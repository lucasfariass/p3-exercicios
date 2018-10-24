/**
 * 
 */
package br.cesed.si.p3.ed.encadeada.lista;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * @author Lucas Farias
 *
 */
class TesteListaEncadeada {

	private ListaEncadeada lista;
	private Conta conta;
	
	@BeforeEach
	void setUp() throws Exception {
		lista = new ListaEncadeada();
	}

	@Test
	public void testeAdd() throws EstadoInvalidoException {
		lista.adicionar(new Conta(111, 32412, "Lucas"));
		lista.adicionar(new Conta(111, 32412, "João"));
		lista.adicionar(new Conta(111, 32412, "Maria"));
		Assert.assertEquals(3, lista.tamanho());
	}
	
	@Test
	public void testeGet() throws EstadoInvalidoException {
		Conta conta1 = new Conta(111, 32412, "Lucas");
		Conta conta2 = new Conta(111, 32412, "João");
		Conta conta3 = new Conta(111, 32412, "Maria");
		
		lista.adicionar(conta1);
		lista.adicionar(conta2);
		lista.adicionar(conta3);
		
		Assert.assertEquals("Maria", conta3.getTitular());
	}
	
	@Test
	public void testeTamanho() throws EstadoInvalidoException {
		Conta conta1 = new Conta(111, 32412, "Lucas");
		Conta conta2 = new Conta(111, 32412, "João");
		Conta conta3 = new Conta(111, 32412, "Maria");
		
		lista.adicionar(conta1);
		lista.adicionar(conta2);
		lista.adicionar(conta3);
		
		Assert.assertEquals(3, lista.tamanho());
	}
	
	@Test
	public void testeRemoverComGet() throws EstadoInvalidoException {
		Conta conta1 = new Conta(111, 32412, "Lucas");
		Conta conta2 = new Conta(111, 32412, "João");
		Conta conta3 = new Conta(111, 32412, "Maria");
		
		lista.adicionar(conta1);
		lista.adicionar(conta2);
		lista.adicionar(conta3);
		lista.remover(conta2);
		
		Assert.assertEquals("Maria", lista.get(1).getTitular());
	}
	
	@Test
	public void testeRemoverObjeto() throws EstadoInvalidoException {
		Conta conta1 = new Conta(111, 32412, "Lucas");
		Conta conta2 = new Conta(111, 32412, "João");
		Conta conta3 = new Conta(111, 32412, "Maria");
		
		lista.adicionar(conta1);
		lista.adicionar(conta2);
		lista.adicionar(conta3);
		lista.remover(conta2);
		
		Assert.assertEquals(2, lista.tamanho());
	}
	
	@Test
	public void testeRemoverPos() throws EstadoInvalidoException {
		Conta conta1 = new Conta(111, 32412, "Lucas");
		Conta conta2 = new Conta(111, 32412, "João");
		Conta conta3 = new Conta(111, 32412, "Maria");
		
		lista.adicionar(conta1);
		lista.adicionar(conta2);
		lista.adicionar(conta3);
		lista.remover(2);
		
		Assert.assertEquals(2, lista.tamanho());
	}
	
	//Testes exceptions
	
	@Test
	public void testeAddContaInvalida() {
		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			lista.adicionar(null);
		});
	}
	
	@Test
	public void testeGetPosInvalida() {
		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			lista.get(4);
		});
	}
	
	@Test
	public void testeRemoverObjetoInvalido() {
		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			lista.remover(null);
		});
	}
	
	@Test
	public void testeRemoverPosInvalida() {
		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			lista.remover(4);
		});
	}

}
