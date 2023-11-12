<!-- removeContact.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Remove Contact</title>
</head>
<body>

<h2>Remove Contact</h2>

<form action="/removeContact" method="get">
    <label for="contactId">Contact ID:</label>
    <input type="text" id="contactId" name="contactId" required><br>

    <button type="submit">Remove Contact</button>
</form>

</body>
</html>
