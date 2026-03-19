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

package com.google.cloud.networkconnectivity.v1beta.stub;

import static com.google.cloud.networkconnectivity.v1beta.TransportManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1beta.TransportManagerClient.ListRemoteTransportProfilesPagedResponse;
import static com.google.cloud.networkconnectivity.v1beta.TransportManagerClient.ListTransportsPagedResponse;

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
import com.google.cloud.networkconnectivity.v1beta.CreateTransportRequest;
import com.google.cloud.networkconnectivity.v1beta.DeleteTransportRequest;
import com.google.cloud.networkconnectivity.v1beta.GetRemoteTransportProfileRequest;
import com.google.cloud.networkconnectivity.v1beta.GetStatusRequest;
import com.google.cloud.networkconnectivity.v1beta.GetStatusResponse;
import com.google.cloud.networkconnectivity.v1beta.GetTransportRequest;
import com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesRequest;
import com.google.cloud.networkconnectivity.v1beta.ListRemoteTransportProfilesResponse;
import com.google.cloud.networkconnectivity.v1beta.ListTransportsRequest;
import com.google.cloud.networkconnectivity.v1beta.ListTransportsResponse;
import com.google.cloud.networkconnectivity.v1beta.OperationMetadata;
import com.google.cloud.networkconnectivity.v1beta.RemoteTransportProfile;
import com.google.cloud.networkconnectivity.v1beta.Transport;
import com.google.cloud.networkconnectivity.v1beta.UpdateTransportRequest;
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
 * Settings class to configure an instance of {@link TransportManagerStub}.
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
 * of getRemoteTransportProfile:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TransportManagerStubSettings.Builder transportManagerSettingsBuilder =
 *     TransportManagerStubSettings.newBuilder();
 * transportManagerSettingsBuilder
 *     .getRemoteTransportProfileSettings()
 *     .setRetrySettings(
 *         transportManagerSettingsBuilder
 *             .getRemoteTransportProfileSettings()
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
 * TransportManagerStubSettings transportManagerSettings = transportManagerSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createTransport:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TransportManagerStubSettings.Builder transportManagerSettingsBuilder =
 *     TransportManagerStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * transportManagerSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class TransportManagerStubSettings extends StubSettings<TransportManagerStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListRemoteTransportProfilesRequest,
          ListRemoteTransportProfilesResponse,
          ListRemoteTransportProfilesPagedResponse>
      listRemoteTransportProfilesSettings;
  private final UnaryCallSettings<GetRemoteTransportProfileRequest, RemoteTransportProfile>
      getRemoteTransportProfileSettings;
  private final PagedCallSettings<
          ListTransportsRequest, ListTransportsResponse, ListTransportsPagedResponse>
      listTransportsSettings;
  private final UnaryCallSettings<GetTransportRequest, Transport> getTransportSettings;
  private final UnaryCallSettings<GetStatusRequest, GetStatusResponse> getStatusSettings;
  private final UnaryCallSettings<CreateTransportRequest, Operation> createTransportSettings;
  private final OperationCallSettings<CreateTransportRequest, Transport, OperationMetadata>
      createTransportOperationSettings;
  private final UnaryCallSettings<UpdateTransportRequest, Operation> updateTransportSettings;
  private final OperationCallSettings<UpdateTransportRequest, Transport, OperationMetadata>
      updateTransportOperationSettings;
  private final UnaryCallSettings<DeleteTransportRequest, Operation> deleteTransportSettings;
  private final OperationCallSettings<DeleteTransportRequest, Empty, OperationMetadata>
      deleteTransportOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListRemoteTransportProfilesRequest,
          ListRemoteTransportProfilesResponse,
          RemoteTransportProfile>
      LIST_REMOTE_TRANSPORT_PROFILES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRemoteTransportProfilesRequest,
              ListRemoteTransportProfilesResponse,
              RemoteTransportProfile>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRemoteTransportProfilesRequest injectToken(
                ListRemoteTransportProfilesRequest payload, String token) {
              return ListRemoteTransportProfilesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListRemoteTransportProfilesRequest injectPageSize(
                ListRemoteTransportProfilesRequest payload, int pageSize) {
              return ListRemoteTransportProfilesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListRemoteTransportProfilesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRemoteTransportProfilesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<RemoteTransportProfile> extractResources(
                ListRemoteTransportProfilesResponse payload) {
              return payload.getRemoteTransportProfilesList();
            }
          };

  private static final PagedListDescriptor<ListTransportsRequest, ListTransportsResponse, Transport>
      LIST_TRANSPORTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTransportsRequest, ListTransportsResponse, Transport>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTransportsRequest injectToken(ListTransportsRequest payload, String token) {
              return ListTransportsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTransportsRequest injectPageSize(
                ListTransportsRequest payload, int pageSize) {
              return ListTransportsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTransportsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTransportsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Transport> extractResources(ListTransportsResponse payload) {
              return payload.getTransportsList();
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
          ListRemoteTransportProfilesRequest,
          ListRemoteTransportProfilesResponse,
          ListRemoteTransportProfilesPagedResponse>
      LIST_REMOTE_TRANSPORT_PROFILES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRemoteTransportProfilesRequest,
              ListRemoteTransportProfilesResponse,
              ListRemoteTransportProfilesPagedResponse>() {
            @Override
            public ApiFuture<ListRemoteTransportProfilesPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListRemoteTransportProfilesRequest, ListRemoteTransportProfilesResponse>
                    callable,
                ListRemoteTransportProfilesRequest request,
                ApiCallContext context,
                ApiFuture<ListRemoteTransportProfilesResponse> futureResponse) {
              PageContext<
                      ListRemoteTransportProfilesRequest,
                      ListRemoteTransportProfilesResponse,
                      RemoteTransportProfile>
                  pageContext =
                      PageContext.create(
                          callable, LIST_REMOTE_TRANSPORT_PROFILES_PAGE_STR_DESC, request, context);
              return ListRemoteTransportProfilesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTransportsRequest, ListTransportsResponse, ListTransportsPagedResponse>
      LIST_TRANSPORTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTransportsRequest, ListTransportsResponse, ListTransportsPagedResponse>() {
            @Override
            public ApiFuture<ListTransportsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTransportsRequest, ListTransportsResponse> callable,
                ListTransportsRequest request,
                ApiCallContext context,
                ApiFuture<ListTransportsResponse> futureResponse) {
              PageContext<ListTransportsRequest, ListTransportsResponse, Transport> pageContext =
                  PageContext.create(callable, LIST_TRANSPORTS_PAGE_STR_DESC, request, context);
              return ListTransportsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listRemoteTransportProfiles. */
  public PagedCallSettings<
          ListRemoteTransportProfilesRequest,
          ListRemoteTransportProfilesResponse,
          ListRemoteTransportProfilesPagedResponse>
      listRemoteTransportProfilesSettings() {
    return listRemoteTransportProfilesSettings;
  }

  /** Returns the object with the settings used for calls to getRemoteTransportProfile. */
  public UnaryCallSettings<GetRemoteTransportProfileRequest, RemoteTransportProfile>
      getRemoteTransportProfileSettings() {
    return getRemoteTransportProfileSettings;
  }

  /** Returns the object with the settings used for calls to listTransports. */
  public PagedCallSettings<
          ListTransportsRequest, ListTransportsResponse, ListTransportsPagedResponse>
      listTransportsSettings() {
    return listTransportsSettings;
  }

  /** Returns the object with the settings used for calls to getTransport. */
  public UnaryCallSettings<GetTransportRequest, Transport> getTransportSettings() {
    return getTransportSettings;
  }

  /** Returns the object with the settings used for calls to getStatus. */
  public UnaryCallSettings<GetStatusRequest, GetStatusResponse> getStatusSettings() {
    return getStatusSettings;
  }

  /** Returns the object with the settings used for calls to createTransport. */
  public UnaryCallSettings<CreateTransportRequest, Operation> createTransportSettings() {
    return createTransportSettings;
  }

  /** Returns the object with the settings used for calls to createTransport. */
  public OperationCallSettings<CreateTransportRequest, Transport, OperationMetadata>
      createTransportOperationSettings() {
    return createTransportOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateTransport. */
  public UnaryCallSettings<UpdateTransportRequest, Operation> updateTransportSettings() {
    return updateTransportSettings;
  }

  /** Returns the object with the settings used for calls to updateTransport. */
  public OperationCallSettings<UpdateTransportRequest, Transport, OperationMetadata>
      updateTransportOperationSettings() {
    return updateTransportOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteTransport. */
  public UnaryCallSettings<DeleteTransportRequest, Operation> deleteTransportSettings() {
    return deleteTransportSettings;
  }

  /** Returns the object with the settings used for calls to deleteTransport. */
  public OperationCallSettings<DeleteTransportRequest, Empty, OperationMetadata>
      deleteTransportOperationSettings() {
    return deleteTransportOperationSettings;
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

  public TransportManagerStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcTransportManagerStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(TransportManagerStubSettings.class))
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

  protected TransportManagerStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listRemoteTransportProfilesSettings =
        settingsBuilder.listRemoteTransportProfilesSettings().build();
    getRemoteTransportProfileSettings = settingsBuilder.getRemoteTransportProfileSettings().build();
    listTransportsSettings = settingsBuilder.listTransportsSettings().build();
    getTransportSettings = settingsBuilder.getTransportSettings().build();
    getStatusSettings = settingsBuilder.getStatusSettings().build();
    createTransportSettings = settingsBuilder.createTransportSettings().build();
    createTransportOperationSettings = settingsBuilder.createTransportOperationSettings().build();
    updateTransportSettings = settingsBuilder.updateTransportSettings().build();
    updateTransportOperationSettings = settingsBuilder.updateTransportOperationSettings().build();
    deleteTransportSettings = settingsBuilder.deleteTransportSettings().build();
    deleteTransportOperationSettings = settingsBuilder.deleteTransportOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for TransportManagerStubSettings. */
  public static class Builder extends StubSettings.Builder<TransportManagerStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListRemoteTransportProfilesRequest,
            ListRemoteTransportProfilesResponse,
            ListRemoteTransportProfilesPagedResponse>
        listRemoteTransportProfilesSettings;
    private final UnaryCallSettings.Builder<
            GetRemoteTransportProfileRequest, RemoteTransportProfile>
        getRemoteTransportProfileSettings;
    private final PagedCallSettings.Builder<
            ListTransportsRequest, ListTransportsResponse, ListTransportsPagedResponse>
        listTransportsSettings;
    private final UnaryCallSettings.Builder<GetTransportRequest, Transport> getTransportSettings;
    private final UnaryCallSettings.Builder<GetStatusRequest, GetStatusResponse> getStatusSettings;
    private final UnaryCallSettings.Builder<CreateTransportRequest, Operation>
        createTransportSettings;
    private final OperationCallSettings.Builder<
            CreateTransportRequest, Transport, OperationMetadata>
        createTransportOperationSettings;
    private final UnaryCallSettings.Builder<UpdateTransportRequest, Operation>
        updateTransportSettings;
    private final OperationCallSettings.Builder<
            UpdateTransportRequest, Transport, OperationMetadata>
        updateTransportOperationSettings;
    private final UnaryCallSettings.Builder<DeleteTransportRequest, Operation>
        deleteTransportSettings;
    private final OperationCallSettings.Builder<DeleteTransportRequest, Empty, OperationMetadata>
        deleteTransportOperationSettings;
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
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listRemoteTransportProfilesSettings =
          PagedCallSettings.newBuilder(LIST_REMOTE_TRANSPORT_PROFILES_PAGE_STR_FACT);
      getRemoteTransportProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTransportsSettings = PagedCallSettings.newBuilder(LIST_TRANSPORTS_PAGE_STR_FACT);
      getTransportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getStatusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTransportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTransportOperationSettings = OperationCallSettings.newBuilder();
      updateTransportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTransportOperationSettings = OperationCallSettings.newBuilder();
      deleteTransportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTransportOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listRemoteTransportProfilesSettings,
              getRemoteTransportProfileSettings,
              listTransportsSettings,
              getTransportSettings,
              getStatusSettings,
              createTransportSettings,
              updateTransportSettings,
              deleteTransportSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(TransportManagerStubSettings settings) {
      super(settings);

      listRemoteTransportProfilesSettings =
          settings.listRemoteTransportProfilesSettings.toBuilder();
      getRemoteTransportProfileSettings = settings.getRemoteTransportProfileSettings.toBuilder();
      listTransportsSettings = settings.listTransportsSettings.toBuilder();
      getTransportSettings = settings.getTransportSettings.toBuilder();
      getStatusSettings = settings.getStatusSettings.toBuilder();
      createTransportSettings = settings.createTransportSettings.toBuilder();
      createTransportOperationSettings = settings.createTransportOperationSettings.toBuilder();
      updateTransportSettings = settings.updateTransportSettings.toBuilder();
      updateTransportOperationSettings = settings.updateTransportOperationSettings.toBuilder();
      deleteTransportSettings = settings.deleteTransportSettings.toBuilder();
      deleteTransportOperationSettings = settings.deleteTransportOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listRemoteTransportProfilesSettings,
              getRemoteTransportProfileSettings,
              listTransportsSettings,
              getTransportSettings,
              getStatusSettings,
              createTransportSettings,
              updateTransportSettings,
              deleteTransportSettings,
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
          .listRemoteTransportProfilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRemoteTransportProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listTransportsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getTransportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getStatusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createTransportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateTransportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteTransportSettings()
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
          .createTransportOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateTransportRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Transport.class))
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
          .updateTransportOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateTransportRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Transport.class))
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
          .deleteTransportOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteTransportRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to listRemoteTransportProfiles. */
    public PagedCallSettings.Builder<
            ListRemoteTransportProfilesRequest,
            ListRemoteTransportProfilesResponse,
            ListRemoteTransportProfilesPagedResponse>
        listRemoteTransportProfilesSettings() {
      return listRemoteTransportProfilesSettings;
    }

    /** Returns the builder for the settings used for calls to getRemoteTransportProfile. */
    public UnaryCallSettings.Builder<GetRemoteTransportProfileRequest, RemoteTransportProfile>
        getRemoteTransportProfileSettings() {
      return getRemoteTransportProfileSettings;
    }

    /** Returns the builder for the settings used for calls to listTransports. */
    public PagedCallSettings.Builder<
            ListTransportsRequest, ListTransportsResponse, ListTransportsPagedResponse>
        listTransportsSettings() {
      return listTransportsSettings;
    }

    /** Returns the builder for the settings used for calls to getTransport. */
    public UnaryCallSettings.Builder<GetTransportRequest, Transport> getTransportSettings() {
      return getTransportSettings;
    }

    /** Returns the builder for the settings used for calls to getStatus. */
    public UnaryCallSettings.Builder<GetStatusRequest, GetStatusResponse> getStatusSettings() {
      return getStatusSettings;
    }

    /** Returns the builder for the settings used for calls to createTransport. */
    public UnaryCallSettings.Builder<CreateTransportRequest, Operation> createTransportSettings() {
      return createTransportSettings;
    }

    /** Returns the builder for the settings used for calls to createTransport. */
    public OperationCallSettings.Builder<CreateTransportRequest, Transport, OperationMetadata>
        createTransportOperationSettings() {
      return createTransportOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateTransport. */
    public UnaryCallSettings.Builder<UpdateTransportRequest, Operation> updateTransportSettings() {
      return updateTransportSettings;
    }

    /** Returns the builder for the settings used for calls to updateTransport. */
    public OperationCallSettings.Builder<UpdateTransportRequest, Transport, OperationMetadata>
        updateTransportOperationSettings() {
      return updateTransportOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTransport. */
    public UnaryCallSettings.Builder<DeleteTransportRequest, Operation> deleteTransportSettings() {
      return deleteTransportSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTransport. */
    public OperationCallSettings.Builder<DeleteTransportRequest, Empty, OperationMetadata>
        deleteTransportOperationSettings() {
      return deleteTransportOperationSettings;
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
    public TransportManagerStubSettings build() throws IOException {
      return new TransportManagerStubSettings(this);
    }
  }
}
