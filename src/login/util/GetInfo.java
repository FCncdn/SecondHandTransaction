package login.util;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.lang3.StringUtils;

import login.entity.User;
import login.service.UserService;
import login.service.impl.UserServiceImpl;

public class GetInfo {
	public User getUser(String userName) throws SQLException{
			System.out.println("dfsfgdgdghdgh"+userName);
	        //1，得到dataSource对象，
	        DataSource dataSource = DBCPUtils.getDataSource();
	        //2，得到QueryRunner对象
	        QueryRunner queryRunner = new QueryRunner(dataSource);
	        //3，执行查询作sql
	        User user = queryRunner.query("select id,name,age from student where username=?", new BeanHandler<>(User.class), userName);
	        return user;
	}

	
}
