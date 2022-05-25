package Programa;

import java.time.LocalDate;
import java.util.ArrayList;
import Armas.Arma;
import Dummy.*;
import Picadora.*;
import Piezas.*;
import Usuarios.*;
/**Añadidos detalles menu cragter*/
public class HelperCrafter {
	static final String RAREZA = "Comun";
	static final String MARCAC = "custom";
	static final String MODELO = "custom";
	static final String[] TIPOArma = { "Pistola", "Rifle", "Escopeta", "" };
	static final String[] TIPOPieza = { "Cañon", "Cargador", "Chasis", "Culata", "Municion", "" };
	static final String[] MARCA = { "Hyperion", "Atlas", "Dahl", "Jakobs", "Maliwan", "Tediore", "Torgue", "Vladof",
			"Bandit", "Gearbox", "" };
	static final String[] RAREZAS = { "Comun", "Poco comun", "Raro", "Extraño", "Extravagante", "Épico", "Único", "" };

	static public void anadirPiezaCrafter(WrapperScanner input, Crafter usuario) {
		char confirmacion;
		char confirmacionParte;
		Piezas pieza;
		do {
			System.out.println("Creación de piezas");
			int dano;
			int dispersion;
			int cargador;
			int probabilidadCritica;
			int danoCritico;
			int cadencia;
			int calibre;
			int estabilidad;
			String tipoArma = TIPOArma[(int) (Math.random() * (TIPOArma.length - 1))];
			String tipoPieza = TIPOPieza[(int) (Math.random() * (TIPOPieza.length - 1))];
			System.out.println(tipoArma);
			System.out.println(tipoPieza);
			if (tipoPieza.equals(TIPOPieza[0])) {
				// int idPieza, String marca, String modelo, LocalDate fechaObtencion, String
				// tipo, int dano, int dispersion
				int precision = (int) (Math.random()*100)+1;
				dano = (int) (Math.random() * 20) + 1;
				dispersion = (int) (Math.random() * 10);
				pieza = new Canon(usuario.getTotalPiezas(), MARCA[(int) (Math.random() * (MARCA.length - 1))], obtenerMarcaAleatoria(),
						LocalDate.now(), tipoPieza, tipoArma, dano, dispersion, precision);
				System.out.println(pieza);
				System.out.println("Esta es tu pieza? (Y/N)");
				confirmacionParte = input.metodoQueDaCadenaDeTexto().toUpperCase().charAt(0);
				if (confirmacionParte == 'Y') {
					usuario.anadirPieza(pieza);
					System.out.println("Pieza añadida con éxito");
				} else {
					System.out.println("No se añadió la pieza");
				}
			} else if (tipoPieza.equals(TIPOPieza[1])) {
				dano = (int)(Math.random()*100)+1;
				estabilidad = (int) (Math.random() * 100);
				cargador = (int) (Math.random() * 25) + 1;
				pieza = new Cargador(usuario.getTotalPiezas(), MARCA[(int) (Math.random() * (MARCA.length - 1))],
						obtenerMarcaAleatoria(), LocalDate.now(), tipoPieza, tipoArma, cargador, estabilidad, dano);
				System.out.println(pieza);
				System.out.println("¿Quieres esta pieza? (Y/N)");
				confirmacion = input.metodoQueDaCadenaDeTexto().toUpperCase().charAt(0);
				if (confirmacion == 'Y') {
					usuario.anadirPieza(pieza);
					System.out.println("Pieza añadida con éxito");
				} else {
					System.out.println("No se añadió la pieza");
				}
			} else if (tipoPieza.equals(TIPOPieza[2])) {
				// int danio, int estabilidad, int cadencia, int dispersion, int
				// probabilidadCritica, int danioCritico
				dano = (int) (Math.random() * 100) + 1;
				estabilidad = (int) (Math.random() * 100);
				dispersion = (int) (Math.random() * 10);
				probabilidadCritica = (int) (Math.random() * 100);
				danoCritico = (int) (Math.random() * 5) + 2;
				cadencia = (int) (Math.random() * 10) + 1;
				pieza = new Chasis(usuario.getTotalPiezas(), MARCA[(int) (Math.random() * (MARCA.length - 1))], obtenerMarcaAleatoria(),
						LocalDate.now(), tipoPieza, tipoArma, dano, estabilidad, cadencia, dispersion,
						probabilidadCritica, danoCritico);
				System.out.println(pieza);
				System.out.println("¿Quieres esta pieza? (Y/N)");
				confirmacion = input.metodoQueDaCadenaDeTexto().toUpperCase().charAt(0);
				if (confirmacion == 'Y') {
					usuario.anadirPieza(pieza);
					System.out.println("Pieza añadida con éxito");
				} else {
					System.out.println("No se añadió la pieza");
				}
			} else if (tipoPieza.equals(TIPOPieza[3])) {
				probabilidadCritica = (int) (Math.random()*50)+1;
				dano = (int) (Math.random() * 20) + 1;
				estabilidad = (int) (Math.random() * 100);
				pieza = new Culata(usuario.getTotalPiezas(), MARCA[(int) (Math.random() * (MARCA.length - 1))], obtenerMarcaAleatoria(),
						LocalDate.now(), tipoPieza, tipoArma, estabilidad, dano, probabilidadCritica);
				System.out.println(pieza);
				System.out.println("¿Quieres esta pieza? (Y/N)");
				confirmacion = input.metodoQueDaCadenaDeTexto().toUpperCase().charAt(0);
				if (confirmacion == 'Y') {
					usuario.anadirPieza(pieza);
					System.out.println("Pieza añadida con éxito");
				} else {
					System.out.println("No se añadió la pieza");
				}
			} else if (tipoPieza.equals(TIPOPieza[4])) {
				dano = (int) (Math.random() * 20) + 1;
				probabilidadCritica = (int) (Math.random() * 100);
				danoCritico = (int) (Math.random() * 5) + 2;
				cadencia = (int) (Math.random() * 10) + 1;
				calibre = (int) (Math.random() * 3) + 1;
				pieza = new Municion(usuario.getTotalPiezas(), MARCA[(int) (Math.random() * (MARCA.length - 1))],
						obtenerMarcaAleatoria(), LocalDate.now(), tipoPieza, tipoArma, dano, calibre, probabilidadCritica, danoCritico);
				System.out.println(pieza);
				System.out.println("¿Quieres esta pieza? (Y/N)");
				confirmacion = input.metodoQueDaCadenaDeTexto().toUpperCase().charAt(0);
				if (confirmacion == 'Y') {
					usuario.anadirPieza(pieza);
					System.out.println("Pieza añadida con éxito");
				} else {
					System.out.println("No se añadió la pieza");
				}
			} else {
				System.out.println("Mala suerte amigo, no pudiste generar una pieza de la picadora");
			}
			System.out.println("¿quieres generar otra pieza? (N para parar)");
			confirmacion = input.metodoQueDaCadenaDeTexto().toUpperCase().charAt(0);
		} while (confirmacion != 'N');
	}

