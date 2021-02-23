/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.aiplatform.v1.stub;

import static com.google.cloud.aiplatform.v1.MigrationServiceClient.SearchMigratableResourcesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
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
import com.google.cloud.aiplatform.v1.BatchMigrateResourcesOperationMetadata;
import com.google.cloud.aiplatform.v1.BatchMigrateResourcesRequest;
import com.google.cloud.aiplatform.v1.BatchMigrateResourcesResponse;
import com.google.cloud.aiplatform.v1.MigratableResource;
import com.google.cloud.aiplatform.v1.SearchMigratableResourcesRequest;
import com.google.cloud.aiplatform.v1.SearchMigratableResourcesResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MigrationServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of searchMigratableResources to 30 seconds:
 *
 * <pre>{@code
 * MigrationServiceStubSettings.Builder migrationServiceSettingsBuilder =
 *     MigrationServiceStubSettings.newBuilder();
 * migrationServiceSettingsBuilder
 *     .searchMigratableResourcesSettings()
 *     .setRetrySettings(
 *         migrationServiceSettingsBuilder
 *             .searchMigratableResourcesSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * MigrationServiceStubSettings migrationServiceSettings = migrationServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class MigrationServiceStubSettings extends StubSettings<MigrationServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          SearchMigratableResourcesRequest,
          SearchMigratableResourcesResponse,
          SearchMigratableResourcesPagedResponse>
      searchMigratableResourcesSettings;
  private final UnaryCallSettings<BatchMigrateResourcesRequest, Operation>
      batchMigrateResourcesSettings;
  private final OperationCallSettings<
          BatchMigrateResourcesRequest,
          BatchMigrateResourcesResponse,
          BatchMigrateResourcesOperationMetadata>
      batchMigrateResourcesOperationSettings;

  private static final PagedListDescriptor<
          SearchMigratableResourcesRequest, SearchMigratableResourcesResponse, MigratableResource>
      SEARCH_MIGRATABLE_RESOURCES_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchMigratableResourcesRequest,
              SearchMigratableResourcesResponse,
              MigratableResource>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchMigratableResourcesRequest injectToken(
                SearchMigratableResourcesRequest payload, String token) {
              return SearchMigratableResourcesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public SearchMigratableResourcesRequest injectPageSize(
                SearchMigratableResourcesRequest payload, int pageSize) {
              return SearchMigratableResourcesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(SearchMigratableResourcesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchMigratableResourcesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MigratableResource> extractResources(
                SearchMigratableResourcesResponse payload) {
              return payload.getMigratableResourcesList() == null
                  ? ImmutableList.<MigratableResource>of()
                  : payload.getMigratableResourcesList();
            }
          };

  private static final PagedListResponseFactory<
          SearchMigratableResourcesRequest,
          SearchMigratableResourcesResponse,
          SearchMigratableResourcesPagedResponse>
      SEARCH_MIGRATABLE_RESOURCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchMigratableResourcesRequest,
              SearchMigratableResourcesResponse,
              SearchMigratableResourcesPagedResponse>() {
            @Override
            public ApiFuture<SearchMigratableResourcesPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchMigratableResourcesRequest, SearchMigratableResourcesResponse>
                    callable,
                SearchMigratableResourcesRequest request,
                ApiCallContext context,
                ApiFuture<SearchMigratableResourcesResponse> futureResponse) {
              PageContext<
                      SearchMigratableResourcesRequest,
                      SearchMigratableResourcesResponse,
                      MigratableResource>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_MIGRATABLE_RESOURCES_PAGE_STR_DESC, request, context);
              return SearchMigratableResourcesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to searchMigratableResources. */
  public PagedCallSettings<
          SearchMigratableResourcesRequest,
          SearchMigratableResourcesResponse,
          SearchMigratableResourcesPagedResponse>
      searchMigratableResourcesSettings() {
    return searchMigratableResourcesSettings;
  }

  /** Returns the object with the settings used for calls to batchMigrateResources. */
  public UnaryCallSettings<BatchMigrateResourcesRequest, Operation>
      batchMigrateResourcesSettings() {
    return batchMigrateResourcesSettings;
  }

  /** Returns the object with the settings used for calls to batchMigrateResources. */
  public OperationCallSettings<
          BatchMigrateResourcesRequest,
          BatchMigrateResourcesResponse,
          BatchMigrateResourcesOperationMetadata>
      batchMigrateResourcesOperationSettings() {
    return batchMigrateResourcesOperationSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public MigrationServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcMigrationServiceStub.create(this);
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
    return "aiplatform.googleapis.com:443";
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
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(MigrationServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected MigrationServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    searchMigratableResourcesSettings = settingsBuilder.searchMigratableResourcesSettings().build();
    batchMigrateResourcesSettings = settingsBuilder.batchMigrateResourcesSettings().build();
    batchMigrateResourcesOperationSettings =
        settingsBuilder.batchMigrateResourcesOperationSettings().build();
  }

  /** Builder for MigrationServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<MigrationServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            SearchMigratableResourcesRequest,
            SearchMigratableResourcesResponse,
            SearchMigratableResourcesPagedResponse>
        searchMigratableResourcesSettings;
    private final UnaryCallSettings.Builder<BatchMigrateResourcesRequest, Operation>
        batchMigrateResourcesSettings;
    private final OperationCallSettings.Builder<
            BatchMigrateResourcesRequest,
            BatchMigrateResourcesResponse,
            BatchMigrateResourcesOperationMetadata>
        batchMigrateResourcesOperationSettings;
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

      searchMigratableResourcesSettings =
          PagedCallSettings.newBuilder(SEARCH_MIGRATABLE_RESOURCES_PAGE_STR_FACT);
      batchMigrateResourcesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchMigrateResourcesOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              searchMigratableResourcesSettings, batchMigrateResourcesSettings);
      initDefaults(this);
    }

    protected Builder(MigrationServiceStubSettings settings) {
      super(settings);

      searchMigratableResourcesSettings = settings.searchMigratableResourcesSettings.toBuilder();
      batchMigrateResourcesSettings = settings.batchMigrateResourcesSettings.toBuilder();
      batchMigrateResourcesOperationSettings =
          settings.batchMigrateResourcesOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              searchMigratableResourcesSettings, batchMigrateResourcesSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .searchMigratableResourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchMigrateResourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchMigrateResourcesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchMigrateResourcesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BatchMigrateResourcesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  BatchMigrateResourcesOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
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

    /** Returns the builder for the settings used for calls to searchMigratableResources. */
    public PagedCallSettings.Builder<
            SearchMigratableResourcesRequest,
            SearchMigratableResourcesResponse,
            SearchMigratableResourcesPagedResponse>
        searchMigratableResourcesSettings() {
      return searchMigratableResourcesSettings;
    }

    /** Returns the builder for the settings used for calls to batchMigrateResources. */
    public UnaryCallSettings.Builder<BatchMigrateResourcesRequest, Operation>
        batchMigrateResourcesSettings() {
      return batchMigrateResourcesSettings;
    }

    /** Returns the builder for the settings used for calls to batchMigrateResources. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            BatchMigrateResourcesRequest,
            BatchMigrateResourcesResponse,
            BatchMigrateResourcesOperationMetadata>
        batchMigrateResourcesOperationSettings() {
      return batchMigrateResourcesOperationSettings;
    }

    @Override
    public MigrationServiceStubSettings build() throws IOException {
      return new MigrationServiceStubSettings(this);
    }
  }
}
