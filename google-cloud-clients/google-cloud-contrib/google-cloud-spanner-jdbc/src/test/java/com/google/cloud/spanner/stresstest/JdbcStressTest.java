/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.stresstest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.admin.database.v1.MockDatabaseAdminImpl;
import com.google.cloud.spanner.admin.instance.v1.MockInstanceAdminImpl;
import com.google.cloud.spanner.jdbc.SpannerPool;
import com.google.common.base.Function;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.protobuf.Empty;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;

/**
 * Stress test for the Cloud Spanner jdbc driver. This test uses the {@link MockSpannerServiceImpl}
 * as a server. This is a mock implementation of a Cloud Spanner server that is started in-process.
 */
@Category(StressTest.class)
@RunWith(Parameterized.class)
public class JdbcStressTest {
  private static final String PROJECT_ID = "test-project";
  private static final String INSTANCE_ID = "test-instance";
  private static final String DATABASE_ID = "test-database";
  private static final long MAX_WAIT_FOR_TEST_RUN = 1200000L;
  private static final int NUMBER_OF_SELECT1_TEST_EXECUTIONS = 6400;
  private static final int NUMBER_OF_RANDOM_TEST_EXECUTIONS = 128;
  private static final int NUMBER_OF_UPDATE_TEST_EXECUTIONS = 6400;
  private static final int NUMBER_OF_UPDATES_IN_TX = 100;
  private static final int ROW_COUNT_RANDOM_RESULT_SET = 1000;

  private static final ThreadFactory THREAD_FACTORY = new ThreadFactoryBuilder().setNameFormat("test-executor-%d").build();
  private static final Statement SELECT1 = Statement.of("SELECT 1 AS COL1");
  private static final ResultSetMetadata SELECT1_METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(StructType.newBuilder()
              .addFields(Field.newBuilder().setName("COL1")
                  .setType(Type.newBuilder().setCode(TypeCode.INT64).build()).build())
              .build())
          .build();
  private static final com.google.spanner.v1.ResultSet SELECT1_RESULTSET =
      com.google.spanner.v1.ResultSet
          .newBuilder().addRows(ListValue.newBuilder()
              .addValues(Value.newBuilder().setStringValue("1").build()).build())
          .setMetadata(SELECT1_METADATA).build();
  private static final Statement SELECT_RANDOM = Statement.of("SELECT * FROM RANDOM");
  private static final com.google.spanner.v1.ResultSet RANDOM_RESULT_SET =
      new RandomResultSetGenerator(ROW_COUNT_RANDOM_RESULT_SET).generate();
  private static final String SELECT_RANDOM_WITH_PARAMS_SQL = "SELECT * FROM RANDOM WHERE FOO=? AND BAR=?";
  private static final Statement SELECT_RANDOM_WITH_PARAMS =
      Statement.newBuilder("SELECT * FROM RANDOM WHERE FOO=@p1 AND BAR=@p2").bind("p1")
          .to(1L).bind("p2").to("TEST").build();
  private static final com.google.spanner.v1.ResultSet RANDOM_WITH_PARAMS_RESULT_SET =
      new RandomResultSetGenerator(ROW_COUNT_RANDOM_RESULT_SET).generate();

  private static final Statement UPDATE_STATEMENT =
      Statement.of("UPDATE FOO SET BAR=1 WHERE BAZ=2");
  private static final long UPDATE_COUNT = 1L;

  private static MockSpannerServiceImpl mockSpanner;
  private static MockInstanceAdminImpl mockInstanceAdmin;
  private static MockDatabaseAdminImpl mockDatabaseAdmin;
  private static Server server;
  private static InetSocketAddress address;

  private static final List<TestResult> RESULTS = new ArrayList<>();
  @Rule public TestName name = new TestName();
  private long lastExecutionTime;
  private long lastExecutionCount;
  @Parameter(0) public String numChannels;
  @Parameter(1) public String parallelThreads;

