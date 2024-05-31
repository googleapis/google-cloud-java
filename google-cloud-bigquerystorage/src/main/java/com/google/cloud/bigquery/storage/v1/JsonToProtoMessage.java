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
package com.google.cloud.bigquery.storage.v1;

import com.google.api.pathtemplate.ValidationException;
import com.google.cloud.bigquery.storage.v1.Exceptions.RowIndexToErrorException;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.UninitializedMessageException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;

/**
 * Converts JSON data to Protobuf messages given the Protobuf descriptor and BigQuery table schema.
 * The Protobuf descriptor must have all fields lowercased.
 */
public class JsonToProtoMessage implements ToProtoConverter<Object> {
  public static final JsonToProtoMessage INSTANCE = new JsonToProtoMessage();
  private static final int NUMERIC_SCALE = 9;
  private static final ImmutableMap<FieldDescriptor.Type, String> FIELD_TYPE_TO_DEBUG_MESSAGE =
      new ImmutableMap.Builder<FieldDescriptor.Type, String>()
          .put(FieldDescriptor.Type.BOOL, "boolean")
          .put(FieldDescriptor.Type.BYTES, "bytes")
          .put(FieldDescriptor.Type.INT32, "int32")
          .put(FieldDescriptor.Type.DOUBLE, "double")
          .put(FieldDescriptor.Type.INT64, "int64")
          .put(FieldDescriptor.Type.STRING, "string")
          .put(FieldDescriptor.Type.MESSAGE, "object")
          .build();
  private static final DateTimeFormatter TIMESTAMP_FORMATTER =
      new DateTimeFormatterBuilder()
          .parseLenient()
          .append(DateTimeFormatter.ofPattern("yyyy[/][-]MM[/][-]dd"))
          .optionalStart()
          .appendLiteral('T')
          .optionalEnd()
          .optionalStart()
          .appendLiteral(' ')
          .optionalEnd()
          .appendValue(ChronoField.HOUR_OF_DAY, 2)
          .appendLiteral(':')
          .appendValue(ChronoField.MINUTE_OF_HOUR, 2)
          .optionalStart()
          .appendLiteral(':')
          .appendValue(ChronoField.SECOND_OF_MINUTE, 2)
          .optionalEnd()
          .optionalStart()
          .appendValue(ChronoField.MILLI_OF_SECOND, 3)
          .optionalEnd()
          .optionalStart()
          .appendFraction(ChronoField.MICRO_OF_SECOND, 3, 6, true)
          .optionalEnd()
          .optionalStart()
          .appendFraction(ChronoField.NANO_OF_SECOND, 6, 9, true)
          .optionalEnd()
          .optionalStart()
          .appendLiteral(' ')
          .optionalEnd()
          .optionalStart()
          .appendOffset("+HH:MM", "+00:00")
          .optionalEnd()
          .optionalStart()
          .appendZoneText(TextStyle.SHORT)
          .optionalEnd()
          .optionalStart()
          .appendLiteral('Z')
          .optionalEnd()
          .toFormatter()
          .withZone(ZoneOffset.UTC);

  private static final DateTimeFormatter DATETIME_FORMATTER =
      new DateTimeFormatterBuilder()
          .parseLenient()
          .append(DateTimeFormatter.ISO_LOCAL_DATE)
          .optionalStart()
          .optionalStart()
          .parseCaseInsensitive()
          .appendLiteral('T')
          .optionalEnd()
          .optionalStart()
          .appendLiteral(' ')
          .optionalEnd()
          .append(DateTimeFormatter.ISO_LOCAL_TIME)
          .optionalEnd()
          .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
          .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
          .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
          .toFormatter();

  /** You can use {@link #INSTANCE} instead */
  public JsonToProtoMessage() {}

  public static DynamicMessage convertJsonToProtoMessage(
      Descriptor protoSchema,
      TableSchema tableSchema,
      JSONObject json,
      boolean ignoreUnknownFields) {
    return INSTANCE.convertToProtoMessage(protoSchema, tableSchema, json, ignoreUnknownFields);
  }

  public static DynamicMessage convertJsonToProtoMessage(Descriptor protoSchema, JSONObject json) {
    return INSTANCE.convertToProtoMessage(protoSchema, json);
  }

  public static DynamicMessage convertJsonToProtoMessage(
      Descriptor protoSchema, TableSchema tableSchema, JSONObject json) {
    return INSTANCE.convertToProtoMessage(protoSchema, tableSchema, json);
  }

