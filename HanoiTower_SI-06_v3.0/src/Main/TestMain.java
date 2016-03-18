package Main;

import Estados.Environment;
import Operadores.Move;
import es.deusto.ingenieria.is.search.algorithms.blind.BreadthFSwithLog;
import es.deusto.ingenieria.is.search.algorithms.blind.DepthFSwithLog;

public class TestMain {

	public static void main(String[] args) {

		// Environment env1 = new Environment(3, 4, 0, 2);

		// Prueba clon antes de effect
		// Environment clon = (Environment) env1.clone();
		// System.out.println("El clon y el env1 son iguales?");
		// System.out.println(env1.equals(clon));
		// Environment env2 = new Environment(3, 4, 0, 2);
		//
		// System.out.println("Testeo de metodo equals: ");
		// if (env1.equals(env2)) {
		// System.out.println("Los entornos env1 y env2 son iguales.");
		// } else
		// System.out.println("Los entornos env1 y env2 son diferentes.");
		//
		// System.out.println("Creacion de un movimiento hacia la derecha.");
		// Move mov = new Move(0, 2);
		// System.out.println("Mover disco superior de la torre 0 a la torre
		// 2.");
		// if (mov.isApplicable(env1)) {
		// System.out.println(env1.toString());
		// env1 = (Environment) mov.effect(env1);
		// System.out.println(env1.toString());
		// } else
		// System.out.println("Error al mover.");
		// // clon.setDiscos(2);
		// System.out.println("Despues de effect()\n" + clon.toString());
		// System.out.println("Siguen siendo iguales env1 y clon?");
		//
		// // Prueba de clon despues de effect
		// System.out.println(env1.equals(clon));
		//
		// // Prueba isFinalState
		// System.out.println("Comprobar si tras el movimiento se llega al
		// estado final del problema.");
		// HanoiTowers prob = new HanoiTowers();
		// if (prob.isFinalState(env1)) {
		// System.out.println("Se ha alcanzado el estado final.");
		// } else {
		// System.out.println("No se ha alcanzado el estado final.");
		// }

		// Prueba metodo solve()
		try {
			HanoiTowers problem = new HanoiTowers();
			problem.addInitialState(problem.gatherInitialPercepts());
			problem.solve(DepthFSwithLog.getInstance());
			problem.solve(BreadthFSwithLog.getInstance());
		} catch (Exception ex) {
			System.err.println("% [MainProgram] Error: " + ex.getMessage());
			ex.printStackTrace();
		}

	}
}
