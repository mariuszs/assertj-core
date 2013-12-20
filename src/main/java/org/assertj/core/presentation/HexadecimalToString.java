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

/**
 * Obtains the hexadecimal {@code toString} representation of an object.
 *
 * @author Mariusz Smykula
 */
final class HexadecimalToString {

  /**
   * Returns the hexadecimal {@code toString} representation of the given object. It may or not the object's own
   * implementation of {@code toString}.
   * 
   * @param o the given object.
   * @param p
   * @return the {@code toString} representation of the given object.
   */
  public static String toStringOf(Presentation p, Object o) {

    if (o instanceof Byte) {
      return toStringOf((Byte) o, p);
    }
    if (o instanceof Short) {
      return toStringOf((Short) o, p);
    }
    if (o instanceof Integer) {
      return toStringOf((Integer) o, p);
    }
    return o == null ? null : SimpleHexadecimalToString.toStringOf(p, o);
  }

  private static String toStringOf(Byte b, Presentation p) {
    return "0x" + SimpleHexadecimalToString.toStringOf(p, b);
  }

  private static String toStringOf(Short s, Presentation p) {
    return "0x" + SimpleHexadecimalToString.toStringOf(p, s);
  }

  private static String toStringOf(Integer s, Presentation p) {
    return "0x" + SimpleHexadecimalToString.toStringOf(p, s);
  }

  private HexadecimalToString() {
  }
}
