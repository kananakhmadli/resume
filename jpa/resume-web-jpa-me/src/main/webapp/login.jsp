<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
        <link rel="stylesheet" href="assets/css/users.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    </head>
    <body >
        <form action="login" method="POST">
            <div class="col-4 container login_fix">
                <center>
                    <h1>
                        Login:
                    </h1>
                </center>
                <div class="form-group">
                    <label>Email address</label>
                    <input type="email" class="form-control" placeholder="emil@gmail.com" name="email">
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-control" placeholder="password" name="password">
                </div>
                <button type="submit" class="btn btn-primary" name="login">Login</button>
            </div>
        </form>
    </body>
</html>
