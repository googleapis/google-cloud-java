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

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Type.Code;
import com.google.cloud.spanner.Type.StructField;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

/** Utility methods for working with {@link com.google.cloud.spanner.ResultSet}. */
public final class ResultSets {

  private ResultSets() {}

  /**
   * Creates a pre-populated {@link com.google.cloud.spanner.ResultSet}
   *
   * @param type row type of the rows in the returned {@link com.google.cloud.spanner.ResultSet}
   * @param rows the rows in the returned {@link com.google.cloud.spanner.ResultSet}.
   */
  public static ResultSet forRows(Type type, Iterable<Struct> rows) {
    return new PrePopulatedResultSet(type, rows);
  }

  /** Converts the given {@link ResultSet} to an {@link AsyncResultSet}. */
  public static AsyncResultSet toAsyncResultSet(ResultSet delegate) {
    return new AsyncResultSetImpl(
        InstantiatingExecutorProvider.newBuilder()
            .setExecutorThreadCount(1)
            .setThreadFactory(
                new ThreadFactoryBuilder()
                    .setDaemon(true)
                    .setNameFormat("test-async-resultset-%d")
                    .build())
            .build(),
        delegate,
        100);
  }

  /**
   * Converts the given {@link ResultSet} to an {@link AsyncResultSet} using the given {@link
   * ExecutorProvider}.
   */
  public static AsyncResultSet toAsyncResultSet(
      ResultSet delegate, ExecutorProvider executorProvider, QueryOption... options) {
    Options readOptions = Options.fromQueryOptions(options);
    final int bufferRows =
        readOptions.hasBufferRows()
            ? readOptions.bufferRows()
            : AsyncResultSetImpl.DEFAULT_BUFFER_SIZE;
    return new AsyncResultSetImpl(executorProvider, delegate, bufferRows);
  }

  /**
   * Converts the {@link ResultSet} that will be returned by the given {@link ApiFuture} to an
   * {@link AsyncResultSet} using the given {@link ExecutorProvider}.
   */
  public static AsyncResultSet toAsyncResultSet(
      ApiFuture<ResultSet> delegate, ExecutorProvider executorProvider, QueryOption... options) {
    Options readOptions = Options.fromQueryOptions(options);
    final int bufferRows =
        readOptions.hasBufferRows()
            ? readOptions.bufferRows()
            : AsyncResultSetImpl.DEFAULT_BUFFER_SIZE;
    return new AsyncResultSetImpl(
        executorProvider, new FutureResultSetSupplier(delegate), bufferRows);
  }

  private static class FutureResultSetSupplier implements Supplier<ResultSet> {
    final ApiFuture<ResultSet> delegate;

    FutureResultSetSupplier(ApiFuture<ResultSet> delegate) {
      this.delegate = Preconditions.checkNotNull(delegate);
    }

    @Override
    public ResultSet get() {
      return SpannerApiFutures.get(delegate);
    }
  }

  private static class PrePopulatedResultSet implements ProtobufResultSet {
    private final List<Struct> rows;
    private final Type type;
    private int index = -1;
    private boolean closed = false;

    PrePopulatedResultSet(Type type, Iterable<Struct> rows) {
      Preconditions.checkNotNull(rows);
      Preconditions.checkNotNull(type);
      Preconditions.checkArgument(type.getCode() == Type.Code.STRUCT);
      for (StructField field : type.getStructFields()) {
        if (field.getType().getCode() == Code.STRUCT) {
          throw new UnsupportedOperationException(
              "STRUCT-typed columns are not supported inside ResultSets.");
        }
      }
      this.type = type;
      this.rows = rows instanceof List<?> ? (List<Struct>) rows : Lists.newArrayList(rows);
      for (Struct row : rows) {
        Preconditions.checkArgument(row.getType().equals(type));
      }
    }

    @Override
    public boolean next() throws SpannerException {
      return ++index < rows.size();
    }

    @Override
    public boolean canGetProtobufValue(int columnIndex) {
      return !closed && index >= 0 && index < rows.size();
    }

