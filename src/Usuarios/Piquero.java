package Usuarios;

import java.util.ArrayList;

import Dummy.*;
import Picadora.ListadoPicadora;
import Picadora.Picadora;

public class Piquero extends Usuario {
	
	private ArrayList<Picadora> picadorasPiquero = new ArrayList<Picadora>();
	private ArrayList<Dummy> dummiesGenerados = new ArrayList<Dummy>();
	
	/**
	 * constructor
	 * */
	public Piquero(String nombre, String contrasena, String tipo) {
		super(nombre, contrasena, tipo);
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Picadora> getPicadorasPiquero() {
		return picadorasPiquero;
	}

	public void setPicadorasPiquero(ArrayList<Picadora> picadorasPiquero) {
		this.picadorasPiquero = picadorasPiquero;
	}
	/**
	 * elimina picadora
	 * */
	public void eliminarPicadora(int id) {
		for(int i=0; i<this.picadorasPiquero.size(); i++) {
			if(this.picadorasPiquero.get(i).getPicadoraId()==id) {
				this.picadorasPiquero.remove(i);
			}
		}
	}
	/**
	 *crea un dummy 
	 * */
	private String[] NOMBREADUMMIES = {"Jack", "Jhon", "Sergio", "Josemi", "Manoli", "Jesse", "Olivia", "Mari", "Joseph", "Carmen", "CLAPTR4P", "C1P0R26", "AVA", "F18Model"};
	private String[] NOMBREBDUMMIES = {"El guapo", "El niño", "El titan", "El vigardo", "La ramera errante", "Psicópata suicida", "Baby booom", "Señor del Skag", "Da Waarudo man", "The highnoon", "Hidden sniper 300clAp", "Light model MK23-12"};
	public Dummy crearDummy(ListadoDummies dummies) {
		Dummy dummy = new Dummy(dummies.darId(), NOMBREADUMMIES[(int)(Math.random()*NOMBREADUMMIES.length-1)]+" alias '"+NOMBREBDUMMIES[(int)(Math.random()*NOMBREBDUMMIES.length-1)]+"'");
		dummy.setArmadura((long)(Long.MAX_VALUE*Math.random()));
		dummy.setEscudo((long)(Long.MAX_VALUE*Math.random()));
		dummy.setVida((long)(Long.MAX_VALUE*Math.random()));
		this.dummiesGenerados.add(dummy);
		dummies.anadirDummies(dummy);
		return dummy;
	}
	/**
	 * lista dumies
	 * */
	public void listarDummies() {
		for(Dummy tonto : this.dummiesGenerados) {
			System.out.println(tonto);
		}
	}
	/**
	 * crea picadora*/
	public Picadora crearPicadora(ListadoPicadora picadoras) {
		Picadora picadora = new Picadora(picadoras.darIdPicadora());
		int bonificacion = (int)((Math.random()*8)+1);
		picadora.setBonificacion(bonificacion);
		this.picadorasPiquero.add(picadora);
		picadoras.anadirPicadora(picadora);
		return picadora;
	}
	/**
	 * lista picadora*/
	public void listarPicadorasPiquero() {
		for(Picadora po : this.picadorasPiquero) {
			System.out.println(po);
		}
	}
	@Override
	public String toString() {
		return "Piquero"+ super.toString() +" [picadorasPiquero=" + picadorasPiquero + "]";
	}
	
	/*Aquí irán las consultas de los piqueros para poder obtener los logs, o los permisos para consultar las picadoras*/
}
