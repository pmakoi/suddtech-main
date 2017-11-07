<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sft" uri="http://www.springframework.org/tags/form"%>


<div class="container">
	<div id="messages" class="table-responsive">
		<table id="messageTable" class="table table-striped table-bordered"
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
			</tbody>
		</table>

	</div>
</div>

<div class="modal fade" id="largeModal" tabindex="-1" role="dialog"
	aria-labelledby="largeModal" aria-hidden="true">
	<div id="contentModal" class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button id="contentBtn" type="button" class="close"
					data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">

					<c:out value="${message.subject}"></c:out>
				</h4>
			</div>
			<div class="modal-body">
				<h3>
					<span id="content_val" value="${message.content}"></span>
				</h3>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Save changes</button>
			</div>
		</div>
	</div>
</div>



<div class="modal fade" id="replyModal" tabindex="-1" role="dialog"
	aria-labelledby="replyModal" aria-hidden="true">
	<div id="contentModal" class="modal-dialog modal-lg row row-fluid">
		<div class="modal-content">
			<div class="modal-header">
				<button id="contentBtn" type="button" class="close"
					data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">
					<c:out value="${message.subject}"></c:out>
				</h4>
			</div>
			<div class="modal-body">
				<sft:form class="form-signin" method="post" commandName="message">
					<div class="form-group form-group-lg">
						<%-- <sft:errors path="content" cssClass="warning error"></sft:errors> --%>
						<textarea placeholder="Your message" class="form-control"
							style="height: 300px; width: 500px;"></textarea>
					</div>
					<div class="form-group form-group-lg glyphicon-style">
						<button type="submit" class="btn btn-success btn-lg" name="submit">
							Reply .<span class="glyphicon glyphicon-envelope"
								aria-hidden="true"></span>
						</button>
					</div>
				</sft:form>
			</div>
			<div class="modal-footer"></div>
		</div>
	</div>
</div>

<script type="text/javascript">
	function showMessages(data) {
		$("#messageTable > tbody").html("");

		for (var i = 0; i < data.messages.length; i++) {
			var message = data.messages[i];

			var tr = document.createElement("tr");

			var subjectSpan = document.createElement("span");
			subjectSpan.setAttribute("class", "message");
			subjectSpan.appendChild(document.createTextNode(message.subject));

			var contentSpan = document.createElement("span");
			contentSpan.setAttribute("class", "messagebody");
			/* contentSpan.appendChild(document.createTextNode(message.content)) */
			var modalLink = document.createElement("a");
			modalLink.setAttribute("class",
					"glyphicon-style glyphicon glyphicon-envelope");
			modalLink.setAttribute("data-toggle", "modal");
			modalLink.setAttribute("data-target", "#largeModal");
			contentSpan.appendChild(modalLink);

			//populate the modal

			document.getElementById("content_val").innerHTML = data.messages[i].content;

			var emailSpan = document.createElement("span");
			emailSpan.setAttribute("class", "emailText");
			emailSpan.appendChild(document.createTextNode(message.email));

			var emailTd = document.createElement("td");
			var td = document.createElement("td");
			var contentTd = document.createElement("td");

			var replyTd = document.createElement("td");

			/* Reply Form*/
			var replySpan = document.createElement("span");
			replySpan.setAttribute("class", "messagebody");
			var replyModal = document.createElement("a");
			replyModal.setAttribute("class",
					"glyphicon-style glyphicon glyphicon-pencil");
			replyModal.setAttribute("data-toggle", "modal");
			replyModal.setAttribute("data-target", "#replyModal");
			replySpan.appendChild(replyModal);

			/*  var replyForm = document.createElement("form");
			replyForm.setAttribute("class", "replyForm");
			var textarea=document.createElement("textarea");
			textarea.setAttribute("class","textarea");
			replyForm.appendChild(textarea);

			var replyButton=document.createElement("input");
			replyButton.setAttribute("class","btn btn-success btn-lg");
			replyButton.setAttribute("type","button");
			replyButton.setAttribute("value","Reply");
			replyForm.appendChild(replyButton);
			replyTd.appendChild(replyForm); */
			/*	$("#messages").appendChild(replyForm);
			 */
			emailTd.appendChild(emailSpan);
			contentTd.appendChild(contentSpan);
			replyTd.appendChild(replySpan);
			td.appendChild(subjectSpan);

			tr.appendChild(emailTd);
			tr.appendChild(td);
			tr.appendChild(contentTd);
			tr.appendChild(replyTd);

			$("#messageTable > tbody").append(tr);

		}
		/* $('#largeModal > modal-body > content_val').on('hide.bs.modal', function () {
		   $('#largeModal').removeData();
		});
		 */
	}
	/* $('a.modalLink').click(function(e) {
		   e.preventDefault();
		   $('#largeModal')
		        .removeData()
		        .html('loading....')
		        .load($(this).attr('href'))
		        .modal({show:true,backdrop:'static'});
		}); */

	function onLoad() {
		updatePage_();
		window.setInterval(updatePage_, 5000);
	}
	function updatePage_() {
		$.getJSON("<c:url value='/getmessages'/>", showMessages);
	}

	$(document).ready(onLoad);
</script>
