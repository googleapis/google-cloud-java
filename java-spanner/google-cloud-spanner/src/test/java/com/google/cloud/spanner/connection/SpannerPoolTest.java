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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import com.google.auth.Credentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.BatchClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SessionPoolOptions;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.connection.ConnectionImpl.LeakedConnectionException;
import com.google.cloud.spanner.connection.SpannerPool.CheckAndCloseSpannersMode;
import com.google.cloud.spanner.connection.SpannerPool.CredentialsKey;
import com.google.cloud.spanner.connection.SpannerPool.SpannerPoolKey;
import com.google.cloud.spanner.omni.SpannerOmniCredentials;
import com.google.common.base.Ticker;
import com.google.common.io.BaseEncoding;
import com.google.common.io.Files;
import com.google.common.testing.FakeTicker;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
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
            .setCredentials(mock(Credentials.class, withSettings().withoutAnnotations()))
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
  public void testDynamicChannelPoolWithNewSettings() {
    SpannerPoolKey keyWithNewDcpSettings =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d"
                        + "?enableDynamicChannelPool=true;dcpMinRpcPerChannel=10;dcpMaxRpcPerChannel=100;dcpConcurrentStreamsLowWatermark=5")
                .setCredentials(NoCredentials.getInstance())
                .build());
    SpannerPoolKey keyWithDifferentMinRpc =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d"
                        + "?enableDynamicChannelPool=true;dcpMinRpcPerChannel=20;dcpMaxRpcPerChannel=100;dcpConcurrentStreamsLowWatermark=5")
                .setCredentials(NoCredentials.getInstance())
                .build());

    assertNotEquals(keyWithNewDcpSettings, keyWithDifferentMinRpc);

    // Same configuration should be equal
    assertEquals(
        keyWithNewDcpSettings,
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d"
                        + "?enableDynamicChannelPool=true;dcpMinRpcPerChannel=10;dcpMaxRpcPerChannel=100;dcpConcurrentStreamsLowWatermark=5")
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

  @Test
  public void testGrpcGcpSettings() {
    SpannerPoolKey keyWithoutGrpcGcp =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri("cloudspanner:/projects/p/instances/i/databases/d")
                .setCredentials(NoCredentials.getInstance())
                .build());
    SpannerPoolKey keyWithGrpcGcpEnabled =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri("cloudspanner:/projects/p/instances/i/databases/d?enableGrpcGcp=true")
                .setCredentials(NoCredentials.getInstance())
                .build());
    SpannerPoolKey keyWithGrpcGcpDisabled =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri("cloudspanner:/projects/p/instances/i/databases/d?enableGrpcGcp=false")
                .setCredentials(NoCredentials.getInstance())
                .build());

    // grpcGcp settings should affect the SpannerPoolKey
    assertNotEquals(keyWithoutGrpcGcp, keyWithGrpcGcpEnabled);
    assertNotEquals(keyWithoutGrpcGcp, keyWithGrpcGcpDisabled);
    assertNotEquals(keyWithGrpcGcpEnabled, keyWithGrpcGcpDisabled);

    // Same configuration should create equal keys
    assertEquals(
        keyWithGrpcGcpEnabled,
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri("cloudspanner:/projects/p/instances/i/databases/d?enableGrpcGcp=true")
                .setCredentials(NoCredentials.getInstance())
                .build()));
    assertEquals(
        keyWithGrpcGcpDisabled,
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri("cloudspanner:/projects/p/instances/i/databases/d?enableGrpcGcp=false")
                .setCredentials(NoCredentials.getInstance())
                .build()));
  }

  @Test
  public void testCertificateAndTrustSettings() {
    SpannerPoolKey keyDefault =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri("cloudspanner:/projects/p/instances/i/databases/d")
                .setCredentials(NoCredentials.getInstance())
                .build());
    SpannerPoolKey keyWithTrustCert1 =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d?caCertificate=/path/to/ca1.crt")
                .setCredentials(NoCredentials.getInstance())
                .build());
    SpannerPoolKey keyWithTrustCert2 =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d?caCertificate=/path/to/ca2.crt")
                .setCredentials(NoCredentials.getInstance())
                .build());
    SpannerPoolKey keyWithClientCert =
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d"
                        + "?clientCertificate=/path/to/client.crt;clientKey=/path/to/client.key;caCertificate=/path/to/ca1.crt")
                .setCredentials(NoCredentials.getInstance())
                .build());

    assertNotEquals(keyDefault, keyWithTrustCert1);
    assertNotEquals(keyWithTrustCert1, keyWithTrustCert2);
    assertNotEquals(keyWithTrustCert1, keyWithClientCert);

    assertEquals(
        keyWithTrustCert1,
        SpannerPoolKey.of(
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/p/instances/i/databases/d?caCertificate=/path/to/ca1.crt")
                .setCredentials(NoCredentials.getInstance())
                .build()));
  }

  @Test
  public void testPartialClientCertThrowsException() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/p/instances/i/databases/d"
                    + "?clientCertificate=/path/to/client.crt")
            .setCredentials(NoCredentials.getInstance())
            .build();
    SpannerPoolKey key = SpannerPoolKey.of(options);
    assertThrows(
        IllegalArgumentException.class, () -> SpannerPool.INSTANCE.createSpanner(key, options));
  }

  @Test
  public void testPartialClientKeyThrowsException() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/p/instances/i/databases/d"
                    + "?clientKey=/path/to/client.key")
            .setCredentials(NoCredentials.getInstance())
            .build();
    SpannerPoolKey key = SpannerPoolKey.of(options);
    assertThrows(
        IllegalArgumentException.class, () -> SpannerPool.INSTANCE.createSpanner(key, options));
  }

  @Test
  public void testGetSpannerWithOmniCredentials() {
    SpannerPool pool = createSubjectAndMocks();

    ConnectionOptions optionsOmniAlice1 = mock(ConnectionOptions.class, withSettings().lenient());
    when(optionsOmniAlice1.getHost()).thenReturn("localhost:15000");
    when(optionsOmniAlice1.getProjectId()).thenReturn(SpannerOptions.SPANNER_OMNI_PROJECT_ID);
    when(optionsOmniAlice1.getInstanceType()).thenReturn(SpannerOptions.InstanceType.OMNI);
    SpannerOmniCredentials credentialsAlice1 =
        new SpannerOmniCredentials(
            "alice",
            SpannerOmniCredentials.convertToSecretBytes(new char[] {'p', 'a', 's', 's', '1'}),
            "localhost:15000");
    when(optionsOmniAlice1.getCredentials()).thenReturn(credentialsAlice1);

    ConnectionOptions optionsOmniAlice1Duplicate =
        mock(ConnectionOptions.class, withSettings().lenient());
    when(optionsOmniAlice1Duplicate.getHost()).thenReturn("localhost:15000");
    when(optionsOmniAlice1Duplicate.getProjectId())
        .thenReturn(SpannerOptions.SPANNER_OMNI_PROJECT_ID);
    when(optionsOmniAlice1Duplicate.getInstanceType()).thenReturn(SpannerOptions.InstanceType.OMNI);
    SpannerOmniCredentials credentialsAlice1Duplicate =
        new SpannerOmniCredentials(
            "alice",
            SpannerOmniCredentials.convertToSecretBytes(new char[] {'p', 'a', 's', 's', '1'}),
            "localhost:15000");
    when(optionsOmniAlice1Duplicate.getCredentials()).thenReturn(credentialsAlice1Duplicate);

    ConnectionOptions optionsOmniAliceWrongPassword =
        mock(ConnectionOptions.class, withSettings().lenient());
    when(optionsOmniAliceWrongPassword.getHost()).thenReturn("localhost:15000");
    when(optionsOmniAliceWrongPassword.getProjectId())
        .thenReturn(SpannerOptions.SPANNER_OMNI_PROJECT_ID);
    when(optionsOmniAliceWrongPassword.getInstanceType())
        .thenReturn(SpannerOptions.InstanceType.OMNI);
    SpannerOmniCredentials credentialsAliceWrongPassword =
        new SpannerOmniCredentials(
            "alice",
            SpannerOmniCredentials.convertToSecretBytes(new char[] {'w', 'r', 'o', 'n', 'g'}),
            "localhost:15000");
    when(optionsOmniAliceWrongPassword.getCredentials()).thenReturn(credentialsAliceWrongPassword);

    ConnectionOptions optionsOmniBob = mock(ConnectionOptions.class, withSettings().lenient());
    when(optionsOmniBob.getHost()).thenReturn("localhost:15000");
    when(optionsOmniBob.getProjectId()).thenReturn(SpannerOptions.SPANNER_OMNI_PROJECT_ID);
    when(optionsOmniBob.getInstanceType()).thenReturn(SpannerOptions.InstanceType.OMNI);
    SpannerOmniCredentials credentialsBob =
        new SpannerOmniCredentials(
            "bob",
            SpannerOmniCredentials.convertToSecretBytes(new char[] {'p', 'a', 's', 's', '1'}),
            "localhost:15000");
    when(optionsOmniBob.getCredentials()).thenReturn(credentialsBob);

    ConnectionOptions optionsOmniNoCredentials =
        mock(ConnectionOptions.class, withSettings().lenient());
    when(optionsOmniNoCredentials.getHost()).thenReturn("localhost:15000");
    when(optionsOmniNoCredentials.getProjectId())
        .thenReturn(SpannerOptions.SPANNER_OMNI_PROJECT_ID);
    when(optionsOmniNoCredentials.getInstanceType()).thenReturn(SpannerOptions.InstanceType.OMNI);
    when(optionsOmniNoCredentials.getCredentials()).thenReturn(NoCredentials.getInstance());

    // 1. Same user and password reuses the Spanner client.
    Spanner spannerAlice1 = pool.getSpanner(optionsOmniAlice1, connection1);
    Spanner spannerAlice1Duplicate = pool.getSpanner(optionsOmniAlice1Duplicate, connection2);
    assertEquals(spannerAlice1, spannerAlice1Duplicate);

    // 2. Same user with wrong password does NOT reuse the Spanner client (prevents auth bypass).
    Spanner spannerAliceWrongPassword = pool.getSpanner(optionsOmniAliceWrongPassword, connection3);
    assertNotEquals(spannerAlice1, spannerAliceWrongPassword);

    // 3. Different user does NOT reuse the Spanner client.
    Spanner spannerBob = pool.getSpanner(optionsOmniBob, connection1);
    assertNotEquals(spannerAlice1, spannerBob);
    assertNotEquals(spannerAliceWrongPassword, spannerBob);

    // 4. No credentials does NOT reuse the authenticated Spanner client.
    Spanner spannerNoCredentials = pool.getSpanner(optionsOmniNoCredentials, connection2);
    assertNotEquals(spannerAlice1, spannerNoCredentials);
  }

  @Test
  public void testGetSpannerWithEncodedCredentials() {
    SpannerPool pool = createSubjectAndMocks();

    ConnectionOptions optionsTenantA1 = mock(ConnectionOptions.class, withSettings().lenient());
    when(optionsTenantA1.getProjectId()).thenReturn("test-project-1");
    when(optionsTenantA1.getEncodedCredentialsHash()).thenReturn("encoded:hash_tenant_a");

    ConnectionOptions optionsTenantA2 = mock(ConnectionOptions.class, withSettings().lenient());
    when(optionsTenantA2.getProjectId()).thenReturn("test-project-1");
    when(optionsTenantA2.getEncodedCredentialsHash()).thenReturn("encoded:hash_tenant_a");

    ConnectionOptions optionsTenantB = mock(ConnectionOptions.class, withSettings().lenient());
    when(optionsTenantB.getProjectId()).thenReturn("test-project-1");
    when(optionsTenantB.getEncodedCredentialsHash()).thenReturn("encoded:hash_tenant_b");

    ConnectionOptions optionsDefaultCredentials =
        mock(ConnectionOptions.class, withSettings().lenient());
    when(optionsDefaultCredentials.getProjectId()).thenReturn("test-project-1");

    // 1. Same tenant with identical encodedCredentials shares the Spanner instance.
    Spanner spannerTenantA1 = pool.getSpanner(optionsTenantA1, connection1);
    Spanner spannerTenantA2 = pool.getSpanner(optionsTenantA2, connection2);
    assertEquals(spannerTenantA1, spannerTenantA2);

    // 2. Different tenant with different encodedCredentials gets a separate Spanner instance
    // (prevents cross-tenant credential reuse).
    Spanner spannerTenantB = pool.getSpanner(optionsTenantB, connection3);
    assertNotEquals(spannerTenantA1, spannerTenantB);

    // 3. Connection with default credentials does NOT reuse the tenant's Spanner instance.
    Spanner spannerDefault = pool.getSpanner(optionsDefaultCredentials, connection1);
    assertNotEquals(spannerTenantA1, spannerDefault);
    assertNotEquals(spannerTenantB, spannerDefault);
  }

  @Test
  public void testGetSpannerWithOAuthToken() {
    SpannerPool pool = createSubjectAndMocks();

    ConnectionOptions optionsOAuth1 = mock(ConnectionOptions.class, withSettings().lenient());
    when(optionsOAuth1.getProjectId()).thenReturn("test-project-1");
    when(optionsOAuth1.getOAuthTokenHash()).thenReturn("oauth:hash_token_1");

    ConnectionOptions optionsOAuth1Duplicate =
        mock(ConnectionOptions.class, withSettings().lenient());
    when(optionsOAuth1Duplicate.getProjectId()).thenReturn("test-project-1");
    when(optionsOAuth1Duplicate.getOAuthTokenHash()).thenReturn("oauth:hash_token_1");

    ConnectionOptions optionsOAuth2 = mock(ConnectionOptions.class, withSettings().lenient());
    when(optionsOAuth2.getProjectId()).thenReturn("test-project-1");
    when(optionsOAuth2.getOAuthTokenHash()).thenReturn("oauth:hash_token_2");

    // 1. Same OAuth token shares the Spanner instance.
    Spanner spanner1 = pool.getSpanner(optionsOAuth1, connection1);
    Spanner spanner1Duplicate = pool.getSpanner(optionsOAuth1Duplicate, connection2);
    assertEquals(spanner1, spanner1Duplicate);

    // 2. Different OAuth token gets a separate Spanner instance.
    Spanner spanner2 = pool.getSpanner(optionsOAuth2, connection3);
    assertNotEquals(spanner1, spanner2);
  }

  @Test
  public void testPoolKeyWithOmniCredentialsFromUri() {
    ConnectionOptions optionsAlice =
        ConnectionOptions.newBuilder()
            .setUri(
                "spanner://localhost:15000/projects/default/instances/default/databases/test-db"
                    + ";usePlainText=true;type=omni;username=alice;password=correct_password")
            .build();
    ConnectionOptions optionsAliceDuplicate =
        ConnectionOptions.newBuilder()
            .setUri(
                "spanner://localhost:15000/projects/default/instances/default/databases/test-db"
                    + ";usePlainText=true;type=omni;username=alice;password=correct_password")
            .build();
    ConnectionOptions optionsAliceWrongPassword =
        ConnectionOptions.newBuilder()
            .setUri(
                "spanner://localhost:15000/projects/default/instances/default/databases/test-db"
                    + ";usePlainText=true;type=omni;username=alice;password=wrong_password")
            .build();
    ConnectionOptions optionsBob =
        ConnectionOptions.newBuilder()
            .setUri(
                "spanner://localhost:15000/projects/default/instances/default/databases/test-db"
                    + ";usePlainText=true;type=omni;username=bob;password=correct_password")
            .build();
    ConnectionOptions optionsAliceHttps =
        ConnectionOptions.newBuilder()
            .setUri(
                "spanner://localhost:15000/projects/default/instances/default/databases/test-db"
                    + ";usePlainText=false;type=omni;username=alice;password=correct_password")
            .build();

    SpannerPoolKey keyAlice = SpannerPoolKey.of(optionsAlice);
    SpannerPoolKey keyAliceDuplicate = SpannerPoolKey.of(optionsAliceDuplicate);
    SpannerPoolKey keyAliceWrongPassword = SpannerPoolKey.of(optionsAliceWrongPassword);
    SpannerPoolKey keyBob = SpannerPoolKey.of(optionsBob);
    SpannerPoolKey keyAliceHttps = SpannerPoolKey.of(optionsAliceHttps);

    assertEquals(keyAlice, keyAliceDuplicate);
    assertEquals(keyAlice.hashCode(), keyAliceDuplicate.hashCode());

    assertNotEquals(keyAlice, keyAliceWrongPassword);
    assertNotEquals(keyAlice, keyBob);
    assertNotEquals(keyAliceWrongPassword, keyBob);
    assertNotEquals(keyAlice, keyAliceHttps);
  }

  @Test
  public void testPoolKeyWithOAuthTokenFromUri() {
    ConnectionOptions optionsToken1 =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?oauthToken=token1")
            .build();
    ConnectionOptions optionsToken1Duplicate =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?oauthToken=token1")
            .build();
    ConnectionOptions optionsToken2 =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?oauthToken=token2")
            .build();

    SpannerPoolKey key1 = SpannerPoolKey.of(optionsToken1);
    SpannerPoolKey key1Duplicate = SpannerPoolKey.of(optionsToken1Duplicate);
    SpannerPoolKey key2 = SpannerPoolKey.of(optionsToken2);

    assertEquals(key1, key1Duplicate);
    assertEquals(key1.hashCode(), key1Duplicate.hashCode());

    assertNotEquals(key1, key2);
  }

  @Test
  public void testPoolKeyWithEncodedCredentialsFromUri() throws Throwable {
    ConnectionOptionsTest.runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_ENCODED_CREDENTIALS_SYSTEM_PROPERTY,
        () -> {
          String key1Path = ConnectionOptionsTest.class.getResource("test-key.json").getFile();
          String key2Path =
              ConnectionOptionsTest.class.getResource("test-key-app-default.json").getFile();
          String encoded1 =
              BaseEncoding.base64Url().encode(Files.asByteSource(new File(key1Path)).read());
          String encoded2 =
              BaseEncoding.base64Url().encode(Files.asByteSource(new File(key2Path)).read());

          ConnectionOptions options1 =
              ConnectionOptions.newBuilder()
                  .setUri(
                      "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?encodedCredentials="
                          + encoded1)
                  .build();
          ConnectionOptions options1Duplicate =
              ConnectionOptions.newBuilder()
                  .setUri(
                      "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?encodedCredentials="
                          + encoded1)
                  .build();
          ConnectionOptions options2 =
              ConnectionOptions.newBuilder()
                  .setUri(
                      "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?encodedCredentials="
                          + encoded2)
                  .build();

          SpannerPoolKey poolKey1 = SpannerPoolKey.of(options1);
          SpannerPoolKey poolKey1Duplicate = SpannerPoolKey.of(options1Duplicate);
          SpannerPoolKey poolKey2 = SpannerPoolKey.of(options2);

          assertEquals(poolKey1, poolKey1Duplicate);
          assertEquals(poolKey1.hashCode(), poolKey1Duplicate.hashCode());

          assertNotEquals(poolKey1, poolKey2);
        });
  }

  @Test
  public void testCredentialsKeyWithNullCredentialsFromProvider() throws IOException {
    ConnectionOptions optionsWithNullProviderCredentials =
        mock(ConnectionOptions.class, withSettings().lenient());
    when(optionsWithNullProviderCredentials.getCredentialsProvider()).thenReturn(() -> null);
    when(optionsWithNullProviderCredentials.getCredentials()).thenReturn(null);

    ConnectionOptions defaultOptions = mock(ConnectionOptions.class, withSettings().lenient());

    CredentialsKey keyWithNullProvider = CredentialsKey.create(optionsWithNullProviderCredentials);
    CredentialsKey defaultKey = CredentialsKey.create(defaultOptions);

    assertEquals(defaultKey, keyWithNullProvider);
    assertEquals(defaultKey.hashCode(), keyWithNullProvider.hashCode());
  }
}
