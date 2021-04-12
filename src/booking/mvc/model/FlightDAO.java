package booking.mvc.model;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.InitialContext;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class FlightDAO{
	DataSource ds; 
	
		FlightDAO(){
			try {
				Context initContext = new InitialContext();
			    Context envContext  = (Context)initContext.lookup("java:/comp/env");
			    ds = (DataSource)envContext.lookup("jdbc/myoracle");
			}catch(NamingException ne) {}
		}
		
		public ArrayList<FlightVO> listFlight_tokyo() {
			Connection con = null;
				ArrayList<FlightVO> fList = new ArrayList<FlightVO>();			
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				String query = "select * from Flight where Ari_City = '�룄荑�'";	
				
				try {				
						con=ds.getConnection();
						pstmt = con.prepareStatement(query);
						rs = pstmt.executeQuery();
						while(rs.next()){		
								String depAirport = rs.getString("Dep_Airport");					
								String depFlight = rs.getString("Dep_Flight");
								Date depDate = rs.getDate("Dep_Date");
								Date ariDate = rs.getDate("Ari_Date");
								String ariAirport = rs.getString("Ari_Airport");
								String ariFlight = rs.getString("Ari_Flight");
								int price = rs.getInt("Price");
								FlightVO fv = new FlightVO();
								fv.setDepAirport(depAirport);
								fv.setDepFlight(depFlight);
								fv.setDepDate(depDate);
								fv.setAriDate(ariDate);
								fv.setAriAirport(ariAirport);
								fv.setAriFlight(ariFlight);
								fv.setPrice(price);
								fList.add(fv);	
								System.out.println(depAirport +" , "+ depFlight +" , " + depDate +" , " + ariDate +" , " + ariAirport +" , " + ariFlight+" , " +price);															
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
				return fList;
	}
	
	public ArrayList<FlightVO> listFlight_osaka(){
		Connection con = null;
				ArrayList<FlightVO> fList = new ArrayList<FlightVO>();			
				ResultSet rs=null;
				PreparedStatement pstmt = null;
				String query="select * from Flight where Ari_City = '�삤�궗移�'";
				
				try {
					con = ds.getConnection();
					pstmt = con.prepareStatement(query);
					rs = pstmt.executeQuery();			
					while(rs.next()){					
						String depAirport = rs.getString("Dep_Airport");					
						String depFlight = rs.getString("Dep_Flight");
						Date depDate = rs.getDate("Dep_Date");
						Date ariDate = rs.getDate("Ari_Date");
						String ariAirport = rs.getString("Ari_Airport");
						String ariFlight = rs.getString("Ari_Flight");
						int price = rs.getInt("Price");
						FlightVO fv = new FlightVO();
						fv.setDepAirport(depAirport);
						fv.setDepFlight(depFlight);
						fv.setDepDate(depDate);
						fv.setAriDate(ariDate);
						fv.setAriAirport(ariAirport);
						fv.setAriFlight(ariFlight);
						fv.setPrice(price);
						fList.add(fv);							
						System.out.println(depAirport +" , "+ depFlight +" , " + depDate +" , " + ariDate +" , " + ariAirport +" , " + ariFlight);
					}					
				}catch(SQLException se) {
					se.printStackTrace();
					return null;
				}finally {
					try {
						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();
						if(con != null) con.close();
					}catch(SQLException se) {}
				}
				return fList;
	}

	public ArrayList<FlightVO> listFlight_sapporo(){
		Connection con = null;
		ArrayList<FlightVO> fList = new ArrayList<FlightVO>();			
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query="select * from Flight where Ari_City = '�궭�룷濡�'";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();			
			while(rs.next()){					
				String depAirport = rs.getString("Dep_Airport");					
				String depFlight = rs.getString("Dep_Flight");
				Date depDate = rs.getDate("Dep_Date");
				Date ariDate = rs.getDate("Ari_Date");
				String ariAirport = rs.getString("Ari_Airport");
				String ariFlight = rs.getString("Ari_Flight");
				int price = rs.getInt("Price");
				FlightVO fv = new FlightVO();
				fv.setDepAirport(depAirport);
				fv.setDepFlight(depFlight);
				fv.setDepDate(depDate);
				fv.setAriDate(ariDate);
				fv.setAriAirport(ariAirport);
				fv.setAriFlight(ariFlight);
				fv.setPrice(price);
				fList.add(fv);							
				System.out.println(depAirport +" , "+ depFlight +" , " + depDate +" , " + ariDate +" , " + ariAirport +" , " + ariFlight);
			}					
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
		return fList;
}
	public ArrayList<FlightVO> listFlight_valencia(){
		Connection con = null;
		ArrayList<FlightVO> fList = new ArrayList<FlightVO>();			
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query="select * from Flight where Ari_City = '諛쒕젋�떆�븘'";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();			
			while(rs.next()){					
				String depAirport = rs.getString("Dep_Airport");					
				String depFlight = rs.getString("Dep_Flight");
				Date depDate = rs.getDate("Dep_Date");
				Date ariDate = rs.getDate("Ari_Date");
				String ariAirport = rs.getString("Ari_Airport");
				String ariFlight = rs.getString("Ari_Flight");
				int price = rs.getInt("Price");
				FlightVO fv = new FlightVO();
				fv.setDepAirport(depAirport);
				fv.setDepFlight(depFlight);
				fv.setDepDate(depDate);
				fv.setAriDate(ariDate);
				fv.setAriAirport(ariAirport);
				fv.setAriFlight(ariFlight);
				fv.setPrice(price);
				fList.add(fv);							
				System.out.println(depAirport +" , "+ depFlight +" , " + depDate +" , " + ariDate +" , " + ariAirport +" , " + ariFlight);
			}					
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
		return fList;
}
	public ArrayList<FlightVO> listFlight_madrid(){
		Connection con = null;
		ArrayList<FlightVO> fList = new ArrayList<FlightVO>();			
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query="select * from Flight where Ari_City = '留덈뱶由щ뱶'";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();			
			while(rs.next()){					
				String depAirport = rs.getString("Dep_Airport");					
				String depFlight = rs.getString("Dep_Flight");
				Date depDate = rs.getDate("Dep_Date");
				Date ariDate = rs.getDate("Ari_Date");
				String ariAirport = rs.getString("Ari_Airport");
				String ariFlight = rs.getString("Ari_Flight");
				int price = rs.getInt("Price");
				FlightVO fv = new FlightVO();
				fv.setDepAirport(depAirport);
				fv.setDepFlight(depFlight);
				fv.setDepDate(depDate);
				fv.setAriDate(ariDate);
				fv.setAriAirport(ariAirport);
				fv.setAriFlight(ariFlight);
				fv.setPrice(price);
				fList.add(fv);							
				System.out.println(depAirport +" , "+ depFlight +" , " + depDate +" , " + ariDate +" , " + ariAirport +" , " + ariFlight);
			}					
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
		return fList;
}
	public ArrayList<FlightVO> listFlight_barcelona(){
		Connection con = null;
		ArrayList<FlightVO> fList = new ArrayList<FlightVO>();			
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query="select * from Flight where Ari_City = '諛붾Ⅴ��濡쒕굹'";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();			
			while(rs.next()){					
				String depAirport = rs.getString("Dep_Airport");					
				String depFlight = rs.getString("Dep_Flight");
				Date depDate = rs.getDate("Dep_Date");
				Date ariDate = rs.getDate("Ari_Date");
				String ariAirport = rs.getString("Ari_Airport");
				String ariFlight = rs.getString("Ari_Flight");
				int price = rs.getInt("Price");
				FlightVO fv = new FlightVO();
				fv.setDepAirport(depAirport);
				fv.setDepFlight(depFlight);
				fv.setDepDate(depDate);
				fv.setAriDate(ariDate);
				fv.setAriAirport(ariAirport);
				fv.setAriFlight(ariFlight);
				fv.setPrice(price);
				fList.add(fv);							
				System.out.println(depAirport +" , "+ depFlight +" , " + depDate +" , " + ariDate +" , " + ariAirport +" , " + ariFlight);
			}					
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
		return fList;
}
	public ArrayList<FlightVO> listFlight_hanoi(){
		Connection con = null;
		ArrayList<FlightVO> fList = new ArrayList<FlightVO>();			
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query="select * from Flight where Ari_City = '�븯�끂�씠'";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();			
			while(rs.next()){					
				String depAirport = rs.getString("Dep_Airport");					
				String depFlight = rs.getString("Dep_Flight");
				Date depDate = rs.getDate("Dep_Date");
				Date ariDate = rs.getDate("Ari_Date");
				String ariAirport = rs.getString("Ari_Airport");
				String ariFlight = rs.getString("Ari_Flight");
				int price = rs.getInt("Price");
				FlightVO fv = new FlightVO();
				fv.setDepAirport(depAirport);
				fv.setDepFlight(depFlight);
				fv.setDepDate(depDate);
				fv.setAriDate(ariDate);
				fv.setAriAirport(ariAirport);
				fv.setAriFlight(ariFlight);
				fv.setPrice(price);
				fList.add(fv);							
				System.out.println(depAirport +" , "+ depFlight +" , " + depDate +" , " + ariDate +" , " + ariAirport +" , " + ariFlight);
			}					
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
		return fList;
}
	public ArrayList<FlightVO> listFlight_hochiminh(){
		Connection con = null;
		ArrayList<FlightVO> fList = new ArrayList<FlightVO>();			
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query="select * from Flight where Ari_City = '�샇移섎��'";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();			
			while(rs.next()){					
				String depAirport = rs.getString("Dep_Airport");					
				String depFlight = rs.getString("Dep_Flight");
				Date depDate = rs.getDate("Dep_Date");
				Date ariDate = rs.getDate("Ari_Date");
				String ariAirport = rs.getString("Ari_Airport");
				String ariFlight = rs.getString("Ari_Flight");
				int price = rs.getInt("Price");
				FlightVO fv = new FlightVO();
				fv.setDepAirport(depAirport);
				fv.setDepFlight(depFlight);
				fv.setDepDate(depDate);
				fv.setAriDate(ariDate);
				fv.setAriAirport(ariAirport);
				fv.setAriFlight(ariFlight);
				fv.setPrice(price);
				fList.add(fv);							
				System.out.println(depAirport +" , "+ depFlight +" , " + depDate +" , " + ariDate +" , " + ariAirport +" , " + ariFlight);
			}					
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
		return fList;
}
	public ArrayList<FlightVO> listFlight_danang(){
		Connection con = null;
		ArrayList<FlightVO> fList = new ArrayList<FlightVO>();			
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query="select * from Flight where Ari_City = '�떎�궘'";
		
		try {
			con = ds.getConnection()
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();			
			while(rs.next()){					
				String depAirport = rs.getString("Dep_Airport");					
				String depFlight = rs.getString("Dep_Flight");
				Date depDate = rs.getDate("Dep_Date");
				Date ariDate = rs.getDate("Ari_Date");
				String ariAirport = rs.getString("Ari_Airport");
				String ariFlight = rs.getString("Ari_Flight");
				int price = rs.getInt("Price");
				FlightVO fv = new FlightVO();
				fv.setDepAirport(depAirport);
				fv.setDepFlight(depFlight);
				fv.setDepDate(depDate);
				fv.setAriDate(ariDate);
				fv.setAriAirport(ariAirport);
				fv.setAriFlight(ariFlight);
				fv.setPrice(price);
				fList.add(fv);							
				System.out.println(depAirport +" , "+ depFlight +" , " + depDate +" , " + ariDate +" , " + ariAirport +" , " + ariFlight);
			}					
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
		return fList;
}
	
}
	
	