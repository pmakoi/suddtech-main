<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">

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

    </div> <!-- /container -->
    
   
    <!-- 
    <html><head><title>Login Page</title></head><body onload='document.f.j_username.focus();'>
<h3>Login with Username and Password</h3><form name='f' action='/easyshop/j_spring_security_check' method='POST'>
 <table>
    <tr><td>User:</td><td><input type='text' name='j_username' value=''></td></tr>
    <tr><td>Password:</td><td><input type='password' name='j_password'/></td></tr>
    <tr><td colspan='2'><input name="submit" type="submit" value="Login"/></td></tr>
  </table>
 -->
