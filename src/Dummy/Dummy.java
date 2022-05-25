package Dummy;

public class Dummy {
	private int id;
	private String nombre;
	private long vida;
	private long armadura;
	private long escudo;
	private boolean estaMuerto;
	/**
	 * @param id
	 * @param nombre
	 */
	public Dummy(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estaMuerto=false;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getVida() {
		return vida;
	}
	public void setVida(long vida) {
		this.vida = vida;
	}
	public long getArmadura() {
		return armadura;
	}
	public void setArmadura(long armadura) {
		this.armadura = armadura;
	}
	public long getEscudo() {
		return escudo;
	}
	public void setEscudo(long escudo) {
		this.escudo = escudo;
	}
	public boolean isEstaMuerto() {
		return estaMuerto;
	}
	public void setEstaMuerto(boolean estaMuerto) {
		this.estaMuerto = estaMuerto;
	}
	public void danoRecibido(int dano) {
		System.out.println("Daño que entra para recibir "+dano);
		if(this.escudo>0) {
			System.out.println("Escudo "+this.getEscudo());
			long danoEscudo=this.getEscudo()-dano;
			System.out.println("escudo tras daño "+danoEscudo);
			this.setEscudo(danoEscudo);
			if(this.armadura>0 && this.escudo==0) {
				System.out.println("Armadura: "+this.getArmadura());
				System.out.println("Vida: "+this.getVida());
				long danoArmadura=(long) (this.getArmadura()-dano*0.75);
				long danoVida=(long) (this.getVida()-dano*0.25);
				System.out.println("Armadura tras impacto "+danoArmadura);
				System.out.println("Vida tras impacto "+danoVida);
				this.setArmadura(danoArmadura);
				this.setVida(danoVida);
			}else if(this.armadura==0) {
				System.out.println("Vida: "+this.getVida());
				long danoVida=this.getVida()-dano;
				System.out.println("Vida tras impacto "+danoVida);
				this.setVida(danoVida);
			}else if(this.vida==0) {
				this.setEstaMuerto(true);
			}
		}
	}
	@Override
	public String toString() {
		return "Dummy [id=" + id + ", nombre=" + nombre + ", vida=" + vida + ", armadura=" + armadura + ", escudo="
				+ escudo + "está muerto "+ estaMuerto +" ]";
	}
	
}
