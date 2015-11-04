package com.google.pubsub.v1;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@javax.annotation.Generated("by gRPC proto compiler")
public class SubscriberGrpc {

  private SubscriberGrpc() {}

  public static final String SERVICE_NAME = "google.pubsub.v1.Subscriber";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.Subscription,
      com.google.pubsub.v1.Subscription> METHOD_CREATE_SUBSCRIPTION =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.pubsub.v1.Subscriber", "CreateSubscription"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.Subscription.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.Subscription.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.GetSubscriptionRequest,
      com.google.pubsub.v1.Subscription> METHOD_GET_SUBSCRIPTION =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.pubsub.v1.Subscriber", "GetSubscription"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.GetSubscriptionRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.Subscription.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.ListSubscriptionsRequest,
      com.google.pubsub.v1.ListSubscriptionsResponse> METHOD_LIST_SUBSCRIPTIONS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.pubsub.v1.Subscriber", "ListSubscriptions"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.ListSubscriptionsRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.ListSubscriptionsResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.DeleteSubscriptionRequest,
      com.google.protobuf.Empty> METHOD_DELETE_SUBSCRIPTION =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.pubsub.v1.Subscriber", "DeleteSubscription"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.DeleteSubscriptionRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Empty.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.ModifyAckDeadlineRequest,
      com.google.protobuf.Empty> METHOD_MODIFY_ACK_DEADLINE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.pubsub.v1.Subscriber", "ModifyAckDeadline"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.ModifyAckDeadlineRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Empty.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.AcknowledgeRequest,
      com.google.protobuf.Empty> METHOD_ACKNOWLEDGE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.pubsub.v1.Subscriber", "Acknowledge"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.AcknowledgeRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Empty.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.PullRequest,
      com.google.pubsub.v1.PullResponse> METHOD_PULL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.pubsub.v1.Subscriber", "Pull"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.PullRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.PullResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.ModifyPushConfigRequest,
      com.google.protobuf.Empty> METHOD_MODIFY_PUSH_CONFIG =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.pubsub.v1.Subscriber", "ModifyPushConfig"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.ModifyPushConfigRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Empty.getDefaultInstance()));

  public static SubscriberStub newStub(io.grpc.Channel channel) {
    return new SubscriberStub(channel);
  }

