import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// A anotação "Executar" só será usada em métodos.
@Target(ElementType.METHOD)

// Essa anotação "Executar" vai estar disponível durante a execução da aplicação.
@Retention(RetentionPolicy.RUNTIME)
public @interface Executar {
	
	// Elemento ou parâmetro 
	// É do tipo String e possui o nome "arg".
	int numRandom();
}

