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
package com.google.cloud.firestore.v1beta1.stub;

import static com.google.cloud.firestore.v1beta1.FirestoreClient.ListCollectionIdsPagedResponse;
import static com.google.cloud.firestore.v1beta1.FirestoreClient.ListDocumentsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
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
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Google Cloud Firestore API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcFirestoreStub extends FirestoreStub {

  private static final MethodDescriptor<GetDocumentRequest, Document> getDocumentMethodDescriptor =
      MethodDescriptor.<GetDocumentRequest, Document>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.firestore.v1beta1.Firestore/GetDocument")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDocumentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Document.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ListDocumentsRequest, ListDocumentsResponse>
      listDocumentsMethodDescriptor =
          MethodDescriptor.<ListDocumentsRequest, ListDocumentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.v1beta1.Firestore/ListDocuments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDocumentsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<CreateDocumentRequest, Document>
      createDocumentMethodDescriptor =
          MethodDescriptor.<CreateDocumentRequest, Document>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.v1beta1.Firestore/CreateDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Document.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<UpdateDocumentRequest, Document>
      updateDocumentMethodDescriptor =
          MethodDescriptor.<UpdateDocumentRequest, Document>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.v1beta1.Firestore/UpdateDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Document.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeleteDocumentRequest, Empty>
      deleteDocumentMethodDescriptor =
          MethodDescriptor.<DeleteDocumentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.v1beta1.Firestore/DeleteDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsMethodDescriptor =
          MethodDescriptor.<BatchGetDocumentsRequest, BatchGetDocumentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.firestore.v1beta1.Firestore/BatchGetDocuments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchGetDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchGetDocumentsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionMethodDescriptor =
          MethodDescriptor.<BeginTransactionRequest, BeginTransactionResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.v1beta1.Firestore/BeginTransaction")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BeginTransactionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BeginTransactionResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<CommitRequest, CommitResponse> commitMethodDescriptor =
      MethodDescriptor.<CommitRequest, CommitResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.firestore.v1beta1.Firestore/Commit")
          .setRequestMarshaller(ProtoUtils.marshaller(CommitRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(CommitResponse.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<RollbackRequest, Empty> rollbackMethodDescriptor =
      MethodDescriptor.<RollbackRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.firestore.v1beta1.Firestore/Rollback")
          .setRequestMarshaller(ProtoUtils.marshaller(RollbackRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<RunQueryRequest, RunQueryResponse>
      runQueryMethodDescriptor =
          MethodDescriptor.<RunQueryRequest, RunQueryResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.firestore.v1beta1.Firestore/RunQuery")
              .setRequestMarshaller(ProtoUtils.marshaller(RunQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RunQueryResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<WriteRequest, WriteResponse> writeMethodDescriptor =
      MethodDescriptor.<WriteRequest, WriteResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName("google.firestore.v1beta1.Firestore/Write")
          .setRequestMarshaller(ProtoUtils.marshaller(WriteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(WriteResponse.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ListenRequest, ListenResponse> listenMethodDescriptor =
      MethodDescriptor.<ListenRequest, ListenResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName("google.firestore.v1beta1.Firestore/Listen")
          .setRequestMarshaller(ProtoUtils.marshaller(ListenRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(ListenResponse.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ListCollectionIdsRequest, ListCollectionIdsResponse>
      listCollectionIdsMethodDescriptor =
          MethodDescriptor.<ListCollectionIdsRequest, ListCollectionIdsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.v1beta1.Firestore/ListCollectionIds")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCollectionIdsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCollectionIdsResponse.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<GetDocumentRequest, Document> getDocumentCallable;
  private final UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> listDocumentsCallable;
  private final UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse>
      listDocumentsPagedCallable;
  private final UnaryCallable<CreateDocumentRequest, Document> createDocumentCallable;
  private final UnaryCallable<UpdateDocumentRequest, Document> updateDocumentCallable;
  private final UnaryCallable<DeleteDocumentRequest, Empty> deleteDocumentCallable;
  private final ServerStreamingCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsCallable;
  private final UnaryCallable<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionCallable;
  private final UnaryCallable<CommitRequest, CommitResponse> commitCallable;
  private final UnaryCallable<RollbackRequest, Empty> rollbackCallable;
  private final ServerStreamingCallable<RunQueryRequest, RunQueryResponse> runQueryCallable;
  private final BidiStreamingCallable<WriteRequest, WriteResponse> writeCallable;
  private final BidiStreamingCallable<ListenRequest, ListenResponse> listenCallable;
  private final UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsResponse>
      listCollectionIdsCallable;
  private final UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsPagedResponse>
      listCollectionIdsPagedCallable;

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcFirestoreStub create(FirestoreStubSettings settings) throws IOException {
    return new GrpcFirestoreStub(settings, ClientContext.create(settings));
  }

  public static final GrpcFirestoreStub create(ClientContext clientContext) throws IOException {
    return new GrpcFirestoreStub(FirestoreStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcFirestoreStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcFirestoreStub(
        FirestoreStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcFirestoreStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcFirestoreStub(FirestoreStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcFirestoreCallableFactory());
  }

  /**
   * Constructs an instance of GrpcFirestoreStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcFirestoreStub(
      FirestoreStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    GrpcCallSettings<GetDocumentRequest, Document> getDocumentTransportSettings =
        GrpcCallSettings.<GetDocumentRequest, Document>newBuilder()
            .setMethodDescriptor(getDocumentMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetDocumentRequest>() {
                  @Override
                  public Map<String, String> extract(GetDocumentRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListDocumentsRequest, ListDocumentsResponse> listDocumentsTransportSettings =
        GrpcCallSettings.<ListDocumentsRequest, ListDocumentsResponse>newBuilder()
            .setMethodDescriptor(listDocumentsMethodDescriptor)
            .build();
    GrpcCallSettings<CreateDocumentRequest, Document> createDocumentTransportSettings =
        GrpcCallSettings.<CreateDocumentRequest, Document>newBuilder()
            .setMethodDescriptor(createDocumentMethodDescriptor)
            .build();
    GrpcCallSettings<UpdateDocumentRequest, Document> updateDocumentTransportSettings =
        GrpcCallSettings.<UpdateDocumentRequest, Document>newBuilder()
            .setMethodDescriptor(updateDocumentMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateDocumentRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateDocumentRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("document.name", String.valueOf(request.getDocument().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteDocumentRequest, Empty> deleteDocumentTransportSettings =
        GrpcCallSettings.<DeleteDocumentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDocumentMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteDocumentRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteDocumentRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
        batchGetDocumentsTransportSettings =
            GrpcCallSettings.<BatchGetDocumentsRequest, BatchGetDocumentsResponse>newBuilder()
                .setMethodDescriptor(batchGetDocumentsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<BatchGetDocumentsRequest>() {
                      @Override
                      public Map<String, String> extract(BatchGetDocumentsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("database", String.valueOf(request.getDatabase()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<BeginTransactionRequest, BeginTransactionResponse>
        beginTransactionTransportSettings =
            GrpcCallSettings.<BeginTransactionRequest, BeginTransactionResponse>newBuilder()
                .setMethodDescriptor(beginTransactionMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<BeginTransactionRequest>() {
                      @Override
                      public Map<String, String> extract(BeginTransactionRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("database", String.valueOf(request.getDatabase()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CommitRequest, CommitResponse> commitTransportSettings =
        GrpcCallSettings.<CommitRequest, CommitResponse>newBuilder()
            .setMethodDescriptor(commitMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CommitRequest>() {
                  @Override
                  public Map<String, String> extract(CommitRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("database", String.valueOf(request.getDatabase()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<RollbackRequest, Empty> rollbackTransportSettings =
        GrpcCallSettings.<RollbackRequest, Empty>newBuilder()
            .setMethodDescriptor(rollbackMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<RollbackRequest>() {
                  @Override
                  public Map<String, String> extract(RollbackRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("database", String.valueOf(request.getDatabase()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<RunQueryRequest, RunQueryResponse> runQueryTransportSettings =
        GrpcCallSettings.<RunQueryRequest, RunQueryResponse>newBuilder()
            .setMethodDescriptor(runQueryMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<RunQueryRequest>() {
                  @Override
                  public Map<String, String> extract(RunQueryRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<WriteRequest, WriteResponse> writeTransportSettings =
        GrpcCallSettings.<WriteRequest, WriteResponse>newBuilder()
            .setMethodDescriptor(writeMethodDescriptor)
            .build();
    GrpcCallSettings<ListenRequest, ListenResponse> listenTransportSettings =
        GrpcCallSettings.<ListenRequest, ListenResponse>newBuilder()
            .setMethodDescriptor(listenMethodDescriptor)
            .build();
    GrpcCallSettings<ListCollectionIdsRequest, ListCollectionIdsResponse>
        listCollectionIdsTransportSettings =
            GrpcCallSettings.<ListCollectionIdsRequest, ListCollectionIdsResponse>newBuilder()
                .setMethodDescriptor(listCollectionIdsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListCollectionIdsRequest>() {
                      @Override
                      public Map<String, String> extract(ListCollectionIdsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();

    this.getDocumentCallable =
        callableFactory.createUnaryCallable(
            getDocumentTransportSettings, settings.getDocumentSettings(), clientContext);
    this.listDocumentsCallable =
        callableFactory.createUnaryCallable(
            listDocumentsTransportSettings, settings.listDocumentsSettings(), clientContext);
    this.listDocumentsPagedCallable =
        callableFactory.createPagedCallable(
            listDocumentsTransportSettings, settings.listDocumentsSettings(), clientContext);
    this.createDocumentCallable =
        callableFactory.createUnaryCallable(
            createDocumentTransportSettings, settings.createDocumentSettings(), clientContext);
    this.updateDocumentCallable =
        callableFactory.createUnaryCallable(
            updateDocumentTransportSettings, settings.updateDocumentSettings(), clientContext);
    this.deleteDocumentCallable =
        callableFactory.createUnaryCallable(
            deleteDocumentTransportSettings, settings.deleteDocumentSettings(), clientContext);
    this.batchGetDocumentsCallable =
        callableFactory.createServerStreamingCallable(
            batchGetDocumentsTransportSettings,
            settings.batchGetDocumentsSettings(),
            clientContext);
    this.beginTransactionCallable =
        callableFactory.createUnaryCallable(
            beginTransactionTransportSettings, settings.beginTransactionSettings(), clientContext);
    this.commitCallable =
        callableFactory.createUnaryCallable(
            commitTransportSettings, settings.commitSettings(), clientContext);
    this.rollbackCallable =
        callableFactory.createUnaryCallable(
            rollbackTransportSettings, settings.rollbackSettings(), clientContext);
    this.runQueryCallable =
        callableFactory.createServerStreamingCallable(
            runQueryTransportSettings, settings.runQuerySettings(), clientContext);
    this.writeCallable =
        callableFactory.createBidiStreamingCallable(
            writeTransportSettings, settings.writeSettings(), clientContext);
    this.listenCallable =
        callableFactory.createBidiStreamingCallable(
            listenTransportSettings, settings.listenSettings(), clientContext);
    this.listCollectionIdsCallable =
        callableFactory.createUnaryCallable(
            listCollectionIdsTransportSettings,
            settings.listCollectionIdsSettings(),
            clientContext);
    this.listCollectionIdsPagedCallable =
        callableFactory.createPagedCallable(
            listCollectionIdsTransportSettings,
            settings.listCollectionIdsSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<GetDocumentRequest, Document> getDocumentCallable() {
    return getDocumentCallable;
  }

  public UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse>
      listDocumentsPagedCallable() {
    return listDocumentsPagedCallable;
  }

  public UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> listDocumentsCallable() {
    return listDocumentsCallable;
  }

  public UnaryCallable<CreateDocumentRequest, Document> createDocumentCallable() {
    return createDocumentCallable;
  }

  public UnaryCallable<UpdateDocumentRequest, Document> updateDocumentCallable() {
    return updateDocumentCallable;
  }

  public UnaryCallable<DeleteDocumentRequest, Empty> deleteDocumentCallable() {
    return deleteDocumentCallable;
  }

  public ServerStreamingCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsCallable() {
    return batchGetDocumentsCallable;
  }

  public UnaryCallable<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionCallable() {
    return beginTransactionCallable;
  }

  public UnaryCallable<CommitRequest, CommitResponse> commitCallable() {
    return commitCallable;
  }

  public UnaryCallable<RollbackRequest, Empty> rollbackCallable() {
    return rollbackCallable;
  }

  public ServerStreamingCallable<RunQueryRequest, RunQueryResponse> runQueryCallable() {
    return runQueryCallable;
  }

  public BidiStreamingCallable<WriteRequest, WriteResponse> writeCallable() {
    return writeCallable;
  }

  public BidiStreamingCallable<ListenRequest, ListenResponse> listenCallable() {
    return listenCallable;
  }

  public UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsPagedResponse>
      listCollectionIdsPagedCallable() {
    return listCollectionIdsPagedCallable;
  }

  public UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsResponse>
      listCollectionIdsCallable() {
    return listCollectionIdsCallable;
  }

  @Override
  public final void close() {
    shutdown();
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
