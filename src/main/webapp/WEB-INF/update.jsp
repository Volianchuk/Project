<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<div>Имя: <c:out value="${requestScope.car.id}"/> </div>
<div>Возраст: <c:out value="${requestScope.car.model}"/> </div>

<br />

<form method="post" action="<c:url value='/update'/>">

    <label>Новое имя: <input type="text" name="id" /></label><br>

    <input type="number" hidden name="id" value="${requestScope.car.id}"/>

    <input type="submit" value="Ok" name="Ok"><br>
</form>
</body>
</html>
