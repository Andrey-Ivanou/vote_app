package by.it_academy.jd2._107.storage.db;

import by.it_academy.jd2._107.storage.db.dbutils.DBUtilsVote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetVoteResultStorageDB {

    private String artistCount;

    private String genreCount;

    private static final String SELECT_ARIST_COUNT_VOTE = "SELECT name, COUNT(app.vote.id)\n" +
            "\tFROM\n" +
            "\tapp.artist INNER JOIN app.vote\n" +
            "\tON app.artist.id = app.vote.artist_id\n" +
            "\tGROUP BY app.artist.name\n" +
            "\tORDER BY 2;";

    private static final String SELECT_GENRE_COUNT_VOTE = "SELECT app.genre.name, COUNT(app.vote.id)\n" +
            "\tFROM\n" +
            "\tapp.genre INNER JOIN app.cross_vote_genre \n" +
            "\tON app.genre.id = app.cross_vote_genre.genre_id\n" +
            "\tINNER JOIN app.vote ON app.cross_vote_genre.vote_id =\n" +
            "\tapp.vote.id\n" +
            "\tGROUP BY app.genre.id\n" +
            "\tORDER BY 2;";


    public String getArtistResult() {
        String artist;

        try (Connection connection = DBUtilsVote.getConnect();
             PreparedStatement statement = connection.prepareStatement(SELECT_ARIST_COUNT_VOTE);) {
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    artist = resultSet.getString(1);
                    Long count = resultSet.getLong(2);
                    artistCount = "Артист: " + artist + " --- Количество голосов:" + count;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return artistCount;
    }


    public String getGenreResult() {
        try (Connection connection = DBUtilsVote.getConnect();
             PreparedStatement statement = connection.prepareStatement(SELECT_GENRE_COUNT_VOTE);) {
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    String genre = resultSet.getString(1);
                    Long count = resultSet.getLong(2);
                    genreCount = "Жанр: " + genre + " --- Количество голосов:" + count;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return genreCount;
    }
}

