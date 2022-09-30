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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.DeploymentResourcePoolServiceClient.ListDeploymentResourcePoolsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DeploymentResourcePoolServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DeploymentResourcePoolServiceClient.QueryDeployedModelsPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.CreateDeploymentResourcePoolOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateDeploymentResourcePoolRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteDeploymentResourcePoolRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeployedModel;
import com.google.cloud.aiplatform.v1beta1.DeploymentResourcePool;
import com.google.cloud.aiplatform.v1beta1.GetDeploymentResourcePoolRequest;
import com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsRequest;
import com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsResponse;
import com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsRequest;
import com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsResponse;
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
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DeploymentResourcePoolServiceStub}.
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
 * <p>For example, to set the total timeout of getDeploymentResourcePool to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DeploymentResourcePoolServiceStubSettings.Builder deploymentResourcePoolServiceSettingsBuilder =
 *     DeploymentResourcePoolServiceStubSettings.newBuilder();
 * deploymentResourcePoolServiceSettingsBuilder
 *     .getDeploymentResourcePoolSettings()
 *     .setRetrySettings(
 *         deploymentResourcePoolServiceSettingsBuilder
 *             .getDeploymentResourcePoolSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DeploymentResourcePoolServiceStubSettings deploymentResourcePoolServiceSettings =
 *     deploymentResourcePoolServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DeploymentResourcePoolServiceStubSettings
    extends StubSettings<DeploymentResourcePoolServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateDeploymentResourcePoolRequest, Operation>
      createDeploymentResourcePoolSettings;
  private final OperationCallSettings<
          CreateDeploymentResourcePoolRequest,
          DeploymentResourcePool,
          CreateDeploymentResourcePoolOperationMetadata>
      createDeploymentResourcePoolOperationSettings;
  private final UnaryCallSettings<GetDeploymentResourcePoolRequest, DeploymentResourcePool>
      getDeploymentResourcePoolSettings;
  private final PagedCallSettings<
          ListDeploymentResourcePoolsRequest,
          ListDeploymentResourcePoolsResponse,
          ListDeploymentResourcePoolsPagedResponse>
      listDeploymentResourcePoolsSettings;
  private final UnaryCallSettings<DeleteDeploymentResourcePoolRequest, Operation>
      deleteDeploymentResourcePoolSettings;
  private final OperationCallSettings<
          DeleteDeploymentResourcePoolRequest, Empty, DeleteOperationMetadata>
      deleteDeploymentResourcePoolOperationSettings;
  private final PagedCallSettings<
          QueryDeployedModelsRequest, QueryDeployedModelsResponse, QueryDeployedModelsPagedResponse>
      queryDeployedModelsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListDeploymentResourcePoolsRequest,
          ListDeploymentResourcePoolsResponse,
          DeploymentResourcePool>
      LIST_DEPLOYMENT_RESOURCE_POOLS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDeploymentResourcePoolsRequest,
              ListDeploymentResourcePoolsResponse,
              DeploymentResourcePool>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDeploymentResourcePoolsRequest injectToken(
                ListDeploymentResourcePoolsRequest payload, String token) {
              return ListDeploymentResourcePoolsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListDeploymentResourcePoolsRequest injectPageSize(
                ListDeploymentResourcePoolsRequest payload, int pageSize) {
              return ListDeploymentResourcePoolsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListDeploymentResourcePoolsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDeploymentResourcePoolsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DeploymentResourcePool> extractResources(
                ListDeploymentResourcePoolsResponse payload) {
              return payload.getDeploymentResourcePoolsList() == null
                  ? ImmutableList.<DeploymentResourcePool>of()
                  : payload.getDeploymentResourcePoolsList();
            }
          };

  private static final PagedListDescriptor<
          QueryDeployedModelsRequest, QueryDeployedModelsResponse, DeployedModel>
      QUERY_DEPLOYED_MODELS_PAGE_STR_DESC =
          new PagedListDescriptor<
              QueryDeployedModelsRequest, QueryDeployedModelsResponse, DeployedModel>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public QueryDeployedModelsRequest injectToken(
                QueryDeployedModelsRequest payload, String token) {
              return QueryDeployedModelsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public QueryDeployedModelsRequest injectPageSize(
                QueryDeployedModelsRequest payload, int pageSize) {
              return QueryDeployedModelsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(QueryDeployedModelsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(QueryDeployedModelsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DeployedModel> extractResources(QueryDeployedModelsResponse payload) {
              return payload.getDeployedModelsList() == null
                  ? ImmutableList.<DeployedModel>of()
                  : payload.getDeployedModelsList();
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
          ListDeploymentResourcePoolsRequest,
          ListDeploymentResourcePoolsResponse,
          ListDeploymentResourcePoolsPagedResponse>
      LIST_DEPLOYMENT_RESOURCE_POOLS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDeploymentResourcePoolsRequest,
              ListDeploymentResourcePoolsResponse,
              ListDeploymentResourcePoolsPagedResponse>() {
            @Override
            public ApiFuture<ListDeploymentResourcePoolsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListDeploymentResourcePoolsRequest, ListDeploymentResourcePoolsResponse>
                    callable,
                ListDeploymentResourcePoolsRequest request,
                ApiCallContext context,
                ApiFuture<ListDeploymentResourcePoolsResponse> futureResponse) {
              PageContext<
                      ListDeploymentResourcePoolsRequest,
                      ListDeploymentResourcePoolsResponse,
                      DeploymentResourcePool>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DEPLOYMENT_RESOURCE_POOLS_PAGE_STR_DESC, request, context);
              return ListDeploymentResourcePoolsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          QueryDeployedModelsRequest, QueryDeployedModelsResponse, QueryDeployedModelsPagedResponse>
      QUERY_DEPLOYED_MODELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              QueryDeployedModelsRequest,
              QueryDeployedModelsResponse,
              QueryDeployedModelsPagedResponse>() {
            @Override
            public ApiFuture<QueryDeployedModelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<QueryDeployedModelsRequest, QueryDeployedModelsResponse> callable,
                QueryDeployedModelsRequest request,
                ApiCallContext context,
                ApiFuture<QueryDeployedModelsResponse> futureResponse) {
              PageContext<QueryDeployedModelsRequest, QueryDeployedModelsResponse, DeployedModel>
                  pageContext =
                      PageContext.create(
                          callable, QUERY_DEPLOYED_MODELS_PAGE_STR_DESC, request, context);
              return QueryDeployedModelsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createDeploymentResourcePool. */
  public UnaryCallSettings<CreateDeploymentResourcePoolRequest, Operation>
      createDeploymentResourcePoolSettings() {
    return createDeploymentResourcePoolSettings;
  }

  /** Returns the object with the settings used for calls to createDeploymentResourcePool. */
  public OperationCallSettings<
          CreateDeploymentResourcePoolRequest,
          DeploymentResourcePool,
          CreateDeploymentResourcePoolOperationMetadata>
      createDeploymentResourcePoolOperationSettings() {
    return createDeploymentResourcePoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to getDeploymentResourcePool. */
  public UnaryCallSettings<GetDeploymentResourcePoolRequest, DeploymentResourcePool>
      getDeploymentResourcePoolSettings() {
    return getDeploymentResourcePoolSettings;
  }

  /** Returns the object with the settings used for calls to listDeploymentResourcePools. */
  public PagedCallSettings<
          ListDeploymentResourcePoolsRequest,
          ListDeploymentResourcePoolsResponse,
          ListDeploymentResourcePoolsPagedResponse>
      listDeploymentResourcePoolsSettings() {
    return listDeploymentResourcePoolsSettings;
  }

  /** Returns the object with the settings used for calls to deleteDeploymentResourcePool. */
  public UnaryCallSettings<DeleteDeploymentResourcePoolRequest, Operation>
      deleteDeploymentResourcePoolSettings() {
    return deleteDeploymentResourcePoolSettings;
  }

  /** Returns the object with the settings used for calls to deleteDeploymentResourcePool. */
  public OperationCallSettings<DeleteDeploymentResourcePoolRequest, Empty, DeleteOperationMetadata>
      deleteDeploymentResourcePoolOperationSettings() {
    return deleteDeploymentResourcePoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to queryDeployedModels. */
  public PagedCallSettings<
          QueryDeployedModelsRequest, QueryDeployedModelsResponse, QueryDeployedModelsPagedResponse>
      queryDeployedModelsSettings() {
    return queryDeployedModelsSettings;
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

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public DeploymentResourcePoolServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDeploymentResourcePoolServiceStub.create(this);
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

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "aiplatform.mtls.googleapis.com:443";
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
            "gapic",
            GaxProperties.getLibraryVersion(DeploymentResourcePoolServiceStubSettings.class))
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

  protected DeploymentResourcePoolServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createDeploymentResourcePoolSettings =
        settingsBuilder.createDeploymentResourcePoolSettings().build();
    createDeploymentResourcePoolOperationSettings =
        settingsBuilder.createDeploymentResourcePoolOperationSettings().build();
    getDeploymentResourcePoolSettings = settingsBuilder.getDeploymentResourcePoolSettings().build();
    listDeploymentResourcePoolsSettings =
        settingsBuilder.listDeploymentResourcePoolsSettings().build();
    deleteDeploymentResourcePoolSettings =
        settingsBuilder.deleteDeploymentResourcePoolSettings().build();
    deleteDeploymentResourcePoolOperationSettings =
        settingsBuilder.deleteDeploymentResourcePoolOperationSettings().build();
    queryDeployedModelsSettings = settingsBuilder.queryDeployedModelsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for DeploymentResourcePoolServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<DeploymentResourcePoolServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateDeploymentResourcePoolRequest, Operation>
        createDeploymentResourcePoolSettings;
    private final OperationCallSettings.Builder<
            CreateDeploymentResourcePoolRequest,
            DeploymentResourcePool,
            CreateDeploymentResourcePoolOperationMetadata>
        createDeploymentResourcePoolOperationSettings;
    private final UnaryCallSettings.Builder<
            GetDeploymentResourcePoolRequest, DeploymentResourcePool>
        getDeploymentResourcePoolSettings;
    private final PagedCallSettings.Builder<
            ListDeploymentResourcePoolsRequest,
            ListDeploymentResourcePoolsResponse,
            ListDeploymentResourcePoolsPagedResponse>
        listDeploymentResourcePoolsSettings;
    private final UnaryCallSettings.Builder<DeleteDeploymentResourcePoolRequest, Operation>
        deleteDeploymentResourcePoolSettings;
    private final OperationCallSettings.Builder<
            DeleteDeploymentResourcePoolRequest, Empty, DeleteOperationMetadata>
        deleteDeploymentResourcePoolOperationSettings;
    private final PagedCallSettings.Builder<
            QueryDeployedModelsRequest,
            QueryDeployedModelsResponse,
            QueryDeployedModelsPagedResponse>
        queryDeployedModelsSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
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

      createDeploymentResourcePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDeploymentResourcePoolOperationSettings = OperationCallSettings.newBuilder();
      getDeploymentResourcePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDeploymentResourcePoolsSettings =
          PagedCallSettings.newBuilder(LIST_DEPLOYMENT_RESOURCE_POOLS_PAGE_STR_FACT);
      deleteDeploymentResourcePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDeploymentResourcePoolOperationSettings = OperationCallSettings.newBuilder();
      queryDeployedModelsSettings =
          PagedCallSettings.newBuilder(QUERY_DEPLOYED_MODELS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDeploymentResourcePoolSettings,
              getDeploymentResourcePoolSettings,
              listDeploymentResourcePoolsSettings,
              deleteDeploymentResourcePoolSettings,
              queryDeployedModelsSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(DeploymentResourcePoolServiceStubSettings settings) {
      super(settings);

      createDeploymentResourcePoolSettings =
          settings.createDeploymentResourcePoolSettings.toBuilder();
      createDeploymentResourcePoolOperationSettings =
          settings.createDeploymentResourcePoolOperationSettings.toBuilder();
      getDeploymentResourcePoolSettings = settings.getDeploymentResourcePoolSettings.toBuilder();
      listDeploymentResourcePoolsSettings =
          settings.listDeploymentResourcePoolsSettings.toBuilder();
      deleteDeploymentResourcePoolSettings =
          settings.deleteDeploymentResourcePoolSettings.toBuilder();
      deleteDeploymentResourcePoolOperationSettings =
          settings.deleteDeploymentResourcePoolOperationSettings.toBuilder();
      queryDeployedModelsSettings = settings.queryDeployedModelsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDeploymentResourcePoolSettings,
              getDeploymentResourcePoolSettings,
              listDeploymentResourcePoolsSettings,
              deleteDeploymentResourcePoolSettings,
              queryDeployedModelsSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .createDeploymentResourcePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getDeploymentResourcePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listDeploymentResourcePoolsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteDeploymentResourcePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .queryDeployedModelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createDeploymentResourcePoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDeploymentResourcePoolRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DeploymentResourcePool.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateDeploymentResourcePoolOperationMetadata.class))
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
          .deleteDeploymentResourcePoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDeploymentResourcePoolRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to createDeploymentResourcePool. */
    public UnaryCallSettings.Builder<CreateDeploymentResourcePoolRequest, Operation>
        createDeploymentResourcePoolSettings() {
      return createDeploymentResourcePoolSettings;
    }

    /** Returns the builder for the settings used for calls to createDeploymentResourcePool. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateDeploymentResourcePoolRequest,
            DeploymentResourcePool,
            CreateDeploymentResourcePoolOperationMetadata>
        createDeploymentResourcePoolOperationSettings() {
      return createDeploymentResourcePoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getDeploymentResourcePool. */
    public UnaryCallSettings.Builder<GetDeploymentResourcePoolRequest, DeploymentResourcePool>
        getDeploymentResourcePoolSettings() {
      return getDeploymentResourcePoolSettings;
    }

    /** Returns the builder for the settings used for calls to listDeploymentResourcePools. */
    public PagedCallSettings.Builder<
            ListDeploymentResourcePoolsRequest,
            ListDeploymentResourcePoolsResponse,
            ListDeploymentResourcePoolsPagedResponse>
        listDeploymentResourcePoolsSettings() {
      return listDeploymentResourcePoolsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDeploymentResourcePool. */
    public UnaryCallSettings.Builder<DeleteDeploymentResourcePoolRequest, Operation>
        deleteDeploymentResourcePoolSettings() {
      return deleteDeploymentResourcePoolSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDeploymentResourcePool. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteDeploymentResourcePoolRequest, Empty, DeleteOperationMetadata>
        deleteDeploymentResourcePoolOperationSettings() {
      return deleteDeploymentResourcePoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to queryDeployedModels. */
    public PagedCallSettings.Builder<
            QueryDeployedModelsRequest,
            QueryDeployedModelsResponse,
            QueryDeployedModelsPagedResponse>
        queryDeployedModelsSettings() {
      return queryDeployedModelsSettings;
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public DeploymentResourcePoolServiceStubSettings build() throws IOException {
      return new DeploymentResourcePoolServiceStubSettings(this);
    }
  }
}
