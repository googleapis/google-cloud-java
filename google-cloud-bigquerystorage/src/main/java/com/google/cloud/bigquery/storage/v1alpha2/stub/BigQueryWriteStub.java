/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigquery.storage.v1alpha2.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.AppendRowsRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.BatchCommitWriteStreamsRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.BatchCommitWriteStreamsResponse;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.CreateWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.FinalizeWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.FinalizeWriteStreamResponse;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.GetWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Stream.WriteStream;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for BigQuery Storage API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class BigQueryWriteStub implements BackgroundResource {

  public UnaryCallable<CreateWriteStreamRequest, WriteStream> createWriteStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: createWriteStreamCallable()");
  }

  public BidiStreamingCallable<AppendRowsRequest, AppendRowsResponse> appendRowsCallable() {
    throw new UnsupportedOperationException("Not implemented: appendRowsCallable()");
  }

  public UnaryCallable<GetWriteStreamRequest, WriteStream> getWriteStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: getWriteStreamCallable()");
  }

  public UnaryCallable<FinalizeWriteStreamRequest, FinalizeWriteStreamResponse>
      finalizeWriteStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: finalizeWriteStreamCallable()");
  }

  public UnaryCallable<BatchCommitWriteStreamsRequest, BatchCommitWriteStreamsResponse>
      batchCommitWriteStreamsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCommitWriteStreamsCallable()");
  }

  @Override
  public abstract void close();
}
