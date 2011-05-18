/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package ccom.acme.internal;

import org.xwiki.component.annotation.Component;
import org.xwiki.component.annotation.Requirement;
import org.xwiki.script.service.ScriptService;

import ccom.acme.HelloWorld;

/**
 * Make the HelloWorld API available to scripting.
 *
 * @version $Id: HelloWorldScriptService.java 33407 2010-12-14 20:42:26Z sdumitriu $
 */
@Component("hello")
public class HelloWorldScriptService implements ScriptService
{
    @Requirement
    private HelloWorld helloWorld;

    public String greet()
    {
        return this.helloWorld.sayHello();
    }
}
