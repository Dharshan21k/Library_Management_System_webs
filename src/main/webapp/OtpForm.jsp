
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
            document.getElementById("otpForm").reset();
        }
    });
    
</script>

</head>
<body>
<h1>Verification User</h1><br>
<s:form id ="otpForm" action="otpregister" method="post">
 <s:textfield name="register.email" label="Enter email"/><br>
<s:textfield name="register.otp" label="Enter Otp"/><br>
  <s:submit value="Submit"/>
 </s:form>
</body>
</html>