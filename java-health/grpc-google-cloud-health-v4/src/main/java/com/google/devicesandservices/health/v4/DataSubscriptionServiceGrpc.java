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
package com.google.devicesandservices.health.v4;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Data Subscription Service that allows clients (e.g., Fitbit 3P
 * applications, internal Fitbit Services) to manage their subscriber endpoints.
 * This service provides CRUD APIs for subscribers,
 * and also offers functionalities for subscriber verification and statistics.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class DataSubscriptionServiceGrpc {

  private DataSubscriptionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.devicesandservices.health.v4.DataSubscriptionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.CreateSubscriberRequest,
          com.google.longrunning.Operation>
      getCreateSubscriberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSubscriber",
      requestType = com.google.devicesandservices.health.v4.CreateSubscriberRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.CreateSubscriberRequest,
          com.google.longrunning.Operation>
      getCreateSubscriberMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.CreateSubscriberRequest,
            com.google.longrunning.Operation>
        getCreateSubscriberMethod;
    if ((getCreateSubscriberMethod = DataSubscriptionServiceGrpc.getCreateSubscriberMethod)
        == null) {
      synchronized (DataSubscriptionServiceGrpc.class) {
        if ((getCreateSubscriberMethod = DataSubscriptionServiceGrpc.getCreateSubscriberMethod)
            == null) {
          DataSubscriptionServiceGrpc.getCreateSubscriberMethod =
              getCreateSubscriberMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.CreateSubscriberRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSubscriber"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.CreateSubscriberRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataSubscriptionServiceMethodDescriptorSupplier("CreateSubscriber"))
                      .build();
        }
      }
    }
    return getCreateSubscriberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.ListSubscribersRequest,
          com.google.devicesandservices.health.v4.ListSubscribersResponse>
      getListSubscribersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSubscribers",
      requestType = com.google.devicesandservices.health.v4.ListSubscribersRequest.class,
      responseType = com.google.devicesandservices.health.v4.ListSubscribersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.ListSubscribersRequest,
          com.google.devicesandservices.health.v4.ListSubscribersResponse>
      getListSubscribersMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.ListSubscribersRequest,
            com.google.devicesandservices.health.v4.ListSubscribersResponse>
        getListSubscribersMethod;
    if ((getListSubscribersMethod = DataSubscriptionServiceGrpc.getListSubscribersMethod) == null) {
      synchronized (DataSubscriptionServiceGrpc.class) {
        if ((getListSubscribersMethod = DataSubscriptionServiceGrpc.getListSubscribersMethod)
            == null) {
          DataSubscriptionServiceGrpc.getListSubscribersMethod =
              getListSubscribersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.ListSubscribersRequest,
                          com.google.devicesandservices.health.v4.ListSubscribersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSubscribers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.ListSubscribersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.ListSubscribersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataSubscriptionServiceMethodDescriptorSupplier("ListSubscribers"))
                      .build();
        }
      }
    }
    return getListSubscribersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.UpdateSubscriberRequest,
          com.google.longrunning.Operation>
      getUpdateSubscriberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSubscriber",
      requestType = com.google.devicesandservices.health.v4.UpdateSubscriberRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.UpdateSubscriberRequest,
          com.google.longrunning.Operation>
      getUpdateSubscriberMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.UpdateSubscriberRequest,
            com.google.longrunning.Operation>
        getUpdateSubscriberMethod;
    if ((getUpdateSubscriberMethod = DataSubscriptionServiceGrpc.getUpdateSubscriberMethod)
        == null) {
      synchronized (DataSubscriptionServiceGrpc.class) {
        if ((getUpdateSubscriberMethod = DataSubscriptionServiceGrpc.getUpdateSubscriberMethod)
            == null) {
          DataSubscriptionServiceGrpc.getUpdateSubscriberMethod =
              getUpdateSubscriberMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.UpdateSubscriberRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSubscriber"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.UpdateSubscriberRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataSubscriptionServiceMethodDescriptorSupplier("UpdateSubscriber"))
                      .build();
        }
      }
    }
    return getUpdateSubscriberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.DeleteSubscriberRequest,
          com.google.longrunning.Operation>
      getDeleteSubscriberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSubscriber",
      requestType = com.google.devicesandservices.health.v4.DeleteSubscriberRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.DeleteSubscriberRequest,
          com.google.longrunning.Operation>
      getDeleteSubscriberMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.DeleteSubscriberRequest,
            com.google.longrunning.Operation>
        getDeleteSubscriberMethod;
    if ((getDeleteSubscriberMethod = DataSubscriptionServiceGrpc.getDeleteSubscriberMethod)
        == null) {
      synchronized (DataSubscriptionServiceGrpc.class) {
        if ((getDeleteSubscriberMethod = DataSubscriptionServiceGrpc.getDeleteSubscriberMethod)
            == null) {
          DataSubscriptionServiceGrpc.getDeleteSubscriberMethod =
              getDeleteSubscriberMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.DeleteSubscriberRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSubscriber"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.DeleteSubscriberRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataSubscriptionServiceMethodDescriptorSupplier("DeleteSubscriber"))
                      .build();
        }
      }
    }
    return getDeleteSubscriberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.CreateSubscriptionRequest,
          com.google.devicesandservices.health.v4.Subscription>
      getCreateSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSubscription",
      requestType = com.google.devicesandservices.health.v4.CreateSubscriptionRequest.class,
      responseType = com.google.devicesandservices.health.v4.Subscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.CreateSubscriptionRequest,
          com.google.devicesandservices.health.v4.Subscription>
      getCreateSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.CreateSubscriptionRequest,
            com.google.devicesandservices.health.v4.Subscription>
        getCreateSubscriptionMethod;
    if ((getCreateSubscriptionMethod = DataSubscriptionServiceGrpc.getCreateSubscriptionMethod)
        == null) {
      synchronized (DataSubscriptionServiceGrpc.class) {
        if ((getCreateSubscriptionMethod = DataSubscriptionServiceGrpc.getCreateSubscriptionMethod)
            == null) {
          DataSubscriptionServiceGrpc.getCreateSubscriptionMethod =
              getCreateSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.CreateSubscriptionRequest,
                          com.google.devicesandservices.health.v4.Subscription>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.CreateSubscriptionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.Subscription
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataSubscriptionServiceMethodDescriptorSupplier("CreateSubscription"))
                      .build();
        }
      }
    }
    return getCreateSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.ListSubscriptionsRequest,
          com.google.devicesandservices.health.v4.ListSubscriptionsResponse>
      getListSubscriptionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSubscriptions",
      requestType = com.google.devicesandservices.health.v4.ListSubscriptionsRequest.class,
      responseType = com.google.devicesandservices.health.v4.ListSubscriptionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.ListSubscriptionsRequest,
          com.google.devicesandservices.health.v4.ListSubscriptionsResponse>
      getListSubscriptionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.ListSubscriptionsRequest,
            com.google.devicesandservices.health.v4.ListSubscriptionsResponse>
        getListSubscriptionsMethod;
    if ((getListSubscriptionsMethod = DataSubscriptionServiceGrpc.getListSubscriptionsMethod)
        == null) {
      synchronized (DataSubscriptionServiceGrpc.class) {
        if ((getListSubscriptionsMethod = DataSubscriptionServiceGrpc.getListSubscriptionsMethod)
            == null) {
          DataSubscriptionServiceGrpc.getListSubscriptionsMethod =
              getListSubscriptionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.ListSubscriptionsRequest,
                          com.google.devicesandservices.health.v4.ListSubscriptionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSubscriptions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.ListSubscriptionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.ListSubscriptionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataSubscriptionServiceMethodDescriptorSupplier("ListSubscriptions"))
                      .build();
        }
      }
    }
    return getListSubscriptionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.UpdateSubscriptionRequest,
          com.google.devicesandservices.health.v4.Subscription>
      getUpdateSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSubscription",
      requestType = com.google.devicesandservices.health.v4.UpdateSubscriptionRequest.class,
      responseType = com.google.devicesandservices.health.v4.Subscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.UpdateSubscriptionRequest,
          com.google.devicesandservices.health.v4.Subscription>
      getUpdateSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.UpdateSubscriptionRequest,
            com.google.devicesandservices.health.v4.Subscription>
        getUpdateSubscriptionMethod;
    if ((getUpdateSubscriptionMethod = DataSubscriptionServiceGrpc.getUpdateSubscriptionMethod)
        == null) {
      synchronized (DataSubscriptionServiceGrpc.class) {
        if ((getUpdateSubscriptionMethod = DataSubscriptionServiceGrpc.getUpdateSubscriptionMethod)
            == null) {
          DataSubscriptionServiceGrpc.getUpdateSubscriptionMethod =
              getUpdateSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.UpdateSubscriptionRequest,
                          com.google.devicesandservices.health.v4.Subscription>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.UpdateSubscriptionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.Subscription
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataSubscriptionServiceMethodDescriptorSupplier("UpdateSubscription"))
                      .build();
        }
      }
    }
    return getUpdateSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.DeleteSubscriptionRequest,
          com.google.protobuf.Empty>
      getDeleteSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSubscription",
      requestType = com.google.devicesandservices.health.v4.DeleteSubscriptionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devicesandservices.health.v4.DeleteSubscriptionRequest,
          com.google.protobuf.Empty>
      getDeleteSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.devicesandservices.health.v4.DeleteSubscriptionRequest,
            com.google.protobuf.Empty>
        getDeleteSubscriptionMethod;
    if ((getDeleteSubscriptionMethod = DataSubscriptionServiceGrpc.getDeleteSubscriptionMethod)
        == null) {
      synchronized (DataSubscriptionServiceGrpc.class) {
        if ((getDeleteSubscriptionMethod = DataSubscriptionServiceGrpc.getDeleteSubscriptionMethod)
            == null) {
          DataSubscriptionServiceGrpc.getDeleteSubscriptionMethod =
              getDeleteSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devicesandservices.health.v4.DeleteSubscriptionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devicesandservices.health.v4.DeleteSubscriptionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataSubscriptionServiceMethodDescriptorSupplier("DeleteSubscription"))
                      .build();
        }
      }
    }
    return getDeleteSubscriptionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataSubscriptionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataSubscriptionServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataSubscriptionServiceStub>() {
          @java.lang.Override
          public DataSubscriptionServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataSubscriptionServiceStub(channel, callOptions);
          }
        };
    return DataSubscriptionServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DataSubscriptionServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataSubscriptionServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataSubscriptionServiceBlockingV2Stub>() {
          @java.lang.Override
          public DataSubscriptionServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataSubscriptionServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return DataSubscriptionServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataSubscriptionServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataSubscriptionServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataSubscriptionServiceBlockingStub>() {
          @java.lang.Override
          public DataSubscriptionServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataSubscriptionServiceBlockingStub(channel, callOptions);
          }
        };
    return DataSubscriptionServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataSubscriptionServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataSubscriptionServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataSubscriptionServiceFutureStub>() {
          @java.lang.Override
          public DataSubscriptionServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataSubscriptionServiceFutureStub(channel, callOptions);
          }
        };
    return DataSubscriptionServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Data Subscription Service that allows clients (e.g., Fitbit 3P
   * applications, internal Fitbit Services) to manage their subscriber endpoints.
   * This service provides CRUD APIs for subscribers,
   * and also offers functionalities for subscriber verification and statistics.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Registers a new subscriber endpoint to receive notifications.
     * A subscriber represents an application or service that wishes to receive
     * data change notifications for users who have granted consent.
     * **Endpoint Verification:**
     * For a subscriber to be successfully created, the provided `endpoint_uri`
     * must be a valid HTTPS endpoint and must pass an automated verification
     * check. The backend will send two HTTP POST requests to the `endpoint_uri`:
     * 1.  **Verification with Authorization:**
     *     *   **Headers:** Includes `Content-Type: application/json` and
     *         `Authorization` (with the exact value from
     *         `CreateSubscriberPayload.endpoint_authorization.secret`).
     *     *   **Body:** `{"type": "verification"}`
     *     *   **Expected Response:** HTTP `201 Created`.
     * 2.  **Verification without Authorization:**
     *     *   **Headers:** Includes `Content-Type: application/json`. The
     *         `Authorization` header is OMITTED.
     *     *   **Body:** `{"type": "verification"}`
     *     *   **Expected Response:** HTTP `401 Unauthorized` or `403 Forbidden`.
     * Both tests must pass for the subscriber creation to succeed. If
     * verification fails, the operation will not be completed and an error will
     * be returned. This process ensures the endpoint is reachable and correctly
     * validates the `Authorization` header.
     * </pre>
     */
    default void createSubscriber(
        com.google.devicesandservices.health.v4.CreateSubscriberRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSubscriberMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all subscribers registered within the owned Google Cloud Project.
     * </pre>
     */
    default void listSubscribers(
        com.google.devicesandservices.health.v4.ListSubscribersRequest request,
        io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.ListSubscribersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSubscribersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the configuration of an existing subscriber, such as the
     * endpoint URI or the data types it's interested in.
     * **Endpoint Verification:**
     * If the `endpoint_uri` or `endpoint_authorization` field is included in the
     * `update_mask`, the backend will re-verify the endpoint. The verification
     * process is the same as described in `CreateSubscriber`:
     * 1.  **Verification with Authorization:** POST to the new or existing
     *     `endpoint_uri` with the new or existing `Authorization` secret. Expects
     *     HTTP `201 Created`.
     * 2.  **Verification without Authorization:** POST to the `endpoint_uri`
     *     without the `Authorization` header. Expects HTTP `401 Unauthorized` or
     *     `403 Forbidden`.
     * Both tests must pass using the potentially updated values for the
     * subscriber update to succeed. If verification fails, the update will not
     * be applied, and an error will be returned.
     * </pre>
     */
    default void updateSubscriber(
        com.google.devicesandservices.health.v4.UpdateSubscriberRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSubscriberMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a subscriber registration. This will stop all notifications
     * to the subscriber's endpoint.
     * </pre>
     */
    default void deleteSubscriber(
        com.google.devicesandservices.health.v4.DeleteSubscriberRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSubscriberMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a subscription for a specific user to a specific subscriber.
     * This method requires the subscriber to have a `SubscriptionCreatePolicy`
     * set to `MANUAL` for the given data types.
     * </pre>
     */
    default void createSubscription(
        com.google.devicesandservices.health.v4.CreateSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Subscription>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all active subscriptions for a given subscriber. This can be
     * filtered, for example, by user or data type.
     * </pre>
     */
    default void listSubscriptions(
        com.google.devicesandservices.health.v4.ListSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devicesandservices.health.v4.ListSubscriptionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSubscriptionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the data types for an existing user subscription.
     * </pre>
     */
    default void updateSubscription(
        com.google.devicesandservices.health.v4.UpdateSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Subscription>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific user subscription, stopping notifications for this
     * user to this subscriber.
     * </pre>
     */
    default void deleteSubscription(
        com.google.devicesandservices.health.v4.DeleteSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSubscriptionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataSubscriptionService.
   *
   * <pre>
   * Data Subscription Service that allows clients (e.g., Fitbit 3P
   * applications, internal Fitbit Services) to manage their subscriber endpoints.
   * This service provides CRUD APIs for subscribers,
   * and also offers functionalities for subscriber verification and statistics.
   * </pre>
   */
  public abstract static class DataSubscriptionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DataSubscriptionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataSubscriptionService.
   *
   * <pre>
   * Data Subscription Service that allows clients (e.g., Fitbit 3P
   * applications, internal Fitbit Services) to manage their subscriber endpoints.
   * This service provides CRUD APIs for subscribers,
   * and also offers functionalities for subscriber verification and statistics.
   * </pre>
   */
  public static final class DataSubscriptionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataSubscriptionServiceStub> {
    private DataSubscriptionServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataSubscriptionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataSubscriptionServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Registers a new subscriber endpoint to receive notifications.
     * A subscriber represents an application or service that wishes to receive
     * data change notifications for users who have granted consent.
     * **Endpoint Verification:**
     * For a subscriber to be successfully created, the provided `endpoint_uri`
     * must be a valid HTTPS endpoint and must pass an automated verification
     * check. The backend will send two HTTP POST requests to the `endpoint_uri`:
     * 1.  **Verification with Authorization:**
     *     *   **Headers:** Includes `Content-Type: application/json` and
     *         `Authorization` (with the exact value from
     *         `CreateSubscriberPayload.endpoint_authorization.secret`).
     *     *   **Body:** `{"type": "verification"}`
     *     *   **Expected Response:** HTTP `201 Created`.
     * 2.  **Verification without Authorization:**
     *     *   **Headers:** Includes `Content-Type: application/json`. The
     *         `Authorization` header is OMITTED.
     *     *   **Body:** `{"type": "verification"}`
     *     *   **Expected Response:** HTTP `401 Unauthorized` or `403 Forbidden`.
     * Both tests must pass for the subscriber creation to succeed. If
     * verification fails, the operation will not be completed and an error will
     * be returned. This process ensures the endpoint is reachable and correctly
     * validates the `Authorization` header.
     * </pre>
     */
    public void createSubscriber(
        com.google.devicesandservices.health.v4.CreateSubscriberRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSubscriberMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all subscribers registered within the owned Google Cloud Project.
     * </pre>
     */
    public void listSubscribers(
        com.google.devicesandservices.health.v4.ListSubscribersRequest request,
        io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.ListSubscribersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSubscribersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the configuration of an existing subscriber, such as the
     * endpoint URI or the data types it's interested in.
     * **Endpoint Verification:**
     * If the `endpoint_uri` or `endpoint_authorization` field is included in the
     * `update_mask`, the backend will re-verify the endpoint. The verification
     * process is the same as described in `CreateSubscriber`:
     * 1.  **Verification with Authorization:** POST to the new or existing
     *     `endpoint_uri` with the new or existing `Authorization` secret. Expects
     *     HTTP `201 Created`.
     * 2.  **Verification without Authorization:** POST to the `endpoint_uri`
     *     without the `Authorization` header. Expects HTTP `401 Unauthorized` or
     *     `403 Forbidden`.
     * Both tests must pass using the potentially updated values for the
     * subscriber update to succeed. If verification fails, the update will not
     * be applied, and an error will be returned.
     * </pre>
     */
    public void updateSubscriber(
        com.google.devicesandservices.health.v4.UpdateSubscriberRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSubscriberMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a subscriber registration. This will stop all notifications
     * to the subscriber's endpoint.
     * </pre>
     */
    public void deleteSubscriber(
        com.google.devicesandservices.health.v4.DeleteSubscriberRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSubscriberMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a subscription for a specific user to a specific subscriber.
     * This method requires the subscriber to have a `SubscriptionCreatePolicy`
     * set to `MANUAL` for the given data types.
     * </pre>
     */
    public void createSubscription(
        com.google.devicesandservices.health.v4.CreateSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Subscription>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all active subscriptions for a given subscriber. This can be
     * filtered, for example, by user or data type.
     * </pre>
     */
    public void listSubscriptions(
        com.google.devicesandservices.health.v4.ListSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devicesandservices.health.v4.ListSubscriptionsResponse>
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
     * Updates the data types for an existing user subscription.
     * </pre>
     */
    public void updateSubscription(
        com.google.devicesandservices.health.v4.UpdateSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Subscription>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific user subscription, stopping notifications for this
     * user to this subscriber.
     * </pre>
     */
    public void deleteSubscription(
        com.google.devicesandservices.health.v4.DeleteSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataSubscriptionService.
   *
   * <pre>
   * Data Subscription Service that allows clients (e.g., Fitbit 3P
   * applications, internal Fitbit Services) to manage their subscriber endpoints.
   * This service provides CRUD APIs for subscribers,
   * and also offers functionalities for subscriber verification and statistics.
   * </pre>
   */
  public static final class DataSubscriptionServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DataSubscriptionServiceBlockingV2Stub> {
    private DataSubscriptionServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataSubscriptionServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataSubscriptionServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Registers a new subscriber endpoint to receive notifications.
     * A subscriber represents an application or service that wishes to receive
     * data change notifications for users who have granted consent.
     * **Endpoint Verification:**
     * For a subscriber to be successfully created, the provided `endpoint_uri`
     * must be a valid HTTPS endpoint and must pass an automated verification
     * check. The backend will send two HTTP POST requests to the `endpoint_uri`:
     * 1.  **Verification with Authorization:**
     *     *   **Headers:** Includes `Content-Type: application/json` and
     *         `Authorization` (with the exact value from
     *         `CreateSubscriberPayload.endpoint_authorization.secret`).
     *     *   **Body:** `{"type": "verification"}`
     *     *   **Expected Response:** HTTP `201 Created`.
     * 2.  **Verification without Authorization:**
     *     *   **Headers:** Includes `Content-Type: application/json`. The
     *         `Authorization` header is OMITTED.
     *     *   **Body:** `{"type": "verification"}`
     *     *   **Expected Response:** HTTP `401 Unauthorized` or `403 Forbidden`.
     * Both tests must pass for the subscriber creation to succeed. If
     * verification fails, the operation will not be completed and an error will
     * be returned. This process ensures the endpoint is reachable and correctly
     * validates the `Authorization` header.
     * </pre>
     */
    public com.google.longrunning.Operation createSubscriber(
        com.google.devicesandservices.health.v4.CreateSubscriberRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateSubscriberMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all subscribers registered within the owned Google Cloud Project.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.ListSubscribersResponse listSubscribers(
        com.google.devicesandservices.health.v4.ListSubscribersRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSubscribersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the configuration of an existing subscriber, such as the
     * endpoint URI or the data types it's interested in.
     * **Endpoint Verification:**
     * If the `endpoint_uri` or `endpoint_authorization` field is included in the
     * `update_mask`, the backend will re-verify the endpoint. The verification
     * process is the same as described in `CreateSubscriber`:
     * 1.  **Verification with Authorization:** POST to the new or existing
     *     `endpoint_uri` with the new or existing `Authorization` secret. Expects
     *     HTTP `201 Created`.
     * 2.  **Verification without Authorization:** POST to the `endpoint_uri`
     *     without the `Authorization` header. Expects HTTP `401 Unauthorized` or
     *     `403 Forbidden`.
     * Both tests must pass using the potentially updated values for the
     * subscriber update to succeed. If verification fails, the update will not
     * be applied, and an error will be returned.
     * </pre>
     */
    public com.google.longrunning.Operation updateSubscriber(
        com.google.devicesandservices.health.v4.UpdateSubscriberRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateSubscriberMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a subscriber registration. This will stop all notifications
     * to the subscriber's endpoint.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSubscriber(
        com.google.devicesandservices.health.v4.DeleteSubscriberRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteSubscriberMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a subscription for a specific user to a specific subscriber.
     * This method requires the subscriber to have a `SubscriptionCreatePolicy`
     * set to `MANUAL` for the given data types.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.Subscription createSubscription(
        com.google.devicesandservices.health.v4.CreateSubscriptionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all active subscriptions for a given subscriber. This can be
     * filtered, for example, by user or data type.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.ListSubscriptionsResponse listSubscriptions(
        com.google.devicesandservices.health.v4.ListSubscriptionsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSubscriptionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the data types for an existing user subscription.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.Subscription updateSubscription(
        com.google.devicesandservices.health.v4.UpdateSubscriptionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific user subscription, stopping notifications for this
     * user to this subscriber.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSubscription(
        com.google.devicesandservices.health.v4.DeleteSubscriptionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteSubscriptionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DataSubscriptionService.
   *
   * <pre>
   * Data Subscription Service that allows clients (e.g., Fitbit 3P
   * applications, internal Fitbit Services) to manage their subscriber endpoints.
   * This service provides CRUD APIs for subscribers,
   * and also offers functionalities for subscriber verification and statistics.
   * </pre>
   */
  public static final class DataSubscriptionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataSubscriptionServiceBlockingStub> {
    private DataSubscriptionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataSubscriptionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataSubscriptionServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Registers a new subscriber endpoint to receive notifications.
     * A subscriber represents an application or service that wishes to receive
     * data change notifications for users who have granted consent.
     * **Endpoint Verification:**
     * For a subscriber to be successfully created, the provided `endpoint_uri`
     * must be a valid HTTPS endpoint and must pass an automated verification
     * check. The backend will send two HTTP POST requests to the `endpoint_uri`:
     * 1.  **Verification with Authorization:**
     *     *   **Headers:** Includes `Content-Type: application/json` and
     *         `Authorization` (with the exact value from
     *         `CreateSubscriberPayload.endpoint_authorization.secret`).
     *     *   **Body:** `{"type": "verification"}`
     *     *   **Expected Response:** HTTP `201 Created`.
     * 2.  **Verification without Authorization:**
     *     *   **Headers:** Includes `Content-Type: application/json`. The
     *         `Authorization` header is OMITTED.
     *     *   **Body:** `{"type": "verification"}`
     *     *   **Expected Response:** HTTP `401 Unauthorized` or `403 Forbidden`.
     * Both tests must pass for the subscriber creation to succeed. If
     * verification fails, the operation will not be completed and an error will
     * be returned. This process ensures the endpoint is reachable and correctly
     * validates the `Authorization` header.
     * </pre>
     */
    public com.google.longrunning.Operation createSubscriber(
        com.google.devicesandservices.health.v4.CreateSubscriberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSubscriberMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all subscribers registered within the owned Google Cloud Project.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.ListSubscribersResponse listSubscribers(
        com.google.devicesandservices.health.v4.ListSubscribersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSubscribersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the configuration of an existing subscriber, such as the
     * endpoint URI or the data types it's interested in.
     * **Endpoint Verification:**
     * If the `endpoint_uri` or `endpoint_authorization` field is included in the
     * `update_mask`, the backend will re-verify the endpoint. The verification
     * process is the same as described in `CreateSubscriber`:
     * 1.  **Verification with Authorization:** POST to the new or existing
     *     `endpoint_uri` with the new or existing `Authorization` secret. Expects
     *     HTTP `201 Created`.
     * 2.  **Verification without Authorization:** POST to the `endpoint_uri`
     *     without the `Authorization` header. Expects HTTP `401 Unauthorized` or
     *     `403 Forbidden`.
     * Both tests must pass using the potentially updated values for the
     * subscriber update to succeed. If verification fails, the update will not
     * be applied, and an error will be returned.
     * </pre>
     */
    public com.google.longrunning.Operation updateSubscriber(
        com.google.devicesandservices.health.v4.UpdateSubscriberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSubscriberMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a subscriber registration. This will stop all notifications
     * to the subscriber's endpoint.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSubscriber(
        com.google.devicesandservices.health.v4.DeleteSubscriberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSubscriberMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a subscription for a specific user to a specific subscriber.
     * This method requires the subscriber to have a `SubscriptionCreatePolicy`
     * set to `MANUAL` for the given data types.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.Subscription createSubscription(
        com.google.devicesandservices.health.v4.CreateSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all active subscriptions for a given subscriber. This can be
     * filtered, for example, by user or data type.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.ListSubscriptionsResponse listSubscriptions(
        com.google.devicesandservices.health.v4.ListSubscriptionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSubscriptionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the data types for an existing user subscription.
     * </pre>
     */
    public com.google.devicesandservices.health.v4.Subscription updateSubscription(
        com.google.devicesandservices.health.v4.UpdateSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific user subscription, stopping notifications for this
     * user to this subscriber.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSubscription(
        com.google.devicesandservices.health.v4.DeleteSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSubscriptionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * DataSubscriptionService.
   *
   * <pre>
   * Data Subscription Service that allows clients (e.g., Fitbit 3P
   * applications, internal Fitbit Services) to manage their subscriber endpoints.
   * This service provides CRUD APIs for subscribers,
   * and also offers functionalities for subscriber verification and statistics.
   * </pre>
   */
  public static final class DataSubscriptionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataSubscriptionServiceFutureStub> {
    private DataSubscriptionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataSubscriptionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataSubscriptionServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Registers a new subscriber endpoint to receive notifications.
     * A subscriber represents an application or service that wishes to receive
     * data change notifications for users who have granted consent.
     * **Endpoint Verification:**
     * For a subscriber to be successfully created, the provided `endpoint_uri`
     * must be a valid HTTPS endpoint and must pass an automated verification
     * check. The backend will send two HTTP POST requests to the `endpoint_uri`:
     * 1.  **Verification with Authorization:**
     *     *   **Headers:** Includes `Content-Type: application/json` and
     *         `Authorization` (with the exact value from
     *         `CreateSubscriberPayload.endpoint_authorization.secret`).
     *     *   **Body:** `{"type": "verification"}`
     *     *   **Expected Response:** HTTP `201 Created`.
     * 2.  **Verification without Authorization:**
     *     *   **Headers:** Includes `Content-Type: application/json`. The
     *         `Authorization` header is OMITTED.
     *     *   **Body:** `{"type": "verification"}`
     *     *   **Expected Response:** HTTP `401 Unauthorized` or `403 Forbidden`.
     * Both tests must pass for the subscriber creation to succeed. If
     * verification fails, the operation will not be completed and an error will
     * be returned. This process ensures the endpoint is reachable and correctly
     * validates the `Authorization` header.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSubscriber(com.google.devicesandservices.health.v4.CreateSubscriberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSubscriberMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all subscribers registered within the owned Google Cloud Project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devicesandservices.health.v4.ListSubscribersResponse>
        listSubscribers(com.google.devicesandservices.health.v4.ListSubscribersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSubscribersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the configuration of an existing subscriber, such as the
     * endpoint URI or the data types it's interested in.
     * **Endpoint Verification:**
     * If the `endpoint_uri` or `endpoint_authorization` field is included in the
     * `update_mask`, the backend will re-verify the endpoint. The verification
     * process is the same as described in `CreateSubscriber`:
     * 1.  **Verification with Authorization:** POST to the new or existing
     *     `endpoint_uri` with the new or existing `Authorization` secret. Expects
     *     HTTP `201 Created`.
     * 2.  **Verification without Authorization:** POST to the `endpoint_uri`
     *     without the `Authorization` header. Expects HTTP `401 Unauthorized` or
     *     `403 Forbidden`.
     * Both tests must pass using the potentially updated values for the
     * subscriber update to succeed. If verification fails, the update will not
     * be applied, and an error will be returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateSubscriber(com.google.devicesandservices.health.v4.UpdateSubscriberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSubscriberMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a subscriber registration. This will stop all notifications
     * to the subscriber's endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSubscriber(com.google.devicesandservices.health.v4.DeleteSubscriberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSubscriberMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a subscription for a specific user to a specific subscriber.
     * This method requires the subscriber to have a `SubscriptionCreatePolicy`
     * set to `MANUAL` for the given data types.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devicesandservices.health.v4.Subscription>
        createSubscription(
            com.google.devicesandservices.health.v4.CreateSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all active subscriptions for a given subscriber. This can be
     * filtered, for example, by user or data type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devicesandservices.health.v4.ListSubscriptionsResponse>
        listSubscriptions(
            com.google.devicesandservices.health.v4.ListSubscriptionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSubscriptionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the data types for an existing user subscription.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devicesandservices.health.v4.Subscription>
        updateSubscription(
            com.google.devicesandservices.health.v4.UpdateSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific user subscription, stopping notifications for this
     * user to this subscriber.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSubscription(
            com.google.devicesandservices.health.v4.DeleteSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSubscriptionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SUBSCRIBER = 0;
  private static final int METHODID_LIST_SUBSCRIBERS = 1;
  private static final int METHODID_UPDATE_SUBSCRIBER = 2;
  private static final int METHODID_DELETE_SUBSCRIBER = 3;
  private static final int METHODID_CREATE_SUBSCRIPTION = 4;
  private static final int METHODID_LIST_SUBSCRIPTIONS = 5;
  private static final int METHODID_UPDATE_SUBSCRIPTION = 6;
  private static final int METHODID_DELETE_SUBSCRIPTION = 7;

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
        case METHODID_CREATE_SUBSCRIBER:
          serviceImpl.createSubscriber(
              (com.google.devicesandservices.health.v4.CreateSubscriberRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SUBSCRIBERS:
          serviceImpl.listSubscribers(
              (com.google.devicesandservices.health.v4.ListSubscribersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devicesandservices.health.v4.ListSubscribersResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SUBSCRIBER:
          serviceImpl.updateSubscriber(
              (com.google.devicesandservices.health.v4.UpdateSubscriberRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SUBSCRIBER:
          serviceImpl.deleteSubscriber(
              (com.google.devicesandservices.health.v4.DeleteSubscriberRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_SUBSCRIPTION:
          serviceImpl.createSubscription(
              (com.google.devicesandservices.health.v4.CreateSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Subscription>)
                  responseObserver);
          break;
        case METHODID_LIST_SUBSCRIPTIONS:
          serviceImpl.listSubscriptions(
              (com.google.devicesandservices.health.v4.ListSubscriptionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devicesandservices.health.v4.ListSubscriptionsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SUBSCRIPTION:
          serviceImpl.updateSubscription(
              (com.google.devicesandservices.health.v4.UpdateSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devicesandservices.health.v4.Subscription>)
                  responseObserver);
          break;
        case METHODID_DELETE_SUBSCRIPTION:
          serviceImpl.deleteSubscription(
              (com.google.devicesandservices.health.v4.DeleteSubscriptionRequest) request,
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
            getCreateSubscriberMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.CreateSubscriberRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SUBSCRIBER)))
        .addMethod(
            getListSubscribersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.ListSubscribersRequest,
                    com.google.devicesandservices.health.v4.ListSubscribersResponse>(
                    service, METHODID_LIST_SUBSCRIBERS)))
        .addMethod(
            getUpdateSubscriberMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.UpdateSubscriberRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_SUBSCRIBER)))
        .addMethod(
            getDeleteSubscriberMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.DeleteSubscriberRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SUBSCRIBER)))
        .addMethod(
            getCreateSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.CreateSubscriptionRequest,
                    com.google.devicesandservices.health.v4.Subscription>(
                    service, METHODID_CREATE_SUBSCRIPTION)))
        .addMethod(
            getListSubscriptionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.ListSubscriptionsRequest,
                    com.google.devicesandservices.health.v4.ListSubscriptionsResponse>(
                    service, METHODID_LIST_SUBSCRIPTIONS)))
        .addMethod(
            getUpdateSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.UpdateSubscriptionRequest,
                    com.google.devicesandservices.health.v4.Subscription>(
                    service, METHODID_UPDATE_SUBSCRIPTION)))
        .addMethod(
            getDeleteSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devicesandservices.health.v4.DeleteSubscriptionRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_SUBSCRIPTION)))
        .build();
  }

  private abstract static class DataSubscriptionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataSubscriptionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.devicesandservices.health.v4.DataSubscriptionServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataSubscriptionService");
    }
  }

  private static final class DataSubscriptionServiceFileDescriptorSupplier
      extends DataSubscriptionServiceBaseDescriptorSupplier {
    DataSubscriptionServiceFileDescriptorSupplier() {}
  }

  private static final class DataSubscriptionServiceMethodDescriptorSupplier
      extends DataSubscriptionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataSubscriptionServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DataSubscriptionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataSubscriptionServiceFileDescriptorSupplier())
                      .addMethod(getCreateSubscriberMethod())
                      .addMethod(getListSubscribersMethod())
                      .addMethod(getUpdateSubscriberMethod())
                      .addMethod(getDeleteSubscriberMethod())
                      .addMethod(getCreateSubscriptionMethod())
                      .addMethod(getListSubscriptionsMethod())
                      .addMethod(getUpdateSubscriptionMethod())
                      .addMethod(getDeleteSubscriptionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
