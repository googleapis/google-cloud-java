/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.bigtable.gaxx.grpc;

import com.google.api.core.InternalApi;
import com.google.api.gax.grpc.ChannelFactory;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/**
 * A {@link ManagedChannel} that will send requests round-robin via a set of channels.
 *
 * <p>In addition to spreading requests over a set of child connections, the pool will also actively
 * manage the lifecycle of the channels. Currently lifecycle management is limited to pre-emptively
 * replacing channels every hour. In the future it will dynamically size the pool based on number of
 * outstanding requests.
 *
 * <p>Package-private for internal use.
 */
class BigtableChannelPool extends ManagedChannel {
  @VisibleForTesting
  static final Logger LOG = Logger.getLogger(BigtableChannelPool.class.getName());

  private static final java.time.Duration REFRESH_PERIOD = java.time.Duration.ofMinutes(50);

  private final BigtableChannelPoolSettings settings;
  private final ChannelFactory channelFactory;
  private final ScheduledExecutorService executor;

  private final Object entryWriteLock = new Object();
  @VisibleForTesting final AtomicReference<ImmutableList<Entry>> entries = new AtomicReference<>();
  private final AtomicInteger indexTicker = new AtomicInteger();
  private final String authority;

  static BigtableChannelPool create(
      BigtableChannelPoolSettings settings, ChannelFactory channelFactory) throws IOException {
    return new BigtableChannelPool(
        settings, channelFactory, Executors.newSingleThreadScheduledExecutor());
  }

  /**
   * Initializes the channel pool. Assumes that all channels have the same authority.
   *
   * @param settings options for controling the ChannelPool sizing behavior
   * @param channelFactory method to create the channels
   * @param executor periodically refreshes the channels
   */
  @VisibleForTesting
  BigtableChannelPool(
      BigtableChannelPoolSettings settings,
      ChannelFactory channelFactory,
      ScheduledExecutorService executor)
      throws IOException {
    this.settings = settings;
    this.channelFactory = channelFactory;

    ImmutableList.Builder<Entry> initialListBuilder = ImmutableList.builder();

    for (int i = 0; i < settings.getInitialChannelCount(); i++) {
      initialListBuilder.add(new Entry(channelFactory.createSingleChannel()));
    }

    entries.set(initialListBuilder.build());
    authority = entries.get().get(0).channel.authority();
    this.executor = executor;

    if (!settings.isStaticSize()) {
      executor.scheduleAtFixedRate(
          this::resizeSafely,
          BigtableChannelPoolSettings.RESIZE_INTERVAL.getSeconds(),
          BigtableChannelPoolSettings.RESIZE_INTERVAL.getSeconds(),
          TimeUnit.SECONDS);
    }
    if (settings.isPreemptiveRefreshEnabled()) {
      executor.scheduleAtFixedRate(
          this::refreshSafely,
          REFRESH_PERIOD.getSeconds(),
          REFRESH_PERIOD.getSeconds(),
          TimeUnit.SECONDS);
    }
  }

  /** {@inheritDoc} */
  @Override
  public String authority() {
    return authority;
  }

  /**
   * Create a {@link ClientCall} on a Channel from the pool chosen in a round-robin fashion to the
   * remote operation specified by the given {@link MethodDescriptor}. The returned {@link
   * ClientCall} does not trigger any remote behavior until {@link
   * ClientCall#start(ClientCall.Listener, io.grpc.Metadata)} is invoked.
   */
  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(
      MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
    return getChannel(indexTicker.getAndIncrement()).newCall(methodDescriptor, callOptions);
  }

  Channel getChannel(int affinity) {
    return new AffinityChannel(affinity);
  }

