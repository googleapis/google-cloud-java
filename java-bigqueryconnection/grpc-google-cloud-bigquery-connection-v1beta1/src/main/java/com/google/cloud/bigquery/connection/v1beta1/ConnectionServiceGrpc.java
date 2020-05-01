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
package com.google.cloud.bigquery.connection.v1beta1;

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
 * Manages external data source connections and credentials.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/bigquery/connection/v1beta1/connection.proto")
public final class ConnectionServiceGrpc {

  private ConnectionServiceGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.bigquery.connection.v1beta1.ConnectionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.CreateConnectionRequest,
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
      getCreateConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConnection",
      requestType =
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.CreateConnectionRequest
              .class,
      responseType = com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.CreateConnectionRequest,
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
      getCreateConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.CreateConnectionRequest,
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
        getCreateConnectionMethod;
    if ((getCreateConnectionMethod = ConnectionServiceGrpc.getCreateConnectionMethod) == null) {
      synchronized (ConnectionServiceGrpc.class) {
        if ((getCreateConnectionMethod = ConnectionServiceGrpc.getCreateConnectionMethod) == null) {
          ConnectionServiceGrpc.getCreateConnectionMethod =
              getCreateConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                              .CreateConnectionRequest,
                          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                                  .CreateConnectionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                                  .Connection.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConnectionServiceMethodDescriptorSupplier("CreateConnection"))
                      .build();
        }
      }
    }
    return getCreateConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.GetConnectionRequest,
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
      getGetConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConnection",
      requestType =
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.GetConnectionRequest.class,
      responseType = com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.GetConnectionRequest,
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
      getGetConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.GetConnectionRequest,
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
        getGetConnectionMethod;
    if ((getGetConnectionMethod = ConnectionServiceGrpc.getGetConnectionMethod) == null) {
      synchronized (ConnectionServiceGrpc.class) {
        if ((getGetConnectionMethod = ConnectionServiceGrpc.getGetConnectionMethod) == null) {
          ConnectionServiceGrpc.getGetConnectionMethod =
              getGetConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                              .GetConnectionRequest,
                          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                                  .GetConnectionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                                  .Connection.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConnectionServiceMethodDescriptorSupplier("GetConnection"))
                      .build();
        }
      }
    }
    return getGetConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.ListConnectionsRequest,
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.ListConnectionsResponse>
      getListConnectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConnections",
      requestType =
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.ListConnectionsRequest.class,
      responseType =
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.ListConnectionsResponse
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.ListConnectionsRequest,
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.ListConnectionsResponse>
      getListConnectionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.ListConnectionsRequest,
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.ListConnectionsResponse>
        getListConnectionsMethod;
    if ((getListConnectionsMethod = ConnectionServiceGrpc.getListConnectionsMethod) == null) {
      synchronized (ConnectionServiceGrpc.class) {
        if ((getListConnectionsMethod = ConnectionServiceGrpc.getListConnectionsMethod) == null) {
          ConnectionServiceGrpc.getListConnectionsMethod =
              getListConnectionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                              .ListConnectionsRequest,
                          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                              .ListConnectionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConnections"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                                  .ListConnectionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                                  .ListConnectionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConnectionServiceMethodDescriptorSupplier("ListConnections"))
                      .build();
        }
      }
    }
    return getListConnectionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.UpdateConnectionRequest,
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
      getUpdateConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConnection",
      requestType =
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.UpdateConnectionRequest
              .class,
      responseType = com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.UpdateConnectionRequest,
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
      getUpdateConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.UpdateConnectionRequest,
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
        getUpdateConnectionMethod;
    if ((getUpdateConnectionMethod = ConnectionServiceGrpc.getUpdateConnectionMethod) == null) {
      synchronized (ConnectionServiceGrpc.class) {
        if ((getUpdateConnectionMethod = ConnectionServiceGrpc.getUpdateConnectionMethod) == null) {
          ConnectionServiceGrpc.getUpdateConnectionMethod =
              getUpdateConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                              .UpdateConnectionRequest,
                          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                                  .UpdateConnectionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                                  .Connection.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConnectionServiceMethodDescriptorSupplier("UpdateConnection"))
                      .build();
        }
      }
    }
    return getUpdateConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
              .UpdateConnectionCredentialRequest,
          com.google.protobuf.Empty>
      getUpdateConnectionCredentialMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConnectionCredential",
      requestType =
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
              .UpdateConnectionCredentialRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
              .UpdateConnectionCredentialRequest,
          com.google.protobuf.Empty>
      getUpdateConnectionCredentialMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                .UpdateConnectionCredentialRequest,
            com.google.protobuf.Empty>
        getUpdateConnectionCredentialMethod;
    if ((getUpdateConnectionCredentialMethod =
            ConnectionServiceGrpc.getUpdateConnectionCredentialMethod)
        == null) {
      synchronized (ConnectionServiceGrpc.class) {
        if ((getUpdateConnectionCredentialMethod =
                ConnectionServiceGrpc.getUpdateConnectionCredentialMethod)
            == null) {
          ConnectionServiceGrpc.getUpdateConnectionCredentialMethod =
              getUpdateConnectionCredentialMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                              .UpdateConnectionCredentialRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateConnectionCredential"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                                  .UpdateConnectionCredentialRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConnectionServiceMethodDescriptorSupplier(
                              "UpdateConnectionCredential"))
                      .build();
        }
      }
    }
    return getUpdateConnectionCredentialMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.DeleteConnectionRequest,
          com.google.protobuf.Empty>
      getDeleteConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConnection",
      requestType =
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.DeleteConnectionRequest
              .class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.DeleteConnectionRequest,
          com.google.protobuf.Empty>
      getDeleteConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.DeleteConnectionRequest,
            com.google.protobuf.Empty>
        getDeleteConnectionMethod;
    if ((getDeleteConnectionMethod = ConnectionServiceGrpc.getDeleteConnectionMethod) == null) {
      synchronized (ConnectionServiceGrpc.class) {
        if ((getDeleteConnectionMethod = ConnectionServiceGrpc.getDeleteConnectionMethod) == null) {
          ConnectionServiceGrpc.getDeleteConnectionMethod =
              getDeleteConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                              .DeleteConnectionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                                  .DeleteConnectionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConnectionServiceMethodDescriptorSupplier("DeleteConnection"))
                      .build();
        }
      }
    }
    return getDeleteConnectionMethod;
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
    if ((getGetIamPolicyMethod = ConnectionServiceGrpc.getGetIamPolicyMethod) == null) {
      synchronized (ConnectionServiceGrpc.class) {
        if ((getGetIamPolicyMethod = ConnectionServiceGrpc.getGetIamPolicyMethod) == null) {
          ConnectionServiceGrpc.getGetIamPolicyMethod =
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
                          new ConnectionServiceMethodDescriptorSupplier("GetIamPolicy"))
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
    if ((getSetIamPolicyMethod = ConnectionServiceGrpc.getSetIamPolicyMethod) == null) {
      synchronized (ConnectionServiceGrpc.class) {
        if ((getSetIamPolicyMethod = ConnectionServiceGrpc.getSetIamPolicyMethod) == null) {
          ConnectionServiceGrpc.getSetIamPolicyMethod =
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
                          new ConnectionServiceMethodDescriptorSupplier("SetIamPolicy"))
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
    if ((getTestIamPermissionsMethod = ConnectionServiceGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (ConnectionServiceGrpc.class) {
        if ((getTestIamPermissionsMethod = ConnectionServiceGrpc.getTestIamPermissionsMethod)
            == null) {
          ConnectionServiceGrpc.getTestIamPermissionsMethod =
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
                          new ConnectionServiceMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ConnectionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConnectionServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConnectionServiceStub>() {
          @java.lang.Override
          public ConnectionServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConnectionServiceStub(channel, callOptions);
          }
        };
    return ConnectionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConnectionServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConnectionServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConnectionServiceBlockingStub>() {
          @java.lang.Override
          public ConnectionServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConnectionServiceBlockingStub(channel, callOptions);
          }
        };
    return ConnectionServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ConnectionServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConnectionServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConnectionServiceFutureStub>() {
          @java.lang.Override
          public ConnectionServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConnectionServiceFutureStub(channel, callOptions);
          }
        };
    return ConnectionServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manages external data source connections and credentials.
   * </pre>
   */
  public abstract static class ConnectionServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a new connection.
     * </pre>
     */
    public void createConnection(
        com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.CreateConnectionRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns specified connection.
     * </pre>
     */
    public void getConnection(
        com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.GetConnectionRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of connections in the given project.
     * </pre>
     */
    public void listConnections(
        com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.ListConnectionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                    .ListConnectionsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListConnectionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified connection. For security reasons, also resets
     * credential if connection properties are in the update field mask.
     * </pre>
     */
    public void updateConnection(
        com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.UpdateConnectionRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the credential for the specified connection.
     * </pre>
     */
    public void updateConnectionCredential(
        com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                .UpdateConnectionCredentialRequest
            request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateConnectionCredentialMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes connection and associated credential.
     * </pre>
     */
    public void deleteConnection(
        com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.DeleteConnectionRequest
            request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a resource.
     * Returns an empty policy if the resource exists and does not have a policy
     * set.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnimplementedUnaryCall(getGetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified resource. Replaces any
     * existing policy.
     * Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnimplementedUnaryCall(getSetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified resource.
     * If the resource does not exist, this will return an empty set of
     * permissions, not a NOT_FOUND error.
     * Note: This operation is designed to be used for building permission-aware
     * UIs and command-line tools, not for authorization checking. This operation
     * may "fail open" without warning.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getTestIamPermissionsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateConnectionMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                          .CreateConnectionRequest,
                      com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>(
                      this, METHODID_CREATE_CONNECTION)))
          .addMethod(
              getGetConnectionMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                          .GetConnectionRequest,
                      com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>(
                      this, METHODID_GET_CONNECTION)))
          .addMethod(
              getListConnectionsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                          .ListConnectionsRequest,
                      com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                          .ListConnectionsResponse>(this, METHODID_LIST_CONNECTIONS)))
          .addMethod(
              getUpdateConnectionMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                          .UpdateConnectionRequest,
                      com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>(
                      this, METHODID_UPDATE_CONNECTION)))
          .addMethod(
              getUpdateConnectionCredentialMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                          .UpdateConnectionCredentialRequest,
                      com.google.protobuf.Empty>(this, METHODID_UPDATE_CONNECTION_CREDENTIAL)))
          .addMethod(
              getDeleteConnectionMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                          .DeleteConnectionRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_CONNECTION)))
          .addMethod(
              getGetIamPolicyMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_GET_IAM_POLICY)))
          .addMethod(
              getSetIamPolicyMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_SET_IAM_POLICY)))
          .addMethod(
              getTestIamPermissionsMethod(),
              asyncUnaryCall(
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
   * Manages external data source connections and credentials.
   * </pre>
   */
  public static final class ConnectionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ConnectionServiceStub> {
    private ConnectionServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConnectionServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new connection.
     * </pre>
     */
    public void createConnection(
        com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.CreateConnectionRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns specified connection.
     * </pre>
     */
    public void getConnection(
        com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.GetConnectionRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of connections in the given project.
     * </pre>
     */
    public void listConnections(
        com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.ListConnectionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                    .ListConnectionsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListConnectionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified connection. For security reasons, also resets
     * credential if connection properties are in the update field mask.
     * </pre>
     */
    public void updateConnection(
        com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.UpdateConnectionRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the credential for the specified connection.
     * </pre>
     */
    public void updateConnectionCredential(
        com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                .UpdateConnectionCredentialRequest
            request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateConnectionCredentialMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes connection and associated credential.
     * </pre>
     */
    public void deleteConnection(
        com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.DeleteConnectionRequest
            request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a resource.
     * Returns an empty policy if the resource exists and does not have a policy
     * set.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified resource. Replaces any
     * existing policy.
     * Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified resource.
     * If the resource does not exist, this will return an empty set of
     * permissions, not a NOT_FOUND error.
     * Note: This operation is designed to be used for building permission-aware
     * UIs and command-line tools, not for authorization checking. This operation
     * may "fail open" without warning.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages external data source connections and credentials.
   * </pre>
   */
  public static final class ConnectionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ConnectionServiceBlockingStub> {
    private ConnectionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConnectionServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new connection.
     * </pre>
     */
    public com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection createConnection(
        com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.CreateConnectionRequest
            request) {
      return blockingUnaryCall(
          getChannel(), getCreateConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns specified connection.
     * </pre>
     */
    public com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection getConnection(
        com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.GetConnectionRequest request) {
      return blockingUnaryCall(getChannel(), getGetConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of connections in the given project.
     * </pre>
     */
    public com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.ListConnectionsResponse
        listConnections(
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.ListConnectionsRequest
                request) {
      return blockingUnaryCall(getChannel(), getListConnectionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified connection. For security reasons, also resets
     * credential if connection properties are in the update field mask.
     * </pre>
     */
    public com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection updateConnection(
        com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.UpdateConnectionRequest
            request) {
      return blockingUnaryCall(
          getChannel(), getUpdateConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the credential for the specified connection.
     * </pre>
     */
    public com.google.protobuf.Empty updateConnectionCredential(
        com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                .UpdateConnectionCredentialRequest
            request) {
      return blockingUnaryCall(
          getChannel(), getUpdateConnectionCredentialMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes connection and associated credential.
     * </pre>
     */
    public com.google.protobuf.Empty deleteConnection(
        com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.DeleteConnectionRequest
            request) {
      return blockingUnaryCall(
          getChannel(), getDeleteConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a resource.
     * Returns an empty policy if the resource exists and does not have a policy
     * set.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return blockingUnaryCall(getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified resource. Replaces any
     * existing policy.
     * Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return blockingUnaryCall(getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified resource.
     * If the resource does not exist, this will return an empty set of
     * permissions, not a NOT_FOUND error.
     * Note: This operation is designed to be used for building permission-aware
     * UIs and command-line tools, not for authorization checking. This operation
     * may "fail open" without warning.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages external data source connections and credentials.
   * </pre>
   */
  public static final class ConnectionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ConnectionServiceFutureStub> {
    private ConnectionServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConnectionServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
        createConnection(
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.CreateConnectionRequest
                request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns specified connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
        getConnection(
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.GetConnectionRequest
                request) {
      return futureUnaryCall(
          getChannel().newCall(getGetConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of connections in the given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.ListConnectionsResponse>
        listConnections(
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.ListConnectionsRequest
                request) {
      return futureUnaryCall(
          getChannel().newCall(getListConnectionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified connection. For security reasons, also resets
     * credential if connection properties are in the update field mask.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>
        updateConnection(
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.UpdateConnectionRequest
                request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the credential for the specified connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        updateConnectionCredential(
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                    .UpdateConnectionCredentialRequest
                request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateConnectionCredentialMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes connection and associated credential.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteConnection(
            com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.DeleteConnectionRequest
                request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a resource.
     * Returns an empty policy if the resource exists and does not have a policy
     * set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified resource. Replaces any
     * existing policy.
     * Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified resource.
     * If the resource does not exist, this will return an empty set of
     * permissions, not a NOT_FOUND error.
     * Note: This operation is designed to be used for building permission-aware
     * UIs and command-line tools, not for authorization checking. This operation
     * may "fail open" without warning.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CONNECTION = 0;
  private static final int METHODID_GET_CONNECTION = 1;
  private static final int METHODID_LIST_CONNECTIONS = 2;
  private static final int METHODID_UPDATE_CONNECTION = 3;
  private static final int METHODID_UPDATE_CONNECTION_CREDENTIAL = 4;
  private static final int METHODID_DELETE_CONNECTION = 5;
  private static final int METHODID_GET_IAM_POLICY = 6;
  private static final int METHODID_SET_IAM_POLICY = 7;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 8;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ConnectionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ConnectionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_CONNECTION:
          serviceImpl.createConnection(
              (com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.CreateConnectionRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>)
                  responseObserver);
          break;
        case METHODID_GET_CONNECTION:
          serviceImpl.getConnection(
              (com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.GetConnectionRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>)
                  responseObserver);
          break;
        case METHODID_LIST_CONNECTIONS:
          serviceImpl.listConnections(
              (com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.ListConnectionsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                          .ListConnectionsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CONNECTION:
          serviceImpl.updateConnection(
              (com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.UpdateConnectionRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.Connection>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CONNECTION_CREDENTIAL:
          serviceImpl.updateConnectionCredential(
              (com.google.cloud.bigquery.connection.v1beta1.ConnectionProto
                      .UpdateConnectionCredentialRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_CONNECTION:
          serviceImpl.deleteConnection(
              (com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.DeleteConnectionRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private abstract static class ConnectionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConnectionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.bigquery.connection.v1beta1.ConnectionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConnectionService");
    }
  }

  private static final class ConnectionServiceFileDescriptorSupplier
      extends ConnectionServiceBaseDescriptorSupplier {
    ConnectionServiceFileDescriptorSupplier() {}
  }

  private static final class ConnectionServiceMethodDescriptorSupplier
      extends ConnectionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ConnectionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ConnectionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ConnectionServiceFileDescriptorSupplier())
                      .addMethod(getCreateConnectionMethod())
                      .addMethod(getGetConnectionMethod())
                      .addMethod(getListConnectionsMethod())
                      .addMethod(getUpdateConnectionMethod())
                      .addMethod(getUpdateConnectionCredentialMethod())
                      .addMethod(getDeleteConnectionMethod())
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
