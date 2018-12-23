package Order.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;


public class DBCPUtils {

	public static DataSource dataSource;

	static {

		try {
			String resource = "config/jdbc.properties";
			InputStream is = DBCPUtils.class.getClassLoader()
					.getResourceAsStream(resource);
			Properties properties = new Properties();
			properties.load(is);
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}

	}

	/**
	 * ��ȡ����Դ
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * ��ȡ����
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
