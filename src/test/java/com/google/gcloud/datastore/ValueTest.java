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

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Primitives;
import com.google.gcloud.datastore.Value.Type;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Map;

public class ValueTest {

  private static final Key KEY = Key.builder("ds", "kind", 1).build();
  private static final Blob BLOB = Blob.copyFrom(new byte[]{});
  private static final DateTime DATE_TIME = DateTime.now();
  private static final Entity ENTITY = Entity.builder(KEY).set("FOO", "BAR").build();
  private static final NullValue NULL_VALUE = NullValue.of();
  private static final StringValue STRING_VALUE = StringValue.of("hello");
  private static final RawValue RAW_VALUE = RawValue.of(STRING_VALUE.toPb());
  private static final ImmutableMap<Type, Object[]> TYPES = ImmutableMap.<Type, Object[]>builder()
      .put(Type.NULL, new Object[] {NullValue.class, NULL_VALUE.get()})
      .put(Type.KEY, new Object[] {KeyValue.class, KEY})
      .put(Type.BLOB, new Object[] {BlobValue.class, BLOB})
      .put(Type.BOOLEAN, new Object[] {BooleanValue.class, Boolean.TRUE})
      .put(Type.DATE_TIME, new Object[] {DateTimeValue.class, DATE_TIME})
      .put(Type.DOUBLE, new Object[] {DoubleValue.class, 1.25D})
      .put(Type.ENTITY, new Object[] {EntityValue.class, ENTITY})
      .put(Type.LIST,
          new Object[] {ListValue.class, ImmutableList.of(NULL_VALUE, STRING_VALUE, RAW_VALUE)})
      .put(Type.LONG, new Object[] {LongValue.class, 123L})
      .put(Type.RAW_VALUE, new Object[] {RawValue.class, RAW_VALUE.get()})
      .put(Type.STRING, new Object[] {StringValue.class, STRING_VALUE.get()})
      .build();

  private ImmutableMap<Type, Value<?>> typeToValue;

  @Before
  public void setUp() throws Exception {
    ImmutableMap.Builder<Type, Value<?>> builder = ImmutableMap.builder();
    for (Type type : Type.values()) {
      Object[] values = TYPES.get(type);
      Class<Value<?>> valueClass = (Class<Value<?>>) values[0];
      Object value = values[1];
      if (value == null) {
        Method method = valueClass.getMethod("of");
        builder.put(type, (Value<?>) method.invoke(null));
      } else {
        boolean found = false;
        for (Method method : valueClass.getDeclaredMethods()) {
          if (method.getName().equals("of")) {
            Class<?> paramType = method.getParameterTypes()[0];
            if (paramType.isPrimitive()) {
              paramType = Primitives.wrap(paramType);
            }
            if (paramType.isAssignableFrom(value.getClass())) {
              builder.put(type, (Value<?>) method.invoke(null, value));
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
    for (Map.Entry<Type, Value<?>> entry : typeToValue.entrySet()) {
      assertEquals(entry.getKey(), entry.getValue().type());
    }
  }

  @Test
  public void testHasIndexed() throws Exception {
    for (Map.Entry<Type, Value<?>> entry : typeToValue.entrySet()) {
      Type type = entry.getKey();
      Boolean indexed = entry.getValue().hasIndexed();
      switch (type) {
        case ENTITY:
          assertTrue(indexed);
          break;
        default:
          assertFalse(indexed);
          break;
      }
    }
  }

  @Test
  public void testIndexed() throws Exception {
    for (Map.Entry<Type, Value<?>> entry : typeToValue.entrySet()) {
      Type type = entry.getKey();
      Boolean indexed = entry.getValue().indexed();
      switch (type) {
        case ENTITY:
          assertFalse(indexed);
          break;
        default:
          assertNull(indexed);
          break;
      }
    }
  }

  @Test
  public void testHasMeaning() throws Exception {

  }

  @Test
  public void testMeaning() throws Exception {

  }

  @Test
  public void testGet() throws Exception {

  }

  @Test
  public void testToBuilder() throws Exception {

  }
}
