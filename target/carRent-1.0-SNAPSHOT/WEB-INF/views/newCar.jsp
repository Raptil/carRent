
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

<div class="container addCar">

    <form:form name="/newCar" action="/newCar" modelAttribute="car" method="post">
        <div class="row">
            <div class="form-group col-lg-6">
                <label for="InputBodyType1">Введите тип кузова</label>
                <form:input  path="bodyType" type="text" class="form-control " id="InputBodyType1" placeholder="Например, седан"></form:input>
            </div>
            <div class="form-group col-lg-6">
                <label for="InputCity1">Введите название города</label>
                <form:input path="city" type="text" class="form-control" id="InputCity1" placeholder="Например, Воронеж"></form:input>
            </div>
            <div class="form-group  col-lg-6">
                <label for="InputColour1">Введите цвет</label>
                <form:input  path="colour" type="text" class="form-control" id="InputColour1" placeholder="Например, черный"></form:input>
            </div>
            <div class="form-group   col-lg-6">
                <label for="InputFuel1">Введите затраты топлива л/100км</label>
                <form:input path="fuel100" type="text" class="form-control" id="InputFuel1" placeholder="Например, 9"></form:input>
            </div>

            <div class="form-group  col-lg-6">
                <label for="InputModel1">Введите название модели</label>
                <form:input path="model" type="text" class="form-control" id="InputModel1" placeholder="Например, Volkswagen"></form:input>
            </div>
            <div class="form-group  col-lg-6">
                <label for="InputNumberOfDoc1">Введите номер свидетельства о ригестрации</label>
                <form:input path="numberOfDoc" type="text" class="form-control" id="InputNumberOfDoc1" placeholder="Например, 111111111"></form:input>
            </div>
            <div class="form-group  col-lg-6">
                <label for="InputPriceDay1">Введите стоимость аренды за день</label>
                <form:input path="priceDay" type="text" class="form-control" id="InputPriceDay1" placeholder="Например, 1500"></form:input>
            </div>
            <div class="form-group   col-lg-6">
                <label for="InputStateNumber1">Введите гос. номер</label>
                <form:input path="stateNumber" type="text" class="form-control" id="InputStateNumber1" placeholder="Например, а554ам136rus"></form:input>
            </div>
            <div class="form-group  col-lg-6">
                <label for="InputYearOld1">Введите год выпуска</label>
                <form:input path="yearsOld" type="text" class="form-control" id="InputYearOld1" placeholder="Например, 2006"></form:input>
            </div>
            <div class="form-group col-lg-6">
                <label for="InputOtherDescription1">Введите подробное описание</label>
                <form:input path="otherDescription" type="text" class="form-control" id="InputOtherDescription1" placeholder="Чтобы вы хотели дополнительно рассказать о транспорте?!"></form:input>
            </div>

            <div class="form-group col-lg-offset-4 col-lg 5  ">

                <input type="file" class="form-control" >
            </div>

            <button type="submit" class="btn-lg btn-success col-lg-3 col-lg-offset-5">Сохранить</button>
        </div>
    </form:form>

</div>
<br>

<footer class="navbar-fixed-bottom navbar-inverse addCar  ">
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