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
package com.google.cloud.bigtable.data.v2.models.sql;

import com.google.api.core.InternalApi;
import com.google.cloud.Date;
import com.google.cloud.bigtable.common.Type;
import com.google.cloud.bigtable.common.Type.SchemalessStruct;
import com.google.cloud.bigtable.common.Type.StructWithSchema;
import com.google.protobuf.ByteString;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * Represents a data type in a SQL query.
 *
 * <p>Complex types ({@link SqlType.Map}, {@link SqlType.Array}, & {@link SqlType.Struct} provide
 * additional information about the schema of the type.
 *
 * @param <T> the corresponding java type
 */
public interface SqlType<T> extends Serializable {

  /* Enumeration of the types */
  enum Code {
    BYTES,
    STRING,
    INT64,
    FLOAT64,
    FLOAT32,
    BOOL,
    TIMESTAMP,
    DATE,
    STRUCT,
    ARRAY,
    MAP
  }

  /** @return {@link Code} enum for this type */
  Code getCode();

  /**
   * Represents a map type in SQL. Provides access to the key and value types for the map.
   *
   * @param <K> Java type of the Map key data
   * @param <V> Java type of the Map value data
   */
  interface Map<K, V> extends SqlType<java.util.Map<K, V>> {
    /** @return {@link SqlType} of the map's key */
    SqlType<K> getKeyType();

    /** @return {@link SqlType} of the map's value */
    SqlType<V> getValueType();
  }

  /**
   * Represents an array type in SQL. Provides access to the element type of the array.
   *
   * @param <Elem> Java type of the Array element data
   */
  interface Array<Elem> extends SqlType<List<Elem>> {
    /** @return {@link SqlType} of the array's elements */
    SqlType<Elem> getElementType();
  }

  /**
   * Represents a struct type in SQL. A struct is an ordered collection of named and type fields.
   */
  interface Struct extends SqlType<com.google.cloud.bigtable.data.v2.models.sql.Struct> {
    // This extends ColumnMetadata so that we can reuse some helpers for both types
    /** Represents a field in a struct */
    interface Field extends ColumnMetadata {
      /** @return the name of the field. Returns an empty string for fields without names. */
      String name();

      /** @return the {@link SqlType} of the field */
      SqlType<?> type();
    }

    /** @return the ordered list of {@link Field}s for the struct */
    List<? extends Field> getFields();

    /**
     * @param fieldIndex index of the field
     * @return the {@link SqlType} of the field at the given index
     */
    SqlType<?> getType(int fieldIndex);

    /**
     * @param fieldName name of the field
     * @return the {@link SqlType} of the field with the given name
     * @throws IllegalArgumentException if there is no field with the name *or* if there are
     *     multiple columns with the given name
     */
    SqlType<?> getType(String fieldName);

    /**
     * @param fieldName name of the field
     * @return the field index of the field with the given name
     * @throws IllegalArgumentException if there is no field with the name *or* if there are
     *     multiple columns with the given name
     */
    int getColumnIndex(String fieldName);
  }

  /** returns a {@link SqlType} for the {@code BYTES} type. */
  static SqlType<ByteString> bytes() {
    return Type.Bytes.create();
  }

  /** returns a {@link SqlType} for the {@code STRING} type. */
  static SqlType<String> string() {
    return Type.String.create();
  }

  /** returns a {@link SqlType} for the {@code INT64} type. */
  static SqlType<Long> int64() {
    return Type.Int64.create();
  }

  /** returns a {@link SqlType} for the {@code FLOAT64} type. */
  static SqlType<Double> float64() {
    return Type.Float64.create();
  }

  /** returns a {@link SqlType} for the {@code FLOAT32} type. */
  static SqlType<Float> float32() {
    return Type.Float32.create();
  }

  /** returns a {@link SqlType} for the {@code BOOL} type. */
  static SqlType<Boolean> bool() {
    return Type.Bool.create();
  }

  /** returns a {@link SqlType} for the {@code TIMESTAMP} type. */
  static SqlType<Instant> timestamp() {
    return Type.Timestamp.create();
  }

  /** returns a {@link SqlType} for the {@code DATE} type. */
  static SqlType<Date> date() {
    return Type.Date.create();
  }

  /**
   * returns a fake {@code STRUCT type} for use on in {@link StructReader} methods that require a
   * {@link SqlType} to validate against. This does not specify a schema because the struct schem
   * will be validated on calls to the structs data accessors.
   *
   * <p> Attempts to access the schema of a struct created this way will throw exceptions.
   *
   * <p> Example usage:
   * <pre>{@code
   *   List<Struct> structList = resultSet.getList("column", SqlType.arrayOf(SqlType.struct()));
   * }
   */
  static SqlType.Struct struct() {
    return SchemalessStruct.create();
  }

  /** returns a {@link SqlType} for an {@code ARRAY} with elements of type {@code elemType} */
  static <Elem> SqlType.Array<Elem> arrayOf(SqlType<Elem> elemType) {
    return Type.Array.create(elemType);
  }

  /**
   * returns a {@link SqlType} for a @code MAP} with keys of type {@code keyType} and values of type
   * {@code valType}
   */
  static <K, V> SqlType.Map<K, V> mapOf(SqlType<K> keyType, SqlType<V> valType) {
    return Type.Map.create(keyType, valType);
  }

  /**
   * returns the {@link SqlType} for the type returned for column families in {@code with_history}
   * queries. This is equivalent to {@code SqlType.mapOf(SqlType.bytes(),
   * SqlType.arrayOf(SqlType.struct()))}
   */
  static SqlType.Map<ByteString, List<com.google.cloud.bigtable.data.v2.models.sql.Struct>>
      historicalMap() {
    return mapOf(bytes(), arrayOf(struct()));
  }

  /**
   * Creates a {@link SqlType} from the protobuf representation of Types.
   *
   * <p>This is considered an internal implementation detail and not meant to be used by
   * applications.
   */
  @InternalApi
  static SqlType<?> fromProto(com.google.bigtable.v2.Type proto) {
    switch (proto.getKindCase()) {
      case BYTES_TYPE:
        return bytes();
      case STRING_TYPE:
        return string();
      case INT64_TYPE:
        return int64();
      case FLOAT64_TYPE:
        return float64();
      case FLOAT32_TYPE:
        return float32();
      case BOOL_TYPE:
        return bool();
      case TIMESTAMP_TYPE:
        return timestamp();
      case DATE_TYPE:
        return date();
      case STRUCT_TYPE:
        return StructWithSchema.fromProto(proto.getStructType());
      case ARRAY_TYPE:
        return arrayOf(fromProto(proto.getArrayType().getElementType()));
      case MAP_TYPE:
        com.google.bigtable.v2.Type.Map mapType = proto.getMapType();
        return mapOf(fromProto(mapType.getKeyType()), fromProto(mapType.getValueType()));
      case KIND_NOT_SET:
        throw new IllegalStateException("Unrecognized Type. You may need to update your client.");
      default:
        throw new IllegalStateException("Unexpected Type: " + proto.getKindCase().name());
    }
  }

  /**
   * This can be used to check whether {@link
   * com.google.cloud.bigtable.data.v2.models.sql.StructReader} get calls are being called for the
   * correct type when compared to the schema. This is different that equals because we do not
   * require users to specify the full struct schema for struct get calls. This is safe because the
   * struct schema will be validated on calls to the struct.
   *
   * <p>This is considered an internal implementation detail and not meant to be used by
   * applications.
   */
  @InternalApi
  static boolean typesMatch(SqlType<?> left, SqlType<?> right) {
    switch (left.getCode()) {
      case BYTES:
      case STRING:
      case INT64:
      case FLOAT64:
      case FLOAT32:
      case BOOL:
      case TIMESTAMP:
      case DATE:
        return left.equals(right);
      case STRUCT:
        // Don't validate fields since the field types will be validated on
        // accessor calls to struct
        return left.getCode().equals(right.getCode());
      case ARRAY:
        if (!left.getCode().equals(right.getCode())) {
          return false;
        }
        SqlType.Array<?> leftArray = (SqlType.Array<?>) left;
        SqlType.Array<?> rightArray = (SqlType.Array<?>) right;
        return typesMatch(leftArray.getElementType(), rightArray.getElementType());
      case MAP:
        if (!left.getCode().equals(right.getCode())) {
          return false;
        }
        SqlType.Map<?, ?> leftMap = (SqlType.Map<?, ?>) left;
        SqlType.Map<?, ?> rightMap = (SqlType.Map<?, ?>) right;
        boolean keysMatch = typesMatch(leftMap.getKeyType(), rightMap.getKeyType());
        boolean valuesMatch = typesMatch(leftMap.getValueType(), rightMap.getValueType());
        return keysMatch && valuesMatch;
      default:
        throw new IllegalStateException("Unexpected type: " + left);
    }
  }
}
