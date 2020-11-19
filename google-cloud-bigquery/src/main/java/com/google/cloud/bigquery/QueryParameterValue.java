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

package com.google.cloud.bigquery;

import static org.threeten.bp.temporal.ChronoField.HOUR_OF_DAY;
import static org.threeten.bp.temporal.ChronoField.MINUTE_OF_HOUR;
import static org.threeten.bp.temporal.ChronoField.NANO_OF_SECOND;
import static org.threeten.bp.temporal.ChronoField.SECOND_OF_MINUTE;

import com.google.api.services.bigquery.model.QueryParameterType;
import com.google.auto.value.AutoValue;
import com.google.cloud.Timestamp;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.io.BaseEncoding;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.DateTimeParseException;

/**
 * A value for a QueryParameter along with its type.
 *
 * <p>A static factory method is provided for each of the possible types (e.g. {@link #int64(Long)}
 * for StandardSQLTypeName.INT64). Alternatively, an instance can be constructed by calling {@link
 * #of(Object, Class)} with the value and a Class object, which will use these mappings:
 *
 * <p>
 *
 * <ul>
 *   <li>Boolean: StandardSQLTypeName.BOOL
 *   <li>String: StandardSQLTypeName.STRING
 *   <li>Integer: StandardSQLTypeName.INT64
 *   <li>Long: StandardSQLTypeName.INT64
 *   <li>Double: StandardSQLTypeName.FLOAT64
 *   <li>Float: StandardSQLTypeName.FLOAT64
 *   <li>BigDecimal: StandardSQLTypeName.NUMERIC
 *   <li>BigNumeric: StandardSQLTypeName.BIGNUMERIC
 * </ul>
 *
 * <p>No other types are supported through that entry point. The other types can be created by
 * calling {@link #of(Object, StandardSQLTypeName)} with the value and a particular
 * StandardSQLTypeName enum value.
 *
 * <p>Struct parameters are currently not supported.
 */
@AutoValue
public abstract class QueryParameterValue implements Serializable {

  private static final DateTimeFormatter timestampFormatter =
      new DateTimeFormatterBuilder()
          .parseLenient()
          .append(DateTimeFormatter.ISO_LOCAL_DATE)
          .appendLiteral(' ')
          .appendValue(HOUR_OF_DAY, 2)
          .appendLiteral(':')
          .appendValue(MINUTE_OF_HOUR, 2)
          .optionalStart()
          .appendLiteral(':')
          .appendValue(SECOND_OF_MINUTE, 2)
          .optionalStart()
          .appendFraction(NANO_OF_SECOND, 6, 9, true)
          .optionalStart()
          .appendOffset("+HHMM", "+00:00")
          .optionalEnd()
          .toFormatter()
          .withZone(ZoneOffset.UTC);
  private static final DateTimeFormatter timestampValidator =
      new DateTimeFormatterBuilder()
          .parseLenient()
          .append(timestampFormatter)
          .optionalStart()
          .appendOffsetId()
          .optionalEnd()
          .toFormatter()
          .withZone(ZoneOffset.UTC);
  private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  private static final DateTimeFormatter timeFormatter =
      DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS");
  private static final DateTimeFormatter datetimeFormatter =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");

  static final Function<
          QueryParameterValue, com.google.api.services.bigquery.model.QueryParameterValue>
      TO_VALUE_PB_FUNCTION =
          new Function<
              QueryParameterValue, com.google.api.services.bigquery.model.QueryParameterValue>() {
            @Override
            public com.google.api.services.bigquery.model.QueryParameterValue apply(
                QueryParameterValue value) {
              return value.toValuePb();
            }
          };
  private static final long serialVersionUID = -5620695863123562896L;

  @AutoValue.Builder
  public abstract static class Builder {

    /** Sets the value to the given scalar value. */
    public abstract Builder setValue(String value);

    /** Sets array values. The type must set to ARRAY. */
    public Builder setArrayValues(List<QueryParameterValue> arrayValues) {
      return setArrayValuesInner(ImmutableList.copyOf(arrayValues));
    }

    abstract Builder setArrayValuesInner(ImmutableList<QueryParameterValue> arrayValues);

    /** Sets struct values. The type must set to STRUCT. */
    public Builder setStructValues(Map<String, QueryParameterValue> structValues) {
      setStructTypes(ImmutableMap.copyOf(structValues));
      return setStructValuesInner(ImmutableMap.copyOf(structValues));
    }

    abstract Builder setStructValuesInner(Map<String, QueryParameterValue> structValues);

    /** Sets the parameter data type. */
    public abstract Builder setType(StandardSQLTypeName type);

    /** Sets the data type of the array elements. The type must set to ARRAY. */
    public abstract Builder setArrayType(StandardSQLTypeName arrayType);

