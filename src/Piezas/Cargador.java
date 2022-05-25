package Piezas;

import java.time.LocalDate;

public class Cargador extends Piezas {

	private int dano;
	private int cargador;
	private int estabilidad;
	
	public Cargador(int idPieza, String marca, String modelo, LocalDate fechaObtencion, String tipo, String tipoArma, int cargador, int estabilidad, int dano) {
		super(idPieza, marca, modelo, fechaObtencion, tipo, tipoArma);
		this.cargador=cargador;
		this.estabilidad=estabilidad;
		this.dano=dano;
		// TODO Auto-generated constructor stub
	}
	
	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public int getCargador() {
		return cargador;
	}

	public void setCargador(int cargador) {
		this.cargador = cargador;
	}

	public int getEstabilidad() {
		return estabilidad;
	}

	public void setEstabilidad(int estabilidad) {
		this.estabilidad = estabilidad;
	}

	@Override
	public String toString() {
		return "Cargador = ["+super.toString()+" estabilidad=" + estabilidad + ", dano=" + dano + ", cargador=" + cargador + "]";
	}
}
