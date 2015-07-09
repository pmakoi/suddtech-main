<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="sft" uri="http://www.springframework.org/tags/form" %>
<div class="container">
	 <sft:form class="form-signin" method ="post" action="${pageContext.request.contextPath}/docreate" commandName="offer">
        <h2 class="form-signin-heading">Place your order please</h2>
        
       <label for="inputUserName" class="col-sm-2 control-label"></label><br/><sft:errors path="username" cssClass="warning error"></sft:errors>
        <sft:input type="text" id="inputUserName" path="username" name="username" class="form-control" placeholder="Your name"></sft:input><%-- required autofocus --%>
       
        <%-- <label for="inputEmail" class="col-sm-2 control-label"></label><br/><sft:errors path="email" cssClass="warning error"></sft:errors>
        <sft:input type="email" id="inputEmail" path="email" name="email" class="form-control" placeholder="Email address"></sft:input>required autofocus
        --%>
        <label for="inputTextErea" class="sr-only">Create advert</label><br/><sft:errors path="text" cssClass="warning error"></sft:errors>
        <sft:textarea id="inputTextErea" path="text" name="text" rows="3" class="form-control" placeholder="Your Text"></sft:textarea>
      
      
       <!--  <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div> -->
        
        <button class="btn btn-primary" type="submit" rolt="button">Create advert</button>
      </sft:form>
	</div>