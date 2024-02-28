<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.igate.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
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
                
                   
                    <table class="table mt-5">
                        <tr class="table-row table-success text-white">
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
  							String str=String.format("<a href='delproducts/%d'><i class='bi bi-trash'></i></a> &nbsp;&nbsp; <a href='updateproducts/%d'><i class='bi bi-pencil-square'></i></a>",p.getPcode(),p.getPcode());
  							out.println("<td>"+str+"</td>");
  							//String durl="delproducts/"+p.getPcode();
  							//String uurl="updateproducts/"+p.getPcode();
  							//out.println("<td><a href='"+durl+"'>delete</a> &nbsp;&nbsp; <a href='"+uurl+"'>update</a></td>");
  							out.println("</tr>");
  						}
    %>
                  
                        
                    </table>
					<div class="text-center">
	         			<br><br>
	               		<a href="crproducts" class="btn btn-success">New Product</a>
          			</div>

            </div>
            <div class="col-md-1">
            </div>
        </div>
        

    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>