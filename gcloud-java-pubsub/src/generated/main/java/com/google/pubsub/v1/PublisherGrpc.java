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
public class PublisherGrpc {

  private PublisherGrpc() {}

  public static final String SERVICE_NAME = "google.pubsub.v1.Publisher";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.Topic,
      com.google.pubsub.v1.Topic> METHOD_CREATE_TOPIC =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.pubsub.v1.Publisher", "CreateTopic"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.Topic.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.Topic.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.PublishRequest,
      com.google.pubsub.v1.PublishResponse> METHOD_PUBLISH =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.pubsub.v1.Publisher", "Publish"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.PublishRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.PublishResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.GetTopicRequest,
      com.google.pubsub.v1.Topic> METHOD_GET_TOPIC =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.pubsub.v1.Publisher", "GetTopic"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.GetTopicRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.Topic.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.ListTopicsRequest,
      com.google.pubsub.v1.ListTopicsResponse> METHOD_LIST_TOPICS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.pubsub.v1.Publisher", "ListTopics"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.ListTopicsRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.ListTopicsResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.ListTopicSubscriptionsRequest,
      com.google.pubsub.v1.ListTopicSubscriptionsResponse> METHOD_LIST_TOPIC_SUBSCRIPTIONS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.pubsub.v1.Publisher", "ListTopicSubscriptions"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.ListTopicSubscriptionsRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.ListTopicSubscriptionsResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.DeleteTopicRequest,
      com.google.protobuf.Empty> METHOD_DELETE_TOPIC =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.pubsub.v1.Publisher", "DeleteTopic"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.pubsub.v1.DeleteTopicRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Empty.getDefaultInstance()));

  public static PublisherStub newStub(io.grpc.Channel channel) {
    return new PublisherStub(channel);
  }

