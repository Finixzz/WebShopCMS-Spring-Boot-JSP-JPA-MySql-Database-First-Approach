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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
	<input type="hidden" id="IsLogged" value="${IsAuthenticated}false">
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main_nav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="main_nav">
                <ul class="navbar-nav">
                    <li class="nav-item active"> <a href="/home" class="nav-link">HOME </a> </li>
                    <c:if test="${IsAuthenticated==true}">
                		<li class="nav-item active"> <a class="nav-link">Welcome ADMINISTRATOR</a> </li>	
                	</c:if>
                </ul>
                
                <ul class="navbar-nav ml-auto">
                   
                   	<li class="nav-item active"> <a class="nav-link" href="/home#about">ABOUT</a> </li>
										
					
                    <li  class="nav-item dropdown">
                        <a class="nav-link  dropdown-toggle" href="#" data-toggle="dropdown"> MEN </a>
                        <ul id="men-categories" class="dropdown-menu dropdown-menu-right">
							
						
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link  dropdown-toggle" href="#" data-toggle="dropdown"> WOMEN </a>
                        <ul id="women-categories" class="dropdown-menu dropdown-menu-right">
							
						
                        </ul>
                    </li>
                    
                    <li class="nav-item active"> <a class="nav-link" href="/home#discounts">DISCOUNTS</a></li>
                    
                    
                    <c:if test="${IsAuthenticated==true}">
	                    <li class="nav-item dropdown">
	                        <a class="nav-link  dropdown-toggle" href="#" data-toggle="dropdown"> MANAGE </a>
	                        <ul  class="dropdown-menu dropdown-menu-right">
								   <li><a class="dropdown-item" style="justify-content:center" href="/items/all"> Items</a></li>
								   <li><a class="dropdown-item" style="justify-content:center" href="/categories"> Categories</a></li>
								   <li>
									   
									   		<form style="justify-content:center" method="POST" action="/home/logot">
			                                    <button class="btn btn-secondary" style="width:100%;">
			                                        Logout
			                                    </button>
			                                </form>
									 
								   </li>
								
							
	                        </ul>
	                    </li>
                     </c:if>
                    
                </ul>
            </div> <!-- navbar-collapse.// -->
        </nav>
</body>
</html>
<style>
html {
  scroll-behavior: smooth;
}
#men-categories a,#women-categories a{
	margin:4% 4%;
	padding:5px 5px;
	color:gray;
	text-decoration:none;
	font-size:15px;
	word-spacing:10px;
	text-align:center;
}

#men-categories li,#women-categories li{
	margin:5px 5px;
	 cursor:pointer;
  	text-align:center;
  		height:5%;
  	font-weight:bold;
}

#men-categories li:hover,#women-categories li:hover {
  background-color: rgb(245, 245, 245);
  cursor:pointer;
  	text-align:center;
  
}
</style>

<script>
	$("document").ready(function(){
	
		
	
		 function createLiElement (category) {
		 	let href="/items?gender="+category.gender+"&categoryId="+category.categoryId;
		 	
		 	
		 	var li = document.createElement("li");
		 	
		 	var ancor=document.createElement("a");
		 	ancor.innerText=category.name;
		 	ancor.class="dropdown-item";
		 	ancor.href=href;
		 	
		 	
		 	li.appendChild(ancor);
		 	
		 	
		 	
		 	
		 	return li;
		 	
		 	
		 	
		 	
		 	return li;
            

        }
		
		 $.ajax({
            url: "/api/categories",
            method: 'GET',
            success: (result) => {

                for(let i=0;i<result.length;i++)
                {
                	if(result[i].gender==="M")
                	{
                		$("#men-categories").append(createLiElement(result[i]));
                	}
                	else
                	{
                	    $("#women-categories").append(createLiElement(result[i]));
                	}
		        }
		        
		        
                
            },
            error: (error) => {
                console.log(error);
            }
        });
	});
		
</script>