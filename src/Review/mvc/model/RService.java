package Review.mvc.model;


import java.util.ArrayList;

import Domain.Review;
import Review.mvc.vo.Listreview;




public class RService {
	private RDAO dao;
	
	private static final RService instance = new RService();
	
	private RService() {
		dao = new RDAO();
	}
	public static RService getInstance() {
		return instance;
	}
	public Review insertS(Review r, int member_no) {
		Review rr = dao.getReview(member_no);
		dao.review_insert(r);
		return r;
		
	}
	public Listreview getListResult(int currentPage, int pageSize) {
		ArrayList<Review> list = dao.list(currentPage, pageSize);
		
		long totalCount = dao.getTotalCount();
		if (list != null) System.out.println("service get");
		System.out.println(totalCount);
		return new Listreview(currentPage, totalCount, pageSize, list);
	}
	public void getReviewS(Review r) {
		dao.review_insert(r);
	}
	public Review getReviewS2(String nick) {
		Review r = dao.getReview(nick);
		return r;
		
	}
	public Review getReview(long seq) {
		return dao.getReview(seq);
	}
}
