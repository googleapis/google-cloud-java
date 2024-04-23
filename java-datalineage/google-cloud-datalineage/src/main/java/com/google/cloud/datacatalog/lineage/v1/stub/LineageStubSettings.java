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

package com.google.cloud.datacatalog.lineage.v1.stub;

import static com.google.cloud.datacatalog.lineage.v1.LineageClient.BatchSearchLinkProcessesPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.ListLineageEventsPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.ListProcessesPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.ListRunsPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.SearchLinksPagedResponse;

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
import com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesRequest;
import com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesResponse;
import com.google.cloud.datacatalog.lineage.v1.CreateLineageEventRequest;
import com.google.cloud.datacatalog.lineage.v1.CreateProcessRequest;
import com.google.cloud.datacatalog.lineage.v1.CreateRunRequest;
import com.google.cloud.datacatalog.lineage.v1.DeleteLineageEventRequest;
import com.google.cloud.datacatalog.lineage.v1.DeleteProcessRequest;
import com.google.cloud.datacatalog.lineage.v1.DeleteRunRequest;
import com.google.cloud.datacatalog.lineage.v1.GetLineageEventRequest;
import com.google.cloud.datacatalog.lineage.v1.GetProcessRequest;
import com.google.cloud.datacatalog.lineage.v1.GetRunRequest;
import com.google.cloud.datacatalog.lineage.v1.LineageEvent;
import com.google.cloud.datacatalog.lineage.v1.Link;
import com.google.cloud.datacatalog.lineage.v1.ListLineageEventsRequest;
import com.google.cloud.datacatalog.lineage.v1.ListLineageEventsResponse;
import com.google.cloud.datacatalog.lineage.v1.ListProcessesRequest;
import com.google.cloud.datacatalog.lineage.v1.ListProcessesResponse;
import com.google.cloud.datacatalog.lineage.v1.ListRunsRequest;
import com.google.cloud.datacatalog.lineage.v1.ListRunsResponse;
import com.google.cloud.datacatalog.lineage.v1.OperationMetadata;
import com.google.cloud.datacatalog.lineage.v1.Process;
import com.google.cloud.datacatalog.lineage.v1.ProcessLinks;
import com.google.cloud.datacatalog.lineage.v1.ProcessOpenLineageRunEventRequest;
import com.google.cloud.datacatalog.lineage.v1.ProcessOpenLineageRunEventResponse;
import com.google.cloud.datacatalog.lineage.v1.Run;
import com.google.cloud.datacatalog.lineage.v1.SearchLinksRequest;
import com.google.cloud.datacatalog.lineage.v1.SearchLinksResponse;
import com.google.cloud.datacatalog.lineage.v1.UpdateProcessRequest;
import com.google.cloud.datacatalog.lineage.v1.UpdateRunRequest;
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
 * Settings class to configure an instance of {@link LineageStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (datalineage.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of processOpenLineageRunEvent to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LineageStubSettings.Builder lineageSettingsBuilder = LineageStubSettings.newBuilder();
 * lineageSettingsBuilder
 *     .processOpenLineageRunEventSettings()
 *     .setRetrySettings(
 *         lineageSettingsBuilder
 *             .processOpenLineageRunEventSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * LineageStubSettings lineageSettings = lineageSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class LineageStubSettings extends StubSettings<LineageStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<
          ProcessOpenLineageRunEventRequest, ProcessOpenLineageRunEventResponse>
      processOpenLineageRunEventSettings;
  private final UnaryCallSettings<CreateProcessRequest, Process> createProcessSettings;
  private final UnaryCallSettings<UpdateProcessRequest, Process> updateProcessSettings;
  private final UnaryCallSettings<GetProcessRequest, Process> getProcessSettings;
  private final PagedCallSettings<
          ListProcessesRequest, ListProcessesResponse, ListProcessesPagedResponse>
      listProcessesSettings;
  private final UnaryCallSettings<DeleteProcessRequest, Operation> deleteProcessSettings;
  private final OperationCallSettings<DeleteProcessRequest, Empty, OperationMetadata>
      deleteProcessOperationSettings;
  private final UnaryCallSettings<CreateRunRequest, Run> createRunSettings;
  private final UnaryCallSettings<UpdateRunRequest, Run> updateRunSettings;
  private final UnaryCallSettings<GetRunRequest, Run> getRunSettings;
  private final PagedCallSettings<ListRunsRequest, ListRunsResponse, ListRunsPagedResponse>
      listRunsSettings;
  private final UnaryCallSettings<DeleteRunRequest, Operation> deleteRunSettings;
  private final OperationCallSettings<DeleteRunRequest, Empty, OperationMetadata>
      deleteRunOperationSettings;
  private final UnaryCallSettings<CreateLineageEventRequest, LineageEvent>
      createLineageEventSettings;
  private final UnaryCallSettings<GetLineageEventRequest, LineageEvent> getLineageEventSettings;
  private final PagedCallSettings<
          ListLineageEventsRequest, ListLineageEventsResponse, ListLineageEventsPagedResponse>
      listLineageEventsSettings;
  private final UnaryCallSettings<DeleteLineageEventRequest, Empty> deleteLineageEventSettings;
  private final PagedCallSettings<SearchLinksRequest, SearchLinksResponse, SearchLinksPagedResponse>
      searchLinksSettings;
  private final PagedCallSettings<
          BatchSearchLinkProcessesRequest,
          BatchSearchLinkProcessesResponse,
          BatchSearchLinkProcessesPagedResponse>
      batchSearchLinkProcessesSettings;

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

  private static final PagedListDescriptor<ListRunsRequest, ListRunsResponse, Run>
      LIST_RUNS_PAGE_STR_DESC =
          new PagedListDescriptor<ListRunsRequest, ListRunsResponse, Run>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRunsRequest injectToken(ListRunsRequest payload, String token) {
              return ListRunsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRunsRequest injectPageSize(ListRunsRequest payload, int pageSize) {
              return ListRunsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRunsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRunsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Run> extractResources(ListRunsResponse payload) {
              return payload.getRunsList() == null
                  ? ImmutableList.<Run>of()
                  : payload.getRunsList();
            }
          };

  private static final PagedListDescriptor<
          ListLineageEventsRequest, ListLineageEventsResponse, LineageEvent>
      LIST_LINEAGE_EVENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListLineageEventsRequest, ListLineageEventsResponse, LineageEvent>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLineageEventsRequest injectToken(
                ListLineageEventsRequest payload, String token) {
              return ListLineageEventsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLineageEventsRequest injectPageSize(
                ListLineageEventsRequest payload, int pageSize) {
              return ListLineageEventsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLineageEventsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLineageEventsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LineageEvent> extractResources(ListLineageEventsResponse payload) {
              return payload.getLineageEventsList() == null
                  ? ImmutableList.<LineageEvent>of()
                  : payload.getLineageEventsList();
            }
          };

  private static final PagedListDescriptor<SearchLinksRequest, SearchLinksResponse, Link>
      SEARCH_LINKS_PAGE_STR_DESC =
          new PagedListDescriptor<SearchLinksRequest, SearchLinksResponse, Link>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchLinksRequest injectToken(SearchLinksRequest payload, String token) {
              return SearchLinksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchLinksRequest injectPageSize(SearchLinksRequest payload, int pageSize) {
              return SearchLinksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchLinksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchLinksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Link> extractResources(SearchLinksResponse payload) {
              return payload.getLinksList() == null
                  ? ImmutableList.<Link>of()
                  : payload.getLinksList();
            }
          };

  private static final PagedListDescriptor<
          BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse, ProcessLinks>
      BATCH_SEARCH_LINK_PROCESSES_PAGE_STR_DESC =
          new PagedListDescriptor<
              BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse, ProcessLinks>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public BatchSearchLinkProcessesRequest injectToken(
                BatchSearchLinkProcessesRequest payload, String token) {
              return BatchSearchLinkProcessesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public BatchSearchLinkProcessesRequest injectPageSize(
                BatchSearchLinkProcessesRequest payload, int pageSize) {
              return BatchSearchLinkProcessesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(BatchSearchLinkProcessesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(BatchSearchLinkProcessesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ProcessLinks> extractResources(
                BatchSearchLinkProcessesResponse payload) {
              return payload.getProcessLinksList() == null
                  ? ImmutableList.<ProcessLinks>of()
                  : payload.getProcessLinksList();
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

  private static final PagedListResponseFactory<
          ListRunsRequest, ListRunsResponse, ListRunsPagedResponse>
      LIST_RUNS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListRunsRequest, ListRunsResponse, ListRunsPagedResponse>() {
            @Override
            public ApiFuture<ListRunsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRunsRequest, ListRunsResponse> callable,
                ListRunsRequest request,
                ApiCallContext context,
                ApiFuture<ListRunsResponse> futureResponse) {
              PageContext<ListRunsRequest, ListRunsResponse, Run> pageContext =
                  PageContext.create(callable, LIST_RUNS_PAGE_STR_DESC, request, context);
              return ListRunsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLineageEventsRequest, ListLineageEventsResponse, ListLineageEventsPagedResponse>
      LIST_LINEAGE_EVENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLineageEventsRequest,
              ListLineageEventsResponse,
              ListLineageEventsPagedResponse>() {
            @Override
            public ApiFuture<ListLineageEventsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLineageEventsRequest, ListLineageEventsResponse> callable,
                ListLineageEventsRequest request,
                ApiCallContext context,
                ApiFuture<ListLineageEventsResponse> futureResponse) {
              PageContext<ListLineageEventsRequest, ListLineageEventsResponse, LineageEvent>
                  pageContext =
                      PageContext.create(
                          callable, LIST_LINEAGE_EVENTS_PAGE_STR_DESC, request, context);
              return ListLineageEventsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchLinksRequest, SearchLinksResponse, SearchLinksPagedResponse>
      SEARCH_LINKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchLinksRequest, SearchLinksResponse, SearchLinksPagedResponse>() {
            @Override
            public ApiFuture<SearchLinksPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchLinksRequest, SearchLinksResponse> callable,
                SearchLinksRequest request,
                ApiCallContext context,
                ApiFuture<SearchLinksResponse> futureResponse) {
              PageContext<SearchLinksRequest, SearchLinksResponse, Link> pageContext =
                  PageContext.create(callable, SEARCH_LINKS_PAGE_STR_DESC, request, context);
              return SearchLinksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          BatchSearchLinkProcessesRequest,
          BatchSearchLinkProcessesResponse,
          BatchSearchLinkProcessesPagedResponse>
      BATCH_SEARCH_LINK_PROCESSES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              BatchSearchLinkProcessesRequest,
              BatchSearchLinkProcessesResponse,
              BatchSearchLinkProcessesPagedResponse>() {
            @Override
            public ApiFuture<BatchSearchLinkProcessesPagedResponse> getFuturePagedResponse(
                UnaryCallable<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse>
                    callable,
                BatchSearchLinkProcessesRequest request,
                ApiCallContext context,
                ApiFuture<BatchSearchLinkProcessesResponse> futureResponse) {
              PageContext<
                      BatchSearchLinkProcessesRequest,
                      BatchSearchLinkProcessesResponse,
                      ProcessLinks>
                  pageContext =
                      PageContext.create(
                          callable, BATCH_SEARCH_LINK_PROCESSES_PAGE_STR_DESC, request, context);
              return BatchSearchLinkProcessesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to processOpenLineageRunEvent. */
  public UnaryCallSettings<ProcessOpenLineageRunEventRequest, ProcessOpenLineageRunEventResponse>
      processOpenLineageRunEventSettings() {
    return processOpenLineageRunEventSettings;
  }

  /** Returns the object with the settings used for calls to createProcess. */
  public UnaryCallSettings<CreateProcessRequest, Process> createProcessSettings() {
    return createProcessSettings;
  }

  /** Returns the object with the settings used for calls to updateProcess. */
  public UnaryCallSettings<UpdateProcessRequest, Process> updateProcessSettings() {
    return updateProcessSettings;
  }

  /** Returns the object with the settings used for calls to getProcess. */
  public UnaryCallSettings<GetProcessRequest, Process> getProcessSettings() {
    return getProcessSettings;
  }

  /** Returns the object with the settings used for calls to listProcesses. */
  public PagedCallSettings<ListProcessesRequest, ListProcessesResponse, ListProcessesPagedResponse>
      listProcessesSettings() {
    return listProcessesSettings;
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

  /** Returns the object with the settings used for calls to createRun. */
  public UnaryCallSettings<CreateRunRequest, Run> createRunSettings() {
    return createRunSettings;
  }

  /** Returns the object with the settings used for calls to updateRun. */
  public UnaryCallSettings<UpdateRunRequest, Run> updateRunSettings() {
    return updateRunSettings;
  }

  /** Returns the object with the settings used for calls to getRun. */
  public UnaryCallSettings<GetRunRequest, Run> getRunSettings() {
    return getRunSettings;
  }

  /** Returns the object with the settings used for calls to listRuns. */
  public PagedCallSettings<ListRunsRequest, ListRunsResponse, ListRunsPagedResponse>
      listRunsSettings() {
    return listRunsSettings;
  }

  /** Returns the object with the settings used for calls to deleteRun. */
  public UnaryCallSettings<DeleteRunRequest, Operation> deleteRunSettings() {
    return deleteRunSettings;
  }

  /** Returns the object with the settings used for calls to deleteRun. */
  public OperationCallSettings<DeleteRunRequest, Empty, OperationMetadata>
      deleteRunOperationSettings() {
    return deleteRunOperationSettings;
  }

  /** Returns the object with the settings used for calls to createLineageEvent. */
  public UnaryCallSettings<CreateLineageEventRequest, LineageEvent> createLineageEventSettings() {
    return createLineageEventSettings;
  }

  /** Returns the object with the settings used for calls to getLineageEvent. */
  public UnaryCallSettings<GetLineageEventRequest, LineageEvent> getLineageEventSettings() {
    return getLineageEventSettings;
  }

  /** Returns the object with the settings used for calls to listLineageEvents. */
  public PagedCallSettings<
          ListLineageEventsRequest, ListLineageEventsResponse, ListLineageEventsPagedResponse>
      listLineageEventsSettings() {
    return listLineageEventsSettings;
  }

  /** Returns the object with the settings used for calls to deleteLineageEvent. */
  public UnaryCallSettings<DeleteLineageEventRequest, Empty> deleteLineageEventSettings() {
    return deleteLineageEventSettings;
  }

  /** Returns the object with the settings used for calls to searchLinks. */
  public PagedCallSettings<SearchLinksRequest, SearchLinksResponse, SearchLinksPagedResponse>
      searchLinksSettings() {
    return searchLinksSettings;
  }

  /** Returns the object with the settings used for calls to batchSearchLinkProcesses. */
  public PagedCallSettings<
          BatchSearchLinkProcessesRequest,
          BatchSearchLinkProcessesResponse,
          BatchSearchLinkProcessesPagedResponse>
      batchSearchLinkProcessesSettings() {
    return batchSearchLinkProcessesSettings;
  }

  public LineageStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcLineageStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonLineageStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "datalineage";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "datalineage.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "datalineage.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(LineageStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(LineageStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LineageStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected LineageStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    processOpenLineageRunEventSettings =
        settingsBuilder.processOpenLineageRunEventSettings().build();
    createProcessSettings = settingsBuilder.createProcessSettings().build();
    updateProcessSettings = settingsBuilder.updateProcessSettings().build();
    getProcessSettings = settingsBuilder.getProcessSettings().build();
    listProcessesSettings = settingsBuilder.listProcessesSettings().build();
    deleteProcessSettings = settingsBuilder.deleteProcessSettings().build();
    deleteProcessOperationSettings = settingsBuilder.deleteProcessOperationSettings().build();
    createRunSettings = settingsBuilder.createRunSettings().build();
    updateRunSettings = settingsBuilder.updateRunSettings().build();
    getRunSettings = settingsBuilder.getRunSettings().build();
    listRunsSettings = settingsBuilder.listRunsSettings().build();
    deleteRunSettings = settingsBuilder.deleteRunSettings().build();
    deleteRunOperationSettings = settingsBuilder.deleteRunOperationSettings().build();
    createLineageEventSettings = settingsBuilder.createLineageEventSettings().build();
    getLineageEventSettings = settingsBuilder.getLineageEventSettings().build();
    listLineageEventsSettings = settingsBuilder.listLineageEventsSettings().build();
    deleteLineageEventSettings = settingsBuilder.deleteLineageEventSettings().build();
    searchLinksSettings = settingsBuilder.searchLinksSettings().build();
    batchSearchLinkProcessesSettings = settingsBuilder.batchSearchLinkProcessesSettings().build();
  }

  /** Builder for LineageStubSettings. */
  public static class Builder extends StubSettings.Builder<LineageStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            ProcessOpenLineageRunEventRequest, ProcessOpenLineageRunEventResponse>
        processOpenLineageRunEventSettings;
    private final UnaryCallSettings.Builder<CreateProcessRequest, Process> createProcessSettings;
    private final UnaryCallSettings.Builder<UpdateProcessRequest, Process> updateProcessSettings;
    private final UnaryCallSettings.Builder<GetProcessRequest, Process> getProcessSettings;
    private final PagedCallSettings.Builder<
            ListProcessesRequest, ListProcessesResponse, ListProcessesPagedResponse>
        listProcessesSettings;
    private final UnaryCallSettings.Builder<DeleteProcessRequest, Operation> deleteProcessSettings;
    private final OperationCallSettings.Builder<DeleteProcessRequest, Empty, OperationMetadata>
        deleteProcessOperationSettings;
    private final UnaryCallSettings.Builder<CreateRunRequest, Run> createRunSettings;
    private final UnaryCallSettings.Builder<UpdateRunRequest, Run> updateRunSettings;
    private final UnaryCallSettings.Builder<GetRunRequest, Run> getRunSettings;
    private final PagedCallSettings.Builder<
            ListRunsRequest, ListRunsResponse, ListRunsPagedResponse>
        listRunsSettings;
    private final UnaryCallSettings.Builder<DeleteRunRequest, Operation> deleteRunSettings;
    private final OperationCallSettings.Builder<DeleteRunRequest, Empty, OperationMetadata>
        deleteRunOperationSettings;
    private final UnaryCallSettings.Builder<CreateLineageEventRequest, LineageEvent>
        createLineageEventSettings;
    private final UnaryCallSettings.Builder<GetLineageEventRequest, LineageEvent>
        getLineageEventSettings;
    private final PagedCallSettings.Builder<
            ListLineageEventsRequest, ListLineageEventsResponse, ListLineageEventsPagedResponse>
        listLineageEventsSettings;
    private final UnaryCallSettings.Builder<DeleteLineageEventRequest, Empty>
        deleteLineageEventSettings;
    private final PagedCallSettings.Builder<
            SearchLinksRequest, SearchLinksResponse, SearchLinksPagedResponse>
        searchLinksSettings;
    private final PagedCallSettings.Builder<
            BatchSearchLinkProcessesRequest,
            BatchSearchLinkProcessesResponse,
            BatchSearchLinkProcessesPagedResponse>
        batchSearchLinkProcessesSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
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
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      processOpenLineageRunEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createProcessSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateProcessSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getProcessSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listProcessesSettings = PagedCallSettings.newBuilder(LIST_PROCESSES_PAGE_STR_FACT);
      deleteProcessSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteProcessOperationSettings = OperationCallSettings.newBuilder();
      createRunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getRunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRunsSettings = PagedCallSettings.newBuilder(LIST_RUNS_PAGE_STR_FACT);
      deleteRunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRunOperationSettings = OperationCallSettings.newBuilder();
      createLineageEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getLineageEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLineageEventsSettings = PagedCallSettings.newBuilder(LIST_LINEAGE_EVENTS_PAGE_STR_FACT);
      deleteLineageEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      searchLinksSettings = PagedCallSettings.newBuilder(SEARCH_LINKS_PAGE_STR_FACT);
      batchSearchLinkProcessesSettings =
          PagedCallSettings.newBuilder(BATCH_SEARCH_LINK_PROCESSES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              processOpenLineageRunEventSettings,
              createProcessSettings,
              updateProcessSettings,
              getProcessSettings,
              listProcessesSettings,
              deleteProcessSettings,
              createRunSettings,
              updateRunSettings,
              getRunSettings,
              listRunsSettings,
              deleteRunSettings,
              createLineageEventSettings,
              getLineageEventSettings,
              listLineageEventsSettings,
              deleteLineageEventSettings,
              searchLinksSettings,
              batchSearchLinkProcessesSettings);
      initDefaults(this);
    }

    protected Builder(LineageStubSettings settings) {
      super(settings);

      processOpenLineageRunEventSettings = settings.processOpenLineageRunEventSettings.toBuilder();
      createProcessSettings = settings.createProcessSettings.toBuilder();
      updateProcessSettings = settings.updateProcessSettings.toBuilder();
      getProcessSettings = settings.getProcessSettings.toBuilder();
      listProcessesSettings = settings.listProcessesSettings.toBuilder();
      deleteProcessSettings = settings.deleteProcessSettings.toBuilder();
      deleteProcessOperationSettings = settings.deleteProcessOperationSettings.toBuilder();
      createRunSettings = settings.createRunSettings.toBuilder();
      updateRunSettings = settings.updateRunSettings.toBuilder();
      getRunSettings = settings.getRunSettings.toBuilder();
      listRunsSettings = settings.listRunsSettings.toBuilder();
      deleteRunSettings = settings.deleteRunSettings.toBuilder();
      deleteRunOperationSettings = settings.deleteRunOperationSettings.toBuilder();
      createLineageEventSettings = settings.createLineageEventSettings.toBuilder();
      getLineageEventSettings = settings.getLineageEventSettings.toBuilder();
      listLineageEventsSettings = settings.listLineageEventsSettings.toBuilder();
      deleteLineageEventSettings = settings.deleteLineageEventSettings.toBuilder();
      searchLinksSettings = settings.searchLinksSettings.toBuilder();
      batchSearchLinkProcessesSettings = settings.batchSearchLinkProcessesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              processOpenLineageRunEventSettings,
              createProcessSettings,
              updateProcessSettings,
              getProcessSettings,
              listProcessesSettings,
              deleteProcessSettings,
              createRunSettings,
              updateRunSettings,
              getRunSettings,
              listRunsSettings,
              deleteRunSettings,
              createLineageEventSettings,
              getLineageEventSettings,
              listLineageEventsSettings,
              deleteLineageEventSettings,
              searchLinksSettings,
              batchSearchLinkProcessesSettings);
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
          .processOpenLineageRunEventSettings()
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
          .getProcessSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listProcessesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteProcessSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createRunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateRunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listRunsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteRunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createLineageEventSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getLineageEventSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLineageEventsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteLineageEventSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .searchLinksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchSearchLinkProcessesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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
          .deleteRunOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteRunRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to processOpenLineageRunEvent. */
    public UnaryCallSettings.Builder<
            ProcessOpenLineageRunEventRequest, ProcessOpenLineageRunEventResponse>
        processOpenLineageRunEventSettings() {
      return processOpenLineageRunEventSettings;
    }

    /** Returns the builder for the settings used for calls to createProcess. */
    public UnaryCallSettings.Builder<CreateProcessRequest, Process> createProcessSettings() {
      return createProcessSettings;
    }

    /** Returns the builder for the settings used for calls to updateProcess. */
    public UnaryCallSettings.Builder<UpdateProcessRequest, Process> updateProcessSettings() {
      return updateProcessSettings;
    }

    /** Returns the builder for the settings used for calls to getProcess. */
    public UnaryCallSettings.Builder<GetProcessRequest, Process> getProcessSettings() {
      return getProcessSettings;
    }

    /** Returns the builder for the settings used for calls to listProcesses. */
    public PagedCallSettings.Builder<
            ListProcessesRequest, ListProcessesResponse, ListProcessesPagedResponse>
        listProcessesSettings() {
      return listProcessesSettings;
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

    /** Returns the builder for the settings used for calls to createRun. */
    public UnaryCallSettings.Builder<CreateRunRequest, Run> createRunSettings() {
      return createRunSettings;
    }

    /** Returns the builder for the settings used for calls to updateRun. */
    public UnaryCallSettings.Builder<UpdateRunRequest, Run> updateRunSettings() {
      return updateRunSettings;
    }

    /** Returns the builder for the settings used for calls to getRun. */
    public UnaryCallSettings.Builder<GetRunRequest, Run> getRunSettings() {
      return getRunSettings;
    }

    /** Returns the builder for the settings used for calls to listRuns. */
    public PagedCallSettings.Builder<ListRunsRequest, ListRunsResponse, ListRunsPagedResponse>
        listRunsSettings() {
      return listRunsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRun. */
    public UnaryCallSettings.Builder<DeleteRunRequest, Operation> deleteRunSettings() {
      return deleteRunSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRun. */
    public OperationCallSettings.Builder<DeleteRunRequest, Empty, OperationMetadata>
        deleteRunOperationSettings() {
      return deleteRunOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createLineageEvent. */
    public UnaryCallSettings.Builder<CreateLineageEventRequest, LineageEvent>
        createLineageEventSettings() {
      return createLineageEventSettings;
    }

    /** Returns the builder for the settings used for calls to getLineageEvent. */
    public UnaryCallSettings.Builder<GetLineageEventRequest, LineageEvent>
        getLineageEventSettings() {
      return getLineageEventSettings;
    }

    /** Returns the builder for the settings used for calls to listLineageEvents. */
    public PagedCallSettings.Builder<
            ListLineageEventsRequest, ListLineageEventsResponse, ListLineageEventsPagedResponse>
        listLineageEventsSettings() {
      return listLineageEventsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteLineageEvent. */
    public UnaryCallSettings.Builder<DeleteLineageEventRequest, Empty>
        deleteLineageEventSettings() {
      return deleteLineageEventSettings;
    }

    /** Returns the builder for the settings used for calls to searchLinks. */
    public PagedCallSettings.Builder<
            SearchLinksRequest, SearchLinksResponse, SearchLinksPagedResponse>
        searchLinksSettings() {
      return searchLinksSettings;
    }

    /** Returns the builder for the settings used for calls to batchSearchLinkProcesses. */
    public PagedCallSettings.Builder<
            BatchSearchLinkProcessesRequest,
            BatchSearchLinkProcessesResponse,
            BatchSearchLinkProcessesPagedResponse>
        batchSearchLinkProcessesSettings() {
      return batchSearchLinkProcessesSettings;
    }

    @Override
    public LineageStubSettings build() throws IOException {
      return new LineageStubSettings(this);
    }
  }
}
