/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.logging;

import static com.google.common.truth.Truth.assertThat;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.reset;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.cloud.logging.Payload.StringPayload;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonParser;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.ErrorManager;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class) // We're testing our own deprecated Builder methods.
@SuppressWarnings("deprecation")
public class LoggingHandlerTest {

  private static final String LOG_NAME = "java.log";
  private static final String MESSAGE = "message";
  private static final String PROJECT = "project";
  private static final String PROJECT_ENV_NAME = "GOOGLE_CLOUD_PROJECT";

  private static final MonitoredResource DEFAULT_RESOURCE =
      MonitoredResource.of("global", ImmutableMap.of("project_id", PROJECT));

  private static final LogEntry FINEST_ENTRY =
      LogEntry.newBuilder(StringPayload.of(MESSAGE))
          .setSeverity(Severity.DEBUG)
          .addLabel("levelName", "FINEST")
          .addLabel("levelValue", String.valueOf(Level.FINEST.intValue()))
          .setTimestamp(123456789L)
          .build();
  private static final LogEntry FINEST_ENHANCED_ENTRY =
      LogEntry.newBuilder(StringPayload.of(MESSAGE))
          .setSeverity(Severity.DEBUG)
          .addLabel("levelName", "FINEST")
          .addLabel("levelValue", String.valueOf(Level.FINEST.intValue()))
          .addLabel("enhanced", "true")
          .setTimestamp(123456789L)
          .build();
  private static final LogEntry FINER_ENTRY =
      LogEntry.newBuilder(StringPayload.of(MESSAGE))
          .setSeverity(Severity.DEBUG)
          .addLabel("levelName", "FINER")
          .addLabel("levelValue", String.valueOf(Level.FINER.intValue()))
          .setTimestamp(123456789L)
          .build();
  private static final LogEntry FINE_ENTRY =
      LogEntry.newBuilder(StringPayload.of(MESSAGE))
          .setSeverity(Severity.DEBUG)
          .addLabel("levelName", "FINE")
          .addLabel("levelValue", String.valueOf(Level.FINE.intValue()))
          .setTimestamp(123456789L)
          .build();
  private static final LogEntry CONFIG_ENTRY =
      LogEntry.newBuilder(StringPayload.of(MESSAGE))
          .setSeverity(Severity.INFO)
          .addLabel("levelName", "CONFIG")
          .addLabel("levelValue", String.valueOf(Level.CONFIG.intValue()))
          .setTimestamp(123456789L)
          .build();
  private static final LogEntry INFO_ENTRY =
      LogEntry.newBuilder(StringPayload.of(MESSAGE))
          .setSeverity(Severity.INFO)
          .setTimestamp(123456789L)
          .build();
  private static final LogEntry WARNING_ENTRY =
      LogEntry.newBuilder(StringPayload.of(MESSAGE))
          .setSeverity(Severity.WARNING)
          .addLabel("levelName", "WARNING")
          .addLabel("levelValue", String.valueOf(Level.WARNING.intValue()))
          .setTimestamp(123456789L)
          .build();
  private static final LogEntry SEVERE_ENTRY =
      LogEntry.newBuilder(StringPayload.of(MESSAGE))
          .setSeverity(Severity.ERROR)
          .addLabel("levelName", "SEVERE")
          .addLabel("levelValue", String.valueOf(Level.SEVERE.intValue()))
          .setTimestamp(123456789L)
          .build();
  private static final LogEntry DEBUG_ENTRY =
      LogEntry.newBuilder(StringPayload.of(MESSAGE))
          .setSeverity(Severity.DEBUG)
          .addLabel("levelName", "DEBUG")
          .addLabel("levelValue", String.valueOf(LoggingLevel.DEBUG.intValue()))
          .setTimestamp(123456789L)
          .build();
  private static final LogEntry NOTICE_ENTRY =
      LogEntry.newBuilder(StringPayload.of(MESSAGE))
          .setSeverity(Severity.NOTICE)
          .addLabel("levelName", "NOTICE")
          .addLabel("levelValue", String.valueOf(LoggingLevel.NOTICE.intValue()))
          .setTimestamp(123456789L)
          .build();
  private static final LogEntry ERROR_ENTRY =
      LogEntry.newBuilder(StringPayload.of(MESSAGE))
          .setSeverity(Severity.ERROR)
          .addLabel("levelName", "ERROR")
          .addLabel("levelValue", String.valueOf(LoggingLevel.ERROR.intValue()))
          .setTimestamp(123456789L)
          .build();
  private static final LogEntry CRITICAL_ENTRY =
      LogEntry.newBuilder(StringPayload.of(MESSAGE))
          .setSeverity(Severity.CRITICAL)
          .addLabel("levelName", "CRITICAL")
          .addLabel("levelValue", String.valueOf(LoggingLevel.CRITICAL.intValue()))
          .setTimestamp(123456789L)
          .build();
  private static final LogEntry ALERT_ENTRY =
      LogEntry.newBuilder(StringPayload.of(MESSAGE))
          .setSeverity(Severity.ALERT)
          .addLabel("levelName", "ALERT")
          .addLabel("levelValue", String.valueOf(LoggingLevel.ALERT.intValue()))
          .setTimestamp(123456789L)
          .build();
  private static final LogEntry EMERGENCY_ENTRY =
      LogEntry.newBuilder(StringPayload.of(MESSAGE))
          .setSeverity(Severity.EMERGENCY)
          .addLabel("levelName", "EMERGENCY")
          .addLabel("levelValue", String.valueOf(LoggingLevel.EMERGENCY.intValue()))
          .setTimestamp(123456789L)
          .build();
  private static final LogEntry TRACE_ENTRY =
      LogEntry.newBuilder(StringPayload.of(MESSAGE))
          .setSeverity(Severity.DEBUG)
          .addLabel("levelName", "FINEST")
          .addLabel("levelValue", String.valueOf(Level.FINEST.intValue()))
          .setTrace("projects/projectId/traces/traceId")
          .setTimestamp(123456789L)
          .build();
  private static final LogEntry DIAGNOSTIC_ENTRY =
      LogEntry.newBuilder(
              InstrumentationTest.generateInstrumentationPayload(
                  Instrumentation.JAVA_LIBRARY_NAME_PREFIX,
                  Instrumentation.truncateValue(
                      Instrumentation.getLibraryVersion(Instrumentation.class))))
          .setLogName(Instrumentation.INSTRUMENTATION_LOG_NAME)
          .build();

