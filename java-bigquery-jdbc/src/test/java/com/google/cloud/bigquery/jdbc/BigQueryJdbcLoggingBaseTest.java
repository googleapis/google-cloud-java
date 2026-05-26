/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigquery.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BigQueryJdbcLoggingBaseTest extends BigQueryJdbcBaseTest {

  protected List<LogRecord> capturedLogs = new ArrayList<>();
  private Handler handler;
  private Logger logger;
  private long threadId;

  @BeforeEach
  public void setUpLogValidator() {
    logger = BigQueryJdbcRootLogger.getRootLogger();
    capturedLogs.clear();
    threadId = Thread.currentThread().getId();
    handler =
        new Handler() {
          @Override
          public void publish(LogRecord record) {
            if (record.getThreadID() == threadId) {
              capturedLogs.add(record);
            }
          }

          @Override
          public void flush() {}

          @Override
          public void close() throws SecurityException {}
        };
    logger.addHandler(handler);
  }

  @AfterEach
  public void tearDownLogValidator() {
    if (logger != null && handler != null) {
      logger.removeHandler(handler);
    }
  }

  protected boolean assertLogContains(String snippet) {
    return capturedLogs.stream().anyMatch(r -> r.getMessage().contains(snippet));
  }
}
