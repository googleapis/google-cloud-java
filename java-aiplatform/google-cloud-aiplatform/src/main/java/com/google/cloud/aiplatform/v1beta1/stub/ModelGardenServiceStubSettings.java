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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.ModelGardenServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelGardenServiceClient.ListPublisherModelsPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.AcceptPublisherModelEulaRequest;
import com.google.cloud.aiplatform.v1beta1.CheckPublisherModelEulaAcceptanceRequest;
import com.google.cloud.aiplatform.v1beta1.DeployOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeployPublisherModelOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeployPublisherModelRequest;
import com.google.cloud.aiplatform.v1beta1.DeployPublisherModelResponse;
import com.google.cloud.aiplatform.v1beta1.DeployRequest;
import com.google.cloud.aiplatform.v1beta1.DeployResponse;
import com.google.cloud.aiplatform.v1beta1.ExportPublisherModelOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ExportPublisherModelRequest;
import com.google.cloud.aiplatform.v1beta1.ExportPublisherModelResponse;
import com.google.cloud.aiplatform.v1beta1.GetPublisherModelRequest;
import com.google.cloud.aiplatform.v1beta1.ListPublisherModelsRequest;
import com.google.cloud.aiplatform.v1beta1.ListPublisherModelsResponse;
import com.google.cloud.aiplatform.v1beta1.PublisherModel;
import com.google.cloud.aiplatform.v1beta1.PublisherModelEulaAcceptance;
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
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ModelGardenServiceStub}.
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getPublisherModel:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ModelGardenServiceStubSettings.Builder modelGardenServiceSettingsBuilder =
 *     ModelGardenServiceStubSettings.newBuilder();
 * modelGardenServiceSettingsBuilder
 *     .getPublisherModelSettings()
 *     .setRetrySettings(
 *         modelGardenServiceSettingsBuilder
 *             .getPublisherModelSettings()
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
 * ModelGardenServiceStubSettings modelGardenServiceSettings =
 *     modelGardenServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for deploy:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ModelGardenServiceStubSettings.Builder modelGardenServiceSettingsBuilder =
 *     ModelGardenServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * modelGardenServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ModelGardenServiceStubSettings extends StubSettings<ModelGardenServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetPublisherModelRequest, PublisherModel>
      getPublisherModelSettings;
  private final PagedCallSettings<
          ListPublisherModelsRequest, ListPublisherModelsResponse, ListPublisherModelsPagedResponse>
      listPublisherModelsSettings;
  private final UnaryCallSettings<DeployRequest, Operation> deploySettings;
  private final OperationCallSettings<DeployRequest, DeployResponse, DeployOperationMetadata>
      deployOperationSettings;
  private final UnaryCallSettings<DeployPublisherModelRequest, Operation>
      deployPublisherModelSettings;
  private final OperationCallSettings<
          DeployPublisherModelRequest,
          DeployPublisherModelResponse,
          DeployPublisherModelOperationMetadata>
      deployPublisherModelOperationSettings;
  private final UnaryCallSettings<ExportPublisherModelRequest, Operation>
      exportPublisherModelSettings;
  private final OperationCallSettings<
          ExportPublisherModelRequest,
          ExportPublisherModelResponse,
          ExportPublisherModelOperationMetadata>
      exportPublisherModelOperationSettings;
  private final UnaryCallSettings<
          CheckPublisherModelEulaAcceptanceRequest, PublisherModelEulaAcceptance>
      checkPublisherModelEulaAcceptanceSettings;
  private final UnaryCallSettings<AcceptPublisherModelEulaRequest, PublisherModelEulaAcceptance>
      acceptPublisherModelEulaSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListPublisherModelsRequest, ListPublisherModelsResponse, PublisherModel>
      LIST_PUBLISHER_MODELS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPublisherModelsRequest, ListPublisherModelsResponse, PublisherModel>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPublisherModelsRequest injectToken(
                ListPublisherModelsRequest payload, String token) {
              return ListPublisherModelsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPublisherModelsRequest injectPageSize(
                ListPublisherModelsRequest payload, int pageSize) {
              return ListPublisherModelsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPublisherModelsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPublisherModelsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PublisherModel> extractResources(ListPublisherModelsResponse payload) {
              return payload.getPublisherModelsList();
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
          ListPublisherModelsRequest, ListPublisherModelsResponse, ListPublisherModelsPagedResponse>
      LIST_PUBLISHER_MODELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPublisherModelsRequest,
              ListPublisherModelsResponse,
              ListPublisherModelsPagedResponse>() {
            @Override
            public ApiFuture<ListPublisherModelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPublisherModelsRequest, ListPublisherModelsResponse> callable,
                ListPublisherModelsRequest request,
                ApiCallContext context,
                ApiFuture<ListPublisherModelsResponse> futureResponse) {
              PageContext<ListPublisherModelsRequest, ListPublisherModelsResponse, PublisherModel>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PUBLISHER_MODELS_PAGE_STR_DESC, request, context);
              return ListPublisherModelsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to getPublisherModel. */
  public UnaryCallSettings<GetPublisherModelRequest, PublisherModel> getPublisherModelSettings() {
    return getPublisherModelSettings;
  }

  /** Returns the object with the settings used for calls to listPublisherModels. */
  public PagedCallSettings<
          ListPublisherModelsRequest, ListPublisherModelsResponse, ListPublisherModelsPagedResponse>
      listPublisherModelsSettings() {
    return listPublisherModelsSettings;
  }

  /** Returns the object with the settings used for calls to deploy. */
  public UnaryCallSettings<DeployRequest, Operation> deploySettings() {
    return deploySettings;
  }

  /** Returns the object with the settings used for calls to deploy. */
  public OperationCallSettings<DeployRequest, DeployResponse, DeployOperationMetadata>
      deployOperationSettings() {
    return deployOperationSettings;
  }

  /**
   * Returns the object with the settings used for calls to deployPublisherModel.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<DeployPublisherModelRequest, Operation> deployPublisherModelSettings() {
    return deployPublisherModelSettings;
  }

  /** Returns the object with the settings used for calls to deployPublisherModel. */
  public OperationCallSettings<
          DeployPublisherModelRequest,
          DeployPublisherModelResponse,
          DeployPublisherModelOperationMetadata>
      deployPublisherModelOperationSettings() {
    return deployPublisherModelOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportPublisherModel. */
  public UnaryCallSettings<ExportPublisherModelRequest, Operation> exportPublisherModelSettings() {
    return exportPublisherModelSettings;
  }

  /** Returns the object with the settings used for calls to exportPublisherModel. */
  public OperationCallSettings<
          ExportPublisherModelRequest,
          ExportPublisherModelResponse,
          ExportPublisherModelOperationMetadata>
      exportPublisherModelOperationSettings() {
    return exportPublisherModelOperationSettings;
  }

  /** Returns the object with the settings used for calls to checkPublisherModelEulaAcceptance. */
  public UnaryCallSettings<CheckPublisherModelEulaAcceptanceRequest, PublisherModelEulaAcceptance>
      checkPublisherModelEulaAcceptanceSettings() {
    return checkPublisherModelEulaAcceptanceSettings;
  }

  /** Returns the object with the settings used for calls to acceptPublisherModelEula. */
  public UnaryCallSettings<AcceptPublisherModelEulaRequest, PublisherModelEulaAcceptance>
      acceptPublisherModelEulaSettings() {
    return acceptPublisherModelEulaSettings;
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

  public ModelGardenServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcModelGardenServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "aiplatform";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
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

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ModelGardenServiceStubSettings.class))
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

  protected ModelGardenServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getPublisherModelSettings = settingsBuilder.getPublisherModelSettings().build();
    listPublisherModelsSettings = settingsBuilder.listPublisherModelsSettings().build();
    deploySettings = settingsBuilder.deploySettings().build();
    deployOperationSettings = settingsBuilder.deployOperationSettings().build();
    deployPublisherModelSettings = settingsBuilder.deployPublisherModelSettings().build();
    deployPublisherModelOperationSettings =
        settingsBuilder.deployPublisherModelOperationSettings().build();
    exportPublisherModelSettings = settingsBuilder.exportPublisherModelSettings().build();
    exportPublisherModelOperationSettings =
        settingsBuilder.exportPublisherModelOperationSettings().build();
    checkPublisherModelEulaAcceptanceSettings =
        settingsBuilder.checkPublisherModelEulaAcceptanceSettings().build();
    acceptPublisherModelEulaSettings = settingsBuilder.acceptPublisherModelEulaSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for ModelGardenServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ModelGardenServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetPublisherModelRequest, PublisherModel>
        getPublisherModelSettings;
    private final PagedCallSettings.Builder<
            ListPublisherModelsRequest,
            ListPublisherModelsResponse,
            ListPublisherModelsPagedResponse>
        listPublisherModelsSettings;
    private final UnaryCallSettings.Builder<DeployRequest, Operation> deploySettings;
    private final OperationCallSettings.Builder<
            DeployRequest, DeployResponse, DeployOperationMetadata>
        deployOperationSettings;
    private final UnaryCallSettings.Builder<DeployPublisherModelRequest, Operation>
        deployPublisherModelSettings;
    private final OperationCallSettings.Builder<
            DeployPublisherModelRequest,
            DeployPublisherModelResponse,
            DeployPublisherModelOperationMetadata>
        deployPublisherModelOperationSettings;
    private final UnaryCallSettings.Builder<ExportPublisherModelRequest, Operation>
        exportPublisherModelSettings;
    private final OperationCallSettings.Builder<
            ExportPublisherModelRequest,
            ExportPublisherModelResponse,
            ExportPublisherModelOperationMetadata>
        exportPublisherModelOperationSettings;
    private final UnaryCallSettings.Builder<
            CheckPublisherModelEulaAcceptanceRequest, PublisherModelEulaAcceptance>
        checkPublisherModelEulaAcceptanceSettings;
    private final UnaryCallSettings.Builder<
            AcceptPublisherModelEulaRequest, PublisherModelEulaAcceptance>
        acceptPublisherModelEulaSettings;
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

      getPublisherModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPublisherModelsSettings =
          PagedCallSettings.newBuilder(LIST_PUBLISHER_MODELS_PAGE_STR_FACT);
      deploySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deployOperationSettings = OperationCallSettings.newBuilder();
      deployPublisherModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deployPublisherModelOperationSettings = OperationCallSettings.newBuilder();
      exportPublisherModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportPublisherModelOperationSettings = OperationCallSettings.newBuilder();
      checkPublisherModelEulaAcceptanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      acceptPublisherModelEulaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getPublisherModelSettings,
              listPublisherModelsSettings,
              deploySettings,
              deployPublisherModelSettings,
              exportPublisherModelSettings,
              checkPublisherModelEulaAcceptanceSettings,
              acceptPublisherModelEulaSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(ModelGardenServiceStubSettings settings) {
      super(settings);

      getPublisherModelSettings = settings.getPublisherModelSettings.toBuilder();
      listPublisherModelsSettings = settings.listPublisherModelsSettings.toBuilder();
      deploySettings = settings.deploySettings.toBuilder();
      deployOperationSettings = settings.deployOperationSettings.toBuilder();
      deployPublisherModelSettings = settings.deployPublisherModelSettings.toBuilder();
      deployPublisherModelOperationSettings =
          settings.deployPublisherModelOperationSettings.toBuilder();
      exportPublisherModelSettings = settings.exportPublisherModelSettings.toBuilder();
      exportPublisherModelOperationSettings =
          settings.exportPublisherModelOperationSettings.toBuilder();
      checkPublisherModelEulaAcceptanceSettings =
          settings.checkPublisherModelEulaAcceptanceSettings.toBuilder();
      acceptPublisherModelEulaSettings = settings.acceptPublisherModelEulaSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getPublisherModelSettings,
              listPublisherModelsSettings,
              deploySettings,
              deployPublisherModelSettings,
              exportPublisherModelSettings,
              checkPublisherModelEulaAcceptanceSettings,
              acceptPublisherModelEulaSettings,
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
          .getPublisherModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listPublisherModelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deploySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deployPublisherModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .exportPublisherModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .checkPublisherModelEulaAcceptanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .acceptPublisherModelEulaSettings()
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
          .deployOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeployRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DeployResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeployOperationMetadata.class))
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
          .deployPublisherModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeployPublisherModelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  DeployPublisherModelResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  DeployPublisherModelOperationMetadata.class))
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
          .exportPublisherModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportPublisherModelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ExportPublisherModelResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ExportPublisherModelOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to getPublisherModel. */
    public UnaryCallSettings.Builder<GetPublisherModelRequest, PublisherModel>
        getPublisherModelSettings() {
      return getPublisherModelSettings;
    }

    /** Returns the builder for the settings used for calls to listPublisherModels. */
    public PagedCallSettings.Builder<
            ListPublisherModelsRequest,
            ListPublisherModelsResponse,
            ListPublisherModelsPagedResponse>
        listPublisherModelsSettings() {
      return listPublisherModelsSettings;
    }

    /** Returns the builder for the settings used for calls to deploy. */
    public UnaryCallSettings.Builder<DeployRequest, Operation> deploySettings() {
      return deploySettings;
    }

    /** Returns the builder for the settings used for calls to deploy. */
    public OperationCallSettings.Builder<DeployRequest, DeployResponse, DeployOperationMetadata>
        deployOperationSettings() {
      return deployOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to deployPublisherModel.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<DeployPublisherModelRequest, Operation>
        deployPublisherModelSettings() {
      return deployPublisherModelSettings;
    }

    /** Returns the builder for the settings used for calls to deployPublisherModel. */
    public OperationCallSettings.Builder<
            DeployPublisherModelRequest,
            DeployPublisherModelResponse,
            DeployPublisherModelOperationMetadata>
        deployPublisherModelOperationSettings() {
      return deployPublisherModelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportPublisherModel. */
    public UnaryCallSettings.Builder<ExportPublisherModelRequest, Operation>
        exportPublisherModelSettings() {
      return exportPublisherModelSettings;
    }

    /** Returns the builder for the settings used for calls to exportPublisherModel. */
    public OperationCallSettings.Builder<
            ExportPublisherModelRequest,
            ExportPublisherModelResponse,
            ExportPublisherModelOperationMetadata>
        exportPublisherModelOperationSettings() {
      return exportPublisherModelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to checkPublisherModelEulaAcceptance. */
    public UnaryCallSettings.Builder<
            CheckPublisherModelEulaAcceptanceRequest, PublisherModelEulaAcceptance>
        checkPublisherModelEulaAcceptanceSettings() {
      return checkPublisherModelEulaAcceptanceSettings;
    }

    /** Returns the builder for the settings used for calls to acceptPublisherModelEula. */
    public UnaryCallSettings.Builder<AcceptPublisherModelEulaRequest, PublisherModelEulaAcceptance>
        acceptPublisherModelEulaSettings() {
      return acceptPublisherModelEulaSettings;
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
    public ModelGardenServiceStubSettings build() throws IOException {
      return new ModelGardenServiceStubSettings(this);
    }
  }
}
