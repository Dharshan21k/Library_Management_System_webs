<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

</head>
<body>
<h1>Login Here</h1><br>
<s:form action="datalogin" method="post">

 <s:textfield name="register.email" label="Enter email"/><br>
 <s:textfield name="register.password" label="Enter password"/>
  <s:submit value="Submit"/>
 </s:form>
</body>
</html>