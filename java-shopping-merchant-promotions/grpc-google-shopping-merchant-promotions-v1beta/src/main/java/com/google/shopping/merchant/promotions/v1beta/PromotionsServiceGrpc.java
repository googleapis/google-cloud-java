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
package com.google.shopping.merchant.promotions.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to manage promotions for products.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/promotions/v1beta/promotions.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PromotionsServiceGrpc {

  private PromotionsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.promotions.v1beta.PromotionsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.promotions.v1beta.InsertPromotionRequest,
          com.google.shopping.merchant.promotions.v1beta.Promotion>
      getInsertPromotionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InsertPromotion",
      requestType = com.google.shopping.merchant.promotions.v1beta.InsertPromotionRequest.class,
      responseType = com.google.shopping.merchant.promotions.v1beta.Promotion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.promotions.v1beta.InsertPromotionRequest,
          com.google.shopping.merchant.promotions.v1beta.Promotion>
      getInsertPromotionMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.promotions.v1beta.InsertPromotionRequest,
            com.google.shopping.merchant.promotions.v1beta.Promotion>
        getInsertPromotionMethod;
    if ((getInsertPromotionMethod = PromotionsServiceGrpc.getInsertPromotionMethod) == null) {
      synchronized (PromotionsServiceGrpc.class) {
        if ((getInsertPromotionMethod = PromotionsServiceGrpc.getInsertPromotionMethod) == null) {
          PromotionsServiceGrpc.getInsertPromotionMethod =
              getInsertPromotionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.promotions.v1beta.InsertPromotionRequest,
                          com.google.shopping.merchant.promotions.v1beta.Promotion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InsertPromotion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.promotions.v1beta.InsertPromotionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.promotions.v1beta.Promotion
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PromotionsServiceMethodDescriptorSupplier("InsertPromotion"))
                      .build();
        }
      }
    }
    return getInsertPromotionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.promotions.v1beta.GetPromotionRequest,
          com.google.shopping.merchant.promotions.v1beta.Promotion>
      getGetPromotionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPromotion",
      requestType = com.google.shopping.merchant.promotions.v1beta.GetPromotionRequest.class,
      responseType = com.google.shopping.merchant.promotions.v1beta.Promotion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.promotions.v1beta.GetPromotionRequest,
          com.google.shopping.merchant.promotions.v1beta.Promotion>
      getGetPromotionMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.promotions.v1beta.GetPromotionRequest,
            com.google.shopping.merchant.promotions.v1beta.Promotion>
        getGetPromotionMethod;
    if ((getGetPromotionMethod = PromotionsServiceGrpc.getGetPromotionMethod) == null) {
      synchronized (PromotionsServiceGrpc.class) {
        if ((getGetPromotionMethod = PromotionsServiceGrpc.getGetPromotionMethod) == null) {
          PromotionsServiceGrpc.getGetPromotionMethod =
              getGetPromotionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.promotions.v1beta.GetPromotionRequest,
                          com.google.shopping.merchant.promotions.v1beta.Promotion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPromotion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.promotions.v1beta.GetPromotionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.promotions.v1beta.Promotion
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PromotionsServiceMethodDescriptorSupplier("GetPromotion"))
                      .build();
        }
      }
    }
    return getGetPromotionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.promotions.v1beta.ListPromotionsRequest,
          com.google.shopping.merchant.promotions.v1beta.ListPromotionsResponse>
      getListPromotionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPromotions",
      requestType = com.google.shopping.merchant.promotions.v1beta.ListPromotionsRequest.class,
      responseType = com.google.shopping.merchant.promotions.v1beta.ListPromotionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.promotions.v1beta.ListPromotionsRequest,
          com.google.shopping.merchant.promotions.v1beta.ListPromotionsResponse>
      getListPromotionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.promotions.v1beta.ListPromotionsRequest,
            com.google.shopping.merchant.promotions.v1beta.ListPromotionsResponse>
        getListPromotionsMethod;
    if ((getListPromotionsMethod = PromotionsServiceGrpc.getListPromotionsMethod) == null) {
      synchronized (PromotionsServiceGrpc.class) {
        if ((getListPromotionsMethod = PromotionsServiceGrpc.getListPromotionsMethod) == null) {
          PromotionsServiceGrpc.getListPromotionsMethod =
              getListPromotionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.promotions.v1beta.ListPromotionsRequest,
                          com.google.shopping.merchant.promotions.v1beta.ListPromotionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPromotions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.promotions.v1beta.ListPromotionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.promotions.v1beta.ListPromotionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PromotionsServiceMethodDescriptorSupplier("ListPromotions"))
                      .build();
        }
      }
    }
    return getListPromotionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static PromotionsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PromotionsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PromotionsServiceStub>() {
          @java.lang.Override
          public PromotionsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PromotionsServiceStub(channel, callOptions);
          }
        };
    return PromotionsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PromotionsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PromotionsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PromotionsServiceBlockingStub>() {
          @java.lang.Override
          public PromotionsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PromotionsServiceBlockingStub(channel, callOptions);
          }
        };
    return PromotionsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static PromotionsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PromotionsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PromotionsServiceFutureStub>() {
          @java.lang.Override
          public PromotionsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PromotionsServiceFutureStub(channel, callOptions);
          }
        };
    return PromotionsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to manage promotions for products.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Inserts a promotion for your Merchant Center account. If the promotion
     * already exists, then it updates the promotion instead.
     * </pre>
     */
    default void insertPromotion(
        com.google.shopping.merchant.promotions.v1beta.InsertPromotionRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.promotions.v1beta.Promotion>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getInsertPromotionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the promotion from your Merchant Center account.
     * After inserting or updating a promotion input, it may take several
     * minutes before the updated promotion can be retrieved.
     * </pre>
     */
    default void getPromotion(
        com.google.shopping.merchant.promotions.v1beta.GetPromotionRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.promotions.v1beta.Promotion>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPromotionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the promotions in your Merchant Center account. The
     * response might contain fewer items than specified by `pageSize`. Rely on
     * `pageToken` to determine if there are more items to be requested.
     * After inserting or updating a promotion, it may take several minutes before
     * the updated processed promotion can be retrieved.
     * </pre>
     */
    default void listPromotions(
        com.google.shopping.merchant.promotions.v1beta.ListPromotionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.promotions.v1beta.ListPromotionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPromotionsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PromotionsService.
   *
   * <pre>
   * Service to manage promotions for products.
   * </pre>
   */
  public abstract static class PromotionsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return PromotionsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PromotionsService.
   *
   * <pre>
   * Service to manage promotions for products.
   * </pre>
   */
  public static final class PromotionsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PromotionsServiceStub> {
    private PromotionsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PromotionsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PromotionsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Inserts a promotion for your Merchant Center account. If the promotion
     * already exists, then it updates the promotion instead.
     * </pre>
     */
    public void insertPromotion(
        com.google.shopping.merchant.promotions.v1beta.InsertPromotionRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.promotions.v1beta.Promotion>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInsertPromotionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the promotion from your Merchant Center account.
     * After inserting or updating a promotion input, it may take several
     * minutes before the updated promotion can be retrieved.
     * </pre>
     */
    public void getPromotion(
        com.google.shopping.merchant.promotions.v1beta.GetPromotionRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.promotions.v1beta.Promotion>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPromotionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the promotions in your Merchant Center account. The
     * response might contain fewer items than specified by `pageSize`. Rely on
     * `pageToken` to determine if there are more items to be requested.
     * After inserting or updating a promotion, it may take several minutes before
     * the updated processed promotion can be retrieved.
     * </pre>
     */
    public void listPromotions(
        com.google.shopping.merchant.promotions.v1beta.ListPromotionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.promotions.v1beta.ListPromotionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPromotionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PromotionsService.
   *
   * <pre>
   * Service to manage promotions for products.
   * </pre>
   */
  public static final class PromotionsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PromotionsServiceBlockingStub> {
    private PromotionsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PromotionsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PromotionsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Inserts a promotion for your Merchant Center account. If the promotion
     * already exists, then it updates the promotion instead.
     * </pre>
     */
    public com.google.shopping.merchant.promotions.v1beta.Promotion insertPromotion(
        com.google.shopping.merchant.promotions.v1beta.InsertPromotionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInsertPromotionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the promotion from your Merchant Center account.
     * After inserting or updating a promotion input, it may take several
     * minutes before the updated promotion can be retrieved.
     * </pre>
     */
    public com.google.shopping.merchant.promotions.v1beta.Promotion getPromotion(
        com.google.shopping.merchant.promotions.v1beta.GetPromotionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPromotionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the promotions in your Merchant Center account. The
     * response might contain fewer items than specified by `pageSize`. Rely on
     * `pageToken` to determine if there are more items to be requested.
     * After inserting or updating a promotion, it may take several minutes before
     * the updated processed promotion can be retrieved.
     * </pre>
     */
    public com.google.shopping.merchant.promotions.v1beta.ListPromotionsResponse listPromotions(
        com.google.shopping.merchant.promotions.v1beta.ListPromotionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPromotionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PromotionsService.
   *
   * <pre>
   * Service to manage promotions for products.
   * </pre>
   */
  public static final class PromotionsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PromotionsServiceFutureStub> {
    private PromotionsServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PromotionsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PromotionsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Inserts a promotion for your Merchant Center account. If the promotion
     * already exists, then it updates the promotion instead.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.promotions.v1beta.Promotion>
        insertPromotion(
            com.google.shopping.merchant.promotions.v1beta.InsertPromotionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInsertPromotionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the promotion from your Merchant Center account.
     * After inserting or updating a promotion input, it may take several
     * minutes before the updated promotion can be retrieved.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.promotions.v1beta.Promotion>
        getPromotion(com.google.shopping.merchant.promotions.v1beta.GetPromotionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPromotionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the promotions in your Merchant Center account. The
     * response might contain fewer items than specified by `pageSize`. Rely on
     * `pageToken` to determine if there are more items to be requested.
     * After inserting or updating a promotion, it may take several minutes before
     * the updated processed promotion can be retrieved.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.promotions.v1beta.ListPromotionsResponse>
        listPromotions(
            com.google.shopping.merchant.promotions.v1beta.ListPromotionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPromotionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INSERT_PROMOTION = 0;
  private static final int METHODID_GET_PROMOTION = 1;
  private static final int METHODID_LIST_PROMOTIONS = 2;

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
        case METHODID_INSERT_PROMOTION:
          serviceImpl.insertPromotion(
              (com.google.shopping.merchant.promotions.v1beta.InsertPromotionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.promotions.v1beta.Promotion>)
                  responseObserver);
          break;
        case METHODID_GET_PROMOTION:
          serviceImpl.getPromotion(
              (com.google.shopping.merchant.promotions.v1beta.GetPromotionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.promotions.v1beta.Promotion>)
                  responseObserver);
          break;
        case METHODID_LIST_PROMOTIONS:
          serviceImpl.listPromotions(
              (com.google.shopping.merchant.promotions.v1beta.ListPromotionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.promotions.v1beta.ListPromotionsResponse>)
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
            getInsertPromotionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.promotions.v1beta.InsertPromotionRequest,
                    com.google.shopping.merchant.promotions.v1beta.Promotion>(
                    service, METHODID_INSERT_PROMOTION)))
        .addMethod(
            getGetPromotionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.promotions.v1beta.GetPromotionRequest,
                    com.google.shopping.merchant.promotions.v1beta.Promotion>(
                    service, METHODID_GET_PROMOTION)))
        .addMethod(
            getListPromotionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.promotions.v1beta.ListPromotionsRequest,
                    com.google.shopping.merchant.promotions.v1beta.ListPromotionsResponse>(
                    service, METHODID_LIST_PROMOTIONS)))
        .build();
  }

  private abstract static class PromotionsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PromotionsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.promotions.v1beta.PromotionsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PromotionsService");
    }
  }

  private static final class PromotionsServiceFileDescriptorSupplier
      extends PromotionsServiceBaseDescriptorSupplier {
    PromotionsServiceFileDescriptorSupplier() {}
  }

  private static final class PromotionsServiceMethodDescriptorSupplier
      extends PromotionsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PromotionsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PromotionsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new PromotionsServiceFileDescriptorSupplier())
                      .addMethod(getInsertPromotionMethod())
                      .addMethod(getGetPromotionMethod())
                      .addMethod(getListPromotionsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
