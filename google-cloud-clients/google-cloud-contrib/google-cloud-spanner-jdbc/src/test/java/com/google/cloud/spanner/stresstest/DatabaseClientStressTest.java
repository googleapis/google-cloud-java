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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import com.google.api.core.ApiFunction;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.ReadContext;
import com.google.cloud.spanner.ReadOnlyTransaction;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TransactionContext;
import com.google.cloud.spanner.TransactionRunner;
import com.google.cloud.spanner.TransactionRunner.TransactionCallable;
import com.google.cloud.spanner.admin.database.v1.MockDatabaseAdminImpl;
import com.google.cloud.spanner.admin.instance.v1.MockInstanceAdminImpl;
import com.google.cloud.spanner.jdbc.SpannerPool;
import com.google.common.base.Function;
import com.google.common.base.Stopwatch;
import com.google.protobuf.Empty;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;

/**
 * Stress test for {@link DatabaseClient}. This test uses the {@link MockSpannerServiceImpl} as a
 * server. This test can be used to compare performance between different releases of the client library, and between the standard client library and the JDBC driver.
 */
@Category(StressTest.class)
@RunWith(Parameterized.class)
public class DatabaseClientStressTest {
  private static final String PROJECT_ID = "test-project";
  private static final String INSTANCE_ID = "test-instance";
  private static final String DATABASE_ID = "test-database";
  private static final long MAX_WAIT_FOR_TEST_RUN = 120000;
  private static final int NUMBER_OF_SELECT1_TEST_EXECUTIONS = 6400;
  private static final int NUMBER_OF_RANDOM_TEST_EXECUTIONS = 128;
  private static final int NUMBER_OF_UPDATE_TEST_EXECUTIONS = 6400;
  private static final int NUMBER_OF_UPDATES_IN_TX = 100;
  private static final int ROW_COUNT_RANDOM_RESULT_SET = 1000;

