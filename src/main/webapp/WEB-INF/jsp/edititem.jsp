<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
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
    <div class="container" style="margin-bottom: 7%">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div id="login-box" class="col-md-12">
                    <form:form class="form"  method="POST" action="/items/edit" modelAttribute="model">
                        <h3 class="text-center text-secondary">Add new item </h3>
                        <div class="form-group">
                            <form:label path="name" class="text-secondary">Name</form:label><br>
                            <form:input value="${model.name}" path="name" type="text" class="form-control" autocomplete="off" required="required"/>
                        </div>
                        <div class="form-group">
                            <form:label path="unitPrice" class="text-secondary">Unit price</form:label><br>
                            <form:input value="${model.unitPrice}" path="unitPrice" type="float" class="form-control" autocomplete="off" required="required"/>
                        </div>
                        <div class="form-group">
                            <form:label path="description" class="text-secondary">Brief description</form:label><br>
						    <form:textarea value="${model.description}" path="description" class="form-control"  rows="3"></form:textarea>
						</div>
						
						<div class="form-group">
                            <form:label path="categoryId" class="text-secondary">Category</form:label>
                            <form:select  path="categoryId" class="form-control" required="required">
                               <option value="${model.categoryId}">${viewModel.categoryList.get(model.categoryId).getName()}</option>
                               <c:forEach var="categories" items="${viewModel.categoryList}">
                               		<c:if test="${categories.categoryId!=model.categoryId}">
	                               		<option value="${categories.categoryId}">${categories.name} |
	                               		
	                               		
	                               		<c:if test="${categories.gender=='M'}">
	                               			FOR HIM
	                               		</c:if>
	                               		<c:if test="${categories.gender=='F'}">
	                               			FOR HER
	                               		</c:if>
                               		</c:if>
                               </c:forEach>
                            </form:select>
                        </div>
						
						<div class="form-group">
                            <form:label path="sizeId" class="text-secondary">Size</form:label>
                            <form:select  path="sizeId" class="form-control" required="required">
                               	   <option value="${model.sizeId}">${viewModel.getSizeById(model.sizeId).getSize()}</option>
	                               <c:forEach var="sizes" items="${viewModel.sizeList}">
	                               		<c:if test="${sizes.sizeId!=model.sizeId}">
	                               			<option value="${sizes.sizeId}">${sizes.size} 
	                               			<c:if test="${sizes.size=='N/A'}">
	                               			| (Some accessories items don't have defined sizes)
	                               			</c:if>
	                               		</c:if>
	                               </c:forEach>
                            </form:select>
                        </div>
                        
                        <div class="form-group">
                            <form:label path="discountRate" class="text-secondary">Discount</form:label>
                            <form:select  path="discountRate" class="form-control">
                            	<c:if test="${model.isDiscounted==true}">
                            		<option value="${model.discountRate}">${model.discountRate}%</option>
                            	
                              		<c:forEach var="discounts" items="${viewModel.discountList}">
                              			<c:if test="${discounts!=model.discountRate}">
											<option value="discounts">${discounts}%</option>
                              			
                              			</c:if>
                              		</c:forEach>
                              		<option value=0>Remove discount</option>
	                            </c:if>
	                            <c:if test="${model.isDiscounted==false}">
	                               	<option value=0>Add discount</option>
                               		<option value="5">5% </option>
                               		<option value="10">10% </option>
                               		<option value="15">15% </option>
                               		<option value="20">20% </option>
                               		<option value="25">25% </option>
                               		<option value="30">30% </option>
                               		<option value="35">35% </option>
                               		<option value="40">40% </option>
                               		<option value="45">45% </option>
                               		<option value="50">50% </option>
	                            </c:if>
                            	
                               
                            </form:select>
                        </div>
                        
                        
                        <button type="submit" class="btn btn-info btn-md">Save changes</button>
                        <a href="/items/all" class="btn btn-secondary btn-md">Back</a>
                        <form:input value="${model.itemId}" path="itemId" type="hidden"/>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

</body>
</html>