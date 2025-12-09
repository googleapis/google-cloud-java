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
package com.google.maps.routeoptimization.v1;

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
@io.grpc.stub.annotations.GrpcGenerated
public final class RouteOptimizationGrpc {

  private RouteOptimizationGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.maps.routeoptimization.v1.RouteOptimization";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.routeoptimization.v1.OptimizeToursRequest,
          com.google.maps.routeoptimization.v1.OptimizeToursResponse>
      getOptimizeToursMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OptimizeTours",
      requestType = com.google.maps.routeoptimization.v1.OptimizeToursRequest.class,
      responseType = com.google.maps.routeoptimization.v1.OptimizeToursResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.routeoptimization.v1.OptimizeToursRequest,
          com.google.maps.routeoptimization.v1.OptimizeToursResponse>
      getOptimizeToursMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.routeoptimization.v1.OptimizeToursRequest,
            com.google.maps.routeoptimization.v1.OptimizeToursResponse>
        getOptimizeToursMethod;
    if ((getOptimizeToursMethod = RouteOptimizationGrpc.getOptimizeToursMethod) == null) {
      synchronized (RouteOptimizationGrpc.class) {
        if ((getOptimizeToursMethod = RouteOptimizationGrpc.getOptimizeToursMethod) == null) {
          RouteOptimizationGrpc.getOptimizeToursMethod =
              getOptimizeToursMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.routeoptimization.v1.OptimizeToursRequest,
                          com.google.maps.routeoptimization.v1.OptimizeToursResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OptimizeTours"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.routeoptimization.v1.OptimizeToursRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.routeoptimization.v1.OptimizeToursResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RouteOptimizationMethodDescriptorSupplier("OptimizeTours"))
                      .build();
        }
      }
    }
    return getOptimizeToursMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.routeoptimization.v1.BatchOptimizeToursRequest,
          com.google.longrunning.Operation>
      getBatchOptimizeToursMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchOptimizeTours",
      requestType = com.google.maps.routeoptimization.v1.BatchOptimizeToursRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.routeoptimization.v1.BatchOptimizeToursRequest,
          com.google.longrunning.Operation>
      getBatchOptimizeToursMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.routeoptimization.v1.BatchOptimizeToursRequest,
            com.google.longrunning.Operation>
        getBatchOptimizeToursMethod;
    if ((getBatchOptimizeToursMethod = RouteOptimizationGrpc.getBatchOptimizeToursMethod) == null) {
      synchronized (RouteOptimizationGrpc.class) {
        if ((getBatchOptimizeToursMethod = RouteOptimizationGrpc.getBatchOptimizeToursMethod)
            == null) {
          RouteOptimizationGrpc.getBatchOptimizeToursMethod =
              getBatchOptimizeToursMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.routeoptimization.v1.BatchOptimizeToursRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchOptimizeTours"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.routeoptimization.v1.BatchOptimizeToursRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RouteOptimizationMethodDescriptorSupplier("BatchOptimizeTours"))
                      .build();
        }
      }
    }
    return getBatchOptimizeToursMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.routeoptimization.v1.OptimizeToursRequest,
          com.google.longrunning.Operation>
      getOptimizeToursLongRunningMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OptimizeToursLongRunning",
      requestType = com.google.maps.routeoptimization.v1.OptimizeToursRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.routeoptimization.v1.OptimizeToursRequest,
          com.google.longrunning.Operation>
      getOptimizeToursLongRunningMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.routeoptimization.v1.OptimizeToursRequest,
            com.google.longrunning.Operation>
        getOptimizeToursLongRunningMethod;
    if ((getOptimizeToursLongRunningMethod =
            RouteOptimizationGrpc.getOptimizeToursLongRunningMethod)
        == null) {
      synchronized (RouteOptimizationGrpc.class) {
        if ((getOptimizeToursLongRunningMethod =
                RouteOptimizationGrpc.getOptimizeToursLongRunningMethod)
            == null) {
          RouteOptimizationGrpc.getOptimizeToursLongRunningMethod =
              getOptimizeToursLongRunningMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.routeoptimization.v1.OptimizeToursRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "OptimizeToursLongRunning"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.routeoptimization.v1.OptimizeToursRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RouteOptimizationMethodDescriptorSupplier("OptimizeToursLongRunning"))
                      .build();
        }
      }
    }
    return getOptimizeToursLongRunningMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.routeoptimization.v1.OptimizeToursUriRequest,
          com.google.longrunning.Operation>
      getOptimizeToursUriMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OptimizeToursUri",
      requestType = com.google.maps.routeoptimization.v1.OptimizeToursUriRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.routeoptimization.v1.OptimizeToursUriRequest,
          com.google.longrunning.Operation>
      getOptimizeToursUriMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.routeoptimization.v1.OptimizeToursUriRequest,
            com.google.longrunning.Operation>
        getOptimizeToursUriMethod;
    if ((getOptimizeToursUriMethod = RouteOptimizationGrpc.getOptimizeToursUriMethod) == null) {
      synchronized (RouteOptimizationGrpc.class) {
        if ((getOptimizeToursUriMethod = RouteOptimizationGrpc.getOptimizeToursUriMethod) == null) {
          RouteOptimizationGrpc.getOptimizeToursUriMethod =
              getOptimizeToursUriMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.routeoptimization.v1.OptimizeToursUriRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OptimizeToursUri"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.routeoptimization.v1.OptimizeToursUriRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RouteOptimizationMethodDescriptorSupplier("OptimizeToursUri"))
                      .build();
        }
      }
    }
    return getOptimizeToursUriMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static RouteOptimizationStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RouteOptimizationStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RouteOptimizationStub>() {
          @java.lang.Override
          public RouteOptimizationStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RouteOptimizationStub(channel, callOptions);
          }
        };
    return RouteOptimizationStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static RouteOptimizationBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RouteOptimizationBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RouteOptimizationBlockingV2Stub>() {
          @java.lang.Override
          public RouteOptimizationBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RouteOptimizationBlockingV2Stub(channel, callOptions);
          }
        };
    return RouteOptimizationBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RouteOptimizationBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RouteOptimizationBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RouteOptimizationBlockingStub>() {
          @java.lang.Override
          public RouteOptimizationBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RouteOptimizationBlockingStub(channel, callOptions);
          }
        };
    return RouteOptimizationBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RouteOptimizationFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RouteOptimizationFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RouteOptimizationFutureStub>() {
          @java.lang.Override
          public RouteOptimizationFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RouteOptimizationFutureStub(channel, callOptions);
          }
        };
    return RouteOptimizationFutureStub.newStub(factory, channel);
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
  public interface AsyncService {

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
    default void optimizeTours(
        com.google.maps.routeoptimization.v1.OptimizeToursRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.routeoptimization.v1.OptimizeToursResponse>
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
     * messages) are read from and written to Cloud Storage in user-specified
     * format. Like the `OptimizeTours` method, each `OptimizeToursRequest`
     * contains a `ShipmentModel` and returns an `OptimizeToursResponse`
     * containing `ShipmentRoute` fields, which are a set of routes to be
     * performed by vehicles minimizing the overall cost.
     * The user can poll `operations.get` to check the status of the LRO:
     * If the LRO `done` field is false, then at least one request is still
     * being processed. Other requests may have completed successfully and their
     * results are available in Cloud Storage.
     * If the LRO's `done` field is true, then all requests have been processed.
     * Any successfully processed requests will have their results available in
     * Cloud Storage. Any requests that failed will not have their results
     * available in Cloud Storage. If the LRO's `error` field is set, then it
     * contains the error from one of the failed requests.
     * </pre>
     */
    default void batchOptimizeTours(
        com.google.maps.routeoptimization.v1.BatchOptimizeToursRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchOptimizeToursMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This is a variant of the
     * [OptimizeTours][google.maps.routeoptimization.v1.RouteOptimization.OptimizeTours]
     * method designed for
     * optimizations with large timeout values. It should be preferred over the
     * `OptimizeTours` method for optimizations that take longer than
     * a few minutes.
     * The returned [long-running operation][google.longrunning.Operation] (LRO)
     * will have a name of the format
     * `&lt;parent&gt;/operations/&lt;operation_id&gt;` and can be used to track
     * progress of the computation. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [OptimizeToursLongRunningMetadata][google.maps.routeoptimization.v1.OptimizeToursLongRunningMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [OptimizeToursResponse][google.maps.routeoptimization.v1.OptimizeToursResponse],
     * if successful.
     * Experimental: See
     * https://developers.google.com/maps/tt/route-optimization/experimental/otlr/make-request
     * for more details.
     * </pre>
     */
    default void optimizeToursLongRunning(
        com.google.maps.routeoptimization.v1.OptimizeToursRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getOptimizeToursLongRunningMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This is a variant of the
     * [OptimizeToursLongRunning][google.maps.routeoptimization.v1.RouteOptimization.OptimizeToursLongRunning]
     * method designed for optimizations with large timeout values and large
     * input/output sizes.
     * The client specifies the URI of the `OptimizeToursRequest` stored
     * in Google Cloud Storage and the server writes the `OptimizeToursResponse`
     * to a client-specified Google Cloud Storage URI.
     * This method should be preferred over the `OptimizeTours` method for
     * optimizations that take longer than a few minutes and input/output sizes
     * that are larger than 8MB, though it can be used for shorter and smaller
     * optimizations as well.
     * The returned [long-running operation][google.longrunning.Operation] (LRO)
     * will have a name of the format
     * `&lt;parent&gt;/operations/&lt;operation_id&gt;` and can be used to track
     * progress of the computation. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [OptimizeToursLongRunningMetadata][google.maps.routeoptimization.v1.OptimizeToursUriMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [OptimizeToursUriResponse][google.maps.routeoptimization.v1.OptimizeToursUriResponse],
     * if successful.
     * Experimental: See
     * https://developers.google.com/maps/tt/route-optimization/experimental/otlr/make-request
     * for more details.
     * </pre>
     */
    default void optimizeToursUri(
        com.google.maps.routeoptimization.v1.OptimizeToursUriRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getOptimizeToursUriMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RouteOptimization.
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
  public abstract static class RouteOptimizationImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return RouteOptimizationGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RouteOptimization.
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
  public static final class RouteOptimizationStub
      extends io.grpc.stub.AbstractAsyncStub<RouteOptimizationStub> {
    private RouteOptimizationStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteOptimizationStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RouteOptimizationStub(channel, callOptions);
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
        com.google.maps.routeoptimization.v1.OptimizeToursRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.routeoptimization.v1.OptimizeToursResponse>
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
     * messages) are read from and written to Cloud Storage in user-specified
     * format. Like the `OptimizeTours` method, each `OptimizeToursRequest`
     * contains a `ShipmentModel` and returns an `OptimizeToursResponse`
     * containing `ShipmentRoute` fields, which are a set of routes to be
     * performed by vehicles minimizing the overall cost.
     * The user can poll `operations.get` to check the status of the LRO:
     * If the LRO `done` field is false, then at least one request is still
     * being processed. Other requests may have completed successfully and their
     * results are available in Cloud Storage.
     * If the LRO's `done` field is true, then all requests have been processed.
     * Any successfully processed requests will have their results available in
     * Cloud Storage. Any requests that failed will not have their results
     * available in Cloud Storage. If the LRO's `error` field is set, then it
     * contains the error from one of the failed requests.
     * </pre>
     */
    public void batchOptimizeTours(
        com.google.maps.routeoptimization.v1.BatchOptimizeToursRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchOptimizeToursMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This is a variant of the
     * [OptimizeTours][google.maps.routeoptimization.v1.RouteOptimization.OptimizeTours]
     * method designed for
     * optimizations with large timeout values. It should be preferred over the
     * `OptimizeTours` method for optimizations that take longer than
     * a few minutes.
     * The returned [long-running operation][google.longrunning.Operation] (LRO)
     * will have a name of the format
     * `&lt;parent&gt;/operations/&lt;operation_id&gt;` and can be used to track
     * progress of the computation. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [OptimizeToursLongRunningMetadata][google.maps.routeoptimization.v1.OptimizeToursLongRunningMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [OptimizeToursResponse][google.maps.routeoptimization.v1.OptimizeToursResponse],
     * if successful.
     * Experimental: See
     * https://developers.google.com/maps/tt/route-optimization/experimental/otlr/make-request
     * for more details.
     * </pre>
     */
    public void optimizeToursLongRunning(
        com.google.maps.routeoptimization.v1.OptimizeToursRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOptimizeToursLongRunningMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This is a variant of the
     * [OptimizeToursLongRunning][google.maps.routeoptimization.v1.RouteOptimization.OptimizeToursLongRunning]
     * method designed for optimizations with large timeout values and large
     * input/output sizes.
     * The client specifies the URI of the `OptimizeToursRequest` stored
     * in Google Cloud Storage and the server writes the `OptimizeToursResponse`
     * to a client-specified Google Cloud Storage URI.
     * This method should be preferred over the `OptimizeTours` method for
     * optimizations that take longer than a few minutes and input/output sizes
     * that are larger than 8MB, though it can be used for shorter and smaller
     * optimizations as well.
     * The returned [long-running operation][google.longrunning.Operation] (LRO)
     * will have a name of the format
     * `&lt;parent&gt;/operations/&lt;operation_id&gt;` and can be used to track
     * progress of the computation. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [OptimizeToursLongRunningMetadata][google.maps.routeoptimization.v1.OptimizeToursUriMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [OptimizeToursUriResponse][google.maps.routeoptimization.v1.OptimizeToursUriResponse],
     * if successful.
     * Experimental: See
     * https://developers.google.com/maps/tt/route-optimization/experimental/otlr/make-request
     * for more details.
     * </pre>
     */
    public void optimizeToursUri(
        com.google.maps.routeoptimization.v1.OptimizeToursUriRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOptimizeToursUriMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RouteOptimization.
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
  public static final class RouteOptimizationBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<RouteOptimizationBlockingV2Stub> {
    private RouteOptimizationBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteOptimizationBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RouteOptimizationBlockingV2Stub(channel, callOptions);
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
    public com.google.maps.routeoptimization.v1.OptimizeToursResponse optimizeTours(
        com.google.maps.routeoptimization.v1.OptimizeToursRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
     * messages) are read from and written to Cloud Storage in user-specified
     * format. Like the `OptimizeTours` method, each `OptimizeToursRequest`
     * contains a `ShipmentModel` and returns an `OptimizeToursResponse`
     * containing `ShipmentRoute` fields, which are a set of routes to be
     * performed by vehicles minimizing the overall cost.
     * The user can poll `operations.get` to check the status of the LRO:
     * If the LRO `done` field is false, then at least one request is still
     * being processed. Other requests may have completed successfully and their
     * results are available in Cloud Storage.
     * If the LRO's `done` field is true, then all requests have been processed.
     * Any successfully processed requests will have their results available in
     * Cloud Storage. Any requests that failed will not have their results
     * available in Cloud Storage. If the LRO's `error` field is set, then it
     * contains the error from one of the failed requests.
     * </pre>
     */
    public com.google.longrunning.Operation batchOptimizeTours(
        com.google.maps.routeoptimization.v1.BatchOptimizeToursRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBatchOptimizeToursMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This is a variant of the
     * [OptimizeTours][google.maps.routeoptimization.v1.RouteOptimization.OptimizeTours]
     * method designed for
     * optimizations with large timeout values. It should be preferred over the
     * `OptimizeTours` method for optimizations that take longer than
     * a few minutes.
     * The returned [long-running operation][google.longrunning.Operation] (LRO)
     * will have a name of the format
     * `&lt;parent&gt;/operations/&lt;operation_id&gt;` and can be used to track
     * progress of the computation. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [OptimizeToursLongRunningMetadata][google.maps.routeoptimization.v1.OptimizeToursLongRunningMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [OptimizeToursResponse][google.maps.routeoptimization.v1.OptimizeToursResponse],
     * if successful.
     * Experimental: See
     * https://developers.google.com/maps/tt/route-optimization/experimental/otlr/make-request
     * for more details.
     * </pre>
     */
    public com.google.longrunning.Operation optimizeToursLongRunning(
        com.google.maps.routeoptimization.v1.OptimizeToursRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getOptimizeToursLongRunningMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This is a variant of the
     * [OptimizeToursLongRunning][google.maps.routeoptimization.v1.RouteOptimization.OptimizeToursLongRunning]
     * method designed for optimizations with large timeout values and large
     * input/output sizes.
     * The client specifies the URI of the `OptimizeToursRequest` stored
     * in Google Cloud Storage and the server writes the `OptimizeToursResponse`
     * to a client-specified Google Cloud Storage URI.
     * This method should be preferred over the `OptimizeTours` method for
     * optimizations that take longer than a few minutes and input/output sizes
     * that are larger than 8MB, though it can be used for shorter and smaller
     * optimizations as well.
     * The returned [long-running operation][google.longrunning.Operation] (LRO)
     * will have a name of the format
     * `&lt;parent&gt;/operations/&lt;operation_id&gt;` and can be used to track
     * progress of the computation. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [OptimizeToursLongRunningMetadata][google.maps.routeoptimization.v1.OptimizeToursUriMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [OptimizeToursUriResponse][google.maps.routeoptimization.v1.OptimizeToursUriResponse],
     * if successful.
     * Experimental: See
     * https://developers.google.com/maps/tt/route-optimization/experimental/otlr/make-request
     * for more details.
     * </pre>
     */
    public com.google.longrunning.Operation optimizeToursUri(
        com.google.maps.routeoptimization.v1.OptimizeToursUriRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getOptimizeToursUriMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service RouteOptimization.
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
  public static final class RouteOptimizationBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RouteOptimizationBlockingStub> {
    private RouteOptimizationBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteOptimizationBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RouteOptimizationBlockingStub(channel, callOptions);
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
    public com.google.maps.routeoptimization.v1.OptimizeToursResponse optimizeTours(
        com.google.maps.routeoptimization.v1.OptimizeToursRequest request) {
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
     * messages) are read from and written to Cloud Storage in user-specified
     * format. Like the `OptimizeTours` method, each `OptimizeToursRequest`
     * contains a `ShipmentModel` and returns an `OptimizeToursResponse`
     * containing `ShipmentRoute` fields, which are a set of routes to be
     * performed by vehicles minimizing the overall cost.
     * The user can poll `operations.get` to check the status of the LRO:
     * If the LRO `done` field is false, then at least one request is still
     * being processed. Other requests may have completed successfully and their
     * results are available in Cloud Storage.
     * If the LRO's `done` field is true, then all requests have been processed.
     * Any successfully processed requests will have their results available in
     * Cloud Storage. Any requests that failed will not have their results
     * available in Cloud Storage. If the LRO's `error` field is set, then it
     * contains the error from one of the failed requests.
     * </pre>
     */
    public com.google.longrunning.Operation batchOptimizeTours(
        com.google.maps.routeoptimization.v1.BatchOptimizeToursRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchOptimizeToursMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This is a variant of the
     * [OptimizeTours][google.maps.routeoptimization.v1.RouteOptimization.OptimizeTours]
     * method designed for
     * optimizations with large timeout values. It should be preferred over the
     * `OptimizeTours` method for optimizations that take longer than
     * a few minutes.
     * The returned [long-running operation][google.longrunning.Operation] (LRO)
     * will have a name of the format
     * `&lt;parent&gt;/operations/&lt;operation_id&gt;` and can be used to track
     * progress of the computation. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [OptimizeToursLongRunningMetadata][google.maps.routeoptimization.v1.OptimizeToursLongRunningMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [OptimizeToursResponse][google.maps.routeoptimization.v1.OptimizeToursResponse],
     * if successful.
     * Experimental: See
     * https://developers.google.com/maps/tt/route-optimization/experimental/otlr/make-request
     * for more details.
     * </pre>
     */
    public com.google.longrunning.Operation optimizeToursLongRunning(
        com.google.maps.routeoptimization.v1.OptimizeToursRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOptimizeToursLongRunningMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This is a variant of the
     * [OptimizeToursLongRunning][google.maps.routeoptimization.v1.RouteOptimization.OptimizeToursLongRunning]
     * method designed for optimizations with large timeout values and large
     * input/output sizes.
     * The client specifies the URI of the `OptimizeToursRequest` stored
     * in Google Cloud Storage and the server writes the `OptimizeToursResponse`
     * to a client-specified Google Cloud Storage URI.
     * This method should be preferred over the `OptimizeTours` method for
     * optimizations that take longer than a few minutes and input/output sizes
     * that are larger than 8MB, though it can be used for shorter and smaller
     * optimizations as well.
     * The returned [long-running operation][google.longrunning.Operation] (LRO)
     * will have a name of the format
     * `&lt;parent&gt;/operations/&lt;operation_id&gt;` and can be used to track
     * progress of the computation. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [OptimizeToursLongRunningMetadata][google.maps.routeoptimization.v1.OptimizeToursUriMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [OptimizeToursUriResponse][google.maps.routeoptimization.v1.OptimizeToursUriResponse],
     * if successful.
     * Experimental: See
     * https://developers.google.com/maps/tt/route-optimization/experimental/otlr/make-request
     * for more details.
     * </pre>
     */
    public com.google.longrunning.Operation optimizeToursUri(
        com.google.maps.routeoptimization.v1.OptimizeToursUriRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOptimizeToursUriMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RouteOptimization.
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
  public static final class RouteOptimizationFutureStub
      extends io.grpc.stub.AbstractFutureStub<RouteOptimizationFutureStub> {
    private RouteOptimizationFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteOptimizationFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RouteOptimizationFutureStub(channel, callOptions);
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
            com.google.maps.routeoptimization.v1.OptimizeToursResponse>
        optimizeTours(com.google.maps.routeoptimization.v1.OptimizeToursRequest request) {
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
     * messages) are read from and written to Cloud Storage in user-specified
     * format. Like the `OptimizeTours` method, each `OptimizeToursRequest`
     * contains a `ShipmentModel` and returns an `OptimizeToursResponse`
     * containing `ShipmentRoute` fields, which are a set of routes to be
     * performed by vehicles minimizing the overall cost.
     * The user can poll `operations.get` to check the status of the LRO:
     * If the LRO `done` field is false, then at least one request is still
     * being processed. Other requests may have completed successfully and their
     * results are available in Cloud Storage.
     * If the LRO's `done` field is true, then all requests have been processed.
     * Any successfully processed requests will have their results available in
     * Cloud Storage. Any requests that failed will not have their results
     * available in Cloud Storage. If the LRO's `error` field is set, then it
     * contains the error from one of the failed requests.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchOptimizeTours(com.google.maps.routeoptimization.v1.BatchOptimizeToursRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchOptimizeToursMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * This is a variant of the
     * [OptimizeTours][google.maps.routeoptimization.v1.RouteOptimization.OptimizeTours]
     * method designed for
     * optimizations with large timeout values. It should be preferred over the
     * `OptimizeTours` method for optimizations that take longer than
     * a few minutes.
     * The returned [long-running operation][google.longrunning.Operation] (LRO)
     * will have a name of the format
     * `&lt;parent&gt;/operations/&lt;operation_id&gt;` and can be used to track
     * progress of the computation. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [OptimizeToursLongRunningMetadata][google.maps.routeoptimization.v1.OptimizeToursLongRunningMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [OptimizeToursResponse][google.maps.routeoptimization.v1.OptimizeToursResponse],
     * if successful.
     * Experimental: See
     * https://developers.google.com/maps/tt/route-optimization/experimental/otlr/make-request
     * for more details.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        optimizeToursLongRunning(
            com.google.maps.routeoptimization.v1.OptimizeToursRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOptimizeToursLongRunningMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * This is a variant of the
     * [OptimizeToursLongRunning][google.maps.routeoptimization.v1.RouteOptimization.OptimizeToursLongRunning]
     * method designed for optimizations with large timeout values and large
     * input/output sizes.
     * The client specifies the URI of the `OptimizeToursRequest` stored
     * in Google Cloud Storage and the server writes the `OptimizeToursResponse`
     * to a client-specified Google Cloud Storage URI.
     * This method should be preferred over the `OptimizeTours` method for
     * optimizations that take longer than a few minutes and input/output sizes
     * that are larger than 8MB, though it can be used for shorter and smaller
     * optimizations as well.
     * The returned [long-running operation][google.longrunning.Operation] (LRO)
     * will have a name of the format
     * `&lt;parent&gt;/operations/&lt;operation_id&gt;` and can be used to track
     * progress of the computation. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [OptimizeToursLongRunningMetadata][google.maps.routeoptimization.v1.OptimizeToursUriMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [OptimizeToursUriResponse][google.maps.routeoptimization.v1.OptimizeToursUriResponse],
     * if successful.
     * Experimental: See
     * https://developers.google.com/maps/tt/route-optimization/experimental/otlr/make-request
     * for more details.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        optimizeToursUri(com.google.maps.routeoptimization.v1.OptimizeToursUriRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOptimizeToursUriMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_OPTIMIZE_TOURS = 0;
  private static final int METHODID_BATCH_OPTIMIZE_TOURS = 1;
  private static final int METHODID_OPTIMIZE_TOURS_LONG_RUNNING = 2;
  private static final int METHODID_OPTIMIZE_TOURS_URI = 3;

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
        case METHODID_OPTIMIZE_TOURS:
          serviceImpl.optimizeTours(
              (com.google.maps.routeoptimization.v1.OptimizeToursRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.maps.routeoptimization.v1.OptimizeToursResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_OPTIMIZE_TOURS:
          serviceImpl.batchOptimizeTours(
              (com.google.maps.routeoptimization.v1.BatchOptimizeToursRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_OPTIMIZE_TOURS_LONG_RUNNING:
          serviceImpl.optimizeToursLongRunning(
              (com.google.maps.routeoptimization.v1.OptimizeToursRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_OPTIMIZE_TOURS_URI:
          serviceImpl.optimizeToursUri(
              (com.google.maps.routeoptimization.v1.OptimizeToursUriRequest) request,
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
            getOptimizeToursMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.routeoptimization.v1.OptimizeToursRequest,
                    com.google.maps.routeoptimization.v1.OptimizeToursResponse>(
                    service, METHODID_OPTIMIZE_TOURS)))
        .addMethod(
            getBatchOptimizeToursMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.routeoptimization.v1.BatchOptimizeToursRequest,
                    com.google.longrunning.Operation>(service, METHODID_BATCH_OPTIMIZE_TOURS)))
        .addMethod(
            getOptimizeToursLongRunningMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.routeoptimization.v1.OptimizeToursRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_OPTIMIZE_TOURS_LONG_RUNNING)))
        .addMethod(
            getOptimizeToursUriMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.routeoptimization.v1.OptimizeToursUriRequest,
                    com.google.longrunning.Operation>(service, METHODID_OPTIMIZE_TOURS_URI)))
        .build();
  }

  private abstract static class RouteOptimizationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RouteOptimizationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.maps.routeoptimization.v1.RouteOptimizationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RouteOptimization");
    }
  }

  private static final class RouteOptimizationFileDescriptorSupplier
      extends RouteOptimizationBaseDescriptorSupplier {
    RouteOptimizationFileDescriptorSupplier() {}
  }

  private static final class RouteOptimizationMethodDescriptorSupplier
      extends RouteOptimizationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RouteOptimizationMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (RouteOptimizationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new RouteOptimizationFileDescriptorSupplier())
                      .addMethod(getOptimizeToursMethod())
                      .addMethod(getBatchOptimizeToursMethod())
                      .addMethod(getOptimizeToursLongRunningMethod())
                      .addMethod(getOptimizeToursUriMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
