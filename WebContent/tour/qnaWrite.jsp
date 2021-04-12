<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="toDay_C" value="<%=new java.util.Date()%>" />

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Bit Tour : 문의하기</title>
        <!-- css 가져오기 -->
        <link rel="stylesheet" type="text/css" href="../css/semantic.min.css" />
        <link rel="stylesheet" type="text/css" href="../css/qna.css" />
        <link rel="stylesheet" type="text/css" href="../css/qnawrite.css" />
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
                    <li><button type="button" onclick="location.href='tour/login/login.do'">여행후기</button></li>
                    <li><button type="button" onclick="location.href='#'">문의하기</button></li>
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
        <div class="ui middle aligned center aligned grid" style="70%">
            <div class="column">
                <c:choose>
                    <c:when test="${loginPassUser.nickname eq 'admin'}">
                        <form class="ui large form" action="qna.do?m=insert&seq=${qna.seq}" method="post">
                            <div class="ui stacked segment">
                                <div class="ui card" style="display: flex; margin: auto;">
                                    <div class="content">
                                        <div class="header">${qna.name}</div>
                                        <div class="description">
                                            <p>${qna.content}</p>
                                        </div>
                                    </div>
                                </div>
                                <br />
                                <div class="two fields">
                                    <div class="field">
                                        <input style="font-family: 'S-CoreDream-5Medium';" id="title_post" name="nick" type="text" value="작성자 :   관리자" readonly />
                                    </div>
                                    <div class="field"><input style="font-family: 'S-CoreDream-5Medium'" id="title_post" type="text" value="작성일 : <fmt:formatDate value="${toDay_C}" pattern="yyyy-MM-dd" />" readonly/></div>
                                </div>
                                <div class="field">
                                    <input style="font-family: 'S-CoreDream-5Medium';" type="text" name="subject" placeholder="게시글 제목" value="답변드립니다." readonly />
                                </div>
                                <div class="field">
                                    <div class="ui left icon input">
                                        <textarea style="font-family: 'S-CoreDream-5Medium';" name="content" placeholder="게시글 내용" rows="20" autofocus="autofocus"></textarea>
                                    </div>
                                </div>

                                <button type="submit" class="ui fluid large teal submit button" style="font-family: 'S-CoreDream-2ExtraLight';">답변하기</button>
                            </div>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form class="ui large form" action="qna.do?m=insert" method="post">
                            <div class="ui stacked segment">
                                <div class="two fields">
                                    <div class="field">
                                        <input style="font-family: 'S-CoreDream-5Medium';" id="title_post" name="nick" type="text" value="작성자 :   ${loginPassUser.nickname}" readonly />
                                    </div>
                                    <div class="field"><input style="font-family: 'S-CoreDream-5Medium'" id="title_post" type="text" value="작성일 : <fmt:formatDate value="${toDay_C}" pattern="yyyy-MM-dd" />" readonly/></div>
                                </div>
                                <div class="field">
                                    <input style="font-family: 'S-CoreDream-5Medium';" type="text" name="subject" placeholder="게시글 제목" autofocus="autofocus" />
                                </div>
                                <div class="field">
                                    <div class="ui left icon input">
                                        <textarea style="font-family: 'S-CoreDream-5Medium';" name="content" placeholder="게시글 내용" rows="20"></textarea>
                                    </div>
                                </div>
                                <button type="submit" class="ui fluid large teal submit button" style="font-family: 'S-CoreDream-2ExtraLight'">문의하기</button>
                            </div>
                        </form>
                    </c:otherwise>
                </c:choose>

                <a href="qna.do?m=list"><button style="font-family: 'S-CoreDream-2ExtraLight';" class="ui fluid large teal submit button">뒤로가기</button></a>
            </div>
        </div>
    </body>
</html>