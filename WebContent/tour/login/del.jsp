<%@page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    boolean flag = (Boolean)request.getAttribute("flag");
%>
<script language="javascript">
    if(<%=flag%>){
    	alert("삭제 성공");
    }else {
    	alert("삭제 실패");
    }
    
    location.href="login.do";
</script>