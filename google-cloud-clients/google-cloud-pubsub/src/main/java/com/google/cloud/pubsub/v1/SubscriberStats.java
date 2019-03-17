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
import java.util.List;

/**
 * A snapshot of the subscriber statistics at the time they were requested from the {@link
 * Subscriber}.
 */
@AutoValue
public abstract class SubscriberStats {

  /** Number of received messages. */
  public abstract long getTotalReceivedMessages();

  /** Number messages acked. */
  public abstract long getTotalAckedMessages();

  /** Number messages nacked. */
  public abstract long getTotalNackedMessages();

  /** Number of messages for which we have auto extended its acknowledgement deadline. */
  public abstract long getNumberOfAutoExtendedAckDeadlines();

  static Builder newBuilder() {
    return new AutoValue_SubscriberStats.Builder();
  }

  @AutoValue.Builder
  abstract static class Builder {
    abstract Builder setTotalReceivedMessages(long value);

    abstract Builder setTotalAckedMessages(long value);

    abstract Builder setTotalNackedMessages(long value);

    abstract Builder setNumberOfAutoExtendedAckDeadlines(long value);

    abstract SubscriberStats build();

    SubscriberStats build(List<SubscriberStats> stats) {
      return SubscriberStats.newBuilder()
          .setNumberOfAutoExtendedAckDeadlines(getTotalNumberOfAutoExtendedAckDeadlines(stats))
          .setTotalAckedMessages(getTotalAckedMessages(stats))
          .setTotalNackedMessages(getTotalNackedMessages(stats))
          .setTotalReceivedMessages(getTotalReceivedMessages(stats))
          .build();
    }

    private static long getTotalReceivedMessages(List<SubscriberStats> stats) {
      long res = 0L;
      for (SubscriberStats stat : stats) {
        res += stat.getTotalReceivedMessages();
      }
      return res;
    }

    private static long getTotalAckedMessages(List<SubscriberStats> stats) {
      long res = 0L;
      for (SubscriberStats stat : stats) {
        res += stat.getTotalAckedMessages();
      }
      return res;
    }

    private static long getTotalNackedMessages(List<SubscriberStats> stats) {
      long res = 0L;
      for (SubscriberStats stat : stats) {
        res += stat.getTotalNackedMessages();
      }
      return res;
    }

    private static long getTotalNumberOfAutoExtendedAckDeadlines(List<SubscriberStats> stats) {
      long res = 0L;
      for (SubscriberStats stat : stats) {
        res += stat.getNumberOfAutoExtendedAckDeadlines();
      }
      return res;
    }
  }
}
