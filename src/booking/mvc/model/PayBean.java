package booking.mvc.model;

import java.sql.Date;

public class PayBean {
	
	private String depAirport;
	private String depFlight;
	private Date depDate;
	private Date ariDate;
	private String ariAirport;
	private String ariFlight;	     
	private String hotelName;   
	private String hotelType;            
	private Date checkIn;       
	private Date checkOut;	
	private String ariCity;
	private int price;
	
	public PayBean(String depAirport, String depFlight, Date depDate, Date ariDate, String ariAirport, String ariFlight,
			String hotelName, String hotelType, Date checkIn, Date checkOut, String ariCity, int price) {
		super();
		this.depAirport = depAirport;
		this.depFlight = depFlight;
		this.depDate = depDate;
		this.ariDate = ariDate;
		this.ariAirport = ariAirport;
		this.ariFlight = ariFlight;
		this.hotelName = hotelName;
		this.hotelType = hotelType;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.ariCity = ariCity;
		this.price = price;
	}

	public String getDepAirport() {
		return depAirport;
	}
	public void setDepAirport(String depAirport) {
		this.depAirport = depAirport;
	}
	public String getDepFlight() {
		return depFlight;
	}
	public void setDepFlight(String depFlight) {
		this.depFlight = depFlight;
	}
	public Date getDepDate() {
		return depDate;
	}
	public void setDepDate(Date depDate) {
		this.depDate = depDate;
	}
	public Date getAriDate() {
		return ariDate;
	}
	public void setAriDate(Date ariDate) {
		this.ariDate = ariDate;
	}
	public String getAriAirport() {
		return ariAirport;
	}
	public void setAriAirport(String ariAirport) {
		this.ariAirport = ariAirport;
	}
	public String getAriFlight() {
		return ariFlight;
	}
	public void setAriFlight(String ariFlight) {
		this.ariFlight = ariFlight;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelType() {
		return hotelType;
	}
	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public String getAriCity() {
		return ariCity;
	}
	public void setAriCity(String ariCity) {
		this.ariCity = ariCity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
	
	