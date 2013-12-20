/*
 * Created on Sep 17, 2010
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
 * Copyright @2010-2011 the original author or authors.
 */
package org.assertj.core.error;

import static junit.framework.Assert.assertEquals;
import static org.assertj.core.error.ShouldBeSorted.shouldBeSortedAccordingToGivenComparator;
import static org.assertj.core.util.Arrays.array;

import java.util.Comparator;

import org.assertj.core.internal.TestDescription;
import org.assertj.core.presentation.StandardPresentation;
import org.assertj.core.util.CaseInsensitiveStringComparator;
import org.junit.Test;

/**
 * Tests for <code>{@link ShouldBeSorted#create(org.assertj.core.description.Description, org.assertj.core.presentation.Presentation)}</code>.
 * 
 * @author Joel Costigliola
 */
public class ShouldBeSortedAccordingToComparator_create_Test {

  @Test
  public void should_create_error_message_with_comparator() {
    ErrorMessageFactory factory = shouldBeSortedAccordingToGivenComparator(1, array("b", "c", "A"),
        new CaseInsensitiveStringComparator());
    String message = factory.create(new TestDescription("Test"), new StandardPresentation());
    assertEquals(
        "[Test] \ngroup is not sorted according to 'CaseInsensitiveStringComparator' comparator because element 1:\n <\"c\">\nis not less or equal than element 2:\n <\"A\">\ngroup was:\n <[\"b\", \"c\", \"A\"]>",
        message);
  }

  @Test
  public void should_create_error_message_with_private_static_comparator() {
    ErrorMessageFactory factory = shouldBeSortedAccordingToGivenComparator(1, array("b", "c", "a"),
        new StaticStringComparator());
    String message = factory.create(new TestDescription("Test"), new StandardPresentation());
    assertEquals(
        "[Test] \ngroup is not sorted according to 'StaticStringComparator' comparator because element 1:\n <\"c\">\nis not less or equal than element 2:\n <\"a\">\ngroup was:\n <[\"b\", \"c\", \"a\"]>",
        message);
  }

  private static class StaticStringComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
      return s1.compareTo(s2);
    }
  }
}
