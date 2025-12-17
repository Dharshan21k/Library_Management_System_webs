<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Actions Page</title>
    <script>
    window.addEventListener("pageshow", function (event) {
        if (event.persisted || performance.getEntriesByType("navigation")[0].type === "back_forward") {
            document.getElementById("Bookform").reset();
        }
    });
</script>
</head>

<body>

<s:form id="Bookform"   action="setborrow" method="post">
    <s:textfield name="bookName" label="Enter Book Tiltle"/>
    <s:textfield name="bb.rollNum"  label="Enter Book Roll Number"/>
    <s:textfield name="bb.borrowDate" label="Enter Borrow Date"/>
    <s:textfield name="bb.returnDate" label="Enter Return Date"/>
    <s:submit value="Submit"/>
</s:form>




</body>
</html>
