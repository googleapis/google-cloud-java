/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.spanner.v1.TypeAnnotationCode.TYPE_ANNOTATION_CODE_UNSPECIFIED;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.spanner.v1.TypeAnnotationCode;
import com.google.spanner.v1.TypeCode;
import java.io.Serializable;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/**
 * Describes a type in the Cloud Spanner type system. Types can either be primitive (for example,
 * {@code INT64} and {@code STRING}) or composite (for example, {@code ARRAY<INT64>} or {@code
 * STRUCT<INT64,STRING>}).
 *
 * <p>{@code Type} instances are immutable.
 */
@Immutable
public final class Type implements Serializable {
  private static final Type TYPE_BOOL = new Type(Code.BOOL, null, null);
  private static final Type TYPE_INT64 = new Type(Code.INT64, null, null);
  private static final Type TYPE_FLOAT32 = new Type(Code.FLOAT32, null, null);
  private static final Type TYPE_FLOAT64 = new Type(Code.FLOAT64, null, null);
  private static final Type TYPE_NUMERIC = new Type(Code.NUMERIC, null, null);
  private static final Type TYPE_PG_NUMERIC = new Type(Code.PG_NUMERIC, null, null);
  private static final Type TYPE_STRING = new Type(Code.STRING, null, null);
  private static final Type TYPE_JSON = new Type(Code.JSON, null, null);
  private static final Type TYPE_PG_JSONB = new Type(Code.PG_JSONB, null, null);
  private static final Type TYPE_PG_OID = new Type(Code.PG_OID, null, null);
  private static final Type TYPE_BYTES = new Type(Code.BYTES, null, null);
  private static final Type TYPE_TIMESTAMP = new Type(Code.TIMESTAMP, null, null);
  private static final Type TYPE_DATE = new Type(Code.DATE, null, null);
  private static final Type TYPE_UUID = new Type(Code.UUID, null, null);
  private static final Type TYPE_INTERVAL = new Type(Code.INTERVAL, null, null);
  private static final Type TYPE_ARRAY_BOOL = new Type(Code.ARRAY, TYPE_BOOL, null);
  private static final Type TYPE_ARRAY_INT64 = new Type(Code.ARRAY, TYPE_INT64, null);
  private static final Type TYPE_ARRAY_FLOAT32 = new Type(Code.ARRAY, TYPE_FLOAT32, null);
  private static final Type TYPE_ARRAY_FLOAT64 = new Type(Code.ARRAY, TYPE_FLOAT64, null);
  private static final Type TYPE_ARRAY_NUMERIC = new Type(Code.ARRAY, TYPE_NUMERIC, null);
  private static final Type TYPE_ARRAY_PG_NUMERIC = new Type(Code.ARRAY, TYPE_PG_NUMERIC, null);
  private static final Type TYPE_ARRAY_STRING = new Type(Code.ARRAY, TYPE_STRING, null);
  private static final Type TYPE_ARRAY_JSON = new Type(Code.ARRAY, TYPE_JSON, null);
  private static final Type TYPE_ARRAY_PG_JSONB = new Type(Code.ARRAY, TYPE_PG_JSONB, null);
  private static final Type TYPE_ARRAY_PG_OID = new Type(Code.ARRAY, TYPE_PG_OID, null);
  private static final Type TYPE_ARRAY_BYTES = new Type(Code.ARRAY, TYPE_BYTES, null);
  private static final Type TYPE_ARRAY_TIMESTAMP = new Type(Code.ARRAY, TYPE_TIMESTAMP, null);
  private static final Type TYPE_ARRAY_DATE = new Type(Code.ARRAY, TYPE_DATE, null);
  private static final Type TYPE_ARRAY_UUID = new Type(Code.ARRAY, TYPE_UUID, null);
  private static final Type TYPE_ARRAY_INTERVAL = new Type(Code.ARRAY, TYPE_INTERVAL, null);

  private static final int AMBIGUOUS_FIELD = -1;
  private static final long serialVersionUID = -3076152125004114582L;

  static Type unrecognized(com.google.spanner.v1.Type proto) {
    return new Type(proto);
  }

  /** Returns the descriptor for the {@code BOOL type}. */
  public static Type bool() {
    return TYPE_BOOL;
  }

  /**
   * Returns the descriptor for the {@code INT64} type: an integral type with the same value domain
   * as a Java {@code long}.
   */
  public static Type int64() {
    return TYPE_INT64;
  }

  /**
   * Returns the descriptor for the {@code FLOAT32} type: a floating point type with the same value
   * domain as a Java {@code float}.
   */
  public static Type float32() {
    return TYPE_FLOAT32;
  }

