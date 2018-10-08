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
            <a class="navbar-brand" href="/mainLogOut">CarService</a>
            <ul class="nav nav-pills">
            </ul>
        </div>
    </div>
</div>
<div class="container">
    <form:form name="/registration" action="/registration" modelAttribute="user" method="post">

        <spring:bind path="name">
            <div class="form-group col-lg-offset-4 col-lg-5">
                <label for="InputName1">Введите ваше имя</label>
                <form:input path="name" type="text" class="form-control " id="InputName1"
                            placeholder="Например, Алексей"></form:input>
            </div>
        </spring:bind>
        <div class="form-group col-lg-offset-4 col-lg-5">
            <label for="InputSurname1">Введите вашу фамилию</label>
            <form:input path="lastName" type="text" class="form-control" id="InputSurname1"
                        placeholder="Например, Кривотулов"></form:input>
            <form:errors path="name"></form:errors>
        </div>
        <div class="form-group col-lg-offset-4 col-lg-5">
            <label for="InputAge1">Введите ваш возраст</label>
            <form:input path="age" type="text" class="form-control" id="InputAge1"
                        placeholder="Например, 22"></form:input>
        </div>
        <div class="form-group  col-lg-offset-4 col-lg-5">
            <label for="InputCity1">Введите город проживания</label>
            <form:input path="city" type="text" class="form-control" id="InputCity1"
                        placeholder="Например, Воронеж"></form:input>
        </div>
        <div class="form-group col-lg-offset-4 col-lg-5">
            <label for="InputEmail1">Выберите ваш пол</label>
            <div class="radio">
                <label>
                    <input type="radio" name="gender" id="Gender1" value="male" checked>
                    Муж
                </label>
            </div>
            <div class="radio">
                <label>
                    <input type="radio" name="gender" id="Gender2" value="feemale" checked>
                    Жен
                </label>
            </div>
        </div>
        <div class="form-group col-lg-offset-4 col-lg-5">
            <label for="InputDoc1">Введите номер водительских прав</label>
            <form:input path="numberOfDoc" type="text" class="form-control" id="InputDoc1"
                        placeholder="Например, 222222222"></form:input>
        </div>
        <div class="form-group col-lg-offset-4 col-lg-5">
            <label for="InputEmail1">Введите ваш Email</label>
            <form:input path="email" type="email" class="form-control" id="InputEmail1"
                        placeholder="Например, carService@gmail.com"></form:input>
        </div>
        <div class="form-group  col-lg-offset-4 col-lg-5">
            <label for="InputPassword1">Введите пароль</label>
            <form:input path="password" type="password" class="form-control" id="InputPassword1"
                        placeholder="Пароль"></form:input>
        </div>
        <div class="form-group col-lg-offset-4 col-lg-5">
            <label for="InputPassword2">Повторно введите пароль</label>
            <input type="password" class="form-control" id="InputPassword2" placeholder="Повторите пароль">
        </div>


        <button type="submit" class="btn-lg btn-success col-lg-3 col-lg-offset-5">Сохранить</button>
    </form:form>
</div>
<br>

<footer class="navbar-static-bottom navbar-inverse  ">
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
