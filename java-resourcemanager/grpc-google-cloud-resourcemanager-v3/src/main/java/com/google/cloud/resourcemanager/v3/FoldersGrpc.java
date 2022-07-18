/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.resourcemanager.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Manages Cloud Platform folder resources.
 * Folders can be used to organize the resources under an
 * organization and to control the policies applied to groups of resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/resourcemanager/v3/folders.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FoldersGrpc {

  private FoldersGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.resourcemanager.v3.Folders";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.GetFolderRequest,
          com.google.cloud.resourcemanager.v3.Folder>
      getGetFolderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFolder",
      requestType = com.google.cloud.resourcemanager.v3.GetFolderRequest.class,
      responseType = com.google.cloud.resourcemanager.v3.Folder.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.GetFolderRequest,
          com.google.cloud.resourcemanager.v3.Folder>
      getGetFolderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.GetFolderRequest,
            com.google.cloud.resourcemanager.v3.Folder>
        getGetFolderMethod;
    if ((getGetFolderMethod = FoldersGrpc.getGetFolderMethod) == null) {
      synchronized (FoldersGrpc.class) {
        if ((getGetFolderMethod = FoldersGrpc.getGetFolderMethod) == null) {
          FoldersGrpc.getGetFolderMethod =
              getGetFolderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.GetFolderRequest,
                          com.google.cloud.resourcemanager.v3.Folder>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFolder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.GetFolderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.Folder.getDefaultInstance()))
                      .setSchemaDescriptor(new FoldersMethodDescriptorSupplier("GetFolder"))
                      .build();
        }
      }
    }
    return getGetFolderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.ListFoldersRequest,
          com.google.cloud.resourcemanager.v3.ListFoldersResponse>
      getListFoldersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFolders",
      requestType = com.google.cloud.resourcemanager.v3.ListFoldersRequest.class,
      responseType = com.google.cloud.resourcemanager.v3.ListFoldersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.ListFoldersRequest,
          com.google.cloud.resourcemanager.v3.ListFoldersResponse>
      getListFoldersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.ListFoldersRequest,
            com.google.cloud.resourcemanager.v3.ListFoldersResponse>
        getListFoldersMethod;
    if ((getListFoldersMethod = FoldersGrpc.getListFoldersMethod) == null) {
      synchronized (FoldersGrpc.class) {
        if ((getListFoldersMethod = FoldersGrpc.getListFoldersMethod) == null) {
          FoldersGrpc.getListFoldersMethod =
              getListFoldersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.ListFoldersRequest,
                          com.google.cloud.resourcemanager.v3.ListFoldersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFolders"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.ListFoldersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.ListFoldersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new FoldersMethodDescriptorSupplier("ListFolders"))
                      .build();
        }
      }
    }
    return getListFoldersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.SearchFoldersRequest,
          com.google.cloud.resourcemanager.v3.SearchFoldersResponse>
      getSearchFoldersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchFolders",
      requestType = com.google.cloud.resourcemanager.v3.SearchFoldersRequest.class,
      responseType = com.google.cloud.resourcemanager.v3.SearchFoldersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.SearchFoldersRequest,
          com.google.cloud.resourcemanager.v3.SearchFoldersResponse>
      getSearchFoldersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.SearchFoldersRequest,
            com.google.cloud.resourcemanager.v3.SearchFoldersResponse>
        getSearchFoldersMethod;
    if ((getSearchFoldersMethod = FoldersGrpc.getSearchFoldersMethod) == null) {
      synchronized (FoldersGrpc.class) {
        if ((getSearchFoldersMethod = FoldersGrpc.getSearchFoldersMethod) == null) {
          FoldersGrpc.getSearchFoldersMethod =
              getSearchFoldersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.SearchFoldersRequest,
                          com.google.cloud.resourcemanager.v3.SearchFoldersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchFolders"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.SearchFoldersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.SearchFoldersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new FoldersMethodDescriptorSupplier("SearchFolders"))
                      .build();
        }
      }
    }
    return getSearchFoldersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.CreateFolderRequest, com.google.longrunning.Operation>
      getCreateFolderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFolder",
      requestType = com.google.cloud.resourcemanager.v3.CreateFolderRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.CreateFolderRequest, com.google.longrunning.Operation>
      getCreateFolderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.CreateFolderRequest,
            com.google.longrunning.Operation>
        getCreateFolderMethod;
    if ((getCreateFolderMethod = FoldersGrpc.getCreateFolderMethod) == null) {
      synchronized (FoldersGrpc.class) {
        if ((getCreateFolderMethod = FoldersGrpc.getCreateFolderMethod) == null) {
          FoldersGrpc.getCreateFolderMethod =
              getCreateFolderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.CreateFolderRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFolder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.CreateFolderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new FoldersMethodDescriptorSupplier("CreateFolder"))
                      .build();
        }
      }
    }
    return getCreateFolderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.UpdateFolderRequest, com.google.longrunning.Operation>
      getUpdateFolderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFolder",
      requestType = com.google.cloud.resourcemanager.v3.UpdateFolderRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.UpdateFolderRequest, com.google.longrunning.Operation>
      getUpdateFolderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.UpdateFolderRequest,
            com.google.longrunning.Operation>
        getUpdateFolderMethod;
    if ((getUpdateFolderMethod = FoldersGrpc.getUpdateFolderMethod) == null) {
      synchronized (FoldersGrpc.class) {
        if ((getUpdateFolderMethod = FoldersGrpc.getUpdateFolderMethod) == null) {
          FoldersGrpc.getUpdateFolderMethod =
              getUpdateFolderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.UpdateFolderRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFolder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.UpdateFolderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new FoldersMethodDescriptorSupplier("UpdateFolder"))
                      .build();
        }
      }
    }
    return getUpdateFolderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.MoveFolderRequest, com.google.longrunning.Operation>
      getMoveFolderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MoveFolder",
      requestType = com.google.cloud.resourcemanager.v3.MoveFolderRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.MoveFolderRequest, com.google.longrunning.Operation>
      getMoveFolderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.MoveFolderRequest, com.google.longrunning.Operation>
        getMoveFolderMethod;
    if ((getMoveFolderMethod = FoldersGrpc.getMoveFolderMethod) == null) {
      synchronized (FoldersGrpc.class) {
        if ((getMoveFolderMethod = FoldersGrpc.getMoveFolderMethod) == null) {
          FoldersGrpc.getMoveFolderMethod =
              getMoveFolderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.MoveFolderRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MoveFolder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.MoveFolderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new FoldersMethodDescriptorSupplier("MoveFolder"))
                      .build();
        }
      }
    }
    return getMoveFolderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.DeleteFolderRequest, com.google.longrunning.Operation>
      getDeleteFolderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFolder",
      requestType = com.google.cloud.resourcemanager.v3.DeleteFolderRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.DeleteFolderRequest, com.google.longrunning.Operation>
      getDeleteFolderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.DeleteFolderRequest,
            com.google.longrunning.Operation>
        getDeleteFolderMethod;
    if ((getDeleteFolderMethod = FoldersGrpc.getDeleteFolderMethod) == null) {
      synchronized (FoldersGrpc.class) {
        if ((getDeleteFolderMethod = FoldersGrpc.getDeleteFolderMethod) == null) {
          FoldersGrpc.getDeleteFolderMethod =
              getDeleteFolderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.DeleteFolderRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFolder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.DeleteFolderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new FoldersMethodDescriptorSupplier("DeleteFolder"))
                      .build();
        }
      }
    }
    return getDeleteFolderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.UndeleteFolderRequest,
          com.google.longrunning.Operation>
      getUndeleteFolderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeleteFolder",
      requestType = com.google.cloud.resourcemanager.v3.UndeleteFolderRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.UndeleteFolderRequest,
          com.google.longrunning.Operation>
      getUndeleteFolderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.UndeleteFolderRequest,
            com.google.longrunning.Operation>
        getUndeleteFolderMethod;
    if ((getUndeleteFolderMethod = FoldersGrpc.getUndeleteFolderMethod) == null) {
      synchronized (FoldersGrpc.class) {
        if ((getUndeleteFolderMethod = FoldersGrpc.getUndeleteFolderMethod) == null) {
          FoldersGrpc.getUndeleteFolderMethod =
              getUndeleteFolderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.UndeleteFolderRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndeleteFolder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.UndeleteFolderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new FoldersMethodDescriptorSupplier("UndeleteFolder"))
                      .build();
        }
      }
    }
    return getUndeleteFolderMethod;
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
    if ((getGetIamPolicyMethod = FoldersGrpc.getGetIamPolicyMethod) == null) {
      synchronized (FoldersGrpc.class) {
        if ((getGetIamPolicyMethod = FoldersGrpc.getGetIamPolicyMethod) == null) {
          FoldersGrpc.getGetIamPolicyMethod =
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
                      .setSchemaDescriptor(new FoldersMethodDescriptorSupplier("GetIamPolicy"))
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
    if ((getSetIamPolicyMethod = FoldersGrpc.getSetIamPolicyMethod) == null) {
      synchronized (FoldersGrpc.class) {
        if ((getSetIamPolicyMethod = FoldersGrpc.getSetIamPolicyMethod) == null) {
          FoldersGrpc.getSetIamPolicyMethod =
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
                      .setSchemaDescriptor(new FoldersMethodDescriptorSupplier("SetIamPolicy"))
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
    if ((getTestIamPermissionsMethod = FoldersGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (FoldersGrpc.class) {
        if ((getTestIamPermissionsMethod = FoldersGrpc.getTestIamPermissionsMethod) == null) {
          FoldersGrpc.getTestIamPermissionsMethod =
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
                          new FoldersMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static FoldersStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FoldersStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FoldersStub>() {
          @java.lang.Override
          public FoldersStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FoldersStub(channel, callOptions);
          }
        };
    return FoldersStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FoldersBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FoldersBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FoldersBlockingStub>() {
          @java.lang.Override
          public FoldersBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FoldersBlockingStub(channel, callOptions);
          }
        };
    return FoldersBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static FoldersFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FoldersFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FoldersFutureStub>() {
          @java.lang.Override
          public FoldersFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FoldersFutureStub(channel, callOptions);
          }
        };
    return FoldersFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manages Cloud Platform folder resources.
   * Folders can be used to organize the resources under an
   * organization and to control the policies applied to groups of resources.
   * </pre>
   */
  public abstract static class FoldersImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Retrieves a folder identified by the supplied resource name.
     * Valid folder resource names have the format `folders/{folder_id}`
     * (for example, `folders/1234`).
     * The caller must have `resourcemanager.folders.get` permission on the
     * identified folder.
     * </pre>
     */
    public void getFolder(
        com.google.cloud.resourcemanager.v3.GetFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.Folder> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFolderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the folders that are direct descendants of supplied parent resource.
     * `list()` provides a strongly consistent view of the folders underneath
     * the specified parent resource.
     * `list()` returns folders sorted based upon the (ascending) lexical ordering
     * of their display_name.
     * The caller must have `resourcemanager.folders.list` permission on the
     * identified parent.
     * </pre>
     */
    public void listFolders(
        com.google.cloud.resourcemanager.v3.ListFoldersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.ListFoldersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFoldersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Search for folders that match specific filter criteria.
     * `search()` provides an eventually consistent view of the folders a user has
     * access to which meet the specified filter criteria.
     * This will only return folders on which the caller has the
     * permission `resourcemanager.folders.get`.
     * </pre>
     */
    public void searchFolders(
        com.google.cloud.resourcemanager.v3.SearchFoldersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.SearchFoldersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchFoldersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a folder in the resource hierarchy.
     * Returns an `Operation` which can be used to track the progress of the
     * folder creation workflow.
     * Upon success, the `Operation.response` field will be populated with the
     * created Folder.
     * In order to succeed, the addition of this new folder must not violate
     * the folder naming, height, or fanout constraints.
     * + The folder's `display_name` must be distinct from all other folders that
     * share its parent.
     * + The addition of the folder must not cause the active folder hierarchy
     * to exceed a height of 10. Note, the full active + deleted folder hierarchy
     * is allowed to reach a height of 20; this provides additional headroom when
     * moving folders that contain deleted folders.
     * + The addition of the folder must not cause the total number of folders
     * under its parent to exceed 300.
     * If the operation fails due to a folder constraint violation, some errors
     * may be returned by the `CreateFolder` request, with status code
     * `FAILED_PRECONDITION` and an error description. Other folder constraint
     * violations will be communicated in the `Operation`, with the specific
     * `PreconditionFailure` returned in the details list in the `Operation.error`
     * field.
     * The caller must have `resourcemanager.folders.create` permission on the
     * identified parent.
     * </pre>
     */
    public void createFolder(
        com.google.cloud.resourcemanager.v3.CreateFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateFolderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a folder, changing its `display_name`.
     * Changes to the folder `display_name` will be rejected if they violate
     * either the `display_name` formatting rules or the naming constraints
     * described in the [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder] documentation.
     * The folder's `display_name` must start and end with a letter or digit,
     * may contain letters, digits, spaces, hyphens and underscores and can be
     * between 3 and 30 characters. This is captured by the regular expression:
     * `[&#92;p{L}&#92;p{N}][&#92;p{L}&#92;p{N}_- ]{1,28}[&#92;p{L}&#92;p{N}]`.
     * The caller must have `resourcemanager.folders.update` permission on the
     * identified folder.
     * If the update fails due to the unique name constraint then a
     * `PreconditionFailure` explaining this violation will be returned
     * in the Status.details field.
     * </pre>
     */
    public void updateFolder(
        com.google.cloud.resourcemanager.v3.UpdateFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFolderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Moves a folder under a new resource parent.
     * Returns an `Operation` which can be used to track the progress of the
     * folder move workflow.
     * Upon success, the `Operation.response` field will be populated with the
     * moved folder.
     * Upon failure, a `FolderOperationError` categorizing the failure cause will
     * be returned - if the failure occurs synchronously then the
     * `FolderOperationError` will be returned in the `Status.details` field.
     * If it occurs asynchronously, then the FolderOperation will be returned
     * in the `Operation.error` field.
     * In addition, the `Operation.metadata` field will be populated with a
     * `FolderOperation` message as an aid to stateless clients.
     * Folder moves will be rejected if they violate either the naming, height,
     * or fanout constraints described in the
     * [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder] documentation.
     * The caller must have `resourcemanager.folders.move` permission on the
     * folder's current and proposed new parent.
     * </pre>
     */
    public void moveFolder(
        com.google.cloud.resourcemanager.v3.MoveFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMoveFolderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Requests deletion of a folder. The folder is moved into the
     * [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Folder.State.DELETE_REQUESTED] state
     * immediately, and is deleted approximately 30 days later. This method may
     * only be called on an empty folder, where a folder is empty if it doesn't
     * contain any folders or projects in the [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state.
     * If called on a folder in [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Folder.State.DELETE_REQUESTED]
     * state the operation will result in a no-op success.
     * The caller must have `resourcemanager.folders.delete` permission on the
     * identified folder.
     * </pre>
     */
    public void deleteFolder(
        com.google.cloud.resourcemanager.v3.DeleteFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteFolderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels the deletion request for a folder. This method may be called on a
     * folder in any state. If the folder is in the [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE]
     * state the result will be a no-op success. In order to succeed, the folder's
     * parent must be in the [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state. In addition,
     * reintroducing the folder into the tree must not violate folder naming,
     * height, and fanout constraints described in the
     * [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder] documentation.
     * The caller must have `resourcemanager.folders.undelete` permission on the
     * identified folder.
     * </pre>
     */
    public void undeleteFolder(
        com.google.cloud.resourcemanager.v3.UndeleteFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeleteFolderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a folder. The returned policy may be
     * empty if no such policy or resource exists. The `resource` field should
     * be the folder's resource name, for example: "folders/1234".
     * The caller must have `resourcemanager.folders.getIamPolicy` permission
     * on the identified folder.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on a folder, replacing any existing policy.
     * The `resource` field should be the folder's resource name, for example:
     * "folders/1234".
     * The caller must have `resourcemanager.folders.setIamPolicy` permission
     * on the identified folder.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified folder.
     * The `resource` field should be the folder's resource name,
     * for example: "folders/1234".
     * There are no permissions required for making this API call.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTestIamPermissionsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetFolderMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.GetFolderRequest,
                      com.google.cloud.resourcemanager.v3.Folder>(this, METHODID_GET_FOLDER)))
          .addMethod(
              getListFoldersMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.ListFoldersRequest,
                      com.google.cloud.resourcemanager.v3.ListFoldersResponse>(
                      this, METHODID_LIST_FOLDERS)))
          .addMethod(
              getSearchFoldersMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.SearchFoldersRequest,
                      com.google.cloud.resourcemanager.v3.SearchFoldersResponse>(
                      this, METHODID_SEARCH_FOLDERS)))
          .addMethod(
              getCreateFolderMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.CreateFolderRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_FOLDER)))
          .addMethod(
              getUpdateFolderMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.UpdateFolderRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_FOLDER)))
          .addMethod(
              getMoveFolderMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.MoveFolderRequest,
                      com.google.longrunning.Operation>(this, METHODID_MOVE_FOLDER)))
          .addMethod(
              getDeleteFolderMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.DeleteFolderRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_FOLDER)))
          .addMethod(
              getUndeleteFolderMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.UndeleteFolderRequest,
                      com.google.longrunning.Operation>(this, METHODID_UNDELETE_FOLDER)))
          .addMethod(
              getGetIamPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_GET_IAM_POLICY)))
          .addMethod(
              getSetIamPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_SET_IAM_POLICY)))
          .addMethod(
              getTestIamPermissionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.TestIamPermissionsRequest,
                      com.google.iam.v1.TestIamPermissionsResponse>(
                      this, METHODID_TEST_IAM_PERMISSIONS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Manages Cloud Platform folder resources.
   * Folders can be used to organize the resources under an
   * organization and to control the policies applied to groups of resources.
   * </pre>
   */
  public static final class FoldersStub extends io.grpc.stub.AbstractAsyncStub<FoldersStub> {
    private FoldersStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FoldersStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FoldersStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a folder identified by the supplied resource name.
     * Valid folder resource names have the format `folders/{folder_id}`
     * (for example, `folders/1234`).
     * The caller must have `resourcemanager.folders.get` permission on the
     * identified folder.
     * </pre>
     */
    public void getFolder(
        com.google.cloud.resourcemanager.v3.GetFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.Folder> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFolderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the folders that are direct descendants of supplied parent resource.
     * `list()` provides a strongly consistent view of the folders underneath
     * the specified parent resource.
     * `list()` returns folders sorted based upon the (ascending) lexical ordering
     * of their display_name.
     * The caller must have `resourcemanager.folders.list` permission on the
     * identified parent.
     * </pre>
     */
    public void listFolders(
        com.google.cloud.resourcemanager.v3.ListFoldersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.ListFoldersResponse>
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
     * Search for folders that match specific filter criteria.
     * `search()` provides an eventually consistent view of the folders a user has
     * access to which meet the specified filter criteria.
     * This will only return folders on which the caller has the
     * permission `resourcemanager.folders.get`.
     * </pre>
     */
    public void searchFolders(
        com.google.cloud.resourcemanager.v3.SearchFoldersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.SearchFoldersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchFoldersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a folder in the resource hierarchy.
     * Returns an `Operation` which can be used to track the progress of the
     * folder creation workflow.
     * Upon success, the `Operation.response` field will be populated with the
     * created Folder.
     * In order to succeed, the addition of this new folder must not violate
     * the folder naming, height, or fanout constraints.
     * + The folder's `display_name` must be distinct from all other folders that
     * share its parent.
     * + The addition of the folder must not cause the active folder hierarchy
     * to exceed a height of 10. Note, the full active + deleted folder hierarchy
     * is allowed to reach a height of 20; this provides additional headroom when
     * moving folders that contain deleted folders.
     * + The addition of the folder must not cause the total number of folders
     * under its parent to exceed 300.
     * If the operation fails due to a folder constraint violation, some errors
     * may be returned by the `CreateFolder` request, with status code
     * `FAILED_PRECONDITION` and an error description. Other folder constraint
     * violations will be communicated in the `Operation`, with the specific
     * `PreconditionFailure` returned in the details list in the `Operation.error`
     * field.
     * The caller must have `resourcemanager.folders.create` permission on the
     * identified parent.
     * </pre>
     */
    public void createFolder(
        com.google.cloud.resourcemanager.v3.CreateFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFolderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a folder, changing its `display_name`.
     * Changes to the folder `display_name` will be rejected if they violate
     * either the `display_name` formatting rules or the naming constraints
     * described in the [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder] documentation.
     * The folder's `display_name` must start and end with a letter or digit,
     * may contain letters, digits, spaces, hyphens and underscores and can be
     * between 3 and 30 characters. This is captured by the regular expression:
     * `[&#92;p{L}&#92;p{N}][&#92;p{L}&#92;p{N}_- ]{1,28}[&#92;p{L}&#92;p{N}]`.
     * The caller must have `resourcemanager.folders.update` permission on the
     * identified folder.
     * If the update fails due to the unique name constraint then a
     * `PreconditionFailure` explaining this violation will be returned
     * in the Status.details field.
     * </pre>
     */
    public void updateFolder(
        com.google.cloud.resourcemanager.v3.UpdateFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFolderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Moves a folder under a new resource parent.
     * Returns an `Operation` which can be used to track the progress of the
     * folder move workflow.
     * Upon success, the `Operation.response` field will be populated with the
     * moved folder.
     * Upon failure, a `FolderOperationError` categorizing the failure cause will
     * be returned - if the failure occurs synchronously then the
     * `FolderOperationError` will be returned in the `Status.details` field.
     * If it occurs asynchronously, then the FolderOperation will be returned
     * in the `Operation.error` field.
     * In addition, the `Operation.metadata` field will be populated with a
     * `FolderOperation` message as an aid to stateless clients.
     * Folder moves will be rejected if they violate either the naming, height,
     * or fanout constraints described in the
     * [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder] documentation.
     * The caller must have `resourcemanager.folders.move` permission on the
     * folder's current and proposed new parent.
     * </pre>
     */
    public void moveFolder(
        com.google.cloud.resourcemanager.v3.MoveFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMoveFolderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Requests deletion of a folder. The folder is moved into the
     * [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Folder.State.DELETE_REQUESTED] state
     * immediately, and is deleted approximately 30 days later. This method may
     * only be called on an empty folder, where a folder is empty if it doesn't
     * contain any folders or projects in the [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state.
     * If called on a folder in [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Folder.State.DELETE_REQUESTED]
     * state the operation will result in a no-op success.
     * The caller must have `resourcemanager.folders.delete` permission on the
     * identified folder.
     * </pre>
     */
    public void deleteFolder(
        com.google.cloud.resourcemanager.v3.DeleteFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFolderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels the deletion request for a folder. This method may be called on a
     * folder in any state. If the folder is in the [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE]
     * state the result will be a no-op success. In order to succeed, the folder's
     * parent must be in the [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state. In addition,
     * reintroducing the folder into the tree must not violate folder naming,
     * height, and fanout constraints described in the
     * [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder] documentation.
     * The caller must have `resourcemanager.folders.undelete` permission on the
     * identified folder.
     * </pre>
     */
    public void undeleteFolder(
        com.google.cloud.resourcemanager.v3.UndeleteFolderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeleteFolderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a folder. The returned policy may be
     * empty if no such policy or resource exists. The `resource` field should
     * be the folder's resource name, for example: "folders/1234".
     * The caller must have `resourcemanager.folders.getIamPolicy` permission
     * on the identified folder.
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
     * Sets the access control policy on a folder, replacing any existing policy.
     * The `resource` field should be the folder's resource name, for example:
     * "folders/1234".
     * The caller must have `resourcemanager.folders.setIamPolicy` permission
     * on the identified folder.
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
     * Returns permissions that a caller has on the specified folder.
     * The `resource` field should be the folder's resource name,
     * for example: "folders/1234".
     * There are no permissions required for making this API call.
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
   *
   *
   * <pre>
   * Manages Cloud Platform folder resources.
   * Folders can be used to organize the resources under an
   * organization and to control the policies applied to groups of resources.
   * </pre>
   */
  public static final class FoldersBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FoldersBlockingStub> {
    private FoldersBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FoldersBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FoldersBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a folder identified by the supplied resource name.
     * Valid folder resource names have the format `folders/{folder_id}`
     * (for example, `folders/1234`).
     * The caller must have `resourcemanager.folders.get` permission on the
     * identified folder.
     * </pre>
     */
    public com.google.cloud.resourcemanager.v3.Folder getFolder(
        com.google.cloud.resourcemanager.v3.GetFolderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFolderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the folders that are direct descendants of supplied parent resource.
     * `list()` provides a strongly consistent view of the folders underneath
     * the specified parent resource.
     * `list()` returns folders sorted based upon the (ascending) lexical ordering
     * of their display_name.
     * The caller must have `resourcemanager.folders.list` permission on the
     * identified parent.
     * </pre>
     */
    public com.google.cloud.resourcemanager.v3.ListFoldersResponse listFolders(
        com.google.cloud.resourcemanager.v3.ListFoldersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFoldersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Search for folders that match specific filter criteria.
     * `search()` provides an eventually consistent view of the folders a user has
     * access to which meet the specified filter criteria.
     * This will only return folders on which the caller has the
     * permission `resourcemanager.folders.get`.
     * </pre>
     */
    public com.google.cloud.resourcemanager.v3.SearchFoldersResponse searchFolders(
        com.google.cloud.resourcemanager.v3.SearchFoldersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchFoldersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a folder in the resource hierarchy.
     * Returns an `Operation` which can be used to track the progress of the
     * folder creation workflow.
     * Upon success, the `Operation.response` field will be populated with the
     * created Folder.
     * In order to succeed, the addition of this new folder must not violate
     * the folder naming, height, or fanout constraints.
     * + The folder's `display_name` must be distinct from all other folders that
     * share its parent.
     * + The addition of the folder must not cause the active folder hierarchy
     * to exceed a height of 10. Note, the full active + deleted folder hierarchy
     * is allowed to reach a height of 20; this provides additional headroom when
     * moving folders that contain deleted folders.
     * + The addition of the folder must not cause the total number of folders
     * under its parent to exceed 300.
     * If the operation fails due to a folder constraint violation, some errors
     * may be returned by the `CreateFolder` request, with status code
     * `FAILED_PRECONDITION` and an error description. Other folder constraint
     * violations will be communicated in the `Operation`, with the specific
     * `PreconditionFailure` returned in the details list in the `Operation.error`
     * field.
     * The caller must have `resourcemanager.folders.create` permission on the
     * identified parent.
     * </pre>
     */
    public com.google.longrunning.Operation createFolder(
        com.google.cloud.resourcemanager.v3.CreateFolderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFolderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a folder, changing its `display_name`.
     * Changes to the folder `display_name` will be rejected if they violate
     * either the `display_name` formatting rules or the naming constraints
     * described in the [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder] documentation.
     * The folder's `display_name` must start and end with a letter or digit,
     * may contain letters, digits, spaces, hyphens and underscores and can be
     * between 3 and 30 characters. This is captured by the regular expression:
     * `[&#92;p{L}&#92;p{N}][&#92;p{L}&#92;p{N}_- ]{1,28}[&#92;p{L}&#92;p{N}]`.
     * The caller must have `resourcemanager.folders.update` permission on the
     * identified folder.
     * If the update fails due to the unique name constraint then a
     * `PreconditionFailure` explaining this violation will be returned
     * in the Status.details field.
     * </pre>
     */
    public com.google.longrunning.Operation updateFolder(
        com.google.cloud.resourcemanager.v3.UpdateFolderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFolderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Moves a folder under a new resource parent.
     * Returns an `Operation` which can be used to track the progress of the
     * folder move workflow.
     * Upon success, the `Operation.response` field will be populated with the
     * moved folder.
     * Upon failure, a `FolderOperationError` categorizing the failure cause will
     * be returned - if the failure occurs synchronously then the
     * `FolderOperationError` will be returned in the `Status.details` field.
     * If it occurs asynchronously, then the FolderOperation will be returned
     * in the `Operation.error` field.
     * In addition, the `Operation.metadata` field will be populated with a
     * `FolderOperation` message as an aid to stateless clients.
     * Folder moves will be rejected if they violate either the naming, height,
     * or fanout constraints described in the
     * [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder] documentation.
     * The caller must have `resourcemanager.folders.move` permission on the
     * folder's current and proposed new parent.
     * </pre>
     */
    public com.google.longrunning.Operation moveFolder(
        com.google.cloud.resourcemanager.v3.MoveFolderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMoveFolderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Requests deletion of a folder. The folder is moved into the
     * [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Folder.State.DELETE_REQUESTED] state
     * immediately, and is deleted approximately 30 days later. This method may
     * only be called on an empty folder, where a folder is empty if it doesn't
     * contain any folders or projects in the [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state.
     * If called on a folder in [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Folder.State.DELETE_REQUESTED]
     * state the operation will result in a no-op success.
     * The caller must have `resourcemanager.folders.delete` permission on the
     * identified folder.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFolder(
        com.google.cloud.resourcemanager.v3.DeleteFolderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFolderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels the deletion request for a folder. This method may be called on a
     * folder in any state. If the folder is in the [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE]
     * state the result will be a no-op success. In order to succeed, the folder's
     * parent must be in the [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state. In addition,
     * reintroducing the folder into the tree must not violate folder naming,
     * height, and fanout constraints described in the
     * [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder] documentation.
     * The caller must have `resourcemanager.folders.undelete` permission on the
     * identified folder.
     * </pre>
     */
    public com.google.longrunning.Operation undeleteFolder(
        com.google.cloud.resourcemanager.v3.UndeleteFolderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeleteFolderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a folder. The returned policy may be
     * empty if no such policy or resource exists. The `resource` field should
     * be the folder's resource name, for example: "folders/1234".
     * The caller must have `resourcemanager.folders.getIamPolicy` permission
     * on the identified folder.
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
     * Sets the access control policy on a folder, replacing any existing policy.
     * The `resource` field should be the folder's resource name, for example:
     * "folders/1234".
     * The caller must have `resourcemanager.folders.setIamPolicy` permission
     * on the identified folder.
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
     * Returns permissions that a caller has on the specified folder.
     * The `resource` field should be the folder's resource name,
     * for example: "folders/1234".
     * There are no permissions required for making this API call.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages Cloud Platform folder resources.
   * Folders can be used to organize the resources under an
   * organization and to control the policies applied to groups of resources.
   * </pre>
   */
  public static final class FoldersFutureStub
      extends io.grpc.stub.AbstractFutureStub<FoldersFutureStub> {
    private FoldersFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FoldersFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FoldersFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a folder identified by the supplied resource name.
     * Valid folder resource names have the format `folders/{folder_id}`
     * (for example, `folders/1234`).
     * The caller must have `resourcemanager.folders.get` permission on the
     * identified folder.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.resourcemanager.v3.Folder>
        getFolder(com.google.cloud.resourcemanager.v3.GetFolderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFolderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the folders that are direct descendants of supplied parent resource.
     * `list()` provides a strongly consistent view of the folders underneath
     * the specified parent resource.
     * `list()` returns folders sorted based upon the (ascending) lexical ordering
     * of their display_name.
     * The caller must have `resourcemanager.folders.list` permission on the
     * identified parent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.resourcemanager.v3.ListFoldersResponse>
        listFolders(com.google.cloud.resourcemanager.v3.ListFoldersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFoldersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Search for folders that match specific filter criteria.
     * `search()` provides an eventually consistent view of the folders a user has
     * access to which meet the specified filter criteria.
     * This will only return folders on which the caller has the
     * permission `resourcemanager.folders.get`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.resourcemanager.v3.SearchFoldersResponse>
        searchFolders(com.google.cloud.resourcemanager.v3.SearchFoldersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchFoldersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a folder in the resource hierarchy.
     * Returns an `Operation` which can be used to track the progress of the
     * folder creation workflow.
     * Upon success, the `Operation.response` field will be populated with the
     * created Folder.
     * In order to succeed, the addition of this new folder must not violate
     * the folder naming, height, or fanout constraints.
     * + The folder's `display_name` must be distinct from all other folders that
     * share its parent.
     * + The addition of the folder must not cause the active folder hierarchy
     * to exceed a height of 10. Note, the full active + deleted folder hierarchy
     * is allowed to reach a height of 20; this provides additional headroom when
     * moving folders that contain deleted folders.
     * + The addition of the folder must not cause the total number of folders
     * under its parent to exceed 300.
     * If the operation fails due to a folder constraint violation, some errors
     * may be returned by the `CreateFolder` request, with status code
     * `FAILED_PRECONDITION` and an error description. Other folder constraint
     * violations will be communicated in the `Operation`, with the specific
     * `PreconditionFailure` returned in the details list in the `Operation.error`
     * field.
     * The caller must have `resourcemanager.folders.create` permission on the
     * identified parent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createFolder(com.google.cloud.resourcemanager.v3.CreateFolderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFolderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a folder, changing its `display_name`.
     * Changes to the folder `display_name` will be rejected if they violate
     * either the `display_name` formatting rules or the naming constraints
     * described in the [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder] documentation.
     * The folder's `display_name` must start and end with a letter or digit,
     * may contain letters, digits, spaces, hyphens and underscores and can be
     * between 3 and 30 characters. This is captured by the regular expression:
     * `[&#92;p{L}&#92;p{N}][&#92;p{L}&#92;p{N}_- ]{1,28}[&#92;p{L}&#92;p{N}]`.
     * The caller must have `resourcemanager.folders.update` permission on the
     * identified folder.
     * If the update fails due to the unique name constraint then a
     * `PreconditionFailure` explaining this violation will be returned
     * in the Status.details field.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateFolder(com.google.cloud.resourcemanager.v3.UpdateFolderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFolderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Moves a folder under a new resource parent.
     * Returns an `Operation` which can be used to track the progress of the
     * folder move workflow.
     * Upon success, the `Operation.response` field will be populated with the
     * moved folder.
     * Upon failure, a `FolderOperationError` categorizing the failure cause will
     * be returned - if the failure occurs synchronously then the
     * `FolderOperationError` will be returned in the `Status.details` field.
     * If it occurs asynchronously, then the FolderOperation will be returned
     * in the `Operation.error` field.
     * In addition, the `Operation.metadata` field will be populated with a
     * `FolderOperation` message as an aid to stateless clients.
     * Folder moves will be rejected if they violate either the naming, height,
     * or fanout constraints described in the
     * [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder] documentation.
     * The caller must have `resourcemanager.folders.move` permission on the
     * folder's current and proposed new parent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        moveFolder(com.google.cloud.resourcemanager.v3.MoveFolderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMoveFolderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Requests deletion of a folder. The folder is moved into the
     * [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Folder.State.DELETE_REQUESTED] state
     * immediately, and is deleted approximately 30 days later. This method may
     * only be called on an empty folder, where a folder is empty if it doesn't
     * contain any folders or projects in the [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state.
     * If called on a folder in [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Folder.State.DELETE_REQUESTED]
     * state the operation will result in a no-op success.
     * The caller must have `resourcemanager.folders.delete` permission on the
     * identified folder.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteFolder(com.google.cloud.resourcemanager.v3.DeleteFolderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFolderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels the deletion request for a folder. This method may be called on a
     * folder in any state. If the folder is in the [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE]
     * state the result will be a no-op success. In order to succeed, the folder's
     * parent must be in the [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state. In addition,
     * reintroducing the folder into the tree must not violate folder naming,
     * height, and fanout constraints described in the
     * [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder] documentation.
     * The caller must have `resourcemanager.folders.undelete` permission on the
     * identified folder.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        undeleteFolder(com.google.cloud.resourcemanager.v3.UndeleteFolderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeleteFolderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a folder. The returned policy may be
     * empty if no such policy or resource exists. The `resource` field should
     * be the folder's resource name, for example: "folders/1234".
     * The caller must have `resourcemanager.folders.getIamPolicy` permission
     * on the identified folder.
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
     * Sets the access control policy on a folder, replacing any existing policy.
     * The `resource` field should be the folder's resource name, for example:
     * "folders/1234".
     * The caller must have `resourcemanager.folders.setIamPolicy` permission
     * on the identified folder.
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
     * Returns permissions that a caller has on the specified folder.
     * The `resource` field should be the folder's resource name,
     * for example: "folders/1234".
     * There are no permissions required for making this API call.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FOLDER = 0;
  private static final int METHODID_LIST_FOLDERS = 1;
  private static final int METHODID_SEARCH_FOLDERS = 2;
  private static final int METHODID_CREATE_FOLDER = 3;
  private static final int METHODID_UPDATE_FOLDER = 4;
  private static final int METHODID_MOVE_FOLDER = 5;
  private static final int METHODID_DELETE_FOLDER = 6;
  private static final int METHODID_UNDELETE_FOLDER = 7;
  private static final int METHODID_GET_IAM_POLICY = 8;
  private static final int METHODID_SET_IAM_POLICY = 9;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 10;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FoldersImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FoldersImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FOLDER:
          serviceImpl.getFolder(
              (com.google.cloud.resourcemanager.v3.GetFolderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.Folder>)
                  responseObserver);
          break;
        case METHODID_LIST_FOLDERS:
          serviceImpl.listFolders(
              (com.google.cloud.resourcemanager.v3.ListFoldersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.ListFoldersResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_FOLDERS:
          serviceImpl.searchFolders(
              (com.google.cloud.resourcemanager.v3.SearchFoldersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.resourcemanager.v3.SearchFoldersResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_FOLDER:
          serviceImpl.createFolder(
              (com.google.cloud.resourcemanager.v3.CreateFolderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_FOLDER:
          serviceImpl.updateFolder(
              (com.google.cloud.resourcemanager.v3.UpdateFolderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_MOVE_FOLDER:
          serviceImpl.moveFolder(
              (com.google.cloud.resourcemanager.v3.MoveFolderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_FOLDER:
          serviceImpl.deleteFolder(
              (com.google.cloud.resourcemanager.v3.DeleteFolderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNDELETE_FOLDER:
          serviceImpl.undeleteFolder(
              (com.google.cloud.resourcemanager.v3.UndeleteFolderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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

  private abstract static class FoldersBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FoldersBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.resourcemanager.v3.FoldersProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Folders");
    }
  }

  private static final class FoldersFileDescriptorSupplier extends FoldersBaseDescriptorSupplier {
    FoldersFileDescriptorSupplier() {}
  }

  private static final class FoldersMethodDescriptorSupplier extends FoldersBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FoldersMethodDescriptorSupplier(String methodName) {
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
      synchronized (FoldersGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new FoldersFileDescriptorSupplier())
                      .addMethod(getGetFolderMethod())
                      .addMethod(getListFoldersMethod())
                      .addMethod(getSearchFoldersMethod())
                      .addMethod(getCreateFolderMethod())
                      .addMethod(getUpdateFolderMethod())
                      .addMethod(getMoveFolderMethod())
                      .addMethod(getDeleteFolderMethod())
                      .addMethod(getUndeleteFolderMethod())
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
