Requisitos previos

Tener instalado Java JDK en el sistema

Disponer de Maven (si no lo incluye su editor de código).

Utilizar Visual Studio Code (con extensión de Java) o cualquier IDE compatible con proyectos Spring Boot.

Instrucciones de instalación y ejecución
1. Descargar y descomprimir el proyecto

Por favor, descargue el archivo ZIP del proyecto y descomprímalo en la carpeta de su elección.

2. Abrir el proyecto en Visual Studio Code

Abra Visual Studio Code y seleccione la opción “Open Folder”. Navegue hasta la carpeta donde ha descomprimido el proyecto y ábrala.

3. Configuración de la base de datos

El archivo properties trae toda la configuración con la base de datos, no hace falta modificar nada.

4. Compilar y ejecutar el proyecto

Puede compilar y ejecutar el backend desde el terminal con Maven utilizando el siguiente comando:

./mvnw spring-boot:run

O, si Maven está instalado globalmente:

mvn spring-boot:run

También puede iniciar la aplicación desde Visual Studio Code utilizando la extensión de Java (botón Run en la clase principal).

5. Acceso a la API

Por defecto, el backend se inicia en el puerto 8080. Puede acceder a la documentación interactiva de la API REST a través de Swagger:

http://localhost:8080/swagger-ui/index.html

o en su defecto usar la del servicio de Render

https://myrecipesapi.onrender.com/swagger-ui/index.html
