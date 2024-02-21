/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.pubsub.v1.stub;

import static com.google.cloud.pubsub.v1.TopicAdminClient.ListTopicSnapshotsPagedResponse;
import static com.google.cloud.pubsub.v1.TopicAdminClient.ListTopicSubscriptionsPagedResponse;
import static com.google.cloud.pubsub.v1.TopicAdminClient.ListTopicsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.DeleteTopicRequest;
import com.google.pubsub.v1.DetachSubscriptionRequest;
import com.google.pubsub.v1.DetachSubscriptionResponse;
import com.google.pubsub.v1.GetTopicRequest;
import com.google.pubsub.v1.ListTopicSnapshotsRequest;
import com.google.pubsub.v1.ListTopicSnapshotsResponse;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ListTopicsResponse;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.UpdateTopicRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Publisher service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcPublisherStub extends PublisherStub {
  private static final MethodDescriptor<Topic, Topic> createTopicMethodDescriptor =
      MethodDescriptor.<Topic, Topic>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.pubsub.v1.Publisher/CreateTopic")
          .setRequestMarshaller(ProtoUtils.marshaller(Topic.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Topic.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateTopicRequest, Topic> updateTopicMethodDescriptor =
      MethodDescriptor.<UpdateTopicRequest, Topic>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.pubsub.v1.Publisher/UpdateTopic")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateTopicRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Topic.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<PublishRequest, PublishResponse> publishMethodDescriptor =
      MethodDescriptor.<PublishRequest, PublishResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.pubsub.v1.Publisher/Publish")
          .setRequestMarshaller(ProtoUtils.marshaller(PublishRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(PublishResponse.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetTopicRequest, Topic> getTopicMethodDescriptor =
      MethodDescriptor.<GetTopicRequest, Topic>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.pubsub.v1.Publisher/GetTopic")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTopicRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Topic.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListTopicsRequest, ListTopicsResponse>
      listTopicsMethodDescriptor =
          MethodDescriptor.<ListTopicsRequest, ListTopicsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.Publisher/ListTopics")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTopicsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListTopicsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
      listTopicSubscriptionsMethodDescriptor =
          MethodDescriptor
              .<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.Publisher/ListTopicSubscriptions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTopicSubscriptionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTopicSubscriptionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTopicSnapshotsRequest, ListTopicSnapshotsResponse>
      listTopicSnapshotsMethodDescriptor =
          MethodDescriptor.<ListTopicSnapshotsRequest, ListTopicSnapshotsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.Publisher/ListTopicSnapshots")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTopicSnapshotsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTopicSnapshotsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTopicRequest, Empty> deleteTopicMethodDescriptor =
      MethodDescriptor.<DeleteTopicRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.pubsub.v1.Publisher/DeleteTopic")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteTopicRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DetachSubscriptionRequest, DetachSubscriptionResponse>
      detachSubscriptionMethodDescriptor =
          MethodDescriptor.<DetachSubscriptionRequest, DetachSubscriptionResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.Publisher/DetachSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DetachSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DetachSubscriptionResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

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
  private final UnaryCallable<ListTopicSnapshotsRequest, ListTopicSnapshotsResponse>
      listTopicSnapshotsCallable;
  private final UnaryCallable<ListTopicSnapshotsRequest, ListTopicSnapshotsPagedResponse>
      listTopicSnapshotsPagedCallable;
  private final UnaryCallable<DeleteTopicRequest, Empty> deleteTopicCallable;
  private final UnaryCallable<DetachSubscriptionRequest, DetachSubscriptionResponse>
      detachSubscriptionCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPublisherStub create(PublisherStubSettings settings) throws IOException {
    return new GrpcPublisherStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPublisherStub create(ClientContext clientContext) throws IOException {
    return new GrpcPublisherStub(PublisherStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPublisherStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPublisherStub(
        PublisherStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPublisherStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPublisherStub(PublisherStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcPublisherCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPublisherStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPublisherStub(
      PublisherStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<Topic, Topic> createTopicTransportSettings =
        GrpcCallSettings.<Topic, Topic>newBuilder()
            .setMethodDescriptor(createTopicMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateTopicRequest, Topic> updateTopicTransportSettings =
        GrpcCallSettings.<UpdateTopicRequest, Topic>newBuilder()
            .setMethodDescriptor(updateTopicMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("topic.name", String.valueOf(request.getTopic().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<PublishRequest, PublishResponse> publishTransportSettings =
        GrpcCallSettings.<PublishRequest, PublishResponse>newBuilder()
            .setMethodDescriptor(publishMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("topic", String.valueOf(request.getTopic()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetTopicRequest, Topic> getTopicTransportSettings =
        GrpcCallSettings.<GetTopicRequest, Topic>newBuilder()
            .setMethodDescriptor(getTopicMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("topic", String.valueOf(request.getTopic()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListTopicsRequest, ListTopicsResponse> listTopicsTransportSettings =
        GrpcCallSettings.<ListTopicsRequest, ListTopicsResponse>newBuilder()
            .setMethodDescriptor(listTopicsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
        listTopicSubscriptionsTransportSettings =
            GrpcCallSettings
                .<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>newBuilder()
                .setMethodDescriptor(listTopicSubscriptionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("topic", String.valueOf(request.getTopic()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListTopicSnapshotsRequest, ListTopicSnapshotsResponse>
        listTopicSnapshotsTransportSettings =
            GrpcCallSettings.<ListTopicSnapshotsRequest, ListTopicSnapshotsResponse>newBuilder()
                .setMethodDescriptor(listTopicSnapshotsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("topic", String.valueOf(request.getTopic()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteTopicRequest, Empty> deleteTopicTransportSettings =
        GrpcCallSettings.<DeleteTopicRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTopicMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("topic", String.valueOf(request.getTopic()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DetachSubscriptionRequest, DetachSubscriptionResponse>
        detachSubscriptionTransportSettings =
            GrpcCallSettings.<DetachSubscriptionRequest, DetachSubscriptionResponse>newBuilder()
                .setMethodDescriptor(detachSubscriptionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("subscription", String.valueOf(request.getSubscription()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.createTopicCallable =
        callableFactory.createUnaryCallable(
            createTopicTransportSettings, settings.createTopicSettings(), clientContext);
    this.updateTopicCallable =
        callableFactory.createUnaryCallable(
            updateTopicTransportSettings, settings.updateTopicSettings(), clientContext);
    this.publishCallable =
        callableFactory.createBatchingCallable(
            publishTransportSettings, settings.publishSettings(), clientContext);
    this.getTopicCallable =
        callableFactory.createUnaryCallable(
            getTopicTransportSettings, settings.getTopicSettings(), clientContext);
    this.listTopicsCallable =
        callableFactory.createUnaryCallable(
            listTopicsTransportSettings, settings.listTopicsSettings(), clientContext);
    this.listTopicsPagedCallable =
        callableFactory.createPagedCallable(
            listTopicsTransportSettings, settings.listTopicsSettings(), clientContext);
    this.listTopicSubscriptionsCallable =
        callableFactory.createUnaryCallable(
            listTopicSubscriptionsTransportSettings,
            settings.listTopicSubscriptionsSettings(),
            clientContext);
    this.listTopicSubscriptionsPagedCallable =
        callableFactory.createPagedCallable(
            listTopicSubscriptionsTransportSettings,
            settings.listTopicSubscriptionsSettings(),
            clientContext);
    this.listTopicSnapshotsCallable =
        callableFactory.createUnaryCallable(
            listTopicSnapshotsTransportSettings,
            settings.listTopicSnapshotsSettings(),
            clientContext);
    this.listTopicSnapshotsPagedCallable =
        callableFactory.createPagedCallable(
            listTopicSnapshotsTransportSettings,
            settings.listTopicSnapshotsSettings(),
            clientContext);
    this.deleteTopicCallable =
        callableFactory.createUnaryCallable(
            deleteTopicTransportSettings, settings.deleteTopicSettings(), clientContext);
    this.detachSubscriptionCallable =
        callableFactory.createUnaryCallable(
            detachSubscriptionTransportSettings,
            settings.detachSubscriptionSettings(),
            clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<Topic, Topic> createTopicCallable() {
    return createTopicCallable;
  }

  @Override
  public UnaryCallable<UpdateTopicRequest, Topic> updateTopicCallable() {
    return updateTopicCallable;
  }

  @Override
  public UnaryCallable<PublishRequest, PublishResponse> publishCallable() {
    return publishCallable;
  }

  @Override
  public UnaryCallable<GetTopicRequest, Topic> getTopicCallable() {
    return getTopicCallable;
  }

  @Override
  public UnaryCallable<ListTopicsRequest, ListTopicsResponse> listTopicsCallable() {
    return listTopicsCallable;
  }

  @Override
  public UnaryCallable<ListTopicsRequest, ListTopicsPagedResponse> listTopicsPagedCallable() {
    return listTopicsPagedCallable;
  }

  @Override
  public UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
      listTopicSubscriptionsCallable() {
    return listTopicSubscriptionsCallable;
  }

  @Override
  public UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsPagedResponse>
      listTopicSubscriptionsPagedCallable() {
    return listTopicSubscriptionsPagedCallable;
  }

  @Override
  public UnaryCallable<ListTopicSnapshotsRequest, ListTopicSnapshotsResponse>
      listTopicSnapshotsCallable() {
    return listTopicSnapshotsCallable;
  }

  @Override
  public UnaryCallable<ListTopicSnapshotsRequest, ListTopicSnapshotsPagedResponse>
      listTopicSnapshotsPagedCallable() {
    return listTopicSnapshotsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteTopicRequest, Empty> deleteTopicCallable() {
    return deleteTopicCallable;
  }

  @Override
  public UnaryCallable<DetachSubscriptionRequest, DetachSubscriptionResponse>
      detachSubscriptionCallable() {
    return detachSubscriptionCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
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
