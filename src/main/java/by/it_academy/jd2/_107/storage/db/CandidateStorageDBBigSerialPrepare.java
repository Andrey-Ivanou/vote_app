package by.it_academy.jd2._107.storage.db;

import by.it_academy.jd2._107.service.CandidateService;
import by.it_academy.jd2._107.storage.api.ICandidateStorage;
import by.it_academy.jd2._107.storage.db.dbutils.DBUtilsVote;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class CandidateStorageDBBigSerialPrepare implements ICandidateStorage {


    private Long counter = 0l;

    private static final String INSERT_QUERY = "INSERT INTO app.artist(\n" +
            "\tname)\n" +
            "\tVALUES (?) RETURNING id;";

    private static final String SELECT_TO_ID_QUERY = "SELECT id, name\n" +
            "\tFROM app.artist\n" +
            "\tWHERE id = ?;";

    private static final String SELECT_ALL_QUERY = "SELECT id, name\n" +
            "\tFROM app.artist;";

    /*private String name = null;*/



    @Override
    public Long create(String name) {
        try (Connection connection = DBUtilsVote.getConnect();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    return resultSet.getLong(1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public String get(Long id) {

        try (Connection connection = DBUtilsVote.getConnect();
             PreparedStatement statement = connection.prepareStatement(SELECT_TO_ID_QUERY);) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    return resultSet.getString("name");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Map<Long, String> get() {
        try (Connection connection = DBUtilsVote.getConnect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);) {

            Map<Long, String> result = new HashMap<>();
            while (resultSet.next()) {
                result.put(resultSet.getLong("id"), resultSet.getString("name"));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
