<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <div class="container">

      <form class="form-signin" name="f" action="${pageContext.request.contextPath}/j_spring_security_check" method="POST">
        <h2 class="form-signin-heading">Please sign in</h2>
        <c:if test="${param.error != null}"> 
        
         <label ><span class="warning">Login failed check that your credentials are correct</span></label></c:if>
              
        
        <label for="inputEmail" class="sr-only">User</label>
        <input type="text" id="inputEmail" class="form-control" name="j_username" value="" placeholder="User name" />
        
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="j_password" class="form-control" placeholder="Password">
        
        <input class="btn btn-primary"  name="submit" type="submit" value="Login"/>
<!--         <button class="btn btn-lg btn-primary btn-block" name="submit" type="submit" value="Login">Sign in</button>
 -->      </form> <p><a href='<c:url value="/newaccount"/>'>Create new account</a></p>

    </div> <!-- /container --> --%>
    
   
  <div class="container">
  
  <div class="row" id="pwd-container">
    <div class="col-md-4"></div>
    
    <div class="col-md-4">
      <section class="login-form">
      
        <form method="POST" name="f" action="${pageContext.request.contextPath}/j_spring_security_check" role="login">
        
          <img src="http://i.imgur.com/RcmcLv4.png" class="img-responsive" alt="" />
          
          <input type="email" name="j_username" placeholder="Email" required class="form-control input-lg" value="" />
          
          <input type="password" class="form-control input-lg" id="password" name="j_password"  placeholder="Password" required="" />
          

          <div class="pwstrength_viewport_progress"></div>
          
          
          <button type="submit" name="go" value="login" class="btn btn-lg btn-primary btn-block">Sign in</button>
          <div>
            <a href='<c:url value="/newaccount"/>'>Create account</a> or <a href="#"></a>
          </div>
          
        </form>
        
        <div class="form-links">
          <a href="#">www.suddtech.net</a>
        </div>
      </section>  
      </div>
      
      <div class="col-md-4"></div>
      

  </div>
 
</div>