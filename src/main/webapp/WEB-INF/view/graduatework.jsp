<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="uk">
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
    <link
            href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.css"
            rel='stylesheet' type='text/css'>
    <style type="text/css">

        .content_hide {
            width: 100%;
            /* Full Width */
            height: 5px;
            margin: -20px 0px 50px 0px;
            background: #FFFFFF;
            display: none;
        }

        .content_visible {
            width: 100%;
            /* Full Width */
            height: 5px;
            margin: -20px 0px 50px 0px;
            background: #FFFFFF;
            display: block;
        }

        .expand {
            width: 100%;
            height: 1px;
            margin: 2px 0;
            background: #504A4B;
            position: absolute;
            box-shadow: 0px 0px 10px 1px rgba(229, 228, 226,0.7);
            -moz-animation: fullexpand 13s ease-out;
            -webkit-animation: fullexpand 13s ease-out;
        }

        /* Full Width Animation Bar */
        @-moz-keyframes fullexpand {
            0% { width: 0px;
            }

            100% {
                width: 100%;
            }
        }

        @-webkit-keyframes fullexpand {
            0% {
                width: 0px;
            }

            100% {
                width: 100%;
            };
        }
    </style>
    <script>
        function processSave() {
            document.getElementById("save").disabled = true;
            document.getElementById("back").disabled = true;
            document.getElementById('content').className = 'content_visible';
            document.getElementById('mainForm').submit();
        }
        function main() {
            document.getElementById('content').className = 'content_hide';
        }
        document.addEventListener("DOMContentLoaded", main);

    </script>
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
                <li style="margin-top: 15px;margin-right: 5px;"><form:form id="log_f" action="${pageContext.request.contextPath}/logout" method="POST">
                    <a href="javascript:;" title="logout"
                       onclick="document.getElementById('log_f').submit();">Logout</a>
                </form:form> </li>
            </sec:authorize>

        </ul>
    </div>
</nav>
<div id="content">
    <span class="expand"></span>
</div>
<!-- Body -->
<c:url var="saveUpdateAction" value="/save"></c:url>
<div class="container">
    <c:if test="${!empty graduateWork.uuid}">
        <h2>Редагування</h2>
    </c:if>
    <c:if test="${empty graduateWork.uuid}">
        <h2>Створення</h2>
    </c:if>
    <form:form id="mainForm" role="form" action="${saveUpdateAction}" method="POST"
               commandName="graduateWork" enctype="multipart/form-data">
        <c:if test="${!empty addEditErrorMess}">
            <div class="alert alert-danger fade in">
                <a href="#" class="close" data-dismiss="alert">&times;</a>
                <strong>Помилка!</strong> ${addEditErrorMess}
            </div>
        </c:if>
        <div class="form-group row">
            <label class="col-sm-2 form-control-label" for="subject">Тема:</label>
            <form:input path="subject" type="text" class="form-control"
                        id="subject" required="true"/>
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
                    <option value="${degr.id}" ${selectedDegree.id == degr.id ? 'selected="selected"' : ''} >${degr.degreeName}</option>
                </c:forEach>
            </form:select>
        </fieldset>
        <fieldset class="form-group">
            <label lass="col-sm-2 form-control-label" for="cathedra_s">Кафедра</label>
            <form:select path="cathedra.id" id="cathedra_s" class="form-control">
                <c:forEach var="cath" items="${cathedras}">
                    <option value="${cath.id}" ${selectedCathedra.id == cath.id ? 'selected="selected"' : ''} >${cath.cathedraName}</option>
                </c:forEach>
            </form:select>
        </fieldset>
        <div class="form-group row">
            <label class="col-sm-2 form-control-label" for="st_group">Група:</label>
            <form:input path="group.groupName" type="text" class="form-control"
                        id="st_group" required="true"/>
        </div>
        <h3>Керівник</h3>
        <div class="form-group row">
            <label class="col-sm-2 form-control-label" for="hw_surname">Фамілія:</label>
            <form:input path="headWork.surname" type="text" class="form-control"
                        id="hw_surname" required="true"/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 form-control-label" for="hw_name">Ім'я:</label>
            <form:input path="headWork.firstName" type="text"
                        class="form-control" id="hw_name" required="true"/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 form-control-label" for="hw_patronymic">По батькові:</label>
            <form:input path="headWork.patronymic" type="text" class="form-control" id="hw_patronymic" required="true"/>
        </div>
        <br/>

        <div class="form-group row">
            <label class="col-sm-2 form-control-label" for="norm_k">Дата нормоконтролю:</label>
            <div id="sandbox-container">
                <form:input path="controlOfNormsDate" id="norm_k" type="text" class="form-control" required="true"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 form-control-label" for="pre_zax">Дата предзахисту:</label>
            <div id="sandbox-container">
                <form:input path="preProtectionDate" id="pre_zax" type="text" class="form-control" required="true"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 form-control-label" for="zax">Дата захисту:</label>
            <div id="sandbox-container">
                <form:input path="protectionDate" id="zax" type="text"  class="form-control" required="true"/>
            </div>
        </div>
        <c:if test="${!empty graduateWork.fileName and !empty graduateWork.selfHref}">
            <div class="form-group row">
                <label class="col-sm-2 form-control-label" for="fileHref">Завантажений файл:</label>
                <label class="col-sm-2 form-control-label" id="fileHref"><a
                        href="${graduateWork.selfHref}" target="_blank">${graduateWork.fileName}</a></label>
            </div>
        </c:if>
        <fieldset class="form-group">
            <label for="file">Завантажити</label>
            <input type="file" class="form-control-file" id="file" name="file"/>
        </fieldset>
        <br/>
        <br/>
        <br/>
        <c:if test="${!empty graduateWork.uuid}">
            <form:hidden path="uuid"/>
            <button id="save" type="submit" onclick="processSave()" class="btn btn-success">Оновити</button>
        </c:if>
        <c:if test="${empty graduateWork.uuid}">
            <button id="save" type="submit" onclick="processSave()" class="btn btn-success">Зберегти</button>
        </c:if>
        <button id="back" type="button" onclick="history.go(-1);" class="btn btn-danger">Назад</button>
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
<script
        src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>

<script>
    $('#sandbox-container input').datepicker({
        autoclose: true
    });

    $('#sandbox-container input').on('show', function (e) {
        console.debug('show', e.date, $(this).data('stickyDate'));

        if (e.date) {
            $(this).data('stickyDate', e.date);
        }
        else {
            $(this).data('stickyDate', null);
        }
    });

    $('#sandbox-container input').on('hide', function (e) {
        console.debug('hide', e.date, $(this).data('stickyDate'));
        var stickyDate = $(this).data('stickyDate');

        if (!e.date && stickyDate) {
            console.debug('restore stickyDate', stickyDate);
            $(this).datepicker('setDate', stickyDate);
            $(this).data('stickyDate', null);
        }
    });</script>
</body>