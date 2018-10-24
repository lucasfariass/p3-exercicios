package br.cesed.si.p3.ed.encadeada.lista;

public class ListaEncadeada {

	private Conta primeiroElemento;
	
	private int inseridos;
	
	/**
	 * Adiciona uma nova conta no final da lista
	 * @param c
	 * @throws EstadoInvalidoException
	 */
	public void adicionar(Conta c) throws EstadoInvalidoException {

		if(c != null) {
			
			if(primeiroElemento == null) {
				primeiroElemento = c;
			} else {
				
				Conta temp = primeiroElemento;
				
				while(temp.getProximo() != null) {
					temp = temp.getProximo();
				}
				
				temp.setProximo(c);
			}
			
			inseridos++;
		} else {
			throw new EstadoInvalidoException("Conta invalida!");
		}
	}

	/**
	 * Retorna a conta da posição passada como parametro
	 * @param posicao
	 * @return Conta
	 * @throws EstadoInvalidoException
	 */
	public Conta get(int posicao) throws EstadoInvalidoException {
		
		Conta temp = primeiroElemento;
		
		if (posicao < inseridos) {
			for (int i = 0; i < posicao; i++) {
				temp = temp.getProximo();
			}
			return temp;
			
		} else {
			throw new EstadoInvalidoException("Posição invalida");
		}
					
	}

	/**
	 * Remove da lista a conta passada como parametro
	 * @param c
	 * @throws EstadoInvalidoException
	 */
	public void remover(Conta c) throws EstadoInvalidoException {
		
		if(c != null) {
			
			Conta temp = primeiroElemento;
			
			while(temp.getProximo() != c) {
				temp = temp.getProximo();
				
				if(temp == null) {
					throw new EstadoInvalidoException("Conta não existe");
				}
			}
			temp.setProximo(c.getProximo());
			inseridos--;
			
		} else {
			throw new EstadoInvalidoException("Conta invalida");
		}
	}

	/**
	 * Remove da lista a conta que está na posição passada como parametro
	 * @param pos
	 * @throws EstadoInvalidoException
	 */
	public void remover(int pos) throws EstadoInvalidoException {
		
		Conta temp = primeiroElemento;
		
		if(pos < inseridos) {
			for (int i = 0; i < pos - 1; i++) {
				temp = temp.getProximo();
			}
			temp.setProximo(temp.getProximo().getProximo());
			inseridos--;
		} else {
			throw new EstadoInvalidoException("Posição invalida");
		}
	}
	
	/**
	 * Retorna o tamanho da lista
	 * @return int, tamanho da lista
	 */
	public int tamanho() {
		return inseridos;
	}
}
