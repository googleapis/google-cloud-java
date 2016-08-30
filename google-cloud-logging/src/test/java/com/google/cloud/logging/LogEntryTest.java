/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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
import static org.junit.Assert.assertNull;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.Payload.JsonPayload;
import com.google.cloud.logging.Payload.ProtoPayload;
import com.google.cloud.logging.Payload.StringPayload;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;

import org.junit.Test;

import java.util.Map;

public class LogEntryTest {

  private static final String LOG_NAME = "syslog";
  private static final MonitoredResource RESOURCE = MonitoredResource.builder("cloudsql_database")
      .labels(ImmutableMap.of("datasetId", "myDataset", "zone", "myZone"))
      .build();
  private static final long TIMESTAMP = 42;
  private static final Severity SEVERITY = Severity.ALERT;
  private static final String INSERT_ID = "insertId";
  private static final HttpRequest HTTP_REQUEST = HttpRequest.builder()
      .requestMethod(HttpRequest.RequestMethod.GET)
      .status(404)
      .build();
  private static final Map<String, String> LABELS =
      ImmutableMap.of("key1", "value1", "key2", "value2");
  private static final Operation OPERATION = Operation.of("id", "producer");
  private static final StringPayload STRING_PAYLOAD = StringPayload.of("payload");
  private static final JsonPayload JSON_PAYLOAD =
      JsonPayload.of(ImmutableMap.<String, Object>of("key", "val"));
  private static final ProtoPayload PROTO_PAYLOAD =
      ProtoPayload.of(Any.pack(Empty.getDefaultInstance()));
  private static final LogEntry STRING_ENTRY = LogEntry.builder(STRING_PAYLOAD)
      .logName(LOG_NAME)
      .resource(RESOURCE)
      .timestamp(TIMESTAMP)
      .severity(SEVERITY)
      .insertId(INSERT_ID)
      .httpRequest(HTTP_REQUEST)
      .labels(LABELS)
      .operation(OPERATION)
      .build();
  private static final LogEntry JSON_ENTRY = LogEntry.builder(JSON_PAYLOAD)
      .logName(LOG_NAME)
      .resource(RESOURCE)
      .timestamp(TIMESTAMP)
      .severity(SEVERITY)
      .insertId(INSERT_ID)
      .httpRequest(HTTP_REQUEST)
      .labels(LABELS)
      .operation(OPERATION)
      .build();
  private static final LogEntry PROTO_ENTRY = LogEntry.builder(PROTO_PAYLOAD)
      .logName(LOG_NAME)
      .resource(RESOURCE)
      .timestamp(TIMESTAMP)
      .severity(SEVERITY)
      .insertId(INSERT_ID)
      .httpRequest(HTTP_REQUEST)
      .labels(LABELS)
      .operation(OPERATION)
      .build();

  @Test
  public void testOf() {
    LogEntry logEntry = LogEntry.of(STRING_PAYLOAD);
    assertEquals(STRING_PAYLOAD, logEntry.payload());
    assertEquals(Severity.DEFAULT, logEntry.severity());
    assertEquals(ImmutableMap.of(), logEntry.labels());
    assertNull(logEntry.logName());
    assertNull(logEntry.resource());
    assertNull(logEntry.timestamp());
    assertNull(logEntry.insertId());
    assertNull(logEntry.httpRequest());
    assertNull(logEntry.operation());
    logEntry = LogEntry.of(LOG_NAME, RESOURCE, STRING_PAYLOAD);
    assertEquals(STRING_PAYLOAD, logEntry.payload());
    assertEquals(LOG_NAME, logEntry.logName());
    assertEquals(RESOURCE, logEntry.resource());
    assertEquals(Severity.DEFAULT, logEntry.severity());
    assertEquals(ImmutableMap.of(), logEntry.labels());
    assertEquals(ImmutableMap.of(), logEntry.labels());
    assertNull(logEntry.timestamp());
    assertNull(logEntry.insertId());
    assertNull(logEntry.httpRequest());
    assertNull(logEntry.operation());
  }

