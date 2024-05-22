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
package com.google.cloud.visionai.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * HealthCheckService provides an interface for Vertex AI Vision Cluster Health
 * Check.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/visionai/v1/health_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HealthCheckServiceGrpc {

  private HealthCheckServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.visionai.v1.HealthCheckService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.HealthCheckRequest,
          com.google.cloud.visionai.v1.HealthCheckResponse>
      getHealthCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HealthCheck",
      requestType = com.google.cloud.visionai.v1.HealthCheckRequest.class,
      responseType = com.google.cloud.visionai.v1.HealthCheckResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.HealthCheckRequest,
          com.google.cloud.visionai.v1.HealthCheckResponse>
      getHealthCheckMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.HealthCheckRequest,
            com.google.cloud.visionai.v1.HealthCheckResponse>
        getHealthCheckMethod;
    if ((getHealthCheckMethod = HealthCheckServiceGrpc.getHealthCheckMethod) == null) {
      synchronized (HealthCheckServiceGrpc.class) {
        if ((getHealthCheckMethod = HealthCheckServiceGrpc.getHealthCheckMethod) == null) {
          HealthCheckServiceGrpc.getHealthCheckMethod =
              getHealthCheckMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.HealthCheckRequest,
                          com.google.cloud.visionai.v1.HealthCheckResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HealthCheck"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.HealthCheckRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.HealthCheckResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HealthCheckServiceMethodDescriptorSupplier("HealthCheck"))
                      .build();
        }
      }
    }
    return getHealthCheckMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static HealthCheckServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HealthCheckServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HealthCheckServiceStub>() {
          @java.lang.Override
          public HealthCheckServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HealthCheckServiceStub(channel, callOptions);
          }
        };
    return HealthCheckServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HealthCheckServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HealthCheckServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HealthCheckServiceBlockingStub>() {
          @java.lang.Override
          public HealthCheckServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HealthCheckServiceBlockingStub(channel, callOptions);
          }
        };
    return HealthCheckServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static HealthCheckServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HealthCheckServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HealthCheckServiceFutureStub>() {
          @java.lang.Override
          public HealthCheckServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HealthCheckServiceFutureStub(channel, callOptions);
          }
        };
    return HealthCheckServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * HealthCheckService provides an interface for Vertex AI Vision Cluster Health
   * Check.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * HealthCheck method checks the health status of the cluster.
     * </pre>
     */
    default void healthCheck(
        com.google.cloud.visionai.v1.HealthCheckRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.HealthCheckResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getHealthCheckMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service HealthCheckService.
   *
   * <pre>
   * HealthCheckService provides an interface for Vertex AI Vision Cluster Health
   * Check.
   * </pre>
   */
  public abstract static class HealthCheckServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return HealthCheckServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service HealthCheckService.
   *
   * <pre>
   * HealthCheckService provides an interface for Vertex AI Vision Cluster Health
   * Check.
   * </pre>
   */
  public static final class HealthCheckServiceStub
      extends io.grpc.stub.AbstractAsyncStub<HealthCheckServiceStub> {
    private HealthCheckServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthCheckServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HealthCheckServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * HealthCheck method checks the health status of the cluster.
     * </pre>
     */
    public void healthCheck(
        com.google.cloud.visionai.v1.HealthCheckRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.HealthCheckResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHealthCheckMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service HealthCheckService.
   *
   * <pre>
   * HealthCheckService provides an interface for Vertex AI Vision Cluster Health
   * Check.
   * </pre>
   */
  public static final class HealthCheckServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<HealthCheckServiceBlockingStub> {
    private HealthCheckServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthCheckServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HealthCheckServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * HealthCheck method checks the health status of the cluster.
     * </pre>
     */
    public com.google.cloud.visionai.v1.HealthCheckResponse healthCheck(
        com.google.cloud.visionai.v1.HealthCheckRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHealthCheckMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service HealthCheckService.
   *
   * <pre>
   * HealthCheckService provides an interface for Vertex AI Vision Cluster Health
   * Check.
   * </pre>
   */
  public static final class HealthCheckServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<HealthCheckServiceFutureStub> {
    private HealthCheckServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthCheckServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HealthCheckServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * HealthCheck method checks the health status of the cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.HealthCheckResponse>
        healthCheck(com.google.cloud.visionai.v1.HealthCheckRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHealthCheckMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HEALTH_CHECK = 0;

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
        case METHODID_HEALTH_CHECK:
          serviceImpl.healthCheck(
              (com.google.cloud.visionai.v1.HealthCheckRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.HealthCheckResponse>)
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
            getHealthCheckMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.HealthCheckRequest,
                    com.google.cloud.visionai.v1.HealthCheckResponse>(
                    service, METHODID_HEALTH_CHECK)))
        .build();
  }

  private abstract static class HealthCheckServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HealthCheckServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.visionai.v1.HealthCheckServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HealthCheckService");
    }
  }

  private static final class HealthCheckServiceFileDescriptorSupplier
      extends HealthCheckServiceBaseDescriptorSupplier {
    HealthCheckServiceFileDescriptorSupplier() {}
  }

  private static final class HealthCheckServiceMethodDescriptorSupplier
      extends HealthCheckServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    HealthCheckServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (HealthCheckServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new HealthCheckServiceFileDescriptorSupplier())
                      .addMethod(getHealthCheckMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
