/*
 * Copyright 2026 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.spi.v1.ChannelPrimerTestRpc;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.Session;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BooleanSupplier;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Verifies that a multiplexed CreateSession that is still in flight when its database client is
 * retired never becomes the prime session of the dynamic channel pool, and that the retired client
 * ignores the late session.
 */
@RunWith(JUnit4.class)
public class DynamicChannelPoolPrimeSessionTest {
  private static final DatabaseId DATABASE_ID =
      DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
  private static final Statement SELECT1 = Statement.of("SELECT 1");
  private static final Duration TIMEOUT = Duration.ofSeconds(15);

  /** A mock Spanner whose CreateSession calls wait for a gate before they are served. */
  private static final class GatedMockSpanner extends MockSpannerServiceImpl {
    final AtomicInteger arrivedCreateSessions = new AtomicInteger();
    volatile CountDownLatch createSessionGate = new CountDownLatch(0);

    @Override
    public void createSession(
        CreateSessionRequest request, StreamObserver<Session> responseObserver) {
      arrivedCreateSessions.incrementAndGet();
      Uninterruptibles.awaitUninterruptibly(createSessionGate);
      super.createSession(request, responseObserver);
    }

    void blockCreateSessions() {
      createSessionGate = new CountDownLatch(1);
    }

    void releaseCreateSessions() {
      createSessionGate.countDown();
    }
  }

  private GatedMockSpanner mockSpanner;
  private Server server;
  private ChannelPrimerTestRpc rpc;
  private SpannerImpl spanner;

  /** A second Spanner that a test creates with its own session pool options, closed after it. */
  private SpannerImpl waitingSpanner;

  private ChannelPrimerTestRpc waitingRpc;

