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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.OnlineEvaluatorServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.OnlineEvaluatorServiceClient.ListOnlineEvaluatorsPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.ActivateOnlineEvaluatorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ActivateOnlineEvaluatorRequest;
import com.google.cloud.aiplatform.v1beta1.CreateOnlineEvaluatorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateOnlineEvaluatorRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOnlineEvaluatorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteOnlineEvaluatorRequest;
import com.google.cloud.aiplatform.v1beta1.GetOnlineEvaluatorRequest;
import com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsRequest;
import com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsResponse;
import com.google.cloud.aiplatform.v1beta1.OnlineEvaluator;
import com.google.cloud.aiplatform.v1beta1.SuspendOnlineEvaluatorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.SuspendOnlineEvaluatorRequest;
import com.google.cloud.aiplatform.v1beta1.UpdateOnlineEvaluatorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateOnlineEvaluatorRequest;
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
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link OnlineEvaluatorServiceStub}.
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
 * of getOnlineEvaluator:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OnlineEvaluatorServiceStubSettings.Builder onlineEvaluatorServiceSettingsBuilder =
 *     OnlineEvaluatorServiceStubSettings.newBuilder();
 * onlineEvaluatorServiceSettingsBuilder
 *     .getOnlineEvaluatorSettings()
 *     .setRetrySettings(
 *         onlineEvaluatorServiceSettingsBuilder
 *             .getOnlineEvaluatorSettings()
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
 * OnlineEvaluatorServiceStubSettings onlineEvaluatorServiceSettings =
 *     onlineEvaluatorServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createOnlineEvaluator:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OnlineEvaluatorServiceStubSettings.Builder onlineEvaluatorServiceSettingsBuilder =
 *     OnlineEvaluatorServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * onlineEvaluatorServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class OnlineEvaluatorServiceStubSettings
    extends StubSettings<OnlineEvaluatorServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateOnlineEvaluatorRequest, Operation>
      createOnlineEvaluatorSettings;
  private final OperationCallSettings<
          CreateOnlineEvaluatorRequest, OnlineEvaluator, CreateOnlineEvaluatorOperationMetadata>
      createOnlineEvaluatorOperationSettings;
  private final UnaryCallSettings<GetOnlineEvaluatorRequest, OnlineEvaluator>
      getOnlineEvaluatorSettings;
  private final UnaryCallSettings<UpdateOnlineEvaluatorRequest, Operation>
      updateOnlineEvaluatorSettings;
  private final OperationCallSettings<
          UpdateOnlineEvaluatorRequest, OnlineEvaluator, UpdateOnlineEvaluatorOperationMetadata>
      updateOnlineEvaluatorOperationSettings;
  private final UnaryCallSettings<DeleteOnlineEvaluatorRequest, Operation>
      deleteOnlineEvaluatorSettings;
  private final OperationCallSettings<
          DeleteOnlineEvaluatorRequest, Empty, DeleteOnlineEvaluatorOperationMetadata>
      deleteOnlineEvaluatorOperationSettings;
  private final PagedCallSettings<
          ListOnlineEvaluatorsRequest,
          ListOnlineEvaluatorsResponse,
          ListOnlineEvaluatorsPagedResponse>
      listOnlineEvaluatorsSettings;
  private final UnaryCallSettings<ActivateOnlineEvaluatorRequest, Operation>
      activateOnlineEvaluatorSettings;
  private final OperationCallSettings<
          ActivateOnlineEvaluatorRequest, OnlineEvaluator, ActivateOnlineEvaluatorOperationMetadata>
      activateOnlineEvaluatorOperationSettings;
  private final UnaryCallSettings<SuspendOnlineEvaluatorRequest, Operation>
      suspendOnlineEvaluatorSettings;
  private final OperationCallSettings<
          SuspendOnlineEvaluatorRequest, OnlineEvaluator, SuspendOnlineEvaluatorOperationMetadata>
      suspendOnlineEvaluatorOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListOnlineEvaluatorsRequest, ListOnlineEvaluatorsResponse, OnlineEvaluator>
      LIST_ONLINE_EVALUATORS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListOnlineEvaluatorsRequest, ListOnlineEvaluatorsResponse, OnlineEvaluator>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListOnlineEvaluatorsRequest injectToken(
                ListOnlineEvaluatorsRequest payload, String token) {
              return ListOnlineEvaluatorsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListOnlineEvaluatorsRequest injectPageSize(
                ListOnlineEvaluatorsRequest payload, int pageSize) {
              return ListOnlineEvaluatorsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListOnlineEvaluatorsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListOnlineEvaluatorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<OnlineEvaluator> extractResources(
                ListOnlineEvaluatorsResponse payload) {
              return payload.getOnlineEvaluatorsList();
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
          ListOnlineEvaluatorsRequest,
          ListOnlineEvaluatorsResponse,
          ListOnlineEvaluatorsPagedResponse>
      LIST_ONLINE_EVALUATORS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListOnlineEvaluatorsRequest,
              ListOnlineEvaluatorsResponse,
              ListOnlineEvaluatorsPagedResponse>() {
            @Override
            public ApiFuture<ListOnlineEvaluatorsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListOnlineEvaluatorsRequest, ListOnlineEvaluatorsResponse> callable,
                ListOnlineEvaluatorsRequest request,
                ApiCallContext context,
                ApiFuture<ListOnlineEvaluatorsResponse> futureResponse) {
              PageContext<
                      ListOnlineEvaluatorsRequest, ListOnlineEvaluatorsResponse, OnlineEvaluator>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ONLINE_EVALUATORS_PAGE_STR_DESC, request, context);
              return ListOnlineEvaluatorsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createOnlineEvaluator. */
  public UnaryCallSettings<CreateOnlineEvaluatorRequest, Operation>
      createOnlineEvaluatorSettings() {
    return createOnlineEvaluatorSettings;
  }

  /** Returns the object with the settings used for calls to createOnlineEvaluator. */
  public OperationCallSettings<
          CreateOnlineEvaluatorRequest, OnlineEvaluator, CreateOnlineEvaluatorOperationMetadata>
      createOnlineEvaluatorOperationSettings() {
    return createOnlineEvaluatorOperationSettings;
  }

  /** Returns the object with the settings used for calls to getOnlineEvaluator. */
  public UnaryCallSettings<GetOnlineEvaluatorRequest, OnlineEvaluator>
      getOnlineEvaluatorSettings() {
    return getOnlineEvaluatorSettings;
  }

  /** Returns the object with the settings used for calls to updateOnlineEvaluator. */
  public UnaryCallSettings<UpdateOnlineEvaluatorRequest, Operation>
      updateOnlineEvaluatorSettings() {
    return updateOnlineEvaluatorSettings;
  }

  /** Returns the object with the settings used for calls to updateOnlineEvaluator. */
  public OperationCallSettings<
          UpdateOnlineEvaluatorRequest, OnlineEvaluator, UpdateOnlineEvaluatorOperationMetadata>
      updateOnlineEvaluatorOperationSettings() {
    return updateOnlineEvaluatorOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteOnlineEvaluator. */
  public UnaryCallSettings<DeleteOnlineEvaluatorRequest, Operation>
      deleteOnlineEvaluatorSettings() {
    return deleteOnlineEvaluatorSettings;
  }

  /** Returns the object with the settings used for calls to deleteOnlineEvaluator. */
  public OperationCallSettings<
          DeleteOnlineEvaluatorRequest, Empty, DeleteOnlineEvaluatorOperationMetadata>
      deleteOnlineEvaluatorOperationSettings() {
    return deleteOnlineEvaluatorOperationSettings;
  }

  /** Returns the object with the settings used for calls to listOnlineEvaluators. */
  public PagedCallSettings<
          ListOnlineEvaluatorsRequest,
          ListOnlineEvaluatorsResponse,
          ListOnlineEvaluatorsPagedResponse>
      listOnlineEvaluatorsSettings() {
    return listOnlineEvaluatorsSettings;
  }

  /** Returns the object with the settings used for calls to activateOnlineEvaluator. */
  public UnaryCallSettings<ActivateOnlineEvaluatorRequest, Operation>
      activateOnlineEvaluatorSettings() {
    return activateOnlineEvaluatorSettings;
  }

  /** Returns the object with the settings used for calls to activateOnlineEvaluator. */
  public OperationCallSettings<
          ActivateOnlineEvaluatorRequest, OnlineEvaluator, ActivateOnlineEvaluatorOperationMetadata>
      activateOnlineEvaluatorOperationSettings() {
    return activateOnlineEvaluatorOperationSettings;
  }

  /** Returns the object with the settings used for calls to suspendOnlineEvaluator. */
  public UnaryCallSettings<SuspendOnlineEvaluatorRequest, Operation>
      suspendOnlineEvaluatorSettings() {
    return suspendOnlineEvaluatorSettings;
  }

  /** Returns the object with the settings used for calls to suspendOnlineEvaluator. */
  public OperationCallSettings<
          SuspendOnlineEvaluatorRequest, OnlineEvaluator, SuspendOnlineEvaluatorOperationMetadata>
      suspendOnlineEvaluatorOperationSettings() {
    return suspendOnlineEvaluatorOperationSettings;
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

  public OnlineEvaluatorServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcOnlineEvaluatorServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(OnlineEvaluatorServiceStubSettings.class))
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

  protected OnlineEvaluatorServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createOnlineEvaluatorSettings = settingsBuilder.createOnlineEvaluatorSettings().build();
    createOnlineEvaluatorOperationSettings =
        settingsBuilder.createOnlineEvaluatorOperationSettings().build();
    getOnlineEvaluatorSettings = settingsBuilder.getOnlineEvaluatorSettings().build();
    updateOnlineEvaluatorSettings = settingsBuilder.updateOnlineEvaluatorSettings().build();
    updateOnlineEvaluatorOperationSettings =
        settingsBuilder.updateOnlineEvaluatorOperationSettings().build();
    deleteOnlineEvaluatorSettings = settingsBuilder.deleteOnlineEvaluatorSettings().build();
    deleteOnlineEvaluatorOperationSettings =
        settingsBuilder.deleteOnlineEvaluatorOperationSettings().build();
    listOnlineEvaluatorsSettings = settingsBuilder.listOnlineEvaluatorsSettings().build();
    activateOnlineEvaluatorSettings = settingsBuilder.activateOnlineEvaluatorSettings().build();
    activateOnlineEvaluatorOperationSettings =
        settingsBuilder.activateOnlineEvaluatorOperationSettings().build();
    suspendOnlineEvaluatorSettings = settingsBuilder.suspendOnlineEvaluatorSettings().build();
    suspendOnlineEvaluatorOperationSettings =
        settingsBuilder.suspendOnlineEvaluatorOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-aiplatform")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for OnlineEvaluatorServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<OnlineEvaluatorServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateOnlineEvaluatorRequest, Operation>
        createOnlineEvaluatorSettings;
    private final OperationCallSettings.Builder<
            CreateOnlineEvaluatorRequest, OnlineEvaluator, CreateOnlineEvaluatorOperationMetadata>
        createOnlineEvaluatorOperationSettings;
    private final UnaryCallSettings.Builder<GetOnlineEvaluatorRequest, OnlineEvaluator>
        getOnlineEvaluatorSettings;
    private final UnaryCallSettings.Builder<UpdateOnlineEvaluatorRequest, Operation>
        updateOnlineEvaluatorSettings;
    private final OperationCallSettings.Builder<
            UpdateOnlineEvaluatorRequest, OnlineEvaluator, UpdateOnlineEvaluatorOperationMetadata>
        updateOnlineEvaluatorOperationSettings;
    private final UnaryCallSettings.Builder<DeleteOnlineEvaluatorRequest, Operation>
        deleteOnlineEvaluatorSettings;
    private final OperationCallSettings.Builder<
            DeleteOnlineEvaluatorRequest, Empty, DeleteOnlineEvaluatorOperationMetadata>
        deleteOnlineEvaluatorOperationSettings;
    private final PagedCallSettings.Builder<
            ListOnlineEvaluatorsRequest,
            ListOnlineEvaluatorsResponse,
            ListOnlineEvaluatorsPagedResponse>
        listOnlineEvaluatorsSettings;
    private final UnaryCallSettings.Builder<ActivateOnlineEvaluatorRequest, Operation>
        activateOnlineEvaluatorSettings;
    private final OperationCallSettings.Builder<
            ActivateOnlineEvaluatorRequest,
            OnlineEvaluator,
            ActivateOnlineEvaluatorOperationMetadata>
        activateOnlineEvaluatorOperationSettings;
    private final UnaryCallSettings.Builder<SuspendOnlineEvaluatorRequest, Operation>
        suspendOnlineEvaluatorSettings;
    private final OperationCallSettings.Builder<
            SuspendOnlineEvaluatorRequest, OnlineEvaluator, SuspendOnlineEvaluatorOperationMetadata>
        suspendOnlineEvaluatorOperationSettings;
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

      createOnlineEvaluatorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createOnlineEvaluatorOperationSettings = OperationCallSettings.newBuilder();
      getOnlineEvaluatorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateOnlineEvaluatorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateOnlineEvaluatorOperationSettings = OperationCallSettings.newBuilder();
      deleteOnlineEvaluatorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOnlineEvaluatorOperationSettings = OperationCallSettings.newBuilder();
      listOnlineEvaluatorsSettings =
          PagedCallSettings.newBuilder(LIST_ONLINE_EVALUATORS_PAGE_STR_FACT);
      activateOnlineEvaluatorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      activateOnlineEvaluatorOperationSettings = OperationCallSettings.newBuilder();
      suspendOnlineEvaluatorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      suspendOnlineEvaluatorOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createOnlineEvaluatorSettings,
              getOnlineEvaluatorSettings,
              updateOnlineEvaluatorSettings,
              deleteOnlineEvaluatorSettings,
              listOnlineEvaluatorsSettings,
              activateOnlineEvaluatorSettings,
              suspendOnlineEvaluatorSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(OnlineEvaluatorServiceStubSettings settings) {
      super(settings);

      createOnlineEvaluatorSettings = settings.createOnlineEvaluatorSettings.toBuilder();
      createOnlineEvaluatorOperationSettings =
          settings.createOnlineEvaluatorOperationSettings.toBuilder();
      getOnlineEvaluatorSettings = settings.getOnlineEvaluatorSettings.toBuilder();
      updateOnlineEvaluatorSettings = settings.updateOnlineEvaluatorSettings.toBuilder();
      updateOnlineEvaluatorOperationSettings =
          settings.updateOnlineEvaluatorOperationSettings.toBuilder();
      deleteOnlineEvaluatorSettings = settings.deleteOnlineEvaluatorSettings.toBuilder();
      deleteOnlineEvaluatorOperationSettings =
          settings.deleteOnlineEvaluatorOperationSettings.toBuilder();
      listOnlineEvaluatorsSettings = settings.listOnlineEvaluatorsSettings.toBuilder();
      activateOnlineEvaluatorSettings = settings.activateOnlineEvaluatorSettings.toBuilder();
      activateOnlineEvaluatorOperationSettings =
          settings.activateOnlineEvaluatorOperationSettings.toBuilder();
      suspendOnlineEvaluatorSettings = settings.suspendOnlineEvaluatorSettings.toBuilder();
      suspendOnlineEvaluatorOperationSettings =
          settings.suspendOnlineEvaluatorOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createOnlineEvaluatorSettings,
              getOnlineEvaluatorSettings,
              updateOnlineEvaluatorSettings,
              deleteOnlineEvaluatorSettings,
              listOnlineEvaluatorsSettings,
              activateOnlineEvaluatorSettings,
              suspendOnlineEvaluatorSettings,
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
          .createOnlineEvaluatorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getOnlineEvaluatorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateOnlineEvaluatorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteOnlineEvaluatorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listOnlineEvaluatorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .activateOnlineEvaluatorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .suspendOnlineEvaluatorSettings()
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
          .createOnlineEvaluatorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateOnlineEvaluatorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(OnlineEvaluator.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateOnlineEvaluatorOperationMetadata.class))
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
          .updateOnlineEvaluatorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateOnlineEvaluatorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(OnlineEvaluator.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdateOnlineEvaluatorOperationMetadata.class))
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
          .deleteOnlineEvaluatorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteOnlineEvaluatorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  DeleteOnlineEvaluatorOperationMetadata.class))
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
          .activateOnlineEvaluatorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ActivateOnlineEvaluatorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(OnlineEvaluator.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ActivateOnlineEvaluatorOperationMetadata.class))
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
          .suspendOnlineEvaluatorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SuspendOnlineEvaluatorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(OnlineEvaluator.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  SuspendOnlineEvaluatorOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to createOnlineEvaluator. */
    public UnaryCallSettings.Builder<CreateOnlineEvaluatorRequest, Operation>
        createOnlineEvaluatorSettings() {
      return createOnlineEvaluatorSettings;
    }

    /** Returns the builder for the settings used for calls to createOnlineEvaluator. */
    public OperationCallSettings.Builder<
            CreateOnlineEvaluatorRequest, OnlineEvaluator, CreateOnlineEvaluatorOperationMetadata>
        createOnlineEvaluatorOperationSettings() {
      return createOnlineEvaluatorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getOnlineEvaluator. */
    public UnaryCallSettings.Builder<GetOnlineEvaluatorRequest, OnlineEvaluator>
        getOnlineEvaluatorSettings() {
      return getOnlineEvaluatorSettings;
    }

    /** Returns the builder for the settings used for calls to updateOnlineEvaluator. */
    public UnaryCallSettings.Builder<UpdateOnlineEvaluatorRequest, Operation>
        updateOnlineEvaluatorSettings() {
      return updateOnlineEvaluatorSettings;
    }

    /** Returns the builder for the settings used for calls to updateOnlineEvaluator. */
    public OperationCallSettings.Builder<
            UpdateOnlineEvaluatorRequest, OnlineEvaluator, UpdateOnlineEvaluatorOperationMetadata>
        updateOnlineEvaluatorOperationSettings() {
      return updateOnlineEvaluatorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteOnlineEvaluator. */
    public UnaryCallSettings.Builder<DeleteOnlineEvaluatorRequest, Operation>
        deleteOnlineEvaluatorSettings() {
      return deleteOnlineEvaluatorSettings;
    }

    /** Returns the builder for the settings used for calls to deleteOnlineEvaluator. */
    public OperationCallSettings.Builder<
            DeleteOnlineEvaluatorRequest, Empty, DeleteOnlineEvaluatorOperationMetadata>
        deleteOnlineEvaluatorOperationSettings() {
      return deleteOnlineEvaluatorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listOnlineEvaluators. */
    public PagedCallSettings.Builder<
            ListOnlineEvaluatorsRequest,
            ListOnlineEvaluatorsResponse,
            ListOnlineEvaluatorsPagedResponse>
        listOnlineEvaluatorsSettings() {
      return listOnlineEvaluatorsSettings;
    }

    /** Returns the builder for the settings used for calls to activateOnlineEvaluator. */
    public UnaryCallSettings.Builder<ActivateOnlineEvaluatorRequest, Operation>
        activateOnlineEvaluatorSettings() {
      return activateOnlineEvaluatorSettings;
    }

    /** Returns the builder for the settings used for calls to activateOnlineEvaluator. */
    public OperationCallSettings.Builder<
            ActivateOnlineEvaluatorRequest,
            OnlineEvaluator,
            ActivateOnlineEvaluatorOperationMetadata>
        activateOnlineEvaluatorOperationSettings() {
      return activateOnlineEvaluatorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to suspendOnlineEvaluator. */
    public UnaryCallSettings.Builder<SuspendOnlineEvaluatorRequest, Operation>
        suspendOnlineEvaluatorSettings() {
      return suspendOnlineEvaluatorSettings;
    }

    /** Returns the builder for the settings used for calls to suspendOnlineEvaluator. */
    public OperationCallSettings.Builder<
            SuspendOnlineEvaluatorRequest, OnlineEvaluator, SuspendOnlineEvaluatorOperationMetadata>
        suspendOnlineEvaluatorOperationSettings() {
      return suspendOnlineEvaluatorOperationSettings;
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
    public OnlineEvaluatorServiceStubSettings build() throws IOException {
      return new OnlineEvaluatorServiceStubSettings(this);
    }
  }
}
