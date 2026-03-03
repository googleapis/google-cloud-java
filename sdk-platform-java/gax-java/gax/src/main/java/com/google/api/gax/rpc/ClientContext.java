/*
 * Copyright 2017 Google LLC
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

import com.google.api.client.util.Strings;
import com.google.api.core.ApiClock;
import com.google.api.core.BetaApi;
import com.google.api.core.NanoClock;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.ExecutorAsBackgroundResource;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.rpc.internal.QuotaProjectIdHidingCredentials;
import com.google.api.gax.tracing.ApiTracerContext;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.BaseApiTracerFactory;
import com.google.api.gax.tracing.SpanTracerFactory;
import com.google.auth.ApiKeyCredentials;
import com.google.auth.CredentialTypeForMetrics;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GdchCredentials;
import com.google.auto.value.AutoValue;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Encapsulates client state, including executor, credentials, and transport channel.
 *
 * <p>Unlike {@link ClientSettings} which allows users to configure the client, {@code
 * ClientContext} is intended to be used in generated code. Most users will not need to use it.
 */
@AutoValue
public abstract class ClientContext {
  private static final String QUOTA_PROJECT_ID_HEADER_KEY = "x-goog-user-project";

  /**
   * The objects that need to be closed in order to clean up the resources created in the process of
   * creating this ClientContext. This will include the closeables from the transport context.
   */
  public abstract List<BackgroundResource> getBackgroundResources();

  /**
   * Gets the executor to use for running scheduled API call logic (such as retries and long-running
   * operations).
   */
  public abstract ScheduledExecutorService getExecutor();

  @Nullable
  public abstract Credentials getCredentials();

  @Nullable
  public abstract TransportChannel getTransportChannel();

  public abstract Map<String, String> getHeaders();

  protected abstract Map<String, String> getInternalHeaders();

  public abstract ApiClock getClock();

  public abstract ApiCallContext getDefaultCallContext();

  @Nullable
  public abstract Watchdog getStreamWatchdog();

  /** This method is obsolete. Use {@link #getStreamWatchdogCheckIntervalDuration()} instead. */
  @Nonnull
  @ObsoleteApi("Use getStreamWatchdogCheckIntervalDuration() instead")
  public final org.threeten.bp.Duration getStreamWatchdogCheckInterval() {
    return toThreetenDuration(getStreamWatchdogCheckIntervalDuration());
  }

  @Nonnull
  public abstract java.time.Duration getStreamWatchdogCheckIntervalDuration();

  @Nullable
  public abstract String getUniverseDomain();

  @Nullable
  public abstract String getEndpoint();

  @Nullable
  public abstract String getQuotaProjectId();

  /** Package-Private as this is to be shared to StubSettings */
  abstract EndpointContext getEndpointContext();

  /** Gets the {@link ApiTracerFactory} that will be used to generate traces for operations. */
  @BetaApi("The surface for tracing is not stable yet and may change in the future.")
  @Nonnull
  public abstract ApiTracerFactory getTracerFactory();

  /**
   * Gets the API audience used when creating a Client that uses {@link
   * com.google.auth.oauth2.GdchCredentials}
   */
  @Nullable
  public abstract String getGdchApiAudience();

  /** Create a new ClientContext with default values */
  public static Builder newBuilder() {
    return new AutoValue_ClientContext.Builder()
        .setBackgroundResources(Collections.<BackgroundResource>emptyList())
        .setExecutor(Executors.newScheduledThreadPool(0))
        .setHeaders(Collections.<String, String>emptyMap())
        .setInternalHeaders(Collections.<String, String>emptyMap())
        .setClock(NanoClock.getDefaultClock())
        .setStreamWatchdog(null)
        .setStreamWatchdogCheckIntervalDuration(java.time.Duration.ZERO)
        .setTracerFactory(BaseApiTracerFactory.getInstance())
        .setQuotaProjectId(null)
        .setGdchApiAudience(null)
        // Attempt to create an empty, non-functioning EndpointContext by default. This is
        // not exposed to the user via getters/setters.
        .setEndpointContext(EndpointContext.getDefaultInstance());
  }

  public abstract Builder toBuilder();

  /**
   * Instantiates the executor, credentials, and transport context based on the given client
   * settings.
   */
  public static ClientContext create(ClientSettings settings) throws IOException {
    return create(settings.getStubSettings());
  }

