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

package com.google.cloud.beyondcorp.appconnectors.v1.stub;

import static com.google.cloud.beyondcorp.appconnectors.v1.AppConnectorsServiceClient.ListAppConnectorsPagedResponse;
import static com.google.cloud.beyondcorp.appconnectors.v1.AppConnectorsServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.beyondcorp.appconnectors.v1.AppConnector;
import com.google.cloud.beyondcorp.appconnectors.v1.AppConnectorOperationMetadata;
import com.google.cloud.beyondcorp.appconnectors.v1.CreateAppConnectorRequest;
import com.google.cloud.beyondcorp.appconnectors.v1.DeleteAppConnectorRequest;
import com.google.cloud.beyondcorp.appconnectors.v1.GetAppConnectorRequest;
import com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsRequest;
import com.google.cloud.beyondcorp.appconnectors.v1.ListAppConnectorsResponse;
import com.google.cloud.beyondcorp.appconnectors.v1.ReportStatusRequest;
import com.google.cloud.beyondcorp.appconnectors.v1.UpdateAppConnectorRequest;
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
 * Settings class to configure an instance of {@link AppConnectorsServiceStub}.
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
 * <p>For example, to set the total timeout of getAppConnector to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AppConnectorsServiceStubSettings.Builder appConnectorsServiceSettingsBuilder =
 *     AppConnectorsServiceStubSettings.newBuilder();
 * appConnectorsServiceSettingsBuilder
 *     .getAppConnectorSettings()
 *     .setRetrySettings(
 *         appConnectorsServiceSettingsBuilder
 *             .getAppConnectorSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AppConnectorsServiceStubSettings appConnectorsServiceSettings =
 *     appConnectorsServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AppConnectorsServiceStubSettings
    extends StubSettings<AppConnectorsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListAppConnectorsRequest, ListAppConnectorsResponse, ListAppConnectorsPagedResponse>
      listAppConnectorsSettings;
  private final UnaryCallSettings<GetAppConnectorRequest, AppConnector> getAppConnectorSettings;
  private final UnaryCallSettings<CreateAppConnectorRequest, Operation> createAppConnectorSettings;
  private final OperationCallSettings<
          CreateAppConnectorRequest, AppConnector, AppConnectorOperationMetadata>
      createAppConnectorOperationSettings;
  private final UnaryCallSettings<UpdateAppConnectorRequest, Operation> updateAppConnectorSettings;
  private final OperationCallSettings<
          UpdateAppConnectorRequest, AppConnector, AppConnectorOperationMetadata>
      updateAppConnectorOperationSettings;
  private final UnaryCallSettings<DeleteAppConnectorRequest, Operation> deleteAppConnectorSettings;
  private final OperationCallSettings<
          DeleteAppConnectorRequest, Empty, AppConnectorOperationMetadata>
      deleteAppConnectorOperationSettings;
  private final UnaryCallSettings<ReportStatusRequest, Operation> reportStatusSettings;
  private final OperationCallSettings<
          ReportStatusRequest, AppConnector, AppConnectorOperationMetadata>
      reportStatusOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListAppConnectorsRequest, ListAppConnectorsResponse, AppConnector>
      LIST_APP_CONNECTORS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAppConnectorsRequest, ListAppConnectorsResponse, AppConnector>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAppConnectorsRequest injectToken(
                ListAppConnectorsRequest payload, String token) {
              return ListAppConnectorsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAppConnectorsRequest injectPageSize(
                ListAppConnectorsRequest payload, int pageSize) {
              return ListAppConnectorsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAppConnectorsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAppConnectorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AppConnector> extractResources(ListAppConnectorsResponse payload) {
              return payload.getAppConnectorsList() == null
                  ? ImmutableList.<AppConnector>of()
                  : payload.getAppConnectorsList();
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
          ListAppConnectorsRequest, ListAppConnectorsResponse, ListAppConnectorsPagedResponse>
      LIST_APP_CONNECTORS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAppConnectorsRequest,
              ListAppConnectorsResponse,
              ListAppConnectorsPagedResponse>() {
            @Override
            public ApiFuture<ListAppConnectorsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAppConnectorsRequest, ListAppConnectorsResponse> callable,
                ListAppConnectorsRequest request,
                ApiCallContext context,
                ApiFuture<ListAppConnectorsResponse> futureResponse) {
              PageContext<ListAppConnectorsRequest, ListAppConnectorsResponse, AppConnector>
                  pageContext =
                      PageContext.create(
                          callable, LIST_APP_CONNECTORS_PAGE_STR_DESC, request, context);
              return ListAppConnectorsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listAppConnectors. */
  public PagedCallSettings<
          ListAppConnectorsRequest, ListAppConnectorsResponse, ListAppConnectorsPagedResponse>
      listAppConnectorsSettings() {
    return listAppConnectorsSettings;
  }

  /** Returns the object with the settings used for calls to getAppConnector. */
  public UnaryCallSettings<GetAppConnectorRequest, AppConnector> getAppConnectorSettings() {
    return getAppConnectorSettings;
  }

  /** Returns the object with the settings used for calls to createAppConnector. */
  public UnaryCallSettings<CreateAppConnectorRequest, Operation> createAppConnectorSettings() {
    return createAppConnectorSettings;
  }

  /** Returns the object with the settings used for calls to createAppConnector. */
  public OperationCallSettings<
          CreateAppConnectorRequest, AppConnector, AppConnectorOperationMetadata>
      createAppConnectorOperationSettings() {
    return createAppConnectorOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAppConnector. */
  public UnaryCallSettings<UpdateAppConnectorRequest, Operation> updateAppConnectorSettings() {
    return updateAppConnectorSettings;
  }

  /** Returns the object with the settings used for calls to updateAppConnector. */
  public OperationCallSettings<
          UpdateAppConnectorRequest, AppConnector, AppConnectorOperationMetadata>
      updateAppConnectorOperationSettings() {
    return updateAppConnectorOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAppConnector. */
  public UnaryCallSettings<DeleteAppConnectorRequest, Operation> deleteAppConnectorSettings() {
    return deleteAppConnectorSettings;
  }

  /** Returns the object with the settings used for calls to deleteAppConnector. */
  public OperationCallSettings<DeleteAppConnectorRequest, Empty, AppConnectorOperationMetadata>
      deleteAppConnectorOperationSettings() {
    return deleteAppConnectorOperationSettings;
  }

  /** Returns the object with the settings used for calls to reportStatus. */
  public UnaryCallSettings<ReportStatusRequest, Operation> reportStatusSettings() {
    return reportStatusSettings;
  }

  /** Returns the object with the settings used for calls to reportStatus. */
  public OperationCallSettings<ReportStatusRequest, AppConnector, AppConnectorOperationMetadata>
      reportStatusOperationSettings() {
    return reportStatusOperationSettings;
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

  public AppConnectorsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAppConnectorsServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(AppConnectorsServiceStubSettings.class))
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

  protected AppConnectorsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listAppConnectorsSettings = settingsBuilder.listAppConnectorsSettings().build();
    getAppConnectorSettings = settingsBuilder.getAppConnectorSettings().build();
    createAppConnectorSettings = settingsBuilder.createAppConnectorSettings().build();
    createAppConnectorOperationSettings =
        settingsBuilder.createAppConnectorOperationSettings().build();
    updateAppConnectorSettings = settingsBuilder.updateAppConnectorSettings().build();
    updateAppConnectorOperationSettings =
        settingsBuilder.updateAppConnectorOperationSettings().build();
    deleteAppConnectorSettings = settingsBuilder.deleteAppConnectorSettings().build();
    deleteAppConnectorOperationSettings =
        settingsBuilder.deleteAppConnectorOperationSettings().build();
    reportStatusSettings = settingsBuilder.reportStatusSettings().build();
    reportStatusOperationSettings = settingsBuilder.reportStatusOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for AppConnectorsServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<AppConnectorsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListAppConnectorsRequest, ListAppConnectorsResponse, ListAppConnectorsPagedResponse>
        listAppConnectorsSettings;
    private final UnaryCallSettings.Builder<GetAppConnectorRequest, AppConnector>
        getAppConnectorSettings;
    private final UnaryCallSettings.Builder<CreateAppConnectorRequest, Operation>
        createAppConnectorSettings;
    private final OperationCallSettings.Builder<
            CreateAppConnectorRequest, AppConnector, AppConnectorOperationMetadata>
        createAppConnectorOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAppConnectorRequest, Operation>
        updateAppConnectorSettings;
    private final OperationCallSettings.Builder<
            UpdateAppConnectorRequest, AppConnector, AppConnectorOperationMetadata>
        updateAppConnectorOperationSettings;
    private final UnaryCallSettings.Builder<DeleteAppConnectorRequest, Operation>
        deleteAppConnectorSettings;
    private final OperationCallSettings.Builder<
            DeleteAppConnectorRequest, Empty, AppConnectorOperationMetadata>
        deleteAppConnectorOperationSettings;
    private final UnaryCallSettings.Builder<ReportStatusRequest, Operation> reportStatusSettings;
    private final OperationCallSettings.Builder<
            ReportStatusRequest, AppConnector, AppConnectorOperationMetadata>
        reportStatusOperationSettings;
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

      listAppConnectorsSettings = PagedCallSettings.newBuilder(LIST_APP_CONNECTORS_PAGE_STR_FACT);
      getAppConnectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAppConnectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAppConnectorOperationSettings = OperationCallSettings.newBuilder();
      updateAppConnectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAppConnectorOperationSettings = OperationCallSettings.newBuilder();
      deleteAppConnectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAppConnectorOperationSettings = OperationCallSettings.newBuilder();
      reportStatusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      reportStatusOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAppConnectorsSettings,
              getAppConnectorSettings,
              createAppConnectorSettings,
              updateAppConnectorSettings,
              deleteAppConnectorSettings,
              reportStatusSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(AppConnectorsServiceStubSettings settings) {
      super(settings);

      listAppConnectorsSettings = settings.listAppConnectorsSettings.toBuilder();
      getAppConnectorSettings = settings.getAppConnectorSettings.toBuilder();
      createAppConnectorSettings = settings.createAppConnectorSettings.toBuilder();
      createAppConnectorOperationSettings =
          settings.createAppConnectorOperationSettings.toBuilder();
      updateAppConnectorSettings = settings.updateAppConnectorSettings.toBuilder();
      updateAppConnectorOperationSettings =
          settings.updateAppConnectorOperationSettings.toBuilder();
      deleteAppConnectorSettings = settings.deleteAppConnectorSettings.toBuilder();
      deleteAppConnectorOperationSettings =
          settings.deleteAppConnectorOperationSettings.toBuilder();
      reportStatusSettings = settings.reportStatusSettings.toBuilder();
      reportStatusOperationSettings = settings.reportStatusOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAppConnectorsSettings,
              getAppConnectorSettings,
              createAppConnectorSettings,
              updateAppConnectorSettings,
              deleteAppConnectorSettings,
              reportStatusSettings,
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
          .listAppConnectorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getAppConnectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createAppConnectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateAppConnectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteAppConnectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .reportStatusSettings()
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
          .createAppConnectorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAppConnectorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AppConnector.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AppConnectorOperationMetadata.class))
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
          .updateAppConnectorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAppConnectorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AppConnector.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AppConnectorOperationMetadata.class))
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
          .deleteAppConnectorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAppConnectorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AppConnectorOperationMetadata.class))
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
          .reportStatusOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ReportStatusRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AppConnector.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AppConnectorOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to listAppConnectors. */
    public PagedCallSettings.Builder<
            ListAppConnectorsRequest, ListAppConnectorsResponse, ListAppConnectorsPagedResponse>
        listAppConnectorsSettings() {
      return listAppConnectorsSettings;
    }

    /** Returns the builder for the settings used for calls to getAppConnector. */
    public UnaryCallSettings.Builder<GetAppConnectorRequest, AppConnector>
        getAppConnectorSettings() {
      return getAppConnectorSettings;
    }

    /** Returns the builder for the settings used for calls to createAppConnector. */
    public UnaryCallSettings.Builder<CreateAppConnectorRequest, Operation>
        createAppConnectorSettings() {
      return createAppConnectorSettings;
    }

    /** Returns the builder for the settings used for calls to createAppConnector. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateAppConnectorRequest, AppConnector, AppConnectorOperationMetadata>
        createAppConnectorOperationSettings() {
      return createAppConnectorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAppConnector. */
    public UnaryCallSettings.Builder<UpdateAppConnectorRequest, Operation>
        updateAppConnectorSettings() {
      return updateAppConnectorSettings;
    }

    /** Returns the builder for the settings used for calls to updateAppConnector. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateAppConnectorRequest, AppConnector, AppConnectorOperationMetadata>
        updateAppConnectorOperationSettings() {
      return updateAppConnectorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAppConnector. */
    public UnaryCallSettings.Builder<DeleteAppConnectorRequest, Operation>
        deleteAppConnectorSettings() {
      return deleteAppConnectorSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAppConnector. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteAppConnectorRequest, Empty, AppConnectorOperationMetadata>
        deleteAppConnectorOperationSettings() {
      return deleteAppConnectorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to reportStatus. */
    public UnaryCallSettings.Builder<ReportStatusRequest, Operation> reportStatusSettings() {
      return reportStatusSettings;
    }

    /** Returns the builder for the settings used for calls to reportStatus. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ReportStatusRequest, AppConnector, AppConnectorOperationMetadata>
        reportStatusOperationSettings() {
      return reportStatusOperationSettings;
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
    public AppConnectorsServiceStubSettings build() throws IOException {
      return new AppConnectorsServiceStubSettings(this);
    }
  }
}
