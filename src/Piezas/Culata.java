package Piezas;

import java.time.LocalDate;

public class Culata extends Piezas {

	private int probabilidadCritica;
	private int estabilidad;
	private int danio;
	/**
	 * @param idPieza
	 * @param fechaObtencion
	 * @param tipo
	 */
	public Culata(int idPieza, String marca, String modelo, LocalDate fechaObtencion, String tipo, String tipoArma, int estabilidad, int danio, int probabilidadCritica) {
		super(idPieza,marca, modelo, fechaObtencion, tipo, tipoArma);
		// TODO Auto-generated constructor stub
		this.estabilidad=estabilidad;
		this.danio=danio;
		this.probabilidadCritica=probabilidadCritica;
	}
	
	public int getProbabilidadCritica() {
		return probabilidadCritica;
	}

	public void setProbabilidadCritica(int probabilidadCritica) {
		this.probabilidadCritica = probabilidadCritica;
	}

	public int getEstabilidad() {
		return estabilidad;
	}

	public void setEstabilidad(int estabilidad) {
		this.estabilidad = estabilidad;
	}
	
	public int getDanio() {
		return danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}
	@Override
	public String toString() {
		return  "Culata = ["+super.toString()+" danio=" + danio + ", estabilidad=" + estabilidad + ", probabilidadCritica=" + probabilidadCritica +"]";
	}	
}
