/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.admin.database.v1.MockDatabaseAdminImpl;
import com.google.cloud.spanner.admin.instance.v1.MockInstanceAdminImpl;
import com.google.cloud.spanner.jdbc.ITAbstractSpannerTest.AbortInterceptor;
import com.google.cloud.spanner.jdbc.ITAbstractSpannerTest.ITConnection;
import com.google.cloud.spanner.jdbc.it.ITTransactionRetryTest.CountTransactionRetryListener;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AbortedTest {
  private static final Statement SELECT_COUNT =
      Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1");
  private static final ResultSetMetadata SELECT_COUNT_METADATA =
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
  private static final com.google.spanner.v1.ResultSet SELECT_COUNT_RESULTSET_BEFORE_INSERT =
      com.google.spanner.v1.ResultSet.newBuilder()
          .addRows(
              ListValue.newBuilder()
                  .addValues(Value.newBuilder().setStringValue("0").build())
                  .build())
          .setMetadata(SELECT_COUNT_METADATA)
          .build();
  private static final com.google.spanner.v1.ResultSet SELECT_COUNT_RESULTSET_AFTER_INSERT =
      com.google.spanner.v1.ResultSet.newBuilder()
          .addRows(
              ListValue.newBuilder()
                  .addValues(Value.newBuilder().setStringValue("1").build())
                  .build())
          .setMetadata(SELECT_COUNT_METADATA)
          .build();
  private static final Statement INSERT_STATEMENT =
      Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test aborted')");
  private static final int UPDATE_COUNT = 1;

  private static MockSpannerServiceImpl mockSpanner;
  private static MockInstanceAdminImpl mockInstanceAdmin;
  private static MockDatabaseAdminImpl mockDatabaseAdmin;
  private static Server server;
  private static InetSocketAddress address;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    mockInstanceAdmin = new MockInstanceAdminImpl();
    mockDatabaseAdmin = new MockDatabaseAdminImpl();
    address = new InetSocketAddress("localhost", 0);
    server =
        NettyServerBuilder.forAddress(address)
            .addService(mockSpanner)
            .addService(mockInstanceAdmin)
            .addService(mockDatabaseAdmin)
            .build()
            .start();
  }

  @AfterClass
  public static void stopServer() throws Exception {
    SpannerPool.closeSpannerPool();
    server.shutdown();
    server.awaitTermination();
  }

  public ITConnection createConnection(
      AbortInterceptor interceptor, TransactionRetryListener transactionRetryListener) {
    return createConnection(
        Arrays.<StatementExecutionInterceptor>asList(interceptor),
        Arrays.<TransactionRetryListener>asList(transactionRetryListener));
  }

  public ITConnection createConnection(
      List<StatementExecutionInterceptor> interceptors,
      List<TransactionRetryListener> transactionRetryListeners) {
    StringBuilder url =
        new StringBuilder(
            String.format(
                "cloudspanner://localhost:%d/projects/proj/instances/inst/databases/db?usePlainText=true;autocommit=false;retryAbortsInternally=true",
                server.getPort()));
    ConnectionOptions.Builder builder =
        ConnectionOptions.newBuilder()
            .setUri(url.toString())
            .setStatementExecutionInterceptors(interceptors);
    ConnectionOptions options = builder.build();
    ITConnection connection = createITConnection(options);
    for (TransactionRetryListener listener : transactionRetryListeners) {
      connection.addTransactionRetryListener(listener);
    }
    return connection;
  }

  private ITConnection createITConnection(ConnectionOptions options) {
    return new ITConnectionImpl(options);
  }

  @Test
  public void testCommitAborted() {
    // Do two iterations to ensure that each iteration gets its own transaction, and that each
    // transaction is the most recent transaction of that session.
    for (int i = 0; i < 2; i++) {
      mockSpanner.putStatementResult(
          StatementResult.query(SELECT_COUNT, SELECT_COUNT_RESULTSET_BEFORE_INSERT));
      mockSpanner.putStatementResult(StatementResult.update(INSERT_STATEMENT, UPDATE_COUNT));
      AbortInterceptor interceptor = new AbortInterceptor(0);
      try (ITConnection connection =
          createConnection(interceptor, new CountTransactionRetryListener())) {
        // verify that the there is no test record
        try (ResultSet rs =
            connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
          assertThat(rs.next(), is(true));
          assertThat(rs.getLong("C"), is(equalTo(0L)));
          assertThat(rs.next(), is(false));
        }
        // do an insert
        connection.executeUpdate(
            Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test aborted')"));
        // indicate that the next statement should abort
        interceptor.setProbability(1.0);
        interceptor.setOnlyInjectOnce(true);
        // do a commit that will first abort, and then on retry will succeed
        connection.commit();
        mockSpanner.putStatementResult(
            StatementResult.query(SELECT_COUNT, SELECT_COUNT_RESULTSET_AFTER_INSERT));
        // verify that the insert succeeded
        try (ResultSet rs =
            connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
          assertThat(rs.next(), is(true));
          assertThat(rs.getLong("C"), is(equalTo(1L)));
          assertThat(rs.next(), is(false));
        }
      }
    }
  }
}
