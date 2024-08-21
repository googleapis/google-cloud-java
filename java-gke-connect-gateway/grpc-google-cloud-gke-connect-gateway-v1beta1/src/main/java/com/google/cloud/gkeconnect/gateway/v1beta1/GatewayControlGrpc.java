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
package com.google.cloud.gkeconnect.gateway.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * GatewayControl is the control plane API for Connect Gateway.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/gkeconnect/gateway/v1beta1/control.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GatewayControlGrpc {

  private GatewayControlGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.gkeconnect.gateway.v1beta1.GatewayControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsRequest,
          com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsResponse>
      getGenerateCredentialsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateCredentials",
      requestType = com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsRequest.class,
      responseType = com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsRequest,
          com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsResponse>
      getGenerateCredentialsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsRequest,
            com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsResponse>
        getGenerateCredentialsMethod;
    if ((getGenerateCredentialsMethod = GatewayControlGrpc.getGenerateCredentialsMethod) == null) {
      synchronized (GatewayControlGrpc.class) {
        if ((getGenerateCredentialsMethod = GatewayControlGrpc.getGenerateCredentialsMethod)
            == null) {
          GatewayControlGrpc.getGenerateCredentialsMethod =
              getGenerateCredentialsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsRequest,
                          com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateCredentials"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkeconnect.gateway.v1beta1
                                  .GenerateCredentialsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GatewayControlMethodDescriptorSupplier("GenerateCredentials"))
                      .build();
        }
      }
    }
    return getGenerateCredentialsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static GatewayControlStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GatewayControlStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GatewayControlStub>() {
          @java.lang.Override
          public GatewayControlStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GatewayControlStub(channel, callOptions);
          }
        };
    return GatewayControlStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GatewayControlBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GatewayControlBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GatewayControlBlockingStub>() {
          @java.lang.Override
          public GatewayControlBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GatewayControlBlockingStub(channel, callOptions);
          }
        };
    return GatewayControlBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static GatewayControlFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GatewayControlFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GatewayControlFutureStub>() {
          @java.lang.Override
          public GatewayControlFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GatewayControlFutureStub(channel, callOptions);
          }
        };
    return GatewayControlFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * GatewayControl is the control plane API for Connect Gateway.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * GenerateCredentials provides connection information that allows a user to
     * access the specified membership using Connect Gateway.
     * </pre>
     */
    default void generateCredentials(
        com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateCredentialsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GatewayControl.
   *
   * <pre>
   * GatewayControl is the control plane API for Connect Gateway.
   * </pre>
   */
  public abstract static class GatewayControlImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return GatewayControlGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GatewayControl.
   *
   * <pre>
   * GatewayControl is the control plane API for Connect Gateway.
   * </pre>
   */
  public static final class GatewayControlStub
      extends io.grpc.stub.AbstractAsyncStub<GatewayControlStub> {
    private GatewayControlStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GatewayControlStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GatewayControlStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * GenerateCredentials provides connection information that allows a user to
     * access the specified membership using Connect Gateway.
     * </pre>
     */
    public void generateCredentials(
        com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateCredentialsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GatewayControl.
   *
   * <pre>
   * GatewayControl is the control plane API for Connect Gateway.
   * </pre>
   */
  public static final class GatewayControlBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GatewayControlBlockingStub> {
    private GatewayControlBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GatewayControlBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GatewayControlBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * GenerateCredentials provides connection information that allows a user to
     * access the specified membership using Connect Gateway.
     * </pre>
     */
    public com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsResponse
        generateCredentials(
            com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateCredentialsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GatewayControl.
   *
   * <pre>
   * GatewayControl is the control plane API for Connect Gateway.
   * </pre>
   */
  public static final class GatewayControlFutureStub
      extends io.grpc.stub.AbstractFutureStub<GatewayControlFutureStub> {
    private GatewayControlFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GatewayControlFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GatewayControlFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * GenerateCredentials provides connection information that allows a user to
     * access the specified membership using Connect Gateway.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsResponse>
        generateCredentials(
            com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateCredentialsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_CREDENTIALS = 0;

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
        case METHODID_GENERATE_CREDENTIALS:
          serviceImpl.generateCredentials(
              (com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsResponse>)
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
            getGenerateCredentialsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsRequest,
                    com.google.cloud.gkeconnect.gateway.v1beta1.GenerateCredentialsResponse>(
                    service, METHODID_GENERATE_CREDENTIALS)))
        .build();
  }

  private abstract static class GatewayControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GatewayControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gkeconnect.gateway.v1beta1.ControlProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GatewayControl");
    }
  }

  private static final class GatewayControlFileDescriptorSupplier
      extends GatewayControlBaseDescriptorSupplier {
    GatewayControlFileDescriptorSupplier() {}
  }

  private static final class GatewayControlMethodDescriptorSupplier
      extends GatewayControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GatewayControlMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (GatewayControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new GatewayControlFileDescriptorSupplier())
                      .addMethod(getGenerateCredentialsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
