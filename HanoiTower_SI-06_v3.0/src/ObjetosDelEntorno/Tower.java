package ObjetosDelEntorno;

import java.util.ArrayList;

//Clase que implementa las torres del entorno.
public class Tower implements Cloneable {
//Variables
	private ArrayList<Disc> discosEnTorre; //Estructura que guarda los discos que contiene cada torre.
//Constructor
	public Tower() {
		setDiscosEnTorre(new ArrayList<Disc>());
	}
//Getters y Setters
	public ArrayList<Disc> getDiscosEnTorre() {
		return discosEnTorre;
	}

	public Disc getDiscosEnTorreConIndice(int id) {
		return discosEnTorre.get(id);
	}

	public void setDiscosEnTorre(ArrayList<Disc> discosEnTorre) {
		this.discosEnTorre = discosEnTorre;
	}

// Coloca discos en la primera torre donde el numero de discos a colocar es "id"
	public void estadoInicial_(int id) {
		for (int i = 1; i <= id; i++) {
			Disc disc = new Disc(i);
			this.discosEnTorre.add(disc);
		}

	}
//Metodo toString() redefinido.
	@Override
	public String toString() {
		String str = " ";
		for (int i = 0; i < this.getDiscosEnTorre().size(); i++) {
			str += this.getDiscosEnTorre().get(i).toString();
		}
		return str;
	}
//Metodo de clonado de torres. Replica la información de todas las variables de la clase torre.
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
//Metodo que compara un entorno con otro. En caso de ser iguales, devuelve True, y en caso cntrario False.
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
//Main de prueba.
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
