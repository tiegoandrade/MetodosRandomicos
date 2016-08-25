// Classe que irá usar a anotação.
public class Teste {

	// Ao usar a reflexão para instanticar e chamar os métodos, esse método será
	// chamado, passando como parâmetro o valor de arg.
	@Executar(numRandom = 1)
	public void m1() {
		System.out.println("m1 chamado");
	}
	
	@Executar(numRandom = 3)
	public void m2() {
		System.out.println("m2 chamado");
	}
	
	@Executar(numRandom = 2)
	public void m3() {
		System.out.println("m3 chamado");
	}
}

