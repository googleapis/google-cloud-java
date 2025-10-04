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

package com.google.cloud.networkconnectivity.v1.stub;

import static com.google.cloud.networkconnectivity.v1.InternalRangeServiceClient.ListInternalRangesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.InternalRangeServiceClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
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
import com.google.cloud.networkconnectivity.v1.CreateInternalRangeRequest;
import com.google.cloud.networkconnectivity.v1.DeleteInternalRangeRequest;
import com.google.cloud.networkconnectivity.v1.GetInternalRangeRequest;
import com.google.cloud.networkconnectivity.v1.InternalRange;
import com.google.cloud.networkconnectivity.v1.ListInternalRangesRequest;
import com.google.cloud.networkconnectivity.v1.ListInternalRangesResponse;
import com.google.cloud.networkconnectivity.v1.OperationMetadata;
import com.google.cloud.networkconnectivity.v1.UpdateInternalRangeRequest;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link InternalRangeServiceStub}.
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getInternalRange:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InternalRangeServiceStubSettings.Builder internalRangeServiceSettingsBuilder =
 *     InternalRangeServiceStubSettings.newBuilder();
 * internalRangeServiceSettingsBuilder
 *     .getInternalRangeSettings()
 *     .setRetrySettings(
 *         internalRangeServiceSettingsBuilder
 *             .getInternalRangeSettings()
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
 * InternalRangeServiceStubSettings internalRangeServiceSettings =
 *     internalRangeServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createInternalRange:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InternalRangeServiceStubSettings.Builder internalRangeServiceSettingsBuilder =
 *     InternalRangeServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * internalRangeServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class InternalRangeServiceStubSettings
    extends StubSettings<InternalRangeServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListInternalRangesRequest, ListInternalRangesResponse, ListInternalRangesPagedResponse>
      listInternalRangesSettings;
  private final UnaryCallSettings<GetInternalRangeRequest, InternalRange> getInternalRangeSettings;
  private final UnaryCallSettings<CreateInternalRangeRequest, Operation>
      createInternalRangeSettings;
  private final OperationCallSettings<CreateInternalRangeRequest, InternalRange, OperationMetadata>
      createInternalRangeOperationSettings;
  private final UnaryCallSettings<UpdateInternalRangeRequest, Operation>
      updateInternalRangeSettings;
  private final OperationCallSettings<UpdateInternalRangeRequest, InternalRange, OperationMetadata>
      updateInternalRangeOperationSettings;
  private final UnaryCallSettings<DeleteInternalRangeRequest, Operation>
      deleteInternalRangeSettings;
  private final OperationCallSettings<DeleteInternalRangeRequest, Empty, OperationMetadata>
      deleteInternalRangeOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListInternalRangesRequest, ListInternalRangesResponse, InternalRange>
      LIST_INTERNAL_RANGES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInternalRangesRequest, ListInternalRangesResponse, InternalRange>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInternalRangesRequest injectToken(
                ListInternalRangesRequest payload, String token) {
              return ListInternalRangesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListInternalRangesRequest injectPageSize(
                ListInternalRangesRequest payload, int pageSize) {
              return ListInternalRangesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListInternalRangesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInternalRangesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InternalRange> extractResources(ListInternalRangesResponse payload) {
              return payload.getInternalRangesList();
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
          ListInternalRangesRequest, ListInternalRangesResponse, ListInternalRangesPagedResponse>
      LIST_INTERNAL_RANGES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInternalRangesRequest,
              ListInternalRangesResponse,
              ListInternalRangesPagedResponse>() {
            @Override
            public ApiFuture<ListInternalRangesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInternalRangesRequest, ListInternalRangesResponse> callable,
                ListInternalRangesRequest request,
                ApiCallContext context,
                ApiFuture<ListInternalRangesResponse> futureResponse) {
              PageContext<ListInternalRangesRequest, ListInternalRangesResponse, InternalRange>
                  pageContext =
                      PageContext.create(
                          callable, LIST_INTERNAL_RANGES_PAGE_STR_DESC, request, context);
              return ListInternalRangesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listInternalRanges. */
  public PagedCallSettings<
          ListInternalRangesRequest, ListInternalRangesResponse, ListInternalRangesPagedResponse>
      listInternalRangesSettings() {
    return listInternalRangesSettings;
  }

  /** Returns the object with the settings used for calls to getInternalRange. */
  public UnaryCallSettings<GetInternalRangeRequest, InternalRange> getInternalRangeSettings() {
    return getInternalRangeSettings;
  }

  /** Returns the object with the settings used for calls to createInternalRange. */
  public UnaryCallSettings<CreateInternalRangeRequest, Operation> createInternalRangeSettings() {
    return createInternalRangeSettings;
  }

  /** Returns the object with the settings used for calls to createInternalRange. */
  public OperationCallSettings<CreateInternalRangeRequest, InternalRange, OperationMetadata>
      createInternalRangeOperationSettings() {
    return createInternalRangeOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateInternalRange. */
  public UnaryCallSettings<UpdateInternalRangeRequest, Operation> updateInternalRangeSettings() {
    return updateInternalRangeSettings;
  }

  /** Returns the object with the settings used for calls to updateInternalRange. */
  public OperationCallSettings<UpdateInternalRangeRequest, InternalRange, OperationMetadata>
      updateInternalRangeOperationSettings() {
    return updateInternalRangeOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteInternalRange. */
  public UnaryCallSettings<DeleteInternalRangeRequest, Operation> deleteInternalRangeSettings() {
    return deleteInternalRangeSettings;
  }

  /** Returns the object with the settings used for calls to deleteInternalRange. */
  public OperationCallSettings<DeleteInternalRangeRequest, Empty, OperationMetadata>
      deleteInternalRangeOperationSettings() {
    return deleteInternalRangeOperationSettings;
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

  public InternalRangeServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcInternalRangeServiceStub.create(this);
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
  @ObsoleteApi("Use getEndpoint() instead")
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
            "gapic", GaxProperties.getLibraryVersion(InternalRangeServiceStubSettings.class))
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

  protected InternalRangeServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listInternalRangesSettings = settingsBuilder.listInternalRangesSettings().build();
    getInternalRangeSettings = settingsBuilder.getInternalRangeSettings().build();
    createInternalRangeSettings = settingsBuilder.createInternalRangeSettings().build();
    createInternalRangeOperationSettings =
        settingsBuilder.createInternalRangeOperationSettings().build();
    updateInternalRangeSettings = settingsBuilder.updateInternalRangeSettings().build();
    updateInternalRangeOperationSettings =
        settingsBuilder.updateInternalRangeOperationSettings().build();
    deleteInternalRangeSettings = settingsBuilder.deleteInternalRangeSettings().build();
    deleteInternalRangeOperationSettings =
        settingsBuilder.deleteInternalRangeOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for InternalRangeServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<InternalRangeServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListInternalRangesRequest, ListInternalRangesResponse, ListInternalRangesPagedResponse>
        listInternalRangesSettings;
    private final UnaryCallSettings.Builder<GetInternalRangeRequest, InternalRange>
        getInternalRangeSettings;
    private final UnaryCallSettings.Builder<CreateInternalRangeRequest, Operation>
        createInternalRangeSettings;
    private final OperationCallSettings.Builder<
            CreateInternalRangeRequest, InternalRange, OperationMetadata>
        createInternalRangeOperationSettings;
    private final UnaryCallSettings.Builder<UpdateInternalRangeRequest, Operation>
        updateInternalRangeSettings;
    private final OperationCallSettings.Builder<
            UpdateInternalRangeRequest, InternalRange, OperationMetadata>
        updateInternalRangeOperationSettings;
    private final UnaryCallSettings.Builder<DeleteInternalRangeRequest, Operation>
        deleteInternalRangeSettings;
    private final OperationCallSettings.Builder<
            DeleteInternalRangeRequest, Empty, OperationMetadata>
        deleteInternalRangeOperationSettings;
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
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listInternalRangesSettings = PagedCallSettings.newBuilder(LIST_INTERNAL_RANGES_PAGE_STR_FACT);
      getInternalRangeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInternalRangeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInternalRangeOperationSettings = OperationCallSettings.newBuilder();
      updateInternalRangeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateInternalRangeOperationSettings = OperationCallSettings.newBuilder();
      deleteInternalRangeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteInternalRangeOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listInternalRangesSettings,
              getInternalRangeSettings,
              createInternalRangeSettings,
              updateInternalRangeSettings,
              deleteInternalRangeSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(InternalRangeServiceStubSettings settings) {
      super(settings);

      listInternalRangesSettings = settings.listInternalRangesSettings.toBuilder();
      getInternalRangeSettings = settings.getInternalRangeSettings.toBuilder();
      createInternalRangeSettings = settings.createInternalRangeSettings.toBuilder();
      createInternalRangeOperationSettings =
          settings.createInternalRangeOperationSettings.toBuilder();
      updateInternalRangeSettings = settings.updateInternalRangeSettings.toBuilder();
      updateInternalRangeOperationSettings =
          settings.updateInternalRangeOperationSettings.toBuilder();
      deleteInternalRangeSettings = settings.deleteInternalRangeSettings.toBuilder();
      deleteInternalRangeOperationSettings =
          settings.deleteInternalRangeOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listInternalRangesSettings,
              getInternalRangeSettings,
              createInternalRangeSettings,
              updateInternalRangeSettings,
              deleteInternalRangeSettings,
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
          .listInternalRangesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getInternalRangeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createInternalRangeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateInternalRangeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteInternalRangeSettings()
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
          .createInternalRangeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateInternalRangeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(InternalRange.class))
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
          .updateInternalRangeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateInternalRangeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(InternalRange.class))
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
          .deleteInternalRangeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteInternalRangeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to listInternalRanges. */
    public PagedCallSettings.Builder<
            ListInternalRangesRequest, ListInternalRangesResponse, ListInternalRangesPagedResponse>
        listInternalRangesSettings() {
      return listInternalRangesSettings;
    }

    /** Returns the builder for the settings used for calls to getInternalRange. */
    public UnaryCallSettings.Builder<GetInternalRangeRequest, InternalRange>
        getInternalRangeSettings() {
      return getInternalRangeSettings;
    }

    /** Returns the builder for the settings used for calls to createInternalRange. */
    public UnaryCallSettings.Builder<CreateInternalRangeRequest, Operation>
        createInternalRangeSettings() {
      return createInternalRangeSettings;
    }

    /** Returns the builder for the settings used for calls to createInternalRange. */
    public OperationCallSettings.Builder<
            CreateInternalRangeRequest, InternalRange, OperationMetadata>
        createInternalRangeOperationSettings() {
      return createInternalRangeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateInternalRange. */
    public UnaryCallSettings.Builder<UpdateInternalRangeRequest, Operation>
        updateInternalRangeSettings() {
      return updateInternalRangeSettings;
    }

    /** Returns the builder for the settings used for calls to updateInternalRange. */
    public OperationCallSettings.Builder<
            UpdateInternalRangeRequest, InternalRange, OperationMetadata>
        updateInternalRangeOperationSettings() {
      return updateInternalRangeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInternalRange. */
    public UnaryCallSettings.Builder<DeleteInternalRangeRequest, Operation>
        deleteInternalRangeSettings() {
      return deleteInternalRangeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInternalRange. */
    public OperationCallSettings.Builder<DeleteInternalRangeRequest, Empty, OperationMetadata>
        deleteInternalRangeOperationSettings() {
      return deleteInternalRangeOperationSettings;
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
    public InternalRangeServiceStubSettings build() throws IOException {
      return new InternalRangeServiceStubSettings(this);
    }
  }
}
