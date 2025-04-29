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
package com.google.shopping.merchant.reviews.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to manage product reviews.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/reviews/v1beta/productreviews.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProductReviewsServiceGrpc {

  private ProductReviewsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.reviews.v1beta.ProductReviewsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.reviews.v1beta.GetProductReviewRequest,
          com.google.shopping.merchant.reviews.v1beta.ProductReview>
      getGetProductReviewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProductReview",
      requestType = com.google.shopping.merchant.reviews.v1beta.GetProductReviewRequest.class,
      responseType = com.google.shopping.merchant.reviews.v1beta.ProductReview.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.reviews.v1beta.GetProductReviewRequest,
          com.google.shopping.merchant.reviews.v1beta.ProductReview>
      getGetProductReviewMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.reviews.v1beta.GetProductReviewRequest,
            com.google.shopping.merchant.reviews.v1beta.ProductReview>
        getGetProductReviewMethod;
    if ((getGetProductReviewMethod = ProductReviewsServiceGrpc.getGetProductReviewMethod) == null) {
      synchronized (ProductReviewsServiceGrpc.class) {
        if ((getGetProductReviewMethod = ProductReviewsServiceGrpc.getGetProductReviewMethod)
            == null) {
          ProductReviewsServiceGrpc.getGetProductReviewMethod =
              getGetProductReviewMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.reviews.v1beta.GetProductReviewRequest,
                          com.google.shopping.merchant.reviews.v1beta.ProductReview>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProductReview"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.reviews.v1beta.GetProductReviewRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.reviews.v1beta.ProductReview
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductReviewsServiceMethodDescriptorSupplier("GetProductReview"))
                      .build();
        }
      }
    }
    return getGetProductReviewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.reviews.v1beta.ListProductReviewsRequest,
          com.google.shopping.merchant.reviews.v1beta.ListProductReviewsResponse>
      getListProductReviewsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProductReviews",
      requestType = com.google.shopping.merchant.reviews.v1beta.ListProductReviewsRequest.class,
      responseType = com.google.shopping.merchant.reviews.v1beta.ListProductReviewsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.reviews.v1beta.ListProductReviewsRequest,
          com.google.shopping.merchant.reviews.v1beta.ListProductReviewsResponse>
      getListProductReviewsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.reviews.v1beta.ListProductReviewsRequest,
            com.google.shopping.merchant.reviews.v1beta.ListProductReviewsResponse>
        getListProductReviewsMethod;
    if ((getListProductReviewsMethod = ProductReviewsServiceGrpc.getListProductReviewsMethod)
        == null) {
      synchronized (ProductReviewsServiceGrpc.class) {
        if ((getListProductReviewsMethod = ProductReviewsServiceGrpc.getListProductReviewsMethod)
            == null) {
          ProductReviewsServiceGrpc.getListProductReviewsMethod =
              getListProductReviewsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.reviews.v1beta.ListProductReviewsRequest,
                          com.google.shopping.merchant.reviews.v1beta.ListProductReviewsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProductReviews"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.reviews.v1beta.ListProductReviewsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.reviews.v1beta.ListProductReviewsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductReviewsServiceMethodDescriptorSupplier("ListProductReviews"))
                      .build();
        }
      }
    }
    return getListProductReviewsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.reviews.v1beta.InsertProductReviewRequest,
          com.google.shopping.merchant.reviews.v1beta.ProductReview>
      getInsertProductReviewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InsertProductReview",
      requestType = com.google.shopping.merchant.reviews.v1beta.InsertProductReviewRequest.class,
      responseType = com.google.shopping.merchant.reviews.v1beta.ProductReview.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.reviews.v1beta.InsertProductReviewRequest,
          com.google.shopping.merchant.reviews.v1beta.ProductReview>
      getInsertProductReviewMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.reviews.v1beta.InsertProductReviewRequest,
            com.google.shopping.merchant.reviews.v1beta.ProductReview>
        getInsertProductReviewMethod;
    if ((getInsertProductReviewMethod = ProductReviewsServiceGrpc.getInsertProductReviewMethod)
        == null) {
      synchronized (ProductReviewsServiceGrpc.class) {
        if ((getInsertProductReviewMethod = ProductReviewsServiceGrpc.getInsertProductReviewMethod)
            == null) {
          ProductReviewsServiceGrpc.getInsertProductReviewMethod =
              getInsertProductReviewMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.reviews.v1beta.InsertProductReviewRequest,
                          com.google.shopping.merchant.reviews.v1beta.ProductReview>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "InsertProductReview"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.reviews.v1beta.InsertProductReviewRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.reviews.v1beta.ProductReview
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductReviewsServiceMethodDescriptorSupplier("InsertProductReview"))
                      .build();
        }
      }
    }
    return getInsertProductReviewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.reviews.v1beta.DeleteProductReviewRequest,
          com.google.protobuf.Empty>
      getDeleteProductReviewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteProductReview",
      requestType = com.google.shopping.merchant.reviews.v1beta.DeleteProductReviewRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.reviews.v1beta.DeleteProductReviewRequest,
          com.google.protobuf.Empty>
      getDeleteProductReviewMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.reviews.v1beta.DeleteProductReviewRequest,
            com.google.protobuf.Empty>
        getDeleteProductReviewMethod;
    if ((getDeleteProductReviewMethod = ProductReviewsServiceGrpc.getDeleteProductReviewMethod)
        == null) {
      synchronized (ProductReviewsServiceGrpc.class) {
        if ((getDeleteProductReviewMethod = ProductReviewsServiceGrpc.getDeleteProductReviewMethod)
            == null) {
          ProductReviewsServiceGrpc.getDeleteProductReviewMethod =
              getDeleteProductReviewMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.reviews.v1beta.DeleteProductReviewRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteProductReview"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.reviews.v1beta.DeleteProductReviewRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductReviewsServiceMethodDescriptorSupplier("DeleteProductReview"))
                      .build();
        }
      }
    }
    return getDeleteProductReviewMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ProductReviewsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductReviewsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProductReviewsServiceStub>() {
          @java.lang.Override
          public ProductReviewsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProductReviewsServiceStub(channel, callOptions);
          }
        };
    return ProductReviewsServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ProductReviewsServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductReviewsServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProductReviewsServiceBlockingV2Stub>() {
          @java.lang.Override
          public ProductReviewsServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProductReviewsServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return ProductReviewsServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductReviewsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductReviewsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProductReviewsServiceBlockingStub>() {
          @java.lang.Override
          public ProductReviewsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProductReviewsServiceBlockingStub(channel, callOptions);
          }
        };
    return ProductReviewsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ProductReviewsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductReviewsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProductReviewsServiceFutureStub>() {
          @java.lang.Override
          public ProductReviewsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProductReviewsServiceFutureStub(channel, callOptions);
          }
        };
    return ProductReviewsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to manage product reviews.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets a product review.
     * </pre>
     */
    default void getProductReview(
        com.google.shopping.merchant.reviews.v1beta.GetProductReviewRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.reviews.v1beta.ProductReview>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetProductReviewMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists product reviews.
     * </pre>
     */
    default void listProductReviews(
        com.google.shopping.merchant.reviews.v1beta.ListProductReviewsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.reviews.v1beta.ListProductReviewsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListProductReviewsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Inserts a product review.
     * </pre>
     */
    default void insertProductReview(
        com.google.shopping.merchant.reviews.v1beta.InsertProductReviewRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.reviews.v1beta.ProductReview>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getInsertProductReviewMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a product review.
     * </pre>
     */
    default void deleteProductReview(
        com.google.shopping.merchant.reviews.v1beta.DeleteProductReviewRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteProductReviewMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ProductReviewsService.
   *
   * <pre>
   * Service to manage product reviews.
   * </pre>
   */
  public abstract static class ProductReviewsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ProductReviewsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ProductReviewsService.
   *
   * <pre>
   * Service to manage product reviews.
   * </pre>
   */
  public static final class ProductReviewsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ProductReviewsServiceStub> {
    private ProductReviewsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductReviewsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductReviewsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a product review.
     * </pre>
     */
    public void getProductReview(
        com.google.shopping.merchant.reviews.v1beta.GetProductReviewRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.reviews.v1beta.ProductReview>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProductReviewMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists product reviews.
     * </pre>
     */
    public void listProductReviews(
        com.google.shopping.merchant.reviews.v1beta.ListProductReviewsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.reviews.v1beta.ListProductReviewsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProductReviewsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Inserts a product review.
     * </pre>
     */
    public void insertProductReview(
        com.google.shopping.merchant.reviews.v1beta.InsertProductReviewRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.reviews.v1beta.ProductReview>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInsertProductReviewMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a product review.
     * </pre>
     */
    public void deleteProductReview(
        com.google.shopping.merchant.reviews.v1beta.DeleteProductReviewRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteProductReviewMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ProductReviewsService.
   *
   * <pre>
   * Service to manage product reviews.
   * </pre>
   */
  public static final class ProductReviewsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ProductReviewsServiceBlockingV2Stub> {
    private ProductReviewsServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductReviewsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductReviewsServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a product review.
     * </pre>
     */
    public com.google.shopping.merchant.reviews.v1beta.ProductReview getProductReview(
        com.google.shopping.merchant.reviews.v1beta.GetProductReviewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProductReviewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists product reviews.
     * </pre>
     */
    public com.google.shopping.merchant.reviews.v1beta.ListProductReviewsResponse
        listProductReviews(
            com.google.shopping.merchant.reviews.v1beta.ListProductReviewsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProductReviewsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Inserts a product review.
     * </pre>
     */
    public com.google.shopping.merchant.reviews.v1beta.ProductReview insertProductReview(
        com.google.shopping.merchant.reviews.v1beta.InsertProductReviewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInsertProductReviewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a product review.
     * </pre>
     */
    public com.google.protobuf.Empty deleteProductReview(
        com.google.shopping.merchant.reviews.v1beta.DeleteProductReviewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteProductReviewMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ProductReviewsService.
   *
   * <pre>
   * Service to manage product reviews.
   * </pre>
   */
  public static final class ProductReviewsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProductReviewsServiceBlockingStub> {
    private ProductReviewsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductReviewsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductReviewsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a product review.
     * </pre>
     */
    public com.google.shopping.merchant.reviews.v1beta.ProductReview getProductReview(
        com.google.shopping.merchant.reviews.v1beta.GetProductReviewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProductReviewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists product reviews.
     * </pre>
     */
    public com.google.shopping.merchant.reviews.v1beta.ListProductReviewsResponse
        listProductReviews(
            com.google.shopping.merchant.reviews.v1beta.ListProductReviewsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProductReviewsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Inserts a product review.
     * </pre>
     */
    public com.google.shopping.merchant.reviews.v1beta.ProductReview insertProductReview(
        com.google.shopping.merchant.reviews.v1beta.InsertProductReviewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInsertProductReviewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a product review.
     * </pre>
     */
    public com.google.protobuf.Empty deleteProductReview(
        com.google.shopping.merchant.reviews.v1beta.DeleteProductReviewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteProductReviewMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * ProductReviewsService.
   *
   * <pre>
   * Service to manage product reviews.
   * </pre>
   */
  public static final class ProductReviewsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProductReviewsServiceFutureStub> {
    private ProductReviewsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductReviewsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductReviewsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a product review.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.reviews.v1beta.ProductReview>
        getProductReview(
            com.google.shopping.merchant.reviews.v1beta.GetProductReviewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProductReviewMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists product reviews.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.reviews.v1beta.ListProductReviewsResponse>
        listProductReviews(
            com.google.shopping.merchant.reviews.v1beta.ListProductReviewsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProductReviewsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Inserts a product review.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.reviews.v1beta.ProductReview>
        insertProductReview(
            com.google.shopping.merchant.reviews.v1beta.InsertProductReviewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInsertProductReviewMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a product review.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteProductReview(
            com.google.shopping.merchant.reviews.v1beta.DeleteProductReviewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteProductReviewMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PRODUCT_REVIEW = 0;
  private static final int METHODID_LIST_PRODUCT_REVIEWS = 1;
  private static final int METHODID_INSERT_PRODUCT_REVIEW = 2;
  private static final int METHODID_DELETE_PRODUCT_REVIEW = 3;

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
        case METHODID_GET_PRODUCT_REVIEW:
          serviceImpl.getProductReview(
              (com.google.shopping.merchant.reviews.v1beta.GetProductReviewRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.reviews.v1beta.ProductReview>)
                  responseObserver);
          break;
        case METHODID_LIST_PRODUCT_REVIEWS:
          serviceImpl.listProductReviews(
              (com.google.shopping.merchant.reviews.v1beta.ListProductReviewsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.reviews.v1beta.ListProductReviewsResponse>)
                  responseObserver);
          break;
        case METHODID_INSERT_PRODUCT_REVIEW:
          serviceImpl.insertProductReview(
              (com.google.shopping.merchant.reviews.v1beta.InsertProductReviewRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.reviews.v1beta.ProductReview>)
                  responseObserver);
          break;
        case METHODID_DELETE_PRODUCT_REVIEW:
          serviceImpl.deleteProductReview(
              (com.google.shopping.merchant.reviews.v1beta.DeleteProductReviewRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
            getGetProductReviewMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.reviews.v1beta.GetProductReviewRequest,
                    com.google.shopping.merchant.reviews.v1beta.ProductReview>(
                    service, METHODID_GET_PRODUCT_REVIEW)))
        .addMethod(
            getListProductReviewsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.reviews.v1beta.ListProductReviewsRequest,
                    com.google.shopping.merchant.reviews.v1beta.ListProductReviewsResponse>(
                    service, METHODID_LIST_PRODUCT_REVIEWS)))
        .addMethod(
            getInsertProductReviewMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.reviews.v1beta.InsertProductReviewRequest,
                    com.google.shopping.merchant.reviews.v1beta.ProductReview>(
                    service, METHODID_INSERT_PRODUCT_REVIEW)))
        .addMethod(
            getDeleteProductReviewMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.reviews.v1beta.DeleteProductReviewRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_PRODUCT_REVIEW)))
        .build();
  }

  private abstract static class ProductReviewsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductReviewsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.reviews.v1beta.ProductReviewsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductReviewsService");
    }
  }

  private static final class ProductReviewsServiceFileDescriptorSupplier
      extends ProductReviewsServiceBaseDescriptorSupplier {
    ProductReviewsServiceFileDescriptorSupplier() {}
  }

  private static final class ProductReviewsServiceMethodDescriptorSupplier
      extends ProductReviewsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ProductReviewsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ProductReviewsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ProductReviewsServiceFileDescriptorSupplier())
                      .addMethod(getGetProductReviewMethod())
                      .addMethod(getListProductReviewsMethod())
                      .addMethod(getInsertProductReviewMethod())
                      .addMethod(getDeleteProductReviewMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
