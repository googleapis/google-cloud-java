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
  private static final long REFRESH_COOLDOWN_MS = 5000;

  private final Supplier<ManagedHttpJsonChannel> channelFactory;
  private final AtomicReference<ChannelEntry> activeEntry;
  private final AtomicBoolean refreshInProgress = new AtomicBoolean(false);
  private final Object lock = new Object();
  private long lastRefreshTimeMs = 0;

  public RefreshingHttpJsonChannel(Supplier<ManagedHttpJsonChannel> channelFactory) {
    this.channelFactory = channelFactory;
    this.activeEntry = new AtomicReference<>(new ChannelEntry(channelFactory.get()));
  }

  @Override
  public void refresh() {
    // 1. Lock-free CAS coalescing check to prevent duplicate queueing/blocking of concurrent threads
    if (!refreshInProgress.compareAndSet(false, true)) {
      return;
    }
    try {
      synchronized (lock) {
        long now = System.currentTimeMillis();
        if (now - lastRefreshTimeMs < REFRESH_COOLDOWN_MS) {
          LOG.fine("HTTP/JSON channel pool refreshed recently, skipping duplicate refresh");
          return;
        }

        LOG.info("mTLS certificate rotation detected. Triggering HTTP/JSON channel pool refresh.");
        ChannelEntry newEntry = new ChannelEntry(channelFactory.get());
        ChannelEntry oldEntry = activeEntry.getAndSet(newEntry);

        if (oldEntry != null) {
          oldEntry.requestShutdown();
        }

        lastRefreshTimeMs = now;
      }
    } finally {
      refreshInProgress.set(false);
    }
  }

  private ChannelEntry getRetainedEntry() {
    while (true) {
      ChannelEntry entry = activeEntry.get();
      if (entry.retain()) {
        return entry;
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
  public void shutdown() {
    activeEntry.get().requestShutdown();
  }

  @Override
  public boolean isShutdown() {
    return activeEntry.get().channel.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return activeEntry.get().channel.isTerminated();
  }

  @Override
  public void shutdownNow() {
    activeEntry.get().channel.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return activeEntry.get().channel.awaitTermination(duration, unit);
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
