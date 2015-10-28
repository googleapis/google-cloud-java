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

package com.google.gcloud.datastore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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

  private static final Key KEY = Key.builder("ds", "kind", 1).build();
  private static final Blob BLOB = Blob.copyFrom(new byte[]{});
  private static final DateTime DATE_TIME = DateTime.now();
  private static final Entity ENTITY = Entity.builder(KEY).set("FOO", "BAR").build();
  private static final NullValue NULL_VALUE = NullValue.of();
  private static final StringValue STRING_VALUE = StringValue.of("hello");
  private static final RawValue RAW_VALUE = RawValue.of(STRING_VALUE.toPb());
  private static final ImmutableMap<ValueType, Object[]> TYPES =
      ImmutableMap.<ValueType, Object[]>builder()
      .put(ValueType.NULL, new Object[] {NullValue.class, NULL_VALUE.get()})
      .put(ValueType.KEY, new Object[] {KeyValue.class, KEY})
      .put(ValueType.BLOB, new Object[] {BlobValue.class, BLOB})
      .put(ValueType.BOOLEAN, new Object[] {BooleanValue.class, Boolean.TRUE})
      .put(ValueType.DATE_TIME, new Object[] {DateTimeValue.class, DATE_TIME})
      .put(ValueType.DOUBLE, new Object[] {DoubleValue.class, 1.25D})
      .put(ValueType.ENTITY, new Object[] {EntityValue.class, ENTITY})
      .put(ValueType.LIST,
          new Object[] {ListValue.class, ImmutableList.of(NULL_VALUE, STRING_VALUE, RAW_VALUE)})
      .put(ValueType.LONG, new Object[] {LongValue.class, 123L})
      .put(ValueType.RAW_VALUE, new Object[] {RawValue.class, RAW_VALUE.get()})
      .put(ValueType.STRING, new Object[] {StringValue.class, STRING_VALUE.get()})
      .build();

  private ImmutableMap<ValueType, Value<?>> typeToValue;

  private class TestBuilder extends Value.BaseBuilder<Set, Value<Set>, TestBuilder> {
    TestBuilder() {
      super(ValueType.LIST);
    }

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
      assertEquals(entry.getKey(), entry.getValue().type());
    }
  }

  @Test
  public void testHasIndexed() throws Exception {
    for (Map.Entry<ValueType, Value<?>> entry : typeToValue.entrySet()) {
      ValueType valueType = entry.getKey();
      Boolean indexed = entry.getValue().hasIndexed();
      switch (valueType) {
        case ENTITY:
          assertTrue(indexed);
          break;
        default:
          assertFalse(indexed);
          break;
      }
    }

    TestBuilder builder = new TestBuilder();
    assertFalse(builder.build().hasIndexed());
    assertTrue(builder.indexed(false).build().hasIndexed());
    assertTrue(builder.indexed(true).build().hasIndexed());
  }

  @Test
  public void testIndexed() throws Exception {
    for (Map.Entry<ValueType, Value<?>> entry : typeToValue.entrySet()) {
      ValueType valueType = entry.getKey();
      Boolean indexed = entry.getValue().indexed();
      switch (valueType) {
        case ENTITY:
          assertFalse(indexed);
          break;
        default:
          assertNull(indexed);
          break;
      }
    }

    TestBuilder builder = new TestBuilder();
    assertNull(builder.build().indexed());
    assertFalse(builder.indexed(false).build().indexed());
    assertTrue(builder.indexed(true).build().indexed());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testHasMeaning() throws Exception {
    for (Value<?> value : typeToValue.values()) {
      assertFalse(value.hasMeaning());
    }

    TestBuilder builder = new TestBuilder();
    assertTrue(builder.meaning(10).build().hasMeaning());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testMeaning() throws Exception {
    for (Value<?> value : typeToValue.values()) {
      assertNull(value.meaning());
    }

    TestBuilder builder = new TestBuilder();
    assertEquals(Integer.valueOf(10), builder.meaning(10).build().meaning());
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
    ValueBuilder builder = new TestBuilder();
    builder.meaning(1).set(content).indexed(true);
    Value<?> value = builder.build();
    builder = value.toBuilder();
    assertEquals(Integer.valueOf(1), value.meaning());
    assertTrue(value.hasIndexed());
    assertTrue(value.indexed());
    assertEquals(ValueType.LIST, value.type());
    assertEquals(content, value.get());
    assertEquals(value, builder.build());
  }
}
