/*
 * Copyright 2024 Google LLC
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
import com.google.auto.value.AutoValue;
import com.google.cloud.bigtable.data.v2.models.MutateRowsException.FailedMutation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * This class represents the result of a MutateRows attempt. It contains a potentially empty list of
 * failed mutations, along with an indicator whether these errors are retryable.
 */
@InternalApi
@AutoValue
public abstract class MutateRowsAttemptResult {

  public abstract List<FailedMutation> getFailedMutations();

  public abstract boolean getIsRetryable();

  @InternalApi
  @Nonnull
  public static MutateRowsAttemptResult create(
      List<FailedMutation> failedMutations, boolean isRetryable) {
    return new AutoValue_MutateRowsAttemptResult(failedMutations, isRetryable);
  }

  @InternalApi
  @Nonnull
  public static MutateRowsAttemptResult success() {
    return new AutoValue_MutateRowsAttemptResult(new ArrayList<>(), false);
  }
}
