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
package com.google.maps.solar.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service definition for the Solar API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/maps/solar/v1/solar_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SolarGrpc {

  private SolarGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.maps.solar.v1.Solar";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.solar.v1.FindClosestBuildingInsightsRequest,
          com.google.maps.solar.v1.BuildingInsights>
      getFindClosestBuildingInsightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindClosestBuildingInsights",
      requestType = com.google.maps.solar.v1.FindClosestBuildingInsightsRequest.class,
      responseType = com.google.maps.solar.v1.BuildingInsights.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.solar.v1.FindClosestBuildingInsightsRequest,
          com.google.maps.solar.v1.BuildingInsights>
      getFindClosestBuildingInsightsMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.solar.v1.FindClosestBuildingInsightsRequest,
            com.google.maps.solar.v1.BuildingInsights>
        getFindClosestBuildingInsightsMethod;
    if ((getFindClosestBuildingInsightsMethod = SolarGrpc.getFindClosestBuildingInsightsMethod)
        == null) {
      synchronized (SolarGrpc.class) {
        if ((getFindClosestBuildingInsightsMethod = SolarGrpc.getFindClosestBuildingInsightsMethod)
            == null) {
          SolarGrpc.getFindClosestBuildingInsightsMethod =
              getFindClosestBuildingInsightsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.solar.v1.FindClosestBuildingInsightsRequest,
                          com.google.maps.solar.v1.BuildingInsights>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FindClosestBuildingInsights"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.solar.v1.FindClosestBuildingInsightsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.solar.v1.BuildingInsights.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SolarMethodDescriptorSupplier("FindClosestBuildingInsights"))
                      .build();
        }
      }
    }
    return getFindClosestBuildingInsightsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.solar.v1.GetDataLayersRequest, com.google.maps.solar.v1.DataLayers>
      getGetDataLayersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataLayers",
      requestType = com.google.maps.solar.v1.GetDataLayersRequest.class,
      responseType = com.google.maps.solar.v1.DataLayers.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.solar.v1.GetDataLayersRequest, com.google.maps.solar.v1.DataLayers>
      getGetDataLayersMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.solar.v1.GetDataLayersRequest, com.google.maps.solar.v1.DataLayers>
        getGetDataLayersMethod;
    if ((getGetDataLayersMethod = SolarGrpc.getGetDataLayersMethod) == null) {
      synchronized (SolarGrpc.class) {
        if ((getGetDataLayersMethod = SolarGrpc.getGetDataLayersMethod) == null) {
          SolarGrpc.getGetDataLayersMethod =
              getGetDataLayersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.solar.v1.GetDataLayersRequest,
                          com.google.maps.solar.v1.DataLayers>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataLayers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.solar.v1.GetDataLayersRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.solar.v1.DataLayers.getDefaultInstance()))
                      .setSchemaDescriptor(new SolarMethodDescriptorSupplier("GetDataLayers"))
                      .build();
        }
      }
    }
    return getGetDataLayersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.solar.v1.GetGeoTiffRequest, com.google.api.HttpBody>
      getGetGeoTiffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGeoTiff",
      requestType = com.google.maps.solar.v1.GetGeoTiffRequest.class,
      responseType = com.google.api.HttpBody.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.solar.v1.GetGeoTiffRequest, com.google.api.HttpBody>
      getGetGeoTiffMethod() {
    io.grpc.MethodDescriptor<com.google.maps.solar.v1.GetGeoTiffRequest, com.google.api.HttpBody>
        getGetGeoTiffMethod;
    if ((getGetGeoTiffMethod = SolarGrpc.getGetGeoTiffMethod) == null) {
      synchronized (SolarGrpc.class) {
        if ((getGetGeoTiffMethod = SolarGrpc.getGetGeoTiffMethod) == null) {
          SolarGrpc.getGetGeoTiffMethod =
              getGetGeoTiffMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.solar.v1.GetGeoTiffRequest, com.google.api.HttpBody>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGeoTiff"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.solar.v1.GetGeoTiffRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.HttpBody.getDefaultInstance()))
                      .setSchemaDescriptor(new SolarMethodDescriptorSupplier("GetGeoTiff"))
                      .build();
        }
      }
    }
    return getGetGeoTiffMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SolarStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SolarStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SolarStub>() {
          @java.lang.Override
          public SolarStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SolarStub(channel, callOptions);
          }
        };
    return SolarStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SolarBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SolarBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SolarBlockingStub>() {
          @java.lang.Override
          public SolarBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SolarBlockingStub(channel, callOptions);
          }
        };
    return SolarBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SolarFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SolarFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SolarFutureStub>() {
          @java.lang.Override
          public SolarFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SolarFutureStub(channel, callOptions);
          }
        };
    return SolarFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service definition for the Solar API.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Locates the closest building to a query point. Returns an error with
     * code `NOT_FOUND` if there are no buildings within approximately 50m of the
     * query point.
     * </pre>
     */
    default void findClosestBuildingInsights(
        com.google.maps.solar.v1.FindClosestBuildingInsightsRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.solar.v1.BuildingInsights> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFindClosestBuildingInsightsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets solar information for a region surrounding a location.
     * Returns an error with code `NOT_FOUND` if the location is outside
     * the coverage area.
     * </pre>
     */
    default void getDataLayers(
        com.google.maps.solar.v1.GetDataLayersRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.solar.v1.DataLayers> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataLayersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns an image by its ID.
     * </pre>
     */
    default void getGeoTiff(
        com.google.maps.solar.v1.GetGeoTiffRequest request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetGeoTiffMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Solar.
   *
   * <pre>
   * Service definition for the Solar API.
   * </pre>
   */
  public abstract static class SolarImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SolarGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Solar.
   *
   * <pre>
   * Service definition for the Solar API.
   * </pre>
   */
  public static final class SolarStub extends io.grpc.stub.AbstractAsyncStub<SolarStub> {
    private SolarStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SolarStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SolarStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Locates the closest building to a query point. Returns an error with
     * code `NOT_FOUND` if there are no buildings within approximately 50m of the
     * query point.
     * </pre>
     */
    public void findClosestBuildingInsights(
        com.google.maps.solar.v1.FindClosestBuildingInsightsRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.solar.v1.BuildingInsights> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindClosestBuildingInsightsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets solar information for a region surrounding a location.
     * Returns an error with code `NOT_FOUND` if the location is outside
     * the coverage area.
     * </pre>
     */
    public void getDataLayers(
        com.google.maps.solar.v1.GetDataLayersRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.solar.v1.DataLayers> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataLayersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns an image by its ID.
     * </pre>
     */
    public void getGeoTiff(
        com.google.maps.solar.v1.GetGeoTiffRequest request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGeoTiffMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Solar.
   *
   * <pre>
   * Service definition for the Solar API.
   * </pre>
   */
  public static final class SolarBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SolarBlockingStub> {
    private SolarBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SolarBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SolarBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Locates the closest building to a query point. Returns an error with
     * code `NOT_FOUND` if there are no buildings within approximately 50m of the
     * query point.
     * </pre>
     */
    public com.google.maps.solar.v1.BuildingInsights findClosestBuildingInsights(
        com.google.maps.solar.v1.FindClosestBuildingInsightsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindClosestBuildingInsightsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets solar information for a region surrounding a location.
     * Returns an error with code `NOT_FOUND` if the location is outside
     * the coverage area.
     * </pre>
     */
    public com.google.maps.solar.v1.DataLayers getDataLayers(
        com.google.maps.solar.v1.GetDataLayersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataLayersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns an image by its ID.
     * </pre>
     */
    public com.google.api.HttpBody getGeoTiff(com.google.maps.solar.v1.GetGeoTiffRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGeoTiffMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Solar.
   *
   * <pre>
   * Service definition for the Solar API.
   * </pre>
   */
  public static final class SolarFutureStub
      extends io.grpc.stub.AbstractFutureStub<SolarFutureStub> {
    private SolarFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SolarFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SolarFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Locates the closest building to a query point. Returns an error with
     * code `NOT_FOUND` if there are no buildings within approximately 50m of the
     * query point.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.solar.v1.BuildingInsights>
        findClosestBuildingInsights(
            com.google.maps.solar.v1.FindClosestBuildingInsightsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindClosestBuildingInsightsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets solar information for a region surrounding a location.
     * Returns an error with code `NOT_FOUND` if the location is outside
     * the coverage area.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.maps.solar.v1.DataLayers>
        getDataLayers(com.google.maps.solar.v1.GetDataLayersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataLayersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns an image by its ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.HttpBody> getGeoTiff(
        com.google.maps.solar.v1.GetGeoTiffRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGeoTiffMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_CLOSEST_BUILDING_INSIGHTS = 0;
  private static final int METHODID_GET_DATA_LAYERS = 1;
  private static final int METHODID_GET_GEO_TIFF = 2;

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
        case METHODID_FIND_CLOSEST_BUILDING_INSIGHTS:
          serviceImpl.findClosestBuildingInsights(
              (com.google.maps.solar.v1.FindClosestBuildingInsightsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.solar.v1.BuildingInsights>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_LAYERS:
          serviceImpl.getDataLayers(
              (com.google.maps.solar.v1.GetDataLayersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.solar.v1.DataLayers>) responseObserver);
          break;
        case METHODID_GET_GEO_TIFF:
          serviceImpl.getGeoTiff(
              (com.google.maps.solar.v1.GetGeoTiffRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.HttpBody>) responseObserver);
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
            getFindClosestBuildingInsightsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.solar.v1.FindClosestBuildingInsightsRequest,
                    com.google.maps.solar.v1.BuildingInsights>(
                    service, METHODID_FIND_CLOSEST_BUILDING_INSIGHTS)))
        .addMethod(
            getGetDataLayersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.solar.v1.GetDataLayersRequest,
                    com.google.maps.solar.v1.DataLayers>(service, METHODID_GET_DATA_LAYERS)))
        .addMethod(
            getGetGeoTiffMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.solar.v1.GetGeoTiffRequest, com.google.api.HttpBody>(
                    service, METHODID_GET_GEO_TIFF)))
        .build();
  }

  private abstract static class SolarBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SolarBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.maps.solar.v1.SolarServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Solar");
    }
  }

  private static final class SolarFileDescriptorSupplier extends SolarBaseDescriptorSupplier {
    SolarFileDescriptorSupplier() {}
  }

  private static final class SolarMethodDescriptorSupplier extends SolarBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SolarMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SolarGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SolarFileDescriptorSupplier())
                      .addMethod(getFindClosestBuildingInsightsMethod())
                      .addMethod(getGetDataLayersMethod())
                      .addMethod(getGetGeoTiffMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
