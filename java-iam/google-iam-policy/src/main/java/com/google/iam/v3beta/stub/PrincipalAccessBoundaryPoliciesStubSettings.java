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

package com.google.iam.v3beta.stub;

import static com.google.iam.v3beta.PrincipalAccessBoundaryPoliciesClient.ListPrincipalAccessBoundaryPoliciesPagedResponse;
import static com.google.iam.v3beta.PrincipalAccessBoundaryPoliciesClient.SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse;

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
import com.google.iam.v3beta.CreatePrincipalAccessBoundaryPolicyRequest;
import com.google.iam.v3beta.DeletePrincipalAccessBoundaryPolicyRequest;
import com.google.iam.v3beta.GetPrincipalAccessBoundaryPolicyRequest;
import com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesRequest;
import com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesResponse;
import com.google.iam.v3beta.OperationMetadata;
import com.google.iam.v3beta.PolicyBinding;
import com.google.iam.v3beta.PrincipalAccessBoundaryPolicy;
import com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsRequest;
import com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsResponse;
import com.google.iam.v3beta.UpdatePrincipalAccessBoundaryPolicyRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PrincipalAccessBoundaryPoliciesStub}.
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
 * of getPrincipalAccessBoundaryPolicy:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PrincipalAccessBoundaryPoliciesStubSettings.Builder
 *     principalAccessBoundaryPoliciesSettingsBuilder =
 *         PrincipalAccessBoundaryPoliciesStubSettings.newBuilder();
 * principalAccessBoundaryPoliciesSettingsBuilder
 *     .getPrincipalAccessBoundaryPolicySettings()
 *     .setRetrySettings(
 *         principalAccessBoundaryPoliciesSettingsBuilder
 *             .getPrincipalAccessBoundaryPolicySettings()
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
 * PrincipalAccessBoundaryPoliciesStubSettings principalAccessBoundaryPoliciesSettings =
 *     principalAccessBoundaryPoliciesSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createPrincipalAccessBoundaryPolicy:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PrincipalAccessBoundaryPoliciesStubSettings.Builder
 *     principalAccessBoundaryPoliciesSettingsBuilder =
 *         PrincipalAccessBoundaryPoliciesStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * principalAccessBoundaryPoliciesSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PrincipalAccessBoundaryPoliciesStubSettings
    extends StubSettings<PrincipalAccessBoundaryPoliciesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreatePrincipalAccessBoundaryPolicyRequest, Operation>
      createPrincipalAccessBoundaryPolicySettings;
  private final OperationCallSettings<
          CreatePrincipalAccessBoundaryPolicyRequest,
          PrincipalAccessBoundaryPolicy,
          OperationMetadata>
      createPrincipalAccessBoundaryPolicyOperationSettings;
  private final UnaryCallSettings<
          GetPrincipalAccessBoundaryPolicyRequest, PrincipalAccessBoundaryPolicy>
      getPrincipalAccessBoundaryPolicySettings;
  private final UnaryCallSettings<UpdatePrincipalAccessBoundaryPolicyRequest, Operation>
      updatePrincipalAccessBoundaryPolicySettings;
  private final OperationCallSettings<
          UpdatePrincipalAccessBoundaryPolicyRequest,
          PrincipalAccessBoundaryPolicy,
          OperationMetadata>
      updatePrincipalAccessBoundaryPolicyOperationSettings;
  private final UnaryCallSettings<DeletePrincipalAccessBoundaryPolicyRequest, Operation>
      deletePrincipalAccessBoundaryPolicySettings;
  private final OperationCallSettings<
          DeletePrincipalAccessBoundaryPolicyRequest, Empty, OperationMetadata>
      deletePrincipalAccessBoundaryPolicyOperationSettings;
  private final PagedCallSettings<
          ListPrincipalAccessBoundaryPoliciesRequest,
          ListPrincipalAccessBoundaryPoliciesResponse,
          ListPrincipalAccessBoundaryPoliciesPagedResponse>
      listPrincipalAccessBoundaryPoliciesSettings;
  private final PagedCallSettings<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsResponse,
          SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse>
      searchPrincipalAccessBoundaryPolicyBindingsSettings;

  private static final PagedListDescriptor<
          ListPrincipalAccessBoundaryPoliciesRequest,
          ListPrincipalAccessBoundaryPoliciesResponse,
          PrincipalAccessBoundaryPolicy>
      LIST_PRINCIPAL_ACCESS_BOUNDARY_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPrincipalAccessBoundaryPoliciesRequest,
              ListPrincipalAccessBoundaryPoliciesResponse,
              PrincipalAccessBoundaryPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPrincipalAccessBoundaryPoliciesRequest injectToken(
                ListPrincipalAccessBoundaryPoliciesRequest payload, String token) {
              return ListPrincipalAccessBoundaryPoliciesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListPrincipalAccessBoundaryPoliciesRequest injectPageSize(
                ListPrincipalAccessBoundaryPoliciesRequest payload, int pageSize) {
              return ListPrincipalAccessBoundaryPoliciesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListPrincipalAccessBoundaryPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPrincipalAccessBoundaryPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PrincipalAccessBoundaryPolicy> extractResources(
                ListPrincipalAccessBoundaryPoliciesResponse payload) {
              return payload.getPrincipalAccessBoundaryPoliciesList();
            }
          };

  private static final PagedListDescriptor<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsResponse,
          PolicyBinding>
      SEARCH_PRINCIPAL_ACCESS_BOUNDARY_POLICY_BINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchPrincipalAccessBoundaryPolicyBindingsRequest,
              SearchPrincipalAccessBoundaryPolicyBindingsResponse,
              PolicyBinding>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchPrincipalAccessBoundaryPolicyBindingsRequest injectToken(
                SearchPrincipalAccessBoundaryPolicyBindingsRequest payload, String token) {
              return SearchPrincipalAccessBoundaryPolicyBindingsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public SearchPrincipalAccessBoundaryPolicyBindingsRequest injectPageSize(
                SearchPrincipalAccessBoundaryPolicyBindingsRequest payload, int pageSize) {
              return SearchPrincipalAccessBoundaryPolicyBindingsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(
                SearchPrincipalAccessBoundaryPolicyBindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(
                SearchPrincipalAccessBoundaryPolicyBindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PolicyBinding> extractResources(
                SearchPrincipalAccessBoundaryPolicyBindingsResponse payload) {
              return payload.getPolicyBindingsList();
            }
          };

  private static final PagedListResponseFactory<
          ListPrincipalAccessBoundaryPoliciesRequest,
          ListPrincipalAccessBoundaryPoliciesResponse,
          ListPrincipalAccessBoundaryPoliciesPagedResponse>
      LIST_PRINCIPAL_ACCESS_BOUNDARY_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPrincipalAccessBoundaryPoliciesRequest,
              ListPrincipalAccessBoundaryPoliciesResponse,
              ListPrincipalAccessBoundaryPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListPrincipalAccessBoundaryPoliciesPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListPrincipalAccessBoundaryPoliciesRequest,
                            ListPrincipalAccessBoundaryPoliciesResponse>
                        callable,
                    ListPrincipalAccessBoundaryPoliciesRequest request,
                    ApiCallContext context,
                    ApiFuture<ListPrincipalAccessBoundaryPoliciesResponse> futureResponse) {
              PageContext<
                      ListPrincipalAccessBoundaryPoliciesRequest,
                      ListPrincipalAccessBoundaryPoliciesResponse,
                      PrincipalAccessBoundaryPolicy>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_PRINCIPAL_ACCESS_BOUNDARY_POLICIES_PAGE_STR_DESC,
                          request,
                          context);
              return ListPrincipalAccessBoundaryPoliciesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsResponse,
          SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse>
      SEARCH_PRINCIPAL_ACCESS_BOUNDARY_POLICY_BINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchPrincipalAccessBoundaryPolicyBindingsRequest,
              SearchPrincipalAccessBoundaryPolicyBindingsResponse,
              SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse>() {
            @Override
            public ApiFuture<SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            SearchPrincipalAccessBoundaryPolicyBindingsRequest,
                            SearchPrincipalAccessBoundaryPolicyBindingsResponse>
                        callable,
                    SearchPrincipalAccessBoundaryPolicyBindingsRequest request,
                    ApiCallContext context,
                    ApiFuture<SearchPrincipalAccessBoundaryPolicyBindingsResponse> futureResponse) {
              PageContext<
                      SearchPrincipalAccessBoundaryPolicyBindingsRequest,
                      SearchPrincipalAccessBoundaryPolicyBindingsResponse,
                      PolicyBinding>
                  pageContext =
                      PageContext.create(
                          callable,
                          SEARCH_PRINCIPAL_ACCESS_BOUNDARY_POLICY_BINDINGS_PAGE_STR_DESC,
                          request,
                          context);
              return SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createPrincipalAccessBoundaryPolicy. */
  public UnaryCallSettings<CreatePrincipalAccessBoundaryPolicyRequest, Operation>
      createPrincipalAccessBoundaryPolicySettings() {
    return createPrincipalAccessBoundaryPolicySettings;
  }

  /** Returns the object with the settings used for calls to createPrincipalAccessBoundaryPolicy. */
  public OperationCallSettings<
          CreatePrincipalAccessBoundaryPolicyRequest,
          PrincipalAccessBoundaryPolicy,
          OperationMetadata>
      createPrincipalAccessBoundaryPolicyOperationSettings() {
    return createPrincipalAccessBoundaryPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to getPrincipalAccessBoundaryPolicy. */
  public UnaryCallSettings<GetPrincipalAccessBoundaryPolicyRequest, PrincipalAccessBoundaryPolicy>
      getPrincipalAccessBoundaryPolicySettings() {
    return getPrincipalAccessBoundaryPolicySettings;
  }

  /** Returns the object with the settings used for calls to updatePrincipalAccessBoundaryPolicy. */
  public UnaryCallSettings<UpdatePrincipalAccessBoundaryPolicyRequest, Operation>
      updatePrincipalAccessBoundaryPolicySettings() {
    return updatePrincipalAccessBoundaryPolicySettings;
  }

  /** Returns the object with the settings used for calls to updatePrincipalAccessBoundaryPolicy. */
  public OperationCallSettings<
          UpdatePrincipalAccessBoundaryPolicyRequest,
          PrincipalAccessBoundaryPolicy,
          OperationMetadata>
      updatePrincipalAccessBoundaryPolicyOperationSettings() {
    return updatePrincipalAccessBoundaryPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deletePrincipalAccessBoundaryPolicy. */
  public UnaryCallSettings<DeletePrincipalAccessBoundaryPolicyRequest, Operation>
      deletePrincipalAccessBoundaryPolicySettings() {
    return deletePrincipalAccessBoundaryPolicySettings;
  }

  /** Returns the object with the settings used for calls to deletePrincipalAccessBoundaryPolicy. */
  public OperationCallSettings<DeletePrincipalAccessBoundaryPolicyRequest, Empty, OperationMetadata>
      deletePrincipalAccessBoundaryPolicyOperationSettings() {
    return deletePrincipalAccessBoundaryPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to listPrincipalAccessBoundaryPolicies. */
  public PagedCallSettings<
          ListPrincipalAccessBoundaryPoliciesRequest,
          ListPrincipalAccessBoundaryPoliciesResponse,
          ListPrincipalAccessBoundaryPoliciesPagedResponse>
      listPrincipalAccessBoundaryPoliciesSettings() {
    return listPrincipalAccessBoundaryPoliciesSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * searchPrincipalAccessBoundaryPolicyBindings.
   */
  public PagedCallSettings<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsResponse,
          SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse>
      searchPrincipalAccessBoundaryPolicyBindingsSettings() {
    return searchPrincipalAccessBoundaryPolicyBindingsSettings;
  }

  public PrincipalAccessBoundaryPoliciesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcPrincipalAccessBoundaryPoliciesStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonPrincipalAccessBoundaryPoliciesStub.create(this);
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
            "gapic",
            GaxProperties.getLibraryVersion(PrincipalAccessBoundaryPoliciesStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic",
            GaxProperties.getLibraryVersion(PrincipalAccessBoundaryPoliciesStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PrincipalAccessBoundaryPoliciesStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected PrincipalAccessBoundaryPoliciesStubSettings(Builder settingsBuilder)
      throws IOException {
    super(settingsBuilder);

    createPrincipalAccessBoundaryPolicySettings =
        settingsBuilder.createPrincipalAccessBoundaryPolicySettings().build();
    createPrincipalAccessBoundaryPolicyOperationSettings =
        settingsBuilder.createPrincipalAccessBoundaryPolicyOperationSettings().build();
    getPrincipalAccessBoundaryPolicySettings =
        settingsBuilder.getPrincipalAccessBoundaryPolicySettings().build();
    updatePrincipalAccessBoundaryPolicySettings =
        settingsBuilder.updatePrincipalAccessBoundaryPolicySettings().build();
    updatePrincipalAccessBoundaryPolicyOperationSettings =
        settingsBuilder.updatePrincipalAccessBoundaryPolicyOperationSettings().build();
    deletePrincipalAccessBoundaryPolicySettings =
        settingsBuilder.deletePrincipalAccessBoundaryPolicySettings().build();
    deletePrincipalAccessBoundaryPolicyOperationSettings =
        settingsBuilder.deletePrincipalAccessBoundaryPolicyOperationSettings().build();
    listPrincipalAccessBoundaryPoliciesSettings =
        settingsBuilder.listPrincipalAccessBoundaryPoliciesSettings().build();
    searchPrincipalAccessBoundaryPolicyBindingsSettings =
        settingsBuilder.searchPrincipalAccessBoundaryPolicyBindingsSettings().build();
  }

  /** Builder for PrincipalAccessBoundaryPoliciesStubSettings. */
  public static class Builder
      extends StubSettings.Builder<PrincipalAccessBoundaryPoliciesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreatePrincipalAccessBoundaryPolicyRequest, Operation>
        createPrincipalAccessBoundaryPolicySettings;
    private final OperationCallSettings.Builder<
            CreatePrincipalAccessBoundaryPolicyRequest,
            PrincipalAccessBoundaryPolicy,
            OperationMetadata>
        createPrincipalAccessBoundaryPolicyOperationSettings;
    private final UnaryCallSettings.Builder<
            GetPrincipalAccessBoundaryPolicyRequest, PrincipalAccessBoundaryPolicy>
        getPrincipalAccessBoundaryPolicySettings;
    private final UnaryCallSettings.Builder<UpdatePrincipalAccessBoundaryPolicyRequest, Operation>
        updatePrincipalAccessBoundaryPolicySettings;
    private final OperationCallSettings.Builder<
            UpdatePrincipalAccessBoundaryPolicyRequest,
            PrincipalAccessBoundaryPolicy,
            OperationMetadata>
        updatePrincipalAccessBoundaryPolicyOperationSettings;
    private final UnaryCallSettings.Builder<DeletePrincipalAccessBoundaryPolicyRequest, Operation>
        deletePrincipalAccessBoundaryPolicySettings;
    private final OperationCallSettings.Builder<
            DeletePrincipalAccessBoundaryPolicyRequest, Empty, OperationMetadata>
        deletePrincipalAccessBoundaryPolicyOperationSettings;
    private final PagedCallSettings.Builder<
            ListPrincipalAccessBoundaryPoliciesRequest,
            ListPrincipalAccessBoundaryPoliciesResponse,
            ListPrincipalAccessBoundaryPoliciesPagedResponse>
        listPrincipalAccessBoundaryPoliciesSettings;
    private final PagedCallSettings.Builder<
            SearchPrincipalAccessBoundaryPolicyBindingsRequest,
            SearchPrincipalAccessBoundaryPolicyBindingsResponse,
            SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse>
        searchPrincipalAccessBoundaryPolicyBindingsSettings;
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

      createPrincipalAccessBoundaryPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPrincipalAccessBoundaryPolicyOperationSettings = OperationCallSettings.newBuilder();
      getPrincipalAccessBoundaryPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePrincipalAccessBoundaryPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePrincipalAccessBoundaryPolicyOperationSettings = OperationCallSettings.newBuilder();
      deletePrincipalAccessBoundaryPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePrincipalAccessBoundaryPolicyOperationSettings = OperationCallSettings.newBuilder();
      listPrincipalAccessBoundaryPoliciesSettings =
          PagedCallSettings.newBuilder(LIST_PRINCIPAL_ACCESS_BOUNDARY_POLICIES_PAGE_STR_FACT);
      searchPrincipalAccessBoundaryPolicyBindingsSettings =
          PagedCallSettings.newBuilder(
              SEARCH_PRINCIPAL_ACCESS_BOUNDARY_POLICY_BINDINGS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createPrincipalAccessBoundaryPolicySettings,
              getPrincipalAccessBoundaryPolicySettings,
              updatePrincipalAccessBoundaryPolicySettings,
              deletePrincipalAccessBoundaryPolicySettings,
              listPrincipalAccessBoundaryPoliciesSettings,
              searchPrincipalAccessBoundaryPolicyBindingsSettings);
      initDefaults(this);
    }

    protected Builder(PrincipalAccessBoundaryPoliciesStubSettings settings) {
      super(settings);

      createPrincipalAccessBoundaryPolicySettings =
          settings.createPrincipalAccessBoundaryPolicySettings.toBuilder();
      createPrincipalAccessBoundaryPolicyOperationSettings =
          settings.createPrincipalAccessBoundaryPolicyOperationSettings.toBuilder();
      getPrincipalAccessBoundaryPolicySettings =
          settings.getPrincipalAccessBoundaryPolicySettings.toBuilder();
      updatePrincipalAccessBoundaryPolicySettings =
          settings.updatePrincipalAccessBoundaryPolicySettings.toBuilder();
      updatePrincipalAccessBoundaryPolicyOperationSettings =
          settings.updatePrincipalAccessBoundaryPolicyOperationSettings.toBuilder();
      deletePrincipalAccessBoundaryPolicySettings =
          settings.deletePrincipalAccessBoundaryPolicySettings.toBuilder();
      deletePrincipalAccessBoundaryPolicyOperationSettings =
          settings.deletePrincipalAccessBoundaryPolicyOperationSettings.toBuilder();
      listPrincipalAccessBoundaryPoliciesSettings =
          settings.listPrincipalAccessBoundaryPoliciesSettings.toBuilder();
      searchPrincipalAccessBoundaryPolicyBindingsSettings =
          settings.searchPrincipalAccessBoundaryPolicyBindingsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createPrincipalAccessBoundaryPolicySettings,
              getPrincipalAccessBoundaryPolicySettings,
              updatePrincipalAccessBoundaryPolicySettings,
              deletePrincipalAccessBoundaryPolicySettings,
              listPrincipalAccessBoundaryPoliciesSettings,
              searchPrincipalAccessBoundaryPolicyBindingsSettings);
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
          .createPrincipalAccessBoundaryPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getPrincipalAccessBoundaryPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updatePrincipalAccessBoundaryPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deletePrincipalAccessBoundaryPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listPrincipalAccessBoundaryPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .searchPrincipalAccessBoundaryPolicyBindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPrincipalAccessBoundaryPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreatePrincipalAccessBoundaryPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  PrincipalAccessBoundaryPolicy.class))
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
          .updatePrincipalAccessBoundaryPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdatePrincipalAccessBoundaryPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  PrincipalAccessBoundaryPolicy.class))
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
          .deletePrincipalAccessBoundaryPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePrincipalAccessBoundaryPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
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

    /**
     * Returns the builder for the settings used for calls to createPrincipalAccessBoundaryPolicy.
     */
    public UnaryCallSettings.Builder<CreatePrincipalAccessBoundaryPolicyRequest, Operation>
        createPrincipalAccessBoundaryPolicySettings() {
      return createPrincipalAccessBoundaryPolicySettings;
    }

    /**
     * Returns the builder for the settings used for calls to createPrincipalAccessBoundaryPolicy.
     */
    public OperationCallSettings.Builder<
            CreatePrincipalAccessBoundaryPolicyRequest,
            PrincipalAccessBoundaryPolicy,
            OperationMetadata>
        createPrincipalAccessBoundaryPolicyOperationSettings() {
      return createPrincipalAccessBoundaryPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getPrincipalAccessBoundaryPolicy. */
    public UnaryCallSettings.Builder<
            GetPrincipalAccessBoundaryPolicyRequest, PrincipalAccessBoundaryPolicy>
        getPrincipalAccessBoundaryPolicySettings() {
      return getPrincipalAccessBoundaryPolicySettings;
    }

    /**
     * Returns the builder for the settings used for calls to updatePrincipalAccessBoundaryPolicy.
     */
    public UnaryCallSettings.Builder<UpdatePrincipalAccessBoundaryPolicyRequest, Operation>
        updatePrincipalAccessBoundaryPolicySettings() {
      return updatePrincipalAccessBoundaryPolicySettings;
    }

    /**
     * Returns the builder for the settings used for calls to updatePrincipalAccessBoundaryPolicy.
     */
    public OperationCallSettings.Builder<
            UpdatePrincipalAccessBoundaryPolicyRequest,
            PrincipalAccessBoundaryPolicy,
            OperationMetadata>
        updatePrincipalAccessBoundaryPolicyOperationSettings() {
      return updatePrincipalAccessBoundaryPolicyOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to deletePrincipalAccessBoundaryPolicy.
     */
    public UnaryCallSettings.Builder<DeletePrincipalAccessBoundaryPolicyRequest, Operation>
        deletePrincipalAccessBoundaryPolicySettings() {
      return deletePrincipalAccessBoundaryPolicySettings;
    }

    /**
     * Returns the builder for the settings used for calls to deletePrincipalAccessBoundaryPolicy.
     */
    public OperationCallSettings.Builder<
            DeletePrincipalAccessBoundaryPolicyRequest, Empty, OperationMetadata>
        deletePrincipalAccessBoundaryPolicyOperationSettings() {
      return deletePrincipalAccessBoundaryPolicyOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to listPrincipalAccessBoundaryPolicies.
     */
    public PagedCallSettings.Builder<
            ListPrincipalAccessBoundaryPoliciesRequest,
            ListPrincipalAccessBoundaryPoliciesResponse,
            ListPrincipalAccessBoundaryPoliciesPagedResponse>
        listPrincipalAccessBoundaryPoliciesSettings() {
      return listPrincipalAccessBoundaryPoliciesSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * searchPrincipalAccessBoundaryPolicyBindings.
     */
    public PagedCallSettings.Builder<
            SearchPrincipalAccessBoundaryPolicyBindingsRequest,
            SearchPrincipalAccessBoundaryPolicyBindingsResponse,
            SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse>
        searchPrincipalAccessBoundaryPolicyBindingsSettings() {
      return searchPrincipalAccessBoundaryPolicyBindingsSettings;
    }

    @Override
    public PrincipalAccessBoundaryPoliciesStubSettings build() throws IOException {
      return new PrincipalAccessBoundaryPoliciesStubSettings(this);
    }
  }
}
