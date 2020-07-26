package service.dto;

import java.util.List;

import service.pojo.Schedule;

public class GetScheduleResponse {
	private List<Schedule> schedules;

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

}
