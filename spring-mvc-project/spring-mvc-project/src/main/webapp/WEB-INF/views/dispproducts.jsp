<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.igate.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<%
	    List<Products>	lst=(List)request.getAttribute("lst");
	
	%>


    <div class="bg-success p-4 text-center text-white">
        <h1>List of Products</h1>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-1">
            </div>
            <div class="col-md-10">
                
                   
                    <table class="table table-light mt-5">
                        <tr class="bg-success text-white">
                            <td>Pcode</td>
                            <td>Product Name</td>
                            <td>Price</td>
                            <td>Stock</td>
                            <td>Action</td>
                        </tr>
                        
  <%
  						for(Products p:lst)
  						{
  							out.println("<tr>");
  							out.println("<td>"+p.getPcode()+"</td>");
  							out.println("<td>"+p.getPname()+"</td>");
  							out.println("<td>"+p.getPrice()+"</td>");
  							out.println("<td>"+p.getStock()+"</td>");
  							out.println("<td></td>");
  							out.println("</tr>");
  							
  						}
    %>
                  
                        
                    </table>

                
            </div>
            <div class="col-md-1">
            </div>
        </div>

    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>