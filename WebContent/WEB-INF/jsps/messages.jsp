<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="container">
	<div id="messages" class="table-responsive">
		<table id="example" class="table table-striped table-bordered"
			cellspacing="0" width="100%">
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
				<c:forEach var="message" items="${messages}">

					<tr id="tableRow">
						<td><c:out value="${message.email}"></c:out></td>

						<td><c:out value="${message.subject}"></c:out></td>

						<td><a href="#"
							class="glyphicon-style glyphicon glyphicon-envelope"
							data-toggle="modal" data-target="#largeModal">. Open message</a>

<div class="modal fade" id="largeModal" tabindex="-1" role="dialog"
						aria-labelledby="largeModal" aria-hidden="true">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">
										<c:out value="${message.subject}"></c:out>
									</h4>
								</div>
								<div class="modal-body">
									<h3>
										<c:out value="${message.content}"></c:out>
									</h3>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary">Save
										changes</button>
								</div>
							</div>
						</div>
					</div>
						</td>

					</tr>

					
				</c:forEach>

			</tbody>
		</table>

	</div>
</div>






<!-- <script type="text/javascript">
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
 
 -->
<!--  </script> -->