  /**
   * Instantiates the executor, credentials, and transport context based on the given client
   * settings.
   */
  public static ClientContext create(StubSettings settings) throws IOException {
    ApiClock clock = settings.getClock();

    ExecutorProvider backgroundExecutorProvider = settings.getBackgroundExecutorProvider();
    final ScheduledExecutorService backgroundExecutor = backgroundExecutorProvider.getExecutor();

    // A valid EndpointContext should have been created in the StubSettings
    EndpointContext endpointContext = settings.getEndpointContext();
    String endpoint = endpointContext.resolvedEndpoint();
    Credentials credentials = getCredentials(settings);
    // check if need to adjust credentials/endpoint/endpointContext for GDC-H
    String settingsGdchApiAudience = settings.getGdchApiAudience();
    boolean usingGDCH = credentials instanceof GdchCredentials;
    if (usingGDCH) {
      // Can only determine if the GDC-H is being used via the Credentials. The Credentials object
      // is resolved in the ClientContext and must be passed to the EndpointContext. Rebuild the
      // endpointContext only on GDC-H flows.
      endpointContext = endpointContext.withGDCH();
      // Resolve the new endpoint with the GDC-H flow
      endpoint = endpointContext.resolvedEndpoint();
      // We recompute the GdchCredentials with the audience
      credentials = getGdchCredentials(settingsGdchApiAudience, endpoint, credentials);
    } else if (!Strings.isNullOrEmpty(settingsGdchApiAudience)) {
      throw new IllegalArgumentException(
          "GDC-H API audience can only be set when using GdchCredentials");
    }

    if (settings.getQuotaProjectId() != null && credentials != null) {
      // If the quotaProjectId is set, wrap original credentials with correct quotaProjectId as
      // QuotaProjectIdHidingCredentials.
      // Ensure that a custom set quota project id takes priority over one detected by credentials.
      // Avoid the backend receiving possibly conflict values of quotaProjectId
      credentials = new QuotaProjectIdHidingCredentials(credentials);
    }

    TransportChannelProvider transportChannelProvider = settings.getTransportChannelProvider();
    // After needsExecutor and StubSettings#setExecutorProvider are deprecated, transport channel
    // executor can only be set from TransportChannelProvider#withExecutor directly, and a provider
    // will have a default executor if it needs one.
    if (transportChannelProvider.needsExecutor() && settings.getExecutorProvider() != null) {
      transportChannelProvider =
          transportChannelProvider.withExecutor(settings.getExecutorProvider().getExecutor());
    }
    if (transportChannelProvider.needsBackgroundExecutor()) {
      transportChannelProvider =
          transportChannelProvider.withBackgroundExecutor(backgroundExecutor);
    }
    Map<String, String> headers = getHeaders(settings, credentials);
    if (transportChannelProvider.needsHeaders()) {
      transportChannelProvider = transportChannelProvider.withHeaders(headers);
    }
    if (transportChannelProvider.needsCredentials() && credentials != null) {
      transportChannelProvider = transportChannelProvider.withCredentials(credentials);
    }
    if (transportChannelProvider.needsEndpoint()) {
      transportChannelProvider = transportChannelProvider.withEndpoint(endpoint);
    }
    transportChannelProvider = transportChannelProvider.withUseS2A(endpointContext.useS2A());
    if (transportChannelProvider.needsMtlsEndpoint() && endpointContext.mtlsEndpoint() != null) {
      transportChannelProvider =
          transportChannelProvider.withMtlsEndpoint(endpointContext.mtlsEndpoint());
    }
    TransportChannel transportChannel = transportChannelProvider.getTransportChannel();

    ApiCallContext defaultCallContext =
        transportChannel.getEmptyCallContext().withTransportChannel(transportChannel);
    if (credentials != null) {
      defaultCallContext = defaultCallContext.withCredentials(credentials);
    }
    defaultCallContext = defaultCallContext.withEndpointContext(endpointContext);

    WatchdogProvider watchdogProvider = settings.getStreamWatchdogProvider();
    @Nullable Watchdog watchdog = null;

    if (watchdogProvider != null) {
      if (watchdogProvider.needsCheckInterval()) {
        watchdogProvider =
            watchdogProvider.withCheckIntervalDuration(
                settings.getStreamWatchdogCheckIntervalDuration());
      }
      if (watchdogProvider.needsClock()) {
        watchdogProvider = watchdogProvider.withClock(clock);
      }
      if (watchdogProvider.needsExecutor()) {
        watchdogProvider = watchdogProvider.withExecutor(backgroundExecutor);
      }
      watchdog = watchdogProvider.getWatchdog();
    }

    ImmutableList.Builder<BackgroundResource> backgroundResources = ImmutableList.builder();

    if (transportChannelProvider.shouldAutoClose()) {
      backgroundResources.add(transportChannel);
    }
    if (backgroundExecutorProvider.shouldAutoClose()) {
      backgroundResources.add(new ExecutorAsBackgroundResource(backgroundExecutor));
    }
    if (watchdogProvider != null && watchdogProvider.shouldAutoClose()) {
      backgroundResources.add(watchdog);
    }
    ApiTracerContext apiTracerContext =
        ApiTracerContext.newBuilder()
            .setServerAddress(endpointContext.resolvedServerAddress())
            .setLibraryMetadata(settings.getLibraryMetadata())
            .build();
    ApiTracerFactory apiTracerFactory = settings.getTracerFactory();
    if (apiTracerFactory instanceof SpanTracerFactory) {
      apiTracerFactory = apiTracerFactory.withContext(apiTracerContext);
    }

    return newBuilder()
        .setBackgroundResources(backgroundResources.build())
        .setExecutor(backgroundExecutor)
        .setCredentials(credentials)
        .setTransportChannel(transportChannel)
        .setHeaders(ImmutableMap.copyOf(settings.getHeaderProvider().getHeaders()))
        .setInternalHeaders(ImmutableMap.copyOf(settings.getInternalHeaderProvider().getHeaders()))
        .setClock(clock)
        .setDefaultCallContext(defaultCallContext)
        .setUniverseDomain(settings.getUniverseDomain())
        .setEndpoint(settings.getEndpoint())
        .setQuotaProjectId(settings.getQuotaProjectId())
        .setStreamWatchdog(watchdog)
        .setStreamWatchdogCheckIntervalDuration(settings.getStreamWatchdogCheckIntervalDuration())
        .setTracerFactory(apiTracerFactory)
        .setEndpointContext(endpointContext)
        .build();
  }

