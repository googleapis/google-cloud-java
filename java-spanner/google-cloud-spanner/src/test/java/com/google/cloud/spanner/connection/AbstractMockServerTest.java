/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.spanner.connection;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ForceCloseSpannerFunction;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.admin.database.v1.MockDatabaseAdminImpl;
import com.google.cloud.spanner.admin.instance.v1.MockInstanceAdminImpl;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest.AbortInterceptor;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest.ITConnection;
import com.google.cloud.spanner.connection.SpannerPool.CheckAndCloseSpannersMode;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.longrunning.GetOperationRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsGrpc.OperationsImplBase;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.internal.LogExceptionRunnable;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public abstract class AbstractMockServerTest {
  public static final long COUNT_BEFORE_INSERT = 0L;
  public static final long COUNT_AFTER_INSERT = 1L;
  public static final Statement SELECT_COUNT_STATEMENT =
      Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1");

  protected static final Statement SELECT1_STATEMENT = Statement.of("SELECT 1");

  private static final ResultSetMetadata SINGLE_COL_INT64_RESULTSET_METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      Field.newBuilder()
                          .setName("C")
                          .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                          .build())
                  .build())
          .build();
  public static final com.google.spanner.v1.ResultSet SELECT_COUNT_RESULTSET_BEFORE_INSERT =
      com.google.spanner.v1.ResultSet.newBuilder()
          .addRows(
              ListValue.newBuilder()
                  .addValues(
                      Value.newBuilder()
                          .setStringValue(String.valueOf(COUNT_BEFORE_INSERT))
                          .build())
                  .build())
          .setMetadata(SINGLE_COL_INT64_RESULTSET_METADATA)
          .build();
  public static final com.google.spanner.v1.ResultSet SELECT_COUNT_RESULTSET_AFTER_INSERT =
      com.google.spanner.v1.ResultSet.newBuilder()
          .addRows(
              ListValue.newBuilder()
                  .addValues(
                      Value.newBuilder().setStringValue(String.valueOf(COUNT_AFTER_INSERT)).build())
                  .build())
          .setMetadata(SINGLE_COL_INT64_RESULTSET_METADATA)
          .build();
  public static final com.google.spanner.v1.ResultSet UPDATE_RETURNING_RESULTSET =
      ResultSet.newBuilder()
          .setStats(ResultSetStats.newBuilder().setRowCountExact(1))
          .setMetadata(
              ResultSetMetadata.newBuilder()
                  .setRowType(
                      StructType.newBuilder()
                          .addFields(
                              Field.newBuilder()
                                  .setName("col")
                                  .setType(Type.newBuilder().setCodeValue(TypeCode.INT64_VALUE))
                                  .build())))
          .addRows(
              ListValue.newBuilder()
                  .addValues(Value.newBuilder().setStringValue("1").build())
                  .build())
          .build();

  protected static final ResultSet SELECT1_RESULTSET =
      ResultSet.newBuilder()
          .setMetadata(SINGLE_COL_INT64_RESULTSET_METADATA)
          .addRows(
              ListValue.newBuilder()
                  .addValues(Value.newBuilder().setStringValue("1").build())
                  .build())
          .build();

  public static final Statement INSERT_STATEMENT =
      Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test aborted')");
  public static final Statement INSERT_RETURNING_STATEMENT =
      Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test aborted') THEN RETURN *");
  public static final Statement PG_INSERT_RETURNING_STATEMENT =
      Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test aborted') RETURNING *");
  public static final long UPDATE_COUNT = 1L;

  public static final int RANDOM_RESULT_SET_ROW_COUNT = 100;
  public static final Statement SELECT_RANDOM_STATEMENT = Statement.of("SELECT * FROM RANDOM");
  public static final com.google.spanner.v1.ResultSet RANDOM_RESULT_SET =
      new RandomResultSetGenerator(RANDOM_RESULT_SET_ROW_COUNT).generate();

  public static MockSpannerServiceImpl mockSpanner;
  public static MockInstanceAdminImpl mockInstanceAdmin;
  public static MockDatabaseAdminImpl mockDatabaseAdmin;
  public static OperationsImplBase mockOperations;
  private static Server server;
  private static InetSocketAddress address;

  private static boolean futureParentHandlers;
  private static boolean exceptionRunnableParentHandlers;
  private static boolean nettyServerParentHandlers;
  private static boolean clientStreamParentHandlers;

  @BeforeClass
  public static void startStaticServer() throws Exception {
    startStaticServer(createServerInterceptor());
  }

  public static void startStaticServer(ServerInterceptor interceptor) throws IOException {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    mockInstanceAdmin = new MockInstanceAdminImpl();
    mockDatabaseAdmin = new MockDatabaseAdminImpl();
    mockOperations =
        new OperationsImplBase() {
          @Override
          public void getOperation(
              GetOperationRequest request, StreamObserver<Operation> responseObserver) {
            responseObserver.onNext(
                Operation.newBuilder()
                    .setDone(false)
                    .setName(request.getName())
                    .setMetadata(Any.pack(Empty.getDefaultInstance()))
                    .build());
            responseObserver.onCompleted();
          }
        };
    address = new InetSocketAddress("localhost", 0);
    server =
        NettyServerBuilder.forAddress(address)
            .addService(mockSpanner)
            .addService(mockInstanceAdmin)
            .addService(mockDatabaseAdmin)
            .addService(mockOperations)
            .intercept(interceptor)
            .build()
            .start();
    mockSpanner.putStatementResult(
        StatementResult.query(SELECT_COUNT_STATEMENT, SELECT_COUNT_RESULTSET_BEFORE_INSERT));
    mockSpanner.putStatementResult(StatementResult.update(INSERT_STATEMENT, UPDATE_COUNT));
    mockSpanner.putStatementResult(
        StatementResult.updateReturning(INSERT_RETURNING_STATEMENT, UPDATE_RETURNING_RESULTSET));
    mockSpanner.putStatementResult(
        StatementResult.updateReturning(PG_INSERT_RETURNING_STATEMENT, UPDATE_RETURNING_RESULTSET));
    mockSpanner.putStatementResult(
        StatementResult.query(SELECT_RANDOM_STATEMENT, RANDOM_RESULT_SET));
    mockSpanner.putStatementResult(StatementResult.query(SELECT1_STATEMENT, SELECT1_RESULTSET));
    mockSpanner.putStatementResult(
        StatementResult.detectDialectResult(Dialect.GOOGLE_STANDARD_SQL));

    futureParentHandlers = Logger.getLogger(AbstractFuture.class.getName()).getUseParentHandlers();
    exceptionRunnableParentHandlers =
        Logger.getLogger(LogExceptionRunnable.class.getName()).getUseParentHandlers();
    nettyServerParentHandlers =
        Logger.getLogger("io.grpc.netty.shaded.io.grpc.netty.NettyServerHandler")
            .getUseParentHandlers();
    clientStreamParentHandlers =
        Logger.getLogger("io.grpc.netty.shaded.io.grpc.netty.NettyServerHandler")
            .getUseParentHandlers();
    Logger.getLogger(AbstractFuture.class.getName()).setUseParentHandlers(false);
    Logger.getLogger(LogExceptionRunnable.class.getName()).setUseParentHandlers(false);
    Logger.getLogger("io.grpc.netty.shaded.io.grpc.netty.NettyServerHandler")
        .setUseParentHandlers(false);
    Logger.getLogger("io.grpc.internal.AbstractClientStream").setUseParentHandlers(false);
  }

  static ServerInterceptor createServerInterceptor() {
    return new ServerInterceptor() {
      @Override
      public <ReqT, RespT> Listener<ReqT> interceptCall(
          ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        return next.startCall(call, headers);
      }
    };
  }

  @AfterClass
  public static void stopServer() {
    try {
      SpannerPool.INSTANCE.checkAndCloseSpanners(
          CheckAndCloseSpannersMode.ERROR,
          new ForceCloseSpannerFunction(500L, TimeUnit.MILLISECONDS));
    } finally {
      Logger.getLogger(AbstractFuture.class.getName()).setUseParentHandlers(futureParentHandlers);
      Logger.getLogger(LogExceptionRunnable.class.getName())
          .setUseParentHandlers(exceptionRunnableParentHandlers);
      Logger.getLogger("io.grpc.netty.shaded.io.grpc.netty.NettyServerHandler")
          .setUseParentHandlers(nettyServerParentHandlers);
      Logger.getLogger("io.grpc.internal.AbstractClientStream")
          .setUseParentHandlers(clientStreamParentHandlers);
    }
    server.shutdown();
  }

  @Before
  public void setupResults() {
    mockSpanner.clearRequests();
    mockSpanner.removeAllExecutionTimes();
    mockDatabaseAdmin.getRequests().clear();
    mockInstanceAdmin.getRequests().clear();
  }

  protected java.sql.Connection createJdbcConnection() throws SQLException {
    return DriverManager.getConnection("jdbc:" + getBaseUrl());
  }

  protected ITConnection createConnection() {
    return createConnection(Collections.emptyList(), Collections.emptyList());
  }

  ITConnection createConnection(String additionalUrlOptions) {
    return createConnection(Collections.emptyList(), Collections.emptyList(), additionalUrlOptions);
  }

  ITConnection createConnection(
      AbortInterceptor interceptor, TransactionRetryListener transactionRetryListener) {
    return createConnection(
        Collections.singletonList(interceptor),
        Collections.singletonList(transactionRetryListener));
  }

  ITConnection createConnection(
      List<StatementExecutionInterceptor> interceptors,
      List<TransactionRetryListener> transactionRetryListeners) {
    return createConnection(interceptors, transactionRetryListeners, "");
  }

  ITConnection createConnection(
      List<StatementExecutionInterceptor> interceptors,
      List<TransactionRetryListener> transactionRetryListeners,
      String additionalUrlOptions) {
    ConnectionOptions.Builder builder =
        ConnectionOptions.newBuilder()
            .setUri(getBaseUrl() + additionalUrlOptions)
            .setStatementExecutionInterceptors(interceptors);
    configureConnectionOptions(builder);
    ConnectionOptions options = builder.build();
    ITConnection connection = createITConnection(options);
    for (TransactionRetryListener listener : transactionRetryListeners) {
      connection.addTransactionRetryListener(listener);
    }
    return connection;
  }

  protected ConnectionOptions.Builder configureConnectionOptions(
      ConnectionOptions.Builder builder) {
    return builder;
  }

  protected String getBaseUrl() {
    return String.format(
        "cloudspanner://localhost:%d/projects/proj/instances/inst/databases/db?usePlainText=true;autocommit=false;retryAbortsInternally=true",
        server.getPort());
  }

  protected static int getPort() {
    return server.getPort();
  }

  protected ExecuteSqlRequest getLastExecuteSqlRequest() {
    List<AbstractMessage> requests = mockSpanner.getRequests();
    for (int i = requests.size() - 1; i >= 0; i--) {
      if (requests.get(i) instanceof ExecuteSqlRequest) {
        return (ExecuteSqlRequest) requests.get(i);
      }
    }
    throw new IllegalStateException("No ExecuteSqlRequest found in requests");
  }

  ITConnection createITConnection(ConnectionOptions options) {
    return new ITConnectionImpl(options);
  }

  boolean isMultiplexedSessionsEnabled(Spanner spanner) {
    if (spanner.getOptions() == null || spanner.getOptions().getSessionPoolOptions() == null) {
      return false;
    }
    return spanner.getOptions().getSessionPoolOptions().getUseMultiplexedSession();
  }

  boolean isMultiplexedSessionsEnabledForPartitionedOps(Spanner spanner) {
    if (spanner.getOptions() == null || spanner.getOptions().getSessionPoolOptions() == null) {
      return false;
    }
    return spanner.getOptions().getSessionPoolOptions().getUseMultiplexedSessionPartitionedOps();
  }

  boolean isMultiplexedSessionsEnabledForRW(Spanner spanner) {
    if (spanner.getOptions() == null || spanner.getOptions().getSessionPoolOptions() == null) {
      return false;
    }
    return spanner.getOptions().getSessionPoolOptions().getUseMultiplexedSessionForRW();
  }
}
