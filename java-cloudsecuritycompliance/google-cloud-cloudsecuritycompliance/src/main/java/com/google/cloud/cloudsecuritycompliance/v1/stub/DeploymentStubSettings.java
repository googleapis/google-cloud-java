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

package com.google.cloud.cloudsecuritycompliance.v1.stub;

import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListCloudControlDeploymentsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListFrameworkDeploymentsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListLocationsPagedResponse;

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
import com.google.cloud.cloudsecuritycompliance.v1.CloudControlDeployment;
import com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkDeploymentRequest;
import com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkDeploymentRequest;
import com.google.cloud.cloudsecuritycompliance.v1.FrameworkDeployment;
import com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlDeploymentRequest;
import com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkDeploymentRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsResponse;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsResponse;
import com.google.cloud.cloudsecuritycompliance.v1.OperationMetadata;
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
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DeploymentStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudsecuritycompliance.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getFrameworkDeployment:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DeploymentStubSettings.Builder deploymentSettingsBuilder = DeploymentStubSettings.newBuilder();
 * deploymentSettingsBuilder
 *     .getFrameworkDeploymentSettings()
 *     .setRetrySettings(
 *         deploymentSettingsBuilder
 *             .getFrameworkDeploymentSettings()
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
 * DeploymentStubSettings deploymentSettings = deploymentSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createFrameworkDeployment:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DeploymentStubSettings.Builder deploymentSettingsBuilder = DeploymentStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * deploymentSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DeploymentStubSettings extends StubSettings<DeploymentStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateFrameworkDeploymentRequest, Operation>
      createFrameworkDeploymentSettings;
  private final OperationCallSettings<
          CreateFrameworkDeploymentRequest, FrameworkDeployment, OperationMetadata>
      createFrameworkDeploymentOperationSettings;
  private final UnaryCallSettings<DeleteFrameworkDeploymentRequest, Operation>
      deleteFrameworkDeploymentSettings;
  private final OperationCallSettings<DeleteFrameworkDeploymentRequest, Empty, OperationMetadata>
      deleteFrameworkDeploymentOperationSettings;
  private final UnaryCallSettings<GetFrameworkDeploymentRequest, FrameworkDeployment>
      getFrameworkDeploymentSettings;
  private final PagedCallSettings<
          ListFrameworkDeploymentsRequest,
          ListFrameworkDeploymentsResponse,
          ListFrameworkDeploymentsPagedResponse>
      listFrameworkDeploymentsSettings;
  private final UnaryCallSettings<GetCloudControlDeploymentRequest, CloudControlDeployment>
      getCloudControlDeploymentSettings;
  private final PagedCallSettings<
          ListCloudControlDeploymentsRequest,
          ListCloudControlDeploymentsResponse,
          ListCloudControlDeploymentsPagedResponse>
      listCloudControlDeploymentsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsResponse, FrameworkDeployment>
      LIST_FRAMEWORK_DEPLOYMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFrameworkDeploymentsRequest,
              ListFrameworkDeploymentsResponse,
              FrameworkDeployment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFrameworkDeploymentsRequest injectToken(
                ListFrameworkDeploymentsRequest payload, String token) {
              return ListFrameworkDeploymentsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListFrameworkDeploymentsRequest injectPageSize(
                ListFrameworkDeploymentsRequest payload, int pageSize) {
              return ListFrameworkDeploymentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListFrameworkDeploymentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFrameworkDeploymentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FrameworkDeployment> extractResources(
                ListFrameworkDeploymentsResponse payload) {
              return payload.getFrameworkDeploymentsList();
            }
          };

  private static final PagedListDescriptor<
          ListCloudControlDeploymentsRequest,
          ListCloudControlDeploymentsResponse,
          CloudControlDeployment>
      LIST_CLOUD_CONTROL_DEPLOYMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCloudControlDeploymentsRequest,
              ListCloudControlDeploymentsResponse,
              CloudControlDeployment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCloudControlDeploymentsRequest injectToken(
                ListCloudControlDeploymentsRequest payload, String token) {
              return ListCloudControlDeploymentsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListCloudControlDeploymentsRequest injectPageSize(
                ListCloudControlDeploymentsRequest payload, int pageSize) {
              return ListCloudControlDeploymentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListCloudControlDeploymentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCloudControlDeploymentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CloudControlDeployment> extractResources(
                ListCloudControlDeploymentsResponse payload) {
              return payload.getCloudControlDeploymentsList();
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
          ListFrameworkDeploymentsRequest,
          ListFrameworkDeploymentsResponse,
          ListFrameworkDeploymentsPagedResponse>
      LIST_FRAMEWORK_DEPLOYMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFrameworkDeploymentsRequest,
              ListFrameworkDeploymentsResponse,
              ListFrameworkDeploymentsPagedResponse>() {
            @Override
            public ApiFuture<ListFrameworkDeploymentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsResponse>
                    callable,
                ListFrameworkDeploymentsRequest request,
                ApiCallContext context,
                ApiFuture<ListFrameworkDeploymentsResponse> futureResponse) {
              PageContext<
                      ListFrameworkDeploymentsRequest,
                      ListFrameworkDeploymentsResponse,
                      FrameworkDeployment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_FRAMEWORK_DEPLOYMENTS_PAGE_STR_DESC, request, context);
              return ListFrameworkDeploymentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCloudControlDeploymentsRequest,
          ListCloudControlDeploymentsResponse,
          ListCloudControlDeploymentsPagedResponse>
      LIST_CLOUD_CONTROL_DEPLOYMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCloudControlDeploymentsRequest,
              ListCloudControlDeploymentsResponse,
              ListCloudControlDeploymentsPagedResponse>() {
            @Override
            public ApiFuture<ListCloudControlDeploymentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsResponse>
                    callable,
                ListCloudControlDeploymentsRequest request,
                ApiCallContext context,
                ApiFuture<ListCloudControlDeploymentsResponse> futureResponse) {
              PageContext<
                      ListCloudControlDeploymentsRequest,
                      ListCloudControlDeploymentsResponse,
                      CloudControlDeployment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CLOUD_CONTROL_DEPLOYMENTS_PAGE_STR_DESC, request, context);
              return ListCloudControlDeploymentsPagedResponse.createAsync(
                  pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createFrameworkDeployment. */
  public UnaryCallSettings<CreateFrameworkDeploymentRequest, Operation>
      createFrameworkDeploymentSettings() {
    return createFrameworkDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to createFrameworkDeployment. */
  public OperationCallSettings<
          CreateFrameworkDeploymentRequest, FrameworkDeployment, OperationMetadata>
      createFrameworkDeploymentOperationSettings() {
    return createFrameworkDeploymentOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteFrameworkDeployment. */
  public UnaryCallSettings<DeleteFrameworkDeploymentRequest, Operation>
      deleteFrameworkDeploymentSettings() {
    return deleteFrameworkDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to deleteFrameworkDeployment. */
  public OperationCallSettings<DeleteFrameworkDeploymentRequest, Empty, OperationMetadata>
      deleteFrameworkDeploymentOperationSettings() {
    return deleteFrameworkDeploymentOperationSettings;
  }

  /** Returns the object with the settings used for calls to getFrameworkDeployment. */
  public UnaryCallSettings<GetFrameworkDeploymentRequest, FrameworkDeployment>
      getFrameworkDeploymentSettings() {
    return getFrameworkDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to listFrameworkDeployments. */
  public PagedCallSettings<
          ListFrameworkDeploymentsRequest,
          ListFrameworkDeploymentsResponse,
          ListFrameworkDeploymentsPagedResponse>
      listFrameworkDeploymentsSettings() {
    return listFrameworkDeploymentsSettings;
  }

  /** Returns the object with the settings used for calls to getCloudControlDeployment. */
  public UnaryCallSettings<GetCloudControlDeploymentRequest, CloudControlDeployment>
      getCloudControlDeploymentSettings() {
    return getCloudControlDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to listCloudControlDeployments. */
  public PagedCallSettings<
          ListCloudControlDeploymentsRequest,
          ListCloudControlDeploymentsResponse,
          ListCloudControlDeploymentsPagedResponse>
      listCloudControlDeploymentsSettings() {
    return listCloudControlDeploymentsSettings;
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

  public DeploymentStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDeploymentStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDeploymentStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "cloudsecuritycompliance";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "cloudsecuritycompliance.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "cloudsecuritycompliance.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DeploymentStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DeploymentStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DeploymentStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DeploymentStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createFrameworkDeploymentSettings = settingsBuilder.createFrameworkDeploymentSettings().build();
    createFrameworkDeploymentOperationSettings =
        settingsBuilder.createFrameworkDeploymentOperationSettings().build();
    deleteFrameworkDeploymentSettings = settingsBuilder.deleteFrameworkDeploymentSettings().build();
    deleteFrameworkDeploymentOperationSettings =
        settingsBuilder.deleteFrameworkDeploymentOperationSettings().build();
    getFrameworkDeploymentSettings = settingsBuilder.getFrameworkDeploymentSettings().build();
    listFrameworkDeploymentsSettings = settingsBuilder.listFrameworkDeploymentsSettings().build();
    getCloudControlDeploymentSettings = settingsBuilder.getCloudControlDeploymentSettings().build();
    listCloudControlDeploymentsSettings =
        settingsBuilder.listCloudControlDeploymentsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for DeploymentStubSettings. */
  public static class Builder extends StubSettings.Builder<DeploymentStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateFrameworkDeploymentRequest, Operation>
        createFrameworkDeploymentSettings;
    private final OperationCallSettings.Builder<
            CreateFrameworkDeploymentRequest, FrameworkDeployment, OperationMetadata>
        createFrameworkDeploymentOperationSettings;
    private final UnaryCallSettings.Builder<DeleteFrameworkDeploymentRequest, Operation>
        deleteFrameworkDeploymentSettings;
    private final OperationCallSettings.Builder<
            DeleteFrameworkDeploymentRequest, Empty, OperationMetadata>
        deleteFrameworkDeploymentOperationSettings;
    private final UnaryCallSettings.Builder<GetFrameworkDeploymentRequest, FrameworkDeployment>
        getFrameworkDeploymentSettings;
    private final PagedCallSettings.Builder<
            ListFrameworkDeploymentsRequest,
            ListFrameworkDeploymentsResponse,
            ListFrameworkDeploymentsPagedResponse>
        listFrameworkDeploymentsSettings;
    private final UnaryCallSettings.Builder<
            GetCloudControlDeploymentRequest, CloudControlDeployment>
        getCloudControlDeploymentSettings;
    private final PagedCallSettings.Builder<
            ListCloudControlDeploymentsRequest,
            ListCloudControlDeploymentsResponse,
            ListCloudControlDeploymentsPagedResponse>
        listCloudControlDeploymentsSettings;
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
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
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
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
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
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createFrameworkDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFrameworkDeploymentOperationSettings = OperationCallSettings.newBuilder();
      deleteFrameworkDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFrameworkDeploymentOperationSettings = OperationCallSettings.newBuilder();
      getFrameworkDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFrameworkDeploymentsSettings =
          PagedCallSettings.newBuilder(LIST_FRAMEWORK_DEPLOYMENTS_PAGE_STR_FACT);
      getCloudControlDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCloudControlDeploymentsSettings =
          PagedCallSettings.newBuilder(LIST_CLOUD_CONTROL_DEPLOYMENTS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createFrameworkDeploymentSettings,
              deleteFrameworkDeploymentSettings,
              getFrameworkDeploymentSettings,
              listFrameworkDeploymentsSettings,
              getCloudControlDeploymentSettings,
              listCloudControlDeploymentsSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(DeploymentStubSettings settings) {
      super(settings);

      createFrameworkDeploymentSettings = settings.createFrameworkDeploymentSettings.toBuilder();
      createFrameworkDeploymentOperationSettings =
          settings.createFrameworkDeploymentOperationSettings.toBuilder();
      deleteFrameworkDeploymentSettings = settings.deleteFrameworkDeploymentSettings.toBuilder();
      deleteFrameworkDeploymentOperationSettings =
          settings.deleteFrameworkDeploymentOperationSettings.toBuilder();
      getFrameworkDeploymentSettings = settings.getFrameworkDeploymentSettings.toBuilder();
      listFrameworkDeploymentsSettings = settings.listFrameworkDeploymentsSettings.toBuilder();
      getCloudControlDeploymentSettings = settings.getCloudControlDeploymentSettings.toBuilder();
      listCloudControlDeploymentsSettings =
          settings.listCloudControlDeploymentsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createFrameworkDeploymentSettings,
              deleteFrameworkDeploymentSettings,
              getFrameworkDeploymentSettings,
              listFrameworkDeploymentsSettings,
              getCloudControlDeploymentSettings,
              listCloudControlDeploymentsSettings,
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
          .createFrameworkDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteFrameworkDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getFrameworkDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listFrameworkDeploymentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCloudControlDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCloudControlDeploymentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createFrameworkDeploymentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateFrameworkDeploymentRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(FrameworkDeployment.class))
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
          .deleteFrameworkDeploymentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteFrameworkDeploymentRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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

    /** Returns the builder for the settings used for calls to createFrameworkDeployment. */
    public UnaryCallSettings.Builder<CreateFrameworkDeploymentRequest, Operation>
        createFrameworkDeploymentSettings() {
      return createFrameworkDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to createFrameworkDeployment. */
    public OperationCallSettings.Builder<
            CreateFrameworkDeploymentRequest, FrameworkDeployment, OperationMetadata>
        createFrameworkDeploymentOperationSettings() {
      return createFrameworkDeploymentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFrameworkDeployment. */
    public UnaryCallSettings.Builder<DeleteFrameworkDeploymentRequest, Operation>
        deleteFrameworkDeploymentSettings() {
      return deleteFrameworkDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFrameworkDeployment. */
    public OperationCallSettings.Builder<DeleteFrameworkDeploymentRequest, Empty, OperationMetadata>
        deleteFrameworkDeploymentOperationSettings() {
      return deleteFrameworkDeploymentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getFrameworkDeployment. */
    public UnaryCallSettings.Builder<GetFrameworkDeploymentRequest, FrameworkDeployment>
        getFrameworkDeploymentSettings() {
      return getFrameworkDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to listFrameworkDeployments. */
    public PagedCallSettings.Builder<
            ListFrameworkDeploymentsRequest,
            ListFrameworkDeploymentsResponse,
            ListFrameworkDeploymentsPagedResponse>
        listFrameworkDeploymentsSettings() {
      return listFrameworkDeploymentsSettings;
    }

    /** Returns the builder for the settings used for calls to getCloudControlDeployment. */
    public UnaryCallSettings.Builder<GetCloudControlDeploymentRequest, CloudControlDeployment>
        getCloudControlDeploymentSettings() {
      return getCloudControlDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to listCloudControlDeployments. */
    public PagedCallSettings.Builder<
            ListCloudControlDeploymentsRequest,
            ListCloudControlDeploymentsResponse,
            ListCloudControlDeploymentsPagedResponse>
        listCloudControlDeploymentsSettings() {
      return listCloudControlDeploymentsSettings;
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
    public DeploymentStubSettings build() throws IOException {
      return new DeploymentStubSettings(this);
    }
  }
}