    @Override
    public com.google.protobuf.Value getProtobufValue(int columnIndex) {
      Preconditions.checkState(!closed, "ResultSet is closed");
      Preconditions.checkState(index >= 0, "Must be preceded by a next() call");
      Preconditions.checkElementIndex(index, rows.size(), "All rows have been yielded");
      return getValue(columnIndex).toProto();
    }

    @Override
    public Struct getCurrentRowAsStruct() {
      Preconditions.checkState(!closed, "ResultSet is closed");
      Preconditions.checkState(index >= 0, "Must be preceded by a next() call");
      Preconditions.checkElementIndex(index, rows.size(), "All rows have been yielded");
      return rows.get(index);
    }

    @Override
    public void close() {
      closed = true;
    }

    @Override
    public Type getType() {
      Preconditions.checkState(index >= 0, "Must be preceded by a next() call");
      return type;
    }

    @Override
    public ResultSetStats getStats() {
      throw new UnsupportedOperationException(
          "ResultSetStats are available only for results returned from analyzeQuery() calls");
    }

    @Override
    public ResultSetMetadata getMetadata() {
      throw new UnsupportedOperationException(
          "ResultSetMetadata are available only for results that were returned from Cloud Spanner");
    }

    @Override
    public int getColumnCount() {
      return getType().getStructFields().size();
    }

    @Override
    public int getColumnIndex(String columnName) {
      return getType().getFieldIndex(columnName);
    }

    @Override
    public Type getColumnType(int columnIndex) {
      return getType().getStructFields().get(columnIndex).getType();
    }

    @Override
    public Type getColumnType(String columnName) {
      for (Type.StructField field : getType().getStructFields()) {
        if (field.getName().equals(columnName)) {
          return field.getType();
        }
      }
      return null;
    }

    @Override
    public boolean isNull(int columnIndex) {
      return getCurrentRowAsStruct().isNull(columnIndex);
    }

    @Override
    public boolean isNull(String columnName) {
      return getCurrentRowAsStruct().isNull(columnName);
    }

    @Override
    public boolean getBoolean(int columnIndex) {
      return getCurrentRowAsStruct().getBoolean(columnIndex);
    }

    @Override
    public boolean getBoolean(String columnName) {
      return getCurrentRowAsStruct().getBoolean(columnName);
    }

    @Override
    public long getLong(int columnIndex) {
      return getCurrentRowAsStruct().getLong(columnIndex);
    }

    @Override
    public long getLong(String columnName) {
      return getCurrentRowAsStruct().getLong(columnName);
    }

    @Override
    public float getFloat(int columnIndex) {
      return getCurrentRowAsStruct().getFloat(columnIndex);
    }

    @Override
    public float getFloat(String columnName) {
      return getCurrentRowAsStruct().getFloat(columnName);
    }

    @Override
    public double getDouble(int columnIndex) {
      return getCurrentRowAsStruct().getDouble(columnIndex);
    }

    @Override
    public double getDouble(String columnName) {
      return getCurrentRowAsStruct().getDouble(columnName);
    }

    @Override
    public BigDecimal getBigDecimal(int columnIndex) {
      return getCurrentRowAsStruct().getBigDecimal(columnIndex);
    }

    @Override
    public BigDecimal getBigDecimal(String columnName) {
      return getCurrentRowAsStruct().getBigDecimal(columnName);
    }

    @Override
    public String getString(int columnIndex) {
      return getCurrentRowAsStruct().getString(columnIndex);
    }

    @Override
    public String getString(String columnName) {
      return getCurrentRowAsStruct().getString(columnName);
    }

    @Override
    public String getJson(int columnIndex) {
      return getCurrentRowAsStruct().getJson(columnIndex);
    }

    @Override
    public String getJson(String columnName) {
      return getCurrentRowAsStruct().getJson(columnName);
    }

    @Override
    public String getPgJsonb(int columnIndex) {
      return getCurrentRowAsStruct().getPgJsonb(columnIndex);
    }

    @Override
    public String getPgJsonb(String columnName) {
      return getCurrentRowAsStruct().getPgJsonb(columnName);
    }

    @Override
    public ByteArray getBytes(int columnIndex) {
      return getCurrentRowAsStruct().getBytes(columnIndex);
    }

    @Override
    public ByteArray getBytes(String columnName) {
      return getCurrentRowAsStruct().getBytes(columnName);
    }