	static public void anadirArmaCrafter(WrapperScanner input, Crafter usuario) {
		char confirmacion;
		Arma arma;
		do {
			System.out.println("Añadir armas");
			// int dano, int precision, int probabilidadCritica, int danoCritico, int
			// cadencia, String rareza, String marca, String modelo
			int dano = (int) (Math.random() * 300) + 1;
			int precision = (int) (Math.random() * 300) + 1;
			int probabilidadCritica = (int) (Math.random() * 300) + 1;
			int danoCritico = (int) (Math.random() * 20) + 1;
			int cadencia = (int) (Math.random() * 300) + 1;
			int cargador = (int) (Math.random() * 100) + 1;
			// static final String[] RAREZAS = {"Comun", "Poco comun", "Raro", "Extraño",
			// "Extravagante", "Épico", "Único", ""};
			arma = new Arma(usuario.getTotalArmas(), dano, precision, probabilidadCritica, danoCritico, cadencia,
					cargador, RAREZAS[(int) (Math.random() * RAREZAS.length - 1)],
					MARCA[(int) (Math.random() * (MARCA.length - 1))], "B24",
					TIPOArma[(int) (Math.random() * (TIPOArma.length - 1))]);
			System.out.println(arma);
			System.out.println("¿Quieres este arma? (Y/N)");
			confirmacion = input.metodoQueDaCadenaDeTexto().toUpperCase().charAt(0);
			if (confirmacion == 'Y') {
				usuario.anadirArma(arma);
				System.out.println("Arma de otro fabricante añadida con éxito");
			} else {
				System.out.println("No se añadió el arma");
			}
		} while (confirmacion != 'N');
	}

	static public void eliminarPieza(WrapperScanner input, Crafter usuario) {
		char confirmacion = 'a';
		int id;
		do {
			usuario.listarPiezas();
			System.out.println("Selecciona la pieza que quieras borrar (Elimina por ID)");
			id = input.metodoQueObtieneIntSeguro();
			if (id == -1 || usuario.getPiezaPorId(id) == null) {
				System.out.println("No existe");
				confirmacion = 'N';
			} else {
				System.out.println("El id seleccionado es " + id + " ¿Es esta la pieza a eliminar? (Y/N)");
				confirmacion = input.metodoQueDaCadenaDeTexto().toUpperCase().charAt(0);
			}
		} while (confirmacion != 'Y' && confirmacion != 'N');
		if (confirmacion == 'Y') {
			usuario.eliminarPiezaPorId(id);
			System.out.println("Pieza eliminada");
		} else {
			System.out.println("No se ha borrado nada");
		}
	}

