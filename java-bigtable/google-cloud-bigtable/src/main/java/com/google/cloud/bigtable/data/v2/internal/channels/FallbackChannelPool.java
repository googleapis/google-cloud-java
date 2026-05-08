/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.bigtable.data.v2.internal.channels;

import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.SessionClientConfiguration.ChannelPoolConfiguration;
import com.google.bigtable.v2.SessionClientConfiguration.ChannelPoolConfiguration.DirectAccessWithFallback;
import com.google.bigtable.v2.SessionRequest;
import com.google.bigtable.v2.SessionResponse;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.PoolFallbackListener;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.PoolFallbackListener.ChannelFallbackReason;
import com.google.common.base.Preconditions;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.time.Duration;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class FallbackChannelPool implements ChannelPool {
  private FallbackConfiguration config;
  private final ChannelPool primary;
  private final ChannelPool secondary;
  private final PoolFallbackListener poolFallbackListener;
  private final ScheduledExecutorService exec;

  @GuardedBy("this")
  private ScheduledFuture<?> checkTask;

  private final AtomicReference<ChannelPool> currentPool;

  private final AtomicInteger successCount = new AtomicInteger();
  private final AtomicInteger failureCount = new AtomicInteger();

  public FallbackChannelPool(
      FallbackConfiguration config,
      PoolFallbackListener poolFallbackListener,
      ScheduledExecutorService exec) {
    Preconditions.checkNotNull(config);
    Preconditions.checkNotNull(poolFallbackListener);
    Preconditions.checkNotNull(exec);
    this.config = config;
    this.primary = config.getPrimaryChannelPool();
    this.secondary = config.getFallbackChannelPool();
    currentPool = new AtomicReference<ChannelPool>(primary);
    this.poolFallbackListener = poolFallbackListener;
    this.exec = exec;
  }

  @Override
  public void start() {
    scheduleCheckRates();
    primary.start();
    secondary.start();
  }

  @Override
  public void updateConfig(ChannelPoolConfiguration newConfig) {
    if (!newConfig.hasDirectAccessWithFallback()) {
      return;
    }

    DirectAccessWithFallback directAccessWithFallback = newConfig.getDirectAccessWithFallback();
    updateConfig(
        config.toBuilder()
            .setEnabled(true)
            .setErrorRate(directAccessWithFallback.getErrorRateThreshold())
            .setCheckInterval(
                Duration.ofSeconds(directAccessWithFallback.getCheckInterval().getSeconds()))
            .build());

    // Propagate further.
    primary.updateConfig(newConfig);
    secondary.updateConfig(newConfig);
  }

  // For now only updates error rate, interval, and is enabled.
  synchronized void updateConfig(FallbackConfiguration newConfig) {
    config =
        config.toBuilder()
            .setEnabled(newConfig.isEnabled())
            .setCheckInterval(newConfig.getCheckInterval())
            .setErrorRate(newConfig.getErrorRate())
            .build();

    if (!config.isEnabled()) {
      if (currentPool.compareAndSet(secondary, primary)) {
        poolFallbackListener.onFallback(
            config.getFallbackName(),
            config.getPrimaryName(),
            ChannelFallbackReason.FALLBACK_DISABLE);
      }
    }
  }

  @Override
  public synchronized void close() {
    if (checkTask != null) {
      checkTask.cancel(false);
    }
    primary.close();
    secondary.close();
  }

  @Override
  public SessionStream newStream(
      MethodDescriptor<SessionRequest, SessionResponse> desc, CallOptions callOptions) {
    final ChannelPool current = currentPool.get();
    final SessionStream stream = current.newStream(desc, callOptions);

    return new ForwardingSessionStream(stream) {
      private boolean ignoreError;

      @Override
      public void start(Listener responseListener, Metadata headers) {
        try {
          super.start(
              new SessionStream.ForwardingListener(responseListener) {
                @Override
                public void onBeforeSessionStart(PeerInfo peerInfo) {
                  if (current == primary) {
                    // Count successful session establishment as success.
                    successCount.incrementAndGet();
                    // peerInfo received successfully, session is established,
                    // this is a successful start, thus ignoring any following errors.
                    ignoreError = true;
                  }
                  super.onBeforeSessionStart(peerInfo);
                }

                @Override
                public void onClose(Status status, Metadata trailers) {
                  // Already using fallback.
                  if (current != primary) {
                    super.onClose(status, trailers);
                    return;
                  }

                  if (!status.isOk() && !ignoreError) {
                    failureCount.incrementAndGet();
                  }
                  super.onClose(status, trailers);
                }
              },
              headers);
        } catch (Exception e) {
          if (current == primary) {
            // Any exception on newStream start is a failure.
            failureCount.incrementAndGet();
          }
          throw e;
        }
      }

      @Override
      public void forceClose(@Nullable String message, @Nullable Throwable cause) {
        // Force closing the session, thus ignoring the error caused by that.
        ignoreError = true;
        super.forceClose(message, cause);
      }
    };
  }

  private synchronized void scheduleCheckRates() {
    checkTask =
        exec.schedule(
            this::checkRatesAndReschedule,
            config.getCheckInterval().toMillis(),
            TimeUnit.MILLISECONDS);
  }

  private void checkRatesAndReschedule() {
    checkRates();
    scheduleCheckRates();
  }

  private synchronized void checkRates() {
    int successes = successCount.getAndSet(0);
    int failures = failureCount.getAndSet(0);
    int total = successes + failures;

    if (!config.isEnabled()) {
      return;
    }

    if (total > 0 && ((double) failures) / total >= config.getErrorRate()) {
      if (currentPool.compareAndSet(primary, secondary)) {
        poolFallbackListener.onFallback(
            config.getPrimaryName(), config.getFallbackName(), ChannelFallbackReason.ERROR_RATE);
      }
    }
  }
}
