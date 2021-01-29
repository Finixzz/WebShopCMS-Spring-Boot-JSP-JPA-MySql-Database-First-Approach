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
	<div style="margin: 5% 10%;">
		<a style="margin:2% 0; width:100%" class="btn btn-secondary" href="/categories/new">ADD NEW CATEGORY</a>
	
		<table id="category-table" class="table">
		  <thead class="thead-danger" style="background-color:red;color:white;">
		    <tr>
		      <th scope="col">Id</th>
		      <th scope="col">Name</th>
		      <th scope="col">Gender</th>
		      <th scope="col">Action</th>      
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="model" items="${model}">
		  
			    <tr>
			      <td>${model.categoryId}</td>
			      <td>${model.name}</td>
			      <td>${model.gender}</td>
			      <td>
			      	<div style="display:flex; justify-content:space-around;">
				      	<a href="/categories/edit?categoryId=${model.categoryId}" class="btn btn-secondary">Edit</a>
				      	<form:form class="delete" method="POST" action="/categories/delete/${model.categoryId}"  data-categoryId="${model.categoryId}" path="categoryId" modelAttribute="model">
				  			<form:button type="submit" class="btn btn-danger">Delete</form:button> 		
				      	</form:form>
			      	</div>
			      	
			      </td>
			      
			      
			    </tr>
			</c:forEach>
			
		  </tbody>
		</table>
	</div>

</body>
</html>
<script>

$("document").ready(function(){
		 
	     
		 $(".delete").submit(function(e){
		 	e.preventDefault();
		 	let categoryId=$(this).attr("data-categoryId")
		 	$.ajax({
            url: "/api/items?categoryId="+categoryId,
            method: 'GET',
            success: (result) => {
					if(result.length==0){
						 if (window.confirm("Are you sure you want to delete this category?")) {
		                    this.submit();
		                }
					}else{
						alert("This category has referenced items. In order to delete this category please delete all related items");
					}
	            },
	            error: (error) => {
	                console.log(error);
	            }
		        });
			});
		 });
		
		 
		
   
</script>

<style>
#category-table tr{
text-align:center;
}
</style>