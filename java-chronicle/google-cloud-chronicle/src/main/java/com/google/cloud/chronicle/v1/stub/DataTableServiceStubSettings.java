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

import static com.google.cloud.chronicle.v1.DataTableServiceClient.ListDataTableRowsPagedResponse;
import static com.google.cloud.chronicle.v1.DataTableServiceClient.ListDataTablesPagedResponse;

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
import com.google.cloud.chronicle.v1.BulkCreateDataTableRowsRequest;
import com.google.cloud.chronicle.v1.BulkCreateDataTableRowsResponse;
import com.google.cloud.chronicle.v1.BulkGetDataTableRowsRequest;
import com.google.cloud.chronicle.v1.BulkGetDataTableRowsResponse;
import com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsRequest;
import com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsResponse;
import com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsRequest;
import com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsResponse;
import com.google.cloud.chronicle.v1.CreateDataTableRequest;
import com.google.cloud.chronicle.v1.CreateDataTableRowRequest;
import com.google.cloud.chronicle.v1.DataTable;
import com.google.cloud.chronicle.v1.DataTableOperationErrors;
import com.google.cloud.chronicle.v1.DataTableRow;
import com.google.cloud.chronicle.v1.DeleteDataTableRequest;
import com.google.cloud.chronicle.v1.DeleteDataTableRowRequest;
import com.google.cloud.chronicle.v1.GetDataTableOperationErrorsRequest;
import com.google.cloud.chronicle.v1.GetDataTableRequest;
import com.google.cloud.chronicle.v1.GetDataTableRowRequest;
import com.google.cloud.chronicle.v1.ListDataTableRowsRequest;
import com.google.cloud.chronicle.v1.ListDataTableRowsResponse;
import com.google.cloud.chronicle.v1.ListDataTablesRequest;
import com.google.cloud.chronicle.v1.ListDataTablesResponse;
import com.google.cloud.chronicle.v1.UpdateDataTableRequest;
import com.google.cloud.chronicle.v1.UpdateDataTableRowRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataTableServiceStub}.
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
 * of createDataTable:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataTableServiceStubSettings.Builder dataTableServiceSettingsBuilder =
 *     DataTableServiceStubSettings.newBuilder();
 * dataTableServiceSettingsBuilder
 *     .createDataTableSettings()
 *     .setRetrySettings(
 *         dataTableServiceSettingsBuilder
 *             .createDataTableSettings()
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
 * DataTableServiceStubSettings dataTableServiceSettings = dataTableServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class DataTableServiceStubSettings extends StubSettings<DataTableServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/chronicle")
          .add("https://www.googleapis.com/auth/chronicle.readonly")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<CreateDataTableRequest, DataTable> createDataTableSettings;
  private final PagedCallSettings<
          ListDataTablesRequest, ListDataTablesResponse, ListDataTablesPagedResponse>
      listDataTablesSettings;
  private final UnaryCallSettings<GetDataTableRequest, DataTable> getDataTableSettings;
  private final UnaryCallSettings<UpdateDataTableRequest, DataTable> updateDataTableSettings;
  private final UnaryCallSettings<DeleteDataTableRequest, Empty> deleteDataTableSettings;
  private final UnaryCallSettings<CreateDataTableRowRequest, DataTableRow>
      createDataTableRowSettings;
  private final UnaryCallSettings<UpdateDataTableRowRequest, DataTableRow>
      updateDataTableRowSettings;
  private final PagedCallSettings<
          ListDataTableRowsRequest, ListDataTableRowsResponse, ListDataTableRowsPagedResponse>
      listDataTableRowsSettings;
  private final UnaryCallSettings<GetDataTableRowRequest, DataTableRow> getDataTableRowSettings;
  private final UnaryCallSettings<DeleteDataTableRowRequest, Empty> deleteDataTableRowSettings;
  private final UnaryCallSettings<BulkCreateDataTableRowsRequest, BulkCreateDataTableRowsResponse>
      bulkCreateDataTableRowsSettings;
  private final UnaryCallSettings<BulkGetDataTableRowsRequest, BulkGetDataTableRowsResponse>
      bulkGetDataTableRowsSettings;
  private final UnaryCallSettings<BulkReplaceDataTableRowsRequest, BulkReplaceDataTableRowsResponse>
      bulkReplaceDataTableRowsSettings;
  private final UnaryCallSettings<BulkUpdateDataTableRowsRequest, BulkUpdateDataTableRowsResponse>
      bulkUpdateDataTableRowsSettings;
  private final UnaryCallSettings<GetDataTableOperationErrorsRequest, DataTableOperationErrors>
      getDataTableOperationErrorsSettings;

  private static final PagedListDescriptor<ListDataTablesRequest, ListDataTablesResponse, DataTable>
      LIST_DATA_TABLES_PAGE_STR_DESC =
          new PagedListDescriptor<ListDataTablesRequest, ListDataTablesResponse, DataTable>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataTablesRequest injectToken(ListDataTablesRequest payload, String token) {
              return ListDataTablesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataTablesRequest injectPageSize(
                ListDataTablesRequest payload, int pageSize) {
              return ListDataTablesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataTablesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataTablesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataTable> extractResources(ListDataTablesResponse payload) {
              return payload.getDataTablesList();
            }
          };

  private static final PagedListDescriptor<
          ListDataTableRowsRequest, ListDataTableRowsResponse, DataTableRow>
      LIST_DATA_TABLE_ROWS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDataTableRowsRequest, ListDataTableRowsResponse, DataTableRow>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataTableRowsRequest injectToken(
                ListDataTableRowsRequest payload, String token) {
              return ListDataTableRowsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataTableRowsRequest injectPageSize(
                ListDataTableRowsRequest payload, int pageSize) {
              return ListDataTableRowsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataTableRowsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataTableRowsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataTableRow> extractResources(ListDataTableRowsResponse payload) {
              return payload.getDataTableRowsList();
            }
          };

  private static final PagedListResponseFactory<
          ListDataTablesRequest, ListDataTablesResponse, ListDataTablesPagedResponse>
      LIST_DATA_TABLES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataTablesRequest, ListDataTablesResponse, ListDataTablesPagedResponse>() {
            @Override
            public ApiFuture<ListDataTablesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataTablesRequest, ListDataTablesResponse> callable,
                ListDataTablesRequest request,
                ApiCallContext context,
                ApiFuture<ListDataTablesResponse> futureResponse) {
              PageContext<ListDataTablesRequest, ListDataTablesResponse, DataTable> pageContext =
                  PageContext.create(callable, LIST_DATA_TABLES_PAGE_STR_DESC, request, context);
              return ListDataTablesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDataTableRowsRequest, ListDataTableRowsResponse, ListDataTableRowsPagedResponse>
      LIST_DATA_TABLE_ROWS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataTableRowsRequest,
              ListDataTableRowsResponse,
              ListDataTableRowsPagedResponse>() {
            @Override
            public ApiFuture<ListDataTableRowsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataTableRowsRequest, ListDataTableRowsResponse> callable,
                ListDataTableRowsRequest request,
                ApiCallContext context,
                ApiFuture<ListDataTableRowsResponse> futureResponse) {
              PageContext<ListDataTableRowsRequest, ListDataTableRowsResponse, DataTableRow>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DATA_TABLE_ROWS_PAGE_STR_DESC, request, context);
              return ListDataTableRowsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createDataTable. */
  public UnaryCallSettings<CreateDataTableRequest, DataTable> createDataTableSettings() {
    return createDataTableSettings;
  }

  /** Returns the object with the settings used for calls to listDataTables. */
  public PagedCallSettings<
          ListDataTablesRequest, ListDataTablesResponse, ListDataTablesPagedResponse>
      listDataTablesSettings() {
    return listDataTablesSettings;
  }

  /** Returns the object with the settings used for calls to getDataTable. */
  public UnaryCallSettings<GetDataTableRequest, DataTable> getDataTableSettings() {
    return getDataTableSettings;
  }

  /** Returns the object with the settings used for calls to updateDataTable. */
  public UnaryCallSettings<UpdateDataTableRequest, DataTable> updateDataTableSettings() {
    return updateDataTableSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataTable. */
  public UnaryCallSettings<DeleteDataTableRequest, Empty> deleteDataTableSettings() {
    return deleteDataTableSettings;
  }

  /** Returns the object with the settings used for calls to createDataTableRow. */
  public UnaryCallSettings<CreateDataTableRowRequest, DataTableRow> createDataTableRowSettings() {
    return createDataTableRowSettings;
  }

  /** Returns the object with the settings used for calls to updateDataTableRow. */
  public UnaryCallSettings<UpdateDataTableRowRequest, DataTableRow> updateDataTableRowSettings() {
    return updateDataTableRowSettings;
  }

  /** Returns the object with the settings used for calls to listDataTableRows. */
  public PagedCallSettings<
          ListDataTableRowsRequest, ListDataTableRowsResponse, ListDataTableRowsPagedResponse>
      listDataTableRowsSettings() {
    return listDataTableRowsSettings;
  }

  /** Returns the object with the settings used for calls to getDataTableRow. */
  public UnaryCallSettings<GetDataTableRowRequest, DataTableRow> getDataTableRowSettings() {
    return getDataTableRowSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataTableRow. */
  public UnaryCallSettings<DeleteDataTableRowRequest, Empty> deleteDataTableRowSettings() {
    return deleteDataTableRowSettings;
  }

  /** Returns the object with the settings used for calls to bulkCreateDataTableRows. */
  public UnaryCallSettings<BulkCreateDataTableRowsRequest, BulkCreateDataTableRowsResponse>
      bulkCreateDataTableRowsSettings() {
    return bulkCreateDataTableRowsSettings;
  }

  /** Returns the object with the settings used for calls to bulkGetDataTableRows. */
  public UnaryCallSettings<BulkGetDataTableRowsRequest, BulkGetDataTableRowsResponse>
      bulkGetDataTableRowsSettings() {
    return bulkGetDataTableRowsSettings;
  }

  /** Returns the object with the settings used for calls to bulkReplaceDataTableRows. */
  public UnaryCallSettings<BulkReplaceDataTableRowsRequest, BulkReplaceDataTableRowsResponse>
      bulkReplaceDataTableRowsSettings() {
    return bulkReplaceDataTableRowsSettings;
  }

  /** Returns the object with the settings used for calls to bulkUpdateDataTableRows. */
  public UnaryCallSettings<BulkUpdateDataTableRowsRequest, BulkUpdateDataTableRowsResponse>
      bulkUpdateDataTableRowsSettings() {
    return bulkUpdateDataTableRowsSettings;
  }

  /** Returns the object with the settings used for calls to getDataTableOperationErrors. */
  public UnaryCallSettings<GetDataTableOperationErrorsRequest, DataTableOperationErrors>
      getDataTableOperationErrorsSettings() {
    return getDataTableOperationErrorsSettings;
  }

  public DataTableServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataTableServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDataTableServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(DataTableServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataTableServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataTableServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DataTableServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createDataTableSettings = settingsBuilder.createDataTableSettings().build();
    listDataTablesSettings = settingsBuilder.listDataTablesSettings().build();
    getDataTableSettings = settingsBuilder.getDataTableSettings().build();
    updateDataTableSettings = settingsBuilder.updateDataTableSettings().build();
    deleteDataTableSettings = settingsBuilder.deleteDataTableSettings().build();
    createDataTableRowSettings = settingsBuilder.createDataTableRowSettings().build();
    updateDataTableRowSettings = settingsBuilder.updateDataTableRowSettings().build();
    listDataTableRowsSettings = settingsBuilder.listDataTableRowsSettings().build();
    getDataTableRowSettings = settingsBuilder.getDataTableRowSettings().build();
    deleteDataTableRowSettings = settingsBuilder.deleteDataTableRowSettings().build();
    bulkCreateDataTableRowsSettings = settingsBuilder.bulkCreateDataTableRowsSettings().build();
    bulkGetDataTableRowsSettings = settingsBuilder.bulkGetDataTableRowsSettings().build();
    bulkReplaceDataTableRowsSettings = settingsBuilder.bulkReplaceDataTableRowsSettings().build();
    bulkUpdateDataTableRowsSettings = settingsBuilder.bulkUpdateDataTableRowsSettings().build();
    getDataTableOperationErrorsSettings =
        settingsBuilder.getDataTableOperationErrorsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-chronicle")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for DataTableServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<DataTableServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateDataTableRequest, DataTable>
        createDataTableSettings;
    private final PagedCallSettings.Builder<
            ListDataTablesRequest, ListDataTablesResponse, ListDataTablesPagedResponse>
        listDataTablesSettings;
    private final UnaryCallSettings.Builder<GetDataTableRequest, DataTable> getDataTableSettings;
    private final UnaryCallSettings.Builder<UpdateDataTableRequest, DataTable>
        updateDataTableSettings;
    private final UnaryCallSettings.Builder<DeleteDataTableRequest, Empty> deleteDataTableSettings;
    private final UnaryCallSettings.Builder<CreateDataTableRowRequest, DataTableRow>
        createDataTableRowSettings;
    private final UnaryCallSettings.Builder<UpdateDataTableRowRequest, DataTableRow>
        updateDataTableRowSettings;
    private final PagedCallSettings.Builder<
            ListDataTableRowsRequest, ListDataTableRowsResponse, ListDataTableRowsPagedResponse>
        listDataTableRowsSettings;
    private final UnaryCallSettings.Builder<GetDataTableRowRequest, DataTableRow>
        getDataTableRowSettings;
    private final UnaryCallSettings.Builder<DeleteDataTableRowRequest, Empty>
        deleteDataTableRowSettings;
    private final UnaryCallSettings.Builder<
            BulkCreateDataTableRowsRequest, BulkCreateDataTableRowsResponse>
        bulkCreateDataTableRowsSettings;
    private final UnaryCallSettings.Builder<
            BulkGetDataTableRowsRequest, BulkGetDataTableRowsResponse>
        bulkGetDataTableRowsSettings;
    private final UnaryCallSettings.Builder<
            BulkReplaceDataTableRowsRequest, BulkReplaceDataTableRowsResponse>
        bulkReplaceDataTableRowsSettings;
    private final UnaryCallSettings.Builder<
            BulkUpdateDataTableRowsRequest, BulkUpdateDataTableRowsResponse>
        bulkUpdateDataTableRowsSettings;
    private final UnaryCallSettings.Builder<
            GetDataTableOperationErrorsRequest, DataTableOperationErrors>
        getDataTableOperationErrorsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_7_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_6_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_7_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_6_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createDataTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDataTablesSettings = PagedCallSettings.newBuilder(LIST_DATA_TABLES_PAGE_STR_FACT);
      getDataTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDataTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDataTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDataTableRowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDataTableRowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDataTableRowsSettings = PagedCallSettings.newBuilder(LIST_DATA_TABLE_ROWS_PAGE_STR_FACT);
      getDataTableRowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDataTableRowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      bulkCreateDataTableRowsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      bulkGetDataTableRowsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      bulkReplaceDataTableRowsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      bulkUpdateDataTableRowsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDataTableOperationErrorsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDataTableSettings,
              listDataTablesSettings,
              getDataTableSettings,
              updateDataTableSettings,
              deleteDataTableSettings,
              createDataTableRowSettings,
              updateDataTableRowSettings,
              listDataTableRowsSettings,
              getDataTableRowSettings,
              deleteDataTableRowSettings,
              bulkCreateDataTableRowsSettings,
              bulkGetDataTableRowsSettings,
              bulkReplaceDataTableRowsSettings,
              bulkUpdateDataTableRowsSettings,
              getDataTableOperationErrorsSettings);
      initDefaults(this);
    }

    protected Builder(DataTableServiceStubSettings settings) {
      super(settings);

      createDataTableSettings = settings.createDataTableSettings.toBuilder();
      listDataTablesSettings = settings.listDataTablesSettings.toBuilder();
      getDataTableSettings = settings.getDataTableSettings.toBuilder();
      updateDataTableSettings = settings.updateDataTableSettings.toBuilder();
      deleteDataTableSettings = settings.deleteDataTableSettings.toBuilder();
      createDataTableRowSettings = settings.createDataTableRowSettings.toBuilder();
      updateDataTableRowSettings = settings.updateDataTableRowSettings.toBuilder();
      listDataTableRowsSettings = settings.listDataTableRowsSettings.toBuilder();
      getDataTableRowSettings = settings.getDataTableRowSettings.toBuilder();
      deleteDataTableRowSettings = settings.deleteDataTableRowSettings.toBuilder();
      bulkCreateDataTableRowsSettings = settings.bulkCreateDataTableRowsSettings.toBuilder();
      bulkGetDataTableRowsSettings = settings.bulkGetDataTableRowsSettings.toBuilder();
      bulkReplaceDataTableRowsSettings = settings.bulkReplaceDataTableRowsSettings.toBuilder();
      bulkUpdateDataTableRowsSettings = settings.bulkUpdateDataTableRowsSettings.toBuilder();
      getDataTableOperationErrorsSettings =
          settings.getDataTableOperationErrorsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDataTableSettings,
              listDataTablesSettings,
              getDataTableSettings,
              updateDataTableSettings,
              deleteDataTableSettings,
              createDataTableRowSettings,
              updateDataTableRowSettings,
              listDataTableRowsSettings,
              getDataTableRowSettings,
              deleteDataTableRowSettings,
              bulkCreateDataTableRowsSettings,
              bulkGetDataTableRowsSettings,
              bulkReplaceDataTableRowsSettings,
              bulkUpdateDataTableRowsSettings,
              getDataTableOperationErrorsSettings);
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
          .createDataTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .listDataTablesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .getDataTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .updateDataTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .deleteDataTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .createDataTableRowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .updateDataTableRowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .listDataTableRowsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .getDataTableRowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .deleteDataTableRowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .bulkCreateDataTableRowsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .bulkGetDataTableRowsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .bulkReplaceDataTableRowsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .bulkUpdateDataTableRowsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .getDataTableOperationErrorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

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

    /** Returns the builder for the settings used for calls to createDataTable. */
    public UnaryCallSettings.Builder<CreateDataTableRequest, DataTable> createDataTableSettings() {
      return createDataTableSettings;
    }

    /** Returns the builder for the settings used for calls to listDataTables. */
    public PagedCallSettings.Builder<
            ListDataTablesRequest, ListDataTablesResponse, ListDataTablesPagedResponse>
        listDataTablesSettings() {
      return listDataTablesSettings;
    }

    /** Returns the builder for the settings used for calls to getDataTable. */
    public UnaryCallSettings.Builder<GetDataTableRequest, DataTable> getDataTableSettings() {
      return getDataTableSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataTable. */
    public UnaryCallSettings.Builder<UpdateDataTableRequest, DataTable> updateDataTableSettings() {
      return updateDataTableSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataTable. */
    public UnaryCallSettings.Builder<DeleteDataTableRequest, Empty> deleteDataTableSettings() {
      return deleteDataTableSettings;
    }

    /** Returns the builder for the settings used for calls to createDataTableRow. */
    public UnaryCallSettings.Builder<CreateDataTableRowRequest, DataTableRow>
        createDataTableRowSettings() {
      return createDataTableRowSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataTableRow. */
    public UnaryCallSettings.Builder<UpdateDataTableRowRequest, DataTableRow>
        updateDataTableRowSettings() {
      return updateDataTableRowSettings;
    }

    /** Returns the builder for the settings used for calls to listDataTableRows. */
    public PagedCallSettings.Builder<
            ListDataTableRowsRequest, ListDataTableRowsResponse, ListDataTableRowsPagedResponse>
        listDataTableRowsSettings() {
      return listDataTableRowsSettings;
    }

    /** Returns the builder for the settings used for calls to getDataTableRow. */
    public UnaryCallSettings.Builder<GetDataTableRowRequest, DataTableRow>
        getDataTableRowSettings() {
      return getDataTableRowSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataTableRow. */
    public UnaryCallSettings.Builder<DeleteDataTableRowRequest, Empty>
        deleteDataTableRowSettings() {
      return deleteDataTableRowSettings;
    }

    /** Returns the builder for the settings used for calls to bulkCreateDataTableRows. */
    public UnaryCallSettings.Builder<
            BulkCreateDataTableRowsRequest, BulkCreateDataTableRowsResponse>
        bulkCreateDataTableRowsSettings() {
      return bulkCreateDataTableRowsSettings;
    }

    /** Returns the builder for the settings used for calls to bulkGetDataTableRows. */
    public UnaryCallSettings.Builder<BulkGetDataTableRowsRequest, BulkGetDataTableRowsResponse>
        bulkGetDataTableRowsSettings() {
      return bulkGetDataTableRowsSettings;
    }

    /** Returns the builder for the settings used for calls to bulkReplaceDataTableRows. */
    public UnaryCallSettings.Builder<
            BulkReplaceDataTableRowsRequest, BulkReplaceDataTableRowsResponse>
        bulkReplaceDataTableRowsSettings() {
      return bulkReplaceDataTableRowsSettings;
    }

    /** Returns the builder for the settings used for calls to bulkUpdateDataTableRows. */
    public UnaryCallSettings.Builder<
            BulkUpdateDataTableRowsRequest, BulkUpdateDataTableRowsResponse>
        bulkUpdateDataTableRowsSettings() {
      return bulkUpdateDataTableRowsSettings;
    }

    /** Returns the builder for the settings used for calls to getDataTableOperationErrors. */
    public UnaryCallSettings.Builder<GetDataTableOperationErrorsRequest, DataTableOperationErrors>
        getDataTableOperationErrorsSettings() {
      return getDataTableOperationErrorsSettings;
    }

    @Override
    public DataTableServiceStubSettings build() throws IOException {
      return new DataTableServiceStubSettings(this);
    }
  }
}
