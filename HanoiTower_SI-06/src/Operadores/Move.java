package Operadores;

import Estados.Environment;
import ObjetosDelEntorno.Disc;
import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.State;

public class Move extends Operator {

	private int posOrigen;
	private int posDestino;

	public Move(int posOrigen, int posDestino) {
		super();
		this.posOrigen = posOrigen;
		this.posDestino = posDestino;
	}

	@Override
	public boolean isApplicable(State state) {
		// Comprueba que la torre de origen no este vacia y que en caso de tener
		// discos, que se lleve
		// a una torre vacia o con discos de mayor tamaño que el disco que se va
		// a mover.
		if (!((Environment) state).getArrayTorres()[this.posOrigen].getDiscosEnTorre().isEmpty()) {
			if (((Environment) state).getArrayTorres()[this.posDestino].getDiscosEnTorre().isEmpty()
					|| ((Environment) state).getArrayTorres()[this.posOrigen].getDiscosEnTorre().get(0)
							.getId() < ((Environment) state).getArrayTorres()[this.posDestino].getDiscosEnTorre().get(0)
									.getId()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public State effect(State state) {
		Environment newEnvironment = (Environment) ((Environment) state).clone();

		Disc disc = newEnvironment.getArrayTorres()[this.posOrigen].getDiscosEnTorre().get(0);
		newEnvironment.getArrayTorres()[this.posOrigen].getDiscosEnTorre().remove(0);
		newEnvironment.getArrayTorres()[this.posDestino].getDiscosEnTorre().add(0, disc);
		return newEnvironment;
	}

}
