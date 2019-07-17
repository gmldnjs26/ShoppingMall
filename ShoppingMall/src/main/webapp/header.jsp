<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kwak Shop</title>
<link href="css/shopping2.css?ver=4" rel="stylesheet">
<script type="text/javascript" src="js/member.js?ver=5"></script>
<script type="text/javascript" src="js/mypage.js?ver=5"></script>
</head>

<body>
	<div id="wrap">
		<!--헤더파일 들어가는 곳 시작 -->
		<header>
			<!--로고 들어가는 곳 시작--->
			<div id="logo">
				<a href="index.do"> 
				<img src="images/f_logo.jpg" width="180" height="100" alt="kwakshop">
				</a>
			</div>
			<!--로고 들어가는 곳 끝-->
			<nav id="catagory_menu">
				<ul>
					<c:choose>
						<c:when test="${empty sessionScope.loginUser}">
							<li><a href="login_form.do">LOGIN</a></li>
							<li>/</li>
							<li><a href="contract.do">JOIN</a></li>
						</c:when>
						<c:otherwise>
							<li style="color: orange">
								${sessionScope.loginUser.name}(${sessionScope.loginUser.id})</li>
							<li><a href="logout.do">LOGOUT</a></li>
						</c:otherwise>
					</c:choose>
					<li>/</li>
					<li><a href="cart_list.do">CART</a></li>
					<li>/</li>
					<li><a href="mypage.do">MY PAGE</a></li>
					<li>/</li>
					<li><a href="qna_list.do">Q&amp;A(1:1)</a></li>
					<li>/</li>
					<li><a href="admin_login_form.do">Admin</a></li>
				</ul>
			</nav>

			<nav id="top_menu">
				<ul>
					<li><a href="category.do?kind=1">OUTER</a>
					</li>
					<li><a href="category.do?kind=2">TOP</a></li>
					<li><a href="category.do?kind=3">PANTS</a>
					</li>
					<li><a href="category.do?kind=4">SHOES</a>
					</li>
					<li><a href="category.do?kind=5">BAG</a></li>
				</ul>
			</nav>
			<div class="clear"></div>
			<hr>
		</header>
		<!--헤더파일 들어가는 곳 끝 -->