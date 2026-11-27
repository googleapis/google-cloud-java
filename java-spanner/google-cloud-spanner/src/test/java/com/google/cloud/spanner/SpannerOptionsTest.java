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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import com.google.api.core.ApiFunction;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.auth.ApiKeyCredentials;
import com.google.auth.Credentials;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.TransportOptions;
import com.google.cloud.grpc.GcpChannelPrimer;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpChannelPoolOptions;
import com.google.cloud.spanner.SpannerOptions.Builder.DefaultReadWriteTransactionOptions;
import com.google.cloud.spanner.SpannerOptions.CallContextConfigurator;
import com.google.cloud.spanner.SpannerOptions.FixedCloseableExecutorProvider;
import com.google.cloud.spanner.SpannerOptions.SpannerCallContextTimeoutConfigurator;
import com.google.cloud.spanner.admin.database.v1.stub.DatabaseAdminStubSettings;
import com.google.cloud.spanner.admin.instance.v1.stub.InstanceAdminStubSettings;
import com.google.cloud.spanner.omni.SpannerOmniCredentials;
import com.google.cloud.spanner.v1.stub.SpannerStubSettings;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.Futures;
import com.google.spanner.v1.BatchCreateSessionsRequest;
import com.google.spanner.v1.BatchWriteRequest;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.DeleteSessionRequest;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.DirectedReadOptions.IncludeReplicas;
import com.google.spanner.v1.DirectedReadOptions.ReplicaSelection;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ExecuteSqlRequest.QueryOptions;
import com.google.spanner.v1.GetSessionRequest;
import com.google.spanner.v1.ListSessionsRequest;
import com.google.spanner.v1.PartitionQueryRequest;
import com.google.spanner.v1.PartitionReadRequest;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.SpannerGrpc;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.grpc.netty.shaded.io.netty.handler.ssl.util.SelfSignedCertificate;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import org.jspecify.annotations.Nullable;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

/** Unit tests for {@link com.google.cloud.spanner.SpannerOptions}. */
@RunWith(JUnit4.class)
public class SpannerOptionsTest {
  private static Level originalLogLevel;

  @BeforeClass
  public static void disableLogging() {
    Logger logger = Logger.getLogger("");
    originalLogLevel = logger.getLevel();
    logger.setLevel(Level.OFF);
  }

  @AfterClass
  public static void resetLogging() {
    Logger logger = Logger.getLogger("");
    logger.setLevel(originalLogLevel);
  }

  @Test
  public void defaultBuilder() {
    // We need to set the project id and credentials since in test environments we cannot guarantee
    // that a default project id and credentials are available.
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .build();
    if (Strings.isNullOrEmpty(System.getenv("SPANNER_EMULATOR_HOST"))) {
      assertEquals("https://spanner.googleapis.com", options.getHost());
    } else {
      assertEquals("http://" + System.getenv("SPANNER_EMULATOR_HOST"), options.getHost());
    }
    assertEquals(4, options.getPrefetchChunks());
    assertNull(options.getSessionLabels());
    assertEquals(DecodeMode.DIRECT, options.getDecodeMode());
  }

  @Test
  public void builder() {
    String host = "http://localhost:8000/";
    String projectId = "test-project";
    Map<String, String> labels = new HashMap<>();
    labels.put("env", "dev");
    InMemoryMetricReader inMemoryMetricReader = InMemoryMetricReader.create();
    SdkMeterProvider sdkMeterProvider =
        SdkMeterProvider.builder().registerMetricReader(inMemoryMetricReader).build();
    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(sdkMeterProvider).build();
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setHost(host)
            .setProjectId(projectId)
            .setPrefetchChunks(2)
            .setSessionLabels(labels)
            .setOpenTelemetry(openTelemetry)
            .build();
    assertThat(options.getHost()).isEqualTo(host);
    assertThat(options.getProjectId()).isEqualTo(projectId);
    assertThat(options.getPrefetchChunks()).isEqualTo(2);
    assertThat(options.getSessionLabels()).containsExactlyEntriesIn(labels);
    assertThat(options.getOpenTelemetry()).isEqualTo(openTelemetry);
  }