    @Override
    public Timestamp getTimestamp(int columnIndex) {
      return getCurrentRowAsStruct().getTimestamp(columnIndex);
    }

    @Override
    public Timestamp getTimestamp(String columnName) {
      return getCurrentRowAsStruct().getTimestamp(columnName);
    }

    @Override
    public Date getDate(int columnIndex) {
      return getCurrentRowAsStruct().getDate(columnIndex);
    }

    @Override
    public Date getDate(String columnName) {
      return getCurrentRowAsStruct().getDate(columnName);
    }

    @Override
    public UUID getUuid(int columnIndex) {
      return getCurrentRowAsStruct().getUuid(columnIndex);
    }

    @Override
    public UUID getUuid(String columnName) {
      return getCurrentRowAsStruct().getUuid(columnName);
    }

    @Override
    public Interval getInterval(int columnIndex) {
      return getCurrentRowAsStruct().getInterval(columnIndex);
    }

    @Override
    public Interval getInterval(String columnName) {
      return getCurrentRowAsStruct().getInterval(columnName);
    }

    @Override
    public <T extends AbstractMessage> T getProtoMessage(int columnIndex, T message) {
      return getCurrentRowAsStruct().getProtoMessage(columnIndex, message);
    }

    @Override
    public <T extends AbstractMessage> T getProtoMessage(String columnName, T message) {
      return getCurrentRowAsStruct().getProtoMessage(columnName, message);
    }

    @Override
    public <T extends ProtocolMessageEnum> T getProtoEnum(
        int columnIndex, Function<Integer, ProtocolMessageEnum> method) {
      return getCurrentRowAsStruct().getProtoEnum(columnIndex, method);
    }

    @Override
    public <T extends ProtocolMessageEnum> T getProtoEnum(
        String columnName, Function<Integer, ProtocolMessageEnum> method) {
      return getCurrentRowAsStruct().getProtoEnum(columnName, method);
    }

    @Override
    public Value getValue(int columnIndex) {
      return getCurrentRowAsStruct().getValue(columnIndex);
    }

    @Override
    public Value getValue(String columnName) {
      return getCurrentRowAsStruct().getValue(columnName);
    }

    @Override
    public boolean[] getBooleanArray(int columnIndex) {
      return getCurrentRowAsStruct().getBooleanArray(columnIndex);
    }

    @Override
    public boolean[] getBooleanArray(String columnName) {
      return getCurrentRowAsStruct().getBooleanArray(columnName);
    }

    @Override
    public List<Boolean> getBooleanList(int columnIndex) {
      return getCurrentRowAsStruct().getBooleanList(columnIndex);
    }

    @Override
    public List<Boolean> getBooleanList(String columnName) {
      return getCurrentRowAsStruct().getBooleanList(columnName);
    }

    @Override
    public long[] getLongArray(int columnIndex) {
      return getCurrentRowAsStruct().getLongArray(columnIndex);
    }

    @Override
    public long[] getLongArray(String columnName) {
      return getCurrentRowAsStruct().getLongArray(columnName);
    }

    @Override
    public List<Long> getLongList(int columnIndex) {
      return getCurrentRowAsStruct().getLongList(columnIndex);
    }

    @Override
    public List<Long> getLongList(String columnName) {
      return getCurrentRowAsStruct().getLongList(columnName);
    }

    @Override
    public float[] getFloatArray(int columnIndex) {
      return getCurrentRowAsStruct().getFloatArray(columnIndex);
    }

    @Override
    public float[] getFloatArray(String columnName) {
      return getCurrentRowAsStruct().getFloatArray(columnName);
    }

    @Override
    public List<Float> getFloatList(int columnIndex) {
      return getCurrentRowAsStruct().getFloatList(columnIndex);
    }

    @Override
    public List<Float> getFloatList(String columnName) {
      return getCurrentRowAsStruct().getFloatList(columnName);
    }

    @Override
    public double[] getDoubleArray(int columnIndex) {
      return getCurrentRowAsStruct().getDoubleArray(columnIndex);
    }

    @Override
    public double[] getDoubleArray(String columnName) {
      return getCurrentRowAsStruct().getDoubleArray(columnName);
    }

