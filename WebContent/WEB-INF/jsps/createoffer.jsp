<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ taglib prefix="sft" uri="http://www.springframework.org/tags/form" %>

	 <sft:form class="form-signin" method ="post" action="${pageContext.request.contextPath}/docreate" commandName="offer">
        <h2 class="form-signin-heading">Pace your order please</h2>
       <label for="inputName" class="col-sm-2 control-label"></label><br/><sft:errors path="name" cssClass="warning error"></sft:errors>
        <sft:input type="name" id="inputName" path="name" name="name" class="form-control" placeholder="Your name"></sft:input><%-- required autofocus --%>
       
        <label for="inputEmail" class="col-sm-2 control-label"></label><br/><sft:errors path="email" cssClass="warning error"></sft:errors>
        <sft:input type="email" id="inputEmail" path="email" name="email" class="form-control" placeholder="Email address"></sft:input><%-- required autofocus --%>
       
        <label for="inputTextErea" class="sr-only">Create advert</label><br/><sft:errors path="text" cssClass="warning error"></sft:errors>
        <sft:textarea id="inputTextErea" path="text" name="text" rows="3" class="form-control" placeholder="Your Text"></sft:textarea>
      
      
       <!--  <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div> -->
        
        <button class="btn btn-primary" type="submit" rolt="button">Create advert</button>
      </sft:form>
	<%@ include file="footer.jsp" %>
	
</body>
</html>