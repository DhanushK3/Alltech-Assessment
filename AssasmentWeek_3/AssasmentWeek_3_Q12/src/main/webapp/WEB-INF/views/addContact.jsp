<!-- addContact.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Contact</title>
</head>
<body>

<h2>Add Contact</h2>

<form action="/addContact" method="post">
    <label for="phoneNo">Phone Number:</label>
    <input type="text" id="phoneNo" name="phoneNo" required><br>

    <label for="fullAddress">Full Address:</label>
    <input type="text" id="fullAddress" name="fullAddress" required><br>

    <button type="submit">Add Contact</button>
</form>

</body>
</html>
