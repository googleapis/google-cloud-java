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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.EntityTypesClient.ListEntityTypesPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.EntityTypesClient.ListLocationsPagedResponse;

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
import com.google.cloud.dialogflow.v2beta1.BatchCreateEntitiesRequest;
import com.google.cloud.dialogflow.v2beta1.BatchDeleteEntitiesRequest;
import com.google.cloud.dialogflow.v2beta1.BatchDeleteEntityTypesRequest;
import com.google.cloud.dialogflow.v2beta1.BatchUpdateEntitiesRequest;
import com.google.cloud.dialogflow.v2beta1.BatchUpdateEntityTypesRequest;
import com.google.cloud.dialogflow.v2beta1.BatchUpdateEntityTypesResponse;
import com.google.cloud.dialogflow.v2beta1.CreateEntityTypeRequest;
import com.google.cloud.dialogflow.v2beta1.DeleteEntityTypeRequest;
import com.google.cloud.dialogflow.v2beta1.EntityType;
import com.google.cloud.dialogflow.v2beta1.GetEntityTypeRequest;
import com.google.cloud.dialogflow.v2beta1.ListEntityTypesRequest;
import com.google.cloud.dialogflow.v2beta1.ListEntityTypesResponse;
import com.google.cloud.dialogflow.v2beta1.UpdateEntityTypeRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link EntityTypesStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dialogflow.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getEntityType to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EntityTypesStubSettings.Builder entityTypesSettingsBuilder =
 *     EntityTypesStubSettings.newBuilder();
 * entityTypesSettingsBuilder
 *     .getEntityTypeSettings()
 *     .setRetrySettings(
 *         entityTypesSettingsBuilder
 *             .getEntityTypeSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * EntityTypesStubSettings entityTypesSettings = entityTypesSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class EntityTypesStubSettings extends StubSettings<EntityTypesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/dialogflow")
          .build();

  private final PagedCallSettings<
          ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>
      listEntityTypesSettings;
  private final UnaryCallSettings<GetEntityTypeRequest, EntityType> getEntityTypeSettings;
  private final UnaryCallSettings<CreateEntityTypeRequest, EntityType> createEntityTypeSettings;
  private final UnaryCallSettings<UpdateEntityTypeRequest, EntityType> updateEntityTypeSettings;
  private final UnaryCallSettings<DeleteEntityTypeRequest, Empty> deleteEntityTypeSettings;
  private final UnaryCallSettings<BatchUpdateEntityTypesRequest, Operation>
      batchUpdateEntityTypesSettings;
  private final OperationCallSettings<
          BatchUpdateEntityTypesRequest, BatchUpdateEntityTypesResponse, Struct>
      batchUpdateEntityTypesOperationSettings;
  private final UnaryCallSettings<BatchDeleteEntityTypesRequest, Operation>
      batchDeleteEntityTypesSettings;
  private final OperationCallSettings<BatchDeleteEntityTypesRequest, Empty, Struct>
      batchDeleteEntityTypesOperationSettings;
  private final UnaryCallSettings<BatchCreateEntitiesRequest, Operation>
      batchCreateEntitiesSettings;
  private final OperationCallSettings<BatchCreateEntitiesRequest, Empty, Struct>
      batchCreateEntitiesOperationSettings;
  private final UnaryCallSettings<BatchUpdateEntitiesRequest, Operation>
      batchUpdateEntitiesSettings;
  private final OperationCallSettings<BatchUpdateEntitiesRequest, Empty, Struct>
      batchUpdateEntitiesOperationSettings;
  private final UnaryCallSettings<BatchDeleteEntitiesRequest, Operation>
      batchDeleteEntitiesSettings;
  private final OperationCallSettings<BatchDeleteEntitiesRequest, Empty, Struct>
      batchDeleteEntitiesOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListEntityTypesRequest, ListEntityTypesResponse, EntityType>
      LIST_ENTITY_TYPES_PAGE_STR_DESC =
          new PagedListDescriptor<ListEntityTypesRequest, ListEntityTypesResponse, EntityType>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEntityTypesRequest injectToken(
                ListEntityTypesRequest payload, String token) {
              return ListEntityTypesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEntityTypesRequest injectPageSize(
                ListEntityTypesRequest payload, int pageSize) {
              return ListEntityTypesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEntityTypesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEntityTypesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EntityType> extractResources(ListEntityTypesResponse payload) {
              return payload.getEntityTypesList() == null
                  ? ImmutableList.<EntityType>of()
                  : payload.getEntityTypesList();
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
          ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>
      LIST_ENTITY_TYPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>() {
            @Override
            public ApiFuture<ListEntityTypesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEntityTypesRequest, ListEntityTypesResponse> callable,
                ListEntityTypesRequest request,
                ApiCallContext context,
                ApiFuture<ListEntityTypesResponse> futureResponse) {
              PageContext<ListEntityTypesRequest, ListEntityTypesResponse, EntityType> pageContext =
                  PageContext.create(callable, LIST_ENTITY_TYPES_PAGE_STR_DESC, request, context);
              return ListEntityTypesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listEntityTypes. */
  public PagedCallSettings<
          ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>
      listEntityTypesSettings() {
    return listEntityTypesSettings;
  }

  /** Returns the object with the settings used for calls to getEntityType. */
  public UnaryCallSettings<GetEntityTypeRequest, EntityType> getEntityTypeSettings() {
    return getEntityTypeSettings;
  }

  /** Returns the object with the settings used for calls to createEntityType. */
  public UnaryCallSettings<CreateEntityTypeRequest, EntityType> createEntityTypeSettings() {
    return createEntityTypeSettings;
  }

  /** Returns the object with the settings used for calls to updateEntityType. */
  public UnaryCallSettings<UpdateEntityTypeRequest, EntityType> updateEntityTypeSettings() {
    return updateEntityTypeSettings;
  }

  /** Returns the object with the settings used for calls to deleteEntityType. */
  public UnaryCallSettings<DeleteEntityTypeRequest, Empty> deleteEntityTypeSettings() {
    return deleteEntityTypeSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateEntityTypes. */
  public UnaryCallSettings<BatchUpdateEntityTypesRequest, Operation>
      batchUpdateEntityTypesSettings() {
    return batchUpdateEntityTypesSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateEntityTypes. */
  public OperationCallSettings<
          BatchUpdateEntityTypesRequest, BatchUpdateEntityTypesResponse, Struct>
      batchUpdateEntityTypesOperationSettings() {
    return batchUpdateEntityTypesOperationSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteEntityTypes. */
  public UnaryCallSettings<BatchDeleteEntityTypesRequest, Operation>
      batchDeleteEntityTypesSettings() {
    return batchDeleteEntityTypesSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteEntityTypes. */
  public OperationCallSettings<BatchDeleteEntityTypesRequest, Empty, Struct>
      batchDeleteEntityTypesOperationSettings() {
    return batchDeleteEntityTypesOperationSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateEntities. */
  public UnaryCallSettings<BatchCreateEntitiesRequest, Operation> batchCreateEntitiesSettings() {
    return batchCreateEntitiesSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateEntities. */
  public OperationCallSettings<BatchCreateEntitiesRequest, Empty, Struct>
      batchCreateEntitiesOperationSettings() {
    return batchCreateEntitiesOperationSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateEntities. */
  public UnaryCallSettings<BatchUpdateEntitiesRequest, Operation> batchUpdateEntitiesSettings() {
    return batchUpdateEntitiesSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateEntities. */
  public OperationCallSettings<BatchUpdateEntitiesRequest, Empty, Struct>
      batchUpdateEntitiesOperationSettings() {
    return batchUpdateEntitiesOperationSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteEntities. */
  public UnaryCallSettings<BatchDeleteEntitiesRequest, Operation> batchDeleteEntitiesSettings() {
    return batchDeleteEntitiesSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteEntities. */
  public OperationCallSettings<BatchDeleteEntitiesRequest, Empty, Struct>
      batchDeleteEntitiesOperationSettings() {
    return batchDeleteEntitiesOperationSettings;
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

  public EntityTypesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcEntityTypesStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonEntityTypesStub.create(this);
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
    return "dialogflow.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "dialogflow.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(EntityTypesStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(EntityTypesStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EntityTypesStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected EntityTypesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listEntityTypesSettings = settingsBuilder.listEntityTypesSettings().build();
    getEntityTypeSettings = settingsBuilder.getEntityTypeSettings().build();
    createEntityTypeSettings = settingsBuilder.createEntityTypeSettings().build();
    updateEntityTypeSettings = settingsBuilder.updateEntityTypeSettings().build();
    deleteEntityTypeSettings = settingsBuilder.deleteEntityTypeSettings().build();
    batchUpdateEntityTypesSettings = settingsBuilder.batchUpdateEntityTypesSettings().build();
    batchUpdateEntityTypesOperationSettings =
        settingsBuilder.batchUpdateEntityTypesOperationSettings().build();
    batchDeleteEntityTypesSettings = settingsBuilder.batchDeleteEntityTypesSettings().build();
    batchDeleteEntityTypesOperationSettings =
        settingsBuilder.batchDeleteEntityTypesOperationSettings().build();
    batchCreateEntitiesSettings = settingsBuilder.batchCreateEntitiesSettings().build();
    batchCreateEntitiesOperationSettings =
        settingsBuilder.batchCreateEntitiesOperationSettings().build();
    batchUpdateEntitiesSettings = settingsBuilder.batchUpdateEntitiesSettings().build();
    batchUpdateEntitiesOperationSettings =
        settingsBuilder.batchUpdateEntitiesOperationSettings().build();
    batchDeleteEntitiesSettings = settingsBuilder.batchDeleteEntitiesSettings().build();
    batchDeleteEntitiesOperationSettings =
        settingsBuilder.batchDeleteEntitiesOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for EntityTypesStubSettings. */
  public static class Builder extends StubSettings.Builder<EntityTypesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>
        listEntityTypesSettings;
    private final UnaryCallSettings.Builder<GetEntityTypeRequest, EntityType> getEntityTypeSettings;
    private final UnaryCallSettings.Builder<CreateEntityTypeRequest, EntityType>
        createEntityTypeSettings;
    private final UnaryCallSettings.Builder<UpdateEntityTypeRequest, EntityType>
        updateEntityTypeSettings;
    private final UnaryCallSettings.Builder<DeleteEntityTypeRequest, Empty>
        deleteEntityTypeSettings;
    private final UnaryCallSettings.Builder<BatchUpdateEntityTypesRequest, Operation>
        batchUpdateEntityTypesSettings;
    private final OperationCallSettings.Builder<
            BatchUpdateEntityTypesRequest, BatchUpdateEntityTypesResponse, Struct>
        batchUpdateEntityTypesOperationSettings;
    private final UnaryCallSettings.Builder<BatchDeleteEntityTypesRequest, Operation>
        batchDeleteEntityTypesSettings;
    private final OperationCallSettings.Builder<BatchDeleteEntityTypesRequest, Empty, Struct>
        batchDeleteEntityTypesOperationSettings;
    private final UnaryCallSettings.Builder<BatchCreateEntitiesRequest, Operation>
        batchCreateEntitiesSettings;
    private final OperationCallSettings.Builder<BatchCreateEntitiesRequest, Empty, Struct>
        batchCreateEntitiesOperationSettings;
    private final UnaryCallSettings.Builder<BatchUpdateEntitiesRequest, Operation>
        batchUpdateEntitiesSettings;
    private final OperationCallSettings.Builder<BatchUpdateEntitiesRequest, Empty, Struct>
        batchUpdateEntitiesOperationSettings;
    private final UnaryCallSettings.Builder<BatchDeleteEntitiesRequest, Operation>
        batchDeleteEntitiesSettings;
    private final OperationCallSettings.Builder<BatchDeleteEntitiesRequest, Empty, Struct>
        batchDeleteEntitiesOperationSettings;
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
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
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
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listEntityTypesSettings = PagedCallSettings.newBuilder(LIST_ENTITY_TYPES_PAGE_STR_FACT);
      getEntityTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEntityTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEntityTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEntityTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateEntityTypesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateEntityTypesOperationSettings = OperationCallSettings.newBuilder();
      batchDeleteEntityTypesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeleteEntityTypesOperationSettings = OperationCallSettings.newBuilder();
      batchCreateEntitiesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateEntitiesOperationSettings = OperationCallSettings.newBuilder();
      batchUpdateEntitiesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateEntitiesOperationSettings = OperationCallSettings.newBuilder();
      batchDeleteEntitiesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeleteEntitiesOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listEntityTypesSettings,
              getEntityTypeSettings,
              createEntityTypeSettings,
              updateEntityTypeSettings,
              deleteEntityTypeSettings,
              batchUpdateEntityTypesSettings,
              batchDeleteEntityTypesSettings,
              batchCreateEntitiesSettings,
              batchUpdateEntitiesSettings,
              batchDeleteEntitiesSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(EntityTypesStubSettings settings) {
      super(settings);

      listEntityTypesSettings = settings.listEntityTypesSettings.toBuilder();
      getEntityTypeSettings = settings.getEntityTypeSettings.toBuilder();
      createEntityTypeSettings = settings.createEntityTypeSettings.toBuilder();
      updateEntityTypeSettings = settings.updateEntityTypeSettings.toBuilder();
      deleteEntityTypeSettings = settings.deleteEntityTypeSettings.toBuilder();
      batchUpdateEntityTypesSettings = settings.batchUpdateEntityTypesSettings.toBuilder();
      batchUpdateEntityTypesOperationSettings =
          settings.batchUpdateEntityTypesOperationSettings.toBuilder();
      batchDeleteEntityTypesSettings = settings.batchDeleteEntityTypesSettings.toBuilder();
      batchDeleteEntityTypesOperationSettings =
          settings.batchDeleteEntityTypesOperationSettings.toBuilder();
      batchCreateEntitiesSettings = settings.batchCreateEntitiesSettings.toBuilder();
      batchCreateEntitiesOperationSettings =
          settings.batchCreateEntitiesOperationSettings.toBuilder();
      batchUpdateEntitiesSettings = settings.batchUpdateEntitiesSettings.toBuilder();
      batchUpdateEntitiesOperationSettings =
          settings.batchUpdateEntitiesOperationSettings.toBuilder();
      batchDeleteEntitiesSettings = settings.batchDeleteEntitiesSettings.toBuilder();
      batchDeleteEntitiesOperationSettings =
          settings.batchDeleteEntitiesOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listEntityTypesSettings,
              getEntityTypeSettings,
              createEntityTypeSettings,
              updateEntityTypeSettings,
              deleteEntityTypeSettings,
              batchUpdateEntityTypesSettings,
              batchDeleteEntityTypesSettings,
              batchCreateEntitiesSettings,
              batchUpdateEntitiesSettings,
              batchDeleteEntitiesSettings,
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
          .listEntityTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEntityTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createEntityTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateEntityTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteEntityTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchUpdateEntityTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchDeleteEntityTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchCreateEntitiesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchUpdateEntitiesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchDeleteEntitiesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchUpdateEntityTypesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchUpdateEntityTypesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BatchUpdateEntityTypesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Struct.class))
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

      builder
          .batchDeleteEntityTypesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchDeleteEntityTypesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Struct.class))
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

      builder
          .batchCreateEntitiesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchCreateEntitiesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Struct.class))
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

      builder
          .batchUpdateEntitiesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchUpdateEntitiesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Struct.class))
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

      builder
          .batchDeleteEntitiesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchDeleteEntitiesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Struct.class))
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

    /** Returns the builder for the settings used for calls to listEntityTypes. */
    public PagedCallSettings.Builder<
            ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>
        listEntityTypesSettings() {
      return listEntityTypesSettings;
    }

    /** Returns the builder for the settings used for calls to getEntityType. */
    public UnaryCallSettings.Builder<GetEntityTypeRequest, EntityType> getEntityTypeSettings() {
      return getEntityTypeSettings;
    }

    /** Returns the builder for the settings used for calls to createEntityType. */
    public UnaryCallSettings.Builder<CreateEntityTypeRequest, EntityType>
        createEntityTypeSettings() {
      return createEntityTypeSettings;
    }

    /** Returns the builder for the settings used for calls to updateEntityType. */
    public UnaryCallSettings.Builder<UpdateEntityTypeRequest, EntityType>
        updateEntityTypeSettings() {
      return updateEntityTypeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEntityType. */
    public UnaryCallSettings.Builder<DeleteEntityTypeRequest, Empty> deleteEntityTypeSettings() {
      return deleteEntityTypeSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateEntityTypes. */
    public UnaryCallSettings.Builder<BatchUpdateEntityTypesRequest, Operation>
        batchUpdateEntityTypesSettings() {
      return batchUpdateEntityTypesSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateEntityTypes. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            BatchUpdateEntityTypesRequest, BatchUpdateEntityTypesResponse, Struct>
        batchUpdateEntityTypesOperationSettings() {
      return batchUpdateEntityTypesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteEntityTypes. */
    public UnaryCallSettings.Builder<BatchDeleteEntityTypesRequest, Operation>
        batchDeleteEntityTypesSettings() {
      return batchDeleteEntityTypesSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteEntityTypes. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<BatchDeleteEntityTypesRequest, Empty, Struct>
        batchDeleteEntityTypesOperationSettings() {
      return batchDeleteEntityTypesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateEntities. */
    public UnaryCallSettings.Builder<BatchCreateEntitiesRequest, Operation>
        batchCreateEntitiesSettings() {
      return batchCreateEntitiesSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateEntities. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<BatchCreateEntitiesRequest, Empty, Struct>
        batchCreateEntitiesOperationSettings() {
      return batchCreateEntitiesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateEntities. */
    public UnaryCallSettings.Builder<BatchUpdateEntitiesRequest, Operation>
        batchUpdateEntitiesSettings() {
      return batchUpdateEntitiesSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateEntities. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<BatchUpdateEntitiesRequest, Empty, Struct>
        batchUpdateEntitiesOperationSettings() {
      return batchUpdateEntitiesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteEntities. */
    public UnaryCallSettings.Builder<BatchDeleteEntitiesRequest, Operation>
        batchDeleteEntitiesSettings() {
      return batchDeleteEntitiesSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteEntities. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<BatchDeleteEntitiesRequest, Empty, Struct>
        batchDeleteEntitiesOperationSettings() {
      return batchDeleteEntitiesOperationSettings;
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
    public EntityTypesStubSettings build() throws IOException {
      return new EntityTypesStubSettings(this);
    }
  }
}
