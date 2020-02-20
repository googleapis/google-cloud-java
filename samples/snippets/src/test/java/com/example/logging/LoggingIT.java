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

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Payload.StringPayload;
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

  private static final String QUICKSTART_LOG = "my-log";
  private static final String TEST_WRITE_LOG = "test-log";

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
    deleteLog(QUICKSTART_LOG);
    deleteLog(TEST_WRITE_LOG);

    System.setOut(null);
  }

  @Test
  public void testQuickstart() throws Exception {
    QuickstartSample.main(QUICKSTART_LOG);
    String got = bout.toString();
    assertThat(got).contains("Logged: Hello, world!");
  }

  @Test(timeout = 60000)
  public void testWriteAndListLogs() throws Exception {
    // write a log entry
    LogEntry entry =
        LogEntry.newBuilder(StringPayload.of("Hello world again"))
            .setLogName(TEST_WRITE_LOG)
            .setResource(MonitoredResource.newBuilder("global").build())
            .build();
    logging.write(Collections.singleton(entry));
    // flush out log immediately
    logging.flush();
    bout.reset();
    // Check if the log is listed yet
    while (bout.toString().isEmpty()) {
      ListLogs.main(TEST_WRITE_LOG);
      Thread.sleep(5000);
    }
    assertThat(bout.toString().contains("Hello world again")).isTrue();
  }
}
