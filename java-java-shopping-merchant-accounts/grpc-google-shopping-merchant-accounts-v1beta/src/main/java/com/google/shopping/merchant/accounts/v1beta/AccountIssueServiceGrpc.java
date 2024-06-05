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
 * Service to support `AccountIssueService` API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1beta/accountissue.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AccountIssueServiceGrpc {

  private AccountIssueServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1beta.AccountIssueService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesRequest,
          com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesResponse>
      getListAccountIssuesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAccountIssues",
      requestType = com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesRequest,
          com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesResponse>
      getListAccountIssuesMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesRequest,
            com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesResponse>
        getListAccountIssuesMethod;
    if ((getListAccountIssuesMethod = AccountIssueServiceGrpc.getListAccountIssuesMethod) == null) {
      synchronized (AccountIssueServiceGrpc.class) {
        if ((getListAccountIssuesMethod = AccountIssueServiceGrpc.getListAccountIssuesMethod)
            == null) {
          AccountIssueServiceGrpc.getListAccountIssuesMethod =
              getListAccountIssuesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesRequest,
                          com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAccountIssues"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccountIssueServiceMethodDescriptorSupplier("ListAccountIssues"))
                      .build();
        }
      }
    }
    return getListAccountIssuesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AccountIssueServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountIssueServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountIssueServiceStub>() {
          @java.lang.Override
          public AccountIssueServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountIssueServiceStub(channel, callOptions);
          }
        };
    return AccountIssueServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccountIssueServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountIssueServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountIssueServiceBlockingStub>() {
          @java.lang.Override
          public AccountIssueServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountIssueServiceBlockingStub(channel, callOptions);
          }
        };
    return AccountIssueServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AccountIssueServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountIssueServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccountIssueServiceFutureStub>() {
          @java.lang.Override
          public AccountIssueServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccountIssueServiceFutureStub(channel, callOptions);
          }
        };
    return AccountIssueServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to support `AccountIssueService` API.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists all account issues of a Merchant Center account.
     * </pre>
     */
    default void listAccountIssues(
        com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAccountIssuesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AccountIssueService.
   *
   * <pre>
   * Service to support `AccountIssueService` API.
   * </pre>
   */
  public abstract static class AccountIssueServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AccountIssueServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AccountIssueService.
   *
   * <pre>
   * Service to support `AccountIssueService` API.
   * </pre>
   */
  public static final class AccountIssueServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AccountIssueServiceStub> {
    private AccountIssueServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountIssueServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountIssueServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all account issues of a Merchant Center account.
     * </pre>
     */
    public void listAccountIssues(
        com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAccountIssuesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AccountIssueService.
   *
   * <pre>
   * Service to support `AccountIssueService` API.
   * </pre>
   */
  public static final class AccountIssueServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AccountIssueServiceBlockingStub> {
    private AccountIssueServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountIssueServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountIssueServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all account issues of a Merchant Center account.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesResponse listAccountIssues(
        com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAccountIssuesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AccountIssueService.
   *
   * <pre>
   * Service to support `AccountIssueService` API.
   * </pre>
   */
  public static final class AccountIssueServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AccountIssueServiceFutureStub> {
    private AccountIssueServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountIssueServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountIssueServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all account issues of a Merchant Center account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesResponse>
        listAccountIssues(
            com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAccountIssuesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ACCOUNT_ISSUES = 0;

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
        case METHODID_LIST_ACCOUNT_ISSUES:
          serviceImpl.listAccountIssues(
              (com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesResponse>)
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
            getListAccountIssuesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesRequest,
                    com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesResponse>(
                    service, METHODID_LIST_ACCOUNT_ISSUES)))
        .build();
  }

  private abstract static class AccountIssueServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccountIssueServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1beta.AccountIssueProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AccountIssueService");
    }
  }

  private static final class AccountIssueServiceFileDescriptorSupplier
      extends AccountIssueServiceBaseDescriptorSupplier {
    AccountIssueServiceFileDescriptorSupplier() {}
  }

  private static final class AccountIssueServiceMethodDescriptorSupplier
      extends AccountIssueServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AccountIssueServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AccountIssueServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AccountIssueServiceFileDescriptorSupplier())
                      .addMethod(getListAccountIssuesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
