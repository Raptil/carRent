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
            <a class="navbar-brand" href="mainLogOut.html">CarService</a>
            <ul class="nav nav-pills">
                <li class="pull-right">
                    <a href="/logout">Выход</a>
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
            <span class="sr-only">Назад/span>
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
                        <li>топливо на 100 км:${car.fuel100}</li>
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
                    <li>расстояние :${stMath.distance}</li>
                    <li>затраты на топливо :${stMath.costFuel}</li>
                    <li>комфорт :${stMath.comfortable}</li>
                    <li>рейтинг :${stMath.rating}</li>
                </ul>
            </div>

            <div class="container col-lg-12">
                <div class="row">
                    <span class="alert-danger">${message}</span>
                    <button href="/statisticsAdd" role="button" class="btn btn-sm btn-danger " data-target="#modalCar"
                            data-toggle="modal">Добавить статистику
                    </button>
                </div>
            </div>
            <div class="container col-lg-12">
                <form action="/bookIt/${car.id_car}" method="post">
                    <div class="form-group ">
                        <label for="DateStart1">Выберите начало аренды</label>
                        <input name="dateStart" type="date" class="form-control " id="DateStart1">
                    </div>
                    <div class="form-group ">
                        <label for="DateEnd1">Выберите окончание аренды</label>
                        <input name="dateEnd" type="date" class="form-control" id="DateEnd1">
                    </div>

                    <button class="btn btn-sm btn-danger" type="submit">Забронировать</button>
                </form>
            </div>
            <br>
            <div class="container col-lg-12">
                <c:forEach items="${comments}" var="comment">
                    <hr>${comment.description}</hr>
                </c:forEach>
            </div>
            <br>
            <div class="form-group container col-lg-12">
                <form action="/addComment/${car.id_car}" method="post">
                    <label for="TextArea1">Добавить комментарий</label>
                    <textarea rows="3" class="form-control" name="comment" id="TextArea1"></textarea>
                    <button class="btn btn-sm btn-danger" type="submit">Добавить</button>
                </form>
            </div>
        </div>
        <div class="container col-lg-4 pull-right">

            <c:forEach items="${carsCity}" var="cars">
                <div class="container  ">

                    <a href="/car/${cars.id_car}">
                        <img class="carPhoto" src="/resources/img/porshe.jpg"/>
                    </a>

                </div>
                <br>
            </c:forEach>

        </div>
    </div>
</div>

<div class="modal fade" id="modalCar">
    <form:form action="/statisticsAdd/${car.id_car}" method="post" modelAttribute="statistics">
        <div class="modal-dialog modal-sm   ">
            <div class="modal-header InLog">
                <button class="close" type="button" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Статистика</h4>
            </div>
            <div class="modal-body">

                <label>Расстояние</label>
                <form:input path="distance" type="text" class="form-control " id="Distance1" placeholder="Например, 500"
                            autofocus="true"></form:input>
                <label>Затраты на топливо</label>
                <form:input path="costFuel" type="text" class="form-control " id="costFuel1"
                            placeholder="Например, 1500"></form:input>
                <label>Комфорт</label>
                <form:input path="comfortable" type="text" class="form-control " id="comfortable1"
                            placeholder="Комфорт от 1 до 5"></form:input>
                <label>Рейтинг</label>
                <form:input path="rating" type="text" class="form-control " id="rating1"
                            placeholder="Рейтинг от 1 до 5"></form:input>
            </div>
            <div class="modal-footer InLog">
                <span class="bg-danger">${message}</span>
                <button class="btn btn-success" type="submit">Добавить</button>
            </div>
        </div>
    </form:form>
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
