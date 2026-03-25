/*
 * Copyright 2025 Google LLC
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.connection.RandomResultSetGenerator;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.rpc.RetryInfo;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.protobuf.ProtoUtils;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@SuppressWarnings({"StatementWithEmptyBody", "resource"})
@RunWith(JUnit4.class)
public class RequestIdMockServerTest {
  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private static Spanner spanner;

  private static final Statement SELECT1 = Statement.of("SELECT 1");
  private static final com.google.spanner.v1.ResultSet SELECT1_RESULT_SET =
      com.google.spanner.v1.ResultSet.newBuilder()
          .setMetadata(
              ResultSetMetadata.newBuilder()
                  .setRowType(
                      StructType.newBuilder()
                          .addFields(
                              Field.newBuilder()
                                  .setName("c")
                                  .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                  .build())
                          .build())
                  .build())
          .addRows(
              ListValue.newBuilder()
                  .addValues(Value.newBuilder().setStringValue("1").build())
                  .build())
          .build();
  private static final Statement DML = Statement.of("insert into test_table (id) values (1)");

  private static final ConcurrentLinkedQueue<XGoogSpannerRequestId> requestIds =
      new ConcurrentLinkedQueue<>();

  @BeforeClass
  public static void setup() throws Exception {
    assumeTrue(System.getenv("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS") == null);
    assumeTrue(System.getenv("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS_FOR_RW") == null);

    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.

    InetSocketAddress address = new InetSocketAddress("localhost", 0);
    server =
        NettyServerBuilder.forAddress(address)
            .addService(mockSpanner)
            .intercept(
                new ServerInterceptor() {
                  @Override
                  public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
                      ServerCall<ReqT, RespT> call,
                      Metadata headers,
                      ServerCallHandler<ReqT, RespT> next) {
                    try {
                      String requestId = headers.get(XGoogSpannerRequestId.REQUEST_ID_HEADER_KEY);
                      if (requestId != null) {
                        requestIds.add(XGoogSpannerRequestId.of(requestId));
                      } else {
                        requestIds.add(XGoogSpannerRequestId.of(0, 0, 0, 0));
                      }
                    } catch (Throwable t) {
                      // Ignore and continue
                    }
                    return Contexts.interceptCall(Context.current(), call, headers, next);
                  }
                })
            .build()
            .start();
    spanner = createSpanner();

    setupResults();
  }

  private static Spanner createSpanner() {
    return SpannerOptions.newBuilder()
        .setProjectId("test-project")
        .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
        .setHost("http://localhost:" + server.getPort())
        .setCredentials(NoCredentials.getInstance())
        .setSessionPoolOption(
            SessionPoolOptions.newBuilder()
                .setFailOnSessionLeak()
                .setMinSessions(0)
                .setSkipVerifyingBeginTransactionForMuxRW(true)
                .setWaitForMinSessions(Duration.ofSeconds(5))
                .build())
        .build()
        .getService();
  }

  private static void setupResults() {
    mockSpanner.putStatementResult(StatementResult.query(SELECT1, SELECT1_RESULT_SET));
    mockSpanner.putStatementResult(StatementResult.update(DML, 1L));
  }

  static Metadata createMinimalRetryInfo() {
    Metadata trailers = new Metadata();
    RetryInfo retryInfo =
        RetryInfo.newBuilder()
            .setRetryDelay(
                com.google.protobuf.Duration.newBuilder()
                    .setNanos((int) TimeUnit.MILLISECONDS.toNanos(1L))
                    .setSeconds(0L))
            .build();
    trailers.put(ProtoUtils.keyForProto(RetryInfo.getDefaultInstance()), retryInfo);
    return trailers;
  }

  @AfterClass
  public static void teardown() throws InterruptedException {
    if (spanner != null) {
      spanner.close();
    }
    if (server != null) {
      server.shutdown();
      server.awaitTermination();
    }
  }

  @Before
  public void prepareTest() {
    // Call getClient() to make sure the multiplexed session has been created.
    // Then clear all requests that were received as part of that so we don't need to include
    // that in the test verifications.
    getClient();
    mockSpanner.reset();
    requestIds.clear();
    ((SpannerImpl) spanner).resetRequestIdCounters();
  }

  private DatabaseClient getClient() {
    return spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
  }

  private long getClientId() {
    return ((SpannerImpl) spanner).getRequestIdClientId();
  }

  @Test
  public void testSingleUseQuery() {
    try (ResultSet resultSet = getClient().singleUse().executeQuery(SELECT1)) {
      while (resultSet.next()) {}
    }

    assertEquals(ImmutableList.of(ExecuteSqlRequest.class), mockSpanner.getRequestTypes());
    List<XGoogSpannerRequestId> actual = ImmutableList.copyOf(requestIds);
    verifyRequestIds(ImmutableList.of(XGoogSpannerRequestId.of(getClientId(), -1, 1, 1)), actual);
  }

  @Test
  public void testQueryError() {
    Statement query = Statement.of("select * from invalid_table");
    mockSpanner.putStatementResult(
        StatementResult.exception(
            query, Status.NOT_FOUND.withDescription("Table not found").asRuntimeException()));

    XGoogSpannerRequestId requestIdFromException;
    try (ResultSet resultSet = getClient().singleUse().executeQuery(query)) {
      SpannerException exception = assertThrows(SpannerException.class, resultSet::next);
      assertEquals(ErrorCode.NOT_FOUND, exception.getErrorCode());
      assertNotNull(exception.getRequestId());
      assertNotEquals("Request ID should not be empty", "", exception.getRequestId());
      requestIdFromException = XGoogSpannerRequestId.of(exception.getRequestId());
    }

    assertEquals(ImmutableList.of(ExecuteSqlRequest.class), mockSpanner.getRequestTypes());
    List<XGoogSpannerRequestId> actual = ImmutableList.copyOf(requestIds);
    verifyRequestIds(ImmutableList.of(XGoogSpannerRequestId.of(getClientId(), -1, 1, 1)), actual);
    assertEquals(actual.get(0), requestIdFromException);
  }

  @Test
  public void testMultiUseReadOnlyTransaction() {
    try (ReadOnlyTransaction transaction = getClient().readOnlyTransaction()) {
      for (int i = 0; i < 2; i++) {
        try (ResultSet resultSet = transaction.executeQuery(SELECT1)) {
          while (resultSet.next()) {}
        }
      }
    }

    assertEquals(
        ImmutableList.of(
            BeginTransactionRequest.class, ExecuteSqlRequest.class, ExecuteSqlRequest.class),
        mockSpanner.getRequestTypes());
    List<XGoogSpannerRequestId> actual = ImmutableList.copyOf(requestIds);
    verifyRequestIds(
        ImmutableList.of(
            XGoogSpannerRequestId.of(getClientId(), -1, 1, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, 2, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, 3, 1)),
        actual);
    verifySameChannelId(actual);
  }

  @Test
  public void testDml() {
    getClient().readWriteTransaction().run(transaction -> transaction.executeUpdate(DML));

    assertEquals(
        ImmutableList.of(ExecuteSqlRequest.class, CommitRequest.class),
        mockSpanner.getRequestTypes());
    List<XGoogSpannerRequestId> actual = ImmutableList.copyOf(requestIds);
    verifyRequestIds(
        ImmutableList.of(
            XGoogSpannerRequestId.of(getClientId(), -1, 1, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, 2, 1)),
        actual);
    verifySameChannelId(actual);
  }

  @Test
  public void testDmlError() {
    Statement invalidDml = Statement.of("insert into invalid_table (id) values (1)");
    mockSpanner.putStatementResult(
        StatementResult.exception(
            invalidDml, Status.NOT_FOUND.withDescription("Table not found").asRuntimeException()));

    SpannerException exception =
        assertThrows(
            SpannerException.class,
            () ->
                getClient()
                    .readWriteTransaction()
                    .run(transaction -> transaction.executeUpdate(invalidDml)));
    assertEquals(ErrorCode.NOT_FOUND, exception.getErrorCode());
    assertNotNull(exception.getRequestId());
    assertNotEquals("Request ID should not be empty", "", exception.getRequestId());
    XGoogSpannerRequestId requestIdFromException =
        XGoogSpannerRequestId.of(exception.getRequestId());

    assertEquals(ImmutableList.of(ExecuteSqlRequest.class), mockSpanner.getRequestTypes());
    List<XGoogSpannerRequestId> actual = ImmutableList.copyOf(requestIds);
    verifyRequestIds(ImmutableList.of(XGoogSpannerRequestId.of(getClientId(), -1, 1, 1)), actual);
    assertEquals(actual.get(0), requestIdFromException);
  }

  @Test
  public void testAbortedTransaction() {
    mockSpanner.setCommitExecutionTime(
        SimulatedExecutionTime.ofException(
            Status.ABORTED.asRuntimeException(createMinimalRetryInfo())));
    getClient()
        .readWriteTransaction()
        .run(
            transaction -> {
              try (ResultSet resultSet = transaction.executeQuery(SELECT1)) {
                while (resultSet.next()) {}
              }
              return transaction.executeUpdate(DML);
            });

    assertEquals(
        ImmutableList.of(
            ExecuteSqlRequest.class,
            ExecuteSqlRequest.class,
            CommitRequest.class,
            ExecuteSqlRequest.class,
            ExecuteSqlRequest.class,
            CommitRequest.class),
        mockSpanner.getRequestTypes());
    List<XGoogSpannerRequestId> actual = ImmutableList.copyOf(requestIds);
    int requestId = 0;
    verifyRequestIds(
        ImmutableList.of(
            XGoogSpannerRequestId.of(getClientId(), -1, ++requestId, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, ++requestId, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, ++requestId, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, ++requestId, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, ++requestId, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, ++requestId, 1)),
        actual);
    verifySameChannelId(actual.subList(0, 3));
    verifySameChannelId(actual.subList(3, 6));
  }

  @Test
  public void testMix() {
    getClient()
        .readWriteTransaction()
        .run(
            transaction -> {
              try (ResultSet resultSet = transaction.executeQuery(SELECT1)) {
                while (resultSet.next()) {}
              }
              return transaction.executeUpdate(DML);
            });
    try (ReadOnlyTransaction transaction = getClient().readOnlyTransaction()) {
      for (int i = 0; i < 2; i++) {
        try (ResultSet resultSet = transaction.executeQuery(SELECT1)) {
          while (resultSet.next()) {}
        }
      }
    }
    try (ResultSet resultSet = getClient().singleUse().executeQuery(SELECT1)) {
      while (resultSet.next()) {}
    }
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.of("SELECT my_column FROM my_table WHERE 1=1"), SELECT1_RESULT_SET));
    try (ResultSet resultSet =
        getClient().singleUse().read("my_table", KeySet.all(), ImmutableList.of("my_column"))) {
      while (resultSet.next()) {}
    }

    assertEquals(
        ImmutableList.of(
            ExecuteSqlRequest.class,
            ExecuteSqlRequest.class,
            CommitRequest.class,
            BeginTransactionRequest.class,
            ExecuteSqlRequest.class,
            ExecuteSqlRequest.class,
            ExecuteSqlRequest.class,
            ReadRequest.class),
        mockSpanner.getRequestTypes());
    List<XGoogSpannerRequestId> actual = ImmutableList.copyOf(requestIds);
    int requestId = 0;
    verifyRequestIds(
        ImmutableList.of(
            XGoogSpannerRequestId.of(getClientId(), -1, ++requestId, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, ++requestId, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, ++requestId, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, ++requestId, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, ++requestId, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, ++requestId, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, ++requestId, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, ++requestId, 1)),
        actual);
    verifySameChannelId(actual.subList(0, 3));
    verifySameChannelId(actual.subList(3, 6));
  }

  @Test
  public void testUnaryUnavailable() {
    mockSpanner.setExecuteSqlExecutionTime(
        SimulatedExecutionTime.ofException(
            Status.UNAVAILABLE.asRuntimeException(createMinimalRetryInfo())));

    getClient().readWriteTransaction().run(transaction -> transaction.executeUpdate(DML));

    assertEquals(
        ImmutableList.of(ExecuteSqlRequest.class, ExecuteSqlRequest.class, CommitRequest.class),
        mockSpanner.getRequestTypes());
    List<XGoogSpannerRequestId> actual = ImmutableList.copyOf(requestIds);
    verifyRequestIds(
        ImmutableList.of(
            XGoogSpannerRequestId.of(getClientId(), -1, 1, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, 1, 2),
            XGoogSpannerRequestId.of(getClientId(), -1, 2, 1)),
        actual);
    verifySameChannelId(actual);
  }

  @Test
  public void testStreamingQueryUnavailable() {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofException(
            Status.UNAVAILABLE.asRuntimeException(createMinimalRetryInfo())));

    try (ResultSet resultSet = getClient().singleUse().executeQuery(SELECT1)) {
      while (resultSet.next()) {}
    }

    assertEquals(
        ImmutableList.of(ExecuteSqlRequest.class, ExecuteSqlRequest.class),
        mockSpanner.getRequestTypes());
    List<XGoogSpannerRequestId> actual = ImmutableList.copyOf(requestIds);
    verifyRequestIds(
        ImmutableList.of(
            XGoogSpannerRequestId.of(getClientId(), -1, 1, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, 1, 2)),
        actual);
  }

  @Test
  public void testStreamingQueryUnavailableHalfway() {
    int numRows = 5;
    Statement statement = Statement.of("select * from random");
    mockSpanner.putStatementResult(
        StatementResult.query(statement, new RandomResultSetGenerator(numRows).generate()));
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofStreamException(
            Status.UNAVAILABLE.asRuntimeException(createMinimalRetryInfo()), 2));

    try (ResultSet resultSet = getClient().singleUse().executeQuery(statement)) {
      while (resultSet.next()) {}
    }

    assertEquals(
        ImmutableList.of(ExecuteSqlRequest.class, ExecuteSqlRequest.class),
        mockSpanner.getRequestTypes());
    List<XGoogSpannerRequestId> actual = ImmutableList.copyOf(requestIds);
    verifyRequestIds(
        ImmutableList.of(
            XGoogSpannerRequestId.of(getClientId(), -1, 1, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, 1, 2)),
        actual);
    List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(ByteString.empty(), requests.get(0).getResumeToken());
    assertNotEquals(ByteString.empty(), requests.get(1).getResumeToken());
  }

  @Test
  public void testStreamingReadUnavailable() {
    mockSpanner.setStreamingReadExecutionTime(
        SimulatedExecutionTime.ofException(
            Status.UNAVAILABLE.asRuntimeException(createMinimalRetryInfo())));

    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.of("SELECT my_column FROM my_table WHERE 1=1"), SELECT1_RESULT_SET));
    try (ResultSet resultSet =
        getClient().singleUse().read("my_table", KeySet.all(), ImmutableList.of("my_column"))) {
      while (resultSet.next()) {}
    }

    assertEquals(
        ImmutableList.of(ReadRequest.class, ReadRequest.class), mockSpanner.getRequestTypes());
    List<XGoogSpannerRequestId> actual = ImmutableList.copyOf(requestIds);
    verifyRequestIds(
        ImmutableList.of(
            XGoogSpannerRequestId.of(getClientId(), -1, 1, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, 1, 2)),
        actual);
  }

  @Test
  public void testStreamingReadUnavailableHalfway() {
    int numRows = 5;
    Statement statement = Statement.of("SELECT my_column FROM my_table WHERE 1=1");
    mockSpanner.putStatementResult(
        StatementResult.query(statement, new RandomResultSetGenerator(numRows).generate()));
    mockSpanner.setStreamingReadExecutionTime(
        SimulatedExecutionTime.ofStreamException(
            Status.UNAVAILABLE.asRuntimeException(createMinimalRetryInfo()), 2));

    try (ResultSet resultSet =
        getClient().singleUse().read("my_table", KeySet.all(), ImmutableList.of("my_column"))) {
      while (resultSet.next()) {}
    }

    assertEquals(
        ImmutableList.of(ReadRequest.class, ReadRequest.class), mockSpanner.getRequestTypes());
    List<XGoogSpannerRequestId> actual = ImmutableList.copyOf(requestIds);
    verifyRequestIds(
        ImmutableList.of(
            XGoogSpannerRequestId.of(getClientId(), -1, 1, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, 1, 2)),
        actual);
    List<ReadRequest> requests = mockSpanner.getRequestsOfType(ReadRequest.class);
    assertEquals(ByteString.empty(), requests.get(0).getResumeToken());
    assertNotEquals(ByteString.empty(), requests.get(1).getResumeToken());
  }

  @Test
  public void testPartitionedDml() {
    getClient().executePartitionedUpdate(DML);

    assertEquals(
        ImmutableList.of(BeginTransactionRequest.class, ExecuteSqlRequest.class),
        mockSpanner.getRequestTypes());
    List<XGoogSpannerRequestId> actual = ImmutableList.copyOf(requestIds);
    verifyRequestIds(
        ImmutableList.of(
            XGoogSpannerRequestId.of(getClientId(), -1, 1, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, 2, 1)),
        actual);
    verifySameChannelId(actual);
  }

  @Test
  public void testPartitionedDmlError() {
    Statement invalidDml = Statement.of("update invalid_table set col=true where col=false");
    mockSpanner.putStatementResult(
        StatementResult.exception(
            invalidDml, Status.NOT_FOUND.withDescription("Table not found").asRuntimeException()));

    SpannerException exception =
        assertThrows(
            SpannerException.class, () -> getClient().executePartitionedUpdate(invalidDml));
    assertEquals(ErrorCode.NOT_FOUND, exception.getErrorCode());
    assertNotNull(exception.getRequestId());
    assertNotEquals("", exception.getRequestId());

    assertEquals(
        ImmutableList.of(BeginTransactionRequest.class, ExecuteSqlRequest.class),
        mockSpanner.getRequestTypes());
    List<XGoogSpannerRequestId> actual = ImmutableList.copyOf(requestIds);
    verifyRequestIds(
        ImmutableList.of(
            XGoogSpannerRequestId.of(getClientId(), -1, 1, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, 2, 1)),
        actual);
    verifySameChannelId(actual);
    assertEquals(XGoogSpannerRequestId.of(exception.getRequestId()), actual.get(1));
  }

  @Test
  public void testPartitionedDmlAborted() {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofException(
            Status.ABORTED.asRuntimeException(createMinimalRetryInfo())));

    getClient().executePartitionedUpdate(DML);

    assertEquals(
        ImmutableList.of(
            BeginTransactionRequest.class,
            ExecuteSqlRequest.class,
            BeginTransactionRequest.class,
            ExecuteSqlRequest.class),
        mockSpanner.getRequestTypes());
    List<XGoogSpannerRequestId> actual = ImmutableList.copyOf(requestIds);
    verifyRequestIds(
        ImmutableList.of(
            XGoogSpannerRequestId.of(getClientId(), -1, 1, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, 2, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, 3, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, 4, 1)),
        actual);
    verifySameChannelId(actual);
  }

  @Test
  public void testPartitionedDmlUnavailable() {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofException(
            Status.UNAVAILABLE.asRuntimeException(createMinimalRetryInfo())));

    getClient().executePartitionedUpdate(DML);

    assertEquals(
        ImmutableList.of(
            BeginTransactionRequest.class,
            ExecuteSqlRequest.class,
            BeginTransactionRequest.class,
            ExecuteSqlRequest.class),
        mockSpanner.getRequestTypes());
    List<XGoogSpannerRequestId> actual = ImmutableList.copyOf(requestIds);
    verifyRequestIds(
        ImmutableList.of(
            XGoogSpannerRequestId.of(getClientId(), -1, 1, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, 2, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, 3, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, 4, 1)),
        actual);
    verifySameChannelId(actual);
  }

  @Test
  public void testPartitionedDmlUnavailableWithResumeToken() {
    Statement update = Statement.of("UPDATE my_table SET active=true where 1=1");
    mockSpanner.putStatementResult(
        StatementResult.query(
            update,
            com.google.spanner.v1.ResultSet.newBuilder()
                .setMetadata(
                    ResultSetMetadata.newBuilder()
                        .setRowType(StructType.newBuilder().build())
                        .build())
                .addRows(ListValue.newBuilder().build())
                .addRows(ListValue.newBuilder().build())
                .addRows(ListValue.newBuilder().build())
                .setStats(ResultSetStats.newBuilder().setRowCountLowerBound(100L).build())
                .build()));
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofStreamException(
            Status.UNAVAILABLE.asRuntimeException(createMinimalRetryInfo()), 2L));

    getClient().executePartitionedUpdate(update);

    assertEquals(
        ImmutableList.of(
            BeginTransactionRequest.class, ExecuteSqlRequest.class, ExecuteSqlRequest.class),
        mockSpanner.getRequestTypes());
    List<XGoogSpannerRequestId> actual = ImmutableList.copyOf(requestIds);
    verifyRequestIds(
        ImmutableList.of(
            XGoogSpannerRequestId.of(getClientId(), -1, 1, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, 2, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, 2, 2)),
        actual);
    verifySameChannelId(actual);
  }

  @Test
  public void testOtherClientId() {
    // Execute a query with the default client from this test class.
    try (ResultSet resultSet = getClient().singleUse().executeQuery(SELECT1)) {
      while (resultSet.next()) {}
    }
    // Create a new client and use that to execute a query. This should use a different client ID.
    long otherClientId;
    try (Spanner spanner = createSpanner()) {
      otherClientId = ((SpannerImpl) spanner).getRequestIdClientId();
      DatabaseClient client = spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
      try (ResultSet resultSet = client.singleUse().executeQuery(SELECT1)) {
        while (resultSet.next()) {}
      }
    }
    // Execute another query with the default client. This should use the original client ID.
    try (ResultSet resultSet = getClient().singleUse().executeQuery(SELECT1)) {
      while (resultSet.next()) {}
    }
    assertEquals(
        ImmutableList.of(
            ExecuteSqlRequest.class,
            CreateSessionRequest.class,
            ExecuteSqlRequest.class,
            ExecuteSqlRequest.class),
        mockSpanner.getRequestTypes());
    List<XGoogSpannerRequestId> actual = ImmutableList.copyOf(requestIds);
    verifyRequestIds(
        ImmutableList.of(
            XGoogSpannerRequestId.of(getClientId(), -1, 1, 1),
            // The CreateSession RPC from the initialization of the second client is included in
            // the requests that we see. This request does not include a channel hint, hence the
            // zero value for the channel number in the request ID.
            XGoogSpannerRequestId.of(otherClientId, 0, 1, 1),
            XGoogSpannerRequestId.of(otherClientId, -1, 2, 1),
            XGoogSpannerRequestId.of(getClientId(), -1, 2, 1)),
        actual);
  }

  private void verifyRequestIds(
      List<XGoogSpannerRequestId> expectedIds, List<XGoogSpannerRequestId> actualIds) {
    assertEquals(message(expectedIds, actualIds), expectedIds.size(), actualIds.size());
    int i = 0;
    for (XGoogSpannerRequestId actual : actualIds) {
      XGoogSpannerRequestId expected = expectedIds.get(i);
      if (expected.getNthChannelId() > -1) {
        assertEquals(expected, actual);
      } else {
        assertTrue(message(expectedIds, actualIds), equalsIgnoringChannelId(expected, actual));
        assertTrue(message(expectedIds, actualIds), actual.hasChannelId());
      }
      i++;
    }
  }

  private void verifySameChannelId(List<XGoogSpannerRequestId> requestIds) {
    for (int i = 0; i < requestIds.size() - 1; i++) {
      XGoogSpannerRequestId requestId = requestIds.get(i);
      assertTrue(requestId.hasChannelId());
      assertEquals(requestId.getNthChannelId(), requestIds.get(i + 1).getNthChannelId());
    }
  }

  private boolean equalsIgnoringChannelId(
      XGoogSpannerRequestId expected, XGoogSpannerRequestId actual) {
    return expected.getNthClientId() == actual.getNthClientId()
        && expected.getNthRequest() == actual.getNthRequest()
        && expected.getAttempt() == actual.getAttempt();
  }

  private String message(List<XGoogSpannerRequestId> expected, List<XGoogSpannerRequestId> actual) {
    return String.format("\n Got: %s\nWant: %s", actual, expected);
  }
}
