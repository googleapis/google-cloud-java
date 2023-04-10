/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.retail.v2beta.stub;

import static com.google.cloud.retail.v2beta.CatalogServiceClient.ListCatalogsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
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
import com.google.cloud.retail.v2beta.AddCatalogAttributeRequest;
import com.google.cloud.retail.v2beta.AttributesConfig;
import com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesRequest;
import com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesResponse;
import com.google.cloud.retail.v2beta.Catalog;
import com.google.cloud.retail.v2beta.CompletionConfig;
import com.google.cloud.retail.v2beta.GetAttributesConfigRequest;
import com.google.cloud.retail.v2beta.GetCompletionConfigRequest;
import com.google.cloud.retail.v2beta.GetDefaultBranchRequest;
import com.google.cloud.retail.v2beta.GetDefaultBranchResponse;
import com.google.cloud.retail.v2beta.ListCatalogsRequest;
import com.google.cloud.retail.v2beta.ListCatalogsResponse;
import com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest;
import com.google.cloud.retail.v2beta.ReplaceCatalogAttributeRequest;
import com.google.cloud.retail.v2beta.SetDefaultBranchRequest;
import com.google.cloud.retail.v2beta.UpdateAttributesConfigRequest;
import com.google.cloud.retail.v2beta.UpdateCatalogRequest;
import com.google.cloud.retail.v2beta.UpdateCompletionConfigRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CatalogServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (retail.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of updateCatalog to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CatalogServiceStubSettings.Builder catalogServiceSettingsBuilder =
 *     CatalogServiceStubSettings.newBuilder();
 * catalogServiceSettingsBuilder
 *     .updateCatalogSettings()
 *     .setRetrySettings(
 *         catalogServiceSettingsBuilder
 *             .updateCatalogSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CatalogServiceStubSettings catalogServiceSettings = catalogServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class CatalogServiceStubSettings extends StubSettings<CatalogServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
      listCatalogsSettings;
  private final UnaryCallSettings<UpdateCatalogRequest, Catalog> updateCatalogSettings;
  private final UnaryCallSettings<SetDefaultBranchRequest, Empty> setDefaultBranchSettings;
  private final UnaryCallSettings<GetDefaultBranchRequest, GetDefaultBranchResponse>
      getDefaultBranchSettings;
  private final UnaryCallSettings<GetCompletionConfigRequest, CompletionConfig>
      getCompletionConfigSettings;
  private final UnaryCallSettings<UpdateCompletionConfigRequest, CompletionConfig>
      updateCompletionConfigSettings;
  private final UnaryCallSettings<GetAttributesConfigRequest, AttributesConfig>
      getAttributesConfigSettings;
  private final UnaryCallSettings<UpdateAttributesConfigRequest, AttributesConfig>
      updateAttributesConfigSettings;
  private final UnaryCallSettings<AddCatalogAttributeRequest, AttributesConfig>
      addCatalogAttributeSettings;
  private final UnaryCallSettings<RemoveCatalogAttributeRequest, AttributesConfig>
      removeCatalogAttributeSettings;
  private final UnaryCallSettings<
          BatchRemoveCatalogAttributesRequest, BatchRemoveCatalogAttributesResponse>
      batchRemoveCatalogAttributesSettings;
  private final UnaryCallSettings<ReplaceCatalogAttributeRequest, AttributesConfig>
      replaceCatalogAttributeSettings;

  private static final PagedListDescriptor<ListCatalogsRequest, ListCatalogsResponse, Catalog>
      LIST_CATALOGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListCatalogsRequest, ListCatalogsResponse, Catalog>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCatalogsRequest injectToken(ListCatalogsRequest payload, String token) {
              return ListCatalogsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCatalogsRequest injectPageSize(ListCatalogsRequest payload, int pageSize) {
              return ListCatalogsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCatalogsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCatalogsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Catalog> extractResources(ListCatalogsResponse payload) {
              return payload.getCatalogsList() == null
                  ? ImmutableList.<Catalog>of()
                  : payload.getCatalogsList();
            }
          };

  private static final PagedListResponseFactory<
          ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
      LIST_CATALOGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>() {
            @Override
            public ApiFuture<ListCatalogsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCatalogsRequest, ListCatalogsResponse> callable,
                ListCatalogsRequest request,
                ApiCallContext context,
                ApiFuture<ListCatalogsResponse> futureResponse) {
              PageContext<ListCatalogsRequest, ListCatalogsResponse, Catalog> pageContext =
                  PageContext.create(callable, LIST_CATALOGS_PAGE_STR_DESC, request, context);
              return ListCatalogsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listCatalogs. */
  public PagedCallSettings<ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
      listCatalogsSettings() {
    return listCatalogsSettings;
  }

  /** Returns the object with the settings used for calls to updateCatalog. */
  public UnaryCallSettings<UpdateCatalogRequest, Catalog> updateCatalogSettings() {
    return updateCatalogSettings;
  }

  /** Returns the object with the settings used for calls to setDefaultBranch. */
  public UnaryCallSettings<SetDefaultBranchRequest, Empty> setDefaultBranchSettings() {
    return setDefaultBranchSettings;
  }

  /** Returns the object with the settings used for calls to getDefaultBranch. */
  public UnaryCallSettings<GetDefaultBranchRequest, GetDefaultBranchResponse>
      getDefaultBranchSettings() {
    return getDefaultBranchSettings;
  }

  /** Returns the object with the settings used for calls to getCompletionConfig. */
  public UnaryCallSettings<GetCompletionConfigRequest, CompletionConfig>
      getCompletionConfigSettings() {
    return getCompletionConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateCompletionConfig. */
  public UnaryCallSettings<UpdateCompletionConfigRequest, CompletionConfig>
      updateCompletionConfigSettings() {
    return updateCompletionConfigSettings;
  }

  /** Returns the object with the settings used for calls to getAttributesConfig. */
  public UnaryCallSettings<GetAttributesConfigRequest, AttributesConfig>
      getAttributesConfigSettings() {
    return getAttributesConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateAttributesConfig. */
  public UnaryCallSettings<UpdateAttributesConfigRequest, AttributesConfig>
      updateAttributesConfigSettings() {
    return updateAttributesConfigSettings;
  }

  /** Returns the object with the settings used for calls to addCatalogAttribute. */
  public UnaryCallSettings<AddCatalogAttributeRequest, AttributesConfig>
      addCatalogAttributeSettings() {
    return addCatalogAttributeSettings;
  }

  /** Returns the object with the settings used for calls to removeCatalogAttribute. */
  public UnaryCallSettings<RemoveCatalogAttributeRequest, AttributesConfig>
      removeCatalogAttributeSettings() {
    return removeCatalogAttributeSettings;
  }

  /** Returns the object with the settings used for calls to batchRemoveCatalogAttributes. */
  public UnaryCallSettings<
          BatchRemoveCatalogAttributesRequest, BatchRemoveCatalogAttributesResponse>
      batchRemoveCatalogAttributesSettings() {
    return batchRemoveCatalogAttributesSettings;
  }

  /** Returns the object with the settings used for calls to replaceCatalogAttribute. */
  public UnaryCallSettings<ReplaceCatalogAttributeRequest, AttributesConfig>
      replaceCatalogAttributeSettings() {
    return replaceCatalogAttributeSettings;
  }

  public CatalogServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCatalogServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonCatalogServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "retail.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "retail.mtls.googleapis.com:443";
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

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CatalogServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CatalogServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CatalogServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected CatalogServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listCatalogsSettings = settingsBuilder.listCatalogsSettings().build();
    updateCatalogSettings = settingsBuilder.updateCatalogSettings().build();
    setDefaultBranchSettings = settingsBuilder.setDefaultBranchSettings().build();
    getDefaultBranchSettings = settingsBuilder.getDefaultBranchSettings().build();
    getCompletionConfigSettings = settingsBuilder.getCompletionConfigSettings().build();
    updateCompletionConfigSettings = settingsBuilder.updateCompletionConfigSettings().build();
    getAttributesConfigSettings = settingsBuilder.getAttributesConfigSettings().build();
    updateAttributesConfigSettings = settingsBuilder.updateAttributesConfigSettings().build();
    addCatalogAttributeSettings = settingsBuilder.addCatalogAttributeSettings().build();
    removeCatalogAttributeSettings = settingsBuilder.removeCatalogAttributeSettings().build();
    batchRemoveCatalogAttributesSettings =
        settingsBuilder.batchRemoveCatalogAttributesSettings().build();
    replaceCatalogAttributeSettings = settingsBuilder.replaceCatalogAttributeSettings().build();
  }

  /** Builder for CatalogServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<CatalogServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
        listCatalogsSettings;
    private final UnaryCallSettings.Builder<UpdateCatalogRequest, Catalog> updateCatalogSettings;
    private final UnaryCallSettings.Builder<SetDefaultBranchRequest, Empty>
        setDefaultBranchSettings;
    private final UnaryCallSettings.Builder<GetDefaultBranchRequest, GetDefaultBranchResponse>
        getDefaultBranchSettings;
    private final UnaryCallSettings.Builder<GetCompletionConfigRequest, CompletionConfig>
        getCompletionConfigSettings;
    private final UnaryCallSettings.Builder<UpdateCompletionConfigRequest, CompletionConfig>
        updateCompletionConfigSettings;
    private final UnaryCallSettings.Builder<GetAttributesConfigRequest, AttributesConfig>
        getAttributesConfigSettings;
    private final UnaryCallSettings.Builder<UpdateAttributesConfigRequest, AttributesConfig>
        updateAttributesConfigSettings;
    private final UnaryCallSettings.Builder<AddCatalogAttributeRequest, AttributesConfig>
        addCatalogAttributeSettings;
    private final UnaryCallSettings.Builder<RemoveCatalogAttributeRequest, AttributesConfig>
        removeCatalogAttributeSettings;
    private final UnaryCallSettings.Builder<
            BatchRemoveCatalogAttributesRequest, BatchRemoveCatalogAttributesResponse>
        batchRemoveCatalogAttributesSettings;
    private final UnaryCallSettings.Builder<ReplaceCatalogAttributeRequest, AttributesConfig>
        replaceCatalogAttributeSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
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
              .setMaxRetryDelay(Duration.ofMillis(5000L))
              .setInitialRpcTimeout(Duration.ofMillis(5000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(5000L))
              .setTotalTimeout(Duration.ofMillis(5000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listCatalogsSettings = PagedCallSettings.newBuilder(LIST_CATALOGS_PAGE_STR_FACT);
      updateCatalogSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setDefaultBranchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDefaultBranchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getCompletionConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCompletionConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAttributesConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAttributesConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addCatalogAttributeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeCatalogAttributeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchRemoveCatalogAttributesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      replaceCatalogAttributeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listCatalogsSettings,
              updateCatalogSettings,
              setDefaultBranchSettings,
              getDefaultBranchSettings,
              getCompletionConfigSettings,
              updateCompletionConfigSettings,
              getAttributesConfigSettings,
              updateAttributesConfigSettings,
              addCatalogAttributeSettings,
              removeCatalogAttributeSettings,
              batchRemoveCatalogAttributesSettings,
              replaceCatalogAttributeSettings);
      initDefaults(this);
    }

    protected Builder(CatalogServiceStubSettings settings) {
      super(settings);

      listCatalogsSettings = settings.listCatalogsSettings.toBuilder();
      updateCatalogSettings = settings.updateCatalogSettings.toBuilder();
      setDefaultBranchSettings = settings.setDefaultBranchSettings.toBuilder();
      getDefaultBranchSettings = settings.getDefaultBranchSettings.toBuilder();
      getCompletionConfigSettings = settings.getCompletionConfigSettings.toBuilder();
      updateCompletionConfigSettings = settings.updateCompletionConfigSettings.toBuilder();
      getAttributesConfigSettings = settings.getAttributesConfigSettings.toBuilder();
      updateAttributesConfigSettings = settings.updateAttributesConfigSettings.toBuilder();
      addCatalogAttributeSettings = settings.addCatalogAttributeSettings.toBuilder();
      removeCatalogAttributeSettings = settings.removeCatalogAttributeSettings.toBuilder();
      batchRemoveCatalogAttributesSettings =
          settings.batchRemoveCatalogAttributesSettings.toBuilder();
      replaceCatalogAttributeSettings = settings.replaceCatalogAttributeSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listCatalogsSettings,
              updateCatalogSettings,
              setDefaultBranchSettings,
              getDefaultBranchSettings,
              getCompletionConfigSettings,
              updateCompletionConfigSettings,
              getAttributesConfigSettings,
              updateAttributesConfigSettings,
              addCatalogAttributeSettings,
              removeCatalogAttributeSettings,
              batchRemoveCatalogAttributesSettings,
              replaceCatalogAttributeSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listCatalogsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateCatalogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setDefaultBranchSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDefaultBranchSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCompletionConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateCompletionConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAttributesConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateAttributesConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .addCatalogAttributeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .removeCatalogAttributeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchRemoveCatalogAttributesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .replaceCatalogAttributeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /** Returns the builder for the settings used for calls to listCatalogs. */
    public PagedCallSettings.Builder<
            ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
        listCatalogsSettings() {
      return listCatalogsSettings;
    }

    /** Returns the builder for the settings used for calls to updateCatalog. */
    public UnaryCallSettings.Builder<UpdateCatalogRequest, Catalog> updateCatalogSettings() {
      return updateCatalogSettings;
    }

    /** Returns the builder for the settings used for calls to setDefaultBranch. */
    public UnaryCallSettings.Builder<SetDefaultBranchRequest, Empty> setDefaultBranchSettings() {
      return setDefaultBranchSettings;
    }

    /** Returns the builder for the settings used for calls to getDefaultBranch. */
    public UnaryCallSettings.Builder<GetDefaultBranchRequest, GetDefaultBranchResponse>
        getDefaultBranchSettings() {
      return getDefaultBranchSettings;
    }

    /** Returns the builder for the settings used for calls to getCompletionConfig. */
    public UnaryCallSettings.Builder<GetCompletionConfigRequest, CompletionConfig>
        getCompletionConfigSettings() {
      return getCompletionConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateCompletionConfig. */
    public UnaryCallSettings.Builder<UpdateCompletionConfigRequest, CompletionConfig>
        updateCompletionConfigSettings() {
      return updateCompletionConfigSettings;
    }

    /** Returns the builder for the settings used for calls to getAttributesConfig. */
    public UnaryCallSettings.Builder<GetAttributesConfigRequest, AttributesConfig>
        getAttributesConfigSettings() {
      return getAttributesConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateAttributesConfig. */
    public UnaryCallSettings.Builder<UpdateAttributesConfigRequest, AttributesConfig>
        updateAttributesConfigSettings() {
      return updateAttributesConfigSettings;
    }

    /** Returns the builder for the settings used for calls to addCatalogAttribute. */
    public UnaryCallSettings.Builder<AddCatalogAttributeRequest, AttributesConfig>
        addCatalogAttributeSettings() {
      return addCatalogAttributeSettings;
    }

    /** Returns the builder for the settings used for calls to removeCatalogAttribute. */
    public UnaryCallSettings.Builder<RemoveCatalogAttributeRequest, AttributesConfig>
        removeCatalogAttributeSettings() {
      return removeCatalogAttributeSettings;
    }

    /** Returns the builder for the settings used for calls to batchRemoveCatalogAttributes. */
    public UnaryCallSettings.Builder<
            BatchRemoveCatalogAttributesRequest, BatchRemoveCatalogAttributesResponse>
        batchRemoveCatalogAttributesSettings() {
      return batchRemoveCatalogAttributesSettings;
    }

    /** Returns the builder for the settings used for calls to replaceCatalogAttribute. */
    public UnaryCallSettings.Builder<ReplaceCatalogAttributeRequest, AttributesConfig>
        replaceCatalogAttributeSettings() {
      return replaceCatalogAttributeSettings;
    }

    @Override
    public CatalogServiceStubSettings build() throws IOException {
      return new CatalogServiceStubSettings(this);
    }
  }
}
