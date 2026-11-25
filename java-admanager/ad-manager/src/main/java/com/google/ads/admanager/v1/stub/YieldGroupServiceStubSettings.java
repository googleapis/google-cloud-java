/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.YieldGroupServiceClient.ListYieldGroupsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateYieldGroupsRequest;
import com.google.ads.admanager.v1.BatchActivateYieldGroupsResponse;
import com.google.ads.admanager.v1.BatchArchiveYieldGroupsRequest;
import com.google.ads.admanager.v1.BatchArchiveYieldGroupsResponse;
import com.google.ads.admanager.v1.BatchCreateYieldGroupsRequest;
import com.google.ads.admanager.v1.BatchCreateYieldGroupsResponse;
import com.google.ads.admanager.v1.BatchDeactivateYieldGroupsRequest;
import com.google.ads.admanager.v1.BatchDeactivateYieldGroupsResponse;
import com.google.ads.admanager.v1.BatchUpdateYieldGroupsRequest;
import com.google.ads.admanager.v1.BatchUpdateYieldGroupsResponse;
import com.google.ads.admanager.v1.CreateYieldGroupRequest;
import com.google.ads.admanager.v1.GetYieldGroupRequest;
import com.google.ads.admanager.v1.ListYieldGroupsRequest;
import com.google.ads.admanager.v1.ListYieldGroupsResponse;
import com.google.ads.admanager.v1.UpdateYieldGroupRequest;
import com.google.ads.admanager.v1.YieldGroup;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
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
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link YieldGroupServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (admanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getYieldGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * YieldGroupServiceStubSettings.Builder yieldGroupServiceSettingsBuilder =
 *     YieldGroupServiceStubSettings.newBuilder();
 * yieldGroupServiceSettingsBuilder
 *     .getYieldGroupSettings()
 *     .setRetrySettings(
 *         yieldGroupServiceSettingsBuilder
 *             .getYieldGroupSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * YieldGroupServiceStubSettings yieldGroupServiceSettings =
 *     yieldGroupServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class YieldGroupServiceStubSettings extends StubSettings<YieldGroupServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/admanager")
          .add("https://www.googleapis.com/auth/admanager.readonly")
          .build();

  private final UnaryCallSettings<GetYieldGroupRequest, YieldGroup> getYieldGroupSettings;
  private final PagedCallSettings<
          ListYieldGroupsRequest, ListYieldGroupsResponse, ListYieldGroupsPagedResponse>
      listYieldGroupsSettings;
  private final UnaryCallSettings<CreateYieldGroupRequest, YieldGroup> createYieldGroupSettings;
  private final UnaryCallSettings<BatchCreateYieldGroupsRequest, BatchCreateYieldGroupsResponse>
      batchCreateYieldGroupsSettings;
  private final UnaryCallSettings<UpdateYieldGroupRequest, YieldGroup> updateYieldGroupSettings;
  private final UnaryCallSettings<BatchUpdateYieldGroupsRequest, BatchUpdateYieldGroupsResponse>
      batchUpdateYieldGroupsSettings;
  private final UnaryCallSettings<BatchActivateYieldGroupsRequest, BatchActivateYieldGroupsResponse>
      batchActivateYieldGroupsSettings;
  private final UnaryCallSettings<
          BatchDeactivateYieldGroupsRequest, BatchDeactivateYieldGroupsResponse>
      batchDeactivateYieldGroupsSettings;
  private final UnaryCallSettings<BatchArchiveYieldGroupsRequest, BatchArchiveYieldGroupsResponse>
      batchArchiveYieldGroupsSettings;

  private static final PagedListDescriptor<
          ListYieldGroupsRequest, ListYieldGroupsResponse, YieldGroup>
      LIST_YIELD_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListYieldGroupsRequest, ListYieldGroupsResponse, YieldGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListYieldGroupsRequest injectToken(
                ListYieldGroupsRequest payload, String token) {
              return ListYieldGroupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListYieldGroupsRequest injectPageSize(
                ListYieldGroupsRequest payload, int pageSize) {
              return ListYieldGroupsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListYieldGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListYieldGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<YieldGroup> extractResources(ListYieldGroupsResponse payload) {
              return payload.getYieldGroupsList();
            }
          };

  private static final PagedListResponseFactory<
          ListYieldGroupsRequest, ListYieldGroupsResponse, ListYieldGroupsPagedResponse>
      LIST_YIELD_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListYieldGroupsRequest, ListYieldGroupsResponse, ListYieldGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListYieldGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListYieldGroupsRequest, ListYieldGroupsResponse> callable,
                ListYieldGroupsRequest request,
                ApiCallContext context,
                ApiFuture<ListYieldGroupsResponse> futureResponse) {
              PageContext<ListYieldGroupsRequest, ListYieldGroupsResponse, YieldGroup> pageContext =
                  PageContext.create(callable, LIST_YIELD_GROUPS_PAGE_STR_DESC, request, context);
              return ListYieldGroupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getYieldGroup. */
  public UnaryCallSettings<GetYieldGroupRequest, YieldGroup> getYieldGroupSettings() {
    return getYieldGroupSettings;
  }

  /** Returns the object with the settings used for calls to listYieldGroups. */
  public PagedCallSettings<
          ListYieldGroupsRequest, ListYieldGroupsResponse, ListYieldGroupsPagedResponse>
      listYieldGroupsSettings() {
    return listYieldGroupsSettings;
  }

  /** Returns the object with the settings used for calls to createYieldGroup. */
  public UnaryCallSettings<CreateYieldGroupRequest, YieldGroup> createYieldGroupSettings() {
    return createYieldGroupSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateYieldGroups. */
  public UnaryCallSettings<BatchCreateYieldGroupsRequest, BatchCreateYieldGroupsResponse>
      batchCreateYieldGroupsSettings() {
    return batchCreateYieldGroupsSettings;
  }

  /** Returns the object with the settings used for calls to updateYieldGroup. */
  public UnaryCallSettings<UpdateYieldGroupRequest, YieldGroup> updateYieldGroupSettings() {
    return updateYieldGroupSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateYieldGroups. */
  public UnaryCallSettings<BatchUpdateYieldGroupsRequest, BatchUpdateYieldGroupsResponse>
      batchUpdateYieldGroupsSettings() {
    return batchUpdateYieldGroupsSettings;
  }

  /** Returns the object with the settings used for calls to batchActivateYieldGroups. */
  public UnaryCallSettings<BatchActivateYieldGroupsRequest, BatchActivateYieldGroupsResponse>
      batchActivateYieldGroupsSettings() {
    return batchActivateYieldGroupsSettings;
  }

  /** Returns the object with the settings used for calls to batchDeactivateYieldGroups. */
  public UnaryCallSettings<BatchDeactivateYieldGroupsRequest, BatchDeactivateYieldGroupsResponse>
      batchDeactivateYieldGroupsSettings() {
    return batchDeactivateYieldGroupsSettings;
  }

  /** Returns the object with the settings used for calls to batchArchiveYieldGroups. */
  public UnaryCallSettings<BatchArchiveYieldGroupsRequest, BatchArchiveYieldGroupsResponse>
      batchArchiveYieldGroupsSettings() {
    return batchArchiveYieldGroupsSettings;
  }

  public YieldGroupServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonYieldGroupServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "admanager";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "admanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "admanager.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(YieldGroupServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected YieldGroupServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getYieldGroupSettings = settingsBuilder.getYieldGroupSettings().build();
    listYieldGroupsSettings = settingsBuilder.listYieldGroupsSettings().build();
    createYieldGroupSettings = settingsBuilder.createYieldGroupSettings().build();
    batchCreateYieldGroupsSettings = settingsBuilder.batchCreateYieldGroupsSettings().build();
    updateYieldGroupSettings = settingsBuilder.updateYieldGroupSettings().build();
    batchUpdateYieldGroupsSettings = settingsBuilder.batchUpdateYieldGroupsSettings().build();
    batchActivateYieldGroupsSettings = settingsBuilder.batchActivateYieldGroupsSettings().build();
    batchDeactivateYieldGroupsSettings =
        settingsBuilder.batchDeactivateYieldGroupsSettings().build();
    batchArchiveYieldGroupsSettings = settingsBuilder.batchArchiveYieldGroupsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.api-ads:ad-manager")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for YieldGroupServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<YieldGroupServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetYieldGroupRequest, YieldGroup> getYieldGroupSettings;
    private final PagedCallSettings.Builder<
            ListYieldGroupsRequest, ListYieldGroupsResponse, ListYieldGroupsPagedResponse>
        listYieldGroupsSettings;
    private final UnaryCallSettings.Builder<CreateYieldGroupRequest, YieldGroup>
        createYieldGroupSettings;
    private final UnaryCallSettings.Builder<
            BatchCreateYieldGroupsRequest, BatchCreateYieldGroupsResponse>
        batchCreateYieldGroupsSettings;
    private final UnaryCallSettings.Builder<UpdateYieldGroupRequest, YieldGroup>
        updateYieldGroupSettings;
    private final UnaryCallSettings.Builder<
            BatchUpdateYieldGroupsRequest, BatchUpdateYieldGroupsResponse>
        batchUpdateYieldGroupsSettings;
    private final UnaryCallSettings.Builder<
            BatchActivateYieldGroupsRequest, BatchActivateYieldGroupsResponse>
        batchActivateYieldGroupsSettings;
    private final UnaryCallSettings.Builder<
            BatchDeactivateYieldGroupsRequest, BatchDeactivateYieldGroupsResponse>
        batchDeactivateYieldGroupsSettings;
    private final UnaryCallSettings.Builder<
            BatchArchiveYieldGroupsRequest, BatchArchiveYieldGroupsResponse>
        batchArchiveYieldGroupsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      getYieldGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listYieldGroupsSettings = PagedCallSettings.newBuilder(LIST_YIELD_GROUPS_PAGE_STR_FACT);
      createYieldGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateYieldGroupsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateYieldGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateYieldGroupsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchActivateYieldGroupsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeactivateYieldGroupsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchArchiveYieldGroupsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getYieldGroupSettings,
              listYieldGroupsSettings,
              createYieldGroupSettings,
              batchCreateYieldGroupsSettings,
              updateYieldGroupSettings,
              batchUpdateYieldGroupsSettings,
              batchActivateYieldGroupsSettings,
              batchDeactivateYieldGroupsSettings,
              batchArchiveYieldGroupsSettings);
      initDefaults(this);
    }

    protected Builder(YieldGroupServiceStubSettings settings) {
      super(settings);

      getYieldGroupSettings = settings.getYieldGroupSettings.toBuilder();
      listYieldGroupsSettings = settings.listYieldGroupsSettings.toBuilder();
      createYieldGroupSettings = settings.createYieldGroupSettings.toBuilder();
      batchCreateYieldGroupsSettings = settings.batchCreateYieldGroupsSettings.toBuilder();
      updateYieldGroupSettings = settings.updateYieldGroupSettings.toBuilder();
      batchUpdateYieldGroupsSettings = settings.batchUpdateYieldGroupsSettings.toBuilder();
      batchActivateYieldGroupsSettings = settings.batchActivateYieldGroupsSettings.toBuilder();
      batchDeactivateYieldGroupsSettings = settings.batchDeactivateYieldGroupsSettings.toBuilder();
      batchArchiveYieldGroupsSettings = settings.batchArchiveYieldGroupsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getYieldGroupSettings,
              listYieldGroupsSettings,
              createYieldGroupSettings,
              batchCreateYieldGroupsSettings,
              updateYieldGroupSettings,
              batchUpdateYieldGroupsSettings,
              batchActivateYieldGroupsSettings,
              batchDeactivateYieldGroupsSettings,
              batchArchiveYieldGroupsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .getYieldGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listYieldGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createYieldGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateYieldGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateYieldGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateYieldGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchActivateYieldGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchDeactivateYieldGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchArchiveYieldGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to getYieldGroup. */
    public UnaryCallSettings.Builder<GetYieldGroupRequest, YieldGroup> getYieldGroupSettings() {
      return getYieldGroupSettings;
    }

    /** Returns the builder for the settings used for calls to listYieldGroups. */
    public PagedCallSettings.Builder<
            ListYieldGroupsRequest, ListYieldGroupsResponse, ListYieldGroupsPagedResponse>
        listYieldGroupsSettings() {
      return listYieldGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to createYieldGroup. */
    public UnaryCallSettings.Builder<CreateYieldGroupRequest, YieldGroup>
        createYieldGroupSettings() {
      return createYieldGroupSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateYieldGroups. */
    public UnaryCallSettings.Builder<BatchCreateYieldGroupsRequest, BatchCreateYieldGroupsResponse>
        batchCreateYieldGroupsSettings() {
      return batchCreateYieldGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to updateYieldGroup. */
    public UnaryCallSettings.Builder<UpdateYieldGroupRequest, YieldGroup>
        updateYieldGroupSettings() {
      return updateYieldGroupSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateYieldGroups. */
    public UnaryCallSettings.Builder<BatchUpdateYieldGroupsRequest, BatchUpdateYieldGroupsResponse>
        batchUpdateYieldGroupsSettings() {
      return batchUpdateYieldGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to batchActivateYieldGroups. */
    public UnaryCallSettings.Builder<
            BatchActivateYieldGroupsRequest, BatchActivateYieldGroupsResponse>
        batchActivateYieldGroupsSettings() {
      return batchActivateYieldGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeactivateYieldGroups. */
    public UnaryCallSettings.Builder<
            BatchDeactivateYieldGroupsRequest, BatchDeactivateYieldGroupsResponse>
        batchDeactivateYieldGroupsSettings() {
      return batchDeactivateYieldGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to batchArchiveYieldGroups. */
    public UnaryCallSettings.Builder<
            BatchArchiveYieldGroupsRequest, BatchArchiveYieldGroupsResponse>
        batchArchiveYieldGroupsSettings() {
      return batchArchiveYieldGroupsSettings;
    }

    @Override
    public YieldGroupServiceStubSettings build() throws IOException {
      return new YieldGroupServiceStubSettings(this);
    }
  }
}
