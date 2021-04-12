package booking.mvc.control;

import java.util.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import booking.mvc.model.BookingService;
import booking.mvc.model.FlightVO;
import booking.mvc.model.HotelVO;

@WebServlet("/booking.do")
public class BookingController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		  		String m = request.getParameter("m");
		  		if(m != null) {
					m= m.trim();
					switch(m) {
						case "pack1_tokyo": pack1(request,response);break;
						case "pack2_osaka":	pack2(request,response);break;	
						case "pack3_sapporo": pack3(request,response);break;
						case "pack4_hanoi": pack4(request,response);break;
						case "pack5_hochiminh": pack5(request,response);break;
						case "pack6_danang": pack6(request,response);break;
						case "pack7_valencia": pack7(request,response);break;
						case "pack8_madrid": pack8(request,response);break;
						case "pack9_barcelona": pack9(request,response);break;
						case "pay"  : insertPayResult(request,response); break;
					}
				}
	  	}
	  	
		private void insertPayResult(HttpServletRequest request, HttpServletResponse response) 
		    	throws ServletException, IOException {
		    
			BookingService service = BookingService.getInstance();	    
		    //request.setAttribute("pList", pList);   		    
		    String view = "Booking/payment/pay_result.jsp";
		    RequestDispatcher rd = request.getRequestDispatcher(view); 
		    rd.forward(request, response);
		}
	  	
		private void pack1(HttpServletRequest request, HttpServletResponse response) 
		    	throws ServletException, IOException {
		    
			BookingService service = BookingService.getInstance();
		    
		    ArrayList<HotelVO> hList = service.hlistS_tokyo();
		    ArrayList<FlightVO> fList = service.fListS_tokyo();	    
		    
		    request.setAttribute("hList", hList);  
		    request.setAttribute("fList", fList);  
		    
		    String view = "Booking/flight&hotel/booking.jsp";
		    RequestDispatcher rd = request.getRequestDispatcher(view); 
		    rd.forward(request, response);
		}
		
		private void pack2(HttpServletRequest request, HttpServletResponse response) 
		    	throws ServletException, IOException {
		    
			BookingService service = BookingService.getInstance();
		    
		    ArrayList<HotelVO> hList = service.hlistS_osaka();
		    ArrayList<FlightVO> fList = service.fListS_osaka();
		    
		    request.setAttribute("hList", hList);  
		    request.setAttribute("fList", fList);

		    String view = "Booking/flight&hotel/booking.jsp";
		    RequestDispatcher rd = request.getRequestDispatcher(view); 
		    rd.forward(request, response);
		}
		
		private void pack3(HttpServletRequest request, HttpServletResponse response) 
		    	throws ServletException, IOException{
		    
			BookingService service = BookingService.getInstance();
		    
		    ArrayList<HotelVO> hList = service.hlistS_sapporo();
		    ArrayList<FlightVO> fList = service.fListS_sapporo();
		    
		    request.setAttribute("hList", hList);  
		    request.setAttribute("fList", fList);    
		    
		    String view = "Booking/flight&hotel/booking.jsp";
		    RequestDispatcher rd = request.getRequestDispatcher(view); 
		    rd.forward(request, response);
		}
		
		private void pack4(HttpServletRequest request, HttpServletResponse response) 
		    	throws ServletException, IOException{
		    
			BookingService service = BookingService.getInstance();
		    
		    ArrayList<HotelVO> hList = service.hlistS_hanoi();
		    ArrayList<FlightVO> fList = service.fListS_hanoi();
		    
		    request.setAttribute("hList", hList);  
		    request.setAttribute("fList", fList);    
		    
		    String view = "Booking/flight&hotel/booking.jsp";
		    RequestDispatcher rd = request.getRequestDispatcher(view); 
		    rd.forward(request, response);
		}
		
		private void pack5(HttpServletRequest request, HttpServletResponse response) 
		    	throws ServletException, IOException{
		    
			BookingService service = BookingService.getInstance();
		    
		    ArrayList<HotelVO> hList = service.hlistS_hochiminh();
		    ArrayList<FlightVO> fList = service.fListS_hochiminh();
		    
		    request.setAttribute("hList", hList);  
		    request.setAttribute("fList", fList);    
		    
		    String view = "Booking/flight&hotel/booking.jsp";
		    RequestDispatcher rd = request.getRequestDispatcher(view); 
		    rd.forward(request, response);
		}
		
		private void pack6(HttpServletRequest request, HttpServletResponse response) 
		    	throws ServletException, IOException{
		    
			BookingService service = BookingService.getInstance();
		    
		    ArrayList<HotelVO> hList = service.hlistS_danang();
		    ArrayList<FlightVO> fList = service.fListS_danang();
		    
		    String view = "Booking/flight&hotel/booking.jsp";
		    request.setAttribute("hList", hList);  
		    request.setAttribute("fList", fList);   
		    
		    RequestDispatcher rd = request.getRequestDispatcher(view); 
		    rd.forward(request, response);
		}
		
		private void pack7(HttpServletRequest request, HttpServletResponse response) 
		    	throws ServletException, IOException{
		    
			BookingService service = BookingService.getInstance();
		    
		    ArrayList<HotelVO> hList = service.hlistS_valencia();
		    ArrayList<FlightVO> fList = service.fListS_valencia();
		    
		    String view = "Booking/flight&hotel/booking.jsp";
		    request.setAttribute("hList", hList);  
		    request.setAttribute("fList", fList);  
		    
		    RequestDispatcher rd = request.getRequestDispatcher(view); 
		    rd.forward(request, response);
		}
		
		private void pack8(HttpServletRequest request, HttpServletResponse response) 
		    	throws ServletException, IOException{
		    
			BookingService service = BookingService.getInstance();
		    
		    ArrayList<HotelVO> hList = service.hlistS_madrid();
		    ArrayList<FlightVO> fList = service.fListS_madrid();
		    
		    String view = "Booking/flight&hotel/booking.jsp";
		    request.setAttribute("hList", hList);  
		    request.setAttribute("fList", fList);    
		    
		    RequestDispatcher rd = request.getRequestDispatcher(view); 
		    rd.forward(request, response);
		}
		
		private void pack9(HttpServletRequest request, HttpServletResponse response) 
		    	throws ServletException, IOException{
		    
			BookingService service = BookingService.getInstance();
		    
		    ArrayList<HotelVO> hList = service.hlistS_barcelona();
		    ArrayList<FlightVO> fList = service.fListS_barcelona();
		    
		    request.setAttribute("hList", hList);  
		    request.setAttribute("fList", fList);    
		    
		    String view = "Booking/flight&hotel/booking.jsp";
		    RequestDispatcher rd = request.getRequestDispatcher(view); 
		    rd.forward(request, response);
		}	
		
}
