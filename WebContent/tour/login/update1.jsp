<%@ page language='java' contentType='text/html; charset=UTF-8'
   pageEncoding='UTF-8'
   import='Domain.Member'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %> 
<html>
   <c:if test='${empty Member}'></c:if>
   <head>
      <title>Join</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <!-- <link rel='stylesheet' type='text/css' href='../../css/join.css'> -->
      <link rel="stylesheet" href="../../css/qna.css">
      <link rel="stylesheet" href="../../css/semantic.min.css">
      <link rel="stylesheet" href="../../css/bootstrap.min.css">
      
      <style>
      	.field {
      		width: 350px !important;
      		margin: 0 auto;
      	}
      	table.join-t3 {
      		margin: 0 auto;
      	}
      </style>
      <!-- <link rel='stylesheet'href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css?ver=1'> -->
   </head>
   <body>
      <div class="ui middle aligned center aligned grid">
        <div class="ui stacked segment">
            <center><h1> 회원정보 변경 양식</h1></center><br/><Br/><br/>
            
            
           
         <form name="f" action="../../tour/login/login.do?m=Update2" method="post">
            <div class="ui equal width form">
                        <div class="fields">
                            <div class="field">
                  <td><span style='color:rgb(124, 124, 124)'>E-mail</span> <span style='color:rgb(223, 111, 111)'>*</span></td>
                  <td><input name ='email' type='email' name='user_email1'   value='${dto.email}' ></td>
               </tr>
               <tr>
                  <td><span style='color:rgb(124, 124, 124)'>비밀번호</span> <span style='color:rgb(223, 111, 111)'>*</span></td>
                  <td><input name ='pwd' type='password' name='user_pwd1' value='${dto.pwd}'></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
               </tr>
               <tr>
                  <td><span style='color:rgb(124, 124, 124)'>이름</span> <span style='color:rgb(223, 111, 111)'>*</span></td>
                  <td class='name-box'><input name ='name' type='text' name='user_name' value='${dto.name}'></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
               </tr>
               <tr>
                  <td><span style='color:rgb(124, 124, 124)'>닉네임</span> <span style='color:rgb(223, 111, 111)'>*</span></td>
                  <td class='name-box'><input name ='nickname' type='text' name='nick_name' value='${dto.nickname}'></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
               </tr>
               <tr>
                  <td><span style='color:rgb(124, 124, 124)'>핸드폰</span> <span style='color:rgb(223, 111, 111)'>*</span></td>
                  <td class='name-box'><input name='phone' type='text' name='user_nickname' placeholder='11자 ex) 01023456789' value='${dto.phone}'></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
               </tr>
             
               <tr>
                  <td><span style='color:rgb(124, 124, 124)'>생년월일</span> <span style='color:rgb(223, 111, 111)'>*</span></td>
                  <td class='birth-box'><input name='bdate' type='text' name='user_birth' placeholder='8자 ex) 19880808' value='${dto.bdate}'></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
               </tr>
              
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
               </tr>
               </div>
                        </div><br/><br/>
                    </div>
            
            <table class='join-t3'>
               <tr>
                  <td colspan='2' align='center'>
                     <!-- <form name="f" action="../../tour/login/login.do?m=insert" method="post"> -->
                     <input class="ui big teal button" type='submit' value='변경' />&nbsp;&nbsp;&nbsp;
                     <%-- <input class="ui big yellow button"  OnClick="location.href ='login.do?m=del&seq=${dto.member_no}'" value='탈퇴'/>    --%>
                     <%-- <button type="button" onclick="location.href='login.do?m=del&seq=${dto.member_no}'">탈퇴하기</button> --%>
                     <button type="button" class="ui large teal button" onclick="location.href='login.do?m=del&seq=${loginPassUser.member_no}'">탈퇴하기</button>
                      </div>                
                     </div>
                  </td>
              </tr>
            </table>
         </form>
      </div>
     
   </body>
</html>