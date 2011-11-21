import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;

public class teste {	
public static void main(String args[]) {
	StringTemplate hello = new StringTemplate("Hello, $name$");
	hello.setAttribute("name", "World");
	System.out.println(hello.toString());
	}
}
