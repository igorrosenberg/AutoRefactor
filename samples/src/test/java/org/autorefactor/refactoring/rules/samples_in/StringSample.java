/*
 * AutoRefactor - Eclipse plugin to automatically refactor Java code bases.
 *
 * Copyright (C) 2013-2014 Jean-Noël Rouvignac - initial API and implementation
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

public class StringSample {

    public String replaceNewString() {
        return new String("");
    }

    public String replaceNewStringFromStringExpression(String s) {
        return new String(s);
    }

    public String replaceStringValueOfOnAString(String s) {
        return String.valueOf(s);
    }

    public String replaceStringToString(String s) {
        String s1 = s.toString();
        String s2 = "".toString();
        String s3 = getS().toString();
        return s1 + s2 + s3;
    }

    public String replaceToStringCallInStringConcat() {
        String s1 = "" + Boolean.TRUE.toString() + Boolean.FALSE.toString();
        String s2 = Boolean.TRUE.toString() + "" + Boolean.FALSE.toString();
        return s1 + s2;
    }

    public String doNotReplaceToStringCallOutsideStringConcat() {
        return Boolean.TRUE.toString();
    }

    public String doNotReplaceTwoConsecutiveToStringCalls() {
        return Boolean.TRUE.toString() + Boolean.FALSE.toString();
    }

    public String removeUselessToStringLeftOperand(byte b, short s) {
        String s1 = Boolean.toString(true) + " foo";
        String s2 = Character.toString('c') + " foo";
        String s3 = Byte.toString(b) + " foo";
        String s4 = Short.toString(s) + " foo";
        String s5 = Integer.toString(42) + " foo";
        String s6 = Long.toString(42l) + " foo";
        String s7 = Float.toString(42.42f) + " foo";
        String s8 = Double.toString(42.42) + " foo";
        return s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8;
    }

    public String removeUselessToStringRightOperand(byte b, short s) {
        String s1 = "foo " + Boolean.toString(true);
        String s2 = "foo " + Character.toString('c');
        String s3 = "foo " + Byte.toString(b);
        String s4 = "foo " + Short.toString(s);
        String s5 = "foo " + Integer.toString(42);
        String s6 = "foo " + Long.toString(42l);
        String s7 = "foo " + Float.toString(42.42f);
        String s8 = "foo " + Double.toString(42.42);
        return s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8;
    }

    public String removeUselessToStringExtendedOperand(byte b, short s) {
        String s1 = "foo " + Boolean.toString(true) + " bar";
        String s2 = "foo " + Character.toString('c') + " bar";
        String s3 = "foo " + Byte.toString(b) + " bar";
        String s4 = "foo " + Short.toString(s) + " bar";
        String s5 = "foo " + Integer.toString(42) + " bar";
        String s6 = "foo " + Long.toString(42l) + " bar";
        String s7 = "foo " + Float.toString(42.42f) + " bar";
        String s8 = "foo " + Double.toString(42.42) + " bar";
        return s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8;
    }

    public String removeUselessValueOfLeftOperand(byte b, short s) {
        String s1 = String.valueOf(true) + " foo";
        String s2 = String.valueOf('c') + " foo";
        String s3 = String.valueOf(b) + " foo";
        String s4 = String.valueOf(s) + " foo";
        String s5 = String.valueOf(42) + " foo";
        String s6 = String.valueOf(42l) + " foo";
        String s7 = String.valueOf(42.42f) + " foo";
        String s8 = String.valueOf(42.42) + " foo";
        String s9 = String.valueOf(new Object()) + " foo";
        return s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9;
    }

    public String removeUselessValueOfRightOperand(byte b, short s) {
        String s1 = "foo " + String.valueOf(true);
        String s2 = "foo " + String.valueOf('c');
        String s3 = "foo " + String.valueOf(b);
        String s4 = "foo " + String.valueOf(s);
        String s5 = "foo " + String.valueOf(42);
        String s6 = "foo " + String.valueOf(42l);
        String s7 = "foo " + String.valueOf(42.42f);
        String s8 = "foo " + String.valueOf(42.42);
        String s9 = "foo " + String.valueOf(new Object());
        return s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9;
    }

    public String removeUselessValueOfExtendedOperand(byte b, short s) {
        String s1 = "foo " + String.valueOf(true) + " bar";
        String s2 = "foo " + String.valueOf('c') + " bar";
        String s3 = "foo " + String.valueOf(b) + " bar";
        String s4 = "foo " + String.valueOf(s) + " bar";
        String s5 = "foo " + String.valueOf(42) + " bar";
        String s6 = "foo " + String.valueOf(42l) + " bar";
        String s7 = "foo " + String.valueOf(42.42f) + " bar";
        String s8 = "foo " + String.valueOf(42.42) + " bar";
        String s9 = "foo " + String.valueOf(new Object()) + " bar";
        return s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9;
    }

    // TODO JNR which operand must be removed here?
    // String s = "" + Integer.toString(42);

    private static String getS() {
        return null;
    }
}
