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
import java.util.function.Function;
import org.junit.jupiter.api.Test;

class CertificateRotationTrackerTest {

  private static final String CERT_PATH = "/fake/cert/path";

  /** Fingerprint reader backed by {@link #fingerprint} that counts disk reads. */
  private final AtomicReference<String> fingerprint = new AtomicReference<>("F1");

  private final AtomicInteger reads = new AtomicInteger();
  private final Function<String, String> reader =
      path -> {
        assertEquals(CERT_PATH, path);
        reads.incrementAndGet();
        return fingerprint.get();
      };

  private CertificateRotationTracker newTracker() {
    return new CertificateRotationTracker(() -> CERT_PATH, reader);
  }

  @Test
  void constructor_readsBaselineFingerprint() {
    CertificateRotationTracker tracker = newTracker();

    assertEquals("F1", tracker.getActiveCertFingerprint());
    assertEquals(1, reads.get());
  }

  @Test
  void constructor_withoutCertPath_hasEmptyFingerprintAndNeverReadsDisk() {
    CertificateRotationTracker tracker = new CertificateRotationTracker(() -> null, reader);

    assertEquals("", tracker.getActiveCertFingerprint());
    assertFalse(tracker.shouldRefresh());
    assertEquals("", tracker.readDiskFingerprint());
    assertEquals(0, reads.get());
  }

  @Test
  void constructor_withUnreadableCert_hasEmptyFingerprint() {
    fingerprint.set(null);

    assertEquals("", newTracker().getActiveCertFingerprint());
  }

  @Test
  void shouldRefresh_whenCertUnchanged_returnsFalse() {
    assertFalse(newTracker().shouldRefresh());
  }

  @Test
  void shouldRefresh_whenCertChanged_returnsTrue() {
    CertificateRotationTracker tracker = newTracker();
    fingerprint.set("F2");

    assertTrue(tracker.shouldRefresh());
  }

  @Test
  void shouldRefresh_comparesFingerprintsCaseInsensitively() {
    fingerprint.set("abcdef");
    CertificateRotationTracker tracker = newTracker();
    fingerprint.set("ABCDEF");

    assertFalse(tracker.shouldRefresh());
  }

  @Test
  void shouldRefresh_whenCertUnreadable_returnsFalse() {
    CertificateRotationTracker tracker = newTracker();
    fingerprint.set("");

    assertFalse(tracker.shouldRefresh());
  }

  @Test
  void shouldRefresh_cachesDetectedRotation() {
    CertificateRotationTracker tracker = newTracker();
    fingerprint.set("F2");

    assertTrue(tracker.shouldRefresh());
    assertTrue(tracker.shouldRefresh());
    // One baseline read plus one disk check; the second call is served from the cache.
    assertEquals(2, reads.get());
  }

  @Test
  void shouldRefresh_doesNotCacheUnchangedResult() {
    CertificateRotationTracker tracker = newTracker();

    assertFalse(tracker.shouldRefresh());
    fingerprint.set("F2");

    // The rotation is detected immediately rather than after a cache TTL.
    assertTrue(tracker.shouldRefresh());
    assertEquals(3, reads.get());
  }

  @Test
  void readDiskFingerprint_bypassesCache() {
    CertificateRotationTracker tracker = newTracker();
    fingerprint.set("F2");
    assertTrue(tracker.shouldRefresh());
    fingerprint.set("F3");

    assertEquals("F3", tracker.readDiskFingerprint());
  }

  @Test
  void readDiskFingerprint_whenCertUnreadable_returnsEmpty() {
    CertificateRotationTracker tracker = newTracker();
    fingerprint.set(null);

    assertEquals("", tracker.readDiskFingerprint());
  }

  @Test
  void markRefreshed_updatesActiveFingerprintAndClearsCachedRotation() {
    CertificateRotationTracker tracker = newTracker();
    fingerprint.set("F2");
    assertTrue(tracker.shouldRefresh());

    tracker.markRefreshed("F2");

    assertEquals("F2", tracker.getActiveCertFingerprint());
    assertTrue(tracker.isAlreadyActive("F2"));
    assertFalse(tracker.shouldRefresh());
  }

  @Test
  void markRefreshed_ignoresNullAndEmptyFingerprints() {
    CertificateRotationTracker tracker = newTracker();

    tracker.markRefreshed(null);
    tracker.markRefreshed("");

    assertEquals("F1", tracker.getActiveCertFingerprint());
  }

  @Test
  void isAlreadyActive_matchesActiveFingerprintCaseInsensitively() {
    fingerprint.set("abcdef");
    CertificateRotationTracker tracker = newTracker();

    assertTrue(tracker.isAlreadyActive("abcdef"));
    assertTrue(tracker.isAlreadyActive("ABCDEF"));
    assertFalse(tracker.isAlreadyActive("other"));
    assertFalse(tracker.isAlreadyActive(null));
  }

  @Test
  void invalidateCache_forcesNextCheckToReadDisk() {
    CertificateRotationTracker tracker = newTracker();
    fingerprint.set("F2");
    assertTrue(tracker.shouldRefresh());
    // The certificate is rolled back while the rotation is cached.
    fingerprint.set("F1");
    assertTrue(tracker.shouldRefresh());

    tracker.invalidateCache();

    assertFalse(tracker.shouldRefresh());
  }

