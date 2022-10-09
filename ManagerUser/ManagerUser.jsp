<%-- 
    Document   : Manager
    Created on : Mar 8, 2022, 9:37:34 PM
    Author     : Son
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>User Manager</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <script src="js/manager.js" type="text/javascript"></script>
        <link href="css/paging.css" rel="stylesheet" type="text/css"/>
        <script >

            function funtion(id){
            if (confirm("Are u sure to delete ?")){
            window.location = "delete?pid=" + id;
            }
            }
        </script>
        <style>
            img{
                width: 300px;
                height: 150px;
            }
            table.table td:last-child i {
                color: black;
            }
            .table-title .btn{
                background-color: black;
            }
            .margin-left-10px{
                margin-left: 10px;
            }
        </style>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Manager User</h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addEmployeeModal"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>                          						
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>                          
                            <th>ID</th>
                            <th>Name</th>
                            <th>Image</th>
                            <th>Price</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listP}" var="o">
                            <tr>
                                <td>${o.id}</td>
                                <td>${o.name}</td>
                                <td>
                                    <img src="image/${o.image}">
                                </td>
                                <td>${o.price} $</td>
                                <td>
                                    <a href="load?uid=${o.id}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                    <button> <a href="#" onclick="funtion('${o.id}')" class="delete" data-toggle="modal">Delete</a></button>                                                                
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <c:set var="page" value="${requestScope.page}" />
                <div class="pag"> 
                    <c:forEach begin="1" end="${requestScope.num}" var="i">
                        <a class="${i==page?"active":""}" href="manager?page=${i}">${i}</a>              
                    </c:forEach>
                </div>

            </div>
        </div>
        <!-- Edit Modal HTML -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="insert" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="form-group margin-left-10px" >
                            <label>Title</label>
                            <input name="title" type="text" class="form-control" required>
                        </div>
                        <div class="form-group margin-left-10px">
                            <label>Name product</label>
                            <input name="name" type="text" class="form-control" required>
                        </div>
                        <div class="form-group margin-left-10px">
                            <label>Detail</label>
                            <input name="detail" type="text" class="form-control" required>
                        </div>
                        <div class="form-group margin-left-10px">
                            <label>Price</label>
                            <textarea name="price" class="form-control" required></textarea>
                        </div>
                        <div class="form-group margin-left-10px">
                            <label>Image</label>
                            <textarea name="image" class="form-control" required></textarea>
                        </div>
                        <div class="form-group margin-left-10px">
                            <label>Category</label>
                            <select name="category" class="form-select" aria-label="Default select example">
                                <c:forEach items="${listC}" var="o">
                                    <option value="${o.cid}">${o.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="Add">
                </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Edit Modal HTML -->
    <div id="editEmployeeModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <form>
                    <div class="modal-header">						
                        <h4 class="modal-title">Update Employee</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">					
                        <div class="form-group">
                            <label>Name</label>
                            <input type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Address</label>
                            <textarea class="form-control" required></textarea>
                        </div>
                        <div class="form-group">
                            <label>Phone</label>
                            <input type="text" class="form-control" required>
                        </div>					
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                        <input type="submit" class="btn btn-info" value="Save">
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>