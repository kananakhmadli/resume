<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Logout</title>
</head>
<body>
<div class="popup">
    <form action="logout" method="POST">
        <div class="popup-container">
            <h2>Logout</h2>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit">logout</button>
            <button id="close-popup" type="button">X</button>
        </div>
    </form>
</div>
<button type="button" id="opne-popup">Open</button>
<script src="<c:url value="/resources/js/main.js" />"></script>
</body>
</html>