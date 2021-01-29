<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
		<h3 class="text-center text-white pt-5">Edit item category</h3>
    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div id="login-box" class="col-md-12">
                    <form:form class="form"  method="POST" action="/categories/edit" modelAttribute="model">
                        <h3 class="text-center text-secondary">Edit item category</h3>
                        <div class="form-group">
                            <form:label  path="name" class="text-secondary">Category name</form:label><br>
                            <form:input value="${model.name}" path="name" type="text" class="form-control" autocomplete="off" required="required"/>
                        </div>
                        <div class="form-group">
                            <form:label path="gender" class="text-secondary">Gender</form:label>
                            <form:select  path="gender" class="form-control" required="required">
                             <c:if test="${model.gender=='M'}">
                             	<option value="M">Male</option>
                               	<option value="F">Female</option>
                             </c:if>
                              <c:if test="${model.gender=='F'}">
                             	 <option value="F">Male</option>
                                 <option value="M">Female</option>
                             </c:if>
                               
                            </form:select>
                        </div>
                        <form:input value="${model.categoryId}" path="categoryId" type="hidden"/>
                        <button type="submit" class="btn btn-info btn-md">Save changes</button>
                        <a href="/categories" class="btn btn-secondary btn-md">Back</a>
                    </form:form>
                </div>
            </div>
        </div>
</body>
</html>