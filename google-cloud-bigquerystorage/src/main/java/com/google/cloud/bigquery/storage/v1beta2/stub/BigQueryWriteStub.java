/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.storage.v1beta2.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.storage.v1beta2.AppendRowsRequest;
import com.google.cloud.bigquery.storage.v1beta2.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1beta2.BatchCommitWriteStreamsRequest;
import com.google.cloud.bigquery.storage.v1beta2.BatchCommitWriteStreamsResponse;
import com.google.cloud.bigquery.storage.v1beta2.CreateWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1beta2.FinalizeWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1beta2.FinalizeWriteStreamResponse;
import com.google.cloud.bigquery.storage.v1beta2.FlushRowsRequest;
import com.google.cloud.bigquery.storage.v1beta2.FlushRowsResponse;
import com.google.cloud.bigquery.storage.v1beta2.GetWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1beta2.WriteStream;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the BigQueryWrite service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
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

  public UnaryCallable<FlushRowsRequest, FlushRowsResponse> flushRowsCallable() {
    throw new UnsupportedOperationException("Not implemented: flushRowsCallable()");
  }

  @Override
  public abstract void close();
}
