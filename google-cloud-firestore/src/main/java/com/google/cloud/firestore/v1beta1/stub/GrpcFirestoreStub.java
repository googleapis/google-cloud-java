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
package com.google.cloud.firestore.v1beta1.stub;

import static com.google.cloud.firestore.v1beta1.PagedResponseWrappers.ListCollectionIdsPagedResponse;
import static com.google.cloud.firestore.v1beta1.PagedResponseWrappers.ListDocumentsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.firestore.v1beta1.FirestoreSettings;
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
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Google Cloud Firestore API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class GrpcFirestoreStub extends FirestoreStub {
  private static final UnaryCallable<GetDocumentRequest, Document> directGetDocumentCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.firestore.v1beta1.Firestore/GetDocument",
              io.grpc.protobuf.ProtoUtils.marshaller(GetDocumentRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Document.getDefaultInstance())));
  private static final UnaryCallable<ListDocumentsRequest, ListDocumentsResponse>
      directListDocumentsCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.firestore.v1beta1.Firestore/ListDocuments",
                  io.grpc.protobuf.ProtoUtils.marshaller(ListDocumentsRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListDocumentsResponse.getDefaultInstance())));
  private static final UnaryCallable<CreateDocumentRequest, Document> directCreateDocumentCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.firestore.v1beta1.Firestore/CreateDocument",
              io.grpc.protobuf.ProtoUtils.marshaller(CreateDocumentRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Document.getDefaultInstance())));
  private static final UnaryCallable<UpdateDocumentRequest, Document> directUpdateDocumentCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.firestore.v1beta1.Firestore/UpdateDocument",
              io.grpc.protobuf.ProtoUtils.marshaller(UpdateDocumentRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Document.getDefaultInstance())));
  private static final UnaryCallable<DeleteDocumentRequest, Empty> directDeleteDocumentCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.firestore.v1beta1.Firestore/DeleteDocument",
              io.grpc.protobuf.ProtoUtils.marshaller(DeleteDocumentRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Empty.getDefaultInstance())));
  private static final ServerStreamingCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      directBatchGetDocumentsCallable =
          GrpcCallableFactory.createDirectServerStreamingCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
                  "google.firestore.v1beta1.Firestore/BatchGetDocuments",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      BatchGetDocumentsRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      BatchGetDocumentsResponse.getDefaultInstance())));
  private static final UnaryCallable<BeginTransactionRequest, BeginTransactionResponse>
      directBeginTransactionCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.firestore.v1beta1.Firestore/BeginTransaction",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      BeginTransactionRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      BeginTransactionResponse.getDefaultInstance())));
  private static final UnaryCallable<CommitRequest, CommitResponse> directCommitCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.firestore.v1beta1.Firestore/Commit",
              io.grpc.protobuf.ProtoUtils.marshaller(CommitRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(CommitResponse.getDefaultInstance())));
  private static final UnaryCallable<RollbackRequest, Empty> directRollbackCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.firestore.v1beta1.Firestore/Rollback",
              io.grpc.protobuf.ProtoUtils.marshaller(RollbackRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Empty.getDefaultInstance())));
  private static final ServerStreamingCallable<RunQueryRequest, RunQueryResponse>
      directRunQueryCallable =
          GrpcCallableFactory.createDirectServerStreamingCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
                  "google.firestore.v1beta1.Firestore/RunQuery",
                  io.grpc.protobuf.ProtoUtils.marshaller(RunQueryRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(RunQueryResponse.getDefaultInstance())));
  private static final BidiStreamingCallable<WriteRequest, WriteResponse> directWriteCallable =
      GrpcCallableFactory.createDirectBidiStreamingCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
              "google.firestore.v1beta1.Firestore/Write",
              io.grpc.protobuf.ProtoUtils.marshaller(WriteRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(WriteResponse.getDefaultInstance())));
  private static final BidiStreamingCallable<ListenRequest, ListenResponse> directListenCallable =
      GrpcCallableFactory.createDirectBidiStreamingCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
              "google.firestore.v1beta1.Firestore/Listen",
              io.grpc.protobuf.ProtoUtils.marshaller(ListenRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(ListenResponse.getDefaultInstance())));
  private static final UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsResponse>
      directListCollectionIdsCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.firestore.v1beta1.Firestore/ListCollectionIds",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListCollectionIdsRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListCollectionIdsResponse.getDefaultInstance())));

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

  public static final GrpcFirestoreStub create(FirestoreSettings settings) throws IOException {
    return new GrpcFirestoreStub(settings, ClientContext.create(settings));
  }

  public static final GrpcFirestoreStub create(ClientContext clientContext) throws IOException {
    return new GrpcFirestoreStub(FirestoreSettings.newBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcFirestoreStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcFirestoreStub(FirestoreSettings settings, ClientContext clientContext)
      throws IOException {

    this.getDocumentCallable =
        GrpcCallableFactory.create(
            directGetDocumentCallable, settings.getDocumentSettings(), clientContext);
    this.listDocumentsCallable =
        GrpcCallableFactory.create(
            directListDocumentsCallable, settings.listDocumentsSettings(), clientContext);
    this.listDocumentsPagedCallable =
        GrpcCallableFactory.createPagedVariant(
            directListDocumentsCallable, settings.listDocumentsSettings(), clientContext);
    this.createDocumentCallable =
        GrpcCallableFactory.create(
            directCreateDocumentCallable, settings.createDocumentSettings(), clientContext);
    this.updateDocumentCallable =
        GrpcCallableFactory.create(
            directUpdateDocumentCallable, settings.updateDocumentSettings(), clientContext);
    this.deleteDocumentCallable =
        GrpcCallableFactory.create(
            directDeleteDocumentCallable, settings.deleteDocumentSettings(), clientContext);
    this.batchGetDocumentsCallable =
        GrpcCallableFactory.create(
            directBatchGetDocumentsCallable, settings.batchGetDocumentsSettings(), clientContext);
    this.beginTransactionCallable =
        GrpcCallableFactory.create(
            directBeginTransactionCallable, settings.beginTransactionSettings(), clientContext);
    this.commitCallable =
        GrpcCallableFactory.create(directCommitCallable, settings.commitSettings(), clientContext);
    this.rollbackCallable =
        GrpcCallableFactory.create(
            directRollbackCallable, settings.rollbackSettings(), clientContext);
    this.runQueryCallable =
        GrpcCallableFactory.create(
            directRunQueryCallable, settings.runQuerySettings(), clientContext);
    this.writeCallable =
        GrpcCallableFactory.create(directWriteCallable, settings.writeSettings(), clientContext);
    this.listenCallable =
        GrpcCallableFactory.create(directListenCallable, settings.listenSettings(), clientContext);
    this.listCollectionIdsCallable =
        GrpcCallableFactory.create(
            directListCollectionIdsCallable, settings.listCollectionIdsSettings(), clientContext);
    this.listCollectionIdsPagedCallable =
        GrpcCallableFactory.createPagedVariant(
            directListCollectionIdsCallable, settings.listCollectionIdsSettings(), clientContext);

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
  public final void close() throws Exception {
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
