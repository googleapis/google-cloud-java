/*
 * Copyright 2017 Google LLC
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

import static com.google.cloud.spanner.SpannerMatchers.isSpannerException;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.ReadContext.QueryAnalyzeMode;
import com.google.cloud.spanner.SessionPool.Clock;
import com.google.cloud.spanner.SessionPool.PooledSession;
import com.google.cloud.spanner.TransactionRunner.TransactionCallable;
import com.google.cloud.spanner.TransactionRunnerImpl.TransactionContextImpl;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc.ResultStreamConsumer;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.RollbackRequest;
import io.opencensus.trace.Span;
import io.opencensus.trace.Status;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracing;
import io.opencensus.trace.config.TraceConfig;
import io.opencensus.trace.config.TraceParams;
import io.opencensus.trace.export.SpanData;
import io.opencensus.trace.export.SpanExporter.Handler;
import io.opencensus.trace.samplers.Samplers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/** Tests for SessionPool that mock out the underlying stub. */
@RunWith(Parameterized.class)
public class SessionPoolTest extends BaseSessionPoolTest {
  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Parameter public int minSessions;

  @Mock SpannerImpl client;
  DatabaseId db = DatabaseId.of("projects/p/instances/i/databases/unused");
  SessionPool pool;
  SessionPoolOptions options;

  @Parameters(name = "min sessions = {0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {{0}, {1}});
  }

  private SessionPool createPool() {
    return SessionPool.createPool(options, new TestExecutorFactory(), db, client);
  }

  private SessionPool createPool(Clock clock) {
    return SessionPool.createPool(options, new TestExecutorFactory(), db, client, clock);
  }

  @Before
  public void setUp() throws Exception {
    initMocks(this);
    options =
        SessionPoolOptions.newBuilder()
            .setMinSessions(minSessions)
            .setMaxSessions(2)
            .setBlockIfPoolExhausted()
            .build();
  }

  private void setupMockSessionCreation() {
    when(client.createSession(db))
        .thenAnswer(
            new Answer<Session>() {

              @Override
              public Session answer(InvocationOnMock invocation) throws Throwable {
                return mockSession();
              }
            });
  }

  @Test
  public void sessionCreation() {
    setupMockSessionCreation();
    pool = createPool();
    try (Session session = pool.getReadSession()) {
      assertThat(session).isNotNull();
    }
  }

  @Test
  public void poolClosure() throws Exception {
    setupMockSessionCreation();
    pool = createPool();
    pool.closeAsync().get();
  }

  @Test
  public void poolClosureClosesLeakedSessions() throws Exception {
    SessionImpl mockSession1 = mockSession();
    SessionImpl mockSession2 = mockSession();
    when(client.createSession(db)).thenReturn(mockSession1).thenReturn(mockSession2);
    pool = createPool();
    Session session1 = pool.getReadSession();
    // Leaked sessions
    pool.getReadSession();
    session1.close();
    pool.closeAsync().get();
    verify(mockSession1).close();
    verify(mockSession2).close();
  }

  @Test
  public void poolClosesWhenMaintenanceLoopIsRunning() throws Exception {
    setupMockSessionCreation();
    final FakeClock clock = new FakeClock();
    pool = createPool(clock);
    final AtomicBoolean stop = new AtomicBoolean(false);
    new Thread(
            new Runnable() {

              @Override
              public void run() {
                // Run in a tight loop.
                while (!stop.get()) {
                  runMaintainanceLoop(clock, pool, 1);
                }
              }
            })
        .start();
    pool.closeAsync().get();
    stop.set(true);
  }

  @Test
  public void poolClosureFailsPendingReadWaiters() throws Exception {
    final CountDownLatch insideCreation = new CountDownLatch(1);
    final CountDownLatch releaseCreation = new CountDownLatch(1);
    SessionImpl session1 = mockSession();
    final Session session2 = mockSession();
    when(client.createSession(db))
        .thenReturn(session1)
        .thenAnswer(
            new Answer<Session>() {
              @Override
              public Session answer(InvocationOnMock invocation) throws Throwable {
                insideCreation.countDown();
                releaseCreation.await();
                return session2;
              }
            });
    pool = createPool();
    pool.getReadSession();
    AtomicBoolean failed = new AtomicBoolean(false);
    CountDownLatch latch = new CountDownLatch(1);
    getSessionAsync(latch, failed);
    insideCreation.await();
    pool.closeAsync();
    releaseCreation.countDown();
    latch.await();
    assertThat(failed.get()).isTrue();
  }

