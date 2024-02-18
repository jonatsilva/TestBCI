Este tutorial es indicado para ejecutar el proyecto java.

A-	Ejecutar el proyecto con:
:: Spring Boot ::        (v2.2.7.RELEASE)

B-	Las librerías necesarias están configuradas desde el pom.xml de MAVEN.

C-	La versión de JDK es JAVA 8.

D-	La base de datos es H2 ejecutado en memoria al iniciar el proyecto.
    http://localhost:8080/h2-ui/login.jsp
    user: sa
    pass: sa

E-	Usar Swagger para poder acceder a los métodos del controller construidos.
    http://localhost:8080/swagger-ui.html#/

F- Los métodos a acceder son:
    
    * Método POST createUser
      Este método es el necesario para crear a un usuario en la base de datos que relaciona la tabla USER y PHONES.
      Antes de crear el usuario el servicio valida que no exista una coincidencia en la base de datos del correo del usuario antes de ser insertado.
      El correo siempre es validado que su estructura sea correcta y no contenga caracteres especiales.
    
    * Método GET searchUserById
      Este método puede devolver atraves del id del usuario los datos de mismo siempre que exista en la base de datos, de lo contrario retornara un json de respuesta vacía.
    
    * Método POST updateUser
      Este método actualiza los datos del usuario ya creado y su datos de contacto telefónico siempre asociado al id del mismo.
      El correo es validado que su estructura sea correcta y no contenga caracteres especiales.

    * Método DELETE deleteUserById
      Este método elimina un usuario existente en la base de daros asociado al id del mismo.

      