  /**
   * Converts input message to Protobuf.
   *
   * <p>WARNING: it's much more efficient to call the other APIs accepting json array if the jsons
   * share the same table schema.
   *
   * @param protoSchema the schema of the output Protobuf schems.
   * @param tableSchema tha underlying table schema for which Protobuf is being built.
   * @param json the input JSON object converted to Protobuf.
   * @param ignoreUnknownFields flag indicating that the additional fields not present in the output
   *     schema should be accepted.
   * @return Converted message in Protobuf format.
   */
  public DynamicMessage convertToProtoMessage(
      Descriptor protoSchema, TableSchema tableSchema, Object json, boolean ignoreUnknownFields) {
    return convertToProtoMessage(protoSchema, tableSchema, (JSONObject) json, ignoreUnknownFields);
  }

  /**
   * Converts Json array to list of Protobuf
   *
   * @param protoSchema the schema of the output Protobuf schems.
   * @param tableSchema tha underlying table schema for which Protobuf is being built.
   * @param jsonArray the input JSON array converted to Protobuf.
   * @param ignoreUnknownFields flag indicating that the additional fields not present in the output
   *     schema should be accepted.
   * @return Converted message in Protobuf format.
   */
  @Override
  public List<DynamicMessage> convertToProtoMessage(
      Descriptor protoSchema,
      TableSchema tableSchema,
      Iterable<Object> jsonArray,
      boolean ignoreUnknownFields) {
    return convertToProtoMessage(
        protoSchema, tableSchema, (JSONArray) jsonArray, ignoreUnknownFields);
  }

  /**
   * Converts Json data to protocol buffer messages given the protocol buffer descriptor.
   *
   * <p>WARNING: it's much more efficient to call the other APIs accepting json array if the jsons
   * share the same table schema.
   *
   * @param protoSchema
   * @param json
   * @throws IllegalArgumentException when JSON data is not compatible with proto descriptor.
   */
  public DynamicMessage convertToProtoMessage(Descriptor protoSchema, JSONObject json)
      throws IllegalArgumentException {
    Preconditions.checkNotNull(json, "JSONObject is null.");
    Preconditions.checkNotNull(protoSchema, "Protobuf descriptor is null.");
    Preconditions.checkState(json.length() != 0, "JSONObject is empty.");

    return convertToProtoMessage(protoSchema, null, json, "root", false);
  }

  /**
   * Converts Json data to protocol buffer messages given the protocol buffer descriptor.
   *
   * <p>WARNING: it's much more efficient to call the other APIs accepting json array if the jsons
   * share the same table schema.
   *
   * @param protoSchema
   * @param tableSchema bigquery table schema is needed for type conversion of DATETIME, TIME,
   *     NUMERIC, BIGNUMERIC
   * @param json
   * @throws IllegalArgumentException when JSON data is not compatible with proto descriptor.
   */
  public DynamicMessage convertToProtoMessage(
      Descriptor protoSchema, TableSchema tableSchema, JSONObject json)
      throws IllegalArgumentException {
    Preconditions.checkNotNull(json, "JSONObject is null.");
    Preconditions.checkNotNull(protoSchema, "Protobuf descriptor is null.");
    Preconditions.checkNotNull(tableSchema, "TableSchema is null.");
    Preconditions.checkState(json.length() != 0, "JSONObject is empty.");

    return convertToProtoMessage(protoSchema, tableSchema.getFieldsList(), json, "root", false);
  }

  /**
   * Converts Json data to protocol buffer messages given the protocol buffer descriptor.
   *
   * <p>WARNING: it's much more efficient to call the other APIs accepting json array if the jsons
   * share the same table schema.
   *
   * @param protoSchema
   * @param tableSchema bigquery table schema is needed for type conversion of DATETIME, TIME,
   *     NUMERIC, BIGNUMERIC
   * @param json
   * @param ignoreUnknownFields allows unknown fields in JSON input to be ignored.
   * @throws IllegalArgumentException when JSON data is not compatible with proto descriptor.
   */
  public DynamicMessage convertToProtoMessage(
      Descriptor protoSchema, TableSchema tableSchema, JSONObject json, boolean ignoreUnknownFields)
      throws IllegalArgumentException {
    Preconditions.checkNotNull(json, "JSONObject is null.");
    Preconditions.checkNotNull(protoSchema, "Protobuf descriptor is null.");
    Preconditions.checkNotNull(tableSchema, "TableSchema is null.");
    Preconditions.checkState(json.length() != 0, "JSONObject is empty.");
    return convertToProtoMessage(
        protoSchema, tableSchema.getFieldsList(), json, "root", ignoreUnknownFields);
  }

