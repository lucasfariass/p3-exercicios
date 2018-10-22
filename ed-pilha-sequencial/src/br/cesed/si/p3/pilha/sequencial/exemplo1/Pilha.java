package br.cesed.si.p3.pilha.sequencial.exemplo1;

/**
 * @author Lucas Farias
 *
 */
public class Pilha {

	public static final int ALOCACAO_INICIAL = 3;
	
	private Object[] arrayInterno = new Object[ALOCACAO_INICIAL];
	
	private int inseridos;
	
	/**
	 * Insere um novo elemento no topo da pilha
	 * @param objeto
	 */
	public void push(Object objeto) {

		if(inseridos == arrayInterno.length) {
			
			Object[] novoArray = new Object[arrayInterno.length * 2];
			
			for (int i = 0; i < arrayInterno.length; i++) {
				novoArray[i] = arrayInterno[i];
			}
			
			arrayInterno = novoArray;
		}
		
		arrayInterno[inseridos] = objeto;
		inseridos++;
	}
	
	/**
	 * Remove e retorna o elemento do topo da pilha
	 * @return
	 */
	public Object pop() {

		Object retorno = arrayInterno[inseridos - 1];
		arrayInterno[inseridos - 1] = null;
		inseridos--;
		
		return retorno;
	}
	
	/**
	 * Retorna o elemento do topo da pilha, sem remover
	 * @return
	 */
	public Object top() {
		return arrayInterno[inseridos - 1];
	}
	
	/**
	 * Retorna o tamanho da pilha
	 * @return
	 */
	public int tamanho() {
		return inseridos;
	}
	
	/**
	 * Retorna se a pilha está vazia ou não
	 * @return
	 */
	public boolean isEmpty() {
		return inseridos == 0;
	}
	
}
