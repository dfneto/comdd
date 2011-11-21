package com.acme;

import org.xwiki.component.annotation.ComponentRole;

@ComponentRole
public interface Dsl
{
    /**
     * Says hello by returning a greeting to the caller.
     *
     * @return a greeting
     */
  //  String sayHello();
    public void executeDsl();
}

