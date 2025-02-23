#Spring
**Un framework es un conjunto de clases e interfaces que nos permiten resolver uno o varios problemas específicos.**
**Spring es el framework más popular de Java, ya que nos permite crear aplicaciones de alto rendimiento, livianas y reutilizables.**

#Spring Boot
**Spring Boot surge con el objetivo de simplificar, estandarizar y unificar el uso de Spring Framework.**
**Spring Boot hace muy sencillo empezar a trabajar con Spring.**

#logback-spring.xml
**El archivo logback-spring.xml es para controlar la cantidad de información que se manda hacia la consola.**
**Este archivo tiene un patrón que nos está indicando cuál es la clase que se está mandando, el nivel, un mensaje y también por cada mensaje que se manda se imprime un salto de línea.**
**<pattern>[%thread] %-5level: %logger - %msg%n</pattern> desactivamos este patrón y activamos el que se va a mandar a consola. <pattern>%msg</pattern>**
**Con este archivo evitamos mandar demasiada información a la consola.**

**La clase Entidad realmente va a corresponder a un mapeo, de una clase de Java con una tabla de base de datos, utilizamos @Entity. Usamos JPA con la implementación Hibernate para poder realizar este mapeo de la clase de Java hacia la Base de Datos. A este tipo de tecnología se la conoce como ORM (Object Relational Mapping o Mapeo Objeto-Relacional).**

**La clase Datos vamos a crear una interface @Repository va hacer las veces del patrón DAO que implementamos anterior. De manera automática va a implementar los métodos a nuestra clase. Luego creamos la interface de Servicio con @Service, va a tener los métodos de listar, modificar, agregar, eliminar, etc.**
**Utilizando Spring vamos agregar varias características por ejemplo el manejo transaccional para encaso de cualquier problema con conexión hacia la base de datos o con el recurso donde estamos obteniendo los datos, entonces si algo falla se aplica el concepto de Rollback, volver hacia atrás (dar marcha atrás).  Cualquier falla no va a afectar el estado de la base de datos. Y si todo funciona correctamente entonces se va a guardar la información en la base de datos o como se conoce commit o guardado de la transacción. El manejo transaccional Spring lo maneja automáticamente. Y por último la clase de presentación @SpringBootApplication y con esto básicamente Spring va a poder administrar todos los objetos que se necesiten en la aplicación.**

##Corrección problemas Lombok
**Hola, en la siguiente lección se va a crear la clase de Entidad de nuestra aplicación, sin embargo si estás usando las últimas versiones al día de hoy de Spring Boot y el proyecto de Lombok, existen ciertos problemas de compatibilidad. Aquí te dejamos unos pasos para que puedas resolver estos problemas en caso de que no se generen correctamente los métodos get/set o constructores en tu aplicación.**

**Para solucionar el problema de la falta de generación de los métodos get/set, constructores, o método toString en las clases de entidad o cualquier otra clase que use la anotación @Data de lombok, debes agregar la versión de lombok a la configuración de la sección build del archivo pom.xml. Así es como debe quedar la configuración:**

**

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <annotationProcessorPaths>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                            <version>1.18.36</version>
                        </path>
                    </annotationProcessorPaths>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
Al agregar estas modificaciones, debes actualizar tus librerías y el archivo pom.xml como sigue (si no sincronizas los cambios no funcionará):
Recuerda que ya debes tener instalado el plugin de lombok para IntelliJ IDEA.
Si aún no lo tienes instalado, puedes revisar los siguientes pasos para instalar y configurar Lombok en IntelliJ IDEA Community Edition:
1. Instalar el Plugin de Lombok en IntelliJ
Abre IntelliJ IDEA.
Ve a File → Settings (o Ctrl + Alt + S en Windows/Linux, Cmd + , en macOS).
En el menú de la izquierda, selecciona Plugins.
En la pestaña Marketplace, busca Lombok.
Haz clic en Install y luego en Restart IDE para aplicar los cambios.
2. Habilitar Lombok en el Proyecto
Abre File → Settings → Build, Execution, Deployment → Compiler → Annotation Processors.
Marca la opción Enable annotation processing.
Aplica los cambios y reinicia IntelliJ si es necesario.
Además, te recomendamos usar el jdk 21 que es la versión estable de Java.
Esto lo debe aplicar en cada uno de los proyectos que usan Spring Boot y Lombok para evitar los problemas mencionados anteriormente.**

