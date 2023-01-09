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

package com.google.cloud.beyondcorp.appgateways.v1.stub;

import static com.google.cloud.beyondcorp.appgateways.v1.AppGatewaysServiceClient.ListAppGatewaysPagedResponse;
import static com.google.cloud.beyondcorp.appgateways.v1.AppGatewaysServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.beyondcorp.appgateways.v1.AppGateway;
import com.google.cloud.beyondcorp.appgateways.v1.AppGatewayOperationMetadata;
import com.google.cloud.beyondcorp.appgateways.v1.CreateAppGatewayRequest;
import com.google.cloud.beyondcorp.appgateways.v1.DeleteAppGatewayRequest;
import com.google.cloud.beyondcorp.appgateways.v1.GetAppGatewayRequest;
import com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysRequest;
import com.google.cloud.beyondcorp.appgateways.v1.ListAppGatewaysResponse;
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
 * Settings class to configure an instance of {@link AppGatewaysServiceStub}.
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
 * <p>For example, to set the total timeout of getAppGateway to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AppGatewaysServiceStubSettings.Builder appGatewaysServiceSettingsBuilder =
 *     AppGatewaysServiceStubSettings.newBuilder();
 * appGatewaysServiceSettingsBuilder
 *     .getAppGatewaySettings()
 *     .setRetrySettings(
 *         appGatewaysServiceSettingsBuilder
 *             .getAppGatewaySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AppGatewaysServiceStubSettings appGatewaysServiceSettings =
 *     appGatewaysServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AppGatewaysServiceStubSettings extends StubSettings<AppGatewaysServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListAppGatewaysRequest, ListAppGatewaysResponse, ListAppGatewaysPagedResponse>
      listAppGatewaysSettings;
  private final UnaryCallSettings<GetAppGatewayRequest, AppGateway> getAppGatewaySettings;
  private final UnaryCallSettings<CreateAppGatewayRequest, Operation> createAppGatewaySettings;
  private final OperationCallSettings<
          CreateAppGatewayRequest, AppGateway, AppGatewayOperationMetadata>
      createAppGatewayOperationSettings;
  private final UnaryCallSettings<DeleteAppGatewayRequest, Operation> deleteAppGatewaySettings;
  private final OperationCallSettings<DeleteAppGatewayRequest, Empty, AppGatewayOperationMetadata>
      deleteAppGatewayOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListAppGatewaysRequest, ListAppGatewaysResponse, AppGateway>
      LIST_APP_GATEWAYS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAppGatewaysRequest, ListAppGatewaysResponse, AppGateway>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAppGatewaysRequest injectToken(
                ListAppGatewaysRequest payload, String token) {
              return ListAppGatewaysRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAppGatewaysRequest injectPageSize(
                ListAppGatewaysRequest payload, int pageSize) {
              return ListAppGatewaysRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAppGatewaysRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAppGatewaysResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AppGateway> extractResources(ListAppGatewaysResponse payload) {
              return payload.getAppGatewaysList() == null
                  ? ImmutableList.<AppGateway>of()
                  : payload.getAppGatewaysList();
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
          ListAppGatewaysRequest, ListAppGatewaysResponse, ListAppGatewaysPagedResponse>
      LIST_APP_GATEWAYS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAppGatewaysRequest, ListAppGatewaysResponse, ListAppGatewaysPagedResponse>() {
            @Override
            public ApiFuture<ListAppGatewaysPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAppGatewaysRequest, ListAppGatewaysResponse> callable,
                ListAppGatewaysRequest request,
                ApiCallContext context,
                ApiFuture<ListAppGatewaysResponse> futureResponse) {
              PageContext<ListAppGatewaysRequest, ListAppGatewaysResponse, AppGateway> pageContext =
                  PageContext.create(callable, LIST_APP_GATEWAYS_PAGE_STR_DESC, request, context);
              return ListAppGatewaysPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listAppGateways. */
  public PagedCallSettings<
          ListAppGatewaysRequest, ListAppGatewaysResponse, ListAppGatewaysPagedResponse>
      listAppGatewaysSettings() {
    return listAppGatewaysSettings;
  }

  /** Returns the object with the settings used for calls to getAppGateway. */
  public UnaryCallSettings<GetAppGatewayRequest, AppGateway> getAppGatewaySettings() {
    return getAppGatewaySettings;
  }

  /** Returns the object with the settings used for calls to createAppGateway. */
  public UnaryCallSettings<CreateAppGatewayRequest, Operation> createAppGatewaySettings() {
    return createAppGatewaySettings;
  }

  /** Returns the object with the settings used for calls to createAppGateway. */
  public OperationCallSettings<CreateAppGatewayRequest, AppGateway, AppGatewayOperationMetadata>
      createAppGatewayOperationSettings() {
    return createAppGatewayOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAppGateway. */
  public UnaryCallSettings<DeleteAppGatewayRequest, Operation> deleteAppGatewaySettings() {
    return deleteAppGatewaySettings;
  }

  /** Returns the object with the settings used for calls to deleteAppGateway. */
  public OperationCallSettings<DeleteAppGatewayRequest, Empty, AppGatewayOperationMetadata>
      deleteAppGatewayOperationSettings() {
    return deleteAppGatewayOperationSettings;
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

  public AppGatewaysServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAppGatewaysServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(AppGatewaysServiceStubSettings.class))
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

  protected AppGatewaysServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listAppGatewaysSettings = settingsBuilder.listAppGatewaysSettings().build();
    getAppGatewaySettings = settingsBuilder.getAppGatewaySettings().build();
    createAppGatewaySettings = settingsBuilder.createAppGatewaySettings().build();
    createAppGatewayOperationSettings = settingsBuilder.createAppGatewayOperationSettings().build();
    deleteAppGatewaySettings = settingsBuilder.deleteAppGatewaySettings().build();
    deleteAppGatewayOperationSettings = settingsBuilder.deleteAppGatewayOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for AppGatewaysServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<AppGatewaysServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListAppGatewaysRequest, ListAppGatewaysResponse, ListAppGatewaysPagedResponse>
        listAppGatewaysSettings;
    private final UnaryCallSettings.Builder<GetAppGatewayRequest, AppGateway> getAppGatewaySettings;
    private final UnaryCallSettings.Builder<CreateAppGatewayRequest, Operation>
        createAppGatewaySettings;
    private final OperationCallSettings.Builder<
            CreateAppGatewayRequest, AppGateway, AppGatewayOperationMetadata>
        createAppGatewayOperationSettings;
    private final UnaryCallSettings.Builder<DeleteAppGatewayRequest, Operation>
        deleteAppGatewaySettings;
    private final OperationCallSettings.Builder<
            DeleteAppGatewayRequest, Empty, AppGatewayOperationMetadata>
        deleteAppGatewayOperationSettings;
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

      listAppGatewaysSettings = PagedCallSettings.newBuilder(LIST_APP_GATEWAYS_PAGE_STR_FACT);
      getAppGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAppGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAppGatewayOperationSettings = OperationCallSettings.newBuilder();
      deleteAppGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAppGatewayOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAppGatewaysSettings,
              getAppGatewaySettings,
              createAppGatewaySettings,
              deleteAppGatewaySettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(AppGatewaysServiceStubSettings settings) {
      super(settings);

      listAppGatewaysSettings = settings.listAppGatewaysSettings.toBuilder();
      getAppGatewaySettings = settings.getAppGatewaySettings.toBuilder();
      createAppGatewaySettings = settings.createAppGatewaySettings.toBuilder();
      createAppGatewayOperationSettings = settings.createAppGatewayOperationSettings.toBuilder();
      deleteAppGatewaySettings = settings.deleteAppGatewaySettings.toBuilder();
      deleteAppGatewayOperationSettings = settings.deleteAppGatewayOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAppGatewaysSettings,
              getAppGatewaySettings,
              createAppGatewaySettings,
              deleteAppGatewaySettings,
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
          .listAppGatewaysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getAppGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createAppGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteAppGatewaySettings()
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
          .createAppGatewayOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAppGatewayRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AppGateway.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AppGatewayOperationMetadata.class))
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
          .deleteAppGatewayOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAppGatewayRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AppGatewayOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to listAppGateways. */
    public PagedCallSettings.Builder<
            ListAppGatewaysRequest, ListAppGatewaysResponse, ListAppGatewaysPagedResponse>
        listAppGatewaysSettings() {
      return listAppGatewaysSettings;
    }

    /** Returns the builder for the settings used for calls to getAppGateway. */
    public UnaryCallSettings.Builder<GetAppGatewayRequest, AppGateway> getAppGatewaySettings() {
      return getAppGatewaySettings;
    }

    /** Returns the builder for the settings used for calls to createAppGateway. */
    public UnaryCallSettings.Builder<CreateAppGatewayRequest, Operation>
        createAppGatewaySettings() {
      return createAppGatewaySettings;
    }

    /** Returns the builder for the settings used for calls to createAppGateway. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateAppGatewayRequest, AppGateway, AppGatewayOperationMetadata>
        createAppGatewayOperationSettings() {
      return createAppGatewayOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAppGateway. */
    public UnaryCallSettings.Builder<DeleteAppGatewayRequest, Operation>
        deleteAppGatewaySettings() {
      return deleteAppGatewaySettings;
    }

    /** Returns the builder for the settings used for calls to deleteAppGateway. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteAppGatewayRequest, Empty, AppGatewayOperationMetadata>
        deleteAppGatewayOperationSettings() {
      return deleteAppGatewayOperationSettings;
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
    public AppGatewaysServiceStubSettings build() throws IOException {
      return new AppGatewaysServiceStubSettings(this);
    }
  }
}
