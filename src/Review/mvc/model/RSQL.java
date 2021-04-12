package Review.mvc.model;

public class RSQL {
	
	final static String PAGE
	= "select * from (select ROWNUM rnum, aa.* from (select * from REVIEW order by article_no desc) aa) where rnum>? and rnum<=?";
	final static String INSERT_REVIEW
    ="insert into review values(REVIEW_SEQ.nextval,?,?,?,?,SYSDATE,?,?)";
	static final String SELECT_COUNT = "select count(*) from REVIEW";	
	static final String GET_REVIEW = "select * from REVIEW where member_no=?";
	static final String CONTENT = 
			"select * from REVIEW where article_no=?";













}
