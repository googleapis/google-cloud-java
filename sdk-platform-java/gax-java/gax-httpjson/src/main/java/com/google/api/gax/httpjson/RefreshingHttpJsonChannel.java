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

import com.google.api.core.InternalApi;
import com.google.api.gax.httpjson.ForwardingHttpJsonClientCall.SimpleForwardingHttpJsonClientCall;
import com.google.api.gax.httpjson.ForwardingHttpJsonClientCallListener.SimpleForwardingHttpJsonClientCallListener;
import com.google.api.gax.rpc.mtls.WorkloadCertificateUtils;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An implementation of {@link ManagedHttpJsonChannel} that supports dynamic mTLS certificate
 * rotation by thread-safely hot-swapping the underlying active HTTP/JSON channel while gracefully
 * retiring older connections after all active in-flight requests complete.
 */
@InternalApi
public class RefreshingHttpJsonChannel extends ManagedHttpJsonChannel {

  private static final Logger LOG = Logger.getLogger(RefreshingHttpJsonChannel.class.getName());

  private static class DiskCheckResult {
    final String fingerprint;
    final long timestampNanos;

    DiskCheckResult(String fingerprint, long timestampNanos) {
      this.fingerprint = fingerprint;
      this.timestampNanos = timestampNanos;
    }
  }

  private final AtomicReference<DiskCheckResult> lastDiskCheck = new AtomicReference<>(null);
  private final Supplier<ManagedHttpJsonChannel> channelFactory;
  private final AtomicReference<ChannelEntry> activeEntry;
  // Keep track of all entries to properly await their termination
  private final java.util.concurrent.ConcurrentLinkedQueue<ChannelEntry> allEntries =
      new java.util.concurrent.ConcurrentLinkedQueue<>();
  private final Object lock = new Object();
  private volatile String activeCertFingerprint = "";

  public RefreshingHttpJsonChannel(Supplier<ManagedHttpJsonChannel> channelFactory) {
    this.channelFactory = channelFactory;
    ChannelEntry initial = new ChannelEntry(channelFactory.get());
    this.activeEntry = new AtomicReference<>(initial);
    this.allEntries.add(initial);
    String certPath = WorkloadCertificateUtils.getWorkloadCertPath();
    if (certPath != null) {
      this.activeCertFingerprint = WorkloadCertificateUtils.getCertificateFingerprint(certPath);
    }
  }

  private String getOrUpdateDiskFingerprint(String certPath) {
    long now = System.nanoTime();
    DiskCheckResult cached = lastDiskCheck.get();
    if (cached != null
        && (now - cached.timestampNanos < java.util.concurrent.TimeUnit.SECONDS.toNanos(1))) {
      return cached.fingerprint;
    }

    synchronized (lastDiskCheck) {
      cached = lastDiskCheck.get();
      if (cached != null
          && (now - cached.timestampNanos < java.util.concurrent.TimeUnit.SECONDS.toNanos(1))) {
        return cached.fingerprint;
      }
      String fingerprint = WorkloadCertificateUtils.getCertificateFingerprint(certPath);
      lastDiskCheck.set(new DiskCheckResult(fingerprint, System.nanoTime()));
      return fingerprint;
    }
  }

  @Override
  public boolean shouldRefresh() {
    String certPath = WorkloadCertificateUtils.getWorkloadCertPath();
    if (certPath == null) {
      return false;
    }
    String currentDiskFingerprint = getOrUpdateDiskFingerprint(certPath);
    if (currentDiskFingerprint.isEmpty()) {
      return false;
    }
    return !currentDiskFingerprint.equalsIgnoreCase(activeCertFingerprint);
  }

  @Override
  public void refresh() {
    synchronized (lock) {
      String certPath = WorkloadCertificateUtils.getWorkloadCertPath();
      if (certPath == null) {
        return;
      }
      String currentDiskFingerprint = getOrUpdateDiskFingerprint(certPath);
      if (currentDiskFingerprint.isEmpty()) {
        return;
      }

      // Double-check inside lock
      if (currentDiskFingerprint.equals(this.activeCertFingerprint)) {
        LOG.fine(
            "HTTP/JSON channel was already refreshed by a concurrent thread, skipping duplicate refresh");
        return;
      }

      this.activeCertFingerprint = currentDiskFingerprint;
      LOG.info("mTLS certificate rotation detected. Triggering HTTP/JSON channel pool refresh.");

      ChannelEntry newEntry = new ChannelEntry(channelFactory.get());
      allEntries.add(newEntry);
      ChannelEntry oldEntry = activeEntry.getAndSet(newEntry);

      if (oldEntry != null) {
        oldEntry.requestShutdown();
      }
    }
  }

