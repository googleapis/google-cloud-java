package com.google.pubsub.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The service that an application uses to manipulate topics, and to send
 * messages to a topic.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/pubsub/v1/pubsub.proto")
public final class PublisherGrpc {

  private PublisherGrpc() {}

  public static final String SERVICE_NAME = "google.pubsub.v1.Publisher";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateTopicMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.Topic,
      com.google.pubsub.v1.Topic> METHOD_CREATE_TOPIC = getCreateTopicMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.pubsub.v1.Topic,
      com.google.pubsub.v1.Topic> getCreateTopicMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.pubsub.v1.Topic,
      com.google.pubsub.v1.Topic> getCreateTopicMethod() {
    return getCreateTopicMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.pubsub.v1.Topic,
      com.google.pubsub.v1.Topic> getCreateTopicMethodHelper() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.Topic, com.google.pubsub.v1.Topic> getCreateTopicMethod;
    if ((getCreateTopicMethod = PublisherGrpc.getCreateTopicMethod) == null) {
      synchronized (PublisherGrpc.class) {
        if ((getCreateTopicMethod = PublisherGrpc.getCreateTopicMethod) == null) {
          PublisherGrpc.getCreateTopicMethod = getCreateTopicMethod = 
              io.grpc.MethodDescriptor.<com.google.pubsub.v1.Topic, com.google.pubsub.v1.Topic>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.pubsub.v1.Publisher", "CreateTopic"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.pubsub.v1.Topic.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.pubsub.v1.Topic.getDefaultInstance()))
                  .setSchemaDescriptor(new PublisherMethodDescriptorSupplier("CreateTopic"))
                  .build();
          }
        }
     }
     return getCreateTopicMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateTopicMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.UpdateTopicRequest,
      com.google.pubsub.v1.Topic> METHOD_UPDATE_TOPIC = getUpdateTopicMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.pubsub.v1.UpdateTopicRequest,
      com.google.pubsub.v1.Topic> getUpdateTopicMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.pubsub.v1.UpdateTopicRequest,
      com.google.pubsub.v1.Topic> getUpdateTopicMethod() {
    return getUpdateTopicMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.pubsub.v1.UpdateTopicRequest,
      com.google.pubsub.v1.Topic> getUpdateTopicMethodHelper() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.UpdateTopicRequest, com.google.pubsub.v1.Topic> getUpdateTopicMethod;
    if ((getUpdateTopicMethod = PublisherGrpc.getUpdateTopicMethod) == null) {
      synchronized (PublisherGrpc.class) {
        if ((getUpdateTopicMethod = PublisherGrpc.getUpdateTopicMethod) == null) {
          PublisherGrpc.getUpdateTopicMethod = getUpdateTopicMethod = 
              io.grpc.MethodDescriptor.<com.google.pubsub.v1.UpdateTopicRequest, com.google.pubsub.v1.Topic>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.pubsub.v1.Publisher", "UpdateTopic"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.pubsub.v1.UpdateTopicRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.pubsub.v1.Topic.getDefaultInstance()))
                  .setSchemaDescriptor(new PublisherMethodDescriptorSupplier("UpdateTopic"))
                  .build();
          }
        }
     }
     return getUpdateTopicMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPublishMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.PublishRequest,
      com.google.pubsub.v1.PublishResponse> METHOD_PUBLISH = getPublishMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.pubsub.v1.PublishRequest,
      com.google.pubsub.v1.PublishResponse> getPublishMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.pubsub.v1.PublishRequest,
      com.google.pubsub.v1.PublishResponse> getPublishMethod() {
    return getPublishMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.pubsub.v1.PublishRequest,
      com.google.pubsub.v1.PublishResponse> getPublishMethodHelper() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.PublishRequest, com.google.pubsub.v1.PublishResponse> getPublishMethod;
    if ((getPublishMethod = PublisherGrpc.getPublishMethod) == null) {
      synchronized (PublisherGrpc.class) {
        if ((getPublishMethod = PublisherGrpc.getPublishMethod) == null) {
          PublisherGrpc.getPublishMethod = getPublishMethod = 
              io.grpc.MethodDescriptor.<com.google.pubsub.v1.PublishRequest, com.google.pubsub.v1.PublishResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.pubsub.v1.Publisher", "Publish"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.pubsub.v1.PublishRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.pubsub.v1.PublishResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PublisherMethodDescriptorSupplier("Publish"))
                  .build();
          }
        }
     }
     return getPublishMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetTopicMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.GetTopicRequest,
      com.google.pubsub.v1.Topic> METHOD_GET_TOPIC = getGetTopicMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.pubsub.v1.GetTopicRequest,
      com.google.pubsub.v1.Topic> getGetTopicMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.pubsub.v1.GetTopicRequest,
      com.google.pubsub.v1.Topic> getGetTopicMethod() {
    return getGetTopicMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.pubsub.v1.GetTopicRequest,
      com.google.pubsub.v1.Topic> getGetTopicMethodHelper() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.GetTopicRequest, com.google.pubsub.v1.Topic> getGetTopicMethod;
    if ((getGetTopicMethod = PublisherGrpc.getGetTopicMethod) == null) {
      synchronized (PublisherGrpc.class) {
        if ((getGetTopicMethod = PublisherGrpc.getGetTopicMethod) == null) {
          PublisherGrpc.getGetTopicMethod = getGetTopicMethod = 
              io.grpc.MethodDescriptor.<com.google.pubsub.v1.GetTopicRequest, com.google.pubsub.v1.Topic>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.pubsub.v1.Publisher", "GetTopic"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.pubsub.v1.GetTopicRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.pubsub.v1.Topic.getDefaultInstance()))
                  .setSchemaDescriptor(new PublisherMethodDescriptorSupplier("GetTopic"))
                  .build();
          }
        }
     }
     return getGetTopicMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListTopicsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.ListTopicsRequest,
      com.google.pubsub.v1.ListTopicsResponse> METHOD_LIST_TOPICS = getListTopicsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.pubsub.v1.ListTopicsRequest,
      com.google.pubsub.v1.ListTopicsResponse> getListTopicsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.pubsub.v1.ListTopicsRequest,
      com.google.pubsub.v1.ListTopicsResponse> getListTopicsMethod() {
    return getListTopicsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.pubsub.v1.ListTopicsRequest,
      com.google.pubsub.v1.ListTopicsResponse> getListTopicsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.ListTopicsRequest, com.google.pubsub.v1.ListTopicsResponse> getListTopicsMethod;
    if ((getListTopicsMethod = PublisherGrpc.getListTopicsMethod) == null) {
      synchronized (PublisherGrpc.class) {
        if ((getListTopicsMethod = PublisherGrpc.getListTopicsMethod) == null) {
          PublisherGrpc.getListTopicsMethod = getListTopicsMethod = 
              io.grpc.MethodDescriptor.<com.google.pubsub.v1.ListTopicsRequest, com.google.pubsub.v1.ListTopicsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.pubsub.v1.Publisher", "ListTopics"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.pubsub.v1.ListTopicsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.pubsub.v1.ListTopicsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PublisherMethodDescriptorSupplier("ListTopics"))
                  .build();
          }
        }
     }
     return getListTopicsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListTopicSubscriptionsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.ListTopicSubscriptionsRequest,
      com.google.pubsub.v1.ListTopicSubscriptionsResponse> METHOD_LIST_TOPIC_SUBSCRIPTIONS = getListTopicSubscriptionsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.pubsub.v1.ListTopicSubscriptionsRequest,
      com.google.pubsub.v1.ListTopicSubscriptionsResponse> getListTopicSubscriptionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.pubsub.v1.ListTopicSubscriptionsRequest,
      com.google.pubsub.v1.ListTopicSubscriptionsResponse> getListTopicSubscriptionsMethod() {
    return getListTopicSubscriptionsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.pubsub.v1.ListTopicSubscriptionsRequest,
      com.google.pubsub.v1.ListTopicSubscriptionsResponse> getListTopicSubscriptionsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.ListTopicSubscriptionsRequest, com.google.pubsub.v1.ListTopicSubscriptionsResponse> getListTopicSubscriptionsMethod;
    if ((getListTopicSubscriptionsMethod = PublisherGrpc.getListTopicSubscriptionsMethod) == null) {
      synchronized (PublisherGrpc.class) {
        if ((getListTopicSubscriptionsMethod = PublisherGrpc.getListTopicSubscriptionsMethod) == null) {
          PublisherGrpc.getListTopicSubscriptionsMethod = getListTopicSubscriptionsMethod = 
              io.grpc.MethodDescriptor.<com.google.pubsub.v1.ListTopicSubscriptionsRequest, com.google.pubsub.v1.ListTopicSubscriptionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.pubsub.v1.Publisher", "ListTopicSubscriptions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.pubsub.v1.ListTopicSubscriptionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.pubsub.v1.ListTopicSubscriptionsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PublisherMethodDescriptorSupplier("ListTopicSubscriptions"))
                  .build();
          }
        }
     }
     return getListTopicSubscriptionsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteTopicMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.pubsub.v1.DeleteTopicRequest,
      com.google.protobuf.Empty> METHOD_DELETE_TOPIC = getDeleteTopicMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.pubsub.v1.DeleteTopicRequest,
      com.google.protobuf.Empty> getDeleteTopicMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.pubsub.v1.DeleteTopicRequest,
      com.google.protobuf.Empty> getDeleteTopicMethod() {
    return getDeleteTopicMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.pubsub.v1.DeleteTopicRequest,
      com.google.protobuf.Empty> getDeleteTopicMethodHelper() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.DeleteTopicRequest, com.google.protobuf.Empty> getDeleteTopicMethod;
    if ((getDeleteTopicMethod = PublisherGrpc.getDeleteTopicMethod) == null) {
      synchronized (PublisherGrpc.class) {
        if ((getDeleteTopicMethod = PublisherGrpc.getDeleteTopicMethod) == null) {
          PublisherGrpc.getDeleteTopicMethod = getDeleteTopicMethod = 
              io.grpc.MethodDescriptor.<com.google.pubsub.v1.DeleteTopicRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.pubsub.v1.Publisher", "DeleteTopic"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.pubsub.v1.DeleteTopicRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new PublisherMethodDescriptorSupplier("DeleteTopic"))
                  .build();
          }
        }
     }
     return getDeleteTopicMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PublisherStub newStub(io.grpc.Channel channel) {
    return new PublisherStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PublisherBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PublisherBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PublisherFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PublisherFutureStub(channel);
  }

  /**
   * <pre>
   * The service that an application uses to manipulate topics, and to send
   * messages to a topic.
   * </pre>
   */
  public static abstract class PublisherImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates the given topic with the given name.
     * </pre>
     */
    public void createTopic(com.google.pubsub.v1.Topic request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateTopicMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates an existing topic. Note that certain properties of a topic are not
     * modifiable.  Options settings follow the style guide:
     * NOTE:  The style guide requires body: "topic" instead of body: "*".
     * Keeping the latter for internal consistency in V1, however it should be
     * corrected in V2.  See
     * https://cloud.google.com/apis/design/standard_methods#update for details.
     * </pre>
     */
    public void updateTopic(com.google.pubsub.v1.UpdateTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateTopicMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic
     * does not exist. The message payload must not be empty; it must contain
     *  either a non-empty data field, or at least one attribute.
     * </pre>
     */
    public void publish(com.google.pubsub.v1.PublishRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.PublishResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPublishMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets the configuration of a topic.
     * </pre>
     */
    public void getTopic(com.google.pubsub.v1.GetTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTopicMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists matching topics.
     * </pre>
     */
    public void listTopics(com.google.pubsub.v1.ListTopicsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListTopicsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists the name of the subscriptions for this topic.
     * </pre>
     */
    public void listTopicSubscriptions(com.google.pubsub.v1.ListTopicSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicSubscriptionsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListTopicSubscriptionsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic
     * does not exist. After a topic is deleted, a new topic may be created with
     * the same name; this is an entirely new topic with none of the old
     * configuration or subscriptions. Existing subscriptions to this topic are
     * not deleted, but their `topic` field is set to `_deleted-topic_`.
     * </pre>
     */
    public void deleteTopic(com.google.pubsub.v1.DeleteTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteTopicMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateTopicMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.pubsub.v1.Topic,
                com.google.pubsub.v1.Topic>(
                  this, METHODID_CREATE_TOPIC)))
          .addMethod(
            getUpdateTopicMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.pubsub.v1.UpdateTopicRequest,
                com.google.pubsub.v1.Topic>(
                  this, METHODID_UPDATE_TOPIC)))
          .addMethod(
            getPublishMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.pubsub.v1.PublishRequest,
                com.google.pubsub.v1.PublishResponse>(
                  this, METHODID_PUBLISH)))
          .addMethod(
            getGetTopicMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.pubsub.v1.GetTopicRequest,
                com.google.pubsub.v1.Topic>(
                  this, METHODID_GET_TOPIC)))
          .addMethod(
            getListTopicsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.pubsub.v1.ListTopicsRequest,
                com.google.pubsub.v1.ListTopicsResponse>(
                  this, METHODID_LIST_TOPICS)))
          .addMethod(
            getListTopicSubscriptionsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.pubsub.v1.ListTopicSubscriptionsRequest,
                com.google.pubsub.v1.ListTopicSubscriptionsResponse>(
                  this, METHODID_LIST_TOPIC_SUBSCRIPTIONS)))
          .addMethod(
            getDeleteTopicMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.pubsub.v1.DeleteTopicRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_TOPIC)))
          .build();
    }
  }

  /**
   * <pre>
   * The service that an application uses to manipulate topics, and to send
   * messages to a topic.
   * </pre>
   */
  public static final class PublisherStub extends io.grpc.stub.AbstractStub<PublisherStub> {
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

    /**
     * <pre>
     * Creates the given topic with the given name.
     * </pre>
     */
    public void createTopic(com.google.pubsub.v1.Topic request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateTopicMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an existing topic. Note that certain properties of a topic are not
     * modifiable.  Options settings follow the style guide:
     * NOTE:  The style guide requires body: "topic" instead of body: "*".
     * Keeping the latter for internal consistency in V1, however it should be
     * corrected in V2.  See
     * https://cloud.google.com/apis/design/standard_methods#update for details.
     * </pre>
     */
    public void updateTopic(com.google.pubsub.v1.UpdateTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateTopicMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic
     * does not exist. The message payload must not be empty; it must contain
     *  either a non-empty data field, or at least one attribute.
     * </pre>
     */
    public void publish(com.google.pubsub.v1.PublishRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.PublishResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPublishMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the configuration of a topic.
     * </pre>
     */
    public void getTopic(com.google.pubsub.v1.GetTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTopicMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists matching topics.
     * </pre>
     */
    public void listTopics(com.google.pubsub.v1.ListTopicsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListTopicsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists the name of the subscriptions for this topic.
     * </pre>
     */
    public void listTopicSubscriptions(com.google.pubsub.v1.ListTopicSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicSubscriptionsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListTopicSubscriptionsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic
     * does not exist. After a topic is deleted, a new topic may be created with
     * the same name; this is an entirely new topic with none of the old
     * configuration or subscriptions. Existing subscriptions to this topic are
     * not deleted, but their `topic` field is set to `_deleted-topic_`.
     * </pre>
     */
    public void deleteTopic(com.google.pubsub.v1.DeleteTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteTopicMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The service that an application uses to manipulate topics, and to send
   * messages to a topic.
   * </pre>
   */
  public static final class PublisherBlockingStub extends io.grpc.stub.AbstractStub<PublisherBlockingStub> {
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

    /**
     * <pre>
     * Creates the given topic with the given name.
     * </pre>
     */
    public com.google.pubsub.v1.Topic createTopic(com.google.pubsub.v1.Topic request) {
      return blockingUnaryCall(
          getChannel(), getCreateTopicMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an existing topic. Note that certain properties of a topic are not
     * modifiable.  Options settings follow the style guide:
     * NOTE:  The style guide requires body: "topic" instead of body: "*".
     * Keeping the latter for internal consistency in V1, however it should be
     * corrected in V2.  See
     * https://cloud.google.com/apis/design/standard_methods#update for details.
     * </pre>
     */
    public com.google.pubsub.v1.Topic updateTopic(com.google.pubsub.v1.UpdateTopicRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateTopicMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic
     * does not exist. The message payload must not be empty; it must contain
     *  either a non-empty data field, or at least one attribute.
     * </pre>
     */
    public com.google.pubsub.v1.PublishResponse publish(com.google.pubsub.v1.PublishRequest request) {
      return blockingUnaryCall(
          getChannel(), getPublishMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the configuration of a topic.
     * </pre>
     */
    public com.google.pubsub.v1.Topic getTopic(com.google.pubsub.v1.GetTopicRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTopicMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists matching topics.
     * </pre>
     */
    public com.google.pubsub.v1.ListTopicsResponse listTopics(com.google.pubsub.v1.ListTopicsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListTopicsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists the name of the subscriptions for this topic.
     * </pre>
     */
    public com.google.pubsub.v1.ListTopicSubscriptionsResponse listTopicSubscriptions(com.google.pubsub.v1.ListTopicSubscriptionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListTopicSubscriptionsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic
     * does not exist. After a topic is deleted, a new topic may be created with
     * the same name; this is an entirely new topic with none of the old
     * configuration or subscriptions. Existing subscriptions to this topic are
     * not deleted, but their `topic` field is set to `_deleted-topic_`.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTopic(com.google.pubsub.v1.DeleteTopicRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteTopicMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The service that an application uses to manipulate topics, and to send
   * messages to a topic.
   * </pre>
   */
  public static final class PublisherFutureStub extends io.grpc.stub.AbstractStub<PublisherFutureStub> {
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

    /**
     * <pre>
     * Creates the given topic with the given name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Topic> createTopic(
        com.google.pubsub.v1.Topic request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateTopicMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an existing topic. Note that certain properties of a topic are not
     * modifiable.  Options settings follow the style guide:
     * NOTE:  The style guide requires body: "topic" instead of body: "*".
     * Keeping the latter for internal consistency in V1, however it should be
     * corrected in V2.  See
     * https://cloud.google.com/apis/design/standard_methods#update for details.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Topic> updateTopic(
        com.google.pubsub.v1.UpdateTopicRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateTopicMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic
     * does not exist. The message payload must not be empty; it must contain
     *  either a non-empty data field, or at least one attribute.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.PublishResponse> publish(
        com.google.pubsub.v1.PublishRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPublishMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the configuration of a topic.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Topic> getTopic(
        com.google.pubsub.v1.GetTopicRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTopicMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists matching topics.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.ListTopicsResponse> listTopics(
        com.google.pubsub.v1.ListTopicsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListTopicsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists the name of the subscriptions for this topic.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.ListTopicSubscriptionsResponse> listTopicSubscriptions(
        com.google.pubsub.v1.ListTopicSubscriptionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListTopicSubscriptionsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic
     * does not exist. After a topic is deleted, a new topic may be created with
     * the same name; this is an entirely new topic with none of the old
     * configuration or subscriptions. Existing subscriptions to this topic are
     * not deleted, but their `topic` field is set to `_deleted-topic_`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteTopic(
        com.google.pubsub.v1.DeleteTopicRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteTopicMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TOPIC = 0;
  private static final int METHODID_UPDATE_TOPIC = 1;
  private static final int METHODID_PUBLISH = 2;
  private static final int METHODID_GET_TOPIC = 3;
  private static final int METHODID_LIST_TOPICS = 4;
  private static final int METHODID_LIST_TOPIC_SUBSCRIPTIONS = 5;
  private static final int METHODID_DELETE_TOPIC = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PublisherImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PublisherImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_TOPIC:
          serviceImpl.createTopic((com.google.pubsub.v1.Topic) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic>) responseObserver);
          break;
        case METHODID_UPDATE_TOPIC:
          serviceImpl.updateTopic((com.google.pubsub.v1.UpdateTopicRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic>) responseObserver);
          break;
        case METHODID_PUBLISH:
          serviceImpl.publish((com.google.pubsub.v1.PublishRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.PublishResponse>) responseObserver);
          break;
        case METHODID_GET_TOPIC:
          serviceImpl.getTopic((com.google.pubsub.v1.GetTopicRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic>) responseObserver);
          break;
        case METHODID_LIST_TOPICS:
          serviceImpl.listTopics((com.google.pubsub.v1.ListTopicsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicsResponse>) responseObserver);
          break;
        case METHODID_LIST_TOPIC_SUBSCRIPTIONS:
          serviceImpl.listTopicSubscriptions((com.google.pubsub.v1.ListTopicSubscriptionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicSubscriptionsResponse>) responseObserver);
          break;
        case METHODID_DELETE_TOPIC:
          serviceImpl.deleteTopic((com.google.pubsub.v1.DeleteTopicRequest) request,
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

  private static abstract class PublisherBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PublisherBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.pubsub.v1.PubsubProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Publisher");
    }
  }

  private static final class PublisherFileDescriptorSupplier
      extends PublisherBaseDescriptorSupplier {
    PublisherFileDescriptorSupplier() {}
  }

  private static final class PublisherMethodDescriptorSupplier
      extends PublisherBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PublisherMethodDescriptorSupplier(String methodName) {
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
      synchronized (PublisherGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PublisherFileDescriptorSupplier())
              .addMethod(getCreateTopicMethodHelper())
              .addMethod(getUpdateTopicMethodHelper())
              .addMethod(getPublishMethodHelper())
              .addMethod(getGetTopicMethodHelper())
              .addMethod(getListTopicsMethodHelper())
              .addMethod(getListTopicSubscriptionsMethodHelper())
              .addMethod(getDeleteTopicMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
