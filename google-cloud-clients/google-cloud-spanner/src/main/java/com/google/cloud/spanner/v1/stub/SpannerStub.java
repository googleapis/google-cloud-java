/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.spanner.v1.stub;

import static com.google.cloud.spanner.v1.SpannerClient.ListSessionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.DeleteSessionRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteBatchDmlResponse;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.GetSessionRequest;
import com.google.spanner.v1.ListSessionsRequest;
import com.google.spanner.v1.ListSessionsResponse;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.PartitionQueryRequest;
import com.google.spanner.v1.PartitionReadRequest;
import com.google.spanner.v1.PartitionResponse;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.Transaction;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Cloud Spanner API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class SpannerStub implements BackgroundResource {

  public UnaryCallable<CreateSessionRequest, Session> createSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: createSessionCallable()");
  }

  public UnaryCallable<GetSessionRequest, Session> getSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: getSessionCallable()");
  }

  public UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse> listSessionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSessionsPagedCallable()");
  }

  public UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSessionsCallable()");
  }

  public UnaryCallable<DeleteSessionRequest, Empty> deleteSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSessionCallable()");
  }

  public UnaryCallable<ExecuteSqlRequest, ResultSet> executeSqlCallable() {
    throw new UnsupportedOperationException("Not implemented: executeSqlCallable()");
  }

  public ServerStreamingCallable<ExecuteSqlRequest, PartialResultSet>
      executeStreamingSqlCallable() {
    throw new UnsupportedOperationException("Not implemented: executeStreamingSqlCallable()");
  }

  public UnaryCallable<ExecuteBatchDmlRequest, ExecuteBatchDmlResponse> executeBatchDmlCallable() {
    throw new UnsupportedOperationException("Not implemented: executeBatchDmlCallable()");
  }

  public UnaryCallable<ReadRequest, ResultSet> readCallable() {
    throw new UnsupportedOperationException("Not implemented: readCallable()");
  }

  public ServerStreamingCallable<ReadRequest, PartialResultSet> streamingReadCallable() {
    throw new UnsupportedOperationException("Not implemented: streamingReadCallable()");
  }

  public UnaryCallable<BeginTransactionRequest, Transaction> beginTransactionCallable() {
    throw new UnsupportedOperationException("Not implemented: beginTransactionCallable()");
  }

  public UnaryCallable<CommitRequest, CommitResponse> commitCallable() {
    throw new UnsupportedOperationException("Not implemented: commitCallable()");
  }

  public UnaryCallable<RollbackRequest, Empty> rollbackCallable() {
    throw new UnsupportedOperationException("Not implemented: rollbackCallable()");
  }

  public UnaryCallable<PartitionQueryRequest, PartitionResponse> partitionQueryCallable() {
    throw new UnsupportedOperationException("Not implemented: partitionQueryCallable()");
  }

  public UnaryCallable<PartitionReadRequest, PartitionResponse> partitionReadCallable() {
    throw new UnsupportedOperationException("Not implemented: partitionReadCallable()");
  }

  @Override
  public abstract void close();
}