  @Test
  public void poolClosureFailsPendingWriteWaiters() throws Exception {
    final CountDownLatch insideCreation = new CountDownLatch(1);
    final CountDownLatch releaseCreation = new CountDownLatch(1);
    SessionImpl session1 = mockSession();
    final Session session2 = mockSession();
    when(client.createSession(db))
        .thenReturn(session1)
        .thenAnswer(
            new Answer<Session>() {
              @Override
              public Session answer(InvocationOnMock invocation) throws Throwable {
                insideCreation.countDown();
                releaseCreation.await();
                return session2;
              }
            });
    pool = createPool();
    pool.getReadSession();
    AtomicBoolean failed = new AtomicBoolean(false);
    CountDownLatch latch = new CountDownLatch(1);
    getReadWriteSessionAsync(latch, failed);
    insideCreation.await();
    pool.closeAsync();
    releaseCreation.countDown();
    latch.await();
    assertThat(failed.get()).isTrue();
  }

  @Test
  public void poolClosesEvenIfCreationFails() throws Exception {
    final CountDownLatch insideCreation = new CountDownLatch(1);
    final CountDownLatch releaseCreation = new CountDownLatch(1);
    when(client.createSession(db))
        .thenAnswer(
            new Answer<Session>() {
              @Override
              public Session answer(InvocationOnMock invocation) throws Throwable {
                insideCreation.countDown();
                releaseCreation.await();
                throw SpannerExceptionFactory.newSpannerException(new RuntimeException());
              }
            });
    pool = createPool();
    AtomicBoolean failed = new AtomicBoolean(false);
    CountDownLatch latch = new CountDownLatch(1);
    getSessionAsync(latch, failed);
    insideCreation.await();
    ListenableFuture<Void> f = pool.closeAsync();
    releaseCreation.countDown();
    f.get();
    assertThat(f.isDone()).isTrue();
  }

  @Test
  public void poolClosesEvenIfPreparationFails() throws Exception {
    SessionImpl session = mockSession();
    when(client.createSession(db)).thenReturn(session);
    final CountDownLatch insidePrepare = new CountDownLatch(1);
    final CountDownLatch releasePrepare = new CountDownLatch(1);
    doAnswer(
            new Answer<Session>() {
              @Override
              public Session answer(InvocationOnMock invocation) throws Throwable {
                insidePrepare.countDown();
                releasePrepare.await();
                throw SpannerExceptionFactory.newSpannerException(new RuntimeException());
              }
            })
        .when(session)
        .prepareReadWriteTransaction();
    pool = createPool();
    AtomicBoolean failed = new AtomicBoolean(false);
    CountDownLatch latch = new CountDownLatch(1);
    getReadWriteSessionAsync(latch, failed);
    insidePrepare.await();
    ListenableFuture<Void> f = pool.closeAsync();
    releasePrepare.countDown();
    f.get();
    assertThat(f.isDone()).isTrue();
  }

  @Test
  public void poolClosureFailsNewRequests() throws Exception {
    SessionImpl session = mockSession();
    when(client.createSession(db)).thenReturn(session);
    pool = createPool();
    pool.getReadSession();
    pool.closeAsync();
    expectedException.expect(IllegalStateException.class);
    pool.getReadSession();
  }

  @Test
  public void atMostMaxSessionsCreated() {
    setupMockSessionCreation();
    AtomicBoolean failed = new AtomicBoolean(false);
    pool = createPool();
    int numSessions = 10;
    final CountDownLatch latch = new CountDownLatch(numSessions);
    for (int i = 0; i < numSessions; i++) {
      getSessionAsync(latch, failed);
    }
    Uninterruptibles.awaitUninterruptibly(latch);
    verify(client, atMost(options.getMaxSessions())).createSession(db);
    assertThat(failed.get()).isFalse();
  }

  @Test
  public void creationExceptionPropagatesToReadSession() {
    when(client.createSession(db))
        .thenThrow(SpannerExceptionFactory.newSpannerException(ErrorCode.INTERNAL, ""));
    pool = createPool();
    expectedException.expect(isSpannerException(ErrorCode.INTERNAL));
    pool.getReadSession();
  }

  @Test
  public void creationExceptionPropagatesToReadWriteSession() {
    when(client.createSession(db))
        .thenThrow(SpannerExceptionFactory.newSpannerException(ErrorCode.INTERNAL, ""));
    pool = createPool();
    expectedException.expect(isSpannerException(ErrorCode.INTERNAL));
    pool.getReadWriteSession();
  }

