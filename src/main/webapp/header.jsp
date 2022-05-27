<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//MemberVO user
	String sid = (String) session.getAttribute("sid");
	String sname = (String) session.getAttribute("sname");
	if(sid!=null) sid=sid.trim().toLowerCase();
%>
<c:set var="path" value="${pageContext.request.contextPath }" />  
<header id="header" class="panel-heading">
	<div class="hd_wrap">
		<nav class="navbar" role="navigation" aria-label="main navigation">
		  <div class="navbar-brand">
		    <a class="navbar-item" href="index.jsp">
		      <img src="${path }/img/logo.png" width="112" height="28">
		    </a>
		
		    <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
		      <span aria-hidden="true"></span>
		      <span aria-hidden="true"></span>
		      <span aria-hidden="true"></span>
		    </a>
		  </div>
		
		  <div id="navbarBasicExample" class="navbar-menu">
		    <div class="navbar-start">
		      <div class="navbar-item has-dropdown is-hoverable">
		        <a class="navbar-link">
		          쇼핑몰
		        </a>
		
		        <div class="navbar-dropdown">
		          <a class="navbar-item">
		            쇼핑몰 소개
		          </a>
		          <a class="navbar-item">
		            쇼핑몰 안내
		          </a>
		          <a class="navbar-item">
		            쇼핑몰 알아보기
		          </a>
		          <hr class="navbar-divider">
		          <a class="navbar-item">
		            쇼핑몰 찾아가기
		          </a>
		        </div>
		      </div>
		      <div class="navbar-item has-dropdown is-hoverable">
		        <a class="navbar-link" href="GetGoodsListCtrl">
		          제품안내
		        </a>
		        <div class="navbar-dropdown">
		          <a class="navbar-item">
		            귀걸이
		          </a>
		          <a class="navbar-item">
		            반지
		          </a>
		          <a class="navbar-item">
		            목걸이
		          </a>
		          <hr class="navbar-divider">
		          <a class="navbar-item">
		            등등
		          </a>
		        </div>
		      </div>
		      <div class="navbar-item has-dropdown is-hoverable">
		        <a class="navbar-link">
		          고객센터
		        </a>
		
		        <div class="navbar-dropdown">
		          <a class="navbar-item" href="GetBoardListCtrl">
		            공지사항
		          </a>
		          <a class="navbar-item">
		            1:1 문의
		          </a>
		          <a class="navbar-item">
		            자주하는 질문 및 답변
		          </a>
		          <hr class="navbar-divider">
		        </div>
		      </div>
		    </div>
		
		    <div class="navbar-end">
		      <div class="navbar-item">
		        <div class="buttons">
		        	<%if(sid==null){ %>
				       	<a class="button is-primary" href="agree.jsp">
		            		<strong>회원가입</strong>
		          		</a>
				       	<a class="button is-light" href="login.jsp">
		          		 	로그인
		         		</a>
					<%} else if(!sid.equals("admin")) { %>
						<a class="button is-primary" href="/web02/GetMypageCtrl">
							<%=sname %>
						</a>
						<a class="button is-light" href="${path }/LogoutCtrl">
		          		 	로그아웃
		         		</a>
					<%} else{%>
						<a class="button is-primary" href="/web02/GetMypageCtrl">
							<%=sname %>
						</a>
						<a class="button is-light" href="/web02/GetCustomerListCtrl">고객목록</a>
						<a class="button is-light" href="${path }/LogoutCtrl">
		          		  로그아웃
		         		</a>
					<%} %>
		        </div>
		      </div>
		    </div>
		  </div>
		</nav>
	</div>
</header>