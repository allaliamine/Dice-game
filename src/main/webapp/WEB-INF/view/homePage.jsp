<%@ include file="navbar.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5 col-md-6 offset-3">
        <div class="card">
            <div class="card-header text-center">
                Role the dice to start playing
            </div>
            <div class="card-body">
                <form method="get" action="${pageContext.request.contextPath}/play">
                    <div class="form-group text-center my-3">
                        current score : <%= request.getSession().getAttribute("score") %>
                    </div>

                    <div class="form-group text-center my-3">
                        Left Throws :  <%= (Integer)request.getSession().getAttribute("throwsNumber") %>
                    </div>

                    <% if ((Integer)request.getSession().getAttribute("throwsNumber") > 0) {%>
                        <button class="btn btn-success offset-3 col-md-6 my-3" type="submit">Roll the dice</button>
                    <% } else { %>
                        <div class="alert alert-danger text-center my-3"> Game is Over!! would you like to play again ? </div>
                        <br>
                        <a class="btn btn-success offset-3 col-md-6" href="${pageContext.request.contextPath}/connect?action=re-init">YES</a>
                    <% } %>

                </form>

            </div>


        </div>

    </div>


</body>
</html>
