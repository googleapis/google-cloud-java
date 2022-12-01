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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.Payload.JsonPayload;
import com.google.cloud.logging.Payload.ProtoPayload;
import com.google.cloud.logging.Payload.StringPayload;
import com.google.common.collect.ImmutableMap;
import com.google.common.testing.EqualsTester;
import com.google.gson.JsonParser;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import java.time.Instant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@SuppressWarnings("deprecation") // We're testing our own deprecated Builder methods
public class LogEntryTest {

  private static final String LOG_NAME = "syslog";
  private static final String PROJECT = "project";
  private static final MonitoredResource RESOURCE =
      MonitoredResource.newBuilder("cloudsql_database")
          .setLabels(ImmutableMap.of("datasetId", "myDataset", "zone", "myZone"))
          .build();
  private static final Instant TIMESTAMP = Instant.parse("1984-08-13T15:35:30.123Z");
  private static final Instant RECEIVE_TIMESTAMP = Instant.parse("1984-08-13T15:35:31.0Z");
  private static final Severity SEVERITY = Severity.ALERT;
  private static final String INSERT_ID = "insertId";
  private static final HttpRequest HTTP_REQUEST =
      HttpRequest.newBuilder()
          .setRequestMethod(HttpRequest.RequestMethod.GET)
          .setStatus(404)
          .build();
  private static final ImmutableMap<String, String> LABELS =
      ImmutableMap.of("key1", "value1", "key2", "value2");
  private static final Operation OPERATION = Operation.of("id", "producer");
  private static final String TRACE = "trace";
  private static final String SPAN_ID = "spanId";
  private static final boolean TRACE_SAMPLED = true;
  private static final SourceLocation SOURCE_LOCATION =
      new SourceLocation.Builder().setFile("file").setLine(42L).setFunction("function").build();
  private static final StringPayload STRING_PAYLOAD = StringPayload.of("payload");
  private static final JsonPayload JSON_PAYLOAD =
      JsonPayload.of(ImmutableMap.<String, Object>of("key1", "val", "key2", 123, "key3", false));
  private static final ProtoPayload PROTO_PAYLOAD =
      ProtoPayload.of(Any.pack(Empty.getDefaultInstance()));
  private static final LogDestinationName BILLING_NAME =
      LogDestinationName.billingAccount("000000-111111-222222");
  private static final LogDestinationName PROJECT_NAME = LogDestinationName.project(PROJECT);
  private static final LogDestinationName FOLDER_NAME = LogDestinationName.folder("123456789");
  private static final LogDestinationName ORG_NAME = LogDestinationName.organization("1122334455");
  private static final LogEntry STRING_ENTRY =
      LogEntry.newBuilder(STRING_PAYLOAD)
          .setLogName(LOG_NAME)
          .setResource(RESOURCE)
          .setTimestamp(TIMESTAMP)
          .setReceiveTimestamp(RECEIVE_TIMESTAMP)
          .setSeverity(SEVERITY)
          .setInsertId(INSERT_ID)
          .setHttpRequest(HTTP_REQUEST)
          .setLabels(LABELS)
          .setOperation(OPERATION)
          .setTrace(TRACE)
          .setSpanId(SPAN_ID)
          .setTraceSampled(TRACE_SAMPLED)
          .setSourceLocation(SOURCE_LOCATION)
          .build();
  private static final LogEntry JSON_ENTRY =
      LogEntry.newBuilder(JSON_PAYLOAD)
          .setLogName(LOG_NAME)
          .setResource(RESOURCE)
          .setTimestamp(TIMESTAMP)
          .setReceiveTimestamp(RECEIVE_TIMESTAMP)
          .setSeverity(SEVERITY)
          .setInsertId(INSERT_ID)
          .setHttpRequest(HTTP_REQUEST)
          .setLabels(LABELS)
          .setOperation(OPERATION)
          .setTrace(TRACE)
          .setSpanId(SPAN_ID)
          .setTraceSampled(TRACE_SAMPLED)
          .setSourceLocation(SOURCE_LOCATION)
          .build();
  private static final LogEntry PROTO_ENTRY =
      LogEntry.newBuilder(PROTO_PAYLOAD)
          .setLogName(LOG_NAME)
          .setResource(RESOURCE)
          .setTimestamp(TIMESTAMP)
          .setReceiveTimestamp(RECEIVE_TIMESTAMP)
          .setSeverity(SEVERITY)
          .setInsertId(INSERT_ID)
          .setHttpRequest(HTTP_REQUEST)
          .setLabels(LABELS)
          .setOperation(OPERATION)
          .setTrace(TRACE)
          .setSpanId(SPAN_ID)
          .setTraceSampled(TRACE_SAMPLED)
          .setSourceLocation(SOURCE_LOCATION)
          .build();
  private static final LogEntry STRING_ENTRY_BILLING =
      STRING_ENTRY.toBuilder().setDestination(BILLING_NAME).build();
  private static final LogEntry STRING_ENTRY_PROJECT =
      STRING_ENTRY.toBuilder().setDestination(PROJECT_NAME).build();
  private static final LogEntry STRING_ENTRY_FOLDER =
      STRING_ENTRY.toBuilder().setDestination(FOLDER_NAME).build();
  private static final LogEntry STRING_ENTRY_ORG =
      STRING_ENTRY.toBuilder().setDestination(ORG_NAME).build();

