/*
 * Created on Jun 12, 2012
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 * 
 * Copyright @2010-2012 the original author or authors.
 */
package org.assertj.core.error;

import static junit.framework.Assert.assertEquals;
import static org.assertj.core.error.ShouldNotBeOfClassIn.shouldNotBeOfClassIn;
import static org.assertj.core.util.Lists.newArrayList;


import org.assertj.core.internal.TestDescription;
import org.assertj.core.presentation.StandardPresentation;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for <code>{@link ShouldNotBeOfClassIn#create(org.assertj.core.description.Description, org.assertj.core.presentation.Presentation)}</code>.
 * 
 * @author Nicolas François
 */
public class ShouldNotBeOfClassIn_Test {

  private ErrorMessageFactory factory;

  @SuppressWarnings("unchecked")
  @Before
  public void setUp() {
    factory = shouldNotBeOfClassIn("Yoda", newArrayList(Long.class, String.class));
  }

  @Test
  public void should_create_error_message() {
    String message = factory.create(new TestDescription("Test"), new StandardPresentation());
    assertEquals(
        "[Test] \nExpecting:\n <\"Yoda\">\nnot to be of any type in:\n <[java.lang.Long, java.lang.String]>\nbut was of type:<java.lang.String>",
        message);
  }
}
