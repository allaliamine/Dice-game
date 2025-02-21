<!DOCTYPE html>
<html lang="en">
<head>
    <title>Regitser</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body>

<div class="col-md-6 offset-3 border shadow-lg p-4 mt-5 bg-body rounded">
    <h2 class="text-center" >  Register </h2>
    <form class="form" method="POST" action="${pageContext.request.contextPath}/register">

        <div class="form-group">
            <label> First Name : </label>
            <br>
            <input class="col-md-12 form-control" type="text" name="name" placeholder="Enter your first name..." required>
        </div>

        <br>

        <div class="form-group">
            <label> Last Name : </label>
            <br>
            <input class="col-md-12 form-control" type="text" placeholder="Enter your last name..." name="last_name" required>
        </div>

        <br>

        <div class="form-group">
            <label> Email : </label>
            <br>
            <input class="col-md-12 form-control" type="text" placeholder="Enter your email..." name="email" required>
        </div>

        <br>

        <div class="form-group">
            <label> Password : </label>
            <br>
            <input class="col-md-12 form-control" type="password" placeholder="Enter your password..." name="password">
        </div>

        <br>

        <button class="btn btn-primary col-md-6 offset-3" type="submit">Create Account</button>


        <%
            String message = (String) request.getAttribute("message");
            if (message != null){%>

        <div class="alert alert-danger text-center my-3"> <%= message %> </div>
        <% } %>
    </form>
</div>
</body>
</html>
