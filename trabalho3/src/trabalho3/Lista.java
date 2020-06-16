package trabalho3;

public interface Lista<K, T> {

	// métodos
	void insere(K chave, T valor);

	int localiza(K chave);

	T retira(int posicao);

	T busca(int posicao);

	int getQuantidade();

	boolean estaVazia();

}