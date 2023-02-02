<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>우리 북카페</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/community.css?v=3">
		<!-- 절대 경로 -->
		<!-- 상대경로는 (../css/community.css) request object의 contextPath를 el로 접근 시 현재 jsp 객체 pageContext를 사용  -->
	</head>
	<body>
		<main id="writer">
			<h3>북챗 :: 커뮤니티</h3>
			<p>오늘 무슨 책을 읽으셨나요?</p>
			<hr style="color:white;">
			<form action="write" method="POST">
				<table>
					<tr>
						<th><label>제목</label></th>	
						<td><input type="text" name="title" size="50" required></td>				
					</tr>
					<tr>
						<th><label>작성자</label></th>
						<td><input type="text" name="writer" size="50" required></td>				
					</tr>
					<tr>
						<th><label>내용</label></th>
						<td><textarea rows="30" cols="80" name="content" style="resize:none;" required></textarea></td>				
					</tr>
					<tr>
						<td style="text-align:center; padding:10px;" colspan="2">
							<button type="submit">저장</button>
							<button type="reset">다시쓰기</button>
							<button type="button" onclick="location.href='#'">목록</button>
						</td>
					</tr>
				</table>
			</form>
		</main>
	</body>
</html>
<!-- eclipse에 ipv4로 처리되도록 tomcat 설정 변경 -->
<!-- request 객체로 remoteAddr 받을 때 기본 설정이 ipv6로 출력 -->
<!-- run - run configuration - Tomcat Server - Arguments - VM argument 문자열 마지막 추가 -Djava.net.preferIPv4Stack=true -->

