/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.data.v2.internal;

import com.google.api.core.InternalApi;
import com.google.api.gax.batching.PartitionKey;
import com.google.api.gax.batching.RequestBuilder;
import com.google.api.gax.rpc.BatchedRequestIssuer;
import com.google.api.gax.rpc.BatchingDescriptor;
import java.util.Collection;

/**
 * This is necessary workaround for {@link
 * com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub#bulkMutateRowsCallable()}. The settings
 * are exposed to the user using the {@link com.google.cloud.bigtable.data.v2.models.RowMutation}
 * wrapper, but the actual descriptor works on the underlying {@link
 * com.google.bigtable.v2.MutateRowsRequest}s. This class is used as a placeholder for the settings
 * and is replaced with the actual implementation of {@link
 * com.google.cloud.bigtable.data.v2.stub.mutaterows.MutateRowsBatchingDescriptor} when constructing
 * the callable chain.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@InternalApi
public class DummyBatchingDescriptor<RequestT, ResponseT>
    implements BatchingDescriptor<RequestT, ResponseT> {

  @Override
  public PartitionKey getBatchPartitionKey(RequestT request) {
    throw new UnsupportedOperationException("Placeholder descriptor should not be used");
  }

  @Override
  public RequestBuilder<RequestT> getRequestBuilder() {
    throw new UnsupportedOperationException("Placeholder descriptor should not be used");
  }

  @Override
  public void splitResponse(
      ResponseT response, Collection<? extends BatchedRequestIssuer<ResponseT>> collection) {
    throw new UnsupportedOperationException("Placeholder descriptor should not be used");
  }

  @Override
  public void splitException(
      Throwable throwable, Collection<? extends BatchedRequestIssuer<ResponseT>> collection) {
    throw new UnsupportedOperationException("Placeholder descriptor should not be used");
  }

  @Override
  public long countElements(RequestT request) {
    throw new UnsupportedOperationException("Placeholder descriptor should not be used");
  }

  @Override
  public long countBytes(RequestT request) {
    throw new UnsupportedOperationException("Placeholder descriptor should not be used");
  }
}
