/*
 * Created on Jan 15, 2011
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
 * Copyright @2011 the original author or authors.
 */
package org.assertj.core.error;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;


import org.assertj.core.description.Description;
import org.assertj.core.internal.TestDescription;
import org.assertj.core.presentation.Presentation;
import org.assertj.core.presentation.StandardPresentation;
import org.junit.*;

/**
 * Tests for <code>{@link BasicErrorMessageFactory#create(Description, org.assertj.core.presentation.Presentation)}</code>.
 * 
 * @author Yvonne Wang
 */
public class BasicErrorMessageFactory_create_Test {

  private MessageFormatter formatter;
  private BasicErrorMessageFactory factory;

  @Before
  public void setUp() {
    formatter = mock(MessageFormatter.class);
    factory = new BasicErrorMessageFactory("Hello %s", "Yoda");
    factory.formatter = formatter;
  }

  @Test
  public void should_implement_toString() {
    Description description = new TestDescription("Test");
    Presentation presentation = new StandardPresentation();
    String formattedMessage = "[Test] Hello Yoda";
    when(formatter.format(description, presentation, "Hello %s", "Yoda")).thenReturn(formattedMessage);
    assertEquals(formattedMessage, factory.create(description, presentation));
  }
}
