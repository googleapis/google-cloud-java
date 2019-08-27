/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.TransportOptions;
import com.google.cloud.spanner.admin.database.v1.stub.DatabaseAdminStubSettings;
import com.google.cloud.spanner.admin.instance.v1.stub.InstanceAdminStubSettings;
import com.google.cloud.spanner.v1.stub.SpannerStubSettings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.threeten.bp.Duration;

/** Unit tests for {@link com.google.cloud.spanner.SpannerOptions}. */
@RunWith(JUnit4.class)
public class SpannerOptionsTest {

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Test
  public void defaultBuilder() {
    // We need to set the project id since in test environment we cannot obtain a default project
    // id.
    SpannerOptions options = SpannerOptions.newBuilder().setProjectId("test-project").build();
    assertThat(options.getHost()).isEqualTo("https://spanner.googleapis.com");
    assertThat(options.getPrefetchChunks()).isEqualTo(4);
    assertThat(options.getSessionLabels()).isNull();
  }

  @Test
  public void builder() {
    String host = "http://localhost:8000/";
    String projectId = "test-project";
    Map<String, String> labels = new HashMap<>();
    labels.put("env", "dev");
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setHost(host)
            .setProjectId(projectId)
            .setPrefetchChunks(2)
            .setSessionLabels(labels)
            .build();
    assertThat(options.getHost()).isEqualTo(host);
    assertThat(options.getProjectId()).isEqualTo(projectId);
    assertThat(options.getPrefetchChunks()).isEqualTo(2);
    assertThat(options.getSessionLabels()).containsExactlyEntriesIn(labels);
  }

