package br.cesed.si.p3.ed.deque.sequencial;

/**
 * @author Lucas Farias
 *
 */
public class Deque {

	private int inseridos;

	private static final int TAM_INICIAL = 3;

	private Object[] arrayInterno = new Object[TAM_INICIAL];

	/**
	 * Metodo encapsulado de aumentar o tamanho do array
	 */
	private void aumentarArray() {
		Object[] novo = new Object[arrayInterno.length * 2];
		
		for (int i = 0; i < arrayInterno.length; i++) {
			novo[i] = arrayInterno[i];
		}
		
		arrayInterno = novo;
	}
	
	/**
	 * Insere um objeto na ultima posição do deque
	 * @param item
	 * @throws EstadoInvalidoException
	 */
	public void insertLast(Object item) throws EstadoInvalidoException{
		if(item != null) {
			if (inseridos == arrayInterno.length) {
				this.aumentarArray();
			}
			
			arrayInterno[inseridos] = item;
			inseridos++;
			
		} else {
			throw new EstadoInvalidoException("Objeto Invalido!");
		}
	}
	
	/**
	 * Insere um item na primeira posição do deque
	 * @param item
	 * @throws EstadoInvalidoException
	 */
	public void insertFirst(Object item) throws EstadoInvalidoException{
		if(item != null) {
			if (inseridos == arrayInterno.length) {
				this.aumentarArray();
			}
			if (inseridos > 0) {
				int aux = inseridos;
				for (int i = 0; i < inseridos; i++) {
					arrayInterno[aux] = arrayInterno[aux - 1];
					aux--;
				}
				
			}
			arrayInterno[0] = item;
			inseridos++;
			
		} else {
			throw new EstadoInvalidoException("Objeto Invalido!");
		}
	}
	
	/**
	 * Remove do deque o objeto passado como parametro
	 * @param item
	 * @throws EstadoInvalidoException
	 */
	public void removeByValue(Object item) throws EstadoInvalidoException {
		boolean existe = false;
		for (int i = 0; i < inseridos; i++) {
			if (arrayInterno[i] == item) {
				existe = true;
			}
		}
		
		if (existe) {
			
			Object[] novo = new Object[arrayInterno.length - 1];
			int aux = 0;
			for (int i = 0; i < inseridos; i++) {
				if (arrayInterno[i] != item) {
					novo[aux] = arrayInterno[i];
					aux++;
				}
			}
			inseridos--;
			arrayInterno = novo;
			
		} else {
			throw new EstadoInvalidoException("O objeto não existe!");
		}
	}
	
	/**
	 * Remove um objeto pela posição passada como parametro
	 * @param posicao
	 * @throws EstadoInvalidoException
	 */
	public void removeByIndex(int posicao) throws EstadoInvalidoException {
		
		if (posicao >= 0 && posicao < inseridos) {
			Object[] novo = new Object[arrayInterno.length - 1];
			int aux = 0;
			for (int i = 0; i < inseridos; i++) {
				if (i != posicao) {
					novo[aux] = arrayInterno[i];
					aux++;
				}
			}
			inseridos--;
			arrayInterno = novo;			
			
		} else {
			throw new EstadoInvalidoException("Posição invalida!");
		}
	}
	
	/**
	 * Remove o primeiro objeto do deque
	 */
	public void removeFirst() {
		arrayInterno[inseridos] = null;
		inseridos--;
	}
	
	/**
	 * Remove o ultimo objeto do deque
	 */
	public void removeLast() {
		if (inseridos > 0) {

			for (int i = 0; i < inseridos - 1; i++) {
				arrayInterno[i] = arrayInterno[i + 1];
			}

			inseridos--;
			arrayInterno[inseridos] = null;
		}
	}

	/**
	 * Retorna o tamanho do deque
	 * @return
	 */
	public int size() {
		return inseridos;
	}
	
	/**
	 * Retorna se o deque está vazio
	 * @return
	 */
	public boolean isEmpty() {
		return inseridos == 0;
	}
}
