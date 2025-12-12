/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.grpc;

import static com.google.cloud.grpc.GcpMultiEndpointChannel.ME_CONTEXT_KEY;
import static com.google.cloud.grpc.GcpMultiEndpointChannel.ME_KEY;
import static com.google.cloud.spanner.SpannerOptions.CALL_CONTEXT_CONFIGURATOR_KEY;
import static com.google.common.base.Preconditions.checkState;
import static com.google.common.truth.Truth.assertThat;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.google.api.client.util.Sleeper;
import com.google.api.core.ApiFunction;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.grpc.GcpManagedChannel.ChannelRef;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpChannelPoolOptions;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpMetricsOptions;
import com.google.cloud.grpc.proto.ApiConfig;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Instance;
import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.InstanceConfig;
import com.google.cloud.spanner.InstanceConfigId;
import com.google.cloud.spanner.InstanceId;
import com.google.cloud.spanner.InstanceInfo;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.SpannerOptions.CallContextConfigurator;
import com.google.common.collect.Iterators;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.Empty;
import com.google.protobuf.util.JsonFormat;
import com.google.protobuf.util.JsonFormat.Parser;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.instance.v1.CreateInstanceMetadata;
import com.google.spanner.v1.BatchCreateSessionsRequest;
import com.google.spanner.v1.BatchCreateSessionsResponse;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.DeleteSessionRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest.Statement;
import com.google.spanner.v1.ExecuteBatchDmlResponse;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.GetSessionRequest;
import com.google.spanner.v1.ListSessionsRequest;
import com.google.spanner.v1.ListSessionsResponse;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.PartitionQueryRequest;
import com.google.spanner.v1.PartitionResponse;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.SpannerGrpc;
import com.google.spanner.v1.SpannerGrpc.SpannerBlockingStub;
import com.google.spanner.v1.SpannerGrpc.SpannerFutureStub;
import com.google.spanner.v1.SpannerGrpc.SpannerStub;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionOptions.ReadOnly;
import com.google.spanner.v1.TransactionOptions.ReadWrite;
import com.google.spanner.v1.TransactionSelector;
import io.grpc.CallOptions;
import io.grpc.ConnectivityState;
import io.grpc.Context;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.grpc.StatusRuntimeException;
import io.grpc.auth.MoreCallCredentials;
import io.grpc.stub.StreamObserver;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for GcpManagedChannel with Spanner. */
@RunWith(JUnit4.class)
public final class SpannerIntegrationTest {

  private static final Logger testLogger = Logger.getLogger(GcpManagedChannel.class.getName());
  private final List<LogRecord> logRecords = new LinkedList<>();
  private static final String GCP_PROJECT_ID = System.getenv("GCP_PROJECT_ID");
  private static final String INSTANCE_ID = "grpc-gcp-test-instance";
  private static final String DB_NAME = "grpc-gcp-test-db";

  private static final String SPANNER_TARGET = "spanner.googleapis.com";
  private static final String USERNAME = "test_user";
  private static final String DATABASE_PATH =
      String.format("projects/%s/instances/%s/databases/%s", GCP_PROJECT_ID, INSTANCE_ID, DB_NAME);
  private static final String API_FILE = "spannertest.json";

  private static final int MAX_CHANNEL = 3;
  private static final int MAX_STREAM = 2;
  private static boolean resourcesCreated = false;

  private static final ManagedChannelBuilder<?> builder =
      ManagedChannelBuilder.forAddress(SPANNER_TARGET, 443);
  private GcpManagedChannel gcpChannel;
  private GcpManagedChannel gcpChannelBRR;

  final String leaderME = "leader";
  final String followerME = "follower";

  final String commonKey = "common_key";
  final String commonValue = "common_value";

  private void sleep(long millis) throws InterruptedException {
    Sleeper.DEFAULT.sleep(millis);
  }

  @BeforeClass
  public static void beforeClass() {
    Assume.assumeTrue(
        "Need to provide GCP_PROJECT_ID for SpannerIntegrationTest", GCP_PROJECT_ID != null);
    SpannerOptions options = SpannerOptions.newBuilder().setProjectId(GCP_PROJECT_ID).build();
    try (Spanner spanner = options.getService()) {
      InstanceAdminClient instanceAdminClient = spanner.getInstanceAdminClient();
      InstanceId instanceId = InstanceId.of(GCP_PROJECT_ID, INSTANCE_ID);
      initializeInstance(instanceAdminClient, instanceId);
      DatabaseAdminClient databaseAdminClient = spanner.getDatabaseAdminClient();
      DatabaseId databaseId = DatabaseId.of(instanceId, DB_NAME);
      initializeDatabase(databaseAdminClient, databaseId);
      DatabaseClient databaseClient = spanner.getDatabaseClient(databaseId);
      initializeTable(databaseClient);
      resourcesCreated = true;
    }
  }

  private String lastLogMessage() {
    return lastLogMessage(1);
  }

  private String lastLogMessage(int nthFromLast) {
    return logRecords.get(logRecords.size() - nthFromLast).getMessage();
  }

  private Level lastLogLevel() {
    return logRecords.get(logRecords.size() - 1).getLevel();
  }

  private final Handler testLogHandler =
      new Handler() {
        @Override
        public synchronized void publish(LogRecord record) {
          logRecords.add(record);
        }

        @Override
        public void flush() {}

        @Override
        public void close() throws SecurityException {}
      };

  private static void initializeTable(DatabaseClient databaseClient) {
    List<Mutation> mutations =
        Arrays.asList(
            Mutation.newInsertBuilder("Users")
                .set("UserId")
                .to(1)
                .set("UserName")
                .to(USERNAME)
                .build());
    databaseClient.write(mutations);
  }

  private static void initializeInstance(
      InstanceAdminClient instanceAdminClient, InstanceId instanceId) {
    InstanceConfig instanceConfig =
        Iterators.get(instanceAdminClient.listInstanceConfigs().iterateAll().iterator(), 0, null);
    checkState(instanceConfig != null, "No instance configs found");

    InstanceConfigId configId = instanceConfig.getId();
    InstanceInfo instance =
        InstanceInfo.newBuilder(instanceId)
            .setNodeCount(1)
            .setDisplayName("grpc-gcp test instance")
            .setInstanceConfigId(configId)
            .build();
    OperationFuture<Instance, CreateInstanceMetadata> op =
        instanceAdminClient.createInstance(instance);
    try {
      op.get();
    } catch (Exception e) {
      throw SpannerExceptionFactory.newSpannerException(e);
    }
  }

  private static void initializeDatabase(
      DatabaseAdminClient databaseAdminClient, DatabaseId databaseId) {
    OperationFuture<Database, CreateDatabaseMetadata> op =
        databaseAdminClient.createDatabase(
            databaseId.getInstanceId().getInstance(),
            databaseId.getDatabase(),
            Arrays.asList(
                "CREATE TABLE Users ("
                    + "  UserId INT64 NOT NULL,"
                    + "  UserName STRING(1024)"
                    + ") PRIMARY KEY (UserId)"));
    try {
      op.get();
    } catch (Exception e) {
      throw SpannerExceptionFactory.newSpannerException(e);
    }
  }

  @AfterClass
  public static void afterClass() {
    if (GCP_PROJECT_ID == null || !resourcesCreated) {
      return;
    }
    SpannerOptions options = SpannerOptions.newBuilder().setProjectId(GCP_PROJECT_ID).build();
    try (Spanner spanner = options.getService()) {
      InstanceAdminClient instanceAdminClient = spanner.getInstanceAdminClient();
      InstanceId instanceId = InstanceId.of(GCP_PROJECT_ID, INSTANCE_ID);
      cleanUpInstance(instanceAdminClient, instanceId);
    } catch (Exception ignored) {
      // Ignore cleanup failures in test environments.
    }
  }

  private static void cleanUpInstance(
      InstanceAdminClient instanceAdminClient, InstanceId instanceId) {
    instanceAdminClient.deleteInstance(instanceId.getInstance());
  }

  private static GoogleCredentials getCreds() {
    GoogleCredentials creds;
    try {
      creds = GoogleCredentials.getApplicationDefault();
    } catch (Exception e) {
      return null;
    }
    return creds;
  }

  /** Helper functions for BlockingStub. */
  private SpannerBlockingStub getSpannerBlockingStub() {
    GoogleCredentials creds = getCreds();
    SpannerBlockingStub stub =
        SpannerGrpc.newBlockingStub(gcpChannel)
            .withCallCredentials(MoreCallCredentials.from(creds));
    return stub;
  }

  private static void deleteSession(SpannerBlockingStub stub, Session session) {
    if (session != null) {
      stub.deleteSession(DeleteSessionRequest.newBuilder().setName(session.getName()).build());
    }
  }

