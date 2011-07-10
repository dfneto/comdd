package com.acme;

import org.xwiki.component.annotation.ComponentRole;

@ComponentRole
public interface Save
{
    /**
     * Says hello by returning a greeting to the caller.
     *
     * @return a greeting
     */
   public String saveModelo(String modeloDaXwiki) ;
}

