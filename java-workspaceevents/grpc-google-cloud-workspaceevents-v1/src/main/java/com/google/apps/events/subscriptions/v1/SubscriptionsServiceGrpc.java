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
package com.google.apps.events.subscriptions.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service that manages subscriptions to Google Workspace events.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/apps/events/subscriptions/v1/subscriptions_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SubscriptionsServiceGrpc {

  private SubscriptionsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.apps.events.subscriptions.v1.SubscriptionsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.events.subscriptions.v1.CreateSubscriptionRequest,
          com.google.longrunning.Operation>
      getCreateSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSubscription",
      requestType = com.google.apps.events.subscriptions.v1.CreateSubscriptionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.events.subscriptions.v1.CreateSubscriptionRequest,
          com.google.longrunning.Operation>
      getCreateSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.events.subscriptions.v1.CreateSubscriptionRequest,
            com.google.longrunning.Operation>
        getCreateSubscriptionMethod;
    if ((getCreateSubscriptionMethod = SubscriptionsServiceGrpc.getCreateSubscriptionMethod)
        == null) {
      synchronized (SubscriptionsServiceGrpc.class) {
        if ((getCreateSubscriptionMethod = SubscriptionsServiceGrpc.getCreateSubscriptionMethod)
            == null) {
          SubscriptionsServiceGrpc.getCreateSubscriptionMethod =
              getCreateSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.events.subscriptions.v1.CreateSubscriptionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.events.subscriptions.v1.CreateSubscriptionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SubscriptionsServiceMethodDescriptorSupplier("CreateSubscription"))
                      .build();
        }
      }
    }
    return getCreateSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.events.subscriptions.v1.DeleteSubscriptionRequest,
          com.google.longrunning.Operation>
      getDeleteSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSubscription",
      requestType = com.google.apps.events.subscriptions.v1.DeleteSubscriptionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.events.subscriptions.v1.DeleteSubscriptionRequest,
          com.google.longrunning.Operation>
      getDeleteSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.events.subscriptions.v1.DeleteSubscriptionRequest,
            com.google.longrunning.Operation>
        getDeleteSubscriptionMethod;
    if ((getDeleteSubscriptionMethod = SubscriptionsServiceGrpc.getDeleteSubscriptionMethod)
        == null) {
      synchronized (SubscriptionsServiceGrpc.class) {
        if ((getDeleteSubscriptionMethod = SubscriptionsServiceGrpc.getDeleteSubscriptionMethod)
            == null) {
          SubscriptionsServiceGrpc.getDeleteSubscriptionMethod =
              getDeleteSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.events.subscriptions.v1.DeleteSubscriptionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.events.subscriptions.v1.DeleteSubscriptionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SubscriptionsServiceMethodDescriptorSupplier("DeleteSubscription"))
                      .build();
        }
      }
    }
    return getDeleteSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.events.subscriptions.v1.GetSubscriptionRequest,
          com.google.apps.events.subscriptions.v1.Subscription>
      getGetSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubscription",
      requestType = com.google.apps.events.subscriptions.v1.GetSubscriptionRequest.class,
      responseType = com.google.apps.events.subscriptions.v1.Subscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.events.subscriptions.v1.GetSubscriptionRequest,
          com.google.apps.events.subscriptions.v1.Subscription>
      getGetSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.events.subscriptions.v1.GetSubscriptionRequest,
            com.google.apps.events.subscriptions.v1.Subscription>
        getGetSubscriptionMethod;
    if ((getGetSubscriptionMethod = SubscriptionsServiceGrpc.getGetSubscriptionMethod) == null) {
      synchronized (SubscriptionsServiceGrpc.class) {
        if ((getGetSubscriptionMethod = SubscriptionsServiceGrpc.getGetSubscriptionMethod)
            == null) {
          SubscriptionsServiceGrpc.getGetSubscriptionMethod =
              getGetSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.events.subscriptions.v1.GetSubscriptionRequest,
                          com.google.apps.events.subscriptions.v1.Subscription>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.events.subscriptions.v1.GetSubscriptionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.events.subscriptions.v1.Subscription
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SubscriptionsServiceMethodDescriptorSupplier("GetSubscription"))
                      .build();
        }
      }
    }
    return getGetSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.events.subscriptions.v1.ListSubscriptionsRequest,
          com.google.apps.events.subscriptions.v1.ListSubscriptionsResponse>
      getListSubscriptionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSubscriptions",
      requestType = com.google.apps.events.subscriptions.v1.ListSubscriptionsRequest.class,
      responseType = com.google.apps.events.subscriptions.v1.ListSubscriptionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.events.subscriptions.v1.ListSubscriptionsRequest,
          com.google.apps.events.subscriptions.v1.ListSubscriptionsResponse>
      getListSubscriptionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.events.subscriptions.v1.ListSubscriptionsRequest,
            com.google.apps.events.subscriptions.v1.ListSubscriptionsResponse>
        getListSubscriptionsMethod;
    if ((getListSubscriptionsMethod = SubscriptionsServiceGrpc.getListSubscriptionsMethod)
        == null) {
      synchronized (SubscriptionsServiceGrpc.class) {
        if ((getListSubscriptionsMethod = SubscriptionsServiceGrpc.getListSubscriptionsMethod)
            == null) {
          SubscriptionsServiceGrpc.getListSubscriptionsMethod =
              getListSubscriptionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.events.subscriptions.v1.ListSubscriptionsRequest,
                          com.google.apps.events.subscriptions.v1.ListSubscriptionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSubscriptions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.events.subscriptions.v1.ListSubscriptionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.events.subscriptions.v1.ListSubscriptionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SubscriptionsServiceMethodDescriptorSupplier("ListSubscriptions"))
                      .build();
        }
      }
    }
    return getListSubscriptionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.events.subscriptions.v1.UpdateSubscriptionRequest,
          com.google.longrunning.Operation>
      getUpdateSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSubscription",
      requestType = com.google.apps.events.subscriptions.v1.UpdateSubscriptionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.events.subscriptions.v1.UpdateSubscriptionRequest,
          com.google.longrunning.Operation>
      getUpdateSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.events.subscriptions.v1.UpdateSubscriptionRequest,
            com.google.longrunning.Operation>
        getUpdateSubscriptionMethod;
    if ((getUpdateSubscriptionMethod = SubscriptionsServiceGrpc.getUpdateSubscriptionMethod)
        == null) {
      synchronized (SubscriptionsServiceGrpc.class) {
        if ((getUpdateSubscriptionMethod = SubscriptionsServiceGrpc.getUpdateSubscriptionMethod)
            == null) {
          SubscriptionsServiceGrpc.getUpdateSubscriptionMethod =
              getUpdateSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.events.subscriptions.v1.UpdateSubscriptionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.events.subscriptions.v1.UpdateSubscriptionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SubscriptionsServiceMethodDescriptorSupplier("UpdateSubscription"))
                      .build();
        }
      }
    }
    return getUpdateSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.events.subscriptions.v1.ReactivateSubscriptionRequest,
          com.google.longrunning.Operation>
      getReactivateSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReactivateSubscription",
      requestType = com.google.apps.events.subscriptions.v1.ReactivateSubscriptionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.events.subscriptions.v1.ReactivateSubscriptionRequest,
          com.google.longrunning.Operation>
      getReactivateSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.events.subscriptions.v1.ReactivateSubscriptionRequest,
            com.google.longrunning.Operation>
        getReactivateSubscriptionMethod;
    if ((getReactivateSubscriptionMethod = SubscriptionsServiceGrpc.getReactivateSubscriptionMethod)
        == null) {
      synchronized (SubscriptionsServiceGrpc.class) {
        if ((getReactivateSubscriptionMethod =
                SubscriptionsServiceGrpc.getReactivateSubscriptionMethod)
            == null) {
          SubscriptionsServiceGrpc.getReactivateSubscriptionMethod =
              getReactivateSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.events.subscriptions.v1.ReactivateSubscriptionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ReactivateSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.events.subscriptions.v1.ReactivateSubscriptionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SubscriptionsServiceMethodDescriptorSupplier(
                              "ReactivateSubscription"))
                      .build();
        }
      }
    }
    return getReactivateSubscriptionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SubscriptionsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscriptionsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SubscriptionsServiceStub>() {
          @java.lang.Override
          public SubscriptionsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SubscriptionsServiceStub(channel, callOptions);
          }
        };
    return SubscriptionsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SubscriptionsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscriptionsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SubscriptionsServiceBlockingStub>() {
          @java.lang.Override
          public SubscriptionsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SubscriptionsServiceBlockingStub(channel, callOptions);
          }
        };
    return SubscriptionsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SubscriptionsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscriptionsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SubscriptionsServiceFutureStub>() {
          @java.lang.Override
          public SubscriptionsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SubscriptionsServiceFutureStub(channel, callOptions);
          }
        };
    return SubscriptionsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service that manages subscriptions to Google Workspace events.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a Google Workspace subscription. To learn how to use this
     * method, see [Create a Google Workspace
     * subscription](https://developers.google.com/workspace/events/guides/create-subscription).
     * </pre>
     */
    default void createSubscription(
        com.google.apps.events.subscriptions.v1.CreateSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Google Workspace subscription.
     * To learn how to use this method, see [Delete a Google Workspace
     * subscription](https://developers.google.com/workspace/events/guides/delete-subscription).
     * </pre>
     */
    default void deleteSubscription(
        com.google.apps.events.subscriptions.v1.DeleteSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Google Workspace subscription. To learn how to use
     * this method, see [Get details about a Google Workspace
     * subscription](https://developers.google.com/workspace/events/guides/get-subscription).
     * </pre>
     */
    default void getSubscription(
        com.google.apps.events.subscriptions.v1.GetSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.events.subscriptions.v1.Subscription>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Google Workspace subscriptions. To learn how to use this method, see
     * [List Google Workspace
     * subscriptions](https://developers.google.com/workspace/events/guides/list-subscriptions).
     * </pre>
     */
    default void listSubscriptions(
        com.google.apps.events.subscriptions.v1.ListSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.apps.events.subscriptions.v1.ListSubscriptionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSubscriptionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates or renews a Google Workspace subscription. To learn how to use this
     * method, see [Update or renew a Google Workspace
     * subscription](https://developers.google.com/workspace/events/guides/update-subscription).
     * </pre>
     */
    default void updateSubscription(
        com.google.apps.events.subscriptions.v1.UpdateSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reactivates a suspended Google Workspace subscription.
     * This method resets your subscription's `State` field to `ACTIVE`. Before
     * you use this method, you must fix the error that suspended the
     * subscription. To learn how to use this method, see [Reactivate a Google
     * Workspace
     * subscription](https://developers.google.com/workspace/events/guides/reactivate-subscription).
     * </pre>
     */
    default void reactivateSubscription(
        com.google.apps.events.subscriptions.v1.ReactivateSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReactivateSubscriptionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SubscriptionsService.
   *
   * <pre>
   * A service that manages subscriptions to Google Workspace events.
   * </pre>
   */
  public abstract static class SubscriptionsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SubscriptionsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SubscriptionsService.
   *
   * <pre>
   * A service that manages subscriptions to Google Workspace events.
   * </pre>
   */
  public static final class SubscriptionsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SubscriptionsServiceStub> {
    private SubscriptionsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscriptionsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscriptionsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a Google Workspace subscription. To learn how to use this
     * method, see [Create a Google Workspace
     * subscription](https://developers.google.com/workspace/events/guides/create-subscription).
     * </pre>
     */
    public void createSubscription(
        com.google.apps.events.subscriptions.v1.CreateSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Google Workspace subscription.
     * To learn how to use this method, see [Delete a Google Workspace
     * subscription](https://developers.google.com/workspace/events/guides/delete-subscription).
     * </pre>
     */
    public void deleteSubscription(
        com.google.apps.events.subscriptions.v1.DeleteSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Google Workspace subscription. To learn how to use
     * this method, see [Get details about a Google Workspace
     * subscription](https://developers.google.com/workspace/events/guides/get-subscription).
     * </pre>
     */
    public void getSubscription(
        com.google.apps.events.subscriptions.v1.GetSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.events.subscriptions.v1.Subscription>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Google Workspace subscriptions. To learn how to use this method, see
     * [List Google Workspace
     * subscriptions](https://developers.google.com/workspace/events/guides/list-subscriptions).
     * </pre>
     */
    public void listSubscriptions(
        com.google.apps.events.subscriptions.v1.ListSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.apps.events.subscriptions.v1.ListSubscriptionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSubscriptionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates or renews a Google Workspace subscription. To learn how to use this
     * method, see [Update or renew a Google Workspace
     * subscription](https://developers.google.com/workspace/events/guides/update-subscription).
     * </pre>
     */
    public void updateSubscription(
        com.google.apps.events.subscriptions.v1.UpdateSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reactivates a suspended Google Workspace subscription.
     * This method resets your subscription's `State` field to `ACTIVE`. Before
     * you use this method, you must fix the error that suspended the
     * subscription. To learn how to use this method, see [Reactivate a Google
     * Workspace
     * subscription](https://developers.google.com/workspace/events/guides/reactivate-subscription).
     * </pre>
     */
    public void reactivateSubscription(
        com.google.apps.events.subscriptions.v1.ReactivateSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReactivateSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SubscriptionsService.
   *
   * <pre>
   * A service that manages subscriptions to Google Workspace events.
   * </pre>
   */
  public static final class SubscriptionsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SubscriptionsServiceBlockingStub> {
    private SubscriptionsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscriptionsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscriptionsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a Google Workspace subscription. To learn how to use this
     * method, see [Create a Google Workspace
     * subscription](https://developers.google.com/workspace/events/guides/create-subscription).
     * </pre>
     */
    public com.google.longrunning.Operation createSubscription(
        com.google.apps.events.subscriptions.v1.CreateSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Google Workspace subscription.
     * To learn how to use this method, see [Delete a Google Workspace
     * subscription](https://developers.google.com/workspace/events/guides/delete-subscription).
     * </pre>
     */
    public com.google.longrunning.Operation deleteSubscription(
        com.google.apps.events.subscriptions.v1.DeleteSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Google Workspace subscription. To learn how to use
     * this method, see [Get details about a Google Workspace
     * subscription](https://developers.google.com/workspace/events/guides/get-subscription).
     * </pre>
     */
    public com.google.apps.events.subscriptions.v1.Subscription getSubscription(
        com.google.apps.events.subscriptions.v1.GetSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Google Workspace subscriptions. To learn how to use this method, see
     * [List Google Workspace
     * subscriptions](https://developers.google.com/workspace/events/guides/list-subscriptions).
     * </pre>
     */
    public com.google.apps.events.subscriptions.v1.ListSubscriptionsResponse listSubscriptions(
        com.google.apps.events.subscriptions.v1.ListSubscriptionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSubscriptionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates or renews a Google Workspace subscription. To learn how to use this
     * method, see [Update or renew a Google Workspace
     * subscription](https://developers.google.com/workspace/events/guides/update-subscription).
     * </pre>
     */
    public com.google.longrunning.Operation updateSubscription(
        com.google.apps.events.subscriptions.v1.UpdateSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reactivates a suspended Google Workspace subscription.
     * This method resets your subscription's `State` field to `ACTIVE`. Before
     * you use this method, you must fix the error that suspended the
     * subscription. To learn how to use this method, see [Reactivate a Google
     * Workspace
     * subscription](https://developers.google.com/workspace/events/guides/reactivate-subscription).
     * </pre>
     */
    public com.google.longrunning.Operation reactivateSubscription(
        com.google.apps.events.subscriptions.v1.ReactivateSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReactivateSubscriptionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SubscriptionsService.
   *
   * <pre>
   * A service that manages subscriptions to Google Workspace events.
   * </pre>
   */
  public static final class SubscriptionsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SubscriptionsServiceFutureStub> {
    private SubscriptionsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscriptionsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscriptionsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a Google Workspace subscription. To learn how to use this
     * method, see [Create a Google Workspace
     * subscription](https://developers.google.com/workspace/events/guides/create-subscription).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSubscription(
            com.google.apps.events.subscriptions.v1.CreateSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Google Workspace subscription.
     * To learn how to use this method, see [Delete a Google Workspace
     * subscription](https://developers.google.com/workspace/events/guides/delete-subscription).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSubscription(
            com.google.apps.events.subscriptions.v1.DeleteSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Google Workspace subscription. To learn how to use
     * this method, see [Get details about a Google Workspace
     * subscription](https://developers.google.com/workspace/events/guides/get-subscription).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.events.subscriptions.v1.Subscription>
        getSubscription(com.google.apps.events.subscriptions.v1.GetSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Google Workspace subscriptions. To learn how to use this method, see
     * [List Google Workspace
     * subscriptions](https://developers.google.com/workspace/events/guides/list-subscriptions).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.events.subscriptions.v1.ListSubscriptionsResponse>
        listSubscriptions(
            com.google.apps.events.subscriptions.v1.ListSubscriptionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSubscriptionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates or renews a Google Workspace subscription. To learn how to use this
     * method, see [Update or renew a Google Workspace
     * subscription](https://developers.google.com/workspace/events/guides/update-subscription).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateSubscription(
            com.google.apps.events.subscriptions.v1.UpdateSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reactivates a suspended Google Workspace subscription.
     * This method resets your subscription's `State` field to `ACTIVE`. Before
     * you use this method, you must fix the error that suspended the
     * subscription. To learn how to use this method, see [Reactivate a Google
     * Workspace
     * subscription](https://developers.google.com/workspace/events/guides/reactivate-subscription).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        reactivateSubscription(
            com.google.apps.events.subscriptions.v1.ReactivateSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReactivateSubscriptionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SUBSCRIPTION = 0;
  private static final int METHODID_DELETE_SUBSCRIPTION = 1;
  private static final int METHODID_GET_SUBSCRIPTION = 2;
  private static final int METHODID_LIST_SUBSCRIPTIONS = 3;
  private static final int METHODID_UPDATE_SUBSCRIPTION = 4;
  private static final int METHODID_REACTIVATE_SUBSCRIPTION = 5;

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
        case METHODID_CREATE_SUBSCRIPTION:
          serviceImpl.createSubscription(
              (com.google.apps.events.subscriptions.v1.CreateSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SUBSCRIPTION:
          serviceImpl.deleteSubscription(
              (com.google.apps.events.subscriptions.v1.DeleteSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_SUBSCRIPTION:
          serviceImpl.getSubscription(
              (com.google.apps.events.subscriptions.v1.GetSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.events.subscriptions.v1.Subscription>)
                  responseObserver);
          break;
        case METHODID_LIST_SUBSCRIPTIONS:
          serviceImpl.listSubscriptions(
              (com.google.apps.events.subscriptions.v1.ListSubscriptionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.apps.events.subscriptions.v1.ListSubscriptionsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SUBSCRIPTION:
          serviceImpl.updateSubscription(
              (com.google.apps.events.subscriptions.v1.UpdateSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REACTIVATE_SUBSCRIPTION:
          serviceImpl.reactivateSubscription(
              (com.google.apps.events.subscriptions.v1.ReactivateSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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
            getCreateSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.events.subscriptions.v1.CreateSubscriptionRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SUBSCRIPTION)))
        .addMethod(
            getDeleteSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.events.subscriptions.v1.DeleteSubscriptionRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SUBSCRIPTION)))
        .addMethod(
            getGetSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.events.subscriptions.v1.GetSubscriptionRequest,
                    com.google.apps.events.subscriptions.v1.Subscription>(
                    service, METHODID_GET_SUBSCRIPTION)))
        .addMethod(
            getListSubscriptionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.events.subscriptions.v1.ListSubscriptionsRequest,
                    com.google.apps.events.subscriptions.v1.ListSubscriptionsResponse>(
                    service, METHODID_LIST_SUBSCRIPTIONS)))
        .addMethod(
            getUpdateSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.events.subscriptions.v1.UpdateSubscriptionRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_SUBSCRIPTION)))
        .addMethod(
            getReactivateSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.events.subscriptions.v1.ReactivateSubscriptionRequest,
                    com.google.longrunning.Operation>(service, METHODID_REACTIVATE_SUBSCRIPTION)))
        .build();
  }

  private abstract static class SubscriptionsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SubscriptionsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.apps.events.subscriptions.v1.SubscriptionsServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SubscriptionsService");
    }
  }

  private static final class SubscriptionsServiceFileDescriptorSupplier
      extends SubscriptionsServiceBaseDescriptorSupplier {
    SubscriptionsServiceFileDescriptorSupplier() {}
  }

  private static final class SubscriptionsServiceMethodDescriptorSupplier
      extends SubscriptionsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SubscriptionsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SubscriptionsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SubscriptionsServiceFileDescriptorSupplier())
                      .addMethod(getCreateSubscriptionMethod())
                      .addMethod(getDeleteSubscriptionMethod())
                      .addMethod(getGetSubscriptionMethod())
                      .addMethod(getListSubscriptionsMethod())
                      .addMethod(getUpdateSubscriptionMethod())
                      .addMethod(getReactivateSubscriptionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
