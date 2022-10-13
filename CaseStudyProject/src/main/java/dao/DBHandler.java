package dao;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DBHandler {
	public static Connection establishConnection(){
		Connection con=null;
		try {
			FileInputStream fin=new FileInputStream("./src/main/resources/db.properties");
			Properties prop = new Properties();
			prop.load(fin);
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			Class.forName(driver);
			con = DriverManager.getConnection(url,username, password);
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