**Por último, recuerda que lombok NO es necesario para ejecutar tu proyecto, solamente es una ayuda para generar los métodos boilerplate de Java, como los métodos get/set, constructores, toString, etc. Así que si ya aplicaste todos los pasos anteriores y sigue sin funcionar tu proyecto, te recomendamos quitar las anotaciones de lombok y agregar manualmente el código de los métodos get/set, constructores, toString, etc a tu clase, de esta manera ya no dependerás del proyecto de lombok y ya tendrás el código necesario para evitar problemas con tu proyecto por la falta de generación de este tipo de código.**

**El tipo primitivo int su valor por defecto es 0 (cero), en cambio cuando trabajamos con objetos con la clase Integer su valor por defecto es null.**
**Para que el Id se autoincremente utilizamos @GenratedValue, y establecemos la estrategia para indicar el tipo de estrategia de generación de esta llave primaria. Cuando trabajamos con MySql y valores auto incrementable utilizamos la propiedad IDENTITY.**
**Ej. @GeneratedValue(strategy = GenerationType.IDENTITY)**
**@Data con esto estamos agregando los métodos getters y setters a esta clase del paquete import lombok.Data.**
**@NoArgsConstructor estamos creando un constructor vacío, sin argumentos, @AllArgsConstructor estamos agregando el constructor con todos los argumentos.**

**ClienteRepositorio extendemos de otra interface JpaRepository es tipo genérico, indicamos el tipo de dato con el que vamos a trabajar, el primer parámetro va hacer Cliente, y el segundo parámetro es el tipo de la llave primaria, Integer. Los datos que hay que especificar es el tipo de la clase y el tipo de la llave primaria. Ej: JpaRepository<Cliente, Integer>.**
**Con esta interface podemos acceder a las funcionalidades de los métodos insertar, agregar, eliminar, listar, actualizar, etc. Por ello proporcionamos el tipo de datos de la clase y el tipo de dato de la llave primaria.**
**Lo primero agregar @Service que esto forma parte de la fábrica de Spring y los métodos que manejemos van a hacer métodos transaccionales.**
**@Autowired  esta anotación significa que se va a auto inyectar una referencia, en este caso, de la capa de datos de la clase repositorio.**
**Importante la anotación @Service debe estar al principio, @Autowired, la inyección de dependencias de clienteRepositorio para poder realizar las operaciones con la base de datos, como pueden ser los métodos findAll, findById, save, delete, update, etc.**

#Logger
**Creamos una variable logger e importamos del paquete org.slf4j.Logger y org.slf4j.LoggerFactory para poder mandar información a consola y vamos a tener más detalles si es que lo necesitamos. Ej: private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class) entre paréntesis indicamos la clase que estamos trabajando**
#Inyección de dependencia
**La clase Application necesita de un objeto, de tipo de Servicio para poder conectarse a su vez con la capa de datos, obtener objetos de tipo Entidad y recuperar la información de la Base de Datos. Para ello inyectamos una dependencia de servicio hacia nuestra capa de presentación.**
**Inyectamos una dependencia de Servicio hacia la clase de presentación**
**@Autowired**
**private IClienteServicio clienteServicio;**
**El archivo logback-spring.xml sirve para poder trabajar con Logger y podemos personalizar como se manda la información a consola, que reemplaza a println, esto lo utilizamos cuando usamos algún framework.**

**Agregamos un método que pueda ejecutar nuestra aplicación de consola, esta clase implementa la interface  CommandLineRunner y tenemos que implementar el método run. Ej:
   public class ZonaFitApplication implements CommandLineRunner {
         @Override     
        public void run(String... args) throws Exception {   
        } }**
**Primero se levanta la fábrica Spring y cuando este en memoria, ahí podemos utilizar todos los elementos, ya cuando se tienen todos los objetos disponibles entonces con el método run, como si fuera el método main podemos empezar a trabajar.**
#Salto de línea genérica
**Para tener el salto de línea de manera genérica, definimos una variable de tipo string llamada nl (new line) y utilizamos la clase System y el método LineSeparator. Ej: String nl = System.LineSeparator();**

**Llamamos el método forEach para iterar con cada uno de estos objetos pero con la expresión Lambda. Primero definimos la variable que va a recibir cada uno de los objetos de tipo cliente (va a hacer el parámetro de nuestra función lambda), después el cuerpo de esta función, mandamos a imprimir a nivel info, obtenemos cada uno de los clientes y finalmente llamamos el método toString de manera explícita.**









 
 