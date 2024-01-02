/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery.storage.v1beta2;

import com.google.api.pathtemplate.ValidationException;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.Message;
import com.google.protobuf.UninitializedMessageException;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;

/**
 * Converts Json data to protocol buffer messages given the protocol buffer descriptor. The protobuf
 * descriptor must have all fields lowercased.
 *
 * <p>This client lib is deprecated, please use v1 instead.
 */
@Deprecated
public class JsonToProtoMessage {
  private static final Logger LOG = Logger.getLogger(JsonToProtoMessage.class.getName());
  private static ImmutableMap<FieldDescriptor.Type, String> FieldTypeToDebugMessage =
      new ImmutableMap.Builder<FieldDescriptor.Type, String>()
          .put(FieldDescriptor.Type.BOOL, "boolean")
          .put(FieldDescriptor.Type.BYTES, "bytes")
          .put(FieldDescriptor.Type.INT32, "int32")
          .put(FieldDescriptor.Type.DOUBLE, "double")
          .put(FieldDescriptor.Type.INT64, "int64")
          .put(FieldDescriptor.Type.STRING, "string")
          .put(FieldDescriptor.Type.MESSAGE, "object")
          .build();

  /**
   * Converts Json data to protocol buffer messages given the protocol buffer descriptor.
   *
   * @param protoSchema
   * @param json
   * @throws IllegalArgumentException when JSON data is not compatible with proto descriptor.
   */
  public static DynamicMessage convertJsonToProtoMessage(Descriptor protoSchema, JSONObject json)
      throws IllegalArgumentException {
    Preconditions.checkNotNull(json, "JSONObject is null.");
    Preconditions.checkNotNull(protoSchema, "Protobuf descriptor is null.");
    Preconditions.checkState(json.length() != 0, "JSONObject is empty.");

    return convertJsonToProtoMessageImpl(protoSchema, null, json, "root", /*topLevel=*/ true);
  }

  /**
   * Converts Json data to protocol buffer messages given the protocol buffer descriptor.
   *
   * @param protoSchema
   * @param tableSchema bigquery table schema is needed for type conversion of DATETIME, TIME,
   *     NUMERIC, BIGNUMERIC
   * @param json
   * @throws IllegalArgumentException when JSON data is not compatible with proto descriptor.
   */
  public static DynamicMessage convertJsonToProtoMessage(
      Descriptor protoSchema, TableSchema tableSchema, JSONObject json)
      throws IllegalArgumentException {
    Preconditions.checkNotNull(json, "JSONObject is null.");
    Preconditions.checkNotNull(protoSchema, "Protobuf descriptor is null.");
    Preconditions.checkNotNull(tableSchema, "TableSchema is null.");
    Preconditions.checkState(json.length() != 0, "JSONObject is empty.");

    return convertJsonToProtoMessageImpl(
        protoSchema, tableSchema.getFieldsList(), json, "root", /*topLevel=*/ true);
  }

  /**
   * Converts Json data to protocol buffer messages given the protocol buffer descriptor.
   *
   * @param protoSchema
   * @param json
   * @param jsonScope Debugging purposes
   * @param topLevel checks if root level has any matching fields.
   * @throws IllegalArgumentException when JSON data is not compatible with proto descriptor.
   */
  private static DynamicMessage convertJsonToProtoMessageImpl(
      Descriptor protoSchema,
      List<TableFieldSchema> tableSchema,
      JSONObject json,
      String jsonScope,
      boolean topLevel)
      throws IllegalArgumentException {
    DynamicMessage.Builder protoMsg = DynamicMessage.newBuilder(protoSchema);
    String[] jsonNames = JSONObject.getNames(json);
    if (jsonNames == null) {
      return protoMsg.build();
    }
    for (int i = 0; i < jsonNames.length; i++) {
      String jsonName = jsonNames[i];
      // We want lowercase here to support case-insensitive data writes.
      // The protobuf descriptor that is used is assumed to have all lowercased fields
      String jsonLowercaseName = jsonName.toLowerCase();
      String currentScope = jsonScope + "." + jsonName;
      FieldDescriptor field = protoSchema.findFieldByName(jsonLowercaseName);
      if (field == null) {
        throw new IllegalArgumentException(
            String.format("JSONObject has fields unknown to BigQuery: %s.", currentScope));
      }
      TableFieldSchema fieldSchema = null;
      if (tableSchema != null) {
        // protoSchema is generated from tableSchema so their field ordering should match.
        fieldSchema = tableSchema.get(field.getIndex());
        if (!fieldSchema.getName().toLowerCase().equals(field.getName())) {
          throw new ValidationException(
              "Field at index "
                  + field.getIndex()
                  + " has mismatch names ("
                  + fieldSchema.getName()
                  + ") ("
                  + field.getName()
                  + ")");
        }
      }
      if (!field.isRepeated()) {
        fillField(protoMsg, field, fieldSchema, json, jsonName, currentScope);
      } else {
        fillRepeatedField(protoMsg, field, fieldSchema, json, jsonName, currentScope);
      }
    }

    DynamicMessage msg;
    try {
      msg = protoMsg.build();
    } catch (UninitializedMessageException e) {
      String errorMsg = e.getMessage();
      int idxOfColon = errorMsg.indexOf(":");
      String missingFieldName = errorMsg.substring(idxOfColon + 2);
      throw new IllegalArgumentException(
          String.format(
              "JSONObject does not have the required field %s.%s.", jsonScope, missingFieldName));
    }
    if (topLevel && msg.getSerializedSize() == 0) {
      throw new IllegalArgumentException("The created protobuf message is empty.");
    }
    return msg;
  }

