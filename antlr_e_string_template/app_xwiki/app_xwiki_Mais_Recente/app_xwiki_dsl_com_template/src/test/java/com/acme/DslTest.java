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
package com.acme;

import org.junit.Assert;
import org.junit.Test;
import com.acme.internal.DefaultDsl;
import org.xwiki.test.AbstractMockingComponentTestCase;
import org.xwiki.test.annotation.MockingRequirement;

/**
 * Tests for the {@link HelloWorld} component.
 *
 * @version $Id: HelloWorldTest.java 33407 2010-12-14 20:42:26Z sdumitriu $
 */
public class DslTest extends AbstractMockingComponentTestCase
{
    @MockingRequirement
    private DefaultDsl hw;

    @Test
    public void testSayHello()
    {
        //Assert.assertEquals("Hello", hw.sayHello());
    }
}
