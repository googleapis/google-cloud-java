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

package com.google.cloud.bigquery.storage.v1beta1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.storage.v1beta1.Storage;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the BigQueryStorage service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class BigQueryStorageStub implements BackgroundResource {

  public UnaryCallable<Storage.CreateReadSessionRequest, Storage.ReadSession>
      createReadSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: createReadSessionCallable()");
  }

  public ServerStreamingCallable<Storage.ReadRowsRequest, Storage.ReadRowsResponse>
      readRowsCallable() {
    throw new UnsupportedOperationException("Not implemented: readRowsCallable()");
  }

  public UnaryCallable<
          Storage.BatchCreateReadSessionStreamsRequest,
          Storage.BatchCreateReadSessionStreamsResponse>
      batchCreateReadSessionStreamsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCreateReadSessionStreamsCallable()");
  }

  public UnaryCallable<Storage.FinalizeStreamRequest, Empty> finalizeStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: finalizeStreamCallable()");
  }

  public UnaryCallable<Storage.SplitReadStreamRequest, Storage.SplitReadStreamResponse>
      splitReadStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: splitReadStreamCallable()");
  }

  @Override
  public abstract void close();
}