	static public void eliminarArma(WrapperScanner input, Crafter usuario) {
		char confirmacion = 'a';
		int id;
		do {
			usuario.listarArmas();
			System.out.println("Selecciona el arma que quieres borrar (Elimina por ID)");
			id = input.metodoQueObtieneIntSeguro();
			if (id == -1 || usuario.getArmaPorId(id) == null) {
				System.out.println("No existe");
				confirmacion = 'N';
			} else {
				System.out.println("El id seleccionado es " + id + " ¿Es esta el arma a eliminar? (Y/N)");
				confirmacion = input.metodoQueDaCadenaDeTexto().toUpperCase().charAt(0);
			}
		} while (confirmacion != 'Y' && confirmacion != 'N');
		if (confirmacion == 'Y') {
			usuario.eliminarArmaPorId(id);
			System.out.println("Pieza eliminada");
		} else {
			System.out.println("No se ha borrado nada");
		}
	}

//	static final String[] TIPOPieza = {"Cañon","Cargador","Chasis","Culata","Municion",""};
	static public void crearArma(WrapperScanner input, Crafter usuario, ListadoPicadora picadoras) {
		System.out.println("¿Qué tipo de arma quieres? (Escopeta/Pistola/Rifle)");
		String tipoArma = input.metodoQueDaCadenaDeTexto();
		ArrayList<Piezas> piezas = usuario.listarPorTipo(tipoArma);
		if (picadoras.darIdPicadora() == 0) {
			System.out.println("Sin picadoras no puedes producir armas");
		} else if (!usuario.cumpleParaArma(piezas)) {
			System.out.println("Te falta un tipo de pieza para seguir");
		} else {
			ArrayList<Piezas> piezasElegidas = new ArrayList<Piezas>();
			Picadora picadora = seleccionarPicadora(input, picadoras);
			boolean pausar = false;
			do {
				picadora.listarPiezasArma(piezasElegidas, piezas);
				int id = input.metodoQueObtieneIntSeguro();
				if (id == -1 || !picadora.existePieza(piezas, id)) {
					System.out.println("No puedes meter se ID de pieza");
				} else {
					Piezas pieza = usuario.seleccionarPieza(id, piezas);
					if (usuario.hayPieza(piezasElegidas, pieza)) {
						System.out.println("Ya has metido una pieza de ese tipo");
					} else {
						piezasElegidas.add(pieza);
					}
				}
				// Chasis chasis, Canon canon, Culata culata, Cargador cargador, Municion
				// municion
				// Switches cañon cargador chasis culata municion
				if (usuario.cumpleParaArma(piezasElegidas) == true) {
					System.out.println("Esta es tu arma");
					Arma arma = new Arma(usuario.getTotalArmas(), usuario.getChasisArma(piezasElegidas),
							usuario.getCanonArma(piezasElegidas), usuario.getCulataArma(piezasElegidas),
							usuario.getCargadorArma(piezasElegidas), usuario.getMunicionArma(piezasElegidas));
					arma.setRareza(RAREZA);
					arma.setMarca(MARCAC);
					arma.setModelo(MODELO);
					picadora.calcularArma(arma, tipoArma);
					System.out.println(arma);
					System.out.println("Quieres este arma? Y/N");
					char finSeleccion = input.metodoQueDaCadenaDeTexto().toUpperCase().charAt(0);
					if (finSeleccion == 'Y') {
						usuario.anadirArma(arma);
						System.out.println("Se añadió arma con éxito");
						picadora.eliminarPiezasCandidatas(usuario, piezasElegidas);
						piezasElegidas.clear();
						picadora.anadirArmaLog(arma);
						pausar = true;
					} else {
						piezasElegidas.clear();
						System.out.println("Selecciona de nuevo todas las piezas");
					}
				}
			} while (pausar == false);
		}
	}

