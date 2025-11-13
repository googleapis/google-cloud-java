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
package com.google.firestore.admin.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Cloud Firestore Admin API.
 * This API provides several administrative services for Cloud Firestore.
 * Project, Database, Namespace, Collection, Collection Group, and Document are
 * used as defined in the Google Cloud Firestore API.
 * Operation: An Operation represents work being performed in the background.
 * The index service manages Cloud Firestore indexes.
 * Index creation is performed asynchronously.
 * An Operation resource is created for each such asynchronous operation.
 * The state of the operation (including any errors encountered)
 * may be queried via the Operation resource.
 * The Operations collection provides a record of actions performed for the
 * specified Project (including any Operations in progress). Operations are not
 * created directly but through calls on other collections or resources.
 * An Operation that is done may be deleted so that it is no longer listed as
 * part of the Operation collection. Operations are garbage collected after
 * 30 days. By default, ListOperations will only return in progress and failed
 * operations. To list completed operation, issue a ListOperations request with
 * the filter `done: true`.
 * Operations are created by service `FirestoreAdmin`, but are accessed via
 * service `google.longrunning.Operations`.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class FirestoreAdminGrpc {

  private FirestoreAdminGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.firestore.admin.v1.FirestoreAdmin";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.CreateIndexRequest, com.google.longrunning.Operation>
      getCreateIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateIndex",
      requestType = com.google.firestore.admin.v1.CreateIndexRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.CreateIndexRequest, com.google.longrunning.Operation>
      getCreateIndexMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateIndex"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ListIndexesRequest,
          com.google.firestore.admin.v1.ListIndexesResponse>
      getListIndexesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIndexes",
      requestType = com.google.firestore.admin.v1.ListIndexesRequest.class,
      responseType = com.google.firestore.admin.v1.ListIndexesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ListIndexesRequest,
          com.google.firestore.admin.v1.ListIndexesResponse>
      getListIndexesMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListIndexes"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.GetIndexRequest, com.google.firestore.admin.v1.Index>
      getGetIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIndex",
      requestType = com.google.firestore.admin.v1.GetIndexRequest.class,
      responseType = com.google.firestore.admin.v1.Index.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.GetIndexRequest, com.google.firestore.admin.v1.Index>
      getGetIndexMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIndex"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.DeleteIndexRequest, com.google.protobuf.Empty>
      getDeleteIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteIndex",
      requestType = com.google.firestore.admin.v1.DeleteIndexRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.DeleteIndexRequest, com.google.protobuf.Empty>
      getDeleteIndexMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteIndex"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.GetFieldRequest, com.google.firestore.admin.v1.Field>
      getGetFieldMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetField",
      requestType = com.google.firestore.admin.v1.GetFieldRequest.class,
      responseType = com.google.firestore.admin.v1.Field.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.GetFieldRequest, com.google.firestore.admin.v1.Field>
      getGetFieldMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetField"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.UpdateFieldRequest, com.google.longrunning.Operation>
      getUpdateFieldMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateField",
      requestType = com.google.firestore.admin.v1.UpdateFieldRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.UpdateFieldRequest, com.google.longrunning.Operation>
      getUpdateFieldMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateField"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ListFieldsRequest,
          com.google.firestore.admin.v1.ListFieldsResponse>
      getListFieldsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFields",
      requestType = com.google.firestore.admin.v1.ListFieldsRequest.class,
      responseType = com.google.firestore.admin.v1.ListFieldsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ListFieldsRequest,
          com.google.firestore.admin.v1.ListFieldsResponse>
      getListFieldsMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFields"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ExportDocumentsRequest, com.google.longrunning.Operation>
      getExportDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportDocuments",
      requestType = com.google.firestore.admin.v1.ExportDocumentsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ExportDocumentsRequest, com.google.longrunning.Operation>
      getExportDocumentsMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportDocuments"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ImportDocumentsRequest, com.google.longrunning.Operation>
      getImportDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportDocuments",
      requestType = com.google.firestore.admin.v1.ImportDocumentsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ImportDocumentsRequest, com.google.longrunning.Operation>
      getImportDocumentsMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportDocuments"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.BulkDeleteDocumentsRequest,
          com.google.longrunning.Operation>
      getBulkDeleteDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BulkDeleteDocuments",
      requestType = com.google.firestore.admin.v1.BulkDeleteDocumentsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.BulkDeleteDocumentsRequest,
          com.google.longrunning.Operation>
      getBulkDeleteDocumentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.BulkDeleteDocumentsRequest,
            com.google.longrunning.Operation>
        getBulkDeleteDocumentsMethod;
    if ((getBulkDeleteDocumentsMethod = FirestoreAdminGrpc.getBulkDeleteDocumentsMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getBulkDeleteDocumentsMethod = FirestoreAdminGrpc.getBulkDeleteDocumentsMethod)
            == null) {
          FirestoreAdminGrpc.getBulkDeleteDocumentsMethod =
              getBulkDeleteDocumentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.BulkDeleteDocumentsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BulkDeleteDocuments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.BulkDeleteDocumentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("BulkDeleteDocuments"))
                      .build();
        }
      }
    }
    return getBulkDeleteDocumentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.CreateDatabaseRequest, com.google.longrunning.Operation>
      getCreateDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDatabase",
      requestType = com.google.firestore.admin.v1.CreateDatabaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.CreateDatabaseRequest, com.google.longrunning.Operation>
      getCreateDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.CreateDatabaseRequest, com.google.longrunning.Operation>
        getCreateDatabaseMethod;
    if ((getCreateDatabaseMethod = FirestoreAdminGrpc.getCreateDatabaseMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getCreateDatabaseMethod = FirestoreAdminGrpc.getCreateDatabaseMethod) == null) {
          FirestoreAdminGrpc.getCreateDatabaseMethod =
              getCreateDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.CreateDatabaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.CreateDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("CreateDatabase"))
                      .build();
        }
      }
    }
    return getCreateDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.GetDatabaseRequest, com.google.firestore.admin.v1.Database>
      getGetDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDatabase",
      requestType = com.google.firestore.admin.v1.GetDatabaseRequest.class,
      responseType = com.google.firestore.admin.v1.Database.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.GetDatabaseRequest, com.google.firestore.admin.v1.Database>
      getGetDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.GetDatabaseRequest,
            com.google.firestore.admin.v1.Database>
        getGetDatabaseMethod;
    if ((getGetDatabaseMethod = FirestoreAdminGrpc.getGetDatabaseMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getGetDatabaseMethod = FirestoreAdminGrpc.getGetDatabaseMethod) == null) {
          FirestoreAdminGrpc.getGetDatabaseMethod =
              getGetDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.GetDatabaseRequest,
                          com.google.firestore.admin.v1.Database>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.GetDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.Database.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("GetDatabase"))
                      .build();
        }
      }
    }
    return getGetDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ListDatabasesRequest,
          com.google.firestore.admin.v1.ListDatabasesResponse>
      getListDatabasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDatabases",
      requestType = com.google.firestore.admin.v1.ListDatabasesRequest.class,
      responseType = com.google.firestore.admin.v1.ListDatabasesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ListDatabasesRequest,
          com.google.firestore.admin.v1.ListDatabasesResponse>
      getListDatabasesMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.ListDatabasesRequest,
            com.google.firestore.admin.v1.ListDatabasesResponse>
        getListDatabasesMethod;
    if ((getListDatabasesMethod = FirestoreAdminGrpc.getListDatabasesMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getListDatabasesMethod = FirestoreAdminGrpc.getListDatabasesMethod) == null) {
          FirestoreAdminGrpc.getListDatabasesMethod =
              getListDatabasesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.ListDatabasesRequest,
                          com.google.firestore.admin.v1.ListDatabasesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDatabases"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.ListDatabasesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.ListDatabasesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("ListDatabases"))
                      .build();
        }
      }
    }
    return getListDatabasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.UpdateDatabaseRequest, com.google.longrunning.Operation>
      getUpdateDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDatabase",
      requestType = com.google.firestore.admin.v1.UpdateDatabaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.UpdateDatabaseRequest, com.google.longrunning.Operation>
      getUpdateDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.UpdateDatabaseRequest, com.google.longrunning.Operation>
        getUpdateDatabaseMethod;
    if ((getUpdateDatabaseMethod = FirestoreAdminGrpc.getUpdateDatabaseMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getUpdateDatabaseMethod = FirestoreAdminGrpc.getUpdateDatabaseMethod) == null) {
          FirestoreAdminGrpc.getUpdateDatabaseMethod =
              getUpdateDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.UpdateDatabaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.UpdateDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("UpdateDatabase"))
                      .build();
        }
      }
    }
    return getUpdateDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.DeleteDatabaseRequest, com.google.longrunning.Operation>
      getDeleteDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDatabase",
      requestType = com.google.firestore.admin.v1.DeleteDatabaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.DeleteDatabaseRequest, com.google.longrunning.Operation>
      getDeleteDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.DeleteDatabaseRequest, com.google.longrunning.Operation>
        getDeleteDatabaseMethod;
    if ((getDeleteDatabaseMethod = FirestoreAdminGrpc.getDeleteDatabaseMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getDeleteDatabaseMethod = FirestoreAdminGrpc.getDeleteDatabaseMethod) == null) {
          FirestoreAdminGrpc.getDeleteDatabaseMethod =
              getDeleteDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.DeleteDatabaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.DeleteDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("DeleteDatabase"))
                      .build();
        }
      }
    }
    return getDeleteDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.CreateUserCredsRequest,
          com.google.firestore.admin.v1.UserCreds>
      getCreateUserCredsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUserCreds",
      requestType = com.google.firestore.admin.v1.CreateUserCredsRequest.class,
      responseType = com.google.firestore.admin.v1.UserCreds.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.CreateUserCredsRequest,
          com.google.firestore.admin.v1.UserCreds>
      getCreateUserCredsMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.CreateUserCredsRequest,
            com.google.firestore.admin.v1.UserCreds>
        getCreateUserCredsMethod;
    if ((getCreateUserCredsMethod = FirestoreAdminGrpc.getCreateUserCredsMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getCreateUserCredsMethod = FirestoreAdminGrpc.getCreateUserCredsMethod) == null) {
          FirestoreAdminGrpc.getCreateUserCredsMethod =
              getCreateUserCredsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.CreateUserCredsRequest,
                          com.google.firestore.admin.v1.UserCreds>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUserCreds"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.CreateUserCredsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.UserCreds.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("CreateUserCreds"))
                      .build();
        }
      }
    }
    return getCreateUserCredsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.GetUserCredsRequest,
          com.google.firestore.admin.v1.UserCreds>
      getGetUserCredsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserCreds",
      requestType = com.google.firestore.admin.v1.GetUserCredsRequest.class,
      responseType = com.google.firestore.admin.v1.UserCreds.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.GetUserCredsRequest,
          com.google.firestore.admin.v1.UserCreds>
      getGetUserCredsMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.GetUserCredsRequest,
            com.google.firestore.admin.v1.UserCreds>
        getGetUserCredsMethod;
    if ((getGetUserCredsMethod = FirestoreAdminGrpc.getGetUserCredsMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getGetUserCredsMethod = FirestoreAdminGrpc.getGetUserCredsMethod) == null) {
          FirestoreAdminGrpc.getGetUserCredsMethod =
              getGetUserCredsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.GetUserCredsRequest,
                          com.google.firestore.admin.v1.UserCreds>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserCreds"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.GetUserCredsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.UserCreds.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("GetUserCreds"))
                      .build();
        }
      }
    }
    return getGetUserCredsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ListUserCredsRequest,
          com.google.firestore.admin.v1.ListUserCredsResponse>
      getListUserCredsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUserCreds",
      requestType = com.google.firestore.admin.v1.ListUserCredsRequest.class,
      responseType = com.google.firestore.admin.v1.ListUserCredsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ListUserCredsRequest,
          com.google.firestore.admin.v1.ListUserCredsResponse>
      getListUserCredsMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.ListUserCredsRequest,
            com.google.firestore.admin.v1.ListUserCredsResponse>
        getListUserCredsMethod;
    if ((getListUserCredsMethod = FirestoreAdminGrpc.getListUserCredsMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getListUserCredsMethod = FirestoreAdminGrpc.getListUserCredsMethod) == null) {
          FirestoreAdminGrpc.getListUserCredsMethod =
              getListUserCredsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.ListUserCredsRequest,
                          com.google.firestore.admin.v1.ListUserCredsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUserCreds"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.ListUserCredsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.ListUserCredsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("ListUserCreds"))
                      .build();
        }
      }
    }
    return getListUserCredsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.EnableUserCredsRequest,
          com.google.firestore.admin.v1.UserCreds>
      getEnableUserCredsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnableUserCreds",
      requestType = com.google.firestore.admin.v1.EnableUserCredsRequest.class,
      responseType = com.google.firestore.admin.v1.UserCreds.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.EnableUserCredsRequest,
          com.google.firestore.admin.v1.UserCreds>
      getEnableUserCredsMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.EnableUserCredsRequest,
            com.google.firestore.admin.v1.UserCreds>
        getEnableUserCredsMethod;
    if ((getEnableUserCredsMethod = FirestoreAdminGrpc.getEnableUserCredsMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getEnableUserCredsMethod = FirestoreAdminGrpc.getEnableUserCredsMethod) == null) {
          FirestoreAdminGrpc.getEnableUserCredsMethod =
              getEnableUserCredsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.EnableUserCredsRequest,
                          com.google.firestore.admin.v1.UserCreds>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EnableUserCreds"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.EnableUserCredsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.UserCreds.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("EnableUserCreds"))
                      .build();
        }
      }
    }
    return getEnableUserCredsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.DisableUserCredsRequest,
          com.google.firestore.admin.v1.UserCreds>
      getDisableUserCredsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisableUserCreds",
      requestType = com.google.firestore.admin.v1.DisableUserCredsRequest.class,
      responseType = com.google.firestore.admin.v1.UserCreds.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.DisableUserCredsRequest,
          com.google.firestore.admin.v1.UserCreds>
      getDisableUserCredsMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.DisableUserCredsRequest,
            com.google.firestore.admin.v1.UserCreds>
        getDisableUserCredsMethod;
    if ((getDisableUserCredsMethod = FirestoreAdminGrpc.getDisableUserCredsMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getDisableUserCredsMethod = FirestoreAdminGrpc.getDisableUserCredsMethod) == null) {
          FirestoreAdminGrpc.getDisableUserCredsMethod =
              getDisableUserCredsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.DisableUserCredsRequest,
                          com.google.firestore.admin.v1.UserCreds>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DisableUserCreds"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.DisableUserCredsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.UserCreds.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("DisableUserCreds"))
                      .build();
        }
      }
    }
    return getDisableUserCredsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ResetUserPasswordRequest,
          com.google.firestore.admin.v1.UserCreds>
      getResetUserPasswordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResetUserPassword",
      requestType = com.google.firestore.admin.v1.ResetUserPasswordRequest.class,
      responseType = com.google.firestore.admin.v1.UserCreds.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ResetUserPasswordRequest,
          com.google.firestore.admin.v1.UserCreds>
      getResetUserPasswordMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.ResetUserPasswordRequest,
            com.google.firestore.admin.v1.UserCreds>
        getResetUserPasswordMethod;
    if ((getResetUserPasswordMethod = FirestoreAdminGrpc.getResetUserPasswordMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getResetUserPasswordMethod = FirestoreAdminGrpc.getResetUserPasswordMethod) == null) {
          FirestoreAdminGrpc.getResetUserPasswordMethod =
              getResetUserPasswordMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.ResetUserPasswordRequest,
                          com.google.firestore.admin.v1.UserCreds>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResetUserPassword"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.ResetUserPasswordRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.UserCreds.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("ResetUserPassword"))
                      .build();
        }
      }
    }
    return getResetUserPasswordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.DeleteUserCredsRequest, com.google.protobuf.Empty>
      getDeleteUserCredsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUserCreds",
      requestType = com.google.firestore.admin.v1.DeleteUserCredsRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.DeleteUserCredsRequest, com.google.protobuf.Empty>
      getDeleteUserCredsMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.DeleteUserCredsRequest, com.google.protobuf.Empty>
        getDeleteUserCredsMethod;
    if ((getDeleteUserCredsMethod = FirestoreAdminGrpc.getDeleteUserCredsMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getDeleteUserCredsMethod = FirestoreAdminGrpc.getDeleteUserCredsMethod) == null) {
          FirestoreAdminGrpc.getDeleteUserCredsMethod =
              getDeleteUserCredsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.DeleteUserCredsRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUserCreds"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.DeleteUserCredsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("DeleteUserCreds"))
                      .build();
        }
      }
    }
    return getDeleteUserCredsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.GetBackupRequest, com.google.firestore.admin.v1.Backup>
      getGetBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackup",
      requestType = com.google.firestore.admin.v1.GetBackupRequest.class,
      responseType = com.google.firestore.admin.v1.Backup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.GetBackupRequest, com.google.firestore.admin.v1.Backup>
      getGetBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.GetBackupRequest, com.google.firestore.admin.v1.Backup>
        getGetBackupMethod;
    if ((getGetBackupMethod = FirestoreAdminGrpc.getGetBackupMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getGetBackupMethod = FirestoreAdminGrpc.getGetBackupMethod) == null) {
          FirestoreAdminGrpc.getGetBackupMethod =
              getGetBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.GetBackupRequest,
                          com.google.firestore.admin.v1.Backup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.GetBackupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.Backup.getDefaultInstance()))
                      .setSchemaDescriptor(new FirestoreAdminMethodDescriptorSupplier("GetBackup"))
                      .build();
        }
      }
    }
    return getGetBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ListBackupsRequest,
          com.google.firestore.admin.v1.ListBackupsResponse>
      getListBackupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackups",
      requestType = com.google.firestore.admin.v1.ListBackupsRequest.class,
      responseType = com.google.firestore.admin.v1.ListBackupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ListBackupsRequest,
          com.google.firestore.admin.v1.ListBackupsResponse>
      getListBackupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.ListBackupsRequest,
            com.google.firestore.admin.v1.ListBackupsResponse>
        getListBackupsMethod;
    if ((getListBackupsMethod = FirestoreAdminGrpc.getListBackupsMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getListBackupsMethod = FirestoreAdminGrpc.getListBackupsMethod) == null) {
          FirestoreAdminGrpc.getListBackupsMethod =
              getListBackupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.ListBackupsRequest,
                          com.google.firestore.admin.v1.ListBackupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBackups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.ListBackupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.ListBackupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("ListBackups"))
                      .build();
        }
      }
    }
    return getListBackupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.DeleteBackupRequest, com.google.protobuf.Empty>
      getDeleteBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackup",
      requestType = com.google.firestore.admin.v1.DeleteBackupRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.DeleteBackupRequest, com.google.protobuf.Empty>
      getDeleteBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.DeleteBackupRequest, com.google.protobuf.Empty>
        getDeleteBackupMethod;
    if ((getDeleteBackupMethod = FirestoreAdminGrpc.getDeleteBackupMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getDeleteBackupMethod = FirestoreAdminGrpc.getDeleteBackupMethod) == null) {
          FirestoreAdminGrpc.getDeleteBackupMethod =
              getDeleteBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.DeleteBackupRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.DeleteBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("DeleteBackup"))
                      .build();
        }
      }
    }
    return getDeleteBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.RestoreDatabaseRequest, com.google.longrunning.Operation>
      getRestoreDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestoreDatabase",
      requestType = com.google.firestore.admin.v1.RestoreDatabaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.RestoreDatabaseRequest, com.google.longrunning.Operation>
      getRestoreDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.RestoreDatabaseRequest, com.google.longrunning.Operation>
        getRestoreDatabaseMethod;
    if ((getRestoreDatabaseMethod = FirestoreAdminGrpc.getRestoreDatabaseMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getRestoreDatabaseMethod = FirestoreAdminGrpc.getRestoreDatabaseMethod) == null) {
          FirestoreAdminGrpc.getRestoreDatabaseMethod =
              getRestoreDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.RestoreDatabaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestoreDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.RestoreDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("RestoreDatabase"))
                      .build();
        }
      }
    }
    return getRestoreDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.CreateBackupScheduleRequest,
          com.google.firestore.admin.v1.BackupSchedule>
      getCreateBackupScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackupSchedule",
      requestType = com.google.firestore.admin.v1.CreateBackupScheduleRequest.class,
      responseType = com.google.firestore.admin.v1.BackupSchedule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.CreateBackupScheduleRequest,
          com.google.firestore.admin.v1.BackupSchedule>
      getCreateBackupScheduleMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.CreateBackupScheduleRequest,
            com.google.firestore.admin.v1.BackupSchedule>
        getCreateBackupScheduleMethod;
    if ((getCreateBackupScheduleMethod = FirestoreAdminGrpc.getCreateBackupScheduleMethod)
        == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getCreateBackupScheduleMethod = FirestoreAdminGrpc.getCreateBackupScheduleMethod)
            == null) {
          FirestoreAdminGrpc.getCreateBackupScheduleMethod =
              getCreateBackupScheduleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.CreateBackupScheduleRequest,
                          com.google.firestore.admin.v1.BackupSchedule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateBackupSchedule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.CreateBackupScheduleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.BackupSchedule.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("CreateBackupSchedule"))
                      .build();
        }
      }
    }
    return getCreateBackupScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.GetBackupScheduleRequest,
          com.google.firestore.admin.v1.BackupSchedule>
      getGetBackupScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackupSchedule",
      requestType = com.google.firestore.admin.v1.GetBackupScheduleRequest.class,
      responseType = com.google.firestore.admin.v1.BackupSchedule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.GetBackupScheduleRequest,
          com.google.firestore.admin.v1.BackupSchedule>
      getGetBackupScheduleMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.GetBackupScheduleRequest,
            com.google.firestore.admin.v1.BackupSchedule>
        getGetBackupScheduleMethod;
    if ((getGetBackupScheduleMethod = FirestoreAdminGrpc.getGetBackupScheduleMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getGetBackupScheduleMethod = FirestoreAdminGrpc.getGetBackupScheduleMethod) == null) {
          FirestoreAdminGrpc.getGetBackupScheduleMethod =
              getGetBackupScheduleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.GetBackupScheduleRequest,
                          com.google.firestore.admin.v1.BackupSchedule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackupSchedule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.GetBackupScheduleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.BackupSchedule.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("GetBackupSchedule"))
                      .build();
        }
      }
    }
    return getGetBackupScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ListBackupSchedulesRequest,
          com.google.firestore.admin.v1.ListBackupSchedulesResponse>
      getListBackupSchedulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackupSchedules",
      requestType = com.google.firestore.admin.v1.ListBackupSchedulesRequest.class,
      responseType = com.google.firestore.admin.v1.ListBackupSchedulesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.ListBackupSchedulesRequest,
          com.google.firestore.admin.v1.ListBackupSchedulesResponse>
      getListBackupSchedulesMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.ListBackupSchedulesRequest,
            com.google.firestore.admin.v1.ListBackupSchedulesResponse>
        getListBackupSchedulesMethod;
    if ((getListBackupSchedulesMethod = FirestoreAdminGrpc.getListBackupSchedulesMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getListBackupSchedulesMethod = FirestoreAdminGrpc.getListBackupSchedulesMethod)
            == null) {
          FirestoreAdminGrpc.getListBackupSchedulesMethod =
              getListBackupSchedulesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.ListBackupSchedulesRequest,
                          com.google.firestore.admin.v1.ListBackupSchedulesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListBackupSchedules"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.ListBackupSchedulesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.ListBackupSchedulesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("ListBackupSchedules"))
                      .build();
        }
      }
    }
    return getListBackupSchedulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.UpdateBackupScheduleRequest,
          com.google.firestore.admin.v1.BackupSchedule>
      getUpdateBackupScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackupSchedule",
      requestType = com.google.firestore.admin.v1.UpdateBackupScheduleRequest.class,
      responseType = com.google.firestore.admin.v1.BackupSchedule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.UpdateBackupScheduleRequest,
          com.google.firestore.admin.v1.BackupSchedule>
      getUpdateBackupScheduleMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.UpdateBackupScheduleRequest,
            com.google.firestore.admin.v1.BackupSchedule>
        getUpdateBackupScheduleMethod;
    if ((getUpdateBackupScheduleMethod = FirestoreAdminGrpc.getUpdateBackupScheduleMethod)
        == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getUpdateBackupScheduleMethod = FirestoreAdminGrpc.getUpdateBackupScheduleMethod)
            == null) {
          FirestoreAdminGrpc.getUpdateBackupScheduleMethod =
              getUpdateBackupScheduleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.UpdateBackupScheduleRequest,
                          com.google.firestore.admin.v1.BackupSchedule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateBackupSchedule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.UpdateBackupScheduleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.BackupSchedule.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("UpdateBackupSchedule"))
                      .build();
        }
      }
    }
    return getUpdateBackupScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.DeleteBackupScheduleRequest, com.google.protobuf.Empty>
      getDeleteBackupScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackupSchedule",
      requestType = com.google.firestore.admin.v1.DeleteBackupScheduleRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.DeleteBackupScheduleRequest, com.google.protobuf.Empty>
      getDeleteBackupScheduleMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.DeleteBackupScheduleRequest, com.google.protobuf.Empty>
        getDeleteBackupScheduleMethod;
    if ((getDeleteBackupScheduleMethod = FirestoreAdminGrpc.getDeleteBackupScheduleMethod)
        == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getDeleteBackupScheduleMethod = FirestoreAdminGrpc.getDeleteBackupScheduleMethod)
            == null) {
          FirestoreAdminGrpc.getDeleteBackupScheduleMethod =
              getDeleteBackupScheduleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.DeleteBackupScheduleRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteBackupSchedule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.DeleteBackupScheduleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("DeleteBackupSchedule"))
                      .build();
        }
      }
    }
    return getDeleteBackupScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.CloneDatabaseRequest, com.google.longrunning.Operation>
      getCloneDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CloneDatabase",
      requestType = com.google.firestore.admin.v1.CloneDatabaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.firestore.admin.v1.CloneDatabaseRequest, com.google.longrunning.Operation>
      getCloneDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.firestore.admin.v1.CloneDatabaseRequest, com.google.longrunning.Operation>
        getCloneDatabaseMethod;
    if ((getCloneDatabaseMethod = FirestoreAdminGrpc.getCloneDatabaseMethod) == null) {
      synchronized (FirestoreAdminGrpc.class) {
        if ((getCloneDatabaseMethod = FirestoreAdminGrpc.getCloneDatabaseMethod) == null) {
          FirestoreAdminGrpc.getCloneDatabaseMethod =
              getCloneDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.firestore.admin.v1.CloneDatabaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CloneDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.firestore.admin.v1.CloneDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirestoreAdminMethodDescriptorSupplier("CloneDatabase"))
                      .build();
        }
      }
    }
    return getCloneDatabaseMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static FirestoreAdminStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FirestoreAdminStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FirestoreAdminStub>() {
          @java.lang.Override
          public FirestoreAdminStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FirestoreAdminStub(channel, callOptions);
          }
        };
    return FirestoreAdminStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static FirestoreAdminBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FirestoreAdminBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FirestoreAdminBlockingV2Stub>() {
          @java.lang.Override
          public FirestoreAdminBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FirestoreAdminBlockingV2Stub(channel, callOptions);
          }
        };
    return FirestoreAdminBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FirestoreAdminBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FirestoreAdminBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FirestoreAdminBlockingStub>() {
          @java.lang.Override
          public FirestoreAdminBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FirestoreAdminBlockingStub(channel, callOptions);
          }
        };
    return FirestoreAdminBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static FirestoreAdminFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FirestoreAdminFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FirestoreAdminFutureStub>() {
          @java.lang.Override
          public FirestoreAdminFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FirestoreAdminFutureStub(channel, callOptions);
          }
        };
    return FirestoreAdminFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Cloud Firestore Admin API.
   * This API provides several administrative services for Cloud Firestore.
   * Project, Database, Namespace, Collection, Collection Group, and Document are
   * used as defined in the Google Cloud Firestore API.
   * Operation: An Operation represents work being performed in the background.
   * The index service manages Cloud Firestore indexes.
   * Index creation is performed asynchronously.
   * An Operation resource is created for each such asynchronous operation.
   * The state of the operation (including any errors encountered)
   * may be queried via the Operation resource.
   * The Operations collection provides a record of actions performed for the
   * specified Project (including any Operations in progress). Operations are not
   * created directly but through calls on other collections or resources.
   * An Operation that is done may be deleted so that it is no longer listed as
   * part of the Operation collection. Operations are garbage collected after
   * 30 days. By default, ListOperations will only return in progress and failed
   * operations. To list completed operation, issue a ListOperations request with
   * the filter `done: true`.
   * Operations are created by service `FirestoreAdmin`, but are accessed via
   * service `google.longrunning.Operations`.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a composite index. This returns a
     * [google.longrunning.Operation][google.longrunning.Operation] which may be
     * used to track the status of the creation. The metadata for the operation
     * will be the type
     * [IndexOperationMetadata][google.firestore.admin.v1.IndexOperationMetadata].
     * </pre>
     */
    default void createIndex(
        com.google.firestore.admin.v1.CreateIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateIndexMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists composite indexes.
     * </pre>
     */
    default void listIndexes(
        com.google.firestore.admin.v1.ListIndexesRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListIndexesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListIndexesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a composite index.
     * </pre>
     */
    default void getIndex(
        com.google.firestore.admin.v1.GetIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.Index> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIndexMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a composite index.
     * </pre>
     */
    default void deleteIndex(
        com.google.firestore.admin.v1.DeleteIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteIndexMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the metadata and configuration for a Field.
     * </pre>
     */
    default void getField(
        com.google.firestore.admin.v1.GetFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.Field> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFieldMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a field configuration. Currently, field updates apply only to
     * single field index configuration. However, calls to
     * [FirestoreAdmin.UpdateField][google.firestore.admin.v1.FirestoreAdmin.UpdateField]
     * should provide a field mask to avoid changing any configuration that the
     * caller isn't aware of. The field mask should be specified as: `{ paths:
     * "index_config" }`.
     * This call returns a
     * [google.longrunning.Operation][google.longrunning.Operation] which may be
     * used to track the status of the field update. The metadata for the
     * operation will be the type
     * [FieldOperationMetadata][google.firestore.admin.v1.FieldOperationMetadata].
     * To configure the default field settings for the database, use
     * the special `Field` with resource name:
     * `projects/{project_id}/databases/{database_id}/collectionGroups/__default__/fields/&#42;`.
     * </pre>
     */
    default void updateField(
        com.google.firestore.admin.v1.UpdateFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFieldMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the field configuration and metadata for this database.
     * Currently,
     * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields]
     * only supports listing fields that have been explicitly overridden. To issue
     * this query, call
     * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields]
     * with the filter set to `indexConfig.usesAncestorConfig:false` or
     * `ttlConfig:*`.
     * </pre>
     */
    default void listFields(
        com.google.firestore.admin.v1.ListFieldsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListFieldsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListFieldsMethod(), responseObserver);
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
     * For more details on export behavior and output format, refer to:
     * https://cloud.google.com/firestore/docs/manage-data/export-import
     * </pre>
     */
    default void exportDocuments(
        com.google.firestore.admin.v1.ExportDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportDocumentsMethod(), responseObserver);
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
    default void importDocuments(
        com.google.firestore.admin.v1.ImportDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportDocumentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Bulk deletes a subset of documents from Google Cloud Firestore.
     * Documents created or updated after the underlying system starts to process
     * the request will not be deleted. The bulk delete occurs in the background
     * and its progress can be monitored and managed via the Operation resource
     * that is created.
     * For more details on bulk delete behavior, refer to:
     * https://cloud.google.com/firestore/docs/manage-data/bulk-delete
     * </pre>
     */
    default void bulkDeleteDocuments(
        com.google.firestore.admin.v1.BulkDeleteDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBulkDeleteDocumentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a database.
     * </pre>
     */
    default void createDatabase(
        com.google.firestore.admin.v1.CreateDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a database.
     * </pre>
     */
    default void getDatabase(
        com.google.firestore.admin.v1.GetDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.Database> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all the databases in the project.
     * </pre>
     */
    default void listDatabases(
        com.google.firestore.admin.v1.ListDatabasesRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListDatabasesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDatabasesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a database.
     * </pre>
     */
    default void updateDatabase(
        com.google.firestore.admin.v1.UpdateDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a database.
     * </pre>
     */
    default void deleteDatabase(
        com.google.firestore.admin.v1.DeleteDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a user creds.
     * </pre>
     */
    default void createUserCreds(
        com.google.firestore.admin.v1.CreateUserCredsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.UserCreds> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateUserCredsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a user creds resource. Note that the returned resource does not
     * contain the secret value itself.
     * </pre>
     */
    default void getUserCreds(
        com.google.firestore.admin.v1.GetUserCredsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.UserCreds> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetUserCredsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all user creds in the database. Note that the returned resource
     * does not contain the secret value itself.
     * </pre>
     */
    default void listUserCreds(
        com.google.firestore.admin.v1.ListUserCredsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListUserCredsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListUserCredsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enables a user creds. No-op if the user creds are already enabled.
     * </pre>
     */
    default void enableUserCreds(
        com.google.firestore.admin.v1.EnableUserCredsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.UserCreds> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getEnableUserCredsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disables a user creds. No-op if the user creds are already disabled.
     * </pre>
     */
    default void disableUserCreds(
        com.google.firestore.admin.v1.DisableUserCredsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.UserCreds> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDisableUserCredsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resets the password of a user creds.
     * </pre>
     */
    default void resetUserPassword(
        com.google.firestore.admin.v1.ResetUserPasswordRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.UserCreds> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResetUserPasswordMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user creds.
     * </pre>
     */
    default void deleteUserCreds(
        com.google.firestore.admin.v1.DeleteUserCredsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteUserCredsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a backup.
     * </pre>
     */
    default void getBackup(
        com.google.firestore.admin.v1.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.Backup> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the backups.
     * </pre>
     */
    default void listBackups(
        com.google.firestore.admin.v1.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListBackupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a backup.
     * </pre>
     */
    default void deleteBackup(
        com.google.firestore.admin.v1.DeleteBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new database by restoring from an existing backup.
     * The new database must be in the same cloud region or multi-region location
     * as the existing backup. This behaves similar to
     * [FirestoreAdmin.CreateDatabase][google.firestore.admin.v1.FirestoreAdmin.CreateDatabase]
     * except instead of creating a new empty database, a new database is created
     * with the database type, index configuration, and documents from an existing
     * backup.
     * The [long-running operation][google.longrunning.Operation] can be used to
     * track the progress of the restore, with the Operation's
     * [metadata][google.longrunning.Operation.metadata] field type being the
     * [RestoreDatabaseMetadata][google.firestore.admin.v1.RestoreDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] type is the
     * [Database][google.firestore.admin.v1.Database] if the restore was
     * successful. The new database is not readable or writeable until the LRO has
     * completed.
     * </pre>
     */
    default void restoreDatabase(
        com.google.firestore.admin.v1.RestoreDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestoreDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a backup schedule on a database.
     * At most two backup schedules can be configured on a database, one daily
     * backup schedule and one weekly backup schedule.
     * </pre>
     */
    default void createBackupSchedule(
        com.google.firestore.admin.v1.CreateBackupScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.BackupSchedule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBackupScheduleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a backup schedule.
     * </pre>
     */
    default void getBackupSchedule(
        com.google.firestore.admin.v1.GetBackupScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.BackupSchedule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBackupScheduleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List backup schedules.
     * </pre>
     */
    default void listBackupSchedules(
        com.google.firestore.admin.v1.ListBackupSchedulesRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListBackupSchedulesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupSchedulesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a backup schedule.
     * </pre>
     */
    default void updateBackupSchedule(
        com.google.firestore.admin.v1.UpdateBackupScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.BackupSchedule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBackupScheduleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a backup schedule.
     * </pre>
     */
    default void deleteBackupSchedule(
        com.google.firestore.admin.v1.DeleteBackupScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBackupScheduleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new database by cloning an existing one.
     * The new database must be in the same cloud region or multi-region location
     * as the existing database. This behaves similar to
     * [FirestoreAdmin.CreateDatabase][google.firestore.admin.v1.FirestoreAdmin.CreateDatabase]
     * except instead of creating a new empty database, a new database is created
     * with the database type, index configuration, and documents from an existing
     * database.
     * The [long-running operation][google.longrunning.Operation] can be used to
     * track the progress of the clone, with the Operation's
     * [metadata][google.longrunning.Operation.metadata] field type being the
     * [CloneDatabaseMetadata][google.firestore.admin.v1.CloneDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] type is the
     * [Database][google.firestore.admin.v1.Database] if the clone was
     * successful. The new database is not readable or writeable until the LRO has
     * completed.
     * </pre>
     */
    default void cloneDatabase(
        com.google.firestore.admin.v1.CloneDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCloneDatabaseMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FirestoreAdmin.
   *
   * <pre>
   * The Cloud Firestore Admin API.
   * This API provides several administrative services for Cloud Firestore.
   * Project, Database, Namespace, Collection, Collection Group, and Document are
   * used as defined in the Google Cloud Firestore API.
   * Operation: An Operation represents work being performed in the background.
   * The index service manages Cloud Firestore indexes.
   * Index creation is performed asynchronously.
   * An Operation resource is created for each such asynchronous operation.
   * The state of the operation (including any errors encountered)
   * may be queried via the Operation resource.
   * The Operations collection provides a record of actions performed for the
   * specified Project (including any Operations in progress). Operations are not
   * created directly but through calls on other collections or resources.
   * An Operation that is done may be deleted so that it is no longer listed as
   * part of the Operation collection. Operations are garbage collected after
   * 30 days. By default, ListOperations will only return in progress and failed
   * operations. To list completed operation, issue a ListOperations request with
   * the filter `done: true`.
   * Operations are created by service `FirestoreAdmin`, but are accessed via
   * service `google.longrunning.Operations`.
   * </pre>
   */
  public abstract static class FirestoreAdminImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return FirestoreAdminGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FirestoreAdmin.
   *
   * <pre>
   * The Cloud Firestore Admin API.
   * This API provides several administrative services for Cloud Firestore.
   * Project, Database, Namespace, Collection, Collection Group, and Document are
   * used as defined in the Google Cloud Firestore API.
   * Operation: An Operation represents work being performed in the background.
   * The index service manages Cloud Firestore indexes.
   * Index creation is performed asynchronously.
   * An Operation resource is created for each such asynchronous operation.
   * The state of the operation (including any errors encountered)
   * may be queried via the Operation resource.
   * The Operations collection provides a record of actions performed for the
   * specified Project (including any Operations in progress). Operations are not
   * created directly but through calls on other collections or resources.
   * An Operation that is done may be deleted so that it is no longer listed as
   * part of the Operation collection. Operations are garbage collected after
   * 30 days. By default, ListOperations will only return in progress and failed
   * operations. To list completed operation, issue a ListOperations request with
   * the filter `done: true`.
   * Operations are created by service `FirestoreAdmin`, but are accessed via
   * service `google.longrunning.Operations`.
   * </pre>
   */
  public static final class FirestoreAdminStub
      extends io.grpc.stub.AbstractAsyncStub<FirestoreAdminStub> {
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
     * Creates a composite index. This returns a
     * [google.longrunning.Operation][google.longrunning.Operation] which may be
     * used to track the status of the creation. The metadata for the operation
     * will be the type
     * [IndexOperationMetadata][google.firestore.admin.v1.IndexOperationMetadata].
     * </pre>
     */
    public void createIndex(
        com.google.firestore.admin.v1.CreateIndexRequest request,
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
     * Lists composite indexes.
     * </pre>
     */
    public void listIndexes(
        com.google.firestore.admin.v1.ListIndexesRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListIndexesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIndexesMethod(), getCallOptions()),
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIndexMethod(), getCallOptions()), request, responseObserver);
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteIndexMethod(), getCallOptions()),
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFieldMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a field configuration. Currently, field updates apply only to
     * single field index configuration. However, calls to
     * [FirestoreAdmin.UpdateField][google.firestore.admin.v1.FirestoreAdmin.UpdateField]
     * should provide a field mask to avoid changing any configuration that the
     * caller isn't aware of. The field mask should be specified as: `{ paths:
     * "index_config" }`.
     * This call returns a
     * [google.longrunning.Operation][google.longrunning.Operation] which may be
     * used to track the status of the field update. The metadata for the
     * operation will be the type
     * [FieldOperationMetadata][google.firestore.admin.v1.FieldOperationMetadata].
     * To configure the default field settings for the database, use
     * the special `Field` with resource name:
     * `projects/{project_id}/databases/{database_id}/collectionGroups/__default__/fields/&#42;`.
     * </pre>
     */
    public void updateField(
        com.google.firestore.admin.v1.UpdateFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFieldMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the field configuration and metadata for this database.
     * Currently,
     * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields]
     * only supports listing fields that have been explicitly overridden. To issue
     * this query, call
     * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields]
     * with the filter set to `indexConfig.usesAncestorConfig:false` or
     * `ttlConfig:*`.
     * </pre>
     */
    public void listFields(
        com.google.firestore.admin.v1.ListFieldsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListFieldsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFieldsMethod(), getCallOptions()), request, responseObserver);
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
     * For more details on export behavior and output format, refer to:
     * https://cloud.google.com/firestore/docs/manage-data/export-import
     * </pre>
     */
    public void exportDocuments(
        com.google.firestore.admin.v1.ExportDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportDocumentsMethod(), getCallOptions()),
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportDocumentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Bulk deletes a subset of documents from Google Cloud Firestore.
     * Documents created or updated after the underlying system starts to process
     * the request will not be deleted. The bulk delete occurs in the background
     * and its progress can be monitored and managed via the Operation resource
     * that is created.
     * For more details on bulk delete behavior, refer to:
     * https://cloud.google.com/firestore/docs/manage-data/bulk-delete
     * </pre>
     */
    public void bulkDeleteDocuments(
        com.google.firestore.admin.v1.BulkDeleteDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBulkDeleteDocumentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a database.
     * </pre>
     */
    public void createDatabase(
        com.google.firestore.admin.v1.CreateDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a database.
     * </pre>
     */
    public void getDatabase(
        com.google.firestore.admin.v1.GetDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.Database> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all the databases in the project.
     * </pre>
     */
    public void listDatabases(
        com.google.firestore.admin.v1.ListDatabasesRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListDatabasesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDatabasesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a database.
     * </pre>
     */
    public void updateDatabase(
        com.google.firestore.admin.v1.UpdateDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a database.
     * </pre>
     */
    public void deleteDatabase(
        com.google.firestore.admin.v1.DeleteDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a user creds.
     * </pre>
     */
    public void createUserCreds(
        com.google.firestore.admin.v1.CreateUserCredsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.UserCreds> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserCredsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a user creds resource. Note that the returned resource does not
     * contain the secret value itself.
     * </pre>
     */
    public void getUserCreds(
        com.google.firestore.admin.v1.GetUserCredsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.UserCreds> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserCredsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all user creds in the database. Note that the returned resource
     * does not contain the secret value itself.
     * </pre>
     */
    public void listUserCreds(
        com.google.firestore.admin.v1.ListUserCredsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListUserCredsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUserCredsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enables a user creds. No-op if the user creds are already enabled.
     * </pre>
     */
    public void enableUserCreds(
        com.google.firestore.admin.v1.EnableUserCredsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.UserCreds> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnableUserCredsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disables a user creds. No-op if the user creds are already disabled.
     * </pre>
     */
    public void disableUserCreds(
        com.google.firestore.admin.v1.DisableUserCredsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.UserCreds> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisableUserCredsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resets the password of a user creds.
     * </pre>
     */
    public void resetUserPassword(
        com.google.firestore.admin.v1.ResetUserPasswordRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.UserCreds> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResetUserPasswordMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user creds.
     * </pre>
     */
    public void deleteUserCreds(
        com.google.firestore.admin.v1.DeleteUserCredsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUserCredsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a backup.
     * </pre>
     */
    public void getBackup(
        com.google.firestore.admin.v1.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.Backup> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the backups.
     * </pre>
     */
    public void listBackups(
        com.google.firestore.admin.v1.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListBackupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBackupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a backup.
     * </pre>
     */
    public void deleteBackup(
        com.google.firestore.admin.v1.DeleteBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new database by restoring from an existing backup.
     * The new database must be in the same cloud region or multi-region location
     * as the existing backup. This behaves similar to
     * [FirestoreAdmin.CreateDatabase][google.firestore.admin.v1.FirestoreAdmin.CreateDatabase]
     * except instead of creating a new empty database, a new database is created
     * with the database type, index configuration, and documents from an existing
     * backup.
     * The [long-running operation][google.longrunning.Operation] can be used to
     * track the progress of the restore, with the Operation's
     * [metadata][google.longrunning.Operation.metadata] field type being the
     * [RestoreDatabaseMetadata][google.firestore.admin.v1.RestoreDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] type is the
     * [Database][google.firestore.admin.v1.Database] if the restore was
     * successful. The new database is not readable or writeable until the LRO has
     * completed.
     * </pre>
     */
    public void restoreDatabase(
        com.google.firestore.admin.v1.RestoreDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestoreDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a backup schedule on a database.
     * At most two backup schedules can be configured on a database, one daily
     * backup schedule and one weekly backup schedule.
     * </pre>
     */
    public void createBackupSchedule(
        com.google.firestore.admin.v1.CreateBackupScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.BackupSchedule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBackupScheduleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a backup schedule.
     * </pre>
     */
    public void getBackupSchedule(
        com.google.firestore.admin.v1.GetBackupScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.BackupSchedule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackupScheduleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List backup schedules.
     * </pre>
     */
    public void listBackupSchedules(
        com.google.firestore.admin.v1.ListBackupSchedulesRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListBackupSchedulesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBackupSchedulesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a backup schedule.
     * </pre>
     */
    public void updateBackupSchedule(
        com.google.firestore.admin.v1.UpdateBackupScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.BackupSchedule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBackupScheduleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a backup schedule.
     * </pre>
     */
    public void deleteBackupSchedule(
        com.google.firestore.admin.v1.DeleteBackupScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBackupScheduleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new database by cloning an existing one.
     * The new database must be in the same cloud region or multi-region location
     * as the existing database. This behaves similar to
     * [FirestoreAdmin.CreateDatabase][google.firestore.admin.v1.FirestoreAdmin.CreateDatabase]
     * except instead of creating a new empty database, a new database is created
     * with the database type, index configuration, and documents from an existing
     * database.
     * The [long-running operation][google.longrunning.Operation] can be used to
     * track the progress of the clone, with the Operation's
     * [metadata][google.longrunning.Operation.metadata] field type being the
     * [CloneDatabaseMetadata][google.firestore.admin.v1.CloneDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] type is the
     * [Database][google.firestore.admin.v1.Database] if the clone was
     * successful. The new database is not readable or writeable until the LRO has
     * completed.
     * </pre>
     */
    public void cloneDatabase(
        com.google.firestore.admin.v1.CloneDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCloneDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FirestoreAdmin.
   *
   * <pre>
   * The Cloud Firestore Admin API.
   * This API provides several administrative services for Cloud Firestore.
   * Project, Database, Namespace, Collection, Collection Group, and Document are
   * used as defined in the Google Cloud Firestore API.
   * Operation: An Operation represents work being performed in the background.
   * The index service manages Cloud Firestore indexes.
   * Index creation is performed asynchronously.
   * An Operation resource is created for each such asynchronous operation.
   * The state of the operation (including any errors encountered)
   * may be queried via the Operation resource.
   * The Operations collection provides a record of actions performed for the
   * specified Project (including any Operations in progress). Operations are not
   * created directly but through calls on other collections or resources.
   * An Operation that is done may be deleted so that it is no longer listed as
   * part of the Operation collection. Operations are garbage collected after
   * 30 days. By default, ListOperations will only return in progress and failed
   * operations. To list completed operation, issue a ListOperations request with
   * the filter `done: true`.
   * Operations are created by service `FirestoreAdmin`, but are accessed via
   * service `google.longrunning.Operations`.
   * </pre>
   */
  public static final class FirestoreAdminBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<FirestoreAdminBlockingV2Stub> {
    private FirestoreAdminBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FirestoreAdminBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FirestoreAdminBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a composite index. This returns a
     * [google.longrunning.Operation][google.longrunning.Operation] which may be
     * used to track the status of the creation. The metadata for the operation
     * will be the type
     * [IndexOperationMetadata][google.firestore.admin.v1.IndexOperationMetadata].
     * </pre>
     */
    public com.google.longrunning.Operation createIndex(
        com.google.firestore.admin.v1.CreateIndexRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateIndexMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists composite indexes.
     * </pre>
     */
    public com.google.firestore.admin.v1.ListIndexesResponse listIndexes(
        com.google.firestore.admin.v1.ListIndexesRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListIndexesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a composite index.
     * </pre>
     */
    public com.google.firestore.admin.v1.Index getIndex(
        com.google.firestore.admin.v1.GetIndexRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetIndexMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a composite index.
     * </pre>
     */
    public com.google.protobuf.Empty deleteIndex(
        com.google.firestore.admin.v1.DeleteIndexRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteIndexMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the metadata and configuration for a Field.
     * </pre>
     */
    public com.google.firestore.admin.v1.Field getField(
        com.google.firestore.admin.v1.GetFieldRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetFieldMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a field configuration. Currently, field updates apply only to
     * single field index configuration. However, calls to
     * [FirestoreAdmin.UpdateField][google.firestore.admin.v1.FirestoreAdmin.UpdateField]
     * should provide a field mask to avoid changing any configuration that the
     * caller isn't aware of. The field mask should be specified as: `{ paths:
     * "index_config" }`.
     * This call returns a
     * [google.longrunning.Operation][google.longrunning.Operation] which may be
     * used to track the status of the field update. The metadata for the
     * operation will be the type
     * [FieldOperationMetadata][google.firestore.admin.v1.FieldOperationMetadata].
     * To configure the default field settings for the database, use
     * the special `Field` with resource name:
     * `projects/{project_id}/databases/{database_id}/collectionGroups/__default__/fields/&#42;`.
     * </pre>
     */
    public com.google.longrunning.Operation updateField(
        com.google.firestore.admin.v1.UpdateFieldRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateFieldMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the field configuration and metadata for this database.
     * Currently,
     * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields]
     * only supports listing fields that have been explicitly overridden. To issue
     * this query, call
     * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields]
     * with the filter set to `indexConfig.usesAncestorConfig:false` or
     * `ttlConfig:*`.
     * </pre>
     */
    public com.google.firestore.admin.v1.ListFieldsResponse listFields(
        com.google.firestore.admin.v1.ListFieldsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListFieldsMethod(), getCallOptions(), request);
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
     * For more details on export behavior and output format, refer to:
     * https://cloud.google.com/firestore/docs/manage-data/export-import
     * </pre>
     */
    public com.google.longrunning.Operation exportDocuments(
        com.google.firestore.admin.v1.ExportDocumentsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getExportDocumentsMethod(), getCallOptions(), request);
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
        com.google.firestore.admin.v1.ImportDocumentsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getImportDocumentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Bulk deletes a subset of documents from Google Cloud Firestore.
     * Documents created or updated after the underlying system starts to process
     * the request will not be deleted. The bulk delete occurs in the background
     * and its progress can be monitored and managed via the Operation resource
     * that is created.
     * For more details on bulk delete behavior, refer to:
     * https://cloud.google.com/firestore/docs/manage-data/bulk-delete
     * </pre>
     */
    public com.google.longrunning.Operation bulkDeleteDocuments(
        com.google.firestore.admin.v1.BulkDeleteDocumentsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBulkDeleteDocumentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a database.
     * </pre>
     */
    public com.google.longrunning.Operation createDatabase(
        com.google.firestore.admin.v1.CreateDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a database.
     * </pre>
     */
    public com.google.firestore.admin.v1.Database getDatabase(
        com.google.firestore.admin.v1.GetDatabaseRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all the databases in the project.
     * </pre>
     */
    public com.google.firestore.admin.v1.ListDatabasesResponse listDatabases(
        com.google.firestore.admin.v1.ListDatabasesRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDatabasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a database.
     * </pre>
     */
    public com.google.longrunning.Operation updateDatabase(
        com.google.firestore.admin.v1.UpdateDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a database.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDatabase(
        com.google.firestore.admin.v1.DeleteDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a user creds.
     * </pre>
     */
    public com.google.firestore.admin.v1.UserCreds createUserCreds(
        com.google.firestore.admin.v1.CreateUserCredsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateUserCredsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a user creds resource. Note that the returned resource does not
     * contain the secret value itself.
     * </pre>
     */
    public com.google.firestore.admin.v1.UserCreds getUserCreds(
        com.google.firestore.admin.v1.GetUserCredsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetUserCredsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all user creds in the database. Note that the returned resource
     * does not contain the secret value itself.
     * </pre>
     */
    public com.google.firestore.admin.v1.ListUserCredsResponse listUserCreds(
        com.google.firestore.admin.v1.ListUserCredsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListUserCredsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Enables a user creds. No-op if the user creds are already enabled.
     * </pre>
     */
    public com.google.firestore.admin.v1.UserCreds enableUserCreds(
        com.google.firestore.admin.v1.EnableUserCredsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getEnableUserCredsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Disables a user creds. No-op if the user creds are already disabled.
     * </pre>
     */
    public com.google.firestore.admin.v1.UserCreds disableUserCreds(
        com.google.firestore.admin.v1.DisableUserCredsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDisableUserCredsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resets the password of a user creds.
     * </pre>
     */
    public com.google.firestore.admin.v1.UserCreds resetUserPassword(
        com.google.firestore.admin.v1.ResetUserPasswordRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getResetUserPasswordMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user creds.
     * </pre>
     */
    public com.google.protobuf.Empty deleteUserCreds(
        com.google.firestore.admin.v1.DeleteUserCredsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteUserCredsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a backup.
     * </pre>
     */
    public com.google.firestore.admin.v1.Backup getBackup(
        com.google.firestore.admin.v1.GetBackupRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the backups.
     * </pre>
     */
    public com.google.firestore.admin.v1.ListBackupsResponse listBackups(
        com.google.firestore.admin.v1.ListBackupsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListBackupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a backup.
     * </pre>
     */
    public com.google.protobuf.Empty deleteBackup(
        com.google.firestore.admin.v1.DeleteBackupRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new database by restoring from an existing backup.
     * The new database must be in the same cloud region or multi-region location
     * as the existing backup. This behaves similar to
     * [FirestoreAdmin.CreateDatabase][google.firestore.admin.v1.FirestoreAdmin.CreateDatabase]
     * except instead of creating a new empty database, a new database is created
     * with the database type, index configuration, and documents from an existing
     * backup.
     * The [long-running operation][google.longrunning.Operation] can be used to
     * track the progress of the restore, with the Operation's
     * [metadata][google.longrunning.Operation.metadata] field type being the
     * [RestoreDatabaseMetadata][google.firestore.admin.v1.RestoreDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] type is the
     * [Database][google.firestore.admin.v1.Database] if the restore was
     * successful. The new database is not readable or writeable until the LRO has
     * completed.
     * </pre>
     */
    public com.google.longrunning.Operation restoreDatabase(
        com.google.firestore.admin.v1.RestoreDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRestoreDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a backup schedule on a database.
     * At most two backup schedules can be configured on a database, one daily
     * backup schedule and one weekly backup schedule.
     * </pre>
     */
    public com.google.firestore.admin.v1.BackupSchedule createBackupSchedule(
        com.google.firestore.admin.v1.CreateBackupScheduleRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateBackupScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a backup schedule.
     * </pre>
     */
    public com.google.firestore.admin.v1.BackupSchedule getBackupSchedule(
        com.google.firestore.admin.v1.GetBackupScheduleRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetBackupScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List backup schedules.
     * </pre>
     */
    public com.google.firestore.admin.v1.ListBackupSchedulesResponse listBackupSchedules(
        com.google.firestore.admin.v1.ListBackupSchedulesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListBackupSchedulesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a backup schedule.
     * </pre>
     */
    public com.google.firestore.admin.v1.BackupSchedule updateBackupSchedule(
        com.google.firestore.admin.v1.UpdateBackupScheduleRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateBackupScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a backup schedule.
     * </pre>
     */
    public com.google.protobuf.Empty deleteBackupSchedule(
        com.google.firestore.admin.v1.DeleteBackupScheduleRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteBackupScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new database by cloning an existing one.
     * The new database must be in the same cloud region or multi-region location
     * as the existing database. This behaves similar to
     * [FirestoreAdmin.CreateDatabase][google.firestore.admin.v1.FirestoreAdmin.CreateDatabase]
     * except instead of creating a new empty database, a new database is created
     * with the database type, index configuration, and documents from an existing
     * database.
     * The [long-running operation][google.longrunning.Operation] can be used to
     * track the progress of the clone, with the Operation's
     * [metadata][google.longrunning.Operation.metadata] field type being the
     * [CloneDatabaseMetadata][google.firestore.admin.v1.CloneDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] type is the
     * [Database][google.firestore.admin.v1.Database] if the clone was
     * successful. The new database is not readable or writeable until the LRO has
     * completed.
     * </pre>
     */
    public com.google.longrunning.Operation cloneDatabase(
        com.google.firestore.admin.v1.CloneDatabaseRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCloneDatabaseMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service FirestoreAdmin.
   *
   * <pre>
   * The Cloud Firestore Admin API.
   * This API provides several administrative services for Cloud Firestore.
   * Project, Database, Namespace, Collection, Collection Group, and Document are
   * used as defined in the Google Cloud Firestore API.
   * Operation: An Operation represents work being performed in the background.
   * The index service manages Cloud Firestore indexes.
   * Index creation is performed asynchronously.
   * An Operation resource is created for each such asynchronous operation.
   * The state of the operation (including any errors encountered)
   * may be queried via the Operation resource.
   * The Operations collection provides a record of actions performed for the
   * specified Project (including any Operations in progress). Operations are not
   * created directly but through calls on other collections or resources.
   * An Operation that is done may be deleted so that it is no longer listed as
   * part of the Operation collection. Operations are garbage collected after
   * 30 days. By default, ListOperations will only return in progress and failed
   * operations. To list completed operation, issue a ListOperations request with
   * the filter `done: true`.
   * Operations are created by service `FirestoreAdmin`, but are accessed via
   * service `google.longrunning.Operations`.
   * </pre>
   */
  public static final class FirestoreAdminBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FirestoreAdminBlockingStub> {
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
     * Creates a composite index. This returns a
     * [google.longrunning.Operation][google.longrunning.Operation] which may be
     * used to track the status of the creation. The metadata for the operation
     * will be the type
     * [IndexOperationMetadata][google.firestore.admin.v1.IndexOperationMetadata].
     * </pre>
     */
    public com.google.longrunning.Operation createIndex(
        com.google.firestore.admin.v1.CreateIndexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIndexMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIndexesMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIndexMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIndexMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFieldMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a field configuration. Currently, field updates apply only to
     * single field index configuration. However, calls to
     * [FirestoreAdmin.UpdateField][google.firestore.admin.v1.FirestoreAdmin.UpdateField]
     * should provide a field mask to avoid changing any configuration that the
     * caller isn't aware of. The field mask should be specified as: `{ paths:
     * "index_config" }`.
     * This call returns a
     * [google.longrunning.Operation][google.longrunning.Operation] which may be
     * used to track the status of the field update. The metadata for the
     * operation will be the type
     * [FieldOperationMetadata][google.firestore.admin.v1.FieldOperationMetadata].
     * To configure the default field settings for the database, use
     * the special `Field` with resource name:
     * `projects/{project_id}/databases/{database_id}/collectionGroups/__default__/fields/&#42;`.
     * </pre>
     */
    public com.google.longrunning.Operation updateField(
        com.google.firestore.admin.v1.UpdateFieldRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFieldMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the field configuration and metadata for this database.
     * Currently,
     * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields]
     * only supports listing fields that have been explicitly overridden. To issue
     * this query, call
     * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields]
     * with the filter set to `indexConfig.usesAncestorConfig:false` or
     * `ttlConfig:*`.
     * </pre>
     */
    public com.google.firestore.admin.v1.ListFieldsResponse listFields(
        com.google.firestore.admin.v1.ListFieldsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFieldsMethod(), getCallOptions(), request);
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
     * For more details on export behavior and output format, refer to:
     * https://cloud.google.com/firestore/docs/manage-data/export-import
     * </pre>
     */
    public com.google.longrunning.Operation exportDocuments(
        com.google.firestore.admin.v1.ExportDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportDocumentsMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportDocumentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Bulk deletes a subset of documents from Google Cloud Firestore.
     * Documents created or updated after the underlying system starts to process
     * the request will not be deleted. The bulk delete occurs in the background
     * and its progress can be monitored and managed via the Operation resource
     * that is created.
     * For more details on bulk delete behavior, refer to:
     * https://cloud.google.com/firestore/docs/manage-data/bulk-delete
     * </pre>
     */
    public com.google.longrunning.Operation bulkDeleteDocuments(
        com.google.firestore.admin.v1.BulkDeleteDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBulkDeleteDocumentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a database.
     * </pre>
     */
    public com.google.longrunning.Operation createDatabase(
        com.google.firestore.admin.v1.CreateDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a database.
     * </pre>
     */
    public com.google.firestore.admin.v1.Database getDatabase(
        com.google.firestore.admin.v1.GetDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all the databases in the project.
     * </pre>
     */
    public com.google.firestore.admin.v1.ListDatabasesResponse listDatabases(
        com.google.firestore.admin.v1.ListDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatabasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a database.
     * </pre>
     */
    public com.google.longrunning.Operation updateDatabase(
        com.google.firestore.admin.v1.UpdateDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a database.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDatabase(
        com.google.firestore.admin.v1.DeleteDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a user creds.
     * </pre>
     */
    public com.google.firestore.admin.v1.UserCreds createUserCreds(
        com.google.firestore.admin.v1.CreateUserCredsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserCredsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a user creds resource. Note that the returned resource does not
     * contain the secret value itself.
     * </pre>
     */
    public com.google.firestore.admin.v1.UserCreds getUserCreds(
        com.google.firestore.admin.v1.GetUserCredsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserCredsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all user creds in the database. Note that the returned resource
     * does not contain the secret value itself.
     * </pre>
     */
    public com.google.firestore.admin.v1.ListUserCredsResponse listUserCreds(
        com.google.firestore.admin.v1.ListUserCredsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUserCredsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Enables a user creds. No-op if the user creds are already enabled.
     * </pre>
     */
    public com.google.firestore.admin.v1.UserCreds enableUserCreds(
        com.google.firestore.admin.v1.EnableUserCredsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnableUserCredsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Disables a user creds. No-op if the user creds are already disabled.
     * </pre>
     */
    public com.google.firestore.admin.v1.UserCreds disableUserCreds(
        com.google.firestore.admin.v1.DisableUserCredsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableUserCredsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resets the password of a user creds.
     * </pre>
     */
    public com.google.firestore.admin.v1.UserCreds resetUserPassword(
        com.google.firestore.admin.v1.ResetUserPasswordRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResetUserPasswordMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user creds.
     * </pre>
     */
    public com.google.protobuf.Empty deleteUserCreds(
        com.google.firestore.admin.v1.DeleteUserCredsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUserCredsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a backup.
     * </pre>
     */
    public com.google.firestore.admin.v1.Backup getBackup(
        com.google.firestore.admin.v1.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the backups.
     * </pre>
     */
    public com.google.firestore.admin.v1.ListBackupsResponse listBackups(
        com.google.firestore.admin.v1.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a backup.
     * </pre>
     */
    public com.google.protobuf.Empty deleteBackup(
        com.google.firestore.admin.v1.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new database by restoring from an existing backup.
     * The new database must be in the same cloud region or multi-region location
     * as the existing backup. This behaves similar to
     * [FirestoreAdmin.CreateDatabase][google.firestore.admin.v1.FirestoreAdmin.CreateDatabase]
     * except instead of creating a new empty database, a new database is created
     * with the database type, index configuration, and documents from an existing
     * backup.
     * The [long-running operation][google.longrunning.Operation] can be used to
     * track the progress of the restore, with the Operation's
     * [metadata][google.longrunning.Operation.metadata] field type being the
     * [RestoreDatabaseMetadata][google.firestore.admin.v1.RestoreDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] type is the
     * [Database][google.firestore.admin.v1.Database] if the restore was
     * successful. The new database is not readable or writeable until the LRO has
     * completed.
     * </pre>
     */
    public com.google.longrunning.Operation restoreDatabase(
        com.google.firestore.admin.v1.RestoreDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a backup schedule on a database.
     * At most two backup schedules can be configured on a database, one daily
     * backup schedule and one weekly backup schedule.
     * </pre>
     */
    public com.google.firestore.admin.v1.BackupSchedule createBackupSchedule(
        com.google.firestore.admin.v1.CreateBackupScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBackupScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a backup schedule.
     * </pre>
     */
    public com.google.firestore.admin.v1.BackupSchedule getBackupSchedule(
        com.google.firestore.admin.v1.GetBackupScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List backup schedules.
     * </pre>
     */
    public com.google.firestore.admin.v1.ListBackupSchedulesResponse listBackupSchedules(
        com.google.firestore.admin.v1.ListBackupSchedulesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupSchedulesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a backup schedule.
     * </pre>
     */
    public com.google.firestore.admin.v1.BackupSchedule updateBackupSchedule(
        com.google.firestore.admin.v1.UpdateBackupScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBackupScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a backup schedule.
     * </pre>
     */
    public com.google.protobuf.Empty deleteBackupSchedule(
        com.google.firestore.admin.v1.DeleteBackupScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBackupScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new database by cloning an existing one.
     * The new database must be in the same cloud region or multi-region location
     * as the existing database. This behaves similar to
     * [FirestoreAdmin.CreateDatabase][google.firestore.admin.v1.FirestoreAdmin.CreateDatabase]
     * except instead of creating a new empty database, a new database is created
     * with the database type, index configuration, and documents from an existing
     * database.
     * The [long-running operation][google.longrunning.Operation] can be used to
     * track the progress of the clone, with the Operation's
     * [metadata][google.longrunning.Operation.metadata] field type being the
     * [CloneDatabaseMetadata][google.firestore.admin.v1.CloneDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] type is the
     * [Database][google.firestore.admin.v1.Database] if the clone was
     * successful. The new database is not readable or writeable until the LRO has
     * completed.
     * </pre>
     */
    public com.google.longrunning.Operation cloneDatabase(
        com.google.firestore.admin.v1.CloneDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCloneDatabaseMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FirestoreAdmin.
   *
   * <pre>
   * The Cloud Firestore Admin API.
   * This API provides several administrative services for Cloud Firestore.
   * Project, Database, Namespace, Collection, Collection Group, and Document are
   * used as defined in the Google Cloud Firestore API.
   * Operation: An Operation represents work being performed in the background.
   * The index service manages Cloud Firestore indexes.
   * Index creation is performed asynchronously.
   * An Operation resource is created for each such asynchronous operation.
   * The state of the operation (including any errors encountered)
   * may be queried via the Operation resource.
   * The Operations collection provides a record of actions performed for the
   * specified Project (including any Operations in progress). Operations are not
   * created directly but through calls on other collections or resources.
   * An Operation that is done may be deleted so that it is no longer listed as
   * part of the Operation collection. Operations are garbage collected after
   * 30 days. By default, ListOperations will only return in progress and failed
   * operations. To list completed operation, issue a ListOperations request with
   * the filter `done: true`.
   * Operations are created by service `FirestoreAdmin`, but are accessed via
   * service `google.longrunning.Operations`.
   * </pre>
   */
  public static final class FirestoreAdminFutureStub
      extends io.grpc.stub.AbstractFutureStub<FirestoreAdminFutureStub> {
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
     * Creates a composite index. This returns a
     * [google.longrunning.Operation][google.longrunning.Operation] which may be
     * used to track the status of the creation. The metadata for the operation
     * will be the type
     * [IndexOperationMetadata][google.firestore.admin.v1.IndexOperationMetadata].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createIndex(com.google.firestore.admin.v1.CreateIndexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateIndexMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIndexesMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIndexMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteIndexMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFieldMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a field configuration. Currently, field updates apply only to
     * single field index configuration. However, calls to
     * [FirestoreAdmin.UpdateField][google.firestore.admin.v1.FirestoreAdmin.UpdateField]
     * should provide a field mask to avoid changing any configuration that the
     * caller isn't aware of. The field mask should be specified as: `{ paths:
     * "index_config" }`.
     * This call returns a
     * [google.longrunning.Operation][google.longrunning.Operation] which may be
     * used to track the status of the field update. The metadata for the
     * operation will be the type
     * [FieldOperationMetadata][google.firestore.admin.v1.FieldOperationMetadata].
     * To configure the default field settings for the database, use
     * the special `Field` with resource name:
     * `projects/{project_id}/databases/{database_id}/collectionGroups/__default__/fields/&#42;`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateField(com.google.firestore.admin.v1.UpdateFieldRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFieldMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the field configuration and metadata for this database.
     * Currently,
     * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields]
     * only supports listing fields that have been explicitly overridden. To issue
     * this query, call
     * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields]
     * with the filter set to `indexConfig.usesAncestorConfig:false` or
     * `ttlConfig:*`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.admin.v1.ListFieldsResponse>
        listFields(com.google.firestore.admin.v1.ListFieldsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFieldsMethod(), getCallOptions()), request);
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
     * For more details on export behavior and output format, refer to:
     * https://cloud.google.com/firestore/docs/manage-data/export-import
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportDocuments(com.google.firestore.admin.v1.ExportDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportDocumentsMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportDocumentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Bulk deletes a subset of documents from Google Cloud Firestore.
     * Documents created or updated after the underlying system starts to process
     * the request will not be deleted. The bulk delete occurs in the background
     * and its progress can be monitored and managed via the Operation resource
     * that is created.
     * For more details on bulk delete behavior, refer to:
     * https://cloud.google.com/firestore/docs/manage-data/bulk-delete
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        bulkDeleteDocuments(com.google.firestore.admin.v1.BulkDeleteDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBulkDeleteDocumentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDatabase(com.google.firestore.admin.v1.CreateDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.admin.v1.Database>
        getDatabase(com.google.firestore.admin.v1.GetDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all the databases in the project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.admin.v1.ListDatabasesResponse>
        listDatabases(com.google.firestore.admin.v1.ListDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDatabasesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDatabase(com.google.firestore.admin.v1.UpdateDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDatabase(com.google.firestore.admin.v1.DeleteDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a user creds.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.admin.v1.UserCreds>
        createUserCreds(com.google.firestore.admin.v1.CreateUserCredsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserCredsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a user creds resource. Note that the returned resource does not
     * contain the secret value itself.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.admin.v1.UserCreds>
        getUserCreds(com.google.firestore.admin.v1.GetUserCredsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserCredsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all user creds in the database. Note that the returned resource
     * does not contain the secret value itself.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.admin.v1.ListUserCredsResponse>
        listUserCreds(com.google.firestore.admin.v1.ListUserCredsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUserCredsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Enables a user creds. No-op if the user creds are already enabled.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.admin.v1.UserCreds>
        enableUserCreds(com.google.firestore.admin.v1.EnableUserCredsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnableUserCredsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Disables a user creds. No-op if the user creds are already disabled.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.admin.v1.UserCreds>
        disableUserCreds(com.google.firestore.admin.v1.DisableUserCredsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableUserCredsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Resets the password of a user creds.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.admin.v1.UserCreds>
        resetUserPassword(com.google.firestore.admin.v1.ResetUserPasswordRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResetUserPasswordMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user creds.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteUserCreds(com.google.firestore.admin.v1.DeleteUserCredsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUserCredsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.firestore.admin.v1.Backup>
        getBackup(com.google.firestore.admin.v1.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the backups.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.admin.v1.ListBackupsResponse>
        listBackups(com.google.firestore.admin.v1.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteBackup(com.google.firestore.admin.v1.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new database by restoring from an existing backup.
     * The new database must be in the same cloud region or multi-region location
     * as the existing backup. This behaves similar to
     * [FirestoreAdmin.CreateDatabase][google.firestore.admin.v1.FirestoreAdmin.CreateDatabase]
     * except instead of creating a new empty database, a new database is created
     * with the database type, index configuration, and documents from an existing
     * backup.
     * The [long-running operation][google.longrunning.Operation] can be used to
     * track the progress of the restore, with the Operation's
     * [metadata][google.longrunning.Operation.metadata] field type being the
     * [RestoreDatabaseMetadata][google.firestore.admin.v1.RestoreDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] type is the
     * [Database][google.firestore.admin.v1.Database] if the restore was
     * successful. The new database is not readable or writeable until the LRO has
     * completed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        restoreDatabase(com.google.firestore.admin.v1.RestoreDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestoreDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a backup schedule on a database.
     * At most two backup schedules can be configured on a database, one daily
     * backup schedule and one weekly backup schedule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.admin.v1.BackupSchedule>
        createBackupSchedule(com.google.firestore.admin.v1.CreateBackupScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBackupScheduleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a backup schedule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.admin.v1.BackupSchedule>
        getBackupSchedule(com.google.firestore.admin.v1.GetBackupScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackupScheduleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List backup schedules.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.admin.v1.ListBackupSchedulesResponse>
        listBackupSchedules(com.google.firestore.admin.v1.ListBackupSchedulesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupSchedulesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a backup schedule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.firestore.admin.v1.BackupSchedule>
        updateBackupSchedule(com.google.firestore.admin.v1.UpdateBackupScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBackupScheduleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a backup schedule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteBackupSchedule(com.google.firestore.admin.v1.DeleteBackupScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBackupScheduleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new database by cloning an existing one.
     * The new database must be in the same cloud region or multi-region location
     * as the existing database. This behaves similar to
     * [FirestoreAdmin.CreateDatabase][google.firestore.admin.v1.FirestoreAdmin.CreateDatabase]
     * except instead of creating a new empty database, a new database is created
     * with the database type, index configuration, and documents from an existing
     * database.
     * The [long-running operation][google.longrunning.Operation] can be used to
     * track the progress of the clone, with the Operation's
     * [metadata][google.longrunning.Operation.metadata] field type being the
     * [CloneDatabaseMetadata][google.firestore.admin.v1.CloneDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] type is the
     * [Database][google.firestore.admin.v1.Database] if the clone was
     * successful. The new database is not readable or writeable until the LRO has
     * completed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        cloneDatabase(com.google.firestore.admin.v1.CloneDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCloneDatabaseMethod(), getCallOptions()), request);
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
  private static final int METHODID_BULK_DELETE_DOCUMENTS = 9;
  private static final int METHODID_CREATE_DATABASE = 10;
  private static final int METHODID_GET_DATABASE = 11;
  private static final int METHODID_LIST_DATABASES = 12;
  private static final int METHODID_UPDATE_DATABASE = 13;
  private static final int METHODID_DELETE_DATABASE = 14;
  private static final int METHODID_CREATE_USER_CREDS = 15;
  private static final int METHODID_GET_USER_CREDS = 16;
  private static final int METHODID_LIST_USER_CREDS = 17;
  private static final int METHODID_ENABLE_USER_CREDS = 18;
  private static final int METHODID_DISABLE_USER_CREDS = 19;
  private static final int METHODID_RESET_USER_PASSWORD = 20;
  private static final int METHODID_DELETE_USER_CREDS = 21;
  private static final int METHODID_GET_BACKUP = 22;
  private static final int METHODID_LIST_BACKUPS = 23;
  private static final int METHODID_DELETE_BACKUP = 24;
  private static final int METHODID_RESTORE_DATABASE = 25;
  private static final int METHODID_CREATE_BACKUP_SCHEDULE = 26;
  private static final int METHODID_GET_BACKUP_SCHEDULE = 27;
  private static final int METHODID_LIST_BACKUP_SCHEDULES = 28;
  private static final int METHODID_UPDATE_BACKUP_SCHEDULE = 29;
  private static final int METHODID_DELETE_BACKUP_SCHEDULE = 30;
  private static final int METHODID_CLONE_DATABASE = 31;

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
        case METHODID_BULK_DELETE_DOCUMENTS:
          serviceImpl.bulkDeleteDocuments(
              (com.google.firestore.admin.v1.BulkDeleteDocumentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_DATABASE:
          serviceImpl.createDatabase(
              (com.google.firestore.admin.v1.CreateDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_DATABASE:
          serviceImpl.getDatabase(
              (com.google.firestore.admin.v1.GetDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.Database>)
                  responseObserver);
          break;
        case METHODID_LIST_DATABASES:
          serviceImpl.listDatabases(
              (com.google.firestore.admin.v1.ListDatabasesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListDatabasesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATABASE:
          serviceImpl.updateDatabase(
              (com.google.firestore.admin.v1.UpdateDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_DATABASE:
          serviceImpl.deleteDatabase(
              (com.google.firestore.admin.v1.DeleteDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_USER_CREDS:
          serviceImpl.createUserCreds(
              (com.google.firestore.admin.v1.CreateUserCredsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.UserCreds>)
                  responseObserver);
          break;
        case METHODID_GET_USER_CREDS:
          serviceImpl.getUserCreds(
              (com.google.firestore.admin.v1.GetUserCredsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.UserCreds>)
                  responseObserver);
          break;
        case METHODID_LIST_USER_CREDS:
          serviceImpl.listUserCreds(
              (com.google.firestore.admin.v1.ListUserCredsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListUserCredsResponse>)
                  responseObserver);
          break;
        case METHODID_ENABLE_USER_CREDS:
          serviceImpl.enableUserCreds(
              (com.google.firestore.admin.v1.EnableUserCredsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.UserCreds>)
                  responseObserver);
          break;
        case METHODID_DISABLE_USER_CREDS:
          serviceImpl.disableUserCreds(
              (com.google.firestore.admin.v1.DisableUserCredsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.UserCreds>)
                  responseObserver);
          break;
        case METHODID_RESET_USER_PASSWORD:
          serviceImpl.resetUserPassword(
              (com.google.firestore.admin.v1.ResetUserPasswordRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.UserCreds>)
                  responseObserver);
          break;
        case METHODID_DELETE_USER_CREDS:
          serviceImpl.deleteUserCreds(
              (com.google.firestore.admin.v1.DeleteUserCredsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_BACKUP:
          serviceImpl.getBackup(
              (com.google.firestore.admin.v1.GetBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.Backup>) responseObserver);
          break;
        case METHODID_LIST_BACKUPS:
          serviceImpl.listBackups(
              (com.google.firestore.admin.v1.ListBackupsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.ListBackupsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_BACKUP:
          serviceImpl.deleteBackup(
              (com.google.firestore.admin.v1.DeleteBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_RESTORE_DATABASE:
          serviceImpl.restoreDatabase(
              (com.google.firestore.admin.v1.RestoreDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_BACKUP_SCHEDULE:
          serviceImpl.createBackupSchedule(
              (com.google.firestore.admin.v1.CreateBackupScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.BackupSchedule>)
                  responseObserver);
          break;
        case METHODID_GET_BACKUP_SCHEDULE:
          serviceImpl.getBackupSchedule(
              (com.google.firestore.admin.v1.GetBackupScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.BackupSchedule>)
                  responseObserver);
          break;
        case METHODID_LIST_BACKUP_SCHEDULES:
          serviceImpl.listBackupSchedules(
              (com.google.firestore.admin.v1.ListBackupSchedulesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.firestore.admin.v1.ListBackupSchedulesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_BACKUP_SCHEDULE:
          serviceImpl.updateBackupSchedule(
              (com.google.firestore.admin.v1.UpdateBackupScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.firestore.admin.v1.BackupSchedule>)
                  responseObserver);
          break;
        case METHODID_DELETE_BACKUP_SCHEDULE:
          serviceImpl.deleteBackupSchedule(
              (com.google.firestore.admin.v1.DeleteBackupScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CLONE_DATABASE:
          serviceImpl.cloneDatabase(
              (com.google.firestore.admin.v1.CloneDatabaseRequest) request,
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getCreateIndexMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.CreateIndexRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_INDEX)))
        .addMethod(
            getListIndexesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.ListIndexesRequest,
                    com.google.firestore.admin.v1.ListIndexesResponse>(
                    service, METHODID_LIST_INDEXES)))
        .addMethod(
            getGetIndexMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.GetIndexRequest,
                    com.google.firestore.admin.v1.Index>(service, METHODID_GET_INDEX)))
        .addMethod(
            getDeleteIndexMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.DeleteIndexRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_INDEX)))
        .addMethod(
            getGetFieldMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.GetFieldRequest,
                    com.google.firestore.admin.v1.Field>(service, METHODID_GET_FIELD)))
        .addMethod(
            getUpdateFieldMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.UpdateFieldRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_FIELD)))
        .addMethod(
            getListFieldsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.ListFieldsRequest,
                    com.google.firestore.admin.v1.ListFieldsResponse>(
                    service, METHODID_LIST_FIELDS)))
        .addMethod(
            getExportDocumentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.ExportDocumentsRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_DOCUMENTS)))
        .addMethod(
            getImportDocumentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.ImportDocumentsRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_DOCUMENTS)))
        .addMethod(
            getBulkDeleteDocumentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.BulkDeleteDocumentsRequest,
                    com.google.longrunning.Operation>(service, METHODID_BULK_DELETE_DOCUMENTS)))
        .addMethod(
            getCreateDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.CreateDatabaseRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_DATABASE)))
        .addMethod(
            getGetDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.GetDatabaseRequest,
                    com.google.firestore.admin.v1.Database>(service, METHODID_GET_DATABASE)))
        .addMethod(
            getListDatabasesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.ListDatabasesRequest,
                    com.google.firestore.admin.v1.ListDatabasesResponse>(
                    service, METHODID_LIST_DATABASES)))
        .addMethod(
            getUpdateDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.UpdateDatabaseRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_DATABASE)))
        .addMethod(
            getDeleteDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.DeleteDatabaseRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_DATABASE)))
        .addMethod(
            getCreateUserCredsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.CreateUserCredsRequest,
                    com.google.firestore.admin.v1.UserCreds>(service, METHODID_CREATE_USER_CREDS)))
        .addMethod(
            getGetUserCredsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.GetUserCredsRequest,
                    com.google.firestore.admin.v1.UserCreds>(service, METHODID_GET_USER_CREDS)))
        .addMethod(
            getListUserCredsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.ListUserCredsRequest,
                    com.google.firestore.admin.v1.ListUserCredsResponse>(
                    service, METHODID_LIST_USER_CREDS)))
        .addMethod(
            getEnableUserCredsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.EnableUserCredsRequest,
                    com.google.firestore.admin.v1.UserCreds>(service, METHODID_ENABLE_USER_CREDS)))
        .addMethod(
            getDisableUserCredsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.DisableUserCredsRequest,
                    com.google.firestore.admin.v1.UserCreds>(service, METHODID_DISABLE_USER_CREDS)))
        .addMethod(
            getResetUserPasswordMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.ResetUserPasswordRequest,
                    com.google.firestore.admin.v1.UserCreds>(
                    service, METHODID_RESET_USER_PASSWORD)))
        .addMethod(
            getDeleteUserCredsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.DeleteUserCredsRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_USER_CREDS)))
        .addMethod(
            getGetBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.GetBackupRequest,
                    com.google.firestore.admin.v1.Backup>(service, METHODID_GET_BACKUP)))
        .addMethod(
            getListBackupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.ListBackupsRequest,
                    com.google.firestore.admin.v1.ListBackupsResponse>(
                    service, METHODID_LIST_BACKUPS)))
        .addMethod(
            getDeleteBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.DeleteBackupRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_BACKUP)))
        .addMethod(
            getRestoreDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.RestoreDatabaseRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESTORE_DATABASE)))
        .addMethod(
            getCreateBackupScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.CreateBackupScheduleRequest,
                    com.google.firestore.admin.v1.BackupSchedule>(
                    service, METHODID_CREATE_BACKUP_SCHEDULE)))
        .addMethod(
            getGetBackupScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.GetBackupScheduleRequest,
                    com.google.firestore.admin.v1.BackupSchedule>(
                    service, METHODID_GET_BACKUP_SCHEDULE)))
        .addMethod(
            getListBackupSchedulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.ListBackupSchedulesRequest,
                    com.google.firestore.admin.v1.ListBackupSchedulesResponse>(
                    service, METHODID_LIST_BACKUP_SCHEDULES)))
        .addMethod(
            getUpdateBackupScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.UpdateBackupScheduleRequest,
                    com.google.firestore.admin.v1.BackupSchedule>(
                    service, METHODID_UPDATE_BACKUP_SCHEDULE)))
        .addMethod(
            getDeleteBackupScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.DeleteBackupScheduleRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_BACKUP_SCHEDULE)))
        .addMethod(
            getCloneDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.firestore.admin.v1.CloneDatabaseRequest,
                    com.google.longrunning.Operation>(service, METHODID_CLONE_DATABASE)))
        .build();
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
    private final java.lang.String methodName;

    FirestoreAdminMethodDescriptorSupplier(java.lang.String methodName) {
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
                      .addMethod(getCreateIndexMethod())
                      .addMethod(getListIndexesMethod())
                      .addMethod(getGetIndexMethod())
                      .addMethod(getDeleteIndexMethod())
                      .addMethod(getGetFieldMethod())
                      .addMethod(getUpdateFieldMethod())
                      .addMethod(getListFieldsMethod())
                      .addMethod(getExportDocumentsMethod())
                      .addMethod(getImportDocumentsMethod())
                      .addMethod(getBulkDeleteDocumentsMethod())
                      .addMethod(getCreateDatabaseMethod())
                      .addMethod(getGetDatabaseMethod())
                      .addMethod(getListDatabasesMethod())
                      .addMethod(getUpdateDatabaseMethod())
                      .addMethod(getDeleteDatabaseMethod())
                      .addMethod(getCreateUserCredsMethod())
                      .addMethod(getGetUserCredsMethod())
                      .addMethod(getListUserCredsMethod())
                      .addMethod(getEnableUserCredsMethod())
                      .addMethod(getDisableUserCredsMethod())
                      .addMethod(getResetUserPasswordMethod())
                      .addMethod(getDeleteUserCredsMethod())
                      .addMethod(getGetBackupMethod())
                      .addMethod(getListBackupsMethod())
                      .addMethod(getDeleteBackupMethod())
                      .addMethod(getRestoreDatabaseMethod())
                      .addMethod(getCreateBackupScheduleMethod())
                      .addMethod(getGetBackupScheduleMethod())
                      .addMethod(getListBackupSchedulesMethod())
                      .addMethod(getUpdateBackupScheduleMethod())
                      .addMethod(getDeleteBackupScheduleMethod())
                      .addMethod(getCloneDatabaseMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
