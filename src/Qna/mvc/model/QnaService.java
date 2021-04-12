package Qna.mvc.model;

import java.util.List;
import Domain.Qna;
import Qna.mvc.vo.ListResult;

public class QnaService {
	private QnaDAO dao;
	private static final QnaService instance = new QnaService();
	
	private QnaService() {
		dao = new QnaDAO();
	}
	public static QnaService getInstance() {
		return instance;
	}
	public ListResult getListResult(int cp, int ps) {
		List<Qna> list = dao.list(cp, ps);
		long totalCount = dao.getTotalCount();
		ListResult r = new ListResult(cp, totalCount, ps, list);
		return r;
	}
	public Qna getQna(long no) {
		return dao.getQna(no);
	}
	public void DBupdate(Qna qna) {
		dao.DBupdate(qna);
	}
	public void del(long no) {
		dao.del(no);
	}
	public void insertNew(Qna qna) {
		dao.insertNew(qna);
	}
	public long getMemNo(String nick) {
		long memNo = dao.getMemNo(nick);
		return memNo;
	}
	public void insertRe(Qna qna, Long seq) {
		dao.insertRe(qna, seq);
	}
}
