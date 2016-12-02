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

import com.google.common.math.Stats;
import java.time.LocalDateTime;
import javax.annotation.concurrent.Immutable;

/**
 * A snapshot of the subscriber statistics at the time they were requested from the {@link
 * Subscriber}.
 */
//TODO: Finish implementation.
@Immutable
public class SubscriberStats {
  private final LocalDateTime startTime;
  private final long totalReceivedMessages;
  private final long totalAckedMessages;
  private final Stats endToEndLatency;
  private final Stats ackLatency;
  private final long numberOfAutoExtendedAckDeadlines;

  SubscriberStats(LocalDateTime startTime) {
    this.startTime = startTime;
    this.totalReceivedMessages = 0;
    this.totalAckedMessages = 0;
    this.numberOfAutoExtendedAckDeadlines = 0;
    this.endToEndLatency = null;
    this.ackLatency = null;
  }

  /** Number of successfully published messages. */
  public long getReceivedMessages() {
    return totalReceivedMessages;
  }

  /** Number of successfully published messages. */
  public long getAckedMessages() {
    return totalAckedMessages;
  }

  /** Time when the subscriber started. */
  public LocalDateTime getStartTime() {
    return startTime;
  }

  /** Number of received messages. */
  public long getTotalReceivedMessages() {
    return totalReceivedMessages;
  }

  /** Number messages acked. */
  public long getTotalAckedMessages() {
    return totalAckedMessages;
  }

  /** End to end latency. */
  public Stats getEndToEndLatency() {
    return endToEndLatency;
  }

  /**
   * Acknowledgement latency; time in between the message has been received and then acknowledged or
   * rejected.
   */
  public Stats getAckLatency() {
    return ackLatency;
  }

  /** Number of messages for which we have auto extended its acknowledgement deadline. */
  public long getNumberOfAutoExtendedAckDeadlines() {
    return numberOfAutoExtendedAckDeadlines;
  }
}
