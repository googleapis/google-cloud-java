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

package com.google.cloud.beyondcorp.clientconnectorservices.v1.stub;

import static com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorServicesServiceClient.ListClientConnectorServicesPagedResponse;
import static com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorServicesServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorService;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorServiceOperationMetadata;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.CreateClientConnectorServiceRequest;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.DeleteClientConnectorServiceRequest;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.GetClientConnectorServiceRequest;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesRequest;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.ListClientConnectorServicesResponse;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.UpdateClientConnectorServiceRequest;
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
 * Settings class to configure an instance of {@link ClientConnectorServicesServiceStub}.
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
 * <p>For example, to set the total timeout of getClientConnectorService to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ClientConnectorServicesServiceStubSettings.Builder
 *     clientConnectorServicesServiceSettingsBuilder =
 *         ClientConnectorServicesServiceStubSettings.newBuilder();
 * clientConnectorServicesServiceSettingsBuilder
 *     .getClientConnectorServiceSettings()
 *     .setRetrySettings(
 *         clientConnectorServicesServiceSettingsBuilder
 *             .getClientConnectorServiceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ClientConnectorServicesServiceStubSettings clientConnectorServicesServiceSettings =
 *     clientConnectorServicesServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ClientConnectorServicesServiceStubSettings
    extends StubSettings<ClientConnectorServicesServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListClientConnectorServicesRequest,
          ListClientConnectorServicesResponse,
          ListClientConnectorServicesPagedResponse>
      listClientConnectorServicesSettings;
  private final UnaryCallSettings<GetClientConnectorServiceRequest, ClientConnectorService>
      getClientConnectorServiceSettings;
  private final UnaryCallSettings<CreateClientConnectorServiceRequest, Operation>
      createClientConnectorServiceSettings;
  private final OperationCallSettings<
          CreateClientConnectorServiceRequest,
          ClientConnectorService,
          ClientConnectorServiceOperationMetadata>
      createClientConnectorServiceOperationSettings;
  private final UnaryCallSettings<UpdateClientConnectorServiceRequest, Operation>
      updateClientConnectorServiceSettings;
  private final OperationCallSettings<
          UpdateClientConnectorServiceRequest,
          ClientConnectorService,
          ClientConnectorServiceOperationMetadata>
      updateClientConnectorServiceOperationSettings;
  private final UnaryCallSettings<DeleteClientConnectorServiceRequest, Operation>
      deleteClientConnectorServiceSettings;
  private final OperationCallSettings<
          DeleteClientConnectorServiceRequest, Empty, ClientConnectorServiceOperationMetadata>
      deleteClientConnectorServiceOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListClientConnectorServicesRequest,
          ListClientConnectorServicesResponse,
          ClientConnectorService>
      LIST_CLIENT_CONNECTOR_SERVICES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListClientConnectorServicesRequest,
              ListClientConnectorServicesResponse,
              ClientConnectorService>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListClientConnectorServicesRequest injectToken(
                ListClientConnectorServicesRequest payload, String token) {
              return ListClientConnectorServicesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListClientConnectorServicesRequest injectPageSize(
                ListClientConnectorServicesRequest payload, int pageSize) {
              return ListClientConnectorServicesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListClientConnectorServicesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListClientConnectorServicesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ClientConnectorService> extractResources(
                ListClientConnectorServicesResponse payload) {
              return payload.getClientConnectorServicesList() == null
                  ? ImmutableList.<ClientConnectorService>of()
                  : payload.getClientConnectorServicesList();
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
          ListClientConnectorServicesRequest,
          ListClientConnectorServicesResponse,
          ListClientConnectorServicesPagedResponse>
      LIST_CLIENT_CONNECTOR_SERVICES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListClientConnectorServicesRequest,
              ListClientConnectorServicesResponse,
              ListClientConnectorServicesPagedResponse>() {
            @Override
            public ApiFuture<ListClientConnectorServicesPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListClientConnectorServicesRequest, ListClientConnectorServicesResponse>
                    callable,
                ListClientConnectorServicesRequest request,
                ApiCallContext context,
                ApiFuture<ListClientConnectorServicesResponse> futureResponse) {
              PageContext<
                      ListClientConnectorServicesRequest,
                      ListClientConnectorServicesResponse,
                      ClientConnectorService>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CLIENT_CONNECTOR_SERVICES_PAGE_STR_DESC, request, context);
              return ListClientConnectorServicesPagedResponse.createAsync(
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

  /** Returns the object with the settings used for calls to listClientConnectorServices. */
  public PagedCallSettings<
          ListClientConnectorServicesRequest,
          ListClientConnectorServicesResponse,
          ListClientConnectorServicesPagedResponse>
      listClientConnectorServicesSettings() {
    return listClientConnectorServicesSettings;
  }

  /** Returns the object with the settings used for calls to getClientConnectorService. */
  public UnaryCallSettings<GetClientConnectorServiceRequest, ClientConnectorService>
      getClientConnectorServiceSettings() {
    return getClientConnectorServiceSettings;
  }

  /** Returns the object with the settings used for calls to createClientConnectorService. */
  public UnaryCallSettings<CreateClientConnectorServiceRequest, Operation>
      createClientConnectorServiceSettings() {
    return createClientConnectorServiceSettings;
  }

  /** Returns the object with the settings used for calls to createClientConnectorService. */
  public OperationCallSettings<
          CreateClientConnectorServiceRequest,
          ClientConnectorService,
          ClientConnectorServiceOperationMetadata>
      createClientConnectorServiceOperationSettings() {
    return createClientConnectorServiceOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateClientConnectorService. */
  public UnaryCallSettings<UpdateClientConnectorServiceRequest, Operation>
      updateClientConnectorServiceSettings() {
    return updateClientConnectorServiceSettings;
  }

  /** Returns the object with the settings used for calls to updateClientConnectorService. */
  public OperationCallSettings<
          UpdateClientConnectorServiceRequest,
          ClientConnectorService,
          ClientConnectorServiceOperationMetadata>
      updateClientConnectorServiceOperationSettings() {
    return updateClientConnectorServiceOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteClientConnectorService. */
  public UnaryCallSettings<DeleteClientConnectorServiceRequest, Operation>
      deleteClientConnectorServiceSettings() {
    return deleteClientConnectorServiceSettings;
  }

  /** Returns the object with the settings used for calls to deleteClientConnectorService. */
  public OperationCallSettings<
          DeleteClientConnectorServiceRequest, Empty, ClientConnectorServiceOperationMetadata>
      deleteClientConnectorServiceOperationSettings() {
    return deleteClientConnectorServiceOperationSettings;
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

  public ClientConnectorServicesServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcClientConnectorServicesServiceStub.create(this);
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
            "gapic",
            GaxProperties.getLibraryVersion(ClientConnectorServicesServiceStubSettings.class))
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

  protected ClientConnectorServicesServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listClientConnectorServicesSettings =
        settingsBuilder.listClientConnectorServicesSettings().build();
    getClientConnectorServiceSettings = settingsBuilder.getClientConnectorServiceSettings().build();
    createClientConnectorServiceSettings =
        settingsBuilder.createClientConnectorServiceSettings().build();
    createClientConnectorServiceOperationSettings =
        settingsBuilder.createClientConnectorServiceOperationSettings().build();
    updateClientConnectorServiceSettings =
        settingsBuilder.updateClientConnectorServiceSettings().build();
    updateClientConnectorServiceOperationSettings =
        settingsBuilder.updateClientConnectorServiceOperationSettings().build();
    deleteClientConnectorServiceSettings =
        settingsBuilder.deleteClientConnectorServiceSettings().build();
    deleteClientConnectorServiceOperationSettings =
        settingsBuilder.deleteClientConnectorServiceOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for ClientConnectorServicesServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ClientConnectorServicesServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListClientConnectorServicesRequest,
            ListClientConnectorServicesResponse,
            ListClientConnectorServicesPagedResponse>
        listClientConnectorServicesSettings;
    private final UnaryCallSettings.Builder<
            GetClientConnectorServiceRequest, ClientConnectorService>
        getClientConnectorServiceSettings;
    private final UnaryCallSettings.Builder<CreateClientConnectorServiceRequest, Operation>
        createClientConnectorServiceSettings;
    private final OperationCallSettings.Builder<
            CreateClientConnectorServiceRequest,
            ClientConnectorService,
            ClientConnectorServiceOperationMetadata>
        createClientConnectorServiceOperationSettings;
    private final UnaryCallSettings.Builder<UpdateClientConnectorServiceRequest, Operation>
        updateClientConnectorServiceSettings;
    private final OperationCallSettings.Builder<
            UpdateClientConnectorServiceRequest,
            ClientConnectorService,
            ClientConnectorServiceOperationMetadata>
        updateClientConnectorServiceOperationSettings;
    private final UnaryCallSettings.Builder<DeleteClientConnectorServiceRequest, Operation>
        deleteClientConnectorServiceSettings;
    private final OperationCallSettings.Builder<
            DeleteClientConnectorServiceRequest, Empty, ClientConnectorServiceOperationMetadata>
        deleteClientConnectorServiceOperationSettings;
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

      listClientConnectorServicesSettings =
          PagedCallSettings.newBuilder(LIST_CLIENT_CONNECTOR_SERVICES_PAGE_STR_FACT);
      getClientConnectorServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createClientConnectorServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createClientConnectorServiceOperationSettings = OperationCallSettings.newBuilder();
      updateClientConnectorServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateClientConnectorServiceOperationSettings = OperationCallSettings.newBuilder();
      deleteClientConnectorServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteClientConnectorServiceOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listClientConnectorServicesSettings,
              getClientConnectorServiceSettings,
              createClientConnectorServiceSettings,
              updateClientConnectorServiceSettings,
              deleteClientConnectorServiceSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(ClientConnectorServicesServiceStubSettings settings) {
      super(settings);

      listClientConnectorServicesSettings =
          settings.listClientConnectorServicesSettings.toBuilder();
      getClientConnectorServiceSettings = settings.getClientConnectorServiceSettings.toBuilder();
      createClientConnectorServiceSettings =
          settings.createClientConnectorServiceSettings.toBuilder();
      createClientConnectorServiceOperationSettings =
          settings.createClientConnectorServiceOperationSettings.toBuilder();
      updateClientConnectorServiceSettings =
          settings.updateClientConnectorServiceSettings.toBuilder();
      updateClientConnectorServiceOperationSettings =
          settings.updateClientConnectorServiceOperationSettings.toBuilder();
      deleteClientConnectorServiceSettings =
          settings.deleteClientConnectorServiceSettings.toBuilder();
      deleteClientConnectorServiceOperationSettings =
          settings.deleteClientConnectorServiceOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listClientConnectorServicesSettings,
              getClientConnectorServiceSettings,
              createClientConnectorServiceSettings,
              updateClientConnectorServiceSettings,
              deleteClientConnectorServiceSettings,
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
          .listClientConnectorServicesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getClientConnectorServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createClientConnectorServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateClientConnectorServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteClientConnectorServiceSettings()
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
          .createClientConnectorServiceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateClientConnectorServiceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ClientConnectorService.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ClientConnectorServiceOperationMetadata.class))
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
          .updateClientConnectorServiceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateClientConnectorServiceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ClientConnectorService.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ClientConnectorServiceOperationMetadata.class))
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
          .deleteClientConnectorServiceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteClientConnectorServiceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ClientConnectorServiceOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to listClientConnectorServices. */
    public PagedCallSettings.Builder<
            ListClientConnectorServicesRequest,
            ListClientConnectorServicesResponse,
            ListClientConnectorServicesPagedResponse>
        listClientConnectorServicesSettings() {
      return listClientConnectorServicesSettings;
    }

    /** Returns the builder for the settings used for calls to getClientConnectorService. */
    public UnaryCallSettings.Builder<GetClientConnectorServiceRequest, ClientConnectorService>
        getClientConnectorServiceSettings() {
      return getClientConnectorServiceSettings;
    }

    /** Returns the builder for the settings used for calls to createClientConnectorService. */
    public UnaryCallSettings.Builder<CreateClientConnectorServiceRequest, Operation>
        createClientConnectorServiceSettings() {
      return createClientConnectorServiceSettings;
    }

    /** Returns the builder for the settings used for calls to createClientConnectorService. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateClientConnectorServiceRequest,
            ClientConnectorService,
            ClientConnectorServiceOperationMetadata>
        createClientConnectorServiceOperationSettings() {
      return createClientConnectorServiceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateClientConnectorService. */
    public UnaryCallSettings.Builder<UpdateClientConnectorServiceRequest, Operation>
        updateClientConnectorServiceSettings() {
      return updateClientConnectorServiceSettings;
    }

    /** Returns the builder for the settings used for calls to updateClientConnectorService. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateClientConnectorServiceRequest,
            ClientConnectorService,
            ClientConnectorServiceOperationMetadata>
        updateClientConnectorServiceOperationSettings() {
      return updateClientConnectorServiceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteClientConnectorService. */
    public UnaryCallSettings.Builder<DeleteClientConnectorServiceRequest, Operation>
        deleteClientConnectorServiceSettings() {
      return deleteClientConnectorServiceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteClientConnectorService. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteClientConnectorServiceRequest, Empty, ClientConnectorServiceOperationMetadata>
        deleteClientConnectorServiceOperationSettings() {
      return deleteClientConnectorServiceOperationSettings;
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
    public ClientConnectorServicesServiceStubSettings build() throws IOException {
      return new ClientConnectorServicesServiceStubSettings(this);
    }
  }
}
