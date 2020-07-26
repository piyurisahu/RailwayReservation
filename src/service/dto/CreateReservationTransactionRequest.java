package service.dto;

import service.pojo.Schedule;

public class CreateReservationTransactionRequest {
	private String customerName;
	private Schedule schedule;
	private String travelDate;

	public CreateReservationTransactionRequest() {
	}

	public CreateReservationTransactionRequest(String customerName, Schedule schedule, String travelDate) {
		this.customerName = customerName;
		this.schedule = schedule;
		this.travelDate = travelDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

}
