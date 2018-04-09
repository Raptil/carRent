
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
<div class="container base">
    <div class="row">
        <div class="container col-lg-4 pull-left">
            <div class="container">
                <img src="/resources/img/avatar.png" class="img-polaroid ">
                <form action="/profile" method="get">
                  <ul>
                    <li>Имя :${user.name}</li>
                    <li>Фамилия :${user.lastName}</li>
                      <li>Город :${user.city}</li>
                      <li>Пол :${user.gender}</li>
                      <li>Возраст :${user.age}</li>
                      <li>Номер телефона :${user.phone}</li>
                      <li>Email :${user.email}</li>
                  </ul>
                </form>
            </div>
            <div class="container clear">

            </div>

        </div>
        <div class="container col-lg-8">
            <div class="container about col-lg-10">
                <p></p>
            </div>
            <div class="container col-lg-10">
                <div class="row">
                    <div>
                        <div id="accordion" class="panel-group">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a href="#collapse1" data-parent="#accordion" data-toggle="collapse">Transport</a>
                                    </h4>
                                </div>
                                <div id="collapse1"class="panel-collapse collapse in">
                                    <div class="panel-body">
                                        <c:forEach items="${cars}" var="car">
                                            <div class="container">
                                            <a href="/car/${car.id_car}"  data-toggle="collapse">${car.model}</a>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>


<footer class="navbar-fixed-bottom navbar-inverse  ">
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