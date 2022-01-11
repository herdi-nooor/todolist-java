package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtil {
    private static HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setUsername("root");
        config.setPassword("password123123");
        config.setJdbcUrl("jdbc:mariadb://localhost/belajar_todolist");

        //pool
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(60*60*1000);

        dataSource = new HikariDataSource(config);
    }
    public static HikariDataSource getDataSource(){
        return dataSource;
    }

}
