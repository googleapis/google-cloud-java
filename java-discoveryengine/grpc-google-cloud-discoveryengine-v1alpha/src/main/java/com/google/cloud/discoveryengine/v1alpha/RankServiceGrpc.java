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
package com.google.cloud.discoveryengine.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for ranking text records.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1alpha/rank_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RankServiceGrpc {

  private RankServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1alpha.RankService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.RankRequest,
          com.google.cloud.discoveryengine.v1alpha.RankResponse>
      getRankMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Rank",
      requestType = com.google.cloud.discoveryengine.v1alpha.RankRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.RankResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.RankRequest,
          com.google.cloud.discoveryengine.v1alpha.RankResponse>
      getRankMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.RankRequest,
            com.google.cloud.discoveryengine.v1alpha.RankResponse>
        getRankMethod;
    if ((getRankMethod = RankServiceGrpc.getRankMethod) == null) {
      synchronized (RankServiceGrpc.class) {
        if ((getRankMethod = RankServiceGrpc.getRankMethod) == null) {
          RankServiceGrpc.getRankMethod =
              getRankMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.RankRequest,
                          com.google.cloud.discoveryengine.v1alpha.RankResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Rank"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.RankRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.RankResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new RankServiceMethodDescriptorSupplier("Rank"))
                      .build();
        }
      }
    }
    return getRankMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static RankServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RankServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RankServiceStub>() {
          @java.lang.Override
          public RankServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RankServiceStub(channel, callOptions);
          }
        };
    return RankServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RankServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RankServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RankServiceBlockingStub>() {
          @java.lang.Override
          public RankServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RankServiceBlockingStub(channel, callOptions);
          }
        };
    return RankServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RankServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RankServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RankServiceFutureStub>() {
          @java.lang.Override
          public RankServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RankServiceFutureStub(channel, callOptions);
          }
        };
    return RankServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for ranking text records.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Ranks a list of text records based on the given input query.
     * </pre>
     */
    default void rank(
        com.google.cloud.discoveryengine.v1alpha.RankRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.RankResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRankMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RankService.
   *
   * <pre>
   * Service for ranking text records.
   * </pre>
   */
  public abstract static class RankServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return RankServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RankService.
   *
   * <pre>
   * Service for ranking text records.
   * </pre>
   */
  public static final class RankServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RankServiceStub> {
    private RankServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RankServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RankServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Ranks a list of text records based on the given input query.
     * </pre>
     */
    public void rank(
        com.google.cloud.discoveryengine.v1alpha.RankRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.RankResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRankMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RankService.
   *
   * <pre>
   * Service for ranking text records.
   * </pre>
   */
  public static final class RankServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RankServiceBlockingStub> {
    private RankServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RankServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RankServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Ranks a list of text records based on the given input query.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.RankResponse rank(
        com.google.cloud.discoveryengine.v1alpha.RankRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRankMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RankService.
   *
   * <pre>
   * Service for ranking text records.
   * </pre>
   */
  public static final class RankServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RankServiceFutureStub> {
    private RankServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RankServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RankServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Ranks a list of text records based on the given input query.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1alpha.RankResponse>
        rank(com.google.cloud.discoveryengine.v1alpha.RankRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRankMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RANK = 0;

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
        case METHODID_RANK:
          serviceImpl.rank(
              (com.google.cloud.discoveryengine.v1alpha.RankRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.RankResponse>)
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
            getRankMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.RankRequest,
                    com.google.cloud.discoveryengine.v1alpha.RankResponse>(service, METHODID_RANK)))
        .build();
  }

  private abstract static class RankServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RankServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1alpha.RankServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RankService");
    }
  }

  private static final class RankServiceFileDescriptorSupplier
      extends RankServiceBaseDescriptorSupplier {
    RankServiceFileDescriptorSupplier() {}
  }

  private static final class RankServiceMethodDescriptorSupplier
      extends RankServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RankServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (RankServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new RankServiceFileDescriptorSupplier())
                      .addMethod(getRankMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
