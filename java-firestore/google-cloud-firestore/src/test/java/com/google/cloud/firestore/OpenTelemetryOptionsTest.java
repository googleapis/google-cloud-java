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

package com.google.cloud.firestore;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.firestore.telemetry.EnabledTraceUtil;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.TracerProvider;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import javax.annotation.Nullable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OpenTelemetryOptionsTest {
  @Nullable private Firestore firestore;

  @Before
  public void setUp() {
    GlobalOpenTelemetry.resetForTest();
  }

  @After
  public void tearDown() {
    if (firestore != null) {
      firestore.shutdown();
      firestore = null;
    }
  }

  FirestoreOptions.Builder getBaseOptions() {
    return FirestoreOptions.newBuilder().setProjectId("test-project").setDatabaseId("(default)");
  }

  @Test
  public void defaultOptionsUsesEnabledTraceUtilWithNoopOpenTelemetry() {
    FirestoreOptions firestoreOptions = getBaseOptions().build();
    firestore = firestoreOptions.getService();
    assertThat(firestore.getOptions().getOpenTelemetryOptions().getOpenTelemetry()).isNull();
    assertThat(firestore.getOptions().getTraceUtil()).isNotNull();
    assertThat(firestore.getOptions().getTraceUtil() instanceof EnabledTraceUtil).isTrue();
    EnabledTraceUtil enabledTraceUtil = (EnabledTraceUtil) firestore.getOptions().getTraceUtil();
    // Assert that a Noop tracer provider is used by default.
    assertThat(enabledTraceUtil.getOpenTelemetry().getTracerProvider())
        .isSameInstanceAs(TracerProvider.noop());
  }

  @Test
  public void existenceOfGlobalOpenTelemetryEnablesTracingWithTheGlobalTracerProvider() {
    // Make a custom TracerProvider.
    Resource resource =
        Resource.getDefault().merge(Resource.builder().put("service.name", "test").build());
    SdkTracerProvider myTracerProvider = SdkTracerProvider.builder().setResource(resource).build();

    // Register a GlobalOpenTelemetry with the custom tracer provider.
    OpenTelemetrySdk.builder().setTracerProvider(myTracerProvider).buildAndRegisterGlobal();

    // Do NOT pass an OpenTelemetry instance to Firestore.
    FirestoreOptions firestoreOptions = getBaseOptions().build();
    firestore = firestoreOptions.getService();

    // An OpenTelemetry instance has not been set in options.
    assertThat(firestore.getOptions().getOpenTelemetryOptions().getOpenTelemetry()).isNull();

    // Assert that tracing is enabled and is using the custom tracer provider from the
    // GlobalOpenTelemetry.
    assertThat(firestore.getOptions().getTraceUtil()).isNotNull();
    assertThat(firestore.getOptions().getTraceUtil() instanceof EnabledTraceUtil).isTrue();
    EnabledTraceUtil enabledTraceUtil = (EnabledTraceUtil) firestore.getOptions().getTraceUtil();
    assertThat(enabledTraceUtil.getOpenTelemetry().getTracerProvider().equals(myTracerProvider));
  }

  @Test
  public void canPassOpenTelemetrySdkInstanceToFirestore() {
    // Make a custom TracerProvider and make an OpenTelemetry instance with it.
    Resource resource =
        Resource.getDefault().merge(Resource.builder().put("service.name", "test").build());
    SdkTracerProvider myTracerProvider = SdkTracerProvider.builder().setResource(resource).build();
    OpenTelemetrySdk myOpenTelemetrySdk =
        OpenTelemetrySdk.builder().setTracerProvider(myTracerProvider).build();

    // Pass it to Firestore.
    FirestoreOptions firestoreOptions =
        getBaseOptions()
            .setOpenTelemetryOptions(
                FirestoreOpenTelemetryOptions.newBuilder()
                    .setOpenTelemetry(myOpenTelemetrySdk)
                    .build())
            .build();
    firestore = firestoreOptions.getService();
    assertThat(firestore.getOptions().getOpenTelemetryOptions().getOpenTelemetry())
        .isEqualTo(myOpenTelemetrySdk);
    assertThat(firestore.getOptions().getTraceUtil() instanceof EnabledTraceUtil).isTrue();
    EnabledTraceUtil enabledTraceUtil = (EnabledTraceUtil) firestore.getOptions().getTraceUtil();
    assertThat(enabledTraceUtil).isNotNull();
    assertThat(enabledTraceUtil.getOpenTelemetry()).isEqualTo(myOpenTelemetrySdk);
    assertThat(enabledTraceUtil.getOpenTelemetry().getTracerProvider().equals(myTracerProvider));
  }
}
