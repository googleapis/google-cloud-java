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

package com.google.cloud.firestore.spi.v1;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.RetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.ScheduledRetryingExecutor;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnauthenticatedException;
import com.google.auth.Credentials;
import com.google.cloud.firestore.FirestoreOpenTelemetryOptions;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.v1.FirestoreClient.ListDocumentsPagedResponse;
import com.google.cloud.firestore.v1.FirestoreClient.PartitionQueryPagedResponse;
import com.google.cloud.firestore.v1.FirestoreSettings;
import com.google.cloud.firestore.v1.stub.FirestoreStubSettings;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.grpc.GrpcTransportOptions.ExecutorFactory;
import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.BatchWriteRequest;
import com.google.firestore.v1.BatchWriteResponse;
import com.google.firestore.v1.BeginTransactionRequest;
import com.google.firestore.v1.BeginTransactionResponse;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.ExecutePipelineRequest;
import com.google.firestore.v1.ExecutePipelineResponse;
import com.google.firestore.v1.ListDocumentsRequest;
import com.google.firestore.v1.ListDocumentsResponse;
import com.google.firestore.v1.PartitionQueryRequest;
import com.google.firestore.v1.PartitionQueryResponse;
import com.google.firestore.v1.RollbackRequest;
import com.google.firestore.v1.RunAggregationQueryRequest;
import com.google.firestore.v1.RunAggregationQueryResponse;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.RunQueryResponse;
import com.google.protobuf.Empty;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;

public class GrpcFirestoreRpcTest {

  private static final String PROJECT_ID = "test-project";
  private static final String CUSTOM_UNIVERSE_DOMAIN = "s3nsapis.fr";
  private static final String UNIVERSE_DOMAIN_ENV_VAR = "GOOGLE_CLOUD_UNIVERSE_DOMAIN";
  private static final String PROBE_RESULT_PREFIX = "UNIVERSE_PROBE_RESULT=";
  private static final String UNSET_ARG = "-";

  private static FirestoreStubSettings defaultStubSettings;

  private final FirestoreOptions firestoreOptionsWithoutOverride =
      FirestoreOptions.newBuilder().setProjectId("test-project").build();

  @BeforeClass
  public static void beforeClass() throws IOException {
    defaultStubSettings = FirestoreStubSettings.newBuilder().build();
  }

  static <T> T getViaReflection(Object o, String fieldName)
      throws NoSuchFieldException, IllegalAccessException {
    return getViaReflection(o.getClass(), fieldName, o);
  }

  static <T> T getViaReflection(Class clazz, String fieldName, Object o)
      throws NoSuchFieldException, IllegalAccessException {
    Field field = clazz.getDeclaredField(fieldName);
    field.setAccessible(true);
    return (T) field.get(o);
  }

  @Test
  public void retrySettingsOverride() throws Exception {
    RetrySettings retrySettings = RetrySettings.newBuilder().setMaxAttempts(2).build();
    FirestoreOptions firestoreOptions =
        FirestoreOptions.newBuilder()
            .setProjectId("test-project")
            .setRetrySettings(retrySettings)
            .build();
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptions);

    CallableRetryData commit = getRetryData(grpcFirestoreRpc.commitCallable());
    assertThat(commit.retrySettings).isEqualTo(retrySettings);
    assertThat(commit.retryableCodes)
        .containsExactlyElementsIn(defaultStubSettings.commitSettings().getRetryableCodes());

    CallableRetryData batchWrite = getRetryData(grpcFirestoreRpc.batchWriteCallable());
    assertThat(batchWrite.retrySettings).isEqualTo(retrySettings);
    assertThat(batchWrite.retryableCodes)
        .containsExactlyElementsIn(defaultStubSettings.batchWriteSettings().getRetryableCodes());

    CallableRetryData batchGetDocuments =
        getRetryData(grpcFirestoreRpc.batchGetDocumentsCallable());
    assertThat(batchGetDocuments.retrySettings).isEqualTo(retrySettings);
    assertThat(batchGetDocuments.retryableCodes)
        .containsExactlyElementsIn(
            defaultStubSettings.batchGetDocumentsSettings().getRetryableCodes());

    CallableRetryData runQuery = getRetryData(grpcFirestoreRpc.runQueryCallable());
    assertThat(runQuery.retrySettings).isEqualTo(retrySettings);
    assertThat(runQuery.retryableCodes)
        .containsExactlyElementsIn(defaultStubSettings.runQuerySettings().getRetryableCodes());

