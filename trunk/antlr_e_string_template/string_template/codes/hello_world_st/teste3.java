import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;


public class teste3 {
	public static void main(String args[]){

		StringTemplateGroup group = new StringTemplateGroup("myGroup", ".");
		StringTemplate query = group.getInstanceOf("template");
		query.setAttribute("column", "name");
		query.setAttribute("column", "email");
		query.setAttribute("table", "User");



		System.out.println(query.toString());

}
}
