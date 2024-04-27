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
package com.google.shopping.merchant.lfp.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for a [LFP
 * partner](https://support.google.com/merchants/answer/7676652) to submit local
 * stores for a merchant.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/lfp/v1beta/lfpstore.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LfpStoreServiceGrpc {

  private LfpStoreServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.lfp.v1beta.LfpStoreService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.lfp.v1beta.GetLfpStoreRequest,
          com.google.shopping.merchant.lfp.v1beta.LfpStore>
      getGetLfpStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLfpStore",
      requestType = com.google.shopping.merchant.lfp.v1beta.GetLfpStoreRequest.class,
      responseType = com.google.shopping.merchant.lfp.v1beta.LfpStore.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.lfp.v1beta.GetLfpStoreRequest,
          com.google.shopping.merchant.lfp.v1beta.LfpStore>
      getGetLfpStoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.lfp.v1beta.GetLfpStoreRequest,
            com.google.shopping.merchant.lfp.v1beta.LfpStore>
        getGetLfpStoreMethod;
    if ((getGetLfpStoreMethod = LfpStoreServiceGrpc.getGetLfpStoreMethod) == null) {
      synchronized (LfpStoreServiceGrpc.class) {
        if ((getGetLfpStoreMethod = LfpStoreServiceGrpc.getGetLfpStoreMethod) == null) {
          LfpStoreServiceGrpc.getGetLfpStoreMethod =
              getGetLfpStoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.lfp.v1beta.GetLfpStoreRequest,
                          com.google.shopping.merchant.lfp.v1beta.LfpStore>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLfpStore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.lfp.v1beta.GetLfpStoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.lfp.v1beta.LfpStore
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LfpStoreServiceMethodDescriptorSupplier("GetLfpStore"))
                      .build();
        }
      }
    }
    return getGetLfpStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.lfp.v1beta.InsertLfpStoreRequest,
          com.google.shopping.merchant.lfp.v1beta.LfpStore>
      getInsertLfpStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InsertLfpStore",
      requestType = com.google.shopping.merchant.lfp.v1beta.InsertLfpStoreRequest.class,
      responseType = com.google.shopping.merchant.lfp.v1beta.LfpStore.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.lfp.v1beta.InsertLfpStoreRequest,
          com.google.shopping.merchant.lfp.v1beta.LfpStore>
      getInsertLfpStoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.lfp.v1beta.InsertLfpStoreRequest,
            com.google.shopping.merchant.lfp.v1beta.LfpStore>
        getInsertLfpStoreMethod;
    if ((getInsertLfpStoreMethod = LfpStoreServiceGrpc.getInsertLfpStoreMethod) == null) {
      synchronized (LfpStoreServiceGrpc.class) {
        if ((getInsertLfpStoreMethod = LfpStoreServiceGrpc.getInsertLfpStoreMethod) == null) {
          LfpStoreServiceGrpc.getInsertLfpStoreMethod =
              getInsertLfpStoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.lfp.v1beta.InsertLfpStoreRequest,
                          com.google.shopping.merchant.lfp.v1beta.LfpStore>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InsertLfpStore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.lfp.v1beta.InsertLfpStoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.lfp.v1beta.LfpStore
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LfpStoreServiceMethodDescriptorSupplier("InsertLfpStore"))
                      .build();
        }
      }
    }
    return getInsertLfpStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.lfp.v1beta.DeleteLfpStoreRequest, com.google.protobuf.Empty>
      getDeleteLfpStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteLfpStore",
      requestType = com.google.shopping.merchant.lfp.v1beta.DeleteLfpStoreRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.lfp.v1beta.DeleteLfpStoreRequest, com.google.protobuf.Empty>
      getDeleteLfpStoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.lfp.v1beta.DeleteLfpStoreRequest,
            com.google.protobuf.Empty>
        getDeleteLfpStoreMethod;
    if ((getDeleteLfpStoreMethod = LfpStoreServiceGrpc.getDeleteLfpStoreMethod) == null) {
      synchronized (LfpStoreServiceGrpc.class) {
        if ((getDeleteLfpStoreMethod = LfpStoreServiceGrpc.getDeleteLfpStoreMethod) == null) {
          LfpStoreServiceGrpc.getDeleteLfpStoreMethod =
              getDeleteLfpStoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.lfp.v1beta.DeleteLfpStoreRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteLfpStore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.lfp.v1beta.DeleteLfpStoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LfpStoreServiceMethodDescriptorSupplier("DeleteLfpStore"))
                      .build();
        }
      }
    }
    return getDeleteLfpStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.lfp.v1beta.ListLfpStoresRequest,
          com.google.shopping.merchant.lfp.v1beta.ListLfpStoresResponse>
      getListLfpStoresMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLfpStores",
      requestType = com.google.shopping.merchant.lfp.v1beta.ListLfpStoresRequest.class,
      responseType = com.google.shopping.merchant.lfp.v1beta.ListLfpStoresResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.lfp.v1beta.ListLfpStoresRequest,
          com.google.shopping.merchant.lfp.v1beta.ListLfpStoresResponse>
      getListLfpStoresMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.lfp.v1beta.ListLfpStoresRequest,
            com.google.shopping.merchant.lfp.v1beta.ListLfpStoresResponse>
        getListLfpStoresMethod;
    if ((getListLfpStoresMethod = LfpStoreServiceGrpc.getListLfpStoresMethod) == null) {
      synchronized (LfpStoreServiceGrpc.class) {
        if ((getListLfpStoresMethod = LfpStoreServiceGrpc.getListLfpStoresMethod) == null) {
          LfpStoreServiceGrpc.getListLfpStoresMethod =
              getListLfpStoresMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.lfp.v1beta.ListLfpStoresRequest,
                          com.google.shopping.merchant.lfp.v1beta.ListLfpStoresResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListLfpStores"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.lfp.v1beta.ListLfpStoresRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.lfp.v1beta.ListLfpStoresResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LfpStoreServiceMethodDescriptorSupplier("ListLfpStores"))
                      .build();
        }
      }
    }
    return getListLfpStoresMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static LfpStoreServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LfpStoreServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LfpStoreServiceStub>() {
          @java.lang.Override
          public LfpStoreServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LfpStoreServiceStub(channel, callOptions);
          }
        };
    return LfpStoreServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LfpStoreServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LfpStoreServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LfpStoreServiceBlockingStub>() {
          @java.lang.Override
          public LfpStoreServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LfpStoreServiceBlockingStub(channel, callOptions);
          }
        };
    return LfpStoreServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static LfpStoreServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LfpStoreServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LfpStoreServiceFutureStub>() {
          @java.lang.Override
          public LfpStoreServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LfpStoreServiceFutureStub(channel, callOptions);
          }
        };
    return LfpStoreServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for a [LFP
   * partner](https://support.google.com/merchants/answer/7676652) to submit local
   * stores for a merchant.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves information about a store.
     * </pre>
     */
    default void getLfpStore(
        com.google.shopping.merchant.lfp.v1beta.GetLfpStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.lfp.v1beta.LfpStore>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetLfpStoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Inserts a store for the target merchant. If the store with the same store
     * code already exists, it will be replaced.
     * </pre>
     */
    default void insertLfpStore(
        com.google.shopping.merchant.lfp.v1beta.InsertLfpStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.lfp.v1beta.LfpStore>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getInsertLfpStoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a store for a target merchant.
     * </pre>
     */
    default void deleteLfpStore(
        com.google.shopping.merchant.lfp.v1beta.DeleteLfpStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteLfpStoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the stores of the target merchant, specified by the filter in
     * `ListLfpStoresRequest`.
     * </pre>
     */
    default void listLfpStores(
        com.google.shopping.merchant.lfp.v1beta.ListLfpStoresRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.lfp.v1beta.ListLfpStoresResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListLfpStoresMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LfpStoreService.
   *
   * <pre>
   * Service for a [LFP
   * partner](https://support.google.com/merchants/answer/7676652) to submit local
   * stores for a merchant.
   * </pre>
   */
  public abstract static class LfpStoreServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return LfpStoreServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LfpStoreService.
   *
   * <pre>
   * Service for a [LFP
   * partner](https://support.google.com/merchants/answer/7676652) to submit local
   * stores for a merchant.
   * </pre>
   */
  public static final class LfpStoreServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LfpStoreServiceStub> {
    private LfpStoreServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LfpStoreServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LfpStoreServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves information about a store.
     * </pre>
     */
    public void getLfpStore(
        com.google.shopping.merchant.lfp.v1beta.GetLfpStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.lfp.v1beta.LfpStore>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLfpStoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Inserts a store for the target merchant. If the store with the same store
     * code already exists, it will be replaced.
     * </pre>
     */
    public void insertLfpStore(
        com.google.shopping.merchant.lfp.v1beta.InsertLfpStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.lfp.v1beta.LfpStore>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInsertLfpStoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a store for a target merchant.
     * </pre>
     */
    public void deleteLfpStore(
        com.google.shopping.merchant.lfp.v1beta.DeleteLfpStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteLfpStoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the stores of the target merchant, specified by the filter in
     * `ListLfpStoresRequest`.
     * </pre>
     */
    public void listLfpStores(
        com.google.shopping.merchant.lfp.v1beta.ListLfpStoresRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.lfp.v1beta.ListLfpStoresResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLfpStoresMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LfpStoreService.
   *
   * <pre>
   * Service for a [LFP
   * partner](https://support.google.com/merchants/answer/7676652) to submit local
   * stores for a merchant.
   * </pre>
   */
  public static final class LfpStoreServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LfpStoreServiceBlockingStub> {
    private LfpStoreServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LfpStoreServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LfpStoreServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves information about a store.
     * </pre>
     */
    public com.google.shopping.merchant.lfp.v1beta.LfpStore getLfpStore(
        com.google.shopping.merchant.lfp.v1beta.GetLfpStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLfpStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Inserts a store for the target merchant. If the store with the same store
     * code already exists, it will be replaced.
     * </pre>
     */
    public com.google.shopping.merchant.lfp.v1beta.LfpStore insertLfpStore(
        com.google.shopping.merchant.lfp.v1beta.InsertLfpStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInsertLfpStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a store for a target merchant.
     * </pre>
     */
    public com.google.protobuf.Empty deleteLfpStore(
        com.google.shopping.merchant.lfp.v1beta.DeleteLfpStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteLfpStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the stores of the target merchant, specified by the filter in
     * `ListLfpStoresRequest`.
     * </pre>
     */
    public com.google.shopping.merchant.lfp.v1beta.ListLfpStoresResponse listLfpStores(
        com.google.shopping.merchant.lfp.v1beta.ListLfpStoresRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLfpStoresMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LfpStoreService.
   *
   * <pre>
   * Service for a [LFP
   * partner](https://support.google.com/merchants/answer/7676652) to submit local
   * stores for a merchant.
   * </pre>
   */
  public static final class LfpStoreServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LfpStoreServiceFutureStub> {
    private LfpStoreServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LfpStoreServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LfpStoreServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves information about a store.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.lfp.v1beta.LfpStore>
        getLfpStore(com.google.shopping.merchant.lfp.v1beta.GetLfpStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLfpStoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Inserts a store for the target merchant. If the store with the same store
     * code already exists, it will be replaced.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.lfp.v1beta.LfpStore>
        insertLfpStore(com.google.shopping.merchant.lfp.v1beta.InsertLfpStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInsertLfpStoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a store for a target merchant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteLfpStore(com.google.shopping.merchant.lfp.v1beta.DeleteLfpStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteLfpStoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the stores of the target merchant, specified by the filter in
     * `ListLfpStoresRequest`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.lfp.v1beta.ListLfpStoresResponse>
        listLfpStores(com.google.shopping.merchant.lfp.v1beta.ListLfpStoresRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLfpStoresMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_LFP_STORE = 0;
  private static final int METHODID_INSERT_LFP_STORE = 1;
  private static final int METHODID_DELETE_LFP_STORE = 2;
  private static final int METHODID_LIST_LFP_STORES = 3;

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
        case METHODID_GET_LFP_STORE:
          serviceImpl.getLfpStore(
              (com.google.shopping.merchant.lfp.v1beta.GetLfpStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.lfp.v1beta.LfpStore>)
                  responseObserver);
          break;
        case METHODID_INSERT_LFP_STORE:
          serviceImpl.insertLfpStore(
              (com.google.shopping.merchant.lfp.v1beta.InsertLfpStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.lfp.v1beta.LfpStore>)
                  responseObserver);
          break;
        case METHODID_DELETE_LFP_STORE:
          serviceImpl.deleteLfpStore(
              (com.google.shopping.merchant.lfp.v1beta.DeleteLfpStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_LFP_STORES:
          serviceImpl.listLfpStores(
              (com.google.shopping.merchant.lfp.v1beta.ListLfpStoresRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.lfp.v1beta.ListLfpStoresResponse>)
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
            getGetLfpStoreMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.lfp.v1beta.GetLfpStoreRequest,
                    com.google.shopping.merchant.lfp.v1beta.LfpStore>(
                    service, METHODID_GET_LFP_STORE)))
        .addMethod(
            getInsertLfpStoreMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.lfp.v1beta.InsertLfpStoreRequest,
                    com.google.shopping.merchant.lfp.v1beta.LfpStore>(
                    service, METHODID_INSERT_LFP_STORE)))
        .addMethod(
            getDeleteLfpStoreMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.lfp.v1beta.DeleteLfpStoreRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_LFP_STORE)))
        .addMethod(
            getListLfpStoresMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.lfp.v1beta.ListLfpStoresRequest,
                    com.google.shopping.merchant.lfp.v1beta.ListLfpStoresResponse>(
                    service, METHODID_LIST_LFP_STORES)))
        .build();
  }

  private abstract static class LfpStoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LfpStoreServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.lfp.v1beta.LfpStoreProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LfpStoreService");
    }
  }

  private static final class LfpStoreServiceFileDescriptorSupplier
      extends LfpStoreServiceBaseDescriptorSupplier {
    LfpStoreServiceFileDescriptorSupplier() {}
  }

  private static final class LfpStoreServiceMethodDescriptorSupplier
      extends LfpStoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LfpStoreServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LfpStoreServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new LfpStoreServiceFileDescriptorSupplier())
                      .addMethod(getGetLfpStoreMethod())
                      .addMethod(getInsertLfpStoreMethod())
                      .addMethod(getDeleteLfpStoreMethod())
                      .addMethod(getListLfpStoresMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
