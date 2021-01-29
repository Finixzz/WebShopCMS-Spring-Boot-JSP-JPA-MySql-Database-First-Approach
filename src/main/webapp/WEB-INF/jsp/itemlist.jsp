

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	 <c:if test="${model.size()==0}">
		 <div class="card" style="margin:5% 5%;">
	        <div class="card-body">
	            <h2 stlye="text-align:center;">Currenty there are no registred items. To add item, click on <i>ADD NEW ITEM</i></h2>
	        </div>
	    </div>
	 </c:if>
	  <c:if test="${model.size()!=0}">
	 
	 <div class="container" style="margin-top:1%; margin-bottom:1%;">
	 <div class="card" style="margin:5% 5%;">
        <div class="card-body">
			<a style="margin:2% 0; width:100%" class="btn btn-secondary" href="/items/new">ADD NEW ITEM</a>
        </div>
	    </div>
	        	<div class="row" style="display:flex; margin:0 auto; justify-content:center">	
	        	
					<c:forEach var="model" items="${model}">
						<div class="col-sm-3" style="margin: 1% 1%">
		                    <div style="padding:5px;" class="card " style="width: 18rem;">
		                        <div class="card-header text-white bg-warning mb-3 ">${model.item.name.toUpperCase()}</div>
		                        <a href="/items/edit?itemId=${model.item.itemId}"  class="btn btn-secondary card-header text-white bg-secondary mb-3" style="margin-top:-2%" >Edit</a>
								<form:form  class="delete" method="POST" action="/items/delete/${model.item.itemId}"  data-itemId="${model.item.itemId}" path="categoryId" modelAttribute="model">
				  					<form:button style="width:100%" type="submit" class="btn btn-danger">Delete</form:button> 		
				      			</form:form>		                        
		                        
		                        <div class="card-body">
		                        <div id="item-ul">
		                        	<a  class="btn btn-info b" >CATEGORY: ${model.category.name.toUpperCase()} </a>
		                        	<a  class="btn btn-info b" >GENDER: ${model.category.gender.toUpperCase()} </a>
		                        	<a  class="btn btn-info b" >SIZE: ${model.size.size.toUpperCase()}</a>
	                        	    <c:if test="${model.item.isDiscounted==true}">
	                        	 		<a  class="btn btn-info b" >INITIAL PRICE: ${model.item.unitPrice} $</a>
	                        	    </c:if>
		                        	
		                        	<p style="color:black;">${model.item.description}</p>
									
									<c:if test="${model.item.isDiscounted==true}">
							        <a   class="btn btn-danger" >${model.item.discountRate}% OFF</a>
							        </c:if>
									
									<c:if test="${model.item.isDiscounted==true}">
										<a  class="btn btn-danger b" >NEW PRICE: ${((model.item.unitPrice*((100-model.item.discountRate)*0.1))/10)} $</a>
									</c:if>
									<c:if test="${model.item.isDiscounted==false}">
	                        	 		<a  class="btn btn-danger b" >PRICE: ${model.item.unitPrice} $</a>
									</c:if>
		                        </div>
		                        </div>
		                    </div>
		                </div>
					</c:forEach>
					
				</div>
		   	 </div>		   	 
	 </c:if>
</body>
</html>


<script>

$("document").ready(function(){
		
		 $(".delete").submit(function(e){
		 	e.preventDefault();
		 	if (window.confirm("Are you sure you want to delete this item?"))
		 	{
		        this.submit();
		    }
		 	});
		 	
});
		
		 
		
   
</script>