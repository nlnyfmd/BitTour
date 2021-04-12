<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
   <head>
      <title>BIT Tour </title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <link rel="stylesheet" href="../../css/qna.css">
      <link rel="stylesheet" href="../../css/semantic.min.css">
      <link rel="stylesheet" href="../../css/index.css">
      <link rel="stylesheet" href="../../css/bootstrap.min.css">
      <!-- 위에까지는 템플릿 -->
      <!-- 추가한 부분 (로그인 확인 js)-->
   </head>
   <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300" onload="document.f.id.focus()">
      <div class="container">
         <div class="header">
            <div class="nav">
               <ul>
                <li><button type="button" onclick="location.href='../'">Home</button></li>
                    <li><button type="button" onclick="location.href='tour/login/login.do'">여행후기</button></li>
                    <li><button type="button" onclick="location.href='main.do?m=spain'">문의하기</button></li>
                    <li><button type="button" onclick="location.href='login.do'">로그인</button></li>
               </ul>
            </div>
         </div>
         <div class="site-wrap" >
            <div class="site-section bg-light" >
               <div class="container">
                  <div class="row" >
                     <div class="col-lg-12">
                        <div class="section-title mb-5">
                           <h1>비밀번호를<br>찾으셨나요?</br></h1>
                        </div>
                     </div>
                     <div class="search-div">
                        <form action="login.do?m=findPwd" method="post">
                           <div class="row">
                              <div class="col-md-12 form-group">
                                 <c:if test="${!empty FoundPWD}">
								<h3>비밀번호 찾기 성공</h3><br/><h5>당신의 비밀번호는 <u>' ${FoundPWD} '</u> 입니다.</h5>
								</c:if>
                              </div>
                           </div>
                           <div class="row">
                              <div class="col-md-12 form-group">
                                 <c:if test="${empty FoundPWD}">
								<h3>비밀번호 찾기 실패</h3><br/><h5>비밀번호가 존재하지않습니다.</h5>
								</c:if>
                              </div>
                           </div>
                           <br/> <br/>
                           <div class="col-12">
                              <input type="submit" value="찾기 버튼을 누르세용" class="btn btn-primary py-3 px-5" value='전송'>
                           </div>
                        </form>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </body>
</html>