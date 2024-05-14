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
package com.google.cloud.kms.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Provides interfaces for managing Cloud KMS Autokey folder-level
 * configurations. A configuration is inherited by all descendent projects. A
 * configuration at one folder overrides any other configurations in its
 * ancestry. Setting a configuration on a folder is a prerequisite for Cloud KMS
 * Autokey, so that users working in a descendant project can request
 * provisioned [CryptoKeys][google.cloud.kms.v1.CryptoKey], ready for Customer
 * Managed Encryption Key (CMEK) use, on-demand.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/kms/v1/autokey_admin.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AutokeyAdminGrpc {

  private AutokeyAdminGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.kms.v1.AutokeyAdmin";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.UpdateAutokeyConfigRequest, com.google.cloud.kms.v1.AutokeyConfig>
      getUpdateAutokeyConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAutokeyConfig",
      requestType = com.google.cloud.kms.v1.UpdateAutokeyConfigRequest.class,
      responseType = com.google.cloud.kms.v1.AutokeyConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.UpdateAutokeyConfigRequest, com.google.cloud.kms.v1.AutokeyConfig>
      getUpdateAutokeyConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.UpdateAutokeyConfigRequest,
            com.google.cloud.kms.v1.AutokeyConfig>
        getUpdateAutokeyConfigMethod;
    if ((getUpdateAutokeyConfigMethod = AutokeyAdminGrpc.getUpdateAutokeyConfigMethod) == null) {
      synchronized (AutokeyAdminGrpc.class) {
        if ((getUpdateAutokeyConfigMethod = AutokeyAdminGrpc.getUpdateAutokeyConfigMethod)
            == null) {
          AutokeyAdminGrpc.getUpdateAutokeyConfigMethod =
              getUpdateAutokeyConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.UpdateAutokeyConfigRequest,
                          com.google.cloud.kms.v1.AutokeyConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateAutokeyConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.UpdateAutokeyConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.AutokeyConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AutokeyAdminMethodDescriptorSupplier("UpdateAutokeyConfig"))
                      .build();
        }
      }
    }
    return getUpdateAutokeyConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetAutokeyConfigRequest, com.google.cloud.kms.v1.AutokeyConfig>
      getGetAutokeyConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAutokeyConfig",
      requestType = com.google.cloud.kms.v1.GetAutokeyConfigRequest.class,
      responseType = com.google.cloud.kms.v1.AutokeyConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetAutokeyConfigRequest, com.google.cloud.kms.v1.AutokeyConfig>
      getGetAutokeyConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.GetAutokeyConfigRequest, com.google.cloud.kms.v1.AutokeyConfig>
        getGetAutokeyConfigMethod;
    if ((getGetAutokeyConfigMethod = AutokeyAdminGrpc.getGetAutokeyConfigMethod) == null) {
      synchronized (AutokeyAdminGrpc.class) {
        if ((getGetAutokeyConfigMethod = AutokeyAdminGrpc.getGetAutokeyConfigMethod) == null) {
          AutokeyAdminGrpc.getGetAutokeyConfigMethod =
              getGetAutokeyConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.GetAutokeyConfigRequest,
                          com.google.cloud.kms.v1.AutokeyConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAutokeyConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.GetAutokeyConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.AutokeyConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AutokeyAdminMethodDescriptorSupplier("GetAutokeyConfig"))
                      .build();
        }
      }
    }
    return getGetAutokeyConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigRequest,
          com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigResponse>
      getShowEffectiveAutokeyConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ShowEffectiveAutokeyConfig",
      requestType = com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigRequest.class,
      responseType = com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigRequest,
          com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigResponse>
      getShowEffectiveAutokeyConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigRequest,
            com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigResponse>
        getShowEffectiveAutokeyConfigMethod;
    if ((getShowEffectiveAutokeyConfigMethod = AutokeyAdminGrpc.getShowEffectiveAutokeyConfigMethod)
        == null) {
      synchronized (AutokeyAdminGrpc.class) {
        if ((getShowEffectiveAutokeyConfigMethod =
                AutokeyAdminGrpc.getShowEffectiveAutokeyConfigMethod)
            == null) {
          AutokeyAdminGrpc.getShowEffectiveAutokeyConfigMethod =
              getShowEffectiveAutokeyConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigRequest,
                          com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ShowEffectiveAutokeyConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AutokeyAdminMethodDescriptorSupplier("ShowEffectiveAutokeyConfig"))
                      .build();
        }
      }
    }
    return getShowEffectiveAutokeyConfigMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AutokeyAdminStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutokeyAdminStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AutokeyAdminStub>() {
          @java.lang.Override
          public AutokeyAdminStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AutokeyAdminStub(channel, callOptions);
          }
        };
    return AutokeyAdminStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AutokeyAdminBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutokeyAdminBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AutokeyAdminBlockingStub>() {
          @java.lang.Override
          public AutokeyAdminBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AutokeyAdminBlockingStub(channel, callOptions);
          }
        };
    return AutokeyAdminBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AutokeyAdminFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutokeyAdminFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AutokeyAdminFutureStub>() {
          @java.lang.Override
          public AutokeyAdminFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AutokeyAdminFutureStub(channel, callOptions);
          }
        };
    return AutokeyAdminFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Provides interfaces for managing Cloud KMS Autokey folder-level
   * configurations. A configuration is inherited by all descendent projects. A
   * configuration at one folder overrides any other configurations in its
   * ancestry. Setting a configuration on a folder is a prerequisite for Cloud KMS
   * Autokey, so that users working in a descendant project can request
   * provisioned [CryptoKeys][google.cloud.kms.v1.CryptoKey], ready for Customer
   * Managed Encryption Key (CMEK) use, on-demand.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Updates the [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] for a
     * folder. The caller must have both `cloudkms.autokeyConfigs.update`
     * permission on the parent folder and `cloudkms.cryptoKeys.setIamPolicy`
     * permission on the provided key project. A
     * [KeyHandle][google.cloud.kms.v1.KeyHandle] creation in the folder's
     * descendant projects will use this configuration to determine where to
     * create the resulting [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    default void updateAutokeyConfig(
        com.google.cloud.kms.v1.UpdateAutokeyConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.AutokeyConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAutokeyConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] for a
     * folder.
     * </pre>
     */
    default void getAutokeyConfig(
        com.google.cloud.kms.v1.GetAutokeyConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.AutokeyConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAutokeyConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the effective Cloud KMS Autokey configuration for a given project.
     * </pre>
     */
    default void showEffectiveAutokeyConfig(
        com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getShowEffectiveAutokeyConfigMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AutokeyAdmin.
   *
   * <pre>
   * Provides interfaces for managing Cloud KMS Autokey folder-level
   * configurations. A configuration is inherited by all descendent projects. A
   * configuration at one folder overrides any other configurations in its
   * ancestry. Setting a configuration on a folder is a prerequisite for Cloud KMS
   * Autokey, so that users working in a descendant project can request
   * provisioned [CryptoKeys][google.cloud.kms.v1.CryptoKey], ready for Customer
   * Managed Encryption Key (CMEK) use, on-demand.
   * </pre>
   */
  public abstract static class AutokeyAdminImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AutokeyAdminGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AutokeyAdmin.
   *
   * <pre>
   * Provides interfaces for managing Cloud KMS Autokey folder-level
   * configurations. A configuration is inherited by all descendent projects. A
   * configuration at one folder overrides any other configurations in its
   * ancestry. Setting a configuration on a folder is a prerequisite for Cloud KMS
   * Autokey, so that users working in a descendant project can request
   * provisioned [CryptoKeys][google.cloud.kms.v1.CryptoKey], ready for Customer
   * Managed Encryption Key (CMEK) use, on-demand.
   * </pre>
   */
  public static final class AutokeyAdminStub
      extends io.grpc.stub.AbstractAsyncStub<AutokeyAdminStub> {
    private AutokeyAdminStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutokeyAdminStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutokeyAdminStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Updates the [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] for a
     * folder. The caller must have both `cloudkms.autokeyConfigs.update`
     * permission on the parent folder and `cloudkms.cryptoKeys.setIamPolicy`
     * permission on the provided key project. A
     * [KeyHandle][google.cloud.kms.v1.KeyHandle] creation in the folder's
     * descendant projects will use this configuration to determine where to
     * create the resulting [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public void updateAutokeyConfig(
        com.google.cloud.kms.v1.UpdateAutokeyConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.AutokeyConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAutokeyConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] for a
     * folder.
     * </pre>
     */
    public void getAutokeyConfig(
        com.google.cloud.kms.v1.GetAutokeyConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.AutokeyConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAutokeyConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the effective Cloud KMS Autokey configuration for a given project.
     * </pre>
     */
    public void showEffectiveAutokeyConfig(
        com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getShowEffectiveAutokeyConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AutokeyAdmin.
   *
   * <pre>
   * Provides interfaces for managing Cloud KMS Autokey folder-level
   * configurations. A configuration is inherited by all descendent projects. A
   * configuration at one folder overrides any other configurations in its
   * ancestry. Setting a configuration on a folder is a prerequisite for Cloud KMS
   * Autokey, so that users working in a descendant project can request
   * provisioned [CryptoKeys][google.cloud.kms.v1.CryptoKey], ready for Customer
   * Managed Encryption Key (CMEK) use, on-demand.
   * </pre>
   */
  public static final class AutokeyAdminBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AutokeyAdminBlockingStub> {
    private AutokeyAdminBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutokeyAdminBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutokeyAdminBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Updates the [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] for a
     * folder. The caller must have both `cloudkms.autokeyConfigs.update`
     * permission on the parent folder and `cloudkms.cryptoKeys.setIamPolicy`
     * permission on the provided key project. A
     * [KeyHandle][google.cloud.kms.v1.KeyHandle] creation in the folder's
     * descendant projects will use this configuration to determine where to
     * create the resulting [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public com.google.cloud.kms.v1.AutokeyConfig updateAutokeyConfig(
        com.google.cloud.kms.v1.UpdateAutokeyConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAutokeyConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] for a
     * folder.
     * </pre>
     */
    public com.google.cloud.kms.v1.AutokeyConfig getAutokeyConfig(
        com.google.cloud.kms.v1.GetAutokeyConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAutokeyConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the effective Cloud KMS Autokey configuration for a given project.
     * </pre>
     */
    public com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigResponse showEffectiveAutokeyConfig(
        com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getShowEffectiveAutokeyConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AutokeyAdmin.
   *
   * <pre>
   * Provides interfaces for managing Cloud KMS Autokey folder-level
   * configurations. A configuration is inherited by all descendent projects. A
   * configuration at one folder overrides any other configurations in its
   * ancestry. Setting a configuration on a folder is a prerequisite for Cloud KMS
   * Autokey, so that users working in a descendant project can request
   * provisioned [CryptoKeys][google.cloud.kms.v1.CryptoKey], ready for Customer
   * Managed Encryption Key (CMEK) use, on-demand.
   * </pre>
   */
  public static final class AutokeyAdminFutureStub
      extends io.grpc.stub.AbstractFutureStub<AutokeyAdminFutureStub> {
    private AutokeyAdminFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutokeyAdminFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutokeyAdminFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Updates the [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] for a
     * folder. The caller must have both `cloudkms.autokeyConfigs.update`
     * permission on the parent folder and `cloudkms.cryptoKeys.setIamPolicy`
     * permission on the provided key project. A
     * [KeyHandle][google.cloud.kms.v1.KeyHandle] creation in the folder's
     * descendant projects will use this configuration to determine where to
     * create the resulting [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.AutokeyConfig>
        updateAutokeyConfig(com.google.cloud.kms.v1.UpdateAutokeyConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAutokeyConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] for a
     * folder.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.AutokeyConfig>
        getAutokeyConfig(com.google.cloud.kms.v1.GetAutokeyConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAutokeyConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the effective Cloud KMS Autokey configuration for a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigResponse>
        showEffectiveAutokeyConfig(
            com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getShowEffectiveAutokeyConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPDATE_AUTOKEY_CONFIG = 0;
  private static final int METHODID_GET_AUTOKEY_CONFIG = 1;
  private static final int METHODID_SHOW_EFFECTIVE_AUTOKEY_CONFIG = 2;

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
        case METHODID_UPDATE_AUTOKEY_CONFIG:
          serviceImpl.updateAutokeyConfig(
              (com.google.cloud.kms.v1.UpdateAutokeyConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.AutokeyConfig>)
                  responseObserver);
          break;
        case METHODID_GET_AUTOKEY_CONFIG:
          serviceImpl.getAutokeyConfig(
              (com.google.cloud.kms.v1.GetAutokeyConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.AutokeyConfig>)
                  responseObserver);
          break;
        case METHODID_SHOW_EFFECTIVE_AUTOKEY_CONFIG:
          serviceImpl.showEffectiveAutokeyConfig(
              (com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigResponse>)
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
            getUpdateAutokeyConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.kms.v1.UpdateAutokeyConfigRequest,
                    com.google.cloud.kms.v1.AutokeyConfig>(
                    service, METHODID_UPDATE_AUTOKEY_CONFIG)))
        .addMethod(
            getGetAutokeyConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.kms.v1.GetAutokeyConfigRequest,
                    com.google.cloud.kms.v1.AutokeyConfig>(service, METHODID_GET_AUTOKEY_CONFIG)))
        .addMethod(
            getShowEffectiveAutokeyConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigRequest,
                    com.google.cloud.kms.v1.ShowEffectiveAutokeyConfigResponse>(
                    service, METHODID_SHOW_EFFECTIVE_AUTOKEY_CONFIG)))
        .build();
  }

  private abstract static class AutokeyAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AutokeyAdminBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.kms.v1.AutokeyAdminProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AutokeyAdmin");
    }
  }

  private static final class AutokeyAdminFileDescriptorSupplier
      extends AutokeyAdminBaseDescriptorSupplier {
    AutokeyAdminFileDescriptorSupplier() {}
  }

  private static final class AutokeyAdminMethodDescriptorSupplier
      extends AutokeyAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AutokeyAdminMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AutokeyAdminGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AutokeyAdminFileDescriptorSupplier())
                      .addMethod(getUpdateAutokeyConfigMethod())
                      .addMethod(getGetAutokeyConfigMethod())
                      .addMethod(getShowEffectiveAutokeyConfigMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
