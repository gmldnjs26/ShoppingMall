<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kwak</title>
<link rel="stylesheet" href="admin/css/admin.css">
<script type="text/javascript" src="admin/product/product.js"></script>
<c:choose>
	<c:when test="${empty admin}">
		<script type="text/javascript">
			location.href = 'admin_login_form.do';
		</script>
	</c:when>
</c:choose>
</head>
<body onload="go_ab()">
	<div id="wrap">
		<header>			
			<div id="logo">
				<a href="command=admin_login_form.do"> 
					<img style="width:800px" src="admin/images/bar_01.gif">
					<img src="admin/images/text.gif">
				</a>
			</div>	
			<input class="btn" type="button"  value="logout"  style="float: right;"
			   onClick="location.href='command=admin_logout.do'">			
		</header>
		<div class="clear"></div>