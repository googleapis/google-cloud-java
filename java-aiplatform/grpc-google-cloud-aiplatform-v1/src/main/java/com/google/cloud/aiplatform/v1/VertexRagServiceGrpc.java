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
 * A service for retrieving relevant contexts.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1/vertex_rag_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class VertexRagServiceGrpc {

  private VertexRagServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.aiplatform.v1.VertexRagService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.RetrieveContextsRequest,
          com.google.cloud.aiplatform.v1.RetrieveContextsResponse>
      getRetrieveContextsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetrieveContexts",
      requestType = com.google.cloud.aiplatform.v1.RetrieveContextsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.RetrieveContextsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.RetrieveContextsRequest,
          com.google.cloud.aiplatform.v1.RetrieveContextsResponse>
      getRetrieveContextsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.RetrieveContextsRequest,
            com.google.cloud.aiplatform.v1.RetrieveContextsResponse>
        getRetrieveContextsMethod;
    if ((getRetrieveContextsMethod = VertexRagServiceGrpc.getRetrieveContextsMethod) == null) {
      synchronized (VertexRagServiceGrpc.class) {
        if ((getRetrieveContextsMethod = VertexRagServiceGrpc.getRetrieveContextsMethod) == null) {
          VertexRagServiceGrpc.getRetrieveContextsMethod =
              getRetrieveContextsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.RetrieveContextsRequest,
                          com.google.cloud.aiplatform.v1.RetrieveContextsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RetrieveContexts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.RetrieveContextsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.RetrieveContextsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagServiceMethodDescriptorSupplier("RetrieveContexts"))
                      .build();
        }
      }
    }
    return getRetrieveContextsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.AugmentPromptRequest,
          com.google.cloud.aiplatform.v1.AugmentPromptResponse>
      getAugmentPromptMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AugmentPrompt",
      requestType = com.google.cloud.aiplatform.v1.AugmentPromptRequest.class,
      responseType = com.google.cloud.aiplatform.v1.AugmentPromptResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.AugmentPromptRequest,
          com.google.cloud.aiplatform.v1.AugmentPromptResponse>
      getAugmentPromptMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.AugmentPromptRequest,
            com.google.cloud.aiplatform.v1.AugmentPromptResponse>
        getAugmentPromptMethod;
    if ((getAugmentPromptMethod = VertexRagServiceGrpc.getAugmentPromptMethod) == null) {
      synchronized (VertexRagServiceGrpc.class) {
        if ((getAugmentPromptMethod = VertexRagServiceGrpc.getAugmentPromptMethod) == null) {
          VertexRagServiceGrpc.getAugmentPromptMethod =
              getAugmentPromptMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.AugmentPromptRequest,
                          com.google.cloud.aiplatform.v1.AugmentPromptResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AugmentPrompt"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.AugmentPromptRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.AugmentPromptResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagServiceMethodDescriptorSupplier("AugmentPrompt"))
                      .build();
        }
      }
    }
    return getAugmentPromptMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CorroborateContentRequest,
          com.google.cloud.aiplatform.v1.CorroborateContentResponse>
      getCorroborateContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CorroborateContent",
      requestType = com.google.cloud.aiplatform.v1.CorroborateContentRequest.class,
      responseType = com.google.cloud.aiplatform.v1.CorroborateContentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CorroborateContentRequest,
          com.google.cloud.aiplatform.v1.CorroborateContentResponse>
      getCorroborateContentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.CorroborateContentRequest,
            com.google.cloud.aiplatform.v1.CorroborateContentResponse>
        getCorroborateContentMethod;
    if ((getCorroborateContentMethod = VertexRagServiceGrpc.getCorroborateContentMethod) == null) {
      synchronized (VertexRagServiceGrpc.class) {
        if ((getCorroborateContentMethod = VertexRagServiceGrpc.getCorroborateContentMethod)
            == null) {
          VertexRagServiceGrpc.getCorroborateContentMethod =
              getCorroborateContentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.CorroborateContentRequest,
                          com.google.cloud.aiplatform.v1.CorroborateContentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CorroborateContent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.CorroborateContentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.CorroborateContentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VertexRagServiceMethodDescriptorSupplier("CorroborateContent"))
                      .build();
        }
      }
    }
    return getCorroborateContentMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static VertexRagServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VertexRagServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VertexRagServiceStub>() {
          @java.lang.Override
          public VertexRagServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VertexRagServiceStub(channel, callOptions);
          }
        };
    return VertexRagServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VertexRagServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VertexRagServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VertexRagServiceBlockingStub>() {
          @java.lang.Override
          public VertexRagServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VertexRagServiceBlockingStub(channel, callOptions);
          }
        };
    return VertexRagServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static VertexRagServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VertexRagServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VertexRagServiceFutureStub>() {
          @java.lang.Override
          public VertexRagServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VertexRagServiceFutureStub(channel, callOptions);
          }
        };
    return VertexRagServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service for retrieving relevant contexts.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves relevant contexts for a query.
     * </pre>
     */
    default void retrieveContexts(
        com.google.cloud.aiplatform.v1.RetrieveContextsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.RetrieveContextsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRetrieveContextsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Given an input prompt, it returns augmented prompt from vertex rag store
     *  to guide LLM towards generating grounded responses.
     * </pre>
     */
    default void augmentPrompt(
        com.google.cloud.aiplatform.v1.AugmentPromptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.AugmentPromptResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAugmentPromptMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Given an input text, it returns a score that evaluates the factuality of
     * the text. It also extracts and returns claims from the text and provides
     * supporting facts.
     * </pre>
     */
    default void corroborateContent(
        com.google.cloud.aiplatform.v1.CorroborateContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.CorroborateContentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCorroborateContentMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service VertexRagService.
   *
   * <pre>
   * A service for retrieving relevant contexts.
   * </pre>
   */
  public abstract static class VertexRagServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return VertexRagServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service VertexRagService.
   *
   * <pre>
   * A service for retrieving relevant contexts.
   * </pre>
   */
  public static final class VertexRagServiceStub
      extends io.grpc.stub.AbstractAsyncStub<VertexRagServiceStub> {
    private VertexRagServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VertexRagServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VertexRagServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves relevant contexts for a query.
     * </pre>
     */
    public void retrieveContexts(
        com.google.cloud.aiplatform.v1.RetrieveContextsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.RetrieveContextsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetrieveContextsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Given an input prompt, it returns augmented prompt from vertex rag store
     *  to guide LLM towards generating grounded responses.
     * </pre>
     */
    public void augmentPrompt(
        com.google.cloud.aiplatform.v1.AugmentPromptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.AugmentPromptResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAugmentPromptMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Given an input text, it returns a score that evaluates the factuality of
     * the text. It also extracts and returns claims from the text and provides
     * supporting facts.
     * </pre>
     */
    public void corroborateContent(
        com.google.cloud.aiplatform.v1.CorroborateContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.CorroborateContentResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCorroborateContentMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service VertexRagService.
   *
   * <pre>
   * A service for retrieving relevant contexts.
   * </pre>
   */
  public static final class VertexRagServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<VertexRagServiceBlockingStub> {
    private VertexRagServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VertexRagServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VertexRagServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves relevant contexts for a query.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.RetrieveContextsResponse retrieveContexts(
        com.google.cloud.aiplatform.v1.RetrieveContextsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrieveContextsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Given an input prompt, it returns augmented prompt from vertex rag store
     *  to guide LLM towards generating grounded responses.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.AugmentPromptResponse augmentPrompt(
        com.google.cloud.aiplatform.v1.AugmentPromptRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAugmentPromptMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Given an input text, it returns a score that evaluates the factuality of
     * the text. It also extracts and returns claims from the text and provides
     * supporting facts.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.CorroborateContentResponse corroborateContent(
        com.google.cloud.aiplatform.v1.CorroborateContentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCorroborateContentMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service VertexRagService.
   *
   * <pre>
   * A service for retrieving relevant contexts.
   * </pre>
   */
  public static final class VertexRagServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<VertexRagServiceFutureStub> {
    private VertexRagServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VertexRagServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VertexRagServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves relevant contexts for a query.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.RetrieveContextsResponse>
        retrieveContexts(com.google.cloud.aiplatform.v1.RetrieveContextsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetrieveContextsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Given an input prompt, it returns augmented prompt from vertex rag store
     *  to guide LLM towards generating grounded responses.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.AugmentPromptResponse>
        augmentPrompt(com.google.cloud.aiplatform.v1.AugmentPromptRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAugmentPromptMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Given an input text, it returns a score that evaluates the factuality of
     * the text. It also extracts and returns claims from the text and provides
     * supporting facts.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.CorroborateContentResponse>
        corroborateContent(com.google.cloud.aiplatform.v1.CorroborateContentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCorroborateContentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RETRIEVE_CONTEXTS = 0;
  private static final int METHODID_AUGMENT_PROMPT = 1;
  private static final int METHODID_CORROBORATE_CONTENT = 2;

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
        case METHODID_RETRIEVE_CONTEXTS:
          serviceImpl.retrieveContexts(
              (com.google.cloud.aiplatform.v1.RetrieveContextsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.RetrieveContextsResponse>)
                  responseObserver);
          break;
        case METHODID_AUGMENT_PROMPT:
          serviceImpl.augmentPrompt(
              (com.google.cloud.aiplatform.v1.AugmentPromptRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.AugmentPromptResponse>)
                  responseObserver);
          break;
        case METHODID_CORROBORATE_CONTENT:
          serviceImpl.corroborateContent(
              (com.google.cloud.aiplatform.v1.CorroborateContentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1.CorroborateContentResponse>)
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
            getRetrieveContextsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.RetrieveContextsRequest,
                    com.google.cloud.aiplatform.v1.RetrieveContextsResponse>(
                    service, METHODID_RETRIEVE_CONTEXTS)))
        .addMethod(
            getAugmentPromptMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.AugmentPromptRequest,
                    com.google.cloud.aiplatform.v1.AugmentPromptResponse>(
                    service, METHODID_AUGMENT_PROMPT)))
        .addMethod(
            getCorroborateContentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.CorroborateContentRequest,
                    com.google.cloud.aiplatform.v1.CorroborateContentResponse>(
                    service, METHODID_CORROBORATE_CONTENT)))
        .build();
  }

  private abstract static class VertexRagServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VertexRagServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1.VertexRagServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VertexRagService");
    }
  }

  private static final class VertexRagServiceFileDescriptorSupplier
      extends VertexRagServiceBaseDescriptorSupplier {
    VertexRagServiceFileDescriptorSupplier() {}
  }

  private static final class VertexRagServiceMethodDescriptorSupplier
      extends VertexRagServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    VertexRagServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (VertexRagServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new VertexRagServiceFileDescriptorSupplier())
                      .addMethod(getRetrieveContextsMethod())
                      .addMethod(getAugmentPromptMethod())
                      .addMethod(getCorroborateContentMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
