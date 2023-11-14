/*
 * Copyright 2023 Google LLC
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

package com.google.maps.fleetengine.delivery.v1.stub;

import static google.maps.fleetengine.delivery.v1.DeliveryServiceClient.ListDeliveryVehiclesPagedResponse;
import static google.maps.fleetengine.delivery.v1.DeliveryServiceClient.ListTasksPagedResponse;
import static google.maps.fleetengine.delivery.v1.DeliveryServiceClient.SearchTasksPagedResponse;

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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import google.maps.fleetengine.delivery.v1.BatchCreateTasksRequest;
import google.maps.fleetengine.delivery.v1.BatchCreateTasksResponse;
import google.maps.fleetengine.delivery.v1.CreateDeliveryVehicleRequest;
import google.maps.fleetengine.delivery.v1.CreateTaskRequest;
import google.maps.fleetengine.delivery.v1.DeliveryVehicle;
import google.maps.fleetengine.delivery.v1.GetDeliveryVehicleRequest;
import google.maps.fleetengine.delivery.v1.GetTaskRequest;
import google.maps.fleetengine.delivery.v1.GetTaskTrackingInfoRequest;
import google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesRequest;
import google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesResponse;
import google.maps.fleetengine.delivery.v1.ListTasksRequest;
import google.maps.fleetengine.delivery.v1.ListTasksResponse;
import google.maps.fleetengine.delivery.v1.SearchTasksRequest;
import google.maps.fleetengine.delivery.v1.SearchTasksResponse;
import google.maps.fleetengine.delivery.v1.Task;
import google.maps.fleetengine.delivery.v1.TaskTrackingInfo;
import google.maps.fleetengine.delivery.v1.UpdateDeliveryVehicleRequest;
import google.maps.fleetengine.delivery.v1.UpdateTaskRequest;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DeliveryServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (fleetengine.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createDeliveryVehicle to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DeliveryServiceStubSettings.Builder deliveryServiceSettingsBuilder =
 *     DeliveryServiceStubSettings.newBuilder();
 * deliveryServiceSettingsBuilder
 *     .createDeliveryVehicleSettings()
 *     .setRetrySettings(
 *         deliveryServiceSettingsBuilder
 *             .createDeliveryVehicleSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DeliveryServiceStubSettings deliveryServiceSettings = deliveryServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DeliveryServiceStubSettings extends StubSettings<DeliveryServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateDeliveryVehicleRequest, DeliveryVehicle>
      createDeliveryVehicleSettings;
  private final UnaryCallSettings<GetDeliveryVehicleRequest, DeliveryVehicle>
      getDeliveryVehicleSettings;
  private final UnaryCallSettings<UpdateDeliveryVehicleRequest, DeliveryVehicle>
      updateDeliveryVehicleSettings;
  private final UnaryCallSettings<BatchCreateTasksRequest, BatchCreateTasksResponse>
      batchCreateTasksSettings;
  private final UnaryCallSettings<CreateTaskRequest, Task> createTaskSettings;
  private final UnaryCallSettings<GetTaskRequest, Task> getTaskSettings;
  private final PagedCallSettings<SearchTasksRequest, SearchTasksResponse, SearchTasksPagedResponse>
      searchTasksSettings;
  private final UnaryCallSettings<UpdateTaskRequest, Task> updateTaskSettings;
  private final PagedCallSettings<ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
      listTasksSettings;
  private final UnaryCallSettings<GetTaskTrackingInfoRequest, TaskTrackingInfo>
      getTaskTrackingInfoSettings;
  private final PagedCallSettings<
          ListDeliveryVehiclesRequest,
          ListDeliveryVehiclesResponse,
          ListDeliveryVehiclesPagedResponse>
      listDeliveryVehiclesSettings;

  private static final PagedListDescriptor<SearchTasksRequest, SearchTasksResponse, Task>
      SEARCH_TASKS_PAGE_STR_DESC =
          new PagedListDescriptor<SearchTasksRequest, SearchTasksResponse, Task>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchTasksRequest injectToken(SearchTasksRequest payload, String token) {
              return SearchTasksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchTasksRequest injectPageSize(SearchTasksRequest payload, int pageSize) {
              return SearchTasksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchTasksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchTasksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Task> extractResources(SearchTasksResponse payload) {
              return payload.getTasksList() == null
                  ? ImmutableList.<Task>of()
                  : payload.getTasksList();
            }
          };

  private static final PagedListDescriptor<ListTasksRequest, ListTasksResponse, Task>
      LIST_TASKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTasksRequest, ListTasksResponse, Task>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTasksRequest injectToken(ListTasksRequest payload, String token) {
              return ListTasksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTasksRequest injectPageSize(ListTasksRequest payload, int pageSize) {
              return ListTasksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTasksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTasksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Task> extractResources(ListTasksResponse payload) {
              return payload.getTasksList() == null
                  ? ImmutableList.<Task>of()
                  : payload.getTasksList();
            }
          };

  private static final PagedListDescriptor<
          ListDeliveryVehiclesRequest, ListDeliveryVehiclesResponse, DeliveryVehicle>
      LIST_DELIVERY_VEHICLES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDeliveryVehiclesRequest, ListDeliveryVehiclesResponse, DeliveryVehicle>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDeliveryVehiclesRequest injectToken(
                ListDeliveryVehiclesRequest payload, String token) {
              return ListDeliveryVehiclesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDeliveryVehiclesRequest injectPageSize(
                ListDeliveryVehiclesRequest payload, int pageSize) {
              return ListDeliveryVehiclesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDeliveryVehiclesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDeliveryVehiclesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DeliveryVehicle> extractResources(
                ListDeliveryVehiclesResponse payload) {
              return payload.getDeliveryVehiclesList() == null
                  ? ImmutableList.<DeliveryVehicle>of()
                  : payload.getDeliveryVehiclesList();
            }
          };

  private static final PagedListResponseFactory<
          SearchTasksRequest, SearchTasksResponse, SearchTasksPagedResponse>
      SEARCH_TASKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchTasksRequest, SearchTasksResponse, SearchTasksPagedResponse>() {
            @Override
            public ApiFuture<SearchTasksPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchTasksRequest, SearchTasksResponse> callable,
                SearchTasksRequest request,
                ApiCallContext context,
                ApiFuture<SearchTasksResponse> futureResponse) {
              PageContext<SearchTasksRequest, SearchTasksResponse, Task> pageContext =
                  PageContext.create(callable, SEARCH_TASKS_PAGE_STR_DESC, request, context);
              return SearchTasksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
      LIST_TASKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>() {
            @Override
            public ApiFuture<ListTasksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTasksRequest, ListTasksResponse> callable,
                ListTasksRequest request,
                ApiCallContext context,
                ApiFuture<ListTasksResponse> futureResponse) {
              PageContext<ListTasksRequest, ListTasksResponse, Task> pageContext =
                  PageContext.create(callable, LIST_TASKS_PAGE_STR_DESC, request, context);
              return ListTasksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDeliveryVehiclesRequest,
          ListDeliveryVehiclesResponse,
          ListDeliveryVehiclesPagedResponse>
      LIST_DELIVERY_VEHICLES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDeliveryVehiclesRequest,
              ListDeliveryVehiclesResponse,
              ListDeliveryVehiclesPagedResponse>() {
            @Override
            public ApiFuture<ListDeliveryVehiclesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDeliveryVehiclesRequest, ListDeliveryVehiclesResponse> callable,
                ListDeliveryVehiclesRequest request,
                ApiCallContext context,
                ApiFuture<ListDeliveryVehiclesResponse> futureResponse) {
              PageContext<
                      ListDeliveryVehiclesRequest, ListDeliveryVehiclesResponse, DeliveryVehicle>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DELIVERY_VEHICLES_PAGE_STR_DESC, request, context);
              return ListDeliveryVehiclesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createDeliveryVehicle. */
  public UnaryCallSettings<CreateDeliveryVehicleRequest, DeliveryVehicle>
      createDeliveryVehicleSettings() {
    return createDeliveryVehicleSettings;
  }

  /** Returns the object with the settings used for calls to getDeliveryVehicle. */
  public UnaryCallSettings<GetDeliveryVehicleRequest, DeliveryVehicle>
      getDeliveryVehicleSettings() {
    return getDeliveryVehicleSettings;
  }

  /** Returns the object with the settings used for calls to updateDeliveryVehicle. */
  public UnaryCallSettings<UpdateDeliveryVehicleRequest, DeliveryVehicle>
      updateDeliveryVehicleSettings() {
    return updateDeliveryVehicleSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateTasks. */
  public UnaryCallSettings<BatchCreateTasksRequest, BatchCreateTasksResponse>
      batchCreateTasksSettings() {
    return batchCreateTasksSettings;
  }

  /** Returns the object with the settings used for calls to createTask. */
  public UnaryCallSettings<CreateTaskRequest, Task> createTaskSettings() {
    return createTaskSettings;
  }

  /** Returns the object with the settings used for calls to getTask. */
  public UnaryCallSettings<GetTaskRequest, Task> getTaskSettings() {
    return getTaskSettings;
  }

  /**
   * Returns the object with the settings used for calls to searchTasks.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public PagedCallSettings<SearchTasksRequest, SearchTasksResponse, SearchTasksPagedResponse>
      searchTasksSettings() {
    return searchTasksSettings;
  }

  /** Returns the object with the settings used for calls to updateTask. */
  public UnaryCallSettings<UpdateTaskRequest, Task> updateTaskSettings() {
    return updateTaskSettings;
  }

  /** Returns the object with the settings used for calls to listTasks. */
  public PagedCallSettings<ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
      listTasksSettings() {
    return listTasksSettings;
  }

  /** Returns the object with the settings used for calls to getTaskTrackingInfo. */
  public UnaryCallSettings<GetTaskTrackingInfoRequest, TaskTrackingInfo>
      getTaskTrackingInfoSettings() {
    return getTaskTrackingInfoSettings;
  }

  /** Returns the object with the settings used for calls to listDeliveryVehicles. */
  public PagedCallSettings<
          ListDeliveryVehiclesRequest,
          ListDeliveryVehiclesResponse,
          ListDeliveryVehiclesPagedResponse>
      listDeliveryVehiclesSettings() {
    return listDeliveryVehiclesSettings;
  }

  public DeliveryServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDeliveryServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDeliveryServiceStub.create(this);
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
    return "fleetengine.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "fleetengine.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DeliveryServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DeliveryServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DeliveryServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DeliveryServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createDeliveryVehicleSettings = settingsBuilder.createDeliveryVehicleSettings().build();
    getDeliveryVehicleSettings = settingsBuilder.getDeliveryVehicleSettings().build();
    updateDeliveryVehicleSettings = settingsBuilder.updateDeliveryVehicleSettings().build();
    batchCreateTasksSettings = settingsBuilder.batchCreateTasksSettings().build();
    createTaskSettings = settingsBuilder.createTaskSettings().build();
    getTaskSettings = settingsBuilder.getTaskSettings().build();
    searchTasksSettings = settingsBuilder.searchTasksSettings().build();
    updateTaskSettings = settingsBuilder.updateTaskSettings().build();
    listTasksSettings = settingsBuilder.listTasksSettings().build();
    getTaskTrackingInfoSettings = settingsBuilder.getTaskTrackingInfoSettings().build();
    listDeliveryVehiclesSettings = settingsBuilder.listDeliveryVehiclesSettings().build();
  }

  /** Builder for DeliveryServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<DeliveryServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateDeliveryVehicleRequest, DeliveryVehicle>
        createDeliveryVehicleSettings;
    private final UnaryCallSettings.Builder<GetDeliveryVehicleRequest, DeliveryVehicle>
        getDeliveryVehicleSettings;
    private final UnaryCallSettings.Builder<UpdateDeliveryVehicleRequest, DeliveryVehicle>
        updateDeliveryVehicleSettings;
    private final UnaryCallSettings.Builder<BatchCreateTasksRequest, BatchCreateTasksResponse>
        batchCreateTasksSettings;
    private final UnaryCallSettings.Builder<CreateTaskRequest, Task> createTaskSettings;
    private final UnaryCallSettings.Builder<GetTaskRequest, Task> getTaskSettings;
    private final PagedCallSettings.Builder<
            SearchTasksRequest, SearchTasksResponse, SearchTasksPagedResponse>
        searchTasksSettings;
    private final UnaryCallSettings.Builder<UpdateTaskRequest, Task> updateTaskSettings;
    private final PagedCallSettings.Builder<
            ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
        listTasksSettings;
    private final UnaryCallSettings.Builder<GetTaskTrackingInfoRequest, TaskTrackingInfo>
        getTaskTrackingInfoSettings;
    private final PagedCallSettings.Builder<
            ListDeliveryVehiclesRequest,
            ListDeliveryVehiclesResponse,
            ListDeliveryVehiclesPagedResponse>
        listDeliveryVehiclesSettings;
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
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
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

      createDeliveryVehicleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDeliveryVehicleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDeliveryVehicleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateTasksSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTaskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getTaskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      searchTasksSettings = PagedCallSettings.newBuilder(SEARCH_TASKS_PAGE_STR_FACT);
      updateTaskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTasksSettings = PagedCallSettings.newBuilder(LIST_TASKS_PAGE_STR_FACT);
      getTaskTrackingInfoSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDeliveryVehiclesSettings =
          PagedCallSettings.newBuilder(LIST_DELIVERY_VEHICLES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDeliveryVehicleSettings,
              getDeliveryVehicleSettings,
              updateDeliveryVehicleSettings,
              batchCreateTasksSettings,
              createTaskSettings,
              getTaskSettings,
              searchTasksSettings,
              updateTaskSettings,
              listTasksSettings,
              getTaskTrackingInfoSettings,
              listDeliveryVehiclesSettings);
      initDefaults(this);
    }

    protected Builder(DeliveryServiceStubSettings settings) {
      super(settings);

      createDeliveryVehicleSettings = settings.createDeliveryVehicleSettings.toBuilder();
      getDeliveryVehicleSettings = settings.getDeliveryVehicleSettings.toBuilder();
      updateDeliveryVehicleSettings = settings.updateDeliveryVehicleSettings.toBuilder();
      batchCreateTasksSettings = settings.batchCreateTasksSettings.toBuilder();
      createTaskSettings = settings.createTaskSettings.toBuilder();
      getTaskSettings = settings.getTaskSettings.toBuilder();
      searchTasksSettings = settings.searchTasksSettings.toBuilder();
      updateTaskSettings = settings.updateTaskSettings.toBuilder();
      listTasksSettings = settings.listTasksSettings.toBuilder();
      getTaskTrackingInfoSettings = settings.getTaskTrackingInfoSettings.toBuilder();
      listDeliveryVehiclesSettings = settings.listDeliveryVehiclesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDeliveryVehicleSettings,
              getDeliveryVehicleSettings,
              updateDeliveryVehicleSettings,
              batchCreateTasksSettings,
              createTaskSettings,
              getTaskSettings,
              searchTasksSettings,
              updateTaskSettings,
              listTasksSettings,
              getTaskTrackingInfoSettings,
              listDeliveryVehiclesSettings);
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
          .createDeliveryVehicleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDeliveryVehicleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateDeliveryVehicleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchCreateTasksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createTaskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getTaskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .searchTasksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateTaskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listTasksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getTaskTrackingInfoSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDeliveryVehiclesSettings()
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

    /** Returns the builder for the settings used for calls to createDeliveryVehicle. */
    public UnaryCallSettings.Builder<CreateDeliveryVehicleRequest, DeliveryVehicle>
        createDeliveryVehicleSettings() {
      return createDeliveryVehicleSettings;
    }

    /** Returns the builder for the settings used for calls to getDeliveryVehicle. */
    public UnaryCallSettings.Builder<GetDeliveryVehicleRequest, DeliveryVehicle>
        getDeliveryVehicleSettings() {
      return getDeliveryVehicleSettings;
    }

    /** Returns the builder for the settings used for calls to updateDeliveryVehicle. */
    public UnaryCallSettings.Builder<UpdateDeliveryVehicleRequest, DeliveryVehicle>
        updateDeliveryVehicleSettings() {
      return updateDeliveryVehicleSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateTasks. */
    public UnaryCallSettings.Builder<BatchCreateTasksRequest, BatchCreateTasksResponse>
        batchCreateTasksSettings() {
      return batchCreateTasksSettings;
    }

    /** Returns the builder for the settings used for calls to createTask. */
    public UnaryCallSettings.Builder<CreateTaskRequest, Task> createTaskSettings() {
      return createTaskSettings;
    }

    /** Returns the builder for the settings used for calls to getTask. */
    public UnaryCallSettings.Builder<GetTaskRequest, Task> getTaskSettings() {
      return getTaskSettings;
    }

    /**
     * Returns the builder for the settings used for calls to searchTasks.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public PagedCallSettings.Builder<
            SearchTasksRequest, SearchTasksResponse, SearchTasksPagedResponse>
        searchTasksSettings() {
      return searchTasksSettings;
    }

    /** Returns the builder for the settings used for calls to updateTask. */
    public UnaryCallSettings.Builder<UpdateTaskRequest, Task> updateTaskSettings() {
      return updateTaskSettings;
    }

    /** Returns the builder for the settings used for calls to listTasks. */
    public PagedCallSettings.Builder<ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
        listTasksSettings() {
      return listTasksSettings;
    }

    /** Returns the builder for the settings used for calls to getTaskTrackingInfo. */
    public UnaryCallSettings.Builder<GetTaskTrackingInfoRequest, TaskTrackingInfo>
        getTaskTrackingInfoSettings() {
      return getTaskTrackingInfoSettings;
    }

    /** Returns the builder for the settings used for calls to listDeliveryVehicles. */
    public PagedCallSettings.Builder<
            ListDeliveryVehiclesRequest,
            ListDeliveryVehiclesResponse,
            ListDeliveryVehiclesPagedResponse>
        listDeliveryVehiclesSettings() {
      return listDeliveryVehiclesSettings;
    }

    @Override
    public DeliveryServiceStubSettings build() throws IOException {
      return new DeliveryServiceStubSettings(this);
    }
  }
}
