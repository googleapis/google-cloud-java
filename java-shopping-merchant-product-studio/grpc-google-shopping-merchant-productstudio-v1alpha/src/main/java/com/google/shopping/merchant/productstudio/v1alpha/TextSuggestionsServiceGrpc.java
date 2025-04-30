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
package com.google.shopping.merchant.productstudio.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service that exposes Generative AI (GenAI) endpoints for creating and
 * enhancing product text content, such as titles, descriptions, etc.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/productstudio/v1alpha/textsuggestions.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TextSuggestionsServiceGrpc {

  private TextSuggestionsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.productstudio.v1alpha.TextSuggestionsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.productstudio.v1alpha.GenerateProductTextSuggestionsRequest,
          com.google.shopping.merchant.productstudio.v1alpha.GenerateProductTextSuggestionsResponse>
      getGenerateProductTextSuggestionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateProductTextSuggestions",
      requestType =
          com.google.shopping.merchant.productstudio.v1alpha.GenerateProductTextSuggestionsRequest
              .class,
      responseType =
          com.google.shopping.merchant.productstudio.v1alpha.GenerateProductTextSuggestionsResponse
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.productstudio.v1alpha.GenerateProductTextSuggestionsRequest,
          com.google.shopping.merchant.productstudio.v1alpha.GenerateProductTextSuggestionsResponse>
      getGenerateProductTextSuggestionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.productstudio.v1alpha
                .GenerateProductTextSuggestionsRequest,
            com.google.shopping.merchant.productstudio.v1alpha
                .GenerateProductTextSuggestionsResponse>
        getGenerateProductTextSuggestionsMethod;
    if ((getGenerateProductTextSuggestionsMethod =
            TextSuggestionsServiceGrpc.getGenerateProductTextSuggestionsMethod)
        == null) {
      synchronized (TextSuggestionsServiceGrpc.class) {
        if ((getGenerateProductTextSuggestionsMethod =
                TextSuggestionsServiceGrpc.getGenerateProductTextSuggestionsMethod)
            == null) {
          TextSuggestionsServiceGrpc.getGenerateProductTextSuggestionsMethod =
              getGenerateProductTextSuggestionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.productstudio.v1alpha
                              .GenerateProductTextSuggestionsRequest,
                          com.google.shopping.merchant.productstudio.v1alpha
                              .GenerateProductTextSuggestionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateProductTextSuggestions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.productstudio.v1alpha
                                  .GenerateProductTextSuggestionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.productstudio.v1alpha
                                  .GenerateProductTextSuggestionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TextSuggestionsServiceMethodDescriptorSupplier(
                              "GenerateProductTextSuggestions"))
                      .build();
        }
      }
    }
    return getGenerateProductTextSuggestionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TextSuggestionsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TextSuggestionsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TextSuggestionsServiceStub>() {
          @java.lang.Override
          public TextSuggestionsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TextSuggestionsServiceStub(channel, callOptions);
          }
        };
    return TextSuggestionsServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static TextSuggestionsServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TextSuggestionsServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TextSuggestionsServiceBlockingV2Stub>() {
          @java.lang.Override
          public TextSuggestionsServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TextSuggestionsServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return TextSuggestionsServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TextSuggestionsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TextSuggestionsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TextSuggestionsServiceBlockingStub>() {
          @java.lang.Override
          public TextSuggestionsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TextSuggestionsServiceBlockingStub(channel, callOptions);
          }
        };
    return TextSuggestionsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TextSuggestionsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TextSuggestionsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TextSuggestionsServiceFutureStub>() {
          @java.lang.Override
          public TextSuggestionsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TextSuggestionsServiceFutureStub(channel, callOptions);
          }
        };
    return TextSuggestionsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service that exposes Generative AI (GenAI) endpoints for creating and
   * enhancing product text content, such as titles, descriptions, etc.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * GenerateProductTextSuggestions generates a set of candidate text
     * completions (e.g., product titles, descriptions) based on provided product
     * information. This endpoint leverages GenAI models to create suggestions for
     * improving existing product text or generating new content.
     * </pre>
     */
    default void generateProductTextSuggestions(
        com.google.shopping.merchant.productstudio.v1alpha.GenerateProductTextSuggestionsRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.productstudio.v1alpha
                    .GenerateProductTextSuggestionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateProductTextSuggestionsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TextSuggestionsService.
   *
   * <pre>
   * Service that exposes Generative AI (GenAI) endpoints for creating and
   * enhancing product text content, such as titles, descriptions, etc.
   * </pre>
   */
  public abstract static class TextSuggestionsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return TextSuggestionsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TextSuggestionsService.
   *
   * <pre>
   * Service that exposes Generative AI (GenAI) endpoints for creating and
   * enhancing product text content, such as titles, descriptions, etc.
   * </pre>
   */
  public static final class TextSuggestionsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<TextSuggestionsServiceStub> {
    private TextSuggestionsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TextSuggestionsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TextSuggestionsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * GenerateProductTextSuggestions generates a set of candidate text
     * completions (e.g., product titles, descriptions) based on provided product
     * information. This endpoint leverages GenAI models to create suggestions for
     * improving existing product text or generating new content.
     * </pre>
     */
    public void generateProductTextSuggestions(
        com.google.shopping.merchant.productstudio.v1alpha.GenerateProductTextSuggestionsRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.productstudio.v1alpha
                    .GenerateProductTextSuggestionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateProductTextSuggestionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TextSuggestionsService.
   *
   * <pre>
   * Service that exposes Generative AI (GenAI) endpoints for creating and
   * enhancing product text content, such as titles, descriptions, etc.
   * </pre>
   */
  public static final class TextSuggestionsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<TextSuggestionsServiceBlockingV2Stub> {
    private TextSuggestionsServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TextSuggestionsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TextSuggestionsServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * GenerateProductTextSuggestions generates a set of candidate text
     * completions (e.g., product titles, descriptions) based on provided product
     * information. This endpoint leverages GenAI models to create suggestions for
     * improving existing product text or generating new content.
     * </pre>
     */
    public com.google.shopping.merchant.productstudio.v1alpha.GenerateProductTextSuggestionsResponse
        generateProductTextSuggestions(
            com.google.shopping.merchant.productstudio.v1alpha.GenerateProductTextSuggestionsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateProductTextSuggestionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service TextSuggestionsService.
   *
   * <pre>
   * Service that exposes Generative AI (GenAI) endpoints for creating and
   * enhancing product text content, such as titles, descriptions, etc.
   * </pre>
   */
  public static final class TextSuggestionsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TextSuggestionsServiceBlockingStub> {
    private TextSuggestionsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TextSuggestionsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TextSuggestionsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * GenerateProductTextSuggestions generates a set of candidate text
     * completions (e.g., product titles, descriptions) based on provided product
     * information. This endpoint leverages GenAI models to create suggestions for
     * improving existing product text or generating new content.
     * </pre>
     */
    public com.google.shopping.merchant.productstudio.v1alpha.GenerateProductTextSuggestionsResponse
        generateProductTextSuggestions(
            com.google.shopping.merchant.productstudio.v1alpha.GenerateProductTextSuggestionsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateProductTextSuggestionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * TextSuggestionsService.
   *
   * <pre>
   * Service that exposes Generative AI (GenAI) endpoints for creating and
   * enhancing product text content, such as titles, descriptions, etc.
   * </pre>
   */
  public static final class TextSuggestionsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<TextSuggestionsServiceFutureStub> {
    private TextSuggestionsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TextSuggestionsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TextSuggestionsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * GenerateProductTextSuggestions generates a set of candidate text
     * completions (e.g., product titles, descriptions) based on provided product
     * information. This endpoint leverages GenAI models to create suggestions for
     * improving existing product text or generating new content.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.productstudio.v1alpha
                .GenerateProductTextSuggestionsResponse>
        generateProductTextSuggestions(
            com.google.shopping.merchant.productstudio.v1alpha.GenerateProductTextSuggestionsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateProductTextSuggestionsMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_GENERATE_PRODUCT_TEXT_SUGGESTIONS = 0;

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
        case METHODID_GENERATE_PRODUCT_TEXT_SUGGESTIONS:
          serviceImpl.generateProductTextSuggestions(
              (com.google.shopping.merchant.productstudio.v1alpha
                      .GenerateProductTextSuggestionsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.productstudio.v1alpha
                          .GenerateProductTextSuggestionsResponse>)
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
            getGenerateProductTextSuggestionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.productstudio.v1alpha
                        .GenerateProductTextSuggestionsRequest,
                    com.google.shopping.merchant.productstudio.v1alpha
                        .GenerateProductTextSuggestionsResponse>(
                    service, METHODID_GENERATE_PRODUCT_TEXT_SUGGESTIONS)))
        .build();
  }

  private abstract static class TextSuggestionsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TextSuggestionsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.productstudio.v1alpha.TextSuggestionsProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TextSuggestionsService");
    }
  }

  private static final class TextSuggestionsServiceFileDescriptorSupplier
      extends TextSuggestionsServiceBaseDescriptorSupplier {
    TextSuggestionsServiceFileDescriptorSupplier() {}
  }

  private static final class TextSuggestionsServiceMethodDescriptorSupplier
      extends TextSuggestionsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TextSuggestionsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (TextSuggestionsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new TextSuggestionsServiceFileDescriptorSupplier())
                      .addMethod(getGenerateProductTextSuggestionsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
