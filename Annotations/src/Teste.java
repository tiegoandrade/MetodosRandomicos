// Classe que ir� usar a anota��o.
public class Teste {

	// Ao usar a reflex�o para instanticar e chamar os m�todos, esse m�todo ser�
	// chamado, passando como par�metro o valor de arg.
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

