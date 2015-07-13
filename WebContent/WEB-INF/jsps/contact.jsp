<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sft" uri="http://www.springframework.org/tags/form"%>


<%-- <div class="container  _container">
	 <sft:form class="form-signin" method ="post"  commandName="message">
	 
            <input type="hidden" name="_flowExcutionKey" value="${flowExcutionKey }"/>
	 
        <h2 class="form-signin-heading"><span class="glyphicon glyphicon-pencil" area-hidden="true"></span></h2>
        
       <label for="inputSubject" class="col-sm-2 control-label"></label><br/><sft:errors path="subject" cssClass="warning error"></sft:errors>
        <sft:input type="text" style="width:450px;" id="inputSubject" path="subject" name="subject" class="form-control" placeholder="Message subject "></sft:input>required autofocus
       
        <label for="inputName" class="sr-only"></label><br/><sft:errors path="name" cssClass="warning error"></sft:errors>
        <sft:input type="text" style="width:450px;" id="inputName" path="name" name="name" class="form-control" placeholder="Your name "></sft:input>required autofocus
      
        <label for="inputEmail" class="col-sm-2 control-label"></label><br/><sft:errors path="email" cssClass="warning error"></sft:errors>
        <sft:input type="email" style="width:450px;" id="inputEmail" path="email" name="email" class="form-control" placeholder="Your mail"></sft:input>required autofocus
       
         <label for="inputTextErea" class="col-sm-2 control-label"></label><br/><sft:errors path="content" cssClass="warning error"></sft:errors>
        <sft:textarea style="height: 300px; width: 500px;" id="inputContent" path="content" name="content" class="form-control" placeholder="Your message "></sft:textarea>required autofocus
       
      
         <button type="submit" class="btn btn-success btn-lg" name="submit">Send<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span></button>
      </sft:form>
	</div> --%>
<div class="container container-fluid _container" id="contactContainer">
	<div class="row row-fluid">
		<div class="col-md-6 col-md-offset-2">
			<div class="form-group form-group-lg col-md-offset-3">
				<h2>
					<span class="glyphicon glyphicon-pencil glyphicon-style" area-hidden="true"></span>
				</h2>
			</div>
			<sft:form class="form-signin" method="post" commandName="message">

				<input type="hidden" name="_flowExcutionKey"
					value="${flowExcutionKey }" />
				<input type="hidden" name="_eventId" value="send" />

				<div style="margin-bottom: 15px;" class="input-group input-group-lg">
					<sft:errors path="name" cssClass="warning error"></sft:errors>
					<sft:input type="text" path="name" style="width:450px;"
						class="form-control" name="name" placeholder="Your name "
						value="${fromName } " />
					<span class="input-group-addon" id="basic-addon"><span
						class="glyphicon glyphicon-user" aria-hidden="true"></span></span>
				</div>

				<div style="margin-bottom: 15px;" class="input-group input-group-lg">
					<sft:errors path="email" cssClass="warning error"></sft:errors>
					<sft:input type="email" path="email" style="width:450px;"
						class="form-control" name="email" placeholder="Your email"
						value="${fromEmail }" />
					<span class="input-group-addon" id="basic-addon">@</span>
				</div>

				<div style="margin-bottom: 15px;" class="input-group input-group-lg">
					<sft:errors path="subject" cssClass="warning error"></sft:errors>
					<sft:input type="text" path="subject" style="width:450px;"
						class="form-control" name="subject" placeholder="Subject" />
					<span class="input-group-addon" id="basic-addon"><span
						class="glyphicon glyphicon-user" aria-hidden="true"></span></span>
				</div>

				<div class="form-group form-group-lg">
					<sft:errors path="content" cssClass="warning error"></sft:errors>
					<sft:textarea path="content" placeholder="Your message"
						class="form-control" style="height:300px; width:500px;" />
				</div>
				<div class="form-group form-group-lg glyphicon-style">
					<button type="submit" class="btn btn-success btn-lg" name="submit">
						Send .<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
					</button>
				</div>
			</sft:form>
		</div>
	</div>
</div>
