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
            <li><a href="/bachelors">Бакалаври</a></li>
            <li><a href="/specialists">Спеціалісти</a></li>
            <li><a href="/masters">Магістри</a></li>
            <li><a href="/search">Пошук</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <sec:authorize access="isAnonymous()">
                <li><a href="/login">Login </a></li>
                <li><a href="/registration">Registration </a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li><p></p></li>
                <li><a href="#>"><%= request.getUserPrincipal().getName() %>
                </a></li>
                <li style="margin-top: 15px;margin-right: 5px;"><form:form id="log_f"
                                                                           action="${pageContext.request.contextPath}/logout"
                                                                           method="POST">
                    <a href="javascript:;" title="logout"
                       onclick="document.getElementById('log_f').submit();">Logout</a>
                </form:form></li>
            </sec:authorize>
        </ul>
    </div>
</nav>
<!-- Body -->
<div class="container">
    <c:url var="searchAction" value="/search"></c:url>
    <form:form role="form" action="${searchAction}" commandName="searchDto" method="POST">
        <div class="form-group row">
            <label class="col-sm-2 form-control-label" for="textarea">Текст для пошуку:</label>
            <form:textarea path="searchText" class="form-control" id="textarea" rows="3"/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2">Тип пошуку</label>
            <div class="col-sm-10">
                <div class="radio">
                    <label> <form:radiobutton path="searchType" name="gridRadio1"
                                              id="gridRadios1" value="1" disabled="true" />Пошук за Темою
                    </label>
                </div>
                <div class="radio disabled">
                    <label> <form:radiobutton path="searchType" name="gridRadio2"
                                              id="gridRadios2" value="2" disabled="true"/> Пошук за ключовими словами
                    </label>
                </div>
                <div class="radio disabled">
                    <label> <form:radiobutton path="searchType" name="gridRadio3"
                                              id="gridRadios3" value="3" disabled="false" checked="true"/> Пошук за текстом робіт
                    </label>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-success">Пошук</button>
        <button type="button" onclick="history.go(-1);" class="btn btn-danger">Назад</button>
    </form:form>
    <br/>
    <c:if test="${!empty graduateWorkList}">
        <h2>Результат пошуку:</h2>
        <div class="row">
            <div class="col-md-29 col-md-offset-1">
                <div class="panel panel-default panel-table">
                    <div class="panel-body">
                        <table class="table table-striped table-bordered table-list">
                            <thead>
                            <tr>
                                <th><em class="fa fa-cog"></em></th>
                                <th>Тема</th>
                                <th>Студент</th>
                                <th>Факультет</th>
                                <th>Кафедра</th>
                                <th>Група</th>
                                <th>Керівник</th>
                                <th>Дата сдачі</th>
                                <th>Текст роботи</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${graduateWorkList}" var="graduateWork">
                                <tr>
                                    <td align="center">
                                        <a href="<c:url value='/edit/${graduateWork.uuid}' />"
                                           class="btn btn-default"><em
                                                class="fa fa-pencil"></em></a>
                                        <form:form action="/remove/${graduateWork.uuid}" method="post">
                                        <button type="submit" class="btn btn-danger"><em
                                                class="fa fa-trash"></em></button>
                                    </td>
                                    </form:form>
                                    <td>${graduateWork.subject}</td>
                                    <td>${graduateWork.student.surname}
                                            ${graduateWork.student.firstName}
                                            ${graduateWork.student.patronymic}</td>
                                    <td>${graduateWork.cathedra.faculty.facultyName}</td>
                                    <td>${graduateWork.cathedra.cathedraName}</td>
                                    <td>${graduateWork.group.groupName}</td>
                                    <td>${graduateWork.headWork.surname}
                                            ${graduateWork.headWork.firstName}
                                            ${graduateWork.headWork.patronymic}</td>
                                    <td>${graduateWork.protectionDate}</td>
                                    <td><a href="${graduateWork.selfHref}" target="_blank">${graduateWork.fileName}</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
</div>
<!-- Footer -->
<div id="footer">
    <div class="container"></div>
</div>
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
        src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>