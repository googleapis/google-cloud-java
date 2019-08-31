/*
 * Copyright 2019 Google LLC
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
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.core.NanoClock;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.grpc.GrpcTransportOptions.ExecutorFactory;
import com.google.cloud.spanner.SessionClient.SessionEnumeration;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

@RunWith(Parameterized.class)
public class SessionClientTest {
  @Parameters(name = "NumChannels = {0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {{1}, {2}, {4}, {8}});
  }

  @Parameter public int numChannels;

  private final String dbName = "projects/p1/instances/i1/databases/d1";
  @Mock private SpannerImpl spanner;
  @Mock private SpannerRpc rpc;
  @Mock private SpannerOptions spannerOptions;
  @Captor ArgumentCaptor<Map<SpannerRpc.Option, Object>> options;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    GrpcTransportOptions transportOptions = mock(GrpcTransportOptions.class);
    when(transportOptions.getExecutorFactory())
        .thenReturn(
            new ExecutorFactory<ScheduledExecutorService>() {
              @Override
              public void release(ScheduledExecutorService executor) {
                executor.shutdown();
              }

              @Override
              public ScheduledExecutorService get() {
                return new ScheduledThreadPoolExecutor(2);
              }
            });
    when(spannerOptions.getTransportOptions()).thenReturn(transportOptions);
    when(spannerOptions.getNumChannels()).thenReturn(numChannels);
    when(spannerOptions.getPrefetchChunks()).thenReturn(1);
    when(spannerOptions.getRetrySettings()).thenReturn(RetrySettings.newBuilder().build());
    when(spannerOptions.getClock()).thenReturn(NanoClock.getDefaultClock());
    when(spanner.getOptions()).thenReturn(spannerOptions);
    when(spanner.getRpc()).thenReturn(rpc);
  }

  @Test
  public void testSessionEnumerationNoExceptions() {
    SessionImpl session1 = mock(SessionImpl.class);
    SessionEnumeration sessions = new SessionEnumeration(2);
    assertThat(sessions.hasMoreElements()).isTrue();
    sessions.put(session1);
    assertThat(sessions.hasMoreElements()).isTrue();
    assertThat(sessions.nextElement()).isEqualTo(session1);
    assertThat(sessions.hasMoreElements()).isTrue();
    sessions.put(mock(SessionImpl.class));
    assertThat(sessions.nextElement()).isNotNull();
    assertThat(sessions.hasMoreElements()).isFalse();
  }

  @Test
  public void testSessionEnumerationExceptionAtEnd() {
    SessionImpl session1 = mock(SessionImpl.class);
    SessionEnumeration sessions = new SessionEnumeration(2);
    sessions.put(session1);
    sessions.registerException(
        SpannerExceptionFactory.newSpannerException(
            ErrorCode.RESOURCE_EXHAUSTED, "no more sessions"),
        1);
    assertThat(sessions.hasMoreElements()).isTrue();
    assertThat(sessions.nextElement()).isEqualTo(session1);
    assertThat(sessions.hasMoreElements()).isTrue();
    try {
      sessions.nextElement();
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.RESOURCE_EXHAUSTED);
    }
    assertThat(sessions.hasMoreElements()).isFalse();
  }

  @Test
  public void testSessionEnumerationExceptionAtBegin() {
    SessionImpl session1 = mock(SessionImpl.class);
    SessionEnumeration sessions = new SessionEnumeration(2);
    sessions.registerException(
        SpannerExceptionFactory.newSpannerException(
            ErrorCode.RESOURCE_EXHAUSTED, "no more sessions"),
        1);
    sessions.put(session1);
    assertThat(sessions.hasMoreElements()).isTrue();
    assertThat(sessions.nextElement()).isEqualTo(session1);
    assertThat(sessions.hasMoreElements()).isTrue();
    try {
      sessions.nextElement();
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.RESOURCE_EXHAUSTED);
    }
    assertThat(sessions.hasMoreElements()).isFalse();
  }

  @Test
  public void testSessionEnumerationExceptionAllExceptions() {
    SessionEnumeration sessions = new SessionEnumeration(2);
    sessions.registerException(
        SpannerExceptionFactory.newSpannerException(
            ErrorCode.RESOURCE_EXHAUSTED, "no more sessions"),
        1);
    sessions.registerException(
        SpannerExceptionFactory.newSpannerException(
            ErrorCode.RESOURCE_EXHAUSTED, "no more sessions"),
        1);
    assertThat(sessions.hasMoreElements()).isTrue();
    try {
      sessions.nextElement();
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.RESOURCE_EXHAUSTED);
    }
    assertThat(sessions.hasMoreElements()).isFalse();
  }

  @Test(expected = NoSuchElementException.class)
  public void testSessionEnumerationNoSuchElement() {
    SessionImpl session = mock(SessionImpl.class);
    SessionEnumeration sessions = new SessionEnumeration(1);
    // Note that hasMoreElements() will return true even though nothing has been added to the
    // enumeration yet, as the enumeration is still guaranteed to return at least one element or an
    // error.
    assertThat(sessions.hasMoreElements()).isTrue();
    sessions.put(session);
    sessions.nextElement();
    assertThat(sessions.hasMoreElements()).isFalse();
    sessions.nextElement();
  }

  @Test
  public void testSessionEnumerationExceptionForMulipleSessions() {
    SessionImpl session = mock(SessionImpl.class);
    SessionEnumeration sessions = new SessionEnumeration(4);
    // Exception for the creation of the first two sessions.
    sessions.registerException(
        SpannerExceptionFactory.newSpannerException(
            ErrorCode.RESOURCE_EXHAUSTED, "no more sessions"),
        2);
    sessions.put(session);
    sessions.put(session);
    assertThat(sessions.hasMoreElements()).isTrue();
    assertThat(sessions.nextElement()).isEqualTo(session);
    assertThat(sessions.hasMoreElements()).isTrue();
    assertThat(sessions.nextElement()).isEqualTo(session);
    assertThat(sessions.hasMoreElements()).isTrue();
    try {
      sessions.nextElement();
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.RESOURCE_EXHAUSTED);
    }
    assertThat(sessions.hasMoreElements()).isFalse();
  }

  @Test
  public void createAndCloseSession() {
    DatabaseId db = DatabaseId.of(dbName);
    String sessionName = dbName + "/sessions/s1";
    Map<String, String> labels = new HashMap<>();
    labels.put("env", "dev");
    when(spannerOptions.getSessionLabels()).thenReturn(labels);
    com.google.spanner.v1.Session sessionProto =
        com.google.spanner.v1.Session.newBuilder()
            .setName(sessionName)
            .putAllLabels(labels)
            .build();
    when(rpc.createSession(Mockito.eq(dbName), Mockito.eq(labels), options.capture()))
        .thenReturn(sessionProto);

    try (SessionClient client = new SessionClient(spanner, db)) {
      Session session = client.createSession();
      assertThat(session.getName()).isEqualTo(sessionName);

      session.close();
      // The same channelHint is passed for deleteSession (contained in "options").
      Mockito.verify(rpc).deleteSession(sessionName, options.getValue());
    }
  }

  @SuppressWarnings("unchecked")
  @Test
  public void batchCreateAndCloseSessions() {
    DatabaseId db = DatabaseId.of(dbName);
    final String sessionName = dbName + "/sessions/s%d";
    final Map<String, String> labels = new HashMap<>();
    labels.put("env", "dev");
    when(spannerOptions.getSessionLabels()).thenReturn(labels);
    final List<Long> usedChannels = Collections.synchronizedList(new ArrayList<Long>());
    when(rpc.batchCreateSessions(
            Mockito.eq(dbName), Mockito.anyInt(), Mockito.eq(labels), Mockito.anyMap()))
        .then(
            new Answer<List<com.google.spanner.v1.Session>>() {
              @Override
              public List<com.google.spanner.v1.Session> answer(InvocationOnMock invocation)
                  throws Throwable {
                Map<SpannerRpc.Option, Object> options = invocation.getArgumentAt(3, Map.class);
                Long channelHint = (Long) options.get(SpannerRpc.Option.CHANNEL_HINT);
                usedChannels.add(channelHint);
                int sessionCount = invocation.getArgumentAt(1, Integer.class);
                List<com.google.spanner.v1.Session> res = new ArrayList<>();
                for (int i = 1; i <= sessionCount; i++) {
                  res.add(
                      com.google.spanner.v1.Session.newBuilder()
                          .setName(String.format(sessionName, i))
                          .putAllLabels(labels)
                          .build());
                }
                return res;
              }
            });

    final int numSessions = 10;
    try (SessionClient client = new SessionClient(spanner, db)) {
      Enumeration<SessionImpl> sessions = client.batchCreateSessions(numSessions);
      int count = 0;
      while (sessions.hasMoreElements()) {
        SessionImpl session = sessions.nextElement();
        assertThat(session.getName()).startsWith(dbName + "/sessions/s");
        count++;
        session.close();
      }
      assertThat(count).isEqualTo(numSessions);
      assertThat(usedChannels.size()).isEqualTo(spannerOptions.getNumChannels());
      List<Long> expectedChannels = new ArrayList<>();
      for (long l = 0; l < spannerOptions.getNumChannels(); l++) {
        expectedChannels.add(l);
      }
      assertThat(usedChannels).containsExactlyElementsIn(expectedChannels);
    }
  }

  private enum AddRemoveSetException {
    SET,
    ADD,
    REMOVE;
  }

  @SuppressWarnings("unchecked")
  @Test
  public void batchCreateSessionsWithExceptions() {
    for (AddRemoveSetException behavior : AddRemoveSetException.values()) {
      final List<Long> errorOnChannels = new ArrayList<>();
      if (behavior == AddRemoveSetException.REMOVE) {
        for (int c = 0; c < spannerOptions.getNumChannels(); c++) {
          errorOnChannels.add(Long.valueOf(c));
        }
      }
      for (int errorOnChannel = 0;
          errorOnChannel < spannerOptions.getNumChannels();
          errorOnChannel++) {
        switch (behavior) {
          case SET:
            errorOnChannels.clear();
          case ADD:
            errorOnChannels.add(Long.valueOf(errorOnChannel));
            break;
          case REMOVE:
            errorOnChannels.remove(Long.valueOf(errorOnChannel));
            break;
          default:
            throw new IllegalStateException();
        }
        DatabaseId db = DatabaseId.of(dbName);
        final String sessionName = dbName + "/sessions/s%d";
        when(rpc.batchCreateSessions(
                Mockito.eq(dbName), Mockito.anyInt(), Mockito.anyMap(), Mockito.anyMap()))
            .then(
                new Answer<List<com.google.spanner.v1.Session>>() {
                  @Override
                  public List<com.google.spanner.v1.Session> answer(InvocationOnMock invocation)
                      throws Throwable {
                    Map<SpannerRpc.Option, Object> options = invocation.getArgumentAt(3, Map.class);
                    Long channelHint = (Long) options.get(SpannerRpc.Option.CHANNEL_HINT);
                    if (errorOnChannels.contains(channelHint)) {
                      throw SpannerExceptionFactory.newSpannerException(
                          ErrorCode.RESOURCE_EXHAUSTED, "could not create any more sessions");
                    } else {
                      int sessionCount = invocation.getArgumentAt(1, Integer.class);
                      List<com.google.spanner.v1.Session> res = new ArrayList<>();
                      for (int i = 1; i <= sessionCount; i++) {
                        res.add(
                            com.google.spanner.v1.Session.newBuilder()
                                .setName(String.format(sessionName, i))
                                .build());
                      }
                      return res;
                    }
                  }
                });

        final int numSessions = 10;
        try (SessionClient client = new SessionClient(spanner, db)) {
          Enumeration<SessionImpl> sessions = client.batchCreateSessions(numSessions);
          int count = 0;
          SpannerException gotException = null;
          while (sessions.hasMoreElements()) {
            // The exception should always be the last that is returned.
            assertThat(gotException == null);
            try {
              SessionImpl session = sessions.nextElement();
              assertThat(session.getName()).startsWith(dbName + "/sessions/s");
              count++;
              session.close();
            } catch (SpannerException e) {
              gotException = e;
            }
          }
          if (errorOnChannels.isEmpty()) {
            assertThat(gotException).isNull();
          } else {
            assertThat(gotException).isNotNull();
            assertThat(gotException.getErrorCode()).isEqualTo(ErrorCode.RESOURCE_EXHAUSTED);
          }
          assertThat(count)
              .isAtLeast(
                  numSessions
                      - (int) Math.ceil((float) numSessions / spannerOptions.getNumChannels())
                          * errorOnChannels.size());
        }
      }
    }
  }

  @SuppressWarnings("unchecked")
  @Test
  public void batchCreateSessionsServerReturnsLessSessionsPerBatch() {
    final int MAX_SESSIONS_PER_BATCH = 5;
    DatabaseId db = DatabaseId.of(dbName);
    final String sessionName = dbName + "/sessions/s%d";
    when(rpc.batchCreateSessions(
            Mockito.eq(dbName), Mockito.anyInt(), Mockito.anyMap(), Mockito.anyMap()))
        .then(
            new Answer<List<com.google.spanner.v1.Session>>() {
              @Override
              public List<com.google.spanner.v1.Session> answer(InvocationOnMock invocation)
                  throws Throwable {
                int sessionCount = invocation.getArgumentAt(1, Integer.class);
                List<com.google.spanner.v1.Session> res = new ArrayList<>();
                for (int i = 1; i <= Math.min(MAX_SESSIONS_PER_BATCH, sessionCount); i++) {
                  res.add(
                      com.google.spanner.v1.Session.newBuilder()
                          .setName(String.format(sessionName, i))
                          .build());
                }
                return res;
              }
            });

    // We want 100 sessions, but each rpc will only return 5. We should still get 100 sessions from
    // the enumerator.
    final int numSessions = 100;
    try (SessionClient client = new SessionClient(spanner, db)) {
      Enumeration<SessionImpl> sessions = client.batchCreateSessions(numSessions);
      int count = 0;
      while (sessions.hasMoreElements()) {
        SessionImpl session = sessions.nextElement();
        assertThat(session.getName()).startsWith(dbName + "/sessions/s");
        count++;
        session.close();
      }
      assertThat(count).isEqualTo(numSessions);
    }
  }

  @SuppressWarnings("unchecked")
  @Test
  public void batchCreateSessionsServerReturnsLessSessionsInTotal() {
    final int MAX_SESSIONS_TOTAL = 50;
    final AtomicInteger totalSessionsReturned = new AtomicInteger();
    DatabaseId db = DatabaseId.of(dbName);
    final String sessionName = dbName + "/sessions/s%d";
    when(rpc.batchCreateSessions(
            Mockito.eq(dbName), Mockito.anyInt(), Mockito.anyMap(), Mockito.anyMap()))
        .then(
            new Answer<List<com.google.spanner.v1.Session>>() {
              @Override
              public List<com.google.spanner.v1.Session> answer(InvocationOnMock invocation)
                  throws Throwable {
                int sessionCount = invocation.getArgumentAt(1, Integer.class);
                List<com.google.spanner.v1.Session> res = new ArrayList<>();
                for (int i = 1; i <= sessionCount; i++) {
                  if (totalSessionsReturned.incrementAndGet() <= MAX_SESSIONS_TOTAL) {
                    res.add(
                        com.google.spanner.v1.Session.newBuilder()
                            .setName(String.format(sessionName, i))
                            .build());
                  }
                }
                return res;
              }
            });

    // We want 100 sessions, but the server can only handle 50. We should receive 50 sessions and
    // then an error.
    final int numSessions = 100;
    int count = 0;
    try (SessionClient client = new SessionClient(spanner, db)) {
      Enumeration<SessionImpl> sessions = client.batchCreateSessions(numSessions);
      while (sessions.hasMoreElements()) {
        SessionImpl session = sessions.nextElement();
        assertThat(session.getName()).startsWith(dbName + "/sessions/s");
        count++;
        session.close();
      }
      fail("missing expected exception");
    } catch (SpannerException e) {
      // ignore, this is the expected exception.
    }
    assertThat(count).isEqualTo(MAX_SESSIONS_TOTAL);
  }
}
