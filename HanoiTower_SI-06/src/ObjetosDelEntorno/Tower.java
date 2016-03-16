package ObjetosDelEntorno;

import java.util.ArrayList;

//En la clase torre equals de arrays de discos y en environmment equals de torre con torre
public class Tower implements Cloneable {

	// ¿Más optimo usar id o diferenciar torres en la clase entorno?
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
		for (int i = 0; i <= id; i++) {
			Disc disc = new Disc(i);
			this.discosEnTorre.add(disc);
		}

	}

	public String toString() {
		String str = "";
		for (int i = 0; i < this.getDiscosEnTorre().size(); i++) {
			str += this.getDiscosEnTorre().get(i).toString();
		}
		return str;
	}

	public Object clone() {
		Object clon = null;

		try {
			clon = super.clone();
		} catch (CloneNotSupportedException e) {
			System.err.println("% [ERROR] Room.clone(): " + e.getMessage());
		}

		return clon;
	}

	public boolean equals(Tower t) {
		boolean equal = false;

		if (this.getDiscosEnTorre().size() == t.getDiscosEnTorre().size()) {

			for (int i = 0; i < this.getDiscosEnTorre().size(); i++) {

				if (this.getDiscosEnTorreConIndice(i).equals(t.getDiscosEnTorreConIndice(i)))
					equal = true;

				else
					equal = false;
			}
		}
		return equal;
	}
	// if(d.equals(t.getDiscosEnTorre()))
	// if (this.getDiscosEnTorre().equals(t.getDiscosEnTorre())) {
	// equal = true;
	// } else
	// equal = false;
	// }
}