  /** Helper functions for Stub(async calls). */
  private SpannerStub getSpannerStub() {
    GoogleCredentials creds = getCreds();
    SpannerStub stub =
        SpannerGrpc.newStub(gcpChannel).withCallCredentials(MoreCallCredentials.from(creds));
    return stub;
  }

  /** A wrapper of checking the status of each channelRef in the gcpChannel. */
  private void checkChannelRefs(int channels, int streams, int affinities) {
    checkChannelRefs(gcpChannel, channels, streams, affinities);
  }

  private void checkChannelRefs(
      GcpManagedChannel gcpChannel, int channels, int streams, int affinities) {
    assertEquals("Channel pool size mismatch.", channels, gcpChannel.channelRefs.size());
    for (int i = 0; i < channels; i++) {
      assertEquals(
          String.format("Channel %d streams mismatch.", i),
          streams,
          gcpChannel.channelRefs.get(i).getActiveStreamsCount());
      assertEquals(
          String.format("Channel %d affinities mismatch.", i),
          affinities,
          gcpChannel.channelRefs.get(i).getAffinityCount());
    }
  }

  private void checkChannelRefs(int[] streams, int[] affinities) {
    for (int i = 0; i < streams.length; i++) {
      assertEquals(
          String.format("Channel %d streams mismatch.", i),
          streams[i],
          gcpChannel.channelRefs.get(i).getActiveStreamsCount());
      assertEquals(
          String.format("Channel %d affinities mismatch.", i),
          affinities[i],
          gcpChannel.channelRefs.get(i).getAffinityCount());
    }
  }

  private List<String> createAsyncSessions(SpannerStub stub) throws Exception {
    List<AsyncResponseObserver<Session>> resps = new ArrayList<>();
    List<String> respNames = new ArrayList<>();
    // Check the state of the channel first.
    assertEquals(ConnectivityState.IDLE, gcpChannel.getState(false));

    // Check CreateSession with multiple channels and streams,
    CreateSessionRequest req = CreateSessionRequest.newBuilder().setDatabase(DATABASE_PATH).build();
    for (int i = 0; i < MAX_CHANNEL * MAX_STREAM; i++) {
      AsyncResponseObserver<Session> resp = new AsyncResponseObserver<>();
      stub.createSession(req, resp);
      resps.add(resp);
    }
    checkChannelRefs(MAX_CHANNEL, MAX_STREAM, 0);
    for (AsyncResponseObserver<Session> resp : resps) {
      respNames.add(resp.get().getName());
    }
    // Since createSession will bind the key, check the number of keys bound with channels.
    assertEquals(ConnectivityState.READY, gcpChannel.getState(false));
    assertEquals(MAX_CHANNEL * MAX_STREAM, gcpChannel.affinityKeyToChannelRef.size());
    checkChannelRefs(MAX_CHANNEL, 0, MAX_STREAM);
    return respNames;
  }

  private void deleteAsyncSessions(SpannerStub stub, List<String> respNames) throws Exception {
    assertEquals(ConnectivityState.READY, gcpChannel.getState(false));
    for (String respName : respNames) {
      AsyncResponseObserver<Empty> resp = new AsyncResponseObserver<>();
      stub.deleteSession(DeleteSessionRequest.newBuilder().setName(respName).build(), resp);
      // The ChannelRef which is bound with the current affinity key.
      ChannelRef currentChannel = gcpChannel.affinityKeyToChannelRef.get(respName);
      // Verify the channel is in use.
      assertEquals(1, currentChannel.getActiveStreamsCount());
      resp.get();
      assertEquals(0, currentChannel.getActiveStreamsCount());
    }
    checkChannelRefs(MAX_CHANNEL, 0, 0);
    assertEquals(0, gcpChannel.affinityKeyToChannelRef.size());
  }

  /** Helper Functions for FutureStub. */
  private SpannerFutureStub getSpannerFutureStub() {
    return getSpannerFutureStub(gcpChannel);
  }

  private SpannerFutureStub getSpannerFutureStub(GcpManagedChannel gcpChannel) {
    GoogleCredentials creds = getCreds();
    return SpannerGrpc.newFutureStub(gcpChannel)
        .withCallCredentials(MoreCallCredentials.from(creds));
  }

  private List<String> createFutureSessions(SpannerFutureStub stub) throws Exception {
    List<ListenableFuture<Session>> futures = new ArrayList<>();
    List<String> futureNames = new ArrayList<>();
    assertEquals(ConnectivityState.IDLE, gcpChannel.getState(false));

    // Check CreateSession with multiple channels and streams,
    CreateSessionRequest req = CreateSessionRequest.newBuilder().setDatabase(DATABASE_PATH).build();
    for (int i = 0; i < MAX_CHANNEL * MAX_STREAM; i++) {
      ListenableFuture<Session> future = stub.createSession(req);
      futures.add(future);
    }
    checkChannelRefs(MAX_CHANNEL, MAX_STREAM, 0);
    for (ListenableFuture<Session> future : futures) {
      futureNames.add(future.get().getName());
    }
    // Since createSession will bind the key, check the number of keys bound with channels.
    assertEquals(ConnectivityState.READY, gcpChannel.getState(false));
    assertEquals(MAX_CHANNEL * MAX_STREAM, gcpChannel.affinityKeyToChannelRef.size());
    checkChannelRefs(MAX_CHANNEL, 0, MAX_STREAM);
    return futureNames;
  }

  private void deleteFutureSessions(SpannerFutureStub stub, List<String> futureNames)
      throws Exception {
    assertEquals(ConnectivityState.READY, gcpChannel.getState(false));
    for (String futureName : futureNames) {
      ListenableFuture<Empty> future =
          stub.deleteSession(DeleteSessionRequest.newBuilder().setName(futureName).build());
      // The ChannelRef which is bound with the current affinity key.
      ChannelRef currentChannel = gcpChannel.affinityKeyToChannelRef.get(futureName);
      // Verify the channel is in use.
      assertEquals(1, currentChannel.getActiveStreamsCount());
      future.get();
      assertEquals(0, currentChannel.getActiveStreamsCount());
    }
    checkChannelRefs(MAX_CHANNEL, 0, 0);
    assertEquals(0, gcpChannel.affinityKeyToChannelRef.size());
  }

  @Rule public ExpectedException expectedEx = ExpectedException.none();

  @Before
  public void setupChannels() {
    testLogger.addHandler(testLogHandler);
    File configFile =
        new File(SpannerIntegrationTest.class.getClassLoader().getResource(API_FILE).getFile());
    gcpChannel =
        (GcpManagedChannel)
            GcpManagedChannelBuilder.forDelegateBuilder(builder)
                .withApiConfigJsonFile(configFile)
                .build();
    gcpChannelBRR =
        (GcpManagedChannel)
            GcpManagedChannelBuilder.forDelegateBuilder(builder)
                .withApiConfigJsonFile(configFile)
                .withOptions(
                    GcpManagedChannelOptions.newBuilder()
                        .withChannelPoolOptions(
                            GcpChannelPoolOptions.newBuilder()
                                .setMaxSize(MAX_CHANNEL)
                                .setConcurrentStreamsLowWatermark(MAX_STREAM)
                                .setUseRoundRobinOnBind(true)
                                .build())
                        .build())
                .build();
  }

  @After
  public void shutdownChannels() {
    testLogger.removeHandler(testLogHandler);
    testLogger.setLevel(Level.INFO);
    logRecords.clear();
    gcpChannel.shutdownNow();
    gcpChannelBRR.shutdownNow();
  }

  private static Object getAttribute(Map<AttributeKey<?>, Object> attributes, String key) {
    for (Map.Entry<AttributeKey<?>, Object> entry : attributes.entrySet()) {
      if (entry.getKey() != null && key.equals(entry.getKey().getKey())) {
        return entry.getValue();
      }
    }
    return null;
  }

  private long getOkCallsCount(InMemoryMetricReader metricReader, String endpoint) {
    for (MetricData metric : metricReader.collectAllMetrics()) {
      if (!metric.getName().equals(GcpMetricsConstants.METRIC_NUM_CALLS_COMPLETED)) {
        continue;
      }
      for (LongPointData point : metric.getLongGaugeData().getPoints()) {
        Map<AttributeKey<?>, Object> attributes = point.getAttributes().asMap();
        Object result = getAttribute(attributes, GcpMetricsConstants.RESULT_LABEL);
        Object common = getAttribute(attributes, commonKey);
        Object ep = getAttribute(attributes, GcpMetricsConstants.ENDPOINT_LABEL);
        if (GcpMetricsConstants.RESULT_SUCCESS.equals(result)
            && commonValue.equals(common)
            && endpoint.equals(ep)) {
          return point.getValue();
        }
      }
    }
    fail("Success calls metric is not found for endpoint: " + endpoint);
    return 0;
  }