  /**
   * Returns the descriptor for the {@code FLOAT64} type: a floating point type with the same value
   * domain as a Java {@code double}.
   */
  public static Type float64() {
    return TYPE_FLOAT64;
  }

  /** Returns the descriptor for the {@code NUMERIC} type. */
  public static Type numeric() {
    return TYPE_NUMERIC;
  }

  /**
   * Returns the descriptor for the {@code NUMERIC} type with the {@code PG_NUMERIC} type
   * annotation.
   */
  public static Type pgNumeric() {
    return Type.TYPE_PG_NUMERIC;
  }

  /**
   * Returns the descriptor for the {@code STRING} type: a variable-length Unicode character string.
   */
  public static Type string() {
    return TYPE_STRING;
  }

  /** Returns the descriptor for the {@code JSON} type. */
  public static Type json() {
    return TYPE_JSON;
  }

  /** Returns the descriptor for the {@code JSONB} type. */
  public static Type pgJsonb() {
    return TYPE_PG_JSONB;
  }

  /** Returns the descriptor for the {@code PG_OID} type. */
  public static Type pgOid() {
    return TYPE_PG_OID;
  }

  /**
   * To get the descriptor for the {@code PROTO} type.
   *
   * @param protoTypeFqn Proto fully qualified name (ex: "examples.spanner.music.SingerInfo").
   */
  public static Type proto(String protoTypeFqn) {
    return new Type(Code.PROTO, protoTypeFqn);
  }

  /**
   * To get the descriptor for the {@code ENUM} type.
   *
   * @param protoTypeFqn Proto ENUM fully qualified name (ex: "examples.spanner.music.Genre")
   */
  public static Type protoEnum(String protoTypeFqn) {
    return new Type(Code.ENUM, protoTypeFqn);
  }

  /** Returns the descriptor for the {@code BYTES} type: a variable-length byte string. */
  public static Type bytes() {
    return TYPE_BYTES;
  }

  /**
   * Returns the descriptor for the {@code TIMESTAMP} type: a nano precision timestamp in the range
   * [0000-01-01 00:00:00, 9999-12-31 23:59:59.999999999 UTC].
   */
  public static Type timestamp() {
    return TYPE_TIMESTAMP;
  }

  /**
   * Returns the descriptor for the {@code DATE} type: a timezone independent date in the range
   * [0001-01-01, 9999-12-31).
   */
  public static Type date() {
    return TYPE_DATE;
  }

  /** Returns the descriptor for the {@code UUID} type. */
  public static Type uuid() {
    return TYPE_UUID;
  }

  /**
   * Returns the descriptor for the {@code INTERVAL} type: an interval which represents a time
   * duration as a tuple of 3 values (months, days, nanoseconds). [Interval(months:-120000, days:
   * -3660000, nanoseconds: -316224000000000000000), Interval(months:120000, days: 3660000,
   * nanoseconds: 316224000000000000000)].
   */
  public static Type interval() {
    return TYPE_INTERVAL;
  }

  /** Returns a descriptor for an array of {@code elementType}. */
  public static Type array(Type elementType) {
    Preconditions.checkNotNull(elementType);
    switch (elementType.getCode()) {
      case BOOL:
        return TYPE_ARRAY_BOOL;
      case INT64:
        return TYPE_ARRAY_INT64;
      case FLOAT32:
        return TYPE_ARRAY_FLOAT32;
      case FLOAT64:
        return TYPE_ARRAY_FLOAT64;
      case NUMERIC:
        return TYPE_ARRAY_NUMERIC;
      case PG_NUMERIC:
        return TYPE_ARRAY_PG_NUMERIC;
      case STRING:
        return TYPE_ARRAY_STRING;
      case JSON:
        return TYPE_ARRAY_JSON;
      case PG_JSONB:
        return TYPE_ARRAY_PG_JSONB;
      case PG_OID:
        return TYPE_ARRAY_PG_OID;
      case BYTES:
        return TYPE_ARRAY_BYTES;
      case TIMESTAMP:
        return TYPE_ARRAY_TIMESTAMP;
      case DATE:
        return TYPE_ARRAY_DATE;
      case UUID:
        return TYPE_ARRAY_UUID;
      case INTERVAL:
        return TYPE_ARRAY_INTERVAL;
      default:
        return new Type(Code.ARRAY, elementType, null);
    }
  }

  /**
   * Returns a descriptor for a {@code STRUCT} type: an ordered collection of named and typed
   * fields.
   */
  public static Type struct(Iterable<StructField> fields) {
    return new Type(Code.STRUCT, null, ImmutableList.copyOf(fields));
  }