  @Test
  public void testBuilder() {
    assertEquals(LOG_NAME, STRING_ENTRY.logName());
    assertEquals(RESOURCE, STRING_ENTRY.resource());
    assertEquals(TIMESTAMP, (long) STRING_ENTRY.timestamp());
    assertEquals(SEVERITY, STRING_ENTRY.severity());
    assertEquals(INSERT_ID, STRING_ENTRY.insertId());
    assertEquals(HTTP_REQUEST, STRING_ENTRY.httpRequest());
    assertEquals(LABELS, STRING_ENTRY.labels());
    assertEquals(OPERATION, STRING_ENTRY.operation());
    assertEquals(STRING_PAYLOAD, STRING_ENTRY.payload());
    assertEquals(LOG_NAME, JSON_ENTRY.logName());
    assertEquals(RESOURCE, JSON_ENTRY.resource());
    assertEquals(TIMESTAMP, (long) JSON_ENTRY.timestamp());
    assertEquals(SEVERITY, JSON_ENTRY.severity());
    assertEquals(INSERT_ID, JSON_ENTRY.insertId());
    assertEquals(HTTP_REQUEST, JSON_ENTRY.httpRequest());
    assertEquals(LABELS, JSON_ENTRY.labels());
    assertEquals(OPERATION, JSON_ENTRY.operation());
    assertEquals(JSON_PAYLOAD, JSON_ENTRY.payload());
    assertEquals(LOG_NAME, PROTO_ENTRY.logName());
    assertEquals(RESOURCE, PROTO_ENTRY.resource());
    assertEquals(TIMESTAMP, (long) PROTO_ENTRY.timestamp());
    assertEquals(SEVERITY, PROTO_ENTRY.severity());
    assertEquals(INSERT_ID, PROTO_ENTRY.insertId());
    assertEquals(HTTP_REQUEST, PROTO_ENTRY.httpRequest());
    assertEquals(LABELS, PROTO_ENTRY.labels());
    assertEquals(OPERATION, PROTO_ENTRY.operation());
    assertEquals(PROTO_PAYLOAD, PROTO_ENTRY.payload());
    LogEntry logEntry = LogEntry.builder(STRING_PAYLOAD)
        .payload(StringPayload.of("otherPayload"))
        .logName(LOG_NAME)
        .resource(RESOURCE)
        .timestamp(TIMESTAMP)
        .severity(SEVERITY)
        .insertId(INSERT_ID)
        .httpRequest(HTTP_REQUEST)
        .addLabel("key1", "value1")
        .addLabel("key2", "value2")
        .operation(OPERATION)
        .build();
    assertEquals(LOG_NAME, logEntry.logName());
    assertEquals(RESOURCE, logEntry.resource());
    assertEquals(TIMESTAMP, (long) logEntry.timestamp());
    assertEquals(SEVERITY, logEntry.severity());
    assertEquals(INSERT_ID, logEntry.insertId());
    assertEquals(HTTP_REQUEST, logEntry.httpRequest());
    assertEquals(LABELS, logEntry.labels());
    assertEquals(OPERATION, logEntry.operation());
    assertEquals(StringPayload.of("otherPayload"), logEntry.payload());
  }

  @Test
  public void testToBuilder() {
    compareLogEntry(STRING_ENTRY, STRING_ENTRY.toBuilder().build());
    HttpRequest request = HttpRequest.builder()
        .requestMethod(HttpRequest.RequestMethod.POST)
        .status(500)
        .build();
    LogEntry logEntry = STRING_ENTRY.toBuilder()
        .payload(StringPayload.of("otherPayload"))
        .logName("otherLogName")
        .resource(MonitoredResource.builder("global").build())
        .timestamp(43)
        .severity(Severity.DEBUG)
        .insertId("otherInsertId")
        .httpRequest(request)
        .clearLabels()
        .addLabel("key", "value")
        .operation(Operation.of("otherId", "otherProducer"))
        .build();
    assertEquals("otherLogName", logEntry.logName());
    assertEquals(MonitoredResource.builder("global").build(), logEntry.resource());
    assertEquals(43, (long) logEntry.timestamp());
    assertEquals(Severity.DEBUG, logEntry.severity());
    assertEquals("otherInsertId", logEntry.insertId());
    assertEquals(request, logEntry.httpRequest());
    assertEquals(ImmutableMap.of("key", "value"), logEntry.labels());
    assertEquals(Operation.of("otherId", "otherProducer"), logEntry.operation());
    assertEquals(StringPayload.of("otherPayload"), logEntry.payload());
    logEntry = logEntry.toBuilder()
        .payload(STRING_PAYLOAD)
        .logName(LOG_NAME)
        .resource(RESOURCE)
        .timestamp(TIMESTAMP)
        .severity(SEVERITY)
        .insertId(INSERT_ID)
        .httpRequest(HTTP_REQUEST)
        .labels(LABELS)
        .operation(OPERATION)
        .build();
    compareLogEntry(STRING_ENTRY, logEntry);
  }

  @Test
  public void testToAndFromPb() {
    compareLogEntry(STRING_ENTRY, LogEntry.fromPb(STRING_ENTRY.toPb("project")));
    compareLogEntry(JSON_ENTRY, LogEntry.fromPb(JSON_ENTRY.toPb("project")));
    compareLogEntry(PROTO_ENTRY, LogEntry.fromPb(PROTO_ENTRY.toPb("project")));
    LogEntry logEntry = LogEntry.of(STRING_PAYLOAD);
    compareLogEntry(logEntry, LogEntry.fromPb(logEntry.toPb("project")));
    logEntry = LogEntry.of(LOG_NAME, RESOURCE, STRING_PAYLOAD);
    compareLogEntry(logEntry, LogEntry.fromPb(logEntry.toPb("project")));
  }

  private void compareLogEntry(LogEntry expected, LogEntry value) {
    assertEquals(expected, value);
    assertEquals(expected.logName(), value.logName());
    assertEquals(expected.resource(), value.resource());
    assertEquals(expected.timestamp(), value.timestamp());
    assertEquals(expected.severity(), value.severity());
    assertEquals(expected.insertId(), value.insertId());
    assertEquals(expected.httpRequest(), value.httpRequest());
    assertEquals(expected.labels(), value.labels());
    assertEquals(expected.operation(), value.operation());
    assertEquals(expected.payload(), value.payload());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
