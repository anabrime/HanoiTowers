package Main;

import Estados.Environment;
import Operadores.Move;

public class TestMain {

	public static void main(String[] args) {

		Environment env1 = new Environment(3, 4, 0, 2);
		Environment env2 = new Environment(3, 4, 0, 2);

		System.out.println("Testeo de metodo equals: ");
		if (env1.equals(env2)) {
			System.out.println("Los entornos env1 y env2 son iguales.");
		} else
			System.out.println("Los entornos env1 y env2 son diferentes.");

		System.out.println("Creacion de un movimiento hacia la derecha.");
		Move mov = new Move(0, 2);
		System.out.println("Mover disco superior de la torre 0 a la torre 2.");
		if (mov.isApplicable(env1)) {
			System.out.println(env1.toString());
			Environment entornoTrasMovimiento = (Environment) mov.effect(env1);
			System.out.println(entornoTrasMovimiento.toString());
		} else
			System.out.println("Error al mover.");

		System.out.println("Comprobar si tras el movimiento se llega al estado final del problema.");
		HanoiTowers prob = new HanoiTowers();
		if (prob.isFinalState(env1)) {
			System.out.println("Se ha alcanzado el estado final.");
		} else {
			System.out.println("No se ha alcanzado el estado final.");
		}
		
	}
}
