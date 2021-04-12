package Qna.mvc.model;

import java.sql.*;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import Domain.Qna;
import static Qna.mvc.model.QnaSQL.*;

public class QnaDAO {
	private DataSource ds;
	
	QnaDAO(){
		try {
			Context initContext = new InitialContext();
		    Context envContext  = (Context)initContext.lookup("java:/comp/env");
		    ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {}
	}
	
	ArrayList<Qna> list(int cp, int ps){
		ArrayList<Qna> list = new ArrayList<Qna>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = LIST_PAGE;
		int startRow = (cp-1) * ps;
		int endRow = cp * ps;  
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				long qnaNo = rs.getLong("qna_no");
				long memNo = rs.getLong("member_no");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				Date rdate = rs.getDate("rdate");
				int group = rs.getInt("qgroup");
				int level = rs.getInt("qlevel");
				int order = rs.getInt("qorder");
				String name = rs.getString("nick");
				Qna q = new Qna(qnaNo,memNo,subject,content,rdate,group,level,order,name);
				list.add(q);
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
		return list;
	}
	long getTotalCount() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = COUNT;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				long count = rs.getLong(1);
				return count;
			}else {
				return-1L;
			}
		}catch(SQLException se) {
			System.out.println("getTotal에서 오류 se:"+se);
			return -1L;
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	int getMaxGroup() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = GROUP_MAX;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				int max = rs.getInt(1);
				return max;
			}else {
				return -1;
			}
		}catch(SQLException se) {
			System.out.println("getMaxGroup() se:"+se);
			return -1;
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	void insertNew(Qna qna) {
		int max = getMaxGroup();
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = INSERT;
		if(qna.getContent() != null) {
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setLong(1, qna.getMemno());
				pstmt.setString(2, qna.getSubject());
				pstmt.setString(3, qna.getContent());
				pstmt.setInt(4, max+1);
				pstmt.setInt(5, qna.getLevel());
				pstmt.setInt(6, qna.getOrder());
				pstmt.executeQuery();
			}catch(SQLException se) {
				System.out.println("insert se:"+se);
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				}catch(SQLException se) {}
			}
		}
	}
	void insertRe(Qna qna, Long seq) {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		String sql1 = RE_SELECT;
		String sql2 = RE_UPDATE;
		String sql3 = RE_INSERT;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setLong(1, seq);
			rs = pstmt1.executeQuery();
			while(rs.next()) {
				int group = rs.getInt("qgroup");
				int level = rs.getInt("qlevel");
				int order = rs.getInt("qorder");
				con.setAutoCommit(false);
				pstmt2 = con.prepareStatement(sql2);
				pstmt2.setInt(1, order);
				pstmt2.setInt(2, group);
				pstmt2.executeUpdate();
				pstmt3 = con.prepareStatement(sql3);
				pstmt3.setLong(1, qna.getMemno());
				pstmt3.setString(2, qna.getSubject());
				pstmt3.setString(3, qna.getContent());
				pstmt3.setInt(4, group);
				pstmt3.setInt(5, (level+1));
				pstmt3.setInt(6, (order+1));
				pstmt3.executeUpdate();
				con.commit();
			}
		}catch(SQLException se) {
			try {
				con.rollback();
				System.out.println("insertRE se: "+se);
			}catch(SQLException sse) {}
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt1 != null) pstmt1.close();
				if(pstmt2 != null) pstmt2.close();
				if(pstmt3 != null) pstmt3.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	Qna getQna(long no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = CONTENT;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				long qnaNo = rs.getLong("qna_no");
				long memNo = rs.getLong("member_no");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				Date rdate = rs.getDate("rdate");
				int group = rs.getInt("qgroup");
				int level = rs.getInt("qlevel");
				int order = rs.getInt("qorder");
				String name = rs.getString("NAME");
				Qna b = new Qna(qnaNo,memNo,subject,content,rdate,group,level,order,name);
				return b;
			}else {
				return null;
			}
		}catch(SQLException se) {
			System.out.println("getQna() se: " + se);
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	void DBupdate(Qna qna) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = UPDATE;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qna.getSubject());
			pstmt.setString(2, qna.getContent());
			pstmt.setLong(3, qna.getSeq());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("update se:"+se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	void del(long no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = DEL;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, no);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("delete se:"+se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	long getMemNo(String nick) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = GET_MEM_NO;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nick);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				long memNo = rs.getLong("MEMBER_NO");
				return memNo;
			}
		}catch(SQLException se) {
			System.out.println("getMemNo se:"+se);
			return -1L;
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
		return -1L;
	}
}
	
	