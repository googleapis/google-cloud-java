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

package com.google.cloud.bigtable.data.v2.internal.util;

import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.ClientConfiguration;
import com.google.bigtable.v2.ClientConfiguration.PollingCase;
import com.google.bigtable.v2.FeatureFlags;
import com.google.bigtable.v2.GetClientConfigurationRequest;
import com.google.bigtable.v2.TelemetryConfiguration;
import com.google.cloud.bigtable.data.v2.internal.api.ChannelProviders.ChannelProvider;
import com.google.cloud.bigtable.data.v2.internal.api.Util;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.DebugTagTracer;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.TextFormat;
import com.google.protobuf.util.Durations;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ClientCall.Listener;
import io.grpc.Deadline;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/**
 * ClientConfiguration controls how the data client should behave. For example, it controls how much
 * of the traffic should go through jetstream vs unary. It also controls how frequent the client
 * should poll for a new configuration and how long the configuration is valid for.
 */
public class ClientConfigurationManager implements AutoCloseable {
  private static final Logger logger = Logger.getLogger(ClientConfigurationManager.class.getName());

  public static final String OVERRIDE_SYS_PROP_KEY = "bigtable.internal.client-config-override";

  public interface ConfigListener<T> {
    void onChange(T newValue);
  }

  public interface ListenerHandle extends Closeable {
    @Override
    void close();
  }

  private class ListenerEntry<T> implements ListenerHandle {
    private final Function<ClientConfiguration, T> extractor;
    private final ConfigListener<T> listener;

    private ListenerEntry(Function<ClientConfiguration, T> extractor, ConfigListener<T> listener) {
      this.extractor = extractor;
      this.listener = listener;
    }

    private void maybeNotify(ClientConfiguration oldConfig, ClientConfiguration newConfig) {
      T oldValue = extractor.apply(oldConfig);
      T newValue = extractor.apply(newConfig);
      if (Objects.equals(oldValue, newValue)) {
        return;
      }
      listener.onChange(newValue);
    }

    @Override
    public void close() {
      synchronized (ClientConfigurationManager.this) {
        if (notifying) {
          pendingListenerRemovals.add(this);
        } else {
          listeners.remove(this);
        }
      }
    }
  }

  private final Metadata metadata;
  private final GetClientConfigurationRequest request;
  private final ChannelProvider channelProvider;

  @GuardedBy("this")
  private ManagedChannel channel;

  private final DebugTagTracer debugTagTracer;
  private final ScheduledExecutorService executor;

  private final ClientConfiguration defaultConfig;
  private final Optional<ClientConfiguration> overrideConfig;

  private final Duration defaultDeadline = Duration.ofSeconds(5);

  @GuardedBy("this")
  @Nonnull
  private ClientConfiguration clientConfiguration;

  @GuardedBy("this")
  @Nonnull
  private Instant validUntil = Instant.MAX;

  @GuardedBy("this")
  private final List<ListenerEntry<?>> listeners = new ArrayList<>();

  @GuardedBy("this")
  private boolean notifying = false;

  @GuardedBy("this")
  private final Set<ListenerEntry<?>> pendingListenerRemovals = new HashSet<>();

  @GuardedBy("this")
  @Nullable
  private ScheduledFuture<?> nextPoll = null;

  @GuardedBy("this")
  private boolean closing = false;

  public ClientConfigurationManager(
      FeatureFlags featureFlags,
      ClientInfo clientInfo,
      ChannelProvider channelProvider,
      DebugTagTracer tracer,
      ScheduledExecutorService executor)
      throws IOException {
    this(System.getProperties(), featureFlags, clientInfo, channelProvider, tracer, executor);
  }

