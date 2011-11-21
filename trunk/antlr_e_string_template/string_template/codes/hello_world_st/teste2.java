import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;


public class teste2 {
	public static void main(String args[]) {
		StringTemplateGroup group =  new StringTemplateGroup("myGroup", ".", DefaultTemplateLexer.class);
		StringTemplate helloAgain = group.getInstanceOf("homepage");

		helloAgain.setAttribute("title", "Welcome To StringTemplate");
		helloAgain.setAttribute("name", "World");
		helloAgain.setAttribute("friends", "Ter");
		helloAgain.setAttribute("friends", "Kunle");
		helloAgain.setAttribute("friends", "Micheal");
		helloAgain.setAttribute("friends", "Marq");

		System.out.println(helloAgain.toString());
		}
	}

