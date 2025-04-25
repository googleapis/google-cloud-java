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
package com.google.cloud.commerce.consumer.procurement.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * ConsumerProcurementService allows customers to make purchases of products
 * served by the Cloud Commerce platform.
 * When purchases are made, the
 * [ConsumerProcurementService][google.cloud.commerce.consumer.procurement.v1.ConsumerProcurementService]
 * programs the appropriate backends, including both Google's own
 * infrastructure, as well as third-party systems, and to enable billing setup
 * for charging for the procured item.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/commerce/consumer/procurement/v1/procurement_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConsumerProcurementServiceGrpc {

  private ConsumerProcurementServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.commerce.consumer.procurement.v1.ConsumerProcurementService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerce.consumer.procurement.v1.PlaceOrderRequest,
          com.google.longrunning.Operation>
      getPlaceOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PlaceOrder",
      requestType = com.google.cloud.commerce.consumer.procurement.v1.PlaceOrderRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerce.consumer.procurement.v1.PlaceOrderRequest,
          com.google.longrunning.Operation>
      getPlaceOrderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerce.consumer.procurement.v1.PlaceOrderRequest,
            com.google.longrunning.Operation>
        getPlaceOrderMethod;
    if ((getPlaceOrderMethod = ConsumerProcurementServiceGrpc.getPlaceOrderMethod) == null) {
      synchronized (ConsumerProcurementServiceGrpc.class) {
        if ((getPlaceOrderMethod = ConsumerProcurementServiceGrpc.getPlaceOrderMethod) == null) {
          ConsumerProcurementServiceGrpc.getPlaceOrderMethod =
              getPlaceOrderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerce.consumer.procurement.v1.PlaceOrderRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PlaceOrder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerce.consumer.procurement.v1.PlaceOrderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConsumerProcurementServiceMethodDescriptorSupplier("PlaceOrder"))
                      .build();
        }
      }
    }
    return getPlaceOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerce.consumer.procurement.v1.GetOrderRequest,
          com.google.cloud.commerce.consumer.procurement.v1.Order>
      getGetOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOrder",
      requestType = com.google.cloud.commerce.consumer.procurement.v1.GetOrderRequest.class,
      responseType = com.google.cloud.commerce.consumer.procurement.v1.Order.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerce.consumer.procurement.v1.GetOrderRequest,
          com.google.cloud.commerce.consumer.procurement.v1.Order>
      getGetOrderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerce.consumer.procurement.v1.GetOrderRequest,
            com.google.cloud.commerce.consumer.procurement.v1.Order>
        getGetOrderMethod;
    if ((getGetOrderMethod = ConsumerProcurementServiceGrpc.getGetOrderMethod) == null) {
      synchronized (ConsumerProcurementServiceGrpc.class) {
        if ((getGetOrderMethod = ConsumerProcurementServiceGrpc.getGetOrderMethod) == null) {
          ConsumerProcurementServiceGrpc.getGetOrderMethod =
              getGetOrderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerce.consumer.procurement.v1.GetOrderRequest,
                          com.google.cloud.commerce.consumer.procurement.v1.Order>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOrder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerce.consumer.procurement.v1.GetOrderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerce.consumer.procurement.v1.Order
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConsumerProcurementServiceMethodDescriptorSupplier("GetOrder"))
                      .build();
        }
      }
    }
    return getGetOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerce.consumer.procurement.v1.ListOrdersRequest,
          com.google.cloud.commerce.consumer.procurement.v1.ListOrdersResponse>
      getListOrdersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOrders",
      requestType = com.google.cloud.commerce.consumer.procurement.v1.ListOrdersRequest.class,
      responseType = com.google.cloud.commerce.consumer.procurement.v1.ListOrdersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerce.consumer.procurement.v1.ListOrdersRequest,
          com.google.cloud.commerce.consumer.procurement.v1.ListOrdersResponse>
      getListOrdersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerce.consumer.procurement.v1.ListOrdersRequest,
            com.google.cloud.commerce.consumer.procurement.v1.ListOrdersResponse>
        getListOrdersMethod;
    if ((getListOrdersMethod = ConsumerProcurementServiceGrpc.getListOrdersMethod) == null) {
      synchronized (ConsumerProcurementServiceGrpc.class) {
        if ((getListOrdersMethod = ConsumerProcurementServiceGrpc.getListOrdersMethod) == null) {
          ConsumerProcurementServiceGrpc.getListOrdersMethod =
              getListOrdersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerce.consumer.procurement.v1.ListOrdersRequest,
                          com.google.cloud.commerce.consumer.procurement.v1.ListOrdersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListOrders"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerce.consumer.procurement.v1.ListOrdersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerce.consumer.procurement.v1.ListOrdersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConsumerProcurementServiceMethodDescriptorSupplier("ListOrders"))
                      .build();
        }
      }
    }
    return getListOrdersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerce.consumer.procurement.v1.ModifyOrderRequest,
          com.google.longrunning.Operation>
      getModifyOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModifyOrder",
      requestType = com.google.cloud.commerce.consumer.procurement.v1.ModifyOrderRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerce.consumer.procurement.v1.ModifyOrderRequest,
          com.google.longrunning.Operation>
      getModifyOrderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerce.consumer.procurement.v1.ModifyOrderRequest,
            com.google.longrunning.Operation>
        getModifyOrderMethod;
    if ((getModifyOrderMethod = ConsumerProcurementServiceGrpc.getModifyOrderMethod) == null) {
      synchronized (ConsumerProcurementServiceGrpc.class) {
        if ((getModifyOrderMethod = ConsumerProcurementServiceGrpc.getModifyOrderMethod) == null) {
          ConsumerProcurementServiceGrpc.getModifyOrderMethod =
              getModifyOrderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerce.consumer.procurement.v1.ModifyOrderRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ModifyOrder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerce.consumer.procurement.v1.ModifyOrderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConsumerProcurementServiceMethodDescriptorSupplier("ModifyOrder"))
                      .build();
        }
      }
    }
    return getModifyOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerce.consumer.procurement.v1.CancelOrderRequest,
          com.google.longrunning.Operation>
      getCancelOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelOrder",
      requestType = com.google.cloud.commerce.consumer.procurement.v1.CancelOrderRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerce.consumer.procurement.v1.CancelOrderRequest,
          com.google.longrunning.Operation>
      getCancelOrderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerce.consumer.procurement.v1.CancelOrderRequest,
            com.google.longrunning.Operation>
        getCancelOrderMethod;
    if ((getCancelOrderMethod = ConsumerProcurementServiceGrpc.getCancelOrderMethod) == null) {
      synchronized (ConsumerProcurementServiceGrpc.class) {
        if ((getCancelOrderMethod = ConsumerProcurementServiceGrpc.getCancelOrderMethod) == null) {
          ConsumerProcurementServiceGrpc.getCancelOrderMethod =
              getCancelOrderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerce.consumer.procurement.v1.CancelOrderRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelOrder"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerce.consumer.procurement.v1.CancelOrderRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConsumerProcurementServiceMethodDescriptorSupplier("CancelOrder"))
                      .build();
        }
      }
    }
    return getCancelOrderMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ConsumerProcurementServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConsumerProcurementServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConsumerProcurementServiceStub>() {
          @java.lang.Override
          public ConsumerProcurementServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConsumerProcurementServiceStub(channel, callOptions);
          }
        };
    return ConsumerProcurementServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConsumerProcurementServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConsumerProcurementServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConsumerProcurementServiceBlockingStub>() {
          @java.lang.Override
          public ConsumerProcurementServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConsumerProcurementServiceBlockingStub(channel, callOptions);
          }
        };
    return ConsumerProcurementServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ConsumerProcurementServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConsumerProcurementServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConsumerProcurementServiceFutureStub>() {
          @java.lang.Override
          public ConsumerProcurementServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConsumerProcurementServiceFutureStub(channel, callOptions);
          }
        };
    return ConsumerProcurementServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * ConsumerProcurementService allows customers to make purchases of products
   * served by the Cloud Commerce platform.
   * When purchases are made, the
   * [ConsumerProcurementService][google.cloud.commerce.consumer.procurement.v1.ConsumerProcurementService]
   * programs the appropriate backends, including both Google's own
   * infrastructure, as well as third-party systems, and to enable billing setup
   * for charging for the procured item.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new [Order][google.cloud.commerce.consumer.procurement.v1.Order].
     * This API only supports GCP spend-based committed use
     * discounts specified by GCP documentation.
     * The returned long-running operation is in-progress until the backend
     * completes the creation of the resource. Once completed, the order is
     * in
     * [OrderState.ORDER_STATE_ACTIVE][google.cloud.commerce.consumer.procurement.v1.OrderState.ORDER_STATE_ACTIVE].
     * In case of failure, the order resource will be removed.
     * </pre>
     */
    default void placeOrder(
        com.google.cloud.commerce.consumer.procurement.v1.PlaceOrderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPlaceOrderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested
     * [Order][google.cloud.commerce.consumer.procurement.v1.Order] resource.
     * </pre>
     */
    default void getOrder(
        com.google.cloud.commerce.consumer.procurement.v1.GetOrderRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerce.consumer.procurement.v1.Order>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetOrderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [Order][google.cloud.commerce.consumer.procurement.v1.Order]
     * resources that the user has access to, within the scope of the parent
     * resource.
     * </pre>
     */
    default void listOrders(
        com.google.cloud.commerce.consumer.procurement.v1.ListOrdersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.commerce.consumer.procurement.v1.ListOrdersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListOrdersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies an existing
     * [Order][google.cloud.commerce.consumer.procurement.v1.Order] resource.
     * </pre>
     */
    default void modifyOrder(
        com.google.cloud.commerce.consumer.procurement.v1.ModifyOrderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getModifyOrderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels an existing
     * [Order][google.cloud.commerce.consumer.procurement.v1.Order]. Every product
     * procured in the Order will be cancelled.
     * </pre>
     */
    default void cancelOrder(
        com.google.cloud.commerce.consumer.procurement.v1.CancelOrderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCancelOrderMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ConsumerProcurementService.
   *
   * <pre>
   * ConsumerProcurementService allows customers to make purchases of products
   * served by the Cloud Commerce platform.
   * When purchases are made, the
   * [ConsumerProcurementService][google.cloud.commerce.consumer.procurement.v1.ConsumerProcurementService]
   * programs the appropriate backends, including both Google's own
   * infrastructure, as well as third-party systems, and to enable billing setup
   * for charging for the procured item.
   * </pre>
   */
  public abstract static class ConsumerProcurementServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ConsumerProcurementServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ConsumerProcurementService.
   *
   * <pre>
   * ConsumerProcurementService allows customers to make purchases of products
   * served by the Cloud Commerce platform.
   * When purchases are made, the
   * [ConsumerProcurementService][google.cloud.commerce.consumer.procurement.v1.ConsumerProcurementService]
   * programs the appropriate backends, including both Google's own
   * infrastructure, as well as third-party systems, and to enable billing setup
   * for charging for the procured item.
   * </pre>
   */
  public static final class ConsumerProcurementServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ConsumerProcurementServiceStub> {
    private ConsumerProcurementServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConsumerProcurementServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConsumerProcurementServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [Order][google.cloud.commerce.consumer.procurement.v1.Order].
     * This API only supports GCP spend-based committed use
     * discounts specified by GCP documentation.
     * The returned long-running operation is in-progress until the backend
     * completes the creation of the resource. Once completed, the order is
     * in
     * [OrderState.ORDER_STATE_ACTIVE][google.cloud.commerce.consumer.procurement.v1.OrderState.ORDER_STATE_ACTIVE].
     * In case of failure, the order resource will be removed.
     * </pre>
     */
    public void placeOrder(
        com.google.cloud.commerce.consumer.procurement.v1.PlaceOrderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPlaceOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested
     * [Order][google.cloud.commerce.consumer.procurement.v1.Order] resource.
     * </pre>
     */
    public void getOrder(
        com.google.cloud.commerce.consumer.procurement.v1.GetOrderRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerce.consumer.procurement.v1.Order>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [Order][google.cloud.commerce.consumer.procurement.v1.Order]
     * resources that the user has access to, within the scope of the parent
     * resource.
     * </pre>
     */
    public void listOrders(
        com.google.cloud.commerce.consumer.procurement.v1.ListOrdersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.commerce.consumer.procurement.v1.ListOrdersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOrdersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies an existing
     * [Order][google.cloud.commerce.consumer.procurement.v1.Order] resource.
     * </pre>
     */
    public void modifyOrder(
        com.google.cloud.commerce.consumer.procurement.v1.ModifyOrderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getModifyOrderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels an existing
     * [Order][google.cloud.commerce.consumer.procurement.v1.Order]. Every product
     * procured in the Order will be cancelled.
     * </pre>
     */
    public void cancelOrder(
        com.google.cloud.commerce.consumer.procurement.v1.CancelOrderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelOrderMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ConsumerProcurementService.
   *
   * <pre>
   * ConsumerProcurementService allows customers to make purchases of products
   * served by the Cloud Commerce platform.
   * When purchases are made, the
   * [ConsumerProcurementService][google.cloud.commerce.consumer.procurement.v1.ConsumerProcurementService]
   * programs the appropriate backends, including both Google's own
   * infrastructure, as well as third-party systems, and to enable billing setup
   * for charging for the procured item.
   * </pre>
   */
  public static final class ConsumerProcurementServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ConsumerProcurementServiceBlockingStub> {
    private ConsumerProcurementServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConsumerProcurementServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConsumerProcurementServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [Order][google.cloud.commerce.consumer.procurement.v1.Order].
     * This API only supports GCP spend-based committed use
     * discounts specified by GCP documentation.
     * The returned long-running operation is in-progress until the backend
     * completes the creation of the resource. Once completed, the order is
     * in
     * [OrderState.ORDER_STATE_ACTIVE][google.cloud.commerce.consumer.procurement.v1.OrderState.ORDER_STATE_ACTIVE].
     * In case of failure, the order resource will be removed.
     * </pre>
     */
    public com.google.longrunning.Operation placeOrder(
        com.google.cloud.commerce.consumer.procurement.v1.PlaceOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPlaceOrderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested
     * [Order][google.cloud.commerce.consumer.procurement.v1.Order] resource.
     * </pre>
     */
    public com.google.cloud.commerce.consumer.procurement.v1.Order getOrder(
        com.google.cloud.commerce.consumer.procurement.v1.GetOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [Order][google.cloud.commerce.consumer.procurement.v1.Order]
     * resources that the user has access to, within the scope of the parent
     * resource.
     * </pre>
     */
    public com.google.cloud.commerce.consumer.procurement.v1.ListOrdersResponse listOrders(
        com.google.cloud.commerce.consumer.procurement.v1.ListOrdersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOrdersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies an existing
     * [Order][google.cloud.commerce.consumer.procurement.v1.Order] resource.
     * </pre>
     */
    public com.google.longrunning.Operation modifyOrder(
        com.google.cloud.commerce.consumer.procurement.v1.ModifyOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModifyOrderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels an existing
     * [Order][google.cloud.commerce.consumer.procurement.v1.Order]. Every product
     * procured in the Order will be cancelled.
     * </pre>
     */
    public com.google.longrunning.Operation cancelOrder(
        com.google.cloud.commerce.consumer.procurement.v1.CancelOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * ConsumerProcurementService.
   *
   * <pre>
   * ConsumerProcurementService allows customers to make purchases of products
   * served by the Cloud Commerce platform.
   * When purchases are made, the
   * [ConsumerProcurementService][google.cloud.commerce.consumer.procurement.v1.ConsumerProcurementService]
   * programs the appropriate backends, including both Google's own
   * infrastructure, as well as third-party systems, and to enable billing setup
   * for charging for the procured item.
   * </pre>
   */
  public static final class ConsumerProcurementServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ConsumerProcurementServiceFutureStub> {
    private ConsumerProcurementServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConsumerProcurementServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConsumerProcurementServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [Order][google.cloud.commerce.consumer.procurement.v1.Order].
     * This API only supports GCP spend-based committed use
     * discounts specified by GCP documentation.
     * The returned long-running operation is in-progress until the backend
     * completes the creation of the resource. Once completed, the order is
     * in
     * [OrderState.ORDER_STATE_ACTIVE][google.cloud.commerce.consumer.procurement.v1.OrderState.ORDER_STATE_ACTIVE].
     * In case of failure, the order resource will be removed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        placeOrder(com.google.cloud.commerce.consumer.procurement.v1.PlaceOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPlaceOrderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the requested
     * [Order][google.cloud.commerce.consumer.procurement.v1.Order] resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerce.consumer.procurement.v1.Order>
        getOrder(com.google.cloud.commerce.consumer.procurement.v1.GetOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOrderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [Order][google.cloud.commerce.consumer.procurement.v1.Order]
     * resources that the user has access to, within the scope of the parent
     * resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerce.consumer.procurement.v1.ListOrdersResponse>
        listOrders(com.google.cloud.commerce.consumer.procurement.v1.ListOrdersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOrdersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies an existing
     * [Order][google.cloud.commerce.consumer.procurement.v1.Order] resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        modifyOrder(com.google.cloud.commerce.consumer.procurement.v1.ModifyOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getModifyOrderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels an existing
     * [Order][google.cloud.commerce.consumer.procurement.v1.Order]. Every product
     * procured in the Order will be cancelled.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        cancelOrder(com.google.cloud.commerce.consumer.procurement.v1.CancelOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PLACE_ORDER = 0;
  private static final int METHODID_GET_ORDER = 1;
  private static final int METHODID_LIST_ORDERS = 2;
  private static final int METHODID_MODIFY_ORDER = 3;
  private static final int METHODID_CANCEL_ORDER = 4;

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
        case METHODID_PLACE_ORDER:
          serviceImpl.placeOrder(
              (com.google.cloud.commerce.consumer.procurement.v1.PlaceOrderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ORDER:
          serviceImpl.getOrder(
              (com.google.cloud.commerce.consumer.procurement.v1.GetOrderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.commerce.consumer.procurement.v1.Order>)
                  responseObserver);
          break;
        case METHODID_LIST_ORDERS:
          serviceImpl.listOrders(
              (com.google.cloud.commerce.consumer.procurement.v1.ListOrdersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.commerce.consumer.procurement.v1.ListOrdersResponse>)
                  responseObserver);
          break;
        case METHODID_MODIFY_ORDER:
          serviceImpl.modifyOrder(
              (com.google.cloud.commerce.consumer.procurement.v1.ModifyOrderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CANCEL_ORDER:
          serviceImpl.cancelOrder(
              (com.google.cloud.commerce.consumer.procurement.v1.CancelOrderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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
            getPlaceOrderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerce.consumer.procurement.v1.PlaceOrderRequest,
                    com.google.longrunning.Operation>(service, METHODID_PLACE_ORDER)))
        .addMethod(
            getGetOrderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerce.consumer.procurement.v1.GetOrderRequest,
                    com.google.cloud.commerce.consumer.procurement.v1.Order>(
                    service, METHODID_GET_ORDER)))
        .addMethod(
            getListOrdersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerce.consumer.procurement.v1.ListOrdersRequest,
                    com.google.cloud.commerce.consumer.procurement.v1.ListOrdersResponse>(
                    service, METHODID_LIST_ORDERS)))
        .addMethod(
            getModifyOrderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerce.consumer.procurement.v1.ModifyOrderRequest,
                    com.google.longrunning.Operation>(service, METHODID_MODIFY_ORDER)))
        .addMethod(
            getCancelOrderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerce.consumer.procurement.v1.CancelOrderRequest,
                    com.google.longrunning.Operation>(service, METHODID_CANCEL_ORDER)))
        .build();
  }

  private abstract static class ConsumerProcurementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConsumerProcurementServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.commerce.consumer.procurement.v1.ProcurementService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConsumerProcurementService");
    }
  }

  private static final class ConsumerProcurementServiceFileDescriptorSupplier
      extends ConsumerProcurementServiceBaseDescriptorSupplier {
    ConsumerProcurementServiceFileDescriptorSupplier() {}
  }

  private static final class ConsumerProcurementServiceMethodDescriptorSupplier
      extends ConsumerProcurementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ConsumerProcurementServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ConsumerProcurementServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ConsumerProcurementServiceFileDescriptorSupplier())
                      .addMethod(getPlaceOrderMethod())
                      .addMethod(getGetOrderMethod())
                      .addMethod(getListOrdersMethod())
                      .addMethod(getModifyOrderMethod())
                      .addMethod(getCancelOrderMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
