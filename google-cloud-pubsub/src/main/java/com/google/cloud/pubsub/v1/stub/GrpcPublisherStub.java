/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.pubsub.v1.stub;

import static com.google.cloud.pubsub.v1.PagedResponseWrappers.ListTopicSubscriptionsPagedResponse;
import static com.google.cloud.pubsub.v1.PagedResponseWrappers.ListTopicsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.pubsub.v1.TopicAdminSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.DeleteTopicRequest;
import com.google.pubsub.v1.GetTopicRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ListTopicsResponse;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.UpdateTopicRequest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Google Cloud Pub/Sub API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class GrpcPublisherStub extends PublisherStub {
  private static final UnaryCallable<Topic, Topic> directCreateTopicCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.pubsub.v1.Publisher/CreateTopic",
              io.grpc.protobuf.ProtoUtils.marshaller(Topic.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Topic.getDefaultInstance())));
  private static final UnaryCallable<UpdateTopicRequest, Topic> directUpdateTopicCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.pubsub.v1.Publisher/UpdateTopic",
              io.grpc.protobuf.ProtoUtils.marshaller(UpdateTopicRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Topic.getDefaultInstance())));
  private static final UnaryCallable<PublishRequest, PublishResponse> directPublishCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.pubsub.v1.Publisher/Publish",
              io.grpc.protobuf.ProtoUtils.marshaller(PublishRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(PublishResponse.getDefaultInstance())));
  private static final UnaryCallable<GetTopicRequest, Topic> directGetTopicCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.pubsub.v1.Publisher/GetTopic",
              io.grpc.protobuf.ProtoUtils.marshaller(GetTopicRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Topic.getDefaultInstance())));
  private static final UnaryCallable<ListTopicsRequest, ListTopicsResponse>
      directListTopicsCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.pubsub.v1.Publisher/ListTopics",
                  io.grpc.protobuf.ProtoUtils.marshaller(ListTopicsRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(ListTopicsResponse.getDefaultInstance())));
  private static final UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
      directListTopicSubscriptionsCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.pubsub.v1.Publisher/ListTopicSubscriptions",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListTopicSubscriptionsRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListTopicSubscriptionsResponse.getDefaultInstance())));
  private static final UnaryCallable<DeleteTopicRequest, Empty> directDeleteTopicCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.pubsub.v1.Publisher/DeleteTopic",
              io.grpc.protobuf.ProtoUtils.marshaller(DeleteTopicRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Empty.getDefaultInstance())));
  private static final UnaryCallable<SetIamPolicyRequest, Policy> directSetIamPolicyCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.iam.v1.IAMPolicy/SetIamPolicy",
              io.grpc.protobuf.ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Policy.getDefaultInstance())));
  private static final UnaryCallable<GetIamPolicyRequest, Policy> directGetIamPolicyCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.iam.v1.IAMPolicy/GetIamPolicy",
              io.grpc.protobuf.ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Policy.getDefaultInstance())));
  private static final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      directTestIamPermissionsCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.iam.v1.IAMPolicy/TestIamPermissions",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      TestIamPermissionsRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      TestIamPermissionsResponse.getDefaultInstance())));

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<Topic, Topic> createTopicCallable;
  private final UnaryCallable<UpdateTopicRequest, Topic> updateTopicCallable;
  private final UnaryCallable<PublishRequest, PublishResponse> publishCallable;
  private final UnaryCallable<GetTopicRequest, Topic> getTopicCallable;
  private final UnaryCallable<ListTopicsRequest, ListTopicsResponse> listTopicsCallable;
  private final UnaryCallable<ListTopicsRequest, ListTopicsPagedResponse> listTopicsPagedCallable;
  private final UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
      listTopicSubscriptionsCallable;
  private final UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsPagedResponse>
      listTopicSubscriptionsPagedCallable;
  private final UnaryCallable<DeleteTopicRequest, Empty> deleteTopicCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  public static final GrpcPublisherStub create(TopicAdminSettings settings) throws IOException {
    return new GrpcPublisherStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPublisherStub create(ClientContext clientContext) throws IOException {
    return new GrpcPublisherStub(TopicAdminSettings.newBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcPublisherStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPublisherStub(TopicAdminSettings settings, ClientContext clientContext)
      throws IOException {

    this.createTopicCallable =
        GrpcCallableFactory.create(
            directCreateTopicCallable, settings.createTopicSettings(), clientContext);
    this.updateTopicCallable =
        GrpcCallableFactory.create(
            directUpdateTopicCallable, settings.updateTopicSettings(), clientContext);
    this.publishCallable =
        GrpcCallableFactory.create(
            directPublishCallable, settings.publishSettings(), clientContext);
    this.getTopicCallable =
        GrpcCallableFactory.create(
            directGetTopicCallable, settings.getTopicSettings(), clientContext);
    this.listTopicsCallable =
        GrpcCallableFactory.create(
            directListTopicsCallable, settings.listTopicsSettings(), clientContext);
    this.listTopicsPagedCallable =
        GrpcCallableFactory.createPagedVariant(
            directListTopicsCallable, settings.listTopicsSettings(), clientContext);
    this.listTopicSubscriptionsCallable =
        GrpcCallableFactory.create(
            directListTopicSubscriptionsCallable,
            settings.listTopicSubscriptionsSettings(),
            clientContext);
    this.listTopicSubscriptionsPagedCallable =
        GrpcCallableFactory.createPagedVariant(
            directListTopicSubscriptionsCallable,
            settings.listTopicSubscriptionsSettings(),
            clientContext);
    this.deleteTopicCallable =
        GrpcCallableFactory.create(
            directDeleteTopicCallable, settings.deleteTopicSettings(), clientContext);
    this.setIamPolicyCallable =
        GrpcCallableFactory.create(
            directSetIamPolicyCallable, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        GrpcCallableFactory.create(
            directGetIamPolicyCallable, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        GrpcCallableFactory.create(
            directTestIamPermissionsCallable, settings.testIamPermissionsSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<Topic, Topic> createTopicCallable() {
    return createTopicCallable;
  }

  public UnaryCallable<UpdateTopicRequest, Topic> updateTopicCallable() {
    return updateTopicCallable;
  }

  public UnaryCallable<PublishRequest, PublishResponse> publishCallable() {
    return publishCallable;
  }

  public UnaryCallable<GetTopicRequest, Topic> getTopicCallable() {
    return getTopicCallable;
  }

  public UnaryCallable<ListTopicsRequest, ListTopicsPagedResponse> listTopicsPagedCallable() {
    return listTopicsPagedCallable;
  }

  public UnaryCallable<ListTopicsRequest, ListTopicsResponse> listTopicsCallable() {
    return listTopicsCallable;
  }

  public UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsPagedResponse>
      listTopicSubscriptionsPagedCallable() {
    return listTopicSubscriptionsPagedCallable;
  }

  public UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
      listTopicSubscriptionsCallable() {
    return listTopicSubscriptionsCallable;
  }

  public UnaryCallable<DeleteTopicRequest, Empty> deleteTopicCallable() {
    return deleteTopicCallable;
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public final void close() throws Exception {
    shutdown();
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
