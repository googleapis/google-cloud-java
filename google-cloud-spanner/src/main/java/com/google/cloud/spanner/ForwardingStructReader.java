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

import com.google.cloud.ByteArray;
import com.google.common.base.Preconditions;
import java.util.List;

/** Forwarding implements of StructReader */
public class ForwardingStructReader implements StructReader {

  private final StructReader delegate;

  public ForwardingStructReader(StructReader delegate) {
    this.delegate = Preconditions.checkNotNull(delegate);
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
    return delegate.isNull(columnIndex);
  }

  @Override
  public boolean isNull(String columnName) {
    return delegate.isNull(columnName);
  }

  @Override
  public boolean getBoolean(int columnIndex) {
    return delegate.getBoolean(columnIndex);
  }

  @Override
  public boolean getBoolean(String columnName) {
    return delegate.getBoolean(columnName);
  }

  @Override
  public long getLong(int columnIndex) {
    return delegate.getLong(columnIndex);
  }

  @Override
  public long getLong(String columnName) {
    return delegate.getLong(columnName);
  }

  @Override
  public double getDouble(int columnIndex) {
    return delegate.getDouble(columnIndex);
  }

  @Override
  public double getDouble(String columnName) {
    return delegate.getDouble(columnName);
  }

  @Override
  public String getString(int columnIndex) {
    return delegate.getString(columnIndex);
  }

  @Override
  public String getString(String columnName) {
    return delegate.getString(columnName);
  }

  @Override
  public ByteArray getBytes(int columnIndex) {
    return delegate.getBytes(columnIndex);
  }

  @Override
  public ByteArray getBytes(String columnName) {
    return delegate.getBytes(columnName);
  }

  @Override
  public Timestamp getTimestamp(int columnIndex) {
    return delegate.getTimestamp(columnIndex);
  }

  @Override
  public Timestamp getTimestamp(String columnName) {
    return delegate.getTimestamp(columnName);
  }

  @Override
  public Date getDate(int columnIndex) {
    return delegate.getDate(columnIndex);
  }

  @Override
  public Date getDate(String columnName) {
    return delegate.getDate(columnName);
  }

  @Override
  public boolean[] getBooleanArray(int columnIndex) {
    return delegate.getBooleanArray(columnIndex);
  }

  @Override
  public boolean[] getBooleanArray(String columnName) {
    return delegate.getBooleanArray(columnName);
  }

  @Override
  public List<Boolean> getBooleanList(int columnIndex) {
    return delegate.getBooleanList(columnIndex);
  }

  @Override
  public List<Boolean> getBooleanList(String columnName) {
    return delegate.getBooleanList(columnName);
  }

  @Override
  public long[] getLongArray(int columnIndex) {
    return delegate.getLongArray(columnIndex);
  }

  @Override
  public long[] getLongArray(String columnName) {
    return delegate.getLongArray(columnName);
  }

  @Override
  public List<Long> getLongList(int columnIndex) {
    return delegate.getLongList(columnIndex);
  }

  @Override
  public List<Long> getLongList(String columnName) {
    return delegate.getLongList(columnName);
  }

  @Override
  public double[] getDoubleArray(int columnIndex) {
    return delegate.getDoubleArray(columnIndex);
  }

  @Override
  public double[] getDoubleArray(String columnName) {
    return delegate.getDoubleArray(columnName);
  }

  @Override
  public List<Double> getDoubleList(int columnIndex) {
    return delegate.getDoubleList(columnIndex);
  }

  @Override
  public List<Double> getDoubleList(String columnName) {
    return delegate.getDoubleList(columnName);
  }

  @Override
  public List<String> getStringList(int columnIndex) {
    return delegate.getStringList(columnIndex);
  }

  @Override
  public List<String> getStringList(String columnName) {
    return delegate.getStringList(columnName);
  }

  @Override
  public List<ByteArray> getBytesList(int columnIndex) {
    return delegate.getBytesList(columnIndex);
  }

  @Override
  public List<ByteArray> getBytesList(String columnName) {
    return delegate.getBytesList(columnName);
  }

  @Override
  public List<Timestamp> getTimestampList(int columnIndex) {
    return delegate.getTimestampList(columnIndex);
  }

  @Override
  public List<Timestamp> getTimestampList(String columnName) {
    return delegate.getTimestampList(columnName);
  }

  @Override
  public List<Date> getDateList(int columnIndex) {
    return delegate.getDateList(columnIndex);
  }

  @Override
  public List<Date> getDateList(String columnName) {
    return delegate.getDateList(columnName);
  }

  @Override
  public List<Struct> getStructList(int columnIndex) {
    return delegate.getStructList(columnIndex);
  }

  @Override
  public List<Struct> getStructList(String columnName) {
    return delegate.getStructList(columnName);
  }
}
