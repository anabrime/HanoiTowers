package Estados;

import ObjetosDelEntorno.Tower;
import es.deusto.ingenieria.is.search.formulation.State;

public class Environment extends State implements Cloneable {

	private int torres;
	private int discos;
	private Tower[] arrayTorres;
	private int torreInicial;
	private int torreFinal;

	public int getTorreInicial() {
		return torreInicial;
	}

	public void setTorreInicial(int torreInicial) {
		this.torreInicial = torreInicial;
	}

	public int getTorreFinal() {
		return torreFinal;
	}

	public void setTorreFinal(int torreFinal) {
		this.torreFinal = torreFinal;
	}

	public Environment(int torres, int discos, int torreInicial, int torreFinal) {
		this.torres = torres;
		this.discos = discos;
		this.torreFinal = torreFinal;
		this.torreInicial = torreInicial;
		this.arrayTorres = new Tower[torres];
		for (int i = 0; i < torres; i++) {
			this.arrayTorres[i] = new Tower();
		}
		this.arrayTorres[torreInicial].estadoInicial_(discos);
	}

	@Override
	public Object clone() {
		Environment clon = null;

		try {
			clon = (Environment) super.clone();
			clon.torres = this.torres;
			clon.discos = this.discos;
			clon.torreInicial = this.torreInicial;
			clon.torreFinal = this.torreFinal;
			clon.arrayTorres = new Tower[this.torres];
			for (int i = 0; i < this.torres; i++) {
				clon.arrayTorres[i] = (Tower) this.arrayTorres[i].clone();
			}
		} catch (CloneNotSupportedException e) {
			System.err.println("% [ERROR] Environment.clone(): " + e.getMessage());
		}

		return clon;
	}

	public int getTorres() {
		return torres;
	}

	public void setTorres(int torres) {
		this.torres = torres;
	}

	public int getDiscos() {
		return discos;
	}

	public void setDiscos(int discos) {
		this.discos = discos;
	}

	public Tower[] getArrayTorres() {
		return arrayTorres;
	}

	public Tower getArrayTorresConIndice(int id) {
		return arrayTorres[id];
	}

	public void setArrayTorres(Tower[] arrayTorres) {
		this.arrayTorres = arrayTorres;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Environment && ((Environment) obj).torres == (this.torres)
				&& ((Environment) obj).discos == (this.discos)) {
			for (int i = 0; i < this.torres; i++) {
				if (!arrayTorres[i].equals(((Environment) obj).getArrayTorresConIndice(i)))
					return false;
			}
		} else {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < torres; i++) {
			str += "T[" + i + "]";
			str += arrayTorres[i].toString();
		}
		return str;
	}

	public static void main(String[] args) {
		Environment entorno = new Environment(3, 4, 0, 2);
		Environment entorno1 = new Environment(3, 4, 0, 2);
		System.out.println(entorno.equals(entorno1));
		 Environment clon;
		 clon = (Environment) entorno.clone();
		 System.out.println(clon.discos); System.out.println("Discos iguales");
		 System.out.println(clon.torres); System.out.println("Torres iguales");
		 System.out.println(clon.torreInicial); System.out.println("TorreInicial igual");
		 System.out.println(clon.torreFinal); System.out.println("Torre Final igual");
		 System.out.println(clon.equals(entorno));
		 for(int i=0;i<entorno.torres;i++){
		 if(clon.arrayTorres[i].equals(entorno.arrayTorres[i])){
		 System.out.println("Torre detectada");
		 System.out.println("Torre " +i +" clonada corectamente");
		 }
		 else{
		 System.out.println("No hay torres detectadas");
		 }
		 }
		 if (entorno.equals(clon)) {
		 System.out.println("El clon del entorno son iguales");
		 } else {
		 System.out.println("El clon del entorno no son iguales");
		 }
		
		 clon.setDiscos(1);
		 if (entorno.equals(clon)) {
		 System.out.println("El clon del entorno son iguales");
		 } else {
		 System.out.println("El clon del entorno no son iguales");
		 }
	}
}