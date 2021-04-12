<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Bit Tour : 당신의 여행과 함께합니다.</title>
        <link rel="stylesheet" href="css/index.css" />
        <link rel="stylesheet" href="css/semantic.min.css" />
    </head>
    <body>
        <div class="container">
            <div class="header">
                <div class="nav">
                    <ul>
                        <li><button type="button" onclick="location.href='#'">Home</button></li>
                        <li><button type="button" onclick="location.href='tour/review.do?m=reviewMain&member_no=${loginPassUser.member_no}'">여행후기</button></li>
                        
                        <li><button type="button" onclick="location.href='tour/qna.do?m=list'">문의하기</button></li>

                        <c:choose>
                            <c:when test="${empty loginPassUser}">
                                <li><button type="button" onclick="location.href='tour/login/login.do'">로그인</button></li>
                            </c:when>
                            <c:otherwise>
                                <li><button type="button" onclick="location.href='tour/login/login.do?m=logout'">로그아웃</button></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </div>
            <div class="img-container">
                <div class="hero">
                    <br />
                    <br />
                    <br />
                    <br />
                    <h2>Welcome Bit Tour</h2>
                    <br />
                    <br />
                    <p class="kor">비트 투어는 당신의 모든 여행에 함께합니다.</p>
                    <p class="main-sub">Bit Tour is responsible for your safe and free trip.</p>
                    <button type="button" onclick="location.href='tour/main.do?m=spain'">스페인</button>&nbsp;&nbsp;&nbsp;&nbsp;
                    <button type="button" onclick="location.href='tour/main.do?m=iceland'">아이슬란드</button>&nbsp;&nbsp;&nbsp;&nbsp;
                    <button type="button" onclick="location.href='tour/main.do?m=peru'">페 루</button>
                </div>
            </div>
        </div>
        <div class="ui inverted vertical footer segment">
            <div class="ui container">
                <div class="ui stackable inverted divided equal height stackable grid">
                    <div style="text-align: center;" class="column">
                        <br />
                        <button class="mini ui yellow button" onclick="location.href='#'">TOP</button><br />
                        <br />
                        <p>Copyright&nbsp;&nbsp;&nbsp;&nbsp; ⓒ &nbsp;&nbsp;&nbsp;&nbsp;2021 &nbsp;&nbsp;&nbsp;&nbsp;이곳의 모든 저작권은 비트캠프 신촌센터 181기 1조에게 있습니다.</p>
                        <br />
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>