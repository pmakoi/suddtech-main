<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>

</head>
<body>

<c:forEach var="row" items="${offers}">
    Name ${row.name}<br/>
    Email ${row.email}<br/>
    Text ${row.text}<br/>
</c:forEach>
</body>
</html>
 --%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
	
	
	    <link href="../css/main.css" rel="stylesheet">

    <title></title>
    
    <style type="text/css">
	.opacity{
	    opacity: 0.95;
	}
    </style>
  </head>
  <body>
  <div class="container">
    <nav class="navbar navbar-default navbar-fixed-top opacity">
	<div class="container-fluid">
	    <div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navigation">
		  <span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>  
		
		</button>
		<a class="navbar-brand" href="home.jsp">My Website</a>
	    </div>
	    <div class="collapse navbar-collapsed" id="navigation">
		<ul class="nav navbar-nav">
		    <li class="active"><a href="#serviceContainer">Service</a></li>
		    <li><a href="#expertContainer">Expert</a></li>
		     <li><a href="#contactContainer">Contact</a></li>
		</ul>
	    </div>
	</div>
    </nav>
  </div>
  
  
  
  
    <c:forEach var="row" items="${offers}">
    <div id="main" class="text text2">
    <ol>
    <li> Name ${row.name}</li>
    <li> Email ${row.email}</li>
    <li> Text ${row.text}</li>
    </ol>
    </div>
   <%--  Name ${row.name}<br/>
    Email ${row.email}<br/>
    Text ${row.text}<br/> --%>
</c:forEach>
</body>
</html>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.min.js"></script>
  </body>
</html>