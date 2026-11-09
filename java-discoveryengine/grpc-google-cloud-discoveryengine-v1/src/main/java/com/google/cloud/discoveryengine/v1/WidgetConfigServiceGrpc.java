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
package com.google.cloud.discoveryengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing
 * [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig] configuration.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class WidgetConfigServiceGrpc {

  private WidgetConfigServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1.WidgetConfigService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.GetWidgetConfigRequest,
          com.google.cloud.discoveryengine.v1.WidgetConfig>
      getGetWidgetConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWidgetConfig",
      requestType = com.google.cloud.discoveryengine.v1.GetWidgetConfigRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.WidgetConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.GetWidgetConfigRequest,
          com.google.cloud.discoveryengine.v1.WidgetConfig>
      getGetWidgetConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.GetWidgetConfigRequest,
            com.google.cloud.discoveryengine.v1.WidgetConfig>
        getGetWidgetConfigMethod;
    if ((getGetWidgetConfigMethod = WidgetConfigServiceGrpc.getGetWidgetConfigMethod) == null) {
      synchronized (WidgetConfigServiceGrpc.class) {
        if ((getGetWidgetConfigMethod = WidgetConfigServiceGrpc.getGetWidgetConfigMethod) == null) {
          WidgetConfigServiceGrpc.getGetWidgetConfigMethod =
              getGetWidgetConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.GetWidgetConfigRequest,
                          com.google.cloud.discoveryengine.v1.WidgetConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWidgetConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.GetWidgetConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.WidgetConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WidgetConfigServiceMethodDescriptorSupplier("GetWidgetConfig"))
                      .build();
        }
      }
    }
    return getGetWidgetConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.UpdateWidgetConfigRequest,
          com.google.cloud.discoveryengine.v1.WidgetConfig>
      getUpdateWidgetConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateWidgetConfig",
      requestType = com.google.cloud.discoveryengine.v1.UpdateWidgetConfigRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.WidgetConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.UpdateWidgetConfigRequest,
          com.google.cloud.discoveryengine.v1.WidgetConfig>
      getUpdateWidgetConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.UpdateWidgetConfigRequest,
            com.google.cloud.discoveryengine.v1.WidgetConfig>
        getUpdateWidgetConfigMethod;
    if ((getUpdateWidgetConfigMethod = WidgetConfigServiceGrpc.getUpdateWidgetConfigMethod)
        == null) {
      synchronized (WidgetConfigServiceGrpc.class) {
        if ((getUpdateWidgetConfigMethod = WidgetConfigServiceGrpc.getUpdateWidgetConfigMethod)
            == null) {
          WidgetConfigServiceGrpc.getUpdateWidgetConfigMethod =
              getUpdateWidgetConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.UpdateWidgetConfigRequest,
                          com.google.cloud.discoveryengine.v1.WidgetConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateWidgetConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.UpdateWidgetConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.WidgetConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WidgetConfigServiceMethodDescriptorSupplier("UpdateWidgetConfig"))
                      .build();
        }
      }
    }
    return getUpdateWidgetConfigMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static WidgetConfigServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WidgetConfigServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WidgetConfigServiceStub>() {
          @java.lang.Override
          public WidgetConfigServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WidgetConfigServiceStub(channel, callOptions);
          }
        };
    return WidgetConfigServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static WidgetConfigServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WidgetConfigServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WidgetConfigServiceBlockingV2Stub>() {
          @java.lang.Override
          public WidgetConfigServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WidgetConfigServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return WidgetConfigServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WidgetConfigServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WidgetConfigServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WidgetConfigServiceBlockingStub>() {
          @java.lang.Override
          public WidgetConfigServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WidgetConfigServiceBlockingStub(channel, callOptions);
          }
        };
    return WidgetConfigServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static WidgetConfigServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WidgetConfigServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WidgetConfigServiceFutureStub>() {
          @java.lang.Override
          public WidgetConfigServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WidgetConfigServiceFutureStub(channel, callOptions);
          }
        };
    return WidgetConfigServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing
   * [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig] configuration.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets a [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig].
     * </pre>
     */
    default void getWidgetConfig(
        com.google.cloud.discoveryengine.v1.GetWidgetConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.WidgetConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetWidgetConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a WidgetConfig.
     * </pre>
     */
    default void updateWidgetConfig(
        com.google.cloud.discoveryengine.v1.UpdateWidgetConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.WidgetConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateWidgetConfigMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WidgetConfigService.
   *
   * <pre>
   * Service for managing
   * [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig] configuration.
   * </pre>
   */
  public abstract static class WidgetConfigServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return WidgetConfigServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WidgetConfigService.
   *
   * <pre>
   * Service for managing
   * [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig] configuration.
   * </pre>
   */
  public static final class WidgetConfigServiceStub
      extends io.grpc.stub.AbstractAsyncStub<WidgetConfigServiceStub> {
    private WidgetConfigServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WidgetConfigServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WidgetConfigServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig].
     * </pre>
     */
    public void getWidgetConfig(
        com.google.cloud.discoveryengine.v1.GetWidgetConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.WidgetConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWidgetConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a WidgetConfig.
     * </pre>
     */
    public void updateWidgetConfig(
        com.google.cloud.discoveryengine.v1.UpdateWidgetConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.WidgetConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateWidgetConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WidgetConfigService.
   *
   * <pre>
   * Service for managing
   * [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig] configuration.
   * </pre>
   */
  public static final class WidgetConfigServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<WidgetConfigServiceBlockingV2Stub> {
    private WidgetConfigServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WidgetConfigServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WidgetConfigServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.WidgetConfig getWidgetConfig(
        com.google.cloud.discoveryengine.v1.GetWidgetConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetWidgetConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a WidgetConfig.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.WidgetConfig updateWidgetConfig(
        com.google.cloud.discoveryengine.v1.UpdateWidgetConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateWidgetConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service WidgetConfigService.
   *
   * <pre>
   * Service for managing
   * [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig] configuration.
   * </pre>
   */
  public static final class WidgetConfigServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WidgetConfigServiceBlockingStub> {
    private WidgetConfigServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WidgetConfigServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WidgetConfigServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.WidgetConfig getWidgetConfig(
        com.google.cloud.discoveryengine.v1.GetWidgetConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWidgetConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a WidgetConfig.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.WidgetConfig updateWidgetConfig(
        com.google.cloud.discoveryengine.v1.UpdateWidgetConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateWidgetConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WidgetConfigService.
   *
   * <pre>
   * Service for managing
   * [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig] configuration.
   * </pre>
   */
  public static final class WidgetConfigServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<WidgetConfigServiceFutureStub> {
    private WidgetConfigServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WidgetConfigServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WidgetConfigServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1.WidgetConfig>
        getWidgetConfig(com.google.cloud.discoveryengine.v1.GetWidgetConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWidgetConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a WidgetConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1.WidgetConfig>
        updateWidgetConfig(com.google.cloud.discoveryengine.v1.UpdateWidgetConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateWidgetConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_WIDGET_CONFIG = 0;
  private static final int METHODID_UPDATE_WIDGET_CONFIG = 1;

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
        case METHODID_GET_WIDGET_CONFIG:
          serviceImpl.getWidgetConfig(
              (com.google.cloud.discoveryengine.v1.GetWidgetConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.WidgetConfig>)
                  responseObserver);
          break;
        case METHODID_UPDATE_WIDGET_CONFIG:
          serviceImpl.updateWidgetConfig(
              (com.google.cloud.discoveryengine.v1.UpdateWidgetConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.WidgetConfig>)
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
            getGetWidgetConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.GetWidgetConfigRequest,
                    com.google.cloud.discoveryengine.v1.WidgetConfig>(
                    service, METHODID_GET_WIDGET_CONFIG)))
        .addMethod(
            getUpdateWidgetConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.UpdateWidgetConfigRequest,
                    com.google.cloud.discoveryengine.v1.WidgetConfig>(
                    service, METHODID_UPDATE_WIDGET_CONFIG)))
        .build();
  }

  private abstract static class WidgetConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WidgetConfigServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1.WidgetConfigServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WidgetConfigService");
    }
  }

  private static final class WidgetConfigServiceFileDescriptorSupplier
      extends WidgetConfigServiceBaseDescriptorSupplier {
    WidgetConfigServiceFileDescriptorSupplier() {}
  }

  private static final class WidgetConfigServiceMethodDescriptorSupplier
      extends WidgetConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WidgetConfigServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (WidgetConfigServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new WidgetConfigServiceFileDescriptorSupplier())
                      .addMethod(getGetWidgetConfigMethod())
                      .addMethod(getUpdateWidgetConfigMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
