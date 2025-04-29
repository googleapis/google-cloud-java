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

package google.cloud.chronicle.v1.stub;

import static google.cloud.chronicle.v1.RuleServiceClient.ListRetrohuntsPagedResponse;
import static google.cloud.chronicle.v1.RuleServiceClient.ListRuleDeploymentsPagedResponse;
import static google.cloud.chronicle.v1.RuleServiceClient.ListRuleRevisionsPagedResponse;
import static google.cloud.chronicle.v1.RuleServiceClient.ListRulesPagedResponse;

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
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import google.cloud.chronicle.v1.CreateRetrohuntRequest;
import google.cloud.chronicle.v1.CreateRuleRequest;
import google.cloud.chronicle.v1.DeleteRuleRequest;
import google.cloud.chronicle.v1.GetRetrohuntRequest;
import google.cloud.chronicle.v1.GetRuleDeploymentRequest;
import google.cloud.chronicle.v1.GetRuleRequest;
import google.cloud.chronicle.v1.ListRetrohuntsRequest;
import google.cloud.chronicle.v1.ListRetrohuntsResponse;
import google.cloud.chronicle.v1.ListRuleDeploymentsRequest;
import google.cloud.chronicle.v1.ListRuleDeploymentsResponse;
import google.cloud.chronicle.v1.ListRuleRevisionsRequest;
import google.cloud.chronicle.v1.ListRuleRevisionsResponse;
import google.cloud.chronicle.v1.ListRulesRequest;
import google.cloud.chronicle.v1.ListRulesResponse;
import google.cloud.chronicle.v1.Retrohunt;
import google.cloud.chronicle.v1.RetrohuntMetadata;
import google.cloud.chronicle.v1.Rule;
import google.cloud.chronicle.v1.RuleDeployment;
import google.cloud.chronicle.v1.UpdateRuleDeploymentRequest;
import google.cloud.chronicle.v1.UpdateRuleRequest;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RuleServiceStub}.
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
 * of createRule:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RuleServiceStubSettings.Builder ruleServiceSettingsBuilder =
 *     RuleServiceStubSettings.newBuilder();
 * ruleServiceSettingsBuilder
 *     .createRuleSettings()
 *     .setRetrySettings(
 *         ruleServiceSettingsBuilder
 *             .createRuleSettings()
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
 * RuleServiceStubSettings ruleServiceSettings = ruleServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createRetrohunt:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RuleServiceStubSettings.Builder ruleServiceSettingsBuilder =
 *     RuleServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * ruleServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RuleServiceStubSettings extends StubSettings<RuleServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateRuleRequest, Rule> createRuleSettings;
  private final UnaryCallSettings<GetRuleRequest, Rule> getRuleSettings;
  private final PagedCallSettings<ListRulesRequest, ListRulesResponse, ListRulesPagedResponse>
      listRulesSettings;
  private final UnaryCallSettings<UpdateRuleRequest, Rule> updateRuleSettings;
  private final UnaryCallSettings<DeleteRuleRequest, Empty> deleteRuleSettings;
  private final PagedCallSettings<
          ListRuleRevisionsRequest, ListRuleRevisionsResponse, ListRuleRevisionsPagedResponse>
      listRuleRevisionsSettings;
  private final UnaryCallSettings<CreateRetrohuntRequest, Operation> createRetrohuntSettings;
  private final OperationCallSettings<CreateRetrohuntRequest, Retrohunt, RetrohuntMetadata>
      createRetrohuntOperationSettings;
  private final UnaryCallSettings<GetRetrohuntRequest, Retrohunt> getRetrohuntSettings;
  private final PagedCallSettings<
          ListRetrohuntsRequest, ListRetrohuntsResponse, ListRetrohuntsPagedResponse>
      listRetrohuntsSettings;
  private final UnaryCallSettings<GetRuleDeploymentRequest, RuleDeployment>
      getRuleDeploymentSettings;
  private final PagedCallSettings<
          ListRuleDeploymentsRequest, ListRuleDeploymentsResponse, ListRuleDeploymentsPagedResponse>
      listRuleDeploymentsSettings;
  private final UnaryCallSettings<UpdateRuleDeploymentRequest, RuleDeployment>
      updateRuleDeploymentSettings;

  private static final PagedListDescriptor<ListRulesRequest, ListRulesResponse, Rule>
      LIST_RULES_PAGE_STR_DESC =
          new PagedListDescriptor<ListRulesRequest, ListRulesResponse, Rule>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRulesRequest injectToken(ListRulesRequest payload, String token) {
              return ListRulesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRulesRequest injectPageSize(ListRulesRequest payload, int pageSize) {
              return ListRulesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRulesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRulesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Rule> extractResources(ListRulesResponse payload) {
              return payload.getRulesList();
            }
          };

  private static final PagedListDescriptor<
          ListRuleRevisionsRequest, ListRuleRevisionsResponse, Rule>
      LIST_RULE_REVISIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListRuleRevisionsRequest, ListRuleRevisionsResponse, Rule>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRuleRevisionsRequest injectToken(
                ListRuleRevisionsRequest payload, String token) {
              return ListRuleRevisionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRuleRevisionsRequest injectPageSize(
                ListRuleRevisionsRequest payload, int pageSize) {
              return ListRuleRevisionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRuleRevisionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRuleRevisionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Rule> extractResources(ListRuleRevisionsResponse payload) {
              return payload.getRulesList();
            }
          };

  private static final PagedListDescriptor<ListRetrohuntsRequest, ListRetrohuntsResponse, Retrohunt>
      LIST_RETROHUNTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListRetrohuntsRequest, ListRetrohuntsResponse, Retrohunt>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRetrohuntsRequest injectToken(ListRetrohuntsRequest payload, String token) {
              return ListRetrohuntsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRetrohuntsRequest injectPageSize(
                ListRetrohuntsRequest payload, int pageSize) {
              return ListRetrohuntsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRetrohuntsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRetrohuntsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Retrohunt> extractResources(ListRetrohuntsResponse payload) {
              return payload.getRetrohuntsList();
            }
          };

  private static final PagedListDescriptor<
          ListRuleDeploymentsRequest, ListRuleDeploymentsResponse, RuleDeployment>
      LIST_RULE_DEPLOYMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRuleDeploymentsRequest, ListRuleDeploymentsResponse, RuleDeployment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRuleDeploymentsRequest injectToken(
                ListRuleDeploymentsRequest payload, String token) {
              return ListRuleDeploymentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRuleDeploymentsRequest injectPageSize(
                ListRuleDeploymentsRequest payload, int pageSize) {
              return ListRuleDeploymentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRuleDeploymentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRuleDeploymentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<RuleDeployment> extractResources(ListRuleDeploymentsResponse payload) {
              return payload.getRuleDeploymentsList();
            }
          };

  private static final PagedListResponseFactory<
          ListRulesRequest, ListRulesResponse, ListRulesPagedResponse>
      LIST_RULES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRulesRequest, ListRulesResponse, ListRulesPagedResponse>() {
            @Override
            public ApiFuture<ListRulesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRulesRequest, ListRulesResponse> callable,
                ListRulesRequest request,
                ApiCallContext context,
                ApiFuture<ListRulesResponse> futureResponse) {
              PageContext<ListRulesRequest, ListRulesResponse, Rule> pageContext =
                  PageContext.create(callable, LIST_RULES_PAGE_STR_DESC, request, context);
              return ListRulesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRuleRevisionsRequest, ListRuleRevisionsResponse, ListRuleRevisionsPagedResponse>
      LIST_RULE_REVISIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRuleRevisionsRequest,
              ListRuleRevisionsResponse,
              ListRuleRevisionsPagedResponse>() {
            @Override
            public ApiFuture<ListRuleRevisionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRuleRevisionsRequest, ListRuleRevisionsResponse> callable,
                ListRuleRevisionsRequest request,
                ApiCallContext context,
                ApiFuture<ListRuleRevisionsResponse> futureResponse) {
              PageContext<ListRuleRevisionsRequest, ListRuleRevisionsResponse, Rule> pageContext =
                  PageContext.create(callable, LIST_RULE_REVISIONS_PAGE_STR_DESC, request, context);
              return ListRuleRevisionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRetrohuntsRequest, ListRetrohuntsResponse, ListRetrohuntsPagedResponse>
      LIST_RETROHUNTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRetrohuntsRequest, ListRetrohuntsResponse, ListRetrohuntsPagedResponse>() {
            @Override
            public ApiFuture<ListRetrohuntsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRetrohuntsRequest, ListRetrohuntsResponse> callable,
                ListRetrohuntsRequest request,
                ApiCallContext context,
                ApiFuture<ListRetrohuntsResponse> futureResponse) {
              PageContext<ListRetrohuntsRequest, ListRetrohuntsResponse, Retrohunt> pageContext =
                  PageContext.create(callable, LIST_RETROHUNTS_PAGE_STR_DESC, request, context);
              return ListRetrohuntsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRuleDeploymentsRequest, ListRuleDeploymentsResponse, ListRuleDeploymentsPagedResponse>
      LIST_RULE_DEPLOYMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRuleDeploymentsRequest,
              ListRuleDeploymentsResponse,
              ListRuleDeploymentsPagedResponse>() {
            @Override
            public ApiFuture<ListRuleDeploymentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRuleDeploymentsRequest, ListRuleDeploymentsResponse> callable,
                ListRuleDeploymentsRequest request,
                ApiCallContext context,
                ApiFuture<ListRuleDeploymentsResponse> futureResponse) {
              PageContext<ListRuleDeploymentsRequest, ListRuleDeploymentsResponse, RuleDeployment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_RULE_DEPLOYMENTS_PAGE_STR_DESC, request, context);
              return ListRuleDeploymentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createRule. */
  public UnaryCallSettings<CreateRuleRequest, Rule> createRuleSettings() {
    return createRuleSettings;
  }

  /** Returns the object with the settings used for calls to getRule. */
  public UnaryCallSettings<GetRuleRequest, Rule> getRuleSettings() {
    return getRuleSettings;
  }

  /** Returns the object with the settings used for calls to listRules. */
  public PagedCallSettings<ListRulesRequest, ListRulesResponse, ListRulesPagedResponse>
      listRulesSettings() {
    return listRulesSettings;
  }

  /** Returns the object with the settings used for calls to updateRule. */
  public UnaryCallSettings<UpdateRuleRequest, Rule> updateRuleSettings() {
    return updateRuleSettings;
  }

  /** Returns the object with the settings used for calls to deleteRule. */
  public UnaryCallSettings<DeleteRuleRequest, Empty> deleteRuleSettings() {
    return deleteRuleSettings;
  }

  /** Returns the object with the settings used for calls to listRuleRevisions. */
  public PagedCallSettings<
          ListRuleRevisionsRequest, ListRuleRevisionsResponse, ListRuleRevisionsPagedResponse>
      listRuleRevisionsSettings() {
    return listRuleRevisionsSettings;
  }

  /** Returns the object with the settings used for calls to createRetrohunt. */
  public UnaryCallSettings<CreateRetrohuntRequest, Operation> createRetrohuntSettings() {
    return createRetrohuntSettings;
  }

  /** Returns the object with the settings used for calls to createRetrohunt. */
  public OperationCallSettings<CreateRetrohuntRequest, Retrohunt, RetrohuntMetadata>
      createRetrohuntOperationSettings() {
    return createRetrohuntOperationSettings;
  }

  /** Returns the object with the settings used for calls to getRetrohunt. */
  public UnaryCallSettings<GetRetrohuntRequest, Retrohunt> getRetrohuntSettings() {
    return getRetrohuntSettings;
  }

  /** Returns the object with the settings used for calls to listRetrohunts. */
  public PagedCallSettings<
          ListRetrohuntsRequest, ListRetrohuntsResponse, ListRetrohuntsPagedResponse>
      listRetrohuntsSettings() {
    return listRetrohuntsSettings;
  }

  /** Returns the object with the settings used for calls to getRuleDeployment. */
  public UnaryCallSettings<GetRuleDeploymentRequest, RuleDeployment> getRuleDeploymentSettings() {
    return getRuleDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to listRuleDeployments. */
  public PagedCallSettings<
          ListRuleDeploymentsRequest, ListRuleDeploymentsResponse, ListRuleDeploymentsPagedResponse>
      listRuleDeploymentsSettings() {
    return listRuleDeploymentsSettings;
  }

  /** Returns the object with the settings used for calls to updateRuleDeployment. */
  public UnaryCallSettings<UpdateRuleDeploymentRequest, RuleDeployment>
      updateRuleDeploymentSettings() {
    return updateRuleDeploymentSettings;
  }

  public RuleServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcRuleServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRuleServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(RuleServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(RuleServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RuleServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected RuleServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createRuleSettings = settingsBuilder.createRuleSettings().build();
    getRuleSettings = settingsBuilder.getRuleSettings().build();
    listRulesSettings = settingsBuilder.listRulesSettings().build();
    updateRuleSettings = settingsBuilder.updateRuleSettings().build();
    deleteRuleSettings = settingsBuilder.deleteRuleSettings().build();
    listRuleRevisionsSettings = settingsBuilder.listRuleRevisionsSettings().build();
    createRetrohuntSettings = settingsBuilder.createRetrohuntSettings().build();
    createRetrohuntOperationSettings = settingsBuilder.createRetrohuntOperationSettings().build();
    getRetrohuntSettings = settingsBuilder.getRetrohuntSettings().build();
    listRetrohuntsSettings = settingsBuilder.listRetrohuntsSettings().build();
    getRuleDeploymentSettings = settingsBuilder.getRuleDeploymentSettings().build();
    listRuleDeploymentsSettings = settingsBuilder.listRuleDeploymentsSettings().build();
    updateRuleDeploymentSettings = settingsBuilder.updateRuleDeploymentSettings().build();
  }

  /** Builder for RuleServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<RuleServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateRuleRequest, Rule> createRuleSettings;
    private final UnaryCallSettings.Builder<GetRuleRequest, Rule> getRuleSettings;
    private final PagedCallSettings.Builder<
            ListRulesRequest, ListRulesResponse, ListRulesPagedResponse>
        listRulesSettings;
    private final UnaryCallSettings.Builder<UpdateRuleRequest, Rule> updateRuleSettings;
    private final UnaryCallSettings.Builder<DeleteRuleRequest, Empty> deleteRuleSettings;
    private final PagedCallSettings.Builder<
            ListRuleRevisionsRequest, ListRuleRevisionsResponse, ListRuleRevisionsPagedResponse>
        listRuleRevisionsSettings;
    private final UnaryCallSettings.Builder<CreateRetrohuntRequest, Operation>
        createRetrohuntSettings;
    private final OperationCallSettings.Builder<
            CreateRetrohuntRequest, Retrohunt, RetrohuntMetadata>
        createRetrohuntOperationSettings;
    private final UnaryCallSettings.Builder<GetRetrohuntRequest, Retrohunt> getRetrohuntSettings;
    private final PagedCallSettings.Builder<
            ListRetrohuntsRequest, ListRetrohuntsResponse, ListRetrohuntsPagedResponse>
        listRetrohuntsSettings;
    private final UnaryCallSettings.Builder<GetRuleDeploymentRequest, RuleDeployment>
        getRuleDeploymentSettings;
    private final PagedCallSettings.Builder<
            ListRuleDeploymentsRequest,
            ListRuleDeploymentsResponse,
            ListRuleDeploymentsPagedResponse>
        listRuleDeploymentsSettings;
    private final UnaryCallSettings.Builder<UpdateRuleDeploymentRequest, RuleDeployment>
        updateRuleDeploymentSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_3_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "retry_policy_2_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_4_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_3_params", settings);
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
      definitions.put("retry_policy_0_params", settings);
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
      definitions.put("retry_policy_2_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_4_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRulesSettings = PagedCallSettings.newBuilder(LIST_RULES_PAGE_STR_FACT);
      updateRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRuleRevisionsSettings = PagedCallSettings.newBuilder(LIST_RULE_REVISIONS_PAGE_STR_FACT);
      createRetrohuntSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRetrohuntOperationSettings = OperationCallSettings.newBuilder();
      getRetrohuntSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRetrohuntsSettings = PagedCallSettings.newBuilder(LIST_RETROHUNTS_PAGE_STR_FACT);
      getRuleDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRuleDeploymentsSettings =
          PagedCallSettings.newBuilder(LIST_RULE_DEPLOYMENTS_PAGE_STR_FACT);
      updateRuleDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createRuleSettings,
              getRuleSettings,
              listRulesSettings,
              updateRuleSettings,
              deleteRuleSettings,
              listRuleRevisionsSettings,
              createRetrohuntSettings,
              getRetrohuntSettings,
              listRetrohuntsSettings,
              getRuleDeploymentSettings,
              listRuleDeploymentsSettings,
              updateRuleDeploymentSettings);
      initDefaults(this);
    }

    protected Builder(RuleServiceStubSettings settings) {
      super(settings);

      createRuleSettings = settings.createRuleSettings.toBuilder();
      getRuleSettings = settings.getRuleSettings.toBuilder();
      listRulesSettings = settings.listRulesSettings.toBuilder();
      updateRuleSettings = settings.updateRuleSettings.toBuilder();
      deleteRuleSettings = settings.deleteRuleSettings.toBuilder();
      listRuleRevisionsSettings = settings.listRuleRevisionsSettings.toBuilder();
      createRetrohuntSettings = settings.createRetrohuntSettings.toBuilder();
      createRetrohuntOperationSettings = settings.createRetrohuntOperationSettings.toBuilder();
      getRetrohuntSettings = settings.getRetrohuntSettings.toBuilder();
      listRetrohuntsSettings = settings.listRetrohuntsSettings.toBuilder();
      getRuleDeploymentSettings = settings.getRuleDeploymentSettings.toBuilder();
      listRuleDeploymentsSettings = settings.listRuleDeploymentsSettings.toBuilder();
      updateRuleDeploymentSettings = settings.updateRuleDeploymentSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createRuleSettings,
              getRuleSettings,
              listRulesSettings,
              updateRuleSettings,
              deleteRuleSettings,
              listRuleRevisionsSettings,
              createRetrohuntSettings,
              getRetrohuntSettings,
              listRetrohuntsSettings,
              getRuleDeploymentSettings,
              listRuleDeploymentsSettings,
              updateRuleDeploymentSettings);
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
          .createRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .getRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listRulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .updateRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

      builder
          .deleteRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .listRuleRevisionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .createRetrohuntSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

      builder
          .getRetrohuntSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listRetrohuntsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRuleDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .listRuleDeploymentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .updateRuleDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

      builder
          .createRetrohuntOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateRetrohuntRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Retrohunt.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(RetrohuntMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(900000L))
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

    /** Returns the builder for the settings used for calls to createRule. */
    public UnaryCallSettings.Builder<CreateRuleRequest, Rule> createRuleSettings() {
      return createRuleSettings;
    }

    /** Returns the builder for the settings used for calls to getRule. */
    public UnaryCallSettings.Builder<GetRuleRequest, Rule> getRuleSettings() {
      return getRuleSettings;
    }

    /** Returns the builder for the settings used for calls to listRules. */
    public PagedCallSettings.Builder<ListRulesRequest, ListRulesResponse, ListRulesPagedResponse>
        listRulesSettings() {
      return listRulesSettings;
    }

    /** Returns the builder for the settings used for calls to updateRule. */
    public UnaryCallSettings.Builder<UpdateRuleRequest, Rule> updateRuleSettings() {
      return updateRuleSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRule. */
    public UnaryCallSettings.Builder<DeleteRuleRequest, Empty> deleteRuleSettings() {
      return deleteRuleSettings;
    }

    /** Returns the builder for the settings used for calls to listRuleRevisions. */
    public PagedCallSettings.Builder<
            ListRuleRevisionsRequest, ListRuleRevisionsResponse, ListRuleRevisionsPagedResponse>
        listRuleRevisionsSettings() {
      return listRuleRevisionsSettings;
    }

    /** Returns the builder for the settings used for calls to createRetrohunt. */
    public UnaryCallSettings.Builder<CreateRetrohuntRequest, Operation> createRetrohuntSettings() {
      return createRetrohuntSettings;
    }

    /** Returns the builder for the settings used for calls to createRetrohunt. */
    public OperationCallSettings.Builder<CreateRetrohuntRequest, Retrohunt, RetrohuntMetadata>
        createRetrohuntOperationSettings() {
      return createRetrohuntOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getRetrohunt. */
    public UnaryCallSettings.Builder<GetRetrohuntRequest, Retrohunt> getRetrohuntSettings() {
      return getRetrohuntSettings;
    }

    /** Returns the builder for the settings used for calls to listRetrohunts. */
    public PagedCallSettings.Builder<
            ListRetrohuntsRequest, ListRetrohuntsResponse, ListRetrohuntsPagedResponse>
        listRetrohuntsSettings() {
      return listRetrohuntsSettings;
    }

    /** Returns the builder for the settings used for calls to getRuleDeployment. */
    public UnaryCallSettings.Builder<GetRuleDeploymentRequest, RuleDeployment>
        getRuleDeploymentSettings() {
      return getRuleDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to listRuleDeployments. */
    public PagedCallSettings.Builder<
            ListRuleDeploymentsRequest,
            ListRuleDeploymentsResponse,
            ListRuleDeploymentsPagedResponse>
        listRuleDeploymentsSettings() {
      return listRuleDeploymentsSettings;
    }

    /** Returns the builder for the settings used for calls to updateRuleDeployment. */
    public UnaryCallSettings.Builder<UpdateRuleDeploymentRequest, RuleDeployment>
        updateRuleDeploymentSettings() {
      return updateRuleDeploymentSettings;
    }

    @Override
    public RuleServiceStubSettings build() throws IOException {
      return new RuleServiceStubSettings(this);
    }
  }
}