  @Test
  public void testSpannerDefaultRetrySettings() {
    RetrySettings defaultRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelay(Duration.ofMillis(250L))
            .setRetryDelayMultiplier(1.3)
            .setMaxRetryDelay(Duration.ofMillis(32000L))
            .setInitialRpcTimeout(Duration.ofMillis(60000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeout(Duration.ofMillis(60000L))
            .setTotalTimeout(Duration.ofMillis(600000L))
            .build();
    RetrySettings streamingRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelay(Duration.ofMillis(250L))
            .setRetryDelayMultiplier(1.3)
            .setMaxRetryDelay(Duration.ofMillis(32000L))
            .setInitialRpcTimeout(Duration.ofMillis(120000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeout(Duration.ofMillis(120000L))
            .setTotalTimeout(Duration.ofMillis(1200000L))
            .build();
    RetrySettings longRunningRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelay(Duration.ofMillis(250L))
            .setRetryDelayMultiplier(1.3)
            .setMaxRetryDelay(Duration.ofMillis(32000L))
            .setInitialRpcTimeout(Duration.ofMillis(3600000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeout(Duration.ofMillis(3600000L))
            .setTotalTimeout(Duration.ofMillis(3600000L))
            .build();
    SpannerOptions options = SpannerOptions.newBuilder().setProjectId("test-project").build();
    SpannerStubSettings stubSettings = options.getSpannerStubSettings();
    List<? extends UnaryCallSettings<?, ?>> callsWithDefaultSettings =
        Arrays.asList(
            stubSettings.beginTransactionSettings(),
            stubSettings.createSessionSettings(),
            stubSettings.deleteSessionSettings(),
            stubSettings.executeBatchDmlSettings(),
            stubSettings.executeSqlSettings(),
            stubSettings.getSessionSettings(),
            stubSettings.listSessionsSettings(),
            stubSettings.partitionQuerySettings(),
            stubSettings.partitionReadSettings(),
            stubSettings.readSettings(),
            stubSettings.rollbackSettings());
    List<? extends ServerStreamingCallSettings<?, ?>> callsWithStreamingSettings =
        Arrays.asList(
            stubSettings.executeStreamingSqlSettings(), stubSettings.streamingReadSettings());
    List<? extends UnaryCallSettings<?, ?>> callsWithLongRunningSettings =
        Arrays.asList(stubSettings.commitSettings());

    for (UnaryCallSettings<?, ?> callSettings : callsWithDefaultSettings) {
      assertThat(callSettings.getRetrySettings()).isEqualTo(defaultRetrySettings);
    }
    for (ServerStreamingCallSettings<?, ?> callSettings : callsWithStreamingSettings) {
      assertThat(callSettings.getRetrySettings()).isEqualTo(streamingRetrySettings);
    }
    for (UnaryCallSettings<?, ?> callSettings : callsWithLongRunningSettings) {
      assertThat(callSettings.getRetrySettings()).isEqualTo(longRunningRetrySettings);
    }
  }

  @Test
  public void testSpannerCustomRetrySettings() {
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelay(Duration.ofSeconds(9999L))
            .setRetryDelayMultiplier(9999.99D)
            .setMaxRetryDelay(Duration.ofSeconds(9999L))
            .setInitialRpcTimeout(Duration.ofSeconds(9999L))
            .setRpcTimeoutMultiplier(9999.99D)
            .setMaxRpcTimeout(Duration.ofSeconds(9999L))
            .setTotalTimeout(Duration.ofSeconds(9999L))
            .build();
    SpannerOptions.Builder builder = SpannerOptions.newBuilder().setProjectId("test-project");
    SpannerStubSettings.Builder stubSettingsBuilder = builder.getSpannerStubSettingsBuilder();
    List<? extends UnaryCallSettings.Builder<?, ?>> unaryCallSettingsBuilders =
        Arrays.asList(
            stubSettingsBuilder.beginTransactionSettings(),
            stubSettingsBuilder.createSessionSettings(),
            stubSettingsBuilder.deleteSessionSettings(),
            stubSettingsBuilder.executeBatchDmlSettings(),
            stubSettingsBuilder.executeSqlSettings(),
            stubSettingsBuilder.getSessionSettings(),
            stubSettingsBuilder.listSessionsSettings(),
            stubSettingsBuilder.partitionQuerySettings(),
            stubSettingsBuilder.partitionReadSettings(),
            stubSettingsBuilder.readSettings(),
            stubSettingsBuilder.rollbackSettings(),
            stubSettingsBuilder.commitSettings());
    for (UnaryCallSettings.Builder<?, ?> callSettingsBuilder : unaryCallSettingsBuilders) {
      callSettingsBuilder.setRetrySettings(retrySettings);
    }
    List<? extends ServerStreamingCallSettings.Builder<?, ?>> streamingCallSettingsBuilders =
        Arrays.asList(
            stubSettingsBuilder.executeStreamingSqlSettings(),
            stubSettingsBuilder.streamingReadSettings());
    for (ServerStreamingCallSettings.Builder<?, ?> callSettingsBuilder :
        streamingCallSettingsBuilders) {
      callSettingsBuilder.setRetrySettings(retrySettings);
    }

    SpannerOptions options = builder.build();
    SpannerStubSettings stubSettings = options.getSpannerStubSettings();
    List<? extends UnaryCallSettings<?, ?>> callsWithDefaultSettings =
        Arrays.asList(
            stubSettings.beginTransactionSettings(),
            stubSettings.createSessionSettings(),
            stubSettings.deleteSessionSettings(),
            stubSettings.executeBatchDmlSettings(),
            stubSettings.executeSqlSettings(),
            stubSettings.getSessionSettings(),
            stubSettings.listSessionsSettings(),
            stubSettings.partitionQuerySettings(),
            stubSettings.partitionReadSettings(),
            stubSettings.readSettings(),
            stubSettings.rollbackSettings(),
            stubSettings.commitSettings());
    List<? extends ServerStreamingCallSettings<?, ?>> callsWithStreamingSettings =
        Arrays.asList(
            stubSettings.executeStreamingSqlSettings(), stubSettings.streamingReadSettings());

    for (UnaryCallSettings<?, ?> callSettings : callsWithDefaultSettings) {
      assertThat(callSettings.getRetrySettings()).isEqualTo(retrySettings);
    }
    for (ServerStreamingCallSettings<?, ?> callSettings : callsWithStreamingSettings) {
      assertThat(callSettings.getRetrySettings()).isEqualTo(retrySettings);
    }
  }

  @Test
  public void testDatabaseAdminDefaultRetrySettings() {
    RetrySettings defaultRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelay(Duration.ofMillis(1000L))
            .setRetryDelayMultiplier(1.3)
            .setMaxRetryDelay(Duration.ofMillis(32000L))
            .setInitialRpcTimeout(Duration.ofMillis(60000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeout(Duration.ofMillis(60000L))
            .setTotalTimeout(Duration.ofMillis(600000L))
            .build();
    SpannerOptions options = SpannerOptions.newBuilder().setProjectId("test-project").build();
    DatabaseAdminStubSettings stubSettings = options.getDatabaseAdminStubSettings();
    List<? extends UnaryCallSettings<?, ?>> callsWithDefaultSettings =
        Arrays.asList(
            stubSettings.dropDatabaseSettings(),
            stubSettings.getDatabaseDdlSettings(),
            stubSettings.getDatabaseSettings());

    for (UnaryCallSettings<?, ?> callSettings : callsWithDefaultSettings) {
      assertThat(callSettings.getRetrySettings()).isEqualTo(defaultRetrySettings);
    }
  }

  @Test
  public void testDatabaseAdminCustomRetrySettings() {
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelay(Duration.ofSeconds(9999L))
            .setRetryDelayMultiplier(9999.99D)
            .setMaxRetryDelay(Duration.ofSeconds(9999L))
            .setInitialRpcTimeout(Duration.ofSeconds(9999L))
            .setRpcTimeoutMultiplier(9999.99D)
            .setMaxRpcTimeout(Duration.ofSeconds(9999L))
            .setTotalTimeout(Duration.ofSeconds(9999L))
            .build();
    SpannerOptions.Builder builder = SpannerOptions.newBuilder().setProjectId("test-project");
    DatabaseAdminStubSettings.Builder stubSettingsBuilder =
        builder.getDatabaseAdminStubSettingsBuilder();
    List<? extends UnaryCallSettings.Builder<?, ?>> unaryCallSettingsBuilders =
        Arrays.asList(
            stubSettingsBuilder.dropDatabaseSettings(),
            stubSettingsBuilder.getDatabaseDdlSettings(),
            stubSettingsBuilder.getDatabaseSettings());
    for (UnaryCallSettings.Builder<?, ?> callSettingsBuilder : unaryCallSettingsBuilders) {
      callSettingsBuilder.setRetrySettings(retrySettings);
    }

    SpannerOptions options = builder.build();
    DatabaseAdminStubSettings stubSettings = options.getDatabaseAdminStubSettings();
    List<? extends UnaryCallSettings<?, ?>> callsWithDefaultSettings =
        Arrays.asList(
            stubSettings.dropDatabaseSettings(),
            stubSettings.getDatabaseDdlSettings(),
            stubSettings.getDatabaseSettings());

    for (UnaryCallSettings<?, ?> callSettings : callsWithDefaultSettings) {
      assertThat(callSettings.getRetrySettings()).isEqualTo(retrySettings);
    }
  }

  @Test
  public void testInstanceAdminDefaultRetrySettings() {
    RetrySettings defaultRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelay(Duration.ofMillis(1000L))
            .setRetryDelayMultiplier(1.3)
            .setMaxRetryDelay(Duration.ofMillis(32000L))
            .setInitialRpcTimeout(Duration.ofMillis(60000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeout(Duration.ofMillis(60000L))
            .setTotalTimeout(Duration.ofMillis(600000L))
            .build();
    SpannerOptions options = SpannerOptions.newBuilder().setProjectId("test-project").build();
    InstanceAdminStubSettings stubSettings = options.getInstanceAdminStubSettings();
    List<? extends UnaryCallSettings<?, ?>> callsWithDefaultSettings =
        Arrays.asList(
            stubSettings.getInstanceConfigSettings(),
            stubSettings.listInstanceConfigsSettings(),
            stubSettings.deleteInstanceSettings(),
            stubSettings.getInstanceSettings(),
            stubSettings.listInstancesSettings());

    for (UnaryCallSettings<?, ?> callSettings : callsWithDefaultSettings) {
      assertThat(callSettings.getRetrySettings()).isEqualTo(defaultRetrySettings);
    }
  }

  @Test
  public void testInstanceAdminCustomRetrySettings() {
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelay(Duration.ofSeconds(9999L))
            .setRetryDelayMultiplier(9999.99D)
            .setMaxRetryDelay(Duration.ofSeconds(9999L))
            .setInitialRpcTimeout(Duration.ofSeconds(9999L))
            .setRpcTimeoutMultiplier(9999.99D)
            .setMaxRpcTimeout(Duration.ofSeconds(9999L))
            .setTotalTimeout(Duration.ofSeconds(9999L))
            .build();
    SpannerOptions.Builder builder = SpannerOptions.newBuilder().setProjectId("test-project");
    InstanceAdminStubSettings.Builder stubSettingsBuilder =
        builder.getInstanceAdminStubSettingsBuilder();
    List<? extends UnaryCallSettings.Builder<?, ?>> unaryCallSettingsBuilders =
        Arrays.asList(
            stubSettingsBuilder.deleteInstanceSettings(),
            stubSettingsBuilder.getInstanceConfigSettings(),
            stubSettingsBuilder.getInstanceSettings(),
            stubSettingsBuilder.listInstanceConfigsSettings(),
            stubSettingsBuilder.listInstancesSettings());
    for (UnaryCallSettings.Builder<?, ?> callSettingsBuilder : unaryCallSettingsBuilders) {
      callSettingsBuilder.setRetrySettings(retrySettings);
    }

    SpannerOptions options = builder.build();
    InstanceAdminStubSettings stubSettings = options.getInstanceAdminStubSettings();
    List<? extends UnaryCallSettings<?, ?>> callsWithDefaultSettings =
        Arrays.asList(
            stubSettings.getInstanceConfigSettings(),
            stubSettings.listInstanceConfigsSettings(),
            stubSettings.deleteInstanceSettings(),
            stubSettings.getInstanceSettings(),
            stubSettings.listInstancesSettings());

    for (UnaryCallSettings<?, ?> callSettings : callsWithDefaultSettings) {
      assertThat(callSettings.getRetrySettings()).isEqualTo(retrySettings);
    }
  }

  @Test
  public void testInvalidTransport() {
    thrown.expect(IllegalArgumentException.class);
    SpannerOptions.newBuilder().setTransportOptions(Mockito.mock(TransportOptions.class));
  }

  @Test
  public void testInvalidSessionLabels() {
    thrown.expect(NullPointerException.class);
    Map<String, String> labels = new HashMap<>();
    labels.put("env", null);
    SpannerOptions.newBuilder().setSessionLabels(labels);
  }

  @Test
  public void testNullSessionLabels() {
    thrown.expect(NullPointerException.class);
    SpannerOptions.newBuilder().setSessionLabels(null);
  }

  @Test
  public void testDoNotCacheClosedSpannerInstance() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setCredentials(NoCredentials.getInstance())
            .build();
    // Getting a service twice should give the same instance.
    Spanner service1 = options.getService();
    Spanner service2 = options.getService();
    assertThat(service1 == service2, is(true));
    assertThat(service1.isClosed()).isFalse();
    // Closing a service instance should cause the SpannerOptions to create a new service.
    service1.close();
    Spanner service3 = options.getService();
    assertThat(service3 == service1, is(false));
    assertThat(service1.isClosed()).isTrue();
    assertThat(service3.isClosed()).isFalse();
    ;
    // Getting another service from the SpannerOptions should return the new cached instance.
    Spanner service4 = options.getService();
    assertThat(service3 == service4, is(true));
    assertThat(service3.isClosed()).isFalse();
    service3.close();
  }

  @Test
  public void testSetClientLibToken() {
    final String jdbcToken = "sp-jdbc";
    final String hibernateToken = "sp-hib";
    SpannerOptions options = SpannerOptions.newBuilder().setClientLibToken(jdbcToken).build();
    assertThat(options.getClientLibToken()).isEqualTo(jdbcToken);

    options = SpannerOptions.newBuilder().setClientLibToken(hibernateToken).build();
    assertThat(options.getClientLibToken()).isEqualTo(hibernateToken);

    options = SpannerOptions.newBuilder().build();
    assertThat(options.getClientLibToken()).isEqualTo(ServiceOptions.getGoogApiClientLibName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetInvalidClientLibToken() {
    SpannerOptions.newBuilder().setClientLibToken("foo");
  }
}
