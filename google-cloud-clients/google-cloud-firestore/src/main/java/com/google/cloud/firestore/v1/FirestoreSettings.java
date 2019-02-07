/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
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

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
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
import com.google.firestore.v1.BeginTransactionRequest;
import com.google.firestore.v1.BeginTransactionResponse;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.CreateDocumentRequest;
import com.google.firestore.v1.DeleteDocumentRequest;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.GetDocumentRequest;
import com.google.firestore.v1.ListCollectionIdsRequest;
import com.google.firestore.v1.ListCollectionIdsResponse;
import com.google.firestore.v1.ListDocumentsRequest;
import com.google.firestore.v1.ListDocumentsResponse;
import com.google.firestore.v1.ListenRequest;
import com.google.firestore.v1.ListenResponse;
import com.google.firestore.v1.RollbackRequest;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.RunQueryResponse;
import com.google.firestore.v1.UpdateDocumentRequest;
import com.google.firestore.v1.WriteRequest;
import com.google.firestore.v1.WriteResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
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
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of updateDocument to 30 seconds:
 *
 * <pre>
 * <code>
 * FirestoreSettings.Builder firestoreSettingsBuilder =
 *     FirestoreSettings.newBuilder();
 * firestoreSettingsBuilder.updateDocumentSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * FirestoreSettings firestoreSettings = firestoreSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
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

  /** Returns the object with the settings used for calls to createDocument. */
  public UnaryCallSettings<CreateDocumentRequest, Document> createDocumentSettings() {
    return ((FirestoreStubSettings) getStubSettings()).createDocumentSettings();
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return FirestoreStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return FirestoreStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FirestoreStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected FirestoreSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for FirestoreSettings. */
  public static class Builder extends ClientSettings.Builder<FirestoreSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(FirestoreStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(FirestoreStubSettings.newBuilder());
    }

    protected Builder(FirestoreSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(FirestoreStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public FirestoreStubSettings.Builder getStubSettingsBuilder() {
      return ((FirestoreStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
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

    /** Returns the builder for the settings used for calls to createDocument. */
    public UnaryCallSettings.Builder<CreateDocumentRequest, Document> createDocumentSettings() {
      return getStubSettingsBuilder().createDocumentSettings();
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

    @Override
    public FirestoreSettings build() throws IOException {
      return new FirestoreSettings(this);
    }
  }
}
