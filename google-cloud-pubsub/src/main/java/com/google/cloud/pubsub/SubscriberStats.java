/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.pubsub;

import com.google.auto.value.AutoValue;

/**
 * A snapshot of the subscriber statistics at the time they were requested from the {@link
 * Subscriber}.
 */
@AutoValue
public abstract class SubscriberStats {
  
  @AutoValue
  //TODO: Finish implementation.
  public abstract static class Stats {}

  /** Number of successfully published messages. */
  public abstract long getReceivedMessages();

  /** Number of successfully published messages. */
  public abstract long getAckedMessages();

  /** Number of received messages. */
  public abstract long getTotalReceivedMessages();

  /** Number messages acked. */
  public abstract long getTotalAckedMessages();

  /** End to end latency. */
  public abstract Stats getEndToEndLatency();

  /**
   * Acknowledgement latency; time in between the message has been received and then acknowledged or
   * rejected.
   */
  public abstract Stats getAckLatency();

  /** Number of messages for which we have auto extended its acknowledgement deadline. */
  public abstract long getNumberOfAutoExtendedAckDeadlines();

  public static Builder newBuilder() {
    return new AutoValue_SubscriberStats.Builder();
  }

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract Builder setReceivedMessages(long value);

    public abstract Builder setAckedMessages(long value);

    public abstract Builder setTotalReceivedMessages(long value);

    public abstract Builder setTotalAckedMessages(long value);

    public abstract Builder setEndToEndLatency(Stats value);

    public abstract Builder setAckLatency(Stats value);

    public abstract Builder setNumberOfAutoExtendedAckDeadlines(long value);

    public abstract SubscriberStats build();
  }
}
