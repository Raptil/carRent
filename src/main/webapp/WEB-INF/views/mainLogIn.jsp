
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Main Page</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/main.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="navbar ">
        <div class="navbar-inverse ">
            <a class="navbar-brand" href="mainLogOut.html">CarService</a>
            <ul class="nav nav-pills">
                <li class="pull-right">
                    <a href="/logout"  >Выход</a>
                </li>
                <li class="dropdown pull-right">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">
                        Профиль
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/profile">Профиль</a></li>
                        <li><a href="/newCar">Добавить транспорт</a></li>
                        <li><a href="/changeProfile">Изменить профиль</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>


<div class="container carMain">
    <div class="container tagline">
        <h2> Car for people from people.</h2>
        <h2>  Price cheep that price of official car company.</h2>
        <h2> GoodLuck.</h2>
    </div>
</div>
<div class="container text-center ">
    <a href="searchLogIn.html">Поиск транспорта</a>
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