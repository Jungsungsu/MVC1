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
      String nick = request.getParameter("nick");
   %>

   <fieldset>
   
      <h1>  <%= nick %>�� ȸ�������� �����ϼ̽��ϴ�. </h1>
   
   </fieldset>

</body>
</html>