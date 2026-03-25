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

package com.google.cloud.spanner.connection;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.auth.Credentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.BatchClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SessionPoolOptions;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.connection.ConnectionImpl.LeakedConnectionException;
import com.google.cloud.spanner.connection.SpannerPool.CheckAndCloseSpannersMode;
import com.google.cloud.spanner.connection.SpannerPool.SpannerPoolKey;
import com.google.common.base.Ticker;
import com.google.common.testing.FakeTicker;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SpannerPoolTest {
  private static final String URI =
      "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database";
  private ConnectionImpl connection1 = mock(ConnectionImpl.class);
  private ConnectionImpl connection2 = mock(ConnectionImpl.class);
  private ConnectionImpl connection3 = mock(ConnectionImpl.class);
  private String credentials1 = "credentials1";
  private String credentials2 = "credentials2";
  private ConnectionOptions options1 = mock(ConnectionOptions.class);
  private ConnectionOptions options2 = mock(ConnectionOptions.class);
  private ConnectionOptions options3 = mock(ConnectionOptions.class);
  private ConnectionOptions options4 = mock(ConnectionOptions.class);

  private ConnectionOptions options5 = mock(ConnectionOptions.class);
  private ConnectionOptions options6 = mock(ConnectionOptions.class);
  private ConnectionOptions options7 = mock(ConnectionOptions.class);
  private ConnectionOptions options8 = mock(ConnectionOptions.class);

  private ConnectionOptions optionsOpenTelemetry1 = mock(ConnectionOptions.class);
  private ConnectionOptions optionsOpenTelemetry2 = mock(ConnectionOptions.class);
  private ConnectionOptions optionsOpenTelemetry3 = mock(ConnectionOptions.class);

  private SpannerPool createSubjectAndMocks() {
    return createSubjectAndMocks(0L, Ticker.systemTicker());
  }

  private SpannerPool createSubjectAndMocks(
      long closeSpannerAfterMillisecondsUnused, Ticker ticker) {
    SpannerPool pool =
        new SpannerPool(closeSpannerAfterMillisecondsUnused, ticker) {
          @Override
          Spanner createSpanner(SpannerPoolKey key, ConnectionOptions options) {
            return mock(Spanner.class);
          }
        };

    OpenTelemetry openTelemetry1 = OpenTelemetrySdk.builder().build();
    OpenTelemetry openTelemetry2 = OpenTelemetrySdk.builder().build();

    when(options1.getCredentialsUrl()).thenReturn(credentials1);
    when(options1.getProjectId()).thenReturn("test-project-1");
    when(options2.getCredentialsUrl()).thenReturn(credentials2);
    when(options2.getProjectId()).thenReturn("test-project-1");

    when(options3.getCredentialsUrl()).thenReturn(credentials1);
    when(options3.getProjectId()).thenReturn("test-project-2");
    when(options4.getCredentialsUrl()).thenReturn(credentials2);
    when(options4.getProjectId()).thenReturn("test-project-2");

    // ConnectionOptions with no specific credentials.
    when(options5.getProjectId()).thenReturn("test-project-3");
    when(options6.getProjectId()).thenReturn("test-project-3");
    when(options7.getProjectId()).thenReturn("test-project-3");
    when(options7.isRouteToLeader()).thenReturn(true);
    when(options8.getProjectId()).thenReturn("test-project-3");
    when(options8.isRouteToLeader()).thenReturn(false);

    when(optionsOpenTelemetry1.getProjectId()).thenReturn("test-project-1");
    when(optionsOpenTelemetry1.getOpenTelemetry()).thenReturn(openTelemetry1);
    when(optionsOpenTelemetry2.getProjectId()).thenReturn("test-project-1");
    when(optionsOpenTelemetry2.getOpenTelemetry()).thenReturn(openTelemetry1);
    when(optionsOpenTelemetry3.getProjectId()).thenReturn("test-project-1");
    when(optionsOpenTelemetry3.getOpenTelemetry()).thenReturn(openTelemetry2);

    return pool;
  }

  @AfterClass
  public static void closeSpannerPool() {
    SpannerPool.closeSpannerPool();
  }

  @Test
  public void testGetSpanner() {
    SpannerPool pool = createSubjectAndMocks();
    Spanner spanner1;
    Spanner spanner2;

    // assert equal
    spanner1 = pool.getSpanner(options1, connection1);
    spanner2 = pool.getSpanner(options1, connection2);
    assertEquals(spanner1, spanner2);
    spanner1 = pool.getSpanner(options2, connection1);
    spanner2 = pool.getSpanner(options2, connection2);
    assertEquals(spanner1, spanner2);
    spanner1 = pool.getSpanner(options3, connection1);
    spanner2 = pool.getSpanner(options3, connection2);
    assertEquals(spanner1, spanner2);
    spanner1 = pool.getSpanner(options4, connection1);
    spanner2 = pool.getSpanner(options4, connection2);
    assertEquals(spanner1, spanner2);
    // Options 5 and 6 both use default credentials.
    spanner1 = pool.getSpanner(options5, connection1);
    spanner2 = pool.getSpanner(options6, connection2);
    assertEquals(spanner1, spanner2);

    // assert not equal
    spanner1 = pool.getSpanner(options1, connection1);
    spanner2 = pool.getSpanner(options2, connection2);
    assertNotEquals(spanner1, spanner2);
    spanner1 = pool.getSpanner(options1, connection1);
    spanner2 = pool.getSpanner(options3, connection2);
    assertNotEquals(spanner1, spanner2);
    spanner1 = pool.getSpanner(options1, connection1);
    spanner2 = pool.getSpanner(options4, connection2);
    assertNotEquals(spanner1, spanner2);
    spanner1 = pool.getSpanner(options2, connection1);
    spanner2 = pool.getSpanner(options3, connection2);
    assertNotEquals(spanner1, spanner2);
    spanner1 = pool.getSpanner(options2, connection1);
    spanner2 = pool.getSpanner(options4, connection2);
    assertNotEquals(spanner1, spanner2);
    spanner1 = pool.getSpanner(options3, connection1);
    spanner2 = pool.getSpanner(options4, connection2);
    assertNotEquals(spanner1, spanner2);
    spanner1 = pool.getSpanner(options7, connection1);
    spanner2 = pool.getSpanner(options8, connection2);
    assertNotEquals(spanner1, spanner2);
  }

  @Test
  public void testRemoveConnection() {
    SpannerPool pool = createSubjectAndMocks();
    Spanner spanner1;
    Spanner spanner2;

    // assert equal
    spanner1 = pool.getSpanner(options1, connection1);
    spanner2 = pool.getSpanner(options1, connection2);
    assertThat(spanner1).isEqualTo(spanner2);
    // one connection removed, assert that we would still get the same Spanner
    pool.removeConnection(options1, connection1);
    spanner1 = pool.getSpanner(options1, connection1);
    assertThat(spanner1).isEqualTo(spanner2);
    // remove two connections, assert that we would still get the same Spanner, as Spanners are not
    // directly closed and removed.
    pool.removeConnection(options1, connection1);
    pool.removeConnection(options1, connection2);
    spanner1 = pool.getSpanner(options1, connection1);
    assertThat(spanner1).isEqualTo(spanner2);
    // remove the last connection again
    pool.removeConnection(options1, connection1);
  }

  private static Logger log = Logger.getLogger(SpannerPool.class.getName());
  private static OutputStream logCapturingStream;
  private static StreamHandler customLogHandler;
  private static boolean useParentHandlers;

  private void attachLogCapturer() {
    logCapturingStream = new ByteArrayOutputStream();
    Logger currentLogger = log;
    Handler[] handlers = new Handler[0];
    while (handlers.length == 0 && currentLogger != null) {
      handlers = currentLogger.getHandlers();
      currentLogger = currentLogger.getParent();
    }
    if (handlers.length == 0) {
      handlers = new Handler[1];
      handlers[0] = new ConsoleHandler();
    }
    customLogHandler = new StreamHandler(logCapturingStream, handlers[0].getFormatter());
    useParentHandlers = log.getUseParentHandlers();
    log.setUseParentHandlers(false);
    log.addHandler(customLogHandler);
  }

  private String getTestCapturedLog() {
    customLogHandler.flush();
    return logCapturingStream.toString();
  }

  @AfterClass
  public static void resetUseParentHandlers() {
    if (useParentHandlers) {
      log.setUseParentHandlers(true);
    }
  }

  @Test
  public void testRemoveConnectionOptionsNotRegistered() {
    attachLogCapturer();
    final String expectedLogPart = "There is no Spanner registered for ConnectionOptions";
    SpannerPool pool = createSubjectAndMocks();
    pool.getSpanner(options1, connection1);
    pool.removeConnection(options2, connection1);
    String capturedLog = getTestCapturedLog();
    assertThat(capturedLog.contains(expectedLogPart)).isTrue();
  }

  @Test
  public void testRemoveConnectionConnectionNotRegistered() {
    attachLogCapturer();
    final String expectedLogPart = "There are no connections registered for ConnectionOptions";
    SpannerPool pool = createSubjectAndMocks();
    pool.getSpanner(options1, connection1);
    pool.removeConnection(options1, connection2);
    String capturedLog = getTestCapturedLog();
    assertThat(capturedLog.contains(expectedLogPart)).isTrue();
  }

  @Test
  public void testRemoveConnectionConnectionAlreadyRemoved() {
    attachLogCapturer();
    final String expectedLogPart = "There are no connections registered for ConnectionOptions";
    SpannerPool pool = createSubjectAndMocks();
    pool.getSpanner(options1, connection1);
    pool.removeConnection(options1, connection1);
    pool.removeConnection(options1, connection1);
    String capturedLog = getTestCapturedLog();
    assertThat(capturedLog.contains(expectedLogPart)).isTrue();
  }

  @Test
  public void testCloseSpanner() {
    attachLogCapturer();
    SpannerPool pool = createSubjectAndMocks();
    Spanner spanner = pool.getSpanner(options1, connection1);
    // verify that closing is not possible until all connections have been removed
    boolean exception = false;
    try {
      pool.checkAndCloseSpanners();
    } catch (SpannerException e) {
      exception = e.getErrorCode() == ErrorCode.FAILED_PRECONDITION;
    }
    assertThat(exception).isTrue();

    // remove the connection and verify that it is possible to close
    pool.removeConnection(options1, connection1);
    pool.checkAndCloseSpanners();
    verify(spanner).close();

    final String expectedLogPart =
        "WARNING: There is/are 1 connection(s) still open. Close all connections before stopping"
            + " the application";
    Spanner spanner2 = pool.getSpanner(options1, connection1);
    pool.checkAndCloseSpanners(CheckAndCloseSpannersMode.WARN);
    String capturedLog = getTestCapturedLog();
    assertThat(capturedLog.contains(expectedLogPart)).isTrue();
    verify(spanner2, never()).close();

    // remove the connection and verify that it is possible to close
    pool.removeConnection(options1, connection1);
    pool.checkAndCloseSpanners(CheckAndCloseSpannersMode.WARN);
    verify(spanner2).close();
  }

  @Test
  public void testLeakedConnection() {
    attachLogCapturer();
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOptions(
                SessionPoolOptions.newBuilder()
                    .setMinSessions(0)
                    .setAutoDetectDialect(false)
                    .build())
            .setUri(URI)
            .build();
    DdlClient ddlClient = mock(DdlClient.class);
    DatabaseClient dbClient = mock(DatabaseClient.class);
    when(dbClient.getDialect()).thenReturn(Dialect.GOOGLE_STANDARD_SQL);
    // create an actual connection object but not in a try-with-resources block
    Connection connection =
        new ConnectionImpl(
            options, SpannerPool.INSTANCE, ddlClient, dbClient, mock(BatchClient.class));
    // try to close the application which should fail
    try {
      ConnectionOptions.closeSpanner();
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.FAILED_PRECONDITION);
    }
    String capturedLog = getTestCapturedLog();
    assertThat(capturedLog.contains(LeakedConnectionException.class.getName())).isTrue();
    assertThat(capturedLog.contains("testLeakedConnection")).isTrue();
    // Now close the connection to avoid trouble with other test cases.
    connection.close();
  }

  @Test
  public void testCloseUnusedSpanners() {
    SpannerPool pool = createSubjectAndMocks();
    Spanner spanner1;
    Spanner spanner2;
    Spanner spanner3;

    // create two connections that use the same Spanner
    spanner1 = pool.getSpanner(options1, connection1);
    spanner2 = pool.getSpanner(options1, connection2);
    assertThat(spanner1).isEqualTo(spanner2);

    // all spanners are in use, this should have no effect
    pool.closeUnusedSpanners(-1L);
    verify(spanner1, never()).close();

    // close one connection. This should also have no effect.
    pool.removeConnection(options1, connection1);
    pool.closeUnusedSpanners(-1L);
    verify(spanner1, never()).close();

    // close the other connection as well, the Spanner object should now be closed.
    pool.removeConnection(options1, connection2);
    pool.closeUnusedSpanners(-1L);
    verify(spanner1).close();

    // create three connections that use two different Spanners
    spanner1 = pool.getSpanner(options1, connection1);
    spanner2 = pool.getSpanner(options2, connection2);
    spanner3 = pool.getSpanner(options2, connection3);
    assertThat(spanner1).isNotEqualTo(spanner2);
    assertThat(spanner2).isEqualTo(spanner3);

    // all spanners are in use, this should have no effect
    pool.closeUnusedSpanners(-1L);
    verify(spanner1, never()).close();
    verify(spanner2, never()).close();
    verify(spanner3, never()).close();

    // close connection1. That should also mark spanner1 as no longer in use
    pool.removeConnection(options1, connection1);
    pool.closeUnusedSpanners(-1L);
    verify(spanner1).close();
    verify(spanner2, never()).close();
    verify(spanner3, never()).close();

    // close connection2. That should have no effect, as connection3 is still using spanner2
    pool.removeConnection(options2, connection2);
    pool.closeUnusedSpanners(-1L);
    verify(spanner1).close();
    verify(spanner2, never()).close();
    verify(spanner3, never()).close();

    // close connection3. Now all should be closed.
    pool.removeConnection(options2, connection3);
    pool.closeUnusedSpanners(-1L);
    verify(spanner1).close();
    verify(spanner2).close();
    verify(spanner3).close();
  }

  private static final long TEST_AUTOMATIC_CLOSE_TIMEOUT_MILLIS = 60_000L;
  private static final long TEST_AUTOMATIC_CLOSE_TIMEOUT_NANOS =
      TimeUnit.NANOSECONDS.convert(TEST_AUTOMATIC_CLOSE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
  private static final long MILLISECOND = TimeUnit.NANOSECONDS.convert(1L, TimeUnit.MILLISECONDS);

  @Test
  public void testAutomaticCloser() {
    FakeTicker ticker = new FakeTicker();
    SpannerPool pool = createSubjectAndMocks(TEST_AUTOMATIC_CLOSE_TIMEOUT_MILLIS, ticker);
    Spanner spanner1;
    Spanner spanner2;
    Spanner spanner3;

    // create two connections that use the same Spanner
    spanner1 = pool.getSpanner(options1, connection1);
    spanner2 = pool.getSpanner(options1, connection2);
    assertThat(spanner1).isEqualTo(spanner2);

    // all spanners are in use, this should have no effect
    ticker.advance(TEST_AUTOMATIC_CLOSE_TIMEOUT_NANOS + MILLISECOND);
    pool.closeUnusedSpanners(TEST_AUTOMATIC_CLOSE_TIMEOUT_MILLIS);
    verify(spanner1, never()).close();

    // close one connection. This should also have no effect.
    pool.removeConnection(options1, connection1);
    ticker.advance(TEST_AUTOMATIC_CLOSE_TIMEOUT_NANOS + MILLISECOND);
    pool.closeUnusedSpanners(TEST_AUTOMATIC_CLOSE_TIMEOUT_MILLIS);
    verify(spanner1, never()).close();

    // close the other connection as well, the Spanner object should now be closed.
    pool.removeConnection(options1, connection2);
    ticker.advance(TEST_AUTOMATIC_CLOSE_TIMEOUT_NANOS + MILLISECOND);
    pool.closeUnusedSpanners(TEST_AUTOMATIC_CLOSE_TIMEOUT_MILLIS);
    verify(spanner1).close();

    // create three connections that use two different Spanners
    spanner1 = pool.getSpanner(options1, connection1);
    spanner2 = pool.getSpanner(options2, connection2);
    spanner3 = pool.getSpanner(options2, connection3);
    assertThat(spanner1).isNotEqualTo(spanner2);
    assertThat(spanner2).isEqualTo(spanner3);

    // all spanners are in use, this should have no effect
    ticker.advance(TEST_AUTOMATIC_CLOSE_TIMEOUT_NANOS + MILLISECOND);
    pool.closeUnusedSpanners(TEST_AUTOMATIC_CLOSE_TIMEOUT_MILLIS);
    verify(spanner1, never()).close();
    verify(spanner2, never()).close();
    verify(spanner3, never()).close();

    // close connection1. That should also mark spanner1 as no longer in use
    pool.removeConnection(options1, connection1);
    ticker.advance(TEST_AUTOMATIC_CLOSE_TIMEOUT_NANOS + MILLISECOND);
    pool.closeUnusedSpanners(TEST_AUTOMATIC_CLOSE_TIMEOUT_MILLIS);
    verify(spanner1).close();
    verify(spanner2, never()).close();
    verify(spanner3, never()).close();

    // close connection2. That should have no effect, as connection3 is still using spanner2
    pool.removeConnection(options2, connection2);
    ticker.advance(TEST_AUTOMATIC_CLOSE_TIMEOUT_NANOS + MILLISECOND);
    pool.closeUnusedSpanners(TEST_AUTOMATIC_CLOSE_TIMEOUT_MILLIS);
    verify(spanner1).close();
    verify(spanner2, never()).close();
    verify(spanner3, never()).close();

    // close connection3. Now all should be closed.
    pool.removeConnection(options2, connection3);
    ticker.advance(TEST_AUTOMATIC_CLOSE_TIMEOUT_NANOS + MILLISECOND);
    pool.closeUnusedSpanners(TEST_AUTOMATIC_CLOSE_TIMEOUT_MILLIS);
    verify(spanner1).close();
    verify(spanner2).close();
    verify(spanner3).close();
  }

  @Test
  public void testSpannerPoolKeyEquality() {
    ConnectionOptions options1 =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner://localhost:9010/projects/p1/instances/i/databases/d"
                    + "?minSessions=200;maxSessions=400;numChannels=8;usePlainText=true;userAgent=test-agent")
            .setCredentials(mock(Credentials.class))
            .build();
    // options2 equals the default session pool options, and is therefore equal to ConnectionOptions
    // without any session pool configuration.
    ConnectionOptions options2 =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/p/instances/i/databases/d?minSessions=100;maxSessions=400")
            .setCredentials(NoCredentials.getInstance())
            .build();
    ConnectionOptions options3 =
        ConnectionOptions.newBuilder()
            .setUri("cloudspanner:/projects/p/instances/i/databases/d")
            .setCredentials(NoCredentials.getInstance())
            .build();
    // Not passing in routeToLeader in Connection URI is equivalent to passing it as true,
    // as routeToLeader is true by default.
    ConnectionOptions options4 =
        ConnectionOptions.newBuilder()
            .setUri("cloudspanner:/projects/p/instances/i/databases/d?routeToLeader=true")
            .setCredentials(NoCredentials.getInstance())
            .build();
    ConnectionOptions options5 =
        ConnectionOptions.newBuilder()
            .setUri("cloudspanner:/projects/p/instances/i/databases/d?routeToLeader=false")
            .setCredentials(NoCredentials.getInstance())
            .build();

    SpannerPoolKey key1 = SpannerPoolKey.of(options1);
    SpannerPoolKey key2 = SpannerPoolKey.of(options2);
    SpannerPoolKey key3 = SpannerPoolKey.of(options3);
    SpannerPoolKey key4 = SpannerPoolKey.of(options4);
    SpannerPoolKey key5 = SpannerPoolKey.of(options5);

    assertNotEquals(key1, key2);
    assertEquals(key2, key3);
    assertNotEquals(key1, key3);
    assertNotEquals(key1, new Object());
    assertEquals(key3, key4);
    assertNotEquals(key4, key5);
  }

  @Test
  public void testEnableApiTracing() {
    SpannerPoolKey keyWithoutApiTracingConfig =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri("cloudspanner:/projects/p/instances/i/databases/d")
                .setCredentials(NoCredentials.getInstance())
                .build());
    SpannerPoolKey keyWithApiTracingEnabled =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri("cloudspanner:/projects/p/instances/i/databases/d?enableApiTracing=true")
                .setCredentials(NoCredentials.getInstance())
                .build());
    SpannerPoolKey keyWithApiTracingDisabled =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri("cloudspanner:/projects/p/instances/i/databases/d?enableApiTracing=false")
                .setCredentials(NoCredentials.getInstance())
                .build());

    assertNotEquals(keyWithoutApiTracingConfig, keyWithApiTracingEnabled);
    assertNotEquals(keyWithoutApiTracingConfig, keyWithApiTracingDisabled);
    assertNotEquals(keyWithApiTracingEnabled, keyWithApiTracingDisabled);

    assertEquals(
        keyWithApiTracingEnabled,
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri("cloudspanner:/projects/p/instances/i/databases/d?enableApiTracing=true")
                .setCredentials(NoCredentials.getInstance())
                .build()));
    assertEquals(
        keyWithApiTracingDisabled,
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri("cloudspanner:/projects/p/instances/i/databases/d?enableApiTracing=false")
                .setCredentials(NoCredentials.getInstance())
                .build()));
    assertEquals(
        keyWithoutApiTracingConfig,
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri("cloudspanner:/projects/p/instances/i/databases/d")
                .setCredentials(NoCredentials.getInstance())
                .build()));
  }

  @Test
  public void testEnableEndToEndTracing() {
    SpannerPoolKey keyWithoutApiTracingConfig =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri("cloudspanner:/projects/p/instances/i/databases/d")
                .setCredentials(NoCredentials.getInstance())
                .build());
    SpannerPoolKey keyWithApiTracingEnabled =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d?enableEndToEndTracing=true")
                .setCredentials(NoCredentials.getInstance())
                .build());
    SpannerPoolKey keyWithApiTracingDisabled =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d?enableEndToEndTracing=false")
                .setCredentials(NoCredentials.getInstance())
                .build());

    assertNotEquals(keyWithoutApiTracingConfig, keyWithApiTracingEnabled);
    assertEquals(keyWithoutApiTracingConfig, keyWithApiTracingDisabled);
    assertNotEquals(keyWithApiTracingEnabled, keyWithApiTracingDisabled);

    assertEquals(
        keyWithApiTracingEnabled,
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d?enableEndToEndTracing=true")
                .setCredentials(NoCredentials.getInstance())
                .build()));
    assertEquals(
        keyWithApiTracingDisabled,
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d?enableEndToEndTracing=false")
                .setCredentials(NoCredentials.getInstance())
                .build()));
    assertEquals(
        keyWithoutApiTracingConfig,
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri("cloudspanner:/projects/p/instances/i/databases/d")
                .setCredentials(NoCredentials.getInstance())
                .build()));
  }

  @Test
  public void testOpenTelemetry() {
    SpannerPool pool = createSubjectAndMocks();
    Spanner spanner1;
    Spanner spanner2;

    // assert equal
    spanner1 = pool.getSpanner(optionsOpenTelemetry1, connection1);
    spanner2 = pool.getSpanner(optionsOpenTelemetry2, connection2);
    assertEquals(spanner1, spanner2);

    // assert not equal
    spanner1 = pool.getSpanner(optionsOpenTelemetry1, connection1);
    spanner2 = pool.getSpanner(optionsOpenTelemetry3, connection2);
    assertNotEquals(spanner1, spanner2);
  }

  @Test
  public void testDynamicChannelPoolSettings() {
    SpannerPoolKey keyWithoutDcp =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri("cloudspanner:/projects/p/instances/i/databases/d")
                .setCredentials(NoCredentials.getInstance())
                .build());
    SpannerPoolKey keyWithDcpEnabled =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d?enableDynamicChannelPool=true")
                .setCredentials(NoCredentials.getInstance())
                .build());
    SpannerPoolKey keyWithDcpDisabled =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d?enableDynamicChannelPool=false")
                .setCredentials(NoCredentials.getInstance())
                .build());
    SpannerPoolKey keyWithDcpAndMinChannels =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d?enableDynamicChannelPool=true;dcpMinChannels=3")
                .setCredentials(NoCredentials.getInstance())
                .build());
    SpannerPoolKey keyWithDcpAndMaxChannels =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d?enableDynamicChannelPool=true;dcpMaxChannels=15")
                .setCredentials(NoCredentials.getInstance())
                .build());
    SpannerPoolKey keyWithDcpAndInitialChannels =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d?enableDynamicChannelPool=true;dcpInitialChannels=5")
                .setCredentials(NoCredentials.getInstance())
                .build());

    // DCP settings should affect the SpannerPoolKey
    assertNotEquals(keyWithoutDcp, keyWithDcpEnabled);
    assertNotEquals(keyWithoutDcp, keyWithDcpDisabled);
    assertNotEquals(keyWithDcpEnabled, keyWithDcpDisabled);

    // Different channel settings should create different keys
    assertNotEquals(keyWithDcpEnabled, keyWithDcpAndMinChannels);
    assertNotEquals(keyWithDcpEnabled, keyWithDcpAndMaxChannels);
    assertNotEquals(keyWithDcpEnabled, keyWithDcpAndInitialChannels);

    // Same configuration should create equal keys
    assertEquals(
        keyWithDcpEnabled,
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d?enableDynamicChannelPool=true")
                .setCredentials(NoCredentials.getInstance())
                .build()));
    assertEquals(
        keyWithDcpAndMinChannels,
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d?enableDynamicChannelPool=true;dcpMinChannels=3")
                .setCredentials(NoCredentials.getInstance())
                .build()));
  }

  @Test
  public void testDynamicChannelPoolWithAllSettings() {
    SpannerPoolKey keyWithAllDcpSettings =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d"
                        + "?enableDynamicChannelPool=true;dcpMinChannels=3;dcpMaxChannels=15;dcpInitialChannels=5")
                .setCredentials(NoCredentials.getInstance())
                .build());
    SpannerPoolKey keyWithDifferentMaxChannels =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d"
                        + "?enableDynamicChannelPool=true;dcpMinChannels=3;dcpMaxChannels=20;dcpInitialChannels=5")
                .setCredentials(NoCredentials.getInstance())
                .build());

    assertNotEquals(keyWithAllDcpSettings, keyWithDifferentMaxChannels);

    // Same configuration should be equal
    assertEquals(
        keyWithAllDcpSettings,
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d"
                        + "?enableDynamicChannelPool=true;dcpMinChannels=3;dcpMaxChannels=15;dcpInitialChannels=5")
                .setCredentials(NoCredentials.getInstance())
                .build()));
  }

  @Test
  public void testExplicitlyDisabledDynamicChannelPool() {
    SpannerPoolKey keyWithoutDcpSetting =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri("cloudspanner:/projects/p/instances/i/databases/d")
                .setCredentials(NoCredentials.getInstance())
                .build());
    SpannerPoolKey keyWithDcpExplicitlyDisabled =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d?enableDynamicChannelPool=false")
                .setCredentials(NoCredentials.getInstance())
                .build());

    // Keys should be different because one has explicit false and one has null (default)
    assertNotEquals(keyWithoutDcpSetting, keyWithDcpExplicitlyDisabled);

    // Verify the explicit false setting is preserved
    assertEquals(
        keyWithDcpExplicitlyDisabled,
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d?enableDynamicChannelPool=false")
                .setCredentials(NoCredentials.getInstance())
                .build()));
  }
}
