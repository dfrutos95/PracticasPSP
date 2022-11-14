
public class Principal {

	public static void main(String[] args) {
		GalletasBean bean = new GalletasBean(10);

		Monstruo[] thv= new Monstruo[3];
		for (int i=0;i<thv.length;i++) {
			int galletas = (int) (Math.random()*10);
			thv[i]=new Monstruo(bean, galletas);
		}
		for (int i=0;i<thv.length;i++) {
			thv[i].start();
		}

	}
}