  /**
   * Converts Json array to list of protocol buffer messages given the protocol buffer descriptor.
   *
   * @param protoSchema
   * @param tableSchema bigquery table schema is needed for type conversion of DATETIME, TIME,
   *     NUMERIC, BIGNUMERIC
   * @param jsonArray
   * @param ignoreUnknownFields allows unknown fields in JSON input to be ignored.
   * @throws IllegalArgumentException when JSON data is not compatible with proto descriptor.
   */
  public List<DynamicMessage> convertToProtoMessage(
      Descriptor protoSchema,
      TableSchema tableSchema,
      JSONArray jsonArray,
      boolean ignoreUnknownFields)
      throws IllegalArgumentException {
    Preconditions.checkNotNull(jsonArray, "jsonArray is null.");
    Preconditions.checkNotNull(protoSchema, "Protobuf descriptor is null.");
    Preconditions.checkNotNull(tableSchema, "tableSchema is null.");
    Preconditions.checkState(jsonArray.length() != 0, "jsonArray is empty.");

    return convertToProtoMessage(
        protoSchema, tableSchema.getFieldsList(), jsonArray, "root", ignoreUnknownFields);
  }

  private DynamicMessage convertToProtoMessage(
      Descriptor protoSchema,
      List<TableFieldSchema> tableSchema,
      JSONObject jsonObject,
      String jsonScope,
      boolean ignoreUnknownFields) {
    JSONArray jsonArray = new JSONArray();
    jsonArray.put(jsonObject);
    return convertToProtoMessage(
            protoSchema, tableSchema, jsonArray, jsonScope, ignoreUnknownFields)
        .get(0);
  }

