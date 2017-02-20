/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import static com.google.cloud.spanner.Type.StructField;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;
import static org.junit.runners.Parameterized.Parameter;

import com.google.cloud.ByteArray;
import com.google.common.base.Throwables;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

/** Unit tests for {@link AbstractStructReader} that cover all type combinations. */
@RunWith(Parameterized.class)
public class AbstractStructReaderTypesTest {
  private static class TestStructReader extends AbstractStructReader {
    @Override
    protected boolean getBooleanInternal(int columnIndex) {
      return false;
    }

    @Override
    protected long getLongInternal(int columnIndex) {
      return 0;
    }

    @Override
    protected double getDoubleInternal(int columnIndex) {
      return 0;
    }

    @Override
    protected String getStringInternal(int columnIndex) {
      return null;
    }

    @Override
    protected ByteArray getBytesInternal(int columnIndex) {
      return null;
    }

    @Override
    protected Timestamp getTimestampInternal(int columnIndex) {
      return null;
    }

    @Override
    protected Date getDateInternal(int columnIndex) {
      return null;
    }

    @Override
    protected boolean[] getBooleanArrayInternal(int columnIndex) {
      return null;
    }

    @Override
    protected List<Boolean> getBooleanListInternal(int columnIndex) {
      return null;
    }

    @Override
    protected long[] getLongArrayInternal(int columnIndex) {
      return null;
    }

    @Override
    protected List<Long> getLongListInternal(int columnIndex) {
      return null;
    }

    @Override
    protected double[] getDoubleArrayInternal(int columnIndex) {
      return null;
    }

    @Override
    protected List<Double> getDoubleListInternal(int columnIndex) {
      return null;
    }

    @Override
    protected List<String> getStringListInternal(int columnIndex) {
      return null;
    }

    @Override
    protected List<ByteArray> getBytesListInternal(int columnIndex) {
      return null;
    }

    @Override
    protected List<Timestamp> getTimestampListInternal(int columnIndex) {
      return null;
    }

    @Override
    protected List<Date> getDateListInternal(int columnIndex) {
      return null;
    }

    @Override
    protected List<Struct> getStructListInternal(int columnIndex) {
      return null;
    }

    @Override
    public Type getType() {
      return null;
    }

    @Override
    public boolean isNull(int columnIndex) {
      return false;
    }
  }

  private static List<String> NON_VALUE_GETTERS =
      Arrays.asList("getType", "getColumnCount", "getColumnIndex", "getColumnType");

  @Parameterized.Parameters(name = "{index}: {0}: {3}()={4}")
  public static Collection<Object[]> parameters() {
    return Arrays.asList(
        new Object[][] {
          {Type.bool(), "getBooleanInternal", false, "getBoolean", null},
          {Type.int64(), "getLongInternal", 123L, "getLong", null},
          {Type.float64(), "getDoubleInternal", 2.0, "getDouble", null},
          {Type.string(), "getStringInternal", "a", "getString", null},
          {Type.bytes(), "getBytesInternal", ByteArray.copyFrom(new byte[] {0}), "getBytes", null},
          {
            Type.timestamp(),
            "getTimestampInternal",
            Timestamp.parseTimestamp("2015-09-15T00:00:00Z"),
            "getTimestamp",
            null
          },
          {Type.date(), "getDateInternal", Date.parseDate("2015-09-15"), "getDate", null},
          {
            Type.array(Type.bool()),
            "getBooleanArrayInternal",
            new boolean[] {true, false},
            "getBooleanArray",
            Arrays.asList("getBooleanList")
          },
          {
            Type.array(Type.bool()),
            "getBooleanListInternal",
            Arrays.asList(false, true),
            "getBooleanList",
            Arrays.asList("getBooleanArray")
          },
          {
            Type.array(Type.int64()),
            "getLongArrayInternal",
            new long[] {1, 2},
            "getLongArray",
            Arrays.asList("getLongList")
          },
          {
            Type.array(Type.int64()),
            "getLongListInternal",
            Arrays.asList(3L, 4L),
            "getLongList",
            Arrays.asList("getLongArray")
          },
          {
            Type.array(Type.float64()),
            "getDoubleArrayInternal",
            new double[] {1.0, 2.0},
            "getDoubleArray",
            Arrays.asList("getDoubleList")
          },
          {
            Type.array(Type.float64()),
            "getDoubleListInternal",
            Arrays.asList(2.0, 4.0),
            "getDoubleList",
            Arrays.asList("getDoubleArray")
          },
          {
            Type.array(Type.string()),
            "getStringListInternal",
            Arrays.asList("a", "b", "c"),
            "getStringList",
            null
          },
          {
            Type.array(Type.bytes()),
            "getBytesListInternal",
            Arrays.asList(
                ByteArray.copyFrom("a"), ByteArray.copyFrom("b"), ByteArray.copyFrom("c")),
            "getBytesList",
            null
          },
          {
            Type.array(Type.timestamp()),
            "getTimestampListInternal",
            Arrays.asList(
                Timestamp.parseTimestamp("2015-09-15T00:00:00Z"),
                Timestamp.parseTimestamp("2015-09-14T00:00:00Z")),
            "getTimestampList",
            null,
          },
          {
            Type.array(Type.date()),
            "getDateListInternal",
            Arrays.asList(Date.parseDate("2015-09-15"), Date.parseDate("2015-09-14")),
            "getDateList",
            null,
          },
          {
            Type.array(Type.struct(StructField.of("f1", Type.int64()))),
            "getStructListInternal",
            Arrays.asList(
                Struct.newBuilder().set("f1").to(1).build(),
                Struct.newBuilder().set("f1").to(2).build(),
                Struct.newBuilder().set("f1").to(3).build()),
            "getStructList",
            null
          }
        });
  }

