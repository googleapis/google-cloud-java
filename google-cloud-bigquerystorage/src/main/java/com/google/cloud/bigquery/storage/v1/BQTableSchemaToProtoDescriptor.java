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

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos.FieldOptions;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Converts a BQ table schema to protobuf descriptor. All field names will be converted to lowercase
 * when constructing the protobuf descriptor. The mapping between field types and field modes are
 * shown in the ImmutableMaps below.
 */
public class BQTableSchemaToProtoDescriptor {
  private static ImmutableMap<TableFieldSchema.Mode, FieldDescriptorProto.Label>
      BQTableSchemaModeMap =
          ImmutableMap.of(
              TableFieldSchema.Mode.NULLABLE, FieldDescriptorProto.Label.LABEL_OPTIONAL,
              TableFieldSchema.Mode.REPEATED, FieldDescriptorProto.Label.LABEL_REPEATED,
              TableFieldSchema.Mode.REQUIRED, FieldDescriptorProto.Label.LABEL_REQUIRED);

  private static ImmutableMap<TableFieldSchema.Type, FieldDescriptorProto.Type>
      BQTableSchemaTypeMap =
          new ImmutableMap.Builder<TableFieldSchema.Type, FieldDescriptorProto.Type>()
              .put(TableFieldSchema.Type.BOOL, FieldDescriptorProto.Type.TYPE_BOOL)
              .put(TableFieldSchema.Type.BYTES, FieldDescriptorProto.Type.TYPE_BYTES)
              .put(TableFieldSchema.Type.DATE, FieldDescriptorProto.Type.TYPE_INT32)
              .put(TableFieldSchema.Type.DATETIME, FieldDescriptorProto.Type.TYPE_INT64)
              .put(TableFieldSchema.Type.DOUBLE, FieldDescriptorProto.Type.TYPE_DOUBLE)
              .put(TableFieldSchema.Type.GEOGRAPHY, FieldDescriptorProto.Type.TYPE_STRING)
              .put(TableFieldSchema.Type.INT64, FieldDescriptorProto.Type.TYPE_INT64)
              .put(TableFieldSchema.Type.NUMERIC, FieldDescriptorProto.Type.TYPE_BYTES)
              .put(TableFieldSchema.Type.BIGNUMERIC, FieldDescriptorProto.Type.TYPE_BYTES)
              .put(TableFieldSchema.Type.STRING, FieldDescriptorProto.Type.TYPE_STRING)
              .put(TableFieldSchema.Type.STRUCT, FieldDescriptorProto.Type.TYPE_MESSAGE)
              .put(TableFieldSchema.Type.TIME, FieldDescriptorProto.Type.TYPE_INT64)
              .put(TableFieldSchema.Type.TIMESTAMP, FieldDescriptorProto.Type.TYPE_INT64)
              .put(TableFieldSchema.Type.JSON, FieldDescriptorProto.Type.TYPE_STRING)
              .put(TableFieldSchema.Type.INTERVAL, FieldDescriptorProto.Type.TYPE_STRING)
              .build();

  /**
   * Converts TableFieldSchema to a Descriptors.Descriptor object.
   *
   * @param BQTableSchema
   * @throws Descriptors.DescriptorValidationException
   */
  public static Descriptor convertBQTableSchemaToProtoDescriptor(TableSchema BQTableSchema)
      throws Descriptors.DescriptorValidationException {
    Preconditions.checkNotNull(BQTableSchema, "BQTableSchema is null.");
    return convertBQTableSchemaToProtoDescriptorImpl(
        BQTableSchema, "root", new HashMap<ImmutableList<TableFieldSchema>, Descriptor>());
  }

