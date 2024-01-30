/*
 * Copyright 2024 Google LLC
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
package com.google.datastore.admin.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Google Cloud Datastore Admin API
 * The Datastore Admin API provides several admin services for Cloud Datastore.
 * Concepts: Project, namespace, kind, and entity as defined in the Google Cloud
 * Datastore API.
 * Operation: An Operation represents work being performed in the background.
 * EntityFilter: Allows specifying a subset of entities in a project. This is
 * specified as a combination of kinds and namespaces (either or both of which
 * may be all).
 * Export/Import Service:
 * - The Export/Import service provides the ability to copy all or a subset of
 * entities to/from Google Cloud Storage.
 * - Exported data may be imported into Cloud Datastore for any Google Cloud
 * Platform project. It is not restricted to the export source project. It is
 * possible to export from one project and then import into another.
 * - Exported data can also be loaded into Google BigQuery for analysis.
 * - Exports and imports are performed asynchronously. An Operation resource is
 * created for each export/import. The state (including any errors encountered)
 * of the export/import may be queried via the Operation resource.
 * Index Service:
 * - The index service manages Cloud Datastore composite indexes.
 * - Index creation and deletion are performed asynchronously.
 * An Operation resource is created for each such asynchronous operation.
 * The state of the operation (including any errors encountered)
 * may be queried via the Operation resource.
 * Operation Service:
 * - The Operations collection provides a record of actions performed for the
 * specified project (including any operations in progress). Operations are not
 * created directly but through calls on other collections or resources.
 * - An operation that is not yet done may be cancelled. The request to cancel
 * is asynchronous and the operation may continue to run for some time after the
 * request to cancel is made.
 * - An operation that is done may be deleted so that it is no longer listed as
 * part of the Operation collection.
 * - ListOperations returns all pending operations, but not completed
 * operations.
 * - Operations are created by service DatastoreAdmin, but are accessed via
 * service google.longrunning.Operations.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/datastore/admin/v1/datastore_admin.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DatastoreAdminGrpc {

  private DatastoreAdminGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.datastore.admin.v1.DatastoreAdmin";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.admin.v1.ExportEntitiesRequest, com.google.longrunning.Operation>
      getExportEntitiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportEntities",
      requestType = com.google.datastore.admin.v1.ExportEntitiesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.datastore.admin.v1.ExportEntitiesRequest, com.google.longrunning.Operation>
      getExportEntitiesMethod() {
    io.grpc.MethodDescriptor<
            com.google.datastore.admin.v1.ExportEntitiesRequest, com.google.longrunning.Operation>
        getExportEntitiesMethod;
    if ((getExportEntitiesMethod = DatastoreAdminGrpc.getExportEntitiesMethod) == null) {
      synchronized (DatastoreAdminGrpc.class) {
        if ((getExportEntitiesMethod = DatastoreAdminGrpc.getExportEntitiesMethod) == null) {
          DatastoreAdminGrpc.getExportEntitiesMethod =
              getExportEntitiesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.datastore.admin.v1.ExportEntitiesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportEntities"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.admin.v1.ExportEntitiesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatastoreAdminMethodDescriptorSupplier("ExportEntities"))
                      .build();
        }
      }
    }
    return getExportEntitiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.admin.v1.ImportEntitiesRequest, com.google.longrunning.Operation>
      getImportEntitiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportEntities",
      requestType = com.google.datastore.admin.v1.ImportEntitiesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.datastore.admin.v1.ImportEntitiesRequest, com.google.longrunning.Operation>
      getImportEntitiesMethod() {
    io.grpc.MethodDescriptor<
            com.google.datastore.admin.v1.ImportEntitiesRequest, com.google.longrunning.Operation>
        getImportEntitiesMethod;
    if ((getImportEntitiesMethod = DatastoreAdminGrpc.getImportEntitiesMethod) == null) {
      synchronized (DatastoreAdminGrpc.class) {
        if ((getImportEntitiesMethod = DatastoreAdminGrpc.getImportEntitiesMethod) == null) {
          DatastoreAdminGrpc.getImportEntitiesMethod =
              getImportEntitiesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.datastore.admin.v1.ImportEntitiesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportEntities"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.admin.v1.ImportEntitiesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatastoreAdminMethodDescriptorSupplier("ImportEntities"))
                      .build();
        }
      }
    }
    return getImportEntitiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.admin.v1.CreateIndexRequest, com.google.longrunning.Operation>
      getCreateIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateIndex",
      requestType = com.google.datastore.admin.v1.CreateIndexRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.datastore.admin.v1.CreateIndexRequest, com.google.longrunning.Operation>
      getCreateIndexMethod() {
    io.grpc.MethodDescriptor<
            com.google.datastore.admin.v1.CreateIndexRequest, com.google.longrunning.Operation>
        getCreateIndexMethod;
    if ((getCreateIndexMethod = DatastoreAdminGrpc.getCreateIndexMethod) == null) {
      synchronized (DatastoreAdminGrpc.class) {
        if ((getCreateIndexMethod = DatastoreAdminGrpc.getCreateIndexMethod) == null) {
          DatastoreAdminGrpc.getCreateIndexMethod =
              getCreateIndexMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.datastore.admin.v1.CreateIndexRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateIndex"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.admin.v1.CreateIndexRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatastoreAdminMethodDescriptorSupplier("CreateIndex"))
                      .build();
        }
      }
    }
    return getCreateIndexMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.admin.v1.DeleteIndexRequest, com.google.longrunning.Operation>
      getDeleteIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteIndex",
      requestType = com.google.datastore.admin.v1.DeleteIndexRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.datastore.admin.v1.DeleteIndexRequest, com.google.longrunning.Operation>
      getDeleteIndexMethod() {
    io.grpc.MethodDescriptor<
            com.google.datastore.admin.v1.DeleteIndexRequest, com.google.longrunning.Operation>
        getDeleteIndexMethod;
    if ((getDeleteIndexMethod = DatastoreAdminGrpc.getDeleteIndexMethod) == null) {
      synchronized (DatastoreAdminGrpc.class) {
        if ((getDeleteIndexMethod = DatastoreAdminGrpc.getDeleteIndexMethod) == null) {
          DatastoreAdminGrpc.getDeleteIndexMethod =
              getDeleteIndexMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.datastore.admin.v1.DeleteIndexRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteIndex"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.admin.v1.DeleteIndexRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatastoreAdminMethodDescriptorSupplier("DeleteIndex"))
                      .build();
        }
      }
    }
    return getDeleteIndexMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.admin.v1.GetIndexRequest, com.google.datastore.admin.v1.Index>
      getGetIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIndex",
      requestType = com.google.datastore.admin.v1.GetIndexRequest.class,
      responseType = com.google.datastore.admin.v1.Index.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.datastore.admin.v1.GetIndexRequest, com.google.datastore.admin.v1.Index>
      getGetIndexMethod() {
    io.grpc.MethodDescriptor<
            com.google.datastore.admin.v1.GetIndexRequest, com.google.datastore.admin.v1.Index>
        getGetIndexMethod;
    if ((getGetIndexMethod = DatastoreAdminGrpc.getGetIndexMethod) == null) {
      synchronized (DatastoreAdminGrpc.class) {
        if ((getGetIndexMethod = DatastoreAdminGrpc.getGetIndexMethod) == null) {
          DatastoreAdminGrpc.getGetIndexMethod =
              getGetIndexMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.datastore.admin.v1.GetIndexRequest,
                          com.google.datastore.admin.v1.Index>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIndex"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.admin.v1.GetIndexRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.admin.v1.Index.getDefaultInstance()))
                      .setSchemaDescriptor(new DatastoreAdminMethodDescriptorSupplier("GetIndex"))
                      .build();
        }
      }
    }
    return getGetIndexMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.datastore.admin.v1.ListIndexesRequest,
          com.google.datastore.admin.v1.ListIndexesResponse>
      getListIndexesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIndexes",
      requestType = com.google.datastore.admin.v1.ListIndexesRequest.class,
      responseType = com.google.datastore.admin.v1.ListIndexesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.datastore.admin.v1.ListIndexesRequest,
          com.google.datastore.admin.v1.ListIndexesResponse>
      getListIndexesMethod() {
    io.grpc.MethodDescriptor<
            com.google.datastore.admin.v1.ListIndexesRequest,
            com.google.datastore.admin.v1.ListIndexesResponse>
        getListIndexesMethod;
    if ((getListIndexesMethod = DatastoreAdminGrpc.getListIndexesMethod) == null) {
      synchronized (DatastoreAdminGrpc.class) {
        if ((getListIndexesMethod = DatastoreAdminGrpc.getListIndexesMethod) == null) {
          DatastoreAdminGrpc.getListIndexesMethod =
              getListIndexesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.datastore.admin.v1.ListIndexesRequest,
                          com.google.datastore.admin.v1.ListIndexesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListIndexes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.admin.v1.ListIndexesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.datastore.admin.v1.ListIndexesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatastoreAdminMethodDescriptorSupplier("ListIndexes"))
                      .build();
        }
      }
    }
    return getListIndexesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DatastoreAdminStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatastoreAdminStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DatastoreAdminStub>() {
          @java.lang.Override
          public DatastoreAdminStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DatastoreAdminStub(channel, callOptions);
          }
        };
    return DatastoreAdminStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DatastoreAdminBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatastoreAdminBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DatastoreAdminBlockingStub>() {
          @java.lang.Override
          public DatastoreAdminBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DatastoreAdminBlockingStub(channel, callOptions);
          }
        };
    return DatastoreAdminBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DatastoreAdminFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatastoreAdminFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DatastoreAdminFutureStub>() {
          @java.lang.Override
          public DatastoreAdminFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DatastoreAdminFutureStub(channel, callOptions);
          }
        };
    return DatastoreAdminFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Google Cloud Datastore Admin API
   * The Datastore Admin API provides several admin services for Cloud Datastore.
   * Concepts: Project, namespace, kind, and entity as defined in the Google Cloud
   * Datastore API.
   * Operation: An Operation represents work being performed in the background.
   * EntityFilter: Allows specifying a subset of entities in a project. This is
   * specified as a combination of kinds and namespaces (either or both of which
   * may be all).
   * Export/Import Service:
   * - The Export/Import service provides the ability to copy all or a subset of
   * entities to/from Google Cloud Storage.
   * - Exported data may be imported into Cloud Datastore for any Google Cloud
   * Platform project. It is not restricted to the export source project. It is
   * possible to export from one project and then import into another.
   * - Exported data can also be loaded into Google BigQuery for analysis.
   * - Exports and imports are performed asynchronously. An Operation resource is
   * created for each export/import. The state (including any errors encountered)
   * of the export/import may be queried via the Operation resource.
   * Index Service:
   * - The index service manages Cloud Datastore composite indexes.
   * - Index creation and deletion are performed asynchronously.
   * An Operation resource is created for each such asynchronous operation.
   * The state of the operation (including any errors encountered)
   * may be queried via the Operation resource.
   * Operation Service:
   * - The Operations collection provides a record of actions performed for the
   * specified project (including any operations in progress). Operations are not
   * created directly but through calls on other collections or resources.
   * - An operation that is not yet done may be cancelled. The request to cancel
   * is asynchronous and the operation may continue to run for some time after the
   * request to cancel is made.
   * - An operation that is done may be deleted so that it is no longer listed as
   * part of the Operation collection.
   * - ListOperations returns all pending operations, but not completed
   * operations.
   * - Operations are created by service DatastoreAdmin, but are accessed via
   * service google.longrunning.Operations.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Exports a copy of all or a subset of entities from Google Cloud Datastore
     * to another storage system, such as Google Cloud Storage. Recent updates to
     * entities may not be reflected in the export. The export occurs in the
     * background and its progress can be monitored and managed via the
     * Operation resource that is created. The output of an export may only be
     * used once the associated operation is done. If an export operation is
     * cancelled before completion it may leave partial data behind in Google
     * Cloud Storage.
     * </pre>
     */
    default void exportEntities(
        com.google.datastore.admin.v1.ExportEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportEntitiesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports entities into Google Cloud Datastore. Existing entities with the
     * same key are overwritten. The import occurs in the background and its
     * progress can be monitored and managed via the Operation resource that is
     * created. If an ImportEntities operation is cancelled, it is possible
     * that a subset of the data has already been imported to Cloud Datastore.
     * </pre>
     */
    default void importEntities(
        com.google.datastore.admin.v1.ImportEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportEntitiesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates the specified index.
     * A newly created index's initial state is `CREATING`. On completion of the
     * returned [google.longrunning.Operation][google.longrunning.Operation], the
     * state will be `READY`. If the index already exists, the call will return an
     * `ALREADY_EXISTS` status.
     * During index creation, the process could result in an error, in which
     * case the index will move to the `ERROR` state. The process can be recovered
     * by fixing the data that caused the error, removing the index with
     * [delete][google.datastore.admin.v1.DatastoreAdmin.DeleteIndex], then
     * re-creating the index with [create]
     * [google.datastore.admin.v1.DatastoreAdmin.CreateIndex].
     * Indexes with a single property cannot be created.
     * </pre>
     */
    default void createIndex(
        com.google.datastore.admin.v1.CreateIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateIndexMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing index.
     * An index can only be deleted if it is in a `READY` or `ERROR` state. On
     * successful execution of the request, the index will be in a `DELETING`
     * [state][google.datastore.admin.v1.Index.State]. And on completion of the
     * returned [google.longrunning.Operation][google.longrunning.Operation], the
     * index will be removed.
     * During index deletion, the process could result in an error, in which
     * case the index will move to the `ERROR` state. The process can be recovered
     * by fixing the data that caused the error, followed by calling
     * [delete][google.datastore.admin.v1.DatastoreAdmin.DeleteIndex] again.
     * </pre>
     */
    default void deleteIndex(
        com.google.datastore.admin.v1.DeleteIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteIndexMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an index.
     * </pre>
     */
    default void getIndex(
        com.google.datastore.admin.v1.GetIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.datastore.admin.v1.Index> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIndexMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the indexes that match the specified filters.  Datastore uses an
     * eventually consistent query to fetch the list of indexes and may
     * occasionally return stale results.
     * </pre>
     */
    default void listIndexes(
        com.google.datastore.admin.v1.ListIndexesRequest request,
        io.grpc.stub.StreamObserver<com.google.datastore.admin.v1.ListIndexesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListIndexesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DatastoreAdmin.
   *
   * <pre>
   * Google Cloud Datastore Admin API
   * The Datastore Admin API provides several admin services for Cloud Datastore.
   * Concepts: Project, namespace, kind, and entity as defined in the Google Cloud
   * Datastore API.
   * Operation: An Operation represents work being performed in the background.
   * EntityFilter: Allows specifying a subset of entities in a project. This is
   * specified as a combination of kinds and namespaces (either or both of which
   * may be all).
   * Export/Import Service:
   * - The Export/Import service provides the ability to copy all or a subset of
   * entities to/from Google Cloud Storage.
   * - Exported data may be imported into Cloud Datastore for any Google Cloud
   * Platform project. It is not restricted to the export source project. It is
   * possible to export from one project and then import into another.
   * - Exported data can also be loaded into Google BigQuery for analysis.
   * - Exports and imports are performed asynchronously. An Operation resource is
   * created for each export/import. The state (including any errors encountered)
   * of the export/import may be queried via the Operation resource.
   * Index Service:
   * - The index service manages Cloud Datastore composite indexes.
   * - Index creation and deletion are performed asynchronously.
   * An Operation resource is created for each such asynchronous operation.
   * The state of the operation (including any errors encountered)
   * may be queried via the Operation resource.
   * Operation Service:
   * - The Operations collection provides a record of actions performed for the
   * specified project (including any operations in progress). Operations are not
   * created directly but through calls on other collections or resources.
   * - An operation that is not yet done may be cancelled. The request to cancel
   * is asynchronous and the operation may continue to run for some time after the
   * request to cancel is made.
   * - An operation that is done may be deleted so that it is no longer listed as
   * part of the Operation collection.
   * - ListOperations returns all pending operations, but not completed
   * operations.
   * - Operations are created by service DatastoreAdmin, but are accessed via
   * service google.longrunning.Operations.
   * </pre>
   */
  public abstract static class DatastoreAdminImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DatastoreAdminGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DatastoreAdmin.
   *
   * <pre>
   * Google Cloud Datastore Admin API
   * The Datastore Admin API provides several admin services for Cloud Datastore.
   * Concepts: Project, namespace, kind, and entity as defined in the Google Cloud
   * Datastore API.
   * Operation: An Operation represents work being performed in the background.
   * EntityFilter: Allows specifying a subset of entities in a project. This is
   * specified as a combination of kinds and namespaces (either or both of which
   * may be all).
   * Export/Import Service:
   * - The Export/Import service provides the ability to copy all or a subset of
   * entities to/from Google Cloud Storage.
   * - Exported data may be imported into Cloud Datastore for any Google Cloud
   * Platform project. It is not restricted to the export source project. It is
   * possible to export from one project and then import into another.
   * - Exported data can also be loaded into Google BigQuery for analysis.
   * - Exports and imports are performed asynchronously. An Operation resource is
   * created for each export/import. The state (including any errors encountered)
   * of the export/import may be queried via the Operation resource.
   * Index Service:
   * - The index service manages Cloud Datastore composite indexes.
   * - Index creation and deletion are performed asynchronously.
   * An Operation resource is created for each such asynchronous operation.
   * The state of the operation (including any errors encountered)
   * may be queried via the Operation resource.
   * Operation Service:
   * - The Operations collection provides a record of actions performed for the
   * specified project (including any operations in progress). Operations are not
   * created directly but through calls on other collections or resources.
   * - An operation that is not yet done may be cancelled. The request to cancel
   * is asynchronous and the operation may continue to run for some time after the
   * request to cancel is made.
   * - An operation that is done may be deleted so that it is no longer listed as
   * part of the Operation collection.
   * - ListOperations returns all pending operations, but not completed
   * operations.
   * - Operations are created by service DatastoreAdmin, but are accessed via
   * service google.longrunning.Operations.
   * </pre>
   */
  public static final class DatastoreAdminStub
      extends io.grpc.stub.AbstractAsyncStub<DatastoreAdminStub> {
    private DatastoreAdminStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatastoreAdminStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatastoreAdminStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Exports a copy of all or a subset of entities from Google Cloud Datastore
     * to another storage system, such as Google Cloud Storage. Recent updates to
     * entities may not be reflected in the export. The export occurs in the
     * background and its progress can be monitored and managed via the
     * Operation resource that is created. The output of an export may only be
     * used once the associated operation is done. If an export operation is
     * cancelled before completion it may leave partial data behind in Google
     * Cloud Storage.
     * </pre>
     */
    public void exportEntities(
        com.google.datastore.admin.v1.ExportEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportEntitiesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports entities into Google Cloud Datastore. Existing entities with the
     * same key are overwritten. The import occurs in the background and its
     * progress can be monitored and managed via the Operation resource that is
     * created. If an ImportEntities operation is cancelled, it is possible
     * that a subset of the data has already been imported to Cloud Datastore.
     * </pre>
     */
    public void importEntities(
        com.google.datastore.admin.v1.ImportEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportEntitiesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates the specified index.
     * A newly created index's initial state is `CREATING`. On completion of the
     * returned [google.longrunning.Operation][google.longrunning.Operation], the
     * state will be `READY`. If the index already exists, the call will return an
     * `ALREADY_EXISTS` status.
     * During index creation, the process could result in an error, in which
     * case the index will move to the `ERROR` state. The process can be recovered
     * by fixing the data that caused the error, removing the index with
     * [delete][google.datastore.admin.v1.DatastoreAdmin.DeleteIndex], then
     * re-creating the index with [create]
     * [google.datastore.admin.v1.DatastoreAdmin.CreateIndex].
     * Indexes with a single property cannot be created.
     * </pre>
     */
    public void createIndex(
        com.google.datastore.admin.v1.CreateIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateIndexMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing index.
     * An index can only be deleted if it is in a `READY` or `ERROR` state. On
     * successful execution of the request, the index will be in a `DELETING`
     * [state][google.datastore.admin.v1.Index.State]. And on completion of the
     * returned [google.longrunning.Operation][google.longrunning.Operation], the
     * index will be removed.
     * During index deletion, the process could result in an error, in which
     * case the index will move to the `ERROR` state. The process can be recovered
     * by fixing the data that caused the error, followed by calling
     * [delete][google.datastore.admin.v1.DatastoreAdmin.DeleteIndex] again.
     * </pre>
     */
    public void deleteIndex(
        com.google.datastore.admin.v1.DeleteIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteIndexMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an index.
     * </pre>
     */
    public void getIndex(
        com.google.datastore.admin.v1.GetIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.datastore.admin.v1.Index> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIndexMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the indexes that match the specified filters.  Datastore uses an
     * eventually consistent query to fetch the list of indexes and may
     * occasionally return stale results.
     * </pre>
     */
    public void listIndexes(
        com.google.datastore.admin.v1.ListIndexesRequest request,
        io.grpc.stub.StreamObserver<com.google.datastore.admin.v1.ListIndexesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIndexesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DatastoreAdmin.
   *
   * <pre>
   * Google Cloud Datastore Admin API
   * The Datastore Admin API provides several admin services for Cloud Datastore.
   * Concepts: Project, namespace, kind, and entity as defined in the Google Cloud
   * Datastore API.
   * Operation: An Operation represents work being performed in the background.
   * EntityFilter: Allows specifying a subset of entities in a project. This is
   * specified as a combination of kinds and namespaces (either or both of which
   * may be all).
   * Export/Import Service:
   * - The Export/Import service provides the ability to copy all or a subset of
   * entities to/from Google Cloud Storage.
   * - Exported data may be imported into Cloud Datastore for any Google Cloud
   * Platform project. It is not restricted to the export source project. It is
   * possible to export from one project and then import into another.
   * - Exported data can also be loaded into Google BigQuery for analysis.
   * - Exports and imports are performed asynchronously. An Operation resource is
   * created for each export/import. The state (including any errors encountered)
   * of the export/import may be queried via the Operation resource.
   * Index Service:
   * - The index service manages Cloud Datastore composite indexes.
   * - Index creation and deletion are performed asynchronously.
   * An Operation resource is created for each such asynchronous operation.
   * The state of the operation (including any errors encountered)
   * may be queried via the Operation resource.
   * Operation Service:
   * - The Operations collection provides a record of actions performed for the
   * specified project (including any operations in progress). Operations are not
   * created directly but through calls on other collections or resources.
   * - An operation that is not yet done may be cancelled. The request to cancel
   * is asynchronous and the operation may continue to run for some time after the
   * request to cancel is made.
   * - An operation that is done may be deleted so that it is no longer listed as
   * part of the Operation collection.
   * - ListOperations returns all pending operations, but not completed
   * operations.
   * - Operations are created by service DatastoreAdmin, but are accessed via
   * service google.longrunning.Operations.
   * </pre>
   */
  public static final class DatastoreAdminBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DatastoreAdminBlockingStub> {
    private DatastoreAdminBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatastoreAdminBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatastoreAdminBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Exports a copy of all or a subset of entities from Google Cloud Datastore
     * to another storage system, such as Google Cloud Storage. Recent updates to
     * entities may not be reflected in the export. The export occurs in the
     * background and its progress can be monitored and managed via the
     * Operation resource that is created. The output of an export may only be
     * used once the associated operation is done. If an export operation is
     * cancelled before completion it may leave partial data behind in Google
     * Cloud Storage.
     * </pre>
     */
    public com.google.longrunning.Operation exportEntities(
        com.google.datastore.admin.v1.ExportEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportEntitiesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports entities into Google Cloud Datastore. Existing entities with the
     * same key are overwritten. The import occurs in the background and its
     * progress can be monitored and managed via the Operation resource that is
     * created. If an ImportEntities operation is cancelled, it is possible
     * that a subset of the data has already been imported to Cloud Datastore.
     * </pre>
     */
    public com.google.longrunning.Operation importEntities(
        com.google.datastore.admin.v1.ImportEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportEntitiesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates the specified index.
     * A newly created index's initial state is `CREATING`. On completion of the
     * returned [google.longrunning.Operation][google.longrunning.Operation], the
     * state will be `READY`. If the index already exists, the call will return an
     * `ALREADY_EXISTS` status.
     * During index creation, the process could result in an error, in which
     * case the index will move to the `ERROR` state. The process can be recovered
     * by fixing the data that caused the error, removing the index with
     * [delete][google.datastore.admin.v1.DatastoreAdmin.DeleteIndex], then
     * re-creating the index with [create]
     * [google.datastore.admin.v1.DatastoreAdmin.CreateIndex].
     * Indexes with a single property cannot be created.
     * </pre>
     */
    public com.google.longrunning.Operation createIndex(
        com.google.datastore.admin.v1.CreateIndexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIndexMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing index.
     * An index can only be deleted if it is in a `READY` or `ERROR` state. On
     * successful execution of the request, the index will be in a `DELETING`
     * [state][google.datastore.admin.v1.Index.State]. And on completion of the
     * returned [google.longrunning.Operation][google.longrunning.Operation], the
     * index will be removed.
     * During index deletion, the process could result in an error, in which
     * case the index will move to the `ERROR` state. The process can be recovered
     * by fixing the data that caused the error, followed by calling
     * [delete][google.datastore.admin.v1.DatastoreAdmin.DeleteIndex] again.
     * </pre>
     */
    public com.google.longrunning.Operation deleteIndex(
        com.google.datastore.admin.v1.DeleteIndexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIndexMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an index.
     * </pre>
     */
    public com.google.datastore.admin.v1.Index getIndex(
        com.google.datastore.admin.v1.GetIndexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIndexMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the indexes that match the specified filters.  Datastore uses an
     * eventually consistent query to fetch the list of indexes and may
     * occasionally return stale results.
     * </pre>
     */
    public com.google.datastore.admin.v1.ListIndexesResponse listIndexes(
        com.google.datastore.admin.v1.ListIndexesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIndexesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DatastoreAdmin.
   *
   * <pre>
   * Google Cloud Datastore Admin API
   * The Datastore Admin API provides several admin services for Cloud Datastore.
   * Concepts: Project, namespace, kind, and entity as defined in the Google Cloud
   * Datastore API.
   * Operation: An Operation represents work being performed in the background.
   * EntityFilter: Allows specifying a subset of entities in a project. This is
   * specified as a combination of kinds and namespaces (either or both of which
   * may be all).
   * Export/Import Service:
   * - The Export/Import service provides the ability to copy all or a subset of
   * entities to/from Google Cloud Storage.
   * - Exported data may be imported into Cloud Datastore for any Google Cloud
   * Platform project. It is not restricted to the export source project. It is
   * possible to export from one project and then import into another.
   * - Exported data can also be loaded into Google BigQuery for analysis.
   * - Exports and imports are performed asynchronously. An Operation resource is
   * created for each export/import. The state (including any errors encountered)
   * of the export/import may be queried via the Operation resource.
   * Index Service:
   * - The index service manages Cloud Datastore composite indexes.
   * - Index creation and deletion are performed asynchronously.
   * An Operation resource is created for each such asynchronous operation.
   * The state of the operation (including any errors encountered)
   * may be queried via the Operation resource.
   * Operation Service:
   * - The Operations collection provides a record of actions performed for the
   * specified project (including any operations in progress). Operations are not
   * created directly but through calls on other collections or resources.
   * - An operation that is not yet done may be cancelled. The request to cancel
   * is asynchronous and the operation may continue to run for some time after the
   * request to cancel is made.
   * - An operation that is done may be deleted so that it is no longer listed as
   * part of the Operation collection.
   * - ListOperations returns all pending operations, but not completed
   * operations.
   * - Operations are created by service DatastoreAdmin, but are accessed via
   * service google.longrunning.Operations.
   * </pre>
   */
  public static final class DatastoreAdminFutureStub
      extends io.grpc.stub.AbstractFutureStub<DatastoreAdminFutureStub> {
    private DatastoreAdminFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatastoreAdminFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatastoreAdminFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Exports a copy of all or a subset of entities from Google Cloud Datastore
     * to another storage system, such as Google Cloud Storage. Recent updates to
     * entities may not be reflected in the export. The export occurs in the
     * background and its progress can be monitored and managed via the
     * Operation resource that is created. The output of an export may only be
     * used once the associated operation is done. If an export operation is
     * cancelled before completion it may leave partial data behind in Google
     * Cloud Storage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportEntities(com.google.datastore.admin.v1.ExportEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportEntitiesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports entities into Google Cloud Datastore. Existing entities with the
     * same key are overwritten. The import occurs in the background and its
     * progress can be monitored and managed via the Operation resource that is
     * created. If an ImportEntities operation is cancelled, it is possible
     * that a subset of the data has already been imported to Cloud Datastore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importEntities(com.google.datastore.admin.v1.ImportEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportEntitiesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates the specified index.
     * A newly created index's initial state is `CREATING`. On completion of the
     * returned [google.longrunning.Operation][google.longrunning.Operation], the
     * state will be `READY`. If the index already exists, the call will return an
     * `ALREADY_EXISTS` status.
     * During index creation, the process could result in an error, in which
     * case the index will move to the `ERROR` state. The process can be recovered
     * by fixing the data that caused the error, removing the index with
     * [delete][google.datastore.admin.v1.DatastoreAdmin.DeleteIndex], then
     * re-creating the index with [create]
     * [google.datastore.admin.v1.DatastoreAdmin.CreateIndex].
     * Indexes with a single property cannot be created.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createIndex(com.google.datastore.admin.v1.CreateIndexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateIndexMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing index.
     * An index can only be deleted if it is in a `READY` or `ERROR` state. On
     * successful execution of the request, the index will be in a `DELETING`
     * [state][google.datastore.admin.v1.Index.State]. And on completion of the
     * returned [google.longrunning.Operation][google.longrunning.Operation], the
     * index will be removed.
     * During index deletion, the process could result in an error, in which
     * case the index will move to the `ERROR` state. The process can be recovered
     * by fixing the data that caused the error, followed by calling
     * [delete][google.datastore.admin.v1.DatastoreAdmin.DeleteIndex] again.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteIndex(com.google.datastore.admin.v1.DeleteIndexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteIndexMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an index.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.datastore.admin.v1.Index>
        getIndex(com.google.datastore.admin.v1.GetIndexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIndexMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the indexes that match the specified filters.  Datastore uses an
     * eventually consistent query to fetch the list of indexes and may
     * occasionally return stale results.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.datastore.admin.v1.ListIndexesResponse>
        listIndexes(com.google.datastore.admin.v1.ListIndexesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIndexesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EXPORT_ENTITIES = 0;
  private static final int METHODID_IMPORT_ENTITIES = 1;
  private static final int METHODID_CREATE_INDEX = 2;
  private static final int METHODID_DELETE_INDEX = 3;
  private static final int METHODID_GET_INDEX = 4;
  private static final int METHODID_LIST_INDEXES = 5;

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
        case METHODID_EXPORT_ENTITIES:
          serviceImpl.exportEntities(
              (com.google.datastore.admin.v1.ExportEntitiesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_ENTITIES:
          serviceImpl.importEntities(
              (com.google.datastore.admin.v1.ImportEntitiesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_INDEX:
          serviceImpl.createIndex(
              (com.google.datastore.admin.v1.CreateIndexRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INDEX:
          serviceImpl.deleteIndex(
              (com.google.datastore.admin.v1.DeleteIndexRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_INDEX:
          serviceImpl.getIndex(
              (com.google.datastore.admin.v1.GetIndexRequest) request,
              (io.grpc.stub.StreamObserver<com.google.datastore.admin.v1.Index>) responseObserver);
          break;
        case METHODID_LIST_INDEXES:
          serviceImpl.listIndexes(
              (com.google.datastore.admin.v1.ListIndexesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.datastore.admin.v1.ListIndexesResponse>)
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getExportEntitiesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.datastore.admin.v1.ExportEntitiesRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_ENTITIES)))
        .addMethod(
            getImportEntitiesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.datastore.admin.v1.ImportEntitiesRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_ENTITIES)))
        .addMethod(
            getCreateIndexMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.datastore.admin.v1.CreateIndexRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_INDEX)))
        .addMethod(
            getDeleteIndexMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.datastore.admin.v1.DeleteIndexRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_INDEX)))
        .addMethod(
            getGetIndexMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.datastore.admin.v1.GetIndexRequest,
                    com.google.datastore.admin.v1.Index>(service, METHODID_GET_INDEX)))
        .addMethod(
            getListIndexesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.datastore.admin.v1.ListIndexesRequest,
                    com.google.datastore.admin.v1.ListIndexesResponse>(
                    service, METHODID_LIST_INDEXES)))
        .build();
  }

  private abstract static class DatastoreAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DatastoreAdminBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.datastore.admin.v1.DatastoreAdminProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DatastoreAdmin");
    }
  }

  private static final class DatastoreAdminFileDescriptorSupplier
      extends DatastoreAdminBaseDescriptorSupplier {
    DatastoreAdminFileDescriptorSupplier() {}
  }

  private static final class DatastoreAdminMethodDescriptorSupplier
      extends DatastoreAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DatastoreAdminMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DatastoreAdminGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DatastoreAdminFileDescriptorSupplier())
                      .addMethod(getExportEntitiesMethod())
                      .addMethod(getImportEntitiesMethod())
                      .addMethod(getCreateIndexMethod())
                      .addMethod(getDeleteIndexMethod())
                      .addMethod(getGetIndexMethod())
                      .addMethod(getListIndexesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
