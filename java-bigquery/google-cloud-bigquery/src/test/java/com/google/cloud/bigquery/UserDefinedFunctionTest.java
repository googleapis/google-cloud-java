/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserDefinedFunctionTest {

  private static final String INLINE = "inline";
  private static final String URI = "uri";
  private static final UserDefinedFunction INLINE_FUNCTION =
      new UserDefinedFunction.InlineFunction(INLINE);
  private static final UserDefinedFunction URI_FUNCTION = new UserDefinedFunction.UriFunction(URI);

  @Test
  public void testConstructor() {
    assertEquals(INLINE, INLINE_FUNCTION.getContent());
    assertEquals(UserDefinedFunction.Type.INLINE, INLINE_FUNCTION.getType());
    assertEquals(URI, URI_FUNCTION.getContent());
    assertEquals(UserDefinedFunction.Type.FROM_URI, URI_FUNCTION.getType());
  }

  @Test
  public void testFactoryMethod() {
    compareUserDefinedFunction(INLINE_FUNCTION, UserDefinedFunction.inline(INLINE));
    compareUserDefinedFunction(URI_FUNCTION, UserDefinedFunction.fromUri(URI));
  }

  @Test
  public void testToAndFromPb() {
    compareUserDefinedFunction(INLINE_FUNCTION, UserDefinedFunction.fromPb(INLINE_FUNCTION.toPb()));
    compareUserDefinedFunction(URI_FUNCTION, UserDefinedFunction.fromPb(URI_FUNCTION.toPb()));
  }

  private void compareUserDefinedFunction(UserDefinedFunction expected, UserDefinedFunction value) {
    assertEquals(expected, value);
    assertEquals(expected.getType(), value.getType());
    assertEquals(expected.getContent(), value.getContent());
  }
}
