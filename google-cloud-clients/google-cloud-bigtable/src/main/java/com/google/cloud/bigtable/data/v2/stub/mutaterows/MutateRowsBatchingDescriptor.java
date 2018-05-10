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
package com.google.cloud.bigtable.data.v2.stub.mutaterows;

import com.google.api.core.InternalApi;
import com.google.api.gax.batching.PartitionKey;
import com.google.api.gax.batching.RequestBuilder;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.BatchedRequestIssuer;
import com.google.api.gax.rpc.BatchingDescriptor;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.cloud.bigtable.data.v2.models.MutateRowsException;
import com.google.cloud.bigtable.data.v2.models.MutateRowsException.FailedMutation;
import com.google.common.base.Function;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * A custom implementation of a {@link BatchingDescriptor} to split individual results in a {@link
 * MutateRowsException}. Each individual result will be matched with its issuer.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications directly.
 */
@InternalApi
public class MutateRowsBatchingDescriptor implements BatchingDescriptor<MutateRowsRequest, Void> {
  /** Return the target table name. This will be used to combine batcheable requests */
  @Override
  public PartitionKey getBatchPartitionKey(MutateRowsRequest request) {
    return new PartitionKey(request.getTableName());
  }

  /** {@inheritDoc} */
  @Override
  public RequestBuilder<MutateRowsRequest> getRequestBuilder() {
    return new MyRequestBuilder();
  }

  @Override
  public void splitResponse(
      Void batchResponse, Collection<? extends BatchedRequestIssuer<Void>> batch) {

    for (BatchedRequestIssuer<Void> issuer : batch) {
      issuer.setResponse(null);
    }
  }

  @Override
  public void splitException(
      Throwable throwable, Collection<? extends BatchedRequestIssuer<Void>> batch) {

    if (!(throwable instanceof MutateRowsException)) {
      for (BatchedRequestIssuer<Void> issuer : batch) {
        issuer.setException(throwable);
      }
      return;
    }

    List<FailedMutation> failedMutations = ((MutateRowsException) throwable).getFailedMutations();

    Map<Integer, FailedMutation> errorsByIndex =
        Maps.uniqueIndex(
            failedMutations,
            new Function<FailedMutation, Integer>() {
              @Nullable
              @Override
              public Integer apply(@Nullable FailedMutation input) {
                return input.getIndex();
              }
            });

    int i = 0;
    for (BatchedRequestIssuer<Void> issuer : batch) {
      // NOTE: the gax batching api doesn't allow for a single issuer to get different exceptions
      // for different entries. However this does not affect this client because BulkMutationBatcher
      // only allows a single mutation per call. So just use the last error per entry.
      ApiException lastError = null;

      for (int j = 0; j < issuer.getMessageCount(); j++) {
        FailedMutation failure = errorsByIndex.get(i++);
        if (failure != null) {
          lastError = failure.getError();
        }
      }

      if (lastError == null) {
        issuer.setResponse(null);
      } else {
        issuer.setException(lastError);
      }
    }
  }

  /** {@inheritDoc} */
  @Override
  public long countElements(MutateRowsRequest request) {
    return request.getEntriesCount();
  }

  /** {@inheritDoc} */
  @Override
  public long countBytes(MutateRowsRequest request) {
    return request.getSerializedSize();
  }

  /** A {@link com.google.api.gax.batching.RequestBuilder} that can aggregate MutateRowsRequest */
  static class MyRequestBuilder implements RequestBuilder<MutateRowsRequest> {
    private MutateRowsRequest.Builder builder;

    @Override
    public void appendRequest(MutateRowsRequest request) {
      if (builder == null) {
        builder = request.toBuilder();
      } else {
        builder.addAllEntries(request.getEntriesList());
      }
    }

    @Override
    public MutateRowsRequest build() {
      return builder.build();
    }
  }
}
