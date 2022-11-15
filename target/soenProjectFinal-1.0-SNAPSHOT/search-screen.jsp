<%--
  Created by IntelliJ IDEA.
  User: shubham
  Date: 12/11/2022
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> Drinks WebApp </title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">

</head>
<body>

<header>
    <nav class="container-fluid" style="background-color: blanchedalmond">
        <div>
            <a class="navbar navbar-expand-lg" style="background-color: coral; margin-left: 20px;
            margin-right: 20px">
                <h1 class="center">Drinks WebApp</h1></a>
        </div>

        <div class="navbar-brand" style="margin-left: 20px; margin-right: 20px">
            <a href="<%=request.getContextPath()%>/list"
               class="nav-link" > <h3 style="color: black">Drinks</h3></a>
        </div>
    </nav>
</header>
<br>

<div class="container-fluid" style="background-color: blanchedalmond">
        <div class="container" style="padding: 10px">
            <form action="results">
                <fieldset id="name" class="form-group">
                    <label><h5>Enter Name</h5></label>
                    <input type="text" value="<c:out value='${drinks.getDrinkName()}' />"
                           class="form-control" name="DrinkName">
                </fieldset>

                <button type="submit" class="btn btn-success btn-block"style="background-color: coral">Search</button>
            </form>
    </div>
</div>



</body>

</html>