  private ApiConfig getApiConfig() throws IOException {
    File configFile =
        new File(SpannerIntegrationTest.class.getClassLoader().getResource(API_FILE).getFile());

    Parser parser = JsonFormat.parser();
    ApiConfig.Builder apiConfigBuilder = ApiConfig.newBuilder();
    Reader reader = Files.newBufferedReader(configFile.toPath(), UTF_8);
    parser.merge(reader, apiConfigBuilder);

    return apiConfigBuilder.build();
  }

  private String getCurrentEndpoint(InMemoryMetricReader metricReader, String meName) {
    for (MetricData metric : metricReader.collectAllMetrics()) {
      if (!metric.getName().equals(GcpMetricsConstants.METRIC_CURRENT_ENDPOINT)) {
        continue;
      }
      for (LongPointData point : metric.getLongGaugeData().getPoints()) {
        Map<AttributeKey<?>, Object> attributes = point.getAttributes().asMap();
        Object me = getAttribute(attributes, GcpMetricsConstants.ME_NAME_LABEL);
        Object common = getAttribute(attributes, commonKey);
        if (meName.equals(me) && commonValue.equals(common) && point.getValue() == 1L) {
          Object endpoint = getAttribute(attributes, GcpMetricsConstants.ENDPOINT_LABEL);
          return endpoint == null ? null : endpoint.toString();
        }
      }
    }
    fail("Current endpoint metric not found for multi-endpoint: " + meName);
    return null;
  }

  private String getEndpointState(InMemoryMetricReader metricReader, String endpoint) {
    for (MetricData metric : metricReader.collectAllMetrics()) {
      if (!metric.getName().equals(GcpMetricsConstants.METRIC_ENDPOINT_STATE)) {
        continue;
      }
      for (LongPointData point : metric.getLongGaugeData().getPoints()) {
        Map<AttributeKey<?>, Object> attributes = point.getAttributes().asMap();
        Object common = getAttribute(attributes, commonKey);
        Object ep = getAttribute(attributes, GcpMetricsConstants.ENDPOINT_LABEL);
        if (!commonValue.equals(common) || !endpoint.equals(ep) || point.getValue() != 1L) {
          continue;
        }
        Object status = getAttribute(attributes, GcpMetricsConstants.STATUS_LABEL);
        return status == null ? null : status.toString();
      }
    }
    fail("Endpoint state metric not found for endpoint: " + endpoint);
    return null;
  }

  private long getSwitchCount(InMemoryMetricReader metricReader, String meName, String type) {
    for (MetricData metric : metricReader.collectAllMetrics()) {
      if (!metric.getName().equals(GcpMetricsConstants.METRIC_ENDPOINT_SWITCH)) {
        continue;
      }
      for (LongPointData point : metric.getLongGaugeData().getPoints()) {
        Map<AttributeKey<?>, Object> attributes = point.getAttributes().asMap();
        Object common = getAttribute(attributes, commonKey);
        Object me = getAttribute(attributes, GcpMetricsConstants.ME_NAME_LABEL);
        Object t = getAttribute(attributes, GcpMetricsConstants.SWITCH_TYPE_LABEL);
        if (commonValue.equals(common) && meName.equals(me) && type.equals(t)) {
          return point.getValue();
        }
      }
    }
    fail("Switch count metric with type " + type + " not found for multi-endpoint: " + meName);
    return 0;
  }

