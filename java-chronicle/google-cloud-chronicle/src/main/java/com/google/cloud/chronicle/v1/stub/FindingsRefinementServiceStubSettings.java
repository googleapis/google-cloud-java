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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.FindingsRefinementServiceClient.ListAllFindingsRefinementDeploymentsPagedResponse;
import static com.google.cloud.chronicle.v1.FindingsRefinementServiceClient.ListFindingsRefinementsPagedResponse;

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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesRequest;
import com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesResponse;
import com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityRequest;
import com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityResponse;
import com.google.cloud.chronicle.v1.CreateFindingsRefinementRequest;
import com.google.cloud.chronicle.v1.FindingsRefinement;
import com.google.cloud.chronicle.v1.FindingsRefinementDeployment;
import com.google.cloud.chronicle.v1.GetFindingsRefinementDeploymentRequest;
import com.google.cloud.chronicle.v1.GetFindingsRefinementRequest;
import com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsRequest;
import com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsResponse;
import com.google.cloud.chronicle.v1.ListFindingsRefinementsRequest;
import com.google.cloud.chronicle.v1.ListFindingsRefinementsResponse;
import com.google.cloud.chronicle.v1.UpdateFindingsRefinementDeploymentRequest;
import com.google.cloud.chronicle.v1.UpdateFindingsRefinementRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link FindingsRefinementServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (chronicle.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getFindingsRefinement:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FindingsRefinementServiceStubSettings.Builder findingsRefinementServiceSettingsBuilder =
 *     FindingsRefinementServiceStubSettings.newBuilder();
 * findingsRefinementServiceSettingsBuilder
 *     .getFindingsRefinementSettings()
 *     .setRetrySettings(
 *         findingsRefinementServiceSettingsBuilder
 *             .getFindingsRefinementSettings()
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
 * FindingsRefinementServiceStubSettings findingsRefinementServiceSettings =
 *     findingsRefinementServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class FindingsRefinementServiceStubSettings
    extends StubSettings<FindingsRefinementServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/chronicle")
          .add("https://www.googleapis.com/auth/chronicle.readonly")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<GetFindingsRefinementRequest, FindingsRefinement>
      getFindingsRefinementSettings;
  private final PagedCallSettings<
          ListFindingsRefinementsRequest,
          ListFindingsRefinementsResponse,
          ListFindingsRefinementsPagedResponse>
      listFindingsRefinementsSettings;
  private final UnaryCallSettings<CreateFindingsRefinementRequest, FindingsRefinement>
      createFindingsRefinementSettings;
  private final UnaryCallSettings<UpdateFindingsRefinementRequest, FindingsRefinement>
      updateFindingsRefinementSettings;
  private final UnaryCallSettings<
          GetFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      getFindingsRefinementDeploymentSettings;
  private final UnaryCallSettings<
          UpdateFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      updateFindingsRefinementDeploymentSettings;
  private final PagedCallSettings<
          ListAllFindingsRefinementDeploymentsRequest,
          ListAllFindingsRefinementDeploymentsResponse,
          ListAllFindingsRefinementDeploymentsPagedResponse>
      listAllFindingsRefinementDeploymentsSettings;
  private final UnaryCallSettings<
          ComputeFindingsRefinementActivityRequest, ComputeFindingsRefinementActivityResponse>
      computeFindingsRefinementActivitySettings;
  private final UnaryCallSettings<
          ComputeAllFindingsRefinementActivitiesRequest,
          ComputeAllFindingsRefinementActivitiesResponse>
      computeAllFindingsRefinementActivitiesSettings;

  private static final PagedListDescriptor<
          ListFindingsRefinementsRequest, ListFindingsRefinementsResponse, FindingsRefinement>
      LIST_FINDINGS_REFINEMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFindingsRefinementsRequest,
              ListFindingsRefinementsResponse,
              FindingsRefinement>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFindingsRefinementsRequest injectToken(
                ListFindingsRefinementsRequest payload, String token) {
              return ListFindingsRefinementsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFindingsRefinementsRequest injectPageSize(
                ListFindingsRefinementsRequest payload, int pageSize) {
              return ListFindingsRefinementsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListFindingsRefinementsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFindingsRefinementsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FindingsRefinement> extractResources(
                ListFindingsRefinementsResponse payload) {
              return payload.getFindingsRefinementsList();
            }
          };

  private static final PagedListDescriptor<
          ListAllFindingsRefinementDeploymentsRequest,
          ListAllFindingsRefinementDeploymentsResponse,
          FindingsRefinementDeployment>
      LIST_ALL_FINDINGS_REFINEMENT_DEPLOYMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAllFindingsRefinementDeploymentsRequest,
              ListAllFindingsRefinementDeploymentsResponse,
              FindingsRefinementDeployment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAllFindingsRefinementDeploymentsRequest injectToken(
                ListAllFindingsRefinementDeploymentsRequest payload, String token) {
              return ListAllFindingsRefinementDeploymentsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListAllFindingsRefinementDeploymentsRequest injectPageSize(
                ListAllFindingsRefinementDeploymentsRequest payload, int pageSize) {
              return ListAllFindingsRefinementDeploymentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListAllFindingsRefinementDeploymentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAllFindingsRefinementDeploymentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FindingsRefinementDeployment> extractResources(
                ListAllFindingsRefinementDeploymentsResponse payload) {
              return payload.getAllFindingsRefinementDeploymentsList();
            }
          };

  private static final PagedListResponseFactory<
          ListFindingsRefinementsRequest,
          ListFindingsRefinementsResponse,
          ListFindingsRefinementsPagedResponse>
      LIST_FINDINGS_REFINEMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFindingsRefinementsRequest,
              ListFindingsRefinementsResponse,
              ListFindingsRefinementsPagedResponse>() {
            @Override
            public ApiFuture<ListFindingsRefinementsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFindingsRefinementsRequest, ListFindingsRefinementsResponse>
                    callable,
                ListFindingsRefinementsRequest request,
                ApiCallContext context,
                ApiFuture<ListFindingsRefinementsResponse> futureResponse) {
              PageContext<
                      ListFindingsRefinementsRequest,
                      ListFindingsRefinementsResponse,
                      FindingsRefinement>
                  pageContext =
                      PageContext.create(
                          callable, LIST_FINDINGS_REFINEMENTS_PAGE_STR_DESC, request, context);
              return ListFindingsRefinementsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAllFindingsRefinementDeploymentsRequest,
          ListAllFindingsRefinementDeploymentsResponse,
          ListAllFindingsRefinementDeploymentsPagedResponse>
      LIST_ALL_FINDINGS_REFINEMENT_DEPLOYMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAllFindingsRefinementDeploymentsRequest,
              ListAllFindingsRefinementDeploymentsResponse,
              ListAllFindingsRefinementDeploymentsPagedResponse>() {
            @Override
            public ApiFuture<ListAllFindingsRefinementDeploymentsPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListAllFindingsRefinementDeploymentsRequest,
                            ListAllFindingsRefinementDeploymentsResponse>
                        callable,
                    ListAllFindingsRefinementDeploymentsRequest request,
                    ApiCallContext context,
                    ApiFuture<ListAllFindingsRefinementDeploymentsResponse> futureResponse) {
              PageContext<
                      ListAllFindingsRefinementDeploymentsRequest,
                      ListAllFindingsRefinementDeploymentsResponse,
                      FindingsRefinementDeployment>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_ALL_FINDINGS_REFINEMENT_DEPLOYMENTS_PAGE_STR_DESC,
                          request,
                          context);
              return ListAllFindingsRefinementDeploymentsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getFindingsRefinement. */
  public UnaryCallSettings<GetFindingsRefinementRequest, FindingsRefinement>
      getFindingsRefinementSettings() {
    return getFindingsRefinementSettings;
  }

  /** Returns the object with the settings used for calls to listFindingsRefinements. */
  public PagedCallSettings<
          ListFindingsRefinementsRequest,
          ListFindingsRefinementsResponse,
          ListFindingsRefinementsPagedResponse>
      listFindingsRefinementsSettings() {
    return listFindingsRefinementsSettings;
  }

  /** Returns the object with the settings used for calls to createFindingsRefinement. */
  public UnaryCallSettings<CreateFindingsRefinementRequest, FindingsRefinement>
      createFindingsRefinementSettings() {
    return createFindingsRefinementSettings;
  }

  /** Returns the object with the settings used for calls to updateFindingsRefinement. */
  public UnaryCallSettings<UpdateFindingsRefinementRequest, FindingsRefinement>
      updateFindingsRefinementSettings() {
    return updateFindingsRefinementSettings;
  }

  /** Returns the object with the settings used for calls to getFindingsRefinementDeployment. */
  public UnaryCallSettings<GetFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      getFindingsRefinementDeploymentSettings() {
    return getFindingsRefinementDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to updateFindingsRefinementDeployment. */
  public UnaryCallSettings<UpdateFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      updateFindingsRefinementDeploymentSettings() {
    return updateFindingsRefinementDeploymentSettings;
  }

  /**
   * Returns the object with the settings used for calls to listAllFindingsRefinementDeployments.
   */
  public PagedCallSettings<
          ListAllFindingsRefinementDeploymentsRequest,
          ListAllFindingsRefinementDeploymentsResponse,
          ListAllFindingsRefinementDeploymentsPagedResponse>
      listAllFindingsRefinementDeploymentsSettings() {
    return listAllFindingsRefinementDeploymentsSettings;
  }

  /** Returns the object with the settings used for calls to computeFindingsRefinementActivity. */
  public UnaryCallSettings<
          ComputeFindingsRefinementActivityRequest, ComputeFindingsRefinementActivityResponse>
      computeFindingsRefinementActivitySettings() {
    return computeFindingsRefinementActivitySettings;
  }

  /**
   * Returns the object with the settings used for calls to computeAllFindingsRefinementActivities.
   */
  public UnaryCallSettings<
          ComputeAllFindingsRefinementActivitiesRequest,
          ComputeAllFindingsRefinementActivitiesResponse>
      computeAllFindingsRefinementActivitiesSettings() {
    return computeAllFindingsRefinementActivitiesSettings;
  }

  public FindingsRefinementServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcFindingsRefinementServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonFindingsRefinementServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "chronicle";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "chronicle.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "chronicle.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(FindingsRefinementServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(FindingsRefinementServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FindingsRefinementServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected FindingsRefinementServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getFindingsRefinementSettings = settingsBuilder.getFindingsRefinementSettings().build();
    listFindingsRefinementsSettings = settingsBuilder.listFindingsRefinementsSettings().build();
    createFindingsRefinementSettings = settingsBuilder.createFindingsRefinementSettings().build();
    updateFindingsRefinementSettings = settingsBuilder.updateFindingsRefinementSettings().build();
    getFindingsRefinementDeploymentSettings =
        settingsBuilder.getFindingsRefinementDeploymentSettings().build();
    updateFindingsRefinementDeploymentSettings =
        settingsBuilder.updateFindingsRefinementDeploymentSettings().build();
    listAllFindingsRefinementDeploymentsSettings =
        settingsBuilder.listAllFindingsRefinementDeploymentsSettings().build();
    computeFindingsRefinementActivitySettings =
        settingsBuilder.computeFindingsRefinementActivitySettings().build();
    computeAllFindingsRefinementActivitiesSettings =
        settingsBuilder.computeAllFindingsRefinementActivitiesSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-chronicle")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for FindingsRefinementServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<FindingsRefinementServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetFindingsRefinementRequest, FindingsRefinement>
        getFindingsRefinementSettings;
    private final PagedCallSettings.Builder<
            ListFindingsRefinementsRequest,
            ListFindingsRefinementsResponse,
            ListFindingsRefinementsPagedResponse>
        listFindingsRefinementsSettings;
    private final UnaryCallSettings.Builder<CreateFindingsRefinementRequest, FindingsRefinement>
        createFindingsRefinementSettings;
    private final UnaryCallSettings.Builder<UpdateFindingsRefinementRequest, FindingsRefinement>
        updateFindingsRefinementSettings;
    private final UnaryCallSettings.Builder<
            GetFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
        getFindingsRefinementDeploymentSettings;
    private final UnaryCallSettings.Builder<
            UpdateFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
        updateFindingsRefinementDeploymentSettings;
    private final PagedCallSettings.Builder<
            ListAllFindingsRefinementDeploymentsRequest,
            ListAllFindingsRefinementDeploymentsResponse,
            ListAllFindingsRefinementDeploymentsPagedResponse>
        listAllFindingsRefinementDeploymentsSettings;
    private final UnaryCallSettings.Builder<
            ComputeFindingsRefinementActivityRequest, ComputeFindingsRefinementActivityResponse>
        computeFindingsRefinementActivitySettings;
    private final UnaryCallSettings.Builder<
            ComputeAllFindingsRefinementActivitiesRequest,
            ComputeAllFindingsRefinementActivitiesResponse>
        computeAllFindingsRefinementActivitiesSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_10_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "retry_policy_13_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "retry_policy_11_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_14_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_12_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_10_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_13_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(120000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(120000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(120000L))
              .setTotalTimeoutDuration(Duration.ofMillis(120000L))
              .build();
      definitions.put("retry_policy_11_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(120000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(120000L))
              .setTotalTimeoutDuration(Duration.ofMillis(120000L))
              .build();
      definitions.put("no_retry_14_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(600000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_12_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      getFindingsRefinementSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFindingsRefinementsSettings =
          PagedCallSettings.newBuilder(LIST_FINDINGS_REFINEMENTS_PAGE_STR_FACT);
      createFindingsRefinementSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFindingsRefinementSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getFindingsRefinementDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFindingsRefinementDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAllFindingsRefinementDeploymentsSettings =
          PagedCallSettings.newBuilder(LIST_ALL_FINDINGS_REFINEMENT_DEPLOYMENTS_PAGE_STR_FACT);
      computeFindingsRefinementActivitySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      computeAllFindingsRefinementActivitiesSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getFindingsRefinementSettings,
              listFindingsRefinementsSettings,
              createFindingsRefinementSettings,
              updateFindingsRefinementSettings,
              getFindingsRefinementDeploymentSettings,
              updateFindingsRefinementDeploymentSettings,
              listAllFindingsRefinementDeploymentsSettings,
              computeFindingsRefinementActivitySettings,
              computeAllFindingsRefinementActivitiesSettings);
      initDefaults(this);
    }

    protected Builder(FindingsRefinementServiceStubSettings settings) {
      super(settings);

      getFindingsRefinementSettings = settings.getFindingsRefinementSettings.toBuilder();
      listFindingsRefinementsSettings = settings.listFindingsRefinementsSettings.toBuilder();
      createFindingsRefinementSettings = settings.createFindingsRefinementSettings.toBuilder();
      updateFindingsRefinementSettings = settings.updateFindingsRefinementSettings.toBuilder();
      getFindingsRefinementDeploymentSettings =
          settings.getFindingsRefinementDeploymentSettings.toBuilder();
      updateFindingsRefinementDeploymentSettings =
          settings.updateFindingsRefinementDeploymentSettings.toBuilder();
      listAllFindingsRefinementDeploymentsSettings =
          settings.listAllFindingsRefinementDeploymentsSettings.toBuilder();
      computeFindingsRefinementActivitySettings =
          settings.computeFindingsRefinementActivitySettings.toBuilder();
      computeAllFindingsRefinementActivitiesSettings =
          settings.computeAllFindingsRefinementActivitiesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getFindingsRefinementSettings,
              listFindingsRefinementsSettings,
              createFindingsRefinementSettings,
              updateFindingsRefinementSettings,
              getFindingsRefinementDeploymentSettings,
              updateFindingsRefinementDeploymentSettings,
              listAllFindingsRefinementDeploymentsSettings,
              computeFindingsRefinementActivitySettings,
              computeAllFindingsRefinementActivitiesSettings);
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
          .getFindingsRefinementSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_10_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_10_params"));

      builder
          .listFindingsRefinementsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_10_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_10_params"));

      builder
          .createFindingsRefinementSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_13_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_13_params"));

      builder
          .updateFindingsRefinementSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_13_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_13_params"));

      builder
          .getFindingsRefinementDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_11_params"));

      builder
          .updateFindingsRefinementDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_14_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_14_params"));

      builder
          .listAllFindingsRefinementDeploymentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_11_params"));

      builder
          .computeFindingsRefinementActivitySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_12_params"));

      builder
          .computeAllFindingsRefinementActivitiesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_12_params"));

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

    /** Returns the builder for the settings used for calls to getFindingsRefinement. */
    public UnaryCallSettings.Builder<GetFindingsRefinementRequest, FindingsRefinement>
        getFindingsRefinementSettings() {
      return getFindingsRefinementSettings;
    }

    /** Returns the builder for the settings used for calls to listFindingsRefinements. */
    public PagedCallSettings.Builder<
            ListFindingsRefinementsRequest,
            ListFindingsRefinementsResponse,
            ListFindingsRefinementsPagedResponse>
        listFindingsRefinementsSettings() {
      return listFindingsRefinementsSettings;
    }

    /** Returns the builder for the settings used for calls to createFindingsRefinement. */
    public UnaryCallSettings.Builder<CreateFindingsRefinementRequest, FindingsRefinement>
        createFindingsRefinementSettings() {
      return createFindingsRefinementSettings;
    }

    /** Returns the builder for the settings used for calls to updateFindingsRefinement. */
    public UnaryCallSettings.Builder<UpdateFindingsRefinementRequest, FindingsRefinement>
        updateFindingsRefinementSettings() {
      return updateFindingsRefinementSettings;
    }

    /** Returns the builder for the settings used for calls to getFindingsRefinementDeployment. */
    public UnaryCallSettings.Builder<
            GetFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
        getFindingsRefinementDeploymentSettings() {
      return getFindingsRefinementDeploymentSettings;
    }

    /**
     * Returns the builder for the settings used for calls to updateFindingsRefinementDeployment.
     */
    public UnaryCallSettings.Builder<
            UpdateFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
        updateFindingsRefinementDeploymentSettings() {
      return updateFindingsRefinementDeploymentSettings;
    }

    /**
     * Returns the builder for the settings used for calls to listAllFindingsRefinementDeployments.
     */
    public PagedCallSettings.Builder<
            ListAllFindingsRefinementDeploymentsRequest,
            ListAllFindingsRefinementDeploymentsResponse,
            ListAllFindingsRefinementDeploymentsPagedResponse>
        listAllFindingsRefinementDeploymentsSettings() {
      return listAllFindingsRefinementDeploymentsSettings;
    }

    /** Returns the builder for the settings used for calls to computeFindingsRefinementActivity. */
    public UnaryCallSettings.Builder<
            ComputeFindingsRefinementActivityRequest, ComputeFindingsRefinementActivityResponse>
        computeFindingsRefinementActivitySettings() {
      return computeFindingsRefinementActivitySettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * computeAllFindingsRefinementActivities.
     */
    public UnaryCallSettings.Builder<
            ComputeAllFindingsRefinementActivitiesRequest,
            ComputeAllFindingsRefinementActivitiesResponse>
        computeAllFindingsRefinementActivitiesSettings() {
      return computeAllFindingsRefinementActivitiesSettings;
    }

    @Override
    public FindingsRefinementServiceStubSettings build() throws IOException {
      return new FindingsRefinementServiceStubSettings(this);
    }
  }
}
