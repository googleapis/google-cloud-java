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
package com.google.cloud.apigeeconnect.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service Interface for the Apigee Connect connection management APIs.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/apigeeconnect/v1/connection.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConnectionServiceGrpc {

  private ConnectionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.apigeeconnect.v1.ConnectionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apigeeconnect.v1.ListConnectionsRequest,
          com.google.cloud.apigeeconnect.v1.ListConnectionsResponse>
      getListConnectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConnections",
      requestType = com.google.cloud.apigeeconnect.v1.ListConnectionsRequest.class,
      responseType = com.google.cloud.apigeeconnect.v1.ListConnectionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apigeeconnect.v1.ListConnectionsRequest,
          com.google.cloud.apigeeconnect.v1.ListConnectionsResponse>
      getListConnectionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apigeeconnect.v1.ListConnectionsRequest,
            com.google.cloud.apigeeconnect.v1.ListConnectionsResponse>
        getListConnectionsMethod;
    if ((getListConnectionsMethod = ConnectionServiceGrpc.getListConnectionsMethod) == null) {
      synchronized (ConnectionServiceGrpc.class) {
        if ((getListConnectionsMethod = ConnectionServiceGrpc.getListConnectionsMethod) == null) {
          ConnectionServiceGrpc.getListConnectionsMethod =
              getListConnectionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apigeeconnect.v1.ListConnectionsRequest,
                          com.google.cloud.apigeeconnect.v1.ListConnectionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConnections"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeconnect.v1.ListConnectionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apigeeconnect.v1.ListConnectionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConnectionServiceMethodDescriptorSupplier("ListConnections"))
                      .build();
        }
      }
    }
    return getListConnectionsMethod;
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
   * Service Interface for the Apigee Connect connection management APIs.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists connections that are currently active for the given Apigee Connect
     * endpoint.
     * </pre>
     */
    default void listConnections(
        com.google.cloud.apigeeconnect.v1.ListConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeconnect.v1.ListConnectionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConnectionsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ConnectionService.
   *
   * <pre>
   * Service Interface for the Apigee Connect connection management APIs.
   * </pre>
   */
  public abstract static class ConnectionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ConnectionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ConnectionService.
   *
   * <pre>
   * Service Interface for the Apigee Connect connection management APIs.
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
     * Lists connections that are currently active for the given Apigee Connect
     * endpoint.
     * </pre>
     */
    public void listConnections(
        com.google.cloud.apigeeconnect.v1.ListConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigeeconnect.v1.ListConnectionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConnectionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ConnectionService.
   *
   * <pre>
   * Service Interface for the Apigee Connect connection management APIs.
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
     * Lists connections that are currently active for the given Apigee Connect
     * endpoint.
     * </pre>
     */
    public com.google.cloud.apigeeconnect.v1.ListConnectionsResponse listConnections(
        com.google.cloud.apigeeconnect.v1.ListConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConnectionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ConnectionService.
   *
   * <pre>
   * Service Interface for the Apigee Connect connection management APIs.
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
     * Lists connections that are currently active for the given Apigee Connect
     * endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apigeeconnect.v1.ListConnectionsResponse>
        listConnections(com.google.cloud.apigeeconnect.v1.ListConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConnectionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CONNECTIONS = 0;

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
              (com.google.cloud.apigeeconnect.v1.ListConnectionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.apigeeconnect.v1.ListConnectionsResponse>)
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
                    com.google.cloud.apigeeconnect.v1.ListConnectionsRequest,
                    com.google.cloud.apigeeconnect.v1.ListConnectionsResponse>(
                    service, METHODID_LIST_CONNECTIONS)))
        .build();
  }

  private abstract static class ConnectionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConnectionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.apigeeconnect.v1.ConnectionProto.getDescriptor();
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
    private final java.lang.String methodName;

    ConnectionServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
                      .addMethod(getListConnectionsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