    /** Sets the data type of the struct elements. The type must set to STRUCT. */
    public Builder setStructTypes(Map<String, QueryParameterValue> structTypes) {
      return setStructTypesInner(structTypes);
    }

    abstract Builder setStructTypesInner(Map<String, QueryParameterValue> structTypes);

    /** Creates a {@code QueryParameterValue} object. */
    public abstract QueryParameterValue build();
  }

  QueryParameterValue() {
    // Package-private so it's extensible by AutoValue but not users.
  }

  /** Returns the value of this parameter. */
  @Nullable
  public abstract String getValue();

  /** Returns the array values of this parameter. The returned list, if not null, is immutable. */
  @Nullable
  public List<QueryParameterValue> getArrayValues() {
    return getArrayValuesInner();
  }

  @Nullable
  abstract ImmutableList<QueryParameterValue> getArrayValuesInner();

  /** Returns the struct values of this parameter. The returned map, if not null, is immutable. */
  @Nullable
  public Map<String, QueryParameterValue> getStructValues() {
    return getStructValuesInner();
  }

  @Nullable
  abstract Map<String, QueryParameterValue> getStructValuesInner();

  /** Returns the data type of this parameter. */
  public abstract StandardSQLTypeName getType();

  /** Returns the data type of the array elements. */
  @Nullable
  public abstract StandardSQLTypeName getArrayType();

  /** Returns the data type of the struct elements. */
  @Nullable
  public Map<String, QueryParameterValue> getStructTypes() {
    return getStructTypesInner();
  }

  @Nullable
  abstract Map<String, QueryParameterValue> getStructTypesInner();

  /**
   * Creates a {@code QueryParameterValue} object with the given value and type. Note: this does not
   * support BigNumeric
   */
  public static <T> QueryParameterValue of(T value, Class<T> type) {
    return of(value, classToType(type));
  }

  /** Creates a {@code QueryParameterValue} object with the given value and type. */
  public static <T> QueryParameterValue of(T value, StandardSQLTypeName type) {
    return QueryParameterValue.newBuilder()
        .setValue(valueToStringOrNull(value, type))
        .setType(type)
        .build();
  }

  /** Creates a {@code QueryParameterValue} object with a type of BOOL. */
  public static QueryParameterValue bool(Boolean value) {
    return of(value, StandardSQLTypeName.BOOL);
  }

  /** Creates a {@code QueryParameterValue} object with a type of INT64. */
  public static QueryParameterValue int64(Long value) {
    return of(value, StandardSQLTypeName.INT64);
  }

  /** Creates a {@code QueryParameterValue} object with a type of INT64. */
  public static QueryParameterValue int64(Integer value) {
    return of(value, StandardSQLTypeName.INT64);
  }

  /** Creates a {@code QueryParameterValue} object with a type of FLOAT64. */
  public static QueryParameterValue float64(Double value) {
    return of(value, StandardSQLTypeName.FLOAT64);
  }

  /** Creates a {@code QueryParameterValue} object with a type of FLOAT64. */
  public static QueryParameterValue float64(Float value) {
    return of(value, StandardSQLTypeName.FLOAT64);
  }

  /** Creates a {@code QueryParameterValue} object with a type of NUMERIC. */
  public static QueryParameterValue numeric(BigDecimal value) {
    return of(value, StandardSQLTypeName.NUMERIC);
  }

  /** Creates a {@code QueryParameterValue} object with a type of BIGNUMERIC. */
  public static QueryParameterValue bigNumeric(BigDecimal value) {
    return of(value, StandardSQLTypeName.BIGNUMERIC);
  }

  /** Creates a {@code QueryParameterValue} object with a type of STRING. */
  public static QueryParameterValue string(String value) {
    return of(value, StandardSQLTypeName.STRING);
  }

  /** Creates a {@code QueryParameterValue} object with a type of BYTES. */
  public static QueryParameterValue bytes(byte[] value) {
    return of(value, StandardSQLTypeName.BYTES);
  }

  /** Creates a {@code QueryParameterValue} object with a type of TIMESTAMP. */
  public static QueryParameterValue timestamp(Long value) {
    return of(value, StandardSQLTypeName.TIMESTAMP);
  }

  /**
   * Creates a {@code QueryParameterValue} object with a type of TIMESTAMP. Must be in the format
   * "yyyy-MM-dd HH:mm:ss.SSSSSSZZ", e.g. "2014-08-19 12:41:35.220000+00:00".
   */
  public static QueryParameterValue timestamp(String value) {
    return of(value, StandardSQLTypeName.TIMESTAMP);
  }

