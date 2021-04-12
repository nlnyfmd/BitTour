<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*, Domain.Qna, Qna.mvc.vo.ListResult"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Bit Tour : 문의내역</title>
        <!-- css 가져오기 -->
        <link rel="stylesheet" type="text/css" href="../css/semantic.min.css" />
        <link rel="stylesheet" type="text/css" href="../css/qna.css" />
        <link rel="stylesheet" type="text/css" href="../css/qnawrite.css" />
    </head>

    <body>
        <div class="header">
            <div class="nav">
                <ul>
                    <li><button type="button" onclick="location.href='../'">Home</button></li>
                    <li><button type="button" onclick="location.href='tour/login/login.do'">여행후기</button></li>
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
                    문의 수정
                </h2>
                <form class="ui large form" action="qna.do?m=DBupdate&no=${qna.seq}" method="post">
                    <div class="ui stacked segment">
                        <div class="two fields">
                            <div class="field">
                                <input id="title_post" type="text" value="작성자 :   ${qna.name}" disabled />
                            </div>
                            <div class="field">
                                <input id="title_post" type="text" value="작성일 :   ${qna.rdate}" disabled />
                            </div>
                        </div>
                        <div class="field">
                            <input id="title_post" type="text" name="subject" value="제목 :   ${qna.subject}" />
                        </div>

                        <div class="field">
                            <div class="ui form">
                                <div class="field">
                                    <textarea id="title_post" name="content" rows="25">${qna.content}</textarea>
                                </div>
                            </div>
                        </div>

                        <!-- 이건 id가 일치할 경우만 뜨게하기. -->
                        <button type="submit" class="ui large olive button">수정하기</button>
                    </div>
                </form>
                <br />
                <br />

                <!-- 이건 관리자일 경우에만 뜨게하기. -->
                <button id="title_name" class="ui large yellow button" onclick="location.href='qna.do?m=content&no=${qna.seq}'">뒤로가기</button>
            </div>
        </div>
    </body>
</html>
