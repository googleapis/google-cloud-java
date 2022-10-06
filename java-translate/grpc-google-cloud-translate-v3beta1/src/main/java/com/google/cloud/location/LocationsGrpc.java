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
package com.google.cloud.location;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * An abstract interface that provides location-related information for
 * a service. Service-specific metadata is provided through the
 * [Location.metadata][google.cloud.location.Location.metadata] field.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/location/locations.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LocationsGrpc {

  private LocationsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.location.Locations";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.location.ListLocationsRequest,
          com.google.cloud.location.ListLocationsResponse>
      getListLocationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLocations",
      requestType = com.google.cloud.location.ListLocationsRequest.class,
      responseType = com.google.cloud.location.ListLocationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.location.ListLocationsRequest,
          com.google.cloud.location.ListLocationsResponse>
      getListLocationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.location.ListLocationsRequest,
            com.google.cloud.location.ListLocationsResponse>
        getListLocationsMethod;
    if ((getListLocationsMethod = LocationsGrpc.getListLocationsMethod) == null) {
      synchronized (LocationsGrpc.class) {
        if ((getListLocationsMethod = LocationsGrpc.getListLocationsMethod) == null) {
          LocationsGrpc.getListLocationsMethod =
              getListLocationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.location.ListLocationsRequest,
                          com.google.cloud.location.ListLocationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListLocations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.location.ListLocationsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.location.ListLocationsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new LocationsMethodDescriptorSupplier("ListLocations"))
                      .build();
        }
      }
    }
    return getListLocationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.location.GetLocationRequest, com.google.cloud.location.Location>
      getGetLocationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLocation",
      requestType = com.google.cloud.location.GetLocationRequest.class,
      responseType = com.google.cloud.location.Location.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.location.GetLocationRequest, com.google.cloud.location.Location>
      getGetLocationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.location.GetLocationRequest, com.google.cloud.location.Location>
        getGetLocationMethod;
    if ((getGetLocationMethod = LocationsGrpc.getGetLocationMethod) == null) {
      synchronized (LocationsGrpc.class) {
        if ((getGetLocationMethod = LocationsGrpc.getGetLocationMethod) == null) {
          LocationsGrpc.getGetLocationMethod =
              getGetLocationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.location.GetLocationRequest,
                          com.google.cloud.location.Location>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLocation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.location.GetLocationRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.location.Location.getDefaultInstance()))
                      .setSchemaDescriptor(new LocationsMethodDescriptorSupplier("GetLocation"))
                      .build();
        }
      }
    }
    return getGetLocationMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static LocationsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LocationsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LocationsStub>() {
          @java.lang.Override
          public LocationsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LocationsStub(channel, callOptions);
          }
        };
    return LocationsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LocationsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LocationsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LocationsBlockingStub>() {
          @java.lang.Override
          public LocationsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LocationsBlockingStub(channel, callOptions);
          }
        };
    return LocationsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static LocationsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LocationsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LocationsFutureStub>() {
          @java.lang.Override
          public LocationsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LocationsFutureStub(channel, callOptions);
          }
        };
    return LocationsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * An abstract interface that provides location-related information for
   * a service. Service-specific metadata is provided through the
   * [Location.metadata][google.cloud.location.Location.metadata] field.
   * </pre>
   */
  public abstract static class LocationsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists information about the supported locations for this service.
     * </pre>
     */
    public void listLocations(
        com.google.cloud.location.ListLocationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.location.ListLocationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListLocationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a location.
     * </pre>
     */
    public void getLocation(
        com.google.cloud.location.GetLocationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.location.Location> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetLocationMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListLocationsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.location.ListLocationsRequest,
                      com.google.cloud.location.ListLocationsResponse>(
                      this, METHODID_LIST_LOCATIONS)))
          .addMethod(
              getGetLocationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.location.GetLocationRequest,
                      com.google.cloud.location.Location>(this, METHODID_GET_LOCATION)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * An abstract interface that provides location-related information for
   * a service. Service-specific metadata is provided through the
   * [Location.metadata][google.cloud.location.Location.metadata] field.
   * </pre>
   */
  public static final class LocationsStub extends io.grpc.stub.AbstractAsyncStub<LocationsStub> {
    private LocationsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LocationsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocationsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists information about the supported locations for this service.
     * </pre>
     */
    public void listLocations(
        com.google.cloud.location.ListLocationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.location.ListLocationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLocationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a location.
     * </pre>
     */
    public void getLocation(
        com.google.cloud.location.GetLocationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.location.Location> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLocationMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * An abstract interface that provides location-related information for
   * a service. Service-specific metadata is provided through the
   * [Location.metadata][google.cloud.location.Location.metadata] field.
   * </pre>
   */
  public static final class LocationsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LocationsBlockingStub> {
    private LocationsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LocationsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocationsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists information about the supported locations for this service.
     * </pre>
     */
    public com.google.cloud.location.ListLocationsResponse listLocations(
        com.google.cloud.location.ListLocationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLocationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a location.
     * </pre>
     */
    public com.google.cloud.location.Location getLocation(
        com.google.cloud.location.GetLocationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLocationMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * An abstract interface that provides location-related information for
   * a service. Service-specific metadata is provided through the
   * [Location.metadata][google.cloud.location.Location.metadata] field.
   * </pre>
   */
  public static final class LocationsFutureStub
      extends io.grpc.stub.AbstractFutureStub<LocationsFutureStub> {
    private LocationsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LocationsFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocationsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists information about the supported locations for this service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.location.ListLocationsResponse>
        listLocations(com.google.cloud.location.ListLocationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLocationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.location.Location>
        getLocation(com.google.cloud.location.GetLocationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLocationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_LOCATIONS = 0;
  private static final int METHODID_GET_LOCATION = 1;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LocationsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LocationsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_LOCATIONS:
          serviceImpl.listLocations(
              (com.google.cloud.location.ListLocationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.location.ListLocationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_LOCATION:
          serviceImpl.getLocation(
              (com.google.cloud.location.GetLocationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.location.Location>) responseObserver);
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

  private abstract static class LocationsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LocationsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.location.LocationsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Locations");
    }
  }

  private static final class LocationsFileDescriptorSupplier
      extends LocationsBaseDescriptorSupplier {
    LocationsFileDescriptorSupplier() {}
  }

  private static final class LocationsMethodDescriptorSupplier
      extends LocationsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LocationsMethodDescriptorSupplier(String methodName) {
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
      synchronized (LocationsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new LocationsFileDescriptorSupplier())
                      .addMethod(getListLocationsMethod())
                      .addMethod(getGetLocationMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
