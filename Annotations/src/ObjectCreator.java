import java.lang.reflect.InvocationTargetException;
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
	 * @param <T>
	 *            Classe que terá seu objeto instanciado e seus métodos
	 *            chamados.
	 * 
	 * @param clazz
	 *            Classe utilizada na instanciação do objeto.
	 * @return Objeto criado e com os métodos invocados. Se o objeto não puder
	 *         ser criado, o retorno é null.
	 * @throws InvocationTargetException
	 *             Lançado quando há algum problema na invocação do método por
	 *             meio de Reflexão.
	 * @throws IllegalArgumentException
	 *             Lançado quando um método passa um parâmetro ilegal ou
	 *             inapropriado.
	 * @throws IllegalAccessException
	 *             Lançado quando o método não tem acesso a classe que será
	 *             instanciada
	 * @throws InstantiationException
	 *             Lançada quando a classe não puder ser instanciada.
	 */
	public static <T> void create(Class<T> clazz)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, InstantiationException {

		/* Cria uma instância da classe. */
		T obj = (T) clazz.newInstance();

		/* Obtém um array com os métodos da classe. */
		Method[] methods = clazz.getMethods();

		int random = 1 + (int) (Math.random() * 3);

		/* Itera sobre cada método da classe. */
		for (Method method : methods) {

			/*
			 * Obtém a anotação "exec" do método. Se não tiver a anotação,
			 * retorna null.
			 */
			Executar exec = method.getAnnotation(Executar.class);

			/*
			 * Invoca o método caso haja anotação e o elemento seja igual ao
			 * número randômico sorteado.
			 */
			if (exec != null && exec.numRandom() == random) {
				method.invoke(obj);

			}
		}
	}
}