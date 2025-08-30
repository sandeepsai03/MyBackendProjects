<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<style>
    .error {
        color: red;
    }
</style>
</head>
<body>

<h1>Registration Form</h1>
<form:form action="/register" modelAttribute="user" method="post">
    <table>
        <tr>
            <td>Username:</td>
            <td><form:input path="uname" /></td>
            <td><form:errors path="uname" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><form:input path="pwd" /></td>
            <td><form:errors path="pwd" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><form:input path="email" /></td>
            <td><form:errors path="email" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Phone number:</td>
            <td><form:input path="phno" /></td>
            <td><form:errors path="phno" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Age:</td>
            <td><form:input path="age" /></td>
            <td><form:errors path="age" cssClass="error" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Register"></td>
        </tr>
    </table>
</form:form>

</body>
</html>
