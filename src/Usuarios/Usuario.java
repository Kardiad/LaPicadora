package Usuarios;

import java.util.ArrayList;

public class Usuario {
	private int idUsuario;
	private String nombre;
	private String contrasena;
	private String tipo;
	private int reportes;
	/**
	 * @param idUsuario
	 * @param nombre
	 * @param contrasena
	 */
	public Usuario(String nombre, String contrasena, String tipo) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.tipo = tipo;
		this.reportes=0;
	}
	
	public int getReportes() {
		return reportes;
	}

	public void setReportes(int reportes) {
		this.reportes = reportes;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * añade un report a usuario*/
	public void anadirReprote(ArrayList<Usuario> usuarios, int id) {
		for(int i=0; i<usuarios.size(); i++) {
			if(usuarios.get(i).getIdUsuario()==id) {
				int cantidad = usuarios.get(i).getReportes();
				usuarios.get(i).setReportes(cantidad++);
			}
		}
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", contrasena=" + contrasena + ", tipo="
				+ tipo + " ha sido reportado "+reportes+" veces]";
	}	
}
