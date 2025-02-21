<%@ page import="org.app.dicegame.Classes.User" %>
<%@ page import="java.util.List" %>
<%@include file="navbar.jsp"%>

<html>
<head>
    <title>Scores</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
    <body>

    <div class="container col-md-6 offset-3 border shadow-lg p-4 mt-5 bg-body rounded">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Rank</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Score</th>
            </tr>
            </thead>

            <tbody>

            <%
                List<User> UsersListScore = (List<User>) request.getAttribute("sortedUsers");
                int i = 1;
                for(User usr : UsersListScore){
            %>
                    <tr <% if (usr.equals(request.getSession().getAttribute("user"))) {out.println("class=" +'"'+ "table-primary"+'"');}%>>
                        <th scope="row"><%= i%></th>
                        <td><%= usr.getName()%></td>
                        <td><%= usr.getLastName() %></td>
                        <td><%= usr.getBestScore() %></td>
                    </tr>

            <% i++; }%>

            </tbody>
        </table>
    </div>



    </body>
</html>
