<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
fieldset{
   border: dotted;
   text-align: center;
}

</style>
</head>
<body>
   <%
      // 1. 파라미터 수집
      String nick = request.getParameter("nick");
   %>

   <fieldset>
   
      <h1>  <%= nick %>님 회원가입이 성공하셨습니다. </h1>
   
   </fieldset>

</body>
</html>