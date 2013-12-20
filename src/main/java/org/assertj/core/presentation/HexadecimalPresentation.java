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

import org.assertj.core.util.ElementSeparator;

/**
 * @author Mariusz Smykula
 */
public class HexadecimalPresentation extends Presentation {

  @Override
  public String toStringOf(Object e) {
    return HexadecimalToString.toStringOf(this, e);
  }

  @Override
  public String arrayElementToStringOf(Object e) {
    return SimpleHexadecimalToString.toStringOf(this, e);
  }

  @Override
  public String elementSeparator(Object e) {
    return ElementSeparator.separatorFor(e);
  }

}
