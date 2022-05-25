package Piezas;

import java.time.LocalDate;

public class Municion extends Piezas {
	private int danio;
	private int calibre;
	private int probabilidadCritica;
	private int danioCritico;
	/**
	 * @param idPieza
	 * @param string 
	 * @param marca 
	 * @param fechaObtencion
	 * @param tipo
	 * @param danio
	 * @param calibre
	 * @param tipo2
	 */
	public Municion(int idPieza, String marca, String modelo, LocalDate fechaObtencion, String tipo, String tipoArma, int danio, int calibre, int probabilidadCritica, int danioCritico) {
		super(idPieza, marca, modelo, fechaObtencion, tipo, tipoArma);
		this.calibre = calibre;
		this.danio = this.danioTotal(danio, calibre);
		this.probabilidadCritica=probabilidadCritica;
		this.danioCritico=danioCritico;
	}


	public int getProbabilidadCritica() {
		return probabilidadCritica;
	}

	public void setProbabilidadCritica(int probabilidadCritica) {
		this.probabilidadCritica = probabilidadCritica;
	}



	public int getDanioCritico() {
		return danioCritico;
	}



	public void setDanioCritico(int danioCritico) {
		this.danioCritico = danioCritico;
	}



	public int getDanio() {
		return danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}

	public int getCalibre() {
		return calibre;
	}

	public void setCalibre(int calibre) {
		this.calibre = calibre;
	}
	private int danioTotal(int danio, int calibre) {
		return danio*calibre;
	}
	/*
	 * private int probabilidadCritica;
	private int danioCritico;
	 * */
	@Override
	public String toString() {
		return "Municion [ "+super.toString()+" danio=" + danio + ", calibre=" + calibre + " municion= "+probabilidadCritica+" danioCritico="+danioCritico+"]";
	}
	
	
}
