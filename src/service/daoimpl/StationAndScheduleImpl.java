package service.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.dao.StationAndScheduleService;
import service.db.Connection;
import service.dto.GetScheduleRequest;
import service.dto.GetScheduleResponse;
import service.dto.GetStationByScheduleRequest;
import service.dto.GetStationResponse;
import service.pojo.Schedule;
import service.pojo.Station;

public class StationAndScheduleImpl extends Connection implements StationAndScheduleService {

	@Override
	public GetStationResponse getStation() {
		GetStationResponse res = new GetStationResponse();
		String query = "SELECT * FROM station_table";
		try {
			ResultSet rs = executeQuery(query);
			List<Station> stations = new ArrayList<>();
			while (rs.next()) {
				stations.add(new Station(rs.getString("Station_id"), rs.getString("Station_Name")));
			}
			res.setStations(stations);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public GetStationResponse getStationBySchedule(GetStationByScheduleRequest getStationByScheduleRequest) {
		GetStationResponse res = new GetStationResponse();
		String query = "SELECT * FROM station_table WHERE station_id In (SELECT StationID_To FROM schedule_table where StationID_From ="
				+ getStationByScheduleRequest.getStationFromId() + ")";
		try {
			ResultSet rs = executeQuery(query);
			List<Station> stations = new ArrayList<>();
			while (rs.next()) {
				stations.add(new Station(rs.getString("Station_id"), rs.getString("Station_Name")));
			}
			res.setStations(stations);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public GetScheduleResponse getSchedule(GetScheduleRequest getScheduleRequest) {
		GetScheduleResponse res = new GetScheduleResponse();
		String query = "SELECT * FROM schedule_table WHERE StationID_From = " + getScheduleRequest.getStationFromId()
				+ " and StationID_To = " + getScheduleRequest.getStationToId();
		try {
			ResultSet rs = executeQuery(query);
			List<Schedule> schedules = new ArrayList<>();
			while (rs.next()) {
				schedules.add(new Schedule(rs.getInt("Connection_ID"), rs.getInt("StationID_From"),
						rs.getInt("StationID_To"), rs.getString("ScheduledTime"), rs.getDouble("TicketPrice")));
			}
			res.setSchedules(schedules);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}
