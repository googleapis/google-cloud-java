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
package com.google.maps.navconnect.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for NavConnect clients to create and get trips.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class NavConnectServiceGrpc {

  private NavConnectServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.maps.navconnect.v1.NavConnectService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.navconnect.v1.CreateTripRequest, com.google.maps.navconnect.v1.Trip>
      getCreateTripMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTrip",
      requestType = com.google.maps.navconnect.v1.CreateTripRequest.class,
      responseType = com.google.maps.navconnect.v1.Trip.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.navconnect.v1.CreateTripRequest, com.google.maps.navconnect.v1.Trip>
      getCreateTripMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.navconnect.v1.CreateTripRequest, com.google.maps.navconnect.v1.Trip>
        getCreateTripMethod;
    if ((getCreateTripMethod = NavConnectServiceGrpc.getCreateTripMethod) == null) {
      synchronized (NavConnectServiceGrpc.class) {
        if ((getCreateTripMethod = NavConnectServiceGrpc.getCreateTripMethod) == null) {
          NavConnectServiceGrpc.getCreateTripMethod =
              getCreateTripMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.navconnect.v1.CreateTripRequest,
                          com.google.maps.navconnect.v1.Trip>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTrip"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.navconnect.v1.CreateTripRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.navconnect.v1.Trip.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NavConnectServiceMethodDescriptorSupplier("CreateTrip"))
                      .build();
        }
      }
    }
    return getCreateTripMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.navconnect.v1.GetTripRequest, com.google.maps.navconnect.v1.Trip>
      getGetTripMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTrip",
      requestType = com.google.maps.navconnect.v1.GetTripRequest.class,
      responseType = com.google.maps.navconnect.v1.Trip.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.navconnect.v1.GetTripRequest, com.google.maps.navconnect.v1.Trip>
      getGetTripMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.navconnect.v1.GetTripRequest, com.google.maps.navconnect.v1.Trip>
        getGetTripMethod;
    if ((getGetTripMethod = NavConnectServiceGrpc.getGetTripMethod) == null) {
      synchronized (NavConnectServiceGrpc.class) {
        if ((getGetTripMethod = NavConnectServiceGrpc.getGetTripMethod) == null) {
          NavConnectServiceGrpc.getGetTripMethod =
              getGetTripMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.navconnect.v1.GetTripRequest,
                          com.google.maps.navconnect.v1.Trip>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTrip"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.navconnect.v1.GetTripRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.navconnect.v1.Trip.getDefaultInstance()))
                      .setSchemaDescriptor(new NavConnectServiceMethodDescriptorSupplier("GetTrip"))
                      .build();
        }
      }
    }
    return getGetTripMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static NavConnectServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NavConnectServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NavConnectServiceStub>() {
          @java.lang.Override
          public NavConnectServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NavConnectServiceStub(channel, callOptions);
          }
        };
    return NavConnectServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static NavConnectServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NavConnectServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NavConnectServiceBlockingV2Stub>() {
          @java.lang.Override
          public NavConnectServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NavConnectServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return NavConnectServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NavConnectServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NavConnectServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NavConnectServiceBlockingStub>() {
          @java.lang.Override
          public NavConnectServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NavConnectServiceBlockingStub(channel, callOptions);
          }
        };
    return NavConnectServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static NavConnectServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NavConnectServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NavConnectServiceFutureStub>() {
          @java.lang.Override
          public NavConnectServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NavConnectServiceFutureStub(channel, callOptions);
          }
        };
    return NavConnectServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for NavConnect clients to create and get trips.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a trip. This must be called before the mobile application can start
     * the trip. The returned trip will have the `auth_token` field set.
     * </pre>
     */
    default void createTrip(
        com.google.maps.navconnect.v1.CreateTripRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.navconnect.v1.Trip> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTripMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a trip.
     * </pre>
     */
    default void getTrip(
        com.google.maps.navconnect.v1.GetTripRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.navconnect.v1.Trip> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTripMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service NavConnectService.
   *
   * <pre>
   * Service for NavConnect clients to create and get trips.
   * </pre>
   */
  public abstract static class NavConnectServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return NavConnectServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service NavConnectService.
   *
   * <pre>
   * Service for NavConnect clients to create and get trips.
   * </pre>
   */
  public static final class NavConnectServiceStub
      extends io.grpc.stub.AbstractAsyncStub<NavConnectServiceStub> {
    private NavConnectServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NavConnectServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NavConnectServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a trip. This must be called before the mobile application can start
     * the trip. The returned trip will have the `auth_token` field set.
     * </pre>
     */
    public void createTrip(
        com.google.maps.navconnect.v1.CreateTripRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.navconnect.v1.Trip> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTripMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a trip.
     * </pre>
     */
    public void getTrip(
        com.google.maps.navconnect.v1.GetTripRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.navconnect.v1.Trip> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTripMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service NavConnectService.
   *
   * <pre>
   * Service for NavConnect clients to create and get trips.
   * </pre>
   */
  public static final class NavConnectServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<NavConnectServiceBlockingV2Stub> {
    private NavConnectServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NavConnectServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NavConnectServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a trip. This must be called before the mobile application can start
     * the trip. The returned trip will have the `auth_token` field set.
     * </pre>
     */
    public com.google.maps.navconnect.v1.Trip createTrip(
        com.google.maps.navconnect.v1.CreateTripRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateTripMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a trip.
     * </pre>
     */
    public com.google.maps.navconnect.v1.Trip getTrip(
        com.google.maps.navconnect.v1.GetTripRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetTripMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service NavConnectService.
   *
   * <pre>
   * Service for NavConnect clients to create and get trips.
   * </pre>
   */
  public static final class NavConnectServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<NavConnectServiceBlockingStub> {
    private NavConnectServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NavConnectServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NavConnectServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a trip. This must be called before the mobile application can start
     * the trip. The returned trip will have the `auth_token` field set.
     * </pre>
     */
    public com.google.maps.navconnect.v1.Trip createTrip(
        com.google.maps.navconnect.v1.CreateTripRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTripMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a trip.
     * </pre>
     */
    public com.google.maps.navconnect.v1.Trip getTrip(
        com.google.maps.navconnect.v1.GetTripRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTripMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service NavConnectService.
   *
   * <pre>
   * Service for NavConnect clients to create and get trips.
   * </pre>
   */
  public static final class NavConnectServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<NavConnectServiceFutureStub> {
    private NavConnectServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NavConnectServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NavConnectServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a trip. This must be called before the mobile application can start
     * the trip. The returned trip will have the `auth_token` field set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.maps.navconnect.v1.Trip>
        createTrip(com.google.maps.navconnect.v1.CreateTripRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTripMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a trip.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.maps.navconnect.v1.Trip>
        getTrip(com.google.maps.navconnect.v1.GetTripRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTripMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TRIP = 0;
  private static final int METHODID_GET_TRIP = 1;

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
        case METHODID_CREATE_TRIP:
          serviceImpl.createTrip(
              (com.google.maps.navconnect.v1.CreateTripRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.navconnect.v1.Trip>) responseObserver);
          break;
        case METHODID_GET_TRIP:
          serviceImpl.getTrip(
              (com.google.maps.navconnect.v1.GetTripRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.navconnect.v1.Trip>) responseObserver);
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
            getCreateTripMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.navconnect.v1.CreateTripRequest,
                    com.google.maps.navconnect.v1.Trip>(service, METHODID_CREATE_TRIP)))
        .addMethod(
            getGetTripMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.navconnect.v1.GetTripRequest,
                    com.google.maps.navconnect.v1.Trip>(service, METHODID_GET_TRIP)))
        .build();
  }

  private abstract static class NavConnectServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NavConnectServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.maps.navconnect.v1.NavConnectServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NavConnectService");
    }
  }

  private static final class NavConnectServiceFileDescriptorSupplier
      extends NavConnectServiceBaseDescriptorSupplier {
    NavConnectServiceFileDescriptorSupplier() {}
  }

  private static final class NavConnectServiceMethodDescriptorSupplier
      extends NavConnectServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    NavConnectServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (NavConnectServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new NavConnectServiceFileDescriptorSupplier())
                      .addMethod(getCreateTripMethod())
                      .addMethod(getGetTripMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
