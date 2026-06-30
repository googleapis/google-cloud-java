/*
 * Copyright 2016 Google LLC
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

import com.google.api.core.ApiClock;
import com.google.api.core.ApiFunction;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.common.base.MoreObjects;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A base settings class to configure a client class.
 *
 * <p>This base class includes settings that are applicable to all services, which includes things
 * like settings for creating an executor, credentials, transport-specific settings, and identifiers
 * for http headers.
 *
 * <p>If no ExecutorProvider is set, then InstantiatingExecutorProvider will be used, which creates
 * a default executor.
 */
public abstract class ClientSettings<SettingsT extends ClientSettings<SettingsT>> {

  private final StubSettings stubSettings;

  /** Constructs an instance of ClientSettings. */
  protected ClientSettings(Builder builder) throws IOException {
    this.stubSettings = builder.stubSettings.build();
  }

  public final StubSettings getStubSettings() {
    return stubSettings;
  }

  /**
   * @deprecated Please use {@link #getBackgroundExecutorProvider()}
   */
  @Deprecated
  public final ExecutorProvider getExecutorProvider() {
    return stubSettings.getExecutorProvider();
  }

  public final ExecutorProvider getBackgroundExecutorProvider() {
    return stubSettings.getBackgroundExecutorProvider();
  }

  public final TransportChannelProvider getTransportChannelProvider() {
    return stubSettings.getTransportChannelProvider();
  }

  public final CredentialsProvider getCredentialsProvider() {
    return stubSettings.getCredentialsProvider();
  }

  public final HeaderProvider getHeaderProvider() {
    return stubSettings.getHeaderProvider();
  }

  protected final HeaderProvider getInternalHeaderProvider() {
    return stubSettings.getInternalHeaderProvider();
  }

  public final ApiClock getClock() {
    return stubSettings.getClock();
  }

  public final String getUniverseDomain() {
    return stubSettings.getUniverseDomain();
  }

  public final String getEndpoint() {
    return stubSettings.getEndpoint();
  }

  public final String getQuotaProjectId() {
    return stubSettings.getQuotaProjectId();
  }

  @Nullable
  public final WatchdogProvider getWatchdogProvider() {
    return stubSettings.getStreamWatchdogProvider();
  }

  /** Gets the API Key that should be used for authentication. */
  public final String getApiKey() {
    return stubSettings.getApiKey();
  }

  /** This method is obsolete. Use {@link #getWatchdogCheckIntervalDuration()} instead. */
  @Nonnull
  @ObsoleteApi("Use getWatchdogCheckIntervalDuration() instead")
  public final org.threeten.bp.Duration getWatchdogCheckInterval() {
    return stubSettings.getStreamWatchdogCheckInterval();
  }

  @Nonnull
  public final java.time.Duration getWatchdogCheckIntervalDuration() {
    return stubSettings.getStreamWatchdogCheckIntervalDuration();
  }

