/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.bigtable.data.v2.internal;

import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.bytesType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.columnMetadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.metadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.prepareResponse;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.core.ApiFutures;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.bigtable.v2.ResultSetMetadata;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.internal.PreparedStatementImpl.PrepareQueryState;
import com.google.cloud.bigtable.data.v2.internal.PreparedStatementImpl.PreparedQueryData;
import com.google.cloud.bigtable.data.v2.internal.PreparedStatementImpl.PreparedQueryVersion;
import com.google.cloud.bigtable.data.v2.models.sql.PreparedStatement;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import com.google.cloud.bigtable.data.v2.stub.metrics.NoopMetricsProvider;
import com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.PrepareRpcExpectation;
import com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.TestBigtableSqlService;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import io.grpc.Status.Code;
import io.grpc.testing.GrpcServerRule;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PreparedStatementImplTest {

  private static final ResultSetMetadata METADATA_PROTO =
      metadata(columnMetadata("_key", bytesType()), columnMetadata("p", stringType()));

  @Rule public GrpcServerRule serverRule = new GrpcServerRule();
  private TestBigtableSqlService service;
  private BigtableDataClient client;
  private Map<String, SqlType<?>> paramTypes;
  private int prepareAttempts;

  @Before
  public void setUp() throws IOException {
    service = new TestBigtableSqlService();
    serverRule.getServiceRegistry().addService(service);
    BigtableDataSettings.Builder settings =
        BigtableDataSettings.newBuilder()
            .setProjectId(TestBigtableSqlService.DEFAULT_PROJECT_ID)
            .setInstanceId(TestBigtableSqlService.DEFAULT_INSTANCE_ID)
            .setAppProfileId(TestBigtableSqlService.DEFAULT_APP_PROFILE_ID)
            .setCredentialsProvider(NoCredentialsProvider.create());
    settings
        .stubSettings()
        .setTransportChannelProvider(
            FixedTransportChannelProvider.create(
                GrpcTransportChannel.create(serverRule.getChannel())))
        // Refreshing channel doesn't work with FixedTransportChannelProvider
        .setRefreshingChannel(false)
        .build();
    // Remove log noise from client side metrics
    settings.setMetricsProvider(NoopMetricsProvider.INSTANCE);
    prepareAttempts =
        settings.stubSettings().prepareQuerySettings().retrySettings().getMaxAttempts();
    client = BigtableDataClient.create(settings.build());
    paramTypes = ImmutableMap.of("param", SqlType.string());
  }

  private PreparedStatementImpl getDefaultPrepareStatement() {
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT _key, @param AS p FROM table")
            .withParamTypes(paramTypes)
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("plan"),
                    METADATA_PROTO,
                    // Plan expires right away
                    Instant.now())));
    return (PreparedStatementImpl)
        client.prepareStatement("SELECT _key, @param AS p FROM table", paramTypes);
  }

  @After
  public void tearDown() {
    if (client != null) {
      client.close();
    }
  }

  @Test
  public void testBackgroundRefresh() throws InterruptedException, ExecutionException {
    PreparedStatementImpl preparedStatement = getDefaultPrepareStatement();
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT _key, @param AS p FROM table")
            .withParamTypes(paramTypes)
            .respondWith(
                prepareResponse(ByteString.copyFromUtf8("plan2"), METADATA_PROTO, Instant.now())));
    // Refresh won't be triggered until this call
    PreparedQueryData initialPlan = preparedStatement.getLatestPrepareResponse();
    PrepareResponse initialResponse = initialPlan.prepareFuture().get();
    // wait for the second call
    do {
      Thread.sleep(10);
    } while (service.prepareCount < 2);
    Thread.sleep(50);
    PreparedQueryData updatedPlan = preparedStatement.getLatestPrepareResponse();
    PrepareResponse updatedResponse = updatedPlan.prepareFuture().get();
    assertThat(updatedPlan.version()).isNotEqualTo(initialPlan.version());
    assertThat(initialResponse.preparedQuery()).isEqualTo(ByteString.copyFromUtf8("plan"));
    assertThat(initialResponse.resultSetMetadata())
        .isEqualTo(ProtoResultSetMetadata.fromProto(METADATA_PROTO));
    assertThat(updatedResponse.preparedQuery()).isEqualTo(ByteString.copyFromUtf8("plan2"));
    assertThat(updatedResponse.resultSetMetadata())
        .isEqualTo(ProtoResultSetMetadata.fromProto(METADATA_PROTO));
    // We don't expect any additional calls
    assertThat(service.prepareCount).isEqualTo(2);
  }

  @Test
  public void noRefreshBeforeExpiryWindow() throws ExecutionException, InterruptedException {
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT _key, @other AS o FROM table")
            .withParamTypes(paramTypes)
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("other_plan"),
                    METADATA_PROTO,
                    // Don't expire
                    Instant.now().plus(Duration.ofMinutes(10)))));
    PreparedStatementImpl unexpired =
        (PreparedStatementImpl)
            client.prepareStatement("SELECT _key, @other AS o FROM table", paramTypes);
    // Don't expect any refresh
    PreparedQueryData initialPlan = unexpired.getLatestPrepareResponse();
    PrepareResponse initialResponse = initialPlan.prepareFuture().get();

    assertThat(initialResponse.preparedQuery()).isEqualTo(ByteString.copyFromUtf8("other_plan"));
    assertThat(service.prepareCount).isEqualTo(1);
  }

  @Test
  public void testMarkExpiredAndStartRefresh() throws ExecutionException, InterruptedException {
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT _key, @param AS p FROM table")
            .withParamTypes(paramTypes)
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("plan"),
                    METADATA_PROTO,
                    // Plan expires right away
                    Instant.now().plusSeconds(2L))));
    PreparedStatementImpl preparedStatement =
        (PreparedStatementImpl)
            client.prepareStatement("SELECT _key, @param AS p FROM table", paramTypes);
    PreparedQueryData initialPlan = preparedStatement.getLatestPrepareResponse();
    PrepareResponse initialPrepareResponse = initialPlan.prepareFuture().get();

    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT _key, @param AS p FROM table")
            .withParamTypes(paramTypes)
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("hardRefreshPlan"),
                    METADATA_PROTO,
                    Instant.now().plus(Duration.ofMinutes(10)))));

    PreparedQueryData updatedPlan =
        preparedStatement.markExpiredAndStartRefresh(initialPlan.version());
    PrepareResponse updatedPrepareResponse = updatedPlan.prepareFuture().get();

    assertThat(updatedPlan.version()).isNotEqualTo(initialPlan.version());
    assertThat(initialPrepareResponse.preparedQuery()).isEqualTo(ByteString.copyFromUtf8("plan"));
    assertThat(initialPrepareResponse.resultSetMetadata())
        .isEqualTo(ProtoResultSetMetadata.fromProto(METADATA_PROTO));
    assertThat(updatedPrepareResponse.preparedQuery())
        .isEqualTo(ByteString.copyFromUtf8("hardRefreshPlan"));
    assertThat(updatedPrepareResponse.resultSetMetadata())
        .isEqualTo(ProtoResultSetMetadata.fromProto(METADATA_PROTO));
    // We don't expect any additional calls
    assertThat(service.prepareCount).isEqualTo(2);
  }

  @Test
  public void testConcurrentBackgroundRefreshCalls()
      throws InterruptedException, ExecutionException {
    PreparedStatementImpl preparedStatement = getDefaultPrepareStatement();
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT _key, @param AS p FROM table")
            .withParamTypes(paramTypes)
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("plan2"),
                    METADATA_PROTO,
                    Instant.now().plus(Duration.ofMinutes(10)))));
    ExecutorService executor = Executors.newFixedThreadPool(50);
    List<Callable<PreparedQueryData>> callableList = new ArrayList<>();
    for (int i = 0; i < 50; i++) {
      callableList.add(preparedStatement::getLatestPrepareResponse);
    }
    List<Future<PreparedQueryData>> results = executor.invokeAll(callableList);
    executor.shutdown();
    boolean done = executor.awaitTermination(1, TimeUnit.MINUTES);
    assertThat(done).isTrue();
    assertThat(service.prepareCount).isEqualTo(2);
    for (Future<PreparedQueryData> prepareFuture : results) {
      PreparedQueryData response = prepareFuture.get();
      assertThat(response.prepareFuture().get().preparedQuery())
          .isIn(
              // Some will get the first plan, some might get the result of refresh
              ImmutableList.of(ByteString.copyFromUtf8("plan"), ByteString.copyFromUtf8("plan2")));
    }
  }

  @Test
  public void testConcurrentMarkExpiredAndStartRefreshCalls()
      throws InterruptedException, ExecutionException {
    PreparedStatementImpl preparedStatement = getDefaultPrepareStatement();
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT _key, @param AS p FROM table")
            .withParamTypes(paramTypes)
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("plan2"),
                    METADATA_PROTO,
                    Instant.now().plus(Duration.ofMinutes(10)))));
    PreparedQueryData initialData = preparedStatement.getLatestPrepareResponse();
    ExecutorService executor = Executors.newFixedThreadPool(50);
    List<Callable<PreparedQueryData>> callableList = new ArrayList<>();
    for (int i = 0; i < 50; i++) {
      callableList.add(() -> preparedStatement.markExpiredAndStartRefresh(initialData.version()));
    }
    List<Future<PreparedQueryData>> results = executor.invokeAll(callableList);
    executor.shutdown();
    boolean done = executor.awaitTermination(1, TimeUnit.MINUTES);
    assertThat(done).isTrue();
    for (Future<PreparedQueryData> refreshFuture : results) {
      PreparedQueryData response = refreshFuture.get();
      assertThat(response.version()).isNotEqualTo(initialData.version());
      assertThat(response.prepareFuture().get().resultSetMetadata())
          .isEqualTo(ProtoResultSetMetadata.fromProto(METADATA_PROTO));
    }
    assertThat(service.prepareCount).isEqualTo(2);
  }

  @Test
  public void testPrepareFailuresAreRetried() throws ExecutionException, InterruptedException {
    PreparedStatementImpl preparedStatement = getDefaultPrepareStatement();
    int failures = 0;
    // Exhaust all the retries w unavailables
    for (int i = 0; i <= prepareAttempts; i++) {
      service.addExpectation(
          PrepareRpcExpectation.create()
              .withSql("SELECT _key, @param AS p FROM table")
              .withParamTypes(paramTypes)
              .respondWithStatus(Code.UNAVAILABLE));
      failures++;
    }
    // Now exhaust all the retries again w deadline exceeded
    for (int i = 0; i <= prepareAttempts; i++) {
      service.addExpectation(
          PrepareRpcExpectation.create()
              .withSql("SELECT _key, @param AS p FROM table")
              .withParamTypes(paramTypes)
              .respondWithStatus(Code.DEADLINE_EXCEEDED));
      failures++;
    }
    // then succeed
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT _key, @param AS p FROM table")
            .withParamTypes(paramTypes)
            .withDelay(Duration.ofMillis(20))
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("plan2"),
                    METADATA_PROTO,
                    Instant.now().plus(Duration.ofMinutes(10)))));
    PreparedQueryData initialData = preparedStatement.getLatestPrepareResponse();
    PreparedQueryData nextData =
        preparedStatement.markExpiredAndStartRefresh(initialData.version());

    assertThat(nextData.prepareFuture().get().preparedQuery())
        .isEqualTo(ByteString.copyFromUtf8("plan2"));
    // initial request + failures + final success
    assertThat(service.prepareCount).isEqualTo(1 + failures + 1);
  }

  @Test
  public void garbageCollectionWorksWhenRetryIsOngoing() throws InterruptedException {
    PreparedStatementImpl preparedStatement = getDefaultPrepareStatement();

    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT _key, @param AS p FROM table")
            .withParamTypes(paramTypes)
            .withDelay(Duration.ofSeconds(1))
            // Return a permanent error so the stub doesn't retry
            .respondWithStatus(Code.INTERNAL));
    WeakReference<PreparedStatement> weakRef = new WeakReference<>(preparedStatement);
    PreparedQueryVersion initialPlanId = preparedStatement.getLatestPrepareResponse().version();
    PreparedQueryData next = preparedStatement.markExpiredAndStartRefresh(initialPlanId);
    preparedStatement = null;
    for (int i = 0; i < 5; i++) {
      // This isn't guaranteed to run GC, so call it a few times. Testing has shown that this
      // is enough to prevent any flakes in 1000 runs
      System.gc();
      Thread.sleep(10);
    }
    assertThat(service.prepareCount).isEqualTo(2);
    assertThat(weakRef.get()).isNull();
    // The plan refresh stops retrying after the PreparedStatement is garbage collected.
    // Because this means it isn't needed anymore, we don't want to keep refreshing.
    assertThrows(
        RuntimeException.class,
        () -> ApiExceptions.callAndTranslateApiException(next.prepareFuture()));
  }

  @Test
  public void testPrepareQueryStateInitialState() throws ExecutionException, InterruptedException {
    ResultSetMetadata md = metadata(columnMetadata("strCol", stringType()));
    PrepareQueryState state =
        PrepareQueryState.createInitialState(
            PrepareResponse.fromProto(prepareResponse(ByteString.copyFromUtf8("plan"), md)));
    assertThat(state.current().prepareFuture().isDone()).isTrue();
    assertThat(state.current().prepareFuture().get().resultSetMetadata())
        .isEqualTo(ProtoResultSetMetadata.fromProto(md));
    assertThat(state.maybeBackgroundRefresh()).isEmpty();
  }

  @Test
  public void testPrepareQueryStateWithBackgroundPlan()
      throws ExecutionException, InterruptedException {
    ResultSetMetadata md = metadata(columnMetadata("strCol", stringType()));
    PrepareQueryState state =
        PrepareQueryState.createInitialState(
            PrepareResponse.fromProto(prepareResponse(ByteString.copyFromUtf8("plan"), md)));

    PrepareQueryState withBackgroundPlan =
        state.withBackgroundPlan(
            ApiFutures.immediateFuture(PrepareResponse.fromProto(prepareResponse(md))));
    assertThat(withBackgroundPlan.current().prepareFuture().isDone()).isTrue();
    assertThat(withBackgroundPlan.current().prepareFuture().get().resultSetMetadata())
        .isEqualTo(ProtoResultSetMetadata.fromProto(md));
    assertThat(withBackgroundPlan.current().version()).isEqualTo(state.current().version());
    assertThat(withBackgroundPlan.maybeBackgroundRefresh()).isPresent();
    assertThat(withBackgroundPlan.maybeBackgroundRefresh().get().version())
        .isNotEqualTo(withBackgroundPlan.current().version());
    assertThat(
            withBackgroundPlan
                .maybeBackgroundRefresh()
                .get()
                .prepareFuture()
                .get()
                .resultSetMetadata())
        .isEqualTo(ProtoResultSetMetadata.fromProto(md));
  }

  @Test
  public void testPrepareQueryStatePromoteBackgroundPlan()
      throws ExecutionException, InterruptedException {
    ResultSetMetadata md = metadata(columnMetadata("strCol", stringType()));
    PrepareQueryState state =
        PrepareQueryState.createInitialState(
            PrepareResponse.fromProto(prepareResponse(ByteString.copyFromUtf8("plan"), md)));
    PrepareQueryState withBackgroundPlan =
        state.withBackgroundPlan(
            ApiFutures.immediateFuture(PrepareResponse.fromProto(prepareResponse(md))));
    PrepareQueryState finalState = withBackgroundPlan.promoteBackgroundPlan();

    assertThat(finalState.current().version())
        .isEqualTo(withBackgroundPlan.maybeBackgroundRefresh().get().version());
    assertThat(finalState.current().prepareFuture().get().resultSetMetadata())
        .isEqualTo(ProtoResultSetMetadata.fromProto(md));
  }
}
