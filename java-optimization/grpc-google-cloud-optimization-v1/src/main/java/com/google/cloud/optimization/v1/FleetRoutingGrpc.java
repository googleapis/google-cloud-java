/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.optimization.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service for optimizing vehicle tours.
 * Validity of certain types of fields:
 *   * `google.protobuf.Timestamp`
 *     * Times are in Unix time: seconds since 1970-01-01T00:00:00+00:00.
 *     * seconds must be in [0, 253402300799],
 *       i.e. in [1970-01-01T00:00:00+00:00, 9999-12-31T23:59:59+00:00].
 *     * nanos must be unset or set to 0.
 *   * `google.protobuf.Duration`
 *     * seconds must be in [0, 253402300799],
 *       i.e. in [1970-01-01T00:00:00+00:00, 9999-12-31T23:59:59+00:00].
 *     * nanos must be unset or set to 0.
 *   * `google.type.LatLng`
 *     * latitude must be in [-90.0, 90.0].
 *     * longitude must be in [-180.0, 180.0].
 *     * at least one of latitude and longitude must be non-zero.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/optimization/v1/fleet_routing.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FleetRoutingGrpc {

  private FleetRoutingGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.optimization.v1.FleetRouting";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.optimization.v1.OptimizeToursRequest,
          com.google.cloud.optimization.v1.OptimizeToursResponse>
      getOptimizeToursMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OptimizeTours",
      requestType = com.google.cloud.optimization.v1.OptimizeToursRequest.class,
      responseType = com.google.cloud.optimization.v1.OptimizeToursResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.optimization.v1.OptimizeToursRequest,
          com.google.cloud.optimization.v1.OptimizeToursResponse>
      getOptimizeToursMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.optimization.v1.OptimizeToursRequest,
            com.google.cloud.optimization.v1.OptimizeToursResponse>
        getOptimizeToursMethod;
    if ((getOptimizeToursMethod = FleetRoutingGrpc.getOptimizeToursMethod) == null) {
      synchronized (FleetRoutingGrpc.class) {
        if ((getOptimizeToursMethod = FleetRoutingGrpc.getOptimizeToursMethod) == null) {
          FleetRoutingGrpc.getOptimizeToursMethod =
              getOptimizeToursMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.optimization.v1.OptimizeToursRequest,
                          com.google.cloud.optimization.v1.OptimizeToursResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OptimizeTours"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.optimization.v1.OptimizeToursRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.optimization.v1.OptimizeToursResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FleetRoutingMethodDescriptorSupplier("OptimizeTours"))
                      .build();
        }
      }
    }
    return getOptimizeToursMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.optimization.v1.BatchOptimizeToursRequest,
          com.google.longrunning.Operation>
      getBatchOptimizeToursMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchOptimizeTours",
      requestType = com.google.cloud.optimization.v1.BatchOptimizeToursRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.optimization.v1.BatchOptimizeToursRequest,
          com.google.longrunning.Operation>
      getBatchOptimizeToursMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.optimization.v1.BatchOptimizeToursRequest,
            com.google.longrunning.Operation>
        getBatchOptimizeToursMethod;
    if ((getBatchOptimizeToursMethod = FleetRoutingGrpc.getBatchOptimizeToursMethod) == null) {
      synchronized (FleetRoutingGrpc.class) {
        if ((getBatchOptimizeToursMethod = FleetRoutingGrpc.getBatchOptimizeToursMethod) == null) {
          FleetRoutingGrpc.getBatchOptimizeToursMethod =
              getBatchOptimizeToursMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.optimization.v1.BatchOptimizeToursRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchOptimizeTours"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.optimization.v1.BatchOptimizeToursRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FleetRoutingMethodDescriptorSupplier("BatchOptimizeTours"))
                      .build();
        }
      }
    }
    return getBatchOptimizeToursMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static FleetRoutingStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FleetRoutingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FleetRoutingStub>() {
          @java.lang.Override
          public FleetRoutingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FleetRoutingStub(channel, callOptions);
          }
        };
    return FleetRoutingStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FleetRoutingBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FleetRoutingBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FleetRoutingBlockingStub>() {
          @java.lang.Override
          public FleetRoutingBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FleetRoutingBlockingStub(channel, callOptions);
          }
        };
    return FleetRoutingBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static FleetRoutingFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FleetRoutingFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FleetRoutingFutureStub>() {
          @java.lang.Override
          public FleetRoutingFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FleetRoutingFutureStub(channel, callOptions);
          }
        };
    return FleetRoutingFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service for optimizing vehicle tours.
   * Validity of certain types of fields:
   *   * `google.protobuf.Timestamp`
   *     * Times are in Unix time: seconds since 1970-01-01T00:00:00+00:00.
   *     * seconds must be in [0, 253402300799],
   *       i.e. in [1970-01-01T00:00:00+00:00, 9999-12-31T23:59:59+00:00].
   *     * nanos must be unset or set to 0.
   *   * `google.protobuf.Duration`
   *     * seconds must be in [0, 253402300799],
   *       i.e. in [1970-01-01T00:00:00+00:00, 9999-12-31T23:59:59+00:00].
   *     * nanos must be unset or set to 0.
   *   * `google.type.LatLng`
   *     * latitude must be in [-90.0, 90.0].
   *     * longitude must be in [-180.0, 180.0].
   *     * at least one of latitude and longitude must be non-zero.
   * </pre>
   */
  public abstract static class FleetRoutingImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Sends an `OptimizeToursRequest` containing a `ShipmentModel` and returns an
     * `OptimizeToursResponse` containing `ShipmentRoute`s, which are a set of
     * routes to be performed by vehicles minimizing the overall cost.
     * A `ShipmentModel` model consists mainly of `Shipment`s that need to be
     * carried out and `Vehicle`s that can be used to transport the `Shipment`s.
     * The `ShipmentRoute`s assign `Shipment`s to `Vehicle`s. More specifically,
     * they assign a series of `Visit`s to each vehicle, where a `Visit`
     * corresponds to a `VisitRequest`, which is a pickup or delivery for a
     * `Shipment`.
     * The goal is to provide an assignment of `ShipmentRoute`s to `Vehicle`s that
     * minimizes the total cost where cost has many components defined in the
     * `ShipmentModel`.
     * </pre>
     */
    public void optimizeTours(
        com.google.cloud.optimization.v1.OptimizeToursRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.optimization.v1.OptimizeToursResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getOptimizeToursMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Optimizes vehicle tours for one or more `OptimizeToursRequest`
     * messages as a batch.
     * This method is a Long Running Operation (LRO). The inputs for optimization
     * (`OptimizeToursRequest` messages) and outputs (`OptimizeToursResponse`
     * messages) are read/written from/to Cloud Storage in user-specified
     * format. Like the `OptimizeTours` method, each `OptimizeToursRequest`
     * contains a `ShipmentModel` and returns an `OptimizeToursResponse`
     * containing `ShipmentRoute`s, which are a set of routes to be performed by
     * vehicles minimizing the overall cost.
     * </pre>
     */
    public void batchOptimizeTours(
        com.google.cloud.optimization.v1.BatchOptimizeToursRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchOptimizeToursMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getOptimizeToursMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.optimization.v1.OptimizeToursRequest,
                      com.google.cloud.optimization.v1.OptimizeToursResponse>(
                      this, METHODID_OPTIMIZE_TOURS)))
          .addMethod(
              getBatchOptimizeToursMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.optimization.v1.BatchOptimizeToursRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_OPTIMIZE_TOURS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * A service for optimizing vehicle tours.
   * Validity of certain types of fields:
   *   * `google.protobuf.Timestamp`
   *     * Times are in Unix time: seconds since 1970-01-01T00:00:00+00:00.
   *     * seconds must be in [0, 253402300799],
   *       i.e. in [1970-01-01T00:00:00+00:00, 9999-12-31T23:59:59+00:00].
   *     * nanos must be unset or set to 0.
   *   * `google.protobuf.Duration`
   *     * seconds must be in [0, 253402300799],
   *       i.e. in [1970-01-01T00:00:00+00:00, 9999-12-31T23:59:59+00:00].
   *     * nanos must be unset or set to 0.
   *   * `google.type.LatLng`
   *     * latitude must be in [-90.0, 90.0].
   *     * longitude must be in [-180.0, 180.0].
   *     * at least one of latitude and longitude must be non-zero.
   * </pre>
   */
  public static final class FleetRoutingStub
      extends io.grpc.stub.AbstractAsyncStub<FleetRoutingStub> {
    private FleetRoutingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FleetRoutingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FleetRoutingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Sends an `OptimizeToursRequest` containing a `ShipmentModel` and returns an
     * `OptimizeToursResponse` containing `ShipmentRoute`s, which are a set of
     * routes to be performed by vehicles minimizing the overall cost.
     * A `ShipmentModel` model consists mainly of `Shipment`s that need to be
     * carried out and `Vehicle`s that can be used to transport the `Shipment`s.
     * The `ShipmentRoute`s assign `Shipment`s to `Vehicle`s. More specifically,
     * they assign a series of `Visit`s to each vehicle, where a `Visit`
     * corresponds to a `VisitRequest`, which is a pickup or delivery for a
     * `Shipment`.
     * The goal is to provide an assignment of `ShipmentRoute`s to `Vehicle`s that
     * minimizes the total cost where cost has many components defined in the
     * `ShipmentModel`.
     * </pre>
     */
    public void optimizeTours(
        com.google.cloud.optimization.v1.OptimizeToursRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.optimization.v1.OptimizeToursResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOptimizeToursMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Optimizes vehicle tours for one or more `OptimizeToursRequest`
     * messages as a batch.
     * This method is a Long Running Operation (LRO). The inputs for optimization
     * (`OptimizeToursRequest` messages) and outputs (`OptimizeToursResponse`
     * messages) are read/written from/to Cloud Storage in user-specified
     * format. Like the `OptimizeTours` method, each `OptimizeToursRequest`
     * contains a `ShipmentModel` and returns an `OptimizeToursResponse`
     * containing `ShipmentRoute`s, which are a set of routes to be performed by
     * vehicles minimizing the overall cost.
     * </pre>
     */
    public void batchOptimizeTours(
        com.google.cloud.optimization.v1.BatchOptimizeToursRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchOptimizeToursMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * A service for optimizing vehicle tours.
   * Validity of certain types of fields:
   *   * `google.protobuf.Timestamp`
   *     * Times are in Unix time: seconds since 1970-01-01T00:00:00+00:00.
   *     * seconds must be in [0, 253402300799],
   *       i.e. in [1970-01-01T00:00:00+00:00, 9999-12-31T23:59:59+00:00].
   *     * nanos must be unset or set to 0.
   *   * `google.protobuf.Duration`
   *     * seconds must be in [0, 253402300799],
   *       i.e. in [1970-01-01T00:00:00+00:00, 9999-12-31T23:59:59+00:00].
   *     * nanos must be unset or set to 0.
   *   * `google.type.LatLng`
   *     * latitude must be in [-90.0, 90.0].
   *     * longitude must be in [-180.0, 180.0].
   *     * at least one of latitude and longitude must be non-zero.
   * </pre>
   */
  public static final class FleetRoutingBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FleetRoutingBlockingStub> {
    private FleetRoutingBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FleetRoutingBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FleetRoutingBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Sends an `OptimizeToursRequest` containing a `ShipmentModel` and returns an
     * `OptimizeToursResponse` containing `ShipmentRoute`s, which are a set of
     * routes to be performed by vehicles minimizing the overall cost.
     * A `ShipmentModel` model consists mainly of `Shipment`s that need to be
     * carried out and `Vehicle`s that can be used to transport the `Shipment`s.
     * The `ShipmentRoute`s assign `Shipment`s to `Vehicle`s. More specifically,
     * they assign a series of `Visit`s to each vehicle, where a `Visit`
     * corresponds to a `VisitRequest`, which is a pickup or delivery for a
     * `Shipment`.
     * The goal is to provide an assignment of `ShipmentRoute`s to `Vehicle`s that
     * minimizes the total cost where cost has many components defined in the
     * `ShipmentModel`.
     * </pre>
     */
    public com.google.cloud.optimization.v1.OptimizeToursResponse optimizeTours(
        com.google.cloud.optimization.v1.OptimizeToursRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOptimizeToursMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Optimizes vehicle tours for one or more `OptimizeToursRequest`
     * messages as a batch.
     * This method is a Long Running Operation (LRO). The inputs for optimization
     * (`OptimizeToursRequest` messages) and outputs (`OptimizeToursResponse`
     * messages) are read/written from/to Cloud Storage in user-specified
     * format. Like the `OptimizeTours` method, each `OptimizeToursRequest`
     * contains a `ShipmentModel` and returns an `OptimizeToursResponse`
     * containing `ShipmentRoute`s, which are a set of routes to be performed by
     * vehicles minimizing the overall cost.
     * </pre>
     */
    public com.google.longrunning.Operation batchOptimizeTours(
        com.google.cloud.optimization.v1.BatchOptimizeToursRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchOptimizeToursMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * A service for optimizing vehicle tours.
   * Validity of certain types of fields:
   *   * `google.protobuf.Timestamp`
   *     * Times are in Unix time: seconds since 1970-01-01T00:00:00+00:00.
   *     * seconds must be in [0, 253402300799],
   *       i.e. in [1970-01-01T00:00:00+00:00, 9999-12-31T23:59:59+00:00].
   *     * nanos must be unset or set to 0.
   *   * `google.protobuf.Duration`
   *     * seconds must be in [0, 253402300799],
   *       i.e. in [1970-01-01T00:00:00+00:00, 9999-12-31T23:59:59+00:00].
   *     * nanos must be unset or set to 0.
   *   * `google.type.LatLng`
   *     * latitude must be in [-90.0, 90.0].
   *     * longitude must be in [-180.0, 180.0].
   *     * at least one of latitude and longitude must be non-zero.
   * </pre>
   */
  public static final class FleetRoutingFutureStub
      extends io.grpc.stub.AbstractFutureStub<FleetRoutingFutureStub> {
    private FleetRoutingFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FleetRoutingFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FleetRoutingFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Sends an `OptimizeToursRequest` containing a `ShipmentModel` and returns an
     * `OptimizeToursResponse` containing `ShipmentRoute`s, which are a set of
     * routes to be performed by vehicles minimizing the overall cost.
     * A `ShipmentModel` model consists mainly of `Shipment`s that need to be
     * carried out and `Vehicle`s that can be used to transport the `Shipment`s.
     * The `ShipmentRoute`s assign `Shipment`s to `Vehicle`s. More specifically,
     * they assign a series of `Visit`s to each vehicle, where a `Visit`
     * corresponds to a `VisitRequest`, which is a pickup or delivery for a
     * `Shipment`.
     * The goal is to provide an assignment of `ShipmentRoute`s to `Vehicle`s that
     * minimizes the total cost where cost has many components defined in the
     * `ShipmentModel`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.optimization.v1.OptimizeToursResponse>
        optimizeTours(com.google.cloud.optimization.v1.OptimizeToursRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOptimizeToursMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Optimizes vehicle tours for one or more `OptimizeToursRequest`
     * messages as a batch.
     * This method is a Long Running Operation (LRO). The inputs for optimization
     * (`OptimizeToursRequest` messages) and outputs (`OptimizeToursResponse`
     * messages) are read/written from/to Cloud Storage in user-specified
     * format. Like the `OptimizeTours` method, each `OptimizeToursRequest`
     * contains a `ShipmentModel` and returns an `OptimizeToursResponse`
     * containing `ShipmentRoute`s, which are a set of routes to be performed by
     * vehicles minimizing the overall cost.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchOptimizeTours(com.google.cloud.optimization.v1.BatchOptimizeToursRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchOptimizeToursMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_OPTIMIZE_TOURS = 0;
  private static final int METHODID_BATCH_OPTIMIZE_TOURS = 1;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FleetRoutingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FleetRoutingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_OPTIMIZE_TOURS:
          serviceImpl.optimizeTours(
              (com.google.cloud.optimization.v1.OptimizeToursRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.optimization.v1.OptimizeToursResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_OPTIMIZE_TOURS:
          serviceImpl.batchOptimizeTours(
              (com.google.cloud.optimization.v1.BatchOptimizeToursRequest) request,
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

  private abstract static class FleetRoutingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FleetRoutingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.optimization.v1.FleetRoutingProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FleetRouting");
    }
  }

  private static final class FleetRoutingFileDescriptorSupplier
      extends FleetRoutingBaseDescriptorSupplier {
    FleetRoutingFileDescriptorSupplier() {}
  }

  private static final class FleetRoutingMethodDescriptorSupplier
      extends FleetRoutingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FleetRoutingMethodDescriptorSupplier(String methodName) {
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
      synchronized (FleetRoutingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new FleetRoutingFileDescriptorSupplier())
                      .addMethod(getOptimizeToursMethod())
                      .addMethod(getBatchOptimizeToursMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
