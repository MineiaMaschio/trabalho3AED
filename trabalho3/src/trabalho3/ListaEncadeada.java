package trabalho3;

public class ListaEncadeada<K, T> implements Lista<K, T> {
	private ItemLista<K, T> primeiro; // = null
	private ItemLista<K, T> ultimo; // = null
	private int qtdeElementos; // = 0

	@Override
	public void insere(K chave, T valor) {
		ItemLista<K, T> novo = new ItemLista<>();
		novo.setInfo(valor);
		novo.setChave(chave);
		if (this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProx(novo);
		}
		ultimo = novo;
		qtdeElementos++;
	}

	@Override
	public int localiza(K chave) {
		ItemLista<K, T> atual = primeiro;
		int contador = 0;
		while (atual != null) {
			if (chave.equals(atual.getChave())) {
				return contador;
			}
			atual = atual.getProx();
			contador++;
		}
		return -1;
	}

	@Override
	public T retira(int posicao) {
		if (posicao < 0 || posicao > qtdeElementos) {
			throw new ListaException("Posição inválida");
		}
		T retorno = null;
		if (posicao == 0) { // primeira posição
			retorno = primeiro.getInfo();
			primeiro = primeiro.getProx();
			if (primeiro == null) {
				ultimo = null;
			}
		} else {
			ItemLista<K, T> anterior = this.descobre(posicao - 1);
			if (posicao == qtdeElementos - 1) { // última posição
				retorno = ultimo.getInfo();
				ultimo = anterior;
				ultimo.setProx(null);
			} else { // posição intermediária
				ItemLista<K, T> atual = anterior.getProx();
				retorno = atual.getInfo();
				anterior.setProx(atual.getProx());
			}
		}
		qtdeElementos--;
		return retorno;
	}

	@Override
	public T busca(int posicao) {
		if (posicao < 0 || posicao >= qtdeElementos) {
			throw new ListaException("Posição inválida");
		}
		return this.descobre(posicao).getInfo();
	}

	@Override
	public boolean estaVazia() {
		return (primeiro == null);
	}

	@Override
	public int getQuantidade() {
		return this.qtdeElementos;
	}

	private ItemLista<K, T> descobre(int posicao) {
		ItemLista<K, T> atual = primeiro;
		int contador = 0;
		while (atual != null) {
			if (contador == posicao) {
				return atual;
			}
			/*
			 * ItemLista temp = atual.getProx(); atual = temp;
			 */
			atual = atual.getProx();
			contador++;
		}
		return null;
	}

}
