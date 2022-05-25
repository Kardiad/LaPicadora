package Piezas;

import java.time.LocalDate;

public class Piezas {

	private int idPieza;
	private String marca;
	private String modelo;
	private LocalDate fechaObtencion;
	private String tipo;
	private String tipoArma;
	/**
	 * @param idPieza
	 * @param marca
	 * @param modelo
	 * @param fechaObtencion
	 */
	public Piezas(int idPieza, String marca, String modelo, LocalDate fechaObtencion, String tipo, String tipoArma) {
		super();
		this.idPieza = idPieza;
		this.marca = marca;
		this.modelo = modelo;
		this.fechaObtencion = fechaObtencion;
		this.tipo=tipo;
		this.tipoArma=tipoArma;
	}
	public Piezas() {
		// TODO Auto-generated constructor stub
	}
	public int getIdPieza() {
		return idPieza;
	}
		
	public void setIdPieza(int idPieza) {
		this.idPieza = idPieza;
	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public LocalDate getFechaObtencion() {
		return fechaObtencion;
	}
	public void setFechaObtencion(LocalDate fechaObtencion) {
		this.fechaObtencion = fechaObtencion;
	}
	public String getTipoArma() {
		return tipoArma;
	}
	public void setTipoArma(String tipoArma) {
		this.tipoArma = tipoArma;
	}
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Piezas [idPieza=" + idPieza + ", marca=" + marca + ", modelo=" + modelo + ", fechaObtencion="
				+ fechaObtencion + ", tipo=" + tipo + "tipoArma= " +tipoArma+" ";
	}

}
