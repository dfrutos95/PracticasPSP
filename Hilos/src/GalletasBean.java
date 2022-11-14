
public class GalletasBean {
	/**Creamos dos variables, CANTIDADINICIAL que definira el maximo de galletas en el almacen
	 * Y galletas que indicará cuantas hay
	*/
	final int CANTIDADINICIAL=10;
	final int AFOROMAXIMO=1;
	int aforoActual=0;
	boolean seguimos;
	public int getAforo() {
		return aforoActual;
	}

	public void setAforo(int aforoActual) {
		this.aforoActual = aforoActual;
	}


	public int getAFOROMAXIMO() {
		return AFOROMAXIMO;
	}


	int galletas=0;
	
	public GalletasBean(int galletas) {
		super();
		this.galletas=galletas;
		this.seguimos=true;
	}
	
	public void setGalletas(int galletas) {
		this.galletas=galletas;
	}

	public int getGalletas() {
		return galletas;
	}

	public int getCANTIDADINICIAL() {
		return CANTIDADINICIAL;
	}
	
	
}