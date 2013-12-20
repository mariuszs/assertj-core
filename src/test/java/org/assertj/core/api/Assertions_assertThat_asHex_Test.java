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
public class Assertions_assertThat_asHex_Test {

  @Rule
  public ExpectedException thrown = none();

  @Test
  public void should_assert_byte_as_hex() {
    thrown.expectMessage("expected:<0x0[3]> but was:<0x0[2]>");
    assertThat((byte) 2).asHex().isEqualTo((byte) 3);
  }

  @Test
  public void should_assert_bytes_as_hex() {
    thrown.expectMessage("expected:<[0[1]]> but was:<[0[2:03]]>");
    assertThat(new byte[] { 2, 3 }).asHex().isEqualTo(new byte[] { 1 });
  }

  @Test
  public void should_assert_short_as_hex() {
    thrown.expectMessage("expected:<0x000[3]> but was:<0x000[2]>");
    assertThat((short) 2).asHex().isEqualTo((short) 3);
  }

  @Test
  public void should_assert_integer_as_hex() {
    thrown.expectMessage("expected:<0x0000000[3]> but was:<0x0000000[2]>");
    assertThat(2).asHex().isEqualTo(3);
  }

  @Test
  public void should_assert_long_as_hex() {
    thrown.expectMessage("expected:<[C]3E0000000000000> but was:<[4]3E0000000000000>");
    assertThat(Long.MAX_VALUE).asHex().isEqualTo(Long.MIN_VALUE);
  }

  @Test
  public void should_assert_String_as_hex() {
    thrown.expectMessage("expected:<\"['0061', '00[62]', '0063']\"> but was:<\"['0061', '00[36]', '0063']\">");
    assertThat("a6c").asHex().isEqualTo("abc");
  }
}
