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

package com.google.cloud.bigquery.biglake.v1alpha1.stub;

import static com.google.cloud.bigquery.biglake.v1alpha1.MetastoreServiceClient.ListCatalogsPagedResponse;
import static com.google.cloud.bigquery.biglake.v1alpha1.MetastoreServiceClient.ListDatabasesPagedResponse;
import static com.google.cloud.bigquery.biglake.v1alpha1.MetastoreServiceClient.ListLocksPagedResponse;
import static com.google.cloud.bigquery.biglake.v1alpha1.MetastoreServiceClient.ListTablesPagedResponse;

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
import com.google.cloud.bigquery.biglake.v1alpha1.Catalog;
import com.google.cloud.bigquery.biglake.v1alpha1.CheckLockRequest;
import com.google.cloud.bigquery.biglake.v1alpha1.CreateCatalogRequest;
import com.google.cloud.bigquery.biglake.v1alpha1.CreateDatabaseRequest;
import com.google.cloud.bigquery.biglake.v1alpha1.CreateLockRequest;
import com.google.cloud.bigquery.biglake.v1alpha1.CreateTableRequest;
import com.google.cloud.bigquery.biglake.v1alpha1.Database;
import com.google.cloud.bigquery.biglake.v1alpha1.DeleteCatalogRequest;
import com.google.cloud.bigquery.biglake.v1alpha1.DeleteDatabaseRequest;
import com.google.cloud.bigquery.biglake.v1alpha1.DeleteLockRequest;
import com.google.cloud.bigquery.biglake.v1alpha1.DeleteTableRequest;
import com.google.cloud.bigquery.biglake.v1alpha1.GetCatalogRequest;
import com.google.cloud.bigquery.biglake.v1alpha1.GetDatabaseRequest;
import com.google.cloud.bigquery.biglake.v1alpha1.GetTableRequest;
import com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsRequest;
import com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsResponse;
import com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesRequest;
import com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesResponse;
import com.google.cloud.bigquery.biglake.v1alpha1.ListLocksRequest;
import com.google.cloud.bigquery.biglake.v1alpha1.ListLocksResponse;
import com.google.cloud.bigquery.biglake.v1alpha1.ListTablesRequest;
import com.google.cloud.bigquery.biglake.v1alpha1.ListTablesResponse;
import com.google.cloud.bigquery.biglake.v1alpha1.Lock;
import com.google.cloud.bigquery.biglake.v1alpha1.RenameTableRequest;
import com.google.cloud.bigquery.biglake.v1alpha1.Table;
import com.google.cloud.bigquery.biglake.v1alpha1.UpdateDatabaseRequest;
import com.google.cloud.bigquery.biglake.v1alpha1.UpdateTableRequest;
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
 * Settings class to configure an instance of {@link MetastoreServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (biglake.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createCatalog to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MetastoreServiceStubSettings.Builder metastoreServiceSettingsBuilder =
 *     MetastoreServiceStubSettings.newBuilder();
 * metastoreServiceSettingsBuilder
 *     .createCatalogSettings()
 *     .setRetrySettings(
 *         metastoreServiceSettingsBuilder
 *             .createCatalogSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * MetastoreServiceStubSettings metastoreServiceSettings = metastoreServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MetastoreServiceStubSettings extends StubSettings<MetastoreServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/bigquery")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<CreateCatalogRequest, Catalog> createCatalogSettings;
  private final UnaryCallSettings<DeleteCatalogRequest, Catalog> deleteCatalogSettings;
  private final UnaryCallSettings<GetCatalogRequest, Catalog> getCatalogSettings;
  private final PagedCallSettings<
          ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
      listCatalogsSettings;
  private final UnaryCallSettings<CreateDatabaseRequest, Database> createDatabaseSettings;
  private final UnaryCallSettings<DeleteDatabaseRequest, Database> deleteDatabaseSettings;
  private final UnaryCallSettings<UpdateDatabaseRequest, Database> updateDatabaseSettings;
  private final UnaryCallSettings<GetDatabaseRequest, Database> getDatabaseSettings;
  private final PagedCallSettings<
          ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
      listDatabasesSettings;
  private final UnaryCallSettings<CreateTableRequest, Table> createTableSettings;
  private final UnaryCallSettings<DeleteTableRequest, Table> deleteTableSettings;
  private final UnaryCallSettings<UpdateTableRequest, Table> updateTableSettings;
  private final UnaryCallSettings<RenameTableRequest, Table> renameTableSettings;
  private final UnaryCallSettings<GetTableRequest, Table> getTableSettings;
  private final PagedCallSettings<ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
      listTablesSettings;
  private final UnaryCallSettings<CreateLockRequest, Lock> createLockSettings;
  private final UnaryCallSettings<DeleteLockRequest, Empty> deleteLockSettings;
  private final UnaryCallSettings<CheckLockRequest, Lock> checkLockSettings;
  private final PagedCallSettings<ListLocksRequest, ListLocksResponse, ListLocksPagedResponse>
      listLocksSettings;

  private static final PagedListDescriptor<ListCatalogsRequest, ListCatalogsResponse, Catalog>
      LIST_CATALOGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListCatalogsRequest, ListCatalogsResponse, Catalog>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCatalogsRequest injectToken(ListCatalogsRequest payload, String token) {
              return ListCatalogsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCatalogsRequest injectPageSize(ListCatalogsRequest payload, int pageSize) {
              return ListCatalogsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCatalogsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCatalogsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Catalog> extractResources(ListCatalogsResponse payload) {
              return payload.getCatalogsList() == null
                  ? ImmutableList.<Catalog>of()
                  : payload.getCatalogsList();
            }
          };

  private static final PagedListDescriptor<ListDatabasesRequest, ListDatabasesResponse, Database>
      LIST_DATABASES_PAGE_STR_DESC =
          new PagedListDescriptor<ListDatabasesRequest, ListDatabasesResponse, Database>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDatabasesRequest injectToken(ListDatabasesRequest payload, String token) {
              return ListDatabasesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDatabasesRequest injectPageSize(ListDatabasesRequest payload, int pageSize) {
              return ListDatabasesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDatabasesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDatabasesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Database> extractResources(ListDatabasesResponse payload) {
              return payload.getDatabasesList() == null
                  ? ImmutableList.<Database>of()
                  : payload.getDatabasesList();
            }
          };

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

  private static final PagedListDescriptor<ListLocksRequest, ListLocksResponse, Lock>
      LIST_LOCKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocksRequest, ListLocksResponse, Lock>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocksRequest injectToken(ListLocksRequest payload, String token) {
              return ListLocksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocksRequest injectPageSize(ListLocksRequest payload, int pageSize) {
              return ListLocksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Lock> extractResources(ListLocksResponse payload) {
              return payload.getLocksList() == null
                  ? ImmutableList.<Lock>of()
                  : payload.getLocksList();
            }
          };

  private static final PagedListResponseFactory<
          ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
      LIST_CATALOGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>() {
            @Override
            public ApiFuture<ListCatalogsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCatalogsRequest, ListCatalogsResponse> callable,
                ListCatalogsRequest request,
                ApiCallContext context,
                ApiFuture<ListCatalogsResponse> futureResponse) {
              PageContext<ListCatalogsRequest, ListCatalogsResponse, Catalog> pageContext =
                  PageContext.create(callable, LIST_CATALOGS_PAGE_STR_DESC, request, context);
              return ListCatalogsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
      LIST_DATABASES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>() {
            @Override
            public ApiFuture<ListDatabasesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> callable,
                ListDatabasesRequest request,
                ApiCallContext context,
                ApiFuture<ListDatabasesResponse> futureResponse) {
              PageContext<ListDatabasesRequest, ListDatabasesResponse, Database> pageContext =
                  PageContext.create(callable, LIST_DATABASES_PAGE_STR_DESC, request, context);
              return ListDatabasesPagedResponse.createAsync(pageContext, futureResponse);
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
          ListLocksRequest, ListLocksResponse, ListLocksPagedResponse>
      LIST_LOCKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocksRequest, ListLocksResponse, ListLocksPagedResponse>() {
            @Override
            public ApiFuture<ListLocksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocksRequest, ListLocksResponse> callable,
                ListLocksRequest request,
                ApiCallContext context,
                ApiFuture<ListLocksResponse> futureResponse) {
              PageContext<ListLocksRequest, ListLocksResponse, Lock> pageContext =
                  PageContext.create(callable, LIST_LOCKS_PAGE_STR_DESC, request, context);
              return ListLocksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createCatalog. */
  public UnaryCallSettings<CreateCatalogRequest, Catalog> createCatalogSettings() {
    return createCatalogSettings;
  }

  /** Returns the object with the settings used for calls to deleteCatalog. */
  public UnaryCallSettings<DeleteCatalogRequest, Catalog> deleteCatalogSettings() {
    return deleteCatalogSettings;
  }

  /** Returns the object with the settings used for calls to getCatalog. */
  public UnaryCallSettings<GetCatalogRequest, Catalog> getCatalogSettings() {
    return getCatalogSettings;
  }

  /** Returns the object with the settings used for calls to listCatalogs. */
  public PagedCallSettings<ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
      listCatalogsSettings() {
    return listCatalogsSettings;
  }

  /** Returns the object with the settings used for calls to createDatabase. */
  public UnaryCallSettings<CreateDatabaseRequest, Database> createDatabaseSettings() {
    return createDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to deleteDatabase. */
  public UnaryCallSettings<DeleteDatabaseRequest, Database> deleteDatabaseSettings() {
    return deleteDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to updateDatabase. */
  public UnaryCallSettings<UpdateDatabaseRequest, Database> updateDatabaseSettings() {
    return updateDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to getDatabase. */
  public UnaryCallSettings<GetDatabaseRequest, Database> getDatabaseSettings() {
    return getDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to listDatabases. */
  public PagedCallSettings<ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
      listDatabasesSettings() {
    return listDatabasesSettings;
  }

  /** Returns the object with the settings used for calls to createTable. */
  public UnaryCallSettings<CreateTableRequest, Table> createTableSettings() {
    return createTableSettings;
  }

  /** Returns the object with the settings used for calls to deleteTable. */
  public UnaryCallSettings<DeleteTableRequest, Table> deleteTableSettings() {
    return deleteTableSettings;
  }

  /** Returns the object with the settings used for calls to updateTable. */
  public UnaryCallSettings<UpdateTableRequest, Table> updateTableSettings() {
    return updateTableSettings;
  }

  /** Returns the object with the settings used for calls to renameTable. */
  public UnaryCallSettings<RenameTableRequest, Table> renameTableSettings() {
    return renameTableSettings;
  }

  /** Returns the object with the settings used for calls to getTable. */
  public UnaryCallSettings<GetTableRequest, Table> getTableSettings() {
    return getTableSettings;
  }

  /** Returns the object with the settings used for calls to listTables. */
  public PagedCallSettings<ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
      listTablesSettings() {
    return listTablesSettings;
  }

  /** Returns the object with the settings used for calls to createLock. */
  public UnaryCallSettings<CreateLockRequest, Lock> createLockSettings() {
    return createLockSettings;
  }

  /** Returns the object with the settings used for calls to deleteLock. */
  public UnaryCallSettings<DeleteLockRequest, Empty> deleteLockSettings() {
    return deleteLockSettings;
  }

  /** Returns the object with the settings used for calls to checkLock. */
  public UnaryCallSettings<CheckLockRequest, Lock> checkLockSettings() {
    return checkLockSettings;
  }

  /** Returns the object with the settings used for calls to listLocks. */
  public PagedCallSettings<ListLocksRequest, ListLocksResponse, ListLocksPagedResponse>
      listLocksSettings() {
    return listLocksSettings;
  }

  public MetastoreServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcMetastoreServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonMetastoreServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "biglake";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "biglake.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "biglake.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(MetastoreServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(MetastoreServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MetastoreServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected MetastoreServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createCatalogSettings = settingsBuilder.createCatalogSettings().build();
    deleteCatalogSettings = settingsBuilder.deleteCatalogSettings().build();
    getCatalogSettings = settingsBuilder.getCatalogSettings().build();
    listCatalogsSettings = settingsBuilder.listCatalogsSettings().build();
    createDatabaseSettings = settingsBuilder.createDatabaseSettings().build();
    deleteDatabaseSettings = settingsBuilder.deleteDatabaseSettings().build();
    updateDatabaseSettings = settingsBuilder.updateDatabaseSettings().build();
    getDatabaseSettings = settingsBuilder.getDatabaseSettings().build();
    listDatabasesSettings = settingsBuilder.listDatabasesSettings().build();
    createTableSettings = settingsBuilder.createTableSettings().build();
    deleteTableSettings = settingsBuilder.deleteTableSettings().build();
    updateTableSettings = settingsBuilder.updateTableSettings().build();
    renameTableSettings = settingsBuilder.renameTableSettings().build();
    getTableSettings = settingsBuilder.getTableSettings().build();
    listTablesSettings = settingsBuilder.listTablesSettings().build();
    createLockSettings = settingsBuilder.createLockSettings().build();
    deleteLockSettings = settingsBuilder.deleteLockSettings().build();
    checkLockSettings = settingsBuilder.checkLockSettings().build();
    listLocksSettings = settingsBuilder.listLocksSettings().build();
  }

  /** Builder for MetastoreServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<MetastoreServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateCatalogRequest, Catalog> createCatalogSettings;
    private final UnaryCallSettings.Builder<DeleteCatalogRequest, Catalog> deleteCatalogSettings;
    private final UnaryCallSettings.Builder<GetCatalogRequest, Catalog> getCatalogSettings;
    private final PagedCallSettings.Builder<
            ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
        listCatalogsSettings;
    private final UnaryCallSettings.Builder<CreateDatabaseRequest, Database> createDatabaseSettings;
    private final UnaryCallSettings.Builder<DeleteDatabaseRequest, Database> deleteDatabaseSettings;
    private final UnaryCallSettings.Builder<UpdateDatabaseRequest, Database> updateDatabaseSettings;
    private final UnaryCallSettings.Builder<GetDatabaseRequest, Database> getDatabaseSettings;
    private final PagedCallSettings.Builder<
            ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
        listDatabasesSettings;
    private final UnaryCallSettings.Builder<CreateTableRequest, Table> createTableSettings;
    private final UnaryCallSettings.Builder<DeleteTableRequest, Table> deleteTableSettings;
    private final UnaryCallSettings.Builder<UpdateTableRequest, Table> updateTableSettings;
    private final UnaryCallSettings.Builder<RenameTableRequest, Table> renameTableSettings;
    private final UnaryCallSettings.Builder<GetTableRequest, Table> getTableSettings;
    private final PagedCallSettings.Builder<
            ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
        listTablesSettings;
    private final UnaryCallSettings.Builder<CreateLockRequest, Lock> createLockSettings;
    private final UnaryCallSettings.Builder<DeleteLockRequest, Empty> deleteLockSettings;
    private final UnaryCallSettings.Builder<CheckLockRequest, Lock> checkLockSettings;
    private final PagedCallSettings.Builder<
            ListLocksRequest, ListLocksResponse, ListLocksPagedResponse>
        listLocksSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
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
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createCatalogSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCatalogSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getCatalogSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCatalogsSettings = PagedCallSettings.newBuilder(LIST_CATALOGS_PAGE_STR_FACT);
      createDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDatabasesSettings = PagedCallSettings.newBuilder(LIST_DATABASES_PAGE_STR_FACT);
      createTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      renameTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTablesSettings = PagedCallSettings.newBuilder(LIST_TABLES_PAGE_STR_FACT);
      createLockSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteLockSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      checkLockSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocksSettings = PagedCallSettings.newBuilder(LIST_LOCKS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createCatalogSettings,
              deleteCatalogSettings,
              getCatalogSettings,
              listCatalogsSettings,
              createDatabaseSettings,
              deleteDatabaseSettings,
              updateDatabaseSettings,
              getDatabaseSettings,
              listDatabasesSettings,
              createTableSettings,
              deleteTableSettings,
              updateTableSettings,
              renameTableSettings,
              getTableSettings,
              listTablesSettings,
              createLockSettings,
              deleteLockSettings,
              checkLockSettings,
              listLocksSettings);
      initDefaults(this);
    }

    protected Builder(MetastoreServiceStubSettings settings) {
      super(settings);

      createCatalogSettings = settings.createCatalogSettings.toBuilder();
      deleteCatalogSettings = settings.deleteCatalogSettings.toBuilder();
      getCatalogSettings = settings.getCatalogSettings.toBuilder();
      listCatalogsSettings = settings.listCatalogsSettings.toBuilder();
      createDatabaseSettings = settings.createDatabaseSettings.toBuilder();
      deleteDatabaseSettings = settings.deleteDatabaseSettings.toBuilder();
      updateDatabaseSettings = settings.updateDatabaseSettings.toBuilder();
      getDatabaseSettings = settings.getDatabaseSettings.toBuilder();
      listDatabasesSettings = settings.listDatabasesSettings.toBuilder();
      createTableSettings = settings.createTableSettings.toBuilder();
      deleteTableSettings = settings.deleteTableSettings.toBuilder();
      updateTableSettings = settings.updateTableSettings.toBuilder();
      renameTableSettings = settings.renameTableSettings.toBuilder();
      getTableSettings = settings.getTableSettings.toBuilder();
      listTablesSettings = settings.listTablesSettings.toBuilder();
      createLockSettings = settings.createLockSettings.toBuilder();
      deleteLockSettings = settings.deleteLockSettings.toBuilder();
      checkLockSettings = settings.checkLockSettings.toBuilder();
      listLocksSettings = settings.listLocksSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createCatalogSettings,
              deleteCatalogSettings,
              getCatalogSettings,
              listCatalogsSettings,
              createDatabaseSettings,
              deleteDatabaseSettings,
              updateDatabaseSettings,
              getDatabaseSettings,
              listDatabasesSettings,
              createTableSettings,
              deleteTableSettings,
              updateTableSettings,
              renameTableSettings,
              getTableSettings,
              listTablesSettings,
              createLockSettings,
              deleteLockSettings,
              checkLockSettings,
              listLocksSettings);
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
          .createCatalogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteCatalogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCatalogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCatalogsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDatabasesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .renameTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listTablesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createLockSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteLockSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .checkLockSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /** Returns the builder for the settings used for calls to createCatalog. */
    public UnaryCallSettings.Builder<CreateCatalogRequest, Catalog> createCatalogSettings() {
      return createCatalogSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCatalog. */
    public UnaryCallSettings.Builder<DeleteCatalogRequest, Catalog> deleteCatalogSettings() {
      return deleteCatalogSettings;
    }

    /** Returns the builder for the settings used for calls to getCatalog. */
    public UnaryCallSettings.Builder<GetCatalogRequest, Catalog> getCatalogSettings() {
      return getCatalogSettings;
    }

    /** Returns the builder for the settings used for calls to listCatalogs. */
    public PagedCallSettings.Builder<
            ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
        listCatalogsSettings() {
      return listCatalogsSettings;
    }

    /** Returns the builder for the settings used for calls to createDatabase. */
    public UnaryCallSettings.Builder<CreateDatabaseRequest, Database> createDatabaseSettings() {
      return createDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDatabase. */
    public UnaryCallSettings.Builder<DeleteDatabaseRequest, Database> deleteDatabaseSettings() {
      return deleteDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to updateDatabase. */
    public UnaryCallSettings.Builder<UpdateDatabaseRequest, Database> updateDatabaseSettings() {
      return updateDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to getDatabase. */
    public UnaryCallSettings.Builder<GetDatabaseRequest, Database> getDatabaseSettings() {
      return getDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to listDatabases. */
    public PagedCallSettings.Builder<
            ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
        listDatabasesSettings() {
      return listDatabasesSettings;
    }

    /** Returns the builder for the settings used for calls to createTable. */
    public UnaryCallSettings.Builder<CreateTableRequest, Table> createTableSettings() {
      return createTableSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTable. */
    public UnaryCallSettings.Builder<DeleteTableRequest, Table> deleteTableSettings() {
      return deleteTableSettings;
    }

    /** Returns the builder for the settings used for calls to updateTable. */
    public UnaryCallSettings.Builder<UpdateTableRequest, Table> updateTableSettings() {
      return updateTableSettings;
    }

    /** Returns the builder for the settings used for calls to renameTable. */
    public UnaryCallSettings.Builder<RenameTableRequest, Table> renameTableSettings() {
      return renameTableSettings;
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

    /** Returns the builder for the settings used for calls to createLock. */
    public UnaryCallSettings.Builder<CreateLockRequest, Lock> createLockSettings() {
      return createLockSettings;
    }

    /** Returns the builder for the settings used for calls to deleteLock. */
    public UnaryCallSettings.Builder<DeleteLockRequest, Empty> deleteLockSettings() {
      return deleteLockSettings;
    }

    /** Returns the builder for the settings used for calls to checkLock. */
    public UnaryCallSettings.Builder<CheckLockRequest, Lock> checkLockSettings() {
      return checkLockSettings;
    }

    /** Returns the builder for the settings used for calls to listLocks. */
    public PagedCallSettings.Builder<ListLocksRequest, ListLocksResponse, ListLocksPagedResponse>
        listLocksSettings() {
      return listLocksSettings;
    }

    @Override
    public MetastoreServiceStubSettings build() throws IOException {
      return new MetastoreServiceStubSettings(this);
    }
  }
}
