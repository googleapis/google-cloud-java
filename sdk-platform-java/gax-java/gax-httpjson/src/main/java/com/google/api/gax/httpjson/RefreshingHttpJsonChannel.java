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
package com.google.api.gax.httpjson;

import com.google.api.client.http.HttpTransport;
import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.mtls.CertificateRotationTracker;
import com.google.api.gax.rpc.mtls.WorkloadCertificateUtils;
import com.google.common.annotations.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An implementation of {@link ManagedHttpJsonChannel} that supports dynamic mTLS certificate
 * rotation. When the workload certificate on disk changes, {@link #refresh()} replaces the {@link
 * HttpTransport} of the underlying channel. Calls that were already created keep using the
 * transport they were created with, so in-flight requests are not interrupted.
 */
@InternalApi
public class RefreshingHttpJsonChannel extends ManagedHttpJsonChannel {

  private static final Logger LOG = Logger.getLogger(RefreshingHttpJsonChannel.class.getName());

  private final CertificateRotationTracker rotationTracker;
  private final Supplier<HttpTransport> transportFactory;
  private final String workloadCertPath;
  private final ManagedHttpJsonChannel delegate;
  private final Object refreshLock = new Object();
  private final AtomicLong generation = new AtomicLong(0);

  /**
   * @param transportFactory creates a transport configured with the certificate currently on disk
   * @param channelFactory creates the underlying channel from the initial transport
   * @param workloadCertPath path of the workload certificate to monitor for rotation
   */
  public RefreshingHttpJsonChannel(
      Supplier<HttpTransport> transportFactory,
      Function<HttpTransport, ManagedHttpJsonChannel> channelFactory,
      String workloadCertPath) {
    super(true);
    this.transportFactory = transportFactory;
    this.workloadCertPath = workloadCertPath;
    // Record the baseline fingerprint before the initial transport loads the certificate from disk,
    // so a rotation between the two steps is detected as a fingerprint change.
    this.rotationTracker =
        new CertificateRotationTracker(this::getWorkloadCertPath, this::getCertificateFingerprint);
    this.delegate = channelFactory.apply(transportFactory.get());
  }

  @VisibleForTesting
  String getWorkloadCertPath() {
    return workloadCertPath;
  }

  @VisibleForTesting
  String getCertificateFingerprint(String certPath) {
    return WorkloadCertificateUtils.getCertificateFingerprint(certPath);
  }

  /** {@inheritDoc} */
  @Override
  public boolean shouldRefresh() {
    return rotationTracker.shouldRefresh();
  }

  /** {@inheritDoc} */
  @Override
  public void refresh() {
    // A generation change while waiting for the lock means a concurrent refresh already swapped in
    // a transport with a new certificate, so there is no need to read the certificate again.
    long generationBeforeLock = generation.get();
    synchronized (refreshLock) {
      if (isShutdown()) {
        return;
      }
      if (generation.get() != generationBeforeLock) {
        LOG.fine(
            "HTTP/JSON channel was already refreshed by a concurrent thread, skipping duplicate"
                + " refresh");
        return;
      }
      String currentDiskFingerprint = rotationTracker.readDiskFingerprint();
      if (currentDiskFingerprint.isEmpty()) {
        return;
      }

      // Double-check inside refreshLock
      if (rotationTracker.isAlreadyActive(currentDiskFingerprint)) {
        LOG.fine(
            "HTTP/JSON channel was already refreshed by a concurrent thread, skipping duplicate"
                + " refresh");
        return;
      }

      LOG.info("mTLS certificate rotation detected. Refreshing HTTP/JSON transport.");

      HttpTransport newTransport;
      try {
        newTransport = transportFactory.get();
      } catch (Exception e) {
        LOG.log(Level.WARNING, "Failed to refresh HTTP/JSON transport, keeping old transport", e);
        return;
      }
      // The previous transport is not shut down: calls created before the swap may still be using
      // it, and it needs no explicit shutdown because its idle keep-alive connections expire.
      delegate.setHttpTransport(newTransport);
      // Order matters: swap the transport, then bump generation, then mark the tracker refreshed,
      // so any failing RPC that observes the new fingerprint also observes the new generation.
      generation.incrementAndGet();
      rotationTracker.markRefreshed(currentDiskFingerprint);
    }
  }

  /** {@inheritDoc} */
  @Override
  public long getGeneration() {
    return generation.get();
  }

  @Override
  public <RequestT, ResponseT> HttpJsonClientCall<RequestT, ResponseT> newCall(
      ApiMethodDescriptor<RequestT, ResponseT> methodDescriptor, HttpJsonCallOptions callOptions) {
    return delegate.newCall(methodDescriptor, callOptions);
  }

  @Override
  Executor getExecutor() {
    return delegate.getExecutor();
  }

  @Override
  String getEndpoint() {
    return delegate.getEndpoint();
  }

  @Override
  @VisibleForTesting
  HttpTransport getHttpTransport() {
    return delegate.getHttpTransport();
  }

  @VisibleForTesting
  void invalidateDiskFingerprintCache() {
    rotationTracker.invalidateCache();
  }

  @Override
  public void shutdown() {
    // Serialized with refresh() so that a transport swap cannot race with shutdown.
    synchronized (refreshLock) {
      delegate.shutdown();
    }
  }

  @Override
  public boolean isShutdown() {
    return delegate.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return delegate.isTerminated();
  }

  @Override
  public void shutdownNow() {
    synchronized (refreshLock) {
      delegate.shutdownNow();
    }
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return delegate.awaitTermination(duration, unit);
  }

  @Override
  public void close() {
    shutdown();
  }
}
