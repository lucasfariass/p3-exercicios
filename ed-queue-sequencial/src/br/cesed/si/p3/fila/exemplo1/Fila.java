package br.cesed.si.p3.fila.exemplo1;

/**
 * @author Lucas Farias
 *
 */
public class Fila {

	private int inseridos;

	private static final int ALOCACAO_INICIAL = 3;

	private Object[] arrayInterno = new Object[ALOCACAO_INICIAL];

	/**
	 * Adiciona um novo objeto na fila (ultima posição)
	 * @param item
	 */
	public void enqueue(Object item) {

		if (inseridos == arrayInterno.length) {

			Object[] novo = new Object[arrayInterno.length * 2];

			for (int i = 0; i < arrayInterno.length; i++) {
				novo[i] = arrayInterno[i];
			}

			arrayInterno = novo;
		}

		arrayInterno[inseridos] = item;
		inseridos++;
	}

	/**
	 * Remove e retorna o elemento do inicio da fila
	 * @return
	 */
	public Object dequeue() {

		Object retorno = arrayInterno[0];

		if (inseridos > 0) {

			for (int i = 0; i < inseridos - 1; i++) {
				arrayInterno[i] = arrayInterno[i + 1];
			}

			inseridos--;
			arrayInterno[inseridos] = null;
		}

		return retorno;
	}

	/**
	 * Retorna o objeto do início da fila, sem remover
	 * @return
	 */
	public Object front() {
		return arrayInterno[0];
	}

	/**
	 * Retorna o tamanho da fila
	 * @return
	 */
	public int tamanho() {
		return inseridos;
	}

	/**
	 * Retorna se a fila está vazia ou não
	 * @return
	 */
	public boolean isEmpty() {
		return inseridos == 0;
	}

}
