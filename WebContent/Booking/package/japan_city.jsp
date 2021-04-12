<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    autoFlush="true"
    %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="package.css?ver=1">
</head>
<body>
    <div class="wrapper">
    <form method="get" action="../../booking.do?"/> 
        <div class="title" >
        </div>
        <ul class="package">      
            <li class="package-item" name="pack1_tokyo" style="cursor:pointer">
                   <div class="intro">                            
                        <input type="IMAGE" name="Submit" value="Submit" align="absmiddle" src="../image/city1.jpg">
                        <div class="intro-contents">
                            <h2>도쿄<span>2박3일 700,000원</span></h2>
                        </div>
                   </div>
            </li>
            <li class="package-item" name=pack2_osaka style="cursor:pointer">     
                <div class="intro">
                    <input type="IMAGE" name="Submit" value="Submit" align="absmiddle" src="../image/city2.jpg">
                    <div class="intro-contents">
                        <h2>오사카<span>3박4일 800,000원</span></h2>
                    </div>
                </div>
            </li>
            <li class="package-item" name=pack3_sapporo style="cursor:pointer">     
                <div class="intro">
                    <input type="IMAGE" name="Submit" value="Submit" align="absmiddle" src="../image/city1.jpg">
                    <div class="intro-contents">
                        <h2>삿포로<span>2박3일 800,000원</span></h2>
                    </div>
                </div>
            </li>
        </ul>
    	</form>
    </div>
</body>
</html>