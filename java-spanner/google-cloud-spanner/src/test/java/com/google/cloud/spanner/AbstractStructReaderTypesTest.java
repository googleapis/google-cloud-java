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

import static com.google.cloud.spanner.Type.StructField;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.runners.Parameterized.Parameter;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.common.base.Throwables;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ProtocolMessageEnum;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.junit.Before;
import org.junit.Test;
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
    protected float getFloatInternal(int columnIndex) {
      return 0f;
    }

    @Override
    protected double getDoubleInternal(int columnIndex) {
      return 0;
    }

    @Override
    protected BigDecimal getBigDecimalInternal(int columnIndex) {
      return null;
    }

    @Override
    protected String getStringInternal(int columnIndex) {
      return null;
    }

    @Override
    protected String getJsonInternal(int columnIndex) {
      return null;
    }

    @Override
    protected String getPgJsonbInternal(int columnIndex) {
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
    protected UUID getUuidInternal(int columnIndex) {
      return null;
    }

    protected Interval getIntervalInternal(int columnIndex) {
      return null;
    }

    @Override
    protected <T extends AbstractMessage> T getProtoMessageInternal(int columnIndex, T message) {
      return null;
    }

    @Override
    protected <T extends ProtocolMessageEnum> T getProtoEnumInternal(
        int columnIndex, Function<Integer, ProtocolMessageEnum> method) {
      return null;
    }

    @Override
    protected Value getValueInternal(int columnIndex) {
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
    protected float[] getFloatArrayInternal(int columnIndex) {
      return null;
    }

    @Override
    protected List<Float> getFloatListInternal(int columnIndex) {
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
    protected List<BigDecimal> getBigDecimalListInternal(int columnIndex) {
      return null;
    }

    @Override
    protected List<String> getStringListInternal(int columnIndex) {
      return null;
    }

    @Override
    protected List<String> getJsonListInternal(int columnIndex) {
      return null;
    }

    @Override
    protected List<String> getPgJsonbListInternal(int columnIndex) {
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
    protected <T extends AbstractMessage> List<T> getProtoMessageListInternal(
        int columnIndex, T message) {
      return null;
    }

    @Override
    protected <T extends ProtocolMessageEnum> List<T> getProtoEnumListInternal(
        int columnIndex, Function<Integer, ProtocolMessageEnum> method) {
      return null;
    }

    @Override
    protected List<Date> getDateListInternal(int columnIndex) {
      return null;
    }

    @Override
    protected List<UUID> getUuidListInternal(int columnIndex) {
      return null;
    }

    @Override
    protected List<Interval> getIntervalListInternal(int columnIndex) {
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
          {
            Type.bool(),
            "getBooleanInternal",
            false,
            "getBoolean",
            Collections.singletonList("getValue")
          },
          {Type.int64(), "getLongInternal", 123L, "getLong", Collections.singletonList("getValue")},
          {
            Type.float32(),
            "getFloatInternal",
            2.0f,
            "getFloat",
            Collections.singletonList("getValue")
          },
          {
            Type.float64(),
            "getDoubleInternal",
            2.0,
            "getDouble",
            Collections.singletonList("getValue")
          },
          {
            Type.numeric(),
            "getBigDecimalInternal",
            BigDecimal.valueOf(21, 1),
            "getBigDecimal",
            Collections.singletonList("getValue")
          },
          {
            Type.pgNumeric(),
            "getStringInternal",
            "1.23",
            "getString",
            Collections.singletonList("getValue")
          },
          {
            Type.string(),
            "getStringInternal",
            "a",
            "getString",
            Collections.singletonList("getValue")
          },
          {
            Type.bytes(),
            "getBytesInternal",
            ByteArray.copyFrom(new byte[] {0}),
            "getBytes",
            Collections.singletonList("getValue")
          },
          {
            Type.json(),
            "getJsonInternal",
            "{\"color\":\"red\",\"value\":\"#f00\"}",
            "getJson",
            Collections.singletonList("getValue")
          },
          {Type.pgOid(), "getLongInternal", 123L, "getLong", Collections.singletonList("getValue")},
          {
            Type.timestamp(),
            "getTimestampInternal",
            Timestamp.parseTimestamp("2015-09-15T00:00:00Z"),
            "getTimestamp",
            Collections.singletonList("getValue")
          },
          {
            Type.date(),
            "getDateInternal",
            Date.parseDate("2015-09-15"),
            "getDate",
            Collections.singletonList("getValue")
          },
          {
            Type.uuid(),
            "getUuidInternal",
            UUID.randomUUID(),
            "getUuid",
            Collections.singletonList("getValue")
          },
          {
            Type.interval(),
            "getIntervalInternal",
            Interval.parseFromString("P1Y2M3DT4H5M6.78912345S"),
            "getInterval",
            Collections.singletonList("getValue")
          },
          {
            Type.array(Type.bool()),
            "getBooleanArrayInternal",
            new boolean[] {true, false},
            "getBooleanArray",
            Arrays.asList("getBooleanList", "getValue")
          },
          {
            Type.array(Type.bool()),
            "getBooleanListInternal",
            Arrays.asList(false, true),
            "getBooleanList",
            Arrays.asList("getBooleanArray", "getValue")
          },
          {
            Type.array(Type.int64()),
            "getLongArrayInternal",
            new long[] {1, 2},
            "getLongArray",
            Arrays.asList("getLongList", "getValue")
          },
          {
            Type.array(Type.int64()),
            "getLongListInternal",
            Arrays.asList(3L, 4L),
            "getLongList",
            Arrays.asList("getLongArray", "getValue")
          },
          {
            Type.array(Type.float32()),
            "getFloatArrayInternal",
            new float[] {1.0f, 2.0f},
            "getFloatArray",
            Arrays.asList("getFloatList", "getValue")
          },
          {
            Type.array(Type.float32()),
            "getFloatListInternal",
            Arrays.asList(2.0f, 4.0f),
            "getFloatList",
            Arrays.asList("getFloatArray", "getValue")
          },
          {
            Type.array(Type.float64()),
            "getDoubleArrayInternal",
            new double[] {1.0, 2.0},
            "getDoubleArray",
            Arrays.asList("getDoubleList", "getValue")
          },
          {
            Type.array(Type.float64()),
            "getDoubleListInternal",
            Arrays.asList(2.0, 4.0),
            "getDoubleList",
            Arrays.asList("getDoubleArray", "getValue")
          },
          {
            Type.array(Type.numeric()),
            "getBigDecimalListInternal",
            Arrays.asList(BigDecimal.valueOf(21, 1), BigDecimal.valueOf(41, 1)),
            "getBigDecimalList",
            Collections.singletonList("getValue")
          },
          {
            Type.array(Type.pgNumeric()),
            "getStringListInternal",
            Arrays.asList("1.23", "2.34"),
            "getStringList",
            Collections.singletonList("getValue")
          },
          {
            Type.array(Type.string()),
            "getStringListInternal",
            Arrays.asList("a", "b", "c"),
            "getStringList",
            Collections.singletonList("getValue")
          },
          {
            Type.array(Type.json()),
            "getJsonListInternal",
            Arrays.asList("{}", "{\"color\":\"red\",\"value\":\"#f00\"}", "[]"),
            "getJsonList",
            Collections.singletonList("getValue")
          },
          {
            Type.array(Type.pgOid()),
            "getLongArrayInternal",
            new long[] {1, 2},
            "getLongArray",
            Arrays.asList("getLongList", "getValue")
          },
          {
            Type.array(Type.pgOid()),
            "getLongListInternal",
            Arrays.asList(3L, 4L),
            "getLongList",
            Arrays.asList("getLongArray", "getValue")
          },
          {
            Type.array(Type.bytes()),
            "getBytesListInternal",
            Arrays.asList(
                ByteArray.copyFrom("a"), ByteArray.copyFrom("b"), ByteArray.copyFrom("c")),
            "getBytesList",
            Collections.singletonList("getValue")
          },
          {
            Type.array(Type.timestamp()),
            "getTimestampListInternal",
            Arrays.asList(
                Timestamp.parseTimestamp("2015-09-15T00:00:00Z"),
                Timestamp.parseTimestamp("2015-09-14T00:00:00Z")),
            "getTimestampList",
            Collections.singletonList("getValue")
          },
          {
            Type.array(Type.date()),
            "getDateListInternal",
            Arrays.asList(Date.parseDate("2015-09-15"), Date.parseDate("2015-09-14")),
            "getDateList",
            Collections.singletonList("getValue")
          },
          {
            Type.array(Type.uuid()),
            "getUuidListInternal",
            Arrays.asList(UUID.randomUUID(), UUID.randomUUID()),
            "getUuidList",
            Collections.singletonList("getValue")
          },
          {
            Type.array(Type.interval()),
            "getIntervalListInternal",
            Arrays.asList(
                Interval.parseFromString("P1Y2M3DT4H5M6.78912345S"),
                Interval.parseFromString("P0Y"),
                Interval.parseFromString("P-1Y2M-3DT-4H5M6.78912345S")),
            "getIntervalList",
            Collections.singletonList("getValue")
          },
          {
            Type.array(Type.struct(StructField.of("f1", Type.int64()))),
            "getStructListInternal",
            Arrays.asList(
                Struct.newBuilder().set("f1").to(1).build(),
                Struct.newBuilder().set("f1").to(2).build(),
                Struct.newBuilder().set("f1").to(3).build()),
            "getStructList",
            Collections.singletonList("getValue")
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
      Throwables.throwIfUnchecked(e.getCause());
      throw new RuntimeException(e);
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
      Throwables.throwIfUnchecked(e.getCause());
      throw new RuntimeException(e);
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
  public void getterForIncorrectType() {
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
      IllegalStateException getterByIndexException =
          assertThrows(
              IllegalStateException.class, () -> getterByIndex(method.getName(), columnIndex));
      assertWithMessage("Exception for " + method)
          .that(getterByIndexException.getMessage())
          .contains("was " + type);
      assertWithMessage("Exception for " + method)
          .that(getterByIndexException.getMessage())
          .contains("Column " + columnIndex);

      IllegalStateException getterByNameException =
          assertThrows(IllegalStateException.class, () -> getterByName(method.getName(), "F1"));
      assertWithMessage("Exception for " + method)
          .that(getterByNameException.getMessage())
          .contains("was " + type);
      assertWithMessage("Exception for " + method)
          .that(getterByNameException.getMessage())
          .contains("Column F1");
    }
  }

  @Test
  public void getterWhenNull() {
    Mockito.when(reader.getType()).thenReturn(Type.struct(StructField.of("F1", type)));
    Mockito.when(reader.isNull(0)).thenReturn(true);
    NullPointerException ex = assertThrows(NullPointerException.class, () -> getterByIndex(0));
    assertNotNull(ex.getMessage());
  }

  @Test
  public void getterByNameWhenNull() {
    Mockito.when(reader.getType()).thenReturn(Type.struct(StructField.of("F1", type)));
    Mockito.when(reader.isNull(0)).thenReturn(true);
    NullPointerException ex = assertThrows(NullPointerException.class, () -> getterByName("F1"));
    assertNotNull(ex.getMessage());
  }
}
