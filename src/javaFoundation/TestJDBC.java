package javaFoundation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @description 学习JDBC源码测试用例
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年9月11日
 */
public class TestJDBC {
	public static void main(String[] args) {
		Connection con;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC";
		String user = "root";
		String password = "zsy1996111";
		try {
			//Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if (!con.isClosed()) {
				System.out.println("\n\t\t成功以 " + user + " 身份连接到数据库！！！");
			}
			Statement statement = con.createStatement();
			String sql = "select * from actor";
			ResultSet res = statement.executeQuery(sql);
			String actorId = null;
			while (res.next()) {
				actorId = res.getString("actor_id");
				System.out.println("查询结果为" + actorId);
			}
//		} catch (ClassNotFoundException e) {
//			System.out.println("I can't find the driver");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("数据库处理完毕");
		}
	}
}
