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

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.protobuf.Descriptors;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class that checks the schema compatibility between Proto schema in proto descriptor and
 * Bigquery table schema. If this check is passed, then user can write to BigQuery table using the
 * user schema, otherwise the write will fail.
 *
 * <p>The implementation as of now is not complete, which measn, if this check passed, there is
 * still a possbility of writing will fail.
 */
public class SchemaCompatibility {
  private BigQuery bigquery;
  private static SchemaCompatibility compat;
  private static String tablePatternString = "projects/([^/]+)/datasets/([^/]+)/tables/([^/]+)";
  private static Pattern tablePattern = Pattern.compile(tablePatternString);
  private static final int NestingLimit = 15;
  // private static Set<Descriptors.FieldDescriptor.Type> SupportedTypesHashSet =

  private static Set SupportedTypes =
      Collections.unmodifiableSet(
          new HashSet<>(
              Arrays.asList(
                  Descriptors.FieldDescriptor.Type.INT32,
                  Descriptors.FieldDescriptor.Type.INT64,
                  Descriptors.FieldDescriptor.Type.UINT32,
                  Descriptors.FieldDescriptor.Type.UINT64,
                  Descriptors.FieldDescriptor.Type.FIXED32,
                  Descriptors.FieldDescriptor.Type.FIXED64,
                  Descriptors.FieldDescriptor.Type.SFIXED32,
                  Descriptors.FieldDescriptor.Type.SFIXED64,
                  Descriptors.FieldDescriptor.Type.FLOAT,
                  Descriptors.FieldDescriptor.Type.DOUBLE,
                  Descriptors.FieldDescriptor.Type.BOOL,
                  Descriptors.FieldDescriptor.Type.BYTES,
                  Descriptors.FieldDescriptor.Type.STRING,
                  Descriptors.FieldDescriptor.Type.MESSAGE,
                  Descriptors.FieldDescriptor.Type.GROUP,
                  Descriptors.FieldDescriptor.Type.ENUM)));

  private SchemaCompatibility(BigQuery bigquery) {
    // TODO: Add functionality that allows SchemaCompatibility to build schemas.
    this.bigquery = bigquery;
  }

  /**
   * Gets a singleton {code SchemaCompatibility} object.
   *
   * @return
   */
  public static SchemaCompatibility getInstance() {
    if (compat == null) {
      RemoteBigQueryHelper bigqueryHelper = RemoteBigQueryHelper.create();
      compat = new SchemaCompatibility(bigqueryHelper.getOptions().getService());
    }
    return compat;
  }

  /**
   * Gets a {code SchemaCompatibility} object with custom BigQuery stub.
   *
   * @param bigquery
   * @return
   */
  @VisibleForTesting
  public static SchemaCompatibility getInstance(BigQuery bigquery) {
    Preconditions.checkNotNull(bigquery, "BigQuery is null.");
    return new SchemaCompatibility(bigquery);
  }

  private TableId getTableId(String tableName) {
    Matcher matcher = tablePattern.matcher(tableName);
    if (!matcher.matches() || matcher.groupCount() != 3) {
      throw new IllegalArgumentException("Invalid table name: " + tableName);
    }
    return TableId.of(matcher.group(1), matcher.group(2), matcher.group(3));
  }

  /**
   * @param field
   * @return True if fieldtype is supported by BQ Schema
   */
  public static boolean isSupportedType(Descriptors.FieldDescriptor field) {
    Preconditions.checkNotNull(field, "Field is null.");
    Descriptors.FieldDescriptor.Type fieldType = field.getType();
    if (!SupportedTypes.contains(fieldType)) {
      return false;
    }
    return true;
  }

  private static boolean isCompatibleWithBQBool(Descriptors.FieldDescriptor.Type field) {
    if (field == Descriptors.FieldDescriptor.Type.BOOL
        || field == Descriptors.FieldDescriptor.Type.INT32
        || field == Descriptors.FieldDescriptor.Type.INT64
        || field == Descriptors.FieldDescriptor.Type.UINT32
        || field == Descriptors.FieldDescriptor.Type.UINT64
        || field == Descriptors.FieldDescriptor.Type.FIXED32
        || field == Descriptors.FieldDescriptor.Type.FIXED64
        || field == Descriptors.FieldDescriptor.Type.SFIXED32
        || field == Descriptors.FieldDescriptor.Type.SFIXED64) {
      return true;
    }
    return false;
  }

  private static boolean isCompatibleWithBQBytes(Descriptors.FieldDescriptor.Type field) {
    if (field == Descriptors.FieldDescriptor.Type.BYTES) {
      return true;
    }
    return false;
  }

