/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.TargetHttpsProxyClient.ListTargetHttpsProxiesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.GetTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.InsertTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.ListTargetHttpsProxiesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetQuicOverrideTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.SetSslCertificatesTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.SetSslPolicyTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.SetUrlMapTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.TargetHttpsProxy;
import com.google.cloud.compute.v1.TargetHttpsProxyList;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link TargetHttpsProxyStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://www.googleapis.com/compute/v1/projects/) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of deleteTargetHttpsProxy to 30 seconds:
 *
 * <pre>
 * <code>
 * TargetHttpsProxyStubSettings.Builder targetHttpsProxySettingsBuilder =
 *     TargetHttpsProxyStubSettings.newBuilder();
 * targetHttpsProxySettingsBuilder.deleteTargetHttpsProxySettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * TargetHttpsProxyStubSettings targetHttpsProxySettings = targetHttpsProxySettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class TargetHttpsProxyStubSettings extends StubSettings<TargetHttpsProxyStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/compute.readonly")
          .add("https://www.googleapis.com/auth/devstorage.full_control")
          .add("https://www.googleapis.com/auth/devstorage.read_only")
          .add("https://www.googleapis.com/auth/devstorage.read_write")
          .build();

  private final UnaryCallSettings<DeleteTargetHttpsProxyHttpRequest, Operation>
      deleteTargetHttpsProxySettings;
  private final UnaryCallSettings<GetTargetHttpsProxyHttpRequest, TargetHttpsProxy>
      getTargetHttpsProxySettings;
  private final UnaryCallSettings<InsertTargetHttpsProxyHttpRequest, Operation>
      insertTargetHttpsProxySettings;
  private final PagedCallSettings<
          ListTargetHttpsProxiesHttpRequest,
          TargetHttpsProxyList,
          ListTargetHttpsProxiesPagedResponse>
      listTargetHttpsProxiesSettings;
  private final UnaryCallSettings<SetQuicOverrideTargetHttpsProxyHttpRequest, Operation>
      setQuicOverrideTargetHttpsProxySettings;
  private final UnaryCallSettings<SetSslCertificatesTargetHttpsProxyHttpRequest, Operation>
      setSslCertificatesTargetHttpsProxySettings;
  private final UnaryCallSettings<SetSslPolicyTargetHttpsProxyHttpRequest, Operation>
      setSslPolicyTargetHttpsProxySettings;
  private final UnaryCallSettings<SetUrlMapTargetHttpsProxyHttpRequest, Operation>
      setUrlMapTargetHttpsProxySettings;

  /** Returns the object with the settings used for calls to deleteTargetHttpsProxy. */
  public UnaryCallSettings<DeleteTargetHttpsProxyHttpRequest, Operation>
      deleteTargetHttpsProxySettings() {
    return deleteTargetHttpsProxySettings;
  }

  /** Returns the object with the settings used for calls to getTargetHttpsProxy. */
  public UnaryCallSettings<GetTargetHttpsProxyHttpRequest, TargetHttpsProxy>
      getTargetHttpsProxySettings() {
    return getTargetHttpsProxySettings;
  }

  /** Returns the object with the settings used for calls to insertTargetHttpsProxy. */
  public UnaryCallSettings<InsertTargetHttpsProxyHttpRequest, Operation>
      insertTargetHttpsProxySettings() {
    return insertTargetHttpsProxySettings;
  }

  /** Returns the object with the settings used for calls to listTargetHttpsProxies. */
  public PagedCallSettings<
          ListTargetHttpsProxiesHttpRequest,
          TargetHttpsProxyList,
          ListTargetHttpsProxiesPagedResponse>
      listTargetHttpsProxiesSettings() {
    return listTargetHttpsProxiesSettings;
  }

  /** Returns the object with the settings used for calls to setQuicOverrideTargetHttpsProxy. */
  public UnaryCallSettings<SetQuicOverrideTargetHttpsProxyHttpRequest, Operation>
      setQuicOverrideTargetHttpsProxySettings() {
    return setQuicOverrideTargetHttpsProxySettings;
  }

  /** Returns the object with the settings used for calls to setSslCertificatesTargetHttpsProxy. */
  public UnaryCallSettings<SetSslCertificatesTargetHttpsProxyHttpRequest, Operation>
      setSslCertificatesTargetHttpsProxySettings() {
    return setSslCertificatesTargetHttpsProxySettings;
  }

  /** Returns the object with the settings used for calls to setSslPolicyTargetHttpsProxy. */
  public UnaryCallSettings<SetSslPolicyTargetHttpsProxyHttpRequest, Operation>
      setSslPolicyTargetHttpsProxySettings() {
    return setSslPolicyTargetHttpsProxySettings;
  }

  /** Returns the object with the settings used for calls to setUrlMapTargetHttpsProxy. */
  public UnaryCallSettings<SetUrlMapTargetHttpsProxyHttpRequest, Operation>
      setUrlMapTargetHttpsProxySettings() {
    return setUrlMapTargetHttpsProxySettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TargetHttpsProxyStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonTargetHttpsProxyStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "https://www.googleapis.com/compute/v1/projects/";
  }

  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return 443;
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(TargetHttpsProxyStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected TargetHttpsProxyStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    deleteTargetHttpsProxySettings = settingsBuilder.deleteTargetHttpsProxySettings().build();
    getTargetHttpsProxySettings = settingsBuilder.getTargetHttpsProxySettings().build();
    insertTargetHttpsProxySettings = settingsBuilder.insertTargetHttpsProxySettings().build();
    listTargetHttpsProxiesSettings = settingsBuilder.listTargetHttpsProxiesSettings().build();
    setQuicOverrideTargetHttpsProxySettings =
        settingsBuilder.setQuicOverrideTargetHttpsProxySettings().build();
    setSslCertificatesTargetHttpsProxySettings =
        settingsBuilder.setSslCertificatesTargetHttpsProxySettings().build();
    setSslPolicyTargetHttpsProxySettings =
        settingsBuilder.setSslPolicyTargetHttpsProxySettings().build();
    setUrlMapTargetHttpsProxySettings = settingsBuilder.setUrlMapTargetHttpsProxySettings().build();
  }

  private static final PagedListDescriptor<
          ListTargetHttpsProxiesHttpRequest, TargetHttpsProxyList, TargetHttpsProxy>
      LIST_TARGET_HTTPS_PROXIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListTargetHttpsProxiesHttpRequest, TargetHttpsProxyList, TargetHttpsProxy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTargetHttpsProxiesHttpRequest injectToken(
                ListTargetHttpsProxiesHttpRequest payload, String token) {
              return ListTargetHttpsProxiesHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListTargetHttpsProxiesHttpRequest injectPageSize(
                ListTargetHttpsProxiesHttpRequest payload, int pageSize) {
              return ListTargetHttpsProxiesHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListTargetHttpsProxiesHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(TargetHttpsProxyList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TargetHttpsProxy> extractResources(TargetHttpsProxyList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<TargetHttpsProxy>of();
            }
          };

  private static final PagedListResponseFactory<
          ListTargetHttpsProxiesHttpRequest,
          TargetHttpsProxyList,
          ListTargetHttpsProxiesPagedResponse>
      LIST_TARGET_HTTPS_PROXIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTargetHttpsProxiesHttpRequest,
              TargetHttpsProxyList,
              ListTargetHttpsProxiesPagedResponse>() {
            @Override
            public ApiFuture<ListTargetHttpsProxiesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTargetHttpsProxiesHttpRequest, TargetHttpsProxyList> callable,
                ListTargetHttpsProxiesHttpRequest request,
                ApiCallContext context,
                ApiFuture<TargetHttpsProxyList> futureResponse) {
              PageContext<ListTargetHttpsProxiesHttpRequest, TargetHttpsProxyList, TargetHttpsProxy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_TARGET_HTTPS_PROXIES_PAGE_STR_DESC, request, context);
              return ListTargetHttpsProxiesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for TargetHttpsProxyStubSettings. */
  public static class Builder extends StubSettings.Builder<TargetHttpsProxyStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<DeleteTargetHttpsProxyHttpRequest, Operation>
        deleteTargetHttpsProxySettings;
    private final UnaryCallSettings.Builder<GetTargetHttpsProxyHttpRequest, TargetHttpsProxy>
        getTargetHttpsProxySettings;
    private final UnaryCallSettings.Builder<InsertTargetHttpsProxyHttpRequest, Operation>
        insertTargetHttpsProxySettings;
    private final PagedCallSettings.Builder<
            ListTargetHttpsProxiesHttpRequest,
            TargetHttpsProxyList,
            ListTargetHttpsProxiesPagedResponse>
        listTargetHttpsProxiesSettings;
    private final UnaryCallSettings.Builder<SetQuicOverrideTargetHttpsProxyHttpRequest, Operation>
        setQuicOverrideTargetHttpsProxySettings;
    private final UnaryCallSettings.Builder<
            SetSslCertificatesTargetHttpsProxyHttpRequest, Operation>
        setSslCertificatesTargetHttpsProxySettings;
    private final UnaryCallSettings.Builder<SetSslPolicyTargetHttpsProxyHttpRequest, Operation>
        setSslPolicyTargetHttpsProxySettings;
    private final UnaryCallSettings.Builder<SetUrlMapTargetHttpsProxyHttpRequest, Operation>
        setUrlMapTargetHttpsProxySettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      deleteTargetHttpsProxySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getTargetHttpsProxySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertTargetHttpsProxySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listTargetHttpsProxiesSettings =
          PagedCallSettings.newBuilder(LIST_TARGET_HTTPS_PROXIES_PAGE_STR_FACT);

      setQuicOverrideTargetHttpsProxySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setSslCertificatesTargetHttpsProxySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setSslPolicyTargetHttpsProxySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setUrlMapTargetHttpsProxySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteTargetHttpsProxySettings,
              getTargetHttpsProxySettings,
              insertTargetHttpsProxySettings,
              listTargetHttpsProxiesSettings,
              setQuicOverrideTargetHttpsProxySettings,
              setSslCertificatesTargetHttpsProxySettings,
              setSslPolicyTargetHttpsProxySettings,
              setUrlMapTargetHttpsProxySettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .deleteTargetHttpsProxySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getTargetHttpsProxySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertTargetHttpsProxySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listTargetHttpsProxiesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setQuicOverrideTargetHttpsProxySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setSslCertificatesTargetHttpsProxySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setSslPolicyTargetHttpsProxySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setUrlMapTargetHttpsProxySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(TargetHttpsProxyStubSettings settings) {
      super(settings);

      deleteTargetHttpsProxySettings = settings.deleteTargetHttpsProxySettings.toBuilder();
      getTargetHttpsProxySettings = settings.getTargetHttpsProxySettings.toBuilder();
      insertTargetHttpsProxySettings = settings.insertTargetHttpsProxySettings.toBuilder();
      listTargetHttpsProxiesSettings = settings.listTargetHttpsProxiesSettings.toBuilder();
      setQuicOverrideTargetHttpsProxySettings =
          settings.setQuicOverrideTargetHttpsProxySettings.toBuilder();
      setSslCertificatesTargetHttpsProxySettings =
          settings.setSslCertificatesTargetHttpsProxySettings.toBuilder();
      setSslPolicyTargetHttpsProxySettings =
          settings.setSslPolicyTargetHttpsProxySettings.toBuilder();
      setUrlMapTargetHttpsProxySettings = settings.setUrlMapTargetHttpsProxySettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteTargetHttpsProxySettings,
              getTargetHttpsProxySettings,
              insertTargetHttpsProxySettings,
              listTargetHttpsProxiesSettings,
              setQuicOverrideTargetHttpsProxySettings,
              setSslCertificatesTargetHttpsProxySettings,
              setSslPolicyTargetHttpsProxySettings,
              setUrlMapTargetHttpsProxySettings);
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to deleteTargetHttpsProxy. */
    public UnaryCallSettings.Builder<DeleteTargetHttpsProxyHttpRequest, Operation>
        deleteTargetHttpsProxySettings() {
      return deleteTargetHttpsProxySettings;
    }

    /** Returns the builder for the settings used for calls to getTargetHttpsProxy. */
    public UnaryCallSettings.Builder<GetTargetHttpsProxyHttpRequest, TargetHttpsProxy>
        getTargetHttpsProxySettings() {
      return getTargetHttpsProxySettings;
    }

    /** Returns the builder for the settings used for calls to insertTargetHttpsProxy. */
    public UnaryCallSettings.Builder<InsertTargetHttpsProxyHttpRequest, Operation>
        insertTargetHttpsProxySettings() {
      return insertTargetHttpsProxySettings;
    }

    /** Returns the builder for the settings used for calls to listTargetHttpsProxies. */
    public PagedCallSettings.Builder<
            ListTargetHttpsProxiesHttpRequest,
            TargetHttpsProxyList,
            ListTargetHttpsProxiesPagedResponse>
        listTargetHttpsProxiesSettings() {
      return listTargetHttpsProxiesSettings;
    }

    /** Returns the builder for the settings used for calls to setQuicOverrideTargetHttpsProxy. */
    public UnaryCallSettings.Builder<SetQuicOverrideTargetHttpsProxyHttpRequest, Operation>
        setQuicOverrideTargetHttpsProxySettings() {
      return setQuicOverrideTargetHttpsProxySettings;
    }

    /**
     * Returns the builder for the settings used for calls to setSslCertificatesTargetHttpsProxy.
     */
    public UnaryCallSettings.Builder<SetSslCertificatesTargetHttpsProxyHttpRequest, Operation>
        setSslCertificatesTargetHttpsProxySettings() {
      return setSslCertificatesTargetHttpsProxySettings;
    }

    /** Returns the builder for the settings used for calls to setSslPolicyTargetHttpsProxy. */
    public UnaryCallSettings.Builder<SetSslPolicyTargetHttpsProxyHttpRequest, Operation>
        setSslPolicyTargetHttpsProxySettings() {
      return setSslPolicyTargetHttpsProxySettings;
    }

    /** Returns the builder for the settings used for calls to setUrlMapTargetHttpsProxy. */
    public UnaryCallSettings.Builder<SetUrlMapTargetHttpsProxyHttpRequest, Operation>
        setUrlMapTargetHttpsProxySettings() {
      return setUrlMapTargetHttpsProxySettings;
    }

    @Override
    public TargetHttpsProxyStubSettings build() throws IOException {
      return new TargetHttpsProxyStubSettings(this);
    }
  }
}
