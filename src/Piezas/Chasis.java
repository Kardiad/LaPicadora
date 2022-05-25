package Piezas;

import java.time.LocalDate;

public class Chasis extends Piezas {

	private int danio;
	private int estabilidad;
	private int cadencia;
	private int dispersion;
	private int probabilidadCritica;
	private int danioCritico;
	/**
	 * @param idPieza
	 * @param fechaObtencion
	 * @param tipo
	 */
	
	public int getDanio() {
		return danio;
	}
	public Chasis(int idPieza, String marca, String modelo, LocalDate fechaObtencion, String tipo, String tipoArma, int danio, int estabilidad, int cadencia,
			int dispersion, int probabilidadCritica, int danioCritico) {
		super(idPieza, marca, modelo, fechaObtencion, tipo, tipoArma);
		this.danio = danio;
		this.estabilidad = estabilidad;
		this.cadencia = cadencia;
		this.dispersion = dispersion;
		this.probabilidadCritica = probabilidadCritica;
		this.danioCritico = danioCritico;
	}
	public void setDanio(int danio) {
		this.danio = danio;
	}
	public int getEstabilidad() {
		return estabilidad;
	}
	public void setEstabilidad(int estabilidad) {
		this.estabilidad = estabilidad;
	}
	public int getCadencia() {
		return cadencia;
	}
	public void setCadencia(int cadencia) {
		this.cadencia = cadencia;
	}
	public int getDispersion() {
		return dispersion;
	}
	public void setDispersion(int dispersion) {
		this.dispersion = dispersion;
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
	@Override
	public String toString() {
		return  "Chasis = ["+super.toString()+" danio=" + danio + ", estabilidad=" + estabilidad + ", cadencia=" + cadencia + ", dispersion="
				+ dispersion + "]";
	}
	
	
	
}
