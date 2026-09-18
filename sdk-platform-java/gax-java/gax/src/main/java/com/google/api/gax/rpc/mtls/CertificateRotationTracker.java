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

import com.google.api.core.InternalApi;
import com.google.common.base.Strings;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.function.Supplier;
import org.jspecify.annotations.Nullable;

/**
 * Thread-safe helper that tracks workload certificate fingerprints on disk to detect mTLS
 * certificate rotations for transport channels ({@code ChannelPool} and {@code
 * RefreshingHttpJsonChannel}).
 *
 * <p>For internal use only.
 */
@InternalApi
public class CertificateRotationTracker {

  /**
   * Duration (1 second) for which a detected certificate rotation (where the disk fingerprint
   * differs from {@code activeCertFingerprint}) is cached in memory.
   *
   * <p>When a certificate rotates on disk, many concurrent in-flight RPCs may fail with {@code
   * UNAUTHENTICATED} simultaneously and call {@link #shouldRefresh()}. Caching positive rotation
   * detections for 1 second coalesces disk reads ({@code Files.readAllBytes}) and SHA-256 hashing
   * across concurrent threads to prevent a thundering herd of file I/O, while bounding maximum
   * staleness to 1 second.
   */
  private static final long POSITIVE_ROTATION_CACHE_TTL_NANOS = TimeUnit.SECONDS.toNanos(1);

  private static final class DiskCheckResult {
    final String fingerprint;
    final long sequence;
    final long timestampNanos;

    DiskCheckResult(String fingerprint, long sequence, long timestampNanos) {
      this.fingerprint = fingerprint;
      this.sequence = sequence;
      this.timestampNanos = timestampNanos;
    }
  }

  private final Supplier<String> certPathSupplier;
  private final Function<String, String> fingerprintReader;
  private volatile String activeCertFingerprint;
  private volatile DiskCheckResult lastDiskCheck = null;
  private final ReentrantLock diskCheckLock = new ReentrantLock();
  private final AtomicLong diskCheckSequence = new AtomicLong(0);

  /**
   * Creates a tracker for a fixed workload certificate path using {@link
   * WorkloadCertificateUtils#getCertificateFingerprint(String)}.
   */
  public CertificateRotationTracker(@Nullable String workloadCertPath) {
    this(() -> workloadCertPath, WorkloadCertificateUtils::getCertificateFingerprint);
  }

  /**
   * Creates a tracker with custom certificate path and fingerprint suppliers (used by transports
   * that expose package-private overrides for testing).
   */
  public CertificateRotationTracker(
      Supplier<String> certPathSupplier, Function<String, String> fingerprintReader) {
    this.certPathSupplier = certPathSupplier;
    this.fingerprintReader = fingerprintReader;
    String initialCertPath = certPathSupplier.get();
    this.activeCertFingerprint =
        initialCertPath != null
            ? Strings.nullToEmpty(fingerprintReader.apply(initialCertPath))
            : "";
  }

  /**
   * Returns {@code true} if a workload certificate path is configured, readable, and its current
   * SHA-256 fingerprint on disk differs from the active fingerprint.
   */
  public boolean shouldRefresh() {
    String certPath = certPathSupplier.get();
    if (certPath == null) {
      return false;
    }
    String currentDiskFingerprint = getOrUpdateDiskFingerprint(certPath);
    if (currentDiskFingerprint.isEmpty()) {
      return false;
    }
    return !currentDiskFingerprint.equalsIgnoreCase(activeCertFingerprint);
  }

  private String getOrUpdateDiskFingerprint(String certPath) {
    long seqBeforeLock = diskCheckSequence.get();
    long now = System.nanoTime();
    DiskCheckResult cached = lastDiskCheck;
    if (cached != null
        && !cached.fingerprint.isEmpty()
        && !cached.fingerprint.equalsIgnoreCase(this.activeCertFingerprint)
        && (now - cached.timestampNanos < POSITIVE_ROTATION_CACHE_TTL_NANOS)) {
      return cached.fingerprint;
    }

    diskCheckLock.lock();
    try {
      now = System.nanoTime();
      cached = lastDiskCheck;
      if (cached != null
          && !cached.fingerprint.isEmpty()
          && (cached.sequence > seqBeforeLock
              || (!cached.fingerprint.equalsIgnoreCase(this.activeCertFingerprint)
                  && (now - cached.timestampNanos < POSITIVE_ROTATION_CACHE_TTL_NANOS)))) {
        return cached.fingerprint;
      }
      long newSeq = diskCheckSequence.incrementAndGet();
      String fingerprint = Strings.nullToEmpty(fingerprintReader.apply(certPath));
      if (!fingerprint.isEmpty()) {
        lastDiskCheck = new DiskCheckResult(fingerprint, newSeq, System.nanoTime());
      } else {
        lastDiskCheck = null;
      }
      return fingerprint;
    } finally {
      diskCheckLock.unlock();
    }
  }

  /**
   * Reads the current certificate fingerprint directly from disk (bypassing the 1-second cache),
   * returning {@code ""} if no workload certificate path is configured or if the file is currently
   * unreadable/empty.
   */
  public String readDiskFingerprint() {
    String certPath = certPathSupplier.get();
    if (certPath == null) {
      return "";
    }
    return Strings.nullToEmpty(fingerprintReader.apply(certPath));
  }

  /**
   * Returns {@code true} if {@code diskFingerprint} matches the currently active certificate
   * fingerprint.
   */
  public boolean isAlreadyActive(String diskFingerprint) {
    return diskFingerprint != null && diskFingerprint.equalsIgnoreCase(this.activeCertFingerprint);
  }

  /**
   * Updates the active certificate fingerprint after a successful channel refresh and clears any
   * cached disk check result.
   */
  public void markRefreshed(String newFingerprint) {
    if (newFingerprint != null && !newFingerprint.isEmpty()) {
      this.activeCertFingerprint = newFingerprint;
      this.lastDiskCheck = null;
    }
  }

  /** Returns the currently active certificate fingerprint (or {@code ""} if none). */
  public String getActiveCertFingerprint() {
    return activeCertFingerprint;
  }

  /** Invalidates the cached disk check result. Visible for testing. */
  public void invalidateCache() {
    this.lastDiskCheck = null;
  }
}
