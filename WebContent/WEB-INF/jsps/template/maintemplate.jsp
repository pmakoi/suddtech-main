<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src="${pageContext.request.contextPath}/static/js/jquery-2.1.3.js"></script>
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	
	<!-- Optional theme -->
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
	    <script src="${pageContext.request.contextPath}/static/js/bootbox.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
	<title>Easy Shop</title>
	<!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/static/css/login.css" rel="stylesheet">	
	<!-- custom css -->
    <link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">
    <!-- TataTable -->
    <link href="${pageContext.request.contextPath}/static/css/dataTables.bootstrap.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/datatable.css" rel="stylesheet" type="text/css">
    <!-- Multi_Select -->	
    <link href="${pageContext.request.contextPath}/static/css/multi_select.css" rel="stylesheet" type="text/css">	
    <%-- <link href="${pageContext.request.contextPath}/static/js/multi_select.js" rel="stylesheet" type="text/css">	 --%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/multi_select.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/login.js"></script>
     <script src="${pageContext.request.contextPath}/static/js/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/dataTables.bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/table.js"></script>

</head>

<body>
	<!-- Header page  -->
	<tiles:insertAttribute name="header" />
  	<div class="jumbotron">
  	<!-- Body page -->
  	<tiles:insertAttribute name="body"/>
  	</div><!-- end jumbotron  -->
  	<!-- Footer page  -->
  	<tiles:insertAttribute name="footer" />
</body>
</html>