  @Parameters(name = "channels = {0}, parallel = {1}")
  public static Collection<Object[]> data() {
    List<Object[]> params = new ArrayList<>();
    for(int channels = 4; channels <= 256; channels *= 2) {
      for(int parallel = 1; parallel <= 64; parallel *= 2) {
        params.add(new Object[] {String.format("%03d", channels), String.format("%02d", parallel)});
      }
    }
    return params;
  }

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    mockSpanner.putStatementResult(StatementResult.query(SELECT1, SELECT1_RESULTSET));
    mockSpanner.putStatementResult(StatementResult.query(SELECT_RANDOM, RANDOM_RESULT_SET));
    mockSpanner.putStatementResult(
        StatementResult.query(SELECT_RANDOM_WITH_PARAMS, RANDOM_WITH_PARAMS_RESULT_SET));
    mockSpanner.putStatementResult(StatementResult.update(UPDATE_STATEMENT, UPDATE_COUNT));
    mockInstanceAdmin = new MockInstanceAdminImpl();
    mockDatabaseAdmin = new MockDatabaseAdminImpl();
    address = new InetSocketAddress("localhost", 0);
    server = NettyServerBuilder.forAddress(address).addService(mockSpanner)
        .addService(mockInstanceAdmin).addService(mockDatabaseAdmin).build().start();
  }

  @AfterClass
  public static void stopServer() throws Exception {
    SpannerPool.closeSpannerPool();
    // Wait a little to allow all delete session requests to finish.
    Thread.sleep(2000L);
    server.shutdown();
  }

  @After
  public void log() throws Exception {
    int parallelThreads = Integer.valueOf(this.parallelThreads);
    int numChannels = Integer.valueOf(this.numChannels);
    RESULTS.add(new TestResult(parallelThreads, numChannels, name.getMethodName(), lastExecutionTime, lastExecutionCount));
    Collections.sort(RESULTS);
    TestResult.logResults(RESULTS);
  }

  private String createBaseUrl(int numChannels) {
    String endpoint = address.getHostString() + ":" + server.getPort();
    StringBuilder url = new StringBuilder("jdbc:cloudspanner://");
    url.append(endpoint);
    url.append("/projects/").append(PROJECT_ID);
    url.append("/instances/").append(INSTANCE_ID);
    url.append("/databases/").append(DATABASE_ID);
    url.append("?usePlainText=true");
    url.append(";numChannels=").append(numChannels);

    return url.toString();
  }

  @Test
  public void select1AutocommitTest()
      throws SQLException, InterruptedException, ExecutionException, TimeoutException {
    int parallelThreads = Integer.valueOf(this.parallelThreads);
    int executionsPerConnection = NUMBER_OF_SELECT1_TEST_EXECUTIONS / parallelThreads;
    Function<Connection, Void> function = new Function<Connection, Void>() {
      @Override
      public Void apply(Connection connection) {
        verifySelect1ResultSet(connection);
        return null;
      }
    };
    runJdbcStressTest(function, executionsPerConnection);
  }

  @Test
  public void selectRandomAutocommitTest()
      throws SQLException, InterruptedException, ExecutionException, TimeoutException {
    int parallelThreads = Integer.valueOf(this.parallelThreads);
    int executionsPerConnection = NUMBER_OF_RANDOM_TEST_EXECUTIONS / parallelThreads;
    Function<Connection, Void> function = new Function<Connection, Void>() {
      @Override
      public Void apply(Connection connection) {
        verifyRandomResultSet(connection);
        return null;
      }
    };
    runJdbcStressTest(function, executionsPerConnection);
  }

  @Test
  public void select1ReadOnlyTxTest()
      throws SQLException, InterruptedException, ExecutionException, TimeoutException {
    int parallelThreads = Integer.valueOf(this.parallelThreads);
    int executionsPerConnection = NUMBER_OF_SELECT1_TEST_EXECUTIONS / parallelThreads;
    Function<Connection, Void> function = new Function<Connection, Void>() {
      @Override
      public Void apply(Connection connection) {
        try {
          connection.setReadOnly(true);
          connection.setAutoCommit(false);
          verifySelect1ResultSet(connection);
          connection.commit();
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
        return null;
      }
    };
    runJdbcStressTest(function, executionsPerConnection);
  }

  @Test
  public void selectRandomReadOnlyTxTest()
      throws SQLException, InterruptedException, ExecutionException, TimeoutException {
    int parallelThreads = Integer.valueOf(this.parallelThreads);
    int executionsPerConnection = NUMBER_OF_RANDOM_TEST_EXECUTIONS / parallelThreads;
    Function<Connection, Void> function = new Function<Connection, Void>() {
      @Override
      public Void apply(Connection connection) {
        try {
          connection.setReadOnly(true);
          connection.setAutoCommit(false);
          verifyRandomResultSet(connection);
          connection.commit();
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
        return null;
      }
    };
    runJdbcStressTest(function, executionsPerConnection);
  }

  @Test
  public void select1ReadWriteTxTest()
      throws SQLException, InterruptedException, ExecutionException, TimeoutException {
    int parallelThreads = Integer.valueOf(this.parallelThreads);
    int executionsPerConnection = NUMBER_OF_SELECT1_TEST_EXECUTIONS / parallelThreads;
    Function<Connection, Void> function = new Function<Connection, Void>() {
      @Override
      public Void apply(Connection connection) {
        try {
          connection.setAutoCommit(false);
          verifySelect1ResultSet(connection);
          connection.commit();
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
        return null;
      }
    };
    runJdbcStressTest(function, executionsPerConnection);
  }

  @Test
  public void selectRandomReadWriteTxTest()
      throws SQLException, InterruptedException, ExecutionException, TimeoutException {
    int parallelThreads = Integer.valueOf(this.parallelThreads);
    int executionsPerConnection = NUMBER_OF_RANDOM_TEST_EXECUTIONS / parallelThreads;
    Function<Connection, Void> function = new Function<Connection, Void>() {
      @Override
      public Void apply(Connection connection) {
        try {
          connection.setAutoCommit(false);
          verifyRandomResultSet(connection);
          connection.commit();
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
        return null;
      }
    };
    runJdbcStressTest(function, executionsPerConnection);
  }

  @Test
  public void selectRandomWithParamsReadWriteTxTest()
      throws SQLException, InterruptedException, ExecutionException, TimeoutException {
    int parallelThreads = Integer.valueOf(this.parallelThreads);
    int executionsPerConnection = NUMBER_OF_RANDOM_TEST_EXECUTIONS / parallelThreads;
    Function<Connection, Void> function = new Function<Connection, Void>() {
      @Override
      public Void apply(Connection connection) {
        try {
          connection.setAutoCommit(false);
          verifyRandomWithParamsResultSet(connection);
          connection.commit();
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
        return null;
      }
    };
    runJdbcStressTest(function, executionsPerConnection);
  }

  @Test
  public void updateAutocommitCreateStatementExecuteUpdate() throws SQLException, InterruptedException, ExecutionException, TimeoutException {
    int parallelThreads = Integer.valueOf(this.parallelThreads);
    int executionsPerConnection = NUMBER_OF_UPDATE_TEST_EXECUTIONS / parallelThreads;
    Function<Connection, Void> function = new Function<Connection, Void>() {
      @Override
      public Void apply(Connection connection) {
        verifyUpdateCreateStatementExecuteUpdate(connection);
        return null;
      }
    };
    runJdbcStressTest(function, executionsPerConnection);
  }

  @Test
  public void updateAutocommitCreateStatementExecute() throws SQLException, InterruptedException, ExecutionException, TimeoutException {
    int parallelThreads = Integer.valueOf(this.parallelThreads);
    int executionsPerConnection = NUMBER_OF_UPDATE_TEST_EXECUTIONS / parallelThreads;
    Function<Connection, Void> function = new Function<Connection, Void>() {
      @Override
      public Void apply(Connection connection) {
        verifyUpdateCreateStatementExecute(connection);
        return null;
      }
    };
    runJdbcStressTest(function, executionsPerConnection);
  }

  @Test
  public void updateAutocommitPrepareStatementExecuteUpdate() throws SQLException, InterruptedException, ExecutionException, TimeoutException {
    int parallelThreads = Integer.valueOf(this.parallelThreads);
    int executionsPerConnection = NUMBER_OF_UPDATE_TEST_EXECUTIONS / parallelThreads;
    Function<Connection, Void> function = new Function<Connection, Void>() {
      @Override
      public Void apply(Connection connection) {
        verifyUpdatePrepareStatementExecuteUpdate(connection);
        return null;
      }
    };
    runJdbcStressTest(function, executionsPerConnection);
  }

  @Test
  public void updateReadWriteTxCreateStatementExecuteUpdate() throws SQLException, InterruptedException, ExecutionException, TimeoutException {
    int parallelThreads = Integer.valueOf(this.parallelThreads);
    int executionsPerConnection = NUMBER_OF_UPDATE_TEST_EXECUTIONS / (parallelThreads * NUMBER_OF_UPDATES_IN_TX);
    Function<Connection, Void> function = new Function<Connection, Void>() {
      @Override
      public Void apply(Connection connection) {
        try {
          connection.setAutoCommit(false);
          for(int i = 0; i<NUMBER_OF_UPDATES_IN_TX; i++) {
            verifyUpdateCreateStatementExecuteUpdate(connection);
          }
          connection.commit();
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
        return null;
      }
    };
    runJdbcStressTest(function, executionsPerConnection, NUMBER_OF_UPDATES_IN_TX);
  }

  @Test
  public void updateReadWriteTxPrepareStatementExecuteUpdate() throws SQLException, InterruptedException, ExecutionException, TimeoutException {
    int parallelThreads = Integer.valueOf(this.parallelThreads);
    int executionsPerConnection = NUMBER_OF_UPDATE_TEST_EXECUTIONS / (parallelThreads * NUMBER_OF_UPDATES_IN_TX);
    Function<Connection, Void> function = new Function<Connection, Void>() {
      @Override
      public Void apply(Connection connection) {
        try {
          connection.setAutoCommit(false);
          PreparedStatement ps = connection.prepareStatement(UPDATE_STATEMENT.getSql());
          for(int i = 0; i<NUMBER_OF_UPDATES_IN_TX; i++) {
            long count = ps.executeUpdate();
            assertThat(count, is(equalTo(UPDATE_COUNT)));
          }
          connection.commit();
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
        return null;
      }
    };
    runJdbcStressTest(function, executionsPerConnection, NUMBER_OF_UPDATES_IN_TX);
  }

  private static class ConnectionCallable<T> implements Callable<T> {
    private final Connection connection;
    private final Function<Connection, T> function;

    private ConnectionCallable(Connection connection, Function<Connection, T> function) {
      this.connection = connection;
      this.function = function;
    }

    @Override
    public T call() throws Exception {
      return function.apply(connection);
    }
  }

  private <T> List<T> runJdbcStressTest(Function<Connection, T> function,
      int executionsPerConnection)
      throws SQLException, InterruptedException, ExecutionException, TimeoutException {
    return runJdbcStressTest(function, executionsPerConnection, 1);
  }

  private <T> List<T> runJdbcStressTest(Function<Connection, T> function,
      int executionsPerConnection, int statementsPerExecution)
      throws SQLException, InterruptedException, ExecutionException, TimeoutException {
    Stopwatch watch = Stopwatch.createStarted();
    List<T> res = new ArrayList<>();
    int parallelThreads = Integer.valueOf(this.parallelThreads);
    int numChannels = Integer.valueOf(this.numChannels);
    List<Connection> connections = new ArrayList<>(parallelThreads);
    List<ThreadPoolExecutor> executors = new ArrayList<>();
    Map<ExecutorService, List<Future<T>>> futures = new HashMap<>();
    try {
      for (int i = 0; i < parallelThreads; i++) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(), THREAD_FACTORY);
        List<Future<T>> f = new ArrayList<>();
        final Connection connection = DriverManager.getConnection(createBaseUrl(numChannels));
        connections.add(connection);
        for (int execution = 0; execution < executionsPerConnection; execution++) {
          f.add(executor.submit(new ConnectionCallable<T>(connection, function)));
        }
        futures.put(executor, f);
        executor.shutdown();
        executors.add(executor);
      }
      for (ThreadPoolExecutor executor : executors) {
        if (executor.awaitTermination(MAX_WAIT_FOR_TEST_RUN, TimeUnit.MILLISECONDS)) {
          for (Future<T> future : futures.get(executor)) {
            res.add(future.get());
          }
          assertThat((int) executor.getCompletedTaskCount(), is(equalTo(executionsPerConnection)));
        } else {
          throw new TimeoutException("Stress test run timed out");
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
      for (Connection connection : connections) {
        connection.close();
      }
    }
    watch.stop();
    lastExecutionCount = executionsPerConnection * parallelThreads * statementsPerExecution;
    lastExecutionTime = watch.elapsed(TimeUnit.MILLISECONDS);
    return res;
  }

  private void verifyUpdateCreateStatementExecuteUpdate(Connection connection) {
    try {
      long count = connection.createStatement().executeUpdate(UPDATE_STATEMENT.getSql());
      assertThat(count, is(equalTo(UPDATE_COUNT)));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private void verifyUpdateCreateStatementExecute(Connection connection) {
    try {
      java.sql.Statement statement = connection.createStatement();
      boolean res = statement.execute(UPDATE_STATEMENT.getSql());
      assertThat(res, is(false));
      assertThat((long) statement.getUpdateCount(), is(equalTo(UPDATE_COUNT)));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private void verifyUpdatePrepareStatementExecuteUpdate(Connection connection) {
    try {
      long count = connection.prepareStatement(UPDATE_STATEMENT.getSql()).executeUpdate();
      assertThat(count, is(equalTo(UPDATE_COUNT)));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private void verifySelect1ResultSet(Connection connection) {
    try (java.sql.ResultSet rs = connection.createStatement().executeQuery(SELECT1.getSql())) {
      assertThat(rs, is(notNullValue()));
      assertThat(rs.next(), is(true));
      assertThat(rs.getLong(1), is(equalTo(1L)));
      assertThat(rs.next(), is(false));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private void verifyRandomResultSet(Connection connection) {
    try (java.sql.ResultSet rs = connection.createStatement().executeQuery(SELECT_RANDOM.getSql())) {
      int rowCount = 0;
      while (rs.next()) {
        for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++) {
          assertThat(getValue(rs, col), is(notNullValue()));
        }
        rowCount++;
      }
      assertThat(rowCount, is(equalTo(ROW_COUNT_RANDOM_RESULT_SET)));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private void verifyRandomWithParamsResultSet(Connection connection) {
    try (PreparedStatement ps = connection.prepareStatement(SELECT_RANDOM_WITH_PARAMS_SQL)) {
      ps.setLong(1, 1L);
      ps.setString(2, "TEST");
      try (java.sql.ResultSet rs = ps.executeQuery()) {
        int rowCount = 0;
        while (rs.next()) {
          for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++) {
            assertThat(getValue(rs, col), is(notNullValue()));
          }
          rowCount++;
        }
        assertThat(rowCount, is(equalTo(ROW_COUNT_RANDOM_RESULT_SET)));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private Object getValue(java.sql.ResultSet rs, int col) throws SQLException {
    rs.getObject(col);
    if (rs.wasNull()) {
      return Empty.getDefaultInstance();
    }
    ResultSetMetaData metadata = rs.getMetaData();
    switch (metadata.getColumnType(col)) {
      case Types.ARRAY:
        return rs.getArray(col);
      case Types.BOOLEAN:
        return rs.getBoolean(col);
      case Types.BINARY:
        return rs.getBytes(col);
      case Types.DATE:
        return rs.getDate(col);
      case Types.DOUBLE:
        return rs.getDouble(col);
      case Types.BIGINT:
        return rs.getLong(col);
      case Types.NVARCHAR:
        return rs.getString(col);
      case Types.TIMESTAMP:
        return rs.getTimestamp(col);
      default:
        break;
    }
    throw new IllegalArgumentException("Unknown or unsupported type");
  }
}
