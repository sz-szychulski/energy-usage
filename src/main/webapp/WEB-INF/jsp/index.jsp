<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Energy Usage App</title>
    <meta charset="UTF-8">
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
        }

        li {
            float: left;
        }

        li a {
            display: block;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 20px;
        }

        table, td, th {
            border: 1px solid #ddd;
            text-align: left;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            padding: 15px;
        }
    </style>
</head>

<body>
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="add">Add</a></li>
        <li><a href="delete_all">Delete all</a></li>
    </ul>
    <hr />
    <h1>Energy usage calculator</h1>
    <c:if test="${!empty deviceList}">
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Energy Consumption [W]</th>
                <th>Time [minutes/day]</th>
            </tr>
            <c:forEach items="${deviceList}" var="device">
                <tr>
                    <td><c:out value="${device.id}" /></td>
                    <td><c:out value="${device.name}" /></td>
                    <td><c:out value="${device.energy_consumption}" /></td>
                    <td><c:out value="${device.time}" /></td>
                    <td><a href="delete/${device.id}"><button>Delete</button></a><a href="modify/${device.id}"><button>Modify</button></a></td>
                </tr>
            </c:forEach>
        </table>
        <br />
        <hr />

        <h2>Daily usage is: <fmt:formatNumber type="number" maxFractionDigits="4" value="${usage}"/>[kWh]</h2>
        <h2>Weekly usage is: <fmt:formatNumber type="number" maxFractionDigits="4" value="${usage * 7}"/>[kWh]</h2>
        <h2>Monthly usage is: <fmt:formatNumber type="number" maxFractionDigits="4" value="${usage * 30}"/>[kWh]</h2>

        <hr />
        <br />
        <form method="get" action="/">
            <b>Price [per kWh]: </b><input type="text" name="price" />
            <input type="submit" value="Set price" />
        </form>
        <c:if test="${!empty price}">
            <h3>Daily cost is: <fmt:formatNumber type="number" maxFractionDigits="2" value="${usage * price}"/>zl</h3>
            <h3>Weekly cost is: <fmt:formatNumber type="number" maxFractionDigits="2" value="${usage * 7 * price}"/>zl</h3>
            <h3>Monthly cost is: <fmt:formatNumber type="number" maxFractionDigits="2" value="${usage * 30 * price}"/>zl</h3>
        </c:if>
        <c:if test="${empty price}">
            <h3>Add price to calculate cost.</h3>
        </c:if>
    </c:if>

    <c:if test="${empty deviceList}">
        <h2>Add device to calculate energy usage</h2>
    </c:if>
</body>
</html>