  /**
   * Converts a TableFieldSchema to a Descriptors.Descriptor object.
   *
   * @param BQTableSchema
   * @param scope Keeps track of current scope to prevent repeated naming while constructing
   *     descriptor.
   * @param dependencyMap Stores already constructed descriptors to prevent reconstruction
   * @throws Descriptors.DescriptorValidationException
   */
  private static Descriptor convertBQTableSchemaToProtoDescriptorImpl(
      TableSchema BQTableSchema,
      String scope,
      HashMap<ImmutableList<TableFieldSchema>, Descriptor> dependencyMap)
      throws Descriptors.DescriptorValidationException {
    List<FileDescriptor> dependenciesList = new ArrayList<FileDescriptor>();
    List<FieldDescriptorProto> fields = new ArrayList<FieldDescriptorProto>();
    int index = 1;
    for (TableFieldSchema BQTableField : BQTableSchema.getFieldsList()) {
      String scopeName =
          BigQuerySchemaUtil.isProtoCompatible(BQTableField.getName())
              ? BQTableField.getName()
              : BigQuerySchemaUtil.generatePlaceholderFieldName(BQTableField.getName());
      String currentScope = scope + "__" + scopeName;
      if (BQTableField.getType() == TableFieldSchema.Type.STRUCT) {
        ImmutableList<TableFieldSchema> fieldList =
            ImmutableList.copyOf(BQTableField.getFieldsList());
        if (dependencyMap.containsKey(fieldList)) {
          Descriptor descriptor = dependencyMap.get(fieldList);
          dependenciesList.add(descriptor.getFile());
          fields.add(convertBQTableFieldToProtoField(BQTableField, index++, descriptor.getName()));
        } else {
          Descriptor descriptor =
              convertBQTableSchemaToProtoDescriptorImpl(
                  TableSchema.newBuilder().addAllFields(fieldList).build(),
                  currentScope,
                  dependencyMap);
          dependenciesList.add(descriptor.getFile());
          dependencyMap.put(fieldList, descriptor);
          fields.add(convertBQTableFieldToProtoField(BQTableField, index++, currentScope));
        }
      } else {
        fields.add(convertBQTableFieldToProtoField(BQTableField, index++, currentScope));
      }
    }
    FileDescriptor[] dependenciesArray = new FileDescriptor[dependenciesList.size()];
    dependenciesArray = dependenciesList.toArray(dependenciesArray);
    DescriptorProto descriptorProto =
        DescriptorProto.newBuilder().setName(scope).addAllField(fields).build();
    FileDescriptorProto fileDescriptorProto =
        FileDescriptorProto.newBuilder().addMessageType(descriptorProto).build();
    FileDescriptor fileDescriptor =
        FileDescriptor.buildFrom(fileDescriptorProto, dependenciesArray);
    Descriptor descriptor = fileDescriptor.findMessageTypeByName(scope);
    return descriptor;
  }

  /**
   * Converts a BQTableField to ProtoField
   *
   * @param BQTableField BQ Field used to construct a FieldDescriptorProto
   * @param index Index for protobuf fields.
   * @param scope used to name descriptors
   */
  private static FieldDescriptorProto convertBQTableFieldToProtoField(
      TableFieldSchema BQTableField, int index, String scope) {
    TableFieldSchema.Mode mode = BQTableField.getMode();
    String fieldName = BQTableField.getName().toLowerCase();

    FieldDescriptorProto.Builder fieldDescriptor =
        FieldDescriptorProto.newBuilder()
            .setName(fieldName)
            .setNumber(index)
            .setLabel((FieldDescriptorProto.Label) BQTableSchemaModeMap.get(mode));

    if (BQTableField.getType() == TableFieldSchema.Type.STRUCT) {
      fieldDescriptor.setTypeName(scope);
    } else {
      fieldDescriptor.setType(
          (FieldDescriptorProto.Type) BQTableSchemaTypeMap.get(BQTableField.getType()));
    }

    // Sets columnName annotation when field name is not proto comptaible.
    if (!BigQuerySchemaUtil.isProtoCompatible(fieldName)) {
      fieldDescriptor.setName(BigQuerySchemaUtil.generatePlaceholderFieldName(fieldName));
      fieldDescriptor.setOptions(
          FieldOptions.newBuilder().setExtension(AnnotationsProto.columnName, fieldName).build());
    }
    return fieldDescriptor.build();
  }
}
