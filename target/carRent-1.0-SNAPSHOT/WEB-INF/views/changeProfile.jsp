
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

<div class="container">
    <form action="/changeProfile/${user.id_user}"  method="post">
        <div class="container col-lg-4 pull-right">

            <img src=".." class="img-polaroid ">

            <div class="form-group ">
                <label src="/resources/img/avatar.png" for="InputImg">Загрузить изображение</label>
                <input type="file" id="InputImg">
            </div>
        </div>
        <div class="container col-lg-8">

            <div class="form-group col-lg-offset-4 col-lg-5">
                <label for="InputName1">Введите имя</label>
                <input path="name" type="text" class="form-control " name="name" id="InputName1"value="${user.name}"placeholder="${user.name}" ></input>
            </div>
            <div class="form-group col-lg-offset-4 col-lg-5">
                <label for="InputSurname1">Введите фамилию</label>
                <input path="lastName" type="text" class="form-control" name="lastName" id="InputSurname1" value="${user.lastName}" placeholder="${user.lastName}"></input>
            </div>
            <div class="form-group col-lg-offset-4 col-lg-5">
                <label for="InputAge1">Введите возраст</label>
                <input path="age" type="text" class="form-control" name="age" id="InputAge1" value="${user.age}" placeholder="${user.age}"></input>
            </div>
            <div class="form-group  col-lg-offset-4 col-lg-5">
                <label for="InputCity1">Введите город</label>
                <input path="city" type="text" class="form-control" name="city" id="InputCity1" value="${user.city}" placeholder="${user.city}"></input>
            </div>
            <div class="form-group  col-lg-offset-4 col-lg-5">
                <label for="InputPhone1">Введите мобильный телефон</label>
                <input path="phone" type="text" class="form-control"  name="phone" id="InputPhone1" value="${user.phone}" placeholder="${user.phone}"></input>
            </div>
            <div class="form-group col-lg-offset-4 col-lg-5">
                <label for="InputEmail1">Выберите пол</label>
                <div class="radio">
                    <label>
                        <input type="radio" name="gender" id="Gender1" value="Male" checked>
                        Муж
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="gender" id="Gender2" value="Feemale" checked>
                        Жен
                    </label>
                </div>
            </div>
            <div class="form-group col-lg-offset-4 col-lg-5">
                <label for="InputEmail1">Введите Email</label>
                <input path="email" type="email" class="form-control" name="email" id="InputEmail1" value="${user.email}" placeholder="${user.email}"></input>
            </div>
            <div class="form-group  col-lg-offset-4 col-lg-5">
                <label for="InputPassword1">Введите пароль</label>
                <input  path="password" type="password" class="form-control" name="password" id="InputPassword1" value="Password" placeholder="Password"></input>
            </div> <div class="form-group col-lg-offset-4 col-lg-5">
            <label for="InputPassword2">Подтвердите пароль</label>
            <input type="password" class="form-control" id="InputPassword2" placeholder="Password">
        </div>




        </div>
        <button type="submit" class="btn-lg btn-success col-lg-3 col-lg-offset-5">Сохранить</button>
    </form>
</div>
<br>

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