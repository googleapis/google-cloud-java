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
package com.google.shopping.merchant.lfp.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for a [LFP
 * partner](https://support.google.com/merchants/answer/7676652) to get the
 * state of a merchant.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/lfp/v1beta/lfpmerchantstate.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LfpMerchantStateServiceGrpc {

  private LfpMerchantStateServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.lfp.v1beta.LfpMerchantStateService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.lfp.v1beta.GetLfpMerchantStateRequest,
          com.google.shopping.merchant.lfp.v1beta.LfpMerchantState>
      getGetLfpMerchantStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLfpMerchantState",
      requestType = com.google.shopping.merchant.lfp.v1beta.GetLfpMerchantStateRequest.class,
      responseType = com.google.shopping.merchant.lfp.v1beta.LfpMerchantState.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.lfp.v1beta.GetLfpMerchantStateRequest,
          com.google.shopping.merchant.lfp.v1beta.LfpMerchantState>
      getGetLfpMerchantStateMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.lfp.v1beta.GetLfpMerchantStateRequest,
            com.google.shopping.merchant.lfp.v1beta.LfpMerchantState>
        getGetLfpMerchantStateMethod;
    if ((getGetLfpMerchantStateMethod = LfpMerchantStateServiceGrpc.getGetLfpMerchantStateMethod)
        == null) {
      synchronized (LfpMerchantStateServiceGrpc.class) {
        if ((getGetLfpMerchantStateMethod =
                LfpMerchantStateServiceGrpc.getGetLfpMerchantStateMethod)
            == null) {
          LfpMerchantStateServiceGrpc.getGetLfpMerchantStateMethod =
              getGetLfpMerchantStateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.lfp.v1beta.GetLfpMerchantStateRequest,
                          com.google.shopping.merchant.lfp.v1beta.LfpMerchantState>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetLfpMerchantState"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.lfp.v1beta.GetLfpMerchantStateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.lfp.v1beta.LfpMerchantState
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LfpMerchantStateServiceMethodDescriptorSupplier(
                              "GetLfpMerchantState"))
                      .build();
        }
      }
    }
    return getGetLfpMerchantStateMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static LfpMerchantStateServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LfpMerchantStateServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LfpMerchantStateServiceStub>() {
          @java.lang.Override
          public LfpMerchantStateServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LfpMerchantStateServiceStub(channel, callOptions);
          }
        };
    return LfpMerchantStateServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LfpMerchantStateServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LfpMerchantStateServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LfpMerchantStateServiceBlockingStub>() {
          @java.lang.Override
          public LfpMerchantStateServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LfpMerchantStateServiceBlockingStub(channel, callOptions);
          }
        };
    return LfpMerchantStateServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static LfpMerchantStateServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LfpMerchantStateServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LfpMerchantStateServiceFutureStub>() {
          @java.lang.Override
          public LfpMerchantStateServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LfpMerchantStateServiceFutureStub(channel, callOptions);
          }
        };
    return LfpMerchantStateServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for a [LFP
   * partner](https://support.google.com/merchants/answer/7676652) to get the
   * state of a merchant.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets the LFP state of a merchant
     * </pre>
     */
    default void getLfpMerchantState(
        com.google.shopping.merchant.lfp.v1beta.GetLfpMerchantStateRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.lfp.v1beta.LfpMerchantState>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetLfpMerchantStateMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LfpMerchantStateService.
   *
   * <pre>
   * Service for a [LFP
   * partner](https://support.google.com/merchants/answer/7676652) to get the
   * state of a merchant.
   * </pre>
   */
  public abstract static class LfpMerchantStateServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return LfpMerchantStateServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LfpMerchantStateService.
   *
   * <pre>
   * Service for a [LFP
   * partner](https://support.google.com/merchants/answer/7676652) to get the
   * state of a merchant.
   * </pre>
   */
  public static final class LfpMerchantStateServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LfpMerchantStateServiceStub> {
    private LfpMerchantStateServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LfpMerchantStateServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LfpMerchantStateServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the LFP state of a merchant
     * </pre>
     */
    public void getLfpMerchantState(
        com.google.shopping.merchant.lfp.v1beta.GetLfpMerchantStateRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.lfp.v1beta.LfpMerchantState>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLfpMerchantStateMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LfpMerchantStateService.
   *
   * <pre>
   * Service for a [LFP
   * partner](https://support.google.com/merchants/answer/7676652) to get the
   * state of a merchant.
   * </pre>
   */
  public static final class LfpMerchantStateServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LfpMerchantStateServiceBlockingStub> {
    private LfpMerchantStateServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LfpMerchantStateServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LfpMerchantStateServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the LFP state of a merchant
     * </pre>
     */
    public com.google.shopping.merchant.lfp.v1beta.LfpMerchantState getLfpMerchantState(
        com.google.shopping.merchant.lfp.v1beta.GetLfpMerchantStateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLfpMerchantStateMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * LfpMerchantStateService.
   *
   * <pre>
   * Service for a [LFP
   * partner](https://support.google.com/merchants/answer/7676652) to get the
   * state of a merchant.
   * </pre>
   */
  public static final class LfpMerchantStateServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LfpMerchantStateServiceFutureStub> {
    private LfpMerchantStateServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LfpMerchantStateServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LfpMerchantStateServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the LFP state of a merchant
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.lfp.v1beta.LfpMerchantState>
        getLfpMerchantState(
            com.google.shopping.merchant.lfp.v1beta.GetLfpMerchantStateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLfpMerchantStateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_LFP_MERCHANT_STATE = 0;

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
        case METHODID_GET_LFP_MERCHANT_STATE:
          serviceImpl.getLfpMerchantState(
              (com.google.shopping.merchant.lfp.v1beta.GetLfpMerchantStateRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.lfp.v1beta.LfpMerchantState>)
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
            getGetLfpMerchantStateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.lfp.v1beta.GetLfpMerchantStateRequest,
                    com.google.shopping.merchant.lfp.v1beta.LfpMerchantState>(
                    service, METHODID_GET_LFP_MERCHANT_STATE)))
        .build();
  }

  private abstract static class LfpMerchantStateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LfpMerchantStateServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.lfp.v1beta.LfpMerchantStateProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LfpMerchantStateService");
    }
  }

  private static final class LfpMerchantStateServiceFileDescriptorSupplier
      extends LfpMerchantStateServiceBaseDescriptorSupplier {
    LfpMerchantStateServiceFileDescriptorSupplier() {}
  }

  private static final class LfpMerchantStateServiceMethodDescriptorSupplier
      extends LfpMerchantStateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LfpMerchantStateServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LfpMerchantStateServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new LfpMerchantStateServiceFileDescriptorSupplier())
                      .addMethod(getGetLfpMerchantStateMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
