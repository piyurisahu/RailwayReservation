package service.pojo;

public class Schedule {
	private int connectionId;
	private int stationIdFrom;
	private int stationIdTo;
	private String scheduledTime;
	private double ticketPrice;

	public Schedule() {
	}

	public Schedule(int connectionId, int stationIdFrom, int stationIdTo, String scheduledTime, double ticketPrice) {
		this.connectionId = connectionId;
		this.stationIdFrom = stationIdFrom;
		this.stationIdTo = stationIdTo;
		this.scheduledTime = scheduledTime;
		this.ticketPrice = ticketPrice;
	}

	public int getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(int connectionId) {
		this.connectionId = connectionId;
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

}
