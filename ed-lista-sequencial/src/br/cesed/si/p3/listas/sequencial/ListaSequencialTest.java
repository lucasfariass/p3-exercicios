package br.cesed.si.p3.listas.sequencial;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListaSequencialTest {

	private ListaSequencial listaSequencial = new ListaSequencial();
	
	@BeforeEach
	void setUp() throws Exception {
		listaSequencial.limpar();
	}

	@Test
	void testAdd() throws EstadoInvalidoException {

		listaSequencial.adicionar("Item 1");
		listaSequencial.adicionar("Item 2");
		listaSequencial.adicionar("Item 3");
		listaSequencial.adicionar("Item 4");

		Assert.assertEquals("Item 1", listaSequencial.obter(0));
		Assert.assertEquals("Item 2", listaSequencial.obter(1));
		Assert.assertEquals("Item 3", listaSequencial.obter(2));
		Assert.assertEquals("Item 4", listaSequencial.obter(3));
		Assert.assertEquals(4, listaSequencial.tamanho());
	}

	@Test
	void testAddValorInvalido() {

		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			listaSequencial.adicionar(null);
		});
	}

	@Test
	void testAddPosicao() throws EstadoInvalidoException {

		listaSequencial.adicionar("Item 1",0);
		listaSequencial.adicionar("Item 2",1);

		Assert.assertEquals("Item 1", listaSequencial.obter(0));
		Assert.assertEquals("Item 2", listaSequencial.obter(1));
		Assert.assertEquals(2, listaSequencial.tamanho());
	}
	
	@Test
	void testAddPosicaoValorInvalido() {

		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			listaSequencial.adicionar(null,0);
		});
	}

	@Test
	void testAddPosicaoInvalida() {

		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			listaSequencial.adicionar("Item 1",-1);
		});
	}

	@Test
	void testTamanhoListaVazia() {
		
		Assert.assertEquals(0, listaSequencial.tamanho());
	}
	
	@Test
	void testRemoverObjeto() throws EstadoInvalidoException {

		listaSequencial.adicionar("Item 1");
		listaSequencial.adicionar("Item 2");
		
		listaSequencial.remover("Item 1");
		
		Assert.assertEquals("Item 2", listaSequencial.obter(0));
	}
	
	@Test
	void testRemoverObjetoInvalido() {
		
		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			listaSequencial.remover(null);
		});
	}
	
	@Test
	void testRemoverPosicao() throws EstadoInvalidoException {
		
		listaSequencial.adicionar("Item 1");
		listaSequencial.adicionar("Item 2");
		
		listaSequencial.remover(0);
		
		Assert.assertEquals("Item 2", listaSequencial.obter(0));
	}
	
	@Test
	void testRemoverPosicaoInvalida() {
		
		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			listaSequencial.remover(-1);
		});
	}
	
	@Test
	void testRemoverPosicaoValorInvalido() {

		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			listaSequencial.remover(null);
		});
	}
}
