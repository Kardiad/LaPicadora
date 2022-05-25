package Piezas;
import java.time.LocalDate;
public class Canon extends Piezas {
	
	private int precision; 
	private int dano;
	private int dispersion;
	/**
	 * @param idPieza
	 * @param tipo
	 * @param dano
	 * @param dispersion
	 */
	
	public Canon(int idPieza, String marca, String modelo, LocalDate fechaObtencion, String tipo, String tipoArma, int dano, int dispersion, int precision) {
		super(idPieza, marca, modelo, fechaObtencion, tipo, tipoArma);
		this.dano=dano;
		this.dispersion=dispersion;
		this.precision=precision;
		// TODO Auto-generated constructor stub
	}
	public Canon() {
		 super();
	}
	
	public int getPrecision() {
		return precision;
	}
	public void setPrecision(int precision) {
		this.precision = precision;
	}
	public int getDano() {
		return dano;
	}
	public void setDano(int dano) {
		this.dano = dano;
	}
	public int getDispersion() {
		return dispersion;
	}
	public void setDispersion(int dispersion) {
		this.dispersion = dispersion;
	}
	@Override
	public String toString() {
		return "Canon = ["+super.toString()+" precision=" + precision + ", dano=" + dano + ", dispersion=" + dispersion + "]";
	}
	
	
	
}
