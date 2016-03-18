package Operadores;

import Estados.Environment;
import ObjetosDelEntorno.Disc;
import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.State;
//Clase que define las acciones, sus condiciones de cumplimiento y los efectos de las mismas.
public class Move extends Operator {
//Variables
	private int posOrigen; //Posición que el algoritmo toma como inicial.
	private int posDestino; //Posición que el algoritmo toma como final.
//Constructor
	public Move(int posOrigen, int posDestino) {
		super();
		this.posOrigen = posOrigen;
		this.posDestino = posDestino;
	}
//Método que implementa las condiciones que se deben de cumplir ara realizar una acción.
	@Override
	public boolean isApplicable(State state) {
		// Comprueba que la torre de origen no este vacia y que en caso de tener
		// discos, que se lleve
		// a una torre vacia o con discos de mayor tamaño que el disco que se va
		// a mover.
		Environment env = (Environment) state;
		if (!(env.getArrayTorres()[this.posOrigen].getDiscosEnTorre().isEmpty())) {
			if (!env.getArrayTorres()[this.posDestino].getDiscosEnTorre().isEmpty()) {
				if (((Environment) state).getArrayTorres()[this.posOrigen].getDiscosEnTorre().get(0)
						.getId() < ((Environment) state).getArrayTorres()[this.posDestino].getDiscosEnTorre().get(0)
								.getId()) {
//					System.out.println("Intentando realizar movimiento " + this.posOrigen + " " + this.posDestino);
//					System.out.println(env.toString());
					return true;
				} else {
					return false;
				}
			} else {
//				System.out.println("Intentando realizar movimiento " + this.posOrigen + " " + this.posDestino);
//				System.out.println(env.toString());
				return true;
			}
		} else {
			return false;
		}
	}
//Método que implementa los efectos de las acciones cuando estas son aplicables.
	@Override
	public State effect(State state) {
		Environment newEnvironment = (Environment) ((Environment) state).clone();

		Disc disc = newEnvironment.getArrayTorres()[this.posOrigen].getDiscosEnTorre().get(0);
		newEnvironment.getArrayTorres()[this.posOrigen].getDiscosEnTorre().remove(0);
		newEnvironment.getArrayTorres()[this.posDestino].getDiscosEnTorre().add(0, disc);
//		System.out.println("Realizando movimiento " + this.posOrigen + this.posDestino);

		return newEnvironment;
	}
}
