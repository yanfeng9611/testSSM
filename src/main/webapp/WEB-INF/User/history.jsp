<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>--%>
<%--<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>--%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>借阅记录</title>
    
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
				  location.href = "/user/history?page="+page;
			  })

			  $("#previous").click(function () {
				  var page = parseInt($("#currentPage").html());
				  if(page == 1){
					  return;
				  }
				  page--;
				  location.href = "/user/history?page="+page;
			  })

			  $("#first").click(function () {
				  location.href = "/user/history?page=1";
			  })

			  $("#last").click(function(){
				  var pages = parseInt($("#pages").html());
				  location.href = "/user/history?page="+pages;
			  })
		  })
	  </script>
  </head>
  
  <body>
    <%@ include file="../public/top.jsp" %>
  	
  	
  	<div id="main">
		<div class="navigation">
			<a href="/user/index?page=1">图书清单</a>
			借阅历史
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
				<td>书名</td>
				<td>作者</td>
				<td>出版社</td>
				<td>类别</td>
				<td>借阅时间</td>
				<td>审批时间</td>
				<td>归还时间</td>
				<td>审核状态</td>
			</tr>
			<c:forEach items="${resultList}" var="resultList">
				<tr>
<%--					<td></td>--%>
					<td>${resultList.idx}</td>
					<td>${resultList.bookName}</td>
					<td>${resultList.author}</td>
					<td>${resultList.publish}</td>
					<td>${resultList.caseName}</td>
					<td>${resultList.borrowtime}</td>
					<td>${resultList.approvalTime}</td>
					<td>${resultList.returntime}</td>
					<td>${resultList.state}</td>
<%--					<td>--%>
<%--						<c:if test="${borrow.state == 0}">--%>
<%--							<font color="black">未审核</font>--%>
<%--						</c:if>--%>
<%--						<c:if test="${borrow.state == 1}">--%>
<%--							<font color="green">审核通过</font>--%>
<%--						</c:if>--%>
<%--						<c:if test="${borrow.state == 2}">--%>
<%--							<font color="red">未通过</font>--%>
<%--						</c:if>--%>
<%--						<c:if test="${borrow.state == 3}">--%>
<%--							<font color="yellow">已归还</font>--%>
<%--						</c:if>--%>
<%--					</td>--%>
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