    @Override
    public List<Double> getDoubleList(int columnIndex) {
      return getCurrentRowAsStruct().getDoubleList(columnIndex);
    }

    @Override
    public List<Double> getDoubleList(String columnName) {
      return getCurrentRowAsStruct().getDoubleList(columnName);
    }

    @Override
    public List<BigDecimal> getBigDecimalList(int columnIndex) {
      return getCurrentRowAsStruct().getBigDecimalList(columnIndex);
    }

    @Override
    public List<BigDecimal> getBigDecimalList(String columnName) {
      return getCurrentRowAsStruct().getBigDecimalList(columnName);
    }

    @Override
    public List<String> getStringList(int columnIndex) {
      return getCurrentRowAsStruct().getStringList(columnIndex);
    }

    @Override
    public List<String> getStringList(String columnName) {
      return getCurrentRowAsStruct().getStringList(columnName);
    }

    @Override
    public List<String> getJsonList(int columnIndex) {
      return getCurrentRowAsStruct().getJsonList(columnIndex);
    }

    @Override
    public List<String> getJsonList(String columnName) {
      return getCurrentRowAsStruct().getJsonList(columnName);
    }

    @Override
    public List<String> getPgJsonbList(int columnIndex) {
      return getCurrentRowAsStruct().getPgJsonbList(columnIndex);
    }

    @Override
    public List<String> getPgJsonbList(String columnName) {
      return getCurrentRowAsStruct().getPgJsonbList(columnName);
    }

    @Override
    public List<ByteArray> getBytesList(int columnIndex) {
      return getCurrentRowAsStruct().getBytesList(columnIndex);
    }

    @Override
    public List<ByteArray> getBytesList(String columnName) {
      return getCurrentRowAsStruct().getBytesList(columnName);
    }

    @Override
    public List<Timestamp> getTimestampList(int columnIndex) {
      return getCurrentRowAsStruct().getTimestampList(columnIndex);
    }

    @Override
    public List<Timestamp> getTimestampList(String columnName) {
      return getCurrentRowAsStruct().getTimestampList(columnName);
    }

    @Override
    public List<Date> getDateList(int columnIndex) {
      return getCurrentRowAsStruct().getDateList(columnIndex);
    }

    @Override
    public List<Date> getDateList(String columnName) {
      return getCurrentRowAsStruct().getDateList(columnName);
    }

    @Override
    public List<UUID> getUuidList(int columnIndex) {
      return getCurrentRowAsStruct().getUuidList(columnIndex);
    }

    @Override
    public List<UUID> getUuidList(String columnName) {
      return getCurrentRowAsStruct().getUuidList(columnName);
    }

    @Override
    public List<Interval> getIntervalList(int columnIndex) {
      return getCurrentRowAsStruct().getIntervalList(columnIndex);
    }

    @Override
    public List<Interval> getIntervalList(String columnName) {
      return getCurrentRowAsStruct().getIntervalList(columnName);
    }

    @Override
    public <T extends AbstractMessage> List<T> getProtoMessageList(int columnIndex, T message) {
      return getCurrentRowAsStruct().getProtoMessageList(columnIndex, message);
    }

    @Override
    public <T extends AbstractMessage> List<T> getProtoMessageList(String columnName, T message) {
      return getCurrentRowAsStruct().getProtoMessageList(columnName, message);
    }

    @Override
    public <T extends ProtocolMessageEnum> List<T> getProtoEnumList(
        int columnIndex, Function<Integer, ProtocolMessageEnum> method) {
      return getCurrentRowAsStruct().getProtoEnumList(columnIndex, method);
    }

    @Override
    public <T extends ProtocolMessageEnum> List<T> getProtoEnumList(
        String columnName, Function<Integer, ProtocolMessageEnum> method) {
      return getCurrentRowAsStruct().getProtoEnumList(columnName, method);
    }

    @Override
    public List<Struct> getStructList(int columnIndex) {
      return getCurrentRowAsStruct().getStructList(columnIndex);
    }

    @Override
    public List<Struct> getStructList(String columnName) {
      return getCurrentRowAsStruct().getStructList(columnName);
    }
  }
}
