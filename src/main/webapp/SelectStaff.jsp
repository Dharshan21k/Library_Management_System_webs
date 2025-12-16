<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Students</title>
</head>
<body>
	<s:iterator value="ar">
            StaffId:<s:property value="staffId" />
		<br>
            Student name:<s:property value="name" />
		<br>
            Date Of Birth:<s:property value="dateOfBirth" />
		<br>
            Blood Group:<s:property value="bloodGroup" />
		<br>
            Gender:<s:property value="gender" />
		<br>
           Roll Number:<s:property value="staffNum" />
		<br>
            Email: <s:property value="email" />
		<br>
              Phone NUmber:<s:property value="phone" />
		<br>
               Address:<s:property value="address" /><br>
               Department Name:<s:property value="departmentName"/><br>
               Enrolled Year:<s:property value="employedYear"/>
               
               
		<br>
		<br>
		<br>
		<br>
	</s:iterator>

</body>
</html>