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
 * Copyright @2009-2013 the original author or authors.
 */
package org.assertj.core.presentation;

import static org.assertj.core.util.Strings.concat;

/**
 * Obtains the binary {@code toString} representation of an object .
 *
 * @author Mariusz Smykula
 */
public final class BinaryToString {

  public static final String BYTE_PREFIX = "0b";

  /**
   * Returns the binary {@code toString} representation of the given object. It may or not the object's own implementation of
   * {@code toString}.
   * 
   * 
   * @param presentation
   * @param o the given object.
   * @return the {@code toString} representation of the given object.
   */
  static String toStringOf(Presentation presentation, Object o) {
    if (o instanceof Long) {
      return toStringOf((Long) o);
    }
    if (o instanceof Integer) {
      return toStringOf((Integer) o);
    }
    if (o instanceof Short) {
      return toStringOf((Short) o);
    }
    if (o instanceof Byte) {
      return toStringOf((Byte) o);
    }
    if (o instanceof Float) {
      return toStringOf((Float) o);
    }
    if (o instanceof String) {
      return toStringOf((String) o, presentation);
    }
    return o == null ? null : ToString.toStringOf(presentation, o);
  }

  private static String toStringOf(String s, Presentation p) {
    return concat("\"", toStringOf(p, s.getBytes()), "\"");
  }

  private static String toStringOf(Integer i) {
    return BYTE_PREFIX + Long.toBinaryString(i | 0x100000000L);
  }

  private static String toStringOf(Short s) {
    return BYTE_PREFIX + Integer.toBinaryString(s | 0x10000);
  }

  private static String toStringOf(Byte b) {
    return BYTE_PREFIX + Integer.toBinaryString(0xFF & b | 0x100);
  }

  private static String toStringOf(Float f) {
    return BYTE_PREFIX + Integer.toBinaryString(Float.floatToIntBits(f));
  }

  private static String toStringOf(Long l) {
    return BYTE_PREFIX + Long.toBinaryString(Double.doubleToRawLongBits(l));
  }

  private BinaryToString() {
  }
}
