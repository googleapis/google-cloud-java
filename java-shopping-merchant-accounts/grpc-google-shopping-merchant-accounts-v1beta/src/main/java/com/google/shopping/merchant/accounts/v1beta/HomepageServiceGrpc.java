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
package com.google.shopping.merchant.accounts.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to support an API for a store's homepage.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1beta/homepage.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HomepageServiceGrpc {

  private HomepageServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1beta.HomepageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetHomepageRequest,
          com.google.shopping.merchant.accounts.v1beta.Homepage>
      getGetHomepageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHomepage",
      requestType = com.google.shopping.merchant.accounts.v1beta.GetHomepageRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.Homepage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetHomepageRequest,
          com.google.shopping.merchant.accounts.v1beta.Homepage>
      getGetHomepageMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.GetHomepageRequest,
            com.google.shopping.merchant.accounts.v1beta.Homepage>
        getGetHomepageMethod;
    if ((getGetHomepageMethod = HomepageServiceGrpc.getGetHomepageMethod) == null) {
      synchronized (HomepageServiceGrpc.class) {
        if ((getGetHomepageMethod = HomepageServiceGrpc.getGetHomepageMethod) == null) {
          HomepageServiceGrpc.getGetHomepageMethod =
              getGetHomepageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.GetHomepageRequest,
                          com.google.shopping.merchant.accounts.v1beta.Homepage>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetHomepage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.GetHomepageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.Homepage
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HomepageServiceMethodDescriptorSupplier("GetHomepage"))
                      .build();
        }
      }
    }
    return getGetHomepageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateHomepageRequest,
          com.google.shopping.merchant.accounts.v1beta.Homepage>
      getUpdateHomepageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateHomepage",
      requestType = com.google.shopping.merchant.accounts.v1beta.UpdateHomepageRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.Homepage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateHomepageRequest,
          com.google.shopping.merchant.accounts.v1beta.Homepage>
      getUpdateHomepageMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.UpdateHomepageRequest,
            com.google.shopping.merchant.accounts.v1beta.Homepage>
        getUpdateHomepageMethod;
    if ((getUpdateHomepageMethod = HomepageServiceGrpc.getUpdateHomepageMethod) == null) {
      synchronized (HomepageServiceGrpc.class) {
        if ((getUpdateHomepageMethod = HomepageServiceGrpc.getUpdateHomepageMethod) == null) {
          HomepageServiceGrpc.getUpdateHomepageMethod =
              getUpdateHomepageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.UpdateHomepageRequest,
                          com.google.shopping.merchant.accounts.v1beta.Homepage>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateHomepage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.UpdateHomepageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.Homepage
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HomepageServiceMethodDescriptorSupplier("UpdateHomepage"))
                      .build();
        }
      }
    }
    return getUpdateHomepageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ClaimHomepageRequest,
          com.google.shopping.merchant.accounts.v1beta.Homepage>
      getClaimHomepageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ClaimHomepage",
      requestType = com.google.shopping.merchant.accounts.v1beta.ClaimHomepageRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.Homepage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ClaimHomepageRequest,
          com.google.shopping.merchant.accounts.v1beta.Homepage>
      getClaimHomepageMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.ClaimHomepageRequest,
            com.google.shopping.merchant.accounts.v1beta.Homepage>
        getClaimHomepageMethod;
    if ((getClaimHomepageMethod = HomepageServiceGrpc.getClaimHomepageMethod) == null) {
      synchronized (HomepageServiceGrpc.class) {
        if ((getClaimHomepageMethod = HomepageServiceGrpc.getClaimHomepageMethod) == null) {
          HomepageServiceGrpc.getClaimHomepageMethod =
              getClaimHomepageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.ClaimHomepageRequest,
                          com.google.shopping.merchant.accounts.v1beta.Homepage>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ClaimHomepage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.ClaimHomepageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.Homepage
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HomepageServiceMethodDescriptorSupplier("ClaimHomepage"))
                      .build();
        }
      }
    }
    return getClaimHomepageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UnclaimHomepageRequest,
          com.google.shopping.merchant.accounts.v1beta.Homepage>
      getUnclaimHomepageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnclaimHomepage",
      requestType = com.google.shopping.merchant.accounts.v1beta.UnclaimHomepageRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.Homepage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UnclaimHomepageRequest,
          com.google.shopping.merchant.accounts.v1beta.Homepage>
      getUnclaimHomepageMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.UnclaimHomepageRequest,
            com.google.shopping.merchant.accounts.v1beta.Homepage>
        getUnclaimHomepageMethod;
    if ((getUnclaimHomepageMethod = HomepageServiceGrpc.getUnclaimHomepageMethod) == null) {
      synchronized (HomepageServiceGrpc.class) {
        if ((getUnclaimHomepageMethod = HomepageServiceGrpc.getUnclaimHomepageMethod) == null) {
          HomepageServiceGrpc.getUnclaimHomepageMethod =
              getUnclaimHomepageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.UnclaimHomepageRequest,
                          com.google.shopping.merchant.accounts.v1beta.Homepage>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UnclaimHomepage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.UnclaimHomepageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.Homepage
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HomepageServiceMethodDescriptorSupplier("UnclaimHomepage"))
                      .build();
        }
      }
    }
    return getUnclaimHomepageMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static HomepageServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HomepageServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HomepageServiceStub>() {
          @java.lang.Override
          public HomepageServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HomepageServiceStub(channel, callOptions);
          }
        };
    return HomepageServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HomepageServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HomepageServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HomepageServiceBlockingStub>() {
          @java.lang.Override
          public HomepageServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HomepageServiceBlockingStub(channel, callOptions);
          }
        };
    return HomepageServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static HomepageServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HomepageServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HomepageServiceFutureStub>() {
          @java.lang.Override
          public HomepageServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HomepageServiceFutureStub(channel, callOptions);
          }
        };
    return HomepageServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to support an API for a store's homepage.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves a store's homepage.
     * </pre>
     */
    default void getHomepage(
        com.google.shopping.merchant.accounts.v1beta.GetHomepageRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Homepage>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetHomepageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a store's homepage. Executing this method requires admin access.
     * </pre>
     */
    default void updateHomepage(
        com.google.shopping.merchant.accounts.v1beta.UpdateHomepageRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Homepage>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateHomepageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Claims a store's homepage. Executing this method requires admin access.
     * If the homepage is already claimed, this will recheck the
     * verification (unless the merchant is exempted from claiming, which also
     * exempts from verification) and return a successful response. If ownership
     * can no longer be verified, it will return an error, but it won't clear the
     * claim. In case of failure, a canonical error message will be returned:
     *    * PERMISSION_DENIED: user doesn't have the necessary permissions on this
     *    MC account;
     *    * FAILED_PRECONDITION:
     *      - The account is not a Merchant Center account;
     *      - MC account doesn't have a homepage;
     *      - claiming failed (in this case the error message will contain more
     *      details).
     * </pre>
     */
    default void claimHomepage(
        com.google.shopping.merchant.accounts.v1beta.ClaimHomepageRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Homepage>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getClaimHomepageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Unclaims a store's homepage. Executing this method requires admin access.
     * </pre>
     */
    default void unclaimHomepage(
        com.google.shopping.merchant.accounts.v1beta.UnclaimHomepageRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Homepage>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUnclaimHomepageMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service HomepageService.
   *
   * <pre>
   * Service to support an API for a store's homepage.
   * </pre>
   */
  public abstract static class HomepageServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return HomepageServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service HomepageService.
   *
   * <pre>
   * Service to support an API for a store's homepage.
   * </pre>
   */
  public static final class HomepageServiceStub
      extends io.grpc.stub.AbstractAsyncStub<HomepageServiceStub> {
    private HomepageServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HomepageServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HomepageServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a store's homepage.
     * </pre>
     */
    public void getHomepage(
        com.google.shopping.merchant.accounts.v1beta.GetHomepageRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Homepage>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHomepageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a store's homepage. Executing this method requires admin access.
     * </pre>
     */
    public void updateHomepage(
        com.google.shopping.merchant.accounts.v1beta.UpdateHomepageRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Homepage>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateHomepageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Claims a store's homepage. Executing this method requires admin access.
     * If the homepage is already claimed, this will recheck the
     * verification (unless the merchant is exempted from claiming, which also
     * exempts from verification) and return a successful response. If ownership
     * can no longer be verified, it will return an error, but it won't clear the
     * claim. In case of failure, a canonical error message will be returned:
     *    * PERMISSION_DENIED: user doesn't have the necessary permissions on this
     *    MC account;
     *    * FAILED_PRECONDITION:
     *      - The account is not a Merchant Center account;
     *      - MC account doesn't have a homepage;
     *      - claiming failed (in this case the error message will contain more
     *      details).
     * </pre>
     */
    public void claimHomepage(
        com.google.shopping.merchant.accounts.v1beta.ClaimHomepageRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Homepage>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getClaimHomepageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Unclaims a store's homepage. Executing this method requires admin access.
     * </pre>
     */
    public void unclaimHomepage(
        com.google.shopping.merchant.accounts.v1beta.UnclaimHomepageRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Homepage>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnclaimHomepageMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service HomepageService.
   *
   * <pre>
   * Service to support an API for a store's homepage.
   * </pre>
   */
  public static final class HomepageServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<HomepageServiceBlockingStub> {
    private HomepageServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HomepageServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HomepageServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a store's homepage.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.Homepage getHomepage(
        com.google.shopping.merchant.accounts.v1beta.GetHomepageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHomepageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a store's homepage. Executing this method requires admin access.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.Homepage updateHomepage(
        com.google.shopping.merchant.accounts.v1beta.UpdateHomepageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateHomepageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Claims a store's homepage. Executing this method requires admin access.
     * If the homepage is already claimed, this will recheck the
     * verification (unless the merchant is exempted from claiming, which also
     * exempts from verification) and return a successful response. If ownership
     * can no longer be verified, it will return an error, but it won't clear the
     * claim. In case of failure, a canonical error message will be returned:
     *    * PERMISSION_DENIED: user doesn't have the necessary permissions on this
     *    MC account;
     *    * FAILED_PRECONDITION:
     *      - The account is not a Merchant Center account;
     *      - MC account doesn't have a homepage;
     *      - claiming failed (in this case the error message will contain more
     *      details).
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.Homepage claimHomepage(
        com.google.shopping.merchant.accounts.v1beta.ClaimHomepageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getClaimHomepageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Unclaims a store's homepage. Executing this method requires admin access.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.Homepage unclaimHomepage(
        com.google.shopping.merchant.accounts.v1beta.UnclaimHomepageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnclaimHomepageMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service HomepageService.
   *
   * <pre>
   * Service to support an API for a store's homepage.
   * </pre>
   */
  public static final class HomepageServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<HomepageServiceFutureStub> {
    private HomepageServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HomepageServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HomepageServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a store's homepage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.Homepage>
        getHomepage(com.google.shopping.merchant.accounts.v1beta.GetHomepageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHomepageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a store's homepage. Executing this method requires admin access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.Homepage>
        updateHomepage(com.google.shopping.merchant.accounts.v1beta.UpdateHomepageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateHomepageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Claims a store's homepage. Executing this method requires admin access.
     * If the homepage is already claimed, this will recheck the
     * verification (unless the merchant is exempted from claiming, which also
     * exempts from verification) and return a successful response. If ownership
     * can no longer be verified, it will return an error, but it won't clear the
     * claim. In case of failure, a canonical error message will be returned:
     *    * PERMISSION_DENIED: user doesn't have the necessary permissions on this
     *    MC account;
     *    * FAILED_PRECONDITION:
     *      - The account is not a Merchant Center account;
     *      - MC account doesn't have a homepage;
     *      - claiming failed (in this case the error message will contain more
     *      details).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.Homepage>
        claimHomepage(com.google.shopping.merchant.accounts.v1beta.ClaimHomepageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getClaimHomepageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Unclaims a store's homepage. Executing this method requires admin access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.Homepage>
        unclaimHomepage(
            com.google.shopping.merchant.accounts.v1beta.UnclaimHomepageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnclaimHomepageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_HOMEPAGE = 0;
  private static final int METHODID_UPDATE_HOMEPAGE = 1;
  private static final int METHODID_CLAIM_HOMEPAGE = 2;
  private static final int METHODID_UNCLAIM_HOMEPAGE = 3;

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
        case METHODID_GET_HOMEPAGE:
          serviceImpl.getHomepage(
              (com.google.shopping.merchant.accounts.v1beta.GetHomepageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Homepage>)
                  responseObserver);
          break;
        case METHODID_UPDATE_HOMEPAGE:
          serviceImpl.updateHomepage(
              (com.google.shopping.merchant.accounts.v1beta.UpdateHomepageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Homepage>)
                  responseObserver);
          break;
        case METHODID_CLAIM_HOMEPAGE:
          serviceImpl.claimHomepage(
              (com.google.shopping.merchant.accounts.v1beta.ClaimHomepageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Homepage>)
                  responseObserver);
          break;
        case METHODID_UNCLAIM_HOMEPAGE:
          serviceImpl.unclaimHomepage(
              (com.google.shopping.merchant.accounts.v1beta.UnclaimHomepageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Homepage>)
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
            getGetHomepageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.GetHomepageRequest,
                    com.google.shopping.merchant.accounts.v1beta.Homepage>(
                    service, METHODID_GET_HOMEPAGE)))
        .addMethod(
            getUpdateHomepageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.UpdateHomepageRequest,
                    com.google.shopping.merchant.accounts.v1beta.Homepage>(
                    service, METHODID_UPDATE_HOMEPAGE)))
        .addMethod(
            getClaimHomepageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.ClaimHomepageRequest,
                    com.google.shopping.merchant.accounts.v1beta.Homepage>(
                    service, METHODID_CLAIM_HOMEPAGE)))
        .addMethod(
            getUnclaimHomepageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.UnclaimHomepageRequest,
                    com.google.shopping.merchant.accounts.v1beta.Homepage>(
                    service, METHODID_UNCLAIM_HOMEPAGE)))
        .build();
  }

  private abstract static class HomepageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HomepageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1beta.HomepageProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HomepageService");
    }
  }

  private static final class HomepageServiceFileDescriptorSupplier
      extends HomepageServiceBaseDescriptorSupplier {
    HomepageServiceFileDescriptorSupplier() {}
  }

  private static final class HomepageServiceMethodDescriptorSupplier
      extends HomepageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    HomepageServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (HomepageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new HomepageServiceFileDescriptorSupplier())
                      .addMethod(getGetHomepageMethod())
                      .addMethod(getUpdateHomepageMethod())
                      .addMethod(getClaimHomepageMethod())
                      .addMethod(getUnclaimHomepageMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
