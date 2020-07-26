package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;


//if you run again just comment  create shop query as it is alredy created.s
public class CreateTable {

	public static void main(String[] args) {
		 final  String url="jdbc:mysql:\\localhost:3306\test";
		 final String username="root";
		 final   String password="";
		 
		 
//		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", username,password);
//			Statement stm = con.createStatement();
//			String createTableShop = "CREATE TABLE Schedule_Table " +
//					"(Connection_ID INTEGER, StationID_From INTEGER, StationID_To INTEGER, ScheduledTime VARCHAR(32), TicketPrice DOUBLE PRECISION)";
//			stm.execute(createTableShop);
//			
//			String createTableShop = "CREATE TABLE Station_Table " +
//					"(Station_Table INTEGER, Station_Name VARCHAR(32))";
		 
		 
//		 LTER TABLE schedule_table
//		 ADD FOREIGN KEY (StationID_From) REFERENCES station_table(Station_ID);
		 try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", username,password);
			Statement stm = con.createStatement();
//			String createTableShop = "CREATE TABLE Schedule_Table " +
//					"(Connection_ID INTEGER, StationID_From INTEGER, StationID_To INTEGER, ScheduledTime VARCHAR(32), TicketPrice DOUBLE PRECISION)";
////			stm.execute(createTableShop);
//			stm.execute(createTableShop);
			stm.executeUpdate( "INSERT INTO Station_Table " + "VALUES (1, 2, 1, '11:00 AM', 2223.00 )");
//			stm.executeUpdate( "INSERT INTO Station_Table " + "VALUES (2, 'INDORE')");
//			stm.executeUpdate( "INSERT INTO Station_Table " + "VALUES (3, 'BHOPAL')");
//			stm.executeUpdate( "INSERT INTO Station_Table " + "VALUES (4, 'REEWA')");
//			stm.executeUpdate( "INSERT INTO Station_Table " + "VALUES (5, 'NAGPUR')");
//			stm.executeUpdate( "INSERT INTO Station_Table " + "VALUES (6, 'PUNE')");
//			stm.executeUpdate( "INSERT INTO Station_Table " + "VALUES (7, 'MUMBAI')");
//			stm.executeUpdate( "INSERT INTO Station_Table " + "VALUES (8, 'DELHI')");
//			stm.executeUpdate( "INSERT INTO Station_Table " + "VALUES (9, 'RAIPUR')");
//			stm.executeUpdate( "INSERT INTO Station_Table " + "VALUES (10, 'BANGLORE')");
//			stm.executeUpdate( "INSERT INTO Station_Table " + "VALUES (11, 'GOA')");
//			stm.executeUpdate( "INSERT INTO Station_Table " + "VALUES (1, 'LUCKNOW')");
//			stm.executeUpdate( "INSERT INTO Station_Table " + "VALUES (1, 'JABALPUR')");
//			String query = "Select * from Station_Table";
//			ResultSet rs = stm.executeQuery(query);
//			while(rs.next()) {
//				String s = rs.getString("Station_Name");
//				
//				System.out.println(s);
//			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
