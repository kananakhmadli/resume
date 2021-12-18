<%@page import="com.company.entity.User"%>
<%@page import="com.company.dao.inter.UserDaoInter"%>
<%@page import="com.company.Context"%>
<%@page import="com.company.dao.impl.UserDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update User</title>
    </head>
    <body>
        <%
            User u = (User) request.getAttribute("user");
        %>
        <div>
            <form action="useraction" method="POST">
                <input type="hidden" name="id" value="<%=u.getId()%>">
                <input type="hidden" name="action" value="update">
                <label for="Name">Name </label>
                <input type="text" name="name" value="<%=u.getName()%>">
                <br>
                <label for="Surname">Surname </label>
                <input type="text" name="surname" value="<%=u.getSurname()%>">
                <br>
                <label for="Email">Email </label>
                <input type="text" name="email" value="<%=u.getEmail()%>">
                <br>
                <label for="Phone">Phone </label>
                <input type="text" name="phone" value="<%=u.getPhone()%>">
                <br> <label for="Birthdate">Birth date </label>
                <input type="text" name="birthdate" value="<%=u.getBirthDate()%>">
                <br>
                <input type="submit" name="save" value="Save">
            </form>

        </div>

    </body>
</html>
