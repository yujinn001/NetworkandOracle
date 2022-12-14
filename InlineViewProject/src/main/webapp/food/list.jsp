<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*,com.sist.dao.*"%>
<%
   //�ڹ��ڵ�
   FoodDAO dao=new FoodDAO();
   String strPage=request.getParameter("page"); //���õ� ���� �޾� �´�
   if(strPage==null)//ó������ ������ ���ϱ� ������ 
   {
      strPage="1";
   }
   int totalpage=dao.foodTotalPage(); //�������� ���ϱ�
   int curpage=Integer.parseInt(strPage);//���������� ���ϱ�(����� ��û�� �Ϳ� ���� �޶�����)
   ArrayList<FoodVO> list=dao.foodListData(curpage); //���� �������� ���� �����͸� ����Ŭ�κ��� �о�´�
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width : 1200px;
}
h1{
   text-align: center
}
</style>
</head>
<body>
   <div class="container">
      <div class="row">
         <%
            for(FoodVO vo:list)
            {
         %>
               <div class="col-md-3">
                   <div class="thumbnail">
                        <a href="detail.jsp?fno=<%=vo.getFno()%>">
                          <img src="<%=vo.getPoster() %>" alt="Lights" style="width:100%">
                          <div class="caption">
                            <p><%= vo.getName() %></p>
                          </div>
                        </a>
                      </div>
                 </div>
         <%
            }
         %>
      </div>
      <div style="height:30px"></div>
      <div class="row">
         <div class="text-center">
            <a href="list.jsp?page=<%= curpage>1?curpage-1:curpage %>" class="btn btn-sm btn-danger">����</a>
            <%=curpage %> page/ <%=totalpage %> pages
            <a href="list.jsp?page=<%= curpage >totalpage?curpage+1:curpage %>" class="btn btn-sm btn-danger">����</a>
         </div>
      </div>
   </div>
</body>
</html>