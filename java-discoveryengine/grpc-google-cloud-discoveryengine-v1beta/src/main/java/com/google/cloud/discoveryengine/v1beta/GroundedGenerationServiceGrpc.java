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
package com.google.cloud.discoveryengine.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for grounded generation.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1beta/grounded_generation_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GroundedGenerationServiceGrpc {

  private GroundedGenerationServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1beta.GroundedGenerationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.CheckGroundingRequest,
          com.google.cloud.discoveryengine.v1beta.CheckGroundingResponse>
      getCheckGroundingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckGrounding",
      requestType = com.google.cloud.discoveryengine.v1beta.CheckGroundingRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.CheckGroundingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.CheckGroundingRequest,
          com.google.cloud.discoveryengine.v1beta.CheckGroundingResponse>
      getCheckGroundingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.CheckGroundingRequest,
            com.google.cloud.discoveryengine.v1beta.CheckGroundingResponse>
        getCheckGroundingMethod;
    if ((getCheckGroundingMethod = GroundedGenerationServiceGrpc.getCheckGroundingMethod) == null) {
      synchronized (GroundedGenerationServiceGrpc.class) {
        if ((getCheckGroundingMethod = GroundedGenerationServiceGrpc.getCheckGroundingMethod)
            == null) {
          GroundedGenerationServiceGrpc.getCheckGroundingMethod =
              getCheckGroundingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.CheckGroundingRequest,
                          com.google.cloud.discoveryengine.v1beta.CheckGroundingResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckGrounding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.CheckGroundingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.CheckGroundingResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GroundedGenerationServiceMethodDescriptorSupplier("CheckGrounding"))
                      .build();
        }
      }
    }
    return getCheckGroundingMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static GroundedGenerationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GroundedGenerationServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GroundedGenerationServiceStub>() {
          @java.lang.Override
          public GroundedGenerationServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GroundedGenerationServiceStub(channel, callOptions);
          }
        };
    return GroundedGenerationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GroundedGenerationServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GroundedGenerationServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GroundedGenerationServiceBlockingStub>() {
          @java.lang.Override
          public GroundedGenerationServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GroundedGenerationServiceBlockingStub(channel, callOptions);
          }
        };
    return GroundedGenerationServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static GroundedGenerationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GroundedGenerationServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GroundedGenerationServiceFutureStub>() {
          @java.lang.Override
          public GroundedGenerationServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GroundedGenerationServiceFutureStub(channel, callOptions);
          }
        };
    return GroundedGenerationServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for grounded generation.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Performs a grounding check.
     * </pre>
     */
    default void checkGrounding(
        com.google.cloud.discoveryengine.v1beta.CheckGroundingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.CheckGroundingResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCheckGroundingMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GroundedGenerationService.
   *
   * <pre>
   * Service for grounded generation.
   * </pre>
   */
  public abstract static class GroundedGenerationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return GroundedGenerationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GroundedGenerationService.
   *
   * <pre>
   * Service for grounded generation.
   * </pre>
   */
  public static final class GroundedGenerationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<GroundedGenerationServiceStub> {
    private GroundedGenerationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GroundedGenerationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GroundedGenerationServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Performs a grounding check.
     * </pre>
     */
    public void checkGrounding(
        com.google.cloud.discoveryengine.v1beta.CheckGroundingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.CheckGroundingResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckGroundingMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GroundedGenerationService.
   *
   * <pre>
   * Service for grounded generation.
   * </pre>
   */
  public static final class GroundedGenerationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GroundedGenerationServiceBlockingStub> {
    private GroundedGenerationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GroundedGenerationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GroundedGenerationServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Performs a grounding check.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.CheckGroundingResponse checkGrounding(
        com.google.cloud.discoveryengine.v1beta.CheckGroundingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckGroundingMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * GroundedGenerationService.
   *
   * <pre>
   * Service for grounded generation.
   * </pre>
   */
  public static final class GroundedGenerationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<GroundedGenerationServiceFutureStub> {
    private GroundedGenerationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GroundedGenerationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GroundedGenerationServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Performs a grounding check.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.CheckGroundingResponse>
        checkGrounding(com.google.cloud.discoveryengine.v1beta.CheckGroundingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckGroundingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_GROUNDING = 0;

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
        case METHODID_CHECK_GROUNDING:
          serviceImpl.checkGrounding(
              (com.google.cloud.discoveryengine.v1beta.CheckGroundingRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1beta.CheckGroundingResponse>)
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
            getCheckGroundingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.CheckGroundingRequest,
                    com.google.cloud.discoveryengine.v1beta.CheckGroundingResponse>(
                    service, METHODID_CHECK_GROUNDING)))
        .build();
  }

  private abstract static class GroundedGenerationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GroundedGenerationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1beta.GroundedGenerationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GroundedGenerationService");
    }
  }

  private static final class GroundedGenerationServiceFileDescriptorSupplier
      extends GroundedGenerationServiceBaseDescriptorSupplier {
    GroundedGenerationServiceFileDescriptorSupplier() {}
  }

  private static final class GroundedGenerationServiceMethodDescriptorSupplier
      extends GroundedGenerationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GroundedGenerationServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (GroundedGenerationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new GroundedGenerationServiceFileDescriptorSupplier())
                      .addMethod(getCheckGroundingMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
