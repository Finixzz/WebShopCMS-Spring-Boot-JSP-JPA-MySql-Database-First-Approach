<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3 class="text-center text-white pt-5">Login</h3>
    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div id="login-box" class="col-md-12">
                    <form:form class="form"  method="POST" action="/login" modelAttribute="model">
                        <h3 class="text-center text-secondary">Login</h3>
                        <div class="form-group">
                            <form:label path="username" class="text-secondary">Username</form:label><br>
                            <form:input  path="username" type="text" class="form-control" autocomplete="off" required="required"/>
                        </div>
                        <div class="form-group">
                            <form:label path="password" class="text-secondary">Password</form:label><br>
                            <form:input  path="password" type="password" class="form-control" autocomplete="off" required="required"/>
                        </div>
                        

                        <button type="submit" class="btn btn-info btn-md">Login</button>
                        <a href="/home" class="btn btn-secondary btn-md">Back</a>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>