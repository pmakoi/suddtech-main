<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ taglib prefix="sft" uri="http://www.springframework.org/tags/form" %>

	 <sft:form class="form-signin" method ="post" action="${pageContext.request.contextPath}/createacount" commandName="user">
	 
        <h2 class="form-signin-heading">Pace your order please</h2>
       <label for="inputName" class="col-sm-2 control-label"></label><br/><sft:errors path="username" cssClass="warning error"></sft:errors>
        <sft:input type="text" id="inputName" path="username" name="username" class="form-control" placeholder="User name"></sft:input><%-- required autofocus --%>
       
         <label for="inputPassword" class="col-sm-2 control-label"></label><br/><sft:errors path="password" cssClass="warning error"></sft:errors>
        <sft:input type="text" id="inputPassword" path="password" name="password" class="form-control" placeholder="Password"></sft:input><%-- required autofocus --%>
        <input type="text" id="inputPassword" name="confirmpassword" class="form-control" placeholder="Confirm password"></input><%-- required autofocus --%>
       
       
        <label for="inputEmail" class="col-sm-2 control-label"></label><br/><sft:errors path="email" cssClass="warning error"></sft:errors>
        <sft:input type="email" id="inputEmail" path="email" name="email" class="form-control" placeholder="Email address"></sft:input><%-- required autofocus --%>
       <%-- 
        <label for="inputTextErea" class="sr-only">Create advert</label><br/><sft:errors path="text" cssClass="warning error"></sft:errors>
        <sft:textarea id="inputTextErea" path="text" name="text" rows="3" class="form-control" placeholder="Your Text"></sft:textarea> --%>

        <button class="btn btn-primary" type="submit" rolt="button">Create advert</button>
      </sft:form>
	<%@ include file="footer.jsp" %>
	
</body>
</html>