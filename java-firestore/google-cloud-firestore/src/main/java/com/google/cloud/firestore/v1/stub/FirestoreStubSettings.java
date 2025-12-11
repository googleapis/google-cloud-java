/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.firestore.v1.stub;

import static com.google.cloud.firestore.v1.FirestoreClient.ListCollectionIdsPagedResponse;
import static com.google.cloud.firestore.v1.FirestoreClient.ListDocumentsPagedResponse;
import static com.google.cloud.firestore.v1.FirestoreClient.PartitionQueryPagedResponse;

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
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.BatchWriteRequest;
import com.google.firestore.v1.BatchWriteResponse;
import com.google.firestore.v1.BeginTransactionRequest;
import com.google.firestore.v1.BeginTransactionResponse;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.CreateDocumentRequest;
import com.google.firestore.v1.Cursor;
import com.google.firestore.v1.DeleteDocumentRequest;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.ExecutePipelineRequest;
import com.google.firestore.v1.ExecutePipelineResponse;
import com.google.firestore.v1.GetDocumentRequest;
import com.google.firestore.v1.ListCollectionIdsRequest;
import com.google.firestore.v1.ListCollectionIdsResponse;
import com.google.firestore.v1.ListDocumentsRequest;
import com.google.firestore.v1.ListDocumentsResponse;
import com.google.firestore.v1.ListenRequest;
import com.google.firestore.v1.ListenResponse;
import com.google.firestore.v1.PartitionQueryRequest;
import com.google.firestore.v1.PartitionQueryResponse;
import com.google.firestore.v1.RollbackRequest;
import com.google.firestore.v1.RunAggregationQueryRequest;
import com.google.firestore.v1.RunAggregationQueryResponse;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.RunQueryResponse;
import com.google.firestore.v1.UpdateDocumentRequest;
import com.google.firestore.v1.WriteRequest;
import com.google.firestore.v1.WriteResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link FirestoreStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (firestore.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getDocument:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FirestoreStubSettings.Builder firestoreSettingsBuilder = FirestoreStubSettings.newBuilder();
 * firestoreSettingsBuilder
 *     .getDocumentSettings()
 *     .setRetrySettings(
 *         firestoreSettingsBuilder
 *             .getDocumentSettings()
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
 * FirestoreStubSettings firestoreSettings = firestoreSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class FirestoreStubSettings extends StubSettings<FirestoreStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/datastore")
          .build();

  private final UnaryCallSettings<GetDocumentRequest, Document> getDocumentSettings;
  private final PagedCallSettings<
          ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
      listDocumentsSettings;
  private final UnaryCallSettings<UpdateDocumentRequest, Document> updateDocumentSettings;
  private final UnaryCallSettings<DeleteDocumentRequest, Empty> deleteDocumentSettings;
  private final ServerStreamingCallSettings<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsSettings;
  private final UnaryCallSettings<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionSettings;
  private final UnaryCallSettings<CommitRequest, CommitResponse> commitSettings;
  private final UnaryCallSettings<RollbackRequest, Empty> rollbackSettings;
  private final ServerStreamingCallSettings<RunQueryRequest, RunQueryResponse> runQuerySettings;
  private final ServerStreamingCallSettings<ExecutePipelineRequest, ExecutePipelineResponse>
      executePipelineSettings;
  private final ServerStreamingCallSettings<RunAggregationQueryRequest, RunAggregationQueryResponse>
      runAggregationQuerySettings;
  private final PagedCallSettings<
          PartitionQueryRequest, PartitionQueryResponse, PartitionQueryPagedResponse>
      partitionQuerySettings;
  private final StreamingCallSettings<WriteRequest, WriteResponse> writeSettings;
  private final StreamingCallSettings<ListenRequest, ListenResponse> listenSettings;
  private final PagedCallSettings<
          ListCollectionIdsRequest, ListCollectionIdsResponse, ListCollectionIdsPagedResponse>
      listCollectionIdsSettings;
  private final UnaryCallSettings<BatchWriteRequest, BatchWriteResponse> batchWriteSettings;
  private final UnaryCallSettings<CreateDocumentRequest, Document> createDocumentSettings;

  private static final PagedListDescriptor<ListDocumentsRequest, ListDocumentsResponse, Document>
      LIST_DOCUMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDocumentsRequest, ListDocumentsResponse, Document>() {
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
            public Iterable<Document> extractResources(ListDocumentsResponse payload) {
              return payload.getDocumentsList();
            }
          };

  private static final PagedListDescriptor<PartitionQueryRequest, PartitionQueryResponse, Cursor>
      PARTITION_QUERY_PAGE_STR_DESC =
          new PagedListDescriptor<PartitionQueryRequest, PartitionQueryResponse, Cursor>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public PartitionQueryRequest injectToken(PartitionQueryRequest payload, String token) {
              return PartitionQueryRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public PartitionQueryRequest injectPageSize(
                PartitionQueryRequest payload, int pageSize) {
              return PartitionQueryRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(PartitionQueryRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(PartitionQueryResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Cursor> extractResources(PartitionQueryResponse payload) {
              return payload.getPartitionsList();
            }
          };

  private static final PagedListDescriptor<
          ListCollectionIdsRequest, ListCollectionIdsResponse, String>
      LIST_COLLECTION_IDS_PAGE_STR_DESC =
          new PagedListDescriptor<ListCollectionIdsRequest, ListCollectionIdsResponse, String>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCollectionIdsRequest injectToken(
                ListCollectionIdsRequest payload, String token) {
              return ListCollectionIdsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCollectionIdsRequest injectPageSize(
                ListCollectionIdsRequest payload, int pageSize) {
              return ListCollectionIdsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCollectionIdsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCollectionIdsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<String> extractResources(ListCollectionIdsResponse payload) {
              return payload.getCollectionIdsList();
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
              PageContext<ListDocumentsRequest, ListDocumentsResponse, Document> pageContext =
                  PageContext.create(callable, LIST_DOCUMENTS_PAGE_STR_DESC, request, context);
              return ListDocumentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          PartitionQueryRequest, PartitionQueryResponse, PartitionQueryPagedResponse>
      PARTITION_QUERY_PAGE_STR_FACT =
          new PagedListResponseFactory<
              PartitionQueryRequest, PartitionQueryResponse, PartitionQueryPagedResponse>() {
            @Override
            public ApiFuture<PartitionQueryPagedResponse> getFuturePagedResponse(
                UnaryCallable<PartitionQueryRequest, PartitionQueryResponse> callable,
                PartitionQueryRequest request,
                ApiCallContext context,
                ApiFuture<PartitionQueryResponse> futureResponse) {
              PageContext<PartitionQueryRequest, PartitionQueryResponse, Cursor> pageContext =
                  PageContext.create(callable, PARTITION_QUERY_PAGE_STR_DESC, request, context);
              return PartitionQueryPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCollectionIdsRequest, ListCollectionIdsResponse, ListCollectionIdsPagedResponse>
      LIST_COLLECTION_IDS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCollectionIdsRequest,
              ListCollectionIdsResponse,
              ListCollectionIdsPagedResponse>() {
            @Override
            public ApiFuture<ListCollectionIdsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsResponse> callable,
                ListCollectionIdsRequest request,
                ApiCallContext context,
                ApiFuture<ListCollectionIdsResponse> futureResponse) {
              PageContext<ListCollectionIdsRequest, ListCollectionIdsResponse, String> pageContext =
                  PageContext.create(callable, LIST_COLLECTION_IDS_PAGE_STR_DESC, request, context);
              return ListCollectionIdsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getDocument. */
  public UnaryCallSettings<GetDocumentRequest, Document> getDocumentSettings() {
    return getDocumentSettings;
  }

  /** Returns the object with the settings used for calls to listDocuments. */
  public PagedCallSettings<ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
      listDocumentsSettings() {
    return listDocumentsSettings;
  }

  /** Returns the object with the settings used for calls to updateDocument. */
  public UnaryCallSettings<UpdateDocumentRequest, Document> updateDocumentSettings() {
    return updateDocumentSettings;
  }

  /** Returns the object with the settings used for calls to deleteDocument. */
  public UnaryCallSettings<DeleteDocumentRequest, Empty> deleteDocumentSettings() {
    return deleteDocumentSettings;
  }

  /** Returns the object with the settings used for calls to batchGetDocuments. */
  public ServerStreamingCallSettings<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsSettings() {
    return batchGetDocumentsSettings;
  }

  /** Returns the object with the settings used for calls to beginTransaction. */
  public UnaryCallSettings<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionSettings() {
    return beginTransactionSettings;
  }

  /** Returns the object with the settings used for calls to commit. */
  public UnaryCallSettings<CommitRequest, CommitResponse> commitSettings() {
    return commitSettings;
  }

  /** Returns the object with the settings used for calls to rollback. */
  public UnaryCallSettings<RollbackRequest, Empty> rollbackSettings() {
    return rollbackSettings;
  }

  /** Returns the object with the settings used for calls to runQuery. */
  public ServerStreamingCallSettings<RunQueryRequest, RunQueryResponse> runQuerySettings() {
    return runQuerySettings;
  }

  /** Returns the object with the settings used for calls to executePipeline. */
  public ServerStreamingCallSettings<ExecutePipelineRequest, ExecutePipelineResponse>
      executePipelineSettings() {
    return executePipelineSettings;
  }

  /** Returns the object with the settings used for calls to runAggregationQuery. */
  public ServerStreamingCallSettings<RunAggregationQueryRequest, RunAggregationQueryResponse>
      runAggregationQuerySettings() {
    return runAggregationQuerySettings;
  }

  /** Returns the object with the settings used for calls to partitionQuery. */
  public PagedCallSettings<
          PartitionQueryRequest, PartitionQueryResponse, PartitionQueryPagedResponse>
      partitionQuerySettings() {
    return partitionQuerySettings;
  }

  /** Returns the object with the settings used for calls to write. */
  public StreamingCallSettings<WriteRequest, WriteResponse> writeSettings() {
    return writeSettings;
  }

  /** Returns the object with the settings used for calls to listen. */
  public StreamingCallSettings<ListenRequest, ListenResponse> listenSettings() {
    return listenSettings;
  }

  /** Returns the object with the settings used for calls to listCollectionIds. */
  public PagedCallSettings<
          ListCollectionIdsRequest, ListCollectionIdsResponse, ListCollectionIdsPagedResponse>
      listCollectionIdsSettings() {
    return listCollectionIdsSettings;
  }

  /** Returns the object with the settings used for calls to batchWrite. */
  public UnaryCallSettings<BatchWriteRequest, BatchWriteResponse> batchWriteSettings() {
    return batchWriteSettings;
  }

  /** Returns the object with the settings used for calls to createDocument. */
  public UnaryCallSettings<CreateDocumentRequest, Document> createDocumentSettings() {
    return createDocumentSettings;
  }

  public FirestoreStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcFirestoreStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonFirestoreStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "firestore";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "firestore.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "firestore.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(FirestoreStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(FirestoreStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FirestoreStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected FirestoreStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getDocumentSettings = settingsBuilder.getDocumentSettings().build();
    listDocumentsSettings = settingsBuilder.listDocumentsSettings().build();
    updateDocumentSettings = settingsBuilder.updateDocumentSettings().build();
    deleteDocumentSettings = settingsBuilder.deleteDocumentSettings().build();
    batchGetDocumentsSettings = settingsBuilder.batchGetDocumentsSettings().build();
    beginTransactionSettings = settingsBuilder.beginTransactionSettings().build();
    commitSettings = settingsBuilder.commitSettings().build();
    rollbackSettings = settingsBuilder.rollbackSettings().build();
    runQuerySettings = settingsBuilder.runQuerySettings().build();
    executePipelineSettings = settingsBuilder.executePipelineSettings().build();
    runAggregationQuerySettings = settingsBuilder.runAggregationQuerySettings().build();
    partitionQuerySettings = settingsBuilder.partitionQuerySettings().build();
    writeSettings = settingsBuilder.writeSettings().build();
    listenSettings = settingsBuilder.listenSettings().build();
    listCollectionIdsSettings = settingsBuilder.listCollectionIdsSettings().build();
    batchWriteSettings = settingsBuilder.batchWriteSettings().build();
    createDocumentSettings = settingsBuilder.createDocumentSettings().build();
  }

  /** Builder for FirestoreStubSettings. */
  public static class Builder extends StubSettings.Builder<FirestoreStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetDocumentRequest, Document> getDocumentSettings;
    private final PagedCallSettings.Builder<
            ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
        listDocumentsSettings;
    private final UnaryCallSettings.Builder<UpdateDocumentRequest, Document> updateDocumentSettings;
    private final UnaryCallSettings.Builder<DeleteDocumentRequest, Empty> deleteDocumentSettings;
    private final ServerStreamingCallSettings.Builder<
            BatchGetDocumentsRequest, BatchGetDocumentsResponse>
        batchGetDocumentsSettings;
    private final UnaryCallSettings.Builder<BeginTransactionRequest, BeginTransactionResponse>
        beginTransactionSettings;
    private final UnaryCallSettings.Builder<CommitRequest, CommitResponse> commitSettings;
    private final UnaryCallSettings.Builder<RollbackRequest, Empty> rollbackSettings;
    private final ServerStreamingCallSettings.Builder<RunQueryRequest, RunQueryResponse>
        runQuerySettings;
    private final ServerStreamingCallSettings.Builder<
            ExecutePipelineRequest, ExecutePipelineResponse>
        executePipelineSettings;
    private final ServerStreamingCallSettings.Builder<
            RunAggregationQueryRequest, RunAggregationQueryResponse>
        runAggregationQuerySettings;
    private final PagedCallSettings.Builder<
            PartitionQueryRequest, PartitionQueryResponse, PartitionQueryPagedResponse>
        partitionQuerySettings;
    private final StreamingCallSettings.Builder<WriteRequest, WriteResponse> writeSettings;
    private final StreamingCallSettings.Builder<ListenRequest, ListenResponse> listenSettings;
    private final PagedCallSettings.Builder<
            ListCollectionIdsRequest, ListCollectionIdsResponse, ListCollectionIdsPagedResponse>
        listCollectionIdsSettings;
    private final UnaryCallSettings.Builder<BatchWriteRequest, BatchWriteResponse>
        batchWriteSettings;
    private final UnaryCallSettings.Builder<CreateDocumentRequest, Document> createDocumentSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_4_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.RESOURCE_EXHAUSTED,
                  StatusCode.Code.UNAVAILABLE,
                  StatusCode.Code.INTERNAL,
                  StatusCode.Code.DEADLINE_EXCEEDED)));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.RESOURCE_EXHAUSTED, StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.RESOURCE_EXHAUSTED,
                  StatusCode.Code.UNAVAILABLE,
                  StatusCode.Code.INTERNAL,
                  StatusCode.Code.DEADLINE_EXCEEDED)));
      definitions.put(
          "no_retry_3_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_2_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.RESOURCE_EXHAUSTED,
                  StatusCode.Code.UNAVAILABLE,
                  StatusCode.Code.INTERNAL,
                  StatusCode.Code.DEADLINE_EXCEEDED)));
      definitions.put(
          "retry_policy_5_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.RESOURCE_EXHAUSTED,
                  StatusCode.Code.UNAVAILABLE,
                  StatusCode.Code.ABORTED)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_4_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(300000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(300000L))
              .setTotalTimeoutDuration(Duration.ofMillis(300000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(86400000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(86400000L))
              .setTotalTimeoutDuration(Duration.ofMillis(86400000L))
              .build();
      definitions.put("no_retry_3_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(86400000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(86400000L))
              .setTotalTimeoutDuration(Duration.ofMillis(86400000L))
              .build();
      definitions.put("retry_policy_2_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_5_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDocumentsSettings = PagedCallSettings.newBuilder(LIST_DOCUMENTS_PAGE_STR_FACT);
      updateDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchGetDocumentsSettings = ServerStreamingCallSettings.newBuilder();
      beginTransactionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      commitSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      rollbackSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      runQuerySettings = ServerStreamingCallSettings.newBuilder();
      executePipelineSettings = ServerStreamingCallSettings.newBuilder();
      runAggregationQuerySettings = ServerStreamingCallSettings.newBuilder();
      partitionQuerySettings = PagedCallSettings.newBuilder(PARTITION_QUERY_PAGE_STR_FACT);
      writeSettings = StreamingCallSettings.newBuilder();
      listenSettings = StreamingCallSettings.newBuilder();
      listCollectionIdsSettings = PagedCallSettings.newBuilder(LIST_COLLECTION_IDS_PAGE_STR_FACT);
      batchWriteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getDocumentSettings,
              listDocumentsSettings,
              updateDocumentSettings,
              deleteDocumentSettings,
              beginTransactionSettings,
              commitSettings,
              rollbackSettings,
              partitionQuerySettings,
              listCollectionIdsSettings,
              batchWriteSettings,
              createDocumentSettings);
      initDefaults(this);
    }

    protected Builder(FirestoreStubSettings settings) {
      super(settings);

      getDocumentSettings = settings.getDocumentSettings.toBuilder();
      listDocumentsSettings = settings.listDocumentsSettings.toBuilder();
      updateDocumentSettings = settings.updateDocumentSettings.toBuilder();
      deleteDocumentSettings = settings.deleteDocumentSettings.toBuilder();
      batchGetDocumentsSettings = settings.batchGetDocumentsSettings.toBuilder();
      beginTransactionSettings = settings.beginTransactionSettings.toBuilder();
      commitSettings = settings.commitSettings.toBuilder();
      rollbackSettings = settings.rollbackSettings.toBuilder();
      runQuerySettings = settings.runQuerySettings.toBuilder();
      executePipelineSettings = settings.executePipelineSettings.toBuilder();
      runAggregationQuerySettings = settings.runAggregationQuerySettings.toBuilder();
      partitionQuerySettings = settings.partitionQuerySettings.toBuilder();
      writeSettings = settings.writeSettings.toBuilder();
      listenSettings = settings.listenSettings.toBuilder();
      listCollectionIdsSettings = settings.listCollectionIdsSettings.toBuilder();
      batchWriteSettings = settings.batchWriteSettings.toBuilder();
      createDocumentSettings = settings.createDocumentSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getDocumentSettings,
              listDocumentsSettings,
              updateDocumentSettings,
              deleteDocumentSettings,
              beginTransactionSettings,
              commitSettings,
              rollbackSettings,
              partitionQuerySettings,
              listCollectionIdsSettings,
              batchWriteSettings,
              createDocumentSettings);
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
          .getDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_4_params"));

      builder
          .listDocumentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_4_params"));

      builder
          .updateDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_4_params"));

      builder
          .batchGetDocumentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .beginTransactionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_4_params"));

      builder
          .commitSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .rollbackSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_4_params"));

      builder
          .runQuerySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .executePipelineSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .runAggregationQuerySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .partitionQuerySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listCollectionIdsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_4_params"));

      builder
          .batchWriteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_5_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_5_params"));

      builder
          .createDocumentSettings()
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

    /** Returns the builder for the settings used for calls to getDocument. */
    public UnaryCallSettings.Builder<GetDocumentRequest, Document> getDocumentSettings() {
      return getDocumentSettings;
    }

    /** Returns the builder for the settings used for calls to listDocuments. */
    public PagedCallSettings.Builder<
            ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
        listDocumentsSettings() {
      return listDocumentsSettings;
    }

    /** Returns the builder for the settings used for calls to updateDocument. */
    public UnaryCallSettings.Builder<UpdateDocumentRequest, Document> updateDocumentSettings() {
      return updateDocumentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDocument. */
    public UnaryCallSettings.Builder<DeleteDocumentRequest, Empty> deleteDocumentSettings() {
      return deleteDocumentSettings;
    }

    /** Returns the builder for the settings used for calls to batchGetDocuments. */
    public ServerStreamingCallSettings.Builder<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
        batchGetDocumentsSettings() {
      return batchGetDocumentsSettings;
    }

    /** Returns the builder for the settings used for calls to beginTransaction. */
    public UnaryCallSettings.Builder<BeginTransactionRequest, BeginTransactionResponse>
        beginTransactionSettings() {
      return beginTransactionSettings;
    }

    /** Returns the builder for the settings used for calls to commit. */
    public UnaryCallSettings.Builder<CommitRequest, CommitResponse> commitSettings() {
      return commitSettings;
    }

    /** Returns the builder for the settings used for calls to rollback. */
    public UnaryCallSettings.Builder<RollbackRequest, Empty> rollbackSettings() {
      return rollbackSettings;
    }

    /** Returns the builder for the settings used for calls to runQuery. */
    public ServerStreamingCallSettings.Builder<RunQueryRequest, RunQueryResponse>
        runQuerySettings() {
      return runQuerySettings;
    }

    /** Returns the builder for the settings used for calls to executePipeline. */
    public ServerStreamingCallSettings.Builder<ExecutePipelineRequest, ExecutePipelineResponse>
        executePipelineSettings() {
      return executePipelineSettings;
    }

    /** Returns the builder for the settings used for calls to runAggregationQuery. */
    public ServerStreamingCallSettings.Builder<
            RunAggregationQueryRequest, RunAggregationQueryResponse>
        runAggregationQuerySettings() {
      return runAggregationQuerySettings;
    }

    /** Returns the builder for the settings used for calls to partitionQuery. */
    public PagedCallSettings.Builder<
            PartitionQueryRequest, PartitionQueryResponse, PartitionQueryPagedResponse>
        partitionQuerySettings() {
      return partitionQuerySettings;
    }

    /** Returns the builder for the settings used for calls to write. */
    public StreamingCallSettings.Builder<WriteRequest, WriteResponse> writeSettings() {
      return writeSettings;
    }

    /** Returns the builder for the settings used for calls to listen. */
    public StreamingCallSettings.Builder<ListenRequest, ListenResponse> listenSettings() {
      return listenSettings;
    }

    /** Returns the builder for the settings used for calls to listCollectionIds. */
    public PagedCallSettings.Builder<
            ListCollectionIdsRequest, ListCollectionIdsResponse, ListCollectionIdsPagedResponse>
        listCollectionIdsSettings() {
      return listCollectionIdsSettings;
    }

    /** Returns the builder for the settings used for calls to batchWrite. */
    public UnaryCallSettings.Builder<BatchWriteRequest, BatchWriteResponse> batchWriteSettings() {
      return batchWriteSettings;
    }

    /** Returns the builder for the settings used for calls to createDocument. */
    public UnaryCallSettings.Builder<CreateDocumentRequest, Document> createDocumentSettings() {
      return createDocumentSettings;
    }

    @Override
    public FirestoreStubSettings build() throws IOException {
      return new FirestoreStubSettings(this);
    }
  }
}
