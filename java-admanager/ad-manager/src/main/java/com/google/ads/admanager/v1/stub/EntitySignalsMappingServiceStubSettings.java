/*
 * Copyright 2025 Google LLC
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

import static com.google.ads.admanager.v1.EntitySignalsMappingServiceClient.ListEntitySignalsMappingsPagedResponse;

import com.google.ads.admanager.v1.BatchCreateEntitySignalsMappingsRequest;
import com.google.ads.admanager.v1.BatchCreateEntitySignalsMappingsResponse;
import com.google.ads.admanager.v1.BatchUpdateEntitySignalsMappingsRequest;
import com.google.ads.admanager.v1.BatchUpdateEntitySignalsMappingsResponse;
import com.google.ads.admanager.v1.CreateEntitySignalsMappingRequest;
import com.google.ads.admanager.v1.EntitySignalsMapping;
import com.google.ads.admanager.v1.GetEntitySignalsMappingRequest;
import com.google.ads.admanager.v1.ListEntitySignalsMappingsRequest;
import com.google.ads.admanager.v1.ListEntitySignalsMappingsResponse;
import com.google.ads.admanager.v1.UpdateEntitySignalsMappingRequest;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link EntitySignalsMappingServiceStub}.
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
 * of getEntitySignalsMapping:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EntitySignalsMappingServiceStubSettings.Builder entitySignalsMappingServiceSettingsBuilder =
 *     EntitySignalsMappingServiceStubSettings.newBuilder();
 * entitySignalsMappingServiceSettingsBuilder
 *     .getEntitySignalsMappingSettings()
 *     .setRetrySettings(
 *         entitySignalsMappingServiceSettingsBuilder
 *             .getEntitySignalsMappingSettings()
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
 * EntitySignalsMappingServiceStubSettings entitySignalsMappingServiceSettings =
 *     entitySignalsMappingServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class EntitySignalsMappingServiceStubSettings
    extends StubSettings<EntitySignalsMappingServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().build();

  private final UnaryCallSettings<GetEntitySignalsMappingRequest, EntitySignalsMapping>
      getEntitySignalsMappingSettings;
  private final PagedCallSettings<
          ListEntitySignalsMappingsRequest,
          ListEntitySignalsMappingsResponse,
          ListEntitySignalsMappingsPagedResponse>
      listEntitySignalsMappingsSettings;
  private final UnaryCallSettings<CreateEntitySignalsMappingRequest, EntitySignalsMapping>
      createEntitySignalsMappingSettings;
  private final UnaryCallSettings<UpdateEntitySignalsMappingRequest, EntitySignalsMapping>
      updateEntitySignalsMappingSettings;
  private final UnaryCallSettings<
          BatchCreateEntitySignalsMappingsRequest, BatchCreateEntitySignalsMappingsResponse>
      batchCreateEntitySignalsMappingsSettings;
  private final UnaryCallSettings<
          BatchUpdateEntitySignalsMappingsRequest, BatchUpdateEntitySignalsMappingsResponse>
      batchUpdateEntitySignalsMappingsSettings;

  private static final PagedListDescriptor<
          ListEntitySignalsMappingsRequest, ListEntitySignalsMappingsResponse, EntitySignalsMapping>
      LIST_ENTITY_SIGNALS_MAPPINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEntitySignalsMappingsRequest,
              ListEntitySignalsMappingsResponse,
              EntitySignalsMapping>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEntitySignalsMappingsRequest injectToken(
                ListEntitySignalsMappingsRequest payload, String token) {
              return ListEntitySignalsMappingsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListEntitySignalsMappingsRequest injectPageSize(
                ListEntitySignalsMappingsRequest payload, int pageSize) {
              return ListEntitySignalsMappingsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListEntitySignalsMappingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEntitySignalsMappingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EntitySignalsMapping> extractResources(
                ListEntitySignalsMappingsResponse payload) {
              return payload.getEntitySignalsMappingsList();
            }
          };

  private static final PagedListResponseFactory<
          ListEntitySignalsMappingsRequest,
          ListEntitySignalsMappingsResponse,
          ListEntitySignalsMappingsPagedResponse>
      LIST_ENTITY_SIGNALS_MAPPINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEntitySignalsMappingsRequest,
              ListEntitySignalsMappingsResponse,
              ListEntitySignalsMappingsPagedResponse>() {
            @Override
            public ApiFuture<ListEntitySignalsMappingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEntitySignalsMappingsRequest, ListEntitySignalsMappingsResponse>
                    callable,
                ListEntitySignalsMappingsRequest request,
                ApiCallContext context,
                ApiFuture<ListEntitySignalsMappingsResponse> futureResponse) {
              PageContext<
                      ListEntitySignalsMappingsRequest,
                      ListEntitySignalsMappingsResponse,
                      EntitySignalsMapping>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ENTITY_SIGNALS_MAPPINGS_PAGE_STR_DESC, request, context);
              return ListEntitySignalsMappingsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getEntitySignalsMapping. */
  public UnaryCallSettings<GetEntitySignalsMappingRequest, EntitySignalsMapping>
      getEntitySignalsMappingSettings() {
    return getEntitySignalsMappingSettings;
  }

  /** Returns the object with the settings used for calls to listEntitySignalsMappings. */
  public PagedCallSettings<
          ListEntitySignalsMappingsRequest,
          ListEntitySignalsMappingsResponse,
          ListEntitySignalsMappingsPagedResponse>
      listEntitySignalsMappingsSettings() {
    return listEntitySignalsMappingsSettings;
  }

  /** Returns the object with the settings used for calls to createEntitySignalsMapping. */
  public UnaryCallSettings<CreateEntitySignalsMappingRequest, EntitySignalsMapping>
      createEntitySignalsMappingSettings() {
    return createEntitySignalsMappingSettings;
  }

  /** Returns the object with the settings used for calls to updateEntitySignalsMapping. */
  public UnaryCallSettings<UpdateEntitySignalsMappingRequest, EntitySignalsMapping>
      updateEntitySignalsMappingSettings() {
    return updateEntitySignalsMappingSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateEntitySignalsMappings. */
  public UnaryCallSettings<
          BatchCreateEntitySignalsMappingsRequest, BatchCreateEntitySignalsMappingsResponse>
      batchCreateEntitySignalsMappingsSettings() {
    return batchCreateEntitySignalsMappingsSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateEntitySignalsMappings. */
  public UnaryCallSettings<
          BatchUpdateEntitySignalsMappingsRequest, BatchUpdateEntitySignalsMappingsResponse>
      batchUpdateEntitySignalsMappingsSettings() {
    return batchUpdateEntitySignalsMappingsSettings;
  }

  public EntitySignalsMappingServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonEntitySignalsMappingServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(EntitySignalsMappingServiceStubSettings.class))
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

  protected EntitySignalsMappingServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getEntitySignalsMappingSettings = settingsBuilder.getEntitySignalsMappingSettings().build();
    listEntitySignalsMappingsSettings = settingsBuilder.listEntitySignalsMappingsSettings().build();
    createEntitySignalsMappingSettings =
        settingsBuilder.createEntitySignalsMappingSettings().build();
    updateEntitySignalsMappingSettings =
        settingsBuilder.updateEntitySignalsMappingSettings().build();
    batchCreateEntitySignalsMappingsSettings =
        settingsBuilder.batchCreateEntitySignalsMappingsSettings().build();
    batchUpdateEntitySignalsMappingsSettings =
        settingsBuilder.batchUpdateEntitySignalsMappingsSettings().build();
  }

  /** Builder for EntitySignalsMappingServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<EntitySignalsMappingServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetEntitySignalsMappingRequest, EntitySignalsMapping>
        getEntitySignalsMappingSettings;
    private final PagedCallSettings.Builder<
            ListEntitySignalsMappingsRequest,
            ListEntitySignalsMappingsResponse,
            ListEntitySignalsMappingsPagedResponse>
        listEntitySignalsMappingsSettings;
    private final UnaryCallSettings.Builder<CreateEntitySignalsMappingRequest, EntitySignalsMapping>
        createEntitySignalsMappingSettings;
    private final UnaryCallSettings.Builder<UpdateEntitySignalsMappingRequest, EntitySignalsMapping>
        updateEntitySignalsMappingSettings;
    private final UnaryCallSettings.Builder<
            BatchCreateEntitySignalsMappingsRequest, BatchCreateEntitySignalsMappingsResponse>
        batchCreateEntitySignalsMappingsSettings;
    private final UnaryCallSettings.Builder<
            BatchUpdateEntitySignalsMappingsRequest, BatchUpdateEntitySignalsMappingsResponse>
        batchUpdateEntitySignalsMappingsSettings;
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

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getEntitySignalsMappingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEntitySignalsMappingsSettings =
          PagedCallSettings.newBuilder(LIST_ENTITY_SIGNALS_MAPPINGS_PAGE_STR_FACT);
      createEntitySignalsMappingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEntitySignalsMappingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateEntitySignalsMappingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateEntitySignalsMappingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getEntitySignalsMappingSettings,
              listEntitySignalsMappingsSettings,
              createEntitySignalsMappingSettings,
              updateEntitySignalsMappingSettings,
              batchCreateEntitySignalsMappingsSettings,
              batchUpdateEntitySignalsMappingsSettings);
      initDefaults(this);
    }

    protected Builder(EntitySignalsMappingServiceStubSettings settings) {
      super(settings);

      getEntitySignalsMappingSettings = settings.getEntitySignalsMappingSettings.toBuilder();
      listEntitySignalsMappingsSettings = settings.listEntitySignalsMappingsSettings.toBuilder();
      createEntitySignalsMappingSettings = settings.createEntitySignalsMappingSettings.toBuilder();
      updateEntitySignalsMappingSettings = settings.updateEntitySignalsMappingSettings.toBuilder();
      batchCreateEntitySignalsMappingsSettings =
          settings.batchCreateEntitySignalsMappingsSettings.toBuilder();
      batchUpdateEntitySignalsMappingsSettings =
          settings.batchUpdateEntitySignalsMappingsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getEntitySignalsMappingSettings,
              listEntitySignalsMappingsSettings,
              createEntitySignalsMappingSettings,
              updateEntitySignalsMappingSettings,
              batchCreateEntitySignalsMappingsSettings,
              batchUpdateEntitySignalsMappingsSettings);
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
          .getEntitySignalsMappingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listEntitySignalsMappingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createEntitySignalsMappingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateEntitySignalsMappingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateEntitySignalsMappingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateEntitySignalsMappingsSettings()
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

    /** Returns the builder for the settings used for calls to getEntitySignalsMapping. */
    public UnaryCallSettings.Builder<GetEntitySignalsMappingRequest, EntitySignalsMapping>
        getEntitySignalsMappingSettings() {
      return getEntitySignalsMappingSettings;
    }

    /** Returns the builder for the settings used for calls to listEntitySignalsMappings. */
    public PagedCallSettings.Builder<
            ListEntitySignalsMappingsRequest,
            ListEntitySignalsMappingsResponse,
            ListEntitySignalsMappingsPagedResponse>
        listEntitySignalsMappingsSettings() {
      return listEntitySignalsMappingsSettings;
    }

    /** Returns the builder for the settings used for calls to createEntitySignalsMapping. */
    public UnaryCallSettings.Builder<CreateEntitySignalsMappingRequest, EntitySignalsMapping>
        createEntitySignalsMappingSettings() {
      return createEntitySignalsMappingSettings;
    }

    /** Returns the builder for the settings used for calls to updateEntitySignalsMapping. */
    public UnaryCallSettings.Builder<UpdateEntitySignalsMappingRequest, EntitySignalsMapping>
        updateEntitySignalsMappingSettings() {
      return updateEntitySignalsMappingSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateEntitySignalsMappings. */
    public UnaryCallSettings.Builder<
            BatchCreateEntitySignalsMappingsRequest, BatchCreateEntitySignalsMappingsResponse>
        batchCreateEntitySignalsMappingsSettings() {
      return batchCreateEntitySignalsMappingsSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateEntitySignalsMappings. */
    public UnaryCallSettings.Builder<
            BatchUpdateEntitySignalsMappingsRequest, BatchUpdateEntitySignalsMappingsResponse>
        batchUpdateEntitySignalsMappingsSettings() {
      return batchUpdateEntitySignalsMappingsSettings;
    }

    @Override
    public EntitySignalsMappingServiceStubSettings build() throws IOException {
      return new EntitySignalsMappingServiceStubSettings(this);
    }
  }
}
