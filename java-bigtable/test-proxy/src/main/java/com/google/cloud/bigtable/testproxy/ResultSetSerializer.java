/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.testproxy;

import com.google.bigtable.v2.ArrayValue;
import com.google.bigtable.v2.Type;
import com.google.bigtable.v2.Type.Array;
import com.google.bigtable.v2.Type.Bool;
import com.google.bigtable.v2.Type.Bytes;
import com.google.bigtable.v2.Type.Float32;
import com.google.bigtable.v2.Type.Float64;
import com.google.bigtable.v2.Type.Int64;
import com.google.bigtable.v2.Type.Map;
import com.google.bigtable.v2.Type.Proto;
import com.google.bigtable.v2.Type.Struct;
import com.google.bigtable.v2.Type.Timestamp;
import com.google.bigtable.v2.Value;
import com.google.cloud.Date;
import com.google.cloud.bigtable.common.Type.SchemalessEnum;
import com.google.cloud.bigtable.common.Type.SchemalessProto;
import com.google.cloud.bigtable.data.v2.models.sql.ColumnMetadata;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSet;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import com.google.cloud.bigtable.data.v2.models.sql.StructReader;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileDescriptorSet;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.ProtocolMessageEnum;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ResultSetSerializer {

  // This is a helper enum to satisfy the type constraints of {@link StructReader#getProtoEnum}.
  private static class DummyEnum implements ProtocolMessageEnum {

    private final int value;
    private final EnumDescriptor descriptor;

    private DummyEnum(int value, EnumDescriptor descriptor) {
      this.value = value;
      this.descriptor = descriptor;
    }

    @Override
    public int getNumber() {
      return value;
    }

    @Override
    public com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
      return descriptor.findValueByNumber(value);
    }

    @Override
    public com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
      return descriptor;
    }
  }

  /**
   * A map of all known message descriptors, keyed by their fully qualified name (e.g.,
   * "my.package.MyMessage").
   */
  private final java.util.Map<String, Descriptor> messageDescriptorMap;

  /**
   * A map of all known enum descriptors, keyed by their fully qualified name (e.g.,
   * "my.package.MyEnum").
   */
  private final java.util.Map<String, EnumDescriptor> enumDescriptorMap;

  /**
   * Helper function to recursively adds a message descriptor and all its nested types to the map.
   */
  private void populateDescriptorMapsRecursively(Descriptor descriptor) {
    messageDescriptorMap.put(descriptor.getFullName(), descriptor);

    for (EnumDescriptor nestedEnum : descriptor.getEnumTypes()) {
      enumDescriptorMap.put(nestedEnum.getFullName(), nestedEnum);
    }
    for (Descriptor nestedMessage : descriptor.getNestedTypes()) {
      populateDescriptorMapsRecursively(nestedMessage);
    }
  }

  /**
   * Creates a serializer with a descriptor cache built from the provided FileDescriptorSet. This is
   * useful for handling PROTO or ENUM types that require schema lookup.
   *
   * @param descriptorSet A set containing one or more .proto file definitions and all their
   *     non-standard dependencies. All .proto file must be provided in dependency order.
   * @throws IllegalArgumentException if the descriptorSet contains unresolvable dependencies.
   */
  public ResultSetSerializer(FileDescriptorSet descriptorSet) throws IllegalArgumentException {
    this.messageDescriptorMap = new HashMap<>();
    this.enumDescriptorMap = new HashMap<>();
    java.util.Map<String, FileDescriptor> builtDescriptors = new HashMap<>();

    for (FileDescriptorProto fileDescriptorProto : descriptorSet.getFileList()) {
      // Collect dependencies. This code require files inside the descriptor set to be sorted
      // according to the dependency order.
      List<FileDescriptor> dependencies = new ArrayList<>();
      for (String dependencyName : fileDescriptorProto.getDependencyList()) {
        FileDescriptor dependency = builtDescriptors.get(dependencyName);
        if (dependency != null) {
          // Dependency is already built, add it.
          dependencies.add(dependency);
        }
        // Dependency is not in our set. We assume it's a well-known type (e.g.,
        // google/protobuf/timestamp.proto) that buildFrom() can find and link automatically.
      }

      try {
        FileDescriptor fileDescriptor =
            FileDescriptor.buildFrom(
                fileDescriptorProto, dependencies.toArray(new FileDescriptor[0]));
        builtDescriptors.put(fileDescriptor.getName(), fileDescriptor);
        // Now, populate both message and enum maps with all messages/enums in this file.
        for (EnumDescriptor enumDescriptor : fileDescriptor.getEnumTypes()) {
          enumDescriptorMap.put(enumDescriptor.getFullName(), enumDescriptor);
        }
        for (Descriptor messageDescriptor : fileDescriptor.getMessageTypes()) {
          populateDescriptorMapsRecursively(messageDescriptor);
        }
      } catch (DescriptorValidationException e) {
        throw new IllegalArgumentException(
            "Failed to build descriptor for " + fileDescriptorProto.getName(), e);
      }
    }
  }

  public ExecuteQueryResult toExecuteQueryResult(ResultSet resultSet)
      throws ExecutionException, InterruptedException {
    ExecuteQueryResult.Builder resultBuilder = ExecuteQueryResult.newBuilder();
    for (ColumnMetadata columnMetadata : resultSet.getMetadata().getColumns()) {
      resultBuilder
          .getMetadataBuilder()
          .addColumnsBuilder()
          .setName(columnMetadata.name())
          .setType(toProtoType(columnMetadata.type()));
    }

    while (resultSet.next()) {
      SqlRow.Builder rowBuilder = resultBuilder.addRowsBuilder();

      for (int i = 0; i < resultSet.getMetadata().getColumns().size(); i++) {
        SqlType<?> colType = resultSet.getMetadata().getColumnType(i);
        rowBuilder.addValues(toProtoValue(getColumn(resultSet, i, colType), colType));
      }
    }

    return resultBuilder.build();
  }

  private Value toProtoValue(Object value, SqlType<?> type) {
    if (value == null) {
      return Value.getDefaultInstance();
    }

    Value.Builder valueBuilder = Value.newBuilder();
    switch (type.getCode()) {
      case BYTES:
        valueBuilder.setBytesValue((ByteString) value);
        break;
      case PROTO:
        valueBuilder.setBytesValue(((AbstractMessage) value).toByteString());
        break;
      case STRING:
        valueBuilder.setStringValue((String) value);
        break;
      case INT64:
        valueBuilder.setIntValue((Long) value);
        break;
      case ENUM:
        valueBuilder.setIntValue(((ProtocolMessageEnum) value).getNumber());
        break;
      case FLOAT32:
        valueBuilder.setFloatValue((Float) value);
        break;
      case FLOAT64:
        valueBuilder.setFloatValue((Double) value);
        break;
      case BOOL:
        valueBuilder.setBoolValue((Boolean) value);
        break;
      case TIMESTAMP:
        Instant ts = (Instant) value;
        valueBuilder.setTimestampValue(
            com.google.protobuf.Timestamp.newBuilder()
                .setSeconds(ts.getEpochSecond())
                .setNanos(ts.getNano())
                .build());
        break;
      case DATE:
        Date date = (Date) value;
        valueBuilder.setDateValue(
            com.google.type.Date.newBuilder()
                .setYear(date.getYear())
                .setMonth(date.getMonth())
                .setDay(date.getDayOfMonth())
                .build());
        break;
      case ARRAY:
        SqlType<?> elementType = ((SqlType.Array<?>) type).getElementType();
        ArrayValue.Builder arrayValue = ArrayValue.newBuilder();
        for (Object item : (List<?>) value) {
          arrayValue.addValues(toProtoValue(item, elementType));
        }
        valueBuilder.setArrayValue(arrayValue.build());
        break;
      case MAP:
        SqlType.Map<?, ?> mapType = (SqlType.Map<?, ?>) type;
        SqlType<?> mapKeyType = mapType.getKeyType();
        SqlType<?> mapValueType = mapType.getValueType();

        ArrayValue.Builder mapArrayValue = ArrayValue.newBuilder();
        ((java.util.Map<?, ?>) value)
            .forEach(
                (k, v) ->
                    mapArrayValue.addValues(
                        Value.newBuilder()
                            .setArrayValue(
                                ArrayValue.newBuilder()
                                    .addValues(toProtoValue(k, mapKeyType))
                                    .addValues(toProtoValue(v, mapValueType))
                                    .build())));
        valueBuilder.setArrayValue(mapArrayValue.build());
        break;
      case STRUCT:
        StructReader structValue = (StructReader) value;
        SqlType.Struct structType = (SqlType.Struct) type;
        ArrayValue.Builder structArrayValue = ArrayValue.newBuilder();
        for (int i = 0; i < structType.getFields().size(); ++i) {
          SqlType<?> fieldType = structType.getType(i);
          structArrayValue.addValues(toProtoValue(getColumn(structValue, i, fieldType), fieldType));
        }
        valueBuilder.setArrayValue(structArrayValue);
        break;
      default:
        throw new IllegalStateException("Unexpected Type: " + type);
    }

    return valueBuilder.build();
  }

  private Object getColumn(StructReader struct, int fieldIndex, SqlType<?> fieldType) {
    if (struct.isNull(fieldIndex)) {
      return null;
    }

    switch (fieldType.getCode()) {
      case ARRAY:
        return struct.getList(fieldIndex, (SqlType.Array<?>) fieldType);
      case BOOL:
        return struct.getBoolean(fieldIndex);
      case BYTES:
        return struct.getBytes(fieldIndex);
      case PROTO:
        SchemalessProto protoType = (SchemalessProto) fieldType;
        Descriptor descriptor = messageDescriptorMap.get(protoType.getMessageName());
        if (descriptor == null) {
          throw new IllegalArgumentException(
              "Descriptor for message " + protoType.getMessageName() + " could not be found");
        }
        return struct.getProtoMessage(fieldIndex, DynamicMessage.getDefaultInstance(descriptor));
      case DATE:
        return struct.getDate(fieldIndex);
      case FLOAT32:
        return struct.getFloat(fieldIndex);
      case FLOAT64:
        return struct.getDouble(fieldIndex);
      case INT64:
        return struct.getLong(fieldIndex);
      case ENUM:
        SchemalessEnum enumType = (SchemalessEnum) fieldType;
        EnumDescriptor enumDescriptor = enumDescriptorMap.get(enumType.getEnumName());
        if (enumDescriptor == null) {
          throw new IllegalArgumentException(
              "Descriptor for enum " + enumType.getEnumName() + " could not be found");
        }
        // We need to extract the integer value of the enum. `getProtoEnum` is the only
        // available method, but it is designed for static enum types. To work around this,
        // we can pass a lambda that constructs our DummyEnum with the captured integer value
        // and the descriptor from the outer scope.
        return struct.getProtoEnum(fieldIndex, number -> new DummyEnum(number, enumDescriptor));
      case MAP:
        return struct.getMap(fieldIndex, (SqlType.Map<?, ?>) fieldType);
      case STRING:
        return struct.getString(fieldIndex);
      case STRUCT:
        return struct.getStruct(fieldIndex);
      case TIMESTAMP:
        return struct.getTimestamp(fieldIndex);
      default:
        throw new IllegalStateException("Unexpected Type: " + fieldType);
    }
  }

  private static Type toProtoType(SqlType<?> type) {
    switch (type.getCode()) {
      case BYTES:
        return Type.newBuilder().setBytesType(Bytes.getDefaultInstance()).build();
      case STRING:
        return Type.newBuilder()
            .setStringType(com.google.bigtable.v2.Type.String.getDefaultInstance())
            .build();
      case INT64:
        return Type.newBuilder().setInt64Type(Int64.getDefaultInstance()).build();
      case FLOAT32:
        return Type.newBuilder().setFloat32Type(Float32.getDefaultInstance()).build();
      case FLOAT64:
        return Type.newBuilder().setFloat64Type(Float64.getDefaultInstance()).build();
      case BOOL:
        return Type.newBuilder().setBoolType(Bool.getDefaultInstance()).build();
      case TIMESTAMP:
        return Type.newBuilder().setTimestampType(Timestamp.getDefaultInstance()).build();
      case DATE:
        return Type.newBuilder()
            .setDateType(com.google.bigtable.v2.Type.Date.getDefaultInstance())
            .build();
      case ARRAY:
        SqlType.Array<?> arrayType = (SqlType.Array<?>) type;
        return Type.newBuilder()
            .setArrayType(
                Array.newBuilder().setElementType(toProtoType(arrayType.getElementType())))
            .build();
      case MAP:
        SqlType.Map<?, ?> mapType = (SqlType.Map<?, ?>) type;
        return Type.newBuilder()
            .setMapType(
                Map.newBuilder()
                    .setKeyType(toProtoType(mapType.getKeyType()))
                    .setValueType(toProtoType(mapType.getValueType())))
            .build();
      case STRUCT:
        SqlType.Struct structType = (SqlType.Struct) type;
        Struct.Builder structBuilder = Struct.newBuilder();
        for (SqlType.Struct.Field field : structType.getFields()) {
          structBuilder
              .addFieldsBuilder()
              .setFieldName(field.name())
              .setType(toProtoType(field.type()));
        }
        return Type.newBuilder().setStructType(structBuilder.build()).build();
      case PROTO:
        SchemalessProto protoType = (SchemalessProto) type;
        return Type.newBuilder()
            .setProtoType(
                Proto.newBuilder()
                    .setMessageName(protoType.getMessageName())
                    .setSchemaBundleId(protoType.schemaBundleId())
                    .build())
            .build();
      case ENUM:
        SchemalessEnum enumType = (SchemalessEnum) type;
        return Type.newBuilder()
            .setEnumType(
                com.google.bigtable.v2.Type.Enum.newBuilder()
                    .setEnumName(enumType.getEnumName())
                    .setSchemaBundleId(enumType.schemaBundleId())
                    .build())
            .build();
      default:
        throw new IllegalStateException("Unexpected Type: " + type);
    }
  }
}
