package Picadora;

import java.util.ArrayList;

public class ListadoPicadora {
	private ArrayList<Picadora> picadoras;
	
	public ListadoPicadora() {
		 this.picadoras= new ArrayList<Picadora>();
	}
	
	public ArrayList<Picadora> getPicadoras() {
		return picadoras;
	}
	
	public void setPicadoras(ArrayList<Picadora> picadoras) {
		this.picadoras = picadoras;
	}
	
	public int darIdPicadora() {
		return picadoras.size();
	}
	
	public void anadirPicadora(Picadora picadora) {
		picadoras.add(picadora);
	}
	
	public void listar() {
		for(Picadora picadora : this.picadoras) {
			System.out.println("Id picadora: "+picadora.getPicadoraId()+" Bonificación para armas "+picadora.getBonificacion());
		}
	}
	
	public Picadora seleccionarPorId(int id) {
		for(Picadora picadora : this.picadoras) {
			if(picadora.getPicadoraId()==id) {
				return picadora;
			}
		}
		return null;
	}
	
	public Picadora obtenerPicadora(int id) {
		for(int i=0; i<picadoras.size(); i++) {
			if(picadoras.get(i).getPicadoraId()==id) {
				return picadoras.get(i);
			}
		}
		return null;
	}
	

}
