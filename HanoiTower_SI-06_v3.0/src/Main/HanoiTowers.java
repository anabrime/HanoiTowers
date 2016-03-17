package Main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Estados.Environment;
import Operadores.Move;
import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.SearchMethod;
import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;

public class HanoiTowers extends Problem {

	private Environment env1 = new Environment(3, 4, 0, 2);

	public HanoiTowers() {
		super();
	}

	@Override
	public boolean isFinalState(State state) {
		if (state != null && state instanceof Environment) {
			if (((Environment) state).getArrayTorres()[((Environment) state).getTorreFinal()].getDiscosEnTorre()
					.size() == ((Environment) state).getDiscos()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public State gatherInitialPercepts() {
		return env1;
	}

	protected void createOperators() {

		for (int i = 0; i < env1.getTorres(); i++) {
			for (int j = 0; j < env1.getTorres(); j++) {
				this.addOperator(new Move(i, j));
			}
		}
	}

	public void solve(SearchMethod searchMethod) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.S");
		Date beginDate = Calendar.getInstance().getTime();
		System.out.println(
				"\n* Start '" + searchMethod.getClass().getSimpleName() + "' (" + formatter.format(beginDate) + ")");

		Node finalNode = searchMethod.search(this, this.getInitialStates().get(0));

		Date endDate = Calendar.getInstance().getTime();
		System.out.println(
				"* End   '" + searchMethod.getClass().getSimpleName() + "' (" + formatter.format(endDate) + ")");

		long miliseconds = (int) Math.abs(beginDate.getTime() - endDate.getTime());
		long seconds = miliseconds / 1000;
		miliseconds %= 1000;
		long minutes = seconds / 60;
		seconds %= 60;
		long hours = minutes / 60;
		minutes %= 60;

		String time = "\n* Serach lasts: ";
		time += (hours > 0) ? hours + " h " : " ";
		time += (minutes > 0) ? minutes + " m " : " ";
		time += (seconds > 0) ? seconds + "s " : " ";
		time += (miliseconds > 0) ? miliseconds + "ms " : " ";

		System.out.println(time);

		if (finalNode != null) {
			System.out.println("\n- Solution found!     :)");
			List<String> operators = new ArrayList<String>();
			searchMethod.solutionPath(finalNode, operators);
			searchMethod.createSolutionLog(operators);
			System.out.println("- Final state:\n" + finalNode.getState());
		} else {
			System.out.println("\n- Unable to find the solution!     :(");
		}
	}
}
