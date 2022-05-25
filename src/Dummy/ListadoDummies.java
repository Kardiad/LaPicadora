package Dummy;

import java.util.ArrayList;
import java.util.Iterator;

public class ListadoDummies {
	private ArrayList<Dummy> dummies;
	
	public ListadoDummies() {
		this.dummies=new ArrayList<Dummy>();
	}
	public int darId() {
		return dummies.size();
	}
	public void anadirDummies(Dummy dummy) {
		this.dummies.add(dummy);
	}
	public void borrarDummy() {
		Iterator<Dummy> iteracion = this.dummies.iterator();
		while(iteracion.hasNext()) {
			Dummy tonto = iteracion.next();
			if(tonto.isEstaMuerto()) {
				iteracion.remove();
			}
		}
	}
	public Dummy obtenerDummyId(int id) {
		for (Dummy dum : dummies) {
			if(dum.getId()==id) {
				return dum;
			}
		}
		return null;
	}
	public void listar() {
		for(Dummy dum : dummies) {
			System.out.println(dum);
		}
	}
}