  @Test
  void shouldRefresh_rereadsDiskOnceCachedRotationExpires() throws InterruptedException {
    CertificateRotationTracker tracker = newTracker();
    fingerprint.set("F2");
    assertTrue(tracker.shouldRefresh());
    // The certificate becomes unreadable while the rotation is cached; the cached rotation is
    // still reported until it expires.
    fingerprint.set("");
    assertTrue(tracker.shouldRefresh());

    // Wait past the 1 second cache TTL.
    Thread.sleep(1100);

    // The expired entry is not used: the disk is read again, and an unreadable certificate is not
    // reported as a rotation.
    assertFalse(tracker.shouldRefresh());
    fingerprint.set("F1");
    assertFalse(tracker.shouldRefresh());
  }

  @Test
  void shouldRefresh_whenCertBecomesReadableAfterUnreadableBaseline_detectsRotation() {
    // For example, the certificate had not been written yet when the channel was created.
    fingerprint.set("");
    CertificateRotationTracker tracker = newTracker();
    assertEquals("", tracker.getActiveCertFingerprint());
    assertFalse(tracker.shouldRefresh());

    fingerprint.set("F1");

    assertTrue(tracker.shouldRefresh());
    tracker.markRefreshed("F1");
    assertFalse(tracker.shouldRefresh());
  }

  @Test
  void stringConstructor_withNullOrMissingCert_hasEmptyFingerprintAndNoRotation() {
    for (String certPath : new String[] {null, "/nonexistent/workload-cert.pem"}) {
      CertificateRotationTracker tracker = new CertificateRotationTracker(certPath);

      assertEquals("", tracker.getActiveCertFingerprint());
      assertEquals("", tracker.readDiskFingerprint());
      assertFalse(tracker.shouldRefresh());
    }
  }

  /**
   * Creates a tracker whose first disk check after the constructor's baseline read blocks, after
   * reading the current fingerprint, until {@code releaseRead} is counted down.
   */
  private CertificateRotationTracker newTrackerWithBlockingDiskCheck(
      CountDownLatch readStarted, CountDownLatch releaseRead) {
    return new CertificateRotationTracker(
        () -> CERT_PATH,
        path -> {
          String read = reader.apply(path);
          if (reads.get() == 2) {
            readStarted.countDown();
            try {
              releaseRead.await();
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
          }
          return read;
        });
  }

  /** Waits until {@code thread} is parked waiting for a lock, or has finished. */
  private static void awaitWaitingOrTerminated(Thread thread) throws InterruptedException {
    long deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5);
    while (thread.getState() != Thread.State.WAITING
        && thread.getState() != Thread.State.TERMINATED) {
      assertTrue(System.nanoTime() < deadline);
      Thread.sleep(1);
    }
  }

  @Test
  void shouldRefresh_concurrentCallersShareOneDiskReadOfRotation() throws Exception {
    CountDownLatch readStarted = new CountDownLatch(1);
    CountDownLatch releaseRead = new CountDownLatch(1);
    CertificateRotationTracker tracker = newTrackerWithBlockingDiskCheck(readStarted, releaseRead);
    fingerprint.set("F2");
    AtomicReference<Boolean> firstResult = new AtomicReference<>();
    AtomicReference<Boolean> secondResult = new AtomicReference<>();

    Thread first = new Thread(() -> firstResult.set(tracker.shouldRefresh()));
    Thread second = new Thread(() -> secondResult.set(tracker.shouldRefresh()));
    try {
      first.start();
      assertTrue(readStarted.await(5, TimeUnit.SECONDS));
      // Another failing RPC checks for a rotation while the first disk check is in progress.
      second.start();
      awaitWaitingOrTerminated(second);
    } finally {
      releaseRead.countDown();
    }
    first.join(5000);
    second.join(5000);
    assertFalse(first.isAlive());
    assertFalse(second.isAlive());

    assertEquals(Boolean.TRUE, firstResult.get());
    assertEquals(Boolean.TRUE, secondResult.get());
    // One baseline read plus a single disk check shared by both callers.
    assertEquals(2, reads.get());
  }

  @Test
  void markRefreshed_duringInProgressDiskCheck_doesNotLeaveStaleCachedFingerprint()
      throws Exception {
    CountDownLatch readStarted = new CountDownLatch(1);
    CountDownLatch releaseRead = new CountDownLatch(1);
    CertificateRotationTracker tracker = newTrackerWithBlockingDiskCheck(readStarted, releaseRead);

    Thread diskCheckThread = new Thread(tracker::shouldRefresh);
    Thread markThread = new Thread(() -> tracker.markRefreshed("F2"));
    try {
      diskCheckThread.start();
      assertTrue(readStarted.await(5, TimeUnit.SECONDS));
      // The certificate rotates and a refresh switches to it while the disk check that read the
      // old certificate is still in progress.
      fingerprint.set("F2");
      markThread.start();
      awaitWaitingOrTerminated(markThread);
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
