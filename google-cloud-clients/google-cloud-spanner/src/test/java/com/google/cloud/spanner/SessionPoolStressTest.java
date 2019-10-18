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

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.cloud.spanner.SessionClient.SessionConsumer;
import com.google.cloud.spanner.SessionPool.SessionConsumerImpl;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * Stress test for {@code SessionPool} which does multiple operations on the pool, making some of
 * them fail and asserts that all the invariants are maintained.
 */
@RunWith(Parameterized.class)
public class SessionPoolStressTest extends BaseSessionPoolTest {
  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Parameter(0)
  public double writeSessionsFraction;

  @Parameter(1)
  public boolean shouldBlock;

  DatabaseId db = DatabaseId.of("projects/p/instances/i/databases/unused");
  SessionPool pool;
  SessionPoolOptions options;
  Object lock = new Object();
  Random random = new Random();
  FakeClock clock = new FakeClock();

  Map<String, Boolean> sessions = new HashMap<>();
  // Exception keeps track of where the session was closed at.
  Map<String, Exception> closedSessions = new HashMap<>();
  Set<String> expiredSessions = new HashSet<>();
  SpannerImpl mockSpanner;
  SpannerOptions spannerOptions;
  int maxAliveSessions;
  int minSessionsWhenSessionClosed = Integer.MAX_VALUE;
  Exception e;

  @Parameters(name = "write fraction = {0}, should block = {1}")
  public static Collection<Object[]> data() {
    List<Object[]> params = new ArrayList<>();
    for (double writeFraction = 0; writeFraction <= 1; writeFraction += 0.5) {
      params.add(new Object[] {writeFraction, true});
      params.add(new Object[] {writeFraction, false});
    }
    return params;
  }

  private void setupSpanner(DatabaseId db) {
    mockSpanner = mock(SpannerImpl.class);
    spannerOptions = mock(SpannerOptions.class);
    when(spannerOptions.getNumChannels()).thenReturn(4);
    SessionClient sessionClient = mock(SessionClient.class);
    when(mockSpanner.getSessionClient(db)).thenReturn(sessionClient);
    when(mockSpanner.getOptions()).thenReturn(spannerOptions);
    when(sessionClient.createSession())
        .thenAnswer(
            new Answer<Session>() {

              @Override
              public Session answer(InvocationOnMock invocation) throws Throwable {
                synchronized (lock) {
                  Session session = mockSession();
                  setupSession(session);

                  sessions.put(session.getName(), false);
                  if (sessions.size() > maxAliveSessions) {
                    maxAliveSessions = sessions.size();
                  }
                  return session;
                }
              }
            });
    doAnswer(
            new Answer<Void>() {
              @Override
              public Void answer(InvocationOnMock invocation) throws Throwable {
                int sessionCount = invocation.getArgumentAt(0, Integer.class);
                for (int s = 0; s < sessionCount; s++) {
                  synchronized (lock) {
                    SessionImpl session = mockSession();
                    setupSession(session);

                    sessions.put(session.getName(), false);
                    if (sessions.size() > maxAliveSessions) {
                      maxAliveSessions = sessions.size();
                    }
                    SessionConsumerImpl consumer =
                        invocation.getArgumentAt(1, SessionConsumerImpl.class);
                    consumer.onSessionReady(session);
                  }
                }
                return null;
              }
            })
        .when(sessionClient)
        .asyncBatchCreateSessions(Mockito.anyInt(), Mockito.any(SessionConsumer.class));
  }

