/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.cloud.datastore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.cloud.Timestamp;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Primitives;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class ValueTest {

  private static final Key KEY = Key.newBuilder("ds", "kind", 1).build();
  private static final Blob BLOB = Blob.copyFrom(new byte[]{});
  private static final Timestamp TIMESTAMP = Timestamp.now();
  private static final Entity ENTITY = Entity.newBuilder(KEY).set("FOO", "BAR").build();
  private static final NullValue NULL_VALUE = NullValue.of();
  private static final StringValue STRING_VALUE = StringValue.of("hello");
  private static final RawValue RAW_VALUE = RawValue.of(STRING_VALUE.toPb());
  private static final LatLngValue LAT_LNG_VALUE =
      LatLngValue.of(new LatLng(37.422035, -122.084124));
  private static final ImmutableMap<ValueType, Object[]> TYPES =
      ImmutableMap.<ValueType, Object[]>builder()
          .put(ValueType.NULL, new Object[] {NullValue.class, NULL_VALUE.get()})
          .put(ValueType.KEY, new Object[] {KeyValue.class, KEY})
          .put(ValueType.BLOB, new Object[] {BlobValue.class, BLOB})
          .put(ValueType.BOOLEAN, new Object[] {BooleanValue.class, Boolean.TRUE})
          .put(ValueType.TIMESTAMP, new Object[] {TimestampValue.class, TIMESTAMP})
          .put(ValueType.DOUBLE, new Object[] {DoubleValue.class, 1.25D})
          .put(ValueType.ENTITY, new Object[] {EntityValue.class, ENTITY})
          .put(ValueType.LIST, new Object[] {
              ListValue.class, ImmutableList.of(NULL_VALUE, STRING_VALUE, RAW_VALUE)})
          .put(ValueType.LONG, new Object[] {LongValue.class, 123L})
          .put(ValueType.RAW_VALUE, new Object[] {RawValue.class, RAW_VALUE.get()})
          .put(ValueType.LAT_LNG, new Object[] {LatLngValue.class, LAT_LNG_VALUE.get()})
          .put(ValueType.STRING, new Object[] {StringValue.class, STRING_VALUE.get()})
          .build();

  private ImmutableMap<ValueType, Value<?>> typeToValue;

  @SuppressWarnings("rawtypes")
  private class TestBuilder extends Value.BaseBuilder<Set, Value<Set>, TestBuilder> {
    TestBuilder() {
      super(ValueType.LIST);
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public Value<Set> build() {
      return new Value(this) {

        @Override
        public TestBuilder toBuilder() {
          return new TestBuilder().mergeFrom(this);
        }
      };
    }
  }

  @Before
  public void setUp() throws Exception {
    ImmutableMap.Builder<ValueType, Value<?>> builder = ImmutableMap.builder();
    for (ValueType valueType : ValueType.values()) {
      Object[] values = TYPES.get(valueType);
      @SuppressWarnings("unchecked")
      Class<Value<?>> valueClass = (Class<Value<?>>) values[0];
      Object value = values[1];
      if (value == null) {
        Method method = valueClass.getMethod("of");
        builder.put(valueType, (Value<?>) method.invoke(null));
      } else {
        boolean found = false;
        for (Method method : valueClass.getDeclaredMethods()) {
          if (method.getName().equals("of")) {
            Class<?> paramType = method.getParameterTypes()[0];
            if (paramType.isPrimitive()) {
              paramType = Primitives.wrap(paramType);
            }
            if (paramType.isAssignableFrom(value.getClass())) {
              builder.put(valueType, (Value<?>) method.invoke(null, value));
              found = true;
              break;
            }
          }
        }
        assertTrue("Could not find an of method for " + valueClass, found);
      }
    }
    typeToValue = builder.build();
  }

  @Test
  public void testType() throws Exception {
    for (Map.Entry<ValueType, Value<?>> entry : typeToValue.entrySet()) {
      assertEquals(entry.getKey(), entry.getValue().getType());
    }
  }


  @Test
  public void testExcludeFromIndexes() throws Exception {
    for (Map.Entry<ValueType, Value<?>> entry : typeToValue.entrySet()) {
      assertFalse(entry.getValue().excludeFromIndexes());
    }
    TestBuilder builder = new TestBuilder();
    assertFalse(builder.build().excludeFromIndexes());
    assertTrue(builder.setExcludeFromIndexes(true).build().excludeFromIndexes());
    assertFalse(builder.setExcludeFromIndexes(false).build().excludeFromIndexes());
  }


  @SuppressWarnings("deprecation")
  @Test
  public void testMeaning() throws Exception {
    TestBuilder builder = new TestBuilder();
    assertEquals(10, builder.setMeaning(10).build().getMeaning());
  }


  @Test
  public void testGet() throws Exception {
    for (Map.Entry<ValueType, Value<?>> entry : typeToValue.entrySet()) {
      ValueType valueType = entry.getKey();
      Value<?> value = entry.getValue();
      assertEquals(TYPES.get(valueType)[1], value.get());
    }

    TestBuilder builder = new TestBuilder();
    Set<String> value = Collections.singleton("bla");
    assertEquals(value, builder.set(value).build().get());
  }

  @SuppressWarnings({"unchecked", "deprecation"})
  @Test
  public void testToBuilder() throws Exception {
    Set<String> content = Collections.singleton("bla");
    @SuppressWarnings("rawtypes")
    ValueBuilder builder = new TestBuilder();
    builder.setMeaning(1).set(content).setExcludeFromIndexes(true);
    Value<?> value = builder.build();
    builder = value.toBuilder();
    assertEquals(1, value.getMeaning());
    assertTrue(value.excludeFromIndexes());
    assertEquals(ValueType.LIST, value.getType());
    assertEquals(content, value.get());
    assertEquals(value, builder.build());
  }
}
