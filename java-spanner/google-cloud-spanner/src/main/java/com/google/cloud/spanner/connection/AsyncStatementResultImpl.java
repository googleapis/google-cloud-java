/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.spanner.SpannerApiFutures.get;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.ExecutorProvider;
import com.google.cloud.spanner.AsyncResultSet;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.ResultSets;
import com.google.common.base.Preconditions;

class AsyncStatementResultImpl implements AsyncStatementResult {

  static AsyncStatementResult of(AsyncResultSet resultSet) {
    return new AsyncStatementResultImpl(Preconditions.checkNotNull(resultSet), null);
  }

  static AsyncStatementResult of(ApiFuture<Long> updateCount) {
    return new AsyncStatementResultImpl(Preconditions.checkNotNull(updateCount));
  }

  static AsyncStatementResult of(
      StatementResult clientSideStatementResult, ExecutorProvider executorProvider) {
    Preconditions.checkNotNull(clientSideStatementResult.getClientSideStatementType());
    Preconditions.checkNotNull(executorProvider);
    if (clientSideStatementResult.getResultType() == ResultType.RESULT_SET) {
      return new AsyncStatementResultImpl(
          ResultSets.toAsyncResultSet(clientSideStatementResult.getResultSet(), executorProvider),
          clientSideStatementResult.getClientSideStatementType());
    } else {
      return new AsyncStatementResultImpl(
          clientSideStatementResult.getClientSideStatementType(), ApiFutures.immediateFuture(null));
    }
  }

  static AsyncStatementResult noResult(ApiFuture<Void> result) {
    return new AsyncStatementResultImpl(null, Preconditions.checkNotNull(result));
  }

  private final ResultType type;
  private final ClientSideStatementType clientSideStatementType;
  private final AsyncResultSet resultSet;
  private final ApiFuture<Long> updateCount;
  private final ApiFuture<Void> noResult;

  private AsyncStatementResultImpl(
      AsyncResultSet resultSet, ClientSideStatementType clientSideStatementType) {
    this.type = ResultType.RESULT_SET;
    this.clientSideStatementType = clientSideStatementType;
    this.resultSet = resultSet;
    this.updateCount = null;
    this.noResult = null;
  }

  private AsyncStatementResultImpl(ApiFuture<Long> updateCount) {
    this.type = ResultType.UPDATE_COUNT;
    this.clientSideStatementType = null;
    this.resultSet = null;
    this.updateCount = updateCount;
    this.noResult = null;
  }

  private AsyncStatementResultImpl(
      ClientSideStatementType clientSideStatementType, ApiFuture<Void> result) {
    this.type = ResultType.NO_RESULT;
    this.clientSideStatementType = clientSideStatementType;
    this.resultSet = null;
    this.updateCount = null;
    this.noResult = result;
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
    return getResultSetAsync();
  }

  @Override
  public Long getUpdateCount() {
    return get(getUpdateCountAsync());
  }

  @Override
  public AsyncResultSet getResultSetAsync() {
    ConnectionPreconditions.checkState(
        resultSet != null, "This result does not contain a ResultSet");
    return resultSet;
  }

  @Override
  public ApiFuture<Long> getUpdateCountAsync() {
    ConnectionPreconditions.checkState(
        updateCount != null, "This result does not contain an update count");
    return updateCount;
  }

  @Override
  public ApiFuture<Void> getNoResultAsync() {
    ConnectionPreconditions.checkState(
        type == ResultType.NO_RESULT, "This result does not contain a 'no-result' result");
    return noResult;
  }
}
