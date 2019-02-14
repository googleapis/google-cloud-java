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

import com.google.api.client.util.Types;
import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.protobuf.ListValue;
import com.google.protobuf.NullValue;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * This class contains static utility methods that operate on or return protobuf's {@code Struct}
 * objects.
 */
final class Structs {

  private static final Function<Value, Object> VALUE_TO_OBJECT =
      new Function<Value, Object>() {
        @Override
        public Object apply(Value value) {
          return valueToObject(value);
        }
      };
  private static final Function<Object, Value> OBJECT_TO_VALUE =
      new Function<Object, Value>() {
        @Override
        public Value apply(Object obj) {
          return objectToValue(obj);
        }
      };

  private Structs() {}

  /**
   * This class wraps a protobuf's {@code Struct} object and offers a map interface to it, hiding
   * protobuf types.
   */
  private static final class StructMap extends AbstractMap<String, Object> {

    private final Set<Entry<String, Object>> entrySet;

    private StructMap(Struct struct) {
      this.entrySet = new StructSet(struct);
    }

    private static final class StructSet extends AbstractSet<Entry<String, Object>> {

      private static final Function<Map.Entry<String, Value>, Map.Entry<String, Object>>
          VALUE_TO_OBJECT =
              new Function<Map.Entry<String, Value>, Map.Entry<String, Object>>() {
                @Override
                public Map.Entry<String, Object> apply(Map.Entry<String, Value> entry) {
                  return new AbstractMap.SimpleEntry<>(
                      entry.getKey(), valueToObject(entry.getValue()));
                }
              };

      private final Struct struct;

      private StructSet(Struct struct) {
        this.struct = struct;
      }

      @Override
      public Iterator<Entry<String, Object>> iterator() {
        return Iterators.transform(struct.getFieldsMap().entrySet().iterator(), VALUE_TO_OBJECT);
      }

      @Override
      public int size() {
        return struct.getFieldsMap().size();
      }
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
      return entrySet;
    }
  }

  /** Returns an unmodifiable map view of the {@link Struct} parameter. */
  static Map<String, Object> asMap(Struct struct) {
    return new StructMap(checkNotNull(struct));
  }

  /**
   * Creates a new {@link Struct} object given the content of the provided {@code map} parameter.
   *
   * <p>Notice that all numbers (int, long, float and double) are serialized as double values. Enums
   * are serialized as strings.
   */
  static Struct newStruct(Map<String, ?> map) {
    Map<String, Value> valueMap = Maps.transformValues(checkNotNull(map), OBJECT_TO_VALUE);
    return Struct.newBuilder().putAllFields(valueMap).build();
  }

  private static Object valueToObject(Value value) {
    switch (value.getKindCase()) {
      case NULL_VALUE:
        return null;
      case NUMBER_VALUE:
        return value.getNumberValue();
      case STRING_VALUE:
        return value.getStringValue();
      case BOOL_VALUE:
        return value.getBoolValue();
      case STRUCT_VALUE:
        return new StructMap(value.getStructValue());
      case LIST_VALUE:
        return Lists.transform(value.getListValue().getValuesList(), VALUE_TO_OBJECT);
      default:
        throw new IllegalArgumentException(String.format("Unsupported protobuf value %s", value));
    }
  }

  @SuppressWarnings("unchecked")
  private static Value objectToValue(final Object obj) {
    Value.Builder builder = Value.newBuilder();
    if (obj == null) {
      builder.setNullValue(NullValue.NULL_VALUE);
      return builder.build();
    }
    Class<?> objClass = obj.getClass();
    if (obj instanceof String) {
      builder.setStringValue((String) obj);
    } else if (obj instanceof Number) {
      builder.setNumberValue(((Number) obj).doubleValue());
    } else if (obj instanceof Boolean) {
      builder.setBoolValue((Boolean) obj);
    } else if (obj instanceof Iterable<?> || objClass.isArray()) {
      builder.setListValue(
          ListValue.newBuilder()
              .addAllValues(Iterables.transform(Types.iterableOf(obj), OBJECT_TO_VALUE)));
    } else if (objClass.isEnum()) {
      builder.setStringValue(((Enum<?>) obj).name());
    } else if (obj instanceof Map) {
      Map<String, Object> map = (Map<String, Object>) obj;
      builder.setStructValue(newStruct(map));
    } else {
      throw new IllegalArgumentException(String.format("Unsupported protobuf value %s", obj));
    }
    return builder.build();
  }
}
