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
package com.google.cloud.bigtable.data.v2.stub.mutaterows;

import com.google.api.core.InternalApi;
import com.google.api.gax.batching.BatchEntry;
import com.google.api.gax.batching.BatchingDescriptor;
import com.google.api.gax.batching.BatchingRequestBuilder;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.MutateRowsException;
import com.google.cloud.bigtable.data.v2.models.MutateRowsException.FailedMutation;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

/**
 * A custom implementation of a {@link BatchingDescriptor} to split batching response into
 * individual row response and in a {@link MutateRowsException}.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications directly.
 */
@InternalApi("For internal use only")
public class MutateRowsBatchingDescriptor
    implements BatchingDescriptor<RowMutationEntry, Void, BulkMutation, Void> {

  @Override
  public BatchingRequestBuilder<RowMutationEntry, BulkMutation> newRequestBuilder(
      BulkMutation prototype) {
    return new RequestBuilder(prototype);
  }

  @Override
  public void splitResponse(Void response, List<BatchEntry<RowMutationEntry, Void>> entries) {
    for (BatchEntry<RowMutationEntry, Void> batchResponse : entries) {
      batchResponse.getResultFuture().set(null);
    }
  }

  /**
   * Marks the entry future with received {@link Throwable}.
   *
   * <p>In case throwable is {@link MutateRowsException}, then it only sets throwable for the
   * entries whose index is mentioned {@link MutateRowsException#getFailedMutations()}.
   */
  @Override
  public void splitException(
      Throwable throwable, List<BatchEntry<RowMutationEntry, Void>> entries) {
    if (!(throwable instanceof MutateRowsException)) {
      for (BatchEntry<RowMutationEntry, Void> entry : entries) {
        entry.getResultFuture().setException(throwable);
      }
      return;
    }

    List<FailedMutation> failedMutations = ((MutateRowsException) throwable).getFailedMutations();
    Map<Integer, Throwable> entryErrors = Maps.newHashMap();

    for (FailedMutation failure : failedMutations) {
      entryErrors.put(failure.getIndex(), failure.getError());
    }

    int i = 0;
    for (BatchEntry<RowMutationEntry, Void> entry : entries) {
      Throwable entryError = entryErrors.get(i++);
      if (entryError == null) {
        entry.getResultFuture().set(null);
      } else {
        entry.getResultFuture().setException(entryError);
      }
    }
  }

  @Override
  public long countBytes(RowMutationEntry entry) {
    return entry.toProto().getSerializedSize();
  }

  /**
   * A {@link BatchingRequestBuilder} that will spool mutations and send them out as a {@link
   * BulkMutation}.
   */
  static class RequestBuilder implements BatchingRequestBuilder<RowMutationEntry, BulkMutation> {
    private BulkMutation bulkMutation;

    RequestBuilder(BulkMutation prototype) {
      this.bulkMutation = prototype.clone();
    }

    @Override
    public void add(RowMutationEntry entry) {
      bulkMutation.add(entry);
    }

    @Override
    public BulkMutation build() {
      return bulkMutation;
    }
  }
}
