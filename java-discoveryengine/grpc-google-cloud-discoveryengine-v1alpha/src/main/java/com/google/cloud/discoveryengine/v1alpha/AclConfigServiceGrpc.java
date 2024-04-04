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
package com.google.cloud.discoveryengine.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing Acl Configuration.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1alpha/acl_config_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AclConfigServiceGrpc {

  private AclConfigServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1alpha.AclConfigService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.UpdateAclConfigRequest,
          com.google.cloud.discoveryengine.v1alpha.AclConfig>
      getUpdateAclConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAclConfig",
      requestType = com.google.cloud.discoveryengine.v1alpha.UpdateAclConfigRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.AclConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.UpdateAclConfigRequest,
          com.google.cloud.discoveryengine.v1alpha.AclConfig>
      getUpdateAclConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.UpdateAclConfigRequest,
            com.google.cloud.discoveryengine.v1alpha.AclConfig>
        getUpdateAclConfigMethod;
    if ((getUpdateAclConfigMethod = AclConfigServiceGrpc.getUpdateAclConfigMethod) == null) {
      synchronized (AclConfigServiceGrpc.class) {
        if ((getUpdateAclConfigMethod = AclConfigServiceGrpc.getUpdateAclConfigMethod) == null) {
          AclConfigServiceGrpc.getUpdateAclConfigMethod =
              getUpdateAclConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.UpdateAclConfigRequest,
                          com.google.cloud.discoveryengine.v1alpha.AclConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAclConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.UpdateAclConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.AclConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AclConfigServiceMethodDescriptorSupplier("UpdateAclConfig"))
                      .build();
        }
      }
    }
    return getUpdateAclConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.GetAclConfigRequest,
          com.google.cloud.discoveryengine.v1alpha.AclConfig>
      getGetAclConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAclConfig",
      requestType = com.google.cloud.discoveryengine.v1alpha.GetAclConfigRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.AclConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.GetAclConfigRequest,
          com.google.cloud.discoveryengine.v1alpha.AclConfig>
      getGetAclConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.GetAclConfigRequest,
            com.google.cloud.discoveryengine.v1alpha.AclConfig>
        getGetAclConfigMethod;
    if ((getGetAclConfigMethod = AclConfigServiceGrpc.getGetAclConfigMethod) == null) {
      synchronized (AclConfigServiceGrpc.class) {
        if ((getGetAclConfigMethod = AclConfigServiceGrpc.getGetAclConfigMethod) == null) {
          AclConfigServiceGrpc.getGetAclConfigMethod =
              getGetAclConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.GetAclConfigRequest,
                          com.google.cloud.discoveryengine.v1alpha.AclConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAclConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.GetAclConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.AclConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AclConfigServiceMethodDescriptorSupplier("GetAclConfig"))
                      .build();
        }
      }
    }
    return getGetAclConfigMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AclConfigServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AclConfigServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AclConfigServiceStub>() {
          @java.lang.Override
          public AclConfigServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AclConfigServiceStub(channel, callOptions);
          }
        };
    return AclConfigServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AclConfigServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AclConfigServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AclConfigServiceBlockingStub>() {
          @java.lang.Override
          public AclConfigServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AclConfigServiceBlockingStub(channel, callOptions);
          }
        };
    return AclConfigServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AclConfigServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AclConfigServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AclConfigServiceFutureStub>() {
          @java.lang.Override
          public AclConfigServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AclConfigServiceFutureStub(channel, callOptions);
          }
        };
    return AclConfigServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing Acl Configuration.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Default Acl Configuration for use in a location of a customer's project.
     * Updates will only reflect to new data stores. Existing data stores will
     * still use the old value.
     * </pre>
     */
    default void updateAclConfig(
        com.google.cloud.discoveryengine.v1alpha.UpdateAclConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.AclConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAclConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the [AclConfig][google.cloud.discoveryengine.v1alpha.AclConfig].
     * </pre>
     */
    default void getAclConfig(
        com.google.cloud.discoveryengine.v1alpha.GetAclConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.AclConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAclConfigMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AclConfigService.
   *
   * <pre>
   * Service for managing Acl Configuration.
   * </pre>
   */
  public abstract static class AclConfigServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AclConfigServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AclConfigService.
   *
   * <pre>
   * Service for managing Acl Configuration.
   * </pre>
   */
  public static final class AclConfigServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AclConfigServiceStub> {
    private AclConfigServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AclConfigServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AclConfigServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Default Acl Configuration for use in a location of a customer's project.
     * Updates will only reflect to new data stores. Existing data stores will
     * still use the old value.
     * </pre>
     */
    public void updateAclConfig(
        com.google.cloud.discoveryengine.v1alpha.UpdateAclConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.AclConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAclConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the [AclConfig][google.cloud.discoveryengine.v1alpha.AclConfig].
     * </pre>
     */
    public void getAclConfig(
        com.google.cloud.discoveryengine.v1alpha.GetAclConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.AclConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAclConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AclConfigService.
   *
   * <pre>
   * Service for managing Acl Configuration.
   * </pre>
   */
  public static final class AclConfigServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AclConfigServiceBlockingStub> {
    private AclConfigServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AclConfigServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AclConfigServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Default Acl Configuration for use in a location of a customer's project.
     * Updates will only reflect to new data stores. Existing data stores will
     * still use the old value.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.AclConfig updateAclConfig(
        com.google.cloud.discoveryengine.v1alpha.UpdateAclConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAclConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the [AclConfig][google.cloud.discoveryengine.v1alpha.AclConfig].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.AclConfig getAclConfig(
        com.google.cloud.discoveryengine.v1alpha.GetAclConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAclConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AclConfigService.
   *
   * <pre>
   * Service for managing Acl Configuration.
   * </pre>
   */
  public static final class AclConfigServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AclConfigServiceFutureStub> {
    private AclConfigServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AclConfigServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AclConfigServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Default Acl Configuration for use in a location of a customer's project.
     * Updates will only reflect to new data stores. Existing data stores will
     * still use the old value.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1alpha.AclConfig>
        updateAclConfig(com.google.cloud.discoveryengine.v1alpha.UpdateAclConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAclConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the [AclConfig][google.cloud.discoveryengine.v1alpha.AclConfig].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1alpha.AclConfig>
        getAclConfig(com.google.cloud.discoveryengine.v1alpha.GetAclConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAclConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPDATE_ACL_CONFIG = 0;
  private static final int METHODID_GET_ACL_CONFIG = 1;

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
        case METHODID_UPDATE_ACL_CONFIG:
          serviceImpl.updateAclConfig(
              (com.google.cloud.discoveryengine.v1alpha.UpdateAclConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.AclConfig>)
                  responseObserver);
          break;
        case METHODID_GET_ACL_CONFIG:
          serviceImpl.getAclConfig(
              (com.google.cloud.discoveryengine.v1alpha.GetAclConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.AclConfig>)
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
            getUpdateAclConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.UpdateAclConfigRequest,
                    com.google.cloud.discoveryengine.v1alpha.AclConfig>(
                    service, METHODID_UPDATE_ACL_CONFIG)))
        .addMethod(
            getGetAclConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.GetAclConfigRequest,
                    com.google.cloud.discoveryengine.v1alpha.AclConfig>(
                    service, METHODID_GET_ACL_CONFIG)))
        .build();
  }

  private abstract static class AclConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AclConfigServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1alpha.AclConfigServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AclConfigService");
    }
  }

  private static final class AclConfigServiceFileDescriptorSupplier
      extends AclConfigServiceBaseDescriptorSupplier {
    AclConfigServiceFileDescriptorSupplier() {}
  }

  private static final class AclConfigServiceMethodDescriptorSupplier
      extends AclConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AclConfigServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AclConfigServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AclConfigServiceFileDescriptorSupplier())
                      .addMethod(getUpdateAclConfigMethod())
                      .addMethod(getGetAclConfigMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