  /**
   * Converts Json data to protocol buffer messages given the protocol buffer descriptor.
   *
   * @param protoSchema
   * @param json
   * @param jsonScope Debugging purposes
   * @throws IllegalArgumentException when JSON data is not compatible with proto descriptor.
   */
  private List<DynamicMessage> convertToProtoMessage(
      Descriptor protoSchema,
      List<TableFieldSchema> tableSchema,
      JSONArray jsonArray,
      String jsonScope,
      boolean ignoreUnknownFields)
      throws RowIndexToErrorException {
    List<DynamicMessage> messageList = new ArrayList<>();
    Map<String, FieldDescriptorAndFieldTableSchema> jsonNameToMetadata = new HashMap<>();
    Map<Integer, String> rowIndexToErrorMessage = new HashMap<>();

    boolean hasDataUnknownError = false;
    for (int i = 0; i < jsonArray.length(); i++) {
      try {
        DynamicMessage.Builder protoMsg = DynamicMessage.newBuilder(protoSchema);
        JSONObject jsonObject = jsonArray.getJSONObject(i);
        String[] jsonNames = JSONObject.getNames(jsonObject);
        if (jsonNames == null) {
          messageList.add(protoMsg.build());
          continue;
        }
        for (String jsonName : jsonNames) {
          String currentScope = jsonScope + "." + jsonName;
          FieldDescriptorAndFieldTableSchema fieldDescriptorAndFieldTableSchema =
              jsonNameToMetadata.computeIfAbsent(
                  currentScope,
                  k -> {
                    return computeDescriptorAndSchema(
                        currentScope, ignoreUnknownFields, jsonName, protoSchema, tableSchema);
                  });
          if (fieldDescriptorAndFieldTableSchema == null) {
            continue;
          }
          FieldDescriptor field = fieldDescriptorAndFieldTableSchema.fieldDescriptor;
          TableFieldSchema tableFieldSchema = fieldDescriptorAndFieldTableSchema.tableFieldSchema;
          try {
            if (!field.isRepeated()) {
              fillField(
                  protoMsg,
                  field,
                  tableFieldSchema,
                  jsonObject,
                  jsonName,
                  currentScope,
                  ignoreUnknownFields);
            } else {
              fillRepeatedField(
                  protoMsg,
                  field,
                  tableFieldSchema,
                  jsonObject,
                  jsonName,
                  currentScope,
                  ignoreUnknownFields);
            }
          } catch (Exceptions.FieldParseError ex) {
            throw ex;
          } catch (Exception ex) {
            // This function is recursively called, so this throw will be caught and throw directly
            // out by the catch above.
            throw new Exceptions.FieldParseError(
                currentScope,
                tableFieldSchema != null
                    ? tableFieldSchema.getType().name()
                    : field.getType().name(),
                ex);
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
                  "JSONObject does not have the required field %s.%s.",
                  jsonScope, missingFieldName));
        }
        messageList.add(msg);
      } catch (IllegalArgumentException exception) {
        if (exception instanceof Exceptions.DataHasUnknownFieldException) {
          hasDataUnknownError = true;
        }
        if (exception instanceof Exceptions.FieldParseError) {
          Exceptions.FieldParseError ex = (Exceptions.FieldParseError) exception;
          rowIndexToErrorMessage.put(
              i,
              "Field "
                  + ex.getFieldName()
                  + " failed to convert to "
                  + ex.getBqType()
                  + ". Error: "
                  + ex.getCause().getMessage());
        } else {
          rowIndexToErrorMessage.put(i, exception.getMessage());
        }
      }
    }
    if (!rowIndexToErrorMessage.isEmpty()) {
      throw new RowIndexToErrorException(rowIndexToErrorMessage, hasDataUnknownError);
    }
    return messageList;
  }

  private static final class FieldDescriptorAndFieldTableSchema {
    TableFieldSchema tableFieldSchema;

    // Field descriptor
    FieldDescriptor fieldDescriptor;
  }

  private FieldDescriptorAndFieldTableSchema computeDescriptorAndSchema(
      String currentScope,
      boolean ignoreUnknownFields,
      String jsonName,
      Descriptor protoSchema,
      List<TableFieldSchema> tableFieldSchemaList) {

    // We want lowercase here to support case-insensitive data writes.
    // The protobuf descriptor that is used is assumed to have all lowercased fields
    String jsonFieldLocator = jsonName.toLowerCase();

    // If jsonName is not compatible with proto naming convention, we should look by its
    // placeholder name.
    if (!BigQuerySchemaUtil.isProtoCompatible(jsonFieldLocator)) {
      jsonFieldLocator = BigQuerySchemaUtil.generatePlaceholderFieldName(jsonFieldLocator);
    }

    FieldDescriptor field = protoSchema.findFieldByName(jsonFieldLocator);
    if (field == null && !ignoreUnknownFields) {
      throw new Exceptions.DataHasUnknownFieldException(currentScope);
    } else if (field == null) {
      return null;
    }
    TableFieldSchema fieldSchema = null;
    if (tableFieldSchemaList != null) {
      // protoSchema is generated from tableSchema so their field ordering should match.
      fieldSchema = tableFieldSchemaList.get(field.getIndex());
      // For RANGE type, expliclitly add the fields start and end of the same FieldElementType as it
      // is not expliclity defined in the TableFieldSchema.
      if (fieldSchema.getType() == TableFieldSchema.Type.RANGE) {
        switch (fieldSchema.getRangeElementType().getType()) {
          case DATE:
          case DATETIME:
          case TIMESTAMP:
            fieldSchema =
                fieldSchema
                    .toBuilder()
                    .addFields(
                        TableFieldSchema.newBuilder()
                            .setName("start")
                            .setType(fieldSchema.getRangeElementType().getType())
                            .build())
                    .addFields(
                        TableFieldSchema.newBuilder()
                            .setName("end")
                            .setType(fieldSchema.getRangeElementType().getType())
                            .build())
                    .build();
            break;
          default:
            throw new ValidationException(
                "Field at index "
                    + field.getIndex()
                    + " with name ("
                    + fieldSchema.getName()
                    + ") with type (RANGE) has an unsupported range element type ("
                    + fieldSchema.getRangeElementType()
                    + ")");
        }
      }

      if (!fieldSchema.getName().toLowerCase().equals(BigQuerySchemaUtil.getFieldName(field))) {
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
    FieldDescriptorAndFieldTableSchema fieldDescriptorAndFieldTableSchema =
        new FieldDescriptorAndFieldTableSchema();
    fieldDescriptorAndFieldTableSchema.fieldDescriptor = field;
    fieldDescriptorAndFieldTableSchema.tableFieldSchema = fieldSchema;
    return fieldDescriptorAndFieldTableSchema;
  }

  /**
   * Fills a non-repetaed protoField with the json data.
   *
   * @param protoMsg The protocol buffer message being constructed
   * @param fieldDescriptor
   * @param fieldSchema
   * @param json
   * @param exactJsonKeyName Exact key name in JSONObject instead of lowercased version
   * @param currentScope Debugging purposes
   * @throws IllegalArgumentException when JSON data is not compatible with proto descriptor.
   */
  private void fillField(
      DynamicMessage.Builder protoMsg,
      FieldDescriptor fieldDescriptor,
      TableFieldSchema fieldSchema,
      JSONObject json,
      String exactJsonKeyName,
      String currentScope,
      boolean ignoreUnknownFields)
      throws IllegalArgumentException {
    java.lang.Object val = json.get(exactJsonKeyName);
    if (val == JSONObject.NULL) {
      return;
    }
    switch (fieldDescriptor.getType()) {
      case BOOL:
        if (val instanceof Boolean) {
          protoMsg.setField(fieldDescriptor, val);
          return;
        }
        if (val instanceof String
            && ("true".equalsIgnoreCase(((String) val))
                || "false".equalsIgnoreCase(((String) val)))) {
          protoMsg.setField(fieldDescriptor, Boolean.parseBoolean((String) val));
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
            } else if (val instanceof Short || val instanceof Integer || val instanceof Long) {
              protoMsg.setField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToNumericByteString(
                      new BigDecimal(((Number) val).longValue())));
              return;
            } else if (val instanceof Float || val instanceof Double) {
              // In JSON, the precision passed in is machine dependent. We should round the number
              // before passing to backend.
              BigDecimal bigDecimal = new BigDecimal(String.valueOf(val));
              if (bigDecimal.scale() > 9) {
                bigDecimal = bigDecimal.setScale(NUMERIC_SCALE, RoundingMode.HALF_UP);
              }
              protoMsg.setField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToNumericByteString(bigDecimal));
              return;
            } else if (val instanceof BigDecimal) {
              protoMsg.setField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToNumericByteString((BigDecimal) val));
              return;
            }
          } else if (fieldSchema.getType() == TableFieldSchema.Type.BIGNUMERIC) {
            if (val instanceof String) {
              protoMsg.setField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToBigNumericByteString(
                      new BigDecimal((String) val)));
              return;
            } else if (val instanceof Short || val instanceof Integer || val instanceof Long) {
              protoMsg.setField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToBigNumericByteString(
                      new BigDecimal(((Number) val).longValue())));
              return;
            } else if (val instanceof Float || val instanceof Double) {
              protoMsg.setField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToBigNumericByteString(
                      new BigDecimal(String.valueOf(val))));
              return;
            } else if (val instanceof BigDecimal) {
              protoMsg.setField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToBigNumericByteString((BigDecimal) val));
              return;
            }
          }
        }
        if (val instanceof ByteString) {
          protoMsg.setField(fieldDescriptor, ((ByteString) val).toByteArray());
          return;
        } else if (val instanceof JSONArray) {
          byte[] bytes = new byte[((JSONArray) val).length()];
          for (int j = 0; j < ((JSONArray) val).length(); j++) {
            bytes[j] = (byte) ((JSONArray) val).getInt(j);
            if (bytes[j] != ((JSONArray) val).getInt(j)) {
              throw new IllegalArgumentException(
                  String.format(
                      "Error: " + currentScope + "[" + j + "] could not be converted to byte[]."));
            }
          }
          protoMsg.setField(fieldDescriptor, bytes);
          return;
        }
        break;
      case INT64:
        if (fieldSchema != null) {
          if (fieldSchema.getType() == TableFieldSchema.Type.DATETIME) {
            if (val instanceof String) {
              protoMsg.setField(
                  fieldDescriptor,
                  CivilTimeEncoder.encodePacked64DatetimeMicros(
                      LocalDateTime.parse((String) val, DATETIME_FORMATTER)));
              return;
            } else if (val instanceof Long) {
              protoMsg.setField(fieldDescriptor, val);
              return;
            }
          } else if (fieldSchema.getType() == TableFieldSchema.Type.TIME) {
            if (val instanceof String) {
              protoMsg.setField(
                  fieldDescriptor,
                  CivilTimeEncoder.encodePacked64TimeMicros(LocalTime.parse((String) val)));
              return;
            } else if (val instanceof Long) {
              protoMsg.setField(fieldDescriptor, val);
              return;
            }
          } else if (fieldSchema.getType() == TableFieldSchema.Type.TIMESTAMP) {
            if (val instanceof String) {
              Double parsed = Doubles.tryParse((String) val);
              if (parsed != null) {
                protoMsg.setField(fieldDescriptor, parsed.longValue());
                return;
              }
              TemporalAccessor parsedTime = TIMESTAMP_FORMATTER.parse((String) val);
              protoMsg.setField(
                  fieldDescriptor,
                  parsedTime.getLong(ChronoField.INSTANT_SECONDS) * 1000000
                      + parsedTime.getLong(ChronoField.MICRO_OF_SECOND));
              return;
            } else if (val instanceof Long) {
              protoMsg.setField(fieldDescriptor, val);
              return;
            } else if (val instanceof Integer) {
              protoMsg.setField(fieldDescriptor, Long.valueOf((Integer) val));
              return;
            }
          }
        }
        if (val instanceof Integer) {
          protoMsg.setField(fieldDescriptor, Long.valueOf((Integer) val));
          return;
        } else if (val instanceof Long) {
          protoMsg.setField(fieldDescriptor, val);
          return;
        }
        if (val instanceof String) {
          Long parsed = Longs.tryParse((String) val);
          if (parsed != null) {
            protoMsg.setField(fieldDescriptor, parsed);
            return;
          }
        }
        break;
      case INT32:
        if (fieldSchema != null && fieldSchema.getType() == TableFieldSchema.Type.DATE) {
          if (val instanceof String) {
            protoMsg.setField(fieldDescriptor, (int) LocalDate.parse((String) val).toEpochDay());
            return;
          } else if (val instanceof Integer || val instanceof Long) {
            protoMsg.setField(fieldDescriptor, ((Number) val).intValue());
            return;
          }
        }
        if (val instanceof Integer) {
          protoMsg.setField(fieldDescriptor, val);
          return;
        }
        if (val instanceof String) {
          Integer parsed = Ints.tryParse((String) val);
          if (parsed != null) {
            protoMsg.setField(fieldDescriptor, parsed);
            return;
          }
        }
        break;
      case STRING:
        if (val instanceof String) {
          protoMsg.setField(fieldDescriptor, val);
          return;
        } else if (val instanceof Short
            || val instanceof Integer
            || val instanceof Long
            || val instanceof Boolean) {
          protoMsg.setField(fieldDescriptor, String.valueOf(val));
          return;
        }
        break;
      case DOUBLE:
        if (val instanceof Number) {
          protoMsg.setField(fieldDescriptor, ((Number) val).doubleValue());
          return;
        }
        if (val instanceof String) {
          Double parsed = Doubles.tryParse((String) val);
          if (parsed != null) {
            protoMsg.setField(fieldDescriptor, parsed);
            return;
          }
        }
        break;
      case MESSAGE:
        if (val instanceof JSONObject) {
          protoMsg.setField(
              fieldDescriptor,
              convertToProtoMessage(
                  fieldDescriptor.getMessageType(),
                  fieldSchema == null ? null : fieldSchema.getFieldsList(),
                  json.getJSONObject(exactJsonKeyName),
                  currentScope,
                  ignoreUnknownFields));
          return;
        }
        break;
    }
    throw new IllegalArgumentException(
        String.format(
            "JSONObject does not have a %s field at %s.",
            FIELD_TYPE_TO_DEBUG_MESSAGE.get(fieldDescriptor.getType()), currentScope));
  }

  /**
   * Fills a repeated protoField with the json data.
   *
   * @param protoMsg The protocol buffer message being constructed
   * @param fieldDescriptor
   * @param fieldSchema
   * @param json If root level has no matching fields, throws exception.
   * @param exactJsonKeyName Exact key name in JSONObject instead of lowercased version
   * @param currentScope Debugging purposes
   * @throws IllegalArgumentException when JSON data is not compatible with proto descriptor.
   */
  private void fillRepeatedField(
      DynamicMessage.Builder protoMsg,
      FieldDescriptor fieldDescriptor,
      TableFieldSchema fieldSchema,
      JSONObject json,
      String exactJsonKeyName,
      String currentScope,
      boolean ignoreUnknownFields)
      throws IllegalArgumentException {

    JSONArray jsonArray;
    try {
      jsonArray = json.getJSONArray(exactJsonKeyName);
    } catch (JSONException e) {
      java.lang.Object val = json.get(exactJsonKeyName);
      // It is OK for repeated field to be null.
      if (val == JSONObject.NULL) {
        return;
      }
      throw new IllegalArgumentException(
          "JSONObject does not have a array field at " + currentScope + ".");
    }
    java.lang.Object val;
    int index;
    for (int i = 0; i < jsonArray.length(); i++) {
      val = jsonArray.get(i);
      index = i;
      switch (fieldDescriptor.getType()) {
        case BOOL:
          if (val instanceof Boolean) {
            protoMsg.addRepeatedField(fieldDescriptor, val);
          } else if (val instanceof String
              && ("true".equalsIgnoreCase(((String) val))
                  || "false".equalsIgnoreCase(((String) val)))) {
            protoMsg.addRepeatedField(fieldDescriptor, Boolean.parseBoolean((String) val));
          } else {
            throwWrongFieldType(fieldDescriptor, currentScope, index);
          }
          break;
        case BYTES:
          boolean added = false;
          if (fieldSchema != null && fieldSchema.getType() == TableFieldSchema.Type.NUMERIC) {
            if (val instanceof String) {
              protoMsg.addRepeatedField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToNumericByteString(
                      new BigDecimal((String) val)));
              added = true;
            } else if (val instanceof Short || val instanceof Integer || val instanceof Long) {
              protoMsg.addRepeatedField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToNumericByteString(
                      new BigDecimal(((Number) val).longValue())));
              added = true;
            } else if (val instanceof Float || val instanceof Double) {
              BigDecimal bigDecimal = new BigDecimal(String.valueOf(val));
              if (bigDecimal.scale() > 9) {
                bigDecimal = bigDecimal.setScale(NUMERIC_SCALE, RoundingMode.HALF_UP);
              }
              protoMsg.addRepeatedField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToNumericByteString(bigDecimal));
              added = true;
            } else if (val instanceof BigDecimal) {
              protoMsg.addRepeatedField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToNumericByteString((BigDecimal) val));
              added = true;
            }
          } else if (fieldSchema != null
              && fieldSchema.getType() == TableFieldSchema.Type.BIGNUMERIC) {
            if (val instanceof String) {
              protoMsg.addRepeatedField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToBigNumericByteString(
                      new BigDecimal((String) val)));
              added = true;
            } else if (val instanceof Short || val instanceof Integer || val instanceof Long) {
              protoMsg.addRepeatedField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToBigNumericByteString(
                      new BigDecimal(((Number) val).longValue())));
              added = true;
            } else if (val instanceof Float || val instanceof Double) {
              protoMsg.addRepeatedField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToBigNumericByteString(
                      new BigDecimal(String.valueOf(val))));
              added = true;
            } else if (val instanceof BigDecimal) {
              protoMsg.addRepeatedField(
                  fieldDescriptor,
                  BigDecimalByteStringEncoder.encodeToBigNumericByteString((BigDecimal) val));
              added = true;
            }
          }
          if (!added) {
            if (val instanceof ByteString) {
              protoMsg.addRepeatedField(fieldDescriptor, ((ByteString) val).toByteArray());
            } else if (val instanceof byte[]) {
              protoMsg.addRepeatedField(fieldDescriptor, val);
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
            } else {
              throwWrongFieldType(fieldDescriptor, currentScope, index);
            }
          }
          break;
        case INT64:
          if (fieldSchema != null && fieldSchema.getType() == TableFieldSchema.Type.DATETIME) {
            if (val instanceof String) {
              protoMsg.addRepeatedField(
                  fieldDescriptor,
                  CivilTimeEncoder.encodePacked64DatetimeMicros(
                      LocalDateTime.parse((String) val, DATETIME_FORMATTER)));
            } else if (val instanceof Long) {
              protoMsg.addRepeatedField(fieldDescriptor, val);
            } else {
              throwWrongFieldType(fieldDescriptor, currentScope, index);
            }
          } else if (fieldSchema != null && fieldSchema.getType() == TableFieldSchema.Type.TIME) {
            if (val instanceof String) {
              protoMsg.addRepeatedField(
                  fieldDescriptor,
                  CivilTimeEncoder.encodePacked64TimeMicros(LocalTime.parse((String) val)));
            } else if (val instanceof Long) {
              protoMsg.addRepeatedField(fieldDescriptor, val);
            } else {
              throwWrongFieldType(fieldDescriptor, currentScope, index);
            }
          } else if (fieldSchema != null
              && fieldSchema.getType() == TableFieldSchema.Type.TIMESTAMP) {
            if (val instanceof String) {
              Double parsed = Doubles.tryParse((String) val);
              if (parsed != null) {
                protoMsg.addRepeatedField(fieldDescriptor, parsed.longValue());
              } else {
                TemporalAccessor parsedTime = TIMESTAMP_FORMATTER.parse((String) val);
                protoMsg.addRepeatedField(
                    fieldDescriptor,
                    parsedTime.getLong(ChronoField.INSTANT_SECONDS) * 1000000
                        + parsedTime.getLong(ChronoField.MICRO_OF_SECOND));
              }
            } else if (val instanceof Long) {
              protoMsg.addRepeatedField(fieldDescriptor, val);
            } else if (val instanceof Integer) {
              protoMsg.addRepeatedField(fieldDescriptor, Long.valueOf((Integer) val));
            } else {
              throwWrongFieldType(fieldDescriptor, currentScope, index);
            }
          } else if (val instanceof Integer) {
            protoMsg.addRepeatedField(fieldDescriptor, Long.valueOf((Integer) val));
          } else if (val instanceof Long) {
            protoMsg.addRepeatedField(fieldDescriptor, val);
          } else if (val instanceof String) {
            Long parsed = Longs.tryParse((String) val);
            if (parsed != null) {
              protoMsg.addRepeatedField(fieldDescriptor, parsed);
            } else {
              throwWrongFieldType(fieldDescriptor, currentScope, index);
            }
          } else {
            throwWrongFieldType(fieldDescriptor, currentScope, index);
          }
          break;
        case INT32:
          if (fieldSchema != null && fieldSchema.getType() == TableFieldSchema.Type.DATE) {
            if (val instanceof String) {
              protoMsg.addRepeatedField(
                  fieldDescriptor, (int) LocalDate.parse((String) val).toEpochDay());
            } else if (val instanceof Integer || val instanceof Long) {
              protoMsg.addRepeatedField(fieldDescriptor, ((Number) val).intValue());
            } else {
              throwWrongFieldType(fieldDescriptor, currentScope, index);
            }
          } else if (val instanceof Integer) {
            protoMsg.addRepeatedField(fieldDescriptor, val);
          } else if (val instanceof String) {
            Integer parsed = Ints.tryParse((String) val);
            if (parsed != null) {
              protoMsg.addRepeatedField(fieldDescriptor, parsed);
            } else {
              throwWrongFieldType(fieldDescriptor, currentScope, index);
            }
          } else {
            throwWrongFieldType(fieldDescriptor, currentScope, index);
          }
          break;
        case STRING:
          if (val instanceof String) {
            protoMsg.addRepeatedField(fieldDescriptor, val);
          } else if (val instanceof Short
              || val instanceof Integer
              || val instanceof Long
              || val instanceof Boolean) {
            protoMsg.addRepeatedField(fieldDescriptor, String.valueOf(val));
            return;
          } else {
            throwWrongFieldType(fieldDescriptor, currentScope, index);
          }
          break;
        case DOUBLE:
          if (val instanceof Number) {
            protoMsg.addRepeatedField(fieldDescriptor, ((Number) val).doubleValue());
          } else if (val instanceof String) {
            Double parsed = Doubles.tryParse((String) val);
            if (parsed != null) {
              protoMsg.addRepeatedField(fieldDescriptor, parsed);
            } else {
              throwWrongFieldType(fieldDescriptor, currentScope, index);
            }
          } else {
            throwWrongFieldType(fieldDescriptor, currentScope, index);
          }
          break;
        case MESSAGE:
          if (val instanceof JSONObject) {
            protoMsg.addRepeatedField(
                fieldDescriptor,
                convertToProtoMessage(
                    fieldDescriptor.getMessageType(),
                    fieldSchema == null ? null : fieldSchema.getFieldsList(),
                    jsonArray.getJSONObject(i),
                    currentScope,
                    ignoreUnknownFields));
          } else {
            throwWrongFieldType(fieldDescriptor, currentScope, index);
          }
          break;
      }
    }
  }

  private static void throwWrongFieldType(
      FieldDescriptor fieldDescriptor, String currentScope, int index) {
    throw new IllegalArgumentException(
        String.format(
            "JSONObject does not have a %s field at %s[%d].",
            FIELD_TYPE_TO_DEBUG_MESSAGE.get(fieldDescriptor.getType()), currentScope, index));
  }
}
