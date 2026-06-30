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

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ProtocolMessageEnum;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * A base interface for reading the fields of a {@code STRUCT}. The Cloud Spanner yields {@code
 * StructReader} instances as one of the subclasses {@link ResultSet} or {@link Struct}, most
 * commonly as the result of a read or query operation. At any point in time, a {@code StructReader}
 * provides access to a single tuple of data comprising multiple typed columns. Each column may have
 * a {@code NULL} or non-{@code NULL} value; in both cases, columns always have a type.
 *
 * <p>Column values are accessed using the {@code getTypeName()} methods; a set of methods exists
 * for each Java type that a column may be read as, and depending on the type of the column, only a
 * subset of those methods will be appropriate. For example, {@link #getString(int)} and {@link
 * #getString(String)} exist for reading columns of type {@link Type#string()}; attempting to call
 * those methods for columns of other types will result in an {@code IllegalStateException}. The
 * {@code getTypeName()} methods should only be called for non-{@code NULL} values, otherwise a
 * {@code NullPointerException} is raised; {@link #isNull(int)}/{@link #isNull(String)} can be used
 * to test for {@code NULL}-ness if necessary.
 *
 * <p>All methods for accessing a column have overloads that accept an {@code int} column index and
 * a {@code String} column name. Column indices are zero-based. The column name overloads will fail
 * with {@code IllegalArgumentException} if the column name does not appear exactly once in this
 * instance's {@link #getType()}. The {@code int} overloads are typically more efficient than their
 * {@code String} counterparts.
 *
 * <p>{@code StructReader} itself does not define whether the implementing type is mutable or
 * immutable. For example, {@link ResultSet} is a mutable implementation of {@code StructReader},
 * where the {@code StructReader} methods provide access to the row that the result set is currently
 * positioned over and {@link ResultSet#next()} changes that view to the next row, whereas {@link
 * Struct} is an immutable implementation of {@code StructReader}.
 */
public interface StructReader {
  /**
   * @return the type of the underlying data. This will always be a {@code STRUCT} type, with fields
   *     corresponding to the data's columns. For the result of a read or query, this will always
   *     match the columns passed to the {@code read()} call or named in the query text, in order.
   */
  Type getType();

  /**
   * @return the number of columns in the underlying data. This includes any columns with {@code
   *     NULL} values.
   */
  int getColumnCount();

  /**
   * @param columnName name of the column
   * @return the index of the column named {@code columnName}.
   * @throws IllegalArgumentException if there is not exactly one element of {@code
   *     type().structFields()} with {@link Type.StructField#getName()} equal to {@code columnName}
   */
  int getColumnIndex(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the type of a column.
   */
  Type getColumnType(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the type of a column.
   */
  Type getColumnType(String columnName);

  /**
   * @param columnIndex index of the column
   * @return {@code true} if a column contains a {@code NULL} value.
   */
  boolean isNull(int columnIndex);

  /**
   * @param columnName name of the column
   * @return {@code true} if a column contains a {@code NULL} value.
   */
  boolean isNull(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#bool()}.
   */
  boolean getBoolean(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#bool()}.
   */
  boolean getBoolean(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#int64()}.
   */
  long getLong(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#int64()}.
   */
  long getLong(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#float32()}.
   */
  default float getFloat(int columnIndex) {
    throw new UnsupportedOperationException("method should be overwritten");
  }

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#float32()}.
   */
  default float getFloat(String columnName) {
    throw new UnsupportedOperationException("method should be overwritten");
  }

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#float64()}.
   */
  double getDouble(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#float64()}.
   */
  double getDouble(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#numeric()}.
   */
  BigDecimal getBigDecimal(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#numeric()}.
   */
  BigDecimal getBigDecimal(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#string()}.
   */
  String getString(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#string()}.
   */
  String getString(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a column with type T or null if the column contains a null value
   *     <p>Example
   *     <pre>{@code
   * Struct row = ...
   * String name = row.getOrNull(1, StructReader::getString)
   * }</pre>
   */
  default <T> T getOrNull(int columnIndex, BiFunction<StructReader, Integer, T> function) {
    return isNull(columnIndex) ? null : function.apply(this, columnIndex);
  }

  /**
   * @param columnName index of the column
   * @return the value of a column with type T or null if the column contains a null value
   *     <p>Example
   *     <pre>{@code
   * Struct row = ...
   * String name = row.getOrNull("name", StructReader::getString)
   * }</pre>
   */
  default <T> T getOrNull(String columnName, BiFunction<StructReader, String, T> function) {
    return isNull(columnName) ? null : function.apply(this, columnName);
  }

  /**
   * @param columnIndex index of the column
   * @return the value of a column with type T, or the given default if the column value is null
   *     <p>Example
   *     <pre>{@code
   * Struct row = ...
   * String name = row.getOrDefault(1, StructReader::getString, "")
   * }</pre>
   */
  default <T> T getOrDefault(
      int columnIndex, BiFunction<StructReader, Integer, T> function, T defaultValue) {
    return isNull(columnIndex) ? defaultValue : function.apply(this, columnIndex);
  }

  /**
   * @param columnName name of the column
   * @return the value of a column with type T, or the given default if the column value is null
   *     <p>Example
   *     <pre>{@code
   * Struct row = ...
   * String name = row.getOrDefault("name", StructReader::getString, "")
   * }</pre>
   */
  default <T> T getOrDefault(
      String columnName, BiFunction<StructReader, String, T> function, T defaultValue) {
    return isNull(columnName) ? defaultValue : function.apply(this, columnName);
  }

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#json()}.
   */
  default String getJson(int columnIndex) {
    throw new UnsupportedOperationException("method should be overwritten");
  }

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#json()}.
   */
  default String getJson(String columnName) {
    throw new UnsupportedOperationException("method should be overwritten");
  }

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#pgJsonb()}.
   */
  default String getPgJsonb(int columnIndex) {
    throw new UnsupportedOperationException("method should be overwritten");
  }

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#pgJsonb()}.
   */
  default String getPgJsonb(String columnName) {
    throw new UnsupportedOperationException("method should be overwritten");
  }

  /**
   * To get the proto message of generic type {@code T} from Struct.
   *
   * @param columnIndex Index of the column.
   * @param message Proto message object. Message can't be null as it's internally used to find the
   *     type of proto. Use @code{MyProtoClass.getDefaultInstance()}. @see <a
   *     href="https://developers.google.com/protocol-buffers/docs/reference/java-generated#message">getDefaultInstance()</a>
   * @return The value of a non-{@code NULL} column with type {@link Type#proto(String)} ()}.
   */
  default <T extends AbstractMessage> T getProtoMessage(int columnIndex, T message) {
    throw new UnsupportedOperationException("method should be overwritten");
  }

  /**
   * To get the proto message of type {@code T} from Struct.
   *
   * @param columnName Name of the column.
   * @param message Proto message object. Message can't be null as it's internally used to find the
   *     type of proto. Use @code{MyProtoClass.getDefaultInstance()}. @see <a
   *     href="https://developers.google.com/protocol-buffers/docs/reference/java-generated#message">getDefaultInstance()</a>
   * @return The value of a non-{@code NULL} column with type {@link Type#proto(String)} ()}.
   */
  default <T extends AbstractMessage> T getProtoMessage(String columnName, T message) {
    throw new UnsupportedOperationException("method should be overwritten");
  }

  /**
   * To get the proto enum of type {@code T} from Struct.
   *
   * @param columnIndex Index of the column.
   * @param method A function that takes enum integer constant as argument and returns the enum. Use
   *     method @code{forNumber} from generated enum class (eg: MyProtoEnum::forNumber). @see <a
   *     href="https://developers.google.com/protocol-buffers/docs/reference/java-generated#enum">forNumber</a>
   * @return The value of a non-{@code NULL} column with type {@link Type#protoEnum(String)} ()}.
   */
  default <T extends ProtocolMessageEnum> T getProtoEnum(
      int columnIndex, Function<Integer, ProtocolMessageEnum> method) {
    throw new UnsupportedOperationException("method should be overwritten");
  }

  /**
   * To get the proto enum of type {@code T} from Struct.
   *
   * @param columnName Name of the column.
   * @param method A function that takes enum integer constant as argument and returns the enum. Use
   *     method @code{forNumber} from generated enum class (eg: MyProtoEnum::forNumber). @see <a
   *     href="https://developers.google.com/protocol-buffers/docs/reference/java-generated#enum">forNumber</a>
   * @return The value of a non-{@code NULL} column with type {@link Type#protoEnum(String)} ()}.
   */
  default <T extends ProtocolMessageEnum> T getProtoEnum(
      String columnName, Function<Integer, ProtocolMessageEnum> method) {
    throw new UnsupportedOperationException("method should be overwritten");
  }

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#bytes()}.
   */
  ByteArray getBytes(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#bytes()}.
   */
  ByteArray getBytes(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#timestamp()}.
   */
  Timestamp getTimestamp(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#timestamp()}.
   */
  Timestamp getTimestamp(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#date()}.
   */
  Date getDate(int columnIndex);

  UUID getUuid(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#date()}.
   */
  Date getDate(String columnName);

  UUID getUuid(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#interval()}.
   */
  Interval getInterval(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@link Type#interval()}.
   */
  Interval getInterval(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a nullable column as a {@link Value}.
   */
  default Value getValue(int columnIndex) {
    throw new UnsupportedOperationException("method should be overwritten");
  }

  /**
   * @param columnName name of the column
   * @return the value of a nullable column as a {@link Value}.
   */
  default Value getValue(String columnName) {
    throw new UnsupportedOperationException("method should be overwritten");
  }

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.bool())}.
   * @throws NullPointerException if any element of the array value is {@code NULL}. If the array
   *     may contain {@code NULL} values, use {@link #getBooleanList(int)} instead.
   */
  boolean[] getBooleanArray(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.bool())}.
   * @throws NullPointerException if any element of the array value is {@code NULL}. If the array
   *     may contain {@code NULL} values, use {@link #getBooleanList(String)} instead.
   */
  boolean[] getBooleanArray(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.bool())}. The
   *     list returned by this method is lazily constructed. Create a copy of it if you intend to
   *     access each element in the list multiple times.
   */
  List<Boolean> getBooleanList(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.bool())}. The
   *     list returned by this method is lazily constructed. Create a copy of it if you intend to
   *     access each element in the list multiple times.
   */
  List<Boolean> getBooleanList(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.int64())}.
   * @throws NullPointerException if any element of the array value is {@code NULL}. If the array
   *     may contain {@code NULL} values, use {@link #getLongList(int)} instead.
   */
  long[] getLongArray(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.int64())}.
   * @throws NullPointerException if any element of the array value is {@code NULL}. If the array
   *     may contain {@code NULL} values, use {@link #getLongList(String)} instead.
   */
  long[] getLongArray(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.int64())}. The
   *     list returned by this method is lazily constructed. Create a copy of it if you intend to
   *     access each element in the list multiple times.
   */
  List<Long> getLongList(int columnIndex);

  /**
   * @param columnName
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.int64())}. The
   *     list returned by this method is lazily constructed. Create a copy of it if you intend to
   *     access each element in the list multiple times.
   */
  List<Long> getLongList(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.float32())}.
   * @throws NullPointerException if any element of the array value is {@code NULL}. If the array
   *     may contain {@code NULL} values, use {@link #getFloatList(int)} instead.
   */
  default float[] getFloatArray(int columnIndex) {
    throw new UnsupportedOperationException("method should be overwritten");
  }

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.float32())}.
   * @throws NullPointerException if any element of the array value is {@code NULL}. If the array
   *     may contain {@code NULL} values, use {@link #getFloatList(String)} instead.
   */
  default float[] getFloatArray(String columnName) {
    throw new UnsupportedOperationException("method should be overwritten");
  }

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.float32())} The
   *     list returned by this method is lazily constructed. Create a copy of it if you intend to
   *     access each element in the list multiple times.
   */
  default List<Float> getFloatList(int columnIndex) {
    throw new UnsupportedOperationException("method should be overwritten");
  }

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.float32())} The
   *     list returned by this method is lazily constructed. Create a copy of it if you intend to
   *     access each element in the list multiple times.
   */
  List<Float> getFloatList(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.float64())}.
   * @throws NullPointerException if any element of the array value is {@code NULL}. If the array
   *     may contain {@code NULL} values, use {@link #getDoubleList(int)} instead.
   */
  double[] getDoubleArray(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.float64())}.
   * @throws NullPointerException if any element of the array value is {@code NULL}. If the array
   *     may contain {@code NULL} values, use {@link #getDoubleList(String)} instead.
   */
  double[] getDoubleArray(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.float64())} The
   *     list returned by this method is lazily constructed. Create a copy of it if you intend to
   *     access each element in the list multiple times.
   */
  List<Double> getDoubleList(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.float64())} The
   *     list returned by this method is lazily constructed. Create a copy of it if you intend to
   *     access each element in the list multiple times.
   */
  List<Double> getDoubleList(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.numeric())} The
   *     list returned by this method is lazily constructed. Create a copy of it if you intend to
   *     access each element in the list multiple times.
   */
  List<BigDecimal> getBigDecimalList(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.numeric())} The
   *     list returned by this method is lazily constructed. Create a copy of it if you intend to
   *     access each element in the list multiple times.
   */
  List<BigDecimal> getBigDecimalList(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.string())}. The
   *     list returned by this method is lazily constructed. Create a copy of it if you intend to
   *     access each element in the list multiple times.
   */
  List<String> getStringList(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.string())}. The
   *     list returned by this method is lazily constructed. Create a copy of it if you intend to
   *     access each element in the list multiple times.
   */
  List<String> getStringList(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.json())}. The
   *     list returned by this method is lazily constructed. Create a copy of it if you intend to
   *     access each element in the list multiple times.
   */
  default List<String> getJsonList(int columnIndex) {
    throw new UnsupportedOperationException("method should be overwritten");
  }
  ;

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.json())}. The
   *     list returned by this method is lazily constructed. Create a copy of it if you intend to
   *     access each element in the list multiple times.
   */
  default List<String> getJsonList(String columnName) {
    throw new UnsupportedOperationException("method should be overwritten");
  }
  ;

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.pgJsonb())} The
   *     list returned by this method is lazily constructed. Create a copy of it if you intend to
   *     access each element in the list multiple times.
   */
  default List<String> getPgJsonbList(int columnIndex) {
    throw new UnsupportedOperationException("method should be overwritten");
  }
  ;

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.pgJsonb())} The
   *     list returned by this method is lazily constructed. Create a copy of it if you intend to
   *     access each element in the list multiple times.
   */
  default List<String> getPgJsonbList(String columnName) {
    throw new UnsupportedOperationException("method should be overwritten");
  }
  ;

  /**
   * To get the proto message of generic type {@code T} from Struct.
   *
   * @param columnIndex Index of the column.
   * @param message Proto message object. Message can't be null as it's internally used to find the
   *     type of proto. Use @code{MyProtoClass.getDefaultInstance()}. @see <a
   *     href="https://developers.google.com/protocol-buffers/docs/reference/java-generated#message">getDefaultInstance()</a>
   * @return The value of a non-{@code NULL} column with type {@code
   *     Type.array(Type.proto(String))}.
   */
  default <T extends AbstractMessage> List<T> getProtoMessageList(int columnIndex, T message) {
    throw new UnsupportedOperationException("method should be overwritten");
  }

  /**
   * To get the proto message of type {@code T} from Struct.
   *
   * @param columnName Name of the column.
   * @param message Proto message object. Message can't be null as it's internally used to find the
   *     type of proto. Use @code{MyProtoClass.getDefaultInstance()}. @see <a
   *     href="https://developers.google.com/protocol-buffers/docs/reference/java-generated#message">getDefaultInstance()</a>
   * @return The value of a non-{@code NULL} column with type {@code
   *     Type.array(Type.proto(String))}.
   */
  default <T extends AbstractMessage> List<T> getProtoMessageList(String columnName, T message) {
    throw new UnsupportedOperationException("method should be overwritten");
  }

  /**
   * To get the proto enum of type {@code T} from Struct.
   *
   * @param columnIndex Index of the column.
   * @param method A function that takes enum integer constant as argument and returns the enum. Use
   *     method @code{forNumber} from generated enum class (eg: MyProtoEnum::forNumber). @see <a
   *     href="https://developers.google.com/protocol-buffers/docs/reference/java-generated#enum">forNumber</a>
   * @return The value of a non-{@code NULL} column with type {@code
   *     Type.array(Type.protoEnum(String))}.
   */
  default <T extends ProtocolMessageEnum> List<T> getProtoEnumList(
      int columnIndex, Function<Integer, ProtocolMessageEnum> method) {
    throw new UnsupportedOperationException("method should be overwritten");
  }

  /**
   * To get the proto enum list of type {@code T} from Struct.
   *
   * @param columnName Name of the column.
   * @param method A function that takes enum integer constant as argument and returns the enum. Use
   *     method @code{forNumber} from generated enum class (eg: MyProtoEnum::forNumber). @see <a
   *     href="https://developers.google.com/protocol-buffers/docs/reference/java-generated#enum">forNumber</a>
   * @return The value of a non-{@code NULL} column with type {@code
   *     Type.array(Type.protoEnum(String))}.
   */
  default <T extends ProtocolMessageEnum> List<T> getProtoEnumList(
      String columnName, Function<Integer, ProtocolMessageEnum> method) {
    throw new UnsupportedOperationException("method should be overwritten");
  }

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.bytes())}. The
   *     list returned by this method is lazily constructed. Create a copy of it if you intend to
   *     access each element in the list multiple times.
   */
  List<ByteArray> getBytesList(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.bytes())}. The
   *     list returned by this method is lazily constructed. Create a copy of it if you intend to
   *     access each element in the list multiple times.
   */
  List<ByteArray> getBytesList(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.timestamp())}
   *     The list returned by this method is lazily constructed. Create a copy of it if you intend
   *     to access each element in the list multiple times.
   */
  List<Timestamp> getTimestampList(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.timestamp())}
   *     The list returned by this method is lazily constructed. Create a copy of it if you intend
   *     to access each element in the list multiple times.
   */
  List<Timestamp> getTimestampList(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.date())}. The
   *     list returned by this method is lazily constructed. Create a copy of it if you intend to
   *     access each element in the list multiple times.
   */
  List<Date> getDateList(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.date())}. The
   *     list returned by this method is lazily constructed. Create a copy of it if you intend to
   *     access each element in the list multiple times.
   */
  List<Date> getDateList(String columnName);

  List<UUID> getUuidList(int columnIndex);

  List<UUID> getUuidList(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.interval())}.
   *     The list returned by this method is lazily constructed. Create a copy of it if you intend
   *     to access each element in the list multiple times.
   */
  List<Interval> getIntervalList(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.interval())}.
   *     The list returned by this method is lazily constructed. Create a copy of it if you intend
   *     to access each element in the list multiple times.
   */
  List<Interval> getIntervalList(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.struct(...))}
   *     The list returned by this method is lazily constructed. Create a copy of it if you intend
   *     to access each element in the list multiple times.
   */
  List<Struct> getStructList(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the value of a non-{@code NULL} column with type {@code Type.array(Type.struct(...))}
   *     The list returned by this method is lazily constructed. Create a copy of it if you intend
   *     to access each element in the list multiple times.
   */
  List<Struct> getStructList(String columnName);
}