  /** {@inheritDoc} */
  @Override
  public ManagedChannel shutdown() {
    LOG.fine("Initiating graceful shutdown due to explicit request");

    List<Entry> localEntries = entries.get();
    for (Entry entry : localEntries) {
      entry.channel.shutdown();
    }
    if (executor != null) {
      // shutdownNow will cancel scheduled tasks
      executor.shutdownNow();
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isShutdown() {
    List<Entry> localEntries = entries.get();
    for (Entry entry : localEntries) {
      if (!entry.channel.isShutdown()) {
        return false;
      }
    }
    return executor == null || executor.isShutdown();
  }

  /** {@inheritDoc} */
  @Override
  public boolean isTerminated() {
    List<Entry> localEntries = entries.get();
    for (Entry entry : localEntries) {
      if (!entry.channel.isTerminated()) {
        return false;
      }
    }

    return executor == null || executor.isTerminated();
  }

  /** {@inheritDoc} */
  @Override
  public ManagedChannel shutdownNow() {
    LOG.fine("Initiating immediate shutdown due to explicit request");

    List<Entry> localEntries = entries.get();
    for (Entry entry : localEntries) {
      entry.channel.shutdownNow();
    }
    if (executor != null) {
      executor.shutdownNow();
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
    long endTimeNanos = System.nanoTime() + unit.toNanos(timeout);
    List<Entry> localEntries = entries.get();
    for (Entry entry : localEntries) {
      long awaitTimeNanos = endTimeNanos - System.nanoTime();
      if (awaitTimeNanos <= 0) {
        break;
      }
      entry.channel.awaitTermination(awaitTimeNanos, TimeUnit.NANOSECONDS);
    }
    if (executor != null) {
      long awaitTimeNanos = endTimeNanos - System.nanoTime();
      executor.awaitTermination(awaitTimeNanos, TimeUnit.NANOSECONDS);
    }
    return isTerminated();
  }

  private void resizeSafely() {
    try {
      synchronized (entryWriteLock) {
        resize();
      }
    } catch (Exception e) {
      LOG.log(Level.WARNING, "Failed to resize channel pool", e);
    }
  }

  /**
   * Resize the number of channels based on the number of outstanding RPCs.
   *
   * <p>This method is expected to be called on a fixed interval. On every invocation it will:
   *
   * <ul>
   *   <li>Get the maximum number of outstanding RPCs since last invocation
   *   <li>Determine a valid range of number of channels to handle that many outstanding RPCs
   *   <li>If the current number of channel falls outside of that range, add or remove at most
   *       {@link BigtableChannelPoolSettings#MAX_RESIZE_DELTA} to get closer to middle of that
   *       range.
   * </ul>
   *
   * <p>Not threadsafe, must be called under the entryWriteLock monitor
   */
  @VisibleForTesting
  void resize() {
    List<Entry> localEntries = entries.get();
    // Estimate the peak of RPCs in the last interval by summing the peak of RPCs per channel
    int actualOutstandingRpcs =
        localEntries.stream().mapToInt(Entry::getAndResetMaxOutstanding).sum();

    // Number of channels if each channel operated at max capacity
    int minChannels =
        (int) Math.ceil(actualOutstandingRpcs / (double) settings.getMaxRpcsPerChannel());
    // Limit the threshold to absolute range
    if (minChannels < settings.getMinChannelCount()) {
      minChannels = settings.getMinChannelCount();
    }

    // Number of channels if each channel operated at minimum capacity
    // Note: getMinRpcsPerChannel() can return 0, but division by 0 shouldn't cause a problem.
    int maxChannels =
        (int) Math.ceil(actualOutstandingRpcs / (double) settings.getMinRpcsPerChannel());
    // Limit the threshold to absolute range
    if (maxChannels > settings.getMaxChannelCount()) {
      maxChannels = settings.getMaxChannelCount();
    }
    if (maxChannels < minChannels) {
      maxChannels = minChannels;
    }

    // If the pool were to be resized, try to aim for the middle of the bound, but limit rate of
    // change.
    int tentativeTarget = (maxChannels + minChannels) / 2;
    int currentSize = localEntries.size();
    int delta = tentativeTarget - currentSize;
    int dampenedTarget = tentativeTarget;
    if (Math.abs(delta) > BigtableChannelPoolSettings.MAX_RESIZE_DELTA) {
      dampenedTarget =
          currentSize + (int) Math.copySign(BigtableChannelPoolSettings.MAX_RESIZE_DELTA, delta);
    }

    // Only resize the pool when thresholds are crossed
    if (localEntries.size() < minChannels) {
      LOG.fine(
          String.format(
              "Detected throughput peak of %d, expanding channel pool size: %d -> %d.",
              actualOutstandingRpcs, currentSize, dampenedTarget));

      expand(dampenedTarget);
    } else if (localEntries.size() > maxChannels) {
      LOG.fine(
          String.format(
              "Detected throughput drop to %d, shrinking channel pool size: %d -> %d.",
              actualOutstandingRpcs, currentSize, dampenedTarget));

      shrink(dampenedTarget);
    }
  }

  /** Not threadsafe, must be called under the entryWriteLock monitor */
  private void shrink(int desiredSize) {
    ImmutableList<Entry> localEntries = entries.get();
    Preconditions.checkState(
        localEntries.size() >= desiredSize, "current size is already smaller than the desired");

    // Set the new list
    entries.set(localEntries.subList(0, desiredSize));
    // clean up removed entries
    List<Entry> removed = localEntries.subList(desiredSize, localEntries.size());
    removed.forEach(Entry::requestShutdown);
  }

  /** Not threadsafe, must be called under the entryWriteLock monitor */
  private void expand(int desiredSize) {
    List<Entry> localEntries = entries.get();
    Preconditions.checkState(
        localEntries.size() <= desiredSize, "current size is already bigger than the desired");

    ImmutableList.Builder<Entry> newEntries = ImmutableList.<Entry>builder().addAll(localEntries);

    for (int i = 0; i < desiredSize - localEntries.size(); i++) {
      try {
        newEntries.add(new Entry(channelFactory.createSingleChannel()));
      } catch (IOException e) {
        LOG.log(Level.WARNING, "Failed to add channel", e);
      }
    }

    entries.set(newEntries.build());
  }

  private void refreshSafely() {
    try {
      refresh();
    } catch (Exception e) {
      LOG.log(Level.WARNING, "Failed to pre-emptively refresh channnels", e);
    }
  }

  /**
   * Replace all of the channels in the channel pool with fresh ones. This is meant to mitigate the
   * hourly GFE disconnects by giving clients the ability to prime the channel on reconnect.
   *
   * <p>This is done on a best effort basis. If the replacement channel fails to construct, the old
   * channel will continue to be used.
   */
  @InternalApi("Visible for testing")
  void refresh() {
    // Note: synchronization is necessary in case refresh is called concurrently:
    // - thread1 fails to replace a single entry
    // - thread2 succeeds replacing an entry
    // - thread1 loses the race to replace the list
    // - then thread2 will shut down channel that thread1 will put back into circulation (after it
    //   replaces the list)
    synchronized (entryWriteLock) {
      LOG.fine("Refreshing all channels");
      ArrayList<Entry> newEntries = new ArrayList<>(entries.get());

      for (int i = 0; i < newEntries.size(); i++) {
        try {
          newEntries.set(i, new Entry(channelFactory.createSingleChannel()));
        } catch (IOException e) {
          LOG.log(Level.WARNING, "Failed to refresh channel, leaving old channel", e);
        }
      }

      ImmutableList<Entry> replacedEntries = entries.getAndSet(ImmutableList.copyOf(newEntries));

      // Shutdown the channels that were cycled out.
      for (Entry e : replacedEntries) {
        if (!newEntries.contains(e)) {
          e.requestShutdown();
        }
      }
    }
  }

  /**
   * Get and retain a Channel Entry. The returned Entry will have its rpc count incremented,
   * preventing it from getting recycled.
   */
  Entry getRetainedEntry(int affinity) {
    // The maximum number of concurrent calls to this method for any given time span is at most 2,
    // so the loop can actually be 2 times. But going for 5 times for a safety margin for potential
    // code evolving
    for (int i = 0; i < 5; i++) {
      Entry entry = getEntry(affinity);
      if (entry.retain()) {
        return entry;
      }
    }
    // It is unlikely to reach here unless the pool code evolves to increase the maximum possible
    // concurrent calls to this method. If it does, this is a bug in the channel pool implementation
    // the number of retries above should be greater than the number of contending maintenance
    // tasks.
    throw new IllegalStateException("Bug: failed to retain a channel");
  }

  /**
   * Returns one of the channels managed by this pool. The pool continues to "own" the channel, and
   * the caller should not shut it down.
   *
   * @param affinity Two calls to this method with the same affinity returns the same channel most
   *     of the time, if the channel pool was refreshed since the last call, a new channel will be
   *     returned. The reverse is not true: Two calls with different affinities might return the
   *     same channel. However, the implementation should attempt to spread load evenly.
   */
  private Entry getEntry(int affinity) {
    List<Entry> localEntries = entries.get();

    int index = Math.abs(affinity % localEntries.size());

    return localEntries.get(index);
  }

  /** Bundles a gRPC {@link ManagedChannel} with some usage accounting. */
  static class Entry {
    private final ManagedChannel channel;

    /**
     * The primary purpose of keeping a count for outstanding RPCs is to track when a channel is
     * safe to close. In grpc, initialization & starting of rpcs is split between 2 methods:
     * Channel#newCall() and ClientCall#start. gRPC already has a mechanism to safely close channels
     * that have rpcs that have been started. However, it does not protect calls that have been
     * created but not started. In the sequence: Channel#newCall() Channel#shutdown()
     * ClientCall#Start(), gRpc will error out the call telling the caller that the channel is
     * shutdown.
     *
     * <p>Hence, the increment of outstanding RPCs has to happen when the ClientCall is initialized,
     * as part of Channel#newCall(), not after the ClientCall is started. The decrement of
     * outstanding RPCs has to happen when the ClientCall is closed or the ClientCall failed to
     * start.
     */
    @VisibleForTesting final AtomicInteger outstandingRpcs = new AtomicInteger(0);

    private final AtomicInteger maxOutstanding = new AtomicInteger();

    // Flag that the channel should be closed once all of the outstanding RPC complete.
    private final AtomicBoolean shutdownRequested = new AtomicBoolean();
    // Flag that the channel has been closed.
    private final AtomicBoolean shutdownInitiated = new AtomicBoolean();

    private Entry(ManagedChannel channel) {
      this.channel = channel;
    }

    int getAndResetMaxOutstanding() {
      return maxOutstanding.getAndSet(outstandingRpcs.get());
    }

    /**
     * Try to increment the outstanding RPC count. The method will return false if the channel is
     * closing and the caller should pick a different channel. If the method returned true, the
     * channel has been successfully retained and it is the responsibility of the caller to release
     * it.
     */
    private boolean retain() {
      // register desire to start RPC
      int currentOutstanding = outstandingRpcs.incrementAndGet();

      // Rough book keeping
      int prevMax = maxOutstanding.get();
      if (currentOutstanding > prevMax) {
        maxOutstanding.incrementAndGet();
      }

      // abort if the channel is closing
      if (shutdownRequested.get()) {
        release();
        return false;
      }
      return true;
    }

    /**
     * Notify the channel that the number of outstanding RPCs has decreased. If shutdown has been
     * previously requested, this method will shutdown the channel if its the last outstanding RPC.
     */
    private void release() {
      int newCount = outstandingRpcs.decrementAndGet();
      if (newCount < 0) {
        LOG.log(Level.WARNING, "Bug! Reference count is negative (" + newCount + ")!");
      }

      // Must check outstandingRpcs after shutdownRequested (in reverse order of retain()) to ensure
      // mutual exclusion.
      if (shutdownRequested.get() && outstandingRpcs.get() == 0) {
        shutdown();
      }
    }

    /**
     * Request a shutdown. The actual shutdown will be delayed until there are no more outstanding
     * RPCs.
     */
    private void requestShutdown() {
      shutdownRequested.set(true);
      if (outstandingRpcs.get() == 0) {
        shutdown();
      }
    }

    /** Ensure that shutdown is only called once. */
    private void shutdown() {
      if (shutdownInitiated.compareAndSet(false, true)) {
        channel.shutdown();
      }
    }
  }

  /** Thin wrapper to ensure that new calls are properly reference counted. */
  private class AffinityChannel extends Channel {
    private final int affinity;

    public AffinityChannel(int affinity) {
      this.affinity = affinity;
    }

    @Override
    public String authority() {
      return authority;
    }

    @Override
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(
        MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {

      Entry entry = getRetainedEntry(affinity);

      return new ReleasingClientCall<>(entry.channel.newCall(methodDescriptor, callOptions), entry);
    }
  }

  /** ClientCall wrapper that makes sure to decrement the outstanding RPC count on completion. */
  static class ReleasingClientCall<ReqT, RespT> extends SimpleForwardingClientCall<ReqT, RespT> {
    @Nullable private CancellationException cancellationException;
    final Entry entry;
    private final AtomicBoolean wasClosed = new AtomicBoolean();
    private final AtomicBoolean wasReleased = new AtomicBoolean();

    public ReleasingClientCall(ClientCall<ReqT, RespT> delegate, Entry entry) {
      super(delegate);
      this.entry = entry;
    }

    @Override
    public void start(Listener<RespT> responseListener, Metadata headers) {
      if (cancellationException != null) {
        throw new IllegalStateException("Call is already cancelled", cancellationException);
      }
      try {
        super.start(
            new SimpleForwardingClientCallListener<RespT>(responseListener) {
              @Override
              public void onClose(Status status, Metadata trailers) {
                if (!wasClosed.compareAndSet(false, true)) {
                  LOG.log(
                      Level.WARNING,
                      "Call is being closed more than once. Please make sure that onClose() is not"
                          + " being manually called.");
                  return;
                }
                try {
                  super.onClose(status, trailers);
                } finally {
                  if (wasReleased.compareAndSet(false, true)) {
                    entry.release();
                  } else {
                    LOG.log(
                        Level.WARNING,
                        "Entry was released before the call is closed. This may be due to an"
                            + " exception on start of the call.");
                  }
                }
              }
            },
            headers);
      } catch (Exception e) {
        // In case start failed, make sure to release
        if (wasReleased.compareAndSet(false, true)) {
          entry.release();
        } else {
          LOG.log(
              Level.WARNING,
              "The entry is already released. This indicates that onClose() has already been called"
                  + " previously");
        }
        throw e;
      }
    }

    @Override
    public void cancel(@Nullable String message, @Nullable Throwable cause) {
      this.cancellationException = new CancellationException(message);
      super.cancel(message, cause);
    }
  }
}
