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
 * Service to support business info API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1beta/businessinfo.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BusinessInfoServiceGrpc {

  private BusinessInfoServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1beta.BusinessInfoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetBusinessInfoRequest,
          com.google.shopping.merchant.accounts.v1beta.BusinessInfo>
      getGetBusinessInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBusinessInfo",
      requestType = com.google.shopping.merchant.accounts.v1beta.GetBusinessInfoRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.BusinessInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetBusinessInfoRequest,
          com.google.shopping.merchant.accounts.v1beta.BusinessInfo>
      getGetBusinessInfoMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.GetBusinessInfoRequest,
            com.google.shopping.merchant.accounts.v1beta.BusinessInfo>
        getGetBusinessInfoMethod;
    if ((getGetBusinessInfoMethod = BusinessInfoServiceGrpc.getGetBusinessInfoMethod) == null) {
      synchronized (BusinessInfoServiceGrpc.class) {
        if ((getGetBusinessInfoMethod = BusinessInfoServiceGrpc.getGetBusinessInfoMethod) == null) {
          BusinessInfoServiceGrpc.getGetBusinessInfoMethod =
              getGetBusinessInfoMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.GetBusinessInfoRequest,
                          com.google.shopping.merchant.accounts.v1beta.BusinessInfo>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBusinessInfo"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.GetBusinessInfoRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.BusinessInfo
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BusinessInfoServiceMethodDescriptorSupplier("GetBusinessInfo"))
                      .build();
        }
      }
    }
    return getGetBusinessInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateBusinessInfoRequest,
          com.google.shopping.merchant.accounts.v1beta.BusinessInfo>
      getUpdateBusinessInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBusinessInfo",
      requestType = com.google.shopping.merchant.accounts.v1beta.UpdateBusinessInfoRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.BusinessInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateBusinessInfoRequest,
          com.google.shopping.merchant.accounts.v1beta.BusinessInfo>
      getUpdateBusinessInfoMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.UpdateBusinessInfoRequest,
            com.google.shopping.merchant.accounts.v1beta.BusinessInfo>
        getUpdateBusinessInfoMethod;
    if ((getUpdateBusinessInfoMethod = BusinessInfoServiceGrpc.getUpdateBusinessInfoMethod)
        == null) {
      synchronized (BusinessInfoServiceGrpc.class) {
        if ((getUpdateBusinessInfoMethod = BusinessInfoServiceGrpc.getUpdateBusinessInfoMethod)
            == null) {
          BusinessInfoServiceGrpc.getUpdateBusinessInfoMethod =
              getUpdateBusinessInfoMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.UpdateBusinessInfoRequest,
                          com.google.shopping.merchant.accounts.v1beta.BusinessInfo>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBusinessInfo"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.UpdateBusinessInfoRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.BusinessInfo
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BusinessInfoServiceMethodDescriptorSupplier("UpdateBusinessInfo"))
                      .build();
        }
      }
    }
    return getUpdateBusinessInfoMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static BusinessInfoServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BusinessInfoServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BusinessInfoServiceStub>() {
          @java.lang.Override
          public BusinessInfoServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BusinessInfoServiceStub(channel, callOptions);
          }
        };
    return BusinessInfoServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BusinessInfoServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BusinessInfoServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BusinessInfoServiceBlockingStub>() {
          @java.lang.Override
          public BusinessInfoServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BusinessInfoServiceBlockingStub(channel, callOptions);
          }
        };
    return BusinessInfoServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BusinessInfoServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BusinessInfoServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BusinessInfoServiceFutureStub>() {
          @java.lang.Override
          public BusinessInfoServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BusinessInfoServiceFutureStub(channel, callOptions);
          }
        };
    return BusinessInfoServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to support business info API.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves the business info of an account.
     * </pre>
     */
    default void getBusinessInfo(
        com.google.shopping.merchant.accounts.v1beta.GetBusinessInfoRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.BusinessInfo>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBusinessInfoMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the business info of an account. Executing this method requires
     * admin access.
     * </pre>
     */
    default void updateBusinessInfo(
        com.google.shopping.merchant.accounts.v1beta.UpdateBusinessInfoRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.BusinessInfo>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBusinessInfoMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BusinessInfoService.
   *
   * <pre>
   * Service to support business info API.
   * </pre>
   */
  public abstract static class BusinessInfoServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return BusinessInfoServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BusinessInfoService.
   *
   * <pre>
   * Service to support business info API.
   * </pre>
   */
  public static final class BusinessInfoServiceStub
      extends io.grpc.stub.AbstractAsyncStub<BusinessInfoServiceStub> {
    private BusinessInfoServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BusinessInfoServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BusinessInfoServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the business info of an account.
     * </pre>
     */
    public void getBusinessInfo(
        com.google.shopping.merchant.accounts.v1beta.GetBusinessInfoRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.BusinessInfo>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBusinessInfoMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the business info of an account. Executing this method requires
     * admin access.
     * </pre>
     */
    public void updateBusinessInfo(
        com.google.shopping.merchant.accounts.v1beta.UpdateBusinessInfoRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.BusinessInfo>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBusinessInfoMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BusinessInfoService.
   *
   * <pre>
   * Service to support business info API.
   * </pre>
   */
  public static final class BusinessInfoServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BusinessInfoServiceBlockingStub> {
    private BusinessInfoServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BusinessInfoServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BusinessInfoServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the business info of an account.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.BusinessInfo getBusinessInfo(
        com.google.shopping.merchant.accounts.v1beta.GetBusinessInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBusinessInfoMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the business info of an account. Executing this method requires
     * admin access.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.BusinessInfo updateBusinessInfo(
        com.google.shopping.merchant.accounts.v1beta.UpdateBusinessInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBusinessInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service BusinessInfoService.
   *
   * <pre>
   * Service to support business info API.
   * </pre>
   */
  public static final class BusinessInfoServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<BusinessInfoServiceFutureStub> {
    private BusinessInfoServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BusinessInfoServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BusinessInfoServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the business info of an account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.BusinessInfo>
        getBusinessInfo(
            com.google.shopping.merchant.accounts.v1beta.GetBusinessInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBusinessInfoMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the business info of an account. Executing this method requires
     * admin access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.BusinessInfo>
        updateBusinessInfo(
            com.google.shopping.merchant.accounts.v1beta.UpdateBusinessInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBusinessInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BUSINESS_INFO = 0;
  private static final int METHODID_UPDATE_BUSINESS_INFO = 1;

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
        case METHODID_GET_BUSINESS_INFO:
          serviceImpl.getBusinessInfo(
              (com.google.shopping.merchant.accounts.v1beta.GetBusinessInfoRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.BusinessInfo>)
                  responseObserver);
          break;
        case METHODID_UPDATE_BUSINESS_INFO:
          serviceImpl.updateBusinessInfo(
              (com.google.shopping.merchant.accounts.v1beta.UpdateBusinessInfoRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.BusinessInfo>)
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
            getGetBusinessInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.GetBusinessInfoRequest,
                    com.google.shopping.merchant.accounts.v1beta.BusinessInfo>(
                    service, METHODID_GET_BUSINESS_INFO)))
        .addMethod(
            getUpdateBusinessInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.UpdateBusinessInfoRequest,
                    com.google.shopping.merchant.accounts.v1beta.BusinessInfo>(
                    service, METHODID_UPDATE_BUSINESS_INFO)))
        .build();
  }

  private abstract static class BusinessInfoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BusinessInfoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1beta.BusinessInfoProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BusinessInfoService");
    }
  }

  private static final class BusinessInfoServiceFileDescriptorSupplier
      extends BusinessInfoServiceBaseDescriptorSupplier {
    BusinessInfoServiceFileDescriptorSupplier() {}
  }

  private static final class BusinessInfoServiceMethodDescriptorSupplier
      extends BusinessInfoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BusinessInfoServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (BusinessInfoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new BusinessInfoServiceFileDescriptorSupplier())
                      .addMethod(getGetBusinessInfoMethod())
                      .addMethod(getUpdateBusinessInfoMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
