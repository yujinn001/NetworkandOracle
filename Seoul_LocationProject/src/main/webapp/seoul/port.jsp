<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.sist.dao.*, java.util.*"%>
    <%
    LocationDAO dao=new LocationDAO();
    ArrayList<ZipcodeVO> list=dao.postFind();
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>