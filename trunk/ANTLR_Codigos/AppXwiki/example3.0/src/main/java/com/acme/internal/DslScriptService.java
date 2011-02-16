package com.acme.internal;

import org.xwiki.component.annotation.Component;
import org.xwiki.component.annotation.Requirement;
import org.xwiki.script.service.ScriptService;

import com.acme.Dsl;

@Component("dsl")
public class DslScriptService implements ScriptService
{
    @Requirement
    private Dsl dsl;

    public void executeDsl2()
    {
        dsl.executeDsl();
    }
}