  // For this test we'll create a Spanner client with gRPC-GCP MultiEndpoint feature.
  //
  // Imagine we have a multi-region Spanner instance with leader in the us-east4 and follower in the
  // us-east1 regions.
  //
  // We will provide two MultiEndpoint configs: "leader" (having leader region endpoint first and
  // follower second) and "follower" (having follower region endpoint first and leader second).
  //
  // Then we'll make sure the Spanner client uses leader MultiEndpoint as a default one and creates
  // its sessions there. Then we'll make sure a read request will also use the leader MultiEndpoint
  // by default.
  //
  // Then we'll verify we can use the follower MultiEndpoint when needed by specifying that in
  // the Spanner context.
  //
  // Then we'll update MultiEndpoints configuration by replacing the leader endpoint and renaming
  // the follower MultiEndpoint. And make sure the new leader endpoint and the previous follower
  // endpoint are still working as expected when using different MultiEndpoints.
  @Test
  public void testSpannerMultiEndpointClient() throws IOException, InterruptedException {
    // Watch debug messages.
    testLogger.setLevel(Level.FINEST);

    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    OpenTelemetry otel = OpenTelemetrySdk.builder().setMeterProvider(meterProvider).build();

    // Leader-first multi-endpoint endpoints.
    final List<String> leaderEndpoints = new ArrayList<>();
    // Follower-first multi-endpoint endpoints.
    final List<String> followerEndpoints = new ArrayList<>();
    final String leaderEndpoint = "us-east4.googleapis.com:443";
    // Test endpoint with protocol specified.
    final String followerEndpoint = "https://us-east1.googleapis.com:443";
    leaderEndpoints.add(leaderEndpoint);
    leaderEndpoints.add(followerEndpoint);
    followerEndpoints.add(followerEndpoint);
    followerEndpoints.add(leaderEndpoint);

    ApiFunction<ManagedChannelBuilder<?>, ManagedChannelBuilder<?>> configurator =
        input -> input.overrideAuthority(SPANNER_TARGET);

    // Leader-first multi-endpoint.
    GcpMultiEndpointOptions leaderOpts =
        GcpMultiEndpointOptions.newBuilder(leaderEndpoints)
            .withName(leaderME)
            .withChannelConfigurator(configurator)
            .withRecoveryTimeout(Duration.ofSeconds(3))
            .build();

    // Follower-first multi-endpoint.
    GcpMultiEndpointOptions followerOpts =
        GcpMultiEndpointOptions.newBuilder(followerEndpoints)
            .withName(followerME)
            .withChannelConfigurator(configurator)
            .withRecoveryTimeout(Duration.ofSeconds(3))
            .build();

    List<GcpMultiEndpointOptions> opts = new ArrayList<>();
    opts.add(leaderOpts);
    opts.add(followerOpts);

    GcpMultiEndpointChannel gcpMultiEndpointChannel =
        new GcpMultiEndpointChannel(
            opts,
            getApiConfig(),
            GcpManagedChannelOptions.newBuilder()
                .withChannelPoolOptions(
                    GcpChannelPoolOptions.newBuilder()
                        .setConcurrentStreamsLowWatermark(0)
                        .setMaxSize(3)
                        .build())
                .withMetricsOptions(
                    GcpMetricsOptions.newBuilder()
                        .withOpenTelemetryMeter(otel.getMeter("grpc-gcp-spanner-it"))
                        .withOtelLabels(
                            Collections.singletonList(commonKey),
                            Collections.singletonList(commonValue))
                        .build())
                .build());

    final int currentIndex = GcpManagedChannel.channelPoolIndex.get();
    final String followerPoolIndex = String.format("pool-%d", currentIndex);
    final String leaderPoolIndex = String.format("pool-%d", currentIndex - 1);

    // Make sure authorities are overridden by channel configurator.
    assertThat(gcpMultiEndpointChannel.authority()).isEqualTo(SPANNER_TARGET);
    assertThat(gcpMultiEndpointChannel.authorityFor(leaderME)).isEqualTo(SPANNER_TARGET);
    assertThat(gcpMultiEndpointChannel.authorityFor(followerME)).isEqualTo(SPANNER_TARGET);
    assertThat(gcpMultiEndpointChannel.authorityFor("no-such-name")).isNull();

    sleep(1000);

    List<String> logMessages =
        logRecords.stream().map(LogRecord::getMessage).collect(Collectors.toList());

    // Make sure min channels are created and connections are established right away in both pools.
    for (String poolIndex : Arrays.asList(leaderPoolIndex, followerPoolIndex)) {
      for (int i = 0; i < 2; i++) {
        assertThat(logMessages)
            .contains(poolIndex + ": Channel " + i + " state change detected: null -> IDLE");

        assertThat(logMessages)
            .contains(poolIndex + ": Channel " + i + " state change detected: IDLE -> CONNECTING");
      }
    }

    // Trigger OTel metric callbacks at least once.
    metricReader.collectAllMetrics();

    logRecords.clear();

    TransportChannelProvider channelProvider =
        FixedTransportChannelProvider.create(GrpcTransportChannel.create(gcpMultiEndpointChannel));

    SpannerOptions.Builder options = SpannerOptions.newBuilder().setProjectId(GCP_PROJECT_ID);

    options.setChannelProvider(channelProvider);
    // Match channel pool size.
    options.setNumChannels(3);

    Spanner spanner = options.build().getService();
    InstanceId instanceId = InstanceId.of(GCP_PROJECT_ID, INSTANCE_ID);
    DatabaseId databaseId = DatabaseId.of(instanceId, DB_NAME);
    DatabaseClient databaseClient = spanner.getDatabaseClient(databaseId);

    Runnable readQuery =
        () -> {
          try (com.google.cloud.spanner.ResultSet read =
              databaseClient
                  .singleUse()
                  .read("Users", KeySet.all(), Arrays.asList("UserId", "UserName"))) {
            int readRows = 0;
            while (read.next()) {
              readRows++;
              assertEquals(USERNAME, read.getCurrentRowAsStruct().getString("UserName"));
            }
            assertEquals(1, readRows);
          }
        };

    // Make sure top priority endpoints reported as current.
    assertThat(getCurrentEndpoint(metricReader, leaderME)).isEqualTo(leaderEndpoint);
    assertThat(getCurrentEndpoint(metricReader, followerME)).isEqualTo(followerEndpoint);

    // Make sure both endpoints reported as available.
    assertThat(getEndpointState(metricReader, leaderEndpoint))
        .isEqualTo(GcpMetricsConstants.STATUS_AVAILABLE);
    assertThat(getEndpointState(metricReader, followerEndpoint))
        .isEqualTo(GcpMetricsConstants.STATUS_AVAILABLE);

    // Make sure leader endpoint is used by default.
    assertThat(getOkCallsCount(metricReader, leaderEndpoint)).isEqualTo(0);
    readQuery.run();

    // Wait for sessions creation requests to be completed but no more than 10 seconds.
    for (int i = 0; i < 20; i++) {
      sleep(500);
      if (getOkCallsCount(metricReader, leaderEndpoint) == 4) {
        break;
      }
    }

    // 3 session creation requests + 1 our read request to the leader endpoint.
    assertThat(getOkCallsCount(metricReader, leaderEndpoint)).isEqualTo(4);

    // Make sure there were 3 session creation requests in the leader pool only.
    assertThat(
            logRecords.stream()
                .filter(
                    logRecord ->
                        logRecord
                            .getMessage()
                            .matches(
                                leaderPoolIndex + ": Binding \\d+ key\\(s\\) to channel \\d:.*"))
                .count())
        .isEqualTo(3);

    assertThat(
            logRecords.stream()
                .filter(
                    logRecord ->
                        logRecord
                            .getMessage()
                            .matches(
                                followerPoolIndex + ": Binding \\d+ key\\(s\\) to channel \\d:.*"))
                .count())
        .isEqualTo(0);

    // Function for creating a context with a specific multi-endpoint set in call options.
    Function<String, Context> callContextFor =
        meName ->
            Context.current()
                .withValue(
                    CALL_CONTEXT_CONFIGURATOR_KEY,
                    new CallContextConfigurator() {
                      @Nullable
                      @Override
                      public <ReqT, RespT> ApiCallContext configure(
                          ApiCallContext context,
                          ReqT request,
                          MethodDescriptor<ReqT, RespT> method) {
                        return context.merge(
                            GrpcCallContext.createDefault()
                                .withCallOptions(CallOptions.DEFAULT.withOption(ME_KEY, meName)));
                      }
                    });

    // Function for creating a context with a specific multi-endpoint set in the context key.
    Function<String, Context> contextFor =
        meName -> Context.current().withValue(ME_CONTEXT_KEY, meName);

    assertThat(getOkCallsCount(metricReader, followerEndpoint)).isEqualTo(0);
    // Use follower, make sure it is used. (multi-endpoint is set in the context)
    contextFor.apply(followerME).run(readQuery);
    assertThat(getOkCallsCount(metricReader, followerEndpoint)).isEqualTo(1);

    // Replace leader endpoints. Try endpoint with default port.
    final String newLeaderEndpoint = "https://us-west1.googleapis.com";
    leaderEndpoints.clear();
    leaderEndpoints.add(newLeaderEndpoint);
    leaderEndpoints.add(followerEndpoint);
    leaderOpts =
        GcpMultiEndpointOptions.newBuilder(leaderEndpoints)
            .withName(leaderME)
            .withChannelConfigurator(configurator)
            .build();

    followerEndpoints.clear();
    followerEndpoints.add(followerEndpoint);
    followerEndpoints.add(newLeaderEndpoint);

    final String newFollowerME = "follower-2";
    // Rename follower MultiEndpoint.
    followerOpts =
        GcpMultiEndpointOptions.newBuilder(followerEndpoints)
            .withName(newFollowerME)
            .withChannelConfigurator(configurator)
            .build();

    opts.clear();
    opts.add(leaderOpts);
    opts.add(followerOpts);

    gcpMultiEndpointChannel.setMultiEndpoints(opts);

    // New leader endpoint should be unavailable first because it is connecting.
    assertThat(getEndpointState(metricReader, newLeaderEndpoint))
        .isEqualTo(GcpMetricsConstants.STATUS_UNAVAILABLE);
    assertThat(getEndpointState(metricReader, followerEndpoint))
        .isEqualTo(GcpMetricsConstants.STATUS_AVAILABLE);

    // One switch should be reported for the leader-first ME with type REPLACE.
    // Switched from leader (removed from the endpoints) to fallback endpoint as new leader endpoint
    // is not yet available.
    assertThat(getSwitchCount(metricReader, leaderME, GcpMetricsConstants.TYPE_REPLACE))
        .isEqualTo(1);
    // No switched should be reported for the follower-first ME as it stays at fallback endpoint.
    assertThat(getSwitchCount(metricReader, newFollowerME, GcpMetricsConstants.TYPE_REPLACE))
        .isEqualTo(0);
    assertThat(getSwitchCount(metricReader, newFollowerME, GcpMetricsConstants.TYPE_FALLBACK))
        .isEqualTo(0);
    assertThat(getSwitchCount(metricReader, newFollowerME, GcpMetricsConstants.TYPE_RECOVER))
        .isEqualTo(0);

    // As it takes some time to connect to the new leader endpoint, RPC will fall back to the
    // follower until we connect to leader.
    assertThat(getOkCallsCount(metricReader, followerEndpoint)).isEqualTo(1);
    readQuery.run();
    assertThat(getOkCallsCount(metricReader, followerEndpoint)).isEqualTo(2);

    sleep(500);

    // Now the new leader endpoint should be available and current for leaderME.
    assertThat(getEndpointState(metricReader, newLeaderEndpoint))
        .isEqualTo(GcpMetricsConstants.STATUS_AVAILABLE);
    assertThat(getCurrentEndpoint(metricReader, leaderME)).isEqualTo(newLeaderEndpoint);

    // And now another switch with type RECOVER should be reported as the leader-first ME should
    // switch from the fallback endpoint to the new leader endpoint.
    assertThat(getSwitchCount(metricReader, leaderME, GcpMetricsConstants.TYPE_RECOVER))
        .isEqualTo(1);

    // Make sure the new leader endpoint is used by default after it is connected.
    assertThat(getOkCallsCount(metricReader, newLeaderEndpoint)).isEqualTo(0);
    readQuery.run();
    assertThat(getOkCallsCount(metricReader, newLeaderEndpoint)).isEqualTo(1);

    // Make sure that the follower endpoint still works if specified.
    assertThat(getOkCallsCount(metricReader, followerEndpoint)).isEqualTo(2);
    // Use follower, make sure it is used. (multi-endpoint is set in the call options)
    callContextFor.apply(newFollowerME).run(readQuery);
    assertThat(getOkCallsCount(metricReader, followerEndpoint)).isEqualTo(3);

    // Use leader, make sure it is used. (multi-endpoint from the call options overrides context-set
    // multi-endpoint)
    contextFor.apply(newFollowerME).run(() -> callContextFor.apply(leaderME).run(readQuery));
    assertThat(getOkCallsCount(metricReader, newLeaderEndpoint)).isEqualTo(2);

    gcpMultiEndpointChannel.shutdown();
    spanner.close();
  }

