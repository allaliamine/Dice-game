<%@page import="org.app.dicegame.Classes.User"  %>

<%

    String LastName = ((User) (request.getSession()).getAttribute("user")).getLastName();

%>

<nav class="navbar navbar-expand-lg bg-dark border-bottom border-body" data-bs-theme="dark">

    <div class="container-fluid">

        <a class="navbar-brand">Dice Game | Hello <%= LastName %></a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">

                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/connect">Home</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/scoreTable">Scores Table</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/connect?action=re-init">Set to 0</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/deconnect">Log out</a>
                </li>

            </ul>
        </div>
    </div>
</nav>