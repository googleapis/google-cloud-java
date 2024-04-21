/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.networkconnectivity.v1.stub;

import static com.google.cloud.networkconnectivity.v1.PolicyBasedRoutingServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.PolicyBasedRoutingServiceClient.ListPolicyBasedRoutesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkconnectivity.v1.CreatePolicyBasedRouteRequest;
import com.google.cloud.networkconnectivity.v1.DeletePolicyBasedRouteRequest;
import com.google.cloud.networkconnectivity.v1.GetPolicyBasedRouteRequest;
import com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesRequest;
import com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesResponse;
import com.google.cloud.networkconnectivity.v1.OperationMetadata;
import com.google.cloud.networkconnectivity.v1.PolicyBasedRoute;
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
 * Settings class to configure an instance of {@link PolicyBasedRoutingServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networkconnectivity.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getPolicyBasedRoute to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PolicyBasedRoutingServiceStubSettings.Builder policyBasedRoutingServiceSettingsBuilder =
 *     PolicyBasedRoutingServiceStubSettings.newBuilder();
 * policyBasedRoutingServiceSettingsBuilder
 *     .getPolicyBasedRouteSettings()
 *     .setRetrySettings(
 *         policyBasedRoutingServiceSettingsBuilder
 *             .getPolicyBasedRouteSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PolicyBasedRoutingServiceStubSettings policyBasedRoutingServiceSettings =
 *     policyBasedRoutingServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class PolicyBasedRoutingServiceStubSettings
    extends StubSettings<PolicyBasedRoutingServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListPolicyBasedRoutesRequest,
          ListPolicyBasedRoutesResponse,
          ListPolicyBasedRoutesPagedResponse>
      listPolicyBasedRoutesSettings;
  private final UnaryCallSettings<GetPolicyBasedRouteRequest, PolicyBasedRoute>
      getPolicyBasedRouteSettings;
  private final UnaryCallSettings<CreatePolicyBasedRouteRequest, Operation>
      createPolicyBasedRouteSettings;
  private final OperationCallSettings<
          CreatePolicyBasedRouteRequest, PolicyBasedRoute, OperationMetadata>
      createPolicyBasedRouteOperationSettings;
  private final UnaryCallSettings<DeletePolicyBasedRouteRequest, Operation>
      deletePolicyBasedRouteSettings;
  private final OperationCallSettings<DeletePolicyBasedRouteRequest, Empty, OperationMetadata>
      deletePolicyBasedRouteOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListPolicyBasedRoutesRequest, ListPolicyBasedRoutesResponse, PolicyBasedRoute>
      LIST_POLICY_BASED_ROUTES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPolicyBasedRoutesRequest, ListPolicyBasedRoutesResponse, PolicyBasedRoute>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPolicyBasedRoutesRequest injectToken(
                ListPolicyBasedRoutesRequest payload, String token) {
              return ListPolicyBasedRoutesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPolicyBasedRoutesRequest injectPageSize(
                ListPolicyBasedRoutesRequest payload, int pageSize) {
              return ListPolicyBasedRoutesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPolicyBasedRoutesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPolicyBasedRoutesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PolicyBasedRoute> extractResources(
                ListPolicyBasedRoutesResponse payload) {
              return payload.getPolicyBasedRoutesList() == null
                  ? ImmutableList.<PolicyBasedRoute>of()
                  : payload.getPolicyBasedRoutesList();
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
          ListPolicyBasedRoutesRequest,
          ListPolicyBasedRoutesResponse,
          ListPolicyBasedRoutesPagedResponse>
      LIST_POLICY_BASED_ROUTES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPolicyBasedRoutesRequest,
              ListPolicyBasedRoutesResponse,
              ListPolicyBasedRoutesPagedResponse>() {
            @Override
            public ApiFuture<ListPolicyBasedRoutesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPolicyBasedRoutesRequest, ListPolicyBasedRoutesResponse> callable,
                ListPolicyBasedRoutesRequest request,
                ApiCallContext context,
                ApiFuture<ListPolicyBasedRoutesResponse> futureResponse) {
              PageContext<
                      ListPolicyBasedRoutesRequest, ListPolicyBasedRoutesResponse, PolicyBasedRoute>
                  pageContext =
                      PageContext.create(
                          callable, LIST_POLICY_BASED_ROUTES_PAGE_STR_DESC, request, context);
              return ListPolicyBasedRoutesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listPolicyBasedRoutes. */
  public PagedCallSettings<
          ListPolicyBasedRoutesRequest,
          ListPolicyBasedRoutesResponse,
          ListPolicyBasedRoutesPagedResponse>
      listPolicyBasedRoutesSettings() {
    return listPolicyBasedRoutesSettings;
  }

  /** Returns the object with the settings used for calls to getPolicyBasedRoute. */
  public UnaryCallSettings<GetPolicyBasedRouteRequest, PolicyBasedRoute>
      getPolicyBasedRouteSettings() {
    return getPolicyBasedRouteSettings;
  }

  /** Returns the object with the settings used for calls to createPolicyBasedRoute. */
  public UnaryCallSettings<CreatePolicyBasedRouteRequest, Operation>
      createPolicyBasedRouteSettings() {
    return createPolicyBasedRouteSettings;
  }

  /** Returns the object with the settings used for calls to createPolicyBasedRoute. */
  public OperationCallSettings<CreatePolicyBasedRouteRequest, PolicyBasedRoute, OperationMetadata>
      createPolicyBasedRouteOperationSettings() {
    return createPolicyBasedRouteOperationSettings;
  }

  /** Returns the object with the settings used for calls to deletePolicyBasedRoute. */
  public UnaryCallSettings<DeletePolicyBasedRouteRequest, Operation>
      deletePolicyBasedRouteSettings() {
    return deletePolicyBasedRouteSettings;
  }

  /** Returns the object with the settings used for calls to deletePolicyBasedRoute. */
  public OperationCallSettings<DeletePolicyBasedRouteRequest, Empty, OperationMetadata>
      deletePolicyBasedRouteOperationSettings() {
    return deletePolicyBasedRouteOperationSettings;
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

  public PolicyBasedRoutingServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcPolicyBasedRoutingServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "networkconnectivity";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "networkconnectivity.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "networkconnectivity.mtls.googleapis.com:443";
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

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(PolicyBasedRoutingServiceStubSettings.class))
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

  protected PolicyBasedRoutingServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listPolicyBasedRoutesSettings = settingsBuilder.listPolicyBasedRoutesSettings().build();
    getPolicyBasedRouteSettings = settingsBuilder.getPolicyBasedRouteSettings().build();
    createPolicyBasedRouteSettings = settingsBuilder.createPolicyBasedRouteSettings().build();
    createPolicyBasedRouteOperationSettings =
        settingsBuilder.createPolicyBasedRouteOperationSettings().build();
    deletePolicyBasedRouteSettings = settingsBuilder.deletePolicyBasedRouteSettings().build();
    deletePolicyBasedRouteOperationSettings =
        settingsBuilder.deletePolicyBasedRouteOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for PolicyBasedRoutingServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<PolicyBasedRoutingServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListPolicyBasedRoutesRequest,
            ListPolicyBasedRoutesResponse,
            ListPolicyBasedRoutesPagedResponse>
        listPolicyBasedRoutesSettings;
    private final UnaryCallSettings.Builder<GetPolicyBasedRouteRequest, PolicyBasedRoute>
        getPolicyBasedRouteSettings;
    private final UnaryCallSettings.Builder<CreatePolicyBasedRouteRequest, Operation>
        createPolicyBasedRouteSettings;
    private final OperationCallSettings.Builder<
            CreatePolicyBasedRouteRequest, PolicyBasedRoute, OperationMetadata>
        createPolicyBasedRouteOperationSettings;
    private final UnaryCallSettings.Builder<DeletePolicyBasedRouteRequest, Operation>
        deletePolicyBasedRouteSettings;
    private final OperationCallSettings.Builder<
            DeletePolicyBasedRouteRequest, Empty, OperationMetadata>
        deletePolicyBasedRouteOperationSettings;
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
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listPolicyBasedRoutesSettings =
          PagedCallSettings.newBuilder(LIST_POLICY_BASED_ROUTES_PAGE_STR_FACT);
      getPolicyBasedRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPolicyBasedRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPolicyBasedRouteOperationSettings = OperationCallSettings.newBuilder();
      deletePolicyBasedRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePolicyBasedRouteOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listPolicyBasedRoutesSettings,
              getPolicyBasedRouteSettings,
              createPolicyBasedRouteSettings,
              deletePolicyBasedRouteSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(PolicyBasedRoutingServiceStubSettings settings) {
      super(settings);

      listPolicyBasedRoutesSettings = settings.listPolicyBasedRoutesSettings.toBuilder();
      getPolicyBasedRouteSettings = settings.getPolicyBasedRouteSettings.toBuilder();
      createPolicyBasedRouteSettings = settings.createPolicyBasedRouteSettings.toBuilder();
      createPolicyBasedRouteOperationSettings =
          settings.createPolicyBasedRouteOperationSettings.toBuilder();
      deletePolicyBasedRouteSettings = settings.deletePolicyBasedRouteSettings.toBuilder();
      deletePolicyBasedRouteOperationSettings =
          settings.deletePolicyBasedRouteOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listPolicyBasedRoutesSettings,
              getPolicyBasedRouteSettings,
              createPolicyBasedRouteSettings,
              deletePolicyBasedRouteSettings,
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
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listPolicyBasedRoutesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPolicyBasedRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPolicyBasedRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deletePolicyBasedRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPolicyBasedRouteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreatePolicyBasedRouteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PolicyBasedRoute.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deletePolicyBasedRouteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePolicyBasedRouteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to listPolicyBasedRoutes. */
    public PagedCallSettings.Builder<
            ListPolicyBasedRoutesRequest,
            ListPolicyBasedRoutesResponse,
            ListPolicyBasedRoutesPagedResponse>
        listPolicyBasedRoutesSettings() {
      return listPolicyBasedRoutesSettings;
    }

    /** Returns the builder for the settings used for calls to getPolicyBasedRoute. */
    public UnaryCallSettings.Builder<GetPolicyBasedRouteRequest, PolicyBasedRoute>
        getPolicyBasedRouteSettings() {
      return getPolicyBasedRouteSettings;
    }

    /** Returns the builder for the settings used for calls to createPolicyBasedRoute. */
    public UnaryCallSettings.Builder<CreatePolicyBasedRouteRequest, Operation>
        createPolicyBasedRouteSettings() {
      return createPolicyBasedRouteSettings;
    }

    /** Returns the builder for the settings used for calls to createPolicyBasedRoute. */
    public OperationCallSettings.Builder<
            CreatePolicyBasedRouteRequest, PolicyBasedRoute, OperationMetadata>
        createPolicyBasedRouteOperationSettings() {
      return createPolicyBasedRouteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deletePolicyBasedRoute. */
    public UnaryCallSettings.Builder<DeletePolicyBasedRouteRequest, Operation>
        deletePolicyBasedRouteSettings() {
      return deletePolicyBasedRouteSettings;
    }

    /** Returns the builder for the settings used for calls to deletePolicyBasedRoute. */
    public OperationCallSettings.Builder<DeletePolicyBasedRouteRequest, Empty, OperationMetadata>
        deletePolicyBasedRouteOperationSettings() {
      return deletePolicyBasedRouteOperationSettings;
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
    public PolicyBasedRoutingServiceStubSettings build() throws IOException {
      return new PolicyBasedRoutingServiceStubSettings(this);
    }
  }
}
