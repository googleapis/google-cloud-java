/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage;

import static com.google.api.gax.util.TimeConversionUtils.toJavaTimeDuration;
import static com.google.api.gax.util.TimeConversionUtils.toThreetenDuration;
import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;

import com.google.api.core.ApiClock;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcInterceptorProvider;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.BasicResultRetryAlgorithm;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.AbortedException;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.NoHeaderProvider;
import com.google.api.gax.rpc.OutOfRangeException;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.internal.QuotaProjectIdHidingCredentials;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.pathtemplate.PathTemplate;
import com.google.auth.Credentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceFactory;
import com.google.cloud.ServiceOptions;
import com.google.cloud.ServiceRpc;
import com.google.cloud.TransportOptions;
import com.google.cloud.Tuple;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.spi.ServiceRpcFactory;
import com.google.cloud.storage.GrpcUtils.ZeroCopyBidiStreamingCallable;
import com.google.cloud.storage.Hasher.UncheckedChecksumMismatchException;
import com.google.cloud.storage.OpenTelemetryBootstrappingUtils.ChannelConfigurator;
import com.google.cloud.storage.RetryContext.RetryContextProvider;
import com.google.cloud.storage.Retrying.DefaultRetrier;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.cloud.storage.UnifiedOpts.UserProject;
import com.google.cloud.storage.spi.StorageRpcFactory;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnsafeByteOperations;
import com.google.storage.v2.BidiReadObjectRequest;
import com.google.storage.v2.BidiReadObjectResponse;
import com.google.storage.v2.ReadObjectRequest;
import com.google.storage.v2.ReadObjectResponse;
import com.google.storage.v2.StorageClient;
import com.google.storage.v2.StorageSettings;
import com.google.storage.v2.stub.GrpcStorageCallableFactory;
import com.google.storage.v2.stub.GrpcStorageStub;
import com.google.storage.v2.stub.StorageStub;
import com.google.storage.v2.stub.StorageStubSettings;
import io.grpc.ClientInterceptor;
import io.grpc.Detachable;
import io.grpc.HasByteBuffer;
import io.grpc.KnownLength;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.ProtoUtils;
import io.opentelemetry.api.OpenTelemetry;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.URI;
import java.nio.ByteBuffer;
import java.time.Clock;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * @since 2.14.0
 */
