<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <div class="header">
        <div class="nav">
            <ul>
                <li><button type="button" onclick="location.href='../'">Home</button></li>
                <li><button type="button" onclick="location.href='review.do?m=reviewMain'">여행후기</button></li>
                <li><button type="button" onclick="location.href='qna.do?m=content'">문의하기</button></li>
                <li><button type="button" onclick="location.href='login.login.do'">로그인</button></li>
            </ul>
        </div>
    </div>
    <!-- nav끝 -->
    <div class="ui middle aligned center aligned grid" style="70%">
        <div class="column">
            <h2 class="ui teal image header">
                여행 후기 쓰기
            </h2>
            <form class="ui large form">
                <div class="ui stacked segment">
                     <div class="field">
                        <input id="title_post" name ="nick" type="text" value="${list.nickname}" placeholder="작성자 : "/>
                     </div>
                    <div class="field">
                        <input id="title_post" type="text" value="${list.rdate}" placeholder="작성일 : " />
                     </div> 
                    <div class="field">
                        <input type="text" id="b_title" placeholder="게시글 제목" name = 'subject' value='${list.subject}' placeholder="제목 : "autocomplete="off" autofocus="autofocus">
                    </div>
                    <div class="field" >
                        <div class="ui left icon input">
                            <textarea placeholder="게시글 내용" rows="20" placeholder="내용 : "></textarea>
                        </div>
                    </div>
                   <%-- <div class="ui fluid large teal submit button" id="write_bbs" name = 'content' value='${list.content}' >글 올리기</div> --%>
                   <button type="submit" class="ui large teal submit button" style="font-family: 'S-CoreDream-2ExtraLight'">글 올리기</button>
                </div>

                <div class="ui error message"></div>

            </form>

            <a href="../tour/review.do?m=reviewMain"><button class="ui fluid large teal submit button" location="review.do?m=reviewMain">뒤로가기</button></a>
        </div>
    </div>
    <!-- js 가져오기 -->
    <script src="/coco/resources/jquery3.3.1.min.js"></script>
    <script src="/coco/resources/semantic.min.js"></script>
    <script>
        $(document).ready(function() {
            $("#write_bbs").click(function() {
                var json = {
                    b_title: $("#b_title").val(),
                    b_content: $("#b_content").val()
                };

                for (var str in json) {
                    if (json[str].length == 0) {
                        alert($("#" + str).attr("placeholder") + "를 입력해주세요.");
                        $("#" + str).focus();
                        return;
                    }
                }

                $.ajax({
                    type: "post",
                    url: "write_bbs",
                    data: json,
                    success: function(data) {
                        switch (Number(data)) {
                            case -1:
								alert("로그인 후 이용해주세요.");
								window.location.href = "/coco";
                                break;
                            case 0:
								alert("정상적으로 등록이 되었습니다.");
								window.location.href = "/coco/main";
                                break;

                            default:
                            	alert("알수없는 오류가 발생 했습니다.[Error Code : " + Number(data) + "]");
                                break;
                        }
                    },
                    error: function(error) {
                        alert("오류 발생" + error);
                    }
                });
            });
        });

    </script>
</body>

</html>
    