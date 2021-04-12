<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*, Domain.Review, Review.mvc.vo.Listreview"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="toDay_C" value="<%=new java.util.Date()%>" />
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Bit Tour : 후기 쓰기</title>
      <!-- css 가져오기 -->
      <link rel="stylesheet" type="text/css" href="../css/semantic.min.css">
      <link rel="stylesheet" type="text/css" href="../css/qna.css">
      <link rel="stylesheet" type="text/css" href="../css/qnawrite.css">
   </head>
    <body>
      <script>
       if(${empty loginPassUser}){
         	alert("회원 서비스 입니다. 로그인 먼저 해주세요~");
         	location.href="../tour/login/login.do";
         }
      </script>
      <div class="header">
         <div class="nav">
            <ul>
               <li><button type="button" onclick="location.href='../'">Home</button></li>
               <li><button type="button" onclick="location.href='review.do?m=reviewMain'">여행후기</button></li>
               <li><button type="button" onclick="location.href='qna.do?m=list'">문의하기</button></li>
               <c:choose>
                  <c:when test="${empty loginPassUser}">
                     <li><button type="button" onclick="location.href='login/login.do'">로그인</button></li>
                  </c:when>
                  <c:otherwise>
                     <li><button type="button" onclick="location.href='login/login.do?m=logout'">로그아웃</button></li>
                  </c:otherwise>
               </c:choose>
            </ul>
         </div>
      </div>
      <!-- nav끝 -->
      <div class="ui middle aligned center aligned grid">
         <div class="column">
            <h2 id="title_name" class="ui teal image header">
               후기 쓰기
            </h2>
            <form class="ui large form" action="review.do?m=reviewInsert" method="post">
               <div class="ui stacked segment">
                  <div class="two fields">
                  <input type="hidden" name ="member_no" value="${loginPassUser.member_no}"/>
                     <div class="field">
                        <input id="title_post" name ="nick" type="text" value="${loginPassUser.nickname}" placeholder="작성자 : "/>
                     </div>
                    <div class="field">
                        <input id="title_post" type="text" value="${loginPassUser.rdate}" />
                     </div> 
                  </div>
                  <div class="field">
                     <input name="subject" id="title_post" type="text" id="b_title" value="${list.subject}"/>
                  </div>
                  <div class="field" >
                     <div class="ui form">
                        <div class="field">
                           <textarea name="content" id="title_post" rows="25"; />${list.content} </textarea>
                        </div>
                     </div>
                  </div>
                  <!-- 이건 id가 일치할 경우만 뜨게하기. -->
                  <div>
                  <button type="submit" class="ui large teal submit button" style="font-family: 'S-CoreDream-2ExtraLight'">제출하기</button>
                  </div>
                  <!-- 이건 id가 일치할 경우만 뜨게하기. -->
               </div>
               <div class="ui error message"></div>
            </form>
            <!-- 이건 관리자일 경우에만 뜨게하기. -->
            <button id="title_name" type="submit" class="ui large yellow button">답변하기</button>
            <!-- 이건 관리자일 경우에만 뜨게하기. -->
            <button id="title_name" class="ui large yellow button" onclick="location.href='../tour/review.do?m=reviewMain'">뒤로가기</button>
         </div>
      </div>
   </body>
</html>