  /**
   * Returns a descriptor for a {@code STRUCT} type: an ordered collection of named and typed
   * fields.
   */
  public static Type struct(StructField... fields) {
    return new Type(Code.STRUCT, null, ImmutableList.copyOf(fields));
  }

  private final com.google.spanner.v1.Type proto;
  private final Code code;
  private final Type arrayElementType;
  private final ImmutableList<StructField> structFields;
  private String protoTypeFqn;

  /**
   * Map of field name to field index. Ambiguous names are indexed to {@link #AMBIGUOUS_FIELD}. The
   * map is lazily initialized with a benign race.
   */
  private Map<String, Integer> fieldsByName;

  private Type(
      @Nonnull Code code,
      @Nullable Type arrayElementType,
      @Nullable ImmutableList<StructField> structFields) {
    this(null, Preconditions.checkNotNull(code), arrayElementType, structFields);
  }

  private Type(@Nonnull com.google.spanner.v1.Type proto) {
    this(
        Preconditions.checkNotNull(proto),
        Code.UNRECOGNIZED,
        proto.hasArrayElementType() ? new Type(proto.getArrayElementType()) : null,
        null);
  }

  private Type(
      com.google.spanner.v1.Type proto,
      Code code,
      Type arrayElementType,
      ImmutableList<StructField> structFields) {
    this.proto = proto;
    this.code = code;
    this.arrayElementType = arrayElementType;
    this.structFields = structFields;
  }

  private Type(Code code, @Nonnull String protoTypeFqn) {
    this(code, null, null);
    this.protoTypeFqn = protoTypeFqn;
  }

  /** Enumerates the categories of types. */
  public enum Code {
    UNRECOGNIZED(TypeCode.UNRECOGNIZED, "unknown"),
    BOOL(TypeCode.BOOL, "boolean"),
    INT64(TypeCode.INT64, "bigint"),
    NUMERIC(TypeCode.NUMERIC, "unknown"),
    PG_NUMERIC(TypeCode.NUMERIC, "numeric", TypeAnnotationCode.PG_NUMERIC),
    FLOAT64(TypeCode.FLOAT64, "double precision"),
    FLOAT32(TypeCode.FLOAT32, "real"),
    STRING(TypeCode.STRING, "character varying"),
    JSON(TypeCode.JSON, "unknown"),
    PG_JSONB(TypeCode.JSON, "jsonb", TypeAnnotationCode.PG_JSONB),
    PG_OID(TypeCode.INT64, "oid", TypeAnnotationCode.PG_OID),
    PROTO(TypeCode.PROTO, "proto"),
    ENUM(TypeCode.ENUM, "enum"),
    BYTES(TypeCode.BYTES, "bytea"),
    TIMESTAMP(TypeCode.TIMESTAMP, "timestamp with time zone"),
    DATE(TypeCode.DATE, "date"),
    UUID(TypeCode.UUID, "uuid"),
    INTERVAL(TypeCode.INTERVAL, "interval"),
    ARRAY(TypeCode.ARRAY, "array"),
    STRUCT(TypeCode.STRUCT, "struct");

    private static final Map<Entry<TypeCode, TypeAnnotationCode>, Code> protoToCode;

    static {
      ImmutableMap.Builder<Entry<TypeCode, TypeAnnotationCode>, Code> builder =
          ImmutableMap.builder();
      for (Code code : Code.values()) {
        builder.put(new SimpleEntry<>(code.getTypeCode(), code.getTypeAnnotationCode()), code);
      }
      protoToCode = builder.build();
    }

    private final String postgreSQLName;
    private final TypeCode typeCode;
    private final TypeAnnotationCode typeAnnotationCode;

    Code(TypeCode typeCode, String postgreSQLName) {
      this(typeCode, postgreSQLName, TYPE_ANNOTATION_CODE_UNSPECIFIED);
    }

    Code(TypeCode typeCode, String postgreSQLName, TypeAnnotationCode typeAnnotationCode) {
      this.typeCode = typeCode;
      this.postgreSQLName = postgreSQLName;
      this.typeAnnotationCode = typeAnnotationCode;
    }

    TypeCode getTypeCode() {
      return typeCode;
    }

    TypeAnnotationCode getTypeAnnotationCode() {
      return typeAnnotationCode;
    }

    static Code fromProto(TypeCode typeCode, TypeAnnotationCode typeAnnotationCode) {
      Code code = protoToCode.get(new SimpleEntry<>(typeCode, typeAnnotationCode));
      return code == null ? Code.UNRECOGNIZED : code;
    }

