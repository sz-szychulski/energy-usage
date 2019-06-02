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
        <li><a href="/delete">Delete</a></li>
    </ul>
    <h1>Add device to database</h1>
    <form method="post" action="/added">
        <table>
            <tr>
                <td style="font-weight: bold">Name: </td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td style="font-weight: bold">Energy consumption [W]</td>
                <td><input type="text" name="energy_consumption" /></td>
            </tr>
            <tr>
                <td style="font-weight: bold">Time usage [minutes/day]</td>
                <td><input type="text" name="time" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Add Device" /></td>
            </tr>
        </table>
    </form>

</body>
</html>