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

package com.google.cloud.spanner;

import static com.google.common.base.Preconditions.checkState;

import com.google.cloud.spanner.SessionImpl.SessionTransaction;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ExecuteSqlRequest.QueryMode;
import com.google.spanner.v1.Transaction;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionSelector;
import java.util.Map;
import java.util.concurrent.Callable;
import org.threeten.bp.Duration;

/** Partitioned DML transaction for bulk updates and deletes. */
class PartitionedDMLTransaction implements SessionTransaction {
  private final SessionImpl session;
  private final SpannerRpc rpc;
  private volatile boolean isValid = true;

  PartitionedDMLTransaction(SessionImpl session, SpannerRpc rpc) {
    this.session = session;
    this.rpc = rpc;
  }

  private ByteString initTransaction() {
    final BeginTransactionRequest request =
        BeginTransactionRequest.newBuilder()
            .setSession(session.getName())
            .setOptions(
                TransactionOptions.newBuilder()
                    .setPartitionedDml(TransactionOptions.PartitionedDml.getDefaultInstance()))
            .build();
    Transaction txn = rpc.beginTransaction(request, session.getOptions());
    if (txn.getId().isEmpty()) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INTERNAL,
          "Failed to init transaction, missing transaction id\n" + session.getName());
    }
    return txn.getId();
  }

  /**
   * Executes the {@link Statement} using a partitioned dml transaction with automatic retry if the
   * transaction was aborted.
   */
  long executePartitionedUpdate(final Statement statement, final Duration timeout) {
    checkState(isValid, "Partitioned DML has been invalidated by a new operation on the session");
    Callable<com.google.spanner.v1.ResultSet> callable =
        new Callable<com.google.spanner.v1.ResultSet>() {
          @Override
          public com.google.spanner.v1.ResultSet call() throws Exception {
            ByteString transactionId = initTransaction();
            final ExecuteSqlRequest.Builder builder =
                ExecuteSqlRequest.newBuilder()
                    .setSql(statement.getSql())
                    .setQueryMode(QueryMode.NORMAL)
                    .setSession(session.getName())
                    .setTransaction(TransactionSelector.newBuilder().setId(transactionId).build());
            Map<String, Value> stmtParameters = statement.getParameters();
            if (!stmtParameters.isEmpty()) {
              com.google.protobuf.Struct.Builder paramsBuilder = builder.getParamsBuilder();
              for (Map.Entry<String, Value> param : stmtParameters.entrySet()) {
                paramsBuilder.putFields(param.getKey(), param.getValue().toProto());
                builder.putParamTypes(param.getKey(), param.getValue().getType().toProto());
              }
            }
            return rpc.executePartitionedDml(builder.build(), session.getOptions(), timeout);
          }
        };
    com.google.spanner.v1.ResultSet resultSet =
        SpannerRetryHelper.runTxWithRetriesOnAborted(callable);
    if (!resultSet.hasStats()) {
      throw new IllegalArgumentException(
          "Partitioned DML response missing stats possibly due to non-DML statement as input");
    }
    // For partitioned DML, using the row count lower bound.
    return resultSet.getStats().getRowCountLowerBound();
  }

  @Override
  public void invalidate() {
    isValid = false;
  }
}
