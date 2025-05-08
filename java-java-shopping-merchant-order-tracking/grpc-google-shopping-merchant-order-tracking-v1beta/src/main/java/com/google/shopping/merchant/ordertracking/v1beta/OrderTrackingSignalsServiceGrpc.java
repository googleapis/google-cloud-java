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
package com.google.shopping.merchant.ordertracking.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to serve order tracking signals public API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/ordertracking/v1beta/order_tracking_signals.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OrderTrackingSignalsServiceGrpc {

  private OrderTrackingSignalsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.ordertracking.v1beta.OrderTrackingSignalsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.ordertracking.v1beta.CreateOrderTrackingSignalRequest,
          com.google.shopping.merchant.ordertracking.v1beta.OrderTrackingSignal>
      getCreateOrderTrackingSignalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateOrderTrackingSignal",
      requestType =
          com.google.shopping.merchant.ordertracking.v1beta.CreateOrderTrackingSignalRequest.class,
      responseType = com.google.shopping.merchant.ordertracking.v1beta.OrderTrackingSignal.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.ordertracking.v1beta.CreateOrderTrackingSignalRequest,
          com.google.shopping.merchant.ordertracking.v1beta.OrderTrackingSignal>
      getCreateOrderTrackingSignalMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.ordertracking.v1beta.CreateOrderTrackingSignalRequest,
            com.google.shopping.merchant.ordertracking.v1beta.OrderTrackingSignal>
        getCreateOrderTrackingSignalMethod;
    if ((getCreateOrderTrackingSignalMethod =
            OrderTrackingSignalsServiceGrpc.getCreateOrderTrackingSignalMethod)
        == null) {
      synchronized (OrderTrackingSignalsServiceGrpc.class) {
        if ((getCreateOrderTrackingSignalMethod =
                OrderTrackingSignalsServiceGrpc.getCreateOrderTrackingSignalMethod)
            == null) {
          OrderTrackingSignalsServiceGrpc.getCreateOrderTrackingSignalMethod =
              getCreateOrderTrackingSignalMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.ordertracking.v1beta
                              .CreateOrderTrackingSignalRequest,
                          com.google.shopping.merchant.ordertracking.v1beta.OrderTrackingSignal>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateOrderTrackingSignal"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.ordertracking.v1beta
                                  .CreateOrderTrackingSignalRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.ordertracking.v1beta.OrderTrackingSignal
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrderTrackingSignalsServiceMethodDescriptorSupplier(
                              "CreateOrderTrackingSignal"))
                      .build();
        }
      }
    }
    return getCreateOrderTrackingSignalMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static OrderTrackingSignalsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderTrackingSignalsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrderTrackingSignalsServiceStub>() {
          @java.lang.Override
          public OrderTrackingSignalsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrderTrackingSignalsServiceStub(channel, callOptions);
          }
        };
    return OrderTrackingSignalsServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static OrderTrackingSignalsServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderTrackingSignalsServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrderTrackingSignalsServiceBlockingV2Stub>() {
          @java.lang.Override
          public OrderTrackingSignalsServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrderTrackingSignalsServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return OrderTrackingSignalsServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrderTrackingSignalsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderTrackingSignalsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrderTrackingSignalsServiceBlockingStub>() {
          @java.lang.Override
          public OrderTrackingSignalsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrderTrackingSignalsServiceBlockingStub(channel, callOptions);
          }
        };
    return OrderTrackingSignalsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static OrderTrackingSignalsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderTrackingSignalsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrderTrackingSignalsServiceFutureStub>() {
          @java.lang.Override
          public OrderTrackingSignalsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrderTrackingSignalsServiceFutureStub(channel, callOptions);
          }
        };
    return OrderTrackingSignalsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to serve order tracking signals public API.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates new order tracking signal.
     * </pre>
     */
    default void createOrderTrackingSignal(
        com.google.shopping.merchant.ordertracking.v1beta.CreateOrderTrackingSignalRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.ordertracking.v1beta.OrderTrackingSignal>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateOrderTrackingSignalMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OrderTrackingSignalsService.
   *
   * <pre>
   * Service to serve order tracking signals public API.
   * </pre>
   */
  public abstract static class OrderTrackingSignalsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return OrderTrackingSignalsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service OrderTrackingSignalsService.
   *
   * <pre>
   * Service to serve order tracking signals public API.
   * </pre>
   */
  public static final class OrderTrackingSignalsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<OrderTrackingSignalsServiceStub> {
    private OrderTrackingSignalsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderTrackingSignalsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderTrackingSignalsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates new order tracking signal.
     * </pre>
     */
    public void createOrderTrackingSignal(
        com.google.shopping.merchant.ordertracking.v1beta.CreateOrderTrackingSignalRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.ordertracking.v1beta.OrderTrackingSignal>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateOrderTrackingSignalMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service OrderTrackingSignalsService.
   *
   * <pre>
   * Service to serve order tracking signals public API.
   * </pre>
   */
  public static final class OrderTrackingSignalsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<OrderTrackingSignalsServiceBlockingV2Stub> {
    private OrderTrackingSignalsServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderTrackingSignalsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderTrackingSignalsServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates new order tracking signal.
     * </pre>
     */
    public com.google.shopping.merchant.ordertracking.v1beta.OrderTrackingSignal
        createOrderTrackingSignal(
            com.google.shopping.merchant.ordertracking.v1beta.CreateOrderTrackingSignalRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOrderTrackingSignalMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * OrderTrackingSignalsService.
   *
   * <pre>
   * Service to serve order tracking signals public API.
   * </pre>
   */
  public static final class OrderTrackingSignalsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OrderTrackingSignalsServiceBlockingStub> {
    private OrderTrackingSignalsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderTrackingSignalsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderTrackingSignalsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates new order tracking signal.
     * </pre>
     */
    public com.google.shopping.merchant.ordertracking.v1beta.OrderTrackingSignal
        createOrderTrackingSignal(
            com.google.shopping.merchant.ordertracking.v1beta.CreateOrderTrackingSignalRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOrderTrackingSignalMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * OrderTrackingSignalsService.
   *
   * <pre>
   * Service to serve order tracking signals public API.
   * </pre>
   */
  public static final class OrderTrackingSignalsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<OrderTrackingSignalsServiceFutureStub> {
    private OrderTrackingSignalsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderTrackingSignalsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderTrackingSignalsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates new order tracking signal.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.ordertracking.v1beta.OrderTrackingSignal>
        createOrderTrackingSignal(
            com.google.shopping.merchant.ordertracking.v1beta.CreateOrderTrackingSignalRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateOrderTrackingSignalMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ORDER_TRACKING_SIGNAL = 0;

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
        case METHODID_CREATE_ORDER_TRACKING_SIGNAL:
          serviceImpl.createOrderTrackingSignal(
              (com.google.shopping.merchant.ordertracking.v1beta.CreateOrderTrackingSignalRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.ordertracking.v1beta.OrderTrackingSignal>)
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
            getCreateOrderTrackingSignalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.ordertracking.v1beta
                        .CreateOrderTrackingSignalRequest,
                    com.google.shopping.merchant.ordertracking.v1beta.OrderTrackingSignal>(
                    service, METHODID_CREATE_ORDER_TRACKING_SIGNAL)))
        .build();
  }

  private abstract static class OrderTrackingSignalsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OrderTrackingSignalsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.ordertracking.v1beta.OrderTrackingSignalsProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OrderTrackingSignalsService");
    }
  }

  private static final class OrderTrackingSignalsServiceFileDescriptorSupplier
      extends OrderTrackingSignalsServiceBaseDescriptorSupplier {
    OrderTrackingSignalsServiceFileDescriptorSupplier() {}
  }

  private static final class OrderTrackingSignalsServiceMethodDescriptorSupplier
      extends OrderTrackingSignalsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OrderTrackingSignalsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (OrderTrackingSignalsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new OrderTrackingSignalsServiceFileDescriptorSupplier())
                      .addMethod(getCreateOrderTrackingSignalMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
