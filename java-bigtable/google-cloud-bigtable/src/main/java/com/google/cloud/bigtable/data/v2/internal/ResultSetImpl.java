/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.internal;

import com.google.api.core.ApiFuture;
import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.Date;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSet;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import com.google.cloud.bigtable.data.v2.models.sql.Struct;
import com.google.cloud.bigtable.data.v2.models.sql.StructReader;
import com.google.cloud.bigtable.data.v2.stub.sql.SqlServerStream;
import com.google.common.base.Preconditions;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.ProtocolMessageEnum;
import java.time.Instant;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * The primary implementation of a ResultSet.
 *
 * <p>This passes through StructReader calls to each row rather than implementing
 * AbstractProtoStructReader directly so that it can support different types of rows in the future.
 *
 * <p>This is considered an internal implementation detail and not meant to be used by applications.
 */
@InternalApi("For internal use only")
public class ResultSetImpl implements ResultSet, StructReader {

  private final ServerStream<SqlRow> serverStream;
  private final Iterator<SqlRow> rowIterator;
  private final ApiFuture<ResultSetMetadata> metadataApiFuture;
  private boolean consumed;
  private SqlRow currentRow;

  public static ResultSet create(SqlServerStream sqlServerStream) {
    return new ResultSetImpl(sqlServerStream);
  }

  private ResultSetImpl(SqlServerStream sqlServerStream) {
    this.serverStream = sqlServerStream.rows();
    this.rowIterator = serverStream.iterator();
    this.metadataApiFuture = sqlServerStream.metadataFuture();
    this.consumed = false;
  }

  private SqlRow getCurrentRow() {
    Preconditions.checkState(!consumed, "Attempted to access data from closed ResultSet");
    Preconditions.checkState(currentRow != null, "Attempted to access data before calling next()");
    return currentRow;
  }

  @Override
  public boolean next() {
    if (consumed) {
      return false;
    }
    boolean hasNext = rowIterator.hasNext();
    if (hasNext) {
      currentRow = rowIterator.next();
    } else {
      consumed = true;
    }
    return hasNext;
  }

  @Override
  public ResultSetMetadata getMetadata() {
    return ApiExceptions.callAndTranslateApiException(metadataApiFuture);
  }

  @Override
  public void close() {
    // If the stream has been consumed we don't want to cancel because it could
    // cancel the request before it receives response trailers.
    if (!consumed) {
      serverStream.cancel();
    }
    consumed = true;
  }

  @Override
  public boolean isNull(int columnIndex) {
    return getCurrentRow().isNull(columnIndex);
  }

  @Override
  public boolean isNull(String columnName) {
    return getCurrentRow().isNull(columnName);
  }

  @Override
  public ByteString getBytes(int columnIndex) {
    return getCurrentRow().getBytes(columnIndex);
  }

  @Override
  public ByteString getBytes(String columnName) {
    return getCurrentRow().getBytes(columnName);
  }

  @Override
  public String getString(int columnIndex) {
    return getCurrentRow().getString(columnIndex);
  }

  @Override
  public String getString(String columnName) {
    return getCurrentRow().getString(columnName);
  }

  @Override
  public long getLong(int columnIndex) {
    return getCurrentRow().getLong(columnIndex);
  }

  @Override
  public long getLong(String columnName) {
    return getCurrentRow().getLong(columnName);
  }

  @Override
  public double getDouble(int columnIndex) {
    return getCurrentRow().getDouble(columnIndex);
  }

  @Override
  public double getDouble(String columnName) {
    return getCurrentRow().getDouble(columnName);
  }

  @Override
  public float getFloat(int columnIndex) {
    return getCurrentRow().getFloat(columnIndex);
  }

  @Override
  public float getFloat(String columnName) {
    return getCurrentRow().getFloat(columnName);
  }

  @Override
  public boolean getBoolean(int columnIndex) {
    return getCurrentRow().getBoolean(columnIndex);
  }

  @Override
  public boolean getBoolean(String columnName) {
    return getCurrentRow().getBoolean(columnName);
  }

  @Override
  public Instant getTimestamp(int columnIndex) {
    return getCurrentRow().getTimestamp(columnIndex);
  }

  @Override
  public Instant getTimestamp(String columnName) {
    return getCurrentRow().getTimestamp(columnName);
  }

  @Override
  public Date getDate(int columnIndex) {
    return getCurrentRow().getDate(columnIndex);
  }

  @Override
  public Date getDate(String columnName) {
    return getCurrentRow().getDate(columnName);
  }

  @Override
  public Struct getStruct(int columnIndex) {
    return getCurrentRow().getStruct(columnIndex);
  }

  @Override
  public Struct getStruct(String columnName) {
    return getCurrentRow().getStruct(columnName);
  }

  @Override
  public <ElemType> List<ElemType> getList(int columnIndex, SqlType.Array<ElemType> arrayType) {
    return getCurrentRow().getList(columnIndex, arrayType);
  }

  @Override
  public <ElemType> List<ElemType> getList(String columnName, SqlType.Array<ElemType> arrayType) {
    return getCurrentRow().getList(columnName, arrayType);
  }

  @Override
  public <K, V> Map<K, V> getMap(int columnIndex, SqlType.Map<K, V> mapType) {
    return getCurrentRow().getMap(columnIndex, mapType);
  }

  @Override
  public <K, V> Map<K, V> getMap(String columnName, SqlType.Map<K, V> mapType) {
    return getCurrentRow().getMap(columnName, mapType);
  }

  @Override
  public <EnumType extends ProtocolMessageEnum> EnumType getProtoEnum(
      int columnIndex, Function<Integer, EnumType> forNumber) {
    return getCurrentRow().getProtoEnum(columnIndex, forNumber);
  }

  @Override
  public <EnumType extends ProtocolMessageEnum> EnumType getProtoEnum(
      String columnName, Function<Integer, EnumType> forNumber) {
    return getCurrentRow().getProtoEnum(columnName, forNumber);
  }

  @Override
  public <MsgType extends AbstractMessage> MsgType getProtoMessage(
      int columnIndex, MsgType message) {
    return getCurrentRow().getProtoMessage(columnIndex, message);
  }

  @Override
  public <MsgType extends AbstractMessage> MsgType getProtoMessage(
      String columnName, MsgType message) {
    return getCurrentRow().getProtoMessage(columnName, message);
  }
}
