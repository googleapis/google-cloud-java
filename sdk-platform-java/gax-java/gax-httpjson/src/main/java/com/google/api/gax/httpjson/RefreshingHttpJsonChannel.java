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
import com.google.api.gax.httpjson.ForwardingHttpJsonClientCall.SimpleForwardingHttpJsonClientCall;
import com.google.api.gax.httpjson.ForwardingHttpJsonClientCallListener.SimpleForwardingHttpJsonClientCallListener;
import com.google.api.gax.rpc.mtls.CertificateRotationTracker;
import com.google.api.gax.rpc.mtls.WorkloadCertificateUtils;
import com.google.common.annotations.VisibleForTesting;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jspecify.annotations.Nullable;

/**
 * An implementation of {@link ManagedHttpJsonChannel} that supports dynamic mTLS certificate
 * rotation by thread-safely hot-swapping the underlying active HTTP/JSON channel while gracefully
 * retiring older connections after all active in-flight requests complete.
 */
@InternalApi
public class RefreshingHttpJsonChannel extends ManagedHttpJsonChannel {

  private static final Logger LOG = Logger.getLogger(RefreshingHttpJsonChannel.class.getName());

  private final CertificateRotationTracker rotationTracker;
  private final Supplier<ManagedHttpJsonChannel> channelFactory;
  private final String workloadCertPath;
  private final AtomicReference<ChannelEntry> activeEntry;
  // Keep track of all entries to properly await their termination
  private final ConcurrentLinkedQueue<ChannelEntry> allEntries = new ConcurrentLinkedQueue<>();
  private final Object refreshLock = new Object();
  private final AtomicLong generation = new AtomicLong(0);

  public RefreshingHttpJsonChannel(
      Supplier<ManagedHttpJsonChannel> channelFactory, String workloadCertPath) {
    this(channelFactory.get(), channelFactory, workloadCertPath);
  }

  public RefreshingHttpJsonChannel(
      ManagedHttpJsonChannel initialChannel,
      Supplier<ManagedHttpJsonChannel> channelFactory,
      String workloadCertPath) {
    super(true);
    this.channelFactory = channelFactory;
    this.workloadCertPath = workloadCertPath;
    ChannelEntry initial = new ChannelEntry(initialChannel);
    this.activeEntry = new AtomicReference<>(initial);
    this.allEntries.add(initial);
    try {
      this.rotationTracker =
          new CertificateRotationTracker(
              this::getWorkloadCertPath, this::getCertificateFingerprint);
    } catch (Throwable t) {
      initialChannel.shutdownNow();
      throw t;
    }
  }

  // Visible for testing
  String getWorkloadCertPath() {
    return workloadCertPath;
  }

  // Visible for testing
  String getCertificateFingerprint(String certPath) {
    return WorkloadCertificateUtils.getCertificateFingerprint(certPath);
  }

  @Override
  public boolean shouldRefresh() {
    return rotationTracker.shouldRefresh();
  }

