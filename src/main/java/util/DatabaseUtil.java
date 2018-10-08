package util;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import exception.DatabaseException;
import exception.FileException;

public class DatabaseUtil {

	private static BasicDataSource ds;
	private static Properties properties;

	public static Connection getConnection() throws FileException, DatabaseException {
		if (properties == null) {
			properties = PropertyUtil.getPropValues();
		}
		if (ds == null) {
			ds = new BasicDataSource();
			ds.setDriverClassName(properties.getProperty("jdbc.driverName"));
			ds.setUrl(properties.getProperty("jdbc.url"));
			ds.setUsername(properties.getProperty("jdbc.username"));
			ds.setPassword(properties.getProperty("jdbc.password"));
			ds.setMaxIdle(20);
			ds.setMaxConnLifetimeMillis(3000);
			ds.setMaxTotal(100);
			ds.setMaxWaitMillis(3000);
		}
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new DatabaseException("Cannot connect database: " + e.getMessage());
		}
		return conn;
	}
}
