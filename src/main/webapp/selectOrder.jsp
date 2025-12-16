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
	<s:iterator value="ar" var="detail">
            Name:<s:property value="#detail[0]" />
		<br>
            total:<s:property value="#detail[1]" />
		<br>
          
               
		<br>
		<br>
		<br>
		<br>
	</s:iterator>

</body>
</html>