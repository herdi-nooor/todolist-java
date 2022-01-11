package util;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtilTest {

    @Test
    public void testConnection() throws SQLException{
        HikariDataSource dataSource = DatabaseUtil.getDataSource();
        Connection cn = dataSource.getConnection();
        cn.close();
        dataSource.close();
    }
}
