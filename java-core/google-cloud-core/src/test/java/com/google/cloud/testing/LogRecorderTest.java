/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.testing;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.truth.Truth;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

public class LogRecorderTest {

  private static final String LOG_LINES =
      "INFO: log line 1\n" + "log line 2\n" + "FINE: log line 3\n";
  private final TestLogger testLogger = new TestLogger();
  private final LogRecorder logRecorder = new LogRecorder(testLogger);

  @Test
  public void shouldAggregateLogs() {
    for (String logLine : LOG_LINES.split("\n")) {
      logRecorder.record(logLine);
    }
    logRecorder.flush();

    assertThat(testLogger.logs.get(Level.INFO).iterator().next())
        .isEqualTo(
            "log line 1"
                + System.lineSeparator()
                + "log line 2"
                + System.lineSeparator()
                + "log line 3"
                + System.lineSeparator());
  }

  @Test
  public void shouldBeEmptyAfterFlushCall() {
    for (String logLine : LOG_LINES.split("\n")) {
      logRecorder.record(logLine);
    }
    // first flush and assertion
    logRecorder.flush();
    assertThat(testLogger.logs.get(Level.INFO).iterator().next())
        .isEqualTo(
            "log line 1"
                + System.lineSeparator()
                + "log line 2"
                + System.lineSeparator()
                + "log line 3"
                + System.lineSeparator());

    // second flush and assertion
    testLogger.reset();
    logRecorder.flush();
    Truth.assertThat(testLogger.logs.get(Level.INFO)).isEmpty();
  }

  private static final class TestLogger extends Logger {

    private Multimap<Level, String> logs = LinkedHashMultimap.create();

    private TestLogger() {
      super("text-logger", null);
    }

    public void log(Level level, String msg) {
      logs.put(level, msg);
    }

    public void reset() {
      this.logs = LinkedHashMultimap.create();
    }

    Multimap<Level, String> getLogs() {
      return logs;
    }
  }
}
