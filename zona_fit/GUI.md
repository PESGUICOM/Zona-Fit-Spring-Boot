# Aplicaciones de escritorio
**@Component cuando se crea un objeto de esta instancia podemos recuperar los demás objetos de Spring y podemos inyectar la dependencia del Servicio dentro del constructor de esta clase.**
#Inyectando dependencia desde un constructor
** 
@Autowired
     public ZonFitForma(ClienteServicio clienteServicio){
        this.clienteServicio = clienteServicio;
    }
**
# El método invokeLater() se va a invocar después de que se levante la fábrica de Spring
**
//Instanciar la fábrica de Spring
ConfigurableApplicationContext contextoSpring = new SpringApplicationBuilder(ZonaFitSwing.class)
        .headless(false)  //método
        .web(WebApplicationType.NONE)  //método para aplicación web NO se levante
        .run(args);
//Crear un objeto de Swing
SwingUtilities.invokeLater(() -> {
    ZonFitForma zonaFitForma = contextoSpring.getBean(ZonFitForma.class);
    zonaFitForma.setVisible(true);
});
con la anotación Lambda**
**Si no corre el programa un posible error en el archivo properties**
**spring.application.name=zona_fit
# Conexión MySql
spring.datasource.url=tu_base_de_datos_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
#Dialecto para MySql
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
#Evitar que se cree el esquema de bd
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
#Desactivar tomcat
spring.main.web-application-type=none**
**//Evitamos la edición de los valores de las celdas de la tabla
        this.tablaModeloClientes = new DefaultTableModel(0, 4){
            @Override //Sobreescribir método para no modificar cliente por celda en la tabla
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String [] cabeceros = {"Id", "Nombre", "Apellido", "Membresía"};
        this.tablaModeloClientes.setColumnIdentifiers(cabeceros);
        this.clientesTabla = new JTable(tablaModeloClientes); //Creando la tabla
        //Restringuimos la selección de la tabla a un solo registro
        this.clientesTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Cargar listado de clientes
        listarClientes();
**
**var clientes = this.clienteServicio.listarClientes(); //la lista se guarda en la variable**
** this.tablaModeloClientes.addRow(reglonCliente); //llenamos tabla**
**
  //Recuperamos los valores del formulario
        var nombre = nombreTexto.getText();
        var apellido = apellidoTexto.getText();
        var membresia = Integer.parseInt(membresiaTexto.getText());
        var cliente = new Cliente(this.idCliente, nombre, apellido, membresia); //Creando objeto
        this.clienteServicio.guardarCliente(cliente); //insertar o modificar
        if (this.idCliente == null)
            mostrarMensaje("Se agregó el nuevo Cliente");
        else
            mostrarMensaje("Se actualizó el Cliente");
        limpiarFormulario();
        listarClientes();
**

