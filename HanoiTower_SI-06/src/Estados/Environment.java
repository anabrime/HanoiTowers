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

	public Object clone() {
		Environment clon = null;

		try {
			clon = (Environment) super.clone();
			clon.torres = this.torres;
			clon.discos = this.discos;
			clon.torreInicial = this.torreInicial;
			clon.torreFinal = this.torreFinal;
			clon.arrayTorres = (Tower[]) this.arrayTorres.clone();
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

	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Environment && ((Environment) obj).torres == (this.torres)
				&& ((Environment) obj).discos == (this.discos)) {
			for (int i = 0; i < this.torres; i++) {
				if (arrayTorres[i].equals(((Environment) obj).getArrayTorresConIndice(i))) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String str = "Environment: ";
		for (int i = 0; i < torres; i++) {
			str += "Torre[" + i + "]";
			str += arrayTorres[i].toString();
		}
		return str;
	}
}