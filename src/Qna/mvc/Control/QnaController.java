package Qna.mvc.Control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Domain.Qna;
import Qna.mvc.model.QnaService;
import Qna.mvc.vo.ListResult;

@WebServlet("/tour/qna.do")
public class QnaController extends HttpServlet {
	String m = null;
	
	public void service(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		m = request.getParameter("m");
		if(m != null) {
			if(m.equals("list")) list(request, response);
			else if(m.equals("content")) content(request, response); 
			else if(m.equals("update")) update(request, response);
			else if(m.equals("write")) write(request, response);
			else if(m.equals("DBupdate")) DBupdate(request, response);
			else if(m.equals("delete")) delete(request, response);
			else if(m.equals("insert")) insert(request, response);
		    else list(request, response);
		}else list(request, response);
	}

	/* QnA 페이지 리스트 */
	public void list(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		String cpStr = request.getParameter("cp");
		String psStr = request.getParameter("ps");
		HttpSession session = request.getSession();
		int cp = 1;
		int ps = 5;
		if(cpStr == null) {
			Object cpObj = session.getAttribute("cp");
			if(cpObj != null) cp = (Integer)cpObj;
		}else {
			cpStr = cpStr.trim();
			cp = Integer.parseInt(cpStr);
		}
		session.setAttribute("cp", cp);
		if(psStr == null) { 
			Object psObj = session.getAttribute("ps");
			if(psObj != null) ps = (Integer)psObj; 
		}else { 
			psStr = psStr.trim();
			int psParam = Integer.parseInt(psStr);
			Object psObj = session.getAttribute("ps");
			if(psObj != null) { 
				int psSession = (Integer)psObj;
				if(psSession != psParam) { 
					cp = 1;
					session.setAttribute("cp", cp);
				}
			}else {
				if(ps!=psParam) {
					cp = 1; 
					session.setAttribute("cp", cp);
				}
			}
			ps = psParam;
		}
		QnaService service = QnaService.getInstance();
		ListResult listResult = service.getListResult(cp, ps);
		request.setAttribute("listResult", listResult);
		if(listResult.getList().size() == 0 && cp>1) {
			response.sendRedirect("qna.do?m=list&cp="+(cp-1));
		}else {
			String view = "qnaList.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}
	
	/* no 값 확인 */
	public long getNo(HttpServletRequest request) {
		String noStr = request.getParameter("no");
		long no = 0L;
		if(noStr == null) {
			return -1L;
		}else {
			noStr = noStr.trim();
			try {
				no = Integer.parseInt(noStr);
				return no;
			}catch(NumberFormatException ne) {
				return -1L;
			}
		}
	}
	
	/* 해당 no의 데이터 뽑기 -> Content or Update */
	public void content(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		long no = getNo(request);
		if(no != -1L) {
			QnaService service = QnaService.getInstance();
			Qna qna = service.getQna(no);
			request.setAttribute("qna", qna);
			String view = "qnaContent.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}else {
			String view = "qna.do";
			response.sendRedirect(view);
		}
	}
	public void update(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		long no = getNo(request);
		if(no != -1L) {
			QnaService service = QnaService.getInstance();
			Qna qna = service.getQna(no);
			request.setAttribute("qna", qna);
			String view = "qnaUpdate.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}else {
			String view = "qna.do";
			response.sendRedirect(view);
		}
	}
	
	/* 입력 값으로 DB 업데이트 */
	public void DBupdate(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		long no = getNo(request);		
		System.out.println("no : "+no);
		String subject = request.getParameter("subject");
		subject = subject.substring(7);
		String content = request.getParameter("content");
		Qna qna = new Qna(no,-1L,subject,content,null,-1,-1,-1,null);
		QnaService service = QnaService.getInstance();
		service.DBupdate(qna);
		String view = "qna.do";
		response.sendRedirect(view);
	}
	
	/* 입력 폼으로 이동 */
	public void write(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		long no = getNo(request);
		System.out.println("write no :"+no);
		if(no != -1L) {  // 관리자가 insert 할 경우.
			QnaService service = QnaService.getInstance();
			Qna qna = service.getQna(no);
			request.setAttribute("qna", qna);
			String view = "qnaWrite.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}else {
			QnaService service = QnaService.getInstance();
			Qna qna = service.getQna(no);
			request.setAttribute("qna", qna);
			String view = "qnaWrite.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		long no = getNo(request);
		System.out.println("delete no :"+no);
		if(no != -1L) {
			QnaService service = QnaService.getInstance();
			service.del(no);
		}
		String view = "qna.do";
		response.sendRedirect(view);
	}
	public void insert(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		String nickStr = request.getParameter("nick");
		String nick = nickStr.substring(8); 
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		QnaService service = QnaService.getInstance();
		if(nick.equals("관리자")) {
			long memNo = service.getMemNo("admin");
			Qna qna = new Qna(-1L,memNo,subject,content,null,-1,0,0,nick);
			String seqStr = request.getParameter("seq");
			seqStr = seqStr.trim();
			long seq = Long.parseLong(seqStr);
			service.insertRe(qna,seq);
		}else {
			long memNo = service.getMemNo(nick);
			Qna qna = new Qna(-1L,memNo,subject,content,null,-1,0,0,nick);
			service.insertNew(qna);
		}
		String view = "qna.do";
		response.sendRedirect(view);
	}
}
