/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.support.v2beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing customer support event subscriptions.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SupportEventSubscriptionServiceGrpc {

  private SupportEventSubscriptionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.support.v2beta.SupportEventSubscriptionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.support.v2beta.CreateSupportEventSubscriptionRequest,
          com.google.cloud.support.v2beta.SupportEventSubscription>
      getCreateSupportEventSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSupportEventSubscription",
      requestType = com.google.cloud.support.v2beta.CreateSupportEventSubscriptionRequest.class,
      responseType = com.google.cloud.support.v2beta.SupportEventSubscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.support.v2beta.CreateSupportEventSubscriptionRequest,
          com.google.cloud.support.v2beta.SupportEventSubscription>
      getCreateSupportEventSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.support.v2beta.CreateSupportEventSubscriptionRequest,
            com.google.cloud.support.v2beta.SupportEventSubscription>
        getCreateSupportEventSubscriptionMethod;
    if ((getCreateSupportEventSubscriptionMethod =
            SupportEventSubscriptionServiceGrpc.getCreateSupportEventSubscriptionMethod)
        == null) {
      synchronized (SupportEventSubscriptionServiceGrpc.class) {
        if ((getCreateSupportEventSubscriptionMethod =
                SupportEventSubscriptionServiceGrpc.getCreateSupportEventSubscriptionMethod)
            == null) {
          SupportEventSubscriptionServiceGrpc.getCreateSupportEventSubscriptionMethod =
              getCreateSupportEventSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.support.v2beta.CreateSupportEventSubscriptionRequest,
                          com.google.cloud.support.v2beta.SupportEventSubscription>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateSupportEventSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2beta.CreateSupportEventSubscriptionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2beta.SupportEventSubscription
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SupportEventSubscriptionServiceMethodDescriptorSupplier(
                              "CreateSupportEventSubscription"))
                      .build();
        }
      }
    }
    return getCreateSupportEventSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.support.v2beta.GetSupportEventSubscriptionRequest,
          com.google.cloud.support.v2beta.SupportEventSubscription>
      getGetSupportEventSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSupportEventSubscription",
      requestType = com.google.cloud.support.v2beta.GetSupportEventSubscriptionRequest.class,
      responseType = com.google.cloud.support.v2beta.SupportEventSubscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.support.v2beta.GetSupportEventSubscriptionRequest,
          com.google.cloud.support.v2beta.SupportEventSubscription>
      getGetSupportEventSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.support.v2beta.GetSupportEventSubscriptionRequest,
            com.google.cloud.support.v2beta.SupportEventSubscription>
        getGetSupportEventSubscriptionMethod;
    if ((getGetSupportEventSubscriptionMethod =
            SupportEventSubscriptionServiceGrpc.getGetSupportEventSubscriptionMethod)
        == null) {
      synchronized (SupportEventSubscriptionServiceGrpc.class) {
        if ((getGetSupportEventSubscriptionMethod =
                SupportEventSubscriptionServiceGrpc.getGetSupportEventSubscriptionMethod)
            == null) {
          SupportEventSubscriptionServiceGrpc.getGetSupportEventSubscriptionMethod =
              getGetSupportEventSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.support.v2beta.GetSupportEventSubscriptionRequest,
                          com.google.cloud.support.v2beta.SupportEventSubscription>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetSupportEventSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2beta.GetSupportEventSubscriptionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2beta.SupportEventSubscription
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SupportEventSubscriptionServiceMethodDescriptorSupplier(
                              "GetSupportEventSubscription"))
                      .build();
        }
      }
    }
    return getGetSupportEventSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.support.v2beta.ListSupportEventSubscriptionsRequest,
          com.google.cloud.support.v2beta.ListSupportEventSubscriptionsResponse>
      getListSupportEventSubscriptionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSupportEventSubscriptions",
      requestType = com.google.cloud.support.v2beta.ListSupportEventSubscriptionsRequest.class,
      responseType = com.google.cloud.support.v2beta.ListSupportEventSubscriptionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.support.v2beta.ListSupportEventSubscriptionsRequest,
          com.google.cloud.support.v2beta.ListSupportEventSubscriptionsResponse>
      getListSupportEventSubscriptionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.support.v2beta.ListSupportEventSubscriptionsRequest,
            com.google.cloud.support.v2beta.ListSupportEventSubscriptionsResponse>
        getListSupportEventSubscriptionsMethod;
    if ((getListSupportEventSubscriptionsMethod =
            SupportEventSubscriptionServiceGrpc.getListSupportEventSubscriptionsMethod)
        == null) {
      synchronized (SupportEventSubscriptionServiceGrpc.class) {
        if ((getListSupportEventSubscriptionsMethod =
                SupportEventSubscriptionServiceGrpc.getListSupportEventSubscriptionsMethod)
            == null) {
          SupportEventSubscriptionServiceGrpc.getListSupportEventSubscriptionsMethod =
              getListSupportEventSubscriptionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.support.v2beta.ListSupportEventSubscriptionsRequest,
                          com.google.cloud.support.v2beta.ListSupportEventSubscriptionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListSupportEventSubscriptions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2beta.ListSupportEventSubscriptionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2beta.ListSupportEventSubscriptionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SupportEventSubscriptionServiceMethodDescriptorSupplier(
                              "ListSupportEventSubscriptions"))
                      .build();
        }
      }
    }
    return getListSupportEventSubscriptionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.support.v2beta.UpdateSupportEventSubscriptionRequest,
          com.google.cloud.support.v2beta.SupportEventSubscription>
      getUpdateSupportEventSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSupportEventSubscription",
      requestType = com.google.cloud.support.v2beta.UpdateSupportEventSubscriptionRequest.class,
      responseType = com.google.cloud.support.v2beta.SupportEventSubscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.support.v2beta.UpdateSupportEventSubscriptionRequest,
          com.google.cloud.support.v2beta.SupportEventSubscription>
      getUpdateSupportEventSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.support.v2beta.UpdateSupportEventSubscriptionRequest,
            com.google.cloud.support.v2beta.SupportEventSubscription>
        getUpdateSupportEventSubscriptionMethod;
    if ((getUpdateSupportEventSubscriptionMethod =
            SupportEventSubscriptionServiceGrpc.getUpdateSupportEventSubscriptionMethod)
        == null) {
      synchronized (SupportEventSubscriptionServiceGrpc.class) {
        if ((getUpdateSupportEventSubscriptionMethod =
                SupportEventSubscriptionServiceGrpc.getUpdateSupportEventSubscriptionMethod)
            == null) {
          SupportEventSubscriptionServiceGrpc.getUpdateSupportEventSubscriptionMethod =
              getUpdateSupportEventSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.support.v2beta.UpdateSupportEventSubscriptionRequest,
                          com.google.cloud.support.v2beta.SupportEventSubscription>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateSupportEventSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2beta.UpdateSupportEventSubscriptionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2beta.SupportEventSubscription
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SupportEventSubscriptionServiceMethodDescriptorSupplier(
                              "UpdateSupportEventSubscription"))
                      .build();
        }
      }
    }
    return getUpdateSupportEventSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.support.v2beta.DeleteSupportEventSubscriptionRequest,
          com.google.cloud.support.v2beta.SupportEventSubscription>
      getDeleteSupportEventSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSupportEventSubscription",
      requestType = com.google.cloud.support.v2beta.DeleteSupportEventSubscriptionRequest.class,
      responseType = com.google.cloud.support.v2beta.SupportEventSubscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.support.v2beta.DeleteSupportEventSubscriptionRequest,
          com.google.cloud.support.v2beta.SupportEventSubscription>
      getDeleteSupportEventSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.support.v2beta.DeleteSupportEventSubscriptionRequest,
            com.google.cloud.support.v2beta.SupportEventSubscription>
        getDeleteSupportEventSubscriptionMethod;
    if ((getDeleteSupportEventSubscriptionMethod =
            SupportEventSubscriptionServiceGrpc.getDeleteSupportEventSubscriptionMethod)
        == null) {
      synchronized (SupportEventSubscriptionServiceGrpc.class) {
        if ((getDeleteSupportEventSubscriptionMethod =
                SupportEventSubscriptionServiceGrpc.getDeleteSupportEventSubscriptionMethod)
            == null) {
          SupportEventSubscriptionServiceGrpc.getDeleteSupportEventSubscriptionMethod =
              getDeleteSupportEventSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.support.v2beta.DeleteSupportEventSubscriptionRequest,
                          com.google.cloud.support.v2beta.SupportEventSubscription>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteSupportEventSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2beta.DeleteSupportEventSubscriptionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2beta.SupportEventSubscription
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SupportEventSubscriptionServiceMethodDescriptorSupplier(
                              "DeleteSupportEventSubscription"))
                      .build();
        }
      }
    }
    return getDeleteSupportEventSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.support.v2beta.UndeleteSupportEventSubscriptionRequest,
          com.google.cloud.support.v2beta.SupportEventSubscription>
      getUndeleteSupportEventSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeleteSupportEventSubscription",
      requestType = com.google.cloud.support.v2beta.UndeleteSupportEventSubscriptionRequest.class,
      responseType = com.google.cloud.support.v2beta.SupportEventSubscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.support.v2beta.UndeleteSupportEventSubscriptionRequest,
          com.google.cloud.support.v2beta.SupportEventSubscription>
      getUndeleteSupportEventSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.support.v2beta.UndeleteSupportEventSubscriptionRequest,
            com.google.cloud.support.v2beta.SupportEventSubscription>
        getUndeleteSupportEventSubscriptionMethod;
    if ((getUndeleteSupportEventSubscriptionMethod =
            SupportEventSubscriptionServiceGrpc.getUndeleteSupportEventSubscriptionMethod)
        == null) {
      synchronized (SupportEventSubscriptionServiceGrpc.class) {
        if ((getUndeleteSupportEventSubscriptionMethod =
                SupportEventSubscriptionServiceGrpc.getUndeleteSupportEventSubscriptionMethod)
            == null) {
          SupportEventSubscriptionServiceGrpc.getUndeleteSupportEventSubscriptionMethod =
              getUndeleteSupportEventSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.support.v2beta.UndeleteSupportEventSubscriptionRequest,
                          com.google.cloud.support.v2beta.SupportEventSubscription>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UndeleteSupportEventSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2beta
                                  .UndeleteSupportEventSubscriptionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2beta.SupportEventSubscription
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SupportEventSubscriptionServiceMethodDescriptorSupplier(
                              "UndeleteSupportEventSubscription"))
                      .build();
        }
      }
    }
    return getUndeleteSupportEventSubscriptionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SupportEventSubscriptionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SupportEventSubscriptionServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SupportEventSubscriptionServiceStub>() {
          @java.lang.Override
          public SupportEventSubscriptionServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SupportEventSubscriptionServiceStub(channel, callOptions);
          }
        };
    return SupportEventSubscriptionServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SupportEventSubscriptionServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SupportEventSubscriptionServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SupportEventSubscriptionServiceBlockingV2Stub>() {
          @java.lang.Override
          public SupportEventSubscriptionServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SupportEventSubscriptionServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SupportEventSubscriptionServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SupportEventSubscriptionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SupportEventSubscriptionServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SupportEventSubscriptionServiceBlockingStub>() {
          @java.lang.Override
          public SupportEventSubscriptionServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SupportEventSubscriptionServiceBlockingStub(channel, callOptions);
          }
        };
    return SupportEventSubscriptionServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SupportEventSubscriptionServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SupportEventSubscriptionServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SupportEventSubscriptionServiceFutureStub>() {
          @java.lang.Override
          public SupportEventSubscriptionServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SupportEventSubscriptionServiceFutureStub(channel, callOptions);
          }
        };
    return SupportEventSubscriptionServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing customer support event subscriptions.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a support event subscription for an organization.
     * </pre>
     */
    default void createSupportEventSubscription(
        com.google.cloud.support.v2beta.CreateSupportEventSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2beta.SupportEventSubscription>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSupportEventSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a support event subscription.
     * </pre>
     */
    default void getSupportEventSubscription(
        com.google.cloud.support.v2beta.GetSupportEventSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2beta.SupportEventSubscription>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSupportEventSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists support event subscriptions.
     * </pre>
     */
    default void listSupportEventSubscriptions(
        com.google.cloud.support.v2beta.ListSupportEventSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.support.v2beta.ListSupportEventSubscriptionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSupportEventSubscriptionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a support event subscription.
     * </pre>
     */
    default void updateSupportEventSubscription(
        com.google.cloud.support.v2beta.UpdateSupportEventSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2beta.SupportEventSubscription>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSupportEventSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Soft deletes a support event subscription.
     * </pre>
     */
    default void deleteSupportEventSubscription(
        com.google.cloud.support.v2beta.DeleteSupportEventSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2beta.SupportEventSubscription>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSupportEventSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeletes a support event subscription.
     * </pre>
     */
    default void undeleteSupportEventSubscription(
        com.google.cloud.support.v2beta.UndeleteSupportEventSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2beta.SupportEventSubscription>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeleteSupportEventSubscriptionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SupportEventSubscriptionService.
   *
   * <pre>
   * Service for managing customer support event subscriptions.
   * </pre>
   */
  public abstract static class SupportEventSubscriptionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SupportEventSubscriptionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service
   * SupportEventSubscriptionService.
   *
   * <pre>
   * Service for managing customer support event subscriptions.
   * </pre>
   */
  public static final class SupportEventSubscriptionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SupportEventSubscriptionServiceStub> {
    private SupportEventSubscriptionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SupportEventSubscriptionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SupportEventSubscriptionServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a support event subscription for an organization.
     * </pre>
     */
    public void createSupportEventSubscription(
        com.google.cloud.support.v2beta.CreateSupportEventSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2beta.SupportEventSubscription>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSupportEventSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a support event subscription.
     * </pre>
     */
    public void getSupportEventSubscription(
        com.google.cloud.support.v2beta.GetSupportEventSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2beta.SupportEventSubscription>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSupportEventSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists support event subscriptions.
     * </pre>
     */
    public void listSupportEventSubscriptions(
        com.google.cloud.support.v2beta.ListSupportEventSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.support.v2beta.ListSupportEventSubscriptionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSupportEventSubscriptionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a support event subscription.
     * </pre>
     */
    public void updateSupportEventSubscription(
        com.google.cloud.support.v2beta.UpdateSupportEventSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2beta.SupportEventSubscription>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSupportEventSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Soft deletes a support event subscription.
     * </pre>
     */
    public void deleteSupportEventSubscription(
        com.google.cloud.support.v2beta.DeleteSupportEventSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2beta.SupportEventSubscription>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSupportEventSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeletes a support event subscription.
     * </pre>
     */
    public void undeleteSupportEventSubscription(
        com.google.cloud.support.v2beta.UndeleteSupportEventSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2beta.SupportEventSubscription>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeleteSupportEventSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SupportEventSubscriptionService.
   *
   * <pre>
   * Service for managing customer support event subscriptions.
   * </pre>
   */
  public static final class SupportEventSubscriptionServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SupportEventSubscriptionServiceBlockingV2Stub> {
    private SupportEventSubscriptionServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SupportEventSubscriptionServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SupportEventSubscriptionServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a support event subscription for an organization.
     * </pre>
     */
    public com.google.cloud.support.v2beta.SupportEventSubscription createSupportEventSubscription(
        com.google.cloud.support.v2beta.CreateSupportEventSubscriptionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateSupportEventSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a support event subscription.
     * </pre>
     */
    public com.google.cloud.support.v2beta.SupportEventSubscription getSupportEventSubscription(
        com.google.cloud.support.v2beta.GetSupportEventSubscriptionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSupportEventSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists support event subscriptions.
     * </pre>
     */
    public com.google.cloud.support.v2beta.ListSupportEventSubscriptionsResponse
        listSupportEventSubscriptions(
            com.google.cloud.support.v2beta.ListSupportEventSubscriptionsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSupportEventSubscriptionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a support event subscription.
     * </pre>
     */
    public com.google.cloud.support.v2beta.SupportEventSubscription updateSupportEventSubscription(
        com.google.cloud.support.v2beta.UpdateSupportEventSubscriptionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateSupportEventSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Soft deletes a support event subscription.
     * </pre>
     */
    public com.google.cloud.support.v2beta.SupportEventSubscription deleteSupportEventSubscription(
        com.google.cloud.support.v2beta.DeleteSupportEventSubscriptionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteSupportEventSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Undeletes a support event subscription.
     * </pre>
     */
    public com.google.cloud.support.v2beta.SupportEventSubscription
        undeleteSupportEventSubscription(
            com.google.cloud.support.v2beta.UndeleteSupportEventSubscriptionRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUndeleteSupportEventSubscriptionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * SupportEventSubscriptionService.
   *
   * <pre>
   * Service for managing customer support event subscriptions.
   * </pre>
   */
  public static final class SupportEventSubscriptionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SupportEventSubscriptionServiceBlockingStub> {
    private SupportEventSubscriptionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SupportEventSubscriptionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SupportEventSubscriptionServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a support event subscription for an organization.
     * </pre>
     */
    public com.google.cloud.support.v2beta.SupportEventSubscription createSupportEventSubscription(
        com.google.cloud.support.v2beta.CreateSupportEventSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSupportEventSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a support event subscription.
     * </pre>
     */
    public com.google.cloud.support.v2beta.SupportEventSubscription getSupportEventSubscription(
        com.google.cloud.support.v2beta.GetSupportEventSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSupportEventSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists support event subscriptions.
     * </pre>
     */
    public com.google.cloud.support.v2beta.ListSupportEventSubscriptionsResponse
        listSupportEventSubscriptions(
            com.google.cloud.support.v2beta.ListSupportEventSubscriptionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSupportEventSubscriptionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a support event subscription.
     * </pre>
     */
    public com.google.cloud.support.v2beta.SupportEventSubscription updateSupportEventSubscription(
        com.google.cloud.support.v2beta.UpdateSupportEventSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSupportEventSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Soft deletes a support event subscription.
     * </pre>
     */
    public com.google.cloud.support.v2beta.SupportEventSubscription deleteSupportEventSubscription(
        com.google.cloud.support.v2beta.DeleteSupportEventSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSupportEventSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Undeletes a support event subscription.
     * </pre>
     */
    public com.google.cloud.support.v2beta.SupportEventSubscription
        undeleteSupportEventSubscription(
            com.google.cloud.support.v2beta.UndeleteSupportEventSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeleteSupportEventSubscriptionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * SupportEventSubscriptionService.
   *
   * <pre>
   * Service for managing customer support event subscriptions.
   * </pre>
   */
  public static final class SupportEventSubscriptionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SupportEventSubscriptionServiceFutureStub> {
    private SupportEventSubscriptionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SupportEventSubscriptionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SupportEventSubscriptionServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a support event subscription for an organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.support.v2beta.SupportEventSubscription>
        createSupportEventSubscription(
            com.google.cloud.support.v2beta.CreateSupportEventSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSupportEventSubscriptionMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets a support event subscription.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.support.v2beta.SupportEventSubscription>
        getSupportEventSubscription(
            com.google.cloud.support.v2beta.GetSupportEventSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSupportEventSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists support event subscriptions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.support.v2beta.ListSupportEventSubscriptionsResponse>
        listSupportEventSubscriptions(
            com.google.cloud.support.v2beta.ListSupportEventSubscriptionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSupportEventSubscriptionsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates a support event subscription.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.support.v2beta.SupportEventSubscription>
        updateSupportEventSubscription(
            com.google.cloud.support.v2beta.UpdateSupportEventSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSupportEventSubscriptionMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Soft deletes a support event subscription.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.support.v2beta.SupportEventSubscription>
        deleteSupportEventSubscription(
            com.google.cloud.support.v2beta.DeleteSupportEventSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSupportEventSubscriptionMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Undeletes a support event subscription.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.support.v2beta.SupportEventSubscription>
        undeleteSupportEventSubscription(
            com.google.cloud.support.v2beta.UndeleteSupportEventSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeleteSupportEventSubscriptionMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_CREATE_SUPPORT_EVENT_SUBSCRIPTION = 0;
  private static final int METHODID_GET_SUPPORT_EVENT_SUBSCRIPTION = 1;
  private static final int METHODID_LIST_SUPPORT_EVENT_SUBSCRIPTIONS = 2;
  private static final int METHODID_UPDATE_SUPPORT_EVENT_SUBSCRIPTION = 3;
  private static final int METHODID_DELETE_SUPPORT_EVENT_SUBSCRIPTION = 4;
  private static final int METHODID_UNDELETE_SUPPORT_EVENT_SUBSCRIPTION = 5;

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
        case METHODID_CREATE_SUPPORT_EVENT_SUBSCRIPTION:
          serviceImpl.createSupportEventSubscription(
              (com.google.cloud.support.v2beta.CreateSupportEventSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.support.v2beta.SupportEventSubscription>)
                  responseObserver);
          break;
        case METHODID_GET_SUPPORT_EVENT_SUBSCRIPTION:
          serviceImpl.getSupportEventSubscription(
              (com.google.cloud.support.v2beta.GetSupportEventSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.support.v2beta.SupportEventSubscription>)
                  responseObserver);
          break;
        case METHODID_LIST_SUPPORT_EVENT_SUBSCRIPTIONS:
          serviceImpl.listSupportEventSubscriptions(
              (com.google.cloud.support.v2beta.ListSupportEventSubscriptionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.support.v2beta.ListSupportEventSubscriptionsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SUPPORT_EVENT_SUBSCRIPTION:
          serviceImpl.updateSupportEventSubscription(
              (com.google.cloud.support.v2beta.UpdateSupportEventSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.support.v2beta.SupportEventSubscription>)
                  responseObserver);
          break;
        case METHODID_DELETE_SUPPORT_EVENT_SUBSCRIPTION:
          serviceImpl.deleteSupportEventSubscription(
              (com.google.cloud.support.v2beta.DeleteSupportEventSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.support.v2beta.SupportEventSubscription>)
                  responseObserver);
          break;
        case METHODID_UNDELETE_SUPPORT_EVENT_SUBSCRIPTION:
          serviceImpl.undeleteSupportEventSubscription(
              (com.google.cloud.support.v2beta.UndeleteSupportEventSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.support.v2beta.SupportEventSubscription>)
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
            getCreateSupportEventSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.support.v2beta.CreateSupportEventSubscriptionRequest,
                    com.google.cloud.support.v2beta.SupportEventSubscription>(
                    service, METHODID_CREATE_SUPPORT_EVENT_SUBSCRIPTION)))
        .addMethod(
            getGetSupportEventSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.support.v2beta.GetSupportEventSubscriptionRequest,
                    com.google.cloud.support.v2beta.SupportEventSubscription>(
                    service, METHODID_GET_SUPPORT_EVENT_SUBSCRIPTION)))
        .addMethod(
            getListSupportEventSubscriptionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.support.v2beta.ListSupportEventSubscriptionsRequest,
                    com.google.cloud.support.v2beta.ListSupportEventSubscriptionsResponse>(
                    service, METHODID_LIST_SUPPORT_EVENT_SUBSCRIPTIONS)))
        .addMethod(
            getUpdateSupportEventSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.support.v2beta.UpdateSupportEventSubscriptionRequest,
                    com.google.cloud.support.v2beta.SupportEventSubscription>(
                    service, METHODID_UPDATE_SUPPORT_EVENT_SUBSCRIPTION)))
        .addMethod(
            getDeleteSupportEventSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.support.v2beta.DeleteSupportEventSubscriptionRequest,
                    com.google.cloud.support.v2beta.SupportEventSubscription>(
                    service, METHODID_DELETE_SUPPORT_EVENT_SUBSCRIPTION)))
        .addMethod(
            getUndeleteSupportEventSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.support.v2beta.UndeleteSupportEventSubscriptionRequest,
                    com.google.cloud.support.v2beta.SupportEventSubscription>(
                    service, METHODID_UNDELETE_SUPPORT_EVENT_SUBSCRIPTION)))
        .build();
  }

  private abstract static class SupportEventSubscriptionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SupportEventSubscriptionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.support.v2beta.SupportEventSubscriptionServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SupportEventSubscriptionService");
    }
  }

  private static final class SupportEventSubscriptionServiceFileDescriptorSupplier
      extends SupportEventSubscriptionServiceBaseDescriptorSupplier {
    SupportEventSubscriptionServiceFileDescriptorSupplier() {}
  }

  private static final class SupportEventSubscriptionServiceMethodDescriptorSupplier
      extends SupportEventSubscriptionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SupportEventSubscriptionServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SupportEventSubscriptionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new SupportEventSubscriptionServiceFileDescriptorSupplier())
                      .addMethod(getCreateSupportEventSubscriptionMethod())
                      .addMethod(getGetSupportEventSubscriptionMethod())
                      .addMethod(getListSupportEventSubscriptionsMethod())
                      .addMethod(getUpdateSupportEventSubscriptionMethod())
                      .addMethod(getDeleteSupportEventSubscriptionMethod())
                      .addMethod(getUndeleteSupportEventSubscriptionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
