/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.support.v2beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service to view case feed items.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/support/v2beta/feed_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FeedServiceGrpc {

  private FeedServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.support.v2beta.FeedService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.support.v2beta.ShowFeedRequest,
          com.google.cloud.support.v2beta.ShowFeedResponse>
      getShowFeedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ShowFeed",
      requestType = com.google.cloud.support.v2beta.ShowFeedRequest.class,
      responseType = com.google.cloud.support.v2beta.ShowFeedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.support.v2beta.ShowFeedRequest,
          com.google.cloud.support.v2beta.ShowFeedResponse>
      getShowFeedMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.support.v2beta.ShowFeedRequest,
            com.google.cloud.support.v2beta.ShowFeedResponse>
        getShowFeedMethod;
    if ((getShowFeedMethod = FeedServiceGrpc.getShowFeedMethod) == null) {
      synchronized (FeedServiceGrpc.class) {
        if ((getShowFeedMethod = FeedServiceGrpc.getShowFeedMethod) == null) {
          FeedServiceGrpc.getShowFeedMethod =
              getShowFeedMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.support.v2beta.ShowFeedRequest,
                          com.google.cloud.support.v2beta.ShowFeedResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ShowFeed"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2beta.ShowFeedRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2beta.ShowFeedResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new FeedServiceMethodDescriptorSupplier("ShowFeed"))
                      .build();
        }
      }
    }
    return getShowFeedMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static FeedServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeedServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FeedServiceStub>() {
          @java.lang.Override
          public FeedServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FeedServiceStub(channel, callOptions);
          }
        };
    return FeedServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static FeedServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeedServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FeedServiceBlockingV2Stub>() {
          @java.lang.Override
          public FeedServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FeedServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return FeedServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FeedServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeedServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FeedServiceBlockingStub>() {
          @java.lang.Override
          public FeedServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FeedServiceBlockingStub(channel, callOptions);
          }
        };
    return FeedServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static FeedServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeedServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FeedServiceFutureStub>() {
          @java.lang.Override
          public FeedServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FeedServiceFutureStub(channel, callOptions);
          }
        };
    return FeedServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service to view case feed items.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Show items in the feed of this case, including case emails,
     * attachments, and comments.
     * </pre>
     */
    default void showFeed(
        com.google.cloud.support.v2beta.ShowFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2beta.ShowFeedResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getShowFeedMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FeedService.
   *
   * <pre>
   * A service to view case feed items.
   * </pre>
   */
  public abstract static class FeedServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return FeedServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FeedService.
   *
   * <pre>
   * A service to view case feed items.
   * </pre>
   */
  public static final class FeedServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FeedServiceStub> {
    private FeedServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeedServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeedServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Show items in the feed of this case, including case emails,
     * attachments, and comments.
     * </pre>
     */
    public void showFeed(
        com.google.cloud.support.v2beta.ShowFeedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2beta.ShowFeedResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getShowFeedMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FeedService.
   *
   * <pre>
   * A service to view case feed items.
   * </pre>
   */
  public static final class FeedServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<FeedServiceBlockingV2Stub> {
    private FeedServiceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeedServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeedServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Show items in the feed of this case, including case emails,
     * attachments, and comments.
     * </pre>
     */
    public com.google.cloud.support.v2beta.ShowFeedResponse showFeed(
        com.google.cloud.support.v2beta.ShowFeedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getShowFeedMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service FeedService.
   *
   * <pre>
   * A service to view case feed items.
   * </pre>
   */
  public static final class FeedServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FeedServiceBlockingStub> {
    private FeedServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeedServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeedServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Show items in the feed of this case, including case emails,
     * attachments, and comments.
     * </pre>
     */
    public com.google.cloud.support.v2beta.ShowFeedResponse showFeed(
        com.google.cloud.support.v2beta.ShowFeedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getShowFeedMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FeedService.
   *
   * <pre>
   * A service to view case feed items.
   * </pre>
   */
  public static final class FeedServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FeedServiceFutureStub> {
    private FeedServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeedServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeedServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Show items in the feed of this case, including case emails,
     * attachments, and comments.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.support.v2beta.ShowFeedResponse>
        showFeed(com.google.cloud.support.v2beta.ShowFeedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getShowFeedMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SHOW_FEED = 0;

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
        case METHODID_SHOW_FEED:
          serviceImpl.showFeed(
              (com.google.cloud.support.v2beta.ShowFeedRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.support.v2beta.ShowFeedResponse>)
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
            getShowFeedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.support.v2beta.ShowFeedRequest,
                    com.google.cloud.support.v2beta.ShowFeedResponse>(service, METHODID_SHOW_FEED)))
        .build();
  }

  private abstract static class FeedServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FeedServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.support.v2beta.FeedServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FeedService");
    }
  }

  private static final class FeedServiceFileDescriptorSupplier
      extends FeedServiceBaseDescriptorSupplier {
    FeedServiceFileDescriptorSupplier() {}
  }

  private static final class FeedServiceMethodDescriptorSupplier
      extends FeedServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FeedServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FeedServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new FeedServiceFileDescriptorSupplier())
                      .addMethod(getShowFeedMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
