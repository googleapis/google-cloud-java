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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceClient.ListRagCorporaPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceClient.ListRagFilesPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.CreateRagCorpusOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateRagCorpusRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteRagCorpusRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteRagFileRequest;
import com.google.cloud.aiplatform.v1beta1.GetRagCorpusRequest;
import com.google.cloud.aiplatform.v1beta1.GetRagFileRequest;
import com.google.cloud.aiplatform.v1beta1.ImportRagFilesOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ImportRagFilesRequest;
import com.google.cloud.aiplatform.v1beta1.ImportRagFilesResponse;
import com.google.cloud.aiplatform.v1beta1.ListRagCorporaRequest;
import com.google.cloud.aiplatform.v1beta1.ListRagCorporaResponse;
import com.google.cloud.aiplatform.v1beta1.ListRagFilesRequest;
import com.google.cloud.aiplatform.v1beta1.ListRagFilesResponse;
import com.google.cloud.aiplatform.v1beta1.RagCorpus;
import com.google.cloud.aiplatform.v1beta1.RagFile;
import com.google.cloud.aiplatform.v1beta1.UploadRagFileRequest;
import com.google.cloud.aiplatform.v1beta1.UploadRagFileResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link VertexRagDataServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getRagCorpus to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VertexRagDataServiceStubSettings.Builder vertexRagDataServiceSettingsBuilder =
 *     VertexRagDataServiceStubSettings.newBuilder();
 * vertexRagDataServiceSettingsBuilder
 *     .getRagCorpusSettings()
 *     .setRetrySettings(
 *         vertexRagDataServiceSettingsBuilder
 *             .getRagCorpusSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * VertexRagDataServiceStubSettings vertexRagDataServiceSettings =
 *     vertexRagDataServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class VertexRagDataServiceStubSettings
    extends StubSettings<VertexRagDataServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateRagCorpusRequest, Operation> createRagCorpusSettings;
  private final OperationCallSettings<
          CreateRagCorpusRequest, RagCorpus, CreateRagCorpusOperationMetadata>
      createRagCorpusOperationSettings;
  private final UnaryCallSettings<GetRagCorpusRequest, RagCorpus> getRagCorpusSettings;
  private final PagedCallSettings<
          ListRagCorporaRequest, ListRagCorporaResponse, ListRagCorporaPagedResponse>
      listRagCorporaSettings;
  private final UnaryCallSettings<DeleteRagCorpusRequest, Operation> deleteRagCorpusSettings;
  private final OperationCallSettings<DeleteRagCorpusRequest, Empty, DeleteOperationMetadata>
      deleteRagCorpusOperationSettings;
  private final UnaryCallSettings<UploadRagFileRequest, UploadRagFileResponse>
      uploadRagFileSettings;
  private final UnaryCallSettings<ImportRagFilesRequest, Operation> importRagFilesSettings;
  private final OperationCallSettings<
          ImportRagFilesRequest, ImportRagFilesResponse, ImportRagFilesOperationMetadata>
      importRagFilesOperationSettings;
  private final UnaryCallSettings<GetRagFileRequest, RagFile> getRagFileSettings;
  private final PagedCallSettings<
          ListRagFilesRequest, ListRagFilesResponse, ListRagFilesPagedResponse>
      listRagFilesSettings;
  private final UnaryCallSettings<DeleteRagFileRequest, Operation> deleteRagFileSettings;
  private final OperationCallSettings<DeleteRagFileRequest, Empty, DeleteOperationMetadata>
      deleteRagFileOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListRagCorporaRequest, ListRagCorporaResponse, RagCorpus>
      LIST_RAG_CORPORA_PAGE_STR_DESC =
          new PagedListDescriptor<ListRagCorporaRequest, ListRagCorporaResponse, RagCorpus>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRagCorporaRequest injectToken(ListRagCorporaRequest payload, String token) {
              return ListRagCorporaRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRagCorporaRequest injectPageSize(
                ListRagCorporaRequest payload, int pageSize) {
              return ListRagCorporaRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRagCorporaRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRagCorporaResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<RagCorpus> extractResources(ListRagCorporaResponse payload) {
              return payload.getRagCorporaList() == null
                  ? ImmutableList.<RagCorpus>of()
                  : payload.getRagCorporaList();
            }
          };

  private static final PagedListDescriptor<ListRagFilesRequest, ListRagFilesResponse, RagFile>
      LIST_RAG_FILES_PAGE_STR_DESC =
          new PagedListDescriptor<ListRagFilesRequest, ListRagFilesResponse, RagFile>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRagFilesRequest injectToken(ListRagFilesRequest payload, String token) {
              return ListRagFilesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRagFilesRequest injectPageSize(ListRagFilesRequest payload, int pageSize) {
              return ListRagFilesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRagFilesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRagFilesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<RagFile> extractResources(ListRagFilesResponse payload) {
              return payload.getRagFilesList() == null
                  ? ImmutableList.<RagFile>of()
                  : payload.getRagFilesList();
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
          ListRagCorporaRequest, ListRagCorporaResponse, ListRagCorporaPagedResponse>
      LIST_RAG_CORPORA_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRagCorporaRequest, ListRagCorporaResponse, ListRagCorporaPagedResponse>() {
            @Override
            public ApiFuture<ListRagCorporaPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRagCorporaRequest, ListRagCorporaResponse> callable,
                ListRagCorporaRequest request,
                ApiCallContext context,
                ApiFuture<ListRagCorporaResponse> futureResponse) {
              PageContext<ListRagCorporaRequest, ListRagCorporaResponse, RagCorpus> pageContext =
                  PageContext.create(callable, LIST_RAG_CORPORA_PAGE_STR_DESC, request, context);
              return ListRagCorporaPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRagFilesRequest, ListRagFilesResponse, ListRagFilesPagedResponse>
      LIST_RAG_FILES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRagFilesRequest, ListRagFilesResponse, ListRagFilesPagedResponse>() {
            @Override
            public ApiFuture<ListRagFilesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRagFilesRequest, ListRagFilesResponse> callable,
                ListRagFilesRequest request,
                ApiCallContext context,
                ApiFuture<ListRagFilesResponse> futureResponse) {
              PageContext<ListRagFilesRequest, ListRagFilesResponse, RagFile> pageContext =
                  PageContext.create(callable, LIST_RAG_FILES_PAGE_STR_DESC, request, context);
              return ListRagFilesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createRagCorpus. */
  public UnaryCallSettings<CreateRagCorpusRequest, Operation> createRagCorpusSettings() {
    return createRagCorpusSettings;
  }

  /** Returns the object with the settings used for calls to createRagCorpus. */
  public OperationCallSettings<CreateRagCorpusRequest, RagCorpus, CreateRagCorpusOperationMetadata>
      createRagCorpusOperationSettings() {
    return createRagCorpusOperationSettings;
  }

  /** Returns the object with the settings used for calls to getRagCorpus. */
  public UnaryCallSettings<GetRagCorpusRequest, RagCorpus> getRagCorpusSettings() {
    return getRagCorpusSettings;
  }

  /** Returns the object with the settings used for calls to listRagCorpora. */
  public PagedCallSettings<
          ListRagCorporaRequest, ListRagCorporaResponse, ListRagCorporaPagedResponse>
      listRagCorporaSettings() {
    return listRagCorporaSettings;
  }

  /** Returns the object with the settings used for calls to deleteRagCorpus. */
  public UnaryCallSettings<DeleteRagCorpusRequest, Operation> deleteRagCorpusSettings() {
    return deleteRagCorpusSettings;
  }

  /** Returns the object with the settings used for calls to deleteRagCorpus. */
  public OperationCallSettings<DeleteRagCorpusRequest, Empty, DeleteOperationMetadata>
      deleteRagCorpusOperationSettings() {
    return deleteRagCorpusOperationSettings;
  }

  /** Returns the object with the settings used for calls to uploadRagFile. */
  public UnaryCallSettings<UploadRagFileRequest, UploadRagFileResponse> uploadRagFileSettings() {
    return uploadRagFileSettings;
  }

  /** Returns the object with the settings used for calls to importRagFiles. */
  public UnaryCallSettings<ImportRagFilesRequest, Operation> importRagFilesSettings() {
    return importRagFilesSettings;
  }

  /** Returns the object with the settings used for calls to importRagFiles. */
  public OperationCallSettings<
          ImportRagFilesRequest, ImportRagFilesResponse, ImportRagFilesOperationMetadata>
      importRagFilesOperationSettings() {
    return importRagFilesOperationSettings;
  }

  /** Returns the object with the settings used for calls to getRagFile. */
  public UnaryCallSettings<GetRagFileRequest, RagFile> getRagFileSettings() {
    return getRagFileSettings;
  }

  /** Returns the object with the settings used for calls to listRagFiles. */
  public PagedCallSettings<ListRagFilesRequest, ListRagFilesResponse, ListRagFilesPagedResponse>
      listRagFilesSettings() {
    return listRagFilesSettings;
  }

  /** Returns the object with the settings used for calls to deleteRagFile. */
  public UnaryCallSettings<DeleteRagFileRequest, Operation> deleteRagFileSettings() {
    return deleteRagFileSettings;
  }

  /** Returns the object with the settings used for calls to deleteRagFile. */
  public OperationCallSettings<DeleteRagFileRequest, Empty, DeleteOperationMetadata>
      deleteRagFileOperationSettings() {
    return deleteRagFileOperationSettings;
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

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public VertexRagDataServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcVertexRagDataServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "aiplatform";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "aiplatform.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "aiplatform.mtls.googleapis.com:443";
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(VertexRagDataServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected VertexRagDataServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createRagCorpusSettings = settingsBuilder.createRagCorpusSettings().build();
    createRagCorpusOperationSettings = settingsBuilder.createRagCorpusOperationSettings().build();
    getRagCorpusSettings = settingsBuilder.getRagCorpusSettings().build();
    listRagCorporaSettings = settingsBuilder.listRagCorporaSettings().build();
    deleteRagCorpusSettings = settingsBuilder.deleteRagCorpusSettings().build();
    deleteRagCorpusOperationSettings = settingsBuilder.deleteRagCorpusOperationSettings().build();
    uploadRagFileSettings = settingsBuilder.uploadRagFileSettings().build();
    importRagFilesSettings = settingsBuilder.importRagFilesSettings().build();
    importRagFilesOperationSettings = settingsBuilder.importRagFilesOperationSettings().build();
    getRagFileSettings = settingsBuilder.getRagFileSettings().build();
    listRagFilesSettings = settingsBuilder.listRagFilesSettings().build();
    deleteRagFileSettings = settingsBuilder.deleteRagFileSettings().build();
    deleteRagFileOperationSettings = settingsBuilder.deleteRagFileOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for VertexRagDataServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<VertexRagDataServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateRagCorpusRequest, Operation>
        createRagCorpusSettings;
    private final OperationCallSettings.Builder<
            CreateRagCorpusRequest, RagCorpus, CreateRagCorpusOperationMetadata>
        createRagCorpusOperationSettings;
    private final UnaryCallSettings.Builder<GetRagCorpusRequest, RagCorpus> getRagCorpusSettings;
    private final PagedCallSettings.Builder<
            ListRagCorporaRequest, ListRagCorporaResponse, ListRagCorporaPagedResponse>
        listRagCorporaSettings;
    private final UnaryCallSettings.Builder<DeleteRagCorpusRequest, Operation>
        deleteRagCorpusSettings;
    private final OperationCallSettings.Builder<
            DeleteRagCorpusRequest, Empty, DeleteOperationMetadata>
        deleteRagCorpusOperationSettings;
    private final UnaryCallSettings.Builder<UploadRagFileRequest, UploadRagFileResponse>
        uploadRagFileSettings;
    private final UnaryCallSettings.Builder<ImportRagFilesRequest, Operation>
        importRagFilesSettings;
    private final OperationCallSettings.Builder<
            ImportRagFilesRequest, ImportRagFilesResponse, ImportRagFilesOperationMetadata>
        importRagFilesOperationSettings;
    private final UnaryCallSettings.Builder<GetRagFileRequest, RagFile> getRagFileSettings;
    private final PagedCallSettings.Builder<
            ListRagFilesRequest, ListRagFilesResponse, ListRagFilesPagedResponse>
        listRagFilesSettings;
    private final UnaryCallSettings.Builder<DeleteRagFileRequest, Operation> deleteRagFileSettings;
    private final OperationCallSettings.Builder<
            DeleteRagFileRequest, Empty, DeleteOperationMetadata>
        deleteRagFileOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
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

      createRagCorpusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRagCorpusOperationSettings = OperationCallSettings.newBuilder();
      getRagCorpusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRagCorporaSettings = PagedCallSettings.newBuilder(LIST_RAG_CORPORA_PAGE_STR_FACT);
      deleteRagCorpusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRagCorpusOperationSettings = OperationCallSettings.newBuilder();
      uploadRagFileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importRagFilesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importRagFilesOperationSettings = OperationCallSettings.newBuilder();
      getRagFileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRagFilesSettings = PagedCallSettings.newBuilder(LIST_RAG_FILES_PAGE_STR_FACT);
      deleteRagFileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRagFileOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createRagCorpusSettings,
              getRagCorpusSettings,
              listRagCorporaSettings,
              deleteRagCorpusSettings,
              uploadRagFileSettings,
              importRagFilesSettings,
              getRagFileSettings,
              listRagFilesSettings,
              deleteRagFileSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(VertexRagDataServiceStubSettings settings) {
      super(settings);

      createRagCorpusSettings = settings.createRagCorpusSettings.toBuilder();
      createRagCorpusOperationSettings = settings.createRagCorpusOperationSettings.toBuilder();
      getRagCorpusSettings = settings.getRagCorpusSettings.toBuilder();
      listRagCorporaSettings = settings.listRagCorporaSettings.toBuilder();
      deleteRagCorpusSettings = settings.deleteRagCorpusSettings.toBuilder();
      deleteRagCorpusOperationSettings = settings.deleteRagCorpusOperationSettings.toBuilder();
      uploadRagFileSettings = settings.uploadRagFileSettings.toBuilder();
      importRagFilesSettings = settings.importRagFilesSettings.toBuilder();
      importRagFilesOperationSettings = settings.importRagFilesOperationSettings.toBuilder();
      getRagFileSettings = settings.getRagFileSettings.toBuilder();
      listRagFilesSettings = settings.listRagFilesSettings.toBuilder();
      deleteRagFileSettings = settings.deleteRagFileSettings.toBuilder();
      deleteRagFileOperationSettings = settings.deleteRagFileOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createRagCorpusSettings,
              getRagCorpusSettings,
              listRagCorporaSettings,
              deleteRagCorpusSettings,
              uploadRagFileSettings,
              importRagFilesSettings,
              getRagFileSettings,
              listRagFilesSettings,
              deleteRagFileSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .createRagCorpusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getRagCorpusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listRagCorporaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteRagCorpusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .uploadRagFileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .importRagFilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getRagFileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listRagFilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteRagFileSettings()
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
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createRagCorpusOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateRagCorpusRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(RagCorpus.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateRagCorpusOperationMetadata.class))
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
          .deleteRagCorpusOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteRagCorpusRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteOperationMetadata.class))
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
          .importRagFilesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportRagFilesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ImportRagFilesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ImportRagFilesOperationMetadata.class))
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
          .deleteRagFileOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteRagFileRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to createRagCorpus. */
    public UnaryCallSettings.Builder<CreateRagCorpusRequest, Operation> createRagCorpusSettings() {
      return createRagCorpusSettings;
    }

    /** Returns the builder for the settings used for calls to createRagCorpus. */
    public OperationCallSettings.Builder<
            CreateRagCorpusRequest, RagCorpus, CreateRagCorpusOperationMetadata>
        createRagCorpusOperationSettings() {
      return createRagCorpusOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getRagCorpus. */
    public UnaryCallSettings.Builder<GetRagCorpusRequest, RagCorpus> getRagCorpusSettings() {
      return getRagCorpusSettings;
    }

    /** Returns the builder for the settings used for calls to listRagCorpora. */
    public PagedCallSettings.Builder<
            ListRagCorporaRequest, ListRagCorporaResponse, ListRagCorporaPagedResponse>
        listRagCorporaSettings() {
      return listRagCorporaSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRagCorpus. */
    public UnaryCallSettings.Builder<DeleteRagCorpusRequest, Operation> deleteRagCorpusSettings() {
      return deleteRagCorpusSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRagCorpus. */
    public OperationCallSettings.Builder<DeleteRagCorpusRequest, Empty, DeleteOperationMetadata>
        deleteRagCorpusOperationSettings() {
      return deleteRagCorpusOperationSettings;
    }

    /** Returns the builder for the settings used for calls to uploadRagFile. */
    public UnaryCallSettings.Builder<UploadRagFileRequest, UploadRagFileResponse>
        uploadRagFileSettings() {
      return uploadRagFileSettings;
    }

    /** Returns the builder for the settings used for calls to importRagFiles. */
    public UnaryCallSettings.Builder<ImportRagFilesRequest, Operation> importRagFilesSettings() {
      return importRagFilesSettings;
    }

    /** Returns the builder for the settings used for calls to importRagFiles. */
    public OperationCallSettings.Builder<
            ImportRagFilesRequest, ImportRagFilesResponse, ImportRagFilesOperationMetadata>
        importRagFilesOperationSettings() {
      return importRagFilesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getRagFile. */
    public UnaryCallSettings.Builder<GetRagFileRequest, RagFile> getRagFileSettings() {
      return getRagFileSettings;
    }

    /** Returns the builder for the settings used for calls to listRagFiles. */
    public PagedCallSettings.Builder<
            ListRagFilesRequest, ListRagFilesResponse, ListRagFilesPagedResponse>
        listRagFilesSettings() {
      return listRagFilesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRagFile. */
    public UnaryCallSettings.Builder<DeleteRagFileRequest, Operation> deleteRagFileSettings() {
      return deleteRagFileSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRagFile. */
    public OperationCallSettings.Builder<DeleteRagFileRequest, Empty, DeleteOperationMetadata>
        deleteRagFileOperationSettings() {
      return deleteRagFileOperationSettings;
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public VertexRagDataServiceStubSettings build() throws IOException {
      return new VertexRagDataServiceStubSettings(this);
    }
  }
}
