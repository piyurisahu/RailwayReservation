package service.dto;

import java.util.List;

import service.pojo.Station;

public class GetStationResponse {
	List<Station> stations;

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

}
