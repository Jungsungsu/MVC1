<%@page import="DAO.MemberVO"%>
<%@page import="DAO.DAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Driver"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	
//1. �Ķ���� ����
String id = request.getParameter("ID");
String pw = request.getParameter("Pw");   

// DAO�� ����Ϸ���
// 2. DAO ȣ��
DAO dao = new DAO();

// 3. DAO�� �޼��带 ���
MemberVO vo = dao.login(id,pw);

if(vo != null){
   response.sendRedirect("Ex12_Logintrue.jsp?id=" + id);
}else{
   response.sendRedirect("Ex12_LoginFalse.jsp");
}

 
 
		 
 

%>	
	
	
</body>
</html>