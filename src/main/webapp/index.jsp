<!DOCTYPE html>
<html lang="en">
<head>
    <title>Connect</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="col-md-6 offset-3 border shadow-lg p-4 mt-5 bg-body rounded">
    <h2 class="text-center"> Sign In </h2>
    <form class="form" method="POST" action="${pageContext.request.contextPath}/connect">

        <div class="form-group">
            <label> Email : </label>
            <br>
            <input class="col-md-12 form-control" type="text" name="email" required>
        </div>

        <br>

        <div class="form-group">
            <label> Password : </label>
            <br>
            <input class="col-md-12 form-control" type="password" name="password" required>
        </div>

        <br>

        <button class="btn btn-primary col-md-6 offset-3" type="submit" > Connect </button>
    </form>
    <hr>
    <p class="text-center"> you don't have an account ? <a class="text-primary" href="${pageContext.request.contextPath}/register">Register here</a></p>


    <%
        String message = (String) request.getSession().getAttribute("message");
        if (message != null){%>

    <div class="alert alert-success text-center my-3"> <%= message %> </div>
    <% request.getSession().removeAttribute("message");} %>

</div>
</body>
</html>