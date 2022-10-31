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
import static org.junit.Assert.assertEquals;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.filter.ThresholdFilter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import com.google.cloud.MonitoredResource;
import com.google.cloud.Timestamp;
import com.google.cloud.logging.Instrumentation;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.cloud.logging.LoggingEnhancer;
import com.google.cloud.logging.Payload;
import com.google.cloud.logging.Payload.JsonPayload;
import com.google.cloud.logging.Payload.Type;
import com.google.cloud.logging.Severity;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Instant;
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
  private static final String PROJECT_ID = "test-project";
  private static final String CRED_FILE_PROJECT_ID = "project-12345";
  private static final String OVERRIDED_PROJECT_ID = "some-project-id";
  private static final String DUMMY_CRED_FILE_PATH =
      "src/test/java/com/google/cloud/logging/logback/dummy-credentials.json";
  private static Payload.JsonPayload JSON_PAYLOAD =
      Payload.JsonPayload.of(ImmutableMap.of("message", "this is a test"));
  private static Payload.JsonPayload JSON_ERROR_PAYLOAD =
      Payload.JsonPayload.of(
          ImmutableMap.of(
              "message",
              "this is a test",
              "@type",
              "type.googleapis.com/google.devtools.clouderrorreporting.v1beta1.ReportedErrorEvent"));
  private static final MonitoredResource DEFAULT_RESOURCE =
      MonitoredResource.of("global", ImmutableMap.of("project_id", PROJECT_ID));
  private static final LogEntry WARN_ENTRY =
      LogEntry.newBuilder(JSON_PAYLOAD)
          .setTimestamp(Instant.ofEpochMilli(100000L))
          .setSeverity(Severity.WARNING)
          .setLabels(
              new ImmutableMap.Builder<String, String>()
                  .put("levelName", "WARN")
                  .put("levelValue", String.valueOf(30000L))
                  .put("loggerName", LoggingAppenderTest.class.getName())
                  // .put("test-label-1", "test-value-1")
                  // .put("test-label-2", "test-value-2")
                  .build())
          .build();
  private static final LogEntry ERROR_ENTRY =
      LogEntry.newBuilder(JSON_ERROR_PAYLOAD)
          .setTimestamp(Instant.ofEpochMilli(100000L))
          .setSeverity(Severity.ERROR)
          .setLabels(
              new ImmutableMap.Builder<String, String>()
                  .put("levelName", "ERROR")
                  .put("levelValue", String.valueOf(40000L))
                  .put("loggerName", LoggingAppenderTest.class.getName())
                  .build())
          .build();
  private static final LogEntry INFO_ENTRY =
      LogEntry.newBuilder(JSON_PAYLOAD)
          .setTimestamp(Instant.ofEpochMilli(100000L))
          .setSeverity(Severity.INFO)
          .setLabels(
              new ImmutableMap.Builder<String, String>()
                  .put("levelName", "INFO")
                  .put("levelValue", String.valueOf(20000L))
                  .put("loggerName", LoggingAppenderTest.class.getName())
                  .put("mdc1", "value1")
                  .put("mdc2", "value2")
                  .build())
          .build();

  private Logging logging;
  private LoggingAppender loggingAppender;

  static class CustomLoggingEventEnhancer implements LoggingEventEnhancer {

    @Override
    public void enhanceLogEntry(LogEntry.Builder builder, ILoggingEvent e) {
      builder.addLabel("foo", "bar");
    }
  }

  static class CustomLoggingEnhancer implements LoggingEnhancer {

    @Override
    public void enhanceLogEntry(LogEntry.Builder builder) {
      builder.addLabel("foo", "bar");
    }
  }

  class TestLoggingAppender extends LoggingAppender {
    @Override
    String getProjectId() {
      return PROJECT_ID;
    }

    @Override
    Logging getLogging() {
      return logging;
    }
  }

  @Before
  public void setUp() {
    LoggingAppender.setInstrumentationStatus(true);
    logging = EasyMock.createStrictMock(Logging.class);
    loggingAppender = new TestLoggingAppender();
    loggingAppender.setAutoPopulateMetadata(false);
  }

  private final WriteOption[] defaultWriteOptions =
      new WriteOption[] {
        WriteOption.logName("java.log"),
        WriteOption.resource(
            MonitoredResource.newBuilder("global")
                .setLabels(
                    new ImmutableMap.Builder<String, String>()
                        .put("project_id", PROJECT_ID)
                        .build())
                .build()),
        WriteOption.partialSuccess(true),
      };

  @Test
  public void testFlushLevelConfigUpdatesLoggingFlushSeverity() {
    logging.setFlushSeverity(Severity.WARNING);
    Capture<Iterable<LogEntry>> capturedArgument = Capture.newInstance();
    logging.write(
        capture(capturedArgument),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class));
    replay(logging);
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    LoggingEvent loggingEvent = createLoggingEvent(Level.WARN, timestamp.getSeconds());
    // error is the default, updating to warn for test
    loggingAppender.setFlushLevel(Level.WARN);
    loggingAppender.start();
    loggingAppender.doAppend(loggingEvent);
    verify(logging);
    assertThat(capturedArgument.getValue().iterator().hasNext()).isTrue();
    assertThat(capturedArgument.getValue().iterator().next()).isEqualTo(WARN_ENTRY);
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
    logging.setFlushSeverity(Severity.ERROR);
    Capture<Iterable<LogEntry>> capturedArgument = Capture.newInstance();
    logging.write(
        capture(capturedArgument),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class));
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
    assertThat(capturedArgument.getValue().iterator().next()).isEqualTo(ERROR_ENTRY);
  }

  @Test
  public void testPartialSuccessOverrideHasExpectedValue() {
    logging.setFlushSeverity(Severity.ERROR);
    Capture<WriteOption> logNameArg = Capture.newInstance();
    Capture<WriteOption> resourceArg = Capture.newInstance();
    Capture<WriteOption> partialSuccessArg = Capture.newInstance();
    logging.write(
        EasyMock.<Iterable<LogEntry>>anyObject(),
        capture(logNameArg),
        capture(resourceArg),
        capture(partialSuccessArg));
    expectLastCall().once();
    replay(logging);
    loggingAppender.start();
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    LoggingEvent loggingEvent = createLoggingEvent(Level.ERROR, timestamp.getSeconds());
    loggingAppender.doAppend(loggingEvent);

    assertThat(logNameArg.getValue()).isEqualTo(defaultWriteOptions[0]);
    // TODO(chingor): Fix this test to work on GCE and locally
    // assertThat(resourceArg.getValue()).isEqualTo(defaultWriteOptions[1]);
    assertThat(partialSuccessArg.getValue()).isEqualTo(defaultWriteOptions[2]);
  }

  @Test
  public void testDefaultWriteOptionsHasExpectedDefaults() {
    logging.setFlushSeverity(Severity.ERROR);
    Capture<WriteOption> partialSuccessArg = Capture.newInstance();
    logging.write(
        EasyMock.<Iterable<LogEntry>>anyObject(),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class),
        capture(partialSuccessArg));
    expectLastCall().once();
    replay(logging);
    loggingAppender.setPartialSuccess(false);
    loggingAppender.start();
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    LoggingEvent loggingEvent = createLoggingEvent(Level.ERROR, timestamp.getSeconds());
    loggingAppender.doAppend(loggingEvent);
    assertThat(partialSuccessArg.getValue()).isEqualTo(WriteOption.partialSuccess(false));
  }

  @Test
  public void testMdcValuesAreConvertedToLabels() {
    logging.setFlushSeverity(Severity.ERROR);
    Capture<Iterable<LogEntry>> capturedArgument = Capture.newInstance();
    logging.write(
        capture(capturedArgument),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class));
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
    assertThat(capturedArgument.getValue().iterator().next()).isEqualTo(INFO_ENTRY);
  }

  @Test(expected = RuntimeException.class)
  public void testCreateLoggingOptionsWithInvalidCredentials() {
    final String nonExistentFile = "/path/to/non/existent/file";
    LoggingAppender appender = new LoggingAppender();
    appender.setCredentialsFile(nonExistentFile);
    appender.getLoggingOptions();
  }

  @Test
  public void testCreateLoggingOptionsWithCredentials() {
    // Try to build LoggingOptions with file based credentials.
    LoggingAppender appender = new LoggingAppender();
    appender.setCredentialsFile(DUMMY_CRED_FILE_PATH);
    assertThat(appender.getLoggingOptions().getProjectId()).isEqualTo(CRED_FILE_PROJECT_ID);
  }

  @Test
  public void testCreateLoggingOptionsWithDestination() {
    // Try to build LoggingOptions with file based credentials.
    LoggingAppender appender = new LoggingAppender();
    appender.setCredentialsFile(DUMMY_CRED_FILE_PATH);
    appender.setLogDestinationProjectId(OVERRIDED_PROJECT_ID);
    assertThat(appender.getLoggingOptions().getProjectId()).isEqualTo(OVERRIDED_PROJECT_ID);
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
    logging.write(
        capture(capturedArgument),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class));
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
    logging.write(
        capture(capturedArgument),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class));
    expectLastCall().once();
    replay(logging);
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    LoggingEvent loggingEvent = createLoggingEvent(Level.INFO, timestamp.getSeconds());
    loggingAppender.addLoggingEventEnhancer(CustomLoggingEventEnhancer.class.getName());
    loggingAppender.start();
    loggingAppender.doAppend(loggingEvent);
    verify(logging);
    MDC.remove("mdc1");
    Map<String, String> capturedArgumentMap =
        capturedArgument.getValue().iterator().next().getLabels();
    assertThat(capturedArgumentMap.get("mdc1")).isNull();
    assertThat(capturedArgumentMap.get("foo")).isEqualTo("bar");
  }

  @Test
  public void testAddCustomLoggingEnhancer() {
    logging.setFlushSeverity(Severity.ERROR);
    Capture<Iterable<LogEntry>> capturedArgument = Capture.newInstance();
    logging.write(
        capture(capturedArgument),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class));
    expectLastCall().once();
    replay(logging);
    loggingAppender.addEnhancer(CustomLoggingEnhancer.class.getName());
    loggingAppender.start();
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    LoggingEvent loggingEvent = createLoggingEvent(Level.WARN, timestamp.getSeconds());
    loggingAppender.doAppend(loggingEvent);
    verify(logging);
    Map<String, String> capturedArgumentMap =
        capturedArgument.getValue().iterator().next().getLabels();
    assertThat(capturedArgumentMap.get("foo")).isEqualTo("bar");
  }

  @Test
  @SuppressWarnings("deprecation")
  public void testFlush() {
    logging.setFlushSeverity(Severity.ERROR);
    logging.write(
        EasyMock.<Iterable<LogEntry>>anyObject(),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class));
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

  @Test
  public void testAutoPopulationEnabled() {
    logging.setFlushSeverity(Severity.ERROR);
    Capture<Iterable<LogEntry>> capturedLogEntries = Capture.newInstance();
    EasyMock.expect(
            logging.populateMetadata(
                capture(capturedLogEntries),
                EasyMock.eq(DEFAULT_RESOURCE),
                EasyMock.eq("com.google.cloud.logging"),
                EasyMock.eq("jdk"),
                EasyMock.eq("sun"),
                EasyMock.eq("java"),
                EasyMock.eq("ch.qos.logback")))
        .andReturn(ImmutableList.of(INFO_ENTRY))
        .once();
    // it is impossible to define expectation for varargs using a single anyObject() matcher
    // see the EasyMock bug https://github.com/easymock/easymock/issues/130.
    // the following mock uses the known fact that the method pass two WriteOption arguments
    // the arguments should be replaced with a single anyObject() matchers when the bug is fixed
    logging.write(
        EasyMock.<Iterable<LogEntry>>anyObject(),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class));
    expectLastCall().once();
    replay(logging);

    loggingAppender.setupMonitoredResource(DEFAULT_RESOURCE);
    loggingAppender.setAutoPopulateMetadata(true);
    loggingAppender.start();
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    LoggingEvent loggingEvent = createLoggingEvent(Level.INFO, timestamp.getSeconds());
    loggingEvent.setMDCPropertyMap(ImmutableMap.of("mdc1", "value1", "mdc2", "value2"));
    loggingAppender.doAppend(loggingEvent);
    verify(logging);
    LogEntry testLogEntry = capturedLogEntries.getValue().iterator().next();
    assertThat(testLogEntry).isEqualTo(INFO_ENTRY);
  }

  @Test
  public void testRedirectToStdoutEnabled() {
    logging.setFlushSeverity(Severity.ERROR);
    EasyMock.expect(
            logging.populateMetadata(
                EasyMock.<Iterable<LogEntry>>anyObject(),
                EasyMock.anyObject(MonitoredResource.class),
                EasyMock.anyString(),
                EasyMock.anyString(),
                EasyMock.anyString(),
                EasyMock.anyString(),
                EasyMock.anyString()))
        .andReturn(ImmutableList.of(INFO_ENTRY))
        .once();
    replay(logging);

    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    System.setOut(out);
    loggingAppender.setupMonitoredResource(DEFAULT_RESOURCE);
    loggingAppender.setAutoPopulateMetadata(true);
    loggingAppender.setRedirectToStdout(true);
    loggingAppender.start();
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    LoggingEvent loggingEvent = createLoggingEvent(Level.INFO, timestamp.getSeconds());
    loggingAppender.doAppend(loggingEvent);
    verify(logging);
    assertThat(Strings.isNullOrEmpty(bout.toString())).isFalse();
    System.setOut(null);
  }

  @Test
  public void testRedirectToStdoutDisabled() {
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    System.setOut(out);

    testAutoPopulationEnabled();

    assertThat(Strings.isNullOrEmpty(bout.toString())).isTrue();
    System.setOut(null);
  }

  @Test
  public void testFDiagnosticInfoAdded() {
    LoggingAppender.setInstrumentationStatus(false);
    Capture<Iterable<LogEntry>> capturedArgument = Capture.newInstance();
    logging.setFlushSeverity(Severity.ERROR);
    logging.write(
        capture(capturedArgument),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class));
    replay(logging);
    LoggingEvent loggingEvent =
        createLoggingEvent(Level.ERROR, Timestamp.ofTimeSecondsAndNanos(100000, 0).getSeconds());
    loggingAppender.start();
    loggingAppender.doAppend(loggingEvent);
    verify(logging);
    int count = 0;
    int diagnosticRecordCount = 0;
    for (LogEntry entry : capturedArgument.getValue()) {
      count++;
      if (entry.getPayload().getType() == Type.JSON) {
        JsonPayload payload = entry.<Payload.JsonPayload>getPayload();
        if (!payload.getData().containsFields(Instrumentation.DIAGNOSTIC_INFO_KEY)) continue;
        ListValue infoList =
            payload
                .getData()
                .getFieldsOrThrow(Instrumentation.DIAGNOSTIC_INFO_KEY)
                .getStructValue()
                .getFieldsOrThrow(Instrumentation.INSTRUMENTATION_SOURCE_KEY)
                .getListValue();
        for (Value val : infoList.getValuesList()) {
          String name =
              val.getStructValue()
                  .getFieldsOrThrow(Instrumentation.INSTRUMENTATION_NAME_KEY)
                  .getStringValue();
          assertThat(name.startsWith(Instrumentation.JAVA_LIBRARY_NAME_PREFIX)).isTrue();
          if (name.equals(LoggingAppender.JAVA_LOGBACK_LIBRARY_NAME)) {
            diagnosticRecordCount++;
          }
        }
      }
    }
    assertEquals(count, 2);
    assertEquals(diagnosticRecordCount, 1);
  }

  @Test
  public void testFDiagnosticInfoNotAdded() {
    logging.setFlushSeverity(Severity.ERROR);
    Capture<Iterable<LogEntry>> capturedArgument = Capture.newInstance();
    logging.write(
        capture(capturedArgument),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class),
        anyObject(WriteOption.class));
    replay(logging);
    LoggingEvent loggingEvent =
        createLoggingEvent(Level.WARN, Timestamp.ofTimeSecondsAndNanos(100000, 0).getSeconds());
    loggingAppender.start();
    loggingAppender.doAppend(loggingEvent);
    verify(logging);
    int count = 0;
    for (LogEntry entry : capturedArgument.getValue()) {
      count++;
      if (entry.getPayload().getType() == Type.JSON) {
        JsonPayload payload = entry.<Payload.JsonPayload>getPayload();
        assertThat(payload.getData().containsFields(Instrumentation.DIAGNOSTIC_INFO_KEY)).isFalse();
      }
    }
    assertEquals(count, 1);
  }
}
