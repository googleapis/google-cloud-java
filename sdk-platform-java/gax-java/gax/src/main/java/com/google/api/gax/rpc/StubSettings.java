/*
 * Copyright 2018 Google LLC
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
package com.google.api.gax.rpc;

import static com.google.api.gax.util.TimeConversionUtils.toJavaTimeDuration;
import static com.google.api.gax.util.TimeConversionUtils.toThreetenDuration;

import com.google.api.core.ApiClock;
import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.core.NanoClock;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.FixedExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.BaseApiTracerFactory;
import com.google.auth.oauth2.QuotaProjectIdProvider;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A base settings class to configure a client stub class.
 *
 * <p>This base class includes settings that are applicable to all services, which includes things
 * like settings for creating an executor, credentials, transport-specific settings, and identifiers
 * for http headers.
 *
 * <p>If no ExecutorProvider is set, then InstantiatingExecutorProvider will be used, which creates
 * a default executor.
 */
public abstract class StubSettings<SettingsT extends StubSettings<SettingsT>> {

  static final String QUOTA_PROJECT_ID_HEADER_KEY = "x-goog-user-project";

  private final ExecutorProvider backgroundExecutorProvider;
  private final CredentialsProvider credentialsProvider;
  private final HeaderProvider headerProvider;
  private final HeaderProvider internalHeaderProvider;
  private final TransportChannelProvider transportChannelProvider;
  private final ApiClock clock;
  private final String quotaProjectId;
  @Nullable private final String gdchApiAudience;
  @Nullable private final WatchdogProvider streamWatchdogProvider;
  @Nonnull private final java.time.Duration streamWatchdogCheckInterval;
  @Nonnull private final ApiTracerFactory tracerFactory;
  // Track if deprecated setExecutorProvider is called
  private boolean deprecatedExecutorProviderSet;
  @Nonnull private final EndpointContext endpointContext;
  private final String apiKey;

  /**
   * Indicate when creating transport whether it is allowed to use mTLS endpoint instead of the
   * default endpoint. Only the endpoint set by client libraries is allowed. User provided endpoint
   * should always be used as it is. Client libraries can set it via the {@link
   * Builder#setSwitchToMtlsEndpointAllowed} method.
   */
  private final boolean switchToMtlsEndpointAllowed;

  /** Constructs an instance of StubSettings. */
  protected StubSettings(Builder builder) {
    this.backgroundExecutorProvider = builder.backgroundExecutorProvider;
    this.transportChannelProvider = builder.transportChannelProvider;
    this.credentialsProvider = builder.credentialsProvider;
    this.headerProvider = builder.headerProvider;
    this.internalHeaderProvider = builder.internalHeaderProvider;
    this.clock = builder.clock;
    this.switchToMtlsEndpointAllowed = builder.switchToMtlsEndpointAllowed;
    this.quotaProjectId = builder.quotaProjectId;
    this.streamWatchdogProvider = builder.streamWatchdogProvider;
    this.streamWatchdogCheckInterval = builder.streamWatchdogCheckInterval;
    this.tracerFactory = builder.tracerFactory;
    this.deprecatedExecutorProviderSet = builder.deprecatedExecutorProviderSet;
    this.gdchApiAudience = builder.gdchApiAudience;
    this.endpointContext = buildEndpointContext(builder);
    this.apiKey = builder.apiKey;
  }

