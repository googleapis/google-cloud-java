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
package com.google.cloud.dialogflow.v2beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing
 * [Fulfillments][google.cloud.dialogflow.v2beta1.Fulfillment].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2beta1/fulfillment.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FulfillmentsGrpc {

  private FulfillmentsGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.dialogflow.v2beta1.Fulfillments";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetFulfillmentRequest,
          com.google.cloud.dialogflow.v2beta1.Fulfillment>
      getGetFulfillmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFulfillment",
      requestType = com.google.cloud.dialogflow.v2beta1.GetFulfillmentRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.Fulfillment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetFulfillmentRequest,
          com.google.cloud.dialogflow.v2beta1.Fulfillment>
      getGetFulfillmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.GetFulfillmentRequest,
            com.google.cloud.dialogflow.v2beta1.Fulfillment>
        getGetFulfillmentMethod;
    if ((getGetFulfillmentMethod = FulfillmentsGrpc.getGetFulfillmentMethod) == null) {
      synchronized (FulfillmentsGrpc.class) {
        if ((getGetFulfillmentMethod = FulfillmentsGrpc.getGetFulfillmentMethod) == null) {
          FulfillmentsGrpc.getGetFulfillmentMethod =
              getGetFulfillmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.GetFulfillmentRequest,
                          com.google.cloud.dialogflow.v2beta1.Fulfillment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFulfillment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.GetFulfillmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.Fulfillment.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FulfillmentsMethodDescriptorSupplier("GetFulfillment"))
                      .build();
        }
      }
    }
    return getGetFulfillmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdateFulfillmentRequest,
          com.google.cloud.dialogflow.v2beta1.Fulfillment>
      getUpdateFulfillmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFulfillment",
      requestType = com.google.cloud.dialogflow.v2beta1.UpdateFulfillmentRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.Fulfillment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdateFulfillmentRequest,
          com.google.cloud.dialogflow.v2beta1.Fulfillment>
      getUpdateFulfillmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.UpdateFulfillmentRequest,
            com.google.cloud.dialogflow.v2beta1.Fulfillment>
        getUpdateFulfillmentMethod;
    if ((getUpdateFulfillmentMethod = FulfillmentsGrpc.getUpdateFulfillmentMethod) == null) {
      synchronized (FulfillmentsGrpc.class) {
        if ((getUpdateFulfillmentMethod = FulfillmentsGrpc.getUpdateFulfillmentMethod) == null) {
          FulfillmentsGrpc.getUpdateFulfillmentMethod =
              getUpdateFulfillmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.UpdateFulfillmentRequest,
                          com.google.cloud.dialogflow.v2beta1.Fulfillment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFulfillment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.UpdateFulfillmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.Fulfillment.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FulfillmentsMethodDescriptorSupplier("UpdateFulfillment"))
                      .build();
        }
      }
    }
    return getUpdateFulfillmentMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static FulfillmentsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FulfillmentsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FulfillmentsStub>() {
          @java.lang.Override
          public FulfillmentsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FulfillmentsStub(channel, callOptions);
          }
        };
    return FulfillmentsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FulfillmentsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FulfillmentsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FulfillmentsBlockingStub>() {
          @java.lang.Override
          public FulfillmentsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FulfillmentsBlockingStub(channel, callOptions);
          }
        };
    return FulfillmentsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static FulfillmentsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FulfillmentsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FulfillmentsFutureStub>() {
          @java.lang.Override
          public FulfillmentsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FulfillmentsFutureStub(channel, callOptions);
          }
        };
    return FulfillmentsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing
   * [Fulfillments][google.cloud.dialogflow.v2beta1.Fulfillment].
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves the fulfillment.
     * </pre>
     */
    default void getFulfillment(
        com.google.cloud.dialogflow.v2beta1.GetFulfillmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Fulfillment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetFulfillmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the fulfillment.
     * </pre>
     */
    default void updateFulfillment(
        com.google.cloud.dialogflow.v2beta1.UpdateFulfillmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Fulfillment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFulfillmentMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Fulfillments.
   *
   * <pre>
   * Service for managing
   * [Fulfillments][google.cloud.dialogflow.v2beta1.Fulfillment].
   * </pre>
   */
  public abstract static class FulfillmentsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return FulfillmentsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Fulfillments.
   *
   * <pre>
   * Service for managing
   * [Fulfillments][google.cloud.dialogflow.v2beta1.Fulfillment].
   * </pre>
   */
  public static final class FulfillmentsStub
      extends io.grpc.stub.AbstractAsyncStub<FulfillmentsStub> {
    private FulfillmentsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FulfillmentsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FulfillmentsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the fulfillment.
     * </pre>
     */
    public void getFulfillment(
        com.google.cloud.dialogflow.v2beta1.GetFulfillmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Fulfillment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFulfillmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the fulfillment.
     * </pre>
     */
    public void updateFulfillment(
        com.google.cloud.dialogflow.v2beta1.UpdateFulfillmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Fulfillment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFulfillmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Fulfillments.
   *
   * <pre>
   * Service for managing
   * [Fulfillments][google.cloud.dialogflow.v2beta1.Fulfillment].
   * </pre>
   */
  public static final class FulfillmentsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FulfillmentsBlockingStub> {
    private FulfillmentsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FulfillmentsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FulfillmentsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the fulfillment.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.Fulfillment getFulfillment(
        com.google.cloud.dialogflow.v2beta1.GetFulfillmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFulfillmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the fulfillment.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.Fulfillment updateFulfillment(
        com.google.cloud.dialogflow.v2beta1.UpdateFulfillmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFulfillmentMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Fulfillments.
   *
   * <pre>
   * Service for managing
   * [Fulfillments][google.cloud.dialogflow.v2beta1.Fulfillment].
   * </pre>
   */
  public static final class FulfillmentsFutureStub
      extends io.grpc.stub.AbstractFutureStub<FulfillmentsFutureStub> {
    private FulfillmentsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FulfillmentsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FulfillmentsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the fulfillment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.Fulfillment>
        getFulfillment(com.google.cloud.dialogflow.v2beta1.GetFulfillmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFulfillmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the fulfillment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.Fulfillment>
        updateFulfillment(com.google.cloud.dialogflow.v2beta1.UpdateFulfillmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFulfillmentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FULFILLMENT = 0;
  private static final int METHODID_UPDATE_FULFILLMENT = 1;

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
        case METHODID_GET_FULFILLMENT:
          serviceImpl.getFulfillment(
              (com.google.cloud.dialogflow.v2beta1.GetFulfillmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Fulfillment>)
                  responseObserver);
          break;
        case METHODID_UPDATE_FULFILLMENT:
          serviceImpl.updateFulfillment(
              (com.google.cloud.dialogflow.v2beta1.UpdateFulfillmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Fulfillment>)
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
            getGetFulfillmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2beta1.GetFulfillmentRequest,
                    com.google.cloud.dialogflow.v2beta1.Fulfillment>(
                    service, METHODID_GET_FULFILLMENT)))
        .addMethod(
            getUpdateFulfillmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2beta1.UpdateFulfillmentRequest,
                    com.google.cloud.dialogflow.v2beta1.Fulfillment>(
                    service, METHODID_UPDATE_FULFILLMENT)))
        .build();
  }

  private abstract static class FulfillmentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FulfillmentsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2beta1.FulfillmentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Fulfillments");
    }
  }

  private static final class FulfillmentsFileDescriptorSupplier
      extends FulfillmentsBaseDescriptorSupplier {
    FulfillmentsFileDescriptorSupplier() {}
  }

  private static final class FulfillmentsMethodDescriptorSupplier
      extends FulfillmentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FulfillmentsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FulfillmentsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new FulfillmentsFileDescriptorSupplier())
                      .addMethod(getGetFulfillmentMethod())
                      .addMethod(getUpdateFulfillmentMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
