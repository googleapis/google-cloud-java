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
package com.google.shopping.css.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing CSS/MC account information.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/css/v1/accounts.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AccountsServiceGrpc {

  private AccountsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.shopping.css.v1.AccountsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.css.v1.ListChildAccountsRequest,
          com.google.shopping.css.v1.ListChildAccountsResponse>
      getListChildAccountsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListChildAccounts",
      requestType = com.google.shopping.css.v1.ListChildAccountsRequest.class,
      responseType = com.google.shopping.css.v1.ListChildAccountsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.css.v1.ListChildAccountsRequest,
          com.google.shopping.css.v1.ListChildAccountsResponse>
      getListChildAccountsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.css.v1.ListChildAccountsRequest,
            com.google.shopping.css.v1.ListChildAccountsResponse>
        getListChildAccountsMethod;
    if ((getListChildAccountsMethod = AccountsServiceGrpc.getListChildAccountsMethod) == null) {
      synchronized (AccountsServiceGrpc.class) {
        if ((getListChildAccountsMethod = AccountsServiceGrpc.getListChildAccountsMethod) == null) {
          AccountsServiceGrpc.getListChildAccountsMethod =
              getListChildAccountsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.css.v1.ListChildAccountsRequest,
                          com.google.shopping.css.v1.ListChildAccountsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListChildAccounts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.css.v1.ListChildAccountsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.css.v1.ListChildAccountsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountsServiceMethodDescriptorSupplier("ListChildAccounts"))
                      .build();
        }
      }
    }
    return getListChildAccountsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.css.v1.GetAccountRequest, com.google.shopping.css.v1.Account>
      getGetAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccount",
      requestType = com.google.shopping.css.v1.GetAccountRequest.class,
      responseType = com.google.shopping.css.v1.Account.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.css.v1.GetAccountRequest, com.google.shopping.css.v1.Account>
      getGetAccountMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.css.v1.GetAccountRequest, com.google.shopping.css.v1.Account>
        getGetAccountMethod;
    if ((getGetAccountMethod = AccountsServiceGrpc.getGetAccountMethod) == null) {
      synchronized (AccountsServiceGrpc.class) {
        if ((getGetAccountMethod = AccountsServiceGrpc.getGetAccountMethod) == null) {
          AccountsServiceGrpc.getGetAccountMethod =
              getGetAccountMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.css.v1.GetAccountRequest,
                          com.google.shopping.css.v1.Account>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccount"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.css.v1.GetAccountRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.css.v1.Account.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountsServiceMethodDescriptorSupplier("GetAccount"))
                      .build();
        }
      }
    }
    return getGetAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.css.v1.UpdateAccountLabelsRequest, com.google.shopping.css.v1.Account>
      getUpdateLabelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateLabels",
      requestType = com.google.shopping.css.v1.UpdateAccountLabelsRequest.class,
      responseType = com.google.shopping.css.v1.Account.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.css.v1.UpdateAccountLabelsRequest, com.google.shopping.css.v1.Account>
      getUpdateLabelsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.css.v1.UpdateAccountLabelsRequest,
            com.google.shopping.css.v1.Account>
        getUpdateLabelsMethod;
    if ((getUpdateLabelsMethod = AccountsServiceGrpc.getUpdateLabelsMethod) == null) {
      synchronized (AccountsServiceGrpc.class) {
        if ((getUpdateLabelsMethod = AccountsServiceGrpc.getUpdateLabelsMethod) == null) {
          AccountsServiceGrpc.getUpdateLabelsMethod =
              getUpdateLabelsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.css.v1.UpdateAccountLabelsRequest,
                          com.google.shopping.css.v1.Account>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateLabels"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.css.v1.UpdateAccountLabelsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.css.v1.Account.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountsServiceMethodDescriptorSupplier("UpdateLabels"))
                      .build();
        }
      }
    }
    return getUpdateLabelsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AccountsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountsServiceStub>() {
          @java.lang.Override
          public AccountsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountsServiceStub(channel, callOptions);
          }
        };
    return AccountsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccountsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountsServiceBlockingStub>() {
          @java.lang.Override
          public AccountsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountsServiceBlockingStub(channel, callOptions);
          }
        };
    return AccountsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AccountsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountsServiceFutureStub>() {
          @java.lang.Override
          public AccountsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountsServiceFutureStub(channel, callOptions);
          }
        };
    return AccountsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing CSS/MC account information.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists all the accounts under the specified CSS account ID, and
     * optionally filters by label ID and account name.
     * </pre>
     */
    default void listChildAccounts(
        com.google.shopping.css.v1.ListChildAccountsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.css.v1.ListChildAccountsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListChildAccountsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a single CSS/MC account by ID.
     * </pre>
     */
    default void getAccount(
        com.google.shopping.css.v1.GetAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.css.v1.Account> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccountMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates labels assigned to CSS/MC accounts by a CSS domain.
     * </pre>
     */
    default void updateLabels(
        com.google.shopping.css.v1.UpdateAccountLabelsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.css.v1.Account> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateLabelsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AccountsService.
   *
   * <pre>
   * Service for managing CSS/MC account information.
   * </pre>
   */
  public abstract static class AccountsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AccountsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AccountsService.
   *
   * <pre>
   * Service for managing CSS/MC account information.
   * </pre>
   */
  public static final class AccountsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AccountsServiceStub> {
    private AccountsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountsServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all the accounts under the specified CSS account ID, and
     * optionally filters by label ID and account name.
     * </pre>
     */
    public void listChildAccounts(
        com.google.shopping.css.v1.ListChildAccountsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.css.v1.ListChildAccountsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListChildAccountsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a single CSS/MC account by ID.
     * </pre>
     */
    public void getAccount(
        com.google.shopping.css.v1.GetAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.css.v1.Account> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates labels assigned to CSS/MC accounts by a CSS domain.
     * </pre>
     */
    public void updateLabels(
        com.google.shopping.css.v1.UpdateAccountLabelsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.css.v1.Account> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateLabelsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AccountsService.
   *
   * <pre>
   * Service for managing CSS/MC account information.
   * </pre>
   */
  public static final class AccountsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AccountsServiceBlockingStub> {
    private AccountsServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all the accounts under the specified CSS account ID, and
     * optionally filters by label ID and account name.
     * </pre>
     */
    public com.google.shopping.css.v1.ListChildAccountsResponse listChildAccounts(
        com.google.shopping.css.v1.ListChildAccountsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListChildAccountsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a single CSS/MC account by ID.
     * </pre>
     */
    public com.google.shopping.css.v1.Account getAccount(
        com.google.shopping.css.v1.GetAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates labels assigned to CSS/MC accounts by a CSS domain.
     * </pre>
     */
    public com.google.shopping.css.v1.Account updateLabels(
        com.google.shopping.css.v1.UpdateAccountLabelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateLabelsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AccountsService.
   *
   * <pre>
   * Service for managing CSS/MC account information.
   * </pre>
   */
  public static final class AccountsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AccountsServiceFutureStub> {
    private AccountsServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all the accounts under the specified CSS account ID, and
     * optionally filters by label ID and account name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.css.v1.ListChildAccountsResponse>
        listChildAccounts(com.google.shopping.css.v1.ListChildAccountsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListChildAccountsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a single CSS/MC account by ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.shopping.css.v1.Account>
        getAccount(com.google.shopping.css.v1.GetAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates labels assigned to CSS/MC accounts by a CSS domain.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.shopping.css.v1.Account>
        updateLabels(com.google.shopping.css.v1.UpdateAccountLabelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateLabelsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CHILD_ACCOUNTS = 0;
  private static final int METHODID_GET_ACCOUNT = 1;
  private static final int METHODID_UPDATE_LABELS = 2;

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
        case METHODID_LIST_CHILD_ACCOUNTS:
          serviceImpl.listChildAccounts(
              (com.google.shopping.css.v1.ListChildAccountsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.css.v1.ListChildAccountsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ACCOUNT:
          serviceImpl.getAccount(
              (com.google.shopping.css.v1.GetAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.css.v1.Account>) responseObserver);
          break;
        case METHODID_UPDATE_LABELS:
          serviceImpl.updateLabels(
              (com.google.shopping.css.v1.UpdateAccountLabelsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.css.v1.Account>) responseObserver);
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
            getListChildAccountsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.css.v1.ListChildAccountsRequest,
                    com.google.shopping.css.v1.ListChildAccountsResponse>(
                    service, METHODID_LIST_CHILD_ACCOUNTS)))
        .addMethod(
            getGetAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.css.v1.GetAccountRequest,
                    com.google.shopping.css.v1.Account>(service, METHODID_GET_ACCOUNT)))
        .addMethod(
            getUpdateLabelsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.css.v1.UpdateAccountLabelsRequest,
                    com.google.shopping.css.v1.Account>(service, METHODID_UPDATE_LABELS)))
        .build();
  }

  private abstract static class AccountsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccountsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.css.v1.AccountsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AccountsService");
    }
  }

  private static final class AccountsServiceFileDescriptorSupplier
      extends AccountsServiceBaseDescriptorSupplier {
    AccountsServiceFileDescriptorSupplier() {}
  }

  private static final class AccountsServiceMethodDescriptorSupplier
      extends AccountsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AccountsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AccountsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AccountsServiceFileDescriptorSupplier())
                      .addMethod(getListChildAccountsMethod())
                      .addMethod(getGetAccountMethod())
                      .addMethod(getUpdateLabelsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
