package service.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Connection {

	public static java.sql.Connection CONNECTION;

	static {
		try {
			CONNECTION = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet executeQuery(String query) throws SQLException {
		return CONNECTION.createStatement().executeQuery(query);
	}

	public void updateQuery(String query) throws SQLException {
		CONNECTION.createStatement().executeUpdate(query);
	}
}
