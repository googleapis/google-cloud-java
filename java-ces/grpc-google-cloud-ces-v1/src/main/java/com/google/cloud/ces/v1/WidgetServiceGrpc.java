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
package com.google.cloud.ces.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Provides APIs for widgets to interact with CES APIs.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class WidgetServiceGrpc {

  private WidgetServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.ces.v1.WidgetService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GenerateChatTokenRequest,
          com.google.cloud.ces.v1.GenerateChatTokenResponse>
      getGenerateChatTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateChatToken",
      requestType = com.google.cloud.ces.v1.GenerateChatTokenRequest.class,
      responseType = com.google.cloud.ces.v1.GenerateChatTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.ces.v1.GenerateChatTokenRequest,
          com.google.cloud.ces.v1.GenerateChatTokenResponse>
      getGenerateChatTokenMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.ces.v1.GenerateChatTokenRequest,
            com.google.cloud.ces.v1.GenerateChatTokenResponse>
        getGenerateChatTokenMethod;
    if ((getGenerateChatTokenMethod = WidgetServiceGrpc.getGenerateChatTokenMethod) == null) {
      synchronized (WidgetServiceGrpc.class) {
        if ((getGenerateChatTokenMethod = WidgetServiceGrpc.getGenerateChatTokenMethod) == null) {
          WidgetServiceGrpc.getGenerateChatTokenMethod =
              getGenerateChatTokenMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.ces.v1.GenerateChatTokenRequest,
                          com.google.cloud.ces.v1.GenerateChatTokenResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateChatToken"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.GenerateChatTokenRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.ces.v1.GenerateChatTokenResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WidgetServiceMethodDescriptorSupplier("GenerateChatToken"))
                      .build();
        }
      }
    }
    return getGenerateChatTokenMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static WidgetServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WidgetServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WidgetServiceStub>() {
          @java.lang.Override
          public WidgetServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WidgetServiceStub(channel, callOptions);
          }
        };
    return WidgetServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static WidgetServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WidgetServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WidgetServiceBlockingV2Stub>() {
          @java.lang.Override
          public WidgetServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WidgetServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return WidgetServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WidgetServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WidgetServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WidgetServiceBlockingStub>() {
          @java.lang.Override
          public WidgetServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WidgetServiceBlockingStub(channel, callOptions);
          }
        };
    return WidgetServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static WidgetServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WidgetServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WidgetServiceFutureStub>() {
          @java.lang.Override
          public WidgetServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WidgetServiceFutureStub(channel, callOptions);
          }
        };
    return WidgetServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Provides APIs for widgets to interact with CES APIs.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Generates a session scoped token for chat widget to authenticate with
     * Session APIs.
     * </pre>
     */
    default void generateChatToken(
        com.google.cloud.ces.v1.GenerateChatTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.GenerateChatTokenResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateChatTokenMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WidgetService.
   *
   * <pre>
   * Provides APIs for widgets to interact with CES APIs.
   * </pre>
   */
  public abstract static class WidgetServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return WidgetServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WidgetService.
   *
   * <pre>
   * Provides APIs for widgets to interact with CES APIs.
   * </pre>
   */
  public static final class WidgetServiceStub
      extends io.grpc.stub.AbstractAsyncStub<WidgetServiceStub> {
    private WidgetServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WidgetServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WidgetServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Generates a session scoped token for chat widget to authenticate with
     * Session APIs.
     * </pre>
     */
    public void generateChatToken(
        com.google.cloud.ces.v1.GenerateChatTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.GenerateChatTokenResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateChatTokenMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WidgetService.
   *
   * <pre>
   * Provides APIs for widgets to interact with CES APIs.
   * </pre>
   */
  public static final class WidgetServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<WidgetServiceBlockingV2Stub> {
    private WidgetServiceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WidgetServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WidgetServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Generates a session scoped token for chat widget to authenticate with
     * Session APIs.
     * </pre>
     */
    public com.google.cloud.ces.v1.GenerateChatTokenResponse generateChatToken(
        com.google.cloud.ces.v1.GenerateChatTokenRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGenerateChatTokenMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service WidgetService.
   *
   * <pre>
   * Provides APIs for widgets to interact with CES APIs.
   * </pre>
   */
  public static final class WidgetServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WidgetServiceBlockingStub> {
    private WidgetServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WidgetServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WidgetServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Generates a session scoped token for chat widget to authenticate with
     * Session APIs.
     * </pre>
     */
    public com.google.cloud.ces.v1.GenerateChatTokenResponse generateChatToken(
        com.google.cloud.ces.v1.GenerateChatTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateChatTokenMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WidgetService.
   *
   * <pre>
   * Provides APIs for widgets to interact with CES APIs.
   * </pre>
   */
  public static final class WidgetServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<WidgetServiceFutureStub> {
    private WidgetServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WidgetServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WidgetServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Generates a session scoped token for chat widget to authenticate with
     * Session APIs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.ces.v1.GenerateChatTokenResponse>
        generateChatToken(com.google.cloud.ces.v1.GenerateChatTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateChatTokenMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_CHAT_TOKEN = 0;

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
        case METHODID_GENERATE_CHAT_TOKEN:
          serviceImpl.generateChatToken(
              (com.google.cloud.ces.v1.GenerateChatTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.ces.v1.GenerateChatTokenResponse>)
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
            getGenerateChatTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.ces.v1.GenerateChatTokenRequest,
                    com.google.cloud.ces.v1.GenerateChatTokenResponse>(
                    service, METHODID_GENERATE_CHAT_TOKEN)))
        .build();
  }

  private abstract static class WidgetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WidgetServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.ces.v1.WidgetServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WidgetService");
    }
  }

  private static final class WidgetServiceFileDescriptorSupplier
      extends WidgetServiceBaseDescriptorSupplier {
    WidgetServiceFileDescriptorSupplier() {}
  }

  private static final class WidgetServiceMethodDescriptorSupplier
      extends WidgetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WidgetServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (WidgetServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new WidgetServiceFileDescriptorSupplier())
                      .addMethod(getGenerateChatTokenMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
