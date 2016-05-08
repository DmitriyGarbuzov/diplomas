<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	language="java"%>
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
				<li><a href="/login">Login</a></li>
			</ul>
		</div>
	</nav>
	<!-- Body -->
	<div class="container">
		<form role="form" action="<c:url value="/search" />" method="POST">
			<div class="form-group row">
				<label class="col-sm-2 form-control-label" for="subject">Текст для поиска:</label>
				<textarea class="form-control" id="textarea" rows="3"></textarea>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">Тип поиска</label>
				<div class="col-sm-10">
					<div class="radio">
						<label> <input type="radio" name="gridRadios"
							id="gridRadios1" value="1" checked>Поиск по Темам
						</label>
					</div>
					<div class="radio">
						<label> <input type="radio" name="gridRadios"
							id="gridRadios2" value="2" disabled> Поиск по ключевым словам
						</label>
					</div>
					<div class="radio disabled">
						<label> <input type="radio" name="gridRadios"
							id="gridRadios3" value="3" disabled> Поиск по текстам робот
						</label>
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-success">Поиск</button>
			<button type="submit" class="btn btn-danger">Назад</button>
		</form>
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