/*
 * Copyright 2026 Google LLC
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
package com.google.maps.geocode.v4;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service for performing geocoding.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class GeocodeServiceGrpc {

  private GeocodeServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.maps.geocode.v4.GeocodeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.geocode.v4.GeocodeAddressRequest,
          com.google.maps.geocode.v4.GeocodeAddressResponse>
      getGeocodeAddressMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GeocodeAddress",
      requestType = com.google.maps.geocode.v4.GeocodeAddressRequest.class,
      responseType = com.google.maps.geocode.v4.GeocodeAddressResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.geocode.v4.GeocodeAddressRequest,
          com.google.maps.geocode.v4.GeocodeAddressResponse>
      getGeocodeAddressMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.geocode.v4.GeocodeAddressRequest,
            com.google.maps.geocode.v4.GeocodeAddressResponse>
        getGeocodeAddressMethod;
    if ((getGeocodeAddressMethod = GeocodeServiceGrpc.getGeocodeAddressMethod) == null) {
      synchronized (GeocodeServiceGrpc.class) {
        if ((getGeocodeAddressMethod = GeocodeServiceGrpc.getGeocodeAddressMethod) == null) {
          GeocodeServiceGrpc.getGeocodeAddressMethod =
              getGeocodeAddressMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.geocode.v4.GeocodeAddressRequest,
                          com.google.maps.geocode.v4.GeocodeAddressResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GeocodeAddress"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.geocode.v4.GeocodeAddressRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.geocode.v4.GeocodeAddressResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GeocodeServiceMethodDescriptorSupplier("GeocodeAddress"))
                      .build();
        }
      }
    }
    return getGeocodeAddressMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.geocode.v4.GeocodeLocationRequest,
          com.google.maps.geocode.v4.GeocodeLocationResponse>
      getGeocodeLocationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GeocodeLocation",
      requestType = com.google.maps.geocode.v4.GeocodeLocationRequest.class,
      responseType = com.google.maps.geocode.v4.GeocodeLocationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.geocode.v4.GeocodeLocationRequest,
          com.google.maps.geocode.v4.GeocodeLocationResponse>
      getGeocodeLocationMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.geocode.v4.GeocodeLocationRequest,
            com.google.maps.geocode.v4.GeocodeLocationResponse>
        getGeocodeLocationMethod;
    if ((getGeocodeLocationMethod = GeocodeServiceGrpc.getGeocodeLocationMethod) == null) {
      synchronized (GeocodeServiceGrpc.class) {
        if ((getGeocodeLocationMethod = GeocodeServiceGrpc.getGeocodeLocationMethod) == null) {
          GeocodeServiceGrpc.getGeocodeLocationMethod =
              getGeocodeLocationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.geocode.v4.GeocodeLocationRequest,
                          com.google.maps.geocode.v4.GeocodeLocationResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GeocodeLocation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.geocode.v4.GeocodeLocationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.geocode.v4.GeocodeLocationResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GeocodeServiceMethodDescriptorSupplier("GeocodeLocation"))
                      .build();
        }
      }
    }
    return getGeocodeLocationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.geocode.v4.GeocodePlaceRequest, com.google.maps.geocode.v4.GeocodeResult>
      getGeocodePlaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GeocodePlace",
      requestType = com.google.maps.geocode.v4.GeocodePlaceRequest.class,
      responseType = com.google.maps.geocode.v4.GeocodeResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.geocode.v4.GeocodePlaceRequest, com.google.maps.geocode.v4.GeocodeResult>
      getGeocodePlaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.geocode.v4.GeocodePlaceRequest,
            com.google.maps.geocode.v4.GeocodeResult>
        getGeocodePlaceMethod;
    if ((getGeocodePlaceMethod = GeocodeServiceGrpc.getGeocodePlaceMethod) == null) {
      synchronized (GeocodeServiceGrpc.class) {
        if ((getGeocodePlaceMethod = GeocodeServiceGrpc.getGeocodePlaceMethod) == null) {
          GeocodeServiceGrpc.getGeocodePlaceMethod =
              getGeocodePlaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.geocode.v4.GeocodePlaceRequest,
                          com.google.maps.geocode.v4.GeocodeResult>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GeocodePlace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.geocode.v4.GeocodePlaceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.geocode.v4.GeocodeResult.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GeocodeServiceMethodDescriptorSupplier("GeocodePlace"))
                      .build();
        }
      }
    }
    return getGeocodePlaceMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static GeocodeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GeocodeServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GeocodeServiceStub>() {
          @java.lang.Override
          public GeocodeServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GeocodeServiceStub(channel, callOptions);
          }
        };
    return GeocodeServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static GeocodeServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GeocodeServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GeocodeServiceBlockingV2Stub>() {
          @java.lang.Override
          public GeocodeServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GeocodeServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return GeocodeServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GeocodeServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GeocodeServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GeocodeServiceBlockingStub>() {
          @java.lang.Override
          public GeocodeServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GeocodeServiceBlockingStub(channel, callOptions);
          }
        };
    return GeocodeServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static GeocodeServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GeocodeServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GeocodeServiceFutureStub>() {
          @java.lang.Override
          public GeocodeServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GeocodeServiceFutureStub(channel, callOptions);
          }
        };
    return GeocodeServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service for performing geocoding.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * This method performs an address geocode, which maps an address to a
     * LatLng. It also provides structured information about the address.
     * </pre>
     */
    default void geocodeAddress(
        com.google.maps.geocode.v4.GeocodeAddressRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.geocode.v4.GeocodeAddressResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGeocodeAddressMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method performs a location geocode, which maps a LatLng to an
     * address. It also provides structured information about the address.
     * </pre>
     */
    default void geocodeLocation(
        com.google.maps.geocode.v4.GeocodeLocationRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.geocode.v4.GeocodeLocationResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGeocodeLocationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method performs a geocode lookup using a place ID.
     * </pre>
     */
    default void geocodePlace(
        com.google.maps.geocode.v4.GeocodePlaceRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.geocode.v4.GeocodeResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGeocodePlaceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GeocodeService.
   *
   * <pre>
   * A service for performing geocoding.
   * </pre>
   */
  public abstract static class GeocodeServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return GeocodeServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GeocodeService.
   *
   * <pre>
   * A service for performing geocoding.
   * </pre>
   */
  public static final class GeocodeServiceStub
      extends io.grpc.stub.AbstractAsyncStub<GeocodeServiceStub> {
    private GeocodeServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeocodeServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GeocodeServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * This method performs an address geocode, which maps an address to a
     * LatLng. It also provides structured information about the address.
     * </pre>
     */
    public void geocodeAddress(
        com.google.maps.geocode.v4.GeocodeAddressRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.geocode.v4.GeocodeAddressResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGeocodeAddressMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method performs a location geocode, which maps a LatLng to an
     * address. It also provides structured information about the address.
     * </pre>
     */
    public void geocodeLocation(
        com.google.maps.geocode.v4.GeocodeLocationRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.geocode.v4.GeocodeLocationResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGeocodeLocationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method performs a geocode lookup using a place ID.
     * </pre>
     */
    public void geocodePlace(
        com.google.maps.geocode.v4.GeocodePlaceRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.geocode.v4.GeocodeResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGeocodePlaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GeocodeService.
   *
   * <pre>
   * A service for performing geocoding.
   * </pre>
   */
  public static final class GeocodeServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<GeocodeServiceBlockingV2Stub> {
    private GeocodeServiceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeocodeServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GeocodeServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * This method performs an address geocode, which maps an address to a
     * LatLng. It also provides structured information about the address.
     * </pre>
     */
    public com.google.maps.geocode.v4.GeocodeAddressResponse geocodeAddress(
        com.google.maps.geocode.v4.GeocodeAddressRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGeocodeAddressMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method performs a location geocode, which maps a LatLng to an
     * address. It also provides structured information about the address.
     * </pre>
     */
    public com.google.maps.geocode.v4.GeocodeLocationResponse geocodeLocation(
        com.google.maps.geocode.v4.GeocodeLocationRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGeocodeLocationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method performs a geocode lookup using a place ID.
     * </pre>
     */
    public com.google.maps.geocode.v4.GeocodeResult geocodePlace(
        com.google.maps.geocode.v4.GeocodePlaceRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGeocodePlaceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service GeocodeService.
   *
   * <pre>
   * A service for performing geocoding.
   * </pre>
   */
  public static final class GeocodeServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GeocodeServiceBlockingStub> {
    private GeocodeServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeocodeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GeocodeServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * This method performs an address geocode, which maps an address to a
     * LatLng. It also provides structured information about the address.
     * </pre>
     */
    public com.google.maps.geocode.v4.GeocodeAddressResponse geocodeAddress(
        com.google.maps.geocode.v4.GeocodeAddressRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGeocodeAddressMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method performs a location geocode, which maps a LatLng to an
     * address. It also provides structured information about the address.
     * </pre>
     */
    public com.google.maps.geocode.v4.GeocodeLocationResponse geocodeLocation(
        com.google.maps.geocode.v4.GeocodeLocationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGeocodeLocationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method performs a geocode lookup using a place ID.
     * </pre>
     */
    public com.google.maps.geocode.v4.GeocodeResult geocodePlace(
        com.google.maps.geocode.v4.GeocodePlaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGeocodePlaceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GeocodeService.
   *
   * <pre>
   * A service for performing geocoding.
   * </pre>
   */
  public static final class GeocodeServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<GeocodeServiceFutureStub> {
    private GeocodeServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeocodeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GeocodeServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * This method performs an address geocode, which maps an address to a
     * LatLng. It also provides structured information about the address.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.geocode.v4.GeocodeAddressResponse>
        geocodeAddress(com.google.maps.geocode.v4.GeocodeAddressRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGeocodeAddressMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * This method performs a location geocode, which maps a LatLng to an
     * address. It also provides structured information about the address.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.geocode.v4.GeocodeLocationResponse>
        geocodeLocation(com.google.maps.geocode.v4.GeocodeLocationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGeocodeLocationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * This method performs a geocode lookup using a place ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.geocode.v4.GeocodeResult>
        geocodePlace(com.google.maps.geocode.v4.GeocodePlaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGeocodePlaceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GEOCODE_ADDRESS = 0;
  private static final int METHODID_GEOCODE_LOCATION = 1;
  private static final int METHODID_GEOCODE_PLACE = 2;

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
        case METHODID_GEOCODE_ADDRESS:
          serviceImpl.geocodeAddress(
              (com.google.maps.geocode.v4.GeocodeAddressRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.geocode.v4.GeocodeAddressResponse>)
                  responseObserver);
          break;
        case METHODID_GEOCODE_LOCATION:
          serviceImpl.geocodeLocation(
              (com.google.maps.geocode.v4.GeocodeLocationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.geocode.v4.GeocodeLocationResponse>)
                  responseObserver);
          break;
        case METHODID_GEOCODE_PLACE:
          serviceImpl.geocodePlace(
              (com.google.maps.geocode.v4.GeocodePlaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.geocode.v4.GeocodeResult>)
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
            getGeocodeAddressMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.geocode.v4.GeocodeAddressRequest,
                    com.google.maps.geocode.v4.GeocodeAddressResponse>(
                    service, METHODID_GEOCODE_ADDRESS)))
        .addMethod(
            getGeocodeLocationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.geocode.v4.GeocodeLocationRequest,
                    com.google.maps.geocode.v4.GeocodeLocationResponse>(
                    service, METHODID_GEOCODE_LOCATION)))
        .addMethod(
            getGeocodePlaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.geocode.v4.GeocodePlaceRequest,
                    com.google.maps.geocode.v4.GeocodeResult>(service, METHODID_GEOCODE_PLACE)))
        .build();
  }

  private abstract static class GeocodeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GeocodeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.maps.geocode.v4.GeocodeServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GeocodeService");
    }
  }

  private static final class GeocodeServiceFileDescriptorSupplier
      extends GeocodeServiceBaseDescriptorSupplier {
    GeocodeServiceFileDescriptorSupplier() {}
  }

  private static final class GeocodeServiceMethodDescriptorSupplier
      extends GeocodeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GeocodeServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (GeocodeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new GeocodeServiceFileDescriptorSupplier())
                      .addMethod(getGeocodeAddressMethod())
                      .addMethod(getGeocodeLocationMethod())
                      .addMethod(getGeocodePlaceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
