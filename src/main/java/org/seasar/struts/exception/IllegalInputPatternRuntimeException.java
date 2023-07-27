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
package org.seasar.struts.exception;

import org.seasar.framework.exception.SRuntimeException;

/**
 * 
 * inputパターンが間違っている場合の例外です。
 * 
 * 
 * @author higa
 * 
 */
public class IllegalInputPatternRuntimeException extends SRuntimeException {

    private static final long serialVersionUID = 1L;

    private String inputPattern;

    /**
     * インスタンスを構築します。
     * 
     * @param inputPattern
     *            inputパターン
     */
    public IllegalInputPatternRuntimeException(String inputPattern) {
        super("ESAS0010", new Object[] { inputPattern });
        this.inputPattern = inputPattern;
    }

    /**
     * inputパターンを返します。
     * 
     * @return inputパターン
     */
    public String getInputPattern() {
        return inputPattern;
    }
}