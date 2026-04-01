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

import static com.google.api.gax.util.TimeConversionUtils.toJavaTimeDuration;
import static com.google.api.gax.util.TimeConversionUtils.toThreetenDuration;

import com.google.api.core.ObsoleteApi;
import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;
import java.time.Duration;
import javax.annotation.Nullable;

/**
 * Represents the batching settings to use for an API method that is capable of batching.
 *
 * <p>By default the settings are configured to <b>not</b> use batching (i.e. the batch size
 * threshold is 1). This is the safest default behavior, which has meaning in all possible
 * scenarios. Users are expected to configure actual batching thresholds explicitly: the element
 * count, the request bytes count and the delay.
 *
 * <p>Warning: With the wrong settings, it is possible to cause long periods of dead waiting time.
 *
 * <p>When batching is turned on for an API method, a call to that method will result in the request
 * being queued up with other requests. When any of the set thresholds are reached, the queued up
 * requests are packaged together in a batch and set to the service as a single RPC. When the
 * response comes back, it is split apart into individual responses according to the individual
 * input requests.
 *
 * <p>There are several supported thresholds:
 *
 * <ul>
 *   <li><b>Delay Threshold</b>: Counting from the time that the first message is queued, once this
 *       delay has passed, then send the batch. The default value is 1 millisecond.
 *   <li><b>Message Count Threshold</b>: Once this many messages are queued, send all of the
 *       messages in a single call, even if the delay threshold hasn't elapsed yet. The default
 *       value is 1 message.
 *   <li><b>Request Byte Threshold</b>: Once the number of bytes in the batched request reaches this
 *       threshold, send all of the messages in a single call, even if neither the delay or message
 *       count thresholds have been exceeded yet. The default value is 1 byte.
 * </ul>
 *
 * <p>These thresholds are treated as triggers, not as limits. Thus, if a request is made with 2x
 * the message count threshold, it will not be split apart (unless one of the limits listed further
 * down is crossed); only one batch will be sent. Each threshold is an independent trigger and
 * doesn't have any knowledge of the other thresholds.
 *
 * <p>Two of the values above also have limits:
 *
 * <ul>
 *   <li><b>Message Count Limit</b>: The limit of the number of messages that the server will accept
 *       in a single request.
 *   <li><b>Request Byte Limit</b>: The limit of the byte size of a request that the server will
 *       accept.
 * </ul>
 *
 * <p>For these values, individual requests that surpass the limit are rejected, and the batching
 * logic will not batch together requests if the resulting batch will surpass the limit. Thus, a
 * batch can be sent that is actually under the threshold if the next request would put the combined
 * request over the limit.
 *
 * <p>Batching also supports FlowControl. This can be used to prevent the batching implementation
 * from accumulating messages without limit, resulting eventually in an OutOfMemory exception. This
 * can occur if messages are created and added to batching faster than they can be processed. The
 * flow control behavior is controlled using FlowControlSettings.
 */
@AutoValue
public abstract class BatchingSettings {
  /** Get the element count threshold to use for batching. */
  @Nullable
  public abstract Long getElementCountThreshold();

  /** Get the request byte threshold to use for batching. */
  @Nullable
  public abstract Long getRequestByteThreshold();

  /** This method is obsolete. Use {@link #getDelayThresholdDuration() } instead */
  @Nullable
  @ObsoleteApi("Use getDelayThresholdDuration() instead")
  public org.threeten.bp.Duration getDelayThreshold() {
    return toThreetenDuration(getDelayThresholdDuration());
  }

  /** Get the delay threshold to use for batching. */
  @Nullable
  public abstract java.time.Duration getDelayThresholdDuration();

  /** Returns the Boolean object to indicate if the batching is enabled. Default to true */
  public abstract Boolean getIsEnabled();

  /** Get the flow control settings to use. */
  public abstract FlowControlSettings getFlowControlSettings();

  /** Get a new builder. */
  public static Builder newBuilder() {
    return new AutoValue_BatchingSettings.Builder()
        .setIsEnabled(true)
        .setElementCountThreshold(1L)
        .setRequestByteThreshold(1L)
        .setDelayThresholdDuration(java.time.Duration.ofMillis(1))
        .setFlowControlSettings(
            FlowControlSettings.newBuilder()
                .setLimitExceededBehavior(LimitExceededBehavior.Ignore)
                .build());
  }

  /** Get a builder with the same values as this object. */
  public abstract Builder toBuilder();

  /**
   * See the class documentation of {@link BatchingSettings} for a description of the different
   * values that can be set.
   */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * Set the element count threshold to use for batching. After this many elements are
     * accumulated, they will be wrapped up in a batch and sent.
     */
    public abstract Builder setElementCountThreshold(Long elementCountThreshold);

    /**
     * Set the request byte threshold to use for batching. After this many bytes are accumulated,
     * the elements will be wrapped up in a batch and sent.
     */
    public abstract Builder setRequestByteThreshold(Long requestByteThreshold);

    /** This method is obsolete. Use {@link #setDelayThresholdDuration(Duration)} instead */
    @ObsoleteApi("Use setDelayThresholdDuration(java.time.Duration) instead")
    public final Builder setDelayThreshold(org.threeten.bp.Duration delayThreshold) {
      return setDelayThresholdDuration(toJavaTimeDuration(delayThreshold));
    }

    /**
     * Set the delay threshold to use for batching. After this amount of time has elapsed (counting
     * from the first element added), the elements will be wrapped up in a batch and sent. This
     * value should not be set too high, usually on the order of milliseconds. Otherwise, calls
     * might appear to never complete.
     */
    public abstract Builder setDelayThresholdDuration(java.time.Duration delayThreshold);

    /**
     * Set if the batch should be enabled. If set to false, the batch logic will be disabled and the
     * simple API call will be used. Default to true.
     */
    public abstract Builder setIsEnabled(Boolean enabled);

    /** Set the flow control settings to be used. */
    public abstract Builder setFlowControlSettings(FlowControlSettings flowControlSettings);

    abstract BatchingSettings autoBuild();

    /** Build the BatchingSettings object. */
    public BatchingSettings build() {
      BatchingSettings settings = autoBuild();
      Preconditions.checkArgument(
          settings.getElementCountThreshold() == null || settings.getElementCountThreshold() > 0,
          "elementCountThreshold must be either unset or positive");
      Preconditions.checkArgument(
          settings.getRequestByteThreshold() == null || settings.getRequestByteThreshold() > 0,
          "requestByteThreshold must be either unset or positive");
      Preconditions.checkArgument(
          settings.getDelayThresholdDuration() == null
              || settings.getDelayThresholdDuration().compareTo(java.time.Duration.ZERO) > 0,
          "delayThreshold must be either unset or positive");
      return settings;
    }
  }
}
