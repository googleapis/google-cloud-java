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

import com.google.api.core.ApiClock;
import com.google.api.core.InternalApi;

/**
 * A barrier kind of object that helps keep track of pending actions and synchronously wait until
 * all have completed.
 */
class Waiter {
  private int pendingCount;

  Waiter() {
    pendingCount = 0;
  }

  public synchronized void incrementPendingCount(int delta) {
    this.pendingCount += delta;
    if (pendingCount == 0) {
      notifyAll();
    }
  }

  public synchronized void waitComplete() {
    boolean interrupted = false;
    try {
      while (pendingCount > 0) {
        try {
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

  public synchronized boolean tryWait(long timeoutMilliseconds, ApiClock clock) {
    long startTime = clock.millisTime();
    long remainingMilliseconds = timeoutMilliseconds;
    boolean interrupted = false;
    boolean completedWait = true;
    try {
      while (pendingCount > 0) {
        if (remainingMilliseconds <= 0) {
          completedWait = false;
          break;
        }
        try {
          wait(remainingMilliseconds);
        } catch (InterruptedException e) {
          interrupted = true;
        }
        remainingMilliseconds = timeoutMilliseconds - (clock.millisTime() - startTime);
      }
    } finally {
      if (interrupted) {
        Thread.currentThread().interrupt();
      }
    }
    return completedWait;
  }

  @InternalApi
  public int pendingCount() {
    return pendingCount;
  }
}
