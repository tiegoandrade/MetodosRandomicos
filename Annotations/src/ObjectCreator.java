import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Classe que usa uma anota��o para verificar se um m�todo pode ou n�o ser
 * executado.
 * 
 * @version 1.0 23-08-2016
 * @author Tiego
 *
 */
public class ObjectCreator {

	/**
	 * M�todo que instancia e chama os m�todos automaticamente ap�s a constru��o
	 * do objeto, caso seja necess�rio.
	 * 
	 * @param <T>
	 *            Classe que ter� seu objeto instanciado e seus m�todos
	 *            chamados.
	 * 
	 * @param clazz
	 *            Classe utilizada na instancia��o do objeto.
	 * @return Objeto criado e com os m�todos invocados. Se o objeto n�o puder
	 *         ser criado, o retorno � null.
	 * @throws InvocationTargetException
	 *             Lan�ado quando h� algum problema na invoca��o do m�todo por
	 *             meio de Reflex�o.
	 * @throws IllegalArgumentException
	 *             Lan�ado quando um m�todo passa um par�metro ilegal ou
	 *             inapropriado.
	 * @throws IllegalAccessException
	 *             Lan�ado quando o m�todo n�o tem acesso a classe que ser�
	 *             instanciada
	 * @throws InstantiationException
	 *             Lan�ada quando a classe n�o puder ser instanciada.
	 */
	public static <T> void create(Class<T> clazz)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, InstantiationException {

		/* Cria uma inst�ncia da classe. */
		T obj = (T) clazz.newInstance();

		/* Obt�m um array com os m�todos da classe. */
		Method[] methods = clazz.getMethods();

		int random = 1 + (int) (Math.random() * 3);

		/* Itera sobre cada m�todo da classe. */
		for (Method method : methods) {

			/*
			 * Obt�m a anota��o "exec" do m�todo. Se n�o tiver a anota��o,
			 * retorna null.
			 */
			Executar exec = method.getAnnotation(Executar.class);

			/*
			 * Invoca o m�todo caso haja anota��o e o elemento seja igual ao
			 * n�mero rand�mico sorteado.
			 */
			if (exec != null && exec.numRandom() == random) {
				method.invoke(obj);

			}
		}
	}
}