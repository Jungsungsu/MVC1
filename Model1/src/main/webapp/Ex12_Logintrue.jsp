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
      // 1. �Ķ���� ����
      String ID = request.getParameter("id");
   %>

   <fieldset>
   
      <h1>  <%=ID %>�� ȯ���մϴ�. </h1>
   
   </fieldset>

</body>
</html>