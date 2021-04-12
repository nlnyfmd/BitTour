<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
autoFlush="true"
isELIgnored="false"
import ='booking.mvc.model.FlightVO'
import ='java.util.ArrayList'
import ='booking.mvc.model.PayBean'
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String ariAirport = (String)request.getParameter("port");
String checkOut= (String)request.getParameter("checkOut");
String hotelName = (String)request.getParameter("hotelName");
String passengerNumber = (String)request.getParameter("passengerNumber");
String payMethod=null;
String bank=null;
String price =request.getParameter("price");
payMethod = request.getParameter("payMethod");
bank = (String)request.getParameter("bank");


request.setCharacterEncoding("utf-8");    
%>

<html>
<head>
    <title>BOOKING</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/Booking/payment/pay.css'/>">
    <link rel="stylesheet"href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css?ver=1"/>	
</head>

<body>
    
    <div id="wrap">
        <br><br>
        <b><font size="5" color="gray">회원가입 정보를 확인하세요.</font></b>
        <br><br>
        <br><br>
        
        <%-- 자바빈에서 입력된 값을 추출한다. --%>
        <table>
            <tr>
                <td id="title">아이디</td>
                <td><%=ariAirport %></td>
                <td><%=checkOut %></td>
                <td><%=hotelName %></td>
                <td><%=passengerNumber %></td>
                <td><%=price %></td>
                <td><%=bank %></td>
                <td><%=payMethod %></td>
            </tr>
        </table>
        
        <br>
        <input type="button" value="확인">
    </div>
</body>
</html>
