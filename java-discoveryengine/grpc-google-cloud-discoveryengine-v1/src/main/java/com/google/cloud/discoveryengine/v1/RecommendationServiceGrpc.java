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
package com.google.cloud.discoveryengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for making recommendations.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1/recommendation_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RecommendationServiceGrpc {

  private RecommendationServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1.RecommendationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.RecommendRequest,
          com.google.cloud.discoveryengine.v1.RecommendResponse>
      getRecommendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Recommend",
      requestType = com.google.cloud.discoveryengine.v1.RecommendRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.RecommendResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.RecommendRequest,
          com.google.cloud.discoveryengine.v1.RecommendResponse>
      getRecommendMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.RecommendRequest,
            com.google.cloud.discoveryengine.v1.RecommendResponse>
        getRecommendMethod;
    if ((getRecommendMethod = RecommendationServiceGrpc.getRecommendMethod) == null) {
      synchronized (RecommendationServiceGrpc.class) {
        if ((getRecommendMethod = RecommendationServiceGrpc.getRecommendMethod) == null) {
          RecommendationServiceGrpc.getRecommendMethod =
              getRecommendMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.RecommendRequest,
                          com.google.cloud.discoveryengine.v1.RecommendResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Recommend"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.RecommendRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.RecommendResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecommendationServiceMethodDescriptorSupplier("Recommend"))
                      .build();
        }
      }
    }
    return getRecommendMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static RecommendationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecommendationServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RecommendationServiceStub>() {
          @java.lang.Override
          public RecommendationServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RecommendationServiceStub(channel, callOptions);
          }
        };
    return RecommendationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecommendationServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecommendationServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RecommendationServiceBlockingStub>() {
          @java.lang.Override
          public RecommendationServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RecommendationServiceBlockingStub(channel, callOptions);
          }
        };
    return RecommendationServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RecommendationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecommendationServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RecommendationServiceFutureStub>() {
          @java.lang.Override
          public RecommendationServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RecommendationServiceFutureStub(channel, callOptions);
          }
        };
    return RecommendationServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for making recommendations.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Makes a recommendation, which requires a contextual user event.
     * </pre>
     */
    default void recommend(
        com.google.cloud.discoveryengine.v1.RecommendRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.RecommendResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRecommendMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RecommendationService.
   *
   * <pre>
   * Service for making recommendations.
   * </pre>
   */
  public abstract static class RecommendationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return RecommendationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RecommendationService.
   *
   * <pre>
   * Service for making recommendations.
   * </pre>
   */
  public static final class RecommendationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RecommendationServiceStub> {
    private RecommendationServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecommendationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecommendationServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Makes a recommendation, which requires a contextual user event.
     * </pre>
     */
    public void recommend(
        com.google.cloud.discoveryengine.v1.RecommendRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.RecommendResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRecommendMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RecommendationService.
   *
   * <pre>
   * Service for making recommendations.
   * </pre>
   */
  public static final class RecommendationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RecommendationServiceBlockingStub> {
    private RecommendationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecommendationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecommendationServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Makes a recommendation, which requires a contextual user event.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.RecommendResponse recommend(
        com.google.cloud.discoveryengine.v1.RecommendRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRecommendMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * RecommendationService.
   *
   * <pre>
   * Service for making recommendations.
   * </pre>
   */
  public static final class RecommendationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RecommendationServiceFutureStub> {
    private RecommendationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecommendationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecommendationServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Makes a recommendation, which requires a contextual user event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1.RecommendResponse>
        recommend(com.google.cloud.discoveryengine.v1.RecommendRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRecommendMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RECOMMEND = 0;

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
        case METHODID_RECOMMEND:
          serviceImpl.recommend(
              (com.google.cloud.discoveryengine.v1.RecommendRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.RecommendResponse>)
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
            getRecommendMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.RecommendRequest,
                    com.google.cloud.discoveryengine.v1.RecommendResponse>(
                    service, METHODID_RECOMMEND)))
        .build();
  }

  private abstract static class RecommendationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecommendationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1.RecommendationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RecommendationService");
    }
  }

  private static final class RecommendationServiceFileDescriptorSupplier
      extends RecommendationServiceBaseDescriptorSupplier {
    RecommendationServiceFileDescriptorSupplier() {}
  }

  private static final class RecommendationServiceMethodDescriptorSupplier
      extends RecommendationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RecommendationServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (RecommendationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new RecommendationServiceFileDescriptorSupplier())
                      .addMethod(getRecommendMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
