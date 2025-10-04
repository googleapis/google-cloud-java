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
package com.google.shopping.merchant.accounts.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for supporting [checkout
 * settings](https://support.google.com/merchants/answer/13945960).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1/checkoutsettings.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CheckoutSettingsServiceGrpc {

  private CheckoutSettingsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1.CheckoutSettingsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.GetCheckoutSettingsRequest,
          com.google.shopping.merchant.accounts.v1.CheckoutSettings>
      getGetCheckoutSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCheckoutSettings",
      requestType = com.google.shopping.merchant.accounts.v1.GetCheckoutSettingsRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1.CheckoutSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.GetCheckoutSettingsRequest,
          com.google.shopping.merchant.accounts.v1.CheckoutSettings>
      getGetCheckoutSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.GetCheckoutSettingsRequest,
            com.google.shopping.merchant.accounts.v1.CheckoutSettings>
        getGetCheckoutSettingsMethod;
    if ((getGetCheckoutSettingsMethod = CheckoutSettingsServiceGrpc.getGetCheckoutSettingsMethod)
        == null) {
      synchronized (CheckoutSettingsServiceGrpc.class) {
        if ((getGetCheckoutSettingsMethod =
                CheckoutSettingsServiceGrpc.getGetCheckoutSettingsMethod)
            == null) {
          CheckoutSettingsServiceGrpc.getGetCheckoutSettingsMethod =
              getGetCheckoutSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.GetCheckoutSettingsRequest,
                          com.google.shopping.merchant.accounts.v1.CheckoutSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCheckoutSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.GetCheckoutSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.CheckoutSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CheckoutSettingsServiceMethodDescriptorSupplier(
                              "GetCheckoutSettings"))
                      .build();
        }
      }
    }
    return getGetCheckoutSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.CreateCheckoutSettingsRequest,
          com.google.shopping.merchant.accounts.v1.CheckoutSettings>
      getCreateCheckoutSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCheckoutSettings",
      requestType = com.google.shopping.merchant.accounts.v1.CreateCheckoutSettingsRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1.CheckoutSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.CreateCheckoutSettingsRequest,
          com.google.shopping.merchant.accounts.v1.CheckoutSettings>
      getCreateCheckoutSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.CreateCheckoutSettingsRequest,
            com.google.shopping.merchant.accounts.v1.CheckoutSettings>
        getCreateCheckoutSettingsMethod;
    if ((getCreateCheckoutSettingsMethod =
            CheckoutSettingsServiceGrpc.getCreateCheckoutSettingsMethod)
        == null) {
      synchronized (CheckoutSettingsServiceGrpc.class) {
        if ((getCreateCheckoutSettingsMethod =
                CheckoutSettingsServiceGrpc.getCreateCheckoutSettingsMethod)
            == null) {
          CheckoutSettingsServiceGrpc.getCreateCheckoutSettingsMethod =
              getCreateCheckoutSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.CreateCheckoutSettingsRequest,
                          com.google.shopping.merchant.accounts.v1.CheckoutSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateCheckoutSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.CreateCheckoutSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.CheckoutSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CheckoutSettingsServiceMethodDescriptorSupplier(
                              "CreateCheckoutSettings"))
                      .build();
        }
      }
    }
    return getCreateCheckoutSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.UpdateCheckoutSettingsRequest,
          com.google.shopping.merchant.accounts.v1.CheckoutSettings>
      getUpdateCheckoutSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCheckoutSettings",
      requestType = com.google.shopping.merchant.accounts.v1.UpdateCheckoutSettingsRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1.CheckoutSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.UpdateCheckoutSettingsRequest,
          com.google.shopping.merchant.accounts.v1.CheckoutSettings>
      getUpdateCheckoutSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.UpdateCheckoutSettingsRequest,
            com.google.shopping.merchant.accounts.v1.CheckoutSettings>
        getUpdateCheckoutSettingsMethod;
    if ((getUpdateCheckoutSettingsMethod =
            CheckoutSettingsServiceGrpc.getUpdateCheckoutSettingsMethod)
        == null) {
      synchronized (CheckoutSettingsServiceGrpc.class) {
        if ((getUpdateCheckoutSettingsMethod =
                CheckoutSettingsServiceGrpc.getUpdateCheckoutSettingsMethod)
            == null) {
          CheckoutSettingsServiceGrpc.getUpdateCheckoutSettingsMethod =
              getUpdateCheckoutSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.UpdateCheckoutSettingsRequest,
                          com.google.shopping.merchant.accounts.v1.CheckoutSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateCheckoutSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.UpdateCheckoutSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.CheckoutSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CheckoutSettingsServiceMethodDescriptorSupplier(
                              "UpdateCheckoutSettings"))
                      .build();
        }
      }
    }
    return getUpdateCheckoutSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.DeleteCheckoutSettingsRequest,
          com.google.protobuf.Empty>
      getDeleteCheckoutSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCheckoutSettings",
      requestType = com.google.shopping.merchant.accounts.v1.DeleteCheckoutSettingsRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.DeleteCheckoutSettingsRequest,
          com.google.protobuf.Empty>
      getDeleteCheckoutSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.DeleteCheckoutSettingsRequest,
            com.google.protobuf.Empty>
        getDeleteCheckoutSettingsMethod;
    if ((getDeleteCheckoutSettingsMethod =
            CheckoutSettingsServiceGrpc.getDeleteCheckoutSettingsMethod)
        == null) {
      synchronized (CheckoutSettingsServiceGrpc.class) {
        if ((getDeleteCheckoutSettingsMethod =
                CheckoutSettingsServiceGrpc.getDeleteCheckoutSettingsMethod)
            == null) {
          CheckoutSettingsServiceGrpc.getDeleteCheckoutSettingsMethod =
              getDeleteCheckoutSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.DeleteCheckoutSettingsRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteCheckoutSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.DeleteCheckoutSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CheckoutSettingsServiceMethodDescriptorSupplier(
                              "DeleteCheckoutSettings"))
                      .build();
        }
      }
    }
    return getDeleteCheckoutSettingsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CheckoutSettingsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CheckoutSettingsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CheckoutSettingsServiceStub>() {
          @java.lang.Override
          public CheckoutSettingsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CheckoutSettingsServiceStub(channel, callOptions);
          }
        };
    return CheckoutSettingsServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static CheckoutSettingsServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CheckoutSettingsServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CheckoutSettingsServiceBlockingV2Stub>() {
          @java.lang.Override
          public CheckoutSettingsServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CheckoutSettingsServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return CheckoutSettingsServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CheckoutSettingsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CheckoutSettingsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CheckoutSettingsServiceBlockingStub>() {
          @java.lang.Override
          public CheckoutSettingsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CheckoutSettingsServiceBlockingStub(channel, callOptions);
          }
        };
    return CheckoutSettingsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CheckoutSettingsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CheckoutSettingsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CheckoutSettingsServiceFutureStub>() {
          @java.lang.Override
          public CheckoutSettingsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CheckoutSettingsServiceFutureStub(channel, callOptions);
          }
        };
    return CheckoutSettingsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for supporting [checkout
   * settings](https://support.google.com/merchants/answer/13945960).
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets `CheckoutSettings` for the given merchant. This includes
     * information about review state, enrollment state and URL settings.
     * </pre>
     */
    default void getCheckoutSettings(
        com.google.shopping.merchant.accounts.v1.GetCheckoutSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.CheckoutSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCheckoutSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates `CheckoutSettings` for the given merchant.
     * </pre>
     */
    default void createCheckoutSettings(
        com.google.shopping.merchant.accounts.v1.CreateCheckoutSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.CheckoutSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCheckoutSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates `CheckoutSettings` for the given merchant.
     * </pre>
     */
    default void updateCheckoutSettings(
        com.google.shopping.merchant.accounts.v1.UpdateCheckoutSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.CheckoutSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCheckoutSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes `CheckoutSettings` and unenrolls merchant from
     * `Checkout` program.
     * </pre>
     */
    default void deleteCheckoutSettings(
        com.google.shopping.merchant.accounts.v1.DeleteCheckoutSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCheckoutSettingsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CheckoutSettingsService.
   *
   * <pre>
   * Service for supporting [checkout
   * settings](https://support.google.com/merchants/answer/13945960).
   * </pre>
   */
  public abstract static class CheckoutSettingsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return CheckoutSettingsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CheckoutSettingsService.
   *
   * <pre>
   * Service for supporting [checkout
   * settings](https://support.google.com/merchants/answer/13945960).
   * </pre>
   */
  public static final class CheckoutSettingsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CheckoutSettingsServiceStub> {
    private CheckoutSettingsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckoutSettingsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CheckoutSettingsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets `CheckoutSettings` for the given merchant. This includes
     * information about review state, enrollment state and URL settings.
     * </pre>
     */
    public void getCheckoutSettings(
        com.google.shopping.merchant.accounts.v1.GetCheckoutSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.CheckoutSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCheckoutSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates `CheckoutSettings` for the given merchant.
     * </pre>
     */
    public void createCheckoutSettings(
        com.google.shopping.merchant.accounts.v1.CreateCheckoutSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.CheckoutSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCheckoutSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates `CheckoutSettings` for the given merchant.
     * </pre>
     */
    public void updateCheckoutSettings(
        com.google.shopping.merchant.accounts.v1.UpdateCheckoutSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.CheckoutSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCheckoutSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes `CheckoutSettings` and unenrolls merchant from
     * `Checkout` program.
     * </pre>
     */
    public void deleteCheckoutSettings(
        com.google.shopping.merchant.accounts.v1.DeleteCheckoutSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCheckoutSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CheckoutSettingsService.
   *
   * <pre>
   * Service for supporting [checkout
   * settings](https://support.google.com/merchants/answer/13945960).
   * </pre>
   */
  public static final class CheckoutSettingsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CheckoutSettingsServiceBlockingV2Stub> {
    private CheckoutSettingsServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckoutSettingsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CheckoutSettingsServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets `CheckoutSettings` for the given merchant. This includes
     * information about review state, enrollment state and URL settings.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.CheckoutSettings getCheckoutSettings(
        com.google.shopping.merchant.accounts.v1.GetCheckoutSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCheckoutSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates `CheckoutSettings` for the given merchant.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.CheckoutSettings createCheckoutSettings(
        com.google.shopping.merchant.accounts.v1.CreateCheckoutSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCheckoutSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates `CheckoutSettings` for the given merchant.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.CheckoutSettings updateCheckoutSettings(
        com.google.shopping.merchant.accounts.v1.UpdateCheckoutSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCheckoutSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes `CheckoutSettings` and unenrolls merchant from
     * `Checkout` program.
     * </pre>
     */
    public com.google.protobuf.Empty deleteCheckoutSettings(
        com.google.shopping.merchant.accounts.v1.DeleteCheckoutSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCheckoutSettingsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service CheckoutSettingsService.
   *
   * <pre>
   * Service for supporting [checkout
   * settings](https://support.google.com/merchants/answer/13945960).
   * </pre>
   */
  public static final class CheckoutSettingsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CheckoutSettingsServiceBlockingStub> {
    private CheckoutSettingsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckoutSettingsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CheckoutSettingsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets `CheckoutSettings` for the given merchant. This includes
     * information about review state, enrollment state and URL settings.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.CheckoutSettings getCheckoutSettings(
        com.google.shopping.merchant.accounts.v1.GetCheckoutSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCheckoutSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates `CheckoutSettings` for the given merchant.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.CheckoutSettings createCheckoutSettings(
        com.google.shopping.merchant.accounts.v1.CreateCheckoutSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCheckoutSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates `CheckoutSettings` for the given merchant.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.CheckoutSettings updateCheckoutSettings(
        com.google.shopping.merchant.accounts.v1.UpdateCheckoutSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCheckoutSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes `CheckoutSettings` and unenrolls merchant from
     * `Checkout` program.
     * </pre>
     */
    public com.google.protobuf.Empty deleteCheckoutSettings(
        com.google.shopping.merchant.accounts.v1.DeleteCheckoutSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCheckoutSettingsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * CheckoutSettingsService.
   *
   * <pre>
   * Service for supporting [checkout
   * settings](https://support.google.com/merchants/answer/13945960).
   * </pre>
   */
  public static final class CheckoutSettingsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CheckoutSettingsServiceFutureStub> {
    private CheckoutSettingsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckoutSettingsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CheckoutSettingsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets `CheckoutSettings` for the given merchant. This includes
     * information about review state, enrollment state and URL settings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1.CheckoutSettings>
        getCheckoutSettings(
            com.google.shopping.merchant.accounts.v1.GetCheckoutSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCheckoutSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates `CheckoutSettings` for the given merchant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1.CheckoutSettings>
        createCheckoutSettings(
            com.google.shopping.merchant.accounts.v1.CreateCheckoutSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCheckoutSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates `CheckoutSettings` for the given merchant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1.CheckoutSettings>
        updateCheckoutSettings(
            com.google.shopping.merchant.accounts.v1.UpdateCheckoutSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCheckoutSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes `CheckoutSettings` and unenrolls merchant from
     * `Checkout` program.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteCheckoutSettings(
            com.google.shopping.merchant.accounts.v1.DeleteCheckoutSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCheckoutSettingsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CHECKOUT_SETTINGS = 0;
  private static final int METHODID_CREATE_CHECKOUT_SETTINGS = 1;
  private static final int METHODID_UPDATE_CHECKOUT_SETTINGS = 2;
  private static final int METHODID_DELETE_CHECKOUT_SETTINGS = 3;

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
        case METHODID_GET_CHECKOUT_SETTINGS:
          serviceImpl.getCheckoutSettings(
              (com.google.shopping.merchant.accounts.v1.GetCheckoutSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1.CheckoutSettings>)
                  responseObserver);
          break;
        case METHODID_CREATE_CHECKOUT_SETTINGS:
          serviceImpl.createCheckoutSettings(
              (com.google.shopping.merchant.accounts.v1.CreateCheckoutSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1.CheckoutSettings>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CHECKOUT_SETTINGS:
          serviceImpl.updateCheckoutSettings(
              (com.google.shopping.merchant.accounts.v1.UpdateCheckoutSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1.CheckoutSettings>)
                  responseObserver);
          break;
        case METHODID_DELETE_CHECKOUT_SETTINGS:
          serviceImpl.deleteCheckoutSettings(
              (com.google.shopping.merchant.accounts.v1.DeleteCheckoutSettingsRequest) request,
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
            getGetCheckoutSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.GetCheckoutSettingsRequest,
                    com.google.shopping.merchant.accounts.v1.CheckoutSettings>(
                    service, METHODID_GET_CHECKOUT_SETTINGS)))
        .addMethod(
            getCreateCheckoutSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.CreateCheckoutSettingsRequest,
                    com.google.shopping.merchant.accounts.v1.CheckoutSettings>(
                    service, METHODID_CREATE_CHECKOUT_SETTINGS)))
        .addMethod(
            getUpdateCheckoutSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.UpdateCheckoutSettingsRequest,
                    com.google.shopping.merchant.accounts.v1.CheckoutSettings>(
                    service, METHODID_UPDATE_CHECKOUT_SETTINGS)))
        .addMethod(
            getDeleteCheckoutSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.DeleteCheckoutSettingsRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_CHECKOUT_SETTINGS)))
        .build();
  }

  private abstract static class CheckoutSettingsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CheckoutSettingsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1.CheckoutsettingsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CheckoutSettingsService");
    }
  }

  private static final class CheckoutSettingsServiceFileDescriptorSupplier
      extends CheckoutSettingsServiceBaseDescriptorSupplier {
    CheckoutSettingsServiceFileDescriptorSupplier() {}
  }

  private static final class CheckoutSettingsServiceMethodDescriptorSupplier
      extends CheckoutSettingsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CheckoutSettingsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CheckoutSettingsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CheckoutSettingsServiceFileDescriptorSupplier())
                      .addMethod(getGetCheckoutSettingsMethod())
                      .addMethod(getCreateCheckoutSettingsMethod())
                      .addMethod(getUpdateCheckoutSettingsMethod())
                      .addMethod(getDeleteCheckoutSettingsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
