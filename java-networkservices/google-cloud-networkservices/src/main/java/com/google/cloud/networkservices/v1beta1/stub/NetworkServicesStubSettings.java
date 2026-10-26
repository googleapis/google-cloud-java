/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.networkservices.v1beta1.stub;

import static com.google.cloud.networkservices.v1beta1.NetworkServicesClient.ListEndpointPoliciesPagedResponse;
import static com.google.cloud.networkservices.v1beta1.NetworkServicesClient.ListLocationsPagedResponse;

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
import com.google.api.gax.rpc.LibraryMetadata;
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
import com.google.cloud.networkservices.v1beta1.CreateEndpointPolicyRequest;
import com.google.cloud.networkservices.v1beta1.DeleteEndpointPolicyRequest;
import com.google.cloud.networkservices.v1beta1.EndpointPolicy;
import com.google.cloud.networkservices.v1beta1.GetEndpointPolicyRequest;
import com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesRequest;
import com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesResponse;
import com.google.cloud.networkservices.v1beta1.OperationMetadata;
import com.google.cloud.networkservices.v1beta1.UpdateEndpointPolicyRequest;
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
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link NetworkServicesStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networkservices.googleapis.com) and default port (443) are
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
 * of getEndpointPolicy:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NetworkServicesStubSettings.Builder networkServicesSettingsBuilder =
 *     NetworkServicesStubSettings.newBuilder();
 * networkServicesSettingsBuilder
 *     .getEndpointPolicySettings()
 *     .setRetrySettings(
 *         networkServicesSettingsBuilder
 *             .getEndpointPolicySettings()
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
 * NetworkServicesStubSettings networkServicesSettings = networkServicesSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createEndpointPolicy:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NetworkServicesStubSettings.Builder networkServicesSettingsBuilder =
 *     NetworkServicesStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * networkServicesSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class NetworkServicesStubSettings extends StubSettings<NetworkServicesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListEndpointPoliciesRequest,
          ListEndpointPoliciesResponse,
          ListEndpointPoliciesPagedResponse>
      listEndpointPoliciesSettings;
  private final UnaryCallSettings<GetEndpointPolicyRequest, EndpointPolicy>
      getEndpointPolicySettings;
  private final UnaryCallSettings<CreateEndpointPolicyRequest, Operation>
      createEndpointPolicySettings;
  private final OperationCallSettings<
          CreateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      createEndpointPolicyOperationSettings;
  private final UnaryCallSettings<UpdateEndpointPolicyRequest, Operation>
      updateEndpointPolicySettings;
  private final OperationCallSettings<
          UpdateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      updateEndpointPolicyOperationSettings;
  private final UnaryCallSettings<DeleteEndpointPolicyRequest, Operation>
      deleteEndpointPolicySettings;
  private final OperationCallSettings<DeleteEndpointPolicyRequest, Empty, OperationMetadata>
      deleteEndpointPolicyOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListEndpointPoliciesRequest, ListEndpointPoliciesResponse, EndpointPolicy>
      LIST_ENDPOINT_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEndpointPoliciesRequest, ListEndpointPoliciesResponse, EndpointPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEndpointPoliciesRequest injectToken(
                ListEndpointPoliciesRequest payload, String token) {
              return ListEndpointPoliciesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEndpointPoliciesRequest injectPageSize(
                ListEndpointPoliciesRequest payload, int pageSize) {
              return ListEndpointPoliciesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEndpointPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEndpointPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EndpointPolicy> extractResources(ListEndpointPoliciesResponse payload) {
              return payload.getEndpointPoliciesList();
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
          ListEndpointPoliciesRequest,
          ListEndpointPoliciesResponse,
          ListEndpointPoliciesPagedResponse>
      LIST_ENDPOINT_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEndpointPoliciesRequest,
              ListEndpointPoliciesResponse,
              ListEndpointPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListEndpointPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse> callable,
                ListEndpointPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListEndpointPoliciesResponse> futureResponse) {
              PageContext<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse, EndpointPolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ENDPOINT_POLICIES_PAGE_STR_DESC, request, context);
              return ListEndpointPoliciesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listEndpointPolicies. */
  public PagedCallSettings<
          ListEndpointPoliciesRequest,
          ListEndpointPoliciesResponse,
          ListEndpointPoliciesPagedResponse>
      listEndpointPoliciesSettings() {
    return listEndpointPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to getEndpointPolicy. */
  public UnaryCallSettings<GetEndpointPolicyRequest, EndpointPolicy> getEndpointPolicySettings() {
    return getEndpointPolicySettings;
  }

  /** Returns the object with the settings used for calls to createEndpointPolicy. */
  public UnaryCallSettings<CreateEndpointPolicyRequest, Operation> createEndpointPolicySettings() {
    return createEndpointPolicySettings;
  }

  /** Returns the object with the settings used for calls to createEndpointPolicy. */
  public OperationCallSettings<CreateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      createEndpointPolicyOperationSettings() {
    return createEndpointPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateEndpointPolicy. */
  public UnaryCallSettings<UpdateEndpointPolicyRequest, Operation> updateEndpointPolicySettings() {
    return updateEndpointPolicySettings;
  }

  /** Returns the object with the settings used for calls to updateEndpointPolicy. */
  public OperationCallSettings<UpdateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      updateEndpointPolicyOperationSettings() {
    return updateEndpointPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteEndpointPolicy. */
  public UnaryCallSettings<DeleteEndpointPolicyRequest, Operation> deleteEndpointPolicySettings() {
    return deleteEndpointPolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteEndpointPolicy. */
  public OperationCallSettings<DeleteEndpointPolicyRequest, Empty, OperationMetadata>
      deleteEndpointPolicyOperationSettings() {
    return deleteEndpointPolicyOperationSettings;
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

  public NetworkServicesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcNetworkServicesStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonNetworkServicesStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "networkservices";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "networkservices.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "networkservices.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(NetworkServicesStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(NetworkServicesStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NetworkServicesStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected NetworkServicesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listEndpointPoliciesSettings = settingsBuilder.listEndpointPoliciesSettings().build();
    getEndpointPolicySettings = settingsBuilder.getEndpointPolicySettings().build();
    createEndpointPolicySettings = settingsBuilder.createEndpointPolicySettings().build();
    createEndpointPolicyOperationSettings =
        settingsBuilder.createEndpointPolicyOperationSettings().build();
    updateEndpointPolicySettings = settingsBuilder.updateEndpointPolicySettings().build();
    updateEndpointPolicyOperationSettings =
        settingsBuilder.updateEndpointPolicyOperationSettings().build();
    deleteEndpointPolicySettings = settingsBuilder.deleteEndpointPolicySettings().build();
    deleteEndpointPolicyOperationSettings =
        settingsBuilder.deleteEndpointPolicyOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-networkservices")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for NetworkServicesStubSettings. */
  public static class Builder extends StubSettings.Builder<NetworkServicesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListEndpointPoliciesRequest,
            ListEndpointPoliciesResponse,
            ListEndpointPoliciesPagedResponse>
        listEndpointPoliciesSettings;
    private final UnaryCallSettings.Builder<GetEndpointPolicyRequest, EndpointPolicy>
        getEndpointPolicySettings;
    private final UnaryCallSettings.Builder<CreateEndpointPolicyRequest, Operation>
        createEndpointPolicySettings;
    private final OperationCallSettings.Builder<
            CreateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
        createEndpointPolicyOperationSettings;
    private final UnaryCallSettings.Builder<UpdateEndpointPolicyRequest, Operation>
        updateEndpointPolicySettings;
    private final OperationCallSettings.Builder<
            UpdateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
        updateEndpointPolicyOperationSettings;
    private final UnaryCallSettings.Builder<DeleteEndpointPolicyRequest, Operation>
        deleteEndpointPolicySettings;
    private final OperationCallSettings.Builder<
            DeleteEndpointPolicyRequest, Empty, OperationMetadata>
        deleteEndpointPolicyOperationSettings;
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
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      definitions.put("no_retry_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      listEndpointPoliciesSettings =
          PagedCallSettings.newBuilder(LIST_ENDPOINT_POLICIES_PAGE_STR_FACT);
      getEndpointPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEndpointPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEndpointPolicyOperationSettings = OperationCallSettings.newBuilder();
      updateEndpointPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEndpointPolicyOperationSettings = OperationCallSettings.newBuilder();
      deleteEndpointPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEndpointPolicyOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listEndpointPoliciesSettings,
              getEndpointPolicySettings,
              createEndpointPolicySettings,
              updateEndpointPolicySettings,
              deleteEndpointPolicySettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(NetworkServicesStubSettings settings) {
      super(settings);

      listEndpointPoliciesSettings = settings.listEndpointPoliciesSettings.toBuilder();
      getEndpointPolicySettings = settings.getEndpointPolicySettings.toBuilder();
      createEndpointPolicySettings = settings.createEndpointPolicySettings.toBuilder();
      createEndpointPolicyOperationSettings =
          settings.createEndpointPolicyOperationSettings.toBuilder();
      updateEndpointPolicySettings = settings.updateEndpointPolicySettings.toBuilder();
      updateEndpointPolicyOperationSettings =
          settings.updateEndpointPolicyOperationSettings.toBuilder();
      deleteEndpointPolicySettings = settings.deleteEndpointPolicySettings.toBuilder();
      deleteEndpointPolicyOperationSettings =
          settings.deleteEndpointPolicyOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listEndpointPoliciesSettings,
              getEndpointPolicySettings,
              createEndpointPolicySettings,
              updateEndpointPolicySettings,
              deleteEndpointPolicySettings,
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
          .listEndpointPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getEndpointPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createEndpointPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateEndpointPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteEndpointPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createEndpointPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateEndpointPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(EndpointPolicy.class))
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
          .updateEndpointPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateEndpointPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(EndpointPolicy.class))
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
          .deleteEndpointPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteEndpointPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
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

    /** Returns the builder for the settings used for calls to listEndpointPolicies. */
    public PagedCallSettings.Builder<
            ListEndpointPoliciesRequest,
            ListEndpointPoliciesResponse,
            ListEndpointPoliciesPagedResponse>
        listEndpointPoliciesSettings() {
      return listEndpointPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to getEndpointPolicy. */
    public UnaryCallSettings.Builder<GetEndpointPolicyRequest, EndpointPolicy>
        getEndpointPolicySettings() {
      return getEndpointPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createEndpointPolicy. */
    public UnaryCallSettings.Builder<CreateEndpointPolicyRequest, Operation>
        createEndpointPolicySettings() {
      return createEndpointPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createEndpointPolicy. */
    public OperationCallSettings.Builder<
            CreateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
        createEndpointPolicyOperationSettings() {
      return createEndpointPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateEndpointPolicy. */
    public UnaryCallSettings.Builder<UpdateEndpointPolicyRequest, Operation>
        updateEndpointPolicySettings() {
      return updateEndpointPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateEndpointPolicy. */
    public OperationCallSettings.Builder<
            UpdateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
        updateEndpointPolicyOperationSettings() {
      return updateEndpointPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEndpointPolicy. */
    public UnaryCallSettings.Builder<DeleteEndpointPolicyRequest, Operation>
        deleteEndpointPolicySettings() {
      return deleteEndpointPolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteEndpointPolicy. */
    public OperationCallSettings.Builder<DeleteEndpointPolicyRequest, Empty, OperationMetadata>
        deleteEndpointPolicyOperationSettings() {
      return deleteEndpointPolicyOperationSettings;
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
    public NetworkServicesStubSettings build() throws IOException {
      return new NetworkServicesStubSettings(this);
    }
  }
}
