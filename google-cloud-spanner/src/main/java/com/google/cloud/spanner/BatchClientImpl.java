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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.ReadOption;
import com.google.cloud.spanner.SpannerImpl.MultiUseReadOnlyTransaction;
import com.google.cloud.spanner.SpannerImpl.SessionImpl;
import com.google.cloud.spanner.SpannerImpl.SessionOption;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.TransactionSelector;
import com.google.spanner.v1.ExecuteSqlRequest.QueryMode;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;

public class BatchClientImpl implements BatchClient {
  private final Random random = new Random();
  private SpannerImpl spanner;
  private DatabaseId db;

  BatchClientImpl(DatabaseId db, SpannerImpl spanner) {
    this.db = db;
    this.spanner = spanner;
  }

  @Override
  public BatchTransaction batchRead(TimestampBound bound) {
    SessionImpl session = (SessionImpl) spanner.createSession(db);
    return new BatchTransactionImpl(spanner, session, bound);
  }

  @Override
  public BatchTransaction batchRead(BatchTransactionId batchTransactionId) {
    final Map<SpannerRpc.Option, ?> options =
        SpannerImpl.optionMap(SessionOption.channelHint(random.nextLong()));
    SessionImpl session = spanner.new SessionImpl(batchTransactionId.getSessionId(), options);
    return new BatchTransactionImpl(spanner, session, batchTransactionId);
  }

  @Override
  public void close() {
    // TODO(snehashah): Auto-generated method stub

  }

  static class BatchTransactionImpl extends MultiUseReadOnlyTransaction
      implements BatchTransaction {
    private final String sessionName;
    private final SpannerImpl spanner;
    private final Map<SpannerRpc.Option, ?> options;

    BatchTransactionImpl(SpannerImpl spanner, SessionImpl session, TimestampBound bound) {
      super(
          session,
          bound,
          spanner.getOptions().getSpannerRpcV1(),
          spanner.getOptions().getPrefetchChunks());
      this.sessionName = session.getName();
      this.options = session.getOptions();
      this.spanner = spanner;
      initTransaction();
    }

    BatchTransactionImpl(
        SpannerImpl spanner, SessionImpl session, BatchTransactionId batchTransactionId) {
      super(
          session,
          batchTransactionId.getTransactionId(),
          batchTransactionId.getTimestamp(),
          spanner.getOptions().getSpannerRpcV1(),
          spanner.getOptions().getPrefetchChunks());
      this.sessionName = session.getName();
      this.options = session.getOptions();
      this.spanner = spanner;
    }

    @Override
    public BatchTransactionId getBatchTransactionId() {
      return new BatchTransactionId(sessionName, transactionId, timestamp);
    }

    @Override
    public List<Partition> generateReadPartitions(
        PartitionParameters parameters,
        String table,
        KeySet keys,
        Iterable<String> columns,
        ReadOption... options) {
      return generateReadUsingIndexPartitions(parameters, table, null, keys, columns, options);
    }

    @Override
    public List<Partition> generateReadUsingIndexPartitions(
        PartitionParameters parameters,
        String table,
        String index,
        KeySet keys,
        Iterable<String> columns,
        ReadOption... option) {
      final CreateReadPartitionsRequest.Builder builder =
          CreateReadPartitionsRequest.newBuilder()
              .setSession(sessionName)
              .setTable(checkNotNull(table))
              .addAllColumns(columns);
      keys.appendToProto(builder.getKeySetBuilder());
      if (index != null) {
        builder.setIndex(index);
      }
      Options readOptions = Options.fromReadOptions(option);
      if (readOptions.hasLimit()) {
        // TODO(snehashah): error!! since we don't support limit in batch APIs.
      }
      TransactionSelector selector = getTransactionSelector();
      if (selector != null) {
        builder.setTransaction(selector);
      }
      builder.setPartitionOptions(parameters);
      final CreateReadPartitionsRequest request = builder.build();
      CreatePartitionsResponse response =
          SpannerImpl.runWithRetries(
              new Callable<CreatePartitionsResponse>() {
                @Override
                public CreatePartitionsResponse call() throws Exception {
                  return rpc.commit(request, options);
                }
              });
      return consumeResponse(response, parameters, table, index, keys, columns, option);    
    }

    private List<Partition> consumeResponse(
        CreatePartitionsResponse response,
        PartitionParameters parameters,
        String table,
        String index,
        KeySet keys,
        Iterable<String> columns,
        ReadOption... option) {
      
    }

    @Override
    public List<Partition> generateQueryPartitions(
        PartitionParameters parameters, Statement statement, QueryOption... options) {
      // TODO(snehashah): Auto-generated method stub
      return null;
    }

    @Override
    public ResultSet execute(Partition partition) {
      // TODO(snehashah): add partition token to the request when available in proto.
      if (partition.getStatement() != null)
        return executeQueryInternalWithOptions(
            partition.getStatement(),
            QueryMode.NORMAL,
            partition.getQueryOptions(),
            partition.getPartitionToken());
      return readInternalWithOptions(
          partition.getTable(),
          partition.getIndex(),
          partition.getKeys(),
          partition.getColumns(),
          partition.getReadOptions(),
          partition.getPartitionToken());
    }
  }
}
