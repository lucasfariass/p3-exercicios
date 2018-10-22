/**
 * 
 */
package br.cesed.si.p3.ed.deque.sequencial;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.cesed.si.p3.ed.deque.*;;

/**
 * @author Lucas Farias
 *
 */
class DequeTeste {

	private Deque deque;
	
	@BeforeEach
	void setUp() throws Exception {
		deque = new Deque();
	}

	
	@Test
	public void testeAddFirstUmElemento() throws EstadoInvalidoException {
		deque.insertFirst(1);
		Assert.assertEquals(1, deque.size());
	}
	
	@Test
	public void testeAddFirstVariosElementos() throws EstadoInvalidoException {
		deque.insertFirst(1);
		deque.insertFirst(2);
		deque.insertFirst(3);
		Assert.assertEquals(3, deque.size());
	}
	
	@Test 
	public void testeAddLast() throws EstadoInvalidoException {
		deque.insertLast(1);
		deque.insertLast(2);
		Assert.assertEquals(2, deque.size());
	}
	
	@Test
	public void testeRemoveFirst() throws EstadoInvalidoException {
		deque.insertFirst(1);
		deque.insertFirst(2);
		deque.removeFirst();
		Assert.assertEquals(1, deque.size());	
	}
	
	@Test
	public void testeRemoveLast() throws EstadoInvalidoException {
		deque.insertFirst(1);
		deque.insertLast(2);
		deque.removeLast();
		Assert.assertEquals(1, deque.size());
	}
	
	@Test
	public void testeAddException() {
		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			deque.insertFirst(null);
		});
	}


}
