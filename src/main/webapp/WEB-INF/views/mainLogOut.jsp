
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Main Page</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/main.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>

<div class="container">
    <div class="navbar ">
        <div class="navbar-inverse ">
            <a class="navbar-brand" href="../mainLogOut.html">CarService</a>
            <ul class="nav nav-pills">
                <li class="pull-right">
                    <a href="#" role="button" class="btn " data-toggle="modal" data-target="#modal-1">Войти</a>
                </li>
                <li class="pull-right"><a href="../registration.html">Регистрация</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="modal fade" id="modal-1">
    <form action="${contextPath}/login" method="post" >
    <div class="modal-dialog modal-sm   ">
        <div class="modal-header InLog">
            <button class="close" type="button" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Войти</h4>
        </div>
        <div class="modal-body">

            <input name="email" type="text" class="form-control " id="Email1" placeholder="Email" autofocus="true"></input>
            <input  name="password" type="password" class="form-control " id="Password1" placeholder="пароль"></input>
        </div>
        <div class="modal-footer InLog">
            <a href="registration.html">Регистрация</a>
            <button class="btn btn-default" type="submit">Войти</button>
        </div>
    </div>
    </form>
</div>

<div class="container carMain">
    <div class="container tagline">
        <h2> Транспорт людям.</h2>
        <h2> Дешевле чем у официальных компаний.</h2>
        <h2> Удачи.</h2>
    </div>
</div>
<div class="container text-center ">
    <a href="searchLogOut.html"><h3>Поиск транспорта</h3></a>
</div>

<div class="container " >
    <h3>Новый транспорт</h3>
    <div class="row">
        <c:forEach items="${cars}" var="car">
        <div class="container col-lg-3 ">

            <a href="/car/${car.id_car}">
                <img class="carPhoto" src="/resources/img/opel.jpg" />
            </a>

        </div>
        </c:forEach>

    </div>
</div>
<div class="container reccomendation" >
    <h3>Рекомендованный транспорт</h3>
    <div class="row">
        <c:forEach items="${carsRec}" var="carRec">
            <div class="container col-lg-3 ">

                <a href="/car/${carRec.id_car}">
                    <img class="carPhoto" src="/resources/img/ferrari.jpg" />
                </a>

            </div>
        </c:forEach>

    </div>
</div>
<div class="container instruction">

</div>
<footer class="navbar-static-bottom navbar-inverse  ">
    <div class="container ">
        <div class="row end">

            <div class="col-lg-3"><small>&copy; CarService</small></div>
            <div class="col-lg-3"><p>8-9525152</p></div>
            <div class="col-lg-3"><p>8-9525152</p></div>
            <div class="col-lg-3"><p>8-9525152</p></div>
        </div>
    </div>
</footer>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>