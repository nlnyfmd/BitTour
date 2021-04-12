package Review.mvc.vo;


import java.util.ArrayList;
import java.util.List;
import Domain.Review;


public class Listreview {
	private int currentPage;//����������
	private long totalCount;//��Ż������ ���� �ʿ�
	private int pageSize;//�ʿ�. �׷��� ����
	private List<Review> list;//���带 ��ƿ��� ����Ʈ. �׷��� ��������.
	private long totalPageCount;//�� ������ �� ���.
	
	public Listreview() {}
	
	/*public Listreview(List<Review> list) {
		this.list = list;
	}*/
	public Listreview(int currentPage, long totalCount, int pageSize, List<Review> list) {
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.list = list;
		this.totalPageCount = calTotalPageCount();
	}
	private long calTotalPageCount() {
		long tpc = totalCount/pageSize; 
		if(totalCount%pageSize != 0) tpc++;
		return tpc;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<Review> getList() {
		return list;
	}
	public ArrayList<Review> getList(int cp,int ps) {
		return (ArrayList<Review>) list;
	}
	public void setList(List<Review> list) {
		this.list = list;
	}
	public long getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(long totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
}
