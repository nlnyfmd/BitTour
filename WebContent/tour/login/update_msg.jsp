<%@page import="Login.mvc.model.LoginCase"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
   if(${rCode} == <%=LoginCase.SIGN_UP%>){
	   alert("💙💚!!회원정보수정 성공하셨습니다🧡💖");
   }else {
	   alert("회원정보수정  실패");
   }
   
   location.href="../../";
</script>