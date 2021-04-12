package booking.mvc.model;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class HotelDAO{
	Connection con;
	
    String url = "jdbc:oracle:thin:@127.0.0.1:1521:KLOUD0706";
	String usr = "tour";
	String pwd = "java";
	
	HotelDAO(){		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, usr, pwd);
		}catch(ClassNotFoundException cnfe) {
			System.out.println("드라이버가 클래스패스 걸리지 않았음");
		}catch(SQLException se) {
		}		
	}
		
	public ArrayList<HotelVO> listHotel_tokyo() {
				ArrayList<HotelVO> hList = new ArrayList<HotelVO>();			
				ResultSet rs=null;
				String query="select * from HOTEL where Ari_City= '도쿄'";
				PreparedStatement pstmt = null;
				try {
					pstmt = con.prepareStatement(query);
					rs = pstmt.executeQuery();			
					while(rs.next()){		
							
							String hotelNo = rs.getString("Hotel_No");					
							String hotelName = rs.getString("HOTELNAME");
							String hotelType = rs.getString("HotelType");
							int max = rs.getInt("max");						
							Date checkIn = rs.getDate("checkIn"); 			
							Date checkOut = rs.getDate("checkOut"); 
							HotelVO hv = new HotelVO();										
							hList.add(hv);
							System.out.println(hotelName);
					}
				}catch(SQLException se) {
						System.out.println("list se:"+se);
						return null;
				}finally {
						try {
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							if(con != null) con.close();
						}catch(SQLException se) {}
				}
				return hList;
	}
	
	public ArrayList<HotelVO> listHotel_sapporo() {
		ArrayList<HotelVO> hList = new ArrayList<HotelVO>();			
		ResultSet rs=null;
		String query="select * from HOTEL";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();			
			while(rs.next()){		
					
					String hotelNo = rs.getString("Hotel_No");					
					String hotelName = rs.getString("HOTELNAME");
					String hotelType = rs.getString("HotelType");
					int max = rs.getInt("max");						
					Date checkIn = rs.getDate("checkIn"); 			
					Date checkOut = rs.getDate("checkOut"); 
					HotelVO hv = new HotelVO();										
					hList.add(hv);
					System.out.println(hotelName);
			}
		}catch(SQLException se) {
				System.out.println("list se:"+se);
				return null;
		}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				}catch(SQLException se) {}
		}
		return hList;
}
	
	public ArrayList<HotelVO> listHotel_osaka() {
		ArrayList<HotelVO> hList = new ArrayList<HotelVO>();			
		ResultSet rs=null;
		String query="select * from HOTEL";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();			
			while(rs.next()){		
					
					String hotelNo = rs.getString("Hotel_No");					
					String hotelName = rs.getString("HOTELNAME");
					String hotelType = rs.getString("HotelType");
					int max = rs.getInt("max");						
					Date checkIn = rs.getDate("checkIn"); 			
					Date checkOut = rs.getDate("checkOut"); 
					HotelVO hv = new HotelVO();										
					hList.add(hv);
					System.out.println(hotelName);
			}
		}catch(SQLException se) {
				System.out.println("list se:"+se);
				return null;
		}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				}catch(SQLException se) {}
		}
		return hList;
}
	
	public ArrayList<HotelVO> listHotel_hanoi()  {
		ArrayList<HotelVO> hList = new ArrayList<HotelVO>();			
		ResultSet rs=null;
		String query="select * from HOTEL";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();			
			while(rs.next()){		
					
					String hotelNo = rs.getString("Hotel_No");					
					String hotelName = rs.getString("HOTELNAME");
					String hotelType = rs.getString("HotelType");
					int max = rs.getInt("max");						
					Date checkIn = rs.getDate("checkIn"); 			
					Date checkOut = rs.getDate("checkOut"); 
					HotelVO hv = new HotelVO();										
					hList.add(hv);
					System.out.println(hotelName);
			}
		}catch(SQLException se) {
				System.out.println("list se:"+se);
				return null;
		}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				}catch(SQLException se) {}
		}
		return hList;
}
	
	public ArrayList<HotelVO> listHotel_danang() {
		ArrayList<HotelVO> hList = new ArrayList<HotelVO>();			
		ResultSet rs=null;
		String query="select * from HOTEL";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();			
			while(rs.next()){		
					
					String hotelNo = rs.getString("Hotel_No");					
					String hotelName = rs.getString("HOTELNAME");
					String hotelType = rs.getString("HotelType");
					int max = rs.getInt("max");						
					Date checkIn = rs.getDate("checkIn"); 			
					Date checkOut = rs.getDate("checkOut"); 
					HotelVO hv = new HotelVO();										
					hList.add(hv);
					System.out.println(hotelName);
			}
		}catch(SQLException se) {
				System.out.println("list se:"+se);
				return null;
		}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				}catch(SQLException se) {}
		}
		return hList;
}
	
	public ArrayList<HotelVO> listHotel_hochiminh() {
		ArrayList<HotelVO> hList = new ArrayList<HotelVO>();			
		ResultSet rs=null;
		String query="select * from HOTEL";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();			
			while(rs.next()){		
					
					String hotelNo = rs.getString("Hotel_No");					
					String hotelName = rs.getString("HOTELNAME");
					String hotelType = rs.getString("HotelType");
					int max = rs.getInt("max");						
					Date checkIn = rs.getDate("checkIn"); 			
					Date checkOut = rs.getDate("checkOut"); 
					HotelVO hv = new HotelVO();										
					hList.add(hv);
					System.out.println(hotelName);
			}
		}catch(SQLException se) {
				System.out.println("list se:"+se);
				return null;
		}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				}catch(SQLException se) {}
		}
		return hList;
}
	
	public ArrayList<HotelVO> listHotel_barcelona()  {
		ArrayList<HotelVO> hList = new ArrayList<HotelVO>();			
		ResultSet rs=null;
		String query="select * from HOTEL";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();			
			while(rs.next()){		
					
					String hotelNo = rs.getString("Hotel_No");					
					String hotelName = rs.getString("HOTELNAME");
					String hotelType = rs.getString("HotelType");
					int max = rs.getInt("max");						
					Date checkIn = rs.getDate("checkIn"); 			
					Date checkOut = rs.getDate("checkOut"); 
					HotelVO hv = new HotelVO();										
					hList.add(hv);
					System.out.println(hotelName);
			}
		}catch(SQLException se) {
				System.out.println("list se:"+se);
				return null;
		}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				}catch(SQLException se) {}
		}
		return hList;
}
	
	public ArrayList<HotelVO> listHotel_valencia()  {
		ArrayList<HotelVO> hList = new ArrayList<HotelVO>();			
		ResultSet rs=null;
		String query="select * from HOTEL where Ari_City= '발렌시아'";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();			
			while(rs.next()){		
					
					String hotelNo = rs.getString("Hotel_No");					
					String hotelName = rs.getString("HOTELNAME");
					String hotelType = rs.getString("HotelType");
					int max = rs.getInt("max");						
					Date checkIn = rs.getDate("checkIn"); 			
					Date checkOut = rs.getDate("checkOut"); 
					HotelVO hv = new HotelVO();										
					hList.add(hv);
					System.out.println(hotelName);
			}
		}catch(SQLException se) {
				System.out.println("list se:"+se);
				return null;
		}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				}catch(SQLException se) {}
		}
		return hList;
}
	
	public ArrayList<HotelVO> listHotel_madrid()  {
		ArrayList<HotelVO> hList = new ArrayList<HotelVO>();			
		ResultSet rs=null;
		String query="select * from HOTEL where Ari_City= '마드리드'";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();			
			while(rs.next()){		
					
					String hotelNo = rs.getString("Hotel_No");					
					String hotelName = rs.getString("HOTELNAME");
					String hotelType = rs.getString("HotelType");
					int max = rs.getInt("max");						
					Date checkIn = rs.getDate("checkIn"); 			
					Date checkOut = rs.getDate("checkOut"); 
					HotelVO hv = new HotelVO();										
					hList.add(hv);
					System.out.println(hotelName);
			}
		}catch(SQLException se) {
				System.out.println("list se:"+se);
				return null;
		}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				}catch(SQLException se) {}
		}
		return hList;
}
	
	

}
	