  @Test
  public void testSpannerMultiEndpointClientWithDelay() throws IOException, InterruptedException {
    // Watch debug messages.
    testLogger.setLevel(Level.FINEST);

    final int poolSize = 3;
    final long switchingDelayMs = 500;
    final long marginMs = 50;

    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    OpenTelemetry otel = OpenTelemetrySdk.builder().setMeterProvider(meterProvider).build();

    // Leader-first multi-endpoint endpoints.
    final List<String> leaderEndpoints = new ArrayList<>();
    // Follower-first multi-endpoint endpoints.
    final List<String> followerEndpoints = new ArrayList<>();
    final String leaderEndpoint = "us-east4.googleapis.com:443";
    final String followerEndpoint = "us-east1.googleapis.com:443";
    leaderEndpoints.add(leaderEndpoint);
    leaderEndpoints.add(followerEndpoint);
    followerEndpoints.add(followerEndpoint);
    followerEndpoints.add(leaderEndpoint);

    ApiFunction<ManagedChannelBuilder<?>, ManagedChannelBuilder<?>> configurator =
        input -> input.overrideAuthority(SPANNER_TARGET);

    GcpMultiEndpointOptions leaderOpts =
        GcpMultiEndpointOptions.newBuilder(leaderEndpoints)
            .withName(leaderME)
            .withChannelConfigurator(configurator)
            .withRecoveryTimeout(Duration.ofSeconds(3))
            .withSwitchingDelay(Duration.ofMillis(switchingDelayMs))
            .build();

    GcpMultiEndpointOptions followerOpts =
        GcpMultiEndpointOptions.newBuilder(followerEndpoints)
            .withName(followerME)
            .withChannelConfigurator(configurator)
            .withRecoveryTimeout(Duration.ofSeconds(3))
            .withSwitchingDelay(Duration.ofMillis(switchingDelayMs))
            .build();

    List<GcpMultiEndpointOptions> opts = new ArrayList<>();
    opts.add(leaderOpts);
    opts.add(followerOpts);

    GcpMultiEndpointChannel gcpMultiEndpointChannel =
        new GcpMultiEndpointChannel(
            opts,
            getApiConfig(),
            GcpManagedChannelOptions.newBuilder()
                .withChannelPoolOptions(
                    GcpChannelPoolOptions.newBuilder()
                        .setConcurrentStreamsLowWatermark(0)
                        .setMaxSize(poolSize)
                        .build())
                .withMetricsOptions(
                    GcpMetricsOptions.newBuilder()
                        .withOpenTelemetryMeter(otel.getMeter("grpc-gcp-spanner-it-delay"))
                        .withOtelLabels(
                            Collections.singletonList(commonKey),
                            Collections.singletonList(commonValue))
                        .build())
                .build());

    final int currentIndex = GcpManagedChannel.channelPoolIndex.get();
    final String followerPoolIndex = String.format("pool-%d", currentIndex);
    final String leaderPoolIndex = String.format("pool-%d", currentIndex - 1);

    TransportChannelProvider channelProvider =
        FixedTransportChannelProvider.create(GrpcTransportChannel.create(gcpMultiEndpointChannel));

    SpannerOptions.Builder options = SpannerOptions.newBuilder().setProjectId(GCP_PROJECT_ID);

    options.setChannelProvider(channelProvider);
    // Match channel pool size.
    options.setNumChannels(poolSize);

    Spanner spanner = options.build().getService();
    InstanceId instanceId = InstanceId.of(GCP_PROJECT_ID, INSTANCE_ID);
    DatabaseId databaseId = DatabaseId.of(instanceId, DB_NAME);
    DatabaseClient databaseClient = spanner.getDatabaseClient(databaseId);

    Runnable readQuery =
        () -> {
          try (com.google.cloud.spanner.ResultSet read =
              databaseClient
                  .singleUse()
                  .read("Users", KeySet.all(), Arrays.asList("UserId", "UserName"))) {
            int readRows = 0;
            while (read.next()) {
              readRows++;
              assertEquals(USERNAME, read.getCurrentRowAsStruct().getString("UserName"));
            }
            assertEquals(1, readRows);
          }
        };

    // Make sure leader endpoint is used by default.
    assertThat(getOkCallsCount(metricReader, leaderEndpoint)).isEqualTo(0);
    readQuery.run();

    // Wait for sessions creation requests to be completed but no more than 10 seconds.
    for (int i = 0; i < 20; i++) {
      sleep(500);
      if (getOkCallsCount(metricReader, leaderEndpoint) == 4) {
        break;
      }
    }

    // 3 session creation requests + 1 our read request to the leader endpoint.
    assertThat(getOkCallsCount(metricReader, leaderEndpoint)).isEqualTo(4);

    // Change the endpoints in the leader endpoint. east4, east1 -> east1, east4.
    leaderOpts =
        GcpMultiEndpointOptions.newBuilder(followerEndpoints)
            .withName(leaderME)
            .withChannelConfigurator(configurator)
            .withRecoveryTimeout(Duration.ofSeconds(3))
            .withSwitchingDelay(Duration.ofMillis(switchingDelayMs))
            .build();

    opts = new ArrayList<>();
    opts.add(leaderOpts);
    opts.add(followerOpts);

    gcpMultiEndpointChannel.setMultiEndpoints(opts);

    // Because of the delay the leader MultiEndpoint should still use leader endpoint.
    sleep(switchingDelayMs - marginMs);
    readQuery.run();
    assertThat(getOkCallsCount(metricReader, leaderEndpoint)).isEqualTo(5);
    assertThat(getOkCallsCount(metricReader, followerEndpoint)).isEqualTo(0);

    // But after the delay, it should switch to the follower endpoint.
    sleep(2 * marginMs);

    readQuery.run();
    assertThat(getOkCallsCount(metricReader, leaderEndpoint)).isEqualTo(5);
    assertThat(getOkCallsCount(metricReader, followerEndpoint)).isEqualTo(1);

    // Remove leader endpoint from the leader multi-endpoint. east1, east4 -> east1.
    leaderOpts =
        GcpMultiEndpointOptions.newBuilder(Collections.singletonList(followerEndpoint))
            .withName(leaderME)
            .withChannelConfigurator(configurator)
            .withRecoveryTimeout(Duration.ofSeconds(3))
            .withSwitchingDelay(Duration.ofMillis(switchingDelayMs))
            .build();

    opts = new ArrayList<>();
    opts.add(leaderOpts);
    opts.add(followerOpts);

    gcpMultiEndpointChannel.setMultiEndpoints(opts);

    // Bring the leader endpoint back. east1 -> east4, east1.
    leaderOpts =
        GcpMultiEndpointOptions.newBuilder(leaderEndpoints)
            .withName(leaderME)
            .withChannelConfigurator(configurator)
            .withRecoveryTimeout(Duration.ofSeconds(3))
            .withSwitchingDelay(Duration.ofMillis(switchingDelayMs))
            .build();

    opts = new ArrayList<>();
    opts.add(leaderOpts);
    opts.add(followerOpts);

    gcpMultiEndpointChannel.setMultiEndpoints(opts);

    // Because of the delay the leader MultiEndpoint should still use follower endpoint.
    sleep(switchingDelayMs - marginMs);
    readQuery.run();
    assertThat(getOkCallsCount(metricReader, leaderEndpoint)).isEqualTo(5);
    assertThat(getOkCallsCount(metricReader, followerEndpoint)).isEqualTo(2);

    // But after the delay, it should switch back to the leader endpoint.
    sleep(2 * marginMs);
    readQuery.run();
    assertThat(getOkCallsCount(metricReader, leaderEndpoint)).isEqualTo(6);
    assertThat(getOkCallsCount(metricReader, followerEndpoint)).isEqualTo(2);

    gcpMultiEndpointChannel.shutdown();
    spanner.close();
  }

  @Test
  public void testCreateAndGetSessionBlocking() {
    SpannerBlockingStub stub = getSpannerBlockingStub();
    CreateSessionRequest req = CreateSessionRequest.newBuilder().setDatabase(DATABASE_PATH).build();
    // The first MAX_CHANNEL requests (without affinity) should be distributed 1 per channel.
    List<Session> sessions = new ArrayList<>();
    for (int i = 0; i < MAX_CHANNEL; i++) {
      Session session = stub.createSession(req);
      assertThat(session).isNotEqualTo(null);
      sessions.add(session);

      Session responseGet =
          stub.getSession(GetSessionRequest.newBuilder().setName(session.getName()).build());
      assertEquals(responseGet.getName(), session.getName());
    }
    checkChannelRefs(MAX_CHANNEL, 0, 1);

    for (Session session : sessions) {
      deleteSession(stub, session);
    }
    checkChannelRefs(MAX_CHANNEL, 0, 0);
  }