  /** Determines which credentials to use. API key overrides credentials provided by provider. */
  private static Credentials getCredentials(StubSettings settings) throws IOException {
    Credentials credentials;
    if (settings.getApiKey() != null) {
      // if API key exists it becomes the default credential
      credentials = ApiKeyCredentials.create(settings.getApiKey());
    } else {
      credentials = settings.getCredentialsProvider().getCredentials();
    }
    return credentials;
  }

  /**
   * Constructs a new {@link com.google.auth.Credentials} object based on credentials provided with
   * a GDC-H audience
   */
  @VisibleForTesting
  static GdchCredentials getGdchCredentials(
      String settingsGdchApiAudience, String endpoint, Credentials credentials) throws IOException {
    String audienceString;
    if (!Strings.isNullOrEmpty(settingsGdchApiAudience)) {
      audienceString = settingsGdchApiAudience;
    } else if (!Strings.isNullOrEmpty(endpoint)) {
      audienceString = endpoint;
    } else {
      throw new IllegalArgumentException("Could not infer GDCH api audience from settings");
    }

    URI gdchAudienceUri;
    try {
      gdchAudienceUri = URI.create(audienceString);
    } catch (IllegalArgumentException ex) { // thrown when passing a malformed uri string
      throw new IllegalArgumentException("The GDC-H API audience string is not a valid URI", ex);
    }
    return ((GdchCredentials) credentials).createWithGdchAudience(gdchAudienceUri);
  }

