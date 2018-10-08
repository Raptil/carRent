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
    <form action="${contextPath}/login" method="post">
        <div class="modal-dialog modal-sm   ">
            <div class="modal-header InLog">
                <button class="close" type="button" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Войти</h4>
            </div>
            <div class="modal-body">

                <input name="email" type="text" class="form-control " id="Email1" placeholder="Email"
                       autofocus="true"></input>
                <input name="password" type="password" class="form-control " id="Password1"
                       placeholder="пароль"></input>
            </div>
            <div class="modal-footer InLog">
                <a href="registration.html">Регистрация</a>
                <button class="btn btn-default" type="submit">Войти</button>
            </div>
        </div>
    </form>
</div>
<div class="container">
    <form:form class="filter" action="/searchLogOut/search" modelAttribute="carFilter" method="get">


        <div class="row">
            <div class="form-group  col-lg-3">
                <label for="City1">Город</label>
                <form:input path="city" type="text" class="form-control " id="City1" placeholder="City"></form:input>
            </div>
            <div class="form-group  col-lg-3">
                <label for="MaxCost1">Максимальная стоимость</label>
                <form:input path="maxPrice" type="text" class="form-control " id="MaxCost1"
                            placeholder="10000"></form:input>
            </div>
            <div class="form-group col-lg-3">
                <label for="MinCost1">Минимальная стоимость</label>
                <form:input path="minPrice" type="text" class="form-control " id="MinCost1"
                            placeholder="0"></form:input>
            </div>
            <div class="form-group col-lg-3">
                <label for="Model1">Модель</label>
                <form:input path="model" type="text" class="form-control " id="Model1" placeholder="0"></form:input>
            </div>
            <div class="form-group col-lg-3">
                <label for="BodyType1">Тип кузова</label>
                <form:input path="bodyType" type="text" class="form-control " id="BodyType1"
                            placeholder="0"></form:input>
            </div>
            <div class="form-group col-lg-3">
                <label for="MinFuel1">Минимальное потребление топлива</label>
                <form:input path="minFuel" type="text" class="form-control " id="MinFuel1" placeholder="0"></form:input>
            </div>
            <div class="form-group col-lg-3">
                <label for="MaxFuel1">Максимальное потребление топлива</label>
                <form:input path="maxFuel" type="text" class="form-control " id="MaxFuel1" placeholder="0"></form:input>
            </div>


        </div>
        <button type="search" class="btn-lg btn-success col-lg-4 col-lg-offset-4">Поиск</button>

    </form:form>
</div>
<div class="container">
    <c:forEach items="${cars}" var="car">

        <br>
        <div class="container">

            <div class="catalog clearfix">

                <img class="carPhotoSearch col-lg-3" src="/resources/img/lada.jpg">
                <a href="/car/${car.id_car}"><h2>${car.model}</h2></a>
                <h3> ${car.city} </h3>
                <h3>${car.bodyType}</h3>
            </div>

        </div>
    </c:forEach>
</div>
<footer class="navbar-fixed-bottom navbar-inverse  ">
    <div class="container ">
        <div class="row end">

            <div class="col-lg-3">
                <small>&copy; CarService</small>
            </div>
            <div class="col-lg-3"><p>8-9525152</p></div>
            <div class="col-lg-3"><p>8-9525152</p></div>
            <div class="col-lg-3"><p>8-9525152</p></div>
        </div>
    </div>
</footer>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>