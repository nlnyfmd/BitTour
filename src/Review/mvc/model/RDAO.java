package Review.mvc.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import Domain.Review;

import static Review.mvc.model.RSQL.*;


public class RDAO {
	private DataSource ds;
	
	RDAO(){
		try {
			Context initContext = new InitialContext();
		    Context envContext  = (Context)initContext.lookup("java:/comp/env");
		    ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {}
	}
	//////////////////////////////////////////////////////////////////
	
	ArrayList<Review> list(int currentPage, int pageSize){
		ArrayList<Review> list = new ArrayList<Review>();
		Connection con = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = PAGE;
		int startRow = (currentPage-1)*pageSize;
		int endRow = currentPage*pageSize; 
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);	
			rs = pstmt.executeQuery();
			while(rs.next()) {
				long article_no = rs.getLong("article_no");
				long member_no = rs.getLong("member_no");
				String nick = rs.getString("nick");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				Date rdate = rs.getDate("rdate");
				long views = rs.getLong("views");
				long rlike = rs.getLong("rlike");				
				Review r = new Review(article_no, member_no, nick, subject, content, rdate,
						views, rlike);
				list.add(r);
				System.out.println(article_no+member_no+nick+subject+content+rdate+views+rlike);
			}
			return list;
		}catch(SQLException se) {
			System.out.println("SQLException : "+se);
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	long getTotalCount() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = SELECT_COUNT;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				int count = rs.getInt(1);
				return count;
			}else {
				return -1;
			}
		}catch(SQLException se) {
			return -1;
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	void review_insert(Review r) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = INSERT_REVIEW;
		System.out.println("insert");
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);	
			pstmt.setLong(1, r.getMember_no());
			System.out.println(r.getMember_no());
			pstmt.setString(2, r.getNick());
			pstmt.setString(3, r.getSubject());
			pstmt.setString(4, r.getContent());
			pstmt.setLong(5, r.getViews());
			pstmt.setLong(6, r.getRlike());
			pstmt.executeUpdate();
			System.out.println("#"+r.getNick());
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){
			}
		}
	}
	Review getReview(long seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = CONTENT;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				long article_no =rs.getLong("article_no");
				long member_no = rs.getLong("member_no");
				String nick = rs.getString("nick");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				Date rdate = rs.getDate("rdate");
				long views = rs.getLong("views");
				long rlike = rs.getLong("rlike");				
				Review rr = new Review(article_no,member_no, nick,subject,content,rdate,views,rlike);
				return rr;
			}else {
				return null;
			}
		}catch(SQLException se) {
			System.out.println("getReview()1 se: " + se);
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	Review getReview(String nick) {
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		String sql = GET_REVIEW;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nick);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				long article_no =rs.getLong("article_no");
				long member_no = rs.getLong("member_no");
				//String nick = rs.getString("nick");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				long views = rs.getLong("views");
				long rlike = rs.getLong("rlike");
				Review rr = new Review(article_no,member_no, nick,subject,content,null, views,rlike);
				return rr;
			}
			
		}catch(SQLException se) {
			System.out.println("getReview()2 se: " + se);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
		return null;
	}
}
	