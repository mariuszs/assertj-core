/*
 * Created on Oct 7, 2009
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

import org.assertj.core.util.*;

import static org.assertj.core.util.Arrays.isArray;
import static org.assertj.core.util.Strings.concat;
import static org.assertj.core.util.Strings.quote;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Obtains the {@code toString} representation of an object.
 *
 * @author Alex Ruiz
 * @author Joel Costigliola
 * @author Yvonne Wang
 * @author Mariusz Smykula
 */
final class ToString {

  /**
   * Returns the {@code toString} representation of the given object. It may or not the object's own implementation of
   * {@code toString}.
   *
   * @param o the given object.
   * @return the {@code toString} representation of the given object.
   */
  public static String toStringOf(Presentation p, Object o) {
    if (isArray(o)) {
      return org.assertj.core.util.Arrays.format(p, o);
    }
    if (o instanceof Calendar) {
      return toStringOf((Calendar) o);
    }
    if (o instanceof Class<?>) {
      return toStringOf((Class<?>) o);
    }
    if (o instanceof Collection<?>) {
      return toStringOf((Collection<?>) o, p);
    }
    if (o instanceof Date) {
      return toStringOf((Date) o);
    }
    if (o instanceof Float) {
      return toStringOf((Float) o);
    }
    if (o instanceof Long) {
      return toStringOf((Long) o);
    }
    if (o instanceof File) {
      return toStringOf((File) o);
    }
    if (o instanceof Map<?, ?>) {
      return toStringOf((Map<?, ?>) o, p);
    }
    if (o instanceof String) {
      return toStringOf((String) o);
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
    return o == null ? null : o.toString();
  }

  private static String toStringOf(Comparator<?> comparator) {
    String comparatorSimpleClassName = comparator.getClass().getSimpleName();
    return quote(!comparatorSimpleClassName.isEmpty() ? comparatorSimpleClassName : "Anonymous Comparator class");
  }

  private static String toStringOf(Calendar c) {
    return Dates.formatAsDatetime(c);
  }

  private static String toStringOf(Class<?> c) {
    return c.getCanonicalName();
  }

  private static String toStringOf(String s) {
    return concat("\"", s, "\"");
  }

  private static String toStringOf(Character c) {
    return concat("'", c, "'");
  }

  private static String toStringOf(Collection<?> c, Presentation p) {
    return org.assertj.core.util.Collections.format(p, c);
  }

  private static String toStringOf(Date d) {
    return Dates.formatAsDatetime(d);
  }

  private static String toStringOf(Float f) {
    return String.format("%sf", f);
  }

  private static String toStringOf(Long l) {
    return String.format("%sL", l);
  }

  private static String toStringOf(File f) {
    return f.getAbsolutePath();
  }

  private static String toStringOf(Map<?, ?> m, Presentation p) {
    return Maps.format(p, m);
  }

  private static String toStringOf(SimpleDateFormat dateFormat) {
    return dateFormat.toPattern();
  }

  private ToString() {}
}
