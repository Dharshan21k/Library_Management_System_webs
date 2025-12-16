<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Actions Page</title>
</head>
<body>

<s:form action="StaffDataInsert" method="post">
    <s:textfield name="st.name" label="Enter Staff name"/>
    <s:textfield name="st.dateOfBirth" type="date" label="Enter Date of birth"/>
    <s:textfield name="st.bloodGroup" label="Enter Blood group"/>
    <s:textfield name="st.gender" label="Enter gender"/>
    <s:textfield name="st.email" label="Enter your email"/>
    <s:textfield name="st.phone" label="Enter your phone number"/>
    <s:textfield name="st.address" label="Enter your address"/>
    <s:textfield name="st.departmentName" label="Enter your department name"/>
    <s:textfield name="st.employedYear" label="Enter your emplloyed Year"/>
    
    <s:submit value="Submit"/>
</s:form>




</body>
</html>
