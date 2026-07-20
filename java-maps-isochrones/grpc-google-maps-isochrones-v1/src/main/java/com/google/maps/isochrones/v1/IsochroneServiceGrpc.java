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
package com.google.maps.isochrones.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for calculating isochrones. An isochrone is an area of reachability
 * from a given origin point within a specified travel time.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class IsochroneServiceGrpc {

  private IsochroneServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.maps.isochrones.v1.IsochroneService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.isochrones.v1.GenerateIsochroneRequest,
          com.google.maps.isochrones.v1.GenerateIsochroneResponse>
      getGenerateIsochroneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateIsochrone",
      requestType = com.google.maps.isochrones.v1.GenerateIsochroneRequest.class,
      responseType = com.google.maps.isochrones.v1.GenerateIsochroneResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.isochrones.v1.GenerateIsochroneRequest,
          com.google.maps.isochrones.v1.GenerateIsochroneResponse>
      getGenerateIsochroneMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.isochrones.v1.GenerateIsochroneRequest,
            com.google.maps.isochrones.v1.GenerateIsochroneResponse>
        getGenerateIsochroneMethod;
    if ((getGenerateIsochroneMethod = IsochroneServiceGrpc.getGenerateIsochroneMethod) == null) {
      synchronized (IsochroneServiceGrpc.class) {
        if ((getGenerateIsochroneMethod = IsochroneServiceGrpc.getGenerateIsochroneMethod)
            == null) {
          IsochroneServiceGrpc.getGenerateIsochroneMethod =
              getGenerateIsochroneMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.isochrones.v1.GenerateIsochroneRequest,
                          com.google.maps.isochrones.v1.GenerateIsochroneResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateIsochrone"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.isochrones.v1.GenerateIsochroneRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.isochrones.v1.GenerateIsochroneResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IsochroneServiceMethodDescriptorSupplier("GenerateIsochrone"))
                      .build();
        }
      }
    }
    return getGenerateIsochroneMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static IsochroneServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IsochroneServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IsochroneServiceStub>() {
          @java.lang.Override
          public IsochroneServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IsochroneServiceStub(channel, callOptions);
          }
        };
    return IsochroneServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static IsochroneServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IsochroneServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IsochroneServiceBlockingV2Stub>() {
          @java.lang.Override
          public IsochroneServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IsochroneServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return IsochroneServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IsochroneServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IsochroneServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IsochroneServiceBlockingStub>() {
          @java.lang.Override
          public IsochroneServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IsochroneServiceBlockingStub(channel, callOptions);
          }
        };
    return IsochroneServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static IsochroneServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IsochroneServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IsochroneServiceFutureStub>() {
          @java.lang.Override
          public IsochroneServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IsochroneServiceFutureStub(channel, callOptions);
          }
        };
    return IsochroneServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for calculating isochrones. An isochrone is an area of reachability
   * from a given origin point within a specified travel time.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Calculates and returns a single isochrone for a given set of parameters.
     * </pre>
     */
    default void generateIsochrone(
        com.google.maps.isochrones.v1.GenerateIsochroneRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.isochrones.v1.GenerateIsochroneResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateIsochroneMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service IsochroneService.
   *
   * <pre>
   * Service for calculating isochrones. An isochrone is an area of reachability
   * from a given origin point within a specified travel time.
   * </pre>
   */
  public abstract static class IsochroneServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return IsochroneServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service IsochroneService.
   *
   * <pre>
   * Service for calculating isochrones. An isochrone is an area of reachability
   * from a given origin point within a specified travel time.
   * </pre>
   */
  public static final class IsochroneServiceStub
      extends io.grpc.stub.AbstractAsyncStub<IsochroneServiceStub> {
    private IsochroneServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IsochroneServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IsochroneServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Calculates and returns a single isochrone for a given set of parameters.
     * </pre>
     */
    public void generateIsochrone(
        com.google.maps.isochrones.v1.GenerateIsochroneRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.isochrones.v1.GenerateIsochroneResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateIsochroneMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service IsochroneService.
   *
   * <pre>
   * Service for calculating isochrones. An isochrone is an area of reachability
   * from a given origin point within a specified travel time.
   * </pre>
   */
  public static final class IsochroneServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<IsochroneServiceBlockingV2Stub> {
    private IsochroneServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IsochroneServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IsochroneServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Calculates and returns a single isochrone for a given set of parameters.
     * </pre>
     */
    public com.google.maps.isochrones.v1.GenerateIsochroneResponse generateIsochrone(
        com.google.maps.isochrones.v1.GenerateIsochroneRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGenerateIsochroneMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service IsochroneService.
   *
   * <pre>
   * Service for calculating isochrones. An isochrone is an area of reachability
   * from a given origin point within a specified travel time.
   * </pre>
   */
  public static final class IsochroneServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<IsochroneServiceBlockingStub> {
    private IsochroneServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IsochroneServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IsochroneServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Calculates and returns a single isochrone for a given set of parameters.
     * </pre>
     */
    public com.google.maps.isochrones.v1.GenerateIsochroneResponse generateIsochrone(
        com.google.maps.isochrones.v1.GenerateIsochroneRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateIsochroneMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service IsochroneService.
   *
   * <pre>
   * Service for calculating isochrones. An isochrone is an area of reachability
   * from a given origin point within a specified travel time.
   * </pre>
   */
  public static final class IsochroneServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<IsochroneServiceFutureStub> {
    private IsochroneServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IsochroneServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IsochroneServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Calculates and returns a single isochrone for a given set of parameters.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.isochrones.v1.GenerateIsochroneResponse>
        generateIsochrone(com.google.maps.isochrones.v1.GenerateIsochroneRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateIsochroneMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_ISOCHRONE = 0;

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
        case METHODID_GENERATE_ISOCHRONE:
          serviceImpl.generateIsochrone(
              (com.google.maps.isochrones.v1.GenerateIsochroneRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.isochrones.v1.GenerateIsochroneResponse>)
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
            getGenerateIsochroneMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.isochrones.v1.GenerateIsochroneRequest,
                    com.google.maps.isochrones.v1.GenerateIsochroneResponse>(
                    service, METHODID_GENERATE_ISOCHRONE)))
        .build();
  }

  private abstract static class IsochroneServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IsochroneServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.maps.isochrones.v1.IsochronesServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IsochroneService");
    }
  }

  private static final class IsochroneServiceFileDescriptorSupplier
      extends IsochroneServiceBaseDescriptorSupplier {
    IsochroneServiceFileDescriptorSupplier() {}
  }

  private static final class IsochroneServiceMethodDescriptorSupplier
      extends IsochroneServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    IsochroneServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (IsochroneServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new IsochroneServiceFileDescriptorSupplier())
                      .addMethod(getGenerateIsochroneMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
