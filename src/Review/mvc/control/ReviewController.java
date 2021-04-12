package Review.mvc.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Domain.Member;
import Domain.Review;
import Review.mvc.model.RService;  
import Review.mvc.vo.Listreview;



@WebServlet("/tour/review.do")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String m = null;
	
	public void service(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		m = request.getParameter("m");
		System.out.println("m:"+m);
		if(m != null) {
			if(m.equals("reviewMain")) reviewMain(request, response);
			else if(m.equals("reviewList")) reviewList(request, response);
			else if(m.equals("reviewWrite")) reviewWrite(request, response);
			else if(m.equals("reviewContent")) reviewContent(request, response);
			else if(m.equals("reviewInsert")) reviewWrite(request, response);
			else if(m.equals("reviewContent")) reviewContent(request, response);
			else reviewMain(request, response);
			}else reviewMain(request, response);
		}

	private void reviewMain(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String cpStr = request.getParameter("cp");
		String psStr = request.getParameter("ps");
		HttpSession session = request.getSession();
		
		Object user = session.getAttribute("loginPassUser"); //
		Member mem = (Member)user;
		
		System.out.println("mem.no : "+mem.getMember_no());
		//(1) cp //메인에서 바로 인서트되게 해놧어
				int cp = 1; //int 타입의 현재 페이지 
				System.out.println("내가 현재페이지");
				if(cpStr == null) { //만약 널값이면
					Object cpObj = session.getAttribute("cp"); //
					if(cpObj != null) {
						cp = (Integer)cpObj;
					}
				}else {
					cpStr = cpStr.trim();
					cp = Integer.parseInt(cpStr);
					System.out.println("cpStr널임: "+ cp);
				}
				session.setAttribute("cp", cp);
				System.out.println("if문 밖5");
				//(2) ps 
				int ps = 5;
				if(psStr == null) {
					Object psObj = session.getAttribute("ps");
					if(psObj != null) {
						ps = (Integer)psObj;
					}
				}else {
					psStr = psStr.trim();
					int psParam = Integer.parseInt(psStr);
					
					Object psObj = session.getAttribute("ps");//페이지사이즈
					if(psObj != null) {
						int psSession = (Integer)psObj;
						if(psSession != psParam) {
							cp = 1;
							session.setAttribute("cp", cp);
						}
					}else {
						if(ps != psParam) {
							cp = 1;
							session.setAttribute("cp", cp);
						}
					}
					
					ps = psParam;
				}
				session.setAttribute("ps", ps);
				/*session.setAttribute("nick", nick);
				System.out.println("cpps:"+cp+ps+nick);*/
				
				RService service = RService.getInstance();
				Listreview listreview = service.getListResult(cp, ps);		
				request.setAttribute("listreview", listreview);
				
				if(listreview.getList(cp, ps).size() == 0 && cp>=1) {
					response.sendRedirect("review.do?m=reviewMain&cp="+(cp-1));
				}else {
					String view = "reviewMain.jsp";
					RequestDispatcher rd = request.getRequestDispatcher(view);
					rd.forward(request, response);
				}
		    }
				
		
	private int getSeq(HttpServletRequest request) {
		String seqStr = request.getParameter("seq");
		int seq = 1;
		if(seqStr ==null) {
			return 1;
		}else {
			seqStr = seqStr.trim();
			try {
				seq = Integer.parseInt(seqStr);
				return seq;
			}catch(NumberFormatException ne) {
				return 1;
			}
		}
	}
	private void reviewList(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("뒤로가기 눌렀음");
		String view = "reviewList.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	/* 해당 seq의 데이터 뽑기 -> Content or Update */
	private void reviewWrite(HttpServletRequest request, HttpServletResponse response)    //  답변누르면 content가는걸로 수정해야함 jsp 폼도 다시 만들어야함 qna참고할것 
			throws ServletException, IOException {
		HttpSession session = request.getSession();//생성
		int member_no = -1;
    	String member_noStr = request.getParameter("member_no");
    	if(member_noStr != null){
    		member_noStr = member_noStr.trim();
    		if(member_noStr.length() != 0){
    			try{
    				member_no = Integer.parseInt(member_noStr);
    				//RService service = RService.getInstance();
    			}catch(NumberFormatException ne){
    			}
    		}
    	}
		String nick = request.getParameter("nick");
		System.out.println(nick);
    	//String nick = (String)session.getAttribute("nick");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		
		if(nick ==null || nick.length()==0) {
			nick ="닉네임없음";
		}
		if(subject ==null || subject.length()==0) {
			subject ="제목 없음";
		}
		if(content ==null || content.length()==0) {
			content ="콘텐츠 없음";
		}
		if(member_no ==-1) {
			member_no =-1;
		}
		Review r = new Review(-1, member_no, nick, subject, content, null, 1, 1 );
		System.out.println("##"+member_no+nick+subject+content);
		RService service = RService.getInstance();
		
		service.getReviewS(r);
		System.out.println("수행완료 리뷰인서트");
		String view = "review.do?m=reviewMain";
		response.sendRedirect(view);
		
	}
		
	private void reviewContent(HttpServletRequest request, HttpServletResponse response)    //  답변누르면 content가는걸로 수정해야함 jsp 폼도 다시 만들어야함 qna참고할것 
			throws ServletException, IOException {
		int seq = getSeq(request);
		String seqStr = request.getParameter("seq");
		System.out.println("reviewContent seq: "+seq);
		if(seqStr !=null) {
			seqStr = seqStr.trim();
			if(seqStr.length() !=0) {
				try {
					seq = Integer.parseInt(seqStr);
					RService service = RService.getInstance();
					Review r = service.getReview(seq);
					request.setAttribute("r", r);
				}catch(NumberFormatException ne) {
				}
			}
		}
		String view = "reviewContent.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		/*long seq = getSeq(request);
		if(seq != -1L) {
			RService service = RService.getInstance();
			Review r = service.getReview(seq);
			request.setAttribute("Review", r);
			String view = "reviewContent.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}else {
			String view = "review.do?m=reviewMain";
			response.sendRedirect(view);
		}*/
	}
	private void reviewInsert(HttpServletRequest request, HttpServletResponse response)    //  답변누르면 content가는걸로 수정해야함 jsp 폼도 다시 만들어야함 qna참고할것 
			throws ServletException, IOException {
		int member_no = -1;
    	String member_noStr = request.getParameter("member_no");
    	if(member_noStr != null){
    		member_noStr = member_noStr.trim();
    		if(member_noStr.length() != 0){
    			try{
    				member_no = Integer.parseInt(member_noStr);
    				RService service = RService.getInstance();
    			}catch(NumberFormatException ne){
    			}
    		}
    	}
		String nick = request.getParameter("nick");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		System.out.println("######"+nick);
		if(nick ==null || nick.length()==0) {
			nick ="닉네임없음";
		}
		if(subject ==null || subject.length()==0) {
			subject ="제목 없음";
		}
		if(content ==null || content.length()==0) {
			content ="콘텐츠 없음";
		}
		Review r = new Review(-1, member_no, nick, subject, content, null, -1, -1 );
		System.out.println(nick+subject+content);
		RService service = RService.getInstance();
		Review rCode = service.getReviewS2(nick);
		HttpSession session = request.getSession();
		session.setAttribute("reviewInsert", rCode);
		System.out.println(rCode);
		
		String view = "review.do?m=reviewMain";
		response.sendRedirect(view);
		}
	}