<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Championship</title>

</head>
<body>
<h1>Race №1</h1><br />
<h2>Racers:</h2><br />
<c:forEach var="racer" items="${requestScope.racers}">
    <ul>
        <li>name: <c:out value="${racer.name}"/></li>
        <li>age: <c:out value="${racer.age}"/></li>
        <li>car model: <c:out value="${racer.car_Model}"/></li>
        <li>max speed: <c:out value="${racer.max_Speed}"/></li>

        <form method="post" action="<c:url value='/delete'/>">
            <input type="number" hidden name="id" value="${racer.id}" />
            <input type="submit" name="delete" value="delete"/>
        </form>

        <form method="get" action="<c:url value='/update'/>">
            <input type="number" hidden name="id" value="${racer.id}" />
            <input type="submit" value="edit"/>
        </form>
    </ul>
    <hr />

</c:forEach>

<h2>Registration</h2><br />

<form method="post" action="<c:url value='/add_racer'/>">

    <label><input type="text" name="name"></label>name<br>

    <label><input type="number" name="age"></label>age<br>

    <label><input type="text" name="car_Model"></label>car model<br>

    <label><input type="number" name="max_Speed"></label>max speed<br>

    <input type="submit" value="Ok" name="Ok"><br>
</form>
