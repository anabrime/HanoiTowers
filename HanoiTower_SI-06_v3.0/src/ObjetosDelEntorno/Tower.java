package ObjetosDelEntorno;

import java.util.ArrayList;

//En la clase torre equals de arrays de discos y en environmment equals de torre con torre
public class Tower implements Cloneable {

	// private int id;

	private ArrayList<Disc> discosEnTorre;

	public ArrayList<Disc> getDiscosEnTorre() {
		return discosEnTorre;
	}

	public Disc getDiscosEnTorreConIndice(int id) {
		return discosEnTorre.get(id);
	}

	public void setDiscosEnTorre(ArrayList<Disc> discosEnTorre) {
		this.discosEnTorre = discosEnTorre;
	}

	public Tower() {
		setDiscosEnTorre(new ArrayList<Disc>());
	}

	// Coloca discos en la primera torre donde
	// el numero de discos a colocar es "id"
	public void estadoInicial_(int id) {
		for (int i = 1; i <= id; i++) {
			Disc disc = new Disc(i);
			this.discosEnTorre.add(disc);
		}

	}

	@Override
	public String toString() {
		String str = " ";
		for (int i = 0; i < this.getDiscosEnTorre().size(); i++) {
			str += this.getDiscosEnTorre().get(i).toString();
		}
		return str;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object clone() {
		Tower clon = new Tower();

		try {
			clon = (Tower) super.clone();
			clon.discosEnTorre = (ArrayList<Disc>) this.discosEnTorre.clone();
		} catch (CloneNotSupportedException e) {
			System.err.println("% [ERROR] Tower.clone(): " + e.getMessage());
		}
		// for (int i = 0; i < this.discosEnTorre.size(); i++) {
		// clon.discosEnTorre.add((Disc)
		// this.getDiscosEnTorreConIndice(i).clone());
		// }

		return clon;
	}

	public boolean equals(Tower t) {

		if (this.getDiscosEnTorre().size() == t.getDiscosEnTorre().size()) {

			for (int i = 0; i < this.getDiscosEnTorre().size(); i++) {

				if (!(this.getDiscosEnTorreConIndice(i).equals(t.getDiscosEnTorreConIndice(i)))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	// if(d.equals(t.getDiscosEnTorre()))
	// if (this.getDiscosEnTorre().equals(t.getDiscosEnTorre())) {
	// equal = true;
	// } else
	// equal = false;
	// }

	public static void main(String[] args) {
		Tower torre = new Tower();
		Tower clon;

		clon = (Tower) torre.clone();
		if (torre.equals(clon)) {
			System.out.println("El clon de la torre se ha creado correctamente");

		} else {
			System.out.println("El clon del la torre no se ha creado correctamente");
		}
	}
}
