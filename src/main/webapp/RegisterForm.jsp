
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<script>
    window.addEventListener("pageshow", function (event) {
        if (event.persisted || performance.getEntriesByType("navigation")[0].type === "back_forward") {
            document.getElementById("registerForm").reset();
        }
    });
</script>
</head>
<body>
<h1>Register Here</h1><br>
<s:form id ="registerForm" action="dataregister" method="post">
 <s:textfield name="register.userName" label="create Username"/><br>
 <s:textfield name="register.email" label="create email"/><br>
 <s:textfield name="register.password" label="create password"/>
  <s:submit value="Submit"/>
 </s:form>
</body>
</html>