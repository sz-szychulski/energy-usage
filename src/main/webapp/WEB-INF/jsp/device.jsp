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
    </style>
</head>

<body>
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/add">Add</a></li>
        <li><a href="/delete_all">Delete all</a></li>
    </ul>
    <hr />
    <h1>Details about current device</h1>
    <table>
        <tr>
            <td style="font-weight: bold">Id: </td>
            <td>${id}</td>
        </tr>
        <tr>
            <td style="font-weight: bold">Name: </td>
            <td>${name}</td>
        </tr>
        <tr>
            <td style="font-weight: bold">Energy consumption: </td>
            <td>${energy_consumption}[W]</td>
        </tr>
        <tr>
            <td style="font-weight: bold">Time usage: </td>
            <td>${time}[minutes/day]</td>
        </tr>
    </table>
</body>
</html>