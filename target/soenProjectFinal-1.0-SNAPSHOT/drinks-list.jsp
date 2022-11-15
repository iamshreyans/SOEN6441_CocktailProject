<%--
  Created by IntelliJ IDEA.
  User: shubham
  Date: 12/11/2022
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
            margin-right: 20px; padding: 10px">
                <h1 class="center">Drinks WebApp</h1></a>
        </div>

        <div class="navbar-brand" style="margin-left: 20px; margin-right: 20px">
            <a href="<%=request.getContextPath()%>/list"
                   class="nav-link" > <h3 style="color: black">Drinks</h3></a>
        </div>
    </nav>
</header>
<br>

<div class="row">

    <div class="container-fluid" style="background-color: blanchedalmond; padding: 10px">
        <h3 class="text-center">List of Drinks </h3>
        <hr>
        <div class="container-fluid text-center" style="margin: 10px; padding: 10px">
            <a href="<%=request.getContextPath()%>/search" class="btn btn-primary"
            style="background-color: coral; border-color: black; color: black; text-align: justify-all"
            >Search For Drinks</a>
        </div>
        <br>
        <table class="table table-bordered" style="border: 2px solid black">
            <thead style="border: 2px solid black">
            <tr style="text-align: center;border: 2px solid black">
                <th style="text-align: center; border: 2px solid black"><h5>ID</h5></th>
                <th style="text-align: center; border: 2px solid black"><h5>Name</h5></th>
                <th style="text-align: center; border: 2px solid black"><h5>Category</h5></th>
                <th style="text-align: center; border: 2px solid black"><h5>Alcohol OR Not</h5></th>
            </tr>
            </thead>
            <tbody >

            <c:forEach var="drinks" items="${requestScope.listOfDrinks}">

                <tr style="border: 2px solid black">
                    <td style="text-align: center; border: 2px solid black"><c:out value="${drinks.getId()}" /></td>
                    <td style="text-align: center; border: 2px solid black"><c:out value="${drinks.getDrinkName()}" /></td>
                    <td style="text-align: center; border: 2px solid black"><c:out value="${drinks.getCategory()}" /></td>
                    <td style="text-align: center; border: 2px solid black"><c:out value="${drinks.getAlcoholic()}" /></td>
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>
</body>
</html>