  @Test
  public void testBatchCreateSessionsBlocking() {
    int sessionCount = 10;
    SpannerBlockingStub stub = getSpannerBlockingStub();
    BatchCreateSessionsRequest req =
        BatchCreateSessionsRequest.newBuilder()
            .setDatabase(DATABASE_PATH)
            .setSessionCount(sessionCount)
            .build();
    List<Session> sessions = new ArrayList<>();
    // The first MAX_CHANNEL requests (without affinity) should be distributed 1 per channel.
    for (int j = 0; j < MAX_CHANNEL; j++) {
      BatchCreateSessionsResponse resp = stub.batchCreateSessions(req);
      assertThat(resp.getSessionCount()).isEqualTo(sessionCount);
      sessions.addAll(resp.getSessionList());
    }
    checkChannelRefs(MAX_CHANNEL, 0, sessionCount);

    for (Session session : sessions) {
      deleteSession(stub, session);
    }
    checkChannelRefs(MAX_CHANNEL, 0, 0);
  }

  @Test
  public void testSessionsCreatedUsingRoundRobin() throws Exception {
    SpannerFutureStub stub = getSpannerFutureStub(gcpChannelBRR);
    List<ListenableFuture<Session>> futures = new ArrayList<>();
    assertEquals(ConnectivityState.IDLE, gcpChannelBRR.getState(false));

    // Should create one session per channel.
    CreateSessionRequest req = CreateSessionRequest.newBuilder().setDatabase(DATABASE_PATH).build();
    for (int i = 0; i < MAX_CHANNEL; i++) {
      ListenableFuture<Session> future = stub.createSession(req);
      futures.add(future);
    }
    // If round-robin in use as expected, then each channel should have 1 active stream with the
    // CreateSession request.
    checkChannelRefs(gcpChannelBRR, MAX_CHANNEL, 1, 0);

    // Collecting futures results.
    String lastSession = "";
    for (ListenableFuture<Session> future : futures) {
      lastSession = future.get().getName();
    }
    // Since createSession will bind the key, check the number of keys bound with channels.
    // Each channel should have 1 affinity key.
    assertEquals(MAX_CHANNEL, gcpChannelBRR.affinityKeyToChannelRef.size());
    checkChannelRefs(gcpChannelBRR, MAX_CHANNEL, 0, 1);

    // Create a different request with the lastSession created.
    ListenableFuture<ResultSet> responseFuture =
        stub.executeSql(
            ExecuteSqlRequest.newBuilder()
                .setSession(lastSession)
                .setSql("select * FROM Users")
                .build());
    // The ChannelRef which is bound with the lastSession.
    ChannelRef currentChannel = gcpChannelBRR.affinityKeyToChannelRef.get(lastSession);
    // Verify the channel is in use.
    assertEquals(1, currentChannel.getActiveStreamsCount());

    // Create another 1 session per channel sequentially.
    // Without the round-robin it won't use the currentChannel as it has more active streams (1)
    // than other channels.
    // But with round-robin each channel should get one create session request.
    for (int i = 0; i < MAX_CHANNEL; i++) {
      ListenableFuture<Session> future = stub.createSession(req);
      future.get();
    }
    ResultSet response = responseFuture.get();

    // If round-robin in use, then each channel should now have 2 active stream with the
    // CreateSession request.
    checkChannelRefs(gcpChannelBRR, MAX_CHANNEL, 0, 2);
  }

  @Test
  public void testSessionsCreatedWithoutRoundRobin() throws Exception {
    // Watch debug messages.
    testLogger.setLevel(Level.FINEST);
    final int currentIndex = GcpManagedChannel.channelPoolIndex.get() - 1;
    final String poolIndex = String.format("pool-%d", currentIndex);

    SpannerFutureStub stub = getSpannerFutureStub();
    List<ListenableFuture<Session>> futures = new ArrayList<>();
    assertEquals(ConnectivityState.IDLE, gcpChannel.getState(false));

    // Should create one session per channel.
    CreateSessionRequest req = CreateSessionRequest.newBuilder().setDatabase(DATABASE_PATH).build();
    for (int i = 0; i < MAX_CHANNEL; i++) {
      ListenableFuture<Session> future = stub.createSession(req);
      futures.add(future);
      assertThat(lastLogMessage(3))
          .isAnyOf(
              poolIndex + ": Channel " + i + " state change detected: null -> IDLE",
              poolIndex + ": Channel " + (i - 1) + " state change detected: IDLE -> CONNECTING",
              poolIndex + ": Channel " + i + " created.");
      assertThat(lastLogMessage(2))
          .isAnyOf(
              poolIndex + ": Channel " + i + " state change detected: null -> IDLE",
              poolIndex + ": Channel " + (i - 1) + " state change detected: IDLE -> CONNECTING",
              poolIndex + ": Channel " + i + " created.");
      assertThat(lastLogMessage())
          .isEqualTo(poolIndex + ": Channel " + i + " picked for bind operation.");
      assertThat(lastLogLevel()).isEqualTo(Level.FINEST);
    }
    // Each channel should have 1 active stream with the CreateSession request because we create
    // them concurrently.
    checkChannelRefs(gcpChannel, MAX_CHANNEL, 1, 0);

    // Collecting futures results.
    String lastSession = "";
    for (ListenableFuture<Session> future : futures) {
      lastSession = future.get().getName();
    }
    // Since createSession will bind the key, check the number of keys bound with channels.
    // Each channel should have 1 affinity key.
    assertEquals(MAX_CHANNEL, gcpChannel.affinityKeyToChannelRef.size());
    checkChannelRefs(MAX_CHANNEL, 0, 1);

    // Create a different request with the lastSession created.
    ListenableFuture<ResultSet> responseFuture =
        stub.executeSql(
            ExecuteSqlRequest.newBuilder()
                .setSession(lastSession)
                .setSql("select * FROM Users")
                .build());
    // The ChannelRef which is bound with the lastSession.
    ChannelRef currentChannel = gcpChannel.affinityKeyToChannelRef.get(lastSession);
    // Verify the channel is in use.
    assertEquals(1, currentChannel.getActiveStreamsCount());

    // Initial log messages count.
    int logCount = logRecords.size();

    // Create another 1 session per channel sequentially.
    // Without the round-robin it won't use the currentChannel as it has more active streams (1)
    // than other channels.
    for (int i = 0; i < MAX_CHANNEL; i++) {
      ListenableFuture<Session> future = stub.createSession(req);
      assertThat(lastLogMessage()).isEqualTo(poolIndex + ": Channel 0 picked for bind operation.");
      assertThat(logRecords.size()).isEqualTo(++logCount);
      future.get();
      logCount++; // For session mapping log message.
    }
    ResultSet response = responseFuture.get();

    // Without round-robin the first channel will get all additional 3 sessions.
    checkChannelRefs(new int[] {0, 0, 0}, new int[] {4, 1, 1});
  }

  @Test
  public void testListSessionsFuture() throws Exception {
    SpannerFutureStub stub = getSpannerFutureStub();
    List<String> futureNames = createFutureSessions(stub);
    ListSessionsResponse responseList =
        stub.listSessions(ListSessionsRequest.newBuilder().setDatabase(DATABASE_PATH).build())
            .get();
    Set<String> trueNames = new HashSet<>();
    deleteFutureSessions(stub, futureNames);
  }

  @Test
  public void testListSessionsAsync() throws Exception {
    SpannerStub stub = getSpannerStub();
    List<String> respNames = createAsyncSessions(stub);
    AsyncResponseObserver<ListSessionsResponse> respList = new AsyncResponseObserver<>();
    stub.listSessions(
        ListSessionsRequest.newBuilder().setDatabase(DATABASE_PATH).build(), respList);
    ListSessionsResponse responseList = respList.get();
    deleteAsyncSessions(stub, respNames);
  }

  @Test
  public void testExecuteSqlFuture() throws Exception {
    SpannerFutureStub stub = getSpannerFutureStub();
    List<String> futureNames = createFutureSessions(stub);
    for (String futureName : futureNames) {
      ListenableFuture<ResultSet> responseFuture =
          stub.executeSql(
              ExecuteSqlRequest.newBuilder()
                  .setSession(futureName)
                  .setSql("select * FROM Users")
                  .build());
      // The ChannelRef which is bound with the current affinity key.
      ChannelRef currentChannel = gcpChannel.affinityKeyToChannelRef.get(futureName);
      // Verify the channel is in use.
      assertEquals(1, currentChannel.getActiveStreamsCount());
      ResultSet response = responseFuture.get();
      assertEquals(1, response.getRowsCount());
      assertEquals(USERNAME, response.getRows(0).getValuesList().get(1).getStringValue());
      assertEquals(0, currentChannel.getActiveStreamsCount());
    }
    deleteFutureSessions(stub, futureNames);
  }

