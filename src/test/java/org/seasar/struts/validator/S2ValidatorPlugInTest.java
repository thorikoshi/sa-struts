/*
 * Copyright 2004-2009 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.struts.validator;

import javax.servlet.ServletContext;

import org.apache.commons.validator.ValidatorResources;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.config.impl.ModuleConfigImpl;
import org.apache.struts.validator.ValidatorPlugIn;
import org.seasar.extension.unit.S2TestCase;

/**
 * @author higa
 * 
 */
public class S2ValidatorPlugInTest extends S2TestCase {

    /**
     * @throws Exception
     */
    public void testInitResources() throws Exception {
        S2ValidatorPlugIn plugIn = new S2ValidatorPlugIn();
        plugIn.setPathnames("validator-rules.xml");
        plugIn.init(new MyActionServlet(getServletContext()),
                new ModuleConfigImpl(""));
        ValidatorResources vr = (ValidatorResources) getServletContext()
                .getAttribute(ValidatorPlugIn.VALIDATOR_KEY);
        assertNotNull(vr);
        assertTrue(vr instanceof S2ValidatorResources);
    }

    private static class MyActionServlet extends ActionServlet {
        private static final long serialVersionUID = 1L;

        private ServletContext servletContext;

        /**
         * @param servletContext
         */
        public MyActionServlet(ServletContext servletContext) {
            super();
            this.servletContext = servletContext;
        }

        @Override
        public ServletContext getServletContext() {
            return servletContext;
        }
    }
}