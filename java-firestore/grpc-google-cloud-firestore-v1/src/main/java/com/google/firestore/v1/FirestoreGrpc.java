/*
 * Copyright 2025 Google LLC
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
package com.google.firestore.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Cloud Firestore service.
 * Cloud Firestore is a fast, fully managed, serverless, cloud-native NoSQL
 * document database that simplifies storing, syncing, and querying data for
 * your mobile, web, and IoT apps at global scale. Its client libraries provide
 * live synchronization and offline support, while its security features and
 * integrations with Firebase and Google Cloud Platform accelerate building
 * truly serverless apps.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class FirestoreGrpc {

  private FirestoreGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.firestore.v1.Firestore";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.GetDocumentRequest, com.google.firestore.v1.Document>
      getGetDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDocument",
      requestType = com.google.firestore.v1.GetDocumentRequest.class,
      responseType = com.google.firestore.v1.Document.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.GetDocumentRequest, com.google.firestore.v1.Document>
      getGetDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.v1.GetDocumentRequest, com.google.firestore.v1.Document>
        getGetDocumentMethod;
    if ((getGetDocumentMethod = FirestoreGrpc.getGetDocumentMethod) == null) {
      synchronized (FirestoreGrpc.class) {
        if ((getGetDocumentMethod = FirestoreGrpc.getGetDocumentMethod) == null) {
          FirestoreGrpc.getGetDocumentMethod =
              getGetDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.v1.GetDocumentRequest,
                          com.google.firestore.v1.Document>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.GetDocumentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.Document.getDefaultInstance()))
                      .setSchemaDescriptor(new FirestoreMethodDescriptorSupplier("GetDocument"))
                      .build();
        }
      }
    }
    return getGetDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.ListDocumentsRequest,
          com.google.firestore.v1.ListDocumentsResponse>
      getListDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDocuments",
      requestType = com.google.firestore.v1.ListDocumentsRequest.class,
      responseType = com.google.firestore.v1.ListDocumentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.ListDocumentsRequest,
          com.google.firestore.v1.ListDocumentsResponse>
      getListDocumentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.v1.ListDocumentsRequest,
            com.google.firestore.v1.ListDocumentsResponse>
        getListDocumentsMethod;
    if ((getListDocumentsMethod = FirestoreGrpc.getListDocumentsMethod) == null) {
      synchronized (FirestoreGrpc.class) {
        if ((getListDocumentsMethod = FirestoreGrpc.getListDocumentsMethod) == null) {
          FirestoreGrpc.getListDocumentsMethod =
              getListDocumentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.v1.ListDocumentsRequest,
                          com.google.firestore.v1.ListDocumentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDocuments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.ListDocumentsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.ListDocumentsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new FirestoreMethodDescriptorSupplier("ListDocuments"))
                      .build();
        }
      }
    }
    return getListDocumentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.UpdateDocumentRequest, com.google.firestore.v1.Document>
      getUpdateDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDocument",
      requestType = com.google.firestore.v1.UpdateDocumentRequest.class,
      responseType = com.google.firestore.v1.Document.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.UpdateDocumentRequest, com.google.firestore.v1.Document>
      getUpdateDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.v1.UpdateDocumentRequest, com.google.firestore.v1.Document>
        getUpdateDocumentMethod;
    if ((getUpdateDocumentMethod = FirestoreGrpc.getUpdateDocumentMethod) == null) {
      synchronized (FirestoreGrpc.class) {
        if ((getUpdateDocumentMethod = FirestoreGrpc.getUpdateDocumentMethod) == null) {
          FirestoreGrpc.getUpdateDocumentMethod =
              getUpdateDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.v1.UpdateDocumentRequest,
                          com.google.firestore.v1.Document>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.UpdateDocumentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.Document.getDefaultInstance()))
                      .setSchemaDescriptor(new FirestoreMethodDescriptorSupplier("UpdateDocument"))
                      .build();
        }
      }
    }
    return getUpdateDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.DeleteDocumentRequest, com.google.protobuf.Empty>
      getDeleteDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDocument",
      requestType = com.google.firestore.v1.DeleteDocumentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.DeleteDocumentRequest, com.google.protobuf.Empty>
      getDeleteDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.v1.DeleteDocumentRequest, com.google.protobuf.Empty>
        getDeleteDocumentMethod;
    if ((getDeleteDocumentMethod = FirestoreGrpc.getDeleteDocumentMethod) == null) {
      synchronized (FirestoreGrpc.class) {
        if ((getDeleteDocumentMethod = FirestoreGrpc.getDeleteDocumentMethod) == null) {
          FirestoreGrpc.getDeleteDocumentMethod =
              getDeleteDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.v1.DeleteDocumentRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.DeleteDocumentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new FirestoreMethodDescriptorSupplier("DeleteDocument"))
                      .build();
        }
      }
    }
    return getDeleteDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.BatchGetDocumentsRequest,
          com.google.firestore.v1.BatchGetDocumentsResponse>
      getBatchGetDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchGetDocuments",
      requestType = com.google.firestore.v1.BatchGetDocumentsRequest.class,
      responseType = com.google.firestore.v1.BatchGetDocumentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.BatchGetDocumentsRequest,
          com.google.firestore.v1.BatchGetDocumentsResponse>
      getBatchGetDocumentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.v1.BatchGetDocumentsRequest,
            com.google.firestore.v1.BatchGetDocumentsResponse>
        getBatchGetDocumentsMethod;
    if ((getBatchGetDocumentsMethod = FirestoreGrpc.getBatchGetDocumentsMethod) == null) {
      synchronized (FirestoreGrpc.class) {
        if ((getBatchGetDocumentsMethod = FirestoreGrpc.getBatchGetDocumentsMethod) == null) {
          FirestoreGrpc.getBatchGetDocumentsMethod =
              getBatchGetDocumentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.v1.BatchGetDocumentsRequest,
                          com.google.firestore.v1.BatchGetDocumentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchGetDocuments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.BatchGetDocumentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.BatchGetDocumentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreMethodDescriptorSupplier("BatchGetDocuments"))
                      .build();
        }
      }
    }
    return getBatchGetDocumentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.BeginTransactionRequest,
          com.google.firestore.v1.BeginTransactionResponse>
      getBeginTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BeginTransaction",
      requestType = com.google.firestore.v1.BeginTransactionRequest.class,
      responseType = com.google.firestore.v1.BeginTransactionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.BeginTransactionRequest,
          com.google.firestore.v1.BeginTransactionResponse>
      getBeginTransactionMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.v1.BeginTransactionRequest,
            com.google.firestore.v1.BeginTransactionResponse>
        getBeginTransactionMethod;
    if ((getBeginTransactionMethod = FirestoreGrpc.getBeginTransactionMethod) == null) {
      synchronized (FirestoreGrpc.class) {
        if ((getBeginTransactionMethod = FirestoreGrpc.getBeginTransactionMethod) == null) {
          FirestoreGrpc.getBeginTransactionMethod =
              getBeginTransactionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.v1.BeginTransactionRequest,
                          com.google.firestore.v1.BeginTransactionResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BeginTransaction"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.BeginTransactionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.BeginTransactionResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreMethodDescriptorSupplier("BeginTransaction"))
                      .build();
        }
      }
    }
    return getBeginTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.CommitRequest, com.google.firestore.v1.CommitResponse>
      getCommitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Commit",
      requestType = com.google.firestore.v1.CommitRequest.class,
      responseType = com.google.firestore.v1.CommitResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.CommitRequest, com.google.firestore.v1.CommitResponse>
      getCommitMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.v1.CommitRequest, com.google.firestore.v1.CommitResponse>
        getCommitMethod;
    if ((getCommitMethod = FirestoreGrpc.getCommitMethod) == null) {
      synchronized (FirestoreGrpc.class) {
        if ((getCommitMethod = FirestoreGrpc.getCommitMethod) == null) {
          FirestoreGrpc.getCommitMethod =
              getCommitMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.v1.CommitRequest,
                          com.google.firestore.v1.CommitResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Commit"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.CommitRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.CommitResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new FirestoreMethodDescriptorSupplier("Commit"))
                      .build();
        }
      }
    }
    return getCommitMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.RollbackRequest, com.google.protobuf.Empty>
      getRollbackMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Rollback",
      requestType = com.google.firestore.v1.RollbackRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.RollbackRequest, com.google.protobuf.Empty>
      getRollbackMethod() {
    io.grpc.MethodDescriptor<com.google.firestore.v1.RollbackRequest, com.google.protobuf.Empty>
        getRollbackMethod;
    if ((getRollbackMethod = FirestoreGrpc.getRollbackMethod) == null) {
      synchronized (FirestoreGrpc.class) {
        if ((getRollbackMethod = FirestoreGrpc.getRollbackMethod) == null) {
          FirestoreGrpc.getRollbackMethod =
              getRollbackMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.v1.RollbackRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Rollback"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.RollbackRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new FirestoreMethodDescriptorSupplier("Rollback"))
                      .build();
        }
      }
    }
    return getRollbackMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.RunQueryRequest, com.google.firestore.v1.RunQueryResponse>
      getRunQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunQuery",
      requestType = com.google.firestore.v1.RunQueryRequest.class,
      responseType = com.google.firestore.v1.RunQueryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.RunQueryRequest, com.google.firestore.v1.RunQueryResponse>
      getRunQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.v1.RunQueryRequest, com.google.firestore.v1.RunQueryResponse>
        getRunQueryMethod;
    if ((getRunQueryMethod = FirestoreGrpc.getRunQueryMethod) == null) {
      synchronized (FirestoreGrpc.class) {
        if ((getRunQueryMethod = FirestoreGrpc.getRunQueryMethod) == null) {
          FirestoreGrpc.getRunQueryMethod =
              getRunQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.v1.RunQueryRequest,
                          com.google.firestore.v1.RunQueryResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.RunQueryRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.RunQueryResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new FirestoreMethodDescriptorSupplier("RunQuery"))
                      .build();
        }
      }
    }
    return getRunQueryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.RunAggregationQueryRequest,
          com.google.firestore.v1.RunAggregationQueryResponse>
      getRunAggregationQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunAggregationQuery",
      requestType = com.google.firestore.v1.RunAggregationQueryRequest.class,
      responseType = com.google.firestore.v1.RunAggregationQueryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.RunAggregationQueryRequest,
          com.google.firestore.v1.RunAggregationQueryResponse>
      getRunAggregationQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.v1.RunAggregationQueryRequest,
            com.google.firestore.v1.RunAggregationQueryResponse>
        getRunAggregationQueryMethod;
    if ((getRunAggregationQueryMethod = FirestoreGrpc.getRunAggregationQueryMethod) == null) {
      synchronized (FirestoreGrpc.class) {
        if ((getRunAggregationQueryMethod = FirestoreGrpc.getRunAggregationQueryMethod) == null) {
          FirestoreGrpc.getRunAggregationQueryMethod =
              getRunAggregationQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.v1.RunAggregationQueryRequest,
                          com.google.firestore.v1.RunAggregationQueryResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RunAggregationQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.RunAggregationQueryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.RunAggregationQueryResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreMethodDescriptorSupplier("RunAggregationQuery"))
                      .build();
        }
      }
    }
    return getRunAggregationQueryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.PartitionQueryRequest,
          com.google.firestore.v1.PartitionQueryResponse>
      getPartitionQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PartitionQuery",
      requestType = com.google.firestore.v1.PartitionQueryRequest.class,
      responseType = com.google.firestore.v1.PartitionQueryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.PartitionQueryRequest,
          com.google.firestore.v1.PartitionQueryResponse>
      getPartitionQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.v1.PartitionQueryRequest,
            com.google.firestore.v1.PartitionQueryResponse>
        getPartitionQueryMethod;
    if ((getPartitionQueryMethod = FirestoreGrpc.getPartitionQueryMethod) == null) {
      synchronized (FirestoreGrpc.class) {
        if ((getPartitionQueryMethod = FirestoreGrpc.getPartitionQueryMethod) == null) {
          FirestoreGrpc.getPartitionQueryMethod =
              getPartitionQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.v1.PartitionQueryRequest,
                          com.google.firestore.v1.PartitionQueryResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PartitionQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.PartitionQueryRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.PartitionQueryResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new FirestoreMethodDescriptorSupplier("PartitionQuery"))
                      .build();
        }
      }
    }
    return getPartitionQueryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.WriteRequest, com.google.firestore.v1.WriteResponse>
      getWriteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Write",
      requestType = com.google.firestore.v1.WriteRequest.class,
      responseType = com.google.firestore.v1.WriteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.WriteRequest, com.google.firestore.v1.WriteResponse>
      getWriteMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.v1.WriteRequest, com.google.firestore.v1.WriteResponse>
        getWriteMethod;
    if ((getWriteMethod = FirestoreGrpc.getWriteMethod) == null) {
      synchronized (FirestoreGrpc.class) {
        if ((getWriteMethod = FirestoreGrpc.getWriteMethod) == null) {
          FirestoreGrpc.getWriteMethod =
              getWriteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.v1.WriteRequest, com.google.firestore.v1.WriteResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Write"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.WriteRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.WriteResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new FirestoreMethodDescriptorSupplier("Write"))
                      .build();
        }
      }
    }
    return getWriteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.ListenRequest, com.google.firestore.v1.ListenResponse>
      getListenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Listen",
      requestType = com.google.firestore.v1.ListenRequest.class,
      responseType = com.google.firestore.v1.ListenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.ListenRequest, com.google.firestore.v1.ListenResponse>
      getListenMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.v1.ListenRequest, com.google.firestore.v1.ListenResponse>
        getListenMethod;
    if ((getListenMethod = FirestoreGrpc.getListenMethod) == null) {
      synchronized (FirestoreGrpc.class) {
        if ((getListenMethod = FirestoreGrpc.getListenMethod) == null) {
          FirestoreGrpc.getListenMethod =
              getListenMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.v1.ListenRequest,
                          com.google.firestore.v1.ListenResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Listen"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.ListenRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.ListenResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new FirestoreMethodDescriptorSupplier("Listen"))
                      .build();
        }
      }
    }
    return getListenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.ListCollectionIdsRequest,
          com.google.firestore.v1.ListCollectionIdsResponse>
      getListCollectionIdsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCollectionIds",
      requestType = com.google.firestore.v1.ListCollectionIdsRequest.class,
      responseType = com.google.firestore.v1.ListCollectionIdsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.ListCollectionIdsRequest,
          com.google.firestore.v1.ListCollectionIdsResponse>
      getListCollectionIdsMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.v1.ListCollectionIdsRequest,
            com.google.firestore.v1.ListCollectionIdsResponse>
        getListCollectionIdsMethod;
    if ((getListCollectionIdsMethod = FirestoreGrpc.getListCollectionIdsMethod) == null) {
      synchronized (FirestoreGrpc.class) {
        if ((getListCollectionIdsMethod = FirestoreGrpc.getListCollectionIdsMethod) == null) {
          FirestoreGrpc.getListCollectionIdsMethod =
              getListCollectionIdsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.v1.ListCollectionIdsRequest,
                          com.google.firestore.v1.ListCollectionIdsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCollectionIds"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.ListCollectionIdsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.ListCollectionIdsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreMethodDescriptorSupplier("ListCollectionIds"))
                      .build();
        }
      }
    }
    return getListCollectionIdsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.BatchWriteRequest, com.google.firestore.v1.BatchWriteResponse>
      getBatchWriteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchWrite",
      requestType = com.google.firestore.v1.BatchWriteRequest.class,
      responseType = com.google.firestore.v1.BatchWriteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.BatchWriteRequest, com.google.firestore.v1.BatchWriteResponse>
      getBatchWriteMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.v1.BatchWriteRequest, com.google.firestore.v1.BatchWriteResponse>
        getBatchWriteMethod;
    if ((getBatchWriteMethod = FirestoreGrpc.getBatchWriteMethod) == null) {
      synchronized (FirestoreGrpc.class) {
        if ((getBatchWriteMethod = FirestoreGrpc.getBatchWriteMethod) == null) {
          FirestoreGrpc.getBatchWriteMethod =
              getBatchWriteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.v1.BatchWriteRequest,
                          com.google.firestore.v1.BatchWriteResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchWrite"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.BatchWriteRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.BatchWriteResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new FirestoreMethodDescriptorSupplier("BatchWrite"))
                      .build();
        }
      }
    }
    return getBatchWriteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.CreateDocumentRequest, com.google.firestore.v1.Document>
      getCreateDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDocument",
      requestType = com.google.firestore.v1.CreateDocumentRequest.class,
      responseType = com.google.firestore.v1.Document.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.CreateDocumentRequest, com.google.firestore.v1.Document>
      getCreateDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.v1.CreateDocumentRequest, com.google.firestore.v1.Document>
        getCreateDocumentMethod;
    if ((getCreateDocumentMethod = FirestoreGrpc.getCreateDocumentMethod) == null) {
      synchronized (FirestoreGrpc.class) {
        if ((getCreateDocumentMethod = FirestoreGrpc.getCreateDocumentMethod) == null) {
          FirestoreGrpc.getCreateDocumentMethod =
              getCreateDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.v1.CreateDocumentRequest,
                          com.google.firestore.v1.Document>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.CreateDocumentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.v1.Document.getDefaultInstance()))
                      .setSchemaDescriptor(new FirestoreMethodDescriptorSupplier("CreateDocument"))
                      .build();
        }
      }
    }
    return getCreateDocumentMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static FirestoreStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FirestoreStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FirestoreStub>() {
          @java.lang.Override
          public FirestoreStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FirestoreStub(channel, callOptions);
          }
        };
    return FirestoreStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static FirestoreBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FirestoreBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FirestoreBlockingV2Stub>() {
          @java.lang.Override
          public FirestoreBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FirestoreBlockingV2Stub(channel, callOptions);
          }
        };
    return FirestoreBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FirestoreBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FirestoreBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FirestoreBlockingStub>() {
          @java.lang.Override
          public FirestoreBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FirestoreBlockingStub(channel, callOptions);
          }
        };
    return FirestoreBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static FirestoreFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FirestoreFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FirestoreFutureStub>() {
          @java.lang.Override
          public FirestoreFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FirestoreFutureStub(channel, callOptions);
          }
        };
    return FirestoreFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Cloud Firestore service.
   * Cloud Firestore is a fast, fully managed, serverless, cloud-native NoSQL
   * document database that simplifies storing, syncing, and querying data for
   * your mobile, web, and IoT apps at global scale. Its client libraries provide
   * live synchronization and offline support, while its security features and
   * integrations with Firebase and Google Cloud Platform accelerate building
   * truly serverless apps.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets a single document.
     * </pre>
     */
    default void getDocument(
        com.google.firestore.v1.GetDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.Document> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists documents.
     * </pre>
     */
    default void listDocuments(
        com.google.firestore.v1.ListDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.ListDocumentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDocumentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates or inserts a document.
     * </pre>
     */
    default void updateDocument(
        com.google.firestore.v1.UpdateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.Document> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a document.
     * </pre>
     */
    default void deleteDocument(
        com.google.firestore.v1.DeleteDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets multiple documents.
     * Documents returned by this method are not guaranteed to be returned in the
     * same order that they were requested.
     * </pre>
     */
    default void batchGetDocuments(
        com.google.firestore.v1.BatchGetDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.BatchGetDocumentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchGetDocumentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts a new transaction.
     * </pre>
     */
    default void beginTransaction(
        com.google.firestore.v1.BeginTransactionRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.BeginTransactionResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBeginTransactionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Commits a transaction, while optionally updating documents.
     * </pre>
     */
    default void commit(
        com.google.firestore.v1.CommitRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.CommitResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCommitMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a transaction.
     * </pre>
     */
    default void rollback(
        com.google.firestore.v1.RollbackRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRollbackMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs a query.
     * </pre>
     */
    default void runQuery(
        com.google.firestore.v1.RunQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.RunQueryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRunQueryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs an aggregation query.
     * Rather than producing [Document][google.firestore.v1.Document] results like
     * [Firestore.RunQuery][google.firestore.v1.Firestore.RunQuery], this API
     * allows running an aggregation to produce a series of
     * [AggregationResult][google.firestore.v1.AggregationResult] server-side.
     * High-Level Example:
     * ```
     * -- Return the number of documents in table given a filter.
     * SELECT COUNT(*) FROM ( SELECT * FROM k where a = true );
     * ```
     * </pre>
     */
    default void runAggregationQuery(
        com.google.firestore.v1.RunAggregationQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.RunAggregationQueryResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRunAggregationQueryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Partitions a query by returning partition cursors that can be used to run
     * the query in parallel. The returned partition cursors are split points that
     * can be used by RunQuery as starting/end points for the query results.
     * </pre>
     */
    default void partitionQuery(
        com.google.firestore.v1.PartitionQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.PartitionQueryResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPartitionQueryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Streams batches of document updates and deletes, in order. This method is
     * only available via gRPC or WebChannel (not REST).
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.google.firestore.v1.WriteRequest> write(
        io.grpc.stub.StreamObserver<com.google.firestore.v1.WriteResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getWriteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Listens to changes. This method is only available via gRPC or WebChannel
     * (not REST).
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.google.firestore.v1.ListenRequest> listen(
        io.grpc.stub.StreamObserver<com.google.firestore.v1.ListenResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getListenMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the collection IDs underneath a document.
     * </pre>
     */
    default void listCollectionIds(
        com.google.firestore.v1.ListCollectionIdsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.ListCollectionIdsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCollectionIdsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Applies a batch of write operations.
     * The BatchWrite method does not apply the write operations atomically
     * and can apply them out of order. Method does not allow more than one write
     * per document. Each write succeeds or fails independently. See the
     * [BatchWriteResponse][google.firestore.v1.BatchWriteResponse] for the
     * success status of each write.
     * If you require an atomically applied set of writes, use
     * [Commit][google.firestore.v1.Firestore.Commit] instead.
     * </pre>
     */
    default void batchWrite(
        com.google.firestore.v1.BatchWriteRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.BatchWriteResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchWriteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new document.
     * </pre>
     */
    default void createDocument(
        com.google.firestore.v1.CreateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.Document> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDocumentMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Firestore.
   *
   * <pre>
   * The Cloud Firestore service.
   * Cloud Firestore is a fast, fully managed, serverless, cloud-native NoSQL
   * document database that simplifies storing, syncing, and querying data for
   * your mobile, web, and IoT apps at global scale. Its client libraries provide
   * live synchronization and offline support, while its security features and
   * integrations with Firebase and Google Cloud Platform accelerate building
   * truly serverless apps.
   * </pre>
   */
  public abstract static class FirestoreImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return FirestoreGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Firestore.
   *
   * <pre>
   * The Cloud Firestore service.
   * Cloud Firestore is a fast, fully managed, serverless, cloud-native NoSQL
   * document database that simplifies storing, syncing, and querying data for
   * your mobile, web, and IoT apps at global scale. Its client libraries provide
   * live synchronization and offline support, while its security features and
   * integrations with Firebase and Google Cloud Platform accelerate building
   * truly serverless apps.
   * </pre>
   */
  public static final class FirestoreStub extends io.grpc.stub.AbstractAsyncStub<FirestoreStub> {
    private FirestoreStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FirestoreStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FirestoreStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a single document.
     * </pre>
     */
    public void getDocument(
        com.google.firestore.v1.GetDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.Document> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists documents.
     * </pre>
     */
    public void listDocuments(
        com.google.firestore.v1.ListDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.ListDocumentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDocumentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates or inserts a document.
     * </pre>
     */
    public void updateDocument(
        com.google.firestore.v1.UpdateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.Document> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a document.
     * </pre>
     */
    public void deleteDocument(
        com.google.firestore.v1.DeleteDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets multiple documents.
     * Documents returned by this method are not guaranteed to be returned in the
     * same order that they were requested.
     * </pre>
     */
    public void batchGetDocuments(
        com.google.firestore.v1.BatchGetDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.BatchGetDocumentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getBatchGetDocumentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts a new transaction.
     * </pre>
     */
    public void beginTransaction(
        com.google.firestore.v1.BeginTransactionRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.BeginTransactionResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBeginTransactionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Commits a transaction, while optionally updating documents.
     * </pre>
     */
    public void commit(
        com.google.firestore.v1.CommitRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.CommitResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCommitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a transaction.
     * </pre>
     */
    public void rollback(
        com.google.firestore.v1.RollbackRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRollbackMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs a query.
     * </pre>
     */
    public void runQuery(
        com.google.firestore.v1.RunQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.RunQueryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getRunQueryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs an aggregation query.
     * Rather than producing [Document][google.firestore.v1.Document] results like
     * [Firestore.RunQuery][google.firestore.v1.Firestore.RunQuery], this API
     * allows running an aggregation to produce a series of
     * [AggregationResult][google.firestore.v1.AggregationResult] server-side.
     * High-Level Example:
     * ```
     * -- Return the number of documents in table given a filter.
     * SELECT COUNT(*) FROM ( SELECT * FROM k where a = true );
     * ```
     * </pre>
     */
    public void runAggregationQuery(
        com.google.firestore.v1.RunAggregationQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.RunAggregationQueryResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getRunAggregationQueryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Partitions a query by returning partition cursors that can be used to run
     * the query in parallel. The returned partition cursors are split points that
     * can be used by RunQuery as starting/end points for the query results.
     * </pre>
     */
    public void partitionQuery(
        com.google.firestore.v1.PartitionQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.PartitionQueryResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPartitionQueryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Streams batches of document updates and deletes, in order. This method is
     * only available via gRPC or WebChannel (not REST).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.firestore.v1.WriteRequest> write(
        io.grpc.stub.StreamObserver<com.google.firestore.v1.WriteResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getWriteMethod(), getCallOptions()), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Listens to changes. This method is only available via gRPC or WebChannel
     * (not REST).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.firestore.v1.ListenRequest> listen(
        io.grpc.stub.StreamObserver<com.google.firestore.v1.ListenResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getListenMethod(), getCallOptions()), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the collection IDs underneath a document.
     * </pre>
     */
    public void listCollectionIds(
        com.google.firestore.v1.ListCollectionIdsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.ListCollectionIdsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCollectionIdsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Applies a batch of write operations.
     * The BatchWrite method does not apply the write operations atomically
     * and can apply them out of order. Method does not allow more than one write
     * per document. Each write succeeds or fails independently. See the
     * [BatchWriteResponse][google.firestore.v1.BatchWriteResponse] for the
     * success status of each write.
     * If you require an atomically applied set of writes, use
     * [Commit][google.firestore.v1.Firestore.Commit] instead.
     * </pre>
     */
    public void batchWrite(
        com.google.firestore.v1.BatchWriteRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.BatchWriteResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchWriteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new document.
     * </pre>
     */
    public void createDocument(
        com.google.firestore.v1.CreateDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.v1.Document> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Firestore.
   *
   * <pre>
   * The Cloud Firestore service.
   * Cloud Firestore is a fast, fully managed, serverless, cloud-native NoSQL
   * document database that simplifies storing, syncing, and querying data for
   * your mobile, web, and IoT apps at global scale. Its client libraries provide
   * live synchronization and offline support, while its security features and
   * integrations with Firebase and Google Cloud Platform accelerate building
   * truly serverless apps.
   * </pre>
   */
  public static final class FirestoreBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<FirestoreBlockingV2Stub> {
    private FirestoreBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FirestoreBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FirestoreBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a single document.
     * </pre>
     */
    public com.google.firestore.v1.Document getDocument(
        com.google.firestore.v1.GetDocumentRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists documents.
     * </pre>
     */
    public com.google.firestore.v1.ListDocumentsResponse listDocuments(
        com.google.firestore.v1.ListDocumentsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDocumentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates or inserts a document.
     * </pre>
     */
    public com.google.firestore.v1.Document updateDocument(
        com.google.firestore.v1.UpdateDocumentRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a document.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDocument(
        com.google.firestore.v1.DeleteDocumentRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets multiple documents.
     * Documents returned by this method are not guaranteed to be returned in the
     * same order that they were requested.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, com.google.firestore.v1.BatchGetDocumentsResponse>
        batchGetDocuments(com.google.firestore.v1.BatchGetDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getBatchGetDocumentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a new transaction.
     * </pre>
     */
    public com.google.firestore.v1.BeginTransactionResponse beginTransaction(
        com.google.firestore.v1.BeginTransactionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBeginTransactionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Commits a transaction, while optionally updating documents.
     * </pre>
     */
    public com.google.firestore.v1.CommitResponse commit(
        com.google.firestore.v1.CommitRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCommitMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a transaction.
     * </pre>
     */
    public com.google.protobuf.Empty rollback(com.google.firestore.v1.RollbackRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRollbackMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Runs a query.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, com.google.firestore.v1.RunQueryResponse> runQuery(
        com.google.firestore.v1.RunQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getRunQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Runs an aggregation query.
     * Rather than producing [Document][google.firestore.v1.Document] results like
     * [Firestore.RunQuery][google.firestore.v1.Firestore.RunQuery], this API
     * allows running an aggregation to produce a series of
     * [AggregationResult][google.firestore.v1.AggregationResult] server-side.
     * High-Level Example:
     * ```
     * -- Return the number of documents in table given a filter.
     * SELECT COUNT(*) FROM ( SELECT * FROM k where a = true );
     * ```
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, com.google.firestore.v1.RunAggregationQueryResponse>
        runAggregationQuery(com.google.firestore.v1.RunAggregationQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getRunAggregationQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Partitions a query by returning partition cursors that can be used to run
     * the query in parallel. The returned partition cursors are split points that
     * can be used by RunQuery as starting/end points for the query results.
     * </pre>
     */
    public com.google.firestore.v1.PartitionQueryResponse partitionQuery(
        com.google.firestore.v1.PartitionQueryRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPartitionQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Streams batches of document updates and deletes, in order. This method is
     * only available via gRPC or WebChannel (not REST).
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<
            com.google.firestore.v1.WriteRequest, com.google.firestore.v1.WriteResponse>
        write() {
      return io.grpc.stub.ClientCalls.blockingBidiStreamingCall(
          getChannel(), getWriteMethod(), getCallOptions());
    }

    /**
     *
     *
     * <pre>
     * Listens to changes. This method is only available via gRPC or WebChannel
     * (not REST).
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<
            com.google.firestore.v1.ListenRequest, com.google.firestore.v1.ListenResponse>
        listen() {
      return io.grpc.stub.ClientCalls.blockingBidiStreamingCall(
          getChannel(), getListenMethod(), getCallOptions());
    }

    /**
     *
     *
     * <pre>
     * Lists all the collection IDs underneath a document.
     * </pre>
     */
    public com.google.firestore.v1.ListCollectionIdsResponse listCollectionIds(
        com.google.firestore.v1.ListCollectionIdsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListCollectionIdsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Applies a batch of write operations.
     * The BatchWrite method does not apply the write operations atomically
     * and can apply them out of order. Method does not allow more than one write
     * per document. Each write succeeds or fails independently. See the
     * [BatchWriteResponse][google.firestore.v1.BatchWriteResponse] for the
     * success status of each write.
     * If you require an atomically applied set of writes, use
     * [Commit][google.firestore.v1.Firestore.Commit] instead.
     * </pre>
     */
    public com.google.firestore.v1.BatchWriteResponse batchWrite(
        com.google.firestore.v1.BatchWriteRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBatchWriteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new document.
     * </pre>
     */
    public com.google.firestore.v1.Document createDocument(
        com.google.firestore.v1.CreateDocumentRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateDocumentMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Firestore.
   *
   * <pre>
   * The Cloud Firestore service.
   * Cloud Firestore is a fast, fully managed, serverless, cloud-native NoSQL
   * document database that simplifies storing, syncing, and querying data for
   * your mobile, web, and IoT apps at global scale. Its client libraries provide
   * live synchronization and offline support, while its security features and
   * integrations with Firebase and Google Cloud Platform accelerate building
   * truly serverless apps.
   * </pre>
   */
  public static final class FirestoreBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FirestoreBlockingStub> {
    private FirestoreBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FirestoreBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FirestoreBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a single document.
     * </pre>
     */
    public com.google.firestore.v1.Document getDocument(
        com.google.firestore.v1.GetDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists documents.
     * </pre>
     */
    public com.google.firestore.v1.ListDocumentsResponse listDocuments(
        com.google.firestore.v1.ListDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDocumentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates or inserts a document.
     * </pre>
     */
    public com.google.firestore.v1.Document updateDocument(
        com.google.firestore.v1.UpdateDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a document.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDocument(
        com.google.firestore.v1.DeleteDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets multiple documents.
     * Documents returned by this method are not guaranteed to be returned in the
     * same order that they were requested.
     * </pre>
     */
    public java.util.Iterator<com.google.firestore.v1.BatchGetDocumentsResponse> batchGetDocuments(
        com.google.firestore.v1.BatchGetDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getBatchGetDocumentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a new transaction.
     * </pre>
     */
    public com.google.firestore.v1.BeginTransactionResponse beginTransaction(
        com.google.firestore.v1.BeginTransactionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBeginTransactionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Commits a transaction, while optionally updating documents.
     * </pre>
     */
    public com.google.firestore.v1.CommitResponse commit(
        com.google.firestore.v1.CommitRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCommitMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a transaction.
     * </pre>
     */
    public com.google.protobuf.Empty rollback(com.google.firestore.v1.RollbackRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRollbackMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Runs a query.
     * </pre>
     */
    public java.util.Iterator<com.google.firestore.v1.RunQueryResponse> runQuery(
        com.google.firestore.v1.RunQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getRunQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Runs an aggregation query.
     * Rather than producing [Document][google.firestore.v1.Document] results like
     * [Firestore.RunQuery][google.firestore.v1.Firestore.RunQuery], this API
     * allows running an aggregation to produce a series of
     * [AggregationResult][google.firestore.v1.AggregationResult] server-side.
     * High-Level Example:
     * ```
     * -- Return the number of documents in table given a filter.
     * SELECT COUNT(*) FROM ( SELECT * FROM k where a = true );
     * ```
     * </pre>
     */
    public java.util.Iterator<com.google.firestore.v1.RunAggregationQueryResponse>
        runAggregationQuery(com.google.firestore.v1.RunAggregationQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getRunAggregationQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Partitions a query by returning partition cursors that can be used to run
     * the query in parallel. The returned partition cursors are split points that
     * can be used by RunQuery as starting/end points for the query results.
     * </pre>
     */
    public com.google.firestore.v1.PartitionQueryResponse partitionQuery(
        com.google.firestore.v1.PartitionQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPartitionQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the collection IDs underneath a document.
     * </pre>
     */
    public com.google.firestore.v1.ListCollectionIdsResponse listCollectionIds(
        com.google.firestore.v1.ListCollectionIdsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCollectionIdsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Applies a batch of write operations.
     * The BatchWrite method does not apply the write operations atomically
     * and can apply them out of order. Method does not allow more than one write
     * per document. Each write succeeds or fails independently. See the
     * [BatchWriteResponse][google.firestore.v1.BatchWriteResponse] for the
     * success status of each write.
     * If you require an atomically applied set of writes, use
     * [Commit][google.firestore.v1.Firestore.Commit] instead.
     * </pre>
     */
    public com.google.firestore.v1.BatchWriteResponse batchWrite(
        com.google.firestore.v1.BatchWriteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchWriteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new document.
     * </pre>
     */
    public com.google.firestore.v1.Document createDocument(
        com.google.firestore.v1.CreateDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDocumentMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Firestore.
   *
   * <pre>
   * The Cloud Firestore service.
   * Cloud Firestore is a fast, fully managed, serverless, cloud-native NoSQL
   * document database that simplifies storing, syncing, and querying data for
   * your mobile, web, and IoT apps at global scale. Its client libraries provide
   * live synchronization and offline support, while its security features and
   * integrations with Firebase and Google Cloud Platform accelerate building
   * truly serverless apps.
   * </pre>
   */
  public static final class FirestoreFutureStub
      extends io.grpc.stub.AbstractFutureStub<FirestoreFutureStub> {
    private FirestoreFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FirestoreFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FirestoreFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a single document.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.firestore.v1.Document>
        getDocument(com.google.firestore.v1.GetDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists documents.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.v1.ListDocumentsResponse>
        listDocuments(com.google.firestore.v1.ListDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDocumentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates or inserts a document.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.firestore.v1.Document>
        updateDocument(com.google.firestore.v1.UpdateDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a document.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDocument(com.google.firestore.v1.DeleteDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a new transaction.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.v1.BeginTransactionResponse>
        beginTransaction(com.google.firestore.v1.BeginTransactionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBeginTransactionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Commits a transaction, while optionally updating documents.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.v1.CommitResponse>
        commit(com.google.firestore.v1.CommitRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCommitMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a transaction.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> rollback(
        com.google.firestore.v1.RollbackRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRollbackMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Partitions a query by returning partition cursors that can be used to run
     * the query in parallel. The returned partition cursors are split points that
     * can be used by RunQuery as starting/end points for the query results.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.v1.PartitionQueryResponse>
        partitionQuery(com.google.firestore.v1.PartitionQueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPartitionQueryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the collection IDs underneath a document.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.v1.ListCollectionIdsResponse>
        listCollectionIds(com.google.firestore.v1.ListCollectionIdsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCollectionIdsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Applies a batch of write operations.
     * The BatchWrite method does not apply the write operations atomically
     * and can apply them out of order. Method does not allow more than one write
     * per document. Each write succeeds or fails independently. See the
     * [BatchWriteResponse][google.firestore.v1.BatchWriteResponse] for the
     * success status of each write.
     * If you require an atomically applied set of writes, use
     * [Commit][google.firestore.v1.Firestore.Commit] instead.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.v1.BatchWriteResponse>
        batchWrite(com.google.firestore.v1.BatchWriteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchWriteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new document.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.firestore.v1.Document>
        createDocument(com.google.firestore.v1.CreateDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDocumentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DOCUMENT = 0;
  private static final int METHODID_LIST_DOCUMENTS = 1;
  private static final int METHODID_UPDATE_DOCUMENT = 2;
  private static final int METHODID_DELETE_DOCUMENT = 3;
  private static final int METHODID_BATCH_GET_DOCUMENTS = 4;
  private static final int METHODID_BEGIN_TRANSACTION = 5;
  private static final int METHODID_COMMIT = 6;
  private static final int METHODID_ROLLBACK = 7;
  private static final int METHODID_RUN_QUERY = 8;
  private static final int METHODID_RUN_AGGREGATION_QUERY = 9;
  private static final int METHODID_PARTITION_QUERY = 10;
  private static final int METHODID_LIST_COLLECTION_IDS = 11;
  private static final int METHODID_BATCH_WRITE = 12;
  private static final int METHODID_CREATE_DOCUMENT = 13;
  private static final int METHODID_WRITE = 14;
  private static final int METHODID_LISTEN = 15;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DOCUMENT:
          serviceImpl.getDocument(
              (com.google.firestore.v1.GetDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.v1.Document>) responseObserver);
          break;
        case METHODID_LIST_DOCUMENTS:
          serviceImpl.listDocuments(
              (com.google.firestore.v1.ListDocumentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.v1.ListDocumentsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DOCUMENT:
          serviceImpl.updateDocument(
              (com.google.firestore.v1.UpdateDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.v1.Document>) responseObserver);
          break;
        case METHODID_DELETE_DOCUMENT:
          serviceImpl.deleteDocument(
              (com.google.firestore.v1.DeleteDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_BATCH_GET_DOCUMENTS:
          serviceImpl.batchGetDocuments(
              (com.google.firestore.v1.BatchGetDocumentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.v1.BatchGetDocumentsResponse>)
                  responseObserver);
          break;
        case METHODID_BEGIN_TRANSACTION:
          serviceImpl.beginTransaction(
              (com.google.firestore.v1.BeginTransactionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.v1.BeginTransactionResponse>)
                  responseObserver);
          break;
        case METHODID_COMMIT:
          serviceImpl.commit(
              (com.google.firestore.v1.CommitRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.v1.CommitResponse>)
                  responseObserver);
          break;
        case METHODID_ROLLBACK:
          serviceImpl.rollback(
              (com.google.firestore.v1.RollbackRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_RUN_QUERY:
          serviceImpl.runQuery(
              (com.google.firestore.v1.RunQueryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.v1.RunQueryResponse>)
                  responseObserver);
          break;
        case METHODID_RUN_AGGREGATION_QUERY:
          serviceImpl.runAggregationQuery(
              (com.google.firestore.v1.RunAggregationQueryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.v1.RunAggregationQueryResponse>)
                  responseObserver);
          break;
        case METHODID_PARTITION_QUERY:
          serviceImpl.partitionQuery(
              (com.google.firestore.v1.PartitionQueryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.v1.PartitionQueryResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_COLLECTION_IDS:
          serviceImpl.listCollectionIds(
              (com.google.firestore.v1.ListCollectionIdsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.v1.ListCollectionIdsResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_WRITE:
          serviceImpl.batchWrite(
              (com.google.firestore.v1.BatchWriteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.v1.BatchWriteResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_DOCUMENT:
          serviceImpl.createDocument(
              (com.google.firestore.v1.CreateDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.v1.Document>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WRITE:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.write(
                  (io.grpc.stub.StreamObserver<com.google.firestore.v1.WriteResponse>)
                      responseObserver);
        case METHODID_LISTEN:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.listen(
                  (io.grpc.stub.StreamObserver<com.google.firestore.v1.ListenResponse>)
                      responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getGetDocumentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.v1.GetDocumentRequest, com.google.firestore.v1.Document>(
                    service, METHODID_GET_DOCUMENT)))
        .addMethod(
            getListDocumentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.v1.ListDocumentsRequest,
                    com.google.firestore.v1.ListDocumentsResponse>(
                    service, METHODID_LIST_DOCUMENTS)))
        .addMethod(
            getUpdateDocumentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.v1.UpdateDocumentRequest,
                    com.google.firestore.v1.Document>(service, METHODID_UPDATE_DOCUMENT)))
        .addMethod(
            getDeleteDocumentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.v1.DeleteDocumentRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_DOCUMENT)))
        .addMethod(
            getBatchGetDocumentsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.firestore.v1.BatchGetDocumentsRequest,
                    com.google.firestore.v1.BatchGetDocumentsResponse>(
                    service, METHODID_BATCH_GET_DOCUMENTS)))
        .addMethod(
            getBeginTransactionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.v1.BeginTransactionRequest,
                    com.google.firestore.v1.BeginTransactionResponse>(
                    service, METHODID_BEGIN_TRANSACTION)))
        .addMethod(
            getCommitMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.v1.CommitRequest, com.google.firestore.v1.CommitResponse>(
                    service, METHODID_COMMIT)))
        .addMethod(
            getRollbackMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.v1.RollbackRequest, com.google.protobuf.Empty>(
                    service, METHODID_ROLLBACK)))
        .addMethod(
            getRunQueryMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.firestore.v1.RunQueryRequest,
                    com.google.firestore.v1.RunQueryResponse>(service, METHODID_RUN_QUERY)))
        .addMethod(
            getRunAggregationQueryMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.firestore.v1.RunAggregationQueryRequest,
                    com.google.firestore.v1.RunAggregationQueryResponse>(
                    service, METHODID_RUN_AGGREGATION_QUERY)))
        .addMethod(
            getPartitionQueryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.v1.PartitionQueryRequest,
                    com.google.firestore.v1.PartitionQueryResponse>(
                    service, METHODID_PARTITION_QUERY)))
        .addMethod(
            getWriteMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                new MethodHandlers<
                    com.google.firestore.v1.WriteRequest, com.google.firestore.v1.WriteResponse>(
                    service, METHODID_WRITE)))
        .addMethod(
            getListenMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                new MethodHandlers<
                    com.google.firestore.v1.ListenRequest, com.google.firestore.v1.ListenResponse>(
                    service, METHODID_LISTEN)))
        .addMethod(
            getListCollectionIdsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.v1.ListCollectionIdsRequest,
                    com.google.firestore.v1.ListCollectionIdsResponse>(
                    service, METHODID_LIST_COLLECTION_IDS)))
        .addMethod(
            getBatchWriteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.v1.BatchWriteRequest,
                    com.google.firestore.v1.BatchWriteResponse>(service, METHODID_BATCH_WRITE)))
        .addMethod(
            getCreateDocumentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.v1.CreateDocumentRequest,
                    com.google.firestore.v1.Document>(service, METHODID_CREATE_DOCUMENT)))
        .build();
  }

  private abstract static class FirestoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FirestoreBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.firestore.v1.FirestoreProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Firestore");
    }
  }

  private static final class FirestoreFileDescriptorSupplier
      extends FirestoreBaseDescriptorSupplier {
    FirestoreFileDescriptorSupplier() {}
  }

  private static final class FirestoreMethodDescriptorSupplier
      extends FirestoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FirestoreMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FirestoreGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new FirestoreFileDescriptorSupplier())
                      .addMethod(getGetDocumentMethod())
                      .addMethod(getListDocumentsMethod())
                      .addMethod(getUpdateDocumentMethod())
                      .addMethod(getDeleteDocumentMethod())
                      .addMethod(getBatchGetDocumentsMethod())
                      .addMethod(getBeginTransactionMethod())
                      .addMethod(getCommitMethod())
                      .addMethod(getRollbackMethod())
                      .addMethod(getRunQueryMethod())
                      .addMethod(getRunAggregationQueryMethod())
                      .addMethod(getPartitionQueryMethod())
                      .addMethod(getWriteMethod())
                      .addMethod(getListenMethod())
                      .addMethod(getListCollectionIdsMethod())
                      .addMethod(getBatchWriteMethod())
                      .addMethod(getCreateDocumentMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
