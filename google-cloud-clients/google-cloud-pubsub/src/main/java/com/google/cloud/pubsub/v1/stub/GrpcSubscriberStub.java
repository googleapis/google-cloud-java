/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.pubsub.v1.stub;

import static com.google.cloud.pubsub.v1.SubscriptionAdminClient.ListSnapshotsPagedResponse;
import static com.google.cloud.pubsub.v1.SubscriptionAdminClient.ListSubscriptionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
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
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Google Cloud Pub/Sub API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcSubscriberStub extends SubscriberStub {

  private static final MethodDescriptor<Subscription, Subscription>
      createSubscriptionMethodDescriptor =
          MethodDescriptor.<Subscription, Subscription>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.Subscriber/CreateSubscription")
              .setRequestMarshaller(ProtoUtils.marshaller(Subscription.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Subscription.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetSubscriptionRequest, Subscription>
      getSubscriptionMethodDescriptor =
          MethodDescriptor.<GetSubscriptionRequest, Subscription>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.Subscriber/GetSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Subscription.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<UpdateSubscriptionRequest, Subscription>
      updateSubscriptionMethodDescriptor =
          MethodDescriptor.<UpdateSubscriptionRequest, Subscription>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.Subscriber/UpdateSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Subscription.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsMethodDescriptor =
          MethodDescriptor.<ListSubscriptionsRequest, ListSubscriptionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.Subscriber/ListSubscriptions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSubscriptionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSubscriptionsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeleteSubscriptionRequest, Empty>
      deleteSubscriptionMethodDescriptor =
          MethodDescriptor.<DeleteSubscriptionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.Subscriber/DeleteSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ModifyAckDeadlineRequest, Empty>
      modifyAckDeadlineMethodDescriptor =
          MethodDescriptor.<ModifyAckDeadlineRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.Subscriber/ModifyAckDeadline")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ModifyAckDeadlineRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<AcknowledgeRequest, Empty> acknowledgeMethodDescriptor =
      MethodDescriptor.<AcknowledgeRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.pubsub.v1.Subscriber/Acknowledge")
          .setRequestMarshaller(ProtoUtils.marshaller(AcknowledgeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<PullRequest, PullResponse> pullMethodDescriptor =
      MethodDescriptor.<PullRequest, PullResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.pubsub.v1.Subscriber/Pull")
          .setRequestMarshaller(ProtoUtils.marshaller(PullRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(PullResponse.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<StreamingPullRequest, StreamingPullResponse>
      streamingPullMethodDescriptor =
          MethodDescriptor.<StreamingPullRequest, StreamingPullResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName("google.pubsub.v1.Subscriber/StreamingPull")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StreamingPullRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StreamingPullResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ModifyPushConfigRequest, Empty>
      modifyPushConfigMethodDescriptor =
          MethodDescriptor.<ModifyPushConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.Subscriber/ModifyPushConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ModifyPushConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ListSnapshotsRequest, ListSnapshotsResponse>
      listSnapshotsMethodDescriptor =
          MethodDescriptor.<ListSnapshotsRequest, ListSnapshotsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.Subscriber/ListSnapshots")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSnapshotsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSnapshotsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<CreateSnapshotRequest, Snapshot>
      createSnapshotMethodDescriptor =
          MethodDescriptor.<CreateSnapshotRequest, Snapshot>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.Subscriber/CreateSnapshot")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Snapshot.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<UpdateSnapshotRequest, Snapshot>
      updateSnapshotMethodDescriptor =
          MethodDescriptor.<UpdateSnapshotRequest, Snapshot>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.Subscriber/UpdateSnapshot")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Snapshot.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeleteSnapshotRequest, Empty>
      deleteSnapshotMethodDescriptor =
          MethodDescriptor.<DeleteSnapshotRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.Subscriber/DeleteSnapshot")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<SeekRequest, SeekResponse> seekMethodDescriptor =
      MethodDescriptor.<SeekRequest, SeekResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.pubsub.v1.Subscriber/Seek")
          .setRequestMarshaller(ProtoUtils.marshaller(SeekRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(SeekResponse.getDefaultInstance()))
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

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSubscriberStub create(SubscriberStubSettings settings)
      throws IOException {
    return new GrpcSubscriberStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSubscriberStub create(ClientContext clientContext) throws IOException {
    return new GrpcSubscriberStub(SubscriberStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSubscriberStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSubscriberStub(
        SubscriberStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSubscriberStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSubscriberStub(SubscriberStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSubscriberCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSubscriberStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSubscriberStub(
      SubscriberStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    GrpcCallSettings<Subscription, Subscription> createSubscriptionTransportSettings =
        GrpcCallSettings.<Subscription, Subscription>newBuilder()
            .setMethodDescriptor(createSubscriptionMethodDescriptor)
            .build();
    GrpcCallSettings<GetSubscriptionRequest, Subscription> getSubscriptionTransportSettings =
        GrpcCallSettings.<GetSubscriptionRequest, Subscription>newBuilder()
            .setMethodDescriptor(getSubscriptionMethodDescriptor)
            .build();
    GrpcCallSettings<UpdateSubscriptionRequest, Subscription> updateSubscriptionTransportSettings =
        GrpcCallSettings.<UpdateSubscriptionRequest, Subscription>newBuilder()
            .setMethodDescriptor(updateSubscriptionMethodDescriptor)
            .build();
    GrpcCallSettings<ListSubscriptionsRequest, ListSubscriptionsResponse>
        listSubscriptionsTransportSettings =
            GrpcCallSettings.<ListSubscriptionsRequest, ListSubscriptionsResponse>newBuilder()
                .setMethodDescriptor(listSubscriptionsMethodDescriptor)
                .build();
    GrpcCallSettings<DeleteSubscriptionRequest, Empty> deleteSubscriptionTransportSettings =
        GrpcCallSettings.<DeleteSubscriptionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSubscriptionMethodDescriptor)
            .build();
    GrpcCallSettings<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineTransportSettings =
        GrpcCallSettings.<ModifyAckDeadlineRequest, Empty>newBuilder()
            .setMethodDescriptor(modifyAckDeadlineMethodDescriptor)
            .build();
    GrpcCallSettings<AcknowledgeRequest, Empty> acknowledgeTransportSettings =
        GrpcCallSettings.<AcknowledgeRequest, Empty>newBuilder()
            .setMethodDescriptor(acknowledgeMethodDescriptor)
            .build();
    GrpcCallSettings<PullRequest, PullResponse> pullTransportSettings =
        GrpcCallSettings.<PullRequest, PullResponse>newBuilder()
            .setMethodDescriptor(pullMethodDescriptor)
            .build();
    GrpcCallSettings<StreamingPullRequest, StreamingPullResponse> streamingPullTransportSettings =
        GrpcCallSettings.<StreamingPullRequest, StreamingPullResponse>newBuilder()
            .setMethodDescriptor(streamingPullMethodDescriptor)
            .build();
    GrpcCallSettings<ModifyPushConfigRequest, Empty> modifyPushConfigTransportSettings =
        GrpcCallSettings.<ModifyPushConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(modifyPushConfigMethodDescriptor)
            .build();
    GrpcCallSettings<ListSnapshotsRequest, ListSnapshotsResponse> listSnapshotsTransportSettings =
        GrpcCallSettings.<ListSnapshotsRequest, ListSnapshotsResponse>newBuilder()
            .setMethodDescriptor(listSnapshotsMethodDescriptor)
            .build();
    GrpcCallSettings<CreateSnapshotRequest, Snapshot> createSnapshotTransportSettings =
        GrpcCallSettings.<CreateSnapshotRequest, Snapshot>newBuilder()
            .setMethodDescriptor(createSnapshotMethodDescriptor)
            .build();
    GrpcCallSettings<UpdateSnapshotRequest, Snapshot> updateSnapshotTransportSettings =
        GrpcCallSettings.<UpdateSnapshotRequest, Snapshot>newBuilder()
            .setMethodDescriptor(updateSnapshotMethodDescriptor)
            .build();
    GrpcCallSettings<DeleteSnapshotRequest, Empty> deleteSnapshotTransportSettings =
        GrpcCallSettings.<DeleteSnapshotRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSnapshotMethodDescriptor)
            .build();
    GrpcCallSettings<SeekRequest, SeekResponse> seekTransportSettings =
        GrpcCallSettings.<SeekRequest, SeekResponse>newBuilder()
            .setMethodDescriptor(seekMethodDescriptor)
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .build();

    this.createSubscriptionCallable =
        callableFactory.createUnaryCallable(
            createSubscriptionTransportSettings,
            settings.createSubscriptionSettings(),
            clientContext);
    this.getSubscriptionCallable =
        callableFactory.createUnaryCallable(
            getSubscriptionTransportSettings, settings.getSubscriptionSettings(), clientContext);
    this.updateSubscriptionCallable =
        callableFactory.createUnaryCallable(
            updateSubscriptionTransportSettings,
            settings.updateSubscriptionSettings(),
            clientContext);
    this.listSubscriptionsCallable =
        callableFactory.createUnaryCallable(
            listSubscriptionsTransportSettings,
            settings.listSubscriptionsSettings(),
            clientContext);
    this.listSubscriptionsPagedCallable =
        callableFactory.createPagedCallable(
            listSubscriptionsTransportSettings,
            settings.listSubscriptionsSettings(),
            clientContext);
    this.deleteSubscriptionCallable =
        callableFactory.createUnaryCallable(
            deleteSubscriptionTransportSettings,
            settings.deleteSubscriptionSettings(),
            clientContext);
    this.modifyAckDeadlineCallable =
        callableFactory.createUnaryCallable(
            modifyAckDeadlineTransportSettings,
            settings.modifyAckDeadlineSettings(),
            clientContext);
    this.acknowledgeCallable =
        callableFactory.createUnaryCallable(
            acknowledgeTransportSettings, settings.acknowledgeSettings(), clientContext);
    this.pullCallable =
        callableFactory.createUnaryCallable(
            pullTransportSettings, settings.pullSettings(), clientContext);
    this.streamingPullCallable =
        callableFactory.createBidiStreamingCallable(
            streamingPullTransportSettings, settings.streamingPullSettings(), clientContext);
    this.modifyPushConfigCallable =
        callableFactory.createUnaryCallable(
            modifyPushConfigTransportSettings, settings.modifyPushConfigSettings(), clientContext);
    this.listSnapshotsCallable =
        callableFactory.createUnaryCallable(
            listSnapshotsTransportSettings, settings.listSnapshotsSettings(), clientContext);
    this.listSnapshotsPagedCallable =
        callableFactory.createPagedCallable(
            listSnapshotsTransportSettings, settings.listSnapshotsSettings(), clientContext);
    this.createSnapshotCallable =
        callableFactory.createUnaryCallable(
            createSnapshotTransportSettings, settings.createSnapshotSettings(), clientContext);
    this.updateSnapshotCallable =
        callableFactory.createUnaryCallable(
            updateSnapshotTransportSettings, settings.updateSnapshotSettings(), clientContext);
    this.deleteSnapshotCallable =
        callableFactory.createUnaryCallable(
            deleteSnapshotTransportSettings, settings.deleteSnapshotSettings(), clientContext);
    this.seekCallable =
        callableFactory.createUnaryCallable(
            seekTransportSettings, settings.seekSettings(), clientContext);
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
  public final void close() {
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