  private static boolean isCompatibleWithBQDate(Descriptors.FieldDescriptor.Type field) {
    if (field == Descriptors.FieldDescriptor.Type.INT32
        || field == Descriptors.FieldDescriptor.Type.INT64
        || field == Descriptors.FieldDescriptor.Type.SFIXED32
        || field == Descriptors.FieldDescriptor.Type.SFIXED64) {

      return true;
    }
    return false;
  }

  private static boolean isCompatibleWithBQDatetime(Descriptors.FieldDescriptor.Type field) {
    if (field == Descriptors.FieldDescriptor.Type.STRING
        || field == Descriptors.FieldDescriptor.Type.INT64) {
      return true;
    }
    return false;
  }

  private static boolean isCompatibleWithBQFloat(Descriptors.FieldDescriptor.Type field) {
    if (field == Descriptors.FieldDescriptor.Type.FLOAT) {
      return true;
    }
    if (field == Descriptors.FieldDescriptor.Type.DOUBLE) {
      return true;
    }
    return false;
  }

  private static boolean isCompatibleWithBQGeography(Descriptors.FieldDescriptor.Type field) {
    if (field == Descriptors.FieldDescriptor.Type.STRING) {
      return true;
    }
    return false;
  }

  private static boolean isCompatibleWithBQInteger(Descriptors.FieldDescriptor.Type field) {
    if (field == Descriptors.FieldDescriptor.Type.INT64
        || field == Descriptors.FieldDescriptor.Type.SFIXED64
        || field == Descriptors.FieldDescriptor.Type.INT32
        || field == Descriptors.FieldDescriptor.Type.UINT32
        || field == Descriptors.FieldDescriptor.Type.FIXED32
        || field == Descriptors.FieldDescriptor.Type.SFIXED32
        || field == Descriptors.FieldDescriptor.Type.ENUM) {
      return true;
    }
    return false;
  }

  private static boolean isCompatibleWithBQNumeric(Descriptors.FieldDescriptor.Type field) {
    if (field == Descriptors.FieldDescriptor.Type.INT32
        || field == Descriptors.FieldDescriptor.Type.INT64
        || field == Descriptors.FieldDescriptor.Type.UINT32
        || field == Descriptors.FieldDescriptor.Type.UINT64
        || field == Descriptors.FieldDescriptor.Type.FIXED32
        || field == Descriptors.FieldDescriptor.Type.FIXED64
        || field == Descriptors.FieldDescriptor.Type.SFIXED32
        || field == Descriptors.FieldDescriptor.Type.SFIXED64
        || field == Descriptors.FieldDescriptor.Type.STRING
        || field == Descriptors.FieldDescriptor.Type.BYTES
        || field == Descriptors.FieldDescriptor.Type.FLOAT
        || field == Descriptors.FieldDescriptor.Type.DOUBLE) {
      return true;
    }

    return false;
  }

  private static boolean isCompatibleWithBQRecord(Descriptors.FieldDescriptor.Type field) {
    if (field == Descriptors.FieldDescriptor.Type.MESSAGE
        || field == Descriptors.FieldDescriptor.Type.GROUP) {
      return true;
    }
    return false;
  }

  private static boolean isCompatibleWithBQString(Descriptors.FieldDescriptor.Type field) {
    if (field == Descriptors.FieldDescriptor.Type.STRING
        || field == Descriptors.FieldDescriptor.Type.ENUM) {
      return true;
    }
    return false;
  }

  private static boolean isCompatibleWithBQTime(Descriptors.FieldDescriptor.Type field) {
    if (field == Descriptors.FieldDescriptor.Type.INT64
        || field == Descriptors.FieldDescriptor.Type.STRING) {

      return true;
    }
    return false;
  }

  private static boolean isCompatibleWithBQTimestamp(Descriptors.FieldDescriptor.Type field) {
    if (isCompatibleWithBQInteger(field)) {
      return true;
    }
    return false;
  }

