package login.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;


public class DBCPUtils {

	private static DataSource dataSource;
    private static Properties properties = new Properties();

	static {

		try {
			String resource = "config/jdbc.properties";
			InputStream is = DBCPUtils.class.getClassLoader()
					.getResourceAsStream(resource);
            //FileInputStream is = new FileInputStream("/jdbc.properties");
            properties.load(is);
		} catch (Exception e) {
			System.out.println("DBCPUtils static method1:" + e.getMessage());
			throw new RuntimeException(e);
		}

		try{
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
		    System.out.println("DBCPUtils static method2:" + e.getMessage());
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
