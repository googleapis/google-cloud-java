/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.logging;

import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class InvalidContextTest {
  @Parameters
  public static List<String> data() {
    final String[] INVALID_W3C_TRACE_CONTEXTS = {
      "",
      "abc/efg",
      "01-something",
      "00-123456789012345678901234567890",
      "00-12345678901234567890123456789012",
      "00-12345678901234567890123456789012345",
      "00-12345678901234567890123456789012-123456789012345",
      "00-12345678901234567890123456789012-1234567890123456",
      "00-12345678901234567890123456789012-12345678901234567",
      "00-12345678901234567890123456789012-1234567890123456-1",
      "00-12345678901234567890123456789012-1234567890123456-123"
    };
    return Arrays.asList(INVALID_W3C_TRACE_CONTEXTS);
  }

  private final String traceContext;

  public InvalidContextTest(String traceContext) {
    this.traceContext = traceContext;
  }

  @Test
  public void testAssertionInvalidContext() {
    Context.Builder builder = Context.newBuilder();
    assertThrows(
        IllegalArgumentException.class, () -> builder.loadW3CTraceParentContext(traceContext));
  }
}
