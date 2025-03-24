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
package com.google.cloud.bigtable.data.v2.stub.sql;

import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.bytesType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.bytesValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.columnMetadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.metadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSetWithToken;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSetWithoutToken;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSets;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.planRefreshError;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.prepareResponse;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.tokenOnlyResultSet;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.FailedPreconditionException;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.InternalException;
import com.google.api.gax.rpc.StatusCode;
import com.google.bigtable.v2.ExecuteQueryResponse;
import com.google.bigtable.v2.ResultSetMetadata;
import com.google.bigtable.v2.Value;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.sql.PreparedStatement;
import com.google.cloud.bigtable.data.v2.models.sql.PreparedStatementRefreshTimeoutException;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSet;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStubSettings;
import com.google.cloud.bigtable.data.v2.stub.metrics.NoopMetricsProvider;
import com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.ExecuteRpcExpectation;
import com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.PrepareRpcExpectation;
import com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.TestBigtableSqlService;
import com.google.cloud.bigtable.gaxx.reframing.IncompleteStreamException;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import io.grpc.testing.GrpcServerRule;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ExecuteQueryRetryTest {
  private static final ByteString PREPARED_QUERY = ByteString.copyFromUtf8("foo");
  private static final ResultSetMetadata DEFAULT_METADATA =
      metadata(columnMetadata("strCol", stringType()));

  @Rule public GrpcServerRule serverRule = new GrpcServerRule();
  private TestBigtableSqlService service;
  private BigtableDataClient client;
  private PreparedStatement preparedStatement;

  public static BigtableDataSettings.Builder defaultSettings(GrpcServerRule serverRule) {
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
    return settings;
  }

  @Before
  public void setUp() throws IOException {
    service = new TestBigtableSqlService();
    serverRule.getServiceRegistry().addService(service);
    client = BigtableDataClient.create(defaultSettings(serverRule).build());
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWith(prepareResponse(PREPARED_QUERY, DEFAULT_METADATA)));
    preparedStatement = client.prepareStatement("SELECT * FROM table", new HashMap<>());
    // Reset the count of RPCs
    service.prepareCount--;
  }

  @After
  public void tearDown() {
    if (client != null) {
      client.close();
    }
  }

  @Test
  public void testAllSuccesses() {
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .respondWith(
                partialResultSetWithoutToken(stringValue("foo")),
                partialResultSetWithoutToken(stringValue("bar")),
                partialResultSetWithToken(stringValue("baz"))));
    ResultSet rs = client.executeQuery(preparedStatement.bind().build());
    assertThat(rs.getMetadata().getColumns()).hasSize(1);
    assertThat(rs.getMetadata().getColumns().get(0).name()).isEqualTo("strCol");
    assertThat(rs.getMetadata().getColumns().get(0).type()).isEqualTo(SqlType.string());

    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("foo");
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("bar");
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("baz");
    assertThat(rs.next()).isFalse();
    rs.close();
  }

  @Test
  public void testRetryOnInitialError() {
    // - First attempt immediately fails
    // - Second attempt returns 'foo', w a token, and succeeds
    // Expect result to be 'foo'
    service.addExpectation(ExecuteRpcExpectation.create().respondWithStatus(Code.UNAVAILABLE));
    service.addExpectation(
        ExecuteRpcExpectation.create().respondWith(partialResultSetWithToken(stringValue("foo"))));

    ResultSet rs = client.executeQuery(preparedStatement.bind().build());
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("foo");
    assertThat(rs.next()).isFalse();
    rs.close();
    assertThat(service.executeCount).isEqualTo(2);
  }

  @Test
  public void testResumptionToken() {
    // - First attempt gets a response with a token, and then fails with unavailable
    // - Second Expects the request to contain the previous token, and returns a new response w
    //   token and then fails with unavailable
    // - Third expects the request to contain the second token, returns a new response w token
    //   and then succeeds
    // We expect the results to contain all of the returned data (no reset batches)
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .respondWith(
                partialResultSetWithToken(ByteString.copyFromUtf8("token1"), stringValue("foo")))
            .respondWithStatus(Code.UNAVAILABLE));
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .withResumeToken(ByteString.copyFromUtf8("token1"))
            .respondWith(
                partialResultSetWithToken(ByteString.copyFromUtf8("token2"), stringValue("bar")))
            .respondWithStatus(Code.UNAVAILABLE));
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .withResumeToken(ByteString.copyFromUtf8("token2"))
            .respondWith(
                partialResultSetWithToken(ByteString.copyFromUtf8("final"), stringValue("baz"))));

    ResultSet rs = client.executeQuery(preparedStatement.bind().build());
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("foo");
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("bar");
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("baz");
    assertThat(rs.next()).isFalse();
    rs.close();
    assertThat(service.executeCount).isEqualTo(3);
  }

  @Test
  public void testResetOnResumption() {
    // - First attempt returns 'foo' with 'token1', then 'discard' w no token, then fails
    // - Second attempt should resume w 'token1', returns an incomplete batch of two chunks. First
    //   chunk contains the reset bit and a some data, second contains some data, we fail w/o
    //   returning the final chunk w a token.
    // - Third attempt should resume w 'token1', we return 'baz' w reset & a token, succeed
    // Expect the results to be 'foo' and 'baz'
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .respondWith(
                partialResultSetWithToken(ByteString.copyFromUtf8("token1"), stringValue("foo")),
                // This is after the token so should be dropped
                partialResultSetWithoutToken(stringValue("discard")))
            .respondWithStatus(Code.UNAVAILABLE));
    List<ExecuteQueryResponse> chunkedResponses =
        partialResultSets(
            3,
            true,
            ByteString.copyFromUtf8("token2"),
            stringValue("longerStringDiscard"),
            stringValue("discard"));
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .withResumeToken(ByteString.copyFromUtf8("token1"))
            // Skip the last response, so we don't send a new token
            .respondWith(chunkedResponses.get(0), chunkedResponses.get(1))
            .respondWithStatus(Code.UNAVAILABLE));
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .withResumeToken(ByteString.copyFromUtf8("token1"))
            .respondWith(
                partialResultSets(1, true, ByteString.copyFromUtf8("final"), stringValue("baz"))
                    .get(0)));

    ResultSet rs = client.executeQuery(preparedStatement.bind().build());
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("foo");
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("baz");
    assertThat(rs.next()).isFalse();
    rs.close();
    assertThat(service.executeCount).isEqualTo(3);
  }

  @Test
  public void testErrorAfterFinalData() {
    // - First attempt returns 'foo', 'bar', 'baz' w 'finalToken' but fails w unavailable
    // - Second attempt uses 'finalToken' and succeeds
    // Expect results to be 'foo', 'bar', 'baz'
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .respondWith(
                partialResultSetWithoutToken(stringValue("foo")),
                partialResultSetWithoutToken(stringValue("bar")),
                partialResultSetWithToken(
                    ByteString.copyFromUtf8("finalToken"), stringValue("baz")))
            .respondWithStatus(Code.UNAVAILABLE));
    service.addExpectation(
        ExecuteRpcExpectation.create().withResumeToken(ByteString.copyFromUtf8("finalToken")));
    ResultSet rs = client.executeQuery(preparedStatement.bind().build());
    assertThat(rs.getMetadata().getColumns()).hasSize(1);
    assertThat(rs.getMetadata().getColumns().get(0).name()).isEqualTo("strCol");
    assertThat(rs.getMetadata().getColumns().get(0).type()).isEqualTo(SqlType.string());

    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("foo");
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("bar");
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("baz");
    assertThat(rs.next()).isFalse();
    rs.close();
  }

  @Test
  public void permanentErrorPropagatesToMetadata() {
    service.addExpectation(ExecuteRpcExpectation.create().respondWithStatus(Code.INVALID_ARGUMENT));

    ResultSet rs = client.executeQuery(preparedStatement.bind().build());
    ApiException e = assertThrows(ApiException.class, rs::getMetadata);
    assertThat(e.getStatusCode().getCode()).isEqualTo(StatusCode.Code.INVALID_ARGUMENT);
  }

  @Test
  public void exhaustedRetriesPropagatesToMetadata() throws IOException {
    int attempts =
        EnhancedBigtableStubSettings.newBuilder()
            .executeQuerySettings()
            .getRetrySettings()
            .getMaxAttempts();
    assertThat(attempts).isGreaterThan(1);
    for (int i = 0; i < attempts; i++) {
      service.addExpectation(ExecuteRpcExpectation.create().respondWithStatus(Code.UNAVAILABLE));
    }

    ResultSet rs = client.executeQuery(preparedStatement.bind().build());
    ApiException e = assertThrows(ApiException.class, rs::getMetadata);
    assertThat(e.getStatusCode().getCode()).isEqualTo(StatusCode.Code.UNAVAILABLE);
  }

  @Test
  public void retryableErrorWithSuccessfulRetryDoesNotPropagateToMetadata() {
    service.addExpectation(ExecuteRpcExpectation.create().respondWithStatus(Code.UNAVAILABLE));
    service.addExpectation(ExecuteRpcExpectation.create().respondWithStatus(Code.UNAVAILABLE));
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .respondWith(tokenOnlyResultSet(ByteString.copyFromUtf8("t"))));
    ResultSet rs = client.executeQuery(preparedStatement.bind().build());
    assertThat(rs.getMetadata().getColumns()).hasSize(1);
  }

  @Test
  public void preservesParamsOnRetry() {
    Map<String, SqlType<?>> paramTypes = ImmutableMap.of("strParam", SqlType.string());
    PreparedStatement preparedStatementWithParams =
        SqlProtoFactory.preparedStatement(
            metadata(columnMetadata("strCol", stringType())), paramTypes);
    Map<String, Value> params =
        ImmutableMap.of("strParam", stringValue("foo").toBuilder().setType(stringType()).build());
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .withParams(params)
            .respondWith(
                partialResultSetWithToken(ByteString.copyFromUtf8("token1"), stringValue("foo")))
            .respondWithStatus(Code.UNAVAILABLE));
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .withParams(params)
            .withResumeToken(ByteString.copyFromUtf8("token1"))
            .respondWith(
                partialResultSetWithToken(ByteString.copyFromUtf8("token2"), stringValue("bar"))));

    ResultSet rs =
        client.executeQuery(
            preparedStatementWithParams.bind().setStringParam("strParam", "foo").build());
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("foo");
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("bar");
    assertThat(rs.next()).isFalse();
  }

  @Test
  public void failsOnCompleteWithOpenPartialBatch() {
    // Return 'foo' with no token, followed by ok
    // This should throw an error, as the backend has violated its contract
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .respondWith(partialResultSetWithoutToken(stringValue("foo")))
            .respondWithStatus(Code.OK));
    ResultSet rs = client.executeQuery(preparedStatement.bind().build());
    assertThrows(IncompleteStreamException.class, rs::next);
  }

  @Test
  public void retryOnExpiredPlan() {
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("bar"),
                    metadata(columnMetadata("bytesCol", bytesType())))));
    // change the schema on refresh (this can happen for SELECT * queries for example)
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("baz"),
                    metadata(columnMetadata("strCol", stringType())))));
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .withPreparedQuery(ByteString.copyFromUtf8("bar"))
            .respondWithException(Code.FAILED_PRECONDITION, planRefreshError()));
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .withPreparedQuery(ByteString.copyFromUtf8("baz"))
            .respondWith(partialResultSetWithToken(stringValue("foo"))));

    PreparedStatement ps = client.prepareStatement("SELECT * FROM table", new HashMap<>());
    ResultSet rs = client.executeQuery(ps.bind().build());
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("foo");
    assertThat(rs.next()).isFalse();
    assertThat(service.executeCount).isEqualTo(2);
    assertThat(service.prepareCount).isEqualTo(2);
  }

  @Test
  public void planRefreshAfterInitialPartialBatch() {
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("bar"),
                    metadata(columnMetadata("bytesCol", bytesType())))));
    // change the schema on refresh (this can happen for SELECT * queries for example)
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("baz"),
                    metadata(columnMetadata("strCol", stringType())))));
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .withPreparedQuery(ByteString.copyFromUtf8("bar"))
            .respondWith(partialResultSetWithoutToken(bytesValue("b")))
            .respondWithStatus(Code.UNAVAILABLE));
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .withPreparedQuery(ByteString.copyFromUtf8("bar"))
            .respondWithException(Code.FAILED_PRECONDITION, planRefreshError()));
    // This creates one response w reset=true and a token
    List<ExecuteQueryResponse> singleResponseBatch = partialResultSets(1, stringValue("foo"));
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .withPreparedQuery(ByteString.copyFromUtf8("baz"))
            .respondWith(singleResponseBatch.get(0)));

    PreparedStatement ps = client.prepareStatement("SELECT * FROM table", new HashMap<>());
    ResultSet rs = client.executeQuery(ps.bind().build());
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("foo");
    assertThat(rs.next()).isFalse();
    assertThat(rs.getMetadata().getColumnType("strCol")).isEqualTo(SqlType.string());
    assertThat(service.executeCount).isEqualTo(3);
    assertThat(service.prepareCount).isEqualTo(2);
  }

  @Test
  public void planRefreshErrorAfterFirstTokenCausesError() {
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("bar"),
                    metadata(columnMetadata("bytesCol", bytesType())))));
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .withPreparedQuery(ByteString.copyFromUtf8("bar"))
            .respondWith(partialResultSetWithToken(bytesValue("b")))
            .respondWithException(Code.FAILED_PRECONDITION, planRefreshError()));

    PreparedStatement ps = client.prepareStatement("SELECT * FROM table", new HashMap<>());
    ResultSet rs = client.executeQuery(ps.bind().build());
    assertThat(rs.next()).isTrue();
    // We received a token so the client yields the data
    assertThat(rs.getBytes("bytesCol").toStringUtf8()).isEqualTo("b");
    IllegalStateException e = assertThrows(IllegalStateException.class, rs::next);
    assertThat(e.getCause()).isInstanceOf(FailedPreconditionException.class);
  }

  @Test
  public void preparedStatementCanBeGarbageCollected() throws InterruptedException {
    // Check for memory leaks since the PreparedStatement handles background refresh
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("foo"),
                    metadata(columnMetadata("strCol", stringType())))));
    service.addExpectation(
        ExecuteRpcExpectation.create().respondWith(partialResultSetWithToken(stringValue("s"))));
    PreparedStatement ps = client.prepareStatement("SELECT * FROM table", new HashMap<>());
    WeakReference<PreparedStatement> prepareWeakRef = new WeakReference<>(ps);
    ResultSet rs = client.executeQuery(ps.bind().build());
    WeakReference<ResultSet> resultSetWeakRef = new WeakReference<>(rs);
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("s");
    assertThat(rs.next()).isFalse();
    rs.close();
    // Note that the result set holds a reference to the ResultSetMetadata that lives in
    // the PreparedStatement. So prepare won't be gc'd until the ResultSet is null.
    rs = null;
    ps = null;
    for (int i = 0; i < 5; i++) {
      // This isn't guaranteed to run GC, so call it a few times. Testing has shown that this
      // is enough to prevent any flakes in 1000 runs
      System.gc();
      Thread.sleep(10);
    }
    assertThat(resultSetWeakRef.get()).isNull();
    assertThat(prepareWeakRef.get()).isNull();
  }

  @Test
  public void planRefreshRespectsExecuteTotalTimeout() throws IOException {
    BigtableDataSettings.Builder settings = defaultSettings(serverRule);
    settings
        .stubSettings()
        .executeQuerySettings()
        .setRetrySettings(
            RetrySettings.newBuilder()
                .setMaxAttempts(10)
                .setTotalTimeoutDuration(Duration.ofMillis(30))
                .build())
        .build();
    settings.stubSettings().build();
    BigtableDataClient clientWithTimeout = BigtableDataClient.create(settings.build());

    // Initially return a prepare response without delay
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("foo"),
                    metadata(columnMetadata("strCol", stringType())))));
    // Trigger plan refresh
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .respondWithException(Code.FAILED_PRECONDITION, planRefreshError()));
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withDelay(Duration.ofSeconds(2))
            .withSql("SELECT * FROM table")
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("bar"),
                    metadata(columnMetadata("strCol", stringType())))));

    PreparedStatement ps =
        clientWithTimeout.prepareStatement("SELECT * FROM table", new HashMap<>());
    ResultSet rs = clientWithTimeout.executeQuery(ps.bind().build());
    assertThrows(PreparedStatementRefreshTimeoutException.class, rs::next);
    assertThat(service.prepareCount).isEqualTo(2);
  }

  @Test
  public void planRefreshRespectsAttemptTimeout() throws IOException {
    BigtableDataSettings.Builder settings = defaultSettings(serverRule);
    settings
        .stubSettings()
        .executeQuerySettings()
        .setRetrySettings(
            RetrySettings.newBuilder()
                // First attempt triggers plan refresh retry.
                // Second should time out
                .setMaxAttempts(2)
                .setInitialRpcTimeoutDuration(Duration.ofMillis(500))
                .setMaxRpcTimeoutDuration(Duration.ofMinutes(500))
                .setTotalTimeoutDuration(Duration.ZERO)
                .build())
        .build();
    settings.stubSettings().build();
    BigtableDataClient clientWithTimeout = BigtableDataClient.create(settings.build());

    // Initially return a prepare response without delay
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("foo"),
                    metadata(columnMetadata("strCol", stringType())))));
    // Trigger plan refresh
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .respondWithException(Code.FAILED_PRECONDITION, planRefreshError()));
    // called after failed precondition
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withDelay(Duration.ofSeconds(2))
            .withSql("SELECT * FROM table")
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("bar"),
                    metadata(columnMetadata("strCol", stringType())))));

    PreparedStatement ps =
        clientWithTimeout.prepareStatement("SELECT * FROM table", new HashMap<>());
    ResultSet rs = clientWithTimeout.executeQuery(ps.bind().build());
    assertThrows(PreparedStatementRefreshTimeoutException.class, rs::next);
    assertThat(service.prepareCount).isEqualTo(2);
  }

  @Test
  public void executeRetriesPlanRefreshErrors() throws IOException {
    // Initially return a prepare response without delay
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("foo"),
                    metadata(columnMetadata("strCol", stringType())))));
    // Trigger plan refresh
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .respondWithException(Code.FAILED_PRECONDITION, planRefreshError()));
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWithStatus(Code.UNAVAILABLE));
    // called after unavailable
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withDelay(Duration.ofSeconds(2))
            .withSql("SELECT * FROM table")
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("bar"),
                    metadata(columnMetadata("strCol", stringType())))));
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .withPreparedQuery(ByteString.copyFromUtf8("bar"))
            .respondWith(partialResultSetWithToken(stringValue("s"))));

    PreparedStatement ps = client.prepareStatement("SELECT * FROM table", new HashMap<>());
    ResultSet rs = client.executeQuery(ps.bind().build());
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("s");
    assertThat(rs.next()).isFalse();
    assertThat(service.executeCount).isEqualTo(2);
    assertThat(service.prepareCount).isEqualTo(3);
  }

  @Test
  public void prepareFailuresBurnExecuteAttempts() throws IOException {
    BigtableDataSettings.Builder settings = defaultSettings(serverRule);
    settings
        .stubSettings()
        .executeQuerySettings()
        .setRetrySettings(
            RetrySettings.newBuilder()
                .setMaxAttempts(4)
                .setInitialRpcTimeoutDuration(Duration.ofMinutes(10))
                .setMaxRpcTimeoutDuration(Duration.ofMinutes(10))
                .setTotalTimeoutDuration(Duration.ofMinutes(50))
                .build())
        .build();
    settings.stubSettings().build();
    BigtableDataClient clientWithTimeout = BigtableDataClient.create(settings.build());

    // Initially return a prepare response without delay
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("foo"),
                    metadata(columnMetadata("strCol", stringType())))));
    // Attempt 1 - Trigger plan refresh
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .respondWithException(Code.FAILED_PRECONDITION, planRefreshError()));
    // Attempt 2
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWithStatus(Code.INTERNAL));
    // Attempt 3
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWithStatus(Code.INTERNAL));
    // Attempt 4
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWithStatus(Code.INTERNAL));
    // This is triggered by the failure in attempt 4. It succeeds
    // but isn't used bc execute stops retrying
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("bar"),
                    metadata(columnMetadata("strCol", stringType())))));

    PreparedStatement ps =
        clientWithTimeout.prepareStatement("SELECT * FROM table", new HashMap<>());
    ResultSet rs = clientWithTimeout.executeQuery(ps.bind().build());
    assertThrows(ApiException.class, rs::next);
    // initial success plus 3 refresh failures, plus (maybe) refresh triggered by the final failure
    assertThat(service.prepareCount).isGreaterThan(3);
  }

  @Test
  public void canRetryAfterRefreshAttemptTimeout() throws IOException {
    BigtableDataSettings.Builder settings = defaultSettings(serverRule);
    settings
        .stubSettings()
        .executeQuerySettings()
        .setRetrySettings(
            RetrySettings.newBuilder()
                // First attempt triggers plan refresh retry.
                // Second should time out, third should succeed
                .setMaxAttempts(3)
                .setInitialRpcTimeoutDuration(Duration.ofSeconds(1))
                .setMaxRpcTimeoutDuration(Duration.ofSeconds(1))
                .setTotalTimeoutDuration(Duration.ofSeconds(5))
                .build())
        .build();
    settings.stubSettings().build();
    BigtableDataClient clientWithTimeout = BigtableDataClient.create(settings.build());

    // Initially return a prepare response without delay
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("foo"),
                    metadata(columnMetadata("strCol", stringType())))));
    // Attempt 1 - Trigger plan refresh
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .respondWithException(Code.FAILED_PRECONDITION, planRefreshError()));
    // Attempt 2
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            // first refresh attempt times out, but then it succeeds
            .withDelay(Duration.ofMillis(1500))
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("bar"),
                    metadata(columnMetadata("strCol", stringType())))));

    service.addExpectation(
        ExecuteRpcExpectation.create()
            .withPreparedQuery(ByteString.copyFromUtf8("bar"))
            .respondWith(partialResultSetWithToken(stringValue("s"))));

    PreparedStatement ps =
        clientWithTimeout.prepareStatement("SELECT * FROM table", new HashMap<>());
    ResultSet rs = clientWithTimeout.executeQuery(ps.bind().build());
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("s");
    assertThat(rs.next()).isFalse();
    assertThat(service.executeCount).isEqualTo(2);
    assertThat(service.prepareCount).isEqualTo(2);
  }

  @Test
  public void prepareRefreshTimeIsFactoredIntoExecuteAttemptTimeout() throws IOException {
    BigtableDataSettings.Builder settings = defaultSettings(serverRule);
    settings
        .stubSettings()
        .executeQuerySettings()
        .setRetrySettings(
            RetrySettings.newBuilder()
                // First attempt triggers plan refresh retry.
                // Second should time out, third should succeed
                .setMaxAttempts(2)
                .setInitialRpcTimeoutDuration(Duration.ofMillis(500))
                .setMaxRpcTimeoutDuration(Duration.ofMillis(500))
                .setTotalTimeoutDuration(Duration.ofMinutes(500))
                .build())
        .build();
    settings.stubSettings().build();
    BigtableDataClient clientWithTimeout = BigtableDataClient.create(settings.build());
    // Initially return a prepare response without delay
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("foo"),
                    metadata(columnMetadata("strCol", stringType())))));
    // Attempt 1 - Trigger plan refresh
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .respondWithException(Code.FAILED_PRECONDITION, planRefreshError()));
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            // Burn most of the execute attempt timeout and succeed
            .withDelay(Duration.ofMillis(350))
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("bar"),
                    metadata(columnMetadata("strCol", stringType())))));
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .withPreparedQuery(ByteString.copyFromUtf8("bar"))
            // Should timeout bc we used 350 ms on prepare refresh and have 500ms timeout
            .withDelay(Duration.ofMillis(350))
            .respondWith(partialResultSetWithToken(stringValue("s"))));

    PreparedStatement ps =
        clientWithTimeout.prepareStatement("SELECT * FROM table", new HashMap<>());
    ResultSet rs = clientWithTimeout.executeQuery(ps.bind().build());
    ApiException e = assertThrows(ApiException.class, rs::next);
    assertThat(e.getStatusCode().getCode()).isEqualTo(StatusCode.Code.DEADLINE_EXCEEDED);
    // initial success plus one refresh
    assertThat(service.prepareCount).isEqualTo(2);
    // refresh error plus timed out req
    assertThat(service.executeCount).isEqualTo(2);
  }

  @Test
  public void retriesRstStreamError() {
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("foo"),
                    metadata(columnMetadata("strCol", stringType())))));
    ApiException rstStreamException =
        new InternalException(
            new StatusRuntimeException(
                Status.INTERNAL.withDescription(
                    "INTERNAL: HTTP/2 error code: INTERNAL_ERROR\nReceived Rst Stream")),
            GrpcStatusCode.of(Status.Code.INTERNAL),
            false);
    service.addExpectation(
        ExecuteRpcExpectation.create().respondWithException(Code.INTERNAL, rstStreamException));
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .withPreparedQuery(ByteString.copyFromUtf8("foo"))
            .respondWith(partialResultSetWithToken(stringValue("s"))));

    PreparedStatement ps = client.prepareStatement("SELECT * FROM table", new HashMap<>());
    ResultSet rs = client.executeQuery(ps.bind().build());
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("s");
    assertThat(rs.next()).isFalse();
    assertThat(service.executeCount).isEqualTo(2);
    assertThat(service.prepareCount).isEqualTo(1);
  }

  @Test
  public void retriesRetriableAuthException() {
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("foo"),
                    metadata(columnMetadata("strCol", stringType())))));
    ApiException authException =
        new InternalException(
            new StatusRuntimeException(
                Status.INTERNAL.withDescription(
                    "Authentication backend internal server error. Please retry")),
            GrpcStatusCode.of(Status.Code.INTERNAL),
            false);
    service.addExpectation(
        ExecuteRpcExpectation.create().respondWithException(Code.INTERNAL, authException));
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .withPreparedQuery(ByteString.copyFromUtf8("foo"))
            .respondWith(partialResultSetWithToken(stringValue("s"))));

    PreparedStatement ps = client.prepareStatement("SELECT * FROM table", new HashMap<>());
    ResultSet rs = client.executeQuery(ps.bind().build());
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("s");
    assertThat(rs.next()).isFalse();
    assertThat(service.executeCount).isEqualTo(2);
    assertThat(service.prepareCount).isEqualTo(1);
  }

  @Test
  public void retriesGoAwayException() {
    service.addExpectation(
        PrepareRpcExpectation.create()
            .withSql("SELECT * FROM table")
            .respondWith(
                prepareResponse(
                    ByteString.copyFromUtf8("foo"),
                    metadata(columnMetadata("strCol", stringType())))));
    ApiException authException =
        new InternalException(
            new StatusRuntimeException(
                Status.INTERNAL.withDescription("Stream closed before write could take place")),
            GrpcStatusCode.of(Status.Code.INTERNAL),
            false);
    service.addExpectation(
        ExecuteRpcExpectation.create().respondWithException(Code.INTERNAL, authException));
    service.addExpectation(
        ExecuteRpcExpectation.create()
            .withPreparedQuery(ByteString.copyFromUtf8("foo"))
            .respondWith(partialResultSetWithToken(stringValue("s"))));

    PreparedStatement ps = client.prepareStatement("SELECT * FROM table", new HashMap<>());
    ResultSet rs = client.executeQuery(ps.bind().build());
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("s");
    assertThat(rs.next()).isFalse();
    assertThat(service.executeCount).isEqualTo(2);
    assertThat(service.prepareCount).isEqualTo(1);
  }
}
