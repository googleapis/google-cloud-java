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
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Interval;
import com.google.cloud.spanner.ProtobufResultSet;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
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
 * Forwarding implementation of {@link ResultSet} that forwards all calls to a delegate that can be
 * replaced. This is used by the JDBC Driver when a read/write transaction is successfully retried.
 * Any {@link ResultSet} that is open during a transaction retry, must be replaced by a result set
 * that is fetched using the new transaction. This is achieved by wrapping the returned result sets
 * in a {@link ReplaceableForwardingResultSet} that replaces its delegate after a transaction retry.
 */
class ReplaceableForwardingResultSet implements ProtobufResultSet {
  private ResultSet delegate;
  private boolean closed;

  ReplaceableForwardingResultSet(ResultSet delegate) {
    this.delegate = Preconditions.checkNotNull(delegate);
  }

  /** Replace the underlying delegate {@link ResultSet} with a new one. */
  void replaceDelegate(ResultSet delegate) {
    Preconditions.checkNotNull(delegate);
    checkClosed();
    if (this.delegate != null) {
      this.delegate.close();
    }
    this.delegate = delegate;
  }

  protected ResultSet getDelegate() {
    return this.delegate;
  }

  private void checkClosed() {
    if (closed) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.FAILED_PRECONDITION, "This ResultSet is closed");
    }
  }

  boolean isClosed() {
    return closed;
  }

  @Override
  public boolean next() throws SpannerException {
    checkClosed();
    return delegate.next();
  }

  @Override
  public boolean canGetProtobufValue(int columnIndex) {
    return !closed
        && delegate instanceof ProtobufResultSet
        && ((ProtobufResultSet) delegate).canGetProtobufValue(columnIndex);
  }

  @Override
  public com.google.protobuf.Value getProtobufValue(int columnIndex) {
    checkClosed();
    Preconditions.checkState(
        delegate instanceof ProtobufResultSet, "The result set does not support protobuf values");
    return ((ProtobufResultSet) getDelegate()).getProtobufValue(columnIndex);
  }

  @Override
  public Struct getCurrentRowAsStruct() {
    checkClosed();
    return delegate.getCurrentRowAsStruct();
  }

  @Override
  public void close() {
    if (delegate != null) {
      delegate.close();
      delegate = null;
    }
    closed = true;
  }

  @Override
  public ResultSetStats getStats() {
    checkClosed();
    return delegate.getStats();
  }

  @Override
  public ResultSetMetadata getMetadata() {
    return delegate.getMetadata();
  }

  @Override
  public Type getType() {
    checkClosed();
    return delegate.getType();
  }

  @Override
  public int getColumnCount() {
    checkClosed();
    return delegate.getColumnCount();
  }

  @Override
  public int getColumnIndex(String columnName) {
    checkClosed();
    return delegate.getColumnIndex(columnName);
  }

  @Override
  public Type getColumnType(int columnIndex) {
    checkClosed();
    return delegate.getColumnType(columnIndex);
  }

  @Override
  public Type getColumnType(String columnName) {
    checkClosed();
    return delegate.getColumnType(columnName);
  }

  @Override
  public boolean isNull(int columnIndex) {
    checkClosed();
    return delegate.isNull(columnIndex);
  }

  @Override
  public boolean isNull(String columnName) {
    checkClosed();
    return delegate.isNull(columnName);
  }

  @Override
  public boolean getBoolean(int columnIndex) {
    checkClosed();
    return delegate.getBoolean(columnIndex);
  }

  @Override
  public boolean getBoolean(String columnName) {
    checkClosed();
    return delegate.getBoolean(columnName);
  }

  @Override
  public long getLong(int columnIndex) {
    checkClosed();
    return delegate.getLong(columnIndex);
  }

  @Override
  public long getLong(String columnName) {
    checkClosed();
    return delegate.getLong(columnName);
  }

  @Override
  public float getFloat(int columnIndex) {
    checkClosed();
    return delegate.getFloat(columnIndex);
  }

  @Override
  public float getFloat(String columnName) {
    checkClosed();
    return delegate.getFloat(columnName);
  }

  @Override
  public double getDouble(int columnIndex) {
    checkClosed();
    return delegate.getDouble(columnIndex);
  }

  @Override
  public double getDouble(String columnName) {
    checkClosed();
    return delegate.getDouble(columnName);
  }

  @Override
  public BigDecimal getBigDecimal(int columnIndex) {
    checkClosed();
    return delegate.getBigDecimal(columnIndex);
  }

  @Override
  public BigDecimal getBigDecimal(String columnName) {
    checkClosed();
    return delegate.getBigDecimal(columnName);
  }

  @Override
  public String getString(int columnIndex) {
    checkClosed();
    return delegate.getString(columnIndex);
  }

  @Override
  public String getString(String columnName) {
    checkClosed();
    return delegate.getString(columnName);
  }

  @Override
  public String getJson(int columnIndex) {
    checkClosed();
    return delegate.getJson(columnIndex);
  }

  @Override
  public String getJson(String columnName) {
    checkClosed();
    return delegate.getJson(columnName);
  }

  @Override
  public String getPgJsonb(int columnIndex) {
    checkClosed();
    return delegate.getPgJsonb(columnIndex);
  }

  @Override
  public String getPgJsonb(String columnName) {
    checkClosed();
    return delegate.getPgJsonb(columnName);
  }

  @Override
  public ByteArray getBytes(int columnIndex) {
    checkClosed();
    return delegate.getBytes(columnIndex);
  }

  @Override
  public ByteArray getBytes(String columnName) {
    checkClosed();
    return delegate.getBytes(columnName);
  }

  @Override
  public Timestamp getTimestamp(int columnIndex) {
    checkClosed();
    return delegate.getTimestamp(columnIndex);
  }

  @Override
  public Timestamp getTimestamp(String columnName) {
    checkClosed();
    return delegate.getTimestamp(columnName);
  }

  @Override
  public Date getDate(int columnIndex) {
    checkClosed();
    return delegate.getDate(columnIndex);
  }

  @Override
  public UUID getUuid(int columnIndex) {
    checkClosed();
    return delegate.getUuid(columnIndex);
  }

  @Override
  public Date getDate(String columnName) {
    checkClosed();
    return delegate.getDate(columnName);
  }

  @Override
  public UUID getUuid(String columnName) {
    checkClosed();
    return delegate.getUuid(columnName);
  }

  @Override
  public Interval getInterval(int columnIndex) {
    checkClosed();
    return delegate.getInterval(columnIndex);
  }

  @Override
  public Interval getInterval(String columnName) {
    checkClosed();
    return delegate.getInterval(columnName);
  }

  @Override
  public Value getValue(int columnIndex) {
    checkClosed();
    return delegate.getValue(columnIndex);
  }

  @Override
  public Value getValue(String columnName) {
    checkClosed();
    return delegate.getValue(columnName);
  }

  @Override
  public boolean[] getBooleanArray(int columnIndex) {
    checkClosed();
    return delegate.getBooleanArray(columnIndex);
  }

  @Override
  public boolean[] getBooleanArray(String columnName) {
    checkClosed();
    return delegate.getBooleanArray(columnName);
  }

  @Override
  public List<Boolean> getBooleanList(int columnIndex) {
    checkClosed();
    return delegate.getBooleanList(columnIndex);
  }

  @Override
  public List<Boolean> getBooleanList(String columnName) {
    checkClosed();
    return delegate.getBooleanList(columnName);
  }

  @Override
  public long[] getLongArray(int columnIndex) {
    checkClosed();
    return delegate.getLongArray(columnIndex);
  }

  @Override
  public long[] getLongArray(String columnName) {
    checkClosed();
    return delegate.getLongArray(columnName);
  }

  @Override
  public List<Long> getLongList(int columnIndex) {
    checkClosed();
    return delegate.getLongList(columnIndex);
  }

  @Override
  public List<Long> getLongList(String columnName) {
    checkClosed();
    return delegate.getLongList(columnName);
  }

  @Override
  public float[] getFloatArray(int columnIndex) {
    checkClosed();
    return delegate.getFloatArray(columnIndex);
  }

  @Override
  public float[] getFloatArray(String columnName) {
    checkClosed();
    return delegate.getFloatArray(columnName);
  }

  @Override
  public List<Float> getFloatList(int columnIndex) {
    checkClosed();
    return delegate.getFloatList(columnIndex);
  }

  @Override
  public List<Float> getFloatList(String columnName) {
    checkClosed();
    return delegate.getFloatList(columnName);
  }

  @Override
  public double[] getDoubleArray(int columnIndex) {
    checkClosed();
    return delegate.getDoubleArray(columnIndex);
  }

  @Override
  public double[] getDoubleArray(String columnName) {
    checkClosed();
    return delegate.getDoubleArray(columnName);
  }

  @Override
  public List<Double> getDoubleList(int columnIndex) {
    checkClosed();
    return delegate.getDoubleList(columnIndex);
  }

  @Override
  public List<Double> getDoubleList(String columnName) {
    checkClosed();
    return delegate.getDoubleList(columnName);
  }

  @Override
  public List<BigDecimal> getBigDecimalList(int columnIndex) {
    checkClosed();
    return delegate.getBigDecimalList(columnIndex);
  }

  @Override
  public List<BigDecimal> getBigDecimalList(String columnName) {
    checkClosed();
    return delegate.getBigDecimalList(columnName);
  }

  @Override
  public List<String> getStringList(int columnIndex) {
    checkClosed();
    return delegate.getStringList(columnIndex);
  }

  @Override
  public List<String> getStringList(String columnName) {
    checkClosed();
    return delegate.getStringList(columnName);
  }

  @Override
  public List<String> getJsonList(int columnIndex) {
    checkClosed();
    return delegate.getJsonList(columnIndex);
  }

  @Override
  public List<String> getJsonList(String columnName) {
    checkClosed();
    return delegate.getJsonList(columnName);
  }

  @Override
  public List<String> getPgJsonbList(int columnIndex) {
    checkClosed();
    return delegate.getPgJsonbList(columnIndex);
  }

  @Override
  public List<String> getPgJsonbList(String columnName) {
    checkClosed();
    return delegate.getPgJsonbList(columnName);
  }

  @Override
  public List<ByteArray> getBytesList(int columnIndex) {
    checkClosed();
    return delegate.getBytesList(columnIndex);
  }

  @Override
  public List<ByteArray> getBytesList(String columnName) {
    checkClosed();
    return delegate.getBytesList(columnName);
  }

  @Override
  public List<Timestamp> getTimestampList(int columnIndex) {
    checkClosed();
    return delegate.getTimestampList(columnIndex);
  }

  @Override
  public List<Timestamp> getTimestampList(String columnName) {
    checkClosed();
    return delegate.getTimestampList(columnName);
  }

  @Override
  public List<Date> getDateList(int columnIndex) {
    checkClosed();
    return delegate.getDateList(columnIndex);
  }

  @Override
  public List<Date> getDateList(String columnName) {
    checkClosed();
    return delegate.getDateList(columnName);
  }

  @Override
  public List<UUID> getUuidList(int columnIndex) {
    checkClosed();
    return delegate.getUuidList(columnIndex);
  }

  @Override
  public List<UUID> getUuidList(String columnName) {
    checkClosed();
    return delegate.getUuidList(columnName);
  }

  @Override
  public List<Interval> getIntervalList(int columnIndex) {
    checkClosed();
    return delegate.getIntervalList(columnIndex);
  }

  @Override
  public List<Interval> getIntervalList(String columnName) {
    checkClosed();
    return delegate.getIntervalList(columnName);
  }

  @Override
  public <T extends AbstractMessage> List<T> getProtoMessageList(int columnIndex, T message) {
    checkClosed();
    return delegate.getProtoMessageList(columnIndex, message);
  }

  @Override
  public <T extends AbstractMessage> List<T> getProtoMessageList(String columnName, T message) {
    checkClosed();
    return delegate.getProtoMessageList(columnName, message);
  }

  @Override
  public <T extends ProtocolMessageEnum> List<T> getProtoEnumList(
      int columnIndex, Function<Integer, ProtocolMessageEnum> method) {
    checkClosed();
    return delegate.getProtoEnumList(columnIndex, method);
  }

  @Override
  public <T extends ProtocolMessageEnum> List<T> getProtoEnumList(
      String columnName, Function<Integer, ProtocolMessageEnum> method) {
    checkClosed();
    return delegate.getProtoEnumList(columnName, method);
  }

  @Override
  public List<Struct> getStructList(int columnIndex) {
    checkClosed();
    return delegate.getStructList(columnIndex);
  }

  @Override
  public List<Struct> getStructList(String columnName) {
    checkClosed();
    return delegate.getStructList(columnName);
  }

  @Override
  public <T extends AbstractMessage> T getProtoMessage(int columnIndex, T message) {
    checkClosed();
    return delegate.getProtoMessage(columnIndex, message);
  }

  @Override
  public <T extends AbstractMessage> T getProtoMessage(String columnName, T message) {
    checkClosed();
    return delegate.getProtoMessage(columnName, message);
  }

  @Override
  public <T extends ProtocolMessageEnum> T getProtoEnum(
      int columnIndex, Function<Integer, ProtocolMessageEnum> method) {
    checkClosed();
    return delegate.getProtoEnum(columnIndex, method);
  }

  @Override
  public <T extends ProtocolMessageEnum> T getProtoEnum(
      String columnName, Function<Integer, ProtocolMessageEnum> method) {
    checkClosed();
    return delegate.getProtoEnum(columnName, method);
  }
}
