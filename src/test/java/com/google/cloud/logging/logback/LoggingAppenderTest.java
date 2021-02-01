/*
 * Copyright 2017 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.fail;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.filter.ThresholdFilter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import com.google.cloud.MonitoredResource;
import com.google.cloud.Timestamp;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Payload.JsonPayload;
import com.google.cloud.logging.Severity;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;
import org.easymock.Capture;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.MDC;

@RunWith(EasyMockRunner.class)
public class LoggingAppenderTest {
  private final String projectId = "test-project";
  private Logging logging;
  private LoggingAppender loggingAppender;

  class TestLoggingAppender extends LoggingAppender {
    @Override
    String getProjectId() {
      return projectId;
    }

    @Override
    Logging getLogging() {
      return logging;
    }
  }

  @Before
  public void setUp() {
    logging = EasyMock.createStrictMock(Logging.class);
    loggingAppender = new TestLoggingAppender();
  }

  private final WriteOption[] defaultWriteOptions =
      new WriteOption[] {
        WriteOption.logName("java.log"),
        WriteOption.resource(
            MonitoredResource.newBuilder("global")
                .setLabels(
                    new ImmutableMap.Builder<String, String>().put("project_id", projectId).build())
                .build())
      };

  @Test
  public void testFlushLevelConfigUpdatesLoggingFlushSeverity() {
    Map<String, Object> jsonContent = new HashMap<>();
    jsonContent.put("message", "this is a test");
    JsonPayload payload = JsonPayload.of(jsonContent);
    LogEntry logEntry =
        LogEntry.newBuilder(payload)
            .setTimestamp(100000L)
            .setSeverity(Severity.WARNING)
            .setLabels(
                new ImmutableMap.Builder<String, String>()
                    .put("levelName", "WARN")
                    .put("levelValue", String.valueOf(30000L))
                    .put("loggerName", this.getClass().getName())
                    .build())
            .build();
    logging.setFlushSeverity(Severity.WARNING);
    Capture<Iterable<LogEntry>> capturedArgument = Capture.newInstance();
    logging.write(capture(capturedArgument), (WriteOption) anyObject(), (WriteOption) anyObject());
    replay(logging);
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    LoggingEvent loggingEvent = createLoggingEvent(Level.WARN, timestamp.getSeconds());
    // error is the default, updating to warn for test
    loggingAppender.setFlushLevel(Level.WARN);
    loggingAppender.start();
    loggingAppender.doAppend(loggingEvent);
    verify(logging);
    assertThat(capturedArgument.getValue().iterator().hasNext()).isTrue();
    assertThat(capturedArgument.getValue().iterator().next()).isEqualTo(logEntry);
  }

  @Test
  public void testFlushLevelConfigSupportsFlushLevelOff() {
    loggingAppender.setFlushLevel(Level.OFF);
    loggingAppender.start();
    Severity foundSeverity = logging.getFlushSeverity();
    assertThat(foundSeverity).isEqualTo(null);
  }

  @Test
  public void testFilterLogsOnlyLogsAtOrAboveLogLevel() {
    Map<String, Object> jsonContent = new HashMap<>();
    jsonContent.put("message", "this is a test");
    jsonContent.put(
        "@type",
        "type.googleapis.com/google.devtools.clouderrorreporting.v1beta1.ReportedErrorEvent");
    JsonPayload payload = JsonPayload.of(jsonContent);
    LogEntry logEntry =
        LogEntry.newBuilder(payload)
            .setTimestamp(100000L)
            .setSeverity(Severity.ERROR)
            .setLabels(
                new ImmutableMap.Builder<String, String>()
                    .put("levelName", "ERROR")
                    .put("levelValue", String.valueOf(40000L))
                    .put("loggerName", this.getClass().getName())
                    .build())
            .build();
    logging.setFlushSeverity(Severity.ERROR);
    Capture<Iterable<LogEntry>> capturedArgument = Capture.newInstance();
    logging.write(capture(capturedArgument), (WriteOption) anyObject(), (WriteOption) anyObject());
    expectLastCall().once();
    replay(logging);
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    LoggingEvent loggingEvent1 = createLoggingEvent(Level.INFO, timestamp.getSeconds());
    ThresholdFilter thresholdFilter = new ThresholdFilter();
    thresholdFilter.setLevel("ERROR");
    thresholdFilter.start();
    loggingAppender.addFilter(thresholdFilter);
    loggingAppender.start();
    // info event does not get logged
    loggingAppender.doAppend(loggingEvent1);
    LoggingEvent loggingEvent2 = createLoggingEvent(Level.ERROR, timestamp.getSeconds());
    // error event gets logged
    loggingAppender.doAppend(loggingEvent2);
    verify(logging);
    assertThat(capturedArgument.getValue().iterator().hasNext()).isTrue();
    assertThat(capturedArgument.getValue().iterator().next()).isEqualTo(logEntry);
  }

  @Test
  public void testEnhancersAddCorrectLabelsToLogEntries() {
    Map<String, Object> jsonContent = new HashMap<>();
    jsonContent.put("message", "this is a test");
    JsonPayload payload = JsonPayload.of(jsonContent);
    LogEntry logEntry =
        LogEntry.newBuilder(payload)
            .setTimestamp(100000L)
            .setSeverity(Severity.WARNING)
            .setLabels(
                new ImmutableMap.Builder<String, String>()
                    .put("levelName", "WARN")
                    .put("levelValue", String.valueOf(30000L))
                    .put("loggerName", this.getClass().getName())
                    .put("test-label-1", "test-value-1")
                    .put("test-label-2", "test-value-2")
                    .build())
            .build();
    logging.setFlushSeverity(Severity.ERROR);
    Capture<Iterable<LogEntry>> capturedArgument = Capture.newInstance();
    logging.write(capture(capturedArgument), (WriteOption) anyObject(), (WriteOption) anyObject());
    expectLastCall().once();
    replay(logging);
    loggingAppender.addEnhancer("com.example.enhancers.TestLoggingEnhancer");
    loggingAppender.addEnhancer("com.example.enhancers.AnotherTestLoggingEnhancer");
    loggingAppender.start();
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    LoggingEvent loggingEvent = createLoggingEvent(Level.WARN, timestamp.getSeconds());
    loggingAppender.doAppend(loggingEvent);
    verify(logging);
    assertThat(capturedArgument.getValue().iterator().hasNext()).isTrue();
    assertThat(capturedArgument.getValue().iterator().next()).isEqualTo(logEntry);
  }

  @Test
  public void testDefaultWriteOptionsHasExpectedDefaults() {
    logging.setFlushSeverity(Severity.ERROR);
    Capture<WriteOption> logNameArg = Capture.newInstance();
    Capture<WriteOption> resourceArg = Capture.newInstance();
    logging.write((Iterable<LogEntry>) anyObject(), capture(logNameArg), capture(resourceArg));
    expectLastCall().once();
    replay(logging);
    loggingAppender.start();
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    LoggingEvent loggingEvent = createLoggingEvent(Level.ERROR, timestamp.getSeconds());
    loggingAppender.doAppend(loggingEvent);

    assertThat(logNameArg.getValue()).isEqualTo(defaultWriteOptions[0]);
    // TODO(chingor): Fix this test to work on GCE and locally
    // assertThat(resourceArg.getValue()).isEqualTo(defaultWriteOptions[1]);
  }

  @Test
  public void testMdcValuesAreConvertedToLabels() {
    Map<String, Object> jsonContent = new HashMap<>();
    jsonContent.put("message", "this is a test");
    JsonPayload payload = JsonPayload.of(jsonContent);
    LogEntry logEntry =
        LogEntry.newBuilder(payload)
            .setTimestamp(100000L)
            .setSeverity(Severity.INFO)
            .setLabels(
                new ImmutableMap.Builder<String, String>()
                    .put("levelName", "INFO")
                    .put("levelValue", String.valueOf(20000L))
                    .put("loggerName", this.getClass().getName())
                    .put("mdc1", "value1")
                    .put("mdc2", "value2")
                    .build())
            .build();
    logging.setFlushSeverity(Severity.ERROR);
    Capture<Iterable<LogEntry>> capturedArgument = Capture.newInstance();
    logging.write(capture(capturedArgument), (WriteOption) anyObject(), (WriteOption) anyObject());
    expectLastCall().once();
    replay(logging);
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    LoggingEvent loggingEvent = createLoggingEvent(Level.INFO, timestamp.getSeconds());
    loggingEvent.setMDCPropertyMap(ImmutableMap.of("mdc1", "value1", "mdc2", "value2"));
    loggingAppender.start();
    // info event does not get logged
    loggingAppender.doAppend(loggingEvent);
    verify(logging);
    assertThat(capturedArgument.getValue().iterator().hasNext()).isTrue();
    assertThat(capturedArgument.getValue().iterator().next()).isEqualTo(logEntry);
  }

  @Test
  public void testCreateLoggingOptions() {
    // Try to build LoggingOptions with custom credentials.
    final String nonExistentFile = "/path/to/non/existent/file";
    LoggingAppender appender = new LoggingAppender();
    appender.setCredentialsFile(nonExistentFile);
    try {
      appender.getLoggingOptions();
      fail("Expected exception");
    } catch (Exception e) {
      assertThat(e.getMessage().contains(nonExistentFile));
    }
    // Try to build LoggingOptions with default credentials.
    LoggingOptions defaultOptions = null;
    try {
      defaultOptions = LoggingOptions.getDefaultInstance();
    } catch (Exception e) {
      // Could not build a default LoggingOptions instance.
    }
    if (defaultOptions != null) {
      appender = new LoggingAppender();
      LoggingOptions options = appender.getLoggingOptions();
      assertThat(options).isEqualTo(defaultOptions);
    }
  }

  private LoggingEvent createLoggingEvent(Level level, long timestamp) {
    LoggingEvent loggingEvent = new LoggingEvent();
    loggingEvent.setMessage("this is a test");
    loggingEvent.setLevel(level);
    loggingEvent.setTimeStamp(timestamp);
    loggingEvent.setLoggerName(this.getClass().getName());
    return loggingEvent;
  }

  @Test
  public void testMdcValuesAreConvertedToLabelsWithPassingNullValues() {
    MDC.put("mdc1", "value1");
    MDC.put("mdc2", null);
    MDC.put("mdc3", "value3");
    logging.setFlushSeverity(Severity.ERROR);
    Capture<Iterable<LogEntry>> capturedArgument = Capture.newInstance();
    logging.write(capture(capturedArgument), (WriteOption) anyObject(), (WriteOption) anyObject());
    expectLastCall().once();
    replay(logging);
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    LoggingEvent loggingEvent = createLoggingEvent(Level.INFO, timestamp.getSeconds());
    loggingAppender.start();
    loggingAppender.doAppend(loggingEvent);
    verify(logging);
    MDC.remove("mdc1");
    MDC.remove("mdc3");
    Map<String, String> capturedArgumentMap =
        capturedArgument.getValue().iterator().next().getLabels();
    assertThat(capturedArgumentMap.get("mdc1")).isEqualTo("value1");
    assertThat(capturedArgumentMap.get("mdc2")).isNull();
    assertThat(capturedArgumentMap.get("mdc3")).isEqualTo("value3");
  }

  @Test
  public void testAddCustomLoggingEventEnhancers() {
    MDC.put("mdc1", "value1");
    logging.setFlushSeverity(Severity.ERROR);
    Capture<Iterable<LogEntry>> capturedArgument = Capture.newInstance();
    logging.write(capture(capturedArgument), (WriteOption) anyObject(), (WriteOption) anyObject());
    expectLastCall().once();
    replay(logging);
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    LoggingEvent loggingEvent = createLoggingEvent(Level.INFO, timestamp.getSeconds());
    loggingAppender.addLoggingEventEnhancer(CustomLoggingEventEnhancer1.class.getName());
    loggingAppender.addLoggingEventEnhancer(CustomLoggingEventEnhancer2.class.getName());
    loggingAppender.start();
    loggingAppender.doAppend(loggingEvent);
    verify(logging);
    MDC.remove("mdc1");
    Map<String, String> capturedArgumentMap =
        capturedArgument.getValue().iterator().next().getLabels();
    assertThat(capturedArgumentMap.get("mdc1")).isNull();
    assertThat(capturedArgumentMap.get("foo")).isEqualTo("foo");
    assertThat(capturedArgumentMap.get("bar")).isEqualTo("bar");
  }

  @Test
  public void testFlush() {
    logging.setFlushSeverity(Severity.ERROR);
    Capture<Iterable<LogEntry>> capturedArgument = Capture.newInstance();
    logging.write(capture(capturedArgument), (WriteOption) anyObject(), (WriteOption) anyObject());
    expectLastCall().times(2);
    logging.flush();
    replay(logging);
    loggingAppender.start();
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    LoggingEvent firstLoggingEvent = createLoggingEvent(Level.WARN, timestamp.getSeconds());
    LoggingEvent secondLoggingEvent = createLoggingEvent(Level.INFO, timestamp.getSeconds());
    loggingAppender.doAppend(firstLoggingEvent);
    loggingAppender.doAppend(secondLoggingEvent);
    loggingAppender.flush();
    verify(logging);
  }

  static class CustomLoggingEventEnhancer1 implements LoggingEventEnhancer {

    @Override
    public void enhanceLogEntry(LogEntry.Builder builder, ILoggingEvent e) {
      builder.addLabel("foo", "foo");
    }
  }

  static class CustomLoggingEventEnhancer2 implements LoggingEventEnhancer {

    @Override
    public void enhanceLogEntry(LogEntry.Builder builder, ILoggingEvent e) {
      builder.addLabel("bar", "bar");
    }
  }
}
