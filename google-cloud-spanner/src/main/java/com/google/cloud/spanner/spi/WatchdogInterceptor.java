/*
 * Copyright 2017 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.spi;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Ticker;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/**
 * A gRPC interceptor that monitors activity on outstanding RPCs. If an RPC sees no activity for a
 * configurable period of time, the watchdog will cancel that RPC and cause it to return an {@code
 * UNAVAILABLE} error so that higher level code will retry the operation. This class exists to work
 * around any edge case that may cause an RPC to hang indefinitely.
 */
class WatchdogInterceptor implements ClientInterceptor {
  private static final String PROPERTY_TIMEOUT_SECONDS =
      "com.google.cloud.spanner.watchdogTimeoutSeconds";
  private static final String PROPERTY_PERIOD_SECONDS =
      "com.google.cloud.spanner.watchdogPeriodSeconds";
  private static final int DEFAULT_TIMEOUT_SECONDS = 30 * 60;
  private static final int DEFAULT_PERIOD_SECONDS = 10;

  private static final Logger logger = Logger.getLogger(WatchdogInterceptor.class.getName());

  private final long activityTimeoutNanos;
  private final TimeUnit activityTimeoutUnits;
  private final Ticker ticker;
  private final ConcurrentHashMap<MonitoredCall<?, ?>, MonitoredCall<?, ?>> monitoredCalls;

  WatchdogInterceptor(long activityTimeout, TimeUnit activityTimeoutUnits) {
    this(activityTimeout, activityTimeoutUnits, Ticker.systemTicker());
  }

  WatchdogInterceptor(long activityTimeout, TimeUnit activityTimeoutUnits, Ticker ticker) {
    checkArgument(activityTimeout > 0, "activityTimeout must be positive");
    this.activityTimeoutNanos = activityTimeoutUnits.toNanos(activityTimeout);
    this.activityTimeoutUnits = checkNotNull(activityTimeoutUnits);
    this.ticker = checkNotNull(ticker);
    // Expect up to ~100 RPCs/channel for initial capacity. Default concurrency level of 16 is
    // likely about right for most applications.
    this.monitoredCalls = new ConcurrentHashMap<>(128 /* initialCapacity */);
  }

  private static int systemProperty(String name, int defaultValue) {
    String stringValue = System.getProperty(name, "");
    return stringValue.isEmpty() ? defaultValue : Integer.parseInt(stringValue);
  }

  /**
   * Creates a default instance based on the system property {@code
   * com.google.cloud.spanner.watchdogTimeoutSeconds}, or a no-op interceptor if none configured.
   */
  @Nullable
  static ClientInterceptor newDefaultWatchdogInterceptor() {
    int timeoutSeconds = systemProperty(PROPERTY_TIMEOUT_SECONDS, DEFAULT_TIMEOUT_SECONDS);
    if (timeoutSeconds <= 0) {
      return new ClientInterceptor() {
        @Override
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
            MethodDescriptor<ReqT, RespT> methodDescriptor,
            CallOptions callOptions,
            Channel channel) {
          return channel.newCall(methodDescriptor, callOptions);
        }
      };
    }
    int periodSeconds = systemProperty(PROPERTY_PERIOD_SECONDS, DEFAULT_PERIOD_SECONDS);
    final WatchdogInterceptor interceptor =
        new WatchdogInterceptor(timeoutSeconds, TimeUnit.SECONDS);
    ScheduledExecutorService executor =
        Executors.newSingleThreadScheduledExecutor(
            new ThreadFactoryBuilder()
                .setDaemon(true)
                .setNameFormat("Cloud-Spanner-WatchdogInterceptor-%d")
                .build());
    executor.scheduleWithFixedDelay(
        new Runnable() {
          @Override
          public void run() {
            interceptor.tick();
          }
        },
        periodSeconds,
        periodSeconds,
        TimeUnit.SECONDS);
    logger.log(
        Level.FINE,
        "Created watchdog interceptor with activity timeout of {0}s and period {1}s",
        new Object[] {timeoutSeconds, periodSeconds});
    return interceptor;
  }

  /**
   * Scans over RPCs currently known to the interceptor, cancelling any that have not seen activity
   * within the timeout.
   */
  void tick() {
    for (MonitoredCall<?, ?> call : monitoredCalls.keySet()) {
      call.checkActivity();
    }
  }

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
      MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
    return new MonitoredCall<>(channel.newCall(methodDescriptor, callOptions));
  }

  private void registerCall(MonitoredCall<?, ?> call) {
    // Cannot put a null value into the map, so use "call".
    monitoredCalls.put(call, call);
  }

  private void unregisterCall(MonitoredCall<?, ?> call) {
    monitoredCalls.remove(call);
  }

  private class MonitoredCall<ReqT, RespT>
      extends ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT> {
    private volatile long lastActivityNanos;
    private volatile boolean stoppedByWatchdog;
    private final AtomicBoolean cancelled = new AtomicBoolean(false);

    MonitoredCall(ClientCall<ReqT, RespT> delegate) {
      super(delegate);
    }

    @Override
    public void start(Listener<RespT> responseListener, Metadata headers) {
      recordActivity();
      registerCall(this);

      ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT> listener =
          new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(
              responseListener) {
            @Override
            public void onHeaders(Metadata headers) {
              recordActivity();
              super.onHeaders(headers);
            }

            @Override
            public void onMessage(RespT message) {
              recordActivity();
              super.onMessage(message);
            }

            @Override
            public void onReady() {
              recordActivity();
              super.onReady();
            }

            @Override
            public void onClose(Status status, Metadata trailers) {
              unregisterCall(MonitoredCall.this);
              super.onClose(handleStatus(status), trailers);
            }
          };

      super.start(listener, headers);
    }

    void recordActivity() {
      lastActivityNanos = ticker.read();
    }

    void checkActivity() {
      if (ticker.read() - lastActivityNanos > activityTimeoutNanos
          && cancelled.compareAndSet(false, true)) {
        stoppedByWatchdog = true;
        delegate().cancel("Cancelled by activity watchdog", null);
        logger.log(
            Level.WARNING,
            "Cancelled due to exceeding inactivity timeout of {0} {1}",
            new Object[] {
              activityTimeoutUnits.convert(activityTimeoutNanos, TimeUnit.NANOSECONDS),
              activityTimeoutUnits
            });
      }
    }

    Status handleStatus(Status status) {
      if (stoppedByWatchdog && status.getCode() == Status.Code.CANCELLED) {
        return Status.UNAVAILABLE.withDescription(
            "Aborted by RPC activity watchdog [timeout="
                + activityTimeoutUnits.convert(activityTimeoutNanos, TimeUnit.NANOSECONDS)
                + " "
                + activityTimeoutUnits
                + "]");
      }
      return status;
    }

    @Override
    public void cancel(@Nullable String message, @Nullable Throwable cause) {
      if (cancelled.compareAndSet(false, true)) {
        super.cancel(message, cause);
      }
    }
  }
}
