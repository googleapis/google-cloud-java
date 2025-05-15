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
package com.google.cloud.chronicle.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * ReferenceListService provides an interface for managing reference lists.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/chronicle/v1/reference_list.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ReferenceListServiceGrpc {

  private ReferenceListServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.chronicle.v1.ReferenceListService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetReferenceListRequest,
          com.google.cloud.chronicle.v1.ReferenceList>
      getGetReferenceListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReferenceList",
      requestType = com.google.cloud.chronicle.v1.GetReferenceListRequest.class,
      responseType = com.google.cloud.chronicle.v1.ReferenceList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetReferenceListRequest,
          com.google.cloud.chronicle.v1.ReferenceList>
      getGetReferenceListMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.GetReferenceListRequest,
            com.google.cloud.chronicle.v1.ReferenceList>
        getGetReferenceListMethod;
    if ((getGetReferenceListMethod = ReferenceListServiceGrpc.getGetReferenceListMethod) == null) {
      synchronized (ReferenceListServiceGrpc.class) {
        if ((getGetReferenceListMethod = ReferenceListServiceGrpc.getGetReferenceListMethod)
            == null) {
          ReferenceListServiceGrpc.getGetReferenceListMethod =
              getGetReferenceListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.GetReferenceListRequest,
                          com.google.cloud.chronicle.v1.ReferenceList>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetReferenceList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.GetReferenceListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ReferenceList.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReferenceListServiceMethodDescriptorSupplier("GetReferenceList"))
                      .build();
        }
      }
    }
    return getGetReferenceListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListReferenceListsRequest,
          com.google.cloud.chronicle.v1.ListReferenceListsResponse>
      getListReferenceListsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReferenceLists",
      requestType = com.google.cloud.chronicle.v1.ListReferenceListsRequest.class,
      responseType = com.google.cloud.chronicle.v1.ListReferenceListsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListReferenceListsRequest,
          com.google.cloud.chronicle.v1.ListReferenceListsResponse>
      getListReferenceListsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.ListReferenceListsRequest,
            com.google.cloud.chronicle.v1.ListReferenceListsResponse>
        getListReferenceListsMethod;
    if ((getListReferenceListsMethod = ReferenceListServiceGrpc.getListReferenceListsMethod)
        == null) {
      synchronized (ReferenceListServiceGrpc.class) {
        if ((getListReferenceListsMethod = ReferenceListServiceGrpc.getListReferenceListsMethod)
            == null) {
          ReferenceListServiceGrpc.getListReferenceListsMethod =
              getListReferenceListsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.ListReferenceListsRequest,
                          com.google.cloud.chronicle.v1.ListReferenceListsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListReferenceLists"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ListReferenceListsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ListReferenceListsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReferenceListServiceMethodDescriptorSupplier("ListReferenceLists"))
                      .build();
        }
      }
    }
    return getListReferenceListsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.CreateReferenceListRequest,
          com.google.cloud.chronicle.v1.ReferenceList>
      getCreateReferenceListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReferenceList",
      requestType = com.google.cloud.chronicle.v1.CreateReferenceListRequest.class,
      responseType = com.google.cloud.chronicle.v1.ReferenceList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.CreateReferenceListRequest,
          com.google.cloud.chronicle.v1.ReferenceList>
      getCreateReferenceListMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.CreateReferenceListRequest,
            com.google.cloud.chronicle.v1.ReferenceList>
        getCreateReferenceListMethod;
    if ((getCreateReferenceListMethod = ReferenceListServiceGrpc.getCreateReferenceListMethod)
        == null) {
      synchronized (ReferenceListServiceGrpc.class) {
        if ((getCreateReferenceListMethod = ReferenceListServiceGrpc.getCreateReferenceListMethod)
            == null) {
          ReferenceListServiceGrpc.getCreateReferenceListMethod =
              getCreateReferenceListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.CreateReferenceListRequest,
                          com.google.cloud.chronicle.v1.ReferenceList>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateReferenceList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.CreateReferenceListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ReferenceList.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReferenceListServiceMethodDescriptorSupplier("CreateReferenceList"))
                      .build();
        }
      }
    }
    return getCreateReferenceListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.UpdateReferenceListRequest,
          com.google.cloud.chronicle.v1.ReferenceList>
      getUpdateReferenceListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateReferenceList",
      requestType = com.google.cloud.chronicle.v1.UpdateReferenceListRequest.class,
      responseType = com.google.cloud.chronicle.v1.ReferenceList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.UpdateReferenceListRequest,
          com.google.cloud.chronicle.v1.ReferenceList>
      getUpdateReferenceListMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.UpdateReferenceListRequest,
            com.google.cloud.chronicle.v1.ReferenceList>
        getUpdateReferenceListMethod;
    if ((getUpdateReferenceListMethod = ReferenceListServiceGrpc.getUpdateReferenceListMethod)
        == null) {
      synchronized (ReferenceListServiceGrpc.class) {
        if ((getUpdateReferenceListMethod = ReferenceListServiceGrpc.getUpdateReferenceListMethod)
            == null) {
          ReferenceListServiceGrpc.getUpdateReferenceListMethod =
              getUpdateReferenceListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.UpdateReferenceListRequest,
                          com.google.cloud.chronicle.v1.ReferenceList>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateReferenceList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.UpdateReferenceListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ReferenceList.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReferenceListServiceMethodDescriptorSupplier("UpdateReferenceList"))
                      .build();
        }
      }
    }
    return getUpdateReferenceListMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ReferenceListServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReferenceListServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ReferenceListServiceStub>() {
          @java.lang.Override
          public ReferenceListServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReferenceListServiceStub(channel, callOptions);
          }
        };
    return ReferenceListServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ReferenceListServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReferenceListServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ReferenceListServiceBlockingV2Stub>() {
          @java.lang.Override
          public ReferenceListServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReferenceListServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return ReferenceListServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReferenceListServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReferenceListServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ReferenceListServiceBlockingStub>() {
          @java.lang.Override
          public ReferenceListServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReferenceListServiceBlockingStub(channel, callOptions);
          }
        };
    return ReferenceListServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ReferenceListServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReferenceListServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ReferenceListServiceFutureStub>() {
          @java.lang.Override
          public ReferenceListServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReferenceListServiceFutureStub(channel, callOptions);
          }
        };
    return ReferenceListServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * ReferenceListService provides an interface for managing reference lists.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets a single reference list.
     * </pre>
     */
    default void getReferenceList(
        com.google.cloud.chronicle.v1.GetReferenceListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ReferenceList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetReferenceListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists a collection of reference lists.
     * </pre>
     */
    default void listReferenceLists(
        com.google.cloud.chronicle.v1.ListReferenceListsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListReferenceListsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListReferenceListsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new reference list.
     * </pre>
     */
    default void createReferenceList(
        com.google.cloud.chronicle.v1.CreateReferenceListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ReferenceList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateReferenceListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing reference list.
     * </pre>
     */
    default void updateReferenceList(
        com.google.cloud.chronicle.v1.UpdateReferenceListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ReferenceList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateReferenceListMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ReferenceListService.
   *
   * <pre>
   * ReferenceListService provides an interface for managing reference lists.
   * </pre>
   */
  public abstract static class ReferenceListServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ReferenceListServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ReferenceListService.
   *
   * <pre>
   * ReferenceListService provides an interface for managing reference lists.
   * </pre>
   */
  public static final class ReferenceListServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ReferenceListServiceStub> {
    private ReferenceListServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReferenceListServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReferenceListServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a single reference list.
     * </pre>
     */
    public void getReferenceList(
        com.google.cloud.chronicle.v1.GetReferenceListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ReferenceList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReferenceListMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists a collection of reference lists.
     * </pre>
     */
    public void listReferenceLists(
        com.google.cloud.chronicle.v1.ListReferenceListsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListReferenceListsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListReferenceListsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new reference list.
     * </pre>
     */
    public void createReferenceList(
        com.google.cloud.chronicle.v1.CreateReferenceListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ReferenceList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateReferenceListMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing reference list.
     * </pre>
     */
    public void updateReferenceList(
        com.google.cloud.chronicle.v1.UpdateReferenceListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ReferenceList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateReferenceListMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ReferenceListService.
   *
   * <pre>
   * ReferenceListService provides an interface for managing reference lists.
   * </pre>
   */
  public static final class ReferenceListServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ReferenceListServiceBlockingV2Stub> {
    private ReferenceListServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReferenceListServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReferenceListServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a single reference list.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ReferenceList getReferenceList(
        com.google.cloud.chronicle.v1.GetReferenceListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReferenceListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists a collection of reference lists.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListReferenceListsResponse listReferenceLists(
        com.google.cloud.chronicle.v1.ListReferenceListsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReferenceListsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new reference list.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ReferenceList createReferenceList(
        com.google.cloud.chronicle.v1.CreateReferenceListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReferenceListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing reference list.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ReferenceList updateReferenceList(
        com.google.cloud.chronicle.v1.UpdateReferenceListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateReferenceListMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ReferenceListService.
   *
   * <pre>
   * ReferenceListService provides an interface for managing reference lists.
   * </pre>
   */
  public static final class ReferenceListServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ReferenceListServiceBlockingStub> {
    private ReferenceListServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReferenceListServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReferenceListServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a single reference list.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ReferenceList getReferenceList(
        com.google.cloud.chronicle.v1.GetReferenceListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReferenceListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists a collection of reference lists.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListReferenceListsResponse listReferenceLists(
        com.google.cloud.chronicle.v1.ListReferenceListsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReferenceListsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new reference list.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ReferenceList createReferenceList(
        com.google.cloud.chronicle.v1.CreateReferenceListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReferenceListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing reference list.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ReferenceList updateReferenceList(
        com.google.cloud.chronicle.v1.UpdateReferenceListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateReferenceListMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ReferenceListService.
   *
   * <pre>
   * ReferenceListService provides an interface for managing reference lists.
   * </pre>
   */
  public static final class ReferenceListServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ReferenceListServiceFutureStub> {
    private ReferenceListServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReferenceListServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReferenceListServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a single reference list.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.ReferenceList>
        getReferenceList(com.google.cloud.chronicle.v1.GetReferenceListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReferenceListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists a collection of reference lists.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.ListReferenceListsResponse>
        listReferenceLists(com.google.cloud.chronicle.v1.ListReferenceListsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReferenceListsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new reference list.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.ReferenceList>
        createReferenceList(com.google.cloud.chronicle.v1.CreateReferenceListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateReferenceListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing reference list.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.ReferenceList>
        updateReferenceList(com.google.cloud.chronicle.v1.UpdateReferenceListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateReferenceListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REFERENCE_LIST = 0;
  private static final int METHODID_LIST_REFERENCE_LISTS = 1;
  private static final int METHODID_CREATE_REFERENCE_LIST = 2;
  private static final int METHODID_UPDATE_REFERENCE_LIST = 3;

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
        case METHODID_GET_REFERENCE_LIST:
          serviceImpl.getReferenceList(
              (com.google.cloud.chronicle.v1.GetReferenceListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ReferenceList>)
                  responseObserver);
          break;
        case METHODID_LIST_REFERENCE_LISTS:
          serviceImpl.listReferenceLists(
              (com.google.cloud.chronicle.v1.ListReferenceListsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.ListReferenceListsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_REFERENCE_LIST:
          serviceImpl.createReferenceList(
              (com.google.cloud.chronicle.v1.CreateReferenceListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ReferenceList>)
                  responseObserver);
          break;
        case METHODID_UPDATE_REFERENCE_LIST:
          serviceImpl.updateReferenceList(
              (com.google.cloud.chronicle.v1.UpdateReferenceListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ReferenceList>)
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
            getGetReferenceListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.GetReferenceListRequest,
                    com.google.cloud.chronicle.v1.ReferenceList>(
                    service, METHODID_GET_REFERENCE_LIST)))
        .addMethod(
            getListReferenceListsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.ListReferenceListsRequest,
                    com.google.cloud.chronicle.v1.ListReferenceListsResponse>(
                    service, METHODID_LIST_REFERENCE_LISTS)))
        .addMethod(
            getCreateReferenceListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.CreateReferenceListRequest,
                    com.google.cloud.chronicle.v1.ReferenceList>(
                    service, METHODID_CREATE_REFERENCE_LIST)))
        .addMethod(
            getUpdateReferenceListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.UpdateReferenceListRequest,
                    com.google.cloud.chronicle.v1.ReferenceList>(
                    service, METHODID_UPDATE_REFERENCE_LIST)))
        .build();
  }

  private abstract static class ReferenceListServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReferenceListServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.chronicle.v1.ReferenceListProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReferenceListService");
    }
  }

  private static final class ReferenceListServiceFileDescriptorSupplier
      extends ReferenceListServiceBaseDescriptorSupplier {
    ReferenceListServiceFileDescriptorSupplier() {}
  }

  private static final class ReferenceListServiceMethodDescriptorSupplier
      extends ReferenceListServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ReferenceListServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ReferenceListServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ReferenceListServiceFileDescriptorSupplier())
                      .addMethod(getGetReferenceListMethod())
                      .addMethod(getListReferenceListsMethod())
                      .addMethod(getCreateReferenceListMethod())
                      .addMethod(getUpdateReferenceListMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
