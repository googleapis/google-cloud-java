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
package com.google.cloud.datacatalog.lineage.configmanagement.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Lineage Config Management service. Config Management service is used to
 * manage the configuration for Data Lineage. These Configs define different
 * configuration options for Lineage customers to control behaviour of lineage
 * systems.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class ConfigManagementServiceGrpc {

  private ConfigManagementServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.datacatalog.lineage.configmanagement.v1.ConfigManagementService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.configmanagement.v1.GetConfigRequest,
          com.google.cloud.datacatalog.lineage.configmanagement.v1.Config>
      getGetConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConfig",
      requestType = com.google.cloud.datacatalog.lineage.configmanagement.v1.GetConfigRequest.class,
      responseType = com.google.cloud.datacatalog.lineage.configmanagement.v1.Config.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.configmanagement.v1.GetConfigRequest,
          com.google.cloud.datacatalog.lineage.configmanagement.v1.Config>
      getGetConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.lineage.configmanagement.v1.GetConfigRequest,
            com.google.cloud.datacatalog.lineage.configmanagement.v1.Config>
        getGetConfigMethod;
    if ((getGetConfigMethod = ConfigManagementServiceGrpc.getGetConfigMethod) == null) {
      synchronized (ConfigManagementServiceGrpc.class) {
        if ((getGetConfigMethod = ConfigManagementServiceGrpc.getGetConfigMethod) == null) {
          ConfigManagementServiceGrpc.getGetConfigMethod =
              getGetConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.lineage.configmanagement.v1.GetConfigRequest,
                          com.google.cloud.datacatalog.lineage.configmanagement.v1.Config>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.configmanagement.v1
                                  .GetConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.configmanagement.v1.Config
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigManagementServiceMethodDescriptorSupplier("GetConfig"))
                      .build();
        }
      }
    }
    return getGetConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.configmanagement.v1.UpdateConfigRequest,
          com.google.cloud.datacatalog.lineage.configmanagement.v1.Config>
      getUpdateConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConfig",
      requestType =
          com.google.cloud.datacatalog.lineage.configmanagement.v1.UpdateConfigRequest.class,
      responseType = com.google.cloud.datacatalog.lineage.configmanagement.v1.Config.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.lineage.configmanagement.v1.UpdateConfigRequest,
          com.google.cloud.datacatalog.lineage.configmanagement.v1.Config>
      getUpdateConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.lineage.configmanagement.v1.UpdateConfigRequest,
            com.google.cloud.datacatalog.lineage.configmanagement.v1.Config>
        getUpdateConfigMethod;
    if ((getUpdateConfigMethod = ConfigManagementServiceGrpc.getUpdateConfigMethod) == null) {
      synchronized (ConfigManagementServiceGrpc.class) {
        if ((getUpdateConfigMethod = ConfigManagementServiceGrpc.getUpdateConfigMethod) == null) {
          ConfigManagementServiceGrpc.getUpdateConfigMethod =
              getUpdateConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.lineage.configmanagement.v1
                              .UpdateConfigRequest,
                          com.google.cloud.datacatalog.lineage.configmanagement.v1.Config>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.configmanagement.v1
                                  .UpdateConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.lineage.configmanagement.v1.Config
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigManagementServiceMethodDescriptorSupplier("UpdateConfig"))
                      .build();
        }
      }
    }
    return getUpdateConfigMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ConfigManagementServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigManagementServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConfigManagementServiceStub>() {
          @java.lang.Override
          public ConfigManagementServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConfigManagementServiceStub(channel, callOptions);
          }
        };
    return ConfigManagementServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ConfigManagementServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigManagementServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConfigManagementServiceBlockingV2Stub>() {
          @java.lang.Override
          public ConfigManagementServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConfigManagementServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return ConfigManagementServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConfigManagementServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigManagementServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConfigManagementServiceBlockingStub>() {
          @java.lang.Override
          public ConfigManagementServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConfigManagementServiceBlockingStub(channel, callOptions);
          }
        };
    return ConfigManagementServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ConfigManagementServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigManagementServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConfigManagementServiceFutureStub>() {
          @java.lang.Override
          public ConfigManagementServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConfigManagementServiceFutureStub(channel, callOptions);
          }
        };
    return ConfigManagementServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Lineage Config Management service. Config Management service is used to
   * manage the configuration for Data Lineage. These Configs define different
   * configuration options for Lineage customers to control behaviour of lineage
   * systems.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Get the Config for a given resource.
     * </pre>
     */
    default void getConfig(
        com.google.cloud.datacatalog.lineage.configmanagement.v1.GetConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.configmanagement.v1.Config>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the Config for a given resource.
     * </pre>
     */
    default void updateConfig(
        com.google.cloud.datacatalog.lineage.configmanagement.v1.UpdateConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.configmanagement.v1.Config>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateConfigMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ConfigManagementService.
   *
   * <pre>
   * Lineage Config Management service. Config Management service is used to
   * manage the configuration for Data Lineage. These Configs define different
   * configuration options for Lineage customers to control behaviour of lineage
   * systems.
   * </pre>
   */
  public abstract static class ConfigManagementServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ConfigManagementServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ConfigManagementService.
   *
   * <pre>
   * Lineage Config Management service. Config Management service is used to
   * manage the configuration for Data Lineage. These Configs define different
   * configuration options for Lineage customers to control behaviour of lineage
   * systems.
   * </pre>
   */
  public static final class ConfigManagementServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ConfigManagementServiceStub> {
    private ConfigManagementServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigManagementServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigManagementServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get the Config for a given resource.
     * </pre>
     */
    public void getConfig(
        com.google.cloud.datacatalog.lineage.configmanagement.v1.GetConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.configmanagement.v1.Config>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the Config for a given resource.
     * </pre>
     */
    public void updateConfig(
        com.google.cloud.datacatalog.lineage.configmanagement.v1.UpdateConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.lineage.configmanagement.v1.Config>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ConfigManagementService.
   *
   * <pre>
   * Lineage Config Management service. Config Management service is used to
   * manage the configuration for Data Lineage. These Configs define different
   * configuration options for Lineage customers to control behaviour of lineage
   * systems.
   * </pre>
   */
  public static final class ConfigManagementServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ConfigManagementServiceBlockingV2Stub> {
    private ConfigManagementServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigManagementServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigManagementServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get the Config for a given resource.
     * </pre>
     */
    public com.google.cloud.datacatalog.lineage.configmanagement.v1.Config getConfig(
        com.google.cloud.datacatalog.lineage.configmanagement.v1.GetConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update the Config for a given resource.
     * </pre>
     */
    public com.google.cloud.datacatalog.lineage.configmanagement.v1.Config updateConfig(
        com.google.cloud.datacatalog.lineage.configmanagement.v1.UpdateConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ConfigManagementService.
   *
   * <pre>
   * Lineage Config Management service. Config Management service is used to
   * manage the configuration for Data Lineage. These Configs define different
   * configuration options for Lineage customers to control behaviour of lineage
   * systems.
   * </pre>
   */
  public static final class ConfigManagementServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ConfigManagementServiceBlockingStub> {
    private ConfigManagementServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigManagementServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigManagementServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get the Config for a given resource.
     * </pre>
     */
    public com.google.cloud.datacatalog.lineage.configmanagement.v1.Config getConfig(
        com.google.cloud.datacatalog.lineage.configmanagement.v1.GetConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update the Config for a given resource.
     * </pre>
     */
    public com.google.cloud.datacatalog.lineage.configmanagement.v1.Config updateConfig(
        com.google.cloud.datacatalog.lineage.configmanagement.v1.UpdateConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * ConfigManagementService.
   *
   * <pre>
   * Lineage Config Management service. Config Management service is used to
   * manage the configuration for Data Lineage. These Configs define different
   * configuration options for Lineage customers to control behaviour of lineage
   * systems.
   * </pre>
   */
  public static final class ConfigManagementServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ConfigManagementServiceFutureStub> {
    private ConfigManagementServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigManagementServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigManagementServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get the Config for a given resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.lineage.configmanagement.v1.Config>
        getConfig(
            com.google.cloud.datacatalog.lineage.configmanagement.v1.GetConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update the Config for a given resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.lineage.configmanagement.v1.Config>
        updateConfig(
            com.google.cloud.datacatalog.lineage.configmanagement.v1.UpdateConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CONFIG = 0;
  private static final int METHODID_UPDATE_CONFIG = 1;

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
        case METHODID_GET_CONFIG:
          serviceImpl.getConfig(
              (com.google.cloud.datacatalog.lineage.configmanagement.v1.GetConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datacatalog.lineage.configmanagement.v1.Config>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CONFIG:
          serviceImpl.updateConfig(
              (com.google.cloud.datacatalog.lineage.configmanagement.v1.UpdateConfigRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datacatalog.lineage.configmanagement.v1.Config>)
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
            getGetConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.datacatalog.lineage.configmanagement.v1.GetConfigRequest,
                    com.google.cloud.datacatalog.lineage.configmanagement.v1.Config>(
                    service, METHODID_GET_CONFIG)))
        .addMethod(
            getUpdateConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.datacatalog.lineage.configmanagement.v1.UpdateConfigRequest,
                    com.google.cloud.datacatalog.lineage.configmanagement.v1.Config>(
                    service, METHODID_UPDATE_CONFIG)))
        .build();
  }

  private abstract static class ConfigManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConfigManagementServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.datacatalog.lineage.configmanagement.v1.ConfigManagementProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConfigManagementService");
    }
  }

  private static final class ConfigManagementServiceFileDescriptorSupplier
      extends ConfigManagementServiceBaseDescriptorSupplier {
    ConfigManagementServiceFileDescriptorSupplier() {}
  }

  private static final class ConfigManagementServiceMethodDescriptorSupplier
      extends ConfigManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ConfigManagementServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ConfigManagementServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ConfigManagementServiceFileDescriptorSupplier())
                      .addMethod(getGetConfigMethod())
                      .addMethod(getUpdateConfigMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
