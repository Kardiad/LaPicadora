package Armas;

import Piezas.*;

public class Arma {
	private int idArma;
	private Chasis chasis;
	private Canon canon;
	private Culata culata;
	private Cargador cargadorO;
	private Municion municion;
	private int dano;
	private int precision;
	private int probabilidadCritica;
	private int danoCritico;
	private int cadencia;
	private int cargador;
	private String rareza;
	private String marca;
	private String modelo;
	private String tipoArma;
	/**
	 * @param chasis
	 * @param canon
	 * @param culata
	 * @param municion
	 */
	public Arma(int idArma, Chasis chasis, Canon canon, Culata culata, Cargador cargador, Municion municion) {
		super();
		this.idArma = idArma;
		this.chasis = chasis;
		this.canon = canon;
		this.culata = culata;
		this.municion = municion;
		this.cargadorO = cargador;
	}
	
	/**
	 * @param dano
	 * @param precision
	 * @param probabilidadCritica
	 * @param danoCritico
	 * @param cadencia
	 * @param cargador
	 * @param rareza
	 * @param marca
	 * @param modelo
	 * @param tipoArma
	 */
	public Arma(int idArma, int dano, int precision, int probabilidadCritica, int danoCritico, int cadencia, int cargador,
			String rareza, String marca, String modelo, String tipoArma) {
		super();
		this.idArma=idArma;
		this.dano = dano;
		this.precision = precision;
		this.probabilidadCritica = probabilidadCritica;
		this.danoCritico = danoCritico;
		this.cadencia = cadencia;
		this.cargador = cargador;
		this.rareza = rareza;
		this.marca = marca;
		this.modelo = modelo;
		this.tipoArma = tipoArma;
	}
	
	
	public int getIdArma() {
		return idArma;
	}

	public void setIdArma(int idArma) {
		this.idArma = idArma;
	}

	public Chasis getChasis() {
		return chasis;
	}

	public void setChasis(Chasis chasis) {
		this.chasis = chasis;
	}

	public Canon getCanon() {
		return canon;
	}

	public void setCanon(Canon canon) {
		this.canon = canon;
	}

	public Culata getCulata() {
		return culata;
	}

	public void setCulata(Culata culata) {
		this.culata = culata;
	}

	public Municion getMunicion() {
		return municion;
	}

	public void setMunicion(Municion municion) {
		this.municion = municion;
	}

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public int getProbabilidadCritica() {
		return probabilidadCritica;
	}

	public void setProbabilidadCritica(int probabilidadCritica) {
		this.probabilidadCritica = probabilidadCritica;
	}

	public int getDanoCritico() {
		return danoCritico;
	}

	public void setDanoCritico(int danoCritico) {
		this.danoCritico = danoCritico;
	}

	public int getCadencia() {
		return cadencia;
	}

	public void setCadencia(int cadencia) {
		this.cadencia = cadencia;
	}

	public int getCargador() {
		return cargador;
	}

	public void setCargador(int cargador) {
		this.cargador = cargador;
	}

	public String getRareza() {
		return rareza;
	}

	public void setRareza(String rareza) {
		this.rareza = rareza;
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

	public String getTipoArma() {
		return tipoArma;
	}

	public void setTipoArma(String tipoArma) {
		this.tipoArma = tipoArma;
	}
	
	public Cargador getCargadorO() {
		return cargadorO;
	}

	public void setCargadorO(Cargador cargadorO) {
		this.cargadorO = cargadorO;
	}
	
	public int dispararArma() {
		/*
		 * Devolver� un int, pero antes har� ver si ha fallado o no, esto lo mediremos en una proporci�n estabilidad da�o
		 * Probabilidad de acertar: precision / tantos 0 como length sea la precision si es 2003 pues 10000 * aleatorio entre 0 y 1
		 * 		Se necesitar� entonces de 1 creador de n�meros de 10 elevado a algo. 
		 * Probabilidad cr�tica: probabilidad crit / tantos 0 como length sea la probabilidad crit.
		 * Cadencia mandar� un aviso de cuanto tiempo ha costado en vaciar un cargador. El c�lculo: 
		 * 		Si la cadencia es superior al cargador lo vaciar� en 5 seg, en caso contrario se har�n cuentas de cuanto tardar�a
		 * 		mandando un mensaje de que tiene tanta cadencia que no permite cargar a veces la siguiente bala.
		 * Da�o: Se calcular� en base a la cantidad de balas que dispara, la cantidad de da�o que tiene cada bala y la probabilidad de cada bala de dar
		 * critico y si es cr�tico que le haga un multiplicador escalado. Esto quiere decir que se har� algo similar a warframe, donde si supera tanto de
		 * da�o critico, entonces lo que har� sera que se cambia la escala del multiplicador. Por ejemplo si llega a 100 ser� un x2 si llega a 1000 ser� un 
		 * x3 y as� sucesivamente.
		 * 
		 * Tengo dudas si esta funci�n va a devolver un da�o realizado por cada bala del cargador o va a hacer una suma total. 
		 * */
		double daElTiro = (this.precision/Math.pow(10, Integer.toString(this.precision).length()))*Math.random();
		if (daElTiro > 0.025) {
			double daCritico = (this.probabilidadCritica/Math.pow(10, Integer.toString(this.probabilidadCritica).length()))*Math.random();
			if(daCritico>0.15) {
				int tipoCritico = Integer.toString(this.danoCritico).length();
				double multiplicador;
				switch (tipoCritico) {
					case 1:
						multiplicador = 2.5;
						return (int)(this.dano*multiplicador);
					case 2:
						multiplicador = 3.5;
						return (int)(this.dano*multiplicador);
					case 3:
						multiplicador = 4.5;
						return (int)(this.dano*multiplicador);
					case 4:
						multiplicador = 5.5;
						return (int)(this.dano*multiplicador);
					default:
						multiplicador = 6.6;
						return (int)(this.dano*multiplicador);
				}
			}else {
				return dano;
			}
		}else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return "Arma idArma= "+idArma+" Stats: [dano=" + dano + ", precision=" + precision + ", probabilidadCritica="
				+ probabilidadCritica + ", danoCritico=" + danoCritico + ", cadencia=" + cadencia + ", cargador="
				+ cargador + ", rareza=" + rareza + ", marca=" + marca + ", modelo=" + modelo + ", tipoArma=" + tipoArma + "]";
	}
	
	
}
