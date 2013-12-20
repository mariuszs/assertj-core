/*
 * Created on Dec 21, 2013
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * 
 * Copyright @2009-2012 the original author or authors.
 */
package org.assertj.core.presentation;

import static org.assertj.core.util.Strings.concat;
import static org.assertj.core.util.Strings.quote;

import java.text.SimpleDateFormat;
import java.util.*;

import org.assertj.core.util.Hexadecimals;

/**
 * Obtains the simplified for use in arrays hexadecimal {@code toString} representation of an object.
 * 
 * @author Mariusz Smykula
 */
final class SimpleHexadecimalToString {

  /**
   * Returns the simplified for use in arrays hexadecimal {@code toString} representation of the given object. It may or
   * not the object's own implementation of {@code toString}.
   * 
   * @param presentation
   * @param o the given object.
   * @return the {@code toString} representation of the given object.
   */
  public static String toStringOf(Presentation presentation, Object o) {
    if (o instanceof Byte) {
      return toStringOf((Byte) o);
    }
    if (o instanceof Short) {
      return toStringOf((Short) o);
    }
    if (o instanceof Integer) {
      return toStringOf((Integer) o);
    }
    if (o instanceof Float) {
      return toStringOf((Float) o);
    }
    if (o instanceof Long) {
      return toStringOf((Long) o);
    }
    if (o instanceof String) {
      return toStringOf((String) o, presentation);
    }
    if (o instanceof Character) {
      return toStringOf((Character) o);
    }
    if (o instanceof Comparator) {
      return toStringOf((Comparator<?>) o);
    }
    if (o instanceof SimpleDateFormat) {
      return toStringOf((SimpleDateFormat) o);
    }
    return o == null ? null : ToString.toStringOf(presentation, o);
  }

  private static String toStringOf(Comparator<?> comparator) {
    String comparatorSimpleClassName = comparator.getClass().getSimpleName();
    return quote(!comparatorSimpleClassName.isEmpty() ? comparatorSimpleClassName : "Anonymous Comparator class");
  }

  private static String toStringOf(Float f) {
    return String.format("%sf", f);
  }

  private static String toStringOf(Long l) {
    return Long.toHexString(Double.doubleToRawLongBits(l)).toUpperCase();
  }

  private static String toStringOf(String s, Presentation p) {
    return concat("\"", toStringOf(p, s.toCharArray()), "\"");
  }

  private static String toStringOf(SimpleDateFormat dateFormat) {
    return dateFormat.toPattern();
  }

  private static String toStringOf(Byte b) {
    return Hexadecimals.byteToHexString(b);
  }

  private static String toStringOf(Short s) {
    return String.format("%04X", s);
  }

  private static String toStringOf(Integer i) {
    return String.format("%08x", i).toUpperCase();
  }

  private static String toStringOf(Character character) {
    return concat("'", String.format("%04X", (int) character), "'");
  }

  private SimpleHexadecimalToString() {
  }
}
