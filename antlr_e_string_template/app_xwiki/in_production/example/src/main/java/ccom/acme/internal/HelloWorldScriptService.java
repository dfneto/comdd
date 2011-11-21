package ccom.acme.internal;

import org.xwiki.component.annotation.Component;
import org.xwiki.component.annotation.Requirement;
import org.xwiki.script.service.ScriptService;

import ccom.acme.HelloWorld;


@Component("dsl")
public class HelloWorldScriptService implements ScriptService
{
    @Requirement
    private HelloWorld dsl;

    public String executeDsl2(String modelo)
    {
        return dsl.executeDsl(modelo);

    }

 


}
