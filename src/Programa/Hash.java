package Programa;

public class Hash {
	private static final String[] tablaEncriptacion = { "as", "abe", "w", "es", "@12", "!#2", "865", "@#as", "ASD", "€sa", "m99(",
			"zx=", "*/as", "c_A", "^*a", "3/q", "as3", "_:;", "!$/", "u6/", "8/*w", "o39", "a6¿", "2¨·", ".P0", "wpo"};
/**
 * encriptado*/
	public static String setPasswordEncriptado(String passwordAEncriptar) {
		passwordAEncriptar.toLowerCase();
		String passwordEncriptado = "";
		try {	
			for(int i=0; i<passwordAEncriptar.length(); i++) {
				if(passwordAEncriptar.charAt(i)!='ñ') {
					passwordEncriptado += tablaEncriptacion[(int)passwordAEncriptar.charAt(i)-97];								
				}
			}
			return passwordEncriptado;
		}catch(Exception e) {
			return "";			
		}
	}
}
