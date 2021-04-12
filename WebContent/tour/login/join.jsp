<%@ page language='java' contentType="text/html; charset=utf-8" import='Domain.Member' pageEncoding="utf-8"%>
<%-- <%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>  --%>
<html>
   <c:if test='${empty Member}'></c:if>
   <head>
      <title>Join</title>
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
            <center><h1> 회원가입 양식 </h1></center><br/><Br/><br/>
            
           
         <form name="f" action="../../tour/login/login.do?m=insert" method="post">
            <div class="ui equal width form">
                        <div class="fields">
                            <div class="field">  <%-- value='${dto.email}' --%>
                  <td><span style='color:rgb(124, 124, 124)'>E-mail</span> <span style='color:rgb(223, 111, 111)'>*</span></td>
                  <td><input name ='email' type='email'  ></td>
               </tr>
               <tr>
                  <td><span style='color:rgb(124, 124, 124)'>비밀번호</span> <span style='color:rgb(223, 111, 111)'>*</span></td>
                  <td><input name ='pwd' type='password' ></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
               </tr>
               <tr>
                  <td><span style='color:rgb(124, 124, 124)'>이름</span> <span style='color:rgb(223, 111, 111)'>*</span></td>
                  <td class='name-box'><input name ='name' type='text'></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
               </tr>
               <tr>
                  <td><span style='color:rgb(124, 124, 124)'>닉네임</span> <span style='color:rgb(223, 111, 111)'>*</span></td>
                  <td class='name-box'><input name ='nickname' type='text'></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
               </tr>
               <tr>
                  <td><span style='color:rgb(124, 124, 124)'>핸드폰</span> <span style='color:rgb(223, 111, 111)'>*</span></td>
                  <td class='name-box'><input name='phone' type='text'placeholder='11자 ex) 01023456789'></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
               </tr>
             
               <tr>
                  <td><span style='color:rgb(124, 124, 124)'>생년월일</span> <span style='color:rgb(223, 111, 111)'>*</span></td>
                  <td class='birth-box'><input name='bdate' type='text'placeholder='8자 ex) 19880808' value='${dto.bdate}'></td>
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
                     <input class="ui big teal button" type='submit' value='가입' />&nbsp;&nbsp;&nbsp;
                     <input class="ui big yellow button" type='button' OnClick="location.href ='../login/update1.jsp'" value='수정'/>   
                      </div>                
                     </div>
                  </td>
              </tr>
            </table>
         </form>
      </div>
     
   </body>
</html>