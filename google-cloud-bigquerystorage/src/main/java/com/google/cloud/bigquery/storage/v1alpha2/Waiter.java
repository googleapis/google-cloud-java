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

package com.google.cloud.bigquery.storage.v1alpha2;

import com.google.api.core.InternalApi;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.UnimplementedException;
import io.grpc.Status;
import java.util.logging.Logger;

/**
 * A barrier kind of object that helps keep track of pending actions and synchronously wait until
 * all have completed.
 */
class Waiter {
  private static final Logger LOG = Logger.getLogger(Waiter.class.getName());

  private int pendingCount;
  private int pendingSize;
  FlowControlSettings flowControlSettings;

  Waiter(FlowControlSettings flowControlSettings) {
    pendingCount = 0;
    pendingSize = 0;
    this.flowControlSettings = flowControlSettings;
  }

  public synchronized void incrementPendingCount(int delta) {
    this.pendingCount += delta;
    if (pendingCount == 0) {
      notifyAll();
    }
  }

  public synchronized void incrementPendingSize(int delta) {
    this.pendingSize += delta;
  }

  private void wait(String message) {
    boolean interrupted = false;
    try {
      LOG.fine("Wait on: " + message);
      wait();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private void handleOverLimit(String message) {
    boolean interrupted = false;
    switch (this.flowControlSettings.getLimitExceededBehavior()) {
      case Block:
        wait(message);
        break;
      case ThrowException:
        throw new IllegalStateException("FlowControl limit exceeded: " + message);
      case Ignore:
        return;
      default:
        throw new UnimplementedException(
            "Unknown behavior setting: "
                + this.flowControlSettings.getLimitExceededBehavior().toString(),
            null,
            GrpcStatusCode.of(Status.Code.UNIMPLEMENTED),
            false);
    }
  }

  public synchronized void waitOnElementCount() {
    LOG.finer(
        "Waiting on element count "
            + this.pendingCount
            + " "
            + this.flowControlSettings.getMaxOutstandingElementCount());
    while (this.pendingCount >= this.flowControlSettings.getMaxOutstandingElementCount()) {
      handleOverLimit("Element count");
    }
  }

  public synchronized void waitOnSizeLimit(int incomingSize) {
    LOG.finer(
        "Waiting on size limit "
            + (this.pendingSize + incomingSize)
            + " "
            + this.flowControlSettings.getMaxOutstandingRequestBytes());
    while (this.pendingSize + incomingSize
        >= this.flowControlSettings.getMaxOutstandingRequestBytes()) {
      handleOverLimit("Byte size");
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

  @InternalApi
  public int pendingCount() {
    return pendingCount;
  }

  @InternalApi
  public int pendingSize() {
    return pendingSize;
  }
}
