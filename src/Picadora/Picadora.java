package Picadora;

import java.util.ArrayList;
import java.util.Iterator;

import Armas.*;
import Piezas.*;
import Usuarios.Crafter;

public class Picadora {
	private ArrayList<Arma> log = new ArrayList<Arma>();
	private int picadoraId;
	private int bonificacion;

	/**
	 * @param log
	 * @param picadoraId
	 */
	public Picadora(int id) {
		this.picadoraId = id;
	}

	public ArrayList<Arma> getLog() {
		return log;
	}

	public int getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}

	public void setLog(ArrayList<Arma> log) {
		this.log = log;
	}

	public int getPicadoraId() {
		return picadoraId;
	}

	public void setPicadoraId(int picadoraId) {
		this.picadoraId = picadoraId;
	}

	public void meterArmaPicadora(Arma arma) {
		this.log.add(arma);
	}

	static final String[] TIPOPieza = { "Cañon", "Cargador", "Chasis", "Culata", "Municion", "" };

	public boolean verificarCrafteo(ArrayList<Piezas> piezas) {
		boolean hayChasis = false;
		boolean hayCargador = false;
		boolean hayCanon = false;
		boolean hayMunicion = false;
		boolean hayCulata = false;
		for (Piezas pieza : piezas) {
			if (pieza.getTipo().equals(TIPOPieza[0])) {
				hayCanon = true;
			}
			if (pieza.getTipo().equals(TIPOPieza[1])) {
				hayCargador = true;
			}
			if (pieza.getTipo().equals(TIPOPieza[2])) {
				hayChasis = true;
			}
			if (pieza.getTipo().equals(TIPOPieza[3])) {
				hayCulata = true;
			}
			if (pieza.getTipo().equals(TIPOPieza[4])) {
				hayMunicion = true;
			}
		}
		if (hayCanon && hayCargador && hayChasis && hayCulata && hayMunicion) {
			return true;
		} else {
			return false;
		}
	}

	public void anadirArmaLog(Arma arma) {
		this.log.add(arma);
	}

	public Arma calcularArma(Arma arma, String tipoArma) {
		// daño
		arma.setDano((arma.getCanon().getDano() + arma.getChasis().getDanio() + arma.getCulata().getDanio() +arma.getCargadorO().getDano())
				* this.bonificacion);
		// precision
		arma.setPrecision((arma.getChasis().getEstabilidad() + arma.getCulata().getEstabilidad()
				+ arma.getCargadorO().getEstabilidad() +arma.getCanon().getPrecision()) * this.bonificacion);
		// probabilidadCritica
		arma.setProbabilidadCritica((arma.getChasis().getProbabilidadCritica() + arma.getCulata().getProbabilidadCritica()) * this.bonificacion);
		// dañoCritico
		arma.setDanoCritico(arma.getChasis().getDanioCritico() * this.bonificacion);
		// cadencia
		arma.setCadencia(arma.getChasis().getCadencia() * this.bonificacion);
		// cargador
		arma.setCargador(arma.getCargadorO().getCargador() * this.bonificacion);
		arma.setTipoArma(tipoArma);
		this.log.add(arma);
		return arma;
	}

	public void eliminarPiezasCandidatas(Crafter usuario, ArrayList<Piezas> piezas) {
		ArrayList<Piezas> piezasUsuario = new ArrayList<Piezas>();
		piezasUsuario = usuario.getPiezasUsuario();
		Iterator<Piezas> iteracion = piezasUsuario.iterator();
		while(iteracion.hasNext()) {
			Piezas pieza = iteracion.next();
			for(int i=0; i<piezas.size(); i++) {
				if(piezas.get(i).getIdPieza()==pieza.getIdPieza()) {
					iteracion.remove();
				}
			}
		}
		usuario.setPiezasUsuario(piezasUsuario);
		
		/*
		for (int i = 0; i < piezasUsuario.size(); i++) {
			for (int j = 0; j < piezas.size(); j++) {
				if (piezasUsuario.get(i).getIdPieza() == piezas.get(j).getIdPieza()) {
					System.out.println("Se va a eliminar "+piezasUsuario.get(i));
					piezasUsuario.remove(i);
				}
			}
		}*/
	}

	public void eliminarArmasCandidatas(ArrayList<Arma> armas, Crafter usuario) {
		ArrayList<Arma> piezasUsuario = new ArrayList<Arma>();
		piezasUsuario = usuario.getArmaUsuario();
		Iterator<Arma> iteracion = piezasUsuario.iterator();
		while(iteracion.hasNext()) {
			Arma arma = iteracion.next();
			for(int i=0; i<armas.size(); i++) {
				if(armas.get(i).getIdArma()==arma.getIdArma()) {
					iteracion.remove();
				}
			}
		}
		usuario.setArmaUsuario(piezasUsuario);
		
		/*ArrayList<Arma> armasUsuario = new ArrayList<Arma>();
		armasUsuario = usuario.getArmaUsuario();
		for (int i = 0; i < armasUsuario.size(); i++) {
			for (int j = 0; j < armas.size(); j++) {
				if (armasUsuario.get(i).getIdArma() == armas.get(j).getIdArma()) {
					System.out.println(armasUsuario.get(i));
					armasUsuario.remove(i);
				}
			}
		}
		usuario.setArmaUsuario(armasUsuario);*/
	}

	public boolean cumpleParaArmaConArma(ArrayList<Arma> armas) {
		if (armas.size() == 3) {
			return true;
		} else {
			return false;
		}
	}

	// int idArma, int dano, int precision, int probabilidadCritica, int
	// danoCritico, int cadencia, int cargador,
	// String rareza, String marca, String modelo, String tipoArma
	public Arma armaDesdeArma(ArrayList<Arma> armas, Crafter usuario) {
		String[] marcas = new String[3];
		String[] rareza = new String[3];
		int danio = 0;
		int precision = 0;
		int probabilidadCritica = 0;
		int danoCritico = 0;
		int cadencia = 0;
		int cargador = 0;
		String modelo = "Custom";
		for (int i = 0; i < armas.size(); i++) {
			marcas[i] = armas.get(i).getMarca();
			rareza[i] = armas.get(i).getRareza();
			danio += armas.get(i).getDano();
			precision += armas.get(i).getPrecision();
			probabilidadCritica += armas.get(i).getProbabilidadCritica();
			danoCritico += armas.get(i).getDanoCritico();
			cadencia += armas.get(i).getCadencia();
			cargador += armas.get(i).getCargador();
		}
		
		Arma arma = new Arma(usuario.getTotalArmas()+1, danio * this.bonificacion, precision * this.bonificacion,
				probabilidadCritica * this.bonificacion, danoCritico * this.bonificacion, cadencia * this.bonificacion,
				cargador * this.bonificacion, rareza[(int) (Math.random() * marcas.length - 1)],
				marcas[(int) (Math.random() * marcas.length - 1)], modelo, armas.get(0).getTipoArma());
		if(arma.getRareza().equals("Único")) {
			arma.setRareza("Comun");
			return arma;
		}else {
			return arma;
		}
	}
	public void listarPiezasArma(ArrayList<Piezas> piezasElegidas, ArrayList<Piezas> piezas) {
		
		System.out.println("*****************************************************************************");
		System.out.println("Estas son las piezas candidatas para hacer rifle, para montar arma inserta ID DE PIEZA");
		for(Piezas pie : piezas) {
			System.out.println(pie);
		}
		System.out.println("*****************************************************************************");
		System.out.println("Las piezas que tienes son:");
		for(Piezas pie : piezasElegidas) {
			System.out.println(pie);
		}
	}
	
	public void listarArmasCandidatas(ArrayList<Arma> armas, ArrayList<Arma> armasCandidatas) {
		System.out.println("*****************************************************************************");
		System.out.println("Te listo las armas que tienes que seleccionar para introducir");
		for(int i=0; i<armas.size(); i++) {
			System.out.println(armas.get(i));
		}
		System.out.println("*****************************************************************************");
		System.out.println("Armas seleccionadas");
		for(Arma arm : armasCandidatas) {
			System.out.println(arm);
		}
	}

	public boolean existePieza(ArrayList<Piezas> piezas, int id) {
		for(Piezas pie : piezas) {
			if(pie.getIdPieza()==id) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Picadora [ picadoraId=" + picadoraId + " log=" + log + " bonificación= " + bonificacion + "]";
	}

}
