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

package com.google.cloud.firestore.v1;

import static com.google.cloud.firestore.v1.FirestoreClient.ListCollectionIdsPagedResponse;
import static com.google.cloud.firestore.v1.FirestoreClient.ListDocumentsPagedResponse;
import static com.google.cloud.firestore.v1.FirestoreClient.PartitionQueryPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.firestore.v1.stub.FirestoreStubSettings;
import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.BatchWriteRequest;
import com.google.firestore.v1.BatchWriteResponse;
import com.google.firestore.v1.BeginTransactionRequest;
import com.google.firestore.v1.BeginTransactionResponse;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.CreateDocumentRequest;
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
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link FirestoreClient}.
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
 * FirestoreSettings.Builder firestoreSettingsBuilder = FirestoreSettings.newBuilder();
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
 * FirestoreSettings firestoreSettings = firestoreSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class FirestoreSettings extends ClientSettings<FirestoreSettings> {

  /** Returns the object with the settings used for calls to getDocument. */
  public UnaryCallSettings<GetDocumentRequest, Document> getDocumentSettings() {
    return ((FirestoreStubSettings) getStubSettings()).getDocumentSettings();
  }

  /** Returns the object with the settings used for calls to listDocuments. */
  public PagedCallSettings<ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
      listDocumentsSettings() {
    return ((FirestoreStubSettings) getStubSettings()).listDocumentsSettings();
  }

  /** Returns the object with the settings used for calls to updateDocument. */
  public UnaryCallSettings<UpdateDocumentRequest, Document> updateDocumentSettings() {
    return ((FirestoreStubSettings) getStubSettings()).updateDocumentSettings();
  }

  /** Returns the object with the settings used for calls to deleteDocument. */
  public UnaryCallSettings<DeleteDocumentRequest, Empty> deleteDocumentSettings() {
    return ((FirestoreStubSettings) getStubSettings()).deleteDocumentSettings();
  }

  /** Returns the object with the settings used for calls to batchGetDocuments. */
  public ServerStreamingCallSettings<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsSettings() {
    return ((FirestoreStubSettings) getStubSettings()).batchGetDocumentsSettings();
  }

  /** Returns the object with the settings used for calls to beginTransaction. */
  public UnaryCallSettings<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionSettings() {
    return ((FirestoreStubSettings) getStubSettings()).beginTransactionSettings();
  }

  /** Returns the object with the settings used for calls to commit. */
  public UnaryCallSettings<CommitRequest, CommitResponse> commitSettings() {
    return ((FirestoreStubSettings) getStubSettings()).commitSettings();
  }

  /** Returns the object with the settings used for calls to rollback. */
  public UnaryCallSettings<RollbackRequest, Empty> rollbackSettings() {
    return ((FirestoreStubSettings) getStubSettings()).rollbackSettings();
  }

  /** Returns the object with the settings used for calls to runQuery. */
  public ServerStreamingCallSettings<RunQueryRequest, RunQueryResponse> runQuerySettings() {
    return ((FirestoreStubSettings) getStubSettings()).runQuerySettings();
  }

  /** Returns the object with the settings used for calls to executePipeline. */
  public ServerStreamingCallSettings<ExecutePipelineRequest, ExecutePipelineResponse>
      executePipelineSettings() {
    return ((FirestoreStubSettings) getStubSettings()).executePipelineSettings();
  }

  /** Returns the object with the settings used for calls to runAggregationQuery. */
  public ServerStreamingCallSettings<RunAggregationQueryRequest, RunAggregationQueryResponse>
      runAggregationQuerySettings() {
    return ((FirestoreStubSettings) getStubSettings()).runAggregationQuerySettings();
  }

  /** Returns the object with the settings used for calls to partitionQuery. */
  public PagedCallSettings<
          PartitionQueryRequest, PartitionQueryResponse, PartitionQueryPagedResponse>
      partitionQuerySettings() {
    return ((FirestoreStubSettings) getStubSettings()).partitionQuerySettings();
  }

  /** Returns the object with the settings used for calls to write. */
  public StreamingCallSettings<WriteRequest, WriteResponse> writeSettings() {
    return ((FirestoreStubSettings) getStubSettings()).writeSettings();
  }

  /** Returns the object with the settings used for calls to listen. */
  public StreamingCallSettings<ListenRequest, ListenResponse> listenSettings() {
    return ((FirestoreStubSettings) getStubSettings()).listenSettings();
  }

  /** Returns the object with the settings used for calls to listCollectionIds. */
  public PagedCallSettings<
          ListCollectionIdsRequest, ListCollectionIdsResponse, ListCollectionIdsPagedResponse>
      listCollectionIdsSettings() {
    return ((FirestoreStubSettings) getStubSettings()).listCollectionIdsSettings();
  }

  /** Returns the object with the settings used for calls to batchWrite. */
  public UnaryCallSettings<BatchWriteRequest, BatchWriteResponse> batchWriteSettings() {
    return ((FirestoreStubSettings) getStubSettings()).batchWriteSettings();
  }

  /** Returns the object with the settings used for calls to createDocument. */
  public UnaryCallSettings<CreateDocumentRequest, Document> createDocumentSettings() {
    return ((FirestoreStubSettings) getStubSettings()).createDocumentSettings();
  }

  public static final FirestoreSettings create(FirestoreStubSettings stub) throws IOException {
    return new FirestoreSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return FirestoreStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return FirestoreStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return FirestoreStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return FirestoreStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return FirestoreStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return FirestoreStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return FirestoreStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FirestoreStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected FirestoreSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for FirestoreSettings. */
  public static class Builder extends ClientSettings.Builder<FirestoreSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(FirestoreStubSettings.newBuilder(clientContext));
    }

    protected Builder(FirestoreSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(FirestoreStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(FirestoreStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(FirestoreStubSettings.newHttpJsonBuilder());
    }

    public FirestoreStubSettings.Builder getStubSettingsBuilder() {
      return ((FirestoreStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to getDocument. */
    public UnaryCallSettings.Builder<GetDocumentRequest, Document> getDocumentSettings() {
      return getStubSettingsBuilder().getDocumentSettings();
    }

    /** Returns the builder for the settings used for calls to listDocuments. */
    public PagedCallSettings.Builder<
            ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
        listDocumentsSettings() {
      return getStubSettingsBuilder().listDocumentsSettings();
    }

    /** Returns the builder for the settings used for calls to updateDocument. */
    public UnaryCallSettings.Builder<UpdateDocumentRequest, Document> updateDocumentSettings() {
      return getStubSettingsBuilder().updateDocumentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDocument. */
    public UnaryCallSettings.Builder<DeleteDocumentRequest, Empty> deleteDocumentSettings() {
      return getStubSettingsBuilder().deleteDocumentSettings();
    }

    /** Returns the builder for the settings used for calls to batchGetDocuments. */
    public ServerStreamingCallSettings.Builder<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
        batchGetDocumentsSettings() {
      return getStubSettingsBuilder().batchGetDocumentsSettings();
    }

    /** Returns the builder for the settings used for calls to beginTransaction. */
    public UnaryCallSettings.Builder<BeginTransactionRequest, BeginTransactionResponse>
        beginTransactionSettings() {
      return getStubSettingsBuilder().beginTransactionSettings();
    }

    /** Returns the builder for the settings used for calls to commit. */
    public UnaryCallSettings.Builder<CommitRequest, CommitResponse> commitSettings() {
      return getStubSettingsBuilder().commitSettings();
    }

    /** Returns the builder for the settings used for calls to rollback. */
    public UnaryCallSettings.Builder<RollbackRequest, Empty> rollbackSettings() {
      return getStubSettingsBuilder().rollbackSettings();
    }

    /** Returns the builder for the settings used for calls to runQuery. */
    public ServerStreamingCallSettings.Builder<RunQueryRequest, RunQueryResponse>
        runQuerySettings() {
      return getStubSettingsBuilder().runQuerySettings();
    }

    /** Returns the builder for the settings used for calls to executePipeline. */
    public ServerStreamingCallSettings.Builder<ExecutePipelineRequest, ExecutePipelineResponse>
        executePipelineSettings() {
      return getStubSettingsBuilder().executePipelineSettings();
    }

    /** Returns the builder for the settings used for calls to runAggregationQuery. */
    public ServerStreamingCallSettings.Builder<
            RunAggregationQueryRequest, RunAggregationQueryResponse>
        runAggregationQuerySettings() {
      return getStubSettingsBuilder().runAggregationQuerySettings();
    }

    /** Returns the builder for the settings used for calls to partitionQuery. */
    public PagedCallSettings.Builder<
            PartitionQueryRequest, PartitionQueryResponse, PartitionQueryPagedResponse>
        partitionQuerySettings() {
      return getStubSettingsBuilder().partitionQuerySettings();
    }

    /** Returns the builder for the settings used for calls to write. */
    public StreamingCallSettings.Builder<WriteRequest, WriteResponse> writeSettings() {
      return getStubSettingsBuilder().writeSettings();
    }

    /** Returns the builder for the settings used for calls to listen. */
    public StreamingCallSettings.Builder<ListenRequest, ListenResponse> listenSettings() {
      return getStubSettingsBuilder().listenSettings();
    }

    /** Returns the builder for the settings used for calls to listCollectionIds. */
    public PagedCallSettings.Builder<
            ListCollectionIdsRequest, ListCollectionIdsResponse, ListCollectionIdsPagedResponse>
        listCollectionIdsSettings() {
      return getStubSettingsBuilder().listCollectionIdsSettings();
    }

    /** Returns the builder for the settings used for calls to batchWrite. */
    public UnaryCallSettings.Builder<BatchWriteRequest, BatchWriteResponse> batchWriteSettings() {
      return getStubSettingsBuilder().batchWriteSettings();
    }

    /** Returns the builder for the settings used for calls to createDocument. */
    public UnaryCallSettings.Builder<CreateDocumentRequest, Document> createDocumentSettings() {
      return getStubSettingsBuilder().createDocumentSettings();
    }

    @Override
    public FirestoreSettings build() throws IOException {
      return new FirestoreSettings(this);
    }
  }
}
