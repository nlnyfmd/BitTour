<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
autoFlush="true"
isELIgnored="false"
import ='booking.mvc.model.FlightVO'
import ='java.util.ArrayList'
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>BOOKING</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/Booking/payment/pay.css'/>">
    <link rel="stylesheet"href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css?ver=1"/>	
</head>
<body> 


    <div class="wrapper1">
    	<form name="pay" method="post">
	        <div class="booking-form-box">
	            <h1>결제요청이 완료됐습니다.</h1>
	            <a href="index.jsp">메인화면으로 돌아가기</a>
	        </div>
		</form>
    </div>
</body>
</html>