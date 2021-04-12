package Index.mvc.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/index.do")
// �� ��Ʈ�ѷ��� ���ؼ� index.jsp�� ������ �ȴ�. ������ ��Ʈ�ѷ��� ���ϱ�!
public class IndexController extends HttpServlet {
   
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		//�信 �����ĸ� �̾Ƽ� rd��¾ַ� ����.
		rd.forward(request, response);
		//rd�� forward�޼ҵ�� �̵��ϰ� �ȴ�. 
	}
}
