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

package com.google.cloud.datastore.telemetry;

import static com.google.common.truth.Truth.assertThat;

import com.google.auth.CredentialTypeForMetrics;
import com.google.auth.Credentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.datastore.DatastoreOptions;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import java.util.Map;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BuiltInDatastoreMetricsProviderTest {

  private static final String PROJECT_ID = "project-id";

  @Test
  public void testBuildClientAttributes() {
    Map<String, String> attributes = BuiltInDatastoreMetricsProvider.buildClientAttributes();
    assertThat(attributes).containsKey(TelemetryConstants.CLIENT_UID_KEY.getKey());
    assertThat(attributes.get(TelemetryConstants.CLIENT_UID_KEY.getKey())).isNotEmpty();
    assertThat(attributes).containsKey(TelemetryConstants.SERVICE_KEY.getKey());
    assertThat(attributes.get(TelemetryConstants.SERVICE_KEY.getKey()))
        .isEqualTo(TelemetryConstants.SERVICE_VALUE);
  }

  @Test
  public void testCreateOpenTelemetry_returnsNoOp() {
    DatastoreOptions options =
        DatastoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setDatabaseId("test-db")
            .setCredentials(NoCredentials.getInstance())
            .build();
    OpenTelemetry otel = BuiltInDatastoreMetricsProvider.INSTANCE.createOpenTelemetry(options);
    assertThat(otel).isInstanceOf(OpenTelemetry.noop().getClass());
  }

  @Test
  public void testCreateOpenTelemetry_returnsNonNull() {
    Credentials credentials = EasyMock.mock(Credentials.class);
    EasyMock.expect(credentials.getMetricsCredentialType())
        .andReturn(CredentialTypeForMetrics.DO_NOT_SEND);
    EasyMock.replay(credentials);

    DatastoreOptions options =
        DatastoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setDatabaseId("test-db")
            .setCredentials(credentials)
            .build();

    OpenTelemetry otel = BuiltInDatastoreMetricsProvider.INSTANCE.createOpenTelemetry(options);
    try {
      assertThat(otel).isNotNull();
    } finally {
      if (otel instanceof OpenTelemetrySdk) {
        ((OpenTelemetrySdk) otel).close();
      }
    }
  }

  @Test
  public void testCreateOpenTelemetry_eachCallReturnsDistinctInstance() {
    Credentials credentials1 = EasyMock.mock(Credentials.class);
    EasyMock.expect(credentials1.getMetricsCredentialType())
        .andReturn(CredentialTypeForMetrics.DO_NOT_SEND);
    Credentials credentials2 = EasyMock.mock(Credentials.class);
    EasyMock.expect(credentials2.getMetricsCredentialType())
        .andReturn(CredentialTypeForMetrics.DO_NOT_SEND);
    EasyMock.replay(credentials1, credentials2);

    DatastoreOptions options1 =
        DatastoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setDatabaseId("test-db")
            .setCredentials(credentials1)
            .build();

    DatastoreOptions options2 =
        DatastoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setDatabaseId("test-db")
            .setCredentials(credentials2)
            .build();

    OpenTelemetry otel1 = BuiltInDatastoreMetricsProvider.INSTANCE.createOpenTelemetry(options1);
    OpenTelemetry otel2 = BuiltInDatastoreMetricsProvider.INSTANCE.createOpenTelemetry(options2);
    try {
      assertThat(otel1).isNotNull();
      assertThat(otel2).isNotNull();
      assertThat(otel1).isNotSameInstanceAs(otel2);
    } finally {
      if (otel1 instanceof OpenTelemetrySdk) {
        ((OpenTelemetrySdk) otel1).close();
      }
      if (otel2 instanceof OpenTelemetrySdk) {
        ((OpenTelemetrySdk) otel2).close();
      }
    }
  }

  @Test
  public void testCreateOpenTelemetry_withEmulatorHostProperty_returnsNoOp() {
    System.setProperty(DatastoreOptions.LOCAL_HOST_ENV_VAR, "localhost:8081");
    try {
      DatastoreOptions options =
          DatastoreOptions.newBuilder()
              .setProjectId(PROJECT_ID)
              .setDatabaseId("test-db")
              .setCredentials(NoCredentials.getInstance())
              .build();
      OpenTelemetry otel = BuiltInDatastoreMetricsProvider.INSTANCE.createOpenTelemetry(options);
      assertThat(otel).isInstanceOf(OpenTelemetry.noop().getClass());
    } finally {
      System.clearProperty(DatastoreOptions.LOCAL_HOST_ENV_VAR);
    }
  }
}
