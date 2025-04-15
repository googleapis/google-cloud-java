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

import static com.google.cloud.aiplatform.v1beta1.ExampleStoreServiceClient.FetchExamplesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ExampleStoreServiceClient.ListExampleStoresPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ExampleStoreServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.CreateExampleStoreOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateExampleStoreRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteExampleStoreOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteExampleStoreRequest;
import com.google.cloud.aiplatform.v1beta1.Example;
import com.google.cloud.aiplatform.v1beta1.ExampleStore;
import com.google.cloud.aiplatform.v1beta1.FetchExamplesRequest;
import com.google.cloud.aiplatform.v1beta1.FetchExamplesResponse;
import com.google.cloud.aiplatform.v1beta1.GetExampleStoreRequest;
import com.google.cloud.aiplatform.v1beta1.ListExampleStoresRequest;
import com.google.cloud.aiplatform.v1beta1.ListExampleStoresResponse;
import com.google.cloud.aiplatform.v1beta1.RemoveExamplesRequest;
import com.google.cloud.aiplatform.v1beta1.RemoveExamplesResponse;
import com.google.cloud.aiplatform.v1beta1.SearchExamplesRequest;
import com.google.cloud.aiplatform.v1beta1.SearchExamplesResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateExampleStoreOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateExampleStoreRequest;
import com.google.cloud.aiplatform.v1beta1.UpsertExamplesRequest;
import com.google.cloud.aiplatform.v1beta1.UpsertExamplesResponse;
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
 * Settings class to configure an instance of {@link ExampleStoreServiceStub}.
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
 * of getExampleStore:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ExampleStoreServiceStubSettings.Builder exampleStoreServiceSettingsBuilder =
 *     ExampleStoreServiceStubSettings.newBuilder();
 * exampleStoreServiceSettingsBuilder
 *     .getExampleStoreSettings()
 *     .setRetrySettings(
 *         exampleStoreServiceSettingsBuilder
 *             .getExampleStoreSettings()
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
 * ExampleStoreServiceStubSettings exampleStoreServiceSettings =
 *     exampleStoreServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createExampleStore:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ExampleStoreServiceStubSettings.Builder exampleStoreServiceSettingsBuilder =
 *     ExampleStoreServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * exampleStoreServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ExampleStoreServiceStubSettings extends StubSettings<ExampleStoreServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateExampleStoreRequest, Operation> createExampleStoreSettings;
  private final OperationCallSettings<
          CreateExampleStoreRequest, ExampleStore, CreateExampleStoreOperationMetadata>
      createExampleStoreOperationSettings;
  private final UnaryCallSettings<GetExampleStoreRequest, ExampleStore> getExampleStoreSettings;
  private final UnaryCallSettings<UpdateExampleStoreRequest, Operation> updateExampleStoreSettings;
  private final OperationCallSettings<
          UpdateExampleStoreRequest, ExampleStore, UpdateExampleStoreOperationMetadata>
      updateExampleStoreOperationSettings;
  private final UnaryCallSettings<DeleteExampleStoreRequest, Operation> deleteExampleStoreSettings;
  private final OperationCallSettings<
          DeleteExampleStoreRequest, Empty, DeleteExampleStoreOperationMetadata>
      deleteExampleStoreOperationSettings;
  private final PagedCallSettings<
          ListExampleStoresRequest, ListExampleStoresResponse, ListExampleStoresPagedResponse>
      listExampleStoresSettings;
  private final UnaryCallSettings<UpsertExamplesRequest, UpsertExamplesResponse>
      upsertExamplesSettings;
  private final UnaryCallSettings<RemoveExamplesRequest, RemoveExamplesResponse>
      removeExamplesSettings;
  private final UnaryCallSettings<SearchExamplesRequest, SearchExamplesResponse>
      searchExamplesSettings;
  private final PagedCallSettings<
          FetchExamplesRequest, FetchExamplesResponse, FetchExamplesPagedResponse>
      fetchExamplesSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListExampleStoresRequest, ListExampleStoresResponse, ExampleStore>
      LIST_EXAMPLE_STORES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListExampleStoresRequest, ListExampleStoresResponse, ExampleStore>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListExampleStoresRequest injectToken(
                ListExampleStoresRequest payload, String token) {
              return ListExampleStoresRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListExampleStoresRequest injectPageSize(
                ListExampleStoresRequest payload, int pageSize) {
              return ListExampleStoresRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListExampleStoresRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListExampleStoresResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ExampleStore> extractResources(ListExampleStoresResponse payload) {
              return payload.getExampleStoresList();
            }
          };

  private static final PagedListDescriptor<FetchExamplesRequest, FetchExamplesResponse, Example>
      FETCH_EXAMPLES_PAGE_STR_DESC =
          new PagedListDescriptor<FetchExamplesRequest, FetchExamplesResponse, Example>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchExamplesRequest injectToken(FetchExamplesRequest payload, String token) {
              return FetchExamplesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public FetchExamplesRequest injectPageSize(FetchExamplesRequest payload, int pageSize) {
              return FetchExamplesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(FetchExamplesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchExamplesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Example> extractResources(FetchExamplesResponse payload) {
              return payload.getExamplesList();
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
          ListExampleStoresRequest, ListExampleStoresResponse, ListExampleStoresPagedResponse>
      LIST_EXAMPLE_STORES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListExampleStoresRequest,
              ListExampleStoresResponse,
              ListExampleStoresPagedResponse>() {
            @Override
            public ApiFuture<ListExampleStoresPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListExampleStoresRequest, ListExampleStoresResponse> callable,
                ListExampleStoresRequest request,
                ApiCallContext context,
                ApiFuture<ListExampleStoresResponse> futureResponse) {
              PageContext<ListExampleStoresRequest, ListExampleStoresResponse, ExampleStore>
                  pageContext =
                      PageContext.create(
                          callable, LIST_EXAMPLE_STORES_PAGE_STR_DESC, request, context);
              return ListExampleStoresPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          FetchExamplesRequest, FetchExamplesResponse, FetchExamplesPagedResponse>
      FETCH_EXAMPLES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchExamplesRequest, FetchExamplesResponse, FetchExamplesPagedResponse>() {
            @Override
            public ApiFuture<FetchExamplesPagedResponse> getFuturePagedResponse(
                UnaryCallable<FetchExamplesRequest, FetchExamplesResponse> callable,
                FetchExamplesRequest request,
                ApiCallContext context,
                ApiFuture<FetchExamplesResponse> futureResponse) {
              PageContext<FetchExamplesRequest, FetchExamplesResponse, Example> pageContext =
                  PageContext.create(callable, FETCH_EXAMPLES_PAGE_STR_DESC, request, context);
              return FetchExamplesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createExampleStore. */
  public UnaryCallSettings<CreateExampleStoreRequest, Operation> createExampleStoreSettings() {
    return createExampleStoreSettings;
  }

  /** Returns the object with the settings used for calls to createExampleStore. */
  public OperationCallSettings<
          CreateExampleStoreRequest, ExampleStore, CreateExampleStoreOperationMetadata>
      createExampleStoreOperationSettings() {
    return createExampleStoreOperationSettings;
  }

  /** Returns the object with the settings used for calls to getExampleStore. */
  public UnaryCallSettings<GetExampleStoreRequest, ExampleStore> getExampleStoreSettings() {
    return getExampleStoreSettings;
  }

  /** Returns the object with the settings used for calls to updateExampleStore. */
  public UnaryCallSettings<UpdateExampleStoreRequest, Operation> updateExampleStoreSettings() {
    return updateExampleStoreSettings;
  }

  /** Returns the object with the settings used for calls to updateExampleStore. */
  public OperationCallSettings<
          UpdateExampleStoreRequest, ExampleStore, UpdateExampleStoreOperationMetadata>
      updateExampleStoreOperationSettings() {
    return updateExampleStoreOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteExampleStore. */
  public UnaryCallSettings<DeleteExampleStoreRequest, Operation> deleteExampleStoreSettings() {
    return deleteExampleStoreSettings;
  }

  /** Returns the object with the settings used for calls to deleteExampleStore. */
  public OperationCallSettings<
          DeleteExampleStoreRequest, Empty, DeleteExampleStoreOperationMetadata>
      deleteExampleStoreOperationSettings() {
    return deleteExampleStoreOperationSettings;
  }

  /** Returns the object with the settings used for calls to listExampleStores. */
  public PagedCallSettings<
          ListExampleStoresRequest, ListExampleStoresResponse, ListExampleStoresPagedResponse>
      listExampleStoresSettings() {
    return listExampleStoresSettings;
  }

  /** Returns the object with the settings used for calls to upsertExamples. */
  public UnaryCallSettings<UpsertExamplesRequest, UpsertExamplesResponse> upsertExamplesSettings() {
    return upsertExamplesSettings;
  }

  /** Returns the object with the settings used for calls to removeExamples. */
  public UnaryCallSettings<RemoveExamplesRequest, RemoveExamplesResponse> removeExamplesSettings() {
    return removeExamplesSettings;
  }

  /** Returns the object with the settings used for calls to searchExamples. */
  public UnaryCallSettings<SearchExamplesRequest, SearchExamplesResponse> searchExamplesSettings() {
    return searchExamplesSettings;
  }

  /** Returns the object with the settings used for calls to fetchExamples. */
  public PagedCallSettings<FetchExamplesRequest, FetchExamplesResponse, FetchExamplesPagedResponse>
      fetchExamplesSettings() {
    return fetchExamplesSettings;
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

  public ExampleStoreServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcExampleStoreServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(ExampleStoreServiceStubSettings.class))
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

  protected ExampleStoreServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createExampleStoreSettings = settingsBuilder.createExampleStoreSettings().build();
    createExampleStoreOperationSettings =
        settingsBuilder.createExampleStoreOperationSettings().build();
    getExampleStoreSettings = settingsBuilder.getExampleStoreSettings().build();
    updateExampleStoreSettings = settingsBuilder.updateExampleStoreSettings().build();
    updateExampleStoreOperationSettings =
        settingsBuilder.updateExampleStoreOperationSettings().build();
    deleteExampleStoreSettings = settingsBuilder.deleteExampleStoreSettings().build();
    deleteExampleStoreOperationSettings =
        settingsBuilder.deleteExampleStoreOperationSettings().build();
    listExampleStoresSettings = settingsBuilder.listExampleStoresSettings().build();
    upsertExamplesSettings = settingsBuilder.upsertExamplesSettings().build();
    removeExamplesSettings = settingsBuilder.removeExamplesSettings().build();
    searchExamplesSettings = settingsBuilder.searchExamplesSettings().build();
    fetchExamplesSettings = settingsBuilder.fetchExamplesSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for ExampleStoreServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ExampleStoreServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateExampleStoreRequest, Operation>
        createExampleStoreSettings;
    private final OperationCallSettings.Builder<
            CreateExampleStoreRequest, ExampleStore, CreateExampleStoreOperationMetadata>
        createExampleStoreOperationSettings;
    private final UnaryCallSettings.Builder<GetExampleStoreRequest, ExampleStore>
        getExampleStoreSettings;
    private final UnaryCallSettings.Builder<UpdateExampleStoreRequest, Operation>
        updateExampleStoreSettings;
    private final OperationCallSettings.Builder<
            UpdateExampleStoreRequest, ExampleStore, UpdateExampleStoreOperationMetadata>
        updateExampleStoreOperationSettings;
    private final UnaryCallSettings.Builder<DeleteExampleStoreRequest, Operation>
        deleteExampleStoreSettings;
    private final OperationCallSettings.Builder<
            DeleteExampleStoreRequest, Empty, DeleteExampleStoreOperationMetadata>
        deleteExampleStoreOperationSettings;
    private final PagedCallSettings.Builder<
            ListExampleStoresRequest, ListExampleStoresResponse, ListExampleStoresPagedResponse>
        listExampleStoresSettings;
    private final UnaryCallSettings.Builder<UpsertExamplesRequest, UpsertExamplesResponse>
        upsertExamplesSettings;
    private final UnaryCallSettings.Builder<RemoveExamplesRequest, RemoveExamplesResponse>
        removeExamplesSettings;
    private final UnaryCallSettings.Builder<SearchExamplesRequest, SearchExamplesResponse>
        searchExamplesSettings;
    private final PagedCallSettings.Builder<
            FetchExamplesRequest, FetchExamplesResponse, FetchExamplesPagedResponse>
        fetchExamplesSettings;
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

      createExampleStoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createExampleStoreOperationSettings = OperationCallSettings.newBuilder();
      getExampleStoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateExampleStoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateExampleStoreOperationSettings = OperationCallSettings.newBuilder();
      deleteExampleStoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteExampleStoreOperationSettings = OperationCallSettings.newBuilder();
      listExampleStoresSettings = PagedCallSettings.newBuilder(LIST_EXAMPLE_STORES_PAGE_STR_FACT);
      upsertExamplesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeExamplesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      searchExamplesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      fetchExamplesSettings = PagedCallSettings.newBuilder(FETCH_EXAMPLES_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createExampleStoreSettings,
              getExampleStoreSettings,
              updateExampleStoreSettings,
              deleteExampleStoreSettings,
              listExampleStoresSettings,
              upsertExamplesSettings,
              removeExamplesSettings,
              searchExamplesSettings,
              fetchExamplesSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(ExampleStoreServiceStubSettings settings) {
      super(settings);

      createExampleStoreSettings = settings.createExampleStoreSettings.toBuilder();
      createExampleStoreOperationSettings =
          settings.createExampleStoreOperationSettings.toBuilder();
      getExampleStoreSettings = settings.getExampleStoreSettings.toBuilder();
      updateExampleStoreSettings = settings.updateExampleStoreSettings.toBuilder();
      updateExampleStoreOperationSettings =
          settings.updateExampleStoreOperationSettings.toBuilder();
      deleteExampleStoreSettings = settings.deleteExampleStoreSettings.toBuilder();
      deleteExampleStoreOperationSettings =
          settings.deleteExampleStoreOperationSettings.toBuilder();
      listExampleStoresSettings = settings.listExampleStoresSettings.toBuilder();
      upsertExamplesSettings = settings.upsertExamplesSettings.toBuilder();
      removeExamplesSettings = settings.removeExamplesSettings.toBuilder();
      searchExamplesSettings = settings.searchExamplesSettings.toBuilder();
      fetchExamplesSettings = settings.fetchExamplesSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createExampleStoreSettings,
              getExampleStoreSettings,
              updateExampleStoreSettings,
              deleteExampleStoreSettings,
              listExampleStoresSettings,
              upsertExamplesSettings,
              removeExamplesSettings,
              searchExamplesSettings,
              fetchExamplesSettings,
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
          .createExampleStoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getExampleStoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateExampleStoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteExampleStoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listExampleStoresSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .upsertExamplesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .removeExamplesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .searchExamplesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .fetchExamplesSettings()
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
          .createExampleStoreOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateExampleStoreRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExampleStore.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateExampleStoreOperationMetadata.class))
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
          .updateExampleStoreOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateExampleStoreRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExampleStore.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdateExampleStoreOperationMetadata.class))
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
          .deleteExampleStoreOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteExampleStoreRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  DeleteExampleStoreOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to createExampleStore. */
    public UnaryCallSettings.Builder<CreateExampleStoreRequest, Operation>
        createExampleStoreSettings() {
      return createExampleStoreSettings;
    }

    /** Returns the builder for the settings used for calls to createExampleStore. */
    public OperationCallSettings.Builder<
            CreateExampleStoreRequest, ExampleStore, CreateExampleStoreOperationMetadata>
        createExampleStoreOperationSettings() {
      return createExampleStoreOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getExampleStore. */
    public UnaryCallSettings.Builder<GetExampleStoreRequest, ExampleStore>
        getExampleStoreSettings() {
      return getExampleStoreSettings;
    }

    /** Returns the builder for the settings used for calls to updateExampleStore. */
    public UnaryCallSettings.Builder<UpdateExampleStoreRequest, Operation>
        updateExampleStoreSettings() {
      return updateExampleStoreSettings;
    }

    /** Returns the builder for the settings used for calls to updateExampleStore. */
    public OperationCallSettings.Builder<
            UpdateExampleStoreRequest, ExampleStore, UpdateExampleStoreOperationMetadata>
        updateExampleStoreOperationSettings() {
      return updateExampleStoreOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExampleStore. */
    public UnaryCallSettings.Builder<DeleteExampleStoreRequest, Operation>
        deleteExampleStoreSettings() {
      return deleteExampleStoreSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExampleStore. */
    public OperationCallSettings.Builder<
            DeleteExampleStoreRequest, Empty, DeleteExampleStoreOperationMetadata>
        deleteExampleStoreOperationSettings() {
      return deleteExampleStoreOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listExampleStores. */
    public PagedCallSettings.Builder<
            ListExampleStoresRequest, ListExampleStoresResponse, ListExampleStoresPagedResponse>
        listExampleStoresSettings() {
      return listExampleStoresSettings;
    }

    /** Returns the builder for the settings used for calls to upsertExamples. */
    public UnaryCallSettings.Builder<UpsertExamplesRequest, UpsertExamplesResponse>
        upsertExamplesSettings() {
      return upsertExamplesSettings;
    }

    /** Returns the builder for the settings used for calls to removeExamples. */
    public UnaryCallSettings.Builder<RemoveExamplesRequest, RemoveExamplesResponse>
        removeExamplesSettings() {
      return removeExamplesSettings;
    }

    /** Returns the builder for the settings used for calls to searchExamples. */
    public UnaryCallSettings.Builder<SearchExamplesRequest, SearchExamplesResponse>
        searchExamplesSettings() {
      return searchExamplesSettings;
    }

    /** Returns the builder for the settings used for calls to fetchExamples. */
    public PagedCallSettings.Builder<
            FetchExamplesRequest, FetchExamplesResponse, FetchExamplesPagedResponse>
        fetchExamplesSettings() {
      return fetchExamplesSettings;
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
    public ExampleStoreServiceStubSettings build() throws IOException {
      return new ExampleStoreServiceStubSettings(this);
    }
  }
}
