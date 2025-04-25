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
package com.google.cloud.dialogflow.cx.v3beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing security settings for Dialogflow.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3beta1/security_settings.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SecuritySettingsServiceGrpc {

  private SecuritySettingsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.dialogflow.cx.v3beta1.SecuritySettingsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.CreateSecuritySettingsRequest,
          com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
      getCreateSecuritySettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSecuritySettings",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.CreateSecuritySettingsRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.CreateSecuritySettingsRequest,
          com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
      getCreateSecuritySettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.CreateSecuritySettingsRequest,
            com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
        getCreateSecuritySettingsMethod;
    if ((getCreateSecuritySettingsMethod =
            SecuritySettingsServiceGrpc.getCreateSecuritySettingsMethod)
        == null) {
      synchronized (SecuritySettingsServiceGrpc.class) {
        if ((getCreateSecuritySettingsMethod =
                SecuritySettingsServiceGrpc.getCreateSecuritySettingsMethod)
            == null) {
          SecuritySettingsServiceGrpc.getCreateSecuritySettingsMethod =
              getCreateSecuritySettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.CreateSecuritySettingsRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateSecuritySettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.CreateSecuritySettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecuritySettingsServiceMethodDescriptorSupplier(
                              "CreateSecuritySettings"))
                      .build();
        }
      }
    }
    return getCreateSecuritySettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetSecuritySettingsRequest,
          com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
      getGetSecuritySettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSecuritySettings",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.GetSecuritySettingsRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetSecuritySettingsRequest,
          com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
      getGetSecuritySettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.GetSecuritySettingsRequest,
            com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
        getGetSecuritySettingsMethod;
    if ((getGetSecuritySettingsMethod = SecuritySettingsServiceGrpc.getGetSecuritySettingsMethod)
        == null) {
      synchronized (SecuritySettingsServiceGrpc.class) {
        if ((getGetSecuritySettingsMethod =
                SecuritySettingsServiceGrpc.getGetSecuritySettingsMethod)
            == null) {
          SecuritySettingsServiceGrpc.getGetSecuritySettingsMethod =
              getGetSecuritySettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.GetSecuritySettingsRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetSecuritySettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.GetSecuritySettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecuritySettingsServiceMethodDescriptorSupplier(
                              "GetSecuritySettings"))
                      .build();
        }
      }
    }
    return getGetSecuritySettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.UpdateSecuritySettingsRequest,
          com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
      getUpdateSecuritySettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSecuritySettings",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.UpdateSecuritySettingsRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.UpdateSecuritySettingsRequest,
          com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
      getUpdateSecuritySettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.UpdateSecuritySettingsRequest,
            com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
        getUpdateSecuritySettingsMethod;
    if ((getUpdateSecuritySettingsMethod =
            SecuritySettingsServiceGrpc.getUpdateSecuritySettingsMethod)
        == null) {
      synchronized (SecuritySettingsServiceGrpc.class) {
        if ((getUpdateSecuritySettingsMethod =
                SecuritySettingsServiceGrpc.getUpdateSecuritySettingsMethod)
            == null) {
          SecuritySettingsServiceGrpc.getUpdateSecuritySettingsMethod =
              getUpdateSecuritySettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.UpdateSecuritySettingsRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateSecuritySettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.UpdateSecuritySettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecuritySettingsServiceMethodDescriptorSupplier(
                              "UpdateSecuritySettings"))
                      .build();
        }
      }
    }
    return getUpdateSecuritySettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsRequest,
          com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsResponse>
      getListSecuritySettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSecuritySettings",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsRequest,
          com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsResponse>
      getListSecuritySettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsRequest,
            com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsResponse>
        getListSecuritySettingsMethod;
    if ((getListSecuritySettingsMethod = SecuritySettingsServiceGrpc.getListSecuritySettingsMethod)
        == null) {
      synchronized (SecuritySettingsServiceGrpc.class) {
        if ((getListSecuritySettingsMethod =
                SecuritySettingsServiceGrpc.getListSecuritySettingsMethod)
            == null) {
          SecuritySettingsServiceGrpc.getListSecuritySettingsMethod =
              getListSecuritySettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListSecuritySettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecuritySettingsServiceMethodDescriptorSupplier(
                              "ListSecuritySettings"))
                      .build();
        }
      }
    }
    return getListSecuritySettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.DeleteSecuritySettingsRequest,
          com.google.protobuf.Empty>
      getDeleteSecuritySettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSecuritySettings",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.DeleteSecuritySettingsRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.DeleteSecuritySettingsRequest,
          com.google.protobuf.Empty>
      getDeleteSecuritySettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.DeleteSecuritySettingsRequest,
            com.google.protobuf.Empty>
        getDeleteSecuritySettingsMethod;
    if ((getDeleteSecuritySettingsMethod =
            SecuritySettingsServiceGrpc.getDeleteSecuritySettingsMethod)
        == null) {
      synchronized (SecuritySettingsServiceGrpc.class) {
        if ((getDeleteSecuritySettingsMethod =
                SecuritySettingsServiceGrpc.getDeleteSecuritySettingsMethod)
            == null) {
          SecuritySettingsServiceGrpc.getDeleteSecuritySettingsMethod =
              getDeleteSecuritySettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.DeleteSecuritySettingsRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteSecuritySettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.DeleteSecuritySettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecuritySettingsServiceMethodDescriptorSupplier(
                              "DeleteSecuritySettings"))
                      .build();
        }
      }
    }
    return getDeleteSecuritySettingsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SecuritySettingsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecuritySettingsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecuritySettingsServiceStub>() {
          @java.lang.Override
          public SecuritySettingsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecuritySettingsServiceStub(channel, callOptions);
          }
        };
    return SecuritySettingsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SecuritySettingsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecuritySettingsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecuritySettingsServiceBlockingStub>() {
          @java.lang.Override
          public SecuritySettingsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecuritySettingsServiceBlockingStub(channel, callOptions);
          }
        };
    return SecuritySettingsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SecuritySettingsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecuritySettingsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecuritySettingsServiceFutureStub>() {
          @java.lang.Override
          public SecuritySettingsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecuritySettingsServiceFutureStub(channel, callOptions);
          }
        };
    return SecuritySettingsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing security settings for Dialogflow.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Create security settings in the specified location.
     * </pre>
     */
    default void createSecuritySettings(
        com.google.cloud.dialogflow.cx.v3beta1.CreateSecuritySettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSecuritySettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified
     * [SecuritySettings][google.cloud.dialogflow.cx.v3beta1.SecuritySettings].
     * The returned settings may be stale by up to 1 minute.
     * </pre>
     */
    default void getSecuritySettings(
        com.google.cloud.dialogflow.cx.v3beta1.GetSecuritySettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSecuritySettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified
     * [SecuritySettings][google.cloud.dialogflow.cx.v3beta1.SecuritySettings].
     * </pre>
     */
    default void updateSecuritySettings(
        com.google.cloud.dialogflow.cx.v3beta1.UpdateSecuritySettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSecuritySettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all security settings in the specified location.
     * </pre>
     */
    default void listSecuritySettings(
        com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSecuritySettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified
     * [SecuritySettings][google.cloud.dialogflow.cx.v3beta1.SecuritySettings].
     * </pre>
     */
    default void deleteSecuritySettings(
        com.google.cloud.dialogflow.cx.v3beta1.DeleteSecuritySettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSecuritySettingsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SecuritySettingsService.
   *
   * <pre>
   * Service for managing security settings for Dialogflow.
   * </pre>
   */
  public abstract static class SecuritySettingsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SecuritySettingsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SecuritySettingsService.
   *
   * <pre>
   * Service for managing security settings for Dialogflow.
   * </pre>
   */
  public static final class SecuritySettingsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SecuritySettingsServiceStub> {
    private SecuritySettingsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecuritySettingsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecuritySettingsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create security settings in the specified location.
     * </pre>
     */
    public void createSecuritySettings(
        com.google.cloud.dialogflow.cx.v3beta1.CreateSecuritySettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSecuritySettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified
     * [SecuritySettings][google.cloud.dialogflow.cx.v3beta1.SecuritySettings].
     * The returned settings may be stale by up to 1 minute.
     * </pre>
     */
    public void getSecuritySettings(
        com.google.cloud.dialogflow.cx.v3beta1.GetSecuritySettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSecuritySettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified
     * [SecuritySettings][google.cloud.dialogflow.cx.v3beta1.SecuritySettings].
     * </pre>
     */
    public void updateSecuritySettings(
        com.google.cloud.dialogflow.cx.v3beta1.UpdateSecuritySettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSecuritySettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all security settings in the specified location.
     * </pre>
     */
    public void listSecuritySettings(
        com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSecuritySettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified
     * [SecuritySettings][google.cloud.dialogflow.cx.v3beta1.SecuritySettings].
     * </pre>
     */
    public void deleteSecuritySettings(
        com.google.cloud.dialogflow.cx.v3beta1.DeleteSecuritySettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSecuritySettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SecuritySettingsService.
   *
   * <pre>
   * Service for managing security settings for Dialogflow.
   * </pre>
   */
  public static final class SecuritySettingsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SecuritySettingsServiceBlockingStub> {
    private SecuritySettingsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecuritySettingsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecuritySettingsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create security settings in the specified location.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings createSecuritySettings(
        com.google.cloud.dialogflow.cx.v3beta1.CreateSecuritySettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSecuritySettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified
     * [SecuritySettings][google.cloud.dialogflow.cx.v3beta1.SecuritySettings].
     * The returned settings may be stale by up to 1 minute.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings getSecuritySettings(
        com.google.cloud.dialogflow.cx.v3beta1.GetSecuritySettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSecuritySettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified
     * [SecuritySettings][google.cloud.dialogflow.cx.v3beta1.SecuritySettings].
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings updateSecuritySettings(
        com.google.cloud.dialogflow.cx.v3beta1.UpdateSecuritySettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSecuritySettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all security settings in the specified location.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsResponse listSecuritySettings(
        com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSecuritySettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified
     * [SecuritySettings][google.cloud.dialogflow.cx.v3beta1.SecuritySettings].
     * </pre>
     */
    public com.google.protobuf.Empty deleteSecuritySettings(
        com.google.cloud.dialogflow.cx.v3beta1.DeleteSecuritySettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSecuritySettingsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * SecuritySettingsService.
   *
   * <pre>
   * Service for managing security settings for Dialogflow.
   * </pre>
   */
  public static final class SecuritySettingsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SecuritySettingsServiceFutureStub> {
    private SecuritySettingsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecuritySettingsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecuritySettingsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create security settings in the specified location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
        createSecuritySettings(
            com.google.cloud.dialogflow.cx.v3beta1.CreateSecuritySettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSecuritySettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified
     * [SecuritySettings][google.cloud.dialogflow.cx.v3beta1.SecuritySettings].
     * The returned settings may be stale by up to 1 minute.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
        getSecuritySettings(
            com.google.cloud.dialogflow.cx.v3beta1.GetSecuritySettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSecuritySettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified
     * [SecuritySettings][google.cloud.dialogflow.cx.v3beta1.SecuritySettings].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>
        updateSecuritySettings(
            com.google.cloud.dialogflow.cx.v3beta1.UpdateSecuritySettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSecuritySettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all security settings in the specified location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsResponse>
        listSecuritySettings(
            com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSecuritySettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified
     * [SecuritySettings][google.cloud.dialogflow.cx.v3beta1.SecuritySettings].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSecuritySettings(
            com.google.cloud.dialogflow.cx.v3beta1.DeleteSecuritySettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSecuritySettingsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SECURITY_SETTINGS = 0;
  private static final int METHODID_GET_SECURITY_SETTINGS = 1;
  private static final int METHODID_UPDATE_SECURITY_SETTINGS = 2;
  private static final int METHODID_LIST_SECURITY_SETTINGS = 3;
  private static final int METHODID_DELETE_SECURITY_SETTINGS = 4;

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
        case METHODID_CREATE_SECURITY_SETTINGS:
          serviceImpl.createSecuritySettings(
              (com.google.cloud.dialogflow.cx.v3beta1.CreateSecuritySettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>)
                  responseObserver);
          break;
        case METHODID_GET_SECURITY_SETTINGS:
          serviceImpl.getSecuritySettings(
              (com.google.cloud.dialogflow.cx.v3beta1.GetSecuritySettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SECURITY_SETTINGS:
          serviceImpl.updateSecuritySettings(
              (com.google.cloud.dialogflow.cx.v3beta1.UpdateSecuritySettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>)
                  responseObserver);
          break;
        case METHODID_LIST_SECURITY_SETTINGS:
          serviceImpl.listSecuritySettings(
              (com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_SECURITY_SETTINGS:
          serviceImpl.deleteSecuritySettings(
              (com.google.cloud.dialogflow.cx.v3beta1.DeleteSecuritySettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
            getCreateSecuritySettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.CreateSecuritySettingsRequest,
                    com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>(
                    service, METHODID_CREATE_SECURITY_SETTINGS)))
        .addMethod(
            getGetSecuritySettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.GetSecuritySettingsRequest,
                    com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>(
                    service, METHODID_GET_SECURITY_SETTINGS)))
        .addMethod(
            getUpdateSecuritySettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.UpdateSecuritySettingsRequest,
                    com.google.cloud.dialogflow.cx.v3beta1.SecuritySettings>(
                    service, METHODID_UPDATE_SECURITY_SETTINGS)))
        .addMethod(
            getListSecuritySettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsRequest,
                    com.google.cloud.dialogflow.cx.v3beta1.ListSecuritySettingsResponse>(
                    service, METHODID_LIST_SECURITY_SETTINGS)))
        .addMethod(
            getDeleteSecuritySettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.DeleteSecuritySettingsRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_SECURITY_SETTINGS)))
        .build();
  }

  private abstract static class SecuritySettingsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SecuritySettingsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3beta1.SecuritySettingsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SecuritySettingsService");
    }
  }

  private static final class SecuritySettingsServiceFileDescriptorSupplier
      extends SecuritySettingsServiceBaseDescriptorSupplier {
    SecuritySettingsServiceFileDescriptorSupplier() {}
  }

  private static final class SecuritySettingsServiceMethodDescriptorSupplier
      extends SecuritySettingsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SecuritySettingsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SecuritySettingsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SecuritySettingsServiceFileDescriptorSupplier())
                      .addMethod(getCreateSecuritySettingsMethod())
                      .addMethod(getGetSecuritySettingsMethod())
                      .addMethod(getUpdateSecuritySettingsMethod())
                      .addMethod(getListSecuritySettingsMethod())
                      .addMethod(getDeleteSecuritySettingsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
