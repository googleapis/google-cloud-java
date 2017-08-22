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

import static com.google.cloud.pubsub.v1.PagedResponseWrappers.ListSnapshotsPagedResponse;
import static com.google.cloud.pubsub.v1.PagedResponseWrappers.ListSubscriptionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.pubsub.v1.SubscriptionAdminSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.CreateSnapshotRequest;
import com.google.pubsub.v1.DeleteSnapshotRequest;
import com.google.pubsub.v1.DeleteSubscriptionRequest;
import com.google.pubsub.v1.GetSubscriptionRequest;
import com.google.pubsub.v1.ListSnapshotsRequest;
import com.google.pubsub.v1.ListSnapshotsResponse;
import com.google.pubsub.v1.ListSubscriptionsRequest;
import com.google.pubsub.v1.ListSubscriptionsResponse;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import com.google.pubsub.v1.ModifyPushConfigRequest;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.SeekRequest;
import com.google.pubsub.v1.SeekResponse;
import com.google.pubsub.v1.Snapshot;
import com.google.pubsub.v1.StreamingPullRequest;
import com.google.pubsub.v1.StreamingPullResponse;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.UpdateSnapshotRequest;
import com.google.pubsub.v1.UpdateSubscriptionRequest;
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
public class GrpcSubscriberStub extends SubscriberStub {
  private static final UnaryCallable<Subscription, Subscription> directCreateSubscriptionCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.pubsub.v1.Subscriber/CreateSubscription",
              io.grpc.protobuf.ProtoUtils.marshaller(Subscription.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Subscription.getDefaultInstance())));
  private static final UnaryCallable<GetSubscriptionRequest, Subscription>
      directGetSubscriptionCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.pubsub.v1.Subscriber/GetSubscription",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      GetSubscriptionRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(Subscription.getDefaultInstance())));
  private static final UnaryCallable<UpdateSubscriptionRequest, Subscription>
      directUpdateSubscriptionCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.pubsub.v1.Subscriber/UpdateSubscription",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      UpdateSubscriptionRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(Subscription.getDefaultInstance())));
  private static final UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      directListSubscriptionsCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.pubsub.v1.Subscriber/ListSubscriptions",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListSubscriptionsRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListSubscriptionsResponse.getDefaultInstance())));
  private static final UnaryCallable<DeleteSubscriptionRequest, Empty>
      directDeleteSubscriptionCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.pubsub.v1.Subscriber/DeleteSubscription",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      DeleteSubscriptionRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(Empty.getDefaultInstance())));
  private static final UnaryCallable<ModifyAckDeadlineRequest, Empty>
      directModifyAckDeadlineCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.pubsub.v1.Subscriber/ModifyAckDeadline",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ModifyAckDeadlineRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(Empty.getDefaultInstance())));
  private static final UnaryCallable<AcknowledgeRequest, Empty> directAcknowledgeCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.pubsub.v1.Subscriber/Acknowledge",
              io.grpc.protobuf.ProtoUtils.marshaller(AcknowledgeRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Empty.getDefaultInstance())));
  private static final UnaryCallable<PullRequest, PullResponse> directPullCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.pubsub.v1.Subscriber/Pull",
              io.grpc.protobuf.ProtoUtils.marshaller(PullRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(PullResponse.getDefaultInstance())));
  private static final BidiStreamingCallable<StreamingPullRequest, StreamingPullResponse>
      directStreamingPullCallable =
          GrpcCallableFactory.createDirectBidiStreamingCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
                  "google.pubsub.v1.Subscriber/StreamingPull",
                  io.grpc.protobuf.ProtoUtils.marshaller(StreamingPullRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      StreamingPullResponse.getDefaultInstance())));
  private static final UnaryCallable<ModifyPushConfigRequest, Empty>
      directModifyPushConfigCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.pubsub.v1.Subscriber/ModifyPushConfig",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ModifyPushConfigRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(Empty.getDefaultInstance())));
  private static final UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse>
      directListSnapshotsCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.pubsub.v1.Subscriber/ListSnapshots",
                  io.grpc.protobuf.ProtoUtils.marshaller(ListSnapshotsRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListSnapshotsResponse.getDefaultInstance())));
  private static final UnaryCallable<CreateSnapshotRequest, Snapshot> directCreateSnapshotCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.pubsub.v1.Subscriber/CreateSnapshot",
              io.grpc.protobuf.ProtoUtils.marshaller(CreateSnapshotRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Snapshot.getDefaultInstance())));
  private static final UnaryCallable<UpdateSnapshotRequest, Snapshot> directUpdateSnapshotCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.pubsub.v1.Subscriber/UpdateSnapshot",
              io.grpc.protobuf.ProtoUtils.marshaller(UpdateSnapshotRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Snapshot.getDefaultInstance())));
  private static final UnaryCallable<DeleteSnapshotRequest, Empty> directDeleteSnapshotCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.pubsub.v1.Subscriber/DeleteSnapshot",
              io.grpc.protobuf.ProtoUtils.marshaller(DeleteSnapshotRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Empty.getDefaultInstance())));
  private static final UnaryCallable<SeekRequest, SeekResponse> directSeekCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.pubsub.v1.Subscriber/Seek",
              io.grpc.protobuf.ProtoUtils.marshaller(SeekRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(SeekResponse.getDefaultInstance())));
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

  private final UnaryCallable<Subscription, Subscription> createSubscriptionCallable;
  private final UnaryCallable<GetSubscriptionRequest, Subscription> getSubscriptionCallable;
  private final UnaryCallable<UpdateSubscriptionRequest, Subscription> updateSubscriptionCallable;
  private final UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable;
  private final UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsPagedResponse>
      listSubscriptionsPagedCallable;
  private final UnaryCallable<DeleteSubscriptionRequest, Empty> deleteSubscriptionCallable;
  private final UnaryCallable<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineCallable;
  private final UnaryCallable<AcknowledgeRequest, Empty> acknowledgeCallable;
  private final UnaryCallable<PullRequest, PullResponse> pullCallable;
  private final BidiStreamingCallable<StreamingPullRequest, StreamingPullResponse>
      streamingPullCallable;
  private final UnaryCallable<ModifyPushConfigRequest, Empty> modifyPushConfigCallable;
  private final UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> listSnapshotsCallable;
  private final UnaryCallable<ListSnapshotsRequest, ListSnapshotsPagedResponse>
      listSnapshotsPagedCallable;
  private final UnaryCallable<CreateSnapshotRequest, Snapshot> createSnapshotCallable;
  private final UnaryCallable<UpdateSnapshotRequest, Snapshot> updateSnapshotCallable;
  private final UnaryCallable<DeleteSnapshotRequest, Empty> deleteSnapshotCallable;
  private final UnaryCallable<SeekRequest, SeekResponse> seekCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  public static final GrpcSubscriberStub create(SubscriptionAdminSettings settings)
      throws IOException {
    return new GrpcSubscriberStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSubscriberStub create(ClientContext clientContext) throws IOException {
    return new GrpcSubscriberStub(
        SubscriptionAdminSettings.defaultBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcSubscriberStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSubscriberStub(SubscriptionAdminSettings settings, ClientContext clientContext)
      throws IOException {

    this.createSubscriptionCallable =
        GrpcCallableFactory.create(
            directCreateSubscriptionCallable, settings.createSubscriptionSettings(), clientContext);
    this.getSubscriptionCallable =
        GrpcCallableFactory.create(
            directGetSubscriptionCallable, settings.getSubscriptionSettings(), clientContext);
    this.updateSubscriptionCallable =
        GrpcCallableFactory.create(
            directUpdateSubscriptionCallable, settings.updateSubscriptionSettings(), clientContext);
    this.listSubscriptionsCallable =
        GrpcCallableFactory.create(
            directListSubscriptionsCallable, settings.listSubscriptionsSettings(), clientContext);
    this.listSubscriptionsPagedCallable =
        GrpcCallableFactory.createPagedVariant(
            directListSubscriptionsCallable, settings.listSubscriptionsSettings(), clientContext);
    this.deleteSubscriptionCallable =
        GrpcCallableFactory.create(
            directDeleteSubscriptionCallable, settings.deleteSubscriptionSettings(), clientContext);
    this.modifyAckDeadlineCallable =
        GrpcCallableFactory.create(
            directModifyAckDeadlineCallable, settings.modifyAckDeadlineSettings(), clientContext);
    this.acknowledgeCallable =
        GrpcCallableFactory.create(
            directAcknowledgeCallable, settings.acknowledgeSettings(), clientContext);
    this.pullCallable =
        GrpcCallableFactory.create(directPullCallable, settings.pullSettings(), clientContext);
    this.streamingPullCallable =
        GrpcCallableFactory.create(
            directStreamingPullCallable, settings.streamingPullSettings(), clientContext);
    this.modifyPushConfigCallable =
        GrpcCallableFactory.create(
            directModifyPushConfigCallable, settings.modifyPushConfigSettings(), clientContext);
    this.listSnapshotsCallable =
        GrpcCallableFactory.create(
            directListSnapshotsCallable, settings.listSnapshotsSettings(), clientContext);
    this.listSnapshotsPagedCallable =
        GrpcCallableFactory.createPagedVariant(
            directListSnapshotsCallable, settings.listSnapshotsSettings(), clientContext);
    this.createSnapshotCallable =
        GrpcCallableFactory.create(
            directCreateSnapshotCallable, settings.createSnapshotSettings(), clientContext);
    this.updateSnapshotCallable =
        GrpcCallableFactory.create(
            directUpdateSnapshotCallable, settings.updateSnapshotSettings(), clientContext);
    this.deleteSnapshotCallable =
        GrpcCallableFactory.create(
            directDeleteSnapshotCallable, settings.deleteSnapshotSettings(), clientContext);
    this.seekCallable =
        GrpcCallableFactory.create(directSeekCallable, settings.seekSettings(), clientContext);
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

  public UnaryCallable<Subscription, Subscription> createSubscriptionCallable() {
    return createSubscriptionCallable;
  }

  public UnaryCallable<GetSubscriptionRequest, Subscription> getSubscriptionCallable() {
    return getSubscriptionCallable;
  }

  public UnaryCallable<UpdateSubscriptionRequest, Subscription> updateSubscriptionCallable() {
    return updateSubscriptionCallable;
  }

  public UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsPagedResponse>
      listSubscriptionsPagedCallable() {
    return listSubscriptionsPagedCallable;
  }

  public UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable() {
    return listSubscriptionsCallable;
  }

  public UnaryCallable<DeleteSubscriptionRequest, Empty> deleteSubscriptionCallable() {
    return deleteSubscriptionCallable;
  }

  public UnaryCallable<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineCallable() {
    return modifyAckDeadlineCallable;
  }

  public UnaryCallable<AcknowledgeRequest, Empty> acknowledgeCallable() {
    return acknowledgeCallable;
  }

  public UnaryCallable<PullRequest, PullResponse> pullCallable() {
    return pullCallable;
  }

  public BidiStreamingCallable<StreamingPullRequest, StreamingPullResponse>
      streamingPullCallable() {
    return streamingPullCallable;
  }

  public UnaryCallable<ModifyPushConfigRequest, Empty> modifyPushConfigCallable() {
    return modifyPushConfigCallable;
  }

  public UnaryCallable<ListSnapshotsRequest, ListSnapshotsPagedResponse>
      listSnapshotsPagedCallable() {
    return listSnapshotsPagedCallable;
  }

  public UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> listSnapshotsCallable() {
    return listSnapshotsCallable;
  }

  public UnaryCallable<CreateSnapshotRequest, Snapshot> createSnapshotCallable() {
    return createSnapshotCallable;
  }

  public UnaryCallable<UpdateSnapshotRequest, Snapshot> updateSnapshotCallable() {
    return updateSnapshotCallable;
  }

  public UnaryCallable<DeleteSnapshotRequest, Empty> deleteSnapshotCallable() {
    return deleteSnapshotCallable;
  }

  public UnaryCallable<SeekRequest, SeekResponse> seekCallable() {
    return seekCallable;
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
