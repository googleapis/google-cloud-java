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

package com.google.cloud.beyondcorp.appconnections.v1.stub;

import static com.google.cloud.beyondcorp.appconnections.v1.AppConnectionsServiceClient.ListAppConnectionsPagedResponse;
import static com.google.cloud.beyondcorp.appconnections.v1.AppConnectionsServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.beyondcorp.appconnections.v1.AppConnectionsServiceClient.ResolveAppConnectionsPagedResponse;

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
import com.google.cloud.beyondcorp.appconnections.v1.AppConnection;
import com.google.cloud.beyondcorp.appconnections.v1.AppConnectionOperationMetadata;
import com.google.cloud.beyondcorp.appconnections.v1.CreateAppConnectionRequest;
import com.google.cloud.beyondcorp.appconnections.v1.DeleteAppConnectionRequest;
import com.google.cloud.beyondcorp.appconnections.v1.GetAppConnectionRequest;
import com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsRequest;
import com.google.cloud.beyondcorp.appconnections.v1.ListAppConnectionsResponse;
import com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsRequest;
import com.google.cloud.beyondcorp.appconnections.v1.ResolveAppConnectionsResponse;
import com.google.cloud.beyondcorp.appconnections.v1.UpdateAppConnectionRequest;
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
 * Settings class to configure an instance of {@link AppConnectionsServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (beyondcorp.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getAppConnection to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AppConnectionsServiceStubSettings.Builder appConnectionsServiceSettingsBuilder =
 *     AppConnectionsServiceStubSettings.newBuilder();
 * appConnectionsServiceSettingsBuilder
 *     .getAppConnectionSettings()
 *     .setRetrySettings(
 *         appConnectionsServiceSettingsBuilder
 *             .getAppConnectionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AppConnectionsServiceStubSettings appConnectionsServiceSettings =
 *     appConnectionsServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AppConnectionsServiceStubSettings
    extends StubSettings<AppConnectionsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListAppConnectionsRequest, ListAppConnectionsResponse, ListAppConnectionsPagedResponse>
      listAppConnectionsSettings;
  private final UnaryCallSettings<GetAppConnectionRequest, AppConnection> getAppConnectionSettings;
  private final UnaryCallSettings<CreateAppConnectionRequest, Operation>
      createAppConnectionSettings;
  private final OperationCallSettings<
          CreateAppConnectionRequest, AppConnection, AppConnectionOperationMetadata>
      createAppConnectionOperationSettings;
  private final UnaryCallSettings<UpdateAppConnectionRequest, Operation>
      updateAppConnectionSettings;
  private final OperationCallSettings<
          UpdateAppConnectionRequest, AppConnection, AppConnectionOperationMetadata>
      updateAppConnectionOperationSettings;
  private final UnaryCallSettings<DeleteAppConnectionRequest, Operation>
      deleteAppConnectionSettings;
  private final OperationCallSettings<
          DeleteAppConnectionRequest, Empty, AppConnectionOperationMetadata>
      deleteAppConnectionOperationSettings;
  private final PagedCallSettings<
          ResolveAppConnectionsRequest,
          ResolveAppConnectionsResponse,
          ResolveAppConnectionsPagedResponse>
      resolveAppConnectionsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListAppConnectionsRequest, ListAppConnectionsResponse, AppConnection>
      LIST_APP_CONNECTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAppConnectionsRequest, ListAppConnectionsResponse, AppConnection>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAppConnectionsRequest injectToken(
                ListAppConnectionsRequest payload, String token) {
              return ListAppConnectionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAppConnectionsRequest injectPageSize(
                ListAppConnectionsRequest payload, int pageSize) {
              return ListAppConnectionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAppConnectionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAppConnectionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AppConnection> extractResources(ListAppConnectionsResponse payload) {
              return payload.getAppConnectionsList() == null
                  ? ImmutableList.<AppConnection>of()
                  : payload.getAppConnectionsList();
            }
          };

  private static final PagedListDescriptor<
          ResolveAppConnectionsRequest,
          ResolveAppConnectionsResponse,
          ResolveAppConnectionsResponse.AppConnectionDetails>
      RESOLVE_APP_CONNECTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ResolveAppConnectionsRequest,
              ResolveAppConnectionsResponse,
              ResolveAppConnectionsResponse.AppConnectionDetails>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ResolveAppConnectionsRequest injectToken(
                ResolveAppConnectionsRequest payload, String token) {
              return ResolveAppConnectionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ResolveAppConnectionsRequest injectPageSize(
                ResolveAppConnectionsRequest payload, int pageSize) {
              return ResolveAppConnectionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ResolveAppConnectionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ResolveAppConnectionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ResolveAppConnectionsResponse.AppConnectionDetails> extractResources(
                ResolveAppConnectionsResponse payload) {
              return payload.getAppConnectionDetailsList() == null
                  ? ImmutableList.<ResolveAppConnectionsResponse.AppConnectionDetails>of()
                  : payload.getAppConnectionDetailsList();
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
          ListAppConnectionsRequest, ListAppConnectionsResponse, ListAppConnectionsPagedResponse>
      LIST_APP_CONNECTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAppConnectionsRequest,
              ListAppConnectionsResponse,
              ListAppConnectionsPagedResponse>() {
            @Override
            public ApiFuture<ListAppConnectionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAppConnectionsRequest, ListAppConnectionsResponse> callable,
                ListAppConnectionsRequest request,
                ApiCallContext context,
                ApiFuture<ListAppConnectionsResponse> futureResponse) {
              PageContext<ListAppConnectionsRequest, ListAppConnectionsResponse, AppConnection>
                  pageContext =
                      PageContext.create(
                          callable, LIST_APP_CONNECTIONS_PAGE_STR_DESC, request, context);
              return ListAppConnectionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ResolveAppConnectionsRequest,
          ResolveAppConnectionsResponse,
          ResolveAppConnectionsPagedResponse>
      RESOLVE_APP_CONNECTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ResolveAppConnectionsRequest,
              ResolveAppConnectionsResponse,
              ResolveAppConnectionsPagedResponse>() {
            @Override
            public ApiFuture<ResolveAppConnectionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ResolveAppConnectionsRequest, ResolveAppConnectionsResponse> callable,
                ResolveAppConnectionsRequest request,
                ApiCallContext context,
                ApiFuture<ResolveAppConnectionsResponse> futureResponse) {
              PageContext<
                      ResolveAppConnectionsRequest,
                      ResolveAppConnectionsResponse,
                      ResolveAppConnectionsResponse.AppConnectionDetails>
                  pageContext =
                      PageContext.create(
                          callable, RESOLVE_APP_CONNECTIONS_PAGE_STR_DESC, request, context);
              return ResolveAppConnectionsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listAppConnections. */
  public PagedCallSettings<
          ListAppConnectionsRequest, ListAppConnectionsResponse, ListAppConnectionsPagedResponse>
      listAppConnectionsSettings() {
    return listAppConnectionsSettings;
  }

  /** Returns the object with the settings used for calls to getAppConnection. */
  public UnaryCallSettings<GetAppConnectionRequest, AppConnection> getAppConnectionSettings() {
    return getAppConnectionSettings;
  }

  /** Returns the object with the settings used for calls to createAppConnection. */
  public UnaryCallSettings<CreateAppConnectionRequest, Operation> createAppConnectionSettings() {
    return createAppConnectionSettings;
  }

  /** Returns the object with the settings used for calls to createAppConnection. */
  public OperationCallSettings<
          CreateAppConnectionRequest, AppConnection, AppConnectionOperationMetadata>
      createAppConnectionOperationSettings() {
    return createAppConnectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAppConnection. */
  public UnaryCallSettings<UpdateAppConnectionRequest, Operation> updateAppConnectionSettings() {
    return updateAppConnectionSettings;
  }

  /** Returns the object with the settings used for calls to updateAppConnection. */
  public OperationCallSettings<
          UpdateAppConnectionRequest, AppConnection, AppConnectionOperationMetadata>
      updateAppConnectionOperationSettings() {
    return updateAppConnectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAppConnection. */
  public UnaryCallSettings<DeleteAppConnectionRequest, Operation> deleteAppConnectionSettings() {
    return deleteAppConnectionSettings;
  }

  /** Returns the object with the settings used for calls to deleteAppConnection. */
  public OperationCallSettings<DeleteAppConnectionRequest, Empty, AppConnectionOperationMetadata>
      deleteAppConnectionOperationSettings() {
    return deleteAppConnectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to resolveAppConnections. */
  public PagedCallSettings<
          ResolveAppConnectionsRequest,
          ResolveAppConnectionsResponse,
          ResolveAppConnectionsPagedResponse>
      resolveAppConnectionsSettings() {
    return resolveAppConnectionsSettings;
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

  public AppConnectionsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAppConnectionsServiceStub.create(this);
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
    return "beyondcorp.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "beyondcorp.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(AppConnectionsServiceStubSettings.class))
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

  protected AppConnectionsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listAppConnectionsSettings = settingsBuilder.listAppConnectionsSettings().build();
    getAppConnectionSettings = settingsBuilder.getAppConnectionSettings().build();
    createAppConnectionSettings = settingsBuilder.createAppConnectionSettings().build();
    createAppConnectionOperationSettings =
        settingsBuilder.createAppConnectionOperationSettings().build();
    updateAppConnectionSettings = settingsBuilder.updateAppConnectionSettings().build();
    updateAppConnectionOperationSettings =
        settingsBuilder.updateAppConnectionOperationSettings().build();
    deleteAppConnectionSettings = settingsBuilder.deleteAppConnectionSettings().build();
    deleteAppConnectionOperationSettings =
        settingsBuilder.deleteAppConnectionOperationSettings().build();
    resolveAppConnectionsSettings = settingsBuilder.resolveAppConnectionsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for AppConnectionsServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<AppConnectionsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListAppConnectionsRequest, ListAppConnectionsResponse, ListAppConnectionsPagedResponse>
        listAppConnectionsSettings;
    private final UnaryCallSettings.Builder<GetAppConnectionRequest, AppConnection>
        getAppConnectionSettings;
    private final UnaryCallSettings.Builder<CreateAppConnectionRequest, Operation>
        createAppConnectionSettings;
    private final OperationCallSettings.Builder<
            CreateAppConnectionRequest, AppConnection, AppConnectionOperationMetadata>
        createAppConnectionOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAppConnectionRequest, Operation>
        updateAppConnectionSettings;
    private final OperationCallSettings.Builder<
            UpdateAppConnectionRequest, AppConnection, AppConnectionOperationMetadata>
        updateAppConnectionOperationSettings;
    private final UnaryCallSettings.Builder<DeleteAppConnectionRequest, Operation>
        deleteAppConnectionSettings;
    private final OperationCallSettings.Builder<
            DeleteAppConnectionRequest, Empty, AppConnectionOperationMetadata>
        deleteAppConnectionOperationSettings;
    private final PagedCallSettings.Builder<
            ResolveAppConnectionsRequest,
            ResolveAppConnectionsResponse,
            ResolveAppConnectionsPagedResponse>
        resolveAppConnectionsSettings;
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

      listAppConnectionsSettings = PagedCallSettings.newBuilder(LIST_APP_CONNECTIONS_PAGE_STR_FACT);
      getAppConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAppConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAppConnectionOperationSettings = OperationCallSettings.newBuilder();
      updateAppConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAppConnectionOperationSettings = OperationCallSettings.newBuilder();
      deleteAppConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAppConnectionOperationSettings = OperationCallSettings.newBuilder();
      resolveAppConnectionsSettings =
          PagedCallSettings.newBuilder(RESOLVE_APP_CONNECTIONS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAppConnectionsSettings,
              getAppConnectionSettings,
              createAppConnectionSettings,
              updateAppConnectionSettings,
              deleteAppConnectionSettings,
              resolveAppConnectionsSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(AppConnectionsServiceStubSettings settings) {
      super(settings);

      listAppConnectionsSettings = settings.listAppConnectionsSettings.toBuilder();
      getAppConnectionSettings = settings.getAppConnectionSettings.toBuilder();
      createAppConnectionSettings = settings.createAppConnectionSettings.toBuilder();
      createAppConnectionOperationSettings =
          settings.createAppConnectionOperationSettings.toBuilder();
      updateAppConnectionSettings = settings.updateAppConnectionSettings.toBuilder();
      updateAppConnectionOperationSettings =
          settings.updateAppConnectionOperationSettings.toBuilder();
      deleteAppConnectionSettings = settings.deleteAppConnectionSettings.toBuilder();
      deleteAppConnectionOperationSettings =
          settings.deleteAppConnectionOperationSettings.toBuilder();
      resolveAppConnectionsSettings = settings.resolveAppConnectionsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAppConnectionsSettings,
              getAppConnectionSettings,
              createAppConnectionSettings,
              updateAppConnectionSettings,
              deleteAppConnectionSettings,
              resolveAppConnectionsSettings,
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
          .listAppConnectionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getAppConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createAppConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateAppConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteAppConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .resolveAppConnectionsSettings()
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
          .createAppConnectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAppConnectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AppConnection.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AppConnectionOperationMetadata.class))
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
          .updateAppConnectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAppConnectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AppConnection.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AppConnectionOperationMetadata.class))
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
          .deleteAppConnectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAppConnectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AppConnectionOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to listAppConnections. */
    public PagedCallSettings.Builder<
            ListAppConnectionsRequest, ListAppConnectionsResponse, ListAppConnectionsPagedResponse>
        listAppConnectionsSettings() {
      return listAppConnectionsSettings;
    }

    /** Returns the builder for the settings used for calls to getAppConnection. */
    public UnaryCallSettings.Builder<GetAppConnectionRequest, AppConnection>
        getAppConnectionSettings() {
      return getAppConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to createAppConnection. */
    public UnaryCallSettings.Builder<CreateAppConnectionRequest, Operation>
        createAppConnectionSettings() {
      return createAppConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to createAppConnection. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateAppConnectionRequest, AppConnection, AppConnectionOperationMetadata>
        createAppConnectionOperationSettings() {
      return createAppConnectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAppConnection. */
    public UnaryCallSettings.Builder<UpdateAppConnectionRequest, Operation>
        updateAppConnectionSettings() {
      return updateAppConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to updateAppConnection. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateAppConnectionRequest, AppConnection, AppConnectionOperationMetadata>
        updateAppConnectionOperationSettings() {
      return updateAppConnectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAppConnection. */
    public UnaryCallSettings.Builder<DeleteAppConnectionRequest, Operation>
        deleteAppConnectionSettings() {
      return deleteAppConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAppConnection. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteAppConnectionRequest, Empty, AppConnectionOperationMetadata>
        deleteAppConnectionOperationSettings() {
      return deleteAppConnectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to resolveAppConnections. */
    public PagedCallSettings.Builder<
            ResolveAppConnectionsRequest,
            ResolveAppConnectionsResponse,
            ResolveAppConnectionsPagedResponse>
        resolveAppConnectionsSettings() {
      return resolveAppConnectionsSettings;
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
    public AppConnectionsServiceStubSettings build() throws IOException {
      return new AppConnectionsServiceStubSettings(this);
    }
  }
}
