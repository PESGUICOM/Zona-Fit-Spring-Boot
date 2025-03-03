# HTML: Hypertext Markup Language o Lenguaje de Marcas de Hipertexto. HTML permite definir la estructura de una página web.
**Hipertexto hace referencia a los enlaces o links que conectan las páginas web entre sí.**
# CSS: Cascading Style Sheets o Hojas de Estilo en Cascada. CSS nos permite manejar el diseño de una página web.
**Son estilos en cascada porque se puede heredar los estilos entre distintos elementos HTML.**
**La prioridad de aplicar los estilos: primero los estilos en inline (sobre los elementos HTML), los segundos estilos que toman prioridad serían los estilos definidos a nivel de la página (Interno) y por último los estilos definidos a nivel de un archivo.**
# Hover
**El evento hover = flotar, pasar por encima del link.**
# Creando clase en CSS
**Un punto al inicio estamos indicando que se está creando una clase. Ej: .texto-centrado{}**
# JSF/Prime Faces
**JSF (Java Server Faces)/ Prime Faces es un conjunto de tecnologías para la creación de aplicaciones web. Aplica el patrón de diseño MVC (Modelo-Vista-Controlador). El Modelo son los datos de nuestra aplicación, la Vista  son las páginas HTML o también conocidas como plantillas y el Controlador es  una clase Java donde se van a administrar las peticiones web.**
# XHTML
**Cuando usamos JSF/Prime Faces la extensión de nuestro HTML va a hacer .xhtml**
**Un framework es una herramienta que nos facilita hacer una tarea en específico, por ejemplo en este caso, crear una aplicación web.**
**Protocolo HTTP que significa HyperText Transfer Protocol o Protocolo de Transferencia de Hipertexto.**
# Petición GET http
**Petición Get (obtener) HTTP para solicitar recursos a un servidor web, existen varios métodos que podemos usar. Por default al solicitar una página o recurso web al servidor se utiliza el método get.**
# Petición POST http
**Una petición Post (envío) HTTP nos permite enviar información al servidor web. La petición Post se envía en el cuerpo de la petición http, en cambio, una petición Get envía la información en el url de la petición.**
# Patrón MVC en este caso
**Patrón MVC cuando hagamos una petición localhost:8080/index.xhtml del lado del servidor (Servidor Tomcat) lo que sucede es lo siguiente en nuestro servidor Tomcat se van a cargar las clases necesarias para poder realizar este procesamiento. En primer lugar quien procesa esta petición  es la clase de controlador, este recibe la petición y obtiene la información del modelo, en este caso de una bas de datos, y se comunica con la capa de servicio, posteriormente el repositorio y finalmente obtenemos la información de modelo de la base de datos. La clase controladora controla el flujo, orquesta el flujo de nuestra aplicación según la petición que esta recibiendo. Posteriormente obtiene la información de una base de datos o de la fuente donde se encuentre los datos de nuestra aplicación. Finalmente el controlador redije esta información hacia la vista que finalmente se va a mostrar. En este caso la vista es index.xhtml, y de manera dinámica se genera este contenido y se regresa el flujo hacia el controlador. Finalmente el controlador genera la respuesta y entonces manda la respuesta por ejemplo el listado de clientes hacia el navegador web o lo que es lo mismo el cliente http.**
# Archivo index.xhtml
**Para generar contenido dinámico en la carpeta resources creamos una carpeta new directory con nombre: META-INF, dentro de la misma generamos una subcarpeta new directory con nombre: resources y dentro de esta un archivo index.xhtml que este archivo, vamos agregar las vistas de nuestra aplicación web. Y cuando accedamos a nuestro archivo(xhtml) se va a desplegar el contenido del xhtml.**
**Estas librerías las encontramos en esta url http://xmlns.jcp.org/jsf/html, estos componentes que ya se han descargado, lo podemos utilizar ingresando a los componentes html, administrados por jsf, dentro de esta página.**
**xmlns = xml name space es el nombre donde se encuentran estos elementos**
# Patrón MVC en web
**El Cliente entra por la url:http://localhost:8080/index.xhtml y hace una petición hacia el servidor. La url la ejecuta el Controlador que se comunica con la capa de Servicio, este con la capa de Repositorio y este con la BD que regresa los objetos Entidad respectivos. Esta información regresa por el Repositorio, Servicio, Controlador respectivamente y desde el Controlador se selecciona la Vista que este va a generar, en este caso el index.xhtml y el controlador comparte la información necesaria con la Vista para que pueda desplegar la información respectiva y finalmente regresa la respuesta al Cliente, hacia el navegador web.**
# @ViewScoped
**@ViewScoped esta anotación es para refrescar la parte de la vista que se necesite, son peticiones AJAX= Asynchronous JavaScript and XML, asíncronas, una aplicación de una vista.**
# Conceptos varios
**responsive="true" para que los elementos se adapten según la ventana**
**inputText para agregar texto, inputNumber para agregar números**
**footer = pie de página**
**@this recuperamos todos los valores de los campos text**
**Para mandar un mensaje Ej: FacesContext.getCurrentInstance().addMessage(null,         new FacesMessage("Cliente Agregado"));**
**.hide() = Para ocultar ventana modal Ej: oncomplete=""PF('eliminarClienteVentana').hide()"**
