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
package com.google.cloud.apihub.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * This service is used for managing plugins inside the API Hub.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/apihub/v1/plugin_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ApiHubPluginGrpc {

  private ApiHubPluginGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.apihub.v1.ApiHubPlugin";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetPluginRequest, com.google.cloud.apihub.v1.Plugin>
      getGetPluginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPlugin",
      requestType = com.google.cloud.apihub.v1.GetPluginRequest.class,
      responseType = com.google.cloud.apihub.v1.Plugin.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetPluginRequest, com.google.cloud.apihub.v1.Plugin>
      getGetPluginMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.GetPluginRequest, com.google.cloud.apihub.v1.Plugin>
        getGetPluginMethod;
    if ((getGetPluginMethod = ApiHubPluginGrpc.getGetPluginMethod) == null) {
      synchronized (ApiHubPluginGrpc.class) {
        if ((getGetPluginMethod = ApiHubPluginGrpc.getGetPluginMethod) == null) {
          ApiHubPluginGrpc.getGetPluginMethod =
              getGetPluginMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.GetPluginRequest,
                          com.google.cloud.apihub.v1.Plugin>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPlugin"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.GetPluginRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Plugin.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubPluginMethodDescriptorSupplier("GetPlugin"))
                      .build();
        }
      }
    }
    return getGetPluginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.EnablePluginRequest, com.google.cloud.apihub.v1.Plugin>
      getEnablePluginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnablePlugin",
      requestType = com.google.cloud.apihub.v1.EnablePluginRequest.class,
      responseType = com.google.cloud.apihub.v1.Plugin.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.EnablePluginRequest, com.google.cloud.apihub.v1.Plugin>
      getEnablePluginMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.EnablePluginRequest, com.google.cloud.apihub.v1.Plugin>
        getEnablePluginMethod;
    if ((getEnablePluginMethod = ApiHubPluginGrpc.getEnablePluginMethod) == null) {
      synchronized (ApiHubPluginGrpc.class) {
        if ((getEnablePluginMethod = ApiHubPluginGrpc.getEnablePluginMethod) == null) {
          ApiHubPluginGrpc.getEnablePluginMethod =
              getEnablePluginMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.EnablePluginRequest,
                          com.google.cloud.apihub.v1.Plugin>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EnablePlugin"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.EnablePluginRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Plugin.getDefaultInstance()))
                      .setSchemaDescriptor(new ApiHubPluginMethodDescriptorSupplier("EnablePlugin"))
                      .build();
        }
      }
    }
    return getEnablePluginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.DisablePluginRequest, com.google.cloud.apihub.v1.Plugin>
      getDisablePluginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisablePlugin",
      requestType = com.google.cloud.apihub.v1.DisablePluginRequest.class,
      responseType = com.google.cloud.apihub.v1.Plugin.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.DisablePluginRequest, com.google.cloud.apihub.v1.Plugin>
      getDisablePluginMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.DisablePluginRequest, com.google.cloud.apihub.v1.Plugin>
        getDisablePluginMethod;
    if ((getDisablePluginMethod = ApiHubPluginGrpc.getDisablePluginMethod) == null) {
      synchronized (ApiHubPluginGrpc.class) {
        if ((getDisablePluginMethod = ApiHubPluginGrpc.getDisablePluginMethod) == null) {
          ApiHubPluginGrpc.getDisablePluginMethod =
              getDisablePluginMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.DisablePluginRequest,
                          com.google.cloud.apihub.v1.Plugin>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DisablePlugin"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.DisablePluginRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Plugin.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ApiHubPluginMethodDescriptorSupplier("DisablePlugin"))
                      .build();
        }
      }
    }
    return getDisablePluginMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ApiHubPluginStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApiHubPluginStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ApiHubPluginStub>() {
          @java.lang.Override
          public ApiHubPluginStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ApiHubPluginStub(channel, callOptions);
          }
        };
    return ApiHubPluginStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ApiHubPluginBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApiHubPluginBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ApiHubPluginBlockingStub>() {
          @java.lang.Override
          public ApiHubPluginBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ApiHubPluginBlockingStub(channel, callOptions);
          }
        };
    return ApiHubPluginBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ApiHubPluginFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApiHubPluginFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ApiHubPluginFutureStub>() {
          @java.lang.Override
          public ApiHubPluginFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ApiHubPluginFutureStub(channel, callOptions);
          }
        };
    return ApiHubPluginFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * This service is used for managing plugins inside the API Hub.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Get details about an API Hub plugin.
     * </pre>
     */
    default void getPlugin(
        com.google.cloud.apihub.v1.GetPluginRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Plugin> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPluginMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enables a plugin.
     * The `state` of the plugin after enabling is `ENABLED`
     * </pre>
     */
    default void enablePlugin(
        com.google.cloud.apihub.v1.EnablePluginRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Plugin> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getEnablePluginMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disables a plugin.
     * The `state` of the plugin after disabling is `DISABLED`
     * </pre>
     */
    default void disablePlugin(
        com.google.cloud.apihub.v1.DisablePluginRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Plugin> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDisablePluginMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ApiHubPlugin.
   *
   * <pre>
   * This service is used for managing plugins inside the API Hub.
   * </pre>
   */
  public abstract static class ApiHubPluginImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ApiHubPluginGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ApiHubPlugin.
   *
   * <pre>
   * This service is used for managing plugins inside the API Hub.
   * </pre>
   */
  public static final class ApiHubPluginStub
      extends io.grpc.stub.AbstractAsyncStub<ApiHubPluginStub> {
    private ApiHubPluginStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApiHubPluginStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApiHubPluginStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get details about an API Hub plugin.
     * </pre>
     */
    public void getPlugin(
        com.google.cloud.apihub.v1.GetPluginRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Plugin> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPluginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enables a plugin.
     * The `state` of the plugin after enabling is `ENABLED`
     * </pre>
     */
    public void enablePlugin(
        com.google.cloud.apihub.v1.EnablePluginRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Plugin> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnablePluginMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disables a plugin.
     * The `state` of the plugin after disabling is `DISABLED`
     * </pre>
     */
    public void disablePlugin(
        com.google.cloud.apihub.v1.DisablePluginRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Plugin> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisablePluginMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ApiHubPlugin.
   *
   * <pre>
   * This service is used for managing plugins inside the API Hub.
   * </pre>
   */
  public static final class ApiHubPluginBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ApiHubPluginBlockingStub> {
    private ApiHubPluginBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApiHubPluginBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApiHubPluginBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get details about an API Hub plugin.
     * </pre>
     */
    public com.google.cloud.apihub.v1.Plugin getPlugin(
        com.google.cloud.apihub.v1.GetPluginRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPluginMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Enables a plugin.
     * The `state` of the plugin after enabling is `ENABLED`
     * </pre>
     */
    public com.google.cloud.apihub.v1.Plugin enablePlugin(
        com.google.cloud.apihub.v1.EnablePluginRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnablePluginMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Disables a plugin.
     * The `state` of the plugin after disabling is `DISABLED`
     * </pre>
     */
    public com.google.cloud.apihub.v1.Plugin disablePlugin(
        com.google.cloud.apihub.v1.DisablePluginRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisablePluginMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ApiHubPlugin.
   *
   * <pre>
   * This service is used for managing plugins inside the API Hub.
   * </pre>
   */
  public static final class ApiHubPluginFutureStub
      extends io.grpc.stub.AbstractFutureStub<ApiHubPluginFutureStub> {
    private ApiHubPluginFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApiHubPluginFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApiHubPluginFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get details about an API Hub plugin.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Plugin>
        getPlugin(com.google.cloud.apihub.v1.GetPluginRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPluginMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Enables a plugin.
     * The `state` of the plugin after enabling is `ENABLED`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Plugin>
        enablePlugin(com.google.cloud.apihub.v1.EnablePluginRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnablePluginMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Disables a plugin.
     * The `state` of the plugin after disabling is `DISABLED`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Plugin>
        disablePlugin(com.google.cloud.apihub.v1.DisablePluginRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisablePluginMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PLUGIN = 0;
  private static final int METHODID_ENABLE_PLUGIN = 1;
  private static final int METHODID_DISABLE_PLUGIN = 2;

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
        case METHODID_GET_PLUGIN:
          serviceImpl.getPlugin(
              (com.google.cloud.apihub.v1.GetPluginRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Plugin>) responseObserver);
          break;
        case METHODID_ENABLE_PLUGIN:
          serviceImpl.enablePlugin(
              (com.google.cloud.apihub.v1.EnablePluginRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Plugin>) responseObserver);
          break;
        case METHODID_DISABLE_PLUGIN:
          serviceImpl.disablePlugin(
              (com.google.cloud.apihub.v1.DisablePluginRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Plugin>) responseObserver);
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
            getGetPluginMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.GetPluginRequest, com.google.cloud.apihub.v1.Plugin>(
                    service, METHODID_GET_PLUGIN)))
        .addMethod(
            getEnablePluginMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.EnablePluginRequest,
                    com.google.cloud.apihub.v1.Plugin>(service, METHODID_ENABLE_PLUGIN)))
        .addMethod(
            getDisablePluginMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.DisablePluginRequest,
                    com.google.cloud.apihub.v1.Plugin>(service, METHODID_DISABLE_PLUGIN)))
        .build();
  }

  private abstract static class ApiHubPluginBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ApiHubPluginBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.apihub.v1.PluginServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ApiHubPlugin");
    }
  }

  private static final class ApiHubPluginFileDescriptorSupplier
      extends ApiHubPluginBaseDescriptorSupplier {
    ApiHubPluginFileDescriptorSupplier() {}
  }

  private static final class ApiHubPluginMethodDescriptorSupplier
      extends ApiHubPluginBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ApiHubPluginMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ApiHubPluginGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ApiHubPluginFileDescriptorSupplier())
                      .addMethod(getGetPluginMethod())
                      .addMethod(getEnablePluginMethod())
                      .addMethod(getDisablePluginMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
