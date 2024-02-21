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

import static com.google.cloud.pubsub.v1.SubscriptionAdminClient.ListSnapshotsPagedResponse;
import static com.google.cloud.pubsub.v1.SubscriptionAdminClient.ListSubscriptionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
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
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.CreateSnapshotRequest;
import com.google.pubsub.v1.DeleteSnapshotRequest;
import com.google.pubsub.v1.DeleteSubscriptionRequest;
import com.google.pubsub.v1.GetSnapshotRequest;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Subscriber service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
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

  private static final MethodDescriptor<GetSnapshotRequest, Snapshot> getSnapshotMethodDescriptor =
      MethodDescriptor.<GetSnapshotRequest, Snapshot>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.pubsub.v1.Subscriber/GetSnapshot")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSnapshotRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Snapshot.getDefaultInstance()))
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
  private final UnaryCallable<GetSnapshotRequest, Snapshot> getSnapshotCallable;
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

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
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
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<Subscription, Subscription> createSubscriptionTransportSettings =
        GrpcCallSettings.<Subscription, Subscription>newBuilder()
            .setMethodDescriptor(createSubscriptionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSubscriptionRequest, Subscription> getSubscriptionTransportSettings =
        GrpcCallSettings.<GetSubscriptionRequest, Subscription>newBuilder()
            .setMethodDescriptor(getSubscriptionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("subscription", String.valueOf(request.getSubscription()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSubscriptionRequest, Subscription> updateSubscriptionTransportSettings =
        GrpcCallSettings.<UpdateSubscriptionRequest, Subscription>newBuilder()
            .setMethodDescriptor(updateSubscriptionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "subscription.name", String.valueOf(request.getSubscription().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSubscriptionsRequest, ListSubscriptionsResponse>
        listSubscriptionsTransportSettings =
            GrpcCallSettings.<ListSubscriptionsRequest, ListSubscriptionsResponse>newBuilder()
                .setMethodDescriptor(listSubscriptionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteSubscriptionRequest, Empty> deleteSubscriptionTransportSettings =
        GrpcCallSettings.<DeleteSubscriptionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSubscriptionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("subscription", String.valueOf(request.getSubscription()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineTransportSettings =
        GrpcCallSettings.<ModifyAckDeadlineRequest, Empty>newBuilder()
            .setMethodDescriptor(modifyAckDeadlineMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("subscription", String.valueOf(request.getSubscription()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<AcknowledgeRequest, Empty> acknowledgeTransportSettings =
        GrpcCallSettings.<AcknowledgeRequest, Empty>newBuilder()
            .setMethodDescriptor(acknowledgeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("subscription", String.valueOf(request.getSubscription()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<PullRequest, PullResponse> pullTransportSettings =
        GrpcCallSettings.<PullRequest, PullResponse>newBuilder()
            .setMethodDescriptor(pullMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("subscription", String.valueOf(request.getSubscription()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<StreamingPullRequest, StreamingPullResponse> streamingPullTransportSettings =
        GrpcCallSettings.<StreamingPullRequest, StreamingPullResponse>newBuilder()
            .setMethodDescriptor(streamingPullMethodDescriptor)
            .build();
    GrpcCallSettings<ModifyPushConfigRequest, Empty> modifyPushConfigTransportSettings =
        GrpcCallSettings.<ModifyPushConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(modifyPushConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("subscription", String.valueOf(request.getSubscription()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSnapshotRequest, Snapshot> getSnapshotTransportSettings =
        GrpcCallSettings.<GetSnapshotRequest, Snapshot>newBuilder()
            .setMethodDescriptor(getSnapshotMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("snapshot", String.valueOf(request.getSnapshot()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSnapshotsRequest, ListSnapshotsResponse> listSnapshotsTransportSettings =
        GrpcCallSettings.<ListSnapshotsRequest, ListSnapshotsResponse>newBuilder()
            .setMethodDescriptor(listSnapshotsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateSnapshotRequest, Snapshot> createSnapshotTransportSettings =
        GrpcCallSettings.<CreateSnapshotRequest, Snapshot>newBuilder()
            .setMethodDescriptor(createSnapshotMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSnapshotRequest, Snapshot> updateSnapshotTransportSettings =
        GrpcCallSettings.<UpdateSnapshotRequest, Snapshot>newBuilder()
            .setMethodDescriptor(updateSnapshotMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("snapshot.name", String.valueOf(request.getSnapshot().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSnapshotRequest, Empty> deleteSnapshotTransportSettings =
        GrpcCallSettings.<DeleteSnapshotRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSnapshotMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("snapshot", String.valueOf(request.getSnapshot()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SeekRequest, SeekResponse> seekTransportSettings =
        GrpcCallSettings.<SeekRequest, SeekResponse>newBuilder()
            .setMethodDescriptor(seekMethodDescriptor)
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
    this.getSnapshotCallable =
        callableFactory.createUnaryCallable(
            getSnapshotTransportSettings, settings.getSnapshotSettings(), clientContext);
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<Subscription, Subscription> createSubscriptionCallable() {
    return createSubscriptionCallable;
  }

  @Override
  public UnaryCallable<GetSubscriptionRequest, Subscription> getSubscriptionCallable() {
    return getSubscriptionCallable;
  }

  @Override
  public UnaryCallable<UpdateSubscriptionRequest, Subscription> updateSubscriptionCallable() {
    return updateSubscriptionCallable;
  }

  @Override
  public UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable() {
    return listSubscriptionsCallable;
  }

  @Override
  public UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsPagedResponse>
      listSubscriptionsPagedCallable() {
    return listSubscriptionsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteSubscriptionRequest, Empty> deleteSubscriptionCallable() {
    return deleteSubscriptionCallable;
  }

  @Override
  public UnaryCallable<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineCallable() {
    return modifyAckDeadlineCallable;
  }

  @Override
  public UnaryCallable<AcknowledgeRequest, Empty> acknowledgeCallable() {
    return acknowledgeCallable;
  }

  @Override
  public UnaryCallable<PullRequest, PullResponse> pullCallable() {
    return pullCallable;
  }

  @Override
  public BidiStreamingCallable<StreamingPullRequest, StreamingPullResponse>
      streamingPullCallable() {
    return streamingPullCallable;
  }

  @Override
  public UnaryCallable<ModifyPushConfigRequest, Empty> modifyPushConfigCallable() {
    return modifyPushConfigCallable;
  }

  @Override
  public UnaryCallable<GetSnapshotRequest, Snapshot> getSnapshotCallable() {
    return getSnapshotCallable;
  }

  @Override
  public UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> listSnapshotsCallable() {
    return listSnapshotsCallable;
  }

  @Override
  public UnaryCallable<ListSnapshotsRequest, ListSnapshotsPagedResponse>
      listSnapshotsPagedCallable() {
    return listSnapshotsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateSnapshotRequest, Snapshot> createSnapshotCallable() {
    return createSnapshotCallable;
  }

  @Override
  public UnaryCallable<UpdateSnapshotRequest, Snapshot> updateSnapshotCallable() {
    return updateSnapshotCallable;
  }

  @Override
  public UnaryCallable<DeleteSnapshotRequest, Empty> deleteSnapshotCallable() {
    return deleteSnapshotCallable;
  }

  @Override
  public UnaryCallable<SeekRequest, SeekResponse> seekCallable() {
    return seekCallable;
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
