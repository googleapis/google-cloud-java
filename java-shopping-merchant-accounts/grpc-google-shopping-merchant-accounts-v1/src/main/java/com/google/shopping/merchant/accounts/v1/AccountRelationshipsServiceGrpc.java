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
package com.google.shopping.merchant.accounts.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to support AccountRelationship API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1/accountrelationships.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AccountRelationshipsServiceGrpc {

  private AccountRelationshipsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1.AccountRelationshipsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.GetAccountRelationshipRequest,
          com.google.shopping.merchant.accounts.v1.AccountRelationship>
      getGetAccountRelationshipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccountRelationship",
      requestType = com.google.shopping.merchant.accounts.v1.GetAccountRelationshipRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1.AccountRelationship.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.GetAccountRelationshipRequest,
          com.google.shopping.merchant.accounts.v1.AccountRelationship>
      getGetAccountRelationshipMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.GetAccountRelationshipRequest,
            com.google.shopping.merchant.accounts.v1.AccountRelationship>
        getGetAccountRelationshipMethod;
    if ((getGetAccountRelationshipMethod =
            AccountRelationshipsServiceGrpc.getGetAccountRelationshipMethod)
        == null) {
      synchronized (AccountRelationshipsServiceGrpc.class) {
        if ((getGetAccountRelationshipMethod =
                AccountRelationshipsServiceGrpc.getGetAccountRelationshipMethod)
            == null) {
          AccountRelationshipsServiceGrpc.getGetAccountRelationshipMethod =
              getGetAccountRelationshipMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.GetAccountRelationshipRequest,
                          com.google.shopping.merchant.accounts.v1.AccountRelationship>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAccountRelationship"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.GetAccountRelationshipRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.AccountRelationship
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountRelationshipsServiceMethodDescriptorSupplier(
                              "GetAccountRelationship"))
                      .build();
        }
      }
    }
    return getGetAccountRelationshipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.UpdateAccountRelationshipRequest,
          com.google.shopping.merchant.accounts.v1.AccountRelationship>
      getUpdateAccountRelationshipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAccountRelationship",
      requestType = com.google.shopping.merchant.accounts.v1.UpdateAccountRelationshipRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1.AccountRelationship.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.UpdateAccountRelationshipRequest,
          com.google.shopping.merchant.accounts.v1.AccountRelationship>
      getUpdateAccountRelationshipMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.UpdateAccountRelationshipRequest,
            com.google.shopping.merchant.accounts.v1.AccountRelationship>
        getUpdateAccountRelationshipMethod;
    if ((getUpdateAccountRelationshipMethod =
            AccountRelationshipsServiceGrpc.getUpdateAccountRelationshipMethod)
        == null) {
      synchronized (AccountRelationshipsServiceGrpc.class) {
        if ((getUpdateAccountRelationshipMethod =
                AccountRelationshipsServiceGrpc.getUpdateAccountRelationshipMethod)
            == null) {
          AccountRelationshipsServiceGrpc.getUpdateAccountRelationshipMethod =
              getUpdateAccountRelationshipMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.UpdateAccountRelationshipRequest,
                          com.google.shopping.merchant.accounts.v1.AccountRelationship>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateAccountRelationship"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1
                                  .UpdateAccountRelationshipRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.AccountRelationship
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountRelationshipsServiceMethodDescriptorSupplier(
                              "UpdateAccountRelationship"))
                      .build();
        }
      }
    }
    return getUpdateAccountRelationshipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsRequest,
          com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsResponse>
      getListAccountRelationshipsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAccountRelationships",
      requestType = com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsRequest.class,
      responseType =
          com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsRequest,
          com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsResponse>
      getListAccountRelationshipsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsRequest,
            com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsResponse>
        getListAccountRelationshipsMethod;
    if ((getListAccountRelationshipsMethod =
            AccountRelationshipsServiceGrpc.getListAccountRelationshipsMethod)
        == null) {
      synchronized (AccountRelationshipsServiceGrpc.class) {
        if ((getListAccountRelationshipsMethod =
                AccountRelationshipsServiceGrpc.getListAccountRelationshipsMethod)
            == null) {
          AccountRelationshipsServiceGrpc.getListAccountRelationshipsMethod =
              getListAccountRelationshipsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsRequest,
                          com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAccountRelationships"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1
                                  .ListAccountRelationshipsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1
                                  .ListAccountRelationshipsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountRelationshipsServiceMethodDescriptorSupplier(
                              "ListAccountRelationships"))
                      .build();
        }
      }
    }
    return getListAccountRelationshipsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AccountRelationshipsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountRelationshipsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountRelationshipsServiceStub>() {
          @java.lang.Override
          public AccountRelationshipsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountRelationshipsServiceStub(channel, callOptions);
          }
        };
    return AccountRelationshipsServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static AccountRelationshipsServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountRelationshipsServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountRelationshipsServiceBlockingV2Stub>() {
          @java.lang.Override
          public AccountRelationshipsServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountRelationshipsServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return AccountRelationshipsServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccountRelationshipsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountRelationshipsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountRelationshipsServiceBlockingStub>() {
          @java.lang.Override
          public AccountRelationshipsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountRelationshipsServiceBlockingStub(channel, callOptions);
          }
        };
    return AccountRelationshipsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AccountRelationshipsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountRelationshipsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountRelationshipsServiceFutureStub>() {
          @java.lang.Override
          public AccountRelationshipsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountRelationshipsServiceFutureStub(channel, callOptions);
          }
        };
    return AccountRelationshipsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to support AccountRelationship API.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieve an account relationship.
     * </pre>
     */
    default void getAccountRelationship(
        com.google.shopping.merchant.accounts.v1.GetAccountRelationshipRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.AccountRelationship>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAccountRelationshipMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the account relationship. Executing this method requires admin
     * access.
     * </pre>
     */
    default void updateAccountRelationship(
        com.google.shopping.merchant.accounts.v1.UpdateAccountRelationshipRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.AccountRelationship>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAccountRelationshipMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List account relationships for the specified account.
     * </pre>
     */
    default void listAccountRelationships(
        com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAccountRelationshipsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AccountRelationshipsService.
   *
   * <pre>
   * Service to support AccountRelationship API.
   * </pre>
   */
  public abstract static class AccountRelationshipsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AccountRelationshipsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AccountRelationshipsService.
   *
   * <pre>
   * Service to support AccountRelationship API.
   * </pre>
   */
  public static final class AccountRelationshipsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AccountRelationshipsServiceStub> {
    private AccountRelationshipsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountRelationshipsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountRelationshipsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve an account relationship.
     * </pre>
     */
    public void getAccountRelationship(
        com.google.shopping.merchant.accounts.v1.GetAccountRelationshipRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.AccountRelationship>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccountRelationshipMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the account relationship. Executing this method requires admin
     * access.
     * </pre>
     */
    public void updateAccountRelationship(
        com.google.shopping.merchant.accounts.v1.UpdateAccountRelationshipRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.AccountRelationship>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAccountRelationshipMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List account relationships for the specified account.
     * </pre>
     */
    public void listAccountRelationships(
        com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAccountRelationshipsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AccountRelationshipsService.
   *
   * <pre>
   * Service to support AccountRelationship API.
   * </pre>
   */
  public static final class AccountRelationshipsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AccountRelationshipsServiceBlockingV2Stub> {
    private AccountRelationshipsServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountRelationshipsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountRelationshipsServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve an account relationship.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.AccountRelationship getAccountRelationship(
        com.google.shopping.merchant.accounts.v1.GetAccountRelationshipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountRelationshipMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the account relationship. Executing this method requires admin
     * access.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.AccountRelationship updateAccountRelationship(
        com.google.shopping.merchant.accounts.v1.UpdateAccountRelationshipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAccountRelationshipMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List account relationships for the specified account.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsResponse
        listAccountRelationships(
            com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAccountRelationshipsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * AccountRelationshipsService.
   *
   * <pre>
   * Service to support AccountRelationship API.
   * </pre>
   */
  public static final class AccountRelationshipsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AccountRelationshipsServiceBlockingStub> {
    private AccountRelationshipsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountRelationshipsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountRelationshipsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve an account relationship.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.AccountRelationship getAccountRelationship(
        com.google.shopping.merchant.accounts.v1.GetAccountRelationshipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountRelationshipMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the account relationship. Executing this method requires admin
     * access.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.AccountRelationship updateAccountRelationship(
        com.google.shopping.merchant.accounts.v1.UpdateAccountRelationshipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAccountRelationshipMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List account relationships for the specified account.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsResponse
        listAccountRelationships(
            com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAccountRelationshipsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * AccountRelationshipsService.
   *
   * <pre>
   * Service to support AccountRelationship API.
   * </pre>
   */
  public static final class AccountRelationshipsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AccountRelationshipsServiceFutureStub> {
    private AccountRelationshipsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountRelationshipsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountRelationshipsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve an account relationship.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1.AccountRelationship>
        getAccountRelationship(
            com.google.shopping.merchant.accounts.v1.GetAccountRelationshipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccountRelationshipMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the account relationship. Executing this method requires admin
     * access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1.AccountRelationship>
        updateAccountRelationship(
            com.google.shopping.merchant.accounts.v1.UpdateAccountRelationshipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAccountRelationshipMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List account relationships for the specified account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsResponse>
        listAccountRelationships(
            com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAccountRelationshipsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ACCOUNT_RELATIONSHIP = 0;
  private static final int METHODID_UPDATE_ACCOUNT_RELATIONSHIP = 1;
  private static final int METHODID_LIST_ACCOUNT_RELATIONSHIPS = 2;

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
        case METHODID_GET_ACCOUNT_RELATIONSHIP:
          serviceImpl.getAccountRelationship(
              (com.google.shopping.merchant.accounts.v1.GetAccountRelationshipRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1.AccountRelationship>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ACCOUNT_RELATIONSHIP:
          serviceImpl.updateAccountRelationship(
              (com.google.shopping.merchant.accounts.v1.UpdateAccountRelationshipRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1.AccountRelationship>)
                  responseObserver);
          break;
        case METHODID_LIST_ACCOUNT_RELATIONSHIPS:
          serviceImpl.listAccountRelationships(
              (com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsResponse>)
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
            getGetAccountRelationshipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.GetAccountRelationshipRequest,
                    com.google.shopping.merchant.accounts.v1.AccountRelationship>(
                    service, METHODID_GET_ACCOUNT_RELATIONSHIP)))
        .addMethod(
            getUpdateAccountRelationshipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.UpdateAccountRelationshipRequest,
                    com.google.shopping.merchant.accounts.v1.AccountRelationship>(
                    service, METHODID_UPDATE_ACCOUNT_RELATIONSHIP)))
        .addMethod(
            getListAccountRelationshipsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsRequest,
                    com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsResponse>(
                    service, METHODID_LIST_ACCOUNT_RELATIONSHIPS)))
        .build();
  }

  private abstract static class AccountRelationshipsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccountRelationshipsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1.AccountRelationshipsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AccountRelationshipsService");
    }
  }

  private static final class AccountRelationshipsServiceFileDescriptorSupplier
      extends AccountRelationshipsServiceBaseDescriptorSupplier {
    AccountRelationshipsServiceFileDescriptorSupplier() {}
  }

  private static final class AccountRelationshipsServiceMethodDescriptorSupplier
      extends AccountRelationshipsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AccountRelationshipsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AccountRelationshipsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AccountRelationshipsServiceFileDescriptorSupplier())
                      .addMethod(getGetAccountRelationshipMethod())
                      .addMethod(getUpdateAccountRelationshipMethod())
                      .addMethod(getListAccountRelationshipsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
