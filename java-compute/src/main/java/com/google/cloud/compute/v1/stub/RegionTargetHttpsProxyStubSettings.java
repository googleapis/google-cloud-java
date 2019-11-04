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

import static com.google.cloud.compute.v1.RegionTargetHttpsProxyClient.ListRegionTargetHttpsProxiesPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.GetRegionTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.InsertRegionTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.ListRegionTargetHttpsProxiesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetSslCertificatesRegionTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.SetUrlMapRegionTargetHttpsProxyHttpRequest;
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
 * Settings class to configure an instance of {@link RegionTargetHttpsProxyStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://compute.googleapis.com/compute/v1/projects/) and
 *       default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of deleteRegionTargetHttpsProxy to 30 seconds:
 *
 * <pre>
 * <code>
 * RegionTargetHttpsProxyStubSettings.Builder regionTargetHttpsProxySettingsBuilder =
 *     RegionTargetHttpsProxyStubSettings.newBuilder();
 * regionTargetHttpsProxySettingsBuilder.deleteRegionTargetHttpsProxySettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * RegionTargetHttpsProxyStubSettings regionTargetHttpsProxySettings = regionTargetHttpsProxySettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionTargetHttpsProxyStubSettings
    extends StubSettings<RegionTargetHttpsProxyStubSettings> {
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

  private final UnaryCallSettings<DeleteRegionTargetHttpsProxyHttpRequest, Operation>
      deleteRegionTargetHttpsProxySettings;
  private final UnaryCallSettings<GetRegionTargetHttpsProxyHttpRequest, TargetHttpsProxy>
      getRegionTargetHttpsProxySettings;
  private final UnaryCallSettings<InsertRegionTargetHttpsProxyHttpRequest, Operation>
      insertRegionTargetHttpsProxySettings;
  private final PagedCallSettings<
          ListRegionTargetHttpsProxiesHttpRequest,
          TargetHttpsProxyList,
          ListRegionTargetHttpsProxiesPagedResponse>
      listRegionTargetHttpsProxiesSettings;
  private final UnaryCallSettings<SetSslCertificatesRegionTargetHttpsProxyHttpRequest, Operation>
      setSslCertificatesRegionTargetHttpsProxySettings;
  private final UnaryCallSettings<SetUrlMapRegionTargetHttpsProxyHttpRequest, Operation>
      setUrlMapRegionTargetHttpsProxySettings;

  /** Returns the object with the settings used for calls to deleteRegionTargetHttpsProxy. */
  public UnaryCallSettings<DeleteRegionTargetHttpsProxyHttpRequest, Operation>
      deleteRegionTargetHttpsProxySettings() {
    return deleteRegionTargetHttpsProxySettings;
  }

  /** Returns the object with the settings used for calls to getRegionTargetHttpsProxy. */
  public UnaryCallSettings<GetRegionTargetHttpsProxyHttpRequest, TargetHttpsProxy>
      getRegionTargetHttpsProxySettings() {
    return getRegionTargetHttpsProxySettings;
  }

  /** Returns the object with the settings used for calls to insertRegionTargetHttpsProxy. */
  public UnaryCallSettings<InsertRegionTargetHttpsProxyHttpRequest, Operation>
      insertRegionTargetHttpsProxySettings() {
    return insertRegionTargetHttpsProxySettings;
  }

  /** Returns the object with the settings used for calls to listRegionTargetHttpsProxies. */
  public PagedCallSettings<
          ListRegionTargetHttpsProxiesHttpRequest,
          TargetHttpsProxyList,
          ListRegionTargetHttpsProxiesPagedResponse>
      listRegionTargetHttpsProxiesSettings() {
    return listRegionTargetHttpsProxiesSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * setSslCertificatesRegionTargetHttpsProxy.
   */
  public UnaryCallSettings<SetSslCertificatesRegionTargetHttpsProxyHttpRequest, Operation>
      setSslCertificatesRegionTargetHttpsProxySettings() {
    return setSslCertificatesRegionTargetHttpsProxySettings;
  }

  /** Returns the object with the settings used for calls to setUrlMapRegionTargetHttpsProxy. */
  public UnaryCallSettings<SetUrlMapRegionTargetHttpsProxyHttpRequest, Operation>
      setUrlMapRegionTargetHttpsProxySettings() {
    return setUrlMapRegionTargetHttpsProxySettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionTargetHttpsProxyStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRegionTargetHttpsProxyStub.create(this);
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
    return "https://compute.googleapis.com/compute/v1/projects/";
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
            "gapic", GaxProperties.getLibraryVersion(RegionTargetHttpsProxyStubSettings.class))
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

  protected RegionTargetHttpsProxyStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    deleteRegionTargetHttpsProxySettings =
        settingsBuilder.deleteRegionTargetHttpsProxySettings().build();
    getRegionTargetHttpsProxySettings = settingsBuilder.getRegionTargetHttpsProxySettings().build();
    insertRegionTargetHttpsProxySettings =
        settingsBuilder.insertRegionTargetHttpsProxySettings().build();
    listRegionTargetHttpsProxiesSettings =
        settingsBuilder.listRegionTargetHttpsProxiesSettings().build();
    setSslCertificatesRegionTargetHttpsProxySettings =
        settingsBuilder.setSslCertificatesRegionTargetHttpsProxySettings().build();
    setUrlMapRegionTargetHttpsProxySettings =
        settingsBuilder.setUrlMapRegionTargetHttpsProxySettings().build();
  }

  private static final PagedListDescriptor<
          ListRegionTargetHttpsProxiesHttpRequest, TargetHttpsProxyList, TargetHttpsProxy>
      LIST_REGION_TARGET_HTTPS_PROXIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRegionTargetHttpsProxiesHttpRequest, TargetHttpsProxyList, TargetHttpsProxy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRegionTargetHttpsProxiesHttpRequest injectToken(
                ListRegionTargetHttpsProxiesHttpRequest payload, String token) {
              return ListRegionTargetHttpsProxiesHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListRegionTargetHttpsProxiesHttpRequest injectPageSize(
                ListRegionTargetHttpsProxiesHttpRequest payload, int pageSize) {
              return ListRegionTargetHttpsProxiesHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListRegionTargetHttpsProxiesHttpRequest payload) {
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
          ListRegionTargetHttpsProxiesHttpRequest,
          TargetHttpsProxyList,
          ListRegionTargetHttpsProxiesPagedResponse>
      LIST_REGION_TARGET_HTTPS_PROXIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRegionTargetHttpsProxiesHttpRequest,
              TargetHttpsProxyList,
              ListRegionTargetHttpsProxiesPagedResponse>() {
            @Override
            public ApiFuture<ListRegionTargetHttpsProxiesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRegionTargetHttpsProxiesHttpRequest, TargetHttpsProxyList>
                    callable,
                ListRegionTargetHttpsProxiesHttpRequest request,
                ApiCallContext context,
                ApiFuture<TargetHttpsProxyList> futureResponse) {
              PageContext<
                      ListRegionTargetHttpsProxiesHttpRequest,
                      TargetHttpsProxyList,
                      TargetHttpsProxy>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_REGION_TARGET_HTTPS_PROXIES_PAGE_STR_DESC,
                          request,
                          context);
              return ListRegionTargetHttpsProxiesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Builder for RegionTargetHttpsProxyStubSettings. */
  public static class Builder
      extends StubSettings.Builder<RegionTargetHttpsProxyStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<DeleteRegionTargetHttpsProxyHttpRequest, Operation>
        deleteRegionTargetHttpsProxySettings;
    private final UnaryCallSettings.Builder<GetRegionTargetHttpsProxyHttpRequest, TargetHttpsProxy>
        getRegionTargetHttpsProxySettings;
    private final UnaryCallSettings.Builder<InsertRegionTargetHttpsProxyHttpRequest, Operation>
        insertRegionTargetHttpsProxySettings;
    private final PagedCallSettings.Builder<
            ListRegionTargetHttpsProxiesHttpRequest,
            TargetHttpsProxyList,
            ListRegionTargetHttpsProxiesPagedResponse>
        listRegionTargetHttpsProxiesSettings;
    private final UnaryCallSettings.Builder<
            SetSslCertificatesRegionTargetHttpsProxyHttpRequest, Operation>
        setSslCertificatesRegionTargetHttpsProxySettings;
    private final UnaryCallSettings.Builder<SetUrlMapRegionTargetHttpsProxyHttpRequest, Operation>
        setUrlMapRegionTargetHttpsProxySettings;

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

      deleteRegionTargetHttpsProxySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getRegionTargetHttpsProxySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertRegionTargetHttpsProxySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listRegionTargetHttpsProxiesSettings =
          PagedCallSettings.newBuilder(LIST_REGION_TARGET_HTTPS_PROXIES_PAGE_STR_FACT);

      setSslCertificatesRegionTargetHttpsProxySettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();

      setUrlMapRegionTargetHttpsProxySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteRegionTargetHttpsProxySettings,
              getRegionTargetHttpsProxySettings,
              insertRegionTargetHttpsProxySettings,
              listRegionTargetHttpsProxiesSettings,
              setSslCertificatesRegionTargetHttpsProxySettings,
              setUrlMapRegionTargetHttpsProxySettings);

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
          .deleteRegionTargetHttpsProxySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getRegionTargetHttpsProxySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertRegionTargetHttpsProxySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listRegionTargetHttpsProxiesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setSslCertificatesRegionTargetHttpsProxySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setUrlMapRegionTargetHttpsProxySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(RegionTargetHttpsProxyStubSettings settings) {
      super(settings);

      deleteRegionTargetHttpsProxySettings =
          settings.deleteRegionTargetHttpsProxySettings.toBuilder();
      getRegionTargetHttpsProxySettings = settings.getRegionTargetHttpsProxySettings.toBuilder();
      insertRegionTargetHttpsProxySettings =
          settings.insertRegionTargetHttpsProxySettings.toBuilder();
      listRegionTargetHttpsProxiesSettings =
          settings.listRegionTargetHttpsProxiesSettings.toBuilder();
      setSslCertificatesRegionTargetHttpsProxySettings =
          settings.setSslCertificatesRegionTargetHttpsProxySettings.toBuilder();
      setUrlMapRegionTargetHttpsProxySettings =
          settings.setUrlMapRegionTargetHttpsProxySettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteRegionTargetHttpsProxySettings,
              getRegionTargetHttpsProxySettings,
              insertRegionTargetHttpsProxySettings,
              listRegionTargetHttpsProxiesSettings,
              setSslCertificatesRegionTargetHttpsProxySettings,
              setUrlMapRegionTargetHttpsProxySettings);
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

    /** Returns the builder for the settings used for calls to deleteRegionTargetHttpsProxy. */
    public UnaryCallSettings.Builder<DeleteRegionTargetHttpsProxyHttpRequest, Operation>
        deleteRegionTargetHttpsProxySettings() {
      return deleteRegionTargetHttpsProxySettings;
    }

    /** Returns the builder for the settings used for calls to getRegionTargetHttpsProxy. */
    public UnaryCallSettings.Builder<GetRegionTargetHttpsProxyHttpRequest, TargetHttpsProxy>
        getRegionTargetHttpsProxySettings() {
      return getRegionTargetHttpsProxySettings;
    }

    /** Returns the builder for the settings used for calls to insertRegionTargetHttpsProxy. */
    public UnaryCallSettings.Builder<InsertRegionTargetHttpsProxyHttpRequest, Operation>
        insertRegionTargetHttpsProxySettings() {
      return insertRegionTargetHttpsProxySettings;
    }

    /** Returns the builder for the settings used for calls to listRegionTargetHttpsProxies. */
    public PagedCallSettings.Builder<
            ListRegionTargetHttpsProxiesHttpRequest,
            TargetHttpsProxyList,
            ListRegionTargetHttpsProxiesPagedResponse>
        listRegionTargetHttpsProxiesSettings() {
      return listRegionTargetHttpsProxiesSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * setSslCertificatesRegionTargetHttpsProxy.
     */
    public UnaryCallSettings.Builder<SetSslCertificatesRegionTargetHttpsProxyHttpRequest, Operation>
        setSslCertificatesRegionTargetHttpsProxySettings() {
      return setSslCertificatesRegionTargetHttpsProxySettings;
    }

    /** Returns the builder for the settings used for calls to setUrlMapRegionTargetHttpsProxy. */
    public UnaryCallSettings.Builder<SetUrlMapRegionTargetHttpsProxyHttpRequest, Operation>
        setUrlMapRegionTargetHttpsProxySettings() {
      return setUrlMapRegionTargetHttpsProxySettings;
    }

    @Override
    public RegionTargetHttpsProxyStubSettings build() throws IOException {
      return new RegionTargetHttpsProxyStubSettings(this);
    }
  }
}
