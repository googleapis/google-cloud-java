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
package com.google.shopping.merchant.reviews.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to manage merchant reviews.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/reviews/v1beta/merchantreviews.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MerchantReviewsServiceGrpc {

  private MerchantReviewsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.reviews.v1beta.MerchantReviewsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.reviews.v1beta.GetMerchantReviewRequest,
          com.google.shopping.merchant.reviews.v1beta.MerchantReview>
      getGetMerchantReviewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMerchantReview",
      requestType = com.google.shopping.merchant.reviews.v1beta.GetMerchantReviewRequest.class,
      responseType = com.google.shopping.merchant.reviews.v1beta.MerchantReview.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.reviews.v1beta.GetMerchantReviewRequest,
          com.google.shopping.merchant.reviews.v1beta.MerchantReview>
      getGetMerchantReviewMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.reviews.v1beta.GetMerchantReviewRequest,
            com.google.shopping.merchant.reviews.v1beta.MerchantReview>
        getGetMerchantReviewMethod;
    if ((getGetMerchantReviewMethod = MerchantReviewsServiceGrpc.getGetMerchantReviewMethod)
        == null) {
      synchronized (MerchantReviewsServiceGrpc.class) {
        if ((getGetMerchantReviewMethod = MerchantReviewsServiceGrpc.getGetMerchantReviewMethod)
            == null) {
          MerchantReviewsServiceGrpc.getGetMerchantReviewMethod =
              getGetMerchantReviewMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.reviews.v1beta.GetMerchantReviewRequest,
                          com.google.shopping.merchant.reviews.v1beta.MerchantReview>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMerchantReview"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.reviews.v1beta.GetMerchantReviewRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.reviews.v1beta.MerchantReview
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MerchantReviewsServiceMethodDescriptorSupplier("GetMerchantReview"))
                      .build();
        }
      }
    }
    return getGetMerchantReviewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsRequest,
          com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsResponse>
      getListMerchantReviewsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMerchantReviews",
      requestType = com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsRequest.class,
      responseType = com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsRequest,
          com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsResponse>
      getListMerchantReviewsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsRequest,
            com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsResponse>
        getListMerchantReviewsMethod;
    if ((getListMerchantReviewsMethod = MerchantReviewsServiceGrpc.getListMerchantReviewsMethod)
        == null) {
      synchronized (MerchantReviewsServiceGrpc.class) {
        if ((getListMerchantReviewsMethod = MerchantReviewsServiceGrpc.getListMerchantReviewsMethod)
            == null) {
          MerchantReviewsServiceGrpc.getListMerchantReviewsMethod =
              getListMerchantReviewsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsRequest,
                          com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListMerchantReviews"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.reviews.v1beta
                                  .ListMerchantReviewsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MerchantReviewsServiceMethodDescriptorSupplier("ListMerchantReviews"))
                      .build();
        }
      }
    }
    return getListMerchantReviewsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.reviews.v1beta.InsertMerchantReviewRequest,
          com.google.shopping.merchant.reviews.v1beta.MerchantReview>
      getInsertMerchantReviewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InsertMerchantReview",
      requestType = com.google.shopping.merchant.reviews.v1beta.InsertMerchantReviewRequest.class,
      responseType = com.google.shopping.merchant.reviews.v1beta.MerchantReview.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.reviews.v1beta.InsertMerchantReviewRequest,
          com.google.shopping.merchant.reviews.v1beta.MerchantReview>
      getInsertMerchantReviewMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.reviews.v1beta.InsertMerchantReviewRequest,
            com.google.shopping.merchant.reviews.v1beta.MerchantReview>
        getInsertMerchantReviewMethod;
    if ((getInsertMerchantReviewMethod = MerchantReviewsServiceGrpc.getInsertMerchantReviewMethod)
        == null) {
      synchronized (MerchantReviewsServiceGrpc.class) {
        if ((getInsertMerchantReviewMethod =
                MerchantReviewsServiceGrpc.getInsertMerchantReviewMethod)
            == null) {
          MerchantReviewsServiceGrpc.getInsertMerchantReviewMethod =
              getInsertMerchantReviewMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.reviews.v1beta.InsertMerchantReviewRequest,
                          com.google.shopping.merchant.reviews.v1beta.MerchantReview>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "InsertMerchantReview"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.reviews.v1beta
                                  .InsertMerchantReviewRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.reviews.v1beta.MerchantReview
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MerchantReviewsServiceMethodDescriptorSupplier(
                              "InsertMerchantReview"))
                      .build();
        }
      }
    }
    return getInsertMerchantReviewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.reviews.v1beta.DeleteMerchantReviewRequest,
          com.google.protobuf.Empty>
      getDeleteMerchantReviewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMerchantReview",
      requestType = com.google.shopping.merchant.reviews.v1beta.DeleteMerchantReviewRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.reviews.v1beta.DeleteMerchantReviewRequest,
          com.google.protobuf.Empty>
      getDeleteMerchantReviewMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.reviews.v1beta.DeleteMerchantReviewRequest,
            com.google.protobuf.Empty>
        getDeleteMerchantReviewMethod;
    if ((getDeleteMerchantReviewMethod = MerchantReviewsServiceGrpc.getDeleteMerchantReviewMethod)
        == null) {
      synchronized (MerchantReviewsServiceGrpc.class) {
        if ((getDeleteMerchantReviewMethod =
                MerchantReviewsServiceGrpc.getDeleteMerchantReviewMethod)
            == null) {
          MerchantReviewsServiceGrpc.getDeleteMerchantReviewMethod =
              getDeleteMerchantReviewMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.reviews.v1beta.DeleteMerchantReviewRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteMerchantReview"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.reviews.v1beta
                                  .DeleteMerchantReviewRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MerchantReviewsServiceMethodDescriptorSupplier(
                              "DeleteMerchantReview"))
                      .build();
        }
      }
    }
    return getDeleteMerchantReviewMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MerchantReviewsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MerchantReviewsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MerchantReviewsServiceStub>() {
          @java.lang.Override
          public MerchantReviewsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MerchantReviewsServiceStub(channel, callOptions);
          }
        };
    return MerchantReviewsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MerchantReviewsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MerchantReviewsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MerchantReviewsServiceBlockingStub>() {
          @java.lang.Override
          public MerchantReviewsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MerchantReviewsServiceBlockingStub(channel, callOptions);
          }
        };
    return MerchantReviewsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MerchantReviewsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MerchantReviewsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MerchantReviewsServiceFutureStub>() {
          @java.lang.Override
          public MerchantReviewsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MerchantReviewsServiceFutureStub(channel, callOptions);
          }
        };
    return MerchantReviewsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to manage merchant reviews.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets a merchant review.
     * </pre>
     */
    default void getMerchantReview(
        com.google.shopping.merchant.reviews.v1beta.GetMerchantReviewRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.reviews.v1beta.MerchantReview>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMerchantReviewMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists merchant reviews.
     * </pre>
     */
    default void listMerchantReviews(
        com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMerchantReviewsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Inserts a review for your Merchant Center account. If the review
     * already exists, then the review is replaced with the new instance.
     * </pre>
     */
    default void insertMerchantReview(
        com.google.shopping.merchant.reviews.v1beta.InsertMerchantReviewRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.reviews.v1beta.MerchantReview>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getInsertMerchantReviewMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes merchant review.
     * </pre>
     */
    default void deleteMerchantReview(
        com.google.shopping.merchant.reviews.v1beta.DeleteMerchantReviewRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMerchantReviewMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MerchantReviewsService.
   *
   * <pre>
   * Service to manage merchant reviews.
   * </pre>
   */
  public abstract static class MerchantReviewsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return MerchantReviewsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MerchantReviewsService.
   *
   * <pre>
   * Service to manage merchant reviews.
   * </pre>
   */
  public static final class MerchantReviewsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MerchantReviewsServiceStub> {
    private MerchantReviewsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MerchantReviewsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MerchantReviewsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a merchant review.
     * </pre>
     */
    public void getMerchantReview(
        com.google.shopping.merchant.reviews.v1beta.GetMerchantReviewRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.reviews.v1beta.MerchantReview>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMerchantReviewMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists merchant reviews.
     * </pre>
     */
    public void listMerchantReviews(
        com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMerchantReviewsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Inserts a review for your Merchant Center account. If the review
     * already exists, then the review is replaced with the new instance.
     * </pre>
     */
    public void insertMerchantReview(
        com.google.shopping.merchant.reviews.v1beta.InsertMerchantReviewRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.reviews.v1beta.MerchantReview>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInsertMerchantReviewMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes merchant review.
     * </pre>
     */
    public void deleteMerchantReview(
        com.google.shopping.merchant.reviews.v1beta.DeleteMerchantReviewRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMerchantReviewMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MerchantReviewsService.
   *
   * <pre>
   * Service to manage merchant reviews.
   * </pre>
   */
  public static final class MerchantReviewsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MerchantReviewsServiceBlockingStub> {
    private MerchantReviewsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MerchantReviewsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MerchantReviewsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a merchant review.
     * </pre>
     */
    public com.google.shopping.merchant.reviews.v1beta.MerchantReview getMerchantReview(
        com.google.shopping.merchant.reviews.v1beta.GetMerchantReviewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMerchantReviewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists merchant reviews.
     * </pre>
     */
    public com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsResponse
        listMerchantReviews(
            com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMerchantReviewsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Inserts a review for your Merchant Center account. If the review
     * already exists, then the review is replaced with the new instance.
     * </pre>
     */
    public com.google.shopping.merchant.reviews.v1beta.MerchantReview insertMerchantReview(
        com.google.shopping.merchant.reviews.v1beta.InsertMerchantReviewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInsertMerchantReviewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes merchant review.
     * </pre>
     */
    public com.google.protobuf.Empty deleteMerchantReview(
        com.google.shopping.merchant.reviews.v1beta.DeleteMerchantReviewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMerchantReviewMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * MerchantReviewsService.
   *
   * <pre>
   * Service to manage merchant reviews.
   * </pre>
   */
  public static final class MerchantReviewsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MerchantReviewsServiceFutureStub> {
    private MerchantReviewsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MerchantReviewsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MerchantReviewsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a merchant review.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.reviews.v1beta.MerchantReview>
        getMerchantReview(
            com.google.shopping.merchant.reviews.v1beta.GetMerchantReviewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMerchantReviewMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists merchant reviews.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsResponse>
        listMerchantReviews(
            com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMerchantReviewsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Inserts a review for your Merchant Center account. If the review
     * already exists, then the review is replaced with the new instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.reviews.v1beta.MerchantReview>
        insertMerchantReview(
            com.google.shopping.merchant.reviews.v1beta.InsertMerchantReviewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInsertMerchantReviewMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes merchant review.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteMerchantReview(
            com.google.shopping.merchant.reviews.v1beta.DeleteMerchantReviewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMerchantReviewMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MERCHANT_REVIEW = 0;
  private static final int METHODID_LIST_MERCHANT_REVIEWS = 1;
  private static final int METHODID_INSERT_MERCHANT_REVIEW = 2;
  private static final int METHODID_DELETE_MERCHANT_REVIEW = 3;

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
        case METHODID_GET_MERCHANT_REVIEW:
          serviceImpl.getMerchantReview(
              (com.google.shopping.merchant.reviews.v1beta.GetMerchantReviewRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.reviews.v1beta.MerchantReview>)
                  responseObserver);
          break;
        case METHODID_LIST_MERCHANT_REVIEWS:
          serviceImpl.listMerchantReviews(
              (com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsResponse>)
                  responseObserver);
          break;
        case METHODID_INSERT_MERCHANT_REVIEW:
          serviceImpl.insertMerchantReview(
              (com.google.shopping.merchant.reviews.v1beta.InsertMerchantReviewRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.reviews.v1beta.MerchantReview>)
                  responseObserver);
          break;
        case METHODID_DELETE_MERCHANT_REVIEW:
          serviceImpl.deleteMerchantReview(
              (com.google.shopping.merchant.reviews.v1beta.DeleteMerchantReviewRequest) request,
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
            getGetMerchantReviewMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.reviews.v1beta.GetMerchantReviewRequest,
                    com.google.shopping.merchant.reviews.v1beta.MerchantReview>(
                    service, METHODID_GET_MERCHANT_REVIEW)))
        .addMethod(
            getListMerchantReviewsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsRequest,
                    com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsResponse>(
                    service, METHODID_LIST_MERCHANT_REVIEWS)))
        .addMethod(
            getInsertMerchantReviewMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.reviews.v1beta.InsertMerchantReviewRequest,
                    com.google.shopping.merchant.reviews.v1beta.MerchantReview>(
                    service, METHODID_INSERT_MERCHANT_REVIEW)))
        .addMethod(
            getDeleteMerchantReviewMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.reviews.v1beta.DeleteMerchantReviewRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_MERCHANT_REVIEW)))
        .build();
  }

  private abstract static class MerchantReviewsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MerchantReviewsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.reviews.v1beta.MerchantReviewsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MerchantReviewsService");
    }
  }

  private static final class MerchantReviewsServiceFileDescriptorSupplier
      extends MerchantReviewsServiceBaseDescriptorSupplier {
    MerchantReviewsServiceFileDescriptorSupplier() {}
  }

  private static final class MerchantReviewsServiceMethodDescriptorSupplier
      extends MerchantReviewsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MerchantReviewsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MerchantReviewsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new MerchantReviewsServiceFileDescriptorSupplier())
                      .addMethod(getGetMerchantReviewMethod())
                      .addMethod(getListMerchantReviewsMethod())
                      .addMethod(getInsertMerchantReviewMethod())
                      .addMethod(getDeleteMerchantReviewMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