    @Override
    public String toString() {
      if (typeAnnotationCode == TYPE_ANNOTATION_CODE_UNSPECIFIED) {
        return typeCode.toString();
      } else {
        return typeCode.toString() + "<" + typeAnnotationCode.toString() + ">";
      }
    }

    private String getGoogleSQLName() {
      return name();
    }

    private String getPostgreSQLName() {
      return postgreSQLName;
    }
  }

  /** Describes an individual field in a {@code STRUCT type}. */
  public static final class StructField implements Serializable {
    private static final long serialVersionUID = 8640511292704408210L;

    private final String name;
    private final Type type;

    public static StructField of(String name, Type type) {
      return new StructField(name, type);
    }

    private StructField(String name, Type type) {
      this.name = Preconditions.checkNotNull(name);
      this.type = Preconditions.checkNotNull(type);
    }

    public String getName() {
      return name;
    }

    public Type getType() {
      return type;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      StructField that = (StructField) o;
      return name.equals(that.name) && type.equals(that.type);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, type);
    }
  }

  /** Returns the type code corresponding to this type. */
  public Code getCode() {
    return code;
  }

  /**
   * Returns the type descriptor for elements of this {@code ARRAY} type.
   *
   * @throws IllegalStateException if {@code code() != Code.ARRAY}
   */
  public Type getArrayElementType() {
    Preconditions.checkState(arrayElementType != null, "Illegal call for non-ARRAY type");
    return arrayElementType;
  }

  /**
   * Returns the fields of this {@code STRUCT} type.
   *
   * @return an immutable list of the fields
   * @throws IllegalStateException if {@code code() != Code.STRUCT}
   */
  public List<StructField> getStructFields() {
    Preconditions.checkState(code == Code.STRUCT, "Illegal call for non-STRUCT type");
    return structFields;
  }

  /**
   * Returns the full package name for elements of this {@code Proto or @code Enum} type.
   *
   * @throws IllegalStateException if {@code code() != Code.PROTO or code() != Code.ENUM}
   */
  public String getProtoTypeFqn() {
    Preconditions.checkState(
        (code == Code.PROTO || code == Code.ENUM), "Illegal call for non-Proto type");
    return protoTypeFqn;
  }

  /**
   * Returns the index of the field named {@code fieldName} in this {@code STRUCT} type.
   *
   * @throws IllegalArgumentException if there is not exactly one element of {@link
   *     #getStructFields()} with {@link StructField#getName()} equal to {@code fieldName}
   * @throws IllegalStateException if {@code code() != Code.STRUCT}
   */
  public int getFieldIndex(String fieldName) {
    Preconditions.checkState(code == Code.STRUCT, "Illegal call for non-STRUCT type");

    if (fieldsByName == null) {
      Map<String, Integer> tmp = new TreeMap<>();
      for (int i = 0; i < getStructFields().size(); ++i) {
        Type.StructField field = getStructFields().get(i);
        if (tmp.put(field.getName(), i) != null) {
          // Column name appears more than once: mark as ambiguous.
          tmp.put(field.getName(), AMBIGUOUS_FIELD);
        }
      }
      // Benign race: Java's final field semantics mean that if we see a non-null "fieldsByName",
      // we are guaranteed to see it in a fully initialized state.  It is thus important that we
      // use an ImmutableMap here, which necessarily uses final fields or equivalent reasoning.
      // Since all computations of "fieldsByName" produce the same value, there is no risk of
      // inconsistency.
      fieldsByName = ImmutableMap.copyOf(tmp);
    }

    Integer index = fieldsByName.get(fieldName);
    if (index == null) {
      throw new IllegalArgumentException("Field not found: " + fieldName);
    }
    if (index == AMBIGUOUS_FIELD) {
      throw new IllegalArgumentException("Ambiguous field name: " + fieldName);
    }
    return index;
  }

  void toString(StringBuilder b) {
    if (code == Code.ARRAY || (proto != null && proto.hasArrayElementType())) {
      if (code == Code.ARRAY) {
        b.append("ARRAY<");
      } else {
        // This is very unlikely to happen. It would mean that we have introduced a type that
        // is not an ARRAY, but does have an array element type.
        b.append("UNRECOGNIZED<");
      }
      arrayElementType.toString(b);
      b.append('>');
    } else if (code == Code.STRUCT) {
      b.append("STRUCT<");
      for (int i = 0; i < structFields.size(); ++i) {
        if (i > 0) {
          b.append(", ");
        }
        StructField f = structFields.get(i);
        b.append(f.getName()).append(' ');
        f.getType().toString(b);
      }
      b.append('>');
    } else if (proto != null) {
      b.append(proto.getCode().name());
      if (proto.getTypeAnnotation() != TYPE_ANNOTATION_CODE_UNSPECIFIED) {
        b.append("<").append(proto.getTypeAnnotation().name()).append(">");
      }
    } else {
      b.append(code.toString());
    }
  }

  @Override
  public String toString() {
    StringBuilder b = new StringBuilder();
    toString(b);
    return b.toString();
  }

  /** Returns the type name as used by the database in the given dialect. */
  public String getSpannerTypeName(Dialect dialect) {
    switch (dialect) {
      case POSTGRESQL:
        return getTypeNamePostgreSQL();
      case GOOGLE_STANDARD_SQL:
      default:
        return getTypeNameGoogleSQL();
    }
  }

  private String getTypeNameGoogleSQL() {
    if (code == Code.ARRAY) {
      return code.getGoogleSQLName() + "<" + arrayElementType.getTypeNameGoogleSQL() + ">";
    }
    return code.getGoogleSQLName();
  }

  private String getTypeNamePostgreSQL() {
    if (code == Code.ARRAY) {
      return arrayElementType.getTypeNamePostgreSQL() + "[]";
    }
    return code.getPostgreSQLName();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Type that = (Type) o;
    if (proto != null) {
      return Objects.equals(proto, that.proto);
    }
    return code == that.code
        && Objects.equals(arrayElementType, that.arrayElementType)
        && Objects.equals(structFields, that.structFields)
        && Objects.equals(protoTypeFqn, that.protoTypeFqn);
  }

  @Override
  public int hashCode() {
    if (proto != null) {
      return proto.hashCode();
    }
    return Objects.hash(code, arrayElementType, structFields);
  }

  com.google.spanner.v1.Type toProto() {
    if (proto != null) {
      return proto;
    }
    com.google.spanner.v1.Type.Builder proto = com.google.spanner.v1.Type.newBuilder();
    proto.setCode(code.getTypeCode());
    proto.setTypeAnnotation(code.getTypeAnnotationCode());
    if (code == Code.ARRAY) {
      proto.setArrayElementType(arrayElementType.toProto());
    } else if (code == Code.STRUCT) {
      com.google.spanner.v1.StructType.Builder fields = proto.getStructTypeBuilder();
      for (StructField field : structFields) {
        fields.addFieldsBuilder().setName(field.getName()).setType(field.getType().toProto());
      }
    } else if (code == Code.PROTO || code == Code.ENUM) {
      proto.setProtoTypeFqn(protoTypeFqn);
    }

    return proto.build();
  }

  static Type fromProto(com.google.spanner.v1.Type proto) {
    Code type = Code.fromProto(proto.getCode(), proto.getTypeAnnotation());
    switch (type) {
      case BOOL:
        return bool();
      case INT64:
        return int64();
      case FLOAT32:
        return float32();
      case FLOAT64:
        return float64();
      case NUMERIC:
        return numeric();
      case PG_NUMERIC:
        return pgNumeric();
      case STRING:
        return string();
      case JSON:
        return json();
      case PG_JSONB:
        return pgJsonb();
      case PG_OID:
        return pgOid();
      case BYTES:
        return bytes();
      case TIMESTAMP:
        return timestamp();
      case DATE:
        return date();
      case UUID:
        return uuid();
      case INTERVAL:
        return interval();
      case PROTO:
        return proto(proto.getProtoTypeFqn());
      case ENUM:
        return protoEnum(proto.getProtoTypeFqn());
      case ARRAY:
        checkArgument(
            proto.hasArrayElementType(),
            "Missing expected 'array_element_type' field in 'Type' message: %s",
            proto);
        Type elementType;
        try {
          elementType = fromProto(proto.getArrayElementType());
        } catch (IllegalArgumentException e) {
          throw new IllegalArgumentException(
              "Could not parse 'array_element_type' attribute in 'Type' message: " + proto, e);
        }
        return array(elementType);
      case STRUCT:
        checkArgument(
            proto.hasStructType(),
            "Missing expected 'struct_type' field in 'Type' message: %s",
            proto);
        List<StructField> fields = new ArrayList<>(proto.getStructType().getFieldsCount());
        for (com.google.spanner.v1.StructType.Field field : proto.getStructType().getFieldsList()) {
          checkArgument(field.hasType(), "Missing expected 'type' attribute in 'Field': %s", proto);
          // Names may be empty; for example, the name of the column returned by "SELECT 1".
          String name = Strings.nullToEmpty(field.getName());
          fields.add(StructField.of(name, fromProto(field.getType())));
        }
        return struct(fields);
      case UNRECOGNIZED:
      default:
        return unrecognized(proto);
    }
  }
}