  /**
   * Fills a non-repetaed protoField with the json data.
   *
   * @param protoMsg The protocol buffer message being constructed
   * @param fieldDescriptor
   * @param json
   * @param exactJsonKeyName Exact key name in JSONObject instead of lowercased version
   * @param currentScope Debugging purposes
   * @throws IllegalArgumentException when JSON data is not compatible with proto descriptor.
   */
  private static void fillField(
      DynamicMessage.Builder protoMsg,
      FieldDescriptor fieldDescriptor,
      TableFieldSchema fieldSchema,
      JSONObject json,
      String exactJsonKeyName,
      String currentScope)
      throws IllegalArgumentException {

    java.lang.Object val = json.get(exactJsonKeyName);
    if (val == JSONObject.NULL) {
      return;
    }
    switch (fieldDescriptor.getType()) {
      case BOOL:
        if (val instanceof Boolean) {
          protoMsg.setField(fieldDescriptor, (Boolean) val);
          return;
        }
        break;
      case BYTES:
        if (fieldSchema != null) {
          if (fieldSchema.getType() == TableFieldSchema.Type.NUMERIC) {
            if (val instanceof String) {
              protoMsg.setField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToNumericByteString(
                      new BigDecimal((String) val)));
              return;
            } else if (val instanceof Long || val instanceof Integer) {
              protoMsg.setField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToNumericByteString(
                      new BigDecimal(((Number) val).longValue())));
              return;
            } else if (val instanceof Float || val instanceof Double) {
              protoMsg.setField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToNumericByteString(
                      new BigDecimal(((Number) val).doubleValue())));
              return;
            }
          } else if (fieldSchema.getType() == TableFieldSchema.Type.BIGNUMERIC) {
            if (val instanceof String) {
              protoMsg.setField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToNumericByteString(
                      new BigDecimal((String) val)));
              return;
            } else if (val instanceof Long || val instanceof Integer) {
              protoMsg.setField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToNumericByteString(
                      new BigDecimal(((Number) val).longValue())));
              return;
            } else if (val instanceof Float || val instanceof Double) {
              protoMsg.setField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToNumericByteString(
                      new BigDecimal(((Number) val).doubleValue())));
              return;
            }
          }
        }
        if (val instanceof ByteString) {
          protoMsg.setField(fieldDescriptor, ((ByteString) val).toByteArray());
          return;
        } else if (val instanceof JSONArray) {
          try {
            byte[] bytes = new byte[((JSONArray) val).length()];
            for (int j = 0; j < ((JSONArray) val).length(); j++) {
              bytes[j] = (byte) ((JSONArray) val).getInt(j);
              if (bytes[j] != ((JSONArray) val).getInt(j)) {
                throw new IllegalArgumentException(
                    String.format(
                        "Error: "
                            + currentScope
                            + "["
                            + j
                            + "] could not be converted to byte[]."));
              }
            }
            protoMsg.setField(fieldDescriptor, bytes);
            return;
          } catch (JSONException e) {
            throw new IllegalArgumentException(
                String.format("Error: " + currentScope + "could not be converted to byte[]."));
          }
        }
        break;
      case INT64:
        if (fieldSchema != null) {
          if (fieldSchema.getType() == TableFieldSchema.Type.DATETIME) {
            if (val instanceof String) {
              protoMsg.setField(
                  fieldDescriptor,
                  CivilTimeEncoder.encodePacked64DatetimeMicros(LocalDateTime.parse((String) val)));
              return;
            } else if (val instanceof Long) {
              protoMsg.setField(fieldDescriptor, (Long) val);
              return;
            }
          } else if (fieldSchema.getType() == TableFieldSchema.Type.TIME) {
            if (val instanceof String) {
              protoMsg.setField(
                  fieldDescriptor,
                  CivilTimeEncoder.encodePacked64TimeMicros(LocalTime.parse((String) val)));
              return;
            } else if (val instanceof Long) {
              protoMsg.setField(fieldDescriptor, (Long) val);
              return;
            }
          }
        }
        if (val instanceof Integer) {
          protoMsg.setField(fieldDescriptor, new Long((Integer) val));
          return;
        } else if (val instanceof Long) {
          protoMsg.setField(fieldDescriptor, (Long) val);
          return;
        }
        break;
      case INT32:
        if (val instanceof Integer) {
          protoMsg.setField(fieldDescriptor, (Integer) val);
          return;
        }
        break;
      case STRING:
        if (val instanceof String) {
          protoMsg.setField(fieldDescriptor, (String) val);
          return;
        }
        break;
      case DOUBLE:
        if (val instanceof Double) {
          protoMsg.setField(fieldDescriptor, (Double) val);
          return;
        } else if (val instanceof Float) {
          protoMsg.setField(fieldDescriptor, new Double((Float) val));
          return;
        }
        break;
      case MESSAGE:
        if (val instanceof JSONObject) {
          Message.Builder message = protoMsg.newBuilderForField(fieldDescriptor);
          protoMsg.setField(
              fieldDescriptor,
              convertJsonToProtoMessageImpl(
                  fieldDescriptor.getMessageType(),
                  fieldSchema == null ? null : fieldSchema.getFieldsList(),
                  json.getJSONObject(exactJsonKeyName),
                  currentScope,
                  /*topLevel =*/ false));
          return;
        }
        break;
    }
    throw new IllegalArgumentException(
        String.format(
            "JSONObject does not have a %s field at %s.",
            FieldTypeToDebugMessage.get(fieldDescriptor.getType()), currentScope));
  }

  /**
   * Fills a repeated protoField with the json data.
   *
   * @param protoMsg The protocol buffer message being constructed
   * @param fieldDescriptor
   * @param json If root level has no matching fields, throws exception.
   * @param exactJsonKeyName Exact key name in JSONObject instead of lowercased version
   * @param currentScope Debugging purposes
   * @throws IllegalArgumentException when JSON data is not compatible with proto descriptor.
   */
  private static void fillRepeatedField(
      DynamicMessage.Builder protoMsg,
      FieldDescriptor fieldDescriptor,
      TableFieldSchema fieldSchema,
      JSONObject json,
      String exactJsonKeyName,
      String currentScope)
      throws IllegalArgumentException {

    JSONArray jsonArray;
    try {
      jsonArray = json.getJSONArray(exactJsonKeyName);
    } catch (JSONException e) {
      throw new IllegalArgumentException(
          "JSONObject does not have a array field at " + currentScope + ".");
    }
    java.lang.Object val;
    int index;
    boolean fail = false;
    for (int i = 0; i < jsonArray.length(); i++) {
      val = jsonArray.get(i);
      index = i;
      switch (fieldDescriptor.getType()) {
        case BOOL:
          if (val instanceof Boolean) {
            protoMsg.addRepeatedField(fieldDescriptor, (Boolean) val);
          } else {
            fail = true;
          }
          break;
        case BYTES:
          Boolean added = false;
          if (fieldSchema != null && fieldSchema.getType() == TableFieldSchema.Type.NUMERIC) {
            if (val instanceof String) {
              protoMsg.addRepeatedField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToNumericByteString(
                      new BigDecimal((String) val)));
              added = true;
            } else if (val instanceof Long || val instanceof Integer) {
              protoMsg.addRepeatedField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToNumericByteString(
                      new BigDecimal(((Number) val).longValue())));
              added = true;
            } else if (val instanceof Float || val instanceof Double) {
              protoMsg.addRepeatedField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToNumericByteString(
                      new BigDecimal(((Number) val).doubleValue())));
              added = true;
            }
          } else if (fieldSchema != null
              && fieldSchema.getType() == TableFieldSchema.Type.BIGNUMERIC) {
            if (val instanceof String) {
              protoMsg.addRepeatedField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToNumericByteString(
                      new BigDecimal((String) val)));
              added = true;
            } else if (val instanceof Long || val instanceof Integer) {
              protoMsg.addRepeatedField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToNumericByteString(
                      new BigDecimal(((Number) val).longValue())));
              added = true;
            } else if (val instanceof Float || val instanceof Double) {
              protoMsg.addRepeatedField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToNumericByteString(
                      new BigDecimal(((Number) val).doubleValue())));
              added = true;
            }
          }
          if (!added) {
            if (val instanceof JSONArray) {
              try {
                byte[] bytes = new byte[((JSONArray) val).length()];
                for (int j = 0; j < ((JSONArray) val).length(); j++) {
                  bytes[j] = (byte) ((JSONArray) val).getInt(j);
                  if (bytes[j] != ((JSONArray) val).getInt(j)) {
                    throw new IllegalArgumentException(
                        String.format(
                            "Error: "
                                + currentScope
                                + "["
                                + index
                                + "] could not be converted to byte[]."));
                  }
                }
                protoMsg.addRepeatedField(fieldDescriptor, bytes);
              } catch (JSONException e) {
                throw new IllegalArgumentException(
                    String.format(
                        "Error: "
                            + currentScope
                            + "["
                            + index
                            + "] could not be converted to byte[]."));
              }
            } else if (val instanceof ByteString) {
              protoMsg.addRepeatedField(fieldDescriptor, ((ByteString) val).toByteArray());
              return;
            } else {
              fail = true;
            }
          }
          break;
        case INT64:
          if (fieldSchema != null && fieldSchema.getType() == TableFieldSchema.Type.DATETIME) {
            if (val instanceof String) {
              protoMsg.addRepeatedField(
                  fieldDescriptor,
                  CivilTimeEncoder.encodePacked64DatetimeMicros(LocalDateTime.parse((String) val)));
            } else if (val instanceof Long) {
              protoMsg.addRepeatedField(fieldDescriptor, (Long) val);
            } else {
              fail = true;
            }
          } else if (fieldSchema != null && fieldSchema.getType() == TableFieldSchema.Type.TIME) {
            if (val instanceof String) {
              protoMsg.addRepeatedField(
                  fieldDescriptor,
                  CivilTimeEncoder.encodePacked64TimeMicros(LocalTime.parse((String) val)));
            } else if (val instanceof Long) {
              protoMsg.addRepeatedField(fieldDescriptor, (Long) val);
            } else {
              fail = true;
            }
          } else if (val instanceof Integer) {
            protoMsg.addRepeatedField(fieldDescriptor, new Long((Integer) val));
          } else if (val instanceof Long) {
            protoMsg.addRepeatedField(fieldDescriptor, (Long) val);
          } else {
            fail = true;
          }
          break;
        case INT32:
          if (val instanceof Integer) {
            protoMsg.addRepeatedField(fieldDescriptor, (Integer) val);
          } else {
            fail = true;
          }
          break;
        case STRING:
          if (val instanceof String) {
            protoMsg.addRepeatedField(fieldDescriptor, (String) val);
          } else {
            fail = true;
          }
          break;
        case DOUBLE:
          if (val instanceof Double) {
            protoMsg.addRepeatedField(fieldDescriptor, (Double) val);
          } else if (val instanceof Float) {
            protoMsg.addRepeatedField(fieldDescriptor, new Double((float) val));
          } else {
            fail = true;
          }
          break;
        case MESSAGE:
          if (val instanceof JSONObject) {
            Message.Builder message = protoMsg.newBuilderForField(fieldDescriptor);
            protoMsg.addRepeatedField(
                fieldDescriptor,
                convertJsonToProtoMessageImpl(
                    fieldDescriptor.getMessageType(),
                    fieldSchema == null ? null : fieldSchema.getFieldsList(),
                    jsonArray.getJSONObject(i),
                    currentScope,
                    /*topLevel =*/ false));
          } else {
            fail = true;
          }
          break;
      }
      if (fail) {
        throw new IllegalArgumentException(
            String.format(
                "JSONObject does not have a %s field at %s[%d].",
                FieldTypeToDebugMessage.get(fieldDescriptor.getType()), currentScope, index));
      }
    }
  }
}
