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

package com.google.cloud.documentai.v1beta3.stub;

import static com.google.cloud.documentai.v1beta3.DocumentServiceClient.ListDocumentsPagedResponse;
import static com.google.cloud.documentai.v1beta3.DocumentServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsMetadata;
import com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsRequest;
import com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsResponse;
import com.google.cloud.documentai.v1beta3.Dataset;
import com.google.cloud.documentai.v1beta3.DatasetSchema;
import com.google.cloud.documentai.v1beta3.DocumentMetadata;
import com.google.cloud.documentai.v1beta3.GetDatasetSchemaRequest;
import com.google.cloud.documentai.v1beta3.GetDocumentRequest;
import com.google.cloud.documentai.v1beta3.GetDocumentResponse;
import com.google.cloud.documentai.v1beta3.ImportDocumentsMetadata;
import com.google.cloud.documentai.v1beta3.ImportDocumentsRequest;
import com.google.cloud.documentai.v1beta3.ImportDocumentsResponse;
import com.google.cloud.documentai.v1beta3.ListDocumentsRequest;
import com.google.cloud.documentai.v1beta3.ListDocumentsResponse;
import com.google.cloud.documentai.v1beta3.UpdateDatasetOperationMetadata;
import com.google.cloud.documentai.v1beta3.UpdateDatasetRequest;
import com.google.cloud.documentai.v1beta3.UpdateDatasetSchemaRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Settings class to configure an instance of {@link DocumentServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (documentai.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getDocument to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DocumentServiceStubSettings.Builder documentServiceSettingsBuilder =
 *     DocumentServiceStubSettings.newBuilder();
 * documentServiceSettingsBuilder
 *     .getDocumentSettings()
 *     .setRetrySettings(
 *         documentServiceSettingsBuilder
 *             .getDocumentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DocumentServiceStubSettings documentServiceSettings = documentServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DocumentServiceStubSettings extends StubSettings<DocumentServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<UpdateDatasetRequest, Operation> updateDatasetSettings;
  private final OperationCallSettings<UpdateDatasetRequest, Dataset, UpdateDatasetOperationMetadata>
      updateDatasetOperationSettings;
  private final UnaryCallSettings<ImportDocumentsRequest, Operation> importDocumentsSettings;
  private final OperationCallSettings<
          ImportDocumentsRequest, ImportDocumentsResponse, ImportDocumentsMetadata>
      importDocumentsOperationSettings;
  private final UnaryCallSettings<GetDocumentRequest, GetDocumentResponse> getDocumentSettings;
  private final PagedCallSettings<
          ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
      listDocumentsSettings;
  private final UnaryCallSettings<BatchDeleteDocumentsRequest, Operation>
      batchDeleteDocumentsSettings;
  private final OperationCallSettings<
          BatchDeleteDocumentsRequest, BatchDeleteDocumentsResponse, BatchDeleteDocumentsMetadata>
      batchDeleteDocumentsOperationSettings;
  private final UnaryCallSettings<GetDatasetSchemaRequest, DatasetSchema> getDatasetSchemaSettings;
  private final UnaryCallSettings<UpdateDatasetSchemaRequest, DatasetSchema>
      updateDatasetSchemaSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListDocumentsRequest, ListDocumentsResponse, DocumentMetadata>
      LIST_DOCUMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDocumentsRequest, ListDocumentsResponse, DocumentMetadata>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDocumentsRequest injectToken(ListDocumentsRequest payload, String token) {
              return ListDocumentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDocumentsRequest injectPageSize(ListDocumentsRequest payload, int pageSize) {
              return ListDocumentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDocumentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDocumentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DocumentMetadata> extractResources(ListDocumentsResponse payload) {
              return payload.getDocumentMetadataList() == null
                  ? ImmutableList.<DocumentMetadata>of()
                  : payload.getDocumentMetadataList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
      LIST_DOCUMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>() {
            @Override
            public ApiFuture<ListDocumentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> callable,
                ListDocumentsRequest request,
                ApiCallContext context,
                ApiFuture<ListDocumentsResponse> futureResponse) {
              PageContext<ListDocumentsRequest, ListDocumentsResponse, DocumentMetadata>
                  pageContext =
                      PageContext.create(callable, LIST_DOCUMENTS_PAGE_STR_DESC, request, context);
              return ListDocumentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to updateDataset. */
  public UnaryCallSettings<UpdateDatasetRequest, Operation> updateDatasetSettings() {
    return updateDatasetSettings;
  }

  /** Returns the object with the settings used for calls to updateDataset. */
  public OperationCallSettings<UpdateDatasetRequest, Dataset, UpdateDatasetOperationMetadata>
      updateDatasetOperationSettings() {
    return updateDatasetOperationSettings;
  }

  /** Returns the object with the settings used for calls to importDocuments. */
  public UnaryCallSettings<ImportDocumentsRequest, Operation> importDocumentsSettings() {
    return importDocumentsSettings;
  }

  /** Returns the object with the settings used for calls to importDocuments. */
  public OperationCallSettings<
          ImportDocumentsRequest, ImportDocumentsResponse, ImportDocumentsMetadata>
      importDocumentsOperationSettings() {
    return importDocumentsOperationSettings;
  }

  /** Returns the object with the settings used for calls to getDocument. */
  public UnaryCallSettings<GetDocumentRequest, GetDocumentResponse> getDocumentSettings() {
    return getDocumentSettings;
  }

  /** Returns the object with the settings used for calls to listDocuments. */
  public PagedCallSettings<ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
      listDocumentsSettings() {
    return listDocumentsSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteDocuments. */
  public UnaryCallSettings<BatchDeleteDocumentsRequest, Operation> batchDeleteDocumentsSettings() {
    return batchDeleteDocumentsSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteDocuments. */
  public OperationCallSettings<
          BatchDeleteDocumentsRequest, BatchDeleteDocumentsResponse, BatchDeleteDocumentsMetadata>
      batchDeleteDocumentsOperationSettings() {
    return batchDeleteDocumentsOperationSettings;
  }

  /** Returns the object with the settings used for calls to getDatasetSchema. */
  public UnaryCallSettings<GetDatasetSchemaRequest, DatasetSchema> getDatasetSchemaSettings() {
    return getDatasetSchemaSettings;
  }

  /** Returns the object with the settings used for calls to updateDatasetSchema. */
  public UnaryCallSettings<UpdateDatasetSchemaRequest, DatasetSchema>
      updateDatasetSchemaSettings() {
    return updateDatasetSchemaSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  public DocumentServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDocumentServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDocumentServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "documentai";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "documentai.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "documentai.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DocumentServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DocumentServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DocumentServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DocumentServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    updateDatasetSettings = settingsBuilder.updateDatasetSettings().build();
    updateDatasetOperationSettings = settingsBuilder.updateDatasetOperationSettings().build();
    importDocumentsSettings = settingsBuilder.importDocumentsSettings().build();
    importDocumentsOperationSettings = settingsBuilder.importDocumentsOperationSettings().build();
    getDocumentSettings = settingsBuilder.getDocumentSettings().build();
    listDocumentsSettings = settingsBuilder.listDocumentsSettings().build();
    batchDeleteDocumentsSettings = settingsBuilder.batchDeleteDocumentsSettings().build();
    batchDeleteDocumentsOperationSettings =
        settingsBuilder.batchDeleteDocumentsOperationSettings().build();
    getDatasetSchemaSettings = settingsBuilder.getDatasetSchemaSettings().build();
    updateDatasetSchemaSettings = settingsBuilder.updateDatasetSchemaSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for DocumentServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<DocumentServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<UpdateDatasetRequest, Operation> updateDatasetSettings;
    private final OperationCallSettings.Builder<
            UpdateDatasetRequest, Dataset, UpdateDatasetOperationMetadata>
        updateDatasetOperationSettings;
    private final UnaryCallSettings.Builder<ImportDocumentsRequest, Operation>
        importDocumentsSettings;
    private final OperationCallSettings.Builder<
            ImportDocumentsRequest, ImportDocumentsResponse, ImportDocumentsMetadata>
        importDocumentsOperationSettings;
    private final UnaryCallSettings.Builder<GetDocumentRequest, GetDocumentResponse>
        getDocumentSettings;
    private final PagedCallSettings.Builder<
            ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
        listDocumentsSettings;
    private final UnaryCallSettings.Builder<BatchDeleteDocumentsRequest, Operation>
        batchDeleteDocumentsSettings;
    private final OperationCallSettings.Builder<
            BatchDeleteDocumentsRequest, BatchDeleteDocumentsResponse, BatchDeleteDocumentsMetadata>
        batchDeleteDocumentsOperationSettings;
    private final UnaryCallSettings.Builder<GetDatasetSchemaRequest, DatasetSchema>
        getDatasetSchemaSettings;
    private final UnaryCallSettings.Builder<UpdateDatasetSchemaRequest, DatasetSchema>
        updateDatasetSchemaSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      updateDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDatasetOperationSettings = OperationCallSettings.newBuilder();
      importDocumentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importDocumentsOperationSettings = OperationCallSettings.newBuilder();
      getDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDocumentsSettings = PagedCallSettings.newBuilder(LIST_DOCUMENTS_PAGE_STR_FACT);
      batchDeleteDocumentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeleteDocumentsOperationSettings = OperationCallSettings.newBuilder();
      getDatasetSchemaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDatasetSchemaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              updateDatasetSettings,
              importDocumentsSettings,
              getDocumentSettings,
              listDocumentsSettings,
              batchDeleteDocumentsSettings,
              getDatasetSchemaSettings,
              updateDatasetSchemaSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(DocumentServiceStubSettings settings) {
      super(settings);

      updateDatasetSettings = settings.updateDatasetSettings.toBuilder();
      updateDatasetOperationSettings = settings.updateDatasetOperationSettings.toBuilder();
      importDocumentsSettings = settings.importDocumentsSettings.toBuilder();
      importDocumentsOperationSettings = settings.importDocumentsOperationSettings.toBuilder();
      getDocumentSettings = settings.getDocumentSettings.toBuilder();
      listDocumentsSettings = settings.listDocumentsSettings.toBuilder();
      batchDeleteDocumentsSettings = settings.batchDeleteDocumentsSettings.toBuilder();
      batchDeleteDocumentsOperationSettings =
          settings.batchDeleteDocumentsOperationSettings.toBuilder();
      getDatasetSchemaSettings = settings.getDatasetSchemaSettings.toBuilder();
      updateDatasetSchemaSettings = settings.updateDatasetSchemaSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              updateDatasetSettings,
              importDocumentsSettings,
              getDocumentSettings,
              listDocumentsSettings,
              batchDeleteDocumentsSettings,
              getDatasetSchemaSettings,
              updateDatasetSchemaSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .updateDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .importDocumentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listDocumentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchDeleteDocumentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getDatasetSchemaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateDatasetSchemaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateDatasetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDatasetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Dataset.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdateDatasetOperationMetadata.class))
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
          .importDocumentsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportDocumentsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ImportDocumentsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(ImportDocumentsMetadata.class))
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
          .batchDeleteDocumentsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchDeleteDocumentsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BatchDeleteDocumentsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  BatchDeleteDocumentsMetadata.class))
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

    /** Returns the builder for the settings used for calls to updateDataset. */
    public UnaryCallSettings.Builder<UpdateDatasetRequest, Operation> updateDatasetSettings() {
      return updateDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataset. */
    public OperationCallSettings.Builder<
            UpdateDatasetRequest, Dataset, UpdateDatasetOperationMetadata>
        updateDatasetOperationSettings() {
      return updateDatasetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to importDocuments. */
    public UnaryCallSettings.Builder<ImportDocumentsRequest, Operation> importDocumentsSettings() {
      return importDocumentsSettings;
    }

    /** Returns the builder for the settings used for calls to importDocuments. */
    public OperationCallSettings.Builder<
            ImportDocumentsRequest, ImportDocumentsResponse, ImportDocumentsMetadata>
        importDocumentsOperationSettings() {
      return importDocumentsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getDocument. */
    public UnaryCallSettings.Builder<GetDocumentRequest, GetDocumentResponse>
        getDocumentSettings() {
      return getDocumentSettings;
    }

    /** Returns the builder for the settings used for calls to listDocuments. */
    public PagedCallSettings.Builder<
            ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
        listDocumentsSettings() {
      return listDocumentsSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteDocuments. */
    public UnaryCallSettings.Builder<BatchDeleteDocumentsRequest, Operation>
        batchDeleteDocumentsSettings() {
      return batchDeleteDocumentsSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteDocuments. */
    public OperationCallSettings.Builder<
            BatchDeleteDocumentsRequest, BatchDeleteDocumentsResponse, BatchDeleteDocumentsMetadata>
        batchDeleteDocumentsOperationSettings() {
      return batchDeleteDocumentsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getDatasetSchema. */
    public UnaryCallSettings.Builder<GetDatasetSchemaRequest, DatasetSchema>
        getDatasetSchemaSettings() {
      return getDatasetSchemaSettings;
    }

    /** Returns the builder for the settings used for calls to updateDatasetSchema. */
    public UnaryCallSettings.Builder<UpdateDatasetSchemaRequest, DatasetSchema>
        updateDatasetSchemaSettings() {
      return updateDatasetSchemaSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    @Override
    public DocumentServiceStubSettings build() throws IOException {
      return new DocumentServiceStubSettings(this);
    }
  }
}
