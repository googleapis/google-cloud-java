/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.bigquery.storage.v1alpha.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsRequest;
import com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsResponse;
import com.google.cloud.bigquery.storage.v1alpha.BatchDeleteMetastorePartitionsRequest;
import com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsRequest;
import com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsResponse;
import com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsRequest;
import com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsResponse;
import com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsRequest;
import com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the MetastorePartitionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class MetastorePartitionServiceStub implements BackgroundResource {

  public UnaryCallable<
          BatchCreateMetastorePartitionsRequest, BatchCreateMetastorePartitionsResponse>
      batchCreateMetastorePartitionsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCreateMetastorePartitionsCallable()");
  }

  public UnaryCallable<BatchDeleteMetastorePartitionsRequest, Empty>
      batchDeleteMetastorePartitionsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchDeleteMetastorePartitionsCallable()");
  }

  public UnaryCallable<
          BatchUpdateMetastorePartitionsRequest, BatchUpdateMetastorePartitionsResponse>
      batchUpdateMetastorePartitionsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchUpdateMetastorePartitionsCallable()");
  }

  public UnaryCallable<ListMetastorePartitionsRequest, ListMetastorePartitionsResponse>
      listMetastorePartitionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listMetastorePartitionsCallable()");
  }

  public BidiStreamingCallable<StreamMetastorePartitionsRequest, StreamMetastorePartitionsResponse>
      streamMetastorePartitionsCallable() {
    throw new UnsupportedOperationException("Not implemented: streamMetastorePartitionsCallable()");
  }

  @Override
  public abstract void close();
}
