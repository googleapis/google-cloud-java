/*
 * Copyright 2020 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.httpjson;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.TypeRegistry;
import com.google.protobuf.util.JsonFormat;
import com.google.protobuf.util.JsonFormat.Printer;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class serializes/deserializes protobuf {@link Message} for REST interactions. It serializes
 * requests protobuf messages into REST messages, splitting the message into the JSON request body,
 * URL path parameters, and query parameters. It deserializes JSON responses into response protobuf
 * message.
 */
public class ProtoRestSerializer<RequestT extends Message> {

  private final TypeRegistry registry;

  private ProtoRestSerializer(TypeRegistry registry) {
    this.registry = registry;
  }

  /** Creates a new instance of ProtoRestSerializer. */
  public static <RequestT extends Message> ProtoRestSerializer<RequestT> create() {
    return create(TypeRegistry.getEmptyTypeRegistry());
  }

  /** Creates a new instance of ProtoRestSerializer. */
  static <RequestT extends Message> ProtoRestSerializer<RequestT> create(TypeRegistry registry) {
    return new ProtoRestSerializer<>(registry);
  }

  /**
   * Serializes the data from {@code message} to a JSON string. The implementation relies on
   * protobuf native JSON formatter.
   *
   * @param message a message to serialize
   * @param numericEnum a boolean flag that determine if enum values should be serialized to number
   *     or not
   * @throws InvalidProtocolBufferException if failed to serialize the protobuf message to JSON
   *     format
   */
  String toJson(Message message, boolean numericEnum) {
    try {
      Printer printer = JsonFormat.printer().usingTypeRegistry(registry);
      if (numericEnum) {
        return printer.printingEnumsAsInts().print(message);
      } else {
        return printer.print(message);
      }
    } catch (InvalidProtocolBufferException e) {
      throw new RestSerializationException("Failed to serialize message to JSON", e);
    }
  }

  /**
   * Deserializes a {@code message} from an input stream to a protobuf message.
   *
   * @param json the input reader with a JSON-encoded message in it
   * @param builder an empty builder for the specific {@code RequestT} message to serialize
   * @throws RestSerializationException if failed to deserialize a protobuf message from the JSON
   *     stream
   */
  @SuppressWarnings("unchecked")
  RequestT fromJson(Reader json, Message.Builder builder) {
    try {
      JsonFormat.parser().usingTypeRegistry(registry).ignoringUnknownFields().merge(json, builder);
      return (RequestT) builder.build();
    } catch (IOException e) {
      throw new RestSerializationException("Failed to parse response message", e);
    }
  }

  /**
   * Puts a message field in {@code fields} map which will be used to populate URL path of a
   * request.
   *
   * @param fields a map with serialized fields
   * @param fieldName a field name
   * @param fieldValue a field value
   */
  public void putPathParam(Map<String, String> fields, String fieldName, Object fieldValue) {
    fields.put(fieldName, String.valueOf(fieldValue));
  }

  private void putDecomposedMessageQueryParam(
      Map<String, List<String>> fields, String fieldName, JsonElement parsed) {
    if (parsed.isJsonPrimitive() || parsed.isJsonNull()) {
      putQueryParam(fields, fieldName, parsed.getAsString());
    } else if (parsed.isJsonArray()) {
      for (JsonElement element : parsed.getAsJsonArray()) {
        putDecomposedMessageQueryParam(fields, fieldName, element);
      }
    } else {
      // it is a json object
      for (String key : parsed.getAsJsonObject().keySet()) {
        putDecomposedMessageQueryParam(
            fields, String.format("%s.%s", fieldName, key), parsed.getAsJsonObject().get(key));
      }
    }
  }

  /**
   * Puts a message field in {@code fields} map which will be used to populate query parameters of a
   * request.
   *
   * @param fields a map with serialized fields
   * @param fieldName a field name
   * @param fieldValue a field value
   */
  public void putQueryParam(Map<String, List<String>> fields, String fieldName, Object fieldValue) {
    List<String> currentParamValueList = new ArrayList<>();
    List<Object> toProcess =
        fieldValue instanceof List<?> ? (List<Object>) fieldValue : ImmutableList.of(fieldValue);
    for (Object fieldValueItem : toProcess) {
      if (fieldValueItem instanceof Message) {
        String json = toJson(((Message) fieldValueItem), true);
        JsonElement parsed = JsonParser.parseString(json);
        putDecomposedMessageQueryParam(fields, fieldName, parsed);
      } else {
        currentParamValueList.add(String.valueOf(fieldValueItem));
      }
    }
    if (currentParamValueList.isEmpty()) {
      // We try to avoid putting non-leaf level fields to the query params
      return;
    }
    List<String> accumulativeParamValueList = fields.getOrDefault(fieldName, new ArrayList<>());
    accumulativeParamValueList.addAll(currentParamValueList);
    fields.put(fieldName, accumulativeParamValueList);
  }

  /**
   * Serializes a message to a request body in a form of JSON-encoded string.
   *
   * @param fieldName a name of a request message field this message belongs to
   * @param fieldValue a field value to serialize
   */
  public String toBody(String fieldName, RequestT fieldValue) {
    return toJson(fieldValue, false);
  }

  /**
   * Serializes a message to a request body in a form of JSON-encoded string.
   *
   * @param fieldName a name of a request message field this message belongs to
   * @param fieldValue a field value to serialize
   * @param numericEnum a boolean flag that determine if enum values should be serialized to number
   */
  public String toBody(String fieldName, RequestT fieldValue, boolean numericEnum) {
    return toJson(fieldValue, numericEnum);
  }
}
