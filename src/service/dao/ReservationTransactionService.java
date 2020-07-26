package service.dao;

import service.dto.CreateReservationTransactionRequest;
import service.dto.CreateReservationTransactionResponse;

public interface ReservationTransactionService {
	public CreateReservationTransactionResponse reserveTicket(CreateReservationTransactionRequest request);
}
