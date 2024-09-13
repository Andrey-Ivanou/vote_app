package by.it_academy.jd2._107.storage.db;

import by.it_academy.jd2._107.dto.SaveVoteDTO;
import by.it_academy.jd2._107.dto.VoteDTO;
import by.it_academy.jd2._107.storage.api.IVoteStorage;
import by.it_academy.jd2._107.storage.db.dbutils.DBUtilsVote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoteStorageDBBigSerialPrepare implements IVoteStorage {

    private Long voteId;

    private static final String INSERT_QUERY = "INSERT INTO app.vote(\n" +
            "\tcreate_at, artist_id, about)\n" +
            "\tVALUES (?, ?, ?) RETURNING id;";

    private static final String INSERT_VOTE_GENRE = "INSERT INTO app.cross_vote_genre(\n" +
            "\tvote_id, genre_id)\n" +
            "\tVALUES (?, ?);";

    @Override
    public Long create(SaveVoteDTO voteDTO) {
        try (Connection connection = DBUtilsVote.getConnect();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);) {
            statement.setObject(1, voteDTO.getCreateAt());
            statement.setLong(2, (voteDTO.getCandidate()));
            statement.setString(3, voteDTO.getComment());
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    setCrossTable(voteDTO, voteId = resultSet.getLong(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Long setCrossTable(SaveVoteDTO voteDTO, Long voteId) {

        try (Connection connection = DBUtilsVote.getConnect();
             PreparedStatement statement = connection.prepareStatement(INSERT_VOTE_GENRE);) {

            for (int i = 0; i < voteDTO.getGenres().length; i++) {
                statement.setLong(1, voteId);
                statement.setLong(2, Long.parseLong(voteDTO.getGenres()[i]));
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return voteId;
    }

    public Long getVoteId() {
        return voteId;
    }
}