  /** The type of the column being tested. */
  @Parameter(value = 0)
  public Type type;

  /** The name of the implementation method to be called in {@code AbstractStructReader}. */
  @Parameter(value = 1)
  public String implMethodName;

  /**
   * The value that should be returned when {@code implMethodName} is called, and is expected from
   * {@code getterMethodName}.
   */
  @Parameter(value = 2)
  public Object value;

  /** The name of the public getter method to be called. */
  @Parameter(value = 3)
  public String getterMethodName;

  @Parameter(value = 4)
  @Nullable
  public List<String> otherAllowedGetters;

  @Rule public ExpectedException expectedException = ExpectedException.none();
  private TestStructReader reader;

  @Before
  public void setUp() {
    // Partial mock allows us to set expectations for the abstract methods.
    reader = Mockito.spy(new TestStructReader());
  }

  private Object getterByIndex(int columnIndex) {
    return getterByIndex(getterMethodName, columnIndex);
  }

  private Object getterByIndex(String methodName, int columnIndex) {
    try {
      return reader.getClass().getMethod(methodName, int.class).invoke(reader, columnIndex);
    } catch (InvocationTargetException e) {
      throw Throwables.propagate(e.getCause());
    } catch (NoSuchMethodException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  private Object getterByName(String columnName) {
    return getterByName(getterMethodName, columnName);
  }

  private Object getterByName(String methodName, String columnName) {
    try {
      return reader.getClass().getMethod(methodName, String.class).invoke(reader, columnName);
    } catch (InvocationTargetException e) {
      throw Throwables.propagate(e.getCause());
    } catch (NoSuchMethodException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void getter() throws Exception {
    Mockito.when(reader.getType())
        .thenReturn(Type.struct(StructField.of("F0", Type.int64()), StructField.of("F1", type)));
    int columnIndex = 1;
    Mockito.when(reader.isNull(columnIndex)).thenReturn(false);
    Mockito.when(
            reader
                .getClass()
                .getDeclaredMethod(implMethodName, int.class)
                .invoke(reader, columnIndex))
        .thenReturn(value);
    assertThat(getterByIndex(columnIndex)).isEqualTo(value);
    assertThat(getterByName("F1")).isEqualTo(value);
  }

  @Test
  public void getterForIncorrectType() throws Exception {
    Mockito.when(reader.getType()).thenReturn(Type.struct(StructField.of("F1", type)));
    int columnIndex = 0;
    Mockito.when(reader.isNull(columnIndex)).thenReturn(false);
    for (Method method : StructReader.class.getMethods()) {
      if (NON_VALUE_GETTERS.contains(method.getName())) {
        continue;
      }
      if (!method.getName().startsWith("get")
          || method.getParameterTypes().length != 1
          || method.getParameterTypes()[0] != int.class) {
        // Skip non-column index getter methods.
        continue;
      }
      if (method.getName().equals(getterMethodName)
          || (otherAllowedGetters != null && otherAllowedGetters.contains(method.getName()))) {
        // Skip allowed getters.
        continue;
      }
      try {
        getterByIndex(method.getName(), columnIndex);
        fail("Expected ISE for " + method);
      } catch (IllegalStateException e) {
        assertThat(e.getMessage()).named("Exception for " + method).contains("was " + type);
        assertThat(e.getMessage())
            .named("Exception for " + method)
            .contains("Column " + columnIndex);
      }
      try {
        getterByName(method.getName(), "F1");
        fail("Expected ISE for " + method);
      } catch (IllegalStateException e) {
        assertThat(e.getMessage()).named("Exception for " + method).contains("was " + type);
        assertThat(e.getMessage()).named("Exception for " + method).contains("Column F1");
      }
    }
  }

  @Test
  public void getterWhenNull() throws Exception {
    Mockito.when(reader.getType()).thenReturn(Type.struct(StructField.of("F1", type)));
    Mockito.when(reader.isNull(0)).thenReturn(true);
    expectedException.expect(NullPointerException.class);
    getterByIndex(0);
  }

  @Test
  public void getterByNameWhenNull() throws Exception {
    Mockito.when(reader.getType()).thenReturn(Type.struct(StructField.of("F1", type)));
    Mockito.when(reader.isNull(0)).thenReturn(true);
    expectedException.expect(NullPointerException.class);
    getterByName("F1");
  }
}
