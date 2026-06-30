/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.connection;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Interval;
import com.google.cloud.spanner.ProtobufResultSet;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Value;
import com.google.common.base.Preconditions;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

/**
 * {@link ResultSet} implementation used by the Spanner connection API to ensure that the query for
 * a {@link ResultSet} is executed directly when it is created. This is done by calling {@link
 * ResultSet#next()} directly after creation. This ensures that a statement timeout can be applied
 * to the actual query execution. It also ensures that any invalid query will throw an exception at
 * execution instead of the first next() call by a client.
 */
class DirectExecuteResultSet implements ProtobufResultSet {
  private static final String MISSING_NEXT_CALL = "Must be preceded by a next() call";
  private final ResultSet delegate;
  private boolean nextCalledByClient = false;
  private final boolean initialNextResult;
  private boolean nextHasReturnedFalse = false;

  /**
   * Creates a new {@link DirectExecuteResultSet} from the given delegate {@link ResultSet}. This
   * automatically executes the query of the given delegate {@link ResultSet} by calling next() on
   * the delegate. The delegate must not have been used (i.e. next() must not have been called on
   * it).
   *
   * @param delegate The underlying {@link ResultSet} for this {@link DirectExecuteResultSet}.
   * @return a {@link DirectExecuteResultSet} that has already executed the query associated with
   *     the delegate {@link ResultSet}.
   */
  static DirectExecuteResultSet ofResultSet(ResultSet delegate) {
    return new DirectExecuteResultSet(delegate);
  }

  DirectExecuteResultSet(ResultSet delegate) {
    Preconditions.checkNotNull(delegate);
    this.delegate = delegate;
    initialNextResult = delegate.next();
  }

  @Override
  public boolean next() throws SpannerException {
    if (nextCalledByClient) {
      boolean res = delegate.next();
      nextHasReturnedFalse = !res;
      return res;
    }
    nextCalledByClient = true;
    nextHasReturnedFalse = !initialNextResult;
    return initialNextResult;
  }

  @Override
  public boolean canGetProtobufValue(int columnIndex) {
    return nextCalledByClient
        && delegate instanceof ProtobufResultSet
        && ((ProtobufResultSet) delegate).canGetProtobufValue(columnIndex);
  }

  @Override
  public com.google.protobuf.Value getProtobufValue(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    Preconditions.checkState(
        delegate instanceof ProtobufResultSet, "The result set does not support protobuf values");
    return ((ProtobufResultSet) delegate).getProtobufValue(columnIndex);
  }

  @Override
  public Struct getCurrentRowAsStruct() {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getCurrentRowAsStruct();
  }

  @Override
  public void close() {
    delegate.close();
  }

  @Override
  public ResultSetStats getStats() {
    if (nextHasReturnedFalse) {
      return delegate.getStats();
    }
    return null;
  }

  @Override
  public ResultSetMetadata getMetadata() {
    return delegate.getMetadata();
  }

  @Override
  public Type getType() {
    return delegate.getType();
  }

  @Override
  public int getColumnCount() {
    return delegate.getColumnCount();
  }

  @Override
  public int getColumnIndex(String columnName) {
    return delegate.getColumnIndex(columnName);
  }

  @Override
  public Type getColumnType(int columnIndex) {
    return delegate.getColumnType(columnIndex);
  }

  @Override
  public Type getColumnType(String columnName) {
    return delegate.getColumnType(columnName);
  }

  @Override
  public boolean isNull(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.isNull(columnIndex);
  }

  @Override
  public boolean isNull(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.isNull(columnName);
  }

  @Override
  public boolean getBoolean(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getBoolean(columnIndex);
  }

  @Override
  public boolean getBoolean(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getBoolean(columnName);
  }

  @Override
  public long getLong(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getLong(columnIndex);
  }

  @Override
  public long getLong(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getLong(columnName);
  }

  @Override
  public float getFloat(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getFloat(columnIndex);
  }

  @Override
  public double getDouble(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getDouble(columnIndex);
  }

  @Override
  public BigDecimal getBigDecimal(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getBigDecimal(columnName);
  }

  @Override
  public BigDecimal getBigDecimal(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getBigDecimal(columnIndex);
  }

  @Override
  public float getFloat(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getFloat(columnName);
  }

  @Override
  public double getDouble(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getDouble(columnName);
  }

  @Override
  public String getString(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getString(columnIndex);
  }

  @Override
  public String getString(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getString(columnName);
  }

  @Override
  public String getJson(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getJson(columnIndex);
  }

  @Override
  public String getJson(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getJson(columnName);
  }

  @Override
  public String getPgJsonb(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getPgJsonb(columnIndex);
  }

  @Override
  public String getPgJsonb(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getPgJsonb(columnName);
  }

  @Override
  public ByteArray getBytes(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getBytes(columnIndex);
  }

  @Override
  public ByteArray getBytes(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getBytes(columnName);
  }

  @Override
  public Timestamp getTimestamp(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getTimestamp(columnIndex);
  }

  @Override
  public Timestamp getTimestamp(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getTimestamp(columnName);
  }

  @Override
  public Date getDate(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getDate(columnIndex);
  }

  @Override
  public Date getDate(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getDate(columnName);
  }

  @Override
  public UUID getUuid(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getUuid(columnIndex);
  }

