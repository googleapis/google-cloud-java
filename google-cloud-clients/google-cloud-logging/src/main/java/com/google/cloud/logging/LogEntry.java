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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.MonitoredResource;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import com.google.logging.v2.LogEntryOperation;
import com.google.logging.v2.LogEntrySourceLocation;
import com.google.logging.v2.LogName;
import com.google.logging.v2.ProjectLogName;
import com.google.protobuf.Timestamp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * A Stackdriver Logging log entry. All log entries are represented via objects of this class. Log
 * entries can have different type of payloads: an UTF-8 string (see
 * {@link Payload.StringPayload}), a JSON object (see {@link Payload.JsonPayload}, or a protobuf
 * object (see {@link Payload.ProtoPayload}). Entries can also store additional information about
 * the operation or the HTTP request that generated the log (see {@link LogEntry#getOperation()} and
 * {@link LogEntry#getHttpRequest()}, respectively).
 *
 * @see <a href="https://cloud.google.com/logging/docs/view/logs_index">Log Entries and Logs</a>
 */
public class LogEntry implements Serializable {

  private static final long serialVersionUID = -944788159728228219L;
  private static final long NANOS_PER_MILLISECOND = 1000000;
  private static final long MILLIS_PER_SECOND = 1000;
  static final Function<com.google.logging.v2.LogEntry, LogEntry> FROM_PB_FUNCTION =
      new Function<com.google.logging.v2.LogEntry, LogEntry>() {
        @Override
        public LogEntry apply(com.google.logging.v2.LogEntry pb) {
          return fromPb(pb);
        }
      };

  private final String logName;
  private final MonitoredResource resource;
  private final Long timestamp;
  private final Long receiveTimestamp;
  private final Severity severity;
  private final String insertId;
  private final HttpRequest httpRequest;
  private final Map<String, String> labels;
  private final Operation operation;
  private final Object trace;
  private final Object spanId;
  private final boolean traceSampled;
  private final SourceLocation sourceLocation;
  private final Payload<?> payload;

  /**
   * A builder for {@code LogEntry} objects.
   */
  public static class Builder {

    private String logName;
    private MonitoredResource resource;
    private Long timestamp;
    private Long receiveTimestamp;
    private Severity severity = Severity.DEFAULT;
    private String insertId;
    private HttpRequest httpRequest;
    private Map<String, String> labels = new HashMap<>();
    private Operation operation;
    private Object trace;
    private Object spanId;
    private boolean traceSampled;
    private SourceLocation sourceLocation;
    private Payload<?> payload;

    Builder(Payload<?> payload) {
      this.payload = payload;
    }

    Builder(LogEntry entry) {
      this.logName = entry.logName;
      this.resource = entry.resource;
      this.timestamp = entry.timestamp;
      this.receiveTimestamp = entry.receiveTimestamp;
      this.severity = entry.severity;
      this.insertId = entry.insertId;
      this.httpRequest = entry.httpRequest;
      this.labels = new HashMap<>(entry.labels);
      this.operation = entry.operation;
      this.trace = entry.trace;
      this.spanId = entry.spanId;
      this.traceSampled = entry.traceSampled;
      this.sourceLocation = entry.sourceLocation;
      this.payload = entry.payload;
    }


    /**
     * Sets the name of the log to which this log entry belongs. The log name must be less than 512
     * characters long and can only include the following characters: upper and lower case
     * alphanumeric characters: {@code [A-Za-z0-9]}; and punctuation characters: {@code _-./}. The
     * forward-slash ({@code /}) characters in the log name must be URL-encoded. Examples:
     * {@code syslog}, {@code library.googleapis.com%2Fbook_log}.
     */
    public Builder setLogName(String logName) {
      this.logName = logName;
      return this;
    }


    /**
     * Sets the monitored resource associated with this log entry. Example: a log entry that reports
     * a database error would be associated with the monitored resource designating the particular
     * database that reported the error.
     */
    public Builder setResource(MonitoredResource resource) {
      this.resource = resource;
      return this;
    }


    /**
     * Sets the time at which the event described by the log entry occurred, in milliseconds. If
     * omitted, the Logging service will use the time at which the log entry is received.
     */
    public Builder setTimestamp(long timestamp) {
      this.timestamp = timestamp;
      return this;
    }


    /**
     * Sets the time the log entry was received by Stackdriver Logging.
     */
    public Builder setReceiveTimestamp(long receiveTimestamp) {
      this.receiveTimestamp = receiveTimestamp;
      return this;
    }


    /**
     * Sets the severity of the log entry. If not set, {@link Severity#DEFAULT} is used.
     */
    public Builder setSeverity(Severity severity) {
      this.severity = severity;
      return this;
    }


    /**
     * Sets a unique ID for the log entry. If you provide this field, the Logging service considers
     * other log entries in the same log with the same ID as duplicates which can be removed. If
     * omitted, the Logging service will generate a unique ID for this log entry.
     */
    public Builder setInsertId(String insertId) {
      this.insertId = insertId;
      return this;
    }


    /**
     * Sets information about the HTTP request associated with this log entry, if applicable.
     */
    public Builder setHttpRequest(HttpRequest httpRequest) {
      this.httpRequest = httpRequest;
      return this;
    }


    /**
     * Sets an optional set of user-defined (key, value) data that provides additional information
     * about the log entry.
     */
    public Builder setLabels(Map<String, String> labels) {
      this.labels = new HashMap<>(checkNotNull(labels));
      return this;
    }


    /**
     * Adds a label to the log entry's labels. Labels are user-defined (key, value) data that
     * provides additional information about the log entry.
     */
    public Builder addLabel(String key, String value) {
      this.labels.put(key, value);
      return this;
    }


    /**
     * Clears all the labels of the log entry. Labels are user-defined (key, value) data that
     * provides additional information about the log entry.
     */
    public Builder clearLabels() {
      this.labels.clear();
      return this;
    }


    /**
     * Sets information about an operation associated with the log entry, if applicable.
     */
    public Builder setOperation(Operation operation) {
      this.operation = operation;
      return this;
    }

    /**
     * Sets the resource name of the trace associated with the log entry, if any. If it contains a
     * relative resource name, the name is assumed to be relative to `//tracing.googleapis.com`.
     */
    public Builder setTrace(String trace) {
      this.trace = trace;
      return this;
    }

    /**
     * Sets the resource name of the trace associated with the log entry, if any. If it contains a
     * relative resource name, the name is assumed to be relative to `//tracing.googleapis.com`.
     */
    public Builder setTrace(Object trace) {
      this.trace = trace;
      return this;
    }

    /**
     * Sets the ID of the trace span associated with the log entry, if any.
     */
    public Builder setSpanId(String spanId) {
      this.spanId = spanId;
      return this;
    }

    /**
     * Sets the ID of the trace span associated with the log entry, if any.
     */
    public Builder setSpanId(Object spanId) {
      this.spanId = spanId;
      return this;
    }


    /**
     * Sets the sampling decision of the trace span associated with the log entry.
     */
    public Builder setTraceSampled(boolean traceSampled) {
      this.traceSampled = traceSampled;
      return this;
    }


    /**
     * Sets the source code location information associated with the log entry if any.
     */
    public Builder setSourceLocation(SourceLocation sourceLocation) {
      this.sourceLocation = sourceLocation;
      return this;
    }


    /**
     * Sets the payload for this log entry. The log entry payload can be provided as an UTF-8 string
     * (see {@link Payload.StringPayload}), a JSON object (see {@link Payload.JsonPayload}, or
     * a protobuf object (see {@link Payload.ProtoPayload}).
     *
     * @see <a href="https://cloud.google.com/logging/docs/view/logs_index">Log Entries and Logs</a>
     */
    public Builder setPayload(Payload payload) {
      this.payload = payload;
      return this;
    }

    /**
     * Creates a {@code LogEntry} object for this builder.
     */
    public LogEntry build() {
      return new LogEntry(this);
    }
  }

  LogEntry(Builder builder) {
    this.logName = builder.logName;
    this.resource = builder.resource;
    this.timestamp = builder.timestamp;
    this.receiveTimestamp = builder.receiveTimestamp;
    this.severity = builder.severity;
    this.insertId = builder.insertId;
    this.httpRequest = builder.httpRequest;
    this.labels = ImmutableMap.copyOf(builder.labels);
    this.operation = builder.operation;
    this.trace = builder.trace;
    this.spanId = builder.spanId;
    this.traceSampled = builder.traceSampled;
    this.sourceLocation = builder.sourceLocation;
    this.payload = builder.payload;
  }


  /**
   * Returns the name of the log to which this log entry belongs. The log name must be less than 512
   * characters long and can only include the following characters: upper and lower case
   * alphanumeric characters: {@code [A-Za-z0-9]}; and punctuation characters: {@code _-./}. The
   * forward-slash ({@code /}) characters in the log name must be URL-encoded. Examples:
   * {@code syslog}, {@code library.googleapis.com%2Fbook_log}.
   */
  public String getLogName() {
    return logName;
  }


  /**
   * Returns the monitored resource associated with this log entry. Example: a log entry that
   * reports a database error would be associated with the monitored resource designating the
   * particular database that reported the error.
   */
  public MonitoredResource getResource() {
    return resource;
  }


  /**
   * Returns the time at which the event described by the log entry occurred, in milliseconds. If
   * omitted, the Logging service will use the time at which the log entry is received.
   */
  public Long getTimestamp() {
    return timestamp;
  }


  /**
   * Returns the time the log entry was received by Stackdriver Logging.
   */
  public Long getReceiveTimestamp() {
    return receiveTimestamp;
  }


  /**
   * Returns the severity of the log entry. If not set, {@link Severity#DEFAULT} is used.
   */
  public Severity getSeverity() {
    return severity;
  }


  /**
   * Returns a unique ID for the log entry. The Logging service considers other log entries in the
   * same log with the same ID as duplicates which can be removed.
   */
  public String getInsertId() {
    return insertId;
  }


  /**
   * Returns information about the HTTP request associated with this log entry, if applicable.
   */
  public HttpRequest getHttpRequest() {
    return httpRequest;
  }


  /**
   * Returns an optional set of user-defined (key, value) data that provides additional information
   * about the log entry.
   */
  public Map<String, String> getLabels() {
    return labels;
  }


  /**
   * Returns information about an operation associated with the log entry, if applicable.
   */
  public Operation getOperation() {
    return operation;
  }


  /**
   * Returns the resource name of the trace associated with the log entry, if any. If it contains a
   * relative resource name, the name is assumed to be relative to `//tracing.googleapis.com`.
   */
  public String getTrace() {
    // For backwards compatibility return null when trace not set instead of "null".
    return trace == null ? null : String.valueOf(trace);
  }


  /**
   * Returns the ID of the trace span associated with the log entry, if any.
   */
  public String getSpanId() {
    // For backwards compatibility return null when spanId not set instead of "null".
    return spanId == null ? null : String.valueOf(spanId);
  }


  /**
   * Returns the sampling decision of the trace span associated with the log entry, or
   * {@code false} if there is no trace span.
   */
  public boolean getTraceSampled() {
    return traceSampled;
  }


  /**
   * Returns the source code location information associated with the log entry, if any.
   */
  public SourceLocation getSourceLocation() {
    return sourceLocation;
  }


  /**
   * Returns the payload for this log entry. The log entry payload can be an UTF-8 string (see
   * {@link Payload.StringPayload}), a JSON object (see {@link Payload.JsonPayload}, or a protobuf
   * object (see {@link Payload.ProtoPayload}).
   *
   * @see <a href="https://cloud.google.com/logging/docs/view/logs_index">Log Entries and Logs</a>
   */
  @SuppressWarnings("unchecked")
  public <T extends Payload> T getPayload() {
    return (T) payload;
  }

  @Override
  public int hashCode() {
    return Objects.hash(logName, resource, timestamp, receiveTimestamp, severity, insertId,
        httpRequest, labels, operation, getTrace(), getSpanId(), traceSampled, sourceLocation, payload);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof LogEntry)) {
      return false;
    }
    LogEntry other = (LogEntry) obj;
    return Objects.equals(logName, other.logName)
        && Objects.equals(resource, other.resource)
        && Objects.equals(timestamp, other.timestamp)
        && Objects.equals(receiveTimestamp, other.receiveTimestamp)
        && Objects.equals(severity, other.severity)
        && Objects.equals(insertId, other.insertId)
        && Objects.equals(httpRequest, other.httpRequest)
        && Objects.equals(labels, other.labels)
        && Objects.equals(operation, other.operation)
        && Objects.equals(getTrace(), other.getTrace())
        && Objects.equals(getSpanId(), other.getSpanId())
        && Objects.equals(traceSampled, other.traceSampled)
        && Objects.equals(sourceLocation, other.sourceLocation)
        && Objects.equals(payload, other.payload);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("logName", logName)
        .add("resource", resource)
        .add("timestamp", timestamp)
        .add("receiveTimestamp", receiveTimestamp)
        .add("severity", severity)
        .add("insertId", insertId)
        .add("httpRequest", httpRequest)
        .add("labels", labels)
        .add("operation", operation)
        .add("trace", trace)
        .add("spanId", spanId)
        .add("traceSampled", traceSampled)
        .add("sourceLocation", sourceLocation)
        .add("payload", payload)
        .toString();
  }

  /**
   * Returns a {@code Builder} for this log entry.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  private static Timestamp timestampFromMillis(Long millis) {
    Timestamp.Builder tsBuilder = Timestamp.newBuilder();
    tsBuilder.setSeconds(millis / MILLIS_PER_SECOND);
    tsBuilder.setNanos((int) (millis % MILLIS_PER_SECOND * NANOS_PER_MILLISECOND));
    return tsBuilder.build();
  }

  private static Long millisFromTimestamp(Timestamp timestamp) {
    return timestamp.getSeconds() * MILLIS_PER_SECOND
        + timestamp.getNanos() / NANOS_PER_MILLISECOND;
  }

  com.google.logging.v2.LogEntry toPb(String projectId) {
    com.google.logging.v2.LogEntry.Builder builder = payload.toPb();
    builder.putAllLabels(labels);
    if (logName != null) {
      builder.setLogName(ProjectLogName.of(projectId, logName).toString());
    }
    if (resource != null) {
      builder.setResource(resource.toPb());
    }
    if (timestamp != null) {
      builder.setTimestamp(timestampFromMillis(timestamp));
    }
    if (receiveTimestamp != null) {
      builder.setReceiveTimestamp(timestampFromMillis(receiveTimestamp));
    }
    if (severity != null) {
      builder.setSeverity(severity.toPb());
    }
    if (insertId != null) {
      builder.setInsertId(insertId);
    }
    if (httpRequest != null) {
      builder.setHttpRequest(httpRequest.toPb());
    }
    if (operation != null) {
      builder.setOperation(operation.toPb());
    }
    if (trace != null) {
      builder.setTrace(getTrace());
    }
    if (spanId != null) {
      builder.setSpanId(getSpanId());
    }
    builder.setTraceSampled(traceSampled);
    if (sourceLocation != null) {
      builder.setSourceLocation(sourceLocation.toPb());
    }
    return builder.build();
  }


  /**
   * Returns a builder for {@code LogEntry} objects given the entry payload.
   */
  public static Builder newBuilder(Payload<?> payload) {
    return new Builder(payload);
  }

  /**
   * Creates a {@code LogEntry} object given the entry payload.
   */
  public static LogEntry of(Payload<?> payload) {
    return newBuilder(payload).build();
  }

  /**
   * Creates a {@code LogEntry} object given the log name, the monitored resource and the entry
   * payload.
   */
  public static LogEntry of(String logName, MonitoredResource resource, Payload<?> payload) {
    return newBuilder(payload).setLogName(logName).setResource(resource).build();
  }

  static LogEntry fromPb(com.google.logging.v2.LogEntry entryPb) {
    Builder builder = newBuilder(Payload.fromPb(entryPb));
    builder.setLabels(entryPb.getLabelsMap());
    builder.setSeverity(Severity.fromPb(entryPb.getSeverity()));
    if (!entryPb.getLogName().equals("")) {
      builder.setLogName(ProjectLogName.parse(entryPb.getLogName()).getLog());
    }
    if (!entryPb.getResource().equals(com.google.api.MonitoredResource.getDefaultInstance())) {
      builder.setResource(MonitoredResource.fromPb(entryPb.getResource()));
    }
    if (entryPb.hasTimestamp()) {
      Long millis = millisFromTimestamp(entryPb.getTimestamp());
      if (millis != 0) {
        builder.setTimestamp(millis);
      }
    }
    if (entryPb.hasReceiveTimestamp()) {
      Long millis = millisFromTimestamp(entryPb.getReceiveTimestamp());
      if (millis != 0) {
        builder.setReceiveTimestamp(millis);
      }
    }
    if (!entryPb.getInsertId().equals("")) {
      builder.setInsertId(entryPb.getInsertId());
    }
    if (!entryPb.getHttpRequest().equals(
        com.google.logging.type.HttpRequest.getDefaultInstance())) {
      builder.setHttpRequest(HttpRequest.fromPb(entryPb.getHttpRequest()));
    }
    if (!entryPb.getOperation().equals(LogEntryOperation.getDefaultInstance())) {
      builder.setOperation(Operation.fromPb(entryPb.getOperation()));
    }
    if (!entryPb.getTrace().equals("")) {
      builder.setTrace(entryPb.getTrace());
    }
    if (!entryPb.getSpanId().equals("")) {
      builder.setSpanId(entryPb.getSpanId());
    }
    builder.setTraceSampled(entryPb.getTraceSampled());
    if (!entryPb.getSourceLocation().equals(LogEntrySourceLocation.getDefaultInstance())) {
      builder.setSourceLocation(SourceLocation.fromPb(entryPb.getSourceLocation()));
    }
    return builder.build();
  }

  static Function<LogEntry, com.google.logging.v2.LogEntry> toPbFunction(final String projectId) {
    return new Function<LogEntry, com.google.logging.v2.LogEntry>() {
      @Override
      public com.google.logging.v2.LogEntry apply(LogEntry entry) {
        return entry.toPb(projectId);
      }
    };
  }
}
