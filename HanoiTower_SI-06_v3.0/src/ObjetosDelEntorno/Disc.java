package ObjetosDelEntorno;

public class Disc implements Cloneable {

	// el atributo id identifica al disco por su tamaño siendo 0 el mas pequeño
	private int id;

	public Disc(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		String str = this.id + " ";
		return str;
	}

	public boolean equals(Disc d) {
		if (this.getId() == d.getId()) {
			return true;
		}
		return false;
	}

	@Override
	public Object clone() {
		Disc clon = new Disc(this.id);
		return clon;
	}
}
