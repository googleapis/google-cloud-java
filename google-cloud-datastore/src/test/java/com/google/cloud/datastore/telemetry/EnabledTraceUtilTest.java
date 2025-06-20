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

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.NoCredentials;
import com.google.cloud.datastore.DatastoreOpenTelemetryOptions;
import com.google.cloud.datastore.DatastoreOptions;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import org.junit.Before;
import org.junit.Test;

public class EnabledTraceUtilTest {
  @Before
  public void setUp() {
    GlobalOpenTelemetry.resetForTest();
  }

  DatastoreOptions.Builder getBaseOptions() {
    return DatastoreOptions.newBuilder()
        .setProjectId("test-project")
        .setCredentials(NoCredentials.getInstance());
  }

  DatastoreOptions getTracingEnabledOptions() {
    return getBaseOptions()
        .setOpenTelemetryOptions(
            DatastoreOpenTelemetryOptions.newBuilder().setTracingEnabled(true).build())
        .build();
  }

  EnabledTraceUtil newEnabledTraceUtil() {
    return new EnabledTraceUtil(getTracingEnabledOptions());
  }

  @Test
  public void usesOpenTelemetryFromOptions() {
    OpenTelemetrySdk myOpenTelemetrySdk = OpenTelemetrySdk.builder().build();
    DatastoreOptions firestoreOptions =
        getBaseOptions()
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder()
                    .setTracingEnabled(true)
                    .setOpenTelemetry(myOpenTelemetrySdk)
                    .build())
            .build();
    EnabledTraceUtil traceUtil = new EnabledTraceUtil(firestoreOptions);
    assertThat(traceUtil.getOpenTelemetry()).isEqualTo(myOpenTelemetrySdk);
  }

  @Test
  public void usesGlobalOpenTelemetryIfOpenTelemetryInstanceNotProvided() {
    OpenTelemetrySdk ignored = OpenTelemetrySdk.builder().buildAndRegisterGlobal();
    DatastoreOptions datastoreOptions =
        getBaseOptions()
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder().setTracingEnabled(true).build())
            .build();
    EnabledTraceUtil traceUtil = new EnabledTraceUtil(datastoreOptions);
    assertThat(traceUtil.getOpenTelemetry()).isEqualTo(GlobalOpenTelemetry.get());
  }

  @Test
  public void enabledTraceUtilProvidesChannelConfigurator() {
    assertThat(newEnabledTraceUtil().getChannelConfigurator()).isNull();
  }

  @Test
  public void openTelemetryInstanceRegistersGrpcChannelConfigurator() {
    OpenTelemetrySdk myOpenTelemetrySdk = OpenTelemetrySdk.builder().build();
    DatastoreOptions firestoreOptions =
        getBaseOptions()
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder()
                    .setTracingEnabled(true)
                    .setOpenTelemetry(myOpenTelemetrySdk)
                    .build())
            .build();
    EnabledTraceUtil traceUtil = new EnabledTraceUtil(firestoreOptions);
    assertThat(traceUtil.getChannelConfigurator()).isNotNull();
  }

  @Test
  public void globalOpenTelemetryRegistersGrpcChannelConfigurator() {

    OpenTelemetrySdk.builder().buildAndRegisterGlobal();
    DatastoreOptions datastoreOptions =
        getBaseOptions()
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder().setTracingEnabled(true).build())
            .build();
    EnabledTraceUtil traceUtil = new EnabledTraceUtil(datastoreOptions);
    assertThat(traceUtil.getChannelConfigurator()).isNotNull();
  }

  @Test
  public void usesEnabledContext() {
    assertThat(newEnabledTraceUtil().getCurrentContext() instanceof EnabledTraceUtil.Context)
        .isTrue();
  }

  @Test
  public void usesEnabledSpan() {
    EnabledTraceUtil traceUtil = newEnabledTraceUtil();
    assertThat(traceUtil.getCurrentSpan() instanceof EnabledTraceUtil.Span).isTrue();
    assertThat(traceUtil.startSpan("foo") != null).isTrue();
    assertThat(
            traceUtil.startSpan("foo", traceUtil.getCurrentSpan()) instanceof EnabledTraceUtil.Span)
        .isTrue();
  }

  @Test
  public void usesEnabledScope() {
    EnabledTraceUtil traceUtil = newEnabledTraceUtil();
    assertThat(traceUtil.getCurrentContext().makeCurrent() instanceof EnabledTraceUtil.Scope)
        .isTrue();
    assertThat(traceUtil.getCurrentSpan().makeCurrent() instanceof EnabledTraceUtil.Scope).isTrue();
  }
}
