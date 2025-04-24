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
 * The service that an application uses to manipulate topics, and to send
 * messages to a topic.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/pubsub/v1/pubsub.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PublisherGrpc {

  private PublisherGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.pubsub.v1.Publisher";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.Topic, com.google.pubsub.v1.Topic>
      getCreateTopicMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTopic",
      requestType = com.google.pubsub.v1.Topic.class,
      responseType = com.google.pubsub.v1.Topic.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.pubsub.v1.Topic, com.google.pubsub.v1.Topic>
      getCreateTopicMethod() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.Topic, com.google.pubsub.v1.Topic>
        getCreateTopicMethod;
    if ((getCreateTopicMethod = PublisherGrpc.getCreateTopicMethod) == null) {
      synchronized (PublisherGrpc.class) {
        if ((getCreateTopicMethod = PublisherGrpc.getCreateTopicMethod) == null) {
          PublisherGrpc.getCreateTopicMethod =
              getCreateTopicMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.Topic, com.google.pubsub.v1.Topic>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTopic"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.Topic.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.Topic.getDefaultInstance()))
                      .setSchemaDescriptor(new PublisherMethodDescriptorSupplier("CreateTopic"))
                      .build();
        }
      }
    }
    return getCreateTopicMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.UpdateTopicRequest, com.google.pubsub.v1.Topic>
      getUpdateTopicMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTopic",
      requestType = com.google.pubsub.v1.UpdateTopicRequest.class,
      responseType = com.google.pubsub.v1.Topic.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.UpdateTopicRequest, com.google.pubsub.v1.Topic>
      getUpdateTopicMethod() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.UpdateTopicRequest, com.google.pubsub.v1.Topic>
        getUpdateTopicMethod;
    if ((getUpdateTopicMethod = PublisherGrpc.getUpdateTopicMethod) == null) {
      synchronized (PublisherGrpc.class) {
        if ((getUpdateTopicMethod = PublisherGrpc.getUpdateTopicMethod) == null) {
          PublisherGrpc.getUpdateTopicMethod =
              getUpdateTopicMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.UpdateTopicRequest, com.google.pubsub.v1.Topic>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTopic"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.UpdateTopicRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.Topic.getDefaultInstance()))
                      .setSchemaDescriptor(new PublisherMethodDescriptorSupplier("UpdateTopic"))
                      .build();
        }
      }
    }
    return getUpdateTopicMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.PublishRequest, com.google.pubsub.v1.PublishResponse>
      getPublishMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Publish",
      requestType = com.google.pubsub.v1.PublishRequest.class,
      responseType = com.google.pubsub.v1.PublishResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.PublishRequest, com.google.pubsub.v1.PublishResponse>
      getPublishMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.PublishRequest, com.google.pubsub.v1.PublishResponse>
        getPublishMethod;
    if ((getPublishMethod = PublisherGrpc.getPublishMethod) == null) {
      synchronized (PublisherGrpc.class) {
        if ((getPublishMethod = PublisherGrpc.getPublishMethod) == null) {
          PublisherGrpc.getPublishMethod =
              getPublishMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.PublishRequest, com.google.pubsub.v1.PublishResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Publish"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.PublishRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.PublishResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new PublisherMethodDescriptorSupplier("Publish"))
                      .build();
        }
      }
    }
    return getPublishMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.GetTopicRequest, com.google.pubsub.v1.Topic>
      getGetTopicMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTopic",
      requestType = com.google.pubsub.v1.GetTopicRequest.class,
      responseType = com.google.pubsub.v1.Topic.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.GetTopicRequest, com.google.pubsub.v1.Topic>
      getGetTopicMethod() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.GetTopicRequest, com.google.pubsub.v1.Topic>
        getGetTopicMethod;
    if ((getGetTopicMethod = PublisherGrpc.getGetTopicMethod) == null) {
      synchronized (PublisherGrpc.class) {
        if ((getGetTopicMethod = PublisherGrpc.getGetTopicMethod) == null) {
          PublisherGrpc.getGetTopicMethod =
              getGetTopicMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.GetTopicRequest, com.google.pubsub.v1.Topic>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTopic"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.GetTopicRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.Topic.getDefaultInstance()))
                      .setSchemaDescriptor(new PublisherMethodDescriptorSupplier("GetTopic"))
                      .build();
        }
      }
    }
    return getGetTopicMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListTopicsRequest, com.google.pubsub.v1.ListTopicsResponse>
      getListTopicsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTopics",
      requestType = com.google.pubsub.v1.ListTopicsRequest.class,
      responseType = com.google.pubsub.v1.ListTopicsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListTopicsRequest, com.google.pubsub.v1.ListTopicsResponse>
      getListTopicsMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.ListTopicsRequest, com.google.pubsub.v1.ListTopicsResponse>
        getListTopicsMethod;
    if ((getListTopicsMethod = PublisherGrpc.getListTopicsMethod) == null) {
      synchronized (PublisherGrpc.class) {
        if ((getListTopicsMethod = PublisherGrpc.getListTopicsMethod) == null) {
          PublisherGrpc.getListTopicsMethod =
              getListTopicsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.ListTopicsRequest,
                          com.google.pubsub.v1.ListTopicsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTopics"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.ListTopicsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.ListTopicsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new PublisherMethodDescriptorSupplier("ListTopics"))
                      .build();
        }
      }
    }
    return getListTopicsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListTopicSubscriptionsRequest,
          com.google.pubsub.v1.ListTopicSubscriptionsResponse>
      getListTopicSubscriptionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTopicSubscriptions",
      requestType = com.google.pubsub.v1.ListTopicSubscriptionsRequest.class,
      responseType = com.google.pubsub.v1.ListTopicSubscriptionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListTopicSubscriptionsRequest,
          com.google.pubsub.v1.ListTopicSubscriptionsResponse>
      getListTopicSubscriptionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.ListTopicSubscriptionsRequest,
            com.google.pubsub.v1.ListTopicSubscriptionsResponse>
        getListTopicSubscriptionsMethod;
    if ((getListTopicSubscriptionsMethod = PublisherGrpc.getListTopicSubscriptionsMethod) == null) {
      synchronized (PublisherGrpc.class) {
        if ((getListTopicSubscriptionsMethod = PublisherGrpc.getListTopicSubscriptionsMethod)
            == null) {
          PublisherGrpc.getListTopicSubscriptionsMethod =
              getListTopicSubscriptionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.ListTopicSubscriptionsRequest,
                          com.google.pubsub.v1.ListTopicSubscriptionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListTopicSubscriptions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.ListTopicSubscriptionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.ListTopicSubscriptionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PublisherMethodDescriptorSupplier("ListTopicSubscriptions"))
                      .build();
        }
      }
    }
    return getListTopicSubscriptionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListTopicSnapshotsRequest,
          com.google.pubsub.v1.ListTopicSnapshotsResponse>
      getListTopicSnapshotsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTopicSnapshots",
      requestType = com.google.pubsub.v1.ListTopicSnapshotsRequest.class,
      responseType = com.google.pubsub.v1.ListTopicSnapshotsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListTopicSnapshotsRequest,
          com.google.pubsub.v1.ListTopicSnapshotsResponse>
      getListTopicSnapshotsMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.ListTopicSnapshotsRequest,
            com.google.pubsub.v1.ListTopicSnapshotsResponse>
        getListTopicSnapshotsMethod;
    if ((getListTopicSnapshotsMethod = PublisherGrpc.getListTopicSnapshotsMethod) == null) {
      synchronized (PublisherGrpc.class) {
        if ((getListTopicSnapshotsMethod = PublisherGrpc.getListTopicSnapshotsMethod) == null) {
          PublisherGrpc.getListTopicSnapshotsMethod =
              getListTopicSnapshotsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.ListTopicSnapshotsRequest,
                          com.google.pubsub.v1.ListTopicSnapshotsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTopicSnapshots"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.ListTopicSnapshotsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.ListTopicSnapshotsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PublisherMethodDescriptorSupplier("ListTopicSnapshots"))
                      .build();
        }
      }
    }
    return getListTopicSnapshotsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.DeleteTopicRequest, com.google.protobuf.Empty>
      getDeleteTopicMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTopic",
      requestType = com.google.pubsub.v1.DeleteTopicRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.DeleteTopicRequest, com.google.protobuf.Empty>
      getDeleteTopicMethod() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.DeleteTopicRequest, com.google.protobuf.Empty>
        getDeleteTopicMethod;
    if ((getDeleteTopicMethod = PublisherGrpc.getDeleteTopicMethod) == null) {
      synchronized (PublisherGrpc.class) {
        if ((getDeleteTopicMethod = PublisherGrpc.getDeleteTopicMethod) == null) {
          PublisherGrpc.getDeleteTopicMethod =
              getDeleteTopicMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.DeleteTopicRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTopic"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.DeleteTopicRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new PublisherMethodDescriptorSupplier("DeleteTopic"))
                      .build();
        }
      }
    }
    return getDeleteTopicMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.DetachSubscriptionRequest,
          com.google.pubsub.v1.DetachSubscriptionResponse>
      getDetachSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DetachSubscription",
      requestType = com.google.pubsub.v1.DetachSubscriptionRequest.class,
      responseType = com.google.pubsub.v1.DetachSubscriptionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.DetachSubscriptionRequest,
          com.google.pubsub.v1.DetachSubscriptionResponse>
      getDetachSubscriptionMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.DetachSubscriptionRequest,
            com.google.pubsub.v1.DetachSubscriptionResponse>
        getDetachSubscriptionMethod;
    if ((getDetachSubscriptionMethod = PublisherGrpc.getDetachSubscriptionMethod) == null) {
      synchronized (PublisherGrpc.class) {
        if ((getDetachSubscriptionMethod = PublisherGrpc.getDetachSubscriptionMethod) == null) {
          PublisherGrpc.getDetachSubscriptionMethod =
              getDetachSubscriptionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.DetachSubscriptionRequest,
                          com.google.pubsub.v1.DetachSubscriptionResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DetachSubscription"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.DetachSubscriptionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.DetachSubscriptionResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PublisherMethodDescriptorSupplier("DetachSubscription"))
                      .build();
        }
      }
    }
    return getDetachSubscriptionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static PublisherStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PublisherStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PublisherStub>() {
          @java.lang.Override
          public PublisherStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PublisherStub(channel, callOptions);
          }
        };
    return PublisherStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static PublisherBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PublisherBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PublisherBlockingV2Stub>() {
          @java.lang.Override
          public PublisherBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PublisherBlockingV2Stub(channel, callOptions);
          }
        };
    return PublisherBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PublisherBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PublisherBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PublisherBlockingStub>() {
          @java.lang.Override
          public PublisherBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PublisherBlockingStub(channel, callOptions);
          }
        };
    return PublisherBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static PublisherFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PublisherFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PublisherFutureStub>() {
          @java.lang.Override
          public PublisherFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PublisherFutureStub(channel, callOptions);
          }
        };
    return PublisherFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The service that an application uses to manipulate topics, and to send
   * messages to a topic.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates the given topic with the given name. See the [resource name rules]
     * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
     * </pre>
     */
    default void createTopic(
        com.google.pubsub.v1.Topic request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTopicMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing topic by updating the fields specified in the update
     * mask. Note that certain properties of a topic are not modifiable.
     * </pre>
     */
    default void updateTopic(
        com.google.pubsub.v1.UpdateTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTopicMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic
     * does not exist.
     * </pre>
     */
    default void publish(
        com.google.pubsub.v1.PublishRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.PublishResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPublishMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the configuration of a topic.
     * </pre>
     */
    default void getTopic(
        com.google.pubsub.v1.GetTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTopicMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists matching topics.
     * </pre>
     */
    default void listTopics(
        com.google.pubsub.v1.ListTopicsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTopicsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the names of the attached subscriptions on this topic.
     * </pre>
     */
    default void listTopicSubscriptions(
        com.google.pubsub.v1.ListTopicSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicSubscriptionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTopicSubscriptionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the names of the snapshots on this topic. Snapshots are used in
     * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations,
     * which allow you to manage message acknowledgments in bulk. That is, you can
     * set the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * </pre>
     */
    default void listTopicSnapshots(
        com.google.pubsub.v1.ListTopicSnapshotsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicSnapshotsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTopicSnapshotsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic
     * does not exist. After a topic is deleted, a new topic may be created with
     * the same name; this is an entirely new topic with none of the old
     * configuration or subscriptions. Existing subscriptions to this topic are
     * not deleted, but their `topic` field is set to `_deleted-topic_`.
     * </pre>
     */
    default void deleteTopic(
        com.google.pubsub.v1.DeleteTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTopicMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Detaches a subscription from this topic. All messages retained in the
     * subscription are dropped. Subsequent `Pull` and `StreamingPull` requests
     * will return FAILED_PRECONDITION. If the subscription is a push
     * subscription, pushes to the endpoint will stop.
     * </pre>
     */
    default void detachSubscription(
        com.google.pubsub.v1.DetachSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.DetachSubscriptionResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDetachSubscriptionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Publisher.
   *
   * <pre>
   * The service that an application uses to manipulate topics, and to send
   * messages to a topic.
   * </pre>
   */
  public abstract static class PublisherImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return PublisherGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Publisher.
   *
   * <pre>
   * The service that an application uses to manipulate topics, and to send
   * messages to a topic.
   * </pre>
   */
  public static final class PublisherStub extends io.grpc.stub.AbstractAsyncStub<PublisherStub> {
    private PublisherStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PublisherStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PublisherStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates the given topic with the given name. See the [resource name rules]
     * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
     * </pre>
     */
    public void createTopic(
        com.google.pubsub.v1.Topic request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTopicMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing topic by updating the fields specified in the update
     * mask. Note that certain properties of a topic are not modifiable.
     * </pre>
     */
    public void updateTopic(
        com.google.pubsub.v1.UpdateTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTopicMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic
     * does not exist.
     * </pre>
     */
    public void publish(
        com.google.pubsub.v1.PublishRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.PublishResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPublishMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the configuration of a topic.
     * </pre>
     */
    public void getTopic(
        com.google.pubsub.v1.GetTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTopicMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists matching topics.
     * </pre>
     */
    public void listTopics(
        com.google.pubsub.v1.ListTopicsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTopicsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the names of the attached subscriptions on this topic.
     * </pre>
     */
    public void listTopicSubscriptions(
        com.google.pubsub.v1.ListTopicSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicSubscriptionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTopicSubscriptionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the names of the snapshots on this topic. Snapshots are used in
     * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations,
     * which allow you to manage message acknowledgments in bulk. That is, you can
     * set the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * </pre>
     */
    public void listTopicSnapshots(
        com.google.pubsub.v1.ListTopicSnapshotsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicSnapshotsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTopicSnapshotsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic
     * does not exist. After a topic is deleted, a new topic may be created with
     * the same name; this is an entirely new topic with none of the old
     * configuration or subscriptions. Existing subscriptions to this topic are
     * not deleted, but their `topic` field is set to `_deleted-topic_`.
     * </pre>
     */
    public void deleteTopic(
        com.google.pubsub.v1.DeleteTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTopicMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Detaches a subscription from this topic. All messages retained in the
     * subscription are dropped. Subsequent `Pull` and `StreamingPull` requests
     * will return FAILED_PRECONDITION. If the subscription is a push
     * subscription, pushes to the endpoint will stop.
     * </pre>
     */
    public void detachSubscription(
        com.google.pubsub.v1.DetachSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.DetachSubscriptionResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDetachSubscriptionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Publisher.
   *
   * <pre>
   * The service that an application uses to manipulate topics, and to send
   * messages to a topic.
   * </pre>
   */
  public static final class PublisherBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<PublisherBlockingV2Stub> {
    private PublisherBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PublisherBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PublisherBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates the given topic with the given name. See the [resource name rules]
     * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
     * </pre>
     */
    public com.google.pubsub.v1.Topic createTopic(com.google.pubsub.v1.Topic request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTopicMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing topic by updating the fields specified in the update
     * mask. Note that certain properties of a topic are not modifiable.
     * </pre>
     */
    public com.google.pubsub.v1.Topic updateTopic(com.google.pubsub.v1.UpdateTopicRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTopicMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic
     * does not exist.
     * </pre>
     */
    public com.google.pubsub.v1.PublishResponse publish(
        com.google.pubsub.v1.PublishRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPublishMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the configuration of a topic.
     * </pre>
     */
    public com.google.pubsub.v1.Topic getTopic(com.google.pubsub.v1.GetTopicRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTopicMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists matching topics.
     * </pre>
     */
    public com.google.pubsub.v1.ListTopicsResponse listTopics(
        com.google.pubsub.v1.ListTopicsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTopicsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the names of the attached subscriptions on this topic.
     * </pre>
     */
    public com.google.pubsub.v1.ListTopicSubscriptionsResponse listTopicSubscriptions(
        com.google.pubsub.v1.ListTopicSubscriptionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTopicSubscriptionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the names of the snapshots on this topic. Snapshots are used in
     * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations,
     * which allow you to manage message acknowledgments in bulk. That is, you can
     * set the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * </pre>
     */
    public com.google.pubsub.v1.ListTopicSnapshotsResponse listTopicSnapshots(
        com.google.pubsub.v1.ListTopicSnapshotsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTopicSnapshotsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic
     * does not exist. After a topic is deleted, a new topic may be created with
     * the same name; this is an entirely new topic with none of the old
     * configuration or subscriptions. Existing subscriptions to this topic are
     * not deleted, but their `topic` field is set to `_deleted-topic_`.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTopic(com.google.pubsub.v1.DeleteTopicRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTopicMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Detaches a subscription from this topic. All messages retained in the
     * subscription are dropped. Subsequent `Pull` and `StreamingPull` requests
     * will return FAILED_PRECONDITION. If the subscription is a push
     * subscription, pushes to the endpoint will stop.
     * </pre>
     */
    public com.google.pubsub.v1.DetachSubscriptionResponse detachSubscription(
        com.google.pubsub.v1.DetachSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDetachSubscriptionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Publisher.
   *
   * <pre>
   * The service that an application uses to manipulate topics, and to send
   * messages to a topic.
   * </pre>
   */
  public static final class PublisherBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PublisherBlockingStub> {
    private PublisherBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PublisherBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PublisherBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates the given topic with the given name. See the [resource name rules]
     * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
     * </pre>
     */
    public com.google.pubsub.v1.Topic createTopic(com.google.pubsub.v1.Topic request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTopicMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing topic by updating the fields specified in the update
     * mask. Note that certain properties of a topic are not modifiable.
     * </pre>
     */
    public com.google.pubsub.v1.Topic updateTopic(com.google.pubsub.v1.UpdateTopicRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTopicMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic
     * does not exist.
     * </pre>
     */
    public com.google.pubsub.v1.PublishResponse publish(
        com.google.pubsub.v1.PublishRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPublishMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the configuration of a topic.
     * </pre>
     */
    public com.google.pubsub.v1.Topic getTopic(com.google.pubsub.v1.GetTopicRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTopicMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists matching topics.
     * </pre>
     */
    public com.google.pubsub.v1.ListTopicsResponse listTopics(
        com.google.pubsub.v1.ListTopicsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTopicsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the names of the attached subscriptions on this topic.
     * </pre>
     */
    public com.google.pubsub.v1.ListTopicSubscriptionsResponse listTopicSubscriptions(
        com.google.pubsub.v1.ListTopicSubscriptionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTopicSubscriptionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the names of the snapshots on this topic. Snapshots are used in
     * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations,
     * which allow you to manage message acknowledgments in bulk. That is, you can
     * set the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * </pre>
     */
    public com.google.pubsub.v1.ListTopicSnapshotsResponse listTopicSnapshots(
        com.google.pubsub.v1.ListTopicSnapshotsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTopicSnapshotsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic
     * does not exist. After a topic is deleted, a new topic may be created with
     * the same name; this is an entirely new topic with none of the old
     * configuration or subscriptions. Existing subscriptions to this topic are
     * not deleted, but their `topic` field is set to `_deleted-topic_`.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTopic(com.google.pubsub.v1.DeleteTopicRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTopicMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Detaches a subscription from this topic. All messages retained in the
     * subscription are dropped. Subsequent `Pull` and `StreamingPull` requests
     * will return FAILED_PRECONDITION. If the subscription is a push
     * subscription, pushes to the endpoint will stop.
     * </pre>
     */
    public com.google.pubsub.v1.DetachSubscriptionResponse detachSubscription(
        com.google.pubsub.v1.DetachSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDetachSubscriptionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Publisher.
   *
   * <pre>
   * The service that an application uses to manipulate topics, and to send
   * messages to a topic.
   * </pre>
   */
  public static final class PublisherFutureStub
      extends io.grpc.stub.AbstractFutureStub<PublisherFutureStub> {
    private PublisherFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PublisherFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PublisherFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates the given topic with the given name. See the [resource name rules]
     * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Topic>
        createTopic(com.google.pubsub.v1.Topic request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTopicMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing topic by updating the fields specified in the update
     * mask. Note that certain properties of a topic are not modifiable.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Topic>
        updateTopic(com.google.pubsub.v1.UpdateTopicRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTopicMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic
     * does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.PublishResponse>
        publish(com.google.pubsub.v1.PublishRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPublishMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the configuration of a topic.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Topic> getTopic(
        com.google.pubsub.v1.GetTopicRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTopicMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists matching topics.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.pubsub.v1.ListTopicsResponse>
        listTopics(com.google.pubsub.v1.ListTopicsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTopicsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the names of the attached subscriptions on this topic.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.pubsub.v1.ListTopicSubscriptionsResponse>
        listTopicSubscriptions(com.google.pubsub.v1.ListTopicSubscriptionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTopicSubscriptionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the names of the snapshots on this topic. Snapshots are used in
     * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations,
     * which allow you to manage message acknowledgments in bulk. That is, you can
     * set the acknowledgment state of messages in an existing subscription to the
     * state captured by a snapshot.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.pubsub.v1.ListTopicSnapshotsResponse>
        listTopicSnapshots(com.google.pubsub.v1.ListTopicSnapshotsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTopicSnapshotsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic
     * does not exist. After a topic is deleted, a new topic may be created with
     * the same name; this is an entirely new topic with none of the old
     * configuration or subscriptions. Existing subscriptions to this topic are
     * not deleted, but their `topic` field is set to `_deleted-topic_`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteTopic(com.google.pubsub.v1.DeleteTopicRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTopicMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Detaches a subscription from this topic. All messages retained in the
     * subscription are dropped. Subsequent `Pull` and `StreamingPull` requests
     * will return FAILED_PRECONDITION. If the subscription is a push
     * subscription, pushes to the endpoint will stop.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.pubsub.v1.DetachSubscriptionResponse>
        detachSubscription(com.google.pubsub.v1.DetachSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDetachSubscriptionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TOPIC = 0;
  private static final int METHODID_UPDATE_TOPIC = 1;
  private static final int METHODID_PUBLISH = 2;
  private static final int METHODID_GET_TOPIC = 3;
  private static final int METHODID_LIST_TOPICS = 4;
  private static final int METHODID_LIST_TOPIC_SUBSCRIPTIONS = 5;
  private static final int METHODID_LIST_TOPIC_SNAPSHOTS = 6;
  private static final int METHODID_DELETE_TOPIC = 7;
  private static final int METHODID_DETACH_SUBSCRIPTION = 8;

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
        case METHODID_CREATE_TOPIC:
          serviceImpl.createTopic(
              (com.google.pubsub.v1.Topic) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic>) responseObserver);
          break;
        case METHODID_UPDATE_TOPIC:
          serviceImpl.updateTopic(
              (com.google.pubsub.v1.UpdateTopicRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic>) responseObserver);
          break;
        case METHODID_PUBLISH:
          serviceImpl.publish(
              (com.google.pubsub.v1.PublishRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.PublishResponse>) responseObserver);
          break;
        case METHODID_GET_TOPIC:
          serviceImpl.getTopic(
              (com.google.pubsub.v1.GetTopicRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.Topic>) responseObserver);
          break;
        case METHODID_LIST_TOPICS:
          serviceImpl.listTopics(
              (com.google.pubsub.v1.ListTopicsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_TOPIC_SUBSCRIPTIONS:
          serviceImpl.listTopicSubscriptions(
              (com.google.pubsub.v1.ListTopicSubscriptionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicSubscriptionsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_TOPIC_SNAPSHOTS:
          serviceImpl.listTopicSnapshots(
              (com.google.pubsub.v1.ListTopicSnapshotsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListTopicSnapshotsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_TOPIC:
          serviceImpl.deleteTopic(
              (com.google.pubsub.v1.DeleteTopicRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DETACH_SUBSCRIPTION:
          serviceImpl.detachSubscription(
              (com.google.pubsub.v1.DetachSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.DetachSubscriptionResponse>)
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
            getCreateTopicMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.pubsub.v1.Topic, com.google.pubsub.v1.Topic>(
                    service, METHODID_CREATE_TOPIC)))
        .addMethod(
            getUpdateTopicMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.UpdateTopicRequest, com.google.pubsub.v1.Topic>(
                    service, METHODID_UPDATE_TOPIC)))
        .addMethod(
            getPublishMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.PublishRequest, com.google.pubsub.v1.PublishResponse>(
                    service, METHODID_PUBLISH)))
        .addMethod(
            getGetTopicMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.GetTopicRequest, com.google.pubsub.v1.Topic>(
                    service, METHODID_GET_TOPIC)))
        .addMethod(
            getListTopicsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.ListTopicsRequest,
                    com.google.pubsub.v1.ListTopicsResponse>(service, METHODID_LIST_TOPICS)))
        .addMethod(
            getListTopicSubscriptionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.ListTopicSubscriptionsRequest,
                    com.google.pubsub.v1.ListTopicSubscriptionsResponse>(
                    service, METHODID_LIST_TOPIC_SUBSCRIPTIONS)))
        .addMethod(
            getListTopicSnapshotsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.ListTopicSnapshotsRequest,
                    com.google.pubsub.v1.ListTopicSnapshotsResponse>(
                    service, METHODID_LIST_TOPIC_SNAPSHOTS)))
        .addMethod(
            getDeleteTopicMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.DeleteTopicRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_TOPIC)))
        .addMethod(
            getDetachSubscriptionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.DetachSubscriptionRequest,
                    com.google.pubsub.v1.DetachSubscriptionResponse>(
                    service, METHODID_DETACH_SUBSCRIPTION)))
        .build();
  }

  private abstract static class PublisherBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
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
    private final java.lang.String methodName;

    PublisherMethodDescriptorSupplier(java.lang.String methodName) {
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
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new PublisherFileDescriptorSupplier())
                      .addMethod(getCreateTopicMethod())
                      .addMethod(getUpdateTopicMethod())
                      .addMethod(getPublishMethod())
                      .addMethod(getGetTopicMethod())
                      .addMethod(getListTopicsMethod())
                      .addMethod(getListTopicSubscriptionsMethod())
                      .addMethod(getListTopicSnapshotsMethod())
                      .addMethod(getDeleteTopicMethod())
                      .addMethod(getDetachSubscriptionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