  /**
   * Checks if proto field option is compatible with BQ field mode.
   *
   * @param protoField
   * @param BQField
   * @param protoScope Debugging purposes to show error if messages are nested.
   * @param BQScope Debugging purposes to show error if messages are nested.
   * @throws IllegalArgumentException if proto field type is incompatible with BQ field type.
   */
  private void protoFieldModeIsCompatibleWithBQFieldMode(
      Descriptors.FieldDescriptor protoField, Field BQField, String protoScope, String BQScope)
      throws IllegalArgumentException {
    if (BQField.getMode() == null) {
      throw new IllegalArgumentException(
          "Big query schema contains invalid field option for " + BQScope + ".");
    }
    switch (BQField.getMode()) {
      case REPEATED:
        if (!protoField.isRepeated()) {
          throw new IllegalArgumentException(
              "Given proto field "
                  + protoScope
                  + " is not repeated but Big Query field "
                  + BQScope
                  + " is.");
        }
        break;
      case REQUIRED:
        if (!protoField.isRequired()) {
          throw new IllegalArgumentException(
              "Given proto field "
                  + protoScope
                  + " is not required but Big Query field "
                  + BQScope
                  + " is.");
        }
        break;
      case NULLABLE:
        if (protoField.isRepeated()) {
          throw new IllegalArgumentException(
              "Given proto field "
                  + protoScope
                  + " is repeated but Big Query field "
                  + BQScope
                  + " is optional.");
        }
        break;
    }
  }
  /**
   * Checks if proto field type is compatible with BQ field type.
   *
   * @param protoField
   * @param BQField
   * @param allowUnknownFields
   * @param protoScope Debugging purposes to show error if messages are nested.
   * @param BQScope Debugging purposes to show error if messages are nested.
   * @param allMessageTypes Keeps track of all current protos to avoid recursively nested protos.
   * @param rootProtoName Debugging purposes for nested level > 15.
   * @throws IllegalArgumentException if proto field type is incompatible with BQ field type.
   */
  private void protoFieldTypeIsCompatibleWithBQFieldType(
      Descriptors.FieldDescriptor protoField,
      Field BQField,
      boolean allowUnknownFields,
      String protoScope,
      String BQScope,
      HashSet<Descriptors.Descriptor> allMessageTypes,
      String rootProtoName)
      throws IllegalArgumentException {

    LegacySQLTypeName BQType = BQField.getType();
    Descriptors.FieldDescriptor.Type protoType = protoField.getType();
    boolean match = false;
    switch (BQType.toString()) {
      case "BOOLEAN":
        match = isCompatibleWithBQBool(protoType);
        break;
      case "BYTES":
        match = isCompatibleWithBQBytes(protoType);
        break;
      case "DATE":
        match = isCompatibleWithBQDate(protoType);
        break;
      case "DATETIME":
        match = isCompatibleWithBQDatetime(protoType);
        break;
      case "FLOAT":
        match = isCompatibleWithBQFloat(protoType);
        break;
      case "GEOGRAPHY":
        match = isCompatibleWithBQGeography(protoType);
        break;
      case "INTEGER":
        match = isCompatibleWithBQInteger(protoType);
        break;
      case "NUMERIC":
        match = isCompatibleWithBQNumeric(protoType);
        break;
      case "RECORD":
        if (allMessageTypes.size() > NestingLimit) {
          throw new IllegalArgumentException(
              "Proto schema "
                  + rootProtoName
                  + " is not supported: contains nested messages of more than 15 levels.");
        }
        match = isCompatibleWithBQRecord(protoType);
        if (!match) {
          break;
        }
        Descriptors.Descriptor message = protoField.getMessageType();
        if (allMessageTypes.contains(message)) {
          throw new IllegalArgumentException(
              "Proto schema " + protoScope + " is not supported: is a recursively nested message.");
        }
        allMessageTypes.add(message);
        isProtoCompatibleWithBQ(
            protoField.getMessageType(),
            Schema.of(BQField.getSubFields()),
            allowUnknownFields,
            protoScope,
            BQScope,
            false,
            allMessageTypes,
            rootProtoName);
        allMessageTypes.remove(message);
        break;
      case "STRING":
        match = isCompatibleWithBQString(protoType);
        break;
      case "TIME":
        match = isCompatibleWithBQTime(protoType);
        break;
      case "TIMESTAMP":
        match = isCompatibleWithBQTimestamp(protoType);
        break;
    }
    if (!match) {
      throw new IllegalArgumentException(
          "The proto field "
              + protoScope
              + " does not have a matching type with the big query field "
              + BQScope
              + ".");
    }
  }

