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
    <div class="carousel slide  col-lg-offset-4 col-lg-4" id="homePhoto" data-ride="carousel">
        <ol class="carousel-indicators">
            <li class="active" data-target="#homePhoto" data-slide-to="0"></li>
            <li data-target="#homePhoto" data-slide-to="1"></li>
            <li data-target="#homePhoto" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="/resources/img/lada.jpg" width="100%" style="max-height: 500px;"/>
                <div class="carousel-caption">

                </div>
            </div>
            <div class="item">
                <img src="/resources/img/opel.jpg" width="100%" style="max-height: 500px; "/>
                <div class="carousel-caption">

                </div>
            </div>
            <div class="item">
                <img src="/resources/img/porshe.jpg" width="100%" style="max-height: 500px;"/>
                <div class="carousel-caption">

                </div>
            </div>

        </div>
        <a class="left carousel-control" role="button" data-slide="prev" href="#homePhoto">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Назад</span>
        </a>
        <a class="right carousel-control" role="button" data-slide="next" href="#homePhoto">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Вперед</span>
        </a>
    </div>
</div>
<br>
<div class="container">
    <div class="row">
        <div class="container col-lg-8 pull-left">
            <div class="container col-lg-12">
                <form action="/car/${car.id_car}">

                    <ul>
                        <li>модель :${car.model}</li>
                        <li>тип кузова :${car.bodyType}</li>
                        <li>цвет :${car.colour}</li>
                        <li>топливо на 100 км :${car.fuel100}</li>
                        <li>цена за день :${car.priceDay}</li>
                        <li>год выпуска :${car.yearsOld}</li>
                        <li>город :${car.city}</li>
                        <li>описание :${car.otherDescription}</li>
                    </ul>

                </form>

            </div>
            <br>
            <label>Статистика</label>
            <div class="container col-lg-12">
                <ul>
                    <li>расстояния :${stMath.distance}</li>
                    <li>затраты на топливо :${stMath.costFuel}</li>
                    <li>комфорт :${stMath.comfortable}</li>
                    <li>рейтинг :${stMath.rating}</li>
                </ul>
            </div>

            <br>
            <br>
            <div class="container col-lg-12">
                <label>Комментарии</label>
                <c:forEach items="${comments}" var="comment">
                    <hr>${comment.description}</hr>
                </c:forEach>
            </div>

        </div>

        <div class="container col-lg-4 pull-right">

            <div class="container  ">
                <a href="mainLogOut.html">
                    <img class="carPhoto" src="/resources/img/opel.jpg"/>
                </a>
            </div>
            <br>
            <div class="container  ">
                <a href="mainLogOut.html">
                    <img class="carPhoto" src="/resources/img/ferrari.jpg"/>
                </a>
            </div>
            <br>
            <div class="container  ">
                <a href="mainLogOut.html">
                    <img class="carPhoto" src="/resources/img/porshe.jpg"/>
                </a>
            </div>

        </div>
    </div>
</div>

<footer class="navbar--bottom navbar-inverse  ">
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
<script src="/resources/js/bootstrap.min.js"></script>

</body>
</html>

