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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.NoCredentials;
import com.google.cloud.grpc.GrpcTransportOptions.ExecutorFactory;
import com.google.cloud.spanner.SessionClient.SessionConsumer;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.stubbing.Answer;

@RunWith(JUnit4.class)
public class MultiplexedSessionDatabaseClientTest {
  private static final DatabaseId TEST_DATABASE_ID =
      DatabaseId.of("test-project", "test-instance", "test-database");

  @After
  public void tearDown() throws Exception {
    clearChannelUsage();
  }

  @Test
  public void testMaintainer() {
    // This fails for the native builds due to the extensive use of reflection.
    assumeTrue(isJava8());

    Instant now = Instant.now();
    Clock clock = mock(Clock.class);
    when(clock.instant()).thenReturn(now);
    SessionClient sessionClient = mock(SessionClient.class);
    SpannerImpl spanner = mock(SpannerImpl.class);
    SpannerOptions spannerOptions = mock(SpannerOptions.class);
    SessionPoolOptions sessionPoolOptions = mock(SessionPoolOptions.class);
    when(sessionClient.getSpanner()).thenReturn(spanner);
    when(sessionClient.getDatabaseId()).thenReturn(TEST_DATABASE_ID);
    when(spanner.getRpc()).thenReturn(mock(SpannerRpc.class));
    when(spanner.getOptions()).thenReturn(spannerOptions);
    when(spannerOptions.getSessionPoolOptions()).thenReturn(sessionPoolOptions);
    when(sessionPoolOptions.getMultiplexedSessionMaintenanceDuration())
        .thenReturn(Duration.ofDays(7));
    when(sessionPoolOptions.getMultiplexedSessionMaintenanceLoopFrequency())
        .thenReturn(Duration.ofMinutes(10));

    SessionImpl session1 = mock(SessionImpl.class);
    SessionReference sessionReference1 = mock(SessionReference.class);
    when(session1.getSessionReference()).thenReturn(sessionReference1);

    SessionImpl session2 = mock(SessionImpl.class);
    SessionReference sessionReference2 = mock(SessionReference.class);
    when(session2.getSessionReference()).thenReturn(sessionReference2);

    doAnswer(
            (Answer<?>)
                invocationOnMock -> {
                  SessionConsumer consumer = invocationOnMock.getArgument(0);
                  // Return session1 the first time it is called.
                  consumer.onSessionReady(session1);
                  return null;
                })
        .doAnswer(
            (Answer<?>)
                invocationOnMock -> {
                  SessionConsumer consumer = invocationOnMock.getArgument(0);
                  // Return session2 the second time that it is called.
                  consumer.onSessionReady(session2);
                  return null;
                })
        .when(sessionClient)
        .asyncCreateMultiplexedSession(any(SessionConsumer.class));

    // Create a client. This should get session1.
    MultiplexedSessionDatabaseClient client =
        new MultiplexedSessionDatabaseClient(sessionClient, clock);

    // Make sure that the client uses the initial session that is created.
    assertEquals(client.getCurrentSessionReference(), session1.getSessionReference());

    // Run the maintainer without advancing the clock. We should still get the same session.
    client.getMaintainer().maintain();
    assertEquals(client.getCurrentSessionReference(), session1.getSessionReference());

    // Advance the clock by 1 day. We should still get the same session.
    when(clock.instant()).thenReturn(now.plus(Duration.ofDays(1)));
    client.getMaintainer().maintain();
    assertEquals(client.getCurrentSessionReference(), session1.getSessionReference());

    // Advance the clock by 8 days. We should now get a new session.
    when(clock.instant()).thenReturn(now.plus(Duration.ofDays(8)));
    client.getMaintainer().maintain();
    assertEquals(client.getCurrentSessionReference(), session2.getSessionReference());
  }

