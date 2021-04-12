package Login.mvc.model;

class LoginSQL {
		static final String MEMBER = "select * from MEMBER where EMAIL=?";
		static final String INSERT = "insert into MEMBER values(MEMBER_SEQ.nextval, ?, ?, ?, ?, ?, SYSDATE, 0, ?, 'öȸ')";
		final static String FINDID = "select email from MEMBER where NAME= ? and PHONE=?";
		final static String FINDPWD = "select pwd from MEMBER where PHONE=? and EMAIL=?";
		final static String UPDATE1 = "select * from MEMBER where EMAIL=?";
		final static String UPDATE2 = "update MEMBER set pwd=?, name=?, nick=?, phone=?, bdate=? where email=?";
		static final String DEL = "delete from MEMBER where member_no=?";
	}

