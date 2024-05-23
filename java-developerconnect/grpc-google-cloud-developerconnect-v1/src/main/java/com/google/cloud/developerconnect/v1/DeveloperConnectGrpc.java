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
package com.google.cloud.developerconnect.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/developerconnect/v1/developer_connect.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DeveloperConnectGrpc {

  private DeveloperConnectGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.developerconnect.v1.DeveloperConnect";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.ListConnectionsRequest,
          com.google.cloud.developerconnect.v1.ListConnectionsResponse>
      getListConnectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConnections",
      requestType = com.google.cloud.developerconnect.v1.ListConnectionsRequest.class,
      responseType = com.google.cloud.developerconnect.v1.ListConnectionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.ListConnectionsRequest,
          com.google.cloud.developerconnect.v1.ListConnectionsResponse>
      getListConnectionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.developerconnect.v1.ListConnectionsRequest,
            com.google.cloud.developerconnect.v1.ListConnectionsResponse>
        getListConnectionsMethod;
    if ((getListConnectionsMethod = DeveloperConnectGrpc.getListConnectionsMethod) == null) {
      synchronized (DeveloperConnectGrpc.class) {
        if ((getListConnectionsMethod = DeveloperConnectGrpc.getListConnectionsMethod) == null) {
          DeveloperConnectGrpc.getListConnectionsMethod =
              getListConnectionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.developerconnect.v1.ListConnectionsRequest,
                          com.google.cloud.developerconnect.v1.ListConnectionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConnections"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.ListConnectionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.ListConnectionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeveloperConnectMethodDescriptorSupplier("ListConnections"))
                      .build();
        }
      }
    }
    return getListConnectionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.GetConnectionRequest,
          com.google.cloud.developerconnect.v1.Connection>
      getGetConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConnection",
      requestType = com.google.cloud.developerconnect.v1.GetConnectionRequest.class,
      responseType = com.google.cloud.developerconnect.v1.Connection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.GetConnectionRequest,
          com.google.cloud.developerconnect.v1.Connection>
      getGetConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.developerconnect.v1.GetConnectionRequest,
            com.google.cloud.developerconnect.v1.Connection>
        getGetConnectionMethod;
    if ((getGetConnectionMethod = DeveloperConnectGrpc.getGetConnectionMethod) == null) {
      synchronized (DeveloperConnectGrpc.class) {
        if ((getGetConnectionMethod = DeveloperConnectGrpc.getGetConnectionMethod) == null) {
          DeveloperConnectGrpc.getGetConnectionMethod =
              getGetConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.developerconnect.v1.GetConnectionRequest,
                          com.google.cloud.developerconnect.v1.Connection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.GetConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.Connection.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeveloperConnectMethodDescriptorSupplier("GetConnection"))
                      .build();
        }
      }
    }
    return getGetConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.CreateConnectionRequest,
          com.google.longrunning.Operation>
      getCreateConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConnection",
      requestType = com.google.cloud.developerconnect.v1.CreateConnectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.CreateConnectionRequest,
          com.google.longrunning.Operation>
      getCreateConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.developerconnect.v1.CreateConnectionRequest,
            com.google.longrunning.Operation>
        getCreateConnectionMethod;
    if ((getCreateConnectionMethod = DeveloperConnectGrpc.getCreateConnectionMethod) == null) {
      synchronized (DeveloperConnectGrpc.class) {
        if ((getCreateConnectionMethod = DeveloperConnectGrpc.getCreateConnectionMethod) == null) {
          DeveloperConnectGrpc.getCreateConnectionMethod =
              getCreateConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.developerconnect.v1.CreateConnectionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.CreateConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeveloperConnectMethodDescriptorSupplier("CreateConnection"))
                      .build();
        }
      }
    }
    return getCreateConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.UpdateConnectionRequest,
          com.google.longrunning.Operation>
      getUpdateConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConnection",
      requestType = com.google.cloud.developerconnect.v1.UpdateConnectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.UpdateConnectionRequest,
          com.google.longrunning.Operation>
      getUpdateConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.developerconnect.v1.UpdateConnectionRequest,
            com.google.longrunning.Operation>
        getUpdateConnectionMethod;
    if ((getUpdateConnectionMethod = DeveloperConnectGrpc.getUpdateConnectionMethod) == null) {
      synchronized (DeveloperConnectGrpc.class) {
        if ((getUpdateConnectionMethod = DeveloperConnectGrpc.getUpdateConnectionMethod) == null) {
          DeveloperConnectGrpc.getUpdateConnectionMethod =
              getUpdateConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.developerconnect.v1.UpdateConnectionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.UpdateConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeveloperConnectMethodDescriptorSupplier("UpdateConnection"))
                      .build();
        }
      }
    }
    return getUpdateConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.DeleteConnectionRequest,
          com.google.longrunning.Operation>
      getDeleteConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConnection",
      requestType = com.google.cloud.developerconnect.v1.DeleteConnectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.DeleteConnectionRequest,
          com.google.longrunning.Operation>
      getDeleteConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.developerconnect.v1.DeleteConnectionRequest,
            com.google.longrunning.Operation>
        getDeleteConnectionMethod;
    if ((getDeleteConnectionMethod = DeveloperConnectGrpc.getDeleteConnectionMethod) == null) {
      synchronized (DeveloperConnectGrpc.class) {
        if ((getDeleteConnectionMethod = DeveloperConnectGrpc.getDeleteConnectionMethod) == null) {
          DeveloperConnectGrpc.getDeleteConnectionMethod =
              getDeleteConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.developerconnect.v1.DeleteConnectionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.DeleteConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeveloperConnectMethodDescriptorSupplier("DeleteConnection"))
                      .build();
        }
      }
    }
    return getDeleteConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.CreateGitRepositoryLinkRequest,
          com.google.longrunning.Operation>
      getCreateGitRepositoryLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGitRepositoryLink",
      requestType = com.google.cloud.developerconnect.v1.CreateGitRepositoryLinkRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.CreateGitRepositoryLinkRequest,
          com.google.longrunning.Operation>
      getCreateGitRepositoryLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.developerconnect.v1.CreateGitRepositoryLinkRequest,
            com.google.longrunning.Operation>
        getCreateGitRepositoryLinkMethod;
    if ((getCreateGitRepositoryLinkMethod = DeveloperConnectGrpc.getCreateGitRepositoryLinkMethod)
        == null) {
      synchronized (DeveloperConnectGrpc.class) {
        if ((getCreateGitRepositoryLinkMethod =
                DeveloperConnectGrpc.getCreateGitRepositoryLinkMethod)
            == null) {
          DeveloperConnectGrpc.getCreateGitRepositoryLinkMethod =
              getCreateGitRepositoryLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.developerconnect.v1.CreateGitRepositoryLinkRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateGitRepositoryLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.CreateGitRepositoryLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeveloperConnectMethodDescriptorSupplier("CreateGitRepositoryLink"))
                      .build();
        }
      }
    }
    return getCreateGitRepositoryLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.DeleteGitRepositoryLinkRequest,
          com.google.longrunning.Operation>
      getDeleteGitRepositoryLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGitRepositoryLink",
      requestType = com.google.cloud.developerconnect.v1.DeleteGitRepositoryLinkRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.DeleteGitRepositoryLinkRequest,
          com.google.longrunning.Operation>
      getDeleteGitRepositoryLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.developerconnect.v1.DeleteGitRepositoryLinkRequest,
            com.google.longrunning.Operation>
        getDeleteGitRepositoryLinkMethod;
    if ((getDeleteGitRepositoryLinkMethod = DeveloperConnectGrpc.getDeleteGitRepositoryLinkMethod)
        == null) {
      synchronized (DeveloperConnectGrpc.class) {
        if ((getDeleteGitRepositoryLinkMethod =
                DeveloperConnectGrpc.getDeleteGitRepositoryLinkMethod)
            == null) {
          DeveloperConnectGrpc.getDeleteGitRepositoryLinkMethod =
              getDeleteGitRepositoryLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.developerconnect.v1.DeleteGitRepositoryLinkRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteGitRepositoryLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.DeleteGitRepositoryLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeveloperConnectMethodDescriptorSupplier("DeleteGitRepositoryLink"))
                      .build();
        }
      }
    }
    return getDeleteGitRepositoryLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.ListGitRepositoryLinksRequest,
          com.google.cloud.developerconnect.v1.ListGitRepositoryLinksResponse>
      getListGitRepositoryLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGitRepositoryLinks",
      requestType = com.google.cloud.developerconnect.v1.ListGitRepositoryLinksRequest.class,
      responseType = com.google.cloud.developerconnect.v1.ListGitRepositoryLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.ListGitRepositoryLinksRequest,
          com.google.cloud.developerconnect.v1.ListGitRepositoryLinksResponse>
      getListGitRepositoryLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.developerconnect.v1.ListGitRepositoryLinksRequest,
            com.google.cloud.developerconnect.v1.ListGitRepositoryLinksResponse>
        getListGitRepositoryLinksMethod;
    if ((getListGitRepositoryLinksMethod = DeveloperConnectGrpc.getListGitRepositoryLinksMethod)
        == null) {
      synchronized (DeveloperConnectGrpc.class) {
        if ((getListGitRepositoryLinksMethod = DeveloperConnectGrpc.getListGitRepositoryLinksMethod)
            == null) {
          DeveloperConnectGrpc.getListGitRepositoryLinksMethod =
              getListGitRepositoryLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.developerconnect.v1.ListGitRepositoryLinksRequest,
                          com.google.cloud.developerconnect.v1.ListGitRepositoryLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListGitRepositoryLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.ListGitRepositoryLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.ListGitRepositoryLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeveloperConnectMethodDescriptorSupplier("ListGitRepositoryLinks"))
                      .build();
        }
      }
    }
    return getListGitRepositoryLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.GetGitRepositoryLinkRequest,
          com.google.cloud.developerconnect.v1.GitRepositoryLink>
      getGetGitRepositoryLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGitRepositoryLink",
      requestType = com.google.cloud.developerconnect.v1.GetGitRepositoryLinkRequest.class,
      responseType = com.google.cloud.developerconnect.v1.GitRepositoryLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.GetGitRepositoryLinkRequest,
          com.google.cloud.developerconnect.v1.GitRepositoryLink>
      getGetGitRepositoryLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.developerconnect.v1.GetGitRepositoryLinkRequest,
            com.google.cloud.developerconnect.v1.GitRepositoryLink>
        getGetGitRepositoryLinkMethod;
    if ((getGetGitRepositoryLinkMethod = DeveloperConnectGrpc.getGetGitRepositoryLinkMethod)
        == null) {
      synchronized (DeveloperConnectGrpc.class) {
        if ((getGetGitRepositoryLinkMethod = DeveloperConnectGrpc.getGetGitRepositoryLinkMethod)
            == null) {
          DeveloperConnectGrpc.getGetGitRepositoryLinkMethod =
              getGetGitRepositoryLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.developerconnect.v1.GetGitRepositoryLinkRequest,
                          com.google.cloud.developerconnect.v1.GitRepositoryLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetGitRepositoryLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.GetGitRepositoryLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.GitRepositoryLink
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeveloperConnectMethodDescriptorSupplier("GetGitRepositoryLink"))
                      .build();
        }
      }
    }
    return getGetGitRepositoryLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.FetchReadWriteTokenRequest,
          com.google.cloud.developerconnect.v1.FetchReadWriteTokenResponse>
      getFetchReadWriteTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchReadWriteToken",
      requestType = com.google.cloud.developerconnect.v1.FetchReadWriteTokenRequest.class,
      responseType = com.google.cloud.developerconnect.v1.FetchReadWriteTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.FetchReadWriteTokenRequest,
          com.google.cloud.developerconnect.v1.FetchReadWriteTokenResponse>
      getFetchReadWriteTokenMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.developerconnect.v1.FetchReadWriteTokenRequest,
            com.google.cloud.developerconnect.v1.FetchReadWriteTokenResponse>
        getFetchReadWriteTokenMethod;
    if ((getFetchReadWriteTokenMethod = DeveloperConnectGrpc.getFetchReadWriteTokenMethod)
        == null) {
      synchronized (DeveloperConnectGrpc.class) {
        if ((getFetchReadWriteTokenMethod = DeveloperConnectGrpc.getFetchReadWriteTokenMethod)
            == null) {
          DeveloperConnectGrpc.getFetchReadWriteTokenMethod =
              getFetchReadWriteTokenMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.developerconnect.v1.FetchReadWriteTokenRequest,
                          com.google.cloud.developerconnect.v1.FetchReadWriteTokenResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FetchReadWriteToken"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.FetchReadWriteTokenRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.FetchReadWriteTokenResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeveloperConnectMethodDescriptorSupplier("FetchReadWriteToken"))
                      .build();
        }
      }
    }
    return getFetchReadWriteTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.FetchReadTokenRequest,
          com.google.cloud.developerconnect.v1.FetchReadTokenResponse>
      getFetchReadTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchReadToken",
      requestType = com.google.cloud.developerconnect.v1.FetchReadTokenRequest.class,
      responseType = com.google.cloud.developerconnect.v1.FetchReadTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.FetchReadTokenRequest,
          com.google.cloud.developerconnect.v1.FetchReadTokenResponse>
      getFetchReadTokenMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.developerconnect.v1.FetchReadTokenRequest,
            com.google.cloud.developerconnect.v1.FetchReadTokenResponse>
        getFetchReadTokenMethod;
    if ((getFetchReadTokenMethod = DeveloperConnectGrpc.getFetchReadTokenMethod) == null) {
      synchronized (DeveloperConnectGrpc.class) {
        if ((getFetchReadTokenMethod = DeveloperConnectGrpc.getFetchReadTokenMethod) == null) {
          DeveloperConnectGrpc.getFetchReadTokenMethod =
              getFetchReadTokenMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.developerconnect.v1.FetchReadTokenRequest,
                          com.google.cloud.developerconnect.v1.FetchReadTokenResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchReadToken"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.FetchReadTokenRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.FetchReadTokenResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeveloperConnectMethodDescriptorSupplier("FetchReadToken"))
                      .build();
        }
      }
    }
    return getFetchReadTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesRequest,
          com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesResponse>
      getFetchLinkableGitRepositoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchLinkableGitRepositories",
      requestType = com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesRequest.class,
      responseType =
          com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesRequest,
          com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesResponse>
      getFetchLinkableGitRepositoriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesRequest,
            com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesResponse>
        getFetchLinkableGitRepositoriesMethod;
    if ((getFetchLinkableGitRepositoriesMethod =
            DeveloperConnectGrpc.getFetchLinkableGitRepositoriesMethod)
        == null) {
      synchronized (DeveloperConnectGrpc.class) {
        if ((getFetchLinkableGitRepositoriesMethod =
                DeveloperConnectGrpc.getFetchLinkableGitRepositoriesMethod)
            == null) {
          DeveloperConnectGrpc.getFetchLinkableGitRepositoriesMethod =
              getFetchLinkableGitRepositoriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesRequest,
                          com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FetchLinkableGitRepositories"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1
                                  .FetchLinkableGitRepositoriesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1
                                  .FetchLinkableGitRepositoriesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeveloperConnectMethodDescriptorSupplier(
                              "FetchLinkableGitRepositories"))
                      .build();
        }
      }
    }
    return getFetchLinkableGitRepositoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.FetchGitHubInstallationsRequest,
          com.google.cloud.developerconnect.v1.FetchGitHubInstallationsResponse>
      getFetchGitHubInstallationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchGitHubInstallations",
      requestType = com.google.cloud.developerconnect.v1.FetchGitHubInstallationsRequest.class,
      responseType = com.google.cloud.developerconnect.v1.FetchGitHubInstallationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.FetchGitHubInstallationsRequest,
          com.google.cloud.developerconnect.v1.FetchGitHubInstallationsResponse>
      getFetchGitHubInstallationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.developerconnect.v1.FetchGitHubInstallationsRequest,
            com.google.cloud.developerconnect.v1.FetchGitHubInstallationsResponse>
        getFetchGitHubInstallationsMethod;
    if ((getFetchGitHubInstallationsMethod = DeveloperConnectGrpc.getFetchGitHubInstallationsMethod)
        == null) {
      synchronized (DeveloperConnectGrpc.class) {
        if ((getFetchGitHubInstallationsMethod =
                DeveloperConnectGrpc.getFetchGitHubInstallationsMethod)
            == null) {
          DeveloperConnectGrpc.getFetchGitHubInstallationsMethod =
              getFetchGitHubInstallationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.developerconnect.v1.FetchGitHubInstallationsRequest,
                          com.google.cloud.developerconnect.v1.FetchGitHubInstallationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FetchGitHubInstallations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.FetchGitHubInstallationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.FetchGitHubInstallationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeveloperConnectMethodDescriptorSupplier("FetchGitHubInstallations"))
                      .build();
        }
      }
    }
    return getFetchGitHubInstallationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.FetchGitRefsRequest,
          com.google.cloud.developerconnect.v1.FetchGitRefsResponse>
      getFetchGitRefsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchGitRefs",
      requestType = com.google.cloud.developerconnect.v1.FetchGitRefsRequest.class,
      responseType = com.google.cloud.developerconnect.v1.FetchGitRefsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.developerconnect.v1.FetchGitRefsRequest,
          com.google.cloud.developerconnect.v1.FetchGitRefsResponse>
      getFetchGitRefsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.developerconnect.v1.FetchGitRefsRequest,
            com.google.cloud.developerconnect.v1.FetchGitRefsResponse>
        getFetchGitRefsMethod;
    if ((getFetchGitRefsMethod = DeveloperConnectGrpc.getFetchGitRefsMethod) == null) {
      synchronized (DeveloperConnectGrpc.class) {
        if ((getFetchGitRefsMethod = DeveloperConnectGrpc.getFetchGitRefsMethod) == null) {
          DeveloperConnectGrpc.getFetchGitRefsMethod =
              getFetchGitRefsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.developerconnect.v1.FetchGitRefsRequest,
                          com.google.cloud.developerconnect.v1.FetchGitRefsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchGitRefs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.FetchGitRefsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.developerconnect.v1.FetchGitRefsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeveloperConnectMethodDescriptorSupplier("FetchGitRefs"))
                      .build();
        }
      }
    }
    return getFetchGitRefsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DeveloperConnectStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeveloperConnectStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeveloperConnectStub>() {
          @java.lang.Override
          public DeveloperConnectStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeveloperConnectStub(channel, callOptions);
          }
        };
    return DeveloperConnectStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeveloperConnectBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeveloperConnectBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeveloperConnectBlockingStub>() {
          @java.lang.Override
          public DeveloperConnectBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeveloperConnectBlockingStub(channel, callOptions);
          }
        };
    return DeveloperConnectBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DeveloperConnectFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeveloperConnectFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeveloperConnectFutureStub>() {
          @java.lang.Override
          public DeveloperConnectFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeveloperConnectFutureStub(channel, callOptions);
          }
        };
    return DeveloperConnectFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists Connections in a given project and location.
     * </pre>
     */
    default void listConnections(
        com.google.cloud.developerconnect.v1.ListConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.developerconnect.v1.ListConnectionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConnectionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Connection.
     * </pre>
     */
    default void getConnection(
        com.google.cloud.developerconnect.v1.GetConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.developerconnect.v1.Connection>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Connection in a given project and location.
     * </pre>
     */
    default void createConnection(
        com.google.cloud.developerconnect.v1.CreateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Connection.
     * </pre>
     */
    default void updateConnection(
        com.google.cloud.developerconnect.v1.UpdateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Connection.
     * </pre>
     */
    default void deleteConnection(
        com.google.cloud.developerconnect.v1.DeleteConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a GitRepositoryLink. Upon linking a Git Repository, Developer
     * Connect will configure the Git Repository to send webhook events to
     * Developer Connect. Connections that use Firebase GitHub Application will
     * have events forwarded to the Firebase service. All other Connections will
     * have events forwarded to Cloud Build.
     * </pre>
     */
    default void createGitRepositoryLink(
        com.google.cloud.developerconnect.v1.CreateGitRepositoryLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateGitRepositoryLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single GitRepositoryLink.
     * </pre>
     */
    default void deleteGitRepositoryLink(
        com.google.cloud.developerconnect.v1.DeleteGitRepositoryLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteGitRepositoryLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists GitRepositoryLinks in a given project, location, and connection.
     * </pre>
     */
    default void listGitRepositoryLinks(
        com.google.cloud.developerconnect.v1.ListGitRepositoryLinksRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.developerconnect.v1.ListGitRepositoryLinksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListGitRepositoryLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single GitRepositoryLink.
     * </pre>
     */
    default void getGitRepositoryLink(
        com.google.cloud.developerconnect.v1.GetGitRepositoryLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.developerconnect.v1.GitRepositoryLink>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetGitRepositoryLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches read/write token of a given gitRepositoryLink.
     * </pre>
     */
    default void fetchReadWriteToken(
        com.google.cloud.developerconnect.v1.FetchReadWriteTokenRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.developerconnect.v1.FetchReadWriteTokenResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchReadWriteTokenMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches read token of a given gitRepositoryLink.
     * </pre>
     */
    default void fetchReadToken(
        com.google.cloud.developerconnect.v1.FetchReadTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.developerconnect.v1.FetchReadTokenResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchReadTokenMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * FetchLinkableGitRepositories returns a list of git repositories from an SCM
     * that are available to be added to a Connection.
     * </pre>
     */
    default void fetchLinkableGitRepositories(
        com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchLinkableGitRepositoriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * FetchGitHubInstallations returns the list of GitHub Installations that
     * are available to be added to a Connection.
     * For github.com, only installations accessible to the authorizer token
     * are returned. For GitHub Enterprise, all installations are returned.
     * </pre>
     */
    default void fetchGitHubInstallations(
        com.google.cloud.developerconnect.v1.FetchGitHubInstallationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.developerconnect.v1.FetchGitHubInstallationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchGitHubInstallationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetch the list of branches or tags for a given repository.
     * </pre>
     */
    default void fetchGitRefs(
        com.google.cloud.developerconnect.v1.FetchGitRefsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.developerconnect.v1.FetchGitRefsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchGitRefsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DeveloperConnect.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class DeveloperConnectImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DeveloperConnectGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DeveloperConnect.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class DeveloperConnectStub
      extends io.grpc.stub.AbstractAsyncStub<DeveloperConnectStub> {
    private DeveloperConnectStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeveloperConnectStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeveloperConnectStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Connections in a given project and location.
     * </pre>
     */
    public void listConnections(
        com.google.cloud.developerconnect.v1.ListConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.developerconnect.v1.ListConnectionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConnectionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Connection.
     * </pre>
     */
    public void getConnection(
        com.google.cloud.developerconnect.v1.GetConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.developerconnect.v1.Connection>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Connection in a given project and location.
     * </pre>
     */
    public void createConnection(
        com.google.cloud.developerconnect.v1.CreateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Connection.
     * </pre>
     */
    public void updateConnection(
        com.google.cloud.developerconnect.v1.UpdateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Connection.
     * </pre>
     */
    public void deleteConnection(
        com.google.cloud.developerconnect.v1.DeleteConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a GitRepositoryLink. Upon linking a Git Repository, Developer
     * Connect will configure the Git Repository to send webhook events to
     * Developer Connect. Connections that use Firebase GitHub Application will
     * have events forwarded to the Firebase service. All other Connections will
     * have events forwarded to Cloud Build.
     * </pre>
     */
    public void createGitRepositoryLink(
        com.google.cloud.developerconnect.v1.CreateGitRepositoryLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGitRepositoryLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single GitRepositoryLink.
     * </pre>
     */
    public void deleteGitRepositoryLink(
        com.google.cloud.developerconnect.v1.DeleteGitRepositoryLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGitRepositoryLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists GitRepositoryLinks in a given project, location, and connection.
     * </pre>
     */
    public void listGitRepositoryLinks(
        com.google.cloud.developerconnect.v1.ListGitRepositoryLinksRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.developerconnect.v1.ListGitRepositoryLinksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGitRepositoryLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single GitRepositoryLink.
     * </pre>
     */
    public void getGitRepositoryLink(
        com.google.cloud.developerconnect.v1.GetGitRepositoryLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.developerconnect.v1.GitRepositoryLink>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGitRepositoryLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches read/write token of a given gitRepositoryLink.
     * </pre>
     */
    public void fetchReadWriteToken(
        com.google.cloud.developerconnect.v1.FetchReadWriteTokenRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.developerconnect.v1.FetchReadWriteTokenResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchReadWriteTokenMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches read token of a given gitRepositoryLink.
     * </pre>
     */
    public void fetchReadToken(
        com.google.cloud.developerconnect.v1.FetchReadTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.developerconnect.v1.FetchReadTokenResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchReadTokenMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * FetchLinkableGitRepositories returns a list of git repositories from an SCM
     * that are available to be added to a Connection.
     * </pre>
     */
    public void fetchLinkableGitRepositories(
        com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchLinkableGitRepositoriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * FetchGitHubInstallations returns the list of GitHub Installations that
     * are available to be added to a Connection.
     * For github.com, only installations accessible to the authorizer token
     * are returned. For GitHub Enterprise, all installations are returned.
     * </pre>
     */
    public void fetchGitHubInstallations(
        com.google.cloud.developerconnect.v1.FetchGitHubInstallationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.developerconnect.v1.FetchGitHubInstallationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchGitHubInstallationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetch the list of branches or tags for a given repository.
     * </pre>
     */
    public void fetchGitRefs(
        com.google.cloud.developerconnect.v1.FetchGitRefsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.developerconnect.v1.FetchGitRefsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchGitRefsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DeveloperConnect.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class DeveloperConnectBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DeveloperConnectBlockingStub> {
    private DeveloperConnectBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeveloperConnectBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeveloperConnectBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Connections in a given project and location.
     * </pre>
     */
    public com.google.cloud.developerconnect.v1.ListConnectionsResponse listConnections(
        com.google.cloud.developerconnect.v1.ListConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConnectionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Connection.
     * </pre>
     */
    public com.google.cloud.developerconnect.v1.Connection getConnection(
        com.google.cloud.developerconnect.v1.GetConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Connection in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createConnection(
        com.google.cloud.developerconnect.v1.CreateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Connection.
     * </pre>
     */
    public com.google.longrunning.Operation updateConnection(
        com.google.cloud.developerconnect.v1.UpdateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Connection.
     * </pre>
     */
    public com.google.longrunning.Operation deleteConnection(
        com.google.cloud.developerconnect.v1.DeleteConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a GitRepositoryLink. Upon linking a Git Repository, Developer
     * Connect will configure the Git Repository to send webhook events to
     * Developer Connect. Connections that use Firebase GitHub Application will
     * have events forwarded to the Firebase service. All other Connections will
     * have events forwarded to Cloud Build.
     * </pre>
     */
    public com.google.longrunning.Operation createGitRepositoryLink(
        com.google.cloud.developerconnect.v1.CreateGitRepositoryLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGitRepositoryLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single GitRepositoryLink.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGitRepositoryLink(
        com.google.cloud.developerconnect.v1.DeleteGitRepositoryLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGitRepositoryLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists GitRepositoryLinks in a given project, location, and connection.
     * </pre>
     */
    public com.google.cloud.developerconnect.v1.ListGitRepositoryLinksResponse
        listGitRepositoryLinks(
            com.google.cloud.developerconnect.v1.ListGitRepositoryLinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGitRepositoryLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single GitRepositoryLink.
     * </pre>
     */
    public com.google.cloud.developerconnect.v1.GitRepositoryLink getGitRepositoryLink(
        com.google.cloud.developerconnect.v1.GetGitRepositoryLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGitRepositoryLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches read/write token of a given gitRepositoryLink.
     * </pre>
     */
    public com.google.cloud.developerconnect.v1.FetchReadWriteTokenResponse fetchReadWriteToken(
        com.google.cloud.developerconnect.v1.FetchReadWriteTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchReadWriteTokenMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches read token of a given gitRepositoryLink.
     * </pre>
     */
    public com.google.cloud.developerconnect.v1.FetchReadTokenResponse fetchReadToken(
        com.google.cloud.developerconnect.v1.FetchReadTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchReadTokenMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * FetchLinkableGitRepositories returns a list of git repositories from an SCM
     * that are available to be added to a Connection.
     * </pre>
     */
    public com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesResponse
        fetchLinkableGitRepositories(
            com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchLinkableGitRepositoriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * FetchGitHubInstallations returns the list of GitHub Installations that
     * are available to be added to a Connection.
     * For github.com, only installations accessible to the authorizer token
     * are returned. For GitHub Enterprise, all installations are returned.
     * </pre>
     */
    public com.google.cloud.developerconnect.v1.FetchGitHubInstallationsResponse
        fetchGitHubInstallations(
            com.google.cloud.developerconnect.v1.FetchGitHubInstallationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchGitHubInstallationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetch the list of branches or tags for a given repository.
     * </pre>
     */
    public com.google.cloud.developerconnect.v1.FetchGitRefsResponse fetchGitRefs(
        com.google.cloud.developerconnect.v1.FetchGitRefsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchGitRefsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DeveloperConnect.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class DeveloperConnectFutureStub
      extends io.grpc.stub.AbstractFutureStub<DeveloperConnectFutureStub> {
    private DeveloperConnectFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeveloperConnectFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeveloperConnectFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Connections in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.developerconnect.v1.ListConnectionsResponse>
        listConnections(com.google.cloud.developerconnect.v1.ListConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConnectionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.developerconnect.v1.Connection>
        getConnection(com.google.cloud.developerconnect.v1.GetConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Connection in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createConnection(com.google.cloud.developerconnect.v1.CreateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateConnection(com.google.cloud.developerconnect.v1.UpdateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteConnection(com.google.cloud.developerconnect.v1.DeleteConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a GitRepositoryLink. Upon linking a Git Repository, Developer
     * Connect will configure the Git Repository to send webhook events to
     * Developer Connect. Connections that use Firebase GitHub Application will
     * have events forwarded to the Firebase service. All other Connections will
     * have events forwarded to Cloud Build.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createGitRepositoryLink(
            com.google.cloud.developerconnect.v1.CreateGitRepositoryLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGitRepositoryLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single GitRepositoryLink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteGitRepositoryLink(
            com.google.cloud.developerconnect.v1.DeleteGitRepositoryLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGitRepositoryLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists GitRepositoryLinks in a given project, location, and connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.developerconnect.v1.ListGitRepositoryLinksResponse>
        listGitRepositoryLinks(
            com.google.cloud.developerconnect.v1.ListGitRepositoryLinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGitRepositoryLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single GitRepositoryLink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.developerconnect.v1.GitRepositoryLink>
        getGitRepositoryLink(
            com.google.cloud.developerconnect.v1.GetGitRepositoryLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGitRepositoryLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches read/write token of a given gitRepositoryLink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.developerconnect.v1.FetchReadWriteTokenResponse>
        fetchReadWriteToken(
            com.google.cloud.developerconnect.v1.FetchReadWriteTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchReadWriteTokenMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches read token of a given gitRepositoryLink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.developerconnect.v1.FetchReadTokenResponse>
        fetchReadToken(com.google.cloud.developerconnect.v1.FetchReadTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchReadTokenMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * FetchLinkableGitRepositories returns a list of git repositories from an SCM
     * that are available to be added to a Connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesResponse>
        fetchLinkableGitRepositories(
            com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchLinkableGitRepositoriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * FetchGitHubInstallations returns the list of GitHub Installations that
     * are available to be added to a Connection.
     * For github.com, only installations accessible to the authorizer token
     * are returned. For GitHub Enterprise, all installations are returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.developerconnect.v1.FetchGitHubInstallationsResponse>
        fetchGitHubInstallations(
            com.google.cloud.developerconnect.v1.FetchGitHubInstallationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchGitHubInstallationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetch the list of branches or tags for a given repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.developerconnect.v1.FetchGitRefsResponse>
        fetchGitRefs(com.google.cloud.developerconnect.v1.FetchGitRefsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchGitRefsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CONNECTIONS = 0;
  private static final int METHODID_GET_CONNECTION = 1;
  private static final int METHODID_CREATE_CONNECTION = 2;
  private static final int METHODID_UPDATE_CONNECTION = 3;
  private static final int METHODID_DELETE_CONNECTION = 4;
  private static final int METHODID_CREATE_GIT_REPOSITORY_LINK = 5;
  private static final int METHODID_DELETE_GIT_REPOSITORY_LINK = 6;
  private static final int METHODID_LIST_GIT_REPOSITORY_LINKS = 7;
  private static final int METHODID_GET_GIT_REPOSITORY_LINK = 8;
  private static final int METHODID_FETCH_READ_WRITE_TOKEN = 9;
  private static final int METHODID_FETCH_READ_TOKEN = 10;
  private static final int METHODID_FETCH_LINKABLE_GIT_REPOSITORIES = 11;
  private static final int METHODID_FETCH_GIT_HUB_INSTALLATIONS = 12;
  private static final int METHODID_FETCH_GIT_REFS = 13;

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
        case METHODID_LIST_CONNECTIONS:
          serviceImpl.listConnections(
              (com.google.cloud.developerconnect.v1.ListConnectionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.developerconnect.v1.ListConnectionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CONNECTION:
          serviceImpl.getConnection(
              (com.google.cloud.developerconnect.v1.GetConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.developerconnect.v1.Connection>)
                  responseObserver);
          break;
        case METHODID_CREATE_CONNECTION:
          serviceImpl.createConnection(
              (com.google.cloud.developerconnect.v1.CreateConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CONNECTION:
          serviceImpl.updateConnection(
              (com.google.cloud.developerconnect.v1.UpdateConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CONNECTION:
          serviceImpl.deleteConnection(
              (com.google.cloud.developerconnect.v1.DeleteConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_GIT_REPOSITORY_LINK:
          serviceImpl.createGitRepositoryLink(
              (com.google.cloud.developerconnect.v1.CreateGitRepositoryLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_GIT_REPOSITORY_LINK:
          serviceImpl.deleteGitRepositoryLink(
              (com.google.cloud.developerconnect.v1.DeleteGitRepositoryLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_GIT_REPOSITORY_LINKS:
          serviceImpl.listGitRepositoryLinks(
              (com.google.cloud.developerconnect.v1.ListGitRepositoryLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.developerconnect.v1.ListGitRepositoryLinksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_GIT_REPOSITORY_LINK:
          serviceImpl.getGitRepositoryLink(
              (com.google.cloud.developerconnect.v1.GetGitRepositoryLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.developerconnect.v1.GitRepositoryLink>)
                  responseObserver);
          break;
        case METHODID_FETCH_READ_WRITE_TOKEN:
          serviceImpl.fetchReadWriteToken(
              (com.google.cloud.developerconnect.v1.FetchReadWriteTokenRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.developerconnect.v1.FetchReadWriteTokenResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_READ_TOKEN:
          serviceImpl.fetchReadToken(
              (com.google.cloud.developerconnect.v1.FetchReadTokenRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.developerconnect.v1.FetchReadTokenResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_LINKABLE_GIT_REPOSITORIES:
          serviceImpl.fetchLinkableGitRepositories(
              (com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_GIT_HUB_INSTALLATIONS:
          serviceImpl.fetchGitHubInstallations(
              (com.google.cloud.developerconnect.v1.FetchGitHubInstallationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.developerconnect.v1.FetchGitHubInstallationsResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_GIT_REFS:
          serviceImpl.fetchGitRefs(
              (com.google.cloud.developerconnect.v1.FetchGitRefsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.developerconnect.v1.FetchGitRefsResponse>)
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
            getListConnectionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.developerconnect.v1.ListConnectionsRequest,
                    com.google.cloud.developerconnect.v1.ListConnectionsResponse>(
                    service, METHODID_LIST_CONNECTIONS)))
        .addMethod(
            getGetConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.developerconnect.v1.GetConnectionRequest,
                    com.google.cloud.developerconnect.v1.Connection>(
                    service, METHODID_GET_CONNECTION)))
        .addMethod(
            getCreateConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.developerconnect.v1.CreateConnectionRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CONNECTION)))
        .addMethod(
            getUpdateConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.developerconnect.v1.UpdateConnectionRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_CONNECTION)))
        .addMethod(
            getDeleteConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.developerconnect.v1.DeleteConnectionRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CONNECTION)))
        .addMethod(
            getCreateGitRepositoryLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.developerconnect.v1.CreateGitRepositoryLinkRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_GIT_REPOSITORY_LINK)))
        .addMethod(
            getDeleteGitRepositoryLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.developerconnect.v1.DeleteGitRepositoryLinkRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_GIT_REPOSITORY_LINK)))
        .addMethod(
            getListGitRepositoryLinksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.developerconnect.v1.ListGitRepositoryLinksRequest,
                    com.google.cloud.developerconnect.v1.ListGitRepositoryLinksResponse>(
                    service, METHODID_LIST_GIT_REPOSITORY_LINKS)))
        .addMethod(
            getGetGitRepositoryLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.developerconnect.v1.GetGitRepositoryLinkRequest,
                    com.google.cloud.developerconnect.v1.GitRepositoryLink>(
                    service, METHODID_GET_GIT_REPOSITORY_LINK)))
        .addMethod(
            getFetchReadWriteTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.developerconnect.v1.FetchReadWriteTokenRequest,
                    com.google.cloud.developerconnect.v1.FetchReadWriteTokenResponse>(
                    service, METHODID_FETCH_READ_WRITE_TOKEN)))
        .addMethod(
            getFetchReadTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.developerconnect.v1.FetchReadTokenRequest,
                    com.google.cloud.developerconnect.v1.FetchReadTokenResponse>(
                    service, METHODID_FETCH_READ_TOKEN)))
        .addMethod(
            getFetchLinkableGitRepositoriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesRequest,
                    com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesResponse>(
                    service, METHODID_FETCH_LINKABLE_GIT_REPOSITORIES)))
        .addMethod(
            getFetchGitHubInstallationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.developerconnect.v1.FetchGitHubInstallationsRequest,
                    com.google.cloud.developerconnect.v1.FetchGitHubInstallationsResponse>(
                    service, METHODID_FETCH_GIT_HUB_INSTALLATIONS)))
        .addMethod(
            getFetchGitRefsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.developerconnect.v1.FetchGitRefsRequest,
                    com.google.cloud.developerconnect.v1.FetchGitRefsResponse>(
                    service, METHODID_FETCH_GIT_REFS)))
        .build();
  }

  private abstract static class DeveloperConnectBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DeveloperConnectBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.developerconnect.v1.DeveloperConnectProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DeveloperConnect");
    }
  }

  private static final class DeveloperConnectFileDescriptorSupplier
      extends DeveloperConnectBaseDescriptorSupplier {
    DeveloperConnectFileDescriptorSupplier() {}
  }

  private static final class DeveloperConnectMethodDescriptorSupplier
      extends DeveloperConnectBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DeveloperConnectMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DeveloperConnectGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DeveloperConnectFileDescriptorSupplier())
                      .addMethod(getListConnectionsMethod())
                      .addMethod(getGetConnectionMethod())
                      .addMethod(getCreateConnectionMethod())
                      .addMethod(getUpdateConnectionMethod())
                      .addMethod(getDeleteConnectionMethod())
                      .addMethod(getCreateGitRepositoryLinkMethod())
                      .addMethod(getDeleteGitRepositoryLinkMethod())
                      .addMethod(getListGitRepositoryLinksMethod())
                      .addMethod(getGetGitRepositoryLinkMethod())
                      .addMethod(getFetchReadWriteTokenMethod())
                      .addMethod(getFetchReadTokenMethod())
                      .addMethod(getFetchLinkableGitRepositoriesMethod())
                      .addMethod(getFetchGitHubInstallationsMethod())
                      .addMethod(getFetchGitRefsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
