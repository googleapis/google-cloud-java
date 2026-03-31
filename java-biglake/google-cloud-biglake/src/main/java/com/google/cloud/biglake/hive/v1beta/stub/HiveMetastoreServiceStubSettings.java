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

package com.google.cloud.biglake.hive.v1beta.stub;

import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveCatalogsPagedResponse;
import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveDatabasesPagedResponse;
import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveTablesPagedResponse;

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
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsRequest;
import com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsResponse;
import com.google.cloud.biglake.hive.v1beta.BatchDeletePartitionsRequest;
import com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsRequest;
import com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsResponse;
import com.google.cloud.biglake.hive.v1beta.CreateHiveCatalogRequest;
import com.google.cloud.biglake.hive.v1beta.CreateHiveDatabaseRequest;
import com.google.cloud.biglake.hive.v1beta.CreateHiveTableRequest;
import com.google.cloud.biglake.hive.v1beta.DeleteHiveCatalogRequest;
import com.google.cloud.biglake.hive.v1beta.DeleteHiveDatabaseRequest;
import com.google.cloud.biglake.hive.v1beta.DeleteHiveTableRequest;
import com.google.cloud.biglake.hive.v1beta.GetHiveCatalogRequest;
import com.google.cloud.biglake.hive.v1beta.GetHiveDatabaseRequest;
import com.google.cloud.biglake.hive.v1beta.GetHiveTableRequest;
import com.google.cloud.biglake.hive.v1beta.HiveCatalog;
import com.google.cloud.biglake.hive.v1beta.HiveDatabase;
import com.google.cloud.biglake.hive.v1beta.HiveTable;
import com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsRequest;
import com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsResponse;
import com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesRequest;
import com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesResponse;
import com.google.cloud.biglake.hive.v1beta.ListHiveTablesRequest;
import com.google.cloud.biglake.hive.v1beta.ListHiveTablesResponse;
import com.google.cloud.biglake.hive.v1beta.ListPartitionsRequest;
import com.google.cloud.biglake.hive.v1beta.ListPartitionsResponse;
import com.google.cloud.biglake.hive.v1beta.UpdateHiveCatalogRequest;
import com.google.cloud.biglake.hive.v1beta.UpdateHiveDatabaseRequest;
import com.google.cloud.biglake.hive.v1beta.UpdateHiveTableRequest;
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
 * Settings class to configure an instance of {@link HiveMetastoreServiceStub}.
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createHiveCatalog:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * HiveMetastoreServiceStubSettings.Builder hiveMetastoreServiceSettingsBuilder =
 *     HiveMetastoreServiceStubSettings.newBuilder();
 * hiveMetastoreServiceSettingsBuilder
 *     .createHiveCatalogSettings()
 *     .setRetrySettings(
 *         hiveMetastoreServiceSettingsBuilder
 *             .createHiveCatalogSettings()
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
 * HiveMetastoreServiceStubSettings hiveMetastoreServiceSettings =
 *     hiveMetastoreServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class HiveMetastoreServiceStubSettings
    extends StubSettings<HiveMetastoreServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/bigquery")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<CreateHiveCatalogRequest, HiveCatalog> createHiveCatalogSettings;
  private final UnaryCallSettings<GetHiveCatalogRequest, HiveCatalog> getHiveCatalogSettings;
  private final PagedCallSettings<
          ListHiveCatalogsRequest, ListHiveCatalogsResponse, ListHiveCatalogsPagedResponse>
      listHiveCatalogsSettings;
  private final UnaryCallSettings<UpdateHiveCatalogRequest, HiveCatalog> updateHiveCatalogSettings;
  private final UnaryCallSettings<DeleteHiveCatalogRequest, Empty> deleteHiveCatalogSettings;
  private final UnaryCallSettings<CreateHiveDatabaseRequest, HiveDatabase>
      createHiveDatabaseSettings;
  private final UnaryCallSettings<GetHiveDatabaseRequest, HiveDatabase> getHiveDatabaseSettings;
  private final PagedCallSettings<
          ListHiveDatabasesRequest, ListHiveDatabasesResponse, ListHiveDatabasesPagedResponse>
      listHiveDatabasesSettings;
  private final UnaryCallSettings<UpdateHiveDatabaseRequest, HiveDatabase>
      updateHiveDatabaseSettings;
  private final UnaryCallSettings<DeleteHiveDatabaseRequest, Empty> deleteHiveDatabaseSettings;
  private final UnaryCallSettings<CreateHiveTableRequest, HiveTable> createHiveTableSettings;
  private final UnaryCallSettings<GetHiveTableRequest, HiveTable> getHiveTableSettings;
  private final PagedCallSettings<
          ListHiveTablesRequest, ListHiveTablesResponse, ListHiveTablesPagedResponse>
      listHiveTablesSettings;
  private final UnaryCallSettings<UpdateHiveTableRequest, HiveTable> updateHiveTableSettings;
  private final UnaryCallSettings<DeleteHiveTableRequest, Empty> deleteHiveTableSettings;
  private final UnaryCallSettings<BatchCreatePartitionsRequest, BatchCreatePartitionsResponse>
      batchCreatePartitionsSettings;
  private final UnaryCallSettings<BatchDeletePartitionsRequest, Empty>
      batchDeletePartitionsSettings;
  private final UnaryCallSettings<BatchUpdatePartitionsRequest, BatchUpdatePartitionsResponse>
      batchUpdatePartitionsSettings;
  private final ServerStreamingCallSettings<ListPartitionsRequest, ListPartitionsResponse>
      listPartitionsSettings;

  private static final PagedListDescriptor<
          ListHiveCatalogsRequest, ListHiveCatalogsResponse, HiveCatalog>
      LIST_HIVE_CATALOGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListHiveCatalogsRequest, ListHiveCatalogsResponse, HiveCatalog>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListHiveCatalogsRequest injectToken(
                ListHiveCatalogsRequest payload, String token) {
              return ListHiveCatalogsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListHiveCatalogsRequest injectPageSize(
                ListHiveCatalogsRequest payload, int pageSize) {
              return ListHiveCatalogsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListHiveCatalogsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListHiveCatalogsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<HiveCatalog> extractResources(ListHiveCatalogsResponse payload) {
              return payload.getCatalogsList();
            }
          };

  private static final PagedListDescriptor<
          ListHiveDatabasesRequest, ListHiveDatabasesResponse, HiveDatabase>
      LIST_HIVE_DATABASES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListHiveDatabasesRequest, ListHiveDatabasesResponse, HiveDatabase>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListHiveDatabasesRequest injectToken(
                ListHiveDatabasesRequest payload, String token) {
              return ListHiveDatabasesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListHiveDatabasesRequest injectPageSize(
                ListHiveDatabasesRequest payload, int pageSize) {
              return ListHiveDatabasesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListHiveDatabasesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListHiveDatabasesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<HiveDatabase> extractResources(ListHiveDatabasesResponse payload) {
              return payload.getDatabasesList();
            }
          };

  private static final PagedListDescriptor<ListHiveTablesRequest, ListHiveTablesResponse, HiveTable>
      LIST_HIVE_TABLES_PAGE_STR_DESC =
          new PagedListDescriptor<ListHiveTablesRequest, ListHiveTablesResponse, HiveTable>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListHiveTablesRequest injectToken(ListHiveTablesRequest payload, String token) {
              return ListHiveTablesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListHiveTablesRequest injectPageSize(
                ListHiveTablesRequest payload, int pageSize) {
              return ListHiveTablesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListHiveTablesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListHiveTablesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<HiveTable> extractResources(ListHiveTablesResponse payload) {
              return payload.getTablesList();
            }
          };

  private static final PagedListResponseFactory<
          ListHiveCatalogsRequest, ListHiveCatalogsResponse, ListHiveCatalogsPagedResponse>
      LIST_HIVE_CATALOGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListHiveCatalogsRequest, ListHiveCatalogsResponse, ListHiveCatalogsPagedResponse>() {
            @Override
            public ApiFuture<ListHiveCatalogsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListHiveCatalogsRequest, ListHiveCatalogsResponse> callable,
                ListHiveCatalogsRequest request,
                ApiCallContext context,
                ApiFuture<ListHiveCatalogsResponse> futureResponse) {
              PageContext<ListHiveCatalogsRequest, ListHiveCatalogsResponse, HiveCatalog>
                  pageContext =
                      PageContext.create(
                          callable, LIST_HIVE_CATALOGS_PAGE_STR_DESC, request, context);
              return ListHiveCatalogsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListHiveDatabasesRequest, ListHiveDatabasesResponse, ListHiveDatabasesPagedResponse>
      LIST_HIVE_DATABASES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListHiveDatabasesRequest,
              ListHiveDatabasesResponse,
              ListHiveDatabasesPagedResponse>() {
            @Override
            public ApiFuture<ListHiveDatabasesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListHiveDatabasesRequest, ListHiveDatabasesResponse> callable,
                ListHiveDatabasesRequest request,
                ApiCallContext context,
                ApiFuture<ListHiveDatabasesResponse> futureResponse) {
              PageContext<ListHiveDatabasesRequest, ListHiveDatabasesResponse, HiveDatabase>
                  pageContext =
                      PageContext.create(
                          callable, LIST_HIVE_DATABASES_PAGE_STR_DESC, request, context);
              return ListHiveDatabasesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListHiveTablesRequest, ListHiveTablesResponse, ListHiveTablesPagedResponse>
      LIST_HIVE_TABLES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListHiveTablesRequest, ListHiveTablesResponse, ListHiveTablesPagedResponse>() {
            @Override
            public ApiFuture<ListHiveTablesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListHiveTablesRequest, ListHiveTablesResponse> callable,
                ListHiveTablesRequest request,
                ApiCallContext context,
                ApiFuture<ListHiveTablesResponse> futureResponse) {
              PageContext<ListHiveTablesRequest, ListHiveTablesResponse, HiveTable> pageContext =
                  PageContext.create(callable, LIST_HIVE_TABLES_PAGE_STR_DESC, request, context);
              return ListHiveTablesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createHiveCatalog. */
  public UnaryCallSettings<CreateHiveCatalogRequest, HiveCatalog> createHiveCatalogSettings() {
    return createHiveCatalogSettings;
  }

  /** Returns the object with the settings used for calls to getHiveCatalog. */
  public UnaryCallSettings<GetHiveCatalogRequest, HiveCatalog> getHiveCatalogSettings() {
    return getHiveCatalogSettings;
  }

  /** Returns the object with the settings used for calls to listHiveCatalogs. */
  public PagedCallSettings<
          ListHiveCatalogsRequest, ListHiveCatalogsResponse, ListHiveCatalogsPagedResponse>
      listHiveCatalogsSettings() {
    return listHiveCatalogsSettings;
  }

  /** Returns the object with the settings used for calls to updateHiveCatalog. */
  public UnaryCallSettings<UpdateHiveCatalogRequest, HiveCatalog> updateHiveCatalogSettings() {
    return updateHiveCatalogSettings;
  }

  /** Returns the object with the settings used for calls to deleteHiveCatalog. */
  public UnaryCallSettings<DeleteHiveCatalogRequest, Empty> deleteHiveCatalogSettings() {
    return deleteHiveCatalogSettings;
  }

  /** Returns the object with the settings used for calls to createHiveDatabase. */
  public UnaryCallSettings<CreateHiveDatabaseRequest, HiveDatabase> createHiveDatabaseSettings() {
    return createHiveDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to getHiveDatabase. */
  public UnaryCallSettings<GetHiveDatabaseRequest, HiveDatabase> getHiveDatabaseSettings() {
    return getHiveDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to listHiveDatabases. */
  public PagedCallSettings<
          ListHiveDatabasesRequest, ListHiveDatabasesResponse, ListHiveDatabasesPagedResponse>
      listHiveDatabasesSettings() {
    return listHiveDatabasesSettings;
  }

  /** Returns the object with the settings used for calls to updateHiveDatabase. */
  public UnaryCallSettings<UpdateHiveDatabaseRequest, HiveDatabase> updateHiveDatabaseSettings() {
    return updateHiveDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to deleteHiveDatabase. */
  public UnaryCallSettings<DeleteHiveDatabaseRequest, Empty> deleteHiveDatabaseSettings() {
    return deleteHiveDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to createHiveTable. */
  public UnaryCallSettings<CreateHiveTableRequest, HiveTable> createHiveTableSettings() {
    return createHiveTableSettings;
  }

  /** Returns the object with the settings used for calls to getHiveTable. */
  public UnaryCallSettings<GetHiveTableRequest, HiveTable> getHiveTableSettings() {
    return getHiveTableSettings;
  }

  /** Returns the object with the settings used for calls to listHiveTables. */
  public PagedCallSettings<
          ListHiveTablesRequest, ListHiveTablesResponse, ListHiveTablesPagedResponse>
      listHiveTablesSettings() {
    return listHiveTablesSettings;
  }

  /** Returns the object with the settings used for calls to updateHiveTable. */
  public UnaryCallSettings<UpdateHiveTableRequest, HiveTable> updateHiveTableSettings() {
    return updateHiveTableSettings;
  }

  /** Returns the object with the settings used for calls to deleteHiveTable. */
  public UnaryCallSettings<DeleteHiveTableRequest, Empty> deleteHiveTableSettings() {
    return deleteHiveTableSettings;
  }

  /** Returns the object with the settings used for calls to batchCreatePartitions. */
  public UnaryCallSettings<BatchCreatePartitionsRequest, BatchCreatePartitionsResponse>
      batchCreatePartitionsSettings() {
    return batchCreatePartitionsSettings;
  }

  /** Returns the object with the settings used for calls to batchDeletePartitions. */
  public UnaryCallSettings<BatchDeletePartitionsRequest, Empty> batchDeletePartitionsSettings() {
    return batchDeletePartitionsSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdatePartitions. */
  public UnaryCallSettings<BatchUpdatePartitionsRequest, BatchUpdatePartitionsResponse>
      batchUpdatePartitionsSettings() {
    return batchUpdatePartitionsSettings;
  }

  /** Returns the object with the settings used for calls to listPartitions. */
  public ServerStreamingCallSettings<ListPartitionsRequest, ListPartitionsResponse>
      listPartitionsSettings() {
    return listPartitionsSettings;
  }

  public HiveMetastoreServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcHiveMetastoreServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonHiveMetastoreServiceStub.create(this);
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
  @ObsoleteApi("Use getEndpoint() instead")
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
            "gapic", GaxProperties.getLibraryVersion(HiveMetastoreServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(HiveMetastoreServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return HiveMetastoreServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected HiveMetastoreServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createHiveCatalogSettings = settingsBuilder.createHiveCatalogSettings().build();
    getHiveCatalogSettings = settingsBuilder.getHiveCatalogSettings().build();
    listHiveCatalogsSettings = settingsBuilder.listHiveCatalogsSettings().build();
    updateHiveCatalogSettings = settingsBuilder.updateHiveCatalogSettings().build();
    deleteHiveCatalogSettings = settingsBuilder.deleteHiveCatalogSettings().build();
    createHiveDatabaseSettings = settingsBuilder.createHiveDatabaseSettings().build();
    getHiveDatabaseSettings = settingsBuilder.getHiveDatabaseSettings().build();
    listHiveDatabasesSettings = settingsBuilder.listHiveDatabasesSettings().build();
    updateHiveDatabaseSettings = settingsBuilder.updateHiveDatabaseSettings().build();
    deleteHiveDatabaseSettings = settingsBuilder.deleteHiveDatabaseSettings().build();
    createHiveTableSettings = settingsBuilder.createHiveTableSettings().build();
    getHiveTableSettings = settingsBuilder.getHiveTableSettings().build();
    listHiveTablesSettings = settingsBuilder.listHiveTablesSettings().build();
    updateHiveTableSettings = settingsBuilder.updateHiveTableSettings().build();
    deleteHiveTableSettings = settingsBuilder.deleteHiveTableSettings().build();
    batchCreatePartitionsSettings = settingsBuilder.batchCreatePartitionsSettings().build();
    batchDeletePartitionsSettings = settingsBuilder.batchDeletePartitionsSettings().build();
    batchUpdatePartitionsSettings = settingsBuilder.batchUpdatePartitionsSettings().build();
    listPartitionsSettings = settingsBuilder.listPartitionsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-biglake")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for HiveMetastoreServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<HiveMetastoreServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateHiveCatalogRequest, HiveCatalog>
        createHiveCatalogSettings;
    private final UnaryCallSettings.Builder<GetHiveCatalogRequest, HiveCatalog>
        getHiveCatalogSettings;
    private final PagedCallSettings.Builder<
            ListHiveCatalogsRequest, ListHiveCatalogsResponse, ListHiveCatalogsPagedResponse>
        listHiveCatalogsSettings;
    private final UnaryCallSettings.Builder<UpdateHiveCatalogRequest, HiveCatalog>
        updateHiveCatalogSettings;
    private final UnaryCallSettings.Builder<DeleteHiveCatalogRequest, Empty>
        deleteHiveCatalogSettings;
    private final UnaryCallSettings.Builder<CreateHiveDatabaseRequest, HiveDatabase>
        createHiveDatabaseSettings;
    private final UnaryCallSettings.Builder<GetHiveDatabaseRequest, HiveDatabase>
        getHiveDatabaseSettings;
    private final PagedCallSettings.Builder<
            ListHiveDatabasesRequest, ListHiveDatabasesResponse, ListHiveDatabasesPagedResponse>
        listHiveDatabasesSettings;
    private final UnaryCallSettings.Builder<UpdateHiveDatabaseRequest, HiveDatabase>
        updateHiveDatabaseSettings;
    private final UnaryCallSettings.Builder<DeleteHiveDatabaseRequest, Empty>
        deleteHiveDatabaseSettings;
    private final UnaryCallSettings.Builder<CreateHiveTableRequest, HiveTable>
        createHiveTableSettings;
    private final UnaryCallSettings.Builder<GetHiveTableRequest, HiveTable> getHiveTableSettings;
    private final PagedCallSettings.Builder<
            ListHiveTablesRequest, ListHiveTablesResponse, ListHiveTablesPagedResponse>
        listHiveTablesSettings;
    private final UnaryCallSettings.Builder<UpdateHiveTableRequest, HiveTable>
        updateHiveTableSettings;
    private final UnaryCallSettings.Builder<DeleteHiveTableRequest, Empty> deleteHiveTableSettings;
    private final UnaryCallSettings.Builder<
            BatchCreatePartitionsRequest, BatchCreatePartitionsResponse>
        batchCreatePartitionsSettings;
    private final UnaryCallSettings.Builder<BatchDeletePartitionsRequest, Empty>
        batchDeletePartitionsSettings;
    private final UnaryCallSettings.Builder<
            BatchUpdatePartitionsRequest, BatchUpdatePartitionsResponse>
        batchUpdatePartitionsSettings;
    private final ServerStreamingCallSettings.Builder<ListPartitionsRequest, ListPartitionsResponse>
        listPartitionsSettings;
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

      createHiveCatalogSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getHiveCatalogSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listHiveCatalogsSettings = PagedCallSettings.newBuilder(LIST_HIVE_CATALOGS_PAGE_STR_FACT);
      updateHiveCatalogSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteHiveCatalogSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createHiveDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getHiveDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listHiveDatabasesSettings = PagedCallSettings.newBuilder(LIST_HIVE_DATABASES_PAGE_STR_FACT);
      updateHiveDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteHiveDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createHiveTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getHiveTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listHiveTablesSettings = PagedCallSettings.newBuilder(LIST_HIVE_TABLES_PAGE_STR_FACT);
      updateHiveTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteHiveTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreatePartitionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeletePartitionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdatePartitionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPartitionsSettings = ServerStreamingCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createHiveCatalogSettings,
              getHiveCatalogSettings,
              listHiveCatalogsSettings,
              updateHiveCatalogSettings,
              deleteHiveCatalogSettings,
              createHiveDatabaseSettings,
              getHiveDatabaseSettings,
              listHiveDatabasesSettings,
              updateHiveDatabaseSettings,
              deleteHiveDatabaseSettings,
              createHiveTableSettings,
              getHiveTableSettings,
              listHiveTablesSettings,
              updateHiveTableSettings,
              deleteHiveTableSettings,
              batchCreatePartitionsSettings,
              batchDeletePartitionsSettings,
              batchUpdatePartitionsSettings);
      initDefaults(this);
    }

    protected Builder(HiveMetastoreServiceStubSettings settings) {
      super(settings);

      createHiveCatalogSettings = settings.createHiveCatalogSettings.toBuilder();
      getHiveCatalogSettings = settings.getHiveCatalogSettings.toBuilder();
      listHiveCatalogsSettings = settings.listHiveCatalogsSettings.toBuilder();
      updateHiveCatalogSettings = settings.updateHiveCatalogSettings.toBuilder();
      deleteHiveCatalogSettings = settings.deleteHiveCatalogSettings.toBuilder();
      createHiveDatabaseSettings = settings.createHiveDatabaseSettings.toBuilder();
      getHiveDatabaseSettings = settings.getHiveDatabaseSettings.toBuilder();
      listHiveDatabasesSettings = settings.listHiveDatabasesSettings.toBuilder();
      updateHiveDatabaseSettings = settings.updateHiveDatabaseSettings.toBuilder();
      deleteHiveDatabaseSettings = settings.deleteHiveDatabaseSettings.toBuilder();
      createHiveTableSettings = settings.createHiveTableSettings.toBuilder();
      getHiveTableSettings = settings.getHiveTableSettings.toBuilder();
      listHiveTablesSettings = settings.listHiveTablesSettings.toBuilder();
      updateHiveTableSettings = settings.updateHiveTableSettings.toBuilder();
      deleteHiveTableSettings = settings.deleteHiveTableSettings.toBuilder();
      batchCreatePartitionsSettings = settings.batchCreatePartitionsSettings.toBuilder();
      batchDeletePartitionsSettings = settings.batchDeletePartitionsSettings.toBuilder();
      batchUpdatePartitionsSettings = settings.batchUpdatePartitionsSettings.toBuilder();
      listPartitionsSettings = settings.listPartitionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createHiveCatalogSettings,
              getHiveCatalogSettings,
              listHiveCatalogsSettings,
              updateHiveCatalogSettings,
              deleteHiveCatalogSettings,
              createHiveDatabaseSettings,
              getHiveDatabaseSettings,
              listHiveDatabasesSettings,
              updateHiveDatabaseSettings,
              deleteHiveDatabaseSettings,
              createHiveTableSettings,
              getHiveTableSettings,
              listHiveTablesSettings,
              updateHiveTableSettings,
              deleteHiveTableSettings,
              batchCreatePartitionsSettings,
              batchDeletePartitionsSettings,
              batchUpdatePartitionsSettings);
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
          .createHiveCatalogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getHiveCatalogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listHiveCatalogsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateHiveCatalogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteHiveCatalogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createHiveDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getHiveDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listHiveDatabasesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateHiveDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteHiveDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createHiveTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getHiveTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listHiveTablesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateHiveTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteHiveTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchCreatePartitionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchDeletePartitionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchUpdatePartitionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPartitionsSettings()
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

    /** Returns the builder for the settings used for calls to createHiveCatalog. */
    public UnaryCallSettings.Builder<CreateHiveCatalogRequest, HiveCatalog>
        createHiveCatalogSettings() {
      return createHiveCatalogSettings;
    }

    /** Returns the builder for the settings used for calls to getHiveCatalog. */
    public UnaryCallSettings.Builder<GetHiveCatalogRequest, HiveCatalog> getHiveCatalogSettings() {
      return getHiveCatalogSettings;
    }

    /** Returns the builder for the settings used for calls to listHiveCatalogs. */
    public PagedCallSettings.Builder<
            ListHiveCatalogsRequest, ListHiveCatalogsResponse, ListHiveCatalogsPagedResponse>
        listHiveCatalogsSettings() {
      return listHiveCatalogsSettings;
    }

    /** Returns the builder for the settings used for calls to updateHiveCatalog. */
    public UnaryCallSettings.Builder<UpdateHiveCatalogRequest, HiveCatalog>
        updateHiveCatalogSettings() {
      return updateHiveCatalogSettings;
    }

    /** Returns the builder for the settings used for calls to deleteHiveCatalog. */
    public UnaryCallSettings.Builder<DeleteHiveCatalogRequest, Empty> deleteHiveCatalogSettings() {
      return deleteHiveCatalogSettings;
    }

    /** Returns the builder for the settings used for calls to createHiveDatabase. */
    public UnaryCallSettings.Builder<CreateHiveDatabaseRequest, HiveDatabase>
        createHiveDatabaseSettings() {
      return createHiveDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to getHiveDatabase. */
    public UnaryCallSettings.Builder<GetHiveDatabaseRequest, HiveDatabase>
        getHiveDatabaseSettings() {
      return getHiveDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to listHiveDatabases. */
    public PagedCallSettings.Builder<
            ListHiveDatabasesRequest, ListHiveDatabasesResponse, ListHiveDatabasesPagedResponse>
        listHiveDatabasesSettings() {
      return listHiveDatabasesSettings;
    }

    /** Returns the builder for the settings used for calls to updateHiveDatabase. */
    public UnaryCallSettings.Builder<UpdateHiveDatabaseRequest, HiveDatabase>
        updateHiveDatabaseSettings() {
      return updateHiveDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to deleteHiveDatabase. */
    public UnaryCallSettings.Builder<DeleteHiveDatabaseRequest, Empty>
        deleteHiveDatabaseSettings() {
      return deleteHiveDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to createHiveTable. */
    public UnaryCallSettings.Builder<CreateHiveTableRequest, HiveTable> createHiveTableSettings() {
      return createHiveTableSettings;
    }

    /** Returns the builder for the settings used for calls to getHiveTable. */
    public UnaryCallSettings.Builder<GetHiveTableRequest, HiveTable> getHiveTableSettings() {
      return getHiveTableSettings;
    }

    /** Returns the builder for the settings used for calls to listHiveTables. */
    public PagedCallSettings.Builder<
            ListHiveTablesRequest, ListHiveTablesResponse, ListHiveTablesPagedResponse>
        listHiveTablesSettings() {
      return listHiveTablesSettings;
    }

    /** Returns the builder for the settings used for calls to updateHiveTable. */
    public UnaryCallSettings.Builder<UpdateHiveTableRequest, HiveTable> updateHiveTableSettings() {
      return updateHiveTableSettings;
    }

    /** Returns the builder for the settings used for calls to deleteHiveTable. */
    public UnaryCallSettings.Builder<DeleteHiveTableRequest, Empty> deleteHiveTableSettings() {
      return deleteHiveTableSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreatePartitions. */
    public UnaryCallSettings.Builder<BatchCreatePartitionsRequest, BatchCreatePartitionsResponse>
        batchCreatePartitionsSettings() {
      return batchCreatePartitionsSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeletePartitions. */
    public UnaryCallSettings.Builder<BatchDeletePartitionsRequest, Empty>
        batchDeletePartitionsSettings() {
      return batchDeletePartitionsSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdatePartitions. */
    public UnaryCallSettings.Builder<BatchUpdatePartitionsRequest, BatchUpdatePartitionsResponse>
        batchUpdatePartitionsSettings() {
      return batchUpdatePartitionsSettings;
    }

    /** Returns the builder for the settings used for calls to listPartitions. */
    public ServerStreamingCallSettings.Builder<ListPartitionsRequest, ListPartitionsResponse>
        listPartitionsSettings() {
      return listPartitionsSettings;
    }

    @Override
    public HiveMetastoreServiceStubSettings build() throws IOException {
      return new HiveMetastoreServiceStubSettings(this);
    }
  }
}
