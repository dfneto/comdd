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
   public void executeDsl() throws Exception;
}