  @Test
  public void testClosedClientIgnoresInitialSessionThatArrivesAfterClose() {
    assumeTrue(isJava8());
    Clock clock = mock(Clock.class);
    when(clock.instant()).thenReturn(Instant.now());
    SessionClient sessionClient = mock(SessionClient.class);
    SpannerImpl spanner = mock(SpannerImpl.class);
    SpannerOptions spannerOptions = mock(SpannerOptions.class);
    SessionPoolOptions sessionPoolOptions = mock(SessionPoolOptions.class);
    when(sessionClient.getSpanner()).thenReturn(spanner);
    when(sessionClient.getDatabaseId()).thenReturn(TEST_DATABASE_ID);
    when(spanner.getRpc()).thenReturn(mock(SpannerRpc.class));
    when(spanner.getOptions()).thenReturn(spannerOptions);
    when(spannerOptions.getSessionPoolOptions()).thenReturn(sessionPoolOptions);
    when(sessionPoolOptions.getMultiplexedSessionMaintenanceDuration())
        .thenReturn(Duration.ofDays(7));
    when(sessionPoolOptions.getMultiplexedSessionMaintenanceLoopFrequency())
        .thenReturn(Duration.ofMinutes(10));
    when(sessionPoolOptions.getWaitForMinSessions()).thenReturn(Duration.ZERO);

    SessionImpl session = mock(SessionImpl.class);
    when(session.getSessionReference()).thenReturn(mock(SessionReference.class));
    // Capture the consumer of the initial session without delivering a session yet.
    AtomicReference<SessionConsumer> consumer = new AtomicReference<>();
    doAnswer(
            (Answer<?>)
                invocationOnMock -> {
                  consumer.set(invocationOnMock.getArgument(0));
                  return null;
                })
        .when(sessionClient)
        .asyncCreateMultiplexedSession(any(SessionConsumer.class));
    MultiplexedSessionDatabaseClient client =
        new MultiplexedSessionDatabaseClient(sessionClient, clock);
    assertNotNull(consumer.get());

    // The client is closed while its initial session is still being created.
    client.close();
    consumer.get().onSessionReady(session);

    // The late session is not handed to waiters of the closed client, and the maintainer is not
    // started for it.
    SpannerException exception =
        assertThrows(SpannerException.class, client::getCurrentSessionReference);
    assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
    verify(sessionPoolOptions, never()).getMultiplexedSessionMaintenanceLoopFrequency();
  }

  @Test
  public void testClosedClientIgnoresRefreshedSessionThatArrivesAfterClose() {
    assumeTrue(isJava8());
    Instant now = Instant.now();
    Clock clock = mock(Clock.class);
    when(clock.instant()).thenReturn(now);
    SessionClient sessionClient = mock(SessionClient.class);
    SpannerImpl spanner = mock(SpannerImpl.class);
    SpannerOptions spannerOptions = mock(SpannerOptions.class);
    SessionPoolOptions sessionPoolOptions = mock(SessionPoolOptions.class);
    when(sessionClient.getSpanner()).thenReturn(spanner);
    when(sessionClient.getDatabaseId()).thenReturn(TEST_DATABASE_ID);
    when(spanner.getRpc()).thenReturn(mock(SpannerRpc.class));
    when(spanner.getOptions()).thenReturn(spannerOptions);
    when(spannerOptions.getSessionPoolOptions()).thenReturn(sessionPoolOptions);
    when(sessionPoolOptions.getMultiplexedSessionMaintenanceDuration())
        .thenReturn(Duration.ofDays(7));
    when(sessionPoolOptions.getMultiplexedSessionMaintenanceLoopFrequency())
        .thenReturn(Duration.ofMinutes(10));

    SessionImpl session1 = mock(SessionImpl.class);
    SessionReference sessionReference1 = mock(SessionReference.class);
    when(session1.getSessionReference()).thenReturn(sessionReference1);
    SessionImpl session2 = mock(SessionImpl.class);
    when(session2.getSessionReference()).thenReturn(mock(SessionReference.class));

    // Deliver the initial session immediately, but capture the consumer of the refresh.
    AtomicReference<SessionConsumer> refreshConsumer = new AtomicReference<>();
    doAnswer(
            (Answer<?>)
                invocationOnMock -> {
                  SessionConsumer consumer = invocationOnMock.getArgument(0);
                  consumer.onSessionReady(session1);
                  return null;
                })
        .doAnswer(
            (Answer<?>)
                invocationOnMock -> {
                  refreshConsumer.set(invocationOnMock.getArgument(0));
                  return null;
                })
        .when(sessionClient)
        .asyncCreateMultiplexedSession(any(SessionConsumer.class));
    MultiplexedSessionDatabaseClient client =
        new MultiplexedSessionDatabaseClient(sessionClient, clock);
    assertEquals(sessionReference1, client.getCurrentSessionReference());

    // The session is due for a refresh, and the refresh is in flight when the client is closed.
    when(clock.instant()).thenReturn(now.plus(Duration.ofDays(8)));
    client.getMaintainer().maintain();
    assertNotNull(refreshConsumer.get());
    client.close();
    refreshConsumer.get().onSessionReady(session2);

    // The refreshed session of the closed client is ignored.
    assertEquals(sessionReference1, client.getCurrentSessionReference());
  }