    CallableRetryData runAggregationQuery =
        getRetryData(grpcFirestoreRpc.runAggregationQueryCallable());
    assertThat(runAggregationQuery.retrySettings).isEqualTo(retrySettings);
    assertThat(runAggregationQuery.retryableCodes)
        .containsExactlyElementsIn(
            defaultStubSettings.runAggregationQuerySettings().getRetryableCodes());

    CallableRetryData beginTransaction = getRetryData(grpcFirestoreRpc.beginTransactionCallable());
    assertThat(beginTransaction.retrySettings).isEqualTo(retrySettings);
    assertThat(beginTransaction.retryableCodes)
        .containsExactlyElementsIn(
            defaultStubSettings.beginTransactionSettings().getRetryableCodes());

    CallableRetryData rollback = getRetryData(grpcFirestoreRpc.rollbackCallable());
    assertThat(rollback.retrySettings).isEqualTo(retrySettings);
    assertThat(rollback.retryableCodes)
        .containsExactlyElementsIn(defaultStubSettings.rollbackSettings().getRetryableCodes());

    CallableRetryData listCollectionIdsPaged =
        getRetryData(grpcFirestoreRpc.listCollectionIdsPagedCallable());
    assertThat(listCollectionIdsPaged.retrySettings).isEqualTo(retrySettings);
    assertThat(listCollectionIdsPaged.retryableCodes)
        .containsExactlyElementsIn(
            defaultStubSettings.listCollectionIdsSettings().getRetryableCodes());

    CallableRetryData partitionQueryPaged =
        getRetryData(grpcFirestoreRpc.partitionQueryPagedCallable());
    assertThat(partitionQueryPaged.retrySettings).isEqualTo(retrySettings);
    assertThat(partitionQueryPaged.retryableCodes)
        .containsExactlyElementsIn(
            defaultStubSettings.partitionQuerySettings().getRetryableCodes());

