package ccom.acme;

import org.xwiki.component.annotation.ComponentRole;

@ComponentRole
public interface HelloWorld
{
    /**
     * Says hello by returning a greeting to the caller.
     *
     * @return a greeting
     */
   // String sayHello();
  public String executeDsl(String modelo);
}

