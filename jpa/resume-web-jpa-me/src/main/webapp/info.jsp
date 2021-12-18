<%@page import="com.company.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page</title>
    </head>
    <body>
        <%
            User u = (User) request.getAttribute("user");
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(u.getBirthDate());
        %>
        <div>
            <div>
                <form action="users" method="GET">
                    <label for="Name">Name : </label><%=u.getName()%>
                    <br>
                    <label for="Surname">Surname : </label><%=u.getSurname()%>
                    <br>
                    <label for="Email">Email : </label><%=u.getEmail()%>
                    <br>
                    <label for="Phone">Phone : </label><%=u.getPhone()%>
                    <br>
                    <label for="Profile Description">Profile Description : </label><%=u.getProfileDesc()%>
                    <br>
                    <label for="Address">Address : </label><%=u.getAddress()%>
                    <br>
                    <label for="Birthday">Birthday : </label><%=u.getBirthDate()%>
                    <br>
                    <input type="submit" value="Back">
                </form>
            </div>
        </div>

    </body>
</html>