  private void setupSession(final Session session) {
    ReadContext mockContext = mock(ReadContext.class);
    final ResultSet mockResult = mock(ResultSet.class);
    when(session.singleUse(any(TimestampBound.class))).thenReturn(mockContext);
    when(mockContext.executeQuery(any(Statement.class)))
        .thenAnswer(
            new Answer<ResultSet>() {

              @Override
              public ResultSet answer(InvocationOnMock invocation) throws Throwable {
                resetTransaction(session);
                return mockResult;
              }
            });
    when(mockResult.next()).thenReturn(true);
    doAnswer(
            new Answer<Void>() {

              @Override
              public Void answer(InvocationOnMock invocation) throws Throwable {
                synchronized (lock) {
                  if (expiredSessions.contains(session.getName())) {
                    throw SpannerExceptionFactory.newSpannerException(
                        ErrorCode.NOT_FOUND, "Session not found");
                  }
                  if (sessions.remove(session.getName()) == null) {
                    setFailed(closedSessions.get(session.getName()));
                  }
                  closedSessions.put(session.getName(), new Exception("Session closed at:"));
                  if (sessions.size() < minSessionsWhenSessionClosed) {
                    minSessionsWhenSessionClosed = sessions.size();
                  }
                }
                return null;
              }
            })
        .when(session)
        .close();

    doAnswer(
            new Answer<Void>() {
              @Override
              public Void answer(InvocationOnMock invocation) throws Throwable {
                if (random.nextInt(100) < 10) {
                  expireSession(session);
                  throw SpannerExceptionFactory.newSpannerException(
                      ErrorCode.NOT_FOUND, "Session not found");
                }
                synchronized (lock) {
                  if (sessions.put(session.getName(), true)) {
                    setFailed();
                  }
                }
                return null;
              }
            })
        .when(session)
        .prepareReadWriteTransaction();
  }

  private void expireSession(Session session) {
    synchronized (lock) {
      sessions.remove(session.getName());
      expiredSessions.add(session.getName());
    }
  }

  private void assertWritePrepared(Session session) {
    synchronized (lock) {
      if (!sessions.get(session.getName())) {
        setFailed();
      }
    }
  }

  private void resetTransaction(Session session) {
    synchronized (lock) {
      sessions.put(session.getName(), false);
    }
  }

  private void setFailed(Exception cause) {
    e = new Exception(cause);
  }

  private void setFailed() {
    e = new Exception();
  }

  private Exception getFailedError() {
    synchronized (lock) {
      return e;
    }
  }

  @Test
  public void stressTest() throws Exception {
    int concurrentThreads = 10;
    final int numOperationsPerThread = 1000;
    final CountDownLatch releaseThreads = new CountDownLatch(1);
    final CountDownLatch threadsDone = new CountDownLatch(concurrentThreads);
    final int writeOperationFraction = 5;
    setupSpanner(db);
    int minSessions = 2;
    int maxSessions = concurrentThreads / 2;
    float writeSessionsFraction = 0.5f;
    SessionPoolOptions.Builder builder =
        SessionPoolOptions.newBuilder()
            .setMinSessions(minSessions)
            .setMaxSessions(maxSessions)
            .setWriteSessionsFraction(writeSessionsFraction);
    if (shouldBlock) {
      builder.setBlockIfPoolExhausted();
    } else {
      builder.setFailIfPoolExhausted();
    }
    pool =
        SessionPool.createPool(
            builder.build(), new TestExecutorFactory(), mockSpanner.getSessionClient(db), clock);
    for (int i = 0; i < concurrentThreads; i++) {
      new Thread(
              new Runnable() {

                @Override
                public void run() {
                  Uninterruptibles.awaitUninterruptibly(releaseThreads);
                  for (int j = 0; j < numOperationsPerThread; j++) {
                    try {
                      Session session = null;
                      if (random.nextInt(10) < writeOperationFraction) {
                        session = pool.getReadWriteSession();
                        assertWritePrepared(session);
                      } else {
                        session = pool.getReadSession();
                      }
                      Uninterruptibles.sleepUninterruptibly(
                          random.nextInt(5), TimeUnit.MILLISECONDS);
                      resetTransaction(session);
                      session.close();
                    } catch (SpannerException e) {
                      if (e.getErrorCode() != ErrorCode.RESOURCE_EXHAUSTED || shouldBlock) {
                        setFailed(e);
                      }
                    } catch (Exception e) {
                      setFailed(e);
                    }
                  }
                  threadsDone.countDown();
                }
              })
          .start();
    }
    // Start maintenance threads in tight loop
    final AtomicBoolean stopMaintenance = new AtomicBoolean(false);
    new Thread(
            new Runnable() {

              @Override
              public void run() {
                while (!stopMaintenance.get()) {
                  runMaintainanceLoop(clock, pool, 1);
                }
              }
            })
        .start();
    releaseThreads.countDown();
    threadsDone.await();
    synchronized (lock) {
      assertThat(maxAliveSessions).isAtMost(maxSessions);
    }
    stopMaintenance.set(true);
    pool.closeAsync().get();
    Exception e = getFailedError();
    if (e != null) {
      throw e;
    }
  }
}
