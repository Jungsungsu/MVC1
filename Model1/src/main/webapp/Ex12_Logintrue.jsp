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
      String ID = request.getParameter("id");
   %>

   <fieldset>
   
      <h1>  <%=ID %>님 환영합니다. </h1>
   
   </fieldset>

</body>
</html>