  @Test
  public void testOf() {
    LogEntry logEntry = LogEntry.of(STRING_PAYLOAD);
    assertEquals(STRING_PAYLOAD, logEntry.getPayload());
    assertEquals(Severity.DEFAULT, logEntry.getSeverity());
    assertEquals(ImmutableMap.of(), logEntry.getLabels());
    assertNull(logEntry.getLogName());
    assertNull(logEntry.getResource());
    assertNull(logEntry.getTimestamp());
    assertNull(logEntry.getInstantTimestamp());
    assertNull(logEntry.getReceiveTimestamp());
    assertNull(logEntry.getInstantReceiveTimestamp());
    assertNull(logEntry.getInsertId());
    assertNull(logEntry.getHttpRequest());
    assertNull(logEntry.getOperation());
    assertNull(logEntry.getTrace());
    assertNull(logEntry.getSpanId());
    assertFalse(logEntry.getTraceSampled());
    assertNull(logEntry.getSourceLocation());
    logEntry = LogEntry.of(LOG_NAME, RESOURCE, STRING_PAYLOAD);
    assertEquals(STRING_PAYLOAD, logEntry.getPayload());
    assertEquals(LOG_NAME, logEntry.getLogName());
    assertEquals(RESOURCE, logEntry.getResource());
    assertEquals(Severity.DEFAULT, logEntry.getSeverity());
    assertEquals(ImmutableMap.of(), logEntry.getLabels());
    assertEquals(ImmutableMap.of(), logEntry.getLabels());
    assertNull(logEntry.getTimestamp());
    assertNull(logEntry.getInstantTimestamp());
    assertNull(logEntry.getReceiveTimestamp());
    assertNull(logEntry.getInstantReceiveTimestamp());
    assertNull(logEntry.getInsertId());
    assertNull(logEntry.getHttpRequest());
    assertNull(logEntry.getOperation());
    assertNull(logEntry.getTrace());
    assertNull(logEntry.getSpanId());
    assertFalse(logEntry.getTraceSampled());
    assertNull(logEntry.getSourceLocation());
  }

