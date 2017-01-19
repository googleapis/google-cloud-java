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

import javax.annotation.concurrent.Immutable;

/**
 * A snapshot of the publisher statistics at the time they were requested from the {@link
 * Publisher}.
 */
//TODO: Finish implementation.
@Immutable
public class PublisherStats {
  private final long sentMessages;
  private final long ackedMessages;
  private final long failedMessages;
  private final long pendingMessages;

  PublisherStats(long sentMessages, long ackedMessages, long failedMessages, long pendingMessages) {
    this.sentMessages = sentMessages;
    this.ackedMessages = ackedMessages;
    this.failedMessages = failedMessages;
    this.pendingMessages = pendingMessages;
  }

  /** Number of successfully published messages. */
  public long getAckedMessages() {
    return ackedMessages;
  }

  /** Number of messages that failed to publish. */
  public long getFailedMessages() {
    return failedMessages;
  }

  /** Number of messages pending to publish, includes message in-flight. */
  public long getPendingMessages() {
    return pendingMessages;
  }

  /** Total messages sent, equal to pending + acked + failed messages. */
  public long getSentMessages() {
    return sentMessages;
  }
}
