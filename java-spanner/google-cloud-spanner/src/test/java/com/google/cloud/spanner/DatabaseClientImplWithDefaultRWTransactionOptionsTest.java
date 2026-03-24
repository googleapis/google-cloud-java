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

import static com.google.cloud.spanner.MockSpannerTestUtil.INVALID_SELECT_STATEMENT;
import static com.google.cloud.spanner.MockSpannerTestUtil.SELECT1;
import static com.google.cloud.spanner.MockSpannerTestUtil.SELECT1_RESULTSET;
import static com.google.cloud.spanner.MockSpannerTestUtil.UPDATE_COUNT;
import static com.google.cloud.spanner.MockSpannerTestUtil.UPDATE_STATEMENT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Options.RpcPriority;
import com.google.cloud.spanner.Options.TransactionOption;
import com.google.cloud.spanner.SpannerOptions.Builder.DefaultReadWriteTransactionOptions;
import com.google.protobuf.AbstractMessage;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import com.google.spanner.v1.TransactionOptions.ReadWrite.ReadLockMode;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.inprocess.InProcessServerBuilder;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.function.Consumer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DatabaseClientImplWithDefaultRWTransactionOptionsTest {
  private static final TransactionOption SERIALIZABLE_ISOLATION_OPTION =
      Options.isolationLevel(IsolationLevel.SERIALIZABLE);
  private static final TransactionOption RR_ISOLATION_OPTION =
      Options.isolationLevel(IsolationLevel.REPEATABLE_READ);
  private static final TransactionOption OPTIMISTIC_READ_LOCK_OPTION =
      Options.readLockMode(ReadLockMode.OPTIMISTIC);
  private static final TransactionOption PESSIMISTIC_READ_LOCK_OPTION =
      Options.readLockMode(ReadLockMode.PESSIMISTIC);
  private static final DatabaseId DATABASE_ID =
      DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private static ExecutorService executor;
  private static LocalChannelProvider channelProvider;
  private Spanner spanner;
  private Spanner spannerWithRR;
  private Spanner spannerWithRRPessimistic;
  private Spanner spannerWithSerializable;
  private Spanner spannerWithSerOptimistic;
  private DatabaseClient client;
  private DatabaseClient clientWithRepeatableReadOption;
  private DatabaseClient clientWithRRPessimisticOption;
  private DatabaseClient clientWithSerializableOption;
  private DatabaseClient clientWithSerOptimisticOption;

  @BeforeClass
  public static void startStaticServer() throws Exception {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    mockSpanner.putStatementResult(StatementResult.update(UPDATE_STATEMENT, UPDATE_COUNT));
    mockSpanner.putStatementResult(StatementResult.query(SELECT1, SELECT1_RESULTSET));
    mockSpanner.putStatementResult(
        StatementResult.exception(
            INVALID_SELECT_STATEMENT,
            Status.INVALID_ARGUMENT.withDescription("invalid statement").asRuntimeException()));
    mockSpanner.putStatementResult(
        StatementResult.read(
            "FOO", KeySet.all(), Collections.singletonList("ID"), SELECT1_RESULTSET));

    String uniqueName = InProcessServerBuilder.generateName();
    executor = Executors.newSingleThreadExecutor();
    server =
        InProcessServerBuilder.forName(uniqueName)
            // We need to use a real executor for timeouts to occur.
            .scheduledExecutorService(new ScheduledThreadPoolExecutor(1))
            .addService(mockSpanner)
            .build()
            .start();
    channelProvider = LocalChannelProvider.create(uniqueName);
  }

  @AfterClass
  public static void stopServer() throws InterruptedException {
    server.shutdown();
    server.awaitTermination();
  }

  @Before
  public void setUp() {
    mockSpanner.reset();
    mockSpanner.removeAllExecutionTimes();
    spanner = getSpannerOptionsBuilder().build().getService();
    spannerWithRR = getSpannerOptionsBuilder(IsolationLevel.REPEATABLE_READ).build().getService();
    spannerWithRRPessimistic =
        getSpannerOptionsBuilder(IsolationLevel.REPEATABLE_READ, ReadLockMode.PESSIMISTIC)
            .build()
            .getService();
    spannerWithSerializable =
        getSpannerOptionsBuilder(IsolationLevel.SERIALIZABLE).build().getService();
    spannerWithSerOptimistic =
        getSpannerOptionsBuilder(IsolationLevel.SERIALIZABLE, ReadLockMode.OPTIMISTIC)
            .build()
            .getService();
    client = spanner.getDatabaseClient(DATABASE_ID);
    clientWithRepeatableReadOption = spannerWithRR.getDatabaseClient(DATABASE_ID);
    clientWithRRPessimisticOption = spannerWithRRPessimistic.getDatabaseClient(DATABASE_ID);
    clientWithSerializableOption = spannerWithSerializable.getDatabaseClient(DATABASE_ID);
    clientWithSerOptimisticOption = spannerWithSerOptimistic.getDatabaseClient(DATABASE_ID);
  }

  private static SpannerOptions.Builder getSpannerOptionsBuilder() {
    return getSpannerOptionsBuilder(
        IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED, ReadLockMode.READ_LOCK_MODE_UNSPECIFIED);
  }

  private static SpannerOptions.Builder getSpannerOptionsBuilder(IsolationLevel isolationLevel) {
    return getSpannerOptionsBuilder(isolationLevel, ReadLockMode.READ_LOCK_MODE_UNSPECIFIED);
  }

  private static SpannerOptions.Builder getSpannerOptionsBuilder(
      IsolationLevel isolationLevel, ReadLockMode readLockMode) {
    SpannerOptions.Builder spannerOptionsBuilder =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance());
    return spannerOptionsBuilder.setDefaultTransactionOptions(
        DefaultReadWriteTransactionOptions.newBuilder()
            .setIsolationLevel(isolationLevel)
            .setReadLockMode(readLockMode)
            .build());
  }

  private void executeTest(
      Consumer<DatabaseClient> testAction, IsolationLevel expectedIsolationLevel) {
    testAction.accept(client);
    validateIsolationLevel(expectedIsolationLevel, ReadLockMode.READ_LOCK_MODE_UNSPECIFIED);
  }

  private void executeTest(
      Consumer<DatabaseClient> testAction,
      IsolationLevel expectedIsolationLevel,
      ReadLockMode readLockMode) {
    testAction.accept(client);
    validateIsolationLevel(expectedIsolationLevel, readLockMode);
  }

  private void executeTestWithRR(
      Consumer<DatabaseClient> testAction, IsolationLevel expectedIsolationLevel) {
    testAction.accept(clientWithRepeatableReadOption);
    validateIsolationLevel(expectedIsolationLevel, ReadLockMode.READ_LOCK_MODE_UNSPECIFIED);
  }

  private void executeTestWithRRPessimistic(
      Consumer<DatabaseClient> testAction,
      IsolationLevel expectedIsolationLevel,
      ReadLockMode expectedReadLockMode) {
    testAction.accept(clientWithRRPessimisticOption);
    validateIsolationLevel(expectedIsolationLevel, expectedReadLockMode);
  }

  private void executeTestWithSerializable(
      Consumer<DatabaseClient> testAction, IsolationLevel expectedIsolationLevel) {
    testAction.accept(clientWithSerializableOption);
    validateIsolationLevel(expectedIsolationLevel, ReadLockMode.READ_LOCK_MODE_UNSPECIFIED);
  }

  private void executeTestWithSerializableOptimistic(
      Consumer<DatabaseClient> testAction,
      IsolationLevel expectedIsolationLevel,
      ReadLockMode expectedReadLockMode) {
    testAction.accept(clientWithSerOptimisticOption);
    validateIsolationLevel(expectedIsolationLevel, expectedReadLockMode);
  }

  @After
  public void tearDown() {
    spanner.close();
    spannerWithRR.close();
    spannerWithRRPessimistic.close();
    spannerWithSerializable.close();
    spannerWithSerOptimistic.close();
  }

  @Test
  public void testWrite_WithNoIsolationLevel() {
    executeTest(
        MockSpannerTestActions::writeInsertMutation, IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED);
  }

  @Test
  public void testWrite_WithRRSpannerOptions() {
    executeTestWithRR(MockSpannerTestActions::writeInsertMutation, IsolationLevel.REPEATABLE_READ);
  }

  @Test
  public void testWriteWithOptions_WithRRSpannerOptions() {
    executeTestWithRR(
        c ->
            MockSpannerTestActions.writeInsertMutationWithOptions(
                c, Options.priority(RpcPriority.HIGH)),
        IsolationLevel.REPEATABLE_READ);
  }

  @Test
  public void testWriteWithOptions_WithRRPessimisticSpannerOptions() {
    executeTestWithRRPessimistic(
        c ->
            MockSpannerTestActions.writeInsertMutationWithOptions(
                c, Options.priority(RpcPriority.HIGH)),
        IsolationLevel.REPEATABLE_READ,
        ReadLockMode.PESSIMISTIC);
  }

  @Test
  public void testWriteWithOptions_WithSerializableTxnOption() {
    executeTestWithRR(
        c ->
            MockSpannerTestActions.writeInsertMutationWithOptions(c, SERIALIZABLE_ISOLATION_OPTION),
        IsolationLevel.SERIALIZABLE);
  }

  @Test
  public void testWriteWithOptions_WithSerializableOptimisticTxnOption() {
    executeTestWithRRPessimistic(
        c ->
            MockSpannerTestActions.writeInsertMutationWithOptions(
                c, SERIALIZABLE_ISOLATION_OPTION, OPTIMISTIC_READ_LOCK_OPTION),
        IsolationLevel.SERIALIZABLE,
        ReadLockMode.OPTIMISTIC);
  }

  @Test
  public void testWriteAtLeastOnce_WithSerializableSpannerOptions() {
    executeTestWithSerializable(
        MockSpannerTestActions::writeAtLeastOnceInsertMutation, IsolationLevel.SERIALIZABLE);
  }

  @Test
  public void testWriteAtLeastOnceWithOptions_WithRRTxnOption() {
    executeTestWithSerializable(
        c ->
            MockSpannerTestActions.writeAtLeastOnceWithOptionsInsertMutation(
                c, RR_ISOLATION_OPTION),
        IsolationLevel.REPEATABLE_READ);
  }

  @Test
  public void testWriteAtLeastOnceWithOptions_WithRRPessimisticTxnOption() {
    executeTestWithSerializableOptimistic(
        c ->
            MockSpannerTestActions.writeAtLeastOnceWithOptionsInsertMutation(
                c, RR_ISOLATION_OPTION, PESSIMISTIC_READ_LOCK_OPTION),
        IsolationLevel.REPEATABLE_READ,
        ReadLockMode.PESSIMISTIC);
  }

  @Test
  public void testWriteAtLeastOnceWithOptions_WithPessimisticTxnOption() {
    executeTestWithRRPessimistic(
        c ->
            MockSpannerTestActions.writeAtLeastOnceWithOptionsInsertMutation(
                c, OPTIMISTIC_READ_LOCK_OPTION),
        IsolationLevel.REPEATABLE_READ,
        ReadLockMode.OPTIMISTIC);
  }

  @Test
  public void testReadWriteTxn_WithRRSpannerOption_batchUpdate() {
    executeTestWithRR(
        MockSpannerTestActions::executeBatchUpdateTransaction, IsolationLevel.REPEATABLE_READ);
  }

  @Test
  public void testReadWriteTxn_WithSerializableTxnOption_batchUpdate() {
    executeTestWithRR(
        c -> MockSpannerTestActions.executeBatchUpdateTransaction(c, SERIALIZABLE_ISOLATION_OPTION),
        IsolationLevel.SERIALIZABLE);
  }

  @Test
  public void testReadWriteTxn_WithSerOptimisticTxnOption_batchUpdate() {
    executeTestWithRRPessimistic(
        c ->
            MockSpannerTestActions.executeBatchUpdateTransaction(
                c, SERIALIZABLE_ISOLATION_OPTION, OPTIMISTIC_READ_LOCK_OPTION),
        IsolationLevel.SERIALIZABLE,
        ReadLockMode.OPTIMISTIC);
  }

  @Test
  public void testPartitionedDML_WithRRSpannerOption() {
    executeTestWithRR(
        MockSpannerTestActions::executePartitionedUpdate,
        IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED);
  }

  @Test
  public void testCommit_WithSerializableTxnOption() {
    executeTest(
        c -> MockSpannerTestActions.commitDeleteTransaction(c, SERIALIZABLE_ISOLATION_OPTION),
        IsolationLevel.SERIALIZABLE);
  }

  @Test
  public void testCommit_WithSerializablePessimisticTxnOption() {
    executeTest(
        c ->
            MockSpannerTestActions.commitDeleteTransaction(
                c, SERIALIZABLE_ISOLATION_OPTION, PESSIMISTIC_READ_LOCK_OPTION),
        IsolationLevel.SERIALIZABLE,
        ReadLockMode.PESSIMISTIC);
  }

  @Test
  public void testCommit_WithSerializableOptimisticTxnOption() {
    executeTest(
        c ->
            MockSpannerTestActions.commitDeleteTransaction(
                c, SERIALIZABLE_ISOLATION_OPTION, OPTIMISTIC_READ_LOCK_OPTION),
        IsolationLevel.SERIALIZABLE,
        ReadLockMode.OPTIMISTIC);
  }

  @Test
  public void testTransactionManagerCommit_WithRRTxnOption() {
    executeTestWithSerializable(
        c -> MockSpannerTestActions.transactionManagerCommit(c, RR_ISOLATION_OPTION),
        IsolationLevel.REPEATABLE_READ);
  }

  @Test
  public void testTransactionManagerCommit_WithRRTxnOptionAndSerOptimisticSpannerOptions() {
    executeTestWithSerializableOptimistic(
        c -> MockSpannerTestActions.transactionManagerCommit(c, RR_ISOLATION_OPTION),
        IsolationLevel.REPEATABLE_READ,
        ReadLockMode.OPTIMISTIC);
  }

  @Test
  public void testAsyncRunnerCommit_WithRRSpannerOption() {
    executeTestWithRR(
        c -> MockSpannerTestActions.asyncRunnerCommit(c, executor), IsolationLevel.REPEATABLE_READ);
  }

  @Test
  public void testAsyncRunnerCommit_WithSerOptimisticSpannerOption() {
    executeTestWithSerializableOptimistic(
        c -> MockSpannerTestActions.asyncRunnerCommit(c, executor),
        IsolationLevel.SERIALIZABLE,
        ReadLockMode.OPTIMISTIC);
  }

  @Test
  public void testAsyncTransactionManagerCommit_WithSerializableTxnOption() {
    executeTestWithRR(
        c ->
            MockSpannerTestActions.transactionManagerAsyncCommit(
                c, executor, SERIALIZABLE_ISOLATION_OPTION),
        IsolationLevel.SERIALIZABLE);
  }

  @Test
  public void testAsyncTransactionManagerCommit_WithRRPessimisticSpannerOptions() {
    executeTestWithRRPessimistic(
        c -> MockSpannerTestActions.transactionManagerAsyncCommit(c, executor),
        IsolationLevel.REPEATABLE_READ,
        ReadLockMode.PESSIMISTIC);
  }

  @Test
  public void testAsyncTransactionManagerCommit_WithSerOptimisticTxnOption() {
    executeTestWithRRPessimistic(
        c ->
            MockSpannerTestActions.transactionManagerAsyncCommit(
                c, executor, SERIALIZABLE_ISOLATION_OPTION, OPTIMISTIC_READ_LOCK_OPTION),
        IsolationLevel.SERIALIZABLE,
        ReadLockMode.OPTIMISTIC);
  }

  @Test
  public void testReadWriteTxn_WithNoOptions() {
    executeTest(MockSpannerTestActions::executeSelect1, IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED);
  }

  @Test
  public void executeSqlWithRWTransactionOptions_RepeatableRead() {
    executeTest(
        c -> MockSpannerTestActions.executeSelect1(c, RR_ISOLATION_OPTION),
        IsolationLevel.REPEATABLE_READ);
  }

  @Test
  public void executeSqlWithRWTransactionOptions_RRPessimistic() {
    executeTest(
        c ->
            MockSpannerTestActions.executeSelect1(
                c, RR_ISOLATION_OPTION, PESSIMISTIC_READ_LOCK_OPTION),
        IsolationLevel.REPEATABLE_READ,
        ReadLockMode.PESSIMISTIC);
  }

  @Test
  public void executeSqlWithRWTransactionOptions_RROptimistic() {
    executeTest(
        c ->
            MockSpannerTestActions.executeSelect1(
                c, RR_ISOLATION_OPTION, PESSIMISTIC_READ_LOCK_OPTION),
        IsolationLevel.REPEATABLE_READ,
        ReadLockMode.PESSIMISTIC);
  }

  @Test
  public void
      executeSqlWithDefaultSpannerOptions_SerializableAndRWTransactionOptions_RepeatableRead() {
    executeTestWithSerializable(
        c -> MockSpannerTestActions.executeSelect1(c, RR_ISOLATION_OPTION),
        IsolationLevel.REPEATABLE_READ);
  }

  @Test
  public void
      executeSqlWithDefaultSpannerOptions_RepeatableReadAndRWTransactionOptions_Serializable() {
    executeTestWithRR(
        c -> MockSpannerTestActions.executeSelect1(c, SERIALIZABLE_ISOLATION_OPTION),
        IsolationLevel.SERIALIZABLE);
  }

  @Test
  public void executeSqlWithDefaultSpannerOptions_RepeatableReadAndNoRWTransactionOptions() {
    executeTestWithRR(MockSpannerTestActions::executeSelect1, IsolationLevel.REPEATABLE_READ);
  }

  @Test
  public void executeSqlWithRWTransactionOptions_Serializable() {
    executeTest(
        c -> MockSpannerTestActions.executeSelect1(c, SERIALIZABLE_ISOLATION_OPTION),
        IsolationLevel.SERIALIZABLE);
  }

  @Test
  public void executeSqlWithRWTransactionOptions_SerializablePessimistic() {
    executeTest(
        c ->
            MockSpannerTestActions.executeSelect1(
                c, SERIALIZABLE_ISOLATION_OPTION, PESSIMISTIC_READ_LOCK_OPTION),
        IsolationLevel.SERIALIZABLE,
        ReadLockMode.PESSIMISTIC);
  }

  @Test
  public void executeSqlWithRWTransactionOptions_SerializableOptimistic() {
    executeTest(
        c ->
            MockSpannerTestActions.executeSelect1(
                c, SERIALIZABLE_ISOLATION_OPTION, OPTIMISTIC_READ_LOCK_OPTION),
        IsolationLevel.SERIALIZABLE,
        ReadLockMode.OPTIMISTIC);
  }

  @Test
  public void readWithRWTransactionOptions_RepeatableRead() {
    executeTest(
        c -> MockSpannerTestActions.executeReadFoo(c, RR_ISOLATION_OPTION),
        IsolationLevel.REPEATABLE_READ);
  }

  @Test
  public void readWithRWTransactionOptions_RepeatableReadPessimistic() {
    executeTest(
        c ->
            MockSpannerTestActions.executeReadFoo(
                c, RR_ISOLATION_OPTION, PESSIMISTIC_READ_LOCK_OPTION),
        IsolationLevel.REPEATABLE_READ,
        ReadLockMode.PESSIMISTIC);
  }

  @Test
  public void readWithRWTransactionOptions_RepeatableReadOptimistic() {
    executeTest(
        c ->
            MockSpannerTestActions.executeReadFoo(
                c, RR_ISOLATION_OPTION, OPTIMISTIC_READ_LOCK_OPTION),
        IsolationLevel.REPEATABLE_READ,
        ReadLockMode.OPTIMISTIC);
  }

  @Test
  public void readWithRWTransactionOptions_Serializable() {
    executeTest(
        c -> MockSpannerTestActions.executeReadFoo(c, SERIALIZABLE_ISOLATION_OPTION),
        IsolationLevel.SERIALIZABLE);
  }

  @Test
  public void beginTransactionWithRWTransactionOptions_RepeatableRead() {
    executeTest(
        c -> MockSpannerTestActions.executeInvalidAndValidSql(c, RR_ISOLATION_OPTION),
        IsolationLevel.REPEATABLE_READ);
  }

  @Test
  public void beginTransactionWithRWTransactionOptions_Serializable() {
    executeTest(
        c -> MockSpannerTestActions.executeInvalidAndValidSql(c, SERIALIZABLE_ISOLATION_OPTION),
        IsolationLevel.SERIALIZABLE);
  }

  @Test
  public void beginTransactionWithRWTransactionOptions_RROptimistic() {
    executeTestWithRRPessimistic(
        c -> MockSpannerTestActions.executeInvalidAndValidSql(c, OPTIMISTIC_READ_LOCK_OPTION),
        IsolationLevel.REPEATABLE_READ,
        ReadLockMode.OPTIMISTIC);
  }

  @Test
  public void beginTransactionWithRWTransactionOptions_SerPessimistic() {
    executeTestWithRRPessimistic(
        c -> MockSpannerTestActions.executeInvalidAndValidSql(c, SERIALIZABLE_ISOLATION_OPTION),
        IsolationLevel.SERIALIZABLE,
        ReadLockMode.PESSIMISTIC);
  }

  @Test
  public void beginTransactionWithRWTransactionOptions_SerOptimistic() {
    executeTestWithRRPessimistic(
        c ->
            MockSpannerTestActions.executeInvalidAndValidSql(
                c, SERIALIZABLE_ISOLATION_OPTION, OPTIMISTIC_READ_LOCK_OPTION),
        IsolationLevel.SERIALIZABLE,
        ReadLockMode.OPTIMISTIC);
  }

  private void validateIsolationLevel(IsolationLevel isolationLevel, ReadLockMode readLockMode) {
    boolean foundMatchingRequest = false;
    for (AbstractMessage request : mockSpanner.getRequests()) {
      if (request instanceof ExecuteSqlRequest) {
        foundMatchingRequest = true;
        assertEquals(
            isolationLevel,
            ((ExecuteSqlRequest) request).getTransaction().getBegin().getIsolationLevel());
        assertEquals(
            readLockMode,
            ((ExecuteSqlRequest) request)
                .getTransaction()
                .getBegin()
                .getReadWrite()
                .getReadLockMode());
      } else if (request instanceof BeginTransactionRequest) {
        foundMatchingRequest = true;
        assertEquals(
            isolationLevel, ((BeginTransactionRequest) request).getOptions().getIsolationLevel());
        assertEquals(
            readLockMode,
            ((BeginTransactionRequest) request).getOptions().getReadWrite().getReadLockMode());
      } else if (request instanceof ReadRequest) {
        foundMatchingRequest = true;
        assertEquals(
            isolationLevel,
            ((ReadRequest) request).getTransaction().getBegin().getIsolationLevel());
        assertEquals(
            readLockMode,
            ((ReadRequest) request).getTransaction().getBegin().getReadWrite().getReadLockMode());
      } else if (request instanceof CommitRequest) {
        foundMatchingRequest = true;
        assertEquals(
            isolationLevel,
            ((CommitRequest) request).getSingleUseTransaction().getIsolationLevel());
        assertEquals(
            readLockMode,
            ((CommitRequest) request).getSingleUseTransaction().getReadWrite().getReadLockMode());
      } else if (request instanceof ExecuteBatchDmlRequest) {
        foundMatchingRequest = true;
        assertEquals(
            isolationLevel,
            ((ExecuteBatchDmlRequest) request).getTransaction().getBegin().getIsolationLevel());
        assertEquals(
            readLockMode,
            ((ExecuteBatchDmlRequest) request)
                .getTransaction()
                .getBegin()
                .getReadWrite()
                .getReadLockMode());
      }
      if (foundMatchingRequest) {
        break;
      }
    }
    assertTrue("No gRPC call is made", foundMatchingRequest);
  }
}
