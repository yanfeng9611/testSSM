<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图书清单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/index.css" type="text/css" rel="stylesheet">
	  <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	  <script type="text/javascript">
		  $(function(){
			  $("#next").click(function(){
				  var pages = parseInt($("#pages").html());
				  var page = parseInt($("#currentPage").html());
				  if(page == pages){
					  return;
				  }
				  page++;
				  location.href = "/user/index?page="+page;
			  })

			  $("#previous").click(function () {
				  var page = parseInt($("#currentPage").html());
				  if(page == 1){
					  return;
				  }
				  page--;
				  location.href = "/user/index?page="+page;
			  })

			  $("#first").click(function () {
				  location.href = "/user/index?page=1";
			  })

			  $("#last").click(function(){
				  var pages = parseInt($("#pages").html());
				  location.href = "/user/index?page="+pages;
			  })
		  })
	  </script>
  </head>
  
  <body>
    <%@ include file="../public/top.jsp" %>
  	
  	
  	<div id="main">
		<div class="navigation">
			图书清单
			<a href="/user/history?page=1">借阅历史</a>
			<a href="/user/approval?page=1">待审批</a>
			<a href="/user/reading?page=1">借阅中</a>
			<a href="/user/accomplish?page=1">已完成</a>
			<div id="readerBlock">欢迎回来&nbsp;:${username}&nbsp;<a href="/user/logout">注销</a></div>
		</div>
		<div class="img_block">
			<img src="images/main_booksort.gif" class="img" />
		</div>
		
		<table class="table" cellspacing="0">
			<tr>
				<td>编号</td>
				<td>名称</td>
				<td>作者</td>
				<td>出版社</td>
				<td>图书类别</td>
				<td>出版时间</td>
				<td>总页数</td>
				<td>单价</td>
				<td>余量</td>
				<td>操作</td>
			</tr>

			<c:forEach items="${userIndexList}" var="userIndexList">
				<tr>
					<td>${userIndexList.idx}</td>
					<td>${userIndexList.bookName}</td>
					<td>${userIndexList.author}</td>
					<td>${userIndexList.publish}</td>
					<td>${userIndexList.caseName}</td>
					<td>${userIndexList.publicationTime}</td>
					<td>${userIndexList.pages}</td>
					<td>${userIndexList.price}</td>
					<td>${userIndexList.availableQuantity}</td>
					<td>
						<c:if test="${userIndexList.availableQuantity > 0}">
							<a href="/update/borrow?bookId=${userIndexList.bookId}">申请借阅</a>
						</c:if>
						<c:if test="${userIndexList.availableQuantity == 0}">
							申请借阅
						</c:if>
					</td>
<%--						<a href="/user?method=handle&id=${borrow.id}&state=1">借阅申请</a>--%>
				</tr>
			</c:forEach>

		</table>
		<hr class="hr"/>
		<div id="pageControl">
			<div class="pageControl_item">每页<font id="dataPrePage">${dataPrePage }</font>条数据</div>
			<div class="pageControl_item" id="last">最后一页</div>
			<div class="pageControl_item" id="next">下一页</div>
			<div class="pageControl_item"><font id="currentPage">${currentPage }</font>/<font id="pages">${pages }</font></div>
			<div class="pageControl_item" id="previous">上一页</div>
			<div class="pageControl_item" id="first">首页</div>
		</div>
	</div>
  	
   <%@ include file="../public/footer.jsp" %>
  </body>
</html>
