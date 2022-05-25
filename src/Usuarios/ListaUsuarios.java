package Usuarios;

import java.util.ArrayList;

public class ListaUsuarios {

	private ArrayList<Usuario> listado;
	/**
	 * consturctor
	 * */
	public ListaUsuarios() {
		 this.listado= new ArrayList<Usuario>();
	}
	/**
	 * @param Usuario
	 * añade usuario a la lista comprobando si existe
	 * */
	public void setListado(Usuario usuario) {
		boolean esta = false;
		if(this.listado.size()==0) {
			this.listado.add(usuario);
		}else {
			for (Usuario u : this.listado) {
				if(u.getNombre().equals(usuario.getNombre())) {
					esta = true;
				}
			}
			if(!esta) {
				System.out.println("El usuario no existe y se ha creado");
				this.listado.add(usuario);
			}else {
				System.out.println("No puedes meter un usuario que ya existe");
			}
		}
	}
	/**
	 * Retorna total usuarios
	 * */
	public int usuariosTotales() {
		return listado.size();
	}
	/**
	 * Da arraylist usuarios
	 * */
	public ArrayList<Usuario> obtenerLista(){
		return this.listado;
	}
	/**
	 * @param nombre
	 * @param contrasena
	 * valida si el usuario existe
	 * */
	public boolean validarUusario(String nombre, String contrasena) {
		for(int i=0; i<listado.size(); i++) {
			if(listado.get(i).getNombre().equals(nombre) && 
					listado.get(i).getContrasena().equals(contrasena)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * @param nombre
	 * @param contrasena
	 * me devuelve el usuario
	 * */
	public Usuario obtenerUsuario (String nombre, String contrasena) {
		for(int i=0; i<listado.size(); i++) {
			if(listado.get(i).getNombre().equals(nombre) && 
					listado.get(i).getContrasena().equals(contrasena)) {
				return listado.get(i);
			}
		}
		return null;
	}
	/**
	 * @param nombre´
	 * @param contrasena
	 * me devuelve un usuario crafter
	 * */
	public Crafter obtenerCrafter(String nombre, String contrasena) {
		for(int i=0; i<listado.size(); i++) {
			if(listado.get(i).getNombre().equals(nombre) && 
					listado.get(i).getContrasena().equals(contrasena)) {
				return (Crafter) listado.get(i);
			}
		}
		return null;
	}
	/**
	 * @param nombre´
	 * @param contrasena
	 * me devuelve un usuario admin
	 * */
	public Admin obtenerAdmin(String nombre, String contrasena) {
		for(int i=0; i<listado.size(); i++) {
			if(listado.get(i).getNombre().equals(nombre) && 
					listado.get(i).getContrasena().equals(contrasena)) {
				return (Admin) listado.get(i);
			}
		}
		return null;
	}
	/**
	 * @param nombre´
	 * @param contrasena
	 * me devuelve un usuario piquero
	 * */
	public Piquero obtenerPiquero(String nombre, String contrasena) {
		for(int i=0; i<listado.size(); i++) {
			if(listado.get(i).getNombre().equals(nombre) && 
					listado.get(i).getContrasena().equals(contrasena)) {
				return (Piquero) listado.get(i);
			}
		}
		return null;
	}
	/**
	 * @param nombre´
	 * @param contrasena
	 * me devuelve un usuario
	 * */
	public Usuario obtenerUsuario(String nombre) {
		for(Usuario usu : listado) {
			if(usu.getNombre().equals(nombre)) {
				return usu;
			}
		}
		return null;
	}
}
