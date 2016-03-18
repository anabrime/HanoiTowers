package ObjetosDelEntorno;
//Clase que implementa los discos.
public class Disc implements Cloneable {
//Variables
	private int id; //Identificador del disco.
//Constructor
	public Disc(int id) {
		this.id = id;
	}
//Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
//Metodo toString() redefinido.
	@Override
	public String toString() {
		String str = this.id + " ";
		return str;
	}
//Metodo que compara un entorno con otro. En caso de ser iguales, devuelve True, y en caso cntrario False.
	public boolean equals(Disc d) {
		if (this.getId() == d.getId()) {
			return true;
		}
		return false;
	}
//Metodo de clonado de discos. Replica la información de todas las variables de la clase disco.
	@Override
	public Object clone() {
		Disc clon = new Disc(this.id);
		return clon;
	}
}
