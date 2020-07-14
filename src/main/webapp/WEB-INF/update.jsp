
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>

<h2>Racer</h2><br />

<div>name: <c:out value="${requestScope.racer.name}"/> </div>
<div>age: <c:out value="${requestScope.racer.age}"/> </div>
<div>car model: <c:out value="${requestScope.racer.car_Model}"/> </div>
<div>max speed: <c:out value="${requestScope.racer.max_Speed}"/> </div>

<br />

<form method="post" action="<c:url value='/update'/>">

    <input type="number" hidden name="id" value="${requestScope.racer.id}"/>
    <label><input type="text" name="name" />name</label><br>

    <label><input type="text" name="age" />age</label><br>

    <label><input type="text" name="car_Model" />car model</label><br>

    <label ><input type="text" name="max_Speed" />max speed</label><br>

    <input type="submit" value="save" name="Save"><br>
</form>
</body>
</html>