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

import com.google.cloud.pubsub.Publisher.CloudPubsubFlowControlException;
import com.google.cloud.pubsub.Publisher.MaxOutstandingBytesReachedException;
import com.google.cloud.pubsub.Publisher.MaxOutstandingMessagesReachedException;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.concurrent.Semaphore;
import javax.annotation.Nullable;

/** Provides flow control capability for Pub/Sub client classes. */
class FlowController {
  @Nullable private final Semaphore outstandingMessageCount;
  @Nullable private final Semaphore outstandingByteCount;
  private final boolean failOnLimits;
  private final Optional<Integer> maxOutstandingMessages;
  private final Optional<Integer> maxOutstandingBytes;

  FlowController(
      Optional<Integer> maxOutstandingMessages,
      Optional<Integer> maxOutstandingBytes,
      boolean failOnFlowControlLimits) {
    this.maxOutstandingMessages = Preconditions.checkNotNull(maxOutstandingMessages);
    this.maxOutstandingBytes = Preconditions.checkNotNull(maxOutstandingBytes);
    outstandingMessageCount =
        maxOutstandingMessages.isPresent() ? new Semaphore(maxOutstandingMessages.get()) : null;
    outstandingByteCount =
        maxOutstandingBytes.isPresent() ? new Semaphore(maxOutstandingBytes.get()) : null;
    this.failOnLimits = failOnFlowControlLimits;
  }

  void reserve(int messages, int bytes) throws CloudPubsubFlowControlException {
    Preconditions.checkArgument(messages > 0);
    
    if (outstandingMessageCount != null) {
      if (!failOnLimits) {
        outstandingMessageCount.acquireUninterruptibly(messages);
      } else if (!outstandingMessageCount.tryAcquire(messages)) {
        throw new MaxOutstandingMessagesReachedException(maxOutstandingMessages.get());
      }
    }

    // Will always allow to send a message even if it is larger than the flow control limit,
    // if it doesn't then it will deadlock the thread.
    if (outstandingByteCount != null) {
      int permitsToDraw = Math.min(bytes, maxOutstandingBytes.get());
      if (!failOnLimits) {
        outstandingByteCount.acquireUninterruptibly(permitsToDraw);
      } else if (!outstandingByteCount.tryAcquire(permitsToDraw)) {
        throw new MaxOutstandingBytesReachedException(maxOutstandingBytes.get());
      }
    }
  }

  void release(int messages, int bytes) {
    Preconditions.checkArgument(messages > 0);
    
    if (outstandingMessageCount != null) {
      outstandingMessageCount.release(messages);
    }
    if (outstandingByteCount != null) {
      // Need to return at most as much bytes as it can be drawn.
      int permitsToReturn = Math.min(bytes, maxOutstandingBytes.get());
      outstandingByteCount.release(permitsToReturn);
    }
  }
}
