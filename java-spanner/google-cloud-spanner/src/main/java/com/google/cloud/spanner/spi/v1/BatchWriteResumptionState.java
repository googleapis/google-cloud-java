/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner.spi.v1;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.common.base.Preconditions;
import com.google.spanner.v1.BatchWriteRequest;
import com.google.spanner.v1.BatchWriteResponse;
import io.grpc.Status;
import java.util.List;
import javax.annotation.Nullable;

/**
 * Pure state tracker for {@code BatchWrite} mutation groups across stream resumption attempts.
 *
 * <p>Tracks which mutation groups remain unacknowledged, builds compacted retry requests containing
 * only remaining groups, and translates attempt-local response indices back to the caller's
 * original index space while releasing acknowledged payloads for immediate garbage collection.
 *
 * <p>Not thread-safe; callers must synchronize access externally.
 */
final class BatchWriteResumptionState {

  // Metadata-only template (session, request_options, exclude_txn_from_change_streams) with
  // mutation_groups cleared so acknowledged payloads can be garbage-collected mid-stream.
  private final BatchWriteRequest requestTemplate;
  // Entries are nulled once acknowledged so large mutation payloads can be GC'd immediately.
  private final BatchWriteRequest.MutationGroup[] pending;
  private int remaining;
  @Nullable private int[] streamIndexes;

  BatchWriteResumptionState(BatchWriteRequest initialRequest) {
    Preconditions.checkNotNull(initialRequest, "initialRequest must not be null");
    this.requestTemplate = initialRequest.toBuilder().clearMutationGroups().build();
    int count = initialRequest.getMutationGroupsCount();
    this.pending = new BatchWriteRequest.MutationGroup[count];
    for (int i = 0; i < count; i++) {
      this.pending[i] = initialRequest.getMutationGroups(i);
    }
    this.remaining = count;
  }

  boolean isAllAcknowledged() {
    return remaining == 0;
  }

  int getRemainingCount() {
    return remaining;
  }

  int getTotalCount() {
    return pending.length;
  }

  BatchWriteRequest getRequestTemplate() {
    return requestTemplate;
  }

  /**
   * Builds the request for the next stream attempt containing only unacknowledged mutation groups
   * and updates the relative-to-original index mapping for that attempt.
   */
  BatchWriteRequest buildNextAttemptRequest() {
    BatchWriteRequest.Builder builder = requestTemplate.toBuilder();
    int[] nextIndexes = new int[remaining];
    int pos = 0;
    for (int i = 0; i < pending.length; i++) {
      BatchWriteRequest.MutationGroup group = pending[i];
      if (group != null) {
        builder.addMutationGroups(group);
        nextIndexes[pos++] = i;
      }
    }
    this.streamIndexes = nextIndexes;
    return builder.build();
  }

  /**
   * Validates all indices in {@code response}, translates them back to the caller's original index
   * space, and marks those mutation groups as acknowledged.
   *
   * @throws ApiException with {@link Status.Code#INTERNAL} (non-retryable) if any index is out of
   *     bounds; tracking state is left unmodified when this exception is thrown.
   */
  BatchWriteResponse translateAndAcknowledge(BatchWriteResponse response) {
    Preconditions.checkNotNull(response, "response must not be null");
    Preconditions.checkState(
        streamIndexes != null,
        "buildNextAttemptRequest() must be called before translateAndAcknowledge()");
    List<Integer> relIndexes = response.getIndexesList();
    // Validate all indices before mutating tracking state.
    for (int i = 0; i < relIndexes.size(); i++) {
      int relIdx = relIndexes.get(i);
      if (relIdx < 0 || relIdx >= streamIndexes.length) {
        throw ApiExceptionFactory.createException(
            String.format(
                "Spanner returned mutation group index %d out of bounds for BatchWrite"
                    + " stream with %d mutation groups",
                relIdx, streamIndexes.length),
            null,
            GrpcStatusCode.of(Status.Code.INTERNAL),
            /* retryable= */ false);
      }
    }

    BatchWriteResponse.Builder translated = response.toBuilder().clearIndexes();
    for (int i = 0; i < relIndexes.size(); i++) {
      int origIdx = streamIndexes[relIndexes.get(i)];
      translated.addIndexes(origIdx);
      if (pending[origIdx] != null) {
        pending[origIdx] = null;
        remaining--;
      }
    }
    return translated.build();
  }
}