  /**
   * Attempt to build the EndpointContext from the Builder based on all the user configurations
   * passed in.
   *
   * @throws RuntimeException if there is an issue building the EndpointContext
   */
  private EndpointContext buildEndpointContext(Builder builder) {
    try {
      return EndpointContext.newBuilder()
          .setServiceName(getServiceName())
          .setClientSettingsEndpoint(builder.clientSettingsEndpoint)
          .setTransportChannelProviderEndpoint(builder.transportChannelProviderEndpoint)
          .setMtlsEndpoint(builder.mtlsEndpoint)
          .setSwitchToMtlsEndpointAllowed(builder.switchToMtlsEndpointAllowed)
          .setUniverseDomain(builder.universeDomain)
          .build();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * @deprecated Please use {@link #getBackgroundExecutorProvider()}.
   */
  @Deprecated
  public final ExecutorProvider getExecutorProvider() {
    return deprecatedExecutorProviderSet ? backgroundExecutorProvider : null;
  }

  public final ExecutorProvider getBackgroundExecutorProvider() {
    return backgroundExecutorProvider;
  }

  public final TransportChannelProvider getTransportChannelProvider() {
    return transportChannelProvider;
  }

  public final CredentialsProvider getCredentialsProvider() {
    return credentialsProvider;
  }

  public final HeaderProvider getHeaderProvider() {
    return headerProvider;
  }

  protected final HeaderProvider getInternalHeaderProvider() {
    return internalHeaderProvider;
  }

  public final ApiClock getClock() {
    return clock;
  }

  /**
   * Marked with Internal Api and meant to overriden by the generated subclasses. This getter is
   * used to set the serviceName to the EndpointContext. The value in generated StubSettings
   * subclasses comes from the proto files.
   *
   * <p>This should be effectively treated as an abstract method.
   */
  @InternalApi
  protected String getServiceName() {
    return "";
  }

  /**
   * @return the fully resolved universe domain used by the client
   */
  public final String getUniverseDomain() {
    return endpointContext.resolvedUniverseDomain();
  }

  /**
   * @return the fully resolved endpoint used by the client
   */
  public String getEndpoint() {
    return endpointContext.resolvedEndpoint();
  }

  /**
   * @return the newly created EndpointContext
   */
  @InternalApi
  final EndpointContext getEndpointContext() {
    return endpointContext;
  }

  public final String getMtlsEndpoint() {
    return endpointContext.mtlsEndpoint();
  }

  /** Limit the visibility to this package only since only this package needs it. */
  final boolean getSwitchToMtlsEndpointAllowed() {
    return switchToMtlsEndpointAllowed;
  }

  public final String getQuotaProjectId() {
    return quotaProjectId;
  }

  @Nullable
  public final WatchdogProvider getStreamWatchdogProvider() {
    return streamWatchdogProvider;
  }

  /** This method is obsolete. Use {@link #getStreamWatchdogCheckIntervalDuration()} instead. */
  @Nonnull
  @ObsoleteApi("Use getStreamWatchdogCheckIntervalDuration() instead")
  public final org.threeten.bp.Duration getStreamWatchdogCheckInterval() {
    return toThreetenDuration(getStreamWatchdogCheckIntervalDuration());
  }

  @Nonnull
  public final java.time.Duration getStreamWatchdogCheckIntervalDuration() {
    return streamWatchdogCheckInterval;
  }

  /**
   * Gets the configured {@link ApiTracerFactory} that will be used to generate traces for
   * operations.
   */
  @BetaApi("The surface for tracing is not stable yet and may change in the future.")
  @Nonnull
  public ApiTracerFactory getTracerFactory() {
    return tracerFactory;
  }

  /** Gets the GDCH API audience to be used with {@link com.google.auth.oauth2.GdchCredentials} */
  @Nullable
  public final String getGdchApiAudience() {
    return gdchApiAudience;
  }

  /** Gets the API Key that should be used for authentication. */
  public final String getApiKey() {
    return apiKey;
  }

  /**
   * Returns the {@link LibraryMetadata} for the client library.
   *
   * <p>This should be effectively treated as an abstract method.
   */
  @InternalApi
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.empty();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("backgroundExecutorProvider", backgroundExecutorProvider)
        .add("transportChannelProvider", transportChannelProvider)
        .add("credentialsProvider", credentialsProvider)
        .add("headerProvider", headerProvider)
        .add("internalHeaderProvider", internalHeaderProvider)
        .add("clock", clock)
        .add("universeDomain", endpointContext.resolvedUniverseDomain())
        .add("endpoint", endpointContext.resolvedEndpoint())
        .add("mtlsEndpoint", endpointContext.mtlsEndpoint())
        .add("switchToMtlsEndpointAllowed", switchToMtlsEndpointAllowed)
        .add("quotaProjectId", quotaProjectId)
        .add("streamWatchdogProvider", streamWatchdogProvider)
        .add("streamWatchdogCheckInterval", streamWatchdogCheckInterval)
        .add("tracerFactory", tracerFactory)
        .add("gdchApiAudience", gdchApiAudience)
        .add("apiKey", apiKey)
        .toString();
  }

  public abstract StubSettings.Builder toBuilder();

  public abstract static class Builder<
      SettingsT extends StubSettings<SettingsT>, B extends Builder<SettingsT, B>> {

    private ExecutorProvider backgroundExecutorProvider;
    private CredentialsProvider credentialsProvider;
    private HeaderProvider headerProvider;
    private HeaderProvider internalHeaderProvider;
    private TransportChannelProvider transportChannelProvider;
    private ApiClock clock;
    private String clientSettingsEndpoint;
    private String transportChannelProviderEndpoint;
    private String mtlsEndpoint;
    private String quotaProjectId;
    @Nullable private String gdchApiAudience;
    @Nullable private WatchdogProvider streamWatchdogProvider;
    @Nonnull private java.time.Duration streamWatchdogCheckInterval;
    @Nonnull private ApiTracerFactory tracerFactory;
    private boolean deprecatedExecutorProviderSet;
    private String universeDomain;
    private final EndpointContext endpointContext;
    private String apiKey;

    /**
     * Indicate when creating transport whether it is allowed to use mTLS endpoint instead of the
     * default endpoint. Only the endpoint set by client libraries is allowed. User provided
     * endpoint should always be used as it is. Client libraries can set it via the {@link
     * Builder#setSwitchToMtlsEndpointAllowed} method.
     */
    private boolean switchToMtlsEndpointAllowed = false;

    /** Create a builder from a StubSettings object. */
    protected Builder(StubSettings settings) {
      this.backgroundExecutorProvider = settings.backgroundExecutorProvider;
      this.transportChannelProvider = settings.transportChannelProvider;
      this.credentialsProvider = settings.credentialsProvider;
      this.headerProvider = settings.headerProvider;
      this.internalHeaderProvider = settings.internalHeaderProvider;
      this.clock = settings.clock;
      this.switchToMtlsEndpointAllowed = settings.switchToMtlsEndpointAllowed;
      this.quotaProjectId = settings.quotaProjectId;
      this.streamWatchdogProvider = settings.streamWatchdogProvider;
      this.streamWatchdogCheckInterval = settings.streamWatchdogCheckInterval;
      this.tracerFactory = settings.tracerFactory;
      this.deprecatedExecutorProviderSet = settings.deprecatedExecutorProviderSet;
      this.gdchApiAudience = settings.gdchApiAudience;
      this.apiKey = settings.apiKey;

      // The follow settings will be set to the original user configurations as the
      // EndpointContext will be rebuilt in the constructor.
      this.clientSettingsEndpoint = settings.getEndpointContext().clientSettingsEndpoint();
      this.transportChannelProviderEndpoint =
          settings.getEndpointContext().transportChannelProviderEndpoint();
      this.mtlsEndpoint = settings.getEndpointContext().mtlsEndpoint();
      this.switchToMtlsEndpointAllowed =
          settings.getEndpointContext().switchToMtlsEndpointAllowed();
      this.universeDomain = settings.getEndpointContext().universeDomain();
      // Store the EndpointContext that was already created. This is used to return the state
      // of the EndpointContext prior to any new modifications
      this.endpointContext = settings.getEndpointContext();
    }

    /** Get Quota Project ID from Client Context * */
    private static String getQuotaProjectIdFromClientContext(ClientContext clientContext) {
      if (clientContext.getQuotaProjectId() != null) {
        return clientContext.getQuotaProjectId();
      }
      if (clientContext.getCredentials() instanceof QuotaProjectIdProvider) {
        return ((QuotaProjectIdProvider) clientContext.getCredentials()).getQuotaProjectId();
      }
      if (clientContext.getHeaders().containsKey(QUOTA_PROJECT_ID_HEADER_KEY)) {
        return clientContext.getHeaders().get(QUOTA_PROJECT_ID_HEADER_KEY);
      }
      if (clientContext.getInternalHeaders().containsKey(QUOTA_PROJECT_ID_HEADER_KEY)) {
        return clientContext.getInternalHeaders().get(QUOTA_PROJECT_ID_HEADER_KEY);
      }
      return null;
    }

    protected Builder(ClientContext clientContext) {
      if (clientContext == null) {
        this.backgroundExecutorProvider = InstantiatingExecutorProvider.newBuilder().build();
        this.transportChannelProvider = null;
        this.credentialsProvider = NoCredentialsProvider.create();
        this.headerProvider = new NoHeaderProvider();
        this.internalHeaderProvider = new NoHeaderProvider();
        this.clock = NanoClock.getDefaultClock();
        this.quotaProjectId = null;
        this.streamWatchdogProvider = InstantiatingWatchdogProvider.create();
        this.streamWatchdogCheckInterval = java.time.Duration.ofSeconds(10);
        this.tracerFactory = BaseApiTracerFactory.getInstance();
        this.deprecatedExecutorProviderSet = false;
        this.gdchApiAudience = null;

        this.clientSettingsEndpoint = null;
        this.transportChannelProviderEndpoint = null;
        this.mtlsEndpoint = null;
        this.switchToMtlsEndpointAllowed = false;
        this.universeDomain = null;
        this.apiKey = null;
        // Attempt to create an empty, non-functioning EndpointContext by default. The client will
        // have
        // a valid EndpointContext with user configurations after the client has been initialized.
        this.endpointContext = EndpointContext.getDefaultInstance();
      } else {
        ExecutorProvider fixedExecutorProvider =
            FixedExecutorProvider.create(clientContext.getExecutor());
        this.deprecatedExecutorProviderSet = true;
        this.backgroundExecutorProvider = fixedExecutorProvider;
        this.transportChannelProvider =
            FixedTransportChannelProvider.create(clientContext.getTransportChannel());
        this.credentialsProvider = FixedCredentialsProvider.create(clientContext.getCredentials());
        this.headerProvider = FixedHeaderProvider.create(clientContext.getHeaders());
        this.internalHeaderProvider =
            FixedHeaderProvider.create(clientContext.getInternalHeaders());
        this.clock = clientContext.getClock();
        this.streamWatchdogProvider =
            FixedWatchdogProvider.create(clientContext.getStreamWatchdog());
        this.streamWatchdogCheckInterval = clientContext.getStreamWatchdogCheckIntervalDuration();
        this.tracerFactory = clientContext.getTracerFactory();
        this.quotaProjectId = getQuotaProjectIdFromClientContext(clientContext);
        this.gdchApiAudience = clientContext.getGdchApiAudience();

        // The follow settings will be set to the original user configurations as the
        // EndpointContext will be rebuilt in the constructor.
        this.clientSettingsEndpoint = clientContext.getEndpointContext().clientSettingsEndpoint();
        this.transportChannelProviderEndpoint =
            clientContext.getEndpointContext().transportChannelProviderEndpoint();
        this.mtlsEndpoint = clientContext.getEndpointContext().mtlsEndpoint();
        this.switchToMtlsEndpointAllowed =
            clientContext.getEndpointContext().switchToMtlsEndpointAllowed();
        this.universeDomain = clientContext.getEndpointContext().universeDomain();
        // Store the EndpointContext that was already created. This is used to return the state
        // of the EndpointContext prior to any new modifications
        this.endpointContext = clientContext.getEndpointContext();
      }
    }

    protected Builder() {
      this((ClientContext) null);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }

    /**
     * Sets the ExecutorProvider to use for getting the executor to use for running asynchronous API
     * call logic (such as retries and long-running operations), and also to pass to the transport
     * settings if an executor is needed for the transport and it doesn't have its own executor
     * provider.
     *
     * @deprecated Please use {@link #setBackgroundExecutorProvider(ExecutorProvider)} for setting
     *     executor to use for running scheduled API call logic. To set executor for {@link
     *     TransportChannelProvider}, please use {@link
     *     TransportChannelProvider#withExecutor(Executor)} instead.
     */
    @Deprecated
    public B setExecutorProvider(ExecutorProvider executorProvider) {
      // For backward compatibility, this will set backgroundExecutorProvider and mark
      // deprecatedExecutorProviderSet to true. In ClientContext#create(), if
      // TransportChannelProvider doesn't have an executor, and deprecatedExecutorProviderSet is
      // true, backgroundExecutorProvider will be used as TransportChannelProvider's executor.
      // After this method is deprecated, TransportChannelProvider's executor can only be set with
      // TransportChannelProvider#withExecutor.
      this.deprecatedExecutorProviderSet = true;
      this.backgroundExecutorProvider = executorProvider;
      return self();
    }

    /**
     * Sets the executor to use for running scheduled API call logic (such as retries and
     * long-running operations).
     */
    public B setBackgroundExecutorProvider(ExecutorProvider backgroundExecutorProvider) {
      this.backgroundExecutorProvider = backgroundExecutorProvider;
      return self();
    }

    /** Sets the CredentialsProvider to use for getting the credentials to make calls with. */
    public B setCredentialsProvider(CredentialsProvider credentialsProvider) {
      this.credentialsProvider = Preconditions.checkNotNull(credentialsProvider);
      return self();
    }

    /**
     * Sets the HeaderProvider for getting custom static headers for http requests. The header
     * provider will be called during client construction only once. The headers returned by the
     * provider will be cached and supplied as is for each request issued by the constructed client.
     * Some reserved headers can be overridden (e.g. Content-Type) or merged with the default value
     * (e.g. User-Agent) by the underlying transport layer.
     */
    public B setHeaderProvider(HeaderProvider headerProvider) {
      this.headerProvider = headerProvider;
      if (this.quotaProjectId == null
          && headerProvider.getHeaders().containsKey(QUOTA_PROJECT_ID_HEADER_KEY)) {
        this.quotaProjectId = headerProvider.getHeaders().get(QUOTA_PROJECT_ID_HEADER_KEY);
      }
      return self();
    }

    /**
     * Sets the HeaderProvider for getting internal (library-defined) static headers for http
     * requests. The header provider will be called during client construction only once. The
     * headers returned by the provider will be cached and supplied as is for each request issued by
     * the constructed client. Some reserved headers can be overridden (e.g. Content-Type) or merged
     * with the default value (e.g. User-Agent) by the underlying transport layer.
     */
    protected B setInternalHeaderProvider(HeaderProvider internalHeaderProvider) {
      this.internalHeaderProvider = internalHeaderProvider;
      if (this.quotaProjectId == null
          && internalHeaderProvider.getHeaders().containsKey(QUOTA_PROJECT_ID_HEADER_KEY)) {
        this.quotaProjectId = internalHeaderProvider.getHeaders().get(QUOTA_PROJECT_ID_HEADER_KEY);
      }
      return self();
    }

    /**
     * Sets the TransportProvider to use for getting the transport-specific context to make calls
     * with.
     */
    public B setTransportChannelProvider(TransportChannelProvider transportChannelProvider) {
      this.transportChannelProvider = transportChannelProvider;
      this.transportChannelProviderEndpoint = transportChannelProvider.getEndpoint();
      return self();
    }

    /**
     * Sets the {@link WatchdogProvider} to use for streaming RPC.
     *
     * <p>This will default to a {@link InstantiatingWatchdogProvider} if it is not set.
     */
    public B setStreamWatchdogProvider(@Nullable WatchdogProvider streamWatchdogProvider) {
      this.streamWatchdogProvider = streamWatchdogProvider;
      return self();
    }

    /**
     * Sets the clock to use for retry logic.
     *
     * <p>This will default to a system clock if it is not set.
     */
    public B setClock(ApiClock clock) {
      this.clock = clock;
      return self();
    }

    public B setUniverseDomain(String universeDomain) {
      this.universeDomain = universeDomain;
      return self();
    }

    public B setEndpoint(String endpoint) {
      this.clientSettingsEndpoint = endpoint;
      this.switchToMtlsEndpointAllowed = false;
      if (this.clientSettingsEndpoint != null && this.mtlsEndpoint == null) {
        this.mtlsEndpoint =
            this.clientSettingsEndpoint.replace("googleapis.com", "mtls.googleapis.com");
      }
      return self();
    }

    protected B setSwitchToMtlsEndpointAllowed(boolean switchToMtlsEndpointAllowed) {
      this.switchToMtlsEndpointAllowed = switchToMtlsEndpointAllowed;
      return self();
    }

    public B setMtlsEndpoint(String mtlsEndpoint) {
      this.mtlsEndpoint = mtlsEndpoint;
      return self();
    }

    public B setQuotaProjectId(String quotaProjectId) {
      this.quotaProjectId = quotaProjectId;
      return self();
    }

    /**
     * This method is obsolete. Use {@link
     * #setStreamWatchdogCheckIntervalDuration(java.time.Duration)} instead.
     */
    @ObsoleteApi("Use setStreamWatchdogCheckIntervalDuration(java.time.Duration) instead")
    public B setStreamWatchdogCheckInterval(@Nonnull org.threeten.bp.Duration checkInterval) {
      return setStreamWatchdogCheckIntervalDuration(toJavaTimeDuration(checkInterval));
    }

    /**
     * Sets how often the {@link Watchdog} will check ongoing streaming RPCs. Defaults to 10 secs.
     * Use {@link java.time.Duration#ZERO} to disable.
     */
    public B setStreamWatchdogCheckIntervalDuration(@Nonnull java.time.Duration checkInterval) {
      Preconditions.checkNotNull(checkInterval);
      this.streamWatchdogCheckInterval = checkInterval;
      return self();
    }

    /**
     * Sets the API audience used by {@link com.google.auth.oauth2.GdchCredentials} It cannot be
     * used if other type of {@link com.google.auth.Credentials} is used. If the provided
     * credentials already have an api audience set, then it will be overriden by this audience
     *
     * @param gdchApiAudience the audience to be used - must be a valid URI string
     */
    public B setGdchApiAudience(String gdchApiAudience) {
      this.gdchApiAudience = gdchApiAudience;
      return self();
    }

    /**
     * Configures the {@link ApiTracerFactory} that will be used to generate traces.
     *
     * @param tracerFactory an instance of {@link ApiTracerFactory} to set.
     */
    @BetaApi("The surface for tracing is not stable yet and may change in the future.")
    public B setTracerFactory(@Nonnull ApiTracerFactory tracerFactory) {
      Preconditions.checkNotNull(tracerFactory);
      this.tracerFactory = tracerFactory;
      return self();
    }

    /**
     * Sets the API key. The API key will get translated to an {@link
     * com.google.auth.ApiKeyCredentials} and stored in {@link ClientContext}.
     *
     * <p>API Key authorization is not supported for every product. Please check the documentation
     * for each product to confirm if it is supported.
     *
     * <p>Note: If you set an API key and {@link CredentialsProvider} in the same ClientSettings the
     * API key will override any credentials provided.
     */
    public B setApiKey(String apiKey) {
      this.apiKey = apiKey;
      return self();
    }

    /**
     * @deprecated Please use {@link #getBackgroundExecutorProvider()}.
     */
    @Deprecated
    public ExecutorProvider getExecutorProvider() {
      return deprecatedExecutorProviderSet ? backgroundExecutorProvider : null;
    }

    /** Gets the ExecutorProvider that was previously set on this Builder. */
    public ExecutorProvider getBackgroundExecutorProvider() {
      return backgroundExecutorProvider;
    }

    /** Gets the TransportProvider that was previously set on this Builder. */
    public TransportChannelProvider getTransportChannelProvider() {
      return transportChannelProvider;
    }

    /** Gets the CredentialsProvider that was previously set on this Builder. */
    public CredentialsProvider getCredentialsProvider() {
      return credentialsProvider;
    }

    /** Gets the custom HeaderProvider that was previously set on this Builder. */
    public HeaderProvider getHeaderProvider() {
      return headerProvider;
    }

    /** Gets the internal HeaderProvider that was previously set on this Builder. */
    protected HeaderProvider getInternalHeaderProvider() {
      return internalHeaderProvider;
    }

    /** Gets the {@link WatchdogProvider }that was previously set on this Builder. */
    @Nullable
    public WatchdogProvider getStreamWatchdogProvider() {
      return streamWatchdogProvider;
    }

    /** Gets the ApiClock that was previously set on this Builder. */
    public ApiClock getClock() {
      return clock;
    }

    /** Gets the API Key that was previously set on this Builder. */
    public final String getApiKey() {
      return apiKey;
    }

    /**
     * @return the resolved endpoint when the Builder was created. If invoked after
     *     `StubSettings.newBuilder()` is called, it will return the clientSettingsEndpoint value.
     *     If other parameters are then set in the builder, the resolved endpoint is not
     *     automatically updated. The resolved endpoint will only be recomputed when the
     *     StubSettings is built again.
     */
    public String getEndpoint() {
      // For the `StubSettings.newBuilder()` case
      if (endpointContext.equals(EndpointContext.getDefaultInstance())) {
        return clientSettingsEndpoint;
      }
      return endpointContext.resolvedEndpoint();
    }

    public String getMtlsEndpoint() {
      return mtlsEndpoint;
    }

    /** Gets the QuotaProjectId that was previously set on this Builder. */
    public String getQuotaProjectId() {
      return quotaProjectId;
    }

    /** This method is obsolete. Use {@link #getStreamWatchdogCheckIntervalDuration()} instead */
    @ObsoleteApi("Use getStreamWatchdogCheckIntervalDuration() instead")
    public org.threeten.bp.Duration getStreamWatchdogCheckInterval() {
      return toThreetenDuration(getStreamWatchdogCheckIntervalDuration());
    }

    @Nonnull
    public java.time.Duration getStreamWatchdogCheckIntervalDuration() {
      return Preconditions.checkNotNull(streamWatchdogCheckInterval);
    }

    @BetaApi("The surface for tracing is not stable yet and may change in the future.")
    @Nonnull
    public ApiTracerFactory getTracerFactory() {
      return tracerFactory;
    }

    /** Gets the GDCH API audience that was previously set in this Builder */
    public String getGdchApiAudience() {
      return gdchApiAudience;
    }

    /** Applies the given settings updater function to the given method settings builders. */
    protected static void applyToAllUnaryMethods(
        Iterable<UnaryCallSettings.Builder<?, ?>> methodSettingsBuilders,
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      for (UnaryCallSettings.Builder<?, ?> settingsBuilder : methodSettingsBuilders) {
        settingsUpdater.apply(settingsBuilder);
      }
    }

    public abstract <B extends StubSettings<B>> StubSettings<B> build() throws IOException;

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("backgroundExecutorProvider", backgroundExecutorProvider)
          .add("transportChannelProvider", transportChannelProvider)
          .add("credentialsProvider", credentialsProvider)
          .add("headerProvider", headerProvider)
          .add("internalHeaderProvider", internalHeaderProvider)
          .add("clock", clock)
          .add("universeDomain", universeDomain)
          .add("endpoint", clientSettingsEndpoint)
          .add("mtlsEndpoint", mtlsEndpoint)
          .add("switchToMtlsEndpointAllowed", switchToMtlsEndpointAllowed)
          .add("quotaProjectId", quotaProjectId)
          .add("streamWatchdogProvider", streamWatchdogProvider)
          .add("streamWatchdogCheckInterval", streamWatchdogCheckInterval)
          .add("tracerFactory", tracerFactory)
          .add("gdchApiAudience", gdchApiAudience)
          .toString();
    }
  }
}
