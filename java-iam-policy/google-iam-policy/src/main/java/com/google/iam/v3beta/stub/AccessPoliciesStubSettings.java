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

package com.google.iam.v3beta.stub;

import static com.google.iam.v3beta.AccessPoliciesClient.ListAccessPoliciesPagedResponse;
import static com.google.iam.v3beta.AccessPoliciesClient.SearchAccessPolicyBindingsPagedResponse;

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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v3beta.AccessPolicy;
import com.google.iam.v3beta.CreateAccessPolicyRequest;
import com.google.iam.v3beta.DeleteAccessPolicyRequest;
import com.google.iam.v3beta.GetAccessPolicyRequest;
import com.google.iam.v3beta.ListAccessPoliciesRequest;
import com.google.iam.v3beta.ListAccessPoliciesResponse;
import com.google.iam.v3beta.OperationMetadata;
import com.google.iam.v3beta.PolicyBinding;
import com.google.iam.v3beta.SearchAccessPolicyBindingsRequest;
import com.google.iam.v3beta.SearchAccessPolicyBindingsResponse;
import com.google.iam.v3beta.UpdateAccessPolicyRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AccessPoliciesStub}.
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
 * of getAccessPolicy:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AccessPoliciesStubSettings.Builder accessPoliciesSettingsBuilder =
 *     AccessPoliciesStubSettings.newBuilder();
 * accessPoliciesSettingsBuilder
 *     .getAccessPolicySettings()
 *     .setRetrySettings(
 *         accessPoliciesSettingsBuilder
 *             .getAccessPolicySettings()
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
 * AccessPoliciesStubSettings accessPoliciesSettings = accessPoliciesSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createAccessPolicy:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AccessPoliciesStubSettings.Builder accessPoliciesSettingsBuilder =
 *     AccessPoliciesStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * accessPoliciesSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class AccessPoliciesStubSettings extends StubSettings<AccessPoliciesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateAccessPolicyRequest, Operation> createAccessPolicySettings;
  private final OperationCallSettings<CreateAccessPolicyRequest, AccessPolicy, OperationMetadata>
      createAccessPolicyOperationSettings;
  private final UnaryCallSettings<GetAccessPolicyRequest, AccessPolicy> getAccessPolicySettings;
  private final UnaryCallSettings<UpdateAccessPolicyRequest, Operation> updateAccessPolicySettings;
  private final OperationCallSettings<UpdateAccessPolicyRequest, AccessPolicy, OperationMetadata>
      updateAccessPolicyOperationSettings;
  private final UnaryCallSettings<DeleteAccessPolicyRequest, Operation> deleteAccessPolicySettings;
  private final OperationCallSettings<DeleteAccessPolicyRequest, Empty, OperationMetadata>
      deleteAccessPolicyOperationSettings;
  private final PagedCallSettings<
          ListAccessPoliciesRequest, ListAccessPoliciesResponse, ListAccessPoliciesPagedResponse>
      listAccessPoliciesSettings;
  private final PagedCallSettings<
          SearchAccessPolicyBindingsRequest,
          SearchAccessPolicyBindingsResponse,
          SearchAccessPolicyBindingsPagedResponse>
      searchAccessPolicyBindingsSettings;

  private static final PagedListDescriptor<
          ListAccessPoliciesRequest, ListAccessPoliciesResponse, AccessPolicy>
      LIST_ACCESS_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAccessPoliciesRequest, ListAccessPoliciesResponse, AccessPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAccessPoliciesRequest injectToken(
                ListAccessPoliciesRequest payload, String token) {
              return ListAccessPoliciesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAccessPoliciesRequest injectPageSize(
                ListAccessPoliciesRequest payload, int pageSize) {
              return ListAccessPoliciesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAccessPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAccessPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AccessPolicy> extractResources(ListAccessPoliciesResponse payload) {
              return payload.getAccessPoliciesList();
            }
          };

  private static final PagedListDescriptor<
          SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsResponse, PolicyBinding>
      SEARCH_ACCESS_POLICY_BINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchAccessPolicyBindingsRequest,
              SearchAccessPolicyBindingsResponse,
              PolicyBinding>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchAccessPolicyBindingsRequest injectToken(
                SearchAccessPolicyBindingsRequest payload, String token) {
              return SearchAccessPolicyBindingsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public SearchAccessPolicyBindingsRequest injectPageSize(
                SearchAccessPolicyBindingsRequest payload, int pageSize) {
              return SearchAccessPolicyBindingsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(SearchAccessPolicyBindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchAccessPolicyBindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PolicyBinding> extractResources(
                SearchAccessPolicyBindingsResponse payload) {
              return payload.getPolicyBindingsList();
            }
          };

  private static final PagedListResponseFactory<
          ListAccessPoliciesRequest, ListAccessPoliciesResponse, ListAccessPoliciesPagedResponse>
      LIST_ACCESS_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAccessPoliciesRequest,
              ListAccessPoliciesResponse,
              ListAccessPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListAccessPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesResponse> callable,
                ListAccessPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListAccessPoliciesResponse> futureResponse) {
              PageContext<ListAccessPoliciesRequest, ListAccessPoliciesResponse, AccessPolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ACCESS_POLICIES_PAGE_STR_DESC, request, context);
              return ListAccessPoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchAccessPolicyBindingsRequest,
          SearchAccessPolicyBindingsResponse,
          SearchAccessPolicyBindingsPagedResponse>
      SEARCH_ACCESS_POLICY_BINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchAccessPolicyBindingsRequest,
              SearchAccessPolicyBindingsResponse,
              SearchAccessPolicyBindingsPagedResponse>() {
            @Override
            public ApiFuture<SearchAccessPolicyBindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsResponse>
                    callable,
                SearchAccessPolicyBindingsRequest request,
                ApiCallContext context,
                ApiFuture<SearchAccessPolicyBindingsResponse> futureResponse) {
              PageContext<
                      SearchAccessPolicyBindingsRequest,
                      SearchAccessPolicyBindingsResponse,
                      PolicyBinding>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_ACCESS_POLICY_BINDINGS_PAGE_STR_DESC, request, context);
              return SearchAccessPolicyBindingsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createAccessPolicy. */
  public UnaryCallSettings<CreateAccessPolicyRequest, Operation> createAccessPolicySettings() {
    return createAccessPolicySettings;
  }

  /** Returns the object with the settings used for calls to createAccessPolicy. */
  public OperationCallSettings<CreateAccessPolicyRequest, AccessPolicy, OperationMetadata>
      createAccessPolicyOperationSettings() {
    return createAccessPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to getAccessPolicy. */
  public UnaryCallSettings<GetAccessPolicyRequest, AccessPolicy> getAccessPolicySettings() {
    return getAccessPolicySettings;
  }

  /** Returns the object with the settings used for calls to updateAccessPolicy. */
  public UnaryCallSettings<UpdateAccessPolicyRequest, Operation> updateAccessPolicySettings() {
    return updateAccessPolicySettings;
  }

  /** Returns the object with the settings used for calls to updateAccessPolicy. */
  public OperationCallSettings<UpdateAccessPolicyRequest, AccessPolicy, OperationMetadata>
      updateAccessPolicyOperationSettings() {
    return updateAccessPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAccessPolicy. */
  public UnaryCallSettings<DeleteAccessPolicyRequest, Operation> deleteAccessPolicySettings() {
    return deleteAccessPolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteAccessPolicy. */
  public OperationCallSettings<DeleteAccessPolicyRequest, Empty, OperationMetadata>
      deleteAccessPolicyOperationSettings() {
    return deleteAccessPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to listAccessPolicies. */
  public PagedCallSettings<
          ListAccessPoliciesRequest, ListAccessPoliciesResponse, ListAccessPoliciesPagedResponse>
      listAccessPoliciesSettings() {
    return listAccessPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to searchAccessPolicyBindings. */
  public PagedCallSettings<
          SearchAccessPolicyBindingsRequest,
          SearchAccessPolicyBindingsResponse,
          SearchAccessPolicyBindingsPagedResponse>
      searchAccessPolicyBindingsSettings() {
    return searchAccessPolicyBindingsSettings;
  }

  public AccessPoliciesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAccessPoliciesStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAccessPoliciesStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(AccessPoliciesStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AccessPoliciesStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AccessPoliciesStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected AccessPoliciesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createAccessPolicySettings = settingsBuilder.createAccessPolicySettings().build();
    createAccessPolicyOperationSettings =
        settingsBuilder.createAccessPolicyOperationSettings().build();
    getAccessPolicySettings = settingsBuilder.getAccessPolicySettings().build();
    updateAccessPolicySettings = settingsBuilder.updateAccessPolicySettings().build();
    updateAccessPolicyOperationSettings =
        settingsBuilder.updateAccessPolicyOperationSettings().build();
    deleteAccessPolicySettings = settingsBuilder.deleteAccessPolicySettings().build();
    deleteAccessPolicyOperationSettings =
        settingsBuilder.deleteAccessPolicyOperationSettings().build();
    listAccessPoliciesSettings = settingsBuilder.listAccessPoliciesSettings().build();
    searchAccessPolicyBindingsSettings =
        settingsBuilder.searchAccessPolicyBindingsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-iam-policy")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for AccessPoliciesStubSettings. */
  public static class Builder extends StubSettings.Builder<AccessPoliciesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateAccessPolicyRequest, Operation>
        createAccessPolicySettings;
    private final OperationCallSettings.Builder<
            CreateAccessPolicyRequest, AccessPolicy, OperationMetadata>
        createAccessPolicyOperationSettings;
    private final UnaryCallSettings.Builder<GetAccessPolicyRequest, AccessPolicy>
        getAccessPolicySettings;
    private final UnaryCallSettings.Builder<UpdateAccessPolicyRequest, Operation>
        updateAccessPolicySettings;
    private final OperationCallSettings.Builder<
            UpdateAccessPolicyRequest, AccessPolicy, OperationMetadata>
        updateAccessPolicyOperationSettings;
    private final UnaryCallSettings.Builder<DeleteAccessPolicyRequest, Operation>
        deleteAccessPolicySettings;
    private final OperationCallSettings.Builder<DeleteAccessPolicyRequest, Empty, OperationMetadata>
        deleteAccessPolicyOperationSettings;
    private final PagedCallSettings.Builder<
            ListAccessPoliciesRequest, ListAccessPoliciesResponse, ListAccessPoliciesPagedResponse>
        listAccessPoliciesSettings;
    private final PagedCallSettings.Builder<
            SearchAccessPolicyBindingsRequest,
            SearchAccessPolicyBindingsResponse,
            SearchAccessPolicyBindingsPagedResponse>
        searchAccessPolicyBindingsSettings;
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

      createAccessPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAccessPolicyOperationSettings = OperationCallSettings.newBuilder();
      getAccessPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAccessPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAccessPolicyOperationSettings = OperationCallSettings.newBuilder();
      deleteAccessPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAccessPolicyOperationSettings = OperationCallSettings.newBuilder();
      listAccessPoliciesSettings = PagedCallSettings.newBuilder(LIST_ACCESS_POLICIES_PAGE_STR_FACT);
      searchAccessPolicyBindingsSettings =
          PagedCallSettings.newBuilder(SEARCH_ACCESS_POLICY_BINDINGS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createAccessPolicySettings,
              getAccessPolicySettings,
              updateAccessPolicySettings,
              deleteAccessPolicySettings,
              listAccessPoliciesSettings,
              searchAccessPolicyBindingsSettings);
      initDefaults(this);
    }

    protected Builder(AccessPoliciesStubSettings settings) {
      super(settings);

      createAccessPolicySettings = settings.createAccessPolicySettings.toBuilder();
      createAccessPolicyOperationSettings =
          settings.createAccessPolicyOperationSettings.toBuilder();
      getAccessPolicySettings = settings.getAccessPolicySettings.toBuilder();
      updateAccessPolicySettings = settings.updateAccessPolicySettings.toBuilder();
      updateAccessPolicyOperationSettings =
          settings.updateAccessPolicyOperationSettings.toBuilder();
      deleteAccessPolicySettings = settings.deleteAccessPolicySettings.toBuilder();
      deleteAccessPolicyOperationSettings =
          settings.deleteAccessPolicyOperationSettings.toBuilder();
      listAccessPoliciesSettings = settings.listAccessPoliciesSettings.toBuilder();
      searchAccessPolicyBindingsSettings = settings.searchAccessPolicyBindingsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createAccessPolicySettings,
              getAccessPolicySettings,
              updateAccessPolicySettings,
              deleteAccessPolicySettings,
              listAccessPoliciesSettings,
              searchAccessPolicyBindingsSettings);
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
          .createAccessPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getAccessPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateAccessPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteAccessPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listAccessPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .searchAccessPolicyBindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAccessPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAccessPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AccessPolicy.class))
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
          .updateAccessPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAccessPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AccessPolicy.class))
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
          .deleteAccessPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAccessPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to createAccessPolicy. */
    public UnaryCallSettings.Builder<CreateAccessPolicyRequest, Operation>
        createAccessPolicySettings() {
      return createAccessPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createAccessPolicy. */
    public OperationCallSettings.Builder<CreateAccessPolicyRequest, AccessPolicy, OperationMetadata>
        createAccessPolicyOperationSettings() {
      return createAccessPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getAccessPolicy. */
    public UnaryCallSettings.Builder<GetAccessPolicyRequest, AccessPolicy>
        getAccessPolicySettings() {
      return getAccessPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateAccessPolicy. */
    public UnaryCallSettings.Builder<UpdateAccessPolicyRequest, Operation>
        updateAccessPolicySettings() {
      return updateAccessPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateAccessPolicy. */
    public OperationCallSettings.Builder<UpdateAccessPolicyRequest, AccessPolicy, OperationMetadata>
        updateAccessPolicyOperationSettings() {
      return updateAccessPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAccessPolicy. */
    public UnaryCallSettings.Builder<DeleteAccessPolicyRequest, Operation>
        deleteAccessPolicySettings() {
      return deleteAccessPolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteAccessPolicy. */
    public OperationCallSettings.Builder<DeleteAccessPolicyRequest, Empty, OperationMetadata>
        deleteAccessPolicyOperationSettings() {
      return deleteAccessPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listAccessPolicies. */
    public PagedCallSettings.Builder<
            ListAccessPoliciesRequest, ListAccessPoliciesResponse, ListAccessPoliciesPagedResponse>
        listAccessPoliciesSettings() {
      return listAccessPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to searchAccessPolicyBindings. */
    public PagedCallSettings.Builder<
            SearchAccessPolicyBindingsRequest,
            SearchAccessPolicyBindingsResponse,
            SearchAccessPolicyBindingsPagedResponse>
        searchAccessPolicyBindingsSettings() {
      return searchAccessPolicyBindingsSettings;
    }

    @Override
    public AccessPoliciesStubSettings build() throws IOException {
      return new AccessPoliciesStubSettings(this);
    }
  }
}