  @Override
  public UUID getUuid(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getUuid(columnName);
  }

  @Override
  public Interval getInterval(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getInterval(columnIndex);
  }

  @Override
  public Interval getInterval(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getInterval(columnName);
  }

  @Override
  public Value getValue(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getValue(columnIndex);
  }

  @Override
  public Value getValue(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getValue(columnName);
  }

  @Override
  public boolean[] getBooleanArray(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getBooleanArray(columnIndex);
  }

  @Override
  public boolean[] getBooleanArray(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getBooleanArray(columnName);
  }

  @Override
  public List<Boolean> getBooleanList(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getBooleanList(columnIndex);
  }

  @Override
  public List<Boolean> getBooleanList(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getBooleanList(columnName);
  }

  @Override
  public long[] getLongArray(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getLongArray(columnIndex);
  }

  @Override
  public long[] getLongArray(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getLongArray(columnName);
  }

  @Override
  public List<Long> getLongList(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getLongList(columnIndex);
  }

  @Override
  public List<Long> getLongList(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getLongList(columnName);
  }

  @Override
  public float[] getFloatArray(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getFloatArray(columnIndex);
  }

  @Override
  public float[] getFloatArray(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getFloatArray(columnName);
  }

  @Override
  public List<Float> getFloatList(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getFloatList(columnIndex);
  }

  @Override
  public List<Float> getFloatList(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getFloatList(columnName);
  }

  @Override
  public double[] getDoubleArray(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getDoubleArray(columnIndex);
  }

  @Override
  public double[] getDoubleArray(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getDoubleArray(columnName);
  }

  @Override
  public List<Double> getDoubleList(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getDoubleList(columnIndex);
  }

  @Override
  public List<Double> getDoubleList(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getDoubleList(columnName);
  }

  @Override
  public List<BigDecimal> getBigDecimalList(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getBigDecimalList(columnIndex);
  }

  @Override
  public List<BigDecimal> getBigDecimalList(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getBigDecimalList(columnName);
  }

  @Override
  public List<String> getStringList(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getStringList(columnIndex);
  }

  @Override
  public List<String> getStringList(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getStringList(columnName);
  }

  @Override
  public List<String> getJsonList(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getJsonList(columnIndex);
  }

  @Override
  public List<String> getJsonList(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getJsonList(columnName);
  }

  @Override
  public List<String> getPgJsonbList(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getPgJsonbList(columnIndex);
  }

  @Override
  public List<String> getPgJsonbList(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getPgJsonbList(columnName);
  }

  @Override
  public List<ByteArray> getBytesList(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getBytesList(columnIndex);
  }

  @Override
  public List<ByteArray> getBytesList(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getBytesList(columnName);
  }

  @Override
  public List<Timestamp> getTimestampList(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getTimestampList(columnIndex);
  }

  @Override
  public List<Timestamp> getTimestampList(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getTimestampList(columnName);
  }

  @Override
  public List<Date> getDateList(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getDateList(columnIndex);
  }

  @Override
  public List<Date> getDateList(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getDateList(columnName);
  }

  @Override
  public List<UUID> getUuidList(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getUuidList(columnIndex);
  }

  @Override
  public List<UUID> getUuidList(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getUuidList(columnName);
  }

  @Override
  public List<Interval> getIntervalList(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getIntervalList(columnIndex);
  }

  @Override
  public List<Interval> getIntervalList(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getIntervalList(columnName);
  }

  @Override
  public <T extends AbstractMessage> List<T> getProtoMessageList(int columnIndex, T message) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getProtoMessageList(columnIndex, message);
  }

  @Override
  public <T extends AbstractMessage> List<T> getProtoMessageList(String columnName, T message) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getProtoMessageList(columnName, message);
  }

  @Override
  public <T extends ProtocolMessageEnum> List<T> getProtoEnumList(
      int columnIndex, Function<Integer, ProtocolMessageEnum> method) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getProtoEnumList(columnIndex, method);
  }

  @Override
  public <T extends ProtocolMessageEnum> List<T> getProtoEnumList(
      String columnName, Function<Integer, ProtocolMessageEnum> method) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getProtoEnumList(columnName, method);
  }

  @Override
  public List<Struct> getStructList(int columnIndex) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getStructList(columnIndex);
  }

  @Override
  public List<Struct> getStructList(String columnName) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getStructList(columnName);
  }

  @Override
  public <T extends ProtocolMessageEnum> T getProtoEnum(
      int columnIndex, Function<Integer, ProtocolMessageEnum> method) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getProtoEnum(columnIndex, method);
  }

  @Override
  public <T extends ProtocolMessageEnum> T getProtoEnum(
      String columnName, Function<Integer, ProtocolMessageEnum> method) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getProtoEnum(columnName, method);
  }

  @Override
  public <T extends AbstractMessage> T getProtoMessage(int columnIndex, T message) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getProtoMessage(columnIndex, message);
  }

  @Override
  public <T extends AbstractMessage> T getProtoMessage(String columnName, T message) {
    Preconditions.checkState(nextCalledByClient, MISSING_NEXT_CALL);
    return delegate.getProtoMessage(columnName, message);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof DirectExecuteResultSet)) {
      return false;
    }
    return ((DirectExecuteResultSet) o).delegate.equals(delegate);
  }

  @Override
  public int hashCode() {
    return delegate.hashCode();
  }
}
