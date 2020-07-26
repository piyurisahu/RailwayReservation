package service.dto;

public class GetScheduleRequest {
	private String stationFromId;
	private String stationToId;

	public GetScheduleRequest() {
	}

	public GetScheduleRequest(String stationFromId, String stationToId) {
		this.stationFromId = stationFromId;
		this.stationToId = stationToId;
	}

	public String getStationFromId() {
		return stationFromId;
	}

	public void setStationFromId(String stationFromId) {
		this.stationFromId = stationFromId;
	}

	public String getStationToId() {
		return stationToId;
	}

	public void setStationToId(String stationToId) {
		this.stationToId = stationToId;
	}

}
