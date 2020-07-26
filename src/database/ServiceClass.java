package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

public class ServiceClass {
	
	
	public Connection getConnection() {
		 final  String url="jdbc:mysql:\\localhost:3306\test";
		 final String username="root";
		 final   String password="";
		 Connection con = null;
		try {
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public String[] getFromStations() {
		Connection con = getConnection();
		String query = "SELECT Station_Name FROM station_table";
		Statement stmt;
		ArrayList<String> a = new ArrayList<String>();
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String s = rs.getString("Station_Name");
				a.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] result = new String[a.size()];
		result = a.toArray(result);
		
		return result;
		
	}
	
	public String[] getToStations(String name) {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		String query = "SELECT SSELECT Station_ID FROM station_table where Station_Name = '"+name+"'";
		
		Statement stmt;
		ArrayList<String> a = new ArrayList<String>();
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String s = rs.getString("Station_Name");
				a.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] result = new String[a.size()];
		result = a.toArray(result);
		
		return result;
	}

}
