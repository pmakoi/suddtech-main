<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="table-responsive">
		<table id="example" class="table table-striped table-bordered"
			cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>User name</th>
					<th>Email</th>
					<th>Text</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>Username</th>
					<th>Email</th>
					<th>Text</th>
				</tr>
			</tfoot>
			<tbody>
				<c:forEach var="offer" items="${offers}">
					<tr>
						<td><c:out value="${offer.user.name}"></c:out></td>
						<td><c:out value="${offer.user.email}"></c:out></td>
						<td><c:out value="${offer.text}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
