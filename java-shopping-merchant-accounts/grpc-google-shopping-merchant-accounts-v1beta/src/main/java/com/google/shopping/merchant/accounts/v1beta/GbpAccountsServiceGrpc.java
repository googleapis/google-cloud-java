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
package com.google.shopping.merchant.accounts.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The service facilitates the management of a merchant's Google Business
 * Profile (GBP) account settings. This API defines the following resource
 * model:
 * - [GbpAccount][google.shopping.merchant.accounts.v1.GbpAccount]
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1beta/gbpaccounts.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GbpAccountsServiceGrpc {

  private GbpAccountsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1beta.GbpAccountsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsRequest,
          com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsResponse>
      getListGbpAccountsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGbpAccounts",
      requestType = com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsRequest,
          com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsResponse>
      getListGbpAccountsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsRequest,
            com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsResponse>
        getListGbpAccountsMethod;
    if ((getListGbpAccountsMethod = GbpAccountsServiceGrpc.getListGbpAccountsMethod) == null) {
      synchronized (GbpAccountsServiceGrpc.class) {
        if ((getListGbpAccountsMethod = GbpAccountsServiceGrpc.getListGbpAccountsMethod) == null) {
          GbpAccountsServiceGrpc.getListGbpAccountsMethod =
              getListGbpAccountsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsRequest,
                          com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGbpAccounts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GbpAccountsServiceMethodDescriptorSupplier("ListGbpAccounts"))
                      .build();
        }
      }
    }
    return getListGbpAccountsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountRequest,
          com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountResponse>
      getLinkGbpAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LinkGbpAccount",
      requestType = com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountRequest,
          com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountResponse>
      getLinkGbpAccountMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountRequest,
            com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountResponse>
        getLinkGbpAccountMethod;
    if ((getLinkGbpAccountMethod = GbpAccountsServiceGrpc.getLinkGbpAccountMethod) == null) {
      synchronized (GbpAccountsServiceGrpc.class) {
        if ((getLinkGbpAccountMethod = GbpAccountsServiceGrpc.getLinkGbpAccountMethod) == null) {
          GbpAccountsServiceGrpc.getLinkGbpAccountMethod =
              getLinkGbpAccountMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountRequest,
                          com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LinkGbpAccount"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GbpAccountsServiceMethodDescriptorSupplier("LinkGbpAccount"))
                      .build();
        }
      }
    }
    return getLinkGbpAccountMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static GbpAccountsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GbpAccountsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GbpAccountsServiceStub>() {
          @java.lang.Override
          public GbpAccountsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GbpAccountsServiceStub(channel, callOptions);
          }
        };
    return GbpAccountsServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static GbpAccountsServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GbpAccountsServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GbpAccountsServiceBlockingV2Stub>() {
          @java.lang.Override
          public GbpAccountsServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GbpAccountsServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return GbpAccountsServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GbpAccountsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GbpAccountsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GbpAccountsServiceBlockingStub>() {
          @java.lang.Override
          public GbpAccountsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GbpAccountsServiceBlockingStub(channel, callOptions);
          }
        };
    return GbpAccountsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static GbpAccountsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GbpAccountsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GbpAccountsServiceFutureStub>() {
          @java.lang.Override
          public GbpAccountsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GbpAccountsServiceFutureStub(channel, callOptions);
          }
        };
    return GbpAccountsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The service facilitates the management of a merchant's Google Business
   * Profile (GBP) account settings. This API defines the following resource
   * model:
   * - [GbpAccount][google.shopping.merchant.accounts.v1.GbpAccount]
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * List the GBP accounts for a given merchant.
     * </pre>
     */
    default void listGbpAccounts(
        com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListGbpAccountsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Link the specified merchant to a GBP account for all countries.
     * </pre>
     */
    default void linkGbpAccount(
        com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getLinkGbpAccountMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GbpAccountsService.
   *
   * <pre>
   * The service facilitates the management of a merchant's Google Business
   * Profile (GBP) account settings. This API defines the following resource
   * model:
   * - [GbpAccount][google.shopping.merchant.accounts.v1.GbpAccount]
   * </pre>
   */
  public abstract static class GbpAccountsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return GbpAccountsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GbpAccountsService.
   *
   * <pre>
   * The service facilitates the management of a merchant's Google Business
   * Profile (GBP) account settings. This API defines the following resource
   * model:
   * - [GbpAccount][google.shopping.merchant.accounts.v1.GbpAccount]
   * </pre>
   */
  public static final class GbpAccountsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<GbpAccountsServiceStub> {
    private GbpAccountsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GbpAccountsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GbpAccountsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * List the GBP accounts for a given merchant.
     * </pre>
     */
    public void listGbpAccounts(
        com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGbpAccountsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Link the specified merchant to a GBP account for all countries.
     * </pre>
     */
    public void linkGbpAccount(
        com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLinkGbpAccountMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GbpAccountsService.
   *
   * <pre>
   * The service facilitates the management of a merchant's Google Business
   * Profile (GBP) account settings. This API defines the following resource
   * model:
   * - [GbpAccount][google.shopping.merchant.accounts.v1.GbpAccount]
   * </pre>
   */
  public static final class GbpAccountsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<GbpAccountsServiceBlockingV2Stub> {
    private GbpAccountsServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GbpAccountsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GbpAccountsServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * List the GBP accounts for a given merchant.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsResponse listGbpAccounts(
        com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGbpAccountsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Link the specified merchant to a GBP account for all countries.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountResponse linkGbpAccount(
        com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLinkGbpAccountMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service GbpAccountsService.
   *
   * <pre>
   * The service facilitates the management of a merchant's Google Business
   * Profile (GBP) account settings. This API defines the following resource
   * model:
   * - [GbpAccount][google.shopping.merchant.accounts.v1.GbpAccount]
   * </pre>
   */
  public static final class GbpAccountsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GbpAccountsServiceBlockingStub> {
    private GbpAccountsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GbpAccountsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GbpAccountsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * List the GBP accounts for a given merchant.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsResponse listGbpAccounts(
        com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGbpAccountsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Link the specified merchant to a GBP account for all countries.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountResponse linkGbpAccount(
        com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLinkGbpAccountMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GbpAccountsService.
   *
   * <pre>
   * The service facilitates the management of a merchant's Google Business
   * Profile (GBP) account settings. This API defines the following resource
   * model:
   * - [GbpAccount][google.shopping.merchant.accounts.v1.GbpAccount]
   * </pre>
   */
  public static final class GbpAccountsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<GbpAccountsServiceFutureStub> {
    private GbpAccountsServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GbpAccountsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GbpAccountsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * List the GBP accounts for a given merchant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsResponse>
        listGbpAccounts(
            com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGbpAccountsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Link the specified merchant to a GBP account for all countries.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountResponse>
        linkGbpAccount(com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLinkGbpAccountMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_GBP_ACCOUNTS = 0;
  private static final int METHODID_LINK_GBP_ACCOUNT = 1;

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
        case METHODID_LIST_GBP_ACCOUNTS:
          serviceImpl.listGbpAccounts(
              (com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsResponse>)
                  responseObserver);
          break;
        case METHODID_LINK_GBP_ACCOUNT:
          serviceImpl.linkGbpAccount(
              (com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountResponse>)
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
            getListGbpAccountsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsRequest,
                    com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsResponse>(
                    service, METHODID_LIST_GBP_ACCOUNTS)))
        .addMethod(
            getLinkGbpAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountRequest,
                    com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountResponse>(
                    service, METHODID_LINK_GBP_ACCOUNT)))
        .build();
  }

  private abstract static class GbpAccountsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GbpAccountsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1beta.GbpAccountsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GbpAccountsService");
    }
  }

  private static final class GbpAccountsServiceFileDescriptorSupplier
      extends GbpAccountsServiceBaseDescriptorSupplier {
    GbpAccountsServiceFileDescriptorSupplier() {}
  }

  private static final class GbpAccountsServiceMethodDescriptorSupplier
      extends GbpAccountsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GbpAccountsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (GbpAccountsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new GbpAccountsServiceFileDescriptorSupplier())
                      .addMethod(getListGbpAccountsMethod())
                      .addMethod(getLinkGbpAccountMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
