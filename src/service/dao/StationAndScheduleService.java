package service.dao;

import service.dto.GetScheduleRequest;
import service.dto.GetScheduleResponse;
import service.dto.GetStationByScheduleRequest;
import service.dto.GetStationResponse;

public interface StationAndScheduleService {
	public GetStationResponse getStation();

	public GetStationResponse getStationBySchedule(GetStationByScheduleRequest getStationBySchedule);

	public GetScheduleResponse getSchedule(GetScheduleRequest getScheduleRequest);
}