  @Override
  public void refresh() {
    synchronized (refreshLock) {
      if (isShutdown()) {
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

      LOG.info("mTLS certificate rotation detected. Triggering HTTP/JSON channel pool refresh.");

      ChannelEntry newEntry = new ChannelEntry(channelFactory.get());
      allEntries.add(newEntry);
      // Prune terminated entries after adding newEntry to ensure allEntries is never empty
      allEntries.removeIf(entry -> entry != newEntry && entry.channel.isTerminated());

      ChannelEntry oldEntry = activeEntry.getAndSet(newEntry);
      rotationTracker.markRefreshed(currentDiskFingerprint);
      generation.incrementAndGet();

      if (oldEntry != null) {
        oldEntry.requestShutdown();
      }
    }
  }

  @Override
  public long getGeneration() {
    return generation.get();
  }

  private ChannelEntry getRetainedEntry() {
    while (true) {
      ChannelEntry entry = activeEntry.get();
      if (entry.retain()) {
        return entry;
      }
      if (entry == activeEntry.get()) {
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
    } catch (Throwable t) {
      entry.release();
      throw t;
    }
  }

  @Override
  java.util.concurrent.Executor getExecutor() {
    return activeEntry.get().channel.getExecutor();
  }

  @VisibleForTesting
  ManagedHttpJsonChannel getActiveChannel() {
    return activeEntry.get().channel;
  }

  private volatile boolean isShuttingDown = false;

  @Override
  public void shutdown() {
    synchronized (refreshLock) {
      isShuttingDown = true;
      for (ChannelEntry entry : allEntries) {
        entry.requestShutdown();
      }
    }
  }

  @Override
  public boolean isShutdown() {
    return isShuttingDown;
  }

  @Override
  public boolean isTerminated() {
    if (!isShuttingDown) {
      return false;
    }
    for (ChannelEntry entry : allEntries) {
      if (!entry.channel.isTerminated()) {
        return false;
      }
    }
    return true;
  }

  @Override
  public void shutdownNow() {
    synchronized (refreshLock) {
      isShuttingDown = true;
      for (ChannelEntry entry : allEntries) {
        entry.shutdownRequested.set(true);
        entry.shutdownInitiated.set(true);
        entry.channel.shutdownNow();
      }
    }
  }

  @VisibleForTesting
  void invalidateDiskFingerprintCache() {
    rotationTracker.invalidateCache();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    long endNanos = System.nanoTime() + unit.toNanos(duration);
    for (ChannelEntry entry : allEntries) {
      if (entry.channel.isTerminated()) {
        continue;
      }
      long remainingNanos = endNanos - System.nanoTime();
      if (remainingNanos <= 0) {
        return false;
      }
      if (!entry.channel.awaitTermination(remainingNanos, TimeUnit.NANOSECONDS)
          && !entry.channel.isTerminated()) {
        return false;
      }
    }
    return true;
  }

  @Override
  public void close() {
    shutdown();
  }

  @Override
  String getEndpoint() {
    return activeEntry.get().channel.getEndpoint();
  }

  @Override
  @VisibleForTesting
  HttpTransport getHttpTransport() {
    return activeEntry.get().channel.getHttpTransport();
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
      if (count < 0) {
        LOG.warning("Channel entry reference count dropped below 0");
      }
      // Must check outstandingCalls after shutdownRequested (in reverse order of retain()) to
      // ensure mutual exclusion.
      if (shutdownRequested.get() && outstandingCalls.get() == 0) {
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

    private final Object callLock = new Object();
    private volatile @Nullable CancellationException cancellationException;
    private final ChannelEntry entry;
    private final AtomicBoolean wasClosed = new AtomicBoolean(false);
    private final AtomicBoolean wasReleased = new AtomicBoolean(false);
    private final AtomicBoolean wasStarted = new AtomicBoolean(false);

    ReleasingHttpJsonClientCall(HttpJsonClientCall<ReqT, RespT> delegate, ChannelEntry entry) {
      super(delegate);
      this.entry = entry;
    }

    @Override
    public void start(Listener<RespT> responseListener, HttpJsonMetadata requestHeaders) {
      synchronized (callLock) {
        if (!wasStarted.compareAndSet(false, true)) {
          throw new IllegalStateException("Call is already started");
        }
        if (cancellationException != null) {
          if (wasReleased.compareAndSet(false, true)) {
            entry.release();
          }
          throw new IllegalStateException("Call is already cancelled", cancellationException);
        }
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
        } catch (Throwable t) {
          if (wasReleased.compareAndSet(false, true)) {
            entry.release();
          }
          throw t;
        }
      }
    }

    @Override
    public void cancel(@Nullable String message, @Nullable Throwable cause) {
      boolean releaseImmediately = false;
      try {
        synchronized (callLock) {
          this.cancellationException = new CancellationException(message);
          if (!wasStarted.get()) {
            releaseImmediately = true;
          }
          if (delegate() != null) {
            super.cancel(message, cause);
          }
        }
      } catch (Throwable t) {
        if (!wasStarted.get()) {
          releaseImmediately = true;
        }
        throw t;
      } finally {
        if (releaseImmediately && wasReleased.compareAndSet(false, true)) {
          entry.release();
        }
      }
    }
  }
}
