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

import com.google.cloud.spanner.SessionPool.Clock;
import com.google.cloud.spanner.SessionPool.PooledSession;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
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
    Session mockSession1 = mockSession();
    Session mockSession2 = mockSession();
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
    Session session1 = mockSession();
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
    Session session1 = mockSession();
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
    Session session = mockSession();
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
    Session session = mockSession();
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
    Session session = mockSession();
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
    Session mockSession = mockSession();
    when(client.createSession(db)).thenReturn(mockSession);
    pool = createPool();
    try (Session session = pool.getReadWriteSession()) {
      assertThat(session).isNotNull();
      verify(mockSession).prepareReadWriteTransaction();
    }
  }

  @Test
  public void getMultipleReadWriteSessions() {
    Session mockSession1 = mockSession();
    Session mockSession2 = mockSession();
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
    Session session = mockSession();
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
    Session mockSession1 = mockSession();
    Session mockSession2 = mockSession();
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
    PooledSession readSession = (PooledSession) pool.getReadSession();
    PooledSession writeSession = (PooledSession) pool.getReadWriteSession();
    verify(writeSession.delegate, times(1)).prepareReadWriteTransaction();
    verify(readSession.delegate, never()).prepareReadWriteTransaction();
    readSession.close();
    writeSession.close();
  }

  @Test
  public void getReadSessionFallsBackToWritePreparedSession() throws Exception {
    Session mockSession1 = mockSession();
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
    PooledSession readSession = (PooledSession) pool.getReadSession();
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
    Session mockSession = mockSession();
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
    Session mockSession1 = mockSession();
    Session mockSession2 = mockSession();
    doThrow(SpannerExceptionFactory.newSpannerException(ErrorCode.NOT_FOUND, "Session not found"))
        .when(mockSession1)
        .prepareReadWriteTransaction();
    when(client.createSession(db)).thenReturn(mockSession1).thenReturn(mockSession2);
    pool = createPool();
    assertThat(((PooledSession) pool.getReadWriteSession()).delegate).isEqualTo(mockSession2);
  }

  @Test
  public void idleSessionCleanup() throws Exception {
    options =
        SessionPoolOptions.newBuilder()
            .setMinSessions(1)
            .setMaxSessions(3)
            .setMaxIdleSessions(0)
            .build();
    Session session1 = mockSession();
    Session session2 = mockSession();
    Session session3 = mockSession();
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
    Session session = mockSession();
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
