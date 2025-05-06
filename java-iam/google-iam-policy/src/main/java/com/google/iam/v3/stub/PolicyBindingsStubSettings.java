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

package com.google.iam.v3.stub;

import static com.google.iam.v3.PolicyBindingsClient.ListPolicyBindingsPagedResponse;
import static com.google.iam.v3.PolicyBindingsClient.SearchTargetPolicyBindingsPagedResponse;

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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v3.CreatePolicyBindingRequest;
import com.google.iam.v3.DeletePolicyBindingRequest;
import com.google.iam.v3.GetPolicyBindingRequest;
import com.google.iam.v3.ListPolicyBindingsRequest;
import com.google.iam.v3.ListPolicyBindingsResponse;
import com.google.iam.v3.OperationMetadata;
import com.google.iam.v3.PolicyBinding;
import com.google.iam.v3.SearchTargetPolicyBindingsRequest;
import com.google.iam.v3.SearchTargetPolicyBindingsResponse;
import com.google.iam.v3.UpdatePolicyBindingRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PolicyBindingsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (iam.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getPolicyBinding:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PolicyBindingsStubSettings.Builder policyBindingsSettingsBuilder =
 *     PolicyBindingsStubSettings.newBuilder();
 * policyBindingsSettingsBuilder
 *     .getPolicyBindingSettings()
 *     .setRetrySettings(
 *         policyBindingsSettingsBuilder
 *             .getPolicyBindingSettings()
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
 * PolicyBindingsStubSettings policyBindingsSettings = policyBindingsSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createPolicyBinding:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PolicyBindingsStubSettings.Builder policyBindingsSettingsBuilder =
 *     PolicyBindingsStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * policyBindingsSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class PolicyBindingsStubSettings extends StubSettings<PolicyBindingsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreatePolicyBindingRequest, Operation>
      createPolicyBindingSettings;
  private final OperationCallSettings<CreatePolicyBindingRequest, PolicyBinding, OperationMetadata>
      createPolicyBindingOperationSettings;
  private final UnaryCallSettings<GetPolicyBindingRequest, PolicyBinding> getPolicyBindingSettings;
  private final UnaryCallSettings<UpdatePolicyBindingRequest, Operation>
      updatePolicyBindingSettings;
  private final OperationCallSettings<UpdatePolicyBindingRequest, PolicyBinding, OperationMetadata>
      updatePolicyBindingOperationSettings;
  private final UnaryCallSettings<DeletePolicyBindingRequest, Operation>
      deletePolicyBindingSettings;
  private final OperationCallSettings<DeletePolicyBindingRequest, Empty, OperationMetadata>
      deletePolicyBindingOperationSettings;
  private final PagedCallSettings<
          ListPolicyBindingsRequest, ListPolicyBindingsResponse, ListPolicyBindingsPagedResponse>
      listPolicyBindingsSettings;
  private final PagedCallSettings<
          SearchTargetPolicyBindingsRequest,
          SearchTargetPolicyBindingsResponse,
          SearchTargetPolicyBindingsPagedResponse>
      searchTargetPolicyBindingsSettings;

  private static final PagedListDescriptor<
          ListPolicyBindingsRequest, ListPolicyBindingsResponse, PolicyBinding>
      LIST_POLICY_BINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPolicyBindingsRequest, ListPolicyBindingsResponse, PolicyBinding>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPolicyBindingsRequest injectToken(
                ListPolicyBindingsRequest payload, String token) {
              return ListPolicyBindingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPolicyBindingsRequest injectPageSize(
                ListPolicyBindingsRequest payload, int pageSize) {
              return ListPolicyBindingsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPolicyBindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPolicyBindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PolicyBinding> extractResources(ListPolicyBindingsResponse payload) {
              return payload.getPolicyBindingsList();
            }
          };

  private static final PagedListDescriptor<
          SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsResponse, PolicyBinding>
      SEARCH_TARGET_POLICY_BINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchTargetPolicyBindingsRequest,
              SearchTargetPolicyBindingsResponse,
              PolicyBinding>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchTargetPolicyBindingsRequest injectToken(
                SearchTargetPolicyBindingsRequest payload, String token) {
              return SearchTargetPolicyBindingsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public SearchTargetPolicyBindingsRequest injectPageSize(
                SearchTargetPolicyBindingsRequest payload, int pageSize) {
              return SearchTargetPolicyBindingsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(SearchTargetPolicyBindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchTargetPolicyBindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PolicyBinding> extractResources(
                SearchTargetPolicyBindingsResponse payload) {
              return payload.getPolicyBindingsList();
            }
          };

  private static final PagedListResponseFactory<
          ListPolicyBindingsRequest, ListPolicyBindingsResponse, ListPolicyBindingsPagedResponse>
      LIST_POLICY_BINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPolicyBindingsRequest,
              ListPolicyBindingsResponse,
              ListPolicyBindingsPagedResponse>() {
            @Override
            public ApiFuture<ListPolicyBindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPolicyBindingsRequest, ListPolicyBindingsResponse> callable,
                ListPolicyBindingsRequest request,
                ApiCallContext context,
                ApiFuture<ListPolicyBindingsResponse> futureResponse) {
              PageContext<ListPolicyBindingsRequest, ListPolicyBindingsResponse, PolicyBinding>
                  pageContext =
                      PageContext.create(
                          callable, LIST_POLICY_BINDINGS_PAGE_STR_DESC, request, context);
              return ListPolicyBindingsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchTargetPolicyBindingsRequest,
          SearchTargetPolicyBindingsResponse,
          SearchTargetPolicyBindingsPagedResponse>
      SEARCH_TARGET_POLICY_BINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchTargetPolicyBindingsRequest,
              SearchTargetPolicyBindingsResponse,
              SearchTargetPolicyBindingsPagedResponse>() {
            @Override
            public ApiFuture<SearchTargetPolicyBindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsResponse>
                    callable,
                SearchTargetPolicyBindingsRequest request,
                ApiCallContext context,
                ApiFuture<SearchTargetPolicyBindingsResponse> futureResponse) {
              PageContext<
                      SearchTargetPolicyBindingsRequest,
                      SearchTargetPolicyBindingsResponse,
                      PolicyBinding>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_TARGET_POLICY_BINDINGS_PAGE_STR_DESC, request, context);
              return SearchTargetPolicyBindingsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createPolicyBinding. */
  public UnaryCallSettings<CreatePolicyBindingRequest, Operation> createPolicyBindingSettings() {
    return createPolicyBindingSettings;
  }

  /** Returns the object with the settings used for calls to createPolicyBinding. */
  public OperationCallSettings<CreatePolicyBindingRequest, PolicyBinding, OperationMetadata>
      createPolicyBindingOperationSettings() {
    return createPolicyBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to getPolicyBinding. */
  public UnaryCallSettings<GetPolicyBindingRequest, PolicyBinding> getPolicyBindingSettings() {
    return getPolicyBindingSettings;
  }

  /** Returns the object with the settings used for calls to updatePolicyBinding. */
  public UnaryCallSettings<UpdatePolicyBindingRequest, Operation> updatePolicyBindingSettings() {
    return updatePolicyBindingSettings;
  }

  /** Returns the object with the settings used for calls to updatePolicyBinding. */
  public OperationCallSettings<UpdatePolicyBindingRequest, PolicyBinding, OperationMetadata>
      updatePolicyBindingOperationSettings() {
    return updatePolicyBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to deletePolicyBinding. */
  public UnaryCallSettings<DeletePolicyBindingRequest, Operation> deletePolicyBindingSettings() {
    return deletePolicyBindingSettings;
  }

  /** Returns the object with the settings used for calls to deletePolicyBinding. */
  public OperationCallSettings<DeletePolicyBindingRequest, Empty, OperationMetadata>
      deletePolicyBindingOperationSettings() {
    return deletePolicyBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to listPolicyBindings. */
  public PagedCallSettings<
          ListPolicyBindingsRequest, ListPolicyBindingsResponse, ListPolicyBindingsPagedResponse>
      listPolicyBindingsSettings() {
    return listPolicyBindingsSettings;
  }

  /** Returns the object with the settings used for calls to searchTargetPolicyBindings. */
  public PagedCallSettings<
          SearchTargetPolicyBindingsRequest,
          SearchTargetPolicyBindingsResponse,
          SearchTargetPolicyBindingsPagedResponse>
      searchTargetPolicyBindingsSettings() {
    return searchTargetPolicyBindingsSettings;
  }

  public PolicyBindingsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcPolicyBindingsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonPolicyBindingsStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "iam";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "iam.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "iam.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(PolicyBindingsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(PolicyBindingsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PolicyBindingsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected PolicyBindingsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createPolicyBindingSettings = settingsBuilder.createPolicyBindingSettings().build();
    createPolicyBindingOperationSettings =
        settingsBuilder.createPolicyBindingOperationSettings().build();
    getPolicyBindingSettings = settingsBuilder.getPolicyBindingSettings().build();
    updatePolicyBindingSettings = settingsBuilder.updatePolicyBindingSettings().build();
    updatePolicyBindingOperationSettings =
        settingsBuilder.updatePolicyBindingOperationSettings().build();
    deletePolicyBindingSettings = settingsBuilder.deletePolicyBindingSettings().build();
    deletePolicyBindingOperationSettings =
        settingsBuilder.deletePolicyBindingOperationSettings().build();
    listPolicyBindingsSettings = settingsBuilder.listPolicyBindingsSettings().build();
    searchTargetPolicyBindingsSettings =
        settingsBuilder.searchTargetPolicyBindingsSettings().build();
  }

  /** Builder for PolicyBindingsStubSettings. */
  public static class Builder extends StubSettings.Builder<PolicyBindingsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreatePolicyBindingRequest, Operation>
        createPolicyBindingSettings;
    private final OperationCallSettings.Builder<
            CreatePolicyBindingRequest, PolicyBinding, OperationMetadata>
        createPolicyBindingOperationSettings;
    private final UnaryCallSettings.Builder<GetPolicyBindingRequest, PolicyBinding>
        getPolicyBindingSettings;
    private final UnaryCallSettings.Builder<UpdatePolicyBindingRequest, Operation>
        updatePolicyBindingSettings;
    private final OperationCallSettings.Builder<
            UpdatePolicyBindingRequest, PolicyBinding, OperationMetadata>
        updatePolicyBindingOperationSettings;
    private final UnaryCallSettings.Builder<DeletePolicyBindingRequest, Operation>
        deletePolicyBindingSettings;
    private final OperationCallSettings.Builder<
            DeletePolicyBindingRequest, Empty, OperationMetadata>
        deletePolicyBindingOperationSettings;
    private final PagedCallSettings.Builder<
            ListPolicyBindingsRequest, ListPolicyBindingsResponse, ListPolicyBindingsPagedResponse>
        listPolicyBindingsSettings;
    private final PagedCallSettings.Builder<
            SearchTargetPolicyBindingsRequest,
            SearchTargetPolicyBindingsResponse,
            SearchTargetPolicyBindingsPagedResponse>
        searchTargetPolicyBindingsSettings;
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
              .setInitialRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setTotalTimeoutDuration(Duration.ofMillis(30000L))
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

      createPolicyBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPolicyBindingOperationSettings = OperationCallSettings.newBuilder();
      getPolicyBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePolicyBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePolicyBindingOperationSettings = OperationCallSettings.newBuilder();
      deletePolicyBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePolicyBindingOperationSettings = OperationCallSettings.newBuilder();
      listPolicyBindingsSettings = PagedCallSettings.newBuilder(LIST_POLICY_BINDINGS_PAGE_STR_FACT);
      searchTargetPolicyBindingsSettings =
          PagedCallSettings.newBuilder(SEARCH_TARGET_POLICY_BINDINGS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createPolicyBindingSettings,
              getPolicyBindingSettings,
              updatePolicyBindingSettings,
              deletePolicyBindingSettings,
              listPolicyBindingsSettings,
              searchTargetPolicyBindingsSettings);
      initDefaults(this);
    }

    protected Builder(PolicyBindingsStubSettings settings) {
      super(settings);

      createPolicyBindingSettings = settings.createPolicyBindingSettings.toBuilder();
      createPolicyBindingOperationSettings =
          settings.createPolicyBindingOperationSettings.toBuilder();
      getPolicyBindingSettings = settings.getPolicyBindingSettings.toBuilder();
      updatePolicyBindingSettings = settings.updatePolicyBindingSettings.toBuilder();
      updatePolicyBindingOperationSettings =
          settings.updatePolicyBindingOperationSettings.toBuilder();
      deletePolicyBindingSettings = settings.deletePolicyBindingSettings.toBuilder();
      deletePolicyBindingOperationSettings =
          settings.deletePolicyBindingOperationSettings.toBuilder();
      listPolicyBindingsSettings = settings.listPolicyBindingsSettings.toBuilder();
      searchTargetPolicyBindingsSettings = settings.searchTargetPolicyBindingsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createPolicyBindingSettings,
              getPolicyBindingSettings,
              updatePolicyBindingSettings,
              deletePolicyBindingSettings,
              listPolicyBindingsSettings,
              searchTargetPolicyBindingsSettings);
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
          .createPolicyBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getPolicyBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updatePolicyBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deletePolicyBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listPolicyBindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .searchTargetPolicyBindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPolicyBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreatePolicyBindingRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PolicyBinding.class))
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
          .updatePolicyBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdatePolicyBindingRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PolicyBinding.class))
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
          .deletePolicyBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePolicyBindingRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to createPolicyBinding. */
    public UnaryCallSettings.Builder<CreatePolicyBindingRequest, Operation>
        createPolicyBindingSettings() {
      return createPolicyBindingSettings;
    }

    /** Returns the builder for the settings used for calls to createPolicyBinding. */
    public OperationCallSettings.Builder<
            CreatePolicyBindingRequest, PolicyBinding, OperationMetadata>
        createPolicyBindingOperationSettings() {
      return createPolicyBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getPolicyBinding. */
    public UnaryCallSettings.Builder<GetPolicyBindingRequest, PolicyBinding>
        getPolicyBindingSettings() {
      return getPolicyBindingSettings;
    }

    /** Returns the builder for the settings used for calls to updatePolicyBinding. */
    public UnaryCallSettings.Builder<UpdatePolicyBindingRequest, Operation>
        updatePolicyBindingSettings() {
      return updatePolicyBindingSettings;
    }

    /** Returns the builder for the settings used for calls to updatePolicyBinding. */
    public OperationCallSettings.Builder<
            UpdatePolicyBindingRequest, PolicyBinding, OperationMetadata>
        updatePolicyBindingOperationSettings() {
      return updatePolicyBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deletePolicyBinding. */
    public UnaryCallSettings.Builder<DeletePolicyBindingRequest, Operation>
        deletePolicyBindingSettings() {
      return deletePolicyBindingSettings;
    }

    /** Returns the builder for the settings used for calls to deletePolicyBinding. */
    public OperationCallSettings.Builder<DeletePolicyBindingRequest, Empty, OperationMetadata>
        deletePolicyBindingOperationSettings() {
      return deletePolicyBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listPolicyBindings. */
    public PagedCallSettings.Builder<
            ListPolicyBindingsRequest, ListPolicyBindingsResponse, ListPolicyBindingsPagedResponse>
        listPolicyBindingsSettings() {
      return listPolicyBindingsSettings;
    }

    /** Returns the builder for the settings used for calls to searchTargetPolicyBindings. */
    public PagedCallSettings.Builder<
            SearchTargetPolicyBindingsRequest,
            SearchTargetPolicyBindingsResponse,
            SearchTargetPolicyBindingsPagedResponse>
        searchTargetPolicyBindingsSettings() {
      return searchTargetPolicyBindingsSettings;
    }

    @Override
    public PolicyBindingsStubSettings build() throws IOException {
      return new PolicyBindingsStubSettings(this);
    }
  }
}