  /**
   * Getting a header map from HeaderProvider and InternalHeaderProvider from settings with Quota
   * Project Id.
   *
   * <p>Then if credentials is present and its type for metrics is not {@code
   * CredentialTypeForMetrics.DO_NOT_SEND}, append this type info to x-goog-api-client header.
   */
  private static Map<String, String> getHeaders(StubSettings settings, Credentials credentials) {
    // Resolve conflicts when merging headers from multiple sources
    Map<String, String> userHeaders = settings.getHeaderProvider().getHeaders();
    Map<String, String> internalHeaders = settings.getInternalHeaderProvider().getHeaders();
    Map<String, String> conflictResolution = new HashMap<>();

    Set<String> conflicts = Sets.intersection(userHeaders.keySet(), internalHeaders.keySet());
    for (String key : conflicts) {
      if ("user-agent".equals(key)) {
        conflictResolution.put(key, userHeaders.get(key) + " " + internalHeaders.get(key));
        continue;
      }
      // Backwards compat: quota project id can conflict if its overriden in settings
      if (QUOTA_PROJECT_ID_HEADER_KEY.equals(key) && settings.getQuotaProjectId() != null) {
        continue;
      }
      throw new IllegalArgumentException("Header provider can't override the header: " + key);
    }
    if (settings.getQuotaProjectId() != null) {
      conflictResolution.put(QUOTA_PROJECT_ID_HEADER_KEY, settings.getQuotaProjectId());
    }

    Map<String, String> effectiveHeaders = new HashMap<>();
    effectiveHeaders.putAll(internalHeaders);
    effectiveHeaders.putAll(userHeaders);
    effectiveHeaders.putAll(conflictResolution);

    return appendCredentialTypeToHeaderIfPresent(effectiveHeaders, credentials);
  }

  private static Map<String, String> appendCredentialTypeToHeaderIfPresent(
      Map<String, String> effectiveHeaders, Credentials credentials) {
    CredentialTypeForMetrics credentialTypeForMetrics =
        credentials == null
            ? CredentialTypeForMetrics.DO_NOT_SEND
            : credentials.getMetricsCredentialType();
    if (credentialTypeForMetrics != CredentialTypeForMetrics.DO_NOT_SEND) {
      effectiveHeaders.computeIfPresent(
          ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
          (key, value) -> value + " cred-type/" + credentialTypeForMetrics.getLabel());
    }
    return ImmutableMap.copyOf(effectiveHeaders);
  }

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder setBackgroundResources(List<BackgroundResource> backgroundResources);

    /**
     * Sets the executor to use for running scheduled API call logic (such as retries and
     * long-running operations).
     */
    public abstract Builder setExecutor(ScheduledExecutorService value);

    public abstract Builder setCredentials(Credentials value);

    public abstract Builder setTransportChannel(TransportChannel transportChannel);

    public abstract Builder setHeaders(Map<String, String> headers);

    protected abstract Builder setInternalHeaders(Map<String, String> headers);

    public abstract Builder setClock(ApiClock clock);

    public abstract Builder setDefaultCallContext(ApiCallContext defaultCallContext);

    public abstract Builder setUniverseDomain(String universeDomain);

    public abstract Builder setEndpoint(String endpoint);

    public abstract Builder setQuotaProjectId(String QuotaProjectId);

    public abstract Builder setStreamWatchdog(Watchdog watchdog);

    /**
     * This method is obsolete. Use {@link
     * #setStreamWatchdogCheckIntervalDuration(java.time.Duration)} instead.
     */
    @ObsoleteApi("Use setStreamWatchdogCheckIntervalDuration(java.time.Duration) instead")
    public final Builder setStreamWatchdogCheckInterval(org.threeten.bp.Duration duration) {
      return setStreamWatchdogCheckIntervalDuration(toJavaTimeDuration(duration));
    }

    public abstract Builder setStreamWatchdogCheckIntervalDuration(java.time.Duration duration);

    /**
     * Set the {@link ApiTracerFactory} that will be used to generate traces for operations.
     *
     * @param tracerFactory an instance {@link ApiTracerFactory}.
     */
    @BetaApi("The surface for tracing is not stable yet and may change in the future.")
    public abstract Builder setTracerFactory(ApiTracerFactory tracerFactory);

    /**
     * Sets the API audience used by {@link com.google.auth.oauth2.GdchCredentials} It cannot be
     * used if other type of {@link com.google.auth.Credentials} is used
     *
     * <p>If the provided credentials already contain an api audience, it will be overriden by this
     * one
     *
     * @param gdchApiAudience the audience to be used - must be a valid URI string
     */
    public abstract Builder setGdchApiAudience(String gdchApiAudience);

    /** Package-Private as this is to be shared to StubSettings */
    abstract Builder setEndpointContext(EndpointContext endpointContext);

    public abstract ClientContext build();
  }
}
