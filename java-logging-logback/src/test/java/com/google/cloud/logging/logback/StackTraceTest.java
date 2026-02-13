/*
 * Copyright 2018 Google LLC
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

package com.google.cloud.logging.logback;

import static com.google.common.truth.Truth.assertThat;

import ch.qos.logback.classic.spi.ThrowableProxy;
import org.junit.Test;

public class StackTraceTest {
  @Test
  public void testStack() {
    Exception ex = new UnsupportedOperationException("foo");
    ex = new IllegalStateException("bar", ex);

    StringBuilder stackBuilder = new StringBuilder();
    LoggingAppender.writeStack(new ThrowableProxy(ex), "", stackBuilder);
    String stack = stackBuilder.toString();

    assertThat(stack).contains("java.lang.IllegalStateException: bar");
    assertThat(stack).contains("caused by: java.lang.UnsupportedOperationException: foo");
    assertThat(stack).contains("common frames elided");
  }
}
