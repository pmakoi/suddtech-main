<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="table-responsive">
		<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>Username</th>
					<th>Email</th>
					<th>Role</th>
					<th>Enabled</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>Username</th>
					<th>Email</th>
					<th>Role</th>
					<th>Enabled</th>
				</tr>
			</tfoot>
			<tbody>
				<c:forEach var="user" items="${users}">
					<tr>
						<td><c:out value="${user.username}"></c:out></td>
						<td><c:out value="${user.email}"></c:out></td>
						<td><c:out value="${user.authority}"></c:out></td>
						<td><c:out value="${user.enabled}"></c:out></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
    