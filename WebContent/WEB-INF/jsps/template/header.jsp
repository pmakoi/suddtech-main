<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

    <nav class="navbar navbar-default navbar-fixed-top opacity">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
      
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
          
          
		<li class="active"><a href="${pageContext.request.contextPath}#">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/offers">Offer</a></li>
            <li><a href="${pageContext.request.contextPath}/createoffer">Create Offer</a></li>

            
            <sec:authorize access="isAuthenticated()">
             	<li><a href="${pageContext.request.contextPath}/contact">Contact</span></a></li>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
             <li><a href="${pageContext.request.contextPath}/admin">Admin page</a></li>
            </sec:authorize>
   
   			<sec:authorize access="isAuthenticated()">
             	<li><a href="${pageContext.request.contextPath}/messages">Messages[<span class="numberMessages" id='numberMessages'>0</span>]</a></li>
            </sec:authorize>
            
             <sec:authorize access="!isAuthenticated()">
            <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
            </sec:authorize>
             <sec:authorize access="isAuthenticated()">
            <li><a href="<c:url value='/j_spring_security_logout'/>">Log out</a></li>
            </sec:authorize>
          </ul>
          <ul class="nav navbar-nav navbar-right">
          </ul>
        </div><!--/.nav-collapse -->
      </div> <!-- container-fluid -->
    </nav><br><br><br><br><br>
 
<script type="text/javascript">
 //<!--
 function updateMessageLink(data){
	 $("#numberMessages").text(data.number);
 }
 function onLoad(){
	 updatePage();
	 window.setInterval(updatePage, 5000);
 }
 function updatePage(){
		$.getJSON("<c:url value='/getmessages'/>", updateMessageLink);

 }
 $(document).ready(onLoad);
 //-->
 </script>
   