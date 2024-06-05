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
 * Service to support `TermsOfService` API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1beta/termsofservice.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TermsOfServiceServiceGrpc {

  private TermsOfServiceServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1beta.TermsOfServiceService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceRequest,
          com.google.shopping.merchant.accounts.v1beta.TermsOfService>
      getGetTermsOfServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTermsOfService",
      requestType = com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.TermsOfService.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceRequest,
          com.google.shopping.merchant.accounts.v1beta.TermsOfService>
      getGetTermsOfServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceRequest,
            com.google.shopping.merchant.accounts.v1beta.TermsOfService>
        getGetTermsOfServiceMethod;
    if ((getGetTermsOfServiceMethod = TermsOfServiceServiceGrpc.getGetTermsOfServiceMethod)
        == null) {
      synchronized (TermsOfServiceServiceGrpc.class) {
        if ((getGetTermsOfServiceMethod = TermsOfServiceServiceGrpc.getGetTermsOfServiceMethod)
            == null) {
          TermsOfServiceServiceGrpc.getGetTermsOfServiceMethod =
              getGetTermsOfServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceRequest,
                          com.google.shopping.merchant.accounts.v1beta.TermsOfService>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTermsOfService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.TermsOfService
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TermsOfServiceServiceMethodDescriptorSupplier("GetTermsOfService"))
                      .build();
        }
      }
    }
    return getGetTermsOfServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.RetrieveLatestTermsOfServiceRequest,
          com.google.shopping.merchant.accounts.v1beta.TermsOfService>
      getRetrieveLatestTermsOfServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetrieveLatestTermsOfService",
      requestType =
          com.google.shopping.merchant.accounts.v1beta.RetrieveLatestTermsOfServiceRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.TermsOfService.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.RetrieveLatestTermsOfServiceRequest,
          com.google.shopping.merchant.accounts.v1beta.TermsOfService>
      getRetrieveLatestTermsOfServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.RetrieveLatestTermsOfServiceRequest,
            com.google.shopping.merchant.accounts.v1beta.TermsOfService>
        getRetrieveLatestTermsOfServiceMethod;
    if ((getRetrieveLatestTermsOfServiceMethod =
            TermsOfServiceServiceGrpc.getRetrieveLatestTermsOfServiceMethod)
        == null) {
      synchronized (TermsOfServiceServiceGrpc.class) {
        if ((getRetrieveLatestTermsOfServiceMethod =
                TermsOfServiceServiceGrpc.getRetrieveLatestTermsOfServiceMethod)
            == null) {
          TermsOfServiceServiceGrpc.getRetrieveLatestTermsOfServiceMethod =
              getRetrieveLatestTermsOfServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta
                              .RetrieveLatestTermsOfServiceRequest,
                          com.google.shopping.merchant.accounts.v1beta.TermsOfService>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RetrieveLatestTermsOfService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .RetrieveLatestTermsOfServiceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.TermsOfService
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TermsOfServiceServiceMethodDescriptorSupplier(
                              "RetrieveLatestTermsOfService"))
                      .build();
        }
      }
    }
    return getRetrieveLatestTermsOfServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.AcceptTermsOfServiceRequest,
          com.google.protobuf.Empty>
      getAcceptTermsOfServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AcceptTermsOfService",
      requestType = com.google.shopping.merchant.accounts.v1beta.AcceptTermsOfServiceRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.AcceptTermsOfServiceRequest,
          com.google.protobuf.Empty>
      getAcceptTermsOfServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.AcceptTermsOfServiceRequest,
            com.google.protobuf.Empty>
        getAcceptTermsOfServiceMethod;
    if ((getAcceptTermsOfServiceMethod = TermsOfServiceServiceGrpc.getAcceptTermsOfServiceMethod)
        == null) {
      synchronized (TermsOfServiceServiceGrpc.class) {
        if ((getAcceptTermsOfServiceMethod =
                TermsOfServiceServiceGrpc.getAcceptTermsOfServiceMethod)
            == null) {
          TermsOfServiceServiceGrpc.getAcceptTermsOfServiceMethod =
              getAcceptTermsOfServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.AcceptTermsOfServiceRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AcceptTermsOfService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .AcceptTermsOfServiceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TermsOfServiceServiceMethodDescriptorSupplier("AcceptTermsOfService"))
                      .build();
        }
      }
    }
    return getAcceptTermsOfServiceMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TermsOfServiceServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TermsOfServiceServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TermsOfServiceServiceStub>() {
          @java.lang.Override
          public TermsOfServiceServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TermsOfServiceServiceStub(channel, callOptions);
          }
        };
    return TermsOfServiceServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TermsOfServiceServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TermsOfServiceServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TermsOfServiceServiceBlockingStub>() {
          @java.lang.Override
          public TermsOfServiceServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TermsOfServiceServiceBlockingStub(channel, callOptions);
          }
        };
    return TermsOfServiceServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TermsOfServiceServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TermsOfServiceServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TermsOfServiceServiceFutureStub>() {
          @java.lang.Override
          public TermsOfServiceServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TermsOfServiceServiceFutureStub(channel, callOptions);
          }
        };
    return TermsOfServiceServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to support `TermsOfService` API.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves the `TermsOfService` associated with the provided version.
     * </pre>
     */
    default void getTermsOfService(
        com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.TermsOfService>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTermsOfServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the latest version of the `TermsOfService` for a given `kind` and
     * `region_code`.
     * </pre>
     */
    default void retrieveLatestTermsOfService(
        com.google.shopping.merchant.accounts.v1beta.RetrieveLatestTermsOfServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.TermsOfService>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRetrieveLatestTermsOfServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Accepts a `TermsOfService`. Executing this method requires admin access.
     * </pre>
     */
    default void acceptTermsOfService(
        com.google.shopping.merchant.accounts.v1beta.AcceptTermsOfServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAcceptTermsOfServiceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TermsOfServiceService.
   *
   * <pre>
   * Service to support `TermsOfService` API.
   * </pre>
   */
  public abstract static class TermsOfServiceServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return TermsOfServiceServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TermsOfServiceService.
   *
   * <pre>
   * Service to support `TermsOfService` API.
   * </pre>
   */
  public static final class TermsOfServiceServiceStub
      extends io.grpc.stub.AbstractAsyncStub<TermsOfServiceServiceStub> {
    private TermsOfServiceServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TermsOfServiceServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TermsOfServiceServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the `TermsOfService` associated with the provided version.
     * </pre>
     */
    public void getTermsOfService(
        com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.TermsOfService>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTermsOfServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the latest version of the `TermsOfService` for a given `kind` and
     * `region_code`.
     * </pre>
     */
    public void retrieveLatestTermsOfService(
        com.google.shopping.merchant.accounts.v1beta.RetrieveLatestTermsOfServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.TermsOfService>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetrieveLatestTermsOfServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Accepts a `TermsOfService`. Executing this method requires admin access.
     * </pre>
     */
    public void acceptTermsOfService(
        com.google.shopping.merchant.accounts.v1beta.AcceptTermsOfServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAcceptTermsOfServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TermsOfServiceService.
   *
   * <pre>
   * Service to support `TermsOfService` API.
   * </pre>
   */
  public static final class TermsOfServiceServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TermsOfServiceServiceBlockingStub> {
    private TermsOfServiceServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TermsOfServiceServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TermsOfServiceServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the `TermsOfService` associated with the provided version.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.TermsOfService getTermsOfService(
        com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTermsOfServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the latest version of the `TermsOfService` for a given `kind` and
     * `region_code`.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.TermsOfService retrieveLatestTermsOfService(
        com.google.shopping.merchant.accounts.v1beta.RetrieveLatestTermsOfServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrieveLatestTermsOfServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Accepts a `TermsOfService`. Executing this method requires admin access.
     * </pre>
     */
    public com.google.protobuf.Empty acceptTermsOfService(
        com.google.shopping.merchant.accounts.v1beta.AcceptTermsOfServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAcceptTermsOfServiceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * TermsOfServiceService.
   *
   * <pre>
   * Service to support `TermsOfService` API.
   * </pre>
   */
  public static final class TermsOfServiceServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<TermsOfServiceServiceFutureStub> {
    private TermsOfServiceServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TermsOfServiceServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TermsOfServiceServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the `TermsOfService` associated with the provided version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.TermsOfService>
        getTermsOfService(
            com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTermsOfServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the latest version of the `TermsOfService` for a given `kind` and
     * `region_code`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.TermsOfService>
        retrieveLatestTermsOfService(
            com.google.shopping.merchant.accounts.v1beta.RetrieveLatestTermsOfServiceRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetrieveLatestTermsOfServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Accepts a `TermsOfService`. Executing this method requires admin access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        acceptTermsOfService(
            com.google.shopping.merchant.accounts.v1beta.AcceptTermsOfServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAcceptTermsOfServiceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TERMS_OF_SERVICE = 0;
  private static final int METHODID_RETRIEVE_LATEST_TERMS_OF_SERVICE = 1;
  private static final int METHODID_ACCEPT_TERMS_OF_SERVICE = 2;

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
        case METHODID_GET_TERMS_OF_SERVICE:
          serviceImpl.getTermsOfService(
              (com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.TermsOfService>)
                  responseObserver);
          break;
        case METHODID_RETRIEVE_LATEST_TERMS_OF_SERVICE:
          serviceImpl.retrieveLatestTermsOfService(
              (com.google.shopping.merchant.accounts.v1beta.RetrieveLatestTermsOfServiceRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.TermsOfService>)
                  responseObserver);
          break;
        case METHODID_ACCEPT_TERMS_OF_SERVICE:
          serviceImpl.acceptTermsOfService(
              (com.google.shopping.merchant.accounts.v1beta.AcceptTermsOfServiceRequest) request,
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
            getGetTermsOfServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceRequest,
                    com.google.shopping.merchant.accounts.v1beta.TermsOfService>(
                    service, METHODID_GET_TERMS_OF_SERVICE)))
        .addMethod(
            getRetrieveLatestTermsOfServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta
                        .RetrieveLatestTermsOfServiceRequest,
                    com.google.shopping.merchant.accounts.v1beta.TermsOfService>(
                    service, METHODID_RETRIEVE_LATEST_TERMS_OF_SERVICE)))
        .addMethod(
            getAcceptTermsOfServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.AcceptTermsOfServiceRequest,
                    com.google.protobuf.Empty>(service, METHODID_ACCEPT_TERMS_OF_SERVICE)))
        .build();
  }

  private abstract static class TermsOfServiceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TermsOfServiceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1beta.TermsOfServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TermsOfServiceService");
    }
  }

  private static final class TermsOfServiceServiceFileDescriptorSupplier
      extends TermsOfServiceServiceBaseDescriptorSupplier {
    TermsOfServiceServiceFileDescriptorSupplier() {}
  }

  private static final class TermsOfServiceServiceMethodDescriptorSupplier
      extends TermsOfServiceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TermsOfServiceServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (TermsOfServiceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new TermsOfServiceServiceFileDescriptorSupplier())
                      .addMethod(getGetTermsOfServiceMethod())
                      .addMethod(getRetrieveLatestTermsOfServiceMethod())
                      .addMethod(getAcceptTermsOfServiceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
