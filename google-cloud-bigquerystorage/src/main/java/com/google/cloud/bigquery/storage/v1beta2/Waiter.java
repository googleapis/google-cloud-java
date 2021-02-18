/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.storage.v1beta2;

import com.google.api.core.InternalApi;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * A barrier kind of object that helps keep track of pending actions and synchronously wait until
 * all have completed.
 */
class Waiter {
  private static final Logger LOG =
      Logger.getLogger(com.google.cloud.bigquery.storage.v1beta2.Waiter.class.getName());

  private long pendingCount;
  private long pendingSize;
  private long countLimit;
  private long sizeLimit;
  private FlowController.LimitExceededBehavior behavior;
  private LinkedList<CountDownLatch> awaitingMessageAcquires;
  private LinkedList<CountDownLatch> awaitingBytesAcquires;
  private final Lock lock;

  Waiter(FlowControlSettings flowControlSettings) {
    pendingCount = 0;
    pendingSize = 0;
    this.awaitingMessageAcquires = new LinkedList<CountDownLatch>();
    this.awaitingBytesAcquires = new LinkedList<CountDownLatch>();
    this.countLimit = flowControlSettings.getMaxOutstandingElementCount();
    this.sizeLimit = flowControlSettings.getMaxOutstandingRequestBytes();
    this.behavior = flowControlSettings.getLimitExceededBehavior();
    this.lock = new ReentrantLock();
  }

  private void notifyNextAcquires() {
    if (!awaitingMessageAcquires.isEmpty()) {
      CountDownLatch awaitingAcquire = awaitingMessageAcquires.getFirst();
      awaitingAcquire.countDown();
    }
    if (!awaitingBytesAcquires.isEmpty()) {
      CountDownLatch awaitingAcquire = awaitingBytesAcquires.getFirst();
      awaitingAcquire.countDown();
    }
  }

  public synchronized void release(long messageSize) throws IllegalStateException {
    lock.lock();
    --pendingCount;
    if (pendingCount < 0) {
      throw new IllegalStateException("pendingCount cannot be less than 0");
    }
    pendingSize -= messageSize;
    if (pendingSize < 0) {
      throw new IllegalStateException("pendingSize cannot be less than 0");
    }
    notifyNextAcquires();
    lock.unlock();
    notifyAll();
  }

  public void acquire(long messageSize) throws FlowController.FlowControlException {
    lock.lock();
    try {
      if (pendingCount >= countLimit
          && behavior == FlowController.LimitExceededBehavior.ThrowException) {
        throw new FlowController.MaxOutstandingElementCountReachedException(countLimit);
      }
      if (pendingSize + messageSize >= sizeLimit
          && behavior == FlowController.LimitExceededBehavior.ThrowException) {
        throw new FlowController.MaxOutstandingRequestBytesReachedException(sizeLimit);
      }

      CountDownLatch messageWaiter = null;
      while (pendingCount >= countLimit) {
        if (messageWaiter == null) {
          messageWaiter = new CountDownLatch(1);
          awaitingMessageAcquires.addLast(messageWaiter);
        } else {
          // This message already in line stays at the head of the line.
          messageWaiter = new CountDownLatch(1);
          awaitingMessageAcquires.set(0, messageWaiter);
        }
        lock.unlock();
        try {
          messageWaiter.await();
        } catch (InterruptedException e) {
          LOG.warning("Interrupted while waiting to acquire flow control tokens");
        }
        lock.lock();
      }
      ++pendingCount;
      if (messageWaiter != null) {
        awaitingMessageAcquires.removeFirst();
      }

      if (!awaitingMessageAcquires.isEmpty() && pendingCount < countLimit) {
        awaitingMessageAcquires.getFirst().countDown();
      }

      // Now acquire space for bytes.
      CountDownLatch bytesWaiter = null;
      Long bytesRemaining = messageSize;
      while (pendingSize + messageSize >= sizeLimit) {
        if (bytesWaiter == null) {
          // This message gets added to the back of the line.
          bytesWaiter = new CountDownLatch(1);
          awaitingBytesAcquires.addLast(bytesWaiter);
        } else {
          // This message already in line stays at the head of the line.
          bytesWaiter = new CountDownLatch(1);
          awaitingBytesAcquires.set(0, bytesWaiter);
        }
        lock.unlock();
        try {
          bytesWaiter.await();
        } catch (InterruptedException e) {
          LOG.warning("Interrupted while waiting to acquire flow control tokens");
        }
        lock.lock();
      }

      pendingSize += messageSize;
      if (bytesWaiter != null) {
        awaitingBytesAcquires.removeFirst();
      }
      // There may be some surplus bytes left; let the next message waiting for bytes have some.
      if (!awaitingBytesAcquires.isEmpty() && pendingSize < sizeLimit) {
        awaitingBytesAcquires.getFirst().countDown();
      }
    } finally {
      lock.unlock();
    }
  }

  public synchronized void waitComplete(long timeoutMillis) throws InterruptedException {
    long end = System.currentTimeMillis() + timeoutMillis;
    lock.lock();
    try {
      while (pendingCount > 0 && (timeoutMillis == 0 || end > System.currentTimeMillis())) {
        lock.unlock();
        try {
          wait(timeoutMillis == 0 ? 0 : end - System.currentTimeMillis());
        } catch (InterruptedException e) {
          throw e;
        }
        lock.lock();
      }
      if (pendingCount > 0) {
        throw new InterruptedException("Wait timeout");
      }
    } finally {
      lock.unlock();
    }
  }

  @InternalApi
  public long pendingCount() {
    return pendingCount;
  }

  @InternalApi
  public long pendingSize() {
    return pendingSize;
  }
}
