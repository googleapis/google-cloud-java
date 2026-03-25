/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.spanner.MockSpannerTestUtil.INVALID_UPDATE_STATEMENT;
import static com.google.cloud.spanner.MockSpannerTestUtil.UPDATE_COUNT;
import static com.google.cloud.spanner.MockSpannerTestUtil.UPDATE_STATEMENT;
import static com.google.cloud.spanner.SpannerApiFutures.get;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.NoCredentials;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AsyncTransactionManager.AsyncTransactionStep;
import com.google.cloud.spanner.AsyncTransactionManager.CommitTimestampFuture;
import com.google.cloud.spanner.AsyncTransactionManager.TransactionContextFuture;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Options.RpcPriority;
import com.google.cloud.spanner.TransactionRunnerImpl.TransactionContextImpl;
import com.google.cloud.spanner.connection.RandomResultSetGenerator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.*;
import com.google.spanner.v1.RequestOptions.Priority;
import com.google.spanner.v1.Session;
import io.grpc.Status;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MultiplexedSessionDatabaseClientMockServerTest extends AbstractMockServerTest {
  private static final Statement STATEMENT = Statement.of("select * from random");

  @BeforeClass
  public static void setupResults() {
    assumeFalse(TestHelper.isMultiplexSessionDisabled());
    mockSpanner.putStatementResults(
        StatementResult.query(STATEMENT, new RandomResultSetGenerator(1).generate()));
    mockSpanner.putStatementResult(StatementResult.update(UPDATE_STATEMENT, UPDATE_COUNT));
    mockSpanner.putStatementResult(
        StatementResult.exception(
            INVALID_UPDATE_STATEMENT,
            Status.INVALID_ARGUMENT.withDescription("invalid statement").asRuntimeException()));
  }

  @Before
  public void createSpannerInstance() {
    spanner =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    .setUseMultiplexedSession(true)
                    .setUseMultiplexedSessionForRW(true)
                    .setUseMultiplexedSessionPartitionedOps(true)
                    // Set the maintainer to loop once every 1ms
                    .setMultiplexedSessionMaintenanceLoopFrequency(Duration.ofMillis(1L))
                    // Set multiplexed sessions to be replaced once every 1ms
                    .setMultiplexedSessionMaintenanceDuration(Duration.ofMillis(1L))
                    .setFailOnSessionLeak()
                    .build())
            .build()
            .getService();
  }

  @Test
  public void testCreateSessionDeadlineExceeded() {
    // Simulate a problem with the CreateSession RPC making it slow.
    mockSpanner.setCreateSessionExecutionTime(
        SimulatedExecutionTime.ofException(Status.DEADLINE_EXCEEDED.asRuntimeException()));

    Spanner testSpanner =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .build()
            .getService();
    DatabaseClient client = testSpanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    // The first attempt should lead to a DEADLINE_EXCEEDED error being propagated from the
    // CreateSession attempt.
    try (ResultSet resultSet = client.singleUse().executeQuery(STATEMENT)) {
      SpannerException exception = assertThrows(SpannerException.class, resultSet::next);
      assertEquals(ErrorCode.DEADLINE_EXCEEDED, exception.getErrorCode());
    }

    // Remove the simulated problem on the mock server.
    // The next attempt should then succeed.
    mockSpanner.removeAllExecutionTimes();
    try (ResultSet resultSet = client.singleUse().executeQuery(STATEMENT)) {
      //noinspection StatementWithEmptyBody
      while (resultSet.next()) {}
    }
  }

  @Test
  public void testMultiUseReadOnlyTransactionUsesSameSession() {
    // Execute two queries using the same transaction. Both queries should use the same
    // session, also when the maintainer has executed in the meantime.
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    try (ReadOnlyTransaction transaction = client.readOnlyTransaction()) {
      try (ResultSet resultSet = transaction.executeQuery(STATEMENT)) {
        //noinspection StatementWithEmptyBody
        while (resultSet.next()) {
          // ignore
        }
      }

      // Wait until the maintainer has replaced the current session.
      waitForSessionToBeReplaced(client);

      try (ResultSet resultSet = transaction.executeQuery(STATEMENT)) {
        //noinspection StatementWithEmptyBody
        while (resultSet.next()) {
          // ignore
        }
      }
    }
    List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(2, requests.size());
    assertEquals(requests.get(0).getSession(), requests.get(1).getSession());

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  @Test
  public void testNewTransactionUsesNewSession() {
    // Execute a single-use read-only transactions, then wait for the maintainer to replace the
    // current session, and then run another single-use read-only transaction. The two transactions
    // should use two different sessions.
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    try (ResultSet resultSet = client.singleUse().executeQuery(STATEMENT)) {
      //noinspection StatementWithEmptyBody
      while (resultSet.next()) {
        // ignore
      }
    }

    // Wait until the maintainer has replaced the current session.
    waitForSessionToBeReplaced(client);

    try (ResultSet resultSet = client.singleUse().executeQuery(STATEMENT)) {
      //noinspection StatementWithEmptyBody
      while (resultSet.next()) {
        // ignore
      }
    }

    List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(2, requests.size());
    assertNotEquals(requests.get(0).getSession(), requests.get(1).getSession());

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(2L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(2L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  @Test
  public void testMaintainerMaintainsMultipleClients() {
    // Verify that the single-threaded shared executor that is used by the multiplexed client
    // maintains and replaces sessions from multiple clients.
    DatabaseClientImpl client1 =
        (DatabaseClientImpl)
            spanner.getDatabaseClient(DatabaseId.of("p", "i", "d" + UUID.randomUUID()));
    DatabaseClientImpl client2 =
        (DatabaseClientImpl)
            spanner.getDatabaseClient(DatabaseId.of("p", "i", "d" + UUID.randomUUID()));

    for (DatabaseClientImpl client : ImmutableList.of(client1, client2)) {
      try (ResultSet resultSet = client.singleUse().executeQuery(STATEMENT)) {
        //noinspection StatementWithEmptyBody
        while (resultSet.next()) {
          // ignore
        }
      }
      // Wait until the maintainer has replaced the current session.
      waitForSessionToBeReplaced(client);
      try (ResultSet resultSet = client.singleUse().executeQuery(STATEMENT)) {
        //noinspection StatementWithEmptyBody
        while (resultSet.next()) {
          // ignore
        }
      }
    }

    List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(4, requests.size());
    // Put all session IDs in a Set to verify that they were all different.
    Set<String> sessionIds =
        requests.stream().map(ExecuteSqlRequest::getSession).collect(Collectors.toSet());
    assertEquals(4, sessionIds.size());

    for (DatabaseClientImpl client : ImmutableList.of(client1, client2)) {
      assertNotNull(client.multiplexedSessionDatabaseClient);
      assertEquals(2L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
      assertEquals(2L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
    }
  }

  @Test
  public void testRetryWithTheSessionCreationWaitTime() {
    mockSpanner.setCreateSessionExecutionTime(
        SimulatedExecutionTime.ofExceptions(
            Arrays.asList(
                Status.DEADLINE_EXCEEDED
                    .withDescription(
                        "CallOptions deadline exceeded after 22.986872393s. "
                            + "Name resolution delay 6.911918521 seconds. [closed=[], "
                            + "open=[[connecting_and_lb_delay=32445014148ns, was_still_waiting]]]")
                    .asRuntimeException(),
                Status.DEADLINE_EXCEEDED
                    .withDescription(
                        "CallOptions deadline exceeded after 22.986872393s. "
                            + "Name resolution delay 6.911918521 seconds. [closed=[], "
                            + "open=[[connecting_and_lb_delay=32445014148ns, was_still_waiting]]]")
                    .asRuntimeException())));

    Spanner testSpanner =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    .setUseMultiplexedSession(true)
                    .setUseMultiplexedSessionForRW(true)
                    .setUseMultiplexedSessionPartitionedOps(true)
                    .setWaitForMinSessionsDuration(Duration.ofSeconds(1))
                    .setFailOnSessionLeak()
                    .build())
            .build()
            .getService();

    DatabaseClientImpl client =
        (DatabaseClientImpl) testSpanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    try (ResultSet resultSet = client.singleUse().executeQuery(STATEMENT)) {
      //noinspection StatementWithEmptyBody
      while (resultSet.next()) {
        // ignore
      }
    }

    List<CreateSessionRequest> createSessionRequests =
        mockSpanner.getRequestsOfType(CreateSessionRequest.class);
    assertEquals(3, createSessionRequests.size());

    List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(1, requests.size());

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());

    testSpanner.close();
  }

  @Test
  public void testRetryWithTheDatabaseNotFoundExceptionWithSessionCreationWaitTime() {
    mockSpanner.setCreateSessionExecutionTime(
        SimulatedExecutionTime.ofExceptions(
            Collections.singletonList(
                Status.NOT_FOUND.withDescription("Database not found.").asRuntimeException())));

    Spanner testSpanner =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    .setUseMultiplexedSession(true)
                    .setUseMultiplexedSessionForRW(true)
                    .setUseMultiplexedSessionPartitionedOps(true)
                    .setWaitForMinSessionsDuration(Duration.ofMillis(200))
                    .setFailOnSessionLeak()
                    .build())
            .build()
            .getService();

    assertThrows(
        SpannerException.class, () -> testSpanner.getDatabaseClient(DatabaseId.of("p", "i", "d")));

    List<CreateSessionRequest> createSessionRequests =
        mockSpanner.getRequestsOfType(CreateSessionRequest.class);
    assertEquals(1, createSessionRequests.size());

    List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(0, requests.size());

    testSpanner.close();
  }

  @Test
  public void testRetryWithNoSessionCreationWaitTime() {
    mockSpanner.setCreateSessionExecutionTime(
        SimulatedExecutionTime.ofExceptions(
            Collections.singletonList(
                Status.DEADLINE_EXCEEDED
                    .withDescription(
                        "CallOptions deadline exceeded after 22.986872393s. "
                            + "Name resolution delay 6.911918521 seconds. [closed=[], "
                            + "open=[[connecting_and_lb_delay=32445014148ns, was_still_waiting]]]")
                    .asRuntimeException())));

    Spanner testSpanner =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    .setUseMultiplexedSession(true)
                    .setUseMultiplexedSessionForRW(true)
                    .setUseMultiplexedSessionPartitionedOps(true)
                    .setFailOnSessionLeak()
                    .build())
            .build()
            .getService();

    DatabaseClientImpl client =
        (DatabaseClientImpl) testSpanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    SpannerException spannerException =
        assertThrows(
            SpannerException.class,
            () -> {
              try (ResultSet resultSet = client.singleUse().executeQuery(STATEMENT)) {
                //noinspection StatementWithEmptyBody
                while (resultSet.next()) {
                  // ignore
                }
              }
            });
    assertEquals(ErrorCode.DEADLINE_EXCEEDED, spannerException.getErrorCode());

    // The CreateSession RPC will be retried, and as the exception is removed by the first call,
    // the second attempt will succeed.
    try (ResultSet resultSet = client.singleUse().executeQuery(STATEMENT)) {
      //noinspection StatementWithEmptyBody
      while (resultSet.next()) {
        // ignore
      }
    }

    List<CreateSessionRequest> createSessionRequests =
        mockSpanner.getRequestsOfType(CreateSessionRequest.class);
    assertEquals(2, createSessionRequests.size());

    List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(1, requests.size());

    testSpanner.close();
  }

  @Test
  public void testRetryWithDelayedInResponseExceedsSessionCreationWaitTime() {
    mockSpanner.setCreateSessionExecutionTime(
        SimulatedExecutionTime.ofMinimumAndRandomTimeAndExceptions(
            150,
            0,
            Arrays.asList(
                Status.DEADLINE_EXCEEDED
                    .withDescription(
                        "CallOptions deadline exceeded after 22.986872393s. "
                            + "Name resolution delay 6.911918521 seconds. [closed=[], "
                            + "open=[[connecting_and_lb_delay=32445014148ns, was_still_waiting]]]")
                    .asRuntimeException(),
                Status.UNAVAILABLE
                    .withDescription(
                        "CallOptions deadline exceeded after 22.986872393s. "
                            + "Name resolution delay 6.911918521 seconds. [closed=[], "
                            + "open=[[connecting_and_lb_delay=32445014148ns, was_still_waiting]]]")
                    .asRuntimeException())));

    Spanner testSpanner =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    .setUseMultiplexedSession(true)
                    .setUseMultiplexedSessionForRW(true)
                    .setUseMultiplexedSessionPartitionedOps(true)
                    .setWaitForMinSessionsDuration(Duration.ofMillis(200))
                    .setFailOnSessionLeak()
                    .build())
            .build()
            .getService();

    SpannerException spannerException =
        assertThrows(
            SpannerException.class,
            () -> {
              DatabaseClientImpl client =
                  (DatabaseClientImpl) testSpanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

              try (ResultSet resultSet = client.singleUse().executeQuery(STATEMENT)) {
                //noinspection StatementWithEmptyBody
                while (resultSet.next()) {
                  // ignore
                }
              }
            });
    assertEquals(ErrorCode.DEADLINE_EXCEEDED, spannerException.getErrorCode());

    List<CreateSessionRequest> createSessionRequests =
        mockSpanner.getRequestsOfType(CreateSessionRequest.class);
    assertEquals(2, createSessionRequests.size());

    List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(0, requests.size());

    testSpanner.close();
  }

  @Test
  public void testRetryWithDelayInExceptionWithInSessionCreationWaitTime() {
    mockSpanner.setCreateSessionExecutionTime(
        SimulatedExecutionTime.ofMinimumAndRandomTimeAndExceptions(
            50,
            0,
            Arrays.asList(
                Status.DEADLINE_EXCEEDED
                    .withDescription(
                        "CallOptions deadline exceeded after 22.986872393s. "
                            + "Name resolution delay 6.911918521 seconds. [closed=[], "
                            + "open=[[connecting_and_lb_delay=32445014148ns, was_still_waiting]]]")
                    .asRuntimeException(),
                Status.DEADLINE_EXCEEDED
                    .withDescription(
                        "CallOptions deadline exceeded after 22.986872393s. "
                            + "Name resolution delay 6.911918521 seconds. [closed=[], "
                            + "open=[[connecting_and_lb_delay=32445014148ns, was_still_waiting]]]")
                    .asRuntimeException())));

    Spanner testSpanner =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    .setUseMultiplexedSession(true)
                    .setUseMultiplexedSessionForRW(true)
                    .setUseMultiplexedSessionPartitionedOps(true)
                    .setWaitForMinSessionsDuration(Duration.ofMillis(200))
                    .setFailOnSessionLeak()
                    .build())
            .build()
            .getService();

    DatabaseClientImpl client =
        (DatabaseClientImpl) testSpanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    try (ResultSet resultSet = client.singleUse().executeQuery(STATEMENT)) {
      //noinspection StatementWithEmptyBody
      while (resultSet.next()) {
        // ignore
      }
    }

    List<CreateSessionRequest> createSessionRequests =
        mockSpanner.getRequestsOfType(CreateSessionRequest.class);
    assertEquals(3, createSessionRequests.size());

    List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(1, requests.size());

    testSpanner.close();
  }

  @Test
  public void testUnimplementedErrorOnCreationIsPropagated() {
    mockSpanner.setCreateSessionExecutionTime(
        SimulatedExecutionTime.ofException(
            Status.UNIMPLEMENTED
                .withDescription("Multiplexed sessions are not implemented")
                .asRuntimeException()));
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    // Get the current session reference. This will block until the CreateSession RPC has failed.
    assertNotNull(client.multiplexedSessionDatabaseClient);
    SpannerException spannerException =
        assertThrows(
            SpannerException.class,
            client.multiplexedSessionDatabaseClient::getCurrentSessionReference);
    assertEquals(ErrorCode.UNIMPLEMENTED, spannerException.getErrorCode());

    spannerException =
        assertThrows(SpannerException.class, () -> client.singleUse().executeQuery(STATEMENT));
    assertEquals(ErrorCode.UNIMPLEMENTED, spannerException.getErrorCode());

    // Verify that we received no ExecuteSqlRequests.
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
  }

  @Test
  public void testWriteAtLeastOnceAborted() {
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    // Force the Commit RPC to return Aborted the first time it is called. The exception is cleared
    // after the first call, so the retry should succeed.
    mockSpanner.setCommitExecutionTime(
        SimulatedExecutionTime.ofException(
            mockSpanner.createAbortedException(ByteString.copyFromUtf8("test"))));
    Timestamp timestamp = MockSpannerTestActions.writeAtLeastOnceInsertMutation(client);
    assertNotNull(timestamp);

    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    assertEquals(2, commitRequests.size());
    for (CommitRequest request : commitRequests) {
      assertTrue(mockSpanner.getSession(request.getSession()).getMultiplexed());
    }

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  @Test
  public void testWriteAtLeastOnce() {
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    Timestamp timestamp = MockSpannerTestActions.writeAtLeastOnceInsertMutation(client);
    assertNotNull(timestamp);

    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    assertThat(commitRequests).hasSize(1);
    CommitRequest commit = commitRequests.get(0);
    assertNotNull(commit.getSingleUseTransaction());
    assertTrue(commit.getSingleUseTransaction().hasReadWrite());
    assertFalse(commit.getSingleUseTransaction().getExcludeTxnFromChangeStreams());
    assertNotNull(commit.getRequestOptions());
    assertEquals(Priority.PRIORITY_UNSPECIFIED, commit.getRequestOptions().getPriority());
    assertTrue(mockSpanner.getSession(commit.getSession()).getMultiplexed());

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  @Test
  public void testWriteAtLeastOnceWithCommitStats() {
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    CommitResponse response =
        client.writeAtLeastOnceWithOptions(
            Collections.singletonList(
                Mutation.newInsertBuilder("FOO").set("ID").to(1L).set("NAME").to("Bar").build()),
            Options.commitStats());
    assertNotNull(response);
    assertNotNull(response.getCommitTimestamp());
    assertNotNull(response.getCommitStats());

    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    assertThat(commitRequests).hasSize(1);
    CommitRequest commit = commitRequests.get(0);
    assertNotNull(commit.getSingleUseTransaction());
    assertTrue(commit.getSingleUseTransaction().hasReadWrite());
    assertFalse(commit.getSingleUseTransaction().getExcludeTxnFromChangeStreams());
    assertNotNull(commit.getRequestOptions());
    assertEquals(Priority.PRIORITY_UNSPECIFIED, commit.getRequestOptions().getPriority());
    assertTrue(mockSpanner.getSession(commit.getSession()).getMultiplexed());

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  @Test
  public void testWriteAtLeastOnceWithOptions() {
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    MockSpannerTestActions.writeAtLeastOnceWithOptionsInsertMutation(
        client, Options.priority(RpcPriority.LOW));

    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    assertThat(commitRequests).hasSize(1);
    CommitRequest commit = commitRequests.get(0);
    assertNotNull(commit.getSingleUseTransaction());
    assertTrue(commit.getSingleUseTransaction().hasReadWrite());
    assertFalse(commit.getSingleUseTransaction().getExcludeTxnFromChangeStreams());
    assertNotNull(commit.getRequestOptions());
    assertEquals(Priority.PRIORITY_LOW, commit.getRequestOptions().getPriority());
    assertTrue(mockSpanner.getSession(commit.getSession()).getMultiplexed());

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  @Test
  public void testWriteAtLeastOnceWithTagOptions() {
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    MockSpannerTestActions.writeAtLeastOnceWithOptionsInsertMutation(
        client, Options.tag("app=spanner,env=test"));

    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    assertThat(commitRequests).hasSize(1);
    CommitRequest commit = commitRequests.get(0);
    assertNotNull(commit.getSingleUseTransaction());
    assertTrue(commit.getSingleUseTransaction().hasReadWrite());
    assertFalse(commit.getSingleUseTransaction().getExcludeTxnFromChangeStreams());
    assertNotNull(commit.getRequestOptions());
    assertThat(commit.getRequestOptions().getTransactionTag()).isEqualTo("app=spanner,env=test");
    assertThat(commit.getRequestOptions().getRequestTag()).isEmpty();
    assertTrue(mockSpanner.getSession(commit.getSession()).getMultiplexed());

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  @Test
  public void testWriteAtLeastOnceWithExcludeTxnFromChangeStreams() {
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    MockSpannerTestActions.writeAtLeastOnceWithOptionsInsertMutation(
        client, Options.excludeTxnFromChangeStreams());

    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    assertThat(commitRequests).hasSize(1);
    CommitRequest commit = commitRequests.get(0);
    assertNotNull(commit.getSingleUseTransaction());
    assertTrue(commit.getSingleUseTransaction().hasReadWrite());
    assertTrue(commit.getSingleUseTransaction().getExcludeTxnFromChangeStreams());
    assertTrue(mockSpanner.getSession(commit.getSession()).getMultiplexed());

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  @Test
  public void testReadWriteTransactionUsingTransactionRunner() {
    // Queries executed within a R/W transaction via TransactionRunner should use a multiplexed
    // session.
    // During a retry (due to an ABORTED error), the transaction should use the same multiplexed
    // session as before, assuming the maintainer hasn't run in the meantime.
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    // Force the Commit RPC to return Aborted the first time it is called. The exception is cleared
    // after the first call, so the retry should succeed.
    mockSpanner.setCommitExecutionTime(
        SimulatedExecutionTime.ofException(
            mockSpanner.createAbortedException(ByteString.copyFromUtf8("test"))));

    client
        .readWriteTransaction()
        .run(
            transaction -> {
              try (ResultSet resultSet = transaction.executeQuery(STATEMENT)) {
                //noinspection StatementWithEmptyBody
                while (resultSet.next()) {
                  // ignore
                }
              }
              return null;
            });

    List<ExecuteSqlRequest> executeSqlRequests =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(2, executeSqlRequests.size());
    assertEquals(executeSqlRequests.get(0).getSession(), executeSqlRequests.get(1).getSession());

    // Verify the requests are executed using multiplexed sessions
    for (ExecuteSqlRequest request : executeSqlRequests) {
      assertTrue(mockSpanner.getSession(request.getSession()).getMultiplexed());
    }

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  @Test
  public void testReadWriteTransactionUsingTransactionManager() {
    // Queries executed within a R/W transaction via TransactionManager should use a multiplexed
    // session.
    // During a retry (due to an ABORTED error), the transaction should use the same multiplexed
    // session as before, assuming the maintainer hasn't run in the meantime.
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    // Force the Commit RPC to return Aborted the first time it is called. The exception is cleared
    // after the first call, so the retry should succeed.
    mockSpanner.setCommitExecutionTime(
        SimulatedExecutionTime.ofException(
            mockSpanner.createAbortedException(ByteString.copyFromUtf8("test"))));

    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin();
      while (true) {
        try {
          try (ResultSet resultSet = transaction.executeQuery(STATEMENT)) {
            //noinspection StatementWithEmptyBody
            while (resultSet.next()) {
              // ignore
            }
          }
          manager.commit();
          assertNotNull(manager.getCommitTimestamp());
          break;
        } catch (AbortedException e) {
          transaction = manager.resetForRetry();
        }
      }
    }

    List<ExecuteSqlRequest> executeSqlRequests =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(2, executeSqlRequests.size());
    assertEquals(executeSqlRequests.get(0).getSession(), executeSqlRequests.get(1).getSession());

    // Verify the requests are executed using multiplexed sessions
    for (ExecuteSqlRequest request : executeSqlRequests) {
      assertTrue(mockSpanner.getSession(request.getSession()).getMultiplexed());
    }

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  @Test
  public void testMutationUsingWrite() {
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    // Force the Commit RPC to return Aborted the first time it is called. The exception is cleared
    // after the first call, so the retry should succeed.
    mockSpanner.setCommitExecutionTime(
        SimulatedExecutionTime.ofException(
            mockSpanner.createAbortedException(ByteString.copyFromUtf8("test"))));
    Timestamp timestamp = MockSpannerTestActions.writeInsertMutation(client);
    assertNotNull(timestamp);

    List<BeginTransactionRequest> beginTransactionRequests =
        mockSpanner.getRequestsOfType(BeginTransactionRequest.class);
    assertEquals(2, beginTransactionRequests.size());
    for (BeginTransactionRequest request : beginTransactionRequests) {
      // Verify that mutation key is set for mutations-only case in read-write transaction.
      assertTrue(request.hasMutationKey());
    }

    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    assertEquals(2, commitRequests.size());
    for (CommitRequest request : commitRequests) {
      assertTrue(mockSpanner.getSession(request.getSession()).getMultiplexed());
      // Verify that the precommit token is set in CommitRequest
      assertTrue(request.hasPrecommitToken());
      assertEquals(
          ByteString.copyFromUtf8("TransactionPrecommitToken"),
          request.getPrecommitToken().getPrecommitToken());
    }

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  @Test
  public void testMutationUsingWriteWithOptions() {
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    CommitResponse response =
        client.writeWithOptions(
            Collections.singletonList(
                Mutation.newInsertBuilder("FOO").set("ID").to(1L).set("NAME").to("Bar").build()),
            Options.tag("app=spanner,env=test"));
    assertNotNull(response);
    assertNotNull(response.getCommitTimestamp());

    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    assertEquals(1L, commitRequests.size());
    CommitRequest commit = commitRequests.get(0);
    assertNotNull(commit.getRequestOptions());
    assertEquals("app=spanner,env=test", commit.getRequestOptions().getTransactionTag());
    assertTrue(mockSpanner.getSession(commit.getSession()).getMultiplexed());

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  @Test
  public void testReadWriteTransactionUsingAsyncTransactionManager() throws Exception {
    // Updates executed within a R/W transaction via AsyncTransactionManager should use a
    // multiplexed session.
    // During a retry (due to an ABORTED error), the transaction should use the same multiplexed
    // session as before, assuming the maintainer hasn't run in the meantime.
    final AtomicInteger attempt = new AtomicInteger();
    CountDownLatch abortedLatch = new CountDownLatch(1);
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    try (AsyncTransactionManager manager = client.transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      while (true) {
        try {
          attempt.incrementAndGet();
          AsyncTransactionStep<Void, Long> updateCount =
              transactionContextFuture.then(
                  (transaction, ignored) -> transaction.executeUpdateAsync(UPDATE_STATEMENT),
                  MoreExecutors.directExecutor());
          updateCount.then(
              (transaction, ignored) -> {
                if (attempt.get() == 1) {
                  mockSpanner.abortTransaction(transaction);
                  abortedLatch.countDown();
                }
                return ApiFutures.immediateFuture(null);
              },
              MoreExecutors.directExecutor());
          abortedLatch.await(10L, TimeUnit.SECONDS);
          CommitTimestampFuture commitTimestamp = updateCount.commitAsync();
          assertEquals(UPDATE_COUNT, updateCount.get().longValue());
          assertNotNull(commitTimestamp.get());
          assertEquals(2L, attempt.get());
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    }

    List<ExecuteSqlRequest> executeSqlRequests =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(2, executeSqlRequests.size());
    assertEquals(executeSqlRequests.get(0).getSession(), executeSqlRequests.get(1).getSession());

    // Verify the requests are executed using multiplexed sessions
    for (ExecuteSqlRequest request : executeSqlRequests) {
      assertTrue(mockSpanner.getSession(request.getSession()).getMultiplexed());
    }

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  @Test
  public void testReadWriteTransactionUsingAsyncRunner() throws Exception {
    // Updates executed within a R/W transaction via AsyncRunner should use a multiplexed
    // session.
    // During a retry (due to an ABORTED error), the transaction should use the same multiplexed
    // session as before, assuming the maintainer hasn't run in the meantime.
    final AtomicInteger attempt = new AtomicInteger();
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    AsyncRunner runner = client.runAsync();
    ApiFuture<Long> updateCount =
        runner.runAsync(
            txn -> {
              ApiFuture<Long> updateCount1 = txn.executeUpdateAsync(UPDATE_STATEMENT);
              if (attempt.incrementAndGet() == 1) {
                mockSpanner.abortTransaction(txn);
              }
              return updateCount1;
            },
            MoreExecutors.directExecutor());
    assertEquals(UPDATE_COUNT, updateCount.get().longValue());
    assertEquals(2L, attempt.get());

    List<ExecuteSqlRequest> executeSqlRequests =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(2L, executeSqlRequests.size());
    assertEquals(executeSqlRequests.get(0).getSession(), executeSqlRequests.get(1).getSession());

    // Verify the requests are executed using multiplexed sessions
    for (ExecuteSqlRequest request : executeSqlRequests) {
      assertTrue(mockSpanner.getSession(request.getSession()).getMultiplexed());
    }

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  @Test
  public void testAsyncRunnerIsNonBlockingWithMultiplexedSession() throws Exception {
    mockSpanner.freeze();
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    AsyncRunner runner = client.runAsync();
    ApiFuture<Void> res =
        runner.runAsync(
            txn -> {
              txn.executeUpdateAsync(UPDATE_STATEMENT);
              return ApiFutures.immediateFuture(null);
            },
            MoreExecutors.directExecutor());
    ApiFuture<Timestamp> ts = runner.getCommitTimestamp();
    mockSpanner.unfreeze();
    assertThat(res.get()).isNull();
    assertThat(ts.get()).isNotNull();

    List<ExecuteSqlRequest> executeSqlRequests =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(1L, executeSqlRequests.size());

    // Verify the requests are executed using multiplexed sessions
    for (ExecuteSqlRequest request : executeSqlRequests) {
      assertTrue(mockSpanner.getSession(request.getSession()).getMultiplexed());
    }

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  @Test
  public void testAbortedReadWriteTxnUsesPreviousTxnIdOnRetryWithInlineBegin() {
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    // Force the Commit RPC to return Aborted the first time it is called. The exception is cleared
    // after the first call, so the retry should succeed.
    mockSpanner.setCommitExecutionTime(
        SimulatedExecutionTime.ofException(
            mockSpanner.createAbortedException(ByteString.copyFromUtf8("test"))));
    TransactionRunner runner = client.readWriteTransaction();
    AtomicReference<ByteString> validTransactionId = new AtomicReference<>();
    runner.run(
        transaction -> {
          try (ResultSet resultSet = transaction.executeQuery(STATEMENT)) {
            while (resultSet.next()) {}
          }

          TransactionContextImpl impl = (TransactionContextImpl) transaction;
          if (validTransactionId.get() == null) {
            // Track the first not-null transactionId. This transaction gets ABORTED during commit
            // operation and gets retried.
            validTransactionId.set(impl.transactionId);
          }
          return null;
        });

    List<ExecuteSqlRequest> executeSqlRequests =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(2, executeSqlRequests.size());

    // Verify the requests are executed using multiplexed sessions
    for (ExecuteSqlRequest request : executeSqlRequests) {
      assertTrue(mockSpanner.getSession(request.getSession()).getMultiplexed());
    }

    // Verify that the first request uses inline begin, and the previous transaction ID is set to
    // ByteString.EMPTY
    assertTrue(executeSqlRequests.get(0).hasTransaction());
    assertTrue(executeSqlRequests.get(0).getTransaction().hasBegin());
    assertTrue(executeSqlRequests.get(0).getTransaction().getBegin().hasReadWrite());
    assertNotNull(
        executeSqlRequests
            .get(0)
            .getTransaction()
            .getBegin()
            .getReadWrite()
            .getMultiplexedSessionPreviousTransactionId());
    assertEquals(
        ByteString.EMPTY,
        executeSqlRequests
            .get(0)
            .getTransaction()
            .getBegin()
            .getReadWrite()
            .getMultiplexedSessionPreviousTransactionId());

    // Verify that the second request uses inline begin, and the previous transaction ID is set
    // appropriately
    assertTrue(executeSqlRequests.get(1).hasTransaction());
    assertTrue(executeSqlRequests.get(1).getTransaction().hasBegin());
    assertTrue(executeSqlRequests.get(1).getTransaction().getBegin().hasReadWrite());
    assertNotNull(
        executeSqlRequests
            .get(1)
            .getTransaction()
            .getBegin()
            .getReadWrite()
            .getMultiplexedSessionPreviousTransactionId());
    assertNotEquals(
        ByteString.EMPTY,
        executeSqlRequests
            .get(1)
            .getTransaction()
            .getBegin()
            .getReadWrite()
            .getMultiplexedSessionPreviousTransactionId());
    assertEquals(
        validTransactionId.get(),
        executeSqlRequests
            .get(1)
            .getTransaction()
            .getBegin()
            .getReadWrite()
            .getMultiplexedSessionPreviousTransactionId());
  }

  @Test
  public void testAbortedReadWriteTxnUsesPreviousTxnIdOnRetryWithExplicitBegin() {
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    // Force the Commit RPC to return Aborted the first time it is called. The exception is cleared
    // after the first call, so the retry should succeed.
    mockSpanner.setCommitExecutionTime(
        SimulatedExecutionTime.ofException(
            mockSpanner.createAbortedException(ByteString.copyFromUtf8("test"))));
    TransactionRunner runner = client.readWriteTransaction();
    AtomicReference<ByteString> validTransactionId = new AtomicReference<>();
    Long updateCount =
        runner.run(
            transaction -> {
              // This update statement carries the BeginTransaction, but fails. This will
              // cause the entire transaction to be retried with an explicit
              // BeginTransaction RPC to ensure all statements in the transaction are
              // actually executed against the same transaction.
              TransactionContextImpl impl = (TransactionContextImpl) transaction;
              if (validTransactionId.get() == null) {
                // Track the first not-null transactionId. This transaction gets ABORTED during
                // commit operation and gets retried.
                validTransactionId.set(impl.transactionId);
              }
              SpannerException e =
                  assertThrows(
                      SpannerException.class,
                      () -> transaction.executeUpdate(INVALID_UPDATE_STATEMENT));
              assertEquals(ErrorCode.INVALID_ARGUMENT, e.getErrorCode());
              return transaction.executeUpdate(UPDATE_STATEMENT);
            });

    assertThat(updateCount).isEqualTo(1L);
    List<BeginTransactionRequest> beginTransactionRequests =
        mockSpanner.getRequestsOfType(BeginTransactionRequest.class);
    assertEquals(2, beginTransactionRequests.size());

    // Verify the requests are executed using multiplexed sessions
    for (BeginTransactionRequest request : beginTransactionRequests) {
      assertTrue(mockSpanner.getSession(request.getSession()).getMultiplexed());
    }

    // Verify that explicit begin transaction is called during retry, and the previous transaction
    // ID is set to ByteString.EMPTY
    assertTrue(beginTransactionRequests.get(0).hasOptions());
    assertTrue(beginTransactionRequests.get(0).getOptions().hasReadWrite());
    assertNotNull(
        beginTransactionRequests
            .get(0)
            .getOptions()
            .getReadWrite()
            .getMultiplexedSessionPreviousTransactionId());
    assertEquals(
        ByteString.EMPTY,
        beginTransactionRequests
            .get(0)
            .getOptions()
            .getReadWrite()
            .getMultiplexedSessionPreviousTransactionId());

    // The previous transaction with id (txn1) fails during commit operation with ABORTED error.
    // Verify that explicit begin transaction is called during retry, and the previous transaction
    // ID is not ByteString.EMPTY (should be set to txn1)
    assertTrue(beginTransactionRequests.get(1).hasOptions());
    assertTrue(beginTransactionRequests.get(1).getOptions().hasReadWrite());
    assertNotNull(
        beginTransactionRequests
            .get(1)
            .getOptions()
            .getReadWrite()
            .getMultiplexedSessionPreviousTransactionId());
    assertNotEquals(
        ByteString.EMPTY,
        beginTransactionRequests
            .get(1)
            .getOptions()
            .getReadWrite()
            .getMultiplexedSessionPreviousTransactionId());
    assertEquals(
        validTransactionId.get(),
        beginTransactionRequests
            .get(1)
            .getOptions()
            .getReadWrite()
            .getMultiplexedSessionPreviousTransactionId());
  }

  @Test
  public void testPrecommitTokenForResultSet() {
    // This test verifies that the precommit token received from the ResultSet is properly tracked
    // and set in the CommitRequest.
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    Long count =
        client
            .readWriteTransaction()
            .run(
                transaction -> {
                  long res = transaction.executeUpdate(UPDATE_STATEMENT);

                  // Verify that the latest precommit token is tracked in the transaction context.
                  TransactionContextImpl impl = (TransactionContextImpl) transaction;
                  assertNotNull(impl.getLatestPrecommitToken());
                  assertEquals(
                      ByteString.copyFromUtf8("ResultSetPrecommitToken"),
                      impl.getLatestPrecommitToken().getPrecommitToken());
                  return res;
                });

    assertNotNull(count);
    assertEquals(1, count.longValue());

    // Verify that the latest precommit token is set in the CommitRequest
    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    assertEquals(1, commitRequests.size());
    assertTrue(mockSpanner.getSession(commitRequests.get(0).getSession()).getMultiplexed());
    assertNotNull(commitRequests.get(0).getPrecommitToken());
    assertEquals(
        ByteString.copyFromUtf8("ResultSetPrecommitToken"),
        commitRequests.get(0).getPrecommitToken().getPrecommitToken());
  }

  @Test
  public void testPrecommitTokenForExecuteBatchDmlResponse() {
    // This test verifies that the precommit token received from the ExecuteBatchDmlResponse is
    // properly tracked and set in the CommitRequest.
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    long[] count =
        client
            .readWriteTransaction()
            .run(
                transaction -> {
                  long[] res = transaction.batchUpdate(Lists.newArrayList(UPDATE_STATEMENT));

                  // Verify that the latest precommit token is tracked in the transaction context.
                  TransactionContextImpl impl = (TransactionContextImpl) transaction;
                  assertNotNull(impl.getLatestPrecommitToken());
                  assertEquals(
                      ByteString.copyFromUtf8("ExecuteBatchDmlResponsePrecommitToken"),
                      impl.getLatestPrecommitToken().getPrecommitToken());
                  return res;
                });

    assertNotNull(count);
    assertEquals(1, count.length);

    // Verify that the latest precommit token is set in the CommitRequest
    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    assertEquals(1, commitRequests.size());
    assertTrue(mockSpanner.getSession(commitRequests.get(0).getSession()).getMultiplexed());
    assertNotNull(commitRequests.get(0).getPrecommitToken());
    assertEquals(
        ByteString.copyFromUtf8("ExecuteBatchDmlResponsePrecommitToken"),
        commitRequests.get(0).getPrecommitToken().getPrecommitToken());
  }

  @Test
  public void testPrecommitTokenForPartialResultSet() {
    // This test verifies that the precommit token received from the PartialResultSet is properly
    // tracked and set in the CommitRequest.
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    client
        .readWriteTransaction()
        .run(
            transaction -> {
              ResultSet resultSet = transaction.executeQuery(STATEMENT);
              //noinspection StatementWithEmptyBody
              while (resultSet.next()) {
                // ignore
              }

              // Verify that the latest precommit token is tracked in the transaction context.
              TransactionContextImpl impl = (TransactionContextImpl) transaction;
              assertNotNull(impl.getLatestPrecommitToken());
              assertEquals(
                  ByteString.copyFromUtf8("PartialResultSetPrecommitToken"),
                  impl.getLatestPrecommitToken().getPrecommitToken());
              return null;
            });

    // Verify that the latest precommit token is set in the CommitRequest
    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    assertEquals(1, commitRequests.size());
    assertTrue(mockSpanner.getSession(commitRequests.get(0).getSession()).getMultiplexed());
    assertNotNull(commitRequests.get(0).getPrecommitToken());
    assertEquals(
        ByteString.copyFromUtf8("PartialResultSetPrecommitToken"),
        commitRequests.get(0).getPrecommitToken().getPrecommitToken());
  }

  @Test
  public void testTxnTracksPrecommitTokenWithLatestSeqNo() {
    // This test ensures that the read-write transaction tracks the precommit token with the
    // highest sequence number and sets it in the CommitRequest.
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    client
        .readWriteTransaction()
        .run(
            transaction -> {
              // Returns a ResultSet containing the precommit token (ResultSetPrecommitToken)
              transaction.executeUpdate(UPDATE_STATEMENT);

              // Returns a PartialResultSet containing the precommit token
              // (PartialResultSetPrecommitToken)
              ResultSet resultSet = transaction.executeQuery(STATEMENT);
              //noinspection StatementWithEmptyBody
              while (resultSet.next()) {
                // ignore
              }

              // Returns an ExecuteBatchDmlResponse containing the precommit token
              // (ExecuteBatchDmlResponsePrecommitToken).
              // Since this is the last request received by the mock Spanner, it should be the most
              // recent precommit token tracked by the transaction context.
              transaction.batchUpdate(Lists.newArrayList(UPDATE_STATEMENT));

              // Verify that the latest precommit token with highest sequence number is tracked in
              // the transaction context.
              TransactionContextImpl impl = (TransactionContextImpl) transaction;
              assertNotNull(impl.getLatestPrecommitToken());
              assertEquals(
                  ByteString.copyFromUtf8("ExecuteBatchDmlResponsePrecommitToken"),
                  impl.getLatestPrecommitToken().getPrecommitToken());
              return null;
            });

    // Verify that the latest precommit token is set in the CommitRequest
    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    assertEquals(1, commitRequests.size());
    assertTrue(mockSpanner.getSession(commitRequests.get(0).getSession()).getMultiplexed());
    assertNotNull(commitRequests.get(0).getPrecommitToken());
    assertEquals(
        ByteString.copyFromUtf8("ExecuteBatchDmlResponsePrecommitToken"),
        commitRequests.get(0).getPrecommitToken().getPrecommitToken());
  }

  @Test
  public void testPrecommitTokenForTransactionResponse() {
    // This test verifies that
    // 1. A random mutation from the list is set in BeginTransactionRequest.
    // 2. The precommit token from the Transaction response is correctly tracked
    // and applied in the CommitRequest. The Transaction response includes a precommit token
    // only when the read-write transaction consists solely of mutations.

    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    client
        .readWriteTransaction()
        .run(
            transaction -> {
              Mutation mutation =
                  Mutation.newInsertBuilder("FOO").set("ID").to(1L).set("NAME").to("Bar").build();
              transaction.buffer(mutation);
              return null;
            });

    // Verify that for mutation only case, a mutation key is set in BeginTransactionRequest.
    List<BeginTransactionRequest> beginTxnRequest =
        mockSpanner.getRequestsOfType(BeginTransactionRequest.class);
    assertEquals(1, beginTxnRequest.size());
    assertTrue(mockSpanner.getSession(beginTxnRequest.get(0).getSession()).getMultiplexed());
    assertTrue(beginTxnRequest.get(0).hasMutationKey());
    assertTrue(beginTxnRequest.get(0).getMutationKey().hasInsert());

    // Verify that the latest precommit token is set in the CommitRequest
    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    assertEquals(1L, commitRequests.size());
    assertTrue(mockSpanner.getSession(commitRequests.get(0).getSession()).getMultiplexed());
    assertNotNull(commitRequests.get(0).getPrecommitToken());
    assertEquals(
        ByteString.copyFromUtf8("TransactionPrecommitToken"),
        commitRequests.get(0).getPrecommitToken().getPrecommitToken());
  }

  @Test
  public void testMutationOnlyCaseAborted() {
    // This test verifies that in the case of mutations-only, when a transaction is retried after an
    // ABORT, the mutation key is correctly set in the BeginTransaction request.
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    // Force the Commit RPC to return Aborted the first time it is called. The exception is cleared
    // after the first call, so the retry should succeed.
    mockSpanner.setCommitExecutionTime(
        SimulatedExecutionTime.ofException(
            mockSpanner.createAbortedException(ByteString.copyFromUtf8("test"))));
    client
        .readWriteTransaction()
        .run(
            transaction -> {
              Mutation mutation =
                  Mutation.newInsertBuilder("FOO").set("ID").to(1L).set("NAME").to("Bar").build();
              transaction.buffer(mutation);
              return null;
            });

    // Verify that for mutation only case, a mutation key is set in BeginTransactionRequest.
    List<BeginTransactionRequest> beginTransactionRequests =
        mockSpanner.getRequestsOfType(BeginTransactionRequest.class);
    assertEquals(2, beginTransactionRequests.size());
    // Verify the requests are executed using multiplexed sessions
    for (BeginTransactionRequest request : beginTransactionRequests) {
      assertTrue(mockSpanner.getSession(request.getSession()).getMultiplexed());
      assertTrue(request.hasMutationKey());
      assertTrue(request.getMutationKey().hasInsert());
    }

    // Verify that the latest precommit token is set in the CommitRequest
    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    assertEquals(2L, commitRequests.size());
    for (CommitRequest request : commitRequests) {
      assertTrue(mockSpanner.getSession(request.getSession()).getMultiplexed());
      assertNotNull(request.getPrecommitToken());
      assertEquals(
          ByteString.copyFromUtf8("TransactionPrecommitToken"),
          request.getPrecommitToken().getPrecommitToken());
    }
  }

  @Test
  public void testMutationOnlyUsingTransactionManager() {
    // Test verifies mutation-only case within a R/W transaction via TransactionManager.
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin();
      while (true) {
        try {
          Mutation mutation =
              Mutation.newInsertBuilder("FOO").set("ID").to(1L).set("NAME").to("Bar").build();
          transaction.buffer(mutation);
          manager.commit();
          assertNotNull(manager.getCommitTimestamp());
          break;
        } catch (AbortedException e) {
          transaction = manager.resetForRetry();
        }
      }
    }

    // Verify that for mutation only case, a mutation key is set in BeginTransactionRequest.
    List<BeginTransactionRequest> beginTransactionRequests =
        mockSpanner.getRequestsOfType(BeginTransactionRequest.class);
    assertThat(beginTransactionRequests).hasSize(1);
    BeginTransactionRequest beginTransaction = beginTransactionRequests.get(0);
    assertTrue(mockSpanner.getSession(beginTransaction.getSession()).getMultiplexed());
    assertTrue(beginTransaction.hasMutationKey());
    assertTrue(beginTransaction.getMutationKey().hasInsert());

    // Verify that the latest precommit token is set in the CommitRequest
    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    assertThat(commitRequests).hasSize(1);
    CommitRequest commitRequest = commitRequests.get(0);
    assertNotNull(commitRequest.getPrecommitToken());
    assertEquals(
        ByteString.copyFromUtf8("TransactionPrecommitToken"),
        commitRequest.getPrecommitToken().getPrecommitToken());
  }

  @Test
  public void testMutationOnlyUsingAsyncRunner() {
    // Test verifies mutation-only case within a R/W transaction via AsyncRunner.
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    MockSpannerTestActions.asyncRunnerCommit(client, MoreExecutors.directExecutor());
    // Verify that the mutation key is set in BeginTransactionRequest
    List<BeginTransactionRequest> beginTransactions =
        mockSpanner.getRequestsOfType(BeginTransactionRequest.class);
    assertThat(beginTransactions).hasSize(1);
    BeginTransactionRequest beginTransaction = beginTransactions.get(0);
    assertTrue(beginTransaction.hasMutationKey());
    assertTrue(beginTransaction.getMutationKey().hasDelete());

    // Verify that the latest precommit token is set in the CommitRequest
    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    assertThat(commitRequests).hasSize(1);
    CommitRequest commitRequest = commitRequests.get(0);
    assertNotNull(commitRequest.getPrecommitToken());
    assertEquals(
        ByteString.copyFromUtf8("TransactionPrecommitToken"),
        commitRequest.getPrecommitToken().getPrecommitToken());
  }

  @Test
  public void testMutationOnlyUsingAsyncTransactionManager() {
    // Test verifies mutation-only case within a R/W transaction via AsyncTransactionManager.
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    MockSpannerTestActions.transactionManagerAsyncCommit(client, MoreExecutors.directExecutor());

    // Verify that the mutation key is set in BeginTransactionRequest
    List<BeginTransactionRequest> beginTransactions =
        mockSpanner.getRequestsOfType(BeginTransactionRequest.class);
    assertThat(beginTransactions).hasSize(1);
    BeginTransactionRequest beginTransaction = beginTransactions.get(0);
    assertTrue(beginTransaction.hasMutationKey());
    assertTrue(beginTransaction.getMutationKey().hasDelete());

    // Verify that the latest precommit token is set in the CommitRequest
    List<CommitRequest> requests = mockSpanner.getRequestsOfType(CommitRequest.class);
    assertThat(requests).hasSize(1);
    CommitRequest request = requests.get(0);
    assertNotNull(request.getPrecommitToken());
    assertEquals(
        ByteString.copyFromUtf8("TransactionPrecommitToken"),
        request.getPrecommitToken().getPrecommitToken());
  }

  private Spanner setupSpannerBySkippingBeginTransactionVerificationForMux() {
    return SpannerOptions.newBuilder()
        .setProjectId("test-project")
        .setChannelProvider(channelProvider)
        .setCredentials(NoCredentials.getInstance())
        .setSessionPoolOption(
            SessionPoolOptions.newBuilder()
                .setUseMultiplexedSession(true)
                .setUseMultiplexedSessionForRW(true)
                .setSkipVerifyingBeginTransactionForMuxRW(true)
                .build())
        .build()
        .getService();
  }

  private void verifyMutationKeySetInBeginTransactionRequests(
      List<BeginTransactionRequest> beginTransactionRequests) {
    assertEquals(2, beginTransactionRequests.size());
    // Verify the requests are executed using multiplexed sessions
    for (BeginTransactionRequest request : beginTransactionRequests) {
      assertTrue(mockSpanner.getSession(request.getSession()).getMultiplexed());
      assertTrue(request.hasMutationKey());
      assertTrue(request.getMutationKey().hasInsert());
    }
  }

  private void verifyPreCommitTokenSetInCommitRequest(List<CommitRequest> commitRequests) {
    assertEquals(1L, commitRequests.size());
    for (CommitRequest request : commitRequests) {
      assertTrue(mockSpanner.getSession(request.getSession()).getMultiplexed());
      assertNotNull(request.getPrecommitToken());
      assertEquals(
          ByteString.copyFromUtf8("TransactionPrecommitToken"),
          request.getPrecommitToken().getPrecommitToken());
    }
  }

  // The following 4 tests validate mutation-only cases where the BeginTransaction RPC fails with an
  // ABORTED or retryable error
  @Test
  public void testMutationOnlyCaseAbortedDuringBeginTransaction() {
    // This test ensures that when a transaction containing only mutations is retried after an
    // ABORT error in the BeginTransaction RPC:
    // 1. The mutation key is correctly included in the BeginTransaction request.
    // 2. The precommit token is properly set in the Commit request.
    Spanner spanner = setupSpannerBySkippingBeginTransactionVerificationForMux();

    // Force the BeginTransaction RPC to return Aborted the first time it is called. The exception
    // is cleared after the first call, so the retry should succeed.
    mockSpanner.setBeginTransactionExecutionTime(
        SimulatedExecutionTime.ofException(
            mockSpanner.createAbortedException(ByteString.copyFromUtf8("test"))));

    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    client
        .readWriteTransaction()
        .run(
            transaction -> {
              Mutation mutation =
                  Mutation.newInsertBuilder("FOO").set("ID").to(1L).set("NAME").to("Bar").build();
              transaction.buffer(mutation);
              return null;
            });

    // Verify that for mutation only case, a mutation key is set in BeginTransactionRequest.
    List<BeginTransactionRequest> beginTransactionRequests =
        mockSpanner.getRequestsOfType(BeginTransactionRequest.class);
    verifyMutationKeySetInBeginTransactionRequests(beginTransactionRequests);

    // Verify that the latest precommit token is set in the CommitRequest
    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    verifyPreCommitTokenSetInCommitRequest(commitRequests);

    spanner.close();
  }

  @Test
  public void testMutationOnlyUsingTransactionManagerAbortedDuringBeginTransaction() {
    // This test ensures that when a transaction containing only mutations is retried after an
    // ABORT error in the BeginTransaction RPC:
    // 1. The mutation key is correctly included in the BeginTransaction request.
    // 2. The precommit token is properly set in the Commit request.
    Spanner spanner = setupSpannerBySkippingBeginTransactionVerificationForMux();

    // Force the BeginTransaction RPC to return Aborted the first time it is called. The exception
    // is cleared after the first call, so the retry should succeed.
    mockSpanner.setBeginTransactionExecutionTime(
        SimulatedExecutionTime.ofException(
            mockSpanner.createAbortedException(ByteString.copyFromUtf8("test"))));

    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin();
      while (true) {
        try {
          Mutation mutation =
              Mutation.newInsertBuilder("FOO").set("ID").to(1L).set("NAME").to("Bar").build();
          transaction.buffer(mutation);
          manager.commit();
          assertNotNull(manager.getCommitTimestamp());
          break;
        } catch (AbortedException e) {
          transaction = manager.resetForRetry();
        }
      }
    }

    // Verify that for mutation only case, a mutation key is set in BeginTransactionRequest.
    List<BeginTransactionRequest> beginTransactionRequests =
        mockSpanner.getRequestsOfType(BeginTransactionRequest.class);
    verifyMutationKeySetInBeginTransactionRequests(beginTransactionRequests);

    // Verify that the latest precommit token is set in the CommitRequest
    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    verifyPreCommitTokenSetInCommitRequest(commitRequests);

    spanner.close();
  }

  @Test
  public void testMutationOnlyUsingAsyncRunnerAbortedDuringBeginTransaction() {
    // This test ensures that when a transaction containing only mutations is retried after an
    // ABORT error in the BeginTransaction RPC:
    // 1. The mutation key is correctly included in the BeginTransaction request.
    // 2. The precommit token is properly set in the Commit request.

    Spanner spanner = setupSpannerBySkippingBeginTransactionVerificationForMux();

    // Force the BeginTransaction RPC to return Aborted the first time it is called. The exception
    // is cleared after the first call, so the retry should succeed.
    mockSpanner.setBeginTransactionExecutionTime(
        SimulatedExecutionTime.ofException(
            mockSpanner.createAbortedException(ByteString.copyFromUtf8("test"))));

    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    AsyncRunner runner = client.runAsync();
    get(
        runner.runAsync(
            txn -> {
              txn.buffer(
                  Mutation.newInsertBuilder("FOO").set("ID").to(1L).set("NAME").to("Bar").build());
              return ApiFutures.immediateFuture(null);
            },
            MoreExecutors.directExecutor()));

    // Verify that for mutation only case, a mutation key is set in BeginTransactionRequest.
    List<BeginTransactionRequest> beginTransactionRequests =
        mockSpanner.getRequestsOfType(BeginTransactionRequest.class);
    verifyMutationKeySetInBeginTransactionRequests(beginTransactionRequests);

    // Verify that the latest precommit token is set in the CommitRequest
    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    verifyPreCommitTokenSetInCommitRequest(commitRequests);

    spanner.close();
  }

  @Test
  public void testMutationOnlyUsingTransactionManagerAsyncAbortedDuringBeginTransaction()
      throws Exception {
    // This test verifies that in the case of mutations-only, when a transaction is retried after an
    // ABORT in BeginTransaction RPC, the mutation key is correctly set in the BeginTransaction
    // request
    // and precommit token is set in Commit request.
    Spanner spanner = setupSpannerBySkippingBeginTransactionVerificationForMux();

    // Force the BeginTransaction RPC to return Aborted the first time it is called. The exception
    // is cleared after the first call, so the retry should succeed.
    mockSpanner.setBeginTransactionExecutionTime(
        SimulatedExecutionTime.ofException(
            mockSpanner.createAbortedException(ByteString.copyFromUtf8("test"))));

    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    try (AsyncTransactionManager manager = client.transactionManagerAsync()) {
      TransactionContextFuture transaction = manager.beginAsync();
      while (true) {
        CommitTimestampFuture commitTimestamp =
            transaction
                .then(
                    (txn, input) -> {
                      txn.buffer(
                          Mutation.newInsertBuilder("FOO")
                              .set("ID")
                              .to(1L)
                              .set("NAME")
                              .to("Bar")
                              .build());
                      return ApiFutures.immediateFuture(null);
                    },
                    MoreExecutors.directExecutor())
                .commitAsync();
        try {
          assertThat(commitTimestamp.get()).isNotNull();
          break;
        } catch (AbortedException e) {
          transaction = manager.resetForRetryAsync();
        }
      }
    }

    // Verify that for mutation only case, a mutation key is set in BeginTransactionRequest.
    List<BeginTransactionRequest> beginTransactionRequests =
        mockSpanner.getRequestsOfType(BeginTransactionRequest.class);
    verifyMutationKeySetInBeginTransactionRequests(beginTransactionRequests);

    // Verify that the latest precommit token is set in the CommitRequest
    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    verifyPreCommitTokenSetInCommitRequest(commitRequests);

    spanner.close();
  }

  @Test
  public void testOtherUnimplementedError_ReadWriteTransactionStillUsesMultiplexedSession() {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofException(
            Status.UNIMPLEMENTED
                .withDescription("Multiplexed sessions are not supported.")
                .asRuntimeException()));

    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    // Try to execute a query using single use transaction.
    try (ResultSet resultSet = client.singleUse().executeQuery(STATEMENT)) {
      SpannerException spannerException = assertThrows(SpannerException.class, resultSet::next);
      assertEquals(ErrorCode.UNIMPLEMENTED, spannerException.getErrorCode());
    }

    // The read-write transaction should use multiplexed sessions and succeed.
    client
        .readWriteTransaction()
        .run(
            transaction -> {
              // Returns a ResultSet containing the precommit token (ResultSetPrecommitToken)
              transaction.executeUpdate(UPDATE_STATEMENT);

              // Verify that a precommit token is received. This guarantees that the read-write
              // transaction was executed on a multiplexed session.
              TransactionContextImpl impl = (TransactionContextImpl) transaction;
              assertNotNull(impl.getLatestPrecommitToken());
              assertEquals(
                  ByteString.copyFromUtf8("ResultSetPrecommitToken"),
                  impl.getLatestPrecommitToken().getPrecommitToken());
              return null;
            });

    // Verify that two ExecuteSqlRequests were received and second one uses a multiplexed session.
    assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);

    Session session2 = mockSpanner.getSession(requests.get(1).getSession());
    assertNotNull(session2);
    assertTrue(session2.getMultiplexed());

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(2L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(2L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  @Test
  public void testReadWriteTransactionWithCommitRetryProtocolExtensionSet() {
    // This test simulates the commit retry protocol extension which occurs when a read-write
    // transaction contains read/query + mutation operations.
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    client
        .readWriteTransaction()
        .run(
            transaction -> {
              try (ResultSet resultSet = transaction.executeQuery(STATEMENT)) {
                //noinspection StatementWithEmptyBody
                while (resultSet.next()) {
                  // ignore
                }
              }

              Mutation mutation =
                  Mutation.newInsertBuilder("FOO").set("ID").to(1L).set("NAME").to("Bar").build();
              transaction.buffer(mutation);

              TransactionContextImpl impl = (TransactionContextImpl) transaction;
              // Force the Commit RPC to return a CommitResponse with MultiplexedSessionRetry field
              // set.
              // This scenario is only possible when a read-write transaction contains read/query +
              // mutation operations.
              mockSpanner.markCommitRetryOnTransaction(impl.transactionId);
              return null;
            });

    List<ExecuteSqlRequest> executeSqlRequests =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(1, executeSqlRequests.size());
    // Verify the request is executed using multiplexed sessions
    assertTrue(mockSpanner.getSession(executeSqlRequests.get(0).getSession()).getMultiplexed());

    List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
    assertEquals(2, commitRequests.size());
    assertNotNull(commitRequests.get(0).getPrecommitToken());
    assertEquals(
        ByteString.copyFromUtf8("PartialResultSetPrecommitToken"),
        commitRequests.get(0).getPrecommitToken().getPrecommitToken());
    // Verify that the first request has mutations set
    assertTrue(commitRequests.get(0).getMutationsCount() > 0);

    // Second CommitRequest should contain the latest precommit token received via the
    // CommitResponse in previous attempt.
    assertNotNull(commitRequests.get(1).getPrecommitToken());
    assertEquals(
        ByteString.copyFromUtf8("CommitResponsePrecommitToken"),
        commitRequests.get(1).getPrecommitToken().getPrecommitToken());
    // Verify that the commit retry request does not have any mutations set
    assertEquals(0, commitRequests.get(1).getMutationsCount());

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  @Test
  public void testBatchWriteAtLeastOnce() {
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    Iterable<MutationGroup> MUTATION_GROUPS =
        ImmutableList.of(
            MutationGroup.of(
                Mutation.newInsertBuilder("FOO1").set("ID").to(1L).set("NAME").to("Bar1").build(),
                Mutation.newInsertBuilder("FOO2").set("ID").to(2L).set("NAME").to("Bar2").build()),
            MutationGroup.of(
                Mutation.newInsertBuilder("FOO3").set("ID").to(3L).set("NAME").to("Bar3").build(),
                Mutation.newInsertBuilder("FOO4").set("ID").to(4L).set("NAME").to("Bar4").build()));

    ServerStream<BatchWriteResponse> responseStream = client.batchWriteAtLeastOnce(MUTATION_GROUPS);
    int idx = 0;
    for (BatchWriteResponse response : responseStream) {
      assertEquals(
          response.getStatus(),
          com.google.rpc.Status.newBuilder().setCode(com.google.rpc.Code.OK_VALUE).build());
      assertEquals(response.getIndexesList(), ImmutableList.of(idx, idx + 1));
      idx += 2;
    }

    assertNotNull(responseStream);
    List<BatchWriteRequest> requests = mockSpanner.getRequestsOfType(BatchWriteRequest.class);
    assertEquals(requests.size(), 1);
    BatchWriteRequest request = requests.get(0);
    assertTrue(mockSpanner.getSession(request.getSession()).getMultiplexed());
    assertEquals(request.getMutationGroupsCount(), 2);
    assertEquals(request.getRequestOptions().getPriority(), Priority.PRIORITY_UNSPECIFIED);
    assertFalse(request.getExcludeTxnFromChangeStreams());

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(1L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  @Test
  public void
      testRWTransactionWithTransactionManager_CommitAborted_SetsTransactionId_AndUsedInNewInstance() {
    // The below test verifies the behaviour of begin(AbortedException) method which is used to
    // maintain transaction priority if resetForRetry() is not called.

    // This test performs the following steps:
    // 1. Simulates an ABORTED exception during commit and verifies that the transaction ID is
    // included in the AbortedException.
    // 2. Passes the ABORTED exception to the begin(AbortedException) method of a new
    // TransactionManager, and verifies that the transaction ID from the failed transaction is sent
    // during the inline begin of the first request.
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    // Force the Commit RPC to return Aborted the first time it is called. The exception is cleared
    // after the first call, so the retry should succeed.
    mockSpanner.setCommitExecutionTime(
        SimulatedExecutionTime.ofException(
            mockSpanner.createAbortedException(ByteString.copyFromUtf8("test"))));

    ByteString abortedTransactionID = null;
    AbortedException exception = null;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin();
      try {
        try (ResultSet resultSet = transaction.executeQuery(STATEMENT)) {
          //noinspection StatementWithEmptyBody
          while (resultSet.next()) {
            // ignore
          }
        }
        manager.commit();
        assertNotNull(manager.getCommitTimestamp());
      } catch (AbortedException e) {
        // The transactionID of the Aborted transaction should be set in AbortedException class.
        assertNotNull(e.getTransactionID());
        abortedTransactionID = e.getTransactionID();
        exception = e;
      }
    }
    // Verify that the transactionID of the aborted transaction is set.
    assertNotNull(abortedTransactionID);
    assertNotNull(exception);
    mockSpanner.clearRequests();

    // Pass AbortedException while invoking begin on the new manager instance.
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin(exception);
      while (true) {
        try {
          try (ResultSet resultSet = transaction.executeQuery(STATEMENT)) {
            //noinspection StatementWithEmptyBody
            while (resultSet.next()) {
              // ignore
            }
          }
          manager.commit();
          assertNotNull(manager.getCommitTimestamp());
          break;
        } catch (AbortedException e) {
          transaction = manager.resetForRetry();
        }
      }
    }

    // Verify that the ExecuteSqlRequest with the inline begin passes the transactionID of the
    // previously aborted transaction.
    List<ExecuteSqlRequest> executeSqlRequests =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(1, executeSqlRequests.size());
    assertTrue(mockSpanner.getSession(executeSqlRequests.get(0).getSession()).getMultiplexed());
    assertNotNull(
        executeSqlRequests
            .get(0)
            .getTransaction()
            .getBegin()
            .getReadWrite()
            .getMultiplexedSessionPreviousTransactionId());
    assertEquals(
        executeSqlRequests
            .get(0)
            .getTransaction()
            .getBegin()
            .getReadWrite()
            .getMultiplexedSessionPreviousTransactionId(),
        abortedTransactionID);

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(2L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(2L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  @Test
  public void
      testRWTransactionWithTransactionManager_ExecuteSQLAborted_SetsTransactionId_AndUsedInNewInstance() {
    // This test performs the following steps:
    // 1. Simulates an ABORTED exception during ExecuteSQL and verifies that the transaction ID is
    // included in the AbortedException.
    // 2. Passes the ABORTED exception to the begin(AbortedException) method of a new
    // TransactionManager, and verifies that the transaction ID from the failed transaction is sent
    // during the inline begin of the first request.
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    ByteString abortedTransactionID = null;
    AbortedException exception = null;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin();
      try {
        try (ResultSet resultSet = transaction.executeQuery(STATEMENT)) {
          //noinspection StatementWithEmptyBody
          while (resultSet.next()) {
            // ignore
          }
        }

        // Simulate an ABORTED in next ExecuteSQL request.
        mockSpanner.setExecuteStreamingSqlExecutionTime(
            SimulatedExecutionTime.ofException(
                mockSpanner.createAbortedException(ByteString.copyFromUtf8("test"))));

        try (ResultSet resultSet = transaction.executeQuery(STATEMENT)) {
          //noinspection StatementWithEmptyBody
          while (resultSet.next()) {
            // ignore
          }
        }
        manager.commit();
        assertNotNull(manager.getCommitTimestamp());
      } catch (AbortedException e) {
        // The transactionID of the Aborted transaction should be set in AbortedException class.
        assertNotNull(e.getTransactionID());
        abortedTransactionID = e.getTransactionID();
        exception = e;
      }
    }
    // Verify that the transactionID of the aborted transaction is set.
    assertNotNull(abortedTransactionID);
    assertNotNull(exception);
    mockSpanner.clearRequests();

    // Pass AbortedException while invoking begin on the new manager instance.
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin(exception);
      while (true) {
        try {
          try (ResultSet resultSet = transaction.executeQuery(STATEMENT)) {
            //noinspection StatementWithEmptyBody
            while (resultSet.next()) {
              // ignore
            }
          }
          manager.commit();
          assertNotNull(manager.getCommitTimestamp());
          break;
        } catch (AbortedException e) {
          transaction = manager.resetForRetry();
        }
      }
    }

    // Verify that the ExecuteSqlRequest with inline begin includes the transaction ID from the
    // previously aborted transaction.
    List<ExecuteSqlRequest> executeSqlRequests =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(1, executeSqlRequests.size());
    assertTrue(mockSpanner.getSession(executeSqlRequests.get(0).getSession()).getMultiplexed());
    assertNotNull(
        executeSqlRequests
            .get(0)
            .getTransaction()
            .getBegin()
            .getReadWrite()
            .getMultiplexedSessionPreviousTransactionId());
    assertEquals(
        executeSqlRequests
            .get(0)
            .getTransaction()
            .getBegin()
            .getReadWrite()
            .getMultiplexedSessionPreviousTransactionId(),
        abortedTransactionID);

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(2L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(2L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  @Test
  public void
      testRWTransactionWithAsyncTransactionManager_CommitAborted_SetsTransactionId_AndUsedInNewInstance()
          throws Exception {
    // This test performs the following steps:
    // 1. Simulates an ABORTED exception during ExecuteSQL and verifies that the transaction ID is
    // included in the AbortedException.
    // 2. Passes the ABORTED exception to the begin(AbortedException) method of a new
    // AsyncTransactionManager, and verifies that the transaction ID from the failed transaction is
    // sent
    // during the inline begin of the first request.
    DatabaseClientImpl client =
        (DatabaseClientImpl) spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
    // Force the Commit RPC to return Aborted the first time it is called. The exception is cleared
    // after the first call, so the retry should succeed.
    mockSpanner.setCommitExecutionTime(
        SimulatedExecutionTime.ofException(
            mockSpanner.createAbortedException(ByteString.copyFromUtf8("test"))));
    ByteString abortedTransactionID = null;
    AbortedException exception = null;
    try (AsyncTransactionManager manager = client.transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync();
      try {
        AsyncTransactionStep<Void, Long> updateCount =
            transactionContextFuture.then(
                (transaction, ignored) -> transaction.executeUpdateAsync(UPDATE_STATEMENT),
                MoreExecutors.directExecutor());
        CommitTimestampFuture commitTimestamp = updateCount.commitAsync();
        assertEquals(UPDATE_COUNT, updateCount.get().longValue());
        assertNotNull(commitTimestamp.get());
      } catch (AbortedException e) {
        assertNotNull(e.getTransactionID());
        exception = e;
        abortedTransactionID = e.getTransactionID();
      }
    }

    // Verify that the transactionID of the aborted transaction is set.
    assertNotNull(abortedTransactionID);
    assertNotNull(exception);
    mockSpanner.clearRequests();

    try (AsyncTransactionManager manager = client.transactionManagerAsync()) {
      TransactionContextFuture transactionContextFuture = manager.beginAsync(exception);
      while (true) {
        try {
          AsyncTransactionStep<Void, Long> updateCount =
              transactionContextFuture.then(
                  (transaction, ignored) -> transaction.executeUpdateAsync(UPDATE_STATEMENT),
                  MoreExecutors.directExecutor());
          CommitTimestampFuture commitTimestamp = updateCount.commitAsync();
          assertEquals(UPDATE_COUNT, updateCount.get().longValue());
          assertNotNull(commitTimestamp.get());
          break;
        } catch (AbortedException e) {
          transactionContextFuture = manager.resetForRetryAsync();
        }
      }
    }

    List<ExecuteSqlRequest> executeSqlRequests =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(1, executeSqlRequests.size());
    assertTrue(mockSpanner.getSession(executeSqlRequests.get(0).getSession()).getMultiplexed());
    assertNotNull(
        executeSqlRequests
            .get(0)
            .getTransaction()
            .getBegin()
            .getReadWrite()
            .getMultiplexedSessionPreviousTransactionId());
    assertEquals(
        executeSqlRequests
            .get(0)
            .getTransaction()
            .getBegin()
            .getReadWrite()
            .getMultiplexedSessionPreviousTransactionId(),
        abortedTransactionID);

    assertNotNull(client.multiplexedSessionDatabaseClient);
    assertEquals(2L, client.multiplexedSessionDatabaseClient.getNumSessionsAcquired().get());
    assertEquals(2L, client.multiplexedSessionDatabaseClient.getNumSessionsReleased().get());
  }

  private void waitForSessionToBeReplaced(DatabaseClientImpl client) {
    assertNotNull(client.multiplexedSessionDatabaseClient);
    SessionReference sessionReference =
        client.multiplexedSessionDatabaseClient.getCurrentSessionReference();
    while (sessionReference
        == client.multiplexedSessionDatabaseClient.getCurrentSessionReference()) {
      Thread.yield();
    }
  }
}
