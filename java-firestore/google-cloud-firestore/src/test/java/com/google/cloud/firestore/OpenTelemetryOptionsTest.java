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

import com.google.cloud.firestore.telemetry.DisabledTraceUtil;
import com.google.cloud.firestore.telemetry.EnabledTraceUtil;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
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
  public void defaultOptionsDisablesTelemetryCollection() {
    FirestoreOptions firestoreOptions = getBaseOptions().build();
    firestore = firestoreOptions.getService();
    assertThat(firestore.getOptions().getOpenTelemetryOptions().isTracingEnabled()).isFalse();
    assertThat(firestore.getOptions().getOpenTelemetryOptions().getOpenTelemetry()).isNull();
    assertThat(firestore.getOptions().getTraceUtil()).isNotNull();
    assertThat(firestore.getOptions().getTraceUtil() instanceof DisabledTraceUtil).isTrue();
  }

  @Test
  public void canEnableTelemetryCollectionWithoutOpenTelemetryInstance() {
    FirestoreOptions firestoreOptions =
        getBaseOptions()
            .setOpenTelemetryOptions(
                FirestoreOpenTelemetryOptions.newBuilder().setTracingEnabled(true).build())
            .build();
    firestore = firestoreOptions.getService();
    assertThat(firestore.getOptions().getOpenTelemetryOptions().isTracingEnabled()).isTrue();
    assertThat(firestore.getOptions().getOpenTelemetryOptions().getOpenTelemetry()).isNull();
    assertThat(firestore.getOptions().getTraceUtil()).isNotNull();
    assertThat(firestore.getOptions().getTraceUtil() instanceof EnabledTraceUtil).isTrue();
  }

  @Test
  public void canEnableTelemetryCollectionWithOpenTelemetryInstance() {
    OpenTelemetry openTelemetry = GlobalOpenTelemetry.get();
    FirestoreOptions firestoreOptions =
        getBaseOptions()
            .setOpenTelemetryOptions(
                FirestoreOpenTelemetryOptions.newBuilder()
                    .setTracingEnabled(true)
                    .setOpenTelemetry(openTelemetry)
                    .build())
            .build();
    firestore = firestoreOptions.getService();
    assertThat(firestore.getOptions().getOpenTelemetryOptions().isTracingEnabled()).isTrue();
    assertThat(firestore.getOptions().getOpenTelemetryOptions().getOpenTelemetry())
        .isEqualTo(openTelemetry);
    assertThat(firestore.getOptions().getTraceUtil()).isNotNull();
    assertThat(firestore.getOptions().getTraceUtil() instanceof EnabledTraceUtil).isTrue();
  }

  @Test
  public void canDisableTelemetryCollectionWhileOpenTelemetryInstanceIsNotNull() {
    OpenTelemetry openTelemetry = GlobalOpenTelemetry.get();
    FirestoreOptions firestoreOptions =
        getBaseOptions()
            .setOpenTelemetryOptions(
                FirestoreOpenTelemetryOptions.newBuilder()
                    .setTracingEnabled(false)
                    .setOpenTelemetry(openTelemetry)
                    .build())
            .build();
    firestore = firestoreOptions.getService();
    assertThat(firestore.getOptions().getOpenTelemetryOptions().isTracingEnabled()).isFalse();
    assertThat(firestore.getOptions().getOpenTelemetryOptions().getOpenTelemetry())
        .isEqualTo(openTelemetry);
    assertThat(firestore.getOptions().getTraceUtil()).isNotNull();
    assertThat(firestore.getOptions().getTraceUtil() instanceof DisabledTraceUtil).isTrue();
  }

  @Test
  public void existenceOfGlobalOpenTelemetryDoesNotEnableTracing() {
    // Register a global OpenTelemetry SDK.
    OpenTelemetrySdk.builder().buildAndRegisterGlobal();

    // Make sure Firestore does not use GlobalOpenTelemetry by default.
    FirestoreOptions firestoreOptions = getBaseOptions().build();
    firestore = firestoreOptions.getService();
    assertThat(firestore.getOptions().getOpenTelemetryOptions().isTracingEnabled()).isFalse();
    assertThat(firestore.getOptions().getOpenTelemetryOptions().getOpenTelemetry()).isNull();
    assertThat(firestore.getOptions().getTraceUtil()).isNotNull();
    assertThat(firestore.getOptions().getTraceUtil() instanceof DisabledTraceUtil).isTrue();
  }

  @Test
  public void canPassOpenTelemetrySdkInstanceToFirestore() {
    OpenTelemetrySdk myOpenTelemetrySdk = OpenTelemetrySdk.builder().build();
    FirestoreOptions firestoreOptions =
        getBaseOptions()
            .setOpenTelemetryOptions(
                FirestoreOpenTelemetryOptions.newBuilder()
                    .setTracingEnabled(true)
                    .setOpenTelemetry(myOpenTelemetrySdk)
                    .build())
            .build();
    firestore = firestoreOptions.getService();
    EnabledTraceUtil enabledTraceUtil = (EnabledTraceUtil) firestore.getOptions().getTraceUtil();
    assertThat(enabledTraceUtil).isNotNull();
    assertThat(enabledTraceUtil.getOpenTelemetry()).isEqualTo(myOpenTelemetrySdk);
  }

  @Test
  public void usesGlobalOpenTelemetryIfOpenTelemetryNotProvidedInOptions() {
    // Register a global OpenTelemetry SDK.
    OpenTelemetrySdk.builder().buildAndRegisterGlobal();

    // Do _not_ pass it to FirestoreOptions.
    FirestoreOptions firestoreOptions =
        getBaseOptions()
            .setOpenTelemetryOptions(
                FirestoreOpenTelemetryOptions.newBuilder().setTracingEnabled(true).build())
            .build();
    firestore = firestoreOptions.getService();
    EnabledTraceUtil enabledTraceUtil = (EnabledTraceUtil) firestore.getOptions().getTraceUtil();
    assertThat(enabledTraceUtil).isNotNull();
    assertThat(enabledTraceUtil.getOpenTelemetry()).isEqualTo(GlobalOpenTelemetry.get());
  }
}
