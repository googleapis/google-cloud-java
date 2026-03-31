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
 * A service for retrieving destinations.
 * A destination provides hierarchical context about a place, which
 * allows you to, for example, find apartment buildings within a larger
 * apartment complex and vice versa. It also provides navigation points suitable
 * for use cases such as ridesharing or delivery.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class DestinationServiceGrpc {

  private DestinationServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.maps.geocode.v4.DestinationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.geocode.v4.SearchDestinationsRequest,
          com.google.maps.geocode.v4.SearchDestinationsResponse>
      getSearchDestinationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchDestinations",
      requestType = com.google.maps.geocode.v4.SearchDestinationsRequest.class,
      responseType = com.google.maps.geocode.v4.SearchDestinationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.geocode.v4.SearchDestinationsRequest,
          com.google.maps.geocode.v4.SearchDestinationsResponse>
      getSearchDestinationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.geocode.v4.SearchDestinationsRequest,
            com.google.maps.geocode.v4.SearchDestinationsResponse>
        getSearchDestinationsMethod;
    if ((getSearchDestinationsMethod = DestinationServiceGrpc.getSearchDestinationsMethod)
        == null) {
      synchronized (DestinationServiceGrpc.class) {
        if ((getSearchDestinationsMethod = DestinationServiceGrpc.getSearchDestinationsMethod)
            == null) {
          DestinationServiceGrpc.getSearchDestinationsMethod =
              getSearchDestinationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.geocode.v4.SearchDestinationsRequest,
                          com.google.maps.geocode.v4.SearchDestinationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchDestinations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.geocode.v4.SearchDestinationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.geocode.v4.SearchDestinationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DestinationServiceMethodDescriptorSupplier("SearchDestinations"))
                      .build();
        }
      }
    }
    return getSearchDestinationsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DestinationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DestinationServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DestinationServiceStub>() {
          @java.lang.Override
          public DestinationServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DestinationServiceStub(channel, callOptions);
          }
        };
    return DestinationServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DestinationServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DestinationServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DestinationServiceBlockingV2Stub>() {
          @java.lang.Override
          public DestinationServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DestinationServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return DestinationServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DestinationServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DestinationServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DestinationServiceBlockingStub>() {
          @java.lang.Override
          public DestinationServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DestinationServiceBlockingStub(channel, callOptions);
          }
        };
    return DestinationServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DestinationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DestinationServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DestinationServiceFutureStub>() {
          @java.lang.Override
          public DestinationServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DestinationServiceFutureStub(channel, callOptions);
          }
        };
    return DestinationServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service for retrieving destinations.
   * A destination provides hierarchical context about a place, which
   * allows you to, for example, find apartment buildings within a larger
   * apartment complex and vice versa. It also provides navigation points suitable
   * for use cases such as ridesharing or delivery.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * This method performs a destination lookup and returns a list of
     * destinations.
     * </pre>
     */
    default void searchDestinations(
        com.google.maps.geocode.v4.SearchDestinationsRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.geocode.v4.SearchDestinationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchDestinationsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DestinationService.
   *
   * <pre>
   * A service for retrieving destinations.
   * A destination provides hierarchical context about a place, which
   * allows you to, for example, find apartment buildings within a larger
   * apartment complex and vice versa. It also provides navigation points suitable
   * for use cases such as ridesharing or delivery.
   * </pre>
   */
  public abstract static class DestinationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DestinationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DestinationService.
   *
   * <pre>
   * A service for retrieving destinations.
   * A destination provides hierarchical context about a place, which
   * allows you to, for example, find apartment buildings within a larger
   * apartment complex and vice versa. It also provides navigation points suitable
   * for use cases such as ridesharing or delivery.
   * </pre>
   */
  public static final class DestinationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DestinationServiceStub> {
    private DestinationServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DestinationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DestinationServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * This method performs a destination lookup and returns a list of
     * destinations.
     * </pre>
     */
    public void searchDestinations(
        com.google.maps.geocode.v4.SearchDestinationsRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.geocode.v4.SearchDestinationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchDestinationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DestinationService.
   *
   * <pre>
   * A service for retrieving destinations.
   * A destination provides hierarchical context about a place, which
   * allows you to, for example, find apartment buildings within a larger
   * apartment complex and vice versa. It also provides navigation points suitable
   * for use cases such as ridesharing or delivery.
   * </pre>
   */
  public static final class DestinationServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DestinationServiceBlockingV2Stub> {
    private DestinationServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DestinationServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DestinationServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * This method performs a destination lookup and returns a list of
     * destinations.
     * </pre>
     */
    public com.google.maps.geocode.v4.SearchDestinationsResponse searchDestinations(
        com.google.maps.geocode.v4.SearchDestinationsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSearchDestinationsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DestinationService.
   *
   * <pre>
   * A service for retrieving destinations.
   * A destination provides hierarchical context about a place, which
   * allows you to, for example, find apartment buildings within a larger
   * apartment complex and vice versa. It also provides navigation points suitable
   * for use cases such as ridesharing or delivery.
   * </pre>
   */
  public static final class DestinationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DestinationServiceBlockingStub> {
    private DestinationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DestinationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DestinationServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * This method performs a destination lookup and returns a list of
     * destinations.
     * </pre>
     */
    public com.google.maps.geocode.v4.SearchDestinationsResponse searchDestinations(
        com.google.maps.geocode.v4.SearchDestinationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchDestinationsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DestinationService.
   *
   * <pre>
   * A service for retrieving destinations.
   * A destination provides hierarchical context about a place, which
   * allows you to, for example, find apartment buildings within a larger
   * apartment complex and vice versa. It also provides navigation points suitable
   * for use cases such as ridesharing or delivery.
   * </pre>
   */
  public static final class DestinationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DestinationServiceFutureStub> {
    private DestinationServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DestinationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DestinationServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * This method performs a destination lookup and returns a list of
     * destinations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.geocode.v4.SearchDestinationsResponse>
        searchDestinations(com.google.maps.geocode.v4.SearchDestinationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchDestinationsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH_DESTINATIONS = 0;

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
        case METHODID_SEARCH_DESTINATIONS:
          serviceImpl.searchDestinations(
              (com.google.maps.geocode.v4.SearchDestinationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.geocode.v4.SearchDestinationsResponse>)
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
            getSearchDestinationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.geocode.v4.SearchDestinationsRequest,
                    com.google.maps.geocode.v4.SearchDestinationsResponse>(
                    service, METHODID_SEARCH_DESTINATIONS)))
        .build();
  }

  private abstract static class DestinationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DestinationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.maps.geocode.v4.DestinationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DestinationService");
    }
  }

  private static final class DestinationServiceFileDescriptorSupplier
      extends DestinationServiceBaseDescriptorSupplier {
    DestinationServiceFileDescriptorSupplier() {}
  }

  private static final class DestinationServiceMethodDescriptorSupplier
      extends DestinationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DestinationServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DestinationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DestinationServiceFileDescriptorSupplier())
                      .addMethod(getSearchDestinationsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