  public static PublisherBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PublisherBlockingStub(channel);
  }

  public static PublisherFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PublisherFutureStub(channel);
  }

  public static interface Publisher {

    public void createTopic(com.google.pubsub.v1.Topic request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic> responseObserver);

    public void publish(com.google.pubsub.v1.PublishRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.PublishResponse> responseObserver);

    public void getTopic(com.google.pubsub.v1.GetTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic> responseObserver);

    public void listTopics(com.google.pubsub.v1.ListTopicsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicsResponse> responseObserver);

    public void listTopicSubscriptions(com.google.pubsub.v1.ListTopicSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicSubscriptionsResponse> responseObserver);

    public void deleteTopic(com.google.pubsub.v1.DeleteTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver);
  }

  public static interface PublisherBlockingClient {

    public com.google.pubsub.v1.Topic createTopic(com.google.pubsub.v1.Topic request);

    public com.google.pubsub.v1.PublishResponse publish(com.google.pubsub.v1.PublishRequest request);

    public com.google.pubsub.v1.Topic getTopic(com.google.pubsub.v1.GetTopicRequest request);

    public com.google.pubsub.v1.ListTopicsResponse listTopics(com.google.pubsub.v1.ListTopicsRequest request);

    public com.google.pubsub.v1.ListTopicSubscriptionsResponse listTopicSubscriptions(com.google.pubsub.v1.ListTopicSubscriptionsRequest request);

    public com.google.protobuf.Empty deleteTopic(com.google.pubsub.v1.DeleteTopicRequest request);
  }

  public static interface PublisherFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Topic> createTopic(
        com.google.pubsub.v1.Topic request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.PublishResponse> publish(
        com.google.pubsub.v1.PublishRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Topic> getTopic(
        com.google.pubsub.v1.GetTopicRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.ListTopicsResponse> listTopics(
        com.google.pubsub.v1.ListTopicsRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.ListTopicSubscriptionsResponse> listTopicSubscriptions(
        com.google.pubsub.v1.ListTopicSubscriptionsRequest request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteTopic(
        com.google.pubsub.v1.DeleteTopicRequest request);
  }

  public static class PublisherStub extends io.grpc.stub.AbstractStub<PublisherStub>
      implements Publisher {
    private PublisherStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PublisherStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PublisherStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PublisherStub(channel, callOptions);
    }

    @java.lang.Override
    public void createTopic(com.google.pubsub.v1.Topic request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_TOPIC, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void publish(com.google.pubsub.v1.PublishRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.PublishResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PUBLISH, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void getTopic(com.google.pubsub.v1.GetTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_TOPIC, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void listTopics(com.google.pubsub.v1.ListTopicsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_TOPICS, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void listTopicSubscriptions(com.google.pubsub.v1.ListTopicSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicSubscriptionsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_TOPIC_SUBSCRIPTIONS, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void deleteTopic(com.google.pubsub.v1.DeleteTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_TOPIC, getCallOptions()), request, responseObserver);
    }
  }

  public static class PublisherBlockingStub extends io.grpc.stub.AbstractStub<PublisherBlockingStub>
      implements PublisherBlockingClient {
    private PublisherBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PublisherBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PublisherBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PublisherBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.pubsub.v1.Topic createTopic(com.google.pubsub.v1.Topic request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_CREATE_TOPIC, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.pubsub.v1.PublishResponse publish(com.google.pubsub.v1.PublishRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_PUBLISH, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.pubsub.v1.Topic getTopic(com.google.pubsub.v1.GetTopicRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_GET_TOPIC, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.pubsub.v1.ListTopicsResponse listTopics(com.google.pubsub.v1.ListTopicsRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_LIST_TOPICS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.pubsub.v1.ListTopicSubscriptionsResponse listTopicSubscriptions(com.google.pubsub.v1.ListTopicSubscriptionsRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_LIST_TOPIC_SUBSCRIPTIONS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.protobuf.Empty deleteTopic(com.google.pubsub.v1.DeleteTopicRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_DELETE_TOPIC, getCallOptions()), request);
    }
  }

  public static class PublisherFutureStub extends io.grpc.stub.AbstractStub<PublisherFutureStub>
      implements PublisherFutureClient {
    private PublisherFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PublisherFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PublisherFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PublisherFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Topic> createTopic(
        com.google.pubsub.v1.Topic request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_TOPIC, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.PublishResponse> publish(
        com.google.pubsub.v1.PublishRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PUBLISH, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Topic> getTopic(
        com.google.pubsub.v1.GetTopicRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_TOPIC, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.ListTopicsResponse> listTopics(
        com.google.pubsub.v1.ListTopicsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_TOPICS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.ListTopicSubscriptionsResponse> listTopicSubscriptions(
        com.google.pubsub.v1.ListTopicSubscriptionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_TOPIC_SUBSCRIPTIONS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteTopic(
        com.google.pubsub.v1.DeleteTopicRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_TOPIC, getCallOptions()), request);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final Publisher serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
      .addMethod(
        METHOD_CREATE_TOPIC,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.pubsub.v1.Topic,
              com.google.pubsub.v1.Topic>() {
            @java.lang.Override
            public void invoke(
                com.google.pubsub.v1.Topic request,
                io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic> responseObserver) {
              serviceImpl.createTopic(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_PUBLISH,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.pubsub.v1.PublishRequest,
              com.google.pubsub.v1.PublishResponse>() {
            @java.lang.Override
            public void invoke(
                com.google.pubsub.v1.PublishRequest request,
                io.grpc.stub.StreamObserver<com.google.pubsub.v1.PublishResponse> responseObserver) {
              serviceImpl.publish(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_GET_TOPIC,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.pubsub.v1.GetTopicRequest,
              com.google.pubsub.v1.Topic>() {
            @java.lang.Override
            public void invoke(
                com.google.pubsub.v1.GetTopicRequest request,
                io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic> responseObserver) {
              serviceImpl.getTopic(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_LIST_TOPICS,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.pubsub.v1.ListTopicsRequest,
              com.google.pubsub.v1.ListTopicsResponse>() {
            @java.lang.Override
            public void invoke(
                com.google.pubsub.v1.ListTopicsRequest request,
                io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicsResponse> responseObserver) {
              serviceImpl.listTopics(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_LIST_TOPIC_SUBSCRIPTIONS,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.pubsub.v1.ListTopicSubscriptionsRequest,
              com.google.pubsub.v1.ListTopicSubscriptionsResponse>() {
            @java.lang.Override
            public void invoke(
                com.google.pubsub.v1.ListTopicSubscriptionsRequest request,
                io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicSubscriptionsResponse> responseObserver) {
              serviceImpl.listTopicSubscriptions(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_DELETE_TOPIC,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.google.pubsub.v1.DeleteTopicRequest,
              com.google.protobuf.Empty>() {
            @java.lang.Override
            public void invoke(
                com.google.pubsub.v1.DeleteTopicRequest request,
                io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
              serviceImpl.deleteTopic(request, responseObserver);
            }
          })).build();
  }
}
