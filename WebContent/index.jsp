<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member"%>
<%@ page import="broker.model.vo.Broker"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<section id="search-banner">
	<p class="banner-text" style="font-size: 30px" >대학생을 위한 방을 구하고 계신가요?</p>
	<br>
	<p class="banner-text">
		<span style="font-weight: bold; font-size: 60px">금방</span>
	</p>
	<form action="<%= request.getContextPath() %>/board/searchLocationRoom" class="main-search-frm">
		<div class="main-search">
			<input type="text" name="localSearch" id="keyword" placeholder="키워드를 입력해 주세요" />
			<button type="submit" class="searchBtn">방 찾기</button>
		</div>
	</form>
</section>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
