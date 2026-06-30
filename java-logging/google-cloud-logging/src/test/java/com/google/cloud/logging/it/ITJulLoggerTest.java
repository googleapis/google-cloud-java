/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.logging.it;

import static com.google.cloud.logging.testing.RemoteLoggingHelper.formatForTest;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.BaseSystemTest;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.LoggingHandler;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Payload;
import com.google.cloud.logging.Severity;
import com.google.cloud.logging.Synchronicity;
import com.google.common.collect.ImmutableMap;
import com.google.logging.v2.LogName;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

public class ITJulLoggerTest extends BaseSystemTest {

  private static final String LOG_ID = formatForTest("test-jul-log-handler-log");

  @After
  public void tearDown() throws InterruptedException {
    assertTrue(cleanupLog(LOG_ID));
  }

  @Ignore
  @Test
  public void testLoggingHandler() throws InterruptedException {
    LoggingOptions options = logging.getOptions();
    LogName logName = LogName.ofProjectLogName(options.getProjectId(), LOG_ID);

    // Create a jul logger at with INFO level
    LoggingHandler handler = new LoggingHandler(LOG_ID, options);
    handler.setLevel(Level.INFO);
    Logger logger = Logger.getLogger(getClass().getName());
    logger.addHandler(handler);
    logger.setLevel(Level.INFO);

    // log a test message
    logger.info("Message");

    // Find the log name and wait until we have at least 1 entry
    Iterator<LogEntry> iterator = waitForLogs(logName);
    assertThat(iterator.hasNext()).isTrue();

    // Read the log entry
    LogEntry entry = iterator.next();
    assertThat(entry.getPayload() instanceof Payload.StringPayload).isTrue();
    assertThat(entry.<Payload.StringPayload>getPayload().getData()).contains("Message");
    assertThat(entry.getLogName()).isEqualTo(LOG_ID);
    assertThat(entry.getLabels())
        .containsExactly("levelName", "INFO", "levelValue", String.valueOf(Level.INFO.intValue()));

    assertThat(entry.getResource().getLabels()).containsEntry("project_id", options.getProjectId());
    assertThat(entry.getHttpRequest()).isNull();
    assertThat(entry.getSeverity()).isEqualTo(Severity.INFO);
    assertThat(entry.getOperation()).isNull();
    assertThat(entry.getInsertId()).isNotNull();
    assertThat(entry.getTimestamp()).isNotNull();
    logger.removeHandler(handler);
  }

  @Ignore
  @Test
  public void testSyncLoggingHandler() throws InterruptedException {
    LoggingOptions options = logging.getOptions();
    LogName logName = LogName.ofProjectLogName(options.getProjectId(), LOG_ID);
    MonitoredResource resource =
        MonitoredResource.of(
            "gce_instance",
            ImmutableMap.of(
                "project_id",
                options.getProjectId(),
                "instance_id",
                "instance",
                "zone",
                "us-central1-a"));

    // Create a jul logger at with INFO level
    LoggingHandler handler = new LoggingHandler(LOG_ID, options, resource);
    handler.setLevel(Level.WARNING);
    handler.setSynchronicity(Synchronicity.SYNC);
    Logger logger = Logger.getLogger(getClass().getName());
    logger.addHandler(handler);
    logger.setLevel(Level.WARNING);
    logger.warning("Message");

    // Find the log name and wait until we have at least 1 entry
    Iterator<LogEntry> iterator = waitForLogs(logName);
    assertThat(iterator.hasNext()).isTrue();

    // Read the log entry
    LogEntry entry = iterator.next();
    assertTrue(entry.getPayload() instanceof Payload.StringPayload);
    assertTrue(entry.<Payload.StringPayload>getPayload().getData().contains("Message"));
    assertEquals(LOG_ID, entry.getLogName());
    assertEquals(
        ImmutableMap.of(
            "levelName", "WARNING", "levelValue", String.valueOf(Level.WARNING.intValue())),
        entry.getLabels());
    assertEquals(resource, entry.getResource());
    assertNull(entry.getHttpRequest());
    assertEquals(Severity.WARNING, entry.getSeverity());
    assertNull(entry.getOperation());
    assertNotNull(entry.getInsertId());
    assertNotNull(entry.getTimestamp());
    assertFalse(iterator.hasNext());
    logger.removeHandler(handler);
  }
}
