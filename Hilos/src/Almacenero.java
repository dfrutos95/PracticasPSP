
public class Almacenero extends Thread{
	GalletasBean bean = null;
	int contador=0;
	boolean seguimos=true;
	
	public Almacenero(GalletasBean bean) {
		this.bean=bean;
	}
	public void reponer() {
		if(bean.getGalletas()==0) {
			bean.setGalletas(10);
			contador++;
			bean.notifyAll();
		}
	}
	public void run() {
		if(contador<10) {
			try {
				synchronized (bean) {
				System.out.println("Soy "+Thread.currentThread().getId()+"..Comprobado el aforo actual "+this.bean.getAforo());
				if (this.bean.getAforo()==this.bean.getAFOROMAXIMO())
					bean.wait();
				System.out.println("Soy "+Thread.currentThread().getId()+"..entro");
				
				this.bean.setAforo(this.bean.getAforo()+1);
				reponer();
				}
				Thread.sleep((long) (Math.random()*8400));
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
		else seguimos=false;
}
}