  @Test
  public void testBuilder() {
    assertEquals(LOG_NAME, STRING_ENTRY.getLogName());
    assertEquals(RESOURCE, STRING_ENTRY.getResource());
    assertEquals(TIMESTAMP.toEpochMilli(), (long) STRING_ENTRY.getTimestamp());
    assertEquals(TIMESTAMP, STRING_ENTRY.getInstantTimestamp());
    assertEquals(RECEIVE_TIMESTAMP.toEpochMilli(), (long) STRING_ENTRY.getReceiveTimestamp());
    assertEquals(RECEIVE_TIMESTAMP, STRING_ENTRY.getInstantReceiveTimestamp());
    assertEquals(SEVERITY, STRING_ENTRY.getSeverity());
    assertEquals(INSERT_ID, STRING_ENTRY.getInsertId());
    assertEquals(HTTP_REQUEST, STRING_ENTRY.getHttpRequest());
    assertEquals(LABELS, STRING_ENTRY.getLabels());
    assertEquals(OPERATION, STRING_ENTRY.getOperation());
    assertEquals(TRACE, STRING_ENTRY.getTrace());
    assertEquals(SPAN_ID, STRING_ENTRY.getSpanId());
    assertEquals(TRACE_SAMPLED, STRING_ENTRY.getTraceSampled());
    assertEquals(SOURCE_LOCATION, STRING_ENTRY.getSourceLocation());
    assertEquals(STRING_PAYLOAD, STRING_ENTRY.getPayload());
    assertEquals(LOG_NAME, JSON_ENTRY.getLogName());
    assertEquals(RESOURCE, JSON_ENTRY.getResource());
    assertEquals(TIMESTAMP.toEpochMilli(), (long) JSON_ENTRY.getTimestamp());
    assertEquals(TIMESTAMP, JSON_ENTRY.getInstantTimestamp());
    assertEquals(RECEIVE_TIMESTAMP.toEpochMilli(), (long) JSON_ENTRY.getReceiveTimestamp());
    assertEquals(RECEIVE_TIMESTAMP, JSON_ENTRY.getInstantReceiveTimestamp());
    assertEquals(SEVERITY, JSON_ENTRY.getSeverity());
    assertEquals(INSERT_ID, JSON_ENTRY.getInsertId());
    assertEquals(HTTP_REQUEST, JSON_ENTRY.getHttpRequest());
    assertEquals(LABELS, JSON_ENTRY.getLabels());
    assertEquals(OPERATION, JSON_ENTRY.getOperation());
    assertEquals(TRACE, JSON_ENTRY.getTrace());
    assertEquals(SPAN_ID, JSON_ENTRY.getSpanId());
    assertEquals(TRACE_SAMPLED, JSON_ENTRY.getTraceSampled());
    assertEquals(SOURCE_LOCATION, JSON_ENTRY.getSourceLocation());
    assertEquals(JSON_PAYLOAD, JSON_ENTRY.getPayload());

    assertEquals(LOG_NAME, PROTO_ENTRY.getLogName());
    assertEquals(RESOURCE, PROTO_ENTRY.getResource());
    assertEquals(TIMESTAMP.toEpochMilli(), (long) PROTO_ENTRY.getTimestamp());
    assertEquals(TIMESTAMP, PROTO_ENTRY.getInstantTimestamp());
    assertEquals(RECEIVE_TIMESTAMP.toEpochMilli(), (long) PROTO_ENTRY.getReceiveTimestamp());
    assertEquals(RECEIVE_TIMESTAMP, PROTO_ENTRY.getInstantReceiveTimestamp());
    assertEquals(SEVERITY, PROTO_ENTRY.getSeverity());
    assertEquals(INSERT_ID, PROTO_ENTRY.getInsertId());
    assertEquals(HTTP_REQUEST, PROTO_ENTRY.getHttpRequest());
    assertEquals(LABELS, PROTO_ENTRY.getLabels());
    assertEquals(OPERATION, PROTO_ENTRY.getOperation());
    assertEquals(TRACE, PROTO_ENTRY.getTrace());
    assertEquals(SPAN_ID, PROTO_ENTRY.getSpanId());
    assertEquals(TRACE_SAMPLED, PROTO_ENTRY.getTraceSampled());
    assertEquals(SOURCE_LOCATION, PROTO_ENTRY.getSourceLocation());
    assertEquals(PROTO_PAYLOAD, PROTO_ENTRY.getPayload());
    LogEntry logEntry =
        LogEntry.newBuilder(STRING_PAYLOAD)
            .setPayload(StringPayload.of("otherPayload"))
            .setLogName(LOG_NAME)
            .setResource(RESOURCE)
            .setTimestamp(TIMESTAMP)
            .setReceiveTimestamp(RECEIVE_TIMESTAMP)
            .setSeverity(SEVERITY)
            .setInsertId(INSERT_ID)
            .setHttpRequest(HTTP_REQUEST)
            .addLabel("key1", "value1")
            .addLabel("key2", "value2")
            .setOperation(OPERATION)
            .setTrace(TRACE)
            .setSpanId(SPAN_ID)
            .setTraceSampled(TRACE_SAMPLED)
            .setSourceLocation(SOURCE_LOCATION)
            .build();
    assertEquals(LOG_NAME, logEntry.getLogName());
    assertEquals(RESOURCE, logEntry.getResource());
    assertEquals(TIMESTAMP.toEpochMilli(), (long) logEntry.getTimestamp());
    assertEquals(TIMESTAMP, logEntry.getInstantTimestamp());
    assertEquals(RECEIVE_TIMESTAMP.toEpochMilli(), (long) logEntry.getReceiveTimestamp());
    assertEquals(RECEIVE_TIMESTAMP, logEntry.getInstantReceiveTimestamp());
    assertEquals(SEVERITY, logEntry.getSeverity());
    assertEquals(INSERT_ID, logEntry.getInsertId());
    assertEquals(HTTP_REQUEST, logEntry.getHttpRequest());
    assertEquals(LABELS, logEntry.getLabels());
    assertEquals(OPERATION, logEntry.getOperation());
    assertEquals(TRACE, logEntry.getTrace());
    assertEquals(SPAN_ID, logEntry.getSpanId());
    assertEquals(TRACE_SAMPLED, logEntry.getTraceSampled());
    assertEquals(SOURCE_LOCATION, logEntry.getSourceLocation());
    assertEquals(StringPayload.of("otherPayload"), logEntry.getPayload());
  }

