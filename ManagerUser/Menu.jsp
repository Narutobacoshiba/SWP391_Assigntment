<%-- 
    Document   : Menu
    Created on : Mar 10, 2022, 9:43:30 PM
    Author     : Son
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/menu.css" rel="stylesheet" type="text/css"/>
<div class="header">
    <div class="container">
        <div class="navbar">
            <div class="logo">
                <a href="Home.jsp"><img src="image/logo.jpg" width="125px"></a>
            </div>
            <nav>
                <ul id="MenuItems">
                    <li><a href="Home.jsp">Home</a></li>
                    <li><a href="AllProduct.jsp">Courses List</a></li>
                    <li><a href="">Manager</a></li>
                    <li><a href="Login.jsp">Login</a></li>
                </ul>
            </nav>
            <a href="cart.html"><img src="image/cart.png" width="30px" height="30px"></a>
            <img src="image/menu.png" class="menu-icon" 
                 onclick="menutoggle()">
        </div>
        <div class="row">
            <div class="col-2">
                <h1>Welcome to<br> SonMotorBike!</h1>
                <p>SonMotor chuyên mua bán các dòng xe motor thể thao phong phú của 
                    các hãng nổi tiếng: Honda, Yamaha, Suzuki,, DUCATI, Kawasaki... </p>
            </div>
            <div class="col-2">
                <img src="image/anhbiaa.jpg">
            </div>
        </div>
    </div>
</div>