    CallableRetryData listDocumentsPaged =
        getRetryData(grpcFirestoreRpc.listDocumentsPagedCallable());
    assertThat(listDocumentsPaged.retrySettings).isEqualTo(retrySettings);
    assertThat(listDocumentsPaged.retryableCodes)
        .containsExactlyElementsIn(defaultStubSettings.listDocumentsSettings().getRetryableCodes());
  }

  private static RetrySettings withMaxAttempt5(RetrySettings retrySettings) {
    return retrySettings.toBuilder().setMaxAttempts(5).build();
  }

  @Test
  public void commitCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.commitCallable());
    UnaryCallSettings<CommitRequest, CommitResponse> expectedSettings =
        defaultStubSettings.commitSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void batchWriteCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.batchWriteCallable());
    UnaryCallSettings<BatchWriteRequest, BatchWriteResponse> expectedSettings =
        defaultStubSettings.batchWriteSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void batchGetDocumentsCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.batchGetDocumentsCallable());
    ServerStreamingCallSettings<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
        expectedSettings = defaultStubSettings.batchGetDocumentsSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void runQueryCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.runQueryCallable());
    ServerStreamingCallSettings<RunQueryRequest, RunQueryResponse> expectedSettings =
        defaultStubSettings.runQuerySettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void runAggregationQueryCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.runAggregationQueryCallable());
    ServerStreamingCallSettings<RunAggregationQueryRequest, RunAggregationQueryResponse>
        expectedSettings = defaultStubSettings.runAggregationQuerySettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void executePipelineCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.executePipelineCallable());
    ServerStreamingCallSettings<ExecutePipelineRequest, ExecutePipelineResponse> expectedSettings =
        defaultStubSettings.executePipelineSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void beginTransactionCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.beginTransactionCallable());
    UnaryCallSettings<BeginTransactionRequest, BeginTransactionResponse> expectedSettings =
        defaultStubSettings.beginTransactionSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void rollbackCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.rollbackCallable());
    UnaryCallSettings<RollbackRequest, Empty> expectedSettings =
        defaultStubSettings.rollbackSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void listCollectionIdsPagedCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.listCollectionIdsPagedCallable());
    PagedCallSettings<ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
        expectedSettings = defaultStubSettings.listDocumentsSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void partitionQueryPagedCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.partitionQueryPagedCallable());
    PagedCallSettings<PartitionQueryRequest, PartitionQueryResponse, PartitionQueryPagedResponse>
        expectedSettings = defaultStubSettings.partitionQuerySettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void listDocumentsPagedCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.listDocumentsPagedCallable());
    PagedCallSettings<ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
        expectedSettings = defaultStubSettings.listDocumentsSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  private static CallableRetryData getRetryData(Object callable) throws Exception {
    String aClassName = callable.getClass().getName();
    switch (aClassName) {
      case "com.google.api.gax.tracing.TracedUnaryCallable":
      case "com.google.api.gax.tracing.TracedServerStreamingCallable":
        return getRetryData(getViaReflection(callable, "innerCallable"));
      case "com.google.api.gax.rpc.UnaryCallable$1":
      case "com.google.api.gax.rpc.ServerStreamingCallable$1":
        return getRetryData(getViaReflection(callable, "this$0"));
      case "com.google.api.gax.rpc.RetryingCallable":
        return new CallableRetryData(
            getRetrySettings(getViaReflection(callable, "executor")),
            getRetryableCodes(getViaReflection(callable, "callable")));
      case "com.google.api.gax.rpc.RetryingServerStreamingCallable":
        return new CallableRetryData(
            getRetrySettings(getViaReflection(callable, "executor")),
            getRetryableCodes(getViaReflection(callable, "innerCallable")));
      case "com.google.api.gax.rpc.PagedCallable":
        return getRetryData(getViaReflection(callable, "callable"));
      default:
        throw new Exception("Unexpected class " + aClassName);
    }
  }

  private static Set<Code> getRetryableCodes(Object o)
      throws NoSuchFieldException, IllegalAccessException {
    switch (o.getClass().getName()) {
      case "com.google.api.gax.rpc.ServerStreamingCallable$1":
        return getRetryableCodes(getViaReflection(o, "this$0"));
      case "com.google.api.gax.rpc.WatchdogServerStreamingCallable":
        return getRetryableCodes(getViaReflection(o, "inner"));
    }
    Object exceptionFactory = getViaReflection(o, "exceptionFactory");
    return getViaReflection(exceptionFactory, "retryableCodes");
  }

  private static RetrySettings getRetrySettings(Object o) throws Exception {
    String aClassName = o.getClass().getName();
    switch (aClassName) {
      case "com.google.api.gax.retrying.ScheduledRetryingExecutor":
        {
          Object retryAlgorithm =
              getViaReflection(ScheduledRetryingExecutor.class, "retryAlgorithm", o);
          Object exponentialRetryAlgorithm =
              getViaReflection(RetryAlgorithm.class, "timedAlgorithmWithContext", retryAlgorithm);
          return getViaReflection(
              ExponentialRetryAlgorithm.class, "globalSettings", exponentialRetryAlgorithm);
        }
      default:
        throw new Exception("Unexpected class " + aClassName);
    }
  }

  private static void assumeNoEmulatorHostEnv() {
    Assume.assumeTrue(
        "FIRESTORE_EMULATOR_HOST must be unset", System.getenv("FIRESTORE_EMULATOR_HOST") == null);
  }

  @Test
  public void universeDomainResolvesEndpointViaGax() throws Exception {
    assumeNoEmulatorHostEnv();
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(new FakeUniverseCredentials(CUSTOM_UNIVERSE_DOMAIN))
            .setUniverseDomain(CUSTOM_UNIVERSE_DOMAIN)
            .build();

    FirestoreSettings settings = GrpcFirestoreRpc.createFirestoreSettings(options);
    assertThat(settings.getUniverseDomain()).isEqualTo(CUSTOM_UNIVERSE_DOMAIN);
    assertThat(settings.getEndpoint()).isEqualTo("firestore." + CUSTOM_UNIVERSE_DOMAIN + ":443");
    InstantiatingGrpcChannelProvider channelProvider =
        (InstantiatingGrpcChannelProvider) settings.getTransportChannelProvider();
    assertThat(channelProvider.needsEndpoint()).isTrue();
    assertThat(channelProvider.getEndpoint()).isNull();

    GrpcFirestoreRpc rpc = new GrpcFirestoreRpc(options);
    try {
      ClientContext clientContext = rpc.getClientContext();
      assertThat(clientContext.getUniverseDomain()).isEqualTo(CUSTOM_UNIVERSE_DOMAIN);
      assertThat(clientContext.getEndpoint())
          .isEqualTo("firestore." + CUSTOM_UNIVERSE_DOMAIN + ":443");
      GrpcTransportChannel transportChannel =
          (GrpcTransportChannel) clientContext.getTransportChannel();
      assertThat(transportChannel.getChannel().authority())
          .isEqualTo("firestore." + CUSTOM_UNIVERSE_DOMAIN + ":443");

      FirestoreStubSettings stubSettings = FirestoreStubSettings.newBuilder(clientContext).build();
      assertThat(stubSettings.getUniverseDomain()).isEqualTo(CUSTOM_UNIVERSE_DOMAIN);
      assertThat(stubSettings.getEndpoint())
          .isEqualTo("firestore." + CUSTOM_UNIVERSE_DOMAIN + ":443");

      // Matching credentials pass universe domain validation cleanly without network calls.
      ((GrpcCallContext) clientContext.getDefaultCallContext()).validateUniverseDomain();
    } finally {
      rpc.close();
    }
  }

  @Test
  public void defaultUniverseDomainAndEndpointWhenEnvUnset() throws Exception {
    assumeNoEmulatorHostEnv();
    Assume.assumeTrue(
        UNIVERSE_DOMAIN_ENV_VAR + " must be unset for default resolution test",
        System.getenv(UNIVERSE_DOMAIN_ENV_VAR) == null);

    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(new FakeUniverseCredentials(Credentials.GOOGLE_DEFAULT_UNIVERSE))
            .build();

    FirestoreSettings settings = GrpcFirestoreRpc.createFirestoreSettings(options);
    assertThat(settings.getUniverseDomain()).isEqualTo(Credentials.GOOGLE_DEFAULT_UNIVERSE);
    assertThat(settings.getEndpoint()).isEqualTo("firestore.googleapis.com:443");

    GrpcFirestoreRpc rpc = new GrpcFirestoreRpc(options);
    try {
      ClientContext clientContext = rpc.getClientContext();
      assertThat(clientContext.getUniverseDomain()).isEqualTo(Credentials.GOOGLE_DEFAULT_UNIVERSE);
      GrpcTransportChannel transportChannel =
          (GrpcTransportChannel) clientContext.getTransportChannel();
      assertThat(transportChannel.getChannel().authority())
          .isEqualTo("firestore.googleapis.com:443");

      FirestoreStubSettings stubSettings = FirestoreStubSettings.newBuilder(clientContext).build();
      assertThat(stubSettings.getUniverseDomain()).isEqualTo(Credentials.GOOGLE_DEFAULT_UNIVERSE);
      assertThat(stubSettings.getEndpoint()).isEqualTo("firestore.googleapis.com:443");
    } finally {
      rpc.close();
    }
  }

  @Test
  public void customHostOverridesDefaultEndpointWithUniverseDomain() throws Exception {
    assumeNoEmulatorHostEnv();
    String customHost = "custom-firestore.example.com:443";
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(new FakeUniverseCredentials(CUSTOM_UNIVERSE_DOMAIN))
            .setUniverseDomain(CUSTOM_UNIVERSE_DOMAIN)
            .setHost(customHost)
            .build();

    FirestoreSettings settings = GrpcFirestoreRpc.createFirestoreSettings(options);
    assertThat(settings.getUniverseDomain()).isEqualTo(CUSTOM_UNIVERSE_DOMAIN);
    assertThat(settings.getEndpoint()).isEqualTo(customHost);

    GrpcFirestoreRpc rpc = new GrpcFirestoreRpc(options);
    try {
      ClientContext clientContext = rpc.getClientContext();
      assertThat(clientContext.getUniverseDomain()).isEqualTo(CUSTOM_UNIVERSE_DOMAIN);
      GrpcTransportChannel transportChannel =
          (GrpcTransportChannel) clientContext.getTransportChannel();
      assertThat(transportChannel.getChannel().authority()).isEqualTo(customHost);

      FirestoreStubSettings stubSettings = FirestoreStubSettings.newBuilder(clientContext).build();
      assertThat(stubSettings.getUniverseDomain()).isEqualTo(CUSTOM_UNIVERSE_DOMAIN);
      assertThat(stubSettings.getEndpoint()).isEqualTo(customHost);
    } finally {
      rpc.close();
    }
  }

  @Test
  public void toBuilderSetHostUpdatesChannelAuthority() throws Exception {
    assumeNoEmulatorHostEnv();
    String customHostA = "custom-a.example.com:443";
    String customHostB = "custom-b.example.com:8443";
    FirestoreOptions optionsA =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(new FakeUniverseCredentials(CUSTOM_UNIVERSE_DOMAIN))
            .setUniverseDomain(CUSTOM_UNIVERSE_DOMAIN)
            .setHost(customHostA)
            .build();
    FirestoreOptions optionsB = optionsA.toBuilder().setHost(customHostB).build();
    FirestoreOptions resetToDefault =
        optionsA.toBuilder().setHost(FirestoreSettings.getDefaultEndpoint()).build();

    GrpcFirestoreRpc rpcB = new GrpcFirestoreRpc(optionsB);
    try {
      ClientContext clientContext = rpcB.getClientContext();
      GrpcTransportChannel transportChannel =
          (GrpcTransportChannel) clientContext.getTransportChannel();
      assertThat(clientContext.getUniverseDomain()).isEqualTo(CUSTOM_UNIVERSE_DOMAIN);
      assertThat(transportChannel.getChannel().authority()).isEqualTo(customHostB);
    } finally {
      rpcB.close();
    }

    GrpcFirestoreRpc rpcDefault = new GrpcFirestoreRpc(resetToDefault);
    try {
      ClientContext clientContext = rpcDefault.getClientContext();
      GrpcTransportChannel transportChannel =
          (GrpcTransportChannel) clientContext.getTransportChannel();
      assertThat(clientContext.getUniverseDomain()).isEqualTo(CUSTOM_UNIVERSE_DOMAIN);
      assertThat(transportChannel.getChannel().authority())
          .isEqualTo("firestore." + CUSTOM_UNIVERSE_DOMAIN + ":443");
    } finally {
      rpcDefault.close();
    }
  }

  @Test
  public void emptyUniverseDomainThrowsIllegalArgumentWrappedInIoException() {
    assumeNoEmulatorHostEnv();
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(new FakeUniverseCredentials(CUSTOM_UNIVERSE_DOMAIN))
            .setUniverseDomain("")
            .build();

    assertThrows(
        IllegalArgumentException.class, () -> GrpcFirestoreRpc.createFirestoreSettings(options));
    IOException thrown = assertThrows(IOException.class, () -> new GrpcFirestoreRpc(options));
    assertThat(thrown).hasCauseThat().isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void mismatchedCredentialsUniverseDomainThrowsUnauthenticated() throws Exception {
    assumeNoEmulatorHostEnv();
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(new FakeUniverseCredentials(Credentials.GOOGLE_DEFAULT_UNIVERSE))
            .setUniverseDomain(CUSTOM_UNIVERSE_DOMAIN)
            .build();

    GrpcFirestoreRpc rpc = new GrpcFirestoreRpc(options);
    try {
      GrpcCallContext callContext =
          (GrpcCallContext) rpc.getClientContext().getDefaultCallContext();
      UnauthenticatedException contextException =
          assertThrows(UnauthenticatedException.class, callContext::validateUniverseDomain);
      assertThat(contextException.getStatusCode().getCode()).isEqualTo(Code.UNAUTHENTICATED);
      assertThat(contextException.getMessage()).contains(CUSTOM_UNIVERSE_DOMAIN);
      assertThat(contextException.getMessage()).contains(Credentials.GOOGLE_DEFAULT_UNIVERSE);

      // Verify the live stub enforces universe domain validation before making a network call.
      UnauthenticatedException callException =
          assertThrows(
              UnauthenticatedException.class,
              () -> rpc.commitCallable().call(CommitRequest.getDefaultInstance()));
      assertThat(callException.getStatusCode().getCode()).isEqualTo(Code.UNAUTHENTICATED);
      assertThat(callException.getMessage()).contains(CUSTOM_UNIVERSE_DOMAIN);
      assertThat(callException.getMessage()).contains(Credentials.GOOGLE_DEFAULT_UNIVERSE);
    } finally {
      rpc.close();
    }
  }

  @Test
  public void endpointLessChannelProviderUsesCustomHost() throws Exception {
    assumeNoEmulatorHostEnv();
    String customHost = "custom-firestore.example.com:443";
    InstantiatingGrpcChannelProvider endpointLessProvider =
        FirestoreSettings.defaultGrpcTransportProviderBuilder().build();
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(new FakeUniverseCredentials(CUSTOM_UNIVERSE_DOMAIN))
            .setUniverseDomain(CUSTOM_UNIVERSE_DOMAIN)
            .setChannelProvider(endpointLessProvider)
            .setHost(customHost)
            .build();

    FirestoreSettings settings = GrpcFirestoreRpc.createFirestoreSettings(options);
    assertThat(settings.getUniverseDomain()).isEqualTo(CUSTOM_UNIVERSE_DOMAIN);
    assertThat(settings.getEndpoint()).isEqualTo(customHost);

    GrpcFirestoreRpc rpc = new GrpcFirestoreRpc(options);
    try {
      ClientContext clientContext = rpc.getClientContext();
      GrpcTransportChannel transportChannel =
          (GrpcTransportChannel) clientContext.getTransportChannel();
      assertThat(clientContext.getUniverseDomain()).isEqualTo(CUSTOM_UNIVERSE_DOMAIN);
      assertThat(transportChannel.getChannel().authority()).isEqualTo(customHost);
    } finally {
      rpc.close();
    }
  }

  @Test
  public void explicitChannelProviderEndpointOverridesSetHost() throws Exception {
    assumeNoEmulatorHostEnv();
    String providerEndpoint = "provider-endpoint.example.com:8443";
    InstantiatingGrpcChannelProvider customProvider =
        FirestoreSettings.defaultGrpcTransportProviderBuilder()
            .setEndpoint(providerEndpoint)
            .build();
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(new FakeUniverseCredentials(CUSTOM_UNIVERSE_DOMAIN))
            .setUniverseDomain(CUSTOM_UNIVERSE_DOMAIN)
            .setChannelProvider(customProvider)
            .setHost("ignored-host.example.com:443")
            .build();

    FirestoreSettings settings = GrpcFirestoreRpc.createFirestoreSettings(options);
    assertThat(settings.getUniverseDomain()).isEqualTo(CUSTOM_UNIVERSE_DOMAIN);
    assertThat(settings.getEndpoint()).isEqualTo(providerEndpoint);

    GrpcFirestoreRpc rpc = new GrpcFirestoreRpc(options);
    try {
      ClientContext clientContext = rpc.getClientContext();
      GrpcTransportChannel transportChannel =
          (GrpcTransportChannel) clientContext.getTransportChannel();
      assertThat(clientContext.getUniverseDomain()).isEqualTo(CUSTOM_UNIVERSE_DOMAIN);
      assertThat(transportChannel.getChannel().authority()).isEqualTo(providerEndpoint);
    } finally {
      rpc.close();
    }
  }

  @Test
  public void tracingEnabledToBuilderPreservesChannelConfiguratorAndResolvesUniverseDomain()
      throws Exception {
    assumeNoEmulatorHostEnv();
    SdkTracerProvider tracerProvider = SdkTracerProvider.builder().build();
    try {
      OpenTelemetrySdk openTelemetry =
          OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();
      FirestoreOptions baseOptions =
          FirestoreOptions.newBuilder()
              .setProjectId(PROJECT_ID)
              .setCredentials(new FakeUniverseCredentials(CUSTOM_UNIVERSE_DOMAIN))
              .setUniverseDomain(CUSTOM_UNIVERSE_DOMAIN)
              .build();
      FirestoreOptions tracedOptions =
          baseOptions.toBuilder()
              .setOpenTelemetryOptions(
                  FirestoreOpenTelemetryOptions.newBuilder()
                      .setOpenTelemetry(openTelemetry)
                      .build())
              .build();

      FirestoreSettings settings = GrpcFirestoreRpc.createFirestoreSettings(tracedOptions);
      InstantiatingGrpcChannelProvider provider =
          (InstantiatingGrpcChannelProvider) settings.getTransportChannelProvider();
      assertThat(provider.needsEndpoint()).isTrue();
      assertThat(provider.toBuilder().getChannelConfigurator()).isNotNull();
      assertThat(settings.getUniverseDomain()).isEqualTo(CUSTOM_UNIVERSE_DOMAIN);
      assertThat(settings.getEndpoint()).isEqualTo("firestore." + CUSTOM_UNIVERSE_DOMAIN + ":443");

      GrpcFirestoreRpc rpc = new GrpcFirestoreRpc(tracedOptions);
      try {
        GrpcTransportChannel transportChannel =
            (GrpcTransportChannel) rpc.getClientContext().getTransportChannel();
        assertThat(transportChannel.getChannel().authority())
            .isEqualTo("firestore." + CUSTOM_UNIVERSE_DOMAIN + ":443");
      } finally {
        rpc.close();
      }
    } finally {
      tracerProvider.close();
    }
  }

  @Test
  public void constructorFailureReleasesExecutor() {
    assumeNoEmulatorHostEnv();
    ScheduledExecutorService backingExecutor = Executors.newSingleThreadScheduledExecutor();
    AtomicInteger getCount = new AtomicInteger();
    AtomicInteger releaseCount = new AtomicInteger();
    AtomicReference<ScheduledExecutorService> released = new AtomicReference<>();
    ExecutorFactory<ScheduledExecutorService> spyFactory =
        new ExecutorFactory<ScheduledExecutorService>() {
          @Override
          public ScheduledExecutorService get() {
            getCount.incrementAndGet();
            return backingExecutor;
          }

          @Override
          public void release(ScheduledExecutorService executor) {
            releaseCount.incrementAndGet();
            released.set(executor);
          }
        };
    try {
      FirestoreOptions options =
          FirestoreOptions.newBuilder()
              .setProjectId(PROJECT_ID)
              .setCredentials(new FakeUniverseCredentials(CUSTOM_UNIVERSE_DOMAIN))
              .setTransportOptions(
                  GrpcTransportOptions.newBuilder().setExecutorFactory(spyFactory).build())
              .setUniverseDomain("")
              .build();

      IOException thrown = assertThrows(IOException.class, () -> new GrpcFirestoreRpc(options));
      assertThat(thrown).hasCauseThat().isInstanceOf(IllegalArgumentException.class);
      assertThat(getCount.get()).isEqualTo(1);
      assertThat(releaseCount.get()).isEqualTo(1);
      assertThat(released.get()).isSameInstanceAs(backingExecutor);
    } finally {
      backingExecutor.shutdownNow();
    }
  }

  @Test
  public void envVarUnsetDefaultsToGoogleapisComInForkedJvm() throws Exception {
    ProbeResult result = runUniverseDomainProbe(null, null, null);
    assertThat(result.universeDomain).isEqualTo(Credentials.GOOGLE_DEFAULT_UNIVERSE);
    assertThat(result.endpoint).isEqualTo("firestore.googleapis.com:443");
    assertThat(result.authority).isEqualTo("firestore.googleapis.com:443");
  }

  @Test
  public void envVarSetsUniverseDomainAndAuthorityInForkedJvm() throws Exception {
    ProbeResult result = runUniverseDomainProbe(CUSTOM_UNIVERSE_DOMAIN, null, null);
    assertThat(result.universeDomain).isEqualTo(CUSTOM_UNIVERSE_DOMAIN);
    assertThat(result.endpoint).isEqualTo("firestore." + CUSTOM_UNIVERSE_DOMAIN + ":443");
    assertThat(result.authority).isEqualTo("firestore." + CUSTOM_UNIVERSE_DOMAIN + ":443");
  }

  @Test
  public void explicitUniverseDomainOverridesEnvVarInForkedJvm() throws Exception {
    ProbeResult result = runUniverseDomainProbe("env.example.com", "explicit.example.com", null);
    assertThat(result.universeDomain).isEqualTo("explicit.example.com");
    assertThat(result.endpoint).isEqualTo("firestore.explicit.example.com:443");
    assertThat(result.authority).isEqualTo("firestore.explicit.example.com:443");
  }

  @Test
  public void customHostOverridesEnvVarEndpointInForkedJvm() throws Exception {
    ProbeResult result =
        runUniverseDomainProbe(CUSTOM_UNIVERSE_DOMAIN, null, "custom.example.com:8443");
    assertThat(result.universeDomain).isEqualTo(CUSTOM_UNIVERSE_DOMAIN);
    assertThat(result.endpoint).isEqualTo("custom.example.com:8443");
    assertThat(result.authority).isEqualTo("custom.example.com:8443");
  }

  private static ProbeResult runUniverseDomainProbe(
      String envUniverseDomain, String explicitUniverseDomain, String explicitHost)
      throws Exception {
    Assume.assumeTrue(
        "Skipping forked JVM probe under GraalVM native image",
        System.getProperty("org.graalvm.nativeimage.imagecode") == null);

    String javaExe =
        System.getProperty("os.name", "").toLowerCase(Locale.ROOT).contains("win")
            ? "java.exe"
            : "java";
    String javaBin = new File(new File(System.getProperty("java.home"), "bin"), javaExe).getPath();

    ProcessBuilder pb =
        new ProcessBuilder(
            javaBin,
            "-cp",
            System.getProperty("java.class.path"),
            UniverseDomainProbe.class.getName(),
            explicitUniverseDomain != null ? explicitUniverseDomain : UNSET_ARG,
            explicitHost != null ? explicitHost : UNSET_ARG);
    Map<String, String> env = pb.environment();
    if (envUniverseDomain == null) {
      env.remove(UNIVERSE_DOMAIN_ENV_VAR);
    } else {
      env.put(UNIVERSE_DOMAIN_ENV_VAR, envUniverseDomain);
    }
    env.remove("FIRESTORE_EMULATOR_HOST");
    env.remove("GOOGLE_API_USE_MTLS_ENDPOINT");
    env.remove("GOOGLE_API_USE_CLIENT_CERTIFICATE");
    env.remove("EXPERIMENTAL_GOOGLE_API_USE_S2A_JAVA");

    Process process = pb.start();
    final StringBuffer stdout = new StringBuffer();
    final StringBuffer stderr = new StringBuffer();
    Thread stdoutThread =
        new Thread(
            () -> readStream(process.getInputStream(), stdout), "universe-domain-probe-stdout");
    Thread stderrThread =
        new Thread(
            () -> readStream(process.getErrorStream(), stderr), "universe-domain-probe-stderr");
    stdoutThread.setDaemon(true);
    stderrThread.setDaemon(true);
    stdoutThread.start();
    stderrThread.start();

    boolean finished = process.waitFor(30, TimeUnit.SECONDS);
    if (!finished) {
      process.destroyForcibly();
      stdoutThread.join(5000);
      stderrThread.join(5000);
      throw new AssertionError(
          "UniverseDomainProbe timed out. stdout=[" + stdout + "] stderr=[" + stderr + "]");
    }
    stdoutThread.join(5000);
    stderrThread.join(5000);

    int exitCode = process.exitValue();
    if (exitCode != 0) {
      throw new AssertionError(
          "UniverseDomainProbe failed with exit code "
              + exitCode
              + ". stdout=["
              + stdout
              + "] stderr=["
              + stderr
              + "]");
    }

    String matchedLine = null;
    for (String line : stdout.toString().split("\\r?\\n")) {
      if (line.startsWith(PROBE_RESULT_PREFIX)) {
        matchedLine = line.substring(PROBE_RESULT_PREFIX.length());
        break;
      }
    }
    if (matchedLine == null) {
      throw new AssertionError(
          "Missing probe output line. stdout=[" + stdout + "] stderr=[" + stderr + "]");
    }
    String[] parts = matchedLine.split("\\|", -1);
    if (parts.length != 3) {
      throw new AssertionError(
          "Unexpected probe output format: [" + matchedLine + "] stderr=[" + stderr + "]");
    }
    return new ProbeResult(parts[0], parts[1], parts[2]);
  }

  private static void readStream(InputStream stream, StringBuffer target) {
    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
      String line;
      while ((line = reader.readLine()) != null) {
        synchronized (target) {
          if (target.length() > 0) {
            target.append('\n');
          }
          target.append(line);
        }
      }
    } catch (IOException ignored) {
      // Child process closed stream on exit.
    }
  }

  private static final class ProbeResult {
    final String universeDomain;
    final String endpoint;
    final String authority;

    ProbeResult(String universeDomain, String endpoint, String authority) {
      this.universeDomain = universeDomain;
      this.endpoint = endpoint;
      this.authority = authority;
    }
  }

  /** Subprocess entrypoint for testing {@code GOOGLE_CLOUD_UNIVERSE_DOMAIN} env resolution. */
  public static final class UniverseDomainProbe {
    public static void main(String[] args) throws Exception {
      String explicitUniverseDomain = UNSET_ARG.equals(args[0]) ? null : args[0];
      String explicitHost = UNSET_ARG.equals(args[1]) ? null : args[1];

      String credUniverseDomain =
          explicitUniverseDomain != null
              ? explicitUniverseDomain
              : (System.getenv(UNIVERSE_DOMAIN_ENV_VAR) != null
                  ? System.getenv(UNIVERSE_DOMAIN_ENV_VAR)
                  : Credentials.GOOGLE_DEFAULT_UNIVERSE);

      FirestoreOptions.Builder builder =
          FirestoreOptions.newBuilder()
              .setProjectId(PROJECT_ID)
              .setCredentials(new FakeUniverseCredentials(credUniverseDomain));
      if (explicitUniverseDomain != null) {
        builder.setUniverseDomain(explicitUniverseDomain);
      }
      if (explicitHost != null) {
        builder.setHost(explicitHost);
      }

      GrpcFirestoreRpc rpc = new GrpcFirestoreRpc(builder.build());
      try {
        ClientContext clientContext = rpc.getClientContext();
        GrpcTransportChannel transportChannel =
            (GrpcTransportChannel) clientContext.getTransportChannel();
        FirestoreStubSettings stubSettings =
            FirestoreStubSettings.newBuilder(clientContext).build();
        System.out.println(
            PROBE_RESULT_PREFIX
                + clientContext.getUniverseDomain()
                + "|"
                + stubSettings.getEndpoint()
                + "|"
                + transportChannel.getChannel().authority());
        System.out.flush();
      } finally {
        rpc.close();
      }
    }
  }

  /** Minimal Credentials implementation with a configurable universe domain for unit testing. */
  private static final class FakeUniverseCredentials extends Credentials {
    private final String universeDomain;

    private FakeUniverseCredentials(String universeDomain) {
      this.universeDomain = universeDomain;
    }

    @Override
    public String getAuthenticationType() {
      return "Fake";
    }

    @Override
    public Map<String, List<String>> getRequestMetadata(URI uri) {
      return Collections.emptyMap();
    }

    @Override
    public boolean hasRequestMetadata() {
      return false;
    }

    @Override
    public boolean hasRequestMetadataOnly() {
      return true;
    }

    @Override
    public void refresh() {}

    @Override
    public String getUniverseDomain() {
      return universeDomain;
    }
  }

  static class CallableRetryData {
    final RetrySettings retrySettings;
    final Set<Code> retryableCodes;

    CallableRetryData(RetrySettings retrySettings, Set<Code> retryableCodes) {
      this.retrySettings = retrySettings;
      this.retryableCodes = retryableCodes;
    }
  }
}
