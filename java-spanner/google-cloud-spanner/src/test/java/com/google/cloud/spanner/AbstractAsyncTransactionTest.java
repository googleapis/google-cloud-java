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

package com.google.cloud.spanner;

import static com.google.cloud.spanner.MockSpannerTestUtil.EMPTY_KEY_VALUE_RESULTSET;
import static com.google.cloud.spanner.MockSpannerTestUtil.INVALID_UPDATE_STATEMENT;
import static com.google.cloud.spanner.MockSpannerTestUtil.READ_MULTIPLE_KEY_VALUE_RESULTSET;
import static com.google.cloud.spanner.MockSpannerTestUtil.READ_MULTIPLE_KEY_VALUE_STATEMENT;
import static com.google.cloud.spanner.MockSpannerTestUtil.READ_ONE_EMPTY_KEY_VALUE_STATEMENT;
import static com.google.cloud.spanner.MockSpannerTestUtil.READ_ONE_KEY_VALUE_RESULTSET;
import static com.google.cloud.spanner.MockSpannerTestUtil.READ_ONE_KEY_VALUE_STATEMENT;
import static com.google.cloud.spanner.MockSpannerTestUtil.TEST_DATABASE;
import static com.google.cloud.spanner.MockSpannerTestUtil.TEST_INSTANCE;
import static com.google.cloud.spanner.MockSpannerTestUtil.TEST_PROJECT;
import static com.google.cloud.spanner.MockSpannerTestUtil.UPDATE_ABORTED_STATEMENT;
import static com.google.cloud.spanner.MockSpannerTestUtil.UPDATE_COUNT;
import static com.google.cloud.spanner.MockSpannerTestUtil.UPDATE_STATEMENT;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/** Base class for {@link AsyncRunnerTest} and {@link AsyncTransactionManagerTest}. */
public abstract class AbstractAsyncTransactionTest {
  static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private static InetSocketAddress address;
  static ExecutorService executor;

  Spanner spanner;

  @BeforeClass
  public static void setup() throws Exception {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D);
    mockSpanner.putStatementResult(
        StatementResult.query(READ_ONE_EMPTY_KEY_VALUE_STATEMENT, EMPTY_KEY_VALUE_RESULTSET));
    mockSpanner.putStatementResult(
        StatementResult.query(READ_ONE_KEY_VALUE_STATEMENT, READ_ONE_KEY_VALUE_RESULTSET));
    mockSpanner.putStatementResult(
        StatementResult.query(
            READ_MULTIPLE_KEY_VALUE_STATEMENT, READ_MULTIPLE_KEY_VALUE_RESULTSET));
    mockSpanner.putStatementResult(StatementResult.update(UPDATE_STATEMENT, UPDATE_COUNT));
    mockSpanner.putStatementResult(
        StatementResult.exception(
            INVALID_UPDATE_STATEMENT,
            Status.INVALID_ARGUMENT.withDescription("invalid statement").asRuntimeException()));
    mockSpanner.putStatementResult(
        StatementResult.exception(
            UPDATE_ABORTED_STATEMENT,
            Status.ABORTED.withDescription("Transaction was aborted").asRuntimeException()));

    address = new InetSocketAddress("localhost", 0);
    server = NettyServerBuilder.forAddress(address).addService(mockSpanner).build().start();
    executor = Executors.newSingleThreadExecutor();
  }

  @AfterClass
  public static void teardown() throws Exception {
    server.shutdown();
    server.awaitTermination();
    executor.shutdown();
  }

  @Before
  public void before() {
    String endpoint = address.getHostString() + ":" + server.getPort();
    spanner =
        SpannerOptions.newBuilder()
            .setProjectId(TEST_PROJECT)
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setHost("http://" + endpoint)
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(SessionPoolOptions.newBuilder().setFailOnSessionLeak().build())
            .build()
            .getService();
  }

  @After
  public void after() {
    spanner.close();
    mockSpanner.removeAllExecutionTimes();
    mockSpanner.reset();
  }

  DatabaseClient client() {
    return spanner.getDatabaseClient(DatabaseId.of(TEST_PROJECT, TEST_INSTANCE, TEST_DATABASE));
  }
}
