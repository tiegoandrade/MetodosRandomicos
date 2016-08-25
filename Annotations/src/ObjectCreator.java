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
	 * @param clazz
	 *            Classe utilizada na instancia��o do objeto.
	 * @return Objeto criado e com os m�todos invocados. Se o objeto n�o puder
	 *         ser criado, o retorno � null.
	 */
	public static <T> T create(Class<T> clazz) {

		try {
			/* Cria uma inst�ncia da classe. */
			T obj = (T) clazz.newInstance();

			/* Obt�m um array com os m�todos da classe. */
			Method[] methods = clazz.getMethods();

			/* Itera sobre cada m�todo da classe. */
			for (Method method : methods) {

				/*
				 * Obt�m a anota��o "exec" do m�todo. Se n�o tiver a anota��o,
				 * retorna null.
				 */
				Executar exec = method.getAnnotation(Executar.class);

				/*
				 * Invoca o m�todo caso haja anota��o e o elemento seja igual ao n�mero rand�mico sorteado.
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