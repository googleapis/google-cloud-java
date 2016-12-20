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
 * A snapshot of the publisher statistics at the time they were requested from the {@link
 * Publisher}.
 */
@AutoValue
public abstract class PublisherStats {
  /** Number of successfully published messages. */
  public abstract long getAckedMessages();

  /** Number of messages that failed to publish. */
  public abstract long getFailedMessages();

  /** Number of messages pending to publish, includes message in-flight. */
  public abstract long getPendingMessages();

  /** Total messages sent, equal to pending + acked + failed messages. */
  public abstract long getSentMessages();

  public static Builder newBuilder() {
    return new AutoValue_PublisherStats.Builder();
  }

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract Builder setAckedMessages(long value);

    public abstract Builder setFailedMessages(long value);

    public abstract Builder setPendingMessages(long value);

    public abstract Builder setSentMessages(long value);

    public abstract PublisherStats build();
  }
}
