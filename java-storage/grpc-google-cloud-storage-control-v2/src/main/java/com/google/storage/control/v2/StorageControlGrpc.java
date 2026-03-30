/*
 * Copyright 2026 Google LLC
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
package com.google.storage.control.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * StorageControl service includes selected control plane operations.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class StorageControlGrpc {

  private StorageControlGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.storage.control.v2.StorageControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.CreateFolderRequest, com.google.storage.control.v2.Folder>
      getCreateFolderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFolder",
      requestType = com.google.storage.control.v2.CreateFolderRequest.class,
      responseType = com.google.storage.control.v2.Folder.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.CreateFolderRequest, com.google.storage.control.v2.Folder>
      getCreateFolderMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.CreateFolderRequest, com.google.storage.control.v2.Folder>
        getCreateFolderMethod;
    if ((getCreateFolderMethod = StorageControlGrpc.getCreateFolderMethod) == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getCreateFolderMethod = StorageControlGrpc.getCreateFolderMethod) == null) {
          StorageControlGrpc.getCreateFolderMethod =
              getCreateFolderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.CreateFolderRequest,
                          com.google.storage.control.v2.Folder>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFolder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.CreateFolderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.Folder.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("CreateFolder"))
                      .build();
        }
      }
    }
    return getCreateFolderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.DeleteFolderRequest, com.google.protobuf.Empty>
      getDeleteFolderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFolder",
      requestType = com.google.storage.control.v2.DeleteFolderRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.DeleteFolderRequest, com.google.protobuf.Empty>
      getDeleteFolderMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.DeleteFolderRequest, com.google.protobuf.Empty>
        getDeleteFolderMethod;
    if ((getDeleteFolderMethod = StorageControlGrpc.getDeleteFolderMethod) == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getDeleteFolderMethod = StorageControlGrpc.getDeleteFolderMethod) == null) {
          StorageControlGrpc.getDeleteFolderMethod =
              getDeleteFolderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.DeleteFolderRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFolder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.DeleteFolderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("DeleteFolder"))
                      .build();
        }
      }
    }
    return getDeleteFolderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.GetFolderRequest, com.google.storage.control.v2.Folder>
      getGetFolderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFolder",
      requestType = com.google.storage.control.v2.GetFolderRequest.class,
      responseType = com.google.storage.control.v2.Folder.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.GetFolderRequest, com.google.storage.control.v2.Folder>
      getGetFolderMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.GetFolderRequest, com.google.storage.control.v2.Folder>
        getGetFolderMethod;
    if ((getGetFolderMethod = StorageControlGrpc.getGetFolderMethod) == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getGetFolderMethod = StorageControlGrpc.getGetFolderMethod) == null) {
          StorageControlGrpc.getGetFolderMethod =
              getGetFolderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.GetFolderRequest,
                          com.google.storage.control.v2.Folder>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFolder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.GetFolderRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.Folder.getDefaultInstance()))
                      .setSchemaDescriptor(new StorageControlMethodDescriptorSupplier("GetFolder"))
                      .build();
        }
      }
    }
    return getGetFolderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.ListFoldersRequest,
          com.google.storage.control.v2.ListFoldersResponse>
      getListFoldersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFolders",
      requestType = com.google.storage.control.v2.ListFoldersRequest.class,
      responseType = com.google.storage.control.v2.ListFoldersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.ListFoldersRequest,
          com.google.storage.control.v2.ListFoldersResponse>
      getListFoldersMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.ListFoldersRequest,
            com.google.storage.control.v2.ListFoldersResponse>
        getListFoldersMethod;
    if ((getListFoldersMethod = StorageControlGrpc.getListFoldersMethod) == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getListFoldersMethod = StorageControlGrpc.getListFoldersMethod) == null) {
          StorageControlGrpc.getListFoldersMethod =
              getListFoldersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.ListFoldersRequest,
                          com.google.storage.control.v2.ListFoldersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFolders"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.ListFoldersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.ListFoldersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("ListFolders"))
                      .build();
        }
      }
    }
    return getListFoldersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.RenameFolderRequest, com.google.longrunning.Operation>
      getRenameFolderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RenameFolder",
      requestType = com.google.storage.control.v2.RenameFolderRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.RenameFolderRequest, com.google.longrunning.Operation>
      getRenameFolderMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.RenameFolderRequest, com.google.longrunning.Operation>
        getRenameFolderMethod;
    if ((getRenameFolderMethod = StorageControlGrpc.getRenameFolderMethod) == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getRenameFolderMethod = StorageControlGrpc.getRenameFolderMethod) == null) {
          StorageControlGrpc.getRenameFolderMethod =
              getRenameFolderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.RenameFolderRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RenameFolder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.RenameFolderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("RenameFolder"))
                      .build();
        }
      }
    }
    return getRenameFolderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.DeleteFolderRecursiveRequest,
          com.google.longrunning.Operation>
      getDeleteFolderRecursiveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFolderRecursive",
      requestType = com.google.storage.control.v2.DeleteFolderRecursiveRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.DeleteFolderRecursiveRequest,
          com.google.longrunning.Operation>
      getDeleteFolderRecursiveMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.DeleteFolderRecursiveRequest,
            com.google.longrunning.Operation>
        getDeleteFolderRecursiveMethod;
    if ((getDeleteFolderRecursiveMethod = StorageControlGrpc.getDeleteFolderRecursiveMethod)
        == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getDeleteFolderRecursiveMethod = StorageControlGrpc.getDeleteFolderRecursiveMethod)
            == null) {
          StorageControlGrpc.getDeleteFolderRecursiveMethod =
              getDeleteFolderRecursiveMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.DeleteFolderRecursiveRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteFolderRecursive"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.DeleteFolderRecursiveRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("DeleteFolderRecursive"))
                      .build();
        }
      }
    }
    return getDeleteFolderRecursiveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.GetStorageLayoutRequest,
          com.google.storage.control.v2.StorageLayout>
      getGetStorageLayoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStorageLayout",
      requestType = com.google.storage.control.v2.GetStorageLayoutRequest.class,
      responseType = com.google.storage.control.v2.StorageLayout.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.GetStorageLayoutRequest,
          com.google.storage.control.v2.StorageLayout>
      getGetStorageLayoutMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.GetStorageLayoutRequest,
            com.google.storage.control.v2.StorageLayout>
        getGetStorageLayoutMethod;
    if ((getGetStorageLayoutMethod = StorageControlGrpc.getGetStorageLayoutMethod) == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getGetStorageLayoutMethod = StorageControlGrpc.getGetStorageLayoutMethod) == null) {
          StorageControlGrpc.getGetStorageLayoutMethod =
              getGetStorageLayoutMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.GetStorageLayoutRequest,
                          com.google.storage.control.v2.StorageLayout>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStorageLayout"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.GetStorageLayoutRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.StorageLayout.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("GetStorageLayout"))
                      .build();
        }
      }
    }
    return getGetStorageLayoutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.CreateManagedFolderRequest,
          com.google.storage.control.v2.ManagedFolder>
      getCreateManagedFolderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateManagedFolder",
      requestType = com.google.storage.control.v2.CreateManagedFolderRequest.class,
      responseType = com.google.storage.control.v2.ManagedFolder.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.CreateManagedFolderRequest,
          com.google.storage.control.v2.ManagedFolder>
      getCreateManagedFolderMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.CreateManagedFolderRequest,
            com.google.storage.control.v2.ManagedFolder>
        getCreateManagedFolderMethod;
    if ((getCreateManagedFolderMethod = StorageControlGrpc.getCreateManagedFolderMethod) == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getCreateManagedFolderMethod = StorageControlGrpc.getCreateManagedFolderMethod)
            == null) {
          StorageControlGrpc.getCreateManagedFolderMethod =
              getCreateManagedFolderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.CreateManagedFolderRequest,
                          com.google.storage.control.v2.ManagedFolder>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateManagedFolder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.CreateManagedFolderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.ManagedFolder.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("CreateManagedFolder"))
                      .build();
        }
      }
    }
    return getCreateManagedFolderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.DeleteManagedFolderRequest, com.google.protobuf.Empty>
      getDeleteManagedFolderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteManagedFolder",
      requestType = com.google.storage.control.v2.DeleteManagedFolderRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.DeleteManagedFolderRequest, com.google.protobuf.Empty>
      getDeleteManagedFolderMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.DeleteManagedFolderRequest, com.google.protobuf.Empty>
        getDeleteManagedFolderMethod;
    if ((getDeleteManagedFolderMethod = StorageControlGrpc.getDeleteManagedFolderMethod) == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getDeleteManagedFolderMethod = StorageControlGrpc.getDeleteManagedFolderMethod)
            == null) {
          StorageControlGrpc.getDeleteManagedFolderMethod =
              getDeleteManagedFolderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.DeleteManagedFolderRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteManagedFolder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.DeleteManagedFolderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("DeleteManagedFolder"))
                      .build();
        }
      }
    }
    return getDeleteManagedFolderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.GetManagedFolderRequest,
          com.google.storage.control.v2.ManagedFolder>
      getGetManagedFolderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetManagedFolder",
      requestType = com.google.storage.control.v2.GetManagedFolderRequest.class,
      responseType = com.google.storage.control.v2.ManagedFolder.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.GetManagedFolderRequest,
          com.google.storage.control.v2.ManagedFolder>
      getGetManagedFolderMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.GetManagedFolderRequest,
            com.google.storage.control.v2.ManagedFolder>
        getGetManagedFolderMethod;
    if ((getGetManagedFolderMethod = StorageControlGrpc.getGetManagedFolderMethod) == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getGetManagedFolderMethod = StorageControlGrpc.getGetManagedFolderMethod) == null) {
          StorageControlGrpc.getGetManagedFolderMethod =
              getGetManagedFolderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.GetManagedFolderRequest,
                          com.google.storage.control.v2.ManagedFolder>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetManagedFolder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.GetManagedFolderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.ManagedFolder.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("GetManagedFolder"))
                      .build();
        }
      }
    }
    return getGetManagedFolderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.ListManagedFoldersRequest,
          com.google.storage.control.v2.ListManagedFoldersResponse>
      getListManagedFoldersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListManagedFolders",
      requestType = com.google.storage.control.v2.ListManagedFoldersRequest.class,
      responseType = com.google.storage.control.v2.ListManagedFoldersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.ListManagedFoldersRequest,
          com.google.storage.control.v2.ListManagedFoldersResponse>
      getListManagedFoldersMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.ListManagedFoldersRequest,
            com.google.storage.control.v2.ListManagedFoldersResponse>
        getListManagedFoldersMethod;
    if ((getListManagedFoldersMethod = StorageControlGrpc.getListManagedFoldersMethod) == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getListManagedFoldersMethod = StorageControlGrpc.getListManagedFoldersMethod)
            == null) {
          StorageControlGrpc.getListManagedFoldersMethod =
              getListManagedFoldersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.ListManagedFoldersRequest,
                          com.google.storage.control.v2.ListManagedFoldersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListManagedFolders"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.ListManagedFoldersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.ListManagedFoldersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("ListManagedFolders"))
                      .build();
        }
      }
    }
    return getListManagedFoldersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.CreateAnywhereCacheRequest,
          com.google.longrunning.Operation>
      getCreateAnywhereCacheMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAnywhereCache",
      requestType = com.google.storage.control.v2.CreateAnywhereCacheRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.CreateAnywhereCacheRequest,
          com.google.longrunning.Operation>
      getCreateAnywhereCacheMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.CreateAnywhereCacheRequest,
            com.google.longrunning.Operation>
        getCreateAnywhereCacheMethod;
    if ((getCreateAnywhereCacheMethod = StorageControlGrpc.getCreateAnywhereCacheMethod) == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getCreateAnywhereCacheMethod = StorageControlGrpc.getCreateAnywhereCacheMethod)
            == null) {
          StorageControlGrpc.getCreateAnywhereCacheMethod =
              getCreateAnywhereCacheMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.CreateAnywhereCacheRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateAnywhereCache"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.CreateAnywhereCacheRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("CreateAnywhereCache"))
                      .build();
        }
      }
    }
    return getCreateAnywhereCacheMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.UpdateAnywhereCacheRequest,
          com.google.longrunning.Operation>
      getUpdateAnywhereCacheMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAnywhereCache",
      requestType = com.google.storage.control.v2.UpdateAnywhereCacheRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.UpdateAnywhereCacheRequest,
          com.google.longrunning.Operation>
      getUpdateAnywhereCacheMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.UpdateAnywhereCacheRequest,
            com.google.longrunning.Operation>
        getUpdateAnywhereCacheMethod;
    if ((getUpdateAnywhereCacheMethod = StorageControlGrpc.getUpdateAnywhereCacheMethod) == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getUpdateAnywhereCacheMethod = StorageControlGrpc.getUpdateAnywhereCacheMethod)
            == null) {
          StorageControlGrpc.getUpdateAnywhereCacheMethod =
              getUpdateAnywhereCacheMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.UpdateAnywhereCacheRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateAnywhereCache"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.UpdateAnywhereCacheRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("UpdateAnywhereCache"))
                      .build();
        }
      }
    }
    return getUpdateAnywhereCacheMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.DisableAnywhereCacheRequest,
          com.google.storage.control.v2.AnywhereCache>
      getDisableAnywhereCacheMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisableAnywhereCache",
      requestType = com.google.storage.control.v2.DisableAnywhereCacheRequest.class,
      responseType = com.google.storage.control.v2.AnywhereCache.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.DisableAnywhereCacheRequest,
          com.google.storage.control.v2.AnywhereCache>
      getDisableAnywhereCacheMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.DisableAnywhereCacheRequest,
            com.google.storage.control.v2.AnywhereCache>
        getDisableAnywhereCacheMethod;
    if ((getDisableAnywhereCacheMethod = StorageControlGrpc.getDisableAnywhereCacheMethod)
        == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getDisableAnywhereCacheMethod = StorageControlGrpc.getDisableAnywhereCacheMethod)
            == null) {
          StorageControlGrpc.getDisableAnywhereCacheMethod =
              getDisableAnywhereCacheMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.DisableAnywhereCacheRequest,
                          com.google.storage.control.v2.AnywhereCache>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DisableAnywhereCache"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.DisableAnywhereCacheRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.AnywhereCache.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("DisableAnywhereCache"))
                      .build();
        }
      }
    }
    return getDisableAnywhereCacheMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.PauseAnywhereCacheRequest,
          com.google.storage.control.v2.AnywhereCache>
      getPauseAnywhereCacheMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PauseAnywhereCache",
      requestType = com.google.storage.control.v2.PauseAnywhereCacheRequest.class,
      responseType = com.google.storage.control.v2.AnywhereCache.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.PauseAnywhereCacheRequest,
          com.google.storage.control.v2.AnywhereCache>
      getPauseAnywhereCacheMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.PauseAnywhereCacheRequest,
            com.google.storage.control.v2.AnywhereCache>
        getPauseAnywhereCacheMethod;
    if ((getPauseAnywhereCacheMethod = StorageControlGrpc.getPauseAnywhereCacheMethod) == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getPauseAnywhereCacheMethod = StorageControlGrpc.getPauseAnywhereCacheMethod)
            == null) {
          StorageControlGrpc.getPauseAnywhereCacheMethod =
              getPauseAnywhereCacheMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.PauseAnywhereCacheRequest,
                          com.google.storage.control.v2.AnywhereCache>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PauseAnywhereCache"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.PauseAnywhereCacheRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.AnywhereCache.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("PauseAnywhereCache"))
                      .build();
        }
      }
    }
    return getPauseAnywhereCacheMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.ResumeAnywhereCacheRequest,
          com.google.storage.control.v2.AnywhereCache>
      getResumeAnywhereCacheMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResumeAnywhereCache",
      requestType = com.google.storage.control.v2.ResumeAnywhereCacheRequest.class,
      responseType = com.google.storage.control.v2.AnywhereCache.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.ResumeAnywhereCacheRequest,
          com.google.storage.control.v2.AnywhereCache>
      getResumeAnywhereCacheMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.ResumeAnywhereCacheRequest,
            com.google.storage.control.v2.AnywhereCache>
        getResumeAnywhereCacheMethod;
    if ((getResumeAnywhereCacheMethod = StorageControlGrpc.getResumeAnywhereCacheMethod) == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getResumeAnywhereCacheMethod = StorageControlGrpc.getResumeAnywhereCacheMethod)
            == null) {
          StorageControlGrpc.getResumeAnywhereCacheMethod =
              getResumeAnywhereCacheMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.ResumeAnywhereCacheRequest,
                          com.google.storage.control.v2.AnywhereCache>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ResumeAnywhereCache"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.ResumeAnywhereCacheRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.AnywhereCache.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("ResumeAnywhereCache"))
                      .build();
        }
      }
    }
    return getResumeAnywhereCacheMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.GetAnywhereCacheRequest,
          com.google.storage.control.v2.AnywhereCache>
      getGetAnywhereCacheMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnywhereCache",
      requestType = com.google.storage.control.v2.GetAnywhereCacheRequest.class,
      responseType = com.google.storage.control.v2.AnywhereCache.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.GetAnywhereCacheRequest,
          com.google.storage.control.v2.AnywhereCache>
      getGetAnywhereCacheMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.GetAnywhereCacheRequest,
            com.google.storage.control.v2.AnywhereCache>
        getGetAnywhereCacheMethod;
    if ((getGetAnywhereCacheMethod = StorageControlGrpc.getGetAnywhereCacheMethod) == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getGetAnywhereCacheMethod = StorageControlGrpc.getGetAnywhereCacheMethod) == null) {
          StorageControlGrpc.getGetAnywhereCacheMethod =
              getGetAnywhereCacheMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.GetAnywhereCacheRequest,
                          com.google.storage.control.v2.AnywhereCache>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAnywhereCache"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.GetAnywhereCacheRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.AnywhereCache.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("GetAnywhereCache"))
                      .build();
        }
      }
    }
    return getGetAnywhereCacheMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.ListAnywhereCachesRequest,
          com.google.storage.control.v2.ListAnywhereCachesResponse>
      getListAnywhereCachesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAnywhereCaches",
      requestType = com.google.storage.control.v2.ListAnywhereCachesRequest.class,
      responseType = com.google.storage.control.v2.ListAnywhereCachesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.ListAnywhereCachesRequest,
          com.google.storage.control.v2.ListAnywhereCachesResponse>
      getListAnywhereCachesMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.ListAnywhereCachesRequest,
            com.google.storage.control.v2.ListAnywhereCachesResponse>
        getListAnywhereCachesMethod;
    if ((getListAnywhereCachesMethod = StorageControlGrpc.getListAnywhereCachesMethod) == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getListAnywhereCachesMethod = StorageControlGrpc.getListAnywhereCachesMethod)
            == null) {
          StorageControlGrpc.getListAnywhereCachesMethod =
              getListAnywhereCachesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.ListAnywhereCachesRequest,
                          com.google.storage.control.v2.ListAnywhereCachesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAnywhereCaches"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.ListAnywhereCachesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.ListAnywhereCachesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("ListAnywhereCaches"))
                      .build();
        }
      }
    }
    return getListAnywhereCachesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.GetProjectIntelligenceConfigRequest,
          com.google.storage.control.v2.IntelligenceConfig>
      getGetProjectIntelligenceConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProjectIntelligenceConfig",
      requestType = com.google.storage.control.v2.GetProjectIntelligenceConfigRequest.class,
      responseType = com.google.storage.control.v2.IntelligenceConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.GetProjectIntelligenceConfigRequest,
          com.google.storage.control.v2.IntelligenceConfig>
      getGetProjectIntelligenceConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.GetProjectIntelligenceConfigRequest,
            com.google.storage.control.v2.IntelligenceConfig>
        getGetProjectIntelligenceConfigMethod;
    if ((getGetProjectIntelligenceConfigMethod =
            StorageControlGrpc.getGetProjectIntelligenceConfigMethod)
        == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getGetProjectIntelligenceConfigMethod =
                StorageControlGrpc.getGetProjectIntelligenceConfigMethod)
            == null) {
          StorageControlGrpc.getGetProjectIntelligenceConfigMethod =
              getGetProjectIntelligenceConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.GetProjectIntelligenceConfigRequest,
                          com.google.storage.control.v2.IntelligenceConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetProjectIntelligenceConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.GetProjectIntelligenceConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.IntelligenceConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier(
                              "GetProjectIntelligenceConfig"))
                      .build();
        }
      }
    }
    return getGetProjectIntelligenceConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.UpdateProjectIntelligenceConfigRequest,
          com.google.storage.control.v2.IntelligenceConfig>
      getUpdateProjectIntelligenceConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateProjectIntelligenceConfig",
      requestType = com.google.storage.control.v2.UpdateProjectIntelligenceConfigRequest.class,
      responseType = com.google.storage.control.v2.IntelligenceConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.UpdateProjectIntelligenceConfigRequest,
          com.google.storage.control.v2.IntelligenceConfig>
      getUpdateProjectIntelligenceConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.UpdateProjectIntelligenceConfigRequest,
            com.google.storage.control.v2.IntelligenceConfig>
        getUpdateProjectIntelligenceConfigMethod;
    if ((getUpdateProjectIntelligenceConfigMethod =
            StorageControlGrpc.getUpdateProjectIntelligenceConfigMethod)
        == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getUpdateProjectIntelligenceConfigMethod =
                StorageControlGrpc.getUpdateProjectIntelligenceConfigMethod)
            == null) {
          StorageControlGrpc.getUpdateProjectIntelligenceConfigMethod =
              getUpdateProjectIntelligenceConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.UpdateProjectIntelligenceConfigRequest,
                          com.google.storage.control.v2.IntelligenceConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateProjectIntelligenceConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.UpdateProjectIntelligenceConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.IntelligenceConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier(
                              "UpdateProjectIntelligenceConfig"))
                      .build();
        }
      }
    }
    return getUpdateProjectIntelligenceConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.GetFolderIntelligenceConfigRequest,
          com.google.storage.control.v2.IntelligenceConfig>
      getGetFolderIntelligenceConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFolderIntelligenceConfig",
      requestType = com.google.storage.control.v2.GetFolderIntelligenceConfigRequest.class,
      responseType = com.google.storage.control.v2.IntelligenceConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.GetFolderIntelligenceConfigRequest,
          com.google.storage.control.v2.IntelligenceConfig>
      getGetFolderIntelligenceConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.GetFolderIntelligenceConfigRequest,
            com.google.storage.control.v2.IntelligenceConfig>
        getGetFolderIntelligenceConfigMethod;
    if ((getGetFolderIntelligenceConfigMethod =
            StorageControlGrpc.getGetFolderIntelligenceConfigMethod)
        == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getGetFolderIntelligenceConfigMethod =
                StorageControlGrpc.getGetFolderIntelligenceConfigMethod)
            == null) {
          StorageControlGrpc.getGetFolderIntelligenceConfigMethod =
              getGetFolderIntelligenceConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.GetFolderIntelligenceConfigRequest,
                          com.google.storage.control.v2.IntelligenceConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetFolderIntelligenceConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.GetFolderIntelligenceConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.IntelligenceConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("GetFolderIntelligenceConfig"))
                      .build();
        }
      }
    }
    return getGetFolderIntelligenceConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.UpdateFolderIntelligenceConfigRequest,
          com.google.storage.control.v2.IntelligenceConfig>
      getUpdateFolderIntelligenceConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFolderIntelligenceConfig",
      requestType = com.google.storage.control.v2.UpdateFolderIntelligenceConfigRequest.class,
      responseType = com.google.storage.control.v2.IntelligenceConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.UpdateFolderIntelligenceConfigRequest,
          com.google.storage.control.v2.IntelligenceConfig>
      getUpdateFolderIntelligenceConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.UpdateFolderIntelligenceConfigRequest,
            com.google.storage.control.v2.IntelligenceConfig>
        getUpdateFolderIntelligenceConfigMethod;
    if ((getUpdateFolderIntelligenceConfigMethod =
            StorageControlGrpc.getUpdateFolderIntelligenceConfigMethod)
        == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getUpdateFolderIntelligenceConfigMethod =
                StorageControlGrpc.getUpdateFolderIntelligenceConfigMethod)
            == null) {
          StorageControlGrpc.getUpdateFolderIntelligenceConfigMethod =
              getUpdateFolderIntelligenceConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.UpdateFolderIntelligenceConfigRequest,
                          com.google.storage.control.v2.IntelligenceConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateFolderIntelligenceConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.UpdateFolderIntelligenceConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.IntelligenceConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier(
                              "UpdateFolderIntelligenceConfig"))
                      .build();
        }
      }
    }
    return getUpdateFolderIntelligenceConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.GetOrganizationIntelligenceConfigRequest,
          com.google.storage.control.v2.IntelligenceConfig>
      getGetOrganizationIntelligenceConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOrganizationIntelligenceConfig",
      requestType = com.google.storage.control.v2.GetOrganizationIntelligenceConfigRequest.class,
      responseType = com.google.storage.control.v2.IntelligenceConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.GetOrganizationIntelligenceConfigRequest,
          com.google.storage.control.v2.IntelligenceConfig>
      getGetOrganizationIntelligenceConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.GetOrganizationIntelligenceConfigRequest,
            com.google.storage.control.v2.IntelligenceConfig>
        getGetOrganizationIntelligenceConfigMethod;
    if ((getGetOrganizationIntelligenceConfigMethod =
            StorageControlGrpc.getGetOrganizationIntelligenceConfigMethod)
        == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getGetOrganizationIntelligenceConfigMethod =
                StorageControlGrpc.getGetOrganizationIntelligenceConfigMethod)
            == null) {
          StorageControlGrpc.getGetOrganizationIntelligenceConfigMethod =
              getGetOrganizationIntelligenceConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.GetOrganizationIntelligenceConfigRequest,
                          com.google.storage.control.v2.IntelligenceConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetOrganizationIntelligenceConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.GetOrganizationIntelligenceConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.IntelligenceConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier(
                              "GetOrganizationIntelligenceConfig"))
                      .build();
        }
      }
    }
    return getGetOrganizationIntelligenceConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.control.v2.UpdateOrganizationIntelligenceConfigRequest,
          com.google.storage.control.v2.IntelligenceConfig>
      getUpdateOrganizationIntelligenceConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateOrganizationIntelligenceConfig",
      requestType = com.google.storage.control.v2.UpdateOrganizationIntelligenceConfigRequest.class,
      responseType = com.google.storage.control.v2.IntelligenceConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.control.v2.UpdateOrganizationIntelligenceConfigRequest,
          com.google.storage.control.v2.IntelligenceConfig>
      getUpdateOrganizationIntelligenceConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.control.v2.UpdateOrganizationIntelligenceConfigRequest,
            com.google.storage.control.v2.IntelligenceConfig>
        getUpdateOrganizationIntelligenceConfigMethod;
    if ((getUpdateOrganizationIntelligenceConfigMethod =
            StorageControlGrpc.getUpdateOrganizationIntelligenceConfigMethod)
        == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getUpdateOrganizationIntelligenceConfigMethod =
                StorageControlGrpc.getUpdateOrganizationIntelligenceConfigMethod)
            == null) {
          StorageControlGrpc.getUpdateOrganizationIntelligenceConfigMethod =
              getUpdateOrganizationIntelligenceConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.control.v2.UpdateOrganizationIntelligenceConfigRequest,
                          com.google.storage.control.v2.IntelligenceConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "UpdateOrganizationIntelligenceConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2
                                  .UpdateOrganizationIntelligenceConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.control.v2.IntelligenceConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier(
                              "UpdateOrganizationIntelligenceConfig"))
                      .build();
        }
      }
    }
    return getUpdateOrganizationIntelligenceConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
        getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = StorageControlGrpc.getGetIamPolicyMethod) == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getGetIamPolicyMethod = StorageControlGrpc.getGetIamPolicyMethod) == null) {
          StorageControlGrpc.getGetIamPolicyMethod =
              getGetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
        getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = StorageControlGrpc.getSetIamPolicyMethod) == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getSetIamPolicyMethod = StorageControlGrpc.getSetIamPolicyMethod) == null) {
          StorageControlGrpc.getSetIamPolicyMethod =
              getSetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("SetIamPolicy"))
                      .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v1.TestIamPermissionsRequest,
            com.google.iam.v1.TestIamPermissionsResponse>
        getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = StorageControlGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (StorageControlGrpc.class) {
        if ((getTestIamPermissionsMethod = StorageControlGrpc.getTestIamPermissionsMethod)
            == null) {
          StorageControlGrpc.getTestIamPermissionsMethod =
              getTestIamPermissionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.TestIamPermissionsRequest,
                          com.google.iam.v1.TestIamPermissionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageControlMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static StorageControlStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StorageControlStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StorageControlStub>() {
          @java.lang.Override
          public StorageControlStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StorageControlStub(channel, callOptions);
          }
        };
    return StorageControlStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static StorageControlBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StorageControlBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StorageControlBlockingV2Stub>() {
          @java.lang.Override
          public StorageControlBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StorageControlBlockingV2Stub(channel, callOptions);
          }
        };
    return StorageControlBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StorageControlBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StorageControlBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StorageControlBlockingStub>() {
          @java.lang.Override
          public StorageControlBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StorageControlBlockingStub(channel, callOptions);
          }
        };
    return StorageControlBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static StorageControlFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StorageControlFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StorageControlFutureStub>() {
          @java.lang.Override
          public StorageControlFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StorageControlFutureStub(channel, callOptions);
          }
        };
    return StorageControlFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * StorageControl service includes selected control plane operations.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new folder. This operation is only applicable to a hierarchical
     * namespace enabled bucket.
     * </pre>
     */
    default void createFolder(
        com.google.storage.control.v2.CreateFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.Folder> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateFolderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes an empty folder. This operation is only applicable to a
     * hierarchical namespace enabled bucket.
     * </pre>
     */
    default void deleteFolder(
        com.google.storage.control.v2.DeleteFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteFolderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for the specified folder. This operation is only
     * applicable to a hierarchical namespace enabled bucket.
     * </pre>
     */
    default void getFolder(
        com.google.storage.control.v2.GetFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.Folder> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFolderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of folders. This operation is only applicable to a
     * hierarchical namespace enabled bucket.
     * </pre>
     */
    default void listFolders(
        com.google.storage.control.v2.ListFoldersRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.ListFoldersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFoldersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Renames a source folder to a destination folder. This operation is only
     * applicable to a hierarchical namespace enabled bucket. During a rename, the
     * source and destination folders are locked until the long running operation
     * completes.
     * </pre>
     */
    default void renameFolder(
        com.google.storage.control.v2.RenameFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRenameFolderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a folder recursively. This operation is only applicable to a
     * hierarchical namespace enabled bucket.
     * </pre>
     */
    default void deleteFolderRecursive(
        com.google.storage.control.v2.DeleteFolderRecursiveRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteFolderRecursiveMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the storage layout configuration for a given bucket.
     * </pre>
     */
    default void getStorageLayout(
        com.google.storage.control.v2.GetStorageLayoutRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.StorageLayout> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetStorageLayoutMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new managed folder.
     * </pre>
     */
    default void createManagedFolder(
        com.google.storage.control.v2.CreateManagedFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.ManagedFolder> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateManagedFolderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes an empty managed folder.
     * </pre>
     */
    default void deleteManagedFolder(
        com.google.storage.control.v2.DeleteManagedFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteManagedFolderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for the specified managed folder.
     * </pre>
     */
    default void getManagedFolder(
        com.google.storage.control.v2.GetManagedFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.ManagedFolder> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetManagedFolderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of managed folders for a given bucket.
     * </pre>
     */
    default void listManagedFolders(
        com.google.storage.control.v2.ListManagedFoldersRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.ListManagedFoldersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListManagedFoldersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an Anywhere Cache instance.
     * </pre>
     */
    default void createAnywhereCache(
        com.google.storage.control.v2.CreateAnywhereCacheRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAnywhereCacheMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an Anywhere Cache instance. Mutable fields include `ttl` and
     * `admission_policy`.
     * </pre>
     */
    default void updateAnywhereCache(
        com.google.storage.control.v2.UpdateAnywhereCacheRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAnywhereCacheMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disables an Anywhere Cache instance. A disabled instance is read-only. The
     * disablement could be revoked by calling ResumeAnywhereCache. The cache
     * instance will be deleted automatically if it remains in the disabled state
     * for at least one hour.
     * </pre>
     */
    default void disableAnywhereCache(
        com.google.storage.control.v2.DisableAnywhereCacheRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.AnywhereCache> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDisableAnywhereCacheMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses an Anywhere Cache instance.
     * </pre>
     */
    default void pauseAnywhereCache(
        com.google.storage.control.v2.PauseAnywhereCacheRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.AnywhereCache> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPauseAnywhereCacheMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resumes a disabled or paused Anywhere Cache instance.
     * </pre>
     */
    default void resumeAnywhereCache(
        com.google.storage.control.v2.ResumeAnywhereCacheRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.AnywhereCache> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResumeAnywhereCacheMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an Anywhere Cache instance.
     * </pre>
     */
    default void getAnywhereCache(
        com.google.storage.control.v2.GetAnywhereCacheRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.AnywhereCache> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAnywhereCacheMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Anywhere Cache instances for a given bucket.
     * </pre>
     */
    default void listAnywhereCaches(
        com.google.storage.control.v2.ListAnywhereCachesRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.ListAnywhereCachesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAnywhereCachesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the Project scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    default void getProjectIntelligenceConfig(
        com.google.storage.control.v2.GetProjectIntelligenceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.IntelligenceConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetProjectIntelligenceConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Project scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    default void updateProjectIntelligenceConfig(
        com.google.storage.control.v2.UpdateProjectIntelligenceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.IntelligenceConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateProjectIntelligenceConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the Folder scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    default void getFolderIntelligenceConfig(
        com.google.storage.control.v2.GetFolderIntelligenceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.IntelligenceConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetFolderIntelligenceConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Folder scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    default void updateFolderIntelligenceConfig(
        com.google.storage.control.v2.UpdateFolderIntelligenceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.IntelligenceConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFolderIntelligenceConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the Organization scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    default void getOrganizationIntelligenceConfig(
        com.google.storage.control.v2.GetOrganizationIntelligenceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.IntelligenceConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetOrganizationIntelligenceConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Organization scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    default void updateOrganizationIntelligenceConfig(
        com.google.storage.control.v2.UpdateOrganizationIntelligenceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.IntelligenceConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateOrganizationIntelligenceConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for a specified bucket.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    default void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an IAM policy for the specified bucket.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    default void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Tests a set of permissions on the given bucket, object, or managed folder
     * to see which, if any, are held by the caller.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket,
     * `projects/_/buckets/{bucket}/objects/{object}` for an object, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    default void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTestIamPermissionsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service StorageControl.
   *
   * <pre>
   * StorageControl service includes selected control plane operations.
   * </pre>
   */
  public abstract static class StorageControlImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return StorageControlGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service StorageControl.
   *
   * <pre>
   * StorageControl service includes selected control plane operations.
   * </pre>
   */
  public static final class StorageControlStub
      extends io.grpc.stub.AbstractAsyncStub<StorageControlStub> {
    private StorageControlStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageControlStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StorageControlStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new folder. This operation is only applicable to a hierarchical
     * namespace enabled bucket.
     * </pre>
     */
    public void createFolder(
        com.google.storage.control.v2.CreateFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.Folder> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFolderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes an empty folder. This operation is only applicable to a
     * hierarchical namespace enabled bucket.
     * </pre>
     */
    public void deleteFolder(
        com.google.storage.control.v2.DeleteFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFolderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for the specified folder. This operation is only
     * applicable to a hierarchical namespace enabled bucket.
     * </pre>
     */
    public void getFolder(
        com.google.storage.control.v2.GetFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.Folder> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFolderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of folders. This operation is only applicable to a
     * hierarchical namespace enabled bucket.
     * </pre>
     */
    public void listFolders(
        com.google.storage.control.v2.ListFoldersRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.ListFoldersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFoldersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Renames a source folder to a destination folder. This operation is only
     * applicable to a hierarchical namespace enabled bucket. During a rename, the
     * source and destination folders are locked until the long running operation
     * completes.
     * </pre>
     */
    public void renameFolder(
        com.google.storage.control.v2.RenameFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRenameFolderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a folder recursively. This operation is only applicable to a
     * hierarchical namespace enabled bucket.
     * </pre>
     */
    public void deleteFolderRecursive(
        com.google.storage.control.v2.DeleteFolderRecursiveRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFolderRecursiveMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the storage layout configuration for a given bucket.
     * </pre>
     */
    public void getStorageLayout(
        com.google.storage.control.v2.GetStorageLayoutRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.StorageLayout> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStorageLayoutMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new managed folder.
     * </pre>
     */
    public void createManagedFolder(
        com.google.storage.control.v2.CreateManagedFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.ManagedFolder> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateManagedFolderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes an empty managed folder.
     * </pre>
     */
    public void deleteManagedFolder(
        com.google.storage.control.v2.DeleteManagedFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteManagedFolderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for the specified managed folder.
     * </pre>
     */
    public void getManagedFolder(
        com.google.storage.control.v2.GetManagedFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.ManagedFolder> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetManagedFolderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of managed folders for a given bucket.
     * </pre>
     */
    public void listManagedFolders(
        com.google.storage.control.v2.ListManagedFoldersRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.ListManagedFoldersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListManagedFoldersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an Anywhere Cache instance.
     * </pre>
     */
    public void createAnywhereCache(
        com.google.storage.control.v2.CreateAnywhereCacheRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAnywhereCacheMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an Anywhere Cache instance. Mutable fields include `ttl` and
     * `admission_policy`.
     * </pre>
     */
    public void updateAnywhereCache(
        com.google.storage.control.v2.UpdateAnywhereCacheRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAnywhereCacheMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disables an Anywhere Cache instance. A disabled instance is read-only. The
     * disablement could be revoked by calling ResumeAnywhereCache. The cache
     * instance will be deleted automatically if it remains in the disabled state
     * for at least one hour.
     * </pre>
     */
    public void disableAnywhereCache(
        com.google.storage.control.v2.DisableAnywhereCacheRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.AnywhereCache> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisableAnywhereCacheMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses an Anywhere Cache instance.
     * </pre>
     */
    public void pauseAnywhereCache(
        com.google.storage.control.v2.PauseAnywhereCacheRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.AnywhereCache> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPauseAnywhereCacheMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resumes a disabled or paused Anywhere Cache instance.
     * </pre>
     */
    public void resumeAnywhereCache(
        com.google.storage.control.v2.ResumeAnywhereCacheRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.AnywhereCache> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResumeAnywhereCacheMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an Anywhere Cache instance.
     * </pre>
     */
    public void getAnywhereCache(
        com.google.storage.control.v2.GetAnywhereCacheRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.AnywhereCache> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnywhereCacheMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Anywhere Cache instances for a given bucket.
     * </pre>
     */
    public void listAnywhereCaches(
        com.google.storage.control.v2.ListAnywhereCachesRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.ListAnywhereCachesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAnywhereCachesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the Project scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public void getProjectIntelligenceConfig(
        com.google.storage.control.v2.GetProjectIntelligenceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.IntelligenceConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProjectIntelligenceConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Project scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public void updateProjectIntelligenceConfig(
        com.google.storage.control.v2.UpdateProjectIntelligenceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.IntelligenceConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateProjectIntelligenceConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the Folder scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public void getFolderIntelligenceConfig(
        com.google.storage.control.v2.GetFolderIntelligenceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.IntelligenceConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFolderIntelligenceConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Folder scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public void updateFolderIntelligenceConfig(
        com.google.storage.control.v2.UpdateFolderIntelligenceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.IntelligenceConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFolderIntelligenceConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the Organization scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public void getOrganizationIntelligenceConfig(
        com.google.storage.control.v2.GetOrganizationIntelligenceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.IntelligenceConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOrganizationIntelligenceConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Organization scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public void updateOrganizationIntelligenceConfig(
        com.google.storage.control.v2.UpdateOrganizationIntelligenceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.control.v2.IntelligenceConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateOrganizationIntelligenceConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for a specified bucket.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an IAM policy for the specified bucket.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Tests a set of permissions on the given bucket, object, or managed folder
     * to see which, if any, are held by the caller.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket,
     * `projects/_/buckets/{bucket}/objects/{object}` for an object, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service StorageControl.
   *
   * <pre>
   * StorageControl service includes selected control plane operations.
   * </pre>
   */
  public static final class StorageControlBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<StorageControlBlockingV2Stub> {
    private StorageControlBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageControlBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StorageControlBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new folder. This operation is only applicable to a hierarchical
     * namespace enabled bucket.
     * </pre>
     */
    public com.google.storage.control.v2.Folder createFolder(
        com.google.storage.control.v2.CreateFolderRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateFolderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes an empty folder. This operation is only applicable to a
     * hierarchical namespace enabled bucket.
     * </pre>
     */
    public com.google.protobuf.Empty deleteFolder(
        com.google.storage.control.v2.DeleteFolderRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteFolderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for the specified folder. This operation is only
     * applicable to a hierarchical namespace enabled bucket.
     * </pre>
     */
    public com.google.storage.control.v2.Folder getFolder(
        com.google.storage.control.v2.GetFolderRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetFolderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of folders. This operation is only applicable to a
     * hierarchical namespace enabled bucket.
     * </pre>
     */
    public com.google.storage.control.v2.ListFoldersResponse listFolders(
        com.google.storage.control.v2.ListFoldersRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListFoldersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Renames a source folder to a destination folder. This operation is only
     * applicable to a hierarchical namespace enabled bucket. During a rename, the
     * source and destination folders are locked until the long running operation
     * completes.
     * </pre>
     */
    public com.google.longrunning.Operation renameFolder(
        com.google.storage.control.v2.RenameFolderRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRenameFolderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a folder recursively. This operation is only applicable to a
     * hierarchical namespace enabled bucket.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFolderRecursive(
        com.google.storage.control.v2.DeleteFolderRecursiveRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteFolderRecursiveMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the storage layout configuration for a given bucket.
     * </pre>
     */
    public com.google.storage.control.v2.StorageLayout getStorageLayout(
        com.google.storage.control.v2.GetStorageLayoutRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetStorageLayoutMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new managed folder.
     * </pre>
     */
    public com.google.storage.control.v2.ManagedFolder createManagedFolder(
        com.google.storage.control.v2.CreateManagedFolderRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateManagedFolderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes an empty managed folder.
     * </pre>
     */
    public com.google.protobuf.Empty deleteManagedFolder(
        com.google.storage.control.v2.DeleteManagedFolderRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteManagedFolderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for the specified managed folder.
     * </pre>
     */
    public com.google.storage.control.v2.ManagedFolder getManagedFolder(
        com.google.storage.control.v2.GetManagedFolderRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetManagedFolderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of managed folders for a given bucket.
     * </pre>
     */
    public com.google.storage.control.v2.ListManagedFoldersResponse listManagedFolders(
        com.google.storage.control.v2.ListManagedFoldersRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListManagedFoldersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an Anywhere Cache instance.
     * </pre>
     */
    public com.google.longrunning.Operation createAnywhereCache(
        com.google.storage.control.v2.CreateAnywhereCacheRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateAnywhereCacheMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an Anywhere Cache instance. Mutable fields include `ttl` and
     * `admission_policy`.
     * </pre>
     */
    public com.google.longrunning.Operation updateAnywhereCache(
        com.google.storage.control.v2.UpdateAnywhereCacheRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateAnywhereCacheMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Disables an Anywhere Cache instance. A disabled instance is read-only. The
     * disablement could be revoked by calling ResumeAnywhereCache. The cache
     * instance will be deleted automatically if it remains in the disabled state
     * for at least one hour.
     * </pre>
     */
    public com.google.storage.control.v2.AnywhereCache disableAnywhereCache(
        com.google.storage.control.v2.DisableAnywhereCacheRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDisableAnywhereCacheMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses an Anywhere Cache instance.
     * </pre>
     */
    public com.google.storage.control.v2.AnywhereCache pauseAnywhereCache(
        com.google.storage.control.v2.PauseAnywhereCacheRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPauseAnywhereCacheMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resumes a disabled or paused Anywhere Cache instance.
     * </pre>
     */
    public com.google.storage.control.v2.AnywhereCache resumeAnywhereCache(
        com.google.storage.control.v2.ResumeAnywhereCacheRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getResumeAnywhereCacheMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an Anywhere Cache instance.
     * </pre>
     */
    public com.google.storage.control.v2.AnywhereCache getAnywhereCache(
        com.google.storage.control.v2.GetAnywhereCacheRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAnywhereCacheMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Anywhere Cache instances for a given bucket.
     * </pre>
     */
    public com.google.storage.control.v2.ListAnywhereCachesResponse listAnywhereCaches(
        com.google.storage.control.v2.ListAnywhereCachesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAnywhereCachesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the Project scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public com.google.storage.control.v2.IntelligenceConfig getProjectIntelligenceConfig(
        com.google.storage.control.v2.GetProjectIntelligenceConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetProjectIntelligenceConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Project scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public com.google.storage.control.v2.IntelligenceConfig updateProjectIntelligenceConfig(
        com.google.storage.control.v2.UpdateProjectIntelligenceConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateProjectIntelligenceConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the Folder scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public com.google.storage.control.v2.IntelligenceConfig getFolderIntelligenceConfig(
        com.google.storage.control.v2.GetFolderIntelligenceConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetFolderIntelligenceConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Folder scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public com.google.storage.control.v2.IntelligenceConfig updateFolderIntelligenceConfig(
        com.google.storage.control.v2.UpdateFolderIntelligenceConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateFolderIntelligenceConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the Organization scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public com.google.storage.control.v2.IntelligenceConfig getOrganizationIntelligenceConfig(
        com.google.storage.control.v2.GetOrganizationIntelligenceConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetOrganizationIntelligenceConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Organization scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public com.google.storage.control.v2.IntelligenceConfig updateOrganizationIntelligenceConfig(
        com.google.storage.control.v2.UpdateOrganizationIntelligenceConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateOrganizationIntelligenceConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for a specified bucket.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an IAM policy for the specified bucket.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Tests a set of permissions on the given bucket, object, or managed folder
     * to see which, if any, are held by the caller.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket,
     * `projects/_/buckets/{bucket}/objects/{object}` for an object, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service StorageControl.
   *
   * <pre>
   * StorageControl service includes selected control plane operations.
   * </pre>
   */
  public static final class StorageControlBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<StorageControlBlockingStub> {
    private StorageControlBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageControlBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StorageControlBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new folder. This operation is only applicable to a hierarchical
     * namespace enabled bucket.
     * </pre>
     */
    public com.google.storage.control.v2.Folder createFolder(
        com.google.storage.control.v2.CreateFolderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFolderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes an empty folder. This operation is only applicable to a
     * hierarchical namespace enabled bucket.
     * </pre>
     */
    public com.google.protobuf.Empty deleteFolder(
        com.google.storage.control.v2.DeleteFolderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFolderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for the specified folder. This operation is only
     * applicable to a hierarchical namespace enabled bucket.
     * </pre>
     */
    public com.google.storage.control.v2.Folder getFolder(
        com.google.storage.control.v2.GetFolderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFolderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of folders. This operation is only applicable to a
     * hierarchical namespace enabled bucket.
     * </pre>
     */
    public com.google.storage.control.v2.ListFoldersResponse listFolders(
        com.google.storage.control.v2.ListFoldersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFoldersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Renames a source folder to a destination folder. This operation is only
     * applicable to a hierarchical namespace enabled bucket. During a rename, the
     * source and destination folders are locked until the long running operation
     * completes.
     * </pre>
     */
    public com.google.longrunning.Operation renameFolder(
        com.google.storage.control.v2.RenameFolderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRenameFolderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a folder recursively. This operation is only applicable to a
     * hierarchical namespace enabled bucket.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFolderRecursive(
        com.google.storage.control.v2.DeleteFolderRecursiveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFolderRecursiveMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the storage layout configuration for a given bucket.
     * </pre>
     */
    public com.google.storage.control.v2.StorageLayout getStorageLayout(
        com.google.storage.control.v2.GetStorageLayoutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStorageLayoutMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new managed folder.
     * </pre>
     */
    public com.google.storage.control.v2.ManagedFolder createManagedFolder(
        com.google.storage.control.v2.CreateManagedFolderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateManagedFolderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes an empty managed folder.
     * </pre>
     */
    public com.google.protobuf.Empty deleteManagedFolder(
        com.google.storage.control.v2.DeleteManagedFolderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteManagedFolderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for the specified managed folder.
     * </pre>
     */
    public com.google.storage.control.v2.ManagedFolder getManagedFolder(
        com.google.storage.control.v2.GetManagedFolderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetManagedFolderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of managed folders for a given bucket.
     * </pre>
     */
    public com.google.storage.control.v2.ListManagedFoldersResponse listManagedFolders(
        com.google.storage.control.v2.ListManagedFoldersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListManagedFoldersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an Anywhere Cache instance.
     * </pre>
     */
    public com.google.longrunning.Operation createAnywhereCache(
        com.google.storage.control.v2.CreateAnywhereCacheRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAnywhereCacheMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an Anywhere Cache instance. Mutable fields include `ttl` and
     * `admission_policy`.
     * </pre>
     */
    public com.google.longrunning.Operation updateAnywhereCache(
        com.google.storage.control.v2.UpdateAnywhereCacheRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAnywhereCacheMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Disables an Anywhere Cache instance. A disabled instance is read-only. The
     * disablement could be revoked by calling ResumeAnywhereCache. The cache
     * instance will be deleted automatically if it remains in the disabled state
     * for at least one hour.
     * </pre>
     */
    public com.google.storage.control.v2.AnywhereCache disableAnywhereCache(
        com.google.storage.control.v2.DisableAnywhereCacheRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableAnywhereCacheMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses an Anywhere Cache instance.
     * </pre>
     */
    public com.google.storage.control.v2.AnywhereCache pauseAnywhereCache(
        com.google.storage.control.v2.PauseAnywhereCacheRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPauseAnywhereCacheMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resumes a disabled or paused Anywhere Cache instance.
     * </pre>
     */
    public com.google.storage.control.v2.AnywhereCache resumeAnywhereCache(
        com.google.storage.control.v2.ResumeAnywhereCacheRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResumeAnywhereCacheMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an Anywhere Cache instance.
     * </pre>
     */
    public com.google.storage.control.v2.AnywhereCache getAnywhereCache(
        com.google.storage.control.v2.GetAnywhereCacheRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnywhereCacheMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Anywhere Cache instances for a given bucket.
     * </pre>
     */
    public com.google.storage.control.v2.ListAnywhereCachesResponse listAnywhereCaches(
        com.google.storage.control.v2.ListAnywhereCachesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAnywhereCachesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the Project scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public com.google.storage.control.v2.IntelligenceConfig getProjectIntelligenceConfig(
        com.google.storage.control.v2.GetProjectIntelligenceConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProjectIntelligenceConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Project scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public com.google.storage.control.v2.IntelligenceConfig updateProjectIntelligenceConfig(
        com.google.storage.control.v2.UpdateProjectIntelligenceConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateProjectIntelligenceConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the Folder scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public com.google.storage.control.v2.IntelligenceConfig getFolderIntelligenceConfig(
        com.google.storage.control.v2.GetFolderIntelligenceConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFolderIntelligenceConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Folder scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public com.google.storage.control.v2.IntelligenceConfig updateFolderIntelligenceConfig(
        com.google.storage.control.v2.UpdateFolderIntelligenceConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFolderIntelligenceConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the Organization scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public com.google.storage.control.v2.IntelligenceConfig getOrganizationIntelligenceConfig(
        com.google.storage.control.v2.GetOrganizationIntelligenceConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrganizationIntelligenceConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Organization scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public com.google.storage.control.v2.IntelligenceConfig updateOrganizationIntelligenceConfig(
        com.google.storage.control.v2.UpdateOrganizationIntelligenceConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateOrganizationIntelligenceConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for a specified bucket.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an IAM policy for the specified bucket.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Tests a set of permissions on the given bucket, object, or managed folder
     * to see which, if any, are held by the caller.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket,
     * `projects/_/buckets/{bucket}/objects/{object}` for an object, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service StorageControl.
   *
   * <pre>
   * StorageControl service includes selected control plane operations.
   * </pre>
   */
  public static final class StorageControlFutureStub
      extends io.grpc.stub.AbstractFutureStub<StorageControlFutureStub> {
    private StorageControlFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageControlFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StorageControlFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new folder. This operation is only applicable to a hierarchical
     * namespace enabled bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.storage.control.v2.Folder>
        createFolder(com.google.storage.control.v2.CreateFolderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFolderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes an empty folder. This operation is only applicable to a
     * hierarchical namespace enabled bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteFolder(com.google.storage.control.v2.DeleteFolderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFolderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for the specified folder. This operation is only
     * applicable to a hierarchical namespace enabled bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.storage.control.v2.Folder>
        getFolder(com.google.storage.control.v2.GetFolderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFolderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of folders. This operation is only applicable to a
     * hierarchical namespace enabled bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.control.v2.ListFoldersResponse>
        listFolders(com.google.storage.control.v2.ListFoldersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFoldersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Renames a source folder to a destination folder. This operation is only
     * applicable to a hierarchical namespace enabled bucket. During a rename, the
     * source and destination folders are locked until the long running operation
     * completes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        renameFolder(com.google.storage.control.v2.RenameFolderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRenameFolderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a folder recursively. This operation is only applicable to a
     * hierarchical namespace enabled bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteFolderRecursive(com.google.storage.control.v2.DeleteFolderRecursiveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFolderRecursiveMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the storage layout configuration for a given bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.control.v2.StorageLayout>
        getStorageLayout(com.google.storage.control.v2.GetStorageLayoutRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStorageLayoutMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new managed folder.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.control.v2.ManagedFolder>
        createManagedFolder(com.google.storage.control.v2.CreateManagedFolderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateManagedFolderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes an empty managed folder.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteManagedFolder(com.google.storage.control.v2.DeleteManagedFolderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteManagedFolderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for the specified managed folder.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.control.v2.ManagedFolder>
        getManagedFolder(com.google.storage.control.v2.GetManagedFolderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetManagedFolderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of managed folders for a given bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.control.v2.ListManagedFoldersResponse>
        listManagedFolders(com.google.storage.control.v2.ListManagedFoldersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListManagedFoldersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an Anywhere Cache instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createAnywhereCache(com.google.storage.control.v2.CreateAnywhereCacheRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAnywhereCacheMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an Anywhere Cache instance. Mutable fields include `ttl` and
     * `admission_policy`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateAnywhereCache(com.google.storage.control.v2.UpdateAnywhereCacheRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAnywhereCacheMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Disables an Anywhere Cache instance. A disabled instance is read-only. The
     * disablement could be revoked by calling ResumeAnywhereCache. The cache
     * instance will be deleted automatically if it remains in the disabled state
     * for at least one hour.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.control.v2.AnywhereCache>
        disableAnywhereCache(com.google.storage.control.v2.DisableAnywhereCacheRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableAnywhereCacheMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses an Anywhere Cache instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.control.v2.AnywhereCache>
        pauseAnywhereCache(com.google.storage.control.v2.PauseAnywhereCacheRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPauseAnywhereCacheMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Resumes a disabled or paused Anywhere Cache instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.control.v2.AnywhereCache>
        resumeAnywhereCache(com.google.storage.control.v2.ResumeAnywhereCacheRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResumeAnywhereCacheMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an Anywhere Cache instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.control.v2.AnywhereCache>
        getAnywhereCache(com.google.storage.control.v2.GetAnywhereCacheRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnywhereCacheMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Anywhere Cache instances for a given bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.control.v2.ListAnywhereCachesResponse>
        listAnywhereCaches(com.google.storage.control.v2.ListAnywhereCachesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAnywhereCachesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the Project scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.control.v2.IntelligenceConfig>
        getProjectIntelligenceConfig(
            com.google.storage.control.v2.GetProjectIntelligenceConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProjectIntelligenceConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Project scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.control.v2.IntelligenceConfig>
        updateProjectIntelligenceConfig(
            com.google.storage.control.v2.UpdateProjectIntelligenceConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateProjectIntelligenceConfigMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Returns the Folder scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.control.v2.IntelligenceConfig>
        getFolderIntelligenceConfig(
            com.google.storage.control.v2.GetFolderIntelligenceConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFolderIntelligenceConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Folder scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.control.v2.IntelligenceConfig>
        updateFolderIntelligenceConfig(
            com.google.storage.control.v2.UpdateFolderIntelligenceConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFolderIntelligenceConfigMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Returns the Organization scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.control.v2.IntelligenceConfig>
        getOrganizationIntelligenceConfig(
            com.google.storage.control.v2.GetOrganizationIntelligenceConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOrganizationIntelligenceConfigMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Organization scoped singleton IntelligenceConfig resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.control.v2.IntelligenceConfig>
        updateOrganizationIntelligenceConfig(
            com.google.storage.control.v2.UpdateOrganizationIntelligenceConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateOrganizationIntelligenceConfigMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for a specified bucket.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an IAM policy for the specified bucket.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Tests a set of permissions on the given bucket, object, or managed folder
     * to see which, if any, are held by the caller.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket,
     * `projects/_/buckets/{bucket}/objects/{object}` for an object, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_FOLDER = 0;
  private static final int METHODID_DELETE_FOLDER = 1;
  private static final int METHODID_GET_FOLDER = 2;
  private static final int METHODID_LIST_FOLDERS = 3;
  private static final int METHODID_RENAME_FOLDER = 4;
  private static final int METHODID_DELETE_FOLDER_RECURSIVE = 5;
  private static final int METHODID_GET_STORAGE_LAYOUT = 6;
  private static final int METHODID_CREATE_MANAGED_FOLDER = 7;
  private static final int METHODID_DELETE_MANAGED_FOLDER = 8;
  private static final int METHODID_GET_MANAGED_FOLDER = 9;
  private static final int METHODID_LIST_MANAGED_FOLDERS = 10;
  private static final int METHODID_CREATE_ANYWHERE_CACHE = 11;
  private static final int METHODID_UPDATE_ANYWHERE_CACHE = 12;
  private static final int METHODID_DISABLE_ANYWHERE_CACHE = 13;
  private static final int METHODID_PAUSE_ANYWHERE_CACHE = 14;
  private static final int METHODID_RESUME_ANYWHERE_CACHE = 15;
  private static final int METHODID_GET_ANYWHERE_CACHE = 16;
  private static final int METHODID_LIST_ANYWHERE_CACHES = 17;
  private static final int METHODID_GET_PROJECT_INTELLIGENCE_CONFIG = 18;
  private static final int METHODID_UPDATE_PROJECT_INTELLIGENCE_CONFIG = 19;
  private static final int METHODID_GET_FOLDER_INTELLIGENCE_CONFIG = 20;
  private static final int METHODID_UPDATE_FOLDER_INTELLIGENCE_CONFIG = 21;
  private static final int METHODID_GET_ORGANIZATION_INTELLIGENCE_CONFIG = 22;
  private static final int METHODID_UPDATE_ORGANIZATION_INTELLIGENCE_CONFIG = 23;
  private static final int METHODID_GET_IAM_POLICY = 24;
  private static final int METHODID_SET_IAM_POLICY = 25;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 26;

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
        case METHODID_CREATE_FOLDER:
          serviceImpl.createFolder(
              (com.google.storage.control.v2.CreateFolderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.control.v2.Folder>) responseObserver);
          break;
        case METHODID_DELETE_FOLDER:
          serviceImpl.deleteFolder(
              (com.google.storage.control.v2.DeleteFolderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_FOLDER:
          serviceImpl.getFolder(
              (com.google.storage.control.v2.GetFolderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.control.v2.Folder>) responseObserver);
          break;
        case METHODID_LIST_FOLDERS:
          serviceImpl.listFolders(
              (com.google.storage.control.v2.ListFoldersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.control.v2.ListFoldersResponse>)
                  responseObserver);
          break;
        case METHODID_RENAME_FOLDER:
          serviceImpl.renameFolder(
              (com.google.storage.control.v2.RenameFolderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_FOLDER_RECURSIVE:
          serviceImpl.deleteFolderRecursive(
              (com.google.storage.control.v2.DeleteFolderRecursiveRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_STORAGE_LAYOUT:
          serviceImpl.getStorageLayout(
              (com.google.storage.control.v2.GetStorageLayoutRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.control.v2.StorageLayout>)
                  responseObserver);
          break;
        case METHODID_CREATE_MANAGED_FOLDER:
          serviceImpl.createManagedFolder(
              (com.google.storage.control.v2.CreateManagedFolderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.control.v2.ManagedFolder>)
                  responseObserver);
          break;
        case METHODID_DELETE_MANAGED_FOLDER:
          serviceImpl.deleteManagedFolder(
              (com.google.storage.control.v2.DeleteManagedFolderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_MANAGED_FOLDER:
          serviceImpl.getManagedFolder(
              (com.google.storage.control.v2.GetManagedFolderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.control.v2.ManagedFolder>)
                  responseObserver);
          break;
        case METHODID_LIST_MANAGED_FOLDERS:
          serviceImpl.listManagedFolders(
              (com.google.storage.control.v2.ListManagedFoldersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.storage.control.v2.ListManagedFoldersResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_ANYWHERE_CACHE:
          serviceImpl.createAnywhereCache(
              (com.google.storage.control.v2.CreateAnywhereCacheRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ANYWHERE_CACHE:
          serviceImpl.updateAnywhereCache(
              (com.google.storage.control.v2.UpdateAnywhereCacheRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DISABLE_ANYWHERE_CACHE:
          serviceImpl.disableAnywhereCache(
              (com.google.storage.control.v2.DisableAnywhereCacheRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.control.v2.AnywhereCache>)
                  responseObserver);
          break;
        case METHODID_PAUSE_ANYWHERE_CACHE:
          serviceImpl.pauseAnywhereCache(
              (com.google.storage.control.v2.PauseAnywhereCacheRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.control.v2.AnywhereCache>)
                  responseObserver);
          break;
        case METHODID_RESUME_ANYWHERE_CACHE:
          serviceImpl.resumeAnywhereCache(
              (com.google.storage.control.v2.ResumeAnywhereCacheRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.control.v2.AnywhereCache>)
                  responseObserver);
          break;
        case METHODID_GET_ANYWHERE_CACHE:
          serviceImpl.getAnywhereCache(
              (com.google.storage.control.v2.GetAnywhereCacheRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.control.v2.AnywhereCache>)
                  responseObserver);
          break;
        case METHODID_LIST_ANYWHERE_CACHES:
          serviceImpl.listAnywhereCaches(
              (com.google.storage.control.v2.ListAnywhereCachesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.storage.control.v2.ListAnywhereCachesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PROJECT_INTELLIGENCE_CONFIG:
          serviceImpl.getProjectIntelligenceConfig(
              (com.google.storage.control.v2.GetProjectIntelligenceConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.control.v2.IntelligenceConfig>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PROJECT_INTELLIGENCE_CONFIG:
          serviceImpl.updateProjectIntelligenceConfig(
              (com.google.storage.control.v2.UpdateProjectIntelligenceConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.control.v2.IntelligenceConfig>)
                  responseObserver);
          break;
        case METHODID_GET_FOLDER_INTELLIGENCE_CONFIG:
          serviceImpl.getFolderIntelligenceConfig(
              (com.google.storage.control.v2.GetFolderIntelligenceConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.control.v2.IntelligenceConfig>)
                  responseObserver);
          break;
        case METHODID_UPDATE_FOLDER_INTELLIGENCE_CONFIG:
          serviceImpl.updateFolderIntelligenceConfig(
              (com.google.storage.control.v2.UpdateFolderIntelligenceConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.control.v2.IntelligenceConfig>)
                  responseObserver);
          break;
        case METHODID_GET_ORGANIZATION_INTELLIGENCE_CONFIG:
          serviceImpl.getOrganizationIntelligenceConfig(
              (com.google.storage.control.v2.GetOrganizationIntelligenceConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.control.v2.IntelligenceConfig>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ORGANIZATION_INTELLIGENCE_CONFIG:
          serviceImpl.updateOrganizationIntelligenceConfig(
              (com.google.storage.control.v2.UpdateOrganizationIntelligenceConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.control.v2.IntelligenceConfig>)
                  responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy(
              (com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions(
              (com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>)
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
            getCreateFolderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.CreateFolderRequest,
                    com.google.storage.control.v2.Folder>(service, METHODID_CREATE_FOLDER)))
        .addMethod(
            getDeleteFolderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.DeleteFolderRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_FOLDER)))
        .addMethod(
            getGetFolderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.GetFolderRequest,
                    com.google.storage.control.v2.Folder>(service, METHODID_GET_FOLDER)))
        .addMethod(
            getListFoldersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.ListFoldersRequest,
                    com.google.storage.control.v2.ListFoldersResponse>(
                    service, METHODID_LIST_FOLDERS)))
        .addMethod(
            getRenameFolderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.RenameFolderRequest,
                    com.google.longrunning.Operation>(service, METHODID_RENAME_FOLDER)))
        .addMethod(
            getDeleteFolderRecursiveMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.DeleteFolderRecursiveRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_FOLDER_RECURSIVE)))
        .addMethod(
            getGetStorageLayoutMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.GetStorageLayoutRequest,
                    com.google.storage.control.v2.StorageLayout>(
                    service, METHODID_GET_STORAGE_LAYOUT)))
        .addMethod(
            getCreateManagedFolderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.CreateManagedFolderRequest,
                    com.google.storage.control.v2.ManagedFolder>(
                    service, METHODID_CREATE_MANAGED_FOLDER)))
        .addMethod(
            getDeleteManagedFolderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.DeleteManagedFolderRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_MANAGED_FOLDER)))
        .addMethod(
            getGetManagedFolderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.GetManagedFolderRequest,
                    com.google.storage.control.v2.ManagedFolder>(
                    service, METHODID_GET_MANAGED_FOLDER)))
        .addMethod(
            getListManagedFoldersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.ListManagedFoldersRequest,
                    com.google.storage.control.v2.ListManagedFoldersResponse>(
                    service, METHODID_LIST_MANAGED_FOLDERS)))
        .addMethod(
            getCreateAnywhereCacheMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.CreateAnywhereCacheRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ANYWHERE_CACHE)))
        .addMethod(
            getUpdateAnywhereCacheMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.UpdateAnywhereCacheRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_ANYWHERE_CACHE)))
        .addMethod(
            getDisableAnywhereCacheMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.DisableAnywhereCacheRequest,
                    com.google.storage.control.v2.AnywhereCache>(
                    service, METHODID_DISABLE_ANYWHERE_CACHE)))
        .addMethod(
            getPauseAnywhereCacheMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.PauseAnywhereCacheRequest,
                    com.google.storage.control.v2.AnywhereCache>(
                    service, METHODID_PAUSE_ANYWHERE_CACHE)))
        .addMethod(
            getResumeAnywhereCacheMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.ResumeAnywhereCacheRequest,
                    com.google.storage.control.v2.AnywhereCache>(
                    service, METHODID_RESUME_ANYWHERE_CACHE)))
        .addMethod(
            getGetAnywhereCacheMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.GetAnywhereCacheRequest,
                    com.google.storage.control.v2.AnywhereCache>(
                    service, METHODID_GET_ANYWHERE_CACHE)))
        .addMethod(
            getListAnywhereCachesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.ListAnywhereCachesRequest,
                    com.google.storage.control.v2.ListAnywhereCachesResponse>(
                    service, METHODID_LIST_ANYWHERE_CACHES)))
        .addMethod(
            getGetProjectIntelligenceConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.GetProjectIntelligenceConfigRequest,
                    com.google.storage.control.v2.IntelligenceConfig>(
                    service, METHODID_GET_PROJECT_INTELLIGENCE_CONFIG)))
        .addMethod(
            getUpdateProjectIntelligenceConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.UpdateProjectIntelligenceConfigRequest,
                    com.google.storage.control.v2.IntelligenceConfig>(
                    service, METHODID_UPDATE_PROJECT_INTELLIGENCE_CONFIG)))
        .addMethod(
            getGetFolderIntelligenceConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.GetFolderIntelligenceConfigRequest,
                    com.google.storage.control.v2.IntelligenceConfig>(
                    service, METHODID_GET_FOLDER_INTELLIGENCE_CONFIG)))
        .addMethod(
            getUpdateFolderIntelligenceConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.UpdateFolderIntelligenceConfigRequest,
                    com.google.storage.control.v2.IntelligenceConfig>(
                    service, METHODID_UPDATE_FOLDER_INTELLIGENCE_CONFIG)))
        .addMethod(
            getGetOrganizationIntelligenceConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.GetOrganizationIntelligenceConfigRequest,
                    com.google.storage.control.v2.IntelligenceConfig>(
                    service, METHODID_GET_ORGANIZATION_INTELLIGENCE_CONFIG)))
        .addMethod(
            getUpdateOrganizationIntelligenceConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.control.v2.UpdateOrganizationIntelligenceConfigRequest,
                    com.google.storage.control.v2.IntelligenceConfig>(
                    service, METHODID_UPDATE_ORGANIZATION_INTELLIGENCE_CONFIG)))
        .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_GET_IAM_POLICY)))
        .addMethod(
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_SET_IAM_POLICY)))
        .addMethod(
            getTestIamPermissionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v1.TestIamPermissionsRequest,
                    com.google.iam.v1.TestIamPermissionsResponse>(
                    service, METHODID_TEST_IAM_PERMISSIONS)))
        .build();
  }

  private abstract static class StorageControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StorageControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.storage.control.v2.StorageControlProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StorageControl");
    }
  }

  private static final class StorageControlFileDescriptorSupplier
      extends StorageControlBaseDescriptorSupplier {
    StorageControlFileDescriptorSupplier() {}
  }

  private static final class StorageControlMethodDescriptorSupplier
      extends StorageControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    StorageControlMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (StorageControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new StorageControlFileDescriptorSupplier())
                      .addMethod(getCreateFolderMethod())
                      .addMethod(getDeleteFolderMethod())
                      .addMethod(getGetFolderMethod())
                      .addMethod(getListFoldersMethod())
                      .addMethod(getRenameFolderMethod())
                      .addMethod(getDeleteFolderRecursiveMethod())
                      .addMethod(getGetStorageLayoutMethod())
                      .addMethod(getCreateManagedFolderMethod())
                      .addMethod(getDeleteManagedFolderMethod())
                      .addMethod(getGetManagedFolderMethod())
                      .addMethod(getListManagedFoldersMethod())
                      .addMethod(getCreateAnywhereCacheMethod())
                      .addMethod(getUpdateAnywhereCacheMethod())
                      .addMethod(getDisableAnywhereCacheMethod())
                      .addMethod(getPauseAnywhereCacheMethod())
                      .addMethod(getResumeAnywhereCacheMethod())
                      .addMethod(getGetAnywhereCacheMethod())
                      .addMethod(getListAnywhereCachesMethod())
                      .addMethod(getGetProjectIntelligenceConfigMethod())
                      .addMethod(getUpdateProjectIntelligenceConfigMethod())
                      .addMethod(getGetFolderIntelligenceConfigMethod())
                      .addMethod(getUpdateFolderIntelligenceConfigMethod())
                      .addMethod(getGetOrganizationIntelligenceConfigMethod())
                      .addMethod(getUpdateOrganizationIntelligenceConfigMethod())
                      .addMethod(getGetIamPolicyMethod())
                      .addMethod(getSetIamPolicyMethod())
                      .addMethod(getTestIamPermissionsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
