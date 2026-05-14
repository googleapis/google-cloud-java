/*
 * Copyright 2023 Google LLC
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

import com.google.api.gax.batching.BatchResource;
import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;

/**
 * A custom implementation of {@link BatchResource} because MutateRowsRequest has a limit on number
 * of mutations.
 */
@AutoValue
abstract class MutateRowsBatchResource implements BatchResource {

  static MutateRowsBatchResource create(long elementCount, long byteCount, long mutationCount) {
    return new AutoValue_MutateRowsBatchResource(elementCount, byteCount, mutationCount);
  }

  @Override
  public BatchResource add(BatchResource batchResource) {
    Preconditions.checkArgument(
        batchResource instanceof MutateRowsBatchResource,
        "Expected MutateRowsBatchResource, got " + batchResource.getClass());
    MutateRowsBatchResource mutateRowsResource = (MutateRowsBatchResource) batchResource;

    return new AutoValue_MutateRowsBatchResource(
        getElementCount() + mutateRowsResource.getElementCount(),
        getByteCount() + mutateRowsResource.getByteCount(),
        getMutationCount() + mutateRowsResource.getMutationCount());
  }

  @Override
  public abstract long getElementCount();

  @Override
  public abstract long getByteCount();

  abstract long getMutationCount();

  @Override
  public boolean shouldFlush(long maxElementThreshold, long maxBytesThreshold) {
    return getElementCount() > maxElementThreshold
        || getByteCount() > maxBytesThreshold
        || getMutationCount() > 100000;
  }
}
