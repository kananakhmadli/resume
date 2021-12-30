<%--suppress ALL --%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <title>Page</title>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <link rel="shortcut icon" href="../../resources/java-brands.svg" type="image/x-icon">
    <link rel="shortcut icon" href="../../resources/java-brands.svg"/>
</head>
<body>
<div class="container mycontainer">
    <div class="row">
        <div class="col-4">
            <f:form action="usersm" method="GET" modelAttribute="user">
                <div class="form-group">
                    <label>name</label>
                    <f:input type="text" path="name" class="form-control" placeholder="Enter name"/>
                    <f:errors path="name"/>
                </div>
                <div class="form-group">
                    <label>surname</label>
                    <f:input type="text" path="surname" class="form-control" placeholder="Enter surname"/>
                    <f:errors path="surname"/>
                </div>
                <div class="form-group">
                    <label>email</label>
                    <f:input type="text" path="email" class="form-control" placeholder="Enter email"/>
                    <f:errors path="email"/>
                </div>
                <f:button type="submit" value="Search" class="btn btn-primary">Seacrh</f:button>
            </f:form>
        </div>
    </div>
    <table class="table">
        <caption>Tabe for Users</caption>
        <thead>
        <tr>
            <th id="name">Name</th>
            <th id="surname">Surname</th>
            <th id="email">Email</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="u">
            <tr>
                <td>${u.name}</td>
                <td>${u.surname}</td>
                <td>${u.email}</td>
                <td>
                    <input type="submit" value="delete" class="btn btn-danger" data-toggle="modal"
                           data-target="#exampleModal" onclick="setIdForDelete(${u.getId()})">
                </td>
                <td>
                    <form action="userdetail" method="GET">
                        <input type="hidden" name="id" value="${u.id}">
                        <input type="hidden" name="action" value="update">
                        <input type="submit" value="update" class="btn btn-secondary">
                    </form>
                </td>
                <td><input type="submit" value="info" class="btn btn-info"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">DELETE</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">Are you sure?</div>
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