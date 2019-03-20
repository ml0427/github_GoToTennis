/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.gtt.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import uuu.gtt.entity.VGBException;

public class RDBConnection {

	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/gtt?zeroDateTimeBehavior=convertToNull";
	private static final String userid = "root", password = "1234";

	public static Connection getConnection() throws VGBException {

		try {
			// 載入JDBC Driver
			Class.forName(driver);

			// 建立連線
			try {
				Connection connection = DriverManager.getConnection(url, userid, password);
				return connection;
			} catch (SQLException ex) {
				throw new VGBException("資料庫連線失敗!", ex);
			}
		} catch (ClassNotFoundException ex) {
			throw new VGBException("載入JDBC Driver失敗: " + driver);
		}
	}

	public static void main(String[] args) { // 測試是否連線
		try (Connection connection = getConnection();) {
			System.out.println("已連線的資料庫名稱：" + connection.getCatalog());
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

}
