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
package com.google.cloud.aiplatform.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * MatchService is a Google managed service for efficient vector similarity
 * search at scale.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1/match_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MatchServiceGrpc {

  private MatchServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.aiplatform.v1.MatchService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.FindNeighborsRequest,
          com.google.cloud.aiplatform.v1.FindNeighborsResponse>
      getFindNeighborsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindNeighbors",
      requestType = com.google.cloud.aiplatform.v1.FindNeighborsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.FindNeighborsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.FindNeighborsRequest,
          com.google.cloud.aiplatform.v1.FindNeighborsResponse>
      getFindNeighborsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.FindNeighborsRequest,
            com.google.cloud.aiplatform.v1.FindNeighborsResponse>
        getFindNeighborsMethod;
    if ((getFindNeighborsMethod = MatchServiceGrpc.getFindNeighborsMethod) == null) {
      synchronized (MatchServiceGrpc.class) {
        if ((getFindNeighborsMethod = MatchServiceGrpc.getFindNeighborsMethod) == null) {
          MatchServiceGrpc.getFindNeighborsMethod =
              getFindNeighborsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.FindNeighborsRequest,
                          com.google.cloud.aiplatform.v1.FindNeighborsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindNeighbors"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.FindNeighborsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.FindNeighborsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MatchServiceMethodDescriptorSupplier("FindNeighbors"))
                      .build();
        }
      }
    }
    return getFindNeighborsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ReadIndexDatapointsRequest,
          com.google.cloud.aiplatform.v1.ReadIndexDatapointsResponse>
      getReadIndexDatapointsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadIndexDatapoints",
      requestType = com.google.cloud.aiplatform.v1.ReadIndexDatapointsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ReadIndexDatapointsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ReadIndexDatapointsRequest,
          com.google.cloud.aiplatform.v1.ReadIndexDatapointsResponse>
      getReadIndexDatapointsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ReadIndexDatapointsRequest,
            com.google.cloud.aiplatform.v1.ReadIndexDatapointsResponse>
        getReadIndexDatapointsMethod;
    if ((getReadIndexDatapointsMethod = MatchServiceGrpc.getReadIndexDatapointsMethod) == null) {
      synchronized (MatchServiceGrpc.class) {
        if ((getReadIndexDatapointsMethod = MatchServiceGrpc.getReadIndexDatapointsMethod)
            == null) {
          MatchServiceGrpc.getReadIndexDatapointsMethod =
              getReadIndexDatapointsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ReadIndexDatapointsRequest,
                          com.google.cloud.aiplatform.v1.ReadIndexDatapointsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ReadIndexDatapoints"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ReadIndexDatapointsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ReadIndexDatapointsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MatchServiceMethodDescriptorSupplier("ReadIndexDatapoints"))
                      .build();
        }
      }
    }
    return getReadIndexDatapointsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MatchServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MatchServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MatchServiceStub>() {
          @java.lang.Override
          public MatchServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MatchServiceStub(channel, callOptions);
          }
        };
    return MatchServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MatchServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MatchServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MatchServiceBlockingStub>() {
          @java.lang.Override
          public MatchServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MatchServiceBlockingStub(channel, callOptions);
          }
        };
    return MatchServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MatchServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MatchServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MatchServiceFutureStub>() {
          @java.lang.Override
          public MatchServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MatchServiceFutureStub(channel, callOptions);
          }
        };
    return MatchServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * MatchService is a Google managed service for efficient vector similarity
   * search at scale.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Finds the nearest neighbors of each vector within the request.
     * </pre>
     */
    default void findNeighbors(
        com.google.cloud.aiplatform.v1.FindNeighborsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.FindNeighborsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFindNeighborsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reads the datapoints/vectors of the given IDs.
     * A maximum of 1000 datapoints can be retrieved in a batch.
     * </pre>
     */
    default void readIndexDatapoints(
        com.google.cloud.aiplatform.v1.ReadIndexDatapointsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ReadIndexDatapointsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReadIndexDatapointsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MatchService.
   *
   * <pre>
   * MatchService is a Google managed service for efficient vector similarity
   * search at scale.
   * </pre>
   */
  public abstract static class MatchServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return MatchServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MatchService.
   *
   * <pre>
   * MatchService is a Google managed service for efficient vector similarity
   * search at scale.
   * </pre>
   */
  public static final class MatchServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MatchServiceStub> {
    private MatchServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MatchServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MatchServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Finds the nearest neighbors of each vector within the request.
     * </pre>
     */
    public void findNeighbors(
        com.google.cloud.aiplatform.v1.FindNeighborsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.FindNeighborsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindNeighborsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reads the datapoints/vectors of the given IDs.
     * A maximum of 1000 datapoints can be retrieved in a batch.
     * </pre>
     */
    public void readIndexDatapoints(
        com.google.cloud.aiplatform.v1.ReadIndexDatapointsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ReadIndexDatapointsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadIndexDatapointsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MatchService.
   *
   * <pre>
   * MatchService is a Google managed service for efficient vector similarity
   * search at scale.
   * </pre>
   */
  public static final class MatchServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MatchServiceBlockingStub> {
    private MatchServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MatchServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MatchServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Finds the nearest neighbors of each vector within the request.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.FindNeighborsResponse findNeighbors(
        com.google.cloud.aiplatform.v1.FindNeighborsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindNeighborsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reads the datapoints/vectors of the given IDs.
     * A maximum of 1000 datapoints can be retrieved in a batch.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ReadIndexDatapointsResponse readIndexDatapoints(
        com.google.cloud.aiplatform.v1.ReadIndexDatapointsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadIndexDatapointsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MatchService.
   *
   * <pre>
   * MatchService is a Google managed service for efficient vector similarity
   * search at scale.
   * </pre>
   */
  public static final class MatchServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MatchServiceFutureStub> {
    private MatchServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MatchServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MatchServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Finds the nearest neighbors of each vector within the request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.FindNeighborsResponse>
        findNeighbors(com.google.cloud.aiplatform.v1.FindNeighborsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindNeighborsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reads the datapoints/vectors of the given IDs.
     * A maximum of 1000 datapoints can be retrieved in a batch.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ReadIndexDatapointsResponse>
        readIndexDatapoints(com.google.cloud.aiplatform.v1.ReadIndexDatapointsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadIndexDatapointsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_NEIGHBORS = 0;
  private static final int METHODID_READ_INDEX_DATAPOINTS = 1;

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
        case METHODID_FIND_NEIGHBORS:
          serviceImpl.findNeighbors(
              (com.google.cloud.aiplatform.v1.FindNeighborsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.FindNeighborsResponse>)
                  responseObserver);
          break;
        case METHODID_READ_INDEX_DATAPOINTS:
          serviceImpl.readIndexDatapoints(
              (com.google.cloud.aiplatform.v1.ReadIndexDatapointsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1.ReadIndexDatapointsResponse>)
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
            getFindNeighborsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.FindNeighborsRequest,
                    com.google.cloud.aiplatform.v1.FindNeighborsResponse>(
                    service, METHODID_FIND_NEIGHBORS)))
        .addMethod(
            getReadIndexDatapointsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.ReadIndexDatapointsRequest,
                    com.google.cloud.aiplatform.v1.ReadIndexDatapointsResponse>(
                    service, METHODID_READ_INDEX_DATAPOINTS)))
        .build();
  }

  private abstract static class MatchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MatchServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1.MatchServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MatchService");
    }
  }

  private static final class MatchServiceFileDescriptorSupplier
      extends MatchServiceBaseDescriptorSupplier {
    MatchServiceFileDescriptorSupplier() {}
  }

  private static final class MatchServiceMethodDescriptorSupplier
      extends MatchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MatchServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MatchServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new MatchServiceFileDescriptorSupplier())
                      .addMethod(getFindNeighborsMethod())
                      .addMethod(getReadIndexDatapointsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
