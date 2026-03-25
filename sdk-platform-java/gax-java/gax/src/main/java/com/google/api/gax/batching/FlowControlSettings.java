/*
 * Copyright 2016 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.batching;

import com.google.api.gax.batching.FlowController.FlowControlException;
import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/** Settings for {@link FlowController}. */
@AutoValue
public abstract class FlowControlSettings {
  public static FlowControlSettings getDefaultInstance() {
    return FlowControlSettings.newBuilder().build();
  }

  /** Maximum number of outstanding elements to keep in memory before enforcing flow control. */
  @Nullable
  public abstract Long getMaxOutstandingElementCount();

  /** Maximum number of outstanding bytes to keep in memory before enforcing flow control. */
  @Nullable
  public abstract Long getMaxOutstandingRequestBytes();

  /**
   * The behavior of {@link FlowController} when the specified limits are exceeded. Defaults to
   * Block.
   *
   * <p>The expected behavior for each of these values is:
   *
   * <ul>
   *   <li>ThrowException: the FlowController will throw a {@link FlowControlException} if any of
   *       the limits are exceeded.
   *   <li>Block: the reserve() method of FlowController will block until the quote is available to
   *       be reserved.
   *   <li>Ignore: all flow control limits will be ignored; the FlowController is disabled.
   * </ul>
   */
  public abstract LimitExceededBehavior getLimitExceededBehavior();

  public abstract Builder toBuilder();

  public static Builder newBuilder() {
    return new AutoValue_FlowControlSettings.Builder()
        .setLimitExceededBehavior(LimitExceededBehavior.Block);
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setMaxOutstandingElementCount(Long value);

    public abstract Builder setMaxOutstandingRequestBytes(Long value);

    public abstract Builder setLimitExceededBehavior(LimitExceededBehavior value);

    abstract FlowControlSettings autoBuild();

    public FlowControlSettings build() {
      FlowControlSettings settings = autoBuild();
      Preconditions.checkArgument(
          settings.getMaxOutstandingElementCount() == null
              || settings.getMaxOutstandingElementCount() > 0,
          "maxOutstandingElementCount limit is disabled by default, but if set it must be set to a value greater than 0.");
      Preconditions.checkArgument(
          settings.getMaxOutstandingRequestBytes() == null
              || settings.getMaxOutstandingRequestBytes() > 0,
          "maxOutstandingRequestBytes limit is disabled by default, but if set it must be set to a value greater than 0.");
      return settings;
    }
  }
}