  @Test
  public void prepareExceptionPropagatesToReadWriteSession() {
    SessionImpl session = mockSession();
    when(client.createSession(db)).thenReturn(session);
    doThrow(SpannerExceptionFactory.newSpannerException(ErrorCode.INTERNAL, ""))
        .when(session)
        .prepareReadWriteTransaction();
    pool = createPool();
    expectedException.expect(isSpannerException(ErrorCode.INTERNAL));
    pool.getReadWriteSession();
  }

  @Test
  public void getReadWriteSession() {
    SessionImpl mockSession = mockSession();
    when(client.createSession(db)).thenReturn(mockSession);
    pool = createPool();
    try (Session session = pool.getReadWriteSession()) {
      assertThat(session).isNotNull();
      verify(mockSession).prepareReadWriteTransaction();
    }
  }

  @Test
  public void getMultipleReadWriteSessions() {
    SessionImpl mockSession1 = mockSession();
    SessionImpl mockSession2 = mockSession();
    when(client.createSession(db)).thenReturn(mockSession1).thenReturn(mockSession2);
    pool = createPool();
    Session session1 = pool.getReadWriteSession();
    Session session2 = pool.getReadWriteSession();
    verify(mockSession1).prepareReadWriteTransaction();
    verify(mockSession2).prepareReadWriteTransaction();
    session1.close();
    session2.close();
  }

  @Test
  public void getMultipleConcurrentReadWriteSessions() {
    AtomicBoolean failed = new AtomicBoolean(false);
    SessionImpl session = mockSession();
    when(client.createSession(db)).thenReturn(session);
    pool = createPool();
    int numSessions = 5;
    final CountDownLatch latch = new CountDownLatch(numSessions);
    for (int i = 0; i < numSessions; i++) {
      getReadWriteSessionAsync(latch, failed);
    }
    Uninterruptibles.awaitUninterruptibly(latch);
  }

  @Test
  public void sessionIsPrePrepared() {
    SessionImpl mockSession1 = mockSession();
    SessionImpl mockSession2 = mockSession();
    final CountDownLatch prepareLatch = new CountDownLatch(1);
    doAnswer(
            new Answer<Void>() {

              @Override
              public Void answer(InvocationOnMock arg0) throws Throwable {
                prepareLatch.countDown();
                return null;
              }
            })
        .when(mockSession1)
        .prepareReadWriteTransaction();
    doAnswer(
            new Answer<Void>() {

              @Override
              public Void answer(InvocationOnMock arg0) throws Throwable {
                prepareLatch.countDown();
                return null;
              }
            })
        .when(mockSession2)
        .prepareReadWriteTransaction();
    when(client.createSession(db)).thenReturn(mockSession1).thenReturn(mockSession2);

    options =
        SessionPoolOptions.newBuilder()
            .setMinSessions(2)
            .setMaxSessions(2)
            .setWriteSessionsFraction(0.5f)
            .build();
    pool = createPool();
    // One of the sessions would be pre prepared.
    Uninterruptibles.awaitUninterruptibly(prepareLatch);
    PooledSession readSession = pool.getReadSession();
    PooledSession writeSession = pool.getReadWriteSession();
    verify(writeSession.delegate, times(1)).prepareReadWriteTransaction();
    verify(readSession.delegate, never()).prepareReadWriteTransaction();
    readSession.close();
    writeSession.close();
  }

  @Test
  public void getReadSessionFallsBackToWritePreparedSession() throws Exception {
    SessionImpl mockSession1 = mockSession();
    final CountDownLatch prepareLatch = new CountDownLatch(2);
    doAnswer(
            new Answer<Void>() {
              @Override
              public Void answer(InvocationOnMock arg0) throws Throwable {
                prepareLatch.countDown();
                return null;
              }
            })
        .when(mockSession1)
        .prepareReadWriteTransaction();
    when(client.createSession(db)).thenReturn(mockSession1);
    options =
        SessionPoolOptions.newBuilder()
            .setMinSessions(minSessions)
            .setMaxSessions(1)
            .setWriteSessionsFraction(1.0f)
            .build();
    pool = createPool();
    pool.getReadWriteSession().close();
    prepareLatch.await();
    // This session should also be write prepared.
    PooledSession readSession = pool.getReadSession();
    verify(readSession.delegate, times(2)).prepareReadWriteTransaction();
  }

