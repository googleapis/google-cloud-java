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
package com.google.cloud.discoveryengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing Assistant configuration and assisting users.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1/assistant_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AssistantServiceGrpc {

  private AssistantServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1.AssistantService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.StreamAssistRequest,
          com.google.cloud.discoveryengine.v1.StreamAssistResponse>
      getStreamAssistMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamAssist",
      requestType = com.google.cloud.discoveryengine.v1.StreamAssistRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.StreamAssistResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.StreamAssistRequest,
          com.google.cloud.discoveryengine.v1.StreamAssistResponse>
      getStreamAssistMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.StreamAssistRequest,
            com.google.cloud.discoveryengine.v1.StreamAssistResponse>
        getStreamAssistMethod;
    if ((getStreamAssistMethod = AssistantServiceGrpc.getStreamAssistMethod) == null) {
      synchronized (AssistantServiceGrpc.class) {
        if ((getStreamAssistMethod = AssistantServiceGrpc.getStreamAssistMethod) == null) {
          AssistantServiceGrpc.getStreamAssistMethod =
              getStreamAssistMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.StreamAssistRequest,
                          com.google.cloud.discoveryengine.v1.StreamAssistResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamAssist"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.StreamAssistRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.StreamAssistResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssistantServiceMethodDescriptorSupplier("StreamAssist"))
                      .build();
        }
      }
    }
    return getStreamAssistMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AssistantServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssistantServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AssistantServiceStub>() {
          @java.lang.Override
          public AssistantServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AssistantServiceStub(channel, callOptions);
          }
        };
    return AssistantServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static AssistantServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssistantServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AssistantServiceBlockingV2Stub>() {
          @java.lang.Override
          public AssistantServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AssistantServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return AssistantServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AssistantServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssistantServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AssistantServiceBlockingStub>() {
          @java.lang.Override
          public AssistantServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AssistantServiceBlockingStub(channel, callOptions);
          }
        };
    return AssistantServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AssistantServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssistantServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AssistantServiceFutureStub>() {
          @java.lang.Override
          public AssistantServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AssistantServiceFutureStub(channel, callOptions);
          }
        };
    return AssistantServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing Assistant configuration and assisting users.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Assists the user with a query in a streaming fashion.
     * </pre>
     */
    default void streamAssist(
        com.google.cloud.discoveryengine.v1.StreamAssistRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.StreamAssistResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStreamAssistMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AssistantService.
   *
   * <pre>
   * Service for managing Assistant configuration and assisting users.
   * </pre>
   */
  public abstract static class AssistantServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AssistantServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AssistantService.
   *
   * <pre>
   * Service for managing Assistant configuration and assisting users.
   * </pre>
   */
  public static final class AssistantServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AssistantServiceStub> {
    private AssistantServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssistantServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssistantServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Assists the user with a query in a streaming fashion.
     * </pre>
     */
    public void streamAssist(
        com.google.cloud.discoveryengine.v1.StreamAssistRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.StreamAssistResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamAssistMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AssistantService.
   *
   * <pre>
   * Service for managing Assistant configuration and assisting users.
   * </pre>
   */
  public static final class AssistantServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AssistantServiceBlockingV2Stub> {
    private AssistantServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssistantServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssistantServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Assists the user with a query in a streaming fashion.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<
            ?, com.google.cloud.discoveryengine.v1.StreamAssistResponse>
        streamAssist(com.google.cloud.discoveryengine.v1.StreamAssistRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getStreamAssistMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AssistantService.
   *
   * <pre>
   * Service for managing Assistant configuration and assisting users.
   * </pre>
   */
  public static final class AssistantServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AssistantServiceBlockingStub> {
    private AssistantServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssistantServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssistantServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Assists the user with a query in a streaming fashion.
     * </pre>
     */
    public java.util.Iterator<com.google.cloud.discoveryengine.v1.StreamAssistResponse>
        streamAssist(com.google.cloud.discoveryengine.v1.StreamAssistRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamAssistMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AssistantService.
   *
   * <pre>
   * Service for managing Assistant configuration and assisting users.
   * </pre>
   */
  public static final class AssistantServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AssistantServiceFutureStub> {
    private AssistantServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssistantServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssistantServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_STREAM_ASSIST = 0;

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
        case METHODID_STREAM_ASSIST:
          serviceImpl.streamAssist(
              (com.google.cloud.discoveryengine.v1.StreamAssistRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1.StreamAssistResponse>)
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
            getStreamAssistMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.StreamAssistRequest,
                    com.google.cloud.discoveryengine.v1.StreamAssistResponse>(
                    service, METHODID_STREAM_ASSIST)))
        .build();
  }

  private abstract static class AssistantServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AssistantServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1.AssistantServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AssistantService");
    }
  }

  private static final class AssistantServiceFileDescriptorSupplier
      extends AssistantServiceBaseDescriptorSupplier {
    AssistantServiceFileDescriptorSupplier() {}
  }

  private static final class AssistantServiceMethodDescriptorSupplier
      extends AssistantServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AssistantServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AssistantServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AssistantServiceFileDescriptorSupplier())
                      .addMethod(getStreamAssistMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
