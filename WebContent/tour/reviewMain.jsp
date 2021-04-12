<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
   <head>
      <meta charset="UTF-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <title>Bit Tour : 후기쓰기</title>
      <link rel="stylesheet" href="../css/qna.css" />
      <link rel="stylesheet" href="../css/semantic.min.css" />
      <link rel="stylesheet" href="../css/index.css" />
   </head>
   <body>
      <div class="header">
         <div class="nav">
            <ul>
               <li><button type="button" onclick="location.href='../'">Home</button></li>
               <li><button type="button" onclick="location.href='review.do?m=reviewMain'">여행후기</button></li>
               <li><button type="button" onclick="location.href='qna.do?m=content'">문의하기</button></li>
               <li><button type="button" onclick="location.href='login/login.do'">로그인</button></li>
            </ul>
         </div>
      </div>
      <!-- nav끝 -->
      <div class="ui middle aligned center aligned grid">
         <div class="column">
            <h2 class="ui teal image header">
               후기 쓰기
            </h2>
            <br />
            <br />
            <br />
            <br />
            <div class="ui large form">
               <div class="ui stacked segment">
                  <button class="ui fluid large teal sumbit button" onclick="location.href='reviewWrite.jsp'">후기 쓰기</button>
                  <table class="ui celled table">
                     <thead>
                        <tr class="col_name">
                           <th>글번호 </th>
                           <th>회원번호</th>
                           <th>닉네임</th>
                           <th>제목</th>
                           <th>내용</th>
                           <th>작성일</th>
                           <th>조회수</th>
                           <th>좋아요</th>
                        </tr>
                     </thead>
                     <tbody id="list">
                        <c:forEach items="${listreview.list}" var="list">
                           <tr>
                              <td>${list.seq}</td>
                              <td>${list.member_no}</td>
                              <td>${list.nick}</td>
                              <td>${list.subject}</td>
                              <td><a style="font-family: 'S-CoreDream-5Medium'" href="review.do?m=reviewContent&seq=${list.seq}">${list.content}</a></td>
                              <td>${list.rdate}</td>
                              <td>${list.views}</td>
                              <td>${list.rlike}</td>
                           </tr>
                        </c:forEach>
                     </tbody>
                  </table>
                 
                  <c:forEach begin="1" end="${listreview.totalPageCount}" var="i">
                            <a style="font-family: 'S-CoreDream-5Medium'" href="review.do?cp=${i}">
                                <c:choose>
                                    <c:when test="${i==listreview.currentPage}">
                                        <strong>${i}</strong>
                                    </c:when>
                                    <c:otherwise>
                                        ${i}
                                    </c:otherwise>
                                </c:choose>
                            </a>
                            &nbsp;&nbsp;
                        </c:forEach>
                  <div align="right"> ${listreview.currentPage}&nbsp;&nbsp;/&nbsp;&nbsp;${listreview.totalPageCount} </div>
                   ( TOTAL : ${listreview.totalCount} )
               </div>
               
               <div class="ui error message"></div>
            </div>
         </div>
      </div>
      <div class="ui modal" id="view_modal">
         <i class="close">x</i>
         <div class="header" id="b_title"></div>
         <div class="content">
            <div class="description">
               <p style="text-align: right;" id="b_review"></p>
               <div id="b_content"></div>
            </div>
         </div>
         <div class="actions">
            <div class="ui black deny button">닫기</div>
         </div>
      </div>
   </body>
</html>