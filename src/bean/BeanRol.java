package bean;

public class BeanRol {

	private int codiRol, codiTipoLocal;
	private String nomUsuari;
	
	public BeanRol(){
		codiRol = 0;
		codiTipoLocal = 0;
		nomUsuari = new String();
	}

	public int getCodiRol() {
		return codiRol;
	}

	public void setCodiRol(int codiRol) {
		this.codiRol = codiRol;
	}

	public int getCodiTipoLocal() {
		return codiTipoLocal;
	}

	public void setCodiTipoLocal(int codiTipoLocal) {
		this.codiTipoLocal = codiTipoLocal;
	}

	public String getNomUsuari() {
		return nomUsuari;
	}

	public void setNomUsuari(String nomUsuari) {
		this.nomUsuari = nomUsuari;
	}
}