	static public void crearArmaPorArmas(WrapperScanner input, Crafter usuario, ListadoPicadora picadoras) {
		System.out.println("¿A qué tipo de armas quieres que aumentemos la rareza? (Escopeta/Pistola/Rifle)");
		String tipoArma = input.metodoQueDaCadenaDeTexto();
		ArrayList<Arma> armas = usuario.listarPorTipoArma(tipoArma);
		if (picadoras.darIdPicadora() == 0) {
			System.out.println("Sin picadoras no puedes producir armas");
		} else if (!usuario.armasCumplenParaArma(armas, tipoArma)) {
			System.out.println("Te faltan armas de tipo " + tipoArma + " para poder aumentar su rareza");
		} else {
			ArrayList<Arma> armasCandidatas = new ArrayList<Arma>();
			Picadora picadora = seleccionarPicadora(input, picadoras);
			boolean pausar = false;
			do {
				picadora.listarArmasCandidatas(armas, armasCandidatas);
				System.out.println("Selecciona arma por ID");
				int id = input.metodoQueObtieneIntSeguro();
				if (id == -1 && usuario.getPiezaPorId(id) == null) {
					System.out.println("No existe ese arma");
				}else if(!usuario.getArmaPorId(id).getTipoArma().equals(tipoArma)) {
					System.out.println("Ese arma no puedes cogerla aunque la tengas en el inventario no es del tipo "+tipoArma);
				}else {
					if (!usuario.armasCumplenParaArma(armasCandidatas, tipoArma)) {
						armasCandidatas.add(usuario.getArmaPorId(id));
					} else {
						System.out.println("Esta es el arma que ha salido");
						Arma arma = picadora.armaDesdeArma(armasCandidatas, usuario);
						System.out.println(arma);
						System.out.println("¿Quieres este arma? (Y/N)");
						if (input.metodoQueDaCadenaDeTexto().toUpperCase().charAt(0) == 'Y') {
							usuario.anadirArma(arma);
							picadora.eliminarArmasCandidatas(armasCandidatas, usuario);
							picadora.anadirArmaLog(arma);
							armasCandidatas.clear();
							pausar = true;
						} else {
							System.out.println("Selecciona de nuevo");
							armasCandidatas.clear();
						}
					}
				}
			} while (pausar == false);
		}
	}

	static Picadora seleccionarPicadora(WrapperScanner input, ListadoPicadora picadoras) {
		boolean pausar = false;
		Picadora picadora;
		do {
			picadoras.listar();
			System.out.println("Selecciona picadora por ID");
			int id = input.metodoQueObtieneIntSeguro();
			picadora = picadoras.seleccionarPorId(id);
			if (picadora != null) {
				System.out.println("Picadora " + picadora + " seleccionada");
				pausar = true;
			} else {
				System.out.println("Selecciona una picadora que exista o llama a un piquero para que te haga una");
			}
		} while (pausar == false);
		return picadora;
	}
	
	static String obtenerMarcaAleatoria() {
		String cadena = "";
		for(int i=0; i<5; i++) {
			cadena +=(char)((int)(Math.random()*122)+48);
		}
		return cadena;
	}
	
	static void galeriaDeTiro(Crafter usuario, ListadoDummies dummies, WrapperScanner input) {
		/*metodo para comprobar si hay dummies en la lista
		 * metodo que seleccione dummies
		 * metodo que seleccione arma crafter
		 * metodo que dispare a un dummie*/
		dummies.listar();
		System.out.println("Introduce el id del señor/a que quieres que reciba tiros");
		int id = input.metodoQueObtieneIntSeguro();
		Dummy dummy = dummies.obtenerDummyId(id);
		if (dummy==null) {
			System.out.println("No se puede disparar a lo que no existe... o sí!, pero no podras saber si tu arma... Mata");
		}else {
			char caracter;
			Arma armaAUsar;
			do {
				System.out.println("Este es tu señuelo de pruebas: "+dummy);
				usuario.listarArmas();
				System.out.println("Selecciona tu arma para derrotarlo, pon el id de arma");
				int idArma = input.metodoQueObtieneIntSeguro();
				armaAUsar = usuario.getArmaPorId(idArma);
				if(idArma<0 && armaAUsar==null) {
					System.out.println("No puedes usar un arma que no existe");
					caracter = 'N';
				}else {
					System.out.println("Esta es tu arma: "+armaAUsar);
					System.out.println("Esta es la configuración ¿estás de acuerdo? (Y/N)");
					caracter = input.metodoQueDaCadenaDeTexto().toUpperCase().charAt(0);					
				}
			}while(caracter!='Y');
			System.out.println("Vamos a ver como pega");
			for (int i=0; i<armaAUsar.getCargador(); i++) {
				int dano = armaAUsar.dispararArma();
				dummy.danoRecibido(dano);
				System.out.println(dummy.getNombre()+" tiene "+dummy.getEscudo()+" de escudo "+dummy.getArmadura()+" de armadura y "+dummy.getVida()+" de vida");
			}
		}
	}
	public static void borrarTodo(Crafter cra, WrapperScanner input) {
		boolean fin = false;
		boolean confirmar = false;
		do {
			System.out.println("Quieres borrar todas las armas y piezas?");
			char caracter = input.metodoQueDaCadenaDeTexto().toUpperCase().charAt(0);
			if(caracter=='Y') {
				confirmar = true;
				fin=true;
			}else if (caracter =='N') {
				confirmar = false;
				fin=true;
			}
		}while(fin==false);
		if(confirmar==true) {
			cra.borrarTodasLasArmas();
			cra.borrarTodasLasPiezas();			
			System.out.println("Se han borrado todas las pertenencias");
		}else {
			System.out.println("No se han realizado cambios");
		}
	}
}
