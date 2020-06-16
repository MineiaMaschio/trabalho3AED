package trabalho3;

public class Principal {

	public static void main(String[] args) {
		Veiculo v = new Veiculo();
		v.setPlaca("AAA-0123");
		v.setModelo("Hyundai Creta");
		v.setAno(2017);
		v.setProprietario("João da Silva");
		Veiculo v2 = new Veiculo();
		v2.setPlaca("AAA-0124");
		v2.setModelo("Hyundai Creta teste 2");
		v2.setAno(2017);
		v2.setProprietario("João da Silva");
		MapaDispersao<String,Veiculo>mp = new MapaDispersao(2000);
		System.out.println(mp.quantosElementos());
		System.out.println(mp.inserir(v.getPlaca(), v));
		System.out.println(mp.inserir(v2.getPlaca(), v2));
		System.out.println(mp.quantosElementos());
		System.out.println(mp.buscar(v.getPlaca()));
		System.out.println(mp.buscar(v2.getPlaca()));
		System.out.println(mp.remover(v.getPlaca()));
		System.out.println(mp.remover(v2.getPlaca()));
		System.out.println(mp.quantosElementos());
		System.out.println(mp.buscar(v.getPlaca()));
		System.out.println(mp.buscar(v2.getPlaca()));
	}

}
