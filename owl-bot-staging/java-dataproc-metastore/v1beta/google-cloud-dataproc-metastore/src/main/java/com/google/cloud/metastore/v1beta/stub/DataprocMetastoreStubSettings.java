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

package com.google.cloud.metastore.v1beta.stub;

import static com.google.cloud.metastore.v1beta.DataprocMetastoreClient.ListBackupsPagedResponse;
import static com.google.cloud.metastore.v1beta.DataprocMetastoreClient.ListMetadataImportsPagedResponse;
import static com.google.cloud.metastore.v1beta.DataprocMetastoreClient.ListServicesPagedResponse;

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
import com.google.cloud.metastore.v1beta.AlterMetadataResourceLocationRequest;
import com.google.cloud.metastore.v1beta.AlterMetadataResourceLocationResponse;
import com.google.cloud.metastore.v1beta.Backup;
import com.google.cloud.metastore.v1beta.CreateBackupRequest;
import com.google.cloud.metastore.v1beta.CreateMetadataImportRequest;
import com.google.cloud.metastore.v1beta.CreateServiceRequest;
import com.google.cloud.metastore.v1beta.DeleteBackupRequest;
import com.google.cloud.metastore.v1beta.DeleteServiceRequest;
import com.google.cloud.metastore.v1beta.ExportMetadataRequest;
import com.google.cloud.metastore.v1beta.GetBackupRequest;
import com.google.cloud.metastore.v1beta.GetMetadataImportRequest;
import com.google.cloud.metastore.v1beta.GetServiceRequest;
import com.google.cloud.metastore.v1beta.ListBackupsRequest;
import com.google.cloud.metastore.v1beta.ListBackupsResponse;
import com.google.cloud.metastore.v1beta.ListMetadataImportsRequest;
import com.google.cloud.metastore.v1beta.ListMetadataImportsResponse;
import com.google.cloud.metastore.v1beta.ListServicesRequest;
import com.google.cloud.metastore.v1beta.ListServicesResponse;
import com.google.cloud.metastore.v1beta.MetadataExport;
import com.google.cloud.metastore.v1beta.MetadataImport;
import com.google.cloud.metastore.v1beta.MoveTableToDatabaseRequest;
import com.google.cloud.metastore.v1beta.MoveTableToDatabaseResponse;
import com.google.cloud.metastore.v1beta.OperationMetadata;
import com.google.cloud.metastore.v1beta.QueryMetadataRequest;
import com.google.cloud.metastore.v1beta.QueryMetadataResponse;
import com.google.cloud.metastore.v1beta.RemoveIamPolicyRequest;
import com.google.cloud.metastore.v1beta.RemoveIamPolicyResponse;
import com.google.cloud.metastore.v1beta.Restore;
import com.google.cloud.metastore.v1beta.RestoreServiceRequest;
import com.google.cloud.metastore.v1beta.Service;
import com.google.cloud.metastore.v1beta.UpdateMetadataImportRequest;
import com.google.cloud.metastore.v1beta.UpdateServiceRequest;
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
 * Settings class to configure an instance of {@link DataprocMetastoreStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (metastore.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getService to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataprocMetastoreStubSettings.Builder dataprocMetastoreSettingsBuilder =
 *     DataprocMetastoreStubSettings.newBuilder();
 * dataprocMetastoreSettingsBuilder
 *     .getServiceSettings()
 *     .setRetrySettings(
 *         dataprocMetastoreSettingsBuilder.getServiceSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataprocMetastoreStubSettings dataprocMetastoreSettings =
 *     dataprocMetastoreSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataprocMetastoreStubSettings extends StubSettings<DataprocMetastoreStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings;
  private final UnaryCallSettings<GetServiceRequest, Service> getServiceSettings;
  private final UnaryCallSettings<CreateServiceRequest, Operation> createServiceSettings;
  private final OperationCallSettings<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationSettings;
  private final UnaryCallSettings<UpdateServiceRequest, Operation> updateServiceSettings;
  private final OperationCallSettings<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationSettings;
  private final UnaryCallSettings<DeleteServiceRequest, Operation> deleteServiceSettings;
  private final OperationCallSettings<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationSettings;
  private final PagedCallSettings<
          ListMetadataImportsRequest, ListMetadataImportsResponse, ListMetadataImportsPagedResponse>
      listMetadataImportsSettings;
  private final UnaryCallSettings<GetMetadataImportRequest, MetadataImport>
      getMetadataImportSettings;
  private final UnaryCallSettings<CreateMetadataImportRequest, Operation>
      createMetadataImportSettings;
  private final OperationCallSettings<
          CreateMetadataImportRequest, MetadataImport, OperationMetadata>
      createMetadataImportOperationSettings;
  private final UnaryCallSettings<UpdateMetadataImportRequest, Operation>
      updateMetadataImportSettings;
  private final OperationCallSettings<
          UpdateMetadataImportRequest, MetadataImport, OperationMetadata>
      updateMetadataImportOperationSettings;
  private final UnaryCallSettings<ExportMetadataRequest, Operation> exportMetadataSettings;
  private final OperationCallSettings<ExportMetadataRequest, MetadataExport, OperationMetadata>
      exportMetadataOperationSettings;
  private final UnaryCallSettings<RestoreServiceRequest, Operation> restoreServiceSettings;
  private final OperationCallSettings<RestoreServiceRequest, Restore, OperationMetadata>
      restoreServiceOperationSettings;
  private final PagedCallSettings<ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      listBackupsSettings;
  private final UnaryCallSettings<GetBackupRequest, Backup> getBackupSettings;
  private final UnaryCallSettings<CreateBackupRequest, Operation> createBackupSettings;
  private final OperationCallSettings<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationSettings;
  private final UnaryCallSettings<DeleteBackupRequest, Operation> deleteBackupSettings;
  private final OperationCallSettings<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationSettings;
  private final UnaryCallSettings<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
      removeIamPolicySettings;
  private final UnaryCallSettings<QueryMetadataRequest, Operation> queryMetadataSettings;
  private final OperationCallSettings<
          QueryMetadataRequest, QueryMetadataResponse, OperationMetadata>
      queryMetadataOperationSettings;
  private final UnaryCallSettings<MoveTableToDatabaseRequest, Operation>
      moveTableToDatabaseSettings;
  private final OperationCallSettings<
          MoveTableToDatabaseRequest, MoveTableToDatabaseResponse, OperationMetadata>
      moveTableToDatabaseOperationSettings;
  private final UnaryCallSettings<AlterMetadataResourceLocationRequest, Operation>
      alterMetadataResourceLocationSettings;
  private final OperationCallSettings<
          AlterMetadataResourceLocationRequest,
          AlterMetadataResourceLocationResponse,
          OperationMetadata>
      alterMetadataResourceLocationOperationSettings;

  private static final PagedListDescriptor<ListServicesRequest, ListServicesResponse, Service>
      LIST_SERVICES_PAGE_STR_DESC =
          new PagedListDescriptor<ListServicesRequest, ListServicesResponse, Service>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListServicesRequest injectToken(ListServicesRequest payload, String token) {
              return ListServicesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListServicesRequest injectPageSize(ListServicesRequest payload, int pageSize) {
              return ListServicesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListServicesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListServicesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Service> extractResources(ListServicesResponse payload) {
              return payload.getServicesList() == null
                  ? ImmutableList.<Service>of()
                  : payload.getServicesList();
            }
          };

  private static final PagedListDescriptor<
          ListMetadataImportsRequest, ListMetadataImportsResponse, MetadataImport>
      LIST_METADATA_IMPORTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMetadataImportsRequest, ListMetadataImportsResponse, MetadataImport>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMetadataImportsRequest injectToken(
                ListMetadataImportsRequest payload, String token) {
              return ListMetadataImportsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMetadataImportsRequest injectPageSize(
                ListMetadataImportsRequest payload, int pageSize) {
              return ListMetadataImportsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMetadataImportsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMetadataImportsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MetadataImport> extractResources(ListMetadataImportsResponse payload) {
              return payload.getMetadataImportsList() == null
                  ? ImmutableList.<MetadataImport>of()
                  : payload.getMetadataImportsList();
            }
          };

  private static final PagedListDescriptor<ListBackupsRequest, ListBackupsResponse, Backup>
      LIST_BACKUPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListBackupsRequest, ListBackupsResponse, Backup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBackupsRequest injectToken(ListBackupsRequest payload, String token) {
              return ListBackupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBackupsRequest injectPageSize(ListBackupsRequest payload, int pageSize) {
              return ListBackupsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBackupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBackupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Backup> extractResources(ListBackupsResponse payload) {
              return payload.getBackupsList() == null
                  ? ImmutableList.<Backup>of()
                  : payload.getBackupsList();
            }
          };

  private static final PagedListResponseFactory<
          ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      LIST_SERVICES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>() {
            @Override
            public ApiFuture<ListServicesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListServicesRequest, ListServicesResponse> callable,
                ListServicesRequest request,
                ApiCallContext context,
                ApiFuture<ListServicesResponse> futureResponse) {
              PageContext<ListServicesRequest, ListServicesResponse, Service> pageContext =
                  PageContext.create(callable, LIST_SERVICES_PAGE_STR_DESC, request, context);
              return ListServicesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMetadataImportsRequest, ListMetadataImportsResponse, ListMetadataImportsPagedResponse>
      LIST_METADATA_IMPORTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMetadataImportsRequest,
              ListMetadataImportsResponse,
              ListMetadataImportsPagedResponse>() {
            @Override
            public ApiFuture<ListMetadataImportsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMetadataImportsRequest, ListMetadataImportsResponse> callable,
                ListMetadataImportsRequest request,
                ApiCallContext context,
                ApiFuture<ListMetadataImportsResponse> futureResponse) {
              PageContext<ListMetadataImportsRequest, ListMetadataImportsResponse, MetadataImport>
                  pageContext =
                      PageContext.create(
                          callable, LIST_METADATA_IMPORTS_PAGE_STR_DESC, request, context);
              return ListMetadataImportsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      LIST_BACKUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>() {
            @Override
            public ApiFuture<ListBackupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBackupsRequest, ListBackupsResponse> callable,
                ListBackupsRequest request,
                ApiCallContext context,
                ApiFuture<ListBackupsResponse> futureResponse) {
              PageContext<ListBackupsRequest, ListBackupsResponse, Backup> pageContext =
                  PageContext.create(callable, LIST_BACKUPS_PAGE_STR_DESC, request, context);
              return ListBackupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listServices. */
  public PagedCallSettings<ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings() {
    return listServicesSettings;
  }

  /** Returns the object with the settings used for calls to getService. */
  public UnaryCallSettings<GetServiceRequest, Service> getServiceSettings() {
    return getServiceSettings;
  }

  /** Returns the object with the settings used for calls to createService. */
  public UnaryCallSettings<CreateServiceRequest, Operation> createServiceSettings() {
    return createServiceSettings;
  }

  /** Returns the object with the settings used for calls to createService. */
  public OperationCallSettings<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationSettings() {
    return createServiceOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateService. */
  public UnaryCallSettings<UpdateServiceRequest, Operation> updateServiceSettings() {
    return updateServiceSettings;
  }

  /** Returns the object with the settings used for calls to updateService. */
  public OperationCallSettings<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationSettings() {
    return updateServiceOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteService. */
  public UnaryCallSettings<DeleteServiceRequest, Operation> deleteServiceSettings() {
    return deleteServiceSettings;
  }

  /** Returns the object with the settings used for calls to deleteService. */
  public OperationCallSettings<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationSettings() {
    return deleteServiceOperationSettings;
  }

  /** Returns the object with the settings used for calls to listMetadataImports. */
  public PagedCallSettings<
          ListMetadataImportsRequest, ListMetadataImportsResponse, ListMetadataImportsPagedResponse>
      listMetadataImportsSettings() {
    return listMetadataImportsSettings;
  }

  /** Returns the object with the settings used for calls to getMetadataImport. */
  public UnaryCallSettings<GetMetadataImportRequest, MetadataImport> getMetadataImportSettings() {
    return getMetadataImportSettings;
  }

  /** Returns the object with the settings used for calls to createMetadataImport. */
  public UnaryCallSettings<CreateMetadataImportRequest, Operation> createMetadataImportSettings() {
    return createMetadataImportSettings;
  }

  /** Returns the object with the settings used for calls to createMetadataImport. */
  public OperationCallSettings<CreateMetadataImportRequest, MetadataImport, OperationMetadata>
      createMetadataImportOperationSettings() {
    return createMetadataImportOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateMetadataImport. */
  public UnaryCallSettings<UpdateMetadataImportRequest, Operation> updateMetadataImportSettings() {
    return updateMetadataImportSettings;
  }

  /** Returns the object with the settings used for calls to updateMetadataImport. */
  public OperationCallSettings<UpdateMetadataImportRequest, MetadataImport, OperationMetadata>
      updateMetadataImportOperationSettings() {
    return updateMetadataImportOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportMetadata. */
  public UnaryCallSettings<ExportMetadataRequest, Operation> exportMetadataSettings() {
    return exportMetadataSettings;
  }

  /** Returns the object with the settings used for calls to exportMetadata. */
  public OperationCallSettings<ExportMetadataRequest, MetadataExport, OperationMetadata>
      exportMetadataOperationSettings() {
    return exportMetadataOperationSettings;
  }

  /** Returns the object with the settings used for calls to restoreService. */
  public UnaryCallSettings<RestoreServiceRequest, Operation> restoreServiceSettings() {
    return restoreServiceSettings;
  }

  /** Returns the object with the settings used for calls to restoreService. */
  public OperationCallSettings<RestoreServiceRequest, Restore, OperationMetadata>
      restoreServiceOperationSettings() {
    return restoreServiceOperationSettings;
  }

  /** Returns the object with the settings used for calls to listBackups. */
  public PagedCallSettings<ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      listBackupsSettings() {
    return listBackupsSettings;
  }

  /** Returns the object with the settings used for calls to getBackup. */
  public UnaryCallSettings<GetBackupRequest, Backup> getBackupSettings() {
    return getBackupSettings;
  }

  /** Returns the object with the settings used for calls to createBackup. */
  public UnaryCallSettings<CreateBackupRequest, Operation> createBackupSettings() {
    return createBackupSettings;
  }

  /** Returns the object with the settings used for calls to createBackup. */
  public OperationCallSettings<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationSettings() {
    return createBackupOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public UnaryCallSettings<DeleteBackupRequest, Operation> deleteBackupSettings() {
    return deleteBackupSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public OperationCallSettings<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationSettings() {
    return deleteBackupOperationSettings;
  }

  /** Returns the object with the settings used for calls to removeIamPolicy. */
  public UnaryCallSettings<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
      removeIamPolicySettings() {
    return removeIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to queryMetadata. */
  public UnaryCallSettings<QueryMetadataRequest, Operation> queryMetadataSettings() {
    return queryMetadataSettings;
  }

  /** Returns the object with the settings used for calls to queryMetadata. */
  public OperationCallSettings<QueryMetadataRequest, QueryMetadataResponse, OperationMetadata>
      queryMetadataOperationSettings() {
    return queryMetadataOperationSettings;
  }

  /** Returns the object with the settings used for calls to moveTableToDatabase. */
  public UnaryCallSettings<MoveTableToDatabaseRequest, Operation> moveTableToDatabaseSettings() {
    return moveTableToDatabaseSettings;
  }

  /** Returns the object with the settings used for calls to moveTableToDatabase. */
  public OperationCallSettings<
          MoveTableToDatabaseRequest, MoveTableToDatabaseResponse, OperationMetadata>
      moveTableToDatabaseOperationSettings() {
    return moveTableToDatabaseOperationSettings;
  }

  /** Returns the object with the settings used for calls to alterMetadataResourceLocation. */
  public UnaryCallSettings<AlterMetadataResourceLocationRequest, Operation>
      alterMetadataResourceLocationSettings() {
    return alterMetadataResourceLocationSettings;
  }

  /** Returns the object with the settings used for calls to alterMetadataResourceLocation. */
  public OperationCallSettings<
          AlterMetadataResourceLocationRequest,
          AlterMetadataResourceLocationResponse,
          OperationMetadata>
      alterMetadataResourceLocationOperationSettings() {
    return alterMetadataResourceLocationOperationSettings;
  }

  public DataprocMetastoreStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataprocMetastoreStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDataprocMetastoreStub.create(this);
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
    return "metastore.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "metastore.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DataprocMetastoreStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataprocMetastoreStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataprocMetastoreStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DataprocMetastoreStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listServicesSettings = settingsBuilder.listServicesSettings().build();
    getServiceSettings = settingsBuilder.getServiceSettings().build();
    createServiceSettings = settingsBuilder.createServiceSettings().build();
    createServiceOperationSettings = settingsBuilder.createServiceOperationSettings().build();
    updateServiceSettings = settingsBuilder.updateServiceSettings().build();
    updateServiceOperationSettings = settingsBuilder.updateServiceOperationSettings().build();
    deleteServiceSettings = settingsBuilder.deleteServiceSettings().build();
    deleteServiceOperationSettings = settingsBuilder.deleteServiceOperationSettings().build();
    listMetadataImportsSettings = settingsBuilder.listMetadataImportsSettings().build();
    getMetadataImportSettings = settingsBuilder.getMetadataImportSettings().build();
    createMetadataImportSettings = settingsBuilder.createMetadataImportSettings().build();
    createMetadataImportOperationSettings =
        settingsBuilder.createMetadataImportOperationSettings().build();
    updateMetadataImportSettings = settingsBuilder.updateMetadataImportSettings().build();
    updateMetadataImportOperationSettings =
        settingsBuilder.updateMetadataImportOperationSettings().build();
    exportMetadataSettings = settingsBuilder.exportMetadataSettings().build();
    exportMetadataOperationSettings = settingsBuilder.exportMetadataOperationSettings().build();
    restoreServiceSettings = settingsBuilder.restoreServiceSettings().build();
    restoreServiceOperationSettings = settingsBuilder.restoreServiceOperationSettings().build();
    listBackupsSettings = settingsBuilder.listBackupsSettings().build();
    getBackupSettings = settingsBuilder.getBackupSettings().build();
    createBackupSettings = settingsBuilder.createBackupSettings().build();
    createBackupOperationSettings = settingsBuilder.createBackupOperationSettings().build();
    deleteBackupSettings = settingsBuilder.deleteBackupSettings().build();
    deleteBackupOperationSettings = settingsBuilder.deleteBackupOperationSettings().build();
    removeIamPolicySettings = settingsBuilder.removeIamPolicySettings().build();
    queryMetadataSettings = settingsBuilder.queryMetadataSettings().build();
    queryMetadataOperationSettings = settingsBuilder.queryMetadataOperationSettings().build();
    moveTableToDatabaseSettings = settingsBuilder.moveTableToDatabaseSettings().build();
    moveTableToDatabaseOperationSettings =
        settingsBuilder.moveTableToDatabaseOperationSettings().build();
    alterMetadataResourceLocationSettings =
        settingsBuilder.alterMetadataResourceLocationSettings().build();
    alterMetadataResourceLocationOperationSettings =
        settingsBuilder.alterMetadataResourceLocationOperationSettings().build();
  }

  /** Builder for DataprocMetastoreStubSettings. */
  public static class Builder extends StubSettings.Builder<DataprocMetastoreStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings;
    private final UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings;
    private final UnaryCallSettings.Builder<CreateServiceRequest, Operation> createServiceSettings;
    private final OperationCallSettings.Builder<CreateServiceRequest, Service, OperationMetadata>
        createServiceOperationSettings;
    private final UnaryCallSettings.Builder<UpdateServiceRequest, Operation> updateServiceSettings;
    private final OperationCallSettings.Builder<UpdateServiceRequest, Service, OperationMetadata>
        updateServiceOperationSettings;
    private final UnaryCallSettings.Builder<DeleteServiceRequest, Operation> deleteServiceSettings;
    private final OperationCallSettings.Builder<DeleteServiceRequest, Empty, OperationMetadata>
        deleteServiceOperationSettings;
    private final PagedCallSettings.Builder<
            ListMetadataImportsRequest,
            ListMetadataImportsResponse,
            ListMetadataImportsPagedResponse>
        listMetadataImportsSettings;
    private final UnaryCallSettings.Builder<GetMetadataImportRequest, MetadataImport>
        getMetadataImportSettings;
    private final UnaryCallSettings.Builder<CreateMetadataImportRequest, Operation>
        createMetadataImportSettings;
    private final OperationCallSettings.Builder<
            CreateMetadataImportRequest, MetadataImport, OperationMetadata>
        createMetadataImportOperationSettings;
    private final UnaryCallSettings.Builder<UpdateMetadataImportRequest, Operation>
        updateMetadataImportSettings;
    private final OperationCallSettings.Builder<
            UpdateMetadataImportRequest, MetadataImport, OperationMetadata>
        updateMetadataImportOperationSettings;
    private final UnaryCallSettings.Builder<ExportMetadataRequest, Operation>
        exportMetadataSettings;
    private final OperationCallSettings.Builder<
            ExportMetadataRequest, MetadataExport, OperationMetadata>
        exportMetadataOperationSettings;
    private final UnaryCallSettings.Builder<RestoreServiceRequest, Operation>
        restoreServiceSettings;
    private final OperationCallSettings.Builder<RestoreServiceRequest, Restore, OperationMetadata>
        restoreServiceOperationSettings;
    private final PagedCallSettings.Builder<
            ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
        listBackupsSettings;
    private final UnaryCallSettings.Builder<GetBackupRequest, Backup> getBackupSettings;
    private final UnaryCallSettings.Builder<CreateBackupRequest, Operation> createBackupSettings;
    private final OperationCallSettings.Builder<CreateBackupRequest, Backup, OperationMetadata>
        createBackupOperationSettings;
    private final UnaryCallSettings.Builder<DeleteBackupRequest, Operation> deleteBackupSettings;
    private final OperationCallSettings.Builder<DeleteBackupRequest, Empty, OperationMetadata>
        deleteBackupOperationSettings;
    private final UnaryCallSettings.Builder<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
        removeIamPolicySettings;
    private final UnaryCallSettings.Builder<QueryMetadataRequest, Operation> queryMetadataSettings;
    private final OperationCallSettings.Builder<
            QueryMetadataRequest, QueryMetadataResponse, OperationMetadata>
        queryMetadataOperationSettings;
    private final UnaryCallSettings.Builder<MoveTableToDatabaseRequest, Operation>
        moveTableToDatabaseSettings;
    private final OperationCallSettings.Builder<
            MoveTableToDatabaseRequest, MoveTableToDatabaseResponse, OperationMetadata>
        moveTableToDatabaseOperationSettings;
    private final UnaryCallSettings.Builder<AlterMetadataResourceLocationRequest, Operation>
        alterMetadataResourceLocationSettings;
    private final OperationCallSettings.Builder<
            AlterMetadataResourceLocationRequest,
            AlterMetadataResourceLocationResponse,
            OperationMetadata>
        alterMetadataResourceLocationOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
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
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listServicesSettings = PagedCallSettings.newBuilder(LIST_SERVICES_PAGE_STR_FACT);
      getServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServiceOperationSettings = OperationCallSettings.newBuilder();
      updateServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateServiceOperationSettings = OperationCallSettings.newBuilder();
      deleteServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteServiceOperationSettings = OperationCallSettings.newBuilder();
      listMetadataImportsSettings =
          PagedCallSettings.newBuilder(LIST_METADATA_IMPORTS_PAGE_STR_FACT);
      getMetadataImportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMetadataImportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMetadataImportOperationSettings = OperationCallSettings.newBuilder();
      updateMetadataImportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMetadataImportOperationSettings = OperationCallSettings.newBuilder();
      exportMetadataSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportMetadataOperationSettings = OperationCallSettings.newBuilder();
      restoreServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restoreServiceOperationSettings = OperationCallSettings.newBuilder();
      listBackupsSettings = PagedCallSettings.newBuilder(LIST_BACKUPS_PAGE_STR_FACT);
      getBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBackupOperationSettings = OperationCallSettings.newBuilder();
      deleteBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBackupOperationSettings = OperationCallSettings.newBuilder();
      removeIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      queryMetadataSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      queryMetadataOperationSettings = OperationCallSettings.newBuilder();
      moveTableToDatabaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      moveTableToDatabaseOperationSettings = OperationCallSettings.newBuilder();
      alterMetadataResourceLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      alterMetadataResourceLocationOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listServicesSettings,
              getServiceSettings,
              createServiceSettings,
              updateServiceSettings,
              deleteServiceSettings,
              listMetadataImportsSettings,
              getMetadataImportSettings,
              createMetadataImportSettings,
              updateMetadataImportSettings,
              exportMetadataSettings,
              restoreServiceSettings,
              listBackupsSettings,
              getBackupSettings,
              createBackupSettings,
              deleteBackupSettings,
              removeIamPolicySettings,
              queryMetadataSettings,
              moveTableToDatabaseSettings,
              alterMetadataResourceLocationSettings);
      initDefaults(this);
    }

    protected Builder(DataprocMetastoreStubSettings settings) {
      super(settings);

      listServicesSettings = settings.listServicesSettings.toBuilder();
      getServiceSettings = settings.getServiceSettings.toBuilder();
      createServiceSettings = settings.createServiceSettings.toBuilder();
      createServiceOperationSettings = settings.createServiceOperationSettings.toBuilder();
      updateServiceSettings = settings.updateServiceSettings.toBuilder();
      updateServiceOperationSettings = settings.updateServiceOperationSettings.toBuilder();
      deleteServiceSettings = settings.deleteServiceSettings.toBuilder();
      deleteServiceOperationSettings = settings.deleteServiceOperationSettings.toBuilder();
      listMetadataImportsSettings = settings.listMetadataImportsSettings.toBuilder();
      getMetadataImportSettings = settings.getMetadataImportSettings.toBuilder();
      createMetadataImportSettings = settings.createMetadataImportSettings.toBuilder();
      createMetadataImportOperationSettings =
          settings.createMetadataImportOperationSettings.toBuilder();
      updateMetadataImportSettings = settings.updateMetadataImportSettings.toBuilder();
      updateMetadataImportOperationSettings =
          settings.updateMetadataImportOperationSettings.toBuilder();
      exportMetadataSettings = settings.exportMetadataSettings.toBuilder();
      exportMetadataOperationSettings = settings.exportMetadataOperationSettings.toBuilder();
      restoreServiceSettings = settings.restoreServiceSettings.toBuilder();
      restoreServiceOperationSettings = settings.restoreServiceOperationSettings.toBuilder();
      listBackupsSettings = settings.listBackupsSettings.toBuilder();
      getBackupSettings = settings.getBackupSettings.toBuilder();
      createBackupSettings = settings.createBackupSettings.toBuilder();
      createBackupOperationSettings = settings.createBackupOperationSettings.toBuilder();
      deleteBackupSettings = settings.deleteBackupSettings.toBuilder();
      deleteBackupOperationSettings = settings.deleteBackupOperationSettings.toBuilder();
      removeIamPolicySettings = settings.removeIamPolicySettings.toBuilder();
      queryMetadataSettings = settings.queryMetadataSettings.toBuilder();
      queryMetadataOperationSettings = settings.queryMetadataOperationSettings.toBuilder();
      moveTableToDatabaseSettings = settings.moveTableToDatabaseSettings.toBuilder();
      moveTableToDatabaseOperationSettings =
          settings.moveTableToDatabaseOperationSettings.toBuilder();
      alterMetadataResourceLocationSettings =
          settings.alterMetadataResourceLocationSettings.toBuilder();
      alterMetadataResourceLocationOperationSettings =
          settings.alterMetadataResourceLocationOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listServicesSettings,
              getServiceSettings,
              createServiceSettings,
              updateServiceSettings,
              deleteServiceSettings,
              listMetadataImportsSettings,
              getMetadataImportSettings,
              createMetadataImportSettings,
              updateMetadataImportSettings,
              exportMetadataSettings,
              restoreServiceSettings,
              listBackupsSettings,
              getBackupSettings,
              createBackupSettings,
              deleteBackupSettings,
              removeIamPolicySettings,
              queryMetadataSettings,
              moveTableToDatabaseSettings,
              alterMetadataResourceLocationSettings);
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
          .listServicesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listMetadataImportsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getMetadataImportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createMetadataImportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateMetadataImportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .exportMetadataSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .restoreServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listBackupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .removeIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .queryMetadataSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .moveTableToDatabaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .alterMetadataResourceLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createServiceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateServiceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Service.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(60000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(120000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(4800000L))
                      .build()));

      builder
          .updateServiceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateServiceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Service.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(60000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(120000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(3000000L))
                      .build()));

      builder
          .deleteServiceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteServiceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(10000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(60000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(1500000L))
                      .build()));

      builder
          .createMetadataImportOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMetadataImportRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MetadataImport.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(60000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(120000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(4800000L))
                      .build()));

      builder
          .updateMetadataImportOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateMetadataImportRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MetadataImport.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(60000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(120000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(1200000L))
                      .build()));

      builder
          .exportMetadataOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportMetadataRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MetadataExport.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(60000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(120000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(4800000L))
                      .build()));

      builder
          .restoreServiceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RestoreServiceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Restore.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(60000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(120000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(4800000L))
                      .build()));

      builder
          .createBackupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateBackupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Backup.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(60000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(120000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(4800000L))
                      .build()));

      builder
          .deleteBackupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteBackupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(10000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(60000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(1500000L))
                      .build()));

      builder
          .queryMetadataOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<QueryMetadataRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(QueryMetadataResponse.class))
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
          .moveTableToDatabaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<MoveTableToDatabaseRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  MoveTableToDatabaseResponse.class))
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
          .alterMetadataResourceLocationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AlterMetadataResourceLocationRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  AlterMetadataResourceLocationResponse.class))
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

    /** Returns the builder for the settings used for calls to listServices. */
    public PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings() {
      return listServicesSettings;
    }

    /** Returns the builder for the settings used for calls to getService. */
    public UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings() {
      return getServiceSettings;
    }

    /** Returns the builder for the settings used for calls to createService. */
    public UnaryCallSettings.Builder<CreateServiceRequest, Operation> createServiceSettings() {
      return createServiceSettings;
    }

    /** Returns the builder for the settings used for calls to createService. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateServiceRequest, Service, OperationMetadata>
        createServiceOperationSettings() {
      return createServiceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateService. */
    public UnaryCallSettings.Builder<UpdateServiceRequest, Operation> updateServiceSettings() {
      return updateServiceSettings;
    }

    /** Returns the builder for the settings used for calls to updateService. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateServiceRequest, Service, OperationMetadata>
        updateServiceOperationSettings() {
      return updateServiceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteService. */
    public UnaryCallSettings.Builder<DeleteServiceRequest, Operation> deleteServiceSettings() {
      return deleteServiceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteService. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteServiceRequest, Empty, OperationMetadata>
        deleteServiceOperationSettings() {
      return deleteServiceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listMetadataImports. */
    public PagedCallSettings.Builder<
            ListMetadataImportsRequest,
            ListMetadataImportsResponse,
            ListMetadataImportsPagedResponse>
        listMetadataImportsSettings() {
      return listMetadataImportsSettings;
    }

    /** Returns the builder for the settings used for calls to getMetadataImport. */
    public UnaryCallSettings.Builder<GetMetadataImportRequest, MetadataImport>
        getMetadataImportSettings() {
      return getMetadataImportSettings;
    }

    /** Returns the builder for the settings used for calls to createMetadataImport. */
    public UnaryCallSettings.Builder<CreateMetadataImportRequest, Operation>
        createMetadataImportSettings() {
      return createMetadataImportSettings;
    }

    /** Returns the builder for the settings used for calls to createMetadataImport. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateMetadataImportRequest, MetadataImport, OperationMetadata>
        createMetadataImportOperationSettings() {
      return createMetadataImportOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateMetadataImport. */
    public UnaryCallSettings.Builder<UpdateMetadataImportRequest, Operation>
        updateMetadataImportSettings() {
      return updateMetadataImportSettings;
    }

    /** Returns the builder for the settings used for calls to updateMetadataImport. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateMetadataImportRequest, MetadataImport, OperationMetadata>
        updateMetadataImportOperationSettings() {
      return updateMetadataImportOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportMetadata. */
    public UnaryCallSettings.Builder<ExportMetadataRequest, Operation> exportMetadataSettings() {
      return exportMetadataSettings;
    }

    /** Returns the builder for the settings used for calls to exportMetadata. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<ExportMetadataRequest, MetadataExport, OperationMetadata>
        exportMetadataOperationSettings() {
      return exportMetadataOperationSettings;
    }

    /** Returns the builder for the settings used for calls to restoreService. */
    public UnaryCallSettings.Builder<RestoreServiceRequest, Operation> restoreServiceSettings() {
      return restoreServiceSettings;
    }

    /** Returns the builder for the settings used for calls to restoreService. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<RestoreServiceRequest, Restore, OperationMetadata>
        restoreServiceOperationSettings() {
      return restoreServiceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listBackups. */
    public PagedCallSettings.Builder<
            ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
        listBackupsSettings() {
      return listBackupsSettings;
    }

    /** Returns the builder for the settings used for calls to getBackup. */
    public UnaryCallSettings.Builder<GetBackupRequest, Backup> getBackupSettings() {
      return getBackupSettings;
    }

    /** Returns the builder for the settings used for calls to createBackup. */
    public UnaryCallSettings.Builder<CreateBackupRequest, Operation> createBackupSettings() {
      return createBackupSettings;
    }

    /** Returns the builder for the settings used for calls to createBackup. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateBackupRequest, Backup, OperationMetadata>
        createBackupOperationSettings() {
      return createBackupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackup. */
    public UnaryCallSettings.Builder<DeleteBackupRequest, Operation> deleteBackupSettings() {
      return deleteBackupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackup. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteBackupRequest, Empty, OperationMetadata>
        deleteBackupOperationSettings() {
      return deleteBackupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to removeIamPolicy. */
    public UnaryCallSettings.Builder<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
        removeIamPolicySettings() {
      return removeIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to queryMetadata. */
    public UnaryCallSettings.Builder<QueryMetadataRequest, Operation> queryMetadataSettings() {
      return queryMetadataSettings;
    }

    /** Returns the builder for the settings used for calls to queryMetadata. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            QueryMetadataRequest, QueryMetadataResponse, OperationMetadata>
        queryMetadataOperationSettings() {
      return queryMetadataOperationSettings;
    }

    /** Returns the builder for the settings used for calls to moveTableToDatabase. */
    public UnaryCallSettings.Builder<MoveTableToDatabaseRequest, Operation>
        moveTableToDatabaseSettings() {
      return moveTableToDatabaseSettings;
    }

    /** Returns the builder for the settings used for calls to moveTableToDatabase. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            MoveTableToDatabaseRequest, MoveTableToDatabaseResponse, OperationMetadata>
        moveTableToDatabaseOperationSettings() {
      return moveTableToDatabaseOperationSettings;
    }

    /** Returns the builder for the settings used for calls to alterMetadataResourceLocation. */
    public UnaryCallSettings.Builder<AlterMetadataResourceLocationRequest, Operation>
        alterMetadataResourceLocationSettings() {
      return alterMetadataResourceLocationSettings;
    }

    /** Returns the builder for the settings used for calls to alterMetadataResourceLocation. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            AlterMetadataResourceLocationRequest,
            AlterMetadataResourceLocationResponse,
            OperationMetadata>
        alterMetadataResourceLocationOperationSettings() {
      return alterMetadataResourceLocationOperationSettings;
    }

    @Override
    public DataprocMetastoreStubSettings build() throws IOException {
      return new DataprocMetastoreStubSettings(this);
    }
  }
}