@TransportCompatibility(Transport.GRPC)
public final class GrpcStorageOptions extends StorageOptions
    implements Retrying.RetryingDependencies {

  private static final long serialVersionUID = -4499446543857945349L;
  private static final String GCS_SCOPE = "https://www.googleapis.com/auth/devstorage.full_control";
  private static final Set<String> SCOPES = ImmutableSet.of(GCS_SCOPE);
  private static final String DEFAULT_HOST = "https://storage.googleapis.com";
  // If true, disable the bound-token-by-default feature for DirectPath.
  private static final boolean DIRECT_PATH_BOUND_TOKEN_DISABLED =
      Boolean.parseBoolean(
          System.getProperty("com.google.cloud.storage.grpc.bound_token", "false"));

  private final GrpcRetryAlgorithmManager retryAlgorithmManager;
  private final java.time.Duration terminationAwaitDuration;
  private final boolean attemptDirectPath;
  private final boolean enableGrpcClientMetrics;

  private final boolean grpcClientMetricsManuallyEnabled;
  private final GrpcInterceptorProvider grpcInterceptorProvider;
  private final BlobWriteSessionConfig blobWriteSessionConfig;
  private transient OpenTelemetry openTelemetry;

  private GrpcStorageOptions(Builder builder, GrpcStorageDefaults serviceDefaults) {
    super(builder, serviceDefaults);
    this.retryAlgorithmManager =
        new GrpcRetryAlgorithmManager(
            MoreObjects.firstNonNull(
                builder.storageRetryStrategy, serviceDefaults.getStorageRetryStrategy()));
    this.terminationAwaitDuration =
        MoreObjects.firstNonNull(
            builder.terminationAwaitDuration,
            serviceDefaults.getTerminationAwaitDurationJavaTime());
    this.attemptDirectPath = builder.attemptDirectPath;
    this.enableGrpcClientMetrics = builder.enableGrpcClientMetrics;
    this.grpcClientMetricsManuallyEnabled = builder.grpcMetricsManuallyEnabled;
    this.grpcInterceptorProvider = builder.grpcInterceptorProvider;
    this.blobWriteSessionConfig = builder.blobWriteSessionConfig;
    this.openTelemetry = builder.openTelemetry;
  }

  @Override
  protected Set<String> getScopes() {
    return SCOPES;
  }

  @InternalApi
  GrpcRetryAlgorithmManager getRetryAlgorithmManager() {
    return retryAlgorithmManager;
  }

  @InternalApi
  java.time.Duration getTerminationAwaitDuration() {
    return terminationAwaitDuration;
  }

  @InternalApi
  StorageSettings getStorageSettings() throws IOException {
    return resolveSettingsAndOpts().x();
  }

  @InternalApi
  GrpcInterceptorProvider getGrpcInterceptorProvider() {
    return grpcInterceptorProvider;
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.openTelemetry = HttpStorageOptions.getDefaultInstance().getOpenTelemetry();
  }

  /**
   * We have to perform several introspections and detections to cross-wire/support several features
   * that are either gapic primitives, ServiceOption primitives or GCS semantic requirements.
   *
   * <h2>Requester Pays, {@code quota_project_id} and {@code userProject}</h2>
   *
   * When using the JSON Api operations destined for requester pays buckets can identify the project
   * for billing and quota attribution by specifying either {@code userProject} query parameter or
   * {@code x-goog-user-project} HTTP Header.
   *
   * <p>If the credentials being used contain the property {@code quota_project_id} this value will
   * automatically be set to the {@code x-goog-user-project} header for both JSON and GAPIC. In the
   * case of JSON this isn't an issue, as any {@code userProject} query parameter takes precedence.
   * However, in gRPC/GAPIC there isn't a {@code userProject} query parameter, instead we are adding
   * {@code x-goog-user-project} to the request context as metadata. If the credentials set the
   * request metadata and we set the request metadata it results in two different entries in the
   * request. This creates ambiguity for GCS which then rejects the request.
   *
   * <p>To account for this and to provide a similar level of precedence we are introspecting the
   * credentials and service options to save any {@code quota_project_id} into an {@link
   * UserProject} which is then used by {@link GrpcStorageImpl} to resolve individual request
   * metadata.
   *
   * <h3>The precedence we provide is as follows</h3>
   *
   * <ol>
   *   <li>Any "userProject" Option provided to an individual method
   *   <li>Any Non-empty value for {@link #getQuotaProjectId()}
   *   <li>Any {@code x-goog-user-project} provided by {@link #credentials}
   * </ol>
   */
  private Tuple<StorageSettings, Opts<UserProject>> resolveSettingsAndOpts() throws IOException {
    String endpoint = getHost();
    URI uri = URI.create(endpoint);
    String scheme = uri.getScheme();
    int port = uri.getPort();
    // Gax routes the endpoint into a method which can't handle schemes,
    // unless for Direct Google Access try and strip here if we can
    switch (scheme) {
      case "http":
        endpoint = String.format(Locale.US, "%s:%s", uri.getHost(), port > 0 ? port : 80);
        break;
      case "https":
        endpoint = String.format(Locale.US, "%s:%s", uri.getHost(), port > 0 ? port : 443);
        break;
    }

    Opts<UserProject> defaultOpts = Opts.empty();
    CredentialsProvider credentialsProvider;
    Preconditions.checkState(credentials != null, "Unable to resolve credentials");
    if (credentials instanceof NoCredentials) {
      credentialsProvider = NoCredentialsProvider.create();
    } else {
      boolean foundQuotaProject = false;
      if (credentials.hasRequestMetadata()) {
        try {
          Map<String, List<String>> requestMetadata = credentials.getRequestMetadata(uri);
          for (Entry<String, List<String>> e : requestMetadata.entrySet()) {
            String key = e.getKey();
            if ("x-goog-user-project".equals(Utils.headerNameToLowerCase(key.trim()))) {
              List<String> value = e.getValue();
              if (!value.isEmpty()) {
                foundQuotaProject = true;
                defaultOpts = Opts.from(UnifiedOpts.userProject(value.get(0)));
                break;
              }
            }
          }
        } catch (IllegalStateException e) {
          // This happens when an instance of OAuth2Credentials attempts to refresh its
          // access token during our attempt at getting request metadata.
          // This is most easily reproduced by OAuth2Credentials.create(null);
          // see com.google.auth.oauth2.OAuth2Credentials.refreshAccessToken
          if (!e.getMessage().startsWith("OAuth2Credentials")) {
            throw e;
          }
        }
      }
      if (foundQuotaProject) {
        // fix for https://github.com/googleapis/java-storage/issues/1736
        credentialsProvider =
            FixedCredentialsProvider.create(new QuotaProjectIdHidingCredentials(credentials));
      } else {
        credentialsProvider = FixedCredentialsProvider.create(credentials);
      }
    }

    boolean isTm =
        Arrays.stream(Thread.currentThread().getStackTrace())
            .anyMatch(
                ste -> ste.getClassName().startsWith("com.google.cloud.storage.transfermanager"));

    HeaderProvider internalHeaderProvider =
        StorageSettings.defaultApiClientHeaderProviderBuilder()
            .setClientLibToken(ServiceOptions.getGoogApiClientLibName(), getLibraryVersion())
            .build();
    if (isTm) {
      internalHeaderProvider =
          XGoogApiClientHeaderProvider.of(
              internalHeaderProvider, ImmutableList.of("gccl-gcs-cmd/tm"));
    }

    StorageSettings.Builder builder =
        new GapicStorageSettingsBuilder(StorageSettings.newBuilder().build())
            .setInternalHeaderProvider(internalHeaderProvider)
            .setEndpoint(endpoint)
            .setCredentialsProvider(credentialsProvider)
            .setClock(getClock());

    if (this.getUniverseDomain() != null) {
      builder.setUniverseDomain(this.getUniverseDomain());
    }

    // this MUST come after credentials, service options set value has higher priority than creds
    String quotaProjectId = this.getQuotaProjectId();
    if (quotaProjectId != null && !quotaProjectId.isEmpty()) {
      defaultOpts = Opts.from(UnifiedOpts.userProject(quotaProjectId));
    }

    builder.setHeaderProvider(this.getMergedHeaderProvider(new NoHeaderProvider()));

    InstantiatingGrpcChannelProvider.Builder channelProviderBuilder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setEndpoint(endpoint)
            .setAllowNonDefaultServiceAccount(true)
            .setAttemptDirectPath(attemptDirectPath);

    if (!DIRECT_PATH_BOUND_TOKEN_DISABLED) {
      channelProviderBuilder.setAllowHardBoundTokenTypes(
          Collections.singletonList(InstantiatingGrpcChannelProvider.HardBoundTokenTypes.ALTS));
    }

    if (!NoopGrpcInterceptorProvider.INSTANCE.equals(grpcInterceptorProvider)) {
      channelProviderBuilder.setInterceptorProvider(grpcInterceptorProvider);
    }

    if (attemptDirectPath) {
      channelProviderBuilder.setAttemptDirectPathXds();
    }

    if (scheme.equals("http")) {
      channelProviderBuilder.setChannelConfigurator(ManagedChannelBuilder::usePlaintext);
    }

    if (enableGrpcClientMetrics) {
      ChannelConfigurator channelConfigurator =
          OpenTelemetryBootstrappingUtils.enableGrpcMetrics(
              ChannelConfigurator.lift(channelProviderBuilder.getChannelConfigurator()),
              endpoint,
              this.getProjectId(),
              this.getUniverseDomain(),
              !grpcClientMetricsManuallyEnabled);
      channelProviderBuilder.setChannelConfigurator(channelConfigurator);
    }

    builder.setTransportChannelProvider(channelProviderBuilder.build());
    RetrySettings baseRetrySettings = getRetrySettings();
    RetrySettings readRetrySettings =
        baseRetrySettings.toBuilder()
            // when performing a read via ReadObject, the ServerStream will have a default relative
            // deadline set of `requestStartTime() + totalTimeout`, meaning if the specified
            // RetrySettings have a totalTimeout of 10 seconds -- which should be plenty for
            // metadata RPCs -- the entire ReadObject stream would need to complete within 10
            // seconds.
            // To allow read streams to have longer lifespans, crank up their timeouts, instead rely
            // on idleTimeout below.
            .setLogicalTimeout(java.time.Duration.ofDays(28))
            .build();
    java.time.Duration totalTimeout = baseRetrySettings.getTotalTimeoutDuration();

    // retries for unary methods are generally handled at a different level, except
    // StartResumableWrite
    builder.applyToAllUnaryMethods(
        input -> {
          input.setSimpleTimeoutNoRetriesDuration(totalTimeout);
          return null;
        });

    // configure the settings for StartResumableWrite
    Duration startResumableTimeoutDuration;
    // the default for initialRpcTimeout is the same as totalTimeout. This is not good, because it
    // will prevent our retries from even happening.
    // If the default values is used, set our per-rpc timeout to 20 seconds to allow our retries
    // a chance.
    if (baseRetrySettings
        .getInitialRpcTimeoutDuration()
        .equals(getDefaultRetrySettings().getInitialRpcTimeoutDuration())) {
      startResumableTimeoutDuration = Duration.ofSeconds(20);
    } else {
      startResumableTimeoutDuration = baseRetrySettings.getInitialRpcTimeoutDuration();
    }
    builder
        .startResumableWriteSettings()
        // set this lower, to allow our retries a chance instead of it being totalTimeout
        .setSimpleTimeoutNoRetriesDuration(startResumableTimeoutDuration);
    // for ReadObject disable retries and move the total timeout to the idle timeout
    builder
        .readObjectSettings()
        .setRetrySettings(readRetrySettings)
        // disable gapic retries because we're handling it ourselves
        .setRetryableCodes(Collections.emptySet())
        // for reads, the stream can be held open for a long time in order to read all bytes,
        // this is totally valid. instead we want to monitor if the stream is doing work and if not
        // timeout.
        .setIdleTimeoutDuration(totalTimeout);
    return Tuple.of(builder.build(), defaultOpts);
  }

  /**
   * @since 2.47.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  @Override
  public OpenTelemetry getOpenTelemetry() {
    return openTelemetry;
  }

  /**
   * @since 2.14.0
   */
  @Override
  public GrpcStorageOptions.Builder toBuilder() {
    return new GrpcStorageOptions.Builder(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        retryAlgorithmManager,
        terminationAwaitDuration,
        attemptDirectPath,
        enableGrpcClientMetrics,
        grpcInterceptorProvider,
        blobWriteSessionConfig,
        openTelemetry,
        baseHashCode());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof GrpcStorageOptions)) {
      return false;
    }
    GrpcStorageOptions that = (GrpcStorageOptions) o;
    return attemptDirectPath == that.attemptDirectPath
        && enableGrpcClientMetrics == that.enableGrpcClientMetrics
        && Objects.equals(retryAlgorithmManager, that.retryAlgorithmManager)
        && Objects.equals(terminationAwaitDuration, that.terminationAwaitDuration)
        && Objects.equals(grpcInterceptorProvider, that.grpcInterceptorProvider)
        && Objects.equals(blobWriteSessionConfig, that.blobWriteSessionConfig)
        && Objects.equals(openTelemetry, that.openTelemetry)
        && this.baseEquals(that);
  }

  /**
   * @since 2.14.0
   */
  public static GrpcStorageOptions.Builder newBuilder() {
    return new GrpcStorageOptions.Builder().setHost(DEFAULT_HOST);
  }

  /**
   * @since 2.14.0
   */
  public static GrpcStorageOptions getDefaultInstance() {
    return newBuilder().build();
  }

  /**
   * @since 2.14.0
   */
  public static GrpcStorageOptions.GrpcStorageDefaults defaults() {
    return GrpcStorageOptions.GrpcStorageDefaults.INSTANCE;
  }

  // since our new GrpcStorageImpl can "close" we need to help ServiceOptions know whether it can
  // use it's cached instance.
  @Override
  protected boolean shouldRefreshService(Storage cachedService) {
    if (cachedService instanceof GrpcStorageImpl) {
      GrpcStorageImpl service = (GrpcStorageImpl) cachedService;
      return service.isClosed();
    }
    return super.shouldRefreshService(cachedService);
  }

  /**
   * @since 2.14.0
   */
  public static final class Builder extends StorageOptions.Builder {

    private StorageRetryStrategy storageRetryStrategy;
    private java.time.Duration terminationAwaitDuration;
    private boolean attemptDirectPath = GrpcStorageDefaults.INSTANCE.isAttemptDirectPath();
    private boolean enableGrpcClientMetrics =
        GrpcStorageDefaults.INSTANCE.isEnableGrpcClientMetrics();
    private GrpcInterceptorProvider grpcInterceptorProvider =
        GrpcStorageDefaults.INSTANCE.grpcInterceptorProvider();
    private BlobWriteSessionConfig blobWriteSessionConfig =
        GrpcStorageDefaults.INSTANCE.getDefaultStorageWriterConfig();
    private OpenTelemetry openTelemetry = GrpcStorageDefaults.INSTANCE.getDefaultOpenTelemetry();

    private boolean grpcMetricsManuallyEnabled = false;

    Builder() {}

    Builder(StorageOptions options) {
      super(options);
      GrpcStorageOptions gso = (GrpcStorageOptions) options;
      this.storageRetryStrategy = gso.getRetryAlgorithmManager().retryStrategy;
      this.terminationAwaitDuration = gso.getTerminationAwaitDuration();
      this.attemptDirectPath = gso.attemptDirectPath;
      this.enableGrpcClientMetrics = gso.enableGrpcClientMetrics;
      this.grpcInterceptorProvider = gso.grpcInterceptorProvider;
      this.blobWriteSessionConfig = gso.blobWriteSessionConfig;
      this.openTelemetry = gso.openTelemetry;
    }

    /**
     * This method is obsolete. Use {@link #setTerminationAwaitJavaTimeDuration(java.time.Duration)}
     * instead.
     */
    @ObsoleteApi("Use setTerminationAwaitJavaTimeDuration(java.time.Duration) instead")
    public Builder setTerminationAwaitDuration(org.threeten.bp.Duration terminationAwaitDuration) {
      return setTerminationAwaitJavaTimeDuration(toJavaTimeDuration(terminationAwaitDuration));
    }

    /**
     * Set the maximum duration in which to await termination of any outstanding requests when
     * calling {@link Storage#close()}
     *
     * @param terminationAwaitDuration a non-null Duration to use
     * @return the builder
     * @since 2.14.0
     */
    public Builder setTerminationAwaitJavaTimeDuration(
        java.time.Duration terminationAwaitDuration) {
      this.terminationAwaitDuration =
          requireNonNull(terminationAwaitDuration, "terminationAwaitDuration must be non null");
      return this;
    }

    /**
     * Option which signifies the client should attempt to connect to gcs via Direct Google Access.
     *
     * <p><i>NOTE</i>There is no need to specify a new endpoint via {@link #setHost(String)} as the
     * underlying code will translate the normal {@code https://storage.googleapis.com:443} into the
     * proper Direct Google Access URI for you.
     *
     * @since 2.14.0
     */
    public GrpcStorageOptions.Builder setAttemptDirectPath(boolean attemptDirectPath) {
      this.attemptDirectPath = attemptDirectPath;
      return this;
    }

    /**
     * Option for whether this client should emit internal gRPC client internal metrics to Cloud
     * Monitoring. To disable metric reporting, set this to false. True by default. Emitting metrics
     * is free and requires minimal CPU and memory.
     *
     * @since 2.41.0
     */
    public GrpcStorageOptions.Builder setEnableGrpcClientMetrics(boolean enableGrpcClientMetrics) {
      this.enableGrpcClientMetrics = enableGrpcClientMetrics;
      if (enableGrpcClientMetrics) {
        grpcMetricsManuallyEnabled = true;
      }
      return this;
    }

    /**
     * @since 2.14.0
     */
    @Override
    public GrpcStorageOptions.Builder setTransportOptions(TransportOptions transportOptions) {
      if (!(transportOptions instanceof GrpcTransportOptions)) {
        throw new IllegalArgumentException("Only gRPC transport is allowed.");
      }
      super.setTransportOptions(transportOptions);
      return this;
    }

    /**
     * Override the default retry handling behavior with an alternate strategy.
     *
     * @param storageRetryStrategy a non-null storageRetryStrategy to use
     * @return the builder
     * @see StorageRetryStrategy#getDefaultStorageRetryStrategy()
     * @since 2.14.0
     */
    public GrpcStorageOptions.Builder setStorageRetryStrategy(
        StorageRetryStrategy storageRetryStrategy) {
      this.storageRetryStrategy =
          requireNonNull(storageRetryStrategy, "storageRetryStrategy must be non null");
      return this;
    }

    @Override
    protected GrpcStorageOptions.Builder self() {
      return this;
    }

    /**
     * @since 2.14.0
     */
    @Override
    public GrpcStorageOptions.Builder setServiceFactory(
        ServiceFactory<Storage, StorageOptions> serviceFactory) {
      super.setServiceFactory(serviceFactory);
      return this;
    }

    /**
     * @since 2.14.0
     */
    @Override
    public GrpcStorageOptions.Builder setClock(ApiClock clock) {
      super.setClock(clock);
      return this;
    }

    /**
     * @since 2.14.0
     */
    @Override
    public GrpcStorageOptions.Builder setProjectId(String projectId) {
      super.setProjectId(projectId);
      return this;
    }

    /**
     * @since 2.14.0
     */
    @Override
    public GrpcStorageOptions.Builder setHost(String host) {
      super.setHost(host);
      return this;
    }

    /**
     * @since 2.14.0
     */
    @Override
    public GrpcStorageOptions.Builder setCredentials(Credentials credentials) {
      super.setCredentials(credentials);
      return this;
    }

    /**
     * @since 2.14.0
     */
    @Override
    public GrpcStorageOptions.Builder setRetrySettings(RetrySettings retrySettings) {
      super.setRetrySettings(retrySettings);
      return this;
    }

    /**
     * @since 2.14.0
     */
    @Override
    public GrpcStorageOptions.Builder setServiceRpcFactory(
        ServiceRpcFactory<StorageOptions> serviceRpcFactory) {
      throw new UnsupportedOperationException(
          "GrpcStorageOptions does not support setting a custom instance of ServiceRpcFactory");
    }

    /**
     * @since 2.14.0
     */
    @Override
    public GrpcStorageOptions.Builder setHeaderProvider(HeaderProvider headerProvider) {
      super.setHeaderProvider(headerProvider);
      return this;
    }

    /**
     * @since 2.14.0
     */
    @Override
    public GrpcStorageOptions.Builder setClientLibToken(String clientLibToken) {
      super.setClientLibToken(clientLibToken);
      return this;
    }

    /**
     * @since 2.14.0
     */
    @Override
    public GrpcStorageOptions.Builder setQuotaProjectId(String quotaProjectId) {
      super.setQuotaProjectId(quotaProjectId);
      return this;
    }

    /**
     * @since 2.22.3
     */
    public GrpcStorageOptions.Builder setGrpcInterceptorProvider(
        @NonNull GrpcInterceptorProvider grpcInterceptorProvider) {
      requireNonNull(grpcInterceptorProvider, "grpcInterceptorProvider must be non null");
      this.grpcInterceptorProvider = grpcInterceptorProvider;
      return this;
    }

    /**
     * @see BlobWriteSessionConfig
     * @see BlobWriteSessionConfigs
     * @see Storage#blobWriteSession(BlobInfo, BlobWriteOption...)
     * @see GrpcStorageDefaults#getDefaultStorageWriterConfig()
     * @since 2.26.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public GrpcStorageOptions.Builder setBlobWriteSessionConfig(
        @NonNull BlobWriteSessionConfig blobWriteSessionConfig) {
      requireNonNull(blobWriteSessionConfig, "blobWriteSessionConfig must be non null");
      checkArgument(
          blobWriteSessionConfig instanceof BlobWriteSessionConfig.GrpcCompatible,
          "The provided instance of BlobWriteSessionConfig is not compatible with gRPC transport.");
      this.blobWriteSessionConfig = blobWriteSessionConfig;
      return this;
    }

    @BetaApi
    @Override
    public GrpcStorageOptions.Builder setUniverseDomain(String universeDomain) {
      super.setUniverseDomain(universeDomain);
      return this;
    }

    @BetaApi
    @Override
    public GrpcStorageOptions.Builder setApiTracerFactory(ApiTracerFactory apiTracerFactory) {
      super.setApiTracerFactory(apiTracerFactory);
      return this;
    }

    /**
     * Enable OpenTelemetry Tracing and provide an instance for the client to use.
     *
     * @param openTelemetry User defined instance of OpenTelemetry to be used by the library
     * @since 2.47.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public GrpcStorageOptions.Builder setOpenTelemetry(OpenTelemetry openTelemetry) {
      requireNonNull(openTelemetry, "openTelemetry must be non null");
      this.openTelemetry = openTelemetry;
      return this;
    }

    /**
     * @since 2.14.0
     */
    @Override
    public GrpcStorageOptions build() {
      GrpcStorageOptions options = new GrpcStorageOptions(this, defaults());
      // TODO: Remove when https://github.com/googleapis/sdk-platform-java/issues/2911 is resolved
      if (options.getUniverseDomain() != null) {
        this.setHost("https://storage." + options.getUniverseDomain());
        return new GrpcStorageOptions(this, defaults());
      }
      return options;
    }
  }

  /**
   * @since 2.14.0
   */
  public static final class GrpcStorageDefaults extends StorageDefaults {
    static final GrpcStorageDefaults INSTANCE = new GrpcStorageOptions.GrpcStorageDefaults();
    static final StorageFactory STORAGE_FACTORY = new GrpcStorageFactory();
    static final StorageRpcFactory STORAGE_RPC_FACTORY = new GrpcStorageRpcFactory();
    static final GrpcInterceptorProvider INTERCEPTOR_PROVIDER =
        NoopGrpcInterceptorProvider.INSTANCE;

    private GrpcStorageDefaults() {}

    /**
     * @since 2.14.0
     */
    @Override
    public StorageFactory getDefaultServiceFactory() {
      return STORAGE_FACTORY;
    }

    /**
     * @since 2.14.0
     */
    @Override
    public StorageRpcFactory getDefaultRpcFactory() {
      return STORAGE_RPC_FACTORY;
    }

    /**
     * @since 2.14.0
     */
    @Override
    public GrpcTransportOptions getDefaultTransportOptions() {
      return GrpcTransportOptions.newBuilder().build();
    }

    /**
     * @since 2.14.0
     */
    public StorageRetryStrategy getStorageRetryStrategy() {
      return StorageRetryStrategy.getDefaultStorageRetryStrategy();
    }

    /** This method is obsolete. Use {@link #getTerminationAwaitDurationJavaTime()} instead. */
    @ObsoleteApi("Use getTerminationAwaitDurationJavaTime() instead")
    public org.threeten.bp.Duration getTerminationAwaitDuration() {
      return toThreetenDuration(getTerminationAwaitDurationJavaTime());
    }

    /**
     * @since 2.14.0
     */
    public java.time.Duration getTerminationAwaitDurationJavaTime() {
      return java.time.Duration.ofMinutes(1);
    }

    /**
     * @since 2.14.0
     */
    public boolean isAttemptDirectPath() {
      return true;
    }

    /**
     * @since 2.41.0
     */
    public boolean isEnableGrpcClientMetrics() {
      return true;
    }

    /**
     * @since 2.22.3
     */
    public GrpcInterceptorProvider grpcInterceptorProvider() {
      return INTERCEPTOR_PROVIDER;
    }

    /**
     * @since 2.26.0 This new api is in preview and is subject to breaking changes.
     */
    public BlobWriteSessionConfig getDefaultStorageWriterConfig() {
      return BlobWriteSessionConfigs.getDefault();
    }

    /**
     * @since 2.47.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public OpenTelemetry getDefaultOpenTelemetry() {
      return OpenTelemetry.noop();
    }
  }

  /**
   * Internal implementation detail, only public to allow for {@link java.io.Serializable}
   * compatibility in {@link com.google.cloud.ServiceOptions}.
   *
   * <p>To access an instance of this class instead use {@link
   * GrpcStorageOptions.GrpcStorageDefaults#getDefaultServiceFactory()
   * GrpcStorageOptions.defaults().getDefaultServiceFactory()}.
   *
   * @see GrpcStorageOptions#defaults()
   * @see GrpcStorageOptions.GrpcStorageDefaults#getDefaultServiceFactory()
   * @since 2.14.0
   */
  @InternalApi
  public static class GrpcStorageFactory implements StorageFactory {
    private static final Logger LOGGER = Logger.getLogger(GrpcStorageFactory.class.getName());

    /**
     * Internal implementation detail, only public to allow for {@link java.io.Serializable}
     * compatibility in {@link com.google.cloud.ServiceOptions}.
     *
     * <p>To access an instance of this class instead use {@link
     * GrpcStorageOptions.GrpcStorageDefaults#getDefaultServiceFactory()
     * GrpcStorageOptions.defaults().getDefaultServiceFactory()}.
     *
     * @see GrpcStorageOptions#defaults()
     * @see GrpcStorageOptions.GrpcStorageDefaults#getDefaultServiceFactory()
     * @deprecated instead use {@link
     *     GrpcStorageOptions.GrpcStorageDefaults#getDefaultServiceFactory()
     *     GrpcStorageOptions.defaults().getDefaultServiceFactory()}
     * @since 2.14.0
     */
    // this class needs to be public due to ServiceOptions forName'ing it in it's readObject method
    @InternalApi
    @Deprecated
    @SuppressWarnings("DeprecatedIsStillUsed")
    public GrpcStorageFactory() {}

    @Override
    public Storage create(StorageOptions options) {
      if (options instanceof GrpcStorageOptions) {
        GrpcStorageOptions grpcStorageOptions = (GrpcStorageOptions) options;
        try {
          Tuple<StorageSettings, Opts<UserProject>> t = grpcStorageOptions.resolveSettingsAndOpts();
          StorageSettings storageSettings = t.x();
          Opts<UserProject> defaultOpts = t.y();

          ScheduledExecutorService executor =
              storageSettings.getBackgroundExecutorProvider().getExecutor();
          RetryContextProvider retryContextProvider =
              RetryContext.providerFrom(
                  executor,
                  grpcStorageOptions,
                  new ReadObjectRangeResultRetryAlgorithmDecorator(
                      grpcStorageOptions.getRetryAlgorithmManager().idempotent()));

          OpenTelemetry otel = options.getOpenTelemetry();
          DefaultRetrier retrier =
              new DefaultRetrier(
                  OtelStorageDecorator.retryContextDecorator(otel), grpcStorageOptions);
          if (ZeroCopyReadinessChecker.isReady()) {
            LOGGER.config("zero-copy protobuf deserialization available, using it");
            StorageStubSettings baseSettings =
                (StorageStubSettings) storageSettings.getStubSettings();
            InternalStorageStubSettings.Builder internalStorageStubSettingsBuilder =
                new InternalStorageStubSettings.Builder(baseSettings);
            InternalStorageSettings.Builder settingsBuilder =
                new InternalStorageSettings.Builder(internalStorageStubSettingsBuilder);
            InternalStorageSettings internalStorageSettingsBuilder =
                new InternalStorageSettings(settingsBuilder);
            InternalStorageClient client =
                new InternalStorageClient(internalStorageSettingsBuilder);
            InternalZeroCopyGrpcStorageStub stub = client.getStub();
            StorageDataClient dataClient =
                StorageDataClient.create(
                    executor,
                    grpcStorageOptions.terminationAwaitDuration,
                    new ZeroCopyBidiStreamingCallable<>(
                        stub.bidiReadObjectCallable(), stub.bidiReadObjectResponseMarshaller),
                    retryContextProvider,
                    IOAutoCloseable.noOp());
            GrpcStorageImpl grpcStorage =
                new GrpcStorageImpl(
                    grpcStorageOptions,
                    client,
                    dataClient,
                    stub.readObjectResponseMarshaller,
                    grpcStorageOptions.blobWriteSessionConfig.createFactory(Clock.systemUTC()),
                    retrier,
                    defaultOpts);
            return OtelStorageDecorator.decorate(grpcStorage, otel, Transport.GRPC);
          } else {
            LOGGER.config(
                "zero-copy protobuf deserialization unavailable, proceeding with default");
            StorageClient client = StorageClient.create(storageSettings);
            StorageDataClient dataClient =
                StorageDataClient.create(
                    executor,
                    grpcStorageOptions.terminationAwaitDuration,
                    new ZeroCopyBidiStreamingCallable<>(
                        client.bidiReadObjectCallable(),
                        ResponseContentLifecycleManager.noopBidiReadObjectResponse()),
                    retryContextProvider,
                    IOAutoCloseable.noOp());
            GrpcStorageImpl grpcStorage =
                new GrpcStorageImpl(
                    grpcStorageOptions,
                    client,
                    dataClient,
                    ResponseContentLifecycleManager.noop(),
                    grpcStorageOptions.blobWriteSessionConfig.createFactory(Clock.systemUTC()),
                    retrier,
                    defaultOpts);
            return OtelStorageDecorator.decorate(grpcStorage, otel, Transport.GRPC);
          }
        } catch (IOException e) {
          throw new IllegalStateException(
              "Unable to instantiate gRPC com.google.cloud.storage.Storage client.", e);
        }
      } else {
        throw new IllegalArgumentException("Only GrpcStorageOptions supported");
      }
    }
  }

  /**
   * Internal implementation detail, only public to allow for {@link java.io.Serializable}
   * compatibility in {@link com.google.cloud.ServiceOptions}.
   *
   * <p>To access an instance of this class instead use {@link
   * GrpcStorageOptions.GrpcStorageDefaults#getDefaultRpcFactory()
   * GrpcStorageOptions.defaults().getDefaultRpcFactory()}.
   *
   * @see GrpcStorageOptions#defaults()
   * @see GrpcStorageOptions.GrpcStorageDefaults#getDefaultRpcFactory()
   * @since 2.14.0
   */
  @InternalApi
  @Deprecated
  public static class GrpcStorageRpcFactory implements StorageRpcFactory {

    /**
     * Internal implementation detail, only public to allow for {@link java.io.Serializable}
     * compatibility in {@link com.google.cloud.ServiceOptions}.
     *
     * <p>To access an instance of this class instead use {@link
     * GrpcStorageOptions.GrpcStorageDefaults#getDefaultRpcFactory()
     * GrpcStorageOptions.defaults().getDefaultRpcFactory()}.
     *
     * @see GrpcStorageOptions#defaults()
     * @see GrpcStorageOptions.GrpcStorageDefaults#getDefaultRpcFactory()
     * @deprecated instead use {@link GrpcStorageOptions.GrpcStorageDefaults#getDefaultRpcFactory()
     *     GrpcStorageOptions.defaults().getDefaultRpcFactory()}
     * @since 2.14.0
     */
    // this class needs to be public due to ServiceOptions forName'ing it in it's readObject method
    @InternalApi
    @Deprecated
    @SuppressWarnings("DeprecatedIsStillUsed")
    public GrpcStorageRpcFactory() {}

    @Override
    public ServiceRpc create(StorageOptions options) {
      throw new IllegalStateException("No supported for grpc");
    }
  }

  // setInternalHeaderProvider is protected so we need to open its scope in order to set it
  // we are adding an entry for gccl which is set via this provider
  private static final class GapicStorageSettingsBuilder extends StorageSettings.Builder {
    private GapicStorageSettingsBuilder(StorageSettings settings) {
      super(settings);
    }

    @Override
    protected StorageSettings.Builder setInternalHeaderProvider(
        HeaderProvider internalHeaderProvider) {
      return super.setInternalHeaderProvider(internalHeaderProvider);
    }
  }

  private static final class NoopGrpcInterceptorProvider
      implements GrpcInterceptorProvider, Serializable {
    private static long serialVersionUID = -8523033236999805349L;
    private static final NoopGrpcInterceptorProvider INSTANCE = new NoopGrpcInterceptorProvider();

    @Override
    public List<ClientInterceptor> getInterceptors() {
      return ImmutableList.of();
    }

    /** prevent java serialization from using a new instance */
    private Object readResolve() {
      return INSTANCE;
    }
  }

  private static final class InternalStorageClient extends StorageClient {

    private InternalStorageClient(StorageSettings settings) throws IOException {
      super(settings);
    }

    @Override
    public void shutdownNow() {
      try {
        // GrpcStorageStub#close() is final and we can't override it
        // instead hook in here to close out the zero-copy marshaller
        //noinspection EmptyTryBlock
        try (ZeroCopyResponseMarshaller<ReadObjectResponse> ignore1 =
                getStub().readObjectResponseMarshaller;
            ZeroCopyResponseMarshaller<BidiReadObjectResponse> ignore2 =
                getStub().bidiReadObjectResponseMarshaller) {
          // use try-with to do the close dance for us
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      } finally {
        super.shutdownNow();
      }
    }

    @Override
    public InternalZeroCopyGrpcStorageStub getStub() {
      return (InternalZeroCopyGrpcStorageStub) super.getStub();
    }
  }

  private static final class InternalStorageSettings extends StorageSettings {

    private InternalStorageSettings(Builder settingsBuilder) throws IOException {
      super(settingsBuilder);
    }

    private static final class Builder extends StorageSettings.Builder {
      private Builder(StorageStubSettings.Builder stubSettings) {
        super(stubSettings);
      }

      @Override
      public InternalStorageSettings build() throws IOException {
        return new InternalStorageSettings(this);
      }
    }
  }

  private static final class InternalStorageStubSettings extends StorageStubSettings {

    private InternalStorageStubSettings(Builder settingsBuilder) throws IOException {
      super(settingsBuilder);
    }

    @Override
    public StorageStub createStub() throws IOException {
      if (!getTransportChannelProvider()
          .getTransportName()
          .equals(GrpcTransportChannel.getGrpcTransportName())) {
        throw new UnsupportedOperationException(
            String.format(
                "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
      }

      ClientContext clientContext = ClientContext.create(this);
      GrpcStorageCallableFactory grpcStorageCallableFactory = new GrpcStorageCallableFactory();
      InternalZeroCopyGrpcStorageStub stub =
          new InternalZeroCopyGrpcStorageStub(this, clientContext, grpcStorageCallableFactory);
      return stub;
    }

    private static final class Builder extends StorageStubSettings.Builder {

      private Builder(StorageStubSettings settings) {
        super(settings);
      }

      @Override
      public InternalStorageStubSettings build() throws IOException {
        return new InternalStorageStubSettings(this);
      }
    }
  }

  // DanglingJavadocs are for breadcrumbs to source of copied generated code
  @SuppressWarnings("DanglingJavadoc")
  private static final class InternalZeroCopyGrpcStorageStub extends GrpcStorageStub
      implements AutoCloseable {

    private static final RequestParamsExtractor<BidiReadObjectRequest>
        EMPTY_REQUEST_PARAMS_EXTRACTOR = request -> ImmutableMap.of();

    /**
     * @see GrpcStorageStub#READ_OBJECT_0_PATH_TEMPLATE
     */
    private static final PathTemplate READ_OBJECT_0_PATH_TEMPLATE =
        PathTemplate.create("{bucket=**}");

    private final ZeroCopyResponseMarshaller<ReadObjectResponse> readObjectResponseMarshaller;
    private final ZeroCopyResponseMarshaller<BidiReadObjectResponse>
        bidiReadObjectResponseMarshaller;

    private final ServerStreamingCallable<ReadObjectRequest, ReadObjectResponse> readObjectCallable;
    private final BidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse>
        bidiReadObjectCallable;

    private InternalZeroCopyGrpcStorageStub(
        StorageStubSettings settings,
        ClientContext clientContext,
        GrpcStubCallableFactory callableFactory)
        throws IOException {
      super(settings, clientContext, callableFactory);

      this.readObjectResponseMarshaller =
          new ZeroCopyResponseMarshaller<>(ReadObjectResponse.getDefaultInstance());

      this.bidiReadObjectResponseMarshaller =
          new ZeroCopyResponseMarshaller<>(BidiReadObjectResponse.getDefaultInstance());

      /**
       * @see GrpcStorageStub#readObjectMethodDescriptor
       */
      MethodDescriptor<ReadObjectRequest, ReadObjectResponse> readObjectMethodDescriptor =
          MethodDescriptor.<ReadObjectRequest, ReadObjectResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.storage.v2.Storage/ReadObject")
              .setRequestMarshaller(ProtoUtils.marshaller(ReadObjectRequest.getDefaultInstance()))
              .setResponseMarshaller(readObjectResponseMarshaller)
              .build();
      /**
       * @see GrpcStorageStub#bidiReadObjectMethodDescriptor
       */
      MethodDescriptor<BidiReadObjectRequest, BidiReadObjectResponse>
          bidiReadObjectMethodDescriptor =
              MethodDescriptor.<BidiReadObjectRequest, BidiReadObjectResponse>newBuilder()
                  .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
                  .setFullMethodName("google.storage.v2.Storage/BidiReadObject")
                  .setRequestMarshaller(
                      ProtoUtils.marshaller(BidiReadObjectRequest.getDefaultInstance()))
                  .setResponseMarshaller(bidiReadObjectResponseMarshaller)
                  .build();

      GrpcCallSettings<ReadObjectRequest, ReadObjectResponse> readObjectTransportSettings =
          GrpcCallSettings.<ReadObjectRequest, ReadObjectResponse>newBuilder()
              .setMethodDescriptor(readObjectMethodDescriptor)
              .setParamsExtractor(
                  request -> {
                    RequestParamsBuilder builder = RequestParamsBuilder.create();
                    // todo: this is fragile to proto annotation changes
                    builder.add(request.getBucket(), "bucket", READ_OBJECT_0_PATH_TEMPLATE);
                    return builder.build();
                  })
              .build();

      GrpcCallSettings<BidiReadObjectRequest, BidiReadObjectResponse>
          bidiReadObjectTransportSettings =
              GrpcCallSettings.<BidiReadObjectRequest, BidiReadObjectResponse>newBuilder()
                  .setMethodDescriptor(bidiReadObjectMethodDescriptor)
                  .setParamsExtractor(EMPTY_REQUEST_PARAMS_EXTRACTOR)
                  .build();

      this.readObjectCallable =
          callableFactory.createServerStreamingCallable(
              readObjectTransportSettings, settings.readObjectSettings(), clientContext);
      this.bidiReadObjectCallable =
          callableFactory.createBidiStreamingCallable(
              bidiReadObjectTransportSettings, settings.bidiReadObjectSettings(), clientContext);
    }

    @Override
    public ServerStreamingCallable<ReadObjectRequest, ReadObjectResponse> readObjectCallable() {
      return readObjectCallable;
    }

    @Override
    public BidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse>
        bidiReadObjectCallable() {
      return bidiReadObjectCallable;
    }
  }

  @VisibleForTesting
  static class ZeroCopyResponseMarshaller<Response extends Message>
      implements MethodDescriptor.PrototypeMarshaller<Response>,
          ResponseContentLifecycleManager<Response>,
          Closeable {
    private final Map<Response, InputStream> unclosedStreams;
    private final Parser<Response> parser;
    private final MethodDescriptor.PrototypeMarshaller<Response> baseMarshaller;

    ZeroCopyResponseMarshaller(Response defaultInstance) {
      parser = (Parser<Response>) defaultInstance.getParserForType();
      baseMarshaller =
          (MethodDescriptor.PrototypeMarshaller<Response>) ProtoUtils.marshaller(defaultInstance);
      unclosedStreams = Collections.synchronizedMap(new IdentityHashMap<>());
    }

    @Override
    public Class<Response> getMessageClass() {
      return baseMarshaller.getMessageClass();
    }

    @Override
    public Response getMessagePrototype() {
      return baseMarshaller.getMessagePrototype();
    }

    @Override
    public InputStream stream(Response value) {
      return baseMarshaller.stream(value);
    }

    @Override
    public Response parse(InputStream stream) {
      CodedInputStream cis = null;
      try {
        if (stream instanceof KnownLength
            && stream instanceof Detachable
            && stream instanceof HasByteBuffer
            && ((HasByteBuffer) stream).byteBufferSupported()) {
          int size = stream.available();
          // Stream is now detached here and should be closed later.
          stream = ((Detachable) stream).detach();
          // This mark call is to keep buffer while traversing buffers using skip.
          stream.mark(size);
          List<ByteString> byteStrings = new ArrayList<>();
          while (stream.available() != 0) {
            ByteBuffer buffer = ((HasByteBuffer) stream).getByteBuffer();
            byteStrings.add(UnsafeByteOperations.unsafeWrap(buffer));
            stream.skip(buffer.remaining());
          }
          stream.reset();
          cis = ByteString.copyFrom(byteStrings).newCodedInput();
          cis.enableAliasing(true);
          cis.setSizeLimit(Integer.MAX_VALUE);
        }
      } catch (IOException e) {
        throw createStatusRuntimeException(e);
      }
      if (cis != null) {
        // fast path (no memory copy)
        Response message;
        try {
          message = parseFrom(cis);
        } catch (InvalidProtocolBufferException ipbe) {
          throw createStatusRuntimeException(ipbe);
        }
        unclosedStreams.put(message, stream);
        return message;
      } else {
        // slow path
        return baseMarshaller.parse(stream);
      }
    }

    private StatusRuntimeException createStatusRuntimeException(IOException e) {
      String description = "";
      Response messagePrototype = baseMarshaller.getMessagePrototype();
      if (messagePrototype != null) {
        description = "for " + messagePrototype.getClass().getSimpleName();
      }
      return Status.INTERNAL
          .withDescription("Error parsing input stream" + description)
          .withCause(e)
          .asRuntimeException();
    }

    private Response parseFrom(CodedInputStream stream) throws InvalidProtocolBufferException {
      Response message = parser.parseFrom(stream);
      try {
        stream.checkLastTagWas(0);
        return message;
      } catch (InvalidProtocolBufferException e) {
        e.setUnfinishedMessage(message);
        throw e;
      }
    }

    @Override
    public ResponseContentLifecycleHandle<Response> get(Response response) {
      return ResponseContentLifecycleHandle.create(
          response,
          () -> {
            InputStream stream = unclosedStreams.remove(response);
            if (stream != null) {
              stream.close();
            }
          });
    }

    @Override
    public void close() throws IOException {
      GrpcUtils.closeAll(unclosedStreams.values());
    }
  }

  static final class ZeroCopyReadinessChecker {
    private static final boolean isZeroCopyReady;

    static {
      // Check whether io.grpc.Detachable exists?
      boolean detachableClassExists = false;
      try {
        // Try to load Detachable interface in the package where KnownLength is in.
        // This can be done directly by looking up io.grpc.Detachable but rather
        // done indirectly to handle the case where gRPC is being shaded in a
        // different package.
        String knownLengthClassName = KnownLength.class.getName();
        String detachableClassName =
            knownLengthClassName.substring(0, knownLengthClassName.lastIndexOf('.') + 1)
                + "Detachable";
        Class<?> detachableClass = Class.forName(detachableClassName);
        detachableClassExists = (detachableClass != null);
      } catch (ClassNotFoundException ex) {
        // leaves detachableClassExists false
      }
      // Check whether com.google.protobuf.UnsafeByteOperations exists?
      boolean unsafeByteOperationsClassExists = false;
      try {
        // Same above
        String messageLiteClassName = MessageLite.class.getName();
        String unsafeByteOperationsClassName =
            messageLiteClassName.substring(0, messageLiteClassName.lastIndexOf('.') + 1)
                + "UnsafeByteOperations";
        Class<?> unsafeByteOperationsClass = Class.forName(unsafeByteOperationsClassName);
        unsafeByteOperationsClassExists = (unsafeByteOperationsClass != null);
      } catch (ClassNotFoundException ex) {
        // leaves unsafeByteOperationsClassExists false
      }
      isZeroCopyReady = detachableClassExists && unsafeByteOperationsClassExists;
    }

    public static boolean isReady() {
      return isZeroCopyReady;
    }
  }

  private static class ReadObjectRangeResultRetryAlgorithmDecorator
      extends BasicResultRetryAlgorithm<Object> {

    private final ResultRetryAlgorithm<?> delegate;

    private ReadObjectRangeResultRetryAlgorithmDecorator(ResultRetryAlgorithm<?> delegate) {
      this.delegate = delegate;
    }

    @Override
    public boolean shouldRetry(Throwable t, Object previousResponse) {
      // this is only retryable with read object range, not other requests
      return t instanceof UncheckedChecksumMismatchException
          || (t instanceof OutOfRangeException && ((OutOfRangeException) t).isRetryable())
          || (t instanceof AbortedException && ((AbortedException) t).isRetryable())
          || delegate.shouldRetry(StorageException.coalesce(t), null);
    }
  }
}