  @Test
  public void testExecuteStreamingSqlAsync() throws Exception {
    SpannerStub stub = getSpannerStub();
    List<String> respNames = createAsyncSessions(stub);
    for (String respName : respNames) {
      AsyncResponseObserver<PartialResultSet> resp = new AsyncResponseObserver<>();
      stub.executeStreamingSql(
          ExecuteSqlRequest.newBuilder().setSession(respName).setSql("select * FROM Users").build(),
          resp);
      // The ChannelRef which is bound with the current affinity key.
      ChannelRef currentChannel = gcpChannel.affinityKeyToChannelRef.get(respName);
      // Verify the channel is in use.
      assertEquals(1, currentChannel.getActiveStreamsCount());
      PartialResultSet response = resp.get();
      assertEquals(USERNAME, resp.get().getValues(1).getStringValue());
      assertEquals(0, currentChannel.getActiveStreamsCount());
    }
    deleteAsyncSessions(stub, respNames);
  }

  @Test
  public void testExecuteStreamingSqlWithAffinityDisabledViaContext() throws Exception {
    SpannerStub stub = getSpannerStub();
    String sessionName = createAsyncSessions(stub).get(0);
    AsyncResponseObserver<PartialResultSet> resp = new AsyncResponseObserver<>();
    stub.executeStreamingSql(
        ExecuteSqlRequest.newBuilder()
            .setSession(sessionName)
            .setSql("select * FROM Users")
            .build(),
        resp);
    // The ChannelRef which is bound with the current affinity key.
    ChannelRef currentChannel = gcpChannel.affinityKeyToChannelRef.get(sessionName);
    // Verify the channel is in use.
    assertEquals(1, currentChannel.getActiveStreamsCount());
    PartialResultSet response = resp.get();
    assertEquals(USERNAME, response.getValues(1).getStringValue());
    assertEquals(0, currentChannel.getActiveStreamsCount());

    Context ctx = Context.current().withValue(GcpManagedChannel.DISABLE_AFFINITY_CTX_KEY, true);
    List<AsyncResponseObserver<PartialResultSet>> resps = new ArrayList<>();
    for (int i = 0; i < MAX_CHANNEL; i++) {
      // Execute the call in the context where affinity is disabled.
      ctx.run(
          () -> {
            AsyncResponseObserver<PartialResultSet> r = new AsyncResponseObserver<>();
            resps.add(r);
            stub.executeStreamingSql(
                ExecuteSqlRequest.newBuilder()
                    .setSession(sessionName)
                    .setSql("select * FROM Users")
                    .build(),
                r);
          });
    }
    // Verify calls with disabled affinity are distributed accross all channels.
    for (ChannelRef ch : gcpChannel.channelRefs) {
      assertEquals(1, ch.getActiveStreamsCount());
    }

    for (AsyncResponseObserver<PartialResultSet> r : resps) {
      response = r.get();
      assertEquals(USERNAME, response.getValues(1).getStringValue());
      assertEquals(0, currentChannel.getActiveStreamsCount());
    }
  }

  @Test
  public void testExecuteStreamingSqlWithAffinityDisabledViaCallOptions() throws Exception {
    SpannerStub stub = getSpannerStub();
    String sessionName = createAsyncSessions(stub).get(0);
    AsyncResponseObserver<PartialResultSet> resp = new AsyncResponseObserver<>();
    stub.executeStreamingSql(
        ExecuteSqlRequest.newBuilder()
            .setSession(sessionName)
            .setSql("select * FROM Users")
            .build(),
        resp);
    // The ChannelRef which is bound with the current affinity key.
    ChannelRef currentChannel = gcpChannel.affinityKeyToChannelRef.get(sessionName);
    // Verify the channel is in use.
    assertEquals(1, currentChannel.getActiveStreamsCount());
    PartialResultSet response = resp.get();
    assertEquals(USERNAME, response.getValues(1).getStringValue());
    assertEquals(0, currentChannel.getActiveStreamsCount());

    List<AsyncResponseObserver<PartialResultSet>> resps = new ArrayList<>();
    for (int i = 0; i < MAX_CHANNEL; i++) {
      AsyncResponseObserver<PartialResultSet> r = new AsyncResponseObserver<>();
      resps.add(r);
      // Execute the call with affinity disabled via call option.
      stub.withOption(GcpManagedChannel.DISABLE_AFFINITY_KEY, true)
          .executeStreamingSql(
              ExecuteSqlRequest.newBuilder()
                  .setSession(sessionName)
                  .setSql("select * FROM Users")
                  .build(),
              r);
    }
    // Verify calls with disabled affinity are distributed accross all channels.
    for (ChannelRef ch : gcpChannel.channelRefs) {
      assertEquals(1, ch.getActiveStreamsCount());
    }

    for (AsyncResponseObserver<PartialResultSet> r : resps) {
      response = r.get();
      assertEquals(USERNAME, response.getValues(1).getStringValue());
      assertEquals(0, currentChannel.getActiveStreamsCount());
    }
  }

  @Test
  public void testExecuteStreamingSqlWithAffinityViaContext() throws Exception {
    SpannerStub stub = getSpannerStub();
    String sessionName = createAsyncSessions(stub).get(0);
    ExecuteSqlRequest executeSqlRequest =
        ExecuteSqlRequest.newBuilder()
            .setSession(sessionName)
            .setSql("select * FROM Users")
            .build();
    List<AsyncResponseObserver<PartialResultSet>> resps = new ArrayList<>();
    AsyncResponseObserver<PartialResultSet> resp = new AsyncResponseObserver<>();
    resps.add(resp);
    stub.executeStreamingSql(executeSqlRequest, resp);
    // The ChannelRef which is bound with the current affinity key.
    ChannelRef currentChannel = gcpChannel.affinityKeyToChannelRef.get(sessionName);
    // Verify the channel is in use.
    assertEquals(1, currentChannel.getActiveStreamsCount());

    final String key = "overriden-key";

    // Override affinity key via context.
    Context ctx = Context.current().withValue(GcpManagedChannel.AFFINITY_CTX_KEY, key);
    ctx.run(
        () -> {
          AsyncResponseObserver<PartialResultSet> r = new AsyncResponseObserver<>();
          resps.add(r);
          stub.executeStreamingSql(executeSqlRequest, r);
        });

    ChannelRef newChannel = gcpChannel.affinityKeyToChannelRef.get(key);
    // Make sure it is mapped to a different channel, because current channel is the busiest.
    assertThat(currentChannel.getId()).isNotEqualTo(newChannel.getId());
    assertEquals(1, newChannel.getActiveStreamsCount());

    // Make another call.
    ctx.run(
        () -> {
          AsyncResponseObserver<PartialResultSet> r = new AsyncResponseObserver<>();
          resps.add(r);
          stub.executeStreamingSql(executeSqlRequest, r);
        });
    assertEquals(2, newChannel.getActiveStreamsCount());

    // Make sure non-overriden affinty still works.
    resp = new AsyncResponseObserver<>();
    resps.add(resp);
    stub.executeStreamingSql(executeSqlRequest, resp);
    assertEquals(2, currentChannel.getActiveStreamsCount());

    // Complete the requests.
    resps.forEach(
        r -> {
          try {
            r.get();
          } catch (InterruptedException e) {
            // Noop if interrupted.
          }
        });
  }

  @Test
  public void testExecuteStreamingSqlWithAffinityViaCallOptions() throws Exception {
    SpannerStub stub = getSpannerStub();
    String sessionName = createAsyncSessions(stub).get(0);
    ExecuteSqlRequest executeSqlRequest =
        ExecuteSqlRequest.newBuilder()
            .setSession(sessionName)
            .setSql("select * FROM Users")
            .build();
    List<AsyncResponseObserver<PartialResultSet>> resps = new ArrayList<>();
    AsyncResponseObserver<PartialResultSet> resp = new AsyncResponseObserver<>();
    resps.add(resp);
    stub.executeStreamingSql(executeSqlRequest, resp);
    // The ChannelRef which is bound with the current affinity key.
    ChannelRef currentChannel = gcpChannel.affinityKeyToChannelRef.get(sessionName);
    // Verify the channel is in use.
    assertEquals(1, currentChannel.getActiveStreamsCount());

    final String key = "overriden-key";

    // Override affinity key via call options.
    resp = new AsyncResponseObserver<>();
    resps.add(resp);
    stub.withOption(GcpManagedChannel.AFFINITY_KEY, key)
        .executeStreamingSql(executeSqlRequest, resp);

    ChannelRef newChannel = gcpChannel.affinityKeyToChannelRef.get(key);
    // Make sure it is mapped to a different channel, because current channel is the busiest.
    assertThat(currentChannel.getId()).isNotEqualTo(newChannel.getId());
    assertEquals(1, newChannel.getActiveStreamsCount());

    // Make another call.
    resp = new AsyncResponseObserver<>();
    resps.add(resp);
    stub.withOption(GcpManagedChannel.AFFINITY_KEY, key)
        .executeStreamingSql(executeSqlRequest, resp);
    assertEquals(2, newChannel.getActiveStreamsCount());

    // Make sure non-overriden affinty still works.
    resp = new AsyncResponseObserver<>();
    resps.add(resp);
    stub.executeStreamingSql(executeSqlRequest, resp);
    assertEquals(2, currentChannel.getActiveStreamsCount());

    // Complete the requests.
    resps.forEach(
        r -> {
          try {
            r.get();
          } catch (InterruptedException e) {
            // Noop if interrupted.
          }
        });
  }