  private static final Statement SELECT1 = Statement.of("SELECT 1 AS COL1");
  private static final ResultSetMetadata SELECT1_METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      Field.newBuilder()
                          .setName("COL1")
                          .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                          .build())
                  .build())
          .build();
  private static final com.google.spanner.v1.ResultSet SELECT1_RESULTSET =
      com.google.spanner.v1.ResultSet.newBuilder()
          .addRows(
              ListValue.newBuilder()
                  .addValues(Value.newBuilder().setStringValue("1").build())
                  .build())
          .setMetadata(SELECT1_METADATA)
          .build();
  private static final Statement SELECT_RANDOM = Statement.of("SELECT * FROM RANDOM");
  private static final com.google.spanner.v1.ResultSet RANDOM_RESULT_SET =
      new RandomResultSetGenerator(ROW_COUNT_RANDOM_RESULT_SET).generate();
  private static final Statement SELECT_RANDOM_WITH_PARAMS =
      Statement.newBuilder("SELECT * FROM RANDOM WHERE FOO=@param1 AND BAR=@param2")
          .bind("param1")
          .to(1L)
          .bind("param2")
          .to("TEST")
          .build();
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
  private static Spanner spanner;

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

  @SuppressWarnings("rawtypes")
  @Before
  public void createSpanner() {
    int numChannels = Integer.valueOf(this.numChannels);
    if(spanner == null || spanner.getOptions().getNumChannels() != numChannels) {
      if(spanner != null) {
        spanner.close();
        spanner = spanner.getOptions().toBuilder().setNumChannels(numChannels).build().getService();
      } else {
        spanner = SpannerOptions.newBuilder()
            .setHost("http://" + address.getHostString() + ":" + server.getPort())
            .setChannelConfigurator(new ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder>() {
              @Override
              public ManagedChannelBuilder apply(ManagedChannelBuilder input) {
                return input.usePlaintext();
              }
            })
            .setNumChannels(numChannels)
            .setCredentials(NoCredentials.getInstance())
            .setProjectId(PROJECT_ID)
            .build().getService();
      }
    }
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

  @Test
  public void singleUseSelect1Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    singleUseTest(
        new Function<ReadContext, Void>() {
          @Override
          public Void apply(ReadContext input) {
            verifySelect1ResultSet(input);
            return null;
          }
        },
        NUMBER_OF_SELECT1_TEST_EXECUTIONS);
  }

  @Test
  public void singleUseRandomTest()
      throws InterruptedException, ExecutionException, TimeoutException {
    singleUseTest(
        new Function<ReadContext, Void>() {
          @Override
          public Void apply(ReadContext input) {
            verifyRandomResultSet(input);
            return null;
          }
        },
        NUMBER_OF_RANDOM_TEST_EXECUTIONS);
  }

  private <T> void singleUseTest(final Function<ReadContext, T> verifyFunction, int testRuns)
      throws InterruptedException, ExecutionException, TimeoutException {
    final DatabaseClient dbClient =
        spanner.getDatabaseClient(DatabaseId.of(PROJECT_ID, INSTANCE_ID, DATABASE_ID));
    Callable<Void> callable =
        new Callable<Void>() {
          @Override
          public Void call() throws Exception {
            try (ReadContext context = dbClient.singleUse()) {
              verifyFunction.apply(context);
            }
            return null;
          }
        };
    runStressTest(callable, testRuns);
  }

  @Test
  public void readOnlyTransactionSelect1Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    readOnlyTransactionTest(
        new Function<ReadContext, Void>() {
          @Override
          public Void apply(ReadContext input) {
            verifySelect1ResultSet(input);
            return null;
          }
        },
        NUMBER_OF_SELECT1_TEST_EXECUTIONS);
  }

  @Test
  public void readOnlyTransactionRandomTest()
      throws InterruptedException, ExecutionException, TimeoutException {
    readOnlyTransactionTest(
        new Function<ReadContext, Void>() {
          @Override
          public Void apply(ReadContext input) {
            verifyRandomResultSet(input);
            return null;
          }
        },
        NUMBER_OF_RANDOM_TEST_EXECUTIONS);
  }

  private <T> void readOnlyTransactionTest(
      final Function<ReadContext, T> verifyFunction, int testRuns)
      throws InterruptedException, ExecutionException, TimeoutException {
    final DatabaseClient dbClient =
        spanner.getDatabaseClient(DatabaseId.of(PROJECT_ID, INSTANCE_ID, DATABASE_ID));
    Callable<Void> callable =
        new Callable<Void>() {
          @Override
          public Void call() throws Exception {
            try (ReadOnlyTransaction context = dbClient.readOnlyTransaction()) {
              verifyFunction.apply(context);
            }
            return null;
          }
        };
    runStressTest(callable, testRuns);
  }

  @Test
  public void readWriteTransactionSelect1Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    readWriteTransactionTest(
        new Function<TransactionContext, Void>() {
          @Override
          public Void apply(TransactionContext input) {
            verifySelect1ResultSet(input);
            return null;
          }
        },
        NUMBER_OF_SELECT1_TEST_EXECUTIONS);
  }

  @Test
  public void readWriteTransactionRandomTest()
      throws InterruptedException, ExecutionException, TimeoutException {
    readWriteTransactionTest(
        new Function<TransactionContext, Void>() {
          @Override
          public Void apply(TransactionContext input) {
            verifyRandomResultSet(input);
            return null;
          }
        },
        NUMBER_OF_RANDOM_TEST_EXECUTIONS);
  }

  @Test
  public void readWriteTransactionRandomWithParamsTest()
      throws InterruptedException, ExecutionException, TimeoutException {
    readWriteTransactionTest(
        new Function<TransactionContext, Void>() {
          @Override
          public Void apply(TransactionContext input) {
            verifyRandomWithParamsResultSet(input);
            return null;
          }
        },
        NUMBER_OF_RANDOM_TEST_EXECUTIONS);
  }

  private <T> void readWriteTransactionTest(
      final Function<TransactionContext, T> verifyFunction, int testRuns)
      throws InterruptedException, ExecutionException, TimeoutException {
    final DatabaseClient dbClient =
        spanner.getDatabaseClient(DatabaseId.of(PROJECT_ID, INSTANCE_ID, DATABASE_ID));
    Callable<Void> callable =
        new Callable<Void>() {
          @Override
          public Void call() throws Exception {
            TransactionRunner runner = dbClient.readWriteTransaction();
            Void res =
                runner.run(
                    new TransactionCallable<Void>() {
                      @Override
                      public Void run(TransactionContext transaction) throws Exception {
                        verifyFunction.apply(transaction);
                        return null;
                      }
                    });
            assertThat(runner.getCommitTimestamp(), is(notNullValue()));
            return res;
          }
        };
    runStressTest(callable, testRuns);
  }

  @Test
  public void singleUpdateTest()
      throws InterruptedException, ExecutionException, TimeoutException {
    final DatabaseClient dbClient =
        spanner.getDatabaseClient(DatabaseId.of(PROJECT_ID, INSTANCE_ID, DATABASE_ID));
    Callable<Void> callable =
        new Callable<Void>() {
          @Override
          public Void call() throws Exception {
            TransactionRunner runner = dbClient.readWriteTransaction();
            Void res =
                runner.run(
                    new TransactionCallable<Void>() {
                      @Override
                      public Void run(TransactionContext transaction) throws Exception {
                        assertThat(
                            transaction.executeUpdate(UPDATE_STATEMENT),
                            is(equalTo(UPDATE_COUNT)));
                        return null;
                      }
                    });
            assertThat(runner.getCommitTimestamp(), is(notNullValue()));
            return res;
          }
        };
    runStressTest(callable, NUMBER_OF_UPDATE_TEST_EXECUTIONS, NUMBER_OF_UPDATE_TEST_EXECUTIONS);
  }

  @Test
  public void readWriteTransactionUpdateTest()
      throws InterruptedException, ExecutionException, TimeoutException {
    final DatabaseClient dbClient =
        spanner.getDatabaseClient(DatabaseId.of(PROJECT_ID, INSTANCE_ID, DATABASE_ID));
    Callable<Void> callable =
        new Callable<Void>() {
          @Override
          public Void call() throws Exception {
            TransactionRunner runner = dbClient.readWriteTransaction();
            Void res =
                runner.run(
                    new TransactionCallable<Void>() {
                      @Override
                      public Void run(TransactionContext transaction) throws Exception {
                        for (int i = 0; i < NUMBER_OF_UPDATES_IN_TX; i++) {
                          assertThat(
                              transaction.executeUpdate(UPDATE_STATEMENT),
                              is(equalTo(UPDATE_COUNT)));
                        }
                        return null;
                      }
                    });
            assertThat(runner.getCommitTimestamp(), is(notNullValue()));
            return res;
          }
        };
    runStressTest(callable, NUMBER_OF_UPDATE_TEST_EXECUTIONS / NUMBER_OF_UPDATES_IN_TX, NUMBER_OF_UPDATE_TEST_EXECUTIONS);
  }

  private void verifySelect1ResultSet(ReadContext context) {
    try (ResultSet rs = context.executeQuery(SELECT1)) {
      assertThat(rs, is(notNullValue()));
      assertThat(rs.next(), is(true));
      assertThat(rs.getLong(0), is(equalTo(1L)));
      assertThat(rs.next(), is(false));
    }
  }

  private void verifyRandomResultSet(ReadContext context) {
    try (ResultSet rs = context.executeQuery(SELECT_RANDOM)) {
      int rowCount = 0;
      while (rs.next()) {
        for (int col = 0; col < rs.getColumnCount(); col++) {
          assertThat(getValue(rs, col), is(notNullValue()));
        }
        rowCount++;
      }
      assertThat(rowCount, is(equalTo(ROW_COUNT_RANDOM_RESULT_SET)));
    }
  }

  private void verifyRandomWithParamsResultSet(ReadContext context) {
    try (ResultSet rs = context.executeQuery(SELECT_RANDOM_WITH_PARAMS)) {
      int rowCount = 0;
      while (rs.next()) {
        for (int col = 0; col < rs.getColumnCount(); col++) {
          assertThat(getValue(rs, col), is(notNullValue()));
        }
        rowCount++;
      }
      assertThat(rowCount, is(equalTo(ROW_COUNT_RANDOM_RESULT_SET)));
    }
  }

  private Object getValue(ResultSet rs, int col) {
    if (rs.isNull(col)) {
      return Empty.getDefaultInstance();
    }
    switch (rs.getColumnType(col).getCode()) {
      case ARRAY:
        switch (rs.getColumnType(col).getArrayElementType().getCode()) {
          case BOOL:
            return rs.getBooleanList(col);
          case BYTES:
            return rs.getBytesList(col);
          case DATE:
            return rs.getDateList(col);
          case FLOAT64:
            return rs.getDoubleList(col);
          case INT64:
            return rs.getLongList(col);
          case STRING:
            return rs.getStringList(col);
          case TIMESTAMP:
            return rs.getTimestampList(col);
          case STRUCT:
          case ARRAY:
          default:
            break;
        }
        break;
      case BOOL:
        return rs.getBoolean(col);
      case BYTES:
        return rs.getBytes(col);
      case DATE:
        return rs.getDate(col);
      case FLOAT64:
        return rs.getDouble(col);
      case INT64:
        return rs.getLong(col);
      case STRING:
        return rs.getString(col);
      case TIMESTAMP:
        return rs.getTimestamp(col);
      case STRUCT:
      default:
        break;
    }
    throw new IllegalArgumentException("Unknown or unsupported type");
  }

  private <T> List<T> runStressTest(Callable<T> callable, int numberOfRuns) throws InterruptedException, ExecutionException, TimeoutException {
    return runStressTest(callable, numberOfRuns, numberOfRuns);
  }

  private <T> List<T> runStressTest(Callable<T> callable, int numberOfRuns, int executionCount)
      throws InterruptedException, ExecutionException, TimeoutException {
    Stopwatch watch = Stopwatch.createStarted();
    int parallelThreads = Integer.valueOf(this.parallelThreads);
    ScheduledThreadPoolExecutor executor =
        new ScheduledThreadPoolExecutor(parallelThreads);
    List<Future<T>> futures = new ArrayList<>(numberOfRuns);
    List<T> res = new ArrayList<>(numberOfRuns);
    for (int i = 0; i < numberOfRuns; i++) {
      futures.add(executor.submit(callable));
    }
    executor.shutdown();
    if (executor.awaitTermination(MAX_WAIT_FOR_TEST_RUN, TimeUnit.MILLISECONDS)) {
      for (Future<T> future : futures) {
        res.add(future.get());
      }
      assertThat((int) executor.getCompletedTaskCount(), is(equalTo(numberOfRuns)));
      assertThat(
          executor.getLargestPoolSize(),
          is(equalTo(Math.min(parallelThreads, numberOfRuns))));
    } else {
      throw new TimeoutException("Stress test run timed out");
    }
    watch.stop();
    lastExecutionCount = executionCount;
    lastExecutionTime = watch.elapsed(TimeUnit.MILLISECONDS);
    return res;
  }
}
