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
	<h3 class="text-center text-white pt-5">Create new item</h3>
    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div id="login-box" class="col-md-12">
                    <form:form class="form"  method="POST" action="/items/save" modelAttribute="model">
                        <h3 class="text-center text-secondary">Add new item </h3>
                        <div class="form-group">
                            <form:label path="name" class="text-secondary">Name</form:label><br>
                            <form:input  path="name" type="text" class="form-control" autocomplete="off" required="required"/>
                        </div>
                        <div class="form-group">
                            <form:label path="unitPrice" class="text-secondary">Unit price</form:label><br>
                            <form:input  path="unitPrice" type="float" class="form-control" autocomplete="off" required="required"/>
                        </div>
                        <div class="form-group">
                            <form:label path="description" class="text-secondary">Brief description</form:label><br>
						    <form:textarea path="description" class="form-control"  rows="3"></form:textarea>
						</div>
						
						<div class="form-group">
                            <form:label path="categoryId" class="text-secondary">Category</form:label>
                            <form:select  path="categoryId" class="form-control" required="required">
                               <option value="">Please assign category to item</option>
                               <c:forEach var="categories" items="${viewModel.categoryList}">
                               		<option value="${categories.categoryId}">${categories.name} |
                               		<c:if test="${categories.gender=='M'}">
                               			FOR HIM
                               		</c:if>
                               		<c:if test="${categories.gender=='F'}">
                               			FOR HER
                               		</c:if>
                               		
                               		
                               </c:forEach>
                            </form:select>
                        </div>
						
						<div class="form-group">
                            <form:label path="sizeId" class="text-secondary">Size</form:label>
                            <form:select  path="sizeId" class="form-control" required="required">
                               <option value="">Please assign item size</option>
                               <c:forEach var="sizes" items="${viewModel.sizeList}">
                               		<option value="${sizes.sizeId}">${sizes.size} 
                               		<c:if test="${sizes.size=='N/A'}">
                               			| (Some accessories items don't have defined sizes)
                               		</c:if>
                               		
                               		
                               		
                               </c:forEach>
                            </form:select>
                        </div>

                        <button type="submit" class="btn btn-info btn-md">Create</button>
                        <a href="/items/all" class="btn btn-secondary btn-md">Back</a>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>