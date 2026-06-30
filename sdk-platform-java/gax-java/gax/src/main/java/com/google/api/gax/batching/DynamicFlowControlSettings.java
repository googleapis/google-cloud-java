/*
 * Copyright 2021 Google LLC
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

import com.google.api.core.InternalApi;
import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/** Settings for dynamic flow control */
@AutoValue
@InternalApi("For google-cloud-java client use only")
public abstract class DynamicFlowControlSettings {

  /** Number of outstanding elements that {@link FlowController} allows when it's initiated. */
  @Nullable
  public abstract Long getInitialOutstandingElementCount();

  /** Number of outstanding bytes that {@link FlowController} allows when it's initiated. */
  @Nullable
  public abstract Long getInitialOutstandingRequestBytes();

  /**
   * Maximum number of outstanding elements {@link FlowController} allows before enforcing flow
   * control.
   */
  @Nullable
  public abstract Long getMaxOutstandingElementCount();

  /**
   * Maximum number of outstanding bytes {@link FlowController} allows before enforcing flow
   * control.
   */
  @Nullable
  public abstract Long getMaxOutstandingRequestBytes();

  /**
   * Minimum number of outstanding elements {@link FlowController} allows before enforcing flow
   * control.
   */
  @Nullable
  public abstract Long getMinOutstandingElementCount();

  /**
   * Minimum number of outstanding bytes {@link FlowController} allows before enforcing flow
   * control.
   */
  @Nullable
  public abstract Long getMinOutstandingRequestBytes();

  /**
   * @see FlowControlSettings#getLimitExceededBehavior()
   */
  public abstract LimitExceededBehavior getLimitExceededBehavior();

  public abstract Builder toBuilder();

  public static Builder newBuilder() {
    return new AutoValue_DynamicFlowControlSettings.Builder()
        .setLimitExceededBehavior(LimitExceededBehavior.Block);
  }

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder setInitialOutstandingElementCount(Long value);

    public abstract Builder setInitialOutstandingRequestBytes(Long value);

    public abstract Builder setMaxOutstandingElementCount(Long value);

    public abstract Builder setMaxOutstandingRequestBytes(Long value);

    public abstract Builder setMinOutstandingElementCount(Long value);

    public abstract Builder setMinOutstandingRequestBytes(Long value);

    public abstract Builder setLimitExceededBehavior(LimitExceededBehavior value);

    abstract DynamicFlowControlSettings autoBuild();

    public DynamicFlowControlSettings build() {
      DynamicFlowControlSettings settings = autoBuild();

      verifyElementCountSettings(settings);
      verifyRequestBytesSettings(settings);

      return settings;
    }

    private void verifyElementCountSettings(DynamicFlowControlSettings settings) {
      // If LimitExceededBehavior is Ignore, dynamic flow control is disabled, there's no need to
      // check element count limit settings
      if (settings.getLimitExceededBehavior() == LimitExceededBehavior.Ignore) {
        return;
      }
      if (settings.getInitialOutstandingElementCount() == null
          && settings.getMinOutstandingElementCount() == null
          && settings.getMaxOutstandingElementCount() == null) {
        return;
      }
      Preconditions.checkState(
          settings.getInitialOutstandingElementCount() != null
              && settings.getMinOutstandingElementCount() != null
              && settings.getMaxOutstandingElementCount() != null,
          "Throttling on element count is disabled by default. To enable this setting,"
              + " minOutstandingElementCount, initialOutstandingElementCount, and "
              + "maxOutstandingElementCount must all be set.");
      Preconditions.checkState(
          settings.getMinOutstandingElementCount() > 0
              && settings.getInitialOutstandingElementCount()
                  <= settings.getMaxOutstandingElementCount()
              && settings.getInitialOutstandingElementCount()
                  >= settings.getMinOutstandingElementCount(),
          "If throttling on element count is set, minOutstandingElementCount must be"
              + " greater than 0, and minOutstandingElementCount <= "
              + "initialOutstandingElementCount <= maxOutstandingElementCount");
    }

    private void verifyRequestBytesSettings(DynamicFlowControlSettings settings) {
      // If LimitExceededBehavior is Ignore, dynamic flow control is disabled, there's no need to
      // check request bytes limit settings
      if (settings.getLimitExceededBehavior() == LimitExceededBehavior.Ignore) {
        return;
      }
      if (settings.getInitialOutstandingRequestBytes() == null
          && settings.getMinOutstandingRequestBytes() == null
          && settings.getMaxOutstandingRequestBytes() == null) {
        return;
      }
      Preconditions.checkState(
          settings.getInitialOutstandingRequestBytes() != null
              && settings.getMinOutstandingRequestBytes() != null
              && settings.getMaxOutstandingRequestBytes() != null,
          "Throttling on number of bytes is disabled by default. To enable this "
              + "setting, minOutstandingRequestBytes, initialOutstandingRequestBytes, and "
              + "maxOutstandingRequestBytes must all be set");
      Preconditions.checkState(
          settings.getMinOutstandingRequestBytes() > 0
              && settings.getInitialOutstandingRequestBytes()
                  <= settings.getMaxOutstandingRequestBytes()
              && settings.getInitialOutstandingRequestBytes()
                  >= settings.getMinOutstandingRequestBytes(),
          "If throttling on number of bytes is set, minOutstandingRequestBytes must "
              + "be greater than 0, and minOutstandingRequestBytes <= "
              + "initialOutstandingRequestBytes <= maxOutstandingRequestBytes");
    }
  }
}
