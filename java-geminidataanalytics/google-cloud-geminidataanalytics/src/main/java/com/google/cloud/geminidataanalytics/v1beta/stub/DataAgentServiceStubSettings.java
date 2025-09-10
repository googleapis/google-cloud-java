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

package com.google.cloud.geminidataanalytics.v1beta.stub;

import static com.google.cloud.geminidataanalytics.v1beta.DataAgentServiceClient.ListAccessibleDataAgentsPagedResponse;
import static com.google.cloud.geminidataanalytics.v1beta.DataAgentServiceClient.ListDataAgentsPagedResponse;
import static com.google.cloud.geminidataanalytics.v1beta.DataAgentServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.geminidataanalytics.v1beta.CreateDataAgentRequest;
import com.google.cloud.geminidataanalytics.v1beta.DataAgent;
import com.google.cloud.geminidataanalytics.v1beta.DeleteDataAgentRequest;
import com.google.cloud.geminidataanalytics.v1beta.GetDataAgentRequest;
import com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsRequest;
import com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsResponse;
import com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsRequest;
import com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsResponse;
import com.google.cloud.geminidataanalytics.v1beta.OperationMetadata;
import com.google.cloud.geminidataanalytics.v1beta.UpdateDataAgentRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataAgentServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (geminidataanalytics.googleapis.com) and default port (443) are
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
 * of getDataAgent:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataAgentServiceStubSettings.Builder dataAgentServiceSettingsBuilder =
 *     DataAgentServiceStubSettings.newBuilder();
 * dataAgentServiceSettingsBuilder
 *     .getDataAgentSettings()
 *     .setRetrySettings(
 *         dataAgentServiceSettingsBuilder
 *             .getDataAgentSettings()
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
 * DataAgentServiceStubSettings dataAgentServiceSettings = dataAgentServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createDataAgent:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataAgentServiceStubSettings.Builder dataAgentServiceSettingsBuilder =
 *     DataAgentServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * dataAgentServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataAgentServiceStubSettings extends StubSettings<DataAgentServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListDataAgentsRequest, ListDataAgentsResponse, ListDataAgentsPagedResponse>
      listDataAgentsSettings;
  private final PagedCallSettings<
          ListAccessibleDataAgentsRequest,
          ListAccessibleDataAgentsResponse,
          ListAccessibleDataAgentsPagedResponse>
      listAccessibleDataAgentsSettings;
  private final UnaryCallSettings<GetDataAgentRequest, DataAgent> getDataAgentSettings;
  private final UnaryCallSettings<CreateDataAgentRequest, Operation> createDataAgentSettings;
  private final OperationCallSettings<CreateDataAgentRequest, DataAgent, OperationMetadata>
      createDataAgentOperationSettings;
  private final UnaryCallSettings<UpdateDataAgentRequest, Operation> updateDataAgentSettings;
  private final OperationCallSettings<UpdateDataAgentRequest, DataAgent, OperationMetadata>
      updateDataAgentOperationSettings;
  private final UnaryCallSettings<DeleteDataAgentRequest, Operation> deleteDataAgentSettings;
  private final OperationCallSettings<DeleteDataAgentRequest, Empty, OperationMetadata>
      deleteDataAgentOperationSettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListDataAgentsRequest, ListDataAgentsResponse, DataAgent>
      LIST_DATA_AGENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDataAgentsRequest, ListDataAgentsResponse, DataAgent>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataAgentsRequest injectToken(ListDataAgentsRequest payload, String token) {
              return ListDataAgentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataAgentsRequest injectPageSize(
                ListDataAgentsRequest payload, int pageSize) {
              return ListDataAgentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataAgentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataAgentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataAgent> extractResources(ListDataAgentsResponse payload) {
              return payload.getDataAgentsList();
            }
          };

  private static final PagedListDescriptor<
          ListAccessibleDataAgentsRequest, ListAccessibleDataAgentsResponse, DataAgent>
      LIST_ACCESSIBLE_DATA_AGENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAccessibleDataAgentsRequest, ListAccessibleDataAgentsResponse, DataAgent>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAccessibleDataAgentsRequest injectToken(
                ListAccessibleDataAgentsRequest payload, String token) {
              return ListAccessibleDataAgentsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListAccessibleDataAgentsRequest injectPageSize(
                ListAccessibleDataAgentsRequest payload, int pageSize) {
              return ListAccessibleDataAgentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListAccessibleDataAgentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAccessibleDataAgentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataAgent> extractResources(ListAccessibleDataAgentsResponse payload) {
              return payload.getDataAgentsList();
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
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListDataAgentsRequest, ListDataAgentsResponse, ListDataAgentsPagedResponse>
      LIST_DATA_AGENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataAgentsRequest, ListDataAgentsResponse, ListDataAgentsPagedResponse>() {
            @Override
            public ApiFuture<ListDataAgentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataAgentsRequest, ListDataAgentsResponse> callable,
                ListDataAgentsRequest request,
                ApiCallContext context,
                ApiFuture<ListDataAgentsResponse> futureResponse) {
              PageContext<ListDataAgentsRequest, ListDataAgentsResponse, DataAgent> pageContext =
                  PageContext.create(callable, LIST_DATA_AGENTS_PAGE_STR_DESC, request, context);
              return ListDataAgentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAccessibleDataAgentsRequest,
          ListAccessibleDataAgentsResponse,
          ListAccessibleDataAgentsPagedResponse>
      LIST_ACCESSIBLE_DATA_AGENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAccessibleDataAgentsRequest,
              ListAccessibleDataAgentsResponse,
              ListAccessibleDataAgentsPagedResponse>() {
            @Override
            public ApiFuture<ListAccessibleDataAgentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAccessibleDataAgentsRequest, ListAccessibleDataAgentsResponse>
                    callable,
                ListAccessibleDataAgentsRequest request,
                ApiCallContext context,
                ApiFuture<ListAccessibleDataAgentsResponse> futureResponse) {
              PageContext<
                      ListAccessibleDataAgentsRequest, ListAccessibleDataAgentsResponse, DataAgent>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ACCESSIBLE_DATA_AGENTS_PAGE_STR_DESC, request, context);
              return ListAccessibleDataAgentsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listDataAgents. */
  public PagedCallSettings<
          ListDataAgentsRequest, ListDataAgentsResponse, ListDataAgentsPagedResponse>
      listDataAgentsSettings() {
    return listDataAgentsSettings;
  }

  /** Returns the object with the settings used for calls to listAccessibleDataAgents. */
  public PagedCallSettings<
          ListAccessibleDataAgentsRequest,
          ListAccessibleDataAgentsResponse,
          ListAccessibleDataAgentsPagedResponse>
      listAccessibleDataAgentsSettings() {
    return listAccessibleDataAgentsSettings;
  }

  /** Returns the object with the settings used for calls to getDataAgent. */
  public UnaryCallSettings<GetDataAgentRequest, DataAgent> getDataAgentSettings() {
    return getDataAgentSettings;
  }

  /** Returns the object with the settings used for calls to createDataAgent. */
  public UnaryCallSettings<CreateDataAgentRequest, Operation> createDataAgentSettings() {
    return createDataAgentSettings;
  }

  /** Returns the object with the settings used for calls to createDataAgent. */
  public OperationCallSettings<CreateDataAgentRequest, DataAgent, OperationMetadata>
      createDataAgentOperationSettings() {
    return createDataAgentOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateDataAgent. */
  public UnaryCallSettings<UpdateDataAgentRequest, Operation> updateDataAgentSettings() {
    return updateDataAgentSettings;
  }

  /** Returns the object with the settings used for calls to updateDataAgent. */
  public OperationCallSettings<UpdateDataAgentRequest, DataAgent, OperationMetadata>
      updateDataAgentOperationSettings() {
    return updateDataAgentOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataAgent. */
  public UnaryCallSettings<DeleteDataAgentRequest, Operation> deleteDataAgentSettings() {
    return deleteDataAgentSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataAgent. */
  public OperationCallSettings<DeleteDataAgentRequest, Empty, OperationMetadata>
      deleteDataAgentOperationSettings() {
    return deleteDataAgentOperationSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
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

  public DataAgentServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataAgentServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDataAgentServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "geminidataanalytics";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "geminidataanalytics.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "geminidataanalytics.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DataAgentServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataAgentServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataAgentServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DataAgentServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listDataAgentsSettings = settingsBuilder.listDataAgentsSettings().build();
    listAccessibleDataAgentsSettings = settingsBuilder.listAccessibleDataAgentsSettings().build();
    getDataAgentSettings = settingsBuilder.getDataAgentSettings().build();
    createDataAgentSettings = settingsBuilder.createDataAgentSettings().build();
    createDataAgentOperationSettings = settingsBuilder.createDataAgentOperationSettings().build();
    updateDataAgentSettings = settingsBuilder.updateDataAgentSettings().build();
    updateDataAgentOperationSettings = settingsBuilder.updateDataAgentOperationSettings().build();
    deleteDataAgentSettings = settingsBuilder.deleteDataAgentSettings().build();
    deleteDataAgentOperationSettings = settingsBuilder.deleteDataAgentOperationSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for DataAgentServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<DataAgentServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListDataAgentsRequest, ListDataAgentsResponse, ListDataAgentsPagedResponse>
        listDataAgentsSettings;
    private final PagedCallSettings.Builder<
            ListAccessibleDataAgentsRequest,
            ListAccessibleDataAgentsResponse,
            ListAccessibleDataAgentsPagedResponse>
        listAccessibleDataAgentsSettings;
    private final UnaryCallSettings.Builder<GetDataAgentRequest, DataAgent> getDataAgentSettings;
    private final UnaryCallSettings.Builder<CreateDataAgentRequest, Operation>
        createDataAgentSettings;
    private final OperationCallSettings.Builder<
            CreateDataAgentRequest, DataAgent, OperationMetadata>
        createDataAgentOperationSettings;
    private final UnaryCallSettings.Builder<UpdateDataAgentRequest, Operation>
        updateDataAgentSettings;
    private final OperationCallSettings.Builder<
            UpdateDataAgentRequest, DataAgent, OperationMetadata>
        updateDataAgentOperationSettings;
    private final UnaryCallSettings.Builder<DeleteDataAgentRequest, Operation>
        deleteDataAgentSettings;
    private final OperationCallSettings.Builder<DeleteDataAgentRequest, Empty, OperationMetadata>
        deleteDataAgentOperationSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
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
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listDataAgentsSettings = PagedCallSettings.newBuilder(LIST_DATA_AGENTS_PAGE_STR_FACT);
      listAccessibleDataAgentsSettings =
          PagedCallSettings.newBuilder(LIST_ACCESSIBLE_DATA_AGENTS_PAGE_STR_FACT);
      getDataAgentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDataAgentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDataAgentOperationSettings = OperationCallSettings.newBuilder();
      updateDataAgentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDataAgentOperationSettings = OperationCallSettings.newBuilder();
      deleteDataAgentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDataAgentOperationSettings = OperationCallSettings.newBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listDataAgentsSettings,
              listAccessibleDataAgentsSettings,
              getDataAgentSettings,
              createDataAgentSettings,
              updateDataAgentSettings,
              deleteDataAgentSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(DataAgentServiceStubSettings settings) {
      super(settings);

      listDataAgentsSettings = settings.listDataAgentsSettings.toBuilder();
      listAccessibleDataAgentsSettings = settings.listAccessibleDataAgentsSettings.toBuilder();
      getDataAgentSettings = settings.getDataAgentSettings.toBuilder();
      createDataAgentSettings = settings.createDataAgentSettings.toBuilder();
      createDataAgentOperationSettings = settings.createDataAgentOperationSettings.toBuilder();
      updateDataAgentSettings = settings.updateDataAgentSettings.toBuilder();
      updateDataAgentOperationSettings = settings.updateDataAgentOperationSettings.toBuilder();
      deleteDataAgentSettings = settings.deleteDataAgentSettings.toBuilder();
      deleteDataAgentOperationSettings = settings.deleteDataAgentOperationSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listDataAgentsSettings,
              listAccessibleDataAgentsSettings,
              getDataAgentSettings,
              createDataAgentSettings,
              updateDataAgentSettings,
              deleteDataAgentSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              listLocationsSettings,
              getLocationSettings);
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
          .listDataAgentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAccessibleDataAgentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDataAgentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createDataAgentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateDataAgentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteDataAgentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setIamPolicySettings()
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
          .createDataAgentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDataAgentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DataAgent.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .updateDataAgentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDataAgentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DataAgent.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteDataAgentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDataAgentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to listDataAgents. */
    public PagedCallSettings.Builder<
            ListDataAgentsRequest, ListDataAgentsResponse, ListDataAgentsPagedResponse>
        listDataAgentsSettings() {
      return listDataAgentsSettings;
    }

    /** Returns the builder for the settings used for calls to listAccessibleDataAgents. */
    public PagedCallSettings.Builder<
            ListAccessibleDataAgentsRequest,
            ListAccessibleDataAgentsResponse,
            ListAccessibleDataAgentsPagedResponse>
        listAccessibleDataAgentsSettings() {
      return listAccessibleDataAgentsSettings;
    }

    /** Returns the builder for the settings used for calls to getDataAgent. */
    public UnaryCallSettings.Builder<GetDataAgentRequest, DataAgent> getDataAgentSettings() {
      return getDataAgentSettings;
    }

    /** Returns the builder for the settings used for calls to createDataAgent. */
    public UnaryCallSettings.Builder<CreateDataAgentRequest, Operation> createDataAgentSettings() {
      return createDataAgentSettings;
    }

    /** Returns the builder for the settings used for calls to createDataAgent. */
    public OperationCallSettings.Builder<CreateDataAgentRequest, DataAgent, OperationMetadata>
        createDataAgentOperationSettings() {
      return createDataAgentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataAgent. */
    public UnaryCallSettings.Builder<UpdateDataAgentRequest, Operation> updateDataAgentSettings() {
      return updateDataAgentSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataAgent. */
    public OperationCallSettings.Builder<UpdateDataAgentRequest, DataAgent, OperationMetadata>
        updateDataAgentOperationSettings() {
      return updateDataAgentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataAgent. */
    public UnaryCallSettings.Builder<DeleteDataAgentRequest, Operation> deleteDataAgentSettings() {
      return deleteDataAgentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataAgent. */
    public OperationCallSettings.Builder<DeleteDataAgentRequest, Empty, OperationMetadata>
        deleteDataAgentOperationSettings() {
      return deleteDataAgentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
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
    public DataAgentServiceStubSettings build() throws IOException {
      return new DataAgentServiceStubSettings(this);
    }
  }
}
