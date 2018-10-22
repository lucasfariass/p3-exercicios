package br.cesed.si.p3.listas.sequencial;

/**
 * @author Lucas Farias
 *
 */
public class ListaSequencial {

	private static final int ALOCACAO_INICIAL = 3;
	
	private Object[] arrayInterno = new Object[ALOCACAO_INICIAL];
	
	private int inseridos;
	
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
	 * Insere um elemento na ultima posição da lista
	 * @param item
	 * @throws EstadoInvalidoException
	 */
	public void adicionar(Object item) throws EstadoInvalidoException {
		
		if(item != null) {
			if(inseridos == arrayInterno.length) {
				this.aumentarArray();
			}
			arrayInterno[inseridos] = item;
			inseridos++;	
			
		} else {
			throw new EstadoInvalidoException("Objeto invalido!");
		}
	}

	/**
	 * Insere o item na posição passada como parametro
	 * @param item
	 * @param posicao
	 * @throws EstadoInvalidoException
	 */
	public void adicionar(Object item, int posicao) throws EstadoInvalidoException {
		
		if(posicao >= 0 && posicao <= inseridos && item != null) {
			if (arrayInterno.length < posicao) {
				this.aumentarArray();
			}
			if (arrayInterno[posicao] == null) {
				inseridos++;
			}
			arrayInterno[posicao] = item; 
			
		} else {
			throw new EstadoInvalidoException("Objeto ou posição invalida!");
		}
	}

	/**
	 * Retorna um objeto pela posição na lista
	 * @param indice
	 * @return
	 */
	public Object obter(int indice) {
		return arrayInterno[indice];
	}

	/**
	 * Remove da lista o objeto passado como parametro
	 * @param item
	 * @throws EstadoInvalidoException
	 */
	public void remover(Object item) throws EstadoInvalidoException {
		
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
			throw new EstadoInvalidoException("Objeto não existe!");
		}
	}
	
	/**
	 * Remove um objeto pela posição passada como parametro
	 * @param posicao
	 * @throws EstadoInvalidoException
	 */
	public void remover(int posicao) throws EstadoInvalidoException {
		
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
	 * Retorna se a lista está vazia
	 * @return
	 */
	public boolean isEmpty() {
		return inseridos == 0;
	}
	
	/**
	 * Limpa toda a lista
	 */
	public void limpar() {
		arrayInterno = new Object[ALOCACAO_INICIAL];
	}
	
	/**
	 * Retorna o tamanho da lista
	 * @return
	 */
	public int tamanho() {
		return inseridos;
	}
}
