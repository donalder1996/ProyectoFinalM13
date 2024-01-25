<?php
$servername = "localhost"; // Nombre del servidor
$username = "root"; // Nombre de usuario de la base de datos
$password = ""; // Contraseña de la base de datos
$dbname = "m13_proyecto"; // Nombre de la base de datos
$conexion = mysqli_connect("localhost", "root", "", "m13_proyecto");
//Obtener los datos del formulario
$nombre = $_POST["nombre"];
$apellido = $_POST["apellido"];
$user = $_POST["user"];
$mail = $_POST["mail"];
$contra = $_POST["contra"];
$genero = $_POST["genero"];
$nacionalidad = $_POST["nacionalidad"];
$fabricante = $_POST["fabricante"];

// Consulta SQL para insertar datos en la tabla
$sql = "INSERT INTO usuarios(nombre,apellido,user,mail,contra,genero,nacionalidad,fabricante) VALUES ('$nombre','$apellido','$user', '$mail', '$contra','$genero','$nacionalidad','$fabricante')";
$result = mysqli_query($conexion,$sql);

if($result){
    echo "datos insertados";
}else{
    echo "no pudo insertar";
}
// if ($_SERVER["REQUEST_METHOD"] === "POST") {
//    $nombre = $_POST["nombre"];
//    $apellido = $_POST["apellido"];
//    $user = $_POST["user"];
//    $mail = $_POST["mail"];
//    $contrasena = $_POST["password"];
//    $genero = $_POST["genero"];
//    $nacionalidad = $_POST["nacionalidad"];
//    $fabricante = $_POST["fabricante"];

//     // Consulta SQL para insertar datos en la tabla
//     $sql = "INSERT INTO usuarios (nombre, apellido, user, mail, password, genero, nacionalidad, fabricante) VALUES ('$nombre', '$apellido', '$user','$mail', '$contrasena','$genero','$nacionalidad','$fabricante')";
    
//     if ($conn->query($sql) === TRUE) {
//         // La inserción se realizó con éxito
//         echo "true";
//     } else {
//         // Ocurrió un error durante la inserción
//         echo "false";
//     }
// }


// Cerrar la conexión a la base de datos
$conexion->close();
?>