  @Test
  public void testSpannerDefaultRetrySettings() {
    RetrySettings witRetryPolicy1 =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(250L))
            .setRetryDelayMultiplier(1.3)
            .setMaxRetryDelayDuration(Duration.ofMillis(32000L))
            .setInitialRpcTimeoutDuration(Duration.ofMillis(3600000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(Duration.ofMillis(3600000L))
            .setTotalTimeoutDuration(Duration.ofMillis(3600000L))
            .build();
    RetrySettings witRetryPolicy2 =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(250L))
            .setRetryDelayMultiplier(1.3)
            .setMaxRetryDelayDuration(Duration.ofMillis(32000L))
            .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
            .setTotalTimeoutDuration(Duration.ofMillis(60000L))
            .build();
    RetrySettings witRetryPolicy3 =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(250L))
            .setRetryDelayMultiplier(1.3)
            .setMaxRetryDelayDuration(Duration.ofMillis(32000L))
            .setInitialRpcTimeoutDuration(Duration.ofMillis(30000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(Duration.ofMillis(30000L))
            .setTotalTimeoutDuration(Duration.ofMillis(30000L))
            .build();
    RetrySettings noRetry1 =
        RetrySettings.newBuilder()
            .setInitialRpcTimeoutDuration(Duration.ofMillis(3600000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(Duration.ofMillis(3600000L))
            .setTotalTimeoutDuration(Duration.ofMillis(3600000L))
            .build();
    SpannerOptions options = SpannerOptions.newBuilder().setProjectId("test-project").build();
    SpannerStubSettings stubSettings = options.getSpannerStubSettings();
    List<? extends UnaryCallSettings<?, ?>> callsWithRetry1 =
        Arrays.asList(stubSettings.listSessionsSettings(), stubSettings.commitSettings());
    List<? extends UnaryCallSettings<?, ?>> callsWithRetry2 =
        Collections.singletonList(stubSettings.batchCreateSessionsSettings());
    List<? extends UnaryCallSettings<?, ?>> callsWithRetry3 =
        Arrays.asList(
            stubSettings.createSessionSettings(),
            stubSettings.getSessionSettings(),
            stubSettings.deleteSessionSettings(),
            stubSettings.executeSqlSettings(),
            stubSettings.executeBatchDmlSettings(),
            stubSettings.readSettings(),
            stubSettings.beginTransactionSettings(),
            stubSettings.rollbackSettings(),
            stubSettings.partitionQuerySettings(),
            stubSettings.partitionReadSettings());
    List<? extends ServerStreamingCallSettings<?, ?>> callsWithNoRetry1 =
        Arrays.asList(
            stubSettings.executeStreamingSqlSettings(), stubSettings.streamingReadSettings());

    for (UnaryCallSettings<?, ?> callSettings : callsWithRetry1) {
      assertThat(callSettings.getRetrySettings()).isEqualTo(witRetryPolicy1);
    }
    for (UnaryCallSettings<?, ?> callSettings : callsWithRetry2) {
      assertThat(callSettings.getRetrySettings()).isEqualTo(witRetryPolicy2);
    }
    for (UnaryCallSettings<?, ?> callSettings : callsWithRetry3) {
      assertThat(callSettings.getRetrySettings()).isEqualTo(witRetryPolicy3);
    }
    for (ServerStreamingCallSettings<?, ?> callSettings : callsWithNoRetry1) {
      assertThat(callSettings.getRetrySettings()).isEqualTo(noRetry1);
    }
  }

  @Test
  public void testSpannerCustomRetrySettings() {
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofSeconds(9999L))
            .setRetryDelayMultiplier(9999.99D)
            .setMaxRetryDelayDuration(Duration.ofSeconds(9999L))
            .setInitialRpcTimeoutDuration(Duration.ofSeconds(9999L))
            .setRpcTimeoutMultiplier(9999.99D)
            .setMaxRpcTimeoutDuration(Duration.ofSeconds(9999L))
            .setTotalTimeoutDuration(Duration.ofSeconds(9999L))
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
    RetrySettings withRetryPolicy1 =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
            .setRetryDelayMultiplier(1.3)
            .setMaxRetryDelayDuration(Duration.ofMillis(32000L))
            .setInitialRpcTimeoutDuration(Duration.ofMillis(3600000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(Duration.ofMillis(3600000L))
            .setTotalTimeoutDuration(Duration.ofMillis(3600000L))
            .build();
    RetrySettings withRetryPolicy2 =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
            .setRetryDelayMultiplier(1.3)
            .setMaxRetryDelayDuration(Duration.ofMillis(32000L))
            .setInitialRpcTimeoutDuration(Duration.ofMillis(30000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(Duration.ofMillis(30000L))
            .setTotalTimeoutDuration(Duration.ofMillis(30000L))
            .build();
    RetrySettings noRetryPolicy2 =
        RetrySettings.newBuilder()
            .setInitialRpcTimeoutDuration(Duration.ofMillis(30000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(Duration.ofMillis(30000L))
            .setTotalTimeoutDuration(Duration.ofMillis(30000L))
            .build();
    SpannerOptions options = SpannerOptions.newBuilder().setProjectId("test-project").build();
    DatabaseAdminStubSettings stubSettings = options.getDatabaseAdminStubSettings();
    List<? extends UnaryCallSettings<?, ?>> callsWithRetryPolicy1 =
        Arrays.asList(
            stubSettings.dropDatabaseSettings(),
            stubSettings.getDatabaseSettings(),
            stubSettings.getDatabaseDdlSettings());
    List<? extends UnaryCallSettings<?, ?>> callsWithRetryPolicy2 =
        Collections.singletonList(stubSettings.getIamPolicySettings());
    List<? extends UnaryCallSettings<?, ?>> callsWithNoRetry2 =
        Arrays.asList(
            stubSettings.setIamPolicySettings(), stubSettings.testIamPermissionsSettings());

    for (UnaryCallSettings<?, ?> callSettings : callsWithRetryPolicy1) {
      assertThat(callSettings.getRetrySettings()).isEqualTo(withRetryPolicy1);
    }
    for (UnaryCallSettings<?, ?> callSettings : callsWithRetryPolicy2) {
      assertThat(callSettings.getRetrySettings()).isEqualTo(withRetryPolicy2);
    }
    for (UnaryCallSettings<?, ?> callSettings : callsWithNoRetry2) {
      assertThat(callSettings.getRetrySettings()).isEqualTo(noRetryPolicy2);
    }
  }

  @Test
  public void testDatabaseAdminCustomRetrySettings() {
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofSeconds(9999L))
            .setRetryDelayMultiplier(9999.99D)
            .setMaxRetryDelayDuration(Duration.ofSeconds(9999L))
            .setInitialRpcTimeoutDuration(Duration.ofSeconds(9999L))
            .setRpcTimeoutMultiplier(9999.99D)
            .setMaxRpcTimeoutDuration(Duration.ofSeconds(9999L))
            .setTotalTimeoutDuration(Duration.ofSeconds(9999L))
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
    RetrySettings withRetryPolicy1 =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
            .setRetryDelayMultiplier(1.3)
            .setMaxRetryDelayDuration(Duration.ofMillis(32000L))
            .setInitialRpcTimeoutDuration(Duration.ofMillis(3600000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(Duration.ofMillis(3600000L))
            .setTotalTimeoutDuration(Duration.ofMillis(3600000L))
            .build();
    RetrySettings withRetryPolicy2 =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
            .setRetryDelayMultiplier(1.3)
            .setMaxRetryDelayDuration(Duration.ofMillis(32000L))
            .setInitialRpcTimeoutDuration(Duration.ofMillis(30000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(Duration.ofMillis(30000L))
            .setTotalTimeoutDuration(Duration.ofMillis(30000L))
            .build();
    RetrySettings noRetryPolicy1 =
        RetrySettings.newBuilder()
            .setInitialRpcTimeoutDuration(Duration.ofMillis(3600000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(Duration.ofMillis(3600000L))
            .setTotalTimeoutDuration(Duration.ofMillis(3600000L))
            .build();
    RetrySettings noRetryPolicy2 =
        RetrySettings.newBuilder()
            .setInitialRpcTimeoutDuration(Duration.ofMillis(30000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(Duration.ofMillis(30000L))
            .setTotalTimeoutDuration(Duration.ofMillis(30000L))
            .build();
    SpannerOptions options = SpannerOptions.newBuilder().setProjectId("test-project").build();
    InstanceAdminStubSettings stubSettings = options.getInstanceAdminStubSettings();
    List<? extends UnaryCallSettings<?, ?>> callsWithRetryPolicy1 =
        Arrays.asList(
            stubSettings.getInstanceConfigSettings(),
            stubSettings.listInstanceConfigsSettings(),
            stubSettings.deleteInstanceSettings(),
            stubSettings.getInstanceSettings(),
            stubSettings.listInstancesSettings());
    List<? extends UnaryCallSettings<?, ?>> callsWithRetryPolicy2 =
        Collections.singletonList(stubSettings.getIamPolicySettings());
    List<? extends UnaryCallSettings<?, ?>> callsWithNoRetryPolicy1 =
        Arrays.asList(stubSettings.createInstanceSettings(), stubSettings.updateInstanceSettings());
    List<? extends UnaryCallSettings<?, ?>> callsWithNoRetryPolicy2 =
        Arrays.asList(
            stubSettings.setIamPolicySettings(), stubSettings.testIamPermissionsSettings());

    for (UnaryCallSettings<?, ?> callSettings : callsWithRetryPolicy1) {
      assertThat(callSettings.getRetrySettings()).isEqualTo(withRetryPolicy1);
    }
    for (UnaryCallSettings<?, ?> callSettings : callsWithRetryPolicy2) {
      assertThat(callSettings.getRetrySettings()).isEqualTo(withRetryPolicy2);
    }
    for (UnaryCallSettings<?, ?> callSettings : callsWithNoRetryPolicy1) {
      assertThat(callSettings.getRetrySettings()).isEqualTo(noRetryPolicy1);
    }
    for (UnaryCallSettings<?, ?> callSettings : callsWithNoRetryPolicy2) {
      assertThat(callSettings.getRetrySettings()).isEqualTo(noRetryPolicy2);
    }
  }

  @Test
  public void testInstanceAdminCustomRetrySettings() {
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofSeconds(9999L))
            .setRetryDelayMultiplier(9999.99D)
            .setMaxRetryDelayDuration(Duration.ofSeconds(9999L))
            .setInitialRpcTimeoutDuration(Duration.ofSeconds(9999L))
            .setRpcTimeoutMultiplier(9999.99D)
            .setMaxRpcTimeoutDuration(Duration.ofSeconds(9999L))
            .setTotalTimeoutDuration(Duration.ofSeconds(9999L))
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
    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                SpannerOptions.newBuilder()
                    .setTransportOptions(Mockito.mock(TransportOptions.class)));
    assertNotNull(e.getMessage());
  }

  @Test
  public void testInvalidSessionLabels() {
    Map<String, String> labels = new HashMap<>();
    labels.put("env", null);
    NullPointerException e =
        assertThrows(
            NullPointerException.class, () -> SpannerOptions.newBuilder().setSessionLabels(labels));
    assertNotNull(e.getMessage());
  }

  @Test
  public void testNullSessionLabels() {
    NullPointerException e =
        assertThrows(
            NullPointerException.class, () -> SpannerOptions.newBuilder().setSessionLabels(null));
    assertNotNull(e.getMessage());
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
    final String pgAdapterToken = "pg-adapter";
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCredentials(NoCredentials.getInstance())
            .setClientLibToken(jdbcToken)
            .build();
    // Verify that the client lib token that will actually be used contains both the JDBC token and
    // the standard Java client library token ('gccl').
    assertEquals("sp-jdbc gccl", options.getClientLibToken());

    options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCredentials(NoCredentials.getInstance())
            .setClientLibToken(hibernateToken)
            .build();
    assertEquals("sp-hib gccl", options.getClientLibToken());

    options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCredentials(NoCredentials.getInstance())
            .setClientLibToken(pgAdapterToken)
            .build();
    assertEquals("pg-adapter gccl", options.getClientLibToken());

    options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertEquals(options.getClientLibToken(), ServiceOptions.getGoogApiClientLibName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetInvalidClientLibToken() {
    SpannerOptions.newBuilder()
        .setProjectId("some-project")
        .setCredentials(NoCredentials.getInstance())
        .setClientLibToken("foo");
  }

  @Test
  public void testSetEmulatorHostWithoutProtocol() {
    // If the host doesn't have a protocol as a prefix, it will automatically be prefixed with
    // "http://".
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setEmulatorHost("localhost:1234")
            .build();
    assertThat(options.getHost()).isEqualTo("http://localhost:1234");
    assertThat(options.getEndpoint()).isEqualTo("localhost:1234");
  }

  @Test
  public void testSetEmulatorHostWithProtocol() {
    // If the host has a protocol, it should not be modified.
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setEmulatorHost("http://localhost:1234")
            .build();
    assertThat(options.getHost()).isEqualTo("http://localhost:1234");
    assertThat(options.getEndpoint()).isEqualTo("localhost:1234");
  }

  @Test
  public void testIsEmulatorEnabledWithEmulatorHostWithoutProtocol() {
    // The builder prepends "http://" to the host, but not to the emulator host. The emulator
    // gate must still detect that the emulator is being used.
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setEmulatorHost("localhost:1234")
            .build();
    assertTrue(options.isEmulatorEnabled());
  }

  @Test
  public void testIsEmulatorEnabledWithEmulatorHostWithProtocol() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setEmulatorHost("http://localhost:1234")
            .build();
    assertTrue(options.isEmulatorEnabled());
  }

  @Test
  public void testIsEmulatorEnabledWithoutEmulatorHost() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setHost("http://localhost:1234")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertFalse(options.isEmulatorEnabled());
  }

  @Test
  public void testDefaultQueryOptions() {
    SpannerOptions.useEnvironment(
        new SpannerOptions.SpannerEnvironment() {
          @Override
          public String getOptimizerVersion() {
            return "";
          }

          @Nonnull
          @Override
          public String getOptimizerStatisticsPackage() {
            return "";
          }
        });
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setDefaultQueryOptions(
                DatabaseId.of("p", "i", "d"),
                QueryOptions.newBuilder()
                    .setOptimizerVersion("1")
                    .setOptimizerStatisticsPackage("custom-package")
                    .build())
            .setProjectId("p")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertThat(options.getDefaultQueryOptions(DatabaseId.of("p", "i", "d")))
        .isEqualTo(
            QueryOptions.newBuilder()
                .setOptimizerVersion("1")
                .setOptimizerStatisticsPackage("custom-package")
                .build());
    assertThat(options.getDefaultQueryOptions(DatabaseId.of("p", "i", "o")))
        .isEqualTo(QueryOptions.getDefaultInstance());

    // Now simulate that the user has set an environment variable for the query optimizer version
    // and statistics package.
    SpannerOptions.useEnvironment(
        new SpannerOptions.SpannerEnvironment() {
          @Override
          public String getOptimizerVersion() {
            return "2";
          }

          @Nonnull
          @Override
          public String getOptimizerStatisticsPackage() {
            return "env-package";
          }
        });
    // Create options with '1' as the default query optimizer version and 'custom-package' as the
    // default query optimizer statistics package. These values should be overridden by
    // the environment variable.
    options =
        SpannerOptions.newBuilder()
            .setDefaultQueryOptions(
                DatabaseId.of("p", "i", "d"),
                QueryOptions.newBuilder()
                    .setOptimizerVersion("1")
                    .setOptimizerStatisticsPackage("custom-package")
                    .build())
            .setProjectId("p")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertThat(options.getDefaultQueryOptions(DatabaseId.of("p", "i", "d")))
        .isEqualTo(
            QueryOptions.newBuilder()
                .setOptimizerVersion("2")
                .setOptimizerStatisticsPackage("env-package")
                .build());
    assertThat(options.getDefaultQueryOptions(DatabaseId.of("p", "i", "o")))
        .isEqualTo(
            QueryOptions.newBuilder()
                .setOptimizerVersion("2")
                .setOptimizerStatisticsPackage("env-package")
                .build());
  }

  @Test
  public void testCompressorName() {
    assertThat(
            SpannerOptions.newBuilder()
                .setProjectId("p")
                .setCompressorName("gzip")
                .build()
                .getCompressorName())
        .isEqualTo("gzip");
    assertThat(
            SpannerOptions.newBuilder()
                .setProjectId("p")
                .setCompressorName("identity")
                .build()
                .getCompressorName())
        .isEqualTo("identity");
    assertNull(
        SpannerOptions.newBuilder()
            .setProjectId("p")
            .setCompressorName(null)
            .build()
            .getCompressorName());
    assertThrows(
        IllegalArgumentException.class, () -> SpannerOptions.newBuilder().setCompressorName("foo"));
  }

  @Test
  public void testLeaderAwareRoutingEnablement() {
    assertTrue(SpannerOptions.newBuilder().setProjectId("p").build().isLeaderAwareRoutingEnabled());
    assertTrue(
        SpannerOptions.newBuilder()
            .setProjectId("p")
            .enableLeaderAwareRouting()
            .build()
            .isLeaderAwareRoutingEnabled());
    assertFalse(
        SpannerOptions.newBuilder()
            .setProjectId("p")
            .disableLeaderAwareRouting()
            .build()
            .isLeaderAwareRoutingEnabled());
  }

  @Test
  public void testEndToEndTracingEnablement() {
    // Test that end-to-end tracing is disabled by default.
    assertFalse(SpannerOptions.newBuilder().setProjectId("p").build().isEndToEndTracingEnabled());
    assertTrue(
        SpannerOptions.newBuilder()
            .setProjectId("p")
            .setEnableEndToEndTracing(true)
            .build()
            .isEndToEndTracingEnabled());
    assertFalse(
        SpannerOptions.newBuilder()
            .setProjectId("p")
            .setEnableEndToEndTracing(false)
            .build()
            .isEndToEndTracingEnabled());
  }

  @Test
  public void testMonitoringHost() {
    String metricsEndpoint = "test-endpoint:443";
    assertNull(SpannerOptions.newBuilder().setProjectId("p").build().getMonitoringHost());
    assertThat(
            SpannerOptions.newBuilder()
                .setProjectId("p")
                .setMonitoringHost(metricsEndpoint)
                .build()
                .getMonitoringHost())
        .isEqualTo(metricsEndpoint);
  }

  @Test
  public void testTransactionOptions() {
    DefaultReadWriteTransactionOptions transactionOptions =
        DefaultReadWriteTransactionOptions.newBuilder()
            .setIsolationLevel(IsolationLevel.SERIALIZABLE)
            .build();
    assertNotNull(
        SpannerOptions.newBuilder().setProjectId("p").build().getDefaultTransactionOptions());
    assertThat(
            SpannerOptions.newBuilder()
                .setProjectId("p")
                .setDefaultTransactionOptions(transactionOptions)
                .build()
                .getDefaultTransactionOptions()
                .getIsolationLevel())
        .isEqualTo(IsolationLevel.SERIALIZABLE);
  }

  @Test
  public void testSetDirectedReadOptions() {
    final DirectedReadOptions directedReadOptions =
        DirectedReadOptions.newBuilder()
            .setIncludeReplicas(
                IncludeReplicas.newBuilder()
                    .addReplicaSelections(
                        ReplicaSelection.newBuilder().setLocation("us-west1").build())
                    .build())
            .build();
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setDirectedReadOptions(directedReadOptions)
            .build();
    assertEquals(options.getDirectedReadOptions(), directedReadOptions);
    assertThrows(
        NullPointerException.class,
        () -> SpannerOptions.newBuilder().setDirectedReadOptions(null).build());
  }

  @Test
  public void testSpannerCallContextTimeoutConfigurator_NullValues() {
    SpannerCallContextTimeoutConfigurator configurator =
        SpannerCallContextTimeoutConfigurator.create();
    ApiCallContext inputCallContext = GrpcCallContext.createDefault();

    assertNull(
        configurator.configure(
            inputCallContext,
            BatchCreateSessionsRequest.getDefaultInstance(),
            SpannerGrpc.getBatchCreateSessionsMethod()));
    assertNull(
        configurator.configure(
            inputCallContext,
            CreateSessionRequest.getDefaultInstance(),
            SpannerGrpc.getCreateSessionMethod()));
    assertNull(
        configurator.configure(
            inputCallContext,
            DeleteSessionRequest.getDefaultInstance(),
            SpannerGrpc.getDeleteSessionMethod()));
    assertNull(
        configurator.configure(
            inputCallContext,
            GetSessionRequest.getDefaultInstance(),
            SpannerGrpc.getGetSessionMethod()));
    assertNull(
        configurator.configure(
            inputCallContext,
            DeleteSessionRequest.getDefaultInstance(),
            SpannerGrpc.getDeleteSessionMethod()));
    assertNull(
        configurator.configure(
            inputCallContext,
            ListSessionsRequest.getDefaultInstance(),
            SpannerGrpc.getListSessionsMethod()));

    assertNull(
        configurator.configure(
            inputCallContext,
            BeginTransactionRequest.getDefaultInstance(),
            SpannerGrpc.getBeginTransactionMethod()));
    assertNull(
        configurator.configure(
            inputCallContext, CommitRequest.getDefaultInstance(), SpannerGrpc.getCommitMethod()));
    assertNull(
        configurator.configure(
            inputCallContext,
            RollbackRequest.getDefaultInstance(),
            SpannerGrpc.getRollbackMethod()));

    assertNull(
        configurator.configure(
            inputCallContext,
            ExecuteSqlRequest.getDefaultInstance(),
            SpannerGrpc.getExecuteSqlMethod()));
    assertNull(
        configurator.configure(
            inputCallContext,
            ExecuteSqlRequest.getDefaultInstance(),
            SpannerGrpc.getExecuteStreamingSqlMethod()));
    assertNull(
        configurator.configure(
            inputCallContext,
            ExecuteBatchDmlRequest.getDefaultInstance(),
            SpannerGrpc.getExecuteBatchDmlMethod()));
    assertNull(
        configurator.configure(
            inputCallContext, ReadRequest.getDefaultInstance(), SpannerGrpc.getReadMethod()));
    assertNull(
        configurator.configure(
            inputCallContext,
            ReadRequest.getDefaultInstance(),
            SpannerGrpc.getStreamingReadMethod()));

    assertNull(
        configurator.configure(
            inputCallContext,
            PartitionQueryRequest.getDefaultInstance(),
            SpannerGrpc.getPartitionQueryMethod()));
    assertNull(
        configurator.configure(
            inputCallContext,
            PartitionReadRequest.getDefaultInstance(),
            SpannerGrpc.getPartitionReadMethod()));
    assertNull(
        configurator.configure(
            inputCallContext,
            BatchWriteRequest.getDefaultInstance(),
            SpannerGrpc.getBatchWriteMethod()));
  }

  @Test
  public void testSpannerCallContextTimeoutConfigurator_WithTimeouts() {
    SpannerCallContextTimeoutConfigurator configurator =
        SpannerCallContextTimeoutConfigurator.create();
    configurator.withBatchUpdateTimeoutDuration(Duration.ofSeconds(1L));
    configurator.withCommitTimeoutDuration(Duration.ofSeconds(2L));
    configurator.withExecuteQueryTimeoutDuration(Duration.ofSeconds(3L));
    configurator.withExecuteUpdateTimeoutDuration(Duration.ofSeconds(4L));
    configurator.withPartitionQueryTimeoutDuration(Duration.ofSeconds(5L));
    configurator.withPartitionReadTimeoutDuration(Duration.ofSeconds(6L));
    configurator.withReadTimeoutDuration(Duration.ofSeconds(7L));
    configurator.withRollbackTimeoutDuration(Duration.ofSeconds(8L));
    configurator.withBatchWriteTimeoutDuration(Duration.ofSeconds(9L));
    assertEquals(Duration.ofSeconds(9L), configurator.getBatchWriteTimeoutDuration());

    ApiCallContext inputCallContext = GrpcCallContext.createDefault();

    assertNull(
        configurator.configure(
            inputCallContext,
            BatchCreateSessionsRequest.getDefaultInstance(),
            SpannerGrpc.getBatchCreateSessionsMethod()));
    assertNull(
        configurator.configure(
            inputCallContext,
            CreateSessionRequest.getDefaultInstance(),
            SpannerGrpc.getCreateSessionMethod()));
    assertNull(
        configurator.configure(
            inputCallContext,
            DeleteSessionRequest.getDefaultInstance(),
            SpannerGrpc.getDeleteSessionMethod()));
    assertNull(
        configurator.configure(
            inputCallContext,
            GetSessionRequest.getDefaultInstance(),
            SpannerGrpc.getGetSessionMethod()));
    assertNull(
        configurator.configure(
            inputCallContext,
            DeleteSessionRequest.getDefaultInstance(),
            SpannerGrpc.getDeleteSessionMethod()));
    assertNull(
        configurator.configure(
            inputCallContext,
            ListSessionsRequest.getDefaultInstance(),
            SpannerGrpc.getListSessionsMethod()));

    assertNull(
        configurator.configure(
            inputCallContext,
            BeginTransactionRequest.getDefaultInstance(),
            SpannerGrpc.getBeginTransactionMethod()));
    assertThat(
            configurator
                .configure(
                    inputCallContext,
                    CommitRequest.getDefaultInstance(),
                    SpannerGrpc.getCommitMethod())
                .getTimeoutDuration())
        .isEqualTo(Duration.ofSeconds(2L));
    assertThat(
            configurator
                .configure(
                    inputCallContext,
                    RollbackRequest.getDefaultInstance(),
                    SpannerGrpc.getRollbackMethod())
                .getTimeoutDuration())
        .isEqualTo(Duration.ofSeconds(8L));

    assertNull(
        configurator.configure(
            inputCallContext,
            ExecuteSqlRequest.getDefaultInstance(),
            SpannerGrpc.getExecuteSqlMethod()));
    assertThat(
            configurator
                .configure(
                    inputCallContext,
                    ExecuteSqlRequest.getDefaultInstance(),
                    SpannerGrpc.getExecuteStreamingSqlMethod())
                .getTimeoutDuration())
        .isEqualTo(Duration.ofSeconds(3L));
    assertThat(
            configurator
                .configure(
                    inputCallContext,
                    ExecuteBatchDmlRequest.getDefaultInstance(),
                    SpannerGrpc.getExecuteBatchDmlMethod())
                .getTimeoutDuration())
        .isEqualTo(Duration.ofSeconds(1L));
    assertNull(
        configurator.configure(
            inputCallContext, ReadRequest.getDefaultInstance(), SpannerGrpc.getReadMethod()));
    assertThat(
            configurator
                .configure(
                    inputCallContext,
                    ReadRequest.getDefaultInstance(),
                    SpannerGrpc.getStreamingReadMethod())
                .getTimeoutDuration())
        .isEqualTo(Duration.ofSeconds(7L));

    assertThat(
            configurator
                .configure(
                    inputCallContext,
                    PartitionQueryRequest.getDefaultInstance(),
                    SpannerGrpc.getPartitionQueryMethod())
                .getTimeoutDuration())
        .isEqualTo(Duration.ofSeconds(5L));
    assertThat(
            configurator
                .configure(
                    inputCallContext,
                    PartitionReadRequest.getDefaultInstance(),
                    SpannerGrpc.getPartitionReadMethod())
                .getTimeoutDuration())
        .isEqualTo(Duration.ofSeconds(6L));
    ApiCallContext batchWriteCallContext =
        configurator.configure(
            inputCallContext,
            BatchWriteRequest.getDefaultInstance(),
            SpannerGrpc.getBatchWriteMethod());
    assertThat(batchWriteCallContext.getTimeoutDuration()).isEqualTo(Duration.ofSeconds(9L));
    assertThat(batchWriteCallContext.getStreamWaitTimeoutDuration())
        .isEqualTo(Duration.ofSeconds(9L));
  }

  @Test
  public void testCustomAsyncExecutorProvider() {
    ScheduledExecutorService service = mock(ScheduledExecutorService.class);
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setAsyncExecutorProvider(FixedCloseableExecutorProvider.create(service))
            .build();
    assertSame(service, options.getAsyncExecutorProvider().getExecutor());
  }

  @Test
  public void testAsyncExecutorProviderCoreThreadCount() throws Exception {
    assertEquals(8, SpannerOptions.getDefaultAsyncExecutorProviderCoreThreadCount());
    String propertyName = "com.google.cloud.spanner.async_num_core_threads";
    assertEquals(
        Integer.valueOf(8),
        runWithSystemProperty(
            propertyName, null, SpannerOptions::getDefaultAsyncExecutorProviderCoreThreadCount));
    assertEquals(
        Integer.valueOf(16),
        runWithSystemProperty(
            propertyName, "16", SpannerOptions::getDefaultAsyncExecutorProviderCoreThreadCount));
    assertEquals(
        Integer.valueOf(1),
        runWithSystemProperty(
            propertyName, "1", SpannerOptions::getDefaultAsyncExecutorProviderCoreThreadCount));
    assertThrows(
        SpannerException.class,
        () ->
            runWithSystemProperty(
                propertyName,
                "foo",
                SpannerOptions::getDefaultAsyncExecutorProviderCoreThreadCount));
    assertThrows(
        SpannerException.class,
        () ->
            runWithSystemProperty(
                propertyName,
                "-1",
                SpannerOptions::getDefaultAsyncExecutorProviderCoreThreadCount));
    assertThrows(
        SpannerException.class,
        () ->
            runWithSystemProperty(
                propertyName, "", SpannerOptions::getDefaultAsyncExecutorProviderCoreThreadCount));
  }

  static <V> V runWithSystemProperty(
      String propertyName, String propertyValue, Callable<V> callable) throws Exception {
    String currentValue = System.getProperty(propertyName);
    if (propertyValue == null) {
      System.clearProperty(propertyName);
    } else {
      System.setProperty(propertyName, propertyValue);
    }
    try {
      return callable.call();
    } finally {
      if (currentValue == null) {
        System.clearProperty(propertyName);
      } else {
        System.setProperty(propertyName, currentValue);
      }
    }
  }

  @Test
  public void testDefaultNumChannelsWithGrpcGcpExtensionEnabled() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .enableGrpcGcpExtension()
            .build();

    assertEquals(SpannerOptions.GRPC_GCP_ENABLED_DEFAULT_CHANNELS, options.getNumChannels());
  }

  @Test
  public void testDefaultNumChannelsWithGrpcGcpExtensionDisabled() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .disableGrpcGcpExtension()
            .build();

    assertEquals(SpannerOptions.DEFAULT_CHANNELS, options.getNumChannels());
  }

  @Test
  public void testNumChannelsWithGrpcGcpExtensionEnabled() {
    // Set number of channels explicitly, before enabling gRPC-GCP channel pool in SpannerOptions
    // builder.
    int numChannels = 5;
    SpannerOptions options1 =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setNumChannels(numChannels)
            .enableGrpcGcpExtension()
            .build();

    assertEquals(numChannels, options1.getNumChannels());

    // Set number of channels explicitly, after enabling gRPC-GCP channel pool in SpannerOptions
    // builder.
    SpannerOptions options2 =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .enableGrpcGcpExtension()
            .setNumChannels(numChannels)
            .build();

    assertEquals(numChannels, options2.getNumChannels());
  }

  @Test
  public void checkCreatedInstanceWhenGrpcGcpExtensionDisabled() {
    SpannerOptions options =
        SpannerOptions.newBuilder().setProjectId("test-project").disableGrpcGcpExtension().build();
    SpannerOptions options1 = options.toBuilder().build();
    assertEquals(false, options.isGrpcGcpExtensionEnabled());
    assertEquals(options.isGrpcGcpExtensionEnabled(), options1.isGrpcGcpExtensionEnabled());

    Spanner spanner1 = options.getService();
    Spanner spanner2 = options1.getService();

    assertNotSame(spanner1, spanner2);

    spanner1.close();
    spanner2.close();
  }

  @Test
  public void checkCreatedInstanceWhenGrpcGcpExtensionEnabled() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .enableGrpcGcpExtension()
            .build();
    SpannerOptions options1 = options.toBuilder().build();
    assertEquals(true, options.isGrpcGcpExtensionEnabled());
    assertEquals(options.isGrpcGcpExtensionEnabled(), options1.isGrpcGcpExtensionEnabled());

    Spanner spanner1 = options.getService();
    Spanner spanner2 = options1.getService();

    assertNotSame(spanner1, spanner2);

    spanner1.close();
    spanner2.close();
  }

  @Test
  public void checkGlobalOpenTelemetryWhenNotInjected() {
    GlobalOpenTelemetry.resetForTest();
    InMemoryMetricReader inMemoryMetricReader = InMemoryMetricReader.create();
    SdkMeterProvider sdkMeterProvider =
        SdkMeterProvider.builder().registerMetricReader(inMemoryMetricReader).build();
    OpenTelemetrySdk.builder().setMeterProvider(sdkMeterProvider).buildAndRegisterGlobal();
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertEquals(GlobalOpenTelemetry.get(), options.getOpenTelemetry());
  }

  @Test
  public void testExperimentalHostOptions() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setExperimentalHost("localhost:8080")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertEquals("default", options.getProjectId());
    assertEquals(0, options.getSessionPoolOptions().getMinSessions());
    assertEquals(0, options.getSessionPoolOptions().getMaxSessions());
    assertTrue(options.getSessionPoolOptions().getUseMultiplexedSession());
    assertTrue(options.getSessionPoolOptions().getUseMultiplexedSessionForRW());
    assertTrue(options.getSessionPoolOptions().getUseMultiplexedSessionPartitionedOps());
  }

  @Test
  public void testDynamicChannelPoolingDisabledByDefault() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertFalse(options.isDynamicChannelPoolEnabled());
  }

  @Test
  public void testDynamicChannelPoolingEnabledExplicitly() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .enableDynamicChannelPool()
            .build();
    assertTrue(options.isDynamicChannelPoolEnabled());

    // Verify Spanner-specific defaults are applied
    GcpChannelPoolOptions poolOptions = options.getGcpChannelPoolOptions();
    assertNotNull(poolOptions);
    assertEquals(SpannerOptions.DEFAULT_DYNAMIC_POOL_INITIAL_SIZE, poolOptions.getInitSize());
    assertEquals(SpannerOptions.DEFAULT_DYNAMIC_POOL_MAX_CHANNELS, poolOptions.getMaxSize());
    assertEquals(SpannerOptions.DEFAULT_DYNAMIC_POOL_MIN_CHANNELS, poolOptions.getMinSize());
    assertEquals(SpannerOptions.DEFAULT_DYNAMIC_POOL_MAX_RPC, poolOptions.getMaxRpcPerChannel());
    assertEquals(SpannerOptions.DEFAULT_DYNAMIC_POOL_MIN_RPC, poolOptions.getMinRpcPerChannel());
    assertEquals(
        SpannerOptions.DEFAULT_DYNAMIC_POOL_SCALE_DOWN_INTERVAL,
        poolOptions.getScaleDownInterval());
  }

  @Test
  public void testDynamicChannelPoolingDisabledWhenNumChannelsSet() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .enableDynamicChannelPool()
            .setNumChannels(5) // Explicitly setting numChannels should disable DCP.
            .build();
    assertFalse(options.isDynamicChannelPoolEnabled());
    assertEquals(5, options.getNumChannels());
  }

  @Test
  public void testDynamicChannelPoolingDisabledExplicitly() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .enableDynamicChannelPool()
            .disableDynamicChannelPool()
            .build();
    assertFalse(options.isDynamicChannelPoolEnabled());
  }

  @Test
  public void testDynamicChannelPoolingCustomSettings() {
    Duration scaleDownInterval = Duration.ofMinutes(5);
    GcpChannelPoolOptions customPoolOptions =
        GcpChannelPoolOptions.newBuilder()
            .setInitSize(6)
            .setMaxSize(15)
            .setMinSize(3)
            .setDynamicScaling(10, 50, scaleDownInterval)
            .build();

    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .enableDynamicChannelPool()
            .setGcpChannelPoolOptions(customPoolOptions)
            .build();

    assertTrue(options.isDynamicChannelPoolEnabled());
    GcpChannelPoolOptions poolOptions = options.getGcpChannelPoolOptions();
    assertEquals(6, poolOptions.getInitSize());
    assertEquals(15, poolOptions.getMaxSize());
    assertEquals(3, poolOptions.getMinSize());
    assertEquals(50, poolOptions.getMaxRpcPerChannel());
    assertEquals(10, poolOptions.getMinRpcPerChannel());
    assertEquals(scaleDownInterval, poolOptions.getScaleDownInterval());
  }

  @Test
  public void testAffinityKeySettings() {
    Duration affinityKeyLifetime = Duration.ofMinutes(10);
    Duration cleanupInterval = Duration.ofMinutes(5);
    GcpChannelPoolOptions poolOptions =
        GcpChannelPoolOptions.newBuilder()
            .setAffinityKeyLifetime(affinityKeyLifetime)
            .setCleanupInterval(cleanupInterval)
            .build();

    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .enableGrpcGcpExtension()
            .setGcpChannelPoolOptions(poolOptions)
            .build();

    assertEquals(affinityKeyLifetime, options.getGcpChannelPoolOptions().getAffinityKeyLifetime());
    assertEquals(cleanupInterval, options.getGcpChannelPoolOptions().getCleanupInterval());
  }

  @Test
  public void testAffinityKeySettingsDefaults() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .enableGrpcGcpExtension()
            .build();

    // Verify default affinity key settings from Spanner defaults
    GcpChannelPoolOptions poolOptions = options.getGcpChannelPoolOptions();
    assertEquals(
        SpannerOptions.DEFAULT_DYNAMIC_POOL_AFFINITY_KEY_LIFETIME,
        poolOptions.getAffinityKeyLifetime());
    assertEquals(
        SpannerOptions.DEFAULT_DYNAMIC_POOL_CLEANUP_INTERVAL, poolOptions.getCleanupInterval());
  }

  @Test
  public void testDynamicChannelPoolingDisabledWhenGrpcGcpDisabled() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .disableGrpcGcpExtension()
            .build();
    // DCP should be disabled when grpc-gcp is disabled.
    assertFalse(options.isDynamicChannelPoolEnabled());
  }

  @Test
  public void testDynamicChannelPoolDefaultValues() {
    // Pins the documented dynamic channel pool default values. If this test fails, the defaults
    // changed: update these literals deliberately and call the change out in the PR description.
    assertEquals(25, SpannerOptions.DEFAULT_DYNAMIC_POOL_MAX_RPC);
    assertEquals(15, SpannerOptions.DEFAULT_DYNAMIC_POOL_MIN_RPC);
    assertEquals(Duration.ofMinutes(3), SpannerOptions.DEFAULT_DYNAMIC_POOL_SCALE_DOWN_INTERVAL);
    assertEquals(4, SpannerOptions.DEFAULT_DYNAMIC_POOL_INITIAL_SIZE);
    assertEquals(10, SpannerOptions.DEFAULT_DYNAMIC_POOL_MAX_CHANNELS);
    assertEquals(2, SpannerOptions.DEFAULT_DYNAMIC_POOL_MIN_CHANNELS);
    assertEquals(Duration.ofMinutes(10), SpannerOptions.DEFAULT_DYNAMIC_POOL_AFFINITY_KEY_LIFETIME);
    assertEquals(Duration.ofMinutes(1), SpannerOptions.DEFAULT_DYNAMIC_POOL_CLEANUP_INTERVAL);
    assertEquals(Duration.ofSeconds(10), SpannerOptions.DEFAULT_DYNAMIC_POOL_CHANNEL_PRIME_TIMEOUT);
    assertEquals(3, SpannerOptions.DEFAULT_DYNAMIC_POOL_CHANNEL_PRIME_MAX_ATTEMPTS);
  }

  @Test
  public void testDynamicChannelPoolPrimeSettingsDefaultsAndUserValues() {
    GcpChannelPoolOptions defaults = SpannerOptions.createDefaultDynamicChannelPoolOptions();
    assertEquals(
        SpannerOptions.DEFAULT_DYNAMIC_POOL_CHANNEL_PRIME_TIMEOUT,
        defaults.getChannelPrimeTimeout());
    assertEquals(
        SpannerOptions.DEFAULT_DYNAMIC_POOL_CHANNEL_PRIME_MAX_ATTEMPTS,
        defaults.getChannelPrimeMaxAttempts());
    // The options themselves never register a primer; the Spanner client does that when the pool
    // is created, unless the user supplied one.
    assertNull(defaults.getChannelPrimer());

    // Prime settings that the user left unset are filled in from the defaults.
    SpannerOptions merged =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .enableDynamicChannelPool()
            .setGcpChannelPoolOptions(GcpChannelPoolOptions.newBuilder().setMaxSize(6).build())
            .build();
    assertEquals(6, merged.getGcpChannelPoolOptions().getMaxSize());
    assertEquals(
        SpannerOptions.DEFAULT_DYNAMIC_POOL_CHANNEL_PRIME_TIMEOUT,
        merged.getGcpChannelPoolOptions().getChannelPrimeTimeout());
    assertEquals(
        SpannerOptions.DEFAULT_DYNAMIC_POOL_CHANNEL_PRIME_MAX_ATTEMPTS,
        merged.getGcpChannelPoolOptions().getChannelPrimeMaxAttempts());
    assertNull(merged.getGcpChannelPoolOptions().getChannelPrimer());

    // A user-provided primer, timeout, and attempt count are preserved.
    GcpChannelPrimer userPrimer = channel -> Futures.immediateFuture(null);
    SpannerOptions custom =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .enableDynamicChannelPool()
            .setGcpChannelPoolOptions(
                GcpChannelPoolOptions.newBuilder()
                    .setChannelPrimer(userPrimer)
                    .setChannelPrimeTimeout(Duration.ofSeconds(2))
                    .setChannelPrimeMaxAttempts(5)
                    .build())
            .build();
    assertSame(userPrimer, custom.getGcpChannelPoolOptions().getChannelPrimer());
    assertEquals(Duration.ofSeconds(2), custom.getGcpChannelPoolOptions().getChannelPrimeTimeout());
    assertEquals(5, custom.getGcpChannelPoolOptions().getChannelPrimeMaxAttempts());
  }

  @Test
  public void testCreateDefaultDynamicChannelPoolOptions() {
    // Test the static factory method for creating default options
    GcpChannelPoolOptions defaults = SpannerOptions.createDefaultDynamicChannelPoolOptions();
    assertNotNull(defaults);
    assertEquals(SpannerOptions.DEFAULT_DYNAMIC_POOL_MAX_CHANNELS, defaults.getMaxSize());
    assertEquals(SpannerOptions.DEFAULT_DYNAMIC_POOL_MIN_CHANNELS, defaults.getMinSize());
    assertEquals(SpannerOptions.DEFAULT_DYNAMIC_POOL_INITIAL_SIZE, defaults.getInitSize());
    assertEquals(SpannerOptions.DEFAULT_DYNAMIC_POOL_MAX_RPC, defaults.getMaxRpcPerChannel());
    assertEquals(SpannerOptions.DEFAULT_DYNAMIC_POOL_MIN_RPC, defaults.getMinRpcPerChannel());
    assertEquals(
        SpannerOptions.DEFAULT_DYNAMIC_POOL_SCALE_DOWN_INTERVAL, defaults.getScaleDownInterval());
    assertEquals(
        SpannerOptions.DEFAULT_DYNAMIC_POOL_AFFINITY_KEY_LIFETIME,
        defaults.getAffinityKeyLifetime());
    assertEquals(
        SpannerOptions.DEFAULT_DYNAMIC_POOL_CLEANUP_INTERVAL, defaults.getCleanupInterval());
  }

  @Test
  public void testPlainTextOptions() {
    SpannerOptions options =
        SpannerOptions.newBuilder().setExperimentalHost("localhost:8080").usePlainText().build();
    assertEquals("http://localhost:8080", options.getHost());
    assertEquals(NoCredentials.getInstance(), options.getCredentials());
    options =
        SpannerOptions.newBuilder()
            .setExperimentalHost("http://localhost:8080")
            .usePlainText()
            .build();
    assertEquals("http://localhost:8080", options.getHost());
    options =
        SpannerOptions.newBuilder().usePlainText().setExperimentalHost("localhost:8080").build();
    assertEquals("http://localhost:8080", options.getHost());
    options =
        SpannerOptions.newBuilder()
            .usePlainText()
            .setExperimentalHost("http://localhost:8080")
            .build();
    assertEquals("http://localhost:8080", options.getHost());
  }

  @Test
  public void testOmniEnforcedInBuild() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setType(SpannerOptions.InstanceType.OMNI)
            .setHost("http://localhost:8080")
            .setProjectId("some-custom-project")
            .setBuiltInMetricsEnabled(true)
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    .setAcquireSessionTimeoutDuration(Duration.ofSeconds(42))
                    .build())
            .setCredentials(NoCredentials.getInstance())
            .build();

    assertEquals(SpannerOptions.SPANNER_OMNI_PROJECT_ID, options.getProjectId());
    assertFalse(options.isEnableBuiltInMetrics());
    assertTrue(options.getSessionPoolOptions().getUseMultiplexedSession());
    assertEquals(
        Duration.ofSeconds(42), options.getSessionPoolOptions().getAcquireSessionTimeout());
  }

  private static class TestSpannerOptions extends SpannerOptions {
    TestSpannerOptions(SpannerOptions.Builder builder) {
      super(builder);
    }
  }

  @Test
  public void testOmniEnforcedInConstructor() {
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setType(SpannerOptions.InstanceType.OMNI)
            .setHost("http://localhost:8080")
            .setProjectId("some-custom-project")
            .setBuiltInMetricsEnabled(true)
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    .setAcquireSessionTimeoutDuration(Duration.ofSeconds(42))
                    .build())
            .setCredentials(NoCredentials.getInstance());

    SpannerOptions options = new TestSpannerOptions(builder);

    assertEquals(SpannerOptions.SPANNER_OMNI_PROJECT_ID, options.getProjectId());
    assertFalse(options.isEnableBuiltInMetrics());
    assertTrue(options.getSessionPoolOptions().getUseMultiplexedSession());
    assertEquals(
        Duration.ofSeconds(42), options.getSessionPoolOptions().getAcquireSessionTimeout());
  }

