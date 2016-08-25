import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// A anota��o "Executar" s� ser� usada em m�todos.
@Target(ElementType.METHOD)

// Essa anota��o "Executar" vai estar dispon�vel durante a execu��o da aplica��o.
@Retention(RetentionPolicy.RUNTIME)
public @interface Executar {
	
	// Elemento ou par�metro 
	// � do tipo String e possui o nome "arg".
	int numRandom();
}

