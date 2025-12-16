<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Actions Page</title>
</head>
<body>

<s:form action="insertDataBook" method="post">
    <s:textfield name="book.title" label="Enter book tiltle" />
    <s:textfield name="book.author" label="Enter Book Author"/>
    <s:textfield name="book.publishedYear" label="Enter Published Year"/>
    <s:textfield name="book.genre" label="Enter genre"/>
    <s:submit value="Submit"/>
</s:form>




</body>
</html>
