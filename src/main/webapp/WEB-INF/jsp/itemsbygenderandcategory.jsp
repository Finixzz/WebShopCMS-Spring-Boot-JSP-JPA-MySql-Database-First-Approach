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
	 <c:if test="${model.size()==0}">
		 <div class="card" style="margin:5% 5%;">
	        <div class="card-body">
	            <h2 stlye="text-align:center;">Currenty there are no registred items for this category</h2>
	        </div>
	    </div>
	 </c:if>
	 
	 <c:if test="${model.size()!=0}">
	 
	 <div class="container" style="margin-top:1%; margin-bottom:1%;">
	 <div class="card" style="margin:5% 5%;">
        <div class="card-body">
            <h2 stlye="text-align:center;">ITEMS BY <i>${model[0].category.name.toUpperCase()}</i> CATEGORY </h2>
        </div>
	    </div>
	        	<div class="row" style="display:flex; margin:0 auto; justify-content:center">	
					<c:forEach var="model" items="${model}">
					
						<div class="col-sm-3" style="margin: 1% 1%">
		                    <div class="card " style="width: 18rem;">
		                        <div class="card-header text-white bg-warning mb-3 ">${model.item.name.toUpperCase()}</div>
		                        
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

<style>
#item-ul .b
 {
 	margin:1% 0;
 }
.button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
}
</style>