  @Test
  public void testDisableMultiplexedSessionEnvVar() throws Exception {
    assumeTrue(isJava8() && !isWindows());
    assumeFalse(System.getenv().containsKey("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS"));

    // Assert that the mux sessions setting is respected by default.
    assertTrue(
        SessionPoolOptions.newBuilder()
            .setUseMultiplexedSession(true)
            .build()
            .getUseMultiplexedSession());

    Class<?> classOfMap = System.getenv().getClass();
    Field field = classOfMap.getDeclaredField("m");
    field.setAccessible(true);
    Map<String, String> writeableEnvironmentVariables =
        (Map<String, String>) field.get(System.getenv());

    try {
      writeableEnvironmentVariables.put("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS", "false");
      // Assert that the env var overrides the mux sessions setting.
      assertFalse(
          SessionPoolOptions.newBuilder()
              .setUseMultiplexedSession(true)
              .build()
              .getUseMultiplexedSession());
    } finally {
      writeableEnvironmentVariables.remove("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS");
    }
  }

  @Test
  public void testEnableMultiplexedSessionEnvVar() throws Exception {
    assumeTrue(isJava8() && !isWindows());
    assumeFalse(System.getenv().containsKey("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS"));

    // Assert that the mux sessions setting is respected by default.
    assertFalse(
        SessionPoolOptions.newBuilder()
            .setUseMultiplexedSession(false)
            .build()
            .getUseMultiplexedSession());

    Class<?> classOfMap = System.getenv().getClass();
    Field field = classOfMap.getDeclaredField("m");
    field.setAccessible(true);
    Map<String, String> writeableEnvironmentVariables =
        (Map<String, String>) field.get(System.getenv());

    try {
      writeableEnvironmentVariables.put("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS", "true");
      // Assert that the env var overrides the mux sessions setting.
      assertTrue(
          SessionPoolOptions.newBuilder()
              .setUseMultiplexedSession(false)
              .build()
              .getUseMultiplexedSession());
    } finally {
      writeableEnvironmentVariables.remove("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS");
    }
  }

  @Test
  public void testIgnoreMultiplexedSessionEnvVar() throws Exception {
    assumeTrue(isJava8() && !isWindows());
    assumeFalse(System.getenv().containsKey("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS"));

    // Assert that the mux sessions setting is respected by default.
    assertFalse(
        SessionPoolOptions.newBuilder()
            .setUseMultiplexedSession(false)
            .build()
            .getUseMultiplexedSession());

    Class<?> classOfMap = System.getenv().getClass();
    Field field = classOfMap.getDeclaredField("m");
    field.setAccessible(true);
    Map<String, String> writeableEnvironmentVariables =
        (Map<String, String>) field.get(System.getenv());

    try {
      writeableEnvironmentVariables.put("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS", "");
      // Assert that the env var overrides the mux sessions setting.
      assertFalse(
          SessionPoolOptions.newBuilder()
              .setUseMultiplexedSession(false)
              .build()
              .getUseMultiplexedSession());
    } finally {
      writeableEnvironmentVariables.remove("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS");
    }
  }

