<%@page import="com.company.entity.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/users.css" >
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>Page</title>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="assets/js/users.js"></script>
    </head>
    <body >
        <%
            List<User> list = (List<User>) request.getAttribute("userList");

        %>
        <div class="container mycontainer">
            <div class="row">
                <div class="col-4">
                    <form action="users" method="GET">
                        <div  class="form-group">
                            <label for="name">name</label>
                            <input type="text" name="name" value="" class="form-control" placeholder="Enter name" >
                        </div>
                        <div  class="form-group">
                            <label for="surname">surname</label>
                            <input type="text" name="surname" class="form-control" placeholder="Enter surname">
                        </div>
                        <input type="submit" value="Search" class="btn btn-primary">
                    </form>
                </div >
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Nationality</th>
                    </tr>

                </thead>
                <tbody>
                    <%   for (User u : list) {
                    %>
                    <tr>
                        <td><%=u.getName()%></td>
                        <td><%=u.getSurname()%></td>
                        <td><%=u.getNationality().getName() == null ? "N/A" : u.getNationality().getName()%></td>
                        <td>

                            <input type="submit" value="delete" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal" onclick="setIdForDelete(<%=u.getId()%>)"> 

                        </td>
                        <td>
                            <form action="userdetail" method="GET">
                                <input type="hidden" name="id" value="<%=u.getId()%>">
                                <input type="hidden" name="action" value="update">
                                <input type="submit"  value="update" class="btn btn-secondary"> 
                            </form>
                        </td>
                        <td><form>
                                <input type="submit"  value="info" class="btn btn-info"> 
                            </form>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">DELETE</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Are you sure?
                    </div>
                    <div class="modal-footer">
                        <form action="userdetail" method="POST">
                            <input type="hidden" name="id" value="" id="idForDelete">
                            <input type="hidden" name="action" value="delete">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <input type="submit" class="btn btn-danger" value="Delete">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body> 
</html>
