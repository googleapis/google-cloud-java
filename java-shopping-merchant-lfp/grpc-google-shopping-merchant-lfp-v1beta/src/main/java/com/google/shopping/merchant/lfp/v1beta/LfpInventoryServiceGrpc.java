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
 * partner](https://support.google.com/merchants/answer/7676652) to submit local
 * inventories for a merchant.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/lfp/v1beta/lfpinventory.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LfpInventoryServiceGrpc {

  private LfpInventoryServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.lfp.v1beta.LfpInventoryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.lfp.v1beta.InsertLfpInventoryRequest,
          com.google.shopping.merchant.lfp.v1beta.LfpInventory>
      getInsertLfpInventoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InsertLfpInventory",
      requestType = com.google.shopping.merchant.lfp.v1beta.InsertLfpInventoryRequest.class,
      responseType = com.google.shopping.merchant.lfp.v1beta.LfpInventory.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.lfp.v1beta.InsertLfpInventoryRequest,
          com.google.shopping.merchant.lfp.v1beta.LfpInventory>
      getInsertLfpInventoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.lfp.v1beta.InsertLfpInventoryRequest,
            com.google.shopping.merchant.lfp.v1beta.LfpInventory>
        getInsertLfpInventoryMethod;
    if ((getInsertLfpInventoryMethod = LfpInventoryServiceGrpc.getInsertLfpInventoryMethod)
        == null) {
      synchronized (LfpInventoryServiceGrpc.class) {
        if ((getInsertLfpInventoryMethod = LfpInventoryServiceGrpc.getInsertLfpInventoryMethod)
            == null) {
          LfpInventoryServiceGrpc.getInsertLfpInventoryMethod =
              getInsertLfpInventoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.lfp.v1beta.InsertLfpInventoryRequest,
                          com.google.shopping.merchant.lfp.v1beta.LfpInventory>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InsertLfpInventory"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.lfp.v1beta.InsertLfpInventoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.lfp.v1beta.LfpInventory
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LfpInventoryServiceMethodDescriptorSupplier("InsertLfpInventory"))
                      .build();
        }
      }
    }
    return getInsertLfpInventoryMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static LfpInventoryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LfpInventoryServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LfpInventoryServiceStub>() {
          @java.lang.Override
          public LfpInventoryServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LfpInventoryServiceStub(channel, callOptions);
          }
        };
    return LfpInventoryServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LfpInventoryServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LfpInventoryServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LfpInventoryServiceBlockingStub>() {
          @java.lang.Override
          public LfpInventoryServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LfpInventoryServiceBlockingStub(channel, callOptions);
          }
        };
    return LfpInventoryServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static LfpInventoryServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LfpInventoryServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LfpInventoryServiceFutureStub>() {
          @java.lang.Override
          public LfpInventoryServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LfpInventoryServiceFutureStub(channel, callOptions);
          }
        };
    return LfpInventoryServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for a [LFP
   * partner](https://support.google.com/merchants/answer/7676652) to submit local
   * inventories for a merchant.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Inserts a `LfpInventory` resource for the given target merchant account. If
     * the resource already exists, it will be replaced. The inventory
     * automatically expires after 30 days.
     * </pre>
     */
    default void insertLfpInventory(
        com.google.shopping.merchant.lfp.v1beta.InsertLfpInventoryRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.lfp.v1beta.LfpInventory>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getInsertLfpInventoryMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LfpInventoryService.
   *
   * <pre>
   * Service for a [LFP
   * partner](https://support.google.com/merchants/answer/7676652) to submit local
   * inventories for a merchant.
   * </pre>
   */
  public abstract static class LfpInventoryServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return LfpInventoryServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LfpInventoryService.
   *
   * <pre>
   * Service for a [LFP
   * partner](https://support.google.com/merchants/answer/7676652) to submit local
   * inventories for a merchant.
   * </pre>
   */
  public static final class LfpInventoryServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LfpInventoryServiceStub> {
    private LfpInventoryServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LfpInventoryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LfpInventoryServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Inserts a `LfpInventory` resource for the given target merchant account. If
     * the resource already exists, it will be replaced. The inventory
     * automatically expires after 30 days.
     * </pre>
     */
    public void insertLfpInventory(
        com.google.shopping.merchant.lfp.v1beta.InsertLfpInventoryRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.lfp.v1beta.LfpInventory>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInsertLfpInventoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LfpInventoryService.
   *
   * <pre>
   * Service for a [LFP
   * partner](https://support.google.com/merchants/answer/7676652) to submit local
   * inventories for a merchant.
   * </pre>
   */
  public static final class LfpInventoryServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LfpInventoryServiceBlockingStub> {
    private LfpInventoryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LfpInventoryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LfpInventoryServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Inserts a `LfpInventory` resource for the given target merchant account. If
     * the resource already exists, it will be replaced. The inventory
     * automatically expires after 30 days.
     * </pre>
     */
    public com.google.shopping.merchant.lfp.v1beta.LfpInventory insertLfpInventory(
        com.google.shopping.merchant.lfp.v1beta.InsertLfpInventoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInsertLfpInventoryMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LfpInventoryService.
   *
   * <pre>
   * Service for a [LFP
   * partner](https://support.google.com/merchants/answer/7676652) to submit local
   * inventories for a merchant.
   * </pre>
   */
  public static final class LfpInventoryServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LfpInventoryServiceFutureStub> {
    private LfpInventoryServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LfpInventoryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LfpInventoryServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Inserts a `LfpInventory` resource for the given target merchant account. If
     * the resource already exists, it will be replaced. The inventory
     * automatically expires after 30 days.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.lfp.v1beta.LfpInventory>
        insertLfpInventory(
            com.google.shopping.merchant.lfp.v1beta.InsertLfpInventoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInsertLfpInventoryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INSERT_LFP_INVENTORY = 0;

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
        case METHODID_INSERT_LFP_INVENTORY:
          serviceImpl.insertLfpInventory(
              (com.google.shopping.merchant.lfp.v1beta.InsertLfpInventoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.lfp.v1beta.LfpInventory>)
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
            getInsertLfpInventoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.lfp.v1beta.InsertLfpInventoryRequest,
                    com.google.shopping.merchant.lfp.v1beta.LfpInventory>(
                    service, METHODID_INSERT_LFP_INVENTORY)))
        .build();
  }

  private abstract static class LfpInventoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LfpInventoryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.lfp.v1beta.LfpInventoryProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LfpInventoryService");
    }
  }

  private static final class LfpInventoryServiceFileDescriptorSupplier
      extends LfpInventoryServiceBaseDescriptorSupplier {
    LfpInventoryServiceFileDescriptorSupplier() {}
  }

  private static final class LfpInventoryServiceMethodDescriptorSupplier
      extends LfpInventoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LfpInventoryServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LfpInventoryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new LfpInventoryServiceFileDescriptorSupplier())
                      .addMethod(getInsertLfpInventoryMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