  private ChannelEntry getRetainedEntry() {
    while (true) {
      ChannelEntry entry = activeEntry.get();
      if (entry.retain()) {
        return entry;
      }
      if (entry.shutdownRequested.get()) {
        throw new IllegalStateException("Channel has been shut down");
      }
    }
  }

  @Override
  public <RequestT, ResponseT> HttpJsonClientCall<RequestT, ResponseT> newCall(
      ApiMethodDescriptor<RequestT, ResponseT> methodDescriptor, HttpJsonCallOptions callOptions) {
    ChannelEntry entry = getRetainedEntry();
    try {
      HttpJsonClientCall<RequestT, ResponseT> delegateCall =
          entry.channel.newCall(methodDescriptor, callOptions);
      return new ReleasingHttpJsonClientCall<>(delegateCall, entry);
    } catch (Exception e) {
      entry.release();
      throw e;
    }
  }

  @Override
  java.util.concurrent.Executor getExecutor() {
    return activeEntry.get().channel.getExecutor();
  }

  @Override
  public void shutdown() {
    for (ChannelEntry entry : allEntries) {
      entry.requestShutdown();
    }
  }

  @Override
  public boolean isShutdown() {
    for (ChannelEntry entry : allEntries) {
      if (!entry.channel.isShutdown()) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean isTerminated() {
    for (ChannelEntry entry : allEntries) {
      if (!entry.channel.isTerminated()) {
        return false;
      }
    }
    return true;
  }

  @Override
  public void shutdownNow() {
    for (ChannelEntry entry : allEntries) {
      entry.channel.shutdownNow();
    }
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    long endNanos = System.nanoTime() + unit.toNanos(duration);
    for (ChannelEntry entry : allEntries) {
      long remainingNanos = endNanos - System.nanoTime();
      if (remainingNanos <= 0) {
        return false;
      }
      if (!entry.channel.awaitTermination(remainingNanos, TimeUnit.NANOSECONDS)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public void close() {
    shutdown();
  }

  /** Internal container to manage request reference-counting and graceful shutdown. */
  private static class ChannelEntry {
    private final ManagedHttpJsonChannel channel;
    private final AtomicInteger outstandingCalls = new AtomicInteger(0);
    private final AtomicBoolean shutdownRequested = new AtomicBoolean(false);
    private final AtomicBoolean shutdownInitiated = new AtomicBoolean(false);

    ChannelEntry(ManagedHttpJsonChannel channel) {
      this.channel = channel;
    }

    boolean retain() {
      outstandingCalls.incrementAndGet();
      if (shutdownRequested.get()) {
        release();
        return false;
      }
      return true;
    }

    void release() {
      int count = outstandingCalls.decrementAndGet();
      if (shutdownRequested.get() && count == 0) {
        shutdown();
      }
    }

    void requestShutdown() {
      shutdownRequested.set(true);
      if (outstandingCalls.get() == 0) {
        shutdown();
      }
    }

    private void shutdown() {
      if (shutdownInitiated.compareAndSet(false, true)) {
        try {
          channel.shutdown();
        } catch (Exception e) {
          LOG.log(Level.WARNING, "Error shutting down retired HTTP/JSON channel", e);
        }
      }
    }
  }

  /** A client call decorator that decrements the entry counter upon call completion. */
  private static class ReleasingHttpJsonClientCall<ReqT, RespT>
      extends SimpleForwardingHttpJsonClientCall<ReqT, RespT> {

    private final ChannelEntry entry;
    private final AtomicBoolean wasClosed = new AtomicBoolean(false);
    private final AtomicBoolean wasReleased = new AtomicBoolean(false);

    ReleasingHttpJsonClientCall(HttpJsonClientCall<ReqT, RespT> delegate, ChannelEntry entry) {
      super(delegate);
      this.entry = entry;
    }

    @Override
    public void start(Listener<RespT> responseListener, HttpJsonMetadata requestHeaders) {
      try {
        super.start(
            new SimpleForwardingHttpJsonClientCallListener<RespT>(responseListener) {
              @Override
              public void onClose(int statusCode, HttpJsonMetadata trailers) {
                if (!wasClosed.compareAndSet(false, true)) {
                  return;
                }
                try {
                  super.onClose(statusCode, trailers);
                } finally {
                  if (wasReleased.compareAndSet(false, true)) {
                    entry.release();
                  }
                }
              }
            },
            requestHeaders);
      } catch (Exception e) {
        if (wasReleased.compareAndSet(false, true)) {
          entry.release();
        }
        throw e;
      }
    }
  }
}