  ClientConfigurationManager(
      Properties sysProps,
      FeatureFlags featureFlags,
      ClientInfo clientInfo,
      ChannelProvider channelProvider,
      DebugTagTracer tracer,
      ScheduledExecutorService executor)
      throws IOException {
    this.defaultConfig = loadDefault();
    this.overrideConfig =
        Optional.ofNullable(sysProps.getProperty(OVERRIDE_SYS_PROP_KEY))
            .map(
                str -> {
                  try {
                    return TextFormat.parse(str, ClientConfiguration.class);
                  } catch (Exception e) {
                    throw new RuntimeException(
                        "Failed to parse bigtable.internal.client-config-override", e);
                  }
                });

    if (overrideConfig.isPresent()) {
      logger.log(
          Level.INFO,
          () ->
              "Local client config override: "
                  + TextFormat.printer()
                      .emittingSingleLine(true)
                      .printToString(overrideConfig.get()));
    }
    featureFlags = channelProvider.updateFeatureFlags(featureFlags);
    this.clientConfiguration = defaultConfig;

    this.metadata =
        Util.composeMetadata(
            featureFlags,
            ImmutableMap.of(
                "instance_name", clientInfo.getInstanceName().toString(),
                "app_profile_id", clientInfo.getAppProfileId()));
    this.request =
        GetClientConfigurationRequest.newBuilder()
            .setInstanceName(clientInfo.getInstanceName().toString())
            .setAppProfileId(clientInfo.getAppProfileId())
            .build();

    this.channelProvider = channelProvider;
    this.channel = channelProvider.newChannelBuilder().build();
    this.debugTagTracer = tracer;
    this.executor = executor;
  }

