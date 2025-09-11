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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Firestore service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcFirestoreStub extends FirestoreStub {
  private static final MethodDescriptor<GetDocumentRequest, Document> getDocumentMethodDescriptor =
      MethodDescriptor.<GetDocumentRequest, Document>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.firestore.v1.Firestore/GetDocument")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDocumentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Document.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListDocumentsRequest, ListDocumentsResponse>
      listDocumentsMethodDescriptor =
          MethodDescriptor.<ListDocumentsRequest, ListDocumentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.v1.Firestore/ListDocuments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDocumentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateDocumentRequest, Document>
      updateDocumentMethodDescriptor =
          MethodDescriptor.<UpdateDocumentRequest, Document>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.v1.Firestore/UpdateDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Document.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteDocumentRequest, Empty>
      deleteDocumentMethodDescriptor =
          MethodDescriptor.<DeleteDocumentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.v1.Firestore/DeleteDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsMethodDescriptor =
          MethodDescriptor.<BatchGetDocumentsRequest, BatchGetDocumentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.firestore.v1.Firestore/BatchGetDocuments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchGetDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchGetDocumentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionMethodDescriptor =
          MethodDescriptor.<BeginTransactionRequest, BeginTransactionResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.v1.Firestore/BeginTransaction")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BeginTransactionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BeginTransactionResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CommitRequest, CommitResponse> commitMethodDescriptor =
      MethodDescriptor.<CommitRequest, CommitResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.firestore.v1.Firestore/Commit")
          .setRequestMarshaller(ProtoUtils.marshaller(CommitRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(CommitResponse.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<RollbackRequest, Empty> rollbackMethodDescriptor =
      MethodDescriptor.<RollbackRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.firestore.v1.Firestore/Rollback")
          .setRequestMarshaller(ProtoUtils.marshaller(RollbackRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<RunQueryRequest, RunQueryResponse>
      runQueryMethodDescriptor =
          MethodDescriptor.<RunQueryRequest, RunQueryResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.firestore.v1.Firestore/RunQuery")
              .setRequestMarshaller(ProtoUtils.marshaller(RunQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RunQueryResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RunAggregationQueryRequest, RunAggregationQueryResponse>
      runAggregationQueryMethodDescriptor =
          MethodDescriptor.<RunAggregationQueryRequest, RunAggregationQueryResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.firestore.v1.Firestore/RunAggregationQuery")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RunAggregationQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RunAggregationQueryResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<PartitionQueryRequest, PartitionQueryResponse>
      partitionQueryMethodDescriptor =
          MethodDescriptor.<PartitionQueryRequest, PartitionQueryResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.v1.Firestore/PartitionQuery")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PartitionQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(PartitionQueryResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<WriteRequest, WriteResponse> writeMethodDescriptor =
      MethodDescriptor.<WriteRequest, WriteResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName("google.firestore.v1.Firestore/Write")
          .setRequestMarshaller(ProtoUtils.marshaller(WriteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(WriteResponse.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListenRequest, ListenResponse> listenMethodDescriptor =
      MethodDescriptor.<ListenRequest, ListenResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName("google.firestore.v1.Firestore/Listen")
          .setRequestMarshaller(ProtoUtils.marshaller(ListenRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(ListenResponse.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListCollectionIdsRequest, ListCollectionIdsResponse>
      listCollectionIdsMethodDescriptor =
          MethodDescriptor.<ListCollectionIdsRequest, ListCollectionIdsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.v1.Firestore/ListCollectionIds")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCollectionIdsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCollectionIdsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BatchWriteRequest, BatchWriteResponse>
      batchWriteMethodDescriptor =
          MethodDescriptor.<BatchWriteRequest, BatchWriteResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.v1.Firestore/BatchWrite")
              .setRequestMarshaller(ProtoUtils.marshaller(BatchWriteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BatchWriteResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateDocumentRequest, Document>
      createDocumentMethodDescriptor =
          MethodDescriptor.<CreateDocumentRequest, Document>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.v1.Firestore/CreateDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Document.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetDocumentRequest, Document> getDocumentCallable;
  private final UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> listDocumentsCallable;
  private final UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse>
      listDocumentsPagedCallable;
  private final UnaryCallable<UpdateDocumentRequest, Document> updateDocumentCallable;
  private final UnaryCallable<DeleteDocumentRequest, Empty> deleteDocumentCallable;
  private final ServerStreamingCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsCallable;
  private final UnaryCallable<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionCallable;
  private final UnaryCallable<CommitRequest, CommitResponse> commitCallable;
  private final UnaryCallable<RollbackRequest, Empty> rollbackCallable;
  private final ServerStreamingCallable<RunQueryRequest, RunQueryResponse> runQueryCallable;
  private final ServerStreamingCallable<RunAggregationQueryRequest, RunAggregationQueryResponse>
      runAggregationQueryCallable;
  private final UnaryCallable<PartitionQueryRequest, PartitionQueryResponse> partitionQueryCallable;
  private final UnaryCallable<PartitionQueryRequest, PartitionQueryPagedResponse>
      partitionQueryPagedCallable;
  private final BidiStreamingCallable<WriteRequest, WriteResponse> writeCallable;
  private final BidiStreamingCallable<ListenRequest, ListenResponse> listenCallable;
  private final UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsResponse>
      listCollectionIdsCallable;
  private final UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsPagedResponse>
      listCollectionIdsPagedCallable;
  private final UnaryCallable<BatchWriteRequest, BatchWriteResponse> batchWriteCallable;
  private final UnaryCallable<CreateDocumentRequest, Document> createDocumentCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
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
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetDocumentRequest, Document> getDocumentTransportSettings =
        GrpcCallSettings.<GetDocumentRequest, Document>newBuilder()
            .setMethodDescriptor(getDocumentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDocumentsRequest, ListDocumentsResponse> listDocumentsTransportSettings =
        GrpcCallSettings.<ListDocumentsRequest, ListDocumentsResponse>newBuilder()
            .setMethodDescriptor(listDocumentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("collection_id", String.valueOf(request.getCollectionId()));
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDocumentRequest, Document> updateDocumentTransportSettings =
        GrpcCallSettings.<UpdateDocumentRequest, Document>newBuilder()
            .setMethodDescriptor(updateDocumentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("document.name", String.valueOf(request.getDocument().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDocumentRequest, Empty> deleteDocumentTransportSettings =
        GrpcCallSettings.<DeleteDocumentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDocumentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
        batchGetDocumentsTransportSettings =
            GrpcCallSettings.<BatchGetDocumentsRequest, BatchGetDocumentsResponse>newBuilder()
                .setMethodDescriptor(batchGetDocumentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("database", String.valueOf(request.getDatabase()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<BeginTransactionRequest, BeginTransactionResponse>
        beginTransactionTransportSettings =
            GrpcCallSettings.<BeginTransactionRequest, BeginTransactionResponse>newBuilder()
                .setMethodDescriptor(beginTransactionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("database", String.valueOf(request.getDatabase()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CommitRequest, CommitResponse> commitTransportSettings =
        GrpcCallSettings.<CommitRequest, CommitResponse>newBuilder()
            .setMethodDescriptor(commitMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RollbackRequest, Empty> rollbackTransportSettings =
        GrpcCallSettings.<RollbackRequest, Empty>newBuilder()
            .setMethodDescriptor(rollbackMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RunQueryRequest, RunQueryResponse> runQueryTransportSettings =
        GrpcCallSettings.<RunQueryRequest, RunQueryResponse>newBuilder()
            .setMethodDescriptor(runQueryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RunAggregationQueryRequest, RunAggregationQueryResponse>
        runAggregationQueryTransportSettings =
            GrpcCallSettings.<RunAggregationQueryRequest, RunAggregationQueryResponse>newBuilder()
                .setMethodDescriptor(runAggregationQueryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<PartitionQueryRequest, PartitionQueryResponse>
        partitionQueryTransportSettings =
            GrpcCallSettings.<PartitionQueryRequest, PartitionQueryResponse>newBuilder()
                .setMethodDescriptor(partitionQueryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<WriteRequest, WriteResponse> writeTransportSettings =
        GrpcCallSettings.<WriteRequest, WriteResponse>newBuilder()
            .setMethodDescriptor(writeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListenRequest, ListenResponse> listenTransportSettings =
        GrpcCallSettings.<ListenRequest, ListenResponse>newBuilder()
            .setMethodDescriptor(listenMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListCollectionIdsRequest, ListCollectionIdsResponse>
        listCollectionIdsTransportSettings =
            GrpcCallSettings.<ListCollectionIdsRequest, ListCollectionIdsResponse>newBuilder()
                .setMethodDescriptor(listCollectionIdsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<BatchWriteRequest, BatchWriteResponse> batchWriteTransportSettings =
        GrpcCallSettings.<BatchWriteRequest, BatchWriteResponse>newBuilder()
            .setMethodDescriptor(batchWriteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDocumentRequest, Document> createDocumentTransportSettings =
        GrpcCallSettings.<CreateDocumentRequest, Document>newBuilder()
            .setMethodDescriptor(createDocumentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("collection_id", String.valueOf(request.getCollectionId()));
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
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
    this.runAggregationQueryCallable =
        callableFactory.createServerStreamingCallable(
            runAggregationQueryTransportSettings,
            settings.runAggregationQuerySettings(),
            clientContext);
    this.partitionQueryCallable =
        callableFactory.createUnaryCallable(
            partitionQueryTransportSettings, settings.partitionQuerySettings(), clientContext);
    this.partitionQueryPagedCallable =
        callableFactory.createPagedCallable(
            partitionQueryTransportSettings, settings.partitionQuerySettings(), clientContext);
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
    this.batchWriteCallable =
        callableFactory.createUnaryCallable(
            batchWriteTransportSettings, settings.batchWriteSettings(), clientContext);
    this.createDocumentCallable =
        callableFactory.createUnaryCallable(
            createDocumentTransportSettings, settings.createDocumentSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetDocumentRequest, Document> getDocumentCallable() {
    return getDocumentCallable;
  }

  @Override
  public UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> listDocumentsCallable() {
    return listDocumentsCallable;
  }

  @Override
  public UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse>
      listDocumentsPagedCallable() {
    return listDocumentsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateDocumentRequest, Document> updateDocumentCallable() {
    return updateDocumentCallable;
  }

  @Override
  public UnaryCallable<DeleteDocumentRequest, Empty> deleteDocumentCallable() {
    return deleteDocumentCallable;
  }

  @Override
  public ServerStreamingCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsCallable() {
    return batchGetDocumentsCallable;
  }

  @Override
  public UnaryCallable<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionCallable() {
    return beginTransactionCallable;
  }

  @Override
  public UnaryCallable<CommitRequest, CommitResponse> commitCallable() {
    return commitCallable;
  }

  @Override
  public UnaryCallable<RollbackRequest, Empty> rollbackCallable() {
    return rollbackCallable;
  }

  @Override
  public ServerStreamingCallable<RunQueryRequest, RunQueryResponse> runQueryCallable() {
    return runQueryCallable;
  }

  @Override
  public ServerStreamingCallable<RunAggregationQueryRequest, RunAggregationQueryResponse>
      runAggregationQueryCallable() {
    return runAggregationQueryCallable;
  }

  @Override
  public UnaryCallable<PartitionQueryRequest, PartitionQueryResponse> partitionQueryCallable() {
    return partitionQueryCallable;
  }

  @Override
  public UnaryCallable<PartitionQueryRequest, PartitionQueryPagedResponse>
      partitionQueryPagedCallable() {
    return partitionQueryPagedCallable;
  }

  @Override
  public BidiStreamingCallable<WriteRequest, WriteResponse> writeCallable() {
    return writeCallable;
  }

  @Override
  public BidiStreamingCallable<ListenRequest, ListenResponse> listenCallable() {
    return listenCallable;
  }

  @Override
  public UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsResponse>
      listCollectionIdsCallable() {
    return listCollectionIdsCallable;
  }

  @Override
  public UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsPagedResponse>
      listCollectionIdsPagedCallable() {
    return listCollectionIdsPagedCallable;
  }

  @Override
  public UnaryCallable<BatchWriteRequest, BatchWriteResponse> batchWriteCallable() {
    return batchWriteCallable;
  }

  @Override
  public UnaryCallable<CreateDocumentRequest, Document> createDocumentCallable() {
    return createDocumentCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
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