  @Test
  public void testExecuteStreamingSqlWithAffinityViaContextAndCallOptions() throws Exception {
    SpannerStub stub = getSpannerStub();
    String sessionName = createAsyncSessions(stub).get(0);
    ExecuteSqlRequest executeSqlRequest =
        ExecuteSqlRequest.newBuilder()
            .setSession(sessionName)
            .setSql("select * FROM Users")
            .build();
    List<AsyncResponseObserver<PartialResultSet>> resps = new ArrayList<>();
    AsyncResponseObserver<PartialResultSet> resp = new AsyncResponseObserver<>();
    resps.add(resp);
    stub.executeStreamingSql(executeSqlRequest, resp);
    // The ChannelRef which is bound with the current affinity key.
    ChannelRef currentChannel = gcpChannel.affinityKeyToChannelRef.get(sessionName);
    // Verify the channel is in use.
    assertEquals(1, currentChannel.getActiveStreamsCount());

    final String contextKey = "context-key";
    final String optionsKey = "options-key";

    // Override affinity key via context.
    Context ctx = Context.current().withValue(GcpManagedChannel.AFFINITY_CTX_KEY, contextKey);
    ctx.run(
        () -> {
          AsyncResponseObserver<PartialResultSet> r = new AsyncResponseObserver<>();
          resps.add(r);
          stub.executeStreamingSql(executeSqlRequest, r);
        });

    ChannelRef contextChannel = gcpChannel.affinityKeyToChannelRef.get(contextKey);
    // Make sure it is mapped to a different channel, because current channel is the busiest.
    assertThat(currentChannel.getId()).isNotEqualTo(contextChannel.getId());
    assertEquals(1, contextChannel.getActiveStreamsCount());

    // Make another call overriding affinity with call options.
    resp = new AsyncResponseObserver<>();
    resps.add(resp);
    stub.withOption(GcpManagedChannel.AFFINITY_KEY, optionsKey)
        .executeStreamingSql(executeSqlRequest, resp);
    // Make sure it is mapped to a different channel, because the current channel and "context"
    // channel are the busiest.
    ChannelRef optionsChannel = gcpChannel.affinityKeyToChannelRef.get(optionsKey);
    assertThat(currentChannel.getId()).isNotEqualTo(optionsChannel.getId());
    assertThat(optionsChannel.getId()).isNotEqualTo(contextChannel.getId());
    assertEquals(1, optionsChannel.getActiveStreamsCount());

    // Now make a call with context and call options affinity keys.
    ctx.run(
        () -> {
          AsyncResponseObserver<PartialResultSet> r = new AsyncResponseObserver<>();
          resps.add(r);
          stub.withOption(GcpManagedChannel.AFFINITY_KEY, optionsKey)
              .executeStreamingSql(executeSqlRequest, r);
        });
    // Make sure affinity from call options is prevailing.
    assertEquals(2, optionsChannel.getActiveStreamsCount());

    // Complete the requests.
    resps.forEach(
        r -> {
          try {
            r.get();
          } catch (InterruptedException e) {
            // Noop if interrupted.
          }
        });
  }

  @Test
  public void testPartitionQueryAsync() throws Exception {
    SpannerStub stub = getSpannerStub();
    List<String> respNames = createAsyncSessions(stub);
    for (String respName : respNames) {
      TransactionOptions options =
          TransactionOptions.newBuilder().setReadOnly(ReadOnly.getDefaultInstance()).build();
      TransactionSelector selector = TransactionSelector.newBuilder().setBegin(options).build();
      AsyncResponseObserver<PartitionResponse> resp = new AsyncResponseObserver<>();
      stub.partitionQuery(
          PartitionQueryRequest.newBuilder()
              .setSession(respName)
              .setSql("select * FROM Users")
              .setTransaction(selector)
              .build(),
          resp);
      // The ChannelRef which is bound with the current affinity key.
      ChannelRef currentChannel = gcpChannel.affinityKeyToChannelRef.get(respName);
      // Verify the channel is in use.
      assertEquals(1, currentChannel.getActiveStreamsCount());
      PartitionResponse response = resp.get();
      assertEquals(0, currentChannel.getActiveStreamsCount());
    }
    deleteAsyncSessions(stub, respNames);
  }

  @Test
  public void testExecuteBatchDmlFuture() throws Exception {
    SpannerFutureStub stub = getSpannerFutureStub();
    List<String> futureNames = createFutureSessions(stub);
    for (String futureName : futureNames) {
      TransactionOptions options =
          TransactionOptions.newBuilder().setReadWrite(ReadWrite.getDefaultInstance()).build();
      TransactionSelector selector = TransactionSelector.newBuilder().setBegin(options).build();
      // Will use only one session for the whole batch.
      ListenableFuture<ExecuteBatchDmlResponse> responseFuture =
          stub.executeBatchDml(
              ExecuteBatchDmlRequest.newBuilder()
                  .setSession(futureName)
                  .setTransaction(selector)
                  .addStatements(Statement.newBuilder().setSql("select * FROM Users").build())
                  .build());
      // The ChannelRef which is bound with the current affinity key.
      ChannelRef currentChannel = gcpChannel.affinityKeyToChannelRef.get(futureName);
      // Verify the channel is in use.
      assertEquals(1, currentChannel.getActiveStreamsCount());
      ExecuteBatchDmlResponse response = responseFuture.get();
      assertEquals(0, currentChannel.getActiveStreamsCount());
    }
    deleteFutureSessions(stub, futureNames);
  }

  @Test
  public void testBoundWithInvalidAffinityKey() {
    SpannerBlockingStub stub = getSpannerBlockingStub();
    CreateSessionRequest req = CreateSessionRequest.newBuilder().setDatabase(DATABASE_PATH).build();
    Session session = stub.createSession(req);
    expectedEx.expect(StatusRuntimeException.class);
    expectedEx.expectMessage("INVALID_ARGUMENT: Invalid GetSession request.");
    // No channel bound with the key "invalid_session", will use the least busy one.
    stub.getSession(GetSessionRequest.newBuilder().setName("invalid_session").build());
  }

  @Test
  public void testUnbindWithInvalidAffinityKey() {
    SpannerBlockingStub stub = getSpannerBlockingStub();
    CreateSessionRequest req = CreateSessionRequest.newBuilder().setDatabase(DATABASE_PATH).build();
    Session session = stub.createSession(req);
    expectedEx.expect(StatusRuntimeException.class);
    expectedEx.expectMessage("INVALID_ARGUMENT: Invalid DeleteSession request.");
    // No channel bound with the key "invalid_session", will use the least busy one.
    stub.deleteSession(DeleteSessionRequest.newBuilder().setName("invalid_session").build());
  }

  @Test
  public void testBoundAfterUnbind() {
    SpannerBlockingStub stub = getSpannerBlockingStub();
    CreateSessionRequest req = CreateSessionRequest.newBuilder().setDatabase(DATABASE_PATH).build();
    Session session = stub.createSession(req);
    stub.deleteSession(DeleteSessionRequest.newBuilder().setName(session.getName()).build());
    expectedEx.expect(StatusRuntimeException.class);
    expectedEx.expectMessage("NOT_FOUND: Session not found: " + session.getName());
    stub.getSession(GetSessionRequest.newBuilder().setName(session.getName()).build());
  }

  private static class AsyncResponseObserver<RespT> implements StreamObserver<RespT> {

    private final CountDownLatch finishLatch = new CountDownLatch(1);
    private RespT response = null;

    private AsyncResponseObserver() {}

    public RespT get() throws InterruptedException {
      finishLatch.await(1, TimeUnit.MINUTES);
      return response;
    }

    @Override
    public void onNext(RespT response) {
      this.response = response;
    }

    @Override
    public void onError(Throwable t) {
      finishLatch.countDown();
    }

    @Override
    public void onCompleted() {
      finishLatch.countDown();
    }
  }
}
