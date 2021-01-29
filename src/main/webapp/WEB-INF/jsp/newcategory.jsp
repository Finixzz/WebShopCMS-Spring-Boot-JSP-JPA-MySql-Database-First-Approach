<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="_NavBar.jsp" %>
	<script>
		if($("#IsLogged").val()=="false")
			window.location.href="/home";
		
	</script>
	<h3 class="text-center text-white pt-5">Create new item category</h3>
    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div id="login-box" class="col-md-12">
                    <form:form class="form"  method="POST" action="/categories/save" modelAttribute="model">
                        <h3 class="text-center text-secondary">Add new item category</h3>
                        <div class="form-group">
                            <form:label path="name" class="text-secondary">Category name</form:label><br>
                            <form:input  path="name" type="text" class="form-control" autocomplete="off" required="required"/>
                        </div>
                        <div class="form-group">
                            <form:label path="gender" class="text-secondary">Gender</form:label>
                            <form:select  path="gender" class="form-control" required="required">
                               <option value="">Please assign gender to category</option>
                               <option value="M">Male</option>
                               <option value="F">Female</option>
                            </form:select>
                        </div>

                        <button type="submit" class="btn btn-info btn-md">Create</button>
                        <a href="/categories" class="btn btn-secondary btn-md">Back</a>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>