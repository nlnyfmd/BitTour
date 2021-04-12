package booking.mvc.model;

import java.sql.Date;

public class HotelVO {
	
	private String depAirport;
	private String depFlight;
	private Date depDate;
	private Date ariDate;
	private String ariAirport;
	private String ariFlight;	
	private String hotelNo;      
	private String hotelName;   
	private String hotelType;    
	private int max;          
	private Date checkIn;       
	private Date checkOut;
	
	public HotelVO() {}
	
	public HotelVO(String depAirport, String depFlight, Date depDate, Date ariDate, String ariAirport, String ariFlight,
			String hotelNo, String hotelName, String hotelType, int max, Date checkIn, Date checkOut) {
		this.depAirport = depAirport;
		this.depFlight = depFlight;
		this.depDate = depDate;
		this.ariDate = ariDate;
		this.ariAirport = ariAirport;
		this.ariFlight = ariFlight;
		this.hotelNo = hotelNo;
		this.hotelName = hotelName;
		this.hotelType = hotelType;
		this.max = max;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
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
	public String getHotelNo() {
		return hotelNo;
	}
	public void setHotelNo(String hotelNo) {
		this.hotelNo = hotelNo;
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
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
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
}

