<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update User</title>
    </head>
    <body>
        <div>
            <form action="useraction" method="POST">
                <input type="hidden" name="action" value="add">
                <label for="name">Name </label>
                <input type="text" name="name" value="">
                <br>
                <label for="surname">Surname </label>
                <input type="text" name="surname" value="">
                <br>
                <label for="email">Email </label>
                <input type="text" name="email" value="">
                <br>
                <label for="phone">Phone </label>
                <input type="text" name="phone" value="">
                <br> 
                <label for="password">Password </label>
                <input type="text" name="password" value="">
                <br>
                <input type="submit" value="Save">
            </form>

        </div>

    </body>
</html>