  @Test
  public void failOnPoolExhaustion() {
    options =
        SessionPoolOptions.newBuilder()
            .setMinSessions(1)
            .setMaxSessions(1)
            .setFailIfPoolExhausted()
            .build();
    SessionImpl mockSession = mockSession();
    when(client.createSession(db)).thenReturn(mockSession);
    pool = createPool();
    Session session1 = pool.getReadSession();
    expectedException.expect(isSpannerException(ErrorCode.RESOURCE_EXHAUSTED));
    pool.getReadSession();
    session1.close();
    session1 = pool.getReadSession();
    assertThat(session1).isNotNull();
    session1.close();
  }

  @Test
  public void poolWorksWhenSessionNotFound() {
    SessionImpl mockSession1 = mockSession();
    SessionImpl mockSession2 = mockSession();
    doThrow(SpannerExceptionFactory.newSpannerException(ErrorCode.NOT_FOUND, "Session not found"))
        .when(mockSession1)
        .prepareReadWriteTransaction();
    when(client.createSession(db)).thenReturn(mockSession1).thenReturn(mockSession2);
    pool = createPool();
    assertThat(pool.getReadWriteSession().delegate).isEqualTo(mockSession2);
  }

  @Test
  public void idleSessionCleanup() throws Exception {
    options =
        SessionPoolOptions.newBuilder()
            .setMinSessions(1)
            .setMaxSessions(3)
            .setMaxIdleSessions(0)
            .build();
    SessionImpl session1 = mockSession();
    SessionImpl session2 = mockSession();
    SessionImpl session3 = mockSession();
    final AtomicInteger numSessionClosed = new AtomicInteger();
    when(client.createSession(db)).thenReturn(session1).thenReturn(session2).thenReturn(session3);
    for (Session session : new Session[] {session1, session2, session3}) {
      doAnswer(
              new Answer<Void>() {

                @Override
                public Void answer(InvocationOnMock invocation) throws Throwable {
                  numSessionClosed.incrementAndGet();
                  return null;
                }
              })
          .when(session)
          .close();
    }
    FakeClock clock = new FakeClock();
    clock.currentTimeMillis = System.currentTimeMillis();
    pool = createPool(clock);
    // Make sure pool has been initialized
    pool.getReadSession().close();
    runMaintainanceLoop(clock, pool, pool.poolMaintainer.numClosureCycles);
    assertThat(numSessionClosed.get()).isEqualTo(0);
    Session readSession1 = pool.getReadSession();
    Session readSession2 = pool.getReadSession();
    Session readSession3 = pool.getReadSession();
    readSession1.close();
    readSession2.close();
    readSession3.close();
    // Now there are 3 sessions in the pool but since all were used in parallel, we will not close
    // any.
    runMaintainanceLoop(clock, pool, pool.poolMaintainer.numClosureCycles);
    assertThat(numSessionClosed.get()).isEqualTo(0);
    // Counters have now been reset
    // Use all 3 sessions sequentially
    pool.getReadSession().close();
    pool.getReadSession().close();
    pool.getReadSession().close();
    runMaintainanceLoop(clock, pool, pool.poolMaintainer.numClosureCycles);
    // We will still close 2 sessions since at any point in time only 1 session was in use.
    assertThat(numSessionClosed.get()).isEqualTo(2);
    pool.closeAsync().get();
  }

  @Test
  public void keepAlive() throws Exception {
    options = SessionPoolOptions.newBuilder().setMinSessions(2).setMaxSessions(3).build();
    SessionImpl session = mockSession();
    mockKeepAlive(session);
    // This is cheating as we are returning the same session each but it makes the verification
    // easier.
    when(client.createSession(db)).thenReturn(session);
    FakeClock clock = new FakeClock();
    clock.currentTimeMillis = System.currentTimeMillis();
    pool = createPool(clock);
    Session session1 = pool.getReadSession();
    Session session2 = pool.getReadSession();
    session1.close();
    session2.close();
    runMaintainanceLoop(clock, pool, pool.poolMaintainer.numKeepAliveCycles);
    verify(session, never()).singleUse(any(TimestampBound.class));
    runMaintainanceLoop(clock, pool, pool.poolMaintainer.numKeepAliveCycles);
    verify(session, times(2)).singleUse(any(TimestampBound.class));
    clock.currentTimeMillis += clock.currentTimeMillis + 35 * 60 * 1000;
    session1 = pool.getReadSession();
    session1.writeAtLeastOnce(new ArrayList<Mutation>());
    session1.close();
    runMaintainanceLoop(clock, pool, pool.poolMaintainer.numKeepAliveCycles);
    verify(session, times(3)).singleUse(any(TimestampBound.class));
    pool.closeAsync().get();
  }

