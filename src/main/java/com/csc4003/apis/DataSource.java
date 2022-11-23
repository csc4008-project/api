package com.csc4003.apis;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * This class is for the configuration of HikariCP. The connection details must be taken from environment variables,
 * these are JdbcUrl, Username and Password.
 */
@Configuration
public class DataSource {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl(System.getenv("JDBC_URL"));
        config.setUsername(System.getenv("JDBC_USER"));
        config.setPassword(System.getenv("JDBC_PASSWORD"));
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
    }

    private DataSource() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
