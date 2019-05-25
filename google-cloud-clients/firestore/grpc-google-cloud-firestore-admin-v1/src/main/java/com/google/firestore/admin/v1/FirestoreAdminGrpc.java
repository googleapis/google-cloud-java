package com.google.firestore.admin.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * Operations are created by service `FirestoreAdmin`, but are accessed via
 * service `google.longrunning.Operations`.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/firestore/admin/v1/firestore_admin.proto")
public final class FirestoreAdminGrpc {

  private FirestoreAdminGrpc() {}

  public static final String SERVICE_NAME = "google.firestore.admin.v1.FirestoreAdmin";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateIndexMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.CreateIndexRequest, com.google.longrunning.Operation>
      METHOD_CREATE_INDEX = getCreateIndexMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.CreateIndexRequest, com.google.longrunning.Operation>
      getCreateIndexMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.CreateIndexRequest, com.google.longrunning.Operation>
      getCreateIndexMethod() {
    return getCreateIndexMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.CreateIndexRequest, com.google.longrunning.Operation>
      getCreateIndexMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.CreateIndexRequest, com.google.longrunning.Operation>
        getCreateIndexMethod;
    if ((getCreateIndexMethod = FirestoreAdminGrpc.getCreateIndexMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getCreateIndexMethod = FirestoreAdminGrpc.getCreateIndexMethod) == null) {
          FirestoreAdminGrpc.getCreateIndexMethod =
              getCreateIndexMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.CreateIndexRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.firestore.admin.v1.FirestoreAdmin", "CreateIndex"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.CreateIndexRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("CreateIndex"))
                      .build();
        }
      }
    }
    return getCreateIndexMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListIndexesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ListIndexesRequest,
          com.google.firestore.admin.v1.ListIndexesResponse>
      METHOD_LIST_INDEXES = getListIndexesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ListIndexesRequest,
          com.google.firestore.admin.v1.ListIndexesResponse>
      getListIndexesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ListIndexesRequest,
          com.google.firestore.admin.v1.ListIndexesResponse>
      getListIndexesMethod() {
    return getListIndexesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ListIndexesRequest,
          com.google.firestore.admin.v1.ListIndexesResponse>
      getListIndexesMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.ListIndexesRequest,
            com.google.firestore.admin.v1.ListIndexesResponse>
        getListIndexesMethod;
    if ((getListIndexesMethod = FirestoreAdminGrpc.getListIndexesMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getListIndexesMethod = FirestoreAdminGrpc.getListIndexesMethod) == null) {
          FirestoreAdminGrpc.getListIndexesMethod =
              getListIndexesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.ListIndexesRequest,
                          com.google.firestore.admin.v1.ListIndexesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.firestore.admin.v1.FirestoreAdmin", "ListIndexes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.ListIndexesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.ListIndexesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("ListIndexes"))
                      .build();
        }
      }
    }
    return getListIndexesMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetIndexMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.GetIndexRequest, com.google.firestore.admin.v1.Index>
      METHOD_GET_INDEX = getGetIndexMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.GetIndexRequest, com.google.firestore.admin.v1.Index>
      getGetIndexMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.GetIndexRequest, com.google.firestore.admin.v1.Index>
      getGetIndexMethod() {
    return getGetIndexMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.GetIndexRequest, com.google.firestore.admin.v1.Index>
      getGetIndexMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.GetIndexRequest, com.google.firestore.admin.v1.Index>
        getGetIndexMethod;
    if ((getGetIndexMethod = FirestoreAdminGrpc.getGetIndexMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getGetIndexMethod = FirestoreAdminGrpc.getGetIndexMethod) == null) {
          FirestoreAdminGrpc.getGetIndexMethod =
              getGetIndexMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.GetIndexRequest,
                          com.google.firestore.admin.v1.Index>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.firestore.admin.v1.FirestoreAdmin", "GetIndex"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.GetIndexRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.Index.getDefaultInstance()))
                      .setSchemaDescriptor(new FirestoreAdminMethodDescriptorSupplier("GetIndex"))
                      .build();
        }
      }
    }
    return getGetIndexMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteIndexMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.DeleteIndexRequest, com.google.protobuf.Empty>
      METHOD_DELETE_INDEX = getDeleteIndexMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.DeleteIndexRequest, com.google.protobuf.Empty>
      getDeleteIndexMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.DeleteIndexRequest, com.google.protobuf.Empty>
      getDeleteIndexMethod() {
    return getDeleteIndexMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.DeleteIndexRequest, com.google.protobuf.Empty>
      getDeleteIndexMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.DeleteIndexRequest, com.google.protobuf.Empty>
        getDeleteIndexMethod;
    if ((getDeleteIndexMethod = FirestoreAdminGrpc.getDeleteIndexMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getDeleteIndexMethod = FirestoreAdminGrpc.getDeleteIndexMethod) == null) {
          FirestoreAdminGrpc.getDeleteIndexMethod =
              getDeleteIndexMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.DeleteIndexRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.firestore.admin.v1.FirestoreAdmin", "DeleteIndex"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.DeleteIndexRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("DeleteIndex"))
                      .build();
        }
      }
    }
    return getDeleteIndexMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetFieldMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.GetFieldRequest, com.google.firestore.admin.v1.Field>
      METHOD_GET_FIELD = getGetFieldMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.GetFieldRequest, com.google.firestore.admin.v1.Field>
      getGetFieldMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.GetFieldRequest, com.google.firestore.admin.v1.Field>
      getGetFieldMethod() {
    return getGetFieldMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.GetFieldRequest, com.google.firestore.admin.v1.Field>
      getGetFieldMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.GetFieldRequest, com.google.firestore.admin.v1.Field>
        getGetFieldMethod;
    if ((getGetFieldMethod = FirestoreAdminGrpc.getGetFieldMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getGetFieldMethod = FirestoreAdminGrpc.getGetFieldMethod) == null) {
          FirestoreAdminGrpc.getGetFieldMethod =
              getGetFieldMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.GetFieldRequest,
                          com.google.firestore.admin.v1.Field>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.firestore.admin.v1.FirestoreAdmin", "GetField"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.GetFieldRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.Field.getDefaultInstance()))
                      .setSchemaDescriptor(new FirestoreAdminMethodDescriptorSupplier("GetField"))
                      .build();
        }
      }
    }
    return getGetFieldMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateFieldMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.UpdateFieldRequest, com.google.longrunning.Operation>
      METHOD_UPDATE_FIELD = getUpdateFieldMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.UpdateFieldRequest, com.google.longrunning.Operation>
      getUpdateFieldMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.UpdateFieldRequest, com.google.longrunning.Operation>
      getUpdateFieldMethod() {
    return getUpdateFieldMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.UpdateFieldRequest, com.google.longrunning.Operation>
      getUpdateFieldMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.UpdateFieldRequest, com.google.longrunning.Operation>
        getUpdateFieldMethod;
    if ((getUpdateFieldMethod = FirestoreAdminGrpc.getUpdateFieldMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getUpdateFieldMethod = FirestoreAdminGrpc.getUpdateFieldMethod) == null) {
          FirestoreAdminGrpc.getUpdateFieldMethod =
              getUpdateFieldMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.UpdateFieldRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.firestore.admin.v1.FirestoreAdmin", "UpdateField"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.UpdateFieldRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("UpdateField"))
                      .build();
        }
      }
    }
    return getUpdateFieldMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListFieldsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ListFieldsRequest,
          com.google.firestore.admin.v1.ListFieldsResponse>
      METHOD_LIST_FIELDS = getListFieldsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ListFieldsRequest,
          com.google.firestore.admin.v1.ListFieldsResponse>
      getListFieldsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ListFieldsRequest,
          com.google.firestore.admin.v1.ListFieldsResponse>
      getListFieldsMethod() {
    return getListFieldsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ListFieldsRequest,
          com.google.firestore.admin.v1.ListFieldsResponse>
      getListFieldsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.ListFieldsRequest,
            com.google.firestore.admin.v1.ListFieldsResponse>
        getListFieldsMethod;
    if ((getListFieldsMethod = FirestoreAdminGrpc.getListFieldsMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getListFieldsMethod = FirestoreAdminGrpc.getListFieldsMethod) == null) {
          FirestoreAdminGrpc.getListFieldsMethod =
              getListFieldsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.ListFieldsRequest,
                          com.google.firestore.admin.v1.ListFieldsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.firestore.admin.v1.FirestoreAdmin", "ListFields"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.ListFieldsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.ListFieldsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new FirestoreAdminMethodDescriptorSupplier("ListFields"))
                      .build();
        }
      }
    }
    return getListFieldsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getExportDocumentsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ExportDocumentsRequest, com.google.longrunning.Operation>
      METHOD_EXPORT_DOCUMENTS = getExportDocumentsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ExportDocumentsRequest, com.google.longrunning.Operation>
      getExportDocumentsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ExportDocumentsRequest, com.google.longrunning.Operation>
      getExportDocumentsMethod() {
    return getExportDocumentsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ExportDocumentsRequest, com.google.longrunning.Operation>
      getExportDocumentsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.ExportDocumentsRequest, com.google.longrunning.Operation>
        getExportDocumentsMethod;
    if ((getExportDocumentsMethod = FirestoreAdminGrpc.getExportDocumentsMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getExportDocumentsMethod = FirestoreAdminGrpc.getExportDocumentsMethod) == null) {
          FirestoreAdminGrpc.getExportDocumentsMethod =
              getExportDocumentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.ExportDocumentsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.firestore.admin.v1.FirestoreAdmin", "ExportDocuments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.ExportDocumentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("ExportDocuments"))
                      .build();
        }
      }
    }
    return getExportDocumentsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getImportDocumentsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ImportDocumentsRequest, com.google.longrunning.Operation>
      METHOD_IMPORT_DOCUMENTS = getImportDocumentsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ImportDocumentsRequest, com.google.longrunning.Operation>
      getImportDocumentsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ImportDocumentsRequest, com.google.longrunning.Operation>
      getImportDocumentsMethod() {
    return getImportDocumentsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ImportDocumentsRequest, com.google.longrunning.Operation>
      getImportDocumentsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.ImportDocumentsRequest, com.google.longrunning.Operation>
        getImportDocumentsMethod;
    if ((getImportDocumentsMethod = FirestoreAdminGrpc.getImportDocumentsMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getImportDocumentsMethod = FirestoreAdminGrpc.getImportDocumentsMethod) == null) {
          FirestoreAdminGrpc.getImportDocumentsMethod =
              getImportDocumentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.ImportDocumentsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.firestore.admin.v1.FirestoreAdmin", "ImportDocuments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.ImportDocumentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("ImportDocuments"))
                      .build();
        }
      }
    }
    return getImportDocumentsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static FirestoreAdminStub newStub(io.grpc.Channel channel) {
    return new FirestoreAdminStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FirestoreAdminBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new FirestoreAdminBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static FirestoreAdminFutureStub newFutureStub(io.grpc.Channel channel) {
    return new FirestoreAdminFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * Operations are created by service `FirestoreAdmin`, but are accessed via
   * service `google.longrunning.Operations`.
   * </pre>
   */
  public abstract static class FirestoreAdminImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a composite index. This returns a [google.longrunning.Operation][google.longrunning.Operation]
     * which may be used to track the status of the creation. The metadata for
     * the operation will be the type [IndexOperationMetadata][google.firestore.admin.v1.IndexOperationMetadata].
     * </pre>
     */
    public void createIndex(
        com.google.firestore.admin.v1.CreateIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateIndexMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists composite indexes.
     * </pre>
     */
    public void listIndexes(
        com.google.firestore.admin.v1.ListIndexesRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListIndexesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListIndexesMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a composite index.
     * </pre>
     */
    public void getIndex(
        com.google.firestore.admin.v1.GetIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.Index> responseObserver) {
      asyncUnimplementedUnaryCall(getGetIndexMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a composite index.
     * </pre>
     */
    public void deleteIndex(
        com.google.firestore.admin.v1.DeleteIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteIndexMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the metadata and configuration for a Field.
     * </pre>
     */
    public void getField(
        com.google.firestore.admin.v1.GetFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.Field> responseObserver) {
      asyncUnimplementedUnaryCall(getGetFieldMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a field configuration. Currently, field updates apply only to
     * single field index configuration. However, calls to
     * [FirestoreAdmin.UpdateField][google.firestore.admin.v1.FirestoreAdmin.UpdateField] should provide a field mask to avoid
     * changing any configuration that the caller isn't aware of. The field mask
     * should be specified as: `{ paths: "index_config" }`.
     * This call returns a [google.longrunning.Operation][google.longrunning.Operation] which may be used to
     * track the status of the field update. The metadata for
     * the operation will be the type [FieldOperationMetadata][google.firestore.admin.v1.FieldOperationMetadata].
     * To configure the default field settings for the database, use
     * the special `Field` with resource name:
     * `projects/{project_id}/databases/{database_id}/collectionGroups/__default__/fields/&#42;`.
     * </pre>
     */
    public void updateField(
        com.google.firestore.admin.v1.UpdateFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateFieldMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the field configuration and metadata for this database.
     * Currently, [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields] only supports listing fields
     * that have been explicitly overridden. To issue this query, call
     * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields] with the filter set to
     * `indexConfig.usesAncestorConfig:false`.
     * </pre>
     */
    public void listFields(
        com.google.firestore.admin.v1.ListFieldsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListFieldsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListFieldsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports a copy of all or a subset of documents from Google Cloud Firestore
     * to another storage system, such as Google Cloud Storage. Recent updates to
     * documents may not be reflected in the export. The export occurs in the
     * background and its progress can be monitored and managed via the
     * Operation resource that is created. The output of an export may only be
     * used once the associated operation is done. If an export operation is
     * cancelled before completion it may leave partial data behind in Google
     * Cloud Storage.
     * </pre>
     */
    public void exportDocuments(
        com.google.firestore.admin.v1.ExportDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getExportDocumentsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports documents into Google Cloud Firestore. Existing documents with the
     * same name are overwritten. The import occurs in the background and its
     * progress can be monitored and managed via the Operation resource that is
     * created. If an ImportDocuments operation is cancelled, it is possible
     * that a subset of the data has already been imported to Cloud Firestore.
     * </pre>
     */
    public void importDocuments(
        com.google.firestore.admin.v1.ImportDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getImportDocumentsMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateIndexMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.firestore.admin.v1.CreateIndexRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_INDEX)))
          .addMethod(
              getListIndexesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.firestore.admin.v1.ListIndexesRequest,
                      com.google.firestore.admin.v1.ListIndexesResponse>(
                      this, METHODID_LIST_INDEXES)))
          .addMethod(
              getGetIndexMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.firestore.admin.v1.GetIndexRequest,
                      com.google.firestore.admin.v1.Index>(this, METHODID_GET_INDEX)))
          .addMethod(
              getDeleteIndexMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.firestore.admin.v1.DeleteIndexRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_INDEX)))
          .addMethod(
              getGetFieldMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.firestore.admin.v1.GetFieldRequest,
                      com.google.firestore.admin.v1.Field>(this, METHODID_GET_FIELD)))
          .addMethod(
              getUpdateFieldMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.firestore.admin.v1.UpdateFieldRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_FIELD)))
          .addMethod(
              getListFieldsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.firestore.admin.v1.ListFieldsRequest,
                      com.google.firestore.admin.v1.ListFieldsResponse>(
                      this, METHODID_LIST_FIELDS)))
          .addMethod(
              getExportDocumentsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.firestore.admin.v1.ExportDocumentsRequest,
                      com.google.longrunning.Operation>(this, METHODID_EXPORT_DOCUMENTS)))
          .addMethod(
              getImportDocumentsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.firestore.admin.v1.ImportDocumentsRequest,
                      com.google.longrunning.Operation>(this, METHODID_IMPORT_DOCUMENTS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Operations are created by service `FirestoreAdmin`, but are accessed via
   * service `google.longrunning.Operations`.
   * </pre>
   */
  public static final class FirestoreAdminStub
      extends io.grpc.stub.AbstractStub<FirestoreAdminStub> {
    private FirestoreAdminStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FirestoreAdminStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FirestoreAdminStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FirestoreAdminStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a composite index. This returns a [google.longrunning.Operation][google.longrunning.Operation]
     * which may be used to track the status of the creation. The metadata for
     * the operation will be the type [IndexOperationMetadata][google.firestore.admin.v1.IndexOperationMetadata].
     * </pre>
     */
    public void createIndex(
        com.google.firestore.admin.v1.CreateIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateIndexMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists composite indexes.
     * </pre>
     */
    public void listIndexes(
        com.google.firestore.admin.v1.ListIndexesRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListIndexesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListIndexesMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a composite index.
     * </pre>
     */
    public void getIndex(
        com.google.firestore.admin.v1.GetIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.Index> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetIndexMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a composite index.
     * </pre>
     */
    public void deleteIndex(
        com.google.firestore.admin.v1.DeleteIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteIndexMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the metadata and configuration for a Field.
     * </pre>
     */
    public void getField(
        com.google.firestore.admin.v1.GetFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.Field> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetFieldMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a field configuration. Currently, field updates apply only to
     * single field index configuration. However, calls to
     * [FirestoreAdmin.UpdateField][google.firestore.admin.v1.FirestoreAdmin.UpdateField] should provide a field mask to avoid
     * changing any configuration that the caller isn't aware of. The field mask
     * should be specified as: `{ paths: "index_config" }`.
     * This call returns a [google.longrunning.Operation][google.longrunning.Operation] which may be used to
     * track the status of the field update. The metadata for
     * the operation will be the type [FieldOperationMetadata][google.firestore.admin.v1.FieldOperationMetadata].
     * To configure the default field settings for the database, use
     * the special `Field` with resource name:
     * `projects/{project_id}/databases/{database_id}/collectionGroups/__default__/fields/&#42;`.
     * </pre>
     */
    public void updateField(
        com.google.firestore.admin.v1.UpdateFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateFieldMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the field configuration and metadata for this database.
     * Currently, [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields] only supports listing fields
     * that have been explicitly overridden. To issue this query, call
     * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields] with the filter set to
     * `indexConfig.usesAncestorConfig:false`.
     * </pre>
     */
    public void listFields(
        com.google.firestore.admin.v1.ListFieldsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListFieldsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListFieldsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports a copy of all or a subset of documents from Google Cloud Firestore
     * to another storage system, such as Google Cloud Storage. Recent updates to
     * documents may not be reflected in the export. The export occurs in the
     * background and its progress can be monitored and managed via the
     * Operation resource that is created. The output of an export may only be
     * used once the associated operation is done. If an export operation is
     * cancelled before completion it may leave partial data behind in Google
     * Cloud Storage.
     * </pre>
     */
    public void exportDocuments(
        com.google.firestore.admin.v1.ExportDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getExportDocumentsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports documents into Google Cloud Firestore. Existing documents with the
     * same name are overwritten. The import occurs in the background and its
     * progress can be monitored and managed via the Operation resource that is
     * created. If an ImportDocuments operation is cancelled, it is possible
     * that a subset of the data has already been imported to Cloud Firestore.
     * </pre>
     */
    public void importDocuments(
        com.google.firestore.admin.v1.ImportDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getImportDocumentsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Operations are created by service `FirestoreAdmin`, but are accessed via
   * service `google.longrunning.Operations`.
   * </pre>
   */
  public static final class FirestoreAdminBlockingStub
      extends io.grpc.stub.AbstractStub<FirestoreAdminBlockingStub> {
    private FirestoreAdminBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FirestoreAdminBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FirestoreAdminBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FirestoreAdminBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a composite index. This returns a [google.longrunning.Operation][google.longrunning.Operation]
     * which may be used to track the status of the creation. The metadata for
     * the operation will be the type [IndexOperationMetadata][google.firestore.admin.v1.IndexOperationMetadata].
     * </pre>
     */
    public com.google.longrunning.Operation createIndex(
        com.google.firestore.admin.v1.CreateIndexRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateIndexMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists composite indexes.
     * </pre>
     */
    public com.google.firestore.admin.v1.ListIndexesResponse listIndexes(
        com.google.firestore.admin.v1.ListIndexesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListIndexesMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a composite index.
     * </pre>
     */
    public com.google.firestore.admin.v1.Index getIndex(
        com.google.firestore.admin.v1.GetIndexRequest request) {
      return blockingUnaryCall(getChannel(), getGetIndexMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a composite index.
     * </pre>
     */
    public com.google.protobuf.Empty deleteIndex(
        com.google.firestore.admin.v1.DeleteIndexRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteIndexMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the metadata and configuration for a Field.
     * </pre>
     */
    public com.google.firestore.admin.v1.Field getField(
        com.google.firestore.admin.v1.GetFieldRequest request) {
      return blockingUnaryCall(getChannel(), getGetFieldMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a field configuration. Currently, field updates apply only to
     * single field index configuration. However, calls to
     * [FirestoreAdmin.UpdateField][google.firestore.admin.v1.FirestoreAdmin.UpdateField] should provide a field mask to avoid
     * changing any configuration that the caller isn't aware of. The field mask
     * should be specified as: `{ paths: "index_config" }`.
     * This call returns a [google.longrunning.Operation][google.longrunning.Operation] which may be used to
     * track the status of the field update. The metadata for
     * the operation will be the type [FieldOperationMetadata][google.firestore.admin.v1.FieldOperationMetadata].
     * To configure the default field settings for the database, use
     * the special `Field` with resource name:
     * `projects/{project_id}/databases/{database_id}/collectionGroups/__default__/fields/&#42;`.
     * </pre>
     */
    public com.google.longrunning.Operation updateField(
        com.google.firestore.admin.v1.UpdateFieldRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateFieldMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the field configuration and metadata for this database.
     * Currently, [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields] only supports listing fields
     * that have been explicitly overridden. To issue this query, call
     * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields] with the filter set to
     * `indexConfig.usesAncestorConfig:false`.
     * </pre>
     */
    public com.google.firestore.admin.v1.ListFieldsResponse listFields(
        com.google.firestore.admin.v1.ListFieldsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListFieldsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports a copy of all or a subset of documents from Google Cloud Firestore
     * to another storage system, such as Google Cloud Storage. Recent updates to
     * documents may not be reflected in the export. The export occurs in the
     * background and its progress can be monitored and managed via the
     * Operation resource that is created. The output of an export may only be
     * used once the associated operation is done. If an export operation is
     * cancelled before completion it may leave partial data behind in Google
     * Cloud Storage.
     * </pre>
     */
    public com.google.longrunning.Operation exportDocuments(
        com.google.firestore.admin.v1.ExportDocumentsRequest request) {
      return blockingUnaryCall(
          getChannel(), getExportDocumentsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports documents into Google Cloud Firestore. Existing documents with the
     * same name are overwritten. The import occurs in the background and its
     * progress can be monitored and managed via the Operation resource that is
     * created. If an ImportDocuments operation is cancelled, it is possible
     * that a subset of the data has already been imported to Cloud Firestore.
     * </pre>
     */
    public com.google.longrunning.Operation importDocuments(
        com.google.firestore.admin.v1.ImportDocumentsRequest request) {
      return blockingUnaryCall(
          getChannel(), getImportDocumentsMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Operations are created by service `FirestoreAdmin`, but are accessed via
   * service `google.longrunning.Operations`.
   * </pre>
   */
  public static final class FirestoreAdminFutureStub
      extends io.grpc.stub.AbstractStub<FirestoreAdminFutureStub> {
    private FirestoreAdminFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FirestoreAdminFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FirestoreAdminFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FirestoreAdminFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a composite index. This returns a [google.longrunning.Operation][google.longrunning.Operation]
     * which may be used to track the status of the creation. The metadata for
     * the operation will be the type [IndexOperationMetadata][google.firestore.admin.v1.IndexOperationMetadata].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createIndex(com.google.firestore.admin.v1.CreateIndexRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateIndexMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists composite indexes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.admin.v1.ListIndexesResponse>
        listIndexes(com.google.firestore.admin.v1.ListIndexesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListIndexesMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a composite index.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.firestore.admin.v1.Index>
        getIndex(com.google.firestore.admin.v1.GetIndexRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetIndexMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a composite index.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteIndex(com.google.firestore.admin.v1.DeleteIndexRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteIndexMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the metadata and configuration for a Field.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.firestore.admin.v1.Field>
        getField(com.google.firestore.admin.v1.GetFieldRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetFieldMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a field configuration. Currently, field updates apply only to
     * single field index configuration. However, calls to
     * [FirestoreAdmin.UpdateField][google.firestore.admin.v1.FirestoreAdmin.UpdateField] should provide a field mask to avoid
     * changing any configuration that the caller isn't aware of. The field mask
     * should be specified as: `{ paths: "index_config" }`.
     * This call returns a [google.longrunning.Operation][google.longrunning.Operation] which may be used to
     * track the status of the field update. The metadata for
     * the operation will be the type [FieldOperationMetadata][google.firestore.admin.v1.FieldOperationMetadata].
     * To configure the default field settings for the database, use
     * the special `Field` with resource name:
     * `projects/{project_id}/databases/{database_id}/collectionGroups/__default__/fields/&#42;`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateField(com.google.firestore.admin.v1.UpdateFieldRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateFieldMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the field configuration and metadata for this database.
     * Currently, [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields] only supports listing fields
     * that have been explicitly overridden. To issue this query, call
     * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields] with the filter set to
     * `indexConfig.usesAncestorConfig:false`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.admin.v1.ListFieldsResponse>
        listFields(com.google.firestore.admin.v1.ListFieldsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListFieldsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports a copy of all or a subset of documents from Google Cloud Firestore
     * to another storage system, such as Google Cloud Storage. Recent updates to
     * documents may not be reflected in the export. The export occurs in the
     * background and its progress can be monitored and managed via the
     * Operation resource that is created. The output of an export may only be
     * used once the associated operation is done. If an export operation is
     * cancelled before completion it may leave partial data behind in Google
     * Cloud Storage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportDocuments(com.google.firestore.admin.v1.ExportDocumentsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getExportDocumentsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports documents into Google Cloud Firestore. Existing documents with the
     * same name are overwritten. The import occurs in the background and its
     * progress can be monitored and managed via the Operation resource that is
     * created. If an ImportDocuments operation is cancelled, it is possible
     * that a subset of the data has already been imported to Cloud Firestore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importDocuments(com.google.firestore.admin.v1.ImportDocumentsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getImportDocumentsMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_INDEX = 0;
  private static final int METHODID_LIST_INDEXES = 1;
  private static final int METHODID_GET_INDEX = 2;
  private static final int METHODID_DELETE_INDEX = 3;
  private static final int METHODID_GET_FIELD = 4;
  private static final int METHODID_UPDATE_FIELD = 5;
  private static final int METHODID_LIST_FIELDS = 6;
  private static final int METHODID_EXPORT_DOCUMENTS = 7;
  private static final int METHODID_IMPORT_DOCUMENTS = 8;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FirestoreAdminImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FirestoreAdminImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_INDEX:
          serviceImpl.createIndex(
              (com.google.firestore.admin.v1.CreateIndexRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_INDEXES:
          serviceImpl.listIndexes(
              (com.google.firestore.admin.v1.ListIndexesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListIndexesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INDEX:
          serviceImpl.getIndex(
              (com.google.firestore.admin.v1.GetIndexRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.Index>) responseObserver);
          break;
        case METHODID_DELETE_INDEX:
          serviceImpl.deleteIndex(
              (com.google.firestore.admin.v1.DeleteIndexRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_FIELD:
          serviceImpl.getField(
              (com.google.firestore.admin.v1.GetFieldRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.Field>) responseObserver);
          break;
        case METHODID_UPDATE_FIELD:
          serviceImpl.updateField(
              (com.google.firestore.admin.v1.UpdateFieldRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_FIELDS:
          serviceImpl.listFields(
              (com.google.firestore.admin.v1.ListFieldsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListFieldsResponse>)
                  responseObserver);
          break;
        case METHODID_EXPORT_DOCUMENTS:
          serviceImpl.exportDocuments(
              (com.google.firestore.admin.v1.ExportDocumentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_DOCUMENTS:
          serviceImpl.importDocuments(
              (com.google.firestore.admin.v1.ImportDocumentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private abstract static class FirestoreAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FirestoreAdminBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.firestore.admin.v1.FirestoreAdminProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FirestoreAdmin");
    }
  }

  private static final class FirestoreAdminFileDescriptorSupplier
      extends FirestoreAdminBaseDescriptorSupplier {
    FirestoreAdminFileDescriptorSupplier() {}
  }

  private static final class FirestoreAdminMethodDescriptorSupplier
      extends FirestoreAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FirestoreAdminMethodDescriptorSupplier(String methodName) {
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
      synchronized (FirestoreAdminGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new FirestoreAdminFileDescriptorSupplier())
                      .addMethod(getCreateIndexMethodHelper())
                      .addMethod(getListIndexesMethodHelper())
                      .addMethod(getGetIndexMethodHelper())
                      .addMethod(getDeleteIndexMethodHelper())
                      .addMethod(getGetFieldMethodHelper())
                      .addMethod(getUpdateFieldMethodHelper())
                      .addMethod(getListFieldsMethodHelper())
                      .addMethod(getExportDocumentsMethodHelper())
                      .addMethod(getImportDocumentsMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
