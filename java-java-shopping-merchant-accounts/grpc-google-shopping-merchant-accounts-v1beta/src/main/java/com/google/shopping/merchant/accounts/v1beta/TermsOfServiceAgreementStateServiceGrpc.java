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
 * Service to support `TermsOfServiceAgreementState` API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments =
        "Source: google/shopping/merchant/accounts/v1beta/termsofserviceagreementstate.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TermsOfServiceAgreementStateServiceGrpc {

  private TermsOfServiceAgreementStateServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementStateService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceAgreementStateRequest,
          com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState>
      getGetTermsOfServiceAgreementStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTermsOfServiceAgreementState",
      requestType =
          com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceAgreementStateRequest.class,
      responseType =
          com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceAgreementStateRequest,
          com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState>
      getGetTermsOfServiceAgreementStateMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceAgreementStateRequest,
            com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState>
        getGetTermsOfServiceAgreementStateMethod;
    if ((getGetTermsOfServiceAgreementStateMethod =
            TermsOfServiceAgreementStateServiceGrpc.getGetTermsOfServiceAgreementStateMethod)
        == null) {
      synchronized (TermsOfServiceAgreementStateServiceGrpc.class) {
        if ((getGetTermsOfServiceAgreementStateMethod =
                TermsOfServiceAgreementStateServiceGrpc.getGetTermsOfServiceAgreementStateMethod)
            == null) {
          TermsOfServiceAgreementStateServiceGrpc.getGetTermsOfServiceAgreementStateMethod =
              getGetTermsOfServiceAgreementStateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta
                              .GetTermsOfServiceAgreementStateRequest,
                          com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetTermsOfServiceAgreementState"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .GetTermsOfServiceAgreementStateRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .TermsOfServiceAgreementState.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TermsOfServiceAgreementStateServiceMethodDescriptorSupplier(
                              "GetTermsOfServiceAgreementState"))
                      .build();
        }
      }
    }
    return getGetTermsOfServiceAgreementStateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta
              .RetrieveForApplicationTermsOfServiceAgreementStateRequest,
          com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState>
      getRetrieveForApplicationTermsOfServiceAgreementStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetrieveForApplicationTermsOfServiceAgreementState",
      requestType =
          com.google.shopping.merchant.accounts.v1beta
              .RetrieveForApplicationTermsOfServiceAgreementStateRequest.class,
      responseType =
          com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta
              .RetrieveForApplicationTermsOfServiceAgreementStateRequest,
          com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState>
      getRetrieveForApplicationTermsOfServiceAgreementStateMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta
                .RetrieveForApplicationTermsOfServiceAgreementStateRequest,
            com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState>
        getRetrieveForApplicationTermsOfServiceAgreementStateMethod;
    if ((getRetrieveForApplicationTermsOfServiceAgreementStateMethod =
            TermsOfServiceAgreementStateServiceGrpc
                .getRetrieveForApplicationTermsOfServiceAgreementStateMethod)
        == null) {
      synchronized (TermsOfServiceAgreementStateServiceGrpc.class) {
        if ((getRetrieveForApplicationTermsOfServiceAgreementStateMethod =
                TermsOfServiceAgreementStateServiceGrpc
                    .getRetrieveForApplicationTermsOfServiceAgreementStateMethod)
            == null) {
          TermsOfServiceAgreementStateServiceGrpc
                  .getRetrieveForApplicationTermsOfServiceAgreementStateMethod =
              getRetrieveForApplicationTermsOfServiceAgreementStateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta
                              .RetrieveForApplicationTermsOfServiceAgreementStateRequest,
                          com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "RetrieveForApplicationTermsOfServiceAgreementState"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .RetrieveForApplicationTermsOfServiceAgreementStateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .TermsOfServiceAgreementState.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TermsOfServiceAgreementStateServiceMethodDescriptorSupplier(
                              "RetrieveForApplicationTermsOfServiceAgreementState"))
                      .build();
        }
      }
    }
    return getRetrieveForApplicationTermsOfServiceAgreementStateMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TermsOfServiceAgreementStateServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TermsOfServiceAgreementStateServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TermsOfServiceAgreementStateServiceStub>() {
          @java.lang.Override
          public TermsOfServiceAgreementStateServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TermsOfServiceAgreementStateServiceStub(channel, callOptions);
          }
        };
    return TermsOfServiceAgreementStateServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TermsOfServiceAgreementStateServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TermsOfServiceAgreementStateServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<
            TermsOfServiceAgreementStateServiceBlockingStub>() {
          @java.lang.Override
          public TermsOfServiceAgreementStateServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TermsOfServiceAgreementStateServiceBlockingStub(channel, callOptions);
          }
        };
    return TermsOfServiceAgreementStateServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TermsOfServiceAgreementStateServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TermsOfServiceAgreementStateServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TermsOfServiceAgreementStateServiceFutureStub>() {
          @java.lang.Override
          public TermsOfServiceAgreementStateServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TermsOfServiceAgreementStateServiceFutureStub(channel, callOptions);
          }
        };
    return TermsOfServiceAgreementStateServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to support `TermsOfServiceAgreementState` API.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Returns the state of a terms of service agreement.
     * </pre>
     */
    default void getTermsOfServiceAgreementState(
        com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceAgreementStateRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTermsOfServiceAgreementStateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the state of the agreement for the application terms of service.
     * </pre>
     */
    default void retrieveForApplicationTermsOfServiceAgreementState(
        com.google.shopping.merchant.accounts.v1beta
                .RetrieveForApplicationTermsOfServiceAgreementStateRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRetrieveForApplicationTermsOfServiceAgreementStateMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TermsOfServiceAgreementStateService.
   *
   * <pre>
   * Service to support `TermsOfServiceAgreementState` API.
   * </pre>
   */
  public abstract static class TermsOfServiceAgreementStateServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return TermsOfServiceAgreementStateServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service
   * TermsOfServiceAgreementStateService.
   *
   * <pre>
   * Service to support `TermsOfServiceAgreementState` API.
   * </pre>
   */
  public static final class TermsOfServiceAgreementStateServiceStub
      extends io.grpc.stub.AbstractAsyncStub<TermsOfServiceAgreementStateServiceStub> {
    private TermsOfServiceAgreementStateServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TermsOfServiceAgreementStateServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TermsOfServiceAgreementStateServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the state of a terms of service agreement.
     * </pre>
     */
    public void getTermsOfServiceAgreementState(
        com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceAgreementStateRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTermsOfServiceAgreementStateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the state of the agreement for the application terms of service.
     * </pre>
     */
    public void retrieveForApplicationTermsOfServiceAgreementState(
        com.google.shopping.merchant.accounts.v1beta
                .RetrieveForApplicationTermsOfServiceAgreementStateRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(
                  getRetrieveForApplicationTermsOfServiceAgreementStateMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service
   * TermsOfServiceAgreementStateService.
   *
   * <pre>
   * Service to support `TermsOfServiceAgreementState` API.
   * </pre>
   */
  public static final class TermsOfServiceAgreementStateServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TermsOfServiceAgreementStateServiceBlockingStub> {
    private TermsOfServiceAgreementStateServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TermsOfServiceAgreementStateServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TermsOfServiceAgreementStateServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the state of a terms of service agreement.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState
        getTermsOfServiceAgreementState(
            com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceAgreementStateRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTermsOfServiceAgreementStateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the state of the agreement for the application terms of service.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState
        retrieveForApplicationTermsOfServiceAgreementState(
            com.google.shopping.merchant.accounts.v1beta
                    .RetrieveForApplicationTermsOfServiceAgreementStateRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getRetrieveForApplicationTermsOfServiceAgreementStateMethod(),
          getCallOptions(),
          request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * TermsOfServiceAgreementStateService.
   *
   * <pre>
   * Service to support `TermsOfServiceAgreementState` API.
   * </pre>
   */
  public static final class TermsOfServiceAgreementStateServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<TermsOfServiceAgreementStateServiceFutureStub> {
    private TermsOfServiceAgreementStateServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TermsOfServiceAgreementStateServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TermsOfServiceAgreementStateServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the state of a terms of service agreement.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState>
        getTermsOfServiceAgreementState(
            com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceAgreementStateRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTermsOfServiceAgreementStateMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the state of the agreement for the application terms of service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState>
        retrieveForApplicationTermsOfServiceAgreementState(
            com.google.shopping.merchant.accounts.v1beta
                    .RetrieveForApplicationTermsOfServiceAgreementStateRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(
                  getRetrieveForApplicationTermsOfServiceAgreementStateMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_GET_TERMS_OF_SERVICE_AGREEMENT_STATE = 0;
  private static final int METHODID_RETRIEVE_FOR_APPLICATION_TERMS_OF_SERVICE_AGREEMENT_STATE = 1;

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
        case METHODID_GET_TERMS_OF_SERVICE_AGREEMENT_STATE:
          serviceImpl.getTermsOfServiceAgreementState(
              (com.google.shopping.merchant.accounts.v1beta.GetTermsOfServiceAgreementStateRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState>)
                  responseObserver);
          break;
        case METHODID_RETRIEVE_FOR_APPLICATION_TERMS_OF_SERVICE_AGREEMENT_STATE:
          serviceImpl.retrieveForApplicationTermsOfServiceAgreementState(
              (com.google.shopping.merchant.accounts.v1beta
                      .RetrieveForApplicationTermsOfServiceAgreementStateRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState>)
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
            getGetTermsOfServiceAgreementStateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta
                        .GetTermsOfServiceAgreementStateRequest,
                    com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState>(
                    service, METHODID_GET_TERMS_OF_SERVICE_AGREEMENT_STATE)))
        .addMethod(
            getRetrieveForApplicationTermsOfServiceAgreementStateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta
                        .RetrieveForApplicationTermsOfServiceAgreementStateRequest,
                    com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementState>(
                    service, METHODID_RETRIEVE_FOR_APPLICATION_TERMS_OF_SERVICE_AGREEMENT_STATE)))
        .build();
  }

  private abstract static class TermsOfServiceAgreementStateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TermsOfServiceAgreementStateServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1beta.TermsOfServiceAgreementStateProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TermsOfServiceAgreementStateService");
    }
  }

  private static final class TermsOfServiceAgreementStateServiceFileDescriptorSupplier
      extends TermsOfServiceAgreementStateServiceBaseDescriptorSupplier {
    TermsOfServiceAgreementStateServiceFileDescriptorSupplier() {}
  }

  private static final class TermsOfServiceAgreementStateServiceMethodDescriptorSupplier
      extends TermsOfServiceAgreementStateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TermsOfServiceAgreementStateServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (TermsOfServiceAgreementStateServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new TermsOfServiceAgreementStateServiceFileDescriptorSupplier())
                      .addMethod(getGetTermsOfServiceAgreementStateMethod())
                      .addMethod(getRetrieveForApplicationTermsOfServiceAgreementStateMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
