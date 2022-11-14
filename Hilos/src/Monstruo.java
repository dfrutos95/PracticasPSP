
public class Monstruo extends Thread{
	GalletasBean bean = null;
	int galletas;
	
	public Monstruo(GalletasBean bean, int galletas) {
		this.bean=bean;
		this.galletas=galletas;
	}
	public void comerGalletas() {
		int galletasDisponibles = bean.getGalletas(); //estas son las galletas que hay en el almacen
		if(this.galletas<bean.getGalletas()) {
			galletasDisponibles=galletasDisponibles-this.galletas;
			bean.setGalletas(galletasDisponibles); //si me como menos galletas de las que hay me las como
		}
		System.out.println("Quedan "+galletasDisponibles+" galletas disponibles");
	}
	public void run() {
		try {
			synchronized (bean) {
			System.out.println("Soy "+Thread.currentThread().getId()+"..Comprobado el aforo actual "+this.bean.getAforo());
			if (this.bean.getAforo()==this.bean.getAFOROMAXIMO())
				bean.wait();
			System.out.println("Soy "+Thread.currentThread().getId()+"..Soy concha,entro");
			
			this.bean.setAforo(this.bean.getAforo()+1);
			}
			//Thread.sleep((long) (Math.random()*8400));
			comerGalletas();
			System.out.println("Soy "+Thread.currentThread().getId()+"..Saliendo");
			synchronized (bean) {
			if (this.bean.getAforo()==this.bean.getAFOROMAXIMO())
				bean.notify();
			this.bean.setAforo(this.bean.getAforo()-1);	
			System.out.println("Soy "+Thread.currentThread().getId()+"..He salido del almacen");
			
			}
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
}
