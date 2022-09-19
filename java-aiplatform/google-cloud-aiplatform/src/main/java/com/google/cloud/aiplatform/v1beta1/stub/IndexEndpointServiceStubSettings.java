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

import static com.google.cloud.aiplatform.v1beta1.IndexEndpointServiceClient.ListIndexEndpointsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.IndexEndpointServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.CreateIndexEndpointOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateIndexEndpointRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteIndexEndpointRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeployIndexOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeployIndexRequest;
import com.google.cloud.aiplatform.v1beta1.DeployIndexResponse;
import com.google.cloud.aiplatform.v1beta1.GetIndexEndpointRequest;
import com.google.cloud.aiplatform.v1beta1.IndexEndpoint;
import com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsRequest;
import com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsResponse;
import com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexRequest;
import com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexResponse;
import com.google.cloud.aiplatform.v1beta1.UndeployIndexOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UndeployIndexRequest;
import com.google.cloud.aiplatform.v1beta1.UndeployIndexResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateIndexEndpointRequest;
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
 * Settings class to configure an instance of {@link IndexEndpointServiceStub}.
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
 * <p>For example, to set the total timeout of getIndexEndpoint to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IndexEndpointServiceStubSettings.Builder indexEndpointServiceSettingsBuilder =
 *     IndexEndpointServiceStubSettings.newBuilder();
 * indexEndpointServiceSettingsBuilder
 *     .getIndexEndpointSettings()
 *     .setRetrySettings(
 *         indexEndpointServiceSettingsBuilder
 *             .getIndexEndpointSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * IndexEndpointServiceStubSettings indexEndpointServiceSettings =
 *     indexEndpointServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class IndexEndpointServiceStubSettings
    extends StubSettings<IndexEndpointServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateIndexEndpointRequest, Operation>
      createIndexEndpointSettings;
  private final OperationCallSettings<
          CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointOperationMetadata>
      createIndexEndpointOperationSettings;
  private final UnaryCallSettings<GetIndexEndpointRequest, IndexEndpoint> getIndexEndpointSettings;
  private final PagedCallSettings<
          ListIndexEndpointsRequest, ListIndexEndpointsResponse, ListIndexEndpointsPagedResponse>
      listIndexEndpointsSettings;
  private final UnaryCallSettings<UpdateIndexEndpointRequest, IndexEndpoint>
      updateIndexEndpointSettings;
  private final UnaryCallSettings<DeleteIndexEndpointRequest, Operation>
      deleteIndexEndpointSettings;
  private final OperationCallSettings<DeleteIndexEndpointRequest, Empty, DeleteOperationMetadata>
      deleteIndexEndpointOperationSettings;
  private final UnaryCallSettings<DeployIndexRequest, Operation> deployIndexSettings;
  private final OperationCallSettings<
          DeployIndexRequest, DeployIndexResponse, DeployIndexOperationMetadata>
      deployIndexOperationSettings;
  private final UnaryCallSettings<UndeployIndexRequest, Operation> undeployIndexSettings;
  private final OperationCallSettings<
          UndeployIndexRequest, UndeployIndexResponse, UndeployIndexOperationMetadata>
      undeployIndexOperationSettings;
  private final UnaryCallSettings<MutateDeployedIndexRequest, Operation>
      mutateDeployedIndexSettings;
  private final OperationCallSettings<
          MutateDeployedIndexRequest,
          MutateDeployedIndexResponse,
          MutateDeployedIndexOperationMetadata>
      mutateDeployedIndexOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListIndexEndpointsRequest, ListIndexEndpointsResponse, IndexEndpoint>
      LIST_INDEX_ENDPOINTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListIndexEndpointsRequest, ListIndexEndpointsResponse, IndexEndpoint>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListIndexEndpointsRequest injectToken(
                ListIndexEndpointsRequest payload, String token) {
              return ListIndexEndpointsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListIndexEndpointsRequest injectPageSize(
                ListIndexEndpointsRequest payload, int pageSize) {
              return ListIndexEndpointsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListIndexEndpointsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListIndexEndpointsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<IndexEndpoint> extractResources(ListIndexEndpointsResponse payload) {
              return payload.getIndexEndpointsList() == null
                  ? ImmutableList.<IndexEndpoint>of()
                  : payload.getIndexEndpointsList();
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
          ListIndexEndpointsRequest, ListIndexEndpointsResponse, ListIndexEndpointsPagedResponse>
      LIST_INDEX_ENDPOINTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListIndexEndpointsRequest,
              ListIndexEndpointsResponse,
              ListIndexEndpointsPagedResponse>() {
            @Override
            public ApiFuture<ListIndexEndpointsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListIndexEndpointsRequest, ListIndexEndpointsResponse> callable,
                ListIndexEndpointsRequest request,
                ApiCallContext context,
                ApiFuture<ListIndexEndpointsResponse> futureResponse) {
              PageContext<ListIndexEndpointsRequest, ListIndexEndpointsResponse, IndexEndpoint>
                  pageContext =
                      PageContext.create(
                          callable, LIST_INDEX_ENDPOINTS_PAGE_STR_DESC, request, context);
              return ListIndexEndpointsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createIndexEndpoint. */
  public UnaryCallSettings<CreateIndexEndpointRequest, Operation> createIndexEndpointSettings() {
    return createIndexEndpointSettings;
  }

  /** Returns the object with the settings used for calls to createIndexEndpoint. */
  public OperationCallSettings<
          CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointOperationMetadata>
      createIndexEndpointOperationSettings() {
    return createIndexEndpointOperationSettings;
  }

  /** Returns the object with the settings used for calls to getIndexEndpoint. */
  public UnaryCallSettings<GetIndexEndpointRequest, IndexEndpoint> getIndexEndpointSettings() {
    return getIndexEndpointSettings;
  }

  /** Returns the object with the settings used for calls to listIndexEndpoints. */
  public PagedCallSettings<
          ListIndexEndpointsRequest, ListIndexEndpointsResponse, ListIndexEndpointsPagedResponse>
      listIndexEndpointsSettings() {
    return listIndexEndpointsSettings;
  }

  /** Returns the object with the settings used for calls to updateIndexEndpoint. */
  public UnaryCallSettings<UpdateIndexEndpointRequest, IndexEndpoint>
      updateIndexEndpointSettings() {
    return updateIndexEndpointSettings;
  }

  /** Returns the object with the settings used for calls to deleteIndexEndpoint. */
  public UnaryCallSettings<DeleteIndexEndpointRequest, Operation> deleteIndexEndpointSettings() {
    return deleteIndexEndpointSettings;
  }

  /** Returns the object with the settings used for calls to deleteIndexEndpoint. */
  public OperationCallSettings<DeleteIndexEndpointRequest, Empty, DeleteOperationMetadata>
      deleteIndexEndpointOperationSettings() {
    return deleteIndexEndpointOperationSettings;
  }

  /** Returns the object with the settings used for calls to deployIndex. */
  public UnaryCallSettings<DeployIndexRequest, Operation> deployIndexSettings() {
    return deployIndexSettings;
  }

  /** Returns the object with the settings used for calls to deployIndex. */
  public OperationCallSettings<
          DeployIndexRequest, DeployIndexResponse, DeployIndexOperationMetadata>
      deployIndexOperationSettings() {
    return deployIndexOperationSettings;
  }

  /** Returns the object with the settings used for calls to undeployIndex. */
  public UnaryCallSettings<UndeployIndexRequest, Operation> undeployIndexSettings() {
    return undeployIndexSettings;
  }

  /** Returns the object with the settings used for calls to undeployIndex. */
  public OperationCallSettings<
          UndeployIndexRequest, UndeployIndexResponse, UndeployIndexOperationMetadata>
      undeployIndexOperationSettings() {
    return undeployIndexOperationSettings;
  }

  /** Returns the object with the settings used for calls to mutateDeployedIndex. */
  public UnaryCallSettings<MutateDeployedIndexRequest, Operation> mutateDeployedIndexSettings() {
    return mutateDeployedIndexSettings;
  }

  /** Returns the object with the settings used for calls to mutateDeployedIndex. */
  public OperationCallSettings<
          MutateDeployedIndexRequest,
          MutateDeployedIndexResponse,
          MutateDeployedIndexOperationMetadata>
      mutateDeployedIndexOperationSettings() {
    return mutateDeployedIndexOperationSettings;
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

  public IndexEndpointServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcIndexEndpointServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(IndexEndpointServiceStubSettings.class))
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

  protected IndexEndpointServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createIndexEndpointSettings = settingsBuilder.createIndexEndpointSettings().build();
    createIndexEndpointOperationSettings =
        settingsBuilder.createIndexEndpointOperationSettings().build();
    getIndexEndpointSettings = settingsBuilder.getIndexEndpointSettings().build();
    listIndexEndpointsSettings = settingsBuilder.listIndexEndpointsSettings().build();
    updateIndexEndpointSettings = settingsBuilder.updateIndexEndpointSettings().build();
    deleteIndexEndpointSettings = settingsBuilder.deleteIndexEndpointSettings().build();
    deleteIndexEndpointOperationSettings =
        settingsBuilder.deleteIndexEndpointOperationSettings().build();
    deployIndexSettings = settingsBuilder.deployIndexSettings().build();
    deployIndexOperationSettings = settingsBuilder.deployIndexOperationSettings().build();
    undeployIndexSettings = settingsBuilder.undeployIndexSettings().build();
    undeployIndexOperationSettings = settingsBuilder.undeployIndexOperationSettings().build();
    mutateDeployedIndexSettings = settingsBuilder.mutateDeployedIndexSettings().build();
    mutateDeployedIndexOperationSettings =
        settingsBuilder.mutateDeployedIndexOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for IndexEndpointServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<IndexEndpointServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateIndexEndpointRequest, Operation>
        createIndexEndpointSettings;
    private final OperationCallSettings.Builder<
            CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointOperationMetadata>
        createIndexEndpointOperationSettings;
    private final UnaryCallSettings.Builder<GetIndexEndpointRequest, IndexEndpoint>
        getIndexEndpointSettings;
    private final PagedCallSettings.Builder<
            ListIndexEndpointsRequest, ListIndexEndpointsResponse, ListIndexEndpointsPagedResponse>
        listIndexEndpointsSettings;
    private final UnaryCallSettings.Builder<UpdateIndexEndpointRequest, IndexEndpoint>
        updateIndexEndpointSettings;
    private final UnaryCallSettings.Builder<DeleteIndexEndpointRequest, Operation>
        deleteIndexEndpointSettings;
    private final OperationCallSettings.Builder<
            DeleteIndexEndpointRequest, Empty, DeleteOperationMetadata>
        deleteIndexEndpointOperationSettings;
    private final UnaryCallSettings.Builder<DeployIndexRequest, Operation> deployIndexSettings;
    private final OperationCallSettings.Builder<
            DeployIndexRequest, DeployIndexResponse, DeployIndexOperationMetadata>
        deployIndexOperationSettings;
    private final UnaryCallSettings.Builder<UndeployIndexRequest, Operation> undeployIndexSettings;
    private final OperationCallSettings.Builder<
            UndeployIndexRequest, UndeployIndexResponse, UndeployIndexOperationMetadata>
        undeployIndexOperationSettings;
    private final UnaryCallSettings.Builder<MutateDeployedIndexRequest, Operation>
        mutateDeployedIndexSettings;
    private final OperationCallSettings.Builder<
            MutateDeployedIndexRequest,
            MutateDeployedIndexResponse,
            MutateDeployedIndexOperationMetadata>
        mutateDeployedIndexOperationSettings;
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
      definitions.put(
          "no_retry_3_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(5000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(5000L))
              .setTotalTimeout(Duration.ofMillis(5000L))
              .build();
      definitions.put("no_retry_3_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createIndexEndpointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createIndexEndpointOperationSettings = OperationCallSettings.newBuilder();
      getIndexEndpointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listIndexEndpointsSettings = PagedCallSettings.newBuilder(LIST_INDEX_ENDPOINTS_PAGE_STR_FACT);
      updateIndexEndpointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteIndexEndpointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteIndexEndpointOperationSettings = OperationCallSettings.newBuilder();
      deployIndexSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deployIndexOperationSettings = OperationCallSettings.newBuilder();
      undeployIndexSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeployIndexOperationSettings = OperationCallSettings.newBuilder();
      mutateDeployedIndexSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      mutateDeployedIndexOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createIndexEndpointSettings,
              getIndexEndpointSettings,
              listIndexEndpointsSettings,
              updateIndexEndpointSettings,
              deleteIndexEndpointSettings,
              deployIndexSettings,
              undeployIndexSettings,
              mutateDeployedIndexSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(IndexEndpointServiceStubSettings settings) {
      super(settings);

      createIndexEndpointSettings = settings.createIndexEndpointSettings.toBuilder();
      createIndexEndpointOperationSettings =
          settings.createIndexEndpointOperationSettings.toBuilder();
      getIndexEndpointSettings = settings.getIndexEndpointSettings.toBuilder();
      listIndexEndpointsSettings = settings.listIndexEndpointsSettings.toBuilder();
      updateIndexEndpointSettings = settings.updateIndexEndpointSettings.toBuilder();
      deleteIndexEndpointSettings = settings.deleteIndexEndpointSettings.toBuilder();
      deleteIndexEndpointOperationSettings =
          settings.deleteIndexEndpointOperationSettings.toBuilder();
      deployIndexSettings = settings.deployIndexSettings.toBuilder();
      deployIndexOperationSettings = settings.deployIndexOperationSettings.toBuilder();
      undeployIndexSettings = settings.undeployIndexSettings.toBuilder();
      undeployIndexOperationSettings = settings.undeployIndexOperationSettings.toBuilder();
      mutateDeployedIndexSettings = settings.mutateDeployedIndexSettings.toBuilder();
      mutateDeployedIndexOperationSettings =
          settings.mutateDeployedIndexOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createIndexEndpointSettings,
              getIndexEndpointSettings,
              listIndexEndpointsSettings,
              updateIndexEndpointSettings,
              deleteIndexEndpointSettings,
              deployIndexSettings,
              undeployIndexSettings,
              mutateDeployedIndexSettings,
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
          .createIndexEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .getIndexEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .listIndexEndpointsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .updateIndexEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .deleteIndexEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .deployIndexSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .undeployIndexSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .mutateDeployedIndexSettings()
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
          .createIndexEndpointOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateIndexEndpointRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(IndexEndpoint.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateIndexEndpointOperationMetadata.class))
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
          .deleteIndexEndpointOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteIndexEndpointRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"))
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

      builder
          .deployIndexOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeployIndexRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DeployIndexResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  DeployIndexOperationMetadata.class))
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
          .undeployIndexOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UndeployIndexRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(UndeployIndexResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UndeployIndexOperationMetadata.class))
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
          .mutateDeployedIndexOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<MutateDeployedIndexRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  MutateDeployedIndexResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  MutateDeployedIndexOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to createIndexEndpoint. */
    public UnaryCallSettings.Builder<CreateIndexEndpointRequest, Operation>
        createIndexEndpointSettings() {
      return createIndexEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to createIndexEndpoint. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointOperationMetadata>
        createIndexEndpointOperationSettings() {
      return createIndexEndpointOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getIndexEndpoint. */
    public UnaryCallSettings.Builder<GetIndexEndpointRequest, IndexEndpoint>
        getIndexEndpointSettings() {
      return getIndexEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to listIndexEndpoints. */
    public PagedCallSettings.Builder<
            ListIndexEndpointsRequest, ListIndexEndpointsResponse, ListIndexEndpointsPagedResponse>
        listIndexEndpointsSettings() {
      return listIndexEndpointsSettings;
    }

    /** Returns the builder for the settings used for calls to updateIndexEndpoint. */
    public UnaryCallSettings.Builder<UpdateIndexEndpointRequest, IndexEndpoint>
        updateIndexEndpointSettings() {
      return updateIndexEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIndexEndpoint. */
    public UnaryCallSettings.Builder<DeleteIndexEndpointRequest, Operation>
        deleteIndexEndpointSettings() {
      return deleteIndexEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIndexEndpoint. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteIndexEndpointRequest, Empty, DeleteOperationMetadata>
        deleteIndexEndpointOperationSettings() {
      return deleteIndexEndpointOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deployIndex. */
    public UnaryCallSettings.Builder<DeployIndexRequest, Operation> deployIndexSettings() {
      return deployIndexSettings;
    }

    /** Returns the builder for the settings used for calls to deployIndex. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeployIndexRequest, DeployIndexResponse, DeployIndexOperationMetadata>
        deployIndexOperationSettings() {
      return deployIndexOperationSettings;
    }

    /** Returns the builder for the settings used for calls to undeployIndex. */
    public UnaryCallSettings.Builder<UndeployIndexRequest, Operation> undeployIndexSettings() {
      return undeployIndexSettings;
    }

    /** Returns the builder for the settings used for calls to undeployIndex. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UndeployIndexRequest, UndeployIndexResponse, UndeployIndexOperationMetadata>
        undeployIndexOperationSettings() {
      return undeployIndexOperationSettings;
    }

    /** Returns the builder for the settings used for calls to mutateDeployedIndex. */
    public UnaryCallSettings.Builder<MutateDeployedIndexRequest, Operation>
        mutateDeployedIndexSettings() {
      return mutateDeployedIndexSettings;
    }

    /** Returns the builder for the settings used for calls to mutateDeployedIndex. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            MutateDeployedIndexRequest,
            MutateDeployedIndexResponse,
            MutateDeployedIndexOperationMetadata>
        mutateDeployedIndexOperationSettings() {
      return mutateDeployedIndexOperationSettings;
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
    public IndexEndpointServiceStubSettings build() throws IOException {
      return new IndexEndpointServiceStubSettings(this);
    }
  }
}
