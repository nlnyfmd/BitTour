<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
autoFlush="true"
isELIgnored="false"
import ='booking.mvc.model.FlightVO'
import ='booking.mvc.model.PayBean'
import ='java.util.ArrayList'
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>BOOKING</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/Booking/flight&hotel/booking.css'/>">
    <link rel="stylesheet"href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css?ver=1"/>	
	<script>
	function calculationtest(){
				passenger = parseInt(test.first.value);
	 			1price = parseInt(test.second.value);
	 			pay.price.value = passenger*1price;
	}
	</script>
</head>
<body>

    <div class="wrapper1">
    	<form name="pay" action="Booking/flight&hotel/BookingResult.jsp" method="post"> 
	        <div class="booking-form-box">	        
	            <h1>항공편</h1>
	            <div class="booking-form">
	           		
	           		<label>출국 공항</label>
	                <select class="custom-select">
		                <c:forEach items="${fList}" var="fv">
							<option>${fv.depAirport}</option>
	        			</c:forEach>
	                </select>
	                
	                <label>입국 공항</label>
	                <select class="custom-select">
	                    <c:forEach items="${fList}" var="fv">
							<option>${fv.ariAirport}</option>
	        			</c:forEach>
	                </select>
	                
	               <!--  <div class ="input-grp"> -->
	                    <label>출국일</label>
		                <select class="custom-select">
		                    <c:forEach items="${fList}" var="fv">
								<option>${fv.depDate}</option>
		        			</c:forEach>
		        		</select>
	                <!-- </div> -->
	
	                <div class ="input-grp">
	                    <label>입국일</label>
	                    <select class="custom-select">
		                    <c:forEach items="${fList}" var="fv">
								<option>${fv.ariDate}</option>
		        			</c:forEach>
	        			</select>
	                </div>
	
	                <div class ="input-grp">
	                    <label>승객 수</label>
	                    <input type="number" class="form-control" name="passenger" id="passenger" onKeyUp=calculationtest(); value="2" min="2" max= "5">
	                </div>
	                
	            </div>
	        </div>
	
	        <div class="booking-form-box">
	            <h1>숙박</h1>
	            <div class="booking-form">
	                <label>호텔</label>
	                <select class="custom-select">
	                    <c:forEach items="${hList}" var="hv">
							<option>${hv.hotelName}</option>
	        			</c:forEach>
	                </select>
	                <label>객실 등급</label>
	                <select class="custom-select">
	                    <option value="1">비즈니스 BUSINESS</option>
	                </select>
	                <div class ="input-grp">
	                    <label>체크인</label>
	                    <select class="custom-select">
		                    <c:forEach items="${hList}" var="hv">
								<option >${hv.checkIn}</option>
		        			</c:forEach>
	              		</select>
	                </div>
	                <div class ="input-grp">
	                    <label>체크아웃</label>
	                    <select class="custom-select">
		                    <c:forEach items="${hList}" var="hv">
								<option >${hv.checkOut}</option>
		        			</c:forEach>
	              		</select>
	                </div>
	                <div class ="input-grp">
	                    <label>이용객 수</label>
	                    <input type="text" class="form-control" value="승객수와 동일" disabled>
	                </div>
	            </div>
	        </div>
	
	        <div class="booking-form-box">
	            <h1>결제</h1>
	            <div class="booking-form">
	                <label>결제 방식</label>
	                <select class="custom-select" id="payMethod" name="payMethod">
	                    <option value="신용카드">신용카드</option>
	                    <option value="체크카드">체크카드</option>
	                    <option value="계좌이체">계좌이체</option>
	                </select>
	                <label>이용 금융기관</label>
	                <select class="custom-select" id="bank" name="bank">
	                    <option value="신한">신한</option>
	                    <option value="우리">우리</option>
	                    <option value="농협">농협</option>
	                    <option value="카카오">카카오</option>
	                    <option value="국민">국민</option>
	                    <option value="우체국">우체국</option>
	                </select>
	                <div class ="input-grp">
	                    <label>총 결제 금액</label>
	                    <input type="number" name="price" id="price" class="form-control select-date" size='10' value="700000">
	                </div>
	                <div class ="input-grp">
	                    <label>결제</label>	             
	                    <input type="submit" class="form-control" value="결제 요청" onClick="location.href='../payment/payResult.jsp' style="cursor:pointer">
	   	            </div>	                
	                <div class ="input-grp2">
	                    <label>뒤로 가기</label>
	                    <input type="text" class="form-control" name="price1" id="price1"  >
	                </div>
	            </div>
	        </div>
		</form> 
    </div>
</body>
</html>