  /**
   * Creates a {@code QueryParameterValue} object with a type of DATE. Must be in the format
   * "yyyy-MM-dd", e.g. "2014-08-19".
   */
  public static QueryParameterValue date(String value) {
    return of(value, StandardSQLTypeName.DATE);
  }

  /**
   * Creates a {@code QueryParameterValue} object with a type of TIME. Must be in the format
   * "HH:mm:ss.SSSSSS", e.g. "12:41:35.220000".
   */
  public static QueryParameterValue time(String value) {
    return of(value, StandardSQLTypeName.TIME);
  }

  /**
   * Creates a {@code QueryParameterValue} object with a type of DATETIME. Must be in the format
   * "yyyy-MM-dd HH:mm:ss.SSSSSS", e.g. ""2014-08-19 12:41:35.220000".
   */
  public static QueryParameterValue dateTime(String value) {
    return of(value, StandardSQLTypeName.DATETIME);
  }

  /**
   * Creates a {@code QueryParameterValue} object with a type of ARRAY, and an array element type
   * based on the given class.
   */
  public static <T> QueryParameterValue array(T[] array, Class<T> clazz) {
    return array(array, classToType(clazz));
  }

  /**
   * Creates a {@code QueryParameterValue} object with a type of ARRAY the given array element type.
   */
  public static <T> QueryParameterValue array(T[] array, StandardSQLTypeName type) {
    List<QueryParameterValue> listValues = new ArrayList<>();
    for (T obj : array) {
      listValues.add(QueryParameterValue.of(obj, type));
    }
    return QueryParameterValue.newBuilder()
        .setArrayValues(listValues)
        .setType(StandardSQLTypeName.ARRAY)
        .setArrayType(type)
        .build();
  }

  /**
   * Creates a map with {@code QueryParameterValue} object and a type of STRUCT the given struct
   * element type.
   */
  public static QueryParameterValue struct(Map<String, QueryParameterValue> struct) {
    return QueryParameterValue.newBuilder()
        .setStructValues(struct)
        .setType(StandardSQLTypeName.STRUCT)
        .build();
  }

  private static <T> StandardSQLTypeName classToType(Class<T> type) {
    if (Boolean.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.BOOL;
    } else if (String.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.STRING;
    } else if (Integer.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.INT64;
    } else if (Long.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.INT64;
    } else if (Double.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.FLOAT64;
    } else if (Float.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.FLOAT64;
    } else if (BigDecimal.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.NUMERIC;
    } else if (Date.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.DATE;
    }
    throw new IllegalArgumentException("Unsupported object type for QueryParameter: " + type);
  }

