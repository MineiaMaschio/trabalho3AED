package trabalho3;

public class ItemLista<K, T> {
	private K chave;

	private T info;
	private ItemLista<K, T> prox;

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public ItemLista<K, T> getProx() {
		return prox;
	}

	public void setProx(ItemLista<K, T> prox) {
		this.prox = prox;
	}

	public K getChave() {
		return chave;
	}

	public void setChave(K chave) {
		this.chave = chave;
	}
}
