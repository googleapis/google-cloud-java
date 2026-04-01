/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.connection;

import com.google.cloud.NoCredentials;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpChannelPoolOptions;
import com.google.cloud.spanner.DecodeMode;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SessionPoolOptions;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import io.grpc.ManagedChannelBuilder;
import io.opentelemetry.api.OpenTelemetry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.annotation.concurrent.GuardedBy;

/**
 * Pool for keeping track of {@link Spanner} instances needed for connections.
 *
 * <p>When a connection is opened for a Google Cloud Spanner database, a {@link Spanner} object can
 * be opened in the background. The {@link SpannerPool} keeps track of which {@link Spanner} objects
 * have been opened by connections during the lifetime of the JVM, which connections are still
 * opened and closed, and which {@link Spanner} objects could be closed.
 *
 * <p>Call the method {@link SpannerPool#closeSpannerPool()} at the end of your application to
 * gracefully shut down all instances in the pool.
 */
public class SpannerPool {
  // TODO: create separate Client Lib Token for the Connection API.
  private static final String CONNECTION_API_CLIENT_LIB_TOKEN = "sp-jdbc";
  private static final Logger logger = Logger.getLogger(SpannerPool.class.getName());

  private static final Function<Spanner, Void> DEFAULT_CLOSE_FUNCTION =
      spanner -> {
        spanner.close();
        return null;
      };

  /**
   * Closes the default {@link SpannerPool} and all {@link Spanner} instances that have been opened
   * by connections and that are still open. Call this method at the end of your application to
   * gracefully close all {@link Spanner} instances in the pool. Failing to call this method will
   * keep your application running for 60 seconds after you close the last {@link
   * java.sql.Connection} to Cloud Spanner, as this is the default timeout before the {@link
   * SpannerPool} closes the unused {@link Spanner} instances.
   */
  public static void closeSpannerPool() {
    INSTANCE.checkAndCloseSpanners();
  }

  /**
   * The minimum number of milliseconds a {@link Spanner} should not have been used for a connection
   * before it is closed.
   */
  private static final long DEFAULT_CLOSE_SPANNER_AFTER_MILLISECONDS_UNUSED = 60000L;

  static final SpannerPool INSTANCE =
      new SpannerPool(DEFAULT_CLOSE_SPANNER_AFTER_MILLISECONDS_UNUSED, Ticker.systemTicker());

  @VisibleForTesting
  enum CheckAndCloseSpannersMode {
    WARN,
    ERROR
  }

  private final class CloseSpannerRunnable implements Runnable {
    @Override
    public void run() {
      try {
        checkAndCloseSpanners(CheckAndCloseSpannersMode.WARN);
      } catch (Throwable e) {
        // ignore
      }
    }
  }

  private final class CloseUnusedSpannersRunnable implements Runnable {
    @Override
    public void run() {
      try {
        closeUnusedSpanners(SpannerPool.this.closeSpannerAfterMillisecondsUnused);
      } catch (Throwable e) {
        logger.log(Level.FINE, "Scheduled call to closeUnusedSpanners failed", e);
      }
    }
  }

  static class CredentialsKey {
    static final Object DEFAULT_CREDENTIALS_KEY = new Object();
    final Object key;

    static CredentialsKey create(ConnectionOptions options) throws IOException {
      return new CredentialsKey(
          Stream.of(
                  options.getOAuthToken(),
                  options.getCredentialsProvider() == null ? null : options.getCredentials(),
                  options.getFixedCredentials(),
                  options.getCredentialsUrl(),
                  DEFAULT_CREDENTIALS_KEY)
              .filter(Objects::nonNull)
              .findFirst()
              .get());
    }

    private CredentialsKey(Object key) {
      this.key = Preconditions.checkNotNull(key);
    }

    public int hashCode() {
      return key.hashCode();
    }

    public boolean equals(Object o) {
      return (o instanceof CredentialsKey && Objects.equals(((CredentialsKey) o).key, this.key));
    }
  }

