<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Дипломи</title>
    <meta charset="utf-8">
    <link
            href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
            crossorigin="anonymous">
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"
            rel='stylesheet' type='text/css'>
</head>
<body>
<!-- Header -->
<nav role="navigation" class="navbar navbar-default">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <button type="button" data-target="#navbarCollapse"
                data-toggle="collapse" class="navbar-toggle">
            <span class="sr-only">Toggle navigation</span> <span
                class="icon-bar"></span> <span class="icon-bar"></span> <span
                class="icon-bar"></span>
        </button>
        <a href="#" class="navbar-brand">Дипломи</a>
    </div>
    <!-- Collection of nav links and other content for toggling -->
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="/bachelors">Бакалаври</a></li>
            <li><a href="/specialists">Спеціалісти</a></li>
            <li><a href="/masters">Магістри</a></li>
            <li><a href="/search">Пошук</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Login</a></li>
        </ul>
    </div>
</nav>
<!-- Body -->
<c:url var="saveUpdateAction" value="/save"></c:url>
<div class="container">
    <c:if test="${!empty graduateWork.uuid}">
        <h2>Редагування</h2>
    </c:if>
    <c:if test="${empty graduateWork.uuid}">
        <h2>Створення</h2>
    </c:if>
    <form:form role="form" action="${saveUpdateAction}" method="POST"
               commandName="graduateWork">
        <div class="form-group row">
            <label class="col-sm-2 form-control-label" for="subject">Тема:</label>
            <form:input path="subject" type="text" class="form-control"
                        id="subject" required="true"/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 form-control-label" for="datepicker">Рік:</label>
            <form:input path="year" type="text" class="form-control"
                        id="datepicker" required="true"/>
        </div>
        <h3>Студент</h3>
        <div class="form-group row">
            <label class="col-sm-2 form-control-label" for="st_surname">Фамілія:</label>
            <form:input path="student.surname" type="text" class="form-control"
                        id="st_surname" required="true"/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 form-control-label" for="st_name">Ім'я:</label>
            <form:input path="student.firstName" type="text"
                        class="form-control" id="st_name" required="true"/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 form-control-label" for="st_patronymic">По
                батькові:</label>
            <form:input path="student.patronymic" type="text"
                        class="form-control" id="st_patronymic" required="true"/>
        </div>
        <fieldset class="form-group">
            <label lass="col-sm-2 form-control-label" for="degree_s">Ступінь</label>
            <form:select path="degree.id" id="degree_s" class="form-control">
                <c:forEach var="degr" items="${degress}">
                    <option value="${degr.id}">${degr.degreeName}</option>
                </c:forEach>
            </form:select>
        </fieldset>
        <fieldset class="form-group">
            <label lass="col-sm-2 form-control-label" for="cathedra_s">Кафедра</label>
            <form:select path="cathedra.id" id="cathedra_s" class="form-control">
                <c:forEach var="cathedra" items="${cathedras}">
                    <option value="${cathedra.id}">${cathedra.cathedraName}</option>
                </c:forEach>
            </form:select>
        </fieldset>
        <div class="form-group row">
            <label class="col-sm-2 form-control-label" for="st_group">Група:</label>
            <form:input path="group.groupName" type="text" class="form-control"
                        id="st_group"/>
        </div>
        <h3>Керівник</h3>
        <div class="form-group row">
            <label class="col-sm-2 form-control-label" for="hw_surname">Фамілія:</label>
            <form:input path="headWork.surname" type="text" class="form-control"
                        id="hw_surname"/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 form-control-label" for="hw_name">Ім'я:</label>
            <form:input path="headWork.firstName" type="text"
                        class="form-control" id="hw_name"/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 form-control-label" for="hw_patronymic">По батькові:</label>
            <form:input path="headWork.patronymic" type="text" class="form-control" id="hw_patronymic"/>
        </div>
        <br/>
        <fieldset class="form-group">
            <label for="file">Завантажити</label>
            <input type="file" class="form-control-file" id="file"/>
        </fieldset>
        <br/>
        <br/>
        <br/>
        <c:if test="${!empty graduateWork.uuid}">
            <button type="submit" class="btn btn-success">Оновити</button>
        </c:if>
        <c:if test="${empty graduateWork.uuid}">
            <button type="submit" class="btn btn-success">Зберегти</button>
        </c:if>
        <button type="submit" class="btn btn-danger">Назад</button>
    </form:form>
    <br/> <br/> <br/> <br/> <br/> <br/>
</div>
<!-- Footer -->
<div class="navbar-fixed-bottom row-fluid">
    <div class="navbar-inner">
        <div class="container"></div>
    </div>
</div>
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
        src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>