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
    <h1>Add device to database</h1>
    <form method="post" action="/added">
        <table>
            <tr>
                <td style="font-weight: bold">Name: </td>
                <td><input type="text" name="name" required/></td>
            </tr>
            <tr>
                <td style="font-weight: bold">Energy consumption [W]:</td>
                <td><input type="number" name="energy_consumption" min="1" required/></td>
            </tr>
            <tr>
                <td style="font-weight: bold">Time usage [minutes/day]:</td>
                <td><input type="number" name="time" min="1" required/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Add Device" /></td>
            </tr>
        </table>
    </form>
    <script>
        var name = document.getElementById("name");
        var energy_consumption = document.getElementById("energy_consumption");
        var time = document.getElementById("time");

        name.addEventListener("input", function (event) {
            if (name.validity.typeMismatch) {
                name.setCustomValidity("I expect text!");
            } else {
                name.setCustomValidity("");
            }
        });

        energy_consumption.addEventListener("input", function (event) {
            if (energy_consumption.validity.typeMismatch) {
                energy_consumption.setCustomValidity("I expect number here!")
            } else {
                energy_consumption.setCustomValidity("");
            }
        });

        time.addEventListener("input", function (event) {
            if (time.validity.typeMismatch) {
                time.setCustomValidity("I expect number here!")
            } else {
                time.setCustomValidity("")
            }
        });
    </script>
</body>
</html>