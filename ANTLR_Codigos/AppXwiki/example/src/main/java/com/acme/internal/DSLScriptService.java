package com.acme.internal;

import org.xwiki.component.annotation.Component;
import org.xwiki.component.annotation.Requirement;
import org.xwiki.script.service.ScriptService;

import com.acme.DSL;

/**
 * Make the HelloWorld API available to scripting.
 *
 * @version $Id: HelloWorldScriptService.java 33407 2010-12-14 20:42:26Z sdumitriu $
 */
@Component("dsl")
public class DSLScriptService implements ScriptService
{
    @Requirement
    private DSL dsl;

    public void executeDsl2()
    {
        dsl.executeDsl();
    }
}
