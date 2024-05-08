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

package com.google.analytics.data.v1alpha.stub;

import static com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient.ListAudienceListsPagedResponse;
import static com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient.ListRecurringAudienceListsPagedResponse;
import static com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient.ListReportTasksPagedResponse;

import com.google.analytics.data.v1alpha.AudienceList;
import com.google.analytics.data.v1alpha.AudienceListMetadata;
import com.google.analytics.data.v1alpha.CreateAudienceListRequest;
import com.google.analytics.data.v1alpha.CreateRecurringAudienceListRequest;
import com.google.analytics.data.v1alpha.CreateReportTaskRequest;
import com.google.analytics.data.v1alpha.GetAudienceListRequest;
import com.google.analytics.data.v1alpha.GetRecurringAudienceListRequest;
import com.google.analytics.data.v1alpha.GetReportTaskRequest;
import com.google.analytics.data.v1alpha.ListAudienceListsRequest;
import com.google.analytics.data.v1alpha.ListAudienceListsResponse;
import com.google.analytics.data.v1alpha.ListRecurringAudienceListsRequest;
import com.google.analytics.data.v1alpha.ListRecurringAudienceListsResponse;
import com.google.analytics.data.v1alpha.ListReportTasksRequest;
import com.google.analytics.data.v1alpha.ListReportTasksResponse;
import com.google.analytics.data.v1alpha.QueryAudienceListRequest;
import com.google.analytics.data.v1alpha.QueryAudienceListResponse;
import com.google.analytics.data.v1alpha.QueryReportTaskRequest;
import com.google.analytics.data.v1alpha.QueryReportTaskResponse;
import com.google.analytics.data.v1alpha.RecurringAudienceList;
import com.google.analytics.data.v1alpha.ReportTask;
import com.google.analytics.data.v1alpha.ReportTaskMetadata;
import com.google.analytics.data.v1alpha.RunFunnelReportRequest;
import com.google.analytics.data.v1alpha.RunFunnelReportResponse;
import com.google.analytics.data.v1alpha.SheetExportAudienceListRequest;
import com.google.analytics.data.v1alpha.SheetExportAudienceListResponse;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AlphaAnalyticsDataStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (analyticsdata.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of runFunnelReport to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AlphaAnalyticsDataStubSettings.Builder alphaAnalyticsDataSettingsBuilder =
 *     AlphaAnalyticsDataStubSettings.newBuilder();
 * alphaAnalyticsDataSettingsBuilder
 *     .runFunnelReportSettings()
 *     .setRetrySettings(
 *         alphaAnalyticsDataSettingsBuilder
 *             .runFunnelReportSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AlphaAnalyticsDataStubSettings alphaAnalyticsDataSettings =
 *     alphaAnalyticsDataSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AlphaAnalyticsDataStubSettings extends StubSettings<AlphaAnalyticsDataStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/analytics")
          .add("https://www.googleapis.com/auth/analytics.readonly")
          .add("https://www.googleapis.com/auth/drive")
          .add("https://www.googleapis.com/auth/drive.file")
          .add("https://www.googleapis.com/auth/spreadsheets")
          .build();

  private final UnaryCallSettings<RunFunnelReportRequest, RunFunnelReportResponse>
      runFunnelReportSettings;
  private final UnaryCallSettings<CreateAudienceListRequest, Operation> createAudienceListSettings;
  private final OperationCallSettings<CreateAudienceListRequest, AudienceList, AudienceListMetadata>
      createAudienceListOperationSettings;
  private final UnaryCallSettings<QueryAudienceListRequest, QueryAudienceListResponse>
      queryAudienceListSettings;
  private final UnaryCallSettings<SheetExportAudienceListRequest, SheetExportAudienceListResponse>
      sheetExportAudienceListSettings;
  private final UnaryCallSettings<GetAudienceListRequest, AudienceList> getAudienceListSettings;
  private final PagedCallSettings<
          ListAudienceListsRequest, ListAudienceListsResponse, ListAudienceListsPagedResponse>
      listAudienceListsSettings;
  private final UnaryCallSettings<CreateRecurringAudienceListRequest, RecurringAudienceList>
      createRecurringAudienceListSettings;
  private final UnaryCallSettings<GetRecurringAudienceListRequest, RecurringAudienceList>
      getRecurringAudienceListSettings;
  private final PagedCallSettings<
          ListRecurringAudienceListsRequest,
          ListRecurringAudienceListsResponse,
          ListRecurringAudienceListsPagedResponse>
      listRecurringAudienceListsSettings;
  private final UnaryCallSettings<CreateReportTaskRequest, Operation> createReportTaskSettings;
  private final OperationCallSettings<CreateReportTaskRequest, ReportTask, ReportTaskMetadata>
      createReportTaskOperationSettings;
  private final UnaryCallSettings<QueryReportTaskRequest, QueryReportTaskResponse>
      queryReportTaskSettings;
  private final UnaryCallSettings<GetReportTaskRequest, ReportTask> getReportTaskSettings;
  private final PagedCallSettings<
          ListReportTasksRequest, ListReportTasksResponse, ListReportTasksPagedResponse>
      listReportTasksSettings;

  private static final PagedListDescriptor<
          ListAudienceListsRequest, ListAudienceListsResponse, AudienceList>
      LIST_AUDIENCE_LISTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAudienceListsRequest, ListAudienceListsResponse, AudienceList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAudienceListsRequest injectToken(
                ListAudienceListsRequest payload, String token) {
              return ListAudienceListsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAudienceListsRequest injectPageSize(
                ListAudienceListsRequest payload, int pageSize) {
              return ListAudienceListsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAudienceListsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAudienceListsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AudienceList> extractResources(ListAudienceListsResponse payload) {
              return payload.getAudienceListsList() == null
                  ? ImmutableList.<AudienceList>of()
                  : payload.getAudienceListsList();
            }
          };

  private static final PagedListDescriptor<
          ListRecurringAudienceListsRequest,
          ListRecurringAudienceListsResponse,
          RecurringAudienceList>
      LIST_RECURRING_AUDIENCE_LISTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRecurringAudienceListsRequest,
              ListRecurringAudienceListsResponse,
              RecurringAudienceList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRecurringAudienceListsRequest injectToken(
                ListRecurringAudienceListsRequest payload, String token) {
              return ListRecurringAudienceListsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListRecurringAudienceListsRequest injectPageSize(
                ListRecurringAudienceListsRequest payload, int pageSize) {
              return ListRecurringAudienceListsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListRecurringAudienceListsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRecurringAudienceListsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<RecurringAudienceList> extractResources(
                ListRecurringAudienceListsResponse payload) {
              return payload.getRecurringAudienceListsList() == null
                  ? ImmutableList.<RecurringAudienceList>of()
                  : payload.getRecurringAudienceListsList();
            }
          };

  private static final PagedListDescriptor<
          ListReportTasksRequest, ListReportTasksResponse, ReportTask>
      LIST_REPORT_TASKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListReportTasksRequest, ListReportTasksResponse, ReportTask>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReportTasksRequest injectToken(
                ListReportTasksRequest payload, String token) {
              return ListReportTasksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListReportTasksRequest injectPageSize(
                ListReportTasksRequest payload, int pageSize) {
              return ListReportTasksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListReportTasksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListReportTasksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ReportTask> extractResources(ListReportTasksResponse payload) {
              return payload.getReportTasksList() == null
                  ? ImmutableList.<ReportTask>of()
                  : payload.getReportTasksList();
            }
          };

  private static final PagedListResponseFactory<
          ListAudienceListsRequest, ListAudienceListsResponse, ListAudienceListsPagedResponse>
      LIST_AUDIENCE_LISTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAudienceListsRequest,
              ListAudienceListsResponse,
              ListAudienceListsPagedResponse>() {
            @Override
            public ApiFuture<ListAudienceListsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAudienceListsRequest, ListAudienceListsResponse> callable,
                ListAudienceListsRequest request,
                ApiCallContext context,
                ApiFuture<ListAudienceListsResponse> futureResponse) {
              PageContext<ListAudienceListsRequest, ListAudienceListsResponse, AudienceList>
                  pageContext =
                      PageContext.create(
                          callable, LIST_AUDIENCE_LISTS_PAGE_STR_DESC, request, context);
              return ListAudienceListsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRecurringAudienceListsRequest,
          ListRecurringAudienceListsResponse,
          ListRecurringAudienceListsPagedResponse>
      LIST_RECURRING_AUDIENCE_LISTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRecurringAudienceListsRequest,
              ListRecurringAudienceListsResponse,
              ListRecurringAudienceListsPagedResponse>() {
            @Override
            public ApiFuture<ListRecurringAudienceListsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRecurringAudienceListsRequest, ListRecurringAudienceListsResponse>
                    callable,
                ListRecurringAudienceListsRequest request,
                ApiCallContext context,
                ApiFuture<ListRecurringAudienceListsResponse> futureResponse) {
              PageContext<
                      ListRecurringAudienceListsRequest,
                      ListRecurringAudienceListsResponse,
                      RecurringAudienceList>
                  pageContext =
                      PageContext.create(
                          callable, LIST_RECURRING_AUDIENCE_LISTS_PAGE_STR_DESC, request, context);
              return ListRecurringAudienceListsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListReportTasksRequest, ListReportTasksResponse, ListReportTasksPagedResponse>
      LIST_REPORT_TASKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReportTasksRequest, ListReportTasksResponse, ListReportTasksPagedResponse>() {
            @Override
            public ApiFuture<ListReportTasksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReportTasksRequest, ListReportTasksResponse> callable,
                ListReportTasksRequest request,
                ApiCallContext context,
                ApiFuture<ListReportTasksResponse> futureResponse) {
              PageContext<ListReportTasksRequest, ListReportTasksResponse, ReportTask> pageContext =
                  PageContext.create(callable, LIST_REPORT_TASKS_PAGE_STR_DESC, request, context);
              return ListReportTasksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to runFunnelReport. */
  public UnaryCallSettings<RunFunnelReportRequest, RunFunnelReportResponse>
      runFunnelReportSettings() {
    return runFunnelReportSettings;
  }

  /** Returns the object with the settings used for calls to createAudienceList. */
  public UnaryCallSettings<CreateAudienceListRequest, Operation> createAudienceListSettings() {
    return createAudienceListSettings;
  }

  /** Returns the object with the settings used for calls to createAudienceList. */
  public OperationCallSettings<CreateAudienceListRequest, AudienceList, AudienceListMetadata>
      createAudienceListOperationSettings() {
    return createAudienceListOperationSettings;
  }

  /** Returns the object with the settings used for calls to queryAudienceList. */
  public UnaryCallSettings<QueryAudienceListRequest, QueryAudienceListResponse>
      queryAudienceListSettings() {
    return queryAudienceListSettings;
  }

  /** Returns the object with the settings used for calls to sheetExportAudienceList. */
  public UnaryCallSettings<SheetExportAudienceListRequest, SheetExportAudienceListResponse>
      sheetExportAudienceListSettings() {
    return sheetExportAudienceListSettings;
  }

  /** Returns the object with the settings used for calls to getAudienceList. */
  public UnaryCallSettings<GetAudienceListRequest, AudienceList> getAudienceListSettings() {
    return getAudienceListSettings;
  }

  /** Returns the object with the settings used for calls to listAudienceLists. */
  public PagedCallSettings<
          ListAudienceListsRequest, ListAudienceListsResponse, ListAudienceListsPagedResponse>
      listAudienceListsSettings() {
    return listAudienceListsSettings;
  }

  /** Returns the object with the settings used for calls to createRecurringAudienceList. */
  public UnaryCallSettings<CreateRecurringAudienceListRequest, RecurringAudienceList>
      createRecurringAudienceListSettings() {
    return createRecurringAudienceListSettings;
  }

  /** Returns the object with the settings used for calls to getRecurringAudienceList. */
  public UnaryCallSettings<GetRecurringAudienceListRequest, RecurringAudienceList>
      getRecurringAudienceListSettings() {
    return getRecurringAudienceListSettings;
  }

  /** Returns the object with the settings used for calls to listRecurringAudienceLists. */
  public PagedCallSettings<
          ListRecurringAudienceListsRequest,
          ListRecurringAudienceListsResponse,
          ListRecurringAudienceListsPagedResponse>
      listRecurringAudienceListsSettings() {
    return listRecurringAudienceListsSettings;
  }

  /** Returns the object with the settings used for calls to createReportTask. */
  public UnaryCallSettings<CreateReportTaskRequest, Operation> createReportTaskSettings() {
    return createReportTaskSettings;
  }

  /** Returns the object with the settings used for calls to createReportTask. */
  public OperationCallSettings<CreateReportTaskRequest, ReportTask, ReportTaskMetadata>
      createReportTaskOperationSettings() {
    return createReportTaskOperationSettings;
  }

  /** Returns the object with the settings used for calls to queryReportTask. */
  public UnaryCallSettings<QueryReportTaskRequest, QueryReportTaskResponse>
      queryReportTaskSettings() {
    return queryReportTaskSettings;
  }

  /** Returns the object with the settings used for calls to getReportTask. */
  public UnaryCallSettings<GetReportTaskRequest, ReportTask> getReportTaskSettings() {
    return getReportTaskSettings;
  }

  /** Returns the object with the settings used for calls to listReportTasks. */
  public PagedCallSettings<
          ListReportTasksRequest, ListReportTasksResponse, ListReportTasksPagedResponse>
      listReportTasksSettings() {
    return listReportTasksSettings;
  }

  public AlphaAnalyticsDataStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAlphaAnalyticsDataStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAlphaAnalyticsDataStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "analyticsdata";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "analyticsdata.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "analyticsdata.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(AlphaAnalyticsDataStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AlphaAnalyticsDataStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AlphaAnalyticsDataStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected AlphaAnalyticsDataStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    runFunnelReportSettings = settingsBuilder.runFunnelReportSettings().build();
    createAudienceListSettings = settingsBuilder.createAudienceListSettings().build();
    createAudienceListOperationSettings =
        settingsBuilder.createAudienceListOperationSettings().build();
    queryAudienceListSettings = settingsBuilder.queryAudienceListSettings().build();
    sheetExportAudienceListSettings = settingsBuilder.sheetExportAudienceListSettings().build();
    getAudienceListSettings = settingsBuilder.getAudienceListSettings().build();
    listAudienceListsSettings = settingsBuilder.listAudienceListsSettings().build();
    createRecurringAudienceListSettings =
        settingsBuilder.createRecurringAudienceListSettings().build();
    getRecurringAudienceListSettings = settingsBuilder.getRecurringAudienceListSettings().build();
    listRecurringAudienceListsSettings =
        settingsBuilder.listRecurringAudienceListsSettings().build();
    createReportTaskSettings = settingsBuilder.createReportTaskSettings().build();
    createReportTaskOperationSettings = settingsBuilder.createReportTaskOperationSettings().build();
    queryReportTaskSettings = settingsBuilder.queryReportTaskSettings().build();
    getReportTaskSettings = settingsBuilder.getReportTaskSettings().build();
    listReportTasksSettings = settingsBuilder.listReportTasksSettings().build();
  }

  /** Builder for AlphaAnalyticsDataStubSettings. */
  public static class Builder
      extends StubSettings.Builder<AlphaAnalyticsDataStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<RunFunnelReportRequest, RunFunnelReportResponse>
        runFunnelReportSettings;
    private final UnaryCallSettings.Builder<CreateAudienceListRequest, Operation>
        createAudienceListSettings;
    private final OperationCallSettings.Builder<
            CreateAudienceListRequest, AudienceList, AudienceListMetadata>
        createAudienceListOperationSettings;
    private final UnaryCallSettings.Builder<QueryAudienceListRequest, QueryAudienceListResponse>
        queryAudienceListSettings;
    private final UnaryCallSettings.Builder<
            SheetExportAudienceListRequest, SheetExportAudienceListResponse>
        sheetExportAudienceListSettings;
    private final UnaryCallSettings.Builder<GetAudienceListRequest, AudienceList>
        getAudienceListSettings;
    private final PagedCallSettings.Builder<
            ListAudienceListsRequest, ListAudienceListsResponse, ListAudienceListsPagedResponse>
        listAudienceListsSettings;
    private final UnaryCallSettings.Builder<
            CreateRecurringAudienceListRequest, RecurringAudienceList>
        createRecurringAudienceListSettings;
    private final UnaryCallSettings.Builder<GetRecurringAudienceListRequest, RecurringAudienceList>
        getRecurringAudienceListSettings;
    private final PagedCallSettings.Builder<
            ListRecurringAudienceListsRequest,
            ListRecurringAudienceListsResponse,
            ListRecurringAudienceListsPagedResponse>
        listRecurringAudienceListsSettings;
    private final UnaryCallSettings.Builder<CreateReportTaskRequest, Operation>
        createReportTaskSettings;
    private final OperationCallSettings.Builder<
            CreateReportTaskRequest, ReportTask, ReportTaskMetadata>
        createReportTaskOperationSettings;
    private final UnaryCallSettings.Builder<QueryReportTaskRequest, QueryReportTaskResponse>
        queryReportTaskSettings;
    private final UnaryCallSettings.Builder<GetReportTaskRequest, ReportTask> getReportTaskSettings;
    private final PagedCallSettings.Builder<
            ListReportTasksRequest, ListReportTasksResponse, ListReportTasksPagedResponse>
        listReportTasksSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNKNOWN)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
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

      runFunnelReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAudienceListSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAudienceListOperationSettings = OperationCallSettings.newBuilder();
      queryAudienceListSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      sheetExportAudienceListSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAudienceListSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAudienceListsSettings = PagedCallSettings.newBuilder(LIST_AUDIENCE_LISTS_PAGE_STR_FACT);
      createRecurringAudienceListSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getRecurringAudienceListSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRecurringAudienceListsSettings =
          PagedCallSettings.newBuilder(LIST_RECURRING_AUDIENCE_LISTS_PAGE_STR_FACT);
      createReportTaskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createReportTaskOperationSettings = OperationCallSettings.newBuilder();
      queryReportTaskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getReportTaskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listReportTasksSettings = PagedCallSettings.newBuilder(LIST_REPORT_TASKS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              runFunnelReportSettings,
              createAudienceListSettings,
              queryAudienceListSettings,
              sheetExportAudienceListSettings,
              getAudienceListSettings,
              listAudienceListsSettings,
              createRecurringAudienceListSettings,
              getRecurringAudienceListSettings,
              listRecurringAudienceListsSettings,
              createReportTaskSettings,
              queryReportTaskSettings,
              getReportTaskSettings,
              listReportTasksSettings);
      initDefaults(this);
    }

    protected Builder(AlphaAnalyticsDataStubSettings settings) {
      super(settings);

      runFunnelReportSettings = settings.runFunnelReportSettings.toBuilder();
      createAudienceListSettings = settings.createAudienceListSettings.toBuilder();
      createAudienceListOperationSettings =
          settings.createAudienceListOperationSettings.toBuilder();
      queryAudienceListSettings = settings.queryAudienceListSettings.toBuilder();
      sheetExportAudienceListSettings = settings.sheetExportAudienceListSettings.toBuilder();
      getAudienceListSettings = settings.getAudienceListSettings.toBuilder();
      listAudienceListsSettings = settings.listAudienceListsSettings.toBuilder();
      createRecurringAudienceListSettings =
          settings.createRecurringAudienceListSettings.toBuilder();
      getRecurringAudienceListSettings = settings.getRecurringAudienceListSettings.toBuilder();
      listRecurringAudienceListsSettings = settings.listRecurringAudienceListsSettings.toBuilder();
      createReportTaskSettings = settings.createReportTaskSettings.toBuilder();
      createReportTaskOperationSettings = settings.createReportTaskOperationSettings.toBuilder();
      queryReportTaskSettings = settings.queryReportTaskSettings.toBuilder();
      getReportTaskSettings = settings.getReportTaskSettings.toBuilder();
      listReportTasksSettings = settings.listReportTasksSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              runFunnelReportSettings,
              createAudienceListSettings,
              queryAudienceListSettings,
              sheetExportAudienceListSettings,
              getAudienceListSettings,
              listAudienceListsSettings,
              createRecurringAudienceListSettings,
              getRecurringAudienceListSettings,
              listRecurringAudienceListsSettings,
              createReportTaskSettings,
              queryReportTaskSettings,
              getReportTaskSettings,
              listReportTasksSettings);
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
          .runFunnelReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createAudienceListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .queryAudienceListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .sheetExportAudienceListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAudienceListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAudienceListsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createRecurringAudienceListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRecurringAudienceListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listRecurringAudienceListsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createReportTaskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .queryReportTaskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getReportTaskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listReportTasksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAudienceListOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAudienceListRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AudienceList.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(AudienceListMetadata.class))
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
          .createReportTaskOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateReportTaskRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ReportTask.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(ReportTaskMetadata.class))
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

    /** Returns the builder for the settings used for calls to runFunnelReport. */
    public UnaryCallSettings.Builder<RunFunnelReportRequest, RunFunnelReportResponse>
        runFunnelReportSettings() {
      return runFunnelReportSettings;
    }

    /** Returns the builder for the settings used for calls to createAudienceList. */
    public UnaryCallSettings.Builder<CreateAudienceListRequest, Operation>
        createAudienceListSettings() {
      return createAudienceListSettings;
    }

    /** Returns the builder for the settings used for calls to createAudienceList. */
    public OperationCallSettings.Builder<
            CreateAudienceListRequest, AudienceList, AudienceListMetadata>
        createAudienceListOperationSettings() {
      return createAudienceListOperationSettings;
    }

    /** Returns the builder for the settings used for calls to queryAudienceList. */
    public UnaryCallSettings.Builder<QueryAudienceListRequest, QueryAudienceListResponse>
        queryAudienceListSettings() {
      return queryAudienceListSettings;
    }

    /** Returns the builder for the settings used for calls to sheetExportAudienceList. */
    public UnaryCallSettings.Builder<
            SheetExportAudienceListRequest, SheetExportAudienceListResponse>
        sheetExportAudienceListSettings() {
      return sheetExportAudienceListSettings;
    }

    /** Returns the builder for the settings used for calls to getAudienceList. */
    public UnaryCallSettings.Builder<GetAudienceListRequest, AudienceList>
        getAudienceListSettings() {
      return getAudienceListSettings;
    }

    /** Returns the builder for the settings used for calls to listAudienceLists. */
    public PagedCallSettings.Builder<
            ListAudienceListsRequest, ListAudienceListsResponse, ListAudienceListsPagedResponse>
        listAudienceListsSettings() {
      return listAudienceListsSettings;
    }

    /** Returns the builder for the settings used for calls to createRecurringAudienceList. */
    public UnaryCallSettings.Builder<CreateRecurringAudienceListRequest, RecurringAudienceList>
        createRecurringAudienceListSettings() {
      return createRecurringAudienceListSettings;
    }

    /** Returns the builder for the settings used for calls to getRecurringAudienceList. */
    public UnaryCallSettings.Builder<GetRecurringAudienceListRequest, RecurringAudienceList>
        getRecurringAudienceListSettings() {
      return getRecurringAudienceListSettings;
    }

    /** Returns the builder for the settings used for calls to listRecurringAudienceLists. */
    public PagedCallSettings.Builder<
            ListRecurringAudienceListsRequest,
            ListRecurringAudienceListsResponse,
            ListRecurringAudienceListsPagedResponse>
        listRecurringAudienceListsSettings() {
      return listRecurringAudienceListsSettings;
    }

    /** Returns the builder for the settings used for calls to createReportTask. */
    public UnaryCallSettings.Builder<CreateReportTaskRequest, Operation>
        createReportTaskSettings() {
      return createReportTaskSettings;
    }

    /** Returns the builder for the settings used for calls to createReportTask. */
    public OperationCallSettings.Builder<CreateReportTaskRequest, ReportTask, ReportTaskMetadata>
        createReportTaskOperationSettings() {
      return createReportTaskOperationSettings;
    }

    /** Returns the builder for the settings used for calls to queryReportTask. */
    public UnaryCallSettings.Builder<QueryReportTaskRequest, QueryReportTaskResponse>
        queryReportTaskSettings() {
      return queryReportTaskSettings;
    }

    /** Returns the builder for the settings used for calls to getReportTask. */
    public UnaryCallSettings.Builder<GetReportTaskRequest, ReportTask> getReportTaskSettings() {
      return getReportTaskSettings;
    }

    /** Returns the builder for the settings used for calls to listReportTasks. */
    public PagedCallSettings.Builder<
            ListReportTasksRequest, ListReportTasksResponse, ListReportTasksPagedResponse>
        listReportTasksSettings() {
      return listReportTasksSettings;
    }

    @Override
    public AlphaAnalyticsDataStubSettings build() throws IOException {
      return new AlphaAnalyticsDataStubSettings(this);
    }
  }
}
