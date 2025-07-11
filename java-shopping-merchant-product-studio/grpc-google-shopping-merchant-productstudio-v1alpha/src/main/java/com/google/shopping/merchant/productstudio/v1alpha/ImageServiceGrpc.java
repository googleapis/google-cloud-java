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
 * enhancing product image content.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/productstudio/v1alpha/image.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ImageServiceGrpc {

  private ImageServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.productstudio.v1alpha.ImageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.productstudio.v1alpha.GenerateProductImageBackgroundRequest,
          com.google.shopping.merchant.productstudio.v1alpha.GenerateProductImageBackgroundResponse>
      getGenerateProductImageBackgroundMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateProductImageBackground",
      requestType =
          com.google.shopping.merchant.productstudio.v1alpha.GenerateProductImageBackgroundRequest
              .class,
      responseType =
          com.google.shopping.merchant.productstudio.v1alpha.GenerateProductImageBackgroundResponse
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.productstudio.v1alpha.GenerateProductImageBackgroundRequest,
          com.google.shopping.merchant.productstudio.v1alpha.GenerateProductImageBackgroundResponse>
      getGenerateProductImageBackgroundMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.productstudio.v1alpha
                .GenerateProductImageBackgroundRequest,
            com.google.shopping.merchant.productstudio.v1alpha
                .GenerateProductImageBackgroundResponse>
        getGenerateProductImageBackgroundMethod;
    if ((getGenerateProductImageBackgroundMethod =
            ImageServiceGrpc.getGenerateProductImageBackgroundMethod)
        == null) {
      synchronized (ImageServiceGrpc.class) {
        if ((getGenerateProductImageBackgroundMethod =
                ImageServiceGrpc.getGenerateProductImageBackgroundMethod)
            == null) {
          ImageServiceGrpc.getGenerateProductImageBackgroundMethod =
              getGenerateProductImageBackgroundMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.productstudio.v1alpha
                              .GenerateProductImageBackgroundRequest,
                          com.google.shopping.merchant.productstudio.v1alpha
                              .GenerateProductImageBackgroundResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateProductImageBackground"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.productstudio.v1alpha
                                  .GenerateProductImageBackgroundRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.productstudio.v1alpha
                                  .GenerateProductImageBackgroundResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ImageServiceMethodDescriptorSupplier(
                              "GenerateProductImageBackground"))
                      .build();
        }
      }
    }
    return getGenerateProductImageBackgroundMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundRequest,
          com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundResponse>
      getRemoveProductImageBackgroundMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveProductImageBackground",
      requestType =
          com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundRequest
              .class,
      responseType =
          com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundResponse
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundRequest,
          com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundResponse>
      getRemoveProductImageBackgroundMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundRequest,
            com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundResponse>
        getRemoveProductImageBackgroundMethod;
    if ((getRemoveProductImageBackgroundMethod =
            ImageServiceGrpc.getRemoveProductImageBackgroundMethod)
        == null) {
      synchronized (ImageServiceGrpc.class) {
        if ((getRemoveProductImageBackgroundMethod =
                ImageServiceGrpc.getRemoveProductImageBackgroundMethod)
            == null) {
          ImageServiceGrpc.getRemoveProductImageBackgroundMethod =
              getRemoveProductImageBackgroundMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.productstudio.v1alpha
                              .RemoveProductImageBackgroundRequest,
                          com.google.shopping.merchant.productstudio.v1alpha
                              .RemoveProductImageBackgroundResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RemoveProductImageBackground"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.productstudio.v1alpha
                                  .RemoveProductImageBackgroundRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.productstudio.v1alpha
                                  .RemoveProductImageBackgroundResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ImageServiceMethodDescriptorSupplier("RemoveProductImageBackground"))
                      .build();
        }
      }
    }
    return getRemoveProductImageBackgroundMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageRequest,
          com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageResponse>
      getUpscaleProductImageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpscaleProductImage",
      requestType =
          com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageRequest.class,
      responseType =
          com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageRequest,
          com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageResponse>
      getUpscaleProductImageMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageRequest,
            com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageResponse>
        getUpscaleProductImageMethod;
    if ((getUpscaleProductImageMethod = ImageServiceGrpc.getUpscaleProductImageMethod) == null) {
      synchronized (ImageServiceGrpc.class) {
        if ((getUpscaleProductImageMethod = ImageServiceGrpc.getUpscaleProductImageMethod)
            == null) {
          ImageServiceGrpc.getUpscaleProductImageMethod =
              getUpscaleProductImageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.productstudio.v1alpha
                              .UpscaleProductImageRequest,
                          com.google.shopping.merchant.productstudio.v1alpha
                              .UpscaleProductImageResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpscaleProductImage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.productstudio.v1alpha
                                  .UpscaleProductImageRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.productstudio.v1alpha
                                  .UpscaleProductImageResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ImageServiceMethodDescriptorSupplier("UpscaleProductImage"))
                      .build();
        }
      }
    }
    return getUpscaleProductImageMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ImageServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ImageServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ImageServiceStub>() {
          @java.lang.Override
          public ImageServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ImageServiceStub(channel, callOptions);
          }
        };
    return ImageServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ImageServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ImageServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ImageServiceBlockingV2Stub>() {
          @java.lang.Override
          public ImageServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ImageServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return ImageServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ImageServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ImageServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ImageServiceBlockingStub>() {
          @java.lang.Override
          public ImageServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ImageServiceBlockingStub(channel, callOptions);
          }
        };
    return ImageServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ImageServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ImageServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ImageServiceFutureStub>() {
          @java.lang.Override
          public ImageServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ImageServiceFutureStub(channel, callOptions);
          }
        };
    return ImageServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service that exposes Generative AI (GenAI) endpoints for creating and
   * enhancing product image content.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * GenerateProductImageBackground generates a new image where the background
     * of the original image is replaced by an AI generated scene based on
     * provided product information and a text prompt.
     * </pre>
     */
    default void generateProductImageBackground(
        com.google.shopping.merchant.productstudio.v1alpha.GenerateProductImageBackgroundRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.productstudio.v1alpha
                    .GenerateProductImageBackgroundResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateProductImageBackgroundMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * RemoveProductImageBackground generates a new image where the background of
     * the original image is removed.
     * </pre>
     */
    default void removeProductImageBackground(
        com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.productstudio.v1alpha
                    .RemoveProductImageBackgroundResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRemoveProductImageBackgroundMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * UpscaleProductImage generates a new image where the resolution of the
     * original image is enhanced.
     * </pre>
     */
    default void upscaleProductImage(
        com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpscaleProductImageMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ImageService.
   *
   * <pre>
   * Service that exposes Generative AI (GenAI) endpoints for creating and
   * enhancing product image content.
   * </pre>
   */
  public abstract static class ImageServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ImageServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ImageService.
   *
   * <pre>
   * Service that exposes Generative AI (GenAI) endpoints for creating and
   * enhancing product image content.
   * </pre>
   */
  public static final class ImageServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ImageServiceStub> {
    private ImageServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ImageServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ImageServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * GenerateProductImageBackground generates a new image where the background
     * of the original image is replaced by an AI generated scene based on
     * provided product information and a text prompt.
     * </pre>
     */
    public void generateProductImageBackground(
        com.google.shopping.merchant.productstudio.v1alpha.GenerateProductImageBackgroundRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.productstudio.v1alpha
                    .GenerateProductImageBackgroundResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateProductImageBackgroundMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * RemoveProductImageBackground generates a new image where the background of
     * the original image is removed.
     * </pre>
     */
    public void removeProductImageBackground(
        com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.productstudio.v1alpha
                    .RemoveProductImageBackgroundResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveProductImageBackgroundMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * UpscaleProductImage generates a new image where the resolution of the
     * original image is enhanced.
     * </pre>
     */
    public void upscaleProductImage(
        com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpscaleProductImageMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ImageService.
   *
   * <pre>
   * Service that exposes Generative AI (GenAI) endpoints for creating and
   * enhancing product image content.
   * </pre>
   */
  public static final class ImageServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ImageServiceBlockingV2Stub> {
    private ImageServiceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ImageServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ImageServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * GenerateProductImageBackground generates a new image where the background
     * of the original image is replaced by an AI generated scene based on
     * provided product information and a text prompt.
     * </pre>
     */
    public com.google.shopping.merchant.productstudio.v1alpha.GenerateProductImageBackgroundResponse
        generateProductImageBackground(
            com.google.shopping.merchant.productstudio.v1alpha.GenerateProductImageBackgroundRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateProductImageBackgroundMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * RemoveProductImageBackground generates a new image where the background of
     * the original image is removed.
     * </pre>
     */
    public com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundResponse
        removeProductImageBackground(
            com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveProductImageBackgroundMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * UpscaleProductImage generates a new image where the resolution of the
     * original image is enhanced.
     * </pre>
     */
    public com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageResponse
        upscaleProductImage(
            com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpscaleProductImageMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ImageService.
   *
   * <pre>
   * Service that exposes Generative AI (GenAI) endpoints for creating and
   * enhancing product image content.
   * </pre>
   */
  public static final class ImageServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ImageServiceBlockingStub> {
    private ImageServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ImageServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ImageServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * GenerateProductImageBackground generates a new image where the background
     * of the original image is replaced by an AI generated scene based on
     * provided product information and a text prompt.
     * </pre>
     */
    public com.google.shopping.merchant.productstudio.v1alpha.GenerateProductImageBackgroundResponse
        generateProductImageBackground(
            com.google.shopping.merchant.productstudio.v1alpha.GenerateProductImageBackgroundRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateProductImageBackgroundMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * RemoveProductImageBackground generates a new image where the background of
     * the original image is removed.
     * </pre>
     */
    public com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundResponse
        removeProductImageBackground(
            com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveProductImageBackgroundMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * UpscaleProductImage generates a new image where the resolution of the
     * original image is enhanced.
     * </pre>
     */
    public com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageResponse
        upscaleProductImage(
            com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpscaleProductImageMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ImageService.
   *
   * <pre>
   * Service that exposes Generative AI (GenAI) endpoints for creating and
   * enhancing product image content.
   * </pre>
   */
  public static final class ImageServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ImageServiceFutureStub> {
    private ImageServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ImageServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ImageServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * GenerateProductImageBackground generates a new image where the background
     * of the original image is replaced by an AI generated scene based on
     * provided product information and a text prompt.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.productstudio.v1alpha
                .GenerateProductImageBackgroundResponse>
        generateProductImageBackground(
            com.google.shopping.merchant.productstudio.v1alpha.GenerateProductImageBackgroundRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateProductImageBackgroundMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * RemoveProductImageBackground generates a new image where the background of
     * the original image is removed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundResponse>
        removeProductImageBackground(
            com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveProductImageBackgroundMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * UpscaleProductImage generates a new image where the resolution of the
     * original image is enhanced.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageResponse>
        upscaleProductImage(
            com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpscaleProductImageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_PRODUCT_IMAGE_BACKGROUND = 0;
  private static final int METHODID_REMOVE_PRODUCT_IMAGE_BACKGROUND = 1;
  private static final int METHODID_UPSCALE_PRODUCT_IMAGE = 2;

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
        case METHODID_GENERATE_PRODUCT_IMAGE_BACKGROUND:
          serviceImpl.generateProductImageBackground(
              (com.google.shopping.merchant.productstudio.v1alpha
                      .GenerateProductImageBackgroundRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.productstudio.v1alpha
                          .GenerateProductImageBackgroundResponse>)
                  responseObserver);
          break;
        case METHODID_REMOVE_PRODUCT_IMAGE_BACKGROUND:
          serviceImpl.removeProductImageBackground(
              (com.google.shopping.merchant.productstudio.v1alpha
                      .RemoveProductImageBackgroundRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.productstudio.v1alpha
                          .RemoveProductImageBackgroundResponse>)
                  responseObserver);
          break;
        case METHODID_UPSCALE_PRODUCT_IMAGE:
          serviceImpl.upscaleProductImage(
              (com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.productstudio.v1alpha
                          .UpscaleProductImageResponse>)
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
            getGenerateProductImageBackgroundMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.productstudio.v1alpha
                        .GenerateProductImageBackgroundRequest,
                    com.google.shopping.merchant.productstudio.v1alpha
                        .GenerateProductImageBackgroundResponse>(
                    service, METHODID_GENERATE_PRODUCT_IMAGE_BACKGROUND)))
        .addMethod(
            getRemoveProductImageBackgroundMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.productstudio.v1alpha
                        .RemoveProductImageBackgroundRequest,
                    com.google.shopping.merchant.productstudio.v1alpha
                        .RemoveProductImageBackgroundResponse>(
                    service, METHODID_REMOVE_PRODUCT_IMAGE_BACKGROUND)))
        .addMethod(
            getUpscaleProductImageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageRequest,
                    com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageResponse>(
                    service, METHODID_UPSCALE_PRODUCT_IMAGE)))
        .build();
  }

  private abstract static class ImageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ImageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.productstudio.v1alpha.ImageProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ImageService");
    }
  }

  private static final class ImageServiceFileDescriptorSupplier
      extends ImageServiceBaseDescriptorSupplier {
    ImageServiceFileDescriptorSupplier() {}
  }

  private static final class ImageServiceMethodDescriptorSupplier
      extends ImageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ImageServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ImageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ImageServiceFileDescriptorSupplier())
                      .addMethod(getGenerateProductImageBackgroundMethod())
                      .addMethod(getRemoveProductImageBackgroundMethod())
                      .addMethod(getUpscaleProductImageMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
