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
package com.google.shopping.merchant.notifications.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to manage notification subscriptions for merchants
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/notifications/v1beta/notificationsapi.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class NotificationsApiServiceGrpc {

  private NotificationsApiServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.notifications.v1beta.NotificationsApiService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.notifications.v1beta.GetNotificationSubscriptionRequest,
          com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>
      getGetNotificationSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNotificationSubscription",
      requestType =
          com.google.shopping.merchant.notifications.v1beta.GetNotificationSubscriptionRequest
              .class,
      responseType =
          com.google.shopping.merchant.notifications.v1beta.NotificationSubscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.notifications.v1beta.GetNotificationSubscriptionRequest,
          com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>
      getGetNotificationSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.notifications.v1beta.GetNotificationSubscriptionRequest,
            com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>
        getGetNotificationSubscriptionMethod;
    if ((getGetNotificationSubscriptionMethod =
            NotificationsApiServiceGrpc.getGetNotificationSubscriptionMethod)
        == null) {
      synchronized (NotificationsApiServiceGrpc.class) {
        if ((getGetNotificationSubscriptionMethod =
                NotificationsApiServiceGrpc.getGetNotificationSubscriptionMethod)
            == null) {
          NotificationsApiServiceGrpc.getGetNotificationSubscriptionMethod =
              getGetNotificationSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.notifications.v1beta
                              .GetNotificationSubscriptionRequest,
                          com.google.shopping.merchant.notifications.v1beta
                              .NotificationSubscription>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetNotificationSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.notifications.v1beta
                                  .GetNotificationSubscriptionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.notifications.v1beta
                                  .NotificationSubscription.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotificationsApiServiceMethodDescriptorSupplier(
                              "GetNotificationSubscription"))
                      .build();
        }
      }
    }
    return getGetNotificationSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.notifications.v1beta.CreateNotificationSubscriptionRequest,
          com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>
      getCreateNotificationSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNotificationSubscription",
      requestType =
          com.google.shopping.merchant.notifications.v1beta.CreateNotificationSubscriptionRequest
              .class,
      responseType =
          com.google.shopping.merchant.notifications.v1beta.NotificationSubscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.notifications.v1beta.CreateNotificationSubscriptionRequest,
          com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>
      getCreateNotificationSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.notifications.v1beta.CreateNotificationSubscriptionRequest,
            com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>
        getCreateNotificationSubscriptionMethod;
    if ((getCreateNotificationSubscriptionMethod =
            NotificationsApiServiceGrpc.getCreateNotificationSubscriptionMethod)
        == null) {
      synchronized (NotificationsApiServiceGrpc.class) {
        if ((getCreateNotificationSubscriptionMethod =
                NotificationsApiServiceGrpc.getCreateNotificationSubscriptionMethod)
            == null) {
          NotificationsApiServiceGrpc.getCreateNotificationSubscriptionMethod =
              getCreateNotificationSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.notifications.v1beta
                              .CreateNotificationSubscriptionRequest,
                          com.google.shopping.merchant.notifications.v1beta
                              .NotificationSubscription>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateNotificationSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.notifications.v1beta
                                  .CreateNotificationSubscriptionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.notifications.v1beta
                                  .NotificationSubscription.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotificationsApiServiceMethodDescriptorSupplier(
                              "CreateNotificationSubscription"))
                      .build();
        }
      }
    }
    return getCreateNotificationSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.notifications.v1beta.UpdateNotificationSubscriptionRequest,
          com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>
      getUpdateNotificationSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateNotificationSubscription",
      requestType =
          com.google.shopping.merchant.notifications.v1beta.UpdateNotificationSubscriptionRequest
              .class,
      responseType =
          com.google.shopping.merchant.notifications.v1beta.NotificationSubscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.notifications.v1beta.UpdateNotificationSubscriptionRequest,
          com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>
      getUpdateNotificationSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.notifications.v1beta.UpdateNotificationSubscriptionRequest,
            com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>
        getUpdateNotificationSubscriptionMethod;
    if ((getUpdateNotificationSubscriptionMethod =
            NotificationsApiServiceGrpc.getUpdateNotificationSubscriptionMethod)
        == null) {
      synchronized (NotificationsApiServiceGrpc.class) {
        if ((getUpdateNotificationSubscriptionMethod =
                NotificationsApiServiceGrpc.getUpdateNotificationSubscriptionMethod)
            == null) {
          NotificationsApiServiceGrpc.getUpdateNotificationSubscriptionMethod =
              getUpdateNotificationSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.notifications.v1beta
                              .UpdateNotificationSubscriptionRequest,
                          com.google.shopping.merchant.notifications.v1beta
                              .NotificationSubscription>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateNotificationSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.notifications.v1beta
                                  .UpdateNotificationSubscriptionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.notifications.v1beta
                                  .NotificationSubscription.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotificationsApiServiceMethodDescriptorSupplier(
                              "UpdateNotificationSubscription"))
                      .build();
        }
      }
    }
    return getUpdateNotificationSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.notifications.v1beta.DeleteNotificationSubscriptionRequest,
          com.google.protobuf.Empty>
      getDeleteNotificationSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNotificationSubscription",
      requestType =
          com.google.shopping.merchant.notifications.v1beta.DeleteNotificationSubscriptionRequest
              .class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.notifications.v1beta.DeleteNotificationSubscriptionRequest,
          com.google.protobuf.Empty>
      getDeleteNotificationSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.notifications.v1beta.DeleteNotificationSubscriptionRequest,
            com.google.protobuf.Empty>
        getDeleteNotificationSubscriptionMethod;
    if ((getDeleteNotificationSubscriptionMethod =
            NotificationsApiServiceGrpc.getDeleteNotificationSubscriptionMethod)
        == null) {
      synchronized (NotificationsApiServiceGrpc.class) {
        if ((getDeleteNotificationSubscriptionMethod =
                NotificationsApiServiceGrpc.getDeleteNotificationSubscriptionMethod)
            == null) {
          NotificationsApiServiceGrpc.getDeleteNotificationSubscriptionMethod =
              getDeleteNotificationSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.notifications.v1beta
                              .DeleteNotificationSubscriptionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteNotificationSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.notifications.v1beta
                                  .DeleteNotificationSubscriptionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotificationsApiServiceMethodDescriptorSupplier(
                              "DeleteNotificationSubscription"))
                      .build();
        }
      }
    }
    return getDeleteNotificationSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.notifications.v1beta.ListNotificationSubscriptionsRequest,
          com.google.shopping.merchant.notifications.v1beta.ListNotificationSubscriptionsResponse>
      getListNotificationSubscriptionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNotificationSubscriptions",
      requestType =
          com.google.shopping.merchant.notifications.v1beta.ListNotificationSubscriptionsRequest
              .class,
      responseType =
          com.google.shopping.merchant.notifications.v1beta.ListNotificationSubscriptionsResponse
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.notifications.v1beta.ListNotificationSubscriptionsRequest,
          com.google.shopping.merchant.notifications.v1beta.ListNotificationSubscriptionsResponse>
      getListNotificationSubscriptionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.notifications.v1beta.ListNotificationSubscriptionsRequest,
            com.google.shopping.merchant.notifications.v1beta.ListNotificationSubscriptionsResponse>
        getListNotificationSubscriptionsMethod;
    if ((getListNotificationSubscriptionsMethod =
            NotificationsApiServiceGrpc.getListNotificationSubscriptionsMethod)
        == null) {
      synchronized (NotificationsApiServiceGrpc.class) {
        if ((getListNotificationSubscriptionsMethod =
                NotificationsApiServiceGrpc.getListNotificationSubscriptionsMethod)
            == null) {
          NotificationsApiServiceGrpc.getListNotificationSubscriptionsMethod =
              getListNotificationSubscriptionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.notifications.v1beta
                              .ListNotificationSubscriptionsRequest,
                          com.google.shopping.merchant.notifications.v1beta
                              .ListNotificationSubscriptionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListNotificationSubscriptions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.notifications.v1beta
                                  .ListNotificationSubscriptionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.notifications.v1beta
                                  .ListNotificationSubscriptionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotificationsApiServiceMethodDescriptorSupplier(
                              "ListNotificationSubscriptions"))
                      .build();
        }
      }
    }
    return getListNotificationSubscriptionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static NotificationsApiServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotificationsApiServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NotificationsApiServiceStub>() {
          @java.lang.Override
          public NotificationsApiServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NotificationsApiServiceStub(channel, callOptions);
          }
        };
    return NotificationsApiServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NotificationsApiServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotificationsApiServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NotificationsApiServiceBlockingStub>() {
          @java.lang.Override
          public NotificationsApiServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NotificationsApiServiceBlockingStub(channel, callOptions);
          }
        };
    return NotificationsApiServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static NotificationsApiServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotificationsApiServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NotificationsApiServiceFutureStub>() {
          @java.lang.Override
          public NotificationsApiServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NotificationsApiServiceFutureStub(channel, callOptions);
          }
        };
    return NotificationsApiServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to manage notification subscriptions for merchants
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets notification subscriptions for an account.
     * </pre>
     */
    default void getNotificationSubscription(
        com.google.shopping.merchant.notifications.v1beta.GetNotificationSubscriptionRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetNotificationSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a notification subscription for a merchant. We will allow the
     * following types of notification subscriptions to exist together (per
     * merchant as a subscriber per event type):
     * 1. Subscription for all managed accounts + subscription for self
     * 2. Multiple "partial" subscriptions for managed accounts + subscription
     * for self
     * we will not allow (per merchant as a subscriber per event type):
     * 1. multiple self subscriptions.
     * 2. multiple "all managed accounts" subscriptions.
     * 3. all and partial subscriptions at the same time.
     * 4. multiple partial subscriptions for the same target account
     * </pre>
     */
    default void createNotificationSubscription(
        com.google.shopping.merchant.notifications.v1beta.CreateNotificationSubscriptionRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateNotificationSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing notification subscription for a merchant.
     * </pre>
     */
    default void updateNotificationSubscription(
        com.google.shopping.merchant.notifications.v1beta.UpdateNotificationSubscriptionRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateNotificationSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a notification subscription for a merchant.
     * </pre>
     */
    default void deleteNotificationSubscription(
        com.google.shopping.merchant.notifications.v1beta.DeleteNotificationSubscriptionRequest
            request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteNotificationSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets all the notification subscriptions for a merchant.
     * </pre>
     */
    default void listNotificationSubscriptions(
        com.google.shopping.merchant.notifications.v1beta.ListNotificationSubscriptionsRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.notifications.v1beta
                    .ListNotificationSubscriptionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListNotificationSubscriptionsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service NotificationsApiService.
   *
   * <pre>
   * Service to manage notification subscriptions for merchants
   * </pre>
   */
  public abstract static class NotificationsApiServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return NotificationsApiServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service NotificationsApiService.
   *
   * <pre>
   * Service to manage notification subscriptions for merchants
   * </pre>
   */
  public static final class NotificationsApiServiceStub
      extends io.grpc.stub.AbstractAsyncStub<NotificationsApiServiceStub> {
    private NotificationsApiServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotificationsApiServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotificationsApiServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets notification subscriptions for an account.
     * </pre>
     */
    public void getNotificationSubscription(
        com.google.shopping.merchant.notifications.v1beta.GetNotificationSubscriptionRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNotificationSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a notification subscription for a merchant. We will allow the
     * following types of notification subscriptions to exist together (per
     * merchant as a subscriber per event type):
     * 1. Subscription for all managed accounts + subscription for self
     * 2. Multiple "partial" subscriptions for managed accounts + subscription
     * for self
     * we will not allow (per merchant as a subscriber per event type):
     * 1. multiple self subscriptions.
     * 2. multiple "all managed accounts" subscriptions.
     * 3. all and partial subscriptions at the same time.
     * 4. multiple partial subscriptions for the same target account
     * </pre>
     */
    public void createNotificationSubscription(
        com.google.shopping.merchant.notifications.v1beta.CreateNotificationSubscriptionRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNotificationSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing notification subscription for a merchant.
     * </pre>
     */
    public void updateNotificationSubscription(
        com.google.shopping.merchant.notifications.v1beta.UpdateNotificationSubscriptionRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateNotificationSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a notification subscription for a merchant.
     * </pre>
     */
    public void deleteNotificationSubscription(
        com.google.shopping.merchant.notifications.v1beta.DeleteNotificationSubscriptionRequest
            request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteNotificationSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets all the notification subscriptions for a merchant.
     * </pre>
     */
    public void listNotificationSubscriptions(
        com.google.shopping.merchant.notifications.v1beta.ListNotificationSubscriptionsRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.notifications.v1beta
                    .ListNotificationSubscriptionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNotificationSubscriptionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service NotificationsApiService.
   *
   * <pre>
   * Service to manage notification subscriptions for merchants
   * </pre>
   */
  public static final class NotificationsApiServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<NotificationsApiServiceBlockingStub> {
    private NotificationsApiServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotificationsApiServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotificationsApiServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets notification subscriptions for an account.
     * </pre>
     */
    public com.google.shopping.merchant.notifications.v1beta.NotificationSubscription
        getNotificationSubscription(
            com.google.shopping.merchant.notifications.v1beta.GetNotificationSubscriptionRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNotificationSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a notification subscription for a merchant. We will allow the
     * following types of notification subscriptions to exist together (per
     * merchant as a subscriber per event type):
     * 1. Subscription for all managed accounts + subscription for self
     * 2. Multiple "partial" subscriptions for managed accounts + subscription
     * for self
     * we will not allow (per merchant as a subscriber per event type):
     * 1. multiple self subscriptions.
     * 2. multiple "all managed accounts" subscriptions.
     * 3. all and partial subscriptions at the same time.
     * 4. multiple partial subscriptions for the same target account
     * </pre>
     */
    public com.google.shopping.merchant.notifications.v1beta.NotificationSubscription
        createNotificationSubscription(
            com.google.shopping.merchant.notifications.v1beta.CreateNotificationSubscriptionRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNotificationSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing notification subscription for a merchant.
     * </pre>
     */
    public com.google.shopping.merchant.notifications.v1beta.NotificationSubscription
        updateNotificationSubscription(
            com.google.shopping.merchant.notifications.v1beta.UpdateNotificationSubscriptionRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateNotificationSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a notification subscription for a merchant.
     * </pre>
     */
    public com.google.protobuf.Empty deleteNotificationSubscription(
        com.google.shopping.merchant.notifications.v1beta.DeleteNotificationSubscriptionRequest
            request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteNotificationSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets all the notification subscriptions for a merchant.
     * </pre>
     */
    public com.google.shopping.merchant.notifications.v1beta.ListNotificationSubscriptionsResponse
        listNotificationSubscriptions(
            com.google.shopping.merchant.notifications.v1beta.ListNotificationSubscriptionsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNotificationSubscriptionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * NotificationsApiService.
   *
   * <pre>
   * Service to manage notification subscriptions for merchants
   * </pre>
   */
  public static final class NotificationsApiServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<NotificationsApiServiceFutureStub> {
    private NotificationsApiServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotificationsApiServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotificationsApiServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets notification subscriptions for an account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>
        getNotificationSubscription(
            com.google.shopping.merchant.notifications.v1beta.GetNotificationSubscriptionRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNotificationSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a notification subscription for a merchant. We will allow the
     * following types of notification subscriptions to exist together (per
     * merchant as a subscriber per event type):
     * 1. Subscription for all managed accounts + subscription for self
     * 2. Multiple "partial" subscriptions for managed accounts + subscription
     * for self
     * we will not allow (per merchant as a subscriber per event type):
     * 1. multiple self subscriptions.
     * 2. multiple "all managed accounts" subscriptions.
     * 3. all and partial subscriptions at the same time.
     * 4. multiple partial subscriptions for the same target account
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>
        createNotificationSubscription(
            com.google.shopping.merchant.notifications.v1beta.CreateNotificationSubscriptionRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNotificationSubscriptionMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing notification subscription for a merchant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>
        updateNotificationSubscription(
            com.google.shopping.merchant.notifications.v1beta.UpdateNotificationSubscriptionRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateNotificationSubscriptionMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a notification subscription for a merchant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteNotificationSubscription(
            com.google.shopping.merchant.notifications.v1beta.DeleteNotificationSubscriptionRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteNotificationSubscriptionMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets all the notification subscriptions for a merchant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.notifications.v1beta.ListNotificationSubscriptionsResponse>
        listNotificationSubscriptions(
            com.google.shopping.merchant.notifications.v1beta.ListNotificationSubscriptionsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNotificationSubscriptionsMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_GET_NOTIFICATION_SUBSCRIPTION = 0;
  private static final int METHODID_CREATE_NOTIFICATION_SUBSCRIPTION = 1;
  private static final int METHODID_UPDATE_NOTIFICATION_SUBSCRIPTION = 2;
  private static final int METHODID_DELETE_NOTIFICATION_SUBSCRIPTION = 3;
  private static final int METHODID_LIST_NOTIFICATION_SUBSCRIPTIONS = 4;

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
        case METHODID_GET_NOTIFICATION_SUBSCRIPTION:
          serviceImpl.getNotificationSubscription(
              (com.google.shopping.merchant.notifications.v1beta.GetNotificationSubscriptionRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>)
                  responseObserver);
          break;
        case METHODID_CREATE_NOTIFICATION_SUBSCRIPTION:
          serviceImpl.createNotificationSubscription(
              (com.google.shopping.merchant.notifications.v1beta
                      .CreateNotificationSubscriptionRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>)
                  responseObserver);
          break;
        case METHODID_UPDATE_NOTIFICATION_SUBSCRIPTION:
          serviceImpl.updateNotificationSubscription(
              (com.google.shopping.merchant.notifications.v1beta
                      .UpdateNotificationSubscriptionRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>)
                  responseObserver);
          break;
        case METHODID_DELETE_NOTIFICATION_SUBSCRIPTION:
          serviceImpl.deleteNotificationSubscription(
              (com.google.shopping.merchant.notifications.v1beta
                      .DeleteNotificationSubscriptionRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_NOTIFICATION_SUBSCRIPTIONS:
          serviceImpl.listNotificationSubscriptions(
              (com.google.shopping.merchant.notifications.v1beta
                      .ListNotificationSubscriptionsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.notifications.v1beta
                          .ListNotificationSubscriptionsResponse>)
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
            getGetNotificationSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.notifications.v1beta
                        .GetNotificationSubscriptionRequest,
                    com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>(
                    service, METHODID_GET_NOTIFICATION_SUBSCRIPTION)))
        .addMethod(
            getCreateNotificationSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.notifications.v1beta
                        .CreateNotificationSubscriptionRequest,
                    com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>(
                    service, METHODID_CREATE_NOTIFICATION_SUBSCRIPTION)))
        .addMethod(
            getUpdateNotificationSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.notifications.v1beta
                        .UpdateNotificationSubscriptionRequest,
                    com.google.shopping.merchant.notifications.v1beta.NotificationSubscription>(
                    service, METHODID_UPDATE_NOTIFICATION_SUBSCRIPTION)))
        .addMethod(
            getDeleteNotificationSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.notifications.v1beta
                        .DeleteNotificationSubscriptionRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_NOTIFICATION_SUBSCRIPTION)))
        .addMethod(
            getListNotificationSubscriptionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.notifications.v1beta
                        .ListNotificationSubscriptionsRequest,
                    com.google.shopping.merchant.notifications.v1beta
                        .ListNotificationSubscriptionsResponse>(
                    service, METHODID_LIST_NOTIFICATION_SUBSCRIPTIONS)))
        .build();
  }

  private abstract static class NotificationsApiServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NotificationsApiServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.notifications.v1beta.NotificationsApiProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NotificationsApiService");
    }
  }

  private static final class NotificationsApiServiceFileDescriptorSupplier
      extends NotificationsApiServiceBaseDescriptorSupplier {
    NotificationsApiServiceFileDescriptorSupplier() {}
  }

  private static final class NotificationsApiServiceMethodDescriptorSupplier
      extends NotificationsApiServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    NotificationsApiServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (NotificationsApiServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new NotificationsApiServiceFileDescriptorSupplier())
                      .addMethod(getGetNotificationSubscriptionMethod())
                      .addMethod(getCreateNotificationSubscriptionMethod())
                      .addMethod(getUpdateNotificationSubscriptionMethod())
                      .addMethod(getDeleteNotificationSubscriptionMethod())
                      .addMethod(getListNotificationSubscriptionsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
