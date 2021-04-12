package booking.mvc.model;

import java.sql.Date;

public class FlightVO {
	private String depAirport;
	private String depFlight;
	private Date depDate;
	private Date ariDate;
	private String ariAirport;
	private String ariFlight;
	private String ariCity;
	private int price;

	public FlightVO(String depAirport,String depFlight,
		Date depDate,Date ariDate, String ariAirport,String ariFlight, String ariCity, int price){
		this.depAirport = depAirport;
		this.depFlight = depFlight;
		this.depDate = depDate;
		this.ariDate = ariDate;
		this.ariAirport = ariAirport;
		this.ariFlight = ariFlight;
		this.ariCity = ariCity;
		this.price = price;
		
	}

	public FlightVO(){}

	public String getDepAirport(){
		return depAirport;
	}
	
	public void setDepAirport(String depAirport){
		this.depAirport=depAirport;		
	}

	public String getDepFlight(){
		return depFlight;
	}
	
	public void setDepFlight(String depFlight){
		this.depFlight=depFlight ;
	}
	
	public Date getDepDate(){
		return depDate;
	}
	
	public void setDepDate(Date depDate){
		this.depDate =depDate ;
	}

	public Date getAriDate(){
		return ariDate;
	}
	
	public void setAriDate(Date ariDate){
		this.ariDate = ariDate ;
	}
	
	public String getAriAirport(){
		return ariAirport;
	}
	
	public void setAriAirport(String ariAirport){
		this.ariAirport = ariAirport;		
	}


	public String getAriFlight(){
		return ariFlight;
	}
	
	public void setAriFlight(String ariFlight){
		this.ariFlight=ariFlight ;
	}
	
	public String getAriCity(){
		return ariCity;
	}
	
	public void setAriCity(String ariCity){
		this.ariCity=ariCity ;
	}
	
	public int getPrice(){
		return price;
	}
	
	public void setPrice(int price){
		this.price=price ;
	}
}

