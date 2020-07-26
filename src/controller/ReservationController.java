package controller;

import java.util.ArrayList;
import java.util.List;

import service.dao.ReservationTransactionService;
import service.dao.StationAndScheduleService;
import service.daoimpl.ReservationTransactionImpl;
import service.daoimpl.StationAndScheduleImpl;
import service.dto.CreateReservationTransactionRequest;
import service.dto.CreateReservationTransactionResponse;
import service.dto.GetScheduleRequest;
import service.dto.GetScheduleResponse;
import service.dto.GetStationByScheduleRequest;
import service.dto.GetStationResponse;
import service.pojo.Schedule;
import service.pojo.Station;
import ui.dto.DropDown;

public class ReservationController {

	private StationAndScheduleService stationAndScheduleService;
	private ReservationTransactionService reservationTransactionService;

	public ReservationController() {
		this.stationAndScheduleService = new StationAndScheduleImpl();
		this.reservationTransactionService = new ReservationTransactionImpl();
	}

	public List<DropDown> getFromStations() {

		GetStationResponse res = stationAndScheduleService.getStation();
		List<DropDown> list = new ArrayList<>();
		for (Station station : res.getStations()) {
			list.add(new DropDown(station.getStationId(), station.getStationName()));
		}
		return list;

	}

	public List<DropDown> getToStations(String id) {
		GetStationByScheduleRequest request = new GetStationByScheduleRequest();
		request.setStationFromId(id);
		GetStationResponse res = stationAndScheduleService.getStationBySchedule(request);
		List<DropDown> list = new ArrayList<>();
		for (Station station : res.getStations()) {
			list.add(new DropDown(station.getStationId(), station.getStationName()));
		}
		return list;
	}

	public List<Schedule> getSchedule(String stationFromId, String stationToId) {
		GetScheduleRequest request = new GetScheduleRequest(stationFromId, stationToId);
		GetScheduleResponse res = stationAndScheduleService.getSchedule(request);
		return res.getSchedules();
	}

	public boolean bookTicket(String customerName, Schedule schedule, String travelDate) {
		CreateReservationTransactionRequest request = new CreateReservationTransactionRequest(customerName, schedule,
				travelDate);
		CreateReservationTransactionResponse res = reservationTransactionService.reserveTicket(request);
		return res.isSuccess();
	}
}