  private static <T> String valueToStringOrNull(T value, StandardSQLTypeName type) {
    if (value == null) {
      return null;
    }
    switch (type) {
      case BOOL:
        if (value instanceof Boolean) {
          return value.toString();
        }
        break;
      case INT64:
        if (value instanceof Integer || value instanceof Long) {
          return value.toString();
        }
        break;
      case FLOAT64:
        if (value instanceof Double || value instanceof Float) {
          return value.toString();
        }
        break;
      case NUMERIC:
      case BIGNUMERIC:
        if (value instanceof BigDecimal) {
          return value.toString();
        }
        break;
      case BYTES:
        if (value instanceof byte[]) {
          return BaseEncoding.base64().encode((byte[]) value);
        }
        break;
      case STRING:
        return value.toString();
      case STRUCT:
        throw new IllegalArgumentException("Cannot convert STRUCT to String value");
      case ARRAY:
        throw new IllegalArgumentException("Cannot convert ARRAY to String value");
      case TIMESTAMP:
        if (value instanceof Long) {
          Timestamp timestamp = Timestamp.ofTimeMicroseconds((Long) value);
          return timestampFormatter.format(
              Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos()));
        } else if (value instanceof String) {
          // verify that the String is in the right format
          checkFormat(value, timestampValidator);
          return (String) value;
        }
        break;
      case DATE:
        if (value instanceof String) {
          // verify that the String is in the right format
          checkFormat(value, dateFormatter);
          return (String) value;
        } else if (value instanceof Date) {
          com.google.cloud.Date date = com.google.cloud.Date.fromJavaUtilDate((Date) value);
          return date.toString();
        }
        break;
      case TIME:
        if (value instanceof String) {
          // verify that the String is in the right format
          checkFormat(value, timeFormatter);
          return (String) value;
        }
        break;
      case DATETIME:
        if (value instanceof String) {
          // verify that the String is in the right format
          checkFormat(value, datetimeFormatter);
          return (String) value;
        }
        break;
      default:
        throw new UnsupportedOperationException("Implementation error - Unsupported type: " + type);
    }
    throw new IllegalArgumentException(
        "Type " + type + " incompatible with " + value.getClass().getCanonicalName());
  }

  private static void checkFormat(Object value, DateTimeFormatter formatter) {
    try {

      formatter.parse((String) value);
    } catch (DateTimeParseException e) {
      throw new IllegalArgumentException(e.getMessage(), e);
    }
  }

  /** Returns a builder for a QueryParameterValue object with given value. */
  public abstract Builder toBuilder();

  /** Returns a builder for the {@code QueryParameterValue} object. */
  public static Builder newBuilder() {
    return new AutoValue_QueryParameterValue.Builder();
  }

  com.google.api.services.bigquery.model.QueryParameterValue toValuePb() {
    com.google.api.services.bigquery.model.QueryParameterValue valuePb =
        new com.google.api.services.bigquery.model.QueryParameterValue();
    valuePb.setValue(getValue());
    if (getArrayValues() != null) {
      valuePb.setArrayValues(
          Lists.transform(getArrayValues(), QueryParameterValue.TO_VALUE_PB_FUNCTION));
    }
    if (getStructValues() != null) {
      Map<String, com.google.api.services.bigquery.model.QueryParameterValue> structValues =
          new HashMap<>();
      for (Map.Entry<String, QueryParameterValue> structValue : getStructValues().entrySet()) {
        structValues.put(structValue.getKey(), structValue.getValue().toValuePb());
      }
      valuePb.setStructValues(structValues);
    }
    return valuePb;
  }

  QueryParameterType toTypePb() {
    QueryParameterType typePb = new QueryParameterType();
    typePb.setType(getType().toString());
    if (getArrayType() != null) {
      QueryParameterType arrayTypePb = new QueryParameterType();
      arrayTypePb.setType(getArrayType().toString());
      typePb.setArrayType(arrayTypePb);
    }
    if (getStructTypes() != null) {
      List<QueryParameterType.StructTypes> structTypes = new ArrayList<>();
      for (Map.Entry<String, QueryParameterValue> entry : getStructTypes().entrySet()) {
        QueryParameterType.StructTypes structType = new QueryParameterType.StructTypes();
        structType.setName(entry.getKey());
        structType.setType(entry.getValue().toTypePb());
        structTypes.add(structType);
      }
      typePb.setStructTypes(structTypes);
    }
    return typePb;
  }

  static QueryParameterValue fromPb(
      com.google.api.services.bigquery.model.QueryParameterValue valuePb,
      QueryParameterType typePb) {
    Builder valueBuilder = newBuilder();
    Map<String, QueryParameterType> parameterTypes = new HashMap<>();
    StandardSQLTypeName type = StandardSQLTypeName.valueOf(typePb.getType());
    valueBuilder.setType(type);
    if (type == StandardSQLTypeName.ARRAY) {
      valueBuilder.setArrayType(StandardSQLTypeName.valueOf(typePb.getArrayType().getType()));
      if (valuePb == null || valuePb.getArrayValues() == null) {
        valueBuilder.setArrayValues(ImmutableList.<QueryParameterValue>of());
      } else {
        ImmutableList.Builder<QueryParameterValue> arrayValues = ImmutableList.builder();
        for (com.google.api.services.bigquery.model.QueryParameterValue elementValuePb :
            valuePb.getArrayValues()) {
          arrayValues.add(fromPb(elementValuePb, typePb.getArrayType()));
        }
        valueBuilder.setArrayValues(arrayValues.build());
      }
    } else if (type == StandardSQLTypeName.STRUCT) {
      Map<String, QueryParameterValue> structTypes = new HashMap<>();
      for (QueryParameterType.StructTypes types : typePb.getStructTypes()) {
        structTypes.put(
            types.getName(),
            QueryParameterValue.newBuilder()
                .setType(StandardSQLTypeName.valueOf(types.getType().getType()))
                .build());
      }
      valueBuilder.setStructTypes(structTypes);
      if (valuePb == null || valuePb.getStructValues() == null) {
        valueBuilder.setStructValues(ImmutableMap.<String, QueryParameterValue>of());
      } else {
        Map<String, QueryParameterValue> structValues = new HashMap<>();
        for (QueryParameterType.StructTypes structType : typePb.getStructTypes()) {
          parameterTypes.put(structType.getName(), structType.getType());
        }
        for (Map.Entry<String, com.google.api.services.bigquery.model.QueryParameterValue>
            structValue : valuePb.getStructValues().entrySet()) {
          structValues.put(
              structValue.getKey(),
              QueryParameterValue.fromPb(
                  structValue.getValue(), parameterTypes.get(structValue.getKey())));
        }
        valueBuilder.setStructValues(structValues);
      }
    } else {
      valueBuilder.setValue(valuePb == null ? "" : valuePb.getValue());
    }
    return valueBuilder.build();
  }
}
