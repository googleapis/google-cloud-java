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
 * Manages account level tax setting data.
 * This API defines the following resource model:
 * - [AccountTax][google.shopping.merchant.accounts.v1main.AccountTax]
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1beta/account_tax.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AccountTaxServiceGrpc {

  private AccountTaxServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1beta.AccountTaxService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetAccountTaxRequest,
          com.google.shopping.merchant.accounts.v1beta.AccountTax>
      getGetAccountTaxMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccountTax",
      requestType = com.google.shopping.merchant.accounts.v1beta.GetAccountTaxRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.AccountTax.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetAccountTaxRequest,
          com.google.shopping.merchant.accounts.v1beta.AccountTax>
      getGetAccountTaxMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.GetAccountTaxRequest,
            com.google.shopping.merchant.accounts.v1beta.AccountTax>
        getGetAccountTaxMethod;
    if ((getGetAccountTaxMethod = AccountTaxServiceGrpc.getGetAccountTaxMethod) == null) {
      synchronized (AccountTaxServiceGrpc.class) {
        if ((getGetAccountTaxMethod = AccountTaxServiceGrpc.getGetAccountTaxMethod) == null) {
          AccountTaxServiceGrpc.getGetAccountTaxMethod =
              getGetAccountTaxMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.GetAccountTaxRequest,
                          com.google.shopping.merchant.accounts.v1beta.AccountTax>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccountTax"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.GetAccountTaxRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.AccountTax
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountTaxServiceMethodDescriptorSupplier("GetAccountTax"))
                      .build();
        }
      }
    }
    return getGetAccountTaxMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ListAccountTaxRequest,
          com.google.shopping.merchant.accounts.v1beta.ListAccountTaxResponse>
      getListAccountTaxMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAccountTax",
      requestType = com.google.shopping.merchant.accounts.v1beta.ListAccountTaxRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.ListAccountTaxResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ListAccountTaxRequest,
          com.google.shopping.merchant.accounts.v1beta.ListAccountTaxResponse>
      getListAccountTaxMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.ListAccountTaxRequest,
            com.google.shopping.merchant.accounts.v1beta.ListAccountTaxResponse>
        getListAccountTaxMethod;
    if ((getListAccountTaxMethod = AccountTaxServiceGrpc.getListAccountTaxMethod) == null) {
      synchronized (AccountTaxServiceGrpc.class) {
        if ((getListAccountTaxMethod = AccountTaxServiceGrpc.getListAccountTaxMethod) == null) {
          AccountTaxServiceGrpc.getListAccountTaxMethod =
              getListAccountTaxMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.ListAccountTaxRequest,
                          com.google.shopping.merchant.accounts.v1beta.ListAccountTaxResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAccountTax"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.ListAccountTaxRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.ListAccountTaxResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountTaxServiceMethodDescriptorSupplier("ListAccountTax"))
                      .build();
        }
      }
    }
    return getListAccountTaxMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateAccountTaxRequest,
          com.google.shopping.merchant.accounts.v1beta.AccountTax>
      getUpdateAccountTaxMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAccountTax",
      requestType = com.google.shopping.merchant.accounts.v1beta.UpdateAccountTaxRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.AccountTax.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateAccountTaxRequest,
          com.google.shopping.merchant.accounts.v1beta.AccountTax>
      getUpdateAccountTaxMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.UpdateAccountTaxRequest,
            com.google.shopping.merchant.accounts.v1beta.AccountTax>
        getUpdateAccountTaxMethod;
    if ((getUpdateAccountTaxMethod = AccountTaxServiceGrpc.getUpdateAccountTaxMethod) == null) {
      synchronized (AccountTaxServiceGrpc.class) {
        if ((getUpdateAccountTaxMethod = AccountTaxServiceGrpc.getUpdateAccountTaxMethod) == null) {
          AccountTaxServiceGrpc.getUpdateAccountTaxMethod =
              getUpdateAccountTaxMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.UpdateAccountTaxRequest,
                          com.google.shopping.merchant.accounts.v1beta.AccountTax>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAccountTax"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.UpdateAccountTaxRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.AccountTax
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountTaxServiceMethodDescriptorSupplier("UpdateAccountTax"))
                      .build();
        }
      }
    }
    return getUpdateAccountTaxMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AccountTaxServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountTaxServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountTaxServiceStub>() {
          @java.lang.Override
          public AccountTaxServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountTaxServiceStub(channel, callOptions);
          }
        };
    return AccountTaxServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccountTaxServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountTaxServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountTaxServiceBlockingStub>() {
          @java.lang.Override
          public AccountTaxServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountTaxServiceBlockingStub(channel, callOptions);
          }
        };
    return AccountTaxServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AccountTaxServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountTaxServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountTaxServiceFutureStub>() {
          @java.lang.Override
          public AccountTaxServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountTaxServiceFutureStub(channel, callOptions);
          }
        };
    return AccountTaxServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manages account level tax setting data.
   * This API defines the following resource model:
   * - [AccountTax][google.shopping.merchant.accounts.v1main.AccountTax]
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Returns the tax rules that match the conditions of GetAccountTaxRequest
     * </pre>
     */
    default void getAccountTax(
        com.google.shopping.merchant.accounts.v1beta.GetAccountTaxRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.AccountTax>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAccountTaxMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the tax settings of the sub-accounts only in your
     * Merchant Center account.
     * This method can only be called on a multi-client account, otherwise it'll
     * return an error.
     * </pre>
     */
    default void listAccountTax(
        com.google.shopping.merchant.accounts.v1beta.ListAccountTaxRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.ListAccountTaxResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAccountTaxMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the tax settings of the account.
     * </pre>
     */
    default void updateAccountTax(
        com.google.shopping.merchant.accounts.v1beta.UpdateAccountTaxRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.AccountTax>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAccountTaxMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AccountTaxService.
   *
   * <pre>
   * Manages account level tax setting data.
   * This API defines the following resource model:
   * - [AccountTax][google.shopping.merchant.accounts.v1main.AccountTax]
   * </pre>
   */
  public abstract static class AccountTaxServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AccountTaxServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AccountTaxService.
   *
   * <pre>
   * Manages account level tax setting data.
   * This API defines the following resource model:
   * - [AccountTax][google.shopping.merchant.accounts.v1main.AccountTax]
   * </pre>
   */
  public static final class AccountTaxServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AccountTaxServiceStub> {
    private AccountTaxServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountTaxServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountTaxServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the tax rules that match the conditions of GetAccountTaxRequest
     * </pre>
     */
    public void getAccountTax(
        com.google.shopping.merchant.accounts.v1beta.GetAccountTaxRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.AccountTax>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccountTaxMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the tax settings of the sub-accounts only in your
     * Merchant Center account.
     * This method can only be called on a multi-client account, otherwise it'll
     * return an error.
     * </pre>
     */
    public void listAccountTax(
        com.google.shopping.merchant.accounts.v1beta.ListAccountTaxRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.ListAccountTaxResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAccountTaxMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the tax settings of the account.
     * </pre>
     */
    public void updateAccountTax(
        com.google.shopping.merchant.accounts.v1beta.UpdateAccountTaxRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.AccountTax>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAccountTaxMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AccountTaxService.
   *
   * <pre>
   * Manages account level tax setting data.
   * This API defines the following resource model:
   * - [AccountTax][google.shopping.merchant.accounts.v1main.AccountTax]
   * </pre>
   */
  public static final class AccountTaxServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AccountTaxServiceBlockingStub> {
    private AccountTaxServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountTaxServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountTaxServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the tax rules that match the conditions of GetAccountTaxRequest
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.AccountTax getAccountTax(
        com.google.shopping.merchant.accounts.v1beta.GetAccountTaxRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountTaxMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the tax settings of the sub-accounts only in your
     * Merchant Center account.
     * This method can only be called on a multi-client account, otherwise it'll
     * return an error.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.ListAccountTaxResponse listAccountTax(
        com.google.shopping.merchant.accounts.v1beta.ListAccountTaxRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAccountTaxMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the tax settings of the account.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.AccountTax updateAccountTax(
        com.google.shopping.merchant.accounts.v1beta.UpdateAccountTaxRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAccountTaxMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AccountTaxService.
   *
   * <pre>
   * Manages account level tax setting data.
   * This API defines the following resource model:
   * - [AccountTax][google.shopping.merchant.accounts.v1main.AccountTax]
   * </pre>
   */
  public static final class AccountTaxServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AccountTaxServiceFutureStub> {
    private AccountTaxServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountTaxServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountTaxServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the tax rules that match the conditions of GetAccountTaxRequest
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.AccountTax>
        getAccountTax(com.google.shopping.merchant.accounts.v1beta.GetAccountTaxRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccountTaxMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the tax settings of the sub-accounts only in your
     * Merchant Center account.
     * This method can only be called on a multi-client account, otherwise it'll
     * return an error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.ListAccountTaxResponse>
        listAccountTax(com.google.shopping.merchant.accounts.v1beta.ListAccountTaxRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAccountTaxMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the tax settings of the account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.AccountTax>
        updateAccountTax(
            com.google.shopping.merchant.accounts.v1beta.UpdateAccountTaxRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAccountTaxMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ACCOUNT_TAX = 0;
  private static final int METHODID_LIST_ACCOUNT_TAX = 1;
  private static final int METHODID_UPDATE_ACCOUNT_TAX = 2;

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
        case METHODID_GET_ACCOUNT_TAX:
          serviceImpl.getAccountTax(
              (com.google.shopping.merchant.accounts.v1beta.GetAccountTaxRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.AccountTax>)
                  responseObserver);
          break;
        case METHODID_LIST_ACCOUNT_TAX:
          serviceImpl.listAccountTax(
              (com.google.shopping.merchant.accounts.v1beta.ListAccountTaxRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.ListAccountTaxResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ACCOUNT_TAX:
          serviceImpl.updateAccountTax(
              (com.google.shopping.merchant.accounts.v1beta.UpdateAccountTaxRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.AccountTax>)
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
            getGetAccountTaxMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.GetAccountTaxRequest,
                    com.google.shopping.merchant.accounts.v1beta.AccountTax>(
                    service, METHODID_GET_ACCOUNT_TAX)))
        .addMethod(
            getListAccountTaxMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.ListAccountTaxRequest,
                    com.google.shopping.merchant.accounts.v1beta.ListAccountTaxResponse>(
                    service, METHODID_LIST_ACCOUNT_TAX)))
        .addMethod(
            getUpdateAccountTaxMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.UpdateAccountTaxRequest,
                    com.google.shopping.merchant.accounts.v1beta.AccountTax>(
                    service, METHODID_UPDATE_ACCOUNT_TAX)))
        .build();
  }

  private abstract static class AccountTaxServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccountTaxServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1beta.AccountTaxProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AccountTaxService");
    }
  }

  private static final class AccountTaxServiceFileDescriptorSupplier
      extends AccountTaxServiceBaseDescriptorSupplier {
    AccountTaxServiceFileDescriptorSupplier() {}
  }

  private static final class AccountTaxServiceMethodDescriptorSupplier
      extends AccountTaxServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AccountTaxServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AccountTaxServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AccountTaxServiceFileDescriptorSupplier())
                      .addMethod(getGetAccountTaxMethod())
                      .addMethod(getListAccountTaxMethod())
                      .addMethod(getUpdateAccountTaxMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
