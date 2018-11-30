package com.google.pubsub.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

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
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/pubsub/v1/pubsub.proto")
public final class SubscriberGrpc {

  private SubscriberGrpc() {}

  public static final String SERVICE_NAME = "google.pubsub.v1.Subscriber";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateSubscriptionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.pubsub.v1.Subscription, com.google.pubsub.v1.Subscription>
      METHOD_CREATE_SUBSCRIPTION = getCreateSubscriptionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.Subscription, com.google.pubsub.v1.Subscription>
      getCreateSubscriptionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.Subscription, com.google.pubsub.v1.Subscription>
      getCreateSubscriptionMethod() {
    return getCreateSubscriptionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.Subscription, com.google.pubsub.v1.Subscription>
      getCreateSubscriptionMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.pubsub.v1.Subscriber", "CreateSubscription"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetSubscriptionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.pubsub.v1.GetSubscriptionRequest, com.google.pubsub.v1.Subscription>
      METHOD_GET_SUBSCRIPTION = getGetSubscriptionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.GetSubscriptionRequest, com.google.pubsub.v1.Subscription>
      getGetSubscriptionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.GetSubscriptionRequest, com.google.pubsub.v1.Subscription>
      getGetSubscriptionMethod() {
    return getGetSubscriptionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.GetSubscriptionRequest, com.google.pubsub.v1.Subscription>
      getGetSubscriptionMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.pubsub.v1.Subscriber", "GetSubscription"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateSubscriptionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.pubsub.v1.UpdateSubscriptionRequest, com.google.pubsub.v1.Subscription>
      METHOD_UPDATE_SUBSCRIPTION = getUpdateSubscriptionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.UpdateSubscriptionRequest, com.google.pubsub.v1.Subscription>
      getUpdateSubscriptionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.UpdateSubscriptionRequest, com.google.pubsub.v1.Subscription>
      getUpdateSubscriptionMethod() {
    return getUpdateSubscriptionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.UpdateSubscriptionRequest, com.google.pubsub.v1.Subscription>
      getUpdateSubscriptionMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.pubsub.v1.Subscriber", "UpdateSubscription"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListSubscriptionsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListSubscriptionsRequest,
          com.google.pubsub.v1.ListSubscriptionsResponse>
      METHOD_LIST_SUBSCRIPTIONS = getListSubscriptionsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListSubscriptionsRequest,
          com.google.pubsub.v1.ListSubscriptionsResponse>
      getListSubscriptionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListSubscriptionsRequest,
          com.google.pubsub.v1.ListSubscriptionsResponse>
      getListSubscriptionsMethod() {
    return getListSubscriptionsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListSubscriptionsRequest,
          com.google.pubsub.v1.ListSubscriptionsResponse>
      getListSubscriptionsMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.pubsub.v1.Subscriber", "ListSubscriptions"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteSubscriptionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.pubsub.v1.DeleteSubscriptionRequest, com.google.protobuf.Empty>
      METHOD_DELETE_SUBSCRIPTION = getDeleteSubscriptionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.DeleteSubscriptionRequest, com.google.protobuf.Empty>
      getDeleteSubscriptionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.DeleteSubscriptionRequest, com.google.protobuf.Empty>
      getDeleteSubscriptionMethod() {
    return getDeleteSubscriptionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.DeleteSubscriptionRequest, com.google.protobuf.Empty>
      getDeleteSubscriptionMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.pubsub.v1.Subscriber", "DeleteSubscription"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getModifyAckDeadlineMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ModifyAckDeadlineRequest, com.google.protobuf.Empty>
      METHOD_MODIFY_ACK_DEADLINE = getModifyAckDeadlineMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ModifyAckDeadlineRequest, com.google.protobuf.Empty>
      getModifyAckDeadlineMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ModifyAckDeadlineRequest, com.google.protobuf.Empty>
      getModifyAckDeadlineMethod() {
    return getModifyAckDeadlineMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ModifyAckDeadlineRequest, com.google.protobuf.Empty>
      getModifyAckDeadlineMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.pubsub.v1.Subscriber", "ModifyAckDeadline"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAcknowledgeMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.pubsub.v1.AcknowledgeRequest, com.google.protobuf.Empty>
      METHOD_ACKNOWLEDGE = getAcknowledgeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.AcknowledgeRequest, com.google.protobuf.Empty>
      getAcknowledgeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.AcknowledgeRequest, com.google.protobuf.Empty>
      getAcknowledgeMethod() {
    return getAcknowledgeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.AcknowledgeRequest, com.google.protobuf.Empty>
      getAcknowledgeMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.pubsub.v1.Subscriber", "Acknowledge"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPullMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.pubsub.v1.PullRequest, com.google.pubsub.v1.PullResponse>
      METHOD_PULL = getPullMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.PullRequest, com.google.pubsub.v1.PullResponse>
      getPullMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.PullRequest, com.google.pubsub.v1.PullResponse>
      getPullMethod() {
    return getPullMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.PullRequest, com.google.pubsub.v1.PullResponse>
      getPullMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.pubsub.v1.Subscriber", "Pull"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStreamingPullMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.pubsub.v1.StreamingPullRequest, com.google.pubsub.v1.StreamingPullResponse>
      METHOD_STREAMING_PULL = getStreamingPullMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.StreamingPullRequest, com.google.pubsub.v1.StreamingPullResponse>
      getStreamingPullMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.StreamingPullRequest, com.google.pubsub.v1.StreamingPullResponse>
      getStreamingPullMethod() {
    return getStreamingPullMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.StreamingPullRequest, com.google.pubsub.v1.StreamingPullResponse>
      getStreamingPullMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.pubsub.v1.Subscriber", "StreamingPull"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getModifyPushConfigMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ModifyPushConfigRequest, com.google.protobuf.Empty>
      METHOD_MODIFY_PUSH_CONFIG = getModifyPushConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ModifyPushConfigRequest, com.google.protobuf.Empty>
      getModifyPushConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ModifyPushConfigRequest, com.google.protobuf.Empty>
      getModifyPushConfigMethod() {
    return getModifyPushConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ModifyPushConfigRequest, com.google.protobuf.Empty>
      getModifyPushConfigMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.pubsub.v1.Subscriber", "ModifyPushConfig"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetSnapshotMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.pubsub.v1.GetSnapshotRequest, com.google.pubsub.v1.Snapshot>
      METHOD_GET_SNAPSHOT = getGetSnapshotMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.GetSnapshotRequest, com.google.pubsub.v1.Snapshot>
      getGetSnapshotMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.GetSnapshotRequest, com.google.pubsub.v1.Snapshot>
      getGetSnapshotMethod() {
    return getGetSnapshotMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.GetSnapshotRequest, com.google.pubsub.v1.Snapshot>
      getGetSnapshotMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.pubsub.v1.Subscriber", "GetSnapshot"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListSnapshotsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListSnapshotsRequest, com.google.pubsub.v1.ListSnapshotsResponse>
      METHOD_LIST_SNAPSHOTS = getListSnapshotsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListSnapshotsRequest, com.google.pubsub.v1.ListSnapshotsResponse>
      getListSnapshotsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListSnapshotsRequest, com.google.pubsub.v1.ListSnapshotsResponse>
      getListSnapshotsMethod() {
    return getListSnapshotsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListSnapshotsRequest, com.google.pubsub.v1.ListSnapshotsResponse>
      getListSnapshotsMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.pubsub.v1.Subscriber", "ListSnapshots"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateSnapshotMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.pubsub.v1.CreateSnapshotRequest, com.google.pubsub.v1.Snapshot>
      METHOD_CREATE_SNAPSHOT = getCreateSnapshotMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.CreateSnapshotRequest, com.google.pubsub.v1.Snapshot>
      getCreateSnapshotMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.CreateSnapshotRequest, com.google.pubsub.v1.Snapshot>
      getCreateSnapshotMethod() {
    return getCreateSnapshotMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.CreateSnapshotRequest, com.google.pubsub.v1.Snapshot>
      getCreateSnapshotMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.pubsub.v1.Subscriber", "CreateSnapshot"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateSnapshotMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.pubsub.v1.UpdateSnapshotRequest, com.google.pubsub.v1.Snapshot>
      METHOD_UPDATE_SNAPSHOT = getUpdateSnapshotMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.UpdateSnapshotRequest, com.google.pubsub.v1.Snapshot>
      getUpdateSnapshotMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.UpdateSnapshotRequest, com.google.pubsub.v1.Snapshot>
      getUpdateSnapshotMethod() {
    return getUpdateSnapshotMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.UpdateSnapshotRequest, com.google.pubsub.v1.Snapshot>
      getUpdateSnapshotMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.pubsub.v1.Subscriber", "UpdateSnapshot"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteSnapshotMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.pubsub.v1.DeleteSnapshotRequest, com.google.protobuf.Empty>
      METHOD_DELETE_SNAPSHOT = getDeleteSnapshotMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.DeleteSnapshotRequest, com.google.protobuf.Empty>
      getDeleteSnapshotMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.DeleteSnapshotRequest, com.google.protobuf.Empty>
      getDeleteSnapshotMethod() {
    return getDeleteSnapshotMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.DeleteSnapshotRequest, com.google.protobuf.Empty>
      getDeleteSnapshotMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.pubsub.v1.Subscriber", "DeleteSnapshot"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSeekMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.pubsub.v1.SeekRequest, com.google.pubsub.v1.SeekResponse>
      METHOD_SEEK = getSeekMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.SeekRequest, com.google.pubsub.v1.SeekResponse>
      getSeekMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.SeekRequest, com.google.pubsub.v1.SeekResponse>
      getSeekMethod() {
    return getSeekMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.SeekRequest, com.google.pubsub.v1.SeekResponse>
      getSeekMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName("google.pubsub.v1.Subscriber", "Seek"))
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
    return new SubscriberStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SubscriberBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new SubscriberBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SubscriberFutureStub newFutureStub(io.grpc.Channel channel) {
    return new SubscriberFutureStub(channel);
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
  public abstract static class SubscriberImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a subscription to a given topic. See the
     * &lt;a href="/pubsub/docs/admin#resource_names"&gt; resource name rules&lt;/a&gt;.
     * If the subscription already exists, returns `ALREADY_EXISTS`.
     * If the corresponding topic doesn't exist, returns `NOT_FOUND`.
     * If the name is not provided in the request, the server will assign a random
     * name for this subscription on the same project as the topic, conforming
     * to the
     * [resource name format](https://cloud.google.com/pubsub/docs/overview#names).
     * The generated name is populated in the returned Subscription object.
     * Note that for REST API requests, you must specify a name in the request.
     * </pre>
     */
    public void createSubscription(
        com.google.pubsub.v1.Subscription request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Subscription> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateSubscriptionMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getGetSubscriptionMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing subscription. Note that certain properties of a
     * subscription, such as its topic, are not modifiable.
     * </pre>
     */
    public void updateSubscription(
        com.google.pubsub.v1.UpdateSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Subscription> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateSubscriptionMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getListSubscriptionsMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getDeleteSubscriptionMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getModifyAckDeadlineMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getAcknowledgeMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pulls messages from the server. The server may return `UNAVAILABLE` if
     * there are too many concurrent pull requests pending for the given
     * subscription.
     * </pre>
     */
    public void pull(
        com.google.pubsub.v1.PullRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.PullResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPullMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Establishes a stream with the server, which sends messages down to the
     * client. The client streams acknowledgements and ack deadline modifications
     * back to the server. The server will close the stream and return the status
     * on any error. The server may close the stream with status `UNAVAILABLE` to
     * reassign server-side resources, in which case, the client should
     * re-establish the stream. Flow control can be achieved by configuring the
     * underlying RPC channel.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.pubsub.v1.StreamingPullRequest> streamingPull(
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.StreamingPullResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getStreamingPullMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getModifyPushConfigMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the configuration details of a snapshot.&lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.
     * </pre>
     */
    public void getSnapshot(
        com.google.pubsub.v1.GetSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Snapshot> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSnapshotMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing snapshots.&lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.
     * </pre>
     */
    public void listSnapshots(
        com.google.pubsub.v1.ListSnapshotsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListSnapshotsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListSnapshotsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a snapshot from the requested subscription.&lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.&lt;br&gt;&lt;br&gt;
     * If the snapshot already exists, returns `ALREADY_EXISTS`.
     * If the requested subscription doesn't exist, returns `NOT_FOUND`.
     * If the backlog in the subscription is too old -- and the resulting snapshot
     * would expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned.
     * See also the `Snapshot.expire_time` field. If the name is not provided in
     * the request, the server will assign a random
     * name for this snapshot on the same project as the subscription, conforming
     * to the [resource name format](https://cloud.google.com/pubsub/docs/overview#names).
     * The generated
     * name is populated in the returned Snapshot object. Note that for REST API
     * requests, you must specify a name in the request.
     * </pre>
     */
    public void createSnapshot(
        com.google.pubsub.v1.CreateSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Snapshot> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateSnapshotMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing snapshot.&lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.
     * Note that certain properties of a snapshot are not modifiable.
     * </pre>
     */
    public void updateSnapshot(
        com.google.pubsub.v1.UpdateSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Snapshot> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateSnapshotMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes an existing snapshot. &lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.
     * When the snapshot is deleted, all messages retained in the snapshot
     * are immediately dropped. After a snapshot is deleted, a new one may be
     * created with the same name, but the new one has no association with the old
     * snapshot or its subscription, unless the same subscription is specified.
     * </pre>
     */
    public void deleteSnapshot(
        com.google.pubsub.v1.DeleteSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteSnapshotMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Seeks an existing subscription to a point in time or to a given snapshot,
     * whichever is provided in the request.&lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.
     * </pre>
     */
    public void seek(
        com.google.pubsub.v1.SeekRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.SeekResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSeekMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateSubscriptionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.pubsub.v1.Subscription, com.google.pubsub.v1.Subscription>(
                      this, METHODID_CREATE_SUBSCRIPTION)))
          .addMethod(
              getGetSubscriptionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.pubsub.v1.GetSubscriptionRequest,
                      com.google.pubsub.v1.Subscription>(this, METHODID_GET_SUBSCRIPTION)))
          .addMethod(
              getUpdateSubscriptionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.pubsub.v1.UpdateSubscriptionRequest,
                      com.google.pubsub.v1.Subscription>(this, METHODID_UPDATE_SUBSCRIPTION)))
          .addMethod(
              getListSubscriptionsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.pubsub.v1.ListSubscriptionsRequest,
                      com.google.pubsub.v1.ListSubscriptionsResponse>(
                      this, METHODID_LIST_SUBSCRIPTIONS)))
          .addMethod(
              getDeleteSubscriptionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.pubsub.v1.DeleteSubscriptionRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_SUBSCRIPTION)))
          .addMethod(
              getModifyAckDeadlineMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.pubsub.v1.ModifyAckDeadlineRequest, com.google.protobuf.Empty>(
                      this, METHODID_MODIFY_ACK_DEADLINE)))
          .addMethod(
              getAcknowledgeMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.pubsub.v1.AcknowledgeRequest, com.google.protobuf.Empty>(
                      this, METHODID_ACKNOWLEDGE)))
          .addMethod(
              getPullMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.pubsub.v1.PullRequest, com.google.pubsub.v1.PullResponse>(
                      this, METHODID_PULL)))
          .addMethod(
              getStreamingPullMethodHelper(),
              asyncBidiStreamingCall(
                  new MethodHandlers<
                      com.google.pubsub.v1.StreamingPullRequest,
                      com.google.pubsub.v1.StreamingPullResponse>(this, METHODID_STREAMING_PULL)))
          .addMethod(
              getModifyPushConfigMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.pubsub.v1.ModifyPushConfigRequest, com.google.protobuf.Empty>(
                      this, METHODID_MODIFY_PUSH_CONFIG)))
          .addMethod(
              getGetSnapshotMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.pubsub.v1.GetSnapshotRequest, com.google.pubsub.v1.Snapshot>(
                      this, METHODID_GET_SNAPSHOT)))
          .addMethod(
              getListSnapshotsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.pubsub.v1.ListSnapshotsRequest,
                      com.google.pubsub.v1.ListSnapshotsResponse>(this, METHODID_LIST_SNAPSHOTS)))
          .addMethod(
              getCreateSnapshotMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.pubsub.v1.CreateSnapshotRequest, com.google.pubsub.v1.Snapshot>(
                      this, METHODID_CREATE_SNAPSHOT)))
          .addMethod(
              getUpdateSnapshotMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.pubsub.v1.UpdateSnapshotRequest, com.google.pubsub.v1.Snapshot>(
                      this, METHODID_UPDATE_SNAPSHOT)))
          .addMethod(
              getDeleteSnapshotMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.pubsub.v1.DeleteSnapshotRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_SNAPSHOT)))
          .addMethod(
              getSeekMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.pubsub.v1.SeekRequest, com.google.pubsub.v1.SeekResponse>(
                      this, METHODID_SEEK)))
          .build();
    }
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
  public static final class SubscriberStub extends io.grpc.stub.AbstractStub<SubscriberStub> {
    private SubscriberStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     * Creates a subscription to a given topic. See the
     * &lt;a href="/pubsub/docs/admin#resource_names"&gt; resource name rules&lt;/a&gt;.
     * If the subscription already exists, returns `ALREADY_EXISTS`.
     * If the corresponding topic doesn't exist, returns `NOT_FOUND`.
     * If the name is not provided in the request, the server will assign a random
     * name for this subscription on the same project as the topic, conforming
     * to the
     * [resource name format](https://cloud.google.com/pubsub/docs/overview#names).
     * The generated name is populated in the returned Subscription object.
     * Note that for REST API requests, you must specify a name in the request.
     * </pre>
     */
    public void createSubscription(
        com.google.pubsub.v1.Subscription request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Subscription> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateSubscriptionMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getGetSubscriptionMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing subscription. Note that certain properties of a
     * subscription, such as its topic, are not modifiable.
     * </pre>
     */
    public void updateSubscription(
        com.google.pubsub.v1.UpdateSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Subscription> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateSubscriptionMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getListSubscriptionsMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getDeleteSubscriptionMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getModifyAckDeadlineMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getAcknowledgeMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pulls messages from the server. The server may return `UNAVAILABLE` if
     * there are too many concurrent pull requests pending for the given
     * subscription.
     * </pre>
     */
    public void pull(
        com.google.pubsub.v1.PullRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.PullResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPullMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Establishes a stream with the server, which sends messages down to the
     * client. The client streams acknowledgements and ack deadline modifications
     * back to the server. The server will close the stream and return the status
     * on any error. The server may close the stream with status `UNAVAILABLE` to
     * reassign server-side resources, in which case, the client should
     * re-establish the stream. Flow control can be achieved by configuring the
     * underlying RPC channel.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.pubsub.v1.StreamingPullRequest> streamingPull(
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.StreamingPullResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getStreamingPullMethodHelper(), getCallOptions()), responseObserver);
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
      asyncUnaryCall(
          getChannel().newCall(getModifyPushConfigMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the configuration details of a snapshot.&lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.
     * </pre>
     */
    public void getSnapshot(
        com.google.pubsub.v1.GetSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Snapshot> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSnapshotMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing snapshots.&lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.
     * </pre>
     */
    public void listSnapshots(
        com.google.pubsub.v1.ListSnapshotsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListSnapshotsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListSnapshotsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a snapshot from the requested subscription.&lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.&lt;br&gt;&lt;br&gt;
     * If the snapshot already exists, returns `ALREADY_EXISTS`.
     * If the requested subscription doesn't exist, returns `NOT_FOUND`.
     * If the backlog in the subscription is too old -- and the resulting snapshot
     * would expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned.
     * See also the `Snapshot.expire_time` field. If the name is not provided in
     * the request, the server will assign a random
     * name for this snapshot on the same project as the subscription, conforming
     * to the [resource name format](https://cloud.google.com/pubsub/docs/overview#names).
     * The generated
     * name is populated in the returned Snapshot object. Note that for REST API
     * requests, you must specify a name in the request.
     * </pre>
     */
    public void createSnapshot(
        com.google.pubsub.v1.CreateSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Snapshot> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateSnapshotMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing snapshot.&lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.
     * Note that certain properties of a snapshot are not modifiable.
     * </pre>
     */
    public void updateSnapshot(
        com.google.pubsub.v1.UpdateSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Snapshot> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateSnapshotMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes an existing snapshot. &lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.
     * When the snapshot is deleted, all messages retained in the snapshot
     * are immediately dropped. After a snapshot is deleted, a new one may be
     * created with the same name, but the new one has no association with the old
     * snapshot or its subscription, unless the same subscription is specified.
     * </pre>
     */
    public void deleteSnapshot(
        com.google.pubsub.v1.DeleteSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteSnapshotMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Seeks an existing subscription to a point in time or to a given snapshot,
     * whichever is provided in the request.&lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.
     * </pre>
     */
    public void seek(
        com.google.pubsub.v1.SeekRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.SeekResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSeekMethodHelper(), getCallOptions()), request, responseObserver);
    }
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
  public static final class SubscriberBlockingStub
      extends io.grpc.stub.AbstractStub<SubscriberBlockingStub> {
    private SubscriberBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     * Creates a subscription to a given topic. See the
     * &lt;a href="/pubsub/docs/admin#resource_names"&gt; resource name rules&lt;/a&gt;.
     * If the subscription already exists, returns `ALREADY_EXISTS`.
     * If the corresponding topic doesn't exist, returns `NOT_FOUND`.
     * If the name is not provided in the request, the server will assign a random
     * name for this subscription on the same project as the topic, conforming
     * to the
     * [resource name format](https://cloud.google.com/pubsub/docs/overview#names).
     * The generated name is populated in the returned Subscription object.
     * Note that for REST API requests, you must specify a name in the request.
     * </pre>
     */
    public com.google.pubsub.v1.Subscription createSubscription(
        com.google.pubsub.v1.Subscription request) {
      return blockingUnaryCall(
          getChannel(), getCreateSubscriptionMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getGetSubscriptionMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing subscription. Note that certain properties of a
     * subscription, such as its topic, are not modifiable.
     * </pre>
     */
    public com.google.pubsub.v1.Subscription updateSubscription(
        com.google.pubsub.v1.UpdateSubscriptionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateSubscriptionMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getListSubscriptionsMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getDeleteSubscriptionMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getModifyAckDeadlineMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getAcknowledgeMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Pulls messages from the server. The server may return `UNAVAILABLE` if
     * there are too many concurrent pull requests pending for the given
     * subscription.
     * </pre>
     */
    public com.google.pubsub.v1.PullResponse pull(com.google.pubsub.v1.PullRequest request) {
      return blockingUnaryCall(getChannel(), getPullMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getModifyPushConfigMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the configuration details of a snapshot.&lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.
     * </pre>
     */
    public com.google.pubsub.v1.Snapshot getSnapshot(
        com.google.pubsub.v1.GetSnapshotRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSnapshotMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing snapshots.&lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.
     * </pre>
     */
    public com.google.pubsub.v1.ListSnapshotsResponse listSnapshots(
        com.google.pubsub.v1.ListSnapshotsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListSnapshotsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a snapshot from the requested subscription.&lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.&lt;br&gt;&lt;br&gt;
     * If the snapshot already exists, returns `ALREADY_EXISTS`.
     * If the requested subscription doesn't exist, returns `NOT_FOUND`.
     * If the backlog in the subscription is too old -- and the resulting snapshot
     * would expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned.
     * See also the `Snapshot.expire_time` field. If the name is not provided in
     * the request, the server will assign a random
     * name for this snapshot on the same project as the subscription, conforming
     * to the [resource name format](https://cloud.google.com/pubsub/docs/overview#names).
     * The generated
     * name is populated in the returned Snapshot object. Note that for REST API
     * requests, you must specify a name in the request.
     * </pre>
     */
    public com.google.pubsub.v1.Snapshot createSnapshot(
        com.google.pubsub.v1.CreateSnapshotRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateSnapshotMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing snapshot.&lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.
     * Note that certain properties of a snapshot are not modifiable.
     * </pre>
     */
    public com.google.pubsub.v1.Snapshot updateSnapshot(
        com.google.pubsub.v1.UpdateSnapshotRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateSnapshotMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes an existing snapshot. &lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.
     * When the snapshot is deleted, all messages retained in the snapshot
     * are immediately dropped. After a snapshot is deleted, a new one may be
     * created with the same name, but the new one has no association with the old
     * snapshot or its subscription, unless the same subscription is specified.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSnapshot(
        com.google.pubsub.v1.DeleteSnapshotRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteSnapshotMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Seeks an existing subscription to a point in time or to a given snapshot,
     * whichever is provided in the request.&lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.
     * </pre>
     */
    public com.google.pubsub.v1.SeekResponse seek(com.google.pubsub.v1.SeekRequest request) {
      return blockingUnaryCall(getChannel(), getSeekMethodHelper(), getCallOptions(), request);
    }
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
  public static final class SubscriberFutureStub
      extends io.grpc.stub.AbstractStub<SubscriberFutureStub> {
    private SubscriberFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     * Creates a subscription to a given topic. See the
     * &lt;a href="/pubsub/docs/admin#resource_names"&gt; resource name rules&lt;/a&gt;.
     * If the subscription already exists, returns `ALREADY_EXISTS`.
     * If the corresponding topic doesn't exist, returns `NOT_FOUND`.
     * If the name is not provided in the request, the server will assign a random
     * name for this subscription on the same project as the topic, conforming
     * to the
     * [resource name format](https://cloud.google.com/pubsub/docs/overview#names).
     * The generated name is populated in the returned Subscription object.
     * Note that for REST API requests, you must specify a name in the request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Subscription>
        createSubscription(com.google.pubsub.v1.Subscription request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateSubscriptionMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getGetSubscriptionMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing subscription. Note that certain properties of a
     * subscription, such as its topic, are not modifiable.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Subscription>
        updateSubscription(com.google.pubsub.v1.UpdateSubscriptionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateSubscriptionMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getListSubscriptionsMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getDeleteSubscriptionMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getModifyAckDeadlineMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getAcknowledgeMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Pulls messages from the server. The server may return `UNAVAILABLE` if
     * there are too many concurrent pull requests pending for the given
     * subscription.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.PullResponse>
        pull(com.google.pubsub.v1.PullRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPullMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getModifyPushConfigMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the configuration details of a snapshot.&lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Snapshot>
        getSnapshot(com.google.pubsub.v1.GetSnapshotRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSnapshotMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing snapshots.&lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.pubsub.v1.ListSnapshotsResponse>
        listSnapshots(com.google.pubsub.v1.ListSnapshotsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListSnapshotsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a snapshot from the requested subscription.&lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.&lt;br&gt;&lt;br&gt;
     * If the snapshot already exists, returns `ALREADY_EXISTS`.
     * If the requested subscription doesn't exist, returns `NOT_FOUND`.
     * If the backlog in the subscription is too old -- and the resulting snapshot
     * would expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned.
     * See also the `Snapshot.expire_time` field. If the name is not provided in
     * the request, the server will assign a random
     * name for this snapshot on the same project as the subscription, conforming
     * to the [resource name format](https://cloud.google.com/pubsub/docs/overview#names).
     * The generated
     * name is populated in the returned Snapshot object. Note that for REST API
     * requests, you must specify a name in the request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Snapshot>
        createSnapshot(com.google.pubsub.v1.CreateSnapshotRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateSnapshotMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing snapshot.&lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.
     * Note that certain properties of a snapshot are not modifiable.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Snapshot>
        updateSnapshot(com.google.pubsub.v1.UpdateSnapshotRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateSnapshotMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes an existing snapshot. &lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.
     * When the snapshot is deleted, all messages retained in the snapshot
     * are immediately dropped. After a snapshot is deleted, a new one may be
     * created with the same name, but the new one has no association with the old
     * snapshot or its subscription, unless the same subscription is specified.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSnapshot(com.google.pubsub.v1.DeleteSnapshotRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteSnapshotMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Seeks an existing subscription to a point in time or to a given snapshot,
     * whichever is provided in the request.&lt;br&gt;&lt;br&gt;
     * &lt;b&gt;ALPHA:&lt;/b&gt; This feature is part of an alpha release. This API might be
     * changed in backward-incompatible ways and is not recommended for production
     * use. It is not subject to any SLA or deprecation policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.SeekResponse>
        seek(com.google.pubsub.v1.SeekRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSeekMethodHelper(), getCallOptions()), request);
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
    private final SubscriberImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SubscriberImplBase serviceImpl, int methodId) {
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
    private final String methodName;

    SubscriberMethodDescriptorSupplier(String methodName) {
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
                      .addMethod(getCreateSubscriptionMethodHelper())
                      .addMethod(getGetSubscriptionMethodHelper())
                      .addMethod(getUpdateSubscriptionMethodHelper())
                      .addMethod(getListSubscriptionsMethodHelper())
                      .addMethod(getDeleteSubscriptionMethodHelper())
                      .addMethod(getModifyAckDeadlineMethodHelper())
                      .addMethod(getAcknowledgeMethodHelper())
                      .addMethod(getPullMethodHelper())
                      .addMethod(getStreamingPullMethodHelper())
                      .addMethod(getModifyPushConfigMethodHelper())
                      .addMethod(getGetSnapshotMethodHelper())
                      .addMethod(getListSnapshotsMethodHelper())
                      .addMethod(getCreateSnapshotMethodHelper())
                      .addMethod(getUpdateSnapshotMethodHelper())
                      .addMethod(getDeleteSnapshotMethodHelper())
                      .addMethod(getSeekMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
