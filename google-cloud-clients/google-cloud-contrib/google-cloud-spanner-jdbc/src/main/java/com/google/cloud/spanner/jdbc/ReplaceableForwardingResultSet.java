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

package com.google.cloud.spanner.jdbc;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Type;
import com.google.common.base.Preconditions;
import com.google.spanner.v1.ResultSetStats;
import java.util.List;

/**
 * Forwarding implementation of {@link ResultSet} that forwards all calls to a delegate that can be
 * replaced. This is used by the JDBC Driver when a read/write transaction is successfully retried.
 * Any {@link ResultSet} that is open during a transaction retry, must be replaced by a result set
 * that is fetched using the new transaction. This is achieved by wrapping the returned result sets
 * in a {@link ReplaceableForwardingResultSet} that replaces its delegate after a transaction retry.
 */
class ReplaceableForwardingResultSet implements ResultSet {
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
  public Date getDate(String columnName) {
    checkClosed();
    return delegate.getDate(columnName);
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
  public List<Struct> getStructList(int columnIndex) {
    checkClosed();
    return delegate.getStructList(columnIndex);
  }

  @Override
  public List<Struct> getStructList(String columnName) {
    checkClosed();
    return delegate.getStructList(columnName);
  }
}
