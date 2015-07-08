/*
 * AutoRefactor - Eclipse plugin to automatically refactor Java code bases.
 *
 * Copyright (C) 2015 Jean-Noël Rouvignac - initial API and implementation
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program under LICENSE-GNUGPL.  If not, see
 * <http://www.gnu.org/licenses/>.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution under LICENSE-ECLIPSE, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.autorefactor.refactoring.rules.samples_in;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UseDiamondOperatorSample {

    private final List<String> listField = new ArrayList<String>();

    public List<String> refactorVariableDeclarationStatement() {
        List<String> l = new ArrayList<String>();
        return l;
    }

    public List<String> refactorVariableDeclarationStatementWithParentheses() {
        List<String> l = ((new ArrayList<String>()));
        return l;
    }

    public List<String> refactorAssignment() {
        List<String> l;
        l = new ArrayList<String>();
        return l;
    }

    public List<String> refactorReturnStatement() {
        return new ArrayList<String>();
    }

    /**
     * @see <a href="https://stuartmarks.wordpress.com/2011/04/29/when-should-diamond-be-used/">
     * When Should Diamond Be Used?</a>
     */
    public void doNotRefactorMethodArgument() {
        List<String> list2 = Collections.synchronizedList(new ArrayList<String>());
        System.out.println(list2);
    }

    /**
     * @see <a href="https://stuartmarks.wordpress.com/2011/04/29/when-should-diamond-be-used/">
     * When Should Diamond Be Used?</a>
     */
    public void refactorMethodArgumentInferToObject() {
        List<Object> list3 = Collections.synchronizedList(new ArrayList<Object>()); // FIXME refactor
        System.out.println(list3);
    }

    /**
     * @see <a href="https://stuartmarks.wordpress.com/2011/04/29/when-should-diamond-be-used/">
     * When Should Diamond Be Used?</a>
     */
    public void refactorMethodArgumentInferTypeFromOutside(List<String> l) {
        List<String> list4 = Collections.synchronizedList(new ArrayList<String>(l)); // FIXME refactor
        System.out.println(list4);
    }

    /**
     * @see <a href="https://stuartmarks.wordpress.com/2011/04/29/when-should-diamond-be-used/">
     * When Should Diamond Be Used?</a>
     */
    public void refactorMethodArgumentInferTypeFromOutside2(List<String> l) {
        List<? extends String> list6 = Collections.synchronizedList(new ArrayList<String>(l)); // FIXME refactor
        System.out.println(list6);
    }

    /**
     * @see <a href="http://docs.oracle.com/javase/7/docs/technotes/guides/language/type-inference-generic-instance-creation.html">
     * Type Inference for Generic Instance Creation</a>
     */
    public List<String> doNotRefactor() {
        List<String> list = new ArrayList<>();
        list.addAll(new ArrayList<String>());
        return list;
    }

    public List<String> doNotRefactorAnonymousClass() {
        return new ArrayList<String>() {
            @Override
            public String toString() {
                return super.toString();
            }
        };
    }

    public List<Object> doNotRefactor2(Collection<String> col) {
        List<Object> list = new ArrayList<Object>(col);
        return list;
    }
}
