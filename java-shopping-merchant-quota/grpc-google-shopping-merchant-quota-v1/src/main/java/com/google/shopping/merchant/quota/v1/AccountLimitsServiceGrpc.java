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
package com.google.shopping.merchant.quota.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to retrieve account limits.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class AccountLimitsServiceGrpc {

  private AccountLimitsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.quota.v1.AccountLimitsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.quota.v1.GetAccountLimitRequest,
          com.google.shopping.merchant.quota.v1.AccountLimit>
      getGetAccountLimitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccountLimit",
      requestType = com.google.shopping.merchant.quota.v1.GetAccountLimitRequest.class,
      responseType = com.google.shopping.merchant.quota.v1.AccountLimit.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.quota.v1.GetAccountLimitRequest,
          com.google.shopping.merchant.quota.v1.AccountLimit>
      getGetAccountLimitMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.quota.v1.GetAccountLimitRequest,
            com.google.shopping.merchant.quota.v1.AccountLimit>
        getGetAccountLimitMethod;
    if ((getGetAccountLimitMethod = AccountLimitsServiceGrpc.getGetAccountLimitMethod) == null) {
      synchronized (AccountLimitsServiceGrpc.class) {
        if ((getGetAccountLimitMethod = AccountLimitsServiceGrpc.getGetAccountLimitMethod)
            == null) {
          AccountLimitsServiceGrpc.getGetAccountLimitMethod =
              getGetAccountLimitMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.quota.v1.GetAccountLimitRequest,
                          com.google.shopping.merchant.quota.v1.AccountLimit>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccountLimit"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.quota.v1.GetAccountLimitRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.quota.v1.AccountLimit
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountLimitsServiceMethodDescriptorSupplier("GetAccountLimit"))
                      .build();
        }
      }
    }
    return getGetAccountLimitMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.quota.v1.ListAccountLimitsRequest,
          com.google.shopping.merchant.quota.v1.ListAccountLimitsResponse>
      getListAccountLimitsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAccountLimits",
      requestType = com.google.shopping.merchant.quota.v1.ListAccountLimitsRequest.class,
      responseType = com.google.shopping.merchant.quota.v1.ListAccountLimitsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.quota.v1.ListAccountLimitsRequest,
          com.google.shopping.merchant.quota.v1.ListAccountLimitsResponse>
      getListAccountLimitsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.quota.v1.ListAccountLimitsRequest,
            com.google.shopping.merchant.quota.v1.ListAccountLimitsResponse>
        getListAccountLimitsMethod;
    if ((getListAccountLimitsMethod = AccountLimitsServiceGrpc.getListAccountLimitsMethod)
        == null) {
      synchronized (AccountLimitsServiceGrpc.class) {
        if ((getListAccountLimitsMethod = AccountLimitsServiceGrpc.getListAccountLimitsMethod)
            == null) {
          AccountLimitsServiceGrpc.getListAccountLimitsMethod =
              getListAccountLimitsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.quota.v1.ListAccountLimitsRequest,
                          com.google.shopping.merchant.quota.v1.ListAccountLimitsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAccountLimits"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.quota.v1.ListAccountLimitsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.quota.v1.ListAccountLimitsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountLimitsServiceMethodDescriptorSupplier("ListAccountLimits"))
                      .build();
        }
      }
    }
    return getListAccountLimitsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AccountLimitsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountLimitsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountLimitsServiceStub>() {
          @java.lang.Override
          public AccountLimitsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountLimitsServiceStub(channel, callOptions);
          }
        };
    return AccountLimitsServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static AccountLimitsServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountLimitsServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountLimitsServiceBlockingV2Stub>() {
          @java.lang.Override
          public AccountLimitsServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountLimitsServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return AccountLimitsServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccountLimitsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountLimitsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountLimitsServiceBlockingStub>() {
          @java.lang.Override
          public AccountLimitsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountLimitsServiceBlockingStub(channel, callOptions);
          }
        };
    return AccountLimitsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AccountLimitsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountLimitsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountLimitsServiceFutureStub>() {
          @java.lang.Override
          public AccountLimitsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountLimitsServiceFutureStub(channel, callOptions);
          }
        };
    return AccountLimitsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to retrieve account limits.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves an account limit.
     * </pre>
     */
    default void getAccountLimit(
        com.google.shopping.merchant.quota.v1.GetAccountLimitRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.quota.v1.AccountLimit>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAccountLimitMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the limits of an account.
     * </pre>
     */
    default void listAccountLimits(
        com.google.shopping.merchant.quota.v1.ListAccountLimitsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.quota.v1.ListAccountLimitsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAccountLimitsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AccountLimitsService.
   *
   * <pre>
   * Service to retrieve account limits.
   * </pre>
   */
  public abstract static class AccountLimitsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AccountLimitsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AccountLimitsService.
   *
   * <pre>
   * Service to retrieve account limits.
   * </pre>
   */
  public static final class AccountLimitsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AccountLimitsServiceStub> {
    private AccountLimitsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountLimitsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountLimitsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an account limit.
     * </pre>
     */
    public void getAccountLimit(
        com.google.shopping.merchant.quota.v1.GetAccountLimitRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.quota.v1.AccountLimit>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccountLimitMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the limits of an account.
     * </pre>
     */
    public void listAccountLimits(
        com.google.shopping.merchant.quota.v1.ListAccountLimitsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.quota.v1.ListAccountLimitsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAccountLimitsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AccountLimitsService.
   *
   * <pre>
   * Service to retrieve account limits.
   * </pre>
   */
  public static final class AccountLimitsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AccountLimitsServiceBlockingV2Stub> {
    private AccountLimitsServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountLimitsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountLimitsServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an account limit.
     * </pre>
     */
    public com.google.shopping.merchant.quota.v1.AccountLimit getAccountLimit(
        com.google.shopping.merchant.quota.v1.GetAccountLimitRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAccountLimitMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the limits of an account.
     * </pre>
     */
    public com.google.shopping.merchant.quota.v1.ListAccountLimitsResponse listAccountLimits(
        com.google.shopping.merchant.quota.v1.ListAccountLimitsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAccountLimitsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AccountLimitsService.
   *
   * <pre>
   * Service to retrieve account limits.
   * </pre>
   */
  public static final class AccountLimitsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AccountLimitsServiceBlockingStub> {
    private AccountLimitsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountLimitsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountLimitsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an account limit.
     * </pre>
     */
    public com.google.shopping.merchant.quota.v1.AccountLimit getAccountLimit(
        com.google.shopping.merchant.quota.v1.GetAccountLimitRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountLimitMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the limits of an account.
     * </pre>
     */
    public com.google.shopping.merchant.quota.v1.ListAccountLimitsResponse listAccountLimits(
        com.google.shopping.merchant.quota.v1.ListAccountLimitsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAccountLimitsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AccountLimitsService.
   *
   * <pre>
   * Service to retrieve account limits.
   * </pre>
   */
  public static final class AccountLimitsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AccountLimitsServiceFutureStub> {
    private AccountLimitsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountLimitsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountLimitsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an account limit.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.quota.v1.AccountLimit>
        getAccountLimit(com.google.shopping.merchant.quota.v1.GetAccountLimitRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccountLimitMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the limits of an account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.quota.v1.ListAccountLimitsResponse>
        listAccountLimits(com.google.shopping.merchant.quota.v1.ListAccountLimitsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAccountLimitsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ACCOUNT_LIMIT = 0;
  private static final int METHODID_LIST_ACCOUNT_LIMITS = 1;

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
        case METHODID_GET_ACCOUNT_LIMIT:
          serviceImpl.getAccountLimit(
              (com.google.shopping.merchant.quota.v1.GetAccountLimitRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.quota.v1.AccountLimit>)
                  responseObserver);
          break;
        case METHODID_LIST_ACCOUNT_LIMITS:
          serviceImpl.listAccountLimits(
              (com.google.shopping.merchant.quota.v1.ListAccountLimitsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.quota.v1.ListAccountLimitsResponse>)
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
            getGetAccountLimitMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.quota.v1.GetAccountLimitRequest,
                    com.google.shopping.merchant.quota.v1.AccountLimit>(
                    service, METHODID_GET_ACCOUNT_LIMIT)))
        .addMethod(
            getListAccountLimitsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.quota.v1.ListAccountLimitsRequest,
                    com.google.shopping.merchant.quota.v1.ListAccountLimitsResponse>(
                    service, METHODID_LIST_ACCOUNT_LIMITS)))
        .build();
  }

  private abstract static class AccountLimitsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccountLimitsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.quota.v1.AccountLimitsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AccountLimitsService");
    }
  }

  private static final class AccountLimitsServiceFileDescriptorSupplier
      extends AccountLimitsServiceBaseDescriptorSupplier {
    AccountLimitsServiceFileDescriptorSupplier() {}
  }

  private static final class AccountLimitsServiceMethodDescriptorSupplier
      extends AccountLimitsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AccountLimitsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AccountLimitsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AccountLimitsServiceFileDescriptorSupplier())
                      .addMethod(getGetAccountLimitMethod())
                      .addMethod(getListAccountLimitsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
