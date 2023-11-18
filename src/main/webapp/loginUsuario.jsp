<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesión</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            margin: 50px;
        }

        h1 {
            color: #333;
        }

        form {
            max-width: 300px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: blue;
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color:#768AC8 ;
        }
    </style>
</head>
<body>
    <h1>Iniciar Sesión</h1>
    <form action="/aso.web/login-servlet" method="POST">
        <input type="text" name="usuario" placeholder="Nombre de Usuario" required> <br>
        <input type="password" name="clave" placeholder="Contraseña" required> <br>
        <input type="submit" value="Iniciar Sesión">
    </form>
</body>
</html>