  @Test
  public void enableGrpcMetricsKeepsOneArgOverloadForCompatibility() throws Exception {
    assertNotNull(
        SpannerOptions.class.getMethod(
            "enablegRPCMetrics", InstantiatingGrpcChannelProvider.Builder.class));
  }

  @Test
  public void testCustomProviderKeepsCloudMonitoringSinkOnNonOmni() {
    SpannerOptions.useEnvironment(new SpannerOptions.SpannerEnvironment() {});
    try {
      CustomOpenTelemetryMetricsProvider provider =
          CustomOpenTelemetryMetricsProvider.create(OpenTelemetry.noop());
      // Additive semantics: a custom sink on a non-OMNI client leaves the Cloud Monitoring sink on.
      SpannerOptions options =
          SpannerOptions.newBuilder()
              .setProjectId("some-project")
              .setEmulatorHost(null)
              .setCredentials(NoCredentials.getInstance())
              .setClientMetricsProvider(provider)
              .build();
      assertSame(provider, options.getClientMetricsProvider());
      assertTrue(options.isEnableBuiltInMetrics());

      // Disabling the built-in flag turns off only the Cloud Monitoring sink; the custom sink
      // stays.
      SpannerOptions customOnly = options.toBuilder().setBuiltInMetricsEnabled(false).build();
      assertSame(provider, customOnly.getClientMetricsProvider());
      assertFalse(customOnly.isEnableBuiltInMetrics());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testLogin() {
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setHost("http://localhost:15000")
            .setType(SpannerOptions.InstanceType.OMNI);
    char[] password = new char[] {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
    builder.login("user", password);

    // Password array should be cleared
    assertArrayEquals(new char[] {'\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0'}, password);

    SpannerOptions options = builder.build();
    assertTrue(options.getCredentials() instanceof SpannerOmniCredentials);
  }

  @Test
  public void testGrpcKeepAliveTime() {
    SpannerOptions defaultOptions =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertEquals(Duration.ofSeconds(120), defaultOptions.getGrpcKeepAliveTime());

    SpannerOptions customOptions =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setGrpcKeepAliveTime(Duration.ofSeconds(20))
            .build();
    assertEquals(Duration.ofSeconds(20), customOptions.getGrpcKeepAliveTime());

    SpannerOptions optionsFromBuilder = customOptions.toBuilder().build();
    assertEquals(Duration.ofSeconds(20), optionsFromBuilder.getGrpcKeepAliveTime());

    assertThrows(
        NullPointerException.class, () -> SpannerOptions.newBuilder().setGrpcKeepAliveTime(null));

    assertThrows(
        IllegalArgumentException.class,
        () -> SpannerOptions.newBuilder().setGrpcKeepAliveTime(Duration.ZERO));

    assertThrows(
        IllegalArgumentException.class,
        () -> SpannerOptions.newBuilder().setGrpcKeepAliveTime(Duration.ofSeconds(-10)));
  }

  @Test
  public void testGrpcKeepAliveTimeout() {
    SpannerOptions defaultOptions =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertEquals(Duration.ofSeconds(20), defaultOptions.getGrpcKeepAliveTimeout());

    SpannerOptions customOptions =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setGrpcKeepAliveTimeout(Duration.ofSeconds(5))
            .build();
    assertEquals(Duration.ofSeconds(5), customOptions.getGrpcKeepAliveTimeout());

    SpannerOptions optionsFromBuilder = customOptions.toBuilder().build();
    assertEquals(Duration.ofSeconds(5), optionsFromBuilder.getGrpcKeepAliveTimeout());

    assertThrows(
        NullPointerException.class,
        () -> SpannerOptions.newBuilder().setGrpcKeepAliveTimeout(null));

    assertThrows(
        IllegalArgumentException.class,
        () -> SpannerOptions.newBuilder().setGrpcKeepAliveTimeout(Duration.ZERO));

    assertThrows(
        IllegalArgumentException.class,
        () -> SpannerOptions.newBuilder().setGrpcKeepAliveTimeout(Duration.ofSeconds(-10)));
  }

  @Test
  public void testCallContextConfigurator() {
    SpannerOptions defaultOptions =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertNull(defaultOptions.getCallContextConfigurator());

    CallContextConfigurator configurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            return null;
          }
        };
    SpannerOptions customOptions =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setCallContextConfigurator(configurator)
            .build();
    assertSame(configurator, customOptions.getCallContextConfigurator());

    SpannerOptions optionsFromBuilder = customOptions.toBuilder().build();
    assertSame(configurator, optionsFromBuilder.getCallContextConfigurator());

    SpannerOptions clearedOptions =
        customOptions.toBuilder().setCallContextConfigurator(null).build();
    assertNull(clearedOptions.getCallContextConfigurator());
  }

  @Test
  public void testUseClientCertAndTrustCertificate() throws Exception {
    SelfSignedCertificate ssc = new SelfSignedCertificate("spanner.test");
    SelfSignedCertificate ca = new SelfSignedCertificate("spanner.ca");

    try {
      String certPath = ssc.certificate().getAbsolutePath();
      String keyPath = ssc.privateKey().getAbsolutePath();
      String caPath = ca.certificate().getAbsolutePath();

      SpannerOptions options =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(NoCredentials.getInstance())
              .setHost("https://localhost:1234")
              .useClientCert(certPath, keyPath)
              .setCaCertificate(caPath)
              .build();

      assertNotNull(options.getChannelConfigurator());
      assertEquals(certPath, options.getClientCertificate());
      assertEquals(keyPath, options.getClientCertificateKey());
      assertEquals(caPath, options.getCaCertificate());

      SpannerOptions fromBuilder = options.toBuilder().build();
      assertNotNull(fromBuilder.getChannelConfigurator());
      assertEquals(certPath, fromBuilder.getClientCertificate());
      assertEquals(keyPath, fromBuilder.getClientCertificateKey());
      assertEquals(caPath, fromBuilder.getCaCertificate());

      // Test standalone setCaCertificate
      SpannerOptions caOnlyOptions =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(NoCredentials.getInstance())
              .setHost("https://localhost:1234")
              .setCaCertificate(caPath)
              .build();

      assertNotNull(caOnlyOptions.getChannelConfigurator());
      assertNull(caOnlyOptions.getClientCertificate());
      assertNull(caOnlyOptions.getClientCertificateKey());
      assertEquals(caPath, caOnlyOptions.getCaCertificate());

      // Test setCaCertificate combined with login (username/password)
      SpannerOptions loginWithCaOptions =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setType(SpannerOptions.InstanceType.OMNI)
              .setHost("https://localhost:1234")
              .setCaCertificate(caPath)
              .login("test-user", "test-pass".toCharArray())
              .build();

      assertTrue(loginWithCaOptions.getCredentials() instanceof SpannerOmniCredentials);
      assertNotNull(loginWithCaOptions.getChannelConfigurator());
      assertEquals(caPath, loginWithCaOptions.getCaCertificate());

      SpannerOptions loginFromBuilder = loginWithCaOptions.toBuilder().build();
      assertTrue(loginFromBuilder.getCredentials() instanceof SpannerOmniCredentials);
      assertNotNull(loginFromBuilder.getChannelConfigurator());
      assertEquals(caPath, loginFromBuilder.getCaCertificate());
    } finally {
      ssc.delete();
      ca.delete();
    }
  }

  @Test
  public void testUseClientCertAndCaCertificateEmptyValidation() {
    assertThrows(
        IllegalArgumentException.class,
        () -> SpannerOptions.newBuilder().useClientCert("", "/path/to/key"));
    assertThrows(
        IllegalArgumentException.class,
        () -> SpannerOptions.newBuilder().useClientCert("/path/to/cert", ""));
    assertThrows(
        IllegalArgumentException.class,
        () -> SpannerOptions.newBuilder().useClientCert(null, "key"));
    assertThrows(
        IllegalArgumentException.class,
        () -> SpannerOptions.newBuilder().useClientCert("cert", null));
    assertThrows(
        IllegalArgumentException.class, () -> SpannerOptions.newBuilder().setCaCertificate(""));
    assertThrows(
        IllegalArgumentException.class, () -> SpannerOptions.newBuilder().setCaCertificate(null));
  }

  @Test
  public void testToBuilderPreservesChannelConfiguratorWithoutChaining() throws Exception {
    SelfSignedCertificate ssc = new SelfSignedCertificate("spanner.test.configurator");
    try {
      String certPath = ssc.certificate().getAbsolutePath();
      String keyPath = ssc.privateKey().getAbsolutePath();

      final int[] configuratorCallCount = new int[] {0};
      @SuppressWarnings("rawtypes")
      ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> customConfigurator =
          builder -> {
            configuratorCallCount[0]++;
            return builder;
          };

      SpannerOptions options =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(NoCredentials.getInstance())
              .setHost("https://localhost:1234")
              .useClientCert(certPath, keyPath)
              .setChannelConfigurator(customConfigurator)
              .build();

      // Repeated toBuilder().build()
      SpannerOptions options2 = options.toBuilder().build();
      SpannerOptions options3 = options2.toBuilder().build();

      ManagedChannelBuilder<?> dummyBuilder = mock(ManagedChannelBuilder.class);
      options3.getChannelConfigurator().apply(dummyBuilder);
      // The custom configurator should only be called once, not 3 times due to redundant nesting
      assertEquals(1, configuratorCallCount[0]);
    } finally {
      ssc.delete();
    }
  }

  @Test
  public void testUnwrapsOmniSslChannelConfiguratorWhenOmniSslContextNull() throws Exception {
    SelfSignedCertificate ssc = new SelfSignedCertificate("spanner.test.unwrap");
    try {
      String certPath = ssc.certificate().getAbsolutePath();
      String keyPath = ssc.privateKey().getAbsolutePath();

      final int[] configuratorCallCount = new int[] {0};
      @SuppressWarnings("rawtypes")
      ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> customConfigurator =
          builder -> {
            configuratorCallCount[0]++;
            return builder;
          };

      SpannerOptions optionsWithCert =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(NoCredentials.getInstance())
              .setHost("https://localhost:1234")
              .useClientCert(certPath, keyPath)
              .setChannelConfigurator(customConfigurator)
              .build();

      // Create new options without certs but with previous channel configurator
      SpannerOptions optionsWithoutCert =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(NoCredentials.getInstance())
              .setHost("https://localhost:1234")
              .setChannelConfigurator(optionsWithCert.getChannelConfigurator())
              .build();

      ManagedChannelBuilder<?> dummyBuilder = mock(ManagedChannelBuilder.class);
      optionsWithoutCert.getChannelConfigurator().apply(dummyBuilder);
      assertEquals(1, configuratorCallCount[0]);
    } finally {
      ssc.delete();
    }
  }

  @Test
  public void testToBuilderPreservesInstanceTypeAndUsePlainText() throws Exception {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setHost("localhost:1234")
            .setType(SpannerOptions.InstanceType.OMNI)
            .usePlainText()
            .build();

    assertEquals(SpannerOptions.InstanceType.OMNI, options.getInstanceType());
    assertTrue(options.isUsePlainText());

    SpannerOptions fromBuilder = options.toBuilder().build();
    assertEquals(SpannerOptions.InstanceType.OMNI, fromBuilder.getInstanceType());
    assertTrue(fromBuilder.isUsePlainText());
  }

  @Test
  public void testToBuilderSetUniverseDomainUpdatesDefaultHost() {
    SpannerOptions base =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setEmulatorHost(null)
            .build();
    assertEquals("https://spanner.googleapis.com", base.getHost());
    assertEquals("spanner.googleapis.com:443", base.getEndpoint());

    SpannerOptions rebuilt = base.toBuilder().setUniverseDomain("universe.example").build();
    assertEquals("universe.example", rebuilt.getUniverseDomain());
    assertEquals("https://spanner.universe.example", rebuilt.getHost());
    assertEquals("spanner.universe.example:443", rebuilt.getEndpoint());
    assertEquals("universe.example", rebuilt.getSpannerStubSettings().getUniverseDomain());
    assertEquals("spanner.universe.example:443", rebuilt.getSpannerStubSettings().getEndpoint());
    assertEquals("universe.example", rebuilt.getInstanceAdminStubSettings().getUniverseDomain());
    assertEquals(
        "spanner.universe.example:443", rebuilt.getInstanceAdminStubSettings().getEndpoint());
    assertEquals("universe.example", rebuilt.getDatabaseAdminStubSettings().getUniverseDomain());
    assertEquals(
        "spanner.universe.example:443", rebuilt.getDatabaseAdminStubSettings().getEndpoint());
  }

  @Test
  public void testToBuilderChangeUniverseDomainUpdatesDefaultHost() {
    SpannerOptions base =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setEmulatorHost(null)
            .setUniverseDomain("domain1.example")
            .build();
    assertEquals("https://spanner.domain1.example", base.getHost());
    assertEquals("spanner.domain1.example:443", base.getEndpoint());

    SpannerOptions rebuilt = base.toBuilder().setUniverseDomain("domain2.example").build();
    assertEquals("domain2.example", rebuilt.getUniverseDomain());
    assertEquals("https://spanner.domain2.example", rebuilt.getHost());
    assertEquals("spanner.domain2.example:443", rebuilt.getEndpoint());
    assertEquals("spanner.domain2.example:443", rebuilt.getSpannerStubSettings().getEndpoint());
  }

  @Test
  public void testToBuilderSetUniverseDomainPreservesCustomHost() {
    SpannerOptions base =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setHost("https://custom.spanner.example:1234")
            .build();

    SpannerOptions rebuilt = base.toBuilder().setUniverseDomain("universe.example").build();
    assertEquals("universe.example", rebuilt.getUniverseDomain());
    assertEquals("https://custom.spanner.example:1234", rebuilt.getHost());
    assertEquals("custom.spanner.example:1234", rebuilt.getEndpoint());
  }

  @Test
  public void testToBuilderSetUniverseDomainPreservesExplicitDefaultHost() {
    SpannerOptions base =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setHost("https://spanner.googleapis.com")
            .build();

    SpannerOptions rebuilt = base.toBuilder().setUniverseDomain("universe.example").build();
    assertEquals("universe.example", rebuilt.getUniverseDomain());
    assertEquals("https://spanner.googleapis.com", rebuilt.getHost());
    assertEquals("spanner.googleapis.com:443", rebuilt.getEndpoint());
  }

  @Test
  public void testToBuilderSetHostAndUniverseDomainOrderIndependent() {
    SpannerOptions base =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setEmulatorHost(null)
            .build();

    SpannerOptions hostThenUniverse =
        base.toBuilder()
            .setHost("https://custom.example:8443")
            .setUniverseDomain("universe.example")
            .build();
    SpannerOptions universeThenHost =
        base.toBuilder()
            .setUniverseDomain("universe.example")
            .setHost("https://custom.example:8443")
            .build();

    assertEquals("https://custom.example:8443", hostThenUniverse.getHost());
    assertEquals("universe.example", hostThenUniverse.getUniverseDomain());
    assertEquals("https://custom.example:8443", universeThenHost.getHost());
    assertEquals("universe.example", universeThenHost.getUniverseDomain());
  }

  @Test
  public void testToBuilderSetHostNullResetsToUniverseDomainDefaultHost() {
    SpannerOptions base =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setHost("https://custom.example:1234")
            .build();

    SpannerOptions rebuilt =
        base.toBuilder().setHost(null).setUniverseDomain("universe.example").build();
    assertEquals("universe.example", rebuilt.getUniverseDomain());
    assertEquals("https://spanner.universe.example", rebuilt.getHost());
    assertEquals("spanner.universe.example:443", rebuilt.getEndpoint());
  }

  @Test
  public void testToBuilderClearEmulatorHostAndSetUniverseDomain() {
    SpannerOptions base =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setEmulatorHost("localhost:9010")
            .build();
    assertEquals("http://localhost:9010", base.getHost());
    assertTrue(base.isEmulatorEnabled());

    SpannerOptions rebuiltEmulator = base.toBuilder().build();
    assertEquals("http://localhost:9010", rebuiltEmulator.getHost());
    assertTrue(rebuiltEmulator.isEmulatorEnabled());

    SpannerOptions rebuiltNonEmulator =
        base.toBuilder().setEmulatorHost(null).setUniverseDomain("universe.example").build();
    assertEquals("universe.example", rebuiltNonEmulator.getUniverseDomain());
    assertEquals("https://spanner.universe.example", rebuiltNonEmulator.getHost());
    assertEquals("spanner.universe.example:443", rebuiltNonEmulator.getEndpoint());
    assertFalse(rebuiltNonEmulator.isEmulatorEnabled());
  }

  @Test
  public void testToBuilderLegacyDeserializedFallbackWithoutConfiguredHost() {
    // Default host with null configuredHost recomputes host when universe domain changes.
    SpannerOptions legacyDefault =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setEmulatorHost(null)
            .build(/* clearConfiguredHost= */ true);
    SpannerOptions rebuiltDefault =
        legacyDefault.toBuilder().setUniverseDomain("universe.example").build();
    assertEquals("https://spanner.universe.example", rebuiltDefault.getHost());
    assertEquals("spanner.universe.example:443", rebuiltDefault.getEndpoint());

    // Custom host with null configuredHost is preserved when universe domain changes.
    SpannerOptions legacyCustom =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setHost("https://custom.spanner.example:1234")
            .build(/* clearConfiguredHost= */ true);
    SpannerOptions rebuiltCustom =
        legacyCustom.toBuilder().setUniverseDomain("universe.example").build();
    assertEquals("https://custom.spanner.example:1234", rebuiltCustom.getHost());
    assertEquals("custom.spanner.example:1234", rebuiltCustom.getEndpoint());

    // Emulator host with null configuredHost stays emulator when unchanged and recomputes default
    // host when emulatorHost is cleared.
    SpannerOptions legacyEmulator =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setEmulatorHost("localhost:9010")
            .build(/* clearConfiguredHost= */ true);
    assertEquals("http://localhost:9010", legacyEmulator.toBuilder().build().getHost());
    SpannerOptions rebuiltClearedEmulator =
        legacyEmulator.toBuilder()
            .setEmulatorHost(null)
            .setUniverseDomain("universe.example")
            .build();
    assertEquals("https://spanner.universe.example", rebuiltClearedEmulator.getHost());
    assertFalse(rebuiltClearedEmulator.isEmulatorEnabled());

    // OMNI instance with both explicit host and non-null emulatorHost preserves the OMNI host.
    SpannerOptions legacyOmniWithEmulator =
        SpannerOptions.newBuilder()
            .setType(SpannerOptions.InstanceType.OMNI)
            .setHost("localhost:8080")
            .usePlainText()
            .setEmulatorHost("localhost:9010")
            .build(/* clearConfiguredHost= */ true);
    SpannerOptions rebuiltOmni =
        legacyOmniWithEmulator.toBuilder().setUniverseDomain("universe.example").build();
    assertEquals("http://localhost:8080", rebuiltOmni.getHost());
    assertEquals("localhost:8080", rebuiltOmni.getEndpoint());
    assertEquals(SpannerOptions.InstanceType.OMNI, rebuiltOmni.getInstanceType());
    assertTrue(rebuiltOmni.isUsePlainText());
  }

  @Test
  public void testToBuilderPreservesUniverseDomainWhenUnchanged() {
    SpannerOptions base =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setEmulatorHost(null)
            .setUniverseDomain("domain1.example")
            .build();

    SpannerOptions rebuilt = base.toBuilder().build();
    assertEquals("domain1.example", rebuilt.getUniverseDomain());
    assertEquals("https://spanner.domain1.example", rebuilt.getHost());
    assertEquals("spanner.domain1.example:443", rebuilt.getEndpoint());
    assertEquals("domain1.example", rebuilt.getSpannerStubSettings().getUniverseDomain());
  }

  @Test
  public void testToBuilderSetUniverseDomainPreservesOmniHost() {
    SpannerOptions plainTextOmni =
        SpannerOptions.newBuilder()
            .setType(SpannerOptions.InstanceType.OMNI)
            .setHost("localhost:8080")
            .usePlainText()
            .build();
    SpannerOptions rebuiltPlainText =
        plainTextOmni.toBuilder().setUniverseDomain("universe.example").build();
    assertEquals("http://localhost:8080", rebuiltPlainText.getHost());
    assertEquals("localhost:8080", rebuiltPlainText.getEndpoint());
    assertEquals(SpannerOptions.InstanceType.OMNI, rebuiltPlainText.getInstanceType());
    assertTrue(rebuiltPlainText.isUsePlainText());

    SpannerOptions tlsOmni =
        SpannerOptions.newBuilder()
            .setType(SpannerOptions.InstanceType.OMNI)
            .setHost("https://omni.example:15000")
            .setCredentials(NoCredentials.getInstance())
            .build();
    SpannerOptions rebuiltTls = tlsOmni.toBuilder().setUniverseDomain("universe.example").build();
    assertEquals("https://omni.example:15000", rebuiltTls.getHost());
    assertEquals("omni.example:15000", rebuiltTls.getEndpoint());
    assertEquals(SpannerOptions.InstanceType.OMNI, rebuiltTls.getInstanceType());
  }

  @Test
  public void testToBuilderSetUniverseDomainKeepsEmulatorHostWhenNotCleared() {
    SpannerOptions base =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setEmulatorHost("localhost:9010")
            .build();

    SpannerOptions rebuilt = base.toBuilder().setUniverseDomain("universe.example").build();
    assertEquals("http://localhost:9010", rebuilt.getHost());
    assertEquals("localhost:9010", rebuilt.getEndpoint());
    assertTrue(rebuilt.isEmulatorEnabled());
    assertEquals("universe.example", rebuilt.getUniverseDomain());
  }

  @Test
  public void testReuseBuilderClearEmulatorHostAndSetUniverseDomain() {
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder().setProjectId("test-project").setEmulatorHost("localhost:9010");

    SpannerOptions emulatorOptions = builder.build();
    assertEquals("http://localhost:9010", emulatorOptions.getHost());
    assertTrue(emulatorOptions.isEmulatorEnabled());

    SpannerOptions nonEmulatorOptions =
        builder.setEmulatorHost(null).setUniverseDomain("universe.example").build();
    assertEquals("https://spanner.universe.example", nonEmulatorOptions.getHost());
    assertEquals("spanner.universe.example:443", nonEmulatorOptions.getEndpoint());
    assertFalse(nonEmulatorOptions.isEmulatorEnabled());
  }

  @Test
  public void testUniverseDomain_ValidValues() {
    SpannerOptions defaultOptions =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setEmulatorHost(null)
            .build();
    assertEquals("https://spanner.googleapis.com", defaultOptions.getHost());
    assertEquals("spanner.googleapis.com:443", defaultOptions.getEndpoint());

    SpannerOptions emptyUniverseOptions =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setEmulatorHost(null)
            .setUniverseDomain("")
            .build();
    assertEquals("https://spanner.googleapis.com", emptyUniverseOptions.getHost());
    assertEquals("spanner.googleapis.com:443", emptyUniverseOptions.getEndpoint());

    for (String universeDomain :
        Arrays.asList("googleapis.com", "abc.goog", "a-1.b-2.example.goog", "ABC.GOOG")) {
      SpannerOptions options =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(NoCredentials.getInstance())
              .setEmulatorHost(null)
              .setUniverseDomain(universeDomain)
              .build();
      assertEquals("https://spanner." + universeDomain, options.getHost());
      assertEquals("spanner." + universeDomain + ":443", options.getEndpoint());
    }
  }

  @Test
  public void testUniverseDomain_RejectsInvalidAndUrlInjectionValues() {
    String overlongLabel = Strings.repeat("a", 64) + ".goog";
    String overlongDomain =
        Strings.repeat("a", 60)
            + "."
            + Strings.repeat("b", 60)
            + "."
            + Strings.repeat("c", 60)
            + "."
            + Strings.repeat("d", 63);
    assertEquals(246, overlongDomain.length());

    for (String invalidDomain :
        Arrays.asList(
            "ignored@attacker.com:8443",
            "ignored@attacker.com",
            "abc.goog:8443",
            "abc.goog/injected#frag",
            "abc.goog/injected?foo=bar#frag",
            "https://attacker.com",
            "abc.goog\\attacker.com",
            " abc.goog",
            "abc.goog ",
            ".abc.goog",
            "abc.goog.",
            "abc..goog",
            "-abc.goog",
            "abc-.goog",
            "abc_def.goog",
            "[::1]",
            overlongLabel,
            overlongDomain)) {
      IllegalArgumentException defaultHostException =
          assertThrows(
              "Expected SpannerOptions with universeDomain=" + invalidDomain + " to be rejected",
              IllegalArgumentException.class,
              () ->
                  SpannerOptions.newBuilder()
                      .setProjectId("test-project")
                      .setCredentials(NoCredentials.getInstance())
                      .setEmulatorHost(null)
                      .setUniverseDomain(invalidDomain)
                      .build());
      assertTrue(
          defaultHostException.getMessage(),
          defaultHostException.getMessage().contains("Invalid universe domain"));

      IllegalArgumentException explicitHostException =
          assertThrows(
              "Expected SpannerOptions with explicit host and universeDomain="
                  + invalidDomain
                  + " to be rejected",
              IllegalArgumentException.class,
              () ->
                  SpannerOptions.newBuilder()
                      .setProjectId("test-project")
                      .setCredentials(NoCredentials.getInstance())
                      .setHost("https://localhost:1234")
                      .setUniverseDomain(invalidDomain)
                      .build());
      assertTrue(
          explicitHostException.getMessage(),
          explicitHostException.getMessage().contains("Invalid universe domain"));
    }
  }

  @Test
  public void testUniverseDomainFromEnvironmentVariable() {
    useUniverseDomainEnvironment("partner.example");
    try {
      SpannerOptions options =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(NoCredentials.getInstance())
              .setEmulatorHost(null)
              .build();
      assertNull(options.getUniverseDomain());
      assertEquals("https://spanner.partner.example", options.getHost());
      assertEquals("spanner.partner.example:443", options.getEndpoint());
      assertEquals("partner.example", options.getSpannerStubSettings().getUniverseDomain());
      assertEquals("spanner.partner.example:443", options.getSpannerStubSettings().getEndpoint());
      assertEquals("partner.example", options.getInstanceAdminStubSettings().getUniverseDomain());
      assertEquals(
          "spanner.partner.example:443", options.getInstanceAdminStubSettings().getEndpoint());
      assertEquals("partner.example", options.getDatabaseAdminStubSettings().getUniverseDomain());
      assertEquals(
          "spanner.partner.example:443", options.getDatabaseAdminStubSettings().getEndpoint());
      String hostDomain = options.getHost().substring("https://spanner.".length());
      assertEquals(hostDomain, options.getSpannerStubSettings().getUniverseDomain());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testExplicitUniverseDomainOverridesEnvironmentVariable() {
    useUniverseDomainEnvironment("env.example");
    try {
      // Control check: confirm the environment value is active when unset.
      SpannerOptions envDefaultOptions =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(NoCredentials.getInstance())
              .setEmulatorHost(null)
              .build();
      assertEquals("https://spanner.env.example", envDefaultOptions.getHost());
      assertEquals("env.example", envDefaultOptions.getSpannerStubSettings().getUniverseDomain());

      SpannerOptions options =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(NoCredentials.getInstance())
              .setEmulatorHost(null)
              .setUniverseDomain("explicit.example")
              .build();
      assertEquals("explicit.example", options.getUniverseDomain());
      assertEquals("https://spanner.explicit.example", options.getHost());
      assertEquals("spanner.explicit.example:443", options.getEndpoint());
      assertEquals("explicit.example", options.getSpannerStubSettings().getUniverseDomain());
      assertEquals("spanner.explicit.example:443", options.getSpannerStubSettings().getEndpoint());
      assertEquals("explicit.example", options.getInstanceAdminStubSettings().getUniverseDomain());
      assertEquals(
          "spanner.explicit.example:443", options.getInstanceAdminStubSettings().getEndpoint());
      assertEquals("explicit.example", options.getDatabaseAdminStubSettings().getUniverseDomain());
      assertEquals(
          "spanner.explicit.example:443", options.getDatabaseAdminStubSettings().getEndpoint());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testToBuilderClearUniverseDomainRespectsEnvironment() {
    useUniverseDomainEnvironment("env.example");
    try {
      SpannerOptions initial =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(NoCredentials.getInstance())
              .setEmulatorHost(null)
              .setUniverseDomain("explicit.example")
              .build();
      SpannerOptions cleared = initial.toBuilder().setUniverseDomain("").build();
      assertEquals("", cleared.getUniverseDomain());
      assertEquals("https://spanner.env.example", cleared.getHost());
      assertEquals("spanner.env.example:443", cleared.getEndpoint());
      assertEquals("env.example", cleared.getSpannerStubSettings().getUniverseDomain());
      assertEquals("spanner.env.example:443", cleared.getSpannerStubSettings().getEndpoint());
      assertEquals("env.example", cleared.getInstanceAdminStubSettings().getUniverseDomain());
      assertEquals("spanner.env.example:443", cleared.getInstanceAdminStubSettings().getEndpoint());
      assertEquals("env.example", cleared.getDatabaseAdminStubSettings().getUniverseDomain());
      assertEquals("spanner.env.example:443", cleared.getDatabaseAdminStubSettings().getEndpoint());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testToBuilderClearUniverseDomainFallsBackToDefaultWhenEnvUnsetOrEmpty() {
    for (String envUniverseDomain : new String[] {null, ""}) {
      useUniverseDomainEnvironment(envUniverseDomain);
      try {
        SpannerOptions initial =
            SpannerOptions.newBuilder()
                .setProjectId("test-project")
                .setCredentials(NoCredentials.getInstance())
                .setEmulatorHost(null)
                .setUniverseDomain("explicit.example")
                .build();
        SpannerOptions cleared = initial.toBuilder().setUniverseDomain("").build();
        assertEquals("", cleared.getUniverseDomain());
        assertEquals("googleapis.com", cleared.getResolvedUniverseDomain());
        assertEquals("https://spanner.googleapis.com", cleared.getHost());
        assertEquals("spanner.googleapis.com:443", cleared.getEndpoint());
        assertEquals("googleapis.com", cleared.getSpannerStubSettings().getUniverseDomain());
        assertEquals("spanner.googleapis.com:443", cleared.getSpannerStubSettings().getEndpoint());
        assertEquals("googleapis.com", cleared.getInstanceAdminStubSettings().getUniverseDomain());
        assertEquals(
            "spanner.googleapis.com:443", cleared.getInstanceAdminStubSettings().getEndpoint());
        assertEquals("googleapis.com", cleared.getDatabaseAdminStubSettings().getUniverseDomain());
        assertEquals(
            "spanner.googleapis.com:443", cleared.getDatabaseAdminStubSettings().getEndpoint());
      } finally {
        SpannerOptions.useDefaultEnvironment();
      }
    }
  }

  @Test
  public void testHasValidUniverseDomainWithEnvironmentAndClearedBuilder() throws IOException {
    Credentials partnerCredentials = credentialsForUniverseDomain("partner.example");
    Credentials gduCredentials = credentialsForUniverseDomain("googleapis.com");

    useUniverseDomainEnvironment("partner.example");
    try {
      SpannerOptions matchingOptions =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(partnerCredentials)
              .setEmulatorHost(null)
              .build();
      assertTrue(matchingOptions.hasValidUniverseDomain());

      SpannerOptions mismatchedOptions =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(gduCredentials)
              .setEmulatorHost(null)
              .build();
      assertFalse(mismatchedOptions.hasValidUniverseDomain());

      SpannerOptions clearedMatching =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(partnerCredentials)
              .setEmulatorHost(null)
              .setUniverseDomain("explicit.example")
              .build()
              .toBuilder()
              .setUniverseDomain("")
              .build();
      assertTrue(clearedMatching.hasValidUniverseDomain());

      SpannerOptions clearedMismatched =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(gduCredentials)
              .setEmulatorHost(null)
              .setUniverseDomain("explicit.example")
              .build()
              .toBuilder()
              .setUniverseDomain("")
              .build();
      assertFalse(clearedMismatched.hasValidUniverseDomain());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }

    for (String envUniverseDomain : new String[] {null, ""}) {
      useUniverseDomainEnvironment(envUniverseDomain);
      try {
        SpannerOptions clearedGdu =
            SpannerOptions.newBuilder()
                .setProjectId("test-project")
                .setCredentials(gduCredentials)
                .setEmulatorHost(null)
                .setUniverseDomain("explicit.example")
                .build()
                .toBuilder()
                .setUniverseDomain("")
                .build();
        assertTrue(clearedGdu.hasValidUniverseDomain());

        SpannerOptions clearedPartner =
            SpannerOptions.newBuilder()
                .setProjectId("test-project")
                .setCredentials(partnerCredentials)
                .setEmulatorHost(null)
                .setUniverseDomain("explicit.example")
                .build()
                .toBuilder()
                .setUniverseDomain("")
                .build();
        assertFalse(clearedPartner.hasValidUniverseDomain());
      } finally {
        SpannerOptions.useDefaultEnvironment();
      }
    }
  }

  @Test
  public void testHasValidUniverseDomainWithApiKeyCredentialsAndEnvironment() throws IOException {
    useUniverseDomainEnvironment("partner.example");
    try {
      SpannerOptions options =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(ApiKeyCredentials.create("test-api-key"))
              .setEmulatorHost(null)
              .build();
      assertTrue(options.hasValidUniverseDomain());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  private static Credentials credentialsForUniverseDomain(String universeDomain) {
    return new GoogleCredentials(new AccessToken("test-token", null)) {
      @Override
      public String getUniverseDomain() {
        return universeDomain;
      }
    };
  }

  @Test
  public void testEmptyUniverseDomainEnvironmentVariableFallsBackToDefault() {
    useUniverseDomainEnvironment("");
    try {
      SpannerOptions options =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(NoCredentials.getInstance())
              .setEmulatorHost(null)
              .build();
      assertNull(options.getUniverseDomain());
      assertEquals("https://spanner.googleapis.com", options.getHost());
      assertEquals("spanner.googleapis.com:443", options.getEndpoint());
      assertEquals("googleapis.com", options.getSpannerStubSettings().getUniverseDomain());
      assertEquals("spanner.googleapis.com:443", options.getSpannerStubSettings().getEndpoint());
      assertEquals("googleapis.com", options.getInstanceAdminStubSettings().getUniverseDomain());
      assertEquals(
          "spanner.googleapis.com:443", options.getInstanceAdminStubSettings().getEndpoint());
      assertEquals("googleapis.com", options.getDatabaseAdminStubSettings().getUniverseDomain());
      assertEquals(
          "spanner.googleapis.com:443", options.getDatabaseAdminStubSettings().getEndpoint());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testResolveUniverseDomainPrecedenceAndValidation() {
    // Precedence: explicit > environment > googleapis.com.
    assertEquals("googleapis.com", SpannerOptions.resolveUniverseDomain(null, null));
    assertEquals("googleapis.com", SpannerOptions.resolveUniverseDomain("", null));
    assertEquals("googleapis.com", SpannerOptions.resolveUniverseDomain(null, ""));
    assertEquals("googleapis.com", SpannerOptions.resolveUniverseDomain("", ""));
    assertEquals("partner.example", SpannerOptions.resolveUniverseDomain(null, "partner.example"));
    assertEquals("partner.example", SpannerOptions.resolveUniverseDomain("", "partner.example"));
    assertEquals(
        "explicit.example",
        SpannerOptions.resolveUniverseDomain("explicit.example", "env.example"));
    assertEquals("explicit.example", SpannerOptions.resolveUniverseDomain("explicit.example", ""));

    IllegalArgumentException invalidEnvException =
        assertThrows(
            IllegalArgumentException.class,
            () -> SpannerOptions.resolveUniverseDomain(null, "evil.com/path"));
    assertTrue(invalidEnvException.getMessage().contains("Invalid universe domain"));

    IllegalArgumentException invalidConfiguredException =
        assertThrows(
            IllegalArgumentException.class,
            () -> SpannerOptions.resolveUniverseDomain("evil.com/path", "partner.example"));
    assertTrue(invalidConfiguredException.getMessage().contains("Invalid universe domain"));

    // End-to-end fail-closed validation across default, emulator, and explicit-host builders.
    useUniverseDomainEnvironment("evil.com/path");
    try {
      IllegalArgumentException defaultException =
          assertThrows(
              IllegalArgumentException.class,
              () ->
                  SpannerOptions.newBuilder()
                      .setProjectId("test-project")
                      .setCredentials(NoCredentials.getInstance())
                      .setEmulatorHost(null)
                      .build());
      assertTrue(defaultException.getMessage().contains("Invalid universe domain"));

      IllegalArgumentException emulatorException =
          assertThrows(
              IllegalArgumentException.class,
              () ->
                  SpannerOptions.newBuilder()
                      .setProjectId("test-project")
                      .setEmulatorHost("localhost:9010")
                      .build());
      assertTrue(emulatorException.getMessage().contains("Invalid universe domain"));

      IllegalArgumentException explicitHostException =
          assertThrows(
              IllegalArgumentException.class,
              () ->
                  SpannerOptions.newBuilder()
                      .setProjectId("test-project")
                      .setCredentials(NoCredentials.getInstance())
                      .setHost("https://custom.host")
                      .build());
      assertTrue(explicitHostException.getMessage().contains("Invalid universe domain"));
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testCloudMonitoringExporterHonorsResolvedUniverseDomain() throws Exception {
    for (String[] envAndExpected :
        new String[][] {{"partner.example", "partner.example"}, {"", "googleapis.com"}}) {
      String envUniverseDomain = envAndExpected[0];
      String expected = envAndExpected[1];
      useUniverseDomainEnvironment(envUniverseDomain);
      try {
        SpannerOptions options =
            SpannerOptions.newBuilder()
                .setProjectId("test-project")
                .setCredentials(NoCredentials.getInstance())
                .setEmulatorHost(null)
                .build();
        assertEquals(expected, options.getResolvedUniverseDomain());
        SpannerCloudMonitoringExporter exporter =
            SpannerCloudMonitoringExporter.create(
                () -> "test-project",
                NoCredentials.getInstance(),
                null,
                options.getResolvedUniverseDomain());
        try {
          assertEquals(
              expected, exporter.getMetricServiceClient().getSettings().getUniverseDomain());
          assertEquals(
              "monitoring." + expected + ":443",
              exporter.getMetricServiceClient().getSettings().getEndpoint());
        } finally {
          exporter.shutdown();
        }
      } finally {
        SpannerOptions.useDefaultEnvironment();
      }
    }
  }

  @Test
  public void testBuiltInMetricsProviderReceivesResolvedUniverseDomain() {
    for (String[] envAndExpected :
        new String[][] {{"partner.example", "partner.example"}, {"", "googleapis.com"}}) {
      String envUniverseDomain = envAndExpected[0];
      String expected = envAndExpected[1];
      SpannerOptions.useEnvironment(
          new SpannerOptions.SpannerEnvironment() {
            @Override
            public @Nullable String getUniverseDomain() {
              return envUniverseDomain;
            }

            @Override
            public boolean isEnableGRPCBuiltInMetrics() {
              return true;
            }
          });
      try {
        // The Cloud Monitoring tracer factory is only created for clients with real credentials.
        SpannerOptions options =
            SpannerOptions.newBuilder()
                .setProjectId("test-project")
                .setCredentials(GoogleCredentials.create(new AccessToken("test-token", null)))
                .setEmulatorHost(null)
                .build();
        assertNull(options.getUniverseDomain());
        RecordingBuiltInMetricsProvider provider = new RecordingBuiltInMetricsProvider();
        options.builtInMetricsProvider = provider;

        options.getBuiltInOpenTelemetry();
        options.enablegRPCMetrics(
            InstantiatingGrpcChannelProvider.newBuilder(), /* isEmulatorEnabled= */ false);
        options.getApiTracerFactory(/* isAdminClient= */ false, /* isEmulatorEnabled= */ false);

        assertEquals(Arrays.asList(expected, expected, expected), provider.universeDomains);
      } finally {
        SpannerOptions.useDefaultEnvironment();
      }
    }
  }

  @Test
  public void testEnableGrpcMetricsSkipsCloudMonitoringWithNoCredentials() {
    useGrpcBuiltInMetricsEnabledEnvironment();
    try {
      SpannerOptions options =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(NoCredentials.getInstance())
              .setEmulatorHost(null)
              .setBuiltInMetricsEnabled(true)
              .build();
      RecordingBuiltInMetricsProvider provider = new RecordingBuiltInMetricsProvider();
      options.builtInMetricsProvider = provider;
      InstantiatingGrpcChannelProvider.Builder channelProviderBuilder =
          InstantiatingGrpcChannelProvider.newBuilder();

      options.enablegRPCMetrics(channelProviderBuilder, /* isEmulatorEnabled= */ false);

      assertTrue(provider.credentials.isEmpty());
      assertNull(channelProviderBuilder.getChannelConfigurator());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testEnableGrpcMetricsSkipsCloudMonitoringWithUsePlainText() {
    useGrpcBuiltInMetricsEnabledEnvironment();
    try {
      SpannerOptions options =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setHost("http://localhost:1234")
              .usePlainText()
              .setEmulatorHost(null)
              .setBuiltInMetricsEnabled(true)
              .build();
      RecordingBuiltInMetricsProvider provider = new RecordingBuiltInMetricsProvider();
      options.builtInMetricsProvider = provider;
      InstantiatingGrpcChannelProvider.Builder channelProviderBuilder =
          InstantiatingGrpcChannelProvider.newBuilder();

      options.enablegRPCMetrics(channelProviderBuilder, /* isEmulatorEnabled= */ false);

      assertTrue(provider.credentials.isEmpty());
      assertNull(channelProviderBuilder.getChannelConfigurator());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testEnableGrpcMetricsKeepsCustomSinkWithNoCredentials() {
    useGrpcBuiltInMetricsEnabledEnvironment();
    OpenTelemetrySdk customOpenTelemetry =
        OpenTelemetrySdk.builder()
            .setMeterProvider(
                SdkMeterProvider.builder()
                    .registerMetricReader(InMemoryMetricReader.create())
                    .build())
            .build();
    try {
      SpannerOptions options =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(NoCredentials.getInstance())
              .setEmulatorHost(null)
              .setBuiltInMetricsEnabled(true)
              .setClientMetricsProvider(
                  CustomOpenTelemetryMetricsProvider.create(customOpenTelemetry))
              .build();
      RecordingBuiltInMetricsProvider provider = new RecordingBuiltInMetricsProvider();
      options.builtInMetricsProvider = provider;
      InstantiatingGrpcChannelProvider.Builder channelProviderBuilder =
          InstantiatingGrpcChannelProvider.newBuilder();

      options.enablegRPCMetrics(channelProviderBuilder, /* isEmulatorEnabled= */ false);

      assertTrue(provider.credentials.isEmpty());
      assertEquals(Collections.singletonList(customOpenTelemetry), provider.customOpenTelemetries);
      assertNotNull(channelProviderBuilder.getChannelConfigurator());
    } finally {
      customOpenTelemetry.close();
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testNoCredentialsFirstDoesNotLockSingletonForLaterAuthenticatedClient() {
    useGrpcBuiltInMetricsEnabledEnvironment();
    try {
      RecordingBuiltInMetricsProvider sharedProvider = new RecordingBuiltInMetricsProvider();
      SpannerOptions noCredOptions =
          SpannerOptions.newBuilder()
              .setProjectId("unauth-project")
              .setCredentials(NoCredentials.getInstance())
              .setEmulatorHost(null)
              .setBuiltInMetricsEnabled(true)
              .build();
      noCredOptions.builtInMetricsProvider = sharedProvider;

      GoogleCredentials googleCredentials =
          GoogleCredentials.create(new AccessToken("test-token", null));
      SpannerOptions authOptions =
          SpannerOptions.newBuilder()
              .setProjectId("auth-project")
              .setCredentials(googleCredentials)
              .setEmulatorHost(null)
              .setBuiltInMetricsEnabled(true)
              .build();
      authOptions.builtInMetricsProvider = sharedProvider;

      noCredOptions.enablegRPCMetrics(
          InstantiatingGrpcChannelProvider.newBuilder(), /* isEmulatorEnabled= */ false);
      assertNull(noCredOptions.getBuiltInOpenTelemetry());

      authOptions.enablegRPCMetrics(
          InstantiatingGrpcChannelProvider.newBuilder(), /* isEmulatorEnabled= */ false);
      assertNotNull(authOptions.getBuiltInOpenTelemetry());

      assertEquals(Arrays.asList(googleCredentials, googleCredentials), sharedProvider.credentials);
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testEnableGrpcMetricsRespectsJmhOverrideWithNoCredentials() {
    useGrpcBuiltInMetricsEnabledEnvironment();
    String previousJmhEnabled = System.getProperty("jmh.enabled");
    System.setProperty("jmh.enabled", "true");
    try {
      SpannerOptions options =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(NoCredentials.getInstance())
              .setEmulatorHost(null)
              .setBuiltInMetricsEnabled(true)
              .build();
      RecordingBuiltInMetricsProvider provider = new RecordingBuiltInMetricsProvider();
      options.builtInMetricsProvider = provider;

      options.enablegRPCMetrics(
          InstantiatingGrpcChannelProvider.newBuilder(), /* isEmulatorEnabled= */ false);
      assertNotNull(options.getBuiltInOpenTelemetry());

      assertEquals(
          Arrays.asList(NoCredentials.getInstance(), NoCredentials.getInstance()),
          provider.credentials);
    } finally {
      if (previousJmhEnabled == null) {
        System.clearProperty("jmh.enabled");
      } else {
        System.setProperty("jmh.enabled", previousJmhEnabled);
      }
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testGetBuiltInOpenTelemetryReturnsNullWithoutCredentialsOrWhenDisabled() {
    useGrpcBuiltInMetricsEnabledEnvironment();
    try {
      RecordingBuiltInMetricsProvider provider = new RecordingBuiltInMetricsProvider();

      SpannerOptions noCredOptions =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(NoCredentials.getInstance())
              .setEmulatorHost(null)
              .setBuiltInMetricsEnabled(true)
              .build();
      noCredOptions.builtInMetricsProvider = provider;
      assertNull(noCredOptions.getBuiltInOpenTelemetry());

      SpannerOptions disabledOptions =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(GoogleCredentials.create(new AccessToken("test-token", null)))
              .setEmulatorHost(null)
              .setBuiltInMetricsEnabled(false)
              .build();
      disabledOptions.builtInMetricsProvider = provider;
      assertNull(disabledOptions.getBuiltInOpenTelemetry());

      SpannerOptions nullCredOptions =
          new TestSpannerOptions(
              SpannerOptions.newBuilder()
                  .setProjectId("test-project")
                  .setCredentials(GoogleCredentials.create(new AccessToken("test-token", null)))
                  .setEmulatorHost(null)
                  .setBuiltInMetricsEnabled(true)) {
            @Override
            public Credentials getCredentials() {
              return null;
            }
          };
      nullCredOptions.builtInMetricsProvider = provider;
      assertNull(nullCredOptions.getBuiltInOpenTelemetry());
      nullCredOptions.enablegRPCMetrics(
          InstantiatingGrpcChannelProvider.newBuilder(), /* isEmulatorEnabled= */ false);

      assertTrue(provider.credentials.isEmpty());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  private static void useGrpcBuiltInMetricsEnabledEnvironment() {
    SpannerOptions.useEnvironment(
        new SpannerOptions.SpannerEnvironment() {
          @Override
          public boolean isEnableGRPCBuiltInMetrics() {
            return true;
          }
        });
  }

  @Test
  public void testBuiltInMetricsDisabledForCustomHostWithoutExplicitTarget() {
    useGrpcBuiltInMetricsEnabledEnvironment();
    try {
      SpannerOptions options =
          SpannerOptions.newBuilder()
              .setProjectId("tpc-project")
              .setEmulatorHost(null)
              .setHost("https://spanner.tpc.example")
              .setCredentials(GoogleCredentials.create(new AccessToken("test-token", null)))
              .build();
      assertFalse(options.isEnableBuiltInMetrics());
      assertFalse(options.isEnableChannelPoolBuiltInMetrics());

      RecordingBuiltInMetricsProvider provider = new RecordingBuiltInMetricsProvider();
      options.builtInMetricsProvider = provider;

      assertNull(options.getBuiltInOpenTelemetry());
      options.enablegRPCMetrics(
          InstantiatingGrpcChannelProvider.newBuilder(), /* isEmulatorEnabled= */ false);
      options.getApiTracerFactory(/* isAdminClient= */ false, /* isEmulatorEnabled= */ false);
      options.initializeBuiltInMetrics(DatabaseId.of("tpc-project", "i", "d"));

      assertTrue(provider.universeDomains.isEmpty());
      assertTrue(provider.fallbackProjects.isEmpty());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testBuiltInMetricsEnabledForDefaultUniverseHosts() {
    SpannerOptions.useEnvironment(new SpannerOptions.SpannerEnvironment() {});
    try {
      String[] defaultUniverseHosts = {
        null,
        "",
        "https://spanner.googleapis.com",
        "https://SPANNER.GOOGLEAPIS.COM:443/",
        "https://spanner.us-central1.rep.googleapis.com",
        "https://private.googleapis.com",
        "https://restricted.googleapis.com",
      };
      for (String host : defaultUniverseHosts) {
        SpannerOptions options =
            SpannerOptions.newBuilder()
                .setProjectId("test-project")
                .setCredentials(NoCredentials.getInstance())
                .setEmulatorHost(null)
                .setHost(host)
                .build();
        assertTrue(
            "Expected built-in metrics enabled for host: " + host,
            options.isEnableBuiltInMetrics());
      }
      // Contrast check: ensure the default-universe allowlist is not vacuously true for all hosts.
      SpannerOptions nonDefaultHost =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(NoCredentials.getInstance())
              .setEmulatorHost(null)
              .setHost("https://spanner.tpc.example")
              .build();
      assertFalse(nonDefaultHost.isEnableBuiltInMetrics());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testBuiltInMetricsFailClosedForSpoofedAndMalformedHosts() {
    SpannerOptions.useEnvironment(new SpannerOptions.SpannerEnvironment() {});
    try {
      String[] nonDefaultOrMalformedHosts = {
        "https://spanner.googleapis.com.evil.com",
        "https://googleapis.com",
        "https://.googleapis.com",
        "http://localhost:9010",
        "spanner.googleapis.com:443",
        "not-a-url",
      };
      for (String host : nonDefaultOrMalformedHosts) {
        SpannerOptions options =
            SpannerOptions.newBuilder()
                .setProjectId("test-project")
                .setCredentials(NoCredentials.getInstance())
                .setEmulatorHost(null)
                .setHost(host)
                .build();
        assertFalse(
            "Expected built-in metrics disabled for host: " + host,
            options.isEnableBuiltInMetrics());
      }
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testBuiltInMetricsEnabledForCustomHostWithExplicitTarget() {
    SpannerOptions.useEnvironment(new SpannerOptions.SpannerEnvironment() {});
    try {
      SpannerOptions withBuilderUniverse =
          SpannerOptions.newBuilder()
              .setProjectId("tpc-project")
              .setEmulatorHost(null)
              .setHost("https://spanner.tpc.example")
              .setUniverseDomain("tpc.example")
              .setCredentials(NoCredentials.getInstance())
              .build();
      assertTrue(withBuilderUniverse.isEnableBuiltInMetrics());

      @SuppressWarnings("deprecation")
      SpannerOptions withBuilderMonitoringHost =
          SpannerOptions.newBuilder()
              .setProjectId("tpc-project")
              .setEmulatorHost(null)
              .setHost("https://spanner.tpc.example")
              .setMonitoringHost("monitoring.tpc.example:443")
              .setCredentials(NoCredentials.getInstance())
              .build();
      assertTrue(withBuilderMonitoringHost.isEnableBuiltInMetrics());

      @SuppressWarnings("deprecation")
      SpannerOptions withBlankMonitoringHost =
          SpannerOptions.newBuilder()
              .setProjectId("tpc-project")
              .setEmulatorHost(null)
              .setHost("https://spanner.tpc.example")
              .setMonitoringHost("   ")
              .setCredentials(NoCredentials.getInstance())
              .build();
      assertFalse(withBlankMonitoringHost.isEnableBuiltInMetrics());

      SpannerOptions withEmptyUniverse =
          SpannerOptions.newBuilder()
              .setProjectId("tpc-project")
              .setEmulatorHost(null)
              .setHost("https://spanner.tpc.example")
              .setUniverseDomain("")
              .setCredentials(NoCredentials.getInstance())
              .build();
      assertFalse(withEmptyUniverse.isEnableBuiltInMetrics());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }

    useUniverseDomainEnvironment("tpc.example");
    try {
      SpannerOptions withEnvUniverse =
          SpannerOptions.newBuilder()
              .setProjectId("tpc-project")
              .setEmulatorHost(null)
              .setHost("https://spanner.tpc.example")
              .setCredentials(NoCredentials.getInstance())
              .build();
      assertTrue(withEnvUniverse.isEnableBuiltInMetrics());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }

    SpannerOptions.useEnvironment(
        new SpannerOptions.SpannerEnvironment() {
          @Override
          public String getMonitoringHost() {
            return "monitoring.tpc.example:443";
          }
        });
    try {
      SpannerOptions withEnvMonitoringHost =
          SpannerOptions.newBuilder()
              .setProjectId("tpc-project")
              .setEmulatorHost(null)
              .setHost("https://spanner.tpc.example")
              .setCredentials(NoCredentials.getInstance())
              .build();
      assertTrue(withEnvMonitoringHost.isEnableBuiltInMetrics());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testCustomHostToBuilderReEvaluatesBuiltInMetrics() {
    SpannerOptions.useEnvironment(new SpannerOptions.SpannerEnvironment() {});
    try {
      SpannerOptions customOnly =
          SpannerOptions.newBuilder()
              .setProjectId("tpc-project")
              .setEmulatorHost(null)
              .setHost("https://spanner.tpc.example")
              .setCredentials(NoCredentials.getInstance())
              .build();
      assertFalse(customOnly.isEnableBuiltInMetrics());

      assertTrue(
          customOnly.toBuilder().setUniverseDomain("tpc.example").build().isEnableBuiltInMetrics());
      @SuppressWarnings("deprecation")
      SpannerOptions withMonitoringHost =
          customOnly.toBuilder().setMonitoringHost("monitoring.tpc.example:443").build();
      assertTrue(withMonitoringHost.isEnableBuiltInMetrics());
      assertTrue(customOnly.toBuilder().setHost(null).build().isEnableBuiltInMetrics());

      SpannerOptions explicitlyDisabled =
          SpannerOptions.newBuilder()
              .setProjectId("tpc-project")
              .setEmulatorHost(null)
              .setHost("https://spanner.tpc.example")
              .setBuiltInMetricsEnabled(false)
              .setCredentials(NoCredentials.getInstance())
              .build();
      assertFalse(
          explicitlyDisabled.toBuilder()
              .setUniverseDomain("tpc.example")
              .build()
              .isEnableBuiltInMetrics());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testCustomHostPreservesCustomMetricsProvider() {
    SpannerOptions.useEnvironment(new SpannerOptions.SpannerEnvironment() {});
    try {
      CustomOpenTelemetryMetricsProvider provider =
          CustomOpenTelemetryMetricsProvider.create(OpenTelemetry.noop());
      SpannerOptions options =
          SpannerOptions.newBuilder()
              .setProjectId("tpc-project")
              .setEmulatorHost(null)
              .setHost("https://spanner.tpc.example")
              .setCredentials(NoCredentials.getInstance())
              .setClientMetricsProvider(provider)
              .build();
      assertFalse(options.isEnableBuiltInMetrics());
      assertSame(provider, options.getClientMetricsProvider());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testCustomHostWarningSuppressedForEmulatorAndPlainText() {
    SpannerOptions.useEnvironment(new SpannerOptions.SpannerEnvironment() {});
    Logger spannerOptionsLogger = Logger.getLogger(SpannerOptions.class.getName());
    Level previousLevel = spannerOptionsLogger.getLevel();
    List<LogRecord> warnings = new ArrayList<>();
    Handler handler =
        new Handler() {
          @Override
          public void publish(LogRecord record) {
            if (record.getLevel().intValue() >= Level.WARNING.intValue()) {
              warnings.add(record);
            }
          }

          @Override
          public void flush() {}

          @Override
          public void close() {}
        };
    spannerOptionsLogger.addHandler(handler);
    spannerOptionsLogger.setLevel(Level.WARNING);
    try {
      SpannerOptions customHttps =
          SpannerOptions.newBuilder()
              .setProjectId("tpc-project")
              .setEmulatorHost(null)
              .setHost("https://spanner.tpc.example")
              .setCredentials(GoogleCredentials.create(new AccessToken("test-token", null)))
              .build();
      assertFalse(customHttps.isEnableBuiltInMetrics());
      assertEquals(1, warnings.size());
      assertTrue(warnings.get(0).getMessage().contains("Disabling built-in Cloud Monitoring"));

      warnings.clear();
      SpannerOptions emulatorOptions =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setEmulatorHost("localhost:9010")
              .build();
      assertFalse(emulatorOptions.isEnableBuiltInMetrics());
      assertTrue(warnings.isEmpty());

      SpannerOptions plainTextCustom =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setHost("http://localhost:9010")
              .usePlainText()
              .build();
      assertFalse(plainTextCustom.isEnableBuiltInMetrics());
      assertTrue(warnings.isEmpty());
    } finally {
      spannerOptionsLogger.removeHandler(handler);
      spannerOptionsLogger.setLevel(previousLevel);
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testCustomHostEdgeCasesAndToBuilderFromDefaultHost() {
    SpannerOptions.useEnvironment(new SpannerOptions.SpannerEnvironment() {});
    try {
      // Additional fail-closed malformed / spoofed host shapes.
      String[] additionalNonDefaultHosts = {
        "   ", "https://spanner.googleapis.com@evil.com", "https://spanner.googleapis.com.",
      };
      for (String host : additionalNonDefaultHosts) {
        SpannerOptions options =
            SpannerOptions.newBuilder()
                .setProjectId("test-project")
                .setCredentials(NoCredentials.getInstance())
                .setEmulatorHost(null)
                .setHost(host)
                .build();
        assertFalse(
            "Expected built-in metrics disabled for host: " + host,
            options.isEnableBuiltInMetrics());
      }

      // Explicit opt-in to googleapis.com keeps built-in metrics enabled on a custom host.
      SpannerOptions explicitDefaultUniverse =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(NoCredentials.getInstance())
              .setEmulatorHost(null)
              .setHost("https://spanner.tpc.example")
              .setUniverseDomain("googleapis.com")
              .build();
      assertTrue(explicitDefaultUniverse.isEnableBuiltInMetrics());

      // Reverse toBuilder() transition: default host (enabled) -> custom host (disabled).
      SpannerOptions defaultOptions =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setCredentials(NoCredentials.getInstance())
              .setEmulatorHost(null)
              .build();
      assertTrue(defaultOptions.isEnableBuiltInMetrics());
      assertFalse(
          defaultOptions.toBuilder()
              .setHost("https://spanner.tpc.example")
              .build()
              .isEnableBuiltInMetrics());

      // Clearing monitoringHost via toBuilder() re-disables built-in metrics on a custom host.
      @SuppressWarnings("deprecation")
      SpannerOptions withMonitoringHost =
          SpannerOptions.newBuilder()
              .setProjectId("tpc-project")
              .setEmulatorHost(null)
              .setHost("https://spanner.tpc.example")
              .setMonitoringHost("monitoring.tpc.example:443")
              .setCredentials(NoCredentials.getInstance())
              .build();
      assertTrue(withMonitoringHost.isEnableBuiltInMetrics());
      @SuppressWarnings("deprecation")
      SpannerOptions clearedMonitoringHost =
          withMonitoringHost.toBuilder().setMonitoringHost(null).build();
      assertFalse(clearedMonitoringHost.isEnableBuiltInMetrics());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  /**
   * Records the universe domain, credentials, custom OpenTelemetry instances, and fallback projects
   * that {@link SpannerOptions} passes to the metrics provider.
   */
  private static final class RecordingBuiltInMetricsProvider extends BuiltInMetricsProvider {
    private final List<String> universeDomains = new ArrayList<>();
    private final List<Credentials> credentials = new ArrayList<>();
    private final List<OpenTelemetry> customOpenTelemetries = new ArrayList<>();
    private final List<String> fallbackProjects = new ArrayList<>();

    @Override
    synchronized OpenTelemetry getOrCreateOpenTelemetry(
        String projectId, Credentials credentials, String monitoringHost, String universeDomain) {
      universeDomains.add(universeDomain);
      this.credentials.add(credentials);
      return OpenTelemetry.noop();
    }

    @Override
    void enableGrpcMetrics(
        InstantiatingGrpcChannelProvider.Builder channelProviderBuilder,
        String projectId,
        Credentials credentials,
        String monitoringHost,
        String universeDomain) {
      universeDomains.add(universeDomain);
      this.credentials.add(credentials);
    }

    @Override
    void enableGrpcMetrics(
        InstantiatingGrpcChannelProvider.Builder channelProviderBuilder,
        OpenTelemetry openTelemetry) {
      customOpenTelemetries.add(openTelemetry);
      super.enableGrpcMetrics(channelProviderBuilder, openTelemetry);
    }

    @Override
    synchronized void setProjectIdIfAbsent(String projectId) {
      fallbackProjects.add(projectId);
    }
  }

  private static void useUniverseDomainEnvironment(@Nullable String universeDomain) {
    SpannerOptions.useEnvironment(
        new SpannerOptions.SpannerEnvironment() {
          @Override
          public @Nullable String getUniverseDomain() {
            return universeDomain;
          }
        });
  }
}
