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
 * Service to support AccountService API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1/accountservices.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AccountServicesServiceGrpc {

  private AccountServicesServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1.AccountServicesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.GetAccountServiceRequest,
          com.google.shopping.merchant.accounts.v1.AccountService>
      getGetAccountServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccountService",
      requestType = com.google.shopping.merchant.accounts.v1.GetAccountServiceRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1.AccountService.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.GetAccountServiceRequest,
          com.google.shopping.merchant.accounts.v1.AccountService>
      getGetAccountServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.GetAccountServiceRequest,
            com.google.shopping.merchant.accounts.v1.AccountService>
        getGetAccountServiceMethod;
    if ((getGetAccountServiceMethod = AccountServicesServiceGrpc.getGetAccountServiceMethod)
        == null) {
      synchronized (AccountServicesServiceGrpc.class) {
        if ((getGetAccountServiceMethod = AccountServicesServiceGrpc.getGetAccountServiceMethod)
            == null) {
          AccountServicesServiceGrpc.getGetAccountServiceMethod =
              getGetAccountServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.GetAccountServiceRequest,
                          com.google.shopping.merchant.accounts.v1.AccountService>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccountService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.GetAccountServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.AccountService
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountServicesServiceMethodDescriptorSupplier("GetAccountService"))
                      .build();
        }
      }
    }
    return getGetAccountServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.ListAccountServicesRequest,
          com.google.shopping.merchant.accounts.v1.ListAccountServicesResponse>
      getListAccountServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAccountServices",
      requestType = com.google.shopping.merchant.accounts.v1.ListAccountServicesRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1.ListAccountServicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.ListAccountServicesRequest,
          com.google.shopping.merchant.accounts.v1.ListAccountServicesResponse>
      getListAccountServicesMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.ListAccountServicesRequest,
            com.google.shopping.merchant.accounts.v1.ListAccountServicesResponse>
        getListAccountServicesMethod;
    if ((getListAccountServicesMethod = AccountServicesServiceGrpc.getListAccountServicesMethod)
        == null) {
      synchronized (AccountServicesServiceGrpc.class) {
        if ((getListAccountServicesMethod = AccountServicesServiceGrpc.getListAccountServicesMethod)
            == null) {
          AccountServicesServiceGrpc.getListAccountServicesMethod =
              getListAccountServicesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.ListAccountServicesRequest,
                          com.google.shopping.merchant.accounts.v1.ListAccountServicesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAccountServices"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.ListAccountServicesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.ListAccountServicesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountServicesServiceMethodDescriptorSupplier("ListAccountServices"))
                      .build();
        }
      }
    }
    return getListAccountServicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.ProposeAccountServiceRequest,
          com.google.shopping.merchant.accounts.v1.AccountService>
      getProposeAccountServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProposeAccountService",
      requestType = com.google.shopping.merchant.accounts.v1.ProposeAccountServiceRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1.AccountService.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.ProposeAccountServiceRequest,
          com.google.shopping.merchant.accounts.v1.AccountService>
      getProposeAccountServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.ProposeAccountServiceRequest,
            com.google.shopping.merchant.accounts.v1.AccountService>
        getProposeAccountServiceMethod;
    if ((getProposeAccountServiceMethod = AccountServicesServiceGrpc.getProposeAccountServiceMethod)
        == null) {
      synchronized (AccountServicesServiceGrpc.class) {
        if ((getProposeAccountServiceMethod =
                AccountServicesServiceGrpc.getProposeAccountServiceMethod)
            == null) {
          AccountServicesServiceGrpc.getProposeAccountServiceMethod =
              getProposeAccountServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.ProposeAccountServiceRequest,
                          com.google.shopping.merchant.accounts.v1.AccountService>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ProposeAccountService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.ProposeAccountServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.AccountService
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountServicesServiceMethodDescriptorSupplier(
                              "ProposeAccountService"))
                      .build();
        }
      }
    }
    return getProposeAccountServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.ApproveAccountServiceRequest,
          com.google.shopping.merchant.accounts.v1.AccountService>
      getApproveAccountServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ApproveAccountService",
      requestType = com.google.shopping.merchant.accounts.v1.ApproveAccountServiceRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1.AccountService.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.ApproveAccountServiceRequest,
          com.google.shopping.merchant.accounts.v1.AccountService>
      getApproveAccountServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.ApproveAccountServiceRequest,
            com.google.shopping.merchant.accounts.v1.AccountService>
        getApproveAccountServiceMethod;
    if ((getApproveAccountServiceMethod = AccountServicesServiceGrpc.getApproveAccountServiceMethod)
        == null) {
      synchronized (AccountServicesServiceGrpc.class) {
        if ((getApproveAccountServiceMethod =
                AccountServicesServiceGrpc.getApproveAccountServiceMethod)
            == null) {
          AccountServicesServiceGrpc.getApproveAccountServiceMethod =
              getApproveAccountServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.ApproveAccountServiceRequest,
                          com.google.shopping.merchant.accounts.v1.AccountService>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ApproveAccountService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.ApproveAccountServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.AccountService
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountServicesServiceMethodDescriptorSupplier(
                              "ApproveAccountService"))
                      .build();
        }
      }
    }
    return getApproveAccountServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.RejectAccountServiceRequest,
          com.google.protobuf.Empty>
      getRejectAccountServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RejectAccountService",
      requestType = com.google.shopping.merchant.accounts.v1.RejectAccountServiceRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.RejectAccountServiceRequest,
          com.google.protobuf.Empty>
      getRejectAccountServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.RejectAccountServiceRequest,
            com.google.protobuf.Empty>
        getRejectAccountServiceMethod;
    if ((getRejectAccountServiceMethod = AccountServicesServiceGrpc.getRejectAccountServiceMethod)
        == null) {
      synchronized (AccountServicesServiceGrpc.class) {
        if ((getRejectAccountServiceMethod =
                AccountServicesServiceGrpc.getRejectAccountServiceMethod)
            == null) {
          AccountServicesServiceGrpc.getRejectAccountServiceMethod =
              getRejectAccountServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.RejectAccountServiceRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RejectAccountService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.RejectAccountServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountServicesServiceMethodDescriptorSupplier(
                              "RejectAccountService"))
                      .build();
        }
      }
    }
    return getRejectAccountServiceMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AccountServicesServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountServicesServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountServicesServiceStub>() {
          @java.lang.Override
          public AccountServicesServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountServicesServiceStub(channel, callOptions);
          }
        };
    return AccountServicesServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static AccountServicesServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountServicesServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountServicesServiceBlockingV2Stub>() {
          @java.lang.Override
          public AccountServicesServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountServicesServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return AccountServicesServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccountServicesServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountServicesServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountServicesServiceBlockingStub>() {
          @java.lang.Override
          public AccountServicesServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountServicesServiceBlockingStub(channel, callOptions);
          }
        };
    return AccountServicesServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AccountServicesServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountServicesServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountServicesServiceFutureStub>() {
          @java.lang.Override
          public AccountServicesServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountServicesServiceFutureStub(channel, callOptions);
          }
        };
    return AccountServicesServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to support AccountService API.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieve an account service.
     * </pre>
     */
    default void getAccountService(
        com.google.shopping.merchant.accounts.v1.GetAccountServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.AccountService>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAccountServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List account services for the specified accounts. Supports filtering.
     * </pre>
     */
    default void listAccountServices(
        com.google.shopping.merchant.accounts.v1.ListAccountServicesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1.ListAccountServicesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAccountServicesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Propose an account service.
     * </pre>
     */
    default void proposeAccountService(
        com.google.shopping.merchant.accounts.v1.ProposeAccountServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.AccountService>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getProposeAccountServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Approve an account service proposal.
     * </pre>
     */
    default void approveAccountService(
        com.google.shopping.merchant.accounts.v1.ApproveAccountServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.AccountService>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getApproveAccountServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reject an account service (both proposed and approve services can be
     * rejected).
     * </pre>
     */
    default void rejectAccountService(
        com.google.shopping.merchant.accounts.v1.RejectAccountServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRejectAccountServiceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AccountServicesService.
   *
   * <pre>
   * Service to support AccountService API.
   * </pre>
   */
  public abstract static class AccountServicesServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AccountServicesServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AccountServicesService.
   *
   * <pre>
   * Service to support AccountService API.
   * </pre>
   */
  public static final class AccountServicesServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AccountServicesServiceStub> {
    private AccountServicesServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountServicesServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountServicesServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve an account service.
     * </pre>
     */
    public void getAccountService(
        com.google.shopping.merchant.accounts.v1.GetAccountServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.AccountService>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccountServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List account services for the specified accounts. Supports filtering.
     * </pre>
     */
    public void listAccountServices(
        com.google.shopping.merchant.accounts.v1.ListAccountServicesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1.ListAccountServicesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAccountServicesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Propose an account service.
     * </pre>
     */
    public void proposeAccountService(
        com.google.shopping.merchant.accounts.v1.ProposeAccountServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.AccountService>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProposeAccountServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Approve an account service proposal.
     * </pre>
     */
    public void approveAccountService(
        com.google.shopping.merchant.accounts.v1.ApproveAccountServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.AccountService>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getApproveAccountServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reject an account service (both proposed and approve services can be
     * rejected).
     * </pre>
     */
    public void rejectAccountService(
        com.google.shopping.merchant.accounts.v1.RejectAccountServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRejectAccountServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AccountServicesService.
   *
   * <pre>
   * Service to support AccountService API.
   * </pre>
   */
  public static final class AccountServicesServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AccountServicesServiceBlockingV2Stub> {
    private AccountServicesServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountServicesServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountServicesServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve an account service.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.AccountService getAccountService(
        com.google.shopping.merchant.accounts.v1.GetAccountServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List account services for the specified accounts. Supports filtering.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.ListAccountServicesResponse listAccountServices(
        com.google.shopping.merchant.accounts.v1.ListAccountServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAccountServicesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Propose an account service.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.AccountService proposeAccountService(
        com.google.shopping.merchant.accounts.v1.ProposeAccountServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProposeAccountServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Approve an account service proposal.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.AccountService approveAccountService(
        com.google.shopping.merchant.accounts.v1.ApproveAccountServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getApproveAccountServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reject an account service (both proposed and approve services can be
     * rejected).
     * </pre>
     */
    public com.google.protobuf.Empty rejectAccountService(
        com.google.shopping.merchant.accounts.v1.RejectAccountServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRejectAccountServiceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AccountServicesService.
   *
   * <pre>
   * Service to support AccountService API.
   * </pre>
   */
  public static final class AccountServicesServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AccountServicesServiceBlockingStub> {
    private AccountServicesServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountServicesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountServicesServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve an account service.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.AccountService getAccountService(
        com.google.shopping.merchant.accounts.v1.GetAccountServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List account services for the specified accounts. Supports filtering.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.ListAccountServicesResponse listAccountServices(
        com.google.shopping.merchant.accounts.v1.ListAccountServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAccountServicesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Propose an account service.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.AccountService proposeAccountService(
        com.google.shopping.merchant.accounts.v1.ProposeAccountServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProposeAccountServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Approve an account service proposal.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.AccountService approveAccountService(
        com.google.shopping.merchant.accounts.v1.ApproveAccountServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getApproveAccountServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reject an account service (both proposed and approve services can be
     * rejected).
     * </pre>
     */
    public com.google.protobuf.Empty rejectAccountService(
        com.google.shopping.merchant.accounts.v1.RejectAccountServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRejectAccountServiceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * AccountServicesService.
   *
   * <pre>
   * Service to support AccountService API.
   * </pre>
   */
  public static final class AccountServicesServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AccountServicesServiceFutureStub> {
    private AccountServicesServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountServicesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountServicesServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve an account service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1.AccountService>
        getAccountService(
            com.google.shopping.merchant.accounts.v1.GetAccountServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccountServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List account services for the specified accounts. Supports filtering.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1.ListAccountServicesResponse>
        listAccountServices(
            com.google.shopping.merchant.accounts.v1.ListAccountServicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAccountServicesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Propose an account service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1.AccountService>
        proposeAccountService(
            com.google.shopping.merchant.accounts.v1.ProposeAccountServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProposeAccountServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Approve an account service proposal.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1.AccountService>
        approveAccountService(
            com.google.shopping.merchant.accounts.v1.ApproveAccountServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getApproveAccountServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reject an account service (both proposed and approve services can be
     * rejected).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        rejectAccountService(
            com.google.shopping.merchant.accounts.v1.RejectAccountServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRejectAccountServiceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ACCOUNT_SERVICE = 0;
  private static final int METHODID_LIST_ACCOUNT_SERVICES = 1;
  private static final int METHODID_PROPOSE_ACCOUNT_SERVICE = 2;
  private static final int METHODID_APPROVE_ACCOUNT_SERVICE = 3;
  private static final int METHODID_REJECT_ACCOUNT_SERVICE = 4;

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
        case METHODID_GET_ACCOUNT_SERVICE:
          serviceImpl.getAccountService(
              (com.google.shopping.merchant.accounts.v1.GetAccountServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.AccountService>)
                  responseObserver);
          break;
        case METHODID_LIST_ACCOUNT_SERVICES:
          serviceImpl.listAccountServices(
              (com.google.shopping.merchant.accounts.v1.ListAccountServicesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1.ListAccountServicesResponse>)
                  responseObserver);
          break;
        case METHODID_PROPOSE_ACCOUNT_SERVICE:
          serviceImpl.proposeAccountService(
              (com.google.shopping.merchant.accounts.v1.ProposeAccountServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.AccountService>)
                  responseObserver);
          break;
        case METHODID_APPROVE_ACCOUNT_SERVICE:
          serviceImpl.approveAccountService(
              (com.google.shopping.merchant.accounts.v1.ApproveAccountServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.AccountService>)
                  responseObserver);
          break;
        case METHODID_REJECT_ACCOUNT_SERVICE:
          serviceImpl.rejectAccountService(
              (com.google.shopping.merchant.accounts.v1.RejectAccountServiceRequest) request,
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
            getGetAccountServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.GetAccountServiceRequest,
                    com.google.shopping.merchant.accounts.v1.AccountService>(
                    service, METHODID_GET_ACCOUNT_SERVICE)))
        .addMethod(
            getListAccountServicesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.ListAccountServicesRequest,
                    com.google.shopping.merchant.accounts.v1.ListAccountServicesResponse>(
                    service, METHODID_LIST_ACCOUNT_SERVICES)))
        .addMethod(
            getProposeAccountServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.ProposeAccountServiceRequest,
                    com.google.shopping.merchant.accounts.v1.AccountService>(
                    service, METHODID_PROPOSE_ACCOUNT_SERVICE)))
        .addMethod(
            getApproveAccountServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.ApproveAccountServiceRequest,
                    com.google.shopping.merchant.accounts.v1.AccountService>(
                    service, METHODID_APPROVE_ACCOUNT_SERVICE)))
        .addMethod(
            getRejectAccountServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.RejectAccountServiceRequest,
                    com.google.protobuf.Empty>(service, METHODID_REJECT_ACCOUNT_SERVICE)))
        .build();
  }

  private abstract static class AccountServicesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccountServicesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1.AccountServicesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AccountServicesService");
    }
  }

  private static final class AccountServicesServiceFileDescriptorSupplier
      extends AccountServicesServiceBaseDescriptorSupplier {
    AccountServicesServiceFileDescriptorSupplier() {}
  }

  private static final class AccountServicesServiceMethodDescriptorSupplier
      extends AccountServicesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AccountServicesServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AccountServicesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AccountServicesServiceFileDescriptorSupplier())
                      .addMethod(getGetAccountServiceMethod())
                      .addMethod(getListAccountServicesMethod())
                      .addMethod(getProposeAccountServiceMethod())
                      .addMethod(getApproveAccountServiceMethod())
                      .addMethod(getRejectAccountServiceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