  @Before
  public void startServer() throws Exception {
    mockSpanner = new GatedMockSpanner();
    mockSpanner.setAbortProbability(0.0D);
    mockSpanner.putStatementResult(
        StatementResult.query(SELECT1, MockSpannerTestUtil.SELECT1_RESULTSET));
    server =
        NettyServerBuilder.forAddress(new InetSocketAddress("localhost", 0))
            .addService(mockSpanner)
            .build()
            .start();
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setEnableDirectAccess(false)
            .setHost("http://localhost:" + server.getPort())
            .setCredentials(NoCredentials.getInstance())
            .enableGrpcGcpExtension()
            .enableDynamicChannelPool()
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    // Every multiplexed session is due for a refresh right after its creation, so
                    // a test can trigger the refresh by running the maintainer. The maintainer is
                    // only run explicitly: its scheduled run is minutes away.
                    .setMultiplexedSessionMaintenanceDuration(Duration.ofMillis(1))
                    .build())
            .build();
    rpc = new ChannelPrimerTestRpc(options);
    spanner = new SpannerImpl(rpc, options);
  }

  @After
  public void stopServer() throws Exception {
    mockSpanner.releaseCreateSessions();
    if (waitingSpanner != null && !waitingSpanner.isClosed()) {
      waitingSpanner.close();
    }
    if (!spanner.isClosed()) {
      spanner.close();
    }
    server.shutdown();
    server.awaitTermination();
  }

  /**
   * Creates a second Spanner instance that waits for the given duration for the multiplexed session
   * of every database client, and whose maintainer runs every ten milliseconds once it is started.
   */
  private void createWaitingSpanner(Duration waitForMinSessions) {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setEnableDirectAccess(false)
            .setHost("http://localhost:" + server.getPort())
            .setCredentials(NoCredentials.getInstance())
            .enableGrpcGcpExtension()
            .enableDynamicChannelPool()
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    // A started maintainer refreshes the session almost immediately, so a test can
                    // detect a maintainer that should never have been started.
                    .setMultiplexedSessionMaintenanceDuration(Duration.ofMillis(1))
                    .setMultiplexedSessionMaintenanceLoopFrequency(Duration.ofMillis(10))
                    .setWaitForMinSessionsDuration(waitForMinSessions)
                    .build())
            .build();
    waitingRpc = new ChannelPrimerTestRpc(options);
    waitingSpanner = new SpannerImpl(waitingRpc, options);
  }

  private static void awaitCondition(BooleanSupplier condition) throws InterruptedException {
    long deadline = System.nanoTime() + TIMEOUT.toNanos();
    while (!condition.getAsBoolean()) {
      if (System.nanoTime() > deadline) {
        throw new AssertionError("Condition not met within " + TIMEOUT);
      }
      Thread.sleep(5L);
    }
  }

  private DatabaseClientImpl getDatabaseClient() {
    return (DatabaseClientImpl) spanner.getDatabaseClient(DATABASE_ID);
  }

  private static MultiplexedSessionDatabaseClient multiplexedClient(DatabaseClientImpl client) {
    return client.multiplexedSessionDatabaseClient;
  }

  /** Creates a database client, waits for its multiplexed session, and returns the client. */
  private DatabaseClientImpl createClientWithPrimeSession() throws Exception {
    DatabaseClientImpl client = getDatabaseClient();
    awaitCondition(() -> rpc.getPrimeSessionName() != null);
    String session = multiplexedClient(client).getCurrentSessionReference().getName();
    assertThat(rpc.getPrimeSessionNames()).containsExactly(session);
    return client;
  }

  /** Blocks CreateSession on the server and triggers a refresh of the client's session. */
  private void blockRefreshInFlight(DatabaseClientImpl client) throws Exception {
    int arrivedBefore = mockSpanner.arrivedCreateSessions.get();
    mockSpanner.blockCreateSessions();
    // The session is due for a refresh once its one millisecond maintenance duration has passed.
    Thread.sleep(10L);
    multiplexedClient(client).getMaintainer().maintain();
    awaitCondition(() -> mockSpanner.arrivedCreateSessions.get() == arrivedBefore + 1);
  }

  /** Releases the blocked CreateSession calls and waits until the given number have returned. */
  private void releaseAndAwaitCompleted(int expectedCompleted) throws Exception {
    mockSpanner.releaseCreateSessions();
    awaitCondition(() -> rpc.getCompletedMultiplexedCreateSessions() >= expectedCompleted);
    assertEquals(expectedCompleted, rpc.getCompletedMultiplexedCreateSessions());
  }

  private void invalidate(DatabaseClientImpl client) {
    invalidate(client, DATABASE_ID);
  }

  private void invalidate(DatabaseClientImpl client, DatabaseId databaseId) {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.stickyDatabaseNotFoundException(databaseId.getName()));
    assertThrows(
        DatabaseNotFoundException.class,
        () -> {
          try (ResultSet resultSet = client.singleUse().executeQuery(SELECT1)) {
            resultSet.next();
          }
        });
    mockSpanner.removeAllExecutionTimes();
    assertFalse(client.isValid());
  }

  @Test
  public void refreshInFlightWhenClientIsReplacedNeverBecomesPrimeSession() throws Exception {
    DatabaseClientImpl retired = createClientWithPrimeSession();
    String retiredSession = multiplexedClient(retired).getCurrentSessionReference().getName();
    invalidate(retired);
    blockRefreshInFlight(retired);

    // Getting the client again retires the invalid client and creates its replacement. The
    // replacement's CreateSession is blocked as well and returns together with the refresh.
    DatabaseClientImpl replacement = getDatabaseClient();
    assertNotSame(retired, replacement);
    assertThat(rpc.getPrimeSessionNames()).isEmpty();
    releaseAndAwaitCompleted(3);

    String replacementSession =
        multiplexedClient(replacement).getCurrentSessionReference().getName();
    assertThat(replacementSession).isNotEqualTo(retiredSession);
    // The late refresh of the retired client is dropped, and the replacement stays selected.
    assertThat(rpc.getPrimeSessionNames()).containsExactly(replacementSession);
    assertThat(rpc.getPrimeOwnerDatabases()).containsExactly(DATABASE_ID.getName());
    // The retired client ignored its refreshed session as well.
    assertEquals(retiredSession, multiplexedClient(retired).getCurrentSessionReference().getName());
    assertTrue(replacement.isValid());
  }

  @Test
  public void refreshInFlightWhenSpannerIsClosedNeverBecomesPrimeSession() throws Exception {
    DatabaseClientImpl client = createClientWithPrimeSession();
    String session = multiplexedClient(client).getCurrentSessionReference().getName();
    blockRefreshInFlight(client);
    // The refresh returns right after the database has been unregistered, while the rpc is still
    // open, which is the latest point at which it could re-register the retired session.
    rpc.setAfterUnregisterHook(
        () -> {
          try {
            releaseAndAwaitCompleted(2);
          } catch (Exception e) {
            throw new AssertionError(e);
          }
        });

    spanner.close();

    assertThat(rpc.getPrimeSessionNames()).isEmpty();
    assertThat(rpc.getPrimeOwnerDatabases()).isEmpty();
    assertEquals(session, multiplexedClient(client).getCurrentSessionReference().getName());
  }

  @Test
  public void initialCreateSessionInFlightWhenSpannerIsClosedNeverBecomesPrimeSession()
      throws Exception {
    mockSpanner.blockCreateSessions();
    DatabaseClientImpl client = getDatabaseClient();
    awaitCondition(() -> mockSpanner.arrivedCreateSessions.get() == 1);
    assertThat(rpc.getPrimeSessionNames()).isEmpty();
    rpc.setAfterUnregisterHook(
        () -> {
          try {
            releaseAndAwaitCompleted(1);
          } catch (Exception e) {
            throw new AssertionError(e);
          }
        });

    spanner.close();

    assertThat(rpc.getPrimeSessionNames()).isEmpty();
    assertThat(rpc.getPrimeOwnerDatabases()).isEmpty();
    // The closed client ignored the session that arrived after it was closed.
    SpannerException exception =
        assertThrows(
            SpannerException.class, () -> multiplexedClient(client).getCurrentSessionReference());
    assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
  }

  @Test
  public void churnOfDatabaseClientsLeavesNoPrimeOwnersBehind() throws Exception {
    // A long-lived Spanner instance that churns through many database names must not retain
    // anything for the retired database clients: the registry holds exactly one owner and one
    // session per live database client.
    List<String> liveDatabases = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      DatabaseId databaseId = DatabaseId.of("[PROJECT]", "[INSTANCE]", "churn-" + i);
      liveDatabases.add(databaseId.getName());
      DatabaseClientImpl client = (DatabaseClientImpl) spanner.getDatabaseClient(databaseId);
      String session = multiplexedClient(client).getCurrentSessionReference().getName();
      awaitCondition(() -> rpc.getPrimeSessionNames().contains(session));
      invalidate(client, databaseId);
      // Getting the client again retires it and creates its replacement.
      DatabaseClientImpl replacement = (DatabaseClientImpl) spanner.getDatabaseClient(databaseId);
      assertNotSame(client, replacement);
      String replacementSession =
          multiplexedClient(replacement).getCurrentSessionReference().getName();
      awaitCondition(() -> rpc.getPrimeSessionNames().contains(replacementSession));
      assertThat(rpc.getPrimeSessionNames()).doesNotContain(session);
      assertThat(rpc.getPrimeSessionNames()).hasSize(liveDatabases.size());
      assertThat(rpc.getPrimeOwnerDatabases()).containsExactlyElementsIn(liveDatabases);
    }

    spanner.close();

    assertThat(rpc.getPrimeSessionNames()).isEmpty();
    assertThat(rpc.getPrimeOwnerDatabases()).isEmpty();
  }

  @Test
  public void failedClientConstructionLeavesNoPrimeOwnerBehind() throws Exception {
    // A client that waits for its first multiplexed session throws from its constructor when the
    // CreateSession fails, and is never cached by the Spanner instance, so nothing will ever close
    // it. It must still have released the owner ticket that it registered before the CreateSession.
    createWaitingSpanner(Duration.ofSeconds(5));
    mockSpanner.setCreateSessionExecutionTime(
        SimulatedExecutionTime.ofStickyException(
            Status.PERMISSION_DENIED.withDescription("no access").asRuntimeException()));

    for (int i = 0; i < 5; i++) {
      DatabaseId databaseId = DatabaseId.of("[PROJECT]", "[INSTANCE]", "failing-" + i);
      SpannerException exception =
          assertThrows(SpannerException.class, () -> waitingSpanner.getDatabaseClient(databaseId));
      assertEquals(ErrorCode.PERMISSION_DENIED, exception.getErrorCode());
      assertThat(waitingRpc.getPrimeOwnerDatabases()).isEmpty();
      assertThat(waitingRpc.getPrimeSessionNames()).isEmpty();
    }

    // The maintainer of a client that never finished its construction is not running: it would
    // have refreshed the session within its ten millisecond loop frequency.
    mockSpanner.removeAllExecutionTimes();
    int arrived = mockSpanner.arrivedCreateSessions.get();
    Thread.sleep(200L);
    assertEquals(arrived, mockSpanner.arrivedCreateSessions.get());
  }

  @Test
  public void sessionArrivingAfterFailedClientConstructionNeverBecomesPrimeSession()
      throws Exception {
    // The CreateSession outlives the wait for the first multiplexed session, so the constructor
    // throws while the CreateSession is still in flight. Its late success must not be recorded as
    // a prime session, and must not start the maintainer of a client that does not exist.
    createWaitingSpanner(Duration.ofMillis(200));
    mockSpanner.blockCreateSessions();
    DatabaseId databaseId = DatabaseId.of("[PROJECT]", "[INSTANCE]", "abandoned");

    SpannerException exception =
        assertThrows(SpannerException.class, () -> waitingSpanner.getDatabaseClient(databaseId));
    assertEquals(ErrorCode.DEADLINE_EXCEEDED, exception.getErrorCode());
    // The owner ticket is released as soon as the constructor fails, before the session arrives.
    assertThat(waitingRpc.getPrimeOwnerDatabases()).isEmpty();

    int arrivedBeforeRelease = mockSpanner.arrivedCreateSessions.get();
    mockSpanner.releaseCreateSessions();
    awaitCondition(() -> waitingRpc.getCompletedMultiplexedCreateSessions() >= 1);

    assertThat(waitingRpc.getPrimeSessionNames()).isEmpty();
    assertThat(waitingRpc.getPrimeOwnerDatabases()).isEmpty();
    // No maintainer was started for the abandoned client, so no session is ever refreshed.
    Thread.sleep(200L);
    assertEquals(arrivedBeforeRelease, mockSpanner.arrivedCreateSessions.get());
  }
}
