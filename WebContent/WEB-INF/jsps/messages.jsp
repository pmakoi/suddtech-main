<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
    
     <div class="container">
	<div id="messages" class="table-responsive">
		 <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
			<thead>
				<tr>
					
					<th>Email</th>
					<th>Subject</th>
					<th>Content</th>
				</tr>
			</thead>
			<tfoot>
				<tr>	
					<th>Email</th>
					<th>Subject</th>
					<th>Content</th>
				</tr>
			</tfoot>
			<tbody id="tBody">
				<c:forEach var="offer" items="${offers}">
					<tr id="tableRow">
						<td><c:out value="${offer.user.name}"></c:out></td>
						<td><a href="<c:url value='/message?uid=${offer.username}'/>">Contact</a></td>
						<td><c:out value="${offer.text}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:choose>
			<c:when test="${hasOffer}">
				<div>
            		<a href='<c:url value="/createoffer"></c:url>'>Edit your current offer</a>
          		</div>
			</c:when>
			<c:otherwise>
				<div>
            		<a href='<c:url value="/createoffer"></c:url>'>Create new offer</a>
          		</div>
			</c:otherwise>
		
		</c:choose> 
	</div>
</div>
  
<script type="text/javascript">
 //<!--
 function showMessages(data){
	 $("#example > tbody").html(""); 
	 for(var i=0; i<data.messages.length; i++){
		 	var message=data.messages[i];
		 
		 	var tr=document.createElement("tr");
		
			var subjectSpan=document.createElement("span");
			subjectSpan.setAttribute("class", "message");
			subjectSpan.appendChild(document.createTextNode(message.subject));
			
			var contentSpan = document.createElement("span");
			contentSpan.setAttribute("class", "messagebody");
			contentSpan.appendChild(document.createTextNode(message.content))
			
			var emailSpan = document.createElement("span");
			emailSpan.setAttribute("class","emailText");
			emailSpan.appendChild(document.createTextNode(message.email));
			
			var emailTd=document.createElement("td");
			var td=document.createElement("td");
			var contentTd=document.createElement("td");
			
			emailTd.appendChild(emailSpan);
			contentTd.appendChild(contentSpan);
			td.appendChild(subjectSpan);
			
			tr.appendChild(emailTd);
			tr.appendChild(td);	
			tr.appendChild(contentTd);
			
 		  	$("#example > tbody").append(tr) ; 
	 	}
  }
 
 function onLoad(){
	 updatePage_();
	 window.setInterval(updatePage_, 5000);
 }
 function updatePage_(){
		$.getJSON("<c:url value='/getmessages'/>", showMessages);
 }
 $(document).ready(onLoad);
 
 //-->
 </script>
   