<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.sist.change.*"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   FoodModel model=new FoodModel();
   model.foodListData(request);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <style type="text/css">
 .container{
    margin-top: 50px; /* ������ �� ����*/
    border:1px black solid;
    height: 700px;
    width: 1200px;
 }
 .row{
    margin: 0px auto; /* ��� ����*/
    width: 960px;
 }
 </style>
</head>
<body>
   <div class="container">
      <div class="row">
         <c:forEach var="vo" items="${list }">
          <div class="col-md-3">
             <div class="thumbnail">
               <a href="#">
                 <img src="${vo.poster }" alt="Lights" style="width:100%" class="img-round">
                 <div class="caption">
                   <p>${vo.name }&nbsp;<span style="color:orange">${vo.score }</span></p>
                 </div>
               </a>
             </div>
           </div>
         </c:forEach>
                 
         </div>
            <div style="height: 20px"></div> <!-- �����ֱ� -->
               <div class="text-center">
                  <ul class="pagination">
                    <li><a href="list.jsp?page=1">1</a></li>
                    <li><a href="list.jsp?page=2">2</a></li>
                    <li><a href="list.jsp?page=3">3</a></li>
                    <li><a href="list.jsp?page=4">4</a></li>
                    <li><a href="list.jsp?page=5">5</a></li>
                  </ul>
               </div>
      </div>

</body>
</html>