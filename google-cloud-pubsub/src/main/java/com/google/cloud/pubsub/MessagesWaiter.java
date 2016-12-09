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

import com.google.common.annotations.VisibleForTesting;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A barrier kind of object that helps to keep track and synchronously wait on pending messages.
 */
class MessagesWaiter {
  private int pendingMessages;

  MessagesWaiter() {
    pendingMessages = 0;
  }

  public synchronized void incrementPendingMessages(int messages) {
    this.pendingMessages += messages;
    if (pendingMessages == 0) {
      notifyAll();
    }
  }

  public synchronized void waitNoMessages() {
    waitNoMessages(new AtomicBoolean());
  }
  
  @VisibleForTesting
  synchronized void waitNoMessages(AtomicBoolean waitReached) {
    boolean interrupted = false;
    try {
      while (pendingMessages > 0) {
        try {
          waitReached.set(true);
          wait();
        } catch (InterruptedException e) {
          // Ignored, uninterruptibly.
          interrupted = true;
        }
      }
    } finally {
      if (interrupted) {
        Thread.currentThread().interrupt();
      }
    }
  }
  
  @VisibleForTesting
  public int pendingMessages() {
    return pendingMessages;
  }
}