  /**
   * Checks if proto schema is compatible with BQ schema.
   *
   * @param protoSchema
   * @param BQSchema
   * @param allowUnknownFields
   * @param protoScope Debugging purposes to show error if messages are nested.
   * @param BQScope Debugging purposes to show error if messages are nested.
   * @param topLevel True if this is the root level of proto (in terms of nested messages)
   * @param allMessageTypes Keeps track of all current protos to avoid recursively nested protos.
   * @param rootProtoName Debugging purposes for nested level > 15.
   * @throws IllegalArgumentException if proto field type is incompatible with BQ field type.
   */
  private void isProtoCompatibleWithBQ(
      Descriptors.Descriptor protoSchema,
      Schema BQSchema,
      boolean allowUnknownFields,
      String protoScope,
      String BQScope,
      boolean topLevel,
      HashSet<Descriptors.Descriptor> allMessageTypes,
      String rootProtoName)
      throws IllegalArgumentException {

    int matchedFields = 0;
    HashMap<String, Descriptors.FieldDescriptor> protoFieldMap = new HashMap<>();
    List<Descriptors.FieldDescriptor> protoFields = protoSchema.getFields();
    List<Field> BQFields = BQSchema.getFields();

    if (protoFields.size() > BQFields.size()) {
      if (!allowUnknownFields) {
        throw new IllegalArgumentException(
            "Proto schema "
                + protoScope
                + " has "
                + protoFields.size()
                + " fields, while BQ schema "
                + BQScope
                + " has "
                + BQFields.size()
                + " fields.");
      }
    }
    // Use hashmap to map from lowercased name to appropriate field to account for casing difference
    for (Descriptors.FieldDescriptor field : protoFields) {
      protoFieldMap.put(field.getName().toLowerCase(), field);
    }

    for (Field BQField : BQFields) {
      String fieldName = BQField.getName().toLowerCase();
      Descriptors.FieldDescriptor protoField = null;
      if (protoFieldMap.containsKey(fieldName)) {
        protoField = protoFieldMap.get(fieldName);
      }

      String currentBQScope = BQScope + "." + BQField.getName();
      if (protoField == null && BQField.getMode() == Field.Mode.REQUIRED) {
        throw new IllegalArgumentException(
            "The required Big Query field "
                + currentBQScope
                + " is missing in the proto schema "
                + protoScope
                + ".");
      }
      if (protoField == null) {
        continue;
      }
      String currentProtoScope = protoScope + "." + protoField.getName();
      if (!isSupportedType(protoField)) {
        throw new IllegalArgumentException(
            "Proto schema "
                + currentProtoScope
                + " is not supported: contains "
                + protoField.getType()
                + " field type.");
      }
      if (protoField.isMapField()) {
        throw new IllegalArgumentException(
            "Proto schema " + currentProtoScope + " is not supported: is a map field.");
      }
      protoFieldModeIsCompatibleWithBQFieldMode(
          protoField, BQField, currentProtoScope, currentBQScope);
      protoFieldTypeIsCompatibleWithBQFieldType(
          protoField,
          BQField,
          allowUnknownFields,
          currentProtoScope,
          currentBQScope,
          allMessageTypes,
          rootProtoName);
      matchedFields++;
    }

    if (matchedFields == 0 && topLevel) {
      throw new IllegalArgumentException(
          "There is no matching fields found for the proto schema "
              + protoScope
              + " and the BQ table schema "
              + BQScope
              + ".");
    }
  }

  /**
   * Checks if proto schema is compatible with BQ schema after retrieving BQ schema by BQTableName.
   *
   * @param BQTableName Must include project_id, dataset_id, and table_id in the form that matches
   *     the regex "projects/([^/]+)/datasets/([^/]+)/tables/([^/]+)"
   * @param protoSchema
   * @param allowUnknownFields Flag indicating proto can have unknown fields.
   * @throws IllegalArgumentException if proto field type is incompatible with BQ field type.
   */
  public void check(
      String BQTableName, Descriptors.Descriptor protoSchema, boolean allowUnknownFields)
      throws IllegalArgumentException {
    Preconditions.checkNotNull(BQTableName, "TableName is null.");
    Preconditions.checkNotNull(protoSchema, "Protobuf descriptor is null.");

    TableId tableId = getTableId(BQTableName);
    Table table = bigquery.getTable(tableId);
    Schema BQSchema = table.getDefinition().getSchema();
    String protoSchemaName = protoSchema.getName();
    HashSet<Descriptors.Descriptor> allMessageTypes = new HashSet<>();
    allMessageTypes.add(protoSchema);
    isProtoCompatibleWithBQ(
        protoSchema,
        BQSchema,
        allowUnknownFields,
        protoSchemaName,
        tableId.getTable(),
        true,
        allMessageTypes,
        protoSchemaName);
  }

  /**
   * Checks if proto schema is compatible with BQ schema after retrieving BQ schema by BQTableName.
   * Assumes allowUnknownFields is false.
   *
   * @param BQTableName Must include project_id, dataset_id, and table_id in the form that matches
   *     the regex "projects/([^/]+)/datasets/([^/]+)/tables/([^/]+)"
   * @param protoSchema
   * @throws IllegalArgumentException if proto field type is incompatible with BQ field type.
   */
  public void check(String BQTableName, Descriptors.Descriptor protoSchema)
      throws IllegalArgumentException {

    check(BQTableName, protoSchema, false);
  }
}