  private static final ImmutableMap<String, String> BASE_SEVERITY_MAP =
      ImmutableMap.of(
          "levelName", Level.INFO.getName(), "levelValue", String.valueOf(Level.INFO.intValue()));
  private static final WriteOption[] DEFAULT_OPTIONS =
      new WriteOption[] {
        WriteOption.logName(LOG_NAME),
        WriteOption.resource(DEFAULT_RESOURCE),
        WriteOption.labels(BASE_SEVERITY_MAP),
      };

  private Logging logging;
  private LoggingOptions options;

  static final class TestFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
      return record.getMessage();
    }
  }

  static final class TestFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
      return true;
    }
  }

  static final class TestLoggingEnhancer implements LoggingEnhancer {
    @Override
    public void enhanceLogEntry(LogEntry.Builder builder) {
      builder.addLabel("enhanced", "true");
    }
  }

  static class OutputStreamPatcher extends ExternalResource {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ByteArrayOutputStream err = new ByteArrayOutputStream();
    PrintStream oldOut = System.out;
    PrintStream oldErr = System.err;

    // Note that we don't apply the patch in the before() method, because we don't need every test
    // in this class to run with a patched System.out and System.err.
    void patch() {
      System.setOut(new PrintStream(out));
      System.setErr(new PrintStream(err));
    }

    @Override
    protected void after() {
      System.setOut(oldOut);
      System.setErr(oldErr);
    }
  }

  static class CustomLevel extends Level {
    CustomLevel() {
      super("CUSTOM", 510);
    }
  }

  @Rule public final OutputStreamPatcher outputStreamPatcher = new OutputStreamPatcher();

  @Before
  public void setUp() {
    Instrumentation.setInstrumentationStatus(true);
    logging = EasyMock.createMock(Logging.class);
    options = EasyMock.createMock(LoggingOptions.class);
    expect(options.getProjectId()).andStubReturn(PROJECT);
    expect(options.getService()).andStubReturn(logging);
    expect(options.getAutoPopulateMetadata()).andStubReturn(Boolean.FALSE);
    logging.setFlushSeverity(Severity.ERROR);
    expectLastCall().anyTimes();
    logging.setWriteSynchronicity(EasyMock.anyObject(Synchronicity.class));
    expectLastCall().anyTimes();
  }

  @After
  public void after() {
    verify(logging, options);
  }

  private static LogRecord newLogRecord(Level level, String message) {
    LogRecord record = new LogRecord(level, message);
    record.setMillis(123456789L);
    return record;
  }

  @Test
  public void testDefaultHandlerCreation() {
    String oldProject = System.getProperty(PROJECT_ENV_NAME);
    System.setProperty(PROJECT_ENV_NAME, PROJECT);
    replay(options, logging);
    LoggingHandler unused = new LoggingHandler();
    if (oldProject != null) {
      System.setProperty(PROJECT_ENV_NAME, oldProject);
    } else {
      System.clearProperty(PROJECT_ENV_NAME);
    }
  }

  @Test
  public void testPublishLevels() {
    logging.write(ImmutableList.of(FINEST_ENTRY), DEFAULT_OPTIONS);
    expectLastCall().once();
    logging.write(ImmutableList.of(FINER_ENTRY), DEFAULT_OPTIONS);
    expectLastCall().once();
    logging.write(ImmutableList.of(FINE_ENTRY), DEFAULT_OPTIONS);
    expectLastCall().once();
    logging.write(ImmutableList.of(CONFIG_ENTRY), DEFAULT_OPTIONS);
    expectLastCall().once();
    logging.write(ImmutableList.of(INFO_ENTRY), DEFAULT_OPTIONS);
    expectLastCall().once();
    logging.write(ImmutableList.of(WARNING_ENTRY), DEFAULT_OPTIONS);
    expectLastCall().once();
    logging.write(ImmutableList.of(SEVERE_ENTRY), DEFAULT_OPTIONS);
    expectLastCall().once();
    logging.write(ImmutableList.of(DEBUG_ENTRY), DEFAULT_OPTIONS);
    expectLastCall().once();
    logging.write(ImmutableList.of(NOTICE_ENTRY), DEFAULT_OPTIONS);
    expectLastCall().once();
    logging.write(ImmutableList.of(ERROR_ENTRY), DEFAULT_OPTIONS);
    expectLastCall().once();
    logging.write(ImmutableList.of(CRITICAL_ENTRY), DEFAULT_OPTIONS);
    expectLastCall().once();
    logging.write(ImmutableList.of(ALERT_ENTRY), DEFAULT_OPTIONS);
    expectLastCall().once();
    logging.write(ImmutableList.of(EMERGENCY_ENTRY), DEFAULT_OPTIONS);
    expectLastCall().once();
    replay(options, logging);
    Handler handler = new LoggingHandler(LOG_NAME, options, DEFAULT_RESOURCE);
    handler.setLevel(Level.ALL);
    handler.setFormatter(new TestFormatter());
    // default levels
    handler.publish(newLogRecord(Level.FINEST, MESSAGE));
    handler.publish(newLogRecord(Level.FINER, MESSAGE));
    handler.publish(newLogRecord(Level.FINE, MESSAGE));
    handler.publish(newLogRecord(Level.CONFIG, MESSAGE));
    handler.publish(newLogRecord(Level.INFO, MESSAGE));
    handler.publish(newLogRecord(Level.WARNING, MESSAGE));
    handler.publish(newLogRecord(Level.SEVERE, MESSAGE));
    // Logging levels
    handler.publish(newLogRecord(LoggingLevel.DEBUG, MESSAGE));
    handler.publish(newLogRecord(LoggingLevel.NOTICE, MESSAGE));
    handler.publish(newLogRecord(LoggingLevel.ERROR, MESSAGE));
    handler.publish(newLogRecord(LoggingLevel.CRITICAL, MESSAGE));
    handler.publish(newLogRecord(LoggingLevel.ALERT, MESSAGE));
    handler.publish(newLogRecord(LoggingLevel.EMERGENCY, MESSAGE));
  }

  @Test
  public void testPublishCustomResource() {
    MonitoredResource resource = MonitoredResource.of("custom", ImmutableMap.<String, String>of());
    logging.write(
        ImmutableList.of(FINEST_ENTRY),
        WriteOption.logName(LOG_NAME),
        WriteOption.resource(resource),
        WriteOption.labels(BASE_SEVERITY_MAP));
    expectLastCall().once();
    replay(options, logging);
    Handler handler = new LoggingHandler(LOG_NAME, options, resource);
    handler.setLevel(Level.ALL);
    handler.setFormatter(new TestFormatter());
    handler.publish(newLogRecord(Level.FINEST, MESSAGE));
  }

  @Test
  public void testPublishCustomResourceWithFolder() {
    testPublishCustomResourceWithDestination(FINEST_ENTRY, LogDestinationName.folder("folder"));
  }

  @Test
  public void testPublishCustomResourceWithBilling() {
    testPublishCustomResourceWithDestination(
        FINEST_ENTRY, LogDestinationName.billingAccount("billing"));
  }

  @Test
  public void testPublishCustomResourceWithOrganization() {
    testPublishCustomResourceWithDestination(
        FINEST_ENTRY, LogDestinationName.organization("organization"));
  }

  @Test
  public void testPublishCustomResourceWithProject() {
    testPublishCustomResourceWithDestination(FINEST_ENTRY, LogDestinationName.project(PROJECT));
  }

  @Test
  public void testPublishKubernetesContainerResource() {
    MonitoredResource resource =
        MonitoredResource.of(
            "k8s_container",
            ImmutableMap.of(
                "project_id",
                PROJECT,
                "container_name",
                "metadata-agent",
                "location",
                "us-central1-c",
                "namespace_name",
                "test-system",
                "pod_name",
                "metadata-agent-cluster"));
    logging.write(
        ImmutableList.of(FINEST_ENTRY),
        WriteOption.logName(LOG_NAME),
        WriteOption.resource(resource),
        WriteOption.labels(BASE_SEVERITY_MAP));
    expectLastCall().once();
    replay(options, logging);
    Handler handler = new LoggingHandler(LOG_NAME, options, resource);
    handler.setLevel(Level.ALL);
    handler.setFormatter(new TestFormatter());
    handler.publish(newLogRecord(Level.FINEST, MESSAGE));
  }

  @Test
  public void testEnhancedLogEntry() {
    logging.write(ImmutableList.of(FINEST_ENHANCED_ENTRY), DEFAULT_OPTIONS);
    expectLastCall().once();
    replay(options, logging);
    Handler handler =
        new LoggingHandler(
            LOG_NAME, options, DEFAULT_RESOURCE, ImmutableList.of(new TestLoggingEnhancer()));
    handler.setLevel(Level.ALL);
    handler.setFormatter(new TestFormatter());
    handler.publish(newLogRecord(Level.FINEST, MESSAGE));
  }

  void validateJsonOutput(ByteArrayOutputStream bout) throws UnsupportedEncodingException {
    final String expectedOutput =
        "{\"severity\":\"INFO\",\"time\":\"1970-01-02T10:17:36.789Z\",\"logging.googleapis.com/labels\":{\"enhanced\":\"true\"},\"logging.googleapis.com/trace_sampled\":false,\"message\":\"message\"}";
    assertEquals(
        JsonParser.parseString(expectedOutput), JsonParser.parseString(bout.toString("UTF-8")));
  }

  @Test
  public void testEnhancedLogEntryPrintToStdout() throws UnsupportedEncodingException {
    outputStreamPatcher.patch();

    replay(options, logging);

    LoggingHandler handler =
        new LoggingHandler(
            LOG_NAME, options, DEFAULT_RESOURCE, ImmutableList.of(new TestLoggingEnhancer()));
    handler.setLevel(Level.ALL);
    handler.setFormatter(new TestFormatter());
    handler.setLogTarget(LoggingHandler.LogTarget.STDOUT);
    handler.publish(newLogRecord(Level.INFO, MESSAGE));

    validateJsonOutput(outputStreamPatcher.out);
  }

  @Test
  public void testEnhancedLogEntryPrintToStderr() throws UnsupportedEncodingException {
    outputStreamPatcher.patch();

    replay(options, logging);

    LoggingHandler handler =
        new LoggingHandler(
            LOG_NAME, options, DEFAULT_RESOURCE, ImmutableList.of(new TestLoggingEnhancer()));
    handler.setLevel(Level.ALL);
    handler.setFormatter(new TestFormatter());
    handler.setLogTarget(LoggingHandler.LogTarget.STDERR);
    handler.publish(newLogRecord(Level.INFO, MESSAGE));

    validateJsonOutput(outputStreamPatcher.err);
  }

  @Test
  public void testTraceEnhancedLogEntry() {
    logging.write(ImmutableList.of(TRACE_ENTRY), DEFAULT_OPTIONS);
    expectLastCall().once();
    replay(options, logging);
    LoggingEnhancer enhancer = new TraceLoggingEnhancer();
    TraceLoggingEnhancer.setCurrentTraceId("projects/projectId/traces/traceId");
    Handler handler =
        new LoggingHandler(LOG_NAME, options, DEFAULT_RESOURCE, ImmutableList.of(enhancer));
    handler.setLevel(Level.ALL);
    handler.setFormatter(new TestFormatter());
    handler.publish(newLogRecord(Level.FINEST, MESSAGE));
  }

  @Test
  public void testReportWriteError() {
    RuntimeException ex = new RuntimeException();
    logging.write(ImmutableList.of(FINEST_ENTRY), DEFAULT_OPTIONS);
    expectLastCall().andStubThrow(ex);
    replay(options, logging);
    ErrorManager errorManager = EasyMock.createStrictMock(ErrorManager.class);
    errorManager.error(null, ex, ErrorManager.WRITE_FAILURE);
    expectLastCall().once();
    replay(errorManager);
    Handler handler = new LoggingHandler(LOG_NAME, options, DEFAULT_RESOURCE);
    handler.setLevel(Level.ALL);
    handler.setErrorManager(errorManager);
    handler.setFormatter(new TestFormatter());
    handler.publish(newLogRecord(Level.FINEST, MESSAGE));
    verify(errorManager);
  }

  @Test
  public void testReportFlushError() {
    RuntimeException ex = new RuntimeException();
    logging.write(ImmutableList.of(FINEST_ENTRY), DEFAULT_OPTIONS);
    expectLastCall().once();
    logging.flush();
    expectLastCall().andThrow(ex);
    ErrorManager errorManager = EasyMock.createStrictMock(ErrorManager.class);
    errorManager.error(null, ex, ErrorManager.FLUSH_FAILURE);
    expectLastCall().once();
    replay(options, logging, errorManager);
    LogRecord record = newLogRecord(Level.FINEST, MESSAGE);
    Handler handler = new LoggingHandler(LOG_NAME, options, DEFAULT_RESOURCE);
    handler.setLevel(Level.ALL);
    handler.setErrorManager(errorManager);
    handler.setFormatter(new TestFormatter());
    handler.publish(record);
    handler.flush();
    verify(errorManager);
  }

  @Test
  public void testReportFormatError() {
    replay(options, logging);
    Formatter formatter = EasyMock.createStrictMock(Formatter.class);
    RuntimeException ex = new RuntimeException();
    ErrorManager errorManager = EasyMock.createStrictMock(ErrorManager.class);
    errorManager.error(null, ex, ErrorManager.FORMAT_FAILURE);
    expectLastCall().once();
    LogRecord record = newLogRecord(Level.FINEST, MESSAGE);
    expect(formatter.format(record)).andThrow(ex);
    replay(errorManager, formatter);
    Handler handler = new LoggingHandler(LOG_NAME, options, DEFAULT_RESOURCE);
    handler.setLevel(Level.ALL);
    handler.setErrorManager(errorManager);
    handler.setFormatter(formatter);
    handler.publish(record);
    verify(errorManager, formatter);
  }

  // BUG(1795): rewrite this test when flush actually works.
  @Ignore
  @Test
  public void testFlushLevel() {
    logging.setFlushSeverity(Severity.WARNING);
    expectLastCall().once();
    logging.write(
        ImmutableList.of(
            FINEST_ENTRY, FINER_ENTRY, FINE_ENTRY, CONFIG_ENTRY, INFO_ENTRY, WARNING_ENTRY),
        DEFAULT_OPTIONS);
    expectLastCall().once();
    replay(options, logging);
    LoggingHandler handler = new LoggingHandler(LOG_NAME, options, DEFAULT_RESOURCE);
    handler.setLevel(Level.ALL);
    handler.setFlushLevel(Level.WARNING);
    handler.setFormatter(new TestFormatter());
    handler.publish(newLogRecord(Level.FINEST, MESSAGE));
    handler.publish(newLogRecord(Level.FINER, MESSAGE));
    handler.publish(newLogRecord(Level.FINE, MESSAGE));
    handler.publish(newLogRecord(Level.CONFIG, MESSAGE));
    handler.publish(newLogRecord(Level.INFO, MESSAGE));
    handler.publish(newLogRecord(Level.WARNING, MESSAGE));
  }

  @Test
  public void testFlushLevelOff() {
    logging.setFlushSeverity(Severity.NONE);
    expectLastCall().once();
    replay(options, logging);
    LoggingHandler handler = new LoggingHandler(LOG_NAME, options, DEFAULT_RESOURCE);
    handler.setFlushLevel(Level.OFF);
    assertEquals(Level.OFF, handler.getFlushLevel());
  }

  @Test
  public void testFlushLevelOn() {
    logging.setFlushSeverity(Severity.WARNING);
    expectLastCall().once();
    replay(options, logging);
    LoggingHandler handler = new LoggingHandler(LOG_NAME, options, DEFAULT_RESOURCE);
    handler.setFlushLevel(Level.WARNING);
    assertEquals(Level.WARNING, handler.getFlushLevel());
  }

  @Test
  public void testCustomFlushLevelOn() {
    CustomLevel level = new CustomLevel();
    logging.setFlushSeverity(Severity.INFO);
    expectLastCall().once();
    replay(options, logging);
    LoggingHandler handler = new LoggingHandler(LOG_NAME, options, DEFAULT_RESOURCE);
    handler.setFlushLevel(level);
    assertEquals(level, handler.getFlushLevel());
  }

  @Test
  public void testSyncWrite() {
    reset(logging);
    LogEntry entry =
        LogEntry.newBuilder(Payload.StringPayload.of(MESSAGE))
            .setSeverity(Severity.DEBUG)
            .addLabel("levelName", "FINEST")
            .addLabel("levelValue", String.valueOf(Level.FINEST.intValue()))
            .setTimestamp(123456789L)
            .build();

    logging.setWriteSynchronicity(Synchronicity.ASYNC);
    logging.setWriteSynchronicity(Synchronicity.SYNC);
    logging.write(ImmutableList.of(entry), DEFAULT_OPTIONS);
    logging.setFlushSeverity(Severity.ERROR);
    replay(options, logging);

    LoggingHandler handler = new LoggingHandler(LOG_NAME, options, DEFAULT_RESOURCE);
    handler.setLevel(Level.ALL);
    handler.setSynchronicity(Synchronicity.SYNC);
    handler.setFormatter(new TestFormatter());
    LogRecord record = new LogRecord(Level.FINEST, MESSAGE);
    record.setMillis(123456789L);
    handler.publish(record);
  }

  @Test
  public void testAddHandler() {
    logging.write(ImmutableList.of(FINEST_ENTRY), DEFAULT_OPTIONS);
    expectLastCall().once();
    replay(options, logging);
    LoggingHandler handler =
        new LoggingHandler(LOG_NAME, options, DEFAULT_RESOURCE) {
          @Override
          public void close() {
            // Make close NOOP to avoid mock close exception
          }
        };
    handler.setLevel(Level.ALL);
    handler.setFormatter(new TestFormatter());
    Logger logger = Logger.getLogger(getClass().getName());
    logger.setLevel(Level.ALL);
    LoggingHandler.addHandler(logger, handler);
    logger.log(newLogRecord(Level.FINEST, MESSAGE));
  }

  @Test
  public void testClose() throws Exception {
    logging.write(ImmutableList.of(FINEST_ENTRY), DEFAULT_OPTIONS);
    expectLastCall().once();
    logging.close();
    expectLastCall().once();
    replay(options, logging);
    Handler handler = new LoggingHandler(LOG_NAME, options, DEFAULT_RESOURCE);
    handler.setLevel(Level.ALL);
    handler.setFormatter(new TestFormatter());
    handler.publish(newLogRecord(Level.FINEST, MESSAGE));
    handler.close();
  }

  private void setupOptionsToEnableAutoPopulation(boolean expectDiagnostic) {
    // Reset the one-time instrumentation status population flag so it happens again on this test:
    Instrumentation.setInstrumentationStatus(false);

    reset(options);
    options = EasyMock.createMock(LoggingOptions.class);
    expect(options.getProjectId()).andStubReturn(PROJECT);
    expect(options.getService()).andStubReturn(logging);
    expect(options.getAutoPopulateMetadata()).andStubReturn(Boolean.TRUE);

    // due to the EasyMock bug https://github.com/easymock/easymock/issues/130
    // it is impossible to define expectation for varargs using anyObject() matcher
    // the following mock uses the known fact that the method pass two exclusion prefixes
    // the following mocks should be replaced with anyObject() matchers when the bug is fixed
    expect(
            logging.populateMetadata(
                EasyMock.eq(
                    expectDiagnostic
                        ? ImmutableList.of(INFO_ENTRY, DIAGNOSTIC_ENTRY)
                        : ImmutableList.of(INFO_ENTRY)),
                EasyMock.eq(DEFAULT_RESOURCE),
                EasyMock.anyString(),
                EasyMock.anyString()))
        .andReturn(ImmutableList.of(INFO_ENTRY))
        .once();
  }

  @Test
  public void testAutoPopulationEnabled() {
    setupOptionsToEnableAutoPopulation(/* expectDiagnostic= */ false);
    logging.write(ImmutableList.of(INFO_ENTRY), DEFAULT_OPTIONS);
    expectLastCall().once();
    replay(options, logging);
    outputStreamPatcher.patch();

    Handler handler = new LoggingHandler(LOG_NAME, options, DEFAULT_RESOURCE);
    handler.setLevel(Level.ALL);
    handler.setFormatter(new TestFormatter());
    handler.publish(newLogRecord(Level.INFO, MESSAGE));

    // Validate that nothing is printed to STDOUT or STDERR since we don't ask for it.
    assertThat(outputStreamPatcher.out.size()).isEqualTo(0);
    assertThat(outputStreamPatcher.err.size()).isEqualTo(0);
  }

  // Test the deprecated get/setRedirectToStdout methods.
  @SuppressWarnings("deprecation")
  @Test
  public void testSetRedirectToStdoutImpliesLogTarget() {
    replay(options, logging);
    LoggingHandler handler = new LoggingHandler(LOG_NAME, options, DEFAULT_RESOURCE);

    assertThat(handler.getLogTarget()).isEqualTo(LoggingHandler.LogTarget.CLOUD_LOGGING);
    assertThat(handler.getRedirectToStdout()).isFalse();

    handler.setRedirectToStdout(true);
    assertThat(handler.getLogTarget()).isEqualTo(LoggingHandler.LogTarget.STDOUT);
    assertThat(handler.getRedirectToStdout()).isTrue();
  }

  @Test
  public void testRedirectToStdout() {
    setupOptionsToEnableAutoPopulation(/* expectDiagnostic= */ true);
    replay(options, logging);
    outputStreamPatcher.patch();

    LoggingHandler handler = new LoggingHandler(LOG_NAME, options, DEFAULT_RESOURCE);
    handler.setLevel(Level.ALL);
    handler.setFormatter(new TestFormatter());
    handler.setLogTarget(LoggingHandler.LogTarget.STDOUT);

    handler.publish(newLogRecord(Level.INFO, MESSAGE));

    assertThat(outputStreamPatcher.out.size()).isGreaterThan(0);
    assertThat(outputStreamPatcher.err.size()).isEqualTo(0);
  }

  @Test
  public void testRedirectToStderr() {
    setupOptionsToEnableAutoPopulation(/* expectDiagnostic= */ true);
    replay(options, logging);
    outputStreamPatcher.patch();

    LoggingHandler handler = new LoggingHandler(LOG_NAME, options, DEFAULT_RESOURCE);
    handler.setLevel(Level.ALL);
    handler.setFormatter(new TestFormatter());
    handler.setLogTarget(LoggingHandler.LogTarget.STDERR);

    handler.publish(newLogRecord(Level.INFO, MESSAGE));

    assertThat(outputStreamPatcher.out.size()).isEqualTo(0);
    assertThat(outputStreamPatcher.err.size()).isGreaterThan(0);
  }

  private void testPublishCustomResourceWithDestination(
      LogEntry entry, LogDestinationName destination) {
    MonitoredResource resource = MonitoredResource.of("custom", ImmutableMap.<String, String>of());
    logging.write(
        ImmutableList.of(entry),
        WriteOption.logName(LOG_NAME),
        WriteOption.resource(resource),
        WriteOption.labels(BASE_SEVERITY_MAP),
        WriteOption.destination(destination));
    expectLastCall().once();
    replay(options, logging);
    Handler handler = new LoggingHandler(LOG_NAME, options, resource, null, destination);
    handler.setLevel(Level.ALL);
    handler.setFormatter(new TestFormatter());
    handler.publish(newLogRecord(Level.FINEST, MESSAGE));
  }
}
