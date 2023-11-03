/*
 * Copyright 2023 Google LLC
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
package google.maps.fleetengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Vehicle management service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/maps/fleetengine/v1/vehicle_api.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class VehicleServiceGrpc {

  private VehicleServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "maps.fleetengine.v1.VehicleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          google.maps.fleetengine.v1.CreateVehicleRequest, google.maps.fleetengine.v1.Vehicle>
      getCreateVehicleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateVehicle",
      requestType = google.maps.fleetengine.v1.CreateVehicleRequest.class,
      responseType = google.maps.fleetengine.v1.Vehicle.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.maps.fleetengine.v1.CreateVehicleRequest, google.maps.fleetengine.v1.Vehicle>
      getCreateVehicleMethod() {
    io.grpc.MethodDescriptor<
            google.maps.fleetengine.v1.CreateVehicleRequest, google.maps.fleetengine.v1.Vehicle>
        getCreateVehicleMethod;
    if ((getCreateVehicleMethod = VehicleServiceGrpc.getCreateVehicleMethod) == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getCreateVehicleMethod = VehicleServiceGrpc.getCreateVehicleMethod) == null) {
          VehicleServiceGrpc.getCreateVehicleMethod =
              getCreateVehicleMethod =
                  io.grpc.MethodDescriptor
                      .<google.maps.fleetengine.v1.CreateVehicleRequest,
                          google.maps.fleetengine.v1.Vehicle>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateVehicle"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.v1.CreateVehicleRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.v1.Vehicle.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VehicleServiceMethodDescriptorSupplier("CreateVehicle"))
                      .build();
        }
      }
    }
    return getCreateVehicleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.maps.fleetengine.v1.GetVehicleRequest, google.maps.fleetengine.v1.Vehicle>
      getGetVehicleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVehicle",
      requestType = google.maps.fleetengine.v1.GetVehicleRequest.class,
      responseType = google.maps.fleetengine.v1.Vehicle.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.maps.fleetengine.v1.GetVehicleRequest, google.maps.fleetengine.v1.Vehicle>
      getGetVehicleMethod() {
    io.grpc.MethodDescriptor<
            google.maps.fleetengine.v1.GetVehicleRequest, google.maps.fleetengine.v1.Vehicle>
        getGetVehicleMethod;
    if ((getGetVehicleMethod = VehicleServiceGrpc.getGetVehicleMethod) == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getGetVehicleMethod = VehicleServiceGrpc.getGetVehicleMethod) == null) {
          VehicleServiceGrpc.getGetVehicleMethod =
              getGetVehicleMethod =
                  io.grpc.MethodDescriptor
                      .<google.maps.fleetengine.v1.GetVehicleRequest,
                          google.maps.fleetengine.v1.Vehicle>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVehicle"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.v1.GetVehicleRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.v1.Vehicle.getDefaultInstance()))
                      .setSchemaDescriptor(new VehicleServiceMethodDescriptorSupplier("GetVehicle"))
                      .build();
        }
      }
    }
    return getGetVehicleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.maps.fleetengine.v1.UpdateVehicleRequest, google.maps.fleetengine.v1.Vehicle>
      getUpdateVehicleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateVehicle",
      requestType = google.maps.fleetengine.v1.UpdateVehicleRequest.class,
      responseType = google.maps.fleetengine.v1.Vehicle.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.maps.fleetengine.v1.UpdateVehicleRequest, google.maps.fleetengine.v1.Vehicle>
      getUpdateVehicleMethod() {
    io.grpc.MethodDescriptor<
            google.maps.fleetengine.v1.UpdateVehicleRequest, google.maps.fleetengine.v1.Vehicle>
        getUpdateVehicleMethod;
    if ((getUpdateVehicleMethod = VehicleServiceGrpc.getUpdateVehicleMethod) == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getUpdateVehicleMethod = VehicleServiceGrpc.getUpdateVehicleMethod) == null) {
          VehicleServiceGrpc.getUpdateVehicleMethod =
              getUpdateVehicleMethod =
                  io.grpc.MethodDescriptor
                      .<google.maps.fleetengine.v1.UpdateVehicleRequest,
                          google.maps.fleetengine.v1.Vehicle>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateVehicle"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.v1.UpdateVehicleRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.v1.Vehicle.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VehicleServiceMethodDescriptorSupplier("UpdateVehicle"))
                      .build();
        }
      }
    }
    return getUpdateVehicleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.maps.fleetengine.v1.UpdateVehicleLocationRequest,
          google.maps.fleetengine.v1.VehicleLocation>
      getUpdateVehicleLocationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateVehicleLocation",
      requestType = google.maps.fleetengine.v1.UpdateVehicleLocationRequest.class,
      responseType = google.maps.fleetengine.v1.VehicleLocation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.maps.fleetengine.v1.UpdateVehicleLocationRequest,
          google.maps.fleetengine.v1.VehicleLocation>
      getUpdateVehicleLocationMethod() {
    io.grpc.MethodDescriptor<
            google.maps.fleetengine.v1.UpdateVehicleLocationRequest,
            google.maps.fleetengine.v1.VehicleLocation>
        getUpdateVehicleLocationMethod;
    if ((getUpdateVehicleLocationMethod = VehicleServiceGrpc.getUpdateVehicleLocationMethod)
        == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getUpdateVehicleLocationMethod = VehicleServiceGrpc.getUpdateVehicleLocationMethod)
            == null) {
          VehicleServiceGrpc.getUpdateVehicleLocationMethod =
              getUpdateVehicleLocationMethod =
                  io.grpc.MethodDescriptor
                      .<google.maps.fleetengine.v1.UpdateVehicleLocationRequest,
                          google.maps.fleetengine.v1.VehicleLocation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateVehicleLocation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.v1.UpdateVehicleLocationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.v1.VehicleLocation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VehicleServiceMethodDescriptorSupplier("UpdateVehicleLocation"))
                      .build();
        }
      }
    }
    return getUpdateVehicleLocationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.maps.fleetengine.v1.UpdateVehicleAttributesRequest,
          google.maps.fleetengine.v1.UpdateVehicleAttributesResponse>
      getUpdateVehicleAttributesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateVehicleAttributes",
      requestType = google.maps.fleetengine.v1.UpdateVehicleAttributesRequest.class,
      responseType = google.maps.fleetengine.v1.UpdateVehicleAttributesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.maps.fleetengine.v1.UpdateVehicleAttributesRequest,
          google.maps.fleetengine.v1.UpdateVehicleAttributesResponse>
      getUpdateVehicleAttributesMethod() {
    io.grpc.MethodDescriptor<
            google.maps.fleetengine.v1.UpdateVehicleAttributesRequest,
            google.maps.fleetengine.v1.UpdateVehicleAttributesResponse>
        getUpdateVehicleAttributesMethod;
    if ((getUpdateVehicleAttributesMethod = VehicleServiceGrpc.getUpdateVehicleAttributesMethod)
        == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getUpdateVehicleAttributesMethod = VehicleServiceGrpc.getUpdateVehicleAttributesMethod)
            == null) {
          VehicleServiceGrpc.getUpdateVehicleAttributesMethod =
              getUpdateVehicleAttributesMethod =
                  io.grpc.MethodDescriptor
                      .<google.maps.fleetengine.v1.UpdateVehicleAttributesRequest,
                          google.maps.fleetengine.v1.UpdateVehicleAttributesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateVehicleAttributes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.v1.UpdateVehicleAttributesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.v1.UpdateVehicleAttributesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VehicleServiceMethodDescriptorSupplier("UpdateVehicleAttributes"))
                      .build();
        }
      }
    }
    return getUpdateVehicleAttributesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.maps.fleetengine.v1.ListVehiclesRequest,
          google.maps.fleetengine.v1.ListVehiclesResponse>
      getListVehiclesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVehicles",
      requestType = google.maps.fleetengine.v1.ListVehiclesRequest.class,
      responseType = google.maps.fleetengine.v1.ListVehiclesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.maps.fleetengine.v1.ListVehiclesRequest,
          google.maps.fleetengine.v1.ListVehiclesResponse>
      getListVehiclesMethod() {
    io.grpc.MethodDescriptor<
            google.maps.fleetengine.v1.ListVehiclesRequest,
            google.maps.fleetengine.v1.ListVehiclesResponse>
        getListVehiclesMethod;
    if ((getListVehiclesMethod = VehicleServiceGrpc.getListVehiclesMethod) == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getListVehiclesMethod = VehicleServiceGrpc.getListVehiclesMethod) == null) {
          VehicleServiceGrpc.getListVehiclesMethod =
              getListVehiclesMethod =
                  io.grpc.MethodDescriptor
                      .<google.maps.fleetengine.v1.ListVehiclesRequest,
                          google.maps.fleetengine.v1.ListVehiclesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListVehicles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.v1.ListVehiclesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.v1.ListVehiclesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VehicleServiceMethodDescriptorSupplier("ListVehicles"))
                      .build();
        }
      }
    }
    return getListVehiclesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.maps.fleetengine.v1.SearchVehiclesRequest,
          google.maps.fleetengine.v1.SearchVehiclesResponse>
      getSearchVehiclesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchVehicles",
      requestType = google.maps.fleetengine.v1.SearchVehiclesRequest.class,
      responseType = google.maps.fleetengine.v1.SearchVehiclesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.maps.fleetengine.v1.SearchVehiclesRequest,
          google.maps.fleetengine.v1.SearchVehiclesResponse>
      getSearchVehiclesMethod() {
    io.grpc.MethodDescriptor<
            google.maps.fleetengine.v1.SearchVehiclesRequest,
            google.maps.fleetengine.v1.SearchVehiclesResponse>
        getSearchVehiclesMethod;
    if ((getSearchVehiclesMethod = VehicleServiceGrpc.getSearchVehiclesMethod) == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getSearchVehiclesMethod = VehicleServiceGrpc.getSearchVehiclesMethod) == null) {
          VehicleServiceGrpc.getSearchVehiclesMethod =
              getSearchVehiclesMethod =
                  io.grpc.MethodDescriptor
                      .<google.maps.fleetengine.v1.SearchVehiclesRequest,
                          google.maps.fleetengine.v1.SearchVehiclesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchVehicles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.v1.SearchVehiclesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.v1.SearchVehiclesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VehicleServiceMethodDescriptorSupplier("SearchVehicles"))
                      .build();
        }
      }
    }
    return getSearchVehiclesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.maps.fleetengine.v1.SearchVehiclesRequest,
          google.maps.fleetengine.v1.SearchVehiclesResponse>
      getSearchFuzzedVehiclesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchFuzzedVehicles",
      requestType = google.maps.fleetengine.v1.SearchVehiclesRequest.class,
      responseType = google.maps.fleetengine.v1.SearchVehiclesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.maps.fleetengine.v1.SearchVehiclesRequest,
          google.maps.fleetengine.v1.SearchVehiclesResponse>
      getSearchFuzzedVehiclesMethod() {
    io.grpc.MethodDescriptor<
            google.maps.fleetengine.v1.SearchVehiclesRequest,
            google.maps.fleetengine.v1.SearchVehiclesResponse>
        getSearchFuzzedVehiclesMethod;
    if ((getSearchFuzzedVehiclesMethod = VehicleServiceGrpc.getSearchFuzzedVehiclesMethod)
        == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getSearchFuzzedVehiclesMethod = VehicleServiceGrpc.getSearchFuzzedVehiclesMethod)
            == null) {
          VehicleServiceGrpc.getSearchFuzzedVehiclesMethod =
              getSearchFuzzedVehiclesMethod =
                  io.grpc.MethodDescriptor
                      .<google.maps.fleetengine.v1.SearchVehiclesRequest,
                          google.maps.fleetengine.v1.SearchVehiclesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SearchFuzzedVehicles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.v1.SearchVehiclesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.maps.fleetengine.v1.SearchVehiclesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VehicleServiceMethodDescriptorSupplier("SearchFuzzedVehicles"))
                      .build();
        }
      }
    }
    return getSearchFuzzedVehiclesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static VehicleServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VehicleServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VehicleServiceStub>() {
          @java.lang.Override
          public VehicleServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VehicleServiceStub(channel, callOptions);
          }
        };
    return VehicleServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VehicleServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VehicleServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VehicleServiceBlockingStub>() {
          @java.lang.Override
          public VehicleServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VehicleServiceBlockingStub(channel, callOptions);
          }
        };
    return VehicleServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static VehicleServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VehicleServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VehicleServiceFutureStub>() {
          @java.lang.Override
          public VehicleServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VehicleServiceFutureStub(channel, callOptions);
          }
        };
    return VehicleServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Vehicle management service.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Instantiates a new vehicle associated with an on-demand rideshare or
     * deliveries provider. Each `Vehicle` must have a unique vehicle ID.
     * The following `Vehicle` fields are required when creating a `Vehicle`:
     * * `vehicleState`
     * * `supportedTripTypes`
     * * `maximumCapacity`
     * * `vehicleType`
     * The following `Vehicle` fields are ignored when creating a `Vehicle`:
     * * `name`
     * * `currentTrips`
     * * `availableCapacity`
     * * `current_route_segment`
     * * `current_route_segment_end_point`
     * * `current_route_segment_version`
     * * `current_route_segment_traffic`
     * * `route`
     * * `waypoints`
     * * `waypoints_version`
     * * `remaining_distance_meters`
     * * `remaining_time_seconds`
     * * `eta_to_next_waypoint`
     * * `navigation_status`
     * All other fields are optional and used if provided.
     * </pre>
     */
    default void createVehicle(
        google.maps.fleetengine.v1.CreateVehicleRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.Vehicle> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateVehicleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a vehicle from the Fleet Engine.
     * </pre>
     */
    default void getVehicle(
        google.maps.fleetengine.v1.GetVehicleRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.Vehicle> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetVehicleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Writes updated vehicle data to the Fleet Engine.
     * When updating a `Vehicle`, the following fields cannot be updated since
     * they are managed by the server:
     * * `currentTrips`
     * * `availableCapacity`
     * * `current_route_segment_version`
     * * `waypoints_version`
     * The vehicle `name` also cannot be updated.
     * If the `attributes` field is updated, **all** the vehicle's attributes are
     * replaced with the attributes provided in the request. If you want to update
     * only some attributes, see the `UpdateVehicleAttributes` method. Likewise,
     * the `waypoints` field can be updated, but must contain all the waypoints
     * currently on the vehicle, and no other waypoints.
     * </pre>
     */
    default void updateVehicle(
        google.maps.fleetengine.v1.UpdateVehicleRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.Vehicle> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateVehicleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use the `UpdateVehicle` method instead.
     * UpdateVehicleLocation updates the location of the vehicle.
     * </pre>
     */
    @java.lang.Deprecated
    default void updateVehicleLocation(
        google.maps.fleetengine.v1.UpdateVehicleLocationRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.VehicleLocation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateVehicleLocationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Partially updates a vehicle's attributes.
     * Only the attributes mentioned in the request will be updated, other
     * attributes will NOT be altered. Note: this is different in `UpdateVehicle`,
     * where the whole `attributes` field will be replaced by the one in
     * `UpdateVehicleRequest`, attributes not in the request would be removed.
     * </pre>
     */
    default void updateVehicleAttributes(
        google.maps.fleetengine.v1.UpdateVehicleAttributesRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.UpdateVehicleAttributesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateVehicleAttributesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a paginated list of vehicles associated with
     * a provider that match the request options.
     * </pre>
     */
    default void listVehicles(
        google.maps.fleetengine.v1.ListVehiclesRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.ListVehiclesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListVehiclesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of vehicles that match the request options.
     * </pre>
     */
    default void searchVehicles(
        google.maps.fleetengine.v1.SearchVehiclesRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.SearchVehiclesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchVehiclesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `SearchVehicles` instead.
     * </pre>
     */
    @java.lang.Deprecated
    default void searchFuzzedVehicles(
        google.maps.fleetengine.v1.SearchVehiclesRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.SearchVehiclesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchFuzzedVehiclesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service VehicleService.
   *
   * <pre>
   * Vehicle management service.
   * </pre>
   */
  public abstract static class VehicleServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return VehicleServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service VehicleService.
   *
   * <pre>
   * Vehicle management service.
   * </pre>
   */
  public static final class VehicleServiceStub
      extends io.grpc.stub.AbstractAsyncStub<VehicleServiceStub> {
    private VehicleServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VehicleServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VehicleServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Instantiates a new vehicle associated with an on-demand rideshare or
     * deliveries provider. Each `Vehicle` must have a unique vehicle ID.
     * The following `Vehicle` fields are required when creating a `Vehicle`:
     * * `vehicleState`
     * * `supportedTripTypes`
     * * `maximumCapacity`
     * * `vehicleType`
     * The following `Vehicle` fields are ignored when creating a `Vehicle`:
     * * `name`
     * * `currentTrips`
     * * `availableCapacity`
     * * `current_route_segment`
     * * `current_route_segment_end_point`
     * * `current_route_segment_version`
     * * `current_route_segment_traffic`
     * * `route`
     * * `waypoints`
     * * `waypoints_version`
     * * `remaining_distance_meters`
     * * `remaining_time_seconds`
     * * `eta_to_next_waypoint`
     * * `navigation_status`
     * All other fields are optional and used if provided.
     * </pre>
     */
    public void createVehicle(
        google.maps.fleetengine.v1.CreateVehicleRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.Vehicle> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateVehicleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a vehicle from the Fleet Engine.
     * </pre>
     */
    public void getVehicle(
        google.maps.fleetengine.v1.GetVehicleRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.Vehicle> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVehicleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Writes updated vehicle data to the Fleet Engine.
     * When updating a `Vehicle`, the following fields cannot be updated since
     * they are managed by the server:
     * * `currentTrips`
     * * `availableCapacity`
     * * `current_route_segment_version`
     * * `waypoints_version`
     * The vehicle `name` also cannot be updated.
     * If the `attributes` field is updated, **all** the vehicle's attributes are
     * replaced with the attributes provided in the request. If you want to update
     * only some attributes, see the `UpdateVehicleAttributes` method. Likewise,
     * the `waypoints` field can be updated, but must contain all the waypoints
     * currently on the vehicle, and no other waypoints.
     * </pre>
     */
    public void updateVehicle(
        google.maps.fleetengine.v1.UpdateVehicleRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.Vehicle> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVehicleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use the `UpdateVehicle` method instead.
     * UpdateVehicleLocation updates the location of the vehicle.
     * </pre>
     */
    @java.lang.Deprecated
    public void updateVehicleLocation(
        google.maps.fleetengine.v1.UpdateVehicleLocationRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.VehicleLocation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVehicleLocationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Partially updates a vehicle's attributes.
     * Only the attributes mentioned in the request will be updated, other
     * attributes will NOT be altered. Note: this is different in `UpdateVehicle`,
     * where the whole `attributes` field will be replaced by the one in
     * `UpdateVehicleRequest`, attributes not in the request would be removed.
     * </pre>
     */
    public void updateVehicleAttributes(
        google.maps.fleetengine.v1.UpdateVehicleAttributesRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.UpdateVehicleAttributesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVehicleAttributesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a paginated list of vehicles associated with
     * a provider that match the request options.
     * </pre>
     */
    public void listVehicles(
        google.maps.fleetengine.v1.ListVehiclesRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.ListVehiclesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVehiclesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of vehicles that match the request options.
     * </pre>
     */
    public void searchVehicles(
        google.maps.fleetengine.v1.SearchVehiclesRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.SearchVehiclesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchVehiclesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `SearchVehicles` instead.
     * </pre>
     */
    @java.lang.Deprecated
    public void searchFuzzedVehicles(
        google.maps.fleetengine.v1.SearchVehiclesRequest request,
        io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.SearchVehiclesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchFuzzedVehiclesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service VehicleService.
   *
   * <pre>
   * Vehicle management service.
   * </pre>
   */
  public static final class VehicleServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<VehicleServiceBlockingStub> {
    private VehicleServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VehicleServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VehicleServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Instantiates a new vehicle associated with an on-demand rideshare or
     * deliveries provider. Each `Vehicle` must have a unique vehicle ID.
     * The following `Vehicle` fields are required when creating a `Vehicle`:
     * * `vehicleState`
     * * `supportedTripTypes`
     * * `maximumCapacity`
     * * `vehicleType`
     * The following `Vehicle` fields are ignored when creating a `Vehicle`:
     * * `name`
     * * `currentTrips`
     * * `availableCapacity`
     * * `current_route_segment`
     * * `current_route_segment_end_point`
     * * `current_route_segment_version`
     * * `current_route_segment_traffic`
     * * `route`
     * * `waypoints`
     * * `waypoints_version`
     * * `remaining_distance_meters`
     * * `remaining_time_seconds`
     * * `eta_to_next_waypoint`
     * * `navigation_status`
     * All other fields are optional and used if provided.
     * </pre>
     */
    public google.maps.fleetengine.v1.Vehicle createVehicle(
        google.maps.fleetengine.v1.CreateVehicleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateVehicleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a vehicle from the Fleet Engine.
     * </pre>
     */
    public google.maps.fleetengine.v1.Vehicle getVehicle(
        google.maps.fleetengine.v1.GetVehicleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVehicleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Writes updated vehicle data to the Fleet Engine.
     * When updating a `Vehicle`, the following fields cannot be updated since
     * they are managed by the server:
     * * `currentTrips`
     * * `availableCapacity`
     * * `current_route_segment_version`
     * * `waypoints_version`
     * The vehicle `name` also cannot be updated.
     * If the `attributes` field is updated, **all** the vehicle's attributes are
     * replaced with the attributes provided in the request. If you want to update
     * only some attributes, see the `UpdateVehicleAttributes` method. Likewise,
     * the `waypoints` field can be updated, but must contain all the waypoints
     * currently on the vehicle, and no other waypoints.
     * </pre>
     */
    public google.maps.fleetengine.v1.Vehicle updateVehicle(
        google.maps.fleetengine.v1.UpdateVehicleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVehicleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use the `UpdateVehicle` method instead.
     * UpdateVehicleLocation updates the location of the vehicle.
     * </pre>
     */
    @java.lang.Deprecated
    public google.maps.fleetengine.v1.VehicleLocation updateVehicleLocation(
        google.maps.fleetengine.v1.UpdateVehicleLocationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVehicleLocationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Partially updates a vehicle's attributes.
     * Only the attributes mentioned in the request will be updated, other
     * attributes will NOT be altered. Note: this is different in `UpdateVehicle`,
     * where the whole `attributes` field will be replaced by the one in
     * `UpdateVehicleRequest`, attributes not in the request would be removed.
     * </pre>
     */
    public google.maps.fleetengine.v1.UpdateVehicleAttributesResponse updateVehicleAttributes(
        google.maps.fleetengine.v1.UpdateVehicleAttributesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVehicleAttributesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a paginated list of vehicles associated with
     * a provider that match the request options.
     * </pre>
     */
    public google.maps.fleetengine.v1.ListVehiclesResponse listVehicles(
        google.maps.fleetengine.v1.ListVehiclesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVehiclesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of vehicles that match the request options.
     * </pre>
     */
    public google.maps.fleetengine.v1.SearchVehiclesResponse searchVehicles(
        google.maps.fleetengine.v1.SearchVehiclesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchVehiclesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `SearchVehicles` instead.
     * </pre>
     */
    @java.lang.Deprecated
    public google.maps.fleetengine.v1.SearchVehiclesResponse searchFuzzedVehicles(
        google.maps.fleetengine.v1.SearchVehiclesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchFuzzedVehiclesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service VehicleService.
   *
   * <pre>
   * Vehicle management service.
   * </pre>
   */
  public static final class VehicleServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<VehicleServiceFutureStub> {
    private VehicleServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VehicleServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VehicleServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Instantiates a new vehicle associated with an on-demand rideshare or
     * deliveries provider. Each `Vehicle` must have a unique vehicle ID.
     * The following `Vehicle` fields are required when creating a `Vehicle`:
     * * `vehicleState`
     * * `supportedTripTypes`
     * * `maximumCapacity`
     * * `vehicleType`
     * The following `Vehicle` fields are ignored when creating a `Vehicle`:
     * * `name`
     * * `currentTrips`
     * * `availableCapacity`
     * * `current_route_segment`
     * * `current_route_segment_end_point`
     * * `current_route_segment_version`
     * * `current_route_segment_traffic`
     * * `route`
     * * `waypoints`
     * * `waypoints_version`
     * * `remaining_distance_meters`
     * * `remaining_time_seconds`
     * * `eta_to_next_waypoint`
     * * `navigation_status`
     * All other fields are optional and used if provided.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<google.maps.fleetengine.v1.Vehicle>
        createVehicle(google.maps.fleetengine.v1.CreateVehicleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateVehicleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a vehicle from the Fleet Engine.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<google.maps.fleetengine.v1.Vehicle>
        getVehicle(google.maps.fleetengine.v1.GetVehicleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVehicleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Writes updated vehicle data to the Fleet Engine.
     * When updating a `Vehicle`, the following fields cannot be updated since
     * they are managed by the server:
     * * `currentTrips`
     * * `availableCapacity`
     * * `current_route_segment_version`
     * * `waypoints_version`
     * The vehicle `name` also cannot be updated.
     * If the `attributes` field is updated, **all** the vehicle's attributes are
     * replaced with the attributes provided in the request. If you want to update
     * only some attributes, see the `UpdateVehicleAttributes` method. Likewise,
     * the `waypoints` field can be updated, but must contain all the waypoints
     * currently on the vehicle, and no other waypoints.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<google.maps.fleetengine.v1.Vehicle>
        updateVehicle(google.maps.fleetengine.v1.UpdateVehicleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVehicleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use the `UpdateVehicle` method instead.
     * UpdateVehicleLocation updates the location of the vehicle.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<
            google.maps.fleetengine.v1.VehicleLocation>
        updateVehicleLocation(google.maps.fleetengine.v1.UpdateVehicleLocationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVehicleLocationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Partially updates a vehicle's attributes.
     * Only the attributes mentioned in the request will be updated, other
     * attributes will NOT be altered. Note: this is different in `UpdateVehicle`,
     * where the whole `attributes` field will be replaced by the one in
     * `UpdateVehicleRequest`, attributes not in the request would be removed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.maps.fleetengine.v1.UpdateVehicleAttributesResponse>
        updateVehicleAttributes(google.maps.fleetengine.v1.UpdateVehicleAttributesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVehicleAttributesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a paginated list of vehicles associated with
     * a provider that match the request options.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.maps.fleetengine.v1.ListVehiclesResponse>
        listVehicles(google.maps.fleetengine.v1.ListVehiclesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVehiclesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of vehicles that match the request options.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.maps.fleetengine.v1.SearchVehiclesResponse>
        searchVehicles(google.maps.fleetengine.v1.SearchVehiclesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchVehiclesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use `SearchVehicles` instead.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<
            google.maps.fleetengine.v1.SearchVehiclesResponse>
        searchFuzzedVehicles(google.maps.fleetengine.v1.SearchVehiclesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchFuzzedVehiclesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_VEHICLE = 0;
  private static final int METHODID_GET_VEHICLE = 1;
  private static final int METHODID_UPDATE_VEHICLE = 2;
  private static final int METHODID_UPDATE_VEHICLE_LOCATION = 3;
  private static final int METHODID_UPDATE_VEHICLE_ATTRIBUTES = 4;
  private static final int METHODID_LIST_VEHICLES = 5;
  private static final int METHODID_SEARCH_VEHICLES = 6;
  private static final int METHODID_SEARCH_FUZZED_VEHICLES = 7;

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
        case METHODID_CREATE_VEHICLE:
          serviceImpl.createVehicle(
              (google.maps.fleetengine.v1.CreateVehicleRequest) request,
              (io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.Vehicle>) responseObserver);
          break;
        case METHODID_GET_VEHICLE:
          serviceImpl.getVehicle(
              (google.maps.fleetengine.v1.GetVehicleRequest) request,
              (io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.Vehicle>) responseObserver);
          break;
        case METHODID_UPDATE_VEHICLE:
          serviceImpl.updateVehicle(
              (google.maps.fleetengine.v1.UpdateVehicleRequest) request,
              (io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.Vehicle>) responseObserver);
          break;
        case METHODID_UPDATE_VEHICLE_LOCATION:
          serviceImpl.updateVehicleLocation(
              (google.maps.fleetengine.v1.UpdateVehicleLocationRequest) request,
              (io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.VehicleLocation>)
                  responseObserver);
          break;
        case METHODID_UPDATE_VEHICLE_ATTRIBUTES:
          serviceImpl.updateVehicleAttributes(
              (google.maps.fleetengine.v1.UpdateVehicleAttributesRequest) request,
              (io.grpc.stub.StreamObserver<
                      google.maps.fleetengine.v1.UpdateVehicleAttributesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_VEHICLES:
          serviceImpl.listVehicles(
              (google.maps.fleetengine.v1.ListVehiclesRequest) request,
              (io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.ListVehiclesResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_VEHICLES:
          serviceImpl.searchVehicles(
              (google.maps.fleetengine.v1.SearchVehiclesRequest) request,
              (io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.SearchVehiclesResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_FUZZED_VEHICLES:
          serviceImpl.searchFuzzedVehicles(
              (google.maps.fleetengine.v1.SearchVehiclesRequest) request,
              (io.grpc.stub.StreamObserver<google.maps.fleetengine.v1.SearchVehiclesResponse>)
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
            getCreateVehicleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.maps.fleetengine.v1.CreateVehicleRequest,
                    google.maps.fleetengine.v1.Vehicle>(service, METHODID_CREATE_VEHICLE)))
        .addMethod(
            getGetVehicleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.maps.fleetengine.v1.GetVehicleRequest,
                    google.maps.fleetengine.v1.Vehicle>(service, METHODID_GET_VEHICLE)))
        .addMethod(
            getUpdateVehicleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.maps.fleetengine.v1.UpdateVehicleRequest,
                    google.maps.fleetengine.v1.Vehicle>(service, METHODID_UPDATE_VEHICLE)))
        .addMethod(
            getUpdateVehicleLocationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.maps.fleetengine.v1.UpdateVehicleLocationRequest,
                    google.maps.fleetengine.v1.VehicleLocation>(
                    service, METHODID_UPDATE_VEHICLE_LOCATION)))
        .addMethod(
            getUpdateVehicleAttributesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.maps.fleetengine.v1.UpdateVehicleAttributesRequest,
                    google.maps.fleetengine.v1.UpdateVehicleAttributesResponse>(
                    service, METHODID_UPDATE_VEHICLE_ATTRIBUTES)))
        .addMethod(
            getListVehiclesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.maps.fleetengine.v1.ListVehiclesRequest,
                    google.maps.fleetengine.v1.ListVehiclesResponse>(
                    service, METHODID_LIST_VEHICLES)))
        .addMethod(
            getSearchVehiclesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.maps.fleetengine.v1.SearchVehiclesRequest,
                    google.maps.fleetengine.v1.SearchVehiclesResponse>(
                    service, METHODID_SEARCH_VEHICLES)))
        .addMethod(
            getSearchFuzzedVehiclesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.maps.fleetengine.v1.SearchVehiclesRequest,
                    google.maps.fleetengine.v1.SearchVehiclesResponse>(
                    service, METHODID_SEARCH_FUZZED_VEHICLES)))
        .build();
  }

  private abstract static class VehicleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VehicleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return google.maps.fleetengine.v1.VehicleApi.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VehicleService");
    }
  }

  private static final class VehicleServiceFileDescriptorSupplier
      extends VehicleServiceBaseDescriptorSupplier {
    VehicleServiceFileDescriptorSupplier() {}
  }

  private static final class VehicleServiceMethodDescriptorSupplier
      extends VehicleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    VehicleServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (VehicleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new VehicleServiceFileDescriptorSupplier())
                      .addMethod(getCreateVehicleMethod())
                      .addMethod(getGetVehicleMethod())
                      .addMethod(getUpdateVehicleMethod())
                      .addMethod(getUpdateVehicleLocationMethod())
                      .addMethod(getUpdateVehicleAttributesMethod())
                      .addMethod(getListVehiclesMethod())
                      .addMethod(getSearchVehiclesMethod())
                      .addMethod(getSearchFuzzedVehiclesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
