import java.util.NoSuchElementException;

public class Pilha<E> {

	private Celula<E> topo;
	private Celula<E> fundo;

	public Pilha() {

		Celula<E> sentinela = new Celula<E>();
		fundo = sentinela;
		topo = sentinela;

	}

	public boolean vazia() {
		return fundo == topo;
	}

	public void empilhar(E item) {

		topo = new Celula<E>(item, topo);
	}

	public E desempilhar() {

		E desempilhado = consultarTopo();
		topo = topo.getProximo();
		return desempilhado;

	}

	public E consultarTopo() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");
		}

		return topo.getItem();

	}

	/**
	 * Cria e devolve uma nova pilha contendo os primeiros numItens elementos
	 * do topo da pilha atual.
	 * 
	 * Os elementos são mantidos na mesma ordem em que estavam na pilha original.
	 * Caso a pilha atual possua menos elementos do que o valor especificado,
	 * uma exceção será lançada.
	 *
	 * @param numItens o número de itens a serem copiados da pilha original.
	 * @return uma nova instância de Pilha<E> contendo os numItens primeiros elementos.
	 * @throws IllegalArgumentException se a pilha não contém numItens elementos.
	 */
	public Pilha<E> subPilha(int numItens) {
		if(numItens < 0){ // valida numItens
			throw new IllegalArgumentException();
		}
		Pilha<E> aux = new Pilha<>(); // guarda temporariamente os elementos copiados
		Pilha resultado = new Pilha<>(); // pilha nova que o metodo vai devolver
		Celula<E> atual = topo; // referencia que começa apontando para o topo da pilha original
		for(int i = 0 ; i < numItens; i++){ //repete exatamente numitens vezes pq queremos copiar os numitens elementos do topo
			if(atual == fundo){
				throw new IllegalArgumentException("A plilha não possui itens  suficientes");
			}
			aux.empilhar(atual.getItem()); // pega o item da celula atual e empilha da auxiliar
			atual = atual.getProximo(); // avança pra prox celula da pilha original
		}
		while(!aux.vazia()){ // os itens ficaram invertidos ent isso daqui inverte a ordem novamente pra ficar certinho
			resultado.empilhar(aux.desempilhar());
		}
		return resultado;
	}
}