  static class SpannerPoolKey {
    private final String host;
    private final String projectId;
    private final CredentialsKey credentialsKey;
    private final SessionPoolOptions sessionPoolOptions;
    private final Integer numChannels;
    private final Boolean enableDynamicChannelPool;
    private final Integer dcpMinChannels;
    private final Integer dcpMaxChannels;
    private final Integer dcpInitialChannels;
    private final boolean usePlainText;
    private final String userAgent;
    private final String databaseRole;
    private final boolean routeToLeader;
    private final boolean useVirtualGrpcTransportThreads;
    private final OpenTelemetry openTelemetry;
    private final Boolean enableExtendedTracing;
    private final Boolean enableApiTracing;
    private final boolean enableEndToEndTracing;
    private final String clientCertificate;
    private final String clientCertificateKey;
    private final boolean isExperimentalHost;
    private final Boolean enableDirectAccess;
    private final String universeDomain;
    private final String grpcInterceptorProvider;

    @VisibleForTesting
    static SpannerPoolKey of(ConnectionOptions options) {
      try {
        return new SpannerPoolKey(options);
      } catch (IOException ioException) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT,
            "Failed to get credentials: " + ioException.getMessage(),
            ioException);
      }
    }

    private SpannerPoolKey(ConnectionOptions options) throws IOException {
      this.host = options.getHost();
      this.projectId = options.getProjectId();
      this.credentialsKey = CredentialsKey.create(options);
      this.databaseRole = options.getDatabaseRole();
      this.sessionPoolOptions =
          options.getSessionPoolOptions() == null
              ? SessionPoolOptions.newBuilder().build()
              : options.getSessionPoolOptions();
      this.numChannels = options.getNumChannels();
      this.enableDynamicChannelPool = options.isEnableDynamicChannelPool();
      this.dcpMinChannels = options.getDcpMinChannels();
      this.dcpMaxChannels = options.getDcpMaxChannels();
      this.dcpInitialChannels = options.getDcpInitialChannels();
      this.usePlainText = options.isUsePlainText();
      this.userAgent = options.getUserAgent();
      this.routeToLeader = options.isRouteToLeader();
      this.useVirtualGrpcTransportThreads = options.isUseVirtualGrpcTransportThreads();
      this.openTelemetry = options.getOpenTelemetry();
      this.enableExtendedTracing = options.isEnableExtendedTracing();
      this.enableApiTracing = options.isEnableApiTracing();
      this.enableEndToEndTracing = options.isEndToEndTracingEnabled();
      this.clientCertificate = options.getClientCertificate();
      this.clientCertificateKey = options.getClientCertificateKey();
      this.isExperimentalHost = options.isExperimentalHost();
      this.enableDirectAccess = options.isEnableDirectAccess();
      this.universeDomain = options.getUniverseDomain();
      this.grpcInterceptorProvider = options.getGrpcInterceptorProviderName();
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof SpannerPoolKey)) {
        return false;
      }
      SpannerPoolKey other = (SpannerPoolKey) o;
      return Objects.equals(this.host, other.host)
          && Objects.equals(this.projectId, other.projectId)
          && Objects.equals(this.credentialsKey, other.credentialsKey)
          && Objects.equals(this.sessionPoolOptions, other.sessionPoolOptions)
          && Objects.equals(this.numChannels, other.numChannels)
          && Objects.equals(this.enableDynamicChannelPool, other.enableDynamicChannelPool)
          && Objects.equals(this.dcpMinChannels, other.dcpMinChannels)
          && Objects.equals(this.dcpMaxChannels, other.dcpMaxChannels)
          && Objects.equals(this.dcpInitialChannels, other.dcpInitialChannels)
          && Objects.equals(this.databaseRole, other.databaseRole)
          && Objects.equals(this.usePlainText, other.usePlainText)
          && Objects.equals(this.userAgent, other.userAgent)
          && Objects.equals(this.routeToLeader, other.routeToLeader)
          && Objects.equals(
              this.useVirtualGrpcTransportThreads, other.useVirtualGrpcTransportThreads)
          && Objects.equals(this.openTelemetry, other.openTelemetry)
          && Objects.equals(this.enableExtendedTracing, other.enableExtendedTracing)
          && Objects.equals(this.enableApiTracing, other.enableApiTracing)
          && Objects.equals(this.enableEndToEndTracing, other.enableEndToEndTracing)
          && Objects.equals(this.clientCertificate, other.clientCertificate)
          && Objects.equals(this.clientCertificateKey, other.clientCertificateKey)
          && Objects.equals(this.isExperimentalHost, other.isExperimentalHost)
          && Objects.equals(this.enableDirectAccess, other.enableDirectAccess)
          && Objects.equals(this.universeDomain, other.universeDomain)
          && Objects.equals(this.grpcInterceptorProvider, other.grpcInterceptorProvider);
    }

    @Override
    public int hashCode() {
      return Objects.hash(
          this.host,
          this.projectId,
          this.credentialsKey,
          this.sessionPoolOptions,
          this.numChannels,
          this.enableDynamicChannelPool,
          this.dcpMinChannels,
          this.dcpMaxChannels,
          this.dcpInitialChannels,
          this.usePlainText,
          this.databaseRole,
          this.userAgent,
          this.routeToLeader,
          this.useVirtualGrpcTransportThreads,
          this.openTelemetry,
          this.enableExtendedTracing,
          this.enableApiTracing,
          this.enableEndToEndTracing,
          this.clientCertificate,
          this.clientCertificateKey,
          this.isExperimentalHost,
          this.enableDirectAccess,
          this.universeDomain,
          this.grpcInterceptorProvider);
    }
  }

  /**
   * The management threads of a {@link SpannerPool} are lazily initialized to prevent unnecessary
   * threads to be created when the connection API is not used.
   */
  private boolean initialized = false;

  /**
   * Thread that will be run as a shutdown hook on closing the application. This thread will close
   * any Spanner instances opened by the Connection API that are still open.
   */
  private Thread shutdownThread = null;

  /**
   * Keep unused {@link Spanner} instances open and in the pool for this duration after all its
   * {@link Connection}s have been closed. This prevents unnecessary opening and closing of {@link
   * Spanner} instances.
   */
  private final long closeSpannerAfterMillisecondsUnused;

  /**
   * This scheduled task will close all {@link Spanner} objects that have not been used for an open
   * connection for at least {@link SpannerPool#DEFAULT_CLOSE_SPANNER_AFTER_MILLISECONDS_UNUSED}
   * milliseconds.
   */
  private ScheduledExecutorService closerService;

  @GuardedBy("this")
  private final Map<SpannerPoolKey, Spanner> spanners = new HashMap<>();

  @GuardedBy("this")
  private final Map<SpannerPoolKey, List<ConnectionImpl>> connections = new HashMap<>();

  /**
   * Keep track of the moment that the last connection for a specific {@link SpannerPoolKey} was
   * closed, so that we can use this to determine whether a {@link Spanner} instance should be
   * closed and removed from the pool. As {@link Spanner} instances are expensive to create and
   * close, we do not want to do that unnecessarily. By adding a delay between the moment the last
   * {@link Connection} for a {@link Spanner} was closed and the moment we close the {@link Spanner}
   * instance, we prevent applications that open one or more connections for a process and close all
   * these connections at the end of the process from getting a severe performance penalty from
   * opening and closing {@link Spanner} instances all the time.
   *
   * <p>{@link Spanner} instances are closed and removed from the pool when the last connection was
   * closed more than {@link #closeSpannerAfterMillisecondsUnused} milliseconds ago.
   */
  @GuardedBy("this")
  private final Map<SpannerPoolKey, Long> lastConnectionClosedAt = new HashMap<>();

  private final Ticker ticker;

  @VisibleForTesting
  SpannerPool(Ticker ticker) {
    this(0L, ticker);
  }

  @VisibleForTesting
  SpannerPool(long closeSpannerAfterMillisecondsUnused, Ticker ticker) {
    this.closeSpannerAfterMillisecondsUnused = closeSpannerAfterMillisecondsUnused;
    this.ticker = ticker;
  }

  /**
   * Gets a Spanner object for a connection with the properties specified in the {@link
   * ConnectionOptions} object. The {@link SpannerPool} will manage a pool of opened Spanner objects
   * for the different connections, and reuse Spanner objects whenever possible. Spanner objects
   * will also be closed down when the application is closing.
   *
   * @param options The specification of the Spanner database to connect to.
   * @param connection The {@link ConnectionImpl} that will be created. This {@link ConnectionImpl}
   *     will be tracked by the pool to know when a {@link Spanner} object can be closed.
   * @return an opened {@link Spanner} object that can be used by a connection to communicate with
   *     the Spanner database.
   */
  Spanner getSpanner(ConnectionOptions options, ConnectionImpl connection) {
    Preconditions.checkNotNull(options);
    Preconditions.checkNotNull(connection);
    SpannerPoolKey key = SpannerPoolKey.of(options);
    Spanner spanner;
    synchronized (this) {
      if (!initialized) {
        initialize();
      }
      if (spanners.get(key) != null) {
        spanner = spanners.get(key);
      } else {
        spanner = createSpanner(key, options);
        spanners.put(key, spanner);
      }
      List<ConnectionImpl> registeredConnectionsForSpanner =
          connections.computeIfAbsent(key, k -> new ArrayList<>());
      registeredConnectionsForSpanner.add(connection);
      lastConnectionClosedAt.remove(key);
      return spanner;
    }
  }

  private void initialize() {
    shutdownThread = new Thread(new CloseSpannerRunnable(), "SpannerPool shutdown hook");
    Runtime.getRuntime().addShutdownHook(shutdownThread);
    if (this.closeSpannerAfterMillisecondsUnused > 0) {
      this.closerService =
          Executors.newSingleThreadScheduledExecutor(
              runnable -> {
                Thread thread = new Thread(runnable, "close-unused-spanners-worker");
                thread.setDaemon(true);
                return thread;
              });
      this.closerService.scheduleAtFixedRate(
          new CloseUnusedSpannersRunnable(),
          this.closeSpannerAfterMillisecondsUnused,
          this.closeSpannerAfterMillisecondsUnused,
          TimeUnit.MILLISECONDS);
    }
    initialized = true;
  }

  @VisibleForTesting
  Spanner createSpanner(SpannerPoolKey key, ConnectionOptions options) {
    ConnectionSpannerOptions.Builder builder = ConnectionSpannerOptions.newBuilder();
    builder
        .setUseVirtualThreads(key.useVirtualGrpcTransportThreads)
        .setClientLibToken(MoreObjects.firstNonNull(key.userAgent, CONNECTION_API_CLIENT_LIB_TOKEN))
        .setHost(key.host)
        .setProjectId(key.projectId)
        // Use lazy decoding, so we can use the protobuf values for calculating the checksum that is
        // needed for read/write transactions.
        .setDecodeMode(DecodeMode.LAZY_PER_COL)
        .setDatabaseRole(options.getDatabaseRole())
        .setCredentials(options.getCredentials());
    builder.setSessionPoolOption(key.sessionPoolOptions);
    if (key.openTelemetry != null) {
      builder.setOpenTelemetry(key.openTelemetry);
    }
    if (key.enableExtendedTracing != null) {
      builder.setEnableExtendedTracing(key.enableExtendedTracing);
    }
    if (key.enableApiTracing != null) {
      builder.setEnableApiTracing(key.enableApiTracing);
    }
    if (key.numChannels != null) {
      builder.setNumChannels(key.numChannels);
    }
    // Configure Dynamic Channel Pooling (DCP) based on explicit user setting.
    // Note: Setting numChannels disables DCP even if enableDynamicChannelPool is true.
    if (key.enableDynamicChannelPool != null && key.numChannels == null) {
      if (Boolean.TRUE.equals(key.enableDynamicChannelPool)) {
        builder.enableDynamicChannelPool();
        // Build custom GcpChannelPoolOptions if any DCP-specific options are set.
        if (key.dcpMinChannels != null
            || key.dcpMaxChannels != null
            || key.dcpInitialChannels != null) {
          // Build GcpChannelPoolOptions from scratch with custom values or Spanner defaults.
          // Note: GcpChannelPoolOptions does not have a toBuilder() method, so we must
          // construct from scratch using SpannerOptions defaults for unspecified values.
          int minChannels =
              key.dcpMinChannels != null
                  ? key.dcpMinChannels
                  : SpannerOptions.DEFAULT_DYNAMIC_POOL_MIN_CHANNELS;
          int maxChannels =
              key.dcpMaxChannels != null
                  ? key.dcpMaxChannels
                  : SpannerOptions.DEFAULT_DYNAMIC_POOL_MAX_CHANNELS;
          int initChannels =
              key.dcpInitialChannels != null
                  ? key.dcpInitialChannels
                  : SpannerOptions.DEFAULT_DYNAMIC_POOL_INITIAL_SIZE;
          GcpChannelPoolOptions poolOptions =
              GcpChannelPoolOptions.newBuilder()
                  .setMinSize(minChannels)
                  .setMaxSize(maxChannels)
                  .setInitSize(initChannels)
                  .setDynamicScaling(
                      SpannerOptions.DEFAULT_DYNAMIC_POOL_MIN_RPC,
                      SpannerOptions.DEFAULT_DYNAMIC_POOL_MAX_RPC,
                      SpannerOptions.DEFAULT_DYNAMIC_POOL_SCALE_DOWN_INTERVAL)
                  .setAffinityKeyLifetime(SpannerOptions.DEFAULT_DYNAMIC_POOL_AFFINITY_KEY_LIFETIME)
                  .setCleanupInterval(SpannerOptions.DEFAULT_DYNAMIC_POOL_CLEANUP_INTERVAL)
                  .build();
          builder.setGcpChannelPoolOptions(poolOptions);
        }
      } else {
        // Explicitly disable DCP when enableDynamicChannelPool=false.
        // This ensures consistent behavior even if the default changes in the future.
        builder.disableDynamicChannelPool();
      }
    }
    if (options.getChannelProvider() != null) {
      builder.setChannelProvider(options.getChannelProvider());
    }
    if (!options.isRouteToLeader()) {
      builder.disableLeaderAwareRouting();
    }
    if (options.isEndToEndTracingEnabled()) {
      builder.setEnableEndToEndTracing(true);
    }
    if (key.usePlainText) {
      // Credentials may not be sent over a plain text channel.
      builder.setCredentials(NoCredentials.getInstance());
      // Set a custom channel configurator to allow http instead of https.
      builder.setChannelConfigurator(ManagedChannelBuilder::usePlaintext);
    }
    if (key.clientCertificate != null && key.clientCertificateKey != null) {
      builder.useClientCert(key.clientCertificate, key.clientCertificateKey);
    }
    if (key.isExperimentalHost) {
      builder.setExperimentalHost(key.host);
    }
    if (key.enableDirectAccess != null) {
      builder.setEnableDirectAccess(key.enableDirectAccess);
    }
    if (key.universeDomain != null) {
      builder.setUniverseDomain(key.universeDomain);
    }
    if (key.grpcInterceptorProvider != null) {
      builder.setInterceptorProvider(options.getGrpcInterceptorProvider());
    }
    if (options.getConfigurator() != null) {
      options.getConfigurator().configure(builder);
    }
    return builder.build().getService();
  }

  /**
   * Remove the given {@link ConnectionImpl} from the list of connections that should be monitored
   * by this pool.
   *
   * @param options The {@link ConnectionOptions} that were used to create the connection.
   * @param connection The {@link ConnectionImpl} to remove from this pool..
   */
  void removeConnection(ConnectionOptions options, ConnectionImpl connection) {
    Preconditions.checkNotNull(options);
    Preconditions.checkNotNull(connection);
    SpannerPoolKey key = SpannerPoolKey.of(options);
    synchronized (this) {
      if (spanners.containsKey(key) && connections.containsKey(key)) {
        List<ConnectionImpl> registeredConnections = connections.get(key);
        // Remove the connection from the pool.
        if (registeredConnections == null || !registeredConnections.remove(connection)) {
          logger.log(
              Level.WARNING,
              "There are no connections registered for ConnectionOptions " + options.toString());
        } else {
          // Check if this was the last connection for this spanner key.
          if (registeredConnections.isEmpty()) {
            // Register the moment the last connection for this Spanner key was removed, so we know
            // which Spanner objects we could close.
            lastConnectionClosedAt.put(
                key, TimeUnit.MILLISECONDS.convert(ticker.read(), TimeUnit.NANOSECONDS));
          }
        }
      } else {
        logger.log(
            Level.WARNING,
            "There is no Spanner registered for ConnectionOptions " + options.toString());
      }
    }
  }

  /**
   * Checks that there are no {@link Connection}s that have been created by this {@link SpannerPool}
   * that are still open, and then closes all {@link Spanner} instances in the pool. If there is at
   * least one unclosed {@link Connection} left in the pool, the method will throw a {@link
   * SpannerException} and no {@link Spanner} instances will be closed.
   */
  void checkAndCloseSpanners() {
    checkAndCloseSpanners(CheckAndCloseSpannersMode.ERROR);
  }

  @VisibleForTesting
  void checkAndCloseSpanners(CheckAndCloseSpannersMode mode) {
    checkAndCloseSpanners(mode, DEFAULT_CLOSE_FUNCTION);
  }

  @VisibleForTesting
  void checkAndCloseSpanners(
      CheckAndCloseSpannersMode mode, Function<Spanner, Void> closeSpannerFunction) {
    List<SpannerPoolKey> keysStillInUse = new ArrayList<>();
    synchronized (this) {
      for (Entry<SpannerPoolKey, Spanner> entry : spanners.entrySet()) {
        if (!lastConnectionClosedAt.containsKey(entry.getKey())) {
          keysStillInUse.add(entry.getKey());
        }
      }
      try {
        if (keysStillInUse.isEmpty() || mode == CheckAndCloseSpannersMode.WARN) {
          if (!keysStillInUse.isEmpty()) {
            logLeakedConnections(keysStillInUse);
            logger.log(
                Level.WARNING,
                "There is/are "
                    + keysStillInUse.size()
                    + " connection(s) still open."
                    + " Close all connections before stopping the application");
          }
          // Force close all Spanner instances by passing in a value that will always be less than
          // the
          // difference between the current time and the close time of a connection.
          closeUnusedSpanners(Long.MIN_VALUE, closeSpannerFunction);
        } else {
          logLeakedConnections(keysStillInUse);
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.FAILED_PRECONDITION,
              "There is/are "
                  + keysStillInUse.size()
                  + " connection(s) still open. Close all connections before calling"
                  + " closeSpanner()");
        }
      } finally {
        if (closerService != null) {
          closerService.shutdown();
        }
        initialized = false;
      }
    }
  }

  private void logLeakedConnections(List<SpannerPoolKey> keysStillInUse) {
    synchronized (this) {
      for (SpannerPoolKey key : keysStillInUse) {
        for (ConnectionImpl con : connections.get(key)) {
          if (!con.isClosed() && con.getLeakedException() != null) {
            logger.log(Level.WARNING, "Leaked connection", con.getLeakedException());
          }
        }
      }
    }
  }

  /**
   * Closes Spanner objects that are no longer in use by connections, and where the last connection
   * that used it was closed more than <code>closeSpannerAfterMillisecondsUnused</code> seconds ago.
   * The delay ensures that Spanner objects are not closed unless there's a good reason for it.
   *
   * @param closeSpannerAfterMillisecondsUnused The number of milliseconds a {@link Spanner} object
   *     should not have been used for a {@link Connection} before it is closed by this method.
   */
  @VisibleForTesting
  void closeUnusedSpanners(long closeSpannerAfterMillisecondsUnused) {
    closeUnusedSpanners(closeSpannerAfterMillisecondsUnused, DEFAULT_CLOSE_FUNCTION);
  }

  void closeUnusedSpanners(
      long closeSpannerAfterMillisecondsUnused, Function<Spanner, Void> closeSpannerFunction) {
    List<SpannerPoolKey> keysToBeRemoved = new ArrayList<>();
    synchronized (this) {
      for (Entry<SpannerPoolKey, Long> entry : lastConnectionClosedAt.entrySet()) {
        Long closedAt = entry.getValue();
        // Check whether the last connection was closed more than
        // closeSpannerAfterMillisecondsUnused milliseconds ago.
        if (closedAt != null
            && ((TimeUnit.MILLISECONDS.convert(ticker.read(), TimeUnit.NANOSECONDS) - closedAt))
                > closeSpannerAfterMillisecondsUnused) {
          Spanner spanner = spanners.get(entry.getKey());
          if (spanner != null) {
            try {
              closeSpannerFunction.apply(spanner);
            } catch (Throwable t) {
              // Ignore any errors and continue with the next one in the pool.
            } finally {
              // Even if the close operation failed, we should remove the spanner object as it is no
              // longer valid.
              spanners.remove(entry.getKey());
              keysToBeRemoved.add(entry.getKey());
            }
          }
        }
      }
      for (SpannerPoolKey key : keysToBeRemoved) {
        lastConnectionClosedAt.remove(key);
      }
    }
  }
}
