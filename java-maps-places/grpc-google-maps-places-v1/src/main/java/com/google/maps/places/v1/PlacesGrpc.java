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
package com.google.maps.places.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service definition for the Places API.
 * Note: every request (except for Autocomplete requests) requires a field mask
 * set outside of the request proto (`all/&#42;`, is not assumed). The field mask
 * can be set via the HTTP header `X-Goog-FieldMask`. See:
 * https://developers.google.com/maps/documentation/places/web-service/choose-fields
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/maps/places/v1/places_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PlacesGrpc {

  private PlacesGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.maps.places.v1.Places";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.places.v1.SearchNearbyRequest,
          com.google.maps.places.v1.SearchNearbyResponse>
      getSearchNearbyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchNearby",
      requestType = com.google.maps.places.v1.SearchNearbyRequest.class,
      responseType = com.google.maps.places.v1.SearchNearbyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.places.v1.SearchNearbyRequest,
          com.google.maps.places.v1.SearchNearbyResponse>
      getSearchNearbyMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.places.v1.SearchNearbyRequest,
            com.google.maps.places.v1.SearchNearbyResponse>
        getSearchNearbyMethod;
    if ((getSearchNearbyMethod = PlacesGrpc.getSearchNearbyMethod) == null) {
      synchronized (PlacesGrpc.class) {
        if ((getSearchNearbyMethod = PlacesGrpc.getSearchNearbyMethod) == null) {
          PlacesGrpc.getSearchNearbyMethod =
              getSearchNearbyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.places.v1.SearchNearbyRequest,
                          com.google.maps.places.v1.SearchNearbyResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchNearby"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.places.v1.SearchNearbyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.places.v1.SearchNearbyResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new PlacesMethodDescriptorSupplier("SearchNearby"))
                      .build();
        }
      }
    }
    return getSearchNearbyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.places.v1.SearchTextRequest, com.google.maps.places.v1.SearchTextResponse>
      getSearchTextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchText",
      requestType = com.google.maps.places.v1.SearchTextRequest.class,
      responseType = com.google.maps.places.v1.SearchTextResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.places.v1.SearchTextRequest, com.google.maps.places.v1.SearchTextResponse>
      getSearchTextMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.places.v1.SearchTextRequest,
            com.google.maps.places.v1.SearchTextResponse>
        getSearchTextMethod;
    if ((getSearchTextMethod = PlacesGrpc.getSearchTextMethod) == null) {
      synchronized (PlacesGrpc.class) {
        if ((getSearchTextMethod = PlacesGrpc.getSearchTextMethod) == null) {
          PlacesGrpc.getSearchTextMethod =
              getSearchTextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.places.v1.SearchTextRequest,
                          com.google.maps.places.v1.SearchTextResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchText"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.places.v1.SearchTextRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.places.v1.SearchTextResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new PlacesMethodDescriptorSupplier("SearchText"))
                      .build();
        }
      }
    }
    return getSearchTextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.places.v1.GetPhotoMediaRequest, com.google.maps.places.v1.PhotoMedia>
      getGetPhotoMediaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPhotoMedia",
      requestType = com.google.maps.places.v1.GetPhotoMediaRequest.class,
      responseType = com.google.maps.places.v1.PhotoMedia.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.places.v1.GetPhotoMediaRequest, com.google.maps.places.v1.PhotoMedia>
      getGetPhotoMediaMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.places.v1.GetPhotoMediaRequest, com.google.maps.places.v1.PhotoMedia>
        getGetPhotoMediaMethod;
    if ((getGetPhotoMediaMethod = PlacesGrpc.getGetPhotoMediaMethod) == null) {
      synchronized (PlacesGrpc.class) {
        if ((getGetPhotoMediaMethod = PlacesGrpc.getGetPhotoMediaMethod) == null) {
          PlacesGrpc.getGetPhotoMediaMethod =
              getGetPhotoMediaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.places.v1.GetPhotoMediaRequest,
                          com.google.maps.places.v1.PhotoMedia>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPhotoMedia"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.places.v1.GetPhotoMediaRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.places.v1.PhotoMedia.getDefaultInstance()))
                      .setSchemaDescriptor(new PlacesMethodDescriptorSupplier("GetPhotoMedia"))
                      .build();
        }
      }
    }
    return getGetPhotoMediaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.places.v1.GetPlaceRequest, com.google.maps.places.v1.Place>
      getGetPlaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPlace",
      requestType = com.google.maps.places.v1.GetPlaceRequest.class,
      responseType = com.google.maps.places.v1.Place.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.places.v1.GetPlaceRequest, com.google.maps.places.v1.Place>
      getGetPlaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.places.v1.GetPlaceRequest, com.google.maps.places.v1.Place>
        getGetPlaceMethod;
    if ((getGetPlaceMethod = PlacesGrpc.getGetPlaceMethod) == null) {
      synchronized (PlacesGrpc.class) {
        if ((getGetPlaceMethod = PlacesGrpc.getGetPlaceMethod) == null) {
          PlacesGrpc.getGetPlaceMethod =
              getGetPlaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.places.v1.GetPlaceRequest, com.google.maps.places.v1.Place>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPlace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.places.v1.GetPlaceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.places.v1.Place.getDefaultInstance()))
                      .setSchemaDescriptor(new PlacesMethodDescriptorSupplier("GetPlace"))
                      .build();
        }
      }
    }
    return getGetPlaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.places.v1.AutocompletePlacesRequest,
          com.google.maps.places.v1.AutocompletePlacesResponse>
      getAutocompletePlacesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AutocompletePlaces",
      requestType = com.google.maps.places.v1.AutocompletePlacesRequest.class,
      responseType = com.google.maps.places.v1.AutocompletePlacesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.places.v1.AutocompletePlacesRequest,
          com.google.maps.places.v1.AutocompletePlacesResponse>
      getAutocompletePlacesMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.places.v1.AutocompletePlacesRequest,
            com.google.maps.places.v1.AutocompletePlacesResponse>
        getAutocompletePlacesMethod;
    if ((getAutocompletePlacesMethod = PlacesGrpc.getAutocompletePlacesMethod) == null) {
      synchronized (PlacesGrpc.class) {
        if ((getAutocompletePlacesMethod = PlacesGrpc.getAutocompletePlacesMethod) == null) {
          PlacesGrpc.getAutocompletePlacesMethod =
              getAutocompletePlacesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.places.v1.AutocompletePlacesRequest,
                          com.google.maps.places.v1.AutocompletePlacesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AutocompletePlaces"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.places.v1.AutocompletePlacesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.places.v1.AutocompletePlacesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new PlacesMethodDescriptorSupplier("AutocompletePlaces"))
                      .build();
        }
      }
    }
    return getAutocompletePlacesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static PlacesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlacesStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PlacesStub>() {
          @java.lang.Override
          public PlacesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PlacesStub(channel, callOptions);
          }
        };
    return PlacesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PlacesBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlacesBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PlacesBlockingStub>() {
          @java.lang.Override
          public PlacesBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PlacesBlockingStub(channel, callOptions);
          }
        };
    return PlacesBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static PlacesFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlacesFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PlacesFutureStub>() {
          @java.lang.Override
          public PlacesFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PlacesFutureStub(channel, callOptions);
          }
        };
    return PlacesFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service definition for the Places API.
   * Note: every request (except for Autocomplete requests) requires a field mask
   * set outside of the request proto (`all/&#42;`, is not assumed). The field mask
   * can be set via the HTTP header `X-Goog-FieldMask`. See:
   * https://developers.google.com/maps/documentation/places/web-service/choose-fields
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Search for places near locations.
     * </pre>
     */
    default void searchNearby(
        com.google.maps.places.v1.SearchNearbyRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.places.v1.SearchNearbyResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchNearbyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Text query based place search.
     * </pre>
     */
    default void searchText(
        com.google.maps.places.v1.SearchTextRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.places.v1.SearchTextResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchTextMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a photo media with a photo reference string.
     * </pre>
     */
    default void getPhotoMedia(
        com.google.maps.places.v1.GetPhotoMediaRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.places.v1.PhotoMedia> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPhotoMediaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get the details of a place based on its resource name, which is a string
     * in the `places/{place_id}` format.
     * </pre>
     */
    default void getPlace(
        com.google.maps.places.v1.GetPlaceRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.places.v1.Place> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPlaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns predictions for the given input.
     * </pre>
     */
    default void autocompletePlaces(
        com.google.maps.places.v1.AutocompletePlacesRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.places.v1.AutocompletePlacesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAutocompletePlacesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Places.
   *
   * <pre>
   * Service definition for the Places API.
   * Note: every request (except for Autocomplete requests) requires a field mask
   * set outside of the request proto (`all/&#42;`, is not assumed). The field mask
   * can be set via the HTTP header `X-Goog-FieldMask`. See:
   * https://developers.google.com/maps/documentation/places/web-service/choose-fields
   * </pre>
   */
  public abstract static class PlacesImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return PlacesGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Places.
   *
   * <pre>
   * Service definition for the Places API.
   * Note: every request (except for Autocomplete requests) requires a field mask
   * set outside of the request proto (`all/&#42;`, is not assumed). The field mask
   * can be set via the HTTP header `X-Goog-FieldMask`. See:
   * https://developers.google.com/maps/documentation/places/web-service/choose-fields
   * </pre>
   */
  public static final class PlacesStub extends io.grpc.stub.AbstractAsyncStub<PlacesStub> {
    private PlacesStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlacesStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlacesStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Search for places near locations.
     * </pre>
     */
    public void searchNearby(
        com.google.maps.places.v1.SearchNearbyRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.places.v1.SearchNearbyResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchNearbyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Text query based place search.
     * </pre>
     */
    public void searchText(
        com.google.maps.places.v1.SearchTextRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.places.v1.SearchTextResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchTextMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a photo media with a photo reference string.
     * </pre>
     */
    public void getPhotoMedia(
        com.google.maps.places.v1.GetPhotoMediaRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.places.v1.PhotoMedia> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPhotoMediaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get the details of a place based on its resource name, which is a string
     * in the `places/{place_id}` format.
     * </pre>
     */
    public void getPlace(
        com.google.maps.places.v1.GetPlaceRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.places.v1.Place> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPlaceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns predictions for the given input.
     * </pre>
     */
    public void autocompletePlaces(
        com.google.maps.places.v1.AutocompletePlacesRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.places.v1.AutocompletePlacesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAutocompletePlacesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Places.
   *
   * <pre>
   * Service definition for the Places API.
   * Note: every request (except for Autocomplete requests) requires a field mask
   * set outside of the request proto (`all/&#42;`, is not assumed). The field mask
   * can be set via the HTTP header `X-Goog-FieldMask`. See:
   * https://developers.google.com/maps/documentation/places/web-service/choose-fields
   * </pre>
   */
  public static final class PlacesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PlacesBlockingStub> {
    private PlacesBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlacesBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlacesBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Search for places near locations.
     * </pre>
     */
    public com.google.maps.places.v1.SearchNearbyResponse searchNearby(
        com.google.maps.places.v1.SearchNearbyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchNearbyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Text query based place search.
     * </pre>
     */
    public com.google.maps.places.v1.SearchTextResponse searchText(
        com.google.maps.places.v1.SearchTextRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchTextMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a photo media with a photo reference string.
     * </pre>
     */
    public com.google.maps.places.v1.PhotoMedia getPhotoMedia(
        com.google.maps.places.v1.GetPhotoMediaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPhotoMediaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get the details of a place based on its resource name, which is a string
     * in the `places/{place_id}` format.
     * </pre>
     */
    public com.google.maps.places.v1.Place getPlace(
        com.google.maps.places.v1.GetPlaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPlaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns predictions for the given input.
     * </pre>
     */
    public com.google.maps.places.v1.AutocompletePlacesResponse autocompletePlaces(
        com.google.maps.places.v1.AutocompletePlacesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAutocompletePlacesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Places.
   *
   * <pre>
   * Service definition for the Places API.
   * Note: every request (except for Autocomplete requests) requires a field mask
   * set outside of the request proto (`all/&#42;`, is not assumed). The field mask
   * can be set via the HTTP header `X-Goog-FieldMask`. See:
   * https://developers.google.com/maps/documentation/places/web-service/choose-fields
   * </pre>
   */
  public static final class PlacesFutureStub
      extends io.grpc.stub.AbstractFutureStub<PlacesFutureStub> {
    private PlacesFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlacesFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlacesFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Search for places near locations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.places.v1.SearchNearbyResponse>
        searchNearby(com.google.maps.places.v1.SearchNearbyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchNearbyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Text query based place search.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.places.v1.SearchTextResponse>
        searchText(com.google.maps.places.v1.SearchTextRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchTextMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a photo media with a photo reference string.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.maps.places.v1.PhotoMedia>
        getPhotoMedia(com.google.maps.places.v1.GetPhotoMediaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPhotoMediaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get the details of a place based on its resource name, which is a string
     * in the `places/{place_id}` format.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.maps.places.v1.Place>
        getPlace(com.google.maps.places.v1.GetPlaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPlaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns predictions for the given input.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.places.v1.AutocompletePlacesResponse>
        autocompletePlaces(com.google.maps.places.v1.AutocompletePlacesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAutocompletePlacesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH_NEARBY = 0;
  private static final int METHODID_SEARCH_TEXT = 1;
  private static final int METHODID_GET_PHOTO_MEDIA = 2;
  private static final int METHODID_GET_PLACE = 3;
  private static final int METHODID_AUTOCOMPLETE_PLACES = 4;

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
        case METHODID_SEARCH_NEARBY:
          serviceImpl.searchNearby(
              (com.google.maps.places.v1.SearchNearbyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.places.v1.SearchNearbyResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_TEXT:
          serviceImpl.searchText(
              (com.google.maps.places.v1.SearchTextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.places.v1.SearchTextResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PHOTO_MEDIA:
          serviceImpl.getPhotoMedia(
              (com.google.maps.places.v1.GetPhotoMediaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.places.v1.PhotoMedia>) responseObserver);
          break;
        case METHODID_GET_PLACE:
          serviceImpl.getPlace(
              (com.google.maps.places.v1.GetPlaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.places.v1.Place>) responseObserver);
          break;
        case METHODID_AUTOCOMPLETE_PLACES:
          serviceImpl.autocompletePlaces(
              (com.google.maps.places.v1.AutocompletePlacesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.places.v1.AutocompletePlacesResponse>)
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
            getSearchNearbyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.places.v1.SearchNearbyRequest,
                    com.google.maps.places.v1.SearchNearbyResponse>(
                    service, METHODID_SEARCH_NEARBY)))
        .addMethod(
            getSearchTextMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.places.v1.SearchTextRequest,
                    com.google.maps.places.v1.SearchTextResponse>(service, METHODID_SEARCH_TEXT)))
        .addMethod(
            getGetPhotoMediaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.places.v1.GetPhotoMediaRequest,
                    com.google.maps.places.v1.PhotoMedia>(service, METHODID_GET_PHOTO_MEDIA)))
        .addMethod(
            getGetPlaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.places.v1.GetPlaceRequest, com.google.maps.places.v1.Place>(
                    service, METHODID_GET_PLACE)))
        .addMethod(
            getAutocompletePlacesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.places.v1.AutocompletePlacesRequest,
                    com.google.maps.places.v1.AutocompletePlacesResponse>(
                    service, METHODID_AUTOCOMPLETE_PLACES)))
        .build();
  }

  private abstract static class PlacesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PlacesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.maps.places.v1.PlacesServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Places");
    }
  }

  private static final class PlacesFileDescriptorSupplier extends PlacesBaseDescriptorSupplier {
    PlacesFileDescriptorSupplier() {}
  }

  private static final class PlacesMethodDescriptorSupplier extends PlacesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PlacesMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PlacesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new PlacesFileDescriptorSupplier())
                      .addMethod(getSearchNearbyMethod())
                      .addMethod(getSearchTextMethod())
                      .addMethod(getGetPhotoMediaMethod())
                      .addMethod(getGetPlaceMethod())
                      .addMethod(getAutocompletePlacesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
