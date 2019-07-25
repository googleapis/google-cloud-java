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

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.ResultSets;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.StructField;
import java.util.Arrays;

/** Implementation of {@link StatementResult} */
class StatementResultImpl implements StatementResult {

  /** {@link StatementResult} containing a {@link ResultSet} returned by Cloud Spanner. */
  static StatementResult of(ResultSet resultSet) {
    return new StatementResultImpl(resultSet, null);
  }

  /**
   * {@link StatementResult} containing a {@link ResultSet} created by a {@link
   * ClientSideStatement}.
   */
  static StatementResult of(ResultSet resultSet, ClientSideStatementType clientSideStatementType) {
    return new StatementResultImpl(resultSet, clientSideStatementType);
  }

  /** {@link StatementResult} containing an update count returned by Cloud Spanner. */
  static StatementResult of(Long updateCount) {
    return new StatementResultImpl(updateCount);
  }

  /**
   * Convenience method for creating a {@link StatementResult} containing a {@link ResultSet} with
   * one BOOL column and one row that is created by a {@link ClientSideStatement}.
   */
  static StatementResult resultSet(
      String name, Boolean value, ClientSideStatementType clientSideStatementType) {
    return of(
        ResultSets.forRows(
            Type.struct(StructField.of(name, Type.bool())),
            Arrays.asList(Struct.newBuilder().set(name).to(value).build())),
        clientSideStatementType);
  }

  /**
   * Convenience method for creating a {@link StatementResult} containing a {@link ResultSet} with
   * one INT64 column and one row that is created by a {@link ClientSideStatement}.
   */
  static StatementResult resultSet(
      String name, Long value, ClientSideStatementType clientSideStatementType) {
    return of(
        ResultSets.forRows(
            Type.struct(StructField.of(name, Type.int64())),
            Arrays.asList(Struct.newBuilder().set(name).to(value).build())),
        clientSideStatementType);
  }

  /**
   * Convenience method for creating a {@link StatementResult} containing a {@link ResultSet} with
   * one ARRAY<INT64> column and one row that is created by a {@link ClientSideStatement}.
   */
  static StatementResult resultSet(
      String name, long[] values, ClientSideStatementType clientSideStatementType) {
    return of(
        ResultSets.forRows(
            Type.struct(StructField.of(name, Type.array(Type.int64()))),
            Arrays.asList(Struct.newBuilder().set(name).toInt64Array(values).build())),
        clientSideStatementType);
  }

  /**
   * Convenience method for creating a {@link StatementResult} containing a {@link ResultSet} with
   * one STRING column and one row that is created by a {@link ClientSideStatement}.
   */
  static StatementResult resultSet(
      String name, String value, ClientSideStatementType clientSideStatementType) {
    return of(
        ResultSets.forRows(
            Type.struct(StructField.of(name, Type.string())),
            Arrays.asList(Struct.newBuilder().set(name).to(value).build())),
        clientSideStatementType);
  }

  /**
   * Convenience method for creating a {@link StatementResult} containing a {@link ResultSet} with
   * one STRING column containing an {@link Enum} value and one row that is created by a {@link
   * ClientSideStatement}.
   */
  static StatementResult resultSet(
      String name, Enum<?> value, ClientSideStatementType clientSideStatementType) {
    return of(
        ResultSets.forRows(
            Type.struct(StructField.of(name, Type.string())),
            Arrays.asList(Struct.newBuilder().set(name).to(value.toString()).build())),
        clientSideStatementType);
  }

  /**
   * Convenience method for creating a {@link StatementResult} containing a {@link ResultSet} with
   * one TIMESTAMP column and one row that is created by a {@link ClientSideStatement}.
   */
  static StatementResult resultSet(
      String name, Timestamp value, ClientSideStatementType clientSideStatementType) {
    return of(
        ResultSets.forRows(
            Type.struct(StructField.of(name, Type.timestamp())),
            Arrays.asList(Struct.newBuilder().set(name).to(value).build())),
        clientSideStatementType);
  }

  /** {@link StatementResult} containing no results. */
  static StatementResult noResult() {
    return new StatementResultImpl((ClientSideStatementType) null);
  }

  /** {@link StatementResult} containing no results created by a {@link ClientSideStatement}. */
  static StatementResult noResult(ClientSideStatementType clientSideStatementType) {
    return new StatementResultImpl(clientSideStatementType);
  }

  private final ResultType type;
  private final ClientSideStatementType clientSideStatementType;
  private final ResultSet resultSet;
  private final Long updateCount;

  private StatementResultImpl(
      ResultSet resultSet, ClientSideStatementType clientSideStatementType) {
    this.type = ResultType.RESULT_SET;
    this.clientSideStatementType = clientSideStatementType;
    this.resultSet = resultSet;
    this.updateCount = null;
  }

  private StatementResultImpl(Long updateCount) {
    this.type = ResultType.UPDATE_COUNT;
    this.clientSideStatementType = null;
    this.resultSet = null;
    this.updateCount = updateCount;
  }

  private StatementResultImpl(ClientSideStatementType clientSideStatementType) {
    this.type = ResultType.NO_RESULT;
    this.clientSideStatementType = clientSideStatementType;
    this.resultSet = null;
    this.updateCount = null;
  }

  @Override
  public ResultType getResultType() {
    return type;
  }

  @Override
  public ClientSideStatementType getClientSideStatementType() {
    return clientSideStatementType;
  }

  @Override
  public ResultSet getResultSet() {
    ConnectionPreconditions.checkState(
        resultSet != null, "This result does not contain a ResultSet");
    return resultSet;
  }

  @Override
  public Long getUpdateCount() {
    ConnectionPreconditions.checkState(
        updateCount != null, "This result does not contain an update count");
    return updateCount;
  }
}
