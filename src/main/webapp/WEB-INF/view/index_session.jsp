<%--
  Author: Pavel Ravvich.
  Date: 14.10.17.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<h2>Hello from Fedorovs Little testing SESSION wtf app!</h2>
<h2>This is testing of "Session" exercise</h2>
<br />

<p><c:out value = "${requestScope.dataForView}"/></p>

<br />
<form method="post" action="">
    <input type="text" name="data" />
    <input type="submit" value="Send" />
</form>

</body>
</html>
