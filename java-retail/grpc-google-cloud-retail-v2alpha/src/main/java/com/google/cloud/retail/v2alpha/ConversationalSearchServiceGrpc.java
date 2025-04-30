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
package com.google.cloud.retail.v2alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for retail conversational search.
 * This feature is only available for users who have Retail Conversational
 * Search enabled. Enable Retail Conversational Search on Cloud Console
 * before using this feature.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/retail/v2alpha/conversational_search_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConversationalSearchServiceGrpc {

  private ConversationalSearchServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.retail.v2alpha.ConversationalSearchService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.ConversationalSearchRequest,
          com.google.cloud.retail.v2alpha.ConversationalSearchResponse>
      getConversationalSearchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ConversationalSearch",
      requestType = com.google.cloud.retail.v2alpha.ConversationalSearchRequest.class,
      responseType = com.google.cloud.retail.v2alpha.ConversationalSearchResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.ConversationalSearchRequest,
          com.google.cloud.retail.v2alpha.ConversationalSearchResponse>
      getConversationalSearchMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2alpha.ConversationalSearchRequest,
            com.google.cloud.retail.v2alpha.ConversationalSearchResponse>
        getConversationalSearchMethod;
    if ((getConversationalSearchMethod =
            ConversationalSearchServiceGrpc.getConversationalSearchMethod)
        == null) {
      synchronized (ConversationalSearchServiceGrpc.class) {
        if ((getConversationalSearchMethod =
                ConversationalSearchServiceGrpc.getConversationalSearchMethod)
            == null) {
          ConversationalSearchServiceGrpc.getConversationalSearchMethod =
              getConversationalSearchMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2alpha.ConversationalSearchRequest,
                          com.google.cloud.retail.v2alpha.ConversationalSearchResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ConversationalSearch"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.ConversationalSearchRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.ConversationalSearchResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversationalSearchServiceMethodDescriptorSupplier(
                              "ConversationalSearch"))
                      .build();
        }
      }
    }
    return getConversationalSearchMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ConversationalSearchServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationalSearchServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConversationalSearchServiceStub>() {
          @java.lang.Override
          public ConversationalSearchServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConversationalSearchServiceStub(channel, callOptions);
          }
        };
    return ConversationalSearchServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ConversationalSearchServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationalSearchServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConversationalSearchServiceBlockingV2Stub>() {
          @java.lang.Override
          public ConversationalSearchServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConversationalSearchServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return ConversationalSearchServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConversationalSearchServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationalSearchServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConversationalSearchServiceBlockingStub>() {
          @java.lang.Override
          public ConversationalSearchServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConversationalSearchServiceBlockingStub(channel, callOptions);
          }
        };
    return ConversationalSearchServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ConversationalSearchServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationalSearchServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConversationalSearchServiceFutureStub>() {
          @java.lang.Override
          public ConversationalSearchServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConversationalSearchServiceFutureStub(channel, callOptions);
          }
        };
    return ConversationalSearchServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for retail conversational search.
   * This feature is only available for users who have Retail Conversational
   * Search enabled. Enable Retail Conversational Search on Cloud Console
   * before using this feature.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Performs a conversational search.
     * This feature is only available for users who have Conversational Search
     * enabled.
     * </pre>
     */
    default void conversationalSearch(
        com.google.cloud.retail.v2alpha.ConversationalSearchRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.ConversationalSearchResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getConversationalSearchMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ConversationalSearchService.
   *
   * <pre>
   * Service for retail conversational search.
   * This feature is only available for users who have Retail Conversational
   * Search enabled. Enable Retail Conversational Search on Cloud Console
   * before using this feature.
   * </pre>
   */
  public abstract static class ConversationalSearchServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ConversationalSearchServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ConversationalSearchService.
   *
   * <pre>
   * Service for retail conversational search.
   * This feature is only available for users who have Retail Conversational
   * Search enabled. Enable Retail Conversational Search on Cloud Console
   * before using this feature.
   * </pre>
   */
  public static final class ConversationalSearchServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ConversationalSearchServiceStub> {
    private ConversationalSearchServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationalSearchServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationalSearchServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Performs a conversational search.
     * This feature is only available for users who have Conversational Search
     * enabled.
     * </pre>
     */
    public void conversationalSearch(
        com.google.cloud.retail.v2alpha.ConversationalSearchRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.ConversationalSearchResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getConversationalSearchMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ConversationalSearchService.
   *
   * <pre>
   * Service for retail conversational search.
   * This feature is only available for users who have Retail Conversational
   * Search enabled. Enable Retail Conversational Search on Cloud Console
   * before using this feature.
   * </pre>
   */
  public static final class ConversationalSearchServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ConversationalSearchServiceBlockingV2Stub> {
    private ConversationalSearchServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationalSearchServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationalSearchServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Performs a conversational search.
     * This feature is only available for users who have Conversational Search
     * enabled.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<
            ?, com.google.cloud.retail.v2alpha.ConversationalSearchResponse>
        conversationalSearch(com.google.cloud.retail.v2alpha.ConversationalSearchRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getConversationalSearchMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * ConversationalSearchService.
   *
   * <pre>
   * Service for retail conversational search.
   * This feature is only available for users who have Retail Conversational
   * Search enabled. Enable Retail Conversational Search on Cloud Console
   * before using this feature.
   * </pre>
   */
  public static final class ConversationalSearchServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ConversationalSearchServiceBlockingStub> {
    private ConversationalSearchServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationalSearchServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationalSearchServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Performs a conversational search.
     * This feature is only available for users who have Conversational Search
     * enabled.
     * </pre>
     */
    public java.util.Iterator<com.google.cloud.retail.v2alpha.ConversationalSearchResponse>
        conversationalSearch(com.google.cloud.retail.v2alpha.ConversationalSearchRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getConversationalSearchMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * ConversationalSearchService.
   *
   * <pre>
   * Service for retail conversational search.
   * This feature is only available for users who have Retail Conversational
   * Search enabled. Enable Retail Conversational Search on Cloud Console
   * before using this feature.
   * </pre>
   */
  public static final class ConversationalSearchServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ConversationalSearchServiceFutureStub> {
    private ConversationalSearchServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationalSearchServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationalSearchServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CONVERSATIONAL_SEARCH = 0;

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
        case METHODID_CONVERSATIONAL_SEARCH:
          serviceImpl.conversationalSearch(
              (com.google.cloud.retail.v2alpha.ConversationalSearchRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.retail.v2alpha.ConversationalSearchResponse>)
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
            getConversationalSearchMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2alpha.ConversationalSearchRequest,
                    com.google.cloud.retail.v2alpha.ConversationalSearchResponse>(
                    service, METHODID_CONVERSATIONAL_SEARCH)))
        .build();
  }

  private abstract static class ConversationalSearchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConversationalSearchServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.retail.v2alpha.ConversationalSearchServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConversationalSearchService");
    }
  }

  private static final class ConversationalSearchServiceFileDescriptorSupplier
      extends ConversationalSearchServiceBaseDescriptorSupplier {
    ConversationalSearchServiceFileDescriptorSupplier() {}
  }

  private static final class ConversationalSearchServiceMethodDescriptorSupplier
      extends ConversationalSearchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ConversationalSearchServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ConversationalSearchServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ConversationalSearchServiceFileDescriptorSupplier())
                      .addMethod(getConversationalSearchMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
