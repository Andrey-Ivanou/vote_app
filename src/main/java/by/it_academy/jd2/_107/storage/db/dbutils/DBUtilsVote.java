package by.it_academy.jd2._107.storage.db.dbutils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtilsVote {

    public static DataSource dataSource;

    static {
        ComboPooledDataSource cpds = new ComboPooledDataSource();

        try {
            cpds.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            throw new RuntimeException("Нет коннекта с базой данных" + e);
        }

        cpds.setJdbcUrl("jdbc:postgresql://localhost:5432/vote");
        cpds.setUser("postgres");
        cpds.setPassword("508an375");

        dataSource = cpds;
    }

    public static Connection getConnect(){
        try {
        Connection connection = dataSource.getConnection();
        return connection;
    } catch (SQLException e) {
        throw new RuntimeException("Ошибка подключения", e);
        }
    }
}
