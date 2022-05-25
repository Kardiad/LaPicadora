package Programa;

import java.util.ArrayList;

import Dummy.*;
import Picadora.ListadoPicadora;
import Usuarios.*;

public class HelperMenu {
	/**
	 * todo el menu del crafter y sus opciones
	 * */
	static public void crafterMenu(WrapperScanner input, Crafter usuario, ListadoPicadora picadoras, ListadoDummies dummies, ListaUsuarios listado) {
		boolean fin = false;
		do {
			System.out.println("Crafter! Este es tu menú");
			System.out.println("Hola: "+usuario.getNombre()+" Estamos esperando tus gestiones en nuestro programa");
			System.out.println("1-Añadir piezas");
			System.out.println("2-Añadir arma de otro fabricante");
			System.out.println("3-Crear arma en torno a piezas");
			System.out.println("4-Crear arma en torno a armas");
			System.out.println("5-Eliminar arma del inventario");
			System.out.println("6-Eliminar pieza del inventario");
			System.out.println("7-Listar inventario piezas");
			System.out.println("8-Listar inventario armas");
			System.out.println("9-Usar un arma para matar dummies");
			System.out.println("10-Borrar todo");
			System.out.println("11-Reportar Usuario");
			System.out.println("12-Salir");
			int opcion = input.metodoQueObtieneIntSeguro();
			switch(opcion) {
			case 1:
				HelperCrafter.anadirPiezaCrafter(input, usuario);
				break;
			case 2:
				HelperCrafter.anadirArmaCrafter(input, usuario);
				break;
			case 3:
				System.out.println("Creación de arma por piezas");
				HelperCrafter.crearArma(input, usuario, picadoras);
				break;
			case 4:
				System.out.println("Crear armas por armas");
				HelperCrafter.crearArmaPorArmas(input, usuario, picadoras);
				break;
			case 5:
				HelperCrafter.eliminarArma(input, usuario);
				break;
			case 6:
				HelperCrafter.eliminarPieza(input, usuario);
				break;
			case 7:
				System.out.println("Listar inventario piezas");
				usuario.listarPiezas();
				break;
			case 8:
				System.out.println("Listar inventario armas");
				usuario.listarArmas();
				break;
			case 9:
				System.out.println("Bienvenid@ a nuestra galería de tiro");
				HelperCrafter.galeriaDeTiro( usuario, dummies, input);
				break;
			case 10:
				System.out.println("Has elegido borrar todo");
				HelperCrafter.borrarTodo(usuario, input);
				break;
			case 11:
				System.out.println("Has elegido reportar usuario");
				System.out.println("Introduce nombre usuario para reportar");
				Usuario usu = listado.obtenerUsuario(input.metodoQueDaCadenaDeTexto());
				if(usu != null) {
					int cantidadReportes = usu.getReportes();
					cantidadReportes++;
					usu.setReportes(cantidadReportes);
				}else {
					System.out.println("EL usuario seleccionado no existe elija otra opcion");
				}
				break;
			case 12:
				System.out.println("Saliste del programa");
				fin=true;
				break;
			default:
				System.out.println("Opción no disponible");
				break;
			}
		}while(fin == false);
	}
	/**
	 * menu piquero y opciones
	 * */
	static public void piqueroMenu(WrapperScanner input, Piquero user, ListadoPicadora picadora, ListadoDummies dummies, ListaUsuarios listado) {
		boolean fin = false;
		do {
			System.out.println("Piquero! "+user.getNombre()+" Este es tu menú");
			System.out.println("1-Crear picadora");
			System.out.println("2-Listar picadoras");
			System.out.println("3-Eliminar picadora");
			System.out.println("4-Crear dummy");
			System.out.println("5-Listar dummy");
			System.out.println("6-Reportar Usuario");
			System.out.println("7-Borrar dummys");
			System.out.println("8-Cerrar sesion");
			int opcion = input.metodoQueObtieneIntSeguro();
			switch(opcion) {
			case 1:
				System.out.println("Crear picadora");
				user.crearPicadora(picadora);
				break;
			case 2:
				System.out.println("Listar picadoras");
				user.listarPicadorasPiquero();
				break;
			case 3:
				System.out.println("Borrar Picadora");
				int id = input.metodoQueObtieneIntSeguro();
				user.eliminarPicadora(id);
				break;
			case 4:
				System.out.println("Crear un dummy");
				Dummy dummy = new Dummy(0,"Holas quiero morir");
				dummy.setEstaMuerto(true);
				dummies.anadirDummies(dummy);
				user.crearDummy(dummies);
				break;
			case 5:
				System.out.println("Listar dummies del usuario");
				user.listarDummies();
				System.out.println("Listar los dummies publicos");
				dummies.listar();
				break;
			case 6:
				System.out.println("Borrar dummies");
				dummies.borrarDummy();
				break;
			case 7:
				System.out.println("Has elegido reportar usuario");
				System.out.println("Introduce nombre usuario para reportar");
				Usuario usu = listado.obtenerUsuario(input.metodoQueDaCadenaDeTexto());
				if(usu != null) {
					int cantidadReportes = usu.getReportes();
					cantidadReportes++;
					usu.setReportes(cantidadReportes);
				}else {
					System.out.println("EL usuario seleccionado no existe elija otra opcion");
				}
				break;
			case 8:
				System.out.println("Saliste con éxito");
				fin=true;
				break;
			default:
				System.out.println("Opción no disponible");
				break;
			}
		}while(fin == false);
	}
	/**
	 * opciones del menu del admin
	 * */
	static public void adminMenu(WrapperScanner input, ArrayList<Usuario> usuarios, Admin user) {
		boolean fin = false;
		do {
			System.out.println("Admin! Este es tu menú");
			System.out.println("1-Listar Usuario");
			System.out.println("2-Buscar por id");
			System.out.println("3-Eliminar Usuario");
			System.out.println("4-Listar usuarios reportados");
			System.out.println("5-Cerrar sesion");
			int opcion = input.metodoQueObtieneIntSeguro();
			switch(opcion) {
			case 1:
				System.out.println("Listar Usuario");
				user.listarUsuarios(usuarios);
				break;
			case 2:
				System.out.println("Buscar por id");
				System.out.println("Introduce id");
				int id = input.metodoQueObtieneIntSeguro();
				System.out.println(user.buscarUsuario(usuarios, id));
				break;
			case 3:
				System.out.println("Eliminar Usuario");
				System.out.println("Introduce id de usuario");
				int identificador = input.metodoQueObtieneIntSeguro();
				user.eliminarUusario(usuarios, identificador);
				break;
			case 4:
				System.out.println("Listar usuarios reportados");
				user.listarUsuariosReportados(usuarios);
				break;
			case 5:
				System.out.println("Saliste con éxito");
				fin=true;
				break;
			default:
				System.out.println("Opción no disponible");
				break;
			}
		}while(fin == false);
	}
}
