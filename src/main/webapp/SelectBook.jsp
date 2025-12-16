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
	<s:iterator value="ls">
            BookId:<s:property value="bookId" />
		<br>
            Book Title:<s:property value="title" />
		<br>
            author:<s:property value="author" />
		<br>
            published Year:<s:property value="publishedYear" />
		<br>
            genre:<s:property value="genre" />
		<br>
           available Copies:<s:property value="availableCopies" />
             
     
               
		<br>
		<br>
		<br>
		<br>
	</s:iterator>

</body>
</html>