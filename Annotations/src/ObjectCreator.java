import java.lang.reflect.Method;

/**
 * Classe que usa uma anotação para verificar se um método pode ou não ser
 * executado.
 * 
 * @version 1.0 23-08-2016
 * @author Tiego
 *
 */
public class ObjectCreator {

	/**
	 * Método que instancia e chama os métodos automaticamente após a construção
	 * do objeto, caso seja necessário.
	 * 
	 * @param clazz
	 *            Classe utilizada na instanciação do objeto.
	 * @return Objeto criado e com os métodos invocados. Se o objeto não puder
	 *         ser criado, o retorno é null.
	 */
	public static <T> T create(Class<T> clazz) {

		try {
			/* Cria uma instância da classe. */
			T obj = (T) clazz.newInstance();

			/* Obtém um array com os métodos da classe. */
			Method[] methods = clazz.getMethods();

			/* Itera sobre cada método da classe. */
			for (Method method : methods) {

				/*
				 * Obtém a anotação "exec" do método. Se não tiver a anotação,
				 * retorna null.
				 */
				Executar exec = method.getAnnotation(Executar.class);

				/*
				 * Invoca o método caso haja anotação e o elemento seja igual ao número randômico sorteado.
				 */
				if (exec != null && exec.numRandom() == NumeroRandom.getRandomInt()) {
					method.invoke(obj);
				}
			}
			
			/* Retorna o objeto criado. */
			return obj;
		} catch (Exception e) {
			
			/* Se houver algum problema, retorna null. */ 
			return null;
		}
	}
}