  @Test
  public void testToBuilder() {
    compareLogEntry(STRING_ENTRY, STRING_ENTRY.toBuilder().build(), true);
    HttpRequest request =
        HttpRequest.newBuilder()
            .setRequestMethod(HttpRequest.RequestMethod.POST)
            .setStatus(500)
            .build();
    LogEntry logEntry =
        STRING_ENTRY
            .toBuilder()
            .setPayload(StringPayload.of("otherPayload"))
            .setLogName("otherLogName")
            .setResource(MonitoredResource.newBuilder("global").build())
            .setTimestamp(43)
            .setReceiveTimestamp(34)
            .setSeverity(Severity.DEBUG)
            .setInsertId("otherInsertId")
            .setHttpRequest(request)
            .clearLabels()
            .addLabel("key", "value")
            .setOperation(Operation.of("otherId", "otherProducer"))
            .setTrace("otherTrace")
            .setSpanId("otherSpanId")
            .setTraceSampled(false)
            .setSourceLocation(new SourceLocation.Builder().setFile("hey.java").build())
            .build();
    assertEquals("otherLogName", logEntry.getLogName());
    assertEquals(MonitoredResource.newBuilder("global").build(), logEntry.getResource());
    assertEquals(43, (long) logEntry.getTimestamp());
    assertEquals(34, (long) logEntry.getReceiveTimestamp());
    assertEquals(Severity.DEBUG, logEntry.getSeverity());
    assertEquals("otherInsertId", logEntry.getInsertId());
    assertEquals(request, logEntry.getHttpRequest());
    assertEquals(ImmutableMap.of("key", "value"), logEntry.getLabels());
    assertEquals(Operation.of("otherId", "otherProducer"), logEntry.getOperation());
    assertEquals("otherTrace", logEntry.getTrace());
    assertEquals("otherSpanId", logEntry.getSpanId());
    assertFalse(logEntry.getTraceSampled());
    assertEquals(
        new SourceLocation.Builder().setFile("hey.java").build(), logEntry.getSourceLocation());
    assertEquals(StringPayload.of("otherPayload"), logEntry.getPayload());
    logEntry =
        logEntry
            .toBuilder()
            .setPayload(STRING_PAYLOAD)
            .setLogName(LOG_NAME)
            .setResource(RESOURCE)
            .setTimestamp(TIMESTAMP)
            .setReceiveTimestamp(RECEIVE_TIMESTAMP)
            .setSeverity(SEVERITY)
            .setInsertId(INSERT_ID)
            .setHttpRequest(HTTP_REQUEST)
            .setLabels(LABELS)
            .setOperation(OPERATION)
            .setTrace(TRACE)
            .setSpanId(SPAN_ID)
            .setTraceSampled(TRACE_SAMPLED)
            .setSourceLocation(SOURCE_LOCATION)
            .build();
    compareLogEntry(STRING_ENTRY, logEntry, true);
  }

  @Test
  public void testToAndFromPb() {
    compareLogEntry(STRING_ENTRY, LogEntry.fromPb(STRING_ENTRY.toPb(PROJECT)), false);
    compareLogEntry(JSON_ENTRY, LogEntry.fromPb(JSON_ENTRY.toPb(PROJECT)), false);
    compareLogEntry(PROTO_ENTRY, LogEntry.fromPb(PROTO_ENTRY.toPb(PROJECT)), false);
    compareLogEntry(
        STRING_ENTRY_BILLING, LogEntry.fromPb(STRING_ENTRY_BILLING.toPb(PROJECT)), true);
    compareLogEntry(STRING_ENTRY_FOLDER, LogEntry.fromPb(STRING_ENTRY_FOLDER.toPb(PROJECT)), true);
    compareLogEntry(STRING_ENTRY_ORG, LogEntry.fromPb(STRING_ENTRY_ORG.toPb(PROJECT)), true);
    compareLogEntry(
        STRING_ENTRY_PROJECT, LogEntry.fromPb(STRING_ENTRY_PROJECT.toPb(PROJECT)), true);
    LogEntry logEntry = LogEntry.of(STRING_PAYLOAD);
    compareLogEntry(logEntry, LogEntry.fromPb(logEntry.toPb(PROJECT)), true);
    logEntry = LogEntry.of(LOG_NAME, RESOURCE, STRING_PAYLOAD);
    compareLogEntry(logEntry, LogEntry.fromPb(logEntry.toPb(PROJECT)), false);
    logEntry =
        LogEntry.newBuilder(STRING_PAYLOAD)
            .setLogName(LOG_NAME)
            .setResource(RESOURCE)
            .setDestination(FOLDER_NAME)
            .build();
    compareLogEntry(logEntry, LogEntry.fromPb(logEntry.toPb(PROJECT)), true);
  }

  @Test
  public void testToAndFromPbWithExpectedFailure() {
    LogEntry logEntry =
        LogEntry.newBuilder(STRING_PAYLOAD).setLogName(LOG_NAME).setResource(RESOURCE).build();
    assertThrows(
        AssertionError.class,
        () -> compareLogEntry(logEntry, LogEntry.fromPb(logEntry.toPb(PROJECT)), true));
  }

