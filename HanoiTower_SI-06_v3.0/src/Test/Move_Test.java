package Main;
import static org.junit.Assert.*;

import org.junit.Test;

import es.deusto.ingenieria.is.search.formulation.State;
import Estados.Environment;
import Operadores.Move;
public class Move_Test {

	
	@Test
	public void isAplicableTest(){

		Environment env = new Environment(4, 8, 1, 2); 
		Move move= new Move(1, 1);
		assertTrue(!move.isApplicable(env));
	}
	@Test
	public void isAplicableTest2(){

		Environment env = new Environment(4, 8, 1, 2); 
		Move move= new Move(1, 2);
		assertTrue(move.isApplicable(env));
	}
	@Test
	public void isAplicableTest3(){

		Environment env = new Environment(4, 8, 1, 2); 
		Move move= new Move(1, 3);
		assertTrue(move.isApplicable(env));
	}
}
