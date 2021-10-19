package net.codejava;

import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlCon { 	 	
	public static JSONArray getPriceInfo(Shops shop) throws Exception {
		String dbUrl = "jdbc:mysql://localhost:3306/Mydb?&serverTimezone=UTC";
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		String username = "root";
		String password = "zjw45ypp";
		String myQuery = "SELECT * from Mydb." + shop.getTableName();
		JSONArray jsonArray = new JSONArray();
		try {
			Class.forName(dbDriver);
			Connection con = DriverManager.getConnection(dbUrl, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(myQuery);
			int collumnCount = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				JSONObject obj = new JSONObject();
				for (int i = 1; i <= collumnCount; i++) {
					Object tempObject = rs.getObject(i);
					obj.put(rs.getMetaData().getColumnLabel(i), tempObject);
				}
				jsonArray.put(obj);
			}
			con.close();
			stmt.close();
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return jsonArray;
	}
}