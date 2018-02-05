<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<aside>
	<div id="sidebar" class="nav-collapse ">
		<!-- sidebar menu start-->
		<ul class="sidebar-menu">
			<li class="active">
				<a class="" href="index.html"> <i class="fa fa-user"></i><span>MANAGER</span></a>
			</li>
			<li class="sub-menu">
				<a href="javascript:;" class=""> <i class="icon_document_alt"></i> <span>리스트</span> <span class="menu-arrow arrow_carrot-right"></span>
			</a>
				<ul class="sub">
					<li><a class="" href="${pageContext.request.contextPath}/idol/idolList">아이돌 리스트</a></li>
					<li><a class="" href="${pageContext.request.contextPath}/book/bookList"><span>책 리스트</span></a></li>
					<li><a class="" href="${pageContext.request.contextPath}/city/cityList">도시 리스트</a></li>
					<li><a class="" href="${pageContext.request.contextPath}/country/countryList">나라 리스트</a></li>
					<li><a class="" href="${pageContext.request.contextPath}/movie/movieList">영화 리스트</a></li>
				</ul>
			</li>
		</ul>
	</div>
	</aside>
	<section id="main-content">
	<section class="wrapper">
	<div class="row">