package Usuarios;

import java.util.ArrayList;

public class Admin extends Usuario {

	public Admin(String nombre, String contrasena, String tipo) {
		super(nombre, contrasena, tipo);
		// TODO Auto-generated constructor stub
	}
	/**
	 * lista usuarios
	 * */
	public void listarUsuarios(ArrayList<Usuario> listado) {
		for (int i = 0; i < listado.size(); i++) {
			System.out.println(listado.get(i));
		}
	}
	/**
	 * elimina usuario por id*/
	public void eliminarUusario(ArrayList<Usuario> listado, int id) {
		boolean noHayUsuario = true;
		for (int i = 0; i < listado.size(); i++) {
			if (listado.get(i).getIdUsuario() == id) {
				System.out.println("Usuario " + listado.get(i));
				listado.remove(i);
				noHayUsuario = false;
			}
		}
		if (!noHayUsuario) {
			System.out.print("El usuario ha sido eliminado \n");
		} else {
			System.out.println("El usuario no existe");
		}
	}
	/**
	 * busca usuario
	 * */
	public Usuario buscarUsuario(ArrayList<Usuario> listado, int id) {
		for (Usuario usuario : listado) {
			if (usuario.getIdUsuario() == id) {
				return usuario;
			}
		}
		return null;
	}
	/**
	 * lista reportados
	 * */
	public void listarUsuariosReportados(ArrayList<Usuario> usuarios) {
		for(Usuario usuario : usuarios) {
			if(usuario.getReportes()>0) {
				System.out.println(usuario);
			}
		}
	}
	@Override
	public String toString() {
		return "Admin [idUsuario=" + getIdUsuario() + ", nombre=" + getNombre() + ", contrasena()="
				+ getContrasena() + ", tipo()=" + getTipo() + ", toString()=" + super.toString() + "]";
	}

}
