<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Actions Page</title>
    <script>
    window.addEventListener("pageshow", function (event) {
        if (event.persisted || performance.getEntriesByType("navigation")[0].type === "back_forward") {
            document.getElementById("StudentForm").reset();
        }
    });
</script>
</head>

<body>

<s:form  id=" StudentForm" action="datainsert" method="post">
    <s:textfield name="student.name" label="Enter Student name"/>
    <s:textfield name="student.dateOfBirth" type="date" label="Enter Date of birth"/>
    <s:textfield name="student.bloodGroup" label="Enter Blood group"/>
    <s:textfield name="student.gender" label="Enter gender"/>
    <s:textfield name="student.email" label="Enter your email"/>
    <s:textfield name="student.phone" label="Enter your phone number"/>
    <s:textfield name="student.address" label="Enter your address"/>
    <s:textfield name="student.departmentName" label="Enter your department name"/>
    <s:textfield name="student.enrolledYear" label="Enter your enrolled Year"/>
    
    <s:submit value="Submit"/>
</s:form>




</body>
</html>
