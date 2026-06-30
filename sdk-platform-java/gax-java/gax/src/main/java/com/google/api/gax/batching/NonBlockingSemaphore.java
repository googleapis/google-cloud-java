/*
 * Copyright 2018 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.api.gax.batching;

import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicLong;

/** A {@link Semaphore64} that immediately returns with failure if permits are not available. */
class NonBlockingSemaphore implements Semaphore64 {
  private AtomicLong acquiredPermits;
  private AtomicLong limit;

  private static void checkNotNegative(long l) {
    Preconditions.checkArgument(l >= 0, "negative permits not allowed: %s", l);
  }

  NonBlockingSemaphore(long permits) {
    checkNotNegative(permits);
    this.acquiredPermits = new AtomicLong(0);
    this.limit = new AtomicLong(permits);
  }

  @Override
  public void release(long permits) {
    checkNotNegative(permits);
    while (true) {
      long old = acquiredPermits.get();
      // TODO: throw exceptions when the permits overflow
      long newAcquired = Math.max(0, old - permits);
      if (acquiredPermits.compareAndSet(old, newAcquired)) {
        return;
      }
    }
  }

  @Override
  public boolean acquire(long permits) {
    checkNotNegative(permits);
    while (true) {
      long old = acquiredPermits.get();
      if (old + permits > limit.get()) {
        return false;
      }
      if (acquiredPermits.compareAndSet(old, old + permits)) {
        return true;
      }
    }
  }

  @Override
  public boolean acquirePartial(long permits) {
    checkNotNegative(permits);
    // To allow individual oversized requests to be sent, clamp the requested permits to the maximum
    // limit. This will allow individual large requests to be sent. Please note that this behavior
    // will result in acquiredPermits going over limit.
    while (true) {
      long old = acquiredPermits.get();
      if (old + permits > limit.get() && old > 0) {
        return false;
      }
      if (acquiredPermits.compareAndSet(old, old + permits)) {
        return true;
      }
    }
  }

  @Override
  public void increasePermitLimit(long permits) {
    checkNotNegative(permits);
    limit.addAndGet(permits);
  }

  @Override
  public void reducePermitLimit(long reduction) {
    checkNotNegative(reduction);

    while (true) {
      long oldLimit = limit.get();
      Preconditions.checkState(oldLimit - reduction > 0, "permit limit underflow");
      if (limit.compareAndSet(oldLimit, oldLimit - reduction)) {
        return;
      }
    }
  }

  @Override
  public long getPermitLimit() {
    return limit.get();
  }
}