  /** Gets the GDCH API audience that was previously set in this Builder */
  public final String getGdchApiAudience() {
    return stubSettings.getGdchApiAudience();
  }

  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("executorProvider", getExecutorProvider())
        .add("backgroundExecutorProvider", getBackgroundExecutorProvider())
        .add("transportChannelProvider", getTransportChannelProvider())
        .add("credentialsProvider", getCredentialsProvider())
        .add("headerProvider", getHeaderProvider())
        .add("internalHeaderProvider", getInternalHeaderProvider())
        .add("clock", getClock())
        .add("universeDomain", getUniverseDomain())
        .add("endpoint", getEndpoint())
        .add("quotaProjectId", getQuotaProjectId())
        .add("watchdogProvider", getWatchdogProvider())
        .add("watchdogCheckInterval", getWatchdogCheckInterval())
        .add("gdchApiAudience", getGdchApiAudience())
        .add("apiKey", getApiKey())
        .toString();
  }

  public abstract <B extends Builder<SettingsT, B>> B toBuilder();

  public abstract static class Builder<
      SettingsT extends ClientSettings<SettingsT>, B extends Builder<SettingsT, B>> {

    private StubSettings.Builder stubSettings;

    /** Create a builder from a ClientSettings object. */
    protected Builder(ClientSettings settings) {
      this.stubSettings = settings.stubSettings.toBuilder();
    }

    /** Create a builder from a StubSettings object. */
    protected Builder(StubSettings.Builder stubSettings) {
      this.stubSettings = stubSettings;
    }

    protected Builder() {
      this((StubSettings.Builder) null);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }

    protected StubSettings.Builder getStubSettings() {
      return stubSettings;
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
      stubSettings.setExecutorProvider(executorProvider);
      stubSettings.setBackgroundExecutorProvider(executorProvider);
      return self();
    }

    /**
     * Sets the ExecutorProvider to use for getting the executor to use for running scheduled API
     * call logic (such as retries and long-running operations). This will not set the executor in
     * {@link TransportChannelProvider}. To set executor for {@link TransportChannelProvider},
     * please use {@link TransportChannelProvider#withExecutor(Executor)}.
     */
    public B setBackgroundExecutorProvider(ExecutorProvider executorProvider) {
      stubSettings.setBackgroundExecutorProvider(executorProvider);
      return self();
    }

    /** Sets the CredentialsProvider to use for getting the credentials to make calls with. */
    public B setCredentialsProvider(CredentialsProvider credentialsProvider) {
      stubSettings.setCredentialsProvider(credentialsProvider);
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
      stubSettings.setHeaderProvider(headerProvider);
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
      stubSettings.setInternalHeaderProvider(internalHeaderProvider);
      return self();
    }

    /**
     * Sets the TransportProvider to use for getting the transport-specific context to make calls
     * with.
     */
    public B setTransportChannelProvider(TransportChannelProvider transportChannelProvider) {
      stubSettings.setTransportChannelProvider(transportChannelProvider);
      return self();
    }

    /**
     * Sets the clock to use for retry logic.
     *
     * <p>This will default to a system clock if it is not set.
     */
    public B setClock(ApiClock clock) {
      stubSettings.setClock(clock);
      return self();
    }

    /** Sets the Universe Domain to configure the resolved endpoint */
    public B setUniverseDomain(String universeDomain) {
      stubSettings.setUniverseDomain(universeDomain);
      return self();
    }

    public B setEndpoint(String endpoint) {
      stubSettings.setEndpoint(endpoint);
      return self();
    }

    public B setQuotaProjectId(String quotaProjectId) {
      stubSettings.setQuotaProjectId(quotaProjectId);
      return self();
    }

    public B setWatchdogProvider(@Nullable WatchdogProvider watchdogProvider) {
      stubSettings.setStreamWatchdogProvider(watchdogProvider);
      return self();
    }

    /**
     * This method is obsolete. Use {@link #setWatchdogCheckIntervalDuration(java.time.Duration)}
     * instead.
     */
    @ObsoleteApi("Use setWatchdogCheckIntervalDuration(java.time.Duration) instead")
    public B setWatchdogCheckInterval(@Nullable org.threeten.bp.Duration checkInterval) {
      return setWatchdogCheckIntervalDuration(toJavaTimeDuration(checkInterval));
    }

    public B setWatchdogCheckIntervalDuration(@Nullable java.time.Duration checkInterval) {
      stubSettings.setStreamWatchdogCheckIntervalDuration(checkInterval);
      return self();
    }

    /**
     * Sets the GDC-H api audience. This is intended only to be used with {@link
     * com.google.auth.oauth2.GdchCredentials} If this field is set and other type of {@link
     * com.google.auth.Credentials} is used then an {@link IllegalArgumentException} will be thrown.
     * If the provided credentials already have an api audience, then it will be overriden by this
     * audience
     */
    public B setGdchApiAudience(@Nullable String gdchApiAudience) {
      stubSettings.setGdchApiAudience(gdchApiAudience);
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
      stubSettings.setApiKey(apiKey);
      return self();
    }

    /**
     * Gets the ExecutorProvider that was previously set on this Builder. This ExecutorProvider is
     * to use for running asynchronous API call logic (such as retries and long-running operations),
     * and also to pass to the transport settings if an executor is needed for the transport and it
     * doesn't have its own executor provider.
     *
     * @deprecated Please use {@link #getBackgroundExecutorProvider()} for getting the executor
     *     provider that's used for running scheduled API call logic.
     */
    @Deprecated
    public ExecutorProvider getExecutorProvider() {
      return stubSettings.getExecutorProvider();
    }

    /**
     * Gets the ExecutorProvider that was previously set on this Builder. This ExecutorProvider is
     * to use for running asynchronous API call logic (such as retries and long-running operations).
     * This ExecutorProvider is not used to set the executor in {@link TransportChannelProvider}.
     */
    public ExecutorProvider getBackgroundExecutorProvider() {
      return stubSettings.getBackgroundExecutorProvider();
    }

    /** Gets the TransportProvider that was previously set on this Builder. */
    public TransportChannelProvider getTransportChannelProvider() {
      return stubSettings.getTransportChannelProvider();
    }

    /** Gets the CredentialsProvider that was previously set on this Builder. */
    public CredentialsProvider getCredentialsProvider() {
      return stubSettings.getCredentialsProvider();
    }

    /** Gets the custom HeaderProvider that was previously set on this Builder. */
    public HeaderProvider getHeaderProvider() {
      return stubSettings.getHeaderProvider();
    }

    /** Gets the internal HeaderProvider that was previously set on this Builder. */
    protected HeaderProvider getInternalHeaderProvider() {
      return stubSettings.getInternalHeaderProvider();
    }

    /** Gets the ApiClock that was previously set on this Builder. */
    public ApiClock getClock() {
      return stubSettings.getClock();
    }

    public String getEndpoint() {
      return stubSettings.getEndpoint();
    }

    /** Gets the QuotaProjectId that was previously set on this Builder. */
    public String getQuotaProjectId() {
      return stubSettings.getQuotaProjectId();
    }

    @Nullable
    public WatchdogProvider getWatchdogProvider() {
      return stubSettings.getStreamWatchdogProvider();
    }

    /** Gets the API Key that was previously set on this Builder. */
    public String getApiKey() {
      return stubSettings.getApiKey();
    }

    /** This method is obsolete. Use {@link #getWatchdogCheckIntervalDuration()} instead */
    @Nullable
    @ObsoleteApi("Use getWatchdogCheckIntervalDuration() instead")
    public org.threeten.bp.Duration getWatchdogCheckInterval() {
      return stubSettings.getStreamWatchdogCheckInterval();
    }

    @Nullable
    public java.time.Duration getWatchdogCheckIntervalDuration() {
      return stubSettings.getStreamWatchdogCheckIntervalDuration();
    }

    /** Gets the GDCH API audience that was previously set in this Builder */
    @Nullable
    public String getGdchApiAudience() {
      return stubSettings.getGdchApiAudience();
    }

    /** Applies the given settings updater function to the given method settings builders. */
    protected static void applyToAllUnaryMethods(
        Iterable<UnaryCallSettings.Builder<?, ?>> methodSettingsBuilders,
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      StubSettings.Builder.applyToAllUnaryMethods(methodSettingsBuilders, settingsUpdater);
    }

    public abstract SettingsT build() throws IOException;

    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("executorProvider", getExecutorProvider())
          .add("backgroundExecutorProvider", getBackgroundExecutorProvider())
          .add("transportChannelProvider", getTransportChannelProvider())
          .add("credentialsProvider", getCredentialsProvider())
          .add("headerProvider", getHeaderProvider())
          .add("internalHeaderProvider", getInternalHeaderProvider())
          .add("clock", getClock())
          .add("endpoint", getEndpoint())
          .add("quotaProjectId", getQuotaProjectId())
          .add("watchdogProvider", getWatchdogProvider())
          .add("watchdogCheckInterval", getWatchdogCheckIntervalDuration())
          .add("gdchApiAudience", getGdchApiAudience())
          .add("apiKey", getApiKey())
          .toString();
    }
  }
}
