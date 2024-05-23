/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.visionai.v1.stub;

import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListAnalysesPagedResponse;
import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListOperatorsPagedResponse;
import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListProcessesPagedResponse;
import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListPublicOperatorsPagedResponse;

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
import com.google.cloud.visionai.v1.Analysis;
import com.google.cloud.visionai.v1.BatchRunProcessRequest;
import com.google.cloud.visionai.v1.BatchRunProcessResponse;
import com.google.cloud.visionai.v1.CreateAnalysisRequest;
import com.google.cloud.visionai.v1.CreateOperatorRequest;
import com.google.cloud.visionai.v1.CreateProcessRequest;
import com.google.cloud.visionai.v1.DeleteAnalysisRequest;
import com.google.cloud.visionai.v1.DeleteOperatorRequest;
import com.google.cloud.visionai.v1.DeleteProcessRequest;
import com.google.cloud.visionai.v1.GetAnalysisRequest;
import com.google.cloud.visionai.v1.GetOperatorRequest;
import com.google.cloud.visionai.v1.GetProcessRequest;
import com.google.cloud.visionai.v1.ListAnalysesRequest;
import com.google.cloud.visionai.v1.ListAnalysesResponse;
import com.google.cloud.visionai.v1.ListOperatorsRequest;
import com.google.cloud.visionai.v1.ListOperatorsResponse;
import com.google.cloud.visionai.v1.ListProcessesRequest;
import com.google.cloud.visionai.v1.ListProcessesResponse;
import com.google.cloud.visionai.v1.ListPublicOperatorsRequest;
import com.google.cloud.visionai.v1.ListPublicOperatorsResponse;
import com.google.cloud.visionai.v1.OperationMetadata;
import com.google.cloud.visionai.v1.Operator;
import com.google.cloud.visionai.v1.Process;
import com.google.cloud.visionai.v1.ResolveOperatorInfoRequest;
import com.google.cloud.visionai.v1.ResolveOperatorInfoResponse;
import com.google.cloud.visionai.v1.UpdateAnalysisRequest;
import com.google.cloud.visionai.v1.UpdateOperatorRequest;
import com.google.cloud.visionai.v1.UpdateProcessRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link LiveVideoAnalyticsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (visionai.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of resolveOperatorInfo to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LiveVideoAnalyticsStubSettings.Builder liveVideoAnalyticsSettingsBuilder =
 *     LiveVideoAnalyticsStubSettings.newBuilder();
 * liveVideoAnalyticsSettingsBuilder
 *     .resolveOperatorInfoSettings()
 *     .setRetrySettings(
 *         liveVideoAnalyticsSettingsBuilder
 *             .resolveOperatorInfoSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * LiveVideoAnalyticsStubSettings liveVideoAnalyticsSettings =
 *     liveVideoAnalyticsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class LiveVideoAnalyticsStubSettings extends StubSettings<LiveVideoAnalyticsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListPublicOperatorsRequest, ListPublicOperatorsResponse, ListPublicOperatorsPagedResponse>
      listPublicOperatorsSettings;
  private final UnaryCallSettings<ResolveOperatorInfoRequest, ResolveOperatorInfoResponse>
      resolveOperatorInfoSettings;
  private final PagedCallSettings<
          ListOperatorsRequest, ListOperatorsResponse, ListOperatorsPagedResponse>
      listOperatorsSettings;
  private final UnaryCallSettings<GetOperatorRequest, Operator> getOperatorSettings;
  private final UnaryCallSettings<CreateOperatorRequest, Operation> createOperatorSettings;
  private final OperationCallSettings<CreateOperatorRequest, Operator, OperationMetadata>
      createOperatorOperationSettings;
  private final UnaryCallSettings<UpdateOperatorRequest, Operation> updateOperatorSettings;
  private final OperationCallSettings<UpdateOperatorRequest, Operator, OperationMetadata>
      updateOperatorOperationSettings;
  private final UnaryCallSettings<DeleteOperatorRequest, Operation> deleteOperatorSettings;
  private final OperationCallSettings<DeleteOperatorRequest, Empty, OperationMetadata>
      deleteOperatorOperationSettings;
  private final PagedCallSettings<
          ListAnalysesRequest, ListAnalysesResponse, ListAnalysesPagedResponse>
      listAnalysesSettings;
  private final UnaryCallSettings<GetAnalysisRequest, Analysis> getAnalysisSettings;
  private final UnaryCallSettings<CreateAnalysisRequest, Operation> createAnalysisSettings;
  private final OperationCallSettings<CreateAnalysisRequest, Analysis, OperationMetadata>
      createAnalysisOperationSettings;
  private final UnaryCallSettings<UpdateAnalysisRequest, Operation> updateAnalysisSettings;
  private final OperationCallSettings<UpdateAnalysisRequest, Analysis, OperationMetadata>
      updateAnalysisOperationSettings;
  private final UnaryCallSettings<DeleteAnalysisRequest, Operation> deleteAnalysisSettings;
  private final OperationCallSettings<DeleteAnalysisRequest, Empty, OperationMetadata>
      deleteAnalysisOperationSettings;
  private final PagedCallSettings<
          ListProcessesRequest, ListProcessesResponse, ListProcessesPagedResponse>
      listProcessesSettings;
  private final UnaryCallSettings<GetProcessRequest, Process> getProcessSettings;
  private final UnaryCallSettings<CreateProcessRequest, Operation> createProcessSettings;
  private final OperationCallSettings<CreateProcessRequest, Process, OperationMetadata>
      createProcessOperationSettings;
  private final UnaryCallSettings<UpdateProcessRequest, Operation> updateProcessSettings;
  private final OperationCallSettings<UpdateProcessRequest, Process, OperationMetadata>
      updateProcessOperationSettings;
  private final UnaryCallSettings<DeleteProcessRequest, Operation> deleteProcessSettings;
  private final OperationCallSettings<DeleteProcessRequest, Empty, OperationMetadata>
      deleteProcessOperationSettings;
  private final UnaryCallSettings<BatchRunProcessRequest, Operation> batchRunProcessSettings;
  private final OperationCallSettings<
          BatchRunProcessRequest, BatchRunProcessResponse, OperationMetadata>
      batchRunProcessOperationSettings;

  private static final PagedListDescriptor<
          ListPublicOperatorsRequest, ListPublicOperatorsResponse, Operator>
      LIST_PUBLIC_OPERATORS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPublicOperatorsRequest, ListPublicOperatorsResponse, Operator>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPublicOperatorsRequest injectToken(
                ListPublicOperatorsRequest payload, String token) {
              return ListPublicOperatorsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPublicOperatorsRequest injectPageSize(
                ListPublicOperatorsRequest payload, int pageSize) {
              return ListPublicOperatorsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPublicOperatorsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPublicOperatorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Operator> extractResources(ListPublicOperatorsResponse payload) {
              return payload.getOperatorsList() == null
                  ? ImmutableList.<Operator>of()
                  : payload.getOperatorsList();
            }
          };

  private static final PagedListDescriptor<ListOperatorsRequest, ListOperatorsResponse, Operator>
      LIST_OPERATORS_PAGE_STR_DESC =
          new PagedListDescriptor<ListOperatorsRequest, ListOperatorsResponse, Operator>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListOperatorsRequest injectToken(ListOperatorsRequest payload, String token) {
              return ListOperatorsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListOperatorsRequest injectPageSize(ListOperatorsRequest payload, int pageSize) {
              return ListOperatorsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListOperatorsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListOperatorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Operator> extractResources(ListOperatorsResponse payload) {
              return payload.getOperatorsList() == null
                  ? ImmutableList.<Operator>of()
                  : payload.getOperatorsList();
            }
          };

  private static final PagedListDescriptor<ListAnalysesRequest, ListAnalysesResponse, Analysis>
      LIST_ANALYSES_PAGE_STR_DESC =
          new PagedListDescriptor<ListAnalysesRequest, ListAnalysesResponse, Analysis>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAnalysesRequest injectToken(ListAnalysesRequest payload, String token) {
              return ListAnalysesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAnalysesRequest injectPageSize(ListAnalysesRequest payload, int pageSize) {
              return ListAnalysesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAnalysesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAnalysesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Analysis> extractResources(ListAnalysesResponse payload) {
              return payload.getAnalysesList() == null
                  ? ImmutableList.<Analysis>of()
                  : payload.getAnalysesList();
            }
          };

  private static final PagedListDescriptor<ListProcessesRequest, ListProcessesResponse, Process>
      LIST_PROCESSES_PAGE_STR_DESC =
          new PagedListDescriptor<ListProcessesRequest, ListProcessesResponse, Process>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListProcessesRequest injectToken(ListProcessesRequest payload, String token) {
              return ListProcessesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListProcessesRequest injectPageSize(ListProcessesRequest payload, int pageSize) {
              return ListProcessesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListProcessesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListProcessesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Process> extractResources(ListProcessesResponse payload) {
              return payload.getProcessesList() == null
                  ? ImmutableList.<Process>of()
                  : payload.getProcessesList();
            }
          };

  private static final PagedListResponseFactory<
          ListPublicOperatorsRequest, ListPublicOperatorsResponse, ListPublicOperatorsPagedResponse>
      LIST_PUBLIC_OPERATORS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPublicOperatorsRequest,
              ListPublicOperatorsResponse,
              ListPublicOperatorsPagedResponse>() {
            @Override
            public ApiFuture<ListPublicOperatorsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPublicOperatorsRequest, ListPublicOperatorsResponse> callable,
                ListPublicOperatorsRequest request,
                ApiCallContext context,
                ApiFuture<ListPublicOperatorsResponse> futureResponse) {
              PageContext<ListPublicOperatorsRequest, ListPublicOperatorsResponse, Operator>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PUBLIC_OPERATORS_PAGE_STR_DESC, request, context);
              return ListPublicOperatorsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListOperatorsRequest, ListOperatorsResponse, ListOperatorsPagedResponse>
      LIST_OPERATORS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListOperatorsRequest, ListOperatorsResponse, ListOperatorsPagedResponse>() {
            @Override
            public ApiFuture<ListOperatorsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListOperatorsRequest, ListOperatorsResponse> callable,
                ListOperatorsRequest request,
                ApiCallContext context,
                ApiFuture<ListOperatorsResponse> futureResponse) {
              PageContext<ListOperatorsRequest, ListOperatorsResponse, Operator> pageContext =
                  PageContext.create(callable, LIST_OPERATORS_PAGE_STR_DESC, request, context);
              return ListOperatorsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAnalysesRequest, ListAnalysesResponse, ListAnalysesPagedResponse>
      LIST_ANALYSES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAnalysesRequest, ListAnalysesResponse, ListAnalysesPagedResponse>() {
            @Override
            public ApiFuture<ListAnalysesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAnalysesRequest, ListAnalysesResponse> callable,
                ListAnalysesRequest request,
                ApiCallContext context,
                ApiFuture<ListAnalysesResponse> futureResponse) {
              PageContext<ListAnalysesRequest, ListAnalysesResponse, Analysis> pageContext =
                  PageContext.create(callable, LIST_ANALYSES_PAGE_STR_DESC, request, context);
              return ListAnalysesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListProcessesRequest, ListProcessesResponse, ListProcessesPagedResponse>
      LIST_PROCESSES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListProcessesRequest, ListProcessesResponse, ListProcessesPagedResponse>() {
            @Override
            public ApiFuture<ListProcessesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListProcessesRequest, ListProcessesResponse> callable,
                ListProcessesRequest request,
                ApiCallContext context,
                ApiFuture<ListProcessesResponse> futureResponse) {
              PageContext<ListProcessesRequest, ListProcessesResponse, Process> pageContext =
                  PageContext.create(callable, LIST_PROCESSES_PAGE_STR_DESC, request, context);
              return ListProcessesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listPublicOperators. */
  public PagedCallSettings<
          ListPublicOperatorsRequest, ListPublicOperatorsResponse, ListPublicOperatorsPagedResponse>
      listPublicOperatorsSettings() {
    return listPublicOperatorsSettings;
  }

  /** Returns the object with the settings used for calls to resolveOperatorInfo. */
  public UnaryCallSettings<ResolveOperatorInfoRequest, ResolveOperatorInfoResponse>
      resolveOperatorInfoSettings() {
    return resolveOperatorInfoSettings;
  }

  /** Returns the object with the settings used for calls to listOperators. */
  public PagedCallSettings<ListOperatorsRequest, ListOperatorsResponse, ListOperatorsPagedResponse>
      listOperatorsSettings() {
    return listOperatorsSettings;
  }

  /** Returns the object with the settings used for calls to getOperator. */
  public UnaryCallSettings<GetOperatorRequest, Operator> getOperatorSettings() {
    return getOperatorSettings;
  }

  /** Returns the object with the settings used for calls to createOperator. */
  public UnaryCallSettings<CreateOperatorRequest, Operation> createOperatorSettings() {
    return createOperatorSettings;
  }

  /** Returns the object with the settings used for calls to createOperator. */
  public OperationCallSettings<CreateOperatorRequest, Operator, OperationMetadata>
      createOperatorOperationSettings() {
    return createOperatorOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateOperator. */
  public UnaryCallSettings<UpdateOperatorRequest, Operation> updateOperatorSettings() {
    return updateOperatorSettings;
  }

  /** Returns the object with the settings used for calls to updateOperator. */
  public OperationCallSettings<UpdateOperatorRequest, Operator, OperationMetadata>
      updateOperatorOperationSettings() {
    return updateOperatorOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteOperator. */
  public UnaryCallSettings<DeleteOperatorRequest, Operation> deleteOperatorSettings() {
    return deleteOperatorSettings;
  }

  /** Returns the object with the settings used for calls to deleteOperator. */
  public OperationCallSettings<DeleteOperatorRequest, Empty, OperationMetadata>
      deleteOperatorOperationSettings() {
    return deleteOperatorOperationSettings;
  }

  /** Returns the object with the settings used for calls to listAnalyses. */
  public PagedCallSettings<ListAnalysesRequest, ListAnalysesResponse, ListAnalysesPagedResponse>
      listAnalysesSettings() {
    return listAnalysesSettings;
  }

  /** Returns the object with the settings used for calls to getAnalysis. */
  public UnaryCallSettings<GetAnalysisRequest, Analysis> getAnalysisSettings() {
    return getAnalysisSettings;
  }

  /** Returns the object with the settings used for calls to createAnalysis. */
  public UnaryCallSettings<CreateAnalysisRequest, Operation> createAnalysisSettings() {
    return createAnalysisSettings;
  }

  /** Returns the object with the settings used for calls to createAnalysis. */
  public OperationCallSettings<CreateAnalysisRequest, Analysis, OperationMetadata>
      createAnalysisOperationSettings() {
    return createAnalysisOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAnalysis. */
  public UnaryCallSettings<UpdateAnalysisRequest, Operation> updateAnalysisSettings() {
    return updateAnalysisSettings;
  }

  /** Returns the object with the settings used for calls to updateAnalysis. */
  public OperationCallSettings<UpdateAnalysisRequest, Analysis, OperationMetadata>
      updateAnalysisOperationSettings() {
    return updateAnalysisOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAnalysis. */
  public UnaryCallSettings<DeleteAnalysisRequest, Operation> deleteAnalysisSettings() {
    return deleteAnalysisSettings;
  }

  /** Returns the object with the settings used for calls to deleteAnalysis. */
  public OperationCallSettings<DeleteAnalysisRequest, Empty, OperationMetadata>
      deleteAnalysisOperationSettings() {
    return deleteAnalysisOperationSettings;
  }

  /** Returns the object with the settings used for calls to listProcesses. */
  public PagedCallSettings<ListProcessesRequest, ListProcessesResponse, ListProcessesPagedResponse>
      listProcessesSettings() {
    return listProcessesSettings;
  }

  /** Returns the object with the settings used for calls to getProcess. */
  public UnaryCallSettings<GetProcessRequest, Process> getProcessSettings() {
    return getProcessSettings;
  }

  /** Returns the object with the settings used for calls to createProcess. */
  public UnaryCallSettings<CreateProcessRequest, Operation> createProcessSettings() {
    return createProcessSettings;
  }

  /** Returns the object with the settings used for calls to createProcess. */
  public OperationCallSettings<CreateProcessRequest, Process, OperationMetadata>
      createProcessOperationSettings() {
    return createProcessOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateProcess. */
  public UnaryCallSettings<UpdateProcessRequest, Operation> updateProcessSettings() {
    return updateProcessSettings;
  }

  /** Returns the object with the settings used for calls to updateProcess. */
  public OperationCallSettings<UpdateProcessRequest, Process, OperationMetadata>
      updateProcessOperationSettings() {
    return updateProcessOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteProcess. */
  public UnaryCallSettings<DeleteProcessRequest, Operation> deleteProcessSettings() {
    return deleteProcessSettings;
  }

  /** Returns the object with the settings used for calls to deleteProcess. */
  public OperationCallSettings<DeleteProcessRequest, Empty, OperationMetadata>
      deleteProcessOperationSettings() {
    return deleteProcessOperationSettings;
  }

  /** Returns the object with the settings used for calls to batchRunProcess. */
  public UnaryCallSettings<BatchRunProcessRequest, Operation> batchRunProcessSettings() {
    return batchRunProcessSettings;
  }

  /** Returns the object with the settings used for calls to batchRunProcess. */
  public OperationCallSettings<BatchRunProcessRequest, BatchRunProcessResponse, OperationMetadata>
      batchRunProcessOperationSettings() {
    return batchRunProcessOperationSettings;
  }

  public LiveVideoAnalyticsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcLiveVideoAnalyticsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonLiveVideoAnalyticsStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "visionai";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "visionai.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "visionai.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(LiveVideoAnalyticsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(LiveVideoAnalyticsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LiveVideoAnalyticsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected LiveVideoAnalyticsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listPublicOperatorsSettings = settingsBuilder.listPublicOperatorsSettings().build();
    resolveOperatorInfoSettings = settingsBuilder.resolveOperatorInfoSettings().build();
    listOperatorsSettings = settingsBuilder.listOperatorsSettings().build();
    getOperatorSettings = settingsBuilder.getOperatorSettings().build();
    createOperatorSettings = settingsBuilder.createOperatorSettings().build();
    createOperatorOperationSettings = settingsBuilder.createOperatorOperationSettings().build();
    updateOperatorSettings = settingsBuilder.updateOperatorSettings().build();
    updateOperatorOperationSettings = settingsBuilder.updateOperatorOperationSettings().build();
    deleteOperatorSettings = settingsBuilder.deleteOperatorSettings().build();
    deleteOperatorOperationSettings = settingsBuilder.deleteOperatorOperationSettings().build();
    listAnalysesSettings = settingsBuilder.listAnalysesSettings().build();
    getAnalysisSettings = settingsBuilder.getAnalysisSettings().build();
    createAnalysisSettings = settingsBuilder.createAnalysisSettings().build();
    createAnalysisOperationSettings = settingsBuilder.createAnalysisOperationSettings().build();
    updateAnalysisSettings = settingsBuilder.updateAnalysisSettings().build();
    updateAnalysisOperationSettings = settingsBuilder.updateAnalysisOperationSettings().build();
    deleteAnalysisSettings = settingsBuilder.deleteAnalysisSettings().build();
    deleteAnalysisOperationSettings = settingsBuilder.deleteAnalysisOperationSettings().build();
    listProcessesSettings = settingsBuilder.listProcessesSettings().build();
    getProcessSettings = settingsBuilder.getProcessSettings().build();
    createProcessSettings = settingsBuilder.createProcessSettings().build();
    createProcessOperationSettings = settingsBuilder.createProcessOperationSettings().build();
    updateProcessSettings = settingsBuilder.updateProcessSettings().build();
    updateProcessOperationSettings = settingsBuilder.updateProcessOperationSettings().build();
    deleteProcessSettings = settingsBuilder.deleteProcessSettings().build();
    deleteProcessOperationSettings = settingsBuilder.deleteProcessOperationSettings().build();
    batchRunProcessSettings = settingsBuilder.batchRunProcessSettings().build();
    batchRunProcessOperationSettings = settingsBuilder.batchRunProcessOperationSettings().build();
  }

  /** Builder for LiveVideoAnalyticsStubSettings. */
  public static class Builder
      extends StubSettings.Builder<LiveVideoAnalyticsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListPublicOperatorsRequest,
            ListPublicOperatorsResponse,
            ListPublicOperatorsPagedResponse>
        listPublicOperatorsSettings;
    private final UnaryCallSettings.Builder<ResolveOperatorInfoRequest, ResolveOperatorInfoResponse>
        resolveOperatorInfoSettings;
    private final PagedCallSettings.Builder<
            ListOperatorsRequest, ListOperatorsResponse, ListOperatorsPagedResponse>
        listOperatorsSettings;
    private final UnaryCallSettings.Builder<GetOperatorRequest, Operator> getOperatorSettings;
    private final UnaryCallSettings.Builder<CreateOperatorRequest, Operation>
        createOperatorSettings;
    private final OperationCallSettings.Builder<CreateOperatorRequest, Operator, OperationMetadata>
        createOperatorOperationSettings;
    private final UnaryCallSettings.Builder<UpdateOperatorRequest, Operation>
        updateOperatorSettings;
    private final OperationCallSettings.Builder<UpdateOperatorRequest, Operator, OperationMetadata>
        updateOperatorOperationSettings;
    private final UnaryCallSettings.Builder<DeleteOperatorRequest, Operation>
        deleteOperatorSettings;
    private final OperationCallSettings.Builder<DeleteOperatorRequest, Empty, OperationMetadata>
        deleteOperatorOperationSettings;
    private final PagedCallSettings.Builder<
            ListAnalysesRequest, ListAnalysesResponse, ListAnalysesPagedResponse>
        listAnalysesSettings;
    private final UnaryCallSettings.Builder<GetAnalysisRequest, Analysis> getAnalysisSettings;
    private final UnaryCallSettings.Builder<CreateAnalysisRequest, Operation>
        createAnalysisSettings;
    private final OperationCallSettings.Builder<CreateAnalysisRequest, Analysis, OperationMetadata>
        createAnalysisOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAnalysisRequest, Operation>
        updateAnalysisSettings;
    private final OperationCallSettings.Builder<UpdateAnalysisRequest, Analysis, OperationMetadata>
        updateAnalysisOperationSettings;
    private final UnaryCallSettings.Builder<DeleteAnalysisRequest, Operation>
        deleteAnalysisSettings;
    private final OperationCallSettings.Builder<DeleteAnalysisRequest, Empty, OperationMetadata>
        deleteAnalysisOperationSettings;
    private final PagedCallSettings.Builder<
            ListProcessesRequest, ListProcessesResponse, ListProcessesPagedResponse>
        listProcessesSettings;
    private final UnaryCallSettings.Builder<GetProcessRequest, Process> getProcessSettings;
    private final UnaryCallSettings.Builder<CreateProcessRequest, Operation> createProcessSettings;
    private final OperationCallSettings.Builder<CreateProcessRequest, Process, OperationMetadata>
        createProcessOperationSettings;
    private final UnaryCallSettings.Builder<UpdateProcessRequest, Operation> updateProcessSettings;
    private final OperationCallSettings.Builder<UpdateProcessRequest, Process, OperationMetadata>
        updateProcessOperationSettings;
    private final UnaryCallSettings.Builder<DeleteProcessRequest, Operation> deleteProcessSettings;
    private final OperationCallSettings.Builder<DeleteProcessRequest, Empty, OperationMetadata>
        deleteProcessOperationSettings;
    private final UnaryCallSettings.Builder<BatchRunProcessRequest, Operation>
        batchRunProcessSettings;
    private final OperationCallSettings.Builder<
            BatchRunProcessRequest, BatchRunProcessResponse, OperationMetadata>
        batchRunProcessOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_8_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "no_retry_5_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "no_retry_7_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_8_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(300000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(300000L))
              .setTotalTimeout(Duration.ofMillis(300000L))
              .build();
      definitions.put("no_retry_5_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(300000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(300000L))
              .setTotalTimeout(Duration.ofMillis(300000L))
              .build();
      definitions.put("no_retry_7_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listPublicOperatorsSettings =
          PagedCallSettings.newBuilder(LIST_PUBLIC_OPERATORS_PAGE_STR_FACT);
      resolveOperatorInfoSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listOperatorsSettings = PagedCallSettings.newBuilder(LIST_OPERATORS_PAGE_STR_FACT);
      getOperatorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createOperatorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createOperatorOperationSettings = OperationCallSettings.newBuilder();
      updateOperatorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateOperatorOperationSettings = OperationCallSettings.newBuilder();
      deleteOperatorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperatorOperationSettings = OperationCallSettings.newBuilder();
      listAnalysesSettings = PagedCallSettings.newBuilder(LIST_ANALYSES_PAGE_STR_FACT);
      getAnalysisSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAnalysisSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAnalysisOperationSettings = OperationCallSettings.newBuilder();
      updateAnalysisSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAnalysisOperationSettings = OperationCallSettings.newBuilder();
      deleteAnalysisSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAnalysisOperationSettings = OperationCallSettings.newBuilder();
      listProcessesSettings = PagedCallSettings.newBuilder(LIST_PROCESSES_PAGE_STR_FACT);
      getProcessSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createProcessSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createProcessOperationSettings = OperationCallSettings.newBuilder();
      updateProcessSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateProcessOperationSettings = OperationCallSettings.newBuilder();
      deleteProcessSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteProcessOperationSettings = OperationCallSettings.newBuilder();
      batchRunProcessSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchRunProcessOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listPublicOperatorsSettings,
              resolveOperatorInfoSettings,
              listOperatorsSettings,
              getOperatorSettings,
              createOperatorSettings,
              updateOperatorSettings,
              deleteOperatorSettings,
              listAnalysesSettings,
              getAnalysisSettings,
              createAnalysisSettings,
              updateAnalysisSettings,
              deleteAnalysisSettings,
              listProcessesSettings,
              getProcessSettings,
              createProcessSettings,
              updateProcessSettings,
              deleteProcessSettings,
              batchRunProcessSettings);
      initDefaults(this);
    }

    protected Builder(LiveVideoAnalyticsStubSettings settings) {
      super(settings);

      listPublicOperatorsSettings = settings.listPublicOperatorsSettings.toBuilder();
      resolveOperatorInfoSettings = settings.resolveOperatorInfoSettings.toBuilder();
      listOperatorsSettings = settings.listOperatorsSettings.toBuilder();
      getOperatorSettings = settings.getOperatorSettings.toBuilder();
      createOperatorSettings = settings.createOperatorSettings.toBuilder();
      createOperatorOperationSettings = settings.createOperatorOperationSettings.toBuilder();
      updateOperatorSettings = settings.updateOperatorSettings.toBuilder();
      updateOperatorOperationSettings = settings.updateOperatorOperationSettings.toBuilder();
      deleteOperatorSettings = settings.deleteOperatorSettings.toBuilder();
      deleteOperatorOperationSettings = settings.deleteOperatorOperationSettings.toBuilder();
      listAnalysesSettings = settings.listAnalysesSettings.toBuilder();
      getAnalysisSettings = settings.getAnalysisSettings.toBuilder();
      createAnalysisSettings = settings.createAnalysisSettings.toBuilder();
      createAnalysisOperationSettings = settings.createAnalysisOperationSettings.toBuilder();
      updateAnalysisSettings = settings.updateAnalysisSettings.toBuilder();
      updateAnalysisOperationSettings = settings.updateAnalysisOperationSettings.toBuilder();
      deleteAnalysisSettings = settings.deleteAnalysisSettings.toBuilder();
      deleteAnalysisOperationSettings = settings.deleteAnalysisOperationSettings.toBuilder();
      listProcessesSettings = settings.listProcessesSettings.toBuilder();
      getProcessSettings = settings.getProcessSettings.toBuilder();
      createProcessSettings = settings.createProcessSettings.toBuilder();
      createProcessOperationSettings = settings.createProcessOperationSettings.toBuilder();
      updateProcessSettings = settings.updateProcessSettings.toBuilder();
      updateProcessOperationSettings = settings.updateProcessOperationSettings.toBuilder();
      deleteProcessSettings = settings.deleteProcessSettings.toBuilder();
      deleteProcessOperationSettings = settings.deleteProcessOperationSettings.toBuilder();
      batchRunProcessSettings = settings.batchRunProcessSettings.toBuilder();
      batchRunProcessOperationSettings = settings.batchRunProcessOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listPublicOperatorsSettings,
              resolveOperatorInfoSettings,
              listOperatorsSettings,
              getOperatorSettings,
              createOperatorSettings,
              updateOperatorSettings,
              deleteOperatorSettings,
              listAnalysesSettings,
              getAnalysisSettings,
              createAnalysisSettings,
              updateAnalysisSettings,
              deleteAnalysisSettings,
              listProcessesSettings,
              getProcessSettings,
              createProcessSettings,
              updateProcessSettings,
              deleteProcessSettings,
              batchRunProcessSettings);
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
          .listPublicOperatorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .resolveOperatorInfoSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listOperatorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_8_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_8_params"));

      builder
          .getOperatorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_8_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_8_params"));

      builder
          .createOperatorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_5_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_5_params"));

      builder
          .updateOperatorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_8_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_8_params"));

      builder
          .deleteOperatorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_8_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_8_params"));

      builder
          .listAnalysesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_8_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_8_params"));

      builder
          .getAnalysisSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_8_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_8_params"));

      builder
          .createAnalysisSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .updateAnalysisSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_8_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_8_params"));

      builder
          .deleteAnalysisSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_8_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_8_params"));

      builder
          .listProcessesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getProcessSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createProcessSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateProcessSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteProcessSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchRunProcessSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createOperatorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateOperatorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_5_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_5_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operator.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .updateOperatorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateOperatorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_8_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_8_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operator.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteOperatorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteOperatorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_8_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_8_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .createAnalysisOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAnalysisRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Analysis.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .updateAnalysisOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAnalysisRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_8_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_8_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Analysis.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteAnalysisOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAnalysisRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_8_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_8_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .createProcessOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateProcessRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Process.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .updateProcessOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateProcessRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Process.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteProcessOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteProcessRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .batchRunProcessOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchRunProcessRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BatchRunProcessResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to listPublicOperators. */
    public PagedCallSettings.Builder<
            ListPublicOperatorsRequest,
            ListPublicOperatorsResponse,
            ListPublicOperatorsPagedResponse>
        listPublicOperatorsSettings() {
      return listPublicOperatorsSettings;
    }

    /** Returns the builder for the settings used for calls to resolveOperatorInfo. */
    public UnaryCallSettings.Builder<ResolveOperatorInfoRequest, ResolveOperatorInfoResponse>
        resolveOperatorInfoSettings() {
      return resolveOperatorInfoSettings;
    }

    /** Returns the builder for the settings used for calls to listOperators. */
    public PagedCallSettings.Builder<
            ListOperatorsRequest, ListOperatorsResponse, ListOperatorsPagedResponse>
        listOperatorsSettings() {
      return listOperatorsSettings;
    }

    /** Returns the builder for the settings used for calls to getOperator. */
    public UnaryCallSettings.Builder<GetOperatorRequest, Operator> getOperatorSettings() {
      return getOperatorSettings;
    }

    /** Returns the builder for the settings used for calls to createOperator. */
    public UnaryCallSettings.Builder<CreateOperatorRequest, Operation> createOperatorSettings() {
      return createOperatorSettings;
    }

    /** Returns the builder for the settings used for calls to createOperator. */
    public OperationCallSettings.Builder<CreateOperatorRequest, Operator, OperationMetadata>
        createOperatorOperationSettings() {
      return createOperatorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateOperator. */
    public UnaryCallSettings.Builder<UpdateOperatorRequest, Operation> updateOperatorSettings() {
      return updateOperatorSettings;
    }

    /** Returns the builder for the settings used for calls to updateOperator. */
    public OperationCallSettings.Builder<UpdateOperatorRequest, Operator, OperationMetadata>
        updateOperatorOperationSettings() {
      return updateOperatorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteOperator. */
    public UnaryCallSettings.Builder<DeleteOperatorRequest, Operation> deleteOperatorSettings() {
      return deleteOperatorSettings;
    }

    /** Returns the builder for the settings used for calls to deleteOperator. */
    public OperationCallSettings.Builder<DeleteOperatorRequest, Empty, OperationMetadata>
        deleteOperatorOperationSettings() {
      return deleteOperatorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listAnalyses. */
    public PagedCallSettings.Builder<
            ListAnalysesRequest, ListAnalysesResponse, ListAnalysesPagedResponse>
        listAnalysesSettings() {
      return listAnalysesSettings;
    }

    /** Returns the builder for the settings used for calls to getAnalysis. */
    public UnaryCallSettings.Builder<GetAnalysisRequest, Analysis> getAnalysisSettings() {
      return getAnalysisSettings;
    }

    /** Returns the builder for the settings used for calls to createAnalysis. */
    public UnaryCallSettings.Builder<CreateAnalysisRequest, Operation> createAnalysisSettings() {
      return createAnalysisSettings;
    }

    /** Returns the builder for the settings used for calls to createAnalysis. */
    public OperationCallSettings.Builder<CreateAnalysisRequest, Analysis, OperationMetadata>
        createAnalysisOperationSettings() {
      return createAnalysisOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAnalysis. */
    public UnaryCallSettings.Builder<UpdateAnalysisRequest, Operation> updateAnalysisSettings() {
      return updateAnalysisSettings;
    }

    /** Returns the builder for the settings used for calls to updateAnalysis. */
    public OperationCallSettings.Builder<UpdateAnalysisRequest, Analysis, OperationMetadata>
        updateAnalysisOperationSettings() {
      return updateAnalysisOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAnalysis. */
    public UnaryCallSettings.Builder<DeleteAnalysisRequest, Operation> deleteAnalysisSettings() {
      return deleteAnalysisSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAnalysis. */
    public OperationCallSettings.Builder<DeleteAnalysisRequest, Empty, OperationMetadata>
        deleteAnalysisOperationSettings() {
      return deleteAnalysisOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listProcesses. */
    public PagedCallSettings.Builder<
            ListProcessesRequest, ListProcessesResponse, ListProcessesPagedResponse>
        listProcessesSettings() {
      return listProcessesSettings;
    }

    /** Returns the builder for the settings used for calls to getProcess. */
    public UnaryCallSettings.Builder<GetProcessRequest, Process> getProcessSettings() {
      return getProcessSettings;
    }

    /** Returns the builder for the settings used for calls to createProcess. */
    public UnaryCallSettings.Builder<CreateProcessRequest, Operation> createProcessSettings() {
      return createProcessSettings;
    }

    /** Returns the builder for the settings used for calls to createProcess. */
    public OperationCallSettings.Builder<CreateProcessRequest, Process, OperationMetadata>
        createProcessOperationSettings() {
      return createProcessOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateProcess. */
    public UnaryCallSettings.Builder<UpdateProcessRequest, Operation> updateProcessSettings() {
      return updateProcessSettings;
    }

    /** Returns the builder for the settings used for calls to updateProcess. */
    public OperationCallSettings.Builder<UpdateProcessRequest, Process, OperationMetadata>
        updateProcessOperationSettings() {
      return updateProcessOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteProcess. */
    public UnaryCallSettings.Builder<DeleteProcessRequest, Operation> deleteProcessSettings() {
      return deleteProcessSettings;
    }

    /** Returns the builder for the settings used for calls to deleteProcess. */
    public OperationCallSettings.Builder<DeleteProcessRequest, Empty, OperationMetadata>
        deleteProcessOperationSettings() {
      return deleteProcessOperationSettings;
    }

    /** Returns the builder for the settings used for calls to batchRunProcess. */
    public UnaryCallSettings.Builder<BatchRunProcessRequest, Operation> batchRunProcessSettings() {
      return batchRunProcessSettings;
    }

    /** Returns the builder for the settings used for calls to batchRunProcess. */
    public OperationCallSettings.Builder<
            BatchRunProcessRequest, BatchRunProcessResponse, OperationMetadata>
        batchRunProcessOperationSettings() {
      return batchRunProcessOperationSettings;
    }

    @Override
    public LiveVideoAnalyticsStubSettings build() throws IOException {
      return new LiveVideoAnalyticsStubSettings(this);
    }
  }
}
