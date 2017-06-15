# cursos
Proyecto Final de Curso

APLICACIÓN CURSOS

Tecnologias  de la aplicacion
Para realizar este proyecto web vamos a utilizar las siguientes tecnologías:
Gestor de Base de datos: MySQL 5.6.17 o posterior, por ejemplo como WAMP o XAMP
Servidor de servlets: Apache Tomcat 6.0 o superior, también se puede utilizar el servidor de aplicaciones  Wildfly  10.0
Entorno Web: Spring MVC
Persistencia Web: Spring JDBC
Seguridad Web: Spring Security
Servicios Web REST: Spring MVC 

Instalación de la aplicación
Creación de la base de datos 
Para crear la base de datos vamos a utilizar la aplicación de consola mysql, seguiremos los siguientes pasos 
Dejar el fichero cursosDB en la ruta deseada por ejemplo c:\desarrollo 
Abriremos una consola de Windows y nos dirigiremos a la ruta donde se encuentran las aplicaciones de consola del gestor de  mysql, en mi caso C:\wamp\bin\mysql\mysql5.6.17\bin
Y aquí ejecutamos el comando 
mysql --host=localhost --user=root --password=    <  c:\desarrollo\cursosDB.sql
 
Rellenado de la base de datos 
Para rellenar la base de datos vamos a utilizar la aplicación de consola mysql, seguiremos los siguientes pasos 
Dejar el fichero cursos.csv en la ruta deseada por ejemplo c:\desarrollo 
Abriremos una consola de Windows y nos dirigiremos a la ruta donde se encuentran las aplicaciones de consola del gestor de  mysql, en mi caso C:\wamp\bin\mysql\mysql5.6.17\bin
Y aquí ejecutamos el comando 
mysqlimport.exe --host=localhost --user=root --password= --local --default-character-set=utf8 --delete --fields-terminated-by=";" --ignore-lines=1 --verbose --columns=@ignorado,NomCurso,@ignorado,@ignorado,@ignorado,@ignorado,@ignorado,@ignorado,CodCurso --fields-enclosed-by="" --fields-escaped-by="" --lines-terminated-by="\r\n"  cursos C:\desarrollo\cursos.csv

 

Se anexan dos ficheros con los pasos necesarios y los comandos para la creación de la BBDD y la carga de datos, por si el copiar y pegar diese algún tipo de problema. 
      

Instalacion y despliegue de la aplicación WEB en el servidor
Para realizar el despliegue de la aplicación en nuestro servidor de servlets tomcat 6 ese necesario arrancar el servidor para ello iremos a la ruta de instalación de tomcat en nuestro caso C:\Desarrollo\apache-tomcat-6.0.48\bin y si estamos en un entorno Windows ejecutaremos el script startup.bat y se nos abrirá una consola donde se iniciara tomcat
 

Una vez iniciado el servidor abriremos un navegador e iremos a la ruta http://localhost:8080/
Dentro del menú pulsaremos tomcat manager y ahí desplegaremos el fichero cursos.war que podemos encontrar en el directorio target 

 

 

Para mas información y actualizaciones en el código de de la aplicación puede revisar el github del equipo de desarrollo. Se encuentra en la ruta https://github.com/nuipek/cursos
Ademas para desarrolladores disponemos de la documentación de java en la carpeta Doc donde se pueden ver paquetes, interfaces y clases de esta, para poder verla abriremos index.html con nuestro navegador favorito. 
 


Ademas tenemos a su disposición de una interfaz grafica donde poder consultar nuestra api rest para interactuar con la aplicación para ellos puede ir a la siguiente url http://localhost:8080/cursos/swagger-ui.html
 





