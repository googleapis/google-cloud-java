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

import static com.google.ads.admanager.v1.LineItemCreativeAssociationServiceClient.ListLineItemCreativeAssociationsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateLineItemCreativeAssociationsRequest;
import com.google.ads.admanager.v1.BatchActivateLineItemCreativeAssociationsResponse;
import com.google.ads.admanager.v1.BatchCreateLineItemCreativeAssociationsRequest;
import com.google.ads.admanager.v1.BatchCreateLineItemCreativeAssociationsResponse;
import com.google.ads.admanager.v1.BatchDeactivateLineItemCreativeAssociationsRequest;
import com.google.ads.admanager.v1.BatchDeactivateLineItemCreativeAssociationsResponse;
import com.google.ads.admanager.v1.BatchDeleteLineItemCreativeAssociationsRequest;
import com.google.ads.admanager.v1.BatchUpdateLineItemCreativeAssociationsRequest;
import com.google.ads.admanager.v1.BatchUpdateLineItemCreativeAssociationsResponse;
import com.google.ads.admanager.v1.CreateLineItemCreativeAssociationRequest;
import com.google.ads.admanager.v1.GetLineItemCreativeAssociationRequest;
import com.google.ads.admanager.v1.LineItemCreativeAssociation;
import com.google.ads.admanager.v1.ListLineItemCreativeAssociationsRequest;
import com.google.ads.admanager.v1.ListLineItemCreativeAssociationsResponse;
import com.google.ads.admanager.v1.PreviewLineItemCreativeAssociationRequest;
import com.google.ads.admanager.v1.PreviewLineItemCreativeAssociationResponse;
import com.google.ads.admanager.v1.UpdateLineItemCreativeAssociationRequest;
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
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link LineItemCreativeAssociationServiceStub}.
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
 * of getLineItemCreativeAssociation:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LineItemCreativeAssociationServiceStubSettings.Builder
 *     lineItemCreativeAssociationServiceSettingsBuilder =
 *         LineItemCreativeAssociationServiceStubSettings.newBuilder();
 * lineItemCreativeAssociationServiceSettingsBuilder
 *     .getLineItemCreativeAssociationSettings()
 *     .setRetrySettings(
 *         lineItemCreativeAssociationServiceSettingsBuilder
 *             .getLineItemCreativeAssociationSettings()
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
 * LineItemCreativeAssociationServiceStubSettings lineItemCreativeAssociationServiceSettings =
 *     lineItemCreativeAssociationServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class LineItemCreativeAssociationServiceStubSettings
    extends StubSettings<LineItemCreativeAssociationServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/admanager")
          .add("https://www.googleapis.com/auth/admanager.readonly")
          .build();

  private final UnaryCallSettings<
          GetLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      getLineItemCreativeAssociationSettings;
  private final PagedCallSettings<
          ListLineItemCreativeAssociationsRequest,
          ListLineItemCreativeAssociationsResponse,
          ListLineItemCreativeAssociationsPagedResponse>
      listLineItemCreativeAssociationsSettings;
  private final UnaryCallSettings<
          CreateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      createLineItemCreativeAssociationSettings;
  private final UnaryCallSettings<
          BatchCreateLineItemCreativeAssociationsRequest,
          BatchCreateLineItemCreativeAssociationsResponse>
      batchCreateLineItemCreativeAssociationsSettings;
  private final UnaryCallSettings<
          UpdateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      updateLineItemCreativeAssociationSettings;
  private final UnaryCallSettings<
          BatchUpdateLineItemCreativeAssociationsRequest,
          BatchUpdateLineItemCreativeAssociationsResponse>
      batchUpdateLineItemCreativeAssociationsSettings;
  private final UnaryCallSettings<
          BatchActivateLineItemCreativeAssociationsRequest,
          BatchActivateLineItemCreativeAssociationsResponse>
      batchActivateLineItemCreativeAssociationsSettings;
  private final UnaryCallSettings<
          BatchDeactivateLineItemCreativeAssociationsRequest,
          BatchDeactivateLineItemCreativeAssociationsResponse>
      batchDeactivateLineItemCreativeAssociationsSettings;
  private final UnaryCallSettings<BatchDeleteLineItemCreativeAssociationsRequest, Empty>
      batchDeleteLineItemCreativeAssociationsSettings;
  private final UnaryCallSettings<
          PreviewLineItemCreativeAssociationRequest, PreviewLineItemCreativeAssociationResponse>
      previewLineItemCreativeAssociationSettings;

  private static final PagedListDescriptor<
          ListLineItemCreativeAssociationsRequest,
          ListLineItemCreativeAssociationsResponse,
          LineItemCreativeAssociation>
      LIST_LINE_ITEM_CREATIVE_ASSOCIATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListLineItemCreativeAssociationsRequest,
              ListLineItemCreativeAssociationsResponse,
              LineItemCreativeAssociation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLineItemCreativeAssociationsRequest injectToken(
                ListLineItemCreativeAssociationsRequest payload, String token) {
              return ListLineItemCreativeAssociationsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListLineItemCreativeAssociationsRequest injectPageSize(
                ListLineItemCreativeAssociationsRequest payload, int pageSize) {
              return ListLineItemCreativeAssociationsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListLineItemCreativeAssociationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLineItemCreativeAssociationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LineItemCreativeAssociation> extractResources(
                ListLineItemCreativeAssociationsResponse payload) {
              return payload.getLineItemCreativeAssociationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListLineItemCreativeAssociationsRequest,
          ListLineItemCreativeAssociationsResponse,
          ListLineItemCreativeAssociationsPagedResponse>
      LIST_LINE_ITEM_CREATIVE_ASSOCIATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLineItemCreativeAssociationsRequest,
              ListLineItemCreativeAssociationsResponse,
              ListLineItemCreativeAssociationsPagedResponse>() {
            @Override
            public ApiFuture<ListLineItemCreativeAssociationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListLineItemCreativeAssociationsRequest,
                        ListLineItemCreativeAssociationsResponse>
                    callable,
                ListLineItemCreativeAssociationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLineItemCreativeAssociationsResponse> futureResponse) {
              PageContext<
                      ListLineItemCreativeAssociationsRequest,
                      ListLineItemCreativeAssociationsResponse,
                      LineItemCreativeAssociation>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_LINE_ITEM_CREATIVE_ASSOCIATIONS_PAGE_STR_DESC,
                          request,
                          context);
              return ListLineItemCreativeAssociationsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getLineItemCreativeAssociation. */
  public UnaryCallSettings<GetLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      getLineItemCreativeAssociationSettings() {
    return getLineItemCreativeAssociationSettings;
  }

  /** Returns the object with the settings used for calls to listLineItemCreativeAssociations. */
  public PagedCallSettings<
          ListLineItemCreativeAssociationsRequest,
          ListLineItemCreativeAssociationsResponse,
          ListLineItemCreativeAssociationsPagedResponse>
      listLineItemCreativeAssociationsSettings() {
    return listLineItemCreativeAssociationsSettings;
  }

  /** Returns the object with the settings used for calls to createLineItemCreativeAssociation. */
  public UnaryCallSettings<CreateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      createLineItemCreativeAssociationSettings() {
    return createLineItemCreativeAssociationSettings;
  }

  /**
   * Returns the object with the settings used for calls to batchCreateLineItemCreativeAssociations.
   */
  public UnaryCallSettings<
          BatchCreateLineItemCreativeAssociationsRequest,
          BatchCreateLineItemCreativeAssociationsResponse>
      batchCreateLineItemCreativeAssociationsSettings() {
    return batchCreateLineItemCreativeAssociationsSettings;
  }

  /** Returns the object with the settings used for calls to updateLineItemCreativeAssociation. */
  public UnaryCallSettings<UpdateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      updateLineItemCreativeAssociationSettings() {
    return updateLineItemCreativeAssociationSettings;
  }

  /**
   * Returns the object with the settings used for calls to batchUpdateLineItemCreativeAssociations.
   */
  public UnaryCallSettings<
          BatchUpdateLineItemCreativeAssociationsRequest,
          BatchUpdateLineItemCreativeAssociationsResponse>
      batchUpdateLineItemCreativeAssociationsSettings() {
    return batchUpdateLineItemCreativeAssociationsSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * batchActivateLineItemCreativeAssociations.
   */
  public UnaryCallSettings<
          BatchActivateLineItemCreativeAssociationsRequest,
          BatchActivateLineItemCreativeAssociationsResponse>
      batchActivateLineItemCreativeAssociationsSettings() {
    return batchActivateLineItemCreativeAssociationsSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * batchDeactivateLineItemCreativeAssociations.
   */
  public UnaryCallSettings<
          BatchDeactivateLineItemCreativeAssociationsRequest,
          BatchDeactivateLineItemCreativeAssociationsResponse>
      batchDeactivateLineItemCreativeAssociationsSettings() {
    return batchDeactivateLineItemCreativeAssociationsSettings;
  }

  /**
   * Returns the object with the settings used for calls to batchDeleteLineItemCreativeAssociations.
   */
  public UnaryCallSettings<BatchDeleteLineItemCreativeAssociationsRequest, Empty>
      batchDeleteLineItemCreativeAssociationsSettings() {
    return batchDeleteLineItemCreativeAssociationsSettings;
  }

  /** Returns the object with the settings used for calls to previewLineItemCreativeAssociation. */
  public UnaryCallSettings<
          PreviewLineItemCreativeAssociationRequest, PreviewLineItemCreativeAssociationResponse>
      previewLineItemCreativeAssociationSettings() {
    return previewLineItemCreativeAssociationSettings;
  }

  public LineItemCreativeAssociationServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonLineItemCreativeAssociationServiceStub.create(this);
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
            "gapic",
            GaxProperties.getLibraryVersion(LineItemCreativeAssociationServiceStubSettings.class))
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

  protected LineItemCreativeAssociationServiceStubSettings(Builder settingsBuilder)
      throws IOException {
    super(settingsBuilder);

    getLineItemCreativeAssociationSettings =
        settingsBuilder.getLineItemCreativeAssociationSettings().build();
    listLineItemCreativeAssociationsSettings =
        settingsBuilder.listLineItemCreativeAssociationsSettings().build();
    createLineItemCreativeAssociationSettings =
        settingsBuilder.createLineItemCreativeAssociationSettings().build();
    batchCreateLineItemCreativeAssociationsSettings =
        settingsBuilder.batchCreateLineItemCreativeAssociationsSettings().build();
    updateLineItemCreativeAssociationSettings =
        settingsBuilder.updateLineItemCreativeAssociationSettings().build();
    batchUpdateLineItemCreativeAssociationsSettings =
        settingsBuilder.batchUpdateLineItemCreativeAssociationsSettings().build();
    batchActivateLineItemCreativeAssociationsSettings =
        settingsBuilder.batchActivateLineItemCreativeAssociationsSettings().build();
    batchDeactivateLineItemCreativeAssociationsSettings =
        settingsBuilder.batchDeactivateLineItemCreativeAssociationsSettings().build();
    batchDeleteLineItemCreativeAssociationsSettings =
        settingsBuilder.batchDeleteLineItemCreativeAssociationsSettings().build();
    previewLineItemCreativeAssociationSettings =
        settingsBuilder.previewLineItemCreativeAssociationSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.api-ads:ad-manager")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for LineItemCreativeAssociationServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<LineItemCreativeAssociationServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            GetLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
        getLineItemCreativeAssociationSettings;
    private final PagedCallSettings.Builder<
            ListLineItemCreativeAssociationsRequest,
            ListLineItemCreativeAssociationsResponse,
            ListLineItemCreativeAssociationsPagedResponse>
        listLineItemCreativeAssociationsSettings;
    private final UnaryCallSettings.Builder<
            CreateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
        createLineItemCreativeAssociationSettings;
    private final UnaryCallSettings.Builder<
            BatchCreateLineItemCreativeAssociationsRequest,
            BatchCreateLineItemCreativeAssociationsResponse>
        batchCreateLineItemCreativeAssociationsSettings;
    private final UnaryCallSettings.Builder<
            UpdateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
        updateLineItemCreativeAssociationSettings;
    private final UnaryCallSettings.Builder<
            BatchUpdateLineItemCreativeAssociationsRequest,
            BatchUpdateLineItemCreativeAssociationsResponse>
        batchUpdateLineItemCreativeAssociationsSettings;
    private final UnaryCallSettings.Builder<
            BatchActivateLineItemCreativeAssociationsRequest,
            BatchActivateLineItemCreativeAssociationsResponse>
        batchActivateLineItemCreativeAssociationsSettings;
    private final UnaryCallSettings.Builder<
            BatchDeactivateLineItemCreativeAssociationsRequest,
            BatchDeactivateLineItemCreativeAssociationsResponse>
        batchDeactivateLineItemCreativeAssociationsSettings;
    private final UnaryCallSettings.Builder<BatchDeleteLineItemCreativeAssociationsRequest, Empty>
        batchDeleteLineItemCreativeAssociationsSettings;
    private final UnaryCallSettings.Builder<
            PreviewLineItemCreativeAssociationRequest, PreviewLineItemCreativeAssociationResponse>
        previewLineItemCreativeAssociationSettings;
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

      getLineItemCreativeAssociationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLineItemCreativeAssociationsSettings =
          PagedCallSettings.newBuilder(LIST_LINE_ITEM_CREATIVE_ASSOCIATIONS_PAGE_STR_FACT);
      createLineItemCreativeAssociationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateLineItemCreativeAssociationsSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateLineItemCreativeAssociationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateLineItemCreativeAssociationsSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchActivateLineItemCreativeAssociationsSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeactivateLineItemCreativeAssociationsSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeleteLineItemCreativeAssociationsSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      previewLineItemCreativeAssociationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getLineItemCreativeAssociationSettings,
              listLineItemCreativeAssociationsSettings,
              createLineItemCreativeAssociationSettings,
              batchCreateLineItemCreativeAssociationsSettings,
              updateLineItemCreativeAssociationSettings,
              batchUpdateLineItemCreativeAssociationsSettings,
              batchActivateLineItemCreativeAssociationsSettings,
              batchDeactivateLineItemCreativeAssociationsSettings,
              batchDeleteLineItemCreativeAssociationsSettings,
              previewLineItemCreativeAssociationSettings);
      initDefaults(this);
    }

    protected Builder(LineItemCreativeAssociationServiceStubSettings settings) {
      super(settings);

      getLineItemCreativeAssociationSettings =
          settings.getLineItemCreativeAssociationSettings.toBuilder();
      listLineItemCreativeAssociationsSettings =
          settings.listLineItemCreativeAssociationsSettings.toBuilder();
      createLineItemCreativeAssociationSettings =
          settings.createLineItemCreativeAssociationSettings.toBuilder();
      batchCreateLineItemCreativeAssociationsSettings =
          settings.batchCreateLineItemCreativeAssociationsSettings.toBuilder();
      updateLineItemCreativeAssociationSettings =
          settings.updateLineItemCreativeAssociationSettings.toBuilder();
      batchUpdateLineItemCreativeAssociationsSettings =
          settings.batchUpdateLineItemCreativeAssociationsSettings.toBuilder();
      batchActivateLineItemCreativeAssociationsSettings =
          settings.batchActivateLineItemCreativeAssociationsSettings.toBuilder();
      batchDeactivateLineItemCreativeAssociationsSettings =
          settings.batchDeactivateLineItemCreativeAssociationsSettings.toBuilder();
      batchDeleteLineItemCreativeAssociationsSettings =
          settings.batchDeleteLineItemCreativeAssociationsSettings.toBuilder();
      previewLineItemCreativeAssociationSettings =
          settings.previewLineItemCreativeAssociationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getLineItemCreativeAssociationSettings,
              listLineItemCreativeAssociationsSettings,
              createLineItemCreativeAssociationSettings,
              batchCreateLineItemCreativeAssociationsSettings,
              updateLineItemCreativeAssociationSettings,
              batchUpdateLineItemCreativeAssociationsSettings,
              batchActivateLineItemCreativeAssociationsSettings,
              batchDeactivateLineItemCreativeAssociationsSettings,
              batchDeleteLineItemCreativeAssociationsSettings,
              previewLineItemCreativeAssociationSettings);
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
          .getLineItemCreativeAssociationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLineItemCreativeAssociationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createLineItemCreativeAssociationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateLineItemCreativeAssociationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateLineItemCreativeAssociationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateLineItemCreativeAssociationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchActivateLineItemCreativeAssociationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchDeactivateLineItemCreativeAssociationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchDeleteLineItemCreativeAssociationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .previewLineItemCreativeAssociationSettings()
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

    /** Returns the builder for the settings used for calls to getLineItemCreativeAssociation. */
    public UnaryCallSettings.Builder<
            GetLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
        getLineItemCreativeAssociationSettings() {
      return getLineItemCreativeAssociationSettings;
    }

    /** Returns the builder for the settings used for calls to listLineItemCreativeAssociations. */
    public PagedCallSettings.Builder<
            ListLineItemCreativeAssociationsRequest,
            ListLineItemCreativeAssociationsResponse,
            ListLineItemCreativeAssociationsPagedResponse>
        listLineItemCreativeAssociationsSettings() {
      return listLineItemCreativeAssociationsSettings;
    }

    /** Returns the builder for the settings used for calls to createLineItemCreativeAssociation. */
    public UnaryCallSettings.Builder<
            CreateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
        createLineItemCreativeAssociationSettings() {
      return createLineItemCreativeAssociationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * batchCreateLineItemCreativeAssociations.
     */
    public UnaryCallSettings.Builder<
            BatchCreateLineItemCreativeAssociationsRequest,
            BatchCreateLineItemCreativeAssociationsResponse>
        batchCreateLineItemCreativeAssociationsSettings() {
      return batchCreateLineItemCreativeAssociationsSettings;
    }

    /** Returns the builder for the settings used for calls to updateLineItemCreativeAssociation. */
    public UnaryCallSettings.Builder<
            UpdateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
        updateLineItemCreativeAssociationSettings() {
      return updateLineItemCreativeAssociationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * batchUpdateLineItemCreativeAssociations.
     */
    public UnaryCallSettings.Builder<
            BatchUpdateLineItemCreativeAssociationsRequest,
            BatchUpdateLineItemCreativeAssociationsResponse>
        batchUpdateLineItemCreativeAssociationsSettings() {
      return batchUpdateLineItemCreativeAssociationsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * batchActivateLineItemCreativeAssociations.
     */
    public UnaryCallSettings.Builder<
            BatchActivateLineItemCreativeAssociationsRequest,
            BatchActivateLineItemCreativeAssociationsResponse>
        batchActivateLineItemCreativeAssociationsSettings() {
      return batchActivateLineItemCreativeAssociationsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * batchDeactivateLineItemCreativeAssociations.
     */
    public UnaryCallSettings.Builder<
            BatchDeactivateLineItemCreativeAssociationsRequest,
            BatchDeactivateLineItemCreativeAssociationsResponse>
        batchDeactivateLineItemCreativeAssociationsSettings() {
      return batchDeactivateLineItemCreativeAssociationsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * batchDeleteLineItemCreativeAssociations.
     */
    public UnaryCallSettings.Builder<BatchDeleteLineItemCreativeAssociationsRequest, Empty>
        batchDeleteLineItemCreativeAssociationsSettings() {
      return batchDeleteLineItemCreativeAssociationsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to previewLineItemCreativeAssociation.
     */
    public UnaryCallSettings.Builder<
            PreviewLineItemCreativeAssociationRequest, PreviewLineItemCreativeAssociationResponse>
        previewLineItemCreativeAssociationSettings() {
      return previewLineItemCreativeAssociationSettings;
    }

    @Override
    public LineItemCreativeAssociationServiceStubSettings build() throws IOException {
      return new LineItemCreativeAssociationServiceStubSettings(this);
    }
  }
}