  @Test
  public void testThrowExceptionMultiplexedSessionEnvVarInvalidValues() throws Exception {
    assumeTrue(isJava8() && !isWindows());
    assumeFalse(System.getenv().containsKey("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS"));

    // Assert that the mux sessions setting is respected by default.
    assertFalse(
        SessionPoolOptions.newBuilder()
            .setUseMultiplexedSession(false)
            .build()
            .getUseMultiplexedSession());

    Class<?> classOfMap = System.getenv().getClass();
    Field field = classOfMap.getDeclaredField("m");
    field.setAccessible(true);
    Map<String, String> writeableEnvironmentVariables =
        (Map<String, String>) field.get(System.getenv());

    try {
      writeableEnvironmentVariables.put("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS", "test");

      // setting an invalid GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS value throws error.
      IllegalArgumentException e =
          assertThrows(
              IllegalArgumentException.class,
              () ->
                  SessionPoolOptions.newBuilder()
                      .setUseMultiplexedSession(false)
                      .build()
                      .getUseMultiplexedSession());
      StringWriter sw = new StringWriter();
      e.printStackTrace(new PrintWriter(sw));
      assertThat(sw.toString())
          .contains("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS should be either true or false");
    } finally {
      writeableEnvironmentVariables.remove("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS");
    }
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testGrpcGcpSingleUseDoesNotReserveBitsetChannelHint() throws Exception {
    assumeTrue(isJava8());
    SessionClient sessionClient = mock(SessionClient.class);
    SpannerImpl spanner = mock(SpannerImpl.class);
    SpannerOptions spannerOptions = mock(SpannerOptions.class);
    SessionPoolOptions sessionPoolOptions = mock(SessionPoolOptions.class);
    TraceWrapper tracer = mock(TraceWrapper.class);
    ISpan span = mock(ISpan.class);

    when(sessionClient.getSpanner()).thenReturn(spanner);
    when(sessionClient.getDatabaseId()).thenReturn(TEST_DATABASE_ID);
    when(spanner.getRpc()).thenReturn(mock(SpannerRpc.class));
    when(spanner.getOptions()).thenReturn(spannerOptions);
    when(spanner.getTracer()).thenReturn(tracer);
    when(tracer.getCurrentSpan()).thenReturn(span);
    when(spannerOptions.getNumChannels()).thenReturn(4);
    when(spannerOptions.isGrpcGcpExtensionEnabled()).thenReturn(true);
    when(spannerOptions.getSessionPoolOptions()).thenReturn(sessionPoolOptions);
    when(sessionPoolOptions.getMultiplexedSessionMaintenanceDuration())
        .thenReturn(Duration.ofDays(7));
    when(sessionPoolOptions.getWaitForMinSessions()).thenReturn(Duration.ZERO);

    MultiplexedSessionDatabaseClient client =
        new MultiplexedSessionDatabaseClient(sessionClient, Clock.systemUTC());
    SessionReference sessionReference =
        new SessionReference(
            "projects/p/instances/i/databases/d/sessions/s1",
            null,
            com.google.protobuf.Timestamp.getDefaultInstance(),
            true,
            null);

    Field sessionFutureField =
        MultiplexedSessionDatabaseClient.class.getDeclaredField("multiplexedSessionReference");
    sessionFutureField.setAccessible(true);
    @SuppressWarnings("unchecked")
    AtomicReference<com.google.api.core.ApiFuture<SessionReference>> sessionFutureRef =
        (AtomicReference<com.google.api.core.ApiFuture<SessionReference>>)
            sessionFutureField.get(client);
    sessionFutureRef.set(ApiFutures.immediateFuture(sessionReference));

    java.lang.reflect.Method method =
        MultiplexedSessionDatabaseClient.class.getDeclaredMethod(
            "createDirectMultiplexedSessionTransaction", boolean.class);
    method.setAccessible(true);
    method.invoke(client, true);

    Field field =
        MultiplexedSessionDatabaseClient.class.getDeclaredField("numCurrentSingleUseTransactions");
    field.setAccessible(true);
    AtomicInteger counter = (AtomicInteger) field.get(client);
    assertEquals(0, counter.get());
  }

  @Test
  public void testCloseRemovesChannelUsageEntryWhenLastClientCloses() throws Exception {
    try (SpannerImpl spanner = createTestSpanner();
        SessionClient sessionClient = createSessionClient(spanner)) {
      MultiplexedSessionDatabaseClient client =
          new MultiplexedSessionDatabaseClient(sessionClient, Clock.systemUTC());

      assertEquals(1, getChannelUsage().size());

      client.close();

      assertEquals(0, getChannelUsage().size());
    }
  }

  @Test
  public void testCloseKeepsChannelUsageEntryWhileAnotherClientIsUsingSameSpanner()
      throws Exception {
    try (SpannerImpl spanner = createTestSpanner();
        SessionClient firstSessionClient = createSessionClient(spanner);
        SessionClient secondSessionClient = createSessionClient(spanner)) {
      MultiplexedSessionDatabaseClient firstClient =
          new MultiplexedSessionDatabaseClient(firstSessionClient, Clock.systemUTC());
      MultiplexedSessionDatabaseClient secondClient =
          new MultiplexedSessionDatabaseClient(secondSessionClient, Clock.systemUTC());

      assertEquals(1, getChannelUsage().size());

      firstClient.close();
      assertEquals(1, getChannelUsage().size());

      secondClient.close();
      assertEquals(0, getChannelUsage().size());
    }
  }

  @Test
  public void testChannelPrimeSessionSourceLifecycleAndNonBlockingAccessor() throws Exception {
    assumeTrue(isJava8());
    Clock clock = mock(Clock.class);
    when(clock.instant()).thenReturn(Instant.now());
    SessionClient sessionClient = mock(SessionClient.class);
    SpannerImpl spanner = mock(SpannerImpl.class);
    SpannerRpc rpc = mock(SpannerRpc.class);
    SpannerOptions spannerOptions = mock(SpannerOptions.class);
    SessionPoolOptions sessionPoolOptions = mock(SessionPoolOptions.class);
    when(sessionClient.getSpanner()).thenReturn(spanner);
    when(spanner.getRpc()).thenReturn(rpc);
    when(spanner.getOptions()).thenReturn(spannerOptions);
    when(spannerOptions.getSessionPoolOptions()).thenReturn(sessionPoolOptions);
    when(sessionPoolOptions.getMultiplexedSessionMaintenanceDuration())
        .thenReturn(Duration.ofDays(7));
    when(sessionPoolOptions.getMultiplexedSessionMaintenanceLoopFrequency())
        .thenReturn(Duration.ofMinutes(10));
    List<SessionConsumer> consumers = new ArrayList<>();
    doAnswer(
            (Answer<?>)
                invocationOnMock -> {
                  consumers.add(invocationOnMock.getArgument(0));
                  return null;
                })
        .when(sessionClient)
        .asyncCreateMultiplexedSession(any(SessionConsumer.class));

    MultiplexedSessionDatabaseClient first =
        new MultiplexedSessionDatabaseClient(sessionClient, clock);
    MultiplexedSessionDatabaseClient second =
        new MultiplexedSessionDatabaseClient(sessionClient, clock);

    ArgumentCaptor<SpannerRpc.ChannelPrimeSessionSource> sources =
        ArgumentCaptor.forClass(SpannerRpc.ChannelPrimeSessionSource.class);
    verify(rpc, times(2)).registerChannelPrimeSessionSource(sources.capture());
    assertThat(sources.getAllValues()).containsExactly(first, second).inOrder();
    // Pending futures yield no session immediately; the accessor never waits for completion.
    assertThat(first.getChannelPrimeSessionName()).isNull();
    assertThat(second.getChannelPrimeSessionName()).isNull();

    consumers
        .get(0)
        .onSessionCreateFailure(
            SpannerExceptionFactory.newSpannerException(ErrorCode.PERMISSION_DENIED, "denied"), 1);
    assertThat(first.getChannelPrimeSessionName()).isNull();

    Field referenceField =
        MultiplexedSessionDatabaseClient.class.getDeclaredField("multiplexedSessionReference");
    referenceField.setAccessible(true);
    @SuppressWarnings("unchecked")
    AtomicReference<ApiFuture<SessionReference>> reference =
        (AtomicReference<ApiFuture<SessionReference>>) referenceField.get(first);
    SettableApiFuture<SessionReference> cancelled = SettableApiFuture.create();
    cancelled.cancel(false);
    reference.set(cancelled);
    assertThat(first.getChannelPrimeSessionName()).isNull();

    SessionReference initialReference = mock(SessionReference.class);
    when(initialReference.getName()).thenReturn("initial-session");
    SessionImpl initialSession = mock(SessionImpl.class);
    when(initialSession.getSessionReference()).thenReturn(initialReference);
    consumers.get(1).onSessionReady(initialSession);
    assertThat(second.getChannelPrimeSessionName()).isEqualTo("initial-session");
    verify(rpc, times(2)).registerChannelPrimeSessionSource(any());

    when(clock.instant()).thenReturn(Instant.now().plus(Duration.ofDays(8)));
    second.getMaintainer().maintain();
    SessionReference refreshedReference = mock(SessionReference.class);
    when(refreshedReference.getName()).thenReturn("refreshed-session");
    SessionImpl refreshedSession = mock(SessionImpl.class);
    when(refreshedSession.getSessionReference()).thenReturn(refreshedReference);
    consumers.get(2).onSessionReady(refreshedSession);
    assertThat(second.getChannelPrimeSessionName()).isEqualTo("refreshed-session");
    verify(rpc, times(2)).registerChannelPrimeSessionSource(any());

    first.close();
    first.close();
    verify(rpc).unregisterChannelPrimeSessionSource(first);
    verify(rpc, never()).unregisterChannelPrimeSessionSource(second);
    second.close();
    verify(rpc).unregisterChannelPrimeSessionSource(second);
    assertThat(second.getChannelPrimeSessionName()).isNull();
  }

  private SessionClient createSessionClient(SpannerImpl spanner) {
    return new FailingMultiplexedSessionClient(spanner);
  }

  private SpannerImpl createTestSpanner() {
    SessionPoolOptions sessionPoolOptions =
        SessionPoolOptions.newBuilder()
            .setMultiplexedSessionMaintenanceDuration(Duration.ofDays(7))
            .setWaitForMinSessionsDuration(Duration.ZERO)
            .build();
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setNumChannels(4)
            .setSessionPoolOption(sessionPoolOptions)
            .build();
    return new SpannerImpl(options);
  }

  @SuppressWarnings("unchecked")
  private Map<?, ?> getChannelUsage() throws Exception {
    Field field = MultiplexedSessionDatabaseClient.class.getDeclaredField("CHANNEL_USAGE");
    field.setAccessible(true);
    return (Map<?, ?>) field.get(null);
  }

  private void clearChannelUsage() throws Exception {
    getChannelUsage().clear();
  }

  private boolean isJava8() {
    return JavaVersionUtil.getJavaMajorVersion() == 8;
  }

  private boolean isWindows() {
    return System.getProperty("os.name").toLowerCase().contains("windows");
  }

  private static final class TestExecutorFactory
      implements ExecutorFactory<ScheduledExecutorService> {
    @Override
    public ScheduledExecutorService get() {
      return Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void release(ScheduledExecutorService executor) {
      executor.shutdown();
      try {
        executor.awaitTermination(10L, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  private static final class FailingMultiplexedSessionClient extends SessionClient {
    private FailingMultiplexedSessionClient(SpannerImpl spanner) {
      super(spanner, TEST_DATABASE_ID, new TestExecutorFactory());
    }

    @Override
    void asyncCreateMultiplexedSession(SessionConsumer consumer) {
      consumer.onSessionCreateFailure(
          SpannerExceptionFactory.newSpannerException(ErrorCode.UNAUTHENTICATED, "test"), 1);
    }
  }
}
