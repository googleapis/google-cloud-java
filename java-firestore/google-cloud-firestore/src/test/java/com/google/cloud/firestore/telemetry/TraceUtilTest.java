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
package com.google.cloud.firestore.telemetry;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.firestore.FirestoreOpenTelemetryOptions;
import com.google.cloud.firestore.FirestoreOptions;
import org.junit.Test;

public class TraceUtilTest {
  @Test
  public void defaultOptionsUseDisabledTraceUtil() {
    TraceUtil traceUtil =
        TraceUtil.getInstance(
            FirestoreOptions.newBuilder()
                .setProjectId("test-project")
                .setDatabaseId("(default)")
                .build());
    assertThat(traceUtil instanceof DisabledTraceUtil).isTrue();
  }

  @Test
  public void tracingDisabledOptionsUseDisabledTraceUtil() {
    TraceUtil traceUtil =
        TraceUtil.getInstance(
            FirestoreOptions.newBuilder()
                .setProjectId("test-project")
                .setDatabaseId("(default)")
                .setOpenTelemetryOptions(
                    FirestoreOpenTelemetryOptions.newBuilder().setTracingEnabled(false).build())
                .build());
    assertThat(traceUtil instanceof DisabledTraceUtil).isTrue();
  }

  @Test
  public void tracingEnabledOptionsUseEnabledTraceUtil() {
    TraceUtil traceUtil =
        TraceUtil.getInstance(
            FirestoreOptions.newBuilder()
                .setProjectId("test-project")
                .setDatabaseId("(default)")
                .setOpenTelemetryOptions(
                    FirestoreOpenTelemetryOptions.newBuilder().setTracingEnabled(true).build())
                .build());
    assertThat(traceUtil instanceof EnabledTraceUtil).isTrue();
  }
}
