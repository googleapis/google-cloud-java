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
import io.opentelemetry.api.OpenTelemetry;
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
  public void testCreateOpenTelemetry_returnsNull() {
    OpenTelemetry otel =
        BuiltInDatastoreMetricsProvider.INSTANCE.createOpenTelemetry(
            PROJECT_ID, "test-db", NoCredentials.getInstance());
    assertThat(otel).isNull();
  }

  @Test
  public void testCreateOpenTelemetry_returnsNonNull() {
    Credentials credentials = EasyMock.mock(Credentials.class);
    EasyMock.expect(credentials.getMetricsCredentialType())
        .andReturn(CredentialTypeForMetrics.DO_NOT_SEND);
    EasyMock.replay(credentials);
    OpenTelemetry otel =
        BuiltInDatastoreMetricsProvider.INSTANCE.createOpenTelemetry(
            PROJECT_ID, "test-db", credentials);
    assertThat(otel).isNotNull();
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
    OpenTelemetry otel1 =
        BuiltInDatastoreMetricsProvider.INSTANCE.createOpenTelemetry(
            PROJECT_ID, "test-db", credentials1);
    OpenTelemetry otel2 =
        BuiltInDatastoreMetricsProvider.INSTANCE.createOpenTelemetry(
            PROJECT_ID, "test-db", credentials2);
    assertThat(otel1).isNotNull();
    assertThat(otel2).isNotNull();
    assertThat(otel1).isNotSameInstanceAs(otel2);
  }
}