  public static SubscriberBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SubscriberBlockingStub(channel);
  }

  public static SubscriberFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SubscriberFutureStub(channel);
  }

  public static interface Subscriber {

    public void createSubscription(com.google.pubsub.v1.Subscription request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Subscription> responseObserver);

    public void getSubscription(com.google.pubsub.v1.GetSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Subscription> responseObserver);

    public void listSubscriptions(com.google.pubsub.v1.ListSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListSubscriptionsResponse> responseObserver);

    public void deleteSubscription(com.google.pubsub.v1.DeleteSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver);

    public void modifyAckDeadline(com.google.pubsub.v1.ModifyAckDeadlineRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver);

    public void acknowledge(com.google.pubsub.v1.AcknowledgeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver);

    public void pull(com.google.pubsub.v1.PullRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.PullResponse> responseObserver);

    public void modifyPushConfig(com.google.pubsub.v1.ModifyPushConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver);
  }

  public static interface SubscriberBlockingClient {

    public com.google.pubsub.v1.Subscription createSubscription(com.google.pubsub.v1.Subscription request);

    public com.google.pubsub.v1.Subscription getSubscription(com.google.pubsub.v1.GetSubscriptionRequest request);

    public com.google.pubsub.v1.ListSubscriptionsResponse listSubscriptions(com.google.pubsub.v1.ListSubscriptionsRequest request);

    public com.google.protobuf.Empty deleteSubscription(com.google.pubsub.v1.DeleteSubscriptionRequest request);

    public com.google.protobuf.Empty modifyAckDeadline(com.google.pubsub.v1.ModifyAckDeadlineRequest request);

    public com.google.protobuf.Empty acknowledge(com.google.pubsub.v1.AcknowledgeRequest request);

    public com.google.pubsub.v1.PullResponse pull(com.google.pubsub.v1.PullRequest request);

    public com.google.protobuf.Empty modifyPushConfig(com.google.pubsub.v1.ModifyPushConfigRequest request);
  }

  public static interface SubscriberFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Subscription> createSubscription(
        com.google.pubsub.v1.Subscription request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Subscription> getSubscription(
        com.google.pubsub.v1.GetSubscriptionRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.ListSubscriptionsResponse> listSubscriptions(
        com.google.pubsub.v1.ListSubscriptionsRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteSubscription(
        com.google.pubsub.v1.DeleteSubscriptionRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> modifyAckDeadline(
        com.google.pubsub.v1.ModifyAckDeadlineRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> acknowledge(
        com.google.pubsub.v1.AcknowledgeRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.PullResponse> pull(
        com.google.pubsub.v1.PullRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> modifyPushConfig(
        com.google.pubsub.v1.ModifyPushConfigRequest request);
  }

  public static class SubscriberStub extends io.grpc.stub.AbstractStub<SubscriberStub>
      implements Subscriber {
    private SubscriberStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SubscriberStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscriberStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SubscriberStub(channel, callOptions);
    }

    @java.lang.Override
    public void createSubscription(com.google.pubsub.v1.Subscription request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Subscription> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_SUBSCRIPTION, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void getSubscription(com.google.pubsub.v1.GetSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Subscription> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_SUBSCRIPTION, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void listSubscriptions(com.google.pubsub.v1.ListSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListSubscriptionsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_SUBSCRIPTIONS, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void deleteSubscription(com.google.pubsub.v1.DeleteSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_SUBSCRIPTION, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void modifyAckDeadline(com.google.pubsub.v1.ModifyAckDeadlineRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_MODIFY_ACK_DEADLINE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void acknowledge(com.google.pubsub.v1.AcknowledgeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ACKNOWLEDGE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void pull(com.google.pubsub.v1.PullRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.PullResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PULL, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void modifyPushConfig(com.google.pubsub.v1.ModifyPushConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_MODIFY_PUSH_CONFIG, getCallOptions()), request, responseObserver);
    }
  }

  public static class SubscriberBlockingStub extends io.grpc.stub.AbstractStub<SubscriberBlockingStub>
      implements SubscriberBlockingClient {
    private SubscriberBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SubscriberBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscriberBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SubscriberBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.pubsub.v1.Subscription createSubscription(com.google.pubsub.v1.Subscription request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_CREATE_SUBSCRIPTION, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.pubsub.v1.Subscription getSubscription(com.google.pubsub.v1.GetSubscriptionRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_GET_SUBSCRIPTION, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.pubsub.v1.ListSubscriptionsResponse listSubscriptions(com.google.pubsub.v1.ListSubscriptionsRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_LIST_SUBSCRIPTIONS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.protobuf.Empty deleteSubscription(com.google.pubsub.v1.DeleteSubscriptionRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_DELETE_SUBSCRIPTION, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.protobuf.Empty modifyAckDeadline(com.google.pubsub.v1.ModifyAckDeadlineRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_MODIFY_ACK_DEADLINE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.protobuf.Empty acknowledge(com.google.pubsub.v1.AcknowledgeRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_ACKNOWLEDGE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.pubsub.v1.PullResponse pull(com.google.pubsub.v1.PullRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_PULL, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.protobuf.Empty modifyPushConfig(com.google.pubsub.v1.ModifyPushConfigRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_MODIFY_PUSH_CONFIG, getCallOptions()), request);
    }
  }

  public static class SubscriberFutureStub extends io.grpc.stub.AbstractStub<SubscriberFutureStub>
      implements SubscriberFutureClient {
    private SubscriberFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SubscriberFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscriberFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SubscriberFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Subscription> createSubscription(
        com.google.pubsub.v1.Subscription request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_SUBSCRIPTION, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Subscription> getSubscription(
        com.google.pubsub.v1.GetSubscriptionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_SUBSCRIPTION, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.ListSubscriptionsResponse> listSubscriptions(
        com.google.pubsub.v1.ListSubscriptionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_SUBSCRIPTIONS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteSubscription(
        com.google.pubsub.v1.DeleteSubscriptionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_SUBSCRIPTION, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> modifyAckDeadline(
        com.google.pubsub.v1.ModifyAckDeadlineRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_MODIFY_ACK_DEADLINE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> acknowledge(
        com.google.pubsub.v1.AcknowledgeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ACKNOWLEDGE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.PullResponse> pull(
        com.google.pubsub.v1.PullRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PULL, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> modifyPushConfig(
        com.google.pubsub.v1.ModifyPushConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_MODIFY_PUSH_CONFIG, getCallOptions()), request);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final Subscriber serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
      .addMethod(
        METHOD_CREATE_SUBSCRIPTION,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.pubsub.v1.Subscription,
              com.google.pubsub.v1.Subscription>() {
            @java.lang.Override
            public void invoke(
                com.google.pubsub.v1.Subscription request,
                io.grpc.stub.StreamObserver<com.google.pubsub.v1.Subscription> responseObserver) {
              serviceImpl.createSubscription(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_GET_SUBSCRIPTION,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.pubsub.v1.GetSubscriptionRequest,
              com.google.pubsub.v1.Subscription>() {
            @java.lang.Override
            public void invoke(
                com.google.pubsub.v1.GetSubscriptionRequest request,
                io.grpc.stub.StreamObserver<com.google.pubsub.v1.Subscription> responseObserver) {
              serviceImpl.getSubscription(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_LIST_SUBSCRIPTIONS,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.pubsub.v1.ListSubscriptionsRequest,
              com.google.pubsub.v1.ListSubscriptionsResponse>() {
            @java.lang.Override
            public void invoke(
                com.google.pubsub.v1.ListSubscriptionsRequest request,
                io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListSubscriptionsResponse> responseObserver) {
              serviceImpl.listSubscriptions(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_DELETE_SUBSCRIPTION,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.pubsub.v1.DeleteSubscriptionRequest,
              com.google.protobuf.Empty>() {
            @java.lang.Override
            public void invoke(
                com.google.pubsub.v1.DeleteSubscriptionRequest request,
                io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
              serviceImpl.deleteSubscription(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_MODIFY_ACK_DEADLINE,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.pubsub.v1.ModifyAckDeadlineRequest,
              com.google.protobuf.Empty>() {
            @java.lang.Override
            public void invoke(
                com.google.pubsub.v1.ModifyAckDeadlineRequest request,
                io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
              serviceImpl.modifyAckDeadline(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_ACKNOWLEDGE,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.pubsub.v1.AcknowledgeRequest,
              com.google.protobuf.Empty>() {
            @java.lang.Override
            public void invoke(
                com.google.pubsub.v1.AcknowledgeRequest request,
                io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
              serviceImpl.acknowledge(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_PULL,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.pubsub.v1.PullRequest,
              com.google.pubsub.v1.PullResponse>() {
            @java.lang.Override
            public void invoke(
                com.google.pubsub.v1.PullRequest request,
                io.grpc.stub.StreamObserver<com.google.pubsub.v1.PullResponse> responseObserver) {
              serviceImpl.pull(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_MODIFY_PUSH_CONFIG,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.pubsub.v1.ModifyPushConfigRequest,
              com.google.protobuf.Empty>() {
            @java.lang.Override
            public void invoke(
                com.google.pubsub.v1.ModifyPushConfigRequest request,
                io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
              serviceImpl.modifyPushConfig(request, responseObserver);
            }
          })).build();
  }
}
