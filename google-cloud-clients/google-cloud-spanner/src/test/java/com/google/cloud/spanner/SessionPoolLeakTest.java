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

package com.google.cloud.spanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.TransactionRunner.TransactionCallable;
import io.grpc.Server;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessServerBuilder;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SessionPoolLeakTest {
  private static final StatusRuntimeException FAILED_PRECONDITION =
      io.grpc.Status.FAILED_PRECONDITION
          .withDescription("Non-retryable test exception.")
          .asRuntimeException();
  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private static LocalChannelProvider channelProvider;
  private Spanner spanner;
  private DatabaseClient client;
  private SessionPool pool;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    String uniqueName = InProcessServerBuilder.generateName();
    server = InProcessServerBuilder.forName(uniqueName).addService(mockSpanner).build().start();
    channelProvider = LocalChannelProvider.create(uniqueName);
  }

  @AfterClass
  public static void stopServer() {
    server.shutdown();
  }

  @Before
  public void setUp() throws Exception {
    mockSpanner.reset();
    mockSpanner.removeAllExecutionTimes();
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance());
    // Make sure the session pool is empty by default, does not contain any write-prepared sessions,
    // and contains at most 2 sessions.
    builder.setSessionPoolOption(
        SessionPoolOptions.newBuilder()
            .setMinSessions(0)
            .setMaxSessions(2)
            .setWriteSessionsFraction(0.0f)
            .build());
    spanner = builder.build().getService();
    client = spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    pool = ((DatabaseClientImpl) client).pool;
  }

  @After
  public void tearDown() throws Exception {
    spanner.close();
  }

  @Test
  public void testReadWriteTransactionExceptionOnCreateSession() {
    readWriteTransactionTest(
        new Runnable() {
          @Override
          public void run() {
            mockSpanner.setCreateSessionExecutionTime(
                SimulatedExecutionTime.ofException(FAILED_PRECONDITION));
          }
        },
        0);
  }

  @Test
  public void testReadWriteTransactionExceptionOnBegin() {
    readWriteTransactionTest(
        new Runnable() {
          @Override
          public void run() {
            mockSpanner.setBeginTransactionExecutionTime(
                SimulatedExecutionTime.ofException(FAILED_PRECONDITION));
          }
        },
        1);
  }

  private void readWriteTransactionTest(
      Runnable setup, int expectedNumberOfSessionsAfterExecution) {
    assertThat(pool.getNumberOfSessionsInPool(), is(equalTo(0)));
    setup.run();
    try {
      client
          .readWriteTransaction()
          .run(
              new TransactionCallable<Void>() {
                @Override
                public Void run(TransactionContext transaction) throws Exception {
                  return null;
                }
              });
      fail("missing FAILED_PRECONDITION exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode(), is(equalTo(ErrorCode.FAILED_PRECONDITION)));
    }
    assertThat(
        pool.getNumberOfSessionsInPool(), is(equalTo(expectedNumberOfSessionsAfterExecution)));
  }

  @Test
  public void testTansactionManagerExceptionOnCreateSession() {
    transactionManagerTest(
        new Runnable() {
          @Override
          public void run() {
            mockSpanner.setCreateSessionExecutionTime(
                SimulatedExecutionTime.ofException(FAILED_PRECONDITION));
          }
        },
        0);
  }

  @Test
  public void testTransactionManagerExceptionOnBegin() throws Exception {
    transactionManagerTest(
        new Runnable() {
          @Override
          public void run() {
            mockSpanner.setBeginTransactionExecutionTime(
                SimulatedExecutionTime.ofException(FAILED_PRECONDITION));
          }
        },
        1);
  }

  private void transactionManagerTest(Runnable setup, int expectedNumberOfSessionsAfterExecution) {
    assertThat(pool.getNumberOfSessionsInPool(), is(equalTo(0)));
    setup.run();
    try (TransactionManager txManager = client.transactionManager()) {
      txManager.begin();
      fail("missing FAILED_PRECONDITION exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode(), is(equalTo(ErrorCode.FAILED_PRECONDITION)));
    }
    assertThat(
        pool.getNumberOfSessionsInPool(), is(equalTo(expectedNumberOfSessionsAfterExecution)));
  }
}
