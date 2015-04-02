<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp" %>
<div class="container">
</div>
<div class="container">
	<c:forEach var="offer" items="${offers}">
		<p>
			<c:out value="${offer}"></c:out>
		</p>
	</c:forEach>
</div>

	<%@ include file="footer.jsp" %>
</body>
</html>