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
 * Service to support [business
 * identity](https://support.google.com/merchants/answer/12564247) API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1beta/businessidentity.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BusinessIdentityServiceGrpc {

  private BusinessIdentityServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1beta.BusinessIdentityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetBusinessIdentityRequest,
          com.google.shopping.merchant.accounts.v1beta.BusinessIdentity>
      getGetBusinessIdentityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBusinessIdentity",
      requestType = com.google.shopping.merchant.accounts.v1beta.GetBusinessIdentityRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.BusinessIdentity.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetBusinessIdentityRequest,
          com.google.shopping.merchant.accounts.v1beta.BusinessIdentity>
      getGetBusinessIdentityMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.GetBusinessIdentityRequest,
            com.google.shopping.merchant.accounts.v1beta.BusinessIdentity>
        getGetBusinessIdentityMethod;
    if ((getGetBusinessIdentityMethod = BusinessIdentityServiceGrpc.getGetBusinessIdentityMethod)
        == null) {
      synchronized (BusinessIdentityServiceGrpc.class) {
        if ((getGetBusinessIdentityMethod =
                BusinessIdentityServiceGrpc.getGetBusinessIdentityMethod)
            == null) {
          BusinessIdentityServiceGrpc.getGetBusinessIdentityMethod =
              getGetBusinessIdentityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.GetBusinessIdentityRequest,
                          com.google.shopping.merchant.accounts.v1beta.BusinessIdentity>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetBusinessIdentity"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .GetBusinessIdentityRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.BusinessIdentity
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BusinessIdentityServiceMethodDescriptorSupplier(
                              "GetBusinessIdentity"))
                      .build();
        }
      }
    }
    return getGetBusinessIdentityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateBusinessIdentityRequest,
          com.google.shopping.merchant.accounts.v1beta.BusinessIdentity>
      getUpdateBusinessIdentityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBusinessIdentity",
      requestType =
          com.google.shopping.merchant.accounts.v1beta.UpdateBusinessIdentityRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.BusinessIdentity.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateBusinessIdentityRequest,
          com.google.shopping.merchant.accounts.v1beta.BusinessIdentity>
      getUpdateBusinessIdentityMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.UpdateBusinessIdentityRequest,
            com.google.shopping.merchant.accounts.v1beta.BusinessIdentity>
        getUpdateBusinessIdentityMethod;
    if ((getUpdateBusinessIdentityMethod =
            BusinessIdentityServiceGrpc.getUpdateBusinessIdentityMethod)
        == null) {
      synchronized (BusinessIdentityServiceGrpc.class) {
        if ((getUpdateBusinessIdentityMethod =
                BusinessIdentityServiceGrpc.getUpdateBusinessIdentityMethod)
            == null) {
          BusinessIdentityServiceGrpc.getUpdateBusinessIdentityMethod =
              getUpdateBusinessIdentityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.UpdateBusinessIdentityRequest,
                          com.google.shopping.merchant.accounts.v1beta.BusinessIdentity>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateBusinessIdentity"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .UpdateBusinessIdentityRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.BusinessIdentity
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BusinessIdentityServiceMethodDescriptorSupplier(
                              "UpdateBusinessIdentity"))
                      .build();
        }
      }
    }
    return getUpdateBusinessIdentityMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static BusinessIdentityServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BusinessIdentityServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BusinessIdentityServiceStub>() {
          @java.lang.Override
          public BusinessIdentityServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BusinessIdentityServiceStub(channel, callOptions);
          }
        };
    return BusinessIdentityServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BusinessIdentityServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BusinessIdentityServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BusinessIdentityServiceBlockingStub>() {
          @java.lang.Override
          public BusinessIdentityServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BusinessIdentityServiceBlockingStub(channel, callOptions);
          }
        };
    return BusinessIdentityServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BusinessIdentityServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BusinessIdentityServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BusinessIdentityServiceFutureStub>() {
          @java.lang.Override
          public BusinessIdentityServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BusinessIdentityServiceFutureStub(channel, callOptions);
          }
        };
    return BusinessIdentityServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to support [business
   * identity](https://support.google.com/merchants/answer/12564247) API.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves the business identity of an account.
     * </pre>
     */
    default void getBusinessIdentity(
        com.google.shopping.merchant.accounts.v1beta.GetBusinessIdentityRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.BusinessIdentity>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBusinessIdentityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the business identity of an account. Executing this method requires
     * admin access.
     * </pre>
     */
    default void updateBusinessIdentity(
        com.google.shopping.merchant.accounts.v1beta.UpdateBusinessIdentityRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.BusinessIdentity>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBusinessIdentityMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BusinessIdentityService.
   *
   * <pre>
   * Service to support [business
   * identity](https://support.google.com/merchants/answer/12564247) API.
   * </pre>
   */
  public abstract static class BusinessIdentityServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return BusinessIdentityServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BusinessIdentityService.
   *
   * <pre>
   * Service to support [business
   * identity](https://support.google.com/merchants/answer/12564247) API.
   * </pre>
   */
  public static final class BusinessIdentityServiceStub
      extends io.grpc.stub.AbstractAsyncStub<BusinessIdentityServiceStub> {
    private BusinessIdentityServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BusinessIdentityServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BusinessIdentityServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the business identity of an account.
     * </pre>
     */
    public void getBusinessIdentity(
        com.google.shopping.merchant.accounts.v1beta.GetBusinessIdentityRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.BusinessIdentity>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBusinessIdentityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the business identity of an account. Executing this method requires
     * admin access.
     * </pre>
     */
    public void updateBusinessIdentity(
        com.google.shopping.merchant.accounts.v1beta.UpdateBusinessIdentityRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.BusinessIdentity>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBusinessIdentityMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BusinessIdentityService.
   *
   * <pre>
   * Service to support [business
   * identity](https://support.google.com/merchants/answer/12564247) API.
   * </pre>
   */
  public static final class BusinessIdentityServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BusinessIdentityServiceBlockingStub> {
    private BusinessIdentityServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BusinessIdentityServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BusinessIdentityServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the business identity of an account.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.BusinessIdentity getBusinessIdentity(
        com.google.shopping.merchant.accounts.v1beta.GetBusinessIdentityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBusinessIdentityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the business identity of an account. Executing this method requires
     * admin access.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.BusinessIdentity updateBusinessIdentity(
        com.google.shopping.merchant.accounts.v1beta.UpdateBusinessIdentityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBusinessIdentityMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * BusinessIdentityService.
   *
   * <pre>
   * Service to support [business
   * identity](https://support.google.com/merchants/answer/12564247) API.
   * </pre>
   */
  public static final class BusinessIdentityServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<BusinessIdentityServiceFutureStub> {
    private BusinessIdentityServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BusinessIdentityServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BusinessIdentityServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the business identity of an account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.BusinessIdentity>
        getBusinessIdentity(
            com.google.shopping.merchant.accounts.v1beta.GetBusinessIdentityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBusinessIdentityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the business identity of an account. Executing this method requires
     * admin access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.BusinessIdentity>
        updateBusinessIdentity(
            com.google.shopping.merchant.accounts.v1beta.UpdateBusinessIdentityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBusinessIdentityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BUSINESS_IDENTITY = 0;
  private static final int METHODID_UPDATE_BUSINESS_IDENTITY = 1;

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
        case METHODID_GET_BUSINESS_IDENTITY:
          serviceImpl.getBusinessIdentity(
              (com.google.shopping.merchant.accounts.v1beta.GetBusinessIdentityRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.BusinessIdentity>)
                  responseObserver);
          break;
        case METHODID_UPDATE_BUSINESS_IDENTITY:
          serviceImpl.updateBusinessIdentity(
              (com.google.shopping.merchant.accounts.v1beta.UpdateBusinessIdentityRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.BusinessIdentity>)
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
            getGetBusinessIdentityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.GetBusinessIdentityRequest,
                    com.google.shopping.merchant.accounts.v1beta.BusinessIdentity>(
                    service, METHODID_GET_BUSINESS_IDENTITY)))
        .addMethod(
            getUpdateBusinessIdentityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.UpdateBusinessIdentityRequest,
                    com.google.shopping.merchant.accounts.v1beta.BusinessIdentity>(
                    service, METHODID_UPDATE_BUSINESS_IDENTITY)))
        .build();
  }

  private abstract static class BusinessIdentityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BusinessIdentityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1beta.BusinessIdentityProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BusinessIdentityService");
    }
  }

  private static final class BusinessIdentityServiceFileDescriptorSupplier
      extends BusinessIdentityServiceBaseDescriptorSupplier {
    BusinessIdentityServiceFileDescriptorSupplier() {}
  }

  private static final class BusinessIdentityServiceMethodDescriptorSupplier
      extends BusinessIdentityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BusinessIdentityServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (BusinessIdentityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new BusinessIdentityServiceFileDescriptorSupplier())
                      .addMethod(getGetBusinessIdentityMethod())
                      .addMethod(getUpdateBusinessIdentityMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
