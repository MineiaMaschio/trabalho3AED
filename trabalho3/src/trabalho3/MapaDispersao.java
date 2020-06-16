package trabalho3;

public class MapaDispersao<K, T> {

	Lista[] tabela = null;

	public MapaDispersao(int quantidade) {
		this.tabela = new Lista[proxNumeroPrimo(quantidade * 2)];
	}

	public int calcularHash(K chave) {
		return chave.hashCode() % this.tabela.length;
	}

	public boolean inserir(K chave, T dado) {
		if (buscar(chave) != null) {
			return false;
		}
		int posicao = calcularHash(chave);
		ListaEncadeada<K, T> lista = (ListaEncadeada<K, T>) this.tabela[posicao];
		if (lista == null) {
			lista = new ListaEncadeada();
			lista.insere(chave, dado);
			this.tabela[posicao] = lista;
		}else {
			lista.insere(chave, dado);
		}
		return true;
	}

	public T remover(K chave) {
		int posicao = calcularHash(chave);
		ListaEncadeada<K, T> lista = (ListaEncadeada<K, T>) this.tabela[posicao];
		if (lista == null) {
			return null;
		}
		int localiza = lista.localiza(chave);
		if (localiza == -1) {
			return null;
		}
		T objeto = lista.busca(localiza);
		lista.retira(localiza);
		return objeto;
	}

	public T buscar(K chave) {
		int posicao = calcularHash(chave);
		ListaEncadeada<K, T> lista = (ListaEncadeada<K, T>) this.tabela[posicao];
		if (lista == null) {
			return null;
		}
		int localiza = lista.localiza(chave);
		if (localiza == -1) {
			return null;
		}
		return lista.busca(localiza);
	}

	public int quantosElementos() {
		int quantidade = 0;
		ListaEncadeada<K, T> listaEncadeada;
		for (int i = 0; i < tabela.length; i++) {
			listaEncadeada = (ListaEncadeada<K, T>) this.tabela[i];
			if (listaEncadeada != null) {
				quantidade += listaEncadeada.getQuantidade();
			}
		}
		return quantidade;
	}

	private int proxNumeroPrimo(int valor) {
		int numeroPrimo = 0;
		int contador = valor;
		while (numeroPrimo == 0) {
			numeroPrimo = ePrimo(contador);
			contador++;
		}
		return numeroPrimo;
	}

	private int ePrimo(int numero) {
		for (int i = 2; i < numero; i++) {
			if (numero % i == 0)
				return 0;
		}
		return numero;
	}
}
