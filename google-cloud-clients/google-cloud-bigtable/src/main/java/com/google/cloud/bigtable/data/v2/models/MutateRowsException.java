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
package com.google.cloud.bigtable.data.v2.models;

import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.auto.value.AutoValue;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Thrown by the MutateRows when at least one Mutation failed. If the last failure was caused by an
 * RPC error (as opposed to a single entry failing), then this exception's cause will be set to that
 * error and {@link #getFailedMutations()} will contain synthetic errors for all of the entries that
 * were part of that RPC.
 */
public final class MutateRowsException extends ApiException {
  // Synthetic status to use for this ApiException subclass.
  private static final StatusCode LOCAL_STATUS =
      new StatusCode() {
        @Override
        public Code getCode() {
          return Code.INTERNAL;
        }

        @Override
        public Object getTransportCode() {
          return null;
        }
      };

  private final List<FailedMutation> failedMutations;

  /**
   * This constructor is considered an internal implementation detail and not meant to be used by
   * applications.
   */
  @InternalApi
  public MutateRowsException(
      @Nullable Throwable rpcError,
      @Nonnull List<FailedMutation> failedMutations,
      boolean retryable) {
    super("Some mutations failed to apply", rpcError, LOCAL_STATUS, retryable);
    Preconditions.checkNotNull(failedMutations);
    Preconditions.checkArgument(!failedMutations.isEmpty(), "failedMutations can't be empty");
    this.failedMutations = failedMutations;
  }

  /**
   * Retrieve all of the failed mutations. This list will contain failures for all of the mutations
   * that have failed across all of the retry attempts so far.
   */
  @Nonnull
  public List<FailedMutation> getFailedMutations() {
    return failedMutations;
  }

  /**
   * Identifies which mutation failed and the reason it failed. The mutation is identified by it's
   * index in the original request's {@link MutateRowsRequest#getEntriesList()}.
   */
  @AutoValue
  public abstract static class FailedMutation {
    /**
     * This method is considered an internal implementation detail and not meant to be used by
     * applications.
     */
    @InternalApi
    @Nonnull
    public static FailedMutation create(int index, ApiException error) {
      return new AutoValue_MutateRowsException_FailedMutation(index, error);
    }

    /**
     * The index of the mutation in the original request's {@link
     * MutateRowsRequest#getEntriesList()}.
     */
    public abstract int getIndex();

    /**
     * The error that prevented this mutation from being applied. Please note, that if the entire
     * RPC attempt failed, all mutations that were part of the attempt will have take on the same
     * error.
     */
    @Nonnull
    public abstract ApiException getError();
  }
}
