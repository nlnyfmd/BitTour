package booking.mvc.model;

import java.util.ArrayList;
import booking.mvc.model.FlightVO;
import booking.mvc.model.HotelVO;

import java.io.IOException;
import java.sql.SQLException;

public class BookingService{
	
	private FlightDAO fd;
	private HotelDAO hd;
	private static final BookingService instance = new BookingService();
	private BookingService() {
		fd = new FlightDAO();
		hd = new HotelDAO();
	}
	public static BookingService getInstance() {
		return instance;
	}
	
	public ArrayList<FlightVO> fListS_tokyo() {
		return fd.listFlight_tokyo();
	}
	
	public ArrayList<FlightVO> fListS_sapporo() {
		return fd.listFlight_sapporo();
	}
	
	public ArrayList<FlightVO> fListS_osaka() {
		return fd.listFlight_osaka();
	}
	
	public ArrayList<FlightVO> fListS_hanoi() {
		return fd.listFlight_hanoi();
	}
	
	public ArrayList<FlightVO> fListS_hochiminh() {
		return fd.listFlight_hochiminh();
	}
	
	public ArrayList<FlightVO> fListS_danang() {
		return fd.listFlight_danang();
	}
	
	public ArrayList<FlightVO> fListS_valencia() {
		return fd.listFlight_valencia();
	}
	
	public ArrayList<FlightVO> fListS_madrid() {
		return fd.listFlight_madrid();
	}
	
	public ArrayList<FlightVO> fListS_barcelona() {
		return fd.listFlight_barcelona();
	}
	
	public ArrayList<HotelVO> hlistS_tokyo() {
		return hd.listHotel_tokyo();
	}
	
	public ArrayList<HotelVO> hlistS_osaka() {
		return hd.listHotel_osaka();
	}
	
	public ArrayList<HotelVO> hlistS_sapporo() {
		return hd.listHotel_sapporo();
	}
	
	public ArrayList<HotelVO> hlistS_hanoi() {
		return hd.listHotel_hanoi();
	}
	
	public ArrayList<HotelVO> hlistS_danang() {
		return hd.listHotel_danang();
	}
	
	public ArrayList<HotelVO> hlistS_hochiminh() {
		return hd.listHotel_hochiminh();
	}
	
	public ArrayList<HotelVO> hlistS_valencia() {
		return hd.listHotel_valencia();
	}
	
	public ArrayList<HotelVO> hlistS_barcelona() {
		return hd.listHotel_barcelona();
	}
	
	public ArrayList<HotelVO> hlistS_madrid() {
		return hd.listHotel_madrid();
	}
	
}