  @Test
  public void blockAndTimeoutOnPoolExhaustion() throws InterruptedException, ExecutionException {
    if (minSessions != 0) {
      // Only execute for minSessions == 0 as we need to setup and shutdown a mock sampler during
      // the test case. A second run would not work as there is no way to restart the sampler.
      return;
    }
    // Setup a dummy trace handler.
    final AtomicInteger deadlineExceededCount = new AtomicInteger();
    Handler handler =
        new Handler() {
          @Override
          public void export(Collection<SpanData> spanDataList) {
            for (SpanData sd : spanDataList) {
              if (sd.getStatus() == Status.DEADLINE_EXCEEDED
                  && sd.getName().equals(SessionPool.WAIT_FOR_SESSION)) {
                deadlineExceededCount.incrementAndGet();
              }
            }
          }
        };
    Tracing.getExportComponent()
        .getSpanExporter()
        .registerHandler(SessionPoolTest.class.getName(), handler);
    TraceConfig traceConfig = Tracing.getTraceConfig();
    TraceParams activeTraceParams = traceConfig.getActiveTraceParams();
    traceConfig.updateActiveTraceParams(
        activeTraceParams.toBuilder().setSampler(Samplers.alwaysSample()).build());
    // Create a session pool with max 1 session and a low timeout for waiting for a session.
    options =
        SessionPoolOptions.newBuilder()
            .setMinSessions(minSessions)
            .setMaxSessions(1)
            .setInitialWaitForSessionTimeoutMillis(40L)
            .build();
    SessionImpl mockSession = mockSession();
    when(client.createSession(db)).thenReturn(mockSession);
    pool = createPool();

    Tracer tracer = Tracing.getTracer();
    Span span = tracer.spanBuilder("RunTest").startSpan();
    // Try to take a read or a read/write session. These requests should block.
    for (Boolean write : new Boolean[] {true, false}) {
      // Take the only session that can be in the pool.
      Session checkedOutSession = pool.getReadSession();
      final Boolean finWrite = write;
      ExecutorService executor = Executors.newFixedThreadPool(1);
      Future<Void> fut =
          executor.submit(
              new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                  Session session;
                  if (finWrite) {
                    session = pool.getReadWriteSession();
                  } else {
                    session = pool.getReadSession();
                  }
                  session.close();
                  return null;
                }
              });
      try {
        fut.get(80L, TimeUnit.MILLISECONDS);
        fail("missing expected timeout exception");
      } catch (TimeoutException e) {
        // This is the expected exception, just ignore it.
      } finally {
        // Return the checked out session to the pool so the async request will get a session and
        // finish.
        checkedOutSession.close();
        fut.get();
        executor.shutdown();
      }
    }
    Session session = pool.getReadSession();
    assertThat(session).isNotNull();
    session.close();
    span.end();
    Tracing.getExportComponent().shutdown();
    // Verify that we got a DEADLINE_EXCEEDED span for both read and read/write session.
    // There might be more than 1 for each request, depending on the execution speed of
    // the environment.
    if (!isNoopExportComponent()) {
      assertThat(deadlineExceededCount.get()).isAtLeast(2);
    }
  }

  private boolean isNoopExportComponent() {
    return Tracing.getExportComponent().getClass().getName().contains("Noop");
  }

  @Test
  public void testSessionNotFoundSingleUse() {
    Statement statement = Statement.of("SELECT 1");
    SessionImpl closedSession = mockSession();
    ReadContext closedContext = mock(ReadContext.class);
    ResultSet closedResultSet = mock(ResultSet.class);
    when(closedResultSet.next())
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(ErrorCode.NOT_FOUND, "Session not found"));
    when(closedContext.executeQuery(statement)).thenReturn(closedResultSet);
    when(closedSession.singleUse()).thenReturn(closedContext);

    SessionImpl openSession = mockSession();
    ReadContext openContext = mock(ReadContext.class);
    ResultSet openResultSet = mock(ResultSet.class);
    when(openResultSet.next()).thenReturn(true, false);
    when(openContext.executeQuery(statement)).thenReturn(openResultSet);
    when(openSession.singleUse()).thenReturn(openContext);

    when(client.createSession(db)).thenReturn(closedSession, openSession);
    FakeClock clock = new FakeClock();
    clock.currentTimeMillis = System.currentTimeMillis();
    pool = createPool(clock);
    ReadContext context = pool.getReadSession().singleUse();
    ResultSet resultSet = context.executeQuery(statement);
    assertThat(resultSet.next()).isTrue();
  }

  @Test
  public void testSessionNotFoundReadOnlyTransaction() {
    Statement statement = Statement.of("SELECT 1");
    SessionImpl closedSession = mockSession();
    when(closedSession.readOnlyTransaction())
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(ErrorCode.NOT_FOUND, "Session not found"));

    SessionImpl openSession = mockSession();
    ReadOnlyTransaction openTransaction = mock(ReadOnlyTransaction.class);
    ResultSet openResultSet = mock(ResultSet.class);
    when(openResultSet.next()).thenReturn(true, false);
    when(openTransaction.executeQuery(statement)).thenReturn(openResultSet);
    when(openSession.readOnlyTransaction()).thenReturn(openTransaction);

    when(client.createSession(db)).thenReturn(closedSession, openSession);
    FakeClock clock = new FakeClock();
    clock.currentTimeMillis = System.currentTimeMillis();
    pool = createPool(clock);
    ReadOnlyTransaction transaction = pool.getReadSession().readOnlyTransaction();
    ResultSet resultSet = transaction.executeQuery(statement);
    assertThat(resultSet.next()).isTrue();
  }

  private enum ReadWriteTransactionTestStatementType {
    QUERY,
    ANALYZE,
    UPDATE,
    BATCH_UPDATE,
    WRITE,
    EXCEPTION;
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testSessionNotFoundReadWriteTransaction() {
    final Statement queryStatement = Statement.of("SELECT 1");
    final Statement updateStatement = Statement.of("UPDATE FOO SET BAR=1 WHERE ID=2");
    final SpannerException sessionNotFound =
        SpannerExceptionFactory.newSpannerException(ErrorCode.NOT_FOUND, "Session not found");
    for (ReadWriteTransactionTestStatementType statementType :
        ReadWriteTransactionTestStatementType.values()) {
      final ReadWriteTransactionTestStatementType executeStatementType = statementType;
      for (boolean prepared : new boolean[] {true, false}) {
        final boolean hasPreparedTransaction = prepared;
        SpannerRpc.StreamingCall closedStreamingCall = mock(SpannerRpc.StreamingCall.class);
        doThrow(sessionNotFound).when(closedStreamingCall).request(Mockito.anyInt());
        SpannerRpc rpc = mock(SpannerRpc.class);
        when(rpc.executeQuery(
                any(ExecuteSqlRequest.class), any(ResultStreamConsumer.class), any(Map.class)))
            .thenReturn(closedStreamingCall);
        when(rpc.executeQuery(any(ExecuteSqlRequest.class), any(Map.class)))
            .thenThrow(sessionNotFound);
        when(rpc.executeBatchDml(any(ExecuteBatchDmlRequest.class), any(Map.class)))
            .thenThrow(sessionNotFound);
        when(rpc.commit(any(CommitRequest.class), any(Map.class))).thenThrow(sessionNotFound);
        doThrow(sessionNotFound).when(rpc).rollback(any(RollbackRequest.class), any(Map.class));
        SessionImpl closedSession = mock(SessionImpl.class);
        when(closedSession.getName())
            .thenReturn("projects/dummy/instances/dummy/database/dummy/sessions/session-closed");
        ByteString preparedTransactionId =
            hasPreparedTransaction ? ByteString.copyFromUtf8("test-txn") : null;
        final TransactionContextImpl closedTransactionContext =
            new TransactionContextImpl(closedSession, preparedTransactionId, rpc, 10);
        when(closedSession.newTransaction()).thenReturn(closedTransactionContext);
        when(closedSession.beginTransaction()).thenThrow(sessionNotFound);
        TransactionRunnerImpl closedTransactionRunner =
            new TransactionRunnerImpl(closedSession, rpc, 10);
        when(closedSession.readWriteTransaction()).thenReturn(closedTransactionRunner);

        SessionImpl openSession = mock(SessionImpl.class);
        when(openSession.getName())
            .thenReturn("projects/dummy/instances/dummy/database/dummy/sessions/session-open");
        final TransactionContextImpl openTransactionContext = mock(TransactionContextImpl.class);
        when(openSession.newTransaction()).thenReturn(openTransactionContext);
        when(openSession.beginTransaction()).thenReturn(ByteString.copyFromUtf8("open-txn"));
        TransactionRunnerImpl openTransactionRunner =
            new TransactionRunnerImpl(openSession, mock(SpannerRpc.class), 10);
        when(openSession.readWriteTransaction()).thenReturn(openTransactionRunner);

        ResultSet openResultSet = mock(ResultSet.class);
        when(openResultSet.next()).thenReturn(true, false);
        ResultSet planResultSet = mock(ResultSet.class);
        when(planResultSet.getStats()).thenReturn(ResultSetStats.getDefaultInstance());
        when(openTransactionContext.executeQuery(queryStatement)).thenReturn(openResultSet);
        when(openTransactionContext.analyzeQuery(queryStatement, QueryAnalyzeMode.PLAN))
            .thenReturn(planResultSet);
        when(openTransactionContext.executeUpdate(updateStatement)).thenReturn(1L);
        when(openTransactionContext.batchUpdate(Arrays.asList(updateStatement, updateStatement)))
            .thenReturn(new long[] {1L, 1L});

        when(client.createSession(db)).thenReturn(closedSession, openSession);
        FakeClock clock = new FakeClock();
        clock.currentTimeMillis = System.currentTimeMillis();
        SessionPoolOptions options =
            SessionPoolOptions.newBuilder()
                .setMinSessions(0) // The pool should not auto-create any sessions
                .setMaxSessions(2)
                .setBlockIfPoolExhausted()
                .build();
        SessionPool pool =
            SessionPool.createPool(options, new TestExecutorFactory(), db, client, clock);
        TransactionRunner runner = pool.getReadWriteSession().readWriteTransaction();
        try {
          runner.run(
              new TransactionCallable<Integer>() {
                private int callNumber = 0;

                @Override
                public Integer run(TransactionContext transaction) throws Exception {
                  callNumber++;
                  if (hasPreparedTransaction) {
                    // If the session had a prepared read/write transaction, that transaction will
                    // be given to the runner in the first place and the SessionNotFoundException
                    // will occur on the first query / update statement.
                    if (callNumber == 1) {
                      assertThat(transaction).isEqualTo(closedTransactionContext);
                    } else {
                      assertThat(transaction).isEqualTo(openTransactionContext);
                    }
                  } else {
                    // If the session did not have a prepared read/write transaction, the library
                    // tried to create a new transaction before handing it to the transaction
                    // runner.
                    // The creation of the new transaction failed with a SessionNotFoundException,
                    // and the session was re-created before the run method was called.
                    assertThat(transaction).isEqualTo(openTransactionContext);
                  }
                  switch (executeStatementType) {
                    case QUERY:
                      ResultSet resultSet = transaction.executeQuery(queryStatement);
                      assertThat(resultSet.next()).isTrue();
                      break;
                    case ANALYZE:
                      ResultSet planResultSet =
                          transaction.analyzeQuery(queryStatement, QueryAnalyzeMode.PLAN);
                      assertThat(planResultSet.next()).isFalse();
                      assertThat(planResultSet.getStats()).isNotNull();
                      break;
                    case UPDATE:
                      long updateCount = transaction.executeUpdate(updateStatement);
                      assertThat(updateCount).isEqualTo(1L);
                      break;
                    case BATCH_UPDATE:
                      long[] updateCounts =
                          transaction.batchUpdate(Arrays.asList(updateStatement, updateStatement));
                      assertThat(updateCounts).isEqualTo(new long[] {1L, 1L});
                      break;
                    case WRITE:
                      transaction.buffer(Mutation.delete("FOO", Key.of(1L)));
                      break;
                    case EXCEPTION:
                      throw new RuntimeException("rollback at call " + callNumber);
                    default:
                      fail("Unknown statement type: " + executeStatementType);
                  }
                  return callNumber;
                }
              });
        } catch (Exception e) {
          // The rollback will also cause a SessionNotFoundException, but this is caught, logged and
          // further ignored by the library, meaning that the session will not be re-created for
          // retry. Hence rollback at call 1.
          assertThat(
                  executeStatementType == ReadWriteTransactionTestStatementType.EXCEPTION
                      && e.getMessage().contains("rollback at call 1"))
              .isTrue();
        }
      }
    }
  }

  @Test
  public void testSessionNotFoundOnPrepareTransaction() {
    final SpannerException sessionNotFound =
        SpannerExceptionFactory.newSpannerException(ErrorCode.NOT_FOUND, "Session not found");
    SessionImpl closedSession = mock(SessionImpl.class);
    when(closedSession.getName())
        .thenReturn("projects/dummy/instances/dummy/database/dummy/sessions/session-closed");
    when(closedSession.beginTransaction()).thenThrow(sessionNotFound);
    doThrow(sessionNotFound).when(closedSession).prepareReadWriteTransaction();

    SessionImpl openSession = mock(SessionImpl.class);
    when(openSession.getName())
        .thenReturn("projects/dummy/instances/dummy/database/dummy/sessions/session-open");

    when(client.createSession(db)).thenReturn(closedSession, openSession);
    FakeClock clock = new FakeClock();
    clock.currentTimeMillis = System.currentTimeMillis();
    pool = createPool(clock);
    PooledSession session = pool.getReadWriteSession();
    assertThat(session.delegate).isEqualTo(openSession);
  }

  @Test
  public void testSessionNotFoundWrite() {
    SpannerException sessionNotFound =
        SpannerExceptionFactory.newSpannerException(ErrorCode.NOT_FOUND, "Session not found");
    List<Mutation> mutations = Arrays.asList(Mutation.newInsertBuilder("FOO").build());
    SessionImpl closedSession = mockSession();
    when(closedSession.write(mutations)).thenThrow(sessionNotFound);

    SessionImpl openSession = mockSession();
    when(openSession.write(mutations)).thenReturn(Timestamp.now());

    when(client.createSession(db)).thenReturn(closedSession, openSession);
    FakeClock clock = new FakeClock();
    clock.currentTimeMillis = System.currentTimeMillis();
    pool = createPool(clock);
    DatabaseClientImpl impl = new DatabaseClientImpl(pool);
    assertThat(impl.write(mutations)).isNotNull();
  }

  @Test
  public void testSessionNotFoundWriteAtLeastOnce() {
    SpannerException sessionNotFound =
        SpannerExceptionFactory.newSpannerException(ErrorCode.NOT_FOUND, "Session not found");
    List<Mutation> mutations = Arrays.asList(Mutation.newInsertBuilder("FOO").build());
    SessionImpl closedSession = mockSession();
    when(closedSession.writeAtLeastOnce(mutations)).thenThrow(sessionNotFound);

    SessionImpl openSession = mockSession();
    when(openSession.writeAtLeastOnce(mutations)).thenReturn(Timestamp.now());

    when(client.createSession(db)).thenReturn(closedSession, openSession);
    FakeClock clock = new FakeClock();
    clock.currentTimeMillis = System.currentTimeMillis();
    pool = createPool(clock);
    DatabaseClientImpl impl = new DatabaseClientImpl(pool);
    assertThat(impl.writeAtLeastOnce(mutations)).isNotNull();
  }

  @Test
  public void testSessionNotFoundPartitionedUpdate() {
    SpannerException sessionNotFound =
        SpannerExceptionFactory.newSpannerException(ErrorCode.NOT_FOUND, "Session not found");
    Statement statement = Statement.of("UPDATE FOO SET BAR=1 WHERE 1=1");
    SessionImpl closedSession = mockSession();
    when(closedSession.executePartitionedUpdate(statement)).thenThrow(sessionNotFound);

    SessionImpl openSession = mockSession();
    when(openSession.executePartitionedUpdate(statement)).thenReturn(1L);

    when(client.createSession(db)).thenReturn(closedSession, openSession);
    FakeClock clock = new FakeClock();
    clock.currentTimeMillis = System.currentTimeMillis();
    pool = createPool(clock);
    DatabaseClientImpl impl = new DatabaseClientImpl(pool);
    assertThat(impl.executePartitionedUpdate(statement)).isEqualTo(1L);
  }

  private void mockKeepAlive(Session session) {
    ReadContext context = mock(ReadContext.class);
    ResultSet resultSet = mock(ResultSet.class);
    when(session.singleUse(any(TimestampBound.class))).thenReturn(context);
    when(context.executeQuery(any(Statement.class))).thenReturn(resultSet);
  }

  private void getSessionAsync(final CountDownLatch latch, final AtomicBoolean failed) {
    new Thread(
            new Runnable() {
              @Override
              public void run() {
                try (Session session = pool.getReadSession()) {
                  failed.compareAndSet(false, session == null);
                  Uninterruptibles.sleepUninterruptibly(10, TimeUnit.MILLISECONDS);
                } catch (SpannerException e) {
                  failed.compareAndSet(false, true);
                } finally {
                  latch.countDown();
                }
              }
            })
        .start();
  }

  private void getReadWriteSessionAsync(final CountDownLatch latch, final AtomicBoolean failed) {
    new Thread(
            new Runnable() {
              @Override
              public void run() {
                try (Session session = pool.getReadWriteSession()) {
                  failed.compareAndSet(false, session == null);
                  Uninterruptibles.sleepUninterruptibly(2, TimeUnit.MILLISECONDS);
                } catch (SpannerException e) {
                  failed.compareAndSet(false, true);
                } finally {
                  latch.countDown();
                }
              }
            })
        .start();
  }
}
