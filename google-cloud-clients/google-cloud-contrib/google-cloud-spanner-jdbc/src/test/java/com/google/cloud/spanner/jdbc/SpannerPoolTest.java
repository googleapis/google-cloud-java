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

package com.google.cloud.spanner.jdbc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.jdbc.ConnectionImpl.LeakedConnectionException;
import com.google.cloud.spanner.jdbc.SpannerPool.CheckAndCloseSpannersMode;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
  private GoogleCredentials credentials1 = mock(GoogleCredentials.class);
  private GoogleCredentials credentials2 = mock(GoogleCredentials.class);
  private ConnectionOptions options1 = mock(ConnectionOptions.class);
  private ConnectionOptions options2 = mock(ConnectionOptions.class);
  private ConnectionOptions options3 = mock(ConnectionOptions.class);
  private ConnectionOptions options4 = mock(ConnectionOptions.class);

  private SpannerPool createSubjectAndMocks() {
    return createSubjectAndMocks(0L);
  }

  private SpannerPool createSubjectAndMocks(long closeSpannerAfterMillisecondsUnused) {
    SpannerPool pool =
        new SpannerPool(closeSpannerAfterMillisecondsUnused) {
          @Override
          Spanner createSpanner(SpannerPoolKey key) {
            return mock(Spanner.class);
          }
        };

    when(options1.getCredentials()).thenReturn(credentials1);
    when(options1.getProjectId()).thenReturn("test-project-1");
    when(options2.getCredentials()).thenReturn(credentials2);
    when(options2.getProjectId()).thenReturn("test-project-1");

    when(options3.getCredentials()).thenReturn(credentials1);
    when(options3.getProjectId()).thenReturn("test-project-2");
    when(options4.getCredentials()).thenReturn(credentials2);
    when(options4.getProjectId()).thenReturn("test-project-2");

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
    assertThat(spanner1, is(equalTo(spanner2)));
    spanner1 = pool.getSpanner(options2, connection1);
    spanner2 = pool.getSpanner(options2, connection2);
    assertThat(spanner1, is(equalTo(spanner2)));
    spanner1 = pool.getSpanner(options3, connection1);
    spanner2 = pool.getSpanner(options3, connection2);
    assertThat(spanner1, is(equalTo(spanner2)));
    spanner1 = pool.getSpanner(options4, connection1);
    spanner2 = pool.getSpanner(options4, connection2);
    assertThat(spanner1, is(equalTo(spanner2)));

    // assert not equal
    spanner1 = pool.getSpanner(options1, connection1);
    spanner2 = pool.getSpanner(options2, connection2);
    assertThat(spanner1, not(equalTo(spanner2)));
    spanner1 = pool.getSpanner(options1, connection1);
    spanner2 = pool.getSpanner(options3, connection2);
    assertThat(spanner1, not(equalTo(spanner2)));
    spanner1 = pool.getSpanner(options1, connection1);
    spanner2 = pool.getSpanner(options4, connection2);
    assertThat(spanner1, not(equalTo(spanner2)));
    spanner1 = pool.getSpanner(options2, connection1);
    spanner2 = pool.getSpanner(options3, connection2);
    assertThat(spanner1, not(equalTo(spanner2)));
    spanner1 = pool.getSpanner(options2, connection1);
    spanner2 = pool.getSpanner(options4, connection2);
    assertThat(spanner1, not(equalTo(spanner2)));
    spanner1 = pool.getSpanner(options3, connection1);
    spanner2 = pool.getSpanner(options4, connection2);
    assertThat(spanner1, not(equalTo(spanner2)));
  }

  @Test
  public void testRemoveConnection() {
    SpannerPool pool = createSubjectAndMocks();
    Spanner spanner1;
    Spanner spanner2;

    // assert equal
    spanner1 = pool.getSpanner(options1, connection1);
    spanner2 = pool.getSpanner(options1, connection2);
    assertThat(spanner1, is(equalTo(spanner2)));
    // one connection removed, assert that we would still get the same Spanner
    pool.removeConnection(options1, connection1);
    spanner1 = pool.getSpanner(options1, connection1);
    assertThat(spanner1, is(equalTo(spanner2)));
    // remove two connections, assert that we would still get the same Spanner, as Spanners are not
    // directly closed and removed.
    pool.removeConnection(options1, connection1);
    pool.removeConnection(options1, connection2);
    spanner1 = pool.getSpanner(options1, connection1);
    assertThat(spanner1, is(equalTo(spanner2)));
    // remove the last connection again
    pool.removeConnection(options1, connection1);
  }

  private static Logger log = Logger.getLogger(SpannerPool.class.getName());
  private static OutputStream logCapturingStream;
  private static StreamHandler customLogHandler;

  private void attachLogCapturer() {
    logCapturingStream = new ByteArrayOutputStream();
    Logger currentLogger = log;
    Handler[] handlers = new Handler[0];
    while (handlers.length == 0 && currentLogger != null) {
      handlers = currentLogger.getHandlers();
      currentLogger = currentLogger.getParent();
    }
    if (handlers.length == 0) {
      throw new IllegalStateException("no handlers found for logger");
    }
    customLogHandler = new StreamHandler(logCapturingStream, handlers[0].getFormatter());
    log.addHandler(customLogHandler);
  }

  public String getTestCapturedLog() throws IOException {
    customLogHandler.flush();
    return logCapturingStream.toString();
  }

  @Test
  public void testRemoveConnectionOptionsNotRegistered() throws IOException {
    attachLogCapturer();
    final String expectedLogPart = "There is no Spanner registered for ConnectionOptions";
    SpannerPool pool = createSubjectAndMocks();
    pool.getSpanner(options1, connection1);
    pool.removeConnection(options2, connection1);
    String capturedLog = getTestCapturedLog();
    assertThat(capturedLog.contains(expectedLogPart), is(true));
  }

  @Test
  public void testRemoveConnectionConnectionNotRegistered() throws IOException {
    attachLogCapturer();
    final String expectedLogPart = "There are no connections registered for ConnectionOptions";
    SpannerPool pool = createSubjectAndMocks();
    pool.getSpanner(options1, connection1);
    pool.removeConnection(options1, connection2);
    String capturedLog = getTestCapturedLog();
    assertThat(capturedLog.contains(expectedLogPart), is(true));
  }

  @Test
  public void testRemoveConnectionConnectionAlreadyRemoved() throws IOException {
    attachLogCapturer();
    final String expectedLogPart = "There are no connections registered for ConnectionOptions";
    SpannerPool pool = createSubjectAndMocks();
    pool.getSpanner(options1, connection1);
    pool.removeConnection(options1, connection1);
    pool.removeConnection(options1, connection1);
    String capturedLog = getTestCapturedLog();
    assertThat(capturedLog.contains(expectedLogPart), is(true));
  }

  @Test
  public void testCloseSpanner() throws IOException {
    SpannerPool pool = createSubjectAndMocks();
    Spanner spanner = pool.getSpanner(options1, connection1);
    // verify that closing is not possible until all connections have been removed
    boolean exception = false;
    try {
      pool.checkAndCloseSpanners();
    } catch (SpannerException e) {
      exception = e.getErrorCode() == ErrorCode.FAILED_PRECONDITION;
    }
    assertThat(exception, is(true));

    // remove the connection and verify that it is possible to close
    pool.removeConnection(options1, connection1);
    pool.checkAndCloseSpanners();
    verify(spanner).close();

    final String expectedLogPart =
        "WARNING: There is/are 1 connection(s) still open. Close all connections before stopping the application";
    Spanner spanner2 = pool.getSpanner(options1, connection1);
    pool.checkAndCloseSpanners(CheckAndCloseSpannersMode.WARN);
    String capturedLog = getTestCapturedLog();
    assertThat(capturedLog.contains(expectedLogPart), is(true));
    verify(spanner2, never()).close();

    // remove the connection and verify that it is possible to close
    pool.removeConnection(options1, connection1);
    pool.checkAndCloseSpanners(CheckAndCloseSpannersMode.WARN);
    verify(spanner2).close();
  }

  @Test
  public void testLeakedConnection() throws IOException {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setCredentials(NoCredentials.getInstance())
            .setUri(URI)
            .build();
    // create an actual connection object but not in a try-with-resources block
    Connection connection = options.getConnection();
    // try to close the application which should fail
    try {
      ConnectionOptions.closeSpanner();
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode(), is(equalTo(ErrorCode.FAILED_PRECONDITION)));
    }
    String capturedLog = getTestCapturedLog();
    assertThat(capturedLog.contains(LeakedConnectionException.class.getName()), is(true));
    assertThat(capturedLog.contains("testLeakedConnection"), is(true));
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
    assertThat(spanner1, is(equalTo(spanner2)));

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
    assertThat(spanner1, not(equalTo(spanner2)));
    assertThat(spanner2, is(equalTo(spanner3)));

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

  /** Allow the automatic close test to be run multiple times to ensure it is stable */
  private static final int NUMBER_OF_AUTOMATIC_CLOSE_TEST_RUNS = 1;

  private static final long TEST_AUTOMATIC_CLOSE_TIMEOUT = 2L;
  private static final long SLEEP_BEFORE_VERIFICATION = 100L;

  @Test
  public void testAutomaticCloser() throws InterruptedException {
    for (int testRun = 0; testRun < NUMBER_OF_AUTOMATIC_CLOSE_TEST_RUNS; testRun++) {
      // create a pool that will close unused spanners after 5 milliseconds
      SpannerPool pool = createSubjectAndMocks(TEST_AUTOMATIC_CLOSE_TIMEOUT);
      Spanner spanner1;
      Spanner spanner2;
      Spanner spanner3;

      // create two connections that use the same Spanner
      spanner1 = pool.getSpanner(options1, connection1);
      spanner2 = pool.getSpanner(options1, connection2);
      assertThat(spanner1, is(equalTo(spanner2)));

      // all spanners are in use, this should have no effect
      Thread.sleep(SLEEP_BEFORE_VERIFICATION);
      verify(spanner1, never()).close();

      // close one connection. This should also have no effect.
      pool.removeConnection(options1, connection1);
      Thread.sleep(SLEEP_BEFORE_VERIFICATION);
      verify(spanner1, never()).close();

      // close the other connection as well, the Spanner object should now be closed.
      pool.removeConnection(options1, connection2);
      Thread.sleep(SLEEP_BEFORE_VERIFICATION);
      verify(spanner1).close();

      // create three connections that use two different Spanners
      spanner1 = pool.getSpanner(options1, connection1);
      spanner2 = pool.getSpanner(options2, connection2);
      spanner3 = pool.getSpanner(options2, connection3);
      assertThat(spanner1, not(equalTo(spanner2)));
      assertThat(spanner2, is(equalTo(spanner3)));

      // all spanners are in use, this should have no effect
      Thread.sleep(SLEEP_BEFORE_VERIFICATION);
      verify(spanner1, never()).close();
      verify(spanner2, never()).close();
      verify(spanner3, never()).close();

      // close connection1. That should also mark spanner1 as no longer in use
      pool.removeConnection(options1, connection1);
      Thread.sleep(SLEEP_BEFORE_VERIFICATION);
      verify(spanner1).close();
      verify(spanner2, never()).close();
      verify(spanner3, never()).close();

      // close connection2. That should have no effect, as connection3 is still using spanner2
      pool.removeConnection(options2, connection2);
      Thread.sleep(SLEEP_BEFORE_VERIFICATION);
      verify(spanner1).close();
      verify(spanner2, never()).close();
      verify(spanner3, never()).close();

      // close connection3. Now all should be closed.
      pool.removeConnection(options2, connection3);
      Thread.sleep(SLEEP_BEFORE_VERIFICATION);
      verify(spanner1).close();
      verify(spanner2).close();
      verify(spanner3).close();
    }
  }
}
