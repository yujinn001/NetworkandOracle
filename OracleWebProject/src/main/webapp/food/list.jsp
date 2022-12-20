<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*,com.sist.dao.*"%>
 <%
    // �ڹ��ڵ� ����
    // 1. ����ڰ� ������ �����͸� �޴´�
    String strPage=request.getParameter("page"); // request, response => ���� ��ü
    if(strPage==null)
       strPage="1"; // default
    int curpage=Integer.parseInt(strPage);
    // 2. ����Ŭ ����(DAO)
    FoodDAO dao=new FoodDAO();
 
    // 3. �����͸� �޴´�
    ArrayList<FoodVO> list=dao.foodListData(curpage);
    
    // 4. html�� �̿��ؼ� ���
    
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
         <%
            for(FoodVO vo:list){
         %>
          <div class="col-md-3">
             <div class="thumbnail">
               <a href="#">
                 <img src="<%=vo.getPoster() %>" alt="Lights" style="width:100%" class ="img-rounded">
                 <div class="caption">
                   <p><%=vo.getName() %>&nbsp;<span style="color:orange"><%=vo.getScore() %></span></p>
                 </div>
               </a>
             </div>
           </div>
            <%
            }
            %>
                 
         </div>
		<div style ="height: 20px"> </div> <!--(html�ּ�) ���� �ֱ� -->
		<div class ="row">
		<div class ="text-center">
		<ul class="pagination">
		  <li><a href="list.jsp?page=1">1</a></li>
		  <li class="active"><a href="#">2</a></li>
		  <li><a href="list.jsp?page=2">3</a></li>
		  <li><a href="list.jsp?page=3">4</a></li>
		  <li><a href="list.jsp?page=4">5</a></li>
		</ul>
		</div>
		</div>         
      </div>

</body>
</html>