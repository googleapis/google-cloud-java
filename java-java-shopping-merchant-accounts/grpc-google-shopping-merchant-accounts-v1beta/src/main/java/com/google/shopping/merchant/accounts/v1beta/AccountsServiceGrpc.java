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
 * Service to support Accounts API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1beta/accounts.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AccountsServiceGrpc {

  private AccountsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1beta.AccountsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetAccountRequest,
          com.google.shopping.merchant.accounts.v1beta.Account>
      getGetAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccount",
      requestType = com.google.shopping.merchant.accounts.v1beta.GetAccountRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.Account.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetAccountRequest,
          com.google.shopping.merchant.accounts.v1beta.Account>
      getGetAccountMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.GetAccountRequest,
            com.google.shopping.merchant.accounts.v1beta.Account>
        getGetAccountMethod;
    if ((getGetAccountMethod = AccountsServiceGrpc.getGetAccountMethod) == null) {
      synchronized (AccountsServiceGrpc.class) {
        if ((getGetAccountMethod = AccountsServiceGrpc.getGetAccountMethod) == null) {
          AccountsServiceGrpc.getGetAccountMethod =
              getGetAccountMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.GetAccountRequest,
                          com.google.shopping.merchant.accounts.v1beta.Account>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccount"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.GetAccountRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.Account
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountsServiceMethodDescriptorSupplier("GetAccount"))
                      .build();
        }
      }
    }
    return getGetAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.CreateAndConfigureAccountRequest,
          com.google.shopping.merchant.accounts.v1beta.Account>
      getCreateAndConfigureAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAndConfigureAccount",
      requestType =
          com.google.shopping.merchant.accounts.v1beta.CreateAndConfigureAccountRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.Account.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.CreateAndConfigureAccountRequest,
          com.google.shopping.merchant.accounts.v1beta.Account>
      getCreateAndConfigureAccountMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.CreateAndConfigureAccountRequest,
            com.google.shopping.merchant.accounts.v1beta.Account>
        getCreateAndConfigureAccountMethod;
    if ((getCreateAndConfigureAccountMethod =
            AccountsServiceGrpc.getCreateAndConfigureAccountMethod)
        == null) {
      synchronized (AccountsServiceGrpc.class) {
        if ((getCreateAndConfigureAccountMethod =
                AccountsServiceGrpc.getCreateAndConfigureAccountMethod)
            == null) {
          AccountsServiceGrpc.getCreateAndConfigureAccountMethod =
              getCreateAndConfigureAccountMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta
                              .CreateAndConfigureAccountRequest,
                          com.google.shopping.merchant.accounts.v1beta.Account>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateAndConfigureAccount"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .CreateAndConfigureAccountRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.Account
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountsServiceMethodDescriptorSupplier("CreateAndConfigureAccount"))
                      .build();
        }
      }
    }
    return getCreateAndConfigureAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.DeleteAccountRequest,
          com.google.protobuf.Empty>
      getDeleteAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAccount",
      requestType = com.google.shopping.merchant.accounts.v1beta.DeleteAccountRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.DeleteAccountRequest,
          com.google.protobuf.Empty>
      getDeleteAccountMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.DeleteAccountRequest,
            com.google.protobuf.Empty>
        getDeleteAccountMethod;
    if ((getDeleteAccountMethod = AccountsServiceGrpc.getDeleteAccountMethod) == null) {
      synchronized (AccountsServiceGrpc.class) {
        if ((getDeleteAccountMethod = AccountsServiceGrpc.getDeleteAccountMethod) == null) {
          AccountsServiceGrpc.getDeleteAccountMethod =
              getDeleteAccountMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.DeleteAccountRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAccount"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.DeleteAccountRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountsServiceMethodDescriptorSupplier("DeleteAccount"))
                      .build();
        }
      }
    }
    return getDeleteAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateAccountRequest,
          com.google.shopping.merchant.accounts.v1beta.Account>
      getUpdateAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAccount",
      requestType = com.google.shopping.merchant.accounts.v1beta.UpdateAccountRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.Account.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateAccountRequest,
          com.google.shopping.merchant.accounts.v1beta.Account>
      getUpdateAccountMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.UpdateAccountRequest,
            com.google.shopping.merchant.accounts.v1beta.Account>
        getUpdateAccountMethod;
    if ((getUpdateAccountMethod = AccountsServiceGrpc.getUpdateAccountMethod) == null) {
      synchronized (AccountsServiceGrpc.class) {
        if ((getUpdateAccountMethod = AccountsServiceGrpc.getUpdateAccountMethod) == null) {
          AccountsServiceGrpc.getUpdateAccountMethod =
              getUpdateAccountMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.UpdateAccountRequest,
                          com.google.shopping.merchant.accounts.v1beta.Account>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAccount"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.UpdateAccountRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.Account
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountsServiceMethodDescriptorSupplier("UpdateAccount"))
                      .build();
        }
      }
    }
    return getUpdateAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ListAccountsRequest,
          com.google.shopping.merchant.accounts.v1beta.ListAccountsResponse>
      getListAccountsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAccounts",
      requestType = com.google.shopping.merchant.accounts.v1beta.ListAccountsRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.ListAccountsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ListAccountsRequest,
          com.google.shopping.merchant.accounts.v1beta.ListAccountsResponse>
      getListAccountsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.ListAccountsRequest,
            com.google.shopping.merchant.accounts.v1beta.ListAccountsResponse>
        getListAccountsMethod;
    if ((getListAccountsMethod = AccountsServiceGrpc.getListAccountsMethod) == null) {
      synchronized (AccountsServiceGrpc.class) {
        if ((getListAccountsMethod = AccountsServiceGrpc.getListAccountsMethod) == null) {
          AccountsServiceGrpc.getListAccountsMethod =
              getListAccountsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.ListAccountsRequest,
                          com.google.shopping.merchant.accounts.v1beta.ListAccountsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAccounts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.ListAccountsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.ListAccountsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountsServiceMethodDescriptorSupplier("ListAccounts"))
                      .build();
        }
      }
    }
    return getListAccountsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ListSubAccountsRequest,
          com.google.shopping.merchant.accounts.v1beta.ListSubAccountsResponse>
      getListSubAccountsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSubAccounts",
      requestType = com.google.shopping.merchant.accounts.v1beta.ListSubAccountsRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.ListSubAccountsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ListSubAccountsRequest,
          com.google.shopping.merchant.accounts.v1beta.ListSubAccountsResponse>
      getListSubAccountsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.ListSubAccountsRequest,
            com.google.shopping.merchant.accounts.v1beta.ListSubAccountsResponse>
        getListSubAccountsMethod;
    if ((getListSubAccountsMethod = AccountsServiceGrpc.getListSubAccountsMethod) == null) {
      synchronized (AccountsServiceGrpc.class) {
        if ((getListSubAccountsMethod = AccountsServiceGrpc.getListSubAccountsMethod) == null) {
          AccountsServiceGrpc.getListSubAccountsMethod =
              getListSubAccountsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.ListSubAccountsRequest,
                          com.google.shopping.merchant.accounts.v1beta.ListSubAccountsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSubAccounts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.ListSubAccountsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.ListSubAccountsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountsServiceMethodDescriptorSupplier("ListSubAccounts"))
                      .build();
        }
      }
    }
    return getListSubAccountsMethod;
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
   * Service to support Accounts API.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves an account from your Merchant Center account.
     * After inserting, updating, or deleting an account, it may take several
     * minutes before changes take effect.
     * </pre>
     */
    default void getAccount(
        com.google.shopping.merchant.accounts.v1beta.GetAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Account>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccountMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a standalone Merchant Center account with additional configuration.
     * Adds the user that makes the request as an admin for the new account.
     * </pre>
     */
    default void createAndConfigureAccount(
        com.google.shopping.merchant.accounts.v1beta.CreateAndConfigureAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Account>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAndConfigureAccountMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified account regardless of its type: standalone, MCA or
     * sub-account. Deleting an MCA leads to the deletion of all of its
     * sub-accounts. Executing this method requires admin access.
     * </pre>
     */
    default void deleteAccount(
        com.google.shopping.merchant.accounts.v1beta.DeleteAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAccountMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an account regardless of its type: standalone, MCA or sub-account.
     * Executing this method requires admin access.
     * </pre>
     */
    default void updateAccount(
        com.google.shopping.merchant.accounts.v1beta.UpdateAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Account>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAccountMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists accounts accessible to the calling user and matching the
     * constraints of the request such as page size or filters.
     * This is not just listing the sub-accounts of an MCA, but all accounts the
     * calling user has access to including other MCAs, linked accounts,
     * standalone accounts and so on.
     * </pre>
     */
    default void listAccounts(
        com.google.shopping.merchant.accounts.v1beta.ListAccountsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.ListAccountsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAccountsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all sub-accounts for a given multi client account. This is a
     * convenience wrapper for the more powerful `ListAccounts` method. This
     * method will produce the same results as calling `ListsAccounts` with the
     * following filter:
     * `relationship(providerId={parent} AND service(type="ACCOUNT_AGGREGATION"))`
     * </pre>
     */
    default void listSubAccounts(
        com.google.shopping.merchant.accounts.v1beta.ListSubAccountsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.ListSubAccountsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSubAccountsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AccountsService.
   *
   * <pre>
   * Service to support Accounts API.
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
   * Service to support Accounts API.
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
     * Retrieves an account from your Merchant Center account.
     * After inserting, updating, or deleting an account, it may take several
     * minutes before changes take effect.
     * </pre>
     */
    public void getAccount(
        com.google.shopping.merchant.accounts.v1beta.GetAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Account>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a standalone Merchant Center account with additional configuration.
     * Adds the user that makes the request as an admin for the new account.
     * </pre>
     */
    public void createAndConfigureAccount(
        com.google.shopping.merchant.accounts.v1beta.CreateAndConfigureAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Account>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAndConfigureAccountMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified account regardless of its type: standalone, MCA or
     * sub-account. Deleting an MCA leads to the deletion of all of its
     * sub-accounts. Executing this method requires admin access.
     * </pre>
     */
    public void deleteAccount(
        com.google.shopping.merchant.accounts.v1beta.DeleteAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAccountMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an account regardless of its type: standalone, MCA or sub-account.
     * Executing this method requires admin access.
     * </pre>
     */
    public void updateAccount(
        com.google.shopping.merchant.accounts.v1beta.UpdateAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Account>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAccountMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists accounts accessible to the calling user and matching the
     * constraints of the request such as page size or filters.
     * This is not just listing the sub-accounts of an MCA, but all accounts the
     * calling user has access to including other MCAs, linked accounts,
     * standalone accounts and so on.
     * </pre>
     */
    public void listAccounts(
        com.google.shopping.merchant.accounts.v1beta.ListAccountsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.ListAccountsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAccountsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all sub-accounts for a given multi client account. This is a
     * convenience wrapper for the more powerful `ListAccounts` method. This
     * method will produce the same results as calling `ListsAccounts` with the
     * following filter:
     * `relationship(providerId={parent} AND service(type="ACCOUNT_AGGREGATION"))`
     * </pre>
     */
    public void listSubAccounts(
        com.google.shopping.merchant.accounts.v1beta.ListSubAccountsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.ListSubAccountsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSubAccountsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AccountsService.
   *
   * <pre>
   * Service to support Accounts API.
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
     * Retrieves an account from your Merchant Center account.
     * After inserting, updating, or deleting an account, it may take several
     * minutes before changes take effect.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.Account getAccount(
        com.google.shopping.merchant.accounts.v1beta.GetAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a standalone Merchant Center account with additional configuration.
     * Adds the user that makes the request as an admin for the new account.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.Account createAndConfigureAccount(
        com.google.shopping.merchant.accounts.v1beta.CreateAndConfigureAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAndConfigureAccountMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified account regardless of its type: standalone, MCA or
     * sub-account. Deleting an MCA leads to the deletion of all of its
     * sub-accounts. Executing this method requires admin access.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAccount(
        com.google.shopping.merchant.accounts.v1beta.DeleteAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAccountMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an account regardless of its type: standalone, MCA or sub-account.
     * Executing this method requires admin access.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.Account updateAccount(
        com.google.shopping.merchant.accounts.v1beta.UpdateAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAccountMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists accounts accessible to the calling user and matching the
     * constraints of the request such as page size or filters.
     * This is not just listing the sub-accounts of an MCA, but all accounts the
     * calling user has access to including other MCAs, linked accounts,
     * standalone accounts and so on.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.ListAccountsResponse listAccounts(
        com.google.shopping.merchant.accounts.v1beta.ListAccountsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAccountsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all sub-accounts for a given multi client account. This is a
     * convenience wrapper for the more powerful `ListAccounts` method. This
     * method will produce the same results as calling `ListsAccounts` with the
     * following filter:
     * `relationship(providerId={parent} AND service(type="ACCOUNT_AGGREGATION"))`
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.ListSubAccountsResponse listSubAccounts(
        com.google.shopping.merchant.accounts.v1beta.ListSubAccountsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSubAccountsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AccountsService.
   *
   * <pre>
   * Service to support Accounts API.
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
     * Retrieves an account from your Merchant Center account.
     * After inserting, updating, or deleting an account, it may take several
     * minutes before changes take effect.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.Account>
        getAccount(com.google.shopping.merchant.accounts.v1beta.GetAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a standalone Merchant Center account with additional configuration.
     * Adds the user that makes the request as an admin for the new account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.Account>
        createAndConfigureAccount(
            com.google.shopping.merchant.accounts.v1beta.CreateAndConfigureAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAndConfigureAccountMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified account regardless of its type: standalone, MCA or
     * sub-account. Deleting an MCA leads to the deletion of all of its
     * sub-accounts. Executing this method requires admin access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAccount(com.google.shopping.merchant.accounts.v1beta.DeleteAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAccountMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an account regardless of its type: standalone, MCA or sub-account.
     * Executing this method requires admin access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.Account>
        updateAccount(com.google.shopping.merchant.accounts.v1beta.UpdateAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAccountMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists accounts accessible to the calling user and matching the
     * constraints of the request such as page size or filters.
     * This is not just listing the sub-accounts of an MCA, but all accounts the
     * calling user has access to including other MCAs, linked accounts,
     * standalone accounts and so on.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.ListAccountsResponse>
        listAccounts(com.google.shopping.merchant.accounts.v1beta.ListAccountsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAccountsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all sub-accounts for a given multi client account. This is a
     * convenience wrapper for the more powerful `ListAccounts` method. This
     * method will produce the same results as calling `ListsAccounts` with the
     * following filter:
     * `relationship(providerId={parent} AND service(type="ACCOUNT_AGGREGATION"))`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.ListSubAccountsResponse>
        listSubAccounts(
            com.google.shopping.merchant.accounts.v1beta.ListSubAccountsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSubAccountsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ACCOUNT = 0;
  private static final int METHODID_CREATE_AND_CONFIGURE_ACCOUNT = 1;
  private static final int METHODID_DELETE_ACCOUNT = 2;
  private static final int METHODID_UPDATE_ACCOUNT = 3;
  private static final int METHODID_LIST_ACCOUNTS = 4;
  private static final int METHODID_LIST_SUB_ACCOUNTS = 5;

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
        case METHODID_GET_ACCOUNT:
          serviceImpl.getAccount(
              (com.google.shopping.merchant.accounts.v1beta.GetAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Account>)
                  responseObserver);
          break;
        case METHODID_CREATE_AND_CONFIGURE_ACCOUNT:
          serviceImpl.createAndConfigureAccount(
              (com.google.shopping.merchant.accounts.v1beta.CreateAndConfigureAccountRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Account>)
                  responseObserver);
          break;
        case METHODID_DELETE_ACCOUNT:
          serviceImpl.deleteAccount(
              (com.google.shopping.merchant.accounts.v1beta.DeleteAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_ACCOUNT:
          serviceImpl.updateAccount(
              (com.google.shopping.merchant.accounts.v1beta.UpdateAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Account>)
                  responseObserver);
          break;
        case METHODID_LIST_ACCOUNTS:
          serviceImpl.listAccounts(
              (com.google.shopping.merchant.accounts.v1beta.ListAccountsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.ListAccountsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_SUB_ACCOUNTS:
          serviceImpl.listSubAccounts(
              (com.google.shopping.merchant.accounts.v1beta.ListSubAccountsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.ListSubAccountsResponse>)
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
            getGetAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.GetAccountRequest,
                    com.google.shopping.merchant.accounts.v1beta.Account>(
                    service, METHODID_GET_ACCOUNT)))
        .addMethod(
            getCreateAndConfigureAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.CreateAndConfigureAccountRequest,
                    com.google.shopping.merchant.accounts.v1beta.Account>(
                    service, METHODID_CREATE_AND_CONFIGURE_ACCOUNT)))
        .addMethod(
            getDeleteAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.DeleteAccountRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_ACCOUNT)))
        .addMethod(
            getUpdateAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.UpdateAccountRequest,
                    com.google.shopping.merchant.accounts.v1beta.Account>(
                    service, METHODID_UPDATE_ACCOUNT)))
        .addMethod(
            getListAccountsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.ListAccountsRequest,
                    com.google.shopping.merchant.accounts.v1beta.ListAccountsResponse>(
                    service, METHODID_LIST_ACCOUNTS)))
        .addMethod(
            getListSubAccountsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.ListSubAccountsRequest,
                    com.google.shopping.merchant.accounts.v1beta.ListSubAccountsResponse>(
                    service, METHODID_LIST_SUB_ACCOUNTS)))
        .build();
  }

  private abstract static class AccountsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccountsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1beta.AccountsProto.getDescriptor();
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
                      .addMethod(getGetAccountMethod())
                      .addMethod(getCreateAndConfigureAccountMethod())
                      .addMethod(getDeleteAccountMethod())
                      .addMethod(getUpdateAccountMethod())
                      .addMethod(getListAccountsMethod())
                      .addMethod(getListSubAccountsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
