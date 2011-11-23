package com.acme.internal;

import org.xwiki.component.annotation.Component;
import org.xwiki.component.annotation.Requirement;
import org.xwiki.script.service.ScriptService;

import com.acme.Save;

@Component("save")
public class SaveScriptService implements ScriptService
{
    @Requirement
    private Save save;

    public String save2(String modeloDaXwiki)
    {
	return save.saveModelo(modeloDaXwiki);

    }
}
