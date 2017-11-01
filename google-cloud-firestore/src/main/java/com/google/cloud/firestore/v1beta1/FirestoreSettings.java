/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.firestore.v1beta1;

import static com.google.cloud.firestore.v1beta1.PagedResponseWrappers.ListCollectionIdsPagedResponse;
import static com.google.cloud.firestore.v1beta1.PagedResponseWrappers.ListDocumentsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.core.PropertiesProvider;
import com.google.api.gax.grpc.GrpcExtraHeaderData;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.firestore.v1beta1.stub.FirestoreStub;
import com.google.cloud.firestore.v1beta1.stub.GrpcFirestoreStub;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.firestore.v1beta1.BatchGetDocumentsRequest;
import com.google.firestore.v1beta1.BatchGetDocumentsResponse;
import com.google.firestore.v1beta1.BeginTransactionRequest;
import com.google.firestore.v1beta1.BeginTransactionResponse;
import com.google.firestore.v1beta1.CommitRequest;
import com.google.firestore.v1beta1.CommitResponse;
import com.google.firestore.v1beta1.CreateDocumentRequest;
import com.google.firestore.v1beta1.DeleteDocumentRequest;
import com.google.firestore.v1beta1.Document;
import com.google.firestore.v1beta1.GetDocumentRequest;
import com.google.firestore.v1beta1.ListCollectionIdsRequest;
import com.google.firestore.v1beta1.ListCollectionIdsResponse;
import com.google.firestore.v1beta1.ListDocumentsRequest;
import com.google.firestore.v1beta1.ListDocumentsResponse;
import com.google.firestore.v1beta1.ListenRequest;
import com.google.firestore.v1beta1.ListenResponse;
import com.google.firestore.v1beta1.RollbackRequest;
import com.google.firestore.v1beta1.RunQueryRequest;
import com.google.firestore.v1beta1.RunQueryResponse;
import com.google.firestore.v1beta1.UpdateDocumentRequest;
import com.google.firestore.v1beta1.WriteRequest;
import com.google.firestore.v1beta1.WriteResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

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
 * firestoreSettingsBuilder.updateDocumentSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * FirestoreSettings firestoreSettings = firestoreSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class FirestoreSettings extends ClientSettings {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/datastore")
          .build();

  private static final String DEFAULT_GAPIC_NAME = "gapic";
  private static final String DEFAULT_GAPIC_VERSION = "";

  private static final String PROPERTIES_FILE = "/com/google/cloud/firestore/project.properties";
  private static final String META_VERSION_KEY = "artifact.version";

  private static String gapicVersion;

  private final UnaryCallSettings<GetDocumentRequest, Document> getDocumentSettings;
  private final PagedCallSettings<
          ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
      listDocumentsSettings;
  private final UnaryCallSettings<CreateDocumentRequest, Document> createDocumentSettings;
  private final UnaryCallSettings<UpdateDocumentRequest, Document> updateDocumentSettings;
  private final UnaryCallSettings<DeleteDocumentRequest, Empty> deleteDocumentSettings;
  private final StreamingCallSettings<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsSettings;
  private final UnaryCallSettings<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionSettings;
  private final UnaryCallSettings<CommitRequest, CommitResponse> commitSettings;
  private final UnaryCallSettings<RollbackRequest, Empty> rollbackSettings;
  private final StreamingCallSettings<RunQueryRequest, RunQueryResponse> runQuerySettings;
  private final StreamingCallSettings<WriteRequest, WriteResponse> writeSettings;
  private final StreamingCallSettings<ListenRequest, ListenResponse> listenSettings;
  private final PagedCallSettings<
          ListCollectionIdsRequest, ListCollectionIdsResponse, ListCollectionIdsPagedResponse>
      listCollectionIdsSettings;

  /** Returns the object with the settings used for calls to getDocument. */
  public UnaryCallSettings<GetDocumentRequest, Document> getDocumentSettings() {
    return getDocumentSettings;
  }

  /** Returns the object with the settings used for calls to listDocuments. */
  public PagedCallSettings<ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
      listDocumentsSettings() {
    return listDocumentsSettings;
  }

  /** Returns the object with the settings used for calls to createDocument. */
  public UnaryCallSettings<CreateDocumentRequest, Document> createDocumentSettings() {
    return createDocumentSettings;
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
  public StreamingCallSettings<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
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
  public StreamingCallSettings<RunQueryRequest, RunQueryResponse> runQuerySettings() {
    return runQuerySettings;
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

  public FirestoreStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcFirestoreStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "firestore.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder().setEndpoint(getDefaultEndpoint());
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratorHeader(DEFAULT_GAPIC_NAME, getGapicVersion())
        .setApiClientHeaderLineKey("x-goog-api-client")
        .addApiClientHeaderLineData(GrpcExtraHeaderData.getXGoogApiClientData());
  }

  private static String getGapicVersion() {
    if (gapicVersion == null) {
      gapicVersion =
          PropertiesProvider.loadProperty(
              FirestoreSettings.class, PROPERTIES_FILE, META_VERSION_KEY);
      gapicVersion = gapicVersion == null ? DEFAULT_GAPIC_VERSION : gapicVersion;
    }
    return gapicVersion;
  }

  /** Returns a builder for this class with recommended defaults. */
  @Deprecated
  public static Builder defaultBuilder() {
    return Builder.createDefault();
  }

  /**
   * Returns a builder for this class with recommended defaults for API methods, and the given
   * ClientContext used for executor/transport/credentials.
   */
  @Deprecated
  public static Builder defaultBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
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

  private FirestoreSettings(Builder settingsBuilder) throws IOException {
    super(
        settingsBuilder.getExecutorProvider(),
        settingsBuilder.getTransportChannelProvider(),
        settingsBuilder.getCredentialsProvider(),
        settingsBuilder.getHeaderProvider(),
        settingsBuilder.getClock());

    getDocumentSettings = settingsBuilder.getDocumentSettings().build();
    listDocumentsSettings = settingsBuilder.listDocumentsSettings().build();
    createDocumentSettings = settingsBuilder.createDocumentSettings().build();
    updateDocumentSettings = settingsBuilder.updateDocumentSettings().build();
    deleteDocumentSettings = settingsBuilder.deleteDocumentSettings().build();
    batchGetDocumentsSettings = settingsBuilder.batchGetDocumentsSettings().build();
    beginTransactionSettings = settingsBuilder.beginTransactionSettings().build();
    commitSettings = settingsBuilder.commitSettings().build();
    rollbackSettings = settingsBuilder.rollbackSettings().build();
    runQuerySettings = settingsBuilder.runQuerySettings().build();
    writeSettings = settingsBuilder.writeSettings().build();
    listenSettings = settingsBuilder.listenSettings().build();
    listCollectionIdsSettings = settingsBuilder.listCollectionIdsSettings().build();
  }

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
          ListCollectionIdsRequest, ListCollectionIdsResponse, ListCollectionIdsPagedResponse>
      LIST_COLLECTION_IDS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCollectionIdsRequest, ListCollectionIdsResponse,
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

  /** Builder for FirestoreSettings. */
  public static class Builder extends ClientSettings.Builder {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<GetDocumentRequest, Document> getDocumentSettings;
    private final PagedCallSettings.Builder<
            ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
        listDocumentsSettings;
    private final UnaryCallSettings.Builder<CreateDocumentRequest, Document> createDocumentSettings;
    private final UnaryCallSettings.Builder<UpdateDocumentRequest, Document> updateDocumentSettings;
    private final UnaryCallSettings.Builder<DeleteDocumentRequest, Empty> deleteDocumentSettings;
    private final StreamingCallSettings.Builder<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
        batchGetDocumentsSettings;
    private final UnaryCallSettings.Builder<BeginTransactionRequest, BeginTransactionResponse>
        beginTransactionSettings;
    private final UnaryCallSettings.Builder<CommitRequest, CommitResponse> commitSettings;
    private final UnaryCallSettings.Builder<RollbackRequest, Empty> rollbackSettings;
    private final StreamingCallSettings.Builder<RunQueryRequest, RunQueryResponse> runQuerySettings;
    private final StreamingCallSettings.Builder<WriteRequest, WriteResponse> writeSettings;
    private final StreamingCallSettings.Builder<ListenRequest, ListenResponse> listenSettings;
    private final PagedCallSettings.Builder<
            ListCollectionIdsRequest, ListCollectionIdsResponse, ListCollectionIdsPagedResponse>
        listCollectionIdsSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(300000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(300000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("streaming", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    private Builder() {
      this((ClientContext) null);
    }

    private Builder(ClientContext clientContext) {
      super(clientContext);

      getDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listDocumentsSettings = PagedCallSettings.newBuilder(LIST_DOCUMENTS_PAGE_STR_FACT);

      createDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      batchGetDocumentsSettings = StreamingCallSettings.newBuilder();

      beginTransactionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      commitSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      rollbackSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      runQuerySettings = StreamingCallSettings.newBuilder();

      writeSettings = StreamingCallSettings.newBuilder();

      listenSettings = StreamingCallSettings.newBuilder();

      listCollectionIdsSettings = PagedCallSettings.newBuilder(LIST_COLLECTION_IDS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getDocumentSettings,
              listDocumentsSettings,
              createDocumentSettings,
              updateDocumentSettings,
              deleteDocumentSettings,
              beginTransactionSettings,
              commitSettings,
              rollbackSettings,
              listCollectionIdsSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .getDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listDocumentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .beginTransactionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .commitSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .rollbackSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listCollectionIdsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    private Builder(FirestoreSettings settings) {
      super(settings);

      getDocumentSettings = settings.getDocumentSettings.toBuilder();
      listDocumentsSettings = settings.listDocumentsSettings.toBuilder();
      createDocumentSettings = settings.createDocumentSettings.toBuilder();
      updateDocumentSettings = settings.updateDocumentSettings.toBuilder();
      deleteDocumentSettings = settings.deleteDocumentSettings.toBuilder();
      batchGetDocumentsSettings = settings.batchGetDocumentsSettings.toBuilder();
      beginTransactionSettings = settings.beginTransactionSettings.toBuilder();
      commitSettings = settings.commitSettings.toBuilder();
      rollbackSettings = settings.rollbackSettings.toBuilder();
      runQuerySettings = settings.runQuerySettings.toBuilder();
      writeSettings = settings.writeSettings.toBuilder();
      listenSettings = settings.listenSettings.toBuilder();
      listCollectionIdsSettings = settings.listCollectionIdsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getDocumentSettings,
              listDocumentsSettings,
              createDocumentSettings,
              updateDocumentSettings,
              deleteDocumentSettings,
              beginTransactionSettings,
              commitSettings,
              rollbackSettings,
              listCollectionIdsSettings);
    }

    @Override
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      super.setExecutorProvider(executorProvider);
      return this;
    }

    @Override
    public Builder setTransportChannelProvider(TransportChannelProvider transportProvider) {
      super.setTransportChannelProvider(transportProvider);
      return this;
    }

    @Override
    public Builder setHeaderProvider(HeaderProvider headerProvider) {
      super.setHeaderProvider(headerProvider);
      return this;
    }

    @Override
    public Builder setCredentialsProvider(CredentialsProvider credentialsProvider) {
      super.setCredentialsProvider(credentialsProvider);
      return this;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
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

    /** Returns the builder for the settings used for calls to createDocument. */
    public UnaryCallSettings.Builder<CreateDocumentRequest, Document> createDocumentSettings() {
      return createDocumentSettings;
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
    public StreamingCallSettings.Builder<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
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
    public StreamingCallSettings.Builder<RunQueryRequest, RunQueryResponse> runQuerySettings() {
      return runQuerySettings;
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

    @Override
    public FirestoreSettings build() throws IOException {
      return new FirestoreSettings(this);
    }
  }
}
