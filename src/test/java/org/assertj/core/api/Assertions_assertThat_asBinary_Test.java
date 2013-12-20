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
package org.assertj.core.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.test.ExpectedException.none;

import org.assertj.core.test.ExpectedException;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Mariusz Smykula
 */
public class Assertions_assertThat_asBinary_Test {

  @Rule
  public ExpectedException thrown = none();

  @Test
  public void should_assert_byte_as_binary() {
    thrown.expectMessage("expected:<0b10000001[1]> but was:<0b10000001[0]>");
    assertThat((byte) 2).asBinary().isEqualTo((byte) 3);
  }

  @Test
  public void should_assert_bytes_as_binary() {
    thrown.expectMessage("expected:<[0b1000000[0]1]> but was:<[0b1000000[10, 0b10000001]1]>");
    assertThat(new byte[] { 2, 3 }).asBinary().isEqualTo(new byte[] { 1 });
  }

  @Test
  public void should_assert_short_as_binary() {
    thrown.expectMessage("expected:<0b1000000000000001[1]> but was:<0b1000000000000001[0]>");
    assertThat((short) 2).asBinary().isEqualTo((short) 3);
  }

  @Test
  public void should_assert_integer_as_binary() {
    thrown.expectMessage("expected:<...00000000000000000001[1]> but was:<...00000000000000000001[0]>");
    assertThat(2).asBinary().isEqualTo(3);
  }

  @Test
  public void should_assert_long_as_binary() {
    thrown.expectMessage("expected:<0b10000000000[1]00000000000000000000...>"
        + " but was:<0b10000000000[0]00000000000000000000...>");
    assertThat((long) 2).asBinary().isEqualTo((long) 3);
  }

  @Test
  public void should_assert_String_as_binary() {
    thrown.expectMessage("expected:<\"[0b101100001, 0b10[01101]10, 0b101100011]\"");
    assertThat("abc").asBinary().isEqualTo("a6c");
  }
}
