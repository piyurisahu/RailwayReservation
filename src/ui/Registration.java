package ui;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;

import controller.ReservationController;
import service.pojo.Schedule;
import ui.dto.DropDown;

public class Registration {

	protected Shell shell;
	private Text customerName;
	private Text ticketPrice;
	private Combo scheduleTime;
	private Combo stationFrom;
	private Combo stationTo;
	private DateTime travelDate;
	private Text systemLabel;
	private Label lblNewLabel;
	private Label lblNewLabel_1;
	private Label lblNewLabel_2;
	private Label lblTicketPrice;
	private Label lblScheduledTime;
	private Label lblTravelDate;
	private Label lblSystemMessage;
	private Button btnSearch;
	private Button btnGetPrice;
	private Button btnBuyTicket;
	private Button btnCancel;
	private ReservationController reservationController;
	private List<Schedule> schedules;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Registration window = new Registration();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		reservationController = new ReservationController();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		initializeWidgets();
		decorateWidgets();
		initializeListeners();
		List<DropDown> dropDownItems = reservationController.getFromStations();
		for (DropDown dropDown : dropDownItems) {
			stationFrom.add(dropDown.getValue());
			stationFrom.setData(dropDown.getValue(), dropDown.getKey());
		}
		btnGetPrice.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});

	}

	private void initializeListeners() {
		stationFrom.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				Combo combo = ((Combo) event.widget);
				List<DropDown> dropDownItems = reservationController
						.getToStations(combo.getData(combo.getText()).toString());
				stationTo.removeAll();
				for (DropDown dropDown : dropDownItems) {
					systemLabel.setText("");
					stationTo.add(dropDown.getValue());
					stationTo.setData(dropDown.getValue(), dropDown.getKey());
				}
				if (dropDownItems.isEmpty())
					systemLabel.setText("No trains found from this station.");
			};
		});
		stationTo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				systemLabel.setText("");
			};
		});
		btnSearch.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				scheduleTime.removeAll();
				schedules = reservationController.getSchedule(stationFrom.getData(stationFrom.getText()).toString(),
						stationTo.getData(stationTo.getText()).toString());
				for (Schedule schedule : schedules) {
					systemLabel.setText("");
					scheduleTime.add(schedule.getScheduledTime());
					scheduleTime.setData(schedule.getScheduledTime(), schedule.getScheduledTime());
				}
				if (schedules.isEmpty())
					systemLabel.setText("No trains found to this station.");
			};
		});

		btnGetPrice.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				ticketPrice.setText("");
				for (Schedule schedule : schedules)
					if (scheduleTime.getText().equals(schedule.getScheduledTime()))
						ticketPrice.setText(String.valueOf(schedule.getTicketPrice()));
			};
		});
		btnBuyTicket.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				Schedule schedule = new Schedule();
				schedule.setScheduledTime(scheduleTime.getData(scheduleTime.getText()).toString());
				schedule.setStationIdFrom(Integer.parseInt(stationFrom.getData(stationFrom.getText()).toString()));
				schedule.setStationIdTo(Integer.parseInt(stationTo.getData(stationTo.getText()).toString()));
				schedule.setTicketPrice(Double.parseDouble(ticketPrice.getText()));
				String date = travelDate.getDay() + "/" + travelDate.getMonth() + "/" + travelDate.getYear();
				if (reservationController.bookTicket(customerName.getText(), schedule, date)) {
					stationTo.removeAll();
					customerName.setText("");
					scheduleTime.removeAll();
					ticketPrice.setText("");
					systemLabel.setText("Ticket Booked successfully.");
				} else
					systemLabel.setText("Something went wrong. Please try again.");
			};
		});
		btnCancel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				stationTo.removeAll();
				customerName.setText("");
				scheduleTime.removeAll();
				ticketPrice.setText("");
				systemLabel.setText("");
			};
		});
	}

	private void decorateWidgets() {
		insertText();
		shell.setSize(426, 300);
		lblNewLabel.setBounds(10, 36, 87, 15);
		lblNewLabel_1.setBounds(10, 73, 77, 15);
		lblNewLabel_2.setBounds(10, 109, 66, 15);
		customerName.setBounds(103, 36, 97, 21);
		ticketPrice.setBounds(311, 36, 77, 21);
		lblTicketPrice.setBounds(215, 36, 66, 15);
		lblScheduledTime.setBounds(215, 73, 90, 15);
		scheduleTime.setBounds(311, 70, 76, 21);
		stationTo.setBounds(103, 106, 97, 23);
		stationFrom.setBounds(103, 70, 97, 23);
		travelDate.setBounds(311, 106, 76, 21);
		lblTravelDate.setBounds(215, 109, 69, 15);
		lblSystemMessage.setBounds(10, 159, 97, 15);
		systemLabel.setBounds(107, 153, 280, 57);
		btnSearch.setBounds(32, 226, 75, 25);
		btnGetPrice.setBounds(123, 226, 75, 25);
		btnBuyTicket.setBounds(206, 226, 75, 25);
		btnCancel.setBounds(304, 226, 75, 25);
	}

	private void insertText() {
		shell.setText("Railway Reservation");
		lblNewLabel.setText("Customer Name");
		lblNewLabel_1.setText("Station(from)");
		lblNewLabel_2.setText("Station (to)");
		lblTicketPrice.setText("Ticket Price");
		lblScheduledTime.setText("Scheduled Time");
		lblTravelDate.setText("Travel Date");
		lblSystemMessage.setText("System Message");
		btnSearch.setText("Search");
		btnGetPrice.setText("Get Price");
		btnBuyTicket.setText("Buy Ticket");
		btnCancel.setText("Cancel");
	}

	private void initializeWidgets() {
		shell = new Shell();
		btnBuyTicket = new Button(shell, SWT.NONE);
		btnGetPrice = new Button(shell, SWT.NONE);
		lblNewLabel = new Label(shell, SWT.NONE);
		btnCancel = new Button(shell, SWT.NONE);
		lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_2 = new Label(shell, SWT.NONE);
		customerName = new Text(shell, SWT.BORDER);
		ticketPrice = new Text(shell, SWT.BORDER);
		lblTicketPrice = new Label(shell, SWT.NONE);
		lblScheduledTime = new Label(shell, SWT.NONE);
		scheduleTime = new Combo(shell, SWT.DROP_DOWN);
		stationTo = new Combo(shell, SWT.DROP_DOWN);
		stationFrom = new Combo(shell, SWT.DROP_DOWN);
		travelDate = new DateTime(shell, SWT.DATE);
		lblTravelDate = new Label(shell, SWT.NONE);
		lblSystemMessage = new Label(shell, SWT.NONE);
		systemLabel = new Text(shell, SWT.BORDER);
		btnSearch = new Button(shell, SWT.NONE);
	}
}
