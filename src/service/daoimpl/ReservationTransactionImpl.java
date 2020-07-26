package service.daoimpl;

import java.sql.SQLException;

import service.dao.ReservationTransactionService;
import service.db.Connection;
import service.dto.CreateReservationTransactionRequest;
import service.dto.CreateReservationTransactionResponse;

public class ReservationTransactionImpl extends Connection implements ReservationTransactionService {

	@Override
	public CreateReservationTransactionResponse reserveTicket(CreateReservationTransactionRequest request) {
		CreateReservationTransactionResponse res = new CreateReservationTransactionResponse();
		String query = "INSERT INTO transaction_table (customer_name, StationID_From, StationID_To, ScheduledTime, Ticket_Price, TravelDate) values ('"
				+ request.getCustomerName() + "', " + request.getSchedule().getStationIdFrom() + ","
				+ request.getSchedule().getStationIdTo() + ",'" + request.getSchedule().getScheduledTime() + "',"
				+ request.getSchedule().getTicketPrice() + ",'" + request.getTravelDate() + "')";
		try {
			updateQuery(query);
			res.setSuccess(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}
