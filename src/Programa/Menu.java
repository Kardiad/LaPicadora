package Programa;

import Dummy.ListadoDummies;
import Picadora.ListadoPicadora;
import Usuarios.ListaUsuarios;
import Usuarios.Piquero;
import Usuarios.Usuario;
import Usuarios.Crafter;
import Usuarios.Admin;
import Programa.HelperMenu;
/**
 * @author jafet
 * @version definitiva
 * */
public class Menu {
	
	static WrapperScanner input = new WrapperScanner();
	static final String USERA = "Admin";
	static final String USERC = "Crafter";
	static final String USERP = "Piquero";
	
	public static void main (String[] args) {
		ListaUsuarios usuarios = new ListaUsuarios();
		ListadoPicadora picadora = new ListadoPicadora();
		ListadoDummies dummies = new ListadoDummies();
		boolean fin = false;
		do {
			System.out.println("Qué quieres hacer");
			System.out.println("1-Sign in");
			System.out.println("2-Loggin");
			System.out.println("3-Viajar con mi equipo");
			int opcion = input.metodoQueObtieneIntSeguro();
			switch(opcion) {
			case 1:
				System.out.println("Bienvenido a la picadora, vienes "
						+ "a formar parte de la familia de cajeros de armas "
						+ "más grande");
				System.out.println("Introduce que tipo de usuario eres");
				System.out.println("1-Crafter (Haces armas y poco mas)");
				System.out.println("2-Piquero (Vigilas las LaPicadora)");
				System.out.println("3-Admin (Puedes echar gente y controlarla)");
				int option = input.metodoQueObtieneIntSeguro();
				switch(option) {
				case 1:
					System.out.println("Introduce nombre de usuario");
					String nombreUsuario = input.metodoQueDaCadenaDeTexto();
					System.out.println("Introduce contraseña");
					String passwordUusuario = input.metodoQueDaCadenaDeTexto();
					String passwordHaseado = Hash.setPasswordEncriptado(passwordUusuario);
					if(passwordHaseado.equals("")) {
						System.out.println("Usuario no válido");
					}else {
						Crafter userC = new Crafter(nombreUsuario, passwordHaseado, "Crafter");
						userC.setIdUsuario(usuarios.usuariosTotales());
						usuarios.setListado(userC);						
					}
					break;
				case 2:
					System.out.println("Introduce nombre de usuario");
					nombreUsuario = input.metodoQueDaCadenaDeTexto();
					System.out.println("Introduce contraseña");
					passwordUusuario = input.metodoQueDaCadenaDeTexto();
					String passwordHas = Hash.setPasswordEncriptado(passwordUusuario);
					if(passwordHas.equals("")) {
						System.out.println("Usuario no válido");
					}else {
						Piquero userP = new Piquero(nombreUsuario, passwordHas, "Piquero");
						userP.setIdUsuario(usuarios.usuariosTotales());
						usuarios.setListado(userP);
					}
					break;
				case 3:
					System.out.println("Introduce nombre de usuario");
					nombreUsuario = input.metodoQueDaCadenaDeTexto();
					System.out.println("Introduce contraseña");
					passwordUusuario = input.metodoQueDaCadenaDeTexto();
					String passwordHashAdmin = Hash.setPasswordEncriptado(passwordUusuario);
					if(passwordHashAdmin.equals("")) {
						System.out.println("Usuario no válido");
					}else {
						Admin userA = new Admin(nombreUsuario, passwordHashAdmin, "Admin");
						userA.setIdUsuario(usuarios.usuariosTotales());
						usuarios.setListado(userA);
					}
					break;
				}
				break;
			case 2:
				System.out.println("Introduce tus credenciales");
				System.out.println("Introduce nombre");
				String nombre = input.metodoQueDaCadenaDeTexto();
				System.out.println("Introduce contraseña");
				String contrasena = Hash.setPasswordEncriptado(input.metodoQueDaCadenaDeTexto());
				if(usuarios.validarUusario(nombre, contrasena)) {
					Usuario user = usuarios.obtenerUsuario(nombre, contrasena);
					switch(user.getTipo()) {
					case USERA:
							Admin admin = usuarios.obtenerAdmin(nombre, contrasena);
							HelperMenu.adminMenu(input, usuarios.obtenerLista(), admin);
						break;
					case USERC:
							Crafter cra = usuarios.obtenerCrafter(nombre, contrasena);
							HelperMenu.crafterMenu(input, cra, picadora, dummies, usuarios);
						break;
					case USERP:
							Piquero piq = usuarios.obtenerPiquero(nombre, contrasena);
							HelperMenu.piqueroMenu(input, piq, picadora, dummies, usuarios);
						break;
					}
				}else {
					System.out.println("Este usuario no existe");
				}
				break;
			case 3:
				System.out.println("Viaja por los planetas y no olvides que somos tu proveedor de armas favorito");
				fin=true;
				break;
			}
		}while(fin==false);
		input.cerrarWrapper();
	}
}
