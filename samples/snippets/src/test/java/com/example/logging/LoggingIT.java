/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.logging;

import static com.google.cloud.logging.testing.RemoteLoggingHelper.formatForTest;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.HttpRequest;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Payload.StringPayload;
import com.google.cloud.logging.Synchronicity;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for quickstart sample. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class LoggingIT {

  private static final String TEST_LOG = formatForTest("test-log");
  private static final String GOOGLEAPIS_AUDIT_LOGNAME = "cloudaudit.googleapis.com%2Factivity";
  private static final String STRING_PAYLOAD = "Hello, world!";
  private static final String STRING_PAYLOAD2 = "Hello world again";

  private ByteArrayOutputStream bout;
  private PrintStream out;
  private Logging logging = LoggingOptions.getDefaultInstance().getService();

  private void deleteLog(String logName) {
    logging.deleteLog(logName);
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    // Clean up created logs
    deleteLog(TEST_LOG);
    System.setOut(null);
  }

  @Test
  public void testQuickstartSample() throws Exception {
    QuickstartSample.main(TEST_LOG);
    String got = bout.toString();
    assertThat(got).contains(String.format("Logged: %s", STRING_PAYLOAD));
  }

  @Test(timeout = 60000)
  public void testListLogEntriesSample() throws Exception {
    // write a log entry
    LogEntry entry =
        LogEntry.newBuilder(StringPayload.of(STRING_PAYLOAD2))
            .setLogName(TEST_LOG)
            .setResource(MonitoredResource.newBuilder("global").build())
            .build();
    logging.setWriteSynchronicity(Synchronicity.SYNC);
    logging.write(Collections.singleton(entry));
    // flush out log immediately
    logging.flush();
    bout.reset();

    // Check for mocked STDOUT having data
    String[] args = new String[] {TEST_LOG};
    while (bout.toString().isEmpty()) {
      ListLogEntries.main(args);
      Thread.sleep(5000);
    }
    assertThat(bout.toString().contains(STRING_PAYLOAD2)).isTrue();
  }

  @Test(timeout = 60000)
  public void testWriteLogHttpRequestSample() throws Exception {
    HttpRequest request =
        HttpRequest.newBuilder()
            .setRequestUrl("www.example.com")
            .setRequestMethod(HttpRequest.RequestMethod.GET)
            .setStatus(200)
            .build();
    LogEntryWriteHttpRequest.createLogEntryRequest(TEST_LOG, STRING_PAYLOAD, request);
    String got = bout.toString();

    // Check weather log entry is logged or not
    assertThat(got).contains(String.format("Logged: %s", STRING_PAYLOAD));
    bout.reset();

    // Check for mocked STDOUT having data
    String[] args = new String[] {TEST_LOG};
    while (bout.toString().isEmpty()) {
      ListLogEntries.main(args);
      Thread.sleep(5000);
    }

    // check log entry contain request data
    assertThat(bout.toString().contains(STRING_PAYLOAD)).isTrue();
    assertThat(bout.toString().contains(request.toString())).isTrue();
  }

  @Test(timeout = 60000)
  public void testListLogNamesSample() throws Exception {
    ListLogs.main();
    // Check for mocked STDOUT having data
    while (bout.toString().isEmpty()) {
      Thread.sleep(5000);
    }

    assertThat(bout.toString().contains(GOOGLEAPIS_AUDIT_LOGNAME)).isTrue();
  }

  @Test(timeout = 60000)
  public void testTailLogEntriesSample() throws Exception {
    Runnable task =
        () -> {
          // wait 10 seconds to allow establishing tail stream in the sample
          try {
            Thread.sleep(10_000);
            try (Logging logging = LoggingOptions.getDefaultInstance().getService()) {
              // create an instance of LogEntry with HTTP request
              LogEntry logEntry =
                  LogEntry.newBuilder(StringPayload.of(STRING_PAYLOAD))
                      .setLogName(TEST_LOG)
                      .setResource(MonitoredResource.newBuilder("global").build())
                      .build();
              // Writes the log entry asynchronously
              logging.write(Collections.singleton(logEntry));
            }
          } catch (Exception t) {
            System.out.println("Failed to write log entry:\n" + t);
          }
        };
    Thread thread = new Thread(task);
    thread.start();

    TailLogEntries.main(new String[] {TEST_LOG});

    // Check for mocked STDOUT having data
    while (bout.toString().isEmpty()) {
      Thread.sleep(1000);
    }
    assertThat(bout.toString().contains(STRING_PAYLOAD)).isTrue();
  }
}
