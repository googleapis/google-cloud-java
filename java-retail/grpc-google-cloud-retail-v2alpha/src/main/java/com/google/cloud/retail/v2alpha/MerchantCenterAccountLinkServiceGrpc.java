/*
 * Copyright 2023 Google LLC
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
 * Merchant Center Link service to link a Branch to a Merchant Center Account.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/retail/v2alpha/merchant_center_account_link_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MerchantCenterAccountLinkServiceGrpc {

  private MerchantCenterAccountLinkServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.retail.v2alpha.MerchantCenterAccountLinkService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksRequest,
          com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksResponse>
      getListMerchantCenterAccountLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMerchantCenterAccountLinks",
      requestType = com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksRequest.class,
      responseType = com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksRequest,
          com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksResponse>
      getListMerchantCenterAccountLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksRequest,
            com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksResponse>
        getListMerchantCenterAccountLinksMethod;
    if ((getListMerchantCenterAccountLinksMethod =
            MerchantCenterAccountLinkServiceGrpc.getListMerchantCenterAccountLinksMethod)
        == null) {
      synchronized (MerchantCenterAccountLinkServiceGrpc.class) {
        if ((getListMerchantCenterAccountLinksMethod =
                MerchantCenterAccountLinkServiceGrpc.getListMerchantCenterAccountLinksMethod)
            == null) {
          MerchantCenterAccountLinkServiceGrpc.getListMerchantCenterAccountLinksMethod =
              getListMerchantCenterAccountLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksRequest,
                          com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListMerchantCenterAccountLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MerchantCenterAccountLinkServiceMethodDescriptorSupplier(
                              "ListMerchantCenterAccountLinks"))
                      .build();
        }
      }
    }
    return getListMerchantCenterAccountLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.CreateMerchantCenterAccountLinkRequest,
          com.google.longrunning.Operation>
      getCreateMerchantCenterAccountLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMerchantCenterAccountLink",
      requestType = com.google.cloud.retail.v2alpha.CreateMerchantCenterAccountLinkRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.CreateMerchantCenterAccountLinkRequest,
          com.google.longrunning.Operation>
      getCreateMerchantCenterAccountLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2alpha.CreateMerchantCenterAccountLinkRequest,
            com.google.longrunning.Operation>
        getCreateMerchantCenterAccountLinkMethod;
    if ((getCreateMerchantCenterAccountLinkMethod =
            MerchantCenterAccountLinkServiceGrpc.getCreateMerchantCenterAccountLinkMethod)
        == null) {
      synchronized (MerchantCenterAccountLinkServiceGrpc.class) {
        if ((getCreateMerchantCenterAccountLinkMethod =
                MerchantCenterAccountLinkServiceGrpc.getCreateMerchantCenterAccountLinkMethod)
            == null) {
          MerchantCenterAccountLinkServiceGrpc.getCreateMerchantCenterAccountLinkMethod =
              getCreateMerchantCenterAccountLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2alpha.CreateMerchantCenterAccountLinkRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateMerchantCenterAccountLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.CreateMerchantCenterAccountLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MerchantCenterAccountLinkServiceMethodDescriptorSupplier(
                              "CreateMerchantCenterAccountLink"))
                      .build();
        }
      }
    }
    return getCreateMerchantCenterAccountLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.DeleteMerchantCenterAccountLinkRequest,
          com.google.protobuf.Empty>
      getDeleteMerchantCenterAccountLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMerchantCenterAccountLink",
      requestType = com.google.cloud.retail.v2alpha.DeleteMerchantCenterAccountLinkRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.DeleteMerchantCenterAccountLinkRequest,
          com.google.protobuf.Empty>
      getDeleteMerchantCenterAccountLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2alpha.DeleteMerchantCenterAccountLinkRequest,
            com.google.protobuf.Empty>
        getDeleteMerchantCenterAccountLinkMethod;
    if ((getDeleteMerchantCenterAccountLinkMethod =
            MerchantCenterAccountLinkServiceGrpc.getDeleteMerchantCenterAccountLinkMethod)
        == null) {
      synchronized (MerchantCenterAccountLinkServiceGrpc.class) {
        if ((getDeleteMerchantCenterAccountLinkMethod =
                MerchantCenterAccountLinkServiceGrpc.getDeleteMerchantCenterAccountLinkMethod)
            == null) {
          MerchantCenterAccountLinkServiceGrpc.getDeleteMerchantCenterAccountLinkMethod =
              getDeleteMerchantCenterAccountLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2alpha.DeleteMerchantCenterAccountLinkRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteMerchantCenterAccountLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.DeleteMerchantCenterAccountLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MerchantCenterAccountLinkServiceMethodDescriptorSupplier(
                              "DeleteMerchantCenterAccountLink"))
                      .build();
        }
      }
    }
    return getDeleteMerchantCenterAccountLinkMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MerchantCenterAccountLinkServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MerchantCenterAccountLinkServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MerchantCenterAccountLinkServiceStub>() {
          @java.lang.Override
          public MerchantCenterAccountLinkServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MerchantCenterAccountLinkServiceStub(channel, callOptions);
          }
        };
    return MerchantCenterAccountLinkServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MerchantCenterAccountLinkServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MerchantCenterAccountLinkServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MerchantCenterAccountLinkServiceBlockingStub>() {
          @java.lang.Override
          public MerchantCenterAccountLinkServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MerchantCenterAccountLinkServiceBlockingStub(channel, callOptions);
          }
        };
    return MerchantCenterAccountLinkServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MerchantCenterAccountLinkServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MerchantCenterAccountLinkServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MerchantCenterAccountLinkServiceFutureStub>() {
          @java.lang.Override
          public MerchantCenterAccountLinkServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MerchantCenterAccountLinkServiceFutureStub(channel, callOptions);
          }
        };
    return MerchantCenterAccountLinkServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Merchant Center Link service to link a Branch to a Merchant Center Account.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists all
     * [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink]s
     * under the specified parent [Catalog][google.cloud.retail.v2alpha.Catalog].
     * </pre>
     */
    default void listMerchantCenterAccountLinks(
        com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMerchantCenterAccountLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a
     * [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink].
     * </pre>
     */
    default void createMerchantCenterAccountLink(
        com.google.cloud.retail.v2alpha.CreateMerchantCenterAccountLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMerchantCenterAccountLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a
     * [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink].
     * If the
     * [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink]
     * to delete does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    default void deleteMerchantCenterAccountLink(
        com.google.cloud.retail.v2alpha.DeleteMerchantCenterAccountLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMerchantCenterAccountLinkMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MerchantCenterAccountLinkService.
   *
   * <pre>
   * Merchant Center Link service to link a Branch to a Merchant Center Account.
   * </pre>
   */
  public abstract static class MerchantCenterAccountLinkServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return MerchantCenterAccountLinkServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service
   * MerchantCenterAccountLinkService.
   *
   * <pre>
   * Merchant Center Link service to link a Branch to a Merchant Center Account.
   * </pre>
   */
  public static final class MerchantCenterAccountLinkServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MerchantCenterAccountLinkServiceStub> {
    private MerchantCenterAccountLinkServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MerchantCenterAccountLinkServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MerchantCenterAccountLinkServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all
     * [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink]s
     * under the specified parent [Catalog][google.cloud.retail.v2alpha.Catalog].
     * </pre>
     */
    public void listMerchantCenterAccountLinks(
        com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMerchantCenterAccountLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a
     * [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink].
     * </pre>
     */
    public void createMerchantCenterAccountLink(
        com.google.cloud.retail.v2alpha.CreateMerchantCenterAccountLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMerchantCenterAccountLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a
     * [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink].
     * If the
     * [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink]
     * to delete does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public void deleteMerchantCenterAccountLink(
        com.google.cloud.retail.v2alpha.DeleteMerchantCenterAccountLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMerchantCenterAccountLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service
   * MerchantCenterAccountLinkService.
   *
   * <pre>
   * Merchant Center Link service to link a Branch to a Merchant Center Account.
   * </pre>
   */
  public static final class MerchantCenterAccountLinkServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MerchantCenterAccountLinkServiceBlockingStub> {
    private MerchantCenterAccountLinkServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MerchantCenterAccountLinkServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MerchantCenterAccountLinkServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all
     * [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink]s
     * under the specified parent [Catalog][google.cloud.retail.v2alpha.Catalog].
     * </pre>
     */
    public com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksResponse
        listMerchantCenterAccountLinks(
            com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMerchantCenterAccountLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a
     * [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink].
     * </pre>
     */
    public com.google.longrunning.Operation createMerchantCenterAccountLink(
        com.google.cloud.retail.v2alpha.CreateMerchantCenterAccountLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMerchantCenterAccountLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a
     * [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink].
     * If the
     * [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink]
     * to delete does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public com.google.protobuf.Empty deleteMerchantCenterAccountLink(
        com.google.cloud.retail.v2alpha.DeleteMerchantCenterAccountLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMerchantCenterAccountLinkMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * MerchantCenterAccountLinkService.
   *
   * <pre>
   * Merchant Center Link service to link a Branch to a Merchant Center Account.
   * </pre>
   */
  public static final class MerchantCenterAccountLinkServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MerchantCenterAccountLinkServiceFutureStub> {
    private MerchantCenterAccountLinkServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MerchantCenterAccountLinkServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MerchantCenterAccountLinkServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all
     * [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink]s
     * under the specified parent [Catalog][google.cloud.retail.v2alpha.Catalog].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksResponse>
        listMerchantCenterAccountLinks(
            com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMerchantCenterAccountLinksMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a
     * [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createMerchantCenterAccountLink(
            com.google.cloud.retail.v2alpha.CreateMerchantCenterAccountLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMerchantCenterAccountLinkMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a
     * [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink].
     * If the
     * [MerchantCenterAccountLink][google.cloud.retail.v2alpha.MerchantCenterAccountLink]
     * to delete does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteMerchantCenterAccountLink(
            com.google.cloud.retail.v2alpha.DeleteMerchantCenterAccountLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMerchantCenterAccountLinkMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_LIST_MERCHANT_CENTER_ACCOUNT_LINKS = 0;
  private static final int METHODID_CREATE_MERCHANT_CENTER_ACCOUNT_LINK = 1;
  private static final int METHODID_DELETE_MERCHANT_CENTER_ACCOUNT_LINK = 2;

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
        case METHODID_LIST_MERCHANT_CENTER_ACCOUNT_LINKS:
          serviceImpl.listMerchantCenterAccountLinks(
              (com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_MERCHANT_CENTER_ACCOUNT_LINK:
          serviceImpl.createMerchantCenterAccountLink(
              (com.google.cloud.retail.v2alpha.CreateMerchantCenterAccountLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MERCHANT_CENTER_ACCOUNT_LINK:
          serviceImpl.deleteMerchantCenterAccountLink(
              (com.google.cloud.retail.v2alpha.DeleteMerchantCenterAccountLinkRequest) request,
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
            getListMerchantCenterAccountLinksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksRequest,
                    com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksResponse>(
                    service, METHODID_LIST_MERCHANT_CENTER_ACCOUNT_LINKS)))
        .addMethod(
            getCreateMerchantCenterAccountLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2alpha.CreateMerchantCenterAccountLinkRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_MERCHANT_CENTER_ACCOUNT_LINK)))
        .addMethod(
            getDeleteMerchantCenterAccountLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2alpha.DeleteMerchantCenterAccountLinkRequest,
                    com.google.protobuf.Empty>(
                    service, METHODID_DELETE_MERCHANT_CENTER_ACCOUNT_LINK)))
        .build();
  }

  private abstract static class MerchantCenterAccountLinkServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MerchantCenterAccountLinkServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.retail.v2alpha.MerchantCenterAccountLinkServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MerchantCenterAccountLinkService");
    }
  }

  private static final class MerchantCenterAccountLinkServiceFileDescriptorSupplier
      extends MerchantCenterAccountLinkServiceBaseDescriptorSupplier {
    MerchantCenterAccountLinkServiceFileDescriptorSupplier() {}
  }

  private static final class MerchantCenterAccountLinkServiceMethodDescriptorSupplier
      extends MerchantCenterAccountLinkServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MerchantCenterAccountLinkServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MerchantCenterAccountLinkServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new MerchantCenterAccountLinkServiceFileDescriptorSupplier())
                      .addMethod(getListMerchantCenterAccountLinksMethod())
                      .addMethod(getCreateMerchantCenterAccountLinkMethod())
                      .addMethod(getDeleteMerchantCenterAccountLinkMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
