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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.MetadataServiceClient.ListEntitiesPagedResponse;
import static com.google.cloud.dataplex.v1.MetadataServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.dataplex.v1.MetadataServiceClient.ListPartitionsPagedResponse;

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
import com.google.cloud.dataplex.v1.CreateEntityRequest;
import com.google.cloud.dataplex.v1.CreatePartitionRequest;
import com.google.cloud.dataplex.v1.DeleteEntityRequest;
import com.google.cloud.dataplex.v1.DeletePartitionRequest;
import com.google.cloud.dataplex.v1.Entity;
import com.google.cloud.dataplex.v1.GetEntityRequest;
import com.google.cloud.dataplex.v1.GetPartitionRequest;
import com.google.cloud.dataplex.v1.ListEntitiesRequest;
import com.google.cloud.dataplex.v1.ListEntitiesResponse;
import com.google.cloud.dataplex.v1.ListPartitionsRequest;
import com.google.cloud.dataplex.v1.ListPartitionsResponse;
import com.google.cloud.dataplex.v1.Partition;
import com.google.cloud.dataplex.v1.UpdateEntityRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Settings class to configure an instance of {@link MetadataServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataplex.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createEntity to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MetadataServiceStubSettings.Builder metadataServiceSettingsBuilder =
 *     MetadataServiceStubSettings.newBuilder();
 * metadataServiceSettingsBuilder
 *     .createEntitySettings()
 *     .setRetrySettings(
 *         metadataServiceSettingsBuilder.createEntitySettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * MetadataServiceStubSettings metadataServiceSettings = metadataServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class MetadataServiceStubSettings extends StubSettings<MetadataServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateEntityRequest, Entity> createEntitySettings;
  private final UnaryCallSettings<UpdateEntityRequest, Entity> updateEntitySettings;
  private final UnaryCallSettings<DeleteEntityRequest, Empty> deleteEntitySettings;
  private final UnaryCallSettings<GetEntityRequest, Entity> getEntitySettings;
  private final PagedCallSettings<
          ListEntitiesRequest, ListEntitiesResponse, ListEntitiesPagedResponse>
      listEntitiesSettings;
  private final UnaryCallSettings<CreatePartitionRequest, Partition> createPartitionSettings;
  private final UnaryCallSettings<DeletePartitionRequest, Empty> deletePartitionSettings;
  private final UnaryCallSettings<GetPartitionRequest, Partition> getPartitionSettings;
  private final PagedCallSettings<
          ListPartitionsRequest, ListPartitionsResponse, ListPartitionsPagedResponse>
      listPartitionsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListEntitiesRequest, ListEntitiesResponse, Entity>
      LIST_ENTITIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListEntitiesRequest, ListEntitiesResponse, Entity>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEntitiesRequest injectToken(ListEntitiesRequest payload, String token) {
              return ListEntitiesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEntitiesRequest injectPageSize(ListEntitiesRequest payload, int pageSize) {
              return ListEntitiesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEntitiesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEntitiesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Entity> extractResources(ListEntitiesResponse payload) {
              return payload.getEntitiesList() == null
                  ? ImmutableList.<Entity>of()
                  : payload.getEntitiesList();
            }
          };

  private static final PagedListDescriptor<ListPartitionsRequest, ListPartitionsResponse, Partition>
      LIST_PARTITIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListPartitionsRequest, ListPartitionsResponse, Partition>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPartitionsRequest injectToken(ListPartitionsRequest payload, String token) {
              return ListPartitionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPartitionsRequest injectPageSize(
                ListPartitionsRequest payload, int pageSize) {
              return ListPartitionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPartitionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPartitionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Partition> extractResources(ListPartitionsResponse payload) {
              return payload.getPartitionsList() == null
                  ? ImmutableList.<Partition>of()
                  : payload.getPartitionsList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListEntitiesRequest, ListEntitiesResponse, ListEntitiesPagedResponse>
      LIST_ENTITIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEntitiesRequest, ListEntitiesResponse, ListEntitiesPagedResponse>() {
            @Override
            public ApiFuture<ListEntitiesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEntitiesRequest, ListEntitiesResponse> callable,
                ListEntitiesRequest request,
                ApiCallContext context,
                ApiFuture<ListEntitiesResponse> futureResponse) {
              PageContext<ListEntitiesRequest, ListEntitiesResponse, Entity> pageContext =
                  PageContext.create(callable, LIST_ENTITIES_PAGE_STR_DESC, request, context);
              return ListEntitiesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPartitionsRequest, ListPartitionsResponse, ListPartitionsPagedResponse>
      LIST_PARTITIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPartitionsRequest, ListPartitionsResponse, ListPartitionsPagedResponse>() {
            @Override
            public ApiFuture<ListPartitionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPartitionsRequest, ListPartitionsResponse> callable,
                ListPartitionsRequest request,
                ApiCallContext context,
                ApiFuture<ListPartitionsResponse> futureResponse) {
              PageContext<ListPartitionsRequest, ListPartitionsResponse, Partition> pageContext =
                  PageContext.create(callable, LIST_PARTITIONS_PAGE_STR_DESC, request, context);
              return ListPartitionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createEntity. */
  public UnaryCallSettings<CreateEntityRequest, Entity> createEntitySettings() {
    return createEntitySettings;
  }

  /** Returns the object with the settings used for calls to updateEntity. */
  public UnaryCallSettings<UpdateEntityRequest, Entity> updateEntitySettings() {
    return updateEntitySettings;
  }

  /** Returns the object with the settings used for calls to deleteEntity. */
  public UnaryCallSettings<DeleteEntityRequest, Empty> deleteEntitySettings() {
    return deleteEntitySettings;
  }

  /** Returns the object with the settings used for calls to getEntity. */
  public UnaryCallSettings<GetEntityRequest, Entity> getEntitySettings() {
    return getEntitySettings;
  }

  /** Returns the object with the settings used for calls to listEntities. */
  public PagedCallSettings<ListEntitiesRequest, ListEntitiesResponse, ListEntitiesPagedResponse>
      listEntitiesSettings() {
    return listEntitiesSettings;
  }

  /** Returns the object with the settings used for calls to createPartition. */
  public UnaryCallSettings<CreatePartitionRequest, Partition> createPartitionSettings() {
    return createPartitionSettings;
  }

  /** Returns the object with the settings used for calls to deletePartition. */
  public UnaryCallSettings<DeletePartitionRequest, Empty> deletePartitionSettings() {
    return deletePartitionSettings;
  }

  /** Returns the object with the settings used for calls to getPartition. */
  public UnaryCallSettings<GetPartitionRequest, Partition> getPartitionSettings() {
    return getPartitionSettings;
  }

  /** Returns the object with the settings used for calls to listPartitions. */
  public PagedCallSettings<
          ListPartitionsRequest, ListPartitionsResponse, ListPartitionsPagedResponse>
      listPartitionsSettings() {
    return listPartitionsSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  public MetadataServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcMetadataServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonMetadataServiceStub.create(this);
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
    return "dataplex.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "dataplex.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(MetadataServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(MetadataServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MetadataServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected MetadataServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createEntitySettings = settingsBuilder.createEntitySettings().build();
    updateEntitySettings = settingsBuilder.updateEntitySettings().build();
    deleteEntitySettings = settingsBuilder.deleteEntitySettings().build();
    getEntitySettings = settingsBuilder.getEntitySettings().build();
    listEntitiesSettings = settingsBuilder.listEntitiesSettings().build();
    createPartitionSettings = settingsBuilder.createPartitionSettings().build();
    deletePartitionSettings = settingsBuilder.deletePartitionSettings().build();
    getPartitionSettings = settingsBuilder.getPartitionSettings().build();
    listPartitionsSettings = settingsBuilder.listPartitionsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for MetadataServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<MetadataServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateEntityRequest, Entity> createEntitySettings;
    private final UnaryCallSettings.Builder<UpdateEntityRequest, Entity> updateEntitySettings;
    private final UnaryCallSettings.Builder<DeleteEntityRequest, Empty> deleteEntitySettings;
    private final UnaryCallSettings.Builder<GetEntityRequest, Entity> getEntitySettings;
    private final PagedCallSettings.Builder<
            ListEntitiesRequest, ListEntitiesResponse, ListEntitiesPagedResponse>
        listEntitiesSettings;
    private final UnaryCallSettings.Builder<CreatePartitionRequest, Partition>
        createPartitionSettings;
    private final UnaryCallSettings.Builder<DeletePartitionRequest, Empty> deletePartitionSettings;
    private final UnaryCallSettings.Builder<GetPartitionRequest, Partition> getPartitionSettings;
    private final PagedCallSettings.Builder<
            ListPartitionsRequest, ListPartitionsResponse, ListPartitionsPagedResponse>
        listPartitionsSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_7_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_2_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "retry_policy_3_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_7_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_2_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_3_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createEntitySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEntitySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEntitySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getEntitySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEntitiesSettings = PagedCallSettings.newBuilder(LIST_ENTITIES_PAGE_STR_FACT);
      createPartitionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePartitionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getPartitionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPartitionsSettings = PagedCallSettings.newBuilder(LIST_PARTITIONS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createEntitySettings,
              updateEntitySettings,
              deleteEntitySettings,
              getEntitySettings,
              listEntitiesSettings,
              createPartitionSettings,
              deletePartitionSettings,
              getPartitionSettings,
              listPartitionsSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(MetadataServiceStubSettings settings) {
      super(settings);

      createEntitySettings = settings.createEntitySettings.toBuilder();
      updateEntitySettings = settings.updateEntitySettings.toBuilder();
      deleteEntitySettings = settings.deleteEntitySettings.toBuilder();
      getEntitySettings = settings.getEntitySettings.toBuilder();
      listEntitiesSettings = settings.listEntitiesSettings.toBuilder();
      createPartitionSettings = settings.createPartitionSettings.toBuilder();
      deletePartitionSettings = settings.deletePartitionSettings.toBuilder();
      getPartitionSettings = settings.getPartitionSettings.toBuilder();
      listPartitionsSettings = settings.listPartitionsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createEntitySettings,
              updateEntitySettings,
              deleteEntitySettings,
              getEntitySettings,
              listEntitiesSettings,
              createPartitionSettings,
              deletePartitionSettings,
              getPartitionSettings,
              listPartitionsSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .createEntitySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .updateEntitySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .deleteEntitySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .getEntitySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .listEntitiesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .createPartitionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .deletePartitionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .getPartitionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .listPartitionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
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

    /** Returns the builder for the settings used for calls to createEntity. */
    public UnaryCallSettings.Builder<CreateEntityRequest, Entity> createEntitySettings() {
      return createEntitySettings;
    }

    /** Returns the builder for the settings used for calls to updateEntity. */
    public UnaryCallSettings.Builder<UpdateEntityRequest, Entity> updateEntitySettings() {
      return updateEntitySettings;
    }

    /** Returns the builder for the settings used for calls to deleteEntity. */
    public UnaryCallSettings.Builder<DeleteEntityRequest, Empty> deleteEntitySettings() {
      return deleteEntitySettings;
    }

    /** Returns the builder for the settings used for calls to getEntity. */
    public UnaryCallSettings.Builder<GetEntityRequest, Entity> getEntitySettings() {
      return getEntitySettings;
    }

    /** Returns the builder for the settings used for calls to listEntities. */
    public PagedCallSettings.Builder<
            ListEntitiesRequest, ListEntitiesResponse, ListEntitiesPagedResponse>
        listEntitiesSettings() {
      return listEntitiesSettings;
    }

    /** Returns the builder for the settings used for calls to createPartition. */
    public UnaryCallSettings.Builder<CreatePartitionRequest, Partition> createPartitionSettings() {
      return createPartitionSettings;
    }

    /** Returns the builder for the settings used for calls to deletePartition. */
    public UnaryCallSettings.Builder<DeletePartitionRequest, Empty> deletePartitionSettings() {
      return deletePartitionSettings;
    }

    /** Returns the builder for the settings used for calls to getPartition. */
    public UnaryCallSettings.Builder<GetPartitionRequest, Partition> getPartitionSettings() {
      return getPartitionSettings;
    }

    /** Returns the builder for the settings used for calls to listPartitions. */
    public PagedCallSettings.Builder<
            ListPartitionsRequest, ListPartitionsResponse, ListPartitionsPagedResponse>
        listPartitionsSettings() {
      return listPartitionsSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    @Override
    public MetadataServiceStubSettings build() throws IOException {
      return new MetadataServiceStubSettings(this);
    }
  }
}
