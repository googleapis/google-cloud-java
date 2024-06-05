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
 * The service facilitates the management of a merchant's remorse return policy
 * configuration, encompassing return policies for both ads and free listings
 * ## programs. This API defines the following resource model:
 * [OnlineReturnPolicy][google.shopping.merchant.accounts.v1.OnlineReturnPolicy]
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1beta/online_return_policy.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OnlineReturnPolicyServiceGrpc {

  private OnlineReturnPolicyServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1beta.OnlineReturnPolicyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetOnlineReturnPolicyRequest,
          com.google.shopping.merchant.accounts.v1beta.OnlineReturnPolicy>
      getGetOnlineReturnPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOnlineReturnPolicy",
      requestType = com.google.shopping.merchant.accounts.v1beta.GetOnlineReturnPolicyRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.OnlineReturnPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetOnlineReturnPolicyRequest,
          com.google.shopping.merchant.accounts.v1beta.OnlineReturnPolicy>
      getGetOnlineReturnPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.GetOnlineReturnPolicyRequest,
            com.google.shopping.merchant.accounts.v1beta.OnlineReturnPolicy>
        getGetOnlineReturnPolicyMethod;
    if ((getGetOnlineReturnPolicyMethod =
            OnlineReturnPolicyServiceGrpc.getGetOnlineReturnPolicyMethod)
        == null) {
      synchronized (OnlineReturnPolicyServiceGrpc.class) {
        if ((getGetOnlineReturnPolicyMethod =
                OnlineReturnPolicyServiceGrpc.getGetOnlineReturnPolicyMethod)
            == null) {
          OnlineReturnPolicyServiceGrpc.getGetOnlineReturnPolicyMethod =
              getGetOnlineReturnPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.GetOnlineReturnPolicyRequest,
                          com.google.shopping.merchant.accounts.v1beta.OnlineReturnPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetOnlineReturnPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .GetOnlineReturnPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.OnlineReturnPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OnlineReturnPolicyServiceMethodDescriptorSupplier(
                              "GetOnlineReturnPolicy"))
                      .build();
        }
      }
    }
    return getGetOnlineReturnPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesRequest,
          com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesResponse>
      getListOnlineReturnPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOnlineReturnPolicies",
      requestType =
          com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesRequest.class,
      responseType =
          com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesRequest,
          com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesResponse>
      getListOnlineReturnPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesRequest,
            com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesResponse>
        getListOnlineReturnPoliciesMethod;
    if ((getListOnlineReturnPoliciesMethod =
            OnlineReturnPolicyServiceGrpc.getListOnlineReturnPoliciesMethod)
        == null) {
      synchronized (OnlineReturnPolicyServiceGrpc.class) {
        if ((getListOnlineReturnPoliciesMethod =
                OnlineReturnPolicyServiceGrpc.getListOnlineReturnPoliciesMethod)
            == null) {
          OnlineReturnPolicyServiceGrpc.getListOnlineReturnPoliciesMethod =
              getListOnlineReturnPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta
                              .ListOnlineReturnPoliciesRequest,
                          com.google.shopping.merchant.accounts.v1beta
                              .ListOnlineReturnPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListOnlineReturnPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .ListOnlineReturnPoliciesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .ListOnlineReturnPoliciesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OnlineReturnPolicyServiceMethodDescriptorSupplier(
                              "ListOnlineReturnPolicies"))
                      .build();
        }
      }
    }
    return getListOnlineReturnPoliciesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static OnlineReturnPolicyServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OnlineReturnPolicyServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OnlineReturnPolicyServiceStub>() {
          @java.lang.Override
          public OnlineReturnPolicyServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OnlineReturnPolicyServiceStub(channel, callOptions);
          }
        };
    return OnlineReturnPolicyServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OnlineReturnPolicyServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OnlineReturnPolicyServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OnlineReturnPolicyServiceBlockingStub>() {
          @java.lang.Override
          public OnlineReturnPolicyServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OnlineReturnPolicyServiceBlockingStub(channel, callOptions);
          }
        };
    return OnlineReturnPolicyServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static OnlineReturnPolicyServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OnlineReturnPolicyServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OnlineReturnPolicyServiceFutureStub>() {
          @java.lang.Override
          public OnlineReturnPolicyServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OnlineReturnPolicyServiceFutureStub(channel, callOptions);
          }
        };
    return OnlineReturnPolicyServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The service facilitates the management of a merchant's remorse return policy
   * configuration, encompassing return policies for both ads and free listings
   * ## programs. This API defines the following resource model:
   * [OnlineReturnPolicy][google.shopping.merchant.accounts.v1.OnlineReturnPolicy]
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets an existing return policy.
     * </pre>
     */
    default void getOnlineReturnPolicy(
        com.google.shopping.merchant.accounts.v1beta.GetOnlineReturnPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.OnlineReturnPolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetOnlineReturnPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all existing return policies.
     * </pre>
     */
    default void listOnlineReturnPolicies(
        com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListOnlineReturnPoliciesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OnlineReturnPolicyService.
   *
   * <pre>
   * The service facilitates the management of a merchant's remorse return policy
   * configuration, encompassing return policies for both ads and free listings
   * ## programs. This API defines the following resource model:
   * [OnlineReturnPolicy][google.shopping.merchant.accounts.v1.OnlineReturnPolicy]
   * </pre>
   */
  public abstract static class OnlineReturnPolicyServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return OnlineReturnPolicyServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service OnlineReturnPolicyService.
   *
   * <pre>
   * The service facilitates the management of a merchant's remorse return policy
   * configuration, encompassing return policies for both ads and free listings
   * ## programs. This API defines the following resource model:
   * [OnlineReturnPolicy][google.shopping.merchant.accounts.v1.OnlineReturnPolicy]
   * </pre>
   */
  public static final class OnlineReturnPolicyServiceStub
      extends io.grpc.stub.AbstractAsyncStub<OnlineReturnPolicyServiceStub> {
    private OnlineReturnPolicyServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OnlineReturnPolicyServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OnlineReturnPolicyServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets an existing return policy.
     * </pre>
     */
    public void getOnlineReturnPolicy(
        com.google.shopping.merchant.accounts.v1beta.GetOnlineReturnPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.OnlineReturnPolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOnlineReturnPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all existing return policies.
     * </pre>
     */
    public void listOnlineReturnPolicies(
        com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOnlineReturnPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service OnlineReturnPolicyService.
   *
   * <pre>
   * The service facilitates the management of a merchant's remorse return policy
   * configuration, encompassing return policies for both ads and free listings
   * ## programs. This API defines the following resource model:
   * [OnlineReturnPolicy][google.shopping.merchant.accounts.v1.OnlineReturnPolicy]
   * </pre>
   */
  public static final class OnlineReturnPolicyServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OnlineReturnPolicyServiceBlockingStub> {
    private OnlineReturnPolicyServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OnlineReturnPolicyServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OnlineReturnPolicyServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets an existing return policy.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.OnlineReturnPolicy getOnlineReturnPolicy(
        com.google.shopping.merchant.accounts.v1beta.GetOnlineReturnPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOnlineReturnPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all existing return policies.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesResponse
        listOnlineReturnPolicies(
            com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOnlineReturnPoliciesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * OnlineReturnPolicyService.
   *
   * <pre>
   * The service facilitates the management of a merchant's remorse return policy
   * configuration, encompassing return policies for both ads and free listings
   * ## programs. This API defines the following resource model:
   * [OnlineReturnPolicy][google.shopping.merchant.accounts.v1.OnlineReturnPolicy]
   * </pre>
   */
  public static final class OnlineReturnPolicyServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<OnlineReturnPolicyServiceFutureStub> {
    private OnlineReturnPolicyServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OnlineReturnPolicyServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OnlineReturnPolicyServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets an existing return policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.OnlineReturnPolicy>
        getOnlineReturnPolicy(
            com.google.shopping.merchant.accounts.v1beta.GetOnlineReturnPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOnlineReturnPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all existing return policies.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesResponse>
        listOnlineReturnPolicies(
            com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOnlineReturnPoliciesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ONLINE_RETURN_POLICY = 0;
  private static final int METHODID_LIST_ONLINE_RETURN_POLICIES = 1;

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
        case METHODID_GET_ONLINE_RETURN_POLICY:
          serviceImpl.getOnlineReturnPolicy(
              (com.google.shopping.merchant.accounts.v1beta.GetOnlineReturnPolicyRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.OnlineReturnPolicy>)
                  responseObserver);
          break;
        case METHODID_LIST_ONLINE_RETURN_POLICIES:
          serviceImpl.listOnlineReturnPolicies(
              (com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta
                          .ListOnlineReturnPoliciesResponse>)
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
            getGetOnlineReturnPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.GetOnlineReturnPolicyRequest,
                    com.google.shopping.merchant.accounts.v1beta.OnlineReturnPolicy>(
                    service, METHODID_GET_ONLINE_RETURN_POLICY)))
        .addMethod(
            getListOnlineReturnPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesRequest,
                    com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesResponse>(
                    service, METHODID_LIST_ONLINE_RETURN_POLICIES)))
        .build();
  }

  private abstract static class OnlineReturnPolicyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OnlineReturnPolicyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1beta.OnlineReturnPolicyProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OnlineReturnPolicyService");
    }
  }

  private static final class OnlineReturnPolicyServiceFileDescriptorSupplier
      extends OnlineReturnPolicyServiceBaseDescriptorSupplier {
    OnlineReturnPolicyServiceFileDescriptorSupplier() {}
  }

  private static final class OnlineReturnPolicyServiceMethodDescriptorSupplier
      extends OnlineReturnPolicyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OnlineReturnPolicyServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (OnlineReturnPolicyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new OnlineReturnPolicyServiceFileDescriptorSupplier())
                      .addMethod(getGetOnlineReturnPolicyMethod())
                      .addMethod(getListOnlineReturnPoliciesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
