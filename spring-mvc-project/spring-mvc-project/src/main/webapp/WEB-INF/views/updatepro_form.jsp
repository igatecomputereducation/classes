<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.igate.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create product page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<%
		Products p=(Products)request.getAttribute("det");
	%>
    <div class="bg-success p-4 text-center text-white">
        <h1>Updating Products</h1>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-3">
            </div>
            <div class="col-md-6">
                <div class="border p-3 mt-3">
                    <form action="../modifyproduct" method="post">
                        <label for="pcode" class="form-label">Pcode</label>
                        <input type="text" name="pcode" value="<%=p.getPcode()%>" id="pcode" autocomplete="off" required autofocus class="form-control" readonly>
                        <label for="pname" class="form-label">Product Name</label>
                        <input type="text" name="pname" value="<%=p.getPname()%>" id="pname" autocomplete="off" required class="form-control">
                        <label for="price" class="form-label">Price</label>
                        <input type="text" name="price" value="<%=p.getPrice()%>" id="price" autocomplete="off" required class="form-control">
                        <label for="stock" class="form-label">stock</label>
                        <input type="text" name="stock" value="<%=p.getStock()%>" id="stock" autocomplete="off" required class="form-control">
                        <input type="submit" value="Update Product" class="btn btn-success w-100 mt-3">
                    </form>
                </div>
            </div>
            <div class="col-md-3">
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>