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
package com.google.shopping.merchant.accounts.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to get method call shipping setting information per Merchant API
 * method.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1beta/shippingsettings.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ShippingSettingsServiceGrpc {

  private ShippingSettingsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1beta.ShippingSettingsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetShippingSettingsRequest,
          com.google.shopping.merchant.accounts.v1beta.ShippingSettings>
      getGetShippingSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetShippingSettings",
      requestType = com.google.shopping.merchant.accounts.v1beta.GetShippingSettingsRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.ShippingSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetShippingSettingsRequest,
          com.google.shopping.merchant.accounts.v1beta.ShippingSettings>
      getGetShippingSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.GetShippingSettingsRequest,
            com.google.shopping.merchant.accounts.v1beta.ShippingSettings>
        getGetShippingSettingsMethod;
    if ((getGetShippingSettingsMethod = ShippingSettingsServiceGrpc.getGetShippingSettingsMethod)
        == null) {
      synchronized (ShippingSettingsServiceGrpc.class) {
        if ((getGetShippingSettingsMethod =
                ShippingSettingsServiceGrpc.getGetShippingSettingsMethod)
            == null) {
          ShippingSettingsServiceGrpc.getGetShippingSettingsMethod =
              getGetShippingSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.GetShippingSettingsRequest,
                          com.google.shopping.merchant.accounts.v1beta.ShippingSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetShippingSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .GetShippingSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.ShippingSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ShippingSettingsServiceMethodDescriptorSupplier(
                              "GetShippingSettings"))
                      .build();
        }
      }
    }
    return getGetShippingSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.InsertShippingSettingsRequest,
          com.google.shopping.merchant.accounts.v1beta.ShippingSettings>
      getInsertShippingSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InsertShippingSettings",
      requestType =
          com.google.shopping.merchant.accounts.v1beta.InsertShippingSettingsRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.ShippingSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.InsertShippingSettingsRequest,
          com.google.shopping.merchant.accounts.v1beta.ShippingSettings>
      getInsertShippingSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.InsertShippingSettingsRequest,
            com.google.shopping.merchant.accounts.v1beta.ShippingSettings>
        getInsertShippingSettingsMethod;
    if ((getInsertShippingSettingsMethod =
            ShippingSettingsServiceGrpc.getInsertShippingSettingsMethod)
        == null) {
      synchronized (ShippingSettingsServiceGrpc.class) {
        if ((getInsertShippingSettingsMethod =
                ShippingSettingsServiceGrpc.getInsertShippingSettingsMethod)
            == null) {
          ShippingSettingsServiceGrpc.getInsertShippingSettingsMethod =
              getInsertShippingSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.InsertShippingSettingsRequest,
                          com.google.shopping.merchant.accounts.v1beta.ShippingSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "InsertShippingSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .InsertShippingSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.ShippingSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ShippingSettingsServiceMethodDescriptorSupplier(
                              "InsertShippingSettings"))
                      .build();
        }
      }
    }
    return getInsertShippingSettingsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ShippingSettingsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ShippingSettingsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ShippingSettingsServiceStub>() {
          @java.lang.Override
          public ShippingSettingsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ShippingSettingsServiceStub(channel, callOptions);
          }
        };
    return ShippingSettingsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ShippingSettingsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ShippingSettingsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ShippingSettingsServiceBlockingStub>() {
          @java.lang.Override
          public ShippingSettingsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ShippingSettingsServiceBlockingStub(channel, callOptions);
          }
        };
    return ShippingSettingsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ShippingSettingsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ShippingSettingsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ShippingSettingsServiceFutureStub>() {
          @java.lang.Override
          public ShippingSettingsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ShippingSettingsServiceFutureStub(channel, callOptions);
          }
        };
    return ShippingSettingsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to get method call shipping setting information per Merchant API
   * method.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieve shipping setting information.
     * </pre>
     */
    default void getShippingSettings(
        com.google.shopping.merchant.accounts.v1beta.GetShippingSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.ShippingSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetShippingSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Replace the shipping setting of a merchant with the request shipping
     * setting. Executing this method requires admin access.
     * </pre>
     */
    default void insertShippingSettings(
        com.google.shopping.merchant.accounts.v1beta.InsertShippingSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.ShippingSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getInsertShippingSettingsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ShippingSettingsService.
   *
   * <pre>
   * Service to get method call shipping setting information per Merchant API
   * method.
   * </pre>
   */
  public abstract static class ShippingSettingsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ShippingSettingsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ShippingSettingsService.
   *
   * <pre>
   * Service to get method call shipping setting information per Merchant API
   * method.
   * </pre>
   */
  public static final class ShippingSettingsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ShippingSettingsServiceStub> {
    private ShippingSettingsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ShippingSettingsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ShippingSettingsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve shipping setting information.
     * </pre>
     */
    public void getShippingSettings(
        com.google.shopping.merchant.accounts.v1beta.GetShippingSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.ShippingSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetShippingSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Replace the shipping setting of a merchant with the request shipping
     * setting. Executing this method requires admin access.
     * </pre>
     */
    public void insertShippingSettings(
        com.google.shopping.merchant.accounts.v1beta.InsertShippingSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.ShippingSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInsertShippingSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ShippingSettingsService.
   *
   * <pre>
   * Service to get method call shipping setting information per Merchant API
   * method.
   * </pre>
   */
  public static final class ShippingSettingsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ShippingSettingsServiceBlockingStub> {
    private ShippingSettingsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ShippingSettingsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ShippingSettingsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve shipping setting information.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.ShippingSettings getShippingSettings(
        com.google.shopping.merchant.accounts.v1beta.GetShippingSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetShippingSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Replace the shipping setting of a merchant with the request shipping
     * setting. Executing this method requires admin access.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.ShippingSettings insertShippingSettings(
        com.google.shopping.merchant.accounts.v1beta.InsertShippingSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInsertShippingSettingsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * ShippingSettingsService.
   *
   * <pre>
   * Service to get method call shipping setting information per Merchant API
   * method.
   * </pre>
   */
  public static final class ShippingSettingsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ShippingSettingsServiceFutureStub> {
    private ShippingSettingsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ShippingSettingsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ShippingSettingsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve shipping setting information.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.ShippingSettings>
        getShippingSettings(
            com.google.shopping.merchant.accounts.v1beta.GetShippingSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetShippingSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Replace the shipping setting of a merchant with the request shipping
     * setting. Executing this method requires admin access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.ShippingSettings>
        insertShippingSettings(
            com.google.shopping.merchant.accounts.v1beta.InsertShippingSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInsertShippingSettingsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SHIPPING_SETTINGS = 0;
  private static final int METHODID_INSERT_SHIPPING_SETTINGS = 1;

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
        case METHODID_GET_SHIPPING_SETTINGS:
          serviceImpl.getShippingSettings(
              (com.google.shopping.merchant.accounts.v1beta.GetShippingSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.ShippingSettings>)
                  responseObserver);
          break;
        case METHODID_INSERT_SHIPPING_SETTINGS:
          serviceImpl.insertShippingSettings(
              (com.google.shopping.merchant.accounts.v1beta.InsertShippingSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.ShippingSettings>)
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
            getGetShippingSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.GetShippingSettingsRequest,
                    com.google.shopping.merchant.accounts.v1beta.ShippingSettings>(
                    service, METHODID_GET_SHIPPING_SETTINGS)))
        .addMethod(
            getInsertShippingSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.InsertShippingSettingsRequest,
                    com.google.shopping.merchant.accounts.v1beta.ShippingSettings>(
                    service, METHODID_INSERT_SHIPPING_SETTINGS)))
        .build();
  }

  private abstract static class ShippingSettingsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ShippingSettingsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1beta.ShippingSettingsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ShippingSettingsService");
    }
  }

  private static final class ShippingSettingsServiceFileDescriptorSupplier
      extends ShippingSettingsServiceBaseDescriptorSupplier {
    ShippingSettingsServiceFileDescriptorSupplier() {}
  }

  private static final class ShippingSettingsServiceMethodDescriptorSupplier
      extends ShippingSettingsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ShippingSettingsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ShippingSettingsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ShippingSettingsServiceFileDescriptorSupplier())
                      .addMethod(getGetShippingSettingsMethod())
                      .addMethod(getInsertShippingSettingsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
