/*
 * Copyright 2024 Google LLC
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
import static org.junit.Assert.*;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.*;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.logging.v2.LogName;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.SpanProcessor;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.util.Iterator;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITTracingLogsTest extends BaseSystemTest {

  private static final String LOG_ID = formatForTest("test-write-log-entries-log");
  private static final Payload.StringPayload STRING_PAYLOAD =
      Payload.StringPayload.of("stringPayload");
  private static final Payload.JsonPayload OTEL_PAYLOAD =
      Payload.JsonPayload.of(ImmutableMap.<String, Object>of("jsonKey", "jsonValue"));

  private static final MonitoredResource GLOBAL_RESOURCE =
      MonitoredResource.newBuilder("global").build();
  private static final MonitoredResource[] MONITORED_RESOURCES_IN_TEST =
      new MonitoredResource[] {GLOBAL_RESOURCE};

  private static final ContextHandler contextHandler = new ContextHandler();

  private static final String W3C_TEST_TRACE_ID = "12345678901234567890123456789012";
  private static final String W3C_TEST_SPAN_ID = "1234567890123456";
  private static final String W3C_TEST_TRACE_SAMPLED = "0f";
  private static final String W3C_TRACE_CONTEXT =
      "00-" + W3C_TEST_TRACE_ID + "-" + W3C_TEST_SPAN_ID + "-" + W3C_TEST_TRACE_SAMPLED;

  private static final String XCTC_TEST_TRACE_ID = "98765432101234569876543210123456";
  private static final String XCTC_TEST_SPAN_ID = "9876543210123456";
  private static final String X_CLOUD_TRACE_CONTEXT =
      XCTC_TEST_TRACE_ID + "/" + XCTC_TEST_SPAN_ID + ";o=1";

  private static String otelTraceId;
  private static String otelSpanId;
  private static boolean isSampled;
  private static Tracer tracer;
  private static LogEntry w3cEntry;
  private static LogEntry xctcEntry;
  private static LogEntry otelEntry;
  private static LogName logName;

  @BeforeClass
  public static void prepareLogs() throws InterruptedException {
    LoggingOptions loggingOptions = logging.getOptions();
    logName = LogName.ofProjectLogName(loggingOptions.getProjectId(), LOG_ID);
    logging.setWriteSynchronicity(Synchronicity.SYNC);
    w3cEntry =
        LogEntry.newBuilder(STRING_PAYLOAD)
            .setLogName(LOG_ID)
            .addLabel("tracing_source", "w3c")
            .setHttpRequest(HttpRequest.newBuilder().setStatus(500).build())
            .setResource(GLOBAL_RESOURCE)
            .build();
    xctcEntry =
        LogEntry.newBuilder(STRING_PAYLOAD)
            .setLogName(LOG_ID)
            .addLabel("tracing_source", "xctc")
            .setHttpRequest(HttpRequest.newBuilder().setRequestUrl("www.google.com").build())
            .setResource(GLOBAL_RESOURCE)
            .build();
    otelEntry =
        LogEntry.newBuilder(OTEL_PAYLOAD)
            .addLabel("tracing_source", "otel")
            .setLogName(LOG_ID)
            .setResource(GLOBAL_RESOURCE)
            .build();

    // Initializes open telemetry SDK
    InMemorySpanExporter testExporter = InMemorySpanExporter.create();
    SpanProcessor inMemorySpanProcessor = SimpleSpanProcessor.create(testExporter);
    OpenTelemetrySdk openTelemetrySdk =
        OpenTelemetrySdk.builder()
            .setTracerProvider(
                SdkTracerProvider.builder().addSpanProcessor(inMemorySpanProcessor).build())
            .build();
    tracer = openTelemetrySdk.getTracer("ContextTest");
  }

  @After
  public void cleanUpLogs() throws InterruptedException {
    assertTrue(cleanupLog(LOG_ID));
  }

  @Test(timeout = 600_000)
  public void testDetectW3CTraceId() throws InterruptedException {
    // Loads w3c tracing context and writes a log entry
    Context.Builder builder = Context.newBuilder();
    builder.loadW3CTraceParentContext(W3C_TRACE_CONTEXT);
    contextHandler.setCurrentContext(builder.build());
    logging.write(ImmutableList.of(w3cEntry));
    logging.flush();

    // Find the log name and wait until we have at least 1 entry
    Iterator<LogEntry> iterator = waitForLogs(logName, MONITORED_RESOURCES_IN_TEST, 1);
    assertThat(iterator.hasNext()).isTrue();

    LogEntry entry = iterator.next();
    assertEquals(LOG_ID, entry.getLogName());
    assertEquals(ImmutableMap.of("tracing_source", "w3c"), entry.getLabels());
    assertEquals(HttpRequest.newBuilder().setStatus(500).build(), entry.getHttpRequest());
    assertEquals(W3C_TEST_TRACE_ID, entry.getTrace());
    assertEquals(W3C_TEST_SPAN_ID, entry.getSpanId());
    assertEquals(true, entry.getTraceSampled());
  }

  @Test(timeout = 600_000)
  public void testDetectXCTCTraceId() throws InterruptedException {
    // Loads cloud trace context and writes a log entry
    Context.Builder builder = Context.newBuilder();
    builder.loadCloudTraceContext(X_CLOUD_TRACE_CONTEXT);
    contextHandler.setCurrentContext(builder.build());
    logging.write(ImmutableList.of(xctcEntry));
    logging.flush();

    // Find the log name and wait until we have at least 1 entry
    Iterator<LogEntry> iterator = waitForLogs(logName, MONITORED_RESOURCES_IN_TEST, 1);
    assertThat(iterator.hasNext()).isTrue();

    LogEntry entry = iterator.next();
    assertEquals(LOG_ID, entry.getLogName());
    assertEquals(ImmutableMap.of("tracing_source", "xctc"), entry.getLabels());
    assertEquals(
        HttpRequest.newBuilder().setRequestUrl("www.google.com").build(), entry.getHttpRequest());
    assertEquals(XCTC_TEST_TRACE_ID, entry.getTrace());
    assertEquals(XCTC_TEST_SPAN_ID, entry.getSpanId());
    assertEquals(true, entry.getTraceSampled());
  }

  @Test(timeout = 600_000)
  public void testDetectOtelTraceId() throws InterruptedException {
    // Writes a log entry in open telemetry context
    writeLogEntryWithOtelContext(otelEntry);

    // Find the log name and wait until we have at least 1 entry
    Iterator<LogEntry> iterator = waitForLogs(logName, MONITORED_RESOURCES_IN_TEST, 1);
    assertThat(iterator.hasNext()).isTrue();

    LogEntry entry = iterator.next();
    assertEquals(LOG_ID, entry.getLogName());
    assertEquals(OTEL_PAYLOAD, entry.getPayload());
    assertEquals(ImmutableMap.of("tracing_source", "otel"), entry.getLabels());
    assertNull(entry.getHttpRequest());
    assertEquals(otelTraceId, entry.getTrace());
    assertEquals(otelSpanId, entry.getSpanId());
    assertEquals(isSampled, entry.getTraceSampled());
  }

  @Test(timeout = 600_000)
  public void testW3CTraceIdWithOtelContext() throws InterruptedException {
    // Writes a log entry with W3C context and Open Telemetry context
    Context.Builder builder = Context.newBuilder();
    builder.loadW3CTraceParentContext(W3C_TRACE_CONTEXT);
    contextHandler.setCurrentContext(builder.build());
    writeLogEntryWithOtelContext(w3cEntry);

    // Find the log name and wait until we have at least 1 entry
    Iterator<LogEntry> iterator = waitForLogs(logName, MONITORED_RESOURCES_IN_TEST, 1);
    assertThat(iterator.hasNext()).isTrue();

    LogEntry entry = iterator.next();
    assertEquals(LOG_ID, entry.getLogName());
    assertEquals(HttpRequest.newBuilder().setStatus(500).build(), entry.getHttpRequest());
    // Expect to get trace Id, span Id and isSampled flag from Open Telemetry context when it
    // exists.
    assertEquals(otelTraceId, entry.getTrace());
    assertEquals(otelSpanId, entry.getSpanId());
    assertEquals(isSampled, entry.getTraceSampled());
  }

  @Test(timeout = 600_000)
  public void testXCTCTraceIdWithOtelContext() throws InterruptedException {
    // Writes a log entry with cloud trace context and Open Telemetry context
    Context.Builder builder = Context.newBuilder();
    builder.loadCloudTraceContext(X_CLOUD_TRACE_CONTEXT);
    contextHandler.setCurrentContext(builder.build());
    writeLogEntryWithOtelContext(xctcEntry);

    // Find the log name and wait until we have at least 1 entry
    Iterator<LogEntry> iterator = waitForLogs(logName, MONITORED_RESOURCES_IN_TEST, 1);
    assertThat(iterator.hasNext()).isTrue();

    LogEntry entry = iterator.next();
    assertEquals(LOG_ID, entry.getLogName());
    // Expect to get trace Id, span Id and isSampled flag from Open telemetry context when it
    // exists.
    assertEquals(otelTraceId, entry.getTrace());
    assertEquals(otelSpanId, entry.getSpanId());
    assertEquals(isSampled, entry.getTraceSampled());
  }

  // Writes a log entry with otel context
  private static void writeLogEntryWithOtelContext(LogEntry entry) throws InterruptedException {
    Span otelSpan = tracer.spanBuilder("Example Span").startSpan();
    SpanContext currentOtelContext;
    try (Scope scope = otelSpan.makeCurrent()) {
      currentOtelContext = otelSpan.getSpanContext();
      otelTraceId = currentOtelContext.getTraceId();
      otelSpanId = currentOtelContext.getSpanId();
      isSampled = currentOtelContext.isSampled();
      logging.write(ImmutableList.of(entry));
    } catch (Throwable t) {
      otelSpan.recordException(t);
      throw t;
    } finally {
      otelSpan.end();
    }
    logging.flush();
  }
}
