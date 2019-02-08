package com.google.firestore.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * The Cloud Firestore service.
 * This service exposes several types of comparable timestamps:
 * *    `create_time` - The time at which a document was created. Changes only
 *      when a document is deleted, then re-created. Increases in a strict
 *       monotonic fashion.
 * *    `update_time` - The time at which a document was last updated. Changes
 *      every time a document is modified. Does not change when a write results
 *      in no modifications. Increases in a strict monotonic fashion.
 * *    `read_time` - The time at which a particular state was observed. Used
 *      to denote a consistent snapshot of the database or the time at which a
 *      Document was observed to not exist.
 * *    `commit_time` - The time at which the writes in a transaction were
 *      committed. Any read with an equal or greater `read_time` is guaranteed
 *      to see the effects of the transaction.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/firestore/v1/firestore.proto")
public final class FirestoreGrpc {

  private FirestoreGrpc() {}

  public static final String SERVICE_NAME = "google.firestore.v1.Firestore";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetDocumentMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.v1.GetDocumentRequest, com.google.firestore.v1.Document>
      METHOD_GET_DOCUMENT = getGetDocumentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.GetDocumentRequest, com.google.firestore.v1.Document>
      getGetDocumentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.GetDocumentRequest, com.google.firestore.v1.Document>
      getGetDocumentMethod() {
    return getGetDocumentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.v1.GetDocumentRequest, com.google.firestore.v1.Document>
      getGetDocumentMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.firestore.v1.Firestore", "GetDocument"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListDocumentsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.v1.ListDocumentsRequest,
          com.google.firestore.v1.ListDocumentsResponse>
      METHOD_LIST_DOCUMENTS = getListDocumentsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.ListDocumentsRequest,
          com.google.firestore.v1.ListDocumentsResponse>
      getListDocumentsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.ListDocumentsRequest,
          com.google.firestore.v1.ListDocumentsResponse>
      getListDocumentsMethod() {
    return getListDocumentsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.v1.ListDocumentsRequest,
          com.google.firestore.v1.ListDocumentsResponse>
      getListDocumentsMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.firestore.v1.Firestore", "ListDocuments"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateDocumentMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.v1.CreateDocumentRequest, com.google.firestore.v1.Document>
      METHOD_CREATE_DOCUMENT = getCreateDocumentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.CreateDocumentRequest, com.google.firestore.v1.Document>
      getCreateDocumentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.CreateDocumentRequest, com.google.firestore.v1.Document>
      getCreateDocumentMethod() {
    return getCreateDocumentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.v1.CreateDocumentRequest, com.google.firestore.v1.Document>
      getCreateDocumentMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.firestore.v1.Firestore", "CreateDocument"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateDocumentMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.v1.UpdateDocumentRequest, com.google.firestore.v1.Document>
      METHOD_UPDATE_DOCUMENT = getUpdateDocumentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.UpdateDocumentRequest, com.google.firestore.v1.Document>
      getUpdateDocumentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.UpdateDocumentRequest, com.google.firestore.v1.Document>
      getUpdateDocumentMethod() {
    return getUpdateDocumentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.v1.UpdateDocumentRequest, com.google.firestore.v1.Document>
      getUpdateDocumentMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.firestore.v1.Firestore", "UpdateDocument"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteDocumentMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.v1.DeleteDocumentRequest, com.google.protobuf.Empty>
      METHOD_DELETE_DOCUMENT = getDeleteDocumentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.DeleteDocumentRequest, com.google.protobuf.Empty>
      getDeleteDocumentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.DeleteDocumentRequest, com.google.protobuf.Empty>
      getDeleteDocumentMethod() {
    return getDeleteDocumentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.v1.DeleteDocumentRequest, com.google.protobuf.Empty>
      getDeleteDocumentMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.firestore.v1.Firestore", "DeleteDocument"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBatchGetDocumentsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.v1.BatchGetDocumentsRequest,
          com.google.firestore.v1.BatchGetDocumentsResponse>
      METHOD_BATCH_GET_DOCUMENTS = getBatchGetDocumentsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.BatchGetDocumentsRequest,
          com.google.firestore.v1.BatchGetDocumentsResponse>
      getBatchGetDocumentsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.BatchGetDocumentsRequest,
          com.google.firestore.v1.BatchGetDocumentsResponse>
      getBatchGetDocumentsMethod() {
    return getBatchGetDocumentsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.v1.BatchGetDocumentsRequest,
          com.google.firestore.v1.BatchGetDocumentsResponse>
      getBatchGetDocumentsMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.firestore.v1.Firestore", "BatchGetDocuments"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBeginTransactionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.v1.BeginTransactionRequest,
          com.google.firestore.v1.BeginTransactionResponse>
      METHOD_BEGIN_TRANSACTION = getBeginTransactionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.BeginTransactionRequest,
          com.google.firestore.v1.BeginTransactionResponse>
      getBeginTransactionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.BeginTransactionRequest,
          com.google.firestore.v1.BeginTransactionResponse>
      getBeginTransactionMethod() {
    return getBeginTransactionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.v1.BeginTransactionRequest,
          com.google.firestore.v1.BeginTransactionResponse>
      getBeginTransactionMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.firestore.v1.Firestore", "BeginTransaction"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCommitMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.v1.CommitRequest, com.google.firestore.v1.CommitResponse>
      METHOD_COMMIT = getCommitMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.CommitRequest, com.google.firestore.v1.CommitResponse>
      getCommitMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.CommitRequest, com.google.firestore.v1.CommitResponse>
      getCommitMethod() {
    return getCommitMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.v1.CommitRequest, com.google.firestore.v1.CommitResponse>
      getCommitMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.firestore.v1.Firestore", "Commit"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRollbackMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.v1.RollbackRequest, com.google.protobuf.Empty>
      METHOD_ROLLBACK = getRollbackMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.RollbackRequest, com.google.protobuf.Empty>
      getRollbackMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.RollbackRequest, com.google.protobuf.Empty>
      getRollbackMethod() {
    return getRollbackMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.v1.RollbackRequest, com.google.protobuf.Empty>
      getRollbackMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.firestore.v1.Firestore", "Rollback"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRunQueryMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.v1.RunQueryRequest, com.google.firestore.v1.RunQueryResponse>
      METHOD_RUN_QUERY = getRunQueryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.RunQueryRequest, com.google.firestore.v1.RunQueryResponse>
      getRunQueryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.RunQueryRequest, com.google.firestore.v1.RunQueryResponse>
      getRunQueryMethod() {
    return getRunQueryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.v1.RunQueryRequest, com.google.firestore.v1.RunQueryResponse>
      getRunQueryMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.firestore.v1.Firestore", "RunQuery"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWriteMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.v1.WriteRequest, com.google.firestore.v1.WriteResponse>
      METHOD_WRITE = getWriteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.WriteRequest, com.google.firestore.v1.WriteResponse>
      getWriteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.WriteRequest, com.google.firestore.v1.WriteResponse>
      getWriteMethod() {
    return getWriteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.v1.WriteRequest, com.google.firestore.v1.WriteResponse>
      getWriteMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.firestore.v1.Firestore", "Write"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListenMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.v1.ListenRequest, com.google.firestore.v1.ListenResponse>
      METHOD_LISTEN = getListenMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.ListenRequest, com.google.firestore.v1.ListenResponse>
      getListenMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.ListenRequest, com.google.firestore.v1.ListenResponse>
      getListenMethod() {
    return getListenMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.v1.ListenRequest, com.google.firestore.v1.ListenResponse>
      getListenMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.firestore.v1.Firestore", "Listen"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListCollectionIdsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.v1.ListCollectionIdsRequest,
          com.google.firestore.v1.ListCollectionIdsResponse>
      METHOD_LIST_COLLECTION_IDS = getListCollectionIdsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.v1.ListCollectionIdsRequest,
          com.google.firestore.v1.ListCollectionIdsResponse>
      getListCollectionIdsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.v1.ListCollectionIdsRequest,
          com.google.firestore.v1.ListCollectionIdsResponse>
      getListCollectionIdsMethod() {
    return getListCollectionIdsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.v1.ListCollectionIdsRequest,
          com.google.firestore.v1.ListCollectionIdsResponse>
      getListCollectionIdsMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.firestore.v1.Firestore", "ListCollectionIds"))
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

  /** Creates a new async stub that supports all call types for the service */
  public static FirestoreStub newStub(io.grpc.Channel channel) {
    return new FirestoreStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FirestoreBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new FirestoreBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static FirestoreFutureStub newFutureStub(io.grpc.Channel channel) {
    return new FirestoreFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * The Cloud Firestore service.
   * This service exposes several types of comparable timestamps:
   * *    `create_time` - The time at which a document was created. Changes only
   *      when a document is deleted, then re-created. Increases in a strict
   *       monotonic fashion.
   * *    `update_time` - The time at which a document was last updated. Changes
   *      every time a document is modified. Does not change when a write results
   *      in no modifications. Increases in a strict monotonic fashion.
   * *    `read_time` - The time at which a particular state was observed. Used
   *      to denote a consistent snapshot of the database or the time at which a
   *      Document was observed to not exist.
   * *    `commit_time` - The time at which the writes in a transaction were
   *      committed. Any read with an equal or greater `read_time` is guaranteed
   *      to see the effects of the transaction.
   * </pre>
   */
  public abstract static class FirestoreImplBase implements io.grpc.BindableService {

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
      asyncUnimplementedUnaryCall(getGetDocumentMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getListDocumentsMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getCreateDocumentMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getUpdateDocumentMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getDeleteDocumentMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getBatchGetDocumentsMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getBeginTransactionMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getCommitMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getRollbackMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getRunQueryMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Streams batches of document updates and deletes, in order.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.firestore.v1.WriteRequest> write(
        io.grpc.stub.StreamObserver<com.google.firestore.v1.WriteResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getWriteMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Listens to changes.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.firestore.v1.ListenRequest> listen(
        io.grpc.stub.StreamObserver<com.google.firestore.v1.ListenResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getListenMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getListCollectionIdsMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetDocumentMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.firestore.v1.GetDocumentRequest, com.google.firestore.v1.Document>(
                      this, METHODID_GET_DOCUMENT)))
          .addMethod(
              getListDocumentsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.firestore.v1.ListDocumentsRequest,
                      com.google.firestore.v1.ListDocumentsResponse>(
                      this, METHODID_LIST_DOCUMENTS)))
          .addMethod(
              getCreateDocumentMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.firestore.v1.CreateDocumentRequest,
                      com.google.firestore.v1.Document>(this, METHODID_CREATE_DOCUMENT)))
          .addMethod(
              getUpdateDocumentMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.firestore.v1.UpdateDocumentRequest,
                      com.google.firestore.v1.Document>(this, METHODID_UPDATE_DOCUMENT)))
          .addMethod(
              getDeleteDocumentMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.firestore.v1.DeleteDocumentRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_DOCUMENT)))
          .addMethod(
              getBatchGetDocumentsMethodHelper(),
              asyncServerStreamingCall(
                  new MethodHandlers<
                      com.google.firestore.v1.BatchGetDocumentsRequest,
                      com.google.firestore.v1.BatchGetDocumentsResponse>(
                      this, METHODID_BATCH_GET_DOCUMENTS)))
          .addMethod(
              getBeginTransactionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.firestore.v1.BeginTransactionRequest,
                      com.google.firestore.v1.BeginTransactionResponse>(
                      this, METHODID_BEGIN_TRANSACTION)))
          .addMethod(
              getCommitMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.firestore.v1.CommitRequest,
                      com.google.firestore.v1.CommitResponse>(this, METHODID_COMMIT)))
          .addMethod(
              getRollbackMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.firestore.v1.RollbackRequest, com.google.protobuf.Empty>(
                      this, METHODID_ROLLBACK)))
          .addMethod(
              getRunQueryMethodHelper(),
              asyncServerStreamingCall(
                  new MethodHandlers<
                      com.google.firestore.v1.RunQueryRequest,
                      com.google.firestore.v1.RunQueryResponse>(this, METHODID_RUN_QUERY)))
          .addMethod(
              getWriteMethodHelper(),
              asyncBidiStreamingCall(
                  new MethodHandlers<
                      com.google.firestore.v1.WriteRequest, com.google.firestore.v1.WriteResponse>(
                      this, METHODID_WRITE)))
          .addMethod(
              getListenMethodHelper(),
              asyncBidiStreamingCall(
                  new MethodHandlers<
                      com.google.firestore.v1.ListenRequest,
                      com.google.firestore.v1.ListenResponse>(this, METHODID_LISTEN)))
          .addMethod(
              getListCollectionIdsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.firestore.v1.ListCollectionIdsRequest,
                      com.google.firestore.v1.ListCollectionIdsResponse>(
                      this, METHODID_LIST_COLLECTION_IDS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The Cloud Firestore service.
   * This service exposes several types of comparable timestamps:
   * *    `create_time` - The time at which a document was created. Changes only
   *      when a document is deleted, then re-created. Increases in a strict
   *       monotonic fashion.
   * *    `update_time` - The time at which a document was last updated. Changes
   *      every time a document is modified. Does not change when a write results
   *      in no modifications. Increases in a strict monotonic fashion.
   * *    `read_time` - The time at which a particular state was observed. Used
   *      to denote a consistent snapshot of the database or the time at which a
   *      Document was observed to not exist.
   * *    `commit_time` - The time at which the writes in a transaction were
   *      committed. Any read with an equal or greater `read_time` is guaranteed
   *      to see the effects of the transaction.
   * </pre>
   */
  public static final class FirestoreStub extends io.grpc.stub.AbstractStub<FirestoreStub> {
    private FirestoreStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      asyncUnaryCall(
          getChannel().newCall(getGetDocumentMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getListDocumentsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
      asyncUnaryCall(
          getChannel().newCall(getCreateDocumentMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getUpdateDocumentMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getDeleteDocumentMethodHelper(), getCallOptions()),
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
      asyncServerStreamingCall(
          getChannel().newCall(getBatchGetDocumentsMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getBeginTransactionMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getCommitMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
      asyncUnaryCall(
          getChannel().newCall(getRollbackMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
      asyncServerStreamingCall(
          getChannel().newCall(getRunQueryMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Streams batches of document updates and deletes, in order.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.firestore.v1.WriteRequest> write(
        io.grpc.stub.StreamObserver<com.google.firestore.v1.WriteResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getWriteMethodHelper(), getCallOptions()), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Listens to changes.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.firestore.v1.ListenRequest> listen(
        io.grpc.stub.StreamObserver<com.google.firestore.v1.ListenResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getListenMethodHelper(), getCallOptions()), responseObserver);
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
      asyncUnaryCall(
          getChannel().newCall(getListCollectionIdsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The Cloud Firestore service.
   * This service exposes several types of comparable timestamps:
   * *    `create_time` - The time at which a document was created. Changes only
   *      when a document is deleted, then re-created. Increases in a strict
   *       monotonic fashion.
   * *    `update_time` - The time at which a document was last updated. Changes
   *      every time a document is modified. Does not change when a write results
   *      in no modifications. Increases in a strict monotonic fashion.
   * *    `read_time` - The time at which a particular state was observed. Used
   *      to denote a consistent snapshot of the database or the time at which a
   *      Document was observed to not exist.
   * *    `commit_time` - The time at which the writes in a transaction were
   *      committed. Any read with an equal or greater `read_time` is guaranteed
   *      to see the effects of the transaction.
   * </pre>
   */
  public static final class FirestoreBlockingStub
      extends io.grpc.stub.AbstractStub<FirestoreBlockingStub> {
    private FirestoreBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      return blockingUnaryCall(
          getChannel(), getGetDocumentMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getListDocumentsMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getCreateDocumentMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getUpdateDocumentMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getDeleteDocumentMethodHelper(), getCallOptions(), request);
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
      return blockingServerStreamingCall(
          getChannel(), getBatchGetDocumentsMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getBeginTransactionMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(getChannel(), getCommitMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a transaction.
     * </pre>
     */
    public com.google.protobuf.Empty rollback(com.google.firestore.v1.RollbackRequest request) {
      return blockingUnaryCall(getChannel(), getRollbackMethodHelper(), getCallOptions(), request);
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
      return blockingServerStreamingCall(
          getChannel(), getRunQueryMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getListCollectionIdsMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The Cloud Firestore service.
   * This service exposes several types of comparable timestamps:
   * *    `create_time` - The time at which a document was created. Changes only
   *      when a document is deleted, then re-created. Increases in a strict
   *       monotonic fashion.
   * *    `update_time` - The time at which a document was last updated. Changes
   *      every time a document is modified. Does not change when a write results
   *      in no modifications. Increases in a strict monotonic fashion.
   * *    `read_time` - The time at which a particular state was observed. Used
   *      to denote a consistent snapshot of the database or the time at which a
   *      Document was observed to not exist.
   * *    `commit_time` - The time at which the writes in a transaction were
   *      committed. Any read with an equal or greater `read_time` is guaranteed
   *      to see the effects of the transaction.
   * </pre>
   */
  public static final class FirestoreFutureStub
      extends io.grpc.stub.AbstractStub<FirestoreFutureStub> {
    private FirestoreFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      return futureUnaryCall(
          getChannel().newCall(getGetDocumentMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getListDocumentsMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getCreateDocumentMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getUpdateDocumentMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getDeleteDocumentMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getBeginTransactionMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getCommitMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getRollbackMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getListCollectionIdsMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DOCUMENT = 0;
  private static final int METHODID_LIST_DOCUMENTS = 1;
  private static final int METHODID_CREATE_DOCUMENT = 2;
  private static final int METHODID_UPDATE_DOCUMENT = 3;
  private static final int METHODID_DELETE_DOCUMENT = 4;
  private static final int METHODID_BATCH_GET_DOCUMENTS = 5;
  private static final int METHODID_BEGIN_TRANSACTION = 6;
  private static final int METHODID_COMMIT = 7;
  private static final int METHODID_ROLLBACK = 8;
  private static final int METHODID_RUN_QUERY = 9;
  private static final int METHODID_LIST_COLLECTION_IDS = 10;
  private static final int METHODID_WRITE = 11;
  private static final int METHODID_LISTEN = 12;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FirestoreImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FirestoreImplBase serviceImpl, int methodId) {
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
        case METHODID_CREATE_DOCUMENT:
          serviceImpl.createDocument(
              (com.google.firestore.v1.CreateDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.v1.Document>) responseObserver);
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
        case METHODID_LIST_COLLECTION_IDS:
          serviceImpl.listCollectionIds(
              (com.google.firestore.v1.ListCollectionIdsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.v1.ListCollectionIdsResponse>)
                  responseObserver);
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
    private final String methodName;

    FirestoreMethodDescriptorSupplier(String methodName) {
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
                      .addMethod(getGetDocumentMethodHelper())
                      .addMethod(getListDocumentsMethodHelper())
                      .addMethod(getCreateDocumentMethodHelper())
                      .addMethod(getUpdateDocumentMethodHelper())
                      .addMethod(getDeleteDocumentMethodHelper())
                      .addMethod(getBatchGetDocumentsMethodHelper())
                      .addMethod(getBeginTransactionMethodHelper())
                      .addMethod(getCommitMethodHelper())
                      .addMethod(getRollbackMethodHelper())
                      .addMethod(getRunQueryMethodHelper())
                      .addMethod(getWriteMethodHelper())
                      .addMethod(getListenMethodHelper())
                      .addMethod(getListCollectionIdsMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
