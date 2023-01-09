/*
 * Copyright 2022 Google LLC
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

package com.google.area120.tables.v1alpha.stub;

import static com.google.area120.tables.v1alpha.TablesServiceClient.ListRowsPagedResponse;
import static com.google.area120.tables.v1alpha.TablesServiceClient.ListTablesPagedResponse;
import static com.google.area120.tables.v1alpha.TablesServiceClient.ListWorkspacesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.area120.tables.v1alpha1.BatchCreateRowsRequest;
import com.google.area120.tables.v1alpha1.BatchCreateRowsResponse;
import com.google.area120.tables.v1alpha1.BatchDeleteRowsRequest;
import com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest;
import com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse;
import com.google.area120.tables.v1alpha1.CreateRowRequest;
import com.google.area120.tables.v1alpha1.DeleteRowRequest;
import com.google.area120.tables.v1alpha1.GetRowRequest;
import com.google.area120.tables.v1alpha1.GetTableRequest;
import com.google.area120.tables.v1alpha1.GetWorkspaceRequest;
import com.google.area120.tables.v1alpha1.ListRowsRequest;
import com.google.area120.tables.v1alpha1.ListRowsResponse;
import com.google.area120.tables.v1alpha1.ListTablesRequest;
import com.google.area120.tables.v1alpha1.ListTablesResponse;
import com.google.area120.tables.v1alpha1.ListWorkspacesRequest;
import com.google.area120.tables.v1alpha1.ListWorkspacesResponse;
import com.google.area120.tables.v1alpha1.Row;
import com.google.area120.tables.v1alpha1.Table;
import com.google.area120.tables.v1alpha1.UpdateRowRequest;
import com.google.area120.tables.v1alpha1.Workspace;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TablesServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (area120tables.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getTable to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TablesServiceStubSettings.Builder tablesServiceSettingsBuilder =
 *     TablesServiceStubSettings.newBuilder();
 * tablesServiceSettingsBuilder
 *     .getTableSettings()
 *     .setRetrySettings(
 *         tablesServiceSettingsBuilder
 *             .getTableSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TablesServiceStubSettings tablesServiceSettings = tablesServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class TablesServiceStubSettings extends StubSettings<TablesServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/drive")
          .add("https://www.googleapis.com/auth/drive.file")
          .add("https://www.googleapis.com/auth/drive.readonly")
          .add("https://www.googleapis.com/auth/spreadsheets")
          .add("https://www.googleapis.com/auth/spreadsheets.readonly")
          .add("https://www.googleapis.com/auth/tables")
          .build();

  private final UnaryCallSettings<GetTableRequest, Table> getTableSettings;
  private final PagedCallSettings<ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
      listTablesSettings;
  private final UnaryCallSettings<GetWorkspaceRequest, Workspace> getWorkspaceSettings;
  private final PagedCallSettings<
          ListWorkspacesRequest, ListWorkspacesResponse, ListWorkspacesPagedResponse>
      listWorkspacesSettings;
  private final UnaryCallSettings<GetRowRequest, Row> getRowSettings;
  private final PagedCallSettings<ListRowsRequest, ListRowsResponse, ListRowsPagedResponse>
      listRowsSettings;
  private final UnaryCallSettings<CreateRowRequest, Row> createRowSettings;
  private final UnaryCallSettings<BatchCreateRowsRequest, BatchCreateRowsResponse>
      batchCreateRowsSettings;
  private final UnaryCallSettings<UpdateRowRequest, Row> updateRowSettings;
  private final UnaryCallSettings<BatchUpdateRowsRequest, BatchUpdateRowsResponse>
      batchUpdateRowsSettings;
  private final UnaryCallSettings<DeleteRowRequest, Empty> deleteRowSettings;
  private final UnaryCallSettings<BatchDeleteRowsRequest, Empty> batchDeleteRowsSettings;

  private static final PagedListDescriptor<ListTablesRequest, ListTablesResponse, Table>
      LIST_TABLES_PAGE_STR_DESC =
          new PagedListDescriptor<ListTablesRequest, ListTablesResponse, Table>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTablesRequest injectToken(ListTablesRequest payload, String token) {
              return ListTablesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTablesRequest injectPageSize(ListTablesRequest payload, int pageSize) {
              return ListTablesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTablesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTablesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Table> extractResources(ListTablesResponse payload) {
              return payload.getTablesList() == null
                  ? ImmutableList.<Table>of()
                  : payload.getTablesList();
            }
          };

  private static final PagedListDescriptor<ListWorkspacesRequest, ListWorkspacesResponse, Workspace>
      LIST_WORKSPACES_PAGE_STR_DESC =
          new PagedListDescriptor<ListWorkspacesRequest, ListWorkspacesResponse, Workspace>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListWorkspacesRequest injectToken(ListWorkspacesRequest payload, String token) {
              return ListWorkspacesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListWorkspacesRequest injectPageSize(
                ListWorkspacesRequest payload, int pageSize) {
              return ListWorkspacesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListWorkspacesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListWorkspacesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Workspace> extractResources(ListWorkspacesResponse payload) {
              return payload.getWorkspacesList() == null
                  ? ImmutableList.<Workspace>of()
                  : payload.getWorkspacesList();
            }
          };

  private static final PagedListDescriptor<ListRowsRequest, ListRowsResponse, Row>
      LIST_ROWS_PAGE_STR_DESC =
          new PagedListDescriptor<ListRowsRequest, ListRowsResponse, Row>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRowsRequest injectToken(ListRowsRequest payload, String token) {
              return ListRowsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRowsRequest injectPageSize(ListRowsRequest payload, int pageSize) {
              return ListRowsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRowsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRowsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Row> extractResources(ListRowsResponse payload) {
              return payload.getRowsList() == null
                  ? ImmutableList.<Row>of()
                  : payload.getRowsList();
            }
          };

  private static final PagedListResponseFactory<
          ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
      LIST_TABLES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>() {
            @Override
            public ApiFuture<ListTablesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTablesRequest, ListTablesResponse> callable,
                ListTablesRequest request,
                ApiCallContext context,
                ApiFuture<ListTablesResponse> futureResponse) {
              PageContext<ListTablesRequest, ListTablesResponse, Table> pageContext =
                  PageContext.create(callable, LIST_TABLES_PAGE_STR_DESC, request, context);
              return ListTablesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListWorkspacesRequest, ListWorkspacesResponse, ListWorkspacesPagedResponse>
      LIST_WORKSPACES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListWorkspacesRequest, ListWorkspacesResponse, ListWorkspacesPagedResponse>() {
            @Override
            public ApiFuture<ListWorkspacesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListWorkspacesRequest, ListWorkspacesResponse> callable,
                ListWorkspacesRequest request,
                ApiCallContext context,
                ApiFuture<ListWorkspacesResponse> futureResponse) {
              PageContext<ListWorkspacesRequest, ListWorkspacesResponse, Workspace> pageContext =
                  PageContext.create(callable, LIST_WORKSPACES_PAGE_STR_DESC, request, context);
              return ListWorkspacesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRowsRequest, ListRowsResponse, ListRowsPagedResponse>
      LIST_ROWS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListRowsRequest, ListRowsResponse, ListRowsPagedResponse>() {
            @Override
            public ApiFuture<ListRowsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRowsRequest, ListRowsResponse> callable,
                ListRowsRequest request,
                ApiCallContext context,
                ApiFuture<ListRowsResponse> futureResponse) {
              PageContext<ListRowsRequest, ListRowsResponse, Row> pageContext =
                  PageContext.create(callable, LIST_ROWS_PAGE_STR_DESC, request, context);
              return ListRowsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getTable. */
  public UnaryCallSettings<GetTableRequest, Table> getTableSettings() {
    return getTableSettings;
  }

  /** Returns the object with the settings used for calls to listTables. */
  public PagedCallSettings<ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
      listTablesSettings() {
    return listTablesSettings;
  }

  /** Returns the object with the settings used for calls to getWorkspace. */
  public UnaryCallSettings<GetWorkspaceRequest, Workspace> getWorkspaceSettings() {
    return getWorkspaceSettings;
  }

  /** Returns the object with the settings used for calls to listWorkspaces. */
  public PagedCallSettings<
          ListWorkspacesRequest, ListWorkspacesResponse, ListWorkspacesPagedResponse>
      listWorkspacesSettings() {
    return listWorkspacesSettings;
  }

  /** Returns the object with the settings used for calls to getRow. */
  public UnaryCallSettings<GetRowRequest, Row> getRowSettings() {
    return getRowSettings;
  }

  /** Returns the object with the settings used for calls to listRows. */
  public PagedCallSettings<ListRowsRequest, ListRowsResponse, ListRowsPagedResponse>
      listRowsSettings() {
    return listRowsSettings;
  }

  /** Returns the object with the settings used for calls to createRow. */
  public UnaryCallSettings<CreateRowRequest, Row> createRowSettings() {
    return createRowSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateRows. */
  public UnaryCallSettings<BatchCreateRowsRequest, BatchCreateRowsResponse>
      batchCreateRowsSettings() {
    return batchCreateRowsSettings;
  }

  /** Returns the object with the settings used for calls to updateRow. */
  public UnaryCallSettings<UpdateRowRequest, Row> updateRowSettings() {
    return updateRowSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateRows. */
  public UnaryCallSettings<BatchUpdateRowsRequest, BatchUpdateRowsResponse>
      batchUpdateRowsSettings() {
    return batchUpdateRowsSettings;
  }

  /** Returns the object with the settings used for calls to deleteRow. */
  public UnaryCallSettings<DeleteRowRequest, Empty> deleteRowSettings() {
    return deleteRowSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteRows. */
  public UnaryCallSettings<BatchDeleteRowsRequest, Empty> batchDeleteRowsSettings() {
    return batchDeleteRowsSettings;
  }

  public TablesServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcTablesServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonTablesServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "area120tables.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "area120tables.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(TablesServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(TablesServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TablesServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected TablesServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getTableSettings = settingsBuilder.getTableSettings().build();
    listTablesSettings = settingsBuilder.listTablesSettings().build();
    getWorkspaceSettings = settingsBuilder.getWorkspaceSettings().build();
    listWorkspacesSettings = settingsBuilder.listWorkspacesSettings().build();
    getRowSettings = settingsBuilder.getRowSettings().build();
    listRowsSettings = settingsBuilder.listRowsSettings().build();
    createRowSettings = settingsBuilder.createRowSettings().build();
    batchCreateRowsSettings = settingsBuilder.batchCreateRowsSettings().build();
    updateRowSettings = settingsBuilder.updateRowSettings().build();
    batchUpdateRowsSettings = settingsBuilder.batchUpdateRowsSettings().build();
    deleteRowSettings = settingsBuilder.deleteRowSettings().build();
    batchDeleteRowsSettings = settingsBuilder.batchDeleteRowsSettings().build();
  }

  /** Builder for TablesServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<TablesServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetTableRequest, Table> getTableSettings;
    private final PagedCallSettings.Builder<
            ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
        listTablesSettings;
    private final UnaryCallSettings.Builder<GetWorkspaceRequest, Workspace> getWorkspaceSettings;
    private final PagedCallSettings.Builder<
            ListWorkspacesRequest, ListWorkspacesResponse, ListWorkspacesPagedResponse>
        listWorkspacesSettings;
    private final UnaryCallSettings.Builder<GetRowRequest, Row> getRowSettings;
    private final PagedCallSettings.Builder<
            ListRowsRequest, ListRowsResponse, ListRowsPagedResponse>
        listRowsSettings;
    private final UnaryCallSettings.Builder<CreateRowRequest, Row> createRowSettings;
    private final UnaryCallSettings.Builder<BatchCreateRowsRequest, BatchCreateRowsResponse>
        batchCreateRowsSettings;
    private final UnaryCallSettings.Builder<UpdateRowRequest, Row> updateRowSettings;
    private final UnaryCallSettings.Builder<BatchUpdateRowsRequest, BatchUpdateRowsResponse>
        batchUpdateRowsSettings;
    private final UnaryCallSettings.Builder<DeleteRowRequest, Empty> deleteRowSettings;
    private final UnaryCallSettings.Builder<BatchDeleteRowsRequest, Empty> batchDeleteRowsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTablesSettings = PagedCallSettings.newBuilder(LIST_TABLES_PAGE_STR_FACT);
      getWorkspaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listWorkspacesSettings = PagedCallSettings.newBuilder(LIST_WORKSPACES_PAGE_STR_FACT);
      getRowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRowsSettings = PagedCallSettings.newBuilder(LIST_ROWS_PAGE_STR_FACT);
      createRowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateRowsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateRowsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeleteRowsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getTableSettings,
              listTablesSettings,
              getWorkspaceSettings,
              listWorkspacesSettings,
              getRowSettings,
              listRowsSettings,
              createRowSettings,
              batchCreateRowsSettings,
              updateRowSettings,
              batchUpdateRowsSettings,
              deleteRowSettings,
              batchDeleteRowsSettings);
      initDefaults(this);
    }

    protected Builder(TablesServiceStubSettings settings) {
      super(settings);

      getTableSettings = settings.getTableSettings.toBuilder();
      listTablesSettings = settings.listTablesSettings.toBuilder();
      getWorkspaceSettings = settings.getWorkspaceSettings.toBuilder();
      listWorkspacesSettings = settings.listWorkspacesSettings.toBuilder();
      getRowSettings = settings.getRowSettings.toBuilder();
      listRowsSettings = settings.listRowsSettings.toBuilder();
      createRowSettings = settings.createRowSettings.toBuilder();
      batchCreateRowsSettings = settings.batchCreateRowsSettings.toBuilder();
      updateRowSettings = settings.updateRowSettings.toBuilder();
      batchUpdateRowsSettings = settings.batchUpdateRowsSettings.toBuilder();
      deleteRowSettings = settings.deleteRowSettings.toBuilder();
      batchDeleteRowsSettings = settings.batchDeleteRowsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getTableSettings,
              listTablesSettings,
              getWorkspaceSettings,
              listWorkspacesSettings,
              getRowSettings,
              listRowsSettings,
              createRowSettings,
              batchCreateRowsSettings,
              updateRowSettings,
              batchUpdateRowsSettings,
              deleteRowSettings,
              batchDeleteRowsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .getTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listTablesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getWorkspaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listWorkspacesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getRowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listRowsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createRowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .batchCreateRowsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateRowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .batchUpdateRowsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteRowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .batchDeleteRowsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

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

    /** Returns the builder for the settings used for calls to getTable. */
    public UnaryCallSettings.Builder<GetTableRequest, Table> getTableSettings() {
      return getTableSettings;
    }

    /** Returns the builder for the settings used for calls to listTables. */
    public PagedCallSettings.Builder<ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
        listTablesSettings() {
      return listTablesSettings;
    }

    /** Returns the builder for the settings used for calls to getWorkspace. */
    public UnaryCallSettings.Builder<GetWorkspaceRequest, Workspace> getWorkspaceSettings() {
      return getWorkspaceSettings;
    }

    /** Returns the builder for the settings used for calls to listWorkspaces. */
    public PagedCallSettings.Builder<
            ListWorkspacesRequest, ListWorkspacesResponse, ListWorkspacesPagedResponse>
        listWorkspacesSettings() {
      return listWorkspacesSettings;
    }

    /** Returns the builder for the settings used for calls to getRow. */
    public UnaryCallSettings.Builder<GetRowRequest, Row> getRowSettings() {
      return getRowSettings;
    }

    /** Returns the builder for the settings used for calls to listRows. */
    public PagedCallSettings.Builder<ListRowsRequest, ListRowsResponse, ListRowsPagedResponse>
        listRowsSettings() {
      return listRowsSettings;
    }

    /** Returns the builder for the settings used for calls to createRow. */
    public UnaryCallSettings.Builder<CreateRowRequest, Row> createRowSettings() {
      return createRowSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateRows. */
    public UnaryCallSettings.Builder<BatchCreateRowsRequest, BatchCreateRowsResponse>
        batchCreateRowsSettings() {
      return batchCreateRowsSettings;
    }

    /** Returns the builder for the settings used for calls to updateRow. */
    public UnaryCallSettings.Builder<UpdateRowRequest, Row> updateRowSettings() {
      return updateRowSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateRows. */
    public UnaryCallSettings.Builder<BatchUpdateRowsRequest, BatchUpdateRowsResponse>
        batchUpdateRowsSettings() {
      return batchUpdateRowsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRow. */
    public UnaryCallSettings.Builder<DeleteRowRequest, Empty> deleteRowSettings() {
      return deleteRowSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteRows. */
    public UnaryCallSettings.Builder<BatchDeleteRowsRequest, Empty> batchDeleteRowsSettings() {
      return batchDeleteRowsSettings;
    }

    @Override
    public TablesServiceStubSettings build() throws IOException {
      return new TablesServiceStubSettings(this);
    }
  }
}
