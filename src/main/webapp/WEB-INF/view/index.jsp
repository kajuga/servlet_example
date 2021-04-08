<%--
  Author: Aleksandr Fedorov.
  Date: 08.04.21.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Hello from fedorovs.com!</h1><br />

<h2>Все пользователи</h2><br />
<%--перебор всех юзеров из list--%>
<c:forEach var="user" items="${requestScope.users}">
    <ul>
        <li>Имя: <c:out value="${user.name}"/></li>
        <li>Возраст: <c:out value="${user.age}"/></li>
    </ul>
    <hr />
</c:forEach>

<h2>Создание нового пользователя</h2><br />
<form method="post" action="">
    <label><input type="text" name="name"></label>Имя<br>
    <label><input type="number" name="age"></label>Возраст<br>
    <input type="submit" value="Ok" name="Ok"><br>
</form>

</body>
</html>