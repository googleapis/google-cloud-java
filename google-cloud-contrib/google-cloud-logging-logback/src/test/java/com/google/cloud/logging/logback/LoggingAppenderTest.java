/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.logging.logback;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.filter.ThresholdFilter;
import ch.qos.logback.classic.spi.LoggingEvent;
import com.google.cloud.MonitoredResource;
import com.google.cloud.Timestamp;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.cloud.logging.Payload;
import com.google.cloud.logging.Severity;
import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

@RunWith(MockitoJUnitRunner.class)
public class LoggingAppenderTest {

  private final String projectId = "test-project";

  private final LoggingAppender loggingAppender = spy(LoggingAppender.class);
  private final Logging logging = mock(Logging.class);
  private final WriteOption[] defaultWriteOptions = new WriteOption[] {
      WriteOption.logName("java.log"),
      WriteOption.resource(MonitoredResource.newBuilder("global")
          .setLabels(new ImmutableMap.Builder<String, String>()
              .put("project_id",projectId).build())
          .build())
  };

  @Before
  public void setUp() {
    doReturn(logging).when(loggingAppender).getLogging();
    doReturn("test-project").when(loggingAppender).getProjectId();
    loggingAppender.start();
  }

  @Test
  public void testFlushLevelConfigUpdatesLoggingFlushSeverity() {
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    LoggingEvent loggingEvent = createLoggingEvent(Level.WARN, timestamp.getSeconds());
    // error is the default, updating to debug for test
    loggingAppender.setFlushLevel(Level.WARN);
    loggingAppender.start(); // reloading config
    loggingAppender.doAppend(loggingEvent);
    verify(logging, times(1)).setFlushSeverity(Severity.WARNING);
  }

  @Test
  public void testFilterLogsOnlyLogsAtOrAboveLogLevel() {
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    // default level is info
    LoggingEvent loggingEvent1 = createLoggingEvent(Level.INFO, timestamp.getSeconds());
    ThresholdFilter thresholdFilter = new ThresholdFilter();
    thresholdFilter.setLevel("ERROR");
    thresholdFilter.start();
    loggingAppender.addFilter(thresholdFilter);
    loggingAppender.doAppend(loggingEvent1);
    verify(logging, times(0)).write(any(Iterable.class), any(WriteOption.class));
    LoggingEvent loggingEvent2 = createLoggingEvent(Level.ERROR, timestamp.getSeconds());
    loggingAppender.doAppend(loggingEvent2);
    verify(logging, times(1)).write(any(Iterable.class), any(WriteOption.class));
  }

  @Test
  public void testEnhancersAddCorrectLabelsToLogEntries() {
    loggingAppender.setEnhancers("com.example.enhancers.TestLoggingEnhancer," +
    "com.example.enhancers.AnotherTestLoggingEnhancer");
    loggingAppender.start();
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    LoggingEvent loggingEvent = createLoggingEvent(Level.WARN, timestamp.getSeconds());
    loggingAppender.doAppend(loggingEvent);
    verify(logging, times(1)).write(
        Collections.singleton(
            LogEntry.newBuilder(Payload.StringPayload.of("this is a test"))
                .setTimestamp(100000)
                .setSeverity(Severity.WARNING)
                .setLabels(new ImmutableMap.Builder<String, String>()
                    .put("levelName", "WARN")
                    .put("levelValue", String.valueOf(Level.WARN_INT))
                    .put("test-label-1", "test-value-1")
                    .put("test-label-2", "test-value-2")
                    .build())
                .build()), defaultWriteOptions);
  }

  @Test
  public void testLogEntryLevelAndLabelsAreAsExpected() {
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    LoggingEvent loggingEvent = createLoggingEvent(Level.ERROR, timestamp.getSeconds());
    loggingAppender.doAppend(loggingEvent);
    verify(logging).write(
        Collections.singleton(
            LogEntry.newBuilder(Payload.StringPayload.of("this is a test"))
                .setTimestamp(100000)
                .setSeverity(Severity.ERROR)
                .setLabels(new ImmutableMap.Builder<String, String>()
                    .put("levelName", "ERROR")
                    .put("levelValue", String.valueOf(Level.ERROR_INT))
                    .build())
                .build()), defaultWriteOptions);
  }

  private LoggingEvent createLoggingEvent(Level level, long timestamp) {
    LoggingEvent loggingEvent = new LoggingEvent();
    loggingEvent.setMessage("this is a test");
    loggingEvent.setLevel(level);
    loggingEvent.setTimeStamp(timestamp);
    return loggingEvent;
  }
}
