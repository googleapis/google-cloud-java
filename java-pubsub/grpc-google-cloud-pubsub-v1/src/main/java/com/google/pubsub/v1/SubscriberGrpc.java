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
package com.google.pubsub.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The service that an application uses to manipulate subscriptions and to
 * consume messages from a subscription via the `Pull` method or by
 * establishing a bi-directional stream using the `StreamingPull` method.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/pubsub/v1/pubsub.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SubscriberGrpc {

  private SubscriberGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.pubsub.v1.Subscriber";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.Subscription, com.google.pubsub.v1.Subscription>
      getCreateSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSubscription",
      requestType = com.google.pubsub.v1.Subscription.class,
      responseType = com.google.pubsub.v1.Subscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.Subscription, com.google.pubsub.v1.Subscription>
      getCreateSubscriptionMethod() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.Subscription, com.google.pubsub.v1.Subscription>
        getCreateSubscriptionMethod;
    if ((getCreateSubscriptionMethod = SubscriberGrpc.getCreateSubscriptionMethod) == null) {
      synchronized (SubscriberGrpc.class) {
        if ((getCreateSubscriptionMethod = SubscriberGrpc.getCreateSubscriptionMethod) == null) {
          SubscriberGrpc.getCreateSubscriptionMethod =
              getCreateSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.Subscription, com.google.pubsub.v1.Subscription>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.Subscription.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.Subscription.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SubscriberMethodDescriptorSupplier("CreateSubscription"))
                      .build();
        }
      }
    }
    return getCreateSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.GetSubscriptionRequest, com.google.pubsub.v1.Subscription>
      getGetSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubscription",
      requestType = com.google.pubsub.v1.GetSubscriptionRequest.class,
      responseType = com.google.pubsub.v1.Subscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.GetSubscriptionRequest, com.google.pubsub.v1.Subscription>
      getGetSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.GetSubscriptionRequest, com.google.pubsub.v1.Subscription>
        getGetSubscriptionMethod;
    if ((getGetSubscriptionMethod = SubscriberGrpc.getGetSubscriptionMethod) == null) {
      synchronized (SubscriberGrpc.class) {
        if ((getGetSubscriptionMethod = SubscriberGrpc.getGetSubscriptionMethod) == null) {
          SubscriberGrpc.getGetSubscriptionMethod =
              getGetSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.GetSubscriptionRequest,
                          com.google.pubsub.v1.Subscription>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.GetSubscriptionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.Subscription.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SubscriberMethodDescriptorSupplier("GetSubscription"))
                      .build();
        }
      }
    }
    return getGetSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.UpdateSubscriptionRequest, com.google.pubsub.v1.Subscription>
      getUpdateSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSubscription",
      requestType = com.google.pubsub.v1.UpdateSubscriptionRequest.class,
      responseType = com.google.pubsub.v1.Subscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.UpdateSubscriptionRequest, com.google.pubsub.v1.Subscription>
      getUpdateSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.UpdateSubscriptionRequest, com.google.pubsub.v1.Subscription>
        getUpdateSubscriptionMethod;
    if ((getUpdateSubscriptionMethod = SubscriberGrpc.getUpdateSubscriptionMethod) == null) {
      synchronized (SubscriberGrpc.class) {
        if ((getUpdateSubscriptionMethod = SubscriberGrpc.getUpdateSubscriptionMethod) == null) {
          SubscriberGrpc.getUpdateSubscriptionMethod =
              getUpdateSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.UpdateSubscriptionRequest,
                          com.google.pubsub.v1.Subscription>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.UpdateSubscriptionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.Subscription.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SubscriberMethodDescriptorSupplier("UpdateSubscription"))
                      .build();
        }
      }
    }
    return getUpdateSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListSubscriptionsRequest,
          com.google.pubsub.v1.ListSubscriptionsResponse>
      getListSubscriptionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSubscriptions",
      requestType = com.google.pubsub.v1.ListSubscriptionsRequest.class,
      responseType = com.google.pubsub.v1.ListSubscriptionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListSubscriptionsRequest,
          com.google.pubsub.v1.ListSubscriptionsResponse>
      getListSubscriptionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.ListSubscriptionsRequest,
            com.google.pubsub.v1.ListSubscriptionsResponse>
        getListSubscriptionsMethod;
    if ((getListSubscriptionsMethod = SubscriberGrpc.getListSubscriptionsMethod) == null) {
      synchronized (SubscriberGrpc.class) {
        if ((getListSubscriptionsMethod = SubscriberGrpc.getListSubscriptionsMethod) == null) {
          SubscriberGrpc.getListSubscriptionsMethod =
              getListSubscriptionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.ListSubscriptionsRequest,
                          com.google.pubsub.v1.ListSubscriptionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSubscriptions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.ListSubscriptionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.ListSubscriptionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SubscriberMethodDescriptorSupplier("ListSubscriptions"))
                      .build();
        }
      }
    }
    return getListSubscriptionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.DeleteSubscriptionRequest, com.google.protobuf.Empty>
      getDeleteSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSubscription",
      requestType = com.google.pubsub.v1.DeleteSubscriptionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.DeleteSubscriptionRequest, com.google.protobuf.Empty>
      getDeleteSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.DeleteSubscriptionRequest, com.google.protobuf.Empty>
        getDeleteSubscriptionMethod;
    if ((getDeleteSubscriptionMethod = SubscriberGrpc.getDeleteSubscriptionMethod) == null) {
      synchronized (SubscriberGrpc.class) {
        if ((getDeleteSubscriptionMethod = SubscriberGrpc.getDeleteSubscriptionMethod) == null) {
          SubscriberGrpc.getDeleteSubscriptionMethod =
              getDeleteSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.DeleteSubscriptionRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.DeleteSubscriptionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SubscriberMethodDescriptorSupplier("DeleteSubscription"))
                      .build();
        }
      }
    }
    return getDeleteSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ModifyAckDeadlineRequest, com.google.protobuf.Empty>
      getModifyAckDeadlineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModifyAckDeadline",
      requestType = com.google.pubsub.v1.ModifyAckDeadlineRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ModifyAckDeadlineRequest, com.google.protobuf.Empty>
      getModifyAckDeadlineMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.ModifyAckDeadlineRequest, com.google.protobuf.Empty>
        getModifyAckDeadlineMethod;
    if ((getModifyAckDeadlineMethod = SubscriberGrpc.getModifyAckDeadlineMethod) == null) {
      synchronized (SubscriberGrpc.class) {
        if ((getModifyAckDeadlineMethod = SubscriberGrpc.getModifyAckDeadlineMethod) == null) {
          SubscriberGrpc.getModifyAckDeadlineMethod =
              getModifyAckDeadlineMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.ModifyAckDeadlineRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ModifyAckDeadline"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.ModifyAckDeadlineRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SubscriberMethodDescriptorSupplier("ModifyAckDeadline"))
                      .build();
        }
      }
    }
    return getModifyAckDeadlineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.AcknowledgeRequest, com.google.protobuf.Empty>
      getAcknowledgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Acknowledge",
      requestType = com.google.pubsub.v1.AcknowledgeRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.AcknowledgeRequest, com.google.protobuf.Empty>
      getAcknowledgeMethod() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.AcknowledgeRequest, com.google.protobuf.Empty>
        getAcknowledgeMethod;
    if ((getAcknowledgeMethod = SubscriberGrpc.getAcknowledgeMethod) == null) {
      synchronized (SubscriberGrpc.class) {
        if ((getAcknowledgeMethod = SubscriberGrpc.getAcknowledgeMethod) == null) {
          SubscriberGrpc.getAcknowledgeMethod =
              getAcknowledgeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.AcknowledgeRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Acknowledge"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.AcknowledgeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new SubscriberMethodDescriptorSupplier("Acknowledge"))
                      .build();
        }
      }
    }
    return getAcknowledgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.PullRequest, com.google.pubsub.v1.PullResponse>
      getPullMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Pull",
      requestType = com.google.pubsub.v1.PullRequest.class,
      responseType = com.google.pubsub.v1.PullResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.PullRequest, com.google.pubsub.v1.PullResponse>
      getPullMethod() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.PullRequest, com.google.pubsub.v1.PullResponse>
        getPullMethod;
    if ((getPullMethod = SubscriberGrpc.getPullMethod) == null) {
      synchronized (SubscriberGrpc.class) {
        if ((getPullMethod = SubscriberGrpc.getPullMethod) == null) {
          SubscriberGrpc.getPullMethod =
              getPullMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.PullRequest, com.google.pubsub.v1.PullResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Pull"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.PullRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.PullResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SubscriberMethodDescriptorSupplier("Pull"))
                      .build();
        }
      }
    }
    return getPullMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.StreamingPullRequest, com.google.pubsub.v1.StreamingPullResponse>
      getStreamingPullMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamingPull",
      requestType = com.google.pubsub.v1.StreamingPullRequest.class,
      responseType = com.google.pubsub.v1.StreamingPullResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.StreamingPullRequest, com.google.pubsub.v1.StreamingPullResponse>
      getStreamingPullMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.StreamingPullRequest, com.google.pubsub.v1.StreamingPullResponse>
        getStreamingPullMethod;
    if ((getStreamingPullMethod = SubscriberGrpc.getStreamingPullMethod) == null) {
      synchronized (SubscriberGrpc.class) {
        if ((getStreamingPullMethod = SubscriberGrpc.getStreamingPullMethod) == null) {
          SubscriberGrpc.getStreamingPullMethod =
              getStreamingPullMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.StreamingPullRequest,
                          com.google.pubsub.v1.StreamingPullResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamingPull"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.StreamingPullRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.StreamingPullResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SubscriberMethodDescriptorSupplier("StreamingPull"))
                      .build();
        }
      }
    }
    return getStreamingPullMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ModifyPushConfigRequest, com.google.protobuf.Empty>
      getModifyPushConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModifyPushConfig",
      requestType = com.google.pubsub.v1.ModifyPushConfigRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ModifyPushConfigRequest, com.google.protobuf.Empty>
      getModifyPushConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.ModifyPushConfigRequest, com.google.protobuf.Empty>
        getModifyPushConfigMethod;
    if ((getModifyPushConfigMethod = SubscriberGrpc.getModifyPushConfigMethod) == null) {
      synchronized (SubscriberGrpc.class) {
        if ((getModifyPushConfigMethod = SubscriberGrpc.getModifyPushConfigMethod) == null) {
          SubscriberGrpc.getModifyPushConfigMethod =
              getModifyPushConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.ModifyPushConfigRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ModifyPushConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.ModifyPushConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SubscriberMethodDescriptorSupplier("ModifyPushConfig"))
                      .build();
        }
      }
    }
    return getModifyPushConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.GetSnapshotRequest, com.google.pubsub.v1.Snapshot>
      getGetSnapshotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSnapshot",
      requestType = com.google.pubsub.v1.GetSnapshotRequest.class,
      responseType = com.google.pubsub.v1.Snapshot.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.GetSnapshotRequest, com.google.pubsub.v1.Snapshot>
      getGetSnapshotMethod() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.GetSnapshotRequest, com.google.pubsub.v1.Snapshot>
        getGetSnapshotMethod;
    if ((getGetSnapshotMethod = SubscriberGrpc.getGetSnapshotMethod) == null) {
      synchronized (SubscriberGrpc.class) {
        if ((getGetSnapshotMethod = SubscriberGrpc.getGetSnapshotMethod) == null) {
          SubscriberGrpc.getGetSnapshotMethod =
              getGetSnapshotMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.GetSnapshotRequest, com.google.pubsub.v1.Snapshot>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSnapshot"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.GetSnapshotRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.Snapshot.getDefaultInstance()))
                      .setSchemaDescriptor(new SubscriberMethodDescriptorSupplier("GetSnapshot"))
                      .build();
        }
      }
    }
    return getGetSnapshotMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListSnapshotsRequest, com.google.pubsub.v1.ListSnapshotsResponse>
      getListSnapshotsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSnapshots",
      requestType = com.google.pubsub.v1.ListSnapshotsRequest.class,
      responseType = com.google.pubsub.v1.ListSnapshotsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListSnapshotsRequest, com.google.pubsub.v1.ListSnapshotsResponse>
      getListSnapshotsMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.ListSnapshotsRequest, com.google.pubsub.v1.ListSnapshotsResponse>
        getListSnapshotsMethod;
    if ((getListSnapshotsMethod = SubscriberGrpc.getListSnapshotsMethod) == null) {
      synchronized (SubscriberGrpc.class) {
        if ((getListSnapshotsMethod = SubscriberGrpc.getListSnapshotsMethod) == null) {
          SubscriberGrpc.getListSnapshotsMethod =
              getListSnapshotsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.ListSnapshotsRequest,
                          com.google.pubsub.v1.ListSnapshotsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSnapshots"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.ListSnapshotsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.ListSnapshotsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SubscriberMethodDescriptorSupplier("ListSnapshots"))
                      .build();
        }
      }
    }
    return getListSnapshotsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.CreateSnapshotRequest, com.google.pubsub.v1.Snapshot>
      getCreateSnapshotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSnapshot",
      requestType = com.google.pubsub.v1.CreateSnapshotRequest.class,
      responseType = com.google.pubsub.v1.Snapshot.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.CreateSnapshotRequest, com.google.pubsub.v1.Snapshot>
      getCreateSnapshotMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.CreateSnapshotRequest, com.google.pubsub.v1.Snapshot>
        getCreateSnapshotMethod;
    if ((getCreateSnapshotMethod = SubscriberGrpc.getCreateSnapshotMethod) == null) {
      synchronized (SubscriberGrpc.class) {
        if ((getCreateSnapshotMethod = SubscriberGrpc.getCreateSnapshotMethod) == null) {
          SubscriberGrpc.getCreateSnapshotMethod =
              getCreateSnapshotMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.CreateSnapshotRequest, com.google.pubsub.v1.Snapshot>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSnapshot"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.CreateSnapshotRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.Snapshot.getDefaultInstance()))
                      .setSchemaDescriptor(new SubscriberMethodDescriptorSupplier("CreateSnapshot"))
                      .build();
        }
      }
    }
    return getCreateSnapshotMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.UpdateSnapshotRequest, com.google.pubsub.v1.Snapshot>
      getUpdateSnapshotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSnapshot",
      requestType = com.google.pubsub.v1.UpdateSnapshotRequest.class,
      responseType = com.google.pubsub.v1.Snapshot.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.UpdateSnapshotRequest, com.google.pubsub.v1.Snapshot>
      getUpdateSnapshotMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.UpdateSnapshotRequest, com.google.pubsub.v1.Snapshot>
        getUpdateSnapshotMethod;
    if ((getUpdateSnapshotMethod = SubscriberGrpc.getUpdateSnapshotMethod) == null) {
      synchronized (SubscriberGrpc.class) {
        if ((getUpdateSnapshotMethod = SubscriberGrpc.getUpdateSnapshotMethod) == null) {
          SubscriberGrpc.getUpdateSnapshotMethod =
              getUpdateSnapshotMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.UpdateSnapshotRequest, com.google.pubsub.v1.Snapshot>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSnapshot"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.UpdateSnapshotRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.Snapshot.getDefaultInstance()))
                      .setSchemaDescriptor(new SubscriberMethodDescriptorSupplier("UpdateSnapshot"))
                      .build();
        }
      }
    }
    return getUpdateSnapshotMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.DeleteSnapshotRequest, com.google.protobuf.Empty>
      getDeleteSnapshotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSnapshot",
      requestType = com.google.pubsub.v1.DeleteSnapshotRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.DeleteSnapshotRequest, com.google.protobuf.Empty>
      getDeleteSnapshotMethod() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.DeleteSnapshotRequest, com.google.protobuf.Empty>
        getDeleteSnapshotMethod;
    if ((getDeleteSnapshotMethod = SubscriberGrpc.getDeleteSnapshotMethod) == null) {
      synchronized (SubscriberGrpc.class) {
        if ((getDeleteSnapshotMethod = SubscriberGrpc.getDeleteSnapshotMethod) == null) {
          SubscriberGrpc.getDeleteSnapshotMethod =
              getDeleteSnapshotMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.DeleteSnapshotRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSnapshot"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.DeleteSnapshotRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new SubscriberMethodDescriptorSupplier("DeleteSnapshot"))
                      .build();
        }
      }
    }
    return getDeleteSnapshotMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.SeekRequest, com.google.pubsub.v1.SeekResponse>
      getSeekMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Seek",
      requestType = com.google.pubsub.v1.SeekRequest.class,
      responseType = com.google.pubsub.v1.SeekResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.SeekRequest, com.google.pubsub.v1.SeekResponse>
      getSeekMethod() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.SeekRequest, com.google.pubsub.v1.SeekResponse>
        getSeekMethod;
    if ((getSeekMethod = SubscriberGrpc.getSeekMethod) == null) {
      synchronized (SubscriberGrpc.class) {
        if ((getSeekMethod = SubscriberGrpc.getSeekMethod) == null) {
          SubscriberGrpc.getSeekMethod =
              getSeekMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.SeekRequest, com.google.pubsub.v1.SeekResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Seek"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.SeekRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.SeekResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SubscriberMethodDescriptorSupplier("Seek"))
                      .build();
        }
      }
    }
    return getSeekMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SubscriberStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscriberStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SubscriberStub>() {
          @java.lang.Override
          public SubscriberStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SubscriberStub(channel, callOptions);
          }
        };
    return SubscriberStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SubscriberBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscriberBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SubscriberBlockingV2Stub>() {
          @java.lang.Override
          public SubscriberBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SubscriberBlockingV2Stub(channel, callOptions);
          }
        };
    return SubscriberBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SubscriberBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscriberBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SubscriberBlockingStub>() {
          @java.lang.Override
          public SubscriberBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SubscriberBlockingStub(channel, callOptions);
          }
        };
    return SubscriberBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SubscriberFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscriberFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SubscriberFutureStub>() {
          @java.lang.Override
          public SubscriberFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SubscriberFutureStub(channel, callOptions);
          }
        };
    return SubscriberFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The service that an application uses to manipulate subscriptions and to
   * consume messages from a subscription via the `Pull` method or by
   * establishing a bi-directional stream using the `StreamingPull` method.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a subscription to a given topic. See the [resource name rules]
     * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
     * If the subscription already exists, returns `ALREADY_EXISTS`.
     * If the corresponding topic doesn't exist, returns `NOT_FOUND`.
     * If the name is not provided in the request, the server will assign a random
     * name for this subscription on the same project as the topic, conforming
     * to the [resource name format]
     * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). The
     * generated name is populated in the returned Subscription object. Note that
     * for REST API requests, you must specify a name in the request.
     * </pre>
     */
    default void createSubscription(
        com.google.pubsub.v1.Subscription request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Subscription> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the configuration details of a subscription.
     * </pre>
     */
    default void getSubscription(
        com.google.pubsub.v1.GetSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Subscription> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing subscription by updating the fields specified in the
     * update mask. Note that certain properties of a subscription, such as its
     * topic, are not modifiable.
     * </pre>
     */
    default void updateSubscription(
        com.google.pubsub.v1.UpdateSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Subscription> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists matching subscriptions.
     * </pre>
     */
    default void listSubscriptions(
        com.google.pubsub.v1.ListSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListSubscriptionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSubscriptionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing subscription. All messages retained in the subscription
     * are immediately dropped. Calls to `Pull` after deletion will return
     * `NOT_FOUND`. After a subscription is deleted, a new one may be created with
     * the same name, but the new one has no association with the old
     * subscription or its topic unless the same topic is specified.
     * </pre>
     */
    default void deleteSubscription(
        com.google.pubsub.v1.DeleteSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSubscriptionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies the ack deadline for a specific message. This method is useful
     * to indicate that more time is needed to process a message by the
     * subscriber, or to make the message available for redelivery if the
     * processing was interrupted. Note that this does not modify the
     * subscription-level `ackDeadlineSeconds` used for subsequent messages.
     * </pre>
     */
    default void modifyAckDeadline(
        com.google.pubsub.v1.ModifyAckDeadlineRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getModifyAckDeadlineMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Acknowledges the messages associated with the `ack_ids` in the
     * `AcknowledgeRequest`. The Pub/Sub system can remove the relevant messages
     * from the subscription.
     * Acknowledging a message whose ack deadline has expired may succeed,
     * but such a message may be redelivered later. Acknowledging a message more
     * than once will not result in an error.
     * </pre>
     */
    default void acknowledge(
        com.google.pubsub.v1.AcknowledgeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAcknowledgeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pulls messages from the server.
     * </pre>
     */
    default void pull(
        com.google.pubsub.v1.PullRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.PullResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPullMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Establishes a stream with the server, which sends messages down to the
     * client. The client streams acknowledgments and ack deadline modifications
     * back to the server. The server will close the stream and return the status
     * on any error. The server may close the stream with status `UNAVAILABLE` to
     * reassign server-side resources, in which case, the client should
     * re-establish the stream. Flow control can be achieved by configuring the
     * underlying RPC channel.
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.google.pubsub.v1.StreamingPullRequest> streamingPull(
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.StreamingPullResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getStreamingPullMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies the `PushConfig` for a specified subscription.
     * This may be used to change a push subscription to a pull one (signified by
     * an empty `PushConfig`) or vice versa, or change the endpoint URL and other
     * attributes of a push subscription. Messages will accumulate for delivery
     * continuously through the call regardless of changes to the `PushConfig`.
     * </pre>
     */
    default void modifyPushConfig(
        com.google.pubsub.v1.ModifyPushConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getModifyPushConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the configuration details of a snapshot. Snapshots are used in
     * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations,
     * which allow you to manage message acknowledgments in bulk. That is, you can
     * set the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * </pre>
     */
    default void getSnapshot(
        com.google.pubsub.v1.GetSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Snapshot> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSnapshotMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing snapshots. Snapshots are used in [Seek](
     * https://cloud.google.com/pubsub/docs/replay-overview) operations, which
     * allow you to manage message acknowledgments in bulk. That is, you can set
     * the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * </pre>
     */
    default void listSnapshots(
        com.google.pubsub.v1.ListSnapshotsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListSnapshotsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSnapshotsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a snapshot from the requested subscription. Snapshots are used in
     * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations,
     * which allow you to manage message acknowledgments in bulk. That is, you can
     * set the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * If the snapshot already exists, returns `ALREADY_EXISTS`.
     * If the requested subscription doesn't exist, returns `NOT_FOUND`.
     * If the backlog in the subscription is too old -- and the resulting snapshot
     * would expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned.
     * See also the `Snapshot.expire_time` field. If the name is not provided in
     * the request, the server will assign a random
     * name for this snapshot on the same project as the subscription, conforming
     * to the [resource name format]
     * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). The
     * generated name is populated in the returned Snapshot object. Note that for
     * REST API requests, you must specify a name in the request.
     * </pre>
     */
    default void createSnapshot(
        com.google.pubsub.v1.CreateSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Snapshot> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSnapshotMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing snapshot by updating the fields specified in the update
     * mask. Snapshots are used in
     * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations,
     * which allow you to manage message acknowledgments in bulk. That is, you can
     * set the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * </pre>
     */
    default void updateSnapshot(
        com.google.pubsub.v1.UpdateSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Snapshot> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSnapshotMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes an existing snapshot. Snapshots are used in [Seek]
     * (https://cloud.google.com/pubsub/docs/replay-overview) operations, which
     * allow you to manage message acknowledgments in bulk. That is, you can set
     * the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * When the snapshot is deleted, all messages retained in the snapshot
     * are immediately dropped. After a snapshot is deleted, a new one may be
     * created with the same name, but the new one has no association with the old
     * snapshot or its subscription, unless the same subscription is specified.
     * </pre>
     */
    default void deleteSnapshot(
        com.google.pubsub.v1.DeleteSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSnapshotMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Seeks an existing subscription to a point in time or to a given snapshot,
     * whichever is provided in the request. Snapshots are used in [Seek]
     * (https://cloud.google.com/pubsub/docs/replay-overview) operations, which
     * allow you to manage message acknowledgments in bulk. That is, you can set
     * the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot. Note that both the subscription and the
     * snapshot must be on the same topic.
     * </pre>
     */
    default void seek(
        com.google.pubsub.v1.SeekRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.SeekResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSeekMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Subscriber.
   *
   * <pre>
   * The service that an application uses to manipulate subscriptions and to
   * consume messages from a subscription via the `Pull` method or by
   * establishing a bi-directional stream using the `StreamingPull` method.
   * </pre>
   */
  public abstract static class SubscriberImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SubscriberGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Subscriber.
   *
   * <pre>
   * The service that an application uses to manipulate subscriptions and to
   * consume messages from a subscription via the `Pull` method or by
   * establishing a bi-directional stream using the `StreamingPull` method.
   * </pre>
   */
  public static final class SubscriberStub extends io.grpc.stub.AbstractAsyncStub<SubscriberStub> {
    private SubscriberStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscriberStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscriberStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a subscription to a given topic. See the [resource name rules]
     * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
     * If the subscription already exists, returns `ALREADY_EXISTS`.
     * If the corresponding topic doesn't exist, returns `NOT_FOUND`.
     * If the name is not provided in the request, the server will assign a random
     * name for this subscription on the same project as the topic, conforming
     * to the [resource name format]
     * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). The
     * generated name is populated in the returned Subscription object. Note that
     * for REST API requests, you must specify a name in the request.
     * </pre>
     */
    public void createSubscription(
        com.google.pubsub.v1.Subscription request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Subscription> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the configuration details of a subscription.
     * </pre>
     */
    public void getSubscription(
        com.google.pubsub.v1.GetSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Subscription> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing subscription by updating the fields specified in the
     * update mask. Note that certain properties of a subscription, such as its
     * topic, are not modifiable.
     * </pre>
     */
    public void updateSubscription(
        com.google.pubsub.v1.UpdateSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Subscription> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists matching subscriptions.
     * </pre>
     */
    public void listSubscriptions(
        com.google.pubsub.v1.ListSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListSubscriptionsResponse>
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
     * Deletes an existing subscription. All messages retained in the subscription
     * are immediately dropped. Calls to `Pull` after deletion will return
     * `NOT_FOUND`. After a subscription is deleted, a new one may be created with
     * the same name, but the new one has no association with the old
     * subscription or its topic unless the same topic is specified.
     * </pre>
     */
    public void deleteSubscription(
        com.google.pubsub.v1.DeleteSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies the ack deadline for a specific message. This method is useful
     * to indicate that more time is needed to process a message by the
     * subscriber, or to make the message available for redelivery if the
     * processing was interrupted. Note that this does not modify the
     * subscription-level `ackDeadlineSeconds` used for subsequent messages.
     * </pre>
     */
    public void modifyAckDeadline(
        com.google.pubsub.v1.ModifyAckDeadlineRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getModifyAckDeadlineMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Acknowledges the messages associated with the `ack_ids` in the
     * `AcknowledgeRequest`. The Pub/Sub system can remove the relevant messages
     * from the subscription.
     * Acknowledging a message whose ack deadline has expired may succeed,
     * but such a message may be redelivered later. Acknowledging a message more
     * than once will not result in an error.
     * </pre>
     */
    public void acknowledge(
        com.google.pubsub.v1.AcknowledgeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAcknowledgeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pulls messages from the server.
     * </pre>
     */
    public void pull(
        com.google.pubsub.v1.PullRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.PullResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPullMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Establishes a stream with the server, which sends messages down to the
     * client. The client streams acknowledgments and ack deadline modifications
     * back to the server. The server will close the stream and return the status
     * on any error. The server may close the stream with status `UNAVAILABLE` to
     * reassign server-side resources, in which case, the client should
     * re-establish the stream. Flow control can be achieved by configuring the
     * underlying RPC channel.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.pubsub.v1.StreamingPullRequest> streamingPull(
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.StreamingPullResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamingPullMethod(), getCallOptions()), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Modifies the `PushConfig` for a specified subscription.
     * This may be used to change a push subscription to a pull one (signified by
     * an empty `PushConfig`) or vice versa, or change the endpoint URL and other
     * attributes of a push subscription. Messages will accumulate for delivery
     * continuously through the call regardless of changes to the `PushConfig`.
     * </pre>
     */
    public void modifyPushConfig(
        com.google.pubsub.v1.ModifyPushConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getModifyPushConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the configuration details of a snapshot. Snapshots are used in
     * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations,
     * which allow you to manage message acknowledgments in bulk. That is, you can
     * set the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * </pre>
     */
    public void getSnapshot(
        com.google.pubsub.v1.GetSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Snapshot> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSnapshotMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing snapshots. Snapshots are used in [Seek](
     * https://cloud.google.com/pubsub/docs/replay-overview) operations, which
     * allow you to manage message acknowledgments in bulk. That is, you can set
     * the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * </pre>
     */
    public void listSnapshots(
        com.google.pubsub.v1.ListSnapshotsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListSnapshotsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSnapshotsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a snapshot from the requested subscription. Snapshots are used in
     * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations,
     * which allow you to manage message acknowledgments in bulk. That is, you can
     * set the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * If the snapshot already exists, returns `ALREADY_EXISTS`.
     * If the requested subscription doesn't exist, returns `NOT_FOUND`.
     * If the backlog in the subscription is too old -- and the resulting snapshot
     * would expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned.
     * See also the `Snapshot.expire_time` field. If the name is not provided in
     * the request, the server will assign a random
     * name for this snapshot on the same project as the subscription, conforming
     * to the [resource name format]
     * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). The
     * generated name is populated in the returned Snapshot object. Note that for
     * REST API requests, you must specify a name in the request.
     * </pre>
     */
    public void createSnapshot(
        com.google.pubsub.v1.CreateSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Snapshot> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSnapshotMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing snapshot by updating the fields specified in the update
     * mask. Snapshots are used in
     * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations,
     * which allow you to manage message acknowledgments in bulk. That is, you can
     * set the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * </pre>
     */
    public void updateSnapshot(
        com.google.pubsub.v1.UpdateSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Snapshot> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSnapshotMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes an existing snapshot. Snapshots are used in [Seek]
     * (https://cloud.google.com/pubsub/docs/replay-overview) operations, which
     * allow you to manage message acknowledgments in bulk. That is, you can set
     * the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * When the snapshot is deleted, all messages retained in the snapshot
     * are immediately dropped. After a snapshot is deleted, a new one may be
     * created with the same name, but the new one has no association with the old
     * snapshot or its subscription, unless the same subscription is specified.
     * </pre>
     */
    public void deleteSnapshot(
        com.google.pubsub.v1.DeleteSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSnapshotMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Seeks an existing subscription to a point in time or to a given snapshot,
     * whichever is provided in the request. Snapshots are used in [Seek]
     * (https://cloud.google.com/pubsub/docs/replay-overview) operations, which
     * allow you to manage message acknowledgments in bulk. That is, you can set
     * the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot. Note that both the subscription and the
     * snapshot must be on the same topic.
     * </pre>
     */
    public void seek(
        com.google.pubsub.v1.SeekRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.SeekResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSeekMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Subscriber.
   *
   * <pre>
   * The service that an application uses to manipulate subscriptions and to
   * consume messages from a subscription via the `Pull` method or by
   * establishing a bi-directional stream using the `StreamingPull` method.
   * </pre>
   */
  public static final class SubscriberBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SubscriberBlockingV2Stub> {
    private SubscriberBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscriberBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscriberBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a subscription to a given topic. See the [resource name rules]
     * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
     * If the subscription already exists, returns `ALREADY_EXISTS`.
     * If the corresponding topic doesn't exist, returns `NOT_FOUND`.
     * If the name is not provided in the request, the server will assign a random
     * name for this subscription on the same project as the topic, conforming
     * to the [resource name format]
     * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). The
     * generated name is populated in the returned Subscription object. Note that
     * for REST API requests, you must specify a name in the request.
     * </pre>
     */
    public com.google.pubsub.v1.Subscription createSubscription(
        com.google.pubsub.v1.Subscription request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the configuration details of a subscription.
     * </pre>
     */
    public com.google.pubsub.v1.Subscription getSubscription(
        com.google.pubsub.v1.GetSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing subscription by updating the fields specified in the
     * update mask. Note that certain properties of a subscription, such as its
     * topic, are not modifiable.
     * </pre>
     */
    public com.google.pubsub.v1.Subscription updateSubscription(
        com.google.pubsub.v1.UpdateSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists matching subscriptions.
     * </pre>
     */
    public com.google.pubsub.v1.ListSubscriptionsResponse listSubscriptions(
        com.google.pubsub.v1.ListSubscriptionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSubscriptionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing subscription. All messages retained in the subscription
     * are immediately dropped. Calls to `Pull` after deletion will return
     * `NOT_FOUND`. After a subscription is deleted, a new one may be created with
     * the same name, but the new one has no association with the old
     * subscription or its topic unless the same topic is specified.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSubscription(
        com.google.pubsub.v1.DeleteSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies the ack deadline for a specific message. This method is useful
     * to indicate that more time is needed to process a message by the
     * subscriber, or to make the message available for redelivery if the
     * processing was interrupted. Note that this does not modify the
     * subscription-level `ackDeadlineSeconds` used for subsequent messages.
     * </pre>
     */
    public com.google.protobuf.Empty modifyAckDeadline(
        com.google.pubsub.v1.ModifyAckDeadlineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModifyAckDeadlineMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Acknowledges the messages associated with the `ack_ids` in the
     * `AcknowledgeRequest`. The Pub/Sub system can remove the relevant messages
     * from the subscription.
     * Acknowledging a message whose ack deadline has expired may succeed,
     * but such a message may be redelivered later. Acknowledging a message more
     * than once will not result in an error.
     * </pre>
     */
    public com.google.protobuf.Empty acknowledge(com.google.pubsub.v1.AcknowledgeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAcknowledgeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Pulls messages from the server.
     * </pre>
     */
    public com.google.pubsub.v1.PullResponse pull(com.google.pubsub.v1.PullRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPullMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Establishes a stream with the server, which sends messages down to the
     * client. The client streams acknowledgments and ack deadline modifications
     * back to the server. The server will close the stream and return the status
     * on any error. The server may close the stream with status `UNAVAILABLE` to
     * reassign server-side resources, in which case, the client should
     * re-establish the stream. Flow control can be achieved by configuring the
     * underlying RPC channel.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<
            com.google.pubsub.v1.StreamingPullRequest, com.google.pubsub.v1.StreamingPullResponse>
        streamingPull() {
      return io.grpc.stub.ClientCalls.blockingBidiStreamingCall(
          getChannel(), getStreamingPullMethod(), getCallOptions());
    }

    /**
     *
     *
     * <pre>
     * Modifies the `PushConfig` for a specified subscription.
     * This may be used to change a push subscription to a pull one (signified by
     * an empty `PushConfig`) or vice versa, or change the endpoint URL and other
     * attributes of a push subscription. Messages will accumulate for delivery
     * continuously through the call regardless of changes to the `PushConfig`.
     * </pre>
     */
    public com.google.protobuf.Empty modifyPushConfig(
        com.google.pubsub.v1.ModifyPushConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModifyPushConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the configuration details of a snapshot. Snapshots are used in
     * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations,
     * which allow you to manage message acknowledgments in bulk. That is, you can
     * set the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * </pre>
     */
    public com.google.pubsub.v1.Snapshot getSnapshot(
        com.google.pubsub.v1.GetSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSnapshotMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing snapshots. Snapshots are used in [Seek](
     * https://cloud.google.com/pubsub/docs/replay-overview) operations, which
     * allow you to manage message acknowledgments in bulk. That is, you can set
     * the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * </pre>
     */
    public com.google.pubsub.v1.ListSnapshotsResponse listSnapshots(
        com.google.pubsub.v1.ListSnapshotsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSnapshotsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a snapshot from the requested subscription. Snapshots are used in
     * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations,
     * which allow you to manage message acknowledgments in bulk. That is, you can
     * set the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * If the snapshot already exists, returns `ALREADY_EXISTS`.
     * If the requested subscription doesn't exist, returns `NOT_FOUND`.
     * If the backlog in the subscription is too old -- and the resulting snapshot
     * would expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned.
     * See also the `Snapshot.expire_time` field. If the name is not provided in
     * the request, the server will assign a random
     * name for this snapshot on the same project as the subscription, conforming
     * to the [resource name format]
     * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). The
     * generated name is populated in the returned Snapshot object. Note that for
     * REST API requests, you must specify a name in the request.
     * </pre>
     */
    public com.google.pubsub.v1.Snapshot createSnapshot(
        com.google.pubsub.v1.CreateSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSnapshotMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing snapshot by updating the fields specified in the update
     * mask. Snapshots are used in
     * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations,
     * which allow you to manage message acknowledgments in bulk. That is, you can
     * set the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * </pre>
     */
    public com.google.pubsub.v1.Snapshot updateSnapshot(
        com.google.pubsub.v1.UpdateSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSnapshotMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes an existing snapshot. Snapshots are used in [Seek]
     * (https://cloud.google.com/pubsub/docs/replay-overview) operations, which
     * allow you to manage message acknowledgments in bulk. That is, you can set
     * the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * When the snapshot is deleted, all messages retained in the snapshot
     * are immediately dropped. After a snapshot is deleted, a new one may be
     * created with the same name, but the new one has no association with the old
     * snapshot or its subscription, unless the same subscription is specified.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSnapshot(
        com.google.pubsub.v1.DeleteSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSnapshotMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Seeks an existing subscription to a point in time or to a given snapshot,
     * whichever is provided in the request. Snapshots are used in [Seek]
     * (https://cloud.google.com/pubsub/docs/replay-overview) operations, which
     * allow you to manage message acknowledgments in bulk. That is, you can set
     * the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot. Note that both the subscription and the
     * snapshot must be on the same topic.
     * </pre>
     */
    public com.google.pubsub.v1.SeekResponse seek(com.google.pubsub.v1.SeekRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSeekMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Subscriber.
   *
   * <pre>
   * The service that an application uses to manipulate subscriptions and to
   * consume messages from a subscription via the `Pull` method or by
   * establishing a bi-directional stream using the `StreamingPull` method.
   * </pre>
   */
  public static final class SubscriberBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SubscriberBlockingStub> {
    private SubscriberBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscriberBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscriberBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a subscription to a given topic. See the [resource name rules]
     * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
     * If the subscription already exists, returns `ALREADY_EXISTS`.
     * If the corresponding topic doesn't exist, returns `NOT_FOUND`.
     * If the name is not provided in the request, the server will assign a random
     * name for this subscription on the same project as the topic, conforming
     * to the [resource name format]
     * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). The
     * generated name is populated in the returned Subscription object. Note that
     * for REST API requests, you must specify a name in the request.
     * </pre>
     */
    public com.google.pubsub.v1.Subscription createSubscription(
        com.google.pubsub.v1.Subscription request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the configuration details of a subscription.
     * </pre>
     */
    public com.google.pubsub.v1.Subscription getSubscription(
        com.google.pubsub.v1.GetSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing subscription by updating the fields specified in the
     * update mask. Note that certain properties of a subscription, such as its
     * topic, are not modifiable.
     * </pre>
     */
    public com.google.pubsub.v1.Subscription updateSubscription(
        com.google.pubsub.v1.UpdateSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists matching subscriptions.
     * </pre>
     */
    public com.google.pubsub.v1.ListSubscriptionsResponse listSubscriptions(
        com.google.pubsub.v1.ListSubscriptionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSubscriptionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing subscription. All messages retained in the subscription
     * are immediately dropped. Calls to `Pull` after deletion will return
     * `NOT_FOUND`. After a subscription is deleted, a new one may be created with
     * the same name, but the new one has no association with the old
     * subscription or its topic unless the same topic is specified.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSubscription(
        com.google.pubsub.v1.DeleteSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies the ack deadline for a specific message. This method is useful
     * to indicate that more time is needed to process a message by the
     * subscriber, or to make the message available for redelivery if the
     * processing was interrupted. Note that this does not modify the
     * subscription-level `ackDeadlineSeconds` used for subsequent messages.
     * </pre>
     */
    public com.google.protobuf.Empty modifyAckDeadline(
        com.google.pubsub.v1.ModifyAckDeadlineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModifyAckDeadlineMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Acknowledges the messages associated with the `ack_ids` in the
     * `AcknowledgeRequest`. The Pub/Sub system can remove the relevant messages
     * from the subscription.
     * Acknowledging a message whose ack deadline has expired may succeed,
     * but such a message may be redelivered later. Acknowledging a message more
     * than once will not result in an error.
     * </pre>
     */
    public com.google.protobuf.Empty acknowledge(com.google.pubsub.v1.AcknowledgeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAcknowledgeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Pulls messages from the server.
     * </pre>
     */
    public com.google.pubsub.v1.PullResponse pull(com.google.pubsub.v1.PullRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPullMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies the `PushConfig` for a specified subscription.
     * This may be used to change a push subscription to a pull one (signified by
     * an empty `PushConfig`) or vice versa, or change the endpoint URL and other
     * attributes of a push subscription. Messages will accumulate for delivery
     * continuously through the call regardless of changes to the `PushConfig`.
     * </pre>
     */
    public com.google.protobuf.Empty modifyPushConfig(
        com.google.pubsub.v1.ModifyPushConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModifyPushConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the configuration details of a snapshot. Snapshots are used in
     * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations,
     * which allow you to manage message acknowledgments in bulk. That is, you can
     * set the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * </pre>
     */
    public com.google.pubsub.v1.Snapshot getSnapshot(
        com.google.pubsub.v1.GetSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSnapshotMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing snapshots. Snapshots are used in [Seek](
     * https://cloud.google.com/pubsub/docs/replay-overview) operations, which
     * allow you to manage message acknowledgments in bulk. That is, you can set
     * the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * </pre>
     */
    public com.google.pubsub.v1.ListSnapshotsResponse listSnapshots(
        com.google.pubsub.v1.ListSnapshotsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSnapshotsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a snapshot from the requested subscription. Snapshots are used in
     * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations,
     * which allow you to manage message acknowledgments in bulk. That is, you can
     * set the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * If the snapshot already exists, returns `ALREADY_EXISTS`.
     * If the requested subscription doesn't exist, returns `NOT_FOUND`.
     * If the backlog in the subscription is too old -- and the resulting snapshot
     * would expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned.
     * See also the `Snapshot.expire_time` field. If the name is not provided in
     * the request, the server will assign a random
     * name for this snapshot on the same project as the subscription, conforming
     * to the [resource name format]
     * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). The
     * generated name is populated in the returned Snapshot object. Note that for
     * REST API requests, you must specify a name in the request.
     * </pre>
     */
    public com.google.pubsub.v1.Snapshot createSnapshot(
        com.google.pubsub.v1.CreateSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSnapshotMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing snapshot by updating the fields specified in the update
     * mask. Snapshots are used in
     * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations,
     * which allow you to manage message acknowledgments in bulk. That is, you can
     * set the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * </pre>
     */
    public com.google.pubsub.v1.Snapshot updateSnapshot(
        com.google.pubsub.v1.UpdateSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSnapshotMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes an existing snapshot. Snapshots are used in [Seek]
     * (https://cloud.google.com/pubsub/docs/replay-overview) operations, which
     * allow you to manage message acknowledgments in bulk. That is, you can set
     * the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * When the snapshot is deleted, all messages retained in the snapshot
     * are immediately dropped. After a snapshot is deleted, a new one may be
     * created with the same name, but the new one has no association with the old
     * snapshot or its subscription, unless the same subscription is specified.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSnapshot(
        com.google.pubsub.v1.DeleteSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSnapshotMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Seeks an existing subscription to a point in time or to a given snapshot,
     * whichever is provided in the request. Snapshots are used in [Seek]
     * (https://cloud.google.com/pubsub/docs/replay-overview) operations, which
     * allow you to manage message acknowledgments in bulk. That is, you can set
     * the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot. Note that both the subscription and the
     * snapshot must be on the same topic.
     * </pre>
     */
    public com.google.pubsub.v1.SeekResponse seek(com.google.pubsub.v1.SeekRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSeekMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Subscriber.
   *
   * <pre>
   * The service that an application uses to manipulate subscriptions and to
   * consume messages from a subscription via the `Pull` method or by
   * establishing a bi-directional stream using the `StreamingPull` method.
   * </pre>
   */
  public static final class SubscriberFutureStub
      extends io.grpc.stub.AbstractFutureStub<SubscriberFutureStub> {
    private SubscriberFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscriberFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscriberFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a subscription to a given topic. See the [resource name rules]
     * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
     * If the subscription already exists, returns `ALREADY_EXISTS`.
     * If the corresponding topic doesn't exist, returns `NOT_FOUND`.
     * If the name is not provided in the request, the server will assign a random
     * name for this subscription on the same project as the topic, conforming
     * to the [resource name format]
     * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). The
     * generated name is populated in the returned Subscription object. Note that
     * for REST API requests, you must specify a name in the request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Subscription>
        createSubscription(com.google.pubsub.v1.Subscription request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the configuration details of a subscription.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Subscription>
        getSubscription(com.google.pubsub.v1.GetSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing subscription by updating the fields specified in the
     * update mask. Note that certain properties of a subscription, such as its
     * topic, are not modifiable.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Subscription>
        updateSubscription(com.google.pubsub.v1.UpdateSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists matching subscriptions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.pubsub.v1.ListSubscriptionsResponse>
        listSubscriptions(com.google.pubsub.v1.ListSubscriptionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSubscriptionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing subscription. All messages retained in the subscription
     * are immediately dropped. Calls to `Pull` after deletion will return
     * `NOT_FOUND`. After a subscription is deleted, a new one may be created with
     * the same name, but the new one has no association with the old
     * subscription or its topic unless the same topic is specified.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSubscription(com.google.pubsub.v1.DeleteSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies the ack deadline for a specific message. This method is useful
     * to indicate that more time is needed to process a message by the
     * subscriber, or to make the message available for redelivery if the
     * processing was interrupted. Note that this does not modify the
     * subscription-level `ackDeadlineSeconds` used for subsequent messages.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        modifyAckDeadline(com.google.pubsub.v1.ModifyAckDeadlineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getModifyAckDeadlineMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Acknowledges the messages associated with the `ack_ids` in the
     * `AcknowledgeRequest`. The Pub/Sub system can remove the relevant messages
     * from the subscription.
     * Acknowledging a message whose ack deadline has expired may succeed,
     * but such a message may be redelivered later. Acknowledging a message more
     * than once will not result in an error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        acknowledge(com.google.pubsub.v1.AcknowledgeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAcknowledgeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Pulls messages from the server.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.PullResponse>
        pull(com.google.pubsub.v1.PullRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPullMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Modifies the `PushConfig` for a specified subscription.
     * This may be used to change a push subscription to a pull one (signified by
     * an empty `PushConfig`) or vice versa, or change the endpoint URL and other
     * attributes of a push subscription. Messages will accumulate for delivery
     * continuously through the call regardless of changes to the `PushConfig`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        modifyPushConfig(com.google.pubsub.v1.ModifyPushConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getModifyPushConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the configuration details of a snapshot. Snapshots are used in
     * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations,
     * which allow you to manage message acknowledgments in bulk. That is, you can
     * set the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Snapshot>
        getSnapshot(com.google.pubsub.v1.GetSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSnapshotMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing snapshots. Snapshots are used in [Seek](
     * https://cloud.google.com/pubsub/docs/replay-overview) operations, which
     * allow you to manage message acknowledgments in bulk. That is, you can set
     * the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.pubsub.v1.ListSnapshotsResponse>
        listSnapshots(com.google.pubsub.v1.ListSnapshotsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSnapshotsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a snapshot from the requested subscription. Snapshots are used in
     * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations,
     * which allow you to manage message acknowledgments in bulk. That is, you can
     * set the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * If the snapshot already exists, returns `ALREADY_EXISTS`.
     * If the requested subscription doesn't exist, returns `NOT_FOUND`.
     * If the backlog in the subscription is too old -- and the resulting snapshot
     * would expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned.
     * See also the `Snapshot.expire_time` field. If the name is not provided in
     * the request, the server will assign a random
     * name for this snapshot on the same project as the subscription, conforming
     * to the [resource name format]
     * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). The
     * generated name is populated in the returned Snapshot object. Note that for
     * REST API requests, you must specify a name in the request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Snapshot>
        createSnapshot(com.google.pubsub.v1.CreateSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSnapshotMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing snapshot by updating the fields specified in the update
     * mask. Snapshots are used in
     * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations,
     * which allow you to manage message acknowledgments in bulk. That is, you can
     * set the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Snapshot>
        updateSnapshot(com.google.pubsub.v1.UpdateSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSnapshotMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes an existing snapshot. Snapshots are used in [Seek]
     * (https://cloud.google.com/pubsub/docs/replay-overview) operations, which
     * allow you to manage message acknowledgments in bulk. That is, you can set
     * the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * When the snapshot is deleted, all messages retained in the snapshot
     * are immediately dropped. After a snapshot is deleted, a new one may be
     * created with the same name, but the new one has no association with the old
     * snapshot or its subscription, unless the same subscription is specified.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSnapshot(com.google.pubsub.v1.DeleteSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSnapshotMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Seeks an existing subscription to a point in time or to a given snapshot,
     * whichever is provided in the request. Snapshots are used in [Seek]
     * (https://cloud.google.com/pubsub/docs/replay-overview) operations, which
     * allow you to manage message acknowledgments in bulk. That is, you can set
     * the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot. Note that both the subscription and the
     * snapshot must be on the same topic.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.SeekResponse>
        seek(com.google.pubsub.v1.SeekRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSeekMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SUBSCRIPTION = 0;
  private static final int METHODID_GET_SUBSCRIPTION = 1;
  private static final int METHODID_UPDATE_SUBSCRIPTION = 2;
  private static final int METHODID_LIST_SUBSCRIPTIONS = 3;
  private static final int METHODID_DELETE_SUBSCRIPTION = 4;
  private static final int METHODID_MODIFY_ACK_DEADLINE = 5;
  private static final int METHODID_ACKNOWLEDGE = 6;
  private static final int METHODID_PULL = 7;
  private static final int METHODID_MODIFY_PUSH_CONFIG = 8;
  private static final int METHODID_GET_SNAPSHOT = 9;
  private static final int METHODID_LIST_SNAPSHOTS = 10;
  private static final int METHODID_CREATE_SNAPSHOT = 11;
  private static final int METHODID_UPDATE_SNAPSHOT = 12;
  private static final int METHODID_DELETE_SNAPSHOT = 13;
  private static final int METHODID_SEEK = 14;
  private static final int METHODID_STREAMING_PULL = 15;

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
              (com.google.pubsub.v1.Subscription) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.Subscription>) responseObserver);
          break;
        case METHODID_GET_SUBSCRIPTION:
          serviceImpl.getSubscription(
              (com.google.pubsub.v1.GetSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.Subscription>) responseObserver);
          break;
        case METHODID_UPDATE_SUBSCRIPTION:
          serviceImpl.updateSubscription(
              (com.google.pubsub.v1.UpdateSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.Subscription>) responseObserver);
          break;
        case METHODID_LIST_SUBSCRIPTIONS:
          serviceImpl.listSubscriptions(
              (com.google.pubsub.v1.ListSubscriptionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListSubscriptionsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_SUBSCRIPTION:
          serviceImpl.deleteSubscription(
              (com.google.pubsub.v1.DeleteSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_MODIFY_ACK_DEADLINE:
          serviceImpl.modifyAckDeadline(
              (com.google.pubsub.v1.ModifyAckDeadlineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_ACKNOWLEDGE:
          serviceImpl.acknowledge(
              (com.google.pubsub.v1.AcknowledgeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_PULL:
          serviceImpl.pull(
              (com.google.pubsub.v1.PullRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.PullResponse>) responseObserver);
          break;
        case METHODID_MODIFY_PUSH_CONFIG:
          serviceImpl.modifyPushConfig(
              (com.google.pubsub.v1.ModifyPushConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_SNAPSHOT:
          serviceImpl.getSnapshot(
              (com.google.pubsub.v1.GetSnapshotRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.Snapshot>) responseObserver);
          break;
        case METHODID_LIST_SNAPSHOTS:
          serviceImpl.listSnapshots(
              (com.google.pubsub.v1.ListSnapshotsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListSnapshotsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_SNAPSHOT:
          serviceImpl.createSnapshot(
              (com.google.pubsub.v1.CreateSnapshotRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.Snapshot>) responseObserver);
          break;
        case METHODID_UPDATE_SNAPSHOT:
          serviceImpl.updateSnapshot(
              (com.google.pubsub.v1.UpdateSnapshotRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.Snapshot>) responseObserver);
          break;
        case METHODID_DELETE_SNAPSHOT:
          serviceImpl.deleteSnapshot(
              (com.google.pubsub.v1.DeleteSnapshotRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SEEK:
          serviceImpl.seek(
              (com.google.pubsub.v1.SeekRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.SeekResponse>) responseObserver);
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
        case METHODID_STREAMING_PULL:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.streamingPull(
                  (io.grpc.stub.StreamObserver<com.google.pubsub.v1.StreamingPullResponse>)
                      responseObserver);
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
                    com.google.pubsub.v1.Subscription, com.google.pubsub.v1.Subscription>(
                    service, METHODID_CREATE_SUBSCRIPTION)))
        .addMethod(
            getGetSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.GetSubscriptionRequest, com.google.pubsub.v1.Subscription>(
                    service, METHODID_GET_SUBSCRIPTION)))
        .addMethod(
            getUpdateSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.UpdateSubscriptionRequest,
                    com.google.pubsub.v1.Subscription>(service, METHODID_UPDATE_SUBSCRIPTION)))
        .addMethod(
            getListSubscriptionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.ListSubscriptionsRequest,
                    com.google.pubsub.v1.ListSubscriptionsResponse>(
                    service, METHODID_LIST_SUBSCRIPTIONS)))
        .addMethod(
            getDeleteSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.DeleteSubscriptionRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_SUBSCRIPTION)))
        .addMethod(
            getModifyAckDeadlineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.ModifyAckDeadlineRequest, com.google.protobuf.Empty>(
                    service, METHODID_MODIFY_ACK_DEADLINE)))
        .addMethod(
            getAcknowledgeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.AcknowledgeRequest, com.google.protobuf.Empty>(
                    service, METHODID_ACKNOWLEDGE)))
        .addMethod(
            getPullMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.PullRequest, com.google.pubsub.v1.PullResponse>(
                    service, METHODID_PULL)))
        .addMethod(
            getStreamingPullMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                new MethodHandlers<
                    com.google.pubsub.v1.StreamingPullRequest,
                    com.google.pubsub.v1.StreamingPullResponse>(service, METHODID_STREAMING_PULL)))
        .addMethod(
            getModifyPushConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.ModifyPushConfigRequest, com.google.protobuf.Empty>(
                    service, METHODID_MODIFY_PUSH_CONFIG)))
        .addMethod(
            getGetSnapshotMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.GetSnapshotRequest, com.google.pubsub.v1.Snapshot>(
                    service, METHODID_GET_SNAPSHOT)))
        .addMethod(
            getListSnapshotsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.ListSnapshotsRequest,
                    com.google.pubsub.v1.ListSnapshotsResponse>(service, METHODID_LIST_SNAPSHOTS)))
        .addMethod(
            getCreateSnapshotMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.CreateSnapshotRequest, com.google.pubsub.v1.Snapshot>(
                    service, METHODID_CREATE_SNAPSHOT)))
        .addMethod(
            getUpdateSnapshotMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.UpdateSnapshotRequest, com.google.pubsub.v1.Snapshot>(
                    service, METHODID_UPDATE_SNAPSHOT)))
        .addMethod(
            getDeleteSnapshotMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.DeleteSnapshotRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_SNAPSHOT)))
        .addMethod(
            getSeekMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.SeekRequest, com.google.pubsub.v1.SeekResponse>(
                    service, METHODID_SEEK)))
        .build();
  }

  private abstract static class SubscriberBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SubscriberBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.pubsub.v1.PubsubProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Subscriber");
    }
  }

  private static final class SubscriberFileDescriptorSupplier
      extends SubscriberBaseDescriptorSupplier {
    SubscriberFileDescriptorSupplier() {}
  }

  private static final class SubscriberMethodDescriptorSupplier
      extends SubscriberBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SubscriberMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SubscriberGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SubscriberFileDescriptorSupplier())
                      .addMethod(getCreateSubscriptionMethod())
                      .addMethod(getGetSubscriptionMethod())
                      .addMethod(getUpdateSubscriptionMethod())
                      .addMethod(getListSubscriptionsMethod())
                      .addMethod(getDeleteSubscriptionMethod())
                      .addMethod(getModifyAckDeadlineMethod())
                      .addMethod(getAcknowledgeMethod())
                      .addMethod(getPullMethod())
                      .addMethod(getStreamingPullMethod())
                      .addMethod(getModifyPushConfigMethod())
                      .addMethod(getGetSnapshotMethod())
                      .addMethod(getListSnapshotsMethod())
                      .addMethod(getCreateSnapshotMethod())
                      .addMethod(getUpdateSnapshotMethod())
                      .addMethod(getDeleteSnapshotMethod())
                      .addMethod(getSeekMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
