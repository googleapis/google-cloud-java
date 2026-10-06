/*
 * Copyright 2026 Google LLC
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
package com.google.api.gax.rpc.mtls;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;

class CertificateRotationTrackerTest {

  @Test
  void markRefreshed_duringInProgressDiskCheck_doesNotLeaveStaleCachedFingerprint()
      throws Exception {
    CountDownLatch readStarted = new CountDownLatch(1);
    CountDownLatch releaseRead = new CountDownLatch(1);
    AtomicInteger reads = new AtomicInteger();
    AtomicReference<String> diskFingerprint = new AtomicReference<>("F1");
    CertificateRotationTracker tracker =
        new CertificateRotationTracker(
            () -> "/fake/cert/path",
            path -> {
              String fingerprint = diskFingerprint.get();
              // The first read after the constructor's baseline read blocks after reading F1.
              if (reads.incrementAndGet() == 2) {
                readStarted.countDown();
                try {
                  releaseRead.await();
                } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
                }
              }
              return fingerprint;
            });

    Thread diskCheckThread = new Thread(tracker::shouldRefresh);
    Thread markThread = new Thread(() -> tracker.markRefreshed("F2"));
    try {
      diskCheckThread.start();
      assertTrue(readStarted.await(5, TimeUnit.SECONDS));
      // The certificate rotates and a refresh switches to it while the disk check that read the
      // old certificate is still in progress.
      diskFingerprint.set("F2");
      markThread.start();
      long deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5);
      while (markThread.getState() != Thread.State.WAITING
          && markThread.getState() != Thread.State.TERMINATED) {
        assertTrue(System.nanoTime() < deadline);
        Thread.sleep(1);
      }
    } finally {
      releaseRead.countDown();
    }
    diskCheckThread.join(5000);
    markThread.join(5000);
    assertFalse(diskCheckThread.isAlive());
    assertFalse(markThread.isAlive());

    // The old fingerprint read by the in-progress check must not be left in the cache, where it
    // would make shouldRefresh() report a rotation that has already been handled.
    assertEquals("F2", tracker.getActiveCertFingerprint());
    assertFalse(tracker.shouldRefresh());
  }
}
