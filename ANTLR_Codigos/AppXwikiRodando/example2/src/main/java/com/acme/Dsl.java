
package com.acme;

import org.xwiki.component.annotation.ComponentRole;

/**
 * Interface (aka Role) of the Component
 * 
 * @version $Id: HelloWorld.java 33407 2010-12-14 20:42:26Z sdumitriu $
 */
@ComponentRole
public interface Dsl
{
    /**
     * Says hello by returning a greeting to the caller.
     *
     * @return a greeting
     */
    public String executeDsl(String modelo) ;
}

