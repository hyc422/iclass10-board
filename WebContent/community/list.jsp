<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>우리 북카페</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/list.css?v=3">
		<!-- 절대 경로 -->
		<!-- 상대경로는 (/css/community.css) request object의 contextPath를 el로 접근 시 현재 jsp 객체 pageContext를 사용  -->
	</head>
	<body>
		<main>
		<h3>북챗 :: 커뮤니티</h3>
		<p>오늘 무슨 책을 읽으셨나요?</p>
		<hr style="color:white;">
			<div style="margin:auto; width:900px;">
				<ul id="main">
					<li>
						<ul class="row">
							<li>번호</li>
							<li>제목</li>
							<li>작성자</li>
							<li>조회수</li>
							<li>작성일</li>
						</ul>
					</li>
		
					<c:forEach var="vo" items="${list}">
						<li>
							<ul class="row">
								<li>
									<c:out value="${vo.idx}"/>
								</li>
								<li>
									<a href="" class="title"><c:out value="${vo.title}"/></a>
									..<span style="color:orange; font-size:80%;">
									(<c:out value="${vo.commentCount}"/>)
									</span>
								</li>
								<li>
									<c:out value="${vo.writer}"/>(<c:out value="${vo.ip}"/>)
								</li>
								<li>
									<c:out value="${vo.readCount}"/>
								</li>
								<li>
									<!-- vo.created 날짜 패턴 적용 결과 문자열을 createdAt 변수로 저장 -->
									<fmt:formatDate value="${vo.createdAt}" pattern="yyyy-MM-dd" var="createdAt"/>
									<c:if test="${createdAt == today}">	<!-- 오늘 작성한 글 시간 표기 -->
										<fmt:formatDate value="${vo.createdAt}" type="time"/>
									</c:if>
									<c:if test="${createdAt != today}">
										<fmt:formatDate value="${vo.createdAt}" pattern="yyyy-MM-dd"/>
									</c:if>
								</li>
							</ul>
						</li>
					</c:forEach>
				</ul>
				<div style="float:right; margin:40px;">
					<a href="write" class="button">글쓰기</a>
					<a href="${pageContext.request.contextPath}" class="button">홈</a>
				</div>
			</div>
		</main>
	</body>
</html>