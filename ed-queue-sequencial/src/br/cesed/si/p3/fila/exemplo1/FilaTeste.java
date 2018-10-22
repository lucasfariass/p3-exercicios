/**
 * 
 */
package br.cesed.si.p3.fila.exemplo1;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Lucas Farias
 *
 */
class FilaTeste {
	
	private Fila fila;
	
	@BeforeEach
	void setUp() throws Exception {
		fila = new Fila();
	}
	
	@Test
	public void testeTamanho() {
		Assert.assertEquals(0, fila.tamanho());
	}
	
	@Test
	public void testeIsEmpty() {
		Assert.assertEquals(true, fila.isEmpty());
	}
	
	@Test
	public void testeEnqueue() {
		fila.enqueue("Lucas");
		Assert.assertEquals(1, fila.tamanho());
	}
	
	@Test
	public void testeDequeueRetorno() {
		fila.enqueue("Lucas");
		fila.enqueue("José");
		fila.enqueue("Maria");
		Assert.assertEquals("Lucas", fila.dequeue());
	}
	
	@Test
	public void testeDequeueTamanho() {
		fila.enqueue("Lucas");
		fila.enqueue("José");
		fila.enqueue("Maria");
		fila.dequeue();
		Assert.assertEquals(2, fila.tamanho());
	}
	
	@Test
	public void testeFront() {
		fila.enqueue("Lucas");
		fila.enqueue("José");
		fila.enqueue("Maria");
		Assert.assertEquals("Lucas", fila.front());
	}

}
