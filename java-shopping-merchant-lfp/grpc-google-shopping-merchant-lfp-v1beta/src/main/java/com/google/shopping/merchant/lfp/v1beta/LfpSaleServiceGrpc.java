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
package com.google.shopping.merchant.lfp.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for a [LFP
 * partner](https://support.google.com/merchants/answer/7676652) to submit sales
 * data for a merchant.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/lfp/v1beta/lfpsale.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LfpSaleServiceGrpc {

  private LfpSaleServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.lfp.v1beta.LfpSaleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.lfp.v1beta.InsertLfpSaleRequest,
          com.google.shopping.merchant.lfp.v1beta.LfpSale>
      getInsertLfpSaleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InsertLfpSale",
      requestType = com.google.shopping.merchant.lfp.v1beta.InsertLfpSaleRequest.class,
      responseType = com.google.shopping.merchant.lfp.v1beta.LfpSale.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.lfp.v1beta.InsertLfpSaleRequest,
          com.google.shopping.merchant.lfp.v1beta.LfpSale>
      getInsertLfpSaleMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.lfp.v1beta.InsertLfpSaleRequest,
            com.google.shopping.merchant.lfp.v1beta.LfpSale>
        getInsertLfpSaleMethod;
    if ((getInsertLfpSaleMethod = LfpSaleServiceGrpc.getInsertLfpSaleMethod) == null) {
      synchronized (LfpSaleServiceGrpc.class) {
        if ((getInsertLfpSaleMethod = LfpSaleServiceGrpc.getInsertLfpSaleMethod) == null) {
          LfpSaleServiceGrpc.getInsertLfpSaleMethod =
              getInsertLfpSaleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.lfp.v1beta.InsertLfpSaleRequest,
                          com.google.shopping.merchant.lfp.v1beta.LfpSale>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InsertLfpSale"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.lfp.v1beta.InsertLfpSaleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.lfp.v1beta.LfpSale.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LfpSaleServiceMethodDescriptorSupplier("InsertLfpSale"))
                      .build();
        }
      }
    }
    return getInsertLfpSaleMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static LfpSaleServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LfpSaleServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LfpSaleServiceStub>() {
          @java.lang.Override
          public LfpSaleServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LfpSaleServiceStub(channel, callOptions);
          }
        };
    return LfpSaleServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LfpSaleServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LfpSaleServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LfpSaleServiceBlockingStub>() {
          @java.lang.Override
          public LfpSaleServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LfpSaleServiceBlockingStub(channel, callOptions);
          }
        };
    return LfpSaleServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static LfpSaleServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LfpSaleServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LfpSaleServiceFutureStub>() {
          @java.lang.Override
          public LfpSaleServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LfpSaleServiceFutureStub(channel, callOptions);
          }
        };
    return LfpSaleServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for a [LFP
   * partner](https://support.google.com/merchants/answer/7676652) to submit sales
   * data for a merchant.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Inserts a `LfpSale` for the given merchant.
     * </pre>
     */
    default void insertLfpSale(
        com.google.shopping.merchant.lfp.v1beta.InsertLfpSaleRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.lfp.v1beta.LfpSale>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getInsertLfpSaleMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LfpSaleService.
   *
   * <pre>
   * Service for a [LFP
   * partner](https://support.google.com/merchants/answer/7676652) to submit sales
   * data for a merchant.
   * </pre>
   */
  public abstract static class LfpSaleServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return LfpSaleServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LfpSaleService.
   *
   * <pre>
   * Service for a [LFP
   * partner](https://support.google.com/merchants/answer/7676652) to submit sales
   * data for a merchant.
   * </pre>
   */
  public static final class LfpSaleServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LfpSaleServiceStub> {
    private LfpSaleServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LfpSaleServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LfpSaleServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Inserts a `LfpSale` for the given merchant.
     * </pre>
     */
    public void insertLfpSale(
        com.google.shopping.merchant.lfp.v1beta.InsertLfpSaleRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.lfp.v1beta.LfpSale>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInsertLfpSaleMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LfpSaleService.
   *
   * <pre>
   * Service for a [LFP
   * partner](https://support.google.com/merchants/answer/7676652) to submit sales
   * data for a merchant.
   * </pre>
   */
  public static final class LfpSaleServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LfpSaleServiceBlockingStub> {
    private LfpSaleServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LfpSaleServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LfpSaleServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Inserts a `LfpSale` for the given merchant.
     * </pre>
     */
    public com.google.shopping.merchant.lfp.v1beta.LfpSale insertLfpSale(
        com.google.shopping.merchant.lfp.v1beta.InsertLfpSaleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInsertLfpSaleMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LfpSaleService.
   *
   * <pre>
   * Service for a [LFP
   * partner](https://support.google.com/merchants/answer/7676652) to submit sales
   * data for a merchant.
   * </pre>
   */
  public static final class LfpSaleServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LfpSaleServiceFutureStub> {
    private LfpSaleServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LfpSaleServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LfpSaleServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Inserts a `LfpSale` for the given merchant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.lfp.v1beta.LfpSale>
        insertLfpSale(com.google.shopping.merchant.lfp.v1beta.InsertLfpSaleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInsertLfpSaleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INSERT_LFP_SALE = 0;

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
        case METHODID_INSERT_LFP_SALE:
          serviceImpl.insertLfpSale(
              (com.google.shopping.merchant.lfp.v1beta.InsertLfpSaleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.lfp.v1beta.LfpSale>)
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
            getInsertLfpSaleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.lfp.v1beta.InsertLfpSaleRequest,
                    com.google.shopping.merchant.lfp.v1beta.LfpSale>(
                    service, METHODID_INSERT_LFP_SALE)))
        .build();
  }

  private abstract static class LfpSaleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LfpSaleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.lfp.v1beta.LfpSaleProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LfpSaleService");
    }
  }

  private static final class LfpSaleServiceFileDescriptorSupplier
      extends LfpSaleServiceBaseDescriptorSupplier {
    LfpSaleServiceFileDescriptorSupplier() {}
  }

  private static final class LfpSaleServiceMethodDescriptorSupplier
      extends LfpSaleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LfpSaleServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LfpSaleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new LfpSaleServiceFileDescriptorSupplier())
                      .addMethod(getInsertLfpSaleMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
