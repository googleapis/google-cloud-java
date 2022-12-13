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
package com.google.maps.routing.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Routes API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/maps/routing/v2/routes_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RoutesGrpc {

  private RoutesGrpc() {}

  public static final String SERVICE_NAME = "google.maps.routing.v2.Routes";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.routing.v2.ComputeRoutesRequest,
          com.google.maps.routing.v2.ComputeRoutesResponse>
      getComputeRoutesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ComputeRoutes",
      requestType = com.google.maps.routing.v2.ComputeRoutesRequest.class,
      responseType = com.google.maps.routing.v2.ComputeRoutesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.routing.v2.ComputeRoutesRequest,
          com.google.maps.routing.v2.ComputeRoutesResponse>
      getComputeRoutesMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.routing.v2.ComputeRoutesRequest,
            com.google.maps.routing.v2.ComputeRoutesResponse>
        getComputeRoutesMethod;
    if ((getComputeRoutesMethod = RoutesGrpc.getComputeRoutesMethod) == null) {
      synchronized (RoutesGrpc.class) {
        if ((getComputeRoutesMethod = RoutesGrpc.getComputeRoutesMethod) == null) {
          RoutesGrpc.getComputeRoutesMethod =
              getComputeRoutesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.routing.v2.ComputeRoutesRequest,
                          com.google.maps.routing.v2.ComputeRoutesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ComputeRoutes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.routing.v2.ComputeRoutesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.routing.v2.ComputeRoutesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new RoutesMethodDescriptorSupplier("ComputeRoutes"))
                      .build();
        }
      }
    }
    return getComputeRoutesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.routing.v2.ComputeRouteMatrixRequest,
          com.google.maps.routing.v2.RouteMatrixElement>
      getComputeRouteMatrixMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ComputeRouteMatrix",
      requestType = com.google.maps.routing.v2.ComputeRouteMatrixRequest.class,
      responseType = com.google.maps.routing.v2.RouteMatrixElement.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.maps.routing.v2.ComputeRouteMatrixRequest,
          com.google.maps.routing.v2.RouteMatrixElement>
      getComputeRouteMatrixMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.routing.v2.ComputeRouteMatrixRequest,
            com.google.maps.routing.v2.RouteMatrixElement>
        getComputeRouteMatrixMethod;
    if ((getComputeRouteMatrixMethod = RoutesGrpc.getComputeRouteMatrixMethod) == null) {
      synchronized (RoutesGrpc.class) {
        if ((getComputeRouteMatrixMethod = RoutesGrpc.getComputeRouteMatrixMethod) == null) {
          RoutesGrpc.getComputeRouteMatrixMethod =
              getComputeRouteMatrixMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.routing.v2.ComputeRouteMatrixRequest,
                          com.google.maps.routing.v2.RouteMatrixElement>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ComputeRouteMatrix"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.routing.v2.ComputeRouteMatrixRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.routing.v2.RouteMatrixElement.getDefaultInstance()))
                      .setSchemaDescriptor(new RoutesMethodDescriptorSupplier("ComputeRouteMatrix"))
                      .build();
        }
      }
    }
    return getComputeRouteMatrixMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static RoutesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoutesStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RoutesStub>() {
          @java.lang.Override
          public RoutesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RoutesStub(channel, callOptions);
          }
        };
    return RoutesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RoutesBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoutesBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RoutesBlockingStub>() {
          @java.lang.Override
          public RoutesBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RoutesBlockingStub(channel, callOptions);
          }
        };
    return RoutesBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RoutesFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoutesFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RoutesFutureStub>() {
          @java.lang.Override
          public RoutesFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RoutesFutureStub(channel, callOptions);
          }
        };
    return RoutesFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Routes API.
   * </pre>
   */
  public abstract static class RoutesImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Returns the primary route along with optional alternate routes, given a set
     * of terminal and intermediate waypoints.
     * **NOTE:** This method requires that you specify a response field mask in
     * the input. You can provide the response field mask by using URL parameter
     * `$fields` or `fields`, or by using an HTTP/gRPC header `X-Goog-FieldMask`
     * (see the [available URL parameters and
     * headers](https://cloud.google.com/apis/docs/system-parameters). The value
     * is a comma separated list of field paths. See detailed documentation about
     * [how to construct the field
     * paths](https://github.com/protocolbuffers/protobuf/blob/master/src/google/protobuf/field_mask.proto).
     * For example, in this method:
     * * Field mask of all available fields (for manual inspection):
     *   `X-Goog-FieldMask: *`
     * * Field mask of Route-level duration, distance, and polyline (an example
     * production setup):
     *   `X-Goog-FieldMask:
     *   routes.duration,routes.distanceMeters,routes.polyline.encodedPolyline`
     * Google discourage the use of the wildcard (`*`) response field mask, or
     * specifying the field mask at the top level (`routes`), because:
     * * Selecting only the fields that you need helps our server save computation
     * cycles, allowing us to return the result to you with a lower latency.
     * * Selecting only the fields that you need
     * in your production job ensures stable latency performance. We might add
     * more response fields in the future, and those new fields might require
     * extra computation time. If you select all fields, or if you select all
     * fields at the top level, then you might experience performance degradation
     * because any new field we add will be automatically included in the
     * response.
     * * Selecting only the fields that you need results in a smaller response
     * size, and thus higher network throughput.
     * </pre>
     */
    public void computeRoutes(
        com.google.maps.routing.v2.ComputeRoutesRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.routing.v2.ComputeRoutesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getComputeRoutesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Takes in a list of origins and destinations and returns a stream containing
     * route information for each combination of origin and destination.
     * **NOTE:** This method requires that you specify a response field mask in
     * the input. You can provide the response field mask by using the URL
     * parameter `$fields` or `fields`, or by using the HTTP/gRPC header
     * `X-Goog-FieldMask` (see the [available URL parameters and
     * headers](https://cloud.google.com/apis/docs/system-parameters). The value
     * is a comma separated list of field paths. See this detailed documentation
     * about [how to construct the field
     * paths](https://github.com/protocolbuffers/protobuf/blob/master/src/google/protobuf/field_mask.proto).
     * For example, in this method:
     * * Field mask of all available fields (for manual inspection):
     *   `X-Goog-FieldMask: *`
     * * Field mask of route durations, distances, element status, condition, and
     *   element indices (an example production setup):
     *   `X-Goog-FieldMask:
     *   originIndex,destinationIndex,status,condition,distanceMeters,duration`
     * It is critical that you include `status` in your field mask as otherwise
     * all messages will appear to be OK. Google discourages the use of the
     * wildcard (`*`) response field mask, because:
     * * Selecting only the fields that you need helps our server save computation
     * cycles, allowing us to return the result to you with a lower latency.
     * * Selecting only the fields that you need in your production job ensures
     * stable latency performance. We might add more response fields in the
     * future, and those new fields might require extra computation time. If you
     * select all fields, or if you select all fields at the top level, then you
     * might experience performance degradation because any new field we add will
     * be automatically included in the response.
     * * Selecting only the fields that you need results in a smaller response
     * size, and thus higher network throughput.
     * </pre>
     */
    public void computeRouteMatrix(
        com.google.maps.routing.v2.ComputeRouteMatrixRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.routing.v2.RouteMatrixElement>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getComputeRouteMatrixMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getComputeRoutesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.maps.routing.v2.ComputeRoutesRequest,
                      com.google.maps.routing.v2.ComputeRoutesResponse>(
                      this, METHODID_COMPUTE_ROUTES)))
          .addMethod(
              getComputeRouteMatrixMethod(),
              io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                  new MethodHandlers<
                      com.google.maps.routing.v2.ComputeRouteMatrixRequest,
                      com.google.maps.routing.v2.RouteMatrixElement>(
                      this, METHODID_COMPUTE_ROUTE_MATRIX)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The Routes API.
   * </pre>
   */
  public static final class RoutesStub extends io.grpc.stub.AbstractAsyncStub<RoutesStub> {
    private RoutesStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoutesStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoutesStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the primary route along with optional alternate routes, given a set
     * of terminal and intermediate waypoints.
     * **NOTE:** This method requires that you specify a response field mask in
     * the input. You can provide the response field mask by using URL parameter
     * `$fields` or `fields`, or by using an HTTP/gRPC header `X-Goog-FieldMask`
     * (see the [available URL parameters and
     * headers](https://cloud.google.com/apis/docs/system-parameters). The value
     * is a comma separated list of field paths. See detailed documentation about
     * [how to construct the field
     * paths](https://github.com/protocolbuffers/protobuf/blob/master/src/google/protobuf/field_mask.proto).
     * For example, in this method:
     * * Field mask of all available fields (for manual inspection):
     *   `X-Goog-FieldMask: *`
     * * Field mask of Route-level duration, distance, and polyline (an example
     * production setup):
     *   `X-Goog-FieldMask:
     *   routes.duration,routes.distanceMeters,routes.polyline.encodedPolyline`
     * Google discourage the use of the wildcard (`*`) response field mask, or
     * specifying the field mask at the top level (`routes`), because:
     * * Selecting only the fields that you need helps our server save computation
     * cycles, allowing us to return the result to you with a lower latency.
     * * Selecting only the fields that you need
     * in your production job ensures stable latency performance. We might add
     * more response fields in the future, and those new fields might require
     * extra computation time. If you select all fields, or if you select all
     * fields at the top level, then you might experience performance degradation
     * because any new field we add will be automatically included in the
     * response.
     * * Selecting only the fields that you need results in a smaller response
     * size, and thus higher network throughput.
     * </pre>
     */
    public void computeRoutes(
        com.google.maps.routing.v2.ComputeRoutesRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.routing.v2.ComputeRoutesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getComputeRoutesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Takes in a list of origins and destinations and returns a stream containing
     * route information for each combination of origin and destination.
     * **NOTE:** This method requires that you specify a response field mask in
     * the input. You can provide the response field mask by using the URL
     * parameter `$fields` or `fields`, or by using the HTTP/gRPC header
     * `X-Goog-FieldMask` (see the [available URL parameters and
     * headers](https://cloud.google.com/apis/docs/system-parameters). The value
     * is a comma separated list of field paths. See this detailed documentation
     * about [how to construct the field
     * paths](https://github.com/protocolbuffers/protobuf/blob/master/src/google/protobuf/field_mask.proto).
     * For example, in this method:
     * * Field mask of all available fields (for manual inspection):
     *   `X-Goog-FieldMask: *`
     * * Field mask of route durations, distances, element status, condition, and
     *   element indices (an example production setup):
     *   `X-Goog-FieldMask:
     *   originIndex,destinationIndex,status,condition,distanceMeters,duration`
     * It is critical that you include `status` in your field mask as otherwise
     * all messages will appear to be OK. Google discourages the use of the
     * wildcard (`*`) response field mask, because:
     * * Selecting only the fields that you need helps our server save computation
     * cycles, allowing us to return the result to you with a lower latency.
     * * Selecting only the fields that you need in your production job ensures
     * stable latency performance. We might add more response fields in the
     * future, and those new fields might require extra computation time. If you
     * select all fields, or if you select all fields at the top level, then you
     * might experience performance degradation because any new field we add will
     * be automatically included in the response.
     * * Selecting only the fields that you need results in a smaller response
     * size, and thus higher network throughput.
     * </pre>
     */
    public void computeRouteMatrix(
        com.google.maps.routing.v2.ComputeRouteMatrixRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.routing.v2.RouteMatrixElement>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getComputeRouteMatrixMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The Routes API.
   * </pre>
   */
  public static final class RoutesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RoutesBlockingStub> {
    private RoutesBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoutesBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoutesBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the primary route along with optional alternate routes, given a set
     * of terminal and intermediate waypoints.
     * **NOTE:** This method requires that you specify a response field mask in
     * the input. You can provide the response field mask by using URL parameter
     * `$fields` or `fields`, or by using an HTTP/gRPC header `X-Goog-FieldMask`
     * (see the [available URL parameters and
     * headers](https://cloud.google.com/apis/docs/system-parameters). The value
     * is a comma separated list of field paths. See detailed documentation about
     * [how to construct the field
     * paths](https://github.com/protocolbuffers/protobuf/blob/master/src/google/protobuf/field_mask.proto).
     * For example, in this method:
     * * Field mask of all available fields (for manual inspection):
     *   `X-Goog-FieldMask: *`
     * * Field mask of Route-level duration, distance, and polyline (an example
     * production setup):
     *   `X-Goog-FieldMask:
     *   routes.duration,routes.distanceMeters,routes.polyline.encodedPolyline`
     * Google discourage the use of the wildcard (`*`) response field mask, or
     * specifying the field mask at the top level (`routes`), because:
     * * Selecting only the fields that you need helps our server save computation
     * cycles, allowing us to return the result to you with a lower latency.
     * * Selecting only the fields that you need
     * in your production job ensures stable latency performance. We might add
     * more response fields in the future, and those new fields might require
     * extra computation time. If you select all fields, or if you select all
     * fields at the top level, then you might experience performance degradation
     * because any new field we add will be automatically included in the
     * response.
     * * Selecting only the fields that you need results in a smaller response
     * size, and thus higher network throughput.
     * </pre>
     */
    public com.google.maps.routing.v2.ComputeRoutesResponse computeRoutes(
        com.google.maps.routing.v2.ComputeRoutesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getComputeRoutesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Takes in a list of origins and destinations and returns a stream containing
     * route information for each combination of origin and destination.
     * **NOTE:** This method requires that you specify a response field mask in
     * the input. You can provide the response field mask by using the URL
     * parameter `$fields` or `fields`, or by using the HTTP/gRPC header
     * `X-Goog-FieldMask` (see the [available URL parameters and
     * headers](https://cloud.google.com/apis/docs/system-parameters). The value
     * is a comma separated list of field paths. See this detailed documentation
     * about [how to construct the field
     * paths](https://github.com/protocolbuffers/protobuf/blob/master/src/google/protobuf/field_mask.proto).
     * For example, in this method:
     * * Field mask of all available fields (for manual inspection):
     *   `X-Goog-FieldMask: *`
     * * Field mask of route durations, distances, element status, condition, and
     *   element indices (an example production setup):
     *   `X-Goog-FieldMask:
     *   originIndex,destinationIndex,status,condition,distanceMeters,duration`
     * It is critical that you include `status` in your field mask as otherwise
     * all messages will appear to be OK. Google discourages the use of the
     * wildcard (`*`) response field mask, because:
     * * Selecting only the fields that you need helps our server save computation
     * cycles, allowing us to return the result to you with a lower latency.
     * * Selecting only the fields that you need in your production job ensures
     * stable latency performance. We might add more response fields in the
     * future, and those new fields might require extra computation time. If you
     * select all fields, or if you select all fields at the top level, then you
     * might experience performance degradation because any new field we add will
     * be automatically included in the response.
     * * Selecting only the fields that you need results in a smaller response
     * size, and thus higher network throughput.
     * </pre>
     */
    public java.util.Iterator<com.google.maps.routing.v2.RouteMatrixElement> computeRouteMatrix(
        com.google.maps.routing.v2.ComputeRouteMatrixRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getComputeRouteMatrixMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The Routes API.
   * </pre>
   */
  public static final class RoutesFutureStub
      extends io.grpc.stub.AbstractFutureStub<RoutesFutureStub> {
    private RoutesFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoutesFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoutesFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the primary route along with optional alternate routes, given a set
     * of terminal and intermediate waypoints.
     * **NOTE:** This method requires that you specify a response field mask in
     * the input. You can provide the response field mask by using URL parameter
     * `$fields` or `fields`, or by using an HTTP/gRPC header `X-Goog-FieldMask`
     * (see the [available URL parameters and
     * headers](https://cloud.google.com/apis/docs/system-parameters). The value
     * is a comma separated list of field paths. See detailed documentation about
     * [how to construct the field
     * paths](https://github.com/protocolbuffers/protobuf/blob/master/src/google/protobuf/field_mask.proto).
     * For example, in this method:
     * * Field mask of all available fields (for manual inspection):
     *   `X-Goog-FieldMask: *`
     * * Field mask of Route-level duration, distance, and polyline (an example
     * production setup):
     *   `X-Goog-FieldMask:
     *   routes.duration,routes.distanceMeters,routes.polyline.encodedPolyline`
     * Google discourage the use of the wildcard (`*`) response field mask, or
     * specifying the field mask at the top level (`routes`), because:
     * * Selecting only the fields that you need helps our server save computation
     * cycles, allowing us to return the result to you with a lower latency.
     * * Selecting only the fields that you need
     * in your production job ensures stable latency performance. We might add
     * more response fields in the future, and those new fields might require
     * extra computation time. If you select all fields, or if you select all
     * fields at the top level, then you might experience performance degradation
     * because any new field we add will be automatically included in the
     * response.
     * * Selecting only the fields that you need results in a smaller response
     * size, and thus higher network throughput.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.routing.v2.ComputeRoutesResponse>
        computeRoutes(com.google.maps.routing.v2.ComputeRoutesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getComputeRoutesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COMPUTE_ROUTES = 0;
  private static final int METHODID_COMPUTE_ROUTE_MATRIX = 1;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RoutesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RoutesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COMPUTE_ROUTES:
          serviceImpl.computeRoutes(
              (com.google.maps.routing.v2.ComputeRoutesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.routing.v2.ComputeRoutesResponse>)
                  responseObserver);
          break;
        case METHODID_COMPUTE_ROUTE_MATRIX:
          serviceImpl.computeRouteMatrix(
              (com.google.maps.routing.v2.ComputeRouteMatrixRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.routing.v2.RouteMatrixElement>)
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

  private abstract static class RoutesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RoutesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.maps.routing.v2.RoutesServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Routes");
    }
  }

  private static final class RoutesFileDescriptorSupplier extends RoutesBaseDescriptorSupplier {
    RoutesFileDescriptorSupplier() {}
  }

  private static final class RoutesMethodDescriptorSupplier extends RoutesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RoutesMethodDescriptorSupplier(String methodName) {
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
      synchronized (RoutesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new RoutesFileDescriptorSupplier())
                      .addMethod(getComputeRoutesMethod())
                      .addMethod(getComputeRouteMatrixMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
