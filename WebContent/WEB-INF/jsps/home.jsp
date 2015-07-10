<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="container">
	<div class="table-responsive">
		<table id="example" class="table table-striped table-bordered"
			cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Offer</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Offer</th>
				</tr>
			</tfoot>
			<tbody>
				<c:forEach var="offer" items="${offers}">
					<tr>
						<td><c:out value="${offer.user.name}"></c:out></td>
						<td><a href="<c:url value='/message?uid=${offer.username}'></c:url>"><span class="glyphicon glyphicon-pencil" area-hidden="true">contact</span></a></td>
						<td><c:out value="${offer.text}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div><!-- /container -->
