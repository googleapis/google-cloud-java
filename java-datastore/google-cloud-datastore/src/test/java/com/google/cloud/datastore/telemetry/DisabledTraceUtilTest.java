/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.datastore.telemetry;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class DisabledTraceUtilTest {
  @Test
  void disabledTraceUtilDoesNotProvideChannelConfigurator() {
    DisabledTraceUtil traceUtil = new DisabledTraceUtil();
    assertThat(traceUtil.getChannelConfigurator()).isNull();
  }

  @Test
  void usesDisabledContext() {
    DisabledTraceUtil traceUtil = new DisabledTraceUtil();
    assertThat(traceUtil.getCurrentContext() instanceof DisabledTraceUtil.Context).isTrue();
  }

  @Test
  void usesDisabledSpan() {
    DisabledTraceUtil traceUtil = new DisabledTraceUtil();
    assertThat(traceUtil.getCurrentSpan() instanceof DisabledTraceUtil.Span).isTrue();
    assertThat(traceUtil.startSpan("foo") instanceof DisabledTraceUtil.Span).isTrue();
    assertThat(
            traceUtil.startSpan("foo", traceUtil.getCurrentSpan())
                instanceof DisabledTraceUtil.Span)
        .isTrue();
  }

  @Test
  void usesDisabledScope() {
    DisabledTraceUtil traceUtil = new DisabledTraceUtil();
    assertThat(traceUtil.getCurrentContext().makeCurrent() instanceof DisabledTraceUtil.Scope)
        .isTrue();
    assertThat(traceUtil.getCurrentSpan().makeCurrent() instanceof DisabledTraceUtil.Scope)
        .isTrue();
  }
}
