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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.core.NanoClock;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.grpc.GrpcTransportOptions.ExecutorFactory;
import com.google.cloud.spanner.SessionClient.SessionConsumer;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Option;
import com.google.common.collect.ImmutableMap;
import io.opencensus.trace.Tracing;
import io.opentelemetry.api.OpenTelemetry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
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

@RunWith(Parameterized.class)
public class SessionClientTests {
  private final class TestExecutorFactory implements ExecutorFactory<ScheduledExecutorService> {
    @Override
    public ScheduledExecutorService get() {
      return Executors.newScheduledThreadPool(spanner.getOptions().getNumChannels());
    }

    @Override
    public void release(ScheduledExecutorService executor) {
      executor.shutdown();
      try {
        executor.awaitTermination(10_000L, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  @Parameters(name = "NumChannels = {0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {{1}, {2}, {4}, {8}});
  }

  @Parameter public int numChannels;

  private final String dbName = "projects/p1/instances/i1/databases/d1";
  @Mock private SpannerImpl spanner;
  @Mock private SpannerRpc rpc;
  @Mock private SpannerOptions spannerOptions;
  private final TraceWrapper tracer =
      new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false);
  @Mock private ISpan span;
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
    when(spannerOptions.getDatabaseRole()).thenReturn("role");
    when(spannerOptions.getRetrySettings()).thenReturn(RetrySettings.newBuilder().build());
    when(spannerOptions.getClock()).thenReturn(NanoClock.getDefaultClock());
    when(spanner.getOptions()).thenReturn(spannerOptions);
    when(spanner.getTracer()).thenReturn(tracer);
    doNothing().when(span).setStatus(any(Throwable.class));
    doNothing().when(span).end();
    doNothing().when(span).addAnnotation("Starting Commit");
    when(spanner.getRpc()).thenReturn(rpc);
    SessionPoolOptions sessionPoolOptions = mock(SessionPoolOptions.class);
    when(sessionPoolOptions.getPoolMaintainerClock()).thenReturn(Clock.INSTANCE);
    when(spannerOptions.getSessionPoolOptions()).thenReturn(sessionPoolOptions);
  }

  @Test
  public void createAndCloseSession() {
    DatabaseId db = DatabaseId.of(dbName);
    String sessionName = dbName + "/sessions/s1";
    Map<String, String> labels = new HashMap<>();
    labels.put("env", "dev");
    String databaseRole = "role";
    when(spannerOptions.getSessionLabels()).thenReturn(labels);
    when(spannerOptions.getDatabaseRole()).thenReturn(databaseRole);
    com.google.spanner.v1.Session sessionProto =
        com.google.spanner.v1.Session.newBuilder()
            .setName(sessionName)
            .putAllLabels(labels)
            .build();
    when(rpc.createSession(
            Mockito.eq(dbName), Mockito.eq(databaseRole), Mockito.eq(labels), options.capture()))
        .thenReturn(sessionProto);

    try (SessionClient client = new SessionClient(spanner, db, new TestExecutorFactory())) {
      Session session = client.createSession();
      assertThat(session.getName()).isEqualTo(sessionName);

      session.close();

      final ArgumentCaptor<Map<SpannerRpc.Option, ?>> deleteOptionsCaptor =
          ArgumentCaptor.forClass(Map.class);
      final ArgumentCaptor<String> sessionNameCaptor = ArgumentCaptor.forClass(String.class);
      Mockito.verify(rpc).deleteSession(sessionNameCaptor.capture(), deleteOptionsCaptor.capture());
      assertEquals(sessionName, sessionNameCaptor.getValue());
      // The same channelHint is passed for deleteSession (contained in "options").
      assertEquals(
          deleteOptionsCaptor.getValue().get(SpannerRpc.Option.CHANNEL_HINT),
          options.getValue().get(SpannerRpc.Option.CHANNEL_HINT));
    }
  }

  @Test
  public void createAndCloseMultiplexedSession() {
    DatabaseId db = DatabaseId.of(dbName);
    String sessionName = dbName + "/sessions/s1";
    Map<String, String> labels = ImmutableMap.of("env", "dev");
    String databaseRole = "role";
    when(spannerOptions.getSessionLabels()).thenReturn(labels);
    when(spannerOptions.getDatabaseRole()).thenReturn(databaseRole);
    com.google.spanner.v1.Session sessionProto =
        com.google.spanner.v1.Session.newBuilder()
            .setName(sessionName)
            .setMultiplexed(true)
            .putAllLabels(labels)
            .build();
    when(rpc.createSession(
            Mockito.eq(dbName),
            Mockito.eq(databaseRole),
            Mockito.eq(labels),
            options.capture(),
            Mockito.eq(true)))
        .thenReturn(sessionProto);
    final AtomicInteger returnedSessionCount = new AtomicInteger();
    final SessionConsumer consumer =
        new SessionConsumer() {
          @Override
          public void onSessionReady(SessionImpl session) {
            assertEquals(sessionName, session.getName());
            returnedSessionCount.incrementAndGet();

            session.close();
            Mockito.verify(rpc).deleteSession(sessionName, options.getValue());
          }

          @Override
          public void onSessionCreateFailure(Throwable t, int createFailureForSessionCount) {}
        };
    try (SessionClient client = new SessionClient(spanner, db, new TestExecutorFactory())) {
      client.createMultiplexedSession(consumer);
    }
    // for multiplexed session there is no channel hint pass in the RPC options
    assertNull(options.getValue());
    assertEquals(1, returnedSessionCount.get());
  }

  @Test
  public void createAndCloseMultiplexedSession_whenRPCThrowsException_thenAssertException() {
    DatabaseId db = DatabaseId.of(dbName);
    Map<String, String> labels = ImmutableMap.of("env", "dev");
    String databaseRole = "role";
    when(spannerOptions.getSessionLabels()).thenReturn(labels);
    when(spannerOptions.getDatabaseRole()).thenReturn(databaseRole);
    when(rpc.createSession(
            Mockito.eq(dbName),
            Mockito.eq(databaseRole),
            Mockito.eq(labels),
            options.capture(),
            Mockito.eq(true)))
        .thenThrow(RuntimeException.class);
    final SessionConsumer consumer =
        new SessionConsumer() {
          @Override
          public void onSessionReady(SessionImpl session) {}

          @Override
          public void onSessionCreateFailure(Throwable t, int createFailureForSessionCount) {
            assertTrue(t instanceof RuntimeException);
          }
        };
    try (SessionClient client = new SessionClient(spanner, db, new TestExecutorFactory())) {
      client.createMultiplexedSession(consumer);
    }
    // for multiplexed session there is no channel hint pass in the RPC options
    assertNull(options.getValue());
  }

  @SuppressWarnings("unchecked")
  @Test
  public void batchCreateAndCloseSessions() {
    DatabaseId db = DatabaseId.of(dbName);
    final String sessionName = dbName + "/sessions/s%d";
    final Map<String, String> labels = new HashMap<>();
    labels.put("env", "dev");
    when(spannerOptions.getSessionLabels()).thenReturn(labels);
    String databaseRole = new String("role");
    when(spannerOptions.getDatabaseRole()).thenReturn(databaseRole);
    final List<Long> usedChannels = Collections.synchronizedList(new ArrayList<>());
    when(rpc.batchCreateSessions(
            Mockito.eq(dbName),
            Mockito.anyInt(),
            Mockito.eq(databaseRole),
            Mockito.eq(labels),
            Mockito.anyMap()))
        .then(
            invocation -> {
              Map<Option, Object> options = invocation.getArgument(4, Map.class);
              Long channelHint = (Long) options.get(Option.CHANNEL_HINT);
              usedChannels.add(channelHint);
              int sessionCount = invocation.getArgument(1, Integer.class);
              List<com.google.spanner.v1.Session> res = new ArrayList<>();
              for (int i = 1; i <= sessionCount; i++) {
                res.add(
                    com.google.spanner.v1.Session.newBuilder()
                        .setName(String.format(sessionName, i))
                        .putAllLabels(labels)
                        .build());
              }
              return res;
            });

    final AtomicInteger returnedSessionCount = new AtomicInteger();
    SessionConsumer consumer =
        new SessionConsumer() {
          @Override
          public void onSessionReady(SessionImpl session) {
            assertThat(session.getName()).startsWith(dbName + "/sessions/s");
            returnedSessionCount.incrementAndGet();
            session.close();
          }

          @Override
          public void onSessionCreateFailure(Throwable t, int createFailureForSessionCount) {}
        };
    final int numSessions = 10;
    try (SessionClient client = new SessionClient(spanner, db, new TestExecutorFactory())) {
      client.asyncBatchCreateSessions(numSessions, true, consumer);
    }
    assertThat(returnedSessionCount.get()).isEqualTo(numSessions);
    assertThat(usedChannels.size()).isEqualTo(spannerOptions.getNumChannels());
    List<Long> expectedChannels = new ArrayList<>();
    for (long l = 0; l < spannerOptions.getNumChannels(); l++) {
      expectedChannels.add(l);
    }
    assertThat(usedChannels).containsExactlyElementsIn(expectedChannels);
  }

  /**
   * Tests that multiple consecutive calls to {@link SessionClient#asyncBatchCreateSessions(int,
   * boolean, SessionConsumer)} with distributeOverChannels=false does not distribute one batch over
   * multiple channels, but it does assign each new call to a new channel. This means that multiple
   * calls to this method will still distribute the total set of sessions over all available
   * channels.
   */
  @SuppressWarnings("unchecked")
  @Test
  public void batchCreateSessionsDistributesMultipleRequestsOverChannels() {
    DatabaseId db = DatabaseId.of(dbName);
    final String sessionName = dbName + "/sessions/s%d";
    final Map<String, String> labels = Collections.emptyMap();
    when(spannerOptions.getSessionLabels()).thenReturn(labels);
    when(spannerOptions.getDatabaseRole()).thenReturn("role");
    final Set<Long> usedChannelHints = Collections.synchronizedSet(new HashSet<>());
    when(rpc.batchCreateSessions(
            Mockito.eq(dbName),
            Mockito.anyInt(),
            Mockito.anyString(),
            Mockito.eq(labels),
            Mockito.anyMap()))
        .then(
            invocation -> {
              Map<Option, Object> options = invocation.getArgument(4, Map.class);
              Long channelHint = (Long) options.get(Option.CHANNEL_HINT);
              usedChannelHints.add(channelHint);
              int sessionCount = invocation.getArgument(1, Integer.class);
              List<com.google.spanner.v1.Session> res = new ArrayList<>();
              for (int i = 1; i <= sessionCount; i++) {
                res.add(
                    com.google.spanner.v1.Session.newBuilder()
                        .setName(String.format(sessionName, i))
                        .putAllLabels(labels)
                        .setCreatorRole("role")
                        .build());
              }
              return res;
            });

    final AtomicInteger returnedSessionCount = new AtomicInteger();
    SessionConsumer consumer =
        new SessionConsumer() {
          @Override
          public void onSessionReady(SessionImpl session) {
            assertThat(session.getName()).startsWith(dbName + "/sessions/s");
            returnedSessionCount.incrementAndGet();
            session.close();
          }

          @Override
          public void onSessionCreateFailure(Throwable t, int createFailureForSessionCount) {}
        };
    final int numSessions = 10;
    final int numBatches = spannerOptions.getNumChannels() * 2;
    try (SessionClient client = new SessionClient(spanner, db, new TestExecutorFactory())) {
      for (int batch = 0; batch < numBatches; batch++) {
        client.asyncBatchCreateSessions(numSessions, false, consumer);
      }
    }
    assertThat(returnedSessionCount.get()).isEqualTo(numSessions * numBatches);
    assertThat(usedChannelHints.size()).isEqualTo(spannerOptions.getNumChannels() * 2);
    List<Long> expectedChannels = new ArrayList<>();
    for (long l = 0; l < spannerOptions.getNumChannels() * 2; l++) {
      expectedChannels.add(l);
    }
    assertThat(usedChannelHints).containsExactlyElementsIn(expectedChannels);
  }

  private enum AddRemoveSetException {
    SET,
    ADD,
    REMOVE
  }

  @SuppressWarnings("unchecked")
  @Test
  public void batchCreateSessionsWithExceptions() {
    for (AddRemoveSetException behavior : AddRemoveSetException.values()) {
      final List<Long> errorOnChannels = new ArrayList<>();
      if (behavior == AddRemoveSetException.REMOVE) {
        for (int c = 0; c < spannerOptions.getNumChannels(); c++) {
          errorOnChannels.add((long) c);
        }
      }
      for (int errorOnChannel = 0;
          errorOnChannel < spannerOptions.getNumChannels();
          errorOnChannel++) {
        switch (behavior) {
          case SET:
            errorOnChannels.clear();
          case ADD:
            errorOnChannels.add((long) errorOnChannel);
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
                Mockito.eq(dbName),
                Mockito.anyInt(),
                Mockito.anyString(),
                Mockito.anyMap(),
                Mockito.anyMap()))
            .then(
                invocation -> {
                  Map<Option, Object> options = invocation.getArgument(4, Map.class);
                  Long channelHint = (Long) options.get(Option.CHANNEL_HINT);
                  if (errorOnChannels.contains(channelHint)) {
                    throw SpannerExceptionFactory.newSpannerException(
                        ErrorCode.RESOURCE_EXHAUSTED, "could not create any more sessions");
                  } else {
                    int sessionCount = invocation.getArgument(1, Integer.class);
                    List<com.google.spanner.v1.Session> res = new ArrayList<>();
                    for (int i = 1; i <= sessionCount; i++) {
                      res.add(
                          com.google.spanner.v1.Session.newBuilder()
                              .setName(String.format(sessionName, i))
                              .build());
                    }
                    return res;
                  }
                });

        final AtomicInteger errorForSessionsCount = new AtomicInteger();
        final AtomicInteger errorCount = new AtomicInteger();
        final AtomicInteger returnedSessionCount = new AtomicInteger();
        SessionConsumer consumer =
            new SessionConsumer() {
              @Override
              public void onSessionReady(SessionImpl session) {
                assertThat(session.getName()).startsWith(dbName + "/sessions/s");
                returnedSessionCount.incrementAndGet();
                session.close();
              }

              @Override
              public void onSessionCreateFailure(Throwable t, int createFailureForSessionCount) {
                assertThat(t).isInstanceOf(SpannerException.class);
                SpannerException e = (SpannerException) t;
                assertThat(e.getErrorCode()).isEqualTo(ErrorCode.RESOURCE_EXHAUSTED);
                errorCount.incrementAndGet();
                errorForSessionsCount.addAndGet(createFailureForSessionCount);
              }
            };
        final int numSessions = 10;
        try (SessionClient client = new SessionClient(spanner, db, new TestExecutorFactory())) {
          client.asyncBatchCreateSessions(numSessions, true, consumer);
        }
        assertThat(errorCount.get()).isEqualTo(errorOnChannels.size());
        assertThat(returnedSessionCount.get())
            .isAtLeast(
                numSessions
                    - ((numSessions / spannerOptions.getNumChannels()) * errorOnChannels.size()
                        + numSessions % spannerOptions.getNumChannels()));
        assertThat(returnedSessionCount.get() + errorForSessionsCount.get()).isEqualTo(numSessions);
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
            Mockito.eq(dbName),
            Mockito.anyInt(),
            Mockito.anyString(),
            Mockito.anyMap(),
            Mockito.anyMap()))
        .then(
            invocation -> {
              int sessionCount = invocation.getArgument(1, Integer.class);
              List<com.google.spanner.v1.Session> res = new ArrayList<>();
              for (int i = 1; i <= Math.min(MAX_SESSIONS_PER_BATCH, sessionCount); i++) {
                res.add(
                    com.google.spanner.v1.Session.newBuilder()
                        .setName(String.format(sessionName, i))
                        .build());
              }
              return res;
            });

    final AtomicInteger returnedSessionCount = new AtomicInteger();
    SessionConsumer consumer =
        new SessionConsumer() {
          @Override
          public void onSessionReady(SessionImpl session) {
            assertThat(session.getName()).startsWith(dbName + "/sessions/s");
            returnedSessionCount.incrementAndGet();
            session.close();
          }

          @Override
          public void onSessionCreateFailure(Throwable t, int createFailureForSessionCount) {}
        };
    // We want 100 sessions, but each rpc will only return 5. The consumer should still get 100
    // sessions.
    final int numSessions = 100;
    try (SessionClient client = new SessionClient(spanner, db, new TestExecutorFactory())) {
      client.asyncBatchCreateSessions(numSessions, true, consumer);
    }
    assertThat(returnedSessionCount.get()).isEqualTo(numSessions);
  }
}
