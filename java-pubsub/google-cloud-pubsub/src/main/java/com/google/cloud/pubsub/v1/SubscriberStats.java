/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.pubsub.v1;

import com.google.auto.value.AutoValue;

/**
 * A snapshot of the subscriber statistics at the time they were requested from the {@link
 * Subscriber}.
 */
@AutoValue
abstract class SubscriberStats {

  @AutoValue
  // TODO: Finish implementation.
  abstract static class Stats {}

  /** Number of successfully published messages. */
  abstract long getReceivedMessages();

  /** Number of successfully published messages. */
  abstract long getAckedMessages();

  /** Number of received messages. */
  abstract long getTotalReceivedMessages();

  /** Number messages acked. */
  abstract long getTotalAckedMessages();

  /** End to end latency. */
  abstract Stats getEndToEndLatency();

  /**
   * Acknowledgement latency; time in between the message has been received and then acknowledged or
   * rejected.
   */
  abstract Stats getAckLatency();

  /** Number of messages for which we have auto extended its acknowledgement deadline. */
  abstract long getNumberOfAutoExtendedAckDeadlines();

  static Builder newBuilder() {
    return new AutoValue_SubscriberStats.Builder();
  }

  @AutoValue.Builder
  abstract static class Builder {
    abstract Builder setReceivedMessages(long value);

    abstract Builder setAckedMessages(long value);

    abstract Builder setTotalReceivedMessages(long value);

    abstract Builder setTotalAckedMessages(long value);

    abstract Builder setEndToEndLatency(Stats value);

    abstract Builder setAckLatency(Stats value);

    abstract Builder setNumberOfAutoExtendedAckDeadlines(long value);

    abstract SubscriberStats build();
  }
}
