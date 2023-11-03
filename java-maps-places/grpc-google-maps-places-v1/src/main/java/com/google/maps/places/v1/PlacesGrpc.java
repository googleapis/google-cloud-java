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
package com.google.maps.places.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service definition for the Places API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/maps/places/v1/places_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PlacesGrpc {

  private PlacesGrpc() {}

  public static final String SERVICE_NAME = "google.maps.places.v1.Places";

  // Static method descriptors that strictly reflect the proto.
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
   * </pre>
   */
  public interface AsyncService {

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
  }

  /**
   * Base class for the server implementation of the service Places.
   *
   * <pre>
   * Service definition for the Places API.
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
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Places.
   *
   * <pre>
   * Service definition for the Places API.
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
     * Text query based place search.
     * </pre>
     */
    public com.google.maps.places.v1.SearchTextResponse searchText(
        com.google.maps.places.v1.SearchTextRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchTextMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Places.
   *
   * <pre>
   * Service definition for the Places API.
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
     * Text query based place search.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.places.v1.SearchTextResponse>
        searchText(com.google.maps.places.v1.SearchTextRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchTextMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH_TEXT = 0;

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
        case METHODID_SEARCH_TEXT:
          serviceImpl.searchText(
              (com.google.maps.places.v1.SearchTextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.places.v1.SearchTextResponse>)
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
            getSearchTextMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.places.v1.SearchTextRequest,
                    com.google.maps.places.v1.SearchTextResponse>(service, METHODID_SEARCH_TEXT)))
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
    private final String methodName;

    PlacesMethodDescriptorSupplier(String methodName) {
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
                      .addMethod(getSearchTextMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
