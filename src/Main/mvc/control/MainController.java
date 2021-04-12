package Main.mvc.control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/tour/main.do")
public class MainController extends HttpServlet {
   private String m;
   
   protected void service(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
      m = request.getParameter("m");
      if(m != null) {
         switch(m) {
         case "spain": spain(request,response); break;
         case "iceland": iceland(request,response); break;
         case "peru": peru(request,response); break;
         }      
      }else {
         String view = "../";
         response.sendRedirect(view);
      }
   }
   private void spain(HttpServletRequest request, HttpServletResponse response) 
   throws ServletException, IOException {
      System.out.println("스페인");
      String view = "spain.jsp";
      RequestDispatcher rd = request.getRequestDispatcher(view);
      rd.forward(request, response);
   }
   private void iceland(HttpServletRequest request, HttpServletResponse response) 
   throws ServletException, IOException {
      System.out.println("아이슬란드");
      String view = "iceland.jsp";
      RequestDispatcher rd = request.getRequestDispatcher(view);
      rd.forward(request, response);
   }
   private void peru(HttpServletRequest request, HttpServletResponse response) 
   throws ServletException, IOException {
      System.out.println("도쿄");
      String view = "peru.jsp";
      RequestDispatcher rd = request.getRequestDispatcher(view);
      rd.forward(request, response);
   }
}