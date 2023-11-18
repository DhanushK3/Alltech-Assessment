<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Form</title>
</head>
<body>
    <h2>Employee Form</h2>
    <form action="save" method="post">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" value="${employee.firstName}">
        <br>
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" value="${employee.lastName}">
        <br>
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" value="${employee.email}">
        <br>
        <input type="hidden" name="id" value="${employee.id}">
        <input type="submit" value="Save">
    </form>
    <br>
    <a href="list">Back to Employee List</a>
</body>
</html>