  public static ClientConfiguration loadDefault() throws IOException {
    try (InputStream is =
        ClientConfiguration.class.getResourceAsStream(
            "/bigtable-default-client-config.textproto")) {
      Preconditions.checkNotNull(is, "Failed to load default config");

      try (Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {
        ClientConfiguration.Builder builder = ClientConfiguration.newBuilder();
        TextFormat.getParser().merge(reader, builder);
        return builder.build();
      }
    }
  }

  /**
   * Start polling client configuration. The first poll should be blocking and client should fall
   * back to unary if it fails.
   */
  public CompletableFuture<ClientConfiguration> start() {
    CompletableFuture<ClientConfiguration> f = startPolling();
    @SuppressWarnings("UnusedVariable")
    CompletableFuture<ClientConfiguration> ignored =
        f.whenComplete(
            (cfg, error) -> {
              if (error != null) {
                debugTagTracer.record(
                    TelemetryConfiguration.Level.ERROR, "client_config_fetch_failed");
                logger.log(Level.WARNING, "Failed to fetch initial config", error);
              } else {
                logger.log(Level.CONFIG, "Got initial config: {0}", cfg);
              }
            });
    return f;
  }

  @Override
  public synchronized void close() {
    closing = true;
    if (nextPoll != null) {
      nextPoll.cancel(true);
    }
    channel.shutdown();
  }

  /** Gets the client configuration. */
  @Nonnull
  public synchronized ClientConfiguration getClientConfiguration() {
    return this.clientConfiguration;
  }

  ClientConfiguration getDefaultConfig() {
    return defaultConfig;
  }

  public synchronized <T> ListenerHandle addListener(
      Function<ClientConfiguration, T> extractor, ConfigListener<T> listener) {
    ListenerEntry<T> entry = new ListenerEntry<>(extractor, listener);
    listeners.add(entry);
    return entry;
  }

  private CompletableFuture<ClientConfiguration> startPolling() {
    CompletableFuture<ClientConfiguration> result = new CompletableFuture<>();
    sendRequestWithRetries(0, result);
    return result;
  }

  private synchronized void sendRequestWithRetries(
      int attemptCount, CompletableFuture<ClientConfiguration> finalResult) {
    if (closing) {
      finalResult.completeExceptionally(new RuntimeException("Client is closing"));
      return;
    }

    CompletableFuture<ClientConfiguration> currentRequest = sendRequest();
    // We only schedule the next poll after successfully getting a client config
    // from the server.
    @SuppressWarnings("UnusedVariable")
    CompletableFuture<ClientConfiguration> ignored =
        currentRequest.whenComplete(
            (result, throwable) -> {
              // Config updated
              if (throwable == null) {
                setClientConfiguration(result);
                scheduleNextPoll();
                finalResult.complete(result);
                return;
              }

              // Handle failure and retry if necessary
              if (handleFailedFetch(throwable, attemptCount)) {
                debugTagTracer.record(
                    TelemetryConfiguration.Level.ERROR, "client_config_fetch_failed");
                replaceChannel();
                long delay = getRetryDelay(attemptCount);
                @SuppressWarnings("UnusedVariable")
                ScheduledFuture<?> ignored2 =
                    executor.schedule(
                        () -> sendRequestWithRetries(attemptCount + 1, finalResult),
                        delay,
                        TimeUnit.MILLISECONDS);
              } else {
                scheduleNextPoll();
                finalResult.completeExceptionally(throwable);
              }
            });
  }

  @GuardedBy("this")
  private CompletableFuture<ClientConfiguration> sendRequest() {
    CompletableFuture<ClientConfiguration> future = new CompletableFuture<>();

    ClientCall<GetClientConfigurationRequest, ClientConfiguration> call =
        channel.newCall(
            BigtableGrpc.getGetClientConfigurationMethod(),
            CallOptions.DEFAULT.withDeadline(
                Deadline.after(defaultDeadline.toMillis(), TimeUnit.MILLISECONDS)));
    call.start(
        new Listener<ClientConfiguration>() {
          @Override
          public void onMessage(ClientConfiguration cfg) {
            cfg = normalizeConfig(cfg);
            future.complete(cfg);
          }

          @Override
          public void onClose(Status status, Metadata trailers) {
            if (!status.isOk()) {
              future.completeExceptionally(status.asRuntimeException());
            }
          }
        },
        metadata);
    call.sendMessage(request);
    call.halfClose();
    call.request(1);

    return future;
  }

  @SuppressWarnings("deprecation")
  private ClientConfiguration normalizeConfig(ClientConfiguration cfg) {
    ClientConfiguration.Builder builder = cfg.toBuilder();

    // TODO: remove this once server is updated
    // Patch PollingConfiguration (migrating PollingInterval)
    if (!cfg.hasPollingConfiguration()) {
      builder.setPollingConfiguration(
          defaultConfig.getPollingConfiguration().toBuilder()
              .setPollingInterval(cfg.getPollingInterval()));
    }

    // TODO: remove this once server is updated
    // Patch SessionPoolConfiguration (migrating LoadBalancingOptions)
    if (!cfg.getSessionConfiguration().hasSessionPoolConfiguration()) {
      builder
          .getSessionConfigurationBuilder()
          .clearLoadBalancingOptions()
          .setSessionPoolConfiguration(
              defaultConfig.getSessionConfiguration().getSessionPoolConfiguration().toBuilder()
                  .setLoadBalancingOptions(cfg.getSessionConfiguration().getLoadBalancingOptions())
                  .build());
    } else {
      // ignore LoadBalancing options when we migrated to SessionPoolConfig
      builder.getSessionConfigurationBuilder().clearLoadBalancingOptions();
    }
    // TODO: remove this once server is updated
    // Patch ChannelPoolConfiguration
    if (!cfg.getSessionConfiguration().hasChannelConfiguration()) {
      builder
          .getSessionConfigurationBuilder()
          .setChannelConfiguration(
              defaultConfig.getSessionConfiguration().getChannelConfiguration());
    }

    // Patch debug tag level
    switch (cfg.getTelemetryConfiguration().getDebugTagLevel()) {
      case UNRECOGNIZED:
      case LEVEL_UNSPECIFIED:
        builder
            .getTelemetryConfigurationBuilder()
            .setDebugTagLevel(defaultConfig.getTelemetryConfiguration().getDebugTagLevel());
    }

    // Inject overrides
    overrideConfig.ifPresent(builder::mergeFrom);

    // When sessions are disabled make sure to clear out the config
    if (cfg.getSessionConfiguration().getSessionLoad() == 0) {
      builder.clearSessionConfiguration();
      return builder.build();
    }

    return builder.build();
  }

  public boolean areSessionsRequired() {
    return overrideConfig.map(c -> c.getSessionConfiguration().getSessionLoad() > 0).orElse(false);
  }

  private long getRetryDelay(int attempt) {
    // the attempt is the total number of attempts starting from 0. The first request
    // is sent immediately, and the second request is sent after 2 ^ 0 ms (with jitter) etc.
    // Initial delay is 1 ms.
    return ThreadLocalRandom.current().nextLong((long) Math.pow(2, attempt));
  }

  private synchronized void scheduleNextPoll() {
    if (closing) {
      return;
    }

    if (!clientConfiguration.hasPollingConfiguration()) {
      return;
    }
    long delayMs =
        Durations.toMillis(clientConfiguration.getPollingConfiguration().getPollingInterval());

    this.nextPoll =
        executor.schedule(
            () -> {
              @SuppressWarnings("UnusedVariable")
              CompletableFuture<ClientConfiguration> ignored = startPolling();
            },
            delayMs,
            TimeUnit.MILLISECONDS);
  }

  private synchronized void setClientConfiguration(ClientConfiguration result) {
    ClientConfiguration old = this.clientConfiguration;

    clientConfiguration = result;
    if (clientConfiguration.hasPollingConfiguration()) {
      this.validUntil =
          Instant.now()
              .plus(
                  toJavaDuration(
                      clientConfiguration.getPollingConfiguration().getValidityDuration()));
    } else if (clientConfiguration.getStopPolling()) {
      this.validUntil = Instant.MAX;
    }

    maybeLogConfigChange(old, result);
    notifyListeners(old, clientConfiguration);
  }

  private void maybeLogConfigChange(ClientConfiguration oldCfg, ClientConfiguration newCfg) {
    if (shouldLogConfigChange(oldCfg, newCfg)) {
      logger.log(Level.CONFIG, "ClientConfig changed to: {0}", newCfg);
    }
  }

  private boolean shouldLogConfigChange(ClientConfiguration oldCfg, ClientConfiguration newCfg) {
    if (oldCfg.getPollingCase() != newCfg.getPollingCase()) {
      return true;
    }
    // round down interval to minimize noise from jitter
    if (oldCfg.getPollingCase() == PollingCase.POLLING_CONFIGURATION) {
      long oldInterval = Durations.toMinutes(oldCfg.getPollingConfiguration().getPollingInterval());
      long newInterval = Durations.toMinutes(newCfg.getPollingConfiguration().getPollingInterval());
      if (oldInterval == newInterval) {
        ClientConfiguration.Builder roundedOldCfgBuilder = oldCfg.toBuilder();
        roundedOldCfgBuilder
            .getPollingConfigurationBuilder()
            .setPollingInterval(newCfg.getPollingConfiguration().getPollingInterval());
        oldCfg = roundedOldCfgBuilder.build();
      }
    }
    return oldCfg.equals(newCfg);
  }

  @GuardedBy("this")
  private void notifyListeners(ClientConfiguration oldConfig, ClientConfiguration newConfig) {
    notifying = true;
    // Snapshot the listeners so that new listeners added this cycle dont get notified
    List<ListenerEntry<?>> snapshot = new ArrayList<>(listeners);

    for (ListenerEntry<?> e : snapshot) {
      if (pendingListenerRemovals.contains(e)) {
        continue;
      }
      e.maybeNotify(oldConfig, newConfig);
    }

    listeners.removeAll(pendingListenerRemovals);
    pendingListenerRemovals.clear();
    notifying = false;
  }

  private synchronized boolean handleFailedFetch(Throwable throwable, int attempt) {
    if (validUntil.isBefore(Instant.now())) {
      setClientConfiguration(defaultConfig);
    }

    // Figure out if we should retry
    if (!(throwable instanceof StatusRuntimeException)) {
      return false;
    }
    Code statusCode = Status.fromThrowable(throwable).getCode();
    // do not retry non-retryable errors
    switch (statusCode) {
      case PERMISSION_DENIED:
      case UNAUTHENTICATED:
        logger.warning("instance.ping permission is required");
        return false;
      case NOT_FOUND:
      case INVALID_ARGUMENT:
        return false;
      default:
        if (closing) {
          return false;
        }
        return attempt < getClientConfiguration().getPollingConfiguration().getMaxRpcRetryCount();
    }
  }

  private synchronized void replaceChannel() {
    channel.shutdownNow();
    channel = channelProvider.newChannelBuilder().build();
  }

  private static Duration toJavaDuration(com.google.protobuf.Duration protobufDuration) {
    return Duration.ofMillis(Durations.toMillis(protobufDuration));
  }
}
