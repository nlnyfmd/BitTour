<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="package.css">
</head>
<body>
    <div class="wrapper">
        <div class="title">
            <h1>어디로 떠날까?</h1>
        </div>
        <ul class="package">      
            <li class="package-item" OnClick="location.href ='../package/japan_city.jsp'" style="cursor:pointer";>
                   <div class="intro">                      
                        <img src="../image/city3.jpg">
                        <div class="intro-contents">
                            <h2>일본<span>도쿄,오사카,훗카이도</span></h2>
                            
                        </div>
                   </div>
            </li>
            <li class="package-item" OnClick="location.href ='../package/vietnam_city.jsp'" style="cursor:pointer";>     
                <div class="intro">
                    <img src="../image/city4.jpg">
                    <div class="intro-contents">
                        <h2>베트남<span>하노이, 호치민, 다낭</span></h2>
                    </div>
                </div>
            </li>
            <li class="package-item" OnClick="location.href ='../package/spain_city.jsp'" style="cursor:pointer";>     
                <div class="intro">
                    <img src="../image/city1.jpg">
                    <div class="intro-contents">
                        <h2>스페인<span>바르셀로나, 마드리드, 발렌시아 </span></h2>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</body>
</html>