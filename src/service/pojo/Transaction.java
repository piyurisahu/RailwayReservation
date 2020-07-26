package service.pojo;

import java.util.Date;

public class Transaction {
	private int transactionId;
	private String customerName;
	private int stationIdFrom;
	private int stationIdTo;
	private String scheduledTime;
	private double ticketPrice;
	private Date travelDate;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getStationIdFrom() {
		return stationIdFrom;
	}

	public void setStationIdFrom(int stationIdFrom) {
		this.stationIdFrom = stationIdFrom;
	}

	public int getStationIdTo() {
		return stationIdTo;
	}

	public void setStationIdTo(int stationIdTo) {
		this.stationIdTo = stationIdTo;
	}

	public String getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(String scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
}
