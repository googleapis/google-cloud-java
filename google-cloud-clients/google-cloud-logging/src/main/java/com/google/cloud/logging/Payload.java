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

import com.google.common.base.MoreObjects;
import com.google.protobuf.Any;
import com.google.protobuf.Struct;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 * A base class for log entry payloads.
 *
 * @see <a href="https://cloud.google.com/logging/docs/view/logs_index">Log Entries and Logs</a>
 */
public abstract class Payload<T> implements Serializable {

  private static final long serialVersionUID = -3802834715329130521L;

  private final Type type;
  private final T data;

  /** Type for a log entry payload. */
  public enum Type {
    /** Log entry data as UTF8 string. */
    STRING,

    /** Log entry data as JSON. */
    JSON,

    /** Log entry data as a protobuf object. */
    PROTO
  }

  /** A log entry payload as an UTF-8 string. */
  public static final class StringPayload extends Payload<String> {

    private static final long serialVersionUID = 646595882175676029L;

    StringPayload(String data) {
      super(Type.STRING, data);
    }

    @Override
    com.google.logging.v2.LogEntry.Builder toPb() {
      return com.google.logging.v2.LogEntry.newBuilder().setTextPayload(getData());
    }

    /** Creates a log entry payload given its data represented as an UTF-8 string. */
    public static StringPayload of(String data) {
      return new StringPayload(data);
    }

    static StringPayload fromPb(com.google.logging.v2.LogEntry entryPb) {
      return StringPayload.of(entryPb.getTextPayload());
    }
  }

  /** A log entry's JSON payload. */
  public static final class JsonPayload extends Payload<Struct> {

    private static final long serialVersionUID = 5747721918608143350L;

    JsonPayload(Struct jsonData) {
      super(Type.JSON, jsonData);
    }

    /** Returns the log entry's JSON data as an unmodifiable map. */
    public Map<String, Object> getDataAsMap() {
      return Structs.asMap(getData());
    }

    @Override
    com.google.logging.v2.LogEntry.Builder toPb() {
      return com.google.logging.v2.LogEntry.newBuilder().setJsonPayload(getData());
    }

    /**
     * Creates a log entry payload given its JSON data represented as a map. The provided map is
     * copied into a {@link Struct} object.
     *
     * <p>Notice that all numbers (int, long, float and double) are serialized as double values.
     * Enums are serialized as strings.
     *
     * <p>Example usage of {@code JsonPayload}:
     *
     * <pre>{@code
     * List<Long> listValue = Arrays.asList(1L, 2L);
     * Map<String, Object> innerMap = new HashMap<String, Object>();
     * innerMap.put("booleanValue", true);
     * innerMap.put("stringValue", "stringValue");
     * Map<String, Object> jsonContent = new HashMap<String, Object>();
     * jsonContent.put("listValue", listValue);
     * jsonContent.put("integerValue", 42);
     * jsonContent.put("doubleValue", 42.0);
     * jsonContent.put("stringValue", "stringValue");
     * jsonContent.put("mapValue", innerMap);
     * JsonPayload payload = JsonPayload.of(jsonContent);
     * }</pre>
     */
    public static JsonPayload of(Map<String, ?> data) {
      return new JsonPayload(Structs.newStruct(data));
    }

    /** Creates a log entry payload given its JSON data represented as a protobuf struct. */
    public static JsonPayload of(Struct data) {
      return new JsonPayload(data);
    }

    static JsonPayload fromPb(com.google.logging.v2.LogEntry entryPb) {
      return JsonPayload.of(entryPb.getJsonPayload());
    }
  }

  /** A log entry payload as a protobuf object. */
  public static final class ProtoPayload extends Payload<Any> {

    private static final long serialVersionUID = 155951112369716872L;

    ProtoPayload(Any data) {
      super(Type.PROTO, data);
    }

    @Override
    com.google.logging.v2.LogEntry.Builder toPb() {
      return com.google.logging.v2.LogEntry.newBuilder().setProtoPayload(getData());
    }

    /** Creates a log entry payload given its data as a protobuf object. */
    public static ProtoPayload of(Any data) {
      return new ProtoPayload(data);
    }

    static ProtoPayload fromPb(com.google.logging.v2.LogEntry entryPb) {
      return ProtoPayload.of(entryPb.getProtoPayload());
    }
  }

  private Payload(Type type, T data) {
    this.type = checkNotNull(type);
    this.data = checkNotNull(data);
  }

  /**
   * Returns the payload type. Payload can be an UTF-8 string ({@link Type#STRING}), a JSON object
   * ({@link Type#JSON}) or a protobuf object ({@link Type#PROTO}).
   */
  public Type getType() {
    return type;
  }

  /** Returns the log entry payload's data. */
  public T getData() {
    return data;
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !(obj instanceof Payload)) {
      return false;
    }
    Payload<?> other = (Payload<?>) obj;
    return Objects.equals(type, other.type) && Objects.equals(data, other.data);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(type, data);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("type", type).add("data", data).toString();
  }

  abstract com.google.logging.v2.LogEntry.Builder toPb();

  @SuppressWarnings("unchecked")
  static <T extends Payload<?>> T fromPb(com.google.logging.v2.LogEntry entryPb) {
    switch (entryPb.getPayloadCase()) {
      case TEXT_PAYLOAD:
        return (T) StringPayload.fromPb(entryPb);
      case JSON_PAYLOAD:
        return (T) JsonPayload.fromPb(entryPb);
      case PROTO_PAYLOAD:
        return (T) ProtoPayload.fromPb(entryPb);
      case PAYLOAD_NOT_SET:
        return null;
      default:
        // should never occur
        throw new IllegalArgumentException("Unrecognized log entry payload");
    }
  }
}
