package com.pesguicom.zona_fit;

import com.pesguicom.zona_fit.modelo.Cliente;
import com.pesguicom.zona_fit.servicio.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.Scanner;

//@SpringBootApplication  //desactivamos para que no se ejecute
public class ZonaFitApplication implements CommandLineRunner {

	//Inyectamos una dependencia de Servicio hacia la clase de presentación
	@Autowired
	//tenemos nuestro objeto
	private IClienteServicio clienteServicio;

	//Para poder mandar información a consola Logger
	private static  final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);

	//variable nl (new line) para salto de línea genérica
	String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicación");
		//Levantar la fábrica de spring
		SpringApplication.run(ZonaFitApplication.class, args);
        logger.info("Aplicación finalizada\n" );
	}

	@Override
	public void run(String... args) throws Exception {
		 zonaFitApp();
	}

	private void zonaFitApp(){
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir){
			var opcion = mostrarMenu(consola);
			salir = ejecutarOpciones(consola, opcion);
			logger.info(nl);
		}
	}

	private int mostrarMenu(Scanner consola){
		logger.info("""
		\n*** Aplicación Zona Fit (GYM) ***
		1. Listar Clientes
		2. Buscar Cliente
		3. Agregar Cliente
		4. Modificar Cliente
		5. Eliminar Cliente
		6. Salir
		Elige una opción:\s""");
		return Integer.parseInt(consola.nextLine());
	}

	private boolean ejecutarOpciones(Scanner consola, int opcion){
		var salir = false;
		switch (opcion){
			case 1 -> {
				logger.info(nl + "--- Listado de Clientes ---" + nl);
				List<Cliente> clientes = clienteServicio.listarClientes();
				clientes.forEach(cliente -> logger.info(cliente.toString() + nl));
			}
			case 2 -> {
				logger.info(nl + "---Buscar Cliente por Id ---" + nl);
				logger.info(nl + "Introduce el id del Cliente a buscar: " + nl);
				var idCliente = Integer.parseInt(consola.nextLine());
                Cliente cliente = clienteServicio.buscarClientePorId(idCliente);//recuperamos desde base de datos
				if (cliente != null)
					logger.info("Cliente encontrado: " + cliente + nl);
				else
					logger.info("Cliente NO encontrado: " + cliente + nl);
			}
			case 3 -> {
				logger.info("--- Agregar Cliente ---" + nl);
				logger.info("Nombre: ");
				var nombre = consola.nextLine();
				logger.info("Apellido: ");
				var apellido = consola.nextLine();
				logger.info("Membresía: ");
				var membresia = Integer.parseInt(consola.nextLine());
				Cliente cliente = new Cliente();
				cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				cliente.setMembresia(membresia);
				clienteServicio.guardarCliente(cliente);
				logger.info("Cliente agregado: " + cliente + nl);
			}
			case 4 -> {
				logger.info("--- Modificar Cliente ---" + nl);
				logger.info("Id Cliente: ");
				var idCliente = Integer.parseInt(consola.nextLine());
				Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
				if (cliente != null) {
					logger.info("Nombre: ");
					var nombre = consola.nextLine();
					logger.info("Apellido: ");
					var apellido = consola.nextLine();
					logger.info("Membresía: ");
					var membresia = Integer.parseInt(consola.nextLine());
					cliente.setNombre(nombre);
					cliente.setApellido(apellido);
					cliente.setMembresia(membresia);
					clienteServicio.guardarCliente(cliente);
					logger.info("Cliente modificado: " + cliente + nl);
				} else {
					logger.info("Cliente NO encontrado" + cliente + nl);
				}
			}
			case 5 -> {
				logger.info("--- Eliminar Cliente ---" + nl);
				logger.info("Id Cliente a eliminar: ");
				var idCliente = Integer.parseInt(consola.nextLine());
				var cliente = clienteServicio.buscarClientePorId(idCliente);
				if (cliente != null){
					clienteServicio.eliminarCliente(cliente);
					logger.info("Cliente eliminado: " + cliente + nl);
				} else {
					logger.info("Cliente NO encontrado: " + cliente + nl);
				}
			}
			case 6 -> {
				logger.info("Hasta pronto!" + nl + nl);
				salir = true;
			}
			default -> logger.info("Opción NO válida: " + opcion + nl);
		}
		return salir;
	}
}
