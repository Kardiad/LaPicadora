package Usuarios;

import java.util.ArrayList;
import java.util.Iterator;
import Armas.Arma;
import Piezas.*;

public class Crafter extends Usuario {

	private ArrayList<Arma> armaUsuario;
	private ArrayList<Piezas> piezasUsuario;
	
	
	/**
	 * @param nombre
	 * @param contrasena
	 * @param tipo
	 * constructor 
	 */
	public Crafter(String nombre, String contrasena, String tipo) {
		super(nombre, contrasena, tipo);
		this.armaUsuario=new ArrayList<Arma>();
		this.piezasUsuario= new ArrayList<Piezas>();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Arma> getArmaUsuario() {
		return armaUsuario;
	}

	public void setArmaUsuario(ArrayList<Arma> armaUsuario) {
		this.armaUsuario = armaUsuario;
	}
	
	public ArrayList<Piezas> getPiezasUsuario() {
		return piezasUsuario;
	}
	
	public int totalArmas() {
		return this.armaUsuario.size();
	}
	
	public int totalPiezas() {
		return this.piezasUsuario.size();
	}
	
	public void setPiezasUsuario(ArrayList<Piezas> piezasUsuario) {
		this.piezasUsuario = piezasUsuario;
	}
	
	public void anadirArma(Arma arma) {
		this.armaUsuario.add(arma);
	}
	
	public void anadirPieza(Piezas pieza) {
		this.piezasUsuario.add(pieza);
	}
	public int getTotalPiezas() {
		return piezasUsuario.size();
	}
	public int getTotalArmas() {
		return armaUsuario.size();
	}
	/**
	 * 
	 *lista piezas usuario
	 * */
	public void listarPiezas() {
		for(Piezas piezas : this.piezasUsuario) {
			System.out.println(piezas);
		}
	}
	/**
	 * 
	 *lista armas usuario
	 * */
	public void listarArmas() {
		for(Arma armas : this.armaUsuario) {
			System.out.println(armas);
		}
	}
	/**
	 *@param id
	 *elimina una pieza por id 
	 *
	 * */
	public void eliminarPiezaPorId(int id) {
		for(int i=0; i<this.piezasUsuario.size(); i++) {
			if(this.piezasUsuario.get(i).getIdPieza()==id) {
				this.piezasUsuario.remove(i);
			}
		}
	}
	/**
	 *@param id
	 *elimina un arma por id 
	 *
	 * */
	public void eliminarArmaPorId(int id) {
		for(int i=0; i<this.armaUsuario.size(); i++) {
			if(this.armaUsuario.get(i).getIdArma()==id) {
				this.armaUsuario.remove(i);
				System.out.println("Arma eliminada");
			}
		}
	}
	/**
	 *@param posicion
	 *comprueba si puedes borrar arma y si lo hace lo hace por posicion 
	 *
	 * */
	public void eliminarArma(int posicion) {
		if(posicion>this.armaUsuario.size()) {
			System.out.println("No tienes tantas armas broh");
		}else if(posicion<0){
			System.out.println("No puedes tener negativo en armas");
		}else{
			this.armaUsuario.remove(posicion);			
		}
	}
	/**
	 *@param tipo
	 *lista piezas por tipo devolviendo lista
	 *
	 * */
	public ArrayList<Piezas> listarPorTipo(String tipo) {
		ArrayList<Piezas> piezasCandidatas = new ArrayList<Piezas>();
		for(int i=0; i<this.piezasUsuario.size(); i++) {
			if(this.piezasUsuario.get(i).getTipoArma().equals(tipo)) {
				piezasCandidatas.add(piezasUsuario.get(i));
			}
		}
		return piezasCandidatas;
	}
	/**
	 *@param id
	 *lista por tipo de arma devolviendo lista 
	 *
	 * */
	public ArrayList<Arma> listarPorTipoArma(String tipo){
		ArrayList<Arma> armasCandidatas = new ArrayList<Arma>();
		for(int i=0; i<this.armaUsuario.size(); i++) {
			if(this.armaUsuario.get(i).getTipoArma().equals(tipo)) {
				armasCandidatas.add(armaUsuario.get(i));
			}
		}
		return armasCandidatas;
	}
	/**
	 *@param id
	 *@param piezas
	 *eselecciona piezas de un array de piezas devolvéndola
	 *
	 * */
	public Piezas seleccionarPieza(int id, ArrayList<Piezas> piezas) {
		for(int i=0; i<piezas.size(); i++) {
			if(piezas.get(i).getIdPieza()==id) {
				return piezas.get(i);
			}
		}
		return null;
	}
	/**
	 *@param id
	 *@param piezas
	 *existe pieza  que sean del mismo tipo que una
	 *
	 * */
	public boolean hayPieza(ArrayList<Piezas> piezas, Piezas pieza) {
		for(int i=0; i<piezas.size(); i++) {
			for(int j=0; j<piezas.size(); j++) {
				if(piezas.get(i).getTipo().equals(pieza.getTipo())) {
					return true;
				}				
			}
		}
		return false;
	}
	/**
	 *@param id
	 *da arma por id
	 *
	 * */
	public Arma getArmaPorId(int id) {
		for(Arma arm : this.armaUsuario) {
			if(arm.getIdArma()==id) {
				return arm;
			}
		}
		return null;
	}
	/**
	 *@param id
	* da pieza por id
	 * */
	public Piezas getPiezaPorId(int id) {
		for(Piezas pie : this.piezasUsuario) {
			if(pie.getIdPieza()==id) {
				return pie;
			}
		}
		return null;
	}
	/**
	 *@param armas
	 *@param tipo
	 *comprueba si las piezas pueden hacer un arma
	 *
	 * */
	static final String[] TIPOPieza = {"Cañon","Cargador","Chasis","Culata","Municion",""};
	public boolean armasCumplenParaArma(ArrayList<Arma> armas, String tipo) {
		int count = 0;
		for(int i=0; i<armas.size(); i++) {
			if(armas.get(i).getTipoArma().equals(tipo)) {
				count++;
			}
		}
		if(count>=2) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 *
	 *@param piezas
	 *te muestra si cumple para hacer un arma
	 *
	 * */
	public boolean cumpleParaArma(ArrayList<Piezas> piezas) {
		boolean canon = false;
		boolean chasis = false;
		boolean culata = false;
		boolean cargador = false;
		boolean municion = false;
		for(int i=0; i<piezas.size(); i++) {
			if(piezas.get(i).getTipo().equals(TIPOPieza[0])) {
				canon = true;
			}
			if(piezas.get(i).getTipo().equals(TIPOPieza[1])) {
				cargador = true;
			}
			if(piezas.get(i).getTipo().equals(TIPOPieza[2])) {
				chasis = true;
			}
			if(piezas.get(i).getTipo().equals(TIPOPieza[3])) {
				culata = true;
			}
			if(piezas.get(i).getTipo().equals(TIPOPieza[4])) {
				municion = true;
			}
		}
		if(canon && chasis && culata && cargador && municion) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 *@param piezas
	 *obtienes piezas el chasis de un array list
	 * */
	public Chasis getChasisArma(ArrayList<Piezas> piezas) {
		for(Piezas pieza : piezas) {
			if(pieza.getTipo().equals(TIPOPieza[2])) {
				return (Chasis)pieza;
			}
		}
		return null;
	}
	/**
	 *@param piezas
	 *obtienes cañon
	 * */
	public Canon getCanonArma(ArrayList<Piezas> piezas) {
		// TODO Auto-generated method stub
		for(Piezas pieza : piezas) {
			if(pieza.getTipo().equals(TIPOPieza[0])) {
				return (Canon)pieza;
			}
		}
		return null;
	}
	/**
	 *@param piezas
	 *cargador
	 * */
	public Cargador getCargadorArma(ArrayList<Piezas> piezas) {
		for(Piezas pieza : piezas) {
			if(pieza.getTipo().equals(TIPOPieza[1])) {
				return (Cargador)pieza;
			}
		}
		return null;
	}
	/**
	 *@param piezas
	 *obtienes piezas culata de un array list
	 * */
	public Culata getCulataArma(ArrayList<Piezas> piezas) {
		// TODO Auto-generated method stub
		for(Piezas pieza : piezas) {
			if(pieza.getTipo().equals(TIPOPieza[3])) {
				return (Culata)pieza;
			}
		}
		return null;
	}	
	/**
	 *@param piezas
	 *obtienes piezas municion de un array list
	 * */
	public Municion getMunicionArma(ArrayList<Piezas> piezas) {
		// TODO Auto-generated method stub
		for(Piezas pieza : piezas) {
			if(pieza.getTipo().equals(TIPOPieza[4])) {
				return (Municion)pieza;
			}
		}
		return null;
	}
	/**
	 *@param piezas
	 *borras todas las piezas
	 * */
	public void borrarTodasLasPiezas() {
		Iterator<Piezas> iterador = this.piezasUsuario.iterator();
		while(iterador.hasNext()) {
			iterador.next();
			iterador.remove();
		}
	}
	/**
	 *@param piezas
	 *borras todas las armas
	 * */
	public void borrarTodasLasArmas() {
		Iterator<Arma> iterador = this.armaUsuario.iterator();
		while(iterador.hasNext()) {
			iterador.next();
			iterador.remove();
		}
	}	
	@Override
	public String toString() {
		return "Crafter ["+super.toString()+"armaUsuario=" + armaUsuario + ", piezasUsuario=" + piezasUsuario + "]";
	}

}