  private void compareLogEntry(LogEntry expected, LogEntry value, boolean extraValidations) {
    if (extraValidations) {
      new EqualsTester().addEqualityGroup(expected, value).testEquals();
    }
    assertEquals(expected.getLogName(), value.getLogName());
    assertEquals(expected.getResource(), value.getResource());
    assertEquals(expected.getTimestamp(), value.getTimestamp());
    assertEquals(expected.getInstantTimestamp(), value.getInstantTimestamp());
    assertEquals(expected.getReceiveTimestamp(), value.getReceiveTimestamp());
    assertEquals(expected.getInstantReceiveTimestamp(), value.getInstantReceiveTimestamp());
    assertEquals(expected.getSeverity(), value.getSeverity());
    assertEquals(expected.getInsertId(), value.getInsertId());
    assertEquals(expected.getHttpRequest(), value.getHttpRequest());
    assertEquals(expected.getLabels(), value.getLabels());
    assertEquals(expected.getOperation(), value.getOperation());
    assertEquals(expected.getTrace(), value.getTrace());
    assertEquals(expected.getSpanId(), value.getSpanId());
    assertEquals(expected.getTraceSampled(), value.getTraceSampled());
    assertEquals(expected.getSourceLocation(), value.getSourceLocation());
    assertEquals(expected.getPayload(), value.getPayload());
  }

  private static final String[] EXPECTED_STRUCTURED_LOGS = {
    "{\"severity\":\"ALERT\",\"time\":\"1984-08-13T15:35:30.123Z\",\"httpRequest\":{\"requestMethod\":\"GET\",\"status\":404,\"cacheLookup\":false,\"cacheHit\":false,\"cacheValidatedWithOriginServer\":false},\"logging.googleapis.com/insertId\":\"insertId\",\"logging.googleapis.com/labels\":{\"key1\":\"value1\",\"key2\":\"value2\"},\"logging.googleapis.com/operation\":{\"id\":\"id\",\"producer\":\"producer\",\"first\":false,\"last\":false},\"logging.googleapis.com/sourceLocation\":{\"file\":\"file\",\"line\":\"42\",\"function\":\"function\"},\"logging.googleapis.com/spanId\":\"spanId\",\"logging.googleapis.com/trace\":\"trace\",\"logging.googleapis.com/trace_sampled\":true,\"message\":\"payload\"}",
    "{\"severity\":\"ALERT\",\"time\":\"1984-08-13T15:35:30.123Z\",\"httpRequest\":{\"requestMethod\":\"GET\",\"status\":404,\"cacheLookup\":false,\"cacheHit\":false,\"cacheValidatedWithOriginServer\":false},\"logging.googleapis.com/insertId\":\"insertId\",\"logging.googleapis.com/labels\":{\"key1\":\"value1\",\"key2\":\"value2\"},\"logging.googleapis.com/operation\":{\"id\":\"id\",\"producer\":\"producer\",\"first\":false,\"last\":false},\"logging.googleapis.com/sourceLocation\":{\"file\":\"file\",\"line\":\"42\",\"function\":\"function\"},\"logging.googleapis.com/spanId\":\"spanId\",\"logging.googleapis.com/trace\":\"trace\",\"logging.googleapis.com/trace_sampled\":true,\"key1\":\"val\",\"key2\":123.0,\"key3\":false}"
  };
  private static final LogEntry[] TEST_LOG_ENTRIES = {STRING_ENTRY, JSON_ENTRY};

  @Test
  public void testStructureLogPresentations() {
    for (int i = 0; i < TEST_LOG_ENTRIES.length; i++) {
      String structuredLog = TEST_LOG_ENTRIES[i].toStructuredJsonString();

      assertEquals(
          JsonParser.parseString(EXPECTED_STRUCTURED_LOGS[i]),
          JsonParser.parseString(structuredLog));
    }
  }

  @Test
  public void testStructureLogPresentationWithProtobufPayload() {
    assertThrows(UnsupportedOperationException.class, () -> PROTO_ENTRY.toStructuredJsonString());
  }

  @Test
  public void testStructureLogInvalidSeverity() {
    assertThrows(
        IllegalArgumentException.class,
        () -> PROTO_ENTRY.toBuilder().setSeverity(Severity.NONE).build().toPb(PROJECT));
    assertThrows(
        IllegalArgumentException.class,
        () -> STRING_ENTRY.toBuilder().setSeverity(Severity.NONE).build().toStructuredJsonString());
  }
}
