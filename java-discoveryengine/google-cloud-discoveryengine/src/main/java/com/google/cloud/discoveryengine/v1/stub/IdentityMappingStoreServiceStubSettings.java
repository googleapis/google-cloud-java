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

package com.google.cloud.discoveryengine.v1.stub;

import static com.google.cloud.discoveryengine.v1.IdentityMappingStoreServiceClient.ListIdentityMappingStoresPagedResponse;
import static com.google.cloud.discoveryengine.v1.IdentityMappingStoreServiceClient.ListIdentityMappingsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.CreateIdentityMappingStoreRequest;
import com.google.cloud.discoveryengine.v1.DeleteIdentityMappingStoreMetadata;
import com.google.cloud.discoveryengine.v1.DeleteIdentityMappingStoreRequest;
import com.google.cloud.discoveryengine.v1.GetIdentityMappingStoreRequest;
import com.google.cloud.discoveryengine.v1.IdentityMappingEntry;
import com.google.cloud.discoveryengine.v1.IdentityMappingEntryOperationMetadata;
import com.google.cloud.discoveryengine.v1.IdentityMappingStore;
import com.google.cloud.discoveryengine.v1.ImportIdentityMappingsRequest;
import com.google.cloud.discoveryengine.v1.ImportIdentityMappingsResponse;
import com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresRequest;
import com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresResponse;
import com.google.cloud.discoveryengine.v1.ListIdentityMappingsRequest;
import com.google.cloud.discoveryengine.v1.ListIdentityMappingsResponse;
import com.google.cloud.discoveryengine.v1.PurgeIdentityMappingsRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link IdentityMappingStoreServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (discoveryengine.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createIdentityMappingStore:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IdentityMappingStoreServiceStubSettings.Builder identityMappingStoreServiceSettingsBuilder =
 *     IdentityMappingStoreServiceStubSettings.newBuilder();
 * identityMappingStoreServiceSettingsBuilder
 *     .createIdentityMappingStoreSettings()
 *     .setRetrySettings(
 *         identityMappingStoreServiceSettingsBuilder
 *             .createIdentityMappingStoreSettings()
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
 * IdentityMappingStoreServiceStubSettings identityMappingStoreServiceSettings =
 *     identityMappingStoreServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for deleteIdentityMappingStore:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IdentityMappingStoreServiceStubSettings.Builder identityMappingStoreServiceSettingsBuilder =
 *     IdentityMappingStoreServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * identityMappingStoreServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class IdentityMappingStoreServiceStubSettings
    extends StubSettings<IdentityMappingStoreServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateIdentityMappingStoreRequest, IdentityMappingStore>
      createIdentityMappingStoreSettings;
  private final UnaryCallSettings<GetIdentityMappingStoreRequest, IdentityMappingStore>
      getIdentityMappingStoreSettings;
  private final UnaryCallSettings<DeleteIdentityMappingStoreRequest, Operation>
      deleteIdentityMappingStoreSettings;
  private final OperationCallSettings<
          DeleteIdentityMappingStoreRequest, Empty, DeleteIdentityMappingStoreMetadata>
      deleteIdentityMappingStoreOperationSettings;
  private final UnaryCallSettings<ImportIdentityMappingsRequest, Operation>
      importIdentityMappingsSettings;
  private final OperationCallSettings<
          ImportIdentityMappingsRequest,
          ImportIdentityMappingsResponse,
          IdentityMappingEntryOperationMetadata>
      importIdentityMappingsOperationSettings;
  private final UnaryCallSettings<PurgeIdentityMappingsRequest, Operation>
      purgeIdentityMappingsSettings;
  private final OperationCallSettings<
          PurgeIdentityMappingsRequest, Empty, IdentityMappingEntryOperationMetadata>
      purgeIdentityMappingsOperationSettings;
  private final PagedCallSettings<
          ListIdentityMappingsRequest,
          ListIdentityMappingsResponse,
          ListIdentityMappingsPagedResponse>
      listIdentityMappingsSettings;
  private final PagedCallSettings<
          ListIdentityMappingStoresRequest,
          ListIdentityMappingStoresResponse,
          ListIdentityMappingStoresPagedResponse>
      listIdentityMappingStoresSettings;

  private static final PagedListDescriptor<
          ListIdentityMappingsRequest, ListIdentityMappingsResponse, IdentityMappingEntry>
      LIST_IDENTITY_MAPPINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListIdentityMappingsRequest, ListIdentityMappingsResponse, IdentityMappingEntry>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListIdentityMappingsRequest injectToken(
                ListIdentityMappingsRequest payload, String token) {
              return ListIdentityMappingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListIdentityMappingsRequest injectPageSize(
                ListIdentityMappingsRequest payload, int pageSize) {
              return ListIdentityMappingsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListIdentityMappingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListIdentityMappingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<IdentityMappingEntry> extractResources(
                ListIdentityMappingsResponse payload) {
              return payload.getIdentityMappingEntriesList();
            }
          };

  private static final PagedListDescriptor<
          ListIdentityMappingStoresRequest, ListIdentityMappingStoresResponse, IdentityMappingStore>
      LIST_IDENTITY_MAPPING_STORES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListIdentityMappingStoresRequest,
              ListIdentityMappingStoresResponse,
              IdentityMappingStore>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListIdentityMappingStoresRequest injectToken(
                ListIdentityMappingStoresRequest payload, String token) {
              return ListIdentityMappingStoresRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListIdentityMappingStoresRequest injectPageSize(
                ListIdentityMappingStoresRequest payload, int pageSize) {
              return ListIdentityMappingStoresRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListIdentityMappingStoresRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListIdentityMappingStoresResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<IdentityMappingStore> extractResources(
                ListIdentityMappingStoresResponse payload) {
              return payload.getIdentityMappingStoresList();
            }
          };

  private static final PagedListResponseFactory<
          ListIdentityMappingsRequest,
          ListIdentityMappingsResponse,
          ListIdentityMappingsPagedResponse>
      LIST_IDENTITY_MAPPINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListIdentityMappingsRequest,
              ListIdentityMappingsResponse,
              ListIdentityMappingsPagedResponse>() {
            @Override
            public ApiFuture<ListIdentityMappingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListIdentityMappingsRequest, ListIdentityMappingsResponse> callable,
                ListIdentityMappingsRequest request,
                ApiCallContext context,
                ApiFuture<ListIdentityMappingsResponse> futureResponse) {
              PageContext<
                      ListIdentityMappingsRequest,
                      ListIdentityMappingsResponse,
                      IdentityMappingEntry>
                  pageContext =
                      PageContext.create(
                          callable, LIST_IDENTITY_MAPPINGS_PAGE_STR_DESC, request, context);
              return ListIdentityMappingsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListIdentityMappingStoresRequest,
          ListIdentityMappingStoresResponse,
          ListIdentityMappingStoresPagedResponse>
      LIST_IDENTITY_MAPPING_STORES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListIdentityMappingStoresRequest,
              ListIdentityMappingStoresResponse,
              ListIdentityMappingStoresPagedResponse>() {
            @Override
            public ApiFuture<ListIdentityMappingStoresPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListIdentityMappingStoresRequest, ListIdentityMappingStoresResponse>
                    callable,
                ListIdentityMappingStoresRequest request,
                ApiCallContext context,
                ApiFuture<ListIdentityMappingStoresResponse> futureResponse) {
              PageContext<
                      ListIdentityMappingStoresRequest,
                      ListIdentityMappingStoresResponse,
                      IdentityMappingStore>
                  pageContext =
                      PageContext.create(
                          callable, LIST_IDENTITY_MAPPING_STORES_PAGE_STR_DESC, request, context);
              return ListIdentityMappingStoresPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createIdentityMappingStore. */
  public UnaryCallSettings<CreateIdentityMappingStoreRequest, IdentityMappingStore>
      createIdentityMappingStoreSettings() {
    return createIdentityMappingStoreSettings;
  }

  /** Returns the object with the settings used for calls to getIdentityMappingStore. */
  public UnaryCallSettings<GetIdentityMappingStoreRequest, IdentityMappingStore>
      getIdentityMappingStoreSettings() {
    return getIdentityMappingStoreSettings;
  }

  /** Returns the object with the settings used for calls to deleteIdentityMappingStore. */
  public UnaryCallSettings<DeleteIdentityMappingStoreRequest, Operation>
      deleteIdentityMappingStoreSettings() {
    return deleteIdentityMappingStoreSettings;
  }

  /** Returns the object with the settings used for calls to deleteIdentityMappingStore. */
  public OperationCallSettings<
          DeleteIdentityMappingStoreRequest, Empty, DeleteIdentityMappingStoreMetadata>
      deleteIdentityMappingStoreOperationSettings() {
    return deleteIdentityMappingStoreOperationSettings;
  }

  /** Returns the object with the settings used for calls to importIdentityMappings. */
  public UnaryCallSettings<ImportIdentityMappingsRequest, Operation>
      importIdentityMappingsSettings() {
    return importIdentityMappingsSettings;
  }

  /** Returns the object with the settings used for calls to importIdentityMappings. */
  public OperationCallSettings<
          ImportIdentityMappingsRequest,
          ImportIdentityMappingsResponse,
          IdentityMappingEntryOperationMetadata>
      importIdentityMappingsOperationSettings() {
    return importIdentityMappingsOperationSettings;
  }

  /** Returns the object with the settings used for calls to purgeIdentityMappings. */
  public UnaryCallSettings<PurgeIdentityMappingsRequest, Operation>
      purgeIdentityMappingsSettings() {
    return purgeIdentityMappingsSettings;
  }

  /** Returns the object with the settings used for calls to purgeIdentityMappings. */
  public OperationCallSettings<
          PurgeIdentityMappingsRequest, Empty, IdentityMappingEntryOperationMetadata>
      purgeIdentityMappingsOperationSettings() {
    return purgeIdentityMappingsOperationSettings;
  }

  /** Returns the object with the settings used for calls to listIdentityMappings. */
  public PagedCallSettings<
          ListIdentityMappingsRequest,
          ListIdentityMappingsResponse,
          ListIdentityMappingsPagedResponse>
      listIdentityMappingsSettings() {
    return listIdentityMappingsSettings;
  }

  /** Returns the object with the settings used for calls to listIdentityMappingStores. */
  public PagedCallSettings<
          ListIdentityMappingStoresRequest,
          ListIdentityMappingStoresResponse,
          ListIdentityMappingStoresPagedResponse>
      listIdentityMappingStoresSettings() {
    return listIdentityMappingStoresSettings;
  }

  public IdentityMappingStoreServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcIdentityMappingStoreServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonIdentityMappingStoreServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "discoveryengine";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "discoveryengine.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "discoveryengine.mtls.googleapis.com:443";
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

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(IdentityMappingStoreServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(IdentityMappingStoreServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return IdentityMappingStoreServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected IdentityMappingStoreServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createIdentityMappingStoreSettings =
        settingsBuilder.createIdentityMappingStoreSettings().build();
    getIdentityMappingStoreSettings = settingsBuilder.getIdentityMappingStoreSettings().build();
    deleteIdentityMappingStoreSettings =
        settingsBuilder.deleteIdentityMappingStoreSettings().build();
    deleteIdentityMappingStoreOperationSettings =
        settingsBuilder.deleteIdentityMappingStoreOperationSettings().build();
    importIdentityMappingsSettings = settingsBuilder.importIdentityMappingsSettings().build();
    importIdentityMappingsOperationSettings =
        settingsBuilder.importIdentityMappingsOperationSettings().build();
    purgeIdentityMappingsSettings = settingsBuilder.purgeIdentityMappingsSettings().build();
    purgeIdentityMappingsOperationSettings =
        settingsBuilder.purgeIdentityMappingsOperationSettings().build();
    listIdentityMappingsSettings = settingsBuilder.listIdentityMappingsSettings().build();
    listIdentityMappingStoresSettings = settingsBuilder.listIdentityMappingStoresSettings().build();
  }

  /** Builder for IdentityMappingStoreServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<IdentityMappingStoreServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateIdentityMappingStoreRequest, IdentityMappingStore>
        createIdentityMappingStoreSettings;
    private final UnaryCallSettings.Builder<GetIdentityMappingStoreRequest, IdentityMappingStore>
        getIdentityMappingStoreSettings;
    private final UnaryCallSettings.Builder<DeleteIdentityMappingStoreRequest, Operation>
        deleteIdentityMappingStoreSettings;
    private final OperationCallSettings.Builder<
            DeleteIdentityMappingStoreRequest, Empty, DeleteIdentityMappingStoreMetadata>
        deleteIdentityMappingStoreOperationSettings;
    private final UnaryCallSettings.Builder<ImportIdentityMappingsRequest, Operation>
        importIdentityMappingsSettings;
    private final OperationCallSettings.Builder<
            ImportIdentityMappingsRequest,
            ImportIdentityMappingsResponse,
            IdentityMappingEntryOperationMetadata>
        importIdentityMappingsOperationSettings;
    private final UnaryCallSettings.Builder<PurgeIdentityMappingsRequest, Operation>
        purgeIdentityMappingsSettings;
    private final OperationCallSettings.Builder<
            PurgeIdentityMappingsRequest, Empty, IdentityMappingEntryOperationMetadata>
        purgeIdentityMappingsOperationSettings;
    private final PagedCallSettings.Builder<
            ListIdentityMappingsRequest,
            ListIdentityMappingsResponse,
            ListIdentityMappingsPagedResponse>
        listIdentityMappingsSettings;
    private final PagedCallSettings.Builder<
            ListIdentityMappingStoresRequest,
            ListIdentityMappingStoresResponse,
            ListIdentityMappingStoresPagedResponse>
        listIdentityMappingStoresSettings;
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

      createIdentityMappingStoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIdentityMappingStoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteIdentityMappingStoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteIdentityMappingStoreOperationSettings = OperationCallSettings.newBuilder();
      importIdentityMappingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importIdentityMappingsOperationSettings = OperationCallSettings.newBuilder();
      purgeIdentityMappingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      purgeIdentityMappingsOperationSettings = OperationCallSettings.newBuilder();
      listIdentityMappingsSettings =
          PagedCallSettings.newBuilder(LIST_IDENTITY_MAPPINGS_PAGE_STR_FACT);
      listIdentityMappingStoresSettings =
          PagedCallSettings.newBuilder(LIST_IDENTITY_MAPPING_STORES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createIdentityMappingStoreSettings,
              getIdentityMappingStoreSettings,
              deleteIdentityMappingStoreSettings,
              importIdentityMappingsSettings,
              purgeIdentityMappingsSettings,
              listIdentityMappingsSettings,
              listIdentityMappingStoresSettings);
      initDefaults(this);
    }

    protected Builder(IdentityMappingStoreServiceStubSettings settings) {
      super(settings);

      createIdentityMappingStoreSettings = settings.createIdentityMappingStoreSettings.toBuilder();
      getIdentityMappingStoreSettings = settings.getIdentityMappingStoreSettings.toBuilder();
      deleteIdentityMappingStoreSettings = settings.deleteIdentityMappingStoreSettings.toBuilder();
      deleteIdentityMappingStoreOperationSettings =
          settings.deleteIdentityMappingStoreOperationSettings.toBuilder();
      importIdentityMappingsSettings = settings.importIdentityMappingsSettings.toBuilder();
      importIdentityMappingsOperationSettings =
          settings.importIdentityMappingsOperationSettings.toBuilder();
      purgeIdentityMappingsSettings = settings.purgeIdentityMappingsSettings.toBuilder();
      purgeIdentityMappingsOperationSettings =
          settings.purgeIdentityMappingsOperationSettings.toBuilder();
      listIdentityMappingsSettings = settings.listIdentityMappingsSettings.toBuilder();
      listIdentityMappingStoresSettings = settings.listIdentityMappingStoresSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createIdentityMappingStoreSettings,
              getIdentityMappingStoreSettings,
              deleteIdentityMappingStoreSettings,
              importIdentityMappingsSettings,
              purgeIdentityMappingsSettings,
              listIdentityMappingsSettings,
              listIdentityMappingStoresSettings);
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

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createIdentityMappingStoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIdentityMappingStoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteIdentityMappingStoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .importIdentityMappingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .purgeIdentityMappingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listIdentityMappingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listIdentityMappingStoresSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteIdentityMappingStoreOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteIdentityMappingStoreRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  DeleteIdentityMappingStoreMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .importIdentityMappingsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportIdentityMappingsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ImportIdentityMappingsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  IdentityMappingEntryOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .purgeIdentityMappingsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PurgeIdentityMappingsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  IdentityMappingEntryOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

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

    /** Returns the builder for the settings used for calls to createIdentityMappingStore. */
    public UnaryCallSettings.Builder<CreateIdentityMappingStoreRequest, IdentityMappingStore>
        createIdentityMappingStoreSettings() {
      return createIdentityMappingStoreSettings;
    }

    /** Returns the builder for the settings used for calls to getIdentityMappingStore. */
    public UnaryCallSettings.Builder<GetIdentityMappingStoreRequest, IdentityMappingStore>
        getIdentityMappingStoreSettings() {
      return getIdentityMappingStoreSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIdentityMappingStore. */
    public UnaryCallSettings.Builder<DeleteIdentityMappingStoreRequest, Operation>
        deleteIdentityMappingStoreSettings() {
      return deleteIdentityMappingStoreSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIdentityMappingStore. */
    public OperationCallSettings.Builder<
            DeleteIdentityMappingStoreRequest, Empty, DeleteIdentityMappingStoreMetadata>
        deleteIdentityMappingStoreOperationSettings() {
      return deleteIdentityMappingStoreOperationSettings;
    }

    /** Returns the builder for the settings used for calls to importIdentityMappings. */
    public UnaryCallSettings.Builder<ImportIdentityMappingsRequest, Operation>
        importIdentityMappingsSettings() {
      return importIdentityMappingsSettings;
    }

    /** Returns the builder for the settings used for calls to importIdentityMappings. */
    public OperationCallSettings.Builder<
            ImportIdentityMappingsRequest,
            ImportIdentityMappingsResponse,
            IdentityMappingEntryOperationMetadata>
        importIdentityMappingsOperationSettings() {
      return importIdentityMappingsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to purgeIdentityMappings. */
    public UnaryCallSettings.Builder<PurgeIdentityMappingsRequest, Operation>
        purgeIdentityMappingsSettings() {
      return purgeIdentityMappingsSettings;
    }

    /** Returns the builder for the settings used for calls to purgeIdentityMappings. */
    public OperationCallSettings.Builder<
            PurgeIdentityMappingsRequest, Empty, IdentityMappingEntryOperationMetadata>
        purgeIdentityMappingsOperationSettings() {
      return purgeIdentityMappingsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listIdentityMappings. */
    public PagedCallSettings.Builder<
            ListIdentityMappingsRequest,
            ListIdentityMappingsResponse,
            ListIdentityMappingsPagedResponse>
        listIdentityMappingsSettings() {
      return listIdentityMappingsSettings;
    }

    /** Returns the builder for the settings used for calls to listIdentityMappingStores. */
    public PagedCallSettings.Builder<
            ListIdentityMappingStoresRequest,
            ListIdentityMappingStoresResponse,
            ListIdentityMappingStoresPagedResponse>
        listIdentityMappingStoresSettings() {
      return listIdentityMappingStoresSettings;
    }

    @Override
    public IdentityMappingStoreServiceStubSettings build() throws IOException {
      return new IdentityMappingStoreServiceStubSettings(this);
    }
  }
}
