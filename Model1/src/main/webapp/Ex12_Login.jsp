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
	
//1. 파라미터 수집
String id = request.getParameter("ID");
String pw = request.getParameter("Pw");   

// DAO를 사용하려면
// 2. DAO 호출
DAO dao = new DAO();

// 3. DAO의 메서드를 사용
MemberVO vo = dao.login(id,pw);

if(vo != null){
   response.sendRedirect("Ex12_Logintrue.jsp?id=" + id);
}else{
   response.sendRedirect("Ex12_LoginFalse.jsp");
}

 
 
		 
 

%>	
	
	
</body>
</html>