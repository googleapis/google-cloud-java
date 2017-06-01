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

import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.ReadOption;
import com.google.cloud.spanner.SpannerImpl.MultiUseReadOnlyTransaction;
import com.google.cloud.spanner.SpannerImpl.SessionImpl;
import com.google.cloud.spanner.SpannerImpl.SessionOption;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

    BatchTransactionImpl(SpannerImpl spanner, SessionImpl session, TimestampBound bound) {
      super(
          session, bound, spanner.getOptions().getSpannerRpcV1(), spanner.getOptions().getPrefetchChunks());
      this.sessionName = session.getName();
      transactionId = session.beginTransaction();
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
    }

    @Override
    public BatchTransactionId getBatchTransactionId() {
      return new BatchTransactionId(sessionName, transactionId, timestamp);
    }

    @Override
    public List<Partition> GenerateReadPartitions(
        PartitionParameters parameters,
        String table,
        KeySet keys,
        Iterable<String> columns,
        ReadOption... options) {
      // TODO(snehashah): Auto-generated method stub
      return null;
    }

    @Override
    public List<Partition> GenerateReadUsingIndexPartitions(
        PartitionParameters parameters,
        String table,
        String index,
        KeySet keys,
        Iterable<String> columns,
        ReadOption... options) {
      // TODO(snehashah): Auto-generated method stub
      return null;
    }

    @Override
    public List<Partition> GenerateQueryPartitions(
        PartitionParameters parameters, Statement statement, QueryOption... options) {
      // TODO(snehashah): Auto-generated method stub
      return null;
    }

    @Override
    public ResultSet execute(Partition partition) {
      // TODO(snehashah): Auto-generated method stub
      